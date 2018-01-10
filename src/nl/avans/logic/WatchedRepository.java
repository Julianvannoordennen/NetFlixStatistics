package nl.avans.logic;

import nl.avans.models.Bekeken;

import java.sql.ResultSet;
import java.util.ArrayList;

public class WatchedRepository {
    private Database sqlConnection;

    public WatchedRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Bekeken> readAll() {
        ArrayList<Bekeken> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Bekeken");
            while(rs.next()) {
                lijst.add(new Bekeken(rs.getInt("AbonneeNummer"), rs.getString("GebruikersNaam"),rs.getInt("Gezien"), rs.getInt("Percentage")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Bekeken read(int abonneeNummer) {
        Bekeken bekeken= null;
        try
        {
            String sqlQuery = "SELECT * FROM Bekeken WHERE AbonneeNummer=" + abonneeNummer;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            bekeken = new Bekeken(rs.getInt("AbonneeNummer"), rs.getString("GebruikersNaam"),rs.getInt("Gezien"), rs.getInt("Percentage"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return bekeken;
    }

    public boolean create(Bekeken bekeken) {
        try
        {
            String sqlQuery = "INSERT INTO Bekeken VALUES (" + bekeken.getAbonneeNummer() + ", '" + bekeken.getGebruikersNaam() + "', '" + bekeken.getGezien() + ", '" + bekeken.getPercentage() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Bekeken bekeken) {
        if(bekeken==null) return false;
        return delete(bekeken.getAbonneeNummer());
    }

    public boolean delete(int abonneeNummer) {
        try
        {
            String sqlQuery = "DELETE Bekeken WHERE AbonneeNummer=" + abonneeNummer;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
