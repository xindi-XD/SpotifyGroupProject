package use_case.create_playlist;

public interface CreatePlaylistOutputBoundary {
    void prepareSuccessView(CreatePlaylistOutputData name);

    void prepareFailView(String error);
}
