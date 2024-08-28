package com.iii.pel.forms.PILT005;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.NumberConverter;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.utl_smtp.connection;

public class PT_IL_LOAN_ACTION extends CommonAction {

	private NumberConverter conv;

	private HtmlOutputLabel COMP_UI_M_APPRV_STATUS;

	private HtmlOutputLabel COMP_LOAN_REF_NO_LABEL;

	private HtmlInputText COMP_LOAN_REF_NO;

	private HtmlOutputLabel COMP_UI_M_ASSURED_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ASSURED_NAME;

	private HtmlOutputLabel COMP_LOAN_DT_LABEL;

	private HtmlCalendar COMP_LOAN_DT;

	private HtmlOutputLabel COMP_LOAN_FC_AMOUNT_LABEL;

	private HtmlInputText COMP_LOAN_FC_AMOUNT;

	private HtmlOutputLabel COMP_LOAN_FC_REPAID_AMT_LABEL;

	private HtmlInputText COMP_LOAN_FC_REPAID_AMT;

	private HtmlOutputLabel COMP_UI_M_FC_OS_AMOUNT_LABEL;

	private HtmlInputText COMP_UI_M_FC_OS_AMOUNT;

	private HtmlOutputLabel COMP_LOAN_LC_AMOUNT_LABEL;

	private HtmlInputText COMP_LOAN_LC_AMOUNT;

	private HtmlOutputLabel COMP_LOAN_LC_REPAID_AMT_LABEL;

	private HtmlInputText COMP_LOAN_LC_REPAID_AMT;

	private HtmlOutputLabel COMP_UI_M_LC_OS_AMOUNT_LABEL;

	private HtmlInputText COMP_UI_M_LC_OS_AMOUNT;

	private HtmlCommandButton COMP_UI_M_LOV_LOAN_REF_NO;

	private PT_IL_LOAN PT_IL_LOAN_BEAN;
	

	FacesContext facesCtx = null;

	private HtmlOutputText COMP_LOAN_DISBURSAL_STATUS;
	Map<String, Object> sessionMap = null;
	HttpSession session = null;
	CRUDHandler handler = new CRUDHandler();

	// Connection con = null;

	/* Variables Required For PreForm */

	public Map<String, Object> getSessionMap() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	/* Variables Required For PreForm */

	public PT_IL_LOAN_ACTION() {
		PT_IL_LOAN_BEAN = new PT_IL_LOAN();
		// sessionMap = getSessionMap();
	}

