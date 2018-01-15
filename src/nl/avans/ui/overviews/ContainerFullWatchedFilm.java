package nl.avans.ui.overviews;

import nl.avans.logic.FilmSelector;
import nl.avans.logic.database.Database;
import nl.avans.logic.database.FilmRepository;
import nl.avans.models.database.Film;
import nl.avans.ui.ContainerContent;
import nl.avans.ui.controls.NetflixComboBox;
import nl.avans.ui.controls.NetflixLabel;
import nl.avans.ui.controls.NetflixList;

public class ContainerFullWatchedFilm extends ContainerContent {

    public ContainerFullWatchedFilm(Database database) {

        //Add title and database
        super("Volledige kijkers per film", database);

        //Create controls
        this.createComponents();
    }

    @Override
    protected void createComponents() {

        //Create serie selector label
        NetflixLabel accountLabel = new NetflixLabel("Kies één film");
        this.add(accountLabel);

        //Create serie selector and add all series
        NetflixComboBox<String> filmSelector = new NetflixComboBox<String>();
        this.add(filmSelector);
        for (Film film : new FilmRepository(this.database).readAll())
            filmSelector.addItem(film.getFilmId() + ": " + film.getTitle());

        //Create percentage overview label
        NetflixLabel percentagesLabel = new NetflixLabel("Kijkers welke de film volledig hebben bekeken");
        this.add(percentagesLabel);

        //Create percentage overview
        NetflixList<String> listContent = new NetflixList<String>();
        this.add(listContent);

        //Create actions
        FilmSelector filmAccountSelector = new FilmSelector(filmSelector, listContent, this.database);
        filmSelector.addActionListener(filmAccountSelector);
        filmSelector.setSelectedIndex(0);
    }
}