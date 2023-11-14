package entity;

public class PlaylistFactory {
    public SinglePlaylist create(String name, String id) {
        return new SinglePlaylist(name, id);
    }
}
