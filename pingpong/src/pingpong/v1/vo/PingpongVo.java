package pingpong.v1.vo;

import java.util.HashSet;
import java.util.Set;

import pingpong.v1.PingpongEnum;

public class PingpongVo {

	private Integer number;

	private Set<PingpongEnum> set = new HashSet<>();

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Set<PingpongEnum> getSet() {
		return set;
	}

	public void setSet(Set<PingpongEnum> set) {
		this.set = set;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(this.getNumber().toString());
		for (PingpongEnum p : getSet()) {
			s.append(" ").append(p);
		}
		return s.toString();
	}

}
