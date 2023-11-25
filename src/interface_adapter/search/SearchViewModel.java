package interface_adapter.search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

//eva writing this one
public class SearchViewModel extends ViewModel {
    public SearchViewModel() {
        super("search results");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
