/**MewBot Version 1.0 
GUI of youtube_dl python library complemented with a custom Youtube Search API
**/



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
import MewBot.MessageBoxes;
import MewBot.Search;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.*;
import javafx.scene.control.SelectionModel;

public class init extends Application
{  
  
    static Image i;
    static Text t1;
    static Text t2;
    static Label l1;
    static Button b3;
    static Button b4_Search;   
    static TextField tf2; 
    static Alert a1;
    public static Text t3;
    static ProgressBar p1;
    static long length;
    static ArrayList<String> youtubeTitles;
    static ArrayList<String> youtubeUrls;
    static Boolean downloadFlag;
    static ComboBox<String> c1;
    static Boolean downloadUrlFlag;
    static Alert downloadComplete;
    static Boolean[] programTracker;
    static Double fdown;
 
   


    public void initString()
    {
    	youtubeTitles=new ArrayList<String>();
    	youtubeUrls=new ArrayList<String>();
    	downloadFlag=false;
        downloadUrlFlag=false;
    }


    public ComboBox<String> init_ComboBox(int x,int y)
    {
    	ComboBox<String> c=new ComboBox<>();
    	c.setTranslateX(x);
    	c.setTranslateY(y);
    	return c;
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
        if(downloadFlag)
        {
            MessageBoxes m=new MessageBoxes("Success","Download Complete","",0);
        }
        else
        {
            downloadComplete=new Alert(AlertType.CONFIRMATION);
            downloadComplete.setContentText((youtubeTitles.get(c1.getSelectionModel().getSelectedIndex())+" has been Downloaded"));
            downloadComplete.showAndWait();

        }
    }    

    public String retchoiceUrl()
    {
        String url="lmao";
        int id=c1.getSelectionModel().getSelectedIndex();
        try
        {
            url=youtubeUrls.get(id);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            MessageBoxes m = new MessageBoxes("Failure","PLease add a song first","",1);
        }
        
        return url;
    }
    

    //Download V_2
    EventHandler<ActionEvent> download=new EventHandler<ActionEvent>() // Download Function
    {
    	public void handle(ActionEvent e)	
    	{
	    	new Thread()
            {
                public void run()
                {
                        Boolean flag=false;
                        if(retchoiceUrl()=="lmao")
                        {

                        }
                        else
                        {
                            if(downloadFlag==false)
                            {
                             addUrl(retchoiceUrl());
                             c1.setVisible(false);
                            }
                            Utilities util=new Utilities();
                            try
                            { 
                                       
                                String line;                                                                                   
                                Double f_down;                            
                                Process proc_1 = new ProcessBuilder("C:\\Program Files\\mewbot.exe\\build\\bin\\ripper.exe","C:\\Program Files\\mewbot.exe\\build\\bin\\music.txt").start(); 
                                BufferedReader bri=new BufferedReader(new InputStreamReader(proc_1.getInputStream()));
                                BufferedReader bre=new BufferedReader(new InputStreamReader(proc_1.getErrorStream()));
                                util.updateMes();
                                t2.setVisible(true);
                                while((line=bri.readLine())!=null)
                                {
                                    fdown=f_down=util.downloadProgress(line);
                                    t2.setText((f_down*100)+" of 100% Completed");
                                    p1.setProgress(f_down);
                                    if(f_down==1.0)
                                    {           
                                        Complete();
                                        util.popQueue();
                                    }
                                    System.out.println(line);                               
                                } 
                                util.updateMes();
                                bri.close();

                                while((line=bre.readLine())!=null)
                                {            
                                    System.out.println(line);  
                                }
                                bre.close();  
                                t2.setVisible(false);   
                            }   
                            catch (IOException f) 
                            {      
                                System.out.println("In exception");       
                            } 
                            catch(IllegalStateException h)
                            {

                            }
                        
                        Platform.runLater(new Runnable()
                        {
                            public void run()
                            {  
                                p1.setProgress(fdown);  
                                System.out.println("Here");  
                                Complete();  
                                p1.setProgress(0.0);
                                t2.setVisible(false); 
                                t2.setText("Download Complete");
                                t2.setVisible(true); 


                            }
                        });
                    }
                }
            }.start();		
                    
                    
			       	
	    }	
    };

    public Boolean clearFile()
    {
        Utilities util=new Utilities();
        Boolean flag=util.deleteQueue();
        return flag;
    }
 


