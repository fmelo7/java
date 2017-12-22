import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class Functions {

	public static <T> T foo(T t) {
		return t;
	}

	public static <T> List<T> foo(List<T> t) {
		return t;
	}

	public static <T> List<T> newArrayList() {
		return new ArrayList<T>();
	}

	@SuppressWarnings("unchecked")
	public static <T extends Number> List<T> fill(List<T> list, Number start, Number end) {
		if (end.intValue() > start.intValue())
			list = fill(list, start, end.intValue() - 1);
		list.add((T) end);
		return list;
	}

	public static Function<Integer, Integer> fill = new Function<Integer, Integer>() {
		int i = 0;

		@Override
		public Integer apply(Integer t) {
			return ++i;
		}
	};

	public static Function<Integer, String> pingPongMapper = new Function<Integer, String>() {
		@Override
		public String apply(Integer t) {
			String r = t.toString();
			if (t % 3 == 0)
				r = "Ping";
			if (t % 5 == 0)
				r += "Pong";
			return String.valueOf(r);
		}
	};

	public static Function<Integer, Integer> fiboMapper = new Function<Integer, Integer>() {
		@Override
		public Integer apply(Integer t) {
			return fibo(t);
		}
	};

	public static Integer fibo(Integer num) {
		if (num == 1)
			return 0;
		if (num == 2)
			return 1;
		return fibo(num - 1) + fibo(num - 2);
	}

}
