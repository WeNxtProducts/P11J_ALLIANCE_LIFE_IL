package com.iii.pel.forms.PILM013_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_DOC_SETUP")
public class PM_IL_DOC_SETUP extends BaseValueBean {
	
	/*Added by saritha*/
	private String UI_ENDORSE_DESC;

	public String getUI_ENDORSE_DESC() {
		return UI_ENDORSE_DESC;
	}

	public void setUI_ENDORSE_DESC(String uI_ENDORSE_DESC) {
		UI_ENDORSE_DESC = uI_ENDORSE_DESC;
	}

	/*End*/
	
	/* Endorsement SSP Call id FALCONQC-1714638 on 29-07-2016*/
	
	@Column(name="DS_END_REASON")
	private String DS_END_REASON;
	
	public String getDS_END_REASON() {
		return DS_END_REASON;
	}

	public void setDS_END_REASON(String dS_END_REASON) {
		DS_END_REASON = dS_END_REASON;
	}
	
	/*End*/
	
	@Column(name="DS_TYPE")
	private String DS_TYPE;

	

	private String UI_M_DS_TYPE_DESC;
	
	private String UI_M_DS_END_DESC;

	@Column(name="DS_END_TYPE")
	private String DS_END_TYPE;

	@Column(name="DS_CODE")
	private String DS_CODE;

	@Column(name="DS_DESC")
	private String DS_DESC;

	@Column(name="DS_POL_CODE")
	private String DS_POL_CODE;

	@Column(name="DS_SHORT_DESC")
	private String DS_SHORT_DESC;

	@Column(name="DS_USE_SEQ_YN")
	private String DS_USE_SEQ_YN;

	@Column(name="DS_CURR_RATE_BS")
	private String DS_CURR_RATE_BS;

	@Column(name="DS_EFF_FM_DT")
	private Date DS_EFF_FM_DT;

	@Column(name="DS_EFF_TO_DT")
	private Date DS_EFF_TO_DT;

	@Column(name="DS_POST_BO")
	private String DS_POST_BO;

	@Column(name="DS_BROKER_YN")
	private String DS_BROKER_YN;

	@Column(name="DS_PRN_BEFORE_APPR")
	private String DS_PRN_BEFORE_APPR;

	@Column(name="DS_REPRINT_YN")
	private String DS_REPRINT_YN;

	@Column(name="DS_AGE_RECALC_YN")
	private String DS_AGE_RECALC_YN;

	@Column(name="DS_BL_DESC")
	private String DS_BL_DESC;

	@Column(name="DS_BL_SHORT_DESC")
	private String DS_BL_SHORT_DESC;

	@Column(name="DS_FUND_TYPE")
	private String DS_FUND_TYPE;

	@Column(name="DS_REFUND_PREM_FLAG")
	private String DS_REFUND_PREM_FLAG;

	@Column(name="DS_REFUND_SURPLUS_FLAG")
	private String DS_REFUND_SURPLUS_FLAG;

	@Column(name="DS_REFUND_DEP_FLAG")
	private String DS_REFUND_DEP_FLAG;

	@Column(name="DS_RECVR_CHRG_FLAG")
	private String DS_RECVR_CHRG_FLAG;

	@Column(name="DS_RECVR_MEDFEE_YN")
	private String DS_RECVR_MEDFEE_YN;

	@Column(name="DS_RECVR_COMM_FLAG")
	private String DS_RECVR_COMM_FLAG;

	@Column(name="DS_CLM_PARSET")
	private String DS_CLM_PARSET;

	private String UI_M_DS_CLM_PARSET_DESC;

	@Column(name="DS_CLM_FULSET")
	private String DS_CLM_FULSET;
	
	@Column(name="DS_FRZ_FLAG")
	private String DS_FRZ_FLAG;

	private String UI_M_DS_CLM_FULSET_DESC;

	@Column(name="DS_CR_DT")
	private Date DS_CR_DT;
	
	@Column(name="DS_UPD_DT")
	private Date DS_UPD_DT; 
	
	@Column(name="DS_CR_UID")
	private String DS_CR_UID;
	
	private String DS_END_TYPE_DESC;
	
	private String DS_POL_CODE_DESC;
	
	private String UI_M_CALC_METHOD;
	
	private boolean rendered;
	
	private boolean checkBox;

	public Date getDS_CR_DT() {
		return DS_CR_DT;
	}

	public void setDS_CR_DT(Date ds_cr_dt) {
		DS_CR_DT = ds_cr_dt;
	}

	public Date getDS_UPD_DT() {
		return DS_UPD_DT;
	}

	public void setDS_UPD_DT(Date ds_upd_dt) {
		DS_UPD_DT = ds_upd_dt;
	}

	public String getDS_TYPE() {
		return DS_TYPE;
	}

