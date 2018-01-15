package nl.avans.ui.overviews;

import nl.avans.logic.AverageWatchingTimesViewer;
import nl.avans.logic.database.AccountRepository;
import nl.avans.logic.database.Database;
import nl.avans.logic.database.EpisodeRepository;
import nl.avans.logic.database.SeriesRepository;
import nl.avans.models.database.Account;
import nl.avans.models.database.Episode;
import nl.avans.models.database.Series;
import nl.avans.ui.ContainerContent;
import nl.avans.ui.controls.NetflixComboBox;
import nl.avans.ui.controls.NetflixLabel;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;

// to see how far something has been watched on average
public class ContainerAverageWatchingTimes extends ContainerContent {

    public ContainerAverageWatchingTimes(Database database) {

        //Add title and database
        super("Gemiddelde kijktijden", database);

        //Create controls
        this.createComponents();
    }

    @Override
    protected void createComponents() {

        //Create serie selector label
        NetflixLabel accountLabel = new NetflixLabel("Kies één account");
        this.add(accountLabel);

        //Create serie selector and add all series
        NetflixComboBox<String> accountSelector = new NetflixComboBox<String>();
        this.add(accountSelector);
        accountSelector.addItem("-- Alle accounts --");
        for (Account account : new AccountRepository(this.database).readAll())
            accountSelector.addItem(account.getName());

        //Create serie selector label
        NetflixLabel serieLabel = new NetflixLabel("Kies één serie");
        this.add(serieLabel);

        //Create serie selector and add al series
        NetflixComboBox<String> serieSelector = new NetflixComboBox<String>();
        this.add(serieSelector);
        for (Series serie : new SeriesRepository(this.database).readAll())
            serieSelector.addItem(serie.getSeries());

        //Create percentage overview label
        NetflixLabel percentagesLabel = new NetflixLabel("Percentages per episode");
        this.add(percentagesLabel);

        //Create percentage overview
        NetflixList<String> listContent = new NetflixList<String>();
        this.add(listContent);

        //Create action and show first item
        AverageWatchingTimesViewer action = new AverageWatchingTimesViewer(accountSelector, serieSelector,listContent, this.database);
        accountSelector.addActionListener(action);
        serieSelector.addActionListener(action);
        action.actionPerformed(null);
    }
}
