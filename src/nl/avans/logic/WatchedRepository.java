package nl.avans.logic;

import nl.avans.models.Watched;

import java.sql.ResultSet;
import java.util.ArrayList;

public class WatchedRepository {
    private Database sqlConnection;

    public WatchedRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Watched> readAll() {
        ArrayList<Watched> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Bekeken");
            while(rs.next()) {
                lijst.add(new Watched(rs.getInt("AbonneeNummer"), rs.getString("GebruikersNaam"),rs.getInt("Gezien"), rs.getInt("Percentage")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Watched read(int subscriberNumber) {
        Watched watched= null;
        try
        {
            String sqlQuery = "SELECT * FROM Bekeken WHERE AbonneeNummer=" + subscriberNumber;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            watched = new Watched(rs.getInt("AbonneeNummer"), rs.getString("GebruikersNaam"),rs.getInt("Gezien"), rs.getInt("Percentage"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return watched;
    }

    public boolean create(Watched watched) {
        try
        {
            String sqlQuery = "INSERT INTO Bekeken VALUES (" + watched.getSubscriberNumber() + ", '" + watched.getUsername() + "', '" + watched.getWatched() + ", '" + watched.getPercentage() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Watched watched) {
        if(watched==null) return false;
        return delete(watched.getSubscriberNumber());
    }

    public boolean delete(int subscriberNumber) {
        try
        {
            String sqlQuery = "DELETE Bekeken WHERE AbonneeNummer=" + subscriberNumber;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
