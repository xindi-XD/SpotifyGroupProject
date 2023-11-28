package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class CommonSongFactory implements SongFactory {
    public CommonSong create(String name, String[] artist, String id) {
        return new CommonSong(name, artist, id);
    }

    public static CommonSong create(JSONObject object) {
        return new CommonSong(object.getString("name"),
                parseArtists(object.getJSONArray("artists")).toArray(new String[0]),
                object.getString("id"));
    }

    public static ArrayList<String> parseArtists(JSONArray artistJSON) {
        ArrayList<String> artists = new ArrayList<>();
        for (int j = 0; j < artistJSON.length(); j++) {
            artists.add(artistJSON.getJSONObject(j).getString("name"));
        }
        return artists;
    }
}
