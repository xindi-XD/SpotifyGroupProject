package interface_adapter.create_playlist;

import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageState;
import interface_adapter.homepage.HomepageViewModel;
import use_case.create_playlist.CreatePlaylistOutputBoundary;
import use_case.create_playlist.CreatePlaylistOutputData;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreatePlaylistPresenter implements CreatePlaylistOutputBoundary {
    private final CreatePlaylistViewModel createPlaylistViewModel;
    private final HomepageViewModel homepageViewModel;
    private ViewManagerModel viewManagerModel;
    public CreatePlaylistPresenter(CreatePlaylistViewModel createPlaylistViewModel,
                                   HomepageViewModel homepageViewModel,
                                   ViewManagerModel viewManagerModel){
        this.createPlaylistViewModel = createPlaylistViewModel;
        this.homepageViewModel = homepageViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(CreatePlaylistOutputData name) {
        // Discarded the Output data run time from CACoding.
        // TODO: change PlaylistState and change property of PlaylistViewModel to add the new playlist to queue.
        CreatePlaylistState createPlaylistState = createPlaylistViewModel.getCreatePlaylistState();
        createPlaylistState.setPlaylistName(name.getPlaylistName());
        this.createPlaylistViewModel.setState(createPlaylistState);
        homepageViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(homepageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        JOptionPane.showMessageDialog(null,
                "Playlist " + name.getPlaylistName() + " has been successfully created!\n" +
                "Description: " + name.getPlaylistDescription() + ".\n");
    }
}
