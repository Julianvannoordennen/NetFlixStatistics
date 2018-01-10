package nl.avans.ui.overviews;

import nl.avans.logic.Database;
import nl.avans.ui.ContainerContent;

import javax.swing.*;
import java.awt.*;

public class ContainerProgress extends ContainerContent {

    public ContainerProgress(Database database) {
        super("Progressie", database);
        this.createComponents();
    }

    private void createComponents() {


    }
}
