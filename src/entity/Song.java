package entity;

public class Song {
    private String name;
    private String artist;
    private int id;
    private String genre;

    public Song(String name, String artist, int id, String genre) {
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

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }
}
