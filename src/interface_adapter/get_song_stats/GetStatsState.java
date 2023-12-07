package interface_adapter.get_song_stats;

import entity.Song;

import java.util.ArrayList;
import java.util.HashMap;

public class GetStatsState {
    private String songId;
    private String songName;
    private String artistName;
    private String releaseDate;
    private HashMap<String, Float> features;
    private String infoError;

    private ArrayList<String> playlistnames;

    private String selectedPlaylist;

    public GetStatsState(GetStatsState copy) {
        this.songId = copy.songId;
        this.songName = copy.songName;
        this.artistName = copy.artistName;
        this.releaseDate = copy.releaseDate;
        this.features = copy.features;
        this.infoError = copy.infoError;
    }

    public GetStatsState() {}
    public void setSongId(String songId) {this.songId =  songId;}

    public String getSongId() {return this.songId;}


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

    public void setPlaylistSelection(String string) { this.selectedPlaylist = string;
    }

    public String getSelectedPlaylist() { return this.selectedPlaylist;
    }

    public void setPlaylistNames(ArrayList<String> names) {this.playlistnames = names;}

    public ArrayList<String> getPlaylistNames() {return this.playlistnames;}
}
