package nl.avans.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NetflixWindow implements Runnable {

    private JFrame frame;
    static final Color PRIMARY_COLOR = Color.BLACK;
    static final Color SECONDARY_COLOR = new Color(215,23,31);
    static final Color THIRD_COLOR = new Color(0,0,0,192);
    static final Color FOURTH_COLOR = Color.WHITE;


    @Override
    public void run() {

        //Create frame
        frame = new JFrame("Netflix Statistix");
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setPreferredSize(new Dimension(1000, 800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Load image
        BufferedImage background = null;
        try {
            background = ImageIO.read(new File("res/background.png"));
        } catch(Exception e) {}

        frame.setContentPane(new ImagePanel(background));

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {

        //Layout
        container.setLayout(new BorderLayout());

        //Add containers
        container.add(new ContainerMenu(), BorderLayout.WEST);
        container.add(new ContainerCredits(), BorderLayout.SOUTH);
        container.add(new ContainerContentHolder(), BorderLayout.CENTER);

        //Add menu container

        /*

        //Value toevoegen
        JTextField value = new JTextField("0");
        value.setEnabled(false);
        container.add(value);

        //Input toevoegen
        JTextField input = new JTextField();
        container.add(input);

        //Buttonpanel toevoegen
        JPanel panel = new ButtonPanel(value, input, calculator);
        container.add(panel);*/
    }

    public JFrame getFrame() {
        return frame;
    }
}
