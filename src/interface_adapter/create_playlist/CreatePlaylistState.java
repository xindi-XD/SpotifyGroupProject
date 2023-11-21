package interface_adapter.create_playlist;

public class CreatePlaylistState {
    private String playlistName;
    private String description;
    private String nullError;
    private String repeatError;
    public CreatePlaylistState(){};
    public void setPlaylistName(String name){
        this.playlistName = name;
    }
    public String getPlaylistName() {return playlistName;}
    public void setDescription(String s) {this.description = s;}
    public String getDescription(){return description;}
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
