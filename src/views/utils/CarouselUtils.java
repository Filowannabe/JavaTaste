package views.utils;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class CarouselUtils {

    public void initCarouselComponents(JPanel grid) {
        JPanel[] panel = new JPanel[3];
        JLabel[] label = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            panel[i] = new JPanel();
            label[i] = new JLabel();
            panel[i].setLayout(new BoxLayout(panel[i], BoxLayout.X_AXIS));

            if (i == 0) {
                label[i].setIcon(new ImageIcon(getClass().getResource("/views/images/1.jpg")));
            }
            if (i == 1) {
                label[i].setIcon(new ImageIcon(getClass().getResource("/views/images/2.jpg")));
            }
            if (i == 2) {
                label[i].setIcon(new ImageIcon(getClass().getResource("/views/images/3.jpg")));
            }
            panel[i].add(label[i]);
            grid.add(panel[i]);
        }
    }
}
