package interface_adapter.get_song_stats;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class GetStatsViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Song statistics";

    private GetStatsState state = new GetStatsState();

    public GetStatsViewModel(){super("Song statistics");}

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public GetStatsState getState() {return state;}

    public void setState(GetStatsState statsState) {this.state = statsState;}
}
