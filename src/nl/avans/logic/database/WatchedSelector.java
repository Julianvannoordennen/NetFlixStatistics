package nl.avans.logic.database;

import nl.avans.models.database.Watched;
import nl.avans.ui.controls.NetflixLabelField;
import nl.avans.ui.controls.NetflixList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class WatchedSelector implements ListSelectionListener {

    private NetflixLabelField subscriberNumber;
    private NetflixLabelField profileNumber;
    private NetflixLabelField watched;
    private NetflixLabelField percentage;
    private NetflixList<String> list;
    private Database database;

    public WatchedSelector(NetflixLabelField subscriberNumber, NetflixLabelField profileNumber, NetflixLabelField watched, NetflixLabelField percentage, NetflixList<String> list, Database database) {
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

        //Get selected item, in case the user did not select '-- Nieuw account aanmaken --'
        Watched selectedWatched = new Watched(0,0,0,0);
        if (selectedNumber > 0) {
            selectedNumber--;
            selectedWatched = new WatchedRepository(this.database).readAll().get(selectedNumber);
            this.subscriberNumber.getField().setEditable(false);
            this.profileNumber.getField().setEditable(false);
            this.watched.getField().setEditable(false);
        } else {
            this.subscriberNumber.getField().setEditable(true);
            this.profileNumber.getField().setEditable(true);
            this.watched.getField().setEditable(true);
        }

        //Add selected item to fields
        this.subscriberNumber.getField().setText(selectedWatched.getSubscriberNumber() + "");
        this.profileNumber.getField().setText(selectedWatched.getProfileNumber() + "");
        this.watched.getField().setText(selectedWatched.getWatched() + "");
        this.percentage.getField().setText(selectedWatched.getPercentage() + "");
    }
}
