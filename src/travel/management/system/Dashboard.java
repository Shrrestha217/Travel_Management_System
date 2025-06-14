package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class Dashboard extends JFrame implements ActionListener {

    String username;
    JButton addPersonalDetails, updatePersonalDetails, viewPersonalDetails, deletePersonalDetails, checkPackage, viewPackage, 
            bookPackage, viewHotels, bookHotels, viewBookedHotel, destinations, payments, calculator, notepad, exit;
    
    Dashboard(String username) {
        this.username = username;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1920, 72);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(72, 72, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 72, 72);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(85, 15, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 32));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 72, 300, 944);
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 300, 63);
        addPersonalDetails.setBackground(new Color(0, 0, 102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 63, 300, 63);
        updatePersonalDetails.setBackground(new Color(0, 0, 102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0, 126, 300, 63);
        viewPersonalDetails.setBackground(new Color(0, 0, 102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 189, 300, 63);
        deletePersonalDetails.setBackground(new Color(0, 0, 102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackage = new JButton("Check Package");
        checkPackage.setBounds(0, 252, 300, 63);
        checkPackage.setBackground(new Color(0, 0, 102));
        checkPackage.setForeground(Color.WHITE);
        checkPackage.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        checkPackage.addActionListener(this);
        p2.add(checkPackage);

        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0, 315, 300, 63);
        bookPackage.setBackground(new Color(0, 0, 102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton("View Package");
        viewPackage.setBounds(0, 378, 300, 63);
        viewPackage.setBackground(new Color(0, 0, 102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0, 441, 300, 62);
        viewHotels.setBackground(new Color(0, 0, 102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotels = new JButton("Book Hotel");
        bookHotels.setBounds(0, 503, 300, 62);
        bookHotels.setBackground(new Color(0, 0, 102));
        bookHotels.setForeground(Color.WHITE);
        bookHotels.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);

        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0, 565, 300, 62);
        viewBookedHotel.setBackground(new Color(0, 0, 102));
        viewBookedHotel.setForeground(Color.WHITE);
        viewBookedHotel.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        destinations = new JButton("Destinations");
        destinations.setBounds(0, 627, 300, 62);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        destinations.addActionListener(this);
        p2.add(destinations);

        payments = new JButton("Payment");
        payments.setBounds(0, 689, 300, 62);
        payments.setBackground(new Color(0, 0, 102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        payments.addActionListener(this);
        p2.add(payments);

        calculator = new JButton("Calculator");
        calculator.setBounds(0, 751, 300, 62);
        calculator.setBackground(new Color(0, 0, 102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(0, 813, 300, 62);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        notepad.addActionListener(this);
        p2.add(notepad);

        exit = new JButton("Leave");
        exit.setBounds(0, 875, 300, 62);
        exit.setBackground(new Color(0, 0, 102));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        exit.addActionListener(this);
        p2.add(exit);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1920, 1080);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management Application");
        text.setBounds(500, 100, 1500, 70);
        text.setForeground(new Color(0, 0, 102));
        text.setFont(new Font("RALEWAY", Font.BOLD, 55));
        image.add(text);

        MouseAdapter ml = new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setFont(new Font("TAHOMA", Font.BOLD, 22));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setFont(new Font("TAHOMA", Font.PLAIN, 20));
            }
        };

        addPersonalDetails.addMouseListener(ml);
        updatePersonalDetails.addMouseListener(ml);
        viewPersonalDetails.addMouseListener(ml);
        deletePersonalDetails.addMouseListener(ml);
        checkPackage.addMouseListener(ml);
        bookPackage.addMouseListener(ml);
        viewPackage.addMouseListener(ml);
        viewHotels.addMouseListener(ml);
        bookHotels.addMouseListener(ml);
        viewBookedHotel.addMouseListener(ml);
        destinations.addMouseListener(ml);
        payments.addMouseListener(ml);
        calculator.addMouseListener(ml);
        notepad.addMouseListener(ml);
        exit.addMouseListener(ml);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addPersonalDetails ){
            new AddCustomer(username);
        } else if (e.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (e.getSource() == viewPersonalDetails) {
            new ViewCustomer(username);
        } else if (e.getSource() == deletePersonalDetails) {
            new DeleteDetails(username);
        } else if (e.getSource() == checkPackage) {
            new CheckPackage();
        } else if (e.getSource() == viewPackage) {
            new ViewPackage(username);
        } else if (e.getSource() == bookPackage) {
            new BookPackage(username);
        } else if (e.getSource() == viewHotels) {
            new CheckHotels();
        } else if (e.getSource() == bookHotels) {
            new BookHotel(username);
        } else if (e.getSource() == viewBookedHotel) {
            new ViewHotel(username);
        } else if (e.getSource() == destinations) {
            new Destinations();
        } else if (e.getSource() == payments) {
            new Payment();
        } else if (e.getSource() == calculator) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == exit) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Dashboard("");
    }
}
