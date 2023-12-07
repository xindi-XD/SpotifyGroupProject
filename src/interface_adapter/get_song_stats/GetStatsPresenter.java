package interface_adapter.get_song_stats;

import entity.CommonSongFactory;
import entity.Song;
import entity.SongFactory;
import interface_adapter.ViewManagerModel;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.get_song_stats.GetStatsOutputBoundary;
import use_case.get_song_stats.GetStatsOutputData;

import javax.swing.*;
import java.util.HashMap;

public class GetStatsPresenter implements GetStatsOutputBoundary {
    private final ViewManagerModel viewManager;
    private final GetStatsViewModel viewModel;

    public GetStatsPresenter(ViewManagerModel manager, GetStatsViewModel getStatsViewModel) {
        this.viewManager = manager;
        this.viewModel = getStatsViewModel;
    }

    @Override
    public void prepareFailView(String e) {
        GetStatsState state = viewModel.getState();
        state.setInfoError(e);
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(GetStatsOutputData response) {
        GetStatsState state = viewModel.getState();
        state.setSongId(response.getId());
        state.setSongName(response.getName());
        state.setArtistName(response.getArtists());
        state.setReleaseDate(response.getReleaseDate());
        state.setFeatures(response.getFeatures());
        state.setPlaylistNames(response.getPlaylistnames());

        this.viewModel.setSongInformation(state.getSongName(), state.getArtistName(), state.getReleaseDate(),
                state.getFeatures());
        viewModel.setState(state);
        viewModel.firePropertyChanged();

        viewManager.setActiveView(viewModel.getViewName());
        viewManager.firePropertyChanged();
    }
}
