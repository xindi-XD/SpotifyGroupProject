package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageViewModel;
import use_case.search.SearchOutputBoundary;

public class SearchPresenter implements SearchOutputBoundary {
    private ViewManagerModel viewManagerModel;
    private final HomepageViewModel homepageViewModel;
    private final SearchViewModel searchViewModel;
    public SearchPresenter(ViewManagerModel viewManagerModel,
                           HomepageViewModel homepageViewModel,
                           SearchViewModel searchViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homepageViewModel = homepageViewModel;
        this.searchViewModel = searchViewModel;
    }
}
