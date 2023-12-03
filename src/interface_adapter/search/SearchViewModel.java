package interface_adapter.search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;

//eva writing this one
public class SearchViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Search Results View";
    public static ArrayList<String> SONG_LABELS = new ArrayList<String>();
    public static ArrayList<String> SONG_WRITER_LABELS = new ArrayList<>();
    public static ArrayList<String> ARTIST_LABELS = new ArrayList<String>();
    public static String ADD_BUTTON_LABEL = "Add";
    public static String GET_INFO_LABEL = "Show Stats";
    public static String LIKE_ARTIST_BUTTON_LABEL = "Like artist";
    public static final String TO_HOME_BUTTON_LABEL = "Back to homepage";
    private SearchState state = new SearchState();

    public SearchViewModel() {
        super("search results");
    }

    public static void resetSongLabels() {
        SONG_LABELS = new ArrayList<String>();
    }

    public static void resetSongWriterLabels() {
        SONG_WRITER_LABELS = new ArrayList<String>();
    }

    public static void resetArtistLabels() {
        ARTIST_LABELS = new ArrayList<String>();
    }

    public void setFiveSongLabels(ArrayList<String> songLabels){
        if (!songLabels.isEmpty()){
            ArrayList<Integer> length = new ArrayList<>();
            length.add(5);
            length.add(songLabels.size());
            Integer min = Collections.min(length);
            for (int i = 0; i < min; i++){
                this.SONG_LABELS.add(i, songLabels.get(i));
            }
        }
    }
    public void setFiveSongWriterLabels(ArrayList<String[]> songWriterLabels) {
        if (!songWriterLabels.isEmpty()){
            ArrayList<Integer> length = new ArrayList<>();
            length.add(5);
            length.add(songWriterLabels.size());
            Integer min = Collections.min(length);
            for (int i = 0; i < min; i++){
                String[] writers = songWriterLabels.get(i);
                String s = toString(writers);
                this.SONG_WRITER_LABELS.add(i, s);
            }
        }
    }
    private String toString(String[] s){
        String string = "by ";
        for (int i = 0; i < s.length - 1; i++){
            string = string + s[i] + ", ";
        }
        string = string + s[s.length - 1];
        return string;
    }
    public void setFiveArtistLabels(ArrayList<String> artistLabels) {
        if (!artistLabels.isEmpty()){
            ArrayList<Integer> length = new ArrayList<>();
            length.add(5);
            length.add(artistLabels.size());
            Integer min = Collections.min(length);
            for (int i = 0; i < min; i++){
                this.ARTIST_LABELS.add(i, artistLabels.get(i));
            }
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
