package nl.avans.logic;

import nl.avans.models.Account;

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

    public Account read(int abonneeNummer) {
        Account account = null;
        try
        {
            String sqlQuery = "SELECT * FROM Account WHERE AbonneeNummer=" + abonneeNummer;
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
            String sqlQuery = "INSERT INTO Account VALUES (" + account.getAbonneeNummer() + ", '" + account.getNaam() + "', '" + account.getStraat() + ", '" + account.getPostcode() + ", '" + account.getHuisnummer() + ", '" + account.getPlaats() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Account account) {
        if(account==null) return false;
        return delete(account.getAbonneeNummer());
    }

    public boolean delete(int abonneeNummer) {
        try
        {
            String sqlQuery = "DELETE Account WHERE AbonneeNummer=" + abonneeNummer;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
