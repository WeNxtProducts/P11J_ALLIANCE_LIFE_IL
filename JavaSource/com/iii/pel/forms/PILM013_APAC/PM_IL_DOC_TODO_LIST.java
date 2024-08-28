package com.iii.pel.forms.PILM013_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_DOC_TODO_LIST")
public class PM_IL_DOC_TODO_LIST extends BaseValueBean {

	@Column(name="DTL_SR_NO")
	private int DTL_SR_NO;

	@Column(name="DTL_CLAIM_TYPE")
	private String DTL_CLAIM_TYPE;

	@Column(name="DTL_TODO_LIST_ITEM")
	private String DTL_TODO_LIST_ITEM;

	@Column(name="DTL_MANDATORY_YN")
	private String DTL_MANDATORY_YN;

	@Column(name="DTL_DEFAULT_YN")
	private String DTL_DEFAULT_YN;

	@Column(name="DTL_BL_TODO_LIST_ITEM")
	private String DTL_BL_TODO_LIST_ITEM;

	private boolean CHECKBOX;
	
	@Column(name="DTL_DS_TYPE")
	private String DTL_DS_TYPE;
	
	@Column(name="DTL_DS_CODE")
	private String DTL_DS_CODE;
	
	@Column(name="DTL_CR_DT")
	private Date DTL_CR_DT;
	
	@Column(name="DTL_CR_UID")
	private String DTL_CR_UID;
	
	@Column(name="DTL_EFF_FM_DT")
	private Date DTL_EFF_FM_DT;
	
	@Column(name="DTL_EFF_TO_DT")
	private Date DTL_EFF_TO_DT;
	
	@Column(name="DTL_UPD_DT")
	private Date DTL_UPD_DT;
	
	@Column(name="DTL_UPD_UID")
	private String DTL_UPD_UID;
	
	@Column(name="DTL_DTG_GROUP_CODE")
	private String DTL_DTG_GROUP_CODE;
	
	private double UI_M_SR_NO;


	public String getDTL_DTG_GROUP_CODE() {
		return DTL_DTG_GROUP_CODE;
	}


	public void setDTL_DTG_GROUP_CODE(String dtl_dtg_group_code) {
		DTL_DTG_GROUP_CODE = dtl_dtg_group_code;
	}


	public Date getDTL_EFF_FM_DT() {
		return DTL_EFF_FM_DT;
	}


	public void setDTL_EFF_FM_DT(Date dtl_eff_fm_dt) {
		DTL_EFF_FM_DT = dtl_eff_fm_dt;
	}


	public Date getDTL_EFF_TO_DT() {
		return DTL_EFF_TO_DT;
	}


	public void setDTL_EFF_TO_DT(Date dtl_eff_to_dt) {
		DTL_EFF_TO_DT = dtl_eff_to_dt;
	}


	public Date getDTL_CR_DT() {
		return DTL_CR_DT;
	}
	

	public void setDTL_CR_DT(Date dtl_cr_dt) {
		DTL_CR_DT = dtl_cr_dt;
	}

		
	public int getDTL_SR_NO() {
		return DTL_SR_NO;
	}


	public void setDTL_SR_NO(int dtl_sr_no) {
		DTL_SR_NO = dtl_sr_no;
	}


	public String getDTL_CLAIM_TYPE() {
		return DTL_CLAIM_TYPE;
	}

	public void setDTL_CLAIM_TYPE(String DTL_CLAIM_TYPE) {
		this.DTL_CLAIM_TYPE = DTL_CLAIM_TYPE;
	}

	public String getDTL_TODO_LIST_ITEM() {
		return DTL_TODO_LIST_ITEM;
	}

	public void setDTL_TODO_LIST_ITEM(String DTL_TODO_LIST_ITEM) {
		this.DTL_TODO_LIST_ITEM = DTL_TODO_LIST_ITEM;
	}

	public String getDTL_MANDATORY_YN() {
		return DTL_MANDATORY_YN;
	}

