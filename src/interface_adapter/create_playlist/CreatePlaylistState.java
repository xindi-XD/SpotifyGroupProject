package interface_adapter.create_playlist;

public class CreatePlaylistState {
    private String playlistName;
    private String description;
    public CreatePlaylistState(){};
    public void setPlaylistName(String name){
        this.playlistName = name;
    }
    public String getPlaylistName() {return playlistName;}
    public void setDescription(String s) {this.description = s;}
    public String getDescription(){return description;}
}
