package app;

import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylistFactory;
import entity.PlaylistFactory;
import entity.CommonSongFactory;
import entity.SongFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import view.HomepageView;

import java.io.IOException;

public class HomepageUseCaseFactory {
    private HomepageUseCaseFactory(){}

    public static HomepageView create(ViewManagerModel viewManagerModel,
                                      HomepageViewModel homepageViewModel,
                                      CreatePlaylistViewModel createPlaylistViewModel,
                                      SearchViewModel searchViewModel,
                                      FilePlaylistDataAccessObject fileDataAccessObject){
        try{
        SearchController searchController = createSearchUseCase(viewManagerModel, homepageViewModel, searchViewModel, fileDataAccessObject);
        return new HomepageView(homepageViewModel, createPlaylistViewModel, searchController, viewManagerModel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static SearchController createSearchUseCase(
            ViewManagerModel viewManagerModel,
            HomepageViewModel homepageViewModel,
            SearchViewModel searchViewModel,
            FilePlaylistDataAccessObject filePlaylistDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SearchOutputBoundary searchOutPutBoundary = new SearchPresenter(viewManagerModel, homepageViewModel, searchViewModel);
        //TODO: Why are we making factories here?
        PlaylistFactory playlistFactory = new CommonPlaylistFactory();
        SongFactory songFactory = new CommonSongFactory();

        SearchInputBoundary searchInteractor = new SearchInteractor(filePlaylistDataAccessObject, searchOutPutBoundary);
        return new SearchController(searchInteractor);
    }
}
