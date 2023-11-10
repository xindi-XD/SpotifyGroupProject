package entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class Playlist {
    private String name;
    private HashMap<String, Song> songs;
    private boolean privacy; // true when is private, default false.

    public Playlist(String name) {
        this.name = name;
        this.songs = new HashMap<>();
        this.privacy = false;
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
