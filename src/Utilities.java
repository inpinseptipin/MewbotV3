package MewBot;


import java.io.*;
import java.util.regex.*;



public class Utilities
{
	String Progress;
	int mesCounter;
	static int substringEnd;


	public void updateMes()
	{
		mesCounter=0;
	}

	public Utilities()
	{
		substringEnd=17;
	}

	public Double downloadProgress(String line)
	{
		mesCounter++;
		Pattern pattern=Pattern.compile(" of");
		Matcher m=pattern.matcher(line);
		Double p=0.0;
	    String sub_line="lel";
	    String value="";
	    Boolean flag=false;
	    if(mesCounter>=5)
	    {
	    	if(m.find())
			{	
				sub_line=line.substring(0,m.start()-1);
				char[] characters=sub_line.toCharArray();
				for(char ch:characters)
				{
					if(ch>=48 && ch<=57)
					{
						value+=ch;
					}
				}
				p=new Double(value);
				p=p/1000;
		
				if(p==1.0)
				{
					mesCounter=0;
				}
			}	
	    }
		
		

	    
	    /*if(mesCounter>=5)
	    {
	    	while(flag==false)
	    	{
	    		try
	    		{
	    			sub_line=line.substring(0,substringEnd);
	    			flag=true;	
	    		}
	    		catch(StringIndexOutOfBoundsException f)
	    		{
	    			substringEnd--;
	    			flag=false;
	    		}	
	    	}
	        char[] characters=sub_line.toCharArray();
	        for(char ch:characters)
	        {
	            if(ch>=48 && ch<=57)
	            {
	                value+=ch;
	                System.out.println(ch);
	            }
	        }
	            p=new Double(value);
	            p=p/100;
	        if(p==1.0)
	        {
	            mesCounter=0;
	        }
	    } 
	    */  
	    return p; 
	}


	public Boolean deleteQueue()
	{
		Boolean flag=false;
    	File file=new File("C:\\Program Files\\mewbot.exe\\build\\bin\\music.txt");
		if(file.delete())
		{
			try
			{
				System.out.println("File Successfully Deleted");
				PrintWriter writer=new PrintWriter("C:\\Program Files\\mewbot.exe\\build\\bin\\music.txt");
				writer.close();		
				flag=true;	
			}
			catch(IOException g)
			{
				flag=false;
			}
			
		}
		else
		{
			System.out.println("File Failed to Delete");
            flag=false;
		}	
		return flag;		

	}

	public Boolean popQueue()
    {
    	Boolean flag=false;
        try
        {
            
            RandomAccessFile in = new RandomAccessFile("C:\\Program Files\\mewbot.exe\\build\\bin\\music.txt", "rw");                                                      
            long writePosition = in.getFilePointer();                            
            in.readLine();                                                                                    
            long readPosition = in.getFilePointer();                             

            byte[] buff = new byte[1024];                                         
            int n;                                                                
            while (-1 != (n = in.read(buff))) 
            {                                  
                in.seek(writePosition);                                          
                in.write(buff, 0, n);                                            
                readPosition += n;                                                
                writePosition += n;                                               
                in.seek(readPosition);                                           
            }                                                                     
            in.setLength(writePosition);                                         
            in.close();  
            flag=true;
        }
        catch(Exception e)
        {
            flag=false;
            //e.printStackTrace();
        }
        return flag;
    }

    public String cleanString(String search)
    {
    	int count=1;
    	for(int i=0;i<search.length();i++)
    	{
    		if(search.charAt(i)==32)
    		{
    			count++;
    		}
    	}
    	String cString[]=search.split(" ",count);
    	search=String.join("+",cString);
    	return search;
    }
}


