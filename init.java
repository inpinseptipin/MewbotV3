import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;  
class youtube
{  
  public static JLabel H1()
  {
    JLabel h;
    h=new JLabel("Welcome to MewBot");
    h.setBounds(200,0,300,100);
    h.setFont(new Font("Courier New", Font.BOLD, 20));
    h.setForeground(Color.BLUE);
    return h;
  }

  public static void main(String[] args)
  {  
    JFrame f=new JFrame("MewBot.exe"); //creating instance of JFrame

    JLabel h1=H1();

    f.setLayout(null);  
    JButton b=new JButton("click me");//creating instance of JButton
    b.setBounds(130,100,100, 40);//x axis, y axis, width, height
    f.setVisible(true);          
    f.add(h1);
    f.add(b);//adding button in JFrame            
    f.setSize(600,700);//600 width and 800 height  
    f.setLayout(null);//using no layout managers  
    f.setVisible(true);//making the frame visible  
  }  

  
}  
