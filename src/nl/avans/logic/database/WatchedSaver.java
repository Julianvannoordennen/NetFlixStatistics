package nl.avans.logic.database;


import nl.avans.models.database.Watched;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WatchedSaver implements ActionListener {

    private NetflixLabelField subscriberNumber;
    private NetflixLabelField profileNumber;
    private NetflixLabelField watched;
    private NetflixLabelField percentage;
    private NetflixList<String> list;
    private Database database;

    public WatchedSaver(NetflixLabelField subscriberNumber, NetflixLabelField profileNumber, NetflixLabelField watched, NetflixLabelField percentage, NetflixList<String> list, Database database) {
        this.subscriberNumber = subscriberNumber;
        this.profileNumber = profileNumber;
        this.watched = watched;
        this.percentage = percentage;
        this.list = list;
        this.database = database;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Create Account repository
        WatchedRepository watchedRepository = new WatchedRepository(this.database);

        //Create Account according to fields
        Watched watched = new Watched(
                Integer.parseInt(this.subscriberNumber.getField().getText()),
                Integer.parseInt(this.profileNumber.getField().getText()),
                Integer.parseInt(this.watched.getField().getText()),
                Integer.parseInt(this.percentage.getField().getText())
        );

        //Check if we need to create or update
        if (this.list.getList().getSelectedIndex() == 0) {

            //Create, clear fields
            this.subscriberNumber.getField().setText("");
            this.profileNumber.getField().setText("");
            this.watched.getField().setText("");
            this.percentage.getField().setText("");

        } else {

            //Update, delete current but keep fields
            watchedRepository.delete(watched);
        }

        //Save
        watchedRepository.create(watched);

        //Update list
        DefaultListModel<String> dlm = this.list.getDefaultListModel();
        dlm.clear();
        dlm.addElement("-- Nieuwe progressie aanmaken --");
        for (Watched updatedWatched : watchedRepository.readAll())
            dlm.addElement(updatedWatched.getSubscriberNumber() + ": ," + updatedWatched.getProfileNumber() + ": ," + updatedWatched.getWatched() + ": ," + updatedWatched.getPercentage());
        this.list.getList().setSelectedIndex(0);
    }
}
