package multiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class BuiltInThreadPool {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<FutureTask<String>> list=new ArrayList<>();
		ExecutorService threadPool = Executors.newCachedThreadPool();

		for (int i = 0; i < 5; i++) {
			Callable<String> c=new  Callable<>(){

				@Override
				public String call() throws Exception {
					// TODO Auto-generated method stub
					Thread.sleep(2000);
					System.out.println("任务被执行");
					return "yes";
				}
				
			};
			list.add((FutureTask<String>) threadPool.submit(c));
		}
		for(int i=0;i<list.size();i++)
		{
			Future<String> f=list.get(i);
			if(i%2==0)
				f.cancel(true);
			else
			{
				if(f.isCancelled())
					System.out.println(true);
				else
					System.out.println(false);
			}
				
		}
		threadPool.shutdown();
	}

}
