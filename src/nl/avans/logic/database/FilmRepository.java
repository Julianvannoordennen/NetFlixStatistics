package nl.avans.logic.database;

import nl.avans.models.database.Film;

import java.sql.ResultSet;
import java.util.ArrayList;

// to create, update or delete film
public class FilmRepository {
    private Database sqlConnection;

    public FilmRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    // list of all films
    public ArrayList<Film> readAll() {
        ArrayList<Film> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Film");
            while(rs.next()) {
                lijst.add(new Film(rs.getInt("FilmId"),rs.getString("Titel"), rs.getString("LeeftijdsIndicatie"), rs.getString("Taal"), rs.getTime("Tijdsduur"), rs.getString("Genre")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }
    //Check what films have been watched by a specific subscriber
    public ArrayList<Film> readByAccount(int subscriberNumber) {
        ArrayList<Film> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT Film.FilmId, Titel, LeeftijdsIndicatie, Taal, Tijdsduur, Genre FROM Film JOIN Bekeken ON Film.FilmId = Bekeken.Gezien WHERE Bekeken.AbonneeNummer=" + subscriberNumber);
            while(rs.next()) {
                lijst.add(new Film(rs.getInt("FilmId"),rs.getString("Titel"), rs.getString("LeeftijdsIndicatie"), rs.getString("Taal"), rs.getTime("Tijdsduur"), rs.getString("Genre")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Film read(int filmId) {
        Film film= null;
        try
        {
            String sqlQuery = "SELECT * FROM Film WHERE Film.FilmId=" + filmId;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            film = new Film(rs.getInt("FilmId"),rs.getString("Titel"), rs.getString("LeeftijdsIndicatie"), rs.getString("Taal"), rs.getTime("Tijdsduur"), rs.getString("Genre"));
        }
        catch(Exception e) {
            if (!e.toString().contains("The result set has no current row."))
                System.out.println(e);
        }
        return film;
    }
    // longest film for people under 16
    public Film readLongestTimeYoungerThan16() {
        Film film= null;
        try
        {
            String sqlQuery = "SELECT TOP 1 * FROM Film WHERE Film.LeeftijdsIndicatie LIKE ('12%') OR Film.LeeftijdsIndicatie LIKE ('6%') ORDER BY Film.Tijdsduur DESC";
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            film = new Film(rs.getInt("FilmId"),rs.getString("Titel"), rs.getString("LeeftijdsIndicatie"), rs.getString("Taal"), rs.getTime("Tijdsduur"), rs.getString("Genre"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return film;
    }
    //create a film
    public boolean create(Film film) {
        try
        {
            String sqlQuery = "INSERT INTO Film VALUES (" + film.getFilmId() + ", '" + film.getTitle() + "', '" + film.getAgeRange() + ", '" + film.getLanguage() + ", '" + film.getDuration() + ", '" + film.getGenre() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
    // delete a film
    public boolean delete(Film film) {
        if(film==null) return false;
        return delete(film.getFilmId());
    }

    public boolean delete(int filmId) {
        try
        {
            String sqlQuery = "DELETE Film WHERE FilmId=" + filmId;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
