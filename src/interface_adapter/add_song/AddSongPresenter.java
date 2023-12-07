package interface_adapter.add_song;

import interface_adapter.ViewManagerModel;
import use_case.add_song.AddSongOutputBoundary;


public class AddSongPresenter implements AddSongOutputBoundary {
    private final AddSongViewModel addSongViewModel;
    private final ViewManagerModel viewManagerModel;
    public AddSongPresenter(ViewManagerModel viewManagerModel, AddSongViewModel addSongViewModel) {
        this.addSongViewModel = addSongViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    public void prepareSuccessView() {
        AddSongState addSongState = addSongViewModel.getState();
        this.addSongViewModel.setState(addSongState);
        addSongViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(addSongViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }


    public void prepareFailView(String error) {
        AddSongState addSongState = addSongViewModel.getState();
        addSongState.setNameError(error);
        addSongViewModel.firePropertyChanged();
    }
}
