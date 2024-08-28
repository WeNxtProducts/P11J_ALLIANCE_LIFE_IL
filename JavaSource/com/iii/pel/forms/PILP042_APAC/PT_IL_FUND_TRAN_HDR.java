package com.iii.pel.forms.PILP042_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_FUND_TRAN_HDR")
public class PT_IL_FUND_TRAN_HDR extends BaseValueBean {

	private Date UI_M_APPRV_DT;

	@Column(name = "FTH_CR_UID")
	private String FTH_CR_UID;

	@Column(name = "FTH_APPRV_USER_ID")
	private String FTH_APPRV_USER_ID;

	@Column(name = "FTH_APPRV_STATUS")
	private String FTH_APPRV_STATUS;

	@Column(name = "FTH_POL_NO")
	private String FTH_POL_NO;

	@Column(name = "FTH_POL_SYS_ID")
	private Long FTH_POL_SYS_ID;

	@Column(name = "FTH_SYS_ID")
	private Long FTH_SYS_ID;

	@Column(name = "FTH_CR_DT")
	private Date FTH_CR_DT;

	private String UI_M_FTH_CUST_CODE;

	private String UI_M_FTH_CUST_NAME;

	private String UI_M_FTH_PROD_CODE;

	private String UI_M_FTH_PROD_DESC;

	@Column(name = "FTH_SWITCH_DT")
	private Date FTH_SWITCH_DT;

	@Column(name = "FTH_FEE_LC_AMT")
	private Double FTH_FEE_LC_AMT;

	@Column(name = "FTH_SEQ_NO")
	private Integer FTH_SEQ_NO;

	@Column(name = "FTH_REMARKS")
	private String FTH_REMARKS;

	public PT_IL_FUND_TRAN_HDR() {

		FTH_SWITCH_DT = new Date();

	}

	public Date getUI_M_APPRV_DT() {
		return UI_M_APPRV_DT;
	}

	public void setUI_M_APPRV_DT(Date UI_M_APPRV_DT) {
		this.UI_M_APPRV_DT = UI_M_APPRV_DT;
	}

	public String getFTH_POL_NO() {
		return FTH_POL_NO;
	}

	public void setFTH_POL_NO(String FTH_POL_NO) {
		this.FTH_POL_NO = FTH_POL_NO;
	}

	public String getUI_M_FTH_CUST_CODE() {
		return UI_M_FTH_CUST_CODE;
	}

	public void setUI_M_FTH_CUST_CODE(String UI_M_FTH_CUST_CODE) {
		this.UI_M_FTH_CUST_CODE = UI_M_FTH_CUST_CODE;
	}

	public String getUI_M_FTH_CUST_NAME() {
		return UI_M_FTH_CUST_NAME;
	}

	public void setUI_M_FTH_CUST_NAME(String UI_M_FTH_CUST_NAME) {
		this.UI_M_FTH_CUST_NAME = UI_M_FTH_CUST_NAME;
	}

	public String getUI_M_FTH_PROD_CODE() {
		return UI_M_FTH_PROD_CODE;
	}

	public void setUI_M_FTH_PROD_CODE(String UI_M_FTH_PROD_CODE) {
		this.UI_M_FTH_PROD_CODE = UI_M_FTH_PROD_CODE;
	}

	public String getUI_M_FTH_PROD_DESC() {
		return UI_M_FTH_PROD_DESC;
	}

	public void setUI_M_FTH_PROD_DESC(String UI_M_FTH_PROD_DESC) {
		this.UI_M_FTH_PROD_DESC = UI_M_FTH_PROD_DESC;
	}

	public Date getFTH_SWITCH_DT() {
		return FTH_SWITCH_DT;
	}

	public void setFTH_SWITCH_DT(Date FTH_SWITCH_DT) {
		this.FTH_SWITCH_DT = FTH_SWITCH_DT;
	}

	public Double getFTH_FEE_LC_AMT() {
		return FTH_FEE_LC_AMT;
	}

	public void setFTH_FEE_LC_AMT(Double FTH_FEE_LC_AMT) {
		this.FTH_FEE_LC_AMT = FTH_FEE_LC_AMT;
	}


	public Integer getFTH_SEQ_NO() {
		return FTH_SEQ_NO;
	}

	public void setFTH_SEQ_NO(Integer fth_seq_no) {
		FTH_SEQ_NO = fth_seq_no;
	}

	public String getFTH_REMARKS() {
		return FTH_REMARKS;
	}

	public void setFTH_REMARKS(String FTH_REMARKS) {
		this.FTH_REMARKS = FTH_REMARKS;
	}

	public Long getFTH_POL_SYS_ID() {
		return FTH_POL_SYS_ID;
	}

	public void setFTH_POL_SYS_ID(Long fth_pol_sys_id) {
		FTH_POL_SYS_ID = fth_pol_sys_id;
	}

	public Long getFTH_SYS_ID() {
		return FTH_SYS_ID;
	}

	public void setFTH_SYS_ID(Long fth_sys_id) {
		FTH_SYS_ID = fth_sys_id;
	}

	public String getFTH_CR_UID() {
		return FTH_CR_UID;
	}

	public void setFTH_CR_UID(String fth_cr_uid) {
		FTH_CR_UID = fth_cr_uid;
	}

	public Date getFTH_CR_DT() {
		return FTH_CR_DT;
	}

	public void setFTH_CR_DT(Date fth_cr_dt) {
		FTH_CR_DT = fth_cr_dt;
	}

	public String getFTH_APPRV_STATUS() {
		return FTH_APPRV_STATUS;
	}

	public void setFTH_APPRV_STATUS(String fth_apprv_status) {
		FTH_APPRV_STATUS = fth_apprv_status;
	}

	public String getFTH_APPRV_USER_ID() {
		return FTH_APPRV_USER_ID;
	}

	public void setFTH_APPRV_USER_ID(String fth_apprv_user_id) {
		FTH_APPRV_USER_ID = fth_apprv_user_id;
	}
}
