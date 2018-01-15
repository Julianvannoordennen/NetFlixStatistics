package nl.avans.ui.controls;

import nl.avans.ui.NetflixWindow;

import javax.swing.*;
import java.awt.*;

//for the save and delete button
public class NetflixSaveDelete extends JPanel {

    private JButton saveButton;
    private JButton deleteButton;

    public NetflixSaveDelete() {
        super();
        setDefault();
    }

    public JButton getSave() {
        return this.saveButton;
    }

    public JButton getDelete() {
        return this.deleteButton;
    }

    private void setDefault() {

        //Set layout
        //this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setLayout(new BorderLayout());

        //Create 2 buttons
        this.saveButton = new JButton("Save");
        this.deleteButton = new JButton("Delete");
        this.add(this.saveButton, BorderLayout.WEST);
        this.add(this.deleteButton, BorderLayout.EAST);
        this.setMaximumSize(new Dimension(9999,100));
        this.setBackground(NetflixWindow.TRANSPARENT);
    }
}
