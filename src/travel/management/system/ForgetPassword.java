package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;

    ForgetPassword() {
        setBounds(350, 200, 850, 420);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(515, 40, 300, 300);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 500, 420);
        add(p1);

        JLabel lbforgotPassword = new JLabel("Forgot Password");
        lbforgotPassword.setBounds(130, 20, 500, 50);
        lbforgotPassword.setFont(new Font("SAN SERIF", Font.BOLD, 26));
        lbforgotPassword.setForeground(Color.BLACK);
        p1.add(lbforgotPassword);

        JLabel lbusername = new JLabel("Username:");
        lbusername.setBounds(40, 90, 100, 25);
        lbusername.setFont(new Font("TAHOMA", Font.BOLD, 14));
        p1.add(lbusername);

        tfusername = new JTextField();
        tfusername.setBounds(130, 90, 180, 25);
        tfusername.setBorder(new LineBorder(Color.BLACK));
        p1.add(tfusername);

        search = new JButton("Search");
        search.setBackground(Color.DARK_GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(330, 91, 100, 25);
        search.addActionListener(this);
        p1.add(search);

        JLabel lbname = new JLabel("Name:");
        lbname.setBounds(40, 140, 100, 25);
        lbname.setFont(new Font("TAHOMA", Font.BOLD, 14));
        p1.add(lbname);

        tfname = new JTextField();
        tfname.setBounds(130, 140, 180, 25);
        tfname.setBorder(new LineBorder(Color.BLACK));
        p1.add(tfname);

        JLabel lbquestion = new JLabel("Security Question:");
        lbquestion.setBounds(40, 190, 150, 25);
        lbquestion.setFont(new Font("TAHOMA", Font.BOLD, 14));
        p1.add(lbquestion);

        tfquestion = new JTextField();
        tfquestion.setBounds(180, 190, 180, 25);
        tfquestion.setBorder(new LineBorder(Color.BLACK));
        p1.add(tfquestion);

        JLabel lbanswer = new JLabel("Answer:");
        lbanswer.setBounds(40, 240, 100, 25);
        lbanswer.setFont(new Font("TAHOMA", Font.BOLD, 14));
        p1.add(lbanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(130, 240, 180, 25);
        tfanswer.setBorder(new LineBorder(Color.BLACK));
        p1.add(tfanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.DARK_GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(330, 240, 100, 25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lbpassword = new JLabel("Password:");
        lbpassword.setBounds(40, 290, 100, 25);
        lbpassword.setFont(new Font("TAHOMA", Font.BOLD, 14));
        p1.add(lbpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(130, 290, 180, 25);
        tfpassword.setBorder(new LineBorder(Color.BLACK));
        p1.add(tfpassword);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("TAHOMA", Font.BOLD, 18));
        back.setBounds(350, 330, 100, 30);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            try {
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("Security"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == retrieve) {
            try {
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND answer = '"+tfusername.getText()+"'";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfpassword.setText(rs.getString("password"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
