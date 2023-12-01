package entity;

import org.json.JSONArray;
import org.json.JSONObject;

public class CommonPlaylistFactory implements PlaylistFactory{

    public Playlist create(String name, String description) {
        return new CommonPlaylist(name, description);
    }
}