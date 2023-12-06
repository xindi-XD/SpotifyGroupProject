package interface_adapter.show_songs;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class ShowSongsViewModel extends ViewModel {
    public ShowSongsViewModel() {super("Your Songs");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
