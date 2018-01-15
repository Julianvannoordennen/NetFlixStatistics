package nl.avans.ui.overviews;

import nl.avans.logic.database.AccountRepository;
import nl.avans.logic.database.Database;
import nl.avans.models.database.Account;
import nl.avans.ui.ContainerContent;
import nl.avans.ui.controls.NetflixLabel;
import nl.avans.ui.controls.NetflixList;

// accounts with only 1 profile
public class ContainerSmallAccounts extends ContainerContent {

    private NetflixList<String> listContent;

    public ContainerSmallAccounts(Database database) {

        //Add title and database
        super("Accounts met één profiel", database);

        //Create controls
        this.createComponents();
    }

    @Override
    protected void createComponents() {

        //Create percentage overview
        this.listContent = new NetflixList<String>();
        this.add(this.listContent);

        //Load accounts with 1 profile
        for (Account account : new AccountRepository(this.database).readAccountsWithOneProfile())
            this.listContent.getDefaultListModel().addElement(account.getSubscriberNumber() + ": " + account.getName());
    }
}
