package use_case.show_songs;

import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylist;
import entity.CommonPlaylistFactory;
import entity.Playlist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ShowSongsUseCaseTest {

    @Test
    void successTest() {}

    @Test
    void failureEmptyPlaylistsNameTest() {
        ShowSongsInputData inputData = new ShowSongsInputData("DC");
        FilePlaylistDataAccessObject playlistDAO = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());
        Playlist playlist = new CommonPlaylist("DC", "DC's playlist");
        playlistDAO.save(playlist);
        // This creates a successPresenter that tests whether the test case is as we expect.
        ShowSongsOutputBoundary successPresenter = new ShowSongsOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowSongsOutputData playlistsOutputData) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Try to add one or more songs to this playlist! ^v^", error);
            }
        };

        ShowSongsInputBoundary interactor = new ShowSongsInteractor(successPresenter, playlistDAO);
        interactor.execute(inputData);
    }
}
