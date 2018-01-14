package nl.avans.models.database;

import java.sql.Time;

public class Film {
    private int filmId;
    private String title;
    private String ageRange;
    private String language;
    private Time duration;
    private String genre;

    public Film(int filmId, String title, String ageRange, String language, Time duration, String genre){
        this.filmId = filmId;
        this.title = title;
        this.ageRange = ageRange;
        this.language = language;
        this.duration = duration;
        this.genre = genre;
    }

    public int getFilmId() {
        return this.filmId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAgeRange() {
        return this.ageRange;
    }

    public String getLanguage() {
        return this.language;
    }

    public Time getDuration() {
        return this.duration;
    }

    public String getGenre() {
        return  this.genre;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAgeRangee(String ageRange) {
        this.ageRange = ageRange;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "FilmId: " + this.filmId+ ", Title: " + this.title + ", AgeRange: " + this.ageRange+ ", Language: " + this.language + ", Duration: " + this.duration + ", Genre: " + this.genre;
    }
}
