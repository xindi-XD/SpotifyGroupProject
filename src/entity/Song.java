package entity;

import java.util.ArrayList;

public interface Song {
    boolean likeSong(CommonSong song);
    boolean unlikeSong(CommonSong song);
    String getName();

    String[] getArtist();

    String getID();
}
