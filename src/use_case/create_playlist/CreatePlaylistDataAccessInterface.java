package use_case.create_playlist;

import entity.CommonPlaylist;

import java.io.IOException;

public interface CreatePlaylistDataAccessInterface {
    void save(CommonPlaylist playlist);
}
