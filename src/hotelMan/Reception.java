package hotelMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton newcustomer,rooms,department,allEmployee,managerInfo,allCustomer,searchRoom,update,roomStatus,pickup,checkout,logout;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newcustomer=new JButton("New Customer Form");
        newcustomer.setBounds(10,30,180,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);

        rooms=new JButton("Rooms");
        rooms.setBounds(10,70,180,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

        department=new JButton("Department");
        department.setBounds(10,110,180,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        allEmployee=new JButton("All Employee");
        allEmployee.setBounds(10,150,180,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

        allCustomer=new JButton("Customer Info");
        allCustomer.setBounds(10,190,180,30);
        allCustomer.setBackground(Color.BLACK);
        allCustomer.setForeground(Color.WHITE);
        allCustomer.addActionListener(this);
        add(allCustomer);

        managerInfo=new JButton("Manager Info");
        managerInfo.setBounds(10,230,180,30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkout=new JButton("Checkout");
        checkout.setBounds(10,270,180,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        update=new JButton("Update");
        update.setBounds(10,310,180,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        roomStatus=new JButton("Update Room Status");
        roomStatus.setBounds(10,350,180,30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickup=new JButton("Pickup Service");
        pickup.setBounds(10,390,180,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);

        searchRoom=new JButton("Search Room");
        searchRoom.setBounds(10,430,180,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);

        logout=new JButton("Logout");
        logout.setBounds(10,470,180,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
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
        } else if (e.getSource()==rooms) {
            setVisible(false);
            new Room();
        } else if (e.getSource()==department) {
            setVisible(false);
            new Department();
        } else if (e.getSource()==allEmployee) {
            setVisible(false);
            new EmployeeInfo();
        } else if (e.getSource()==managerInfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (e.getSource()==allCustomer) {
            setVisible(false);
            new CustomerInfo();
        }else if (e.getSource()==searchRoom){
            setVisible(false);
            new SearchRoom();
        }else if (e.getSource()==update){
            setVisible(false);
            new UpdateCheck();
        } else if (e.getSource()==roomStatus) {
            setVisible(false);
            new UpdateRoom();
        } else if (e.getSource()==pickup) {
            setVisible(false);
            new Pickup();
        } else if (e.getSource()==checkout) {
            setVisible(false);
            new CheckOut();
        }else if (e.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
    }
}
