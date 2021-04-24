package Navigator;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.pages.HomePage;
import views.widgets.CarouselWidget;

public class Navigator extends JFrame {
    JPanel body;
    Toolkit screen = Toolkit.getDefaultToolkit();
    Dimension sizeScreen = screen.getScreenSize();
    private int navigatorWidth = sizeScreen.width;
    private int navigatorHeight = sizeScreen.height;

    public Navigator() {
        body = new JPanel();
        body.setSize(navigatorWidth, navigatorHeight);
        body.setBackground(Color.BLUE);
        body.setLayout(null);
        add(body);
    }

    public void bodyAddComponent(JPanel panel, int x, int y, int width, int height) {
        panel.setBounds(x, y, width, height);
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        body.add(panel);
    }

    public void goCarousel(int x, int y, int width, int height) {
        body.removeAll();
        repaintAndRevalidate();
        CarouselWidget carousel = new CarouselWidget(this);
        carousel.setBounds(x, y, width, height);
        carousel.setLayout(null);
        body.add(carousel);
        repaintAndRevalidate();
    }

    public void goHomePage(int x, int y, int width, int height) {
        body.removeAll();
        repaintAndRevalidate();
        HomePage homePage = new HomePage(this);
        homePage.setBounds(x, y, width, height);
        homePage.setLayout(null);
        body.add(homePage);
        repaintAndRevalidate();
    }

    public int getBodyHeight() {
        int height = sizeScreen.height;
        return height;
    }

    public int getBodyWidth() {
        int width = sizeScreen.width;
        return width;
    }

    public void bodyReAdd(JPanel panel, int x, int y, int width, int height) {
        body.removeAll();
        repaintAndRevalidate();

        panel.setBounds(x, y, width, height);
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        body.add(panel);
        repaintAndRevalidate();
    }

    public void repaintAndRevalidate() {
        body.repaint();
        body.revalidate();
    }

    public void initComponents() {
        setVisible(true);
        setBounds(0, 0, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

}
