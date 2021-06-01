package views.widgets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
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
import java.awt.event.MouseAdapter;

public class CarouselWidget extends JPanel {
    private Navigator parent;
    private GeneralUtils generalUtils;
    private CarouselUtils carouselUtils;
    private JScrollBar horizontalMovement;
    private JScrollPane scrollBar;
    private JButton left;
    private JButton right;
    private final int CAROUSEL_HEIGHT;
    private final int CAROUSEL_LAST_ITEM;
    private final int CAROUSEL_ITEMS_NUMBER;
    private Timer carouselTimer = new Timer();
    private TimerTask timerTask;

    public CarouselWidget(Navigator parent, int width, int height) {
        this.parent = parent;

        CAROUSEL_HEIGHT = height;
        CAROUSEL_ITEMS_NUMBER = 3;
        CAROUSEL_LAST_ITEM = parent.getBodyWidth() * CAROUSEL_ITEMS_NUMBER - parent.getBodyWidth();

        generalUtils = new GeneralUtils();
        carouselUtils = new CarouselUtils();

        JPanel flowLayout = new JPanel();
        JPanel gridLayout = new JPanel();
        flowLayout.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        flowLayout.add(carouselUtils.initCarouselComponents(gridLayout, parent.getBodyWidth(), CAROUSEL_HEIGHT, 0,
                CAROUSEL_ITEMS_NUMBER));

        left = new JButton();
        left.setBounds(0, CAROUSEL_HEIGHT / 2, 54, 70);
        left.setVisible(false);
        right = new JButton();
        right.setBounds(parent.getBodyWidth() - (54 + 18), CAROUSEL_HEIGHT / 2, 54, 70);
        right.setVisible(false);

        generalUtils.buttonChangeColorOrForeground(left, 0, 0, 0, true);
        generalUtils.buttonChangeColorOrForeground(left, 0, 255, 0, false);
        generalUtils.changeFontAndText(left, true, "Tahoma", 15, "<");

        generalUtils.buttonChangeColorOrForeground(right, 0, 0, 0, true);
        generalUtils.buttonChangeColorOrForeground(right, 0, 255, 0, false);
        generalUtils.changeFontAndText(right, true, "Tahoma", 15, ">");

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

        stopSlideSystem(left);
        stopSlideSystem(right);
        stopSlideSystem(scrollBar);
        setSize(width, height);
        add(right);
        add(left);
        add(scrollBar);
    }

    public void repaintCarousel() {
        repaint();
        revalidate();
        left.repaint();
        left.revalidate();
        right.repaint();
        right.revalidate();
        scrollBar.repaint();
        scrollBar.revalidate();
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

    private void goRight(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemSlide(1);
            }
        });
    }

    private void goLeft(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemSlide(0);
            }
        });
    }

    private void stopSlideSystem(JButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cancelTimer();
                right.setVisible(true);
                left.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                slideCarouselTimer();
                right.setVisible(false);
                left.setVisible(false);
            }
        });
    }

    private void stopSlideSystem(JScrollPane pane) {
        pane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cancelTimer();
                right.setVisible(true);
                left.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                slideCarouselTimer();
                right.setVisible(false);
                left.setVisible(false);
            }
        });
    }

    private void slideCarouselTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                itemSlide(1);
                repaintCarousel();
            }
        };
        carouselTimer.schedule(timerTask, 5000, 5000);
    }

    private void cancelTimer() {
        try {
            timerTask.cancel();
        } catch (Exception e) {
        }
    }

}