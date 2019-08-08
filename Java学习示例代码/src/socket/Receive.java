package socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	DataInputStream input;
	public Receive(Socket s) throws IOException {
		input=new DataInputStream(s.getInputStream());
	}

	@Override
	public void run() {
		while(true)
		{
			try {
				receive();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void receive() throws IOException
	{
		//ԭ�صȴ�����Ϣ����
		while(input.available()==0);
		//��ȡ��Ϣ����
		int msgType=input.readInt();
		//������Ϣ����ѡ���ȡ��ʽ����ʱֻ��Stringһ�����ͣ�ʵ��Ӧ�ÿ��Ի��ж�����ļ�
		switch(msgType)
		{
			case 0:
				String msg=input.readUTF();
				System.out.println("\t\t\t"+msg);
				break;
		}
		return;
	}
}
