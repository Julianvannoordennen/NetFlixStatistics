package nl.avans.logic;

import nl.avans.logic.database.Database;
import nl.avans.logic.database.ProfileRepository;
import nl.avans.models.database.Profile;
import nl.avans.ui.controls.NetflixLabelDrop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//to select a specific profile
public class ProgressAccountSelector implements ActionListener {

    private NetflixLabelDrop<Integer> subscriberNumber;
    private NetflixLabelDrop<Integer> profileNumber;
    private Database database;

    public ProgressAccountSelector(NetflixLabelDrop<Integer> subscriberNumber, NetflixLabelDrop<Integer> profileNumber, Database database) {
        this.subscriberNumber = subscriberNumber;
        this.profileNumber = profileNumber;
        this.database = database;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Get selected subscriberNumber
        int number = this.subscriberNumber.getReturnValue();

        //List subscribers
        profileNumber.clearReturnValues();
        profileNumber.getDropDown().removeAllItems();
        for (Profile profile : new ProfileRepository(this.database).readAllBySubscriberNumber(number)) {
            profileNumber.getDropDown().addItem(profile.getProfileNumber() + ": " + profile.getProfileName());
            profileNumber.addReturnValue(profile.getProfileNumber());
        }
    }
}
