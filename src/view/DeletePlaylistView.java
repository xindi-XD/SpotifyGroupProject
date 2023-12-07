package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.delete_playlist.DeletePlaylistController;
import interface_adapter.delete_playlist.DeletePlaylistState;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.homepage.HomepageViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

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
        deletePlaylist = new JButton(deletePlaylistViewModel.DELETE_PLAYLIST_BUTTON_LABEL);
        buttons.add(backToHome);
        buttons.add(deletePlaylist);

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

        deletePlaylist.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(deletePlaylist)){
                            DeletePlaylistState state = deletePlaylistViewModel.getDeletePlaylistState();
                            deletePlaylistController.execute(state.getPlaylistName());
                            if (Objects.equals(state.getNameError(), "a")) {state.setNameError(null);}
                            else if (state.getNameError() != null) {
                                JOptionPane.showMessageDialog(DeletePlaylistView.this, state.getNameError());
                                state.setNameError(null);
                            }
                            else {
                                JOptionPane.showMessageDialog(null,
                                        state.getPlaylistName() + " says good bye~");
                                playlistNameInputField.setText(null);
                                state.setPlaylistName(null);
                            }
                        }
                    }
                }
        );

        playlistNameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        DeletePlaylistState currentState = deletePlaylistViewModel.getDeletePlaylistState();
                        String text = playlistNameInputField.getText() + e.getKeyChar();
                        currentState.setPlaylistName(text);
                        deletePlaylistViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(playlistNameInfo);
        this.add(buttons);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DeletePlaylistState state = (DeletePlaylistState) evt.getNewValue();
    }
}
