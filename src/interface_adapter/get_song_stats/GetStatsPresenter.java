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
        JSONObject responseSong = response.getSong();
        Song result = CommonSongFactory.create(responseSong);
        HashMap<String, Float> features = response.getFeatures();
        state.setFeatures(features);
        state.setSongName(result.getName());
        String all_artists = "";
        int index = 0;
        String[] artistsList = result.getArtist();
        for (String artist : artistsList) {
            if (index == artistsList.length - 1) {
                all_artists += artist;
                break;
            }
            all_artists += artist + " | ";
            index++;
        }
        state.setArtistName(all_artists);
        state.setReleaseDate(result.getReleaseDate());
        this.viewModel.setSongInformation(state.getSongName(), state.getArtistName(), state.getReleaseDate(),
                state.getFeatures());
        viewModel.setState(state);
        viewModel.firePropertyChanged();

        viewManager.setActiveView(viewModel.getViewName());
        viewManager.firePropertyChanged();
    }
}
