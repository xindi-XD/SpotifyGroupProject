package use_case.create_playlist;

import entity.CommonPlaylist;

public interface CreatePlaylistDataAccessInterface {
    void save(CommonPlaylist playlist);
}
