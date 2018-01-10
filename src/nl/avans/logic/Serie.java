package nl.avans.logic;

public class Serie {
    private String serie;
    private String seizoen;
    private String leeftijd;
    private String taal;
    private String genre;
    private String lijktOP;

    public Serie(String serie, String seizoen, String leeftijd, String taal, String genre, String lijktOP){
        this.serie = serie;
        this.seizoen = seizoen;
        this.leeftijd = leeftijd;
        this.taal = taal;
        this.genre = genre;
        this.lijktOP = lijktOP;
    }

    public String getSerie() {
        return this.serie;
    }

    public String getSeizoen() {
        return this.seizoen;
    }

    public String getLeeftijd() {
        return this.leeftijd;
    }

    public String getTaal() {
        return this.taal;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getLijktOP() {
        return this.lijktOP;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setSeizoen(String seizoen) {
        this.seizoen = seizoen;
    }

    public void setLeeftijd(String leeftijd) {
        this.leeftijd = leeftijd;
    }

    public void setTaal(String taal) {
        this.taal = taal;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLijktOP(String lijktOP) {
        this.lijktOP = lijktOP;
    }

    @Override
    public String toString() {
        return "Serie: " + this.serie + ", Seizoen: " + this.seizoen + ", Leeftijd " + this.leeftijd + ", Taal: " + this.taal + ", Genre: " + this.genre + ", LijktOP: " + this.lijktOP;
    }
}
