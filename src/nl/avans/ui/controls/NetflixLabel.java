package nl.avans.ui.controls;

import nl.avans.ui.NetflixWindow;

import javax.swing.*;
import java.awt.*;

public class NetflixLabel extends JLabel {

    public NetflixLabel(String text) {
        super(text);
        setDefault();
    }

    private void setDefault() {

        //Change design from label
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setFont(NetflixWindow.FONT_SMALL_BOLD);
        this.setForeground(NetflixWindow.PRIMARY_COLOR);
    }
}