	public void setDS_TYPE(String DS_TYPE) {
		this.DS_TYPE = DS_TYPE;
	}

	public String getUI_M_DS_TYPE_DESC() {
		return UI_M_DS_TYPE_DESC;
	}

	public void setUI_M_DS_TYPE_DESC(String UI_M_DS_TYPE_DESC) {
		this.UI_M_DS_TYPE_DESC = UI_M_DS_TYPE_DESC;
	}

	public String getDS_END_TYPE() {
		return DS_END_TYPE;
	}

	public void setDS_END_TYPE(String DS_END_TYPE) {
		this.DS_END_TYPE = DS_END_TYPE;
	}

	public String getDS_CODE() {
		return DS_CODE;
	}

	public void setDS_CODE(String DS_CODE) {
		this.DS_CODE = DS_CODE;
	}

	public String getDS_DESC() {
		return DS_DESC;
	}

	public void setDS_DESC(String DS_DESC) {
		this.DS_DESC = DS_DESC;
	}

	public String getDS_POL_CODE() {
		return DS_POL_CODE;
	}

	public void setDS_POL_CODE(String DS_POL_CODE) {
		this.DS_POL_CODE = DS_POL_CODE;
	}

	public String getDS_SHORT_DESC() {
		return DS_SHORT_DESC;
	}

	public void setDS_SHORT_DESC(String DS_SHORT_DESC) {
		this.DS_SHORT_DESC = DS_SHORT_DESC;
	}

	public String getDS_USE_SEQ_YN() {
		return DS_USE_SEQ_YN;
	}

	public void setDS_USE_SEQ_YN(String DS_USE_SEQ_YN) {
		this.DS_USE_SEQ_YN = DS_USE_SEQ_YN;
	}

	public String getDS_CURR_RATE_BS() {
		return DS_CURR_RATE_BS;
	}

	public void setDS_CURR_RATE_BS(String DS_CURR_RATE_BS) {
		this.DS_CURR_RATE_BS = DS_CURR_RATE_BS;
	}

	public Date getDS_EFF_FM_DT() {
		 return DS_EFF_FM_DT;
	}

	public void setDS_EFF_FM_DT(Date DS_EFF_FM_DT) {
		this.DS_EFF_FM_DT = DS_EFF_FM_DT;
	}

	public Date getDS_EFF_TO_DT() {
		 return DS_EFF_TO_DT;
	}

	public void setDS_EFF_TO_DT(Date DS_EFF_TO_DT) {
		this.DS_EFF_TO_DT = DS_EFF_TO_DT;
	}

	public String getDS_POST_BO() {
		return DS_POST_BO;
	}

	public void setDS_POST_BO(String DS_POST_BO) {
		this.DS_POST_BO = DS_POST_BO;
	}

	public String getDS_BROKER_YN() {
		return DS_BROKER_YN;
	}

	public void setDS_BROKER_YN(String DS_BROKER_YN) {
		this.DS_BROKER_YN = DS_BROKER_YN;
	}

	public String getDS_PRN_BEFORE_APPR() {
		return DS_PRN_BEFORE_APPR;
	}

	public void setDS_PRN_BEFORE_APPR(String DS_PRN_BEFORE_APPR) {
		this.DS_PRN_BEFORE_APPR = DS_PRN_BEFORE_APPR;
	}

	public String getDS_REPRINT_YN() {
		return DS_REPRINT_YN;
	}

	public void setDS_REPRINT_YN(String DS_REPRINT_YN) {
		this.DS_REPRINT_YN = DS_REPRINT_YN;
	}

	public String getDS_AGE_RECALC_YN() {
		return DS_AGE_RECALC_YN;
	}

	public void setDS_AGE_RECALC_YN(String DS_AGE_RECALC_YN) {
		this.DS_AGE_RECALC_YN = DS_AGE_RECALC_YN;
	}

	public String getDS_BL_DESC() {
		return DS_BL_DESC;
	}

	public void setDS_BL_DESC(String DS_BL_DESC) {
		this.DS_BL_DESC = DS_BL_DESC;
	}

	public String getDS_BL_SHORT_DESC() {
		return DS_BL_SHORT_DESC;
	}

	public void setDS_BL_SHORT_DESC(String DS_BL_SHORT_DESC) {
		this.DS_BL_SHORT_DESC = DS_BL_SHORT_DESC;
	}

	public String getDS_FUND_TYPE() {
		return DS_FUND_TYPE;
	}

	public void setDS_FUND_TYPE(String DS_FUND_TYPE) {
		this.DS_FUND_TYPE = DS_FUND_TYPE;
	}

	public String getDS_REFUND_PREM_FLAG() {
		return DS_REFUND_PREM_FLAG;
	}

