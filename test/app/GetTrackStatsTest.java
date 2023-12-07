package app;

import org.junit.Test;
import org.junit.Assert;
import view.SearchView;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertNotNull;

public class GetTrackStatsTest {

    public JButton getButton() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app);

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        SearchView sv = (SearchView) jp2.getComponent(2);

        JPanel resultLine = (JPanel) sv.getComponent(2);

        return (JButton) resultLine.getComponent(2); // this should be the get stats button
    }

    @org.junit.Test
    public void testGetStatsButtonPresent() {
        Main.main(null);
        JButton button = getButton();
        assert(button.getText().equals("Show Stats"));
    }
}
