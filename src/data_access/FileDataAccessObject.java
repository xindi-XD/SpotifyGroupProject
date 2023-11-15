package data_access;

import use_case.create_playlist.CreatePlaylistDataAccessInterface;
import use_case.delete_playlist.DeletePlaylistDataAccessInterface;

public class FileDataAccessObject implements CreatePlaylistDataAccessInterface, DeletePlaylistDataAccessInterface {

    @Override
    public void create(String name) {

    }

    @Override
    public void delete(String name) {

    }
}
