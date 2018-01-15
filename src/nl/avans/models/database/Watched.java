package nl.avans.models.database;

//for showing what someone has watched
public class Watched {
    private int subscriberNumber;
    private int profileNumber;
    private int watched;
    private int percentage;

    public Watched(int subscriberNumber, int profileNumber, int watched, int percentage){
        this.subscriberNumber = subscriberNumber;
        this.profileNumber = profileNumber;
        this.watched = watched;
        this.percentage = percentage;
    }
// to return information about the subscriber and the series/film watched
    public int getSubscriberNumber() {
        return this.subscriberNumber;
    }

    public int getProfileNumber() {
        return this.profileNumber;
    }

    public int getWatched() {
        return this.watched;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public void setSubscriberNumber(int subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    public void setUsername(int profileNumber) {
        this.profileNumber = profileNumber;
    }

    public void setWatched(int watched) {
        this.watched = watched;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "SubscriberNumber: " + this.subscriberNumber + ", Username: " + this.profileNumber + ", Watched: " + this.watched + ", Percentage: " + this.percentage;
    }
}
