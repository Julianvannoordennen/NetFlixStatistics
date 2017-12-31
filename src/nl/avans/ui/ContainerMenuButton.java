package nl.avans.ui;

import nl.avans.logic.ContainerContentLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ContainerMenuButton extends JLabel implements MouseListener  {

    public ContainerMenuButton(String itemText, ContainerContentLoader event) {

        //Apply text and alignment
        super(itemText, SwingConstants.RIGHT);
        this.createComponents(itemText, event);
    }

    private void createComponents(String itemText, ContainerContentLoader event) {

        //Mouse options
        this.addMouseListener(this);
        this.setFocusable(true);

        //Make transparent
        this.setOpaque(false);

        //Create panel text
        this.addMouseListener(event);
        this.setForeground(NetflixWindow.FOURTH_COLOR);
        this.setFont(NetflixWindow.FONT_BIG);
        this.setPreferredSize(new Dimension(150,50));
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        //Hover color
        this.setForeground(NetflixWindow.SECONDARY_COLOR);
    }

    @Override
    public void mouseExited(MouseEvent e) {

        //Old color
        this.setForeground(NetflixWindow.FOURTH_COLOR);
    }
}
