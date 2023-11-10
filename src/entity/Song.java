package entity;

public class Song {
    private String name;
    private String artist;
    private int id;

    public Song(String name, String artist, int id) {
        this.name = name;
        this.artist = artist;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getId() {
        return this.id;
    }
}
