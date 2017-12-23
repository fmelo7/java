package pingpong.util;

import java.util.function.Function;

public interface Functions {

	public static Function<Integer, Integer> fill = new Function<Integer, Integer>() {
		private int i = 0;

		@Override
		public Integer apply(Integer n) {
			return ++i;
		}
	};
}
