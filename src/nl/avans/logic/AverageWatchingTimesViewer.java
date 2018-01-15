package nl.avans.logic;

import nl.avans.logic.database.*;
import nl.avans.models.database.Account;
import nl.avans.models.database.Episode;
import nl.avans.models.database.Series;
import nl.avans.ui.controls.NetflixComboBox;
import nl.avans.ui.controls.NetflixList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

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

        //Create watched repository
        WatchedRepository watchedRepository = new WatchedRepository(this.database);

        //Get serie
        Series serie = new SeriesRepository(this.database).readAll().get(this.serieSelector.getSelectedIndex());

        //Get account and data
        int selectedNumber = this.accountSelector.getSelectedIndex();
        Account selectedAccount = new Account(0,"","","",0,"");
        if (selectedNumber > 0) {
            selectedNumber--;
            selectedAccount = new AccountRepository(this.database).readAll().get(selectedNumber);
        }

        //Get data
        ResultSet resultSet = watchedRepository.readAvgAccountAndSerie(selectedAccount.getSubscriberNumber() + "", serie.getSeries());

        //Show data
        try {
            while (resultSet.next()) {
                this.listContent.getDefaultListModel().addElement(resultSet.getString("TitelAflevering") + " (" + resultSet.getInt("AfleveringId") + "): " + resultSet.getString("Percentage") + "%");
            }
        } catch(Exception ex) {}
    }
}