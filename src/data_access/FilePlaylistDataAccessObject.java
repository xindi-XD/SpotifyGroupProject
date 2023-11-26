package data_access;

import entity.CommonPlaylist;
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

    private final JSONObject jsonFile;

    private final FileWriter file;
    private final Map<String, CommonPlaylist> playlists = new HashMap<>();
    private PlaylistFactory playlistFactory;

    public FilePlaylistDataAccessObject(String jsonPath, PlaylistFactory playlistFactory) throws IOException {
        this.playlistFactory = playlistFactory;

        jsonFile = new JSONObject();
        file = new FileWriter(jsonPath);
        if (jsonFile.isEmpty()) {
            Playlist likedSongs = PlaylistFactory.create("Liked Songs");
            jsonFile.put(likedSongs.getName(), likedSongs);
            file.write(jsonFile.toString());
            save();
        }
    }

    @Override
    public void save(CommonPlaylist playlist) {
        playlists.put(playlist.getName(), playlist);
        this.save();
    }

    private void save() {
        try {
            for (CommonPlaylist commonPlaylist : playlists.values()) {
                jsonFile.put(commonPlaylist.getName(), commonPlaylist);
            }

            file.write(jsonFile.toString());
            file.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
