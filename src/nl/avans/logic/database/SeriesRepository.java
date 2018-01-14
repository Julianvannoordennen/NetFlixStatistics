package nl.avans.logic.database;

import nl.avans.models.database.Series;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SeriesRepository {
    private Database sqlConnection;

    public SeriesRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Series> readAll() {
        ArrayList<Series> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Serie");
            while(rs.next()) {
                lijst.add(new Series(rs.getString("Serie"),rs.getString("Seizoen"), rs.getString("Leeftijd"), rs.getString("Taal"), rs.getString("Genre"), rs.getString("LijktOP")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Series read(String season) {
        Series series = null;
        try
        {
            String sqlQuery = "SELECT * FROM Serie WHERE Serie=" + season;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            series = new Series(rs.getString("Serie"),rs.getString("Seizoen"), rs.getString("Leeftijd"), rs.getString("Taal"), rs.getString("Genre"), rs.getString("LijktOP"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return series;
    }

    public boolean create(Series series) {
        try
        {
            String sqlQuery = "INSERT INTO Serie VALUES (" + series.getSeries() + ", '" + series.getSeason() + "', '" + series.getAge() + ", '" + series.getLanguage() + ", '" + series.getGenre() + ", '" + series.getResembles() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Series series) {
        if(series==null) return false;
        return delete(series.getSeries());
    }

    public boolean delete(String series) {
        try
        {
            String sqlQuery = "DELETE Serie WHERE Serie=" + series;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
