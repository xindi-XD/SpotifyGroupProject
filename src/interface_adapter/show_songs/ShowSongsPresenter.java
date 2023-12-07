package interface_adapter.show_songs;

import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageViewModel;
import use_case.show_songs.ShowSongsOutputBoundary;
import use_case.show_songs.ShowSongsOutputData;

public class ShowSongsPresenter implements ShowSongsOutputBoundary {
    final ViewManagerModel viewManagerModel;
    final HomepageViewModel homepageViewModel;
    final ShowSongsViewModel showSongsViewModel;
    public ShowSongsPresenter(ViewManagerModel viewManagerModel, HomepageViewModel homepageViewModel,
                              ShowSongsViewModel showSongsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homepageViewModel = homepageViewModel;
        this.showSongsViewModel = showSongsViewModel;
    }

    @Override
    public void prepareSuccessView(ShowSongsOutputData songs) {

    }

    @Override
    public void prepareFailView(String error) {
        ShowSongsState state = showSongsViewModel.getState();
        state.setNoSongsError(error);
        showSongsViewModel.firePropertyChanged();
    }
}
