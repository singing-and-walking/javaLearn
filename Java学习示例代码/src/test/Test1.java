package test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test1 {
	public static void main(String[] args)  {
		Test1 t=new Test1();
				t.Power(61, 67);
		
	}
    public  double Power(double base, int exponent) {
        if(exponent==0)
			return 1;
		if(base==0)
			return 0;
        if(exponent<0)
        {
            base=1/base;
            exponent=0-exponent;
        }
        
        return powerTool(base,exponent);
         
    }
    private  double powerTool(double base,int exp)
    {
        if(exp==1)
			return base;
        double midAns=powerTool(base,exp>>1);
        if((exp&1)==1)
        {
        	return midAns*midAns*base;
        }
        else
        {
        	return midAns*midAns;
        }
    }
}
