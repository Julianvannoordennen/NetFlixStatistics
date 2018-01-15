package nl.avans.ui;

import nl.avans.ui.controls.ContainerMenuButton;

import javax.swing.*;
import java.awt.*;

// the menu layout and items
public class ContainerMenu extends JPanel {

    public ContainerMenu(ContainerMenuButton[] menuItems) {
        this.createComponents(menuItems);
    }

    private void createComponents(ContainerMenuButton[] menuItems) {

        //Set panel layout
        this.setLayout(new FlowLayout());
        this.setBackground(NetflixWindow.PRIMARY_COLOR);
        this.setMinimumSize(new Dimension(200, 400));
        this.setPreferredSize(new Dimension(200, 400));

        //Create logo
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(new ImageIcon(new ImageIcon("res/logo.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        imgLabel.setMinimumSize(new Dimension(200, 200));
        imgLabel.setPreferredSize(new Dimension(200, 200));
        imgLabel.setMaximumSize(new Dimension(200, 200));
        this.add(imgLabel, BorderLayout.NORTH);

        //Create menu items
        for (ContainerMenuButton item : menuItems)
            this.add(item);
    }
}
