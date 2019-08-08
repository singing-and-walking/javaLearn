package socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	public static void main(String[] args) throws IOException {
		Server m=new Server();
		m.startServer();
	}
	public void startServer() throws IOException
	{
		ServerSocket ss=new ServerSocket(8086);
		Socket s=ss.accept();
		System.out.println("一个客户端连接"+s);
		Thread receive=new Thread(new Receive(s));
		Thread send=new Thread(new Send(s));
		receive.start();
		send.start();
		
//		s.close();
//		ss.close();
	}
	public void showLocalHostAddress() throws UnknownHostException
	{
        InetAddress host = InetAddress.getLocalHost();
        String ip =host.getHostAddress();
        System.out.println("本机ip地址：" + ip);
	}
}
