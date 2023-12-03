package entity;

public class CommonSong implements Song {
    final private String name;
    final private String[] artist;
    final private String[] genres;
    final private String id;

    public CommonSong(String name, String[] artist, String[] genres, String id) {
        this.name = name;
        this.id = id;
        this.genres = genres;
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

    public String[] getGenres() {return genres;}

    @Override
    public String getID() {return id;
    }


}
