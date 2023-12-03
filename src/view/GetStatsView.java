package view;

import interface_adapter.get_song_stats.GetStatsViewModel;

import javax.swing.*;
import java.awt.*;
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

        JLabel title = new JLabel(GetStatsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(300, 300));
        this.add(title);
        JButton back = new JButton(GetStatsViewModel.BACK_LABEL);
        this.add(back);
    }

    public void setResults() {
        this.add(new JLabel(GetStatsViewModel.SONG_NAME_LABEL));
        this.add(new JLabel(GetStatsViewModel.ARTIST_NAME_LABEL));
        this.add(new JLabel(GetStatsViewModel.RELEASE_DATE_LABEL));
        for (String feature : GetStatsViewModel.FEATURE_LABELS) {
            this.add(new JLabel(feature));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setResults();
    }
}
