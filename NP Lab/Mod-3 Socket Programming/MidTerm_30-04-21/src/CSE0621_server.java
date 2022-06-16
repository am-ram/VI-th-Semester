
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
class CSE0621_server
{
   public static void main(String args[ ])throws IOException
    {
     ServerSocket ss=new ServerSocket(55);
     Socket s=ss.accept();
     System.out.println("Connected"); 
     DataInputStream in=new DataInputStream(s.getInputStream());
     DataOutputStream out=new DataOutputStream(s.getOutputStream());
     DataInputStream sysin=new DataInputStream(System.in);
     while(true)
     {
      String str=in.readLine();
      System.out.println("Recieved length and breadth from client"+str);
      if(str.equals("End"))
        break;
      StringTokenizer st = new StringTokenizer(str);
      int l=Integer.parseInt(st.nextToken());
      
      int b=Integer.parseInt(st.nextToken());
      int area = l*b;
      System.out.println("Transferring result:"+area);
      out.writeBytes("Area of rectangle =  "+area+" sq.units \n");
     }
    ss.close();
    } 
}