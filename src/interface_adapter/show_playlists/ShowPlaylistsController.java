package interface_adapter.show_playlists;

import use_case.show_playlists.ShowPlaylistsInputBoundary;

public class ShowPlaylistsController {
    final ShowPlaylistsInputBoundary showPlaylistsInteractor;

    public ShowPlaylistsController(ShowPlaylistsInputBoundary showPlaylistsInteractor) {
        this.showPlaylistsInteractor = showPlaylistsInteractor;
    }

    public void execute() {
        showPlaylistsInteractor.execute();
    }
}
