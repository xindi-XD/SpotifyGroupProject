package entity;

import org.json.JSONArray;
import org.json.JSONObject;

public class CommonPlaylistFactory implements PlaylistFactory{

    public Playlist create(String name) {
        return new CommonPlaylist(name);
    }

    public Playlist create(JSONObject object) {
        Playlist playlist = new CommonPlaylist(object.getString("name"));
        JSONArray objectTracks = object.getJSONArray("tracks");
        for (int i = 0; i < objectTracks.length(); i++) {
            CommonSongFactory songFactory = new CommonSongFactory();
            playlist.addSong(songFactory.create((JSONObject) objectTracks.get(i)));
        }
        return playlist;
    }
}
