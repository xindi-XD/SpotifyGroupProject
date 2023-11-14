package entity;

import java.util.HashMap;

public class PlaylistFactory {
    public Playlist create(String name, HashMap<Song, String> songs, boolean privacy) {
        return new Playlist(name, songs, privacy);
    }
}
