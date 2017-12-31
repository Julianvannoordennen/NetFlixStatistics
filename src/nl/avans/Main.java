package nl.avans;

import nl.avans.logic.Database;
import nl.avans.ui.NetflixWindow;

import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
/*
        Database database = new Database();
        ResultSet rs = database.execute("SELECT * FROM TestTabel");
        //ResultSet rs2 = database.execute("SELECT TOP 1 * FROM TestTabel");

        try {

            System.out.println(rs.getString("naam"));
        } catch (Exception e) {System.out.println(e);}

*/
        //database.disconnect();

        //Create UI
        new NetflixWindow().run();

    }
}
