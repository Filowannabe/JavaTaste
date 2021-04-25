package views.pages;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.utils.GeneralUtils;

import Navigator.Navigator;

public class HomePage extends JPanel {

    private JLabel title;
    private JButton switcher;
    private JPanel homeBody;
    private JPanel blackWindow;
    private JLabel background;
    private GeneralUtils generalUtils;
    private Navigator parent = new Navigator();
    private final int COMPONENTS_IN_X = parent.getBodyWidth() / 2 - ((parent.getBodyWidth() / 20) / 2);

    public HomePage(Navigator parent) {
        this.parent = parent;
        generalUtils = new GeneralUtils();

        background = new JLabel();
        background.setBounds(0, 0, parent.getBodyWidth(), parent.getBodyHeight());
        background.setIcon(generalUtils.scaleImageToLabel("/views/images/bghack.jpg", parent.getBodyWidth(),
                parent.getBodyHeight()));

        blackWindow = new JPanel();
        blackWindow.setLayout(null);
        blackWindow.setBounds(0, 0, parent.getBodyWidth(), parent.getBodyHeight());
        blackWindow.setBackground(new Color(0, 0, 0, 150));

        title = new JLabel();
        title.setBounds(COMPONENTS_IN_X - 50, 250, parent.getBodyWidth(), 50);
        title.setForeground(Color.WHITE);

        switcher = new JButton();
        switcher.setBounds(COMPONENTS_IN_X, parent.getBodyHeight() / 2, parent.getBodyWidth() / 20, 30);
        generalUtils.changeFontAndText(switcher, true, "Times New Roman", 15, "Switch");
        goCarousel(switcher);

        generalUtils.buttonChangeColorOrForeground(switcher, 0, 255, 0, true);
        generalUtils.buttonChangeColorOrForeground(switcher, 255, 255, 255, false);
        generalUtils.customizeButton(switcher, false);
        generalUtils.changeFontAndText(title, true, "Times New Roman", 40, "Hello world");

        homeBody = new JPanel();
        homeBody.setLayout(null);
        homeBody.add(title);
        homeBody.add(switcher);
        homeBody.add(blackWindow);
        homeBody.add(background);
        homeBody.setBackground(Color.RED);
        homeBody.setBounds(0, 0, parent.getBodyWidth(), parent.getBodyHeight());
        add(homeBody);
    }

    public void goCarousel(JButton btn) {
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                parent.goCarousel(0, 0, parent.getBodyWidth(), parent.getBodyHeight());
            }
        });
    }
}
