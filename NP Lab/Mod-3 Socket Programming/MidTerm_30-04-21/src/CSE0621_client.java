import java.net.*;
import java.io.*;
public class CSE0621_client {
	public static void main(String args[])throws IOException
	   { 
	    Socket s=new Socket("localhost",55);
	    DataInputStream in=new DataInputStream(s.getInputStream());
	    DataOutputStream out=new DataOutputStream(s.getOutputStream());
	    DataInputStream sysin=new DataInputStream(System.in);
	    while(true)
	    {
	    	System.out.println("To compute area of rectangle...");	
	     System.out.println("Enter length & breadth of rectangle : ");
	     String str=sysin.readLine();
	     out.writeBytes(str+"\n");
	     
	     if(str.equals("End"))
	       break;
	     System.out.println(in.readLine()); 
	     }
	     s.close();
	    }
}
