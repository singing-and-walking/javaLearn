package multiThread;

import java.util.concurrent.atomic.AtomicInteger;

import been.User;

/*演示同步问题及解决方案*/
public class ConcurrencyProblem {
	public static void main(String[] args) throws InterruptedException {
		ConcurrencyProblem m = new ConcurrencyProblem();
		m.concurrencyProblem();
	}

	/*
	 * 展示同步运行问题 n个线程为age加一理论上最后age数值是n， 但运行此方法后，,age可能不是n。 一次可能不出现问题，运行多次看看
	 */
	// 这里使用带参构造方法初始化值，使用空构造方法时默认初始值为0
	private static AtomicInteger atoi = new AtomicInteger(0);

	public void concurrencyProblem() throws InterruptedException {
		User user = new User();
		user.setAge(0);
		int n = 10000;
		Thread[] ts = new Thread[n];
		for (int i = 0; i < n; i++) {
			// 添加一个线程
			Thread t = new Thread() {
				@Override
				public void run() {
					// 直接执行这行代码产生同步问题
//					user.setAge(user.getAge()+1);

//					//解决方案一：synchronized修饰的方法
//					user.addAge();
//					//解决方案二：synchronized(object){}代码块
//					synchronized (user) {
//						user.setAge(user.getAge()+1);
//					}
					// 解决方案三：使用java.util.concurrent.atomic包里的原子类
					atoi.incrementAndGet();
				}
			};
			ts[i] = t;
		}
		// 启动所有线程
		for (int i = 0; i < n; i++) {
			ts[i].start();
		}
		// 等待所有线程结束
		for (int i = 0; i < n; i++) {
			ts[i].join();
		}
		// 打印年龄
		System.out.println("age:" + user.getAge());
		System.out.println("atoi:" + atoi);
	}
}
