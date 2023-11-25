package interface_adapter.search;

import use_case.search.SearchInputBoundary;

public class SearchController {
    final SearchInputBoundary searchInteractor;
    public SearchController(SearchInputBoundary searchInteractor){
        this.searchInteractor = searchInteractor;
    }

    public void execute(String query, Object queryType) {
    }
}
