package com.iii.pel.forms.PILP_STP;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {
	private String UI_M_PROD_FM;
	private String UI_M_PROD_TO;
	private Date UI_M_FM_DT;
	private Date UI_M_TO_DT;
	private String UI_M_PROD_FM_DESC;
	private String UI_M_PROD_TO_DESC;
	
	public String getUI_M_PROD_FM_DESC() {
		return UI_M_PROD_FM_DESC;
	}
	public void setUI_M_PROD_FM_DESC(String ui_m_prod_fm_desc) {
		UI_M_PROD_FM_DESC = ui_m_prod_fm_desc;
	}
	public String getUI_M_PROD_TO_DESC() {
		return UI_M_PROD_TO_DESC;
	}
	public void setUI_M_PROD_TO_DESC(String ui_m_prod_to_desc) {
		UI_M_PROD_TO_DESC = ui_m_prod_to_desc;
	}
	public String getUI_M_PROD_FM() {
		return UI_M_PROD_FM;
	}
	public void setUI_M_PROD_FM(String ui_m_prod_fm) {
		UI_M_PROD_FM = ui_m_prod_fm;
	}
	public String getUI_M_PROD_TO() {
		return UI_M_PROD_TO;
	}
	public void setUI_M_PROD_TO(String ui_m_prod_to) {
		UI_M_PROD_TO = ui_m_prod_to;
	}
	public Date getUI_M_FM_DT() {
		return UI_M_FM_DT;
	}
	public void setUI_M_FM_DT(Date ui_m_fm_dt) {
		UI_M_FM_DT = ui_m_fm_dt;
	}
	public Date getUI_M_TO_DT() {
		return UI_M_TO_DT;
	}
	public void setUI_M_TO_DT(Date ui_m_to_dt) {
		UI_M_TO_DT = ui_m_to_dt;
	}
	
	
}
