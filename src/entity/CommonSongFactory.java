package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class CommonSongFactory implements SongFactory {

    public static CommonSong create(String name, String[] artist, String id) {
        return new CommonSong(name, artist, id);
    }

    public static Song create(JSONObject object) {
        return new CommonSong(object.getString("name"),
                parseArtists(object.getJSONArray("artists")).toArray(new String[0]),
                object.getString("id"));
    }

    public static ArrayList<Song> createSongList(JSONArray results) {
        ArrayList<Song> songs = new ArrayList<>();
        for (int i = 0; i < results.length(); i++) {
            JSONObject track = results.getJSONObject(i);
            JSONArray artistObjects = track.getJSONArray("artists");
            ArrayList<String> artists = parseArtists(artistObjects);
            Song song = create(track.getString("name"), artists.toArray(new String[0]), track.getString("id"));
            songs.add(song);
        }
        return songs;
    }

    public static ArrayList<String> parseArtists(JSONArray artistJSON) {
        ArrayList<String> artists = new ArrayList<>();
        for (int j = 0; j < artistJSON.length(); j++) {
            artists.add(artistJSON.getJSONObject(j).getString("name"));
        }
        return artists;
    }
}
