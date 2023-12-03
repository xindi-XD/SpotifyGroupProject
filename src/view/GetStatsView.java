package view;

import interface_adapter.get_song_stats.GetStatsViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GetStatsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Song statistics";
    private final GetStatsViewModel getStatsViewModel;

    public GetStatsView(GetStatsViewModel getStatsViewModel) {
        this.getStatsViewModel = getStatsViewModel;
        this.getStatsViewModel.addPropertyChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
