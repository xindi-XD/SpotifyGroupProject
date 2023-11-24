package entity;

import java.util.ArrayList;

public class CommonSong implements Song {
    final private String name;
    final private String[] artist;
    final private String id;


    public CommonSong(String name, String[] artist, String id) {
        this.name = name;
        this.id = id;
        this.artist = artist;
    }

    @Override
    public boolean likeSong(CommonSong song) {
        return false;
    }

    @Override
    public boolean unlikeSong(CommonSong song) {
        return false;
    }

    public String getName() {
        return name;
    }


    public String[] getArtist() {
        return artist;
    }

    @Override
    public String getID() {return id;
    }


}
