package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) {
		try {
			DatagramSocket socket=new DatagramSocket(8088);
			System.out.println("����������8088�˿�");
			DatagramPacket packet=new DatagramPacket(new byte[1],1);
			socket.receive(packet);
			System.out.println("�������յ�һ����Ϣ"+new String(packet.getData()));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
