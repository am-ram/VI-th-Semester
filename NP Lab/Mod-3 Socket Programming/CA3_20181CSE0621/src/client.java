import java.net.*;
import java.io.*;

public class client {

    public static DatagramSocket ds;
    public static byte buffer[] = new byte[1024];
    public static int clientport = 1780, serverport = 1781;

    public static void main(String args[]) throws Exception {

        byte buffer[] = new byte[1024];
        ds = new DatagramSocket(clientport);
        BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

        while (true) {
        	System.out.println("Program to find area of square\n");
            System.out.println("Enter side of square : ");
            String str = breader.readLine();
            buffer = str.getBytes();
            ds.send(new DatagramPacket(buffer, str.length(), InetAddress.getLocalHost(), serverport));

            ds.receive(dp);
            String pdata = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Area of square = " + pdata+" sq.units\n");
        }
    }
}