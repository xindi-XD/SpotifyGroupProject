package view;

import interface_adapter.show_playlists.ShowPlaylistsViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ShowPlaylistsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Your Playlists";
    private ShowPlaylistsViewModel showPlaylistsViewModel;
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
