package use_case.create_playlist;

import entity.Playlist;

import java.io.IOException;

public interface CreatePlaylistDataAccessInterface {
    boolean existsPlaylistName(String name);
    void save(Playlist playlist);
}
