package multiThread;

import java.util.ArrayList;
import java.util.List;

public class MyThreadPool {
	int size;
	List<Runnable> tasks=new ArrayList<Runnable>();
	
	public MyThreadPool(int size) {
		this.size=size;
		
		for(int i=0;i<size;i++)
			new ConsumeThread("�߳�"+i).start();
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
				//����tasks
				synchronized(tasks)
				{
					System.out.println(this.getName()+"ռ��tasks");
						try {
							//���tasksΪ�գ����������״̬
							if(tasks.isEmpty())
							{
								System.out.println(this.getName()+"��������״̬");
								tasks.wait();
								//�����Ѻ���������ѭ����д���tasks�Ƿ�Ϊ��
								continue;
							}
							//tasks��Ϊ�գ�ȡ��һ������ʼִ��
							task=tasks.remove(0);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				//ȡ��һ��������ͷ�tasks������������synchronized(tasks)��ִ�еĻ�������ִ���ڼ䣬��������Ͳ��ܱ������߳�ȡ��ִ�С�
				if(task!=null)
					task.run();
					//����ִ�н�������������tasksִ������ֱ�������Ϊ��
			}
		}
	}
	
}
