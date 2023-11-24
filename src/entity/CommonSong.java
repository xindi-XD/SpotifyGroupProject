package entity;

public class CommonSong implements Song {
    final private String name;
    final private String artist;
    final private String id;

    final private String genre;

    public CommonSong(String name, String artist, String id, String genre) {
        this.name = name;
        this.id = id;
        this.artist = artist;
        this.genre = genre;
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

    @Override
    public String getGenre() {return genre; }

    public String getArtist() {
        return artist;
    }

    @Override
    public String getID() {return id;
    }


}
