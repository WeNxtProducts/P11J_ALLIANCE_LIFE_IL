package com.iii.pel.forms.PILT002_APAC_QE;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name="PW_IL_QQUOT_APPL_CHARGE")
public class PW_IL_QQUOT_APPL_CHARGE extends BaseValueBean {
	
	//QQAC_CHRG_CODE,QQAC_APPLIED_ON,QQAC_APPLY_PERIOD,QQAC_RATE,QQAC_RATE_PER,QQAC_FC_CHRG_AMT 
	
	@Column(name="QQAC_SYS_ID")
	private Long QQAC_SYS_ID;
	
	@Column(name="QQAC_QUOT_SYS_ID")
	private Long QQAC_QUOT_SYS_ID;
	
	@Column(name="QQAC_CHRG_CODE")
	private String QQAC_CHRG_CODE;
	

	
	@Column(name="QQAC_FC_CHRG_AMT")
	private Double QQAC_FC_CHRG_AMT;
	
	@Column(name="QQAC_LC_CHRG_AMT")
	private Double QQAC_LC_CHRG_AMT;
	
	
	@Column(name="QQAC_APPLIED_ON")
	private String QQAC_APPLIED_ON;
	
	@Column(name="QQAC_APPLY_PERIOD")
	private String QQAC_APPLY_PERIOD;
	
	@Column(name="QQAC_RATE")
	private Double QQAC_RATE;
	
	@Column(name="QQAC_RATE_PER")
	private int QQAC_RATE_PER;
	
	@Column(name="QQAC_CR_UID")
	private String QQAC_CR_UID;
	
   private String UI_M_CHRG_DESC;
	
	@Column(name="QQAC_CR_DT")
	private Date QQAC_CR_DT;
	
	private String UI_CHARGE_APPLIED_ON;
	private String UI_CHARGE_APPLIED_PERIOD;
	
	
	
	public String getUI_M_CHRG_DESC() {
		return UI_M_CHRG_DESC;
	}

	public String getUI_CHARGE_APPLIED_ON() {
		return UI_CHARGE_APPLIED_ON;
	}

	public void setUI_CHARGE_APPLIED_ON(String uI_CHARGE_APPLIED_ON) {
		UI_CHARGE_APPLIED_ON = uI_CHARGE_APPLIED_ON;
	}

	public String getUI_CHARGE_APPLIED_PERIOD() {
		return UI_CHARGE_APPLIED_PERIOD;
	}

	public void setUI_CHARGE_APPLIED_PERIOD(String uI_CHARGE_APPLIED_PERIOD) {
		UI_CHARGE_APPLIED_PERIOD = uI_CHARGE_APPLIED_PERIOD;
	}

	public void setUI_M_CHRG_DESC(String uI_M_CHRG_DESC) {
		UI_M_CHRG_DESC = uI_M_CHRG_DESC;
	}

	public Date getQQAC_CR_DT() {
		return QQAC_CR_DT;
	}

	public void setQQAC_CR_DT(Date qQAC_CR_DT) {
		QQAC_CR_DT = qQAC_CR_DT;
	}

	public String getQQAC_CR_UID() {
		return QQAC_CR_UID;
	}

	public void setQQAC_CR_UID(String qQAC_CR_UID) {
		QQAC_CR_UID = qQAC_CR_UID;
	}

	public String getQQAC_APPLIED_ON() {
		return QQAC_APPLIED_ON;
	}

	public void setQQAC_APPLIED_ON(String qQAC_APPLIED_ON) {
		QQAC_APPLIED_ON = qQAC_APPLIED_ON;
	}

	public String getQQAC_APPLY_PERIOD() {
		return QQAC_APPLY_PERIOD;
	}

	public void setQQAC_APPLY_PERIOD(String qQAC_APPLY_PERIOD) {
		QQAC_APPLY_PERIOD = qQAC_APPLY_PERIOD;
	}

	public Double getQQAC_RATE() {
		return QQAC_RATE;
	}

	public void setQQAC_RATE(Double qQAC_RATE) {
		QQAC_RATE = qQAC_RATE;
	}

	

	public int getQQAC_RATE_PER() {
		return QQAC_RATE_PER;
	}

	public void setQQAC_RATE_PER(int qQAC_RATE_PER) {
		QQAC_RATE_PER = qQAC_RATE_PER;
	}

	public Long getQQAC_SYS_ID() {
		return QQAC_SYS_ID;
	}

	public void setQQAC_SYS_ID(Long qQAC_SYS_ID) {
		QQAC_SYS_ID = qQAC_SYS_ID;
	}


	public Long getQQAC_QUOT_SYS_ID() {
		return QQAC_QUOT_SYS_ID;
	}

	public void setQQAC_QUOT_SYS_ID(Long qQAC_QUOT_SYS_ID) {
		QQAC_QUOT_SYS_ID = qQAC_QUOT_SYS_ID;
	}

	public String getQQAC_CHRG_CODE() {
		return QQAC_CHRG_CODE;
	}

	public void setQQAC_CHRG_CODE(String qQAC_CHRG_CODE) {
		QQAC_CHRG_CODE = qQAC_CHRG_CODE;
	}

	public Double getQQAC_FC_CHRG_AMT() {
		return QQAC_FC_CHRG_AMT;
	}

	public void setQQAC_FC_CHRG_AMT(Double qQAC_FC_CHRG_AMT) {
		QQAC_FC_CHRG_AMT = qQAC_FC_CHRG_AMT;
	}

	public Double getQQAC_LC_CHRG_AMT() {
		return QQAC_LC_CHRG_AMT;
	}

	public void setQQAC_LC_CHRG_AMT(Double qQAC_LC_CHRG_AMT) {
		QQAC_LC_CHRG_AMT = qQAC_LC_CHRG_AMT;
	}

	
	private String UI_QQAC_RATE;
	private String UI_QQAC_RATE_PER;
	private String UI_QQAC_FC_CHRG_AMT;



	public String getUI_QQAC_RATE() {
		return UI_QQAC_RATE;
	}

	public void setUI_QQAC_RATE(String uI_QQAC_RATE) {
		UI_QQAC_RATE = uI_QQAC_RATE;
	}

	public String getUI_QQAC_RATE_PER() {
		return UI_QQAC_RATE_PER;
	}

	public void setUI_QQAC_RATE_PER(String uI_QQAC_RATE_PER) {
		UI_QQAC_RATE_PER = uI_QQAC_RATE_PER;
	}

	public String getUI_QQAC_FC_CHRG_AMT() {
		return UI_QQAC_FC_CHRG_AMT;
	}

	public void setUI_QQAC_FC_CHRG_AMT(String uI_QQAC_FC_CHRG_AMT) {
		UI_QQAC_FC_CHRG_AMT = uI_QQAC_FC_CHRG_AMT;
	}
	
	
	
	

}
