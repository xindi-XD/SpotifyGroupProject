package interface_adapter.create_playlist;

import use_case.create_playlist.CreatePlaylistInputBoundary;
import use_case.create_playlist.CreatePlaylistInputData;

public class CreatePlaylistController {
    final CreatePlaylistInputBoundary createPlaylistInteractor;
    public CreatePlaylistController(CreatePlaylistInputBoundary createPlaylistUseCaseInteractor){
        this.createPlaylistInteractor = createPlaylistUseCaseInteractor;
    }


    public void execute(String name, String description){
        CreatePlaylistInputData createPlaylistInputData = new CreatePlaylistInputData(name, description);
        createPlaylistInteractor.execute(createPlaylistInputData);
    }
}
