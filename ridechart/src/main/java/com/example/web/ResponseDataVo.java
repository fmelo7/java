package com.example.web;

import java.util.List;

public class ResponseDataVo {
	private List<DataVo> data1;
	private List<DataVo> data2;

	public ResponseDataVo(List<DataVo> data1, List<DataVo> data2) {
		this.setData1(data1);
		this.setData2(data2);
	}

	public List<DataVo> getData1() {
		return data1;
	}

	public void setData1(List<DataVo> data1) {
		this.data1 = data1;
	}

	public List<DataVo> getData2() {
		return data2;
	}

	public void setData2(List<DataVo> data2) {
		this.data2 = data2;
	}
}
