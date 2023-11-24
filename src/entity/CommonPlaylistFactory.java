package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class CommonPlaylistFactory implements PlaylistFactory{
    public static CommonPlaylist create(String name) {
        return new CommonPlaylist(name);
    }

    public static ArrayList<Playlist> createPlaylistList(JSONArray results) {
        ArrayList<Playlist> playlists = new ArrayList<>();
        for (int i = 0; i < results.length(); i++) {
            JSONObject playlistObject = results.getJSONObject(i);
            Playlist playlist = create(playlistObject.getString("name"));
            ArrayList<Song> songsList = SongFactory.createSongList(playlistObject.getJSONArray("tracks"));
            for (Song song : songsList) {
                playlist.addSong(song);
            }
            playlists.add(playlist);
        }
        return playlists;
    }
}
