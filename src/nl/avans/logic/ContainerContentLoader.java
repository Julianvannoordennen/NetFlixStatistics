package nl.avans.logic;

import nl.avans.ui.ContainerContentHolder;

import javax.swing.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Meant to show what happens when you do something with your mouse

public class ContainerContentLoader implements MouseListener {

    private ContainerContentHolder targetContainer;
    private JPanel loadContainer;
    private JFrame frame;

    public ContainerContentLoader(JFrame frame, ContainerContentHolder targetContainer, JPanel loadContainer) {
        this.targetContainer = targetContainer;
        this.loadContainer = loadContainer;
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        //Load target container
        this.targetContainer.viewContainer(this.loadContainer);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
