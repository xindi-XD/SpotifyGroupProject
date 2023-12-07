package use_case.delete_playlist;

import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylist;
import entity.CommonPlaylistFactory;
import entity.Playlist;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DeletePlaylistUseCaseTest {

    @Test
    void successTest() {
        DeletePlaylistInputData inputData = new DeletePlaylistInputData("DC");
        FilePlaylistDataAccessObject playlistDAO = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());
        Playlist playlist = new CommonPlaylist("DC", null);
        playlistDAO.save(playlist);

        // This creates a successPresenter that tests whether the test case is as we expect.
        DeletePlaylistOutputBoundary successPresenter = new DeletePlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(DeletePlaylistOutputData playlist) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals("DC", playlist.getName());
                assertFalse(playlistDAO.existsPlaylistName("DC"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        DeletePlaylistInputBoundary interactor = new DeletePlaylistInteractor(playlistDAO, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureEmptyPlaylistNameTest() {
        DeletePlaylistInputData inputData = new DeletePlaylistInputData("");
        DeletePlaylistDataAccessInterface playlistDAO = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());

        // This creates a successPresenter that tests whether the test case is as we expect.
        DeletePlaylistOutputBoundary successPresenter = new DeletePlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(DeletePlaylistOutputData playlist) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("The playlist name can't be empty", error);
            }
        };

        DeletePlaylistInputBoundary interactor = new DeletePlaylistInteractor(playlistDAO, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failurePlaylistExistsTest() {
        DeletePlaylistInputData inputData = new DeletePlaylistInputData("DC");
        DeletePlaylistDataAccessInterface playlistDAO = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());

        // This creates a successPresenter that tests whether the test case is as we expect.
        DeletePlaylistOutputBoundary successPresenter = new DeletePlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(DeletePlaylistOutputData playlist) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                fail("Use case failure is unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("The playlist does not exist", error);
            }
        };

        DeletePlaylistInputBoundary interactor = new DeletePlaylistInteractor(playlistDAO, successPresenter);
        interactor.execute(inputData);
    }
}