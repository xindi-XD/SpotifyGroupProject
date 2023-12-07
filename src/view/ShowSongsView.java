package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.show_playlists.ShowPlaylistsViewModel;
import interface_adapter.show_songs.ShowSongsState;
import interface_adapter.show_songs.ShowSongsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ShowSongsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Your Songs";
    private final ViewManagerModel viewManagerModel;
    private final HomepageViewModel homepageViewModel;
    private final ShowSongsViewModel showSongsViewModel;
    private final ShowPlaylistsViewModel showPlaylistsViewModel;
    private final JButton backToPlaylists;
    private final JButton backToHome;
    public ShowSongsView(ViewManagerModel viewManagerModel, HomepageViewModel homepageViewModel,
                         ShowSongsViewModel showSongsViewModel, ShowPlaylistsViewModel showPlaylistsViewModel) {

        this.viewManagerModel = viewManagerModel;
        this.homepageViewModel = homepageViewModel;
        this.showSongsViewModel = showSongsViewModel;
        this.showPlaylistsViewModel = showPlaylistsViewModel;
        showSongsViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(ShowSongsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel buttons = new JPanel();
        backToPlaylists = new JButton(ShowSongsViewModel.TO_PLAYLISTS_BUTTON_LABEL);
        backToHome = new JButton(ShowSongsViewModel.TO_HOME_BUTTON_LABEL);
        buttons.add(backToHome);
        buttons.add(backToPlaylists);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(580, 400));
        this.add(title);
        this.add(buttons);

        backToHome.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(backToHome)){
                            viewManagerModel.setActiveView(homepageViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        backToPlaylists.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(backToPlaylists)) {
                            viewManagerModel.setActiveView(showPlaylistsViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
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
        ShowSongsState state = (ShowSongsState) evt.getNewValue();
        if (state.getNoSongsError() != null) {
            JOptionPane.showMessageDialog(this, state.getNoSongsError());
            state.setNoSongsError(null);
        }
    }
}
