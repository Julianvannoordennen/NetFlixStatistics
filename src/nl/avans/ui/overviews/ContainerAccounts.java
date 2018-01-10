package nl.avans.ui.overviews;

import nl.avans.logic.Database;
import nl.avans.ui.ContainerContent;

import javax.swing.*;
import java.awt.*;

public class ContainerAccounts extends ContainerContent {

    public ContainerAccounts(Database database) {
        super("Accounts", database);
        this.createComponents();
    }

    private void createComponents() {
    }
}
