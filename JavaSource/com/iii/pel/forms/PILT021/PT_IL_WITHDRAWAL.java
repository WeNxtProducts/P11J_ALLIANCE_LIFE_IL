package com.iii.pel.forms.PILT021;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_WITHDRAWAL")
public class PT_IL_WITHDRAWAL extends BaseValueBean {

	@Column(name="WD_SYS_ID")
	private Long WD_SYS_ID;

	@Column(name="WD_POL_SYS_ID")
	private Long WD_POL_SYS_ID;

	@Column(name="WD_NUMBER")
	private Integer WD_NUMBER;

	@Column(name="WD_DATE")
	private Date WD_DATE;

	@Column(name="WD_RATE")
	private Double WD_RATE;

	@Column(name="WD_RATE_PER")
	private Double WD_RATE_PER;

	@Column(name="WD_GROSS_LC_VALUE")
	private Double WD_GROSS_LC_VALUE;

	@Column(name="WD_GROSS_FC_VALUE")
	private Double WD_GROSS_FC_VALUE;

	@Column(name="WD_NET_LC_VALUE")
	private Double WD_NET_LC_VALUE;

	@Column(name="WD_NET_FC_VALUE")
	private Double WD_NET_FC_VALUE;

	@Column(name="WD_APPRV_STATUS")
	private String WD_APPRV_STATUS;

	@Column(name="WD_CR_DT")
	private Date WD_CR_DT;

	@Column(name="WD_CR_UID")
	private String WD_CR_UID;

	@Column(name="WD_UPD_DT")
	private Date WD_UPD_DT;

	@Column(name="WD_UPD_UID")
	private String WD_UPD_UID;

	@Column(name="WD_TOPUP_LC_AMT")
	private Double WD_TOPUP_LC_AMT;

	@Column(name="WD_TOPUP_FC_AMT")
	private Double WD_TOPUP_FC_AMT;

	@Column(name="WD_TOPUP_INT_LC_AMT")
	private Double WD_TOPUP_INT_LC_AMT;

	@Column(name="WD_TOPUP_INT_FC_AMT")
	private Double WD_TOPUP_INT_FC_AMT;

	@Column(name="WD_POL_NO")
	private String WD_POL_NO;

	@Column(name="WD_AMOUNT_YN")
	private String WD_AMOUNT_YN;

	@Column(name="WD_TYPE")
	private String WD_TYPE;

	@Column(name="WD_STATUS_CODE")
	private String WD_STATUS_CODE;

	@Column(name="WD_STATUS_DT")
	private Date WD_STATUS_DT;

	@Column(name="WD_REASON_CODE")
	private String WD_REASON_CODE;

	@Column(name="WD_REMARKS")
	private String WD_REMARKS;

	@Column(name="WD_PREM_TXN_CODE")
	private String WD_PREM_TXN_CODE;

	@Column(name="WD_PREM_DOC_NO")
	private Long WD_PREM_DOC_NO;

	@Column(name="WD_TOP_UP_TXN_CODE")
	private String WD_TOP_UP_TXN_CODE;

	@Column(name="WD_TOP_UP_DOC_NO")
	private Long WD_TOP_UP_DOC_NO;

	@Column(name="WD_DOC_DT")
	private Date WD_DOC_DT;

	@Column(name="WD_NET_TOP_UP_FC_VALUE")
	private Double WD_NET_TOP_UP_FC_VALUE;

	@Column(name="WD_NET_TOP_UP_LC_VALUE")
	private Double WD_NET_TOP_UP_LC_VALUE;

	@Column(name="WD_FULL_YN")
	private String WD_FULL_YN;

	@Column(name="WD_FLEX_01")
	private String WD_FLEX_01;

	@Column(name="WD_AMT1")
	private Double WD_AMT1;

	@Column(name="WD_APPRV_UID")
	private String WD_APPRV_UID;

	@Column(name="WD_APPRV_DT")
	private Date WD_APPRV_DT;

	@Column(name="WD_DOC_NO")
	private String WD_DOC_NO;

	@Column(name="WD_PAY_TO")
	private String WD_PAY_TO;

	private String UI_M_POL_NO;
	private Date UI_M_APPRV_DT;
	private Date UI_M_POL_ISSUE_DT;
	private String UI_M_POL_CUST_CODE;
	private String UI_M_POL_CUST_NAME;
	private Double UI_M_RED_SUM_ASSURED;
	
