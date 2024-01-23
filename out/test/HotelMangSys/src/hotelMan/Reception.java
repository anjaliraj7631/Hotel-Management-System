package hotelMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton newcustomer;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newcustomer=new JButton("New Customer Form");
        newcustomer.setBounds(10,30,180,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);

        JButton rooms=new JButton("Rooms");
        rooms.setBounds(10,70,180,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        add(rooms);

        JButton department=new JButton("Department");
        department.setBounds(10,110,180,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        add(department);

        JButton allEmployee=new JButton("All Employee");
        allEmployee.setBounds(10,150,180,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        add(allEmployee);

        JButton allCustomer=new JButton("Customer Info");
        allCustomer.setBounds(10,190,180,30);
        allCustomer.setBackground(Color.BLACK);
        allCustomer.setForeground(Color.WHITE);
        add(allCustomer);

        JButton managerInfo=new JButton("Manager Info");
        managerInfo.setBounds(10,230,180,30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        add(managerInfo);

        JButton checkout=new JButton("Checkout");
        checkout.setBounds(10,270,180,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);

        JButton update=new JButton("Update");
        update.setBounds(10,310,180,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

        JButton roomStatus=new JButton("Update Room Status");
        roomStatus.setBounds(10,350,180,30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        add(roomStatus);

        JButton pickup=new JButton("Pickup Service");
        pickup.setBounds(10,390,180,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        add(pickup);

        JButton searchRoom=new JButton("Search Room");
        searchRoom.setBounds(10,430,180,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        add(searchRoom);

        JButton logout=new JButton("Logout");
        logout.setBounds(10,470,180,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);

        setBounds(350,200,800,570);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== newcustomer){
            setVisible(false);
            new AddCustomer();
        }
    }
}
