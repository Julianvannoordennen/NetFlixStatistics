package nl.avans.models;

public class Profiel {
    private int abonneenummer;
    private String profielnaam;
    private String geboortedatum;

    public Profiel(int abonneenummer, String profielnaam, String geboortedatum){
        this.abonneenummer = abonneenummer;
        this.profielnaam = profielnaam;
        this.geboortedatum = geboortedatum;
    }

    public int getAbonneenummer() {
        return this.abonneenummer;
    }

    public String getProfielnaam() {
        return this.profielnaam;
    }

    public String getGeboortedatum() {
        return this.geboortedatum;
    }

    public void setAbonneenummer(int abonneenummer) {
        this.abonneenummer = abonneenummer;
    }

    public void setProfielnaam(String profielnaam) {
        this.profielnaam = profielnaam;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    @Override
    public String toString() {
        return "Abonneenummer: " + this.abonneenummer + ", Profielnaam: " + this.profielnaam + ", Geboortedatum: " + this.geboortedatum;
    }
}
