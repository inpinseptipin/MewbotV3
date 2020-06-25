package Mewbot;

import java.util.*;
import java.io.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class urlSearcher
{
	static LinkedHashMap<String,String> results;
	static LinkedHashMap<Integer,String> resultChoice;
	static int counter;

	public int getCounter()
	{
		return counter;
	}
	public void displayResults()
	{

	
		Iterator itr=results.keySet().iterator();
		Iterator itr1=results.values().iterator();
		while(itr.hasNext() && itr1.hasNext())
		{
			String name=itr.next().toString();
			resultChoice.put(++counter,name);
			System.out.println(counter+") "+name);		
		}
	}

	public String getSong(int choice)
	{
		Iterator itr=results.values().iterator();
		String name=resultChoice.get(choice).toString();
		String url=results.get(name).toString();
		
		
		return url;
	}
	public urlSearcher()
	{
		results=new LinkedHashMap<String,String>();
		resultChoice=new LinkedHashMap<Integer,String>();
		counter=0;
	}

	public Boolean runSearch(String searchTerm)
	{
		
		Boolean flag=false;
		String line;
		try
		{
			String resultReader=null;
			Process process=Runtime.getRuntime().exec("curl https://www.youtube.com/results?search_query="+searchTerm+" -o Results.html");
			BufferedReader bri=new BufferedReader(new InputStreamReader(process.getInputStream()));
			while((line=bri.readLine())!=null)
			{
				System.out.println("SEARCHING");
			}
			flag=true;
			System.out.println("Search Complete");
		}
		catch(IOException e)
		{
			System.out.println("Search Failed");
			flag=false;
		}
		return flag;
	}	


	public Boolean readResults()
	{
		String resultReader;
		Boolean flag=false;
		int count=0;
		System.out.println("Printing Results");
		while(flag!=true)
		{
			try
			{
				
				FileReader fin=new FileReader("Results.html");
				BufferedReader bri=new BufferedReader(fin);
				while((resultReader=bri.readLine())!=null)
				{	
					extract(resultReader);
					count++;
				}	
				flag=true;
			}
			catch(IOException e)
			{
				if(count==0)
				{
					System.out.println("Cannot Read Results");
					System.exit(1);
					count=1;	
				}
				
			}						
		}		
		return flag;
	}


	public Boolean extract(String line)
	{
		String href;
		String title;
		Pattern pattern=Pattern.compile("/watch*");
		Pattern pa1=Pattern.compile("  title=*");
		Pattern pa2=Pattern.compile("aria=*");
		Matcher m=pattern.matcher(line);
		Matcher m1=pa1.matcher(line);
		Matcher m2=pa2.matcher(line);
		Boolean flag=false;
		int count=0;
		try
		{
			if(m.find())
			{
			
				if(m1.find() && m2.find())
				{
					
					href="https://www.youtube.com"+line.substring(m.start(),(m.start()+20));
					title=line.substring((m1.start()+8),(m2.start()-16));
					results.put(title,href);
					count++;
					
				}
			//System.out.println(m.start()+" To "+m.end());
			}
					
		}
		catch(StringIndexOutOfBoundsException f)
		{
			System.out.println("Please try again");
		}
		return flag;
	}	

	public Boolean wipe()
	{
		Boolean flag=false;
		File file=new File("Results.html");
		if(file.delete())
		{
			flag=true;
		}
		return flag;
	}

}			
		
	