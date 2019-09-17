import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String oriData=scan.nextLine();
		scan.close();
		List<String> subData=new ArrayList<>();
		for(int i=0,last=0;i<oriData.length();i++)
		{
			if(oriData.charAt(i)==' ')
			{
				if(last!=i)
					subData.add(oriData.substring(last,i));
				last=i+1;
			}
			if(i==oriData.length()-1)
			{
				subData.add(oriData.substring(last,i+1));
				last=i+1;
			}
		}
		Collections.reverse(subData);
		Collections.rotate(subData, 2);
		for(int i=0;i<subData.size();i++)
			System.out.print(subData.get(i)+" ");
		
	}

}
