import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;



class youtube
{  
  
  static JProgressBar bar_1;

  public static JLabel H1()
  {
    JLabel h;
    h=new JLabel("Welcome to MewBot");
    h.setBounds(200,250,10,10);
    return h;
  }

  public static void Bar_1()
  {
    bar_1= new JProgressBar();
    bar_1.setValue(0);
    bar_1.setStringPainted(true);
    
  }

  public static void fill()
  {
    int i=0;
    try
    {
      while(i<=100)
      {
        bar_1.setValue(i+10);
        Thread.sleep(1000);
        i+=20;
      }
    }

    catch(Exception e)
    {

    }
  }

  public static void main(String[] args)
  {  
    JFrame f=new JFrame("MewBot.exe"); //creating instance of JFrame

    JPanel panel_1=new JPanel();
    
    Bar_1();

    panel_1.add(bar_1);

    panel_1.setBounds(10,300,400,50);
    

    JLabel h1=H1();

      
    JButton b=new JButton("click me");//creating instance of JButton
    b.setBounds(130,100,100, 40);//x axis, y axis, width, height
    f.setVisible(true);          
    f.add(h1);
    f.add(panel_1);
    f.add(b);//adding button in JFrame            
    f.setSize(400,500);//400 width and 500 height  
    //f.setLayout(null);//using no layout managers  
    f.setVisible(true);//making the frame visible 

    fill();

     
  }  

  
}  
