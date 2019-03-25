import javafx.application.Application; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.canvas.*; 
import javafx.scene.web.*; 
import javafx.scene.image.*; 
import java.io.*; 
import javafx.geometry.*;
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView; 
import javafx.scene.Group;  
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;  
import javafx.scene.text.FontPosture;  
import javafx.scene.text.FontWeight; 
import javafx.scene.paint.Color;
import javafx.stage.Stage;  
import javafx.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
  
public class init extends Application
{  
  
    static Image i;
    static Text t1;
    static Text t2;
    static Label l1;
    static Button b1;    

    public Text init_Text(String title, int x, int y)
    {
        Text t=new Text(title);
        t.setTranslateX(x);
        t.setTranslateY(y);
        return t; 
    }
 
    public Label init_Label(String title,int x,int y)
    {
        Label l=new Label(title);
        l.setTranslateX(x);
        l.setTranslateY(y);
        return l;
    }

    public Button init_Button(String title,int x,int y)
    {
        Button b=new Button(title);
        b.setTranslateX(x);
        b.setTranslateY(y);
        return b;
    }

    EventHandler<ActionEvent> event= new EventHandler<ActionEvent>()
    {
        public void handle(ActionEvent e)
        {
           Runnable_1 r_1=new Runnable_1();
           Thread t_1=new Thread(r_1);
           t_1.start();
            
        }
    };

    

    @Override                                                                

    public void start(Stage primaryStage) throws Exception
    {
        t1=init_Text("Welcome to MewBot",0,-275);
        t1.setFont(Font.font("Chocolate Dealer",45));
        t1.setFill(Color.RED);
               
        b1=init_Button("Download and Convert",0,0);
        
        Image i = new Image("https://i0.wp.com/www.freepptbackgrounds.net/wp-content/uploads/2015/03/Listening-Music-Powerpoint-Templates.jpg?resize=806%2C605&ssl=1");
        BackgroundImage bgi = new BackgroundImage(i,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT); 
        Background bg = new Background(bgi);
        
        StackPane root = new StackPane();

       	root.setBackground(bg);
                      
        Scene scene = new Scene(root,800,600);  

        

        b1.setOnAction(event);
     
        

        root.getChildren().add(b1);
        root.getChildren().add(t1);
        primaryStage.setTitle("MewBot.exe");  
        primaryStage.setScene(scene);    
        primaryStage.show();  
    }

    public static void main(String[] args) 
    {  
        launch(args);  
    }  
}

class Runnable_1 implements Runnable
{
	private int var;

	public Runnable_1()
	{
		this.var=0;
	}

	public  void run()
    {
        Boolean flag=true;
        try
        { 
                       
            String line;                   
            Process proc_1 = new ProcessBuilder("C:\\Users\\arsen\\Desktop\\MewBot.exe\\build\\Bin\\ripper.exe","C:\\Users\\arsen\\Desktop\\MewBot.exe\\build\\Bin\\music.txt").start();; 
            BufferedReader bri=new BufferedReader(new InputStreamReader(proc_1.getInputStream()));
            BufferedReader bre=new BufferedReader(new InputStreamReader(proc_1.getErrorStream()));

            while((line=bri.readLine())!=null)
            {
                System.out.println(line);
            }
            bri.close();

            while((line=bre.readLine())!=null)
            {            
                System.out.println(line);
            }
            bre.close();
            
            System.out.println("Done");

        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
            System.out.println("In exception");
            flag=false;
        } 
    }


}