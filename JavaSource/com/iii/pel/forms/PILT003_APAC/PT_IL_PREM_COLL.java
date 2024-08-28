package com.iii.pel.forms.PILT003_APAC;

import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_PREM_COLL")
public class PT_IL_PREM_COLL extends BaseValueBean {

	@Column(name="PC_SYS_ID")
	private Long PC_SYS_ID;

	@Column(name="PC_POL_SYS_ID")
	private Long PC_POL_SYS_ID;

	@Column(name="PC_END_NO_IDX")
	private Double PC_END_NO_IDX;

	@Column(name="PC_SCHD_PYMT_DT")
	private Date PC_SCHD_PYMT_DT;
	
	private String UI_M_PC_SCHD_PYMT_DT;

	@Column(name="PC_PAID_DT")
	private Date PC_PAID_DT;

	@Column(name="PC_FACIN_YN")
	private String PC_FACIN_YN;

	@Column(name="PC_LC_GROSS_PREM")
	private Double PC_LC_GROSS_PREM;

	@Column(name="PC_FC_GROSS_PREM")
	private Double PC_FC_GROSS_PREM;

	@Column(name="PC_LC_DISCOUNT")
	private Double PC_LC_DISCOUNT;

	@Column(name="PC_FC_DISCOUNT")
	private Double PC_FC_DISCOUNT;

	@Column(name="PC_LC_CHARGE")
	private Double PC_LC_CHARGE;

	@Column(name="PC_FC_CHARGE")
	private Double PC_FC_CHARGE;

	@Column(name="PC_LC_FI_COMM")
	private Double PC_LC_FI_COMM;

	@Column(name="PC_FC_FI_COMM")
	private Double PC_FC_FI_COMM;

	@Column(name="PC_LC_FI_TAX")
	private Double PC_LC_FI_TAX;

	@Column(name="PC_FC_FI_TAX")
	private Double PC_FC_FI_TAX;

	@Column(name="PC_LC_FO_PREM")
	private Double PC_LC_FO_PREM;

	@Column(name="PC_FC_FO_PREM")
	private Double PC_FC_FO_PREM;
	
	private Double UI_M_TOL_LIMIT_AMT;

	@Column(name="PC_LC_FO_COMM")
	private Double PC_LC_FO_COMM;

	@Column(name="PC_FC_FO_COMM")
	private Double PC_FC_FO_COMM;

	@Column(name="PC_LC_FO_TAX")
	private Double PC_LC_FO_TAX;

	@Column(name="PC_FC_FO_TAX")
	private Double PC_FC_FO_TAX;

	@Column(name="PC_LC_FO_RETRO_PREM")
	private Double PC_LC_FO_RETRO_PREM;

	@Column(name="PC_FC_FO_RETRO_PREM")
	private Double PC_FC_FO_RETRO_PREM;
	
	private Double UI_M_PC_FC_OUTSTD_AMT;
	
	private Double UI_M_PC_LC_OUTSTD_AMT;
	
	private Double UI_M_PC_FC_OUTSTD_AMT_1;
	
	private Double UI_M_PC_LC_OUTSTD_AMT_1;
	

	@Column(name="PC_LC_FO_RETRO_COMM")
	private Double PC_LC_FO_RETRO_COMM;

	@Column(name="PC_FC_FO_RETRO_COMM")
	private Double PC_FC_FO_RETRO_COMM;

	@Column(name="PC_LC_FO_RETRO_TAX")
	private Double PC_LC_FO_RETRO_TAX;

	@Column(name="PC_FC_FO_RETRO_TAX")
	private Double PC_FC_FO_RETRO_TAX;

	@Column(name="PC_PREM_TYPE")
	private String PC_PREM_TYPE;

	@Column(name="PC_PAID_FLAG")
	private String PC_PAID_FLAG;

	@Column(name="PC_UNPAID_PREM")
	private String PC_UNPAID_PREM;

	@Column(name="PC_APPRV_DT")
	private Date PC_APPRV_DT;

	@Column(name="PC_FAC_CLOSE_FLAG")
	private String PC_FAC_CLOSE_FLAG;

	@Column(name="PC_RI_CLOSE_FLAG")
	private String PC_RI_CLOSE_FLAG;

	@Column(name="PC_CR_DT")
	private Date PC_CR_DT;

	@Column(name="PC_CR_UID")
	private String PC_CR_UID;

	@Column(name="PC_UPD_DT")
	private Date PC_UPD_DT;
	
	private Double UI_M_TOT_EXCESS_AMT;
	
	private Double UI_M_TOT_UTL_AMT;

	@Column(name="PC_UPD_UID")
	private String PC_UPD_UID;

	@Column(name="PC_UNPAID_PREM_INT_CODE")
	private String PC_UNPAID_PREM_INT_CODE;

	@Column(name="PC_FC_UNPAID_PREM_INT")
	private Double PC_FC_UNPAID_PREM_INT;

	@Column(name="PC_LC_UNPAID_PREM_INT")
	private Double PC_LC_UNPAID_PREM_INT;

	@Column(name="PC_OBJ_ID")
	private String PC_OBJ_ID;

	@Column(name="PC_OBJ_SYS_ID")
	private Long PC_OBJ_SYS_ID;

	@Column(name="PC_REF_NO")
	private String PC_REF_NO;

	@Column(name="PC_FC_AMAN_PREM")
	private Double PC_FC_AMAN_PREM;

	@Column(name="PC_LC_AMAN_PREM")
	private Double PC_LC_AMAN_PREM;

	@Column(name="PC_FC_SENABEL_PREM")
	private Double PC_FC_SENABEL_PREM;

	@Column(name="PC_LC_SENABEL_PREM")
	private Double PC_LC_SENABEL_PREM;

	@Column(name="PC_SURPLUS_CONSIDER_YN")
	private String PC_SURPLUS_CONSIDER_YN;

