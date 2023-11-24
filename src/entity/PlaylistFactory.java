package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlaylistFactory {
    public static Playlist create(String name, String id) {
        return new Playlist(name, id);
    }

    public static Playlist create(String name, String id, ArrayList<Song> songs, boolean privacy) {
        return new Playlist(name, id, songs, privacy);
    }

    public static ArrayList<Playlist> createPlaylistList(JSONArray results) {
        ArrayList<Playlist> playlists = new ArrayList<>();
        for (int i = 0; i < results.length(); i++) {
            JSONObject playlistObject = results.getJSONObject(i);
            Playlist playlist = PlaylistFactory.create(playlistObject.getString("name"),
                    playlistObject.getString("id"),
                    SongFactory.createSongList(playlistObject.getJSONArray("tracks")),
                    playlistObject.getBoolean("public"));
            playlists.add(playlist);
        }
        return playlists;
    }

}