	@Column(name="WD_FLEX_04")
	private String WD_FLEX_04;
	@Column(name="WD_FLEX_05")
	private String WD_FLEX_05;
	@Column(name="WD_FLEX_06")
	private String WD_FLEX_06;
	
	public void setWD_UPD_DT(Date WD_UPD_DT) {
		this.WD_UPD_DT = WD_UPD_DT;
	}
	public Date getWD_UPD_DT() {
		 return WD_UPD_DT;
	}
	public void setWD_TOPUP_INT_LC_AMT(Double WD_TOPUP_INT_LC_AMT) {
		this.WD_TOPUP_INT_LC_AMT = WD_TOPUP_INT_LC_AMT;
	}
	public Double getWD_TOPUP_INT_LC_AMT() {
		 return WD_TOPUP_INT_LC_AMT;
	}
	public void setWD_APPRV_UID(String WD_APPRV_UID) {
		this.WD_APPRV_UID = WD_APPRV_UID;
	}
	public String getWD_APPRV_UID() {
		 return WD_APPRV_UID;
	}
	public void setWD_POL_SYS_ID(Long WD_POL_SYS_ID) {
		this.WD_POL_SYS_ID = WD_POL_SYS_ID;
	}
	public Long getWD_POL_SYS_ID() {
		 return WD_POL_SYS_ID;
	}
	public void setWD_APPRV_STATUS(String WD_APPRV_STATUS) {
		this.WD_APPRV_STATUS = WD_APPRV_STATUS;
	}
	public String getWD_APPRV_STATUS() {
		 return WD_APPRV_STATUS;
	}
	public void setWD_STATUS_CODE(String WD_STATUS_CODE) {
		this.WD_STATUS_CODE = WD_STATUS_CODE;
	}
	public String getWD_STATUS_CODE() {
		 return WD_STATUS_CODE;
	}
	public void setWD_REMARKS(String WD_REMARKS) {
		this.WD_REMARKS = WD_REMARKS;
	}
	public String getWD_REMARKS() {
		 return WD_REMARKS;
	}
	public void setWD_TOPUP_INT_FC_AMT(Double WD_TOPUP_INT_FC_AMT) {
		this.WD_TOPUP_INT_FC_AMT = WD_TOPUP_INT_FC_AMT;
	}
	public Double getWD_TOPUP_INT_FC_AMT() {
		 return WD_TOPUP_INT_FC_AMT;
	}
	public void setWD_FLEX_01(String WD_FLEX_01) {
		this.WD_FLEX_01 = WD_FLEX_01;
	}
	public String getWD_FLEX_01() {
		 return WD_FLEX_01;
	}
	public void setWD_CR_DT(Date WD_CR_DT) {
		this.WD_CR_DT = WD_CR_DT;
	}
	public Date getWD_CR_DT() {
		 return WD_CR_DT;
	}
	public void setWD_DATE(Date WD_DATE) {
		this.WD_DATE = WD_DATE;
	}
	public Date getWD_DATE() {
		 return WD_DATE;
	}
	
	public void setWD_NET_FC_VALUE(Double WD_NET_FC_VALUE) {
		this.WD_NET_FC_VALUE = WD_NET_FC_VALUE;
	}
	public Double getWD_NET_FC_VALUE() {
		 return WD_NET_FC_VALUE;
	}
	public void setUI_M_POL_CUST_CODE(String UI_M_POL_CUST_CODE) {
		this.UI_M_POL_CUST_CODE = UI_M_POL_CUST_CODE;
	}
	public String getUI_M_POL_CUST_CODE() {
		 return UI_M_POL_CUST_CODE;
	}
	
