package interface_adapter.show_songs;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShowSongsViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Your Songs";
    public static ArrayList<String> SONG_NAME_LABELS = new ArrayList<String>();
    public static Map<String, String[]> SONG_ARTIST_LABELS = new HashMap<>();
    public static final String TO_PLAYLISTS_BUTTON_LABEL = "Back to your playlists";
    public static final String TO_HOME_BUTTON_LABEL = "Back to homepage";
    private ShowSongsState state = new ShowSongsState();
    public ShowSongsViewModel() {super("Your Songs");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ShowSongsState getState() {
        return state;
    }

    public void setState(ShowSongsState state) {
        this.state = state;
    }
}
