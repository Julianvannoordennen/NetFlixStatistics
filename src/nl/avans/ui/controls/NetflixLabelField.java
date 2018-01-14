package nl.avans.ui.controls;

import javax.swing.*;
import java.awt.*;

public class NetflixLabelField extends JPanel {

    private NetflixLabel subscriberNumberLabel;
    private NetflixField subscriberNumberField;
    private JPanel applyContainer;

    public NetflixLabelField(String labelText, JPanel applyContainer) {
        super();
        setDefault(labelText, applyContainer);
    }

    public NetflixLabel getLabel() {
        return this.subscriberNumberLabel;
    }

    public NetflixField getField() {
        return this.subscriberNumberField;
    }

    private void setDefault(String labelText, JPanel applyContainer) {

        //Instantiate
        this.applyContainer = applyContainer;
        this.subscriberNumberLabel = new NetflixLabel(labelText);
        this.subscriberNumberField = new NetflixField();

        //Set layout
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setMaximumSize(new Dimension(9999,50));
        this.setPreferredSize(new Dimension(9999,50));
        this.subscriberNumberLabel.setMaximumSize(new Dimension(250,10));
        this.subscriberNumberLabel.setPreferredSize(new Dimension(250,10));

        //Add all
        this.add(this.subscriberNumberLabel);
        this.add(this.subscriberNumberField);
        this.applyContainer.add(this);
    }
}
