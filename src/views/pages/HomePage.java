package views.pages;

import javax.swing.JPanel;
import java.awt.Color;
import views.utils.GeneralUtils;
import views.widgets.CarouselWidget;
import views.widgets.SliderWidget;
import Navigator.Navigator;

public class HomePage extends JPanel {
    private Navigator parent;
    private GeneralUtils generalUtils;
    private CarouselWidget carousel;
    private int sliderHeight = 0;
    private SliderWidget[] sliders;

    public HomePage(Navigator parent) {
        this.parent = parent;
        generalUtils = new GeneralUtils();
        carousel = new CarouselWidget(parent, parent.getBodyWidth() - 18, 500);
        bodyAddComponent(carousel, 0, 0);

        sliders = new SliderWidget[5];
        sliderHeight = 500;
        for (int i = 0; i < sliders.length; i++) {
            sliders[i] = new SliderWidget(parent, parent.getBodyWidth() - 18, 400);
            bodyAddComponent(sliders[i], 0, sliderHeight);
            sliderHeight += 400;
        }
        setBackground(Color.BLACK);
    }

    public int getHomeHeight() {
        return this.sliderHeight;
    }

    private void bodyAddComponent(JPanel panel, int x, int y) {
        panel.setLocation(x, y);
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        add(panel);
    }
}
