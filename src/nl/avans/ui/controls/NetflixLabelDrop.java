package nl.avans.ui.controls;

import nl.avans.ui.NetflixWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
// dropdown base
public class NetflixLabelDrop<E> extends JPanel {

    private NetflixLabel label;
    private NetflixComboBox<String> dropdown;
    private JPanel applyContainer;
    private ArrayList<E> returnList;

    public NetflixLabelDrop(String labelText, JPanel applyContainer) {
        super();
        setDefault(labelText, applyContainer);
    }

    public NetflixLabel getLabel() {
        return this.label;
    }

    public NetflixComboBox<String> getDropDown() {
        return this.dropdown;
    }

    public void addReturnValue(E value) {
        this.returnList.add(value);
    }

    public E getReturnValue() {
        return this.returnList.get(this.dropdown.getSelectedIndex());
    }

    public void clearReturnValues() {
        this.returnList.clear();
    }

    private void setDefault(String labelText, JPanel applyContainer) {

        //Instantiate
        this.applyContainer = applyContainer;
        this.label = new NetflixLabel(labelText);
        this.dropdown = new NetflixComboBox<String>();
        this.returnList = new ArrayList<E>();

        //Set layout
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setMaximumSize(new Dimension(9999,50));
        this.setPreferredSize(new Dimension(9999,50));
        this.label.setMaximumSize(new Dimension(250,10));
        this.label.setPreferredSize(new Dimension(250,10));
        this.setBackground(NetflixWindow.TRANSPARENT);
        this.label.setForeground(NetflixWindow.PRIMARY_COLOR);
        this.label.setFont(NetflixWindow.FONT_SMALL_BOLD);

        //Add all
        this.add(this.label);
        this.add(this.dropdown);
        this.applyContainer.add(this);
    }
}