	public void setDS_REFUND_PREM_FLAG(String DS_REFUND_PREM_FLAG) {
		this.DS_REFUND_PREM_FLAG = DS_REFUND_PREM_FLAG;
	}

	public String getDS_REFUND_SURPLUS_FLAG() {
		return DS_REFUND_SURPLUS_FLAG;
	}

	public void setDS_REFUND_SURPLUS_FLAG(String DS_REFUND_SURPLUS_FLAG) {
		this.DS_REFUND_SURPLUS_FLAG = DS_REFUND_SURPLUS_FLAG;
	}

	public String getDS_REFUND_DEP_FLAG() {
		return DS_REFUND_DEP_FLAG;
	}

	public void setDS_REFUND_DEP_FLAG(String DS_REFUND_DEP_FLAG) {
		this.DS_REFUND_DEP_FLAG = DS_REFUND_DEP_FLAG;
	}

	public String getDS_RECVR_CHRG_FLAG() {
		return DS_RECVR_CHRG_FLAG;
	}

	public void setDS_RECVR_CHRG_FLAG(String DS_RECVR_CHRG_FLAG) {
		this.DS_RECVR_CHRG_FLAG = DS_RECVR_CHRG_FLAG;
	}

	public String getDS_RECVR_MEDFEE_YN() {
		return DS_RECVR_MEDFEE_YN;
	}

	public void setDS_RECVR_MEDFEE_YN(String DS_RECVR_MEDFEE_YN) {
		this.DS_RECVR_MEDFEE_YN = DS_RECVR_MEDFEE_YN;
	}

	public String getDS_RECVR_COMM_FLAG() {
		return DS_RECVR_COMM_FLAG;
	}

	public void setDS_RECVR_COMM_FLAG(String DS_RECVR_COMM_FLAG) {
		this.DS_RECVR_COMM_FLAG = DS_RECVR_COMM_FLAG;
	}

	public String getDS_CLM_PARSET() {
		return DS_CLM_PARSET;
	}

	public void setDS_CLM_PARSET(String DS_CLM_PARSET) {
		this.DS_CLM_PARSET = DS_CLM_PARSET;
	}

	public String getUI_M_DS_CLM_PARSET_DESC() {
		return UI_M_DS_CLM_PARSET_DESC;
	}

	public void setUI_M_DS_CLM_PARSET_DESC(String UI_M_DS_CLM_PARSET_DESC) {
		this.UI_M_DS_CLM_PARSET_DESC = UI_M_DS_CLM_PARSET_DESC;
	}

	public String getDS_CLM_FULSET() {
		return DS_CLM_FULSET;
	}

	public void setDS_CLM_FULSET(String DS_CLM_FULSET) {
		this.DS_CLM_FULSET = DS_CLM_FULSET;
	}

	public String getUI_M_DS_CLM_FULSET_DESC() {
		return UI_M_DS_CLM_FULSET_DESC;
	}

	public void setUI_M_DS_CLM_FULSET_DESC(String UI_M_DS_CLM_FULSET_DESC) {
		this.UI_M_DS_CLM_FULSET_DESC = UI_M_DS_CLM_FULSET_DESC;
	}

	public String getDS_FRZ_FLAG() {
		return DS_FRZ_FLAG;
	}

	public void setDS_FRZ_FLAG(String ds_frz_flag) {
		DS_FRZ_FLAG = ds_frz_flag;
	}

	public String getDS_END_TYPE_DESC() {
		return DS_END_TYPE_DESC;
	}

	public void setDS_END_TYPE_DESC(String ds_end_type_desc) {
		DS_END_TYPE_DESC = ds_end_type_desc;
	}

	public String getDS_POL_CODE_DESC() {
		return DS_POL_CODE_DESC;
	}

	public void setDS_POL_CODE_DESC(String ds_pol_code_desc) {
		DS_POL_CODE_DESC = ds_pol_code_desc;
	}

	public String getUI_M_CALC_METHOD() {
		return UI_M_CALC_METHOD;
	}

	public void setUI_M_CALC_METHOD(String ui_m_calc_method) {
		UI_M_CALC_METHOD = ui_m_calc_method;
	}

	public String getDS_CR_UID() {
		return DS_CR_UID;
	}

	public void setDS_CR_UID(String ds_cr_uid) {
		DS_CR_UID = ds_cr_uid;
	}

	public boolean isRendered() {
		System.out.println("IS REndered Called"+rendered);		
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public boolean isCheckBox() {
		return checkBox;
	}

	public void setCheckBox(boolean checkBox) {
		this.checkBox = checkBox;
	}

	public String getUI_M_DS_END_DESC() {
		return UI_M_DS_END_DESC;
	}

	public void setUI_M_DS_END_DESC(String ui_m_ds_end_desc) {
		UI_M_DS_END_DESC = ui_m_ds_end_desc;
	}
}
