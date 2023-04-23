package cold;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Patient extends JFrame {
    private JPanel contentPane;
    private JTextField PATIENT_ID;
    private JTextField PATIENT_NAME;
    private JTextField ADDRESS;
    private JTextField CITY;
    private JTextField STATE;

    /**
     * Create the frame.
     */
    public Patient() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel lblNewLabel = new JLabel("PATIENT ENTRY FORM");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(70, 11, 276, 43);
        contentPane.add(lblNewLabel);
        JLabel lblNewLabel_1 = new JLabel("PATIENT ID");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 61, 112, 14);
        contentPane.add(lblNewLabel_1);
        JLabel lblNewLabel_1_1 = new JLabel("PATIENT NAME");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(10, 95, 112, 14);
        contentPane.add(lblNewLabel_1_1);
        JLabel lblNewLabel_1_2 = new JLabel("ADDRESS");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2.setBounds(10, 128, 112, 14);
        contentPane.add(lblNewLabel_1_2);
        JLabel lblNewLabel_1_3 = new JLabel("CITY");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_3.setBounds(10, 163, 112, 14);
        contentPane.add(lblNewLabel_1_3);
        JLabel lblNewLabel_1_4 = new JLabel("STATE");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_4.setBounds(10, 195, 112, 14);
        contentPane.add(lblNewLabel_1_4);
        PATIENT_ID = new JTextField();
        PATIENT_ID.setBounds(137, 65, 86, 20);
        contentPane.add(PATIENT_ID);
        PATIENT_ID.setColumns(10);
        PATIENT_NAME = new JTextField();
        PATIENT_NAME.setBounds(132, 94, 163, 20);
        contentPane.add(PATIENT_NAME);
        PATIENT_NAME.setColumns(10);
        ADDRESS = new JTextField();
        ADDRESS.setBounds(137, 127, 86, 20);
        contentPane.add(ADDRESS);
        ADDRESS.setColumns(10);
        CITY = new JTextField();
        CITY.setBounds(137, 162, 86, 20);
        contentPane.add(CITY);
        CITY.setColumns(10);
        STATE = new JTextField();
        STATE.setText("");
        STATE.setBounds(137, 204, 86, 20);
        contentPane.add(STATE);
        STATE.setColumns(10);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 255));
        panel.setBounds(321, 142, 103, 64);
        contentPane.add(panel);
        JButton Save = new JButton("SAVE");
        Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "", "");
                    String query = "INSERT INTO patient VALUES(?,?,?,?,?)";
                    PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                    ps.setString(1, PATIENT_ID.getText());
                    ps.setString(2, PATIENT_NAME.getText());
                    ((java.sql.PreparedStatement) ps).setString(3, ADDRESS.getText());
                    ((java.sql.PreparedStatement) ps).setString(4, CITY.getText());
                    ps.setString(5, STATE.getText());
                    int i = ps.executeUpdate();
                    JOptionPane.showMessageDialog(Save, i + " Record added succesfully..");
                    ps.close();
                    con.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        panel.add(Save);
        JButton Delete = new JButton("DELETE");
        Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "", "");
                    String query = "DELETE FROM patient WHERE PATIENT_ID=?";
                    PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                    ps.setString(1, PATIENT_ID.getText());
                    int i = ps.executeUpdate();
                    JOptionPane.showMessageDialog(Delete, i + "Record deleted succesfully..");
                    ps.close();
                    con.close();
                } catch (Exception b1) {
                    b1.printStackTrace();
                }
            }
        });
        panel.add(Delete);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Patient frame = new Patient();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
