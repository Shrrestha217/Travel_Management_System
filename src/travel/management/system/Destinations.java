package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable{

    Thread t1;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JLabel[] label = new JLabel[]{l1, l2, l3, l4, l5, l6, l7, l8, l9, l10};
    JLabel caption;
    JPanel p1, p2;

    @Override
    public void run() {
        try {
            int i;
            String[] cap = new String[]{"Kashmir", "Rajasthan", "Kerala", "West Bengal", "Madhya Pradesh", "Tamil Nadu", "Assam", "Uttar Pradesh", "Maharasthra", "Chattisgarh"};

            for(i = 0; i < 10; i++) {
                label[i].setVisible(true);
                caption.setText(cap[i]);

                Thread.sleep(2500);

                label[i].setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(false);
    }

    Destinations(){
        setBounds(500, 200, 800, 750);

        int i;
        ImageIcon i1 = null, i2 = null, i3 = null, i4 = null, i5 = null, i6 = null, i7 = null, i8 = null, i9 = null, i10 = null;
        ImageIcon[] image = new ImageIcon[]{i1, i2, i3, i4, i5, i6, i7, i8, i9, i10};

        Image j1 = null, j2 = null, j3 = null, j4 = null, j5 = null, j6 = null, j7 = null, j8 = null, j9 = null, j10 = null;
        Image[] jimage = new Image[]{j1, j2, j3, j4, j5, j6, j7, j8, j9, j10};

        ImageIcon k1 = null, k2 = null, k3 = null, k4 = null, k5 = null, k6 = null, k7 = null, k8 = null, k9 = null, k10 = null;
        ImageIcon[] kimage = new ImageIcon[]{k1, k2, k3, k4, k5, k6, k7, k8, k9, k10};

        for(i = 0; i < 10; i++) {
            image[i] = new ImageIcon(ClassLoader.getSystemResource("icon/hotel"+(i+1)+".jpg"));
            jimage[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            label[i] = new JLabel(kimage[i]);
            label[i].setBounds(0, 50, 800, 600);
            add(label[i]);
        }

        p1 = new JPanel();
        p1.setBounds(0, 0, 800, 50);
        p1.setBackground(new Color(247, 235, 203));
        add(p1);

        JLabel head = new JLabel("CHECK OUT THE AMAZING LOCATIONS");
        head.setBounds(0, 5, 300, 40);
        head.setHorizontalAlignment(SwingConstants.CENTER);
        head.setFont(new Font("TAHOMA", Font.BOLD, 34));
        head.setForeground(Color.RED);
        p1.add(head);

        p2 = new JPanel();
        p2.setBounds(0, 650, 800, 50);
        p2.setBackground(new Color(247, 235, 203));
        p2.setLayout(null);
        add(p2);

        caption = new JLabel();
        caption.setForeground(new Color(64, 14, 179));
        caption.setBounds(0, 660, 760, 50);
        caption.setFont(new Font("TAHOMA", Font.BOLD, 34));
        caption.setHorizontalAlignment(SwingConstants.CENTER);
        p2.add(caption);

        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Destinations();
    }
}
