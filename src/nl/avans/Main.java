package nl.avans;

import nl.avans.logic.*;
import nl.avans.ui.NetflixWindow;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Create database connection
        Database database = new Database(String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                "netflixstatistics.database.windows.net", "NetflixStatistix", "NetflixStatistics", "Netflix$tatistics"));

        //Lezen testtabel
        SerieRepository trc = new SerieRepository(database);
        for (Serie r : trc.readAll()) {
            System.out.println(r);
        }

        //Create UI
        new NetflixWindow().run();
    }
}
