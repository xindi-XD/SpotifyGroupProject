package use_case.show_playlists;

import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylist;
import entity.CommonPlaylistFactory;
import entity.Playlist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShowPlaylistsUseCaseTest {

    @Test
    void successTest() {
        FilePlaylistDataAccessObject playlistDAO = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());
        Playlist playlist = new CommonPlaylist("DC", "DC's playlist");
        playlistDAO.save(playlist);
        // This creates a successPresenter that tests whether the test case is as we expect.
        ShowPlaylistsOutputBoundary successPresenter = new ShowPlaylistsOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowPlaylistsOutputData playlistsOutputData) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals("DC", playlistsOutputData.getPlaylists().get("DC").getName());
                assertEquals("DC's playlist", playlistsOutputData.getPlaylists().get("DC").getDescription());
                assertTrue(playlistsOutputData.getPlaylistsName().contains("DC"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        ShowPlaylistsInputBoundary interactor = new ShowPlaylistsInteractor(playlistDAO, successPresenter);
        interactor.execute();
    }

    @Test
    void failureEmptyPlaylistsNameTest() {
        FilePlaylistDataAccessObject playlistDAO = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());
        // This creates a successPresenter that tests whether the test case is as we expect.
        ShowPlaylistsOutputBoundary successPresenter = new ShowPlaylistsOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowPlaylistsOutputData playlistsOutputData) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("You haven't create any playlist yet.", error);
            }
        };

        ShowPlaylistsInputBoundary interactor = new ShowPlaylistsInteractor(playlistDAO, successPresenter);
        interactor.execute();
    }
}