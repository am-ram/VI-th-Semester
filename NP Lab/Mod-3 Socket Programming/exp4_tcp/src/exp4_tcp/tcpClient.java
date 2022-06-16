package exp4_tcp;
import java.util.*;
import java.net.*;
import java.io.*;
public class tcpClient {
	public static void main (String []  args)throws IOException {
		//System.out.println("HI from client");
		
		Socket s=new Socket("localhost",54);
		DataInputStream in=new DataInputStream(s.getInputStream());
		DataOutputStream out=new DataOutputStream(s.getOutputStream());
		DataInputStream sysin=new DataInputStream(System.in);
		while(true)
		{
		String str=in.readLine();
		System.out.println("Message from server : "+str);
		if(str.equals("End"))
		break;
		System.out.println("Enter reply message : ");
		String line=sysin.readLine();
		out.writeBytes(line+"\n");
		}
		s.close();
	}
}
