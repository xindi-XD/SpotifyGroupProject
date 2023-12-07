package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Todo: changed the type of songs to Map, need to modify some codes so the codes are compatible.
public class CommonPlaylist implements Playlist{
    private String name;

    private String description;
    private final ArrayList<CommonSong> songs = new ArrayList<>();

    public CommonPlaylist(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public boolean addSong(CommonSong song) {  // this method is to add a song to the playlist.
        if (!songs.contains(song)) {
            songs.add(song);
            return true;
        }
        return false;
    }

    public boolean removeSong(CommonSong song) { // remove the song.
        songs.remove(song);
        return true;
    }

    public Map<String, String[]> getSong() {  // get all the songs with the same name when user searches for a song.
        Map<String,String[]> songList = new HashMap<>();
        for (CommonSong song: songs) {
            if (song.getName().equals(name)) {
                songList.put(song.getName(), song.getArtist());
            }
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
