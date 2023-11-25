package entity;

import java.util.ArrayList;

public interface Playlist {
    boolean addSong(CommonSong song);
    boolean removeSong(CommonSong song);
    ArrayList<CommonSong> getSong(String name);
    String getName();
    boolean setName(String name);
    int getLength();
}
