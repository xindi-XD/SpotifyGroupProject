package view;

import entity.Playlist;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_song.AddSongController;
import interface_adapter.add_song.AddSongState;
import interface_adapter.add_song.AddSongViewModel;
import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreatePlaylistState;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.delete_playlist.DeletePlaylistController;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.get_song_stats.GetStatsViewModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.show_playlists.ShowPlaylistsController;
import interface_adapter.show_playlists.ShowPlaylistsState;
import interface_adapter.show_playlists.ShowPlaylistsViewModel;
import interface_adapter.show_songs.ShowSongsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Map;


public class AddSongView implements PropertyChangeListener {
    public final String viewName = "Song added!";
    private final AddSongViewModel addSongViewModel;
    private final GetStatsViewModel getStatsViewModel;

    private final ViewManagerModel viewManagerModel;

    private final JButton back;

    public AddSongView(AddSongViewModel addSongViewModel, GetStatsViewModel getStatsViewModel, ViewManagerModel viewManagerModel) {
        this.addSongViewModel = addSongViewModel;
        this.getStatsViewModel = getStatsViewModel;
        this.viewManagerModel = viewManagerModel;

        addSongViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(interface_adapter.add_song.AddSongViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        back = new JButton(addSongViewModel.BACK_LABEL);
        buttons.add(back);

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            viewManagerModel.setActiveView(getStatsViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddSongState state = (AddSongState) evt.getNewValue();
    }
}



