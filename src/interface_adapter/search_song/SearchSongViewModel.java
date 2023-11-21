package interface_adapter.search_song;
import interface_adapter.ViewModel;
import interface_adapter.homepage.HomepageViewModel;

import java.beans.PropertyChangeListener;

//eva writing this one
public class SearchSongViewModel extends ViewModel {
    public SearchSongViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
