package app;

import data_access.FileDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.homepage.HomepageViewModel;
import view.HomepageView;

public class HomepageUseCaseFactory {
    private HomepageUseCaseFactory(){}

    public static HomepageView create(ViewManagerModel viewManagerModel, HomepageViewModel homepageViewModel,
                                      CreatePlaylistViewModel createPlaylistViewModel, FileDataAccessObject fileDataAccessObject){


    }

}
