package nl.avans.logic;

import java.sql.ResultSet;
import java.util.ArrayList;

public class FilmRepository {
    private Database sqlConnection;

    public FilmRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

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

    public Film read(int filmId) {
        Film film= null;
        try
        {
            String sqlQuery = "SELECT * FROM Film WHERE FilmId=" + filmId;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            film = new Film(rs.getInt("FilmId"),rs.getString("Titel"), rs.getString("LeeftijdsIndicatie"), rs.getString("Taal"), rs.getTime("Tijdsduur"), rs.getString("Genre"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return film;
    }

    public boolean create(Film film) {
        try
        {
            String sqlQuery = "INSERT INTO Film VALUES (" + film.getFilmId() + ", '" + film.getTitel() + "', '" + film.getLeeftijdsIndicatie() + ", '" + film.getTaal() + ", '" + film.getTijdsduur() + ", '" + film.getGenre() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

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
