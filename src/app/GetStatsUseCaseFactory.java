package app;

import data_access.FilePlaylistDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_song.AddSongController;
import interface_adapter.add_song.AddSongPresenter;
import interface_adapter.add_song.AddSongViewModel;
import interface_adapter.get_song_stats.GetStatsViewModel;
import interface_adapter.search.SearchViewModel;
import use_case.add_song.AddSongInputBoundary;
import use_case.add_song.AddSongInteractor;
import use_case.add_song.AddSongOutputBoundary;
import view.GetStatsView;

/**
 * Use case factory for the get stats use case.
 * @author EEK
 */
public class GetStatsUseCaseFactory {
    private GetStatsUseCaseFactory(){}

    public static GetStatsView create(ViewManagerModel viewManagerModel,
                                      AddSongViewModel addSongViewModel,
                                      SearchViewModel searchViewModel,
                                       GetStatsViewModel getStatsViewModel,
                                      FilePlaylistDataAccessObject filePlaylistDataAccessObject){
        AddSongController addSongController = createAddSongUseCase(viewManagerModel, addSongViewModel, filePlaylistDataAccessObject);
        return new GetStatsView(getStatsViewModel, viewManagerModel, searchViewModel, addSongController);
    }
    private static AddSongController createAddSongUseCase(ViewManagerModel viewManagerModel, AddSongViewModel addSongViewModel,
                                                            FilePlaylistDataAccessObject filePlaylistDataAccessObject) {
        AddSongOutputBoundary addSongOutputBoundary = new AddSongPresenter(viewManagerModel, addSongViewModel);
        AddSongInputBoundary addSongInteractor = new AddSongInteractor(filePlaylistDataAccessObject, addSongOutputBoundary);
        return new AddSongController(addSongInteractor);
    }
}
