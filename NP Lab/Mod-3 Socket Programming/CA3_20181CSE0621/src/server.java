import java.net.*;

public class server {

    public static DatagramSocket ds;
    public static int clientport = 1780, serverport = 1781;

    public static void main(String args[]) throws Exception {
        byte buffer[] = new byte[1024];
        ds = new DatagramSocket(serverport);
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

        while (true) {

            ds.receive(dp);
            String recvdata = new String(dp.getData(), 0, dp.getLength());
            System.out.println("[Server] Received Data from Client");
            String rh[] = recvdata.split(" ");
            double area = ((Double.parseDouble(rh[0]) * Double.parseDouble(rh[0])));
            String str = String.valueOf(area);
            buffer = str.getBytes();
            ds.send(new DatagramPacket(buffer, str.length(), InetAddress.getLocalHost(), clientport));
            System.out.println("[Server] Data sent to Client");
        }
    }
}