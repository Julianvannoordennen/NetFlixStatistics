package nl.avans.models;

public class Series {
    private String series;
    private String season;
    private String age;
    private String language;
    private String genre;
    private String resembles;

    public Series(String series, String season, String age, String language, String genre, String resembles){
        this.series = series;
        this.season = season;
        this.age = age;
        this.language = language;
        this.genre = genre;
        this.resembles = resembles;
    }

    public String getSeries() {
        return this.series;
    }

    public String getSeason() {
        return this.season;
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

    public void setSeries(String series) {
        this.series = series;
    }

    public void setSeason(String season) {
        this.season = season;
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
        return "Series: " + this.series + ", Season: " + this.season + ", Age " + this.age + ", Language: " + this.language + ", Genre: " + this.genre + ", Resembles: " + this.resembles;
    }
}
