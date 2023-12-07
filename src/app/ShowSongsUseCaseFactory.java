package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.show_playlists.ShowPlaylistsViewModel;
import interface_adapter.show_songs.ShowSongsViewModel;
import view.ShowSongsView;

public class ShowSongsUseCaseFactory {
    private ShowSongsUseCaseFactory() {}
    public static ShowSongsView create(ViewManagerModel viewManagerModel,
                                       HomepageViewModel homepageViewModel,
                                       ShowSongsViewModel showSongsViewModel,
                                       ShowPlaylistsViewModel showPlaylistsViewModel) {

        return new ShowSongsView(viewManagerModel, homepageViewModel, showSongsViewModel, showPlaylistsViewModel);
    }
}
