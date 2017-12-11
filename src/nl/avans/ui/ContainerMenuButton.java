package nl.avans.ui;

import javax.swing.*;
import java.awt.*;

public class ContainerMenuButton extends JPanel {

    public ContainerMenuButton(String itemText) {
        this.createComponents(itemText);
    }

    private void createComponents(String itemText) {

        //Make transparent
        this.setOpaque(false);

        //Create panel text
        JLabel menuItem = new JLabel(itemText);
        menuItem.setForeground(NetflixWindow.FOURTH_COLOR);
        menuItem.setFont(NetflixWindow.FONT_BIG);

        //Add label
        this.add(menuItem);
    }
}
