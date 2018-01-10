package nl.avans.models;

public class Profile {
    private int subscriberNumber;
    private String profileName;
    private String birthDate;

    public Profile(int subscriberNumber, String profileName, String birthDate){
        this.subscriberNumber = subscriberNumber;
        this.profileName = profileName;
        this.birthDate = birthDate;
    }

    public int getSubscriberNumber() {
        return this.subscriberNumber;
    }

    public String getProfileName() {
        return this.profileName;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

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
        return "SubscriberNumber: " + this.subscriberNumber + ", ProfileName: " + this.profileName + ", BirthDate: " + this.birthDate;
    }
}
