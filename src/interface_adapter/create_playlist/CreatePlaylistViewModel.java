package interface_adapter.create_playlist;

import interface_adapter.ViewModel;
import interface_adapter.homepage.HomepageViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreatePlaylistViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Create New Playlist View";
    public static final String PLAYLISTNAME_LABEL = "Enter name for new playlist";
    public static final String DESCRIPTION_LABEL = "Describe the new playlist";
    public static final String TOHOME_BUTTON_LABEL = "Back to homepage";
    private CreatePlaylistState state = new CreatePlaylistState();
    public CreatePlaylistViewModel(){
        super("create playlist");
    }

    public void setState(CreatePlaylistState state) {this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public CreatePlaylistState getCreatePlaylistState() {return state;}

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
