package data_access;

import entity.CommonPlaylist;
import entity.PlaylistFactory;
import org.json.JSONObject;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

// Todo: needs to figure out how to store data into a json file.
public class FilePlaylistDataAccessObject implements CreatePlaylistDataAccessInterface {

    private final JSONObject jsonFile;
    private final Map<String, CommonPlaylist> playlists = new HashMap<>();
    private PlaylistFactory playlistFactory;

    public FilePlaylistDataAccessObject(String jsonPath, PlaylistFactory playlistFactory) {
        this.playlistFactory = playlistFactory;

        jsonFile = new JSONObject(jsonPath);

        if (jsonFile.length() == 0) {
            save();
        }
    }

    @Override
    public void save(CommonPlaylist playlist) {
        playlists.put(playlist.getName(), playlist);
        this.save();
    }

    private void save() {}
}
