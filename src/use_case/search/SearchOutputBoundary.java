package use_case.search;

public interface SearchOutputBoundary {
    void prepareFailView(String s);

    void prepareSuccessSongView(SearchOutputData searchOutputData);
    void prepareSuccessArtistView(SearchOutputData searchOutputData);
}
