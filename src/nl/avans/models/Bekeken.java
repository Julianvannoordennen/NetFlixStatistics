package nl.avans.models;

public class Bekeken {
    private int abonneeNummer;
    private String gebruikersNaam;
    private int gezien;
    private int percentage;

    public Bekeken(int abonneeNummer, String gebruikersNaam, int gezien, int percentage){
        this.abonneeNummer = abonneeNummer;
        this.gebruikersNaam = gebruikersNaam;
        this.gezien = gezien;
        this.percentage = percentage;
    }

    public int getAbonneeNummer() {
        return this.abonneeNummer;
    }

    public String getGebruikersNaam() {
        return this.gebruikersNaam;
    }

    public int getGezien() {
        return this.gezien;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public void setAbonneeNummer(int abonneeNummer) {
        this.abonneeNummer = abonneeNummer;
    }

    public void setGebruikersNaam(String gebruikersNaam) {
        this.gebruikersNaam = gebruikersNaam;
    }

    public void setGezien(int gezien) {
        this.gezien = gezien;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "AbonneeNummer: " + this.abonneeNummer + ", GebruikersNaam: " + this.gebruikersNaam + ", Gezien: " + this.gezien + ", Percentage: " + this.percentage;
    }
}
