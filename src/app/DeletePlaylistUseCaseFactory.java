package app;

import entity.CommonPlaylistFactory;
import entity.PlaylistFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.delete_playlist.DeletePlaylistController;
import interface_adapter.delete_playlist.DeletePlaylistPresenter;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import use_case.delete_playlist.DeletePlaylistDataAccessInterface;
import use_case.delete_playlist.DeletePlaylistInputBoundary;
import use_case.delete_playlist.DeletePlaylistInteractor;
import use_case.delete_playlist.DeletePlaylistOutputBoundary;
import view.DeletePlaylistView;

/**
 * Use case factory for the delete playlist use case.
 * @author DavidChu
 */
public class DeletePlaylistUseCaseFactory {
    private DeletePlaylistUseCaseFactory(){}

    /**
     * Creates a new DeletePlaylistView instance for a call to the delete playlist use case.
     * @param viewManagerModel view manager to switch between the get homepage and delete playlist view
     * @param homepageViewModel the homepage view model the use case was called from
     * @param deletePlaylistViewModel the delete playlist view model that is to be opened
     * @param deletePlaylistDataAccessObject file access object to edit stored playlists
     * @return a DeletePlaylistView object containing all relevant classes
     */
    public static DeletePlaylistView create(ViewManagerModel viewManagerModel,
                                            HomepageViewModel homepageViewModel,
                                            DeletePlaylistViewModel deletePlaylistViewModel, DeletePlaylistDataAccessInterface deletePlaylistDataAccessObject) {

//        try {
        DeletePlaylistController deletePlaylistController = createDeletePlaylistUseCase(viewManagerModel, deletePlaylistViewModel, homepageViewModel, deletePlaylistDataAccessObject);
        return new DeletePlaylistView(deletePlaylistViewModel, deletePlaylistController,
                homepageViewModel, viewManagerModel);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open user data file.");
//        }
//        return null;
    }

    private static DeletePlaylistController createDeletePlaylistUseCase(
            ViewManagerModel viewManagerModel,
            DeletePlaylistViewModel deletePlaylistViewModel,
            HomepageViewModel homepageViewModel, DeletePlaylistDataAccessInterface deletePlaylistDataAccessObject){

        // Notice how we pass this method's parameters to the Presenter.
        DeletePlaylistOutputBoundary deletePlaylistOutputBoundary = new DeletePlaylistPresenter(deletePlaylistViewModel, homepageViewModel, viewManagerModel);
        // TODO: Incomplete method. Missing factory and DAO.
        PlaylistFactory playlistFactory = new CommonPlaylistFactory();
        DeletePlaylistInputBoundary deletePlaylistInteractor = new DeletePlaylistInteractor(deletePlaylistDataAccessObject, deletePlaylistOutputBoundary);
        return new DeletePlaylistController(deletePlaylistInteractor);
    }
}
