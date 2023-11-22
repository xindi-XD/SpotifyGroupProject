package entity;

import org.json.JSONObject;

public class Song {
    final private String name;
    final private String[] artist;
    final private String id;

    public Song(String name, String[] artist, String id) {
        this.name = name;
        this.id = id;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public String[] getArtist() {
        return artist;
    }

    public String getId() {
        return id;
    }

}
