package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class Payment extends JFrame implements ActionListener {

    JButton pay, back;

    Payment(){
        setBounds(500, 200, 800, 600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 800, 600);
        add(l1);

        pay = new JButton("Payment");
        pay.setBounds(20, 30, 150, 40);
        pay.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(620, 30, 100, 40);
        back.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

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
        back.addMouseListener(ml);
        pay.addMouseListener(ml);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Payment();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pay) {

        }else if (e.getSource() == back) {
            setVisible(false);
        }
    }
}
