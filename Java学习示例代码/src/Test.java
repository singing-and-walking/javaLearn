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
			//��%������ȡ��������/������ȡ��
			int a=number%10;//a��ÿһλ����
			indiv=indiv*10+a;//���㷴�����
			n++;//λ����һ
			number=number/10;//ÿ��ѭ��number��ȥ�����һ������ֱ��Ϊ0
			//���������a
		}
		//���λ��n
		//�������indiv
	}

}
