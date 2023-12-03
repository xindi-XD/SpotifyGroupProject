package use_case.search;

public interface SearchOutputBoundary {
    void prepareFailResultView(String s);
    void prepareFailInputView(String s);

    void prepareSuccessSongView(SearchOutputData searchOutputData);
    void prepareSuccessArtistView(SearchOutputData searchOutputData);
}
