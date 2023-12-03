package interface_adapter.delete_playlist;

public class DeletePlaylistState {
    private String playlistName;
    private String nullError;
    private String repeatError;
    public DeletePlaylistState(){};
    public void setPlaylistName(String name){
        this.playlistName = name;
    }
    public String getPlaylistName() {return playlistName;}
    public void setNullError(String error){
        this.nullError = error;
    }
    public String getNullError() {
        return nullError;
    }
    public void setRepeatError(String error){
        this.repeatError = error;
    }
    public String getRepeatError() {
        return repeatError;
    }
}
