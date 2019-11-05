package task;
import java.io.*;
import java.util.Scanner;
 
public class MyTask2
{   
    static void modifyFile(String filePath, String key, String newVals)
    {
    	FileInputStream inputStream = null;
    	FileOutputStream outstream = null;
    	Scanner sc = null;
    	try {
			inputStream = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	sc = new Scanner(inputStream, "UTF-8");
    	
    	String[] keys = sc.nextLine().split(";");
    	String[] values = sc.nextLine().split(";");
    	sc.close();
    	if(keys.length==values.length)
    	{
    		for(int i =0; i < keys.length; i++)
    		{
    			if(keys[i].equals(key))
    			{
    				values[i]= newVals;
    				try {
						outstream = new FileOutputStream(filePath);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
    				PrintStream out = new PrintStream(outstream); 
    			    out.print(String.join(";", keys));
    			    out.print("\n");
    			    out.print(String.join(";", values));
    			}
    		}
    		System.out.println(String.join(";", keys));
    		System.out.println(String.join(";", values));
    		}
    	else {
    		System.out.println("File is corrupt");
    	}
    }
     
    public static void main(String[] args)
    {
        modifyFile("/home/mikhail/eclipse-workspace/task/src/task/File.txt", "one", "9");
    }
}