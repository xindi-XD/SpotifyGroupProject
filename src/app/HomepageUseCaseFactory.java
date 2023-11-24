package app;

import data_access.FilePlaylistDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.homepage.HomepageViewModel;
import view.HomepageView;

public class HomepageUseCaseFactory {
    private HomepageUseCaseFactory(){}

/*
    public static HomepageView create(ViewManagerModel viewManagerModel,
                                      HomepageViewModel homepageViewModel,
                                      CreatePlaylistViewModel createPlaylistViewModel,
                                      FilePlaylistDataAccessObject fileDataAccessObject){
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
//        return new HomepageController(homepageInteractor);*/
}
