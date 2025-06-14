package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bill extends JFrame implements ActionListener {

    int days, person, rooms, ac, food;
    JButton back;

    public int TotalPrice(int days, int person, int rooms, int ac, int food){
        this.days = days;
        this.person = person;
        this.rooms = rooms;
        this.ac = ac;
        this.food = food;

        setBounds(500, 200, 500, 500);
        getContentPane().setBackground(new Color(196, 238, 244));
        setLayout(null);

        JLabel text = new JLabel("-----BILL-----");
        text.setBounds(150, 0, 200, 50);
        text.setForeground(new Color(6, 5, 59));
        text.setFont(new Font("TAHOMA", Font.BOLD, 24));
        add(text);

        JLabel bar = new JLabel("-----------------------------------------------------------------------------------");
        bar.setBounds(0, 50, 550, 50);
        bar.setForeground(new Color(6, 5, 59));
        bar.setFont(new Font("TAHOMA", Font.BOLD, 24));
        add(bar);

        JLabel perperson= new JLabel("Price Per Person:");
        perperson.setBounds(30, 80, 200, 50);
        perperson.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(perperson);

        JLabel valueperperson= new JLabel(String.valueOf(rooms));
        valueperperson.setBounds(350, 80, 200, 50);
        valueperperson.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(valueperperson);

        JLabel labelac= new JLabel("Ac/Non-Ac:");
        labelac.setBounds(30, 110, 200, 50);
        labelac.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(labelac);

        JLabel valueac= new JLabel(String.valueOf(ac));
        valueac.setBounds(350, 110, 200, 50);
        valueac.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(valueac);

        JLabel labelfood= new JLabel("Food Charges:");
        labelfood.setBounds(30, 140, 200, 50);
        labelfood.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(labelfood);

        JLabel valuefood= new JLabel(String.valueOf(food));
        valuefood.setBounds(350, 140, 200, 50);
        valuefood.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(valuefood);

        JLabel bar1 = new JLabel("-----------------------------------------------------------------------------------");
        bar1.setBounds(0, 180, 550, 50);
        bar1.setForeground(new Color(6, 5, 59));
        bar1.setFont(new Font("TAHOMA", Font.BOLD, 24));
        add(bar1);

        JLabel labelperson = new JLabel("Cost Per Person Per Day:");
        labelperson.setBounds(30, 210, 200, 50);
        labelperson.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(labelperson);

        int val = rooms + food + ac;

        JLabel valueperson = new JLabel(String.valueOf(val));
        valueperson.setBounds(350, 210, 200, 50);
        valueperson.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(valueperson);

        JLabel lbnoofperson= new JLabel("Total No. Of Persons:");
        lbnoofperson.setBounds(30, 240, 200, 50);
        lbnoofperson.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(lbnoofperson);

        JLabel valuenoofperson= new JLabel(String.valueOf(person));
        valuenoofperson.setBounds(350, 240, 200, 50);
        valuenoofperson.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(valuenoofperson);

        JLabel lbnoofdays= new JLabel("Total No. Of Days:");
        lbnoofdays.setBounds(30, 270, 200, 50);
        lbnoofdays.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(lbnoofdays);

        JLabel valuenoofdays= new JLabel(String.valueOf(days));
        valuenoofdays.setBounds(350, 270, 200, 50);
        valuenoofdays.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(valuenoofdays);

        JLabel bar2 = new JLabel("-----------------------------------------------------------------------------------");
        bar2.setBounds(0, 310, 550, 50);
        bar2.setForeground(new Color(6, 5, 59));
        bar2.setFont(new Font("TAHOMA", Font.BOLD, 24));
        add(bar2);

        JLabel lbtotal= new JLabel("Grand Total:");
        lbtotal.setBounds(30, 350, 200, 50);
        lbtotal.setFont(new Font("TAHOMA", Font.BOLD, 18));
        add(lbtotal);

        int total = val * person * days;

        JLabel valuetotal= new JLabel(String.valueOf(total));
        valuetotal.setBounds(350, 350, 200, 50);
        valuetotal.setFont(new Font("TAHOMA", Font.BOLD, 18));
        add(valuetotal);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 410, 100, 30);
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);

        setVisible(true);

        return total;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        Bill grandTotal = new Bill();
        grandTotal.TotalPrice(0, 0, 0, 0, 0);
    }
}
