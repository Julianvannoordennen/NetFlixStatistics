package nl.avans.logic;

import nl.avans.logic.database.Database;
import nl.avans.logic.database.ProfileRepository;
import nl.avans.models.database.Profile;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ProfileSelector implements ListSelectionListener {

    private NetflixLabelField profileNumber;
    private NetflixLabelField subscriberNumber;
    private NetflixLabelField profileName;
    private NetflixLabelField birthDate;
    private NetflixList<String> list;
    private Database database;

    public ProfileSelector(NetflixLabelField profileNumber, NetflixLabelField subscriberNumber, NetflixLabelField profileName, NetflixLabelField birthDate, NetflixList<String> list, Database database) {
        this.profileNumber = profileNumber;
        this.subscriberNumber = subscriberNumber;
        this.profileName = profileName;
        this.birthDate = birthDate;
        this.list = list;
        this.database = database;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        //Get selected index
        int selectedNumber = this.list.getList().getSelectedIndex();

        //Get selected item, in case the user did not select '-- Nieuw account aanmaken --'
        Profile selectedProfile = new Profile(0,0,"","");
        if (selectedNumber > 0) {
            selectedNumber--;
            selectedProfile = new ProfileRepository(this.database).readAll().get(selectedNumber);
            this.profileNumber.getField().setEditable(false);
        } else {
            this.profileNumber.getField().setEditable(true);
        }

        //Add selected item to fields
        this.profileNumber.getField().setText(selectedProfile.getProfileNumber() + "");
        this.subscriberNumber.getField().setText(selectedProfile.getSubscriberNumber() + "");
        this.profileName.getField().setText(selectedProfile.getProfileName());
        this.birthDate.getField().setText(selectedProfile.getBirthDate());
    }
}
