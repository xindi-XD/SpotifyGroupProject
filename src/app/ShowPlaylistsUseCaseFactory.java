package app;

import entity.CommonPlaylistFactory;
import entity.PlaylistFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.show_playlists.ShowPlaylistsController;
import interface_adapter.show_playlists.ShowPlaylistsPresenter;
import interface_adapter.show_playlists.ShowPlaylistsViewModel;
import interface_adapter.show_songs.ShowSongsViewModel;
import use_case.show_playlists.ShowPlaylistsDataAccessInterface;
import use_case.show_playlists.ShowPlaylistsInputBoundary;
import use_case.show_playlists.ShowPlaylistsInteractor;
import use_case.show_playlists.ShowPlaylistsOutputBoundary;
import view.ShowPlaylistsView;

public class ShowPlaylistsUseCaseFactory {
    private ShowPlaylistsUseCaseFactory(){}
    public static ShowPlaylistsView create(ViewManagerModel viewManagerModel,
                                           HomepageViewModel homepageViewModel,
                                           ShowPlaylistsViewModel showPlaylistsViewModel,
                                           ShowPlaylistsDataAccessInterface showPlaylistsDataAccessObject,
                                           ShowSongsViewModel showSongsViewModel) {

//        try {
        ShowPlaylistsController showPlaylistsController = createShowPlaylistsUseCase(viewManagerModel, showPlaylistsViewModel, homepageViewModel, showPlaylistsDataAccessObject);
        return new ShowPlaylistsView(showPlaylistsViewModel, viewManagerModel, homepageViewModel, showPlaylistsController, showSongsViewModel);
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
}
