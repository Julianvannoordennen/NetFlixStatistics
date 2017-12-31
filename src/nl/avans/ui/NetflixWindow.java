package nl.avans.ui;

import nl.avans.logic.ContainerContentLoader;

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
    static final Color THIRD_COLOR = new Color(255,255,255,64);
    static final Color FOURTH_COLOR = Color.WHITE;
    static final Font FONT_BIG = new Font("Helvetica Neue", Font.BOLD, 20);
    static final Font FONT_BIG_ENABLED = new Font("Helvetica Neue", Font.BOLD, 20);
    static final Font FONT_SMALL = new Font("Helvetica Neue", Font.ITALIC, 14);

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

        //Create menu items for menu
        ContainerContentHolder holder = new ContainerContentHolder();
        ContainerMenuButton[] menuItems = {
            new ContainerMenuButton("Accounts   ▶", new ContainerContentLoader(this.frame, holder, new ContainerAccounts())),
            new ContainerMenuButton("Profielen   ▶", new ContainerContentLoader(this.frame, holder, new ContainerProfiles())),
            new ContainerMenuButton("Progressie   ▶", new ContainerContentLoader(this.frame, holder, new ContainerProgress()))
        };

        //Add containers
        container.add(new ContainerMenu(menuItems), BorderLayout.WEST);
        container.add(new ContainerCredits(), BorderLayout.SOUTH);
        container.add(holder, BorderLayout.CENTER);

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
