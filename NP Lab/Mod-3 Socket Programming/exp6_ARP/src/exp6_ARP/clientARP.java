package exp6_ARP;
import java.io.*;
import java.net.*;
class clientARP
{
	public static void main(String args[])throws IOException
	{
		Socket s=new Socket("localhost",54);
		DataInputStream in=new DataInputStream(s.getInputStream());
		DataOutputStream out=new DataOutputStream(s.getOutputStream());
		DataInputStream sysin=new DataInputStream(System.in);
		System.out.println("Enter an IP Address:");
		String str=sysin.readLine();
		out.writeBytes(str+"\n");
		System.out.println("The corresponding MAC address \n"+in.readLine());
	}
}