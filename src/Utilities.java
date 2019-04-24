package MewBot;


import java.io.*;



public class Utilities
{
	String Progress;
	int mesCounter;


	public void updateMes()
	{
		mesCounter=0;
	}


	public Double downloadProgress(String line)
	{
		mesCounter++;
	    Double p=0.0;
	    String sub_line;
	    String value="";
	    if(mesCounter>=5)
	    {
	        sub_line=line.substring(0,15);
	        char[] characters=sub_line.toCharArray();
	        for(char ch:characters)
	        {
	            if(ch>=48 && ch<=57)
	            {
	                value+=ch;
	            }
	        }
	            p=new Double(value);
	            p=p/100;
	        if(p==1.0)
	        {
	            mesCounter=0;
	        }
	    }   
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


