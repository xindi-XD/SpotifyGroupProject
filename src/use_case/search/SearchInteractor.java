package use_case.search;

import entity.CommonArtist;
import entity.CommonSong;
import org.json.JSONArray;
import use_case.search.search_strategies.ArtistCompiler;
import use_case.search.search_strategies.Compiler;
import use_case.search.search_strategies.SongCompiler;

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
            //Input: query name.
            String query = searchInputData.getQuery();
            String queryType = searchInputData.getQueryType();
            JSONArray results = searchAPIDataAccessObject.search(query, queryType);
            // Output: a JSONObject.
            // TODO: If write gibberish, returns nothing, error screen.
            // TODO: When result < 5.
            if (queryType.equals("track")) {
                SongCompiler compiler = new SongCompiler();
                ArrayList<CommonSong> songs = compiler.compileResult(results);
                SearchOutputData searchOutputData = new SearchOutputData(songs, now.toString(), false);
                searchPresenter.prepareSuccessSongView(searchOutputData);
            }
            else if (queryType.equals("artist")){
                ArtistCompiler compiler = new ArtistCompiler();
                ArrayList<CommonArtist> artists = compiler.compileResult(results);
                SearchOutputData searchOutputData = new SearchOutputData(artists, now.toString(), false);
                searchPresenter.prepareSuccessArtistView(searchOutputData);

            }
        }
    }
}
