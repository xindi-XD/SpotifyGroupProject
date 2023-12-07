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

public class AddSongUseCaseFactory {
    private AddSongUseCaseFactory(){}

    public static AddSongView create(ViewManagerModel viewManagerModel,
                                      GetStatsViewModel getStatsViewModel,
                                      AddSongViewModel addSongViewModel){
        return new AddSongView(addSongViewModel, getStatsViewModel, viewManagerModel);
    }

}
