package nl.avans.logic;

import nl.avans.models.Aflevering;

import java.sql.ResultSet;
import java.util.ArrayList;

public class EpisodeRepository {
    private Database sqlConnection;

    public EpisodeRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Aflevering> readAll() {
        ArrayList<Aflevering> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Aflevering");
            while(rs.next()) {
                lijst.add(new Aflevering(rs.getInt("AfleveringId"),rs.getString("Serie"), rs.getString("Seizoen"), rs.getString("TitelAflevering"), rs.getTime("Tijdsduur")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Aflevering read(int afleveringId) {
        Aflevering aflevering = null;
        try
        {
            String sqlQuery = "SELECT * FROM Aflevering WHERE AfleveringId=" + afleveringId;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            aflevering = new Aflevering(rs.getInt("AfleveringId"),rs.getString("Serie"), rs.getString("Seizoen"), rs.getString("TitelAflevering"), rs.getTime("Tijdsduur"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return aflevering;
    }

    public boolean create(Aflevering aflevering) {
        try
        {
            String sqlQuery = "INSERT INTO Aflevering VALUES (" + aflevering.getAfleveringId() + ", '" + aflevering.getSerie() + "', '" + aflevering.getSeizoen() + ", '" + aflevering.getTitelAflevering() + ", '" + aflevering.getTijdsduur() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Aflevering aflevering) {
        if(aflevering==null) return false;
        return delete(aflevering.getAfleveringId());
    }

    public boolean delete(int afleveringId) {
        try
        {
            String sqlQuery = "DELETE Aflevering WHERE AfleveringId=" + afleveringId;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
