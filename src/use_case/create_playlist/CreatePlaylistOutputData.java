package use_case.create_playlist;

public class CreatePlaylistOutputData {
    private final String playlistName;

    public CreatePlaylistOutputData(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistName() {
        return playlistName;
    }
}
