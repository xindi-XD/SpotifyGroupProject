package interface_adapter.create_playlist;

public class CreatePlaylistState {
    private String playlistName;
    private String description;
    private String nameError;
    public CreatePlaylistState(){};
    public void setPlaylistName(String name){
        this.playlistName = name;
    }
    public String getPlaylistName() {return playlistName;}
    public void setDescription(String s) {this.description = s;}
    public String getDescription(){return description;}
    public void setNameError(String error){
        this.nameError = error;
    }
    public String getNameError() {
        return nameError;
    }
}
