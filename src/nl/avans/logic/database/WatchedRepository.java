package nl.avans.logic.database;

import nl.avans.models.database.Episode;
import nl.avans.models.database.Profile;
import nl.avans.models.database.Watched;

import java.sql.ResultSet;
import java.util.ArrayList;

// All parts that need to be noted about a 'watched' show
public class WatchedRepository {
    private Database sqlConnection;

    public WatchedRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    // A list with all watched shows
    public ArrayList<Watched> readAll() {
        ArrayList<Watched> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Bekeken");
            while(rs.next()) {
                lijst.add(new Watched(rs.getInt("AbonneeNummer"), rs.getInt("ProfielNummer"),rs.getInt("Gezien"), rs.getInt("Percentage")));
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
            watched = new Watched(rs.getInt("AbonneeNummer"), rs.getInt("ProfielNummer"),rs.getInt("Gezien"), rs.getInt("Percentage"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return watched;
    }
    // To add a watched show
    public boolean create(Watched watched) {
        try
        {
            String sqlQuery = "INSERT INTO Bekeken VALUES (" + watched.getSubscriberNumber() + ", " + watched.getWatched() + ", " + watched.getPercentage() + ", " + watched.getProfileNumber() + ")";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
    //How far a show has been watched on average
    public ResultSet readAvgAccountAndSerie(String account, String serie) {
        ArrayList<ResultSet> lijst = new ArrayList<>();
        try {
            if (account.equals("0")) {
                return sqlConnection.executeSql("SELECT AfleveringId, AVG(Percentage) as Percentage, Aflevering.TitelAflevering FROM Bekeken INNER JOIN Aflevering ON Bekeken.Gezien = Aflevering.AfleveringId WHERE Serie='" + serie + "' GROUP BY AfleveringId, Aflevering.TitelAflevering");
            } else {
                return sqlConnection.executeSql("SELECT AfleveringId, AVG(Percentage) as Percentage, Aflevering.TitelAflevering FROM Aflevering INNER JOIN Bekeken ON Aflevering.AfleveringId = Bekeken.Gezien WHERE Serie = '" + serie + "' AND AbonneeNummer = " + account + " GROUP BY AfleveringId, AbonneeNummer, Aflevering.TitelAflevering");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    //to update what has been watched
    public boolean update(Watched watched) {
        try
        {
            String sqlQuery = "UPDATE Bekeken SET Percentage=" + watched.getPercentage() + " WHERE Gezien=" + watched.getWatched() + " AND Abonneenummer=" + watched.getSubscriberNumber() + " AND ProfielNummer=" + watched.getProfileNumber();
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Watched watched) {
        if(watched==null) return false;
        return delete(watched.getSubscriberNumber(), watched.getProfileNumber(), watched.getWatched());
    }

    public boolean delete(int subscriberNumber, int profileNumber, int watched) {
        try
        {
            String sqlQuery = "DELETE Bekeken WHERE AbonneeNummer=" + subscriberNumber + " AND ProfielNummer=" + profileNumber + " AND Gezien=" + watched;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
