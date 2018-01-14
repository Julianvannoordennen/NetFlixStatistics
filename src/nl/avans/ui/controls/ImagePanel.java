package nl.avans.ui.controls;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JComponent {

    private Image image;

    public ImagePanel(Image image) {

        //Save image
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {

        //Draw image
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}