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
import view.CreatePlaylistView;
import view.HomepageView;

import javax.swing.*;
import java.io.IOException;

public class CreatePlaylistUseCaseFactory {
    public static CreatePlaylistView create(ViewManagerModel viewManagerModel,
                                            HomepageViewModel homepageViewModel,
                                            CreatePlaylistViewModel createPlaylistViewModel,
                                            FileDataAccessObject fileDataAccessObject) {

        try {
            CreatePlaylistController createPlaylistController = createCreatePlaylistUseCase(viewManagerModel, createPlaylistViewModel, homepageViewModel, fileDataAccessObject);
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
            FileDataAccessObject fileDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        CreatePlaylistOutputBoundary createPlaylistOutputBoundary = new CreatePlaylistPresenter(createPlaylistViewModel, homepageViewModel, viewManagerModel);
        // TODO: Factory for something.
        UserFactory userFactory = new CommonUserFactory();
        CreatePlaylistInputBoundary createPlaylistInputBoundary = new CreatePlaylistInteractor(
                userDataAccessObject, createPlaylistOutptBoundary);
        // user DAO doesn't seem right.

        return new CreatePlaylistController(CreatePlaylistInteractor);
    }

}
