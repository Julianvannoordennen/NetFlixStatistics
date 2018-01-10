package nl.avans.logic;

public class Account {
    private int abonneeNummer;
    private String naam;
    private String straat;
    private String postcode;
    private int huisnummer;
    private String plaats;

    public Account(int abonneeNummer, String naam, String straat, String postcode, int huisnummer, String plaats){
        this.abonneeNummer = abonneeNummer;
        this.naam = naam;
        this.straat = straat;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.plaats = plaats;
    }

    public int getAbonneeNummer() {
        return this.abonneeNummer;
    }

    public String getNaam() {
        return this.naam;
    }

    public String getStraat() {
        return this.straat;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public int getHuisnummer() {
        return this.huisnummer;
    }

    public String getPlaats() {
        return this.plaats;
    }

    public void setAbonneeNummer(int abonneeNummer) {
        this.abonneeNummer = abonneeNummer;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    @Override
    public String toString() {
        return "AbonneeNummer: " + this.abonneeNummer + ", Naam: " + this.naam+ ", Straat: " + this.straat + ", Postcode: " + this.postcode + ", Huisnummer: " + this.huisnummer + ", Plaats: " + this.plaats;
    }
}
