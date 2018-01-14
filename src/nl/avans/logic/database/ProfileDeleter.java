package nl.avans.logic.database;

import nl.avans.models.database.Profile;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileDeleter implements ActionListener {

    private NetflixLabelField profileNumber;
    private NetflixList<String> list;
    private Database database;

    public ProfileDeleter(NetflixLabelField profileNumber, NetflixList<String> list, Database database) {
        this.profileNumber = profileNumber;
        this.list = list;
        this.database = database;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Create profile repository
        ProfileRepository profileRepository = new ProfileRepository(this.database);

        //Delete current
        profileRepository.delete(Integer.parseInt(this.profileNumber.getField().getText()));

        //Update list
        DefaultListModel<String> dlm = this.list.getDefaultListModel();
        dlm.clear();
        dlm.addElement("-- Nieuw profiel aanmaken --");
        for (Profile updatedProfile : profileRepository.readAll())
            dlm.addElement(updatedProfile.getProfileNumber() + ": " + updatedProfile.getProfileName());
        this.list.getList().setSelectedIndex(0);
    }
}