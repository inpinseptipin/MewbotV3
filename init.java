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
import java.io.FileReader;
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
    	

    }

    public TextField init_TextField(String title,int x, int y, int h) //TextField INITIALIZER
    {
        TextField t = new TextField();
        t.setText(title);
        t.setTranslateX(x);
        t.setTranslateY(y);
        t.setPrefColumnCount(h);
        return t;
    }
    public Text init_Text(String title, int x, int y) //TEXT INITALIZER
    {
        Text t=new Text(title);
        t.setTranslateX(x);
        t.setTranslateY(y);
        return t; 
    }
 
    public Label init_Label(String title,int x,int y)//LABEL INITIALIZER
    {
        Label l=new Label(title);
        l.setTranslateX(x);
        l.setTranslateY(y);
        return l;
    }

    public Button init_Button(String title,int x,int y)//BUTTON INITIALIZER
    {
        Button b=new Button(title);
        b.setTranslateX(x);
        b.setTranslateY(y);
        return b;
    }


    public Boolean del_music()//Clear Download Queue
    {
    	Boolean flag=false;
    	File file=new File("C:\\Users\\arsen\\Desktop\\MewBot.exe\\build\\Bin\\music.txt");
		if(file.delete())
		{
			try
			{
				System.out.println("File Successfully Deleted");
				PrintWriter writer=new PrintWriter("C:\\Users\\arsen\\Desktop\\MewBot.exe\\build\\Bin\\music.txt");
				writer.close();		
				flag=true;	
			}
			catch(IOException g)
			{
				g.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("File Failed to Delete");

		}	
		return flag;		      			         
    }

    EventHandler<ActionEvent> download1=new EventHandler<ActionEvent>() // Download Function
    {
    	public void handle(ActionEvent e)	
    	{
    		
    		new Thread()
    		{    			    			
	    		public void run() 
	    		{
	    			Boolean flag=false;
	    			
	    			
	    			
				        try
				        { 
				    		                
				            if(net_check())
	    					{	
	    						System.exit(1);
	    					}

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
				                if(net_check())
				                {
				                	Alert alert_1=new Alert(AlertType.ERROR);
									alert_1.setTitle("Error Dialog");
									alert_1.setHeaderText("MewBot.exe Has to Terminate");
									alert_1.setContentText("Your are not connected to the Internet");
									alert_1.showAndWait();
				                }
				                else
				                {
				                	Alert alert=new Alert(AlertType.ERROR);
				                	alert.setTitle("Error Dialog");
				                	alert.setHeaderText("Download Terminated");
				                	alert.setContentText("URL INVALID");
				                	alert.showAndWait(); 

				                }
				                
				                Thread.sleep(1000);
				            }
				            bre.close();
	 
				        }   
				        catch (IOException e) 
				        { 
				             
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
    
    EventHandler<ActionEvent> download= new EventHandler<ActionEvent>() // Old Download Function
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

    EventHandler<ActionEvent> get_url=new EventHandler<ActionEvent>()  // URL INSERTER
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

    public static Boolean net_check() throws IOException // INTERNET CONNECTION CHECKER
	{
		Boolean flag;
		try
		{
			
			Process proc=Runtime.getRuntime().exec("ping 8.8.8.8");
			int x=proc.waitFor();
			if(x==0)
			{
				System.out.println("Connection Established");
				flag=false;
			}
			else 
			{
				Alert alert_1=new Alert(AlertType.ERROR);
				alert_1.setTitle("Error Dialog");
				alert_1.setHeaderText("MewBot.exe Has to Terminate");
				alert_1.setContentText("Your are not connected to the Internet");
				alert_1.showAndWait();
				flag=true;
				
			}
			
		}
		catch(IOException e)
		{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("I/O Interruption");
			alert.setHeaderText("MewBot.exe has to Terminate");
			alert.setContentText("Application will terminate");
			alert.showAndWait();
			flag=true;
		}	
		catch(InterruptedException e)
		{
			e.printStackTrace();
			flag=true;
		}
		return flag;
	}

    @Override                                                                

    public void start(Stage primaryStage) throws Exception // GUI
    {
        t1=init_Text("Welcome to MewBot",255,10);
        t1.setFont(Font.font("Chocolate Dealer",45));
        t1.setFill(Color.RED);
        
        t3=init_Text("Another Generic Downloader",350,80);
        t3.setFont(Font.font("Rainbow Bridge Personal Use",15));
        t3.setFill(Color.BLUE);

        //b1=init_Button("Convert and Download",185,200);
        b2=init_Button("Add Url to the Download Queue",350,350);
        b3=init_Button("Download",700,250);
     	tf1=init_TextField("enter Url Here",250,250,5);

     	
        Image i = new Image("https://i0.wp.com/www.freepptbackgrounds.net/wp-content/uploads/2015/03/Listening-Music-Powerpoint-Templates.jpg?resize=806%2C605&ssl=1");
        BackgroundImage bgi = new BackgroundImage(i,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT); 
        Background bg = new Background(bgi);
        
        StackPane root = new StackPane();
        GridPane root_1=new GridPane();

       	root_1.setBackground(bg);              
        Scene scene = new Scene(root_1,800,600);  

      
      
        //b1.setOnAction(download);
        b2.setOnAction(get_url);
        b3.setOnAction(download1);
     
        
        root_1.getChildren().add(b2);
        root_1.getChildren().add(t1);
        root_1.getChildren().add(tf1);
        root_1.getChildren().add(t3);
        root_1.getChildren().add(b3);
       
		if(net_check()==true)
		{
			System.exit(1);
		}        
		primaryStage.setTitle("MewBot.exe");  
        primaryStage.setScene(scene);    
        primaryStage.show();  
        
    }

    public static void main(String[] args) 
    {  
        launch(args);  
    }  

    public void will_run() throws IOException
    {
    	try
    	{
    		if(net_check())
    		{
    			System.exit(1);
    		}
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}	
    }
};

class Runnable_1 implements Runnable // Class Running Old Download Button
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
       			   
                t.t3.setText(line);
                Thread.sleep(300); 
                
            }
            bri.close();

            while((line=bre.readLine())!=null)
            {            
                System.out.println(line);
                
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

