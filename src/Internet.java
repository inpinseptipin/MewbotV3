package MewBot;

import java.net.*;
import java.util.regex.*;
import java.io.IOException;



public class Internet
{
	String defaultUrl;

	public Internet()
	{
		defaultUrl="https://www.google.com/";
	}


	

	public Boolean netCheck()
	{
		Boolean flag=false;
		try
		{
			URL url1=new URL(defaultUrl);
			URLConnection connection=url1.openConnection();
			connection.connect();
			flag=true;
		}
		catch(IOException e)
        {
            flag=false;
        }  
        catch(NullPointerException f)
        {
            flag=false;
        } 

        return flag;
	}

	public Boolean validUrl(String url)
	{
		Boolean flag=false;
		Pattern youtube=Pattern.compile("www.youtube.com");
		Matcher m= youtube.matcher(url);
		if(m.find())
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		
		try
		{
			URL url1=new URL(url);
			URLConnection connection=url1.openConnection();
			connection.connect();
			flag=true;
		}	
		catch(IOException e)
		{
			flag=false;
		}
		catch(NullPointerException f)
		{
			flag=false;
		}

		return flag;
	}

	public Boolean isUrl(String line)
	{
		Boolean flag=false;
		Pattern pattern=Pattern.compile("www.*");
		Matcher m=pattern.matcher(line);
		if(m.find())
		{
			flag=true;
		}
		return flag;
	}




};