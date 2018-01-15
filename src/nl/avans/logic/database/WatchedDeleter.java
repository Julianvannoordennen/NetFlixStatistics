package nl.avans.logic.database;

import nl.avans.models.database.Watched;
import nl.avans.ui.controls.NetflixLabelDrop;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WatchedDeleter implements ActionListener {

    private NetflixLabelDrop<Integer> subscriberNumber;
    private NetflixLabelDrop<Integer> profileNumber;
    private NetflixLabelDrop<Integer> watched;
    private NetflixList<String> list;
    private Database database;

    public WatchedDeleter(NetflixLabelDrop<Integer> subscriberNumber, NetflixLabelDrop<Integer> profileNumber, NetflixLabelDrop<Integer> watched, NetflixList<String> list, Database database) {
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
        watchedRepository.delete(this.subscriberNumber.getReturnValue(),this.profileNumber.getReturnValue(),this.watched.getReturnValue());

        //Update list
        DefaultListModel<String> dlm = this.list.getDefaultListModel();
        dlm.clear();
        dlm.addElement("-- Nieuwe progressie aanmaken --");
        for (Watched updatedWatched : watchedRepository.readAll())
            dlm.addElement(updatedWatched.getSubscriberNumber() + ": ," + updatedWatched.getProfileNumber() + ": ," + updatedWatched.getWatched() + ": ," + updatedWatched.getPercentage());
        this.list.getList().setSelectedIndex(0);
    }
}