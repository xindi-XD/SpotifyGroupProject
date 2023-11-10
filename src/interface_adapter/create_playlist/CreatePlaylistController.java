package interface_adapter.create_playlist;

import use_case.create_playlist.CreatePlaylistInputBoundary;
import use_case.create_playlist.CreatePlaylistInputData;
import use_case.create_playlist.CreatePlaylistInteractor;

public class CreatePlaylistController {
    final CreatePlaylistInputBoundary createPlaylistInteractor;
    public CreatePlaylistController(CreatePlaylistInputBoundary createPlaylistUseCaseInteractor){
        this.createPlaylistInteractor = createPlaylistUseCaseInteractor;
    }

    public void execute(){
        CreatePlaylistInputData createPlaylistInputData = new CreatePlaylistInputData();
        createPlaylistInteractor.execute(createPlaylistInputData);
    }
}
