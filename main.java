import java.io.*;
import java.util.*;

// Driver class
public class main
{
		@SuppressWarnings("resource")
		public main(String[] args) throws IOException 
        {
            List list=new List();
                
                System.out.print("Enter file name: ");
                Scanner s=new Scanner(System.in);
                String file=s.next();
                // Read file 
                File f=new File(file);
                BufferedReader br=new BufferedReader(new FileReader(f));
                String l=br.readLine();
                int line=0;
                while(l!=null){// loop while text line in file is not null
                    if(l.equals(""))// if line is empty then skip it
                    {
                        l=br.readLine();
                         continue;
                    }
                    String m[]=l.split(",|\\.|\\?|\\s|!|:|;|-|a||A||an|An|AN|the||The||THE|");// split on the different delimeters as given
                    line++;
                    System.out.println(line+" "+l);
                    for(int i=0;i<m.length;i++){
                        list=list.add(list,m[i],String.valueOf(line));// add each word to linked list
                    }
                    l=br.readLine();
                }
                System.out.println();
                list.sort(list);// sort linked list
                
                // display linked list
                list.display(list);
                System.out.println("Total number of lines: "+line);
        }
}
