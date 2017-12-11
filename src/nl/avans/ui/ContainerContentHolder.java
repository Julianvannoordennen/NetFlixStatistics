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

    private void createComponents() {

        //Set container layout
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        this.setOpaque(false);

        //Create content container
        this.add(new ContainerContent(), BorderLayout.CENTER);
    }
}
