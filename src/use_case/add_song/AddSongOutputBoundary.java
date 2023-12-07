package use_case.add_song;

public interface AddSongOutputBoundary {
    void prepareFailView(String s);
    void prepareSuccessView();
}
