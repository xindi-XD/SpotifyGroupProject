package use_case.search;

import data_access.APIDataAccessObject;
import entity.CommonSong;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

import use_case.search.search_strategies.SongCompiler;

import java.util.ArrayList;

public class SearchInteractorTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testExecute() {
        successTest();
    }

    public void testGetCompiledResult() {
    }

    public void successTest(){
        SearchInputData searchInputData = new SearchInputData("Boat", "track");
        // If no API access, line below should be FilePlaylistDataAccessObject.
        SearchAPIDataAccessInterface api = new APIDataAccessObject();
        SearchOutputBoundary successPresenter = new SearchOutputBoundary() {
            @Override
            public void prepareFailResultView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailInputView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareSuccessSongView(SearchOutputData result) {
                assertEquals(result.getSongs().getClass(), ArrayList.class);
                assertNotNull(result.getCreationTime()); // any creation time is fine.
            }

            @Override
            public void prepareSuccessArtistView(SearchOutputData searchOutputData) {
                fail("Search type is unexpected.");}
        };
        SearchInputBoundary interactor = new SearchInteractor(api, successPresenter);
        interactor.execute(searchInputData);
    }
    @org.junit.Test
    public void failureNoInputTest() {
        SearchInputData searchInputData = new SearchInputData(null, "track");
        SearchAPIDataAccessInterface api = new APIDataAccessObject();
        SearchOutputBoundary failurePresenter = new SearchOutputBoundary() {
            @Override
            public void prepareFailResultView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailInputView(String error) {
                assertEquals(error, "No search results were found ┐(ﾟ～ﾟ)┌");
            }

            @Override
            public void prepareSuccessSongView(SearchOutputData result) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareSuccessArtistView(SearchOutputData searchOutputData) {
                fail("Use case success is unexpected.");}
        };
        SearchInputBoundary interactor = new SearchInteractor(api, failurePresenter);
        interactor.execute(searchInputData);
    }
}