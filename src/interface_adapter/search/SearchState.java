package interface_adapter.search;

import entity.CommonArtist;
import entity.CommonSong;

import java.util.ArrayList;

public class SearchState {
    private String noResultError;
    private String noInputError;
    private ArrayList<CommonSong> songs;
    private ArrayList<CommonArtist> artists;

    public SearchState(){}
    public void setSongResult(ArrayList<CommonSong> input) {
        this.songs = input;
    }
    public void setArtistResult(ArrayList<CommonArtist> input){
        this.artists = input;
    }
    public ArrayList<String> getSongNames(){
        ArrayList<String> songNames = new ArrayList<>();
        for (CommonSong song : songs) {
            songNames.add(song.getName());
        }
        return songNames;
    }
    public ArrayList<String> getSongIDs() {
        ArrayList<String> songIDs = new ArrayList<>();
        for (CommonSong song : songs) {
            songIDs.add(song.getID());
        }
        return songIDs;
    }
    public ArrayList<String> getArtistNames(){
        ArrayList<String> artistNames = new ArrayList<>();
        for (CommonArtist artist : artists) {
            artistNames.add(artist.getName());
        }
        return artistNames;
    }

    public void setNoResultError(String error) {
        this.noResultError = error;
    }
    public String getNoResultError(){
        return noResultError;
    }
    public void setNoInputError(String error) {
        this.noInputError = error;
    }
    public Object getNoInputError() {return noInputError;}
}
