package nl.avans.logic.database;

import nl.avans.models.database.Profile;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileSaver implements ActionListener {

    private NetflixLabelField profileNumber;
    private NetflixLabelField subscriberNumber;
    private NetflixLabelField profileName;
    private NetflixLabelField birthDate;
    private NetflixList<String> list;
    private Database database;

    public ProfileSaver(NetflixLabelField profileNumber, NetflixLabelField subscriberNumber, NetflixLabelField profileName, NetflixLabelField birthDate, NetflixList<String> list, Database database) {
        this.profileNumber = profileNumber;
        this.subscriberNumber = subscriberNumber;
        this.profileName = profileName;
        this.birthDate = birthDate;
        this.list = list;
        this.database = database;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Create Account repository
        ProfileRepository profileRepository = new ProfileRepository(this.database);

        //Create Account according to fields
        Profile profile = new Profile(
                Integer.parseInt(this.profileNumber.getField().getText()),
                Integer.parseInt(this.subscriberNumber.getField().getText()),
                this.profileName.getField().getText(),
                this.birthDate.getField().getText()
        );

        if (!this.profileNumber.getField().getText().matches("[0-9]")
                || !this.subscriberNumber.getField().getText().matches("[0-9]{7}")
                || !this.profileName.getField().getText().matches("[a-zA-Z]{1,50}")
                || !this.birthDate.getField().getText().matches("([0-2][0-9])|(30|31)-(0[0-9])|(10|11|12)-[0-9]{4}")) {
            System.out.println("The input values are incorrect.");
        }

        //Check if we need to create or update
        if (this.list.getList().getSelectedIndex() == 0) {

            //Create, clear fields
            this.profileNumber.getField().setText("");
            this.subscriberNumber.getField().setText("");
            this.profileName.getField().setText("");
            this.birthDate.getField().setText("");

        } else {

            //Update, delete current but keep fields
            profileRepository.delete(profile);
        }

        //Save
        profileRepository.create(profile);

        //Update list
        DefaultListModel<String> dlm = this.list.getDefaultListModel();
        dlm.clear();
        dlm.addElement("-- Nieuw account aanmaken --");
        for (Profile updatedProfile : profileRepository.readAll())
            dlm.addElement(updatedProfile.getProfileNumber() + ": " + updatedProfile.getProfileName());
        this.list.getList().setSelectedIndex(0);
    }
}