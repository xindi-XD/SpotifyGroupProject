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
    private final HomepageViewModel homepageViewModel;
    // JTextField(columns) determines bracket length.
    private final CreatePlaylistController createPlaylistController;
    final JTextField playlistNameInputField = new JTextField(15);
    final JTextField descriptionInputField = new JTextField(15);
    private final JLabel playlistNameError = new JLabel(); // TODO: Captures repeated playlist name created by the same account. Not implemented.
    private final JButton backToHome;
    private final JButton makePlaylist;
    private final ViewManagerModel viewManagerModel;

    public CreatePlaylistView(CreatePlaylistViewModel createPlaylistViewModel, CreatePlaylistController createPlaylistController,
                              HomepageViewModel homepageViewModel, ViewManagerModel viewManagerModel){
        // Initialize view models.
        this.homepageViewModel = homepageViewModel;
        this.createPlaylistViewModel = createPlaylistViewModel;
        this.viewManagerModel = viewManagerModel;
        this.createPlaylistController = createPlaylistController;
        // Initialize controllers.
        // Make this view listen to changes made in view models.
        createPlaylistViewModel.addPropertyChangeListener(this);
        // TODO: Should create playlist view listen to homepage view model?

        JLabel title = new JLabel(CreatePlaylistViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel playlistNameInfo = new LabelTextPanel(
                new JLabel(CreatePlaylistViewModel.PLAYLIST_NAME_LABEL), playlistNameInputField);
        LabelTextPanel descriptionInfo = new LabelTextPanel(
                new JLabel(CreatePlaylistViewModel.DESCRIPTION_LABEL), descriptionInputField);

        JPanel buttons = new JPanel();
        backToHome = new JButton(createPlaylistViewModel.TO_HOME_BUTTON_LABEL);
        makePlaylist = new JButton(createPlaylistViewModel.CREATE_PLAYLIST_BUTTON_LABEL);
        buttons.add(backToHome);
        buttons.add(makePlaylist);
//        this.createPlaylist = createPlaylist;

        backToHome.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(backToHome)){
                            // Doesn't pass in any parameter. Switch view to HomepageView.
                            viewManagerModel.setActiveView(homepageViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        makePlaylist.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent evt){
                        if (evt.getSource().equals(makePlaylist)){
                            createPlaylistController.execute("Playlist name retrieved from keyboard");
                            CreatePlaylistState state = createPlaylistViewModel.getCreatePlaylistState();
                            if (state.getNullError() != null){
                                JOptionPane.showMessageDialog(CreatePlaylistView.this, state.getNullError());
                            }
                            else if (state.getRepeatError() != null){
                                JOptionPane.showMessageDialog(CreatePlaylistView.this, state.getRepeatError());
                            }

                        }
                    }
                }
        );

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
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(playlistNameInfo);
        this.add(descriptionInfo);
        this.add(buttons);

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
