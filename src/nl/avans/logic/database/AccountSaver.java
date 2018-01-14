package nl.avans.logic.database;

import nl.avans.logic.database.AccountRepository;
import nl.avans.logic.database.Database;
import nl.avans.models.database.Account;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccountSaver implements ActionListener {

    private NetflixLabelField subscriberNumber;
    private NetflixLabelField name;
    private NetflixLabelField street;
    private NetflixLabelField postalCode;
    private NetflixLabelField houseNumber;
    private NetflixLabelField city;
    private NetflixList<String> list;
    private Database database;

    public AccountSaver(NetflixLabelField subscriberNumber, NetflixLabelField name, NetflixLabelField street, NetflixLabelField postalCode, NetflixLabelField houseNumber, NetflixLabelField city, NetflixList<String> list, Database database) {
        this.subscriberNumber = subscriberNumber;
        this.name = name;
        this.street = street;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.city = city;
        this.list = list;
        this.database = database;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Create Account repository
        AccountRepository accountRepository = new AccountRepository(this.database);

        //Create Account according to fields
        Account account = new Account(
                Integer.parseInt(this.subscriberNumber.getField().getText()),
                this.name.getField().getText(),
                this.street.getField().getText(),
                this.postalCode.getField().getText(),
                Integer.parseInt(this.houseNumber.getField().getText()),
                this.city.getField().getText()
        );

        if (!this.subscriberNumber.getField().getText().matches("[0-9]{7}")
                || !this.name.getField().getText().matches("[a-zA-Z\\.]{3,50}")
                || !this.street.getField().getText().matches("[a-zA-Z]{3,50}")
                || !this.postalCode.getField().getText().matches("[1-9][0-9]{3}[A-Z]{2}")
                || !this.city.getField().getText().matches("[a-zA-Z]{1,60}")) {
            System.out.println("The input values are incorrect.");
        }

        return;

        //Check if we need to create or update
        if (this.list.getList().getSelectedIndex() == 0) {

            //Create, clear fields
            this.subscriberNumber.getField().setText("");
            this.name.getField().setText("");
            this.street.getField().setText("");
            this.postalCode.getField().setText("");
            this.houseNumber.getField().setText("");
            this.city.getField().setText("");

        } else {

            //Update, delete current but keep fields
            accountRepository.delete(account);
        }

        //Save
        accountRepository.create(account);

        //Update list
        DefaultListModel<String> dlm = this.list.getDefaultListModel();
        dlm.clear();
        dlm.addElement("-- Nieuw account aanmaken --");
        for (Account updatedAccount : accountRepository.readAll())
            dlm.addElement(updatedAccount.getSubscriberNumber() + ": " + updatedAccount.getName());
        this.list.getList().setSelectedIndex(0);
    }
}
