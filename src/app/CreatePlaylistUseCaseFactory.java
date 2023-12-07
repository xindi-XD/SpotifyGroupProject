package app;

import entity.CommonPlaylistFactory;
import entity.PlaylistFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreatePlaylistPresenter;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.homepage.HomepageViewModel;
import use_case.create_playlist.CreatePlaylistInputBoundary;
import use_case.create_playlist.CreatePlaylistInteractor;
import use_case.create_playlist.CreatePlaylistOutputBoundary;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;
import view.CreatePlaylistView;

import javax.swing.*;
import java.io.IOException;

/**
 * Use case factory for create playlist use case.
 * @author xindi-XD, DavidChu
 */
public class CreatePlaylistUseCaseFactory {

    private CreatePlaylistUseCaseFactory(){}

    /**
     * Creates a new PlaylistView instance for a call to the create playlist use case.
     * @param viewManagerModel view manager to switch between the get homepage and create playlist view
     * @param homepageViewModel the homepage view model the use case was called from
     * @param createPlaylistViewModel the create playlist view model that is to be opened
     * @param createPlaylistDataAccessObject file access object to edit stored playlists
     * @return a PlaylistView object containing all relevant classes
     */
    public static CreatePlaylistView create(ViewManagerModel viewManagerModel,
                                            HomepageViewModel homepageViewModel,
                                            CreatePlaylistViewModel createPlaylistViewModel, CreatePlaylistDataAccessInterface createPlaylistDataAccessObject) {

//        try {
        CreatePlaylistController createPlaylistController = createCreatePlaylistUseCase(viewManagerModel, createPlaylistViewModel, homepageViewModel, createPlaylistDataAccessObject);
        return new CreatePlaylistView(createPlaylistViewModel, createPlaylistController,
                homepageViewModel, viewManagerModel);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open user data file.");
//        }
//        return null;
    }

    private static CreatePlaylistController createCreatePlaylistUseCase(
            ViewManagerModel viewManagerModel,
            CreatePlaylistViewModel createPlaylistViewModel,
            HomepageViewModel homepageViewModel, CreatePlaylistDataAccessInterface createPlaylistDataAccessObject){

        // Notice how we pass this method's parameters to the Presenter.
        CreatePlaylistOutputBoundary createPlaylistOutputBoundary = new CreatePlaylistPresenter(createPlaylistViewModel, homepageViewModel, viewManagerModel);
        // TODO: Incomplete method. Missing DAO.
        PlaylistFactory playlistFactory = new CommonPlaylistFactory();
        CreatePlaylistInputBoundary createPlaylistInteractor = new CreatePlaylistInteractor(createPlaylistDataAccessObject, createPlaylistOutputBoundary, playlistFactory);
        return new CreatePlaylistController(createPlaylistInteractor);
    }
}
