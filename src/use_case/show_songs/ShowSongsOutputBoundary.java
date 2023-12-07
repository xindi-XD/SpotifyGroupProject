package use_case.show_songs;

public interface ShowSongsOutputBoundary {
    void prepareSuccessView(ShowSongsOutputData showSongsOutputData);
    void prepareFailView(String error);
}
