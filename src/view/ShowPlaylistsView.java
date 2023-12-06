package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.show_playlists.ShowPlaylistsController;
import interface_adapter.show_playlists.ShowPlaylistsState;
import interface_adapter.show_playlists.ShowPlaylistsViewModel;
import interface_adapter.show_songs.ShowSongsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ShowPlaylistsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Your Playlists";
    private final ShowPlaylistsViewModel showPlaylistsViewModel;
    private final ViewManagerModel viewManagerModel;
    private final HomepageViewModel homepageViewModel;
    private final ShowSongsViewModel showSongsViewModel;
    private final ShowPlaylistsController showPlaylistsController;
    private final JButton backToHome;
    private final ArrayList<JButton> showSongButtons = new ArrayList<>();

    public ShowPlaylistsView(ShowPlaylistsViewModel showPlaylistsViewModel, ViewManagerModel viewManagerModel,
                             HomepageViewModel homepageViewModel, ShowPlaylistsController showPlaylistsController,
                             ShowSongsViewModel showSongsViewModel) {
        this.showPlaylistsViewModel = showPlaylistsViewModel;
        this.viewManagerModel = viewManagerModel;
        this.homepageViewModel = homepageViewModel;
        this.showSongsViewModel = showSongsViewModel;
        this.showPlaylistsController = showPlaylistsController;
        showPlaylistsViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(ShowPlaylistsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel buttons = new JPanel();
        backToHome = new JButton(ShowPlaylistsViewModel.TO_HOME_BUTTON_LABEL);
        buttons.add(backToHome);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(580, 400));
        this.add(title);
        this.add(buttons);

        backToHome.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(backToHome)){
                            viewManagerModel.setActiveView(ShowPlaylistsView.this.homepageViewModel.getViewName());
                            ShowPlaylistsView.this.viewManagerModel.firePropertyChanged();
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
        ShowPlaylistsState state = (ShowPlaylistsState) evt.getNewValue();
        if (state.getPlaylistsError() != null) {
            JOptionPane.showMessageDialog(this, state.getPlaylistsError());
            state.setPlaylistsError(null);
        }
        else {
            setResults();
            resetResults();
        }
    }

    private void resetResults() {
        ShowPlaylistsViewModel.resetPlaylistNameLabels();
    }

    private void setResults() {
        ArrayList<String> playlists = showPlaylistsViewModel.getState().getPlaylistsNames();
        if (!showSongButtons.isEmpty()) {
            showSongButtons.clear();
            this.removeAll();
            this.repaint();
            reconstruct();
        }
        if (!playlists.isEmpty()) {
            for (int i = 0; i < ShowPlaylistsViewModel.PLAYLIST_NAME_LABELS.size(); i++) {
                onePlaylistResult(playlists.get(i), i);
            }
        }
    }

    private void onePlaylistResult(String playlistName, int index) {
        JLabel playlistLabel = new JLabel(playlistName);
        JButton showSongs = new JButton(ShowPlaylistsViewModel.SHOW_SONGS_LABEL);
        JPanel resultLine = new JPanel();
        resultLine.add(playlistLabel);
        resultLine.add(showSongs);
        this.add(resultLine);
        showSongButtons.add(showSongs);
        showSongs.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(showSongs)) {
                            viewManagerModel.setActiveView(showSongsViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );
    }

    private void reconstruct() {
        JLabel title = new JLabel(ShowPlaylistsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel buttons = new JPanel();
        buttons.add(backToHome);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(580, 400));
        this.add(title);
        this.add(buttons);
        backToHome.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(backToHome)) {
                            viewManagerModel.setActiveView(homepageViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );
    }
}
