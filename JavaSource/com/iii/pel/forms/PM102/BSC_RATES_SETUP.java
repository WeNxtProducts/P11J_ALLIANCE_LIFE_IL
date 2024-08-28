package com.iii.pel.forms.PM102;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_BSC_RATES_SETUP")
public class BSC_RATES_SETUP extends BaseValueBean {
	
	@Column(name="BSC_EVENT")
	private String BSC_EVENT;
	
	@Column(name="BSC_EVENT_DESC")
	private String BSC_EVENT_DESC;

	@Column(name="BSC_UNIT")
	private Integer BSC_UNIT;
	
	@Column(name="BSC_VALUE")
	private Double BSC_VALUE;

	public String getBSC_EVENT() {
		return BSC_EVENT;
	}

	public void setBSC_EVENT(String bsc_event) {
		BSC_EVENT = bsc_event;
	}

	public Integer getBSC_UNIT() {
		return BSC_UNIT;
	}

	public void setBSC_UNIT(Integer bsc_unit) {
		BSC_UNIT = bsc_unit;
	}

	public Double getBSC_VALUE() {
		return BSC_VALUE;
	}

	public void setBSC_VALUE(Double bsc_value) {
		BSC_VALUE = bsc_value;
	}

	public String getBSC_EVENT_DESC() {
		return BSC_EVENT_DESC;
	}

	public void setBSC_EVENT_DESC(String bsc_event_desc) {
		BSC_EVENT_DESC = bsc_event_desc;
	}

	
	
	

}
