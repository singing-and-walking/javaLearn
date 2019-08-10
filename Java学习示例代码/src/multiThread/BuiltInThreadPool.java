package multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BuiltInThreadPool {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();

		for (int i = 0; i < 5; i++) {
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println("任务被执行");
				}
			};
			threadPool.execute(task);
		}

		threadPool.shutdown();
	}

}
