import javafx.application.Application;  
import javafx.scene.Scene;  
import javafx.scene.control.Label;  
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;  
import javafx.stage.Stage;  
  
public class init extends Application {  
  
    
    static Label l1;
    static Label l2;
    

    public Label init_Label(String title,int x,int y)
    {
        Label l=new Label(title);
        l.setTranslateX(x);
        l.setTranslateY(y);
        return l;
    }


    @Override  
    public void start(Stage primaryStage) throws Exception
    {  
              

        l1=init_Label("AyyLmao",0,-275);
        l1.setFont(new Font("Arial", 30));  

        StackPane root = new StackPane();  


        Scene scene=new Scene(root,800,600);  

        root.getChildren().add(l1);  
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Youtube To Mp3");  
        primaryStage.show();  
          
    }





    public static void main(String[] args) {  
        launch(args);  
    }  
}