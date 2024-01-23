package hotelMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text=new JLabel("THE TAJ GROUP WELCOME YOU..");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,45));
        text.setForeground(Color.WHITE);//to change text color
        image.add(text);

        JMenuBar mb=new JMenuBar();// to add menu-bar
        mb.setBounds(0,0,15550,30);
        image.add(mb);

        JMenu hotel=new JMenu("HOTEL MANAGEMENT");// to add menu in menu-bar
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem reception=new JMenuItem("RECEPTION");// to add sub item in menu
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin=new JMenu("ADMIN");// to add menu in menu-bar
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem addemp=new JMenuItem("ADD EMPLOYEE");
        addemp.addActionListener(this);
        admin.add(addemp);

        JMenuItem addrooms=new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem adddriver=new JMenuItem("ADD DRIVERS");
        adddriver.addActionListener(this);
        admin.add(adddriver);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //to extract text from menu we have to use getActionCommand
        if (e.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        } else if (e.getActionCommand().equals("ADD ROOMS")) {
            new AddRooms();
        } else if (e.getActionCommand().equals("ADD DRIVERS")) {
            new AddDrivers();
        } else if (e.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }

}
