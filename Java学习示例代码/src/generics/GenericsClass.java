package generics;

public class GenericsClass<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public void test(T...ts)
	{
		System.out.println(ts.length);
	}
	
	public void test2(T[] ts)
	{
		System.out.println(ts.length);
	}

	public void test3(String...strings)
	{
		System.out.println(strings.length);
	}
}
