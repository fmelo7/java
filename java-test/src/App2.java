import java.util.ArrayList;
import java.util.List;

public class App2 {

	class V {
		public void drive() {
			System.out.println("v : drive");
		}
	}

	class C {
		public void drive() {
			System.out.println("c : drive");
		}
	}

	public static void main(String[] args) {

		V v;
		C c;
		v = new App2().new V();
		c = new App2().new C();
		v.drive();
		c.drive();
		//v = c;
		v.drive();
		
		List<Integer> list = new ArrayList<>();
		//list.
	}
}