	@Column(name="PC_EMPLOYER_CODE")
	private String PC_EMPLOYER_CODE;

	@Column(name="PC_CONT_CODE")
	private String PC_CONT_CODE;

	@Column(name="PC_FC_BASIC_PREM")
	private Double PC_FC_BASIC_PREM;

	@Column(name="PC_LC_BASIC_PREM")
	private Double PC_LC_BASIC_PREM;

	@Column(name="PC_FC_ADDL_PREM")
	private Double PC_FC_ADDL_PREM;

	@Column(name="PC_LC_ADDL_PREM")
	private Double PC_LC_ADDL_PREM;

	@Column(name="PC_FC_LOAD_AMT")
	private Double PC_FC_LOAD_AMT;

	@Column(name="PC_LC_LOAD_AMT")
	private Double PC_LC_LOAD_AMT;

	@Column(name="PC_FC_CHARGE_AMT")
	private Double PC_FC_CHARGE_AMT;

	@Column(name="PC_LC_CHARGE_AMT")
	private Double PC_LC_CHARGE_AMT;

	@Column(name="PC_EXC_INT_PERC")
	private Double PC_EXC_INT_PERC;

	@Column(name="PC_FC_EXC_INT_AMT")
	private Double PC_FC_EXC_INT_AMT;

	@Column(name="PC_LC_EXC_INT_AMT")
	private Double PC_LC_EXC_INT_AMT;

	@Column(name="PC_FC_AVLB_BAL_AMT")
	private Double PC_FC_AVLB_BAL_AMT;

	@Column(name="PC_LC_AVLB_BAL_AMT")
	private Double PC_LC_AVLB_BAL_AMT;

	@Column(name="PC_FC_PAID_AMT")
	private Double PC_FC_PAID_AMT;

	@Column(name="PC_LC_PAID_AMT")
	private Double PC_LC_PAID_AMT;

	@Column(name="PC_DRIP_YN")
	private String PC_DRIP_YN;

	@Column(name="PC_TEMP_RCPT_NO")
	private String PC_TEMP_RCPT_NO;

	@Column(name="PC_DRCR_ACNT_YEAR")
	private Double PC_DRCR_ACNT_YEAR;

	@Column(name="PC_DRCR_TXN_CODE")
	private String PC_DRCR_TXN_CODE;

	@Column(name="PC_DRCR_DOC_NO")
	private Integer PC_DRCR_DOC_NO;

	@Column(name="PC_WAIVE_PREM_YN")
	private String PC_WAIVE_PREM_YN;
	
	@Column(name="PC_DRCR_DOC_DT")
	private Date PC_DRCR_DOC_DT;

	@Column(name="PC_COLL_TYPE")
	private String PC_COLL_TYPE;

	@Column(name="PC_DU_REF_ID")
	private String PC_DU_REF_ID;

	@Column(name="PC_FLEX_01")
	private String PC_FLEX_01;

	@Column(name="PC_FLEX_02")
	private String PC_FLEX_02;

	@Column(name="PC_FLEX_03")
	private String PC_FLEX_03;

	@Column(name="PC_FLEX_04")
	private String PC_FLEX_04;

	@Column(name="PC_FLEX_05")
	private String PC_FLEX_05;
	
	@Column(name="PC_FLEX_06")
	private String PC_FLEX_06;

	@Column(name="PC_UNIT_YN")
	private String PC_UNIT_YN;

	@Column(name="PC_PREM_HOLIDAY_YN")
	private String PC_PREM_HOLIDAY_YN;

	@Column(name="PC_RI_ALLOC_YN")
	private String PC_RI_ALLOC_YN;

	@Column(name="PC_DOC_NO")
	private String PC_DOC_NO;
	
	@Column(name="PC_LC_UNPAID_WAIVE_PREM_INT")
	private Double PC_LC_UNPAID_WAIVE_PREM_INT;
	
	@Column(name="PC_FC_UNPAID_WAIVE_PREM_INT")
	private Double PC_FC_UNPAID_WAIVE_PREM_INT;
	
	/*Added by Ram on 23/02/2017 for fetch Records by Statuswise*/
	private String POL_STS_FLAG;
	public String getPOL_STS_FLAG() {
		return POL_STS_FLAG;
	}
	public void setPOL_STS_FLAG(String pOL_STS_FLAG) {
		POL_STS_FLAG = pOL_STS_FLAG;
	}
	/*End*/

	
	/*Added by Ram on 05/03/2017 for DepRefId is null issue*/
	private Double OLD_PC_FC_PAID_AMT;
	public Double getOLD_PC_FC_PAID_AMT() {
		return OLD_PC_FC_PAID_AMT;
	}
	public void setOLD_PC_FC_PAID_AMT(Double oLD_PC_FC_PAID_AMT) {
		OLD_PC_FC_PAID_AMT = oLD_PC_FC_PAID_AMT;
	}
	/*End*/

