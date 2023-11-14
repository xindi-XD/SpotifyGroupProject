package entity;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SinglePlaylist {
    private String name;
    private String id;
    private ArrayList<Song> songs;
    private boolean privacy; // true when is private, default false.

    public SinglePlaylist(String name, String id) {
        this.name = name;
        this.id = id;
        this.songs = new ArrayList<>();
        this.privacy = false;
    }

    public boolean setSong(Song song) {  // this method is to add a song to the playlist.
        if (!songs.contains(song)) {
            songs.add(song);
            return true;
        }
        return false;
    }

    public void removeSong(Song song) { // remove the song.
        songs.remove(song);
    }

    public ArrayList<Song> getSong(String name) {  // get all the songs with the same name when user searches for a song.
        ArrayList<Song> songList = new ArrayList<>();
        if (songs.isEmpty()) {
            System.out.println("No result for an empty playlist.");
        }

        for (Song song: songs) {
            if (song.getName().equals(name)) {
                songList.add(song);
            }
        }

        if (songList.isEmpty()) {
            System.out.println("Didn't find the song");
        }
        return songList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public int getLength() {
        return songs.size();
    }

    public boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy() {
        this.privacy = !privacy;
    }
}
