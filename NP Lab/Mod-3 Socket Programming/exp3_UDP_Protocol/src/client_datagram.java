import java.util.*;
import java.net.*;
import java.io.*;
public class client_datagram {
	public static DatagramSocket ds;
	public static int clientport=3020, serverport=3021;
	
	public static void main(String[] args) throws Exception
	{
		byte buffer[] = new byte[2048];
		ds = new DatagramSocket(clientport);
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Message : ");
		String msg=breader.readLine();
		buffer=msg.getBytes();
		ds.send(new DatagramPacket(buffer,msg.length(),InetAddress.getLocalHost(),serverport));		
		
		while(true) 
		{
			DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
			ds.receive(dp);
			String recvdata = new String(dp.getData(),0,dp.getLength());
			if(recvdata.equals("End"))
				break;

			System.out.println("Message from Server : "+recvdata);
			String str = breader.readLine();
			buffer = str.getBytes();
			ds.send(new DatagramPacket(buffer,str.length(),InetAddress.getLocalHost(),serverport));
		}
	}
}