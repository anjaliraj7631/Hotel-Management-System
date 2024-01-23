package hotelMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame implements ActionListener {
    JButton addr,cancel;
    JTextField tfname,tfage,tfcarcompany, tfcarmodel,tflocation;
    JComboBox gendercombo, availcombo;
    AddDrivers(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("Add Drivers");
        heading.setFont(new Font("Thoma",Font.BOLD,20));
        heading.setBounds(150,10,200,20);
        add(heading);

        JLabel lblname=new JLabel("Name");
        lblname.setFont(new Font("Thoma",Font.PLAIN,16));
        lblname.setBounds(60,70,120,30);
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);

        JLabel lblage=new JLabel("Age");
        lblage.setFont(new Font("Thoma",Font.PLAIN,16));
        lblage.setBounds(60,110,120,30);
        add(lblage);

        tfage=new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);

        JLabel lblgender=new JLabel("Gender");
        lblgender.setFont(new Font("Thoma",Font.PLAIN,16));
        lblgender.setBounds(60,150,120,30);
        add(lblgender);

        String genderop[]={"Male","Female"};
        gendercombo=new JComboBox(genderop);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        JLabel lblcarcompany=new JLabel("Car Company");
        lblcarcompany.setFont(new Font("Thoma",Font.PLAIN,16));
        lblcarcompany.setBounds(60,190,120,30);
        add(lblcarcompany);

        tfcarcompany=new JTextField();
        tfcarcompany.setBounds(200,190,150,30);
        add(tfcarcompany);

        JLabel lblcarmodel=new JLabel("Car Model");
        lblcarmodel.setFont(new Font("Thoma",Font.PLAIN,16));
        lblcarmodel.setBounds(60,230,120,30);
        add(lblcarmodel);

        tfcarmodel=new JTextField();
        tfcarmodel.setBounds(200,230,150,30);
        add(tfcarmodel);

        JLabel lblavail=new JLabel("Available");
        lblavail.setFont(new Font("Thoma",Font.PLAIN,16));
        lblavail.setBounds(60,270,120,30);
        add(lblavail);

        String availop[]={"Available","Busy"};
        availcombo=new JComboBox(availop);
        availcombo.setBounds(200,270,150,30);
        availcombo.setBackground(Color.WHITE);
        add(availcombo);

        JLabel lbllocation=new JLabel("Location");
        lbllocation.setFont(new Font("Thoma",Font.PLAIN,16));
        lbllocation.setBounds(60,310,120,30);
        add(lbllocation);

        tflocation=new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);

        addr=new JButton("Add Driver");
        addr.setForeground(Color.WHITE);
        addr.setBackground(Color.BLACK);
        addr.setBounds(60,370,130,30);
        addr.addActionListener(this);
        add(addr);

        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);

        setBounds(300,200,980,470);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addr){
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String) gendercombo.getSelectedItem();
            String carcompany=tfcarcompany.getText();
            String carmodel=tfcarmodel.getText();
            String available=(String) availcombo.getSelectedItem();
            String location=tflocation.getText();
            try {
                Conn conn=new Conn();
                String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+carcompany+"','"+carmodel+"','"+available+"','"+location+"')";
                conn.st.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"new driver added successfully");
                setVisible(false);

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDrivers();
    }
}
