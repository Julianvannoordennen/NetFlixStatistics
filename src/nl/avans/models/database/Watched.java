package nl.avans.models.database;

public class Watched {
    private int subscriberNumber;
    private String username;
    private int watched;
    private int percentage;

    public Watched(int subscriberNumber, String username, int watched, int percentage){
        this.subscriberNumber = subscriberNumber;
        this.username = username;
        this.watched = watched;
        this.percentage = percentage;
    }

    public int getSubscriberNumber() {
        return this.subscriberNumber;
    }

    public String getUsername() {
        return this.username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setWatched(int watched) {
        this.watched = watched;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "SubscriberNumber: " + this.subscriberNumber + ", Username: " + this.username + ", Watched: " + this.watched + ", Percentage: " + this.percentage;
    }
}
