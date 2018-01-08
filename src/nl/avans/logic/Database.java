package nl.avans.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

    private Connection connection = null;

    //Constructors
    public Database() {}
    public Database(String connectionUrl) {
        this.connectDatabase(connectionUrl);
    }

    //Connect to the database
    public boolean connectDatabase(String connectionUrl) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(connectionUrl);
        }
        catch(Exception e)
        {
            System.out.println(e);
            connection=null;
            return false;
        }
        return true;
    }

    //Disconnect from the database
    public void disconnectDatabase() {
        if (connection != null) {
            try {
                connection.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }
            connection=null;
        }
    }

    //Execute a query
    public ResultSet executeSql(String sqlQuery) {
        ResultSet rs = null;
        try
        {
            Statement statement = this.connection.createStatement();
            rs = statement.executeQuery(sqlQuery);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return rs;
    }

    //Execute a query without resultset
    public boolean executeSqlNoResult(String sqlQuery) {
        try
        {
            Statement statement = this.connection.createStatement();
            return statement.execute(sqlQuery);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }


    /*
    public ResultSet execute(String query) {

        // Dit zijn de instellingen voor de verbinding. Vervang de databaseName indien deze voor jou anders is.
        String hostName = "netflixstatistics.database.windows.net";
        String dbName = "NetflixStatistix";
        String user = "NetflixStatistics";
        String password = "Netflix$tatistics";
        String connectionUrl = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);

        // Connection beheert informatie over de connectie met de database.
        Connection con = null;

        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;

        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        ResultSet rs = null;

        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            // Stel een SQL query samen.
            stmt = con.createStatement();

            // Voer de query uit op de database.
            rs = stmt.executeQuery(query);
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }

        return rs;
    }*/
}
