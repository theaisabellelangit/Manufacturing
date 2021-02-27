import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableGUI {
    private JFrame frame = new JFrame("Manufacturing System");
    private JTextField timeField = new JTextField();
    private JLabel timeLabel = new JLabel("Enter Simulation Time (minutes): ");
    private JButton generate = new JButton("GENERATE TABLE");
    private JFrame tableFrame = new JFrame("Simulation Table");

    public TableGUI() {
        frame.setVisible(true);
        frame.setSize(500, 300);
        frame.setLayout(null);
        timeLabel.setBounds(50,50,200,70);
        timeLabel.setHorizontalTextPosition(4);
        timeField.setBounds(250 ,80, 100, 20);
        generate.setBounds(100,150, 250,30 );

        frame.add(timeLabel);
        frame.add(timeField);
        frame.add(generate);

        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                tableFrame.setVisible(true);
                tableFrame.setSize(1000, 700);
                String[] column = {"Entity No.", "Time(t)", "Event","Type","Q(t)","B(t)", "In queue", "In service","P", "N","∑WQ","WQ*", "∑TS", "TS*", "∫Q","Q*","∫Q"};
                String [][] data = new String[20][30];
                JTable table = new JTable(data, column);
                tableFrame.add(table.getTableHeader(), BorderLayout.PAGE_START);
                tableFrame.add(table, BorderLayout.CENTER);
                tableFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                tableFrame.pack();
                tableFrame.setLocationRelativeTo(null);
                table.setVisible(true);

            }
        });

    }

    public static void main (String [] args) {
        new TableGUI();
    }
}
