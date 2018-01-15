package nl.avans.logic.database;


import nl.avans.models.database.Watched;
import nl.avans.ui.controls.NetflixLabelDrop;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// to add a new watched film/series
public class WatchedSaver implements ActionListener {

    private NetflixLabelDrop<Integer> subscriberNumber;
    private NetflixLabelDrop<Integer> profileNumber;
    private NetflixLabelDrop<Integer> watched;
    private NetflixLabelField percentage;
    private NetflixList<String> list;
    private Database database;
    private Frame frame;

    public WatchedSaver(NetflixLabelDrop<Integer> subscriberNumber, NetflixLabelDrop<Integer> profileNumber, NetflixLabelDrop<Integer> watched, NetflixLabelField percentage, NetflixList<String> list, Database database, Frame frame) {
        this.subscriberNumber = subscriberNumber;
        this.profileNumber = profileNumber;
        this.watched = watched;
        this.percentage = percentage;
        this.list = list;
        this.database = database;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Check if field is correct
        Boolean error = false;
        try {
            Integer percentage = Integer.parseInt(this.percentage.getField().getText());
            error = percentage < 1 || percentage > 100;
        } catch (Exception ex) {error = true;}
        if (error) {
            JOptionPane.showMessageDialog(frame, "- Het percentage moet binnen 1 en 100 zitten\n","Foute invoer", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Create Account repository
        WatchedRepository watchedRepository = new WatchedRepository(this.database);

        //Create Account according to fields
        Watched watched = new Watched(
                this.subscriberNumber.getReturnValue(),
                this.profileNumber.getReturnValue(),
                this.watched.getReturnValue(),
                Integer.parseInt(this.percentage.getField().getText())
        );

        //Check if we need to create or update
        if (this.list.getList().getSelectedIndex() == 0) {

            //Create, clear fields
            this.subscriberNumber.getDropDown().setSelectedIndex(0);
            this.profileNumber.getDropDown().setSelectedIndex(0);
            this.watched.getDropDown().setSelectedIndex(0);
            this.percentage.getField().setText("");

            //Save
            watchedRepository.create(watched);

        } else {

            //Update
            watchedRepository.update(watched);
        }


        //Update list
        DefaultListModel<String> dlm = this.list.getDefaultListModel();
        dlm.clear();
        dlm.addElement("-- Nieuwe progressie aanmaken --");
        for (Watched updatedWatched : watchedRepository.readAll())
            dlm.addElement(updatedWatched.getSubscriberNumber() + ": ," + updatedWatched.getProfileNumber() + ": ," + updatedWatched.getWatched() + ": ," + updatedWatched.getPercentage());
        this.list.getList().setSelectedIndex(0);
    }
}
