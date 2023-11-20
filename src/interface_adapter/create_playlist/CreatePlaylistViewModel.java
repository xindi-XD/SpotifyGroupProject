package interface_adapter.create_playlist;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreatePlaylistViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Create New Playlist View";
    public static final String PLAYLIST_NAME_LABEL = "Enter name for new playlist";
    public static final String DESCRIPTION_LABEL = "Describe the new playlist";
    public static final String TO_HOME_BUTTON_LABEL = "Back to homepage";
    public static final String CREATE_PLAYLIST_BUTTON_LABEL = "Create playlist";

    private CreatePlaylistState state = new CreatePlaylistState();
    public CreatePlaylistViewModel(){
        super("create playlist");
    }

    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public void setState(CreatePlaylistState state) {this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public CreatePlaylistState getCreatePlaylistState() {return state;}


}
