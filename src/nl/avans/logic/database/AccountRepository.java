package nl.avans.logic.database;

import nl.avans.models.database.Account;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountRepository {
    private Database sqlConnection;

    public AccountRepository(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Account> readAll() {
        ArrayList<Account> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Account");
            while(rs.next()) {
                lijst.add(new Account(rs.getInt("AbonneeNummer"),rs.getString("Naam"), rs.getString("Straat"), rs.getString("Postcode"), rs.getInt("Huisnummer"), rs.getString("Plaats")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Account read(int subscriberNumber) {
        Account account = null;
        try
        {
            String sqlQuery = "SELECT * FROM Account WHERE AbonneeNummer=" + subscriberNumber + " ORDER BY AbonneeNummer";
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            account = new Account(rs.getInt("AbonneeNummer"),rs.getString("Naam"), rs.getString("Straat"), rs.getString("Postcode"), rs.getInt("Huisnummer"), rs.getString("Plaats"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return account;
    }

    public boolean create(Account account) {
        try
        {
            String sqlQuery = "INSERT INTO Account VALUES (" + account.getSubscriberNumber() + ", '" + account.getName() + "', '" + account.getStreet() + "', '" + account.getPostalCode() + "', " + account.getHouseNumber() + ", '" + account.getCity() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean update(Account account) {
        try
        {
            String sqlQuery = "UPDATE Account SET Naam='" + account.getName() + "', Straat='" + account.getStreet() + "', Postcode='" + account.getPostalCode() + "', Huisnummer=" + account.getHouseNumber() + ", Plaats='" + account.getCity() + "' WHERE AbonneeNummer=" + account.getSubscriberNumber();
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Account account) {
        if(account==null) return false;
        return delete(account.getSubscriberNumber());
    }

    public boolean delete(int subscriberNumber) {
        try
        {
            String sqlQuery = "DELETE Account WHERE AbonneeNummer=" + subscriberNumber;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
