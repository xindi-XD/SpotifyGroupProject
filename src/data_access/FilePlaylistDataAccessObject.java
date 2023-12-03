package data_access;

import entity.Playlist;
import entity.PlaylistFactory;
import org.json.JSONObject;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;
import use_case.delete_playlist.DeletePlaylistDataAccessInterface;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class FilePlaylistDataAccessObject implements CreatePlaylistDataAccessInterface, DeletePlaylistDataAccessInterface {

    private final String jsonPath;
    private final Map<String, Playlist> playlists = new HashMap<>();
    private final PlaylistFactory playlistFactory;

    public FilePlaylistDataAccessObject(String jsonPath, PlaylistFactory playlistFactory) throws IOException {
        this.playlistFactory = playlistFactory;
        this.jsonPath = jsonPath;
    }

    @Override
    public boolean existsPlaylistName(String name) {
        return playlists.containsKey(name);
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

    public void delete(String playlistName) {
        try {
            int dialogResult = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to say good by to " + playlistName + "?");
            if (dialogResult == JOptionPane.YES_OPTION) {
                playlists.remove(playlistName);
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e);
        }

        this.save();
    }
}
