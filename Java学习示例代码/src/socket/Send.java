package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Send implements Runnable{
	DataOutputStream output;
	public Send(Socket s) throws IOException {
		output=new DataOutputStream(s.getOutputStream());
	}
	@Override
	public void run() {
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			String msg=scan.nextLine();
			try {
				sendString(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void sendString(String msg) throws IOException
	{	
		//判断消息是否为空
		if(msg.length()!=0)
		{
			output.writeInt(0);
			output.writeUTF(msg);
		}
	}

}
