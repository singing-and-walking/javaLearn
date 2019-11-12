//排序算法集合
package basicAlgorithm;

import java.util.Arrays;

public class SortAlgorithm {
	public static void main(String[] args) {
		SortAlgorithm sort = new SortAlgorithm();
		int scale = 1000000;
		int data[] = new int[scale];
		for (int i = 0; i < scale; i++) {
			data[i] = (int) (Math.random() * 1000);
		}
		int a[]= {1,3,3,5,7,6};
		int data2[] = Arrays.copyOf(data, scale);
		Arrays.sort(data2);

//		sort.quickSort(data, 0, scale - 1);// 快速排序
//		sort.heapSort(data);//堆排序
//		data=sort.mergeSort(data, 0, scale-1);//归并排序
//		
//		System.out.println(Arrays.equals(data, data2));
//		data[0] = -1;
//		System.out.println(Arrays.equals(data, data2));
//		System.out.println(sort.binarySearch(a,0,2,0));//二分查找
//		System.out.println(sort.BFPRT(a, 0, 5, 0));//线性查找
		sort.DFS(a,0);//深度优先搜索
	}

	void quickSort(int data[], int begin, int end) {
		if (begin >= end) {// 递归到最后的情况：剩下一个或零个元素
			return;
		}
		int i = begin;
		int j = end;
		int key = data[i];
		int index = i;
		i++;
		while (i <= j) {// 最后i要大于j
			if (index < i) {
				if (data[j] < key) {
					data[index] = data[j];
					index = j;
				}
				j--;
			} else {
				if (data[i] > key) {
					data[index] = data[i];
					index = i;
				}
				i++;
			}
		}
		data[index] = key;// 最后剩下index的位置填入key
		// 以index为界将数组分成两部分进行递归
		quickSort(data, begin, index - 1);
		quickSort(data, index + 1, end);
	}
	void heapSort(int data[])
	{
		for(int i=(data.length-2)/2;i>=0;i--)//n/2+n/4*2+n/8*3+...+2*(logn-1)+logn
		{
			adjustHeap(data,i,data.length-1);
		}
		for(int i=data.length-1;i>=0;i--)
		{
			int temp=data[i];
			data[i]=data[0];
			data[0]=temp;
			adjustHeap(data,0,i-1);
		}
	}
	void adjustHeap(int data[],int index,int end)
	{
		int key=data[index];
		int next=2*index+1;
		while(next<=end)
		{
			if(next+1<=end&&data[next+1]>data[next])
				next++;
			if(data[next]>key)
			{
				data[index]=data[next];
				index=next;
				next=2*index+1;
			}
			else
				break;
		}
		data[index]=key;
	}
	int[] mergeSort(int data[],int begin,int end)
	{
		if(begin==end)
			return new int[] {data[begin]};
		int mid=(end+begin)/2;
		return merge(mergeSort(data,begin,mid),mergeSort(data,mid+1,end));
	}
	int[] merge(int m1[],int m2[])
	{
		int data[]=new int[m1.length+m2.length];
		int i=0,j=0;
		while(i<m1.length||j<m2.length)
		{
			for(;i<m1.length&&(j==m2.length||m1[i]<=m2[j]);i++)
			{
				data[i+j]=m1[i];
			}
			for(;j<m2.length&&(i==m1.length||m2[j]<m1[i]);j++)
			{
				data[i+j]=m2[j];
			}
		}
		return data;
	}
	int binarySearch(int data[],int begin,int end,int target)
	{
		if(begin>end)
			return -1;
		int mid=(begin+end)/2;
		if(data[mid]==target)
			return mid;
		if(data[mid]>target)
			return binarySearch(data,begin,mid-1,target);
		else
			return binarySearch(data,mid+1,end,target);
	}
	int BFPRT(int[] data,int begin,int end,int order)
	{
		if(end-begin+1<=5)
		{
			quickSort(data,begin,end);
			return data[begin+order];
		}
		int index=begin;
		for(int i=begin;i+4<=end;i+=5)
		{
			quickSort(data,i,i+4);
			int temp=data[index];
			data[index]=data[i+2];
			data[i+2]=temp;
			index++;
		}
		int key=BFPRT(data,begin,index-1,(index-1-begin)/2);
		index=(index-1-begin)/2;
		int i=begin;
		int j=end;
		while(i<=j)
		{
			while(i<=j)
			{
				if(data[j]<key)
				{
					data[index]=data[j];
					index=j;
					j--;
					break;
				}
				j--;
			}
			while(i<=j)
			{
				if(data[i]>key)
				{
					data[index]=data[i];
					index=i;
					i++;
					break;
				}
				i++;
			}
		}
		if(index==order)
			return key;
		else
		{
			if(index<order)
				return BFPRT(data,index+1,end,order-index-1);
			else
				return BFPRT(data,begin,index-1,order);
		}
	}
	void DFS(int data[],int i)
	{
		if(i>=data.length)
			return;
		System.out.println(data[i]);
		DFS(data,2*i+1);
		DFS(data,2*i+2);
		
	}
}
