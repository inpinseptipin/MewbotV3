import javafx.application.Application;  
import javafx.scene.Scene;  
import javafx.scene.control.Label;  
import javafx.scene.layout.StackPane;  
import javafx.stage.Stage;  

class sid
{
    @Override  
    public static void main(String[] args)
 {
  Stage primaryStage = new Stage(); 
  Label l = new Label("Welcome to Mew Bot");  
  StackPane root = new StackPane();   
  Scene s = new Scene(root,300,300);  
  root.getChildren().add(l);
  primaryStage.setScene(s);  
  primaryStage.setTitle("Youtube to Mp3");  
  primaryStage.show(); 
 }
}
