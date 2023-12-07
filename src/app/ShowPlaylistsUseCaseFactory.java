package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.show_playlists.ShowPlaylistsController;
import interface_adapter.show_playlists.ShowPlaylistsPresenter;
import interface_adapter.show_playlists.ShowPlaylistsViewModel;
import interface_adapter.show_songs.ShowSongsController;
import interface_adapter.show_songs.ShowSongsPresenter;
import interface_adapter.show_songs.ShowSongsViewModel;
import use_case.show_playlists.ShowPlaylistsDataAccessInterface;
import use_case.show_playlists.ShowPlaylistsInputBoundary;
import use_case.show_playlists.ShowPlaylistsInteractor;
import use_case.show_playlists.ShowPlaylistsOutputBoundary;
import use_case.show_songs.ShowSongsDataAccessInterface;
import use_case.show_songs.ShowSongsInputBoundary;
import use_case.show_songs.ShowSongsInteractor;
import use_case.show_songs.ShowSongsOutputBoundary;
import view.ShowPlaylistsView;

public class ShowPlaylistsUseCaseFactory {
    private ShowPlaylistsUseCaseFactory(){}
    public static ShowPlaylistsView create(ViewManagerModel viewManagerModel,
                                           HomepageViewModel homepageViewModel,
                                           ShowPlaylistsViewModel showPlaylistsViewModel,
                                           ShowPlaylistsDataAccessInterface showPlaylistsDataAccessObject,
                                           ShowSongsViewModel showSongsViewModel,
                                           ShowSongsDataAccessInterface showSongsDataAccessObject) {

//        try {
        ShowPlaylistsController showPlaylistsController = createShowPlaylistsUseCase(viewManagerModel, showPlaylistsViewModel, homepageViewModel, showPlaylistsDataAccessObject);
        ShowSongsController showSongsController = createShowSongsUseCase(viewManagerModel, showSongsViewModel, homepageViewModel, showSongsDataAccessObject);
        return new ShowPlaylistsView(showPlaylistsViewModel, viewManagerModel, homepageViewModel, showPlaylistsController, showSongsController);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open user data file.");
//        }
//        return null;
    }

    private static ShowPlaylistsController createShowPlaylistsUseCase(
            ViewManagerModel viewManagerModel,
            ShowPlaylistsViewModel showPlaylistsViewModel,
            HomepageViewModel homepageViewModel, ShowPlaylistsDataAccessInterface showPlaylistsDataAccessObject){

        // Notice how we pass this method's parameters to the Presenter.
        ShowPlaylistsOutputBoundary showPlaylistsOutputBoundary = new ShowPlaylistsPresenter(viewManagerModel, homepageViewModel, showPlaylistsViewModel);
        ShowPlaylistsInputBoundary showPlaylistsInteractor = new ShowPlaylistsInteractor(showPlaylistsDataAccessObject, showPlaylistsOutputBoundary);
        return new ShowPlaylistsController(showPlaylistsInteractor);
    }

    private static ShowSongsController createShowSongsUseCase(
            ViewManagerModel viewManagerModel, ShowSongsViewModel showSongsViewModel,
            HomepageViewModel homepageViewModel, ShowSongsDataAccessInterface showSongsDataAccessObject) {
        ShowSongsOutputBoundary showSongsOutputBoundary = new ShowSongsPresenter(viewManagerModel, homepageViewModel, showSongsViewModel);
        ShowSongsInputBoundary showSongsInteractor = new ShowSongsInteractor(showSongsOutputBoundary, showSongsDataAccessObject);
        return new ShowSongsController(showSongsInteractor);
    }
}
