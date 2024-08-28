package com.iii.pel.forms.PILP016;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class PRINT extends BaseValueBean {

	@Column(name="UI_M_POL_ENDT")
	private String UI_M_POL_ENDT;

	private String UI_M_POL_END_NO;

	@Column(name="UI_M_SCHEDULE")
	private String UI_M_SCHEDULE;

	@Column(name="UI_M_PRINTYPE")
	private String UI_M_PRINTYPE;

	@Column(name="UI_M_OTHERS")
	private String UI_M_OTHERS;

	@Column(name="UI_M_OTH_TYPE")
	private String UI_M_OTH_TYPE;

	@Column(name="UI_M_PRINTYPE1")
	private String UI_M_PRINTYPE1;

	private String UI_M_PLSP_REPORT_ID ;

	public String getUI_M_POL_ENDT() {
		return UI_M_POL_ENDT;
	}

	public void setUI_M_POL_ENDT(String UI_M_POL_ENDT) {
		this.UI_M_POL_ENDT = UI_M_POL_ENDT;
	}

	public String getUI_M_POL_END_NO() {
		return UI_M_POL_END_NO;
	}

	public void setUI_M_POL_END_NO(String UI_M_POL_END_NO) {
		this.UI_M_POL_END_NO = UI_M_POL_END_NO;
	}

	public String getUI_M_SCHEDULE() {
		return UI_M_SCHEDULE;
	}

	public void setUI_M_SCHEDULE(String UI_M_SCHEDULE) {
		this.UI_M_SCHEDULE = UI_M_SCHEDULE;
	}

	public String getUI_M_PRINTYPE() {
		return UI_M_PRINTYPE;
	}

	public void setUI_M_PRINTYPE(String UI_M_PRINTYPE) {
		this.UI_M_PRINTYPE = UI_M_PRINTYPE;
	}

	public String getUI_M_OTHERS() {
		return UI_M_OTHERS;
	}

	public void setUI_M_OTHERS(String UI_M_OTHERS) {
		this.UI_M_OTHERS = UI_M_OTHERS;
	}

	public String getUI_M_OTH_TYPE() {
		return UI_M_OTH_TYPE;
	}

	public void setUI_M_OTH_TYPE(String UI_M_OTH_TYPE) {
		this.UI_M_OTH_TYPE = UI_M_OTH_TYPE;
	}

	public String getUI_M_PRINTYPE1() {
		return UI_M_PRINTYPE1;
	}

	public void setUI_M_PRINTYPE1(String UI_M_PRINTYPE1) {
		this.UI_M_PRINTYPE1 = UI_M_PRINTYPE1;
	}

	public String getUI_M_PLSP_REPORT_ID() {
		return UI_M_PLSP_REPORT_ID;
	}

	public void setUI_M_PLSP_REPORT_ID(String ui_m_plsp_report_id) {
		UI_M_PLSP_REPORT_ID = ui_m_plsp_report_id;
	}
	
	//added by krithika on 25-03-2016
	private String list_vaue;
	public String getList_vaue() {
		return list_vaue;
	}

	public void setList_vaue(String list_vaue) {
		this.list_vaue = list_vaue;
	} 
	
	
	
}