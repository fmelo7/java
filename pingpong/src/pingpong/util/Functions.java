package pingpong.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Functions {

	public static Function<Integer, Integer> fill = new Function<Integer, Integer>() {
		private int i = 0;

		@Override
		public Integer apply(Integer n) {
			return ++i;
		}
	};

	public static List<Integer> initialize(Integer number) {
		return Arrays//
				.stream(new Integer[number])//
				.map(Functions.fill)//
				.collect(Collectors.<Integer>toList());
	}
}