	private Double UI_M_FC_NET_PREM = 0.0d;
	private Double UI_M_FC_LOAN_INT;
	private Double UI_M_LC_LOAN_INT;
	private Double UI_M_LC_NET_PREM;
	private Double UI_M_FC_TOT_AMT;
	private Double UI_M_LC_TOT_AMT;
	private Double UI_M_FC_TOT_DUE_AMT;
	private Double UI_M_LC_TOT_DUE_AMT;
	private Double UI_M_PREM_FC_TO_PAY;
	private Double UI_M_PREM_TO_PAY;
	private Double UI_M_PREM_FC_AMT;
	private Double UI_M_PREM_AMT;
	private Double UI_M_UTL_AMT;
	private Double UI_M_EXCESS_AMT;
	private Double UI_M_SHORT_AMT;
	private String UI_M_BASE_CURR_CODE;;
	private String UI_M_CODE_DESC;;
	public void setPC_UPD_UID(String PC_UPD_UID) {
		this.PC_UPD_UID = PC_UPD_UID;
	}
	public String getPC_UPD_UID() {
		 return PC_UPD_UID;
	}
	public void setPC_EMPLOYER_CODE(String PC_EMPLOYER_CODE) {
		this.PC_EMPLOYER_CODE = PC_EMPLOYER_CODE;
	}
	public String getPC_EMPLOYER_CODE() {
		 return PC_EMPLOYER_CODE;
	}
	public void setPC_END_NO_IDX(Double PC_END_NO_IDX) {
		this.PC_END_NO_IDX = PC_END_NO_IDX;
	}
	public Double getPC_END_NO_IDX() {
		 return PC_END_NO_IDX;
	}
	public void setPC_FACIN_YN(String PC_FACIN_YN) {
		this.PC_FACIN_YN = PC_FACIN_YN;
	}
	public String getPC_FACIN_YN() {
		 return PC_FACIN_YN;
	}
	public void setPC_DRCR_ACNT_YEAR(Double PC_DRCR_ACNT_YEAR) {
		this.PC_DRCR_ACNT_YEAR = PC_DRCR_ACNT_YEAR;
	}
	public Double getPC_DRCR_ACNT_YEAR() {
		 return PC_DRCR_ACNT_YEAR;
	}
	public void setPC_LC_FO_RETRO_PREM(Double PC_LC_FO_RETRO_PREM) {
		this.PC_LC_FO_RETRO_PREM = PC_LC_FO_RETRO_PREM;
	}
	public Double getPC_LC_FO_RETRO_PREM() {
		 return PC_LC_FO_RETRO_PREM;
	}
	public void setPC_FC_FO_COMM(Double PC_FC_FO_COMM) {
		this.PC_FC_FO_COMM = PC_FC_FO_COMM;
	}
	public Double getPC_FC_FO_COMM() {
		 return PC_FC_FO_COMM;
	}
	public void setPC_LC_SENABEL_PREM(Double PC_LC_SENABEL_PREM) {
		this.PC_LC_SENABEL_PREM = PC_LC_SENABEL_PREM;
	}
	public Double getPC_LC_SENABEL_PREM() {
		 return PC_LC_SENABEL_PREM;
	}
	public void setPC_LC_FO_PREM(Double PC_LC_FO_PREM) {
		this.PC_LC_FO_PREM = PC_LC_FO_PREM;
	}
	public Double getPC_LC_FO_PREM() {
		 return PC_LC_FO_PREM;
	}
	public void setPC_PAID_DT(Date PC_PAID_DT) {
		this.PC_PAID_DT = PC_PAID_DT;
	}
	public Date getPC_PAID_DT() {
		 return PC_PAID_DT;
	}
	public void setPC_DOC_NO(String PC_DOC_NO) {
		this.PC_DOC_NO = PC_DOC_NO;
	}
	public String getPC_DOC_NO() {
		 return PC_DOC_NO;
	}
	public void setPC_PREM_TYPE(String PC_PREM_TYPE) {
		this.PC_PREM_TYPE = PC_PREM_TYPE;
	}
	public String getPC_PREM_TYPE() {
		 return PC_PREM_TYPE;
	}
	public void setPC_FC_SENABEL_PREM(Double PC_FC_SENABEL_PREM) {
		this.PC_FC_SENABEL_PREM = PC_FC_SENABEL_PREM;
	}
	public Double getPC_FC_SENABEL_PREM() {
		 return PC_FC_SENABEL_PREM;
	}
	public void setPC_FC_PAID_AMT(Double PC_FC_PAID_AMT) {
		this.PC_FC_PAID_AMT = PC_FC_PAID_AMT;
	}
	public Double getPC_FC_PAID_AMT() {
		 return PC_FC_PAID_AMT;
	}
	public void setPC_UNPAID_PREM(String PC_UNPAID_PREM) {
		this.PC_UNPAID_PREM = PC_UNPAID_PREM;
	}
	public String getPC_UNPAID_PREM() {
		 return PC_UNPAID_PREM;
	}
	public void setPC_EXC_INT_PERC(Double PC_EXC_INT_PERC) {
		this.PC_EXC_INT_PERC = PC_EXC_INT_PERC;
	}
	public Double getPC_EXC_INT_PERC() {
		 return PC_EXC_INT_PERC;
	}
	public void setPC_CR_UID(String PC_CR_UID) {
		this.PC_CR_UID = PC_CR_UID;
	}
	public String getPC_CR_UID() {
		 return PC_CR_UID;
	}
	public void setPC_SYS_ID(Long PC_SYS_ID) {
		this.PC_SYS_ID = PC_SYS_ID;
	}
	public Long getPC_SYS_ID() {
		 return PC_SYS_ID;
	}
	public void setPC_REF_NO(String PC_REF_NO) {
		this.PC_REF_NO = PC_REF_NO;
	}
	public String getPC_REF_NO() {
		 return PC_REF_NO;
	}
	public void setPC_COLL_TYPE(String PC_COLL_TYPE) {
		this.PC_COLL_TYPE = PC_COLL_TYPE;
	}
	public String getPC_COLL_TYPE() {
		 return PC_COLL_TYPE;
	}
	public void setUI_M_PREM_FC_TO_PAY(Double UI_M_PREM_FC_TO_PAY) {
		this.UI_M_PREM_FC_TO_PAY = UI_M_PREM_FC_TO_PAY;
	}
	public Double getUI_M_PREM_FC_TO_PAY() {
		 return UI_M_PREM_FC_TO_PAY;
	}
	public void setPC_LC_CHARGE(Double PC_LC_CHARGE) {
		this.PC_LC_CHARGE = PC_LC_CHARGE;
	}
	public Double getPC_LC_CHARGE() {
		 return PC_LC_CHARGE;
	}
	public void setPC_FC_FO_PREM(Double PC_FC_FO_PREM) {
		this.PC_FC_FO_PREM = PC_FC_FO_PREM;
	}
	public Double getPC_FC_FO_PREM() {
		 return PC_FC_FO_PREM;
	}
	public void setPC_PAID_FLAG(String PC_PAID_FLAG) {
		this.PC_PAID_FLAG = PC_PAID_FLAG;
	}
	public String getPC_PAID_FLAG() {
		 return PC_PAID_FLAG;
	}
	public void setPC_LC_FI_COMM(Double PC_LC_FI_COMM) {
		this.PC_LC_FI_COMM = PC_LC_FI_COMM;
	}
	public Double getPC_LC_FI_COMM() {
		 return PC_LC_FI_COMM;
	}
	public void setPC_FC_CHARGE_AMT(Double PC_FC_CHARGE_AMT) {
		this.PC_FC_CHARGE_AMT = PC_FC_CHARGE_AMT;
	}
	public Double getPC_FC_CHARGE_AMT() {
		 return PC_FC_CHARGE_AMT;
	}
	public void setPC_CONT_CODE(String PC_CONT_CODE) {
		this.PC_CONT_CODE = PC_CONT_CODE;
	}
	public String getPC_CONT_CODE() {
		 return PC_CONT_CODE;
	}
	public void setPC_UNPAID_PREM_INT_CODE(String PC_UNPAID_PREM_INT_CODE) {
		this.PC_UNPAID_PREM_INT_CODE = PC_UNPAID_PREM_INT_CODE;
	}
	public String getPC_UNPAID_PREM_INT_CODE() {
		 return PC_UNPAID_PREM_INT_CODE;
	}
	public void setPC_LC_EXC_INT_AMT(Double PC_LC_EXC_INT_AMT) {
		this.PC_LC_EXC_INT_AMT = PC_LC_EXC_INT_AMT;
	}
	public Double getPC_LC_EXC_INT_AMT() {
		 return PC_LC_EXC_INT_AMT;
	}
	public void setPC_FC_FO_RETRO_COMM(Double PC_FC_FO_RETRO_COMM) {
		this.PC_FC_FO_RETRO_COMM = PC_FC_FO_RETRO_COMM;
	}
	public Double getPC_FC_FO_RETRO_COMM() {
		 return PC_FC_FO_RETRO_COMM;
	}
	public void setPC_LC_FI_TAX(Double PC_LC_FI_TAX) {
		this.PC_LC_FI_TAX = PC_LC_FI_TAX;
	}
	public Double getPC_LC_FI_TAX() {
		 return PC_LC_FI_TAX;
	}
	public void setPC_LC_FO_RETRO_TAX(Double PC_LC_FO_RETRO_TAX) {
		this.PC_LC_FO_RETRO_TAX = PC_LC_FO_RETRO_TAX;
	}
	public Double getPC_LC_FO_RETRO_TAX() {
		 return PC_LC_FO_RETRO_TAX;
	}
	public void setPC_DRCR_TXN_CODE(String PC_DRCR_TXN_CODE) {
		this.PC_DRCR_TXN_CODE = PC_DRCR_TXN_CODE;
	}
	public String getPC_DRCR_TXN_CODE() {
		 return PC_DRCR_TXN_CODE;
	}
	public void setPC_LC_GROSS_PREM(Double PC_LC_GROSS_PREM) {
		this.PC_LC_GROSS_PREM = PC_LC_GROSS_PREM;
	}
	public Double getPC_LC_GROSS_PREM() {
		 return PC_LC_GROSS_PREM;
	}
	public void setPC_LC_PAID_AMT(Double PC_LC_PAID_AMT) {
		this.PC_LC_PAID_AMT = PC_LC_PAID_AMT;
	}
	public Double getPC_LC_PAID_AMT() {
		 return PC_LC_PAID_AMT;
	}
	public void setPC_FAC_CLOSE_FLAG(String PC_FAC_CLOSE_FLAG) {
		this.PC_FAC_CLOSE_FLAG = PC_FAC_CLOSE_FLAG;
	}
	public String getPC_FAC_CLOSE_FLAG() {
		 return PC_FAC_CLOSE_FLAG;
	}
	public void setPC_FC_FO_TAX(Double PC_FC_FO_TAX) {
		this.PC_FC_FO_TAX = PC_FC_FO_TAX;
	}
	public Double getPC_FC_FO_TAX() {
		 return PC_FC_FO_TAX;
	}
	public void setPC_TEMP_RCPT_NO(String PC_TEMP_RCPT_NO) {
		this.PC_TEMP_RCPT_NO = PC_TEMP_RCPT_NO;
	}
	public String getPC_TEMP_RCPT_NO() {
		 return PC_TEMP_RCPT_NO;
	}
	public void setPC_PREM_HOLIDAY_YN(String PC_PREM_HOLIDAY_YN) {
		this.PC_PREM_HOLIDAY_YN = PC_PREM_HOLIDAY_YN;
	}
	public String getPC_PREM_HOLIDAY_YN() {
		 return PC_PREM_HOLIDAY_YN;
	}
	public void setPC_RI_ALLOC_YN(String PC_RI_ALLOC_YN) {
		this.PC_RI_ALLOC_YN = PC_RI_ALLOC_YN;
	}
	public String getPC_RI_ALLOC_YN() {
		 return PC_RI_ALLOC_YN;
	}
	public void setUI_M_LC_LOAN_INT(Double UI_M_LC_LOAN_INT) {
		this.UI_M_LC_LOAN_INT = UI_M_LC_LOAN_INT;
	}
	public Double getUI_M_LC_LOAN_INT() {
		 return UI_M_LC_LOAN_INT;
	}
	public void setPC_CR_DT(Date PC_CR_DT) {
		this.PC_CR_DT = PC_CR_DT;
	}
	public Date getPC_CR_DT() {
		 return PC_CR_DT;
	}
	public void setPC_APPRV_DT(Date PC_APPRV_DT) {
		this.PC_APPRV_DT = PC_APPRV_DT;
	}
	public Date getPC_APPRV_DT() {
		 return PC_APPRV_DT;
	}
	public void setPC_FC_AVLB_BAL_AMT(Double PC_FC_AVLB_BAL_AMT) {
		this.PC_FC_AVLB_BAL_AMT = PC_FC_AVLB_BAL_AMT;
	}
	public Double getPC_FC_AVLB_BAL_AMT() {
		 return PC_FC_AVLB_BAL_AMT;
	}
	public void setPC_LC_BASIC_PREM(Double PC_LC_BASIC_PREM) {
		this.PC_LC_BASIC_PREM = PC_LC_BASIC_PREM;
	}
	public Double getPC_LC_BASIC_PREM() {
		 return PC_LC_BASIC_PREM;
	}
	public void setPC_FC_CHARGE(Double PC_FC_CHARGE) {
		this.PC_FC_CHARGE = PC_FC_CHARGE;
	}
	public Double getPC_FC_CHARGE() {
		 return PC_FC_CHARGE;
	}
	public void setPC_FC_LOAD_AMT(Double PC_FC_LOAD_AMT) {
		this.PC_FC_LOAD_AMT = PC_FC_LOAD_AMT;
	}
	public Double getPC_FC_LOAD_AMT() {
		 return PC_FC_LOAD_AMT;
	}
	public void setPC_FC_GROSS_PREM(Double PC_FC_GROSS_PREM) {
		this.PC_FC_GROSS_PREM = PC_FC_GROSS_PREM;
	}
	public Double getPC_FC_GROSS_PREM() {
		 return PC_FC_GROSS_PREM;
	}
	public void setPC_UNIT_YN(String PC_UNIT_YN) {
		this.PC_UNIT_YN = PC_UNIT_YN;
	}
	public String getPC_UNIT_YN() {
		 return PC_UNIT_YN;
	}
	public void setPC_UPD_DT(Date PC_UPD_DT) {
		this.PC_UPD_DT = PC_UPD_DT;
	}
	public Date getPC_UPD_DT() {
		 return PC_UPD_DT;
	}
	public void setPC_OBJ_ID(String PC_OBJ_ID) {
		this.PC_OBJ_ID = PC_OBJ_ID;
	}
	public String getPC_OBJ_ID() {
		 return PC_OBJ_ID;
	}
	public void setPC_LC_ADDL_PREM(Double PC_LC_ADDL_PREM) {
		this.PC_LC_ADDL_PREM = PC_LC_ADDL_PREM;
	}
	public Double getPC_LC_ADDL_PREM() {
		 return PC_LC_ADDL_PREM;
	}
	public void setUI_M_PREM_FC_AMT(Double UI_M_PREM_FC_AMT) {
		this.UI_M_PREM_FC_AMT = UI_M_PREM_FC_AMT;
	}
	public Double getUI_M_PREM_FC_AMT() {
		 return UI_M_PREM_FC_AMT;
	}
	public void setPC_LC_LOAD_AMT(Double PC_LC_LOAD_AMT) {
		this.PC_LC_LOAD_AMT = PC_LC_LOAD_AMT;
	}
	public Double getPC_LC_LOAD_AMT() {
		 return PC_LC_LOAD_AMT;
	}
	public void setPC_FC_ADDL_PREM(Double PC_FC_ADDL_PREM) {
		this.PC_FC_ADDL_PREM = PC_FC_ADDL_PREM;
	}
	public Double getPC_FC_ADDL_PREM() {
		 return PC_FC_ADDL_PREM;
	}
	public void setPC_FC_BASIC_PREM(Double PC_FC_BASIC_PREM) {
		this.PC_FC_BASIC_PREM = PC_FC_BASIC_PREM;
	}
	public Double getPC_FC_BASIC_PREM() {
		 return PC_FC_BASIC_PREM;
	}
	public void setUI_M_LC_NET_PREM(Double UI_M_LC_NET_PREM) {
		this.UI_M_LC_NET_PREM = UI_M_LC_NET_PREM;
	}
	public Double getUI_M_LC_NET_PREM() {
		 return UI_M_LC_NET_PREM;
	}
	public void setPC_DRCR_DOC_DT(Date PC_DRCR_DOC_DT) {
		this.PC_DRCR_DOC_DT = PC_DRCR_DOC_DT;
	}
	public Date getPC_DRCR_DOC_DT() {
		 return PC_DRCR_DOC_DT;
	}
	public void setPC_FC_FO_RETRO_PREM(Double PC_FC_FO_RETRO_PREM) {
		this.PC_FC_FO_RETRO_PREM = PC_FC_FO_RETRO_PREM;
	}
	public Double getPC_FC_FO_RETRO_PREM() {
		 return PC_FC_FO_RETRO_PREM;
	}
	
