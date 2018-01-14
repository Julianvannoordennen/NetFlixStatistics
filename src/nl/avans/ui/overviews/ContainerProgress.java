package nl.avans.ui.overviews;

import nl.avans.logic.database.*;
import nl.avans.models.database.Watched;
import nl.avans.ui.ContainerContent;
import nl.avans.ui.controls.NetflixLabel;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;
import nl.avans.ui.controls.NetflixSaveDelete;

public class ContainerProgress extends ContainerContent {

    public ContainerProgress(Database database) {
        super("Progressie", database);
        this.createComponents();
    }

    private void createComponents() {

        //Create watched selector label
        NetflixLabel watchedLabel = new NetflixLabel("Kies één progressie");
        this.add(watchedLabel);

        //Create account selector
        NetflixList<String> listContent = new NetflixList<String>();
        this.add(listContent);

        //Create 'add user' and add existing users
        listContent.getDefaultListModel().addElement("-- Nieuwe progressie aanmaken --");
        for (Watched watched : new WatchedRepository(this.database).readAll())
            listContent.getDefaultListModel().addElement(watched.getSubscriberNumber() + ": ," + watched.getProfileNumber() + ": ," + watched.getWatched() + ": ," + watched.getPercentage());

        //Create labels and fields
        NetflixLabelField subscriberNumber = new NetflixLabelField("Subscriptienummer:   ", this);
        NetflixLabelField profileNumber = new NetflixLabelField("Profielnummer:   ", this);
        NetflixLabelField watched = new NetflixLabelField("Geziennummer:   ", this);
        NetflixLabelField percentage = new NetflixLabelField("Percentage:   ", this);
        this.add(subscriberNumber);
        this.add(profileNumber);
        this.add(watched);
        this.add(percentage);

        //Create save and delete button
        NetflixSaveDelete saveDelete = new NetflixSaveDelete();
        this.add(saveDelete);

        //Create actions
        WatchedSelector watchedSelector = new WatchedSelector(subscriberNumber,profileNumber,watched,percentage, listContent, this.database);
        listContent.getList().addListSelectionListener(watchedSelector);
        listContent.getList().setSelectedIndex(0);

        WatchedSaver saver = new WatchedSaver(subscriberNumber,profileNumber,watched,percentage,listContent,this.database);
        saveDelete.getSave().addActionListener(saver);

        WatchedDeleter deleter = new WatchedDeleter(subscriberNumber,profileNumber,watched, listContent,this.database);
        saveDelete.getDelete().addActionListener(deleter);
    }
}
