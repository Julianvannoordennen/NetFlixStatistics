package nl.avans.models.database;

//Contains every type of information added to series
public class Series {
    private String series;
    private String age;
    private String language;
    private String genre;
    private String resembles;

    public Series(String series, String age, String language, String genre, String resembles){
        this.series = series;
        this.age = age;
        this.language = language;
        this.genre = genre;
        this.resembles = resembles;
    }
    //Returns all information entered about series
    public String getSeries() {
        return this.series;
    }

    public String getAge() {
        return this.age;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getResembles() {
        return this.resembles;
    }

    //For setting the information
    public void setSeries(String series) {
        this.series = series;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setResembles(String resembles) {
        this.resembles = resembles;
    }

    @Override
    public String toString() {
        return "Series: " + this.series + ", Age " + this.age + ", Language: " + this.language + ", Genre: " + this.genre + ", Resembles: " + this.resembles;
    }
}
