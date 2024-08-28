package com.iii.pel.forms.PILP014_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="")
public class CTRL {

	private String UI_M_CURSOR_HINT_REC;
	
	private Integer EM_ERR_NO;
	                                                                                                                                                                                    
	private String EM_ENG_MSG;                                                                                                                                                                                
	private String EM_FOR_MSG ;                                                                                                                                                                               
	private String EM_ENG_ACTION;                                                                                                                                                                                 
	private String EM_FOR_ACTION;                                                                                                                                                                                 
	private  Date EM_CR_DT;                                                                                                                                                                                                 
	private String EM_CR_UID;                                                                                                                                                                                       
	private Date EM_UPD_DT;                                                                                                                                                                                                 
	private String EM_UPD_UID;                                                                                                                                                                                      
	private String EM_ERR_SEVERITY;

	@Column(name="UI_M_USER_DISP")
	private String UI_M_USER_DISP;

	public String getUI_M_CURSOR_HINT_REC() {
		return UI_M_CURSOR_HINT_REC;
	}

	private String M_COMM_DEL;
	
	public String getM_COMM_DEL() {
		return M_COMM_DEL;
	}

	public void setM_COMM_DEL(String m_comm_del) {
		M_COMM_DEL = m_comm_del;
	}

	public void setUI_M_CURSOR_HINT_REC(String UI_M_CURSOR_HINT_REC) {
		this.UI_M_CURSOR_HINT_REC = UI_M_CURSOR_HINT_REC;
	}

	public String getUI_M_USER_DISP() {
		return UI_M_USER_DISP;
	}

	public void setUI_M_USER_DISP(String UI_M_USER_DISP) {
		this.UI_M_USER_DISP = UI_M_USER_DISP;
	}

	public Integer getEM_ERR_NO() {
		return EM_ERR_NO;
	}

	public void setEM_ERR_NO(Integer em_err_no) {
		EM_ERR_NO = em_err_no;
	}

	public String getEM_ENG_MSG() {
		return EM_ENG_MSG;
	}

	public void setEM_ENG_MSG(String em_eng_msg) {
		EM_ENG_MSG = em_eng_msg;
	}

	public String getEM_FOR_MSG() {
		return EM_FOR_MSG;
	}

	public void setEM_FOR_MSG(String em_for_msg) {
		EM_FOR_MSG = em_for_msg;
	}

	public String getEM_ENG_ACTION() {
		return EM_ENG_ACTION;
	}

	public void setEM_ENG_ACTION(String em_eng_action) {
		EM_ENG_ACTION = em_eng_action;
	}

	public String getEM_FOR_ACTION() {
		return EM_FOR_ACTION;
	}

	public void setEM_FOR_ACTION(String em_for_action) {
		EM_FOR_ACTION = em_for_action;
	}

	public Date getEM_CR_DT() {
		return EM_CR_DT;
	}

	public void setEM_CR_DT(Date em_cr_dt) {
		EM_CR_DT = em_cr_dt;
	}

	public String getEM_CR_UID() {
		return EM_CR_UID;
	}

	public void setEM_CR_UID(String em_cr_uid) {
		EM_CR_UID = em_cr_uid;
	}

	public Date getEM_UPD_DT() {
		return EM_UPD_DT;
	}

	public void setEM_UPD_DT(Date em_upd_dt) {
		EM_UPD_DT = em_upd_dt;
	}

	public String getEM_UPD_UID() {
		return EM_UPD_UID;
	}

	public void setEM_UPD_UID(String em_upd_uid) {
		EM_UPD_UID = em_upd_uid;
	}

	public String getEM_ERR_SEVERITY() {
		return EM_ERR_SEVERITY;
	}

	public void setEM_ERR_SEVERITY(String em_err_severity) {
		EM_ERR_SEVERITY = em_err_severity;
	}
	
	
	private String EM_POL_NO;

	public String getEM_POL_NO() {
		return EM_POL_NO;
	}

	public void setEM_POL_NO(String eM_POL_NO) {
		EM_POL_NO = eM_POL_NO;
	}  
	
}
