import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		List<Integer> data=new ArrayList<>();
		for(int i=0;i<N;i++)
		{
			data.add(scan.nextInt());
		}
		int count=0;
		List<Integer> target=new ArrayList<>(data);
		target.sort(null);
		
		
		for(int i=0;i<data.size();i++)
		{
			int temp=target.get(i);
			if(data.indexOf(temp)<i)
				count++;
		}
		System.out.println(count);
		scan.close();
	}
	
}
