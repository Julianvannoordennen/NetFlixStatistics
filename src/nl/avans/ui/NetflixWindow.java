package nl.avans.ui;

import nl.avans.logic.ContainerContentLoader;
import nl.avans.logic.database.Database;
import nl.avans.ui.controls.ImagePanel;
import nl.avans.ui.overviews.ContainerAccounts;
import nl.avans.ui.overviews.ContainerAverageWatchingTimes;
import nl.avans.ui.overviews.ContainerProfiles;
import nl.avans.ui.overviews.ContainerProgress;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class NetflixWindow implements Runnable {

    private JFrame frame;
    private Database database;
    static final Color PRIMARY_COLOR = Color.BLACK;
    static final Color SECONDARY_COLOR = new Color(215,23,31);
    static final Color THIRD_COLOR = new Color(255,255,255,64);
    static final Color FOURTH_COLOR = Color.WHITE;
    static final Font FONT_BIG = new Font("Helvetica Neue", Font.BOLD, 20);
    static final Font FONT_BIG_ENABLED = new Font("Helvetica Neue", Font.BOLD, 20);
    static final Font FONT_SMALL = new Font("Helvetica Neue", Font.ITALIC, 14);

    public NetflixWindow(Database database) {
        this.database = database;
    }

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
            new ContainerMenuButton("Accounts   ▶", new ContainerContentLoader(this.frame, holder, new ContainerAccounts(database))),
            new ContainerMenuButton("Profielen   ▶", new ContainerContentLoader(this.frame, holder, new ContainerProfiles(database))),
            new ContainerMenuButton("Progressie   ▶", new ContainerContentLoader(this.frame, holder, new ContainerProgress(database))),
            new ContainerMenuButton("Gemiddelde kijktijd   ▶", new ContainerContentLoader(this.frame, holder, new ContainerAverageWatchingTimes(database)))
        };

        //Add containers
        container.add(new ContainerMenu(menuItems), BorderLayout.WEST);
        container.add(new ContainerCredits(), BorderLayout.SOUTH);
        container.add(holder, BorderLayout.CENTER);
    }

    public JFrame getFrame() {
        return frame;
    }
}
