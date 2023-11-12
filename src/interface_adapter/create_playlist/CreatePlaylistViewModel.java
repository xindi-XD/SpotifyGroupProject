package interface_adapter.create_playlist;

import interface_adapter.ViewModel;
import interface_adapter.homepage.HomepageViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreatePlaylistViewModel extends ViewModel {
    public static final String NEWPLAYLIST_BUTTON_LABEL = "Create New Playlist";
    public static final String TITLE_LABEL = "Create Playlist View";
    private CreatePlaylistState state = new CreatePlaylistState();
    public CreatePlaylistViewModel(){
        super("create playlist"); // TODO So it can't be super class of anything? Not sure how super works.
    }

    public void setState(CreatePlaylistState state) {this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

//  Methods firePropertyChanged, addPropertyChangeListener are inherited from HomepageViewModel.
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
