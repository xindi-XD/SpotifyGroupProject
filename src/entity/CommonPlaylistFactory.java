package entity;

public class CommonPlaylistFactory implements PlaylistFactory{
    @Override
    public CommonPlaylist create(String name) {
        return new CommonPlaylist(name);
    }
}
