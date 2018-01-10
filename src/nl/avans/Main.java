package nl.avans;

import nl.avans.logic.Database;
import nl.avans.logic.TestClass;
import nl.avans.logic.TestRepositoryClass;
import nl.avans.ui.NetflixWindow;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Crate database connection
        Database database = new Database(String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                "netflixstatistics.database.windows.net", "NetflixStatistix", "NetflixStatistics", "Netflix$tatistics"));

        //Lezen testtabel
        TestRepositoryClass trc = new TestRepositoryClass(database);
        for (TestClass r : trc.readAll()) {
            System.out.println(r);
        }

        //Create UI
        new NetflixWindow().run();
    }
}
