package Navigator;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import views.pages.HomePage;
import views.pages.HelloPage;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Navigator extends JFrame {
    private JPanel body;
    private Toolkit screen = Toolkit.getDefaultToolkit();
    private Dimension sizeScreen = screen.getScreenSize();
    private GroupLayout bodyLayout;
    private JScrollPane scrollBar;

    public Navigator() {
        body = new JPanel();
        initBody(body, getBodyHeight());
        add(scrollBar);
    }

    public void bodyAddComponent(JPanel panel, int x, int y, int width, int height) {
        panel.setBounds(x, y, width, height);
        panel.setLayout(null);
        body.add(panel);
    }

    public void goHelloPage(int x, int y, int width, int height) {
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        body.removeAll();
        setBodyLayoutGroup(height);
        repaintAndRevalidate();
        HelloPage temp = new HelloPage(this);
        temp.setBounds(x, y, width, height);
        temp.setLayout(null);
        body.add(temp);
        repaintAndRevalidate();
    }

    public void goHomePage(int x, int y, int width, int height) {
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        body.removeAll();
        setBodyLayoutGroup(height);
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

        body.add(panel);
        repaintAndRevalidate();
    }

    public void repaintAndRevalidate() {
        body.repaint();
        body.revalidate();
    }

    public void initComponents() {
        setVisible(true);
        setBounds(0, 0, getBodyWidth(), getBodyHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void initBody(JPanel body, int height) {
        bodyLayout = new GroupLayout(body);
        body.setLayout(bodyLayout);
        setBodyLayoutGroup(height);
        scrollBar = new JScrollPane();
        scrollBar.setViewportView(body);
        scrollBar.setBackground(Color.BLUE);
        scrollBar.setBounds(0, 0, getBodyWidth(), getBodyHeight());
    }

    public void setBodyLayoutGroup(int height) {
        bodyLayout.setHorizontalGroup(
                bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
        bodyLayout.setVerticalGroup(
                bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, height, Short.MAX_VALUE));
    }

}
