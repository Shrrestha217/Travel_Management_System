package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckPackage extends JFrame {

    CheckPackage() {
        setBounds(450, 200, 900, 600);

        JTabbedPane tab = new JTabbedPane();

        String[] package1 = {"GOLDEN PACKAGE", "6 Days And 7 Nights", "In The Blues Of Lakshwadeep", "Airport Assistance", "Half Day City Tour", "Daily Buffer", "Welcome Drinks on Arrival", "Full Day Island Cruise", "Rs. 34000/-", "package1.jpg"};
        String[] package2 = {"SILVER PACKAGE", "5 Days And 6 Nights", "In Heaven On Earth Kashmir", "Free Entrance Tickets", "Meet And Greet At Airport", "Welcome Drinks On Arrival", "Night Safari", "Cruise With Dinner", "Rs. 26000/-", "package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE", "5 Days And 4 Nights", "In Gods Own Land Kerala", "Return Airfare", "Free Clubbing And Disco", "River Rafting", "Daily Buffet", "BBQ Dinner", "Rs. 12000/-", "package3.jpg"};

        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null, p1);
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null, p2);
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null, p3);

        add(tab);

        setVisible(true);
    }

    public JPanel createPackage(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(255, 238, 169));

        JPanel p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(new Color(23, 4, 199));
        p3.setBounds(0, 5, 900, 50);
        p1.add(p3);

        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(300, 10, 300, 30);
        l1.setForeground(new Color(255, 221, 3));
        l1.setFont(new Font("TAHOMA", Font.BOLD, 30));
        p3.add(l1);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(255, 191, 120));
        p2.setBounds(30, 70, 350, 450);
        p1.add(p2);

        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30, 30, 300, 30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("TAHOMA", Font.BOLD, 20));
        p2.add(l2);

        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30, 75, 300, 30);
        l3.setForeground(new Color(0, 0, 128));
        l3.setFont(new Font("TAHOMA", Font.BOLD, 20));
        p2.add(l3);

        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(30, 120, 300, 30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("TAHOMA", Font.BOLD, 20));
        p2.add(l4);

        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30, 165, 300, 30);
        l5.setForeground(new Color(0, 0, 128));
        l5.setFont(new Font("TAHOMA", Font.BOLD, 20));
        p2.add(l5);

        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(30, 210, 300, 30);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("TAHOMA", Font.BOLD, 20));
        p2.add(l6);

        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30, 255, 300, 30);
        l7.setForeground(new Color(0, 0, 128));
        l7.setFont(new Font("TAHOMA", Font.BOLD, 20));
        p2.add(l7);

        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(30, 300, 300, 30);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("TAHOMA", Font.BOLD, 20));
        p2.add(l8);

        JLabel l9 = new JLabel("Book Now");
        l9.setBounds(70, 340, 300, 50);
        l9.setForeground(new Color(255, 0, 0));
        l9.setFont(new Font("TAHOMA", Font.BOLD, 32));
        p2.add(l9);

        MouseAdapter ml = new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setFont(new Font("TAHOMA", Font.BOLD, 36));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setFont(new Font("TAHOMA", Font.BOLD, 30));
            }
        };
        l9.addMouseListener(ml);

        JLabel l10 = new JLabel(pack[8]);
        l10.setBounds(70, 390, 300, 50);
        l10.setForeground(new Color(0, 0, 128));
        l10.setFont(new Font("TAHOMA", Font.BOLD, 28));
        p2.add(l10);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/" + pack[9]));
        Image i2 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label1 = new JLabel(i3);
        label1.setBounds(400, 70, 450, 450);
        p1.add(label1);

        return p1;
    }

    public static void main(String[] args) {
        new CheckPackage();
    }
}
