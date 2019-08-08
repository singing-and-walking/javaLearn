package socketBase;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(8086);
		Socket s=ss.accept();
		System.out.println("一个客户端连接"+s);
		int msg=s.getInputStream().read();
		System.out.println((char)msg);
	}

	public void showLocalHostAddress() throws UnknownHostException
	{
        InetAddress host = InetAddress.getLocalHost();
        String ip =host.getHostAddress();
        //或取本机ip，客户端连接服务器时要用的
        System.out.println("本机ip地址：" + ip);
	}
}
