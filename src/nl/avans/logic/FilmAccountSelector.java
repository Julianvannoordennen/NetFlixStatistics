package nl.avans.logic;

import nl.avans.logic.database.AccountRepository;
import nl.avans.logic.database.Database;
import nl.avans.logic.database.FilmRepository;
import nl.avans.models.database.Account;
import nl.avans.models.database.Film;
import nl.avans.ui.controls.NetflixComboBox;
import nl.avans.ui.controls.NetflixList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilmAccountSelector implements ActionListener {

    private NetflixComboBox<String> accountSelector;
    private NetflixList<String> listContent;
    private Database database;

    public FilmAccountSelector(NetflixComboBox<String> accountSelector, NetflixList<String> listContent, Database database) {
        this.accountSelector = accountSelector;
        this.listContent = listContent;
        this.database = database;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Clear all items in list
        this.listContent.getDefaultListModel().clear();

        //Get account and data
        int selectedNumber = this.accountSelector.getSelectedIndex();
        Account account = new AccountRepository(this.database).readAll().get(selectedNumber);

        //Show films
        for (Film film : new FilmRepository(this.database).readByAccount(account.getSubscriberNumber())) {
            this.listContent.getDefaultListModel().addElement(film.getFilmId() + ": " + film.getTitle());
        }

    }
}
