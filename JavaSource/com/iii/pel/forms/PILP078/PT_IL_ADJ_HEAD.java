package com.iii.pel.forms.PILP078;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_ADJ_HEAD")
public class PT_IL_ADJ_HEAD extends BaseValueBean{
	
	@Column(name="AH_REF_TYPE")
	private String AH_REF_TYPE;
	
	@Column(name="AH_REF_NO")
	private String AH_REF_NO;
	
	@Column(name="AH_CUST_CODE")
	private String AH_CUST_CODE;
	
	private String UI_M_CUST_DESC;
	
	public String getUI_M_CUST_DESC() {
		return UI_M_CUST_DESC;
	}
	public void setUI_M_CUST_DESC(String uI_M_CUST_DESC) {
		UI_M_CUST_DESC = uI_M_CUST_DESC;
	}

	@Column(name="AH_LC_AMOUNT")
	private Double AH_LC_AMOUNT;
	
	@Column(name="AH_FC_AMOUNT")
	private Double AH_FC_AMOUNT;
	
	public Double getAH_FC_AMOUNT() {
		return AH_FC_AMOUNT;
	}
	public void setAH_FC_AMOUNT(Double aH_FC_AMOUNT) {
		AH_FC_AMOUNT = aH_FC_AMOUNT;
	}

	private Double UI_POL_TOTAL;
	
	@Column(name = "AH_CR_UID")
	private String AH_CR_UID;

	@Column(name = "AH_CR_DT")
	private Date AH_CR_DT;
	
	@Column(name = "AH_UPD_UID")
	private String AH_UPD_UID;
	
	@Column(name = "AH_UPD_DT")
	private Date AH_UPD_DT;
	
	@Column(name = "AH_REF_SYS_ID")
	private Long AH_REF_SYS_ID;
	
	@Column(name = "AH_SYS_ID")
	private Long AH_SYS_ID;
	
	public Long getAH_SYS_ID() {
		return AH_SYS_ID;
	}

	

	public void setAH_SYS_ID(Long aH_SYS_ID) {
		AH_SYS_ID = aH_SYS_ID;
	}

	public Long getAH_REF_SYS_ID() {
		return AH_REF_SYS_ID;
	}

	public void setAH_REF_SYS_ID(Long aH_REF_SYS_ID) {
		AH_REF_SYS_ID = aH_REF_SYS_ID;
	}


	public String getAH_UPD_UID() {
		return AH_UPD_UID;
	}

	public void setAH_UPD_UID(String aH_UPD_UID) {
		AH_UPD_UID = aH_UPD_UID;
	}

	public Date getAH_UPD_DT() {
		return AH_UPD_DT;
	}

	public void setAH_UPD_DT(Date aH_UPD_DT) {
		AH_UPD_DT = aH_UPD_DT;
	}

	public String getAH_CR_UID() {
		return AH_CR_UID;
	}

	public void setAH_CR_UID(String aH_CR_UID) {
		AH_CR_UID = aH_CR_UID;
	}

	public Date getAH_CR_DT() {
		return AH_CR_DT;
	}

	public void setAH_CR_DT(Date aH_CR_DT) {
		AH_CR_DT = aH_CR_DT;
	}

	public Double getUI_POL_TOTAL() {
		return UI_POL_TOTAL;
	}

	public void setUI_POL_TOTAL(Double uI_POL_TOTAL) {
		UI_POL_TOTAL = uI_POL_TOTAL;
	}

	public String getAH_CUST_CODE() {
		return AH_CUST_CODE;
	}

	public void setAH_CUST_CODE(String aH_CUST_CODE) {
		AH_CUST_CODE = aH_CUST_CODE;
	}

	public String getAH_REF_TYPE() {
		return AH_REF_TYPE;
	}

	public void setAH_REF_TYPE(String aH_REF_TYPE) {
		AH_REF_TYPE = aH_REF_TYPE;
	}

	public String getAH_REF_NO() {
		return AH_REF_NO;
	}

	public void setAH_REF_NO(String aH_REF_NO) {
		AH_REF_NO = aH_REF_NO;
	}

	public Double getAH_LC_AMOUNT() {
		return AH_LC_AMOUNT;
	}

	public void setAH_LC_AMOUNT(Double aH_LC_AMOUNT) {
		AH_LC_AMOUNT = aH_LC_AMOUNT;
	}
/*	private Double UI_CURR_TOT_VAL;
	
	public Double getUI_CURR_TOT_VAL() {
		return UI_CURR_TOT_VAL;
	}
	public void setUI_CURR_TOT_VAL(Double uI_CURR_TOT_VAL) {
		UI_CURR_TOT_VAL = uI_CURR_TOT_VAL;
	}*/
}
