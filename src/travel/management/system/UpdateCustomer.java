package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {

    JComboBox combid;
    JTextField tfusername, tfname, tfnumber, tfcountry, tfaddress, tfphone, tfemail;
    JRadioButton rmale, rfemale, rother;
    JButton updateButton, backButton;
    String username;

    UpdateCustomer(String username) {
        this.username = username;

        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel details = new JLabel("Customer Details");
        details.setBounds(130, 30, 300, 40);
        details.setFont(new Font("SAN SERIF", Font.BOLD, 26));
        add(details);

        JLabel lbusername = new JLabel("Username:");
        lbusername.setBounds(50, 90, 150, 25);
        lbusername.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbusername);

        tfusername = new JTextField();
        tfusername.setBounds(160, 90, 250, 25);
        add(tfusername);

        JLabel lbid = new JLabel("Id:");
        lbid.setBounds(50, 130, 150, 25);
        lbid.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbid);

        combid = new JComboBox(new String[] {"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        combid.setBounds(160, 130, 250, 25);
        combid.setBackground(Color.WHITE);
        add(combid);

        JLabel lbnumber = new JLabel("Number:");
        lbnumber.setBounds(50, 170, 150, 25);
        lbnumber.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(160, 170, 250, 25);
        add(tfnumber);

        JLabel lbname = new JLabel("Name:");
        lbname.setBounds(50, 210, 150, 25);
        lbname.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbname);

        tfname = new JTextField();
        tfname.setBounds(160, 210, 250, 25);
        add(tfname);

        JLabel lbgender = new JLabel("Gender:");
        lbgender.setBounds(50, 250, 150, 25);
        lbgender.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(160, 250, 70, 25);
        rmale.setBackground(Color.WHITE);
        rmale.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(230, 250, 100, 25);
        rfemale.setBackground(Color.WHITE);
        rfemale.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
        add(rfemale);

        rother = new JRadioButton("Other");
        rother.setBounds(330, 250, 90, 25);
        rother.setBackground(Color.WHITE);
        rother.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
        add(rother);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        bg.add(rother);

        JLabel lbcountry = new JLabel("Country:");
        lbcountry.setBounds(50, 290, 150, 25);
        lbcountry.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(160, 290, 250, 25);
        add(tfcountry);

        JLabel lbaddress = new JLabel("Address:");
        lbaddress.setBounds(50, 330, 150, 25);
        lbaddress.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbaddress);

        tfaddress = new JTextField();
        tfaddress.setBounds(160, 330, 250, 25);
        add(tfaddress);

        JLabel lbphone = new JLabel("Phone No.:");
        lbphone.setBounds(50, 370, 150, 25);
        lbphone.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbphone);

        tfphone = new JTextField();
        tfphone.setBounds(160, 370, 250, 25);
        add(tfphone);

        JLabel lbemail = new JLabel("Email:");
        lbemail.setBounds(50, 410, 150, 25);
        lbemail.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbemail);

        tfemail = new JTextField();
        tfemail.setBounds(160, 410, 250, 25);
        add(tfemail);

        updateButton = new JButton("Update");
        updateButton.setBounds(80, 460, 150, 30);
        updateButton.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(this);
        add(updateButton);

        backButton = new JButton("Back");
        backButton.setBounds(270, 460, 150, 30);
        backButton.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image i2 = i1.getImage().getScaledInstance(240, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(530, 40, 240, 450);
        add(l1);

        MouseAdapter ml = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                Component c = evt.getComponent();
                c.setFont(new Font("TAHOMA", Font.BOLD, 20));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                Component c = evt.getComponent();
                c.setFont(new Font("TAHOMA", Font.PLAIN, 18));
            }
        };

        updateButton.addMouseListener(ml);
        backButton.addMouseListener(ml);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()) {
                tfusername.setText(rs.getString("username"));
                combid.setSelectedItem(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfname.setText(rs.getString("name"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                String gender = rs.getString("gender");
                if (gender.equals("Male")) {
                    rmale.setSelected(true);
                } else if (gender.equals("Female")) {
                    rfemale.setSelected(true);
                } else {
                    rother.setSelected(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updateButton){
            String username = tfusername.getText();
            String id = (String) combid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if (rmale.isSelected()){
                gender = "Male";
            } else if (rfemale.isSelected()) {
                gender = "Female";
            } else if (rother.isSelected()) {
                gender = "Other";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"'";
            try {
                Conn c  = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Upated Successfully");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("");
    }
}
