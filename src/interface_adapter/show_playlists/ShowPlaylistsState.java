package interface_adapter.show_playlists;

import entity.CommonPlaylist;
import entity.Playlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShowPlaylistsState {
    private String noPlaylistsError;
    private Map<String, Playlist> playlists;
    private Map<String, String> playlistsDescription;
    public ShowPlaylistsState() {}
    public void setPlaylistsResult(Map<String, Playlist> playlists) {
        this.playlists = playlists;
    }

    public void setPlaylistsDescription(Map<String, String> playlistsDescription) {
        this.playlistsDescription = playlistsDescription;
    }

    public ArrayList<String> getPlaylistsNames() {
        ArrayList<String> playlistResult = new ArrayList<>();
        for (Playlist playlist: playlists.values()) {
            String playlistName = playlist.getName();
            playlistResult.add(playlistName);
        }
        return playlistResult;
    }

    public Map<String, String> getDescriptions() {
        Map<String, String> playlistDescription = new HashMap<>();
        for (Playlist playlist: playlists.values()) {
            playlistDescription.put(playlist.getName(), playlist.getDescription());
        }
        return playlistDescription;
    }

    public void setPlaylistsError(String error) {
        this.noPlaylistsError = error;
    }

    public String getPlaylistsError() {
        return noPlaylistsError;
    }
}
