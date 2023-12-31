package app;

import data_access.APIDataAccessObject;
import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylistFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_song.AddSongViewModel;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.get_song_stats.GetStatsViewModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.show_playlists.ShowPlaylistsViewModel;
import interface_adapter.show_songs.ShowSongsViewModel;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * SpotifyGroupProject Main Class
 * @author DavidChu, xindi-XD, jayuj, EEK
 */
public class Main {
    /**
     * Initializes all views necessary for startup.
     * @param args
     */
    public static void main(String[] args){
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
        DeletePlaylistViewModel deletePlaylistViewModel = new DeletePlaylistViewModel();
        SearchViewModel searchViewModel = new SearchViewModel();
        ShowPlaylistsViewModel showPlaylistsViewModel = new ShowPlaylistsViewModel();
        ShowSongsViewModel showSongsViewModel = new ShowSongsViewModel();
        GetStatsViewModel getStatsViewModel = new GetStatsViewModel();
        AddSongViewModel addSongViewModel = new AddSongViewModel();
        FilePlaylistDataAccessObject playlistDataAccessObject = new FilePlaylistDataAccessObject("./playlists.json", new CommonPlaylistFactory());
        APIDataAccessObject apiDataAccessObject = new APIDataAccessObject();
//        try {
//            fileDataAccessObject = new FileDataAccessObject("./users.csv", new CommonUserFactory());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
        HomepageView homepageView = HomepageUseCaseFactory.create(viewManagerModel, homepageViewModel, createPlaylistViewModel, deletePlaylistViewModel, showPlaylistsViewModel, searchViewModel, apiDataAccessObject, playlistDataAccessObject);
        views.add(homepageView, homepageView.viewName);
        CreatePlaylistView createPlaylistView = CreatePlaylistUseCaseFactory.create(viewManagerModel, homepageViewModel, createPlaylistViewModel, playlistDataAccessObject);
        views.add(createPlaylistView, createPlaylistView.viewName);
        DeletePlaylistView deletePlaylistView = DeletePlaylistUseCaseFactory.create(viewManagerModel, homepageViewModel, deletePlaylistViewModel, playlistDataAccessObject);
        views.add(deletePlaylistView, deletePlaylistView.viewName);
        ShowPlaylistsView showPlaylistsView = ShowPlaylistsUseCaseFactory.create(viewManagerModel, homepageViewModel, showPlaylistsViewModel, playlistDataAccessObject, showSongsViewModel, playlistDataAccessObject);
        views.add(showPlaylistsView, showPlaylistsView.viewName);
        ShowSongsView showSongsView = ShowSongsUseCaseFactory.create(viewManagerModel, homepageViewModel, showSongsViewModel, showPlaylistsViewModel);
        views.add(showSongsView, showSongsView.viewName);
        SearchView searchView = SearchUseCaseFactory.create(viewManagerModel, homepageViewModel, searchViewModel,
                getStatsViewModel, apiDataAccessObject, playlistDataAccessObject);
        views.add(searchView, searchView.viewName);
        GetStatsView getStatsView = GetStatsUseCaseFactory.create(viewManagerModel, addSongViewModel, searchViewModel, getStatsViewModel, playlistDataAccessObject);
        views.add(getStatsView, getStatsView.viewName);
        //AddSongView addSongView = AddSongUseCaseFactory.create(viewManagerModel, getStatsViewModel, addSongViewModel);
        //views.add(addSongView, addSongView.viewName);

        viewManagerModel.setActiveView(homepageView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}