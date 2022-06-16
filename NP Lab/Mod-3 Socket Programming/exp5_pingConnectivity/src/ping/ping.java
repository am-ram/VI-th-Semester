package ping;
import java.net.*;
import java.io.*;
import java.util.*;
public class ping
{
public static void main(String[] args)throws IOException
{
	String host="";
	Scanner input = new Scanner(System.in);
	System.out.print("\n\nEnter host name: ");
	host = input.next();
	try
	{
		InetAddress address = InetAddress.getByName(host);
		System.out.println("IP address: " + address.toString());
		System.out.println("Sending Ping Request to " + host);
		if (address.isReachable(5000))
			System.out.println(host + " is reachable.");
		else
			System.out.println(host + " NOT reachable.");
	}
	catch (UnknownHostException uhEx)
	{
		System.out.println("Could not find " + host);
	}
  }
}