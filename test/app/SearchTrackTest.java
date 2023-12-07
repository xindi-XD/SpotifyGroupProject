package app;

import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylistFactory;
import entity.PlaylistFactory;
import interface_adapter.search.SearchPresenter;
import org.junit.Test;
import use_case.search.SearchOutputData;
import view.HomepageView;
import view.LabelTextPanel;
import view.SearchView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SearchTrackTest {
    static String message = "";
    static boolean popUpDiscovered = false;
    public JTextField getSearchBar(){
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }
        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        HomepageView hv = (HomepageView) jp2.getComponent(0);

        LabelTextPanel searchInfo = (LabelTextPanel) hv.getComponent(1);
        JTextField searchField = (JTextField) searchInfo.getComponent(1);
        return searchField;
    }

    public JComboBox<String> getDropDown(){
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }
        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        HomepageView hv = (HomepageView) jp2.getComponent(0);

        JPanel type = (JPanel) hv.getComponent(2);
        JComboBox<String> dropdown = (JComboBox<String>)  type.getComponent(1);
        return dropdown;
    }
    public JButton getButton() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }
        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        HomepageView hv = (HomepageView) jp2.getComponent(0);

        JPanel type = (JPanel) hv.getComponent(2);
        JButton search = (JButton) type.getComponent(2);

        return search; // this should be the clear button
    }

    public void setNormalTrackName(JTextField searchField){
        searchField.setText("I'm a genius");
    }
    public void setQuirkyTrackName(JTextField searchField){
        searchField.setText("o/r][[.;4p21.f';g.'.[pl"); // TODO: to be tested.
    }
    @org.junit.Test
    public void testSearchButtonPresent() {
        Main.main(null);
        JButton button = getButton();
        assert(button.getText().equals("Search"));
    }
    @org.junit.Test
    public void testDropDownPresent(){
        Main.main(null);
        JComboBox<String> dropdown = getDropDown();
        assert(dropdown.getItemAt(0).equals("track"));
        assert(dropdown.getItemAt(1).equals("artist"));
    }
    @org.junit.Test
    public void testSearchBarPresent(){
        Main.main(null);
        JTextField searchBar = getSearchBar();
        // Don't use .equals(null), use .isEmpty().
        assert(searchBar.getText().isEmpty());
    }

    @org.junit.Test
    public void testNormalTrack(){
    }

    @org.junit.Test
    public void testNoInput(){
        Main.main(null);
        JButton button = getButton();
        createCloseTimer().start();

        button.doClick();
        assert(message.contains("Please input search item."));
    }
    @org.junit.Test
    public void testNoInputPopupShown(){
        popUpDiscovered = false;

        Main.main(null);
        JFrame app = null;

        JButton button = getButton();
        createCloseTimer().start();

        button.doClick();
        assert(popUpDiscovered);
        System.out.println("popup was detected successfully.");
    }

    @org.junit.Test
    public void testNoTrackReturned(){
        popUpDiscovered = false;

        Main.main(null);
        JFrame app = null;

        JButton button = getButton();
        JTextField searchBar = getSearchBar();
        JComboBox dropDown = getDropDown();

        createCloseTimer().start();

        button.doClick();
        assert(popUpDiscovered);
        System.out.println("popup was detected successfully.");
    }
    private Timer createCloseTimer() {
        ActionListener close = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Window[] windows = Window.getWindows();
                for (Window window : windows) {

                    if (window instanceof JDialog) {

                        JDialog dialog = (JDialog)window;

                        // this ignores old dialogs
                        if (dialog.isVisible()) {
                            String s = ((JOptionPane) ((BorderLayout) dialog.getRootPane()
                                    .getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)).getMessage().toString();
                            System.out.println("message = " + s);

                            // store the information we got from the JDialog
                            SearchTrackTest.message = s;
                            SearchTrackTest.popUpDiscovered = true;

                            System.out.println("disposing of..." + window.getClass());
                            window.dispose();
                        }
                    }
                }
            }

        };

        Timer t = new Timer(1000, close);
        t.setRepeats(false);
        return t;
    }
}