    EventHandler<ActionEvent> search=new EventHandler<ActionEvent>()
    {
    	public void handle(ActionEvent e)
    	{
            Internet internet=new Internet();
            downloadFlag=internet.isUrl(tf2.getText());
            System.out.println(downloadFlag);
            if(downloadFlag)
            {
                if(internet.validUrl(tf2.getText()))
                {
                    if(addUrl(tf2.getText()))
                    {
                        MessageBoxes m = new MessageBoxes("Success","Click on Download to start Downloading","",0);         
                    }
                }
                else
                {
                    MessageBoxes m=new MessageBoxes("Error","Invalid Url","",1);       
                }
            }
            else
            {
                Utilities u=new Utilities();
                Search search=new Search();
                c1.getItems().clear();
                search.wipe();

                String searchString=tf2.getText();
                searchString=u.cleanString(searchString);
                search.cmd_command(searchString);
                //search.readUrl();
                if(search.readUrl())
                {
                    youtubeTitles=search.top3Titles();
                    youtubeUrls=search.top3Urls();
                    addCombo();
                }                
            }
            Platform.runLater(new Runnable()
                    {
                        public void run()
                        {                       
                        }
                    });    		
    	}

    };




    public void addCombo()
    {
    	ObservableList<String> d1=FXCollections.observableArrayList(youtubeTitles);
    	c1.getItems().addAll(youtubeTitles);  
        tf2.setText("");	
        c1.setVisible(true);
    }

     

       	
public Boolean addUrl(String url)
{
    Boolean flag=false;
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
        System.out.println(url);
        tf2.setText("");
        flag=true;    
    }
    catch(Exception f)
    {
                     
    }
             
    return flag;   
}        
            
   

    @Override                                                                

    public void start(Stage primaryStage) throws Exception // GUI
    {
        
        Internet internet=new Internet();
        clearFile();
        initString();
        t1=init_Text("MewBot",300,10);
        t1.setFont(Font.font("Courier New",45));
        t1.setFill(Color.web("#05ffcd"));   

        t2=init_Text("",300,200);
        t2.setFont(Font.font("Courier New",16));
        t2.setFill(Color.web("#05ffcd"));    
        
        b3=init_Button("Download",300,450);
        b3.setFont(Font.font("Bookman Old Style",FontWeight.BOLD,16));
        b3.setMaxWidth(200);

        b4_Search=init_Button("Search Song",620 ,300);
        b4_Search.setFont(Font.font("Bookman Old Style",FontWeight.BOLD,16));

     	

        tf2=init_TextField("Enter Search Criteria or Video URL",10,300,0,0);
        tf2.setFont(Font.font("Courier New",FontWeight.BOLD,16));

        p1=init_ProgressBar(100,550,600);

        c1=init_ComboBox(300,100);
        c1.setStyle("-fx-font: 12px \"Courier New\";");
        c1.setVisible(false);

        FileInputStream input = new FileInputStream("C:/Program Files/Mewbot.exe/res/BG_3.jpg");
        Image i = new Image(input);
        BackgroundImage bgi = new BackgroundImage(i,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT); 
        Background bg = new Background(bgi);     
      
                           
        GridPane root_1=new GridPane();
        Scene scene_1 = new Scene(root_1,800,600);
     
        if(internet.netCheck())
        {
            MessageBoxes m1=new MessageBoxes("Launched Successfully","Welcome to Mewbot","MEWBOT",0);
        }
        else
        {
            MessageBoxes m1=new MessageBoxes("Error Dialog","No Internet Connection","MewBot Failed to Launch",1);
            System.exit(1);
        }  

        
                           
        b3.setOnAction(download);
        b4_Search.setOnAction(search);

        root_1.setBackground(bg); 
        root_1.getChildren().add(tf2);
        root_1.getChildren().add(c1);
        root_1.getChildren().add(b4_Search);
        root_1.getChildren().add(b3);
        root_1.getChildren().add(t1);
        root_1.getChildren().add(t2);
        root_1.getChildren().add(p1);
              
		primaryStage.setTitle("MewBot.exe");  
        primaryStage.setScene(scene_1);    
        primaryStage.show();          
    }

    public static void main(String[] args) 
    {  
        launch(args);  
    }  
};


