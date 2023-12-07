package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Todo: changed the type of songs to Map, need to modify some codes so the codes are compatible.
public class CommonPlaylist implements Playlist{
    private String name;

    private String description;
    private final Map<String, CommonSong> songs = new HashMap<>();

    public CommonPlaylist(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public boolean addSong(CommonSong song) {  // this method is to add a song to the playlist.
        if (!songs.containsKey(song.getName()) && !songs.containsValue(song)) {
            songs.put(song.getName(), song);
            return true;
        }
        return false;
    }

    public boolean removeSong(CommonSong song) { // remove the song.
        songs.remove(song);
        return true;
    }

    public ArrayList<CommonSong> getSong() {  // get all the songs with the same name when user searches for a song.
        ArrayList<CommonSong> songList = new ArrayList<>();
        if (songs.isEmpty()) {
            System.out.println("No result for an empty playlist.");
        }

        for (CommonSong song: songs.values()) {
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

    public String getDescription() {
        return description;
    }

    public boolean setDescription(String description) {
        this.description = description;
        return true;
    }

    public int getLength() {
        return songs.size();
    }
}
