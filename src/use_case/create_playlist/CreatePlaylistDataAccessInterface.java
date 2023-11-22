package use_case.create_playlist;

import entity.Playlist;

public interface CreatePlaylistDataAccessInterface {
    void save(Playlist playlist);
}
