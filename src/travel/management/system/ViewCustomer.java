package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;

public class ViewCustomer extends JFrame implements ActionListener {

    JLabel lbusername, lbid, lbnumber, lbname, lbgender, lbcountry, lbaddress, lbphone, lbemail;
    JButton backButton;
    String username;

    ViewCustomer(String username) {
        this.username = username;

        setBounds(450, 180, 870, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel details = new JLabel("WELCOME " + username.toUpperCase());
        details.setBounds(250, 30, 300, 40);
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
        labelid.setBounds(50, 150, 150, 25);
        labelid.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelid);

        lbid = new JLabel();
        lbid.setBounds(180, 150, 150, 25);
        lbid.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbid);

        JLabel labelnumber = new JLabel("Number: ");
        labelnumber.setBounds(50, 210, 150, 25);
        labelnumber.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelnumber);

        lbnumber = new JLabel();
        lbnumber.setBounds(180, 210, 150, 25);
        lbnumber.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbnumber);

        JLabel labelname = new JLabel("Name: ");
        labelname.setBounds(50, 270, 150, 25);
        labelname.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelname);

        lbname = new JLabel();
        lbname.setBounds(180, 270, 150, 25);
        lbname.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbname);

        JLabel labelgender = new JLabel("Gender: ");
        labelgender.setBounds(50, 330, 150, 25);
        labelgender.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelgender);

        lbgender = new JLabel();
        lbgender.setBounds(180, 330, 150, 25);
        lbgender.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbgender);

        JLabel labelcountry = new JLabel("Country: ");
        labelcountry.setBounds(500, 90, 150, 25);
        labelcountry.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelcountry);

        lbcountry = new JLabel();
        lbcountry.setBounds(630, 90, 150, 25);
        lbcountry.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbcountry);

        JLabel labeladdress = new JLabel("Address: ");
        labeladdress.setBounds(500, 150, 150, 25);
        labeladdress.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labeladdress);

        lbaddress = new JLabel();
        lbaddress.setBounds(630, 150, 150, 25);
        lbaddress.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbaddress);

        JLabel labelphone = new JLabel("Phone: ");
        labelphone.setBounds(500, 210, 150, 25);
        labelphone.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelphone);

        lbphone = new JLabel();
        lbphone.setBounds(630, 210, 150, 25);
        lbphone.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbphone);

        JLabel labelemail = new JLabel("Email: ");
        labelemail.setBounds(500, 270, 150, 25);
        labelemail.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelemail);

        lbemail = new JLabel();
        lbemail.setBounds(630, 270, 200, 25);
        lbemail.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbemail);

        backButton = new JButton("Back");
        backButton.setBounds(350, 390, 150, 30);
        backButton.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(100, 450, 600, 200);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()) {
                lbusername.setText(rs.getString("username"));
                lbid.setText(rs.getString("id"));
                lbnumber.setText(rs.getString("number"));
                lbname.setText(rs.getString("name"));
                lbgender.setText(rs.getString("gender"));
                lbcountry.setText(rs.getString("country"));
                lbaddress.setText(rs.getString("address"));
                lbphone.setText(rs.getString("phone"));
                lbemail.setText(rs.getString("email"));
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

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewCustomer("");
    }
}
