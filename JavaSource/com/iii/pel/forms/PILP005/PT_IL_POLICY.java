package com.iii.pel.forms.PILP005;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class PT_IL_POLICY extends BaseValueBean {

	private String POL_NO;

	@Column(name="POL_FAC_YN")
	private String POL_FAC_YN;

	private Date UI_M_PC_PAID_DT;
	
	private Date UI_M_SCHD_DT;
	
	private Long UI_M_POL_SYS_ID;
	
	private Long UI_M_PC_SYS_ID;
	
	private Date POL_ISSUE_DT;

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String POL_NO) {
		this.POL_NO = POL_NO;
	}

	public String getPOL_FAC_YN() {
		return POL_FAC_YN;
	}

	public void setPOL_FAC_YN(String POL_FAC_YN) {
		this.POL_FAC_YN = POL_FAC_YN;
	}

	public Date getUI_M_PC_PAID_DT() {
		return UI_M_PC_PAID_DT;
	}

	public void setUI_M_PC_PAID_DT(Date ui_m_pc_paid_dt) {
		UI_M_PC_PAID_DT = ui_m_pc_paid_dt;
	}

	public Date getUI_M_SCHD_DT() {
		return UI_M_SCHD_DT;
	}

	public void setUI_M_SCHD_DT(Date ui_m_schd_dt) {
		UI_M_SCHD_DT = ui_m_schd_dt;
	}

	public Long getUI_M_POL_SYS_ID() {
		return UI_M_POL_SYS_ID;
	}

	public void setUI_M_POL_SYS_ID(Long ui_m_pol_sys_id) {
		UI_M_POL_SYS_ID = ui_m_pol_sys_id;
	}

	public Long getUI_M_PC_SYS_ID() {
		return UI_M_PC_SYS_ID;
	}

	public void setUI_M_PC_SYS_ID(Long ui_m_pc_sys_id) {
		UI_M_PC_SYS_ID = ui_m_pc_sys_id;
	}

	public Date getPOL_ISSUE_DT() {
		return POL_ISSUE_DT;
	}

	public void setPOL_ISSUE_DT(Date pol_issue_dt) {
		POL_ISSUE_DT = pol_issue_dt;
	}

}
