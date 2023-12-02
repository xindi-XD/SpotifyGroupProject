package use_case.search;

import entity.CommonArtist;
import entity.CommonArtistFactory;
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
    private ResultCompiler resultCompiler;

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
            //Input: query name.
            String query = searchInputData.getQuery();
            String queryType = searchInputData.getQueryType();
            JSONArray results = searchAPIDataAccessObject.search(query, queryType);
            // Output: a JSONObject.
            // TODO: Parse the JSONObject into an arraylist of songs or artists.
            if (queryType.equals("track")) {
                ArrayList<CommonSong> songs = resultCompiler.compileResult(results);
                SearchOutputData searchOutputData = new SearchOutputData(songs, now.toString(), false);
                searchPresenter.prepareSuccessSongView(searchOutputData);
            }
            else if (queryType.equals("artist")){
                ArrayList<CommonArtist> artists = resultCompiler.compileResult(results);
                SearchOutputData searchOutputData = new SearchOutputData(artists, now.toString(), false);
                searchPresenter.prepareSuccessArtistView(searchOutputData);

            }
        }
    }
}
