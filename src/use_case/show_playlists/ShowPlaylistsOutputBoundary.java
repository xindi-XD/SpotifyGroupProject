package use_case.show_playlists;

public interface ShowPlaylistsOutputBoundary {
    void prepareSuccessView(ShowPlaylistsOutputData playlists);
    void prepareFailView(String error);
}
