package nl.avans.ui;

import javax.swing.*;
import java.awt.*;

public class ContainerMenu extends JPanel {

    public ContainerMenu() {
        this.createComponents();
    }

    private void createComponents() {

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
        String[] menuItems = {"Menuitem 1   ▶", "Menuitem 2   ▶", "Menuitem 3   ▶"};
        for (String item : menuItems) {

            //Create panel
            JPanel menuPanel = new ContainerMenuButton(item);
            this.add(menuPanel);
        }
    }
}
