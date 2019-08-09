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
						//假设这是执行一个任务所用时间
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("\t\t\t任务执行完毕");
				}
			};
			tp.addTask(task);
		}

	}
}
