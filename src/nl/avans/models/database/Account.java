package nl.avans.models.database;

public class Account {
    private int subscriberNumber;
    private String name;
    private String street;
    private String postalCode;
    private int houseNumber;
    private String city;

    public Account(int subscriberNumber, String name, String street, String postalCode, int houseNumber, String city){
        this.subscriberNumber = subscriberNumber;
        this.name = name;
        this.street = street;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.city = city;
    }

    public int getSubscriberNumber() {
        return this.subscriberNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getStreet() {
        return this.street;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public int getHouseNumber() {
        return this.houseNumber;
    }

    public String getCity() {
        return this.city;
    }

    public void setSubscriberNumber(int subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "SubscriberNumber: " + this.subscriberNumber + ", Name: " + this.name+ ", Street: " + this.street + ", PostalCode: " + this.postalCode + ", HouseNumber: " + this.houseNumber + ", City: " + this.city;
    }
}
