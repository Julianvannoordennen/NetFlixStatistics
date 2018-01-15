package nl.avans.ui.overviews;

import nl.avans.logic.FilmAccountSelector;
import nl.avans.logic.database.AccountRepository;
import nl.avans.logic.database.Database;
import nl.avans.models.database.Account;
import nl.avans.ui.ContainerContent;
import nl.avans.ui.controls.NetflixComboBox;
import nl.avans.ui.controls.NetflixLabel;
import nl.avans.ui.controls.NetflixList;

public class ContainerWatchedFilms extends ContainerContent {

    public ContainerWatchedFilms(Database database) {

        //Add title and database
        super("Films bekeken door accounts", database);

        //Create controls
        this.createComponents();
    }

    @Override
    protected void createComponents() {

        //Create serie selector label
        NetflixLabel accountLabel = new NetflixLabel("Kies één account");
        this.add(accountLabel);

        //Create serie selector and add all series
        NetflixComboBox<String> accountSelector = new NetflixComboBox<String>();
        this.add(accountSelector);
        for (Account account : new AccountRepository(this.database).readAll())
            accountSelector.addItem(account.getName());

        //Create percentage overview label
        NetflixLabel percentagesLabel = new NetflixLabel("Bekeken films");
        this.add(percentagesLabel);

        //Create percentage overview
        NetflixList<String> listContent = new NetflixList<String>();
        this.add(listContent);

        //Create actions
        FilmAccountSelector filmAccountSelector = new FilmAccountSelector(accountSelector, listContent, this.database);
        accountSelector.addActionListener(filmAccountSelector);
        accountSelector.setSelectedIndex(0);
    }
}
