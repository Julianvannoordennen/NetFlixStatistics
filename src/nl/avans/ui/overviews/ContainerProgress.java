package nl.avans.ui.overviews;

import nl.avans.logic.ProgressAccountSelector;
import nl.avans.logic.WatchedSelector;
import nl.avans.logic.database.*;
import nl.avans.models.database.*;
import nl.avans.ui.ContainerContent;
import nl.avans.ui.controls.*;

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
        for (Watched watched : new WatchedRepository(this.database).readAll()) {
            listContent.getDefaultListModel().addElement(watched.getSubscriberNumber() + ": ," + watched.getProfileNumber() + ": ," + watched.getWatched() + ": ," + watched.getPercentage());
        }

        //Create labels and fields
        NetflixLabelDrop<Integer> subscriberNumber = new NetflixLabelDrop<Integer>("Subscriptienummer:   ", this);
        NetflixLabelDrop<Integer> profileNumber = new NetflixLabelDrop<Integer>("Profielnummer:   ", this);
        NetflixLabelDrop<Integer> watched = new NetflixLabelDrop<Integer>("Geziennummer:   ", this);
        NetflixLabelField percentage = new NetflixLabelField("Percentage:   ", this);
        this.add(subscriberNumber);
        this.add(profileNumber);
        this.add(watched);
        this.add(percentage);

        //Load LabelDrop data
        for (Account account : new AccountRepository(this.database).readAll()) {
            subscriberNumber.getDropDown().addItem(account.getSubscriberNumber() + ": " + account.getName());
            subscriberNumber.addReturnValue(account.getSubscriberNumber());
        }

        for (Episode episode : new EpisodeRepository(this.database).readAll()) {
            watched.getDropDown().addItem(episode.getEpisodeId() + ": " + episode.getTitleEpisode());
            watched.addReturnValue(episode.getEpisodeId());
        }

        for (Film film : new FilmRepository(this.database).readAll()) {
            watched.getDropDown().addItem(film.getFilmId() + ": " + film.getTitle());
            watched.addReturnValue(film.getFilmId());
        }

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

        ProgressAccountSelector progressAccountSelector = new ProgressAccountSelector(subscriberNumber,profileNumber,this.database);
        subscriberNumber.getDropDown().addActionListener(progressAccountSelector);
        subscriberNumber.getDropDown().setSelectedIndex(0);

    }
}
