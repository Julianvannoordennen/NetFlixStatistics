package nl.avans.ui;

import nl.avans.logic.database.Database;

import javax.swing.*;
import java.awt.*;

public abstract class ContainerContent extends JPanel {

    protected Database database;

    public ContainerContent(String titleString, Database database) {
        this.database = database;
        this.createComponents(titleString);
    }

    private void createComponents(String titleString) {

        //Set layout
        this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(NetflixWindow.THIRD_COLOR);

        //Add title
        JLabel title = new JLabel(titleString);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(NetflixWindow.SECONDARY_COLOR);
        title.setFont(NetflixWindow.FONT_BIG);
        this.add(title,BorderLayout.NORTH);
    }
}
