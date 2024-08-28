package com.iii.pel.forms.PILT027;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_COMM_VALUES")
public class PT_AGENT_COMM_VALUES extends BaseValueBean {

	@Column(name="ACV_AGENT_CODE")
	private String ACV_AGENT_CODE;

	@Column(name="ACV_COMM_CODE")
	private String ACV_COMM_CODE;

	@Column(name="ACV_LEVEL")
	private Double ACV_LEVEL;

	@Column(name="ACV_YEAR")
	private Double ACV_YEAR;

	@Column(name="ACV_RATE")
	private Double ACV_RATE;

	@Column(name="ACV_RATE_PER")
	private Double ACV_RATE_PER;

	@Column(name="ACV_FC_VALUE")
	private Double ACV_FC_VALUE;

	@Column(name="ACV_LC_VALUE")
	private Double ACV_LC_VALUE;

	private String UI_M_ACV_AGENT_DESC;

	private String UI_M_ACV_COMM_DESC;

	@Column(name="ACV_COVER_CODE")
	private String ACV_COVER_CODE;

	private String UI_M_ACV_COVER_DESC;

	@Column(name="ACV_AGENT_RANK_CODE")
	private String ACV_AGENT_RANK_CODE;

	private String UI_M_ACV_AGENT_RANK_CODE;

	@Column(name="ACV_COMM_TYPE")
	private String ACV_COMM_TYPE;



	public String getACV_AGENT_CODE() {
		return ACV_AGENT_CODE;
	}

	public void setACV_AGENT_CODE(String ACV_AGENT_CODE) {
		this.ACV_AGENT_CODE = ACV_AGENT_CODE;
	}

	public String getACV_COMM_CODE() {
		return ACV_COMM_CODE;
	}

	public void setACV_COMM_CODE(String ACV_COMM_CODE) {
		this.ACV_COMM_CODE = ACV_COMM_CODE;
	}

	public Double getACV_LEVEL() {
		return ACV_LEVEL;
	}

	public void setACV_LEVEL(Double ACV_LEVEL) {
		this.ACV_LEVEL = ACV_LEVEL;
	}

	public Double getACV_YEAR() {
		return ACV_YEAR;
	}

	public void setACV_YEAR(Double ACV_YEAR) {
		this.ACV_YEAR = ACV_YEAR;
	}

	public Double getACV_RATE() {
		return ACV_RATE;
	}

	public void setACV_RATE(Double ACV_RATE) {
		this.ACV_RATE = ACV_RATE;
	}

	public Double getACV_RATE_PER() {
		return ACV_RATE_PER;
	}

	public void setACV_RATE_PER(Double ACV_RATE_PER) {
		this.ACV_RATE_PER = ACV_RATE_PER;
	}

	public Double getACV_FC_VALUE() {
		return ACV_FC_VALUE;
	}

	public void setACV_FC_VALUE(Double ACV_FC_VALUE) {
		this.ACV_FC_VALUE = ACV_FC_VALUE;
	}

	public Double getACV_LC_VALUE() {
		return ACV_LC_VALUE;
	}

	public void setACV_LC_VALUE(Double ACV_LC_VALUE) {
		this.ACV_LC_VALUE = ACV_LC_VALUE;
	}

	public String getUI_M_ACV_AGENT_DESC() {
		return UI_M_ACV_AGENT_DESC;
	}

	public void setUI_M_ACV_AGENT_DESC(String UI_M_ACV_AGENT_DESC) {
		this.UI_M_ACV_AGENT_DESC = UI_M_ACV_AGENT_DESC;
	}

	public String getUI_M_ACV_COMM_DESC() {
		return UI_M_ACV_COMM_DESC;
	}

	public void setUI_M_ACV_COMM_DESC(String UI_M_ACV_COMM_DESC) {
		this.UI_M_ACV_COMM_DESC = UI_M_ACV_COMM_DESC;
	}

	public String getACV_COVER_CODE() {
		return ACV_COVER_CODE;
	}

	public void setACV_COVER_CODE(String ACV_COVER_CODE) {
		this.ACV_COVER_CODE = ACV_COVER_CODE;
	}

	public String getUI_M_ACV_COVER_DESC() {
		return UI_M_ACV_COVER_DESC;
	}

	public void setUI_M_ACV_COVER_DESC(String UI_M_ACV_COVER_DESC) {
		this.UI_M_ACV_COVER_DESC = UI_M_ACV_COVER_DESC;
	}

	public String getACV_AGENT_RANK_CODE() {
		return ACV_AGENT_RANK_CODE;
	}

	public void setACV_AGENT_RANK_CODE(String ACV_AGENT_RANK_CODE) {
		this.ACV_AGENT_RANK_CODE = ACV_AGENT_RANK_CODE;
	}

	public String getUI_M_ACV_AGENT_RANK_CODE() {
		return UI_M_ACV_AGENT_RANK_CODE;
	}

	public void setUI_M_ACV_AGENT_RANK_CODE(String UI_M_ACV_AGENT_RANK_CODE) {
		this.UI_M_ACV_AGENT_RANK_CODE = UI_M_ACV_AGENT_RANK_CODE;
	}

	public String getACV_COMM_TYPE() {
		return ACV_COMM_TYPE;
	}

	public void setACV_COMM_TYPE(String ACV_COMM_TYPE) {
		this.ACV_COMM_TYPE = ACV_COMM_TYPE;
	}
}
