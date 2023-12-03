package interface_adapter.get_song_stats;

import interface_adapter.ViewManagerModel;
import use_case.get_song_stats.GetStatsOutputBoundary;
import use_case.get_song_stats.GetStatsOutputData;

import javax.swing.*;

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
        state.setSong(response.getSong());
        this.viewModel.setState(state);
        viewModel.firePropertyChanged();

        viewManager.setActiveView(viewModel.getViewName());
        viewManager.firePropertyChanged();
    }
}
