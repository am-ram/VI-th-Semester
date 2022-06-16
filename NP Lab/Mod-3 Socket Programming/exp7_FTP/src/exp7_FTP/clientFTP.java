package exp7_FTP;
import java.io.*;
import java.net.*;
public class clientFTP
{
	public static void main(String a[])throws IOException
	{
			Socket s=new Socket(InetAddress.getLocalHost(),5553);
			DataInputStream s1=new DataInputStream(s.getInputStream());
			DataInputStream inp=new DataInputStream(System.in);
			DataOutputStream so=new DataOutputStream(s.getOutputStream());
			System.out.println("\n enter the filename(path)");
			String str=inp.readLine();
			so.writeBytes(str+"\n");
			FileOutputStream fos=new FileOutputStream("output.txt");
			int str1;
			while((str1=s1.read())!=-1)
				fos.write((char)str1);
			System.out.println("\n file received successfully");
			s1.close();
			so.close();
			inp.close();
			s.close();
		}
}