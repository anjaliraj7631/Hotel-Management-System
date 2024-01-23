package hotelMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel roomnumber,checkintime,checkouttime;
    JButton checkout,back;
    CheckOut(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("Checkout");
        text.setForeground(Color.BLUE);
        text.setBounds(100,20,100,30);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);

        JLabel lblid=new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);

        ccustomer=new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel tick=new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);

        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);

        roomnumber=new JLabel();
        roomnumber.setBounds(150,130,100,30);
        add(roomnumber);

        JLabel lblcheckin=new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);

        checkintime=new JLabel();
        checkintime.setBounds(150,180,100,30);
        add(checkintime);

        JLabel lblcheckout=new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);

        Date date=new Date();
        checkouttime=new JLabel(""+date);
        checkouttime.setBounds(150,230,150,30);
        add(checkouttime);

        checkout=new JButton("CheckOut");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        checkout.setBounds(30,280,120,30);
        add(checkout);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(170,280,120,30);
        add(back);

        try {
            Conn conn=new Conn();
            ResultSet rs=conn.st.executeQuery("select * from customer");
            while (rs.next()){
                ccustomer.add(rs.getString("number"));
                roomnumber.setText(rs.getString("room"));
                checkintime.setText(rs.getString("checkintime"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image im2=im1.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon im3=new ImageIcon(im2);
        JLabel image=new JLabel(im3);
        image.setBounds(350,50,400,250);
        add(image);

        setBounds(300,200,800,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==checkout){
            String query1="delete from customer where number='"+ccustomer.getSelectedItem()+"' ";
            String query2="update room set availability='Available' where roomnumber='"+roomnumber.getText()+"' ";
            try{
                Conn c=new Conn();
                c.st.executeUpdate(query1);
                c.st.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Check out done");
                setVisible(false);
                new Reception();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
