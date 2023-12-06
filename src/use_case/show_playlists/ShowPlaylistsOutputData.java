package use_case.show_playlists;

import entity.Playlist;

import java.util.Map;

public class ShowPlaylistsOutputData {
    private final Map<String, Playlist> playlists;

    public ShowPlaylistsOutputData(Map<String, Playlist> playlists) {
        this.playlists = playlists;
    }

    public Map<String, Playlist> getPlaylists() {
        return playlists;
    }
}
