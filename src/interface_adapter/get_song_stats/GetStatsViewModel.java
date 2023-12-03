package interface_adapter.get_song_stats;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

public class GetStatsViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Song statistics";
    public static String SONG_NAME_LABEL = "Name: ";
    public static String ARTIST_NAME_LABEL = "Artist: ";
    public static String RELEASE_DATE_LABEL = "Released: ";
    public static ArrayList<String> FEATURE_LABELS;
    public static String[] featureNames = {"acousticness", "danceability", "energy", "instrumentalness", "liveness",
            "loudness", "speechiness", "valence"};
    public static final String BACK_LABEL = "Back";

    private GetStatsState state = new GetStatsState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public GetStatsViewModel(){
        super("Song statistics");
        FEATURE_LABELS = new ArrayList<>();
        for (String feature : featureNames) {
            FEATURE_LABELS.add(feature.substring(0, 1).toUpperCase() + feature.substring(1) + ": ");
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

    public GetStatsState getState() {return state;}

    public void setState(GetStatsState statsState) {this.state = statsState;}

    public void setSongInformation(String name, String artist, String releaseDate, HashMap<String, Float> features) {
        SONG_NAME_LABEL += name;
        ARTIST_NAME_LABEL += artist;
        RELEASE_DATE_LABEL += releaseDate;
        int index  = 0;
        for (String feature : featureNames) {
            FEATURE_LABELS.set(index, FEATURE_LABELS.get(index) + features.get(feature));
            index++;
        }
    }
}
