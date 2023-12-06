package app;

import data_access.APIDataAccessObject;
import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylistFactory;
import entity.PlaylistFactory;
import entity.CommonSongFactory;
import entity.SongFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import interface_adapter.show_playlists.ShowPlaylistsController;
import interface_adapter.show_playlists.ShowPlaylistsPresenter;
import interface_adapter.show_playlists.ShowPlaylistsViewModel;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchAPIDataAccessInterface;
import use_case.show_playlists.ShowPlaylistsInputBoundary;
import use_case.show_playlists.ShowPlaylistsInteractor;
import use_case.show_playlists.ShowPlaylistsOutputBoundary;
import view.HomepageView;

import javax.swing.text.View;
import java.io.File;
import java.io.IOException;

public class HomepageUseCaseFactory {
    private HomepageUseCaseFactory(){}

    public static HomepageView create(ViewManagerModel viewManagerModel,
                                      HomepageViewModel homepageViewModel,
                                      CreatePlaylistViewModel createPlaylistViewModel,
                                      DeletePlaylistViewModel deletePlaylistViewModel,
                                      ShowPlaylistsViewModel showPlaylistsViewModel,
                                      SearchViewModel searchViewModel,
                                      APIDataAccessObject apiDataAccessObject,
                                      FilePlaylistDataAccessObject filePlaylistDataAccessObject){
        try{
        SearchController searchController = createSearchUseCase(viewManagerModel, homepageViewModel, searchViewModel, apiDataAccessObject);
        ShowPlaylistsController showPlaylistsController = createShowPlaylistsUseCase(viewManagerModel, homepageViewModel, showPlaylistsViewModel, filePlaylistDataAccessObject);
        return new HomepageView(homepageViewModel, createPlaylistViewModel, searchController, viewManagerModel, deletePlaylistViewModel,
                showPlaylistsViewModel, showPlaylistsController);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static SearchController createSearchUseCase(
            ViewManagerModel viewManagerModel,
            HomepageViewModel homepageViewModel,
            SearchViewModel searchViewModel,
            SearchAPIDataAccessInterface apiDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SearchOutputBoundary searchOutPutBoundary = new SearchPresenter(viewManagerModel, homepageViewModel, searchViewModel);
        //TODO: Why are we making factories here?
        PlaylistFactory playlistFactory = new CommonPlaylistFactory();
        SongFactory songFactory = new CommonSongFactory();

        SearchInputBoundary searchInteractor = new SearchInteractor(apiDataAccessObject, searchOutPutBoundary);
        return new SearchController(searchInteractor);
    }

    private static ShowPlaylistsController createShowPlaylistsUseCase(
            ViewManagerModel viewManagerModel,
            HomepageViewModel homepageViewModel,
            ShowPlaylistsViewModel showPlaylistsViewModel,
            FilePlaylistDataAccessObject filePlaylistDataAccessObject) throws IOException {
        ShowPlaylistsOutputBoundary showPlaylistsPresenter = new ShowPlaylistsPresenter(viewManagerModel, homepageViewModel, showPlaylistsViewModel);

        ShowPlaylistsInputBoundary showPlaylistsInteractor = new ShowPlaylistsInteractor(filePlaylistDataAccessObject, showPlaylistsPresenter);
        return new ShowPlaylistsController(showPlaylistsInteractor);
    }
}
