package pingpong.vo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import pingpong.v1.PingpongEnum;

public class PingpongVo {

	private Integer number;

	private Set<PingpongEnum> set = new HashSet<>();

	public PingpongVo() {
	}

	public PingpongVo(Integer number, PingpongEnum... p) {
		this.number = number;
		this.set.addAll(Arrays.asList(p));
	}

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

	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(((PingpongVo) obj).toString());
	}

}
