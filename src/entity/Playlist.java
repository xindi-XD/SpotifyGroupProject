package entity;

import java.util.ArrayList;

public interface Playlist {
    boolean addSong(CommonSong song);
    boolean removeSong(CommonSong song);
    ArrayList<CommonSong> getSong();
    String getName();
    boolean setName(String name);
    int getLength();
}
