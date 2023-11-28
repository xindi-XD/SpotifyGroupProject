package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageViewModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Override
    public void prepareFailView(String s) {

    }

    @Override
    public void prepareSuccessView(SearchOutputData response) {
        // On success, switch to the search view.
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        SearchState searchState = searchViewModel.getState();
        searchState.setResult(response.getSongs());
        this.searchViewModel.setState(searchState);
        searchViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
