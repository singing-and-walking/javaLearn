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
		//原地等待新消息传来
		while(input.available()==0);
		//读取消息类型
		int msgType=input.readInt();
		//根据消息类型选择读取方式，暂时只有String一种类型，实际应用可以会有对象或文件
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
