package nl.avans.ui.controls;

import javax.swing.*;

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
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        //Create 2 buttons
        this.saveButton = new JButton("Save");
        this.deleteButton = new JButton("Delete");
        this.add(this.saveButton);
        this.add(this.deleteButton);
    }
}
