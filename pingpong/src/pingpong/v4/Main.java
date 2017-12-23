package pingpong.v4;

import static pingpong.model.PingpongEnum.PING;
import static pingpong.model.PingpongEnum.PONG;
import static pingpong.model.PingpongEnum.createVo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Assert;

import pingpong.model.PingpongVo;

public class Main {

	public static void main(String[] args) {

		// arrange
		Integer number = 100;
		List<Integer> list = initialize(number);

		// act
		List<PingpongVo> list2 = pingpong(list);

		// assert
		Assert.assertTrue(list2.contains(new PingpongVo(3, PING)));
		Assert.assertTrue(list2.contains(new PingpongVo(5, PONG)));
		Assert.assertTrue(list2.contains(new PingpongVo(15, PING, PONG)));
		System.out.println("Success!");
	}

	private static List<PingpongVo> pingpong(List<Integer> list) {
		return list.stream()//
				.map(createVo)//
				.collect(Collectors.toList());
	}

	private static List<Integer> initialize(Integer number) {
		return Arrays//
				.stream(new Integer[number])//
				.map(fill)//
				.collect(Collectors.<Integer>toList());
	}

	private static Function<Integer, PingpongVo> createVo = new Function<Integer, PingpongVo>() {
		@Override
		public PingpongVo apply(Integer number) {
			return createVo(number);
		}
	};

	private static Function<Integer, Integer> fill = new Function<Integer, Integer>() {
		private int i = 0;

		@Override
		public Integer apply(Integer n) {
			return ++i;
		}
	};

}
