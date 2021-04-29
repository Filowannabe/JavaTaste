package views.utils;

import javax.swing.JPanel;

import Navigator.Navigator;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class SliderUtils {

    private GeneralUtils generalUtils;

    public SliderUtils() {
        generalUtils = new GeneralUtils();
    }

    public JPanel initCarouselComponents(Navigator parent, JPanel grid, int width, int height, int rows, int columns) {

        grid.setLayout(new GridLayout(rows, columns, 20, 20));
        grid.setBackground(new Color(30, 30, 30));
        JPanel[] panel = new JPanel[columns];
        JLabel[] label = new JLabel[columns];

        for (int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel();
            label[i] = new JLabel();
            panel[i].setLayout(new BoxLayout(panel[i], BoxLayout.X_AXIS));
            label[i].setIcon(generalUtils.scaleImageToLabel("/views/images/Spirited_Away.jpg", width, height));
            goTempPage(label, i, parent);
            panel[i].add(label[i]);
            grid.add(panel[i]);
        }
        return grid;
    }

    public void goTempPage(JLabel[] label, int i, Navigator parent) {
        label[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.goHelloPage(0, 0, parent.getBodyWidth(), parent.getBodyHeight());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    }
}
