package view;

import core.Helper;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LayOut extends JFrame {
    public LayOut() {
    }

    public void guiInitilaze(int width, int height) {
        this.setDefaultCloseOperation(2);
        this.setTitle("Tourism Agency");
        this.setSize(width, height);
        this.setLocation(Helper.getLocationPoint("x", this.getSize()), Helper.getLocationPoint("y", this.getSize()));
        this.setVisible(true);
    }
}