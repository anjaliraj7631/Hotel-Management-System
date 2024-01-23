package hotelMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JComboBox idcombo;
    JTextField tfnumber, tfname, tfcountry,tfdeposit;
    JRadioButton rbfemale,rbmale;
    JButton addcus,back;

    Choice croom;
    JLabel checkintime;
    AddCustomer() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(text);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35, 80, 100, 20);
        lblid.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(lblid);

        String options[] = {"Aadhar Card", "Passport", "Driving License", "Voter-id Card", "Ration Card"};
        idcombo = new JComboBox(options);
        idcombo.setBounds(200, 80, 150, 25);
        idcombo.setBackground(Color.WHITE);
        add(idcombo);

        JLabel lblnumber = new JLabel("Id Number");
        lblnumber.setBounds(35, 120, 100, 20);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200, 120, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 160, 100, 20);
        lblname.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 200, 60, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(270, 200, 100, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35, 240, 100, 20);
        lblcountry.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        add(tfcountry);

        JLabel lblroomnum = new JLabel("Room Number");
        lblroomnum.setBounds(35, 280, 150, 20);
        lblroomnum.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(lblroomnum);

        croom=new Choice();

        try {
            Conn con=new Conn();
            String query="select * from room where availability='Available'";
            ResultSet rs=con.st.executeQuery(query);
            while (rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        croom.setBounds(200,280,150,25);
        add(croom);

        JLabel lbltime = new JLabel("Check-in time");
        lbltime.setBounds(35, 320, 150, 20);
        lbltime.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(lbltime);

        Date date=new Date();

        checkintime=new JLabel(""+date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(checkintime);

        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35, 360, 100, 20);
        lbldeposit.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(lbldeposit);

        tfdeposit =new JTextField();
        tfdeposit.setBounds(200, 360, 150, 25);
        add(tfdeposit);

        addcus=new JButton("Add Customer");
        addcus.setForeground(Color.WHITE);
        addcus.setBackground(Color.BLACK);
        addcus.setBounds(50,410,120,30);
        addcus.addActionListener(this);
        add(addcus);

        back=new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);

        setBounds(350, 200, 800, 550);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AddCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== addcus){
            String id=(String) idcombo.getSelectedItem();
            String number=tfnumber.getText();
            String name=tfname.getText();
            String gender=null;
            if(rbmale.isSelected()){
                gender="Male";
            }else {
                gender="Female";
            }
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String time=checkintime.getText();
            String deposit=tfdeposit.getText();

            try {
                String query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2="update room set availability='Occupied' where roomnumber= '"+room+"' ";

                Conn conn=new Conn();
                conn.st.executeUpdate(query);
                conn.st.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
                setVisible(false);
                new Reception();

            }catch (Exception eh){
                eh.printStackTrace();
            }

        } else if (e.getSource()==back) {
            setVisible(false);
            new Reception();
        }
    }
}
