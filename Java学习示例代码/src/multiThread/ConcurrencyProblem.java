package multiThread;

import java.util.concurrent.atomic.AtomicInteger;

import been.User;

/*��ʾͬ�����⼰�������*/
public class ConcurrencyProblem {
	public static void main(String[] args) throws InterruptedException {
		ConcurrencyProblem m = new ConcurrencyProblem();
		m.concurrencyProblem();
	}

	/*
	 * չʾͬ���������� n���߳�Ϊage��һ���������age��ֵ��n�� �����д˷�����,age���ܲ���n�� һ�ο��ܲ��������⣬���ж�ο���
	 */
	// ����ʹ�ô��ι��췽����ʼ��ֵ��ʹ�ÿչ��췽��ʱĬ�ϳ�ʼֵΪ0
	private static AtomicInteger atoi = new AtomicInteger(0);

	public void concurrencyProblem() throws InterruptedException {
		User user = new User();
		user.setAge(0);
		int n = 10000;
		Thread[] ts = new Thread[n];
		for (int i = 0; i < n; i++) {
			// ���һ���߳�
			Thread t = new Thread() {
				@Override
				public void run() {
					// ֱ��ִ�����д������ͬ������
//					user.setAge(user.getAge()+1);

//					//�������һ��synchronized���εķ���
//					user.addAge();
//					//�����������synchronized(object){}�����
//					synchronized (user) {
//						user.setAge(user.getAge()+1);
//					}
					// �����������ʹ��java.util.concurrent.atomic�����ԭ����
					atoi.incrementAndGet();
				}
			};
			ts[i] = t;
		}
		// ���������߳�
		for (int i = 0; i < n; i++) {
			ts[i].start();
		}
		// �ȴ������߳̽���
		for (int i = 0; i < n; i++) {
			ts[i].join();
		}
		// ��ӡ����
		System.out.println("age:" + user.getAge());
		System.out.println("atoi:" + atoi);
	}
}
