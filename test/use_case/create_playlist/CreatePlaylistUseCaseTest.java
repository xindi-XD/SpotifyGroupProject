package use_case.create_playlist;

import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylist;
import entity.CommonPlaylistFactory;
import entity.Playlist;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CreatePlaylistUseCaseTest {

    @Test
    void successTest() {
        CreatePlaylistInputData inputData = new CreatePlaylistInputData("DC", "DC's playlist");
        CreatePlaylistDataAccessInterface playlistDAO = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());

        // This creates a successPresenter that tests whether the test case is as we expect.
        CreatePlaylistOutputBoundary successPresenter = new CreatePlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(CreatePlaylistOutputData playlist) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals("DC", playlist.getPlaylistName());
                assertEquals("DC's playlist", playlist.getPlaylistDescription());
                assertTrue(playlistDAO.existsPlaylistName("DC"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        CreatePlaylistInputBoundary interactor = new CreatePlaylistInteractor(playlistDAO, successPresenter, new CommonPlaylistFactory());
        interactor.execute(inputData);
    }

    @Test
    void failureEmptyPlaylistNameTest() {
        CreatePlaylistInputData inputData = new CreatePlaylistInputData(null, null);
        CreatePlaylistDataAccessInterface playlistDAO = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());

        // This creates a successPresenter that tests whether the test case is as we expect.
        CreatePlaylistOutputBoundary successPresenter = new CreatePlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(CreatePlaylistOutputData playlist) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("The playlist name can't be empty", error);
            }
        };

        CreatePlaylistInputBoundary interactor = new CreatePlaylistInteractor(playlistDAO, successPresenter, new CommonPlaylistFactory());
        interactor.execute(inputData);
    }

    @Test
    void failurePlaylistExistsTest() {
        CreatePlaylistInputData inputData = new CreatePlaylistInputData("DC", "DC's playlist");
        CreatePlaylistDataAccessInterface playlistDAO = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());
        Playlist playlist = new CommonPlaylist("DC", "");
        playlistDAO.save(playlist);

        // This creates a successPresenter that tests whether the test case is as we expect.
        CreatePlaylistOutputBoundary successPresenter = new CreatePlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(CreatePlaylistOutputData playlist) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                fail("Use case failure is unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("The playlist has already been created", error);
            }
        };

        CreatePlaylistInputBoundary interactor = new CreatePlaylistInteractor(playlistDAO, successPresenter, new CommonPlaylistFactory());
        interactor.execute(inputData);
    }
}