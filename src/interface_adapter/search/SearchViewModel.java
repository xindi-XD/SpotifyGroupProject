package interface_adapter.search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

//eva writing this one
public class SearchViewModel extends ViewModel {
    // TODO: implement labels.
    private SearchState state = new SearchState();

    public SearchViewModel() {
        super("search results");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public SearchState getState() {
        return this.state;
    }

    public void setState(SearchState searchState) {
        this.state = searchState;
    }
}
