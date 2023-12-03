package interface_adapter.search;

import entity.CommonArtist;
import entity.CommonSong;

import java.util.ArrayList;

public class SearchState {
    private String noResultError;
    private ArrayList<CommonSong> songs;
    private ArrayList<CommonArtist> artists;
    private ArrayList<String> songNames;
    private ArrayList<String> artistNames;
    public SearchState(){}
    public void setSongResult(ArrayList<CommonSong> input) {
        this.songs = input;
    }
    public void setArtistResult(ArrayList<CommonArtist> input){
        this.artists = input;
    }
    public ArrayList<String> getSongNames(){
        this.songNames = new ArrayList<>();
        for (int i = 0; i < songs.size(); i++){
            songNames.add(songs.get(i).getName());
        }
        return songNames;
    }
    public ArrayList<String> getArtistNames(){
        this.artistNames = new ArrayList<>();;
        for (int i = 0; i < artists.size(); i++){
            artistNames.add(artists.get(i).getName());
        }
        return artistNames;
    }

    public void setNoResultError(String error) {
        this.noResultError = error;
    }
}
