package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
	public static void main(String[] args) {
		try {
			DatagramSocket socket=new DatagramSocket();
			byte[] data="123".getBytes();
			DatagramPacket packet=new DatagramPacket(data,data.length,InetAddress.getLocalHost(),8088);
			socket.send(packet);
			System.out.println("�ͻ��˷���һ����Ϣ");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
