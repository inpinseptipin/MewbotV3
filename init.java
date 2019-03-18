import javax.swing.*;  
class youtube
{  
  public static JLabel H1()
  {
    JLabel h;
    h=new JLabel("Welcome to MewBot");
    h.setBounds(200,250,150,100);
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
    f.setSize(400,500);//400 width and 500 height  
    f.setLayout(null);//using no layout managers  
    f.setVisible(true);//making the frame visible  
  }  

  
}  
