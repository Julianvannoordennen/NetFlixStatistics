package nl.avans.ui.overviews;

import nl.avans.logic.database.AccountDeleter;
import nl.avans.logic.database.AccountSaver;
import nl.avans.logic.AccountSelector;
import nl.avans.logic.database.AccountRepository;
import nl.avans.logic.database.Database;
import nl.avans.models.database.Account;
import nl.avans.ui.ContainerContent;
import nl.avans.ui.controls.*;
import java.awt.*;

//The accountpage layout

public class ContainerAccounts extends ContainerContent {

    private Frame frame;

    public ContainerAccounts(Database database, Frame frame) {
        super("Accounts", database);
        this.frame = frame;
        this.createComponents();
    }

    @Override
    protected void createComponents() {

        //Create account selector label
        NetflixLabel accountLabel = new NetflixLabel("Kies één account");
        this.add(accountLabel);

        //Create account selector
        NetflixList<String> listContent = new NetflixList<String>();
        this.add(listContent);

        //Create 'add user' and add existing users
        listContent.getDefaultListModel().addElement("-- Nieuw account aanmaken --");
        for (Account account : new AccountRepository(this.database).readAll())
            listContent.getDefaultListModel().addElement(account.getSubscriberNumber() + ": " + account.getName());

        //Create labels and fields
        NetflixLabelField subscriberNumber = new NetflixLabelField("Subscriptienummer:   ", this);
        NetflixLabelField name = new NetflixLabelField("Naam:   ", this);
        NetflixLabelField street = new NetflixLabelField("Straat:   ", this);
        NetflixLabelField postalCode = new NetflixLabelField("Postcode:   ", this);
        NetflixLabelField houseNumber = new NetflixLabelField("Huisnummer:   ", this);
        NetflixLabelField city = new NetflixLabelField("Stad:   ", this);
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
        AccountSelector accountSelector = new AccountSelector(subscriberNumber,name,street,postalCode,houseNumber,city, listContent, this.database);
        listContent.getList().addListSelectionListener(accountSelector);
        listContent.getList().setSelectedIndex(0);

        AccountSaver saver = new AccountSaver(subscriberNumber,name,street,postalCode,houseNumber,city,listContent,this.database, frame);
        saveDelete.getSave().addActionListener(saver);

        AccountDeleter deleter = new AccountDeleter(subscriberNumber, listContent,this.database);
        saveDelete.getDelete().addActionListener(deleter);
    }
}
