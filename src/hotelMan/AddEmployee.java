package hotelMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tfname, tfage, tsal, tphone, temail, taadhar;
    JRadioButton rbfemale, rbmale;
    JButton submit;
    JComboBox cjjob;
    AddEmployee(){
        setLayout(null);
        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);

        JLabel lblage=new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);

        tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);

        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);

        rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(280,130,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob=new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);

        String str[]={"Frontend Desk Clerks","Porters","Housekepping","Kitchen Staft","Room Service","Chefs","Waiter/Waiteress","Manager","Accountant"};
        cjjob=new JComboBox(str);
        cjjob.setBounds(200,180,150,30);
        cjjob.setBackground(Color.WHITE);
        add(cjjob);

        JLabel lblsal=new JLabel("SALARY");
        lblsal.setBounds(60,230,120,30);
        lblsal.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblsal);

        tsal=new JTextField();
        tsal.setBounds(200,230,150,30);
        add(tsal);

        JLabel lblphone=new JLabel("PHONE");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblphone);

        tphone=new JTextField();
        tphone.setBounds(200,280,150,30);
        add(tphone);

        JLabel lblemail=new JLabel("EMAIL");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblemail);

        temail=new JTextField();
        temail.setBounds(200,330,150,30);
        add(temail);

        JLabel lblaadhar=new JLabel("AADHAR");
        lblaadhar.setBounds(60,380,120,30);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblaadhar);

        taadhar=new JTextField();
        taadhar.setBounds(200,380,150,30);
        add(taadhar);

        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);//we can also crop image
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name=tfname.getText();
        String age=tfage.getText();
        String salary=tsal.getText();
        String phone=tphone.getText();
        String email=temail.getText();
        String aadhar=taadhar.getText();

        if (name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty");
            return;
        }
        String gender=null;
        if(rbmale.isSelected()){
            gender="Male";
        }else if(rbfemale.isSelected()){
            gender="Female";
        }

        String job=(String) cjjob.getSelectedItem();//czz getSelecteditem return an object, to get value from combobox

        try {
            Conn conn=new Conn();
            String query="insert into employee values('"+name+"', '"+age+"','"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')";
            conn.st.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);

        }catch (Exception ee){
            ee.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }


}
