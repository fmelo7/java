package pingpong.model;

public enum PingpongEnum {

	PING(3), //
	PONG(5);

	private Integer number;

	private PingpongEnum(Integer number) {
		this.number = number;
	}

	public static boolean isPing(Integer number) {
		return number % PING.number == 0;
	}

	public static boolean isPong(Integer number) {
		return number % PONG.number == 0;
	}

	public static PingpongVo createVo(Integer number) {
		PingpongVo vo = new PingpongVo(number);
		if (isPing(number)) {
			vo.getSet().add(PING);
		}
		if (isPong(number)) {
			vo.getSet().add(PONG);
		}
		return vo;
	}
}
