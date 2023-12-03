package use_case.get_song_stats;

import org.json.JSONObject;

import java.util.HashMap;

public interface GetStatsAPIDataAccessInterface {

    JSONObject getTrack(String id);

    HashMap<String, Float> getTrackFeatures(String id);
}
