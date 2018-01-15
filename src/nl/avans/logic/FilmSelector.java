package nl.avans.logic;

import nl.avans.logic.database.Database;
import nl.avans.logic.database.FilmRepository;
import nl.avans.logic.database.ProfileRepository;
import nl.avans.logic.database.WatchedRepository;
import nl.avans.models.database.Film;
import nl.avans.models.database.Profile;
import nl.avans.models.database.Watched;
import nl.avans.ui.controls.NetflixComboBox;
import nl.avans.ui.controls.NetflixList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilmSelector implements ActionListener {

    private NetflixComboBox<String> filmSelector;
    private NetflixList<String> listContent;
    private Database database;

    public FilmSelector(NetflixComboBox<String> filmSelector, NetflixList<String> listContent, Database database) {
        this.filmSelector = filmSelector;
        this.listContent = listContent;
        this.database = database;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Clear all items in list
        this.listContent.getDefaultListModel().clear();

        //Get account and data
        int selectedNumber = this.filmSelector.getSelectedIndex();
        Film film = new FilmRepository(this.database).readAll().get(selectedNumber);

        //Show films
        for (Profile profile : new ProfileRepository(this.database).readFullyWatchedByFilm(film.getFilmId())) {
            this.listContent.getDefaultListModel().addElement(profile.getProfileNumber() + ": " + profile.getProfileName());
        }
    }
}
