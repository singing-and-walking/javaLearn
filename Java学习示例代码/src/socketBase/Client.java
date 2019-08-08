package socketBase;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s=new Socket("192.168.0.101",8086);
		s.getOutputStream().write('a');
	}
}
