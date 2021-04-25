package views.utils;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class CarouselUtils {

    private GeneralUtils generalUtils;

    public CarouselUtils() {
        generalUtils = new GeneralUtils();
    }

    public JPanel initCarouselComponents(JPanel grid, int size, int width, int height, int rows, int columns) {

        grid.setLayout(new GridLayout(rows, columns, 0, 0));
        JPanel[] panel = new JPanel[size];
        JLabel[] label = new JLabel[size];

        for (int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel();
            label[i] = new JLabel();
            panel[i].setLayout(new BoxLayout(panel[i], BoxLayout.X_AXIS));

            if (i == 0) {
                label[i].setIcon(generalUtils.scaleImageToLabel("/views/images/1.jpg", width, height));
            }
            if (i == 1) {
                label[i].setIcon(generalUtils.scaleImageToLabel("/views/images/2.jpg", width, height));
            }
            if (i == 2) {
                label[i].setIcon(generalUtils.scaleImageToLabel("/views/images/3.jpg", width, height));
            }
            panel[i].add(label[i]);
            grid.add(panel[i]);
        }
        return grid;
    }
}
