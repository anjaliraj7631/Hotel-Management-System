package hotelMan;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Room extends JFrame {
    JTable table;
    Room(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        table=new JTable();
        table.setBounds(0,40,500,400);
        add(table);

        try{
            Conn conn=new Conn();
            ResultSet rs =conn.st.executeQuery("select * from room");

        }catch (Exception e){
            e.printStackTrace();
        }

        setBounds(300,200,1050,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
