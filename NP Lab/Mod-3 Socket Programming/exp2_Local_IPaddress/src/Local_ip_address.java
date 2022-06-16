import java.util.*;
import java.net.*;
public class Local_ip_address
{
	public static void main(String[] args)
	{		
		try
		{
			InetAddress address =InetAddress.getLocalHost();
		System.out.println("Your IP address is ==> " + address);
		}
		catch (UnknownHostException uhEx)
		{
		System.out.println("Could not find local address!");
		}
	}
}