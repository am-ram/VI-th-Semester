import java.util.*;
import java.net.*;
public class IPFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Host Name : ");
		host = input.next();
		try {
			InetAddress address = InetAddress.getByName(host);
			System.out.println("IP address: " + address.toString());
		}
		catch (UnknownHostException uhEx)
		{
			System.out.println("Could not find " + host);
		}
		
	}

}