	public void setDTL_MANDATORY_YN(String DTL_MANDATORY_YN) {
		this.DTL_MANDATORY_YN = DTL_MANDATORY_YN;
	}

	public String getDTL_DEFAULT_YN() {
		return DTL_DEFAULT_YN;
	}

	public void setDTL_DEFAULT_YN(String DTL_DEFAULT_YN) {
		this.DTL_DEFAULT_YN = DTL_DEFAULT_YN;
	}

	public String getDTL_BL_TODO_LIST_ITEM() {
		return DTL_BL_TODO_LIST_ITEM;
	}

	public void setDTL_BL_TODO_LIST_ITEM(String DTL_BL_TODO_LIST_ITEM) {
		this.DTL_BL_TODO_LIST_ITEM = DTL_BL_TODO_LIST_ITEM;
	}

	public String getDTL_DS_TYPE() {
		return DTL_DS_TYPE;
	}

	public void setDTL_DS_TYPE(String dtl_ds_type) {
		DTL_DS_TYPE = dtl_ds_type;
	}

	public String getDTL_DS_CODE() {
		return DTL_DS_CODE;
	}

	public void setDTL_DS_CODE(String dtl_ds_code) {
		DTL_DS_CODE = dtl_ds_code;
	}


	public String getDTL_CR_UID() {
		return DTL_CR_UID;
	}


	public void setDTL_CR_UID(String dtl_cr_uid) {
		DTL_CR_UID = dtl_cr_uid;
	}


	public Date getDTL_UPD_DT() {
		return DTL_UPD_DT;
	}


	public void setDTL_UPD_DT(Date dtl_upd_dt) {
		DTL_UPD_DT = dtl_upd_dt;
	}


	public String getDTL_UPD_UID() {
		return DTL_UPD_UID;
	}


	public void setDTL_UPD_UID(String dtl_upd_uid) {
		DTL_UPD_UID = dtl_upd_uid;
	}


	public double getUI_M_SR_NO() {
		return UI_M_SR_NO;
	}


	public void setUI_M_SR_NO(double ui_m_sr_no) {
		UI_M_SR_NO = ui_m_sr_no;
	}


	public boolean isCHECKBOX() {
		return CHECKBOX;
	}


	public void setCHECKBOX(boolean checkbox) {
		CHECKBOX = checkbox;
	}

	/*Added by saritha on 11-07-2017 for ssp call id ZBILQC-1719714*/
	@Column(name="DTL_SA_FROM")
	private Double DTL_SA_FROM;

	public Double getDTL_SA_FROM() {
		return DTL_SA_FROM;
	}
	public void setDTL_SA_FROM(Double dTL_SA_FROM) {
		DTL_SA_FROM = dTL_SA_FROM;
	}

	@Column(name="DTL_SA_TO")
	private Double DTL_SA_TO;

	public Double getDTL_SA_TO() {
		return DTL_SA_TO;
	}
	public void setDTL_SA_TO(Double dTL_SA_TO) {
		DTL_SA_TO = dTL_SA_TO;
	}

	/*End*/
	
	//Added by kavitha on 28.12.2019 for orient 
		@Column(name="DTL_PROD_CODE")
		private String DTL_PROD_CODE;
		
		private String UI_M_DTL_PROD_CODE_DESC;


		public String getDTL_PROD_CODE() {
			return DTL_PROD_CODE;
		}


		public void setDTL_PROD_CODE(String dTL_PROD_CODE) {
			DTL_PROD_CODE = dTL_PROD_CODE;
		}
		
		public String getUI_M_DTL_PROD_CODE_DESC() {
			return UI_M_DTL_PROD_CODE_DESC;
		}


		public void setUI_M_DTL_PROD_CODE_DESC(String uI_M_DTL_PROD_CODE_DESC) {
			UI_M_DTL_PROD_CODE_DESC = uI_M_DTL_PROD_CODE_DESC;
		}

		
		
	
}
