package MewBot;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Search
{
	static LinkedHashMap<String,String> urls;
	static ArrayList<String> youtubeTitles;
	static int count;
	static ArrayList<String> youtubeUrls;



	public Search()
	{
		urls=new LinkedHashMap<String,String>();
		youtubeTitles=new ArrayList<String>();
		youtubeUrls=new ArrayList<String>();
		count=0;
		

	}

	public void dispUrl()
	{
		Iterator itr=urls.keySet().iterator();
		Iterator itr1=urls.values().iterator();
		while(itr.hasNext() && itr1.hasNext())
		{
			System.out.println(itr.next() + " = " +itr1.next());		
		}

	}

	public ArrayList<String> top3Titles()
	{
		Iterator itr=urls.keySet().iterator();
		int title_count=0;
		while(title_count<3)
		{
			youtubeTitles.add(itr.next().toString());
			title_count++;
		
			
		}		
		return youtubeTitles;
	}

	public ArrayList<String> top3Urls()
	{
		Iterator itr=urls.values().iterator();
	
		
		int url_count=0;
		while(url_count<3)
		{
			youtubeUrls.add(itr.next().toString());
			url_count++;
					
		}		
		return youtubeUrls;
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

		
		try
		{
			if(m.find())
			{
			
				if(m1.find() && m2.find())
				{
					System.out.println("Required Url Found");
					href="https://www.youtube.com"+line.substring(m.start(),(m.start()+20));
					title=line.substring((m1.start()+8),(m2.start()-16));
					urls.put(title,href);
					flag=true;
				}

			//System.out.println(m.start()+" To "+m.end());
			}		
		}
		catch(StringIndexOutOfBoundsException f)
		{
			flag=false;
		}

		
		
		return flag;
	}

	

	public Boolean cmd_command(String para) //WORKING PROPERLY
	{
		
				String line;
				Boolean flag=false;
				try
				{
					Process process=Runtime.getRuntime().exec("curl https://www.youtube.com/results?search_query="+para+" -o urls.html");
				
					BufferedReader bri=new BufferedReader(new InputStreamReader(process.getInputStream()));
					while((line=bri.readLine())!=null)
					{
						System.out.println(line);
					}
					
					flag=true;
					System.out.println("File Created");
				}
				catch(IOException e)
				{
					System.out.println("CANNOT CREATE HTML FILE");
					flag=false;
				}		
			
			
		
		
		return true;	}

	public Boolean wipe()
	{
		Boolean flag=false;
		File file=new File("C:\\Program Files\\mewbot.exe\\src\\urls.html");
		if(file.delete())
		{
			flag=true;
		}
		return flag;
	}


	public Boolean readUrl()
	{
		String line;
		Boolean flag=false;
		Boolean openFile=false;
		int fileCount=0;
	
		while(flag!=true)
		{
			try
			{
				
				FileReader fin=new FileReader("C:\\Program Files\\mewbot.exe\\src\\urls.html");
				BufferedReader bri=new BufferedReader(fin);
				while((line=bri.readLine())!=null)
				{	
					extract(line);
					count++;
					
				}	
				flag=true;
			}
			catch(IOException e)
			{
				
				fileCount++;
				openFile=false;
				
			}						
		}		
		return flag;
	}


}