package interface_adapter.get_song_stats;

import entity.Song;

import java.util.HashMap;

public class GetStatsState {
    private Object song;
    private HashMap<String, Float> features;
    private String infoError;

    public GetStatsState(GetStatsState copy) {
        this.song = copy.song;
        this.features = copy.features;
        this.infoError = copy.infoError;
    }

    public GetStatsState() {}

    public Object getSong() {return song;}

    public void setSong(Object song) {this.song = song;}

    public HashMap<String, Float> getFeatures() {return this.features;}

    public void setFeatures(HashMap<String, Float> features) {this.features = features;}

    public String getInfoError() {return infoError;}

    public void setInfoError(String error) {this.infoError = error;}

}
