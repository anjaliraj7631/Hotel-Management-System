package hotelMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JButton addr,cancel;
    JTextField tfroom,tfprice;
    JComboBox availcombo,cleancombo,bedtypecombo;
    AddRooms(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("Add Rooms");
        heading.setFont(new Font("Thoma",Font.BOLD,20));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel lblroomno=new JLabel("Room Number");
        lblroomno.setFont(new Font("Thoma",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);

        tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        JLabel lblavail=new JLabel("Available");
        lblavail.setFont(new Font("Thoma",Font.PLAIN,16));
        lblavail.setBounds(60,130,120,30);
        add(lblavail);

        String availop[]={"Available","Occupied"};
        availcombo=new JComboBox(availop);
        availcombo.setBounds(200,130,150,30);
        availcombo.setBackground(Color.WHITE);
        add(availcombo);

        JLabel lblclean=new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Thoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);

        String cleanop[]={"Cleaned","Dirty"};
        cleancombo=new JComboBox(cleanop);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        JLabel lblprice=new JLabel("Price");
        lblprice.setFont(new Font("Thoma",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);

        tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);

        JLabel lblbedtype=new JLabel("Bed Type");
        lblbedtype.setFont(new Font("Thoma",Font.PLAIN,16));
        lblbedtype.setBounds(60,280,120,30);
        add(lblbedtype);

        String bedtypeopt[]={"Single Bed","Double Bed"};
        bedtypecombo=new JComboBox(bedtypeopt);
        bedtypecombo.setBounds(200,280,150,30);
        bedtypecombo.setBackground(Color.WHITE);
        add(bedtypecombo);

        addr=new JButton("Add Room");
        addr.setForeground(Color.WHITE);
        addr.setBackground(Color.BLACK);
        addr.setBounds(60,350,130,30);
        addr.addActionListener(this);
        add(addr);

        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);

        setBounds(330,200,940,470);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addr){
            String roomnumber=tfroom.getText();
            String availability=(String) availcombo.getSelectedItem();
            String status=(String) cleancombo.getSelectedItem();
            String price=tfprice.getText();
            String bedType=(String) bedtypecombo.getSelectedItem();

            try {
                Conn conn=new Conn();
                String str="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+bedType+"')";
                conn.st.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"new room added successfully");
                setVisible(false);

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRooms();
    }


}
