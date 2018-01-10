package nl.avans.logic;

import nl.avans.models.Profiel;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfileRepository {
    private Database sqlConnection;

    public ProfileRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Profiel> readAll() {
        ArrayList<Profiel> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Profiel");
            while(rs.next()) {
                lijst.add(new Profiel(rs.getInt("Abonneenummer"),rs.getString("Profielnaam"), rs.getString("Geboortedatum")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Profiel read(int abonneenummer) {
        Profiel profiel = null;
        try
        {
            String sqlQuery = "SELECT * FROM Profiel WHERE Abonneenummer=" + abonneenummer;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            profiel = new Profiel(rs.getInt("Abonneenummer"),rs.getString("Profielnaam"), rs.getString("Geboortedatum"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return profiel;
    }

    public boolean create(Profiel profiel) {
        try
        {
            String sqlQuery = "INSERT INTO Profiel VALUES (" + profiel.getAbonneenummer() + ", '" + profiel.getProfielnaam() + "', '" + profiel.getGeboortedatum() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Profiel profiel) {
        if(profiel==null) return false;
        return delete(profiel.getAbonneenummer());
    }

    public boolean delete(int abonneenummer) {
        try
        {
            String sqlQuery = "DELETE Profiel WHERE Abonneenummer=" + abonneenummer;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
