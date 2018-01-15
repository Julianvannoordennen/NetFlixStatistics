package nl.avans.models.database;

import java.sql.Time;

// shows what information is showed for an episode
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
// returns the entered information about an episode
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
// to set all information about an episode
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
