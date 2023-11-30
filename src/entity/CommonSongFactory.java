package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonSongFactory implements SongFactory {

    public CommonSong create(String name, String[] artist, String[] genres, String id) {
        return new CommonSong(name, artist, genres, id);
    }

    public CommonSong create(JSONObject object) {
        ArrayList<String> artists = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();
        JSONArray artistJSON = object.getJSONArray("artists");
        for (int j = 0; j < artistJSON.length(); j++) {
            artists.add(artistJSON.getJSONObject(j).getString("name"));
            String[] artistGenres = (String[])artistJSON.getJSONObject(j).get("genres");
            for (String gen : artistGenres) {
                if (!genres.contains(gen)) {
                    genres.add(gen);
                }
            }
        }
        return new CommonSong(object.getString("name"),
                artists.toArray(new String[0]), genres.toArray(new String[0]),
                object.getString("id"));
    }
}
