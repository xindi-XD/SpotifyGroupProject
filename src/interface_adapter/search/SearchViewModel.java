package interface_adapter.search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

//eva writing this one
public class SearchViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Search Results View";
    public static String SONG1_LABEL;
    public static String SONG2_LABEL;
    public static String SONG3_LABEL;
    public static String SONG4_LABEL;
    public static String SONG5_LABEL;
    public static String ADD_BUTTON_LABEL = "Add";
    private SearchState state = new SearchState();

    public SearchViewModel() {
        super("search results");
    }
    public void setSongLabels(ArrayList<String> songLabels){
        this.SONG1_LABEL = songLabels.get(0);
        this.SONG2_LABEL = songLabels.get(1);
        this.SONG3_LABEL = songLabels.get(2);
        this.SONG4_LABEL = songLabels.get(3);
        this.SONG5_LABEL = songLabels.get(4);
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SearchState getState() {
        return state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public void setState(SearchState searchState) {
        this.state = searchState;
    }
}
