package multiThread;

public class WaitAndNotify {
	public static void main(String[] args) throws InterruptedException {
		WaitAndNotify wn = new WaitAndNotify();
		wn.test();
	}

	static int count = 5;

	public void test() throws InterruptedException {
		
		// 作为同步对象
		Object obj = new Object();

		// 添加一个线程
		Thread t1 = new Thread("加数线程") {
			@Override
			public void run() {
				// synchronized(object){}代码块
				while (true) {
					synchronized (obj) {
						try {
							while (count < 10) {
								count++;
								System.out.println(this.getName() + "+count:" + count);
								sleep(1000);
							}
							obj.notify();
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};

		Thread t2 = new Thread("减数线程") {
			@Override
			public void run() {
				// synchronized(object){}代码块

				while (true) {
					synchronized (obj) {
						try {
							while (count > 5) {
								count--;
								System.out.println(this.getName() + "-count:" + count);
								sleep(1000);
							}
							obj.notify();
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		t1.start();
		t2.start();
	}
}
