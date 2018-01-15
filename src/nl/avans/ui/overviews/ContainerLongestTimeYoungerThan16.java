package nl.avans.ui.overviews;

import nl.avans.logic.database.Database;
import nl.avans.logic.database.FilmRepository;
import nl.avans.models.database.Film;
import nl.avans.ui.ContainerContent;
import nl.avans.ui.controls.NetflixLabelField;

public class ContainerLongestTimeYoungerThan16 extends ContainerContent {

    public ContainerLongestTimeYoungerThan16(Database database) {

        //Add title and database
        super("Langste film voor onder de zestien", database);

        //Create controls
        this.createComponents();
    }

    private void createComponents() {

        //Create labels and fields
        NetflixLabelField filmId = new NetflixLabelField("FilmId:   ", this);
        NetflixLabelField title = new NetflixLabelField("Titel:   ", this);
        NetflixLabelField ageRange = new NetflixLabelField("Leeftijdsindicatie:   ", this);
        NetflixLabelField language = new NetflixLabelField("Taal:   ", this);
        NetflixLabelField duration = new NetflixLabelField("Tijdsduur:   ", this);
        NetflixLabelField genre = new NetflixLabelField("Genre:   ", this);

        //Load longest movie for under 16
        Film film = new FilmRepository(this.database).readLongestTimeYoungerThan16();

        //View data
        filmId.getField().setText(film.getFilmId() + "");
        title.getField().setText(film.getTitle());
        ageRange.getField().setText(film.getAgeRange());
        language.getField().setText(film.getLanguage());
        duration.getField().setText(film.getDuration() + "");
        genre.getField().setText(film.getGenre());
    }
}
