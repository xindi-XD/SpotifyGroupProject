package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_song.AddSongController;
import interface_adapter.get_song_stats.GetStatsState;
import interface_adapter.get_song_stats.GetStatsViewModel;
import interface_adapter.homepage.HomepageState;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GetStatsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Song statistics";
    private final GetStatsViewModel getStatsViewModel;
    private final ViewManagerModel manager;
    private final SearchViewModel searchViewModel;

    private final JButton back;
    private final JButton addsong;

    private final AddSongController addSongController;

    final JTextField playlistInputField = new JTextField(15);

    private String[] playlists = {"No playlists yet"};
    private JComboBox<String> playlistDropdown = new JComboBox<String>(playlists);

    public GetStatsView(GetStatsViewModel getStatsViewModel, ViewManagerModel viewManagerModel,
                        SearchViewModel searchViewModel, AddSongController addSongController) {
        this.getStatsViewModel = getStatsViewModel;
        this.getStatsViewModel.addPropertyChangeListener(this);
        this.manager = viewManagerModel;
        this.searchViewModel = searchViewModel;
        this.addSongController = addSongController;

        JLabel title = new JLabel(GetStatsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(300, 300));
        this.add(title);
        back = new JButton(GetStatsViewModel.BACK_LABEL);
        this.add(back);
        addsong = new JButton(GetStatsViewModel.ADD_LABEL);
        this.add(addsong);
//        playlistDropdown.setMaximumSize(playlistDropdown.getPreferredSize() );



        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == back) {
                            GetStatsView.this.manager.setActiveView(GetStatsView.this.searchViewModel.getViewName());
                            GetStatsView.this.manager.firePropertyChanged();
                            GetStatsView.this.getStatsViewModel.setState(new GetStatsState());
                        }
                    }
                }
        );

        addsong.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(addsong)){
                            playlists = getStatsViewModel.getState().getPlaylistNames().toArray(new String[0]);
                            // TODO
                            setResults();

                            GetStatsState currentState = getStatsViewModel.getState();
                            currentState.setPlaylistSelection(playlistDropdown.getSelectedItem().toString());
                            addSongController.execute(currentState.getSongId(), currentState.getSelectedPlaylist()
                            );
                        }
                    }
                }
        );


    }

    private void setResults() {
        this.removeAll();
        this.repaint();
        this.reconstruct();
        this.add(new JLabel(GetStatsViewModel.SONG_NAME_LABEL));
        this.add(new JLabel(GetStatsViewModel.ARTIST_NAME_LABEL));
        this.add(new JLabel(GetStatsViewModel.RELEASE_DATE_LABEL));
        for (String feature : GetStatsViewModel.FEATURE_LABELS) {
            this.add(new JLabel(feature));
        }
    }

    private void reset() {
        GetStatsViewModel.resetLabels();
    }

    private void reconstruct() {
        JLabel title = new JLabel(GetStatsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(300, 300));
        this.add(title);
        JPanel buttons = new JPanel();
        JButton back = new JButton(GetStatsViewModel.BACK_LABEL);
        JButton addsong = new JButton(GetStatsViewModel.ADD_LABEL);
        buttons.add(back);
        buttons.add(addsong);
        this.add(buttons);
        // TODO
        LabelTextPanel playlistOptions = new LabelTextPanel(
                new JLabel(GetStatsViewModel.PLAYLIST_OPTIONS_LABEL), playlistInputField);
        JLabel playlistSelection = new JLabel(GetStatsViewModel.PLAYLIST_SELECTION);
        JPanel type = new JPanel();
        type.add(playlistSelection);
        this.add(playlistOptions);
        playlistDropdown.setMaximumSize(playlistDropdown.getPreferredSize() );
        type.add(playlistDropdown);
        this.add(type);

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == back) {
                            GetStatsView.this.manager.setActiveView(GetStatsView.this.searchViewModel.getViewName());
                            GetStatsView.this.manager.firePropertyChanged();
                            GetStatsView.this.getStatsViewModel.setState(new GetStatsState());
                        }
                    }
                }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        GetStatsState state = (GetStatsState) evt.getNewValue();
        if (state.getInfoError() != null) {
            JOptionPane.showMessageDialog(this, state.getInfoError());
            state.setInfoError(null);
        }
        else {
            setResults();
            reset();
        }
    }
}