	public Long getWD_PREM_DOC_NO() {
		return WD_PREM_DOC_NO;
	}
	public void setWD_PREM_DOC_NO(Long wd_prem_doc_no) {
		WD_PREM_DOC_NO = wd_prem_doc_no;
	}
	public Long getWD_TOP_UP_DOC_NO() {
		return WD_TOP_UP_DOC_NO;
	}
	public void setWD_TOP_UP_DOC_NO(Long wd_top_up_doc_no) {
		WD_TOP_UP_DOC_NO = wd_top_up_doc_no;
	}
	public void setWD_AMT1(Double WD_AMT1) {
		this.WD_AMT1 = WD_AMT1;
	}
	public Double getWD_AMT1() {
		 return WD_AMT1;
	}
	public void setWD_GROSS_FC_VALUE(Double WD_GROSS_FC_VALUE) {
		this.WD_GROSS_FC_VALUE = WD_GROSS_FC_VALUE;
	}
	public Double getWD_GROSS_FC_VALUE() {
		 return WD_GROSS_FC_VALUE;
	}
	public void setWD_APPRV_DT(Date WD_APPRV_DT) {
		this.WD_APPRV_DT = WD_APPRV_DT;
	}
	public Date getWD_APPRV_DT() {
		 return WD_APPRV_DT;
	}
	public void setWD_POL_NO(String WD_POL_NO) {
		this.WD_POL_NO = WD_POL_NO;
	}
	public String getWD_POL_NO() {
		 return WD_POL_NO;
	}
	public void setWD_DOC_DT(Date WD_DOC_DT) {
		this.WD_DOC_DT = WD_DOC_DT;
	}
	public Date getWD_DOC_DT() {
		 return WD_DOC_DT;
	}
	public void setWD_REASON_CODE(String WD_REASON_CODE) {
		this.WD_REASON_CODE = WD_REASON_CODE;
	}
	public String getWD_REASON_CODE() {
		 return WD_REASON_CODE;
	}
	public void setWD_UPD_UID(String WD_UPD_UID) {
		this.WD_UPD_UID = WD_UPD_UID;
	}
	public String getWD_UPD_UID() {
		 return WD_UPD_UID;
	}
	public void setWD_TOPUP_LC_AMT(Double WD_TOPUP_LC_AMT) {
		this.WD_TOPUP_LC_AMT = WD_TOPUP_LC_AMT;
	}
	public Double getWD_TOPUP_LC_AMT() {
		 return WD_TOPUP_LC_AMT;
	}
	public void setWD_NET_LC_VALUE(Double WD_NET_LC_VALUE) {
		this.WD_NET_LC_VALUE = WD_NET_LC_VALUE;
	}
	public Double getWD_NET_LC_VALUE() {
		 return WD_NET_LC_VALUE;
	}
	public void setWD_RATE_PER(Double WD_RATE_PER) {
		this.WD_RATE_PER = WD_RATE_PER;
	}
	public Double getWD_RATE_PER() {
		 return WD_RATE_PER;
	}
	public void setWD_TOP_UP_TXN_CODE(String WD_TOP_UP_TXN_CODE) {
		this.WD_TOP_UP_TXN_CODE = WD_TOP_UP_TXN_CODE;
	}
	public String getWD_TOP_UP_TXN_CODE() {
		 return WD_TOP_UP_TXN_CODE;
	}
	public void setWD_RATE(Double WD_RATE) {
		this.WD_RATE = WD_RATE;
	}
	public Double getWD_RATE() {
		 return WD_RATE;
	}
	public void setWD_TYPE(String WD_TYPE) {
		this.WD_TYPE = WD_TYPE;
	}
	public String getWD_TYPE() {
		 return WD_TYPE;
	}
	public void setWD_PAY_TO(String WD_PAY_TO) {
		this.WD_PAY_TO = WD_PAY_TO;
	}
	public String getWD_PAY_TO() {
		 return WD_PAY_TO;
	}
	public void setWD_NET_TOP_UP_FC_VALUE(Double WD_NET_TOP_UP_FC_VALUE) {
		this.WD_NET_TOP_UP_FC_VALUE = WD_NET_TOP_UP_FC_VALUE;
	}
	public Double getWD_NET_TOP_UP_FC_VALUE() {
		 return WD_NET_TOP_UP_FC_VALUE;
	}
	public void setWD_NUMBER(Integer WD_NUMBER) {
		this.WD_NUMBER = WD_NUMBER;
	}
	public Integer getWD_NUMBER() {
		 return WD_NUMBER;
	}
	public void setWD_TOPUP_FC_AMT(Double WD_TOPUP_FC_AMT) {
		this.WD_TOPUP_FC_AMT = WD_TOPUP_FC_AMT;
	}
	public Double getWD_TOPUP_FC_AMT() {
		 return WD_TOPUP_FC_AMT;
	}
	public void setWD_AMOUNT_YN(String WD_AMOUNT_YN) {
		this.WD_AMOUNT_YN = WD_AMOUNT_YN;
	}
	public String getWD_AMOUNT_YN() {
		 return WD_AMOUNT_YN;
	}
	public void setWD_PREM_TXN_CODE(String WD_PREM_TXN_CODE) {
		this.WD_PREM_TXN_CODE = WD_PREM_TXN_CODE;
	}
	public String getWD_PREM_TXN_CODE() {
		 return WD_PREM_TXN_CODE;
	}
	public void setWD_CR_UID(String WD_CR_UID) {
		this.WD_CR_UID = WD_CR_UID;
	}
	public String getWD_CR_UID() {
		 return WD_CR_UID;
	}
	public void setWD_FULL_YN(String WD_FULL_YN) {
		this.WD_FULL_YN = WD_FULL_YN;
	}
	public String getWD_FULL_YN() {
		 return WD_FULL_YN;
	}
	public void setUI_M_RED_SUM_ASSURED(Double UI_M_RED_SUM_ASSURED) {
		this.UI_M_RED_SUM_ASSURED = UI_M_RED_SUM_ASSURED;
	}
	public Double getUI_M_RED_SUM_ASSURED() {
		 return UI_M_RED_SUM_ASSURED;
	}
	public void setWD_NET_TOP_UP_LC_VALUE(Double WD_NET_TOP_UP_LC_VALUE) {
		this.WD_NET_TOP_UP_LC_VALUE = WD_NET_TOP_UP_LC_VALUE;
	}
	public Double getWD_NET_TOP_UP_LC_VALUE() {
		 return WD_NET_TOP_UP_LC_VALUE;
	}
	public void setUI_M_POL_CUST_NAME(String UI_M_POL_CUST_NAME) {
		this.UI_M_POL_CUST_NAME = UI_M_POL_CUST_NAME;
	}
	public String getUI_M_POL_CUST_NAME() {
		 return UI_M_POL_CUST_NAME;
	}
	public void setUI_M_POL_NO(String UI_M_POL_NO) {
		this.UI_M_POL_NO = UI_M_POL_NO;
	}
	public String getUI_M_POL_NO() {
		 return UI_M_POL_NO;
	}
	public void setWD_STATUS_DT(Date WD_STATUS_DT) {
		this.WD_STATUS_DT = WD_STATUS_DT;
	}
	public Date getWD_STATUS_DT() {
		 return WD_STATUS_DT;
	}
	public void setUI_M_POL_ISSUE_DT(Date UI_M_POL_ISSUE_DT) {
		this.UI_M_POL_ISSUE_DT = UI_M_POL_ISSUE_DT;
	}
	public Date getUI_M_POL_ISSUE_DT() {
		 return UI_M_POL_ISSUE_DT;
	}
	public void setWD_SYS_ID(Long WD_SYS_ID) {
		this.WD_SYS_ID = WD_SYS_ID;
	}
	public Long getWD_SYS_ID() {
		 return WD_SYS_ID;
	}
	public void setWD_DOC_NO(String WD_DOC_NO) {
		this.WD_DOC_NO = WD_DOC_NO;
	}
	public String getWD_DOC_NO() {
		 return WD_DOC_NO;
	}
	public void setWD_GROSS_LC_VALUE(Double WD_GROSS_LC_VALUE) {
		this.WD_GROSS_LC_VALUE = WD_GROSS_LC_VALUE;
	}
	public Double getWD_GROSS_LC_VALUE() {
		 return WD_GROSS_LC_VALUE;
	}
	public void setUI_M_APPRV_DT(Date UI_M_APPRV_DT) {
		this.UI_M_APPRV_DT = UI_M_APPRV_DT;
	}
	public Date getUI_M_APPRV_DT() {
		 return UI_M_APPRV_DT;
	}
	public String getWD_FLEX_04() {
		return WD_FLEX_04;
	}
	public void setWD_FLEX_04(String wd_flex_04) {
		WD_FLEX_04 = wd_flex_04;
	}
	public String getWD_FLEX_05() {
		return WD_FLEX_05;
	}
	public void setWD_FLEX_05(String wd_flex_05) {
		WD_FLEX_05 = wd_flex_05;
	}
	public String getWD_FLEX_06() {
		return WD_FLEX_06;
	}
	public void setWD_FLEX_06(String wd_flex_06) {
		WD_FLEX_06 = wd_flex_06;
	}
	
