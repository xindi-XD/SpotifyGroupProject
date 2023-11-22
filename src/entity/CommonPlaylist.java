package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Todo: changed the type of songs to Map, need to modify some codes so the codes are compatible.
public class CommonPlaylist implements Playlist{
    private String name;
    private final Map<String, Song> songs = new HashMap<>();

    public CommonPlaylist(String name) {
        this.name = name;
    }
    public boolean addSong(Song song) {  // this method is to add a song to the playlist.
        if (!songs.contains(song)) {
            songs.add(song);
            return true;
        }
        return false;
    }

    public boolean removeSong(Song song) { // remove the song.
        songs.remove(song);
        return true;
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

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public int getLength() {
        return songs.size();
    }
}
