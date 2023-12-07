package entity;

import data_access.APIDataAccessObject;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.get_song_stats.GetStatsAPIDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonSongFactory implements SongFactory {

    public CommonSong create(String id, String name, String artist, String releaseDate) {
        return new CommonSong(id, name, artist, releaseDate);
    }

    public static CommonSong create(JSONObject result) {
        ArrayList<String> artists = new ArrayList<>();
        JSONArray artistJSON = result.getJSONArray("artists");
        for (int j = 0; j < artistJSON.length(); j++) {
            artists.add(artistJSON.getJSONObject(j).getString("name"));
        }
        String all_artists = "";
        for (int i = 0; i < artists.size(); i++) {
            if (i == artists.size() - 1) {
                all_artists += artists.get(i);
                break;
            }
            all_artists += artists.get(i) + " | ";
        }
        return new CommonSong(result.getString("id"), result.getString("name"),
                all_artists, result.getJSONObject("album").getString("release_date")
        );
    }

    public static CommonSong create(String id) {
        GetStatsAPIDataAccessInterface apiDataAccessInterface = new APIDataAccessObject();
        JSONObject result = apiDataAccessInterface.getTrack(id);
        ArrayList<String> artists = new ArrayList<>();
        JSONArray artistJSON = result.getJSONArray("artists");
        for (int j = 0; j < artistJSON.length(); j++) {
            artists.add(artistJSON.getJSONObject(j).getString("name"));
        }
        String all_artists = "";
        for (int i = 0; i < artists.size(); i++) {
            if (i == artists.size() - 1) {
                all_artists += artists.get(i);
                break;
            }
            all_artists += artists.get(i) + " | ";
        }
       // HashMap<String, Float> features = apiDataAccessInterface.getTrackFeatures(id);
        return new CommonSong(id, result.getString("name"),
                all_artists, result.getJSONObject("album").getString("release_date")
                );
    }
}
