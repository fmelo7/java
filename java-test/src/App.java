import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List p = new ArrayList<>();
		p.add(7);
		p.add(5);
		p.add(1);
		p.remove(1);
		System.out.println(p);

		int speed = 8;
		int weight = 2;

		++speed;
		weight++;
		int walkrate = speed * weight;
		System.out.println(walkrate);
	}

}
