package pingpong.v4;

import static pingpong.model.PingpongEnum.PING;
import static pingpong.model.PingpongEnum.PONG;
import static pingpong.model.PingpongEnum.createVo;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;

import pingpong.model.PingpongVo;
import pingpong.util.Functions;

public class Main {

	public static void main(String[] args) {

		// arrange
		Integer number = 100;
		List<Integer> list = Functions.initialize(number);

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
				.map(number -> createVo(number))//
				.collect(Collectors.toList());
	}

}
