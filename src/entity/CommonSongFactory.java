package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonSongFactory implements SongFactory {

    public CommonSong create(String name, String[] artist, String releaseDate, String id) {
        return new CommonSong(name, artist, releaseDate, id);
    }

    public static CommonSong create(JSONObject object) {
        ArrayList<String> artists = new ArrayList<>();
        JSONArray artistJSON = object.getJSONArray("artists");
        for (int j = 0; j < artistJSON.length(); j++) {
            artists.add(artistJSON.getJSONObject(j).getString("name"));
        }
        return new CommonSong(object.getString("name"),
                artists.toArray(new String[0]), object.getJSONObject("album").getString("release_date"),
                object.getString("id"));
    }
}
