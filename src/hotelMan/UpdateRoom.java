package hotelMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField tfroom,tfavailable,tfcleaningstaus,tfpaid,tfpending;
    JButton check,back,update;
    UpdateRoom(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Thomas",Font.PLAIN,25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lblid=new JLabel("Customer Id");
        lblid.setBounds(30,80,100,20);
        add(lblid);

        ccustomer=new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        try {
            Conn conn=new Conn();
            ResultSet rs=conn.st.executeQuery("select * from customer");
            while (rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(30,130,100,20);
        add(lblroom);

        tfroom=new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);

        JLabel lblname=new JLabel("Availability");
        lblname.setBounds(30,180,100,20);
        add(lblname);

        tfavailable=new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);

        JLabel lblcleaningstatus=new JLabel("Cleaning Status");
        lblcleaningstatus.setBounds(30,230,100,20);
        add(lblcleaningstatus);

        tfcleaningstaus=new JTextField();
        tfcleaningstaus.setBounds(200,230,150,25);
        add(tfcleaningstaus);

        check=new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        check.setBounds(30,300,100,30);
        add(check);

        update=new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setBounds(150,300,100,30);
        add(update);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(270,300,100,30);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,50,500,300);
        add(image);

        setBounds(300,200,980,450);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
            String id=ccustomer.getSelectedItem();
            String query="select * from customer where number='"+id+"'";
            try {
                Conn c=new Conn();
                ResultSet rs=c.st.executeQuery(query);
                while (rs.next()){
                    tfroom.setText(rs.getString("room"));
                }

                ResultSet rs2=c.st.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"' ");
                while (rs2.next()){
                   tfavailable.setText(rs2.getString("availability"));
                   tfcleaningstaus.setText(rs2.getString("cleaning_status"));
                }
            }catch (Exception e1){
                e1.printStackTrace();
            }
        } else if (e.getSource()==update) {
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String avilable=tfavailable.getText();
            String status=tfcleaningstaus.getText();

            try {
                Conn con=new Conn();
                con.st.executeUpdate("update room set availability='"+avilable+"',cleaning_status='"+status+"'  where roomnumber='"+room+"' " );
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                setVisible(false);
                new Reception();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }
}
