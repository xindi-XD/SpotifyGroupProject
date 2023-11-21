package interface_adapter.delete_playlist;

import interface_adapter.ViewModel;
import interface_adapter.homepage.HomepageViewModel;

import java.beans.PropertyChangeListener;

public class DeletePlaylistViewModel extends ViewModel {
    public DeletePlaylistViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
