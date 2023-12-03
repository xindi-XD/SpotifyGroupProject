package interface_adapter.get_song_stats;

import entity.Song;

import java.util.HashMap;

public class GetStatsState {
    private String songName;
    private String artistName;
    private String releaseDate;
    private HashMap<String, Float> features;
    private String infoError;

    public GetStatsState(GetStatsState copy) {
        this.songName = copy.songName;
        this.artistName = copy.artistName;
        this.releaseDate = copy.releaseDate;
        this.features = copy.features;
        this.infoError = copy.infoError;
    }

    public GetStatsState() {}

    public String getSongName() {return songName;}

    public void setSongName(String song) {this.songName = song;}

    public String getArtistName() {return artistName;}

    public void setArtistName(String artist) {this.artistName = artist;}

    public String getReleaseDate() {return releaseDate;}

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public HashMap<String, Float> getFeatures() {return this.features;}

    public void setFeatures(HashMap<String, Float> features) {this.features = features;}

    public String getInfoError() {return infoError;}

    public void setInfoError(String error) {this.infoError = error;}

}
