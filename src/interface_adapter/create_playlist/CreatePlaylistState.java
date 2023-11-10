package interface_adapter.create_playlist;

public class CreatePlaylistState {
    private String playlistName;
    public CreatePlaylistState(){};
    public void setPlaylistName(String name){
        this.playlistName = name;
    }
    public String getPlaylistName() {
        return playlistName;
    }
}
