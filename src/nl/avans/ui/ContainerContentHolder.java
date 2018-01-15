package nl.avans.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ContainerContentHolder extends JPanel {

    public ContainerContentHolder() {
        this.createComponents();
    }

    public void viewContainer(ContainerContent container) {

        //Make them invisible
        this.removeAll();
        this.repaint();
        this.revalidate();
        this.add(container);
        this.repaint();
        this.revalidate();

        //Refresh data inside the container
        container.refresh();
    }

    private void createComponents() {

        //Set container layout
        this.setLayout(new CardLayout());
        this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        this.setOpaque(false);
    }
}
