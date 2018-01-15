package nl.avans.logic.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void testConnectDatabaseWithValidConnectionURLReturnsTrue() {

        //Arange
        Database database = new Database();

        //Act
        Boolean result = database.connectDatabase(String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                "netflixstatistics.database.windows.net", "NetflixStatistix", "NetflixStatistics", "Netflix$tatistics"));

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    void testConnectDatabaseWithInvalidConnectionURLReturnsFalse() {

        //Arange
        Database database = new Database();

        //Act
        Boolean result = database.connectDatabase(String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                "netflixstatistics.database.windows.net", "abc", "def", "ghi"));

        //Assert
        Assertions.assertFalse(result);
    }

    @Test
    void testExecuteSqlWithValidQueryReturnsTrue() {

        //Arange
        Database database = new Database();

        //Act
        database.connectDatabase(String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                "netflixstatistics.database.windows.net", "NetflixStatistix", "NetflixStatistics", "Netflix$tatistics"));

        ResultSet rs = database.executeSql("SELECT * FROM Film");

        //Assert
        Assertions.assertTrue(rs != null);
    }

    @Test
    void testExecuteSqlWithInvalidQueryReturnsFalse() {

        //Arange
        Database database = new Database();

        //Act
        database.connectDatabase(String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                "netflixstatistics.database.windows.net", "NetflixStatistix", "NetflixStatistics", "Netflix$tatistics"));

        ResultSet rs = database.executeSql("SELECT * FROM Boek");

        //Assert
        Assertions.assertFalse(rs != null);
    }
}