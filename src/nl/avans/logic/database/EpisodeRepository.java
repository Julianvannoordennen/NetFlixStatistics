package nl.avans.logic.database;

import nl.avans.models.database.Episode;

import java.sql.ResultSet;
import java.util.ArrayList;

public class EpisodeRepository {
    private Database sqlConnection;

    public EpisodeRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Episode> readAll() {
        ArrayList<Episode> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Aflevering");
            while(rs.next()) {
                lijst.add(new Episode(rs.getInt("AfleveringId"),rs.getString("Serie"), rs.getString("Seizoen"), rs.getString("TitelAflevering"), rs.getTime("Tijdsduur")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Episode read(int episodeId) {
        Episode episode = null;
        try
        {
            String sqlQuery = "SELECT * FROM Aflevering WHERE AfleveringId=" + episodeId;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            episode = new Episode(rs.getInt("AfleveringId"),rs.getString("Serie"), rs.getString("Seizoen"), rs.getString("TitelAflevering"), rs.getTime("Tijdsduur"));
        }
        catch(Exception e) {
            if (!e.toString().contains("The result set has no current row."))
                System.out.println(e);
        }
        return episode;
    }

    public boolean create(Episode episode) {
        try
        {
            String sqlQuery = "INSERT INTO Aflevering VALUES (" + episode.getEpisodeId() + ", '" + episode.getSeries() + "', '" + episode.getSeason() + ", '" + episode.getTitleEpisode() + ", '" + episode.getDuration() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Episode episode) {
        if(episode==null) return false;
        return delete(episode.getEpisodeId());
    }

    public boolean delete(int episodeId) {
        try
        {
            String sqlQuery = "DELETE Aflevering WHERE AfleveringId=" + episodeId;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
