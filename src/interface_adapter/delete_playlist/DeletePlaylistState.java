package interface_adapter.delete_playlist;

public class DeletePlaylistState {
    private String playlistName;
    private String nameError;
    public DeletePlaylistState(){};
    public void setPlaylistName(String name){
        this.playlistName = name;
    }
    public String getPlaylistName() {return playlistName;}
    public void setNameError(String error){
        this.nameError = error;
    }
    public String getNameError() {
        return nameError;
    }
}
