package interface_adapter.create_playlist;

import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageState;
import interface_adapter.homepage.HomepageViewModel;
import use_case.create_playlist.CreatePlaylistOutputBoundary;

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
    public void prepareSuccessView() {
        // Discarded the Output data run time from CACoding.
        // TODO: change PlaylistState and change property of PlaylistViewModel to add the new playlist to queue.
        viewManagerModel.setActiveView(homepageViewModel.getViewName());
    }
}
