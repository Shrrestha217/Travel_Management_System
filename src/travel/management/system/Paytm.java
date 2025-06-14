package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class Paytm extends JFrame implements ActionListener {

    Paytm() {
        setBounds(100, 100, 900, 900);

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);

        try {
            pane.setPage("https://paytm.com/");
        } catch (Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html>Could Not Load, Error 404</html>");
        }

        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);

        JButton back = new JButton("Back");
        back.setBounds(740, 30, 100, 40);
        back.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        pane.add(back);

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

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Payment();
    }

    public static void main(String[] args) {
        new Paytm();
    }
}
