package socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client=new Client();
		client.startClient();
	}
	public void startClient() throws UnknownHostException, IOException
	{
		Socket s=new Socket("192.168.0.101",8086);
		Thread receive=new Thread(new Receive(s));
		Thread send=new Thread(new Send(s));
		receive.start();
		send.start();
//		s.close();
	}
}
