package entity;

public interface SongFactory {
    CommonSong create(String name, String artist, String id, String genre);
}