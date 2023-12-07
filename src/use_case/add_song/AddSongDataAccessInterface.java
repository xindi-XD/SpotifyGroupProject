package use_case.add_song;

import entity.Playlist;

import java.util.Map;

public interface AddSongDataAccessInterface {
    Map<String, Playlist> getPlaylists();

}
