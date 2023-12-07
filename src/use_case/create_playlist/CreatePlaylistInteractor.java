package use_case.create_playlist;


import entity.CommonPlaylist;
import entity.Playlist;
import entity.PlaylistFactory;

import java.util.Objects;

public class CreatePlaylistInteractor implements CreatePlaylistInputBoundary{
    final CreatePlaylistDataAccessInterface createPlaylistDataAccessObject;
    final CreatePlaylistOutputBoundary createPlaylistPresenter;
    final PlaylistFactory playlistFactory;

    public CreatePlaylistInteractor(CreatePlaylistDataAccessInterface createPlaylistDataAccessInterface,
                                     CreatePlaylistOutputBoundary createPlaylistOutputBoundary,
                                    PlaylistFactory playlistFactory){
        this.createPlaylistDataAccessObject = createPlaylistDataAccessInterface;
        this.createPlaylistPresenter = createPlaylistOutputBoundary;
        this.playlistFactory = playlistFactory;
    }
    @Override
    public void execute(CreatePlaylistInputData createPlaylistInputData) {
        if (createPlaylistInputData.getName() == null || createPlaylistInputData.getName().length() <= 1) {
            createPlaylistPresenter.prepareFailView("The playlist name can't be empty");
        }
        else if (createPlaylistDataAccessObject.existsPlaylistName(createPlaylistInputData.getName())) {
            createPlaylistPresenter.prepareFailView("The playlist has already been created");
        }
        else {
            String playlistName = createPlaylistInputData.getName();
            String playlistDes = createPlaylistInputData.getDescription();
            Playlist newPlaylist = playlistFactory.create(playlistName, playlistDes);
            createPlaylistDataAccessObject.save(newPlaylist);

            String newPlaylistName = newPlaylist.getName();
            String newPlaylistDes = newPlaylist.getDescription();
            CreatePlaylistOutputData createPlaylistOutputData = new CreatePlaylistOutputData(newPlaylistName, newPlaylistDes);
            createPlaylistPresenter.prepareSuccessView(createPlaylistOutputData);
        }
    }
}
