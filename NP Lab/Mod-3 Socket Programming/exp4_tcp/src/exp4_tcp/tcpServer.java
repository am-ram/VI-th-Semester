package exp4_tcp;
import java.util.*;
import java.net.*;
import java.io.*;
public class tcpServer {
	public static void main (String []  args)throws IOException {
		//System.out.println("HI from server");
		ServerSocket ss=new ServerSocket(54);
		Socket s=ss.accept();
		System.out.println("Server Connected....");
		DataInputStream in=new DataInputStream(s.getInputStream());
		DataOutputStream out=new DataOutputStream(s.getOutputStream());
		DataInputStream sysin=new DataInputStream(System.in);
		while(true)
		{
		//System.out.println("Enter a string :");
		System.out.println("Enter length and breadth :");	
		String str=sysin.readLine();
		out.writeBytes(str+"\n");
		if(str.equals("End")) break;
		System.out.println("Message from client : "+in.readLine());
		}
		ss.close();
	}
}
