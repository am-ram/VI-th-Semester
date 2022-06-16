import java.util.*;
import java.net.*;
import java.io.*;
public class server_datagram {
	//For server
	public static DatagramSocket ds;
	public static int clientport=3020, serverport=3021;
	
	public static void main(String[] args) throws Exception
	{
		byte buffer[] = new byte[2048];
		ds = new DatagramSocket(serverport);
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
		ds.receive(dp);
		System.out.println("Connected ...");
		String pdata = new String(dp.getData(),0,dp.getLength());
		System.out.println("Message from Client : " + pdata);
		while(true) 
		{
			System.out.println("Enter response Message : ");
			String str = breader.readLine();
			buffer = str.getBytes();
			if(str==null||str.equals("End"))
			{
				ds.send(new DatagramPacket(buffer,str.length(),InetAddress.getLocalHost(),clientport));
				break;
			}
			ds.send(new DatagramPacket(buffer,str.length(),InetAddress.getLocalHost(),clientport));
			ds.receive(dp);
			String recvdata = new String(dp.getData(),0,dp.getLength());
			System.out.println("Message from Client : "+recvdata);
		}
	}
}

