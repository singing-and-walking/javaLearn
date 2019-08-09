package multiThread;

public class MyThreadPoolTest {
	public static void main(String[] args) {
		MyThreadPool tp=new MyThreadPool(5 );
		for(int i=0;i<100;i++)
		{
			Runnable task=new Runnable() {
				@Override
				public void run() {
					try {
						//��������ִ��һ����������ʱ��
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("\t\t\t����ִ�����");
				}
			};
			tp.addTask(task);
		}

	}
}
