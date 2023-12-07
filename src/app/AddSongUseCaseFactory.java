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
import view.AddSongView;
import view.GetStatsView;

/**
 * Use case factory for add song use case.
 * @author EEK
 */
public class AddSongUseCaseFactory {
    private AddSongUseCaseFactory(){}

    /**
     * Creates a new AddSongView instance for a call to the add song use case.
     * @param viewManagerModel view manager to switch between the get statistics and add song view
     * @param getStatsViewModel the get statistics view model that the use case was called from
     * @param addSongViewModel the add song view model that is to be opened
     * @return an AddSongView object containing all relevant view models
     */
    public static AddSongView create(ViewManagerModel viewManagerModel,
                                      GetStatsViewModel getStatsViewModel,
                                      AddSongViewModel addSongViewModel){
        return new AddSongView(addSongViewModel, getStatsViewModel, viewManagerModel);
    }

}
