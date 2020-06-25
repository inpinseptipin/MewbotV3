import Mewbot.urlSearcher;
import java.util.Scanner;
import java.io.*;

public class Mewbot
{
	static String searchTerm;
	
	public static void callDownloader(String chosenUrl)
	{
		String cmd="python3 Downloader.py "+chosenUrl;
		String line;
		try
		{
			
			//Process proc=new ProcessBuilder("python3 Downloader.py"+chosenUrl).start();
			Process proc=Runtime.getRuntime().exec(cmd);
			BufferedReader bri=new BufferedReader(new InputStreamReader(proc.getInputStream()));
			BufferedReader bre=new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			System.out.println("Download Started");
			while((line=bri.readLine())!=null)
			{
				System.out.println(line);
			}
			while((line=bre.readLine())!=null)
			{
				System.out.println(line);
			}		

		}
		catch(Exception e)
		{
			System.out.println("In Exception");
		}

		
	}
	public static void clearScreen()
	{
		try
		{
			Process proc=Runtime.getRuntime().exec("clear");
		}
		catch(Exception c)
		{

		}
	}

	public static void main(String[] args)
	{
		Boolean flag=true;
		while(flag)
		{
			System.out.print("\033[H\033[2J");
			System.out.println("Welcome to MEWBOT CLI   , Press n to exit");
			Scanner in=new Scanner(System.in);
			Scanner scan=new Scanner(System.in);

			int choice=1234;
			System.out.print("Enter URL/Search Term: ");
			searchTerm=in.next();
			

			urlSearcher search=new urlSearcher();
			search.wipe();
			search.runSearch(searchTerm);


			search.readResults();
			System.out.println("Choose the name by selecting its Index Number \n\n");
			search.displayResults();

			int totalResults=search.getCounter();
			
		
				System.out.print("Your Choice : ");
				choice=scan.nextInt();	
			
			
			callDownloader(search.getSong(choice));
			
			
			System.out.println("Press n and enter to exit");
			if(in.next().charAt(0)=='n')
			{
				flag=false;
			}
		}
		
	}






}