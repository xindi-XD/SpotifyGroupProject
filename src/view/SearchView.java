package view;

import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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

    }
    //this is where the user can choose to add a song resulting from a search to a
    //playlist or see information about it

}