	/*Added by Ameen on 01-12-2017 for ZBLIFE-1458892*/
	@Column(name="WD_FLEX_07")
	private String WD_FLEX_07;
	
	@Column(name="WD_FLEX_08")
	private String WD_FLEX_08;
	
	@Column(name="WD_FLEX_09")
	private String WD_FLEX_09;
	
	@Column(name="WD_FLEX_10")
	private String WD_FLEX_10;
	
	@Column(name="WD_FLEX_11")
	private String WD_FLEX_11;
	
	@Column(name="WD_FLEX_12")
	private String WD_FLEX_12;
	
	private String UI_M_BANK_NAME;
	
	private String UI_M_DIVN_CODE;

	public String getWD_FLEX_07() {
		return WD_FLEX_07;
	}
	public void setWD_FLEX_07(String wD_FLEX_07) {
		WD_FLEX_07 = wD_FLEX_07;
	}
	public String getWD_FLEX_08() {
		return WD_FLEX_08;
	}
	public void setWD_FLEX_08(String wD_FLEX_08) {
		WD_FLEX_08 = wD_FLEX_08;
	}
	public String getWD_FLEX_09() {
		return WD_FLEX_09;
	}
	public void setWD_FLEX_09(String wD_FLEX_09) {
		WD_FLEX_09 = wD_FLEX_09;
	}
	public String getWD_FLEX_10() {
		return WD_FLEX_10;
	}
	public void setWD_FLEX_10(String wD_FLEX_10) {
		WD_FLEX_10 = wD_FLEX_10;
	}
	public String getWD_FLEX_11() {
		return WD_FLEX_11;
	}
	public void setWD_FLEX_11(String wD_FLEX_11) {
		WD_FLEX_11 = wD_FLEX_11;
	}
	public String getWD_FLEX_12() {
		return WD_FLEX_12;
	}
	public void setWD_FLEX_12(String wD_FLEX_12) {
		WD_FLEX_12 = wD_FLEX_12;
	}
	public String getUI_M_BANK_NAME() {
		return UI_M_BANK_NAME;
	}
	public void setUI_M_BANK_NAME(String uI_M_BANK_NAME) {
		UI_M_BANK_NAME = uI_M_BANK_NAME;
	}
	public String getUI_M_DIVN_CODE() {
		return UI_M_DIVN_CODE;
	}
	public void setUI_M_DIVN_CODE(String uI_M_DIVN_CODE) {
		UI_M_DIVN_CODE = uI_M_DIVN_CODE;
	}
	
