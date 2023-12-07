package interface_adapter.show_playlists;

import entity.CommonPlaylist;
import entity.Playlist;

import java.util.ArrayList;
import java.util.Map;

public class ShowPlaylistsState {
    private String noPlaylistsError;
    private Map<String, Playlist> playlists;
    public ShowPlaylistsState() {}
    public void setPlaylistsResult(Map<String, Playlist> playlists) {
        this.playlists = playlists;
    }

    public ArrayList<String> getPlaylistsNames() {
        ArrayList<String> playlistResult = new ArrayList<>();
        for (Playlist playlist: playlists.values()) {
            String playlistName = playlist.getName();
            playlistResult.add(playlistName);
        }
        return playlistResult;
    }

    public Map<String, Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylistsError(String error) {
        this.noPlaylistsError = error;
    }

    public String getPlaylistsError() {
        return noPlaylistsError;
    }
}
