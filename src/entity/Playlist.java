package entity;

import java.util.Map;

public interface Playlist {
    boolean addSong(CommonSong song);
    boolean removeSong(CommonSong song);
    Map<String, String[]> getSong();
    String getName();
    boolean setName(String name);
    String getDescription();
    boolean setDescription(String description);
    int getLength();
}
