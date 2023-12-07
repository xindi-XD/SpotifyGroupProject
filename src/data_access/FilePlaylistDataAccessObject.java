package data_access;

import entity.Playlist;
import entity.PlaylistFactory;
import org.json.JSONObject;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;
import use_case.delete_playlist.DeletePlaylistDataAccessInterface;
import use_case.show_playlists.ShowPlaylistsDataAccessInterface;
import use_case.show_songs.ShowSongsDataAccessInterface;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class FilePlaylistDataAccessObject implements CreatePlaylistDataAccessInterface, DeletePlaylistDataAccessInterface,
        ShowPlaylistsDataAccessInterface, ShowSongsDataAccessInterface {

    private final String jsonPath;
    private final Map<String, Playlist> playlists = new HashMap<>();
    private final PlaylistFactory playlistFactory;

    public FilePlaylistDataAccessObject(String jsonPath, PlaylistFactory playlistFactory) {
        this.playlistFactory = playlistFactory;
        this.jsonPath = jsonPath;
    }

    public Map<String, Playlist> getPlaylists() {
        return playlists;
    }

    @Override
    public boolean existsPlaylistName(String name) {
        return playlists.containsKey(name);
    }

    @Override
    public boolean noExistsSongs(String name) {
        return playlists.get(name).getLength() == 0;
    }

    @Override
    public Map<String, String[]> getSongs(String name) {
        return playlists.get(name).getSong();
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
            playlists.remove(playlistName);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e);
        }

        this.save();
    }
}
