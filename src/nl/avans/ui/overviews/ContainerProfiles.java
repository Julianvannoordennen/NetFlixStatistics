package nl.avans.ui.overviews;

import nl.avans.logic.ProfileSelector;
import nl.avans.logic.database.*;
import nl.avans.models.database.Account;
import nl.avans.models.database.Profile;
import nl.avans.ui.ContainerContent;
import nl.avans.ui.controls.*;

public class ContainerProfiles extends ContainerContent {

    public ContainerProfiles(Database database) {
        super("Profielen", database);
        this.createComponents();
    }

    @Override
    protected void createComponents() {

        //Create profile selector label
        NetflixLabel profileLabel = new NetflixLabel("Kies één profiel");
        this.add(profileLabel);

        //Create profile selector
        NetflixList<String> listContent = new NetflixList<String>();
        this.add(listContent);

        //Create 'add profile' and add existing profiles
        listContent.getDefaultListModel().addElement("-- Nieuw profiel aanmaken --");
        for (Profile profile : new ProfileRepository(this.database).readAll())
            listContent.getDefaultListModel().addElement(profile.getProfileNumber() + ": " + profile.getProfileName());

        //Create labels and fields
        NetflixLabelField profileNumber = new NetflixLabelField("Profielnummer:   ", this);
        NetflixLabelDrop<Integer> subscriberNumber = new NetflixLabelDrop<Integer>("Subscriptienummer:   ", this);
        NetflixLabelField profileName = new NetflixLabelField("Profielnaam:   ", this);
        NetflixLabelField birthDate = new NetflixLabelField("Geboortedatum:   ", this);
        this.add(profileNumber);
        this.add(subscriberNumber);
        this.add(profileName);
        this.add(birthDate);

        //Load LabelDrop data
        for (Account account : new AccountRepository(this.database).readAll()) {
            subscriberNumber.getDropDown().addItem(account.getSubscriberNumber() + ": " + account.getName());
            subscriberNumber.addReturnValue(account.getSubscriberNumber());
        }

        //Create save and delete button
        NetflixSaveDelete saveDelete = new NetflixSaveDelete();
        this.add(saveDelete);

        //Create actions
        ProfileSelector profileSelector = new ProfileSelector(profileNumber, subscriberNumber, profileName, birthDate, listContent, this.database);
        listContent.getList().addListSelectionListener(profileSelector);
        listContent.getList().setSelectedIndex(0);

        ProfileSaver saver = new ProfileSaver(profileNumber, subscriberNumber, profileName, birthDate,listContent,this.database);
        saveDelete.getSave().addActionListener(saver);

        ProfileDeleter deleter = new ProfileDeleter(profileNumber, listContent,this.database);
        saveDelete.getDelete().addActionListener(deleter);
    }
}
