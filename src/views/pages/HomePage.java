package views.pages;

import javax.swing.JPanel;
import java.awt.Color;
import views.utils.GeneralUtils;
import views.widgets.CarouselWidget;
import views.widgets.SliderWidget;
import Navigator.Navigator;

public class HomePage extends JPanel {
    Navigator parent;
    CarouselWidget carousel;
    GeneralUtils generalUtils;
    SliderWidget slider;
    SliderWidget slider2;
    SliderWidget slider3;

    public HomePage(Navigator parent) {
        this.parent = parent;
        generalUtils = new GeneralUtils();

        carousel = new CarouselWidget(parent, parent.getBodyWidth()-18, 500);
        slider = new SliderWidget(parent, parent.getBodyWidth(), 400);
        slider2 = new SliderWidget(parent, parent.getBodyWidth(), 400);
        slider3 = new SliderWidget(parent, parent.getBodyWidth(), 400);

        bodyAddComponent(carousel, 0, 0);
        bodyAddComponent(slider, 0, 500);
        bodyAddComponent(slider2, 0, 900);
        bodyAddComponent(slider3, 0, 1300);
 
        setBackground(Color.BLACK);
    }

    public void bodyAddComponent(JPanel panel, int x, int y) {
        panel.setLocation(x, y);
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        add(panel);
    }

}