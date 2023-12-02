package use_case.search;

import entity.CommonPlaylistFactory;
import entity.CommonSong;
import entity.CommonSongFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class SearchInteractor implements SearchInputBoundary {
    final SearchAPIDataAccessInterface searchAPIDataAccessObject;
    //TODO: song and artist are not distinguished.
    final SearchOutputBoundary searchPresenter;

    public SearchInteractor(SearchAPIDataAccessInterface searchAPIDataAccessInterface,
                            SearchOutputBoundary searchOutputBoundary) {
        this.searchAPIDataAccessObject = searchAPIDataAccessInterface;
        this.searchPresenter = searchOutputBoundary;
    }

    @Override
    public void execute(SearchInputData searchInputData) {
        if (Objects.equals(searchInputData.getQuery(), "")){
            // TODO: PrepareFailView incomplete.
            searchPresenter.prepareFailView("Please input search item.");
        } else {
            LocalDateTime now = LocalDateTime.now();
            if (Objects.equals(searchInputData.getQueryType(), "Track")){
                //Input: query name.
                String query = searchInputData.getQuery();
                JSONArray results = searchAPIDataAccessObject.search(query, "track");
                // TODO: Output data incomplete.
                ArrayList<CommonSong> songs = new ArrayList<>();
                // Output: passes an array of Song objects to output data.
                for (int i = 0; i< results.length(); i++){
                    JSONObject result = (JSONObject) results.get(i);
                    CommonSong song = CommonSongFactory.create(result);
                    songs.add(song);
                }
                SearchOutputData searchOutputData = new SearchOutputData(songs, now.toString(), false);
                searchPresenter.prepareSuccessView(searchOutputData);
            }
        }
    }
}
