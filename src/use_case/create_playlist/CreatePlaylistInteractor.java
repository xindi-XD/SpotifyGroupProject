package use_case.create_playlist;

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
        createPlaylistPresenter.prepareSuccessView();
    }
}