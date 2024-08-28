package com.iii.pel.forms.PILT039_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_RECEIPT_TRANS_DTL")
public class PILT039_APAC_BEAN extends BaseValueBean{

	
	@Column(name = "RTD_REASON_CODE")
	private String RTD_REASON_CODE;
	
	
	@Column(name = "RTD_RTH_SYS_ID")
	private int RTD_RTH_SYS_ID;
	
	@Column(name="RTD_SYS_ID")
	private int  RTD_SYS_ID;
	
	public int getRTD_SYS_ID() {
		return RTD_SYS_ID;
	}

	public void setRTD_SYS_ID(int rTD_SYS_ID) {
		RTD_SYS_ID = rTD_SYS_ID;
	}
	
	public int getRTD_RTH_SYS_ID() {
		return RTD_RTH_SYS_ID;
	}

	public void setRTD_RTH_SYS_ID(int rTD_RTH_SYS_ID) {
		RTD_RTH_SYS_ID = rTD_RTH_SYS_ID;
	}

	private String RTD_REASON_CODE_DESC;
	
	@Column(name = "RTD_REV_REMARKS")
	private String RTD_REV_REMARKS;
	
	
	@Column(name = "RTD_TXN_CODE")
	private String RTD_TXN_CODE;
	
	@Column(name = "RTD_DOC_NO")
	private String RTD_DOC_NO;
	
	@Column(name = "RTD_DOC_DT")
	private Date RTD_DOC_DT;
	
	@Column(name = "RTD_ACNT_YR")
	private int RTD_ACNT_YR;
	
	private Date UI_M_POL_START_DT;
	
	private String POL_STRT_DATE;

	public String getPOL_STRT_DATE() {
		return POL_STRT_DATE;
	}

	public void setPOL_STRT_DATE(String pOL_STRT_DATE) {
		POL_STRT_DATE = pOL_STRT_DATE;
	}

	public Date getUI_M_POL_START_DT() {
		return UI_M_POL_START_DT;
	}

	public void setUI_M_POL_START_DT(Date uI_M_POL_START_DT) {
		UI_M_POL_START_DT = uI_M_POL_START_DT;
	}

	public String getRTD_REASON_CODE() {
		return RTD_REASON_CODE;
	}

	public void setRTD_REASON_CODE(String rTD_REASON_CODE) {
		RTD_REASON_CODE = rTD_REASON_CODE;
	}

	public String getRTD_REASON_CODE_DESC() {
		return RTD_REASON_CODE_DESC;
	}

	public void setRTD_REASON_CODE_DESC(String rTD_REASON_CODE_DESC) {
		RTD_REASON_CODE_DESC = rTD_REASON_CODE_DESC;
	}

	public String getRTD_REV_REMARKS() {
		return RTD_REV_REMARKS;
	}

	public void setRTD_REV_REMARKS(String rTD_REV_REMARKS) {
		RTD_REV_REMARKS = rTD_REV_REMARKS;
	}

	public String getRTD_TXN_CODE() {
		return RTD_TXN_CODE;
	}

	public void setRTD_TXN_CODE(String rTD_TXN_CODE) {
		RTD_TXN_CODE = rTD_TXN_CODE;
	}

	public String getRTD_DOC_NO() {
		return RTD_DOC_NO;
	}

	public void setRTD_DOC_NO(String rTD_DOC_NO) {
		RTD_DOC_NO = rTD_DOC_NO;
	}

	

	public Date getRTD_DOC_DT() {
		return RTD_DOC_DT;
	}

	public void setRTD_DOC_DT(Date rTD_DOC_DT) {
		RTD_DOC_DT = rTD_DOC_DT;
	}

	public int getRTD_ACNT_YR() {
		return RTD_ACNT_YR;
	}

	public void setRTD_ACNT_YR(int rTD_ACNT_YR) {
		RTD_ACNT_YR = rTD_ACNT_YR;
	}

	/*added by nadhiya*/
	
	
@Column(name="RTD_DEP_LC_AMT")
	private Double RTD_DEP_LC_AMT;
	
	@Column(name="RTD_TRNS_YN")
	private String RTD_TRNS_YN;
	
