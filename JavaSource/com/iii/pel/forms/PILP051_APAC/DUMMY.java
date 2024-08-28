package com.iii.pel.forms.PILP051_APAC;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")

public class DUMMY  extends BaseValueBean {

	
	private String UI_M_CLAIM_NO_FM;
	
	private String UI_M_CLAIM_NO_TO;
	
	private Date UI_M_AS_ON_DT;


	public Date getUI_M_AS_ON_DT() {
		return UI_M_AS_ON_DT;
	}

	public void setUI_M_AS_ON_DT(Date ui_m_as_on_dt) {
		UI_M_AS_ON_DT = ui_m_as_on_dt;
	}

	public String getUI_M_CLAIM_NO_FM() {
		return UI_M_CLAIM_NO_FM;
	}

	public void setUI_M_CLAIM_NO_FM(String ui_m_claim_no_fm) {
		UI_M_CLAIM_NO_FM = ui_m_claim_no_fm;
	}


	public String getUI_M_CLAIM_NO_TO() {
		return UI_M_CLAIM_NO_TO;
	}

	public void setUI_M_CLAIM_NO_TO(String ui_m_claim_no_to) {
		UI_M_CLAIM_NO_TO = ui_m_claim_no_to;
	}


}
