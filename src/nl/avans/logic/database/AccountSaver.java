package nl.avans.logic.database;

import nl.avans.logic.database.AccountRepository;
import nl.avans.logic.database.Database;
import nl.avans.models.database.Account;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//to make an account the right way
public class AccountSaver implements ActionListener {

    private NetflixLabelField subscriberNumber;
    private NetflixLabelField name;
    private NetflixLabelField street;
    private NetflixLabelField postalCode;
    private NetflixLabelField houseNumber;
    private NetflixLabelField city;
    private NetflixList<String> list;
    private Database database;
    private Frame frame;

    public AccountSaver(NetflixLabelField subscriberNumber, NetflixLabelField name, NetflixLabelField street, NetflixLabelField postalCode, NetflixLabelField houseNumber, NetflixLabelField city, NetflixList<String> list, Database database, Frame frame) {
        this.subscriberNumber = subscriberNumber;
        this.name = name;
        this.street = street;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.city = city;
        this.list = list;
        this.database = database;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Check if fields are correct
        String error = "";
        if (!this.subscriberNumber.getField().getText().matches("[0-9]{7}")) error += "- Subscriptienummer moet zeven tekens bevatten\n";
        if (this.name.getField().getText().length() < 2 || this.name.getField().getText().length() > 50) error += "- Naam moet minimaal twee en maximaal 50 letters bevatten, geen cijfers\n";
        if (this.street.getField().getText().length() < 2 || this.street.getField().getText().length() > 50) error += "- Straat moet minimaal twee en maximaal 50 letters bevatten, geen cijfers\n";
        if (!this.postalCode.getField().getText().matches("[1-9][0-9]{3}[A-Z]{2}")) error += "- Postcode moet uit het volgende formaat bestaan: '1000AA'\n";
        if (!this.houseNumber.getField().getText().matches("[1-9][0-9]{1,3}")) error += "- Het huisnummer moet hoger dan nul en lager dan 10.000 zijn\n";
        if (this.city.getField().getText().length() < 2 || this.city.getField().getText().length() > 50) error += "- Stad moet minimaal twee en maximaal 50 letters bevatten, geen cijfers\n";
        if (!error.equals("")) {
            JOptionPane.showMessageDialog(frame, error,"Foute invoer", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Create Account according to fields
        Account account = new Account(
                Integer.parseInt(this.subscriberNumber.getField().getText()),
                this.name.getField().getText(),
                this.street.getField().getText(),
                this.postalCode.getField().getText(),
                Integer.parseInt(this.houseNumber.getField().getText()),
                this.city.getField().getText()
        );

        //Create Account repository
        AccountRepository accountRepository = new AccountRepository(this.database);

        //Check if we need to create or update
        if (this.list.getList().getSelectedIndex() == 0) {

            //Create, clear fields
            this.subscriberNumber.getField().setText("");
            this.name.getField().setText("");
            this.street.getField().setText("");
            this.postalCode.getField().setText("");
            this.houseNumber.getField().setText("");
            this.city.getField().setText("");

            //Save
            accountRepository.create(account);

        } else {

            //Update
            accountRepository.update(account);
        }

        //Update list
        DefaultListModel<String> dlm = this.list.getDefaultListModel();
        dlm.clear();
        dlm.addElement("-- Nieuw account aanmaken --");
        for (Account updatedAccount : accountRepository.readAll())
            dlm.addElement(updatedAccount.getSubscriberNumber() + ": " + updatedAccount.getName());
        this.list.getList().setSelectedIndex(0);
    }
}
