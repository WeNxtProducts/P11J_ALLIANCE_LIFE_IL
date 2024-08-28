package com.iii.pel.forms.PILM040;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_MASTER_POLICY")
public class PM_IL_MASTER_POLICY extends BaseValueBean {

	@Id
	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="MP_CUST_CODE")
	private String MP_CUST_CODE;

	private String UI_M_MP_CUST_CODE_DESC;

	@Column(name="MP_PROD_CODE")
	private String MP_PROD_CODE;

	private String UI_M_MP_PROD_CODE_DESC;

	@Column(name="MP_POL_NO")
	private String MP_POL_NO;

	@Column(name="MP_ISSUE_DT")
	private Date MP_ISSUE_DT;

	@Column(name="MP_POL_FM_DT")
	private Date MP_POL_FM_DT;

	@Column(name="MP_LC_MAX_TPD_BNF")
	private Double MP_LC_MAX_TPD_BNF;

	@Column(name="MP_PRE_TPD_BNF_MONTHS")
	private Integer MP_PRE_TPD_BNF_MONTHS;

	@Column(name="MP_LC_FUNERAL_EXP_LMT")
	private Double MP_LC_FUNERAL_EXP_LMT;

	@Column(name="MP_LC_FUNERAL_EXP_AMT")
	private Double MP_LC_FUNERAL_EXP_AMT;

	@Column(name="MP_CLM_INTM_DAYS")
	private Integer MP_CLM_INTM_DAYS;

	@Column(name="MP_NOTICE_PRD")
	private Integer MP_NOTICE_PRD;

	@Column(name="MP_LC_FCL")
	private Double MP_LC_FCL;

	@Column(name="MP_CR_DT")
	private Date MP_CR_DT;
	
	@Column(name="MP_CR_UID")
	private String MP_CR_UID;
	
	@Column(name="MP_UPD_DT")
	private Date MP_UPD_DT;
	
	@Column(name="MP_UPD_UID")
	private String MP_UPD_UID;
	
	private boolean checkBox;
	
	


	public boolean isCheckBox() {
		return checkBox;
	}

	public void setCheckBox(boolean checkBox) {
		this.checkBox = checkBox;
	}

	public String getMP_CUST_CODE() {
		return MP_CUST_CODE;
	}

	public void setMP_CUST_CODE(String MP_CUST_CODE) {
		this.MP_CUST_CODE = MP_CUST_CODE;
	}

	public String getUI_M_MP_CUST_CODE_DESC() {
		return UI_M_MP_CUST_CODE_DESC;
	}

	public void setUI_M_MP_CUST_CODE_DESC(String UI_M_MP_CUST_CODE_DESC) {
		this.UI_M_MP_CUST_CODE_DESC = UI_M_MP_CUST_CODE_DESC;
	}

	public String getMP_PROD_CODE() {
		return MP_PROD_CODE;
	}

	public void setMP_PROD_CODE(String MP_PROD_CODE) {
		this.MP_PROD_CODE = MP_PROD_CODE;
	}

	public String getUI_M_MP_PROD_CODE_DESC() {
		return UI_M_MP_PROD_CODE_DESC;
	}

	public void setUI_M_MP_PROD_CODE_DESC(String UI_M_MP_PROD_CODE_DESC) {
		this.UI_M_MP_PROD_CODE_DESC = UI_M_MP_PROD_CODE_DESC;
	}

	public String getMP_POL_NO() {
		return MP_POL_NO;
	}

	public void setMP_POL_NO(String MP_POL_NO) {
		this.MP_POL_NO = MP_POL_NO;
	}

	public Date getMP_ISSUE_DT() {
		 return MP_ISSUE_DT;
	}

	public void setMP_ISSUE_DT(Date MP_ISSUE_DT) {
		this.MP_ISSUE_DT = MP_ISSUE_DT;
	}

	public Date getMP_POL_FM_DT() {
		 return MP_POL_FM_DT;
	}

	public void setMP_POL_FM_DT(Date MP_POL_FM_DT) {
		this.MP_POL_FM_DT = MP_POL_FM_DT;
	}

	public Double getMP_LC_MAX_TPD_BNF() {
		return MP_LC_MAX_TPD_BNF;
	}

	public void setMP_LC_MAX_TPD_BNF(Double MP_LC_MAX_TPD_BNF) {
		this.MP_LC_MAX_TPD_BNF = MP_LC_MAX_TPD_BNF;
	}

	

	public Double getMP_LC_FUNERAL_EXP_LMT() {
		return MP_LC_FUNERAL_EXP_LMT;
	}

	public void setMP_LC_FUNERAL_EXP_LMT(Double MP_LC_FUNERAL_EXP_LMT) {
		this.MP_LC_FUNERAL_EXP_LMT = MP_LC_FUNERAL_EXP_LMT;
	}

	public Double getMP_LC_FUNERAL_EXP_AMT() {
		return MP_LC_FUNERAL_EXP_AMT;
	}

	public void setMP_LC_FUNERAL_EXP_AMT(Double MP_LC_FUNERAL_EXP_AMT) {
		this.MP_LC_FUNERAL_EXP_AMT = MP_LC_FUNERAL_EXP_AMT;
	}


	public Integer getMP_PRE_TPD_BNF_MONTHS() {
		return MP_PRE_TPD_BNF_MONTHS;
	}

	public void setMP_PRE_TPD_BNF_MONTHS(Integer mp_pre_tpd_bnf_months) {
		MP_PRE_TPD_BNF_MONTHS = mp_pre_tpd_bnf_months;
	}

	public Integer getMP_CLM_INTM_DAYS() {
		return MP_CLM_INTM_DAYS;
	}

	public void setMP_CLM_INTM_DAYS(Integer mp_clm_intm_days) {
		MP_CLM_INTM_DAYS = mp_clm_intm_days;
	}

	public Integer getMP_NOTICE_PRD() {
		return MP_NOTICE_PRD;
	}

	public void setMP_NOTICE_PRD(Integer mp_notice_prd) {
		MP_NOTICE_PRD = mp_notice_prd;
	}

	public Double getMP_LC_FCL() {
		return MP_LC_FCL;
	}

	public void setMP_LC_FCL(Double MP_LC_FCL) {
		this.MP_LC_FCL = MP_LC_FCL;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public Date getMP_CR_DT() {
		return MP_CR_DT;
	}

	public void setMP_CR_DT(Date mp_cr_dt) {
		MP_CR_DT = mp_cr_dt;
	}

	public String getMP_CR_UID() {
		return MP_CR_UID;
	}

	public void setMP_CR_UID(String mp_cr_uid) {
		MP_CR_UID = mp_cr_uid;
	}

	public Date getMP_UPD_DT() {
		return MP_UPD_DT;
	}

	public void setMP_UPD_DT(Date mp_upd_dt) {
		MP_UPD_DT = mp_upd_dt;
	}

	public String getMP_UPD_UID() {
		return MP_UPD_UID;
	}

	public void setMP_UPD_UID(String mp_upd_uid) {
		MP_UPD_UID = mp_upd_uid;
	}
}
