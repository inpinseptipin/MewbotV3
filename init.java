import javafx.application.Application;
import javafx.scene.Group;  
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow; 
import javafx.scene.effect.Shadow;  
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;  
  
public class init extends Application
{  
  
    
    static Label l1;
    static Button b1;    

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
        DropShadow dropShadow = new DropShadow();
        String style =  "-fx-background-color:black;" +
                "-fx-background-radius:10;" +
                "-fx-font: 16px \"Microsoft YaHei\";" +
                "-fx-text-fill:white;-fx-padding:10;";
        l1=init_Label("Welcome to Mewbot",0,-275);
        l1.setStyle(style);
        dropShadow.setBlurType(BlurType.THREE_PASS_BOX);
        dropShadow.setWidth(40);
        dropShadow.setHeight(40);
        dropShadow.setRadius(19.5);
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(00);
        dropShadow.setColor(Color.color(0, 0, 0));
        l1.setEffect(dropShadow);  
        
        b1=init_Button("Click me",0,0);

        l1.setFont(new Font("Comic Sans MS", 30)); 



        StackPane root = new StackPane();  


        Scene scene=new Scene(root,800,600);  

        root.getChildren().add(l1);
        root.getChildren().add(b1);  
        primaryStage.setScene(scene);  
        primaryStage.setTitle("MewBot.exe");  
        primaryStage.show();  
    }



    public static void main(String[] args) 
    {  
        launch(args);  
    }  
}