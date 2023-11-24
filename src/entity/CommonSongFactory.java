package entity;

public class CommonSongFactory implements SongFactory {
    @Override
    public CommonSong create(String name, String artist, String id, String genre) {
        return new CommonSong(name, artist, id, genre);
    }
}
