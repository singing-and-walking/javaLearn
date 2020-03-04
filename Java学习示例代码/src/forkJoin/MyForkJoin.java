package forkJoin;

import java.util.concurrent.RecursiveTask;

public class MyForkJoin extends  RecursiveTask<Integer>{
	int[] task;
	int begin;
	int end;
	public MyForkJoin(int[] task,int begin,int end)
	{
		this.task=task;
		this.begin=begin;
		this.end=end;
		System.out.println("begin:"+begin+"\tend:"+end);
	}
	@Override
	protected Integer compute() {
		if(end-begin==0)
		{
			return task[begin];
		}
		else
		{
			int mid=(begin+end)/2;
			MyForkJoin fk1=new MyForkJoin(task,begin,mid);
			MyForkJoin fk2=new MyForkJoin(task,mid+1,end);
			invokeAll(fk1, fk2);
			return fk1.join()+fk2.join();
		}
	}
	public static void main(String[] args) {
		int[] task= {1,2,3,4};
		MyForkJoin fk=new MyForkJoin(task,0,task.length-1);
		fk.invoke();
		System.out.println(fk.invoke());
	}
}
