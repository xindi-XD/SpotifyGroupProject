package data_access;

import entity.Playlist;
import org.json.JSONObject;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;

public class FilePlaylistDataAccessObject implements CreatePlaylistDataAccessInterface {

    private final JSONObject jsonfile;

    public FilePlaylistDataAccessObject(String jsonPath) {
        this.jsonfile = new JSONObject(jsonPath);
    }

    @Override
    public void save(Playlist playlist) {

    }
}
