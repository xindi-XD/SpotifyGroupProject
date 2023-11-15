package entity;

public class PlaylistFactory {
    public Playlist create(String name, String id) {
        return new Playlist(name, id);
    }
}
