package use_case.show_playlists;

import entity.Playlist;

import java.util.Map;

public class ShowPlaylistsInteractor implements ShowPlaylistsInputBoundary{
    final ShowPlaylistsDataAccessInterface showPlaylistsDataAccessObject;
    final ShowPlaylistsOutputBoundary showPlaylistsPresenter;


    public ShowPlaylistsInteractor(ShowPlaylistsDataAccessInterface showPlaylistsDataAccessObject,
                                   ShowPlaylistsOutputBoundary showPlaylistsPresenter) {
        this.showPlaylistsDataAccessObject = showPlaylistsDataAccessObject;
        this.showPlaylistsPresenter = showPlaylistsPresenter;
    }

    @Override
    public void execute() {
        Map<String, Playlist> playlists = showPlaylistsDataAccessObject.getPlaylists();
        if (playlists.isEmpty()) {
            showPlaylistsPresenter.prepareFailView("You haven't create any playlist yet.");
        }
        else {
            ShowPlaylistsOutputData playlistsOutputData = new ShowPlaylistsOutputData(playlists);
            showPlaylistsPresenter.prepareSuccessView(playlistsOutputData);
        }
    }
}
