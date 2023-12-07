package interface_adapter.show_playlists;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShowPlaylistsViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Your Playlists";
    public static ArrayList<String> PLAYLIST_NAME_LABELS = new ArrayList<String>();
    public static Map<String, String> PLAYLIST_DESCRIPTION_LABELS = new HashMap<>();
    public static String SHOW_SONGS_LABEL = "Songs";
    public static final String TO_HOME_BUTTON_LABEL = "Back to homepage";
    private ShowPlaylistsState state = new ShowPlaylistsState();
    public ShowPlaylistsViewModel() {
        super("Your Playlists");
    }

    public static void resetPlaylistNameLabels() {
        PLAYLIST_NAME_LABELS = new ArrayList<String>();
    }

    public static void resetPlaylistDescriptionLabels() {
        PLAYLIST_DESCRIPTION_LABELS = new HashMap<>();
    }

    public void setPlaylistNameLabels(ArrayList<String> playlistsLabels){
        if (!playlistsLabels.isEmpty()) {
            for (int i = 0; i < playlistsLabels.size(); i++){
                this.PLAYLIST_NAME_LABELS.add(i, playlistsLabels.get(i));
            }
        }
    }

    public void setPlaylistDescriptionLabels(Map<String, String> playlistDescriptionLabels) {
        if (!playlistDescriptionLabels.isEmpty()) {
            PLAYLIST_DESCRIPTION_LABELS = playlistDescriptionLabels;
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
