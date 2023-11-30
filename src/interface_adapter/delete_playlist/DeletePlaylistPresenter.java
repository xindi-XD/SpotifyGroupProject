package interface_adapter.delete_playlist;

import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageViewModel;
import use_case.delete_playlist.DeletePlaylistOutputBoundary;
import use_case.delete_playlist.DeletePlaylistOutputData;

import javax.swing.*;

public class DeletePlaylistPresenter implements DeletePlaylistOutputBoundary {
    private final DeletePlaylistViewModel deletePlaylistViewModel;
    private final HomepageViewModel homepageViewModel;
    private ViewManagerModel viewManagerModel;

    public DeletePlaylistPresenter(DeletePlaylistViewModel deletePlaylistViewModel,
                                   HomepageViewModel homepageViewModel,
                                   ViewManagerModel viewManagerModel) {
        this.deletePlaylistViewModel = deletePlaylistViewModel;
        this.homepageViewModel = homepageViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DeletePlaylistOutputData playlistName) {
        DeletePlaylistState deletePlaylistState = deletePlaylistViewModel.getDeletePlaylistState();
        deletePlaylistState.setPlaylistName(playlistName.getName());
        this.deletePlaylistViewModel.setState(deletePlaylistState);
        homepageViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(homepageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        JOptionPane.showMessageDialog(null,
                playlistName.getName() + " says good bye.\n");
    }
}
