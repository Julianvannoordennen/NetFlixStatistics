package nl.avans.logic;

import nl.avans.logic.database.Database;
import nl.avans.logic.database.EpisodeRepository;
import nl.avans.models.database.Episode;
import nl.avans.ui.controls.NetflixComboBox;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AverageWatchingTimesViewer implements ActionListener {

    private NetflixComboBox<String> accountSelector;
    private NetflixComboBox<String> serieSelector;
    private NetflixList<String> listContent;
    private Database database;

    public AverageWatchingTimesViewer(NetflixComboBox<String> accountSelector, NetflixComboBox<String> serieSelector, NetflixList<String> listContent, Database database) {
        this.accountSelector = accountSelector;
        this.serieSelector = serieSelector;
        this.listContent = listContent;
        this.database = database;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Clear all items in list
        this.listContent.getDefaultListModel().clear();

        //Add all episodes from the selected NetflixComboBox item
        for (Episode episode : new EpisodeRepository(this.database).readAll()) {

            //Check if it is the correct serie
            if (episode.getSeries().equals(this.serieSelector.getSelectedItem())) {
                this.listContent.getDefaultListModel().addElement("Titel: " + episode.getTitleEpisode() + ", Volgnummer: " + episode.getEpisodeId() + ", Gemiddeld bekeken %: ");
            }
        }
    }
}