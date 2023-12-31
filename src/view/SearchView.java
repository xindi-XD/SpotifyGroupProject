package view;

import interface_adapter.get_song_stats.GetStatsController;
import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search results";
    private final SearchViewModel searchViewModel;
    private final ViewManagerModel viewManagerModel;
    private final HomepageViewModel homepageViewModel;
    private final GetStatsController getStatsController;
    private final JButton backToHome;
    private final ArrayList<JButton> addButtons = new ArrayList<JButton>();
    private final ArrayList<JButton> likeButtons = new ArrayList<JButton>();
  
    public SearchView(SearchViewModel searchViewModel, HomepageViewModel homepageViewModel,
                      ViewManagerModel viewManagerModel, GetStatsController getStatsController){

        this.searchViewModel = searchViewModel;
        this.viewManagerModel = viewManagerModel;
        this.homepageViewModel = homepageViewModel;
        this.getStatsController = getStatsController;
        searchViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(SearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel buttons = new JPanel();
        backToHome = new JButton(SearchViewModel.TO_HOME_BUTTON_LABEL);
        buttons.add(backToHome);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension( 580, 400 ));
        this.add(title);
        this.add(buttons);


        backToHome.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(backToHome)){
                            // Doesn't pass in any parameter. Switch view to HomepageView.
                            SearchView.this.viewManagerModel.setActiveView(SearchView.this.homepageViewModel.getViewName());
                            SearchView.this.viewManagerModel.firePropertyChanged();

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
        SearchState state = (SearchState) evt.getNewValue();
        if (state.getNoResultError() != null) {
            JOptionPane.showMessageDialog(this, state.getNoResultError());
            state.setNoResultError(null);
        }
        else if (state.getNoInputError() != null){
            JOptionPane.showMessageDialog(this, state.getNoInputError());
            state.setNoInputError(null);
        }
        else {
            setResults();
            resetResults();
        }
    }

    private void resetResults() {
        SearchViewModel.resetSongLabels();
        SearchViewModel.resetSongWriterLabels();
        SearchViewModel.resetArtistLabels();
    }

    //this is where the user can choose to add a song resulting from a search to a
    //playlist or see information about it
    private void setResults() {
        ArrayList<String> songLabels = SearchViewModel.SONG_LABELS;
        ArrayList<String> songWriterLabels = SearchViewModel.SONG_WRITER_LABELS;
        ArrayList<String> artistLabels = SearchViewModel.ARTIST_LABELS;
        if (!addButtons.isEmpty()|!likeButtons.isEmpty()){
            addButtons.clear();
            likeButtons.clear();
            this.removeAll();
            this.repaint();
            reconstruct();
        }
        if (!songLabels.isEmpty()){
            for (int i = 0; i < SearchViewModel.SONG_LABELS.size(); i++){
                oneSongResult(songLabels.get(i), songWriterLabels.get(i), i);
            }
        }
        else if (!artistLabels.isEmpty()){
            for (int i = 0; i < SearchViewModel.ARTIST_LABELS.size(); i++){
                oneArtistResult(SearchViewModel.ARTIST_LABELS.get(i));
            }
        }
    }

    private void oneSongResult(String songName, String songWriter, int index){
        JLabel songLabel = new JLabel(songName);
        JLabel songWriterLabel = new JLabel(songWriter);
        JButton add = new JButton(SearchViewModel.ADD_BUTTON_LABEL);
        JButton stats = new JButton(SearchViewModel.GET_INFO_LABEL);
        JPanel resultLine = new JPanel();
        resultLine.add(songLabel);
        resultLine.add(songWriterLabel);
        resultLine.add(add);
        resultLine.add(stats);
        stats.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(stats)) {
                            SearchState currentState = searchViewModel.getState();
                            getStatsController.execute(currentState.getSongIDs().get(index));
                        }
                    }
                }
        );
        this.add(resultLine);

    }
    private void oneArtistResult(String artistName){
        JLabel artistLabel = new JLabel(artistName);
        JButton like = new JButton(SearchViewModel.LIKE_ARTIST_BUTTON_LABEL);
        JPanel resultLine = new JPanel();
        resultLine.add(artistLabel);
        resultLine.add(like);
        this.add(resultLine);
        likeButtons.add(like);
    }
    private void resetButtons(ArrayList<JButton> buttons){
        buttons.clear();
    }
    private void reconstruct(){
        JLabel title = new JLabel(SearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel buttons = new JPanel();
        buttons.add(backToHome);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension( 580, 400 ));
        this.add(title);
        this.add(buttons);
        backToHome.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(backToHome)){
                            // Doesn't pass in any parameter. Switch view to HomepageView.
                            SearchView.this.viewManagerModel.setActiveView(SearchView.this.homepageViewModel.getViewName());
                            SearchView.this.viewManagerModel.firePropertyChanged();

                        }
                    }
                }
        );
    }

}
