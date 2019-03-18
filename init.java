import javax.swing.*;  
class youtube
{  
  public static void main(String[] args)
  {  
   JFrame f=new JFrame("MewBot.exe");//creating instance of JFrame 
   JLabel l1; 
   l1=new JLabel("YOUTUBE TO MP3");
   l1.setBounds(50,50, 100,30);
   f.setLayout(null);  
   JButton b=new JButton("click me");//creating instance of JButton
   b.setBounds(130,100,100, 40);//x axis, y axis, width, height
   f.setVisible(true);          
   f.add(b);//adding button in JFrame            
   f.setSize(400,500);//400 width and 500 height  
   f.setLayout(null);//using no layout managers  
   f.setVisible(true);//making the frame visible  
  }  
}  
