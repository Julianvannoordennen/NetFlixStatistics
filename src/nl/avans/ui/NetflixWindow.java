package nl.avans.ui;

import nl.avans.logic.ContainerContentLoader;
import nl.avans.logic.database.Database;
import nl.avans.ui.controls.ContainerMenuButton;
import nl.avans.ui.controls.ImagePanel;
import nl.avans.ui.overviews.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class NetflixWindow implements Runnable {

    private JFrame frame;
    private Database database;
    public static final Color PRIMARY_COLOR = Color.BLACK;
    public static final Color SECONDARY_COLOR = new Color(215,23,31);
    public static final Color THIRD_COLOR = new Color(255,255,255,64);
    public static final Color FOURTH_COLOR = Color.WHITE;
    public static final Color TRANSPARENT = new Color(0,0,0,0);
    public static final Font FONT_BIG = new Font("Helvetica Neue", Font.BOLD, 16);
    public static final Font FONT_SMALL_BOLD = new Font("Helvetica Neue", Font.BOLD, 12);
    public static final Font FONT_SMALL = new Font("Helvetica Neue", Font.ITALIC, 12);

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
            new ContainerMenuButton("Accounts   ▶", new ContainerContentLoader(this.frame, holder, new ContainerAccounts(database, frame))),
            new ContainerMenuButton("Profielen   ▶", new ContainerContentLoader(this.frame, holder, new ContainerProfiles(database, frame))),
            new ContainerMenuButton("Progressie   ▶", new ContainerContentLoader(this.frame, holder, new ContainerProgress(database, frame))),
            new ContainerMenuButton("Gem. kijktijd   ▶", new ContainerContentLoader(this.frame, holder, new ContainerAverageWatchingTimes(database))),
            new ContainerMenuButton("16- Langst   ▶", new ContainerContentLoader(this.frame, holder, new ContainerLongestTimeYoungerThan16(database))),
            new ContainerMenuButton("Enkele profielen   ▶", new ContainerContentLoader(this.frame, holder, new ContainerSmallAccounts(database))),
            new ContainerMenuButton("Bekeken films   ▶", new ContainerContentLoader(this.frame, holder, new ContainerWatchedFilms(database))),
            new ContainerMenuButton("Geheel bekeken   ▶", new ContainerContentLoader(this.frame, holder, new ContainerFullWatchedFilm(database)))
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
