package use_case.search;

import entity.CommonArtist;
import entity.CommonSong;

import java.util.ArrayList;

public class SearchOutputData {
    // TODO: data is an arraylist, of either common song or common artist.
    private final ArrayList data;
    private String creationTime;
    private boolean useCaseFailed;
    private String outputType;
    public SearchOutputData(ArrayList data, String creationTime, boolean useCaseFailed){
        this.creationTime = creationTime;
        this.data = data;
        this.useCaseFailed = useCaseFailed;
    }
    public ArrayList<CommonSong> getSongs(){
        ArrayList<CommonSong> songs = ((ArrayList<CommonSong>) data);
        return songs;
    }
    public ArrayList<CommonArtist> getArtists() {
        ArrayList<CommonArtist> artists =  ((ArrayList<CommonArtist>) data);
        return artists;
    }
    public String getCreationTime(){
        return creationTime;
    }
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}
