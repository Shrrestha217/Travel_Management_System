package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    String username;
    JLabel lbusername, lbid, lbnumber, lbphone, lbprice;
    JTextField tfpersons;
    Choice cpackage;
    JButton checkprice, bookpackage, back;

    BookPackage(String username) {
        this.username = username;

        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("TAHOMA", Font.BOLD, 20));
        add(text);

        JLabel labelusername = new JLabel("Username: ");
        labelusername.setBounds(50, 70, 150, 25);
        labelusername.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelusername);

        lbusername = new JLabel();
        lbusername.setBounds(200, 70, 200, 25);
        lbusername.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbusername);

        JLabel labelPack = new JLabel("Select Package: ");
        labelPack.setBounds(50, 130, 150, 25);
        labelPack.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelPack);

        cpackage = new Choice();
        cpackage.add("------Select Package------");
        cpackage.add("Golden Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
        cpackage.setBounds(200, 130, 200, 30);
        add(cpackage);


        JLabel labelpersons = new JLabel("Total Persons: ");
        labelpersons.setBounds(50, 190, 150, 25);
        labelpersons.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelpersons);

        tfpersons = new JTextField();
        tfpersons.setBounds(200, 190, 200, 25);
        tfpersons.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(tfpersons);

        JLabel labelid = new JLabel("Id: ");
        labelid.setBounds(50, 250, 150, 25);
        labelid.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelid);

        lbid = new JLabel();
        lbid.setBounds(200, 250, 200, 25);
        lbid.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbid);

        JLabel labelnumber = new JLabel("Number: ");
        labelnumber.setBounds(50, 310, 150, 25);
        labelnumber.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelnumber);

        lbnumber = new JLabel();
        lbnumber.setBounds(200, 310, 150, 25);
        lbnumber.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbnumber);

        JLabel labelphone = new JLabel("Phone: ");
        labelphone.setBounds(50, 370, 150, 25);
        labelphone.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(labelphone);

        lbphone = new JLabel();
        lbphone.setBounds(200, 370, 200, 25);
        lbphone.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbphone);

        JLabel lbtotalprice = new JLabel("Total Price: ");
        lbtotalprice.setBounds(50, 430, 150, 25);
        lbtotalprice.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbtotalprice);

        lbprice = new JLabel();
        lbprice.setBounds(200, 430, 150, 25);
        lbprice.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lbprice);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()) {
                lbusername.setText(rs.getString("username"));
                lbid.setText(rs.getString("id"));
                lbnumber.setText(rs.getString("number"));
                lbphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 470, 150, 25);
        checkprice.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(250, 470, 180, 25);
        bookpackage.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(160, 510, 150, 25);
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 520, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label1 = new JLabel(i3);
        label1.setBounds(500, 20, 550, 520);
        add(label1);

        MouseAdapter ml = new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setFont(new Font("SAN SERIF", Font.BOLD, 20));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
            }
        };
        checkprice.addMouseListener(ml);
        bookpackage.addMouseListener(ml);
        back.addMouseListener(ml);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;

            if(pack.equals("Golden Package")){
                cost += 34000;
            } else if (pack.equals("Silver Package")) {
                cost += 26000;
            } else if (pack.equals("Bronze Package")) {
                cost += 12000;
            }

            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            lbprice.setText("Rs. " + cost);

        } else if (e.getSource() == bookpackage) {
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+lbusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+lbid.getText()+"', '"+lbnumber.getText()+"', '"+lbphone.getText()+"', '"+lbprice.getText()+"')");

                JOptionPane.showMessageDialog(null, "Package Booked Successfully");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("");
    }
}
