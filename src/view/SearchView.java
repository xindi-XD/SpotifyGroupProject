package view;

import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search results";
    private final SearchViewModel searchViewModel;
    public SearchView(SearchViewModel searchViewModel){
        this.searchViewModel = searchViewModel;
        searchViewModel.addPropertyChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchState state = (SearchState) evt.getNewValue();
        setFields(state);
    }
    //this is where the user can choose to add a song resulting from a search to a
    //playlist or see information about it
    private void setFields(SearchState state) {
        ArrayList<String> songNames = state.getSongNames();
        searchViewModel.setSongLabels(songNames);
    }

}
