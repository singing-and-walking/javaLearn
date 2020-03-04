package test3;
import static java.lang.Math.*;
import static test.Test2.id;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

import been.User;
import test.Test2;

public class Test3 extends Test2{
	
	public <T extends Comparable> T bs(T... a) 
	{
//		T sum=null;
//		for(int i=0;i<a.length;i++)
//			sum+=a[i];
		
		System.out.println();
		System.out.println("³É¹¦"+a[1].getClass());
		return a[0];
	}

	public static void main(String[] args) throws InterruptedException {
		Test3 t3=new Test3();
		Number a=t3.bs(3.14,1729,0);
		Object obj=new Object();
		
	}
}