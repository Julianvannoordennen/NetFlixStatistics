package nl.avans.ui.overviews;

import nl.avans.logic.Database;
import nl.avans.ui.ContainerContent;

import javax.swing.*;
import java.awt.*;

public class ContainerProfiles extends ContainerContent {

    public ContainerProfiles(Database database) {
        super("Profielen", database);
        this.createComponents();
    }

    private void createComponents() {
    }
}
