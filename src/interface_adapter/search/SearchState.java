package interface_adapter.search;

import entity.CommonSong;

import java.util.ArrayList;

public class SearchState {
    private ArrayList<CommonSong> songs;
    private ArrayList<CommonArtist> artists;
    private ArrayList<String> songNames;
    public SearchState(){}
    public void setResult(ArrayList<E> input, String type) {
        if (type == "track"){this.songs = input;}
        else if (type == "artist"){this.artists = input;}
    }
    public ArrayList<String> getSongNames(){
        this.songNames = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            songNames.add(songs.get(i).getName());

        }
        return songNames;
    }
}
