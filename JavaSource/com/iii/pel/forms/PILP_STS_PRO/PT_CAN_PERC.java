package com.iii.pel.forms.PILP_STS_PRO;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_CAN_PRC")
public class PT_CAN_PERC extends BaseValueBean {

	private String UI_M_POL_NO_FM;
	
	private String UI_M_POL_NO_TO;
	
	private Date UI_M_PROCESS_DT;
	
	@Column(name ="CP_POL_NO")
	private String CP_POL_NO;
	
	@Column(name ="CP_STATUS_DT")
	private Date CP_STATUS_DT;
	
	@Column(name ="CP_NO_OF_DAYS")
	private Integer CP_NO_OF_DAYS;
	
	@Column(name ="CP_FLEX_03")
	private  String CP_FLEX_03;
	
	@Column(name ="CP_FLEX_05")
	private  String CP_FLEX_05;
	
	@Column(name ="CP_FLEX_01")
	private  String CP_FLEX_01;
	
	@Column(name ="CP_FLEX_02")
	private  String CP_FLEX_02;
	
	private Boolean UI_YES_ALL;

	public String getUI_M_POL_NO_FM() {
		return UI_M_POL_NO_FM;
	}

	public void setUI_M_POL_NO_FM(String ui_m_pol_no_fm) {
		UI_M_POL_NO_FM = ui_m_pol_no_fm;
	}

	public String getUI_M_POL_NO_TO() {
		return UI_M_POL_NO_TO;
	}

	public void setUI_M_POL_NO_TO(String ui_m_pol_no_to) {
		UI_M_POL_NO_TO = ui_m_pol_no_to;
	}

	public Date getUI_M_PROCESS_DT() {
		return UI_M_PROCESS_DT;
	}

	public void setUI_M_PROCESS_DT(Date ui_m_process_dt) {
		UI_M_PROCESS_DT = ui_m_process_dt;
	}

	public String getCP_POL_NO() {
		return CP_POL_NO;
	}

	public void setCP_POL_NO(String cp_pol_no) {
		CP_POL_NO = cp_pol_no;
	}

	public Date getCP_STATUS_DT() {
		return CP_STATUS_DT;
	}

	public void setCP_STATUS_DT(Date cp_status_dt) {
		CP_STATUS_DT = cp_status_dt;
	}

	

	public Integer getCP_NO_OF_DAYS() {
		return CP_NO_OF_DAYS;
	}

	public void setCP_NO_OF_DAYS(Integer cp_no_of_days) {
		CP_NO_OF_DAYS = cp_no_of_days;
	}



	public Boolean getUI_YES_ALL() {
		return UI_YES_ALL;
	}

	public void setUI_YES_ALL(Boolean ui_yes_all) {
		UI_YES_ALL = ui_yes_all;
	}

	public String getCP_FLEX_03() {
		return CP_FLEX_03;
	}

	public void setCP_FLEX_03(String cp_flex_03) {
		CP_FLEX_03 = cp_flex_03;
	}

	public String getCP_FLEX_05() {
		return CP_FLEX_05;
	}

	public void setCP_FLEX_05(String cp_flex_05) {
		CP_FLEX_05 = cp_flex_05;
	}

	public String getCP_FLEX_01() {
		return CP_FLEX_01;
	}

	public void setCP_FLEX_01(String cp_flex_01) {
		CP_FLEX_01 = cp_flex_01;
	}

	public String getCP_FLEX_02() {
		return CP_FLEX_02;
	}

	public void setCP_FLEX_02(String cp_flex_02) {
		CP_FLEX_02 = cp_flex_02;
	}
	
}