	private String WP_RTD_TXN_CODE;
	
	private String WP_POL_CUST_CODE;
	
	private String WP_CUST_NAME;
	
	public String getWP_POL_CUST_CODE() {
		return WP_POL_CUST_CODE;
	}

	public void setWP_POL_CUST_CODE(String wP_POL_CUST_CODE) {
		WP_POL_CUST_CODE = wP_POL_CUST_CODE;
	}

	public String getWP_CUST_NAME() {
		return WP_CUST_NAME;
	}

	public void setWP_CUST_NAME(String wP_CUST_NAME) {
		WP_CUST_NAME = wP_CUST_NAME;
	}

	public Double getRTD_DEP_LC_AMT() {
		return RTD_DEP_LC_AMT;
	}

	public void setRTD_DEP_LC_AMT(Double rTD_DEP_LC_AMT) {
		RTD_DEP_LC_AMT = rTD_DEP_LC_AMT;
	}

	public String getRTD_TRNS_YN() {
		return RTD_TRNS_YN;
	}

	public void setRTD_TRNS_YN(String rTD_TRNS_YN) {
		RTD_TRNS_YN = rTD_TRNS_YN;
	}

	private String WP_DOC_NO;
	
	
	private Date WP_DOC_DT;
	
	private String DOC_DT;
	
	private int WP_ACC_YEAR;
	
	private int WP_DEP_LC_DEP_AMT;
	
	private Double WP_TOT_RTD_DEP_LC_AMT;
	
	private int WP_TOT_SELECTED_AMT;


	public String getDOC_DT() {
		return DOC_DT;
	}

	public void setDOC_DT(String dOC_DT) {
		DOC_DT = dOC_DT;
	}

	public String getWP_RTD_TXN_CODE() {
		return WP_RTD_TXN_CODE;
	}

	public void setWP_RTD_TXN_CODE(String wP_RTD_TXN_CODE) {
		WP_RTD_TXN_CODE = wP_RTD_TXN_CODE;
	}

	public String getWP_DOC_NO() {
		return WP_DOC_NO;
	}

	public void setWP_DOC_NO(String wP_DOC_NO) {
		WP_DOC_NO = wP_DOC_NO;
	}

	public Date getWP_DOC_DT() {
		return WP_DOC_DT;
	}

	public void setWP_DOC_DT(Date wP_DOC_DT) {
		WP_DOC_DT = wP_DOC_DT;
	}

	public int getWP_ACC_YEAR() {
		return WP_ACC_YEAR;
	}

	public void setWP_ACC_YEAR(int wP_ACC_YEAR) {
		WP_ACC_YEAR = wP_ACC_YEAR;
	}

	public int getWP_DEP_LC_DEP_AMT() {
		return WP_DEP_LC_DEP_AMT;
	}

	public void setWP_DEP_LC_DEP_AMT(int wP_DEP_LC_DEP_AMT) {
		WP_DEP_LC_DEP_AMT = wP_DEP_LC_DEP_AMT;
	}

	/*public int getWP_TOT_RTD_DEP_LC_AMT() {
		return WP_TOT_RTD_DEP_LC_AMT;
	}

	public void setWP_TOT_RTD_DEP_LC_AMT(int wP_TOT_RTD_DEP_LC_AMT) {
		WP_TOT_RTD_DEP_LC_AMT = wP_TOT_RTD_DEP_LC_AMT;
	}*/

	public int getWP_TOT_SELECTED_AMT() {
		return WP_TOT_SELECTED_AMT;
	}

	public Double getWP_TOT_RTD_DEP_LC_AMT() {
		return WP_TOT_RTD_DEP_LC_AMT;
	}

	public void setWP_TOT_RTD_DEP_LC_AMT(Double wP_TOT_RTD_DEP_LC_AMT) {
		WP_TOT_RTD_DEP_LC_AMT = wP_TOT_RTD_DEP_LC_AMT;
	}

	public void setWP_TOT_SELECTED_AMT(int wP_TOT_SELECTED_AMT) {
		WP_TOT_SELECTED_AMT = wP_TOT_SELECTED_AMT;
	}
	
	private String status;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
}
