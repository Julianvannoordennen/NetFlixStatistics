package nl.avans.models.database;

public class Profile {
    private int profileNumber;
    private int subscriberNumber;
    private String profileName;
    private String birthDate;

    public Profile(int profileNumber, int subscriberNumber, String profileName, String birthDate){
        this.profileNumber = profileNumber;
        this.subscriberNumber = subscriberNumber;
        this.profileName = profileName;
        this.birthDate = birthDate;
    }

    public int getProfileNumber() { return this.profileNumber; }

    public int getSubscriberNumber() {
        return this.subscriberNumber;
    }

    public String getProfileName() {
        return this.profileName;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setProfileNumber(int profileNumber) { this.profileNumber = profileNumber; }

    public void setSubscriberNumber(int subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "ProfileNumber: " + this.profileNumber + ", ProfileName: " + this.profileName + ", BirthDate: " + this.birthDate;
    }
}
