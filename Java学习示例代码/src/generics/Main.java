package generics;

public class Main {
	public static void main(String[] args) {
		GenericsClass<String> gc=new GenericsClass<>();
		gc.setT("123");
		System.out.println(gc.getT());
	}
}
