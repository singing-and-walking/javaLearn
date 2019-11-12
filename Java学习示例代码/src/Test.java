import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int number=1345;
		
		int n=0;
		int indiv=0;
		while(number>0)
		{
			//‘%’运算取余数，‘/’运行取商
			int a=number%10;//a是每一位的数
			indiv=indiv*10+a;//计算反序的数
			n++;//位数加一
			number=number/10;//每次循序number就去掉最后一个数，直到为0
			//在这里输出a
		}
		//输出位数n
		//输出反序indiv
	}

}
