package entity;

import java.util.ArrayList;

public interface Playlist {
    boolean addSong(Song song);
    boolean removeSong(Song song);
    ArrayList<Song> getSong(String name);
    String getName();
    boolean setName(String name);
    int getLength();
}
