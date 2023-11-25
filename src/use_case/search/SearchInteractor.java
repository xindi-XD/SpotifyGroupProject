package use_case.search;

import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.search.SearchViewModel;

public class SearchInteractor implements SearchInputBoundary {
    final SearchPlaylistDataAccessInterface searchPlaylistDataAccessObject;
    //TODO: song and playlist are not distinguished.
    final SearchOutputBoundary searchPresenter;

    public SearchInteractor(SearchPlaylistDataAccessInterface searchPlaylistDataAccessInterface,
                           SearchOutputBoundary searchOutputBoundary) {
        this.searchPlaylistDataAccessObject = searchPlaylistDataAccessInterface;
        this.searchPresenter = searchOutputBoundary;
    }
}
