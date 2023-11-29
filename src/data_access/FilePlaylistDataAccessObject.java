package data_access;

import entity.Playlist;
import entity.PlaylistFactory;
import org.json.JSONObject;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FilePlaylistDataAccessObject implements CreatePlaylistDataAccessInterface {

    private final String jsonPath;
    private final Map<String, Playlist> playlists = new HashMap<>();
    private final PlaylistFactory playlistFactory;

    public FilePlaylistDataAccessObject(String jsonPath, PlaylistFactory playlistFactory) throws IOException {
        this.playlistFactory = playlistFactory;
        this.jsonPath = jsonPath;
    }

    @Override
    public void save(Playlist playlist) {
        playlists.put(playlist.getName(), playlist);
        this.save();
    }

    private void save() {
        try {
            JSONObject jsonFile = new JSONObject();
            FileWriter file = new FileWriter(jsonPath);
            for (Playlist playlist : playlists.values()) {
                jsonFile.put(playlist.getName(), playlist);
            }
            file.write(jsonFile.toString());
            file.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
