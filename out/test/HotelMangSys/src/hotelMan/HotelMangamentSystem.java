package hotelMan;
import javax.swing.*;  // using for create frame jframe is persent inside swing package in java extended v
import java.awt.*;
import java.awt.event.*;

public class HotelMangamentSystem extends JFrame implements ActionListener {
    HotelMangamentSystem(){
//        setSize(1366,565);//size of frame l and w
//        setLocation(100,100);// to set location of frame by default it is top left origin from top:100 and from left:100
        setBounds(0,0,1366,565);
        setLayout(null);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));// icon is store in img1
        JLabel image=new JLabel(img1);
        image.setBounds(0,0,1366,565);//used to make layout // taking four propert: locationx, location y, length, width //combin of set loc & size
        add(image);  //used to place component on the frame
        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");//to write text over frame
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);// to change text color
        text.setFont(new Font("serif",Font.PLAIN,30));
        image.add(text);

        JButton next=new JButton("Next");
        next.setBounds(1250,450,60,40);
        next.setBackground(Color.WHITE);
        next.addActionListener(this);
        image.add(next);

        setVisible(true);//to show visibility of frame

        while (true){ // for dipper functionality
            text.setVisible(false);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
//overriding method from ActionListener
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
       new HotelMangamentSystem(); //to open frame making this constructor
    }
}
