package use_case.show_playlists;

import entity.Playlist;

import java.util.Map;

public interface ShowPlaylistsDataAccessInterface {
    Map<String, Playlist> getPlaylists();
}
