package entity;

public interface Song {
    boolean likeSong(CommonSong song);
    boolean unlikeSong(CommonSong song);
    String getName();

    String[] getArtist();

    String getReleaseDate();

    String getID();

}
