package use_case.create_playlist;


import java.util.Set;

public class CreatePlaylistInteractor implements CreatePlaylistInputBoundary{
    final CreatePlaylistOutputBoundary createPlaylistPresenter;

    public CreatePlaylistInteractor(CreatePlaylistOutputBoundary createPlaylistOutputBoundary){
        this.createPlaylistPresenter = createPlaylistOutputBoundary;
    }
    @Override
    public void execute(CreatePlaylistInputData createPlaylistInputData) {
        createPlaylistPresenter.prepareSuccessView();
    }
}
