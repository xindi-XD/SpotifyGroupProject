package use_case.create_playlist;

public class CreatePlaylistOutputData {
    private final String playlistName;
    private final String playlistDescription;

    public CreatePlaylistOutputData(String playlistName, String playlistDescription) {
        this.playlistName = playlistName;
        this.playlistDescription = playlistDescription;
    }

    public String getPlaylistName() {
        return playlistName;
    }
    public String getPlaylistDescription() {
        return playlistDescription;
    }
}
