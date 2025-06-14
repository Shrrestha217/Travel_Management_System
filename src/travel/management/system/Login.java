package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, forgotPassword;
    JTextField tfusername, tfpassword;

    Login() {
        setLayout(null);
        setSize(900, 500);
        setLocation(350, 200);
        setUndecorated(false);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 500);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login1.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(-25, -17, 450, 500);
        p1.add(l1);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(183, 228, 248));
        p2.setBounds(400, 0, 500, 500);
        add(p2);

        JLabel loginCap = new JLabel("Login");
        loginCap.setBounds(180, 30, 150, 60);
        loginCap.setFont(new Font("SAN SERIF", Font.BOLD, 38));
        loginCap.setForeground(new Color(18, 17, 72));
        p2.add(loginCap);

        JLabel lb1username = new JLabel("Username:");
        lb1username.setBounds(70, 110, 150, 25);
        lb1username.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        p2.add(lb1username);

        tfusername = new JTextField();
        tfusername.setBounds(70, 150, 330, 30);
        tfusername.setBorder(BorderFactory.createLoweredBevelBorder());
        p2.add(tfusername);

        JLabel lbpassword = new JLabel("Password:");
        lbpassword.setBounds(70, 210, 150, 25);
        lbpassword.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        p2.add(lbpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(70, 240, 330, 30);
        tfpassword.setBorder(BorderFactory.createLoweredBevelBorder());
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(70, 320, 130, 30);
        login.setBackground(new Color(39, 59, 121));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(18, 17, 72)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Sign Up");
        signup.setBounds(270, 320, 130, 30);
        signup.setBackground(new Color(39, 59, 121));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(18, 17, 72)));
        signup.addActionListener(this);
        p2.add(signup);

        JLabel text = new JLabel("Trouble Logging In?");
        text.setBounds(70, 380, 150, 35);
        text.setForeground(Color.RED);
        p2.add(text);

        forgotPassword = new JButton("Forgot Password");
        forgotPassword.setBounds(190, 380, 140, 35);
        forgotPassword.setBackground(new Color(39, 59, 121));
        forgotPassword.setForeground(Color.WHITE);
        forgotPassword.setBorder(new LineBorder(new Color(18, 17, 72)));
        forgotPassword.addActionListener(this);
        p2.add(forgotPassword);

        MouseAdapter ml = new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(new Color(97, 225, 248));
                c.setForeground(new Color(17, 18, 72));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(new Color(39, 59, 121));
                c.setForeground(Color.WHITE);
            }
        };
        login.addMouseListener(ml);
        signup.addMouseListener(ml);
        forgotPassword.addMouseListener(ml);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tfusername.getText();
                String password = tfpassword.getText();

                String query = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == signup) {
            setVisible(false);
            new Signup();

        } else if (e.getSource() == forgotPassword) {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}