	/*End*/
	
	/*Added by Janani on 16.01.2018 as per Gaurav's sugges.*/
	
	private String planType;

	private String prodIntrSavingsYN;

	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getProdIntrSavingsYN() {
		return prodIntrSavingsYN;
	}
	public void setProdIntrSavingsYN(String prodIntrSavingsYN) {
		this.prodIntrSavingsYN = prodIntrSavingsYN;
	}
	
	/*End*/
	
	/*Newly Field Added by saritha on 25-Jan-2018*/  
	
	@Column(name="WD_FLEX_03")
	private String WD_FLEX_03;

	public String getWD_FLEX_03() {
		return WD_FLEX_03;
	}
	public void setWD_FLEX_03(String wD_FLEX_03) {
		WD_FLEX_03 = wD_FLEX_03;
	}
	
	/*End*/
	
	/*Added by ganesh on 09-04-2018 for freeze flag field*/
	private boolean freezeFlag;
	
	@Column(name="WD_FRZ_FLAG")
	private String WD_FRZ_FLAG;

	public boolean isFreezeFlag() {
		return freezeFlag;
	}
	public void setFreezeFlag(boolean freezeFlag) {
		this.freezeFlag = freezeFlag;
	}
	public String getWD_FRZ_FLAG() {
		return WD_FRZ_FLAG;
	}
	public void setWD_FRZ_FLAG(String wD_FRZ_FLAG) {
		WD_FRZ_FLAG = wD_FRZ_FLAG;
		if(WD_FRZ_FLAG != null && WD_FRZ_FLAG.equals("Y")){
			freezeFlag = true;
		}else{
			freezeFlag = false;
		}
	}
	
	
	private String WD_APPR_DATE_STR;

	public String getWD_APPR_DATE_STR() {
		return WD_APPR_DATE_STR;
	}
	public void setWD_APPR_DATE_STR(String wD_APPR_DATE_STR) {
		WD_APPR_DATE_STR = wD_APPR_DATE_STR;
	}
	
	private String WD_CR_DATE_STR;

	public String getWD_CR_DATE_STR() {
		return WD_CR_DATE_STR;
	}
	public void setWD_CR_DATE_STR(String wD_CR_DATE_STR) {
		WD_CR_DATE_STR = wD_CR_DATE_STR;
	}
	/*end*/
}
