package nl.avans.logic;

public class TestClass {
    private int studentnumber;
    private String firstName;
    private String lastName;
    private String abode;
    private String education;

    public TestClass(int studentnumber, String firstName, String lastName, String abode, String education){
        this.studentnumber = studentnumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.abode = abode;
        this.education = education;
    }

    public int getStudentnumber() {
        return this.studentnumber;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAbode() {
        return this.abode;
    }

    public String getEducation() {
        return this.education;
    }

    public void setStudentnumber(int studentnumber) {
        this.studentnumber = studentnumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAbode(String abode) {
        this.abode = abode;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Studentnumber: " + this.studentnumber + ", Name: " + this.firstName + " " + this.lastName + ", Abode: " + this.abode + ", Education: " + this.education;
    }
}
