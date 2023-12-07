package use_case.show_songs;

import entity.Playlist;

public class ShowSongsInputData {
    private final String playlist;
    public ShowSongsInputData(String playlist) {
        this.playlist = playlist;
    }

    public String getPlaylist() {
        return playlist;
    }
}
