package interface_adapter.add_song;

import interface_adapter.get_song_stats.GetStatsState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

public class AddSongViewModel {
    public static final String TITLE_LABEL = "Song added!";
    public static final String BACK_LABEL = "Back";

    private AddSongState state = new AddSongState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public AddSongViewModel(){
    }
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public AddSongState getState() {return state;}

    public void setState(AddSongState addState) {this.state = addState;}

    public String getViewName() {return TITLE_LABEL;
    }
}
