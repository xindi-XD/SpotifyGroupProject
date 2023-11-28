package data_access;

import entity.CommonPlaylist;
import entity.CommonPlaylistFactory;
import entity.Playlist;
import entity.PlaylistFactory;
import org.json.JSONObject;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Todo: needs to figure out how to store data into a json file.
public class FilePlaylistDataAccessObject implements CreatePlaylistDataAccessInterface {

    private JSONObject jsonFile;

    private final String jsonPath;
    private final Map<String, CommonPlaylist> playlists = new HashMap<>();
    private PlaylistFactory playlistFactory;

    public FilePlaylistDataAccessObject(String jsonPath, PlaylistFactory playlistFactory) throws IOException {
        this.playlistFactory = playlistFactory;
        this.jsonPath = jsonPath;
    }

    @Override
    public void save(CommonPlaylist playlist) {
        playlists.put(playlist.getName(), playlist);
        this.save();
    }

    private void save() {
        try {
            jsonFile = new JSONObject();
            FileWriter file = new FileWriter(jsonPath);
            for (CommonPlaylist commonPlaylist : playlists.values()) {
                jsonFile.put(commonPlaylist.getName(), commonPlaylist);
            }

//            jsonFile.put("dc", new CommonPlaylistFactory());
//            jsonFile.put("cd", new CommonPlaylistFactory());
            file.write(jsonFile.toString());
            file.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
