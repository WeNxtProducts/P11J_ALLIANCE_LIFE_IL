package com.iii.pel.forms.PILP028_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class RI_CLOSING extends BaseValueBean {

	private String UI_M_TREATY_CODE;

	@Column(name="UI_M_PERIOD")
	private Integer UI_M_PERIOD;

	private Integer UI_M_SRNO;

	private String UI_M_ASSR_CODE_FM;

	private String UI_M_ASSR_CODE_TO;

	private Date UI_M_RI_FM_DT;

	private Date UI_M_RI_TO_DT;



	public String getUI_M_TREATY_CODE() {
		return UI_M_TREATY_CODE;
	}

	public void setUI_M_TREATY_CODE(String UI_M_TREATY_CODE) {
		this.UI_M_TREATY_CODE = UI_M_TREATY_CODE;
	}

	



	public Integer getUI_M_PERIOD() {
		return UI_M_PERIOD;
	}

	public void setUI_M_PERIOD(Integer ui_m_period) {
		UI_M_PERIOD = ui_m_period;
	}

	public String getUI_M_ASSR_CODE_FM() {
		return UI_M_ASSR_CODE_FM;
	}

	public void setUI_M_ASSR_CODE_FM(String UI_M_ASSR_CODE_FM) {
		this.UI_M_ASSR_CODE_FM = UI_M_ASSR_CODE_FM;
	}

	public String getUI_M_ASSR_CODE_TO() {
		return UI_M_ASSR_CODE_TO;
	}

	public void setUI_M_ASSR_CODE_TO(String UI_M_ASSR_CODE_TO) {
		this.UI_M_ASSR_CODE_TO = UI_M_ASSR_CODE_TO;
	}


	public Date getUI_M_RI_FM_DT() {
		return UI_M_RI_FM_DT;
	}

	public void setUI_M_RI_FM_DT(Date ui_m_ri_fm_dt) {
		UI_M_RI_FM_DT = ui_m_ri_fm_dt;
	}

	public Date getUI_M_RI_TO_DT() {
		return UI_M_RI_TO_DT;
	}

	public void setUI_M_RI_TO_DT(Date ui_m_ri_to_dt) {
		UI_M_RI_TO_DT = ui_m_ri_to_dt;
	}

	public void setUI_M_SRNO(Integer ui_m_srno) {
		UI_M_SRNO = ui_m_srno;
	}

	public Integer getUI_M_SRNO() {
		return UI_M_SRNO;
	}

	


}
