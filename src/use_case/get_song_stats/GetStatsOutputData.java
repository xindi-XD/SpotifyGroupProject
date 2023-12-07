package use_case.get_song_stats;

import entity.Song;
import org.json.JSONObject;

import java.util.HashMap;

public class GetStatsOutputData {
    private final JSONObject song;
    private final HashMap<String, Float> features;
    private boolean useCaseFailed;

    public GetStatsOutputData(JSONObject song, HashMap<String, Float> features,
                              boolean failed) {
        this.song = song;
        this.features = features;
        this.useCaseFailed = failed;
    }

    public JSONObject getSong() {return song;}

    public HashMap<String, Float> getFeatures() {return features;}
}
