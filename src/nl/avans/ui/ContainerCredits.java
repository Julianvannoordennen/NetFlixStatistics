package nl.avans.ui;

import javax.swing.*;
import java.awt.*;

public class ContainerCredits extends JPanel {

    public ContainerCredits() {
        this.createComponents();
    }

    private void createComponents() {

        //Set panel layout
        this.setLayout(new BorderLayout());
        this.setBackground(NetflixWindow.PRIMARY_COLOR);
        this.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 25));

        //Period label
        JLabel period = new JLabel("<html><br />Netflix Statistix<br />Informatica jaar 1, 23IVT1D1<br /></html>");
        period.setForeground(NetflixWindow.SECONDARY_COLOR);
        period.setFont(NetflixWindow.FONT_SMALL);
        this.add(period, BorderLayout.WEST);

        //Credits label
        JLabel credits = new JLabel("<html><br /><ul><li>Julian van Noordennen - 2127530</li><li>Szonja Hollos - 2128202</li><li>Tobias Willemsen - 2124631</li></ul><br /></html>");
        credits.setForeground(NetflixWindow.SECONDARY_COLOR);
        credits.setFont(NetflixWindow.FONT_SMALL);
        this.add(credits, BorderLayout.EAST);
    }
}
