package nl.avans.models.database;

// Shows everything needed to make an account and returns them.
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

    // returns the subscriber's number
    public int getSubscriberNumber() {
        return this.subscriberNumber;
    }
// returns the subscriber's name
    public String getName() {
        return this.name;
    }
// returns the street entered when making the account
    public String getStreet() {
        return this.street;
    }
// returns the postal code entered when making the account
    public String getPostalCode() {
        return this.postalCode;
    }
// returns the entered housenumber
    public int getHouseNumber() {
        return this.houseNumber;
    }
// returns the city the subscriber lives in
    public String getCity() {
        return this.city;
    }
// sets all parts of the account
    
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
