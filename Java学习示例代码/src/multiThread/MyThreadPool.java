package multiThread;

import java.util.ArrayList;
import java.util.List;

public class MyThreadPool {
	int size;
	List<Runnable> tasks=new ArrayList<Runnable>();
	
	public MyThreadPool(int size) {
		this.size=size;
		
		for(int i=0;i<size;i++)
			new ConsumeThread("线程"+i).start();
	}
	
	public void addTask(Runnable task)
	{
		synchronized(tasks)
		{
			tasks.add(task);
			tasks.notify();
		}
	}
	
	private class ConsumeThread extends Thread{
		public ConsumeThread(String name) {
			super(name);
		}
		@Override
		public void run() {
			while(true)
			{
				Runnable task = null;
				//竞争tasks
				synchronized(tasks)
				{
					System.out.println(this.getName()+"占有tasks");
						try {
							//如果tasks为空，则进入休眠状态
							if(tasks.isEmpty())
							{
								System.out.println(this.getName()+"进入休眠状态");
								tasks.wait();
								//被唤醒后跳出这轮循环重写检测tasks是否为空
								continue;
							}
							//tasks不为空，取出一个任务开始执行
							task=tasks.remove(0);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				//取出一个任务就释放tasks，否则任务在synchronized(tasks)内执行的话，任务执行期间，其他任务就不能被其他线程取出执行。
				if(task!=null)
					task.run();
					//任务执行结束，继续竞争tasks执行任务直到任务池为空
			}
		}
	}
	
}
