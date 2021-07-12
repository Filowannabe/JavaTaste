package Navigator;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import views.pages.HomePage;
import views.pages.MediaPlayerPage;
import views.pages.HelloPage;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javafx.embed.swing.JFXPanel;


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

    public void goMediaPlayerPage(int width, int height) {
        scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        body.removeAll();
        setBodyLayoutGroup(height);
        JFXPanel fxPanel = new MediaPlayerPage().getPanel();
        setMediaPlayerBodyLayoutGroup(body, fxPanel, width, height);
        repaintAndRevalidate();
        body.add(fxPanel);
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
        scrollBar.setBackground(Color.BLACK);
        scrollBar.setBounds(0, 0, getBodyWidth(), getBodyHeight());
    }

    public void setBodyLayoutGroup(int height) {
        bodyLayout.setHorizontalGroup(
                bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
        bodyLayout.setVerticalGroup(
                bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, height, Short.MAX_VALUE));
    }

    private void setMediaPlayerBodyLayoutGroup(JPanel body, JFXPanel bodyContent, int width, int height) {
        bodyLayout = new GroupLayout(body);
        body.setLayout(bodyLayout);
        body.setBackground(new Color(36, 36, 36));
        bodyLayout.setHorizontalGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(bodyContent, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)));
        bodyLayout.setVerticalGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup().addGap(0, 0, 0)
                        .addComponent(bodyContent, GroupLayout.PREFERRED_SIZE, height, GroupLayout.PREFERRED_SIZE)));
    }
}
