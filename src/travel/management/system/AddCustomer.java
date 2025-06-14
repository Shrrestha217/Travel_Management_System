package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel labelusername, labelname;
    JComboBox combid;
    JTextField tfnumber, tfcountry, tfaddress, tfphone, tfemail;
    JRadioButton rmale, rfemale, rother;
    JButton addButton, backButton;
    String username;

    AddCustomer(String username) {
        this.username = username;

        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel details = new JLabel("CUSTOMER DETAILS");
        details.setBounds(130, 30, 300, 40);
        details.setFont(new Font("SAN SERIF", Font.BOLD, 26));
        add(details);

        JLabel lbusername = new JLabel("Username:");
        lbusername.setBounds(50, 90, 150, 25);
        lbusername.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbusername);

        labelusername = new JLabel();
        labelusername.setBounds(160, 90, 250, 25);
        add(labelusername);

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

        labelname = new JLabel();
        labelname.setBounds(160, 210, 250, 25);
        add(labelname);

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

        addButton = new JButton("Add");
        addButton.setBounds(80, 460, 100, 30);
        addButton.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(this);
        add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(240, 460, 100, 30);
        backButton.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400, 40, 450, 420);
        add(l1);

        MouseAdapter ml = new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setFont(new Font("TAHOMA", Font.BOLD, 20));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setFont(new Font("TAHOMA", Font.PLAIN, 18));
            }
        };

        addButton.addMouseListener(ml);
        backButton.addMouseListener(ml);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
            ResultSet rs2 = c.s.executeQuery("select * from customer where username = '"+username+"'");
            if (rs2.next()) {
                combid.setSelectedItem(rs2.getString("id"));
                tfnumber.setText(rs2.getString("number"));
                tfcountry.setText(rs2.getString("country"));
                tfaddress.setText(rs2.getString("address"));
                tfphone.setText(rs2.getString("phone"));
                tfemail.setText(rs2.getString("email"));

                String gender = rs2.getString("gender");
                if (gender.equals("Male")) {
                    rmale.setSelected(true);
                } else if (gender.equals("Female")) {
                    rfemale.setSelected(true);
                } else {
                    rother.setSelected(true);
                }

                combid.setEnabled(false);
                tfnumber.setEditable(false);
                tfcountry.setEditable(false);
                tfaddress.setEditable(false);
                tfphone.setEditable(false);
                tfemail.setEditable(false);
                rmale.setEnabled(false);
                rfemale.setEnabled(false);
                rother.setEnabled(false);
                addButton.setVisible(false);
                backButton.setBounds(200, 460, 100, 25);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton){
            String username = labelusername.getText();
            String id = (String) combid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
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

            String query = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
            try {
                Conn c  = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer("");
    }
}
