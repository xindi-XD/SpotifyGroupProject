package app;

import data_access.FileDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreatePlaylistPresenter;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.homepage.HomepageController;
import interface_adapter.homepage.HomepagePresenter;
import interface_adapter.homepage.HomepageViewModel;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;
import use_case.create_playlist.CreatePlaylistInputBoundary;
import use_case.create_playlist.CreatePlaylistInteractor;
import use_case.create_playlist.CreatePlaylistOutputBoundary;
import view.CreatePlaylistView;
import view.HomepageView;

import javax.swing.*;
import java.io.IOException;

public class HomepageUseCaseFactory {
    private HomepageUseCaseFactory(){}

    public static HomepageView create(ViewManagerModel viewManagerModel, HomepageViewModel homepageViewModel,
                                      CreatePlaylistViewModel createPlaylistViewModel, FileDataAccessObject fileDataAccessObject){

        //            HomepageController homepageController = createHomepageUseCase(viewManagerModel, createPlaylistViewModel, homepageViewModel, fileDataAccessObject);
        return new HomepageView(homepageViewModel, createPlaylistViewModel, viewManagerModel);
    }

//    private static HomepageController createHomepageUseCase(
//            ViewManagerModel viewManagerModel,
//            CreatePlaylistViewModel createPlaylistViewModel,
//            HomepageViewModel homepageViewModel,
//            CreatePlaylistDataAccessInterface createPlaylistDataAccessObject) throws IOException {
//
//        // Notice how we pass this method's parameters to the Presenter.
//        // TODO: Homepage Presenter not implemented.
//        HomepageOutputBoundary homepageOutputBoundary = new HomepagePresenter();
//        // TODO: Incomplete method. Missing factory and DAO.
//        CreatePlaylistInputBoundary createPlaylistInteractor = new CreatePlaylistInteractor(createPlaylistDataAccessObject, createPlaylistOutputBoundary);
//        return new HomepageController(homepageInteractor);
}
