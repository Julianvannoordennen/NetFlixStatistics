package nl.avans.logic;

import nl.avans.logic.database.AccountRepository;
import nl.avans.logic.database.Database;
import nl.avans.logic.database.ProfileRepository;
import nl.avans.models.database.Account;
import nl.avans.models.database.Profile;
import nl.avans.ui.controls.NetflixLabelDrop;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// Meant to select or make changes to a profile.
public class ProfileSelector implements ListSelectionListener {

    private NetflixLabelField profileNumber;
    private NetflixLabelDrop subscriberNumber;
    private NetflixLabelField profileName;
    private NetflixLabelField birthDate;
    private NetflixList<String> list;
    private Database database;

    public ProfileSelector(NetflixLabelField profileNumber, NetflixLabelDrop subscriberNumber, NetflixLabelField profileName, NetflixLabelField birthDate, NetflixList<String> list, Database database) {
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

        //Get selected item, in case the user did not select '-- Nieuw profiel aanmaken --'
        Profile selectedProfile = new Profile(0,0,"","");
        if (selectedNumber > 0) {
            selectedNumber--;
            selectedProfile = new ProfileRepository(this.database).readAll().get(selectedNumber);
            this.profileNumber.getField().setEditable(false);
            this.subscriberNumber.getDropDown().setEnabled(false);
        } else {
            this.profileNumber.getField().setEditable(true);
            this.subscriberNumber.getDropDown().setEnabled(true);
        }

        //Add selected item to fields
        this.profileNumber.getField().setText(selectedProfile.getProfileNumber() + "");
        this.profileName.getField().setText(selectedProfile.getProfileName());
        this.birthDate.getField().setText(selectedProfile.getBirthDate());

        //Set dropdown
        if (selectedProfile.getSubscriberNumber() > 0) {
            Account account = new AccountRepository(this.database).read(selectedProfile.getSubscriberNumber());
            String subscriberNumberItemText = account.getSubscriberNumber() + ": " + account.getName();
            this.subscriberNumber.getDropDown().setSelectedItem(subscriberNumberItemText);
        }
    }
}
