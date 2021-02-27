package monitoring.simulation;

import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
	run();
    }

    public static void run() {

        System.out.println("Enter the simulation time: ");
        int time = s.nextInt();
        printTable();
    }

    public static void printTable() {
        JFrame frame;

        frame = new JFrame("Manufacturing System");
        String data [][] = {{"-", "0", "Initial", "0", "0", "0", "0", "0", "0","0","0","0","0","0","0","0","0"},
                {"1", "0", "Arrival", "0", "1", "0", "0", "0", "1", "0", "0", "0", "0"}};
        String column [] = {"Entity No.", "Time(t)", "Event", "Type", "Q(t)", "B(t)", "In Queue", "In Service",
         "P", "N", "∑WQ", "WQ*", "∑TS", "TS*", " ∫Q", "Q*", " ∫Q"};

        final JTable t = new JTable(data, column);
        t.setCellSelectionEnabled(true);
        ListSelectionModel select = t.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String Data = null;
                int[] row = t.getSelectedRows();
                int[] columns = t.getSelectedColumns();
                for (int i = 0; i < row.length; i++) {
                    for (int j = 0; j < columns.length; j++) {
                        Data = (String) t.getValueAt(row[i], columns[j]);
                    } }
                System.out.println("Table element selected is: " + Data);
            }
        });
        JScrollPane sp=new JScrollPane(t);
        frame.add(sp);
        frame.setSize(10000, 200);
        frame.setVisible(true);
    }
}
