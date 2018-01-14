package nl.avans.logic.database;

import nl.avans.logic.database.AccountRepository;
import nl.avans.logic.database.Database;
import nl.avans.models.database.Account;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountDeleter implements ActionListener {

    private NetflixLabelField subscriberNumber;
    private NetflixList<String> list;
    private Database database;

    public AccountDeleter(NetflixLabelField subscriberNumber, NetflixList<String> list, Database database) {
        this.subscriberNumber = subscriberNumber;
        this.list = list;
        this.database = database;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Create Account repository
        AccountRepository accountRepository = new AccountRepository(this.database);

        //Delete current but keep fields
        accountRepository.delete(Integer.parseInt(this.subscriberNumber.getField().getText()));

        //Update list
        DefaultListModel<String> dlm = this.list.getDefaultListModel();
        dlm.clear();
        dlm.addElement("-- Nieuw account aanmaken --");
        for (Account updatedAccount : accountRepository.readAll())
            dlm.addElement(updatedAccount.getSubscriberNumber() + ": " + updatedAccount.getName());
        this.list.getList().setSelectedIndex(0);
    }
}