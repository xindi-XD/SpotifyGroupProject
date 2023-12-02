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
    public void prepareSuccessSongView(SearchOutputData songs) {
        // On success, switch to the search view.
        LocalDateTime responseTime = LocalDateTime.parse(songs.getCreationTime());
        songs.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        SearchState searchState = searchViewModel.getState();
        searchState.setSongResult(songs.getSongs());
        this.searchViewModel.setState(searchState);
        // searchState has a list of song objects. It also has a method getSongNames() return an ArrayList<String> of song names.
        this.searchViewModel.setFiveSongLabels(searchState.getSongNames());
        searchViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessArtistView(SearchOutputData artists){
        LocalDateTime responseTime = LocalDateTime.parse(artists.getCreationTime());
        artists.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        SearchState searchState = searchViewModel.getState();
        searchState.setArtistResult(artists.getArtists());
        this.searchViewModel.setState(searchState);
        // searchState has a list of song objects. It also has a method getSongNames() return an ArrayList<String> of song names.
        this.searchViewModel.setFiveArtistLabels(searchState.getArtistNames());
        searchViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
