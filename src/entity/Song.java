package entity;

public class Song {
    final private String name;
    final private String artist;
    final private String id;
    final private String genre;

    public Song(String name, String artist, String id, String genre) {
        this.name = name;
        this.artist = artist;
        this.id = id;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }
}
