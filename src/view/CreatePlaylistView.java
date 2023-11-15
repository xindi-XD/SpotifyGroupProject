package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreatePlaylistState;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.homepage.HomepageController;
import interface_adapter.homepage.HomepageState;
import interface_adapter.homepage.HomepageViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreatePlaylistView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "create playlist";
    private final CreatePlaylistViewModel createPlaylistViewModel;
    private final CreatePlaylistController createPlaylistController;
    final JTextField playlistNameInputField = new JTextField(15);
    final JTextField descriptionInputField = new JTextField(15);
    // TODO: Adjust display columns (field width) if description is too long.
    private final JLabel playlistNameError = new JLabel(); // TODO: Captures repeated playlist name created by the same account. Not implemented.
    final JButton backToHome;
    private ViewManagerModel viewManagerModel;

    public CreatePlaylistView(CreatePlaylistViewModel createPlaylistViewModel, CreatePlaylistController createPlaylistController,
                              HomepageViewModel homepageViewModel){

        this.createPlaylistViewModel = createPlaylistViewModel;
        this.createPlaylistViewModel.addPropertyChangeListener(this);
        this.createPlaylistController = createPlaylistController;

        JLabel title = new JLabel(CreatePlaylistViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel playlistNameInfo = new LabelTextPanel(
                new JLabel(CreatePlaylistViewModel.PLAYLISTNAME_LABEL), playlistNameInputField);
        LabelTextPanel descriptionInfo = new LabelTextPanel(
                new JLabel(CreatePlaylistViewModel.DESCRIPTION_LABEL), playlistNameInputField);
        JPanel buttons = new JPanel();
        backToHome = new JButton(createPlaylistViewModel.TOHOME_BUTTON_LABEL);
        buttons.add(backToHome);
//        this.createPlaylist = createPlaylist;

        backToHome.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(backToHome)){
                            // Doesn't pass in any parameter. Switch view to CreatePlaylistView.
                            viewManagerModel.setActiveView(homepageViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        ); //TODO: to be implemented, framework shown below.

        playlistNameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreatePlaylistState currentState = createPlaylistViewModel.getCreatePlaylistState();
                        String text = playlistNameInputField.getText() + e.getKeyChar();
                        currentState.setPlaylistName(text);
                        createPlaylistViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        descriptionInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreatePlaylistState currentState = createPlaylistViewModel.getCreatePlaylistState();
                        currentState.setDescription(descriptionInputField.getText() + e.getKeyChar());
                        createPlaylistViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
    }

    // TODO: actionPerformed and propertyChange unchecked.
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
