package interface_adapter.get_song_stats;

import entity.Song;
import interface_adapter.ViewManagerModel;
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
        JOptionPane.showMessageDialog(null, e);
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(GetStatsOutputData response) {
        GetStatsState state = viewModel.getState();
        Song result = (Song) response.getSong();
        HashMap<String, Float> features = response.getFeatures();
        state.setFeatures(features);
        state.setSongName(result.getName());
        String all_artists = "";
        for (String artist : result.getArtist()) {
            all_artists += artist + " | ";
        }
        state.setArtistName(all_artists);
        state.setReleaseDate(result.getReleaseDate());
        this.viewModel.setState(state);
        this.viewModel.setSongInformation(state.getSongName(), state.getArtistName(), state.getReleaseDate(),
                state.getFeatures());
        viewModel.firePropertyChanged();

        viewManager.setActiveView(viewModel.getViewName());
        viewManager.firePropertyChanged();
    }
}
