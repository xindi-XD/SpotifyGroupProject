package use_case.show_stats;

import data_access.APIDataAccessObject;
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
                assertEquals(getStatsOutputData.getSong().getName(), "Among Us (Trap Remix)");
                assertEquals(getStatsOutputData.getSong().getSongId(), "6kyHcHEBPtwjEbUWrNuLlv");
                assertEquals(getStatsOutputData.getSong().getReleaseDate(), "2020-10-11");
                assert(!getStatsOutputData.getSong().getFeatures().isEmpty());
            }
        };
        GetStatsInputBoundary interactor = new GetStatsInteractor(api, successPresenter);
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
        GetStatsInputBoundary interactor = new GetStatsInteractor(api, failurePresenter);
        interactor.execute(input);
    }
}
