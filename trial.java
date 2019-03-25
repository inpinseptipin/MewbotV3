import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


 
class test
{
    public static void run_script()
    {
        Boolean flag=true;
        try
        { 
            // Command to create an external process 
            String[] command = {"ripper.exe","music.txt"};
            
  
            // Running the above command 
            

            Runtime run  = Runtime.getRuntime(); 
            Process proc = run.exec(command); 
            
            InputStream is=proc.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);

            String line =new String();
            while((line=br.readLine())!=null)
            {
                System.out.println(line);
                System.out.println("adad");
            }

        } 
  
        catch (IOException e) 
        { 
            e.printStackTrace(); 
            System.out.println("In exception");
            flag=false;
        } 
    }    
    public static void main(String[] args)
    {
        run_script();
    }
}