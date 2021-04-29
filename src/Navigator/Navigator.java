package Navigator;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.pages.HomePage;
import views.pages.HelloPage;

public class Navigator extends JFrame {
    private JPanel body;
    private Toolkit screen = Toolkit.getDefaultToolkit();
    private Dimension sizeScreen = screen.getScreenSize();
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

    public void goHelloPage(int x, int y, int width, int height) {
        body.removeAll();
        repaintAndRevalidate();
        HelloPage temp = new HelloPage(this);
        temp.setBounds(x, y, width, height);
        temp.setLayout(null);
        body.add(temp);
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
