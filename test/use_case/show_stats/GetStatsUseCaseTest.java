package use_case.show_stats;

import data_access.APIDataAccessObject;
import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylistFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.get_song_stats.*;

import static org.junit.jupiter.api.Assertions.*;
class GetStatsUseCaseTest {

    @BeforeEach
    void setUp() {}

    @AfterEach
    void tearDown() {}

    @Test
    void execute() {}

    @Test
    void getCompiledResult() {}

    @Test
    public void successGetStatsTest() {
        GetStatsInputData input = new GetStatsInputData("6kyHcHEBPtwjEbUWrNuLlv");
        GetStatsAPIDataAccessInterface api = new APIDataAccessObject();
        GetStatsOutputBoundary successPresenter = new GetStatsOutputBoundary() {
            @Override
            public void prepareFailView(String e) {
                fail("Fail get stats unexpected.");
            }

            @Override
            public void prepareSuccessView(GetStatsOutputData getStatsOutputData) {
                assertEquals(getStatsOutputData.getName(), "Among Us (Trap Remix)");
                assertEquals(getStatsOutputData.getArtists(), "Leonz");
                assertEquals(getStatsOutputData.getId(), "6kyHcHEBPtwjEbUWrNuLlv");
                assertEquals(getStatsOutputData.getReleaseDate(), "2020-10-11");
                assert(!getStatsOutputData.getFeatures().isEmpty());
            }
        };
        GetStatsFilePlaylistDataAccessInterface fileAccess = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());
        GetStatsInputBoundary interactor = new GetStatsInteractor(api, successPresenter, fileAccess);
        interactor.execute(input);
    }

    @org.junit.jupiter.api.Test
    public void failureNoSongTest() {
        GetStatsInputData input = new GetStatsInputData("sus");
        GetStatsAPIDataAccessInterface api = new APIDataAccessObject();
        GetStatsOutputBoundary failurePresenter = new GetStatsOutputBoundary() {
            @Override
            public void prepareFailView(String e) {
                assertEquals(e, "Song doesn't exist");
            }

            @Override
            public void prepareSuccessView(GetStatsOutputData getStatsOutputData) {
                fail("Success get stats unexpected.");
            }
        };
        GetStatsFilePlaylistDataAccessInterface fileAccess = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());
        GetStatsInputBoundary interactor = new GetStatsInteractor(api, failurePresenter, fileAccess);
        assertThrows(RuntimeException.class, () -> interactor.execute(input));
    }
}
