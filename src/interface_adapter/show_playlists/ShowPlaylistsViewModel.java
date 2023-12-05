package interface_adapter.show_playlists;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ShowPlaylistsViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Your Playlists";
    public static final ArrayList<String> PLAYLIST_NAME_LABELS = new ArrayList<>();
    public static final String SHOW_SONGS_LABEL = "Show Songs";
    public static final String TO_HOME_BUTTON_LABEL = "Back to homepage";
    private ShowPlaylistsState state = new ShowPlaylistsState();
    public ShowPlaylistsViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
