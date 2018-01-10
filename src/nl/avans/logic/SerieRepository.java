package nl.avans.logic;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SerieRepository {
    private Database sqlConnection;

    public SerieRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Serie> readAll() {
        ArrayList<Serie> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Serie");
            while(rs.next()) {
                lijst.add(new Serie(rs.getString("Serie"),rs.getString("Seizoen"), rs.getString("Leeftijd"), rs.getString("Taal"), rs.getString("Genre"), rs.getString("LijktOP")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Serie read(String seizoen) {
        Serie serie = null;
        try
        {
            String sqlQuery = "SELECT * FROM Serie WHERE Serie=" + seizoen;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            serie = new Serie(rs.getString("Serie"),rs.getString("Seizoen"), rs.getString("Leeftijd"), rs.getString("Taal"), rs.getString("Genre"), rs.getString("LijktOP"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return serie;
    }

    public boolean create(Serie serie) {
        try
        {
            String sqlQuery = "INSERT INTO Serie VALUES (" + serie.getSerie() + ", '" + serie.getSeizoen() + "', '" + serie.getLeeftijd() + ", '" + serie.getTaal() + ", '" + serie.getGenre() + ", '" + serie.getLijktOP() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Serie serie) {
        if(serie==null) return false;
        return delete(serie.getSerie());
    }

    public boolean delete(String serie) {
        try
        {
            String sqlQuery = "DELETE Serie WHERE Serie=" + serie;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
