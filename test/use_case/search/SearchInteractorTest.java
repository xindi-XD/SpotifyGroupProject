package use_case.search;

import data_access.APIDataAccessObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchInteractorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {

    }

    @Test
    void getCompiledResult() {
    }
    @org.junit.jupiter.api.Test
    public void successTrackTest(){
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

    @org.junit.jupiter.api.Test
    public void successArtistTest(){
        SearchInputData searchInputData = new SearchInputData("Ed Sheeran", "artist");
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
                fail("Search type is unexpected.");}
            @Override
            public void prepareSuccessArtistView(SearchOutputData result) {
                assertEquals(result.getSongs().getClass(), ArrayList.class);
                assertNotNull(result.getCreationTime()); // any creation time is fine.
                assertNotNull(result.getArtists());
            }
        };
            SearchInputBoundary interactor = new SearchInteractor(api, successPresenter);
            interactor.execute(searchInputData);
    }
    @org.junit.jupiter.api.Test
    public void failureNoInputTest() {
        SearchInputData searchInputData = new SearchInputData("", "track");
        SearchAPIDataAccessInterface api = new APIDataAccessObject();
        SearchOutputBoundary failurePresenter = new SearchOutputBoundary() {
            @Override
            public void prepareFailResultView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailInputView(String error) {
                assertEquals(error, "Please input search item.");
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
    @org.junit.jupiter.api.Test
    public void failureNoResultTest() {
        SearchInputData searchInputData = new SearchInputData("][][-=]=;'.", "track");
        SearchAPIDataAccessInterface api = new APIDataAccessObject();
        SearchOutputBoundary failurePresenter = new SearchOutputBoundary() {
            @Override
            public void prepareFailResultView(String error) {
                assertEquals(error, "No search results were found ┐(ﾟ～ﾟ)┌");
            }

            @Override
            public void prepareFailInputView(String error) {
                fail("Use case failure is unexpected.");
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