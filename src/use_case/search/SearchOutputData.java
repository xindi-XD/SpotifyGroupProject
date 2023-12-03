package use_case.search;

import entity.CommonSong;

import java.util.ArrayList;

public class SearchOutputData {
    // TODO: song type is Object, change to string when assured.
    private final ArrayList<CommonSong> songs;
    private String creationTime;
    private boolean useCaseFailed;
    public SearchOutputData(ArrayList<CommonSong> songs, String creationTime, boolean useCaseFailed){
        this.creationTime = creationTime;
        this.songs = songs;
        this.useCaseFailed = useCaseFailed;
    }
    public ArrayList<CommonSong> getSongs(){
        return songs;
    }
    public String getCreationTime(){
        return creationTime;
    }
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
