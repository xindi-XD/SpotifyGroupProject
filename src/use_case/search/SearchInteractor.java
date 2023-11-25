package use_case.search;

import data_access.APIDataAccessObject;
import data_access.FilePlaylistDataAccessObject;
import org.json.JSONArray;

import java.time.LocalDateTime;
import java.util.Objects;

public class SearchInteractor implements SearchInputBoundary {
    final SearchPlaylistDataAccessInterface searchPlaylistDataAccessObject;
    //TODO: song and playlist are not distinguished.
    final SearchOutputBoundary searchPresenter;

    public SearchInteractor(SearchPlaylistDataAccessInterface searchPlaylistDataAccessInterface,
                            SearchOutputBoundary searchOutputBoundary) {
        this.searchPlaylistDataAccessObject = searchPlaylistDataAccessInterface;
        this.searchPresenter = searchOutputBoundary;
    }

    @Override
    public void execute(SearchInputData searchInputData) {
        if (Objects.equals(searchInputData.getQuery(), "")){
            // TODO: PrepareFailView incomplete.
            searchPresenter.prepareFailView("Please input search item.");
        } else if (Objects.equals(searchInputData.getQueryType(), "")){
            searchPresenter.prepareFailView("Please select item type.");
        } else {
            LocalDateTime now = LocalDateTime.now();
            if (Objects.equals(searchInputData.getQueryType(), "Track")){
                //Input: query name.
                //Output: an array of 10 song objects, or a JSONarray.
                String query = searchInputData.getQuery();
                JSONArray result = searchPlaylistDataAccessObject.searchTrack(query);
                // TODO: Output data incomplete.
                SearchOutputData searchOutputData = new SearchOutputData(result.get(1), now.toString(), false);
                searchPresenter.prepareSuccessView(searchOutputData);
            }
        }
    }
}
