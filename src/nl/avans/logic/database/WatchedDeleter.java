package nl.avans.logic.database;

import nl.avans.models.database.Watched;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WatchedDeleter implements ActionListener {

    private NetflixLabelField subscriberNumber;
    private NetflixLabelField profileNumber;
    private NetflixLabelField watched;
    private NetflixList<String> list;
    private Database database;

    public WatchedDeleter(NetflixLabelField subscriberNumber, NetflixLabelField profileNumber, NetflixLabelField watched, NetflixList<String> list, Database database) {
        this.subscriberNumber = subscriberNumber;
        this.profileNumber = profileNumber;
        this.watched = watched;
        this.list = list;
        this.database = database;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Create Account repository
        WatchedRepository watchedRepository = new WatchedRepository(this.database);

        //Delete current
        watchedRepository.delete(Integer.parseInt(this.subscriberNumber.getField().getText()),Integer.parseInt(this.profileNumber.getField().getText()),Integer.parseInt(this.watched.getField().getText()));

        //Update list
        DefaultListModel<String> dlm = this.list.getDefaultListModel();
        dlm.clear();
        dlm.addElement("-- Nieuwe progressie aanmaken --");
        for (Watched updatedWatched : watchedRepository.readAll())
            dlm.addElement(updatedWatched.getSubscriberNumber() + ": ," + updatedWatched.getProfileNumber() + ": ," + updatedWatched.getWatched() + ": ," + updatedWatched.getPercentage());
        this.list.getList().setSelectedIndex(0);
    }
}