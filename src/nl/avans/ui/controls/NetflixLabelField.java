package nl.avans.ui.controls;

import nl.avans.ui.NetflixWindow;

import javax.swing.*;
import java.awt.*;

//for a subscriber
public class NetflixLabelField extends JPanel {

    private NetflixLabel subscriberNumberLabel;
    private JTextField subscriberNumberField;
    private JPanel applyContainer;

    public NetflixLabelField(String labelText, JPanel applyContainer) {
        super();
        setDefault(labelText, applyContainer);
    }

    public NetflixLabel getLabel() {
        return this.subscriberNumberLabel;
    }

    public JTextField getField() {
        return this.subscriberNumberField;
    }

    private void setDefault(String labelText, JPanel applyContainer) {

        //Instantiate
        this.applyContainer = applyContainer;
        this.subscriberNumberLabel = new NetflixLabel(labelText);
        this.subscriberNumberField = new JTextField();

        //Set layout
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setMaximumSize(new Dimension(9999,50));
        this.setPreferredSize(new Dimension(9999,50));
        this.subscriberNumberLabel.setMaximumSize(new Dimension(250,10));
        this.subscriberNumberLabel.setPreferredSize(new Dimension(250,10));
        this.setBackground(NetflixWindow.TRANSPARENT);
        this.subscriberNumberLabel.setForeground(NetflixWindow.PRIMARY_COLOR);
        this.subscriberNumberLabel.setFont(NetflixWindow.FONT_SMALL_BOLD);

        //Add all
        this.add(this.subscriberNumberLabel);
        this.add(this.subscriberNumberField);
        this.applyContainer.add(this);
    }
}
