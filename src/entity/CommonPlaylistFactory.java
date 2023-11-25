package entity;

public class CommonPlaylistFactory implements PlaylistFactory{
    @Override
    public Playlist create(String name) {
        return new CommonPlaylist(name);
    }
}
