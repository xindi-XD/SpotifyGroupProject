package entity;

import java.util.HashMap;
import java.util.Map;

public class CommonSong implements Song {
    final private String songId;

    final private String name;

    final private String artists;

    final private String releaseDate;


    public CommonSong(String id, String name, String artist, String releaseDate) {
        this.songId = id;
        this.name = name;
        this.artists = artist;
        this.releaseDate = releaseDate;

    }

    public String getId() {return this.songId;}


    public String getName() {
        return name;
    }


    public String getArtistName() {
        return artists;
    }

    public String getReleaseDate() {return releaseDate;}



}
