package interface_adapter.search;

import entity.CommonSong;

import java.util.ArrayList;

public class SearchState {
    private ArrayList<CommonSong> songs;
    private ArrayList<String> songNames;
    public SearchState(){}
    public void setResult(ArrayList<CommonSong> songs) {
        this.songs = songs;
    }
    public ArrayList<String> getSongNames(){
        this.songNames = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            songNames.add(songs.get(i).getName());

        }
        return songNames;
    }
}
