package use_case.delete_playlist;

import entity.PlaylistFactory;

import javax.swing.*;

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
        if (deletePlaylistInputData.getName() == null) {
            deletePlaylistPresenter.prepareFailView("The playlist name can't be empty");
        }
        else if (!deletePlaylistDataAccessObject.existsPlaylistName(deletePlaylistInputData.getName())) {
            deletePlaylistPresenter.prepareFailView("The playlist does not exist");
        }
        else {
            String playlistName = deletePlaylistInputData.getName();
            int dialogResult = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to say good bye to " + playlistName + "?");
            if (dialogResult == JOptionPane.YES_OPTION) {
                deletePlaylistDataAccessObject.delete(playlistName);

                DeletePlaylistOutputData deletePlaylistOutputData = new DeletePlaylistOutputData(playlistName);
                deletePlaylistPresenter.prepareSuccessView(deletePlaylistOutputData);
            } else {deletePlaylistPresenter.prepareFailView("a");}
        }
    }
}
