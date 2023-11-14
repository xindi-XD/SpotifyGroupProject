package entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Playlist {
    private String name;
    private HashMap<Song, String> songs;
    private boolean privacy; // true when is private, default false.

    public Playlist(String name) {
        this.name = name;
        this.songs = new HashMap<>();
        this.privacy = false;
    }

    public Playlist(String name, HashMap<Song, String> songs, boolean privacy) {
        this.name = name;
        this.songs = songs;
        this.privacy = privacy;
    }

    public boolean setSong(Song song) {  // this method is to add a song to the playlist.
        if (!songs.containsKey(song) || !songs.containsValue(song.getName())) {
            songs.put(song, song.getName());
            return true;
        }
        return false;
    }

    public void removeSong(Song song) { // remove the song.
        if (songs.containsKey(song) || songs.containsValue(song.getName())) {
            songs.remove(song);
        }
    }

    public ArrayList<Song> getSong(String name) {  // get all the songs with the same name when user searches for a song.
        ArrayList<Song> songList = new ArrayList<>();
        Map<Song, String> songsMap = songs;
        if (songs.containsValue(name)) {
            for (Map.Entry<Song, String> entry: songsMap.entrySet()) {
                Song song = entry.getKey();
                String songName = entry.getValue();
                if (name.equals(songName)) {
                    songList.add(song);
                }
            }
        }
        return songList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
