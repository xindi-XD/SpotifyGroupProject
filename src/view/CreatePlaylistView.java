package view;

import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreatePlaylistState;
import interface_adapter.create_playlist.CreatePlaylistViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreatePlaylistView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "create playlist";
    private final CreatePlaylistViewModel createPlaylistViewModel;
    private final CreatePlaylistController createPlaylistController;
    final JTextField playlistNameInputField = new JTextField(15);
    private final JLabel playlistNameError = new JLabel(); // Captures repeated playlist name created by the same account.
    final JButton createPlaylist;
    public CreatePlaylistView(CreatePlaylistViewModel createPlaylistViewModel, CreatePlaylistController createPlaylistController){

        this.createPlaylistViewModel = createPlaylistViewModel;
        this.createPlaylistViewModel.addPropertyChangeListener(this);
        this.createPlaylistController = createPlaylistController;

        JLabel title = new JLabel("Create New Playlist Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel playlistNameInfo = new LabelTextPanel(
                new JLabel("Name for the new playlist"), playlistNameInputField);
        JPanel buttons = new JPanel();
        createPlaylist = new JButton(createPlaylistViewModel.NEWPLAYLIST_BUTTON_LABEL);
        buttons.add(createPlaylist);
//        this.createPlaylist = createPlaylist;

        createPlaylist.addActionListener(this); //TODO: to be implemented, framework shown below.
//        createPlaylist.addActionListener(){
//            public void actionPerformed(ActionEvent evt) {
//                if (evt.getSource().equals(createPlaylist)) {
//                    CreatePlaylistState currentState = createPlaylistViewModel.getState();
//                    // TODO: missing implementation of getState(), getPlaylistName()
//                    createPlaylistController.execute(
//                            currentState.getPlaylistName()
//                    );
//                }
//            }
//        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CreatePlaylistState state = (CreatePlaylistState) evt.getNewValue();
        // There's a method in LoginView that allows automatic fill-in-the-blank.
    }
}
