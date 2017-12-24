import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DesignPatterns {

	// around methods
	public static void main(String... args) {

		// Resource resource = new Resource();
		// try {
		// resource.op1();
		// resource.op2();
		// } finally {
		// resource.close();
		// }
		// easy to forget close ++
		// exception
		// verbose

		// try (Resource resource = new Resource()) {
		// resource.op1();
		// resource.op2();
		// }
		Resource.use(1, resource -> resource.op1().op2());

	}

	// cascade methods
	public static void mainCascade(String... args) {

		// Mailer mailer = new Mailer();
		// mailer.from("builder@agiledeveloper.com");
		// mailer.to("fmelo@gmail.com");
		// mailer.subject("your code sucks!");
		// mailer.body(".. here you go ...");
		// mailer.send();
		// ---
		Mailer.send(mailer -> mailer.from("builder@agiledeveloper.com")//
				.to("fmelo@gmail.com")//
				.subject("your code sucks!")//
				.body(".. here you go ..."));//
	}

	// decorator
	public static void mainDecorator(String... args) {

		Function<Integer, Integer> inc = e -> e + 1;
		Function<Integer, Integer> doubleIt = e -> e * 2;

		doWork(5, inc);
		doWork(5, doubleIt);
		doWork(5, inc.andThen(doubleIt));
		// ---

		printSnap(new Camera());
		printSnap(new Camera(Color::brighter));
		printSnap(new Camera(Color::darker));
		printSnap(new Camera(Color::brighter, Color::darker));
	}

	public static void printSnap(Camera camera) {
		System.out.println(camera.snap(new Color(125, 125, 125)));
	}

	public static void doWork(int value, Function<Integer, Integer> func) {
		System.out.println(func.apply(value));
	}

	// strategy
	public static void mainStrategy(String... args) {

		List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// number.forEach(System.out::println);

		// total all values
		System.out.println(totalValue(number, e -> true));
		// total even values
		// System.out.println(totalValue(number, e -> e % 2 == 0));
		System.out.println(totalValue(number, Util::isEven));
		// total odd values
		// System.out.println(totalValue(number, e -> e % 2 != 0));
		System.out.println(totalValue(number, Util::isOdd));
	}

	private static int totalValue(List<Integer> number, Predicate<Integer> selector) {
		// int result = 0;
		// for (int e : number) {
		// result += e;
		// }
		// return result;
		// return number.stream().filter(selector).reduce(0, Integer::sum);
		return number.stream().filter(selector).mapToInt(e -> e).sum();
	}

}

// around methods
class Resource {

	private Resource(Integer number) {
		System.out.println("createed...");
	}

	public Resource op1() {
		System.out.println("op1...");
		return this;
	}

	public Resource op2() {
		System.out.println("op2...");
		return this;
	}

	// public void finalize() {
	// System.out.println("cleanup...");
	// }
	private void close() {
		System.out.println("cleanup...");
	}

	public static void use(Integer number, Consumer<Resource> block) {
		Resource resource = new Resource(number);
		try {
			block.accept(resource);
		} finally {
			resource.close();
		}
	}
}

// cascade methods
class Mailer {

	public static void print(String msg) {
		System.out.println(msg);
	}

	public Mailer from(String addr) {
		print("from: " + addr);
		return this;
	}

	public Mailer to(String addr) {
		print("to: " + addr);
		return this;
	}

	public Mailer subject(String line) {
		print("line: " + line);
		return this;
	}

	public Mailer body(String msg) {
		print("body: " + msg);
		return this;
	}

	public void send() {
		print("sending...");
	}

	public static void send(Consumer<Mailer> block) {
		Mailer mailer = new Mailer();
		block.accept(mailer);
		print("sending...");
	}
}

class Camera {
	private Function<Color, Color> filter;

	public Camera(Function<Color, Color>... filters) {
		setFilters(filters);
	}

	private void setFilters(Function<Color, Color>... filters) {
		filter = Stream.of(filters)//
				// .reduce(color -> color, (theFilters, aFilter) ->
				// theFilters.andThen(aFilter));
				// .reduce(Function.identity(), (theFilters, aFilter) ->
				// theFilters.andThen(aFilter));
				.reduce(Function.identity(), Function::andThen);
	}

	public Color snap(Color input) {
		return filter.apply(input);
	}
}

// strategy
class Util {
	public static boolean isEven(int number) {
		return number % 2 == 0;
	}

	public static boolean isOdd(int number) {
		return number % 2 != 0;
	}
}
