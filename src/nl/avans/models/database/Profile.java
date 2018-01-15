package nl.avans.models.database;

//Contains all the important things for creating and viewing a profile.
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

    // Every part of a profile returned
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
    // Meant to set every part of a profile
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
