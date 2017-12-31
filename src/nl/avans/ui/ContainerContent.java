package nl.avans.ui;

import javax.swing.*;
import java.awt.*;

public abstract class ContainerContent extends JPanel {

    public ContainerContent(String titleString) {
        this.createComponents(titleString);
    }

    private void createComponents(String titleString) {

        //Set layout
        this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        this.setLayout(new BorderLayout());
        this.setBackground(NetflixWindow.THIRD_COLOR);

        //Add title
        JLabel title = new JLabel(titleString);
        title.setForeground(NetflixWindow.SECONDARY_COLOR);
        title.setFont(NetflixWindow.FONT_BIG);
        this.add(title,BorderLayout.NORTH);
    }
}
