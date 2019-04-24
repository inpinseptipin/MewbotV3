package MewBot;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;


public class MessageBoxes
{
	


	public MessageBoxes(String h,String c,String t,int type)
	{
		if(type==0)
		{
			Alert a=new Alert(AlertType.CONFIRMATION);
			a.setHeaderText(h);
			a.setTitle(t);
			a.setContentText(c);
			a.showAndWait();	
		}

		if(type==1)
		{
			Alert a=new Alert(AlertType.ERROR);
			a.setHeaderText(h);
			a.setTitle(t);
			a.setContentText(c);
			a.showAndWait();	
		}

		if(type==2)
		{
			Alert a=new Alert(AlertType.WARNING);
			a.setHeaderText(h);
			a.setTitle(t);
			a.setContentText(c);
			a.showAndWait();	
		}

		if(type==3)
		{
			Alert a=new Alert(AlertType.NONE);
			a.setHeaderText(h);
			a.setTitle(t);
			a.setContentText(c);
			a.showAndWait();
		}
		
	}
}