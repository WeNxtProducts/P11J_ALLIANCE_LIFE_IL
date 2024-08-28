package com.iii.pel.forms.PILT017;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import sun.org.mozilla.javascript.internal.regexp.SubString;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP002_APAC.P_VAL_CURR;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.pel.forms.PILT016A_APAC.PILT016A_APAC_COMPOSITE_ACTION;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_DEP_APPROVAL;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.functions.ConvertFunctions;
import com.vembu.plsql.runtime.functions.DateFunctions;
import com.vembu.plsql.runtime.functions.StringFunctions;

public class PT_IL_PYMT_DTLS_HELPER {
    
	PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();

    public void pilt017_pt_il_pymt_dtls_pd_pay_mode_when_list_changed(
	    PT_IL_PYMT_DTLS_ACTION pymtDtlAction) throws SQLException,
	    Exception {
	// PT_IL_PYMT_DTLS pymtDtlBean =
	// pymtDtlAction.getPT_IL_PYMT_DTLS_BEAN();
	PT_IL_PYMT_DTLS_DB_CLASS dbClass = new PT_IL_PYMT_DTLS_DB_CLASS();
	PT_IL_PYMT_DTLS_ACTION compositeAction = null;
	PT_IL_PYMT_DTLS paymentDetailBean = pymtDtlAction
		.getPT_IL_PYMT_DTLS_BEAN();
	String PD_PAY_MODE = paymentDetailBean.getPD_PAY_MODE();
	Long PD_TXN_SYS_ID = paymentDetailBean.getPD_TXN_SYS_ID();
	String ROWID = paymentDetailBean.getROWID();
	int rowCount = compositeAction.getDataTable().getRowCount();
	CommonUtils commonUtils = new CommonUtils();
	String val = " P C D L H O I CC E SD TT BC PM EF AS SC A C1 C2 C3 C4 C5 C6 ";
	String condition = " C D L H O SD ";
	String condition1 = " I CC C1 C2 C3 C4 C5 C6 ";
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	ResultSet resSetPayMode = null;
	ResultSet resSetOnPayMode = null;
	ResultSet resSetCustPerc = null;

	try {
	    connection = CommonUtils.getConnection();
	    compositeAction = new PT_IL_PYMT_DTLS_ACTION();
	    compositeAction = (PT_IL_PYMT_DTLS_ACTION) commonUtils
		    .getMappedBeanFromSession("PT_IL_PYMT_DTLS_ACTION");
	    int M_PS_VALUE = 0;
	    String M_CODE_DESC = null;
	    String RECORD_STATUS = null;
	    String M_DUMMY = null;

	    if (ROWID != null) {
		RECORD_STATUS = "CHANGED";
	    } else {
		RECORD_STATUS = "INSERT";
	    }

	    String retreivePayModeQry = SqlConstants.RETRIEVE_PAY_MODE;
	    Object[] objPayMode = { PD_TXN_SYS_ID };

	    String retreiveOnPayModeQry = SqlConstants.RETRIEVE_ON_PAY_MODE;
	    Object[] objOnPayMode = { PD_PAY_MODE, PD_TXN_SYS_ID, ROWID };

	    String retreiveCustPercQry = SqlConstants.RETRIEVE_CUST_SHARE_PERC;
	    // Object [] objCustSharePerc={pymtDtlBean.getPD_PAY_MODE()};
	    Object[] objCustSharePerc = { PD_PAY_MODE };
	    Double M_BCSH_CUST_SHARE_PERC_2 = 0.0;

	    /*
	     * if(resSetCustPerc!=null){ resSetCustPerc.close(); }
	     */
	    CommonUtils.closeCursor(resSetCustPerc);
	    resSetCustPerc = handler.executeSelectStatement(
		    retreiveCustPercQry, connection, objCustSharePerc);
	    if (resSetCustPerc.next()) {
		M_BCSH_CUST_SHARE_PERC_2 = resSetCustPerc.getDouble(1);
	    }
	    // resSetCustPerc.close();
	    CommonUtils.closeCursor(resSetCustPerc);
	    ArrayList list = dbClass.P_VAL_SYSTEM("IL_MUL_PAY", "IL_MUL_PAY",
		    "E");
	    M_CODE_DESC = (String) list.get(0);
	    M_PS_VALUE = Integer.parseInt(list.get(1).toString());

	    /*
	     * if(resSetPayMode!=null){ resSetPayMode.close(); }
	     */
	    CommonUtils.closeCursor(resSetPayMode);

	    if (M_PS_VALUE == 2) {
		if (RECORD_STATUS == ("INSERT") || RECORD_STATUS == ("CHANGED")) {
		    resSetPayMode = handler.executeSelectStatement(
			    retreivePayModeQry, connection, objPayMode);
		    if (resSetPayMode.next()) {
			M_DUMMY = resSetPayMode.getString(1);
		    }
		    if (M_DUMMY != paymentDetailBean.getPD_PAID_FOR()) {
			paymentDetailBean.setPD_PAY_MODE(M_DUMMY);
			throw new ValidatorException(
				Messages
					.getMessage("messageProperties",
						"ERROR_MSG_PILT017$PT_IL_PYMT_DTLS$91570_PAYMENT_MODE_TO_BE_SAME"));
		    }
		    // resSetPayMode.close();
		    CommonUtils.closeCursor(resSetPayMode);
		}
	    }

	    int lastIndex = rowCount - 1;

	    if (M_PS_VALUE == 2) {
		if (RECORD_STATUS == ("INSERT") || RECORD_STATUS == ("CHANGED")) {
		    resSetPayMode = handler.executeSelectStatement(
			    retreivePayModeQry, connection, objPayMode);
		    if (resSetPayMode.next()) {
			M_DUMMY = resSetPayMode.getString(1);
		    }
		    if (M_DUMMY != PD_PAY_MODE) {
			paymentDetailBean.setPD_PAY_MODE(M_DUMMY);
			throw new ValidatorException(
				Messages
					.getMessage("messageProperties",
						"ERROR_MSG_PILT017$PT_IL_PYMT_DTLS$91570_PAYMENT_MODE_TO_BE_SAME"));
		    }
		    // resSetPayMode.close();
		    CommonUtils.closeCursor(resSetPayMode);
		}
	    }

	    if (val.contains(" " + PD_PAY_MODE + " ")) {
		String TXN_TYPE = (String)CommonUtils.getGlobalObject("GLOBAL.TXN_TYPE");
		if ("DR".equals(TXN_TYPE)) {
		    throw new ValidatorException(Messages.getMessage(
			    PELConstants.pelErrorMessagePath, "91000"));
		}
		if ("D".equals(PD_PAY_MODE)) {
		    paymentDetailBean.setUI_M_PD_DEP_AMT((Double) paymentDetailBean.getPD_LC_AMT());
		    paymentDetailBean.setUI_M_PD_OTH_AMT(0.0);
		} else {
		    paymentDetailBean.setUI_M_PD_OTH_AMT((Double) paymentDetailBean.getPD_LC_AMT());
		    paymentDetailBean.setUI_M_PD_DEP_AMT(0.0);
		}

		// paymentDetailBean.setPD_DPD_REF_ID(null);
		/*
		 * pymtDtlAction.getCOMP_PD_DPD_REF_ID().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_DPD_REF_ID().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DPD_REF_ID().setDisabled(true);
		 */

		// GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_FC_AMT");
	    }
	    if ("P".equals(PD_PAY_MODE)) {
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_BANK_NAME(null);
		paymentDetailBean.setPD_BRANCH_NAME(null);
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);
		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setUI_M_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);
		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		paymentDetailBean.setPD_ATM_CARD_NO(null);

		/*
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		 */
	    } else if (condition.contains(" " + PD_PAY_MODE + " ")) {
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);

		/*
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false); //
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(false);
		 * //NAVIGABLE-true //
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(false);
		 * //NAVIGABLE-true //
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		 * //NAVIGABLE-true //
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		 * //NAVIGABLE-true
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setReadonly(false);
		 * //UPDATE_ALLOWED-true //
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setReadonly(false);
		 * //UPDATE_ALLOWED-true
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		 * //UPDATE_ALLOWED-true
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		 * //UPDATE_ALLOWED-true
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		 */

