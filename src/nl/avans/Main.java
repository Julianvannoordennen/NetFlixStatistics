package nl.avans;

import nl.avans.logic.*;
import nl.avans.models.*;
import nl.avans.ui.NetflixWindow;

public class Main {

    public static void main(String[] args) {

        //Create database connection
        Database database = new Database(String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                "netflixstatistics.database.windows.net", "NetflixStatistix", "NetflixStatistics", "Netflix$tatistics"));

        //Create UI
        new NetflixWindow(database).run();
    }
}
