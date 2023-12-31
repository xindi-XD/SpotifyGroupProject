package view;

// imports from CACoding
import interface_adapter.ViewManagerModel;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.homepage.HomepageState;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.show_playlists.ShowPlaylistsViewModel;
import interface_adapter.show_playlists.ShowPlaylistsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class HomepageView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "homepage";
    private final HomepageViewModel homepageViewModel;
    private final CreatePlaylistViewModel createPlaylistViewModel;
    private final DeletePlaylistViewModel deletePlaylistViewModel;
    private final ShowPlaylistsViewModel showPlaylistsViewModel;
    private final SearchController searchController;
    private final ShowPlaylistsController showPlaylistsController;
    final JTextField searchInputField = new JTextField(15);
    private final JButton createPlaylist;
    private final JButton showPlaylists;
    private final JButton deletePlaylist;
    private final JButton search;
    private final ViewManagerModel viewManagerModel;
    String[] types = {"track", "artist"};

    public HomepageView(HomepageViewModel homepageViewModel, CreatePlaylistViewModel createPlaylistViewModel,
                        SearchController searchController, ViewManagerModel viewManagerModel,
                        DeletePlaylistViewModel deletePlaylistViewModel,
                        ShowPlaylistsViewModel showPlaylistsViewModel, ShowPlaylistsController showPlaylistsController){
//        this.createPlaylistController = createPlaylistController;
        // Initialize view models.
        this.createPlaylistViewModel = createPlaylistViewModel;
        this.deletePlaylistViewModel = deletePlaylistViewModel;
        this.showPlaylistsViewModel = showPlaylistsViewModel;
        this.homepageViewModel = homepageViewModel;
        this.viewManagerModel = viewManagerModel;
        this.searchController = searchController;
        this.showPlaylistsController = showPlaylistsController;
        // Initialize controllers (if any).
        // Make this view listen to changes made in view models.
        homepageViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(HomepageViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel searchInfo = new LabelTextPanel(
                new JLabel(HomepageViewModel.SEARCH_INFO_LABEL), searchInputField);
        JLabel searchType = new JLabel(HomepageViewModel.SEARCH_TYPE_LABEL);
        JComboBox<String> searchTypeDropdown = new JComboBox<String>(types);
        searchTypeDropdown.setMaximumSize( searchTypeDropdown.getPreferredSize() );
        search = new JButton(HomepageViewModel.SEARCH_BUTTON_LABEL);
        JPanel type = new JPanel();
        type.add(searchType);
        type.add(searchTypeDropdown);
        type.add(search);
        JPanel buttons = new JPanel();
        createPlaylist = new JButton(HomepageViewModel.CREATEPLAYLIST_BUTTON_LABEL);
        buttons.add(createPlaylist);
        showPlaylists = new JButton(HomepageViewModel.SHOWPLAYLISTS_BUTTON_LABEL);
        buttons.add(showPlaylists);
        deletePlaylist = new JButton(HomepageViewModel.DELETEPLAYLIST_BUTTON_LABEL);
        buttons.add(deletePlaylist);


        // TODO: delete and search, to be implemented
//        deletePlaylist = new JButton(HomepageViewModel.DELETEPLAYLIST_BUTTON_LABEL);
//        buttons.add(deletePlaylist);

        createPlaylist.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(createPlaylist)){
                            // Doesn't pass in any parameter. Switch view to CreatePlaylistView.
                            viewManagerModel.setActiveView(createPlaylistViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
//                            HomepageState currentState = homepageViewModel.getHomepageState();
//                            homepageController.executeCP();
                            // TODO: the state should be similar to an existing playlist. They should be able to add
                            //  or delete songs, set and change names. The only difference is that the new playlist
                            //  should be stored in the permenant database. Might call state methods here.
                        }
                    }
                }
        );

        deletePlaylist.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(deletePlaylist)){
                            viewManagerModel.setActiveView(deletePlaylistViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        showPlaylists.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(showPlaylists)){
                            showPlaylistsController.execute();
                        }
                    }
                }
        );

        searchInputField.addKeyListener(
                new KeyListener(){
                    @Override
                    public void keyTyped(KeyEvent e) {
                        HomepageState currentState = homepageViewModel.getHomepageState();
                        String text = searchInputField.getText() + e.getKeyChar();
                        currentState.setQuery(text);
                        homepageViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                }
        );
        search.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(search)){
                            HomepageState currentState = homepageViewModel.getHomepageState();
                            currentState.setQueryType(searchTypeDropdown.getSelectedItem().toString());
                            searchController.execute(
                                    currentState.getQuery(),
                                    currentState.getQueryType()
                                );
                        }
                    }
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(searchInfo);
        this.add(type);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Something not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        HomepageState state = (HomepageState) evt.getNewValue();
        if (state.getHomepageError() != null) {
            JOptionPane.showMessageDialog(this, state.getHomepageError());
        }
    }


}
