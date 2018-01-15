package nl.avans.ui;

import nl.avans.logic.database.Database;

import javax.swing.*;
import java.awt.*;

//Title and layout of the application
public abstract class ContainerContent extends JPanel {

    protected Database database;
    private String titleString;

    public ContainerContent(String titleString, Database database) {
        this.titleString = titleString;
        this.database = database;
        this.createDefaultComponents();
    }

    private void createDefaultComponents() {

        //Set layout
        this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(NetflixWindow.TRANSPARENT);

        //Add title
        JLabel title = new JLabel(this.titleString);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(NetflixWindow.SECONDARY_COLOR);
        title.setFont(NetflixWindow.FONT_BIG);
        this.add(title,BorderLayout.NORTH);
    }

    public void refresh() {
        this.removeAll();
        createDefaultComponents();
        createComponents();
    }

    protected abstract void createComponents();
}
