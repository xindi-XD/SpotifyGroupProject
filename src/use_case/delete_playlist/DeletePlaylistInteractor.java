package use_case.delete_playlist;

import entity.PlaylistFactory;

public class DeletePlaylistInteractor implements DeletePlaylistInputBoundary {
    final DeletePlaylistDataAccessInterface deletePlaylistDataAccessObject;
    final DeletePlaylistOutputBoundary deletePlaylistPresenter;

    public DeletePlaylistInteractor(DeletePlaylistDataAccessInterface deletePlaylistDataAccessInterface,
                                    DeletePlaylistOutputBoundary deletePlaylistOutputBoundary) {
        this.deletePlaylistDataAccessObject = deletePlaylistDataAccessInterface;
        this.deletePlaylistPresenter = deletePlaylistOutputBoundary;
    }
    @Override
    public void execute(DeletePlaylistInputData deletePlaylistInputData) {
        String playlistName = deletePlaylistInputData.getName();
        deletePlaylistDataAccessObject.delete(playlistName);

        DeletePlaylistOutputData deletePlaylistOutputData = new DeletePlaylistOutputData(playlistName);
        deletePlaylistPresenter.prepareSuccessView(deletePlaylistOutputData);
    }
}
