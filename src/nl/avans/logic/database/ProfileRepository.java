package nl.avans.logic.database;

import nl.avans.models.database.Profile;

import java.sql.ResultSet;
import java.util.ArrayList;

//To take data out of a profiles and use it to connect to other data
public class ProfileRepository {
    private Database sqlConnection;

    // a list of profiles
    public ProfileRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Profile> readAll() {
        ArrayList<Profile> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Profiel");
            while(rs.next()) {
                lijst.add(new Profile(rs.getInt("Profielnummer"),rs.getInt("Abonneenummer"),rs.getString("Profielnaam"), rs.getString("Geboortedatum")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }
    //A list of films that have been fully watched by a subscriber
    public ArrayList<Profile> readFullyWatchedByFilm(int filmId) {
        ArrayList<Profile> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT Profiel.ProfielNummer, Profiel.Abonneenummer, Profiel.Profielnaam, Profiel.Geboortedatum FROM Film JOIN Bekeken ON Film.FilmId = Bekeken.Gezien JOIN Profiel ON Bekeken.ProfielNummer = Profiel.ProfielNummer WHERE Percentage=100 AND Film.FilmId=" + filmId);
            while(rs.next()) {
                lijst.add(new Profile(rs.getInt("Profielnummer"),rs.getInt("Abonneenummer"),rs.getString("Profielnaam"), rs.getString("Geboortedatum")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }
    //information about a specific subscriber
    public ArrayList<Profile> readAllBySubscriberNumber(int subscriberNumber) {
        ArrayList<Profile> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Profiel WHERE Abonneenummer=" + subscriberNumber);
            while(rs.next()) {
                lijst.add(new Profile(rs.getInt("Profielnummer"),rs.getInt("Abonneenummer"),rs.getString("Profielnaam"), rs.getString("Geboortedatum")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Profile read(int profileNumber) {
        Profile profile= null;
        try
        {
            String sqlQuery = "SELECT * FROM Profiel WHERE ProfielNummer=" + profileNumber;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            profile = new Profile(rs.getInt("Profielnummer"),rs.getInt("Abonneenummer"),rs.getString("Profielnaam"), rs.getString("Geboortedatum"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return profile;
    }
    // used to create a new profile
    public boolean create(Profile profile) {
        try
        {
            String sqlQuery = "INSERT INTO Profiel VALUES (" + profile.getProfileNumber() + ", " + profile.getSubscriberNumber() + ", '" + profile.getProfileName() + "', '" + profile.getBirthDate() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
    // used to change a profile
    public boolean update(Profile profile) {
        try
        {
            String sqlQuery = "UPDATE Profiel SET Profielnaam='" + profile.getProfileName() + "', Geboortedatum='" + profile.getBirthDate() + "' WHERE ProfielNummer=" + profile.getProfileNumber() + " AND Abonneenummer=" + profile.getSubscriberNumber();
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
    // for deleting a profile
    public boolean delete(Profile profile) {
        if(profile==null) return false;
        return delete(profile.getProfileNumber());
    }

    public boolean delete(int profileNumber) {
        try
        {
            String sqlQuery = "DELETE Profiel WHERE Profielnummer=" + profileNumber;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
