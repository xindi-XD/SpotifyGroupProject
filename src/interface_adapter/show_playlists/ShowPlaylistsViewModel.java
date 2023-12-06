package interface_adapter.show_playlists;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;

public class ShowPlaylistsViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Your Playlists";
    public static ArrayList<String> PLAYLIST_NAME_LABELS = new ArrayList<String>();
    public static String SHOW_SONGS_LABEL = "Songs";
    public static final String TO_HOME_BUTTON_LABEL = "Back to homepage";
    private ShowPlaylistsState state = new ShowPlaylistsState();
    public ShowPlaylistsViewModel() {
        super("Your Playlists");
    }

    public static void resetPlaylistNameLabels() {
        PLAYLIST_NAME_LABELS = new ArrayList<String>();
    }

    public void setPlaylistNameLabels(ArrayList<String> playlistsLabels){
        if (!playlistsLabels.isEmpty()) {
            ArrayList<Integer> length = new ArrayList<>();
            length.add(5);
            length.add(playlistsLabels.size());
            Integer min = Collections.min(length);
            for (int i = 0; i < min; i++){
                this.PLAYLIST_NAME_LABELS.add(i, playlistsLabels.get(i));
            }
        }
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ShowPlaylistsState getState() {
        return state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void setState(ShowPlaylistsState showPlaylistsState) {
        this.state = showPlaylistsState;
    }
}