	public void setPC_DRIP_YN(String PC_DRIP_YN) {
		this.PC_DRIP_YN = PC_DRIP_YN;
	}
	public String getPC_DRIP_YN() {
		 return PC_DRIP_YN;
	}
	public void setPC_FC_DISCOUNT(Double PC_FC_DISCOUNT) {
		this.PC_FC_DISCOUNT = PC_FC_DISCOUNT;
	}
	public Double getPC_FC_DISCOUNT() {
		 return PC_FC_DISCOUNT;
	}
	public void setPC_LC_AMAN_PREM(Double PC_LC_AMAN_PREM) {
		this.PC_LC_AMAN_PREM = PC_LC_AMAN_PREM;
	}
	public Double getPC_LC_AMAN_PREM() {
		 return PC_LC_AMAN_PREM;
	}
	public void setPC_FC_FI_COMM(Double PC_FC_FI_COMM) {
		this.PC_FC_FI_COMM = PC_FC_FI_COMM;
	}
	public Double getPC_FC_FI_COMM() {
		 return PC_FC_FI_COMM;
	}
	public void setPC_LC_FO_RETRO_COMM(Double PC_LC_FO_RETRO_COMM) {
		this.PC_LC_FO_RETRO_COMM = PC_LC_FO_RETRO_COMM;
	}
	public Double getPC_LC_FO_RETRO_COMM() {
		 return PC_LC_FO_RETRO_COMM;
	}
	public void setPC_POL_SYS_ID(Long PC_POL_SYS_ID) {
		this.PC_POL_SYS_ID = PC_POL_SYS_ID;
	}
	public Long getPC_POL_SYS_ID() {
		 return PC_POL_SYS_ID;
	}
	public void setPC_FC_FO_RETRO_TAX(Double PC_FC_FO_RETRO_TAX) {
		this.PC_FC_FO_RETRO_TAX = PC_FC_FO_RETRO_TAX;
	}
	public Double getPC_FC_FO_RETRO_TAX() {
		 return PC_FC_FO_RETRO_TAX;
	}
	public void setPC_LC_FO_TAX(Double PC_LC_FO_TAX) {
		this.PC_LC_FO_TAX = PC_LC_FO_TAX;
	}
	public Double getPC_LC_FO_TAX() {
		 return PC_LC_FO_TAX;
	}
	public void setPC_LC_FO_COMM(Double PC_LC_FO_COMM) {
		this.PC_LC_FO_COMM = PC_LC_FO_COMM;
	}
	public Double getPC_LC_FO_COMM() {
		 return PC_LC_FO_COMM;
	}
	public void setPC_FC_FI_TAX(Double PC_FC_FI_TAX) {
		this.PC_FC_FI_TAX = PC_FC_FI_TAX;
	}
	public Double getPC_FC_FI_TAX() {
		 return PC_FC_FI_TAX;
	}
	public void setPC_LC_CHARGE_AMT(Double PC_LC_CHARGE_AMT) {
		this.PC_LC_CHARGE_AMT = PC_LC_CHARGE_AMT;
	}
	public Double getPC_LC_CHARGE_AMT() {
		 return PC_LC_CHARGE_AMT;
	}
	public void setPC_DU_REF_ID(String PC_DU_REF_ID) {
		this.PC_DU_REF_ID = PC_DU_REF_ID;
	}
	public String getPC_DU_REF_ID() {
		 return PC_DU_REF_ID;
	}
	public void setUI_M_FC_LOAN_INT(Double UI_M_FC_LOAN_INT) {
		this.UI_M_FC_LOAN_INT = UI_M_FC_LOAN_INT;
	}
	public Double getUI_M_FC_LOAN_INT() {
		 return UI_M_FC_LOAN_INT;
	}
	public void setUI_M_FC_NET_PREM(Double UI_M_FC_NET_PREM) {
		this.UI_M_FC_NET_PREM = UI_M_FC_NET_PREM;
	}
	public Double getUI_M_FC_NET_PREM() {
		 return UI_M_FC_NET_PREM;
	}
	public void setPC_OBJ_SYS_ID(Long PC_OBJ_SYS_ID) {
		this.PC_OBJ_SYS_ID = PC_OBJ_SYS_ID;
	}
	public Long getPC_OBJ_SYS_ID() {
		 return PC_OBJ_SYS_ID;
	}
	public void setPC_SURPLUS_CONSIDER_YN(String PC_SURPLUS_CONSIDER_YN) {
		this.PC_SURPLUS_CONSIDER_YN = PC_SURPLUS_CONSIDER_YN;
	}
	public String getPC_SURPLUS_CONSIDER_YN() {
		 return PC_SURPLUS_CONSIDER_YN;
	}
	public void setPC_FC_UNPAID_PREM_INT(Double PC_FC_UNPAID_PREM_INT) {
		this.PC_FC_UNPAID_PREM_INT = PC_FC_UNPAID_PREM_INT;
	}
	public Double getPC_FC_UNPAID_PREM_INT() {
		 return PC_FC_UNPAID_PREM_INT;
	}
	public void setPC_LC_UNPAID_PREM_INT(Double PC_LC_UNPAID_PREM_INT) {
		this.PC_LC_UNPAID_PREM_INT = PC_LC_UNPAID_PREM_INT;
	}
	public Double getPC_LC_UNPAID_PREM_INT() {
		 return PC_LC_UNPAID_PREM_INT;
	}
	public void setPC_FC_AMAN_PREM(Double PC_FC_AMAN_PREM) {
		this.PC_FC_AMAN_PREM = PC_FC_AMAN_PREM;
	}
	public Double getPC_FC_AMAN_PREM() {
		 return PC_FC_AMAN_PREM;
	}
	public void setPC_FC_EXC_INT_AMT(Double PC_FC_EXC_INT_AMT) {
		this.PC_FC_EXC_INT_AMT = PC_FC_EXC_INT_AMT;
	}
	public Double getPC_FC_EXC_INT_AMT() {
		 return PC_FC_EXC_INT_AMT;
	}
	public void setPC_RI_CLOSE_FLAG(String PC_RI_CLOSE_FLAG) {
		this.PC_RI_CLOSE_FLAG = PC_RI_CLOSE_FLAG;
	}
	public String getPC_RI_CLOSE_FLAG() {
		 return PC_RI_CLOSE_FLAG;
	}
	public void setPC_LC_DISCOUNT(Double PC_LC_DISCOUNT) {
		this.PC_LC_DISCOUNT = PC_LC_DISCOUNT;
	}
	public Double getPC_LC_DISCOUNT() {
		 return PC_LC_DISCOUNT;
	}
	public void setPC_LC_AVLB_BAL_AMT(Double PC_LC_AVLB_BAL_AMT) {
		this.PC_LC_AVLB_BAL_AMT = PC_LC_AVLB_BAL_AMT;
	}
	public Double getPC_LC_AVLB_BAL_AMT() {
		 return PC_LC_AVLB_BAL_AMT;
	}
	public void setUI_M_PREM_AMT(Double UI_M_PREM_AMT) {
		this.UI_M_PREM_AMT = UI_M_PREM_AMT;
	}
	public Double getUI_M_PREM_AMT() {
		 return UI_M_PREM_AMT;
	}
	public void setPC_SCHD_PYMT_DT(Date PC_SCHD_PYMT_DT) {
		this.PC_SCHD_PYMT_DT = PC_SCHD_PYMT_DT;
		UI_M_PC_SCHD_PYMT_DT = CommonUtils.dateToPELStringFormatter(PC_SCHD_PYMT_DT);
	}
	public Date getPC_SCHD_PYMT_DT() {
		 return PC_SCHD_PYMT_DT;
	}
	public void setPC_FLEX_01(String PC_FLEX_01) {
		this.PC_FLEX_01 = PC_FLEX_01;
	}
	public String getPC_FLEX_01() {
		 return PC_FLEX_01;
	}
	public void setPC_FLEX_02(String PC_FLEX_02) {
		this.PC_FLEX_02 = PC_FLEX_02;
	}
	public String getPC_FLEX_02() {
		 return PC_FLEX_02;
	}
	public void setPC_FLEX_03(String PC_FLEX_03) {
		this.PC_FLEX_03 = PC_FLEX_03;
	}
	public String getPC_FLEX_03() {
		 return PC_FLEX_03;
	}
	public void setUI_M_PREM_TO_PAY(Double UI_M_PREM_TO_PAY) {
		this.UI_M_PREM_TO_PAY = UI_M_PREM_TO_PAY;
	}
	public Double getUI_M_PREM_TO_PAY() {
		 return UI_M_PREM_TO_PAY;
	}
	public void setPC_FLEX_04(String PC_FLEX_04) {
		this.PC_FLEX_04 = PC_FLEX_04;
	}
	public String getPC_FLEX_04() {
		 return PC_FLEX_04;
	}
	public void setPC_FLEX_05(String PC_FLEX_05) {
		this.PC_FLEX_05 = PC_FLEX_05;
	}
	public String getPC_FLEX_05() {
		 return PC_FLEX_05;
	}
	public Double getUI_M_TOT_EXCESS_AMT() {
		return UI_M_TOT_EXCESS_AMT;
	}
	public void setUI_M_TOT_EXCESS_AMT(Double ui_m_tot_excess_amt) {
		UI_M_TOT_EXCESS_AMT = ui_m_tot_excess_amt;
	}
	public Double getUI_M_TOT_UTL_AMT() {
		return UI_M_TOT_UTL_AMT;
	}
	public void setUI_M_TOT_UTL_AMT(Double ui_m_tot_utl_amt) {
		UI_M_TOT_UTL_AMT = ui_m_tot_utl_amt;
	}
	public Double getUI_M_TOL_LIMIT_AMT() {
		return UI_M_TOL_LIMIT_AMT;
	}
	public void setUI_M_TOL_LIMIT_AMT(Double ui_m_tol_limit_amt) {
		UI_M_TOL_LIMIT_AMT = ui_m_tol_limit_amt;
	}
	public String getUI_M_BASE_CURR_CODE() {
		return UI_M_BASE_CURR_CODE;
	}
	public void setUI_M_BASE_CURR_CODE(String ui_m_base_curr_code) {
		UI_M_BASE_CURR_CODE = ui_m_base_curr_code;
	}
	public Double getUI_M_FC_TOT_AMT() {
		return UI_M_FC_TOT_AMT;
	}
	public void setUI_M_FC_TOT_AMT(Double ui_m_fc_tot_amt) {
		UI_M_FC_TOT_AMT = ui_m_fc_tot_amt;
	}
	public Double getUI_M_LC_TOT_AMT() {
		return UI_M_LC_TOT_AMT;
	}
	public void setUI_M_LC_TOT_AMT(Double ui_m_lc_tot_amt) {
		UI_M_LC_TOT_AMT = ui_m_lc_tot_amt;
	}
	public Double getUI_M_FC_TOT_DUE_AMT() {
		return UI_M_FC_TOT_DUE_AMT;
	}
	public void setUI_M_FC_TOT_DUE_AMT(Double ui_m_fc_tot_due_amt) {
		UI_M_FC_TOT_DUE_AMT = ui_m_fc_tot_due_amt;
	}
	public Double getUI_M_LC_TOT_DUE_AMT() {
		return UI_M_LC_TOT_DUE_AMT;
	}
	public void setUI_M_LC_TOT_DUE_AMT(Double ui_m_lc_tot_due_amt) {
		UI_M_LC_TOT_DUE_AMT = ui_m_lc_tot_due_amt;
	}
	public Double getUI_M_UTL_AMT() {
		return UI_M_UTL_AMT;
	}
	public void setUI_M_UTL_AMT(Double ui_m_utl_amt) {
		UI_M_UTL_AMT = ui_m_utl_amt;
	}
	public Double getUI_M_EXCESS_AMT() {
		return UI_M_EXCESS_AMT;
	}
	public void setUI_M_EXCESS_AMT(Double ui_m_excess_amt) {
		UI_M_EXCESS_AMT = ui_m_excess_amt;
	}
	public Double getUI_M_SHORT_AMT() {
		return UI_M_SHORT_AMT;
	}
	public void setUI_M_SHORT_AMT(Double ui_m_short_amt) {
		UI_M_SHORT_AMT = ui_m_short_amt;
	}
	public String getUI_M_CODE_DESC() {
		return UI_M_CODE_DESC;
	}
	public void setUI_M_CODE_DESC(String ui_m_code_desc) {
		UI_M_CODE_DESC = ui_m_code_desc;
	}
	public String getUI_M_PC_SCHD_PYMT_DT() {
		return UI_M_PC_SCHD_PYMT_DT;
	}
	public void setUI_M_PC_SCHD_PYMT_DT(String ui_m_pc_schd_pymt_dt) {
		UI_M_PC_SCHD_PYMT_DT = ui_m_pc_schd_pymt_dt;
	}
	public Double getUI_M_PC_FC_OUTSTD_AMT() {
		return UI_M_PC_FC_OUTSTD_AMT;
	}
	public void setUI_M_PC_FC_OUTSTD_AMT(Double ui_m_pc_fc_outstd_amt) {
		UI_M_PC_FC_OUTSTD_AMT = ui_m_pc_fc_outstd_amt;
	}
	public Double getUI_M_PC_LC_OUTSTD_AMT() {
		return UI_M_PC_LC_OUTSTD_AMT;
	}
	public void setUI_M_PC_LC_OUTSTD_AMT(Double ui_m_pc_lc_outstd_amt) {
		UI_M_PC_LC_OUTSTD_AMT = ui_m_pc_lc_outstd_amt;
	}
	public Double getUI_M_PC_FC_OUTSTD_AMT_1() {
		return UI_M_PC_FC_OUTSTD_AMT_1;
	}
	public void setUI_M_PC_FC_OUTSTD_AMT_1(Double ui_m_pc_fc_outstd_amt_1) {
		UI_M_PC_FC_OUTSTD_AMT_1 = ui_m_pc_fc_outstd_amt_1;
	}
	public Double getUI_M_PC_LC_OUTSTD_AMT_1() {
		return UI_M_PC_LC_OUTSTD_AMT_1;
	}
	public void setUI_M_PC_LC_OUTSTD_AMT_1(Double ui_m_pc_lc_outstd_amt_1) {
		UI_M_PC_LC_OUTSTD_AMT_1 = ui_m_pc_lc_outstd_amt_1;
	}
	public Double getPC_LC_UNPAID_WAIVE_PREM_INT() {
		return PC_LC_UNPAID_WAIVE_PREM_INT;
	}
	public void setPC_LC_UNPAID_WAIVE_PREM_INT(Double pc_lc_unpaid_waive_prem_int) {
		PC_LC_UNPAID_WAIVE_PREM_INT = pc_lc_unpaid_waive_prem_int;
	}
	public Double getPC_FC_UNPAID_WAIVE_PREM_INT() {
		return PC_FC_UNPAID_WAIVE_PREM_INT;
	}
	public void setPC_FC_UNPAID_WAIVE_PREM_INT(Double pc_fc_unpaid_waive_prem_int) {
		PC_FC_UNPAID_WAIVE_PREM_INT = pc_fc_unpaid_waive_prem_int;
	}
	public String getPC_WAIVE_PREM_YN() {
		return PC_WAIVE_PREM_YN;
	}
	public void setPC_WAIVE_PREM_YN(String pc_waive_prem_yn) {
		PC_WAIVE_PREM_YN = pc_waive_prem_yn;
	}
	public String getPC_FLEX_06() {
		return PC_FLEX_06;
	}
	public void setPC_FLEX_06(String pc_flex_06) {
		PC_FLEX_06 = pc_flex_06;
	}
	public void setPC_DRCR_DOC_NO(Integer pc_drcr_doc_no) {
		PC_DRCR_DOC_NO = pc_drcr_doc_no;
	}
	public Integer getPC_DRCR_DOC_NO() {
		return PC_DRCR_DOC_NO;
	}
	/*Added by Ram on 08/02/2017 for BankCode field capturing*/
	/*Modified by Ram on 09/02/2017 as per Ajoy's suggestion
	 * 
	 * @Column(name = "BANK_CODE")*/
	@Column(name="PD_BANK_CODE")
	private String BANK_CODE;
	private String UI_BANK_DESC;
	
