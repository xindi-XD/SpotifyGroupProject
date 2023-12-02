package view;

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
    private final JButton add1;
    private final SearchViewModel searchViewModel;
    public SearchView(SearchViewModel searchViewModel){
        this.searchViewModel = searchViewModel;
        searchViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

//        JLabel song2 = new JLabel(SearchViewModel.SONG2_LABEL);
//        JLabel song3 = new JLabel(SearchViewModel.SONG3_LABEL);
//        JLabel song4 = new JLabel(SearchViewModel.SONG4_LABEL);
//        JLabel song5 = new JLabel(SearchViewModel.SONG5_LABEL);
//        JLabel song1 = new JLabel(SearchViewModel.SONG1_LABEL);
        add1 = new JButton(SearchViewModel.ADD_BUTTON_LABEL);
//
//        JPanel resultLine1 = new JPanel();
//        resultLine1.add(song1);
//        resultLine1.add(add1);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchState state = (SearchState) evt.getNewValue();
        setResults();
    }
    //this is where the user can choose to add a song resulting from a search to a
    //playlist or see information about it
    private void setResults() {
        for (int i = 0; i < SearchViewModel.SONG_LABELS.size(); i++){
            oneResult(SearchViewModel.SONG_LABELS.get(i));
        }
    }

    private void oneResult(String songName){
        JLabel songLabel = new JLabel(songName);
        JButton add = new JButton(SearchViewModel.ADD_BUTTON_LABEL);
        JPanel resultLine = new JPanel();
        resultLine.add(songLabel);
        resultLine.add(add);
        this.add(resultLine);
    }

}
