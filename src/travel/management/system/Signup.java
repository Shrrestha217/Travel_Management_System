package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class Signup extends JFrame implements ActionListener {
    JButton create, back;
    JTextField tfusername, tfname, tfpassword, tfanswer;
    Choice secuirty;

    Signup() {
        setLayout(null);
        setSize(900, 500);
        setLocation(350, 200);
        setUndecorated(false);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 500, 500);
        p1.setLayout(null);
        add(p1);

        JLabel signupCap = new JLabel("Sign Up");
        signupCap.setBounds(170, 30, 150, 50);
        signupCap.setForeground(new Color(17, 18, 72));
        signupCap.setFont(new Font("SAN SERIF", Font.BOLD, 38));
        p1.add(signupCap);

        JLabel lb1username = new JLabel("Username:");
        lb1username.setBounds(50, 110, 150, 30);
        lb1username.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        p1.add(lb1username);

        tfusername = new JTextField();
        tfusername.setBounds(160, 110, 250, 25);
        tfusername.setBorder(BorderFactory.createLoweredBevelBorder());
        p1.add(tfusername);

        JLabel lb2name = new JLabel("Name:");
        lb2name.setBounds(50, 160, 150, 30);
        lb2name.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        p1.add(lb2name);

        tfname = new JTextField();
        tfname.setBounds(160, 160, 250, 25);
        tfname.setBorder(BorderFactory.createLoweredBevelBorder());
        p1.add(tfname);

        JLabel lb3Password = new JLabel("Password:");
        lb3Password.setBounds(50, 210, 150, 30);
        lb3Password.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        p1.add(lb3Password);

        tfpassword = new JTextField();
        tfpassword.setBounds(160, 210, 250, 25);
        tfpassword.setBorder(BorderFactory.createLoweredBevelBorder());
        p1.add(tfpassword);

        JLabel lb4Security = new JLabel("Security Question:");
        lb4Security.setBounds(50, 260, 150, 30);
        lb4Security.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        p1.add(lb4Security);

        secuirty = new Choice();
        secuirty.add("My birth place");
        secuirty.add("My school name");
        secuirty.add("My favourite book");
        secuirty.add("My favourite color");
        secuirty.add("My favourite movie");
        secuirty.add("My pet name");
        secuirty.setBounds(205, 264, 205, 40);
        p1.add(secuirty);

        JLabel lb5Answer = new JLabel("Answer:");
        lb5Answer.setBounds(50, 310, 150, 30);
        lb5Answer.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        p1.add(lb5Answer);

        tfanswer = new JTextField();
        tfanswer.setBounds(160, 310, 250, 25);
        tfanswer.setBorder(BorderFactory.createLoweredBevelBorder());
        p1.add(tfanswer);

        create = new JButton("Create");
        create.setBounds(80, 375, 130, 30);
        create.setBackground(Color.WHITE);
        create.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        create.setForeground(new Color(18, 17, 72));
        create.setBorder(new LineBorder(new Color(18, 17, 72)));
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBounds(280, 375, 130, 30);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        back.setForeground(new Color(18, 17, 72));
        back.setBorder(new LineBorder(new Color(18, 17, 72)));
        back.addActionListener(this);
        p1.add(back);

        MouseAdapter ml = new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(new Color(18, 17, 72));
                c.setForeground(Color.WHITE);
                c.setFont(new Font("SAN SERIF", Font.BOLD, 16));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(Color.WHITE);
                c.setForeground(new Color(18, 17, 72));
            }
        };

        create.addMouseListener(ml);
        back.addMouseListener(ml);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(370, 370, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(430, -15, 500, 500);
        add(l1);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == create) {
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = secuirty.getSelectedItem();
            String answer = tfanswer.getText();

            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Dashboard(username);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
