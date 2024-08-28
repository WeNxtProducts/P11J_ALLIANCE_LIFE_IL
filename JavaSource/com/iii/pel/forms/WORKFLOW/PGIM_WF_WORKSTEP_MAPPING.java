package com.iii.pel.forms.WORKFLOW;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PGIM_WF_WORKSTEP_MAPPING")
public class PGIM_WF_WORKSTEP_MAPPING extends BaseValueBean {
	
	@Column(name="PWWM_PROCESS_ID")
	private String PWWM_PROCESS_ID;
	
	@Column(name="PWWM_WORKSTEP_ID")
	private String PWWM_WORKSTEP_ID;
	
	@Column(name="PWWM_RULE_ID")
	private String PWWM_RULE_ID;   
	
	@Column(name="PWWM_RULE_PARAM_ID")
	private String PWWM_RULE_PARAM_ID;
	
	@Column(name="PWWM_SQL_STMT")
	private String PWWM_SQL_STMT; 
	
	@Column(name="PWWM_TABLE_NAME")
	private String PWWM_TABLE_NAME;
	
	@Column(name="PWWM_WHR_CLS1_FLD")
	private String PWWM_WHR_CLS1_FLD;
	
	@Column(name="PWWM_WHR_CLS2_FLD")
	private String PWWM_WHR_CLS2_FLD;
	
	@Column(name="PWWM_WHR_CLS3_FLD")
	private String PWWM_WHR_CLS3_FLD;
	
	@Column(name="PWWM_WHR_CLS4_FLD")
	private String PWWM_WHR_CLS4_FLD;
	
	@Column(name="PWWM_WHR_CLS5_FLD")
	private String PWWM_WHR_CLS5_FLD;
	
	@Column(name="PWWM_SQL_RETURN_TYPE")
	private String PWWM_SQL_RETURN_TYPE;
	
	@Column(name="PWWM_CR_UID")
	private String PWWM_CR_UID;
	
	@Column(name="PWWM_CR_DT")
	private Date PWWM_CR_DT;
	
	@Column(name="PWWM_UPD_UID")
	private String PWWM_UPD_UID;
	
	@Column(name="PWWM_UPD_DT")
	private Date PWWM_UPD_DT;
	
	@Column(name="PWWM_PWB_CODE")
	private String PWWM_PWB_CODE;
	
	public String getPWWM_PROCESS_ID() {
		return PWWM_PROCESS_ID;
	}
	public void setPWWM_PROCESS_ID(String pWWM_PROCESS_ID) {
		PWWM_PROCESS_ID = pWWM_PROCESS_ID;
	}
	public String getPWWM_WORKSTEP_ID() {
		return PWWM_WORKSTEP_ID;
	}
	public void setPWWM_WORKSTEP_ID(String pWWM_WORKSTEP_ID) {
		PWWM_WORKSTEP_ID = pWWM_WORKSTEP_ID;
	}
	public String getPWWM_RULE_ID() {
		return PWWM_RULE_ID;
	}
	public void setPWWM_RULE_ID(String pWWM_RULE_ID) {
		PWWM_RULE_ID = pWWM_RULE_ID;
	}
	public String getPWWM_RULE_PARAM_ID() {
		return PWWM_RULE_PARAM_ID;
	}
	public void setPWWM_RULE_PARAM_ID(String pWWM_RULE_PARAM_ID) {
		PWWM_RULE_PARAM_ID = pWWM_RULE_PARAM_ID;
	}
	public String getPWWM_SQL_STMT() {
		return PWWM_SQL_STMT;
	}
	public void setPWWM_SQL_STMT(String pWWM_SQL_STMT) {
		PWWM_SQL_STMT = pWWM_SQL_STMT;
	}
	public String getPWWM_TABLE_NAME() {
		return PWWM_TABLE_NAME;
	}
	public void setPWWM_TABLE_NAME(String pWWM_TABLE_NAME) {
		PWWM_TABLE_NAME = pWWM_TABLE_NAME;
	}
	public String getPWWM_WHR_CLS1_FLD() {
		return PWWM_WHR_CLS1_FLD;
	}
	public void setPWWM_WHR_CLS1_FLD(String pWWM_WHR_CLS1_FLD) {
		PWWM_WHR_CLS1_FLD = pWWM_WHR_CLS1_FLD;
	}
	public String getPWWM_WHR_CLS2_FLD() {
		return PWWM_WHR_CLS2_FLD;
	}
	public void setPWWM_WHR_CLS2_FLD(String pWWM_WHR_CLS2_FLD) {
		PWWM_WHR_CLS2_FLD = pWWM_WHR_CLS2_FLD;
	}
	public String getPWWM_WHR_CLS3_FLD() {
		return PWWM_WHR_CLS3_FLD;
	}
	public void setPWWM_WHR_CLS3_FLD(String pWWM_WHR_CLS3_FLD) {
		PWWM_WHR_CLS3_FLD = pWWM_WHR_CLS3_FLD;
	}
	public String getPWWM_WHR_CLS4_FLD() {
		return PWWM_WHR_CLS4_FLD;
	}
	public void setPWWM_WHR_CLS4_FLD(String pWWM_WHR_CLS4_FLD) {
		PWWM_WHR_CLS4_FLD = pWWM_WHR_CLS4_FLD;
	}
	public String getPWWM_WHR_CLS5_FLD() {
		return PWWM_WHR_CLS5_FLD;
	}
	public void setPWWM_WHR_CLS5_FLD(String pWWM_WHR_CLS5_FLD) {
		PWWM_WHR_CLS5_FLD = pWWM_WHR_CLS5_FLD;
	}
	public String getPWWM_SQL_RETURN_TYPE() {
		return PWWM_SQL_RETURN_TYPE;
	}
	public void setPWWM_SQL_RETURN_TYPE(String pWWM_SQL_RETURN_TYPE) {
		PWWM_SQL_RETURN_TYPE = pWWM_SQL_RETURN_TYPE;
	}
	public String getPWWM_CR_UID() {
		return PWWM_CR_UID;
	}
	public void setPWWM_CR_UID(String pWWM_CR_UID) {
		PWWM_CR_UID = pWWM_CR_UID;
	}
	public Date getPWWM_CR_DT() {
		return PWWM_CR_DT;
	}
	public void setPWWM_CR_DT(Date pWWM_CR_DT) {
		PWWM_CR_DT = pWWM_CR_DT;
	}
	public String getPWWM_UPD_UID() {
		return PWWM_UPD_UID;
	}
	public void setPWWM_UPD_UID(String pWWM_UPD_UID) {
		PWWM_UPD_UID = pWWM_UPD_UID;
	}
	public Date getPWWM_UPD_DT() {
		return PWWM_UPD_DT;
	}
	public void setPWWM_UPD_DT(Date pWWM_UPD_DT) {
		PWWM_UPD_DT = pWWM_UPD_DT;
	}
	public String getPWWM_PWB_CODE() {
		return PWWM_PWB_CODE;
	}
	public void setPWWM_PWB_CODE(String pWWM_PWB_CODE) {
		PWWM_PWB_CODE = pWWM_PWB_CODE;
	}
	
	
	
}
