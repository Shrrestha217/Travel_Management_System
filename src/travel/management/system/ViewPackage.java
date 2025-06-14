package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener {
    JLabel lbusername, lbid, lbnumber, lbphone, lbpackage, lbperson, lbprice;
    JButton backButton;
    String username;

    ViewPackage(String username) {
        this.username = username;

        setBounds(450, 200, 900, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel details = new JLabel("VIEW BOOKING DETAILS");
        details.setBounds(270, 30, 400, 40);
        details.setFont(new Font("SAN SERIF", Font.BOLD, 26));
        add(details);

        JLabel labelusername = new JLabel("Username: ");
        labelusername.setBounds(50, 90, 150, 25);
        labelusername.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelusername);

        lbusername = new JLabel();
        lbusername.setBounds(180, 90, 150, 25);
        lbusername.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbusername);

        JLabel labelid = new JLabel("Id: ");
        labelid.setBounds(50, 140, 150, 25);
        labelid.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelid);

        lbid = new JLabel();
        lbid.setBounds(180, 140, 150, 25);
        lbid.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbid);

        JLabel labelnumber = new JLabel("Number: ");
        labelnumber.setBounds(50, 190, 150, 25);
        labelnumber.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelnumber);

        lbnumber = new JLabel();
        lbnumber.setBounds(180, 190, 150, 25);
        lbnumber.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbnumber);

        JLabel labelphone = new JLabel("Phone: ");
        labelphone.setBounds(50, 240, 150, 25);
        labelphone.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelphone);

        lbphone = new JLabel();
        lbphone.setBounds(180, 240, 150, 25);
        lbphone.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbphone);

        JLabel labelpackage = new JLabel("Package: ");
        labelpackage.setBounds(50, 290, 150, 25);
        labelpackage.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelpackage);

        lbpackage = new JLabel();
        lbpackage.setBounds(180, 290, 150, 25);
        lbpackage.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbpackage);

        JLabel labelperson = new JLabel("Persons: ");
        labelperson.setBounds(50, 340, 150, 25);
        labelperson.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelperson);

        lbperson = new JLabel();
        lbperson.setBounds(180, 340, 150, 25);
        lbperson.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbperson);

        JLabel labelprice = new JLabel("Total Price: ");
        labelprice.setBounds(50, 390, 150, 25);
        labelprice.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelprice);

        lbprice = new JLabel();
        lbprice.setBounds(180, 390, 150, 25);
        lbprice.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbprice);

        backButton = new JButton("Back");
        backButton.setBounds(130, 460, 150, 30);
        backButton.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bookpackage where username = '"+username+"'");
            while(rs.next()) {
                lbusername.setText(rs.getString("username"));
                lbid.setText(rs.getString("id"));
                lbnumber.setText(rs.getString("number"));
                lbphone.setText(rs.getString("phone"));
                lbperson.setText(rs.getString("persons"));
                lbpackage.setText(rs.getString("package"));
                lbprice.setText(rs.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        MouseAdapter ml = new MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setFont(new Font("TAHOMA", Font.PLAIN, 18));
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setFont(new Font("TAHOMA", Font.BOLD, 20));
            }
        };
        backButton.addMouseListener(ml);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400, 90, 450, 440);
        add(l1);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewPackage("");
    }
}
