package interface_adapter.homepage;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HomepageViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Homepage View";
    public static final String CREATEPLAYLIST_BUTTON_LABEL = "Create Playlist";
    // TODO: show, delete and search to be implemented.
    public static final String SHOWPLAYLISTS_BUTTON_LABEL = "Show Playlists";
    public static final String DELETEPLAYLIST_BUTTON_LABEL = "Delete Playlist";
    public static final String SEARCH_LABEL = "Search for song/artist";

    private HomepageState state = new HomepageState();

    public HomepageViewModel(){
        super("homepage");
    }


    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    /**
     * Methods below aren't inherited from ViewModel. Might delete. */
    public void setState(HomepageState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public HomepageState getHomepageState() {
        return state;
    }
}
