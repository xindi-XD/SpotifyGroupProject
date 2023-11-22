package data_access;

import entity.Playlist;
import org.json.JSONObject;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;

public class FilePlaylistDataAccessObject implements CreatePlaylistDataAccessInterface {

    private final JSONObject jsonFile;

    public FilePlaylistDataAccessObject(String jsonPath) {
        jsonFile = new JSONObject(jsonPath);
    }

    @Override
    public void createPlaylist(Playlist playlist) {

    }
}
