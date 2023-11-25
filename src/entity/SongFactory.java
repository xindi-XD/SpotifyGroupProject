package entity;

import java.util.ArrayList;

public interface SongFactory {
    CommonSong create(String name, String[] artist, String id);
}