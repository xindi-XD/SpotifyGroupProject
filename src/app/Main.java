package app;

import data_access.APIDataAccessObject;
import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylistFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchViewModel;
import view.CreatePlaylistView;
import view.HomepageView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO: API call commented out for only view transition.
//        APIDataAccessObject spot = new APIDataAccessObject();
//        //System.out.println(spot.getData("11vYnWjFxgXBgw2aC6Rb8"));
//        System.out.println(spot.getMe());
        JFrame application = new JFrame("Spotify Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as playlists and songs, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        // TODO: more VMs to be added.
        HomepageViewModel homepageViewModel = new HomepageViewModel();
        CreatePlaylistViewModel createPlaylistViewModel = new CreatePlaylistViewModel();
        SearchViewModel searchViewModel = new SearchViewModel();
        FilePlaylistDataAccessObject playlistDataAccessObject = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());
        APIDataAccessObject apiDataAccessObject = new APIDataAccessObject();
//        try {
//            fileDataAccessObject = new FileDataAccessObject("./users.csv", new CommonUserFactory());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
        HomepageView homepageView = HomepageUseCaseFactory.create(viewManagerModel, homepageViewModel, createPlaylistViewModel, searchViewModel, apiDataAccessObject);
        views.add(homepageView, homepageView.viewName);
        CreatePlaylistView createPlaylistView = CreatePlaylistUseCaseFactory.create(viewManagerModel, homepageViewModel, createPlaylistViewModel, playlistDataAccessObject);
        views.add(createPlaylistView, createPlaylistView.viewName);

        viewManagerModel.setActiveView(homepageView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}