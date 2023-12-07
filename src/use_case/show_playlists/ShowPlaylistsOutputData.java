package use_case.show_playlists;

import entity.Playlist;

import java.util.ArrayList;
import java.util.Map;

public class ShowPlaylistsOutputData {
    private final Map<String, Playlist> playlistsData;
    private final ArrayList<String> playlistsName = new ArrayList<>();

    public ShowPlaylistsOutputData(Map<String, Playlist> playlists) {
        this.playlistsData = playlists;
        this.playlistsName.addAll(playlistsData.keySet());
    }

    public Map<String, Playlist> getPlaylists() {
        return playlistsData;
    }

    public ArrayList<String> getPlaylistsName() {
        return playlistsName;
    }
}
