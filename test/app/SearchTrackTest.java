package app;

import data_access.FilePlaylistDataAccessObject;
import entity.CommonPlaylistFactory;
import entity.PlaylistFactory;
import org.junit.Test;
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
    @Test
    public void getSearchBar(){
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
//        JButton search = (JButton) searchInfo.getComponent(2);
//        return search; // this should be the clear button
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
    @org.junit.Test
    public void testSearchButtonPresent() {
        Main.main(null);
        JButton button = getButton();
        assert(button.getText().equals("Search"));
    }
    @org.junit.Test
    public void testSearchTrack(){

    }

    @org.junit.Test
    public void testNoInput(){

    }

    @org.junit.Test
    public void testNoTrackReturned(){}
}
