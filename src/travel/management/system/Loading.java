package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame {
    Thread t;
    JProgressBar bar;
    String username;

    public void run() {
        try {
            int i, max, value;
            for(i = 1; i <= 101; i++) {
                max = bar.getMaximum();
                value = bar.getValue();

                if(value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {
        this.username = username;
        t = new Thread(this::run);

        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel and Toruism Application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(new Color(3, 33, 163));
        text.setFont(new Font("RALEWAY", Font.BOLD, 36));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150, 110, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(210, 140, 600, 40);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("RALEWAY", Font.BOLD, 16));
        add(loading);

        JLabel lbusername = new JLabel("Welcome " + username);
        lbusername.setBounds(150, 220, 600, 40);
        lbusername.setForeground(new Color(29, 122, 59));
        lbusername.setFont(new Font("RALEWAY", Font.BOLD, 30));
        add(lbusername);

        t.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Loading("");
    }
}
