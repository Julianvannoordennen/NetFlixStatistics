package nl.avans.ui.controls;

import javax.swing.*;

public class NetflixList<E> extends JScrollPane {

    private DefaultListModel<E> listContent;
    private JList list;

    public NetflixList() {
        super();
        setDefault();
    }

    public DefaultListModel<E> getDefaultListModel() {
        return this.listContent;
    }

    public JList getList() {
        return this.list;
    }

    private void setDefault() {

        //Create instances
        this.listContent = new DefaultListModel<E>();
        this.list = new JList(this.listContent);
        this.getViewport().add(this.list, null);
    }
}
