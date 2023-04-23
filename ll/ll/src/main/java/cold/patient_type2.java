package cold;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.lang.Class.forName;

public class patient_type2 extends JFrame {
    private JTextField ID;
    private JTextField STATE;
    private JTextField NAME;
    private JButton ADD;
    private JButton QUERY;
    private JButton DELETE;
    private JTextField CITY;
    private JTextField ADDRESS;
    private JTextField PHONE;
    private JPanel main;

    public patient_type2() {
        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital2", "root", "");
                    String query = "INSERT INTO patient VALUES(?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, ID.getText());
                    ps.setString(2, NAME.getText());
                    ps.setString(3, STATE.getText());
                    ps.setString(4, CITY.getText());
                    ps.setString(5, ADDRESS.getText());
                    ps.setString(6, PHONE.getText());
                    int i = ps.executeUpdate();
                    JOptionPane.showMessageDialog(ADD, i + " Record added successfully..");
                    ps.close();
                    con.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        DELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital2", "root", "");
                    String query = "DELETE FROM patient WHERE PATID=?";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, ID.getText());
                    int i = ps.executeUpdate();
                    JOptionPane.showMessageDialog(DELETE, i + " Record deleted successfully..");
                    ps.close();
                    con.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        QUERY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = 0, p = 0;
                    String a = "";
                    String n = "";
                    String s = "";
                    String c = "";
                    forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital2", "root", "");
                    String query = "SELECT * FROM patient where PATID=?";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, ID.getText());
                    ResultSet r = ps.executeQuery();
                    while (r.next()) {
                        id = r.getInt("PATID");
                        n = r.getString("NAME");
                        s = r.getString("STATE");
                        c = r.getString("CITY");
                        a = r.getString("ADDRESS");
                        p = r.getInt("PHONE");
                    }
                    JOptionPane.showMessageDialog(QUERY, "PATIENT ID:" + id + "\nPATIENT NAME:" + n + "\nPATIENT STATE:" + s + "\nPATIENT CITY:" + c + "\nPATIENT ADDRESS:" + a + "\nPATIENT PHONE:" + p);
                    ps.close();
                    r.close();
                    con.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    patient_type2 frame = new patient_type2();
                    frame.setContentPane(new patient_type2().main);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
