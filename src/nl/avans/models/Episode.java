package nl.avans.models;

import java.sql.Time;

public class Episode {
    private int episodeId;
    private String series;
    private String season;
    private String titleEpisode;
    private Time duration;

    public Episode(int episodeId, String series, String season, String titleEpisode, Time duration){
        this.episodeId = episodeId;
        this.series = series;
        this.season = season;
        this.titleEpisode = titleEpisode;
        this.duration = duration;
    }

    public int getEpisodeId() {
        return this.episodeId;
    }

    public String getSeries() {
        return this.series;
    }

    public String getSeason() {
        return this.season;
    }

    public String getTitleEpisode() {
        return this.titleEpisode;
    }

    public Time getDuration() {
        return this.duration;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setTitleEpisode(String titleEpisode) {
        this.titleEpisode = titleEpisode;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "EpisodeId: " + this.episodeId + ", Series: " + this.series + ", Season: " + this.season+ ", TitleEpisode: " + this.titleEpisode + ", Duration: " + this.duration;
    }
}
