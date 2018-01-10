package nl.avans.logic;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TestRepositoryClass {
    private Database sqlConnection;

    public TestRepositoryClass(Database sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<TestClass> readAll() {
        ArrayList<TestClass> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM TestTabel");
            while(rs.next()) {
                lijst.add(new TestClass(rs.getInt("Studentnumber"),rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Abode"), rs.getString("Education")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public TestClass read(int studentnumber) {
        TestClass student = null;
        try
        {
            String sqlQuery = "SELECT * FROM TestTabel WHERE Studentnummer=" + studentnumber;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            student = new TestClass(rs.getInt("Studentnumber"),rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Abode"), rs.getString("Education"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return student;
    }

    public boolean create(TestClass student) {
        try
        {
            String sqlQuery = "INSERT INTO TestTabel VALUES (" + student.getStudentnumber() + ", '" + student.getFirstName() + "', '" + student.getLastName() + ", '" + student.getAbode() + ", '" + student.getEducation() + "')";
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(TestClass student) {
        if(student==null) return false;
        return delete(student.getStudentnumber());
    }

    public boolean delete(int studentnumber) {
        try
        {
            String sqlQuery = "DELETE TestTabel WHERE Studentnummer=" + studentnumber;
            return sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
