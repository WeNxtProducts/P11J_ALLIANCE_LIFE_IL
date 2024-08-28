package com.iii.pel.forms.PILQ004_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class POLICY_DETAILS_ACTION {

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_TRAN_DT_LABEL;

	private HtmlCalendar COMP_POL_TRAN_DT;

	private HtmlOutputLabel COMP_POL_FC_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_POL_FC_SUM_ASSURED;

	private HtmlOutputLabel COMP_UI_M_POL_PLAN_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POL_PLAN_DESC;

	private HtmlOutputLabel COMP_POL_PLAN_CODE_LABEL;

	private HtmlInputText COMP_POL_PLAN_CODE;

	private HtmlOutputLabel COMP_POL_LC_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_POL_LC_SUM_ASSURED;

	private HtmlOutputLabel COMP_NEXT_DUE_DATE_LABEL;

	private HtmlCalendar COMP_NEXT_DUE_DATE;

	private HtmlOutputLabel COMP_POL_FC_FIRST_PREM_LABEL;

	private HtmlInputText COMP_POL_FC_FIRST_PREM;

	private HtmlOutputLabel COMP_POL_PERIOD_LABEL;

	private HtmlInputText COMP_POL_PERIOD;

	private HtmlOutputLabel COMP_POL_PREM_PAY_YRS_LABEL;

	private HtmlInputText COMP_POL_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_POL_START_DT_LABEL;

	private HtmlCalendar COMP_POL_START_DT;

	private HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL;

	private HtmlCalendar COMP_POL_EXPIRY_DT;

	private HtmlOutputLabel COMP_POL_REMARKS_LABEL;

	private HtmlInputText COMP_POL_REMARKS;

	private HtmlOutputLabel COMP_POL_FC_BASIC_PREM_LABEL;

	private HtmlInputText COMP_POL_FC_BASIC_PREM;

	private HtmlOutputLabel COMP_POL_MODE_OF_PYMT_DESC_LABEL;

	private HtmlInputText COMP_POL_MODE_OF_PYMT_DESC;

	private HtmlOutputLabel COMP_POL_ADDL_STATUS_LABEL;

	private HtmlInputText COMP_POL_ADDL_STATUS;

	private HtmlOutputLabel COMP_POL_LC_FIRST_PREM_LABEL;

	private HtmlInputText COMP_POL_LC_FIRST_PREM;

	private HtmlOutputLabel COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL;

	private HtmlInputText COMP_UI_M_POAD_LC_THRESOLD_LMT;

	private HtmlOutputLabel COMP_POL_STATUS_DESC_LABEL;

	private HtmlInputText COMP_POL_STATUS_DESC;

	private HtmlOutputLabel COMP_UI_M_TYPE_LABEL;

	private HtmlInputText COMP_UI_M_TYPE;

	private HtmlOutputLabel COMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL;

	private HtmlInputText COMP_UI_M_POAD_LC_THRESHOLD_LMT;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_POAD_ASSURED_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private POLICY_DETAILS POLICY_DETAILS_BEAN;

	public POLICY_DETAILS_ACTION() {
		POLICY_DETAILS_BEAN = new POLICY_DETAILS();
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_POL_TRAN_DT_LABEL() {
		return COMP_POL_TRAN_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_TRAN_DT() {
		return COMP_POL_TRAN_DT;
	}

	public void setCOMP_POL_TRAN_DT_LABEL(HtmlOutputLabel COMP_POL_TRAN_DT_LABEL) {
		this.COMP_POL_TRAN_DT_LABEL = COMP_POL_TRAN_DT_LABEL;
	}

	public void setCOMP_POL_TRAN_DT(HtmlCalendar COMP_POL_TRAN_DT) {
		this.COMP_POL_TRAN_DT = COMP_POL_TRAN_DT;
	}

	public HtmlOutputLabel getCOMP_POL_FC_SUM_ASSURED_LABEL() {
		return COMP_POL_FC_SUM_ASSURED_LABEL;
	}

	public HtmlInputText getCOMP_POL_FC_SUM_ASSURED() {
		return COMP_POL_FC_SUM_ASSURED;
	}

	public void setCOMP_POL_FC_SUM_ASSURED_LABEL(HtmlOutputLabel COMP_POL_FC_SUM_ASSURED_LABEL) {
		this.COMP_POL_FC_SUM_ASSURED_LABEL = COMP_POL_FC_SUM_ASSURED_LABEL;
	}

	public void setCOMP_POL_FC_SUM_ASSURED(HtmlInputText COMP_POL_FC_SUM_ASSURED) {
		this.COMP_POL_FC_SUM_ASSURED = COMP_POL_FC_SUM_ASSURED;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PLAN_DESC_LABEL() {
		return COMP_UI_M_POL_PLAN_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_PLAN_DESC() {
		return COMP_UI_M_POL_PLAN_DESC;
	}

	public void setCOMP_UI_M_POL_PLAN_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_PLAN_DESC_LABEL) {
		this.COMP_UI_M_POL_PLAN_DESC_LABEL = COMP_UI_M_POL_PLAN_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_PLAN_DESC(HtmlInputText COMP_UI_M_POL_PLAN_DESC) {
		this.COMP_UI_M_POL_PLAN_DESC = COMP_UI_M_POL_PLAN_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_PLAN_CODE_LABEL() {
		return COMP_POL_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_PLAN_CODE() {
		return COMP_POL_PLAN_CODE;
	}

	public void setCOMP_POL_PLAN_CODE_LABEL(HtmlOutputLabel COMP_POL_PLAN_CODE_LABEL) {
		this.COMP_POL_PLAN_CODE_LABEL = COMP_POL_PLAN_CODE_LABEL;
	}

	public void setCOMP_POL_PLAN_CODE(HtmlInputText COMP_POL_PLAN_CODE) {
		this.COMP_POL_PLAN_CODE = COMP_POL_PLAN_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_LC_SUM_ASSURED_LABEL() {
		return COMP_POL_LC_SUM_ASSURED_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_SUM_ASSURED() {
		return COMP_POL_LC_SUM_ASSURED;
	}

	public void setCOMP_POL_LC_SUM_ASSURED_LABEL(HtmlOutputLabel COMP_POL_LC_SUM_ASSURED_LABEL) {
		this.COMP_POL_LC_SUM_ASSURED_LABEL = COMP_POL_LC_SUM_ASSURED_LABEL;
	}

	public void setCOMP_POL_LC_SUM_ASSURED(HtmlInputText COMP_POL_LC_SUM_ASSURED) {
		this.COMP_POL_LC_SUM_ASSURED = COMP_POL_LC_SUM_ASSURED;
	}

	public HtmlOutputLabel getCOMP_NEXT_DUE_DATE_LABEL() {
		return COMP_NEXT_DUE_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_NEXT_DUE_DATE() {
		return COMP_NEXT_DUE_DATE;
	}

	public void setCOMP_NEXT_DUE_DATE_LABEL(HtmlOutputLabel COMP_NEXT_DUE_DATE_LABEL) {
		this.COMP_NEXT_DUE_DATE_LABEL = COMP_NEXT_DUE_DATE_LABEL;
	}

	public void setCOMP_NEXT_DUE_DATE(HtmlCalendar COMP_NEXT_DUE_DATE) {
		this.COMP_NEXT_DUE_DATE = COMP_NEXT_DUE_DATE;
	}

	public HtmlOutputLabel getCOMP_POL_FC_FIRST_PREM_LABEL() {
		return COMP_POL_FC_FIRST_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_FC_FIRST_PREM() {
		return COMP_POL_FC_FIRST_PREM;
	}

	public void setCOMP_POL_FC_FIRST_PREM_LABEL(HtmlOutputLabel COMP_POL_FC_FIRST_PREM_LABEL) {
		this.COMP_POL_FC_FIRST_PREM_LABEL = COMP_POL_FC_FIRST_PREM_LABEL;
	}

	public void setCOMP_POL_FC_FIRST_PREM(HtmlInputText COMP_POL_FC_FIRST_PREM) {
		this.COMP_POL_FC_FIRST_PREM = COMP_POL_FC_FIRST_PREM;
	}

	public HtmlOutputLabel getCOMP_POL_PERIOD_LABEL() {
		return COMP_POL_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_POL_PERIOD() {
		return COMP_POL_PERIOD;
	}

	public void setCOMP_POL_PERIOD_LABEL(HtmlOutputLabel COMP_POL_PERIOD_LABEL) {
		this.COMP_POL_PERIOD_LABEL = COMP_POL_PERIOD_LABEL;
	}

	public void setCOMP_POL_PERIOD(HtmlInputText COMP_POL_PERIOD) {
		this.COMP_POL_PERIOD = COMP_POL_PERIOD;
	}

	public HtmlOutputLabel getCOMP_POL_PREM_PAY_YRS_LABEL() {
		return COMP_POL_PREM_PAY_YRS_LABEL;
	}

	public HtmlInputText getCOMP_POL_PREM_PAY_YRS() {
		return COMP_POL_PREM_PAY_YRS;
	}

	public void setCOMP_POL_PREM_PAY_YRS_LABEL(HtmlOutputLabel COMP_POL_PREM_PAY_YRS_LABEL) {
		this.COMP_POL_PREM_PAY_YRS_LABEL = COMP_POL_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_POL_PREM_PAY_YRS(HtmlInputText COMP_POL_PREM_PAY_YRS) {
		this.COMP_POL_PREM_PAY_YRS = COMP_POL_PREM_PAY_YRS;
	}

	public HtmlOutputLabel getCOMP_POL_START_DT_LABEL() {
		return COMP_POL_START_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_START_DT() {
		return COMP_POL_START_DT;
	}

	public void setCOMP_POL_START_DT_LABEL(HtmlOutputLabel COMP_POL_START_DT_LABEL) {
		this.COMP_POL_START_DT_LABEL = COMP_POL_START_DT_LABEL;
	}

	public void setCOMP_POL_START_DT(HtmlCalendar COMP_POL_START_DT) {
		this.COMP_POL_START_DT = COMP_POL_START_DT;
	}

	public HtmlOutputLabel getCOMP_POL_EXPIRY_DT_LABEL() {
		return COMP_POL_EXPIRY_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_EXPIRY_DT() {
		return COMP_POL_EXPIRY_DT;
	}

	public void setCOMP_POL_EXPIRY_DT_LABEL(HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL) {
		this.COMP_POL_EXPIRY_DT_LABEL = COMP_POL_EXPIRY_DT_LABEL;
	}

	public void setCOMP_POL_EXPIRY_DT(HtmlCalendar COMP_POL_EXPIRY_DT) {
		this.COMP_POL_EXPIRY_DT = COMP_POL_EXPIRY_DT;
	}

	public HtmlOutputLabel getCOMP_POL_REMARKS_LABEL() {
		return COMP_POL_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_POL_REMARKS() {
		return COMP_POL_REMARKS;
	}

	public void setCOMP_POL_REMARKS_LABEL(HtmlOutputLabel COMP_POL_REMARKS_LABEL) {
		this.COMP_POL_REMARKS_LABEL = COMP_POL_REMARKS_LABEL;
	}

	public void setCOMP_POL_REMARKS(HtmlInputText COMP_POL_REMARKS) {
		this.COMP_POL_REMARKS = COMP_POL_REMARKS;
	}

	public HtmlOutputLabel getCOMP_POL_FC_BASIC_PREM_LABEL() {
		return COMP_POL_FC_BASIC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_FC_BASIC_PREM() {
		return COMP_POL_FC_BASIC_PREM;
	}

	public void setCOMP_POL_FC_BASIC_PREM_LABEL(HtmlOutputLabel COMP_POL_FC_BASIC_PREM_LABEL) {
		this.COMP_POL_FC_BASIC_PREM_LABEL = COMP_POL_FC_BASIC_PREM_LABEL;
	}

	public void setCOMP_POL_FC_BASIC_PREM(HtmlInputText COMP_POL_FC_BASIC_PREM) {
		this.COMP_POL_FC_BASIC_PREM = COMP_POL_FC_BASIC_PREM;
	}

	public HtmlOutputLabel getCOMP_POL_MODE_OF_PYMT_DESC_LABEL() {
		return COMP_POL_MODE_OF_PYMT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_POL_MODE_OF_PYMT_DESC() {
		return COMP_POL_MODE_OF_PYMT_DESC;
	}

	public void setCOMP_POL_MODE_OF_PYMT_DESC_LABEL(HtmlOutputLabel COMP_POL_MODE_OF_PYMT_DESC_LABEL) {
		this.COMP_POL_MODE_OF_PYMT_DESC_LABEL = COMP_POL_MODE_OF_PYMT_DESC_LABEL;
	}

	public void setCOMP_POL_MODE_OF_PYMT_DESC(HtmlInputText COMP_POL_MODE_OF_PYMT_DESC) {
		this.COMP_POL_MODE_OF_PYMT_DESC = COMP_POL_MODE_OF_PYMT_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_ADDL_STATUS_LABEL() {
		return COMP_POL_ADDL_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_POL_ADDL_STATUS() {
		return COMP_POL_ADDL_STATUS;
	}

	public void setCOMP_POL_ADDL_STATUS_LABEL(HtmlOutputLabel COMP_POL_ADDL_STATUS_LABEL) {
		this.COMP_POL_ADDL_STATUS_LABEL = COMP_POL_ADDL_STATUS_LABEL;
	}

	public void setCOMP_POL_ADDL_STATUS(HtmlInputText COMP_POL_ADDL_STATUS) {
		this.COMP_POL_ADDL_STATUS = COMP_POL_ADDL_STATUS;
	}

	public HtmlOutputLabel getCOMP_POL_LC_FIRST_PREM_LABEL() {
		return COMP_POL_LC_FIRST_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_FIRST_PREM() {
		return COMP_POL_LC_FIRST_PREM;
	}

	public void setCOMP_POL_LC_FIRST_PREM_LABEL(HtmlOutputLabel COMP_POL_LC_FIRST_PREM_LABEL) {
		this.COMP_POL_LC_FIRST_PREM_LABEL = COMP_POL_LC_FIRST_PREM_LABEL;
	}

	public void setCOMP_POL_LC_FIRST_PREM(HtmlInputText COMP_POL_LC_FIRST_PREM) {
		this.COMP_POL_LC_FIRST_PREM = COMP_POL_LC_FIRST_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL() {
		return COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAD_LC_THRESOLD_LMT() {
		return COMP_UI_M_POAD_LC_THRESOLD_LMT;
	}

	public void setCOMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL(HtmlOutputLabel COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL) {
		this.COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL = COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL;
	}

	public void setCOMP_UI_M_POAD_LC_THRESOLD_LMT(HtmlInputText COMP_UI_M_POAD_LC_THRESOLD_LMT) {
		this.COMP_UI_M_POAD_LC_THRESOLD_LMT = COMP_UI_M_POAD_LC_THRESOLD_LMT;
	}

	public HtmlOutputLabel getCOMP_POL_STATUS_DESC_LABEL() {
		return COMP_POL_STATUS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_POL_STATUS_DESC() {
		return COMP_POL_STATUS_DESC;
	}

	public void setCOMP_POL_STATUS_DESC_LABEL(HtmlOutputLabel COMP_POL_STATUS_DESC_LABEL) {
		this.COMP_POL_STATUS_DESC_LABEL = COMP_POL_STATUS_DESC_LABEL;
	}

	public void setCOMP_POL_STATUS_DESC(HtmlInputText COMP_POL_STATUS_DESC) {
		this.COMP_POL_STATUS_DESC = COMP_POL_STATUS_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_TYPE_LABEL() {
		return COMP_UI_M_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TYPE() {
		return COMP_UI_M_TYPE;
	}

	public void setCOMP_UI_M_TYPE_LABEL(HtmlOutputLabel COMP_UI_M_TYPE_LABEL) {
		this.COMP_UI_M_TYPE_LABEL = COMP_UI_M_TYPE_LABEL;
	}

	public void setCOMP_UI_M_TYPE(HtmlInputText COMP_UI_M_TYPE) {
		this.COMP_UI_M_TYPE = COMP_UI_M_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL() {
		return COMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAD_LC_THRESHOLD_LMT() {
		return COMP_UI_M_POAD_LC_THRESHOLD_LMT;
	}

	public void setCOMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL(HtmlOutputLabel COMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL) {
		this.COMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL = COMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL;
	}

	public void setCOMP_UI_M_POAD_LC_THRESHOLD_LMT(HtmlInputText COMP_UI_M_POAD_LC_THRESHOLD_LMT) {
		this.COMP_UI_M_POAD_LC_THRESHOLD_LMT = COMP_UI_M_POAD_LC_THRESHOLD_LMT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POAD_ASSR_CODE() {
		return COMP_UI_M_BUT_LOV_POAD_ASSR_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_POAD_ASSR_CODE(HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_CODE) {
		this.COMP_UI_M_BUT_LOV_POAD_ASSR_CODE = COMP_UI_M_BUT_LOV_POAD_ASSR_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POAD_ASSURED_NAME() {
		return COMP_UI_M_BUT_POAD_ASSURED_NAME;
	}

	public void setCOMP_UI_M_BUT_POAD_ASSURED_NAME(HtmlCommandButton COMP_UI_M_BUT_POAD_ASSURED_NAME) {
		this.COMP_UI_M_BUT_POAD_ASSURED_NAME = COMP_UI_M_BUT_POAD_ASSURED_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POAD_ASSR_REFID1() {
		return COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1;
	}

	public void setCOMP_UI_M_BUT_LOV_POAD_ASSR_REFID1(HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1) {
		this.COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1 = COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POAD_ASSR_REFID2() {
		return COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2;
	}

	public void setCOMP_UI_M_BUT_LOV_POAD_ASSR_REFID2(HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2) {
		this.COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2 = COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton COMP_UI_M_BUT_MAIN) {
		this.COMP_UI_M_BUT_MAIN = COMP_UI_M_BUT_MAIN;
	}

	public POLICY_DETAILS getPOLICY_DETAILS_BEAN() {
		return POLICY_DETAILS_BEAN;
	}

	public void setPOLICY_DETAILS_BEAN(POLICY_DETAILS POLICY_DETAILS_BEAN) {
		this.POLICY_DETAILS_BEAN = POLICY_DETAILS_BEAN;
	}
	
	/**
	 * 
	 * @param ASSRD_DTLS_BEAN
	 * @throws Exception
	 */
	public void preQueryPOLICY_DETAILS(ASSRD_DTLS ASSRD_DTLS_BEAN) throws Exception {
		System.out.println("\n\nASSRD_DTLS_ACTION.preQueryPOLICY_DETAILS() Starting ..............");

		String asrCode = ASSRD_DTLS_BEAN.getPOAD_ASSR_CODE();//(String)getCOMP_POAD_ASSR_CODE().getSubmittedValue();
		String asrRefID1 = ASSRD_DTLS_BEAN.getPOAD_ASSRD_REF_ID1();//(String)getCOMP_POAD_ASSRD_REF_ID1().getSubmittedValue();
		String asrRefID2 = ASSRD_DTLS_BEAN.getPOAD_ASSRD_REF_ID2();//("".equals(getCOMP_POAD_ASSRD_REF_ID2().getSubmittedValue())? null:(String)getCOMP_POAD_ASSRD_REF_ID2().getSubmittedValue());

		System.out.println("asrCode: "+asrCode);
		System.out.println("asrRefID1: "+asrRefID1);
		System.out.println("asrRefID2: "+asrRefID2);

		String STAT1 = null;
		String DS_TYPE1 = "1";
		String DS_TYPE2 = "2";
		String CONVERT_YN = "N";

		try{
			if("".equalsIgnoreCase(asrCode)){
				asrCode = null;
			}
			if("".equalsIgnoreCase(asrRefID1)){
				asrRefID1 = null;
			}
			if("".equalsIgnoreCase(asrRefID2)){
				asrRefID2 = null;
			}
			
			
			if((asrCode != null && (asrRefID1 == null || "".equalsIgnoreCase(asrRefID1)) && (asrRefID2 == null || "".equalsIgnoreCase(asrRefID2)))) {
				STAT1="POL_SYS_ID IN (SELECT POAD_POL_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_ASSR_CODE = '"+asrCode+"' AND ((POL_DS_TYPE='"+DS_TYPE1+"' AND POL_CONVERT_YN="+"'"+CONVERT_YN+"'"+") OR POL_DS_TYPE = '"+DS_TYPE2+"' ))";
			} 
			if((asrCode != null && asrRefID1 != null && asrRefID2 != null)) {
				STAT1="POL_SYS_ID IN (SELECT POAD_POL_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_ASSR_CODE = '"+asrCode+"' AND POAD_REF_ID1='"+asrRefID1+"' AND POAD_REF_ID2='"+asrRefID2+"' AND ((POL_DS_TYPE='"+DS_TYPE1+"' AND POL_CONVERT_YN="+"'"+CONVERT_YN+"'"+") OR POL_DS_TYPE ='"+DS_TYPE2+"' ))";
			}
			if((asrCode != null && asrRefID1 != null && (asrRefID2 == null || "".equalsIgnoreCase(asrRefID2)))) {
				STAT1="POL_SYS_ID IN (SELECT POAD_POL_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_ASSR_CODE = '"+asrCode+"' AND POAD_REF_ID1='"+asrRefID1+"' AND ((POL_DS_TYPE='"+DS_TYPE1+"' AND POL_CONVERT_YN="+"'"+CONVERT_YN+"'"+" ) OR POL_DS_TYPE ='"+DS_TYPE2+"' ))";
			}
			if((asrCode != null && (asrRefID1 == null || "".equalsIgnoreCase(asrRefID1)) && asrRefID2 != null)) {
				STAT1="POL_SYS_ID IN (SELECT POAD_POL_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_ASSR_CODE = '"+asrCode+"' AND POAD_REF_ID2='"+asrRefID2+"' AND ((POL_DS_TYPE='"+DS_TYPE1+"' AND POL_CONVERT_YN="+"'"+CONVERT_YN+"'"+" ) OR POL_DS_TYPE ='"+DS_TYPE2+"' ))";
			}
			if(((asrCode == null || "".equalsIgnoreCase(asrCode)) && (asrRefID1 == null || "".equalsIgnoreCase(asrRefID1)) && (asrRefID2 == null || "".equalsIgnoreCase(asrRefID2)) )) {
				STAT1="POL_SYS_ID IN (SELECT POAD_POL_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE ((POL_DS_TYPE="+""+DS_TYPE1+""+" AND POL_CONVERT_YN="+"'"+CONVERT_YN+"'"+" ) OR POL_DS_TYPE ='"+DS_TYPE2+"' ))";
			}
			if(((asrCode == null || "".equalsIgnoreCase(asrCode)) && asrRefID1 != null && asrRefID2 != null)) {
				STAT1="POL_SYS_ID IN (SELECT POAD_POL_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_REF_ID1='"+asrRefID1+"' AND POAD_REF_ID2='"+asrRefID2+"' AND ((POL_DS_TYPE='"+DS_TYPE1+"' AND POL_CONVERT_YN="+"'"+CONVERT_YN+"'"+" ) OR POL_DS_TYPE ='"+DS_TYPE2+"' ))";
			}
			if(((asrCode == null || "".equalsIgnoreCase(asrCode)) && asrRefID1 != null && (asrRefID2 == null || "".equalsIgnoreCase(asrRefID2)))) {
				STAT1="POL_SYS_ID IN (SELECT POAD_POL_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_REF_ID1='"+asrRefID1+"' AND ((POL_DS_TYPE='"+DS_TYPE1+"' AND POL_CONVERT_YN="+"'"+CONVERT_YN+"'"+" ) OR POL_DS_TYPE ='"+DS_TYPE2+"' ))";
			}
			if(((asrCode == null || "".equalsIgnoreCase(asrCode)) && (asrRefID1 == null || "".equalsIgnoreCase(asrRefID1) ) && asrRefID2 != null)) {
				STAT1="POL_SYS_ID IN (SELECT POAD_POL_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_REF_ID2='"+asrRefID2+"' AND ((POL_DS_TYPE='"+DS_TYPE1+"' AND POL_CONVERT_YN="+"'"+CONVERT_YN+"'"+" ) OR POL_DS_TYPE ='"+DS_TYPE2+"' ))";
			}
			
			System.out.println("ASSRD_DTLS_ACTION.preQueryPOLICY_DETAILS() PreQuery : "+STAT1);
			
			CommonUtils.setGlobalVariable("POLICY_DETAILS_DEFAULT_WHERE", STAT1);
		}catch(Exception exception){
			throw exception;
		}
	}
	
	/**
	 * 
	 * @param ASSRD_DTLS_ACTION_BEAN
	 */
	public void onLoad(ASSRD_DTLS_ACTION ASSRD_DTLS_ACTION_BEAN) throws Exception{
		try{
			preQueryPOLICY_DETAILS(ASSRD_DTLS_ACTION_BEAN.getASSRD_DTLS_BEAN());
			executeQuery(ASSRD_DTLS_ACTION_BEAN);
			if(ASSRD_DTLS_ACTION_BEAN.getPolicyDetailList()!=null 
					&& !ASSRD_DTLS_ACTION_BEAN.getPolicyDetailList().isEmpty()){
				POLICY_DETAILS policy_details = ASSRD_DTLS_ACTION_BEAN.getPolicyDetailList().get(0);
				policy_details.setRowSelected(true);
				ASSRD_DTLS_ACTION_BEAN.setPOLICY_DETAILS_BEAN(policy_details);
			}else{
				ASSRD_DTLS_ACTION_BEAN.setPOLICY_DETAILS_BEAN(new POLICY_DETAILS());
			}
			if(ASSRD_DTLS_ACTION_BEAN.getPOLICY_DETAILS_BEAN().getPOL_SYS_ID()!=null){
				onPopulateDetails(ASSRD_DTLS_ACTION_BEAN, ASSRD_DTLS_ACTION_BEAN.getPOLICY_DETAILS_BEAN());
			}else{
				ASSRD_DTLS_ACTION_BEAN.getCoverList().clear();
				ASSRD_DTLS_ACTION_BEAN.getLoadList().clear();
				ASSRD_DTLS_ACTION_BEAN.setPOL_ADDL_COVER_BEAN(new POL_ADDL_COVER());
				ASSRD_DTLS_ACTION_BEAN.setPOL_DISC_LOAD_BEAN(new POL_DISC_LOAD());
			}
		}catch(Exception exception){exception.printStackTrace();throw exception;}
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	private void executeQuery(ASSRD_DTLS_ACTION ASSRD_DTLS_ACTION_BEAN) throws SQLException, Exception {
		POLICY_DETAILS POLICY_DETAILS_BEAN = ASSRD_DTLS_ACTION_BEAN.getPOLICY_DETAILS_BEAN();
		String preQuery = CommonUtils.getGlobalVariable("POLICY_DETAILS_DEFAULT_WHERE");
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		String C1 = "SELECT ROWID, PT_IL_POLICY.* FROM PT_IL_POLICY WHERE ".concat(preQuery);
		List<POLICY_DETAILS> list = new ArrayList<POLICY_DETAILS>();
		try{
			System.out.println(preQuery);
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection);
			while(resultSet.next()){
				POLICY_DETAILS_BEAN = new POLICY_DETAILS();
				POLICY_DETAILS_BEAN.setPOL_DS_TYPE(resultSet.getString("POL_DS_TYPE"));
				POLICY_DETAILS_BEAN.setPOL_NO(resultSet.getString("POL_NO"));
				POLICY_DETAILS_BEAN.setPOL_PLAN_CODE(resultSet.getString("POL_PLAN_CODE"));
				POLICY_DETAILS_BEAN.setPOL_FC_SUM_ASSURED(resultSet.getDouble("POL_FC_SUM_ASSURED"));
				POLICY_DETAILS_BEAN.setPOL_LC_SUM_ASSURED(resultSet.getDouble("POL_LC_SUM_ASSURED"));
				POLICY_DETAILS_BEAN.setPOL_PERIOD(resultSet.getDouble("POL_PERIOD"));
				POLICY_DETAILS_BEAN.setPOL_EXPIRY_DT(resultSet.getDate("POL_EXPIRY_DT"));
				POLICY_DETAILS_BEAN.setPOL_STATUS(resultSet.getString("POL_STATUS"));
				POLICY_DETAILS_BEAN.setPOL_LC_FIRST_PREM(resultSet.getDouble("POL_LC_FIRST_PREM"));
				POLICY_DETAILS_BEAN.setPOL_FC_FIRST_PREM(resultSet.getDouble("POL_FC_FIRST_PREM"));
				POLICY_DETAILS_BEAN.setPOL_MODE_OF_PYMT(resultSet.getString("POL_MODE_OF_PYMT"));
				POLICY_DETAILS_BEAN.setPOL_ADDL_STATUS(resultSet.getString("POL_ADDL_STATUS"));
				//POLICY_DETAILS_BEAN.setPOL_LC_SUM_ASSURED(resultSet.getDouble("POL_LC_SUM_ASSURED"));
				POLICY_DETAILS_BEAN.setPOL_PREM_PAY_YRS(resultSet.getDouble("POL_PREM_PAY_YRS"));
				POLICY_DETAILS_BEAN.setPOL_FC_BASIC_PREM(resultSet.getDouble("POL_FC_BASIC_PREM"));
				POLICY_DETAILS_BEAN.setPOL_REMARKS(resultSet.getString("POL_DS_TYPE"));
				POLICY_DETAILS_BEAN.setPOL_START_DT(resultSet.getDate("POL_START_DT"));
				POLICY_DETAILS_BEAN.setPOL_TRAN_DT(resultSet.getDate("POL_TRAN_DT"));
				POLICY_DETAILS_BEAN.setPOL_SYS_ID(resultSet.getLong("POL_SYS_ID"));
				postQueryPOLICY_DETAILS(POLICY_DETAILS_BEAN);
				list.add(POLICY_DETAILS_BEAN);
			}
			
			ASSRD_DTLS_ACTION_BEAN.setPolicyDetailList(list);
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(Exception exception2){exception2.printStackTrace();}
		}
	}
	
	/**
	 * 
	 * @param ASSRD_DTLS_ACTION_BEAN
	 * @throws Exception
	 */
	public void onPopulateDetails(ASSRD_DTLS_ACTION ASSRD_DTLS_ACTION_BEAN,POLICY_DETAILS POLICY_DETAILS_BEAN) throws Exception{
		try{
			POL_ADDL_COVER_ACTION POL_ADDL_COVER_ACTION = new POL_ADDL_COVER_ACTION();
			POL_DISC_LOAD_ACTION POL_DISC_LOAD_ACTION = new POL_DISC_LOAD_ACTION();
			POL_ADDL_COVER_ACTION.executeQuery(ASSRD_DTLS_ACTION_BEAN,POLICY_DETAILS_BEAN);
			POL_DISC_LOAD_ACTION.executeQuery(ASSRD_DTLS_ACTION_BEAN,POLICY_DETAILS_BEAN);
			
			if(ASSRD_DTLS_ACTION_BEAN.getCoverList()!=null && 
					!ASSRD_DTLS_ACTION_BEAN.getCoverList().isEmpty()){
				POL_ADDL_COVER pol_addl_cover = ASSRD_DTLS_ACTION_BEAN.getCoverList().get(0);
				pol_addl_cover.setRowSelected(true);
				ASSRD_DTLS_ACTION_BEAN.setPOL_ADDL_COVER_BEAN(pol_addl_cover);
			}
			
			if(ASSRD_DTLS_ACTION_BEAN.getLoadList()!=null && 
					!ASSRD_DTLS_ACTION_BEAN.getLoadList().isEmpty()){
				POL_DISC_LOAD pol_disc_load = ASSRD_DTLS_ACTION_BEAN.getLoadList().get(0);
				pol_disc_load.setRowSelected(true);
				ASSRD_DTLS_ACTION_BEAN.setPOL_DISC_LOAD_BEAN(pol_disc_load);
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
	}
	
	/**
	 * 
	 * @param preQueryList
	 * @return
	 * @throws Exception
	 */
	public List<POLICY_DETAILS> postQueryPOLICY_DETAILS(POLICY_DETAILS POLICY_DETAILS_BEAN) throws Exception {
		System.out.println(" \n\n ASSRD_DTLS_ACTION.postQueryPOLICY_DETAILS() Starting .............. ");		
		ArrayList<OracleParameter> list =null;
		List<POLICY_DETAILS> postQueryList = new ArrayList<POLICY_DETAILS>();
		Connection connection = null;
		String C1 = "SELECT PC_SCHD_PYMT_DT FROM PT_IL_PREM_COLL WHERE " +
				" PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG,'N')  = 'N'";
		String C2 = "SELECT POAD_LC_THRESHOLD_LMT,POAD_SYS_ID FROM   PT_IL_POL_ASSURED_DTLS WHERE  POAD_POL_SYS_ID = ? ";
		try{
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();

			String  M_POAD_LC_THRESHOLD_LMT=null;
			String  M_POAD_SYS_ID=null;
			ResultSet C1_REC=null;
			ResultSet C2_REC=null;
			String policyStatus = POLICY_DETAILS_BEAN.getPOL_STATUS();
			
			if("A".equals(policyStatus))
			{
				POLICY_DETAILS_BEAN.setPOL_STATUS_DESC("APPROVED");
			}
			else if("C".equals(policyStatus))
			{
				POLICY_DETAILS_BEAN.setPOL_STATUS_DESC("CANCELLED");
			}
			else if("E".equals(policyStatus))
			{
				POLICY_DETAILS_BEAN.setPOL_STATUS_DESC("ENDORSED");
			}
			else if("M".equals(policyStatus))
			{
				POLICY_DETAILS_BEAN.setPOL_STATUS_DESC("MATURED");
			}
			else if("S".equals(policyStatus))
			{
				POLICY_DETAILS_BEAN.setPOL_STATUS_DESC("SURRENDERED");
			}
			else if("P".equals(policyStatus))
			{
				POLICY_DETAILS_BEAN.setPOL_STATUS_DESC("PAIDUP");
			}
			else if("D".equals(policyStatus))
			{
				POLICY_DETAILS_BEAN.setPOL_STATUS_DESC("DEATH CLAIM");
			}
			else if("R".equals(policyStatus))
			{
				POLICY_DETAILS_BEAN.setPOL_STATUS_DESC("RE-INSTATED");
			}
			if("S".equals(POLICY_DETAILS_BEAN.getPOL_MODE_OF_PYMT()))
			{
				POLICY_DETAILS_BEAN.setPOL_MODE_OF_PYMT_DESC("SINGLE");
			}
			else if("Y".equals(POLICY_DETAILS_BEAN.getPOL_MODE_OF_PYMT()))
			{
				POLICY_DETAILS_BEAN.setPOL_MODE_OF_PYMT_DESC("YEARLY");
			}
			else if("H".equals(POLICY_DETAILS_BEAN.getPOL_MODE_OF_PYMT()))
			{
				POLICY_DETAILS_BEAN.setPOL_MODE_OF_PYMT_DESC("HALF-YEARLY");
			}
			else if("Q".equals(POLICY_DETAILS_BEAN.getPOL_MODE_OF_PYMT()))
			{
				POLICY_DETAILS_BEAN.setPOL_MODE_OF_PYMT_DESC("QUARTERLY");
			}
			else if("M".equals(POLICY_DETAILS_BEAN.getPOL_MODE_OF_PYMT()))
			{
				POLICY_DETAILS_BEAN.setPOL_MODE_OF_PYMT_DESC("MONTHLY");
			}
			if("1".equals(POLICY_DETAILS_BEAN.getPOL_DS_TYPE()))
			{
				POLICY_DETAILS_BEAN.setUI_M_TYPE("PROPOSAL");
			}
			else if("2".equals(POLICY_DETAILS_BEAN.getPOL_DS_TYPE()))
			{
				POLICY_DETAILS_BEAN.setUI_M_TYPE("POLICY");
			}
			
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN", POLICY_DETAILS_BEAN.getPOL_PLAN_CODE());
			OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT",POLICY_DETAILS_BEAN.getUI_M_POL_PLAN_DESC());
			OracleParameter param3 = new OracleParameter("in3","STRING","IN","'N'");
			OracleParameter param4 = new OracleParameter("in4","STRING","IN","'E'");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();

			list = procHandler.execute(paramList, connection, "P_VAL_PLAN");

			if(list!=null && list.get(0)!=null){
				POLICY_DETAILS_BEAN.setUI_M_POL_PLAN_DESC(list.get(0).getValue());
			}
			
			C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{POLICY_DETAILS_BEAN.getPOL_SYS_ID()});
			if(C1_REC.next()){
				POLICY_DETAILS_BEAN.setNEXT_DUE_DATE(C1_REC.getDate("PC_SCHD_PYMT_DT"));
			}
			
			C2_REC = handler.executeSelectStatement(C2, connection,new Object[]{POLICY_DETAILS_BEAN.getPOL_SYS_ID()});
			if(C2_REC.next())
			{
				POLICY_DETAILS_BEAN.setUI_M_POAD_TOT_THRESOLD_LMT(C2_REC.getDouble(1));
				M_POAD_SYS_ID = C2_REC.getString(2);
				M_POAD_LC_THRESHOLD_LMT = C2_REC.getString(1);
			}
			paramList.clear();
			OracleParameter param11 = new OracleParameter("in1","DOUBLE","IN", String.valueOf(POLICY_DETAILS_BEAN.getPOL_SYS_ID()));
			OracleParameter param22 = new OracleParameter("in2","STRING","IN",M_POAD_SYS_ID);
			OracleParameter param33 = new OracleParameter("in3","STRING","OUT",M_POAD_LC_THRESHOLD_LMT);
			paramList.add(param11);
			paramList.add(param22);
			paramList.add(param33);

			list = procHandler.execute(paramList, connection, "P9ILPK_POLICY.CALC_ASSRD_THRESHOLD_LIMIT");
			if(list!=null && list.get(0)!=null){
				POLICY_DETAILS_BEAN.setUI_M_POAD_LC_THRESOLD_LMT(Double.parseDouble(list.get(0).getValue()));
			}
		}catch(Exception exception){exception.printStackTrace();throw exception;}
		return postQueryList;
	}

}
