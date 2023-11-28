package use_case.search;

public interface SearchOutputBoundary {
    void prepareFailView(String s);

    void prepareSuccessView(SearchOutputData searchOutputData);
}
