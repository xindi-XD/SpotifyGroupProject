package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.delete_playlist.DeletePlaylistController;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.homepage.HomepageViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DeletePlaylistView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "delete playlist";
    private final DeletePlaylistViewModel deletePlaylistViewModel;
    private final HomepageViewModel homepageViewModel;
    private final DeletePlaylistController deletePlaylistController;
    final JTextField playlistNameInputField = new JTextField(15);
    private final JLabel playlistNameError = new JLabel();
    private final JButton backToHome;
    private final JButton deletePlaylist;
    private final ViewManagerModel viewManagerModel;

    public DeletePlaylistView(DeletePlaylistViewModel deletePlaylistViewModel, DeletePlaylistController deletePlaylistController,
                              HomepageViewModel homepageViewModel, ViewManagerModel viewManagerModel){
        this.homepageViewModel = homepageViewModel;
        this.deletePlaylistViewModel = deletePlaylistViewModel;
        this.viewManagerModel = viewManagerModel;
        this.deletePlaylistController = deletePlaylistController;

        deletePlaylistViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(interface_adapter.delete_playlist.DeletePlaylistViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel playlistNameInfo = new LabelTextPanel(
                new JLabel(DeletePlaylistViewModel.PLAYLIST_NAME_LABEL), playlistNameInputField);

        JPanel buttons = new JPanel();
        backToHome = new JButton(deletePlaylistViewModel.TO_HOME_BUTTON_LABEL);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
