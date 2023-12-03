package app;

import data_access.APIDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.get_song_stats.GetStatsController;
import interface_adapter.get_song_stats.GetStatsPresenter;
import interface_adapter.get_song_stats.GetStatsViewModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchViewModel;
import use_case.get_song_stats.GetStatsInputBoundary;
import use_case.get_song_stats.GetStatsInteractor;
import use_case.get_song_stats.GetStatsOutputBoundary;
import use_case.get_song_stats.GetStatsOutputData;
import view.HomepageView;
import view.SearchView;

import java.io.IOException;

public class SearchUseCaseFactory {
    private SearchUseCaseFactory(){}
    // addsong usecase controller gets put in here
    //and getStats use case!

    public static SearchView create(ViewManagerModel viewManagerModel,
                                    HomepageViewModel homepageViewModel,
                                    SearchViewModel searchViewModel,
                                    GetStatsViewModel getStatsViewModel,
                                    APIDataAccessObject apiDataAccessObject){
        GetStatsController getStatsController = createGetStatsUseCase(viewManagerModel,
                getStatsViewModel, apiDataAccessObject);
        return new SearchView(searchViewModel, homepageViewModel, viewManagerModel, getStatsController);
    }

    private static GetStatsController createGetStatsUseCase(ViewManagerModel viewManagerModel,
                                                            GetStatsViewModel getStatsViewModel,
                                                            APIDataAccessObject apiDataAccessObject) {
        GetStatsOutputBoundary getStatsOutputBoundary = new GetStatsPresenter(viewManagerModel, getStatsViewModel);
        GetStatsInputBoundary getStatsInteractor = new GetStatsInteractor(apiDataAccessObject, getStatsOutputBoundary);
        return new GetStatsController(getStatsInteractor);
    }
}
