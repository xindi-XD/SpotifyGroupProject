package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SongFactory {

    public SongFactory() {}

    public static Song create(String name, String[] artist, String id) {
        return new Song(name, artist, id);
    }

    public static ArrayList<Song> createSongList(JSONArray results) {
        ArrayList<Song> songs = new ArrayList<>();
        for (int i = 0; i < results.length(); i++) {
            JSONObject track = results.getJSONObject(i);
            ArrayList<String> artists = new ArrayList<>();
            JSONArray artistObjects = track.getJSONArray("artists");
            for (int j = 0; j < artistObjects.length(); j++) {
                artists.add(artistObjects.getJSONObject(j).getString("name"));
            }
            Song song = create(track.getString("name"), artists.toArray(new String[0]), track.getString("id"));
            songs.add(song);
        }
        return songs;
    }
}
