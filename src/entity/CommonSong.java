package entity;

public class CommonSong implements Song {
    final private String name;
    final private String[] artist;
    final private String releaseDate;
    final private String id;

    public CommonSong(String name, String[] artist, String releaseDate, String id) {
        this.name = name;
        this.id = id;
        this.releaseDate = releaseDate;
        this.artist = artist;
    }

    @Override
    // TODO: method body is not implemented.
    public boolean likeSong(CommonSong song) {
        return false;
    }

    @Override
    // TODO: method body is not implemented.
    public boolean unlikeSong(CommonSong song) {
        return false;
    }

    public String getName() {
        return name;
    }


    public String[] getArtist() {
        return artist;
    }

    public String getReleaseDate() {return releaseDate;}

    @Override
    public String getID() {return id;}


}