		if (RECORD_STATUS != "CHANGED") {
		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_DT(null);
		    paymentDetailBean.setPD_BANK_NAME(null);
		    paymentDetailBean.setPD_BRANCH_NAME(null);
		}
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);
		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setUI_M_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);
		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		paymentDetailBean.setPD_ATM_CARD_NO(null);
	    } else if (condition1.contains(" " + PD_PAY_MODE + " ")) {
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_BANK_NAME(null);
		paymentDetailBean.setPD_BRANCH_NAME(null);

		/*
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(false);
		 * //NAVIGABLE-true
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(false);
		 * //NAVIGABLE-true
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(false);
		 * //NAVIGABLE-true
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(false);
		 * //NAVIGABLE-true
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(false);
		 * //NAVIGABLE-true
		 * //pymtDtlAction.getCOMP_PD_CC_TYPE().setReadonly(false);
		 * //UPDATE_ALLOWED-true
		 * pymtDtlAction.getCOMP_PD_CC_NO().setReadonly(false);
		 * //UPDATE_ALLOWED-true
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setReadonly(false);
		 * //UPDATE_ALLOWED-true
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setReadonly(false);
		 * //UPDATE_ALLOWED-true
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setReadonly(false);
		 * //UPDATE_ALLOWED-true
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		 */
		if (M_BCSH_CUST_SHARE_PERC_2 != 0.0) {
		    // pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		} else {
		    // pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(true);
		}

		/*
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		 */

		if (RECORD_STATUS == "CHANGED") {
		    /*
		     * :PT_IL_PYMT_DTLS.PD_CC_TYPE=:PT_IL_PYMT_DTLS.PD_CC_TYPE;
		     * :PT_IL_PYMT_DTLS.PD_CC_NO=:PT_IL_PYMT_DTLS.PD_CC_NO;
		     * :PT_IL_PYMT_DTLS.PD_CC_NAME=:PT_IL_PYMT_DTLS.PD_CC_NAME;
		     * :PT_IL_PYMT_DTLS.PD_CC_EXP_DT=:PT_IL_PYMT_DTLS.PD_CC_EXP_DT;
		     * :PT_IL_PYMT_DTLS.PD_CC_APP_CODE=:PT_IL_PYMT_DTLS.PD_CC_APP_CODE;
		     * :PT_IL_PYMT_DTLS.M_EXP_DT=:PT_IL_PYMT_DTLS.M_EXP_DT;
		     */
		} else {
		    paymentDetailBean.setPD_CC_TYPE("O");
		    paymentDetailBean.setPD_CC_NO(null);
		    paymentDetailBean.setPD_CC_NAME(null);
		    paymentDetailBean.setPD_CC_EXP_DT(null);
		    paymentDetailBean.setPD_CC_APP_CODE(null);
		    paymentDetailBean.setUI_M_EXP_DT(null);
		}
		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setUI_M_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);
		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		paymentDetailBean.setPD_ATM_CARD_NO(null);
	    } else if ("TT".equals(PD_PAY_MODE)) {
		/*
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		 */

		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_EXP_DT(null);
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_BANK_NAME(null);
		paymentDetailBean.setPD_BRANCH_NAME(null);
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);

		if (RECORD_STATUS == "CHANGED") {
		    /*
		     * :PT_IL_PYMT_DTLS.PD_OUR_BANK_CODE=:PT_IL_PYMT_DTLS.PD_OUR_BANK_CODE;
		     * :PT_IL_PYMT_DTLS.PD_DATE_OF_CREDIT=:PT_IL_PYMT_DTLS.PD_DATE_OF_CREDIT;
		     * :PT_IL_PYMT_DTLS.PD_TT_REF_NO=:PT_IL_PYMT_DTLS.PD_TT_REF_NO;
		     * :PT_IL_PYMT_DTLS.PD_TT_CURR_CODE=:PT_IL_PYMT_DTLS.PD_TT_CURR_CODE;
		     */
		} else {
		    paymentDetailBean.setPD_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_TT_REF_NO(null);
		    paymentDetailBean.setPD_TT_CURR_CODE(null);
		}
		paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setUI_M_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);
		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		paymentDetailBean.setPD_ATM_CARD_NO(null);
	    } else if ("BC".equals(PD_PAY_MODE)) {
		/*
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(true);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		 */
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);
		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);
		if ("CHANGED".equals(RECORD_STATUS)) {
		    /*
		     * :PT_IL_PYMT_DTLS.M_OUR_BANK_CODE=:PT_IL_PYMT_DTLS.M_OUR_BANK_CODE;
		     * :PT_IL_PYMT_DTLS.PD_REM_SLIP_GEN_YN=:PT_IL_PYMT_DTLS.PD_REM_SLIP_GEN_YN;
		     * :PT_IL_PYMT_DTLS.M_CHQ_NO=:PT_IL_PYMT_DTLS.M_CHQ_NO;
		     * :PT_IL_PYMT_DTLS.PD_BANK_NAME=:PT_IL_PYMT_DTLS.PD_BANK_NAME;
		     * :PT_IL_PYMT_DTLS.PD_BRANCH_NAME=:PT_IL_PYMT_DTLS.PD_BRANCH_NAME;
		     */
		} else {
		    paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setUI_M_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_BANK_NAME(null);
		    paymentDetailBean.setPD_BRANCH_NAME(null);
		}
		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);
		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		paymentDetailBean.setPD_ATM_CARD_NO(null);
	    } else if ("PM".equals(PD_PAY_MODE)) {
		/*
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		 */

		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_BANK_NAME(null);
		paymentDetailBean.setPD_BRANCH_NAME(null);
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);
		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setUI_M_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_NO(null);

		if ("CHANGED".equals(RECORD_STATUS)) {
		    /*
		     * :PT_IL_PYMT_DTLS.PD_PO_MO_NO=:PT_IL_PYMT_DTLS.PD_PO_MO_NO;
		     * :PT_IL_PYMT_DTLS.PD_PO_MO_DT=:PT_IL_PYMT_DTLS.PD_PO_MO_DT;
		     * :PT_IL_PYMT_DTLS.M_REM_SLIP_GEN_YN=:PT_IL_PYMT_DTLS.M_REM_SLIP_GEN_YN;
		     * :PT_IL_PYMT_DTLS.PD_REM_AMT=:PT_IL_PYMT_DTLS.PD_REM_AMT;
		     * :PT_IL_PYMT_DTLS.M_OUR_BANK_CODE_1=:PT_IL_PYMT_DTLS.M_OUR_BANK_CODE_1;
		     * :PT_IL_PYMT_DTLS.PD_FC_AMT=:PT_IL_PYMT_DTLS.PD_FC_AMT;
		     */
		} else {
		    paymentDetailBean.setPD_PO_MO_NO(null);
		    paymentDetailBean.setPD_PO_MO_DT(null);
		    paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setPD_REM_AMT(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		}
		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);
		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		paymentDetailBean.setPD_ATM_CARD_NO(null);
	    } else if ("EF".equals(PD_PAY_MODE)) {
		/*
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setReadonly(false); //
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		 */

		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_BANK_NAME(null);
		paymentDetailBean.setPD_BRANCH_NAME(null);
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);
		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setUI_M_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);
		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		paymentDetailBean.setPD_ATM_CARD_NO(null);
		if ("CHANGED".equals(RECORD_STATUS)) {
		    /*
		     * :PT_IL_PYMT_DTLS.M_OUR_BANK_CODE_2=:PT_IL_PYMT_DTLS.M_OUR_BANK_CODE_2;
		     * :PT_IL_PYMT_DTLS.PD_BANK_REF_NO=:PT_IL_PYMT_DTLS.PD_BANK_REF_NO;
		     * :PT_IL_PYMT_DTLS.M_DATE_OF_CREDIT=:PT_IL_PYMT_DTLS.M_DATE_OF_CREDIT;
		     * :PT_IL_PYMT_DTLS.PD_BANK_NAME=:PT_IL_PYMT_DTLS.PD_BANK_NAME;
		     * :PT_IL_PYMT_DTLS.PD_BRANCH_NAME=:PT_IL_PYMT_DTLS.PD_BRANCH_NAME;
		     */
		} else {
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		    paymentDetailBean.setPD_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_BANK_NAME(null);
		    paymentDetailBean.setPD_BRANCH_NAME(null);
		}
	    } else if ("AD".equals(PD_PAY_MODE)) {
		/*
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setReadonly(false);
		 * //pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setReadonly(false);
		 * //pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		 */

		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);
		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setUI_M_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);
		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		paymentDetailBean.setPD_ATM_CARD_NO(null);
		if ("CHANGED".equals(RECORD_STATUS)) {
		    /*
		     * :PT_IL_PYMT_DTLS.M_BANK_REF_NO=:PT_IL_PYMT_DTLS.M_BANK_REF_NO;
		     * :PT_IL_PYMT_DTLS.M_DATE_OF_CREDIT_1=:PT_IL_PYMT_DTLS.M_DATE_OF_CREDIT_1;
		     * :PT_IL_PYMT_DTLS.PD_BANK_NAME=:PT_IL_PYMT_DTLS.PD_BANK_NAME;
		     * :PT_IL_PYMT_DTLS.PD_BRANCH_NAME=:PT_IL_PYMT_DTLS.PD_BRANCH_NAME;
		     */
		} else {
		    paymentDetailBean.setUI_M_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		    paymentDetailBean.setPD_BANK_NAME(null);
		    paymentDetailBean.setPD_BRANCH_NAME(null);
		}
	    } else if ("SC".equals(PD_PAY_MODE)) {
		/*
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(false);
		 * //pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setReadonly(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setReadonly(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setReadonly(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setReadonly(false);
		 * //pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setReadonly(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		 */

		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_BANK_NAME(null);
		paymentDetailBean.setPD_BRANCH_NAME(null);
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);
		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setUI_M_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		paymentDetailBean.setPD_ATM_CARD_NO(null);
		if ("CHANGED".equals(RECORD_STATUS)) {
		    paymentDetailBean.setUI_M_PD_CC_TYPE(paymentDetailBean
			    .getPD_CC_TYPE());
		    paymentDetailBean.setUI_M_PD_CC_NO(paymentDetailBean
			    .getPD_CC_NO());
		    paymentDetailBean.setUI_M_PD_CC_APP_CODE(paymentDetailBean
			    .getPD_CC_APP_CODE());
		    paymentDetailBean.setUI_M_BANK_REF_NO_1(paymentDetailBean
			    .getPD_BANK_REF_NO());
		    paymentDetailBean
			    .setUI_M_DATE_OF_CREDIT_2(paymentDetailBean
				    .getPD_DATE_OF_CREDIT());
		} else {
		    paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		    paymentDetailBean.setUI_M_PD_CC_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		}
	    } else if ("A".equals(PD_PAY_MODE)) {
		/*
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		 */

		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);
		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setUI_M_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);
		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		if ("CHANGED".equals(RECORD_STATUS)) {
		    /*
		     * pymtDtlBean.setUI_M_BANK_REF_NO_2(pymtDtlBean.getUI_M_BANK_REF_NO_2());
		     * pymtDtlBean.setPD_ATM_CARD_NO(pymtDtlBean.getPD_ATM_CARD_NO());
		     * pymtDtlBean.setPD_BANK_NAME(pymtDtlBean.getPD_BANK_NAME());
		     * pymtDtlBean.setPD_BRANCH_NAME(pymtDtlBean.getPD_BRANCH_NAME());
		     */
		} else {
		    paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		    paymentDetailBean.setPD_ATM_CARD_NO(null);
		    paymentDetailBean.setPD_BANK_NAME(null);
		    paymentDetailBean.setPD_BRANCH_NAME(null);
		}
	    } else if ("E".equals(PD_PAY_MODE)) {
		/*
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(false);
		 * //pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(false);//",NAVIGABLE,PROPERTY_TRUE);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(false);
		 * //pymtDtlAction.getCOMP_PD_CR_ADVICE_NO",NAVIGABLE,PROPERTY_TRUE);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(false);
		 * paymentDetailBean.setPD_PAYIN_DATE(commonUtils.getCurrentSQLDate());
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		 * //pymtDtlAction.getCOMP_PT_IL_PYMT_DTLS.PD_BANK_NAME",NAVIGABLE,PROPERTY_TRUE);
		 * //pymtDtlAction.getCOMP_PT_IL_PYMT_DTLS.PD_BRANCH_NAME",NAVIGABLE,PROPERTY_TRUE);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		 */

		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);
		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setUI_M_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		paymentDetailBean.setPD_ATM_CARD_NO(null);
		if ("CHANGED".equals(RECORD_STATUS)) {
		    /*
		     * :PT_IL_PYMT_DTLS.PD_BANK_NAME=:PT_IL_PYMT_DTLS.PD_BANK_NAME;
		     * :PT_IL_PYMT_DTLS.PD_BRANCH_NAME=:PT_IL_PYMT_DTLS.PD_BRANCH_NAME;
		     * :PT_IL_PYMT_DTLS.PD_CR_ADVICE_NO=:PT_IL_PYMT_DTLS.PD_CR_ADVICE_NO;
		     */
		} else {
		    paymentDetailBean.setPD_BANK_NAME(null);
		    paymentDetailBean.setPD_BRANCH_NAME(null);
		    paymentDetailBean.setPD_CR_ADVICE_NO(null);
		}
	    } else if ("DP".equals(PD_PAY_MODE)) {
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_BANK_NAME(null);
		paymentDetailBean.setPD_BRANCH_NAME(null);
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);
		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);
		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);
		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);

		/*
		 * pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		 * 
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		 * //pymtDtlAction.getCOMP_PD_BANK_NAME",NAVIGABLE,PROPERTY_TRUE);
		 * //pymtDtlAction.getCOMP_PD_BRANCH_NAME",NAVIGABLE,PROPERTY_TRUE);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		 * pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		 * pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_DPD_REF_ID().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_DPD_REF_ID().setRequired(true);
		 * pymtDtlAction.getCOMP_UI_M_BUT_LOV_DPD_REF_ID().setDisabled(false);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		 * 
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		 */

		paymentDetailBean.setPD_FC_AMT(null);
		paymentDetailBean.setPD_LC_AMT(null);
	    } else if ("PT".equals(PD_PAY_MODE)) {
		throw new ValidatorException(Messages.getMessage(
			PELConstants.pelErrorMessagePath, "91391"));
	    }
	    if ("D".equals(paymentDetailBean.getPD_PAID_FOR())) {
		paymentDetailBean.setUI_M_PD_DEP_AMT(paymentDetailBean
			.getPD_LC_AMT());
		paymentDetailBean.setUI_M_PD_OTH_AMT(0.0);
	    } else {
		paymentDetailBean.setUI_M_PD_OTH_AMT(paymentDetailBean
			.getPD_LC_AMT());
		paymentDetailBean.setUI_M_PD_DEP_AMT(0.0);
	    }
	    if (!"E".equals(PD_PAY_MODE)) {
		// pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		// pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
	    }
	    if (paymentDetailBean.getPD_PAYIN_DATE() == null
		    && !"E".equals(PD_PAY_MODE)) {
		paymentDetailBean.setPD_PAYIN_DATE(new java.sql.Date(Calendar
			.getInstance().getTimeInMillis()));
		// pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
	    } else if (paymentDetailBean.getPD_PAYIN_DATE() != null
		    && !"E".equals(PD_PAY_MODE)) {
		// pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
	    } else if (paymentDetailBean.getPD_PAYIN_DATE() != null
		    && "E".equals(PD_PAY_MODE)) {
		// pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(false);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	} finally {
	    try {
		CommonUtils.closeCursor(resSetPayMode);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    try {
		CommonUtils.closeCursor(resSetOnPayMode);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    try {
		CommonUtils.closeCursor(resSetCustPerc);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void pilt017_pt_il_pymt_dtls_pd_pay_mode_when_validate_item(
	    PT_IL_PYMT_DTLS_ACTION pymtDtlAction) throws Exception {
    	PT_IL_PYMT_DTLS_DB_CLASS dbClass = new PT_IL_PYMT_DTLS_DB_CLASS();
    	PT_IL_PYMT_DTLS paymentDetailBean = pymtDtlAction.getPT_IL_PYMT_DTLS_BEAN();
	
	
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	String paymentPdMode = paymentDetailBean.getPD_PAY_MODE();
	String condition = " F P C D L H O I CC E SD TT BC PM EF AD SC A C1 C2 C3 C4 C5 C6 BS ";
	String condition1 = " I CC C1 C2 C3 C4 C5 C6 ";
	String condition2 = " C D L H O SD ";
	String C4 = "  SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N')  FROM MENU_USER   WHERE USER_ID = ? ";
	String rowId = paymentDetailBean.getROWID();
	ResultSet resSetPayMode = null;
	ResultSet resSetOnPayMode = null;
	ResultSet resSetCustPerc = null, rs = null;
	DBProcedures procedures = new DBProcedures();
	int M_PS_VALUE = 0;

	String RECORD_STATUS = null;
	String M_USER_CREDIT_CARD_UPD_YN = null;
	String M_CODE_DESC = null;
	String M_DUMMY = null;
	try {
	    connection = CommonUtils.getConnection();

	    if (rowId != null) {
		RECORD_STATUS = "CHANGED";
	    } else {
		RECORD_STATUS = "INSERT";
	    }

	    String retreivePayModeQry = SqlConstants.RETRIEVE_PAY_MODE;
	    Long sysId = (Long)CommonUtils.getGlobalObject("GLOBAL.TXN_SYS_ID");
	    String PD_TXN_TYPE = paymentDetailBean.getPD_TXN_TYPE();
	    paymentDetailBean.setPD_TXN_SYS_ID(sysId);
	    Object[] objPayMode = { paymentDetailBean.getPD_TXN_SYS_ID(),
		    PD_TXN_TYPE };
	    // String sql_C1="SELECT PD_PAY_MODE FROM PT_IL_PYMT_DTLS AND
	    // PD_TXN_SYS_ID = :PT_IL_PYMT_DTLS.PD_TXN_SYS_ID";
	    // Statement
	    // stmt_C1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

	    String retreiveOnPayModeQry = SqlConstants.RETRIEVE_ON_PAY_MODE;
	    
	    Object[] objOnPayMode = { paymentPdMode,
		    paymentDetailBean.getPD_TXN_TYPE(),
		    paymentDetailBean.getPD_TXN_SYS_ID(),
		    paymentDetailBean.getROWID() };

	    // String sql_C2="SELECT 'X' FROM PT_IL_PYMT_DTLS WHERE PD_PAY_MODE
	    // = :PT_IL_PYMT_DTLS.PD_PAY_MODE AND PD_TXN_TYPE =
	    // :PT_IL_PYMT_DTLS.PD_TXN_TYPE AND PD_TXN_SYS_ID =
	    // :PT_IL_PYMT_DTLS.PD_TXN_SYS_ID AND ROWID !=
	    // :PT_IL_PYMT_DTLS.ROWID ";
	    // Statement
	    // stmt_C2=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

	    String retreiveCustPercQry = SqlConstants.RETRIEVE_CUST_SHARE_PERC;
	    Object[] objCustSharePerc = { paymentPdMode };

	    // String sql_C3="SELECT BCSH_CUST_SHARE_PERC FROM
	    // PM_BANK_CHARGE_SETUP_HDR WHERE BCSH_PAY_MODE =
	    // :PT_IL_PYMT_DTLS.PD_PAY_MODE ";
	    // ResultSet vembu_C3=null;
	    // Statement
	    // stmt_C3=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    Double M_BCSH_CUST_SHARE_PERC_3 = 0.0;
	    /*
	     * if(resSetCustPerc!=null) { resSetCustPerc.close(); }
	     */
	    CommonUtils.closeCursor(resSetCustPerc);
	    resSetCustPerc = handler.executeSelectStatement(
		    retreiveCustPercQry, connection, objCustSharePerc);
	    if (resSetCustPerc.next()) {
		M_BCSH_CUST_SHARE_PERC_3 = resSetCustPerc.getDouble(1);
	    }
	    // resSetCustPerc.close();
	    CommonUtils.closeCursor(resSetCustPerc);
	    ArrayList list = procedures.P_VAL_SYSTEM("IL_MUL_PAY",
		    "IL_MUL_PAY", M_CODE_DESC, "E", null);

	    if (!list.isEmpty()) {
		M_CODE_DESC = (String) list.get(0);
		M_PS_VALUE = Integer.parseInt(list.get(1).toString());
	    }
	    /*
	     * if(resSetPayMode!=null) { resSetPayMode.close(); }
	     */
	    CommonUtils.closeCursor(resSetPayMode);
	    /*
	     * if(rowIndex>1) {
	     */
	    if("DP".equalsIgnoreCase(paymentDetailBean.getPD_PAY_MODE())){
	    if (M_PS_VALUE == 2) {
		if (RECORD_STATUS == ("INSERT") || RECORD_STATUS == ("CHANGED")) {
		    // vembu_C1=stmt_C1.executeQuery(sql_C1);
		    resSetPayMode = handler.executeSelectStatement(
			    retreivePayModeQry, connection, objPayMode);
		    if (resSetPayMode.next()) {
			M_DUMMY = resSetPayMode.getString(1);
		    }
		    if (M_DUMMY!=null && (!M_DUMMY.equals(paymentDetailBean.getPD_PAY_MODE()))) {
			paymentDetailBean.setPD_PAY_MODE(M_DUMMY);
			//throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91570"));
		    }
		    // resSetPayMode.close();
		    CommonUtils.closeCursor(resSetPayMode);
		}
	    }
	    }
	   
	   /* if (M_PS_VALUE == 2) {
		if (RECORD_STATUS == ("INSERT") || RECORD_STATUS == ("CHANGED")) {
		    // vembu_C1=stmt_C1.executeQuery(sql_C1);
		    resSetPayMode = handler.executeSelectStatement(
			    retreivePayModeQry, connection, objPayMode);
		    if (resSetPayMode.next()) {
			M_DUMMY = resSetPayMode.getString(1);
		    }
		    if (M_DUMMY != paymentDetailBean.getPD_PAY_MODE()) {
			paymentDetailBean.setPD_PAY_MODE(M_DUMMY);
			throw new Exception(
				Messages
					.getString(PELConstants.pelErrorMessagePath,
						"91570",
						new Object[] { CommonUtils
							.getGlobalVariable("GLOBAL.M_LANG_CODE")}));
		    }
		    // resSetPayMode.close();
		    CommonUtils.closeCursor(resSetPayMode);
		}
	    }
	    */
	    if (condition.contains(" " + paymentPdMode + " ")) {
		String TXN_TYPE =(String) CommonUtils
			.getGlobalObject("GLOBAL.TXN_TYPE");
		if ("DR".equals(TXN_TYPE)) {
		    throw new Exception(Messages.getString(  PELConstants.pelErrorMessagePath, "91000"));
		}

		if ("D".equals(paymentDetailBean.getPD_PAID_FOR())) {
		    paymentDetailBean.setUI_M_PD_DEP_AMT(paymentDetailBean .getPD_LC_AMT());
		    paymentDetailBean.setUI_M_PD_OTH_AMT(0.0);
		} else {
		    paymentDetailBean.setUI_M_PD_OTH_AMT(paymentDetailBean.getPD_LC_AMT());
		    paymentDetailBean.setUI_M_PD_DEP_AMT(0.0);
		}

		//paymentDetailBean.setPD_DPD_REF_ID(null);

		pymtDtlAction.getCOMP_PD_DPD_REF_ID().setDisabled(true);
		//pymtDtlAction.getCOMP_PD_DPD_REF_ID().setRequired(false);

		/*
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_DPD_REF_ID",ENABLED,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_DPD_REF_ID",REQUIRED,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.M_BUT_LOV_DPD_REF_ID",ENABLED,PROPERTY_FALSE);
		 */

	    }
	    if ("P".equals(paymentPdMode)
		    || "F".equalsIgnoreCase(paymentPdMode) || "E".equals(paymentPdMode)) {

		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_BANK_NAME(null);
		paymentDetailBean.setPD_BRANCH_NAME(null);
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);
		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setUI_M_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);
		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		paymentDetailBean.setPD_ATM_CARD_NO(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);

		pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);

		pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);

		pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(false);
		pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);

		pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);

		pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);

		pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);

		pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);

		pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);

		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);

		pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);

		pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);

		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);

		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);

		pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);

		pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);

		pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2()
			.setRequired(false);
		;

		pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);

		pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);

	    } else if (condition2.contains(" " + paymentPdMode + " ")) {
		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_APP_CODE(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);

		//pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(false);
		pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(false);
		pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);

		//pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(false); // NAVIGABLE-true
		pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(false); // NAVIGABLE-true
		pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false); // NAVIGABLE-true
		pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false); // NAVIGABLE-true

		//pymtDtlAction.getCOMP_PD_CHQ_NO().setReadonly(false); // UPDATE_ALLOWED-true
		// pymtDtlAction.getCOMP_PD_CHQ_DT().setReadonly(false);
		// //UPDATE_ALLOWED-true
		pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false); // UPDATE_ALLOWED-true
		pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false); // UPDATE_ALLOWED-true

		pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(true);
		pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(true);
		pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(true);
		pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		pymtDtlAction.getCOMP_PD_MICR_CODE().setRequired(true);//added newly for micr code

		pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);

		pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);

		pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);

		pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);

		pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);

		pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);

		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);

		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);

		pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);

		pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);

		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);

		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);

		/*
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		 */
		pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);

		pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2()
			.setRequired(false);

		pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);

		/*if ("CHANGED".equals(RECORD_STATUS)) {
		    
		     * :PT_IL_PYMT_DTLS.PD_CHQ_NO=:PT_IL_PYMT_DTLS.PD_CHQ_NO;
		     * :PT_IL_PYMT_DTLS.PD_CHQ_DT=:PT_IL_PYMT_DTLS.PD_CHQ_DT;
		     * :PT_IL_PYMT_DTLS.PD_BANK_NAME=:PT_IL_PYMT_DTLS.PD_BANK_NAME;
		     * :PT_IL_PYMT_DTLS.PD_BRANCH_NAME=:PT_IL_PYMT_DTLS.PD_BRANCH_NAME;
		     
		} else {
		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_DT(null);
		    paymentDetailBean.setPD_BANK_NAME(null);
		    paymentDetailBean.setPD_BRANCH_NAME(null);
		}*/

		paymentDetailBean.setPD_CC_TYPE("O");
		paymentDetailBean.setPD_CC_NO(null);
		paymentDetailBean.setPD_CC_NAME(null);
		paymentDetailBean.setPD_CC_EXP_DT(null);
		paymentDetailBean.setUI_M_EXP_DT(null);

		paymentDetailBean.setPD_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		paymentDetailBean.setPD_TT_REF_NO(null);
		paymentDetailBean.setPD_TT_CURR_CODE(null);

		paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		//paymentDetailBean.setUI_M_CHQ_NO(null);

		paymentDetailBean.setPD_PO_MO_NO(null);
		paymentDetailBean.setPD_PO_MO_DT(null);
		paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		paymentDetailBean.setPD_REM_AMT(null);
		paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);

		paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		paymentDetailBean.setPD_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);

		paymentDetailBean.setUI_M_BANK_REF_NO(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		paymentDetailBean.setPD_CR_ADVICE_NO(null);

		paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		paymentDetailBean.setUI_M_PD_CC_NO(null);
		paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		paymentDetailBean.setPD_ATM_CARD_NO(null);
	    } else if (condition1.contains(" " + paymentPdMode + " ")) {
		paymentDetailBean.setPD_CHQ_NO(null);
		paymentDetailBean.setPD_CHQ_DT(null);
		paymentDetailBean.setPD_BANK_NAME(null);
		paymentDetailBean.setPD_BRANCH_NAME(null);
		// paymentDetailBean.setUI_M_PD_CC_NO_1(null);

		pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(false);
		pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(false);
		pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(false);
		pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(false);
		pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(false);

		pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(true);
		pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(true);
		pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);

		pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);

		pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(false);
		pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);

		pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);

		pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);

		pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);

		pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);

		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);

		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);

		pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);

		pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);

		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);

		pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);

		pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);

		pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1()
			.setRequired(false);

		/*
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		 * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		 * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		 */pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);

		if (!"I".equalsIgnoreCase(paymentPdMode)) {

		    rs = handler.executeSelectStatement(C4, connection,
			    new Object[] { CommonUtils.getControlBean()
				    .getM_USER_ID() });
		    if (rs.next()) {
			M_USER_CREDIT_CARD_UPD_YN = rs.getString(1);
		    }

		    if ("N".equalsIgnoreCase(M_USER_CREDIT_CARD_UPD_YN)
			    && paymentDetailBean.getUI_M_PD_CC_NO() != null) {
			pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
			/*
			 * SET_ITEM_PROPERTY('PT_IL_PYMT_DTLS.M_PD_CC_NO_1',UPDATE_ALLOWED,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('PT_IL_PYMT_DTLS.M_PD_CC_NO_1',INSERT_ALLOWED,PROPERTY_FALSE);
			 */
		    }
		}

		if ("CHANGED".equals(RECORD_STATUS)) {
		    /*
		     * :PT_IL_PYMT_DTLS.PD_CC_TYPE=:PT_IL_PYMT_DTLS.PD_CC_TYPE;
		     * :PT_IL_PYMT_DTLS.PD_CC_NO=:PT_IL_PYMT_DTLS.PD_CC_NO;
		     * :PT_IL_PYMT_DTLS.PD_CC_NAME=:PT_IL_PYMT_DTLS.PD_CC_NAME;
		     * :PT_IL_PYMT_DTLS.PD_CC_EXP_DT=:PT_IL_PYMT_DTLS.PD_CC_EXP_DT;
		     * :PT_IL_PYMT_DTLS.PD_CC_APP_CODE=:PT_IL_PYMT_DTLS.PD_CC_APP_CODE;
		     * :PT_IL_PYMT_DTLS.M_EXP_DT=:PT_IL_PYMT_DTLS.M_EXP_DT;
		     */
		} else {
		    paymentDetailBean.setPD_CC_TYPE("O");
		    paymentDetailBean.setPD_CC_NO(null);
		    paymentDetailBean.setPD_CC_NAME(null);
		    paymentDetailBean.setPD_CC_EXP_DT(null);
		    paymentDetailBean.setPD_CC_APP_CODE(null);
		    paymentDetailBean.setUI_M_EXP_DT(null);

		    paymentDetailBean.setPD_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_TT_REF_NO(null);
		    paymentDetailBean.setPD_TT_CURR_CODE(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		   paymentDetailBean.setUI_M_CHQ_NO(null);
		   paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_PO_MO_NO(null);
		    paymentDetailBean.setPD_PO_MO_DT(null);
		    paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setPD_REM_AMT(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		    paymentDetailBean.setPD_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		    paymentDetailBean.setPD_CR_ADVICE_NO(null);

		    paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		    paymentDetailBean.setUI_M_PD_CC_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		    paymentDetailBean.setPD_ATM_CARD_NO(null);
		}
		if ("TT".equals(pymtDtlAction.getCOMP_PD_PAY_MODE())) {
		    paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_TT_REF_NO(null);
		    paymentDetailBean.setPD_OUR_BANK_CODE(null);

		    pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);

		    pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);

		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);

		    pymtDtlAction.getCOMP_PD_TT_REF_NO_LABEL().setValue(
			    "TT Reference No");
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE_LABEL().setValue(
			    "Our Bank Account No");
		    /*
		     * :BP.B_PD_TT_REF_NO := 'TT Reference No';
		     * :BP.B_PD_OUR_BANK_CODE := 'Our Bank Account No';
		     */

		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRendered(true);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE_LABEL().setRendered(
			    true);
		    // SET_ITEM_PROPERTY('PT_IL_PYMT_DTLS.M_BUT_LOV_TT_CURR_CODE',VISIBLE,PROPERTY_TRUE);

		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT()
			    .setDisabled(false);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(false);

		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(true);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(true);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(true);

		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);

		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(
			    true);

		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(
			    false);

		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);

		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_DT(null);
		    paymentDetailBean.setPD_BANK_NAME(null);
		    paymentDetailBean.setPD_BRANCH_NAME(null);
		    paymentDetailBean.setPD_CC_TYPE("O");
		    paymentDetailBean.setPD_CC_NO(null);
		    paymentDetailBean.setPD_CC_NAME(null);
		    paymentDetailBean.setPD_CC_APP_CODE(null);
		    paymentDetailBean.setPD_CC_EXP_DT(null);
		    paymentDetailBean.setUI_M_EXP_DT(null);

		    if ("CHANGED".equals(RECORD_STATUS)) {
			/*
			 * :PT_IL_PYMT_DTLS.PD_OUR_BANK_CODE=:PT_IL_PYMT_DTLS.PD_OUR_BANK_CODE;
			 * :PT_IL_PYMT_DTLS.PD_DATE_OF_CREDIT=:PT_IL_PYMT_DTLS.PD_DATE_OF_CREDIT;
			 * :PT_IL_PYMT_DTLS.PD_TT_REF_NO=:PT_IL_PYMT_DTLS.PD_TT_REF_NO;
			 * :PT_IL_PYMT_DTLS.PD_TT_CURR_CODE=:PT_IL_PYMT_DTLS.PD_TT_CURR_CODE;
			 */
		    } else {
			paymentDetailBean.setPD_OUR_BANK_CODE(null);
			paymentDetailBean.setPD_DATE_OF_CREDIT(null);
			paymentDetailBean.setPD_TT_REF_NO(null);
			paymentDetailBean.setPD_TT_CURR_CODE(null);
		    }
		    paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setUI_M_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_PO_MO_NO(null);
		    paymentDetailBean.setPD_PO_MO_DT(null);
		    paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setPD_REM_AMT(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		    paymentDetailBean.setPD_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		    paymentDetailBean.setPD_CR_ADVICE_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		    paymentDetailBean.setUI_M_PD_CC_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		    paymentDetailBean.setPD_ATM_CARD_NO(null);
		} else if ("BC".equals(paymentDetailBean.getPD_PAY_MODE())) {
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT()
			    .setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE()
			    .setRequired(true);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN()
			    .setRequired(true);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(true);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(true);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(
			    false);

		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(
			    true);

		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(
			    false);

		    /*
		     * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		     * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		     * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		     * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		     */

		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);

		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_DT(null);
		    paymentDetailBean.setPD_CC_TYPE("O");
		    paymentDetailBean.setPD_CC_NO(null);
		    paymentDetailBean.setPD_CC_NAME(null);
		    paymentDetailBean.setPD_CC_APP_CODE(null);
		    paymentDetailBean.setPD_CC_EXP_DT(null);
		    paymentDetailBean.setUI_M_EXP_DT(null);
		    paymentDetailBean.setPD_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_TT_REF_NO(null);
		    paymentDetailBean.setPD_TT_CURR_CODE(null);
		    if ("CHANGED".equals(RECORD_STATUS)) {
			/*
			 * :PT_IL_PYMT_DTLS.M_OUR_BANK_CODE=:PT_IL_PYMT_DTLS.M_OUR_BANK_CODE;
			 * :PT_IL_PYMT_DTLS.PD_REM_SLIP_GEN_YN=:PT_IL_PYMT_DTLS.PD_REM_SLIP_GEN_YN;
			 * :PT_IL_PYMT_DTLS.M_CHQ_NO=:PT_IL_PYMT_DTLS.M_CHQ_NO;
			 * :PT_IL_PYMT_DTLS.PD_BANK_NAME=:PT_IL_PYMT_DTLS.PD_BANK_NAME;
			 * :PT_IL_PYMT_DTLS.PD_BRANCH_NAME=:PT_IL_PYMT_DTLS.PD_BRANCH_NAME;
			 */
		    } else {
			paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
			paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
			//paymentDetailBean.setUI_M_CHQ_NO(null);
			paymentDetailBean.setPD_BANK_NAME(null);
			paymentDetailBean.setPD_BRANCH_NAME(null);
		    }
		    paymentDetailBean.setPD_PO_MO_NO(null);
		    paymentDetailBean.setPD_PO_MO_DT(null);
		    paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setPD_REM_AMT(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		    paymentDetailBean.setPD_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		    paymentDetailBean.setPD_CR_ADVICE_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		    paymentDetailBean.setUI_M_PD_CC_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		    paymentDetailBean.setPD_ATM_CARD_NO(null);
		} else if ("PM".equals(paymentDetailBean.getPD_PAY_MODE())) {
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT()
			    .setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(true);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(
			    true);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(
			    true);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(
			    false);

		    /*
		     * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		     * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		     * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		     * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		     */

		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);

		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_DT(null);
		    paymentDetailBean.setPD_BANK_NAME(null);
		    paymentDetailBean.setPD_BRANCH_NAME(null);
		    paymentDetailBean.setPD_CC_TYPE("O");
		    paymentDetailBean.setPD_CC_NO(null);
		    paymentDetailBean.setPD_CC_NAME(null);
		    paymentDetailBean.setPD_CC_APP_CODE(null);
		    paymentDetailBean.setPD_CC_EXP_DT(null);
		    paymentDetailBean.setUI_M_EXP_DT(null);
		    paymentDetailBean.setPD_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_TT_REF_NO(null);
		    paymentDetailBean.setPD_TT_CURR_CODE(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setUI_M_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_NO(null);

		    if ("CHANGED".equals(RECORD_STATUS)) {
			/*
			 * :PT_IL_PYMT_DTLS.PD_PO_MO_NO=:PT_IL_PYMT_DTLS.PD_PO_MO_NO;
			 * :PT_IL_PYMT_DTLS.PD_PO_MO_DT=:PT_IL_PYMT_DTLS.PD_PO_MO_DT;
			 * :PT_IL_PYMT_DTLS.M_REM_SLIP_GEN_YN=:PT_IL_PYMT_DTLS.M_REM_SLIP_GEN_YN;
			 * :PT_IL_PYMT_DTLS.PD_REM_AMT=:PT_IL_PYMT_DTLS.PD_REM_AMT;
			 * :PT_IL_PYMT_DTLS.M_OUR_BANK_CODE_1=:PT_IL_PYMT_DTLS.M_OUR_BANK_CODE_1;
			 * :PT_IL_PYMT_DTLS.PD_FC_AMT=:PT_IL_PYMT_DTLS.PD_FC_AMT;
			 */
		    } else {
			paymentDetailBean.setPD_PO_MO_NO(null);
			paymentDetailBean.setPD_PO_MO_DT(null);
			paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
			paymentDetailBean.setPD_REM_AMT(null);
			paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		    }
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		    paymentDetailBean.setPD_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		    paymentDetailBean.setPD_CR_ADVICE_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		    paymentDetailBean.setUI_M_PD_CC_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		    paymentDetailBean.setPD_ATM_CARD_NO(null);
		} else if ("EF".equals(paymentDetailBean.getPD_PAY_MODE())) {
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT()
			    .setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(
			    true);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(true);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setReadonly(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setReadonly(false);
		    // pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setReadonly(false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);

		    /*
		     * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		     * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		     * pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		     * pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		     */

		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);

		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_DT(null);
		    /*
		     * paymentDetailBean.setPD_BANK_NAME(null);
		     * paymentDetailBean.setPD_BRANCH_NAME(null);
		     */

		    paymentDetailBean.setPD_CC_TYPE("O");
		    paymentDetailBean.setPD_CC_NO(null);
		    paymentDetailBean.setPD_CC_NAME(null);
		    paymentDetailBean.setPD_CC_APP_CODE(null);
		    paymentDetailBean.setPD_CC_EXP_DT(null);
		    paymentDetailBean.setUI_M_EXP_DT(null);
		    paymentDetailBean.setPD_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_TT_REF_NO(null);
		    paymentDetailBean.setPD_TT_CURR_CODE(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		   paymentDetailBean.setUI_M_CHQ_NO(null);
		   paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_PO_MO_NO(null);
		    paymentDetailBean.setPD_PO_MO_DT(null);
		    paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setPD_REM_AMT(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		    paymentDetailBean.setPD_CR_ADVICE_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		    paymentDetailBean.setUI_M_PD_CC_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		    paymentDetailBean.setPD_ATM_CARD_NO(null);
		    if ("CHANGED".equals(RECORD_STATUS)) {
			/*
			 * :PT_IL_PYMT_DTLS.M_OUR_BANK_CODE_2=:PT_IL_PYMT_DTLS.M_OUR_BANK_CODE_2;
			 * :PT_IL_PYMT_DTLS.PD_BANK_REF_NO=:PT_IL_PYMT_DTLS.PD_BANK_REF_NO;
			 * :PT_IL_PYMT_DTLS.M_DATE_OF_CREDIT=:PT_IL_PYMT_DTLS.M_DATE_OF_CREDIT;
			 * :PT_IL_PYMT_DTLS.PD_BANK_NAME=:PT_IL_PYMT_DTLS.PD_BANK_NAME;
			 * :PT_IL_PYMT_DTLS.PD_BRANCH_NAME=:PT_IL_PYMT_DTLS.PD_BRANCH_NAME;
			 */
		    } else {
			paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
			paymentDetailBean.setPD_BANK_REF_NO(null);
			paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
			paymentDetailBean.setPD_BANK_NAME(null);
			paymentDetailBean.setPD_BRANCH_NAME(null);
		    }
		} else if ("AD".equals(paymentDetailBean.getPD_PAY_MODE())) {
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT()
			    .setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(
			    false);

		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);

		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(
			    true);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(true);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setReadonly(false);
		    // pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setReadonly(false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setReadonly(false);
		    // pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setReadonly(false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);

		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_DT(null);
		    paymentDetailBean.setPD_CC_TYPE("O");
		    paymentDetailBean.setPD_CC_NO(null);
		    paymentDetailBean.setPD_CC_NAME(null);
		    paymentDetailBean.setPD_CC_APP_CODE(null);
		    paymentDetailBean.setPD_CC_EXP_DT(null);
		    paymentDetailBean.setUI_M_EXP_DT(null);
		    paymentDetailBean.setPD_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_TT_REF_NO(null);
		    paymentDetailBean.setPD_TT_CURR_CODE(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setUI_M_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_PO_MO_NO(null);
		    paymentDetailBean.setPD_PO_MO_DT(null);
		    paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setPD_REM_AMT(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		    paymentDetailBean.setPD_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_CR_ADVICE_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		    paymentDetailBean.setUI_M_PD_CC_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		    paymentDetailBean.setPD_ATM_CARD_NO(null);
		    if ("CHANGED".equals(RECORD_STATUS)) {
			/*
			 * :PT_IL_PYMT_DTLS.M_BANK_REF_NO=:PT_IL_PYMT_DTLS.M_BANK_REF_NO;
			 * :PT_IL_PYMT_DTLS.M_DATE_OF_CREDIT_1=:PT_IL_PYMT_DTLS.M_DATE_OF_CREDIT_1;
			 * :PT_IL_PYMT_DTLS.PD_BANK_NAME=:PT_IL_PYMT_DTLS.PD_BANK_NAME;
			 * :PT_IL_PYMT_DTLS.PD_BRANCH_NAME=:PT_IL_PYMT_DTLS.PD_BRANCH_NAME;
			 */
		    } else {
			paymentDetailBean.setUI_M_BANK_REF_NO(null);
			paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
			paymentDetailBean.setPD_BANK_NAME(null);
			paymentDetailBean.setPD_BRANCH_NAME(null);
		    }
		} else if ("SC".equals(paymentPdMode)) {
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT()
			    .setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1()
			    .setRequired(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(
			    true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(
			    false);
		    // pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setReadonly(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setReadonly(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setReadonly(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setReadonly(
			    false);
		    // pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setReadonly(false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);

		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_DT(null);
		    paymentDetailBean.setPD_BANK_NAME(null);
		    paymentDetailBean.setPD_BRANCH_NAME(null);
		    paymentDetailBean.setPD_CC_TYPE("O");
		    paymentDetailBean.setPD_CC_NO(null);
		    paymentDetailBean.setPD_CC_NAME(null);
		    paymentDetailBean.setPD_CC_APP_CODE(null);
		    paymentDetailBean.setPD_CC_EXP_DT(null);
		    paymentDetailBean.setUI_M_EXP_DT(null);
		    paymentDetailBean.setPD_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_TT_REF_NO(null);
		    paymentDetailBean.setPD_TT_CURR_CODE(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setUI_M_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_PO_MO_NO(null);
		    paymentDetailBean.setPD_PO_MO_DT(null);
		    paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setPD_REM_AMT(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		    paymentDetailBean.setPD_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		    paymentDetailBean.setPD_CR_ADVICE_NO(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		    paymentDetailBean.setPD_ATM_CARD_NO(null);
		    if ("CHANGED".equals(RECORD_STATUS)) {
			paymentDetailBean.setUI_M_PD_CC_TYPE(paymentDetailBean
				.getPD_CC_TYPE());
			paymentDetailBean.setUI_M_PD_CC_NO(paymentDetailBean
				.getPD_CC_NO());
			paymentDetailBean
				.setUI_M_PD_CC_APP_CODE(paymentDetailBean
					.getPD_CC_APP_CODE());
			paymentDetailBean
				.setUI_M_BANK_REF_NO_1(paymentDetailBean
					.getPD_BANK_REF_NO());
			paymentDetailBean
				.setUI_M_DATE_OF_CREDIT_2(paymentDetailBean
					.getPD_DATE_OF_CREDIT());
		    } else {
			paymentDetailBean.setUI_M_PD_CC_TYPE(null);
			paymentDetailBean.setUI_M_PD_CC_NO(null);
			paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
			paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
			paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		    }
		} else if ("A".equals(paymentPdMode)) {
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT()
			    .setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setReadonly(
			    false);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setReadonly(false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);

		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_DT(null);
		    paymentDetailBean.setPD_CC_TYPE("O");
		    paymentDetailBean.setPD_CC_NO(null);
		    paymentDetailBean.setPD_CC_NAME(null);
		    paymentDetailBean.setPD_CC_APP_CODE(null);
		    paymentDetailBean.setPD_CC_EXP_DT(null);
		    paymentDetailBean.setUI_M_EXP_DT(null);
		    paymentDetailBean.setPD_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_TT_REF_NO(null);
		    paymentDetailBean.setPD_TT_CURR_CODE(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setUI_M_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_PO_MO_NO(null);
		    paymentDetailBean.setPD_PO_MO_DT(null);
		    paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setPD_REM_AMT(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		    paymentDetailBean.setPD_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		    paymentDetailBean.setPD_CR_ADVICE_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		    paymentDetailBean.setUI_M_PD_CC_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		    if ("CHANGED".equals(RECORD_STATUS)) {
			/*
			 * pymtDtlBean.setUI_M_BANK_REF_NO_2(pymtDtlBean.getUI_M_BANK_REF_NO_2());
			 * pymtDtlBean.setPD_ATM_CARD_NO(pymtDtlBean.getPD_ATM_CARD_NO());
			 * pymtDtlBean.setPD_BANK_NAME(pymtDtlBean.getPD_BANK_NAME());
			 * pymtDtlBean.setPD_BRANCH_NAME(pymtDtlBean.getPD_BRANCH_NAME());
			 */
		    } else {
			paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
			paymentDetailBean.setPD_ATM_CARD_NO(null);
			paymentDetailBean.setPD_BANK_NAME(null);
			paymentDetailBean.setPD_BRANCH_NAME(null);
		    }
		} else if ("E".equals(paymentPdMode)) {
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(false);
		    // pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(false);//",NAVIGABLE,PROPERTY_TRUE);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(true);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(false);
		    // pymtDtlAction.getCOMP_PD_CR_ADVICE_NO",NAVIGABLE,PROPERTY_TRUE);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(true);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(false);
		    paymentDetailBean.setPD_PAYIN_DATE(new java.sql.Date(
			    Calendar.getInstance().getTimeInMillis()));
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		    // pymtDtlAction.getCOMP_PT_IL_PYMT_DTLS.PD_BANK_NAME",NAVIGABLE,PROPERTY_TRUE);
		    // pymtDtlAction.getCOMP_PT_IL_PYMT_DTLS.PD_BRANCH_NAME",NAVIGABLE,PROPERTY_TRUE);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(true);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT()
			    .setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);

		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_DT(null);
		    paymentDetailBean.setPD_CC_TYPE("O");
		    paymentDetailBean.setPD_CC_NO(null);
		    paymentDetailBean.setPD_CC_NAME(null);
		    paymentDetailBean.setPD_CC_APP_CODE(null);
		    paymentDetailBean.setPD_CC_EXP_DT(null);
		    paymentDetailBean.setUI_M_EXP_DT(null);
		    paymentDetailBean.setPD_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_TT_REF_NO(null);
		    paymentDetailBean.setPD_TT_CURR_CODE(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setUI_M_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_PO_MO_NO(null);
		    paymentDetailBean.setPD_PO_MO_DT(null);
		    paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setPD_REM_AMT(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		    paymentDetailBean.setPD_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		    paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		    paymentDetailBean.setUI_M_PD_CC_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_2(null);
		    paymentDetailBean.setPD_ATM_CARD_NO(null);
		    if ("CHANGED".equals(RECORD_STATUS)) {
			/*
			 * :PT_IL_PYMT_DTLS.PD_BANK_NAME=:PT_IL_PYMT_DTLS.PD_BANK_NAME;
			 * :PT_IL_PYMT_DTLS.PD_BRANCH_NAME=:PT_IL_PYMT_DTLS.PD_BRANCH_NAME;
			 * :PT_IL_PYMT_DTLS.PD_CR_ADVICE_NO=:PT_IL_PYMT_DTLS.PD_CR_ADVICE_NO;
			 */
		    } else {
			paymentDetailBean.setPD_BANK_NAME(null);
			paymentDetailBean.setPD_BRANCH_NAME(null);
			paymentDetailBean.setPD_CR_ADVICE_NO(null);
		    }
		} else if ("DP".equals(paymentPdMode)) {
		    paymentDetailBean.setPD_CHQ_NO(null);
		    paymentDetailBean.setPD_CHQ_DT(null);
		    paymentDetailBean.setPD_BANK_NAME(null);
		    paymentDetailBean.setPD_BRANCH_NAME(null);
		    paymentDetailBean.setPD_CC_TYPE("O");
		    paymentDetailBean.setPD_CC_NO(null);
		    paymentDetailBean.setPD_CC_NAME(null);
		    paymentDetailBean.setPD_CC_APP_CODE(null);
		    paymentDetailBean.setPD_CC_EXP_DT(null);
		    paymentDetailBean.setUI_M_EXP_DT(null);
		    paymentDetailBean.setPD_OUR_BANK_CODE(null);
		    paymentDetailBean.setPD_DATE_OF_CREDIT(null);
		    paymentDetailBean.setPD_TT_REF_NO(null);
		    paymentDetailBean.setPD_TT_CURR_CODE(null);
		    paymentDetailBean.setPD_PO_MO_NO(null);
		    paymentDetailBean.setPD_PO_MO_DT(null);
		    paymentDetailBean.setUI_M_REM_SLIP_GEN_YN(null);
		    paymentDetailBean.setPD_REM_AMT(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_1(null);
		    paymentDetailBean.setUI_M_OUR_BANK_CODE_2(null);
		    paymentDetailBean.setPD_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_1(null);
		    paymentDetailBean.setPD_CR_ADVICE_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_TYPE(null);
		    paymentDetailBean.setUI_M_PD_CC_NO(null);
		    paymentDetailBean.setUI_M_PD_CC_APP_CODE(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_1(null);
		    paymentDetailBean.setUI_M_DATE_OF_CREDIT_2(null);
		    paymentDetailBean.setUI_M_BANK_REF_NO_2(null);

		    pymtDtlAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_NAME().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		    // pymtDtlAction.getCOMP_PT_IL_PYMT_DTLS.PD_BANK_NAME",NAVIGABLE,PROPERTY_TRUE);
		    // pymtDtlAction.getCOMP_PT_IL_PYMT_DTLS.PD_BRANCH_NAME",NAVIGABLE,PROPERTY_TRUE);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setRequired(true);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		    pymtDtlAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		    pymtDtlAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		    pymtDtlAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_DATE_OF_CREDIT()
			    .setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		   // pymtDtlAction.getCOMP_PD_DPD_REF_ID().setDisabled(false);
		   //pymtDtlAction.getCOMP_PD_DPD_REF_ID().setRequired(true);
		    // pymtDtlAction.getCOMP_UI_M_BUT_LOV_DPD_REF_ID().setDisabled(false);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);

		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		    pymtDtlAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_REM_AMT().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(
			    false);

		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(
			    false);

		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(
			    true);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		    pymtDtlAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2()
			    .setDisabled(true);
		    pymtDtlAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(
			    false);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		    pymtDtlAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);

		    // GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_DPD_REF_ID");
		    paymentDetailBean.setPD_FC_AMT(null);
		    paymentDetailBean.setPD_LC_AMT(null);
		} else if ("PT".equals(paymentPdMode)) {
		    throw new Exception(Messages.getString(
			    PELConstants.pelErrorMessagePath, "91391"));
		}
		if ("D".equals(paymentDetailBean.getPD_PAID_FOR())) {
		    paymentDetailBean.setUI_M_PD_DEP_AMT(paymentDetailBean
			    .getPD_LC_AMT());
		    paymentDetailBean.setUI_M_PD_OTH_AMT(0.0);
		} else {
		    paymentDetailBean.setUI_M_PD_OTH_AMT(paymentDetailBean
			    .getPD_LC_AMT());
		    paymentDetailBean.setUI_M_PD_DEP_AMT(0.0);
		}

		if ("E".equals(paymentPdMode)) {
		    // pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		    // pymtDtlAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		}
		if (paymentPdMode == null && !"E".equals(paymentPdMode)) {
		    paymentDetailBean.setPD_PAYIN_DATE(new java.sql.Date(
			    Calendar.getInstance().getTimeInMillis()));
		    // pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		} else if (paymentPdMode != null && "E".equals(paymentPdMode)) {
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		} else if (paymentPdMode != null && !"E".equals(paymentPdMode)) {
		    pymtDtlAction.getCOMP_PD_PAYIN_DATE().setDisabled(false);
		}
	    }
	} catch (DBException e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} catch (SQLException e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} finally {
	    try {
		CommonUtils.closeCursor(resSetPayMode);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    try {
		CommonUtils.closeCursor(resSetOnPayMode);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    try {
		CommonUtils.closeCursor(resSetCustPerc);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    /*
     * public void pilt017_pt_il_pymt_dtls_pd_sr_no_key_prev_item() throws
     * SQLException,Exception {
     * 
     * //Connection vembu_conn =
     * SwisSqlConnection.getInstance().getConnection(); try { // final
     * dbms_output dbms_output1=new dbms_output();
     * connection=connectionAgent.getConnection();
     * 
     * 
     * if(:SYSTEM.CURSOR_RECORD!=1) { PREVIOUS_RECORD.PREVIOUS_RECORD();
     * GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_REMARKS"); } }catch(Exception e) {
     * e.printStackTrace(); throw e; } finally { if(vembu_conn != null) {
     * SwisSqlConnection.getInstance().closeConnection(vembu_conn); } } }
     */

    public void pilt017_pt_il_pymt_dtls_pd_sr_no_when_validate_item(
	    PT_IL_PYMT_DTLS_ACTION pymtDtlAction) throws SQLException,
	    Exception {
	PT_IL_PYMT_DTLS paymentDetailsBean = pymtDtlAction
		.getPT_IL_PYMT_DTLS_BEAN();
	try {
	    if(paymentDetailsBean.getPD_SR_NO()!= 0){
	   if(paymentDetailsBean.getPD_SR_NO() < 1 ){
	       throw new Exception(
			Messages.getString(
					PELConstants.pelErrorMessagePath,
					"91003",
					new Object[] {
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")  }));
	   }
	    }
	    if ("D".equals(paymentDetailsBean.getPD_PAID_FOR())) {
		paymentDetailsBean.setUI_M_PD_DEP_AMT(paymentDetailsBean
			.getPD_LC_AMT());
		paymentDetailsBean.setUI_M_PD_OTH_AMT(0.0);
	    } else {
		paymentDetailsBean.setUI_M_PD_OTH_AMT(paymentDetailsBean
			.getPD_LC_AMT());
		paymentDetailsBean.setUI_M_PD_DEP_AMT(0.0);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
    }

    public void L_DUP_CHQ_NO(PT_IL_PYMT_DTLS_ACTION pymtDtlAction)
	    throws SQLException, Exception {
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	ResultSet valExists1 = null;
	ResultSet valExists2 = null;

	PT_IL_PYMT_DTLS paymentDetailsBean = pymtDtlAction
		.getPT_IL_PYMT_DTLS_BEAN();
	String ROWID = paymentDetailsBean.getROWID();

	// Connection vembu_conn =
	// SwisSqlConnection.getInstance().getConnection();
	try {
	    connection = CommonUtils.getConnection();
	    String RECORD_STATUS = null;
	    handler = new CRUDHandler();

	    if (ROWID != null) {
		RECORD_STATUS = "CHANGED";
	    } else {
		RECORD_STATUS = "INSERT";
	    }

	    String recExistsQry1 = SqlConstants.RECORD_EXISTS1;
	    Object[] forValue1 = { paymentDetailsBean.getPD_BANK_NAME() };

	    String recExistsQry2 = SqlConstants.RECORD_EXISTS2;
	    Object[] forValue2 = { paymentDetailsBean.getPD_BANK_NAME(), ROWID };

	    if ("INSERT".equals(RECORD_STATUS)) {
		valExists1 = handler.executeSelectStatement(recExistsQry1,
			connection, forValue1);
		while (valExists1.next()) {
		    if (!valExists1.isLast()) {
			throw new ValidatorException(Messages.getMessage(
				PELConstants.pelErrorMessagePath, "91399"));
		    }
		}
	    } else if ("CHANGED".equals(RECORD_STATUS)) {
		valExists2 = handler.executeSelectStatement(recExistsQry2,
			connection, forValue2);
		while (valExists2.next()) {
		    if (!valExists2.isLast()) {
			throw new ValidatorException(Messages.getMessage(
				PELConstants.pelErrorMessagePath, "91399"));
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	} finally {
	    try {
		CommonUtils.closeCursor(valExists1);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    try {
		CommonUtils.closeCursor(valExists2);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void pilt017_pt_il_pymt_dtls_m_exp_dt_when_validate_item(
	    PT_IL_PYMT_DTLS_ACTION pymtDtlAction) throws SQLException,
	    Exception {
	PT_IL_PYMT_DTLS paymentDetailsBean = pymtDtlAction
		.getPT_IL_PYMT_DTLS_BEAN();

	CommonUtils commonUtils = new CommonUtils();
	String condition = " I CC C1 C2 C3 C4 C5 C6 ";
	String PD_PAY_MODE = paymentDetailsBean.getPD_PAY_MODE();
	try {
	    paymentDetailsBean.setPD_CC_EXP_DT(DateFunctions
		    .last_day(ConvertFunctions
			    .to_date((java.sql.Date) paymentDetailsBean
				    .getUI_M_EXP_DT(), "MM/RR")));
	    paymentDetailsBean.setPD_CC_EXP_DT(DateFunctions
		    .last_day(ConvertFunctions
			    .to_date((java.sql.Date) paymentDetailsBean
				    .getUI_M_EXP_DT(), "MM/RR")));
	    if (paymentDetailsBean.getPD_CC_EXP_DT() != null) {
		if (ConvertFunctions.to_date(
			ConvertFunctions.to_char(
				(java.sql.Date) paymentDetailsBean
					.getPD_CC_EXP_DT(), "DD/MM/RRRR"),
			"DD/MM/RRRR").compareTo(
			ConvertFunctions.to_date(ConvertFunctions.to_char(
				commonUtils.getCurrentSQLDate(), "dd/MM/yyyy"),
				"dd/MM/yyyy")) < 0) {
		    throw new ValidatorException(Messages.getMessage(
			    PELConstants.pelErrorMessagePath, "91064"));
		}
		if (paymentDetailsBean.getPD_CC_EXP_DT().after(
			ConvertFunctions.to_date("31/12/2999", "DD/MM/RRRR"))) {
		    throw new ValidatorException(Messages.getMessage(
			    PELConstants.pelErrorMessagePath, "91063"));
		}
	    }
	    if (condition.contains(" " + PD_PAY_MODE + " ")) {
		// pymtDtlBean.setUI_M_EXP_DT((ConvertFunctions.to_char((Date)pymtDtlBean.getPD_CC_EXP_DT(),"MM")+"/"+ConvertFunctions.to_char((Date)pymtDtlBean.getPD_CC_EXP_DT(),"YYYY")));
	    } else {
		paymentDetailsBean.setUI_M_EXP_DT(null);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}

	/*
	 * { Connection vembu_conn =
	 * SwisSqlConnection.getInstance().getConnection(); try { final
	 * dbms_output dbms_output1=new dbms_output(); try{
	 * :PT_IL_PYMT_DTLS.PD_CC_EXP_DT=DateFunctions.last_day(ConvertFunctions.to_date(:PT_IL_PYMT_DTLS.M_EXP_DT,"MM/RR")); }
	 * catch(SQLException se){
	 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91014,:CTRL.M_LANG_CODE,"FORMAT","MM","YYYY");
	 * throw new FORM_TRIGGER_FAILURE(); }
	 * :PT_IL_PYMT_DTLS.PD_CC_EXP_DT=DateFunctions.last_day(ConvertFunctions.to_date(:PT_IL_PYMT_DTLS.M_EXP_DT,"MM/RR"));
	 * if(:PT_IL_PYMT_DTLS.PD_CC_EXP_DT != null) {
	 * if(ConvertFunctions.to_date(ConvertFunctions.to_char(:PT_IL_PYMT_DTLS.PD_CC_EXP_DT,"DD/MM/RRRR"),"DD/MM/RRRR").compareTo(ConvertFunctions.to_date(ConvertFunctions.to_char(new
	 * java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/RRRR"),"DD/MM/RRRR"))
	 * <0) {
	 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91064,:CTRL.M_LANG_CODE);
	 * throw new FORM_TRIGGER_FAILURE(); } }
	 * if(:PT_IL_PYMT_DTLS.PD_CC_EXP_DT != null) {
	 * if(:PT_IL_PYMT_DTLS.PD_CC_EXP_DT>ConvertFunctions.to_date("31/12/2999","DD/MM/RRRR")) {
	 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91063,:CTRL.M_LANG_CODE);
	 * throw new FORM_TRIGGER_FAILURE(); } }
	 * if(pymtDtlAction.getCOMP_PD_PAY_MODE().equals("I") ||
	 * pymtDtlAction.getCOMP_PD_PAY_MODE().equals("CC") ||
	 * pymtDtlAction.getCOMP_PD_PAY_MODE().equals("C1") ||
	 * pymtDtlAction.getCOMP_PD_PAY_MODE().equals("C2") ||
	 * pymtDtlAction.getCOMP_PD_PAY_MODE().equals("C3") ||
	 * pymtDtlAction.getCOMP_PD_PAY_MODE().equals("C4") ||
	 * pymtDtlAction.getCOMP_PD_PAY_MODE().equals("C5") ||
	 * pymtDtlAction.getCOMP_PD_PAY_MODE().equals("C6") &&
	 * :PT_IL_PYMT_DTLS.M_EXP_DT != null) {
	 * :PT_IL_PYMT_DTLS.M_EXP_DT=(ConvertFunctions.to_char(:PT_IL_PYMT_DTLS.PD_CC_EXP_DT,"MM")+"/"+ConvertFunctions.to_char(:PT_IL_PYMT_DTLS.PD_CC_EXP_DT,"YYYY")); }
	 * else { :PT_IL_PYMT_DTLS.M_EXP_DT=null; } }catch(Exception e) {
	 * e.printStackTrace(); throw e; } finally { if(vembu_conn != null) {
	 * SwisSqlConnection.getInstance().closeConnection(vembu_conn); } } }
	 */
    }

    public void pilt017_pt_il_pymt_dtls_m_pd_cc_app_code_when_validate_item(
	    PT_IL_PYMT_DTLS_ACTION pymtDtlAction) throws SQLException,
	    Exception {
	PT_IL_PYMT_DTLS paymentDetailsBean = pymtDtlAction
		.getPT_IL_PYMT_DTLS_BEAN();
	try {
	    paymentDetailsBean.setUI_M_PD_CC_APP_CODE(StringFunctions.lPad(
		    (String) paymentDetailsBean.getUI_M_PD_CC_APP_CODE(), 6,
		    "0"));
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}

	/*
	 * try {
	 * 
	 * :PT_IL_PYMT_DTLS.M_PD_CC_APP_CODE=StringFunctions.lPad(:PT_IL_PYMT_DTLS.M_PD_CC_APP_CODE,6,"0");
	 * }catch(Exception e) { e.printStackTrace(); throw e; } finally {
	 * if(vembu_conn != null) {
	 * SwisSqlConnection.getInstance().closeConnection(vembu_conn); } } }
	 */

    }

    public void pilt017_pt_il_pymt_dtls_pd_sr_no_key_next_item(
	    PT_IL_PYMT_DTLS_ACTION pymtDtlAction) throws SQLException,
	    Exception {

	PT_IL_PYMT_DTLS paymentDetailsBean = pymtDtlAction
		.getPT_IL_PYMT_DTLS_BEAN();
	try {
	    if (paymentDetailsBean.getPD_SR_NO() != 0) {
		if (paymentDetailsBean.getPD_SR_NO() < 1) {
		    throw new Exception(Messages.getString(
			    PELConstants.pelErrorMessagePath, "91003",
			    new Object[] { CommonUtils
				    .getGlobalVariable("GLOBAL.M_LANG_CODE") }));

		}
	    }
	    if ("D".equals(paymentDetailsBean.getPD_PAID_FOR())) {
		paymentDetailsBean.setUI_M_PD_DEP_AMT(paymentDetailsBean
			.getPD_LC_AMT());
		paymentDetailsBean.setUI_M_PD_OTH_AMT(00.00);
	    } else {
		paymentDetailsBean.setUI_M_PD_OTH_AMT(paymentDetailsBean
			.getPD_LC_AMT());
		paymentDetailsBean.setUI_M_PD_DEP_AMT(00.00);

	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
    }

    public void pilt017_pt_il_pymt_dtls_pd_bank_name_key_next_item(
	    PT_IL_PYMT_DTLS_ACTION pymtDtlAction) throws SQLException,
	    Exception {

	PT_IL_PYMT_DTLS paymentDetailsBean = pymtDtlAction
		.getPT_IL_PYMT_DTLS_BEAN();
	String PD_PAY_MODE = paymentDetailsBean.getPD_PAY_MODE();
	try {
	    String condition = " C D L H O SD ";
	    if (condition.contains(" " + PD_PAY_MODE + " ")) {
		L_DUP_CHQ_NO(pymtDtlAction);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
    }

    public void pilt017_pt_il_pymt_dtls_pd_bank_name_when_validate_item(
	    PT_IL_PYMT_DTLS_ACTION pymtDtlAction) throws SQLException,
	    Exception {

	PT_IL_PYMT_DTLS paymentDetailsBean = pymtDtlAction
		.getPT_IL_PYMT_DTLS_BEAN();

	String PD_BANK_NAME = paymentDetailsBean.getPD_BANK_NAME();
	// String condition = " C D L H O SD ";
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	String PD_PAY_MODE = paymentDetailsBean.getPD_PAY_MODE();
	ResultSet bankDtl = null;
	try {
			connection = CommonUtils.getConnection();
			String C1 = SqlConstants.BANK_DTL_QRY;
			Object[] values = { CommonUtils.getControlBean().getM_LANG_CODE(),
					PD_BANK_NAME };

			if (PD_BANK_NAME != null) {
				bankDtl = handler.executeSelectStatement(C1,
						connection, values);
				if (bankDtl.next()) {
					paymentDetailsBean.setUI_M_BANK_NAME_DESC(bankDtl
							.getString(1));
					paymentDetailsBean.setPD_BRANCH_NAME(bankDtl.getString(1));
				} else {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "Invalid Bank . Please re-enter.." }));
				}
				// bankDtl.close();
			} else {
				paymentDetailsBean.setUI_M_BANK_NAME_DESC(null);
			}
			/*
			 * if (condition.contains(" " + PD_PAY_MODE + " ")) {
			 * L_DUP_CHQ_NO(pymtDtlAction); }
			 */
		} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	} finally {
	    try {
		CommonUtils.closeCursor(bankDtl);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void pd_chq_dt_when_validate_item(PT_IL_PYMT_DTLS pt_il_pymt_dtls)
	    throws SQLException, Exception {

	String M_CODE_DESCRIPTION = null;
	int M_TEMP_VAL = 0;
	DBProcedures procedures = new DBProcedures();
	ArrayList<String> pValList = new ArrayList<String>();

	try {
	    if (pt_il_pymt_dtls.getPD_CHQ_DT() != null) {
		if (pt_il_pymt_dtls.getPD_CHQ_DT().after(
			ConvertFunctions.to_date("31/12/2999", "DD/MM/RRRR"))) {
		    throw new Exception(Messages.getString(
			    PELConstants.pelErrorMessagePath, "91063",
			    new Object[] { CommonUtils
				    .getGlobalVariable("GLOBAL.M_LANG_CODE") }));
		}

		if (pt_il_pymt_dtls.getPD_CHQ_DT().after(
			new CommonUtils().getCurrentDate())) {
		    pValList = procedures.P_VAL_SYSTEM("IL_PDC_DAYS",
			    "IL_PDC_DAYS", M_CODE_DESCRIPTION, "N", CommonUtils
				    .getProcedureValue(M_TEMP_VAL));
		    if (pValList != null && !pValList.isEmpty()) {
			M_CODE_DESCRIPTION = pValList.get(0);
			if (pValList.get(1) != null)
			    M_TEMP_VAL = Integer.parseInt(pValList.get(1));
		    }
		    if (CommonUtils.subtractDate(
			    pt_il_pymt_dtls.getPD_CHQ_DT(), new CommonUtils()
				    .getCurrentDate()) > CommonUtils.nvl(
			    M_TEMP_VAL, 0)) {
			throw new Exception(Messages.getString(
				PELConstants.pelErrorMessagePath, "91385",
				new Object[] {
				// CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
				M_TEMP_VAL }));
		    }
		    pValList = new ArrayList<String>();
		    pValList = procedures.P_VAL_SYSTEM("PDC_ALT_DAYS",
			    "PDC_ALT_DAYS", M_CODE_DESCRIPTION, "N",
			    CommonUtils.getProcedureValue(M_TEMP_VAL));
		    if (pValList != null && !pValList.isEmpty()) {
			M_CODE_DESCRIPTION = pValList.get(0);
			if (pValList.get(1) != null)
			    M_TEMP_VAL = Integer.parseInt(pValList.get(1));
		    }

		    if (CommonUtils.subtractDate(
			    pt_il_pymt_dtls.getPD_CHQ_DT(), new CommonUtils()
				    .getCurrentDate()) > CommonUtils.nvl(
			    M_TEMP_VAL, 0)) {
			throw new Exception(Messages.getString(
				PELConstants.pelErrorMessagePath, "91385",
				new Object[] {
				// CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
				M_TEMP_VAL }));
		    }
		    CommonUtils.setGlobalVariable("GLOBAL.DEP_PDC_FLAG", "Y");
		} else if (pt_il_pymt_dtls.getPD_CHQ_DT().before(
			new CommonUtils().getCurrentDate())) {
		    pValList = new ArrayList<String>();
		    pValList = procedures.P_VAL_SYSTEM("IL_PRC_DAYS",
			    "IL_PRC_DAYS", M_CODE_DESCRIPTION, "N", CommonUtils
				    .getProcedureValue(M_TEMP_VAL));
		    if (pValList != null && !pValList.isEmpty()) {
			M_CODE_DESCRIPTION = pValList.get(0);
			if (pValList.get(1) != null)
			    M_TEMP_VAL = Integer.parseInt(pValList.get(1));
		    }
		    if (CommonUtils.subtractDate(new CommonUtils()
			    .getCurrentDate(), pt_il_pymt_dtls.getPD_CHQ_DT()) > CommonUtils
			    .nvl(M_TEMP_VAL, 0)) {
			throw new Exception(Messages.getString(
				PELConstants.pelErrorMessagePath, "91386",
				new Object[] {
				// CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
				M_TEMP_VAL }));
		    }
		    pValList = new ArrayList<String>();
		    pValList = procedures.P_VAL_SYSTEM("PRC_ALT_DAYS",
			    "PRC_ALT_DAYS", M_CODE_DESCRIPTION, "N",
			    CommonUtils.getProcedureValue(M_TEMP_VAL));
		    if (pValList != null && !pValList.isEmpty()) {
			M_CODE_DESCRIPTION = pValList.get(0);
			if (pValList.get(1) != null)
			    M_TEMP_VAL = Integer.parseInt(pValList.get(1));
		    }
		    if (CommonUtils.subtractDate(new CommonUtils()
			    .getCurrentDate(), pt_il_pymt_dtls.getPD_CHQ_DT()) > CommonUtils
			    .nvl(M_TEMP_VAL, 0)) {
			throw new Exception(Messages.getString(
				PELConstants.pelErrorMessagePath, "91386",
				new Object[] {
				// CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
				M_TEMP_VAL }));
		    }
		    CommonUtils.setGlobalVariable("GLOBAL.DEP_PDC_FLAG", "N");
		} else {
		    CommonUtils.setGlobalVariable("GLOBAL.DEP_PDC_FLAG", "N");
		}
	    } else {

		CommonUtils.setGlobalVariable("GLOBAL.DEP_PDC_FLAG", "N");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    // Modified by Kavitha 22 Sep 11 P_VAL_ROUND_AMT added

    public void pilt017pt_il_pymt_dtls_pd_fc_amt_when_validate_item(
    		PT_IL_PYMT_DTLS_ACTION pymtDtlAction) throws  Exception {
	PT_IL_PYMT_DTLS paymentDetailsBean = pymtDtlAction
		.getPT_IL_PYMT_DTLS_BEAN();
	String PD_PAY_MODE = paymentDetailsBean.getPD_PAY_MODE();
	
	try {
	    if (paymentDetailsBean.getPD_FC_AMT() != null) {
		if (paymentDetailsBean.getPD_FC_AMT() <= 0) {
		    throw new Exception("Value should be Greater then 0.");

		}
	    }
	    if (paymentDetailsBean.getUI_M_PD_TOTAL_AMT() != null) {
		if (paymentDetailsBean.getUI_M_PD_TOTAL_AMT() > (Double) CommonUtils.getGlobalObject("GLOBAL.FC_AMT")) {
		    throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91070"));
		}
	    }
	    
	    paymentDetailsBean.setPD_LC_AMT(paymentDetailsBean.getPD_FC_AMT() *  (Double)CommonUtils .getGlobalObject("GLOBAL.EXCH_RATE"));
	    if ("PM".equals(PD_PAY_MODE)) {
		paymentDetailsBean.setPD_REM_AMT(paymentDetailsBean.getPD_LC_AMT());
	    } else {
		paymentDetailsBean.setPD_REM_AMT(null);
	    }
	    if ("D".equals(paymentDetailsBean.getPD_PAID_FOR())) {
		paymentDetailsBean.setUI_M_PD_DEP_AMT(paymentDetailsBean.getPD_LC_AMT());
		paymentDetailsBean.setUI_M_PD_OTH_AMT(0.0);
	    } else {
		paymentDetailsBean.setUI_M_PD_OTH_AMT(paymentDetailsBean.getPD_LC_AMT());
		paymentDetailsBean.setUI_M_PD_DEP_AMT(0.0);
	    }

	    /*Added by Janani on 09.06.2018 for FSD_IL_FLA_019 */
	    Double lc_amt = 0.0;
		
	    Double exch_rate = paymentDetailsBean.getPD_EXCH_RATE();
	    
	    lc_amt = CommonUtils.nvl(paymentDetailsBean.getPD_FC_AMT(), 0.0) / exch_rate ;
	    
	    System.out.println("lc_amt              "+lc_amt+"      getPD_TXN_SYS_ID       "+paymentDetailsBean.getPD_TXN_SYS_ID());
	    
	    paymentDetailsBean.setPD_LC_AMT(lc_amt);
	    /*End*/
	    
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
    }

    // Modified by Kavitha 22 Sep 11 P_VAL_ROUND_AMT,P_VAL_FC_LC_TOLERANCE added
    public void pilt017_pt_il_pymt_dtls_pd_lc_amt_when_validate_item(
	    PT_IL_PYMT_DTLS_ACTION paymentAction, DUMMY_ACTION dummy_action)
	    throws  Exception {

	PT_IL_PYMT_DTLS paymentDetailsBean = paymentAction.getPT_IL_PYMT_DTLS_BEAN();
	DUMMY dummy = dummy_action.getDUMMY_BEAN();
	try {
	    if (paymentDetailsBean.getPD_LC_AMT() != null) {
		if (paymentDetailsBean.getPD_LC_AMT() <= 0) {
		    throw new Exception("Value should be Greater then 0.");
		}
	    }
	    
	    new LIFELIB().P_VAL_FC_LC_TOLERANCE(CommonUtils.getProcedureValue(paymentDetailsBean.getPD_FC_AMT()),
			    CommonUtils.getProcedureValue(paymentDetailsBean.getPD_LC_AMT()),
			    CommonUtils.getGlobalObject("GLOBAL.EXCH_RATE").toString(),"E");

	    if ("D".equals(paymentDetailsBean.getPD_PAID_FOR())) {
		paymentDetailsBean.setUI_M_PD_DEP_AMT(paymentDetailsBean
			.getPD_LC_AMT());
		paymentDetailsBean.setUI_M_PD_OTH_AMT(0.0);
	    } else {
		paymentDetailsBean.setUI_M_PD_OTH_AMT(paymentDetailsBean
			.getPD_LC_AMT());
		paymentDetailsBean.setUI_M_PD_DEP_AMT(0.0);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
    }

    // Modified by Kavitha using rowIndex is removed
    public void pilt017_pt_il_pymt_dtls_pd_paid_for_when_list_changed(
	    PT_IL_PYMT_DTLS_ACTION paymentAction) throws SQLException,
	    Exception {
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	String G_DEP_REF_NO = CommonUtils
		.getGlobalVariable("GLOBAL.G_DEP_REF_NO");

	PT_IL_PYMT_DTLS paymentDetailsBean = paymentAction
		.getPT_IL_PYMT_DTLS_BEAN();
	ResultSet topUpDtlRS = null;
	ResultSet lcAmtDtlRS = null;
	ResultSet polYrsPrmDtlRS = null;
	String M_PROD_TOPUP_YN = null;
	String M_PROD_TOPUP_MIN_YRS = null;
	double M_PROD_TOPUP_MULTIPLE = 0d;
	double M_POL_NO_YRS_PREM_PAID = 0d;
	String M_POL_MODE_OF_PYMT = null;
	double M_PTP_LC_MAX_AMT = 0d;
	double M_PTP_LC_MIN_AMT = 0d;

	double M_TEMP = -1;
	double M_TEMP_1 = -1;
	String M_TEMP3 = null;

	try {
	    connection = CommonUtils.getConnection();

	    String lcAmtQry = SqlConstants.LC_AMT_CHK;
	    Object[] objDepRfNo = { G_DEP_REF_NO };

	    String topUpQryQry = SqlConstants.TOP_UP_CHK;

	    String polYrsPrmPaid = SqlConstants.POL_YRS_PRM_PAID;

	    if (G_DEP_REF_NO != null) {
		if (CommonUtils.nvl((String) CommonUtils.getGlobalObject("GLOBAL.TXN_TYPE"), "Q").equals("Q")) {
		    paymentDetailsBean.setPD_PAID_FOR("D");
		}
		if (CommonUtils.nvl(paymentDetailsBean.getPD_PAID_FOR(), "X").equals("T")) {
		    /*
		     * if(topUpDtlRS!=null){ topUpDtlRS.close(); }
		     */
		    topUpDtlRS = handler.executeSelectStatement(topUpQryQry,
			    connection, objDepRfNo);
		    if (topUpDtlRS.next()) {
			M_PROD_TOPUP_YN = topUpDtlRS.getString(1);
			M_PROD_TOPUP_MIN_YRS = topUpDtlRS.getString(2);
			M_PROD_TOPUP_MULTIPLE = topUpDtlRS.getDouble(3);

		    }
		    CommonUtils.closeCursor(topUpDtlRS);
		    if (CommonUtils.nvl(M_PROD_TOPUP_YN, "N") != "Y") {
			paymentDetailsBean.setPD_PAID_FOR("D");
			paymentDetailsBean
				.setUI_M_PD_DEP_AMT(paymentDetailsBean
					.getPD_LC_AMT());
			paymentDetailsBean.setUI_M_PD_OTH_AMT(0.0);
			throw new ValidatorException(
				Messages
					.getMessage(
						PELConstants.pelErrorMessagePath,
						"3206",
						new Object[] { "Top Up Not Applicable for this Reference No" }));
		    }

		    CommonUtils.closeCursor(polYrsPrmDtlRS);
		    polYrsPrmDtlRS = handler.executeSelectStatement(
			    polYrsPrmPaid, connection, objDepRfNo);
		    if (polYrsPrmDtlRS.next()) {
			M_POL_NO_YRS_PREM_PAID = polYrsPrmDtlRS.getDouble(1);
			M_POL_MODE_OF_PYMT = polYrsPrmDtlRS.getString(2);
		    }
		    CommonUtils.closeCursor(polYrsPrmDtlRS);

		    lcAmtDtlRS = handler.executeSelectStatement(lcAmtQry,
			    connection, objDepRfNo);
		    if (lcAmtDtlRS.next()) {
			M_PTP_LC_MIN_AMT = lcAmtDtlRS.getDouble(1);
			M_PTP_LC_MAX_AMT = lcAmtDtlRS.getDouble(2);
		    }

		    if (CommonUtils.nvl(paymentDetailsBean.getPD_LC_AMT(), 0) > M_PTP_LC_MAX_AMT) {
			paymentDetailsBean.setPD_PAID_FOR("D");
			paymentDetailsBean
				.setUI_M_PD_DEP_AMT(paymentDetailsBean
					.getPD_LC_AMT());
			paymentDetailsBean.setUI_M_PD_OTH_AMT(0d);
			throw new ValidatorException(
				Messages
					.getMessage(
						PELConstants.pelErrorMessagePath,
						"3206",
						new Object[] { "Top-up Amount is greater then Top-up maximum Amount." }));

		    } else if (CommonUtils.nvl(paymentDetailsBean
			    .getPD_LC_AMT(), 0) < M_PTP_LC_MIN_AMT) {
			paymentDetailsBean.setPD_PAID_FOR("D");
			paymentDetailsBean
				.setUI_M_PD_DEP_AMT(paymentDetailsBean
					.getPD_LC_AMT());
			paymentDetailsBean.setUI_M_PD_OTH_AMT(0d);
			throw new ValidatorException(
				Messages
					.getMessage(
						PELConstants.pelErrorMessagePath,
						"3206",
						new Object[] { "Top-up Amount is less then Top-up minimum Amount." }));
		    }

		    if (M_PROD_TOPUP_MULTIPLE > 0) {
			if ((CommonUtils.nvl(paymentDetailsBean.getPD_LC_AMT(),
				0) % M_PROD_TOPUP_MULTIPLE) != 0) {
			    paymentDetailsBean.setPD_PAID_FOR("D");
			    throw new ValidatorException(Messages.getMessage(
				    PELConstants.pelErrorMessagePath, "3206",
				    new Object[] { "Top up amount "
					    + paymentDetailsBean.getPD_LC_AMT()
					    + " should be multiple of "
					    + M_PROD_TOPUP_MULTIPLE }));
			}
		    }

		}
		if ("D".equals(paymentDetailsBean.getPD_PAID_FOR())) {
		    paymentDetailsBean.setUI_M_PD_DEP_AMT(paymentDetailsBean
			    .getPD_LC_AMT());
		    paymentDetailsBean.setUI_M_PD_OTH_AMT(0.0);
		} else {
		    paymentDetailsBean.setUI_M_PD_OTH_AMT(paymentDetailsBean
			    .getPD_LC_AMT());
		    paymentDetailsBean.setUI_M_PD_DEP_AMT(0.0);
		}
	    }
	} catch (Exception e) {

	    throw new Exception(e.getMessage());
	} finally {
	    try {
		CommonUtils.closeCursor(topUpDtlRS);
	    } catch (Exception e) {
	    }
	    try {
		CommonUtils.closeCursor(lcAmtDtlRS);
	    } catch (Exception e) {
	    }
	    try {
		CommonUtils.closeCursor(polYrsPrmDtlRS);
	    } catch (Exception e) {
	    }
	}

    }

    private Boolean  Status;
    
    public void pilt017_pt_il_pymt_dtls_when_new_record_instance(
	    PT_IL_PYMT_DTLS_ACTION paymentAction) throws Exception {

	PT_IL_PYMT_DTLS_DB_CLASS dbClass = new PT_IL_PYMT_DTLS_DB_CLASS();
	PT_IL_PYMT_DTLS paymentDetailsBean = paymentAction.getPT_IL_PYMT_DTLS_BEAN();
	String PD_PAY_MODE = paymentDetailsBean.getPD_PAY_MODE();
	DBProcedures procedures = new DBProcedures();
	Connection con = null;
	CRUDHandler handler = new CRUDHandler();
	String condition1 = " C D L H O SD ";
	String condition2 = " I CC C1 C2 C3 C4 C5 C6 ";
	ResultSet resSetPayMode = null;
	ResultSet resSetCustPerc = null;
	try {
	    con = CommonUtils.getConnection();
	    int M_PS_VALUE = 0;
	    String M_CODE_DESC = null;
	    String M_DUMMY = null;
	    String TXN_TYPE = null;
	    Long TXN_SYS_ID = null;
	    String retreivePayModeQry = SqlConstants.RETRIEVE_PAY_MODE;
	    if ("PILT003_APAC".equalsIgnoreCase((String) CommonUtils
				.getGlobalObject("CALLING_FORM"))) {
	    	TXN_TYPE ="PC";
	    	TXN_SYS_ID =(Long) CommonUtils
			.getGlobalObject("G_PC_SYS_ID") ;
	    }else{
	     TXN_TYPE = (String)CommonUtils.getGlobalObject("GLOBAL.TXN_TYPE");
	     TXN_SYS_ID = (Long)CommonUtils.getGlobalObject("GLOBAL.TXN_SYS_ID");
	    }
	    String DEP_REF_NO =(String) CommonUtils.getGlobalObject("GLOBAL.G_DEP_REF_NO");
	    Double DEP_LC_TOTAL_AMT  = (Double) CommonUtils.getGlobalObject("GLOBAL.FC_AMT");
	    Double DEP_FC_TOTAL_AMT = (Double)CommonUtils.getGlobalObject("GLOBAL.LC_AMT");
	    String CURRENCY_CODE = (String)CommonUtils.getGlobalObject("GLOBAL.CURR_CODE");
	    Double EXCHANGE_RATE = (Double)CommonUtils.getGlobalObject("GLOBAL.EXCH_RATE");
	    
	    paymentDetailsBean.setPD_TXN_SYS_ID(TXN_SYS_ID);
	    paymentDetailsBean.setPD_TXN_TYPE(TXN_TYPE);
	    paymentDetailsBean.setPD_TT_CURR_CODE(CURRENCY_CODE);
	 //   paymentDetailsBean.setPD_LC_AMT(DEP_FC_TOTAL_AMT);
	    Status = (Boolean)CommonUtils.getGlobalObject("APPROVAL_STATUS");
	    Object[] objPayMode = { paymentDetailsBean.getPD_TXN_SYS_ID(),paymentDetailsBean.getPD_TXN_TYPE() };
	    
	    Object[] objCustSharePerc = { paymentDetailsBean.getPD_PAY_MODE() };
	    Double M_BCSH_CUST_SHARE_PERC_1 = 0.0;
	    ArrayList list = procedures.P_VAL_SYSTEM("IL_MUL_PAY", "IL_MUL_PAY","E",null,null);
	    M_PS_VALUE = Integer.parseInt(list.get(1).toString());
	    M_CODE_DESC = (String) list.get(0);
	    

	    if (M_PS_VALUE == 2) {
	    	String Query = "SELECT PD_PAY_MODE FROM PT_IL_PYMT_DTLS WHERE  PD_TXN_SYS_ID = ? AND PD_TXN_TYPE = ?";
	    	resSetPayMode = handler.executeSelectStatement(Query, con, objPayMode);
	    	if (resSetPayMode.next()) {
	    		M_DUMMY = resSetPayMode.getString(1);
	    		paymentDetailsBean.setPD_PAY_MODE(M_DUMMY);
	    	}
		CommonUtils.closeCursor(resSetPayMode);
		String retreiveCustPercQry = "SELECT BCSH_CUST_SHARE_PERC FROM  PM_BANK_CHARGE_SETUP_HDR  WHERE  BCSH_PAY_MODE  = ? ";
		resSetCustPerc = handler.executeSelectStatement(retreiveCustPercQry, con, objCustSharePerc);
	    if (resSetCustPerc.next()) {
		M_BCSH_CUST_SHARE_PERC_1 = resSetCustPerc.getDouble(1);
	    }
	    CommonUtils.closeCursor(resSetCustPerc);
	    String condition = " L I E TT PM AD A C2 C4 C6 D H CC SD BC EF SC C1 C3 C5 P C ";
	    
	    if ("P".equals(PD_PAY_MODE)) {
	    	paymentAction.getCOMP_PD_CHQ_NO().setDisabled(true);
	    	paymentAction.getCOMP_PD_CHQ_DT().setDisabled(true);
	    	paymentAction.getCOMP_PD_BANK_NAME().setDisabled(true);
	    	paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
	    	paymentAction.getCOMP_PD_CC_TYPE().setDisabled(true);
	    	paymentAction.getCOMP_PD_CC_NO().setDisabled(true);
	    	paymentAction.getCOMP_PD_CC_NAME().setDisabled(true);
	    	paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
	    	paymentAction.getCOMP_PD_CHQ_NO().setRequired(false);
	    	paymentAction.getCOMP_PD_CHQ_DT().setRequired(false);
	    	paymentAction.getCOMP_PD_BANK_NAME().setRequired(false);
	    	paymentAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
	    	paymentAction.getCOMP_PD_CC_TYPE().setRequired(false);
	    	paymentAction.getCOMP_PD_CC_NO().setRequired(false);
	    	paymentAction.getCOMP_PD_CC_NAME().setRequired(false);
	    	paymentAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
	    	paymentAction.getCOMP_UI_M_EXP_DT().setRequired(false);
	    	paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
	    	paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
	    	paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
	    	paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
	    	paymentAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
	    	paymentAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
	    	paymentAction.getCOMP_PD_TT_REF_NO().setRequired(false);
	    	paymentAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
	    	paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
	    	paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
	    	paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
	    	paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
	    	paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
	    	paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
	    	paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
	    	paymentAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
	    	paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
	    	paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
	    	paymentAction.getCOMP_PD_REM_AMT().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
	    	paymentAction.getCOMP_PD_PO_MO_NO().setRequired(false);
	    	paymentAction.getCOMP_PD_PO_MO_DT().setRequired(false);
	    	paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
	    	paymentAction.getCOMP_PD_REM_AMT().setRequired(false);
	    	paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
	    	paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
	    	paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
	    	paymentAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
	    	paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
	    	paymentAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
	    	paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1()
	    	.setRequired(false);
	    	paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
	    	paymentAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
	    	paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
	    	paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
	    	paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2()
	    	.setRequired(false);
	    	paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
	    	paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
	    	paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
	    	paymentAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
	    	

	    } else if (condition1.contains(" " + PD_PAY_MODE + " ")) {

		//paymentAction.getCOMP_PD_CHQ_NO().setDisabled(false);
		paymentAction.getCOMP_PD_CHQ_DT().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(false); //
		//paymentAction.getCOMP_PD_CHQ_NO().setDisabled(false);
		paymentAction.getCOMP_PD_CHQ_DT().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		//paymentAction.getCOMP_PD_CHQ_NO().setReadonly(false);
		paymentAction.getCOMP_PD_CHQ_DT().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		paymentAction.getCOMP_PD_CHQ_NO().setRequired(true);
		paymentAction.getCOMP_PD_CHQ_DT().setRequired(false);
		paymentAction.getCOMP_PD_BANK_NAME().setRequired(true);
		paymentAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		paymentAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_PD_CC_NAME().setRequired(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_PD_REM_AMT().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
	    } else if (condition2.contains(" " + PD_PAY_MODE + " ")) {

		paymentAction.getCOMP_PD_CC_TYPE().setDisabled(false);
		paymentAction.getCOMP_PD_CC_NO().setDisabled(false);
		paymentAction.getCOMP_PD_CC_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(false);
		paymentAction.getCOMP_PD_CC_TYPE().setDisabled(false);
		paymentAction.getCOMP_PD_CC_NO().setDisabled(false);
		paymentAction.getCOMP_PD_CC_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(false);
		paymentAction.getCOMP_PD_CC_NO().setReadonly(false);
		paymentAction.getCOMP_PD_CC_NAME().setReadonly(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setReadonly(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(false);
		paymentAction.getCOMP_PD_CC_TYPE().setRequired(true);
		paymentAction.getCOMP_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		paymentAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_CHQ_DT().setRequired(false);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_NAME().setRequired(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_PD_REM_AMT().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);

	    } else if ("TT".equals(PD_PAY_MODE)) {

		paymentAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_CHQ_DT().setRequired(false);
		paymentAction.getCOMP_PD_BANK_NAME().setRequired(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		paymentAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_PD_CC_NAME().setRequired(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(true);
		paymentAction.getCOMP_PD_TT_REF_NO().setRequired(true);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setRequired(true);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_PD_REM_AMT().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
	    } else if ("BC".equals(PD_PAY_MODE)) {
		paymentAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_CHQ_DT().setRequired(false);
		paymentAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_PD_CC_NAME().setRequired(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(true);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(true);
		paymentAction.getCOMP_UI_M_CHQ_NO().setRequired(true);
		paymentAction.getCOMP_PD_BANK_NAME().setRequired(true);
		paymentAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_PD_REM_AMT().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
	    } else if ("PM".equals(PD_PAY_MODE)) {
		paymentAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_CHQ_DT().setRequired(false);
		paymentAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_PD_CC_NAME().setRequired(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_BANK_NAME().setRequired(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(false);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setRequired(true);
		paymentAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(true);
		paymentAction.getCOMP_PD_REM_AMT().setRequired(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(true);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(false);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(false);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
	    }
	    if ("EF".equals(PD_PAY_MODE)) {
		paymentAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_CHQ_DT().setRequired(false);
		paymentAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_PD_CC_NAME().setRequired(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_PD_REM_AMT().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setRequired(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(true);
		paymentAction.getCOMP_PD_BANK_NAME().setRequired(true);
		paymentAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setReadonly(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setReadonly(false); //
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
	    } else if ("AD".equals(PD_PAY_MODE)) {

	    paymentAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_CHQ_DT().setRequired(false);
		paymentAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_PD_CC_NAME().setRequired(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_PD_REM_AMT().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setRequired(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(true);
		paymentAction.getCOMP_PD_BANK_NAME().setRequired(true);
		paymentAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setReadonly(false);
		paymentAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setReadonly(false);
		paymentAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
	    } else if ("SC".equals(PD_PAY_MODE)) {
	    paymentAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_CHQ_DT().setRequired(false);
		paymentAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_PD_CC_NAME().setRequired(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_PD_REM_AMT().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_PD_BANK_NAME().setRequired(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(false);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(true);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setRequired(true);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(true);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setReadonly(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setReadonly(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setReadonly(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
	    } else if ("A".equals(PD_PAY_MODE)) {
	    	paymentAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_CHQ_DT().setRequired(false);
		paymentAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_PD_CC_NAME().setRequired(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_PD_REM_AMT().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setReadonly(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setReadonly(false);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setRequired(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setRequired(false);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);

	    } else if ("E".equals(PD_PAY_MODE)) {

		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(false);

		paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(true);
		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(true);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(false);
		paymentDetailsBean.setPD_PAYIN_DATE(new CommonUtils().getCurrentDate());
		paymentAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_PD_CC_NAME().setRequired(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_EXP_DT().setRequired(false);
		paymentAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_CHQ_DT().setRequired(false);
		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BANK_NAME().setRequired(true);
		paymentAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		paymentAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_PD_REM_AMT().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
	    } else if ("DP".equals(PD_PAY_MODE)) {
	    paymentAction.getCOMP_PD_CHQ_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NAME().setDisabled(true);
		paymentAction.getCOMP_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_EXP_DT().setDisabled(true);
		paymentAction.getCOMP_PD_CC_NAME().setRequired(false);
		paymentAction.getCOMP_PD_CC_APP_CODE().setRequired(false);

		paymentAction.getCOMP_PD_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_PD_TT_REF_NO().setDisabled(true);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_NAME().setDisabled(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setDisabled(false);
		// paymentAction.getCOMP_PD_BANK_NAME",NAVIGABLE,PROPERTY_TRUE);
		// paymentAction.getCOMP_PD_BRANCH_NAME",NAVIGABLE,PROPERTY_TRUE);
		paymentAction.getCOMP_PD_BANK_NAME().setRequired(true);
		paymentAction.getCOMP_PD_BRANCH_NAME().setRequired(true);
		paymentAction.getCOMP_PD_BANK_NAME().setReadonly(false);
		paymentAction.getCOMP_PD_BRANCH_NAME().setReadonly(false);
		paymentAction.getCOMP_PD_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_PD_TT_REF_NO().setRequired(false);
		paymentAction.getCOMP_PD_TT_CURR_CODE().setRequired(false);
		//paymentAction.getCOMP_PD_DPD_REF_ID().setDisabled(false);
	//	paymentAction.getCOMP_PD_DPD_REF_ID().setRequired(true);
		// paymentAction.getCOMP_UI_M_BUT_LOV_DPD_REF_ID().setDisabled(false);
		paymentAction.getCOMP_PD_PAYIN_DATE().setDisabled(true);
		paymentAction.getCOMP_PD_PAYIN_DATE().setRequired(false);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setDisabled(true);
		paymentAction.getCOMP_PD_CR_ADVICE_NO().setRequired(false);

		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setDisabled(true);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_UI_M_CHQ_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE().setRequired(false);
		paymentAction.getCOMP_PD_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_UI_M_CHQ_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_NO().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_DT().setDisabled(true);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setDisabled(true);
		paymentAction.getCOMP_PD_REM_AMT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setDisabled(true);
		paymentAction.getCOMP_PD_PO_MO_NO().setRequired(false);
		paymentAction.getCOMP_PD_PO_MO_DT().setRequired(false);
		paymentAction.getCOMP_UI_M_REM_SLIP_GEN_YN().setRequired(false);
		paymentAction.getCOMP_PD_REM_AMT().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_1().setRequired(false);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setDisabled(true);
		paymentAction.getCOMP_PD_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setDisabled(true);
		paymentAction.getCOMP_UI_M_OUR_BANK_CODE_2().setRequired(false);
		paymentAction.getCOMP_PD_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_1()
			.setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setDisabled(true);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_PD_CC_TYPE().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_NO().setRequired(false);
		paymentAction.getCOMP_UI_M_PD_CC_APP_CODE().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_1().setRequired(false);
		paymentAction.getCOMP_UI_M_DATE_OF_CREDIT_2().setRequired(false);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setDisabled(true);
		paymentAction.getCOMP_UI_M_BANK_REF_NO_2().setRequired(false);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setDisabled(true);
		paymentAction.getCOMP_PD_ATM_CARD_NO().setRequired(false);
	    }
	    }

	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	} finally {
	    try {
		CommonUtils.closeCursor(resSetPayMode);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    try {
		CommonUtils.closeCursor(resSetCustPerc);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void pilt017_pt_il_pymt_dtls_when_create_record(
	    PT_IL_PYMT_DTLS paymentDetailBean,
	    PT_IL_PYMT_DTLS_ACTION paymentDetailAction,DUMMY dummy) throws Exception {
	Double M_PD_FC_AMT = null;
	Double M_PD_LC_AMT = null;
	String M_PS_VALUE = null;
	String M_CODE_DESC = null;
	String M_DUMMY = null;
	String selectQuery = PILT017_QUERY_CONSTANTS.PILT017_PT_IL_PYMT_DTLS_WHEN_CREATE_RECORD;
	ResultSet rst = null;
	CRUDHandler handler = null;
	Connection con = null;
	CommonUtils commonUtils = new CommonUtils();
	DBProcedures procCall = new DBProcedures();
	PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
 
	Double FC_AMT = null;
	Double LC_AMT = null;
	Double EXCH_RATE = null;
	String PD_PAID_FOR = null;
	String M_PD_CURR_CODE_DESC;
	String BASE_CURR_CODE;
	Double M_PD_TOTAL_AMT;
	// Double PD_TXN_SYS_ID ;
	Double PD_LC_AMT;
	Double PD_FC_AMT;
	String TXN_TYPE=null;
	String PD_PAYIN_DATE = null;
	try {
	    con = CommonUtils.getConnection();
	    if (con != null) {
		handler = new CRUDHandler();
		 
		if(CommonUtils.getGlobalObject("GLOBAL.FC_AMT") !=null){
			
			FC_AMT = (Double)CommonUtils.getGlobalObject("GLOBAL.FC_AMT");
		}
			
		if(CommonUtils.getGlobalObject("GLOBAL.LC_AMT") !=null)

		    LC_AMT = (Double)CommonUtils.getGlobalObject("GLOBAL.LC_AMT");
		 if(CommonUtils.getGlobalObject("GLOBAL.EXCH_RATE") !=null)//{
			EXCH_RATE = (Double)CommonUtils.getGlobalObject("GLOBAL.EXCH_RATE");
		//}
			CommonUtils.setGlobalObject("GLOBAL.LC_AMT",LC_AMT);
		//if(CommonUtils.getGlobalObject("GLOBAL.EXCH_RATE") !=null)
		  //  EXCH_RATE = Double.parseDouble((String)CommonUtils.getGlobalObject("GLOBAL.EXCH_RATE")); 


		// if(rst.next()){
		paymentDetailBean.setPD_PAID_FOR("D");
		paymentDetailBean.setPD_TXN_TYPE((String)CommonUtils.getGlobalObject("GLOBAL.TXN_TYPE"));
		if(CommonUtils.getGlobalObject("GLOBAL.TXN_SYS_ID") !=null)
		    paymentDetailBean.setPD_TXN_SYS_ID((Long)(CommonUtils.getGlobalObject("GLOBAL.TXN_SYS_ID")));
		paymentDetailBean.setPD_CURR_CODE((String)CommonUtils.getGlobalObject("GLOBAL.CURR_CODE"));
        		M_PD_FC_AMT = java.lang.Math.abs( CommonUtils.nvl(FC_AMT ,0.0d));
        		M_PD_LC_AMT = java.lang.Math.abs(CommonUtils.nvl(LC_AMT,0.0d));
        		PD_PAID_FOR = paymentDetailBean.getPD_PAID_FOR();
        		
		if ("D".equals(PD_PAID_FOR)) {
		    paymentDetailBean.setUI_M_PD_DEP_AMT(paymentDetailBean.getPD_LC_AMT());
		    paymentDetailBean.setUI_M_PD_OTH_AMT(0.0);
		} else {
		    paymentDetailBean.setUI_M_PD_OTH_AMT(paymentDetailBean.getPD_LC_AMT());
		    paymentDetailBean.setUI_M_PD_DEP_AMT(0.0);
		}
		TXN_TYPE =(String)CommonUtils.getGlobalObject("GLOBAL.TXN_TYPE");
		if ("QD".equals(TXN_TYPE) || "PD".equals(TXN_TYPE)) {
		     paymentDetailAction.getCOMP_PD_DPD_REF_ID().setDisabled(true);
		    // paymentDetailAction.getCOMP_UI_M_BUT_LOV_DPD_REF_ID().setDisabled(true);
		}
		else{
		    //paymentDetailAction.getCOMP_PD_DPD_REF_ID().setDisabled(false);
		}
		if ("DR".equals(TXN_TYPE)) {
		    paymentDetailBean.setPD_PAY_MODE("DP");
		}
		else {
		    paymentDetailBean.setPD_PAY_MODE("P");
		}
	    }
		 
		if ( paymentDetailBean.getPD_PAYIN_DATE() == null) {
		    paymentDetailBean.setPD_PAYIN_DATE(commonUtils
			    .getCurrentSQLDate());
		}
		else{
		    paymentDetailBean.setPD_PAYIN_DATE( paymentDetailBean.getPD_PAYIN_DATE());
		    paymentDetailAction.getCOMP_PD_PAYIN_DATE().setDisabled( false);
		   //SET_ITEM_PROPERTY('PT_IL_PYMT_DTLS.PD_PAYIN_DATE',UPDATE_ALLOWED,PROPERTY_TRUE);   
		}
		paymentDetailBean.setPD_CC_TYPE("O");

		paymentDetailBean.setPD_CUST_NAME(dummy.getPD_CUST_NAME());
		paymentDetailBean.setPD_ADDR_01(dummy.getPD_ADDR_01());
		paymentDetailBean.setPD_ADDR_02(dummy.getPD_ADDR_02());
		paymentDetailBean.setPD_ADDR_03(dummy.getPD_ADDR_03());
		paymentDetailBean.setPD_REMARKS(dummy.getPD_REMARKS());
		if ( paymentDetailBean.getPD_CURR_CODE() != null) {
		   List pval= procCall.helperP_VAL_CURR(paymentDetailBean.getPD_CURR_CODE(),
			    paymentDetailBean.getUI_M_PD_CURR_CODE_DESC(), "N", "E", "");
		   if(pval.get(0)!=null) 
		       paymentDetailBean.setUI_M_PD_CURR_CODE_DESC(pval.get(0).toString());
		    // TODO NEED To Conform (Number Format Procedure)

		    // P_SET_FC_NUM_FMT_MASK
		}
		if (paymentDetailBean.getUI_M_PD_TOTAL_AMT() != null) {
		    if (paymentDetailBean.getUI_M_PD_TOTAL_AMT() == M_PD_FC_AMT) {
			throw new ValidatorException(Messages.getMessage(
				PELConstants.pelErrorMessagePath, "91066"));
		    }
		}
		if (paymentDetailBean.getUI_M_PD_TOTAL_AMT() != null) {
		    paymentDetailBean
			    .setPD_FC_AMT(M_PD_FC_AMT - paymentDetailBean.getUI_M_PD_TOTAL_AMT());
		} else {

		    paymentDetailBean.setPD_FC_AMT(M_PD_FC_AMT);
		}
		 List pvalList =  pkg_pilt002_apac.P_VAL_ROUND_AMT(paymentDetailBean.getPD_CURR_CODE(),
			    CommonUtils.getProcedureValue(paymentDetailBean.getPD_FC_AMT() )  , "V");
		 if(pvalList.get(0)!=null)
		      paymentDetailBean.setPD_FC_AMT(Double.parseDouble(pvalList.get(0).toString())); 
		    Double value = paymentDetailBean.getPD_FC_AMT() * CommonUtils.nvl(EXCH_RATE,0.0);
		    if (value == null) {
			value = 0.0;
		    }
		    paymentDetailBean.setPD_LC_AMT(value);
		 
		  ArrayList<String> pvalListlc =  pkg_pilt002_apac.P_VAL_ROUND_AMT(paymentDetailBean.getPD_CURR_CODE(),//dummy.getBASE_CURR_CODE(), 
			    commonUtils.getProcedureValue(paymentDetailBean.getPD_LC_AMT()), "R");
		  if(pvalListlc !=null)
		      paymentDetailBean.setPD_LC_AMT(Double.parseDouble(pvalListlc.get(0)));
		 
	    // }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} finally {
	    try {
		CommonUtils.closeCursor(rst);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    

    public void pilt017_pt_il_pymt_dtls_post_insert(
	    PT_IL_PYMT_DTLS paymentDetailBean) throws Exception {
	String M_NO =null;
	Connection connection = null;
	ResultSet resultSet = null;
	ResultSet rst = null;
	CRUDHandler handler = new CRUDHandler();
	Object[] values = null;
	String pymtModecondition = " CC C1 C2 C3 C4 C5 C6 ";
	String queryEncrypt = " SELECT F_CC_ENCRYPT(?,?,?,?) FROM DUAL ";
		try {
			connection = CommonUtils.getConnection();
		    String PD_PAY_MODE = paymentDetailBean.getPD_PAY_MODE();
		    if (pymtModecondition.contains(" " + PD_PAY_MODE + " ") && 
			    paymentDetailBean.getUI_M_PD_CC_NO_1() !=null &&
			    !"XXXXXXXXXXXX".equals(CommonUtils.SUBSTR(  paymentDetailBean.getUI_M_PD_CC_NO_1(),1,12))) {
		      
		        // M_NO:= F_CC_ENCRYPT(:PT_IL_PYMT_DTLS.M_PD_CC_NO_1,:PT_IL_PYMT_DTLS.PD_SYS_ID,'E',:PT_IL_PYMT_DTLS.); 
			values = new Object[] {
				paymentDetailBean.getUI_M_PD_CC_NO_1(),
				paymentDetailBean.getPD_SYS_ID(), "E",
				paymentDetailBean.getPD_PAY_MODE() };
			 resultSet = new CRUDHandler().executeSelectStatement(queryEncrypt,
					connection, values);
        			while (resultSet.next()) {
        			    M_NO = resultSet.getString(1);
        			}    
		    }
		    else if (pymtModecondition.contains(" " + PD_PAY_MODE + " ") && 
			    paymentDetailBean.getUI_M_PD_CC_NO_1()==null ){
		 
		        paymentDetailBean.setPD_CC_NO( null);
		        
		    }else if("I".equals(paymentDetailBean.getPD_PAY_MODE() )){
			values = new Object[] {
				paymentDetailBean.getUI_M_PD_CC_NO_1(),
				paymentDetailBean.getPD_SYS_ID(), "E",
				paymentDetailBean.getPD_PAY_MODE() };
			 resultSet = new CRUDHandler().executeSelectStatement(queryEncrypt,
					connection, values);
        			while (resultSet.next()) {
        			    M_NO = resultSet.getString(1);
        			}   
		          //M_NO:= F_CC_ENCRYPT(:PT_IL_PYMT_DTLS.M_PD_CC_NO_1,:PT_IL_PYMT_DTLS.PD_SYS_ID,'E',:PT_IL_PYMT_DTLS.PD_PAY_MODE); 
		    }
		    else if("SC".equals(paymentDetailBean.getPD_PAY_MODE()) &&
			    	!"XXXXXXXXXXXX".equals(CommonUtils.SUBSTR(paymentDetailBean.getUI_M_PD_CC_NO(),1,12))){
			values = new Object[] {
				paymentDetailBean.getUI_M_PD_CC_NO(),
				paymentDetailBean.getPD_SYS_ID(), "E",
				paymentDetailBean.getPD_PAY_MODE() };
			 resultSet = new CRUDHandler().executeSelectStatement(queryEncrypt,
					connection, values);
        			while (resultSet.next()) {
        			    M_NO = resultSet.getString(1);
        			}   
		        //  M_NO:= F_CC_ENCRYPT(:PT_IL_PYMT_DTLS.M_PD_CC_NO,:PT_IL_PYMT_DTLS.PD_SYS_ID,'E',:PT_IL_PYMT_DTLS.PD_PAY_MODE); 

		    }
		    
		  
		    helperP9ILPK_CHEQ_VALIDATION_UPD_REF_ID_PYMT_DTLS(
						paymentDetailBean.getPD_TXN_SYS_ID(), paymentDetailBean.getPD_TXN_TYPE());
		    
		    
		} catch (Exception e) {
		    // TODO: handle exception
		}
    }
    
    public void pilt017_pt_il_pymt_dtls_post_update(
	    PT_IL_PYMT_DTLS paymentDetailBean) throws Exception {
	String M_NO =null;
	String M_USER_CREDIT_CARD_UPD_YN =null;
	String M_PD_CC_NO =null;
	String M_PD_CC_NO_2 =null;
	 
	Connection connection = null;
	ResultSet resultSet = null;
	ResultSet rst = null;
	CRUDHandler handler = new CRUDHandler();
	Object[] values = null;
	String pymtModecondition = " CC C1 C2 C3 C4 C5 C6 ";
	String C1 = "SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N')     FROM MENU_USER  " +
			"  WHERE USER_ID = ? ";
	String queryEncrypt = " SELECT F_CC_ENCRYPT(?,?,?,?) FROM DUAL ";
	try {
	    connection = CommonUtils.getConnection();
	    values = new Object[]{CommonUtils.getControlBean().getM_USER_ID()}; 
	    resultSet = new CRUDHandler().executeSelectStatement(C1,
			connection, values);
		while (resultSet.next()) {
		    M_USER_CREDIT_CARD_UPD_YN = resultSet.getString(1);
		}   
	    
	    
	    String PD_PAY_MODE = paymentDetailBean.getPD_PAY_MODE();
	    if (pymtModecondition.contains(" " + PD_PAY_MODE + " ") && 
		    paymentDetailBean.getUI_M_PD_CC_NO_1() !=null &&
		    !"XXXXXXXXXXXX".equals(CommonUtils.SUBSTR(  paymentDetailBean.getUI_M_PD_CC_NO_1(),1,12))) {
		
		// M_NO:= F_CC_ENCRYPT(:PT_IL_PYMT_DTLS.M_PD_CC_NO_1,:PT_IL_PYMT_DTLS.PD_SYS_ID,'E',:PT_IL_PYMT_DTLS.); 
		values = new Object[] {
			paymentDetailBean.getUI_M_PD_CC_NO_1(),
			paymentDetailBean.getPD_SYS_ID(), "E",
			paymentDetailBean.getPD_PAY_MODE() };
		resultSet = new CRUDHandler().executeSelectStatement(queryEncrypt,
			connection, values);
		while (resultSet.next()) {
		    M_NO = resultSet.getString(1);
		}    
	    }
	   else if("I".equals(paymentDetailBean.getPD_PAY_MODE() )){
		values = new Object[] {
			paymentDetailBean.getUI_M_PD_CC_NO_1(),
			paymentDetailBean.getPD_SYS_ID(), "E",
			paymentDetailBean.getPD_PAY_MODE() };
		resultSet = new CRUDHandler().executeSelectStatement(queryEncrypt,
			connection, values);
		while (resultSet.next()) {
		    M_NO = resultSet.getString(1);
		}   
		//M_NO:= F_CC_ENCRYPT(:PT_IL_PYMT_DTLS.M_PD_CC_NO_1,:PT_IL_PYMT_DTLS.PD_SYS_ID,'E',:PT_IL_PYMT_DTLS.PD_PAY_MODE); 
	    }
	    else if("SC".equals(paymentDetailBean.getPD_PAY_MODE()) &&
		    !"XXXXXXXXXXXX".equals(CommonUtils.SUBSTR(paymentDetailBean.getUI_M_PD_CC_NO(),1,12))){
		values = new Object[] {
			paymentDetailBean.getUI_M_PD_CC_NO(),
			paymentDetailBean.getPD_SYS_ID(), "E",
			paymentDetailBean.getPD_PAY_MODE() };
		resultSet = new CRUDHandler().executeSelectStatement(queryEncrypt,
			connection, values);
		while (resultSet.next()) {
		    M_NO = resultSet.getString(1);
		}   
		//  M_NO:= F_CC_ENCRYPT(:PT_IL_PYMT_DTLS.M_PD_CC_NO,:PT_IL_PYMT_DTLS.PD_SYS_ID,'E',:PT_IL_PYMT_DTLS.PD_PAY_MODE); 
		
	    }
	    
	    if(paymentDetailBean.getPD_DPD_REF_ID()== null){
	    helperP9ILPK_CHEQ_VALIDATION_UPD_REF_ID_PYMT_DTLS(
					paymentDetailBean.getPD_TXN_SYS_ID(), paymentDetailBean.getPD_TXN_TYPE());
	    }
	    
	    /*Added by Janani on 09.06.2018 for FSD_IL_FLA_019 */
	   
	    CommonUtils.setGlobalObject("GLOBAL.DEP_LC_AMT",paymentDetailBean.getPD_LC_AMT());
	   
	    String upd_lc_amt_query = "UPDATE PT_IL_DEPOSIT SET DEP_LC_DEP_AMT = ? ,DEP_LC_TOTAL_AMT = ?  WHERE DEP_SYS_ID = ?";
	    
	    new CRUDHandler().executeUpdateStatement(upd_lc_amt_query, connection,new Object[] {paymentDetailBean.getPD_LC_AMT(),
	    		paymentDetailBean.getPD_LC_AMT(),paymentDetailBean.getPD_TXN_SYS_ID()});
	    
	    connection.commit();
	    
	    /*End*/
	    
	    
	} catch (Exception e) {
		e.printStackTrace();
	    // TODO: handle exception
	}
	
	
    }
	public void pilt017_pt_il_pymt_dtls_pre_insert(
		PT_IL_PYMT_DTLS paymentDetailBean) throws Exception {
	String selectQuery = PILT017_QUERY_CONSTANTS.PILT017_PT_IL_PYMT_DTLS_PRE_INSERT;
	Connection con = null;
	CRUDHandler handler = null;
	ResultSet rst = null;
	CommonUtils commonUtils = new CommonUtils();
	String M_USER_ID = null;
	String PD_PAY_MODE = paymentDetailBean.getPD_PAY_MODE();

	String M_OUR_BANK_CODE = null;
	String M_CHQ_NO = null;
	String M_OUR_BANK_CODE_1 = null;
	String M_REM_SLIP_GEN_YN = null;
	String M_OUR_BANK_CODE_2 = null;
	String M_DATE_OF_CREDIT = null;
	String M_BANK_REF_NO = null;
	String M_DATE_OF_CREDIT_1 = null;
	String M_PD_CC_TYPE = null;
	String M_PD_CC_NO = null;
	String M_PD_CC_APP_CODE = null;
	String M_BANK_REF_NO_1 = null;
	String M_DATE_OF_CREDIT_2 = null;
	String M_BANK_REF_NO_2 = null;
	String PD_TXN_TYPE = null;
	int M_PD_CVV_NO = 0;
	try {
				con = CommonUtils.getConnection();
				L_DUP_SERIAL_NO(paymentDetailBean);
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);

				if (rst.next()) {
					paymentDetailBean.setPD_SYS_ID(rst.getLong(1));
				}
			
				paymentDetailBean.setPD_CR_DT(commonUtils.getCurrentDate());
				paymentDetailBean.setPD_CR_UID(CommonUtils.getControlBean()
						.getUSER_ID());

				if ("BC".equals(PD_PAY_MODE)) {
					M_OUR_BANK_CODE = paymentDetailBean.getUI_M_OUR_BANK_CODE();
					M_CHQ_NO = paymentDetailBean.getPD_CHQ_NO();
					paymentDetailBean.setPD_OUR_BANK_CODE(M_OUR_BANK_CODE);
					paymentDetailBean.setPD_CHQ_NO(M_CHQ_NO);
				}
				if ("PM".equals(PD_PAY_MODE)) {
					M_OUR_BANK_CODE_1 = paymentDetailBean
							.getUI_M_OUR_BANK_CODE_1();
					M_REM_SLIP_GEN_YN = paymentDetailBean
							.getUI_M_REM_SLIP_GEN_YN();
					paymentDetailBean.setPD_OUR_BANK_CODE(M_OUR_BANK_CODE_1);
					paymentDetailBean.setPD_REM_SLIP_GEN_YN(M_REM_SLIP_GEN_YN);
				}
				if ("EF".equals(PD_PAY_MODE)) {
					M_OUR_BANK_CODE_2 = paymentDetailBean
							.getUI_M_OUR_BANK_CODE_2();
					M_DATE_OF_CREDIT = new SimpleDateFormat("dd-MMM-yyyy")
							.format(paymentDetailBean.getUI_M_DATE_OF_CREDIT());
					paymentDetailBean.setPD_OUR_BANK_CODE(M_OUR_BANK_CODE_2);
					paymentDetailBean
							.setPD_DATE_OF_CREDIT(new SimpleDateFormat(
									"dd-MMM-yyyy").parse(M_DATE_OF_CREDIT));
				}
				if ("AD".equals(PD_PAY_MODE)) {
					M_BANK_REF_NO = paymentDetailBean.getUI_M_BANK_REF_NO();
					M_DATE_OF_CREDIT_1 = new SimpleDateFormat("dd-MMM-yyyy")
							.format(paymentDetailBean
									.getUI_M_DATE_OF_CREDIT_1());
					paymentDetailBean.setPD_BANK_REF_NO(M_BANK_REF_NO);
					paymentDetailBean
							.setPD_DATE_OF_CREDIT(new SimpleDateFormat(
									"dd-MMM-yyyy").parse(M_DATE_OF_CREDIT_1));
				}
				if ("SC".equals(PD_PAY_MODE)) {
					M_PD_CC_TYPE = paymentDetailBean.getUI_M_PD_CC_TYPE();
					M_PD_CC_NO = paymentDetailBean.getUI_M_PD_CC_NO();
					M_PD_CC_APP_CODE = paymentDetailBean
							.getUI_M_PD_CC_APP_CODE();
					M_BANK_REF_NO_1 = paymentDetailBean.getUI_M_BANK_REF_NO_1();
					M_DATE_OF_CREDIT_2 = new SimpleDateFormat("dd-MMM-yyyy")
							.format(paymentDetailBean
									.getUI_M_DATE_OF_CREDIT_2());
					paymentDetailBean.setPD_CC_TYPE(M_PD_CC_TYPE);
					paymentDetailBean.setPD_CC_NO(M_PD_CC_NO);
					paymentDetailBean.setPD_CC_APP_CODE(M_PD_CC_APP_CODE);
					paymentDetailBean.setPD_BANK_REF_NO(M_BANK_REF_NO_1);
					paymentDetailBean
							.setPD_DATE_OF_CREDIT(new SimpleDateFormat(
									"dd-MMM-yyyy").parse(M_DATE_OF_CREDIT_2));
					/*M_PD_CVV_NO = paymentDetailBean.getPD_CVV_NO();
					paymentDetailBean.setPD_CVV_NO(M_PD_CVV_NO);*/
				}
				/*
				 * paymentDetailBean.setPD_TXN_TYPE(PD_TXN_TYPE); PD_TXN_TYPE =
				 * (String)CommonUtils.getGlobalObject("GLOBAL.TXN_TYPE");
				 * paymentDetailBean.setPD_TXN_SYS_ID((Long)CommonUtils.getGlobalObject("GLOBAL.TXN_SYS_ID"));
				 * 
				 */

				if ("A".equals(PD_PAY_MODE)) {
					M_BANK_REF_NO_2 = paymentDetailBean.getUI_M_BANK_REF_NO_2();
					paymentDetailBean.setPD_BANK_REF_NO(M_BANK_REF_NO_2);
				}
	} catch (DBException e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} catch (SQLException e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} catch (ParseException e) {
	    e.printStackTrace();

	} finally {
	    try {
		CommonUtils.closeCursor(rst);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	 }
	}
    public void pilt017_pt_il_pymt_dtls_pre_update(
	    PT_IL_PYMT_DTLS paymentDetailBean) throws Exception {

	CommonUtils commonUtils = new CommonUtils();
	String M_USER_ID = null;
	String PD_PAY_MODE = paymentDetailBean.getPD_PAY_MODE();

	String M_OUR_BANK_CODE = null;
	String M_CHQ_NO = null;
	String M_OUR_BANK_CODE_1 = null;
	String M_REM_SLIP_GEN_YN = null;
	String M_OUR_BANK_CODE_2 = null;
	String M_DATE_OF_CREDIT = null;
	String M_BANK_REF_NO = null;
	String M_DATE_OF_CREDIT_1 = null;
	String M_PD_CC_TYPE = null;
	String M_PD_CC_NO = null;
	String M_PD_CC_APP_CODE = null;
	String M_BANK_REF_NO_1 = null;
	String M_DATE_OF_CREDIT_2 = null;
	String M_BANK_REF_NO_2 = null;
	String PD_TXN_TYPE = (String) CommonUtils.getGlobalObject("GLOBAL.TXN_TYPE");
	M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");

	try {
	    L_DUP_SERIAL_NO(paymentDetailBean);
	    paymentDetailBean.setPD_UPD_DT(commonUtils.getCurrentSQLDate());
	    paymentDetailBean.setPD_UPD_UID(M_USER_ID);
	    paymentDetailBean.setPD_TXN_TYPE(PD_TXN_TYPE);
	    if ("BC".equals(PD_PAY_MODE)) {
		M_OUR_BANK_CODE = paymentDetailBean.getUI_M_OUR_BANK_CODE();
		M_CHQ_NO = paymentDetailBean.getPD_CHQ_NO();

		paymentDetailBean.setPD_OUR_BANK_CODE(M_OUR_BANK_CODE);
		paymentDetailBean.setPD_CHQ_NO(M_CHQ_NO);
	    }
	    if ("PM".equals(PD_PAY_MODE)) {
		M_OUR_BANK_CODE_1 = paymentDetailBean.getUI_M_OUR_BANK_CODE_1();
		M_REM_SLIP_GEN_YN = paymentDetailBean.getUI_M_REM_SLIP_GEN_YN();

		paymentDetailBean.setPD_OUR_BANK_CODE(M_OUR_BANK_CODE_1);
		paymentDetailBean.setPD_REM_SLIP_GEN_YN(M_REM_SLIP_GEN_YN);
	    }
	    if ("EF".equals(PD_PAY_MODE)) {
		M_OUR_BANK_CODE_2 = paymentDetailBean.getUI_M_OUR_BANK_CODE_2();
		
		/*Add if Condition by Ram on 25/11/2016 for avoid Null Pointer Exception*/
		if(paymentDetailBean.getUI_M_DATE_OF_CREDIT() != null)
		{
			M_DATE_OF_CREDIT = new SimpleDateFormat("dd-MMM-yyyy")
			.format(paymentDetailBean.getUI_M_DATE_OF_CREDIT());	
			paymentDetailBean.setPD_DATE_OF_CREDIT(new SimpleDateFormat(
					"dd-MMM-yyyy").parse(M_DATE_OF_CREDIT));
		}
		/*End*/

		paymentDetailBean.setPD_OUR_BANK_CODE(M_OUR_BANK_CODE_2);
		
	    }
	    if ("AD".equals(PD_PAY_MODE)) {
		M_BANK_REF_NO = paymentDetailBean.getUI_M_BANK_REF_NO();
		
		/*Add if Condition by Ram on 25/11/2016 for avoid Null Pointer Exception*/
		if(paymentDetailBean.getUI_M_DATE_OF_CREDIT_1() != null)
		{
			M_DATE_OF_CREDIT_1 = new SimpleDateFormat("dd-MMM-yyyy")
			.format(paymentDetailBean.getUI_M_DATE_OF_CREDIT_1());	
			paymentDetailBean.setPD_DATE_OF_CREDIT(new SimpleDateFormat(
					"dd-MMM-yyyy").parse(M_DATE_OF_CREDIT_1));
		}
		/*End*/

		paymentDetailBean.setPD_BANK_REF_NO(M_BANK_REF_NO);
		
		 
		
		}
	    if ("SC".equals(PD_PAY_MODE)) {
		M_PD_CC_TYPE = paymentDetailBean.getUI_M_PD_CC_TYPE();
		/*commented by pidugu raj for kic, since found pd_cc_no is required but some one mapped wrongly ui_m_pd_cc_no  
		 M_PD_CC_NO = paymentDetailBean.getUI_M_PD_CC_NO();*/
		
		//Newly added by pidugu raj dt: 04-10-2018 for kic credit card number
		M_PD_CC_NO = paymentDetailBean.getPD_CC_NO();
		//End Newly added by pidugu raj dt: 04-10-2018 for kic credit card number
		
		M_PD_CC_APP_CODE = paymentDetailBean.getUI_M_PD_CC_APP_CODE();

		M_BANK_REF_NO_1 = paymentDetailBean.getUI_M_BANK_REF_NO_1();
		
		/*Add if Condition by Ram on 25/11/2016 for avoid Null Pointer Exception*/
		if(paymentDetailBean.getUI_M_DATE_OF_CREDIT_2() != null)
		{
			M_DATE_OF_CREDIT_2 = new SimpleDateFormat("dd-MMM-yyyy")
			.format(paymentDetailBean.getUI_M_DATE_OF_CREDIT_2());
			paymentDetailBean.setPD_DATE_OF_CREDIT(new SimpleDateFormat(
					"dd-MMM-yyyy").parse(M_DATE_OF_CREDIT_2));	
	
		}
		/*End*/
		
		paymentDetailBean.setPD_CC_TYPE(M_PD_CC_TYPE);
		paymentDetailBean.setPD_CC_NO(M_PD_CC_NO);
		paymentDetailBean.setPD_CC_APP_CODE(M_PD_CC_APP_CODE);
		paymentDetailBean.setPD_BANK_REF_NO(M_BANK_REF_NO_1);
		paymentDetailBean.setPD_CVV_NO(paymentDetailBean.getPD_CVV_NO());
		 
		
	    }
	    if ("A".equals(PD_PAY_MODE)) {
		M_BANK_REF_NO_2 = paymentDetailBean.getUI_M_BANK_REF_NO_2();

		paymentDetailBean.setPD_BANK_REF_NO(M_BANK_REF_NO_2);
	    }
	} catch (ParseException e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public void L_DUP_SERIAL_NO(PT_IL_PYMT_DTLS paymentDetailBean)
	    throws ValidatorException {
	int PD_SR_NO = paymentDetailBean.getPD_SR_NO();
	String PD_TXN_TYPE = paymentDetailBean.getPD_TXN_TYPE();
	Long PD_TXN_SYS_ID = paymentDetailBean.getPD_TXN_SYS_ID();
	String ROWID = paymentDetailBean.getROWID();
	Connection con = null;
	ResultSet rst = null;
	CRUDHandler handler = null;
	String sql_C1 = "SELECT 'X' FROM  PT_IL_PYMT_DTLS  WHERE  PD_SR_NO  = '"
		+ PD_SR_NO
		+ "'  AND PD_TXN_TYPE  = '"
		+ PD_TXN_TYPE
		+ "'  AND PD_TXN_SYS_ID  = '" + PD_TXN_SYS_ID + "'";
	String value = null;
	String sql_C2 = "SELECT 'X' FROM  PT_IL_PYMT_DTLS  WHERE  PD_SR_NO  = '"
		+ PD_SR_NO
		+ "'  AND PD_TXN_TYPE  = '"
		+ PD_TXN_TYPE
		+ "'  AND PD_TXN_SYS_ID  = '"
		+ PD_TXN_SYS_ID
		+ "'  AND ROWID  != '" + ROWID + "' ";
	try {
	    con = CommonUtils.getConnection();
	    if (con != null) {
		handler = new CRUDHandler();
		if (ROWID == null) {
		    rst = handler.executeSelectStatement(sql_C1, con);
		    if (rst.next()) {
			throw new ValidatorException(Messages.getMessage(
				PELConstants.pelErrorMessagePath, "91000"));
		    }
		    /*
		     * else{ value = rst.getString(1); }
		     */
		} else {
		    rst = handler.executeSelectStatement(sql_C2, con);
		    if (rst.next()) {
			throw new ValidatorException(Messages.getMessage(
				PELConstants.pelErrorMessagePath, "91000"));
		    }
		    /*
		     * else{ value = rst.getString(1); }
		     */
		}
	    }
	} catch (DBException e) {
	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    try {
		CommonUtils.closeCursor(rst);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public static List<SelectItem> getDropDownListValue(String formName,
	    String blockName, String blockFieldName, String filedName) {
	List<SelectItem> listValues = null;
	try {
	    listValues = ListItemUtil.getDropDownListValue(CommonUtils
		    .getConnection(), formName, blockName, blockFieldName,
		    filedName);
	} catch (DBException e) {
	    e.printStackTrace();
	}

	return listValues;
    }

    public void onKeyCommit(PT_IL_PYMT_DTLS_ACTION detailAction)
	    throws Exception {
	String PD_TXN_TYPE = (String)CommonUtils.getGlobalObject("GLOBAL.TXN_TYPE");
	String PD_PD_TXN_SYS_ID = CommonUtils
		.getGlobalVariable("GLOBAL.TXN_SYS_ID");

	String M_DUMMY = null;
	Connection con = null;
	CRUDHandler handler = null;
	ResultSet rst = null;
	ResultSet rst1 = null;
	PT_IL_PYMT_DTLS paymentDetailsBean = detailAction
		.getPT_IL_PYMT_DTLS_BEAN();
	DBProcedures procedures = new DBProcedures();

	String condition = " C D L H O SD ";

	String PD_PAY_MODE = paymentDetailsBean.getPD_PAY_MODE();
	// String ROWID = p
	ArrayList<String> value = null;

	Iterator<PT_IL_PYMT_DTLS> iterator = null;
	if (detailAction.getDataTableList() != null) {
	    iterator = detailAction.getDataTableList().iterator();

	}

	String sql_C1 = "SELECT PD_PAY_MODE FROM PT_IL_PYMT_DTLS AND PD_TXN_SYS_ID = '"
		+ PD_PD_TXN_SYS_ID + "'";
	String sql_C2 = "SELECT 'X' FROM  PT_IL_PYMT_DTLS  WHERE  PD_PAY_MODE  = '"
		+ PD_PAY_MODE
		+ "'  AND PD_TXN_TYPE  = '"
		+ PD_TXN_TYPE
		+ "'  AND PD_TXN_SYS_ID  = '"
		+ PD_PD_TXN_SYS_ID
		+ "'  AND ROWID  != :PT_IL_PYMT_DTLS.ROWID ";
	String M_PS_VALUE = "";
	try {
	    con = CommonUtils.getConnection();
	    if (condition.contains(" " + PD_PAY_MODE + " ")) {
		L_DUP_CHQ_NO(detailAction);
	    }
	    value = procedures
		    .callP_VAL_SYSTEM("IL_MUL_PAY", "IL_MUL_PAY", "E");
	    M_PS_VALUE = value.get(0);
	    if ("2".equals(M_PS_VALUE)) {
		if (paymentDetailsBean.getROWID() == null) {
		    if (con != null) {
			handler = new CRUDHandler();
			rst = handler.executeSelectStatement(sql_C1, con);
			if (rst.next()) {
			    M_DUMMY = rst.getString(1);
			}
			if (M_DUMMY != PD_PAY_MODE) {
			    paymentDetailsBean.setPD_PAY_MODE(M_DUMMY);
			}

			/*
			 * IF NAME_IN('SYSTEM.CURSOR_BLOCK') NOT IN (
			 * 'CTRL','BUTTON_PALETTE') THEN
			 * GET_FIRST_FIELD(M_FIELD_NAME) ; IF
			 * NAME_IN(M_FIELD_NAME) IS NULL THEN CLEAR_RECORD ;
			 * CHK_PKG_FAILURE ; END IF ;
			 * GET_ALERT_MSG('10',M_MESSAGE);
			 * SET_ALERT_PROPERTY('SAVE_BOX',ALERT_MESSAGE_TEXT,M_MESSAGE);
			 * M_CHOICE := SHOW_ALERT('SAVE_BOX'); IF M_CHOICE =
			 * ALERT_BUTTON1 THEN
			 * SET_APPLICATION_PROPERTY(CURSOR_STYLE,'BUSY');
			 * /COPY('0','SYSTEM.MESSAGE_LEVEL');
			 * COPY('C','CTRL.M_COMM_DEL') ; COMMIT_FORM;
			 * COPY('','CTRL.M_COMM_DEL') ;
			 * COPY('','CTRL.M_COMMIT_FLAG') ;
			 * COPY('10','SYSTEM.MESSAGE_LEVEL');
			 * SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT');
			 * CHK_PKG_FAILURE ;
			 * GO_BLOCK(GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),
			 * FIRSTBLOCK)) ; M_INSERTED:='Y';
			 * 
			 * ELSIF M_CHOICE = ALERT_BUTTON2 THEN
			 * 
			 * SET_APPLICATION_PROPERTY(CURSOR_STYLE,'BUSY');
			 * COPY('0','SYSTEM.MESSAGE_LEVEL');
			 * COPY('C','CTRL.M_COMM_DEL') ; COMMIT_FORM;
			 * COPY('','CTRL.M_COMM_DEL') ;
			 * COPY('','CTRL.M_COMMIT_FLAG') ;
			 * COPY('10','SYSTEM.MESSAGE_LEVEL');
			 * SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT');
			 * CHK_PKG_FAILURE ; M_INSERTED:='Y';
			 * 
			 * END IF;
			 */

			DBProcedures procCall = new DBProcedures();
			procCall
				.helperP9ILPK_CHEQ_VALIDATION_UPD_REF_ID_PYMT_DTLS(
					PD_PD_TXN_SYS_ID, PD_TXN_TYPE);
		    }
		}
	    }
	} catch (DBException e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} catch (SQLException e) {
	    e.printStackTrace();
	    throw new Exception(Messages.getString(
		    PELConstants.pelErrorMessagePath, "91570"));
	} finally {
	    try {
		CommonUtils.closeCursor(rst);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    try {
		CommonUtils.closeCursor(rst1);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    // WHEN VALIDATE ITEM Added by Kavitha

    public void m_chq_no_when_validate_item(PT_IL_PYMT_DTLS paymentDetailBean)
	    throws Exception {
	int M_PS_VALUE = 0;
	ResultSet rs = null;
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	String C1 = " SELECT PS_VALUE  FROM PP_SYSTEM  WHERE PS_TYPE = 'IL_MAX_CHQNO'";
	try {

	    connection = CommonUtils.getConnection();
	    rs = handler.executeSelectStatement(C1, connection);
	    if (rs.next()) {
		M_PS_VALUE = rs.getInt(1);
	    }
	    String payMode = paymentDetailBean.getPD_PAY_MODE();
	    if ("BC".equalsIgnoreCase(payMode) || "C".equalsIgnoreCase(payMode)
		    || "D".equalsIgnoreCase(payMode)
		    || "L".equalsIgnoreCase(payMode)) {

		if (paymentDetailBean.getUI_M_CHQ_NO().length() != M_PS_VALUE) {
		    throw new Exception(Messages.getString(
			    PELConstants.pelErrorMessagePath, "91014",
			    new Object[] { "Cheque/DD Number", M_PS_VALUE,
				    "Digits" }));

		}
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}

    }

    public void pd_chq_no_when_validate_item(PT_IL_PYMT_DTLS paymentDetailBean,COMPOSITE_ACTION_BEAN compositeAction)
	    throws Exception {
	int M_PS_VALUE = 0;
	ResultSet rs = null;
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	String C1 = " SELECT PS_VALUE  FROM PP_SYSTEM  WHERE PS_TYPE = 'IL_MAX_CHQNO'";
	try {

	    connection = CommonUtils.getConnection();
	    rs = handler.executeSelectStatement(C1, connection);
	    if (rs.next()) {
		M_PS_VALUE = rs.getInt(1);
	    }
	    String payMode = paymentDetailBean.getPD_PAY_MODE();
	    if ("BC".equalsIgnoreCase(payMode) || "C".equalsIgnoreCase(payMode)
		    || "D".equalsIgnoreCase(payMode)
		    || "L".equalsIgnoreCase(payMode)) {
	    
	    /*M_PS_VALUE !=0 this condition addded by Sivarajan on 30-01-2019 for KIC check number Validation*/
		if (M_PS_VALUE !=0 && paymentDetailBean.getPD_CHQ_NO().length() != M_PS_VALUE) {
			//added by agalya for cheque number validation in receipt entry -payment details button screen on 04/07/2016 , ref no- FALCONQC-1714607
			String enteredValue = paymentDetailBean.getPD_CHQ_NO();
		paymentDetailBean.setPD_CHQ_NO(null);
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getCOMP_PD_CHQ_NO().setValue(null);
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getCOMP_PD_CHQ_NO().resetValue();
			System.out.println("paymentDetailBean.getPD_CHQ_NO()  :"+paymentDetailBean.getPD_CHQ_NO());  
			  throw new Exception(Messages.getString(
					    PELConstants.pelErrorMessagePath, "91014",
					    new Object[] { "Cheque/DD Number", M_PS_VALUE,
						    "Digits. Please Re-enter"/*+".You have entered "+enteredValue+".Please Re-enter"*/ }));
		   /* throw new Exception(Messages.getString(
			    PELConstants.pelErrorMessagePath, "91014",
			    new Object[] { "Cheque/DD Number", M_PS_VALUE,
				    "Digits" }));*/

			  //end
		}
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}

    }

    public void pd_tt_curr_code_when_validate_item(
	    PT_IL_PYMT_DTLS paymentDetailBean) throws Exception {
	String M_DUMMY = null;
	ResultSet rs = null;
	Object[] values = {};
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	String C1 = " SELECT 'X' FROM   PM_CURRENCY	WHERE  CURR_CODE = ? ";
	try {
	    connection = CommonUtils.getConnection();
	    values = new Object[] { paymentDetailBean.getPD_TT_CURR_CODE() };
	    if ("TT".equalsIgnoreCase(paymentDetailBean.getPD_PAY_MODE())) {
		rs = handler.executeSelectStatement(C1, connection, values);
		if (rs.next()) {
		    M_DUMMY = rs.getString(1);
		} else {
		    throw new Exception(Messages.getString(
			    PELConstants.pelErrorMessagePath, "91053",
			    new Object[] { CommonUtils
				    .getGlobalVariable("GLOBAL.M_LANG_CODE") }));
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public void m_pd_cc_no_1_when_validate_item(
	    PT_IL_PYMT_DTLS paymentDetailBean) throws Exception {
	String M_CREDIT_CARD_UPD_YN = null;
	ResultSet rs = null;
	Object[] values = {};
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	String C1 = " SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N')  FROM MENU_USER  WHERE USER_ID = ";
	String pymtModecondition = " CC C1 C2 C3 C4 C5 C6 ";
	try {
	    connection = CommonUtils.getConnection();
	    values = new Object[] { CommonUtils.getControlBean().getM_USER_ID() };
	    rs = handler.executeSelectStatement(C1, connection, values);
	    if (rs.next()) {
		M_CREDIT_CARD_UPD_YN = rs.getString(1);
	    }
	    String PD_PAY_MODE = paymentDetailBean.getPD_PAY_MODE();
	    if (pymtModecondition.contains(" " + PD_PAY_MODE + " ")) {
		if (paymentDetailBean.getUI_M_PD_CC_NO().length() != 16) {
		    throw new Exception(Messages.getString(
			    PELConstants.pelErrorMessagePath, "92080",
			    new Object[] { CommonUtils
				    .getGlobalVariable("GLOBAL.M_LANG_CODE") }));
		} else {

		    if (!"XXXXXXXXXXXX".equalsIgnoreCase(CommonUtils.SUBSTR(
			    paymentDetailBean.getUI_M_PD_CC_NO(), 1, 12))) {
			int i = 1;
			do {
			    if (CommonUtils.SUBSTR(
				    paymentDetailBean.getUI_M_PD_CC_NO(), i, 1)
				    .charAt(0) < 48
				    || CommonUtils.SUBSTR(
					    paymentDetailBean
						    .getUI_M_PD_CC_NO(), i, 1)
					    .charAt(0) > 57) {

				/*
				 * ASCII(SUBSTR(:PT_IL_PYMT_DTLS.M_PD_CC_NO_1,I,1))<48
				 * OR
				 * ASCII(SUBSTR(:PT_IL_PYMT_DTLS.M_PD_CC_NO_1,I,1))>57
				 * THEN
				 */
				throw new Exception(
					Messages
						.getString(
							PELConstants.pelErrorMessagePath,
							"3206",
							new Object[] {
								CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE"),
								"Invalid Credit Card Number Entered" }));
			    }

			} while (i <= paymentDetailBean.getUI_M_PD_CC_NO()
				.length());

		    }
		}

	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public void pd_cc_app_code_when_validate_item(
	    PT_IL_PYMT_DTLS paymentDetailBean) {
	paymentDetailBean.setPD_CC_APP_CODE(CommonUtils.lpad(paymentDetailBean
		.getPD_CC_APP_CODE(), 6, "0"));
    }

    public void pd_dpd_ref_id_when_validate_item(
	    PT_IL_PYMT_DTLS paymentDetailBean, DUMMY dummyBean)
	    throws Exception {
	ResultSet resultSet1 = null;
	ResultSet resultSet2 = null;
	ResultSet resultSet3 = null;
	ResultSet resultSet4 = null;
	CRUDHandler handler = new CRUDHandler();
	Connection con = null;
	String C1 = "SELECT  (DPD_LC_DEP_AMT-DPD_LC_UTIL_AMT) FC_AMT,DPD_CHQ_NO,DPD_CHQ_DT, "
		+ "DPD_BANK_NAME,DPD_BRANCH_NAME,DPD_CC_NO,DPD_CC_NAME,DPD_CC_EXP_DT, "
		+ "DPD_CC_TYPE,DPD_REMARKS FROM PT_IL_DEPOSIT_PYMT_DTLS WHERE DPD_REF_ID =	? ";

	String C2 = "SELECT DECODE(:CTRL.M_LANG_CODE,'ENG',BANK_NAME,BANK_NAME_BL) "
		+ "FROM   FM_BANK WHERE  BANK_CODE= M_BANK_NAME";

	String C3 = "SELECT PD_CUST_NAME ,PD_ADDR_01,PD_ADDR_02,PD_ADDR_03 FROM  PT_IL_PYMT_DTLS "
		+ "WHERE  PD_DPD_REF_ID = M_DPD_REF_ID ";
	
//	String C4 = "SELECT 'X' FROM PT_IL_PYMT_DTLS WHERE PD_DPD_REF_ID = ? ";

	String M_CONT_CODE = null;
	try {
		con = CommonUtils.getConnection();
		 //ADDED FOR UNIQUE PD_DPD_REF_ID
	 /*   resultSet4 = handler.executeSelectStatement(C4, con, new Object[]{paymentDetailBean.getPD_DPD_REF_ID()});
	    if(resultSet4.next()){
	    	throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath,"90015",new Object[] {"Dep Ref ID"}));
	    }*/
	    //added ends 
	    if ("LR".equalsIgnoreCase(paymentDetailBean.getPD_PAY_MODE())) {
		Object[] c1values = new Object[] { paymentDetailBean
			.getPD_DPD_REF_ID() };
		resultSet1 = handler.executeSelectStatement(C1, con, c1values);
		if (resultSet1.next()) {
		    paymentDetailBean.setPD_LC_AMT(resultSet1.getDouble(1));
		    paymentDetailBean.setPD_CHQ_NO(resultSet1.getString(2));
		    paymentDetailBean.setPD_CHQ_DT(resultSet1.getDate(3));
		    paymentDetailBean.setPD_BANK_NAME(resultSet1.getString(4));
		    paymentDetailBean
			    .setPD_BRANCH_NAME(resultSet1.getString(5));
		    paymentDetailBean.setPD_CC_NO(resultSet1.getString(6));
		    paymentDetailBean.setPD_CC_NAME(resultSet1.getString(7));
		    paymentDetailBean.setPD_CC_EXP_DT(resultSet1.getDate(8));
		    paymentDetailBean.setPD_CC_TYPE(resultSet1.getString(9));
		    paymentDetailBean.setPD_REMARKS(resultSet1.getString(10));
		    ArrayList<String> list = new DBProcedures()
			    .callPILQ106_P_VAL_ROUND_AMT(paymentDetailBean
				    .getPD_CURR_CODE(), CommonUtils
				    .getProcedureValue(paymentDetailBean
					    .getPD_FC_AMT()), "V");
		    if (!list.isEmpty()) {
			paymentDetailBean.setPD_FC_AMT(Double.parseDouble(list
				.get(0)));
		    }
		    paymentDetailBean.setPD_FC_AMT((paymentDetailBean.getPD_LC_AMT() / (Double)CommonUtils.getGlobalObject("GLOBAL.EXCH_RATE")));
		    ArrayList<String> list1 = new DBProcedures()
			    .callPILQ106_P_VAL_ROUND_AMT(dummyBean
				    .getBASE_CURR_CODE(), CommonUtils
				    .getProcedureValue(paymentDetailBean
					    .getPD_FC_AMT()), "R");
		    if (!list1.isEmpty()) {
			paymentDetailBean.setPD_FC_AMT(Double.parseDouble(list1
				.get(0)));
		    }
		} else {
		    throw new Exception("DEPOSIT PYMT DTLS NOT FOUND FOR "
			    + paymentDetailBean.getPD_DPD_REF_ID());
		    // DISP_ALERT('DEPOSIT PYMT DTLS NOT FOUND FOR
		    // '||:PT_IL_PYMT_DTLS.PD_DPD_REF_ID);
		}
		if (paymentDetailBean.getPD_BANK_NAME() != null) {
		    resultSet2 = handler.executeSelectStatement(C2, con);
		    if (resultSet2.next()) {
			// OPEN C2(:PT_IL_PYMT_DTLS.PD_BANK_NAME);
			paymentDetailBean.setUI_M_BANK_NAME_DESC(resultSet2
				.getString(1));
		    } else {
			throw new Exception(Messages.getString(
				PELConstants.pelErrorMessagePath, "3206"));
			// STD_MESSAGE_ROUTINE (3206,:CTRL.M_LANG_CODE);
		    }

		    if (paymentDetailBean.getPD_LC_AMT() > 0) {
			resultSet3 = handler.executeSelectStatement(C3, con);
			// OPEN C3(:PT_IL_PYMT_DTLS.PD_DPD_REF_ID);
			while (resultSet3.next()) {
			    paymentDetailBean.setPD_CUST_NAME(resultSet3
				    .getString(1));
			    paymentDetailBean.setPD_ADDR_01(resultSet3
				    .getString(2));
			    paymentDetailBean.setPD_ADDR_02(resultSet3
				    .getString(3));
			    paymentDetailBean.setPD_ADDR_03(resultSet3
				    .getString(4));
			}
		    }
		}
	    }
	   
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public void m_exp_dt_when_validate_item(PT_IL_PYMT_DTLS paymentDetailBean)
	    throws Exception {

	String pymtModecondition = " I CC C1 C2 C3 C4 C5 C6 ";
	try {
	    // paymentDetailBean.setPD_CC_EXP_DT(
	    // CommonUtils.LAST_DAY(TO_DATE(:PT_IL_PYMT_DTLS.M_EXP_DT,'MM/RR')));
	    /*
	     * EXCEPTION WHEN OTHERS THEN
	     * STD_MESSAGE_ROUTINE(91014,:CTRL.M_LANG_CODE,'Format','MM','YYYY');
	     * RAISE FORM_TRIGGER_FAILURE; END;
	     */

	    // paymentDetailBean.setPD_CC_EXP_DT(
	    // LAST_DAY(TO_DATE(:PT_IL_PYMT_DTLS.M_EXP_DT,'MM/RR')));
	    paymentDetailBean.setPD_CC_EXP_DT(CommonUtils
		    .getLastDateOfTheMonth(paymentDetailBean.getUI_M_EXP_DT()));
	    if (paymentDetailBean.getPD_CC_EXP_DT() != null) {
		if (paymentDetailBean.getPD_CC_EXP_DT().before(
			new CommonUtils().getCurrentDate())) {
		    throw new Exception(Messages.getString(
			    PELConstants.pelErrorMessagePath, "91064",
			    new Object[] { CommonUtils
				    .getGlobalVariable("GLOBAL.M_LANG_CODE") }));
		}
	    }

	    if (paymentDetailBean.getPD_CC_EXP_DT() != null) {
		if (paymentDetailBean.getPD_CC_EXP_DT().after(
			CommonUtils.stringToUtilDate("31/12/2999"))) {
		    // IF :PT_IL_PYMT_DTLS.PD_CC_EXP_DT >
		    // TO_DATE('31/12/2999','DD/MM/RRRR') ){
		    throw new Exception(Messages.getString(
			    PELConstants.pelErrorMessagePath, "91063",
			    new Object[] { CommonUtils
				    .getGlobalVariable("GLOBAL.M_LANG_CODE") }));

		}
	    }

	    String PD_PAY_MODE = paymentDetailBean.getPD_PAY_MODE();
	    if (pymtModecondition.contains(" " + PD_PAY_MODE + " ")
		    && paymentDetailBean.getUI_M_EXP_DT() != null) {
		paymentDetailBean.setUI_M_EXP_DT(paymentDetailBean
			.getPD_CC_EXP_DT());
		/*
		 * paymentDetailBean.setUI_M_EXP_DT((TO_CHAR(:PT_IL_PYMT_DTLS.PD_CC_EXP_DT,'MM')||
		 * '/'||TO_CHAR(:PT_IL_PYMT_DTLS.PD_CC_EXP_DT,'YYYY'));
		 */
	    } else {
		paymentDetailBean.setUI_M_EXP_DT(null);
	    }
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}

    }

    public void m_pd_cc_no_when_validate_item(PT_IL_PYMT_DTLS paymentDetailBean)
	    throws Exception {
	String M_CREDIT_CARD_UPD_YN = null;
	String C1 = " SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N')  FROM MENU_USER  WHERE USER_ID = ";
	ResultSet rs = null;
	Object[] values = {};
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	try {
	    connection = CommonUtils.getConnection();
	    values = new Object[] { CommonUtils.getControlBean().getM_USER_ID() };
	    rs = handler.executeSelectStatement(C1, connection, values);
	    if (rs.next()) {
		M_CREDIT_CARD_UPD_YN = rs.getString(1);
	    }

	    if ("SC".equalsIgnoreCase(paymentDetailBean.getPD_PAY_MODE())) {
		if (paymentDetailBean.getUI_M_PD_CC_NO().length() != 16) {
		    throw new Exception(Messages.getString(
			    PELConstants.pelErrorMessagePath, "92080",
			    new Object[] { CommonUtils
				    .getGlobalVariable("GLOBAL.M_LANG_CODE") }));
		} else {
		    if (!"XXXXXXXXXXXX".equalsIgnoreCase(CommonUtils.SUBSTR(
			    paymentDetailBean.getUI_M_PD_CC_NO(), 1, 12))) {
			int i = 1;
			do {
			    if (CommonUtils.SUBSTR(
				    paymentDetailBean.getUI_M_PD_CC_NO(), i, 1)
				    .charAt(0) < 48
				    || CommonUtils.SUBSTR(
					    paymentDetailBean
						    .getUI_M_PD_CC_NO(), i, 1)
					    .charAt(0) > 57) {

				/*
				 * ASCII(SUBSTR(:PT_IL_PYMT_DTLS.M_PD_CC_NO_1,I,1))<48
				 * OR
				 * ASCII(SUBSTR(:PT_IL_PYMT_DTLS.M_PD_CC_NO_1,I,1))>57
				 * THEN
				 */
				throw new Exception(
					Messages
						.getString(
							PELConstants.pelErrorMessagePath,
							"3206",
							new Object[] {
								CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE"),
								"Invalid Credit Card Number Entered" }));
			    }

			} while (i <= paymentDetailBean.getUI_M_PD_CC_NO()
				.length());

			/*
			 * FOR I IN 1..LENGTH(:PT_IL_PYMT_DTLS.M_PD_CC_NO) LOOP
			 * IF ASCII(SUBSTR(:PT_IL_PYMT_DTLS.M_PD_CC_NO,I,1))<48
			 * OR ASCII(SUBSTR(:PT_IL_PYMT_DTLS.M_PD_CC_NO,I,1))>57
			 * THEN
			 * STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,'Invalid
			 * Credit Card Number Entered'); RAISE
			 * FORM_TRIGGER_FAILURE; END IF; END LOOP;
			 */
		    }
		}
	    }

	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}

    }

    public void whenValidatePD_REMARKS(DUMMY dummyBean,
	    PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) throws Exception {
	try {
	    dummyBean.setPD_REMARKS(PT_IL_PYMT_DTLS_BEAN.getPD_REMARKS());
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());

	}

    }

    public void whenValidatePD_ADDR_03(DUMMY dummyBean,
	    PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) throws Exception {
	try {
	    dummyBean.setPD_ADDR_03(PT_IL_PYMT_DTLS_BEAN.getPD_ADDR_03());
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public void whenValidatePD_ADDR_02(DUMMY dummyBean,
	    PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) throws Exception {
	try {
	    dummyBean.setPD_ADDR_02(PT_IL_PYMT_DTLS_BEAN.getPD_ADDR_02());
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public void whenValidatePD_ADDR_01(DUMMY dummyBean,
	    PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) throws Exception {
	try {
	    dummyBean.setPD_ADDR_01(PT_IL_PYMT_DTLS_BEAN.getPD_ADDR_01());
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public void whenValidatePD_CUST_NAME(DUMMY dummyBean,
	    PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) throws Exception {
	try {
	    if (PT_IL_PYMT_DTLS_BEAN.getPD_CUST_NAME() != null) {
		dummyBean.setPD_CUST_NAME(PT_IL_PYMT_DTLS_BEAN
			.getPD_CUST_NAME());
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public void whenValidatePD_BANK_NAME(PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN)
	    throws Exception {
	Connection connection = null;
	ResultSet resultSet = null;
	CRUDHandler handler = new CRUDHandler();
	String Cursor_c1 = "SELECT DECODE( ? ,'ENG',BANK_NAME,BANK_NAME_BL) , "
		+ "  BANK_BR_CODE FROM FM_BANK WHERE  BANK_CODE= ?";
	try {
	    connection = CommonUtils.getConnection();

	    if (PT_IL_PYMT_DTLS_BEAN.getPD_BANK_NAME() != null) {
		resultSet = handler.executeSelectStatement(Cursor_c1,
			connection, new Object[] {
				CommonUtils.getControlBean().getM_LANG_CODE(),
				PT_IL_PYMT_DTLS_BEAN.getPD_BANK_NAME() });
		if (resultSet.next()) {
		    PT_IL_PYMT_DTLS_BEAN.setUI_M_BANK_NAME_DESC(resultSet
			    .getString(1));
		    PT_IL_PYMT_DTLS_BEAN.setPD_BRANCH_NAME(resultSet
			    .getString(2));
		} else {
		    throw new Exception(
			    Messages
				    .getString(
					    PELConstants.pelErrorMessagePath,
					    "3206",
					    new Object[] {
						    CommonUtils
							    .getGlobalVariable("GLOBAL.M_LANG_CODE"),
						    "Invalid Bank . Please re-enter.." }));
		}
	    } else {
		PT_IL_PYMT_DTLS_BEAN.setUI_M_BANK_NAME_DESC(null);
	    }
	} catch (DBException e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} catch (SQLException e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} finally {
	    try {
		CommonUtils.closeCursor(resultSet);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}

    }

    public void whenValidatePD_PAYIN_DATE(Date PD_PAYIN_DATE) throws Exception {
	try {
	    if (PD_PAYIN_DATE.after(new CommonUtils().getCurrentDate())) {
		throw new Exception(
			"PAY IN DATE CANNOT BE GREATER THAN SYSDATE");
	    }
	} catch (ParseException e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public void whenValidateM_PD_CC_APP_CODE(String M_PD_CC_APP_CODE,
	    PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) throws Exception {

	try {
	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_APP_CODE(CommonUtils.lpad(
		    M_PD_CC_APP_CODE, 6, "0"));
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public String M_BUT_MORE_WHEN_BUTTON_PRESSED(PT_IL_PYMT_DTLS pt_il_pymt_dtls) {
    	String pymtModecondition = " I CC C1 C2 C3 C4 C5 C6 ";
    	String outCome = "PT_IL_PYMT_DTLS";
	    
    	try {
		    String PD_PAY_MODE = pt_il_pymt_dtls.getPD_PAY_MODE();
		    if (pymtModecondition.contains(" " + PD_PAY_MODE + " ")){
			outCome = "PT_IL_PYMT_DTLS_1";
		    } 
		    if ("TT".equals(pt_il_pymt_dtls.getPD_PAY_MODE())) {
		    	outCome = "PT_IL_PYMT_DTLS_2";
		    } 
		    if ("BC".equals(pt_il_pymt_dtls.getPD_PAY_MODE())) {
		    	outCome = "PT_IL_PYMT_DTLS_3";
		    } 
		    if ("PM".equals(pt_il_pymt_dtls.getPD_PAY_MODE())) {
		    	outCome = "PT_IL_PYMT_DTLS_4";
		    }
		    if ("EF".equals(pt_il_pymt_dtls.getPD_PAY_MODE())) {
			outCome = "PT_IL_PYMT_DTLS_5";
		    }
		    if ("AD".equals(pt_il_pymt_dtls.getPD_PAY_MODE())) {
			outCome = "PT_IL_PYMT_DTLS_6";
		    } 
		    if ("SC".equals(pt_il_pymt_dtls.getPD_PAY_MODE())) {
		    	outCome = "PT_IL_PYMT_DTLS_7";
		    } 
		    if ("A".equals(pt_il_pymt_dtls.getPD_PAY_MODE())) {
		    	outCome = "PT_IL_PYMT_DTLS_8";
		    }
		    if ("BS".equals(pt_il_pymt_dtls.getPD_PAY_MODE())) {
			outCome = "PT_IL_PYMT_DTLS_2";
		    } 
	} catch (Exception e) {
		e.printStackTrace();
	}
	return outCome;
    }

	


    public void pilp002_apac_pt_il_pymt_dtls_post_query(
	    PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) {

	String C1 = "	SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N')  FROM MENU_USER  WHERE  USER_ID = ? ";
	String queryEncrypt = " SELECT F_CC_ENCRYPT(?,?,?,?) FROM DUAL ";
	ResultSet resultSet = null;
	String M_CREDIT_CARD_UPD_YN = null;
	Object[] values = {};

	try {
	    if (PT_IL_PYMT_DTLS_BEAN.getPD_CURR_CODE() != null) {
		ArrayList<String> list = P_VAL_CURR.callP_VAL_CURR(CommonUtils.getConnection(),
			PT_IL_PYMT_DTLS_BEAN.getPD_CURR_CODE(), "N", "W", "");
		if (list != null & list.size() > 0) {
		    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CURR_CODE_DESC(list.get(0));
		    // COMP_UI_M_PD_CURR_CODE_DESC.setSubmittedValue(list.get(0));
		}
		// P_SET_FC_NUM_FMT_MASK.P_SET_FC_NUM_FMT_MASK(:PT_IL_PYMT_DTLS.PD_CURR_CODE);
	    }
	    if ("D".equalsIgnoreCase(PT_IL_PYMT_DTLS_BEAN.getPD_PAID_FOR())) {
		PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(PT_IL_PYMT_DTLS_BEAN
			.getPD_LC_AMT());
		PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(0.0);
	    } else {
		PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(PT_IL_PYMT_DTLS_BEAN
			.getPD_LC_AMT());
		PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(0.0);
	    }
	    if ("I".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "CC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "C1".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "C2".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "C3".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "C4".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "C5".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "C6".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setUI_M_EXP_DT(PT_IL_PYMT_DTLS_BEAN
			.getPD_CC_EXP_DT());
		
		
		
		
		/*
		 * PT_IL_PYMT_DTLS_BEAN.setUI_M_EXP_DT(ConvertFunctions.to_char(
		 * PT_IL_PYMT_DTLS_BEAN.getPD_CC_EXP_DT()
		 * ,"MM/YY")); //chk
		 * PT_IL_PYMT_DTLS_BEAN.setUI_M_EXP_DT(StringFunctions.substr(PT_IL_PYMT_DTLS_BEAN.getUI_M_EXP_DT(),1,2)+
		 * CommonUtils.SUBSTR(
		 * PT_IL_PYMT_DTLS_BEAN.getUI_M_EXP_DT(),4,5));
		 */
	    }
	    if ("BC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setUI_M_OUR_BANK_CODE(PT_IL_PYMT_DTLS_BEAN
			.getPD_OUR_BANK_CODE());
		PT_IL_PYMT_DTLS_BEAN.setPD_CHQ_NO(PT_IL_PYMT_DTLS_BEAN
			.getPD_CHQ_NO());
	    }
	    if ("PM".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN
			.setUI_M_OUR_BANK_CODE_1(PT_IL_PYMT_DTLS_BEAN
				.getPD_OUR_BANK_CODE());
		PT_IL_PYMT_DTLS_BEAN
			.setUI_M_REM_SLIP_GEN_YN(PT_IL_PYMT_DTLS_BEAN
				.getPD_REM_SLIP_GEN_YN());
	    }
	    if ("EF".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN
			.setUI_M_OUR_BANK_CODE_2(PT_IL_PYMT_DTLS_BEAN
				.getPD_OUR_BANK_CODE());
		PT_IL_PYMT_DTLS_BEAN
			.setUI_M_DATE_OF_CREDIT(PT_IL_PYMT_DTLS_BEAN
				.getPD_DATE_OF_CREDIT());
	    }
	    if ("AD".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setUI_M_BANK_REF_NO(PT_IL_PYMT_DTLS_BEAN
			.getPD_BANK_REF_NO());
		PT_IL_PYMT_DTLS_BEAN
			.setUI_M_DATE_OF_CREDIT_1(PT_IL_PYMT_DTLS_BEAN
				.getPD_DATE_OF_CREDIT());
	    }
	    if ("SC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_TYPE(PT_IL_PYMT_DTLS_BEAN
			.getPD_CC_TYPE());
		PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_NO(PT_IL_PYMT_DTLS_BEAN
			.getPD_CC_NO());
		PT_IL_PYMT_DTLS_BEAN
			.setUI_M_PD_CC_APP_CODE(PT_IL_PYMT_DTLS_BEAN
				.getPD_CC_APP_CODE());
		PT_IL_PYMT_DTLS_BEAN.setUI_M_BANK_REF_NO_1(PT_IL_PYMT_DTLS_BEAN
			.getPD_BANK_REF_NO());
		PT_IL_PYMT_DTLS_BEAN
			.setUI_M_DATE_OF_CREDIT_2(PT_IL_PYMT_DTLS_BEAN
				.getPD_DATE_OF_CREDIT());
		 if(PT_IL_PYMT_DTLS_BEAN.getPD_CC_EXP_DT() != null){
		    	/*Newly added by pidugu raj dt: 04-10-2018 for expiry date as suggested by vaitheeswaran*/
				String expDt = (PT_IL_PYMT_DTLS_BEAN.getPD_CC_EXP_DT().toString());
				PT_IL_PYMT_DTLS_BEAN.setPOL_CARD_EXP_DT_MM(expDt.substring(5,7));
				PT_IL_PYMT_DTLS_BEAN.setPOL_CARD_EXP_DT_YY(expDt.substring(2,4));
				/*Newly added by pidugu raj dt: 04-10-2018 for expiry date as suggested by vaitheeswaran*/
		    }
	    }

	    values = new Object[] { CommonUtils.getControlBean().getM_USER_ID() };
	    resultSet = new CRUDHandler().executeSelectStatement(C1,
		    CommonUtils.getConnection(), values);
	    while (resultSet.next()) {
		M_CREDIT_CARD_UPD_YN = resultSet.getString(1);
	    }

	    if (PT_IL_PYMT_DTLS_BEAN.getPD_CC_NO() != null) {

		if ("Y".equals(M_CREDIT_CARD_UPD_YN)
			&& PT_IL_PYMT_DTLS_BEAN.getPD_CC_NO() != null) {
		    values = new Object[] { "X",
			    PT_IL_PYMT_DTLS_BEAN.getPD_SYS_ID(), "D",
			    PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() };
		    resultSet = new CRUDHandler().executeSelectStatement(
			    queryEncrypt, CommonUtils.getConnection(), values);
		    while (resultSet.next()) {
			PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_NO(resultSet
				.getString(1));
		    }
		    // :PT_IL_PYMT_DTLS.M_PD_CC_NO:=
		    // F_CC_ENCRYPT('X',:PT_IL_PYMT_DTLS.PD_SYS_ID,'D',:PT_IL_PYMT_DTLS.PD_PAY_MODE);

		} else if ("N".equals(M_CREDIT_CARD_UPD_YN)
			&& PT_IL_PYMT_DTLS_BEAN.getPD_CC_NO() != null) {
		    values = new Object[] { "X",
			    PT_IL_PYMT_DTLS_BEAN.getPD_SYS_ID(), "D",
			    PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() };
		    resultSet = new CRUDHandler().executeSelectStatement(queryEncrypt, CommonUtils.getConnection(), values);
		    while (resultSet.next()) {
			PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_NO(resultSet.getString(1));
		    }
		    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_NO(CommonUtils.lpad(CommonUtils.SUBSTR(PT_IL_PYMT_DTLS_BEAN.getUI_M_PD_CC_NO(), 13, 16), 16, "X"));
		   
		}
	    }

	    if ("I".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_NO_1(PT_IL_PYMT_DTLS_BEAN.getPD_CC_NO());
	    }
	    if ("A".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setUI_M_BANK_REF_NO_2(PT_IL_PYMT_DTLS_BEAN.getPD_BANK_REF_NO());
	    }
	    if(PT_IL_PYMT_DTLS_BEAN.getPD_CC_EXP_DT() != null){
	    	/*Newly added by pidugu raj dt: 04-10-2018 for expiry date as suggested by vaitheeswaran*/
			String expDt = (PT_IL_PYMT_DTLS_BEAN.getPD_CC_EXP_DT().toString());
			PT_IL_PYMT_DTLS_BEAN.setPOL_CARD_EXP_DT_MM(expDt.substring(5,7));
			PT_IL_PYMT_DTLS_BEAN.setPOL_CARD_EXP_DT_YY(expDt.substring(2,4));
			/*Newly added by pidugu raj dt: 04-10-2018 for expiry date as suggested by vaitheeswaran*/
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
	public ArrayList<OracleParameter> helperP9ILPK_CHEQ_VALIDATION_UPD_REF_ID_PYMT_DTLS(Long P_PD_TXN_SYS_ID, String P_TXN_TYPE) throws SQLException, Exception{ 
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> returnList = new ArrayList<OracleParameter>();
		System.out.println("P_PD_TXN_SYS_ID " + P_PD_TXN_SYS_ID);
		System.out.println("P_TXN_TYPE " + P_TXN_TYPE);
		OracleParameter param1 = new OracleParameter("IN1",
				OracleParameter.DATA_TYPE.LONG,
				OracleParameter.DIRECTION_TYPE.IN, P_PD_TXN_SYS_ID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2",
				OracleParameter.DATA_TYPE.STRING,
				OracleParameter.DIRECTION_TYPE.IN, P_TXN_TYPE);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.executeProc(parameterList, connection,
				"P9ILPK_CHEQ_VALIDATION.UPD_REF_ID_PYMT_DTLS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		/*
		 * while (iterator.hasNext()) { OracleParameter oracleParameter =
		 * iterator.next(); System.out.println("Output value:::" +
		 * oracleParameter.getValue());
		 * returnList.add(oracleParameter.getValue().get); }
		 */
		return returnList;
	}

	/*Added by Janani on 09.06.2018 for FSD_IL_FLA_019 */
	
	public void PD_CURR_CODE_when_validate_item(
			PT_IL_PYMT_DTLS_ACTION pymtDtlAction) throws Exception {

		PT_IL_PYMT_DTLS paymentDetailsBean = pymtDtlAction
				.getPT_IL_PYMT_DTLS_BEAN();

		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String err_msg = null;

		ArrayList<OracleParameter> list1;
		
		try {
			
			list1 = new P9ILPK_DEP_APPROVAL().PR_MULTI_CURRENCY_PREMIUM(CommonUtils.getGlobalObject("GLOBAL.CURR_CODE"),
																		paymentDetailsBean.getPD_CURR_CODE(),
																		paymentDetailsBean.getPD_LC_AMT(),
																		null,
																		null,
																		null);

			if (list1.get(0).getValueObject() != null ) {
				
				paymentDetailsBean.setPD_EXCH_RATE((double) list1.get(0).getValueObject());
			}
			if (list1.get(1).getValueObject() != null) {
				
				paymentDetailsBean.setPD_FC_AMT((double) list1.get(1).getValueObject());
			}
			if (list1.get(2).getValueObject() != null && list1.get(2).getValueObject().equals("N")) {

				throw new Exception("Exchange Rate is not found for the currency code entered");	
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/*Newly added by pidugu raj dt: 01-10-2018 for KIC RECEIPT ENTRY method of collection*/
	public void POL_PYMT_TYPE_WHEN_VALIDATE_ITEM(
			PT_IL_PYMT_DTLS pt_IL_PYMT_DTLS, PT_IL_PYMT_DTLS_ACTION pt_IL_PYMT_DTLS_ACTION) {
		try{
		
		if(pt_IL_PYMT_DTLS.getPD_PAY_MODE().equalsIgnoreCase("SC")){
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDITCARD_TEXT().setDisabled(false);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDIT_HOLDER_TEXT().setDisabled(false);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CVV_NO().setDisabled(false);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDITCARD_LABEL().setValue("Credit Card No:");
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CONT_AD_BANK_CODE_LABEL().setValue("Credit Card Merchant Bank");
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDIT_HOLDER_NAME().setValue("CREDIT HOLDER NAME");
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CARD_EXP_DT_LABEL().setValue("Card Expiry Date");
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CVV_NO_LABEL().setValue("CVV No.");
			
		}
		if(pt_IL_PYMT_DTLS.getPD_PAY_MODE().equalsIgnoreCase("B")){
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDITCARD_TEXT().setDisabled(false);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDIT_HOLDER_TEXT().setDisabled(false);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CVV_NO().setDisabled(false);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDITCARD_LABEL().setValue("Knet Card No.");
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CONT_AD_BANK_CODE_LABEL().setValue("Knet Card Merchant Bank");
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDIT_HOLDER_NAME().setValue("Knet Card Holder Name");
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CARD_EXP_DT_LABEL().setValue("Card Expiry Date");
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CVV_NO_LABEL().setValue("CVV No.");
			
		}
		if(pt_IL_PYMT_DTLS.getPD_PAY_MODE().equalsIgnoreCase("P")){
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDITCARD_LABEL().setValue("Customer A/C No.");
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CONT_AD_BANK_CODE_LABEL().setValue("Bank Name");
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDITCARD_TEXT().setDisabled(true);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDIT_HOLDER_TEXT().setDisabled(true);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CVV_NO().setDisabled(true);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDIT_MERCHANT_BANK().setDisabled(true);
		}
		/*Newly added by pidugu raj dt:16-10-2018 as suggested by sivaraman if employee in  dropdown selected during receipt entry*/
		if(pt_IL_PYMT_DTLS.getPD_PAY_MODE().equalsIgnoreCase("E")){
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDITCARD_LABEL().setValue("Customer A/C No.");
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CONT_AD_BANK_CODE_LABEL().setValue("Bank Name");
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDITCARD_TEXT().setDisabled(true);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDIT_HOLDER_TEXT().setDisabled(true);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CVV_NO().setDisabled(true);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDIT_MERCHANT_BANK().setDisabled(true);
		}
		/*End Newly added by pidugu raj dt:16-10-2018 as suggested by sivaraman if employee in  dropdown selected during receipt entry*/
		if(pt_IL_PYMT_DTLS.getPD_PAY_MODE().equalsIgnoreCase("B")){
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDITCARD_TEXT().setDisabled(true);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDIT_HOLDER_TEXT().setDisabled(true);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_POL_CVV_NO().setDisabled(true);
			pt_IL_PYMT_DTLS_ACTION.getCOMP_CREDIT_MERCHANT_BANK().setDisabled(true);
		}
		if(pt_IL_PYMT_DTLS.getPD_PAY_MODE().equalsIgnoreCase("N")){
			throw new Exception("Choose valid Method of collection");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/*End Newly added by pidugu raj dt: 01-10-2018 for KIC RECEIPT ENTRY method of collection*/
	/*public void UI_M_POL_CONT_AD_ACC_NO_WHEN_VALIDATE_ITEM(
			COMPOSITE_ACTION_BEAN compositeAction, Long value) {

		PT_IL_PYMT_DTLS pymt_bean = compositeAction
				.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN();

		ArrayList<OracleParameter> pValList = null;
		try {

			pValList = pkg_pilt002_apac.P_M_POL_CONT_AD_ACC_NO_W_VAL_I(
					pt_il_policy_bean.getPOL_CUST_CODE(), value,
					pt_il_policy_bean.getPOL_PYMT_TYPE(), pt_il_policy_bean
							.getPOL_END_NO_IDX(), pt_il_policy_bean
							.getPOL_END_TYPE(), pt_il_policy_bean
							.getUI_M_POL_CONT_AD_ACC_NO_1());
			if (pValList != null) {
				pt_il_policy_bean
						.setUI_M_POL_CONT_AD_ACC_NO_1((Long) pValList.get(0)
								.getValueObject());

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}*/

	public String doGetBankDesc(String pd_ADDR_02) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String C1 = "SELECT BANK_NAME FROM FM_BANK WHERE BANK_CODE = ?";
		Object[] values = null;
		String bankDesc = null;
		try{
			values = new Object[] {pd_ADDR_02 }; 
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					    CommonUtils.getConnection(), values);
				    while (resultSet.next()) {
				    	bankDesc = resultSet.getString(1);
				    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return bankDesc;
		
	}
	
	 /*End*/
	
}
