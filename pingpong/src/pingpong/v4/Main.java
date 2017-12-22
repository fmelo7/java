package pingpong.v4;

import static pingpong.model.PingpongEnum.PING;
import static pingpong.model.PingpongEnum.PONG;

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
	}

	private static List<PingpongVo> pingpong(List<Integer> list) {
		return list.stream()//
				.map(new Function<Integer, PingpongVo>() {
					@Override
					public PingpongVo apply(Integer n) {
						PingpongVo vo = new PingpongVo();
						vo.setNumber(n);
						if (n % 3 == 0) {
							vo.getSet().add(PING);
						}
						if (n % 5 == 0) {
							vo.getSet().add(PONG);
						}
						return vo;
					}
				})//
				.collect(Collectors.toList());
	}

	private static List<Integer> initialize(Integer number) {
		return Arrays//
				.stream(new Integer[number])//
				.map(new Function<Integer, Integer>() {
					private int i = 0;

					@Override
					public Integer apply(Integer n) {
						return ++i;
					}
				})//
				.collect(Collectors.<Integer>toList());
	}

}