	public String getBANK_CODE() {
		return BANK_CODE;
	}
	public void setBANK_CODE(String bANK_CODE) {
		BANK_CODE = bANK_CODE;
	}
	public String getUI_BANK_DESC() {
		return UI_BANK_DESC;
	}
	public void setUI_BANK_DESC(String uI_BANK_DESC) {
		UI_BANK_DESC = uI_BANK_DESC;
	}
	/*End*/

	/*Newly added by dhinesh on 23-06-2017 for ssp call id */
	@Column(name="PC_DEP_REF_DOC_NO")
	private Integer PC_DEP_REF_DOC_NO;

	
	@Column(name="PC_DEP_REF_DOC_DT")
	private Date PC_DEP_REF_DOC_DT;
	
	public Integer getPC_DEP_REF_DOC_NO() {
		return PC_DEP_REF_DOC_NO;
	}
	public void setPC_DEP_REF_DOC_NO(Integer pC_DEP_REF_DOC_NO) {
		PC_DEP_REF_DOC_NO = pC_DEP_REF_DOC_NO;
	}
	public Date getPC_DEP_REF_DOC_DT() {
		return PC_DEP_REF_DOC_DT;
	}
	public void setPC_DEP_REF_DOC_DT(Date pC_DEP_REF_DOC_DT) {
		PC_DEP_REF_DOC_DT = pC_DEP_REF_DOC_DT;
	}
	/*End*/
	
	/*Added by saritha on 26-10-2017 for ssp call id ZBLIFE-1449091*/
	private Double UI_M_TOTAL_PREM_PAID;
	public Double getUI_M_TOTAL_PREM_PAID() {
		return UI_M_TOTAL_PREM_PAID;
	}
	public void setUI_M_TOTAL_PREM_PAID(Double uI_M_TOTAL_PREM_PAID) {
		UI_M_TOTAL_PREM_PAID = uI_M_TOTAL_PREM_PAID;
	}
	/*End*/
	
}