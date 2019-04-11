import javafx.application.Application;
import javafx.application.Platform; 
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
import javafx.scene.control.Button;
import javafx.scene.layout.HBox; 
import javafx.scene.text.Text;
import javafx.scene.text.Font;  
import javafx.scene.text.FontPosture;  
import javafx.scene.text.FontWeight; 
import javafx.scene.paint.Color;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;  
import javafx.event.ActionEvent;
import javafx.concurrent.Task;
import MewBot.Utilities;
import MewBot.Internet;

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
    public static String url;
    static Alert a1;
    public static Text t3;
    static ProgressBar p1;
    static long length;
    public static Boolean url_flag;


    public init()
    {
    	

    }

    //TextField INITIALIZER
    public TextField init_TextField(String title,int x, int y, int h,int z) 
    {
        TextField t = new TextField();
        t.setText(title);
        t.setTranslateX(x);
        t.setTranslateY(y);
        t.setPrefColumnCount(h);
        t.setPrefWidth(z);
        return t;
    }

    //TEXT INITALIZER
    public Text init_Text(String title, int x, int y) 
    {
        Text t=new Text(title);
        t.setTranslateX(x);
        t.setTranslateY(y);
        return t; 
    }
 
    //LABEL INITIALIZER
    public Label init_Label(String title,int x,int y)
    {
        Label l=new Label(title);
        l.setTranslateX(x);
        l.setTranslateY(y);
        return l;
    }

    //BUTTON INITIALIZER
    public Button init_Button(String title,int x,int y)
    {
        Button b=new Button(title);
        b.setTranslateX(x);
        b.setTranslateY(y);
        return b;
    }

    //PROGRESSBAR INITIALIZER
    public ProgressBar init_ProgressBar(int x, int y,int z)
    {
        ProgressBar p=new ProgressBar();
        p.setProgress(0.0);
        p.setTranslateX(x);
        p.setTranslateY(y);
        p.setPrefWidth(z);
        return p;
    }

    

    public void Complete()
    {
        Alert a=new Alert(AlertType.CONFIRMATION);
        a.setTitle("Download Complete");
        a.setHeaderText("");
        a.setContentText("");
        a.showAndWait();

    }

    

    //Download V_2
    EventHandler<ActionEvent> download1=new EventHandler<ActionEvent>() // Download Function
    {
    	public void handle(ActionEvent e)	
    	{
    		
    		new Thread()
    		{    			    			
	    		public void run() 
	    		{
	    			Boolean flag=false;
	    			Utilities util=new Utilities();
				        try
				        { 
				    		                
				            String line;                                                                                   
                            Double f_down;                                 
				            Process proc_1 = new ProcessBuilder("C:\\Program Files\\mewbot.exe\\build\\bin\\ripper.exe","C:\\Program Files\\mewbot.exe\\build\\bin\\music.txt").start(); 
				            BufferedReader bri=new BufferedReader(new InputStreamReader(proc_1.getInputStream()));
				            BufferedReader bre=new BufferedReader(new InputStreamReader(proc_1.getErrorStream()));
				            util.updateMes();

				            while((line=bri.readLine())!=null)
				            {
                                f_down=util.downloadProgress(line);
                                p1.setProgress(f_down);
                                if(f_down==1.0)
                                {
                                    
                                    Complete();
                                    util.popQueue();

                                }
				                //System.out.println(download_progress(line_1));                               
				            } 
                            util.updateMes();
				            bri.close();

				            while((line=bre.readLine())!=null)
				            {            
				                
				                System.out.println(line);
				              
				            }
				            bre.close();
	 
				        }   
				        catch (IOException e) 
				        { 
				             
				            System.out.println("In exception");
				            
				        } 
				        /*catch(InterruptedException k)
				        {
				        	System.out.println("Thread interrupted");
				        }
				        */
				   

			        Platform.runLater(new Runnable()
			        {
			        	public void run()
			        	{
			        		Internet i=new Internet();
			        		Boolean flag=i.netCheck();
			        		if(flag)
			        		{
			        			//Alert Box Needed here
			        		}			        			
			        	}
			        });
			    }
	    	}.start();

	    	
	    }	
    };

    EventHandler<ActionEvent>clear_queue=new EventHandler<ActionEvent>()
    {
        public void handle(ActionEvent e)
        {
 
            Utilities util=new Utilities();
            Boolean flag=util.deleteQueue();
            if(flag)
            {
                Alert del_queue=new Alert(AlertType.CONFIRMATION);
                del_queue.setTitle("Success");
                del_queue.setContentText("Queue Cleared Successfully");
                del_queue.showAndWait();
            }
            else
            {
                Alert del_queue=new Alert(AlertType.ERROR);
                del_queue.setTitle("Failure");
                del_queue.setContentText("Failed to clear the download queue");
                del_queue.showAndWait();   
            }
        }
    };

    // URL INSERTER

    EventHandler<ActionEvent> get_url=new EventHandler<ActionEvent>()  
    {
    	public void handle(ActionEvent e)
    	{
    		Internet internet=new Internet();
    		url=tf1.getText();
            Boolean flag=internet.validUrl(url);
            if(flag)
    		{
                try
        		{
        			FileWriter f1=new FileWriter("C:\\Program Files\\mewbot.exe\\build\\bin\\music.txt",true);
        			BufferedWriter bf1=new BufferedWriter(f1);
        			bf1.write(url);
        			bf1.newLine();
        			bf1.close();

                    RandomAccessFile in=new RandomAccessFile("C:\\Program Files\\mewbot.exe\\build\\bin\\music.txt","rw");
                    length=in.length();
                    System.out.println("Length = "+length);
                    in.close();   
            



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

            else
            {
                Alert alert=new Alert(AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setContentText("Failed to Add Url to the Download Queue , Try Again");
                alert.showAndWait();
                
            }
    	}
    };

    

    @Override                                                                

    public void start(Stage primaryStage) throws Exception // GUI
    {
        t1=init_Text("Welcome to MewBot",255,10);
        t1.setFont(Font.font("Chocolate Dealer",45));
        t1.setFill(Color.web("#05ffcd"));
                
        t3=init_Text("Another Generic Downloader",315,35);
        t3.setFont(Font.font("Rainbow Bridge Personal Use",18));
        t3.setFill(Color.web("#05ffcd"));

        b1=init_Button("Clear Queue",60,350);
        b1.setFont(Font.font("Bookman Old Style",FontWeight.BOLD,16));

        b2=init_Button("Add Url to the Download Queue",250,350);
        b2.setFont(Font.font("Bookman Old Style",FontWeight.BOLD,16));

        b3=init_Button("Download",620,250);
        b3.setFont(Font.font("Bookman Old Style",FontWeight.BOLD,16));

     	tf1=init_TextField("Enter Url Here",10,250,0,0);
        tf1.setFont(Font.font("Courier New",FontWeight.BOLD,16));

        p1=init_ProgressBar(100,550,600);

        Internet internet=new Internet();

       
     	FileInputStream input = new FileInputStream("C:/Program Files/Mewbot.exe/res/BG_3.jpg");
        Image i = new Image(input);
        BackgroundImage bgi = new BackgroundImage(i,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT); 
        Background bg = new Background(bgi);
        
       
        GridPane root_1=new GridPane();
        Scene scene = new Scene(root_1,800,600);
       


        if(internet.netCheck())
        {
            Alert a=new Alert(AlertType.CONFIRMATION);
            a.setTitle("Application Launched Successfully");
            a.setContentText("Welcome to MewBot.exe");
            a.showAndWait();
        }
        else
        {
            Alert a=new Alert(AlertType.ERROR);
            a.setTitle("Error Dialog");
            a.setHeaderText("Mewbot.exe failed to launch");
            a.setContentText("No Internet Connection Detected");
            a.showAndWait();
            System.exit(1);
        }  

       	root_1.setBackground(bg);                    
        b1.setOnAction(clear_queue);
        b2.setOnAction(get_url);
        b3.setOnAction(download1);

        
     
        
        root_1.getChildren().add(tf1);
        root_1.getChildren().add(b3);
        root_1.getChildren().add(b2);
        root_1.getChildren().add(b1);
        root_1.getChildren().add(t1);
        root_1.getChildren().add(t3);
        root_1.getChildren().add(p1);
        
       


       
		primaryStage.setTitle("MewBot.exe");  
        primaryStage.setScene(scene);    
        primaryStage.show();  
        
    }

    public static void main(String[] args) 
    {  
        launch(args);  
    }  

    
};


