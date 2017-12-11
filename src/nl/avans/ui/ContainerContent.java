package nl.avans.ui;

import javax.swing.*;
import java.awt.*;

public class ContainerContent extends JPanel {

    public ContainerContent() {
        this.createComponents();
    }

    private void createComponents() {

        //Set layout
        this.setLayout(new BorderLayout());
        this.setBackground(NetflixWindow.THIRD_COLOR);


    }
}
