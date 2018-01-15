package nl.avans.logic.database;

import nl.avans.models.database.Profile;
import nl.avans.ui.controls.NetflixLabelDrop;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// to create or update a profile in the right way
public class ProfileSaver implements ActionListener {

    private NetflixLabelField profileNumber;
    private NetflixLabelDrop<Integer> subscriberNumber;
    private NetflixLabelField profileName;
    private NetflixLabelField birthDate;
    private NetflixList<String> list;
    private Database database;
    private Frame frame;

    public ProfileSaver(NetflixLabelField profileNumber, NetflixLabelDrop<Integer> subscriberNumber, NetflixLabelField profileName, NetflixLabelField birthDate, NetflixList<String> list, Database database, Frame frame) {
        this.profileNumber = profileNumber;
        this.subscriberNumber = subscriberNumber;
        this.profileName = profileName;
        this.birthDate = birthDate;
        this.list = list;
        this.database = database;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Create Account repository
        ProfileRepository profileRepository = new ProfileRepository(this.database);

        //Check if fields are correct
        String error = "";
        if (!this.profileNumber.getField().getText().matches("[1-9][0-9]{0,7}")) error += "- Profielnummer moet minder zijn dan 9999999 en meer dan 0\n";
        if (!this.profileName.getField().getText().matches("[a-zA-Z]{1,50}")) error += "- Profielnaam moet 50 of minder en 1 of meer letters hebben\n";
        if (!this.birthDate.getField().getText().matches("(0[1-9]|[12]\\d|3[01])-(0[1-9]|1[0-2])-([12]\\d{3})")) error += "- De geboortedatum voldoet niet aan de vereiste invoer\n";
        if (!error.equals("")){
            JOptionPane.showMessageDialog(frame, error,"Foute invoer", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Create Account according to fields
        Profile profile = new Profile(
                Integer.parseInt(this.profileNumber.getField().getText()),
                this.subscriberNumber.getReturnValue(),
                this.profileName.getField().getText(),
                this.birthDate.getField().getText()
        );

        //Check if we need to create or update
        if (this.list.getList().getSelectedIndex() == 0) {

            //Create, clear fields
            this.profileNumber.getField().setText("");
            this.subscriberNumber.getDropDown().setSelectedIndex(0);
            this.profileName.getField().setText("");
            this.birthDate.getField().setText("");

            //Save
            if (!profileRepository.create(profile)) {
                JOptionPane.showMessageDialog(frame, "- Ingevoerde profielnummer bestaat al\n","Foute invoer", JOptionPane.ERROR_MESSAGE);
            }

        } else {

            //Update
            profileRepository.update(profile);
        }

        //Update list
        DefaultListModel<String> dlm = this.list.getDefaultListModel();
        dlm.clear();
        dlm.addElement("-- Nieuw account aanmaken --");
        for (Profile updatedProfile : profileRepository.readAll())
            dlm.addElement(updatedProfile.getProfileNumber() + ": " + updatedProfile.getProfileName());
        this.list.getList().setSelectedIndex(0);
    }
}