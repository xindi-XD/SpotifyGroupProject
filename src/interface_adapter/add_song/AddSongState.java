package interface_adapter.add_song;

public class AddSongState {
    private String nameError;
    public AddSongState(){};
    public void setNameError(String error){
        this.nameError = error;
    }
    public String getNameError() {
        return nameError;
    }
}
