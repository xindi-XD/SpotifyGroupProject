import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylist;
import entity.CommonPlaylistFactory;
import entity.Playlist;
import entity.PlaylistFactory;
import org.junit.Test;

import java.io.IOException;

public class CreatePlaylistTest {
    @Test
    public void testCreatePlaylistSuccessfully() {
        PlaylistFactory playlistFactory = new CommonPlaylistFactory();
        FilePlaylistDataAccessObject dao;
//        try {
//            dao = new FilePlaylistDataAccessObject("./testPlaylists.json", playlistFactory);
//        }
    }
    @Test
    public void testCreatePlaylistSuccessfullyWithoutDescription() {

    }
    @Test
    public void testEmptyPlaylistName() {

    }
    @Test
    public void testEmptyPlaylistNameWithoutDescription() {

    }
    @Test
    public void testDuplicatePlaylistName() {

    }
    @Test
    public void testDuplicatePlaylistNameWithoutDescription() {

    }
    @Test
    public void testMultiplePlaylistsCreation() {

    }
    @Test
    public void testMultiplePlaylistsCreationWithoutDescription() {

    }
}
