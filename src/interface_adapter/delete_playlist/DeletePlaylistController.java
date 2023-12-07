package interface_adapter.delete_playlist;

import use_case.delete_playlist.DeletePlaylistInputBoundary;
import use_case.delete_playlist.DeletePlaylistInputData;

public class DeletePlaylistController {
    final DeletePlaylistInputBoundary deletePlaylistInteractor;

    public DeletePlaylistController(DeletePlaylistInputBoundary deletePlaylistInteractor) {
        this.deletePlaylistInteractor = deletePlaylistInteractor;
    }

    public void execute(String name) {
        DeletePlaylistInputData deletePlaylistInputData = new DeletePlaylistInputData(name);
        deletePlaylistInteractor.execute(deletePlaylistInputData);
    }
}
