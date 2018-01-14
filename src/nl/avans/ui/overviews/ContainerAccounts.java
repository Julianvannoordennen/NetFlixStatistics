package nl.avans.ui.overviews;

import nl.avans.logic.database.AccountDeleter;
import nl.avans.logic.database.AccountSaver;
import nl.avans.logic.AccountSelector;
import nl.avans.logic.database.AccountRepository;
import nl.avans.logic.database.Database;
import nl.avans.models.database.Account;
import nl.avans.ui.ContainerContent;
import nl.avans.ui.controls.*;

public class ContainerAccounts extends ContainerContent {

    public ContainerAccounts(Database database) {
        super("Accounts", database);
        this.createComponents();
    }

    private void createComponents() {

        //Create serie selector label
        NetflixLabel accountLabel = new NetflixLabel("Kies één account");
        this.add(accountLabel);

        //Create serie selector
        NetflixList<String> listContent = new NetflixList<String>();
        this.add(listContent);

        //Create 'add user' and add existing users
        listContent.getDefaultListModel().addElement("-- Nieuw account aanmaken --");
        for (Account account : new AccountRepository(this.database).readAll())
            listContent.getDefaultListModel().addElement(account.getSubscriberNumber() + ": " + account.getName());

        //Create labels and fields
        NetflixLabelField subscriberNumber = new NetflixLabelField("Subscriber Number:   ", this);
        NetflixLabelField name = new NetflixLabelField("Name:   ", this);
        NetflixLabelField street = new NetflixLabelField("Street:   ", this);
        NetflixLabelField postalCode = new NetflixLabelField("Postalcode:   ", this);
        NetflixLabelField houseNumber = new NetflixLabelField("House Number:   ", this);
        NetflixLabelField city = new NetflixLabelField("City:   ", this);
        this.add(subscriberNumber);
        this.add(name);
        this.add(street);
        this.add(postalCode);
        this.add(houseNumber);
        this.add(city);

        //Create save and delete button
        NetflixSaveDelete saveDelete = new NetflixSaveDelete();
        this.add(saveDelete);

        //Create actions
        AccountSelector as = new AccountSelector(subscriberNumber,name,street,postalCode,houseNumber,city, listContent, this.database);
        listContent.getList().addListSelectionListener(as);
        listContent.getList().setSelectedIndex(0);

        AccountSaver saver = new AccountSaver(subscriberNumber,name,street,postalCode,houseNumber,city,listContent,this.database);
        saveDelete.getSave().addActionListener(saver);

        AccountDeleter deleter = new AccountDeleter(subscriberNumber, listContent,this.database);
        saveDelete.getDelete().addActionListener(deleter);
    }
}
