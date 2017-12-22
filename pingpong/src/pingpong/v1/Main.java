package pingpong.v1;

import java.util.ArrayList;
import java.util.List;

import pingpong.v1.vo.PingpongVo;

public class Main {

	public static void main(String[] args) {

		List<PingpongVo> list = new ArrayList<>();

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

		for (PingpongVo vo : list) {

			System.out.println(vo.toString());
		}
	}

}
