import javafx.application.Application;  
import javafx.scene.Scene;  
import javafx.scene.control.Label;  
import javafx.scene.layout.StackPane;  
import javafx.stage.Stage;  
  
public class init extends Application {  
  
    
    
    static Label l1;
    static Label l2;

    @Override  
    public void start(Stage primaryStage) throws Exception
    {  
        // TODO Auto-generated method stub  
        l1=new Label("Welcome to MewBot");  
        StackPane root = new StackPane();   
        Scene scene=new Scene(root,300,300);  
        root.getChildren().add(l1);  
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Youtube To Mp3");  
        primaryStage.show();  
          
    }


    public static void main(String[] args) {  
        launch(args);  
    }  
}