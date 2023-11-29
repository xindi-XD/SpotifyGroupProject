package use_case.create_playlist;


import entity.CommonPlaylist;
import entity.Playlist;
import entity.PlaylistFactory;

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
        String playlistName = createPlaylistInputData.getName();
        Playlist newPlaylist = playlistFactory.create(playlistName);
        createPlaylistDataAccessObject.save(newPlaylist);

        String newPlaylistName = newPlaylist.getName();
        CreatePlaylistOutputData createPlaylistOutputData = new CreatePlaylistOutputData(newPlaylistName);
        createPlaylistPresenter.prepareSuccessView(createPlaylistOutputData);
    }
}
