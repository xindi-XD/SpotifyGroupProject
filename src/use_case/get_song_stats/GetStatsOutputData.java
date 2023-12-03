package use_case.get_song_stats;

import entity.Song;

import java.util.HashMap;

public class GetStatsOutputData {
    private final Object song;
    private final HashMap<String, Float> features;
    private boolean useCaseFailed;

    public GetStatsOutputData(Object song, HashMap<String, Float> features,
                              boolean failed) {
        this.song = song;
        this.features = features;
        this.useCaseFailed = failed;
    }

    public Object getSong() {return song;}

    public HashMap<String, Float> getFeatures() {return features;}
}
