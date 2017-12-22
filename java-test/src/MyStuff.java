
public class MyStuff {

	String name;

	public MyStuff(String n) {
		name = n;
	}

	public static void main(String[] args) {
		MyStuff m1 = new MyStuff("guitar");
		MyStuff m2 = new MyStuff("tv");
		System.out.println(m1.equals(m2));
	}

	public boolean equals(Object o) {
		MyStuff m = (MyStuff) o;
		if (m.name != null) {
			return true;
		}
		return false;
	}

}
