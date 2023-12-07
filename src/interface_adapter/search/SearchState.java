package interface_adapter.search;

import entity.CommonArtist;
import entity.CommonSong;

import java.util.ArrayList;

public class SearchState {
    private String noResultError;
    private String noInputError;
    private ArrayList<CommonSong> songs;
    private ArrayList<CommonArtist> artists;
    // songWriterNames is an arraylist of an arraylist of strings. For each of the songs.
    private ArrayList<String> songNames;
    private ArrayList<String> songWriterNames;
    // artistNames is for artist.
    private ArrayList<String> artistNames;
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
            songIDs.add(song.getId());
        }
        return songIDs;
    }
    public ArrayList<String> getSongWriterNames(){
        this.songWriterNames = new ArrayList<>();
        for (int i = 0; i < songs.size(); i++){
            songWriterNames.add(songs.get(i).getArtistName());
        }
        return songWriterNames;
    }
    public ArrayList<String> getArtistNames(){
        ArrayList<String> artistNames = new ArrayList<>();
        for (CommonArtist artist : artists) {
            artistNames.add(artist.getName());
        }
        return artistNames;
    }
    public ArrayList<CommonSong> getFullSongs(){
        return songs;
    }
    public ArrayList<CommonArtist> getFullArtists(){
        return artists;
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
