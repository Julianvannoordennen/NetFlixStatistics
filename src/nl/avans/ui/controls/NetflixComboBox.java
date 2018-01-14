package nl.avans.ui.controls;

import javax.swing.*;
import java.awt.*;

public class NetflixComboBox<E> extends JComboBox<E> {

    public NetflixComboBox() {
        setDefault();
    }

    private void setDefault() {

        //Set default design
        this.setMaximumSize(new Dimension(999999,100));
    }
}