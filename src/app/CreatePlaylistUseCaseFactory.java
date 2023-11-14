package app;

import data_access.FileDataAccessObject;
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
import view.HomepageView;

import javax.swing.*;
import java.io.IOException;

public class CreatePlaylistUseCaseFactory {
    public static CreatePlaylistView create(ViewManagerModel viewManagerModel,
                                            HomepageViewModel homepageViewModel,
                                            CreatePlaylistViewModel createPlaylistViewModel,
                                            CreatePlaylistDataAccessInterface createPlaylistDataAccessObject) {

        try {
            CreatePlaylistController createPlaylistController = createCreatePlaylistUseCase(viewManagerModel, createPlaylistViewModel, homepageViewModel, createPlaylistDataAccessObject);
            return new CreatePlaylistView(createPlaylistViewModel, createPlaylistController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }
        return null;
    }

    private static CreatePlaylistController createCreatePlaylistUseCase(
            ViewManagerModel viewManagerModel,
            CreatePlaylistViewModel createPlaylistViewModel,
            HomepageViewModel homepageViewModel,
            CreatePlaylistDataAccessInterface createPlaylistDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        CreatePlaylistOutputBoundary createPlaylistOutputBoundary = new CreatePlaylistPresenter(createPlaylistViewModel, homepageViewModel, viewManagerModel);
        // TODO: Incomplete method. Missing factory and DAO.
        CreatePlaylistInputBoundary createPlaylistInteractor = new CreatePlaylistInteractor(createPlaylistDataAccessObject, createPlaylistOutputBoundary);
        return new CreatePlaylistController(createPlaylistInteractor);
    }
}