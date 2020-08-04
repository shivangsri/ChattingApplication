package chat.app;


import static chat.app.server.din;
import static chat.app.server.dout;
import static chat.app.server.s;
import static chat.app.server.ta;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;


 class Client extends JFrame implements ActionListener{
     JPanel p1;
     JTextField t;
     JButton b;
     static JTextArea ta;
      
     static Socket s;
     static DataInputStream din;
     static DataOutputStream dout;
     
     
    Client(){
        
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,350,50);
        add(p1);
        
        //For back button
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("chat/app/icons/3.png"));
        Image i2=i1.getImage().getScaledInstance(27, 27, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(7, 7, 27, 27);
        p1.add(l1);
        l1.addMouseListener(new MouseAdapter (){
            
            @Override
            public void mouseClicked(MouseEvent e){
                System.exit(0);
                
            }
            
        });
        
        
        
        
        //For DP
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("chat/app/icons/1.png"));
        Image i5=i4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel l2=new JLabel(i6);
        l2.setBounds(40, 5, 40, 40);
        p1.add(l2);
        
        //for name
        JLabel name=new JLabel("Shiva");
        name.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        name.setForeground(Color.WHITE);
        name.setBounds(86,5,100,20);
        p1.add(name);
       
        
        
        //for active
        JLabel active=new JLabel("Active Now");
        active.setFont(new Font("SAN_SERIF",Font.PLAIN,10));
        active.setForeground(Color.WHITE);
        active.setBounds(86,23,100,20);
        p1.add(active);
        
        
        //for dot
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("chat/app/icons/3icon.png"));
        Image i8=i7.getImage().getScaledInstance(7,20, Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel dot=new JLabel(i9);
        dot.setBounds(320, 10, 7, 20);
        p1.add(dot);
        
        
        
        //for phone icon
         ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("chat/app/icons/phone.png"));
        Image i11=i10.getImage().getScaledInstance(25,30 ,Image.SCALE_DEFAULT);
        ImageIcon i12=new ImageIcon(i11);
        JLabel phone=new JLabel(i12);
        phone.setBounds(284, 7, 25, 30);
        p1.add(phone);
       
        
        
        
        //For Video icon
       ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("chat/app/icons/video.png"));
        Image i14=i13.getImage().getScaledInstance(22,30 ,Image.SCALE_DEFAULT);
        ImageIcon i15=new ImageIcon(i14);
        JLabel video=new JLabel(i15);
        video.setBounds(244, 7, 22, 30);
        p1.add(video);
        
        
        
        
        //For Displaying message
        
        ta=new JTextArea();
        ta.setBounds(5,55,340,405);
        ta.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
       
        ta.setEditable(false);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        
        add(ta);
       
        
        
        
        //For entering text
        t=new JTextField();
        t.setBounds(5,470,260,25);
        t.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        add(t);
        
        
        
        //for snd button
        b=new JButton("Send");
        b.setBounds(270,470,70,25);
        b.setBackground(new Color(7,94,84));
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        add(b);
        
        
        
        
       getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        setSize(350,500);
        setLocation(800,100);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
     try{  String ab= t.getText();
     
       ta.setText(ta.getText()+"\n\t\t\t"+ab);
       dout.writeUTF(ab);
       t.setText("");}
     catch(Exception ex){
         
     }
        
    }
       public static void main(String args[]){
        
    
         
    new Client();
    
    try{
    s=new Socket("127.0.0.1",8001);
     din=new DataInputStream(s.getInputStream());
             dout=new DataOutputStream(s.getOutputStream());
             
             String msgin="";
             while(true){
                     msgin=din.readUTF();
                     ta.setText(ta.getText()+"\n"+msgin);}
    }catch(Exception e){
        
    }
    
    
    
    }

  
}












