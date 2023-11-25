package app;

import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylist;
import entity.CommonPlaylistFactory;
import entity.Playlist;
import entity.PlaylistFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutPutBoundary;
import view.HomepageView;

public class HomepageUseCaseFactory {
    private HomepageUseCaseFactory(){}

    public static HomepageView create(ViewManagerModel viewManagerModel,
                                      HomepageViewModel homepageViewModel,
                                      CreatePlaylistViewModel createPlaylistViewModel,
                                      FilePlaylistDataAccessObject fileDataAccessObject){
        SearchController searchController = createSearchUseCase(viewManagerModel, homepageViewModel, fileDataAccessObject);
        //TODO: Try() not implemented. searchViewModel not implemented.
        return new HomepageView(homepageViewModel, createPlaylistViewModel, searchController, viewManagerModel);
    }

    private static SearchController createSearchUseCase(
            ViewManagerModel viewManagerModel,
            HomepageViewModel homepageViewModel,
            FilePlaylistDataAccessObject filePlaylistDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SearchOutPutBoundary searchOutPutBoundary = new SearchPresenter(viewManagerModel, homepageViewModel, searchViewModel);
        PlaylistFactory playistFactory = new CommonPlaylistFactory();
//        SongFactory songFactory = new CommonSongFactory(); TODO: CommonSongFactory not found.

        SearchInputBoundary searchInteractor = new SearchInteractor(filePlaylistDataAccessObject, searchOutPutBoundary);
        return new SearchController(searchInteractor);
    }
}
