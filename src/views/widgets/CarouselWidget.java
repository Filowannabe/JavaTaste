package views.widgets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import Navigator.Navigator;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import views.utils.CarouselUtils;
import views.utils.GeneralUtils;

public class CarouselWidget extends JPanel {
    private Navigator parent;
    private GeneralUtils generalUtils;
    private CarouselUtils carouselUtils;
    private JScrollBar horizontalMovement;
    private JScrollPane scrollBar;
    private JButton left;
    private JButton right;
    private JPanel bodyCarousel;
    private final int CAROUSEL_HEIGHT;
    private final int CAROUSEL_LAST_ITEM;
    private final int CAROUSEL_ITEMS_NUMBER;

    public CarouselWidget(Navigator parent) {
        this.parent = parent;
        CAROUSEL_HEIGHT = parent.getBodyHeight() - 200;
        CAROUSEL_ITEMS_NUMBER = 3;
        CAROUSEL_LAST_ITEM = parent.getBodyWidth() * CAROUSEL_ITEMS_NUMBER - parent.getBodyWidth();

        generalUtils = new GeneralUtils();
        carouselUtils = new CarouselUtils();
        bodyCarousel = new JPanel();

        JPanel flowLayout = new JPanel();
        JPanel gridLayout = new JPanel();
        flowLayout.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        flowLayout.add(carouselUtils.initCarouselComponents(gridLayout, 5, parent.getBodyWidth(), CAROUSEL_HEIGHT, 0,
                CAROUSEL_ITEMS_NUMBER));

        left = new JButton();
        left.setBounds(0, CAROUSEL_HEIGHT / 2, 54, 70);
        right = new JButton();
        right.setBounds(parent.getBodyWidth() - 54, CAROUSEL_HEIGHT / 2, 54, 70);

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
        scrollBar.setBounds(0, 0, parent.getBodyWidth(), CAROUSEL_HEIGHT);

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
                horizontalMovement.setValue(CAROUSEL_LAST_ITEM);
            } else {
                horizontalMovement.setValue(scrollBar.getHorizontalScrollBar().getValue() - parent.getBodyWidth());
            }
        }
        if (control == 1) {
            if (scrollBar.getHorizontalScrollBar().getValue() == CAROUSEL_LAST_ITEM) {
                horizontalMovement.setValue(0);
            } else {
                horizontalMovement.setValue(scrollBar.getHorizontalScrollBar().getValue() + parent.getBodyWidth());
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