	public HtmlOutputLabel getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputLabel COMP_UI_M_APPRV_STATUS) {
		this.COMP_UI_M_APPRV_STATUS = COMP_UI_M_APPRV_STATUS;
	}

	public HtmlOutputLabel getCOMP_LOAN_REF_NO_LABEL() {
		return COMP_LOAN_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_REF_NO() {
		return COMP_LOAN_REF_NO;
	}

	public void setCOMP_LOAN_REF_NO_LABEL(HtmlOutputLabel COMP_LOAN_REF_NO_LABEL) {
		this.COMP_LOAN_REF_NO_LABEL = COMP_LOAN_REF_NO_LABEL;
	}

	public void setCOMP_LOAN_REF_NO(HtmlInputText COMP_LOAN_REF_NO) {
		this.COMP_LOAN_REF_NO = COMP_LOAN_REF_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_ASSURED_NAME_LABEL() {
		return COMP_UI_M_ASSURED_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ASSURED_NAME() {
		return COMP_UI_M_ASSURED_NAME;
	}

	public void setCOMP_UI_M_ASSURED_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ASSURED_NAME_LABEL) {
		this.COMP_UI_M_ASSURED_NAME_LABEL = COMP_UI_M_ASSURED_NAME_LABEL;
	}

	public void setCOMP_UI_M_ASSURED_NAME(HtmlInputText COMP_UI_M_ASSURED_NAME) {
		this.COMP_UI_M_ASSURED_NAME = COMP_UI_M_ASSURED_NAME;
	}

	public HtmlOutputLabel getCOMP_LOAN_DT_LABEL() {
		return COMP_LOAN_DT_LABEL;
	}

	public HtmlCalendar getCOMP_LOAN_DT() {
		return COMP_LOAN_DT;
	}

	public void setCOMP_LOAN_DT_LABEL(HtmlOutputLabel COMP_LOAN_DT_LABEL) {
		this.COMP_LOAN_DT_LABEL = COMP_LOAN_DT_LABEL;
	}

	public void setCOMP_LOAN_DT(HtmlCalendar COMP_LOAN_DT) {
		this.COMP_LOAN_DT = COMP_LOAN_DT;
	}

	public HtmlOutputLabel getCOMP_LOAN_FC_AMOUNT_LABEL() {
		return COMP_LOAN_FC_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_FC_AMOUNT() {
		return COMP_LOAN_FC_AMOUNT;
	}

	public void setCOMP_LOAN_FC_AMOUNT_LABEL(
			HtmlOutputLabel COMP_LOAN_FC_AMOUNT_LABEL) {
		this.COMP_LOAN_FC_AMOUNT_LABEL = COMP_LOAN_FC_AMOUNT_LABEL;
	}

	public void setCOMP_LOAN_FC_AMOUNT(HtmlInputText COMP_LOAN_FC_AMOUNT) {
		this.COMP_LOAN_FC_AMOUNT = COMP_LOAN_FC_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_LOAN_FC_REPAID_AMT_LABEL() {
		return COMP_LOAN_FC_REPAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_FC_REPAID_AMT() {
		return COMP_LOAN_FC_REPAID_AMT;
	}

	public void setCOMP_LOAN_FC_REPAID_AMT_LABEL(
			HtmlOutputLabel COMP_LOAN_FC_REPAID_AMT_LABEL) {
		this.COMP_LOAN_FC_REPAID_AMT_LABEL = COMP_LOAN_FC_REPAID_AMT_LABEL;
	}

	public void setCOMP_LOAN_FC_REPAID_AMT(HtmlInputText COMP_LOAN_FC_REPAID_AMT) {
		this.COMP_LOAN_FC_REPAID_AMT = COMP_LOAN_FC_REPAID_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_OS_AMOUNT_LABEL() {
		return COMP_UI_M_FC_OS_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_OS_AMOUNT() {
		return COMP_UI_M_FC_OS_AMOUNT;
	}

	public void setCOMP_UI_M_FC_OS_AMOUNT_LABEL(
			HtmlOutputLabel COMP_UI_M_FC_OS_AMOUNT_LABEL) {
		this.COMP_UI_M_FC_OS_AMOUNT_LABEL = COMP_UI_M_FC_OS_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_FC_OS_AMOUNT(HtmlInputText COMP_UI_M_FC_OS_AMOUNT) {
		this.COMP_UI_M_FC_OS_AMOUNT = COMP_UI_M_FC_OS_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_AMOUNT_LABEL() {
		return COMP_LOAN_LC_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_LC_AMOUNT() {
		return COMP_LOAN_LC_AMOUNT;
	}

	public void setCOMP_LOAN_LC_AMOUNT_LABEL(
			HtmlOutputLabel COMP_LOAN_LC_AMOUNT_LABEL) {
		this.COMP_LOAN_LC_AMOUNT_LABEL = COMP_LOAN_LC_AMOUNT_LABEL;
	}

	public void setCOMP_LOAN_LC_AMOUNT(HtmlInputText COMP_LOAN_LC_AMOUNT) {
		this.COMP_LOAN_LC_AMOUNT = COMP_LOAN_LC_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_REPAID_AMT_LABEL() {
		return COMP_LOAN_LC_REPAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_LC_REPAID_AMT() {
		return COMP_LOAN_LC_REPAID_AMT;
	}

	public void setCOMP_LOAN_LC_REPAID_AMT_LABEL(
			HtmlOutputLabel COMP_LOAN_LC_REPAID_AMT_LABEL) {
		this.COMP_LOAN_LC_REPAID_AMT_LABEL = COMP_LOAN_LC_REPAID_AMT_LABEL;
	}

	public void setCOMP_LOAN_LC_REPAID_AMT(HtmlInputText COMP_LOAN_LC_REPAID_AMT) {
		this.COMP_LOAN_LC_REPAID_AMT = COMP_LOAN_LC_REPAID_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_OS_AMOUNT_LABEL() {
		return COMP_UI_M_LC_OS_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_OS_AMOUNT() {
		return COMP_UI_M_LC_OS_AMOUNT;
	}

	public void setCOMP_UI_M_LC_OS_AMOUNT_LABEL(
			HtmlOutputLabel COMP_UI_M_LC_OS_AMOUNT_LABEL) {
		this.COMP_UI_M_LC_OS_AMOUNT_LABEL = COMP_UI_M_LC_OS_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_LC_OS_AMOUNT(HtmlInputText COMP_UI_M_LC_OS_AMOUNT) {
		this.COMP_UI_M_LC_OS_AMOUNT = COMP_UI_M_LC_OS_AMOUNT;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_LOAN_REF_NO() {
		return COMP_UI_M_LOV_LOAN_REF_NO;
	}

	public void setCOMP_UI_M_LOV_LOAN_REF_NO(
			HtmlCommandButton COMP_UI_M_LOV_LOAN_REF_NO) {
		this.COMP_UI_M_LOV_LOAN_REF_NO = COMP_UI_M_LOV_LOAN_REF_NO;
	}

	public PT_IL_LOAN getPT_IL_LOAN_BEAN() {
		return PT_IL_LOAN_BEAN;
	}

	public void setPT_IL_LOAN_BEAN(PT_IL_LOAN PT_IL_LOAN_BEAN) {
		this.PT_IL_LOAN_BEAN = PT_IL_LOAN_BEAN;
	}

	public NumberConverter getConv() {
		return conv;
	}

	public void setConv(NumberConverter conv) {
		this.conv = conv;
	}

	/* Form-Level Events Starts Here */

	public void onLoad(PhaseEvent pe) {
		PT_IL_LOAN_REPAYMENT_ACTION repayAction = (PT_IL_LOAN_REPAYMENT_ACTION) CommonUtils.getGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION");
		String callingForm = CommonUtils
				.getGlobalVariable("PILT004_CALLING_FORM");
		if (callingForm != null && "PILT004".equals(callingForm)) {
			com.iii.pel.forms.PILT004.PT_IL_LOAN PILT004_PT_IL_LOAN = (com.iii.pel.forms.PILT004.PT_IL_LOAN) CommonUtils
					.getGlobalObject("PILT004_PT_IL_LOAN_BEAN");
			String rowId = PILT004_PT_IL_LOAN.getROWID();
			try {
				if (isBlockFlag()) {
					PT_IL_LOAN_REPAYMENT_ACTION repayBeanAction = new PT_IL_LOAN_REPAYMENT_ACTION();
					CommonUtils.setGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION", repayBeanAction);
					if (rowId != null) {
						executeQuery();
					}
					if (repayBeanAction.getPT_IL_LOAN_REPAYMENT_BEAN()
							.getROWID() != null) {

					} else {
						repayBeanAction.WHEN_CREATE_RECORD(repayBeanAction
								.getPT_IL_LOAN_REPAYMENT_BEAN());
					}
				}
				setBlockFlag(false);
				if("A".equalsIgnoreCase(repayAction.getPT_IL_LOAN_REPAYMENT_BEAN().getLR_STATUS())){
					repayAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				}
			} catch (Exception e) {
				PT_IL_LOAN_REPAYMENT_ACTION repayBeanAction = (PT_IL_LOAN_REPAYMENT_ACTION) CommonUtils.getGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION");
				e.printStackTrace();
				repayBeanAction.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				repayBeanAction.getErrorMap().put("BEFORE_PHASE", e.getMessage());
			}
			
		} else {
			PT_IL_LOAN_ACTION PT_IL_LOAN_ACTION_BEAN = (PT_IL_LOAN_ACTION) CommonUtils
					.getGlobalObject("PT_IL_LOAN_ACTION");
			String rowId = PT_IL_LOAN_ACTION_BEAN.getPT_IL_LOAN_BEAN()
					.getROWID();
			try {
				if (isBlockFlag()) {
					PT_IL_LOAN_REPAYMENT_ACTION repayBeanAction = new PT_IL_LOAN_REPAYMENT_ACTION();
					CommonUtils.setGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION", repayBeanAction);
					if (rowId != null) {
						executeQuery();
					}
					if (repayBeanAction.getPT_IL_LOAN_REPAYMENT_BEAN()
							.getROWID() != null) {

					} else {
						repayBeanAction.WHEN_CREATE_RECORD(repayBeanAction
								.getPT_IL_LOAN_REPAYMENT_BEAN());
					}
				}
				setBlockFlag(false);
				if("A".equalsIgnoreCase(repayAction.getPT_IL_LOAN_REPAYMENT_BEAN().getLR_STATUS())){
					repayAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				}
			} catch (Exception e) {
				PT_IL_LOAN_REPAYMENT_ACTION repayBeanAction = (PT_IL_LOAN_REPAYMENT_ACTION) CommonUtils.getGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION");
				e.printStackTrace();
				repayBeanAction.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				repayBeanAction.getErrorMap().put("BEFORE_PHASE", e.getMessage());
			}
		}
	}

	/**
	 * Disables all components in PT_IL_LOAN_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_LOAN_REF_NO.setDisabled(disabled);
		COMP_UI_M_ASSURED_NAME.setDisabled(disabled);
		COMP_LOAN_FC_AMOUNT.setDisabled(disabled);
		COMP_LOAN_FC_REPAID_AMT.setDisabled(disabled);
		COMP_UI_M_FC_OS_AMOUNT.setDisabled(disabled);
		COMP_LOAN_LC_AMOUNT.setDisabled(disabled);
		COMP_LOAN_LC_REPAID_AMT.setDisabled(disabled);
		COMP_UI_M_LC_OS_AMOUNT.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_LOAN_DT.setDisabled(disabled);

		/*// Disabling HtmlCommandButton
		COMP_UI_M_LOV_LOAN_REF_NO.setDisabled(disabled);*/

	}



	public void executeQuery() throws Exception {
		try {
			executeSelectStatement();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void executeSelectStatement() throws Exception {
		
		String selectStatement = "SELECT ROWID,PT_IL_LOAN.* FROM PT_IL_LOAN WHERE NVL(LOAN_STATUS,'N') IN ('A', 'C') "
				+ " AND ROWID = ?";
		
		String rowId = null;
		
		if("PILT004".equalsIgnoreCase(CommonUtils.getGlobalVariable("PILT004_CALLING_FORM"))){
			com.iii.pel.forms.PILT004.PT_IL_LOAN_ACTION PT_IL_LOAN_ACTION_BEAN = (com.iii.pel.forms.PILT004.PT_IL_LOAN_ACTION) CommonUtils
			.getGlobalObject("PILT004_PT_IL_LOAN_ACTION");
			rowId = PT_IL_LOAN_ACTION_BEAN.getPT_IL_LOAN_BEAN().getROWID();
		}
		else{
			PT_IL_LOAN_ACTION PT_IL_LOAN_ACTION_BEAN = (PT_IL_LOAN_ACTION) CommonUtils
			.getGlobalObject("PT_IL_LOAN_ACTION");
			rowId = PT_IL_LOAN_ACTION_BEAN.getPT_IL_LOAN_BEAN().getROWID();
		}
		Connection connection = null;
		ResultSet resultSet = null;
		String M_CUST_CURR_CODE = null;
		String M_CURR_RATE_BS = null;
		Double LOAN_EXCH_RATE = 0.0;
		String M_POL_DS_CODE = null;
		Date LR_PYMT_DT = null;
		Double LR_FC_PYMT_AMT = 0.0;
		Double LR_LC_PYMT_AMT = 0.0;
		Double LR_FC_INT_AMT = 0.0;
		Double LR_LC_INT_AMT = 0.0;
		Double LR_FC_LOAN_AMT = 0.0;
		Double LR_LC_LOAN_AMT = 0.0;
		Date LR_REPAY_PAID_DT = null;
		String LR_PYMT_REF_NO = null;
		String LR_SYS_ID = null;
		String LR_STATUS = null;
		
		/*Newly Added by Dhinesh on 10.3.2017*/
		Date    LR_CR_DT = null;
		String LR_FLAG = null;
		String LR_CR_UID = null;
		/*End*/
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map sessionMap = ctx.getExternalContext().getSessionMap();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext()
				.getRequest();
		try {
			connection = CommonUtils.getConnection();

			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { rowId });
			
			PT_IL_LOAN PT_IL_LOAN_BEAN = new PT_IL_LOAN();
			while (resultSet.next()) {
				PT_IL_LOAN_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_LOAN_BEAN.setLOAN_SYS_ID(resultSet
						.getDouble("LOAN_SYS_ID"));
				PT_IL_LOAN_BEAN.setLOAN_POL_NO(resultSet
						.getString("LOAN_POL_NO"));
				PT_IL_LOAN_BEAN.setLOAN_POL_SYS_ID(resultSet
						.getDouble("LOAN_POL_SYS_ID"));
				PT_IL_LOAN_BEAN.setLOAN_DT(resultSet.getDate("LOAN_DT"));
				PT_IL_LOAN_BEAN.setLOAN_REF_NO(resultSet
						.getString("LOAN_REF_NO"));
				PT_IL_LOAN_BEAN.setLOAN_LC_AMOUNT(resultSet
						.getDouble("LOAN_LC_AMOUNT"));
				PT_IL_LOAN_BEAN.setLOAN_FC_AMOUNT(resultSet
						.getDouble("LOAN_FC_AMOUNT"));
				PT_IL_LOAN_BEAN.setLOAN_LC_REPAID_AMT(resultSet
						.getDouble("LOAN_LC_REPAID_AMT"));
				PT_IL_LOAN_BEAN.setLOAN_FC_REPAID_AMT(resultSet
						.getDouble("LOAN_FC_REPAID_AMT"));
				
				//------------------------------Newly added below code on 1.3.2017 by Dhinesh   ------------------------------

				PT_IL_LOAN_BEAN.setLOAN_EXCH_RATE(resultSet
						.getDouble("LOAN_EXCH_RATE"));
				LOAN_EXCH_RATE =PT_IL_LOAN_BEAN.getLOAN_EXCH_RATE();
				
				//----------------------------------- End ----------------------------------------------------
			}
			//------------------------------Newly added below code on 3.3.2017 by Dhinesh   ------------------------------
			CommonUtils.setGlobalVariable("LOAN_EXCH_RATE", (LOAN_EXCH_RATE+""));
			//----------------------------------- End ----------------------------------------------------
			
			/*Added By Sankar 23.3.2016 for Loan Repayment*/
			executetoglepanel(connection,PT_IL_LOAN_BEAN,PT_IL_LOAN_BEAN.getLOAN_REF_NO());
			/*End*/
			if (PT_IL_LOAN_BEAN.getLOAN_POL_SYS_ID() != null) {
				String Query = "SELECT POL_ASSURED_NAME,POL_CUST_CURR_CODE,POL_DS_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ? ";
				Object[] values2 = { PT_IL_LOAN_BEAN.getLOAN_POL_SYS_ID() };
				ResultSet rs2 = handler.executeSelectStatement(Query, connection,
						values2);
				if (rs2.next()) {
					PT_IL_LOAN_BEAN.setUI_M_ASSURED_NAME(rs2
							.getString("POL_ASSURED_NAME"));
					M_CUST_CURR_CODE = rs2.getString("POL_CUST_CURR_CODE");
					M_POL_DS_CODE = rs2.getString("POL_DS_CODE");
					// sessionMap.put("M_CUST_CURR_CODE", M_CUST_CURR_CODE);
					CommonUtils.setGlobalVariable("M_CUST_CURR_CODE",
							M_CUST_CURR_CODE);
				}

				if (M_POL_DS_CODE != null) {
					String Query3 = "SELECT DS_CURR_RATE_BS  FROM   PM_IL_DOC_SETUP WHERE  DS_TYPE = '2' AND DS_CODE = ?";
					Object[] values3 = { M_POL_DS_CODE };
					ResultSet rs3 = handler.executeSelectStatement(Query3, connection,
							values3);
					if (rs3.next()) {
						M_CURR_RATE_BS = rs3.getString("DS_CURR_RATE_BS");
						sessionMap.put("M_CURR_RATE_BS", M_CURR_RATE_BS);
					}
				}
			}
			String query3 = "select A.LR_PYMT_DT,A.LR_FC_PYMT_AMT,A.LR_LC_PYMT_AMT,"
				+ "A.LR_FC_INT_AMT,A.LR_LC_INT_AMT,A.LR_FC_LOAN_AMT,"
				+ "A.LR_LC_LOAN_AMT,A.LR_PYMT_REF_NO,A.ROWID,A.LR_LOAN_SYS_ID,A.LR_SYS_ID,A.LR_STATUS,A.LR_REPAY_PAID_DT,A.LR_FLAG,A.LR_CR_DT,A.LR_CR_UID  "
				+ "FROM PT_IL_LOAN_REPAYMENT A,PT_IL_LOAN B where A.LR_LOAN_SYS_ID = B.LOAN_SYS_ID AND B.LOAN_REF_NO = ?";
		connection = CommonUtils.getConnection();
		Object[] values_ref_no = { PT_IL_LOAN_BEAN.getLOAN_REF_NO() };
		ResultSet rs123 = handler.executeSelectStatement(query3, connection,
				values_ref_no);

		PT_IL_LOAN_REPAYMENT_ACTION repayBeanAction = (PT_IL_LOAN_REPAYMENT_ACTION) CommonUtils.getGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION");
		List<PT_IL_LOAN_REPAYMENT> testList = repayBeanAction
				.getGridDisplay();
		testList.clear();
		while (rs123.next()) {
			PT_IL_LOAN_REPAYMENT repayBean = new PT_IL_LOAN_REPAYMENT();
			LR_PYMT_DT = rs123.getDate(1);
			LR_FC_PYMT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(2)),
					0.0);
			LR_LC_PYMT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(3)),
					0.0);
			LR_FC_INT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(4)),
					0.0);
			LR_LC_INT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(5)),
					0.0);
			LR_FC_LOAN_AMT = NVLDouble(Double.valueOf(rs123.getDouble(6)),
					0.0);
			LR_LC_LOAN_AMT = NVLDouble(Double.valueOf(rs123.getDouble(7)),
					0.0);
			LR_PYMT_REF_NO = rs123.getString(8);
			LR_SYS_ID = rs123.getString(11);
			LR_STATUS = rs123.getString(12);
			LR_REPAY_PAID_DT = rs123.getDate(13);
			
			/*Newly added by Dhinesh on 10.3.2017*/
			LR_FLAG   = rs123.getString(14);
			LR_CR_DT  = rs123.getTimestamp(15);
			LR_CR_UID = rs123.getString(16);
			/*End*/
			
			repayBean.setLR_PYMT_DT(LR_PYMT_DT);
			repayBean.setLR_FC_PYMT_AMT(LR_FC_PYMT_AMT);
			repayBean.setLR_LC_PYMT_AMT(LR_LC_PYMT_AMT);
			repayBean.setLR_FC_INT_AMT(LR_FC_INT_AMT);
			repayBean.setLR_LC_INT_AMT(LR_LC_INT_AMT);
			repayBean.setLR_FC_LOAN_AMT(LR_FC_LOAN_AMT);
			repayBean.setLR_LC_LOAN_AMT(LR_LC_LOAN_AMT);
			repayBean.setLR_PYMT_REF_NO(LR_PYMT_REF_NO);
			repayBean.setROWID(rs123.getString(9));
			repayBean.setLR_LOAN_SYS_ID(rs123.getDouble(10));
			repayBean.setLR_SYS_ID(rs123.getLong(11));
			repayBean.setLR_STATUS(LR_STATUS);
			repayBean.setLR_REPAY_PAID_DT(LR_REPAY_PAID_DT);
			if("N".equalsIgnoreCase(CommonUtils.nvl(repayBean.getLR_STATUS(),"N"))){
				repayBean.setUI_M_LOAN_STATUS("Not Approved");
			}else if("A".equalsIgnoreCase(CommonUtils.nvl(repayBean.getLR_STATUS(),"N"))){
				repayBean.setUI_M_LOAN_STATUS("Approved");
			}
			/*Newly added by Dhinesh on 10.3.2017*/
			repayBean.setLR_FLAG(LR_FLAG);
			repayBean.setLR_CR_DT(LR_CR_DT);
			repayBean.setLR_CR_UID(LR_CR_UID);
			/*End*/
			testList.add(repayBean);

		}

		repayBeanAction.setBeanList(testList);
		System.out.println("---------------------->Repay list size: "
				+ testList.size());
		// sessionMap.put("PILT005_PT_IL_LOAN_REPAYMENT_ACTION",
		// repayBeanAction);
		/*CommonUtils.setGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION",
				repayBeanAction);*/

		Double M_FC_OS_AMOUNT = 0.0;
		M_FC_OS_AMOUNT = (NVLDouble(PT_IL_LOAN_BEAN.getLOAN_FC_AMOUNT(), 0.0) - NVLDouble(
				PT_IL_LOAN_BEAN.getLOAN_FC_REPAID_AMT(), 0.0));
		sessionMap.put("M_FC_OS_AMOUNT", M_FC_OS_AMOUNT);
		// CommonUtils.setGlobalVariable("M_FC_OS_AMOUNT",
		// M_FC_OS_AMOUNT+"");

		Double M_LC_OS_AMOUNT = 0.0;
		M_LC_OS_AMOUNT = (NVLDouble(PT_IL_LOAN_BEAN.getLOAN_LC_AMOUNT(), 0.0) - NVLDouble(
				PT_IL_LOAN_BEAN.getLOAN_LC_REPAID_AMT(), 0.0));
		sessionMap.put("M_LC_OS_AMOUNT", M_LC_OS_AMOUNT);

		PT_IL_LOAN_BEAN.setUI_M_FC_OS_AMOUNT(M_FC_OS_AMOUNT);
		PT_IL_LOAN_BEAN.setUI_M_LC_OS_AMOUNT(M_LC_OS_AMOUNT);
		sessionMap.put("PILT005_PT_IL_LOAN_ACTION", this);
		CommonUtils.setGlobalObject("PILT005_PT_IL_LOAN_ACTION",
				this);

		// Logic For Default Population
		PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN = null;
		Iterator<PT_IL_LOAN_REPAYMENT> it = testList.iterator();

		while (it.hasNext()) {
			PT_IL_LOAN_REPAYMENT_BEAN = it.next();
			PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(false);
		}
		// actionBean.setDataTableList(outputList);
		if (testList.size() > 0) {
			repayBeanAction.setPT_IL_LOAN_REPAYMENT_BEAN(testList.get(0));
			repayBeanAction.getPT_IL_LOAN_REPAYMENT_BEAN().setRowSelected(
					true);
		}
			this.setPT_IL_LOAN_BEAN(PT_IL_LOAN_BEAN);
			CommonUtils.setGlobalObject("LOAN_DT", PT_IL_LOAN_BEAN.getLOAN_DT());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception(exception.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	public void loanRepaymentExecuteQuery() throws Exception{
		Date LR_PYMT_DT = null;
		Double LR_FC_PYMT_AMT = 0.0;
		Double LR_LC_PYMT_AMT = 0.0;
		Double LR_FC_INT_AMT = 0.0;
		Double LR_LC_INT_AMT = 0.0;
		Double LR_FC_LOAN_AMT = 0.0;
		Double LR_LC_LOAN_AMT = 0.0;
		String LR_PYMT_REF_NO = null;
		String LR_SYS_ID = null;
		String LR_STATUS = null;
		
		/*Newly added by Dhinesh on 10.3.2017*/
		Date    LR_CR_DT = null;
		String LR_FLAG = null;
		String LR_CR_UID = null;
		/*End*/
		
		Connection connection = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map sessionMap = ctx.getExternalContext().getSessionMap();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext()
				.getRequest();
		PT_IL_LOAN_ACTION pt_il_loan_action = new PT_IL_LOAN_ACTION();
		PT_IL_LOAN loanbean = pt_il_loan_action.getPT_IL_LOAN_BEAN();

		try {
			String query3 = "select A.LR_PYMT_DT,A.LR_FC_PYMT_AMT,A.LR_LC_PYMT_AMT,"
					+ "A.LR_FC_INT_AMT,A.LR_LC_INT_AMT,A.LR_FC_LOAN_AMT,"
					+ "A.LR_LC_LOAN_AMT,A.LR_PYMT_REF_NO,A.ROWID,A.LR_LOAN_SYS_ID,A.LR_SYS_ID,A.LR_STATUS,A.LR_FLAG,A.LR_CR_DT,A.LR_CR_UID  "
					+ "FROM PT_IL_LOAN_REPAYMENT A,PT_IL_LOAN B where A.LR_LOAN_SYS_ID = B.LOAN_SYS_ID AND B.LOAN_REF_NO = ?";
			connection = CommonUtils.getConnection();
			Object[] values_ref_no = { loanbean.getLOAN_REF_NO() };
			ResultSet rs123 = handler.executeSelectStatement(query3, connection,
					values_ref_no);

			PT_IL_LOAN_REPAYMENT_ACTION repayBeanAction = new PT_IL_LOAN_REPAYMENT_ACTION();
			List<PT_IL_LOAN_REPAYMENT> testList = repayBeanAction
					.getGridDisplay();
			testList.clear();
			while (rs123.next()) {
				PT_IL_LOAN_REPAYMENT repayBean = new PT_IL_LOAN_REPAYMENT();
				LR_PYMT_DT = rs123.getDate(1);
				LR_FC_PYMT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(2)),
						0.0);
				LR_LC_PYMT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(3)),
						0.0);
				LR_FC_INT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(4)),
						0.0);
				LR_LC_INT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(5)),
						0.0);
				LR_FC_LOAN_AMT = NVLDouble(Double.valueOf(rs123.getDouble(6)),
						0.0);
				LR_LC_LOAN_AMT = NVLDouble(Double.valueOf(rs123.getDouble(7)),
						0.0);
				LR_PYMT_REF_NO = rs123.getString(8);
				LR_SYS_ID = rs123.getString(11);
				LR_STATUS = rs123.getString(12);
				/*Newly added by Dhinesh on 10.3.2017*/
				LR_FLAG   = rs123.getString(13);
				LR_CR_DT  = rs123.getTimestamp(14);
				LR_CR_UID   = rs123.getString(15);
				/*End*/
				repayBean.setLR_PYMT_DT(LR_PYMT_DT);
				repayBean.setLR_FC_PYMT_AMT(LR_FC_PYMT_AMT);
				repayBean.setLR_LC_PYMT_AMT(LR_LC_PYMT_AMT);
				repayBean.setLR_FC_INT_AMT(LR_FC_INT_AMT);
				repayBean.setLR_LC_INT_AMT(LR_LC_INT_AMT);
				repayBean.setLR_FC_LOAN_AMT(LR_FC_LOAN_AMT);
				repayBean.setLR_LC_LOAN_AMT(LR_LC_LOAN_AMT);
				repayBean.setLR_PYMT_REF_NO(LR_PYMT_REF_NO);
				repayBean.setROWID(rs123.getString(9));
				repayBean.setLR_LOAN_SYS_ID(rs123.getDouble(10));
				repayBean.setLR_SYS_ID(rs123.getLong(11));
				repayBean.setLR_STATUS(LR_STATUS);
				/*Newly added by Dhinesh on 10.3.2017*/
				repayBean.setLR_FLAG(LR_FLAG);
				repayBean.setLR_CR_DT(LR_CR_DT);
				repayBean.setLR_CR_UID(LR_CR_UID);
				/*End*/
				testList.add(repayBean);

			}

			repayBeanAction.setBeanList(testList);
			System.out.println("---------------------->Repay list size: "
					+ testList.size());
			// sessionMap.put("PILT005_PT_IL_LOAN_REPAYMENT_ACTION",
			// repayBeanAction);
			CommonUtils.setGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION",
					repayBeanAction);

			Double M_FC_OS_AMOUNT = 0.0;
			M_FC_OS_AMOUNT = (NVLDouble(loanbean.getLOAN_FC_AMOUNT(), 0.0) - NVLDouble(
					loanbean.getLOAN_FC_REPAID_AMT(), 0.0));
			sessionMap.put("M_FC_OS_AMOUNT", M_FC_OS_AMOUNT);
			// CommonUtils.setGlobalVariable("M_FC_OS_AMOUNT",
			// M_FC_OS_AMOUNT+"");

			Double M_LC_OS_AMOUNT = 0.0;
			M_LC_OS_AMOUNT = (NVLDouble(loanbean.getLOAN_LC_AMOUNT(), 0.0) - NVLDouble(
					loanbean.getLOAN_LC_REPAID_AMT(), 0.0));
			sessionMap.put("M_LC_OS_AMOUNT", M_LC_OS_AMOUNT);

			loanbean.setUI_M_FC_OS_AMOUNT(M_FC_OS_AMOUNT);
			loanbean.setUI_M_LC_OS_AMOUNT(M_LC_OS_AMOUNT);
			sessionMap.put("PILT005_PT_IL_LOAN_ACTION", pt_il_loan_action);
			CommonUtils.setGlobalObject("PILT005_PT_IL_LOAN_ACTION",
					pt_il_loan_action);

			// Logic For Default Population
			PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN = null;
			Iterator<PT_IL_LOAN_REPAYMENT> it = testList.iterator();

			while (it.hasNext()) {
				PT_IL_LOAN_REPAYMENT_BEAN = it.next();
				PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(false);
			}
			// actionBean.setDataTableList(outputList);
			if (testList.size() > 0) {
				repayBeanAction.setPT_IL_LOAN_REPAYMENT_BEAN(testList.get(0));
				repayBeanAction.getPT_IL_LOAN_REPAYMENT_BEAN().setRowSelected(
						true);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public String executeQueryOld() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map sessionMap = ctx.getExternalContext().getSessionMap();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext()
				.getRequest();
		Date LOAN_DT = null;
		String M_CUST_CURR_CODE = null;
		String M_CURR_RATE_BS = null;
		Double LOAN_EXCH_RATE = 0.0;
		String M_POL_DS_CODE = null;

		CommonUtils.setGlobalObject("PILT005_LOAN_REPAYMENT_SEARCH", this);
		// String query = "SELECT ROWID,PM_BANK_CHARGE_SETUP_HDR.* FROM
		// PM_BANK_CHARGE_SETUP_HDR WHERE ROWID =
		// '"+req.getParameter("rowID")+"'";
		try {
			CRUDHandler handler = null;
			handler = new CRUDHandler();
			Connection con = CommonUtils.getConnection();
			PT_IL_LOAN_ACTION pt_il_loan_action = new PT_IL_LOAN_ACTION();
			PT_IL_LOAN loanbean = pt_il_loan_action.getPT_IL_LOAN_BEAN();
			/*
			 * String query = "SELECT ROWID,PT_IL_LOAN.* FROM PT_IL_LOAN WHERE
			 * ROWID = '"+req.getParameter("rowID")+"'"; List<LoanRepaymentSearchPageBean>
			 * rs = handler.fetch(query,
			 * "com.iii.pel.forms.PILT005.LoanRepaymentSearchPageBean", con);
			 * LoanRepaymentSearchPageBean beanValue = rs.get(0);
			 * setSearchBean(beanValue);
			 */

			String LOAN_REF_NO = "";
			// String query = "SELECT LOAN_REF_NO FROM PT_IL_LOAN WHERE ROWID =
			// '"+req.getParameter("rowID")+"'";
			String query = "SELECT PT_IL_LOAN.ROWID,PT_IL_LOAN.* FROM PT_IL_LOAN WHERE NVL(LOAN_STATUS,'N') IN ('A', 'C') ";
			ResultSet rs = handler.executeSelectStatement(query, con);
			while (rs.next()) {
				loanbean.setLOAN_SYS_ID(rs.getDouble("LOAN_SYS_ID"));
				loanbean.setLOAN_POL_SYS_ID(rs.getDouble("LOAN_POL_SYS_ID"));
				loanbean.setLOAN_DT(rs.getDate("LOAN_DT"));
				LOAN_EXCH_RATE = rs.getDouble("LOAN_EXCH_RATE");
				loanbean.setLOAN_REF_NO(rs.getString("LOAN_REF_NO"));
				loanbean.setLOAN_LC_AMOUNT(rs.getDouble("LOAN_LC_AMOUNT"));
				loanbean.setLOAN_FC_AMOUNT(rs.getDouble("LOAN_FC_AMOUNT"));
				loanbean.setLOAN_LC_REPAID_AMT(rs
						.getDouble("LOAN_LC_REPAID_AMT"));
				loanbean.setLOAN_FC_REPAID_AMT(rs
						.getDouble("LOAN_FC_REPAID_AMT"));
				loanbean.setLOAN_REF_NO(rs.getString("LOAN_REF_NO"));
			}
			System.out.println("LOAN_REF_NO = " + loanbean.getLOAN_REF_NO());

			sessionMap.put("LOAN_REF_NO", loanbean.getLOAN_REF_NO());
			sessionMap.put("LOAN_DT", loanbean.getLOAN_DT());
			CommonUtils
					.setGlobalVariable("LOAN_DT", loanbean.getLOAN_DT() + "");
			CommonUtils.setGlobalVariable("LOAN_REF_NO_REQUERY", loanbean
					.getLOAN_REF_NO());
			// CommonUtils.setGlobalVariable(String.valueOf("LOAN_POL_SYS_ID",
			// loanbean.getLOAN_POL_SYS_ID()));
			CommonUtils.setGlobalVariable("LOAN_EXCH_RATE",
					(LOAN_EXCH_RATE + ""));
			DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			String dat = "";
			if (loanbean.getLOAN_DT() != null) {
				dat = df.format(loanbean.getLOAN_DT());
			}
			sessionMap.put("LOAN_DT", dat);
			if (loanbean.getLOAN_POL_SYS_ID() != null) {
				String Query = "SELECT POL_ASSURED_NAME,POL_CUST_CURR_CODE,POL_DS_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ? ";
				Object[] values2 = { loanbean.getLOAN_POL_SYS_ID() };
				ResultSet rs2 = handler.executeSelectStatement(Query, con,
						values2);
				if (rs2.next()) {
					loanbean.setUI_M_ASSURED_NAME(rs2
							.getString("POL_ASSURED_NAME"));
					M_CUST_CURR_CODE = rs2.getString("POL_CUST_CURR_CODE");
					M_POL_DS_CODE = rs2.getString("POL_DS_CODE");
					// sessionMap.put("M_CUST_CURR_CODE", M_CUST_CURR_CODE);
					CommonUtils.setGlobalVariable("M_CUST_CURR_CODE",
							M_CUST_CURR_CODE);
				}

				if (M_POL_DS_CODE != null) {
					String Query3 = "SELECT DS_CURR_RATE_BS  FROM   PM_IL_DOC_SETUP WHERE  DS_TYPE = '2' AND DS_CODE = ?";
					Object[] values3 = { M_POL_DS_CODE };
					ResultSet rs3 = handler.executeSelectStatement(Query3, con,
							values3);
					if (rs3.next()) {
						M_CURR_RATE_BS = rs3.getString("DS_CURR_RATE_BS");
						sessionMap.put("M_CURR_RATE_BS", M_CURR_RATE_BS);
					}
				}
			}
			Date LR_PYMT_DT = null;
			Double LR_FC_PYMT_AMT = 0.0;
			Double LR_LC_PYMT_AMT = 0.0;
			Double LR_FC_INT_AMT = 0.0;
			Double LR_LC_INT_AMT = 0.0;
			Double LR_FC_LOAN_AMT = 0.0;
			Double LR_LC_LOAN_AMT = 0.0;
			String LR_PYMT_REF_NO = null;
			String LR_SYS_ID = null;
			String LR_STATUS = null;
			
			/*Newly Added By Dhinesh on 10.3.2017*/
			Date    LR_CR_DT = null;
			String LR_FLAG = null;
			String LR_CR_UID = null;
			/*End*/
			String query3 = "select A.LR_PYMT_DT,A.LR_FC_PYMT_AMT,A.LR_LC_PYMT_AMT,"
					+ "A.LR_FC_INT_AMT,A.LR_LC_INT_AMT,A.LR_FC_LOAN_AMT,"
					+ "A.LR_LC_LOAN_AMT,A.LR_PYMT_REF_NO,A.ROWID,A.LR_LOAN_SYS_ID,A.LR_SYS_ID,A.LR_STATUS,A.LR_FLAG,A.LR_CR_DT , A.LR_CR_UID "
					+ "FROM PT_IL_LOAN_REPAYMENT A,PT_IL_LOAN B where A.LR_LOAN_SYS_ID = B.LOAN_SYS_ID AND B.LOAN_REF_NO = ?";
			Object[] values_ref_no = { loanbean.getLOAN_REF_NO() };
			ResultSet rs123 = handler.executeSelectStatement(query3, con,
					values_ref_no);

			PT_IL_LOAN_REPAYMENT_ACTION repayBeanAction = new PT_IL_LOAN_REPAYMENT_ACTION();
			List<PT_IL_LOAN_REPAYMENT> testList = repayBeanAction
					.getGridDisplay();
			testList.clear();
			while (rs123.next()) {
				PT_IL_LOAN_REPAYMENT repayBean = new PT_IL_LOAN_REPAYMENT();
				LR_PYMT_DT = rs123.getDate(1);
				LR_FC_PYMT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(2)),
						0.0);
				LR_LC_PYMT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(3)),
						0.0);
				LR_FC_INT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(4)),
						0.0);
				LR_LC_INT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(5)),
						0.0);
				LR_FC_LOAN_AMT = NVLDouble(Double.valueOf(rs123.getDouble(6)),
						0.0);
				LR_LC_LOAN_AMT = NVLDouble(Double.valueOf(rs123.getDouble(7)),
						0.0);
				LR_PYMT_REF_NO = rs123.getString(8);
				LR_SYS_ID = rs123.getString(11);
				LR_STATUS = rs123.getString(12);
				
				/*Newly Added By Dhinesh on 10.3.2017*/
				LR_FLAG   = rs123.getString(13);
				LR_CR_DT  = rs123.getTimestamp(14);
				LR_CR_UID  = rs123.getString(15);
				/*End*/
				
				repayBean.setLR_PYMT_DT(LR_PYMT_DT);
				repayBean.setLR_FC_PYMT_AMT(LR_FC_PYMT_AMT);
				repayBean.setLR_LC_PYMT_AMT(LR_LC_PYMT_AMT);
				repayBean.setLR_FC_INT_AMT(LR_FC_INT_AMT);
				repayBean.setLR_LC_INT_AMT(LR_LC_INT_AMT);
				repayBean.setLR_FC_LOAN_AMT(LR_FC_LOAN_AMT);
				repayBean.setLR_LC_LOAN_AMT(LR_LC_LOAN_AMT);
				repayBean.setLR_PYMT_REF_NO(LR_PYMT_REF_NO);
				repayBean.setROWID(rs123.getString(9));
				repayBean.setLR_LOAN_SYS_ID(rs123.getDouble(10));
				repayBean.setLR_SYS_ID(rs123.getLong(11));
				repayBean.setLR_STATUS(LR_STATUS);
				/*Newly Added By Dhinesh on 10.3.2017*/
				repayBean.setLR_FLAG(LR_FLAG);
				repayBean.setLR_CR_DT(LR_CR_DT);
				repayBean.setLR_CR_UID(LR_CR_UID);
				/*End*/
				testList.add(repayBean);

			}

			repayBeanAction.setBeanList(testList);
			System.out.println("---------------------->Repay list size: "
					+ testList.size());
			// sessionMap.put("PILT005_PT_IL_LOAN_REPAYMENT_ACTION",
			// repayBeanAction);
			CommonUtils.setGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION",
					repayBeanAction);

			Double M_FC_OS_AMOUNT = 0.0;
			M_FC_OS_AMOUNT = (NVLDouble(loanbean.getLOAN_FC_AMOUNT(), 0.0) - NVLDouble(
					loanbean.getLOAN_FC_REPAID_AMT(), 0.0));
			sessionMap.put("M_FC_OS_AMOUNT", M_FC_OS_AMOUNT);
			// CommonUtils.setGlobalVariable("M_FC_OS_AMOUNT",
			// M_FC_OS_AMOUNT+"");

			Double M_LC_OS_AMOUNT = 0.0;
			M_LC_OS_AMOUNT = (NVLDouble(loanbean.getLOAN_LC_AMOUNT(), 0.0) - NVLDouble(
					loanbean.getLOAN_LC_REPAID_AMT(), 0.0));
			sessionMap.put("M_LC_OS_AMOUNT", M_LC_OS_AMOUNT);

			loanbean.setUI_M_FC_OS_AMOUNT(M_FC_OS_AMOUNT);
			loanbean.setUI_M_LC_OS_AMOUNT(M_LC_OS_AMOUNT);
			sessionMap.put("PILT005_PT_IL_LOAN_ACTION", pt_il_loan_action);
			CommonUtils.setGlobalObject("PILT005_PT_IL_LOAN_ACTION",
					pt_il_loan_action);

			// Logic For Default Population
			PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN = null;
			Iterator<PT_IL_LOAN_REPAYMENT> it = testList.iterator();

			while (it.hasNext()) {
				PT_IL_LOAN_REPAYMENT_BEAN = it.next();
				PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(false);
			}
			// actionBean.setDataTableList(outputList);
			if (testList.size() > 0) {
				repayBeanAction.setPT_IL_LOAN_REPAYMENT_BEAN(testList.get(0));
				repayBeanAction.getPT_IL_LOAN_REPAYMENT_BEAN().setRowSelected(
						true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		}
		return "loanPage";
	}

	Integer NVLInteger(Integer first, Integer second) {
		if (first == null) {
			first = second;
		}
		return first;
	}

	Double NVLDouble(Double first, Double second) {
		if (first == null) {
			first = second;
		}
		return first;
	}

	String NVLString(String first, String second) {
		if ((first == null) || first.equals("")) {
			first = second;
		}
		return first;
	}

	/* Form-Level Events Ends Here */

	private void callingAllFormLevelEvents() {
		System.out.println("PT_IL_LOAN_ACTION.callingAllFormLevelEvents()");
		/* Preform Event */
		preform();

		/* WHEN-CREATE-RECORD Event */
		whenCreateRecord();

		/* WHEN-NEW-FORM-INSTANCE Event */
		whenNewFormInstance();
	}

	private void whenNewFormInstance() {
		System.out.println("PT_IL_LOAN_ACTION.whenNewFormInstance()");
		/*
		 * Clarifications Required.
		 */
	}

	private void whenCreateRecord() {
		System.out.println("PT_IL_LOAN_ACTION.whenCreateRecord()");
		/*
		 * Need to be converted.
		 */
	}

	private void preform() {
		System.out.println("PT_IL_LOAN_ACTION.preform()");
		facesCtx = FacesContext.getCurrentInstance();
		sessionMap = getSessionMap();
		sessionMap.put("GLOBAL.M_FAILURE", "FALSE");
		STD_PRE_FORM();

		String M_TITLE = CommonUtils.getControlBean().getM_USER_ID() + " "
				+ CommonUtils.getControlBean().getM_SCR_NAME() + " "
				+ new Date();

		/*
		 * L_SET_LC_FORMAT - This is a Front-End Procedure. It is used to set
		 * the formats for Currency Fields. It has been handled in the JSP page.
		 */

	}

	private void STD_PRE_FORM() {
		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_PARA_1((String) sessionMap.get("GLOBAL.M_PARA_1"));
		ctrlBean.setM_PROG_NAME("PILT005");
		sessionMap.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
	}

	public String loanRefNoOnBlur() throws Exception {

		/**
		 * Note:- The following method has to execute 2 queries one after the
		 * other or Use the Consolidated Query. for single execution. Decision
		 * is pending......
		 */

		String loanRefNo = PT_IL_LOAN_BEAN.getLOAN_REF_NO();

		// Query-2 (Consolidated Query):
		/*
		 * String selectQuery2 = "SELECT
		 * A.LOAN_DT,A.LOAN_FC_AMOUNT,A.LOAN_LC_AMOUNT,"+
		 * "A.LOAN_FC_REPAID_AMT,A.LOAN_LC_REPAID_AMT,"+"B.POL_ASSURED_NAME,B.POL_CUST_CURR_CODE,B.POL_DS_CODE
		 * FROM PT_IL_LOAN A,PT_IL_POLICY B where A.LOAN_REF_NO =
		 * '"+loanRefNo+"' AND B.POL_SYS_ID = A.LOAN_POL_SYS_ID";
		 */
		String selectQuery2 = "SELECT A.LOAN_DT,A.LOAN_FC_AMOUNT,A.LOAN_LC_AMOUNT,"
				+ "A.LOAN_FC_REPAID_AMT,A.LOAN_LC_REPAID_AMT,"
				+ "B.POL_ASSURED_NAME,B.POL_CUST_CURR_CODE,B.POL_DS_CODE,C.DS_CURR_RATE_BS FROM "
				+ "PT_IL_LOAN A,PT_IL_POLICY B,PM_IL_DOC_SETUP C WHERE A.LOAN_REF_NO = '"
				+ loanRefNo
				+ "'AND B.POL_SYS_ID = A.LOAN_POL_SYS_ID AND C.DS_TYPE = '2' AND C.DS_CODE = B.POL_DS_CODE";
		Connection con = CommonUtils.getConnection();
		ResultSet rs = handler.executeSelectStatement(selectQuery2, con);

		Date dt = null;
		String LOAN_FC_AMOUNT = null;
		String LOAN_LC_AMOUNT = null;
		String LOAN_FC_REPAID_AMT = null;
		String LOAN_LC_REPAID_AMT = null;
		String M_ASSURED_NAME = null;
		String M_CUST_CURR_CODE = null;
		String M_CURR_RATE_BS = null;

		while (rs.next()) {
			dt = rs.getDate(1);
			LOAN_FC_AMOUNT = rs.getString(2);
			LOAN_LC_AMOUNT = rs.getString(3);
			LOAN_FC_REPAID_AMT = rs.getString(4);
			LOAN_LC_REPAID_AMT = rs.getString(5);
			M_ASSURED_NAME = rs.getString(6);
			M_CUST_CURR_CODE = rs.getString(7);
			M_CURR_RATE_BS = rs.getString(9);
		}

		getCOMP_LOAN_DT().setSubmittedValue(dt);
		getCOMP_LOAN_FC_AMOUNT().setSubmittedValue(LOAN_FC_AMOUNT);
		getCOMP_LOAN_LC_AMOUNT().setSubmittedValue(LOAN_LC_AMOUNT);
		getCOMP_LOAN_FC_REPAID_AMT().setSubmittedValue(LOAN_FC_REPAID_AMT);
		getCOMP_LOAN_LC_REPAID_AMT().setSubmittedValue(LOAN_LC_REPAID_AMT);
		getCOMP_UI_M_ASSURED_NAME().setSubmittedValue(M_ASSURED_NAME);

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String LOAN_DT = sdf.format(dt);
		/** ******************************************************** */
		/*
		 * Date LR_PYMT_DT = null; Double LR_FC_PYMT_AMT = 0.0; Double
		 * LR_LC_PYMT_AMT = 0.0; Double LR_FC_INT_AMT = 0.0; Double
		 * LR_LC_INT_AMT = 0.0; Double LR_FC_LOAN_AMT = 0.0; Double
		 * LR_LC_LOAN_AMT = 0.0; String LR_PYMT_REF_NO = null;
		 * 
		 * String query2 = "select
		 * A.LR_PYMT_DT,A.LR_FC_PYMT_AMT,A.LR_LC_PYMT_AMT,"+
		 * "A.LR_FC_INT_AMT,A.LR_LC_INT_AMT,A.LR_FC_LOAN_AMT,"+
		 * "A.LR_LC_LOAN_AMT,A.LR_PYMT_REF_NO "+ "FROM PT_IL_LOAN_REPAYMENT
		 * A,PT_IL_LOAN B where A.LR_LOAN_SYS_ID = B.LOAN_SYS_ID AND
		 * B.LOAN_REF_NO = '"+loanRefNo+"'"; ResultSet rs123 =
		 * handler.executeSelectStatement(query2, con);
		 * 
		 * PT_IL_LOAN_REPAYMENT_ACTION repayBeanAction = new
		 * PT_IL_LOAN_REPAYMENT_ACTION(); List testList =
		 * repayBeanAction.getGridDisplay();
		 * 
		 * while(rs123.next()){
		 * 
		 * PT_IL_LOAN_REPAYMENT repayBean =
		 * repayBeanAction.getPT_IL_LOAN_REPAYMENT_BEAN(); LR_PYMT_DT =
		 * rs123.getDate(1); LR_FC_PYMT_AMT =
		 * Double.valueOf(rs123.getString(2)); LR_LC_PYMT_AMT =
		 * Double.valueOf(rs123.getString(3)); LR_FC_INT_AMT =
		 * Double.valueOf(rs123.getString(4)); LR_LC_INT_AMT =
		 * Double.valueOf(rs123.getString(5)); LR_FC_LOAN_AMT =
		 * Double.valueOf(rs123.getString(6)); LR_LC_LOAN_AMT =
		 * Double.valueOf(rs123.getString(7)); LR_PYMT_REF_NO =
		 * rs123.getString(8);
		 * 
		 * repayBean.setLR_PYMT_DT(LR_PYMT_DT);
		 * repayBean.setLR_FC_PYMT_AMT(LR_FC_PYMT_AMT);
		 * repayBean.setLR_LC_PYMT_AMT(LR_LC_PYMT_AMT);
		 * repayBean.setLR_FC_INT_AMT(LR_FC_INT_AMT);
		 * repayBean.setLR_LC_INT_AMT(LR_LC_INT_AMT);
		 * repayBean.setLR_LC_LOAN_AMT(LR_LC_LOAN_AMT);
		 * repayBean.setLR_PYMT_REF_NO(LR_PYMT_REF_NO);
		 * 
		 * testList.add(repayBean);
		 * 
		 * System.out.println("LR_PYMT_DT = "+LR_PYMT_DT);
		 * System.out.println("LR_FC_PYMT_AMT = "+LR_FC_PYMT_AMT);
		 * System.out.println("LR_LC_PYMT_AMT = "+LR_LC_PYMT_AMT);
		 * System.out.println("LR_FC_INT_AMT = "+LR_FC_INT_AMT);
		 * System.out.println("LR_LC_INT_AMT = "+LR_LC_INT_AMT);
		 * System.out.println("LR_FC_LOAN_AMT = "+LR_FC_LOAN_AMT);
		 * System.out.println("LR_LC_LOAN_AMT = "+LR_LC_LOAN_AMT);
		 * System.out.println("LR_PYMT_REF_NO = "+LR_PYMT_REF_NO); }
		 */

		/* Session Variables Required in Other Classes */

		sessionMap = getSessionMap();
		sessionMap.put("LOAN_REF_NO", loanRefNo);
		sessionMap.put("LOAN_DT", LOAN_DT);
		sessionMap.put("M_CUST_CURR_CODE", M_CUST_CURR_CODE);
		sessionMap.put("M_CURR_RATE_BS", M_CURR_RATE_BS);

		/* Session Variables Required in Other Classes */
		/*
		 * Double M_FC_OS_AMOUNT = 0.0; Double M_LC_OS_AMOUNT = 0.0;
		 * 
		 * Double COMP_LOAN_FC_AMOUNT = 0.0; Double COMP_LOAN_LC_AMOUNT = 0.0;
		 * Double COMP_LOAN_FC_REPAID_AMT = 0.0; Double COMP_LOAN_LC_REPAID_AMT =
		 * 0.0;
		 * 
		 * if(getCOMP_LOAN_FC_AMOUNT().getSubmittedValue()!=null ){
		 * COMP_LOAN_FC_AMOUNT =
		 * Double.valueOf(getCOMP_LOAN_FC_AMOUNT().getSubmittedValue().toString());
		 * if(getCOMP_LOAN_FC_REPAID_AMT().getSubmittedValue()!=null){
		 * COMP_LOAN_FC_REPAID_AMT =
		 * Double.valueOf(getCOMP_LOAN_FC_REPAID_AMT().getSubmittedValue().toString());
		 * }else if(getCOMP_LOAN_FC_REPAID_AMT().getSubmittedValue() == null){
		 * COMP_LOAN_FC_REPAID_AMT = 0.0; }
		 * 
		 * M_FC_OS_AMOUNT = COMP_LOAN_FC_AMOUNT - COMP_LOAN_FC_REPAID_AMT;
		 * sessionMap.put("M_FC_OS_AMOUNT", M_FC_OS_AMOUNT);
		 * getCOMP_UI_M_FC_OS_AMOUNT().setSubmittedValue(String.valueOf(M_FC_OS_AMOUNT)); }
		 * 
		 * if(getCOMP_LOAN_LC_AMOUNT().getSubmittedValue()!=null){
		 * COMP_LOAN_LC_AMOUNT =
		 * Double.valueOf(getCOMP_LOAN_LC_AMOUNT().getSubmittedValue().toString());
		 * if(getCOMP_LOAN_LC_REPAID_AMT().getSubmittedValue()!=null){
		 * COMP_LOAN_LC_REPAID_AMT =
		 * Double.valueOf(getCOMP_LOAN_LC_REPAID_AMT().getSubmittedValue().toString());
		 * }else if(getCOMP_LOAN_LC_REPAID_AMT().getSubmittedValue()== null){
		 * COMP_LOAN_LC_REPAID_AMT = 0.0; }
		 * 
		 * M_LC_OS_AMOUNT = COMP_LOAN_LC_AMOUNT - COMP_LOAN_LC_REPAID_AMT;
		 * sessionMap.put("M_LC_OS_AMOUNT", M_LC_OS_AMOUNT);
		 * getCOMP_UI_M_LC_OS_AMOUNT().setSubmittedValue(String.valueOf(M_LC_OS_AMOUNT)); }
		 */
		return "loanPage";
	}

	/* Helper Methods. For Example like LOV */

	public String test() throws Exception {
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();

		Connection con = CommonUtils.getConnection();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "OUT", "");
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN", "E");
		paramList.add(param1);
		paramList.add(param2);

		ArrayList result = procHandler.execute(paramList, con,
				"P_GET_BASE_CURR_DEC");
		// System.out.println("Result Size = "+result.size());

		int M_BASE_DEC = 0;
		String M_MASK = "";
		Iterator iter = result.iterator();
		while (iter.hasNext()) {
			OracleParameter obj = (OracleParameter) iter.next();
			System.out.println("Value = " + obj.getValue());
			M_BASE_DEC = Integer.parseInt(obj.getValue().toString());
		}
		// int M_BASE_DEC = 2;
		// int maxLength = 16;
		int maxLength = getCOMP_UI_M_ASSURED_NAME().getMaxlength();
		String formatQuery = "SELECT LPAD('9'," + (maxLength - M_BASE_DEC - 1)
				+ ",'9')||'.'||LPAD('9'," + M_BASE_DEC + ",'9') FROM DUAL";
		// System.out.println("Query = "+formatQuery);
		CRUDHandler crud = new CRUDHandler();
		ResultSet rs = crud.executeSelectStatement(formatQuery, con);

		while (rs.next()) {
			M_MASK = rs.getString(1);
		}
		// System.out.println("Type = "+getConv().getType()+" Pattern =
		// "+getConv().getPattern());
		return "";
	}

	public List suggestionList(Object obj) {
		List list = new ArrayList();
		String entry = obj.toString();

		if (entry.equalsIgnoreCase("*")) {
			String query = "SELECT LOAN_REF_NO,TO_CHAR(LOAN_DT),LOAN_CODE FROM PT_IL_LOAN WHERE NVL(LOAN_STATUS,'N') ='A' AND ROWNUM<51";
			list = lovValues(query);
		}
		return list;
	}
	
public void saveRecord() {
		
		// Newly added below code on 19.2.2017 by Dhinesh
			String message = null;
			PT_IL_LOAN_REPAYMENT_ACTION repayBeanAction = (PT_IL_LOAN_REPAYMENT_ACTION) CommonUtils.getGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION");
			
		//end	
			try {
				getErrorMap().clear();
				getWarningMap().clear();
				CommonUtils.getConnection().commit();
				
				/* Newly added below code on 19.2.2017 by Dhinesh */
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
				repayBeanAction.getWarningMap().put("SAVE",message);
				repayBeanAction.getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				
				//end	
				
				/* Commented below code on 19.2.2017 by Dhinesh
				getWarningMap().put(
						"SAVE",
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));*/
			} catch (Exception e) {
				/* Commented below code on 19.2.2017 by Dhinesh
				/*getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SAVE", e.getMessage());*/
				//end
				
				// Newly added below code on 19.2.2017 by Dhinesh
				repayBeanAction.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				repayBeanAction.getErrorMap().put("SAVE", e.getMessage());
				// End
			}
		}
		

	public List lovValues(String query) {
		List list = new ArrayList();
		Connection con;
		try {
			con = CommonUtils.getConnection();
			ResultSet rs = handler.executeSelectStatement(query, con);

			while (rs.next()) {
				LoanRefNoLovBean lovBean = new LoanRefNoLovBean();
				lovBean.setLOAN_REF_NO(rs.getString("LOAN_REF_NO"));
				lovBean.setLOAN_DT(rs.getString("TO_CHAR(LOAN_DT)"));
				lovBean.setLOAN_CODE(rs.getString("LOAN_CODE"));
				list.add(lovBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/* Helper Methods. For Example like LOV */

	/* Navigation To Other Blocks is Handled Here */

	/*
	 * Navigation to Payment Details is not Required. Payment Details Form is
	 * being done by Pradeep's team. Just need to Call that form once its
	 * completed.
	 */
	/*
	 * public String paymentDetailsNav(){ return "paymentDtls"; }
	 */

	public String paymentDetailsNav() {

		return "PILT017_PaymentDetails";
	}

	/* Navigation To Other Blocks is Handled Here */

	/* Error Handling Mechanism */
	private Map<String, String> errorMap = new HashMap<String, String>();
	private Map<String, String> warningMap = new HashMap<String, String>();

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	private String errorMessages;
	private String warningMessages;

	public String getErrorMessages() {
		String messageList;
		if ((errorMap == null) || (errorMap.size() == 0)) {
			messageList = "";
		} else {
			Map<String, String> error = new HashMap<String, String>();
			error.putAll(errorMap);
			error.remove("current");
			messageList = "<FONT SIZE=2><UL>\n";
			for (String message : error.values()) {

				messageList = messageList + "<LI>" + message + "\n";
			}
			messageList = messageList + "</UL></FONT>\n";
		}

		return messageList;
	}
	
	public void checkEnableOrDisableButtons() throws Exception{
		PT_IL_LOAN_REPAYMENT_ACTION repayBeanAction = new PT_IL_LOAN_REPAYMENT_ACTION();
		String C1 = "SELECT LR_STATUS FROM PT_IL_LOAN,PT_IL_LOAN_REPAYMENT " +
				"WHERE LR_STATUS = 'A' AND LR_LOAN_SYS_ID=?";
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{PT_IL_LOAN_BEAN.getLOAN_SYS_ID()});
			if(resultSet.next()){
				repayBeanAction.getUI_M_BUT_ADD().setDisabled(true);
				repayBeanAction.getUI_M_BUT_DELETE().setDisabled(true);
				repayBeanAction.getUI_M_BUT_POST().setDisabled(true);
			}
			else{
				repayBeanAction.getUI_M_BUT_ADD().setDisabled(false);
				repayBeanAction.getUI_M_BUT_DELETE().setDisabled(false);
				repayBeanAction.getUI_M_BUT_POST().setDisabled(false);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}

	public void requiredValidation(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent(); // Ajax4jsf
		// comp
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/* Error Handling Mechanism */

	public HtmlOutputText getCOMP_LOAN_DISBURSAL_STATUS() {
		return COMP_LOAN_DISBURSAL_STATUS;
	}

	public void setCOMP_LOAN_DISBURSAL_STATUS(
			HtmlOutputText comp_loan_disbursal_status) {
		COMP_LOAN_DISBURSAL_STATUS = comp_loan_disbursal_status;
	}

public void executetoglepanel(Connection connection,PT_IL_LOAN PT_IL_LOAN_BEAN,String Refno) throws SQLException{
		
		System.out.println("Refno........."+Refno);
		String query = "select POL_ASSURED_NAME,POL_LC_SUM_ASSURED,POL_START_DT,POL_PERIOD,"
       +"DECODE(POL_MODE_OF_PYMT,'M','MONTHLY','Q','QUARTELY','H','HALF YEARLY','Y','YEARLY','S','SINGLE') as PYMT,"
       +"(SELECT MAX(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = POL_SYS_ID AND PC_PAID_DT IS NOT NULL  AND NVL(PC_PAID_FLAG, 'N') = 'A') PREM_DUE_DT,"
       +"(SELECT MAX(DEP_DOC_DT) FROM PT_IL_DEPOSIT WHERE DEP_REF_NO = POL_NO  AND NVL(DEP_REC_REV_YN, 'N') = 'N') LAST_RCPT_DT "
       +"FROM PT_IL_POLICY, PT_IL_LOAN WHERE POL_NO = LOAN_POL_NO  AND LOAN_REF_NO = ?";
		ResultSet resultSet = null;
		resultSet = new CRUDHandler().executeSelectStatement(
				query, connection, new Object[] { Refno });
		while (resultSet.next()) {
			
			 PT_IL_LOAN_BEAN.setPOL_LC_SUM_ASSURED(resultSet
						.getString("POL_LC_SUM_ASSURED"));
			 PT_IL_LOAN_BEAN.setPOL_START_DT(resultSet
						.getDate("POL_START_DT"));
			 PT_IL_LOAN_BEAN.setPOL_PERIOD(resultSet
						.getString("POL_PERIOD"));
			 PT_IL_LOAN_BEAN.setPYMT(resultSet
						.getString("PYMT"));
			 PT_IL_LOAN_BEAN.setPREM_DUE_DT(resultSet
						.getDate("PREM_DUE_DT"));
			 PT_IL_LOAN_BEAN.setLAST_RCPT_DT(resultSet
						.getDate("LAST_RCPT_DT"));
		}	 
}
public String navigationEnabled() {
	CommonUtils.clearMaps(this);
	return "";

   }
}
