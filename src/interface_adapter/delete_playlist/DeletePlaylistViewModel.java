package interface_adapter.delete_playlist;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeletePlaylistViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Delete Playlist View";
    public static final String PLAYLIST_NAME_LABEL = "Enter name to delete playlist";
    public static final String TO_HOME_BUTTON_LABEL = "Back to homepage";
    public static final String DELETE_PLAYLIST_BUTTON_LABEL = "Delete playlist";
    private DeletePlaylistState state = new DeletePlaylistState();
    public DeletePlaylistViewModel() {
        super("delete playlist");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setState(DeletePlaylistState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public DeletePlaylistState getDeletePlaylistState() {
        return state;
    }
}
