package com.iii.pel.forms.PILT002_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PCOPK_SYS_VARS;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class PILT002_APAC_HELPER {

    /*
     * public void callPILT002_APAC_WHEN_CREATE_RECORD(
     * PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
     * CommonUtils commonUtils = new CommonUtils(); Connection connection =
     * null; CRUDHandler handler = new CRUDHandler(); ResultSet resultSet =
     * null; Object[] values = null; DBProcedures procedures = new
     * DBProcedures(); ArrayList<String> arrayList = new ArrayList<String>();
     * 
     * PT_IL_POLICY_ACTION action = compositeAction
     * .getPT_IL_POLICY_ACTION_BEAN(); PT_IL_POLICY valueBean =
     * action.getPT_IL_POLICY_BEAN();
     * 
     * ControlBean controlBean = compositeAction.getControlBean();
     * 
     * try {
     * 
     * connection = CommonUtils.getConnection();
     * 
     * String M_RATE_PER = null; String M_RATE = null; Object[] objects = {
     * CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_3"),
     * PILT002_APAC_CONSTANTS.PLAN_FRZ_FLAG };
     * 
     * 
     * if(GET_BLOCK_PROPERTY.GET_BLOCK_PROPERTY("PT_IL_POLICY",INSERT_ALLOWED)=="TRUE") {
     * 
     * valueBean.setPOL_DIVN_CODE(CommonUtils
     * .getGlobalVariable("GLOBAL.M_DIVN_CODE"));
     * 
     * StringFunctions .substr(
     * CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES"), 4, 6).trim());
     * 
     * valueBean.setPOL_DEPT_CODE(CommonUtils
     * .getGlobalVariable("GLOBAL.M_DEPT_CODE"));
     * 
     * 
     * StringFunctions .substr(
     * CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES"), 10, 6).trim());
     * 
     * valueBean.setPOL_CLASS_CODE(CommonUtils
     * .getGlobalVariable("GLOBAL.M_PARAM_2"));
     *//**
	 * Calling P_VAL_DIVN Procedure
	 */
    /*
     * arrayList = procedures.callP_VAL_DIVN(valueBean.getPOL_DIVN_CODE(),
     * PILT002_APAC_CONSTANTS.P_NAME_FLAG, PILT002_APAC_CONSTANTS.P_ERR_FLAG);
     * if (arrayList != null && arrayList.size() > 0) {
     * valueBean.setUI_M_POL_DIVN_DESC(arrayList.get(0)); } //
     * :GLOBAL.M_DIVN_CODE=:PT_IL_POLICY.POL_DIVN_CODE;
     * 
     *//**
	 * Calling P_VAL_DEPT Procedure
	 */
    /*
     * 
     * arrayList = procedures.callP_VAL_DEPT(valueBean.getPOL_DIVN_CODE(),
     * valueBean.getPOL_DEPT_CODE(), PILT002_APAC_CONSTANTS.P_NAME_FLAG,
     * PILT002_APAC_CONSTANTS.P_ERR_FLAG); if (arrayList != null &&
     * arrayList.size() > 0) {
     * valueBean.setUI_M_POL_DEPT_DESC(arrayList.get(0)); }
     * 
     * 
     * if((GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CALLING_FORM)!="PILP052_APAC") &&
     * :PT_IL_POLICY.POL_PROP_QUOT_FLAG!="Q") {
     * 
     *//**
	 * Calling P_VAL_CLASS Procedure
	 */
    /*
     * arrayList = procedures.callP_VAL_CLASS(valueBean .getPOL_CLASS_CODE(),
     * PILT002_APAC_CONSTANTS.P_NAME_FLAG, PILT002_APAC_CONSTANTS.P_ERR_FLAG);
     * if (arrayList != null && arrayList.size() > 0) {
     * valueBean.setUI_M_POL_CLASS_DESC(arrayList.get(0)); }
     * 
     * valueBean.setPOL_ISSUE_DT(commonUtils.getCurrentDateTime());
     * valueBean.setPOL_START_DT(commonUtils.getCurrentDateTime());
     * valueBean.setPOL_FIRST_INST_DT(commonUtils.getCurrentDateTime());
     * 
     * values = new Object[2]; values[0] = valueBean.getPOL_ISSUE_DT();
     * values[1] = valueBean.getPOL_CLASS_CODE();
     * 
     * resultSet = handler.executeSelectStatement(
     * PILT002_APAC_QUERY_CONSTANTS.SELECT_UW_YEAR, connection, values);
     * 
     * if (resultSet != null && resultSet.next()) { int M_UW_YEAR =
     * resultSet.getInt("PT_UW_YEAR");
     * valueBean.setUI_M_PT_SYS_ID(resultSet.getString("PT_SYS_ID"));
     * 
     * if (valueBean.getPOL_UW_YEAR() == 0 || valueBean.getPOL_END_CODE() ==
     * null) { valueBean.setPOL_UW_YEAR(M_UW_YEAR); } }
     * 
     * valueBean.setPOL_PROP_RECV_DT(new java.sql.Date(Calendar
     * .getInstance().getTimeInMillis())); valueBean.setPOL_PROP_STAMP_DT(new
     * java.sql.Date(Calendar .getInstance().getTimeInMillis())); // Setting
     * UI_M_BASE_CURR // Bug fixed : fetching POL_SA_CURR_CODE and M_BASE_CURR
     * when // pre_form : Added by Shankar Bodduluri : 01-04-2009 String
     * P_CURR_CODE = null; String P_NAME = null; int P_DECIMAL = -1; ArrayList<String>
     * list = procedures.helperF_GET_BASE_CURRENCY(
     * CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), "N", P_CURR_CODE,
     * P_NAME, P_DECIMAL + "", "E"); if (list != null && list.size() > 0) {
     * P_CURR_CODE = list.get(0); P_NAME = list.get(1); P_DECIMAL =
     * CommonUtils.parseToInt(list.get(2)); }
     * CommonUtils.setGlobalObject("GLOBAL.M_BASE_CURR", P_CURR_CODE); // Bug
     * fixed : fetching POL_SA_CURR_CODE and M_BASE_CURR when // pre_form :
     * Added by Shankar Bodduluri : 01-04-2009
     * valueBean.setUI_M_BASE_CURR(CommonUtils
     * .getGlobalVariable("GLOBAL.M_BASE_CURR"));
     * valueBean.setPOL_SA_CURR_CODE(valueBean.getUI_M_BASE_CURR());
     * valueBean.setPOL_CUST_CURR_CODE(valueBean.getUI_M_BASE_CURR());
     * valueBean.setPOL_PROD_GROUP_CODE(CommonUtils
     * .getGlobalVariable("GLOBAL.M_PARAM_14"));
     * 
     * STARTS --> Setting Prod Grp code desc ArrayList<String> valueList = new
     * ArrayList<String>(); String foreignLangCode = CommonUtils
     * .getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"); String ctrlLangCode =
     * controlBean.getM_LANG_CODE();
     * 
     * valueList = procedures.callPCOPK_GENERAL_P_VAL_GRP_CODE(CommonUtils
     * .getGlobalVariable("GLOBAL.M_PARAM_14"), "E", foreignLangCode,
     * ctrlLangCode, "");
     * 
     * if (valueList != null && !valueList.get(0).isEmpty()) {
     * valueBean.setUI_M_PROD_GROUP_DESC(valueList.get(0)); } Setting Prod Grp
     * code desc <-- ENDS
     * 
     * valueBean.setPOL_PLAN_CODE(CommonUtils
     * .getGlobalVariable("GLOBAL.M_PARAM_3"));
     * valueBean.setPOL_MODE_OF_PYMT(CommonUtils
     * .getGlobalVariable("GLOBAL.M_PARAM_5"));
     * 
     * pilt002_apac_pt_il_policy_pol_mode_of_pymt_when_validate_item(compositeAction);
     * 
     * valueBean.setPOL_PROD_CODE(CommonUtils
     * .getGlobalVariable("GLOBAL.M_PARAM_6"));
     * 
     * valueBean.setPOL_DS_CODE(CommonUtils
     * .getGlobalVariable("GLOBAL.M_PARAM_1"));
     * valueBean.setPOL_DS_TYPE(CommonUtils
     * .getGlobalVariable("GLOBAL.M_PARAM_11"));
     * 
     * resultSet = handler.executeSelectStatement(
     * PILT002_APAC_QUERY_CONSTANTS.SELECT_PLAN_CREDIT_YN, connection, objects);
     * 
     * if (resultSet.next()) {
     * valueBean.setPOL_CREDIT_YN(resultSet.getString(1)); }
     * CommonUtils.closeCursor(resultSet);
     * 
     * valueBean.setUI_M_SURR_MAT("S"); valueBean.setPOL_CASH_YN("Y"); //
     * PREMIAGDC-317764 -VijayAnand.V 10-08-2009 if
     * ("Y".equals(valueBean.getPOL_CASH_YN())) {
     * action.getCOMP_POL_PYMT_TYPE().setDisabled(true); } // PREMIAGDC-317764
     * -VijayAnand.V 10-08-2009 valueBean.setPOL_FAC_YN("N");
     * valueBean.setPOL_FAC_BASIS("A"); valueBean.setPOL_CREDIT_YN("N");
     * valueBean.setPOL_RATE_APPLIED_ON("S");
     * valueBean.setPOL_JOINT_LIFE_YN("N");
     * valueBean.setPOL_TARIFF_TERM_FLAG("2"); valueBean.setPOL_STAFF_YN("N");
     * valueBean.setPOL_STD_RISK_YN("N"); valueBean.setPOL_CQS_YN("N");
     * valueBean.setPOL_PREM_WAIVE_YN("N");
     * valueBean.setPOL_INCORPORATED_YN("N"); valueBean.setPOL_NET_PREM_YN("N");
     * valueBean.setPOL_MODE_OF_CALC(MigratingFunctions.nvl(CommonUtils
     * .getGlobalVariable("GLOBAL.M_PARAM_9"), "S"));
     * valueBean.setPOL_PYMT_TYPE("P"); valueBean.setPOL_FRZ_FLAG("N");
     * valueBean.setPOL_NO_OF_INST(1d); valueBean.setPOL_HOME_OWNER_FLAG("N");
     * valueBean.setPOL_ORG_PROP_RECV_YN("Y");
     * valueBean.setPOL_FC_BANK_ALLOC_AMT(0d);
     * valueBean.setPOL_LC_BANK_ALLOC_AMT(0d);
     * valueBean.setPOL_FC_CLIENT_ALLOC_AMT(0d);
     * valueBean.setPOL_LC_CLIENT_ALLOC_AMT(0d);
     * valueBean.setPOL_MED_FEE_RECOVER_YN("N");
     * 
     * if ("I".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_10"))) {
     * valueBean.setPOL_GRANTEE_TYPE("I"); } else {
     * valueBean.setPOL_GRANTEE_TYPE("B"); } // action.instantiateComponents();
     * action.getCOMP_POL_RATE_APPLIED_ON().setDisabled(true);
     * action.getCOMP_POL_TARIFF_TERM_FLAG().setDisabled(true);
     * 
     * action.getCOMP_POL_FC_DISC_AMT().setDisabled(true);
     * action.getCOMP_POL_LC_DISC_AMT().setDisabled(true);
     * 
     * 
     * if ("1".equals(valueBean.getPOL_DS_TYPE())) { if (!"Q".equals(CommonUtils
     * .getGlobalVariable("GLOBAL.M_PARAM_13")) && !"1".equals(CommonUtils
     * .getGlobalVariable("GLOBAL.M_PARAM_11"))) {
     * action.getCOMP_UI_M_BUT_HOLD().setDisabled(false); } //
     * [PREMIAGDC-277595-VijayAnand 22-JUL-09 //
     * action.getCOMP_UI_M_BUT_CONVERT().setDisabled(false); //
     * [PREMIAGDC-277595-VijayAnand 22-JUL-09
     * 
     * 
     * :BP.B_PROP_LC_DEP_PREM="PROP LC DEP. AMT"; POL_LC_DEPOSIT_AMOUNT
     * :BP.B_PROP_FC_DEP_PREM="PROP FC DEP. AMT"; POL_FC_DEPOSIT_AMOUNT
     * 
     * action.getCOMP_POL_LC_DEPOSIT_AMOUNT_LABEL().setValue( "Prop LC Dep.
     * Amt"); action.getCOMP_POL_FC_DEPOSIT_AMOUNT_LABEL().setValue( "Prop FC
     * Dep. Amt"); valueBean.setPOL_FC_DEPOSIT_AMOUNT(0.0d);
     * valueBean.setPOL_LC_DEPOSIT_AMOUNT(0.0d);
     * valueBean.setPOL_CONVERT_YN("N"); } else {
     * 
     * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_BUT_HOLD",VISIBLE,PROPERTY_TRUE);
     * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_BUT_CONVERT",VISIBLE,PROPERTY_FALSE);
     * :BP.B_PROP_LC_DEP_PREM="LC FIRST PREMIUM"; :BP.B_PROP_FC_DEP_PREM="FC
     * FIRST PREMIUM";
     * 
     * action.getCOMP_UI_M_BUT_HOLD().setDisabled(false);
     * action.getCOMP_UI_M_BUT_CONVERT().setDisabled(true);
     * action.getCOMP_POL_LC_DEPOSIT_AMOUNT_LABEL().setValue( "LC First
     * Premium"); action.getCOMP_POL_FC_DEPOSIT_AMOUNT_LABEL().setValue( "FC
     * First Premium");
     *  } if ("1".equals(valueBean.getPOL_DS_TYPE()) ||
     * ("2".equals(valueBean.getPOL_DS_TYPE()) && !MigratingFunctions
     * .nvl(valueBean.getPOL_END_TYPE(), "000").equals( "010"))) {
     * 
     * action.getCOMP_POL_EXC_INT_PERC().setDisabled(true);
     * action.getCOMP_POL_FC_EXC_INT_AMT().setDisabled(true);
     * action.getCOMP_POL_LC_EXC_INT_AMT().setDisabled(true); } if
     * (("2".equals(valueBean.getPOL_DS_TYPE()) && MigratingFunctions
     * .nvl(valueBean.getPOL_END_TYPE(), "000").equals("010"))) {
     * 
     * action.getCOMP_POL_EXC_INT_PERC().setDisabled(false); if
     * (StringFunctions.substr( MigratingFunctions.nvl(CommonUtils
     * .getGlobalVariable("GLOBAL.M_PRIVILEGE"), ""), 2, 1).equals("Y")) { //
     * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_POLICY.POL_EXC_INT_PERC",UPDATE_ALLOWED,PROPERTY_TRUE); } //
     * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_POLICY.POL_EXC_INT_PERC",NAVIGABLE,PROPERTY_TRUE);
     * action.getCOMP_POL_FC_EXC_INT_AMT().setDisabled(true);
     * action.getCOMP_POL_LC_EXC_INT_AMT().setDisabled(true);
     *  } else { action.getCOMP_POL_EXC_INT_PERC().setDisabled(true);
     * action.getCOMP_POL_FC_EXC_INT_AMT().setDisabled(true);
     * action.getCOMP_POL_LC_EXC_INT_AMT().setDisabled(true); }
     *  // arrayList = callP9ILPK_POLICY_P_GET_MOP_RATE(connection, //
     * compositeAction); String modeOfPayment = valueBean.getPOL_MODE_OF_PYMT();
     * 
     * Date polStartDate = action.getCOMP_POL_START_DT().getAsDate(
     * action.getCOMP_POL_START_DT().getSubmittedValue()); polStartDate =
     * polStartDate == null ? valueBean.getPOL_START_DT() : polStartDate;
     * 
     * arrayList = procedures.callP9ILPK_POLICY_P_GET_MOP_RATE(valueBean
     * .getPOL_PLAN_CODE(), modeOfPayment, CommonUtils
     * .dateToStringFormatter(polStartDate));
     * 
     * if (arrayList != null && arrayList.size() > 0) {
     * 
     * M_RATE = arrayList.get(0); M_RATE_PER = arrayList.get(1); } Double rate =
     * CommonUtils.roundDouble(Double
     * .parseDouble(MigratingFunctions.nvl(M_RATE, "0")) /
     * Double.parseDouble(MigratingFunctions .nvl(M_RATE_PER, "1")));
     * 
     * valueBean.setPOL_MODE_OF_PYMT_RATE(rate);
     * action.getCOMP_POL_MODE_OF_PYMT_RATE().resetValue();
     *  // Setting the no of instalment if ("S".equals(modeOfPayment) ||
     * "Y".equals(modeOfPayment)) { valueBean.setPOL_NO_OF_INST(1.0); } else if
     * ("H".equals(modeOfPayment)) { valueBean.setPOL_NO_OF_INST(2.0); } else if
     * ("M".equals(modeOfPayment)) { valueBean.setPOL_NO_OF_INST(12.0); } else
     * if ("Q".equals(modeOfPayment)) { valueBean.setPOL_NO_OF_INST(4.0); }
     *  //
     * p9ilpk_policy.p9ilpk_policy.p_get_mop_rate(:PT_IL_POLICY.POL_PLAN_CODE,:PT_IL_POLICY.POL_MODE_OF_PYMT,:PT_IL_POLICY.POL_START_DT,M_RATE,M_RATE_PER); //
     * pt_il_policy_composite_action.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_MODE_OF_PYMT_RATE(NumericFunctions.round((MigratingFunctions.nvl(M_RATE,0)/MigratingFunctions.nvl(M_RATE_PER,1)),5));
     * 
     * valueBean.setPOL_PROFIT_RATE(4d);
     * action.getCOMP_POL_PROFIT_RATE().setDisabled(true);
     *  // Setting descriptions for plan code and prod code //
     * 
     * String planDescQuery = "SELECT COVER_DESC FROM PM_IL_COVER WHERE
     * COVER_CODE = ?"; Object[] valsForPlanDesc = {
     * valueBean.getPOL_PLAN_CODE() }; ResultSet PLAN_DESC = null; PLAN_DESC =
     * handler.executeSelectStatement(planDescQuery, connection,
     * valsForPlanDesc);
     * 
     * if (PLAN_DESC.next()) {
     * valueBean.setUI_M_POL_PLAN_DESC(PLAN_DESC.getString(1)); }
     * 
     * CommonUtils.closeCursor(PLAN_DESC); String prodDescQuery = "SELECT
     * PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ?"; Object[]
     * valsForProdDesc = { valueBean.getPOL_PROD_CODE() }; ResultSet PROD_DESC =
     * null; PROD_DESC = handler.executeSelectStatement(prodDescQuery,
     * connection, valsForProdDesc);
     * 
     * if (PROD_DESC.next()) {
     * valueBean.setUI_M_PROD_DESC(PROD_DESC.getString(1)); }
     *  } catch (SQLException se) {
     * ErrorHelpUtil.getErrorsAndWarningforProcedure(connection,
     * FacesContext.getCurrentInstance(), PILT002_APAC_CONSTANTS.FORM_ID,
     * compositeAction .getPT_IL_POL_BROKER_HEAD_ACTION_BEAN() .getErrorMap()); //
     * throw new Exception(se.getMessage()); } catch (DBException e) {
     * e.printStackTrace(); throw new Exception(e.getMessage()); } catch
     * (Exception e) { e.printStackTrace(); throw new Exception(e.getMessage()); }
     * finally { CommonUtils.closeCursor(resultSet);
     * 
     * ErrorHelpUtil.getErrorsAndWarningforProcedure(connection,
     * FacesContext.getCurrentInstance(), PILT002_APAC_CONSTANTS.FORM_ID,
     * action.getWarningMap());
     *  } }
     */

    public void IL_ADD_ENDORSE_CHANGES(
	    PILT002_APAC_COMPOSITE_ACTION compositeAction) {
	PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
	.getPT_IL_POLICY_ACTION_BEAN();
	PT_IL_POLICY_1_ACTION pt_il_policy_1_action = compositeAction
	.getPT_IL_POLICY_1_ACTION_BEAN();
        PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
        	.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
        PT_IL_POL_ASSURED_DTLS_1_ACTION  pt_il_pol_assured_dtls_1_action = compositeAction
        .getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
        PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
        
        try {
	    	pt_il_policy_action.getCOMP_POL_SA_CURR_CODE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_CUST_CURR_CODE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_CUST_EXCH_RATE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_CONT_CODE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_CREDIT_YN().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_CREDIT_DISCOUNT_PERC().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_LOAD_PERC().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID1().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID2().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_CUST_CODE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_ASSURED_NAME().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_SRC_OF_BUS().setDisabled(true);

	        pt_il_policy_action.getCOMP_POL_CASH_YN().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_ORG_PROP_RECV_YN().setDisabled(true);
	            
	        pt_il_policy_action.getCOMP_POL_PROP_RECV_DT().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_PROP_STAMP_DT().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_PROP_DECL_DT().setDisabled(true);
	        
	        pt_il_policy_action
		    .getCOMP_POL_FAC_BASIS().setDisabled(true);// ',ENABLED,PROPERTY_FALSE);
	        pt_il_policy_action
		    .getCOMP_POL_RI_POOL_CODE().setDisabled(true); // ',ENABLED,PROPERTY_FALSE);

	    	  
	         pt_il_pol_assured_dtls_action.setINSERT_ALLOWED( false); 
	         pt_il_pol_assured_dtls_action.setDELETE_ALLOWED( false); 
	         
	        if("Y".equals(CommonUtils.SUBSTR( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE"),2,1) )){
	            pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED( true); 
	        }
	     	 compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().setDELETE_ALLOWED(false ); 
	     	 compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().setDELETE_ALLOWED(false ); 
	     		
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_DOB().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_ASSURED_NAME().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_TYPE().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE().setDisabled( true);
	        
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_SMOKE_YN().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_CATG_CODE().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CLASS().setDisabled( true);
	        
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CODE().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_HEALTH_CODE().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_PREM().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_PREM().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SENABEL_PREM().setDisabled( true);        
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SENABEL_PREM().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_LOAD_PREM().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_LOAD_PREM().setDisabled( true);
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SALARY().setDisabled( true);    
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SALARY().setDisabled( true);        
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT_UNIT().setDisabled( true); 
	         pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT_UNIT().setDisabled( true); 
	    		
	        
	         pt_il_pol_assured_dtls_1_action.setINSERT_ALLOWED( false); 
	         pt_il_pol_assured_dtls_1_action.setDELETE_ALLOWED( false); 
	         compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().setDELETE_ALLOWED( false); 
	         if("Y".equals(CommonUtils.SUBSTR( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE"),2,1) )){
		            pt_il_pol_assured_dtls_1_action.setUPDATE_ALLOWED( true); 
			}
	        
	        
	     		pt_il_pol_assured_dtls_1_action.getCOMP_POAD_SMOKE_YN().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_CATG_CODE().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_OCC_CLASS().setDisabled( true);
	     		pt_il_pol_assured_dtls_1_action.getCOMP_POAD_ASSURED_NAME().setDisabled( true);
	     		pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SALARY().setDisabled( true);    
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SALARY().setDisabled( true);        
	     		
	     		
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DOB().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_TYPE().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEIGHT().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_WEIGHT().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_ADDL_RISK_CODE().setDisabled( true);

	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_OCC_CODE().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEALTH_CODE().setDisabled( true);

	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SUM_ASSURED().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SUM_ASSURED().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_PREM().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_PREM().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SENABEL_PREM().setDisabled( true);        
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SENABEL_PREM().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_LOAD_PREM().setDisabled( true);
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_LOAD_PREM().setDisabled( true);    

	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEIGHT_UNIT().setDisabled( true); 
	        pt_il_pol_assured_dtls_1_action.getCOMP_POAD_WEIGHT_UNIT().setDisabled( true);  

	        compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setINSERT_ALLOWED( false); 
	        compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setUPDATE_ALLOWED( false); 
	        compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setDELETE_ALLOWED( false); 

	    	compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN().setINSERT_ALLOWED( false); 
	    	compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN().setUPDATE_ALLOWED( false); 
	    	compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN().setDELETE_ALLOWED( false); 
	    	
	    	compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().setINSERT_ALLOWED( false); 
	    	compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().setUPDATE_ALLOWED( false); 
	    	compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().setDELETE_ALLOWED( false); 
	    	
	    	compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().setINSERT_ALLOWED( false); 
	    	compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().setUPDATE_ALLOWED( false); 
	    	compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().setDELETE_ALLOWED( false); 
	    	
	    	compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN().setINSERT_ALLOWED( false); 
	    	compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN().setUPDATE_ALLOWED( false); 
	    	compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN().setDELETE_ALLOWED( false); 
 
	    	compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setINSERT_ALLOWED( false); 
	    	compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setUPDATE_ALLOWED( false); 
	    	compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setDELETE_ALLOWED( false); 
	     
	    	compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN().setINSERT_ALLOWED( false); 
	    	compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN().setUPDATE_ALLOWED( false); 
	    	compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN().setDELETE_ALLOWED( false); 
	    	
	        pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_TARIFF_TERM_FLAG().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_RATE_APPLIED_ON().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_STD_RISK_YN().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_LC_BASIC_PREM().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_NO_OF_INST().setDisabled(true); 
	        pt_il_policy_action.getCOMP_POL_INCORPORATED_YN().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_PROFIT_RATE().setDisabled(true); 
	        pt_il_policy_action.getCOMP_POL_MODE_OF_CALC().setDisabled(true); 
	        
	        
	        pt_il_policy_action.getCOMP_POL_DEFER_PRD().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_BANK_BRANCH_NAME().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_HOME_OWNER_FLAG().setDisabled(true);
	       
	        pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_FC_NET_PREM().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_LC_NET_PREM().setDisabled(true);
	        
	        pt_il_policy_action.getCOMP_POL_FC_PRE_TPD_BNF().setDisabled(true);
	        pt_il_policy_action.getCOMP_POL_LC_PRE_TPD_BNF().setDisabled(true);
	        
	         compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getCOMP_DTLS_SR_NO().setDisabled( true);
	        if("Y".equals(CommonUtils.nvl(pt_il_policy_action.getPT_IL_POLICY_BEAN().getPOL_INCORPORATED_YN(),"N"))){
	    			 pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT().setDisabled(true);    	
	    			 pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT().setDisabled(true);
	    			 pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT().setDisabled(true);
	    			 pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT().setDisabled(true);
	    			 pt_il_policy_action.getCOMP_POL_FC_TOT_SA().setDisabled(true);
	    			 pt_il_policy_action.getCOMP_POL_LC_TOT_SA().setDisabled(true);
	        }

	        compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().setINSERT_ALLOWED( false); 
	        
	        compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PS_STATUS().setDisabled(true);
	    	compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PS_REASON_CODE().setDisabled(true);
	        
	        compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PS_STATUS_DT().setDisabled( true);
	        
	        compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PS_STATUS().setDisabled( true);
	    	
	    	compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL()
			    .setDisabled(true);
	    		
	    		compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CUSTOMER()
			    .setDisabled(true);
		    compositeAction.getDUMMY_ACTION_BEAN()
			    .getCOMP_UI_M_BUT_CONTRACTOR().setDisabled(true);

		    compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_HOLD()
		    .setDisabled(true);
	    compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_FUND_DTL()
		    .setDisabled(true);
 
	    compositeAction.getDUMMY_ACTION_BEAN()
	    .getCOMP_UI_M_BUT_OCC_RATE_PAYOR().setDisabled(true);
	    	compositeAction.getDUMMY_ACTION_BEAN()
	    .getCOMP_UI_M_BUT_OCC_RATE_PAYEE().setDisabled(true);
	     		
	    		pt_il_doc_todo_list_status_action.getCOMP_DTLS_TODO_LIST_ITEM().setDisabled( true);
	    		pt_il_doc_todo_list_status_action.getCOMP_DTLS_MANDATORY_YN().setDisabled( true);
	    		pt_il_doc_todo_list_status_action.getCOMP_DTLS_APPR_STS().setDisabled( true);
	    		
	    		if("Y".equals(CommonUtils.SUBSTR( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE"),1,1) )){
		            compositeAction.getPT_IL_POL_STATUS_2_ACTION_BEAN().setINSERT_ALLOWED( true); 
			}
	    		if("Y".equals(CommonUtils.SUBSTR( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE"),2,1) )){
	    		    compositeAction.getPT_IL_POL_STATUS_2_ACTION_BEAN().setUPDATE_ALLOWED( true); 
	    		}
	    		if("Y".equals(CommonUtils.SUBSTR( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE"),3,1) )){
	    		    compositeAction.getPT_IL_POL_STATUS_2_ACTION_BEAN().setDELETE_ALLOWED( true); 
	    		}	        	 
	   
	   /* 
	    compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL()
		    .setDisabled(false);

	    compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CUSTOMER()
		    .setDisabled(false);
	    compositeAction.getDUMMY_ACTION_BEAN()
		    .getCOMP_UI_M_BUT_CONTRACTOR().setDisabled(false);

	    compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_HOLD()
		    .setDisabled(false);
	    compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_FUND_DTL()
		    .setDisabled(false);

	    compositeAction.getDUMMY_ACTION_BEAN()
		    .getCOMP_UI_M_BUT_OCC_RATE_PAYOR().setDisabled(false);
	    compositeAction.getDUMMY_ACTION_BEAN()
		    .getCOMP_UI_M_BUT_OCC_RATE_PAYEE().setDisabled(false);*/

	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }

    public void IL_ADD_ENDORSE_COMMENT_CHANGES(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
	 
	PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
	.getPT_IL_POLICY_ACTION_BEAN();
	PT_IL_POLICY_1_ACTION pt_il_policy_1_action = compositeAction
	.getPT_IL_POLICY_1_ACTION_BEAN();
        PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
        	.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
        PT_IL_POL_ASSURED_DTLS_1_ACTION  pt_il_pol_assured_dtls_1_action = compositeAction
        .getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
        PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
        	.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
        PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
        	.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
        PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
        	.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
        PT_IL_SURR_MAT_VALUES_ACTION pt_il_surr_mat_values_action = compositeAction
        	.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
        PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
        	.getPT_IL_POL_CHARGE_ACTION_BEAN();
        PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
        	.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
        PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
        	.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
        PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
        	.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
        PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
        	.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
        PT_IL_UNPAID_PREM_DTLS_ACTION pt_il_unpaid_prem_dtls_action = compositeAction
        	.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN();
        
        PT_IL_POL_BENEFICIARY_ACTION pt_il_pol_beneficiary_action =compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN();
        PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION pt_il_pol_assr_illness_dtls_action = compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN();
        PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
        PT_IL_POL_CONDITION_ACTION pt_il_pol_condition_action = compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN();
        PT_IL_POL_STATUS_ACTION   pt_il_pol_status_action = compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN();
	     PT_IL_POL_STATUS_1_ACTION pt_il_pol_status_1_action = compositeAction.getPT_IL_POL_STATUS_1_ACTION_BEAN();
	     PT_IL_POL_RED_SA_ACTION pt_il_pol_red_sa_action = compositeAction.getPT_IL_POL_RED_SA_ACTION_BEAN();
	     PT_IL_POL_FUND_DTL_ACTION  pt_il_pol_fund_dtl_action = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN();
	     PT_IL_POL_FUND_DTL_1_ACTION pt_il_pol_fund_dtl_1_action = compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN();
	     PM_IL_DOC_TODO_GROUP_ACTION pm_il_doc_todo_group_action=compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN();
	       
	try {
	   
	    pt_il_policy_1_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
	     pt_il_pol_addl_cover_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_assured_dtls_1_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_addl_cover_1_action.setUPDATE_ALLOWED(false);
	     pt_il_pol_beneficiary_action.setUPDATE_ALLOWED(false);
	     pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED( false); 
	     pt_il_pol_assr_illness_dtls_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_charge_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_broker_head_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED( false);
	     pt_il_doc_todo_list_status_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_disc_load_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_condition_action.setUPDATE_ALLOWED( false);
	     pt_il_surr_mat_values_action.setUPDATE_ALLOWED( false);
	     pt_il_unpaid_prem_dtls_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_status_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_status_1_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_red_sa_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_fund_dtl_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_fund_dtl_1_action.setUPDATE_ALLOWED( false);
	     pm_il_doc_todo_group_action.setUPDATE_ALLOWED( false);
	     pt_il_pol_condition_action.setINSERT_ALLOWED(false);		
	    		
	    	pt_il_policy_action.getCOMP_POL_BANK_REF_NO().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_PROP_REF_NO().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_PYMT_TYPE().setDisabled( true);
	    		 
	    		pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_GRANTEE_NAME().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_AGENT_REF_CODE().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_PROJECT_CODE().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_DEVELOPER_CODE().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_INTRODUCER_REF_ID1().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_FLEX_01().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_FLEX_02().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_FLEX_03().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_LC_TOP_UP_AMT().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_GRANTEE_NAME().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_REMARKS().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_FORM_NO().setDisabled( true);
	    		
	    		pt_il_policy_action.getCOMP_POL_RES_ADDRESS_1().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_RES_ADDRESS_2().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_RES_ADDRESS_3().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_RES_AREA_CODE().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_RES_PHONE_NO().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_OFF_ADDRESS_1().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_OFF_ADDRESS_2().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_OFF_ADDRESS_3().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_OFF_AREA_CODE().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_OFF_PHONE_NO().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_CITY_CODE().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_FAX_NO().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_COUNT_CODE().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_FAX_AREA_CODE().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_STATE_CODE().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_MOBILE_NO().setDisabled( true);
	    		pt_il_policy_action.getCOMP_UI_M_POL_CITY_NAME().setDisabled( true);
	    		pt_il_policy_action.getCOMP_UI_M_POL_COUNT_NAME().setDisabled( true);
	    		pt_il_policy_action.getCOMP_UI_M_POL_STATE_NAME().setDisabled( true);
	    		pt_il_policy_action.getCOMP_POL_SRC_OF_BUS().setDisabled( true);
	    		pt_il_pol_condition_action.getCOMP_PLCOND_CODE().setDisabled( true);
	    		pt_il_pol_condition_action.getCOMP_PLCOND_DESC().setDisabled( true);
	    	 
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }

    public void PILT002_APAC_WHEN_NEW_FORM_INSTANCE(
	    PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

	Connection connection = null;
	PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();

	String M_COVER_SA_CALC = null;
	Object[] object = null;
	ResultSet resultSet = null;
	String query1 = " SELECT COVER_SA_CALC FROM PM_IL_COVER  WHERE COVER_CODE = ? ";
	PT_IL_POLICY_HELPER pt_il_policy_helper = new PT_IL_POLICY_HELPER();
	try {

	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
		    .getExternalContext().getSessionMap();

	    /// The POL_PLAN_CODE is set in whenCreateRecord only. 
	    /// So instead of getting the POL_PLAN_CODE from bean get it from global parameter. 
	//    object = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
	   
	    object = new Object[] { CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_3")};
	    
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(query1,
		    connection, object);
	    while (resultSet.next()) {
		M_COVER_SA_CALC = resultSet.getString("COVER_SA_CALC");
	    }

	    if ("F".equalsIgnoreCase(M_COVER_SA_CALC)) {
		pt_il_policy_action.getCOMP_POL_NO_OF_UNIT_LABEL().setValue(
			"SA Factor");// --ADDED BY PIYUSH
	    } else {
		pt_il_policy_action.getCOMP_POL_NO_OF_UNIT_LABEL().setValue(
			"Units");// --ADDED BY SARVINDER
	    }
	    String callingForm = (String) sessionMap.get("CALLING_FORM");
	    /**
	     * if we click the "Policy Dtls" button in the claims entry screen.
	     * it should show the policy details.
	     */
	    if (null!=CommonUtils.getGlobalVariable("CALLING_FORM")&&(CommonUtils.getGlobalVariable("CALLING_FORM").equals("PILT010")
		    || CommonUtils.getGlobalVariable("CALLING_FORM").equals(
			    "PILP052_APAC")
		    || CommonUtils.getGlobalVariable("CALLING_FORM").equals(
			    "PILT006_APAC")
		    || CommonUtils.getGlobalVariable("CALLING_FORM").equals(
			    "PQ123")
		    || CommonUtils.getGlobalVariable("CALLING_FORM").equals(
			    "PILQ121_APAC"))) {
	    //added for claim query	
	    		pt_il_policy_bean.setPOL_SYS_ID((Long)CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID"));
		pt_il_policy_helper.executeQuery(compositeAction);
		// EXECUTE_QUERY.EXECUTE_QUERY();
	    } else if ("PILT041_APAC".equalsIgnoreCase(CommonUtils.getGlobalVariable("CALLING_FORM"))) // ADDED BY SARVINDER/
	    {
		pt_il_policy_helper.executeQuery(compositeAction);
		// EXECUTE_QUERY;
	    } else if ("IL_END_QUOT".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"))) {

		CommonUtils.setGlobalObject("M_POL_SYS_ID", null);
		pt_il_policy_helper.executeQuery(compositeAction);
		// EXECUTE_QUERY.EXECUTE_QUERY();
	    } else if ("N".equalsIgnoreCase(CommonUtils.getGlobalVariable(
		    "GLOBAL.M_PRIVILEGE").substring(0, 1))
		    && "N".equalsIgnoreCase(CommonUtils.getGlobalVariable(
			    "GLOBAL.M_PRIVILEGE").substring(1, 2))) {
		CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID", null);
		// PENDING
		// ENTER_QUERY;
	    } else
		CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID", null);

	    CommonUtils.setGlobalObject("GLOBAL.M_GRP_THRESHOLD", "N");
	    CommonUtils.setGlobalObject("GLOBAL.M_PREV_POL_CUST_CODE", null);
	    CommonUtils.setGlobalObject("GLOBAL.M_POL_CONT_CODE", null);
	    CommonUtils.setGlobalObject("GLOBAL.M_NEW_POL_CUST_CODE", null);
	    CommonUtils.setGlobalObject("GLOBAL.M_PAYER_FOUND", null);

	    // GO_ITEM('PT_IL_POLICY.POL_PROD_CODE');

	    if ("PILT041_APAC".equalsIgnoreCase(CommonUtils.getGlobalVariable("CALLING_FORM"))
		    && "G".equalsIgnoreCase(CommonUtils
			    .getGlobalVariable("GLOBAL.M_PARAM_18"))) {
		compositeAction.getPT_IL_POLICY_ACTION_BEAN()
			.getCOMP_POL_FLEX_03().setDisabled(true);
		if ("Y".equalsIgnoreCase(CommonUtils.getGlobalVariable(
			"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
		    // compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FLEX_03().setDisabled(true);
		    // SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FLEX_03',INSERT_ALLOWED,PROPERTY_TRUE);
		}
		if ("Y".equalsIgnoreCase(CommonUtils.getGlobalVariable(
			"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
		    // compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FLEX_03().setDisabled(true);
		    // SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FLEX_03',UPDATE_ALLOWED,PROPERTY_TRUE);
		}
		// to set enable or disable
		IL_ADD_ENDORSE_CHANGES(compositeAction);
		pt_il_policy_bean.setPOL_APPRV_STATUS("N");
	    } else if ("PILT041_APAC".equalsIgnoreCase(CommonUtils.getGlobalVariable("CALLING_FORM"))
		    && "C".equalsIgnoreCase(CommonUtils
			    .getGlobalVariable("GLOBAL.M_PARAM_18"))) {

		IL_ADD_ENDORSE_CHANGES(compositeAction);
		 IL_ADD_ENDORSE_COMMENT_CHANGES(compositeAction);
		pt_il_policy_bean.setPOL_APPRV_STATUS("N");
	    }

	    if ("Q".equalsIgnoreCase(CommonUtils
		    .getGlobalVariable("GLOBAL.M_PARAM_13"))
		    && "1".equalsIgnoreCase(CommonUtils
			    .getGlobalVariable("GLOBAL.M_PARAM_11"))) {

	    	compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_SURR_MAT_VALUES");
			/*
			 * Commented By Haneef, to fix the issue: After Changing POL_PROP_QUOT_FLAG to 'Q', the below blocks
			 * are disabling, but as confirmed by Raja, All the blocks should be enabled
			 * even if the flag is 'Q'
			 */
	    	
	    	/*compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_BENEFICIARY");
			compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_ASSR_MED_HIST");
			compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_ASSR_ILLNESS_DTLS");
			compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_MED_EXAM_DTL");
			compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_STATUS");
			compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_DISC_LOAD");
			compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_CONDITION");*/

		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_SURR_MAT().setRendered(false);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_PRMDTLS().setRendered(false);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_UPI().setRendered(false);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_UDDATE_STAT().setRendered(false);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_CALC_DISC_LOAD().setRendered(false);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_POL_AMDT().setRendered(false);
		// --compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UIM_BUT_HOLD().setRendered(false);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_CONVERT().setRendered(false);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_UPLOAD().setRendered(false);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_CLAIM().setRendered(false);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_FUND_QUERY().setRendered(false);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_ENDT_QUOT().setRendered(false);
		// --compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UIM_BUT_COPY().setRendered(false);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN()
			.getCOMP_POL_FRZ_FLAG().setDisabled(false);

		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_APPROVAL().setRendered(false);
		compositeAction.getDUMMY_ACTION_BEAN()
		.getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(true);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_ENDT().setRendered(false);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_DOC_GEN_NO().setRendered(false);

		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_CONVERT().setRendered(true);

		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_HOLD().setRendered(true);
		compositeAction.getDUMMY_ACTION_BEAN()
			.getCOMP_UI_M_BUT_HOLD().setDisabled(false);

		/*-=========completed=========
			SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_ASSR_MED_HIST',VISIBLE,PROPERTY_FALSE);
			SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_ASSR_ILLNESS_DTL',VISIBLE,PROPERTY_FALSE);
			SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_MED_EXAM_DTL',VISIBLE,PROPERTY_FALSE);
			SET_TAB_PAGE_PROPERTY('TAB_PT_IL_DOC_TODO_LIST_STATUS',VISIBLE,PROPERTY_FALSE);
			SET_TAB_PAGE_PROPERTY('TAB_PT_IL_SURR_MAT_VALUES',VISIBLE,PROPERTY_FALSE);
			SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_STAT',VISIBLE,PROPERTY_FALSE);
			SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_COMMENTS',VISIBLE,PROPERTY_FALSE);
			SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_DISCOUNT',VISIBLE,PROPERTY_FALSE);
			SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_CONDITION',VISIBLE,PROPERTY_FALSE);
			==========end=========	                                                                         
			SET_ITEM_PROPERTY('M_BUT_SURR_MAT',VISIBLE,PROPERTY_FALSE);
			SET_ITEM_PROPERTY('M_BUT_PRMDTLS',VISIBLE,PROPERTY_FALSE);
			SET_ITEM_PROPERTY('M_BUT_UPI',VISIBLE,PROPERTY_FALSE);
			SET_ITEM_PROPERTY('M_BUT_UDDATE_STAT',VISIBLE,PROPERTY_FALSE);
			SET_ITEM_PROPERTY('M_BUT_CALC_DISC_LOAD',VISIBLE,PROPERTY_FALSE);
			SET_ITEM_PROPERTY('M_BUT_POL_AMDT',VISIBLE,PROPERTY_FALSE);
			--SET_ITEM_PROPERTY('M_BUT_HOLD',VISIBLE,PROPERTY_FALSE);
			SET_ITEM_PROPERTY('M_BUT_CONVERT',VISIBLE,PROPERTY_FALSE);
			SET_ITEM_PROPERTY('M_BUT_UPLOAD',VISIBLE,PROPERTY_FALSE);
			SET_ITEM_PROPERTY('M_BUT_CLAIM',VISIBLE,PROPERTY_FALSE);		
		  SET_ITEM_PROPERTY('M_BUT_FUND_QUERY',VISIBLE,PROPERTY_FALSE);			
		  SET_ITEM_PROPERTY('M_ENDT_QUOT',VISIBLE,PROPERTY_FALSE);
		  --SET_ITEM_PROPERTY('M_BUT_COPY',VISIBLE,PROPERTY_FALSE);
		  SET_ITEM_PROPERTY('POL_FRZ_FLAG',ENABLED,PROPERTY_FALSE);
		                                                         
		  SET_ITEM_PROPERTY('M_BUT_APPROVAL',VISIBLE,PROPERTY_FALSE);
		  SET_ITEM_PROPERTY('M_BUT_ENDT',VISIBLE,PROPERTY_FALSE);
		  SET_ITEM_PROPERTY('M_BUT_DOC_GEN_NO',VISIBLE,PROPERTY_FALSE);

		  SET_ITEM_PROPERTY('M_BUT_CONVERT',VISIBLE,PROPERTY_TRUE);
		 -- SET_ITEM_PROPERTY('M_BUT_CONVERT',ENABLED,PROPERTY_TRUE); --COMMENTED BY SIVARAM TO DISABLE THE CONVERT BUTTON
		  
		  SET_ITEM_PROPERTY('M_BUT_HOLD',VISIBLE,PROPERTY_TRUE);
		  SET_ITEM_PROPERTY('M_BUT_HOLD',ENABLED,PROPERTY_TRUE);
		 */
	    }

	    if ("M".equalsIgnoreCase(compositeAction.getDUMMY_ACTION_BEAN()
		    .getDUMMY_BEAN().getUI_M_POL_PLAN_TYPE())) {
		//PENDING
		// pt_il_policy_action.getCOMP_UI_M_FC_RED_SA().setRendered(false);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN()
			.getCOMP_POL_FC_CURR_SA().setRendered(false);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN()
			.getCOMP_POL_LC_CURR_SA().setRendered(false);
	    }
	    if ("PILQ121_APAC".equalsIgnoreCase(CommonUtils.getGlobalVariable("CALLING_FORM"))) {
		compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT()
			.setDisabled(false);
	    }
	    if ("D".equalsIgnoreCase(compositeAction.getDUMMY_ACTION_BEAN()
			    .getDUMMY_BEAN().getUI_M_POL_PLAN_TYPE())) {
			//compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_MATURITY);
			
			//compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_MATURITY");
			
			
			
		    } else{
			//compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_POL_MATURITY);
		   // compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_MATURITY");
		    }
	    /*
	     * IF (GET_APPLICATION_PROPERTY(CALLING_FORM) IN('PILQ121_APAC'))
	     * THEN ---ANUSREEQUERY
	     * SET_ITEM_PROPERTY('DUMMY.M_BUT_ENDT',ENABLED,PROPERTY_FALSE); END
	     * IF; -- ADDED BY PRAVEEN FOR MATURITY ISSUE IF
	     * :DUMMY.M_POL_PLAN_TYPE='D' THEN
	     * SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_MATURITY',ENABLED,PROPERTY_FALSE);
	     * ELSE
	     * SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_MATURITY',ENABLED,PROPERTY_TRUE);
	     * END IF;
	     */

	    new PT_IL_POLICY_HELPER().enabledisableJointlife(compositeAction);
	    if ("U".equalsIgnoreCase(compositeAction.getDUMMY_ACTION_BEAN()
			    .getDUMMY_BEAN().getUI_M_POL_PLAN_TYPE())) {
	    	pt_il_policy_action.getCOMP_UI_M_POL_FC_GR_ANN_PREM_LABEL().setValue("Total Contribution");
	    }else{
	    	pt_il_policy_action.getCOMP_UI_M_POL_FC_GR_ANN_PREM_LABEL().setValue("Annual Premium");
	    }
	    
	} catch (DBException e) {
	    e.printStackTrace();
	}
    }

    public void PRE_FORM(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	    throws Exception {

	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	DBProcedures dbProcedures = new DBProcedures();

	PT_IL_POLICY_ACTION action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
	PT_IL_POLICY valueBean = action.getPT_IL_POLICY_BEAN();

	DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
	DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();

	String M_PO_SSTDAP_YN = null;
	String M_PR_SSTDAP_YN = null;
	String M_ASD_CHAR_VALUE = null;
	String M_PS_VALUE = null;
	String M_CHAR_CODE = null;
	String M_CODE_DESC = null;
	String M_PS_CODE_DESC = null;
	String M_PS_DESC = null;
	String M_DESC = null;
	String M_TITLE = null;
	double M_MED_HIST_COUNT = -1;
	Object[] object1 = {}, object2 = {}, objectPP_SYS = {}, object3 = {}, objectPlan = {}, object4 = {}, object5 = {}, object6 = {}, object7 = {}, objectBuy = {}, object8 = {};
	ResultSet rs_BUY_SELL = null, rs_PP_SYS = null, rs_PLAN = null, rs_1 = null, rs_2 = null, rs_3 = null, rs_4 = null, rs_5 = null, rs_6 = null, rs_7 = null, rs_8 = null;

	// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added
	String P_CURR_CODE = null;
	String P_NAME = null;
	int P_DECIMAL = -1;
	// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added
	ArrayList<String> pValList = null;
	try {

	    connection = CommonUtils.getConnection();

	   
	    CommonUtils.setGlobalVariable("GLOBAL.M_LC_CHECK", "N");

	   


	    rs_PP_SYS = new CRUDHandler().executeSelectStatement( 
		    PILT002_APAC_QUERY_CONSTANTS.preFormQUERY_PP_SYS,
		    connection );

	    if (rs_PP_SYS.next()) {
		String ps_code =  rs_PP_SYS.getString("PS_CODE");
		CommonUtils.setGlobalVariable("GLOBAL.M_SITE",ps_code);
	    }
	    //STD_PRE_FORM(compositeAction);
	    CommonUtils.setGlobalVariable("GLOBAL.M_PLAN_CHNG", "N");

	    object1 = new Object[] {
		    CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"),
		    CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1") };
	    rs_1 = new CRUDHandler().executeSelectStatement(
		    PILT002_APAC_QUERY_CONSTANTS.preFormQUERY_1, connection,
		    object1);

	    while (rs_1.next()) {
		compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
			.setUI_M_BROKER_YN(rs_1.getString("DS_BROKER_YN"));
	    }

	    if ("N".equalsIgnoreCase(compositeAction.getDUMMY_ACTION_BEAN()
		    .getDUMMY_BEAN().getUI_M_BROKER_YN()))
			//compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);
		    compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_BROKER_HEAD");
		    else
			//compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);
		    compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_BROKER_HEAD");
	    // SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_BROKER_HEAD',ENABLED,PROPERTY_TRUE);

	    object5 = new Object[] { CommonUtils
		    .getGlobalVariable("GLOBAL.M_PARAM_6") };

	    rs_5 = handler.executeSelectStatement(
		    PILT002_APAC_QUERY_CONSTANTS.preFormQUERY_5, connection,
		    object5);

	    while (rs_5.next()) {
		dummy_bean.setUI_M_PROD_PREM_CALC_MTHD(rs_5
			.getString("PROD_PREM_CALC_MTHD"));
		dummy_bean.setUI_M_PROD_PERIOD_MULTIPLE(rs_5
			.getInt("PROD_PERIOD_MULTIPLE"));
		dummy_bean.setUI_M_NOTIONAL(rs_5.getString("PROD_ALLOC_TYPE"));
		dummy_bean.setUI_M_PROD_PREM_TARIFF(rs_5
			.getString("PROD_PREM_TARIFF"));
		dummy_bean.setUI_M_PROD_SA_TARIFF(rs_5
			.getString("PROD_SA_TARIFF"));
		dummy_bean.setUI_M_PROD_SA_FACTOR(rs_5
			.getString("PROD_SA_FACTOR"));
		dummy_bean.setUI_M_PROD_TOPUP_YN(rs_5
			.getString("PROD_TOPUP_YN"));
		dummy_bean.setUI_M_PROD_MATU_DT(rs_5.getString("PROD_MATU_DT"));
		dummy_bean.setUI_M_PROD_AUTO_UW(rs_5.getString("PROD_AUTO_UW"));
		dummy_bean.setUI_M_PROD_SA_ADD_FACTOR(rs_5
			.getString("PROD_SA_ADD_FACTOR"));
	    }
	    object6 = new Object[] { CommonUtils
		    .getGlobalVariable("GLOBAL.M_PARAM_3") };

	    rs_6 = handler.executeSelectStatement(
		    PILT002_APAC_QUERY_CONSTANTS.preFormQUERY_6, connection,
		    object6);
	    if (rs_6.next()) {
		dummy_bean.setUI_M_COVER_SA_CALC(rs_6.getString(1));
		dummy_bean.setUI_M_COVER_FUND_TYPE(rs_6.getString(2));
		dummy_bean.setUI_M_COVER_FUND_MTHD(rs_6.getString(3));
		dummy_bean.setUI_M_COVER_VAR_VALUE(rs_6.getString(4));

	    }
	    object7 = new Object[] { "IL_TAB_RATE" };
	    rs_7 = handler.executeSelectStatement(
		    PILT002_APAC_QUERY_CONSTANTS.preFormQUERY_7, connection,
		    object7);

	    if (rs_7.next()) {
		dummy_bean.setUI_M_CSVSD_PARA_VALUE(rs_7.getDouble(1));
	    }

	    if (CommonUtils.nvl(dummy_bean.getUI_M_CSVSD_PARA_VALUE(), 0) == 1) {
		action.getCOMP_POL_HEALTH_RATE().setRendered(true);
		action.getCOMP_POL_FC_HEALTH_LOAD().setRendered(true);
		action.getCOMP_POL_LC_HEALTH_LOAD().setRendered(true);
		 action.getCOMP_POL_HEALTH_RATE_LABEL().setRendered( true);
		 action.getCOMP_POL_LC_HEALTH_LOAD_LABEL().setRendered( true);
		// SET_ITEM_PROPERTY('BP.B_POL_HEALTH_LC_LOAD',VISIBLE,PROPERTY_TRUE);
	    } else {
		action.getCOMP_POL_HEALTH_RATE().setRendered(false);
		action.getCOMP_POL_FC_HEALTH_LOAD().setRendered(false);
		action.getCOMP_POL_LC_HEALTH_LOAD().setRendered(false);
		action.getCOMP_POL_HEALTH_RATE_LABEL().setRendered( false);
		 action.getCOMP_POL_LC_HEALTH_LOAD_LABEL().setRendered( false);
		// SET_ITEM_PROPERTY('BP.B_POL_HEALTH_RATE',VISIBLE,PROPERTY_FALSE);
		// SET_ITEM_PROPERTY('BP.B_POL_HEALTH_LC_LOAD',VISIBLE,PROPERTY_FALSE);
	    }

	    pValList = dbProcedures.callP_VAL_SYSTEM("ILUWMEDHT", "ILUWMEDHT",
		    "N");
	    if (pValList != null && pValList.size() > 0) {
		M_CODE_DESC = pValList.get(0);
		dummy_bean.setUI_M_ILUWMEDHT(Double.parseDouble(pValList.get(1)));
	    }

	  /*  if ("1".equalsIgnoreCase(CommonUtils.getGlobalVariable(
		    "GLOBAL.M_FOR_LANG_CODE").substring(4, 5))) {
		//
	    }*/
	    /*
	     * String forLangCode = CommonUtils
	     * .getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"); forLangCode =
	     * forLangCode == null ? "" : forLangCode;
	     */

	    /**
	     * Calling P_VAL_FINAL_PARAMETER Procedure and set the corresponding
	     * O/P in Dummy.M_BASE_CURR
	     */
	    pValList = new ArrayList<String>();

	    pValList = DBProcedures.P_VAL_FINAL_PARAMETER(connection,
		    "BASE.CURR", "E");
	    // ('BASE.CURR', :DUMMY.M_BASE_CURR, 'E') ;
	    if (pValList != null && pValList.size() > 0) {
		dummy_bean.setUI_M_BASE_CURR(pValList.get(0));
	  
		makeCurrDecimalglobal(dummy_bean.getUI_M_BASE_CURR());
	  //  dummy_bean.setUI_M_CURR_DECIMAL(makeCurrDecimalglobal(dummy_bean.getUI_M_BASE_CURR()));
	    }

	    objectBuy = new Object[] {
		    CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"),
		    CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1") };

	    rs_BUY_SELL = new CRUDHandler().executeSelectStatement(
		    PILT002_APAC_QUERY_CONSTANTS.preFormQUERY_BUY_SELL,
		    connection, objectBuy);

	    while (rs_BUY_SELL.next()) {
		dummy_bean.setUI_M_BUY_SELL(rs_BUY_SELL
			.getString("DS_CURR_RATE_BS"));
	    }

	    dummy_bean.setPT_IL_POLICY_CF("N");
	    dummy_bean.setPT_IL_POL_ASSURED_DTLS_CF("P");
	    dummy_bean.setPT_IL_POL_ADDL_COVER_CF("P");
	    dummy_bean.setPT_IL_POL_CHARGE_CF("P");
	    dummy_bean.setPT_IL_POL_DISC_LOAD_CF("P");
	    dummy_bean.setPT_IL_DOC_TODO_LIST_STATUS_CF("P");
	    dummy_bean.setPT_IL_POL_BROKER_HEAD_CF("P");
	    dummy_bean.setPT_IL_POL_BROKER_DTL_CF("P");
	    dummy_bean.setPT_IL_SURR_MAT_VALUES_CF("N");
	    dummy_bean.setPT_IL_UNPAID_PREM_DTLS_CF("N");
	    dummy_bean.setPT_IL_POL_BENEFICIARY_CF("N");
	    dummy_bean.setPT_IL_POL_ASSR_ILLNESS_DTLS_CF("N");
	    dummy_bean.setPT_IL_POL_ASSR_MED_HIST_CF("N");
	    dummy_bean.setPT_IL_POL_MED_EXAM_DTL_CF("N");
	    dummy_bean.setPT_IL_POL_CONDITION_CF("N");

	    /*
	     * M_TITLE = valueBean.getUI_M_USER_ID() + " " +
	     * valueBean.getUI_M_SCR_NAME() + " " + ConvertFunctions.to_char(new
	     * java.sql.Date(Calendar .getInstance().getTimeInMillis()),
	     * "DD/MM/YY");
	     */

	    // SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
	    /**
	     * Calling P_VAL_SYSTEM Procedure and set the corresponding O/P in
	     * M_DESC & Dummy.IL_DOC_GEN Respectively
	     */

	    pValList = new ArrayList<String>();

	    pValList = dbProcedures.callP_VAL_SYSTEM("IL_DOC_GEN",
		    "IL_DOC_GEN", "N");

	    if (pValList != null && pValList.size() > 0) {
		M_DESC = pValList.get(0);
		dummy_bean.setUI_M_IL_DOC_GEN(pValList.get(1));
	    }

	    if ("1".equals(dummy_bean.getUI_M_IL_DOC_GEN())) {
		dummy_action.getCOMP_UI_M_BUT_DOC_GEN_NO().setRendered(false);
	    } else {
		dummy_action.getCOMP_UI_M_BUT_DOC_GEN_NO().setRendered(true);
	    }

	    /**
	     * Calling P_VAL_SYSTEM Procedure and set the corresponding O/P in
	     * M_DESC & Dummy.IL_DOC_GEN Respectively
	     */
	    pValList = new ArrayList<String>();

	    pValList = dbProcedures.callP_VAL_SYSTEM("IL_ASSRIND",
		    "IL_ASSRIND", "N");

	    if (pValList != null && pValList.size() > 0) {
		M_DESC = pValList.get(0);
		dummy_bean.setUI_M_IL_ASSRIND(pValList.get(1));
	    }

	    objectPlan = new Object[] { CommonUtils
		    .getGlobalVariable("GLOBAL.M_PARAM_3") };

	    rs_PLAN = handler.executeSelectStatement(
		    PILT002_APAC_QUERY_CONSTANTS.preFormQUERY_PLAN, connection,
		    objectPlan);

	    if (rs_PLAN.next()) {
		dummy_bean
			.setUI_M_POL_PLAN_TYPE(rs_PLAN.getString("PLAN_TYPE"));
		dummy_bean.setUI_M_PLAN_AGE_TERM_FLAG(rs_PLAN
			.getString("PLAN_AGE_TERM_FLAG"));
		dummy_bean.setUI_M_PLAN_RED_SA_BASIS(rs_PLAN
			.getString("PLAN_RED_SA_BASIS"));
		dummy_bean.setUI_M_PLAN_CALC_TYPE(rs_PLAN
			.getString("PLAN_CALC_TYPE"));
	    }

	    if (!"A".equalsIgnoreCase(dummy_bean.getUI_M_POL_PLAN_TYPE())
		    || !"S".equalsIgnoreCase(dummy_bean.getUI_M_POL_PLAN_TYPE())) {

		compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
			.getCOMP_POAD_FC_SUM_ASSURED().setDisabled(true);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
			.getCOMP_POAD_LC_SUM_ASSURED().setDisabled(true);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
			.getCOMP_POAD_FC_SUM_ASSURED().setDisabled(true);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
			.getCOMP_POAD_LC_SUM_ASSURED().setDisabled(true);
	    }
	    if ("A".equalsIgnoreCase(dummy_bean.getUI_M_POL_PLAN_TYPE())
		    || "S".equalsIgnoreCase(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
	    
		compositeAction.getPT_IL_POLICY_ACTION_BEAN()
			.getCOMP_POL_FC_SUM_ASSURED().setRequired(false);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN()
			.getCOMP_POL_LC_SUM_ASSURED().setRequired(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
			.getCOMP_POAD_FC_SUM_ASSURED().setRequired(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
			.getCOMP_POAD_LC_SUM_ASSURED().setRequired(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
			.getCOMP_POAD_CATG_CODE().setRequired(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
			.getCOMP_POAD_FC_SUM_ASSURED().setRequired(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
			.getCOMP_POAD_LC_SUM_ASSURED().setRequired(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
			.getCOMP_POAD_CATG_CODE().setRequired(false);
	    }

	    object8 = new Object[] {
		    CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
		    "FAC_YN", CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_6") };

	    rs_8 = handler.executeSelectStatement(
		    PILT002_APAC_QUERY_CONSTANTS.preFormQUERY_8, connection,
		    object8);
	    while (rs_8.next()) {

		M_ASD_CHAR_VALUE = rs_8.getString("ASD_CHAR_VALUE");
	    }

	    if ("N".equals(CommonUtils.nvl(M_ASD_CHAR_VALUE, "N"))) {
		action.getCOMP_POL_FAC_YN().setDisabled(false);
	    } 
	    else {
		action.getCOMP_POL_FAC_YN().setDisabled(false);
	    }

	    CommonUtils.setGlobalVariable("GLOBAL.M_AGENT_RATE", "Y");

	    // String planType = dummy_bean.getUI_M_POL_PLAN_TYPE();
	    if (CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_4") != null
		    && "S".equals(dummy_bean.getUI_M_POL_PLAN_TYPE() )) {

		dummy_bean.setUI_M_AMAN_PLAN_CODE(CommonUtils
			.getGlobalVariable("GLOBAL.M_PARAM_4"));
	    } else if (CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_4") == null
		    && "S".equalsIgnoreCase(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
		throw new Exception(
			Messages
				.getString(PELConstants.pelErrorMessagePath,
					"Required Aman plan code not defined in menu setup 4th parameter"));
		// throw ValidatorException();
	    }
	    /*Site parameter code handled by Ameen on 06-03-2018 to take based on site code*/

	    if ("1".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"))) {
			if ("P".equals(CommonUtils
				.getGlobalVariable("GLOBAL.M_PARAM_13"))) {
	
			    action
				    .getCOMP_POL_NO_LABEL()
				    .setValue(
					    Messages
						    .getString(
						    		CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")+"messageProperties_PILT002_APAC",
							    "PILT002_APAC$PT_IL_POLICY$POL_NO_P$caption")); // Proposal
													    // No
	
			    action
				    .getCOMP_POL_PROP_NO_LABEL()
				    .setValue(
					    Messages
						    .getString(
						    		CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")+"messageProperties_PILT002_APAC",
							    "PILT002_APAC$PT_IL_POLICY$POL_PROP_NO_Q$caption")); // 'Quotation
														    // No'
	
			    
			} else if ("Q".equals(CommonUtils
				.getGlobalVariable("GLOBAL.M_PARAM_13"))) {
			    action
				    .getCOMP_POL_NO_LABEL()
				    .setValue(
					    Messages
						    .getString(
						    		CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")+"messageProperties_PILT002_APAC",
							    "PILT002_APAC$PT_IL_POLICY$POL_NO_Q$caption")); // 'Quotation
													    // No.'
			}
			
			/*added by gopi for hands on feed back issue,serial no 18 in ZB on 31/01/17*/
		    action.getCOMP_POL_QUOT_NO_LABEL().setRendered(false);
		    action.getCOMP_POL_QUOT_NO().setRendered(false);
		    /*end*/
		}else {

		/**
		 * Calling P_VAL_SYSTEM Procedure and set the corresponding O/P
		 * in M_CODE_DESC & M_PS_VALUE Respectively
		 */
			
				pValList = new ArrayList<String>();
				pValList = dbProcedures.callP_VAL_SYSTEM("IL_BP_PARA",
					"IL_BP_PARA", "E");
				if (pValList != null && pValList.size() > 0) {
				    M_CODE_DESC = pValList.get(0);
				    M_PS_VALUE = pValList.get(1);
				}

				if (M_PS_VALUE != null && M_PS_VALUE.equals("2")) {
				    action
					    .getCOMP_POL_NO_LABEL()
					    .setValue(
						    Messages
							    .getString(
							    		CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")+"messageProperties_PILT002_APAC",
								    "PILT002_APAC$PT_IL_POLICY$POL_NO_2$caption")); // Certificate
														    // No.';
		
				} else {
				    action
					    .getCOMP_POL_NO_LABEL()
					    .setValue(
						    Messages
							    .getString(
							    		CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")+"messageProperties_PILT002_APAC",
								    "PILT002_APAC$PT_IL_POLICY$POL_NO$caption")); // Policy	 No.';

		    /*
		     * // [ bugid:137 Aniesh 18-Dec-2008-Policy Screen -fix
		     * action.setPOLICY_NO_LABEL(Messages.getString(
		     * "messageProperties_PILT002_APAC",
		     * "PILT002_APAC$PT_IL_POLICY$POL_PROP_NO$caption")); if
		     * (null != action.getPT_IL_POLICY_BEAN().getPOL_PROP_NO()) {
		     * (action.getCOMP_POLICY_NO()).setSubmittedValue(action
		     * .getPT_IL_POLICY_BEAN().getPOL_PROP_NO()); }
		     *  // bugid:137 Aniesh 18-Dec-2008-Policy Screen -fix]
		     */}
		 action
			.getCOMP_POL_PROP_NO_LABEL()
			.setValue(
				Messages
					.getString(
						"messageProperties_PILT002_APAC",
						"PILT002_APAC$PT_IL_POLICY$POL_PROP_NO$caption"));  // Proposal No.';
		 
		 /*added by gopi for hands on feed back issue,serial no 18 in ZB on 31/01/17*/
		    action.getCOMP_POL_QUOT_NO_LABEL().setRendered(true);
		    action.getCOMP_POL_QUOT_NO().setRendered(true);
		    /*end*/
			
	    }
	    /*
	     * valueBean.setPOL_DS_TYPE(CommonUtils
	     * .getGlobalVariable("GLOBAL.M_PARAM_11"));
	     */
	    
	    
	    if ("U".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
			    dummy_action.getCOMP_UI_M_BUT_FUND_QUERY().setDisabled(
				    false);
			    dummy_action.getCOMP_UI_M_BUT_FUND_QUERY().setRendered(true);
			}else{
				 dummy_action.getCOMP_UI_M_BUT_FUND_QUERY().setRendered(false);
			}
	    
	    

	    if (CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_5") == null) {
		CommonUtils.setGlobalVariable("GLOBAL.M_PARAM_5", "S");
	    }
	    /*
	     * HIDE_VIEW('PT_IL_POL_ADDL_COVER_PAYOR_1');
	     * HIDE_VIEW('PT_IL_POL_ADDL_COVER_PAYOR_2');
	     * HIDE_VIEW('PT_IL_POL_ADDL_COVER_PAYEE_1');
	     * HIDE_VIEW('PT_IL_POL_ADDL_COVER_PAYEE_2');
	     * 
	     * HIDE_VIEW('PT_IL_POL_ADDRESS'); HIDE_VIEW('PT_IL_PAYEE_DTLS');
	     * HIDE_VIEW('PT_IL_PAYOR_DTLS'); HIDE_VIEW('PT_IL_POLICY2');* /
	     * 
	     * /** Calling P_VAL_SYSTEM Procedure and set the corresponding O/P
	     * in M_PS_CODE_DESC & DUMMY.M_CALC_METHOD Respectively
	     */

	    dummy_action.getCOMP_UI_M_BUT_MORE_COVER().setValue("More Info.");
	    dummy_action.getCOMP_UI_M_BUT_ADD_DETAILS().setDisabled(true);

	    pValList = dbProcedures.callP_VAL_SYSTEM("IL_CALC_MTHD",
		    "IL_CALC_MTHD", "N");


	    if (pValList != null &&  pValList.get(0)!=null) {
		M_PS_CODE_DESC = pValList.get(0);
	    }
	    if( pValList.get(1)!=null){
		dummy_bean.setUI_M_CALC_METHOD(Integer.parseInt(pValList.get(1)));
	    }

	    //ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
	    // || dummy_bean.getUI_M_CALC_METHOD() == 2
	    
	    if (dummy_bean.getUI_M_CALC_METHOD() == 1 || dummy_bean.getUI_M_CALC_METHOD() == 2) {

		if ("1".equals(valueBean.getPOL_DS_TYPE())) {

		    M_CHAR_CODE = "PR_SSTDAP_YN";

		    object3 = new Object[] {
			    CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
			    M_CHAR_CODE,
			    CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_6") };
		    rs_3 = handler.executeSelectStatement(
			    PILT002_APAC_QUERY_CONSTANTS.preFormQUERY_3,
			    connection, object3);
		    if (rs_3.next()) {
			M_PR_SSTDAP_YN = rs_3.getString("ASD_CHAR_VALUE");

		    }

		    if (CommonUtils.nvl(M_PR_SSTDAP_YN, "N").equals("N")) {
			action.getCOMP_POL_STD_RISK_YN().setDisabled(true);
		    } else if (MigratingFunctions.nvl(M_PR_SSTDAP_YN, "N")
			    .equals("Y")) {
			action.getCOMP_POL_STD_RISK_YN().setDisabled(false);
			// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_STD_RISK_YN',NAVIGABLE,PROPERTY_TRUE);

			if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 2))) {

			    // SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_POLICY.POL_STD_RISK_YN",UPDATE_ALLOWED,PROPERTY_TRUE);
			}
		    }
		} else if ("2".equals(valueBean.getPOL_DS_TYPE())) {
		    M_CHAR_CODE = "PO_SSTDAP_YN";

		    object3 = new Object[] {
			    CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
			    M_CHAR_CODE,
			    CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_6") };
		    rs_3 = handler.executeSelectStatement(
			    PILT002_APAC_QUERY_CONSTANTS.preFormQUERY_3,
			    connection, object3);
		    if (rs_3.next()) {
			M_PR_SSTDAP_YN = rs_3.getString("ASD_CHAR_VALUE");

		    }

		    if (CommonUtils.nvl(M_PO_SSTDAP_YN, "N").equals("N")) {
			action.getCOMP_POL_STD_RISK_YN().setDisabled(true);
		    } else if (CommonUtils.nvl(M_PO_SSTDAP_YN, "N").equals("Y")) {
			action.getCOMP_POL_STD_RISK_YN().setDisabled(false);
			// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_POLICY.POL_STD_RISK_YN",NAVIGABLE,PROPERTY_TRUE);
			if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
			    // SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_POLICY.POL_STD_RISK_YN",UPDATE_ALLOWED,PROPERTY_TRUE);
			}
		    }
		}
	    }
	    
	    //ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.(dummy_bean.getUI_M_CALC_METHOD() == 2)
	    
	    if (dummy_bean.getUI_M_CALC_METHOD() == 1 || dummy_bean.getUI_M_CALC_METHOD() == 2) {

		/*
		 * SET_TAB_PAGE_PROPERTY('TAB_TAKAFUL_DTLS',VISIBLE,PROPERTY_TRUE);
		 * SET_TAB_PAGE_PROPERTY('TAB_TAKAFUL_PREMIUM',VISIBLE,PROPERTY_TRUE);
		 * SET_TAB_PAGE_PROPERTY('TAB_PREMIUM_DETAILS',VISIBLE,PROPERTY_FALSE);
		 * SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_STAT',VISIBLE,PROPERTY_TRUE);
		 * SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_ASSR_MED_HIST',VISIBLE,PROPERTY_FALSE);
		 */

			///compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_TAKAFUL_DTLS);
			//compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_TAKAFUL_DTLS");
			//compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_TAKAFUL_PREMIUM);
			compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_TAKAFUL_PREM_DTLS");
			
	    	
			//compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PREMIUM_DETAILS);
			compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_PREM_DTLS");
			//compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_POL_STAT);
			//compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_PT_IL_POL_STAT");
			//compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_ASSR_MED_HIST);
			compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_ASSR_MED_HIST");

		//dummy_action.getCOMP_UI_M_BUT_UDDATE_STAT().setRendered(true);
		dummy_action.getCOMP_UI_M_BUT_PRMDTLS().setDisabled(true);
		//Commented by Kavi  this functionality is not available in p9
		//dummy_action.getCOMP_UI_M_BUT_POL_AMDT().setRendered(true);

		if ("M".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())
			|| "R".equals(dummy_bean.getUI_M_PLAN_RED_SA_BASIS())) {

		    action.getCOMP_POL_CREDIT_INT_RATE().setRequired(true);
		} else {
		    action.getCOMP_POL_CREDIT_INT_RATE().setRequired(false);
		}
		action.getCOMP_POL_DEFER_PRD().setRequired(true);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
			.getCOMP_POAD_DOB().setRequired(true);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
			.getCOMP_POAD_DOB().setRequired(true);

		if (CommonUtils.nvl(dummy_bean.getUI_M_PROD_AUTO_UW(), "N")
			.equals("Y")) {

		    compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
			    .getCOMP_POAD_HEIGHT().setRequired(true);
		    compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
			    .getCOMP_POAD_WEIGHT().setRequired(true);
		    compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
			    .getCOMP_POAD_OCC_CODE().setRequired(true);
		    compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
			    .getCOMP_POAD_OCC_CLASS().setRequired(true);
		    compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
			    .getCOMP_POAD_HEIGHT().setRequired(true);
		    compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
			    .getCOMP_POAD_WEIGHT().setRequired(true);
		    compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
			    .getCOMP_POAD_OCC_CODE().setRequired(true);
		    compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
			    .getCOMP_POAD_OCC_CLASS().setRequired(true);
		}
		action.getCOMP_POL_PROFIT_RATE().setRequired(true);
		action.getCOMP_POL_NO_OF_INST().setRequired(true);
	    } else {

			//compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_TAKAFUL_DTLS);
			//compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_TAKAFUL_DTLS");
			//compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_TAKAFUL_PREMIUM);
			compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_TAKAFUL_PREM_DTLS");
			//compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PREMIUM_DETAILS);
			compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_PREM_DTLS");
			//compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_STAT);
			//compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_PT_IL_POL_STAT");
			//compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_ASSR_MED_HIST);
			compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_ASSR_MED_HIST");

		/*
		 * SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("TAB_TAKAFUL_DTLS",VISIBLE,PROPERTY_FALSE);
		 * SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("TAB_TAKAFUL_PREMIUM",VISIBLE,PROPERTY_FALSE);
		 * SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("TAB_PREMIUM_DETAILS",VISIBLE,PROPERTY_TRUE);
		 * SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("TAB_PT_IL_POL_STAT",VISIBLE,PROPERTY_FALSE);
		 * SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("TAB_PT_IL_POL_ASSR_MED_HIST",VISIBLE,PROPERTY_FALSE);
		 */

		/*
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_UDDATE_STAT',VISIBLE,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_POL_AMDT',VISIBLE,PROPERTY_FALSE);
		 */
		dummy_action.getCOMP_UI_M_BUT_UDDATE_STAT().setRendered(false);
		dummy_action.getCOMP_UI_M_BUT_POL_AMDT().setRendered(false);

		if (dummy_action.getCOMP_UI_M_BUT_PRMDTLS().isRendered()==true) {
		    dummy_action.getCOMP_UI_M_BUT_PRMDTLS().setDisabled(false);
		    // SET_ITEM_PROPERTY('DUMMY.M_BUT_PRMDTLS',NAVIGABLE,PROPERTY_TRUE);
		}

		action.getCOMP_POL_NO_OF_INST().setRendered(false);
		action.getCOMP_POL_NO_OF_INST_LABEL().setRendered(false);
		action.getCOMP_POL_CREDIT_INT_RATE().setRequired(false);
		action.getCOMP_POL_DEFER_PRD().setRequired(false);
		action.getCOMP_POL_PROFIT_RATE().setRequired(false);
		action.getCOMP_POL_NO_OF_INST().setRequired(false);
	    }
	    
	    //ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
	    
	    if ((dummy_bean.getUI_M_CALC_METHOD() == 1 || dummy_bean.getUI_M_CALC_METHOD() == 2)
		    && !CommonUtils
			    .nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(), "X")
			    .equals("M")) {
			//compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_TAKAFUL_PREMIUM);
			compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_TAKAFUL_PREM_DTLS");
			//compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PREMIUM_DETAILS);
			compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_PREM_DTLS");

		/*
		 * SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("TAB_TAKAFUL_PREMIUM",VISIBLE,PROPERTY_FALSE);
		 * SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("TAB_PREMIUM_DETAILS",VISIBLE,PROPERTY_TRUE);
		 */
			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
			
	    } else if ((dummy_bean.getUI_M_CALC_METHOD() == 1 || dummy_bean.getUI_M_CALC_METHOD() == 2)
		    && CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(), "X")
			    .equals("M")) {
		if ("T".equals(dummy_bean.getUI_M_PROD_PREM_CALC_MTHD())) {

			   // compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_TAKAFUL_PREMIUM);
		    compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_TAKAFUL_PREM_DTLS");
		   // compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PREMIUM_DETAILS);
		    compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_PREM_DTLS");

		    /*
		     * SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("TAB_TAKAFUL_PREMIUM",VISIBLE,PROPERTY_FALSE);
		     * SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("TAB_PREMIUM_DETAILS",VISIBLE,PROPERTY_TRUE);
		     */
		} else {

			   // compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_TAKAFUL_PREMIUM);
		    compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_TAKAFUL_PREM_DTLS");
		   //.getTabbedBar().setTabDisabled(compositeAction.TAB_PREMIUM_DETAILS);
		    compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_PREM_DTLS");
		    /*
		     * SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("TAB_TAKAFUL_PREMIUM",VISIBLE,PROPERTY_TRUE);
		     * SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("TAB_PREMIUM_DETAILS",VISIBLE,PROPERTY_FALSE);
		     */
		}
	    }
	    object2 = new Object[] {
		    CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"),
		    CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1") };
	    rs_2 = handler.executeSelectStatement(
		    PILT002_APAC_QUERY_CONSTANTS.preFormQUERY_2, connection,
		    object2);
	    if (rs_2.next()) {

		M_MED_HIST_COUNT = rs_2.getDouble(1);

	    }
	    if (CommonUtils.nvl(M_MED_HIST_COUNT, 0) == 0) {
			//compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_ASSR_MED_HIST);
			compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_ASSR_MED_HIST");
		// SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("TAB_PT_IL_POL_ASSR_MED_HIST",ENABLED,PROPERTY_FALSE);
	    }
	    dummy_bean.setUI_M_AGE(null);

	    /**
	     * Calling P_VAL_SYSTEM Procedure and set the corresponding O/P in
	     * M_PS_DESC & DUMMY.M_IL_BROK_CALC Respectively
	     */
	    pValList = new ArrayList<String>();

	    pValList = dbProcedures.callP_VAL_SYSTEM("IL_BROK_CALC",
		    "IL_BROK_CALC", "N");
	    if (pValList != null & pValList.size() > 0) {
		M_PS_DESC = pValList.get(0);
		dummy_bean.setUI_M_IL_BROK_CALC(Integer.parseInt(pValList
			.get(1)));
	    }
	    /**
	     * Calling P_VAL_SYSTEM Procedure and set the corresponding O/P in
	     * M_PS_DESC & DUMMY.M_IL_BEN_VALUE Respectively
	     */

	    pValList = new ArrayList<String>();
	    pValList = dbProcedures.callP_VAL_SYSTEM("IL_BEN_LMT",
		    "IL_BEN_LMT", "N");
	    if (pValList != null && pValList.size() > 0) {
		M_PS_DESC = pValList.get(0);
		dummy_bean.setUI_M_IL_BEN_VALUE(Double.parseDouble(pValList.get(1)));
	    }

	    if (CommonUtils.nvl(dummy_bean.getUI_M_IL_BROK_CALC(), 2) == 1) {
		compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
			.getCOMP_POBH_ACTING_AGENT_YN().setDisabled(true);
	    } else {
		compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
			.getCOMP_POBH_ACTING_AGENT_YN().setDisabled(false);
		// SET_ITEM_PROPERTY('PT_IL_POL_BROKER_HEAD.POBH_ACTING_AGENT_YN',NAVIGABLE,PROPERTY_TRUE);
		if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
			.substring(1, 2).equals("Y")) {
		    // SET_ITEM_PROPERTY('PT_IL_POL_BROKER_HEAD.POBH_ACTING_AGENT_YN',UPDATE_ALLOWED,PROPERTY_TRUE);
		}
	    }

	    object4 = new Object[] { "IL_MR_RED_SA", "IL_MR_RED_SA" };

	    rs_4 = handler.executeSelectStatement(
		    PILT002_APAC_QUERY_CONSTANTS.preFormQUERY_4, connection,
		    object4);

	    if (rs_4.next()) {
		dummy_bean.setUI_M_IL_RED_SA_END(rs_4.getString(1));
	    }

	    if (dummy_bean.getUI_M_NOTIONAL() != null
		    && "N".equals(dummy_bean.getUI_M_NOTIONAL())) {
		/*
		 * SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_POL_FUND_DTL",INSERT_ALLOWED,PROPERTY_FALSE);
		 * SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_POL_FUND_DTL",UPDATE_ALLOWED,PROPERTY_FALSE);
		 * SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_POL_FUND_DTL",DELETE_ALLOWED,PROPERTY_FALSE);
		 */
	    } else if ("O".equals(dummy_bean.getUI_M_NOTIONAL())) {
		if ("Y".equals(CommonUtils.getGlobalVariable(
			"GLOBAL.M_PRIVILEGE").substring(0,1))) {
		    // SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_POL_FUND_DTL",INSERT_ALLOWED,PROPERTY_TRUE);
		}
		if ("Y".equals(CommonUtils.getGlobalVariable(
			"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
		    // SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_POL_FUND_DTL",UPDATE_ALLOWED,PROPERTY_TRUE);
		}
		if ("Y".equals(CommonUtils.getGlobalVariable(
			"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
		    // SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_POL_FUND_DTL",DELETE_ALLOWED,PROPERTY_TRUE);
		}
	    }

	    dummy_action.getCOMP_UI_M_BUT_CALC_DISC_LOAD().setDisabled(false);
         /* commented by saranya for RSA Button on 29-06-2016*/
	    /*if ("R".equals(dummy_bean.getUI_M_PLAN_RED_SA_BASIS())) {*/
	    /*
	    */
	    
	    System.out.println("dummy_bean.getUI_M_PLAN_RED_SA_BASIS()   : "+dummy_bean.getUI_M_PLAN_RED_SA_BASIS());
	    System.out.println("dummy_bean.getUI_M_POL_PLAN_TYPE()       : "+dummy_bean.getUI_M_POL_PLAN_TYPE());
	    if (("R".equals(dummy_bean.getUI_M_PLAN_RED_SA_BASIS()))||("M".equalsIgnoreCase(dummy_bean.getUI_M_POL_PLAN_TYPE()))) {
		compositeAction.getPT_IL_POL_RED_SA_ACTION_BEAN()
			.getCOMP_UI_M_BUT_RD_SA().setDisabled(false);
		compositeAction.getPT_IL_POL_RED_SA_ACTION_BEAN()
			.getCOMP_UI_M_BUT_RD_SA1().setDisabled(false);
	    } else {
		compositeAction.getPT_IL_POL_RED_SA_ACTION_BEAN()
			.getCOMP_UI_M_BUT_RD_SA().setDisabled(true);
		compositeAction.getPT_IL_POL_RED_SA_ACTION_BEAN()
			.getCOMP_UI_M_BUT_RD_SA1().setDisabled(true);
	    }

	    if (!"U".equals(dummy_bean.getUI_M_COVER_SA_CALC())
		    && !"F".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
		action.getCOMP_POL_NO_OF_UNIT().setDisabled(true);
	    }

	    if ("U".equals(dummy_bean.getUI_M_COVER_SA_CALC())
		    || "F".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
		action.getCOMP_POL_NO_OF_UNIT().setRequired(true);
	    } else {
		action.getCOMP_POL_NO_OF_UNIT().setRequired(false);
	    }

	    if (dummy_bean.getUI_M_COVER_SA_CALC() != null
		    && !"A".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
		action.getCOMP_POL_SUB_PLAN_CODE().setDisabled(true);
		
	    } else if (dummy_bean.getUI_M_COVER_SA_CALC() != null
		    && "A".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
		action.getCOMP_POL_SUB_PLAN_CODE().setDisabled(false);
		action.getCOMP_POL_SUB_PLAN_CODE().setRequired(true);
	    }

	    if ("U".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {

		action.getCOMP_POL_FC_MIN_PREM().setDisabled(true);
		action.getCOMP_POL_LC_MIN_PREM().setDisabled(true);
		action.getCOMP_POL_FC_EXTRA_PREM().setDisabled(true);
		action.getCOMP_POL_LC_EXTRA_PREM().setDisabled(true);

		action.getCOMP_POL_DEF_IMM_FLAG().setRendered(false);
		action.getCOMP_POL_FC_MON_ANNU_AMT().setRendered(false);
		action.getCOMP_POL_LC_MON_ANNU_AMT().setRendered(false);
		dummy_action.getCOMP_UI_M_BUT_ANN_DTLS().setRendered(false);

		action.getCOMP_POL_DEF_IMM_FLAG_LABEL().setRendered(false);
		action.getCOMP_POL_LC_MON_ANNU_AMT_LABEL().setRendered(false);
		action.getCOMP_POL_FC_MON_ANNU_AMT_LABEL().setRendered(false);

		
		/*Added by Janani on 11.04.2017 for issue reported by Sivaram*/
		System.out.println("PLan type to hide extra premium fields                       :"+dummy_bean.getUI_M_POL_PLAN_TYPE());
		action.getCOMP_POL_FC_EXTRA_PREM().setRendered(false);
		action.getCOMP_POL_LC_EXTRA_PREM().setRendered(false);
		
		/*End*/
		
	    } else {
		if ("D".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {

		    action.getCOMP_POL_DEF_IMM_FLAG().setRendered(true);
		    action.getCOMP_POL_FC_MON_ANNU_AMT().setRendered(true);
		    action.getCOMP_POL_LC_MON_ANNU_AMT().setRendered(true);

		    if ("G".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {

			action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
			action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(true);
			action.getCOMP_POL_FC_MON_ANNU_AMT().setRequired(true);
			action.getCOMP_POL_LC_MON_ANNU_AMT().setRequired(true);
		    } else {
			action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(false);
			action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(false);
			action.getCOMP_POL_FC_SUM_ASSURED().setRequired(true);
			action.getCOMP_POL_LC_SUM_ASSURED().setRequired(true);
		    }
		    dummy_action.getCOMP_UI_M_BUT_ANN_DTLS().setDisabled(false);
		    action.getCOMP_POL_DEF_IMM_FLAG_LABEL().setRendered(true);
		    action.getCOMP_POL_LC_MON_ANNU_AMT_LABEL().setRendered(true);
		    action.getCOMP_POL_FC_MON_ANNU_AMT_LABEL().setRendered(true);

		    /*
		     * action.getCOMP_POL_FC_MIN_PREM().setDisabled(true);
		     * action.getCOMP_POL_LC_MIN_PREM().setDisabled(true);
		     * action.getCOMP_POL_FC_EXTRA_PREM().setDisabled(true);
		     * action.getCOMP_POL_LC_EXTRA_PREM().setDisabled(true);
		     */
		} else {
		    action.getCOMP_POL_DEF_IMM_FLAG().setRendered(false);
		    action.getCOMP_POL_FC_MON_ANNU_AMT().setRendered(false);
		    action.getCOMP_POL_LC_MON_ANNU_AMT().setRendered(false);
		    dummy_action.getCOMP_UI_M_BUT_ANN_DTLS().setRendered(false);

		    action.getCOMP_POL_DEF_IMM_FLAG_LABEL().setRendered(false);
		    action.getCOMP_POL_LC_MON_ANNU_AMT_LABEL().setRendered( false);
		    action.getCOMP_POL_FC_MON_ANNU_AMT_LABEL().setRendered( false);
		}

		//action.getCOMP_POL_FC_MIN_PREM().setRendered(false);
		//its use for rendering both component together 
		action.getCOMP_REGION_ONE().setRendered(false);
		//action.getCOMP_POL_LC_MIN_PREM().setRendered(false);
		action.getCOMP_REGION_TWO().setRendered(false);
		//action.getCOMP_POL_FC_EXTRA_PREM().setRendered(false);
		action.getCOMP_REGION_FOUR().setRendered(false);
		action.getCOMP_REGION_THREE().setRendered(false);
		//action.getCOMP_POL_LC_EXTRA_PREM().setRendered(false);

		action.getCOMP_POL_FC_MIN_PREM_LABEL().setRendered(false);
		action.getCOMP_POL_LC_MIN_PREM().setRendered(false);
		action.getCOMP_POL_FC_EXTRA_PREM().setRendered(false);
		action.getCOMP_POL_LC_EXTRA_PREM().setRendered(false);
	    }

	    if ("D".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
			// SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_MATURITY',ENABLED,PROPERTY_FALSE);
			//compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_MATURITY);
			//compositeAction.getWizard().disableWizardItem(actionName);
		    } else {
			//compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_POL_MATURITY);
			//compositeAction.getWizard().enableWizardItem(actionName);
			// SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_MATURITY',ENABLED,PROPERTY_TRUE);
		    }
	    
	    new PCOPK_SYS_VARS().P_SET_PARA_VALUES(CommonUtils
				.getGlobalVariable("GLOBAL.M_LANG_CODE"), CommonUtils
				.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"), CommonUtils
				.getGlobalVariable("GLOBAL.M_USER_ID"), CommonUtils
				.getGlobalVariable("GLOBAL.M_COMP_CODE"), CommonUtils
				.getGlobalVariable("GLOBAL.M_DIVN_CODE"), CommonUtils
				.getGlobalVariable("GLOBAL.M_DEPT_CODE"), dummy_bean
				.getUI_M_BASE_CURR(), "2", CommonUtils.getControlBean()
				.getM_PROG_NAME());
               } catch (SQLException se) {

	    	ErrorHelpUtil.getErrorsAndWarningforProcedure(connection,
		    FacesContext.getCurrentInstance(),
		    PILT002_APAC_CONSTANTS.FORM_ID, action.getWarningMap());
	    throw new Exception(se.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} finally {
	    CommonUtils.closeCursor(rs_1);
	    CommonUtils.closeCursor(rs_2);
	    CommonUtils.closeCursor(rs_3);
	    CommonUtils.closeCursor(rs_4);
	    CommonUtils.closeCursor(rs_5);
	    CommonUtils.closeCursor(rs_6);
	    CommonUtils.closeCursor(rs_7);
	    CommonUtils.closeCursor(rs_8);
	    CommonUtils.closeCursor(rs_PP_SYS);
	    CommonUtils.closeCursor(rs_PLAN);
	    CommonUtils.closeCursor(rs_BUY_SELL);

	    /*
	     * ErrorHelpUtil.getErrorsAndWarningforProcedure(connection,
	     * FacesContext.getCurrentInstance(),
	     * PILT002_APAC_CONSTANTS.FORM_ID, action.getWarningMap());
	     */
	}
    }
    
    /**
	 * 
	 * @param PT_IL_CLAIM_ACTION_BEAN
	 */
	public void STD_PRE_FORM(PILT002_APAC_COMPOSITE_ACTION compositeAction){
		String CUR_FORM = null;
		String M_FIRST_BLOCK =null;
		String M_MODULE_NAME =null;
		int M_QUERY_OK = 0;
		String M_TITLE = null;
		String M_SCR_NAME =null;
		String M_COMP_CODE = null;
		String M_DIVN_CODE =null;
		String M_DEPT_CODE = null;
		
		String M_PARA_1 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
		String M_NAME = CommonUtils.getGlobalVariable("GLOBAL.M_NAME");
		String LANG_CODE = CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE");
		String M_DFLT_VALUES = CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES");
		M_MODULE_NAME =  CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_NAME");
			
		if(M_NAME!=null){
			//M_SCR_NAME = M_NAME.substring(30);
		}
		if(M_DFLT_VALUES==null || "".equalsIgnoreCase(M_DFLT_VALUES)){
			M_COMP_CODE = "001";//M_DFLT_VALUES.substring(1, 3);
			M_DIVN_CODE = "HO";//M_DFLT_VALUES.substring(4, 6);
			M_DEPT_CODE = "001";//M_DFLT_VALUES.substring(10, 6);
		}
		
		CTRL CTRL_BEAN = new CTRL();
		CTRL_BEAN.setUI_M_PARA_1(M_PARA_1);
		CTRL_BEAN.setUI_M_USER_ID(M_USER_ID);
		CTRL_BEAN.setUI_M_LANG_CODE(LANG_CODE);
		CTRL_BEAN.setUI_M_COMP_CODE(M_COMP_CODE);
		CTRL_BEAN.setUI_M_DIVN_CODE(M_DIVN_CODE);
		CTRL_BEAN.setUI_M_DEPT_CODE(M_DEPT_CODE);
		CTRL_BEAN.setUI_M_SCR_NAME(M_SCR_NAME);
		
		compositeAction.getCTRL_ACTION_BEAN().setCTRL_BEAN(CTRL_BEAN);
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "false");
		
	}

	
	 public void setLabel(  PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	     ArrayList<String> pValList = new ArrayList<String>();
	     String M_CODE_DESC = null;
	     String  M_PS_VALUE= null;
		try {
		    	PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction.getPT_IL_POLICY_ACTION_BEAN();
			PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
			 PT_IL_POLICY_1_ACTION pt_il_policy_1_action =compositeAction.getPT_IL_POLICY_1_ACTION_BEAN();
			 PT_IL_POLICY2_ACTION pt_il_policy_2_action =compositeAction.getPT_IL_POLICY2_ACTION_BEAN();
			 PT_IL_POL_STATUS_ACTION pt_il_pol_status_action = compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN();
			 DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		   pValList =  DBProcedures.P_VAL_SYSTEM("IL_BP_PARA","IL_BP_PARA",M_CODE_DESC,"E",M_PS_VALUE);
		    
		   if(!pValList.isEmpty()){
		       M_CODE_DESC = pValList.get(0);
		       M_PS_VALUE = pValList.get(1);	
		   }
		if ("1".equalsIgnoreCase( M_PS_VALUE)) {
		    
		    //compositeAction.getComp().setTitle("Policy Information");
		    //compositeAction.getWizard().setCaption("Policy Entry");
		    pt_il_policy_action.getCOMP_FORM_CAPTION().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$FORM_NAME_1$Caption"));
		    /*
		     * modified by Ameen for KIC label changes
		     * pt_il_policy_action.getCOMP_POL_NO_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NO$Caption"));*/
		    pt_il_policy_action.getCOMP_POL_NO_LABEL().setValue( Messages.getString(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")+"messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_COPY_POL_NO_2$caption"));
	            pt_il_policy_action.getCOMP_POL_NO().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NO$tooltip")); 
	            pt_il_policy_action.getCOMP_POL_FC_MODAL_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_MODAL_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_POL_FC_MODAL_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_MODAL_PREM$caption"));
	            pt_il_policy_action.getCOMP_POL_LC_MODAL_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_MODAL_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_POL_LC_MODAL_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_MODAL_PREM$caption"));
		    pt_il_policy_action.getCOMP_POL_FORM_NO_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FORM_NO$caption"));
		    pt_il_policy_action.getCOMP_POL_FORM_NO().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FORM_NO$tooltip")); 
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_FC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$UI_M_POAC_FC_PREM$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_FC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$UI_M_POAC_FC_PREM$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_FC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$UI_M_POAC_FC_PREM$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_FC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$UI_M_POAC_FC_PREM$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_LC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$UI_M_POAC_LC_PREM$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_LC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$UI_M_POAC_LC_PREM$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_LC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$UI_M_POAC_LC_PREM$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_LC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$UI_M_POAC_LC_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_PREM_PAY_YRS$caption"));
		    pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_PREM_PAY_YRS$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_PREM_PAY_YRS().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_PREM_PAY_YRS$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_PREM_PAY_YRS_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_PREM_PAY_YRS$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_PREM_PAY_YRS().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_PREM_PAY_YRS$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_PREM_PAY_YRS_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_PREM_PAY_YRS$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_FC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_ORG_FC_PREM$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_FC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","APAC$PT_IL_POL_ADDL_COVER$POAC_ORG_FC_PREM$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_FC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_ORG_FC_PREM$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_FC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_ORG_FC_PREM$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_LC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_ORG_LC_PREM$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_LC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_ORG_LC_PREM$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_LC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_ORG_LC_PREM$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_LC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_ORG_LC_PREM$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_PREM_PAY_YRS().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_ORG_PREM_PAY_YRS$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_PREM_PAY_YRS_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_ORG_PREM_PAY_YRS$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_PREM_PAY_YRS().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_ORG_PREM_PAY_YRS$tooltip"));	
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_PREM_PAY_YRS_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_ORG_PREM_PAY_YRS$caption"));
		    pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_GRANTEE_TYPE$tooltip"));
		    pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_GRANTEE_TYPE$caption"));
		    pt_il_policy_action.getCOMP_POL_GRANTEE_NAME().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_GRANTEE_NAME$tooltip"));
		    pt_il_policy_action.getCOMP_POL_GRANTEE_NAME_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_GRANTEE_NAME$caption"));
		    pt_il_policy_action.getCOMP_POL_LC_MIN_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_MIN_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_POL_LC_MIN_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_MIN_PREM$caption"));
		    pt_il_policy_action.getCOMP_POL_FC_MIN_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_MIN_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_POL_FC_MIN_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_MIN_PREM$caption"));

		    pt_il_policy_action.getCOMP_POL_FC_EXTRA_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_EXTRA_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_POL_FC_EXTRA_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_EXTRA_PREM$caption"));
		    pt_il_policy_action.getCOMP_POL_LC_EXTRA_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_EXTRA_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_POL_LC_EXTRA_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_EXTRA_PREM$caption"));
		    pt_il_policy_action.getCOMP_POL_NO_YRS_PREM_PAID_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NO_YRS_PREM_PAID$caption")); 
		    pt_il_policy_action.getCOMP_POL_NO_YRS_PREM_PAID().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NO_YRS_PREM_PAID$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_PAY_YEARS_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_PAY_YEARS$caption"));
		    pt_il_policy_action.getCOMP_UI_M_PAY_YEARS().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_PAY_YEARS$tooltip"));
		    pt_il_policy_1_action.getCOMP_POL_LC_BASIC_PREM_1_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY_1$POL_LC_BASIC_PREM_1$caption"));
		    pt_il_policy_1_action.getCOMP_POL_FC_BASIC_PREM_1_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY_1$POL_FC_BASIC_PREM_1$caption"));

		    pt_il_policy_action.getCOMP_UI_M_POL_FC_NET_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_NET_PREM$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_NET_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_NET_PREM$tooltip"));

		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_NET_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_NET_PREM$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM1().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_NET_PREM1$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM1_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_NET_PREM1$caption"));

		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY2$UI_M_POL_LC_NET_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY2$UI_M_POL_LC_NET_PREM$caption"));

		    pt_il_policy_action.getCOMP_UI_M_POL_FC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_PREM$caption")); 
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_PREM$tooltip")); 

		    pt_il_policy_action.getCOMP_UI_M_POL_LC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_PREM$caption")); 

		    pt_il_policy_action.getCOMP_UI_M_FC_INST_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_FC_INST_PREM$caption")); 
		    pt_il_policy_action.getCOMP_UI_M_FC_INST_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_FC_INST_PREM$tooltip"));

		    pt_il_policy_action.getCOMP_UI_M_LC_INST_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_LC_INST_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_LC_INST_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_LC_INST_PREM$caption"));

		    pt_il_policy_action.getCOMP_POL_FRZ_FLAG_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FRZ_FLAG$caption")); 
		    pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FRZ_FLAG$tooltip"));

		    pt_il_policy_action.getCOMP_POL_MASTER_POL_NO().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_MASTER_POL_NO$tooltip"));
		    pt_il_policy_action.getCOMP_POL_MASTER_POL_NO_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_MASTER_POL_NO$caption"));

		    pt_il_policy_action.getCOMP_POL_DEFER_PRD_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_DEFER_PRD$caption")); 
		    pt_il_policy_action.getCOMP_POL_DEFER_PRD().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_DEFER_PRD$tooltip"));

	            pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NET_PREM_YN$tooltip")); 
		    pt_il_policy_action.getCOMP_POL_NET_PREM_YN_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NET_PREM_YN$caption"));
		    pt_il_policy_action.getCOMP_POL_INCORPORATED_YN().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_INCORPORATED_YN$tooltip")); 
		    pt_il_policy_action.getCOMP_POL_INCORPORATED_YN_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_INCORPORATED_YN$caption"));

		    pt_il_policy_2_action.getCOMP_UI_M_POL_LC_BASIC_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY2$UI_M_POL_LC_BASIC_PREM$caption"));
		    pt_il_policy_action.getCOMP_POL_LC_ADDL_PREM1_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_ADDL_PREM1$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_TOT_PREM1_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_TOT_PREM1$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM1_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_NET_PREM$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_GR_ANN_PREM1$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_INST_LC_PREM1_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_INST_LC_PREM1$caption"));
		    pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM1_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_FIRST_PREM1$caption"));
		    
		    pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_BASIC_PREM$caption"));
		    pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_BASIC_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_POL_LC_BASIC_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_BASIC_PREM$tooltip"));
		  
		    pt_il_policy_action.getCOMP_POL_FC_ADDL_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_ADDL_PREM$caption"));
		    pt_il_policy_action.getCOMP_POL_FC_ADDL_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_ADDL_PREM$tooltip"));
		   
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_TOT_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_TOT_PREM$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_TOT_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_TOT_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_TOT_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_TOT_PREM$tooltip"));
		   
		    pt_il_policy_action.getCOMP_POL_FC_NETT_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_NETT_PREM$caption"));
		    pt_il_policy_action.getCOMP_POL_FC_NETT_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_NETT_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_POL_LC_NETT_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_NETT_PREM$tooltip"));
		   
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_GR_ANN_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_GR_ANN_PREM$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_GR_ANN_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_GR_ANN_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_GR_ANN_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_GR_ANN_PREM$tooltip"));
		    
		    pt_il_policy_action.getCOMP_UI_M_POL_INST_FC_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_INST_FC_PREM$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_INST_FC_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_INST_FC_PREM$tooltip"));
		    
		    pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_FIRST_PREM$caption"));
		    pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_FIRST_PREM$tooltip"));
		    pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_FIRST_PREM$tooltip"));
		    dummy_action.getCOMP_UI_M_POL_NO().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_CONVERT$UI_M_POL_NO$caption"));
		    dummy_action.getCOMP_UI_M_POL_DOC_CODE().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_CONVERT$UI_M_POL_DOC_CODE$caption"));
		
		
		} else if ("2".equalsIgnoreCase( M_PS_VALUE)) {
		    //compositeAction.getComp().setTitle("Proposal Information");
		    //compositeAction.getWizard().setCaption("Proposal Entry");
		    pt_il_policy_action.getCOMP_FORM_CAPTION().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$FORM_NAME_2$Caption"));
		
		    /*
		     * modifeid by Ameen for KIC
		     * pt_il_policy_action.getCOMP_POL_NO_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NO_2$caption"));*/
		    pt_il_policy_action.getCOMP_POL_NO_LABEL().setValue( Messages.getString(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")+"messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NO_2$caption"));
	            pt_il_policy_action.getCOMP_POL_NO().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NO_2$tooltip")); 
	            pt_il_policy_action.getCOMP_POL_FC_MODAL_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_MODAL_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_FC_MODAL_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_MODAL_PREM_2$caption"));
	            pt_il_policy_action.getCOMP_POL_LC_MODAL_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_MODAL_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_LC_MODAL_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_MODAL_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_POL_FORM_NO_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FORM_NO_2$caption"));
			
		    pt_il_policy_action.getCOMP_POL_FORM_NO().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FORM_NO_2$tooltip")); 
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_FC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$UI_M_POAC_FC_PREM_2$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_FC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$UI_M_POAC_FC_PREM_2$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_FC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$UI_M_POAC_FC_PREM_2$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_FC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$UI_M_POAC_FC_PREM_2$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_LC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$UI_M_POAC_LC_PREM_2$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_LC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$UI_M_POAC_LC_PREM_2$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_LC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$UI_M_POAC_LC_PREM_2$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_UI_M_POAC_LC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$UI_M_POAC_LC_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_PREM_PAY_YRS_2$caption"));
		    pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_PREM_PAY_YRS_2$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_PREM_PAY_YRS().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_PREM_PAY_YRS_2$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_PREM_PAY_YRS_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_PREM_PAY_YRS_2$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_PREM_PAY_YRS().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_PREM_PAY_YRS_2$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_PREM_PAY_YRS_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_PREM_PAY_YRS_2$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_FC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_ORG_FC_PREM_2$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_FC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","APAC$PT_IL_POL_ADDL_COVER$POAC_ORG_FC_PREM_2$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_FC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_ORG_FC_PREM_2$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_FC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_ORG_FC_PREM_2$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_LC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_ORG_LC_PREM_2$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_LC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_ORG_LC_PREM_2$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_LC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_ORG_LC_PREM_2$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_LC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_ORG_LC_PREM_2$caption"));

		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_PREM_PAY_YRS().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_ORG_PREM_PAY_YRS_2$tooltip"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_PREM_PAY_YRS_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER$POAC_ORG_PREM_PAY_YRS_2$caption"));
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_PREM_PAY_YRS().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_ORG_PREM_PAY_YRS_2$tooltip"));	
		    pt_il_pol_addl_cover_action.getCOMP_POAC_ORG_PREM_PAY_YRS_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POL_ADDL_COVER_1$POAC_ORG_PREM_PAY_YRS_2$caption"));
		    pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_GRANTEE_TYPE_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_GRANTEE_TYPE_2$caption"));
		    pt_il_policy_action.getCOMP_POL_GRANTEE_NAME().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_GRANTEE_NAME_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_GRANTEE_NAME_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_GRANTEE_NAME_2$caption"));
		    pt_il_policy_action.getCOMP_POL_LC_MIN_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_MIN_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_LC_MIN_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_MIN_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_POL_FC_MIN_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_MIN_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_FC_MIN_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_MIN_PREM_2$caption"));

		    pt_il_policy_action.getCOMP_POL_FC_EXTRA_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_EXTRA_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_FC_EXTRA_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_EXTRA_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_POL_LC_EXTRA_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_EXTRA_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_LC_EXTRA_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_EXTRA_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_POL_NO_YRS_PREM_PAID_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NO_YRS_PREM_PAID_2$caption")); 
		    pt_il_policy_action.getCOMP_POL_NO_YRS_PREM_PAID().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NO_YRS_PREM_PAID_2$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_PAY_YEARS_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_PAY_YEARS_2$caption"));
		    pt_il_policy_action.getCOMP_UI_M_PAY_YEARS().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_PAY_YEARS_2$tooltip"));
		    pt_il_policy_1_action.getCOMP_POL_LC_BASIC_PREM_1_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY_1$POL_LC_BASIC_PREM_1_2$caption"));
		    pt_il_policy_1_action.getCOMP_POL_LC_BASIC_PREM_1_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY_1$POL_FC_BASIC_PREM_1_2$caption"));

		    pt_il_policy_action.getCOMP_UI_M_POL_FC_NET_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_NET_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_NET_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_NET_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_NET_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_NET_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM1().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_NET_PREM1_2$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM1_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_NET_PREM1_2$caption"));

		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY2$UI_M_POL_LC_NET_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY2$UI_M_POL_LC_NET_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_PREM_2$caption")); 
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_PREM_2$tooltip")); 
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_PREM_2$caption")); 
		    pt_il_policy_action.getCOMP_UI_M_FC_INST_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_FC_INST_PREM_2$caption")); 
		    pt_il_policy_action.getCOMP_UI_M_FC_INST_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_FC_INST_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_LC_INST_PREM().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_LC_INST_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_LC_INST_PREM_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_LC_INST_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_POL_FRZ_FLAG_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FRZ_FLAG_2$caption")); 
		    pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FRZ_FLAG_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_MASTER_POL_NO().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_MASTER_POL_NO_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_MASTER_POL_NO_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_MASTER_POL_NO_2$caption"));

		    pt_il_policy_action.getCOMP_POL_DEFER_PRD_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_DEFER_PRD_2$caption")); 
		    pt_il_policy_action.getCOMP_POL_DEFER_PRD().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_DEFER_PRD_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NET_PREM_YN_2$tooltip")); 
		    pt_il_policy_action.getCOMP_POL_NET_PREM_YN_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_NET_PREM_YN_2$caption"));
		    pt_il_policy_action.getCOMP_POL_INCORPORATED_YN().setTitle( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_INCORPORATED_YN_2$tooltip")); 
		    pt_il_policy_action.getCOMP_POL_INCORPORATED_YN_LABEL().setValue( Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_INCORPORATED_YN_2$caption"));
		    pt_il_policy_2_action.getCOMP_UI_M_POL_LC_BASIC_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY2$UI_M_POL_LC_BASIC_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_POL_LC_ADDL_PREM1_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_ADDL_PREM1_2$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_TOT_PREM1_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_TOT_PREM1_2$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_NET_PREM1_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_NET_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_LC_GR_ANN_PREM1_2$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_INST_LC_PREM1_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_INST_LC_PREM1_2$caption"));
		    pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM1_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_LC_FIRST_PREM1_2$caption"));
		    
		    pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_BASIC_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_BASIC_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_LC_BASIC_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_BASIC_PREM_2$tooltip"));
		  
		    pt_il_policy_action.getCOMP_POL_FC_ADDL_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_ADDL_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_POL_FC_ADDL_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_ADDL_PREM_2$tooltip"));
		   
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_TOT_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_TOT_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_TOT_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_TOT_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_TOT_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_TOT_PREM_2$tooltip"));
		   
		    pt_il_policy_action.getCOMP_POL_FC_NETT_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_NETT_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_POL_FC_NETT_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_NETT_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_LC_NETT_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_NETT_PREM_2$tooltip"));
		   
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_GR_ANN_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_GR_ANN_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_FC_GR_ANN_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_GR_ANN_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_UI_M_POL_LC_GR_ANN_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_FC_GR_ANN_PREM_2$tooltip"));
		    
		    pt_il_policy_action.getCOMP_UI_M_POL_INST_FC_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_INST_FC_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_UI_M_POL_INST_FC_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$UI_M_POL_INST_FC_PREM_2$tooltip"));
		    
		    pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM_LABEL().setValue(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_FIRST_PREM_2$caption"));
		    pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_FIRST_PREM_2$tooltip"));
		    pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_POLICY$POL_FC_FIRST_PREM_2$tooltip"));
		    dummy_action.getCOMP_UI_M_POL_NO().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_CONVERT$UI_M_POL_NO_2$caption"));
		    dummy_action.getCOMP_UI_M_POL_DOC_CODE().setTitle(Messages.getString("messageProperties_PILT002_APAC","PILT002_APAC$PT_IL_CONVERT$UI_M_POL_DOC_CODE_2$caption"));
		}
		    
		 if( M_PS_VALUE.equalsIgnoreCase("1" )){
		 	dummy_action.getCOMP_UI_M_BUT_REPLACE_POLICY().setValue("Replace Policy");
		 	dummy_action.getCOMP_UI_M_BUT_PRMDTLS().setValue("Prem. Dtls.");
		 }else  if( M_PS_VALUE.equalsIgnoreCase("2" )){ 
		     dummy_action.getCOMP_UI_M_BUT_REPLACE_POLICY().setValue("Replace Cert.");
		     dummy_action.getCOMP_UI_M_BUT_PRMDTLS().setValue("Contrib. Dtls.");
		     
		 }
		 
		 dummy_action.getCOMP_UI_M_BUT_FUND_QUERY().setRendered(false);
		
		 
		/* if("KIC".equals(CommonUtils.getGlobalVariable("GLOBAL.M_SITE"))){
		     pt_il_policy_action.getCOMP_POL_CONT_CODE_LABEL().setValue("Contractor Code");
		 }*/
		 
		 /*Newly added By Dhinesh on 4-1-2018*/
		 if("KIC".equals(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE"))){
		     pt_il_policy_action.getCOMP_POL_CONT_CODE_LABEL().setValue("LA Code");
		 }
		 /*End*/
		 else if("AOIC".equals(CommonUtils.getGlobalVariable("GLOBAL.M_SITE")) &&  "1".equalsIgnoreCase( M_PS_VALUE) ){ 
		     pt_il_policy_action.getCOMP_POL_CONT_CODE_LABEL().setValue("Policy Holder");
		 }else if("AOIC".equals(CommonUtils.getGlobalVariable("GLOBAL.M_SITE")) &&   "2".equalsIgnoreCase( M_PS_VALUE) ){ 
		   	 pt_il_policy_action.getCOMP_POL_CONT_CODE_LABEL().setValue("Cert. Holder");
		 }else{
			 
			 /*changed by raja on 18-04-2017*/
			/* pt_il_policy_action.getCOMP_POL_CONT_CODE_LABEL().setValue("Assured Code");*/
		     pt_il_policy_action.getCOMP_POL_CONT_CODE_LABEL().setValue("Life Assured Code");
		     
		     /*end*/
		     dummy_action.getCOMP_UI_M_BUT_CONTRACTOR().setValue("Assr Dtls");
		     //SET_ITEM_PROPERTY('DUMMY.M_BUT_CONTRACTOR',LABEL, 'Assr Dtls');
		 }
		   
		
		if("1".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"))){
		    if(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11").equals("1") &&
			    CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13").equals("P")    ){
			 pt_il_policy_action.getCOMP_FORM_CAPTION().setValue(  "Proposal Entry");
			 pt_il_pol_status_action.getCOMP_FORM_CAPTION().setValue("Proposal Status");
		         
		    }else if(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11").equals("1") &&
					    CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13").equals("Q")    ){
			 pt_il_policy_action.getCOMP_FORM_CAPTION().setValue(  "Quotation Entry");
		      	 
		    }
		    else if(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1").equals("IL_END_QUOT")) {
		   	//  SET_WINDOW_PROPERTY('PT_IL_POLICY',TITLE,'Endorsement Quotation');
		   	  pt_il_policy_action.getCOMP_FORM_CAPTION().setValue(  "Endorsement Quotation");
		    }else if( M_PS_VALUE.equalsIgnoreCase("1" )){
		    //  SET_WINDOW_PROPERTY('PT_IL_POLICY',TITLE,'Policy Entry');   	
		     // SET_WINDOW_PROPERTY('PT_IL_POL_STATUS',    TITLE, 'Policy Status');  
		    	pt_il_policy_action.getCOMP_FORM_CAPTION().setValue(  "Policy Entry");
		    	pt_il_pol_status_action.getCOMP_FORM_CAPTION().setValue("Policy Status");
		}else if (M_PS_VALUE.equalsIgnoreCase("2") ){  
		   	/*  SET_WINDOW_PROPERTY('PT_IL_POLICY',TITLE,'Certificate Entry');   	
			    SET_WINDOW_PROPERTY('PT_IL_POL_STATUS',    TITLE, 'Certificate Status'); */
			pt_il_policy_action.getCOMP_FORM_CAPTION().setValue(  "Certificate Entry");
		    	pt_il_pol_status_action.getCOMP_FORM_CAPTION().setValue("Certificate Status");
		}
		    if( M_PS_VALUE.equalsIgnoreCase("1" )){
			dummy_action.getCOMP_FORM_CONVERT_CAPTION().setValue("Convert Proposal To Policy");
			//SET_WINDOW_PROPERTY(PT_IL_CONVERT',    TITLE, 'Convert Proposal To Policy'); 
		    }else  if( M_PS_VALUE.equalsIgnoreCase("2" )){ 
			dummy_action.getCOMP_FORM_CONVERT_CAPTION().setValue("Convert Proposal To Certificate");
		   	//SET_WINDOW_PROPERTY('PT_IL_CONVERT',    TITLE, 'Convert Proposal To Certificate'); 
		    }
		
		}
		
		     
	   }
		catch (Exception e) {
		    e.printStackTrace();
		    throw new Exception(e.getMessage());
		}
	}
	 
	 public void disableMortageTabs(PT_IL_POLICY_ACTION pt_il_policy_action) {
		PT_IL_POLICY policyBean = pt_il_policy_action.getPT_IL_POLICY_BEAN();
		String planCode = policyBean.getPOL_PLAN_CODE();
		String query = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
		String planType = null;
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { planCode });
			if (resultSet.next()) {
				planType = resultSet.getString("PLAN_TYPE");
			}
			if ("M".equalsIgnoreCase(planType)) {
					pt_il_policy_action.getCOMP_MORE_INFO_2().setRendered(true);
					pt_il_policy_action.getCOMP_MORE_INFO_3().setRendered(true);
				}else{
					pt_il_policy_action.getCOMP_MORE_INFO_2().setRendered(false);
					pt_il_policy_action.getCOMP_MORE_INFO_3().setRendered(false);
				}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 

	 
	 
	 public int makeCurrDecimalglobal(String currcode){
		 
			System.out.println("********** ENTER THE MAKECURRDECIMALGLOBAL METHOD **********");
			System.out.println("currcode    : "+currcode);
			
			String query = "SELECT CURR_DECIMAL FROM FM_CURRENCY where CURR_CODE= ?";
			
			int CURR_DECI = 0;
			
			ResultSet resultSet = null;
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				resultSet = handler.executeSelectStatement(query, connection,
						new Object[] { currcode });
				if (resultSet.next()) {
					CURR_DECI = resultSet.getInt("CURR_DECIMAL");
				}
				
				System.out.println("CURR_DECI    : "+CURR_DECI);
		CommonUtils.setGlobalObject("GLOBAL.CURR_DECIMAL", CURR_DECI);
		System.out.println("Dhinesh------GLOBAL.CURR_DECIMAL    : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
		
			} catch (DBException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return CURR_DECI;
	 } 
	  
}
