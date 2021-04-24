package views.widgets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import Navigator.Navigator;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import views.utils.CarouselUtils;
import views.utils.GeneralUtils;

public class CarouselWidget extends JPanel {
    Navigator parent;
    GeneralUtils generalUtils;
    CarouselUtils carouselUtils;

    private JScrollBar horizontalMovement;
    private JScrollPane scrollBar;
    JButton left;
    JButton right;
    private JPanel bodyCarousel;

    public CarouselWidget(Navigator parent) {
        generalUtils = new GeneralUtils();
        carouselUtils = new CarouselUtils();
        bodyCarousel = new JPanel();
        this.parent = parent;

        JPanel flowLayout = new JPanel();
        flowLayout.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JPanel gridLayout = new JPanel();
        gridLayout.setLayout(new java.awt.GridLayout(0, 3, 0, 0));
        flowLayout.add(gridLayout);
        carouselUtils.initCarouselComponents(gridLayout);

        left = new JButton();
        right = new JButton();

        left.setBounds(0, parent.getBodyHeight() / 3, 54, 70);
        right.setBounds(parent.getBodyWidth() - 54, parent.getBodyHeight() / 3, 54, 70);

        generalUtils.buttonChangeColorOrForeground(left, 0, 0, 0, true);
        generalUtils.buttonChangeColorOrForeground(left, 0, 255, 0, false);
        generalUtils.changeFontAndText(left, true, "Arial", 15, "<");

        generalUtils.buttonChangeColorOrForeground(right, 0, 0, 0, true);
        generalUtils.buttonChangeColorOrForeground(right, 0, 255, 0, false);
        generalUtils.changeFontAndText(right, true, "Arial", 15, ">");

        generalUtils.customizeButton(left, false);
        generalUtils.customizeButton(right, false);

        goRight(right);
        goLeft(left);

        scrollBar = new JScrollPane();
        horizontalMovement = scrollBar.getHorizontalScrollBar();
        scrollBar.setViewportView(flowLayout);
        scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollBar.setBackground(Color.BLACK);
        scrollBar.setBounds(0, 0, parent.getBodyWidth(), parent.getBodyHeight() - 200);

        JButton test = new JButton();
        generalUtils.buttonChangeColorOrForeground(test, 0, 255, 0, true);
        generalUtils.buttonChangeColorOrForeground(test, 255, 255, 255, false);
        test.setBounds(0, parent.getBodyHeight() - 200, parent.getBodyWidth(), 150);
        generalUtils.customizeButton(test, false);
        generalUtils.changeFontAndText(test, true, "Times New Roman", 15, "Home");
        goHomePage(test);

        bodyCarousel.add(left);
        bodyCarousel.add(right);
        bodyCarousel.add(scrollBar);
        bodyCarousel.add(test);
        bodyCarousel.setBackground(Color.BLACK);
        bodyCarousel.setLayout(null);
        bodyCarousel.setBounds(0, 0, parent.getBodyWidth(), parent.getBodyHeight());

        add(bodyCarousel);
    }

    public void repaintCarousel() {
        this.bodyCarousel.repaint();
        this.bodyCarousel.revalidate();
        this.left.repaint();
        this.left.revalidate();
        this.right.repaint();
        this.right.revalidate();
        this.scrollBar.repaint();
        this.scrollBar.revalidate();
    }

    private void itemSlide(int control) {
        repaintCarousel();
        if (control == 0) {
            if (scrollBar.getHorizontalScrollBar().getValue() == 0) {
                horizontalMovement.setValue(3840);

            } else {
                horizontalMovement.setValue(scrollBar.getHorizontalScrollBar().getValue() - 1922);
            }
        }
        if (control == 1) {
            if (scrollBar.getHorizontalScrollBar().getValue() > 1922) {
                horizontalMovement.setValue(0);

            } else {
                horizontalMovement.setValue(scrollBar.getHorizontalScrollBar().getValue() + 1922);
            }
        }
    }

    public void goHomePage(JButton btn) {
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                parent.goHomePage(0, 0, parent.getBodyWidth(), parent.getBodyHeight());
            }

        });
    }

    public void goRight(JButton btn) {
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                itemSlide(1);
            }
        });
    }

    public void goLeft(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemSlide(0);
            }
        });
    }
}