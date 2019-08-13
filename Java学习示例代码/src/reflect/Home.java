package reflect;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

import been.User;

public class Home {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<User> c=User.class;
		System.out.println(c);
		Method[] ms=c.getDeclaredMethods();
		for(Method m:ms)
		{
			System.out.print(m.getReturnType()+" "+m.getName()+"(");
			Type[] ts=m.getGenericParameterTypes();
			for(Type t:ts)
			{
				System.out.print(t.getTypeName()+",");
			}
			
			System.out.println(")");
		}
	}
}
