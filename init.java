import javafx.application.Application; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.canvas.*; 
import javafx.scene.web.*; 
import javafx.scene.layout.*; 
import javafx.scene.image.*; 
import java.io.*; 
import javafx.geometry.*; 
import javafx.scene.Group;  
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;  
import javafx.scene.text.FontPosture;  
import javafx.scene.text.FontWeight; 
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;  
  
public class init extends Application
{  
  
    static Image i;
    static Text t1;
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

    @Override                                                                

    public void start(Stage primaryStage) throws Exception
    {
        t1=init_Text("Welcome to MewBot",0,-275);
        t1.setFont(Font.font("Chocolate Dealer",45));
        t1.setFill(Color.RED);
               
        b1=init_Button("Click me",0,0);
        
        HBox hbox = new HBox(t1,b1);
        FileInputStream input = new FileInputStream("C:/Users/Lenovo/Desktop/MewBot.exe/background1.jpg");
        Image i = new Image(input);
        BackgroundImage bgi = new BackgroundImage(i,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT); 
        Background bg = new Background(bgi);
        hbox.setBackground(bg);

        StackPane root = new StackPane(hbox);              
        Scene scene = new Scene(root,800,600);  

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