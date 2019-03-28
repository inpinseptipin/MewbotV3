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
import java.awt.Component;
import javafx.scene.control.TextArea;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import java.io.FileWriter;
import java.io.BufferedWriter;
import javafx.concurrent.Task;
import javafx.application.Platform;



  
public class init extends Application
{  
  
    static Image i;
    static Text t1;
    static Text t2;
   	
    static Label l1;
    static Button b1;
    static Button b2;
    static Button b3;
    static TextField tf1;    
    static String url;

    public static Text t3;


    public init()
    {
    	t3=init_Text("HELLO",185,175);

    }

    public TextField init_TextField(String title,int x, int y, int h)
    {
        TextField t = new TextField();
        t.setText(title);
        t.setTranslateX(x);
        t.setTranslateY(y);
        t.setPrefColumnCount(h);
        return t;
    }
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

    EventHandler<ActionEvent> download1=new EventHandler<ActionEvent>()
    {
    	public void handle(ActionEvent e)	
    	{
    		new Thread()
    		{    			    			
	    		public void run() 
	    		{
	    			
			        try
			        { 
			                    
			            String line;                   
			            Process proc_1 = new ProcessBuilder("C:\\Users\\arsen\\Desktop\\MewBot.exe\\build\\Bin\\ripper.exe","C:\\Users\\arsen\\Desktop\\MewBot.exe\\build\\Bin\\music.txt").start();; 
			            BufferedReader bri=new BufferedReader(new InputStreamReader(proc_1.getInputStream()));
			            BufferedReader bre=new BufferedReader(new InputStreamReader(proc_1.getErrorStream()));

			            while((line=bri.readLine())!=null)
			            {
			                System.out.println(line);
			       			  
			                t3.setText(line);
			                Thread.sleep(300); 
			                
			            }
			            bri.close();

			            while((line=bre.readLine())!=null)
			            {            
			                System.out.println(line);
			                
			                t3.setText(line);
			                Thread.sleep(1000);
			            }
			            bre.close();
			            
			            System.out.println("Done");

			        } 
			        catch (IOException e) 
			        { 
			            e.printStackTrace(); 
			            System.out.println("In exception");
			            
			        } 
			        catch(InterruptedException k)
			        {
			        	System.out.println("Thread interrupted");
			        }

			        Platform.runLater(new Runnable()
			        {
			        	public void run()
			        	{
			        		
			        	}
			        });
			    }
	    	}.start();
	    }	
    };
    
    
    	

    

    EventHandler<ActionEvent> download= new EventHandler<ActionEvent>()
    {
        public void handle(ActionEvent e)
        {
           String line;

           Runnable_1 r_1=new Runnable_1();
           Thread t_1=new Thread(r_1);
           t_1.start();
           
           
           		t3.setText(r_1.retvar());
           
         
            
        }
    };

    EventHandler<ActionEvent> get_url=new EventHandler<ActionEvent>()
    {
    	public void handle(ActionEvent e)
    	{
    		url=tf1.getText();
    		try
    		{
    			FileWriter f1=new FileWriter("C:\\Users\\arsen\\Desktop\\MewBot.exe\\build\\Bin\\music.txt",true);
    			BufferedWriter bf1=new BufferedWriter(f1);
    			bf1.write(url);
    			bf1.newLine();
    			bf1.close();

    			Alert alert=new Alert(AlertType.CONFIRMATION);
    			alert.setTitle("Success");
    			alert.setContentText("Url Successfully Added to the Queue");
    			alert.showAndWait();
    			System.out.println(url);
    			tf1.setText("");	

    		}
    		catch(Exception f)
    		{
    			Alert alert=new Alert(AlertType.ERROR);
    			alert.setTitle("Failure");
    			alert.setContentText("Failed to Add Url to the Download Queue , Try Again");
    			alert.showAndWait();
    			f.printStackTrace();
    		}
    		

    	}
    };

    public static void net_check() throws IOException 
	{
		try
		{
			
			Process proc=Runtime.getRuntime().exec("ping 8.8.8.8");
			int x=proc.waitFor();
			if(x==0)
			{
				System.out.println("Connection Established");
			}
			else
			{
				Alert alert_1=new Alert(AlertType.ERROR);
				alert_1.setTitle("Error Dialog");
				alert_1.setHeaderText("Error");
				alert_1.setContentText("Oooops!!! Your are not connected to the Internet");
				alert_1.showAndWait();
				System.exit(1);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

    @Override                                                                

    public void start(Stage primaryStage) throws Exception
    {
        t1=init_Text("Welcome to MewBot",185,0);
        t1.setFont(Font.font("Chocolate Dealer",45));
        t1.setFill(Color.RED);
        t3=init_Text("HELLO",185,175);

        b1=init_Button("Convert and Download",185,200);
        b2=init_Button("Add Url to the Download Queue",185,450);
        b3=init_Button("Download",185,220);
     	tf1=init_TextField("enter Url Here",250,250,5);

     	
        Image i = new Image("https://i0.wp.com/www.freepptbackgrounds.net/wp-content/uploads/2015/03/Listening-Music-Powerpoint-Templates.jpg?resize=806%2C605&ssl=1");
        BackgroundImage bgi = new BackgroundImage(i,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT); 
        Background bg = new Background(bgi);
        
        StackPane root = new StackPane();
        TilePane root_1=new TilePane();

       	root_1.setBackground(bg);              
        Scene scene = new Scene(root_1,800,600);  

      
      
        b1.setOnAction(download);
        b2.setOnAction(get_url);
        b3.setOnAction(download1);
     
        root_1.getChildren().add(b1);
        root_1.getChildren().add(b2);
        root_1.getChildren().add(t1);
        root_1.getChildren().add(tf1);
        root_1.getChildren().add(t3);
        root_1.getChildren().add(b3);
       


        primaryStage.setTitle("MewBot.exe");  
        primaryStage.setScene(scene);    
        primaryStage.show();  
         net_check();
    }

    public static void main(String[] args) 
    {  
        launch(args);  
    }  
};

class Runnable_1 implements Runnable
{
	public String var;
	init t=new init();
	public Runnable_1()
	{
		this.var="";
	}

	public String retvar()
	{
		return var;
	}

	public void in(String line)
	{
		var=line;
	}

	
	public void run()
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
       			in(line);   
                t.t3.setText(line);
                Thread.sleep(300); 
                
            }
            bri.close();

            while((line=bre.readLine())!=null)
            {            
                System.out.println(line);
                in(line);
                t.t3.setText(line);
                Thread.sleep(1000);
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
        catch(InterruptedException k)
        {
        	System.out.println("Thread interrupted");
        }
    }

};

