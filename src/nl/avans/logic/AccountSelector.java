package nl.avans.logic;

        import nl.avans.logic.database.AccountRepository;
        import nl.avans.logic.database.Database;
        import nl.avans.models.database.Account;
        import nl.avans.ui.controls.NetflixLabelField;
        import nl.avans.ui.controls.NetflixList;

        import javax.swing.*;
        import javax.swing.event.ListSelectionEvent;
        import javax.swing.event.ListSelectionListener;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.ArrayList;

public class AccountSelector implements ListSelectionListener {

    private NetflixLabelField subscriberNumber;
    private NetflixLabelField name;
    private NetflixLabelField street;
    private NetflixLabelField postalCode;
    private NetflixLabelField houseNumber;
    private NetflixLabelField city;
    private NetflixList<String> list;
    private Database database;

    public AccountSelector(NetflixLabelField subscriberNumber, NetflixLabelField name, NetflixLabelField street, NetflixLabelField postalCode, NetflixLabelField houseNumber, NetflixLabelField city, NetflixList<String> list, Database database) {
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
    public void valueChanged(ListSelectionEvent e) {

        //Get selected index
        int selectedNumber = this.list.getList().getSelectedIndex();

        //Get selected item, in case the user did not select '-- Nieuw account aanmaken --'
        Account selectedAccount = new Account(0,"","","",0,"");
        if (selectedNumber > 0) {
            selectedNumber--;
            selectedAccount = new AccountRepository(this.database).readAll().get(selectedNumber);
            this.subscriberNumber.getField().setEditable(false);
        } else {
            this.subscriberNumber.getField().setEditable(true);
        }

        //Add selected item to fields
        this.subscriberNumber.getField().setText(selectedAccount.getSubscriberNumber() + "");
        this.name.getField().setText(selectedAccount.getName());
        this.street.getField().setText(selectedAccount.getStreet());
        this.postalCode.getField().setText(selectedAccount.getPostalCode());
        this.houseNumber.getField().setText(selectedAccount.getHouseNumber() + "");
        this.city.getField().setText(selectedAccount.getCity());
    }
}
