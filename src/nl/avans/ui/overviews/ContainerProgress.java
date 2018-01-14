package nl.avans.ui.overviews;

import nl.avans.logic.database.Database;
import nl.avans.ui.ContainerContent;

public class ContainerProgress extends ContainerContent {

    public ContainerProgress(Database database) {
        super("Progressie", database);
        this.createComponents();
    }

    private void createComponents() {


    }
}
