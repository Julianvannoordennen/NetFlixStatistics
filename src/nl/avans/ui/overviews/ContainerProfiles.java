package nl.avans.ui.overviews;

import nl.avans.logic.database.Database;
import nl.avans.ui.ContainerContent;

public class ContainerProfiles extends ContainerContent {

    public ContainerProfiles(Database database) {
        super("Profielen", database);
        this.createComponents();
    }

    private void createComponents() {
    }
}
