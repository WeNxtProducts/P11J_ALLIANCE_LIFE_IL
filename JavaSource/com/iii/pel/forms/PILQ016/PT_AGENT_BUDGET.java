package com.iii.pel.forms.PILQ016;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PS_AGENT_MON_BUDGET")
public class PT_AGENT_BUDGET extends BaseValueBean {

	@Column(name="ABGT_AGENT_CODE")
	private String ABGT_AGENT_CODE;

	private String UI_M_ABGT_AGENT_NAME;

	private Date UI_M_ABGT_FM_DT;

	private Date UI_M_ABGT_TO_DT;



	public String getABGT_AGENT_CODE() {
		return ABGT_AGENT_CODE;
	}

	public void setABGT_AGENT_CODE(String ABGT_AGENT_CODE) {
		this.ABGT_AGENT_CODE = ABGT_AGENT_CODE;
	}

	public String getUI_M_ABGT_AGENT_NAME() {
		return UI_M_ABGT_AGENT_NAME;
	}

	public void setUI_M_ABGT_AGENT_NAME(String UI_M_ABGT_AGENT_NAME) {
		this.UI_M_ABGT_AGENT_NAME = UI_M_ABGT_AGENT_NAME;
	}

	public Date getUI_M_ABGT_FM_DT() {
		 return UI_M_ABGT_FM_DT;
	}

	public void setUI_M_ABGT_FM_DT(Date UI_M_ABGT_FM_DT) {
		this.UI_M_ABGT_FM_DT = UI_M_ABGT_FM_DT;
	}

	public Date getUI_M_ABGT_TO_DT() {
		 return UI_M_ABGT_TO_DT;
	}

	public void setUI_M_ABGT_TO_DT(Date UI_M_ABGT_TO_DT) {
		this.UI_M_ABGT_TO_DT = UI_M_ABGT_TO_DT;
	}
}
