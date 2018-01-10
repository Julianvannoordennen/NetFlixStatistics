package nl.avans.models;

import java.sql.Time;

public class Film {
    private int filmId;
    private String titel;
    private String leeftijdsIndicatie;
    private String taal;
    private Time tijdsduur;
    private String genre;

    public Film(int filmId, String titel, String leeftijdsIndicatie, String taal, Time tijdsduur, String genre){
        this.filmId = filmId;
        this.titel = titel;
        this.leeftijdsIndicatie = leeftijdsIndicatie;
        this.taal = taal;
        this.tijdsduur = tijdsduur;
        this.genre = genre;
    }

    public int getFilmId() {
        return this.filmId;
    }

    public String getTitel() {
        return this.titel;
    }

    public String getLeeftijdsIndicatie() {
        return this.leeftijdsIndicatie;
    }

    public String getTaal() {
        return this.taal;
    }

    public Time getTijdsduur() {
        return this.tijdsduur;
    }

    public String getGenre() {
        return  this.genre;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setLeeftijdsIndicatiee(String leeftijdsIndicatie) {
        this.leeftijdsIndicatie = leeftijdsIndicatie;
    }

    public void setTaal(String taal) {
        this.taal = taal;
    }

    public void setTijdsduur(Time tijdsduur) {
        this.tijdsduur = tijdsduur;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "FilmId: " + this.filmId+ ", Titel: " + this.titel + ", LeeftijdsIndicatie: " + this.leeftijdsIndicatie+ ", Taal: " + this.taal + ", Tijdsduur: " + this.tijdsduur + ", Genre: " + this.genre;
    }
}
