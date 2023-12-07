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

public class DeletePlaylistUseCaseFactory {
    private DeletePlaylistUseCaseFactory(){}
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
