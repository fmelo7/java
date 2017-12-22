import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Functional {

	public static void main(String[] args) {

		pingPongTest();
		fibonacciStreamJava7Test();
		fibonacciListTest();
		calculate();
	}

	public static void pingPongTest() {

		// Integer i = Functions.foo(100);
		// List<Integer> l = Functions.foo(new ArrayList<Integer>());

		// fill array
		// ping & pong
		List<Integer> list = Arrays.stream(new Integer[100]).map(Functions.fill).collect(Collectors.<Integer>toList());
		// List<Integer> list = Functions.fill(Functions.<Integer>newArrayList(), 1,
		// 100);
		List<String> pingPong = pingPong(list);

		// assert fill array
		System.out.println(list);
		String expected1 = "^\\[1, 2, 3,.*98, 99, 100\\]$";
		boolean matches = Functions.fill(list, 1, 100).toString().matches(expected1);
		System.out.println(matches);
		assertTrue(matches);

		// assert ping & pong
		System.out.println(pingPong);
		String expected2 = "^\\[1, 2, 3Ping, 4, 5Pong, 6Ping, 7, 8, 9Ping, 10Pong, 11, 12Ping, 13, 14, 15PingPong.*98, Ping, Pong\\]$";
		boolean matches2 = pingPong.toString().matches(expected2);
		System.out.println(matches2);
		assertTrue(matches2);
	}

	private static List<String> pingPong(List<Integer> list) {
		return Arrays.stream(list.toArray(new Integer[] {})).map(Functions.pingPongMapper)
				.collect(Collectors.<String>toList());
	}

	public static void fibonacciStreamJava7Test() {

		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

		Stream<Integer> stream = Arrays.stream(list.toArray(new Integer[] {}));

		List<Integer> actual = stream.map(Functions.fiboMapper).collect(Collectors.<Integer>toList());

		List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5));
		assertEquals(expected, actual);
		System.out.println("Sucesso! " + expected + ", " + actual);
	}

	public static void fibonacciListTest() {

		// Arrange
		Integer num = 5;

		// Act
		List<Integer> actual = fiboList(num);

		// Assert
		List<Integer> expected = Arrays.asList(0, 1, 1, 2, 3);
		assertEquals(expected, actual);
		System.out.println("Sucesso! " + expected + ", " + actual);
	}

	private static List<Integer> fiboList(Integer num) {
		List<Integer> list = new ArrayList<>();
		if (num > 1)
			list.addAll(fiboList(num - 1));
		list.add(fibo(num));
		return list;
	}

	private static Integer fibo(Integer num) {
		if (num == 1)
			return 0;
		if (num == 2)
			return 1;
		return fibo(num - 1) + fibo(num - 2);
	}

	public static void calculate() {

		// Arrange
		List<Integer> list = Arrays.asList(1, 2, 3);

		// Act
		List<Integer> actual = calc(list);

		// Assert
		List<Integer> expected = Arrays.asList(2, 4, 6);
		assertEquals(expected, actual);
		System.out.println("Sucesso! " + expected + ", " + actual);
	}

	private static List<Integer> calc(List<Integer> list) {
		Integer[] array = list.toArray(new Integer[] {});
		Function<Integer, Integer> doubleMapper = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t * 2;
			}
		};
		Collector<Integer, ?, List<Integer>> collector = Collectors.toList();
		return Arrays.stream(array).map(doubleMapper).collect(collector);
	}
}
