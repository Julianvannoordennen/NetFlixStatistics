package nl.avans.logic;

import java.sql.Time;

public class Aflevering {
    private int afleveringId;
    private String serie;
    private String seizoen;
    private String titelAflevering;
    private Time tijdsduur;

    public Aflevering(int afleveringId, String serie, String seizoen, String titelAflevering, Time tijdsduur){
        this.afleveringId = afleveringId;
        this.serie = serie;
        this.seizoen = seizoen;
        this.titelAflevering = titelAflevering;
        this.tijdsduur = tijdsduur;
    }

    public int getAfleveringId() {
        return this.afleveringId;
    }

    public String getSerie() {
        return this.serie;
    }

    public String getSeizoen() {
        return this.seizoen;
    }

    public String getTitelAflevering() {
        return this.titelAflevering;
    }

    public Time getTijdsduur() {
        return this.tijdsduur;
    }

    public void setAfleveringId(int afleveringId) {
        this.afleveringId = afleveringId;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setSeizoen(String seizoen) {
        this.seizoen = seizoen;
    }

    public void setTitelAflevering(String titelAflevering) {
        this.titelAflevering = titelAflevering;
    }

    public void setTijdsduur(Time tijdsduur) {
        this.tijdsduur = tijdsduur;
    }

    @Override
    public String toString() {
        return "AfleveringId: " + this.afleveringId + ", Serie: " + this.serie + ", Seizoen: " + this.seizoen+ ", TitelAflevering: " + this.titelAflevering + ", Tijdsduur: " + this.tijdsduur;
    }
}
