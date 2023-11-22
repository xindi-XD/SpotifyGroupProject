package use_case.create_playlist;


import entity.Playlist;

import java.util.Set;

public class CreatePlaylistInteractor implements CreatePlaylistInputBoundary{
    final CreatePlaylistDataAccessInterface createPlaylistDataAccessObject;
    final CreatePlaylistOutputBoundary createPlaylistPresenter;

    public CreatePlaylistInteractor(CreatePlaylistDataAccessInterface createPlaylistDataAccessInterface,
                                     CreatePlaylistOutputBoundary createPlaylistOutputBoundary){
        this.createPlaylistDataAccessObject = createPlaylistDataAccessInterface;
        this.createPlaylistPresenter = createPlaylistOutputBoundary;
    }
    @Override
    public void execute(CreatePlaylistInputData createPlaylistInputData) {
        String playlistName = createPlaylistInputData.getName();
        Playlist newPlaylist = new Playlist(playlistName);
        createPlaylistDataAccessObject.save(newPlaylist);

//        createPlaylistPresenter.prepareSuccessView();
    }
}
