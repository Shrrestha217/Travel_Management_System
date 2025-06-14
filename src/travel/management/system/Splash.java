package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread thread;

    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1085, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1200, 600);
        add(l3);

        setUndecorated(true);
        setVisible(true);
        thread = new Thread(this);
        thread.start();
    }

    public void run(){
        try {
            Thread.sleep(7000);
            new Login();
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       Splash frame = new Splash();

       int x = 1;
       for(int i = 1; i <= 500; x+= 7, i+= 6) {
           frame.setLocation(750 - (x + i)/2, 400 - (i/2));
           frame.setSize(x + i, i);

           try{
               Thread.sleep(10);
               Timer timer = new Timer(15, null);
           } catch (Exception e) {};
       }
    }
}
