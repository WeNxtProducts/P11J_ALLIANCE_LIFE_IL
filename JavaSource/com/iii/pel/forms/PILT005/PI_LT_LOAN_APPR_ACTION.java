package com.iii.pel.forms.PILT005;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PI_LT_LOAN_APPR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CUST_CODE_LABEL;
	private HtmlInputText COMP_CUST_CODE;
	private HtmlOutputLabel COMP_CUST_NAME_LABEL;
	private HtmlInputText COMP_CUST_NAME;
	private HtmlOutputLabel COMP_APPR_DT_LABEL;
	private HtmlCalendar COMP_APPR_DT;
	private HtmlCommandButton COMP_UI_M_BUT_OK; 
	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private PT_IL_LOAN_APPROVE PT_IL_LOAN_APPROVE_BEAN;

	public PT_IL_LOAN_APPROVE getPT_IL_LOAN_APPROVE_BEAN() {
		return PT_IL_LOAN_APPROVE_BEAN;
	}

	public void setPT_IL_LOAN_APPROVE_BEAN(
			PT_IL_LOAN_APPROVE pt_il_loan_approve_bean) {
		PT_IL_LOAN_APPROVE_BEAN = pt_il_loan_approve_bean;
	}

	public PI_LT_LOAN_APPR_ACTION(){
		PT_IL_LOAN_APPROVE_BEAN= new PT_IL_LOAN_APPROVE();
		COMP_UI_M_BUT_OK = new HtmlCommandButton();
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}
	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton comp_ui_m_but_ok) {
		COMP_UI_M_BUT_OK = comp_ui_m_but_ok;
	}
	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}
	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton comp_ui_m_but_main) {
		COMP_UI_M_BUT_MAIN = comp_ui_m_but_main;
	}
	public HtmlOutputLabel getCOMP_CUST_CODE_LABEL() {
		return COMP_CUST_CODE_LABEL;
	}
	public void setCOMP_CUST_CODE_LABEL(HtmlOutputLabel comp_cust_code_label) {
		COMP_CUST_CODE_LABEL = comp_cust_code_label;
	}
	public HtmlInputText getCOMP_CUST_CODE() {
		return COMP_CUST_CODE;
	}
	public void setCOMP_CUST_CODE(HtmlInputText comp_cust_code) {
		COMP_CUST_CODE = comp_cust_code;
	}
	public HtmlOutputLabel getCOMP_CUST_NAME_LABEL() {
		return COMP_CUST_NAME_LABEL;
	}
	public void setCOMP_CUST_NAME_LABEL(HtmlOutputLabel comp_cust_name_label) {
		COMP_CUST_NAME_LABEL = comp_cust_name_label;
	}
	public HtmlInputText getCOMP_CUST_NAME() {
		return COMP_CUST_NAME;
	}
	public void setCOMP_CUST_NAME(HtmlInputText comp_cust_name) {
		COMP_CUST_NAME = comp_cust_name;
	}
	public HtmlOutputLabel getCOMP_APPR_DT_LABEL() {
		return COMP_APPR_DT_LABEL;
	}
	public void setCOMP_APPR_DT_LABEL(HtmlOutputLabel comp_appr_dt_label) {
		COMP_APPR_DT_LABEL = comp_appr_dt_label;
	}
	public HtmlCalendar getCOMP_APPR_DT() {
		return COMP_APPR_DT;
	}
	public void setCOMP_APPR_DT(HtmlCalendar comp_appr_dt) {
		COMP_APPR_DT = comp_appr_dt;
	}

	public String backFromApprove()throws Exception{
		//Reloading Done in OK button click.
		//Commented by Amit Kumar(50664)
		//reloadRepayment();
		
		return "BACK_FROM_PILT005_APPROVE";
	}
	/** [ BugId:PREMIAGDC-0133 Mallika 13-Mar-09 After approval of a repayment, the screen should come back to repayment screen 
	 * @throws SQLException 
	 * @throws DBException */
	
	public String OKAction() {
		String retrnValue = null;
		Connection con = null;
		Double M_PD_LC_AMT = 0.0;
		String M_APPROVED = "N";
		ResultSet resultSet = null;
		DBProcedures dbProcedures = new DBProcedures();
		LoanRepaymentSearchPageAction searchAction = null;
		
		try {
			con = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();

			PT_IL_LOAN_REPAYMENT loanRepaymentBean = (PT_IL_LOAN_REPAYMENT) CommonUtils.getGlobalObject("PILT005_LOAN_REPAYMENT_VALUE_BEAN");
			System.out.println("PT_IL_LOAN_REPAYMENT (Object) = "+loanRepaymentBean);
			System.out.println("LR_SYS_ID :------>"+ loanRepaymentBean.getLR_SYS_ID());
			String query1 = "SELECT SUM(NVL(PD_LC_AMT,0)) FROM PT_IL_PYMT_DTLS WHERE PD_TXN_SYS_ID = ? AND	PD_PAY_MODE	= 'DP'";
			Object[] values = {loanRepaymentBean.getLR_SYS_ID()};
			resultSet = handler.executeSelectStatement(query1, con, values);

			System.out.println("M_POL_CUST_CODE = "+PT_IL_LOAN_APPROVE_BEAN.getCUST_CODE());

			LOAN_REPAYMENT_APPROVAL(PT_IL_LOAN_APPROVE_BEAN.getCUST_CODE(),String.valueOf(loanRepaymentBean.getLR_SYS_ID()));

			M_APPROVED = "Y";
			loanRepaymentBean.setLR_STATUS(M_APPROVED);
			String result2 = "";

			if(M_APPROVED.equals("Y")){
				if(resultSet.next()){
					M_PD_LC_AMT = resultSet.getDouble(1); 
					
				}
				
				if(M_PD_LC_AMT > 0){
					dbProcedures.callP9ILPK_CHEQ_VALIDATION_UPD_DEPOSIT_PYMT_DTLS(String.valueOf(loanRepaymentBean.getLR_SYS_ID()), CommonUtils.getGlobalVariable("GLOBAL.TXN_TYPE"));
				}
				
				//Not Applicable in java conversion
				//:CTRL.M_COMM_DEL := 'C';
				   CommonUtils utils = new CommonUtils();
				   utils.doComitt();
				   
				 //Not Applicable in java conversion
				//:CTRL.M_COMM_DEL := '';
				
				   new PT_IL_LOAN_ACTION().getWarningMap().put("current",
						   Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91127"));
				
				   new PT_IL_LOAN_ACTION().getWarningMap().put("approve",
						   Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91127"));
				   
				// EXECUTE_QUERY
				//new PT_IL_LOAN_ACTION().executeQuery();
				/*searchAction = (LoanRepaymentSearchPageAction) utils.getMappedBeanFromSession("PILT005_LOAN_REPAYMENT_SEARCH");
				if(searchAction != null){
					String ROWID = CommonUtils.getGlobalVariable("rowID");
					searchAction.executeQuery(ROWID);
				}else{
					getErrorMap().put("current", "Requery Failed....");
				}*/
				retrnValue = "goBackToLoan";
				FacesContext ctx = FacesContext.getCurrentInstance();
				Map<String, Object> sessionMap = ctx.getExternalContext()
						.getSessionMap();
				PT_IL_LOAN_ACTION action = (PT_IL_LOAN_ACTION) sessionMap
						.get("PILT005_PT_IL_LOAN_ACTION");
				action.executeQuery();
			}
		}/*catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(con, FacesContext.getCurrentInstance(), getCOMP_UI_M_BUT_OK().getId(), getWarningMap());
		}*/
		catch (SQLException exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
			setErrorMessages(exc.getMessage());
			//throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			//getErrorMap().put("current", "Not Approved.");
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			setErrorMessages(e.getMessage());
		}finally{
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(), 
						FacesContext.getCurrentInstance(), 
						getCOMP_UI_M_BUT_OK().getId(), this.getWarningMap());
			} catch (DBException e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
				setErrorMessages(e.getMessage());
				//throw e;
			} catch (ValidatorException e) {
				e.printStackTrace();
				//getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getFacesMessage().getSummary());
				System.out.println("Message------------->"+e.getFacesMessage().getDetail());
				setErrorMessages(e.getFacesMessage().getSummary());
				//throw e;
			}
		}
		return retrnValue;
	}
	/**  BugId:PREMIAGDC-0133 Mallika 13-Mar-09 ]
	 * @throws Exception */

	private String LOAN_REPAYMENT_APPROVAL(String var1,String var2) throws SQLException,Exception {
		String result = "";
		Connection con = null;
		ArrayList<OracleParameter> inputList = new ArrayList<OracleParameter>();

		try {
		con = CommonUtils.getConnection();
		OracleProcedureHandler procHandler = new OracleProcedureHandler();

		OracleParameter inputParam1 = new OracleParameter("in1","STRING","IN",var1);
		OracleParameter inputParam2 = new OracleParameter("in2","STRING","IN",var2);
		inputList.add(inputParam1);
		inputList.add(inputParam2);

		//callP_SET_PARA_VALUES("ENG","","LIFEALL","001","HO","ADM","BND","0","");
			procHandler.execute(inputList, con, "P9ILPK_LOAN.LOAN_REPAYMENT_APPROVAL");
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	private void UPD_DEPOSIT_PYMT_DTLS(String var1,String var2){
		String result = "";
		Connection con = null;
		ArrayList<OracleParameter> inputList = new ArrayList<OracleParameter>();

		try {
			con = CommonUtils.getConnection();
			OracleProcedureHandler procHandler = new OracleProcedureHandler();

			OracleParameter inputParam1 = new OracleParameter("in1","STRING","IN",var1);
			OracleParameter inputParam2 = new OracleParameter("in2","STRING","IN OUT",var2);
			inputList.add(inputParam1);
			inputList.add(inputParam2);
			
			
			procHandler.execute(inputList, con, "P9ILPK_CHEQ_VALIDATION.UPD_DEPOSIT_PYMT_DTLS");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	

	private void reloadRepayment()throws Exception{
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map sessionMap = ctx.getExternalContext().getSessionMap();
		
		String LOAN_REF_NO = (String) sessionMap.get("LOAN_REF_NO");
		System.out.println("LOAN_REF_NO = "+LOAN_REF_NO);
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

		Connection con = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();

		String query3 = "select A.LR_PYMT_DT,A.LR_FC_PYMT_AMT,A.LR_LC_PYMT_AMT,"+
		"A.LR_FC_INT_AMT,A.LR_LC_INT_AMT,A.LR_FC_LOAN_AMT,"+
		"A.LR_LC_LOAN_AMT,A.LR_PYMT_REF_NO,A.ROWID,A.LR_LOAN_SYS_ID,A.LR_SYS_ID,A.LR_STATUS "+ 
		"FROM PT_IL_LOAN_REPAYMENT A,PT_IL_LOAN B where A.LR_LOAN_SYS_ID = B.LOAN_SYS_ID AND B.LOAN_REF_NO = '"+LOAN_REF_NO+"'";
		ResultSet rs123 = handler.executeSelectStatement(query3, con);

		PT_IL_LOAN_REPAYMENT_ACTION repayBeanAction = new PT_IL_LOAN_REPAYMENT_ACTION();
		List testList = repayBeanAction.getGridDisplay();
		testList.clear();
		while(rs123.next()){
			PT_IL_LOAN_REPAYMENT repayBean = new PT_IL_LOAN_REPAYMENT();
			LR_PYMT_DT = rs123.getDate(1);
			LR_FC_PYMT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(2)), 0.0);
			LR_LC_PYMT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(3)), 0.0);
			LR_FC_INT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(4)), 0.0);
			LR_LC_INT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(5)), 0.0);
			LR_FC_LOAN_AMT = NVLDouble(Double.valueOf(rs123.getDouble(6)), 0.0);
			LR_LC_LOAN_AMT = NVLDouble(Double.valueOf(rs123.getDouble(7)), 0.0);
			LR_PYMT_REF_NO = rs123.getString(8);
			LR_SYS_ID = rs123.getString(11);
			LR_STATUS = rs123.getString(12);

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
			testList.add(repayBean);
		}

		sessionMap.put("PILT005_PT_IL_LOAN_REPAYMENT_ACTION", repayBeanAction);
		
		Date dt = null;
		Double LOAN_FC_AMOUNT=0.0;
		Double LOAN_LC_AMOUNT=0.0;
		Double LOAN_FC_REPAID_AMT=0.0;
		Double LOAN_LC_REPAID_AMT=0.0;
		String M_ASSURED_NAME=null;
		String M_CUST_CURR_CODE=null;
		String M_CURR_RATE_BS=null;
		Double LOAN_EXCH_RATE = 0.0;
		String LOAN_POL_SYS_ID = null;
		
		String query2 = "SELECT A.LOAN_DT,A.LOAN_FC_AMOUNT,A.LOAN_LC_AMOUNT,"+
		"A.LOAN_FC_REPAID_AMT,A.LOAN_LC_REPAID_AMT,"+
		"B.POL_ASSURED_NAME,B.POL_CUST_CURR_CODE,B.POL_DS_CODE,C.DS_CURR_RATE_BS,A.LOAN_SYS_ID,A.LOAN_EXCH_RATE,A.LOAN_POL_SYS_ID FROM "+
		"PT_IL_LOAN A,PT_IL_POLICY B,PM_IL_DOC_SETUP C WHERE A.LOAN_REF_NO = '"+LOAN_REF_NO+
		"'AND B.POL_SYS_ID = A.LOAN_POL_SYS_ID AND C.DS_TYPE = '2' AND C.DS_CODE = B.POL_DS_CODE";
		
		ResultSet rs1 = handler.executeSelectStatement(query2, con);
		PT_IL_LOAN_ACTION pt_il_loan_action = new PT_IL_LOAN_ACTION();
		PT_IL_LOAN loanbean = pt_il_loan_action.getPT_IL_LOAN_BEAN();
		
		while(rs1.next()){
			dt = rs1.getDate(1);
			LOAN_FC_AMOUNT = NVLDouble(Double.valueOf(rs1.getString(2)), 0.0);
			LOAN_LC_AMOUNT = NVLDouble(Double.valueOf(rs1.getString(3)), 0.0);
			LOAN_FC_REPAID_AMT = NVLDouble(Double.valueOf(rs1.getDouble(4)), 0.0);
			LOAN_LC_REPAID_AMT = NVLDouble(Double.valueOf(rs1.getDouble(5)), 0.0);
			M_ASSURED_NAME = rs1.getString(6);
			M_CUST_CURR_CODE = rs1.getString(7);
			M_CURR_RATE_BS = rs1.getString(9);
			loanbean.setLOAN_SYS_ID(rs1.getDouble(10));
			LOAN_EXCH_RATE = NVLDouble(Double.valueOf(rs1.getDouble(11)), 0.0);
			LOAN_POL_SYS_ID = rs1.getString(12);
		}
		
		sessionMap.put("M_CUST_CURR_CODE", M_CUST_CURR_CODE);
		sessionMap.put("M_CURR_RATE_BS", M_CURR_RATE_BS);
		
		CommonUtils.setGlobalVariable("LOAN_POL_SYS_ID", LOAN_POL_SYS_ID);
		CommonUtils.setGlobalVariable("M_CUST_CURR_CODE", M_CUST_CURR_CODE);
		CommonUtils.setGlobalVariable("LOAN_EXCH_RATE", (LOAN_EXCH_RATE+""));
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String dat="";
		if(dt != null){
			 dat = df.format(dt);
		}
		sessionMap.put("LOAN_DT", dat);
		loanbean.setLOAN_REF_NO(LOAN_REF_NO);
		loanbean.setLOAN_DT(dt);
		loanbean.setLOAN_FC_AMOUNT(LOAN_FC_AMOUNT);
		loanbean.setLOAN_LC_AMOUNT(LOAN_LC_AMOUNT);
		loanbean.setLOAN_FC_REPAID_AMT(LOAN_FC_REPAID_AMT);
		loanbean.setLOAN_LC_REPAID_AMT(LOAN_LC_REPAID_AMT);
		loanbean.setUI_M_ASSURED_NAME(M_ASSURED_NAME);
		
		Double M_FC_OS_AMOUNT = 0.0;
		M_FC_OS_AMOUNT = (NVLDouble(LOAN_FC_AMOUNT, 0.0)-NVLDouble(LOAN_FC_REPAID_AMT, 0.0));
		sessionMap.put("M_FC_OS_AMOUNT", M_FC_OS_AMOUNT);
		
		Double M_LC_OS_AMOUNT = 0.0;
		M_LC_OS_AMOUNT = (NVLDouble(LOAN_LC_AMOUNT, 0.0)-NVLDouble(LOAN_LC_REPAID_AMT, 0.0));
		sessionMap.put("M_LC_OS_AMOUNT", M_LC_OS_AMOUNT);
		
		loanbean.setUI_M_FC_OS_AMOUNT(M_FC_OS_AMOUNT);
		loanbean.setUI_M_LC_OS_AMOUNT(M_LC_OS_AMOUNT);
		sessionMap.put("PILT005_PT_IL_LOAN_ACTION", pt_il_loan_action);
		
		return;
	}

	Integer NVLInteger(Integer first, Integer second){
		if(first==null){
			first=second;
		}
		return first;
	}

	Double NVLDouble(Double first, Double second){
		if(first==null){
			first=second;
		}
		return first;
	}

	String NVLString(String first, String second){
		if((first==null) || first.equals("")){
			first=second;
		}
		return first;
	}
}


