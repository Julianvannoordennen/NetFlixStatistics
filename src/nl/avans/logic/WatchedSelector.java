package nl.avans.logic;

import nl.avans.logic.database.*;
import nl.avans.models.database.*;
import nl.avans.ui.controls.NetflixLabelDrop;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// Shows which things have been watched by a specific profile
public class WatchedSelector implements ListSelectionListener {

    private NetflixLabelDrop<Integer> subscriberNumber;
    private NetflixLabelDrop<Integer> profileNumber;
    private NetflixLabelDrop<Integer> watched;
    private NetflixLabelField percentage;
    private NetflixList<String> list;
    private Database database;

    public WatchedSelector(NetflixLabelDrop<Integer> subscriberNumber, NetflixLabelDrop<Integer> profileNumber, NetflixLabelDrop<Integer> watched, NetflixLabelField percentage, NetflixList<String> list, Database database) {
        this.subscriberNumber = subscriberNumber;
        this.profileNumber = profileNumber;
        this.watched = watched;
        this.percentage = percentage;
        this.list = list;
        this.database = database;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        //Get selected index
        int selectedNumber = this.list.getList().getSelectedIndex();

        //Get selected item, in case the user did not select '-- Nieuwe progressie aanmaken --'
        Watched selectedWatched = new Watched(0,0,0,0);
        if (selectedNumber > 0) {
            selectedNumber--;
            selectedWatched = new WatchedRepository(this.database).readAll().get(selectedNumber);
            this.subscriberNumber.getDropDown().setEnabled(false);
            this.profileNumber.getDropDown().setEnabled(false);
            this.watched.getDropDown().setEnabled(false);
        } else {
            this.subscriberNumber.getDropDown().setEnabled(true);
            this.profileNumber.getDropDown().setEnabled(true);
            this.watched.getDropDown().setEnabled(true);
        }

        //Add selected item to fields
        this.percentage.getField().setText(selectedWatched.getPercentage() + "");

        //Set dropdown Account
        if (selectedWatched.getSubscriberNumber() > 0) {
            Account account = new AccountRepository(this.database).read(selectedWatched.getSubscriberNumber());
            String subscriberNumberItemText = selectedWatched.getSubscriberNumber() + ": " + account.getName();
            this.subscriberNumber.getDropDown().setSelectedItem(subscriberNumberItemText);
        }

        //Set dropdown Profile
        if (selectedWatched.getProfileNumber() > 0) {
            Profile profile = new ProfileRepository(this.database).read(selectedWatched.getProfileNumber());
            String profileNumberItemText = selectedWatched.getProfileNumber() + ": " + profile.getProfileName();
            this.profileNumber.getDropDown().setSelectedItem(profileNumberItemText);
        }

        //Set dropdown Episode
        if (selectedWatched.getWatched() > 0) {
            Episode episode = new EpisodeRepository(this.database).read(selectedWatched.getWatched());
            Film film = new FilmRepository(this.database).read(selectedWatched.getWatched());
            String watchedItemText = selectedWatched.getWatched() + ": " + ((episode == null) ? film.getTitle() : episode.getTitleEpisode());
            System.out.println(watchedItemText);
            this.watched.getDropDown().setSelectedItem(watchedItemText);
        }
    }
}
