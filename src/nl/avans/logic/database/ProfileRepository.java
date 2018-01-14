package nl.avans.logic.database;

import nl.avans.models.database.Profile;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfileRepository {
    private Database sqlConnection;

    public ProfileRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Profile> readAll() {
        ArrayList<Profile> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Profiel");
            while(rs.next()) {
                lijst.add(new Profile(rs.getInt("Abonneenummer"),rs.getString("Profielnaam"), rs.getString("Geboortedatum")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Profile read(int subscriberNumber) {
        Profile profile= null;
        try
        {
            String sqlQuery = "SELECT * FROM Profiel WHERE Abonneenummer=" + subscriberNumber;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            profile = new Profile(rs.getInt("Abonneenummer"),rs.getString("Profielnaam"), rs.getString("Geboortedatum"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return profile;
    }

    public boolean create(Profile profile) {
        try
        {
            String sqlQuery = "INSERT INTO Profiel VALUES (" + profile.getSubscriberNumber() + ", '" + profile.getProfileName() + "', '" + profile.getBirthDate() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Profile profile) {
        if(profile==null) return false;
        return delete(profile.getSubscriberNumber());
    }

    public boolean delete(int subscriberNumber) {
        try
        {
            String sqlQuery = "DELETE Profiel WHERE Abonneenummer=" + subscriberNumber;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
