package pingpong.v2;

import static pingpong.v1.PingpongEnum.PING;
import static pingpong.v1.PingpongEnum.PONG;

import java.util.ArrayList;
import java.util.List;

import pingpong.v1.PingpongEnum;
import pingpong.vo.PingpongVo;

public class Main {

	public static void main(String[] args) {

		// arrange
		List<PingpongVo> list = new ArrayList<>();

		// act
		for (int i = 0; i < 100; i++) {

			PingpongVo vo = new PingpongVo();
			Integer number = i + 1;
			vo.setNumber(number);
			if (number % 3 == 0) {
				vo.getSet().add(PingpongEnum.PING);
			}
			if (number % 5 == 0) {
				vo.getSet().add(PingpongEnum.PONG);
			}
			list.add(vo);
		}

		// assert
		if (!list.contains(new PingpongVo(3, PING)))
			System.err.println("Error 1");
		if (!list.contains(new PingpongVo(5, PONG)))
			System.err.println("Error 2");
		if (!list.contains(new PingpongVo(15, PING, PONG)))
			System.err.println("Error 3");
	}

}
