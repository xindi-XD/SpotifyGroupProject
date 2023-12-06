package interface_adapter.show_playlists;

import entity.Playlist;
import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageViewModel;
import use_case.show_playlists.ShowPlaylistsOutputBoundary;
import use_case.show_playlists.ShowPlaylistsOutputData;

import java.util.Map;

public class ShowPlaylistsPresenter implements ShowPlaylistsOutputBoundary {
    final ViewManagerModel viewManagerModel;
    final HomepageViewModel homepageViewModel;
    final ShowPlaylistsViewModel showPlaylistsViewModel;
    public ShowPlaylistsPresenter(ViewManagerModel viewManagerModel, HomepageViewModel homepageViewModel,
                                  ShowPlaylistsViewModel showPlaylistsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homepageViewModel = homepageViewModel;
        this.showPlaylistsViewModel = showPlaylistsViewModel;
    }

    @Override
    public void prepareSuccessView(ShowPlaylistsOutputData playlists) {
        ShowPlaylistsState state = showPlaylistsViewModel.getState();
        state.setPlaylistsResult(playlists.getPlaylists());
        this.showPlaylistsViewModel.setState(state);
        this.showPlaylistsViewModel.setPlaylistNameLabels(state.getPlaylistsNames());
        showPlaylistsViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(showPlaylistsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ShowPlaylistsState state = showPlaylistsViewModel.getState();
        state.setPlaylistsError(error);
        showPlaylistsViewModel.firePropertyChanged();
    }
}
