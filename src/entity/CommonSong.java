package entity;

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

    @Override
    public String getID() {return id;}


}
