package interface_adapter.search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

//eva writing this one
public class SearchViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Search Results View";
    public static ArrayList<String> SONG_LABELS;
    public static ArrayList<String> ARTIST_LABELS;
    public static String ADD_BUTTON_LABEL = "Add";
    public static String LIKE_ARTIST_BUTTON_LABEL = "Like artist";
    private SearchState state = new SearchState();

    public SearchViewModel() {
        super("search results");
    }
    public void setFiveSongLabels(ArrayList<String> songLabels){
        for (int i = 0; i < 5; i++){
            this.SONG_LABELS.add(i, songLabels.get(i));
        }
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
