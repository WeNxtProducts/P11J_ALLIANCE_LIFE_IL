package com.iii.pel.forms.PILT004;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PI_LT_LOAN_APPR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CUST_CODE_LABEL;
	private HtmlInputText COMP_CUST_CODE;
	private HtmlOutputLabel COMP_CUST_NAME_LABEL;
	private HtmlInputText COMP_CUST_NAME;
	private HtmlOutputLabel COMP_APPR_DT_LABEL;
	private HtmlCalendar COMP_APPR_DT;
	private HtmlCommandButton COMP_UI_M_BUT_OK; 
	private HtmlCommandButton COMP_UI_M_BUT_LOV_INT_CODE;
	private HtmlCommandButton COMP_UI_M_BUT_MAIN;
	
	PT_IL_LOAN_APPROVE PT_IL_LOAN_APPROVE_BEAN;
	
	private boolean custCodeDisabled; 
	
	private ControlBean ctrl;
	
	private String lov_CUSTCODE = "SELECT CUST_CODE, CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS) AND CUST_FRZ_FLAG = 'N' AND ROWNUM<100 ORDER BY CUST_CODE"; 
	
	public PT_IL_LOAN_APPROVE getPT_IL_LOAN_APPROVE_BEAN() {
		return PT_IL_LOAN_APPROVE_BEAN;
	}

	public void setPT_IL_LOAN_APPROVE_BEAN(
			PT_IL_LOAN_APPROVE pt_il_loan_approve_bean) {
		    PT_IL_LOAN_APPROVE_BEAN = pt_il_loan_approve_bean;
	}

	public PI_LT_LOAN_APPR_ACTION(){
		PT_IL_LOAN_APPROVE_BEAN= new PT_IL_LOAN_APPROVE();
		ctrl = (ControlBean) CommonUtils.getControlBean().clone();
		
		/*if(!CommonUtils.getGlobalVariable("PILT004_POL_CUSTCODE").equals(null)){
			
			String cust_code = CommonUtils.getGlobalVariable("PILT004_POL_CUSTCODE");
			
			PT_IL_LOAN_APPROVE_BEAN.setCUST_CODE(cust_code);
			PT_IL_LOAN_APPROVE_BEAN.setAPPR_DT(new Date());
			String custnameQry = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE='" + cust_code + "' ";
			try{
				PreparedStatement psmt_custname = CommonUtils.getConnection().prepareStatement(lov_CUSTCODE);
				ResultSet rs_custname = psmt_custname.executeQuery();
				while(rs_custname.next()){
					PT_IL_LOAN_APPROVE_BEAN.setUI_M_CUST_NAME(rs_custname.getString("CUST_NAME"));
				}
				
				
			}catch(Exception ex){ex.printStackTrace();}
			
		}*/
		
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
	
	
	
	
	public List LovActionForCustCode(Object object) {
		List lovList = new ArrayList();
		if ("*".equals(object.toString())) {
			try {
				Connection con = CommonUtils.getConnection();
				PreparedStatement psmt = con.prepareStatement(lov_CUSTCODE);
				ResultSet rs = psmt.executeQuery();

				while (rs.next()) {
					PT_IL_APPR_LOV lovbox = new PT_IL_APPR_LOV();

					lovbox.setCUST_CODE(rs.getString(1));
					lovbox.setCUST_NAME(rs.getString(2));
					lovList.add(lovbox);

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return lovList;

		}
		return lovList;

	}
	
	
	public void  CUST_CODE_Validator(ActionEvent event){
		System.out.println("inside-----1");
		UIInput input = (UIInput) event.getComponent().getParent();
		String CUST_CODE = (String) input.getSubmittedValue();
		PT_IL_LOAN_APPROVE_BEAN.setCUST_CODE(CUST_CODE);	
		
		String custNamequery = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS) AND CUST_CODE = ? AND (SYSDATE BETWEEN  NVL(CUST_EFF_FM_DT,'01-JAN-1900') AND NVL(CUST_EFF_TO_DT ,'31-DEC-2999'))";
		try{
		PreparedStatement psmt = CommonUtils.getConnection().prepareStatement(custNamequery);
		psmt.setString(1, CUST_CODE);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()){
			System.out.println("custname=======" + rs.getString(1));
			COMP_CUST_NAME.setSubmittedValue(rs.getString(1));
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String OKBtnAction(){
		String retrunString=null;
		Integer M_SYS_ID = 0, M_LOAN_SYS_ID = 0, M_PC_SYS_ID = 0, M_POL_SYS_ID = 0;
		Double M_LOAN_FC_UNPAID_PREM = 0.0, M_LOAN_LC_UNPAID_PREM = 0.0, M_LOAN_FC_OS_AMOUNT = 0.0, 
		       M_LOAN_LC_OS_AMOUNT = 0.0 , M_LOAN_INT_RATE = 0.0, M_VALUE = 0.0, M_VALUE1 = 0.0, 
		       M_FC_UNPAID_PREM_INT = 0.0, M_LC_UNPAID_PREM_INT = 0.0, M_TOT_FC_UNPAID_PREM = 0.0, 
		       M_TOT_LC_UNPAID_PREM = 0.0, M_TOT_FC_UNPAID_PREM_INT = 0.0, M_TOT_LC_UNPAID_PREM_INT = 0.0,
		       M_PC_FC_UNPAID_PREM = 0.0, M_PC_LC_UNPAID_PREM = 0.0, M_PC_FC_UNPAID_PREM_INT = 0.0, 
		       M_PC_LC_UNPAID_PREM_INT = 0.0, M_RND_TYPE = 0.0;  
		String M_CODE_DESC = "", M_POL_NO = "", M_DESC = "", P_SUCCESS_PREM = "";
		
		Map m = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_LOAN_ACTION ptIlLoanAction = (PT_IL_LOAN_ACTION) m.get("PILT004_PT_IL_LOAN_ACTION");
		
		String queryCursor0 = "SELECT PIL_LR_SYS_ID.NEXTVAL FROM DUAL";
		
		String queryCursor1 = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ?";
		Object[] cursor1Values = {ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_POL_NO()};
		
		String queryCursor2 = "SELECT LOAN_SYS_ID FROM PT_IL_LOAN WHERE LOAN_POL_NO = ? AND LOAN_STATUS = 'A'";
		Object[] cursor2Values = {ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_POL_NO()};
		
		String queryCursor3 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_NO = ? AND NVL(POL_STATUS,'N') IN ('A', 'E', 'R')";
		Object[] cursor3Values = {ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_POL_NO()};
		
		String queryCursor4 = "SELECT PC_SYS_ID FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? " +
				               "AND NVL(PC_PAID_FLAG, 'N') IN ('Y', 'N') " +
				               "AND TRUNC(PC_SCHD_PYMT_DT) < TRUNC(?)";
		Object[] cursor4Values = {ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_POL_SYS_ID(), 
				                  getPT_IL_LOAN_APPROVE_BEAN().getAPPR_DT()};
		
		ResultSet rsCursor3 = null, rsCursor1 = null, rsCursor4 = null;
		boolean found = false;
		/*IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
	      STD_MESSAGE_ROUTINE(71048,:GLOBAL.M_LANG_CODE);
	      RAISE FORM_TRIGGER_FAILURE;
	    END IF;*/
		try{
			System.out.println("I am in Approval Section and Policy Number is: "+ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_POL_NO());
			rsCursor3 = getHandler().executeSelectStatement(queryCursor3, CommonUtils.getConnection(),cursor3Values);
			while(rsCursor3.next()){
				found = true;
				M_POL_NO = rsCursor3.getString(1) ;
			}
			if(found == false){
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71081").getSummary());
				getErrorMap().put("detail", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71081").getSummary());
				return "";
			}
			System.out.println("I am in Approval Section1111111");
			rsCursor1 = getHandler().executeSelectStatement(queryCursor1, CommonUtils.getConnection(),cursor1Values);
			while(rsCursor1.next()){
				M_POL_SYS_ID = rsCursor1.getInt(1) ;
			}
			System.out.println("I am in Approval Section22222222222");
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN", ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_POL_NO());
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN", CommonUtils.dateToStringFormatter(getPT_IL_LOAN_APPROVE_BEAN().getAPPR_DT()));
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN", ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_SURR_PERC().toString());
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN", ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_NO_YRS_PREM_PAID().toString());
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN", ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_CURR_CODE());
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN", ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_BASE_CURR());         
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN", ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE().toString());
			OracleParameter param8 = new OracleParameter("OUT1", "STRING", "OUT", "");
			OracleParameter param9 = new OracleParameter("OUT2", "STRING", "OUT", "");
			OracleParameter param10 = new OracleParameter("OUT3", "STRING", "OUT", "");
			OracleParameter param11 = new OracleParameter("OUT4", "STRING", "OUT", "");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);
			paramList.add(param6);
			paramList.add(param7);
			paramList.add(param8);
			paramList.add(param9);
			paramList.add(param10);
			paramList.add(param11);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			ArrayList<OracleParameter> outputList = procHandler.execute(paramList, CommonUtils.getConnection(),"P9ILPK_LOAN.SV_CALCULATION");
			ptIlLoanAction.getPT_IL_LOAN_BEAN().setUI_M_FC_95_VALUE(Double.parseDouble(((OracleParameter) outputList.get(0)).getValue()));
			ptIlLoanAction.getPT_IL_LOAN_BEAN().setUI_M_LC_95_VALUE(Double.parseDouble(((OracleParameter) outputList.get(1)).getValue()));
			
			ptIlLoanAction.getPT_IL_LOAN_BEAN().setLOAN_FC_PERM_AMT(Double.parseDouble(((OracleParameter) outputList.get(2)).getValue()));
			ptIlLoanAction.getCOMP_LOAN_FC_PERM_AMT().setSubmittedValue(((OracleParameter) outputList.get(2)).getValue());
			
			ptIlLoanAction.getPT_IL_LOAN_BEAN().setLOAN_LC_PERM_AMT(Double.parseDouble(((OracleParameter) outputList.get(3)).getValue()));
			ptIlLoanAction.getCOMP_LOAN_LC_PERM_AMT().setSubmittedValue(((OracleParameter) outputList.get(3)).getValue());
			
			System.out.println("I am in Approval Section333333333333333"+(MigratingFunctions.nvl(ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_FC_PER_AMT(), 0.0) 
					< ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_AMOUNT()));
			
			/*if(MigratingFunctions.nvl(ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_FC_PER_AMT(), 0.0) 
					< ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_AMOUNT()){
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71084").getSummary());
				getErrorMap().put("detail", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71084").getSummary());
				return "";
			}*/
			
			if(MigratingFunctions.nvl(ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_PERM_AMT(), 0.0) 
					< ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_AMOUNT()){
				ptIlLoanAction.getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71084").getSummary());
				ptIlLoanAction.getWarningMap().put("detail", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71084").getSummary());
//				return "";
			}
			System.out.println("I am in Approval Section 444444444444444444");
			if("P".equalsIgnoreCase(ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_POL_STATUS()) 
					|| "Y".equalsIgnoreCase(ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_POL_PREM_WAIVE_YN())){
				System.out.println("I am in Approval Section 55555555555555555");
				M_TOT_FC_UNPAID_PREM = 0.0;
		      	M_TOT_LC_UNPAID_PREM = 0.0;
		      	M_TOT_FC_UNPAID_PREM_INT = 0.0;
		      	M_TOT_LC_UNPAID_PREM_INT = 0.0;
			}else{
				System.out.println("I am in Approval Section 6666666666666666");
				
				//CHECK FOR PREMIUM DEDUCTION WITH FC Unpaid premium---updated the code by ganesh which is instructed by Raja sir
				System.out.println("cheking prem ded         "+ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_UNPAID_PREM());
				if(ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_UNPAID_PREM()>0){
				//CHECK FOR PREMIUM DEDUCTION WITH FC Unpaid premium
				ArrayList<OracleParameter> paramList1 = new ArrayList<OracleParameter>();
				OracleParameter param12 = new OracleParameter("IN1", "STRING", "IN", ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_POL_SYS_ID().toString());
				OracleParameter param22 = new OracleParameter("IN2", "STRING", "IN", CommonUtils.dateToStringFormatter(getPT_IL_LOAN_APPROVE_BEAN().getAPPR_DT()));
				paramList1.add(param12);
				paramList1.add(param22);
				OracleProcedureHandler procHandler1 = new OracleProcedureHandler();
				ArrayList<OracleParameter> outputList1 = procHandler1.execute(paramList1, CommonUtils.getConnection(),"P9ILPK_LOAN.INSERT_PREM_COLL_RECORDS");
				
				rsCursor4 = getHandler().executeSelectStatement(queryCursor4, CommonUtils.getConnection(),cursor4Values);
				
				while(rsCursor4.next()){
					System.out.println("I am in Approval Section77777777777777777");
					M_PC_SYS_ID = rsCursor4.getInt(1) ;

					ArrayList<OracleParameter> paramList3 = new ArrayList<OracleParameter>();
					OracleParameter param13 = new OracleParameter("IN1", "STRING", "IN", ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_POL_SYS_ID().toString());
					OracleParameter param23 = new OracleParameter("IN2", "STRING", "IN", M_PC_SYS_ID.toString());
					OracleParameter param33 = new OracleParameter("IN3", "STRING", "IN", CommonUtils.dateToStringFormatter(getPT_IL_LOAN_APPROVE_BEAN().getAPPR_DT()));
					OracleParameter param43 = new OracleParameter("OUT1", "STRING", "OUT", "");
					OracleParameter param53 = new OracleParameter("OUT2", "STRING", "OUT", "");
					OracleParameter param63 = new OracleParameter("OUT3", "STRING", "OUT", "");
					OracleParameter param73 = new OracleParameter("OUT4", "STRING", "OUT", "");
					paramList3.add(param13);
					paramList3.add(param23);
					paramList3.add(param33);
					paramList3.add(param43);
					paramList3.add(param53);
					paramList3.add(param63);
					paramList3.add(param73);
					OracleProcedureHandler procHandler3 = new OracleProcedureHandler();
					ArrayList<OracleParameter> outputList3 = procHandler3.execute(paramList3, CommonUtils.getConnection(),"P9ILPK_PREM_COLL.P_CALC_UNPAID_PREM_INT");

					if(((OracleParameter) outputList3.get(0)).getValue() != null){
						M_PC_FC_UNPAID_PREM = Double.parseDouble(((OracleParameter) outputList3.get(0)).getValue());
					}else{
						M_PC_FC_UNPAID_PREM = 0.0;
					}
					
					if(((OracleParameter) outputList3.get(1)).getValue() != null){
						M_PC_LC_UNPAID_PREM = Double.parseDouble(((OracleParameter) outputList3.get(1)).getValue());
					}else{
						M_PC_LC_UNPAID_PREM = 0.0;
					}

					if(((OracleParameter) outputList3.get(2)).getValue() != null){
						M_PC_FC_UNPAID_PREM_INT = Double.parseDouble(((OracleParameter) outputList3.get(2)).getValue());
					}else{
						M_PC_FC_UNPAID_PREM_INT = 0.0;
					}

					if(((OracleParameter) outputList3.get(3)).getValue() != null){
						M_PC_LC_UNPAID_PREM_INT = Double.parseDouble(((OracleParameter) outputList3.get(3)).getValue());
					}else{
						M_PC_LC_UNPAID_PREM_INT = 0.0;
					}
					
					if(MigratingFunctions.nvl(M_PC_FC_UNPAID_PREM, 0.0) > 0.0){
						ArrayList<OracleParameter> paramList41 = new ArrayList<OracleParameter>();
						OracleParameter param41 = new OracleParameter("in1","STRING","IN","IL_RND_TYPE");
						OracleParameter param42 = new OracleParameter("in2","STRING","IN","IL_RND_TYPE");
						OracleParameter param46 = new OracleParameter("inout1","STRING","IN OUT",M_DESC);
						OracleParameter param44 = new OracleParameter("in4","STRING","IN","E");
						OracleParameter param45 = new OracleParameter("inout2","STRING","IN OUT",M_RND_TYPE.toString());
						paramList41.add(param41);
						paramList41.add(param42);
						paramList41.add(param46);
						paramList41.add(param44);
						paramList41.add(param45);
						OracleProcedureHandler procHandler4 = new OracleProcedureHandler();
						ArrayList listP_VAL_SYSTEM = procHandler4.execute(paramList41, CommonUtils.getConnection(), "P_VAL_SYSTEM");
						System.out.println("The procedure executed******"+((OracleParameter) listP_VAL_SYSTEM.get(0)).getValue());
						M_DESC = ((OracleParameter) listP_VAL_SYSTEM.get(0)).getValue();
						M_RND_TYPE = Double.parseDouble(((OracleParameter) listP_VAL_SYSTEM.get(1)).getValue());
						
						String updateQuery = "UPDATE PT_IL_PREM_COLL SET PC_PAID_FLAG = 'Y'," +
								             "PC_PAID_DT = ?, PC_OBJ_ID = 'L', PC_OBJ_SYS_ID = ?," +
								             "PC_UNPAID_PREM_INT_CODE = ?, PC_FC_UNPAID_PREM_INT = NVL(?,0), " +
								             "PC_LC_UNPAID_PREM_INT = NVL(?,0), " +
								             "PC_FC_PAID_AMT = DECODE(?, 1 , " +
								                                                "ROUND(NVL(PC_FC_GROSS_PREM,0)+ NVL(PC_FC_CHARGE_AMT,0)+ NVL(?,0))," +
								                                                "(NVL(PC_FC_GROSS_PREM,0)+ NVL(PC_FC_CHARGE_AMT,0)+ NVL(?,0))), " +
								                                                "PC_LC_PAID_AMT = DECODE(?, 1 , " +
								                                                                          "ROUND(NVL(PC_LC_GROSS_PREM,0)+NVL(PC_LC_CHARGE_AMT,0)+NVL(?,0))," +
								                                                                          "(NVL(PC_LC_GROSS_PREM,0)+NVL(PC_LC_CHARGE_AMT,0)+NVL(?,0)))" +
								              "WHERE PC_POL_SYS_ID = ? AND PC_SYS_ID = ?";
						Object[] updateQueryValues = {getPT_IL_LOAN_APPROVE_BEAN().getAPPR_DT(), ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_SYS_ID(),
													  ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_UNPAID_PREM_INT_CODE(), M_PC_FC_UNPAID_PREM_INT,
													  M_PC_LC_UNPAID_PREM_INT, M_RND_TYPE, M_PC_FC_UNPAID_PREM_INT, M_PC_FC_UNPAID_PREM_INT, M_RND_TYPE,
													  M_PC_LC_UNPAID_PREM_INT, M_PC_LC_UNPAID_PREM_INT, ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_POL_SYS_ID(), 
													  M_PC_SYS_ID};
						getHandler().executeUpdateStatement(updateQuery, CommonUtils.getConnection(), updateQueryValues);
						
						
					}
					M_TOT_FC_UNPAID_PREM     = MigratingFunctions.nvl(M_TOT_FC_UNPAID_PREM, 0.0) + MigratingFunctions.nvl(M_PC_FC_UNPAID_PREM, 0.0);
		            M_TOT_LC_UNPAID_PREM     = MigratingFunctions.nvl(M_TOT_LC_UNPAID_PREM, 0.0) + MigratingFunctions.nvl(M_PC_LC_UNPAID_PREM, 0.0);
		            M_TOT_FC_UNPAID_PREM_INT = MigratingFunctions.nvl(M_TOT_FC_UNPAID_PREM_INT, 0.0) + MigratingFunctions.nvl(M_PC_FC_UNPAID_PREM_INT, 0.0); 
		            M_TOT_LC_UNPAID_PREM_INT = MigratingFunctions.nvl(M_TOT_LC_UNPAID_PREM_INT, 0.0) + MigratingFunctions.nvl(M_PC_LC_UNPAID_PREM_INT, 0.0); 
				}
				System.out.println("I am in Approval Section8888888888888888");
				ArrayList<OracleParameter> paramList51 = new ArrayList<OracleParameter>();
				OracleParameter param51 = new OracleParameter("in1","STRING","IN",ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_POL_SYS_ID().toString());
				OracleParameter param52 = new OracleParameter("in2","STRING","IN","Y");
				OracleParameter param53 = new OracleParameter("in3","STRING","IN","Y");
				OracleParameter param54 = new OracleParameter("in4","STRING","IN",CommonUtils.dateToStringFormatter(getPT_IL_LOAN_APPROVE_BEAN().getAPPR_DT()));
				OracleParameter param55 = new OracleParameter("in5","STRING","IN",CommonUtils.dateToStringFormatter(new Date()));
				OracleParameter param56 = new OracleParameter("in6","STRING","IN","P");
				OracleParameter param57 = new OracleParameter("out1","STRING","OUT",P_SUCCESS_PREM);
				OracleParameter param58 = new OracleParameter("in7","STRING","IN",getPT_IL_LOAN_APPROVE_BEAN().getCUST_CODE());
				OracleParameter param59 = new OracleParameter("in8","STRING","IN","PILT004");
				OracleParameter param50 = new OracleParameter("in9","STRING","IN","");
				paramList51.add(param51);
				paramList51.add(param52);
				paramList51.add(param53);
				paramList51.add(param54);
				paramList51.add(param55);
				paramList51.add(param56);
				paramList51.add(param57);
				paramList51.add(param58);
				paramList51.add(param59);
				paramList51.add(param50);
				OracleProcedureHandler procHandler5 = new OracleProcedureHandler();
				ArrayList listP_APPROVE_PREM_COLL = procHandler5.execute(paramList51, CommonUtils.getConnection(), "P9ILPK_PREM_COLL.P_APPROVE_PREM_COLL");
				System.out.println("The procedure executed******"+((OracleParameter) listP_APPROVE_PREM_COLL.get(0)).getValue());
				P_SUCCESS_PREM = ((OracleParameter) listP_APPROVE_PREM_COLL.get(0)).getValue();
			}
			
			int b =Double.compare(MigratingFunctions.nvl(M_TOT_FC_UNPAID_PREM, 0.0),MigratingFunctions.nvl(ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_UNPAID_PREM(), 0.0));
			
			int b1 =Double.compare(MigratingFunctions.nvl(M_TOT_FC_UNPAID_PREM_INT, 0.0),MigratingFunctions.nvl(ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_UNPAID_PREM_INT(), 0.0));
			
			if(((b > 0)||(b < 0))||((b1 > 0)||(b1 < 0))){
				ptIlLoanAction.getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71187").getSummary());
				ptIlLoanAction.getWarningMap().put("detail", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71187").getSummary());
				ptIlLoanAction.setCompUiMButRecalDisabled(false);
			}
			System.out.println("I am in Approval Section 9999999999999999999999");
			System.out.println("The values are: 1111111"+M_TOT_FC_UNPAID_PREM);
			System.out.println("The values are: 2222222"+ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_UNPAID_PREM());
			System.out.println("The values are: 3333333"+M_TOT_FC_UNPAID_PREM_INT);
			System.out.println("The values are: 4444444"+M_TOT_FC_UNPAID_PREM_INT);
		/*	if((MigratingFunctions.nvl(M_TOT_FC_UNPAID_PREM, 0.0) !=  MigratingFunctions.nvl(ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_UNPAID_PREM(), 0.0)) || 
					(MigratingFunctions.nvl(M_TOT_FC_UNPAID_PREM_INT, 0.0) !=  MigratingFunctions.nvl(ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_UNPAID_PREM_INT(), 0.0))){
				ptIlLoanAction.getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71187").getSummary());
				ptIlLoanAction.getWarningMap().put("detail", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71187").getSummary());
				ptIlLoanAction.setCompUiMButRecalDisabled(false);
//				return "";
			}*/
			}
			
			//PREMIUM DEDUCTION ENDS HERE
			// CHECK FOR OUTSTANDING LOAN DEDUCTION FC Outstanding loan
			System.out.println("I am in Approval Section 10 10 10 10 10 10 10 10 10 10 10 10 10");
			ArrayList<OracleParameter> paramList6 = new ArrayList<OracleParameter>();
			OracleParameter param61 = new OracleParameter("IN1", "STRING", "IN", ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_POL_SYS_ID().toString());
			OracleParameter param62 = new OracleParameter("INOUT1", "STRING", "IN OUT", M_LOAN_FC_OS_AMOUNT.toString());
			OracleParameter param63 = new OracleParameter("INOUT2", "STRING", "IN OUT", M_LOAN_LC_OS_AMOUNT.toString());
			OracleParameter param64 = new OracleParameter("INOUT3", "STRING", "IN OUT", M_LOAN_INT_RATE.toString());
			paramList6.add(param61);
			paramList6.add(param62);
			paramList6.add(param63);
			paramList6.add(param64);
			OracleProcedureHandler procHandler6 = new OracleProcedureHandler();
			ArrayList<OracleParameter> outputList6 = procHandler6.execute(paramList6, CommonUtils.getConnection(),"P9ILPK_LOAN.CALC_OS_LOAN_AMT");
			M_LOAN_FC_OS_AMOUNT = Double.parseDouble((((OracleParameter) outputList6.get(0)).getValue()));
			M_LOAN_LC_OS_AMOUNT = Double.parseDouble(((OracleParameter) outputList6.get(1)).getValue());
			M_LOAN_INT_RATE = Double.parseDouble(((OracleParameter) outputList6.get(2)).getValue());
			
			System.out.println("M_LOAN_FC_OS_AMOUNT    :  "+M_LOAN_FC_OS_AMOUNT);
			System.out.println("M_LOAN_LC_OS_AMOUNT    :  "+M_LOAN_LC_OS_AMOUNT);
			System.out.println("ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_OS_AMOUNT()    :  "+ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_OS_AMOUNT());
			
			
			System.out.println("I am in Approval Section 11 11 11 11 11 11 11 11 11 11 11 11 11");
			
			/*
			 * commented by dhinesh on 21.9.2016 compare double value cheic
			 * 
			 * if( MigratingFunctions.nvl(M_LOAN_FC_OS_AMOUNT, 0.0) != MigratingFunctions.nvl(ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_OS_AMOUNT(), 0.0)){
				System.out.println("I am in Approval Section 12 12 12 12 12 12 12 12 12 12 12 12 12");
				ptIlLoanAction.getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71188").getSummary());
				ptIlLoanAction.getWarningMap().put("detail", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71188").getSummary());
				ptIlLoanAction.setCompUiMButRecalDisabled(false);
			}*/
			
			int c=Double.compare(MigratingFunctions.nvl(M_LOAN_FC_OS_AMOUNT, 0.0),MigratingFunctions.nvl(ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_OS_AMOUNT(), 0.0));
			
		/*	if((c > 0)||(c < 0)){*/
			
			if((c > 0)||(c < 0)){
				System.out.println("Not Equal both Value ");
				ptIlLoanAction.getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71188").getSummary());
				ptIlLoanAction.getWarningMap().put("detail", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71188").getSummary());
				ptIlLoanAction.setCompUiMButRecalDisabled(false);
			}else{
				System.out.println("Both are equal");
			}
			
			
			if(MigratingFunctions.nvl(ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_UNPAID_PREM(), 0.0) > 0){
				System.out.println("I am in Approval Section !!!!!!!!!!!!!!!!!!!!!!");
				getCtrl().setM_COMM_DEL("P");
//				POST;
				getCtrl().setM_COMM_DEL("");
				
			
				
				CommonUtils.setGlobalObject("GLOBAL.M_POL_NO", ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_POL_NO());
				CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID", M_POL_SYS_ID);
//				CommonUtils.setGlobalObject("GLOBAL.M_APPRV_DATE", CommonUtils.);
				CommonUtils.setGlobalObject("GLOBAL.M_CUST_CODE", getPT_IL_LOAN_APPROVE_BEAN().getCUST_CODE());
				CommonUtils.setGlobalObject("GLOBAL.M_LOAN_CALLING_FORM", "PILT004");
				
				System.out.println("Before going to PILP003");
				return "PILP003_APAC";
			}
			System.out.println("I am in Approval Section @@@@@@@@@@@@@@@@@@@@@@@@");
			ArrayList<OracleParameter> paramList51 = new ArrayList<OracleParameter>();
			OracleParameter param51 = new OracleParameter("in1","STRING","IN",getPT_IL_LOAN_APPROVE_BEAN().getCUST_CODE());
			OracleParameter param52 = new OracleParameter("in2","STRING","IN",ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_POL_SYS_ID().toString());
			OracleParameter param53 = new OracleParameter("in3","STRING","IN",ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_SYS_ID().toString());
			paramList51.add(param51);
			paramList51.add(param52);
			paramList51.add(param53);
			OracleProcedureHandler procHandler5 = new OracleProcedureHandler();
			ArrayList listP_APPROVE_PREM_COLL = procHandler5.execute(paramList51, CommonUtils.getConnection(), "P9ILPK_LOAN.LOAN_PAYMENT_APPROVAL");
			
			ptIlLoanAction.getPT_IL_LOAN_BEAN().setLOAN_STATUS("A");
			System.out.println("I am in Approval Section #######################");
			ArrayList<OracleParameter> paramList7 = new ArrayList<OracleParameter>();
			OracleParameter param71 = new OracleParameter("in1","STRING","IN","IL_LNINT_DED");
			OracleParameter param72 = new OracleParameter("in2","STRING","IN","ID");
			OracleParameter param73 = new OracleParameter("inout1","STRING","IN OUT",M_CODE_DESC);
			OracleParameter param74 = new OracleParameter("in3","STRING","IN","N");
			OracleParameter param75 = new OracleParameter("inout2","STRING","IN OUT",M_VALUE1.toString());
			paramList7.add(param71);
			paramList7.add(param72);
			paramList7.add(param73);
			paramList7.add(param74);
			paramList7.add(param75);
			OracleProcedureHandler procHandler7 = new OracleProcedureHandler();
			ArrayList listP_VAL_SYSTEM = procHandler.execute(paramList7, CommonUtils.getConnection(), "P_VAL_SYSTEM");
			System.out.println("The procedure executed******"+((OracleParameter) listP_VAL_SYSTEM.get(0)).getValue());
			M_CODE_DESC = ((OracleParameter) listP_VAL_SYSTEM.get(0)).getValue();
			M_VALUE1 = Double.parseDouble(((OracleParameter) listP_VAL_SYSTEM.get(1)).getValue());
			System.out.println("I am in Approval Section $$$$$$$$$$$$$$$$$$$$$$$$");
			
			ptIlLoanAction.getPT_IL_LOAN_BEAN().setLOAN_STATUS("A");
			ptIlLoanAction.saveFormDetails();
			if(M_VALUE1 == 1){
				System.out.println("I am in Approval Section %%%%%%%%%%%%%%%%%%%%");
				ArrayList<OracleParameter> paramList8 = new ArrayList<OracleParameter>();
				OracleParameter param81 = new OracleParameter("in1","STRING","IN",ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_SYS_ID().toString());
				OracleParameter param82 = new OracleParameter("in2","STRING","IN",CommonUtils.dateToStringFormatter(getPT_IL_LOAN_APPROVE_BEAN().getAPPR_DT()));
				OracleParameter param83 = new OracleParameter("in3","STRING","IN",ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_LC_INTEREST().toString());
				OracleParameter param84 = new OracleParameter("in4","STRING","IN",ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_INTEREST().toString());
				OracleParameter param85 = new OracleParameter("in5","STRING","IN",CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
				paramList8.add(param81);
				paramList8.add(param82);
				paramList8.add(param83);
				paramList8.add(param84);
				paramList8.add(param85);
				OracleProcedureHandler procHandler8 = new OracleProcedureHandler();
				ArrayList listNSERT_PT_IL_LOAN8 = procHandler.execute(paramList8, CommonUtils.getConnection(), "P9ILPK_LOAN.INSERT_PT_IL_LOAN_INT_COLL");
				System.out.println("I am in Approval Section ^^^^^^^^^^^^^^^^^^^^^^");
			}
			System.out.println("I am in Approval Section &&&&&&&&&&&&&&&&&&&&&&");
			if(MigratingFunctions.nvl(ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_FC_UNPAID_PREM(),0.0) > 0.0){
				System.out.println("Before Commit");
				if("Y".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.M_SUCC"))){
					System.out.println("111111 Connection is being committed");
					getCtrl().setM_COMM_DEL("C");
					CommonUtils.getConnection().commit();
					getCtrl().setM_COMM_DEL("");
					getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71190").getSummary());
					getWarningMap().put("detail", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71190").getSummary());
				}
			}else{
				System.out.println("In else part Before Commit");
				getCtrl().setM_COMM_DEL("C");
				System.out.println("2222222 Connection is being committed");
				CommonUtils.getConnection().commit();
				/*CommonUtils ct = new CommonUtils();
				ct.doComitt();*/
				getCtrl().setM_COMM_DEL("");
				getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71190").getSummary());
				getWarningMap().put("detail", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71190").getSummary());
			}
			System.out.println("I am in Approval Section *********************");
			ptIlLoanAction.setCompUiMButRecalDisabled(true);
			ptIlLoanAction.setCompUiMButApprvDisabled(true);
//			ptIlLoanAction.setCompApprStatusRendered(true);
			ptIlLoanAction.getCOMP_UI_M_BUT_APPRV().setDisabled(true);
			ptIlLoanAction.getPT_IL_LOAN_BEAN().setUI_M_APPRV_STATUS("");
			
			ArrayList<OracleParameter> paramList9 = new ArrayList<OracleParameter>();
			OracleParameter param91 = new OracleParameter("in1","STRING","IN","IL_LOAN_ST");
			OracleParameter param92 = new OracleParameter("in2","STRING","IN",MigratingFunctions.nvl(ptIlLoanAction.getPT_IL_LOAN_BEAN().getLOAN_STATUS(),"N"));
			OracleParameter param93 = new OracleParameter("inout1","STRING","IN OUT",ptIlLoanAction.getPT_IL_LOAN_BEAN().getUI_M_APPRV_STATUS());
			OracleParameter param94 = new OracleParameter("in3","STRING","IN","N");
			OracleParameter param95 = new OracleParameter("inout2","STRING","IN OUT",M_VALUE.toString());
			paramList9.add(param91);
			paramList9.add(param92);
			paramList9.add(param93);
			paramList9.add(param94);
			paramList9.add(param95);
			OracleProcedureHandler procHandler9 = new OracleProcedureHandler();
			ArrayList listP_VAL_SYSTEM9 = procHandler.execute(paramList9, CommonUtils.getConnection(), "P_VAL_SYSTEM");
			System.out.println("The procedure executed******"+((OracleParameter) listP_VAL_SYSTEM.get(0)).getValue());
			ptIlLoanAction.getPT_IL_LOAN_BEAN().setUI_M_APPRV_STATUS(((OracleParameter) listP_VAL_SYSTEM9.get(0)).getValue());
			M_VALUE = Double.parseDouble(((OracleParameter) listP_VAL_SYSTEM9.get(1)).getValue());
			
			
			ptIlLoanAction.setCompUiMButRepaymentDisabled(false);
			ptIlLoanAction.setBlockDeleteAllowed(false);
			
			/*   Added By Dhinesh on 22.9.2016   */
			
			PT_IL_LOAN_CHARGE_ACTION ptIlLoanChargeAction= null;
			if((PT_IL_LOAN_CHARGE_ACTION) m.get("PILT004_PT_IL_LOAN_CHARGE_ACTION")!=null)
			{
			System.out.println("ENTER THE  ");
			ptIlLoanChargeAction = (PT_IL_LOAN_CHARGE_ACTION) m.get("PILT004_PT_IL_LOAN_CHARGE_ACTION");
			ptIlLoanChargeAction.setInsertAllowed(false);
			ptIlLoanChargeAction.setDELETE_ALLOWED(false);
			ptIlLoanChargeAction.setUpdateAllowed(false);
			}
			
			/*  End  */
			
			retrunString = "PILT004_APPR_OK";
		}catch (SQLException e) {
			try {
				ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(), FacesContext.getCurrentInstance(), getCOMP_UI_M_BUT_OK().getClientId(FacesContext.getCurrentInstance()), getErrorMap(), getWarningMap());
			} catch (ValidatorException dbe) {
				getErrorMap().put("current", dbe.getMessage());
				getErrorMap().put("detail", dbe.getMessage());
				dbe.printStackTrace();
				throw new ValidatorException(new FacesMessage(dbe.getMessage()));
			} catch (DBException dbe) {
				dbe.printStackTrace();
				return retrunString;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return retrunString;
	}
	
	
	/*public String OKBtnAction(){
		
		int M_POL_SYS_ID=0;
		String apprDate = format_Date(PT_IL_LOAN_APPROVE_BEAN.getAPPR_DT());
		System.out.println("ApprDate======" + apprDate);
		
		String POL_SA_CURR_CODE;
		String POL_ISSUE_DT;
		Double POL_FC_CURR_SA;
		Double POL_LC_CURR_SA;
		String POL_PREM_WAIVE_YN="";
		String POL_STATUS="";
		int M_PC_SYS_ID =0;
		Double LOAN_FC_PERM_AMT =0.0;
		Double LOAN_LC_PERM_AMT = 0.0;
		Double UNPAID_PREM_INT =0.0;
		Double LC_UNPAID_PREM_INT=0.0; 
		Double M_NO_YRS_PREM_PAID=0.0;
		
		Double M_TOT_FC_UNPAID_PREM = 0.0;
        Double M_TOT_LC_UNPAID_PREM = 0.0;
        Double M_TOT_FC_UNPAID_PREM_INT = 0.0;
        Double M_TOT_LC_UNPAID_PREM_INT = 0.0;
		
		String M_POL_NO = "";
		
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
		PT_IL_LOAN_ACTION actionBean = (PT_IL_LOAN_ACTION) sessionMap.get("PILT004_PT_IL_LOAN_ACTION");
		PT_IL_LOAN valueBean = actionBean.getPT_IL_LOAN_BEAN();
		
		
		System.out.println("PI_LT_LOAN_APPR_ACTION.OKBtnAction()");
		String cursorC0 = "SELECT PIL_LR_SYS_ID.NEXTVAL FROM DUAL";
		String CURSORC1 = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = '"+valueBean.getLOAN_POL_NO()+"'";
		String CURSORC2 = "SELECT LOAN_SYS_ID FROM PT_IL_LOAN WHERE LOAN_POL_NO = '"+valueBean.getLOAN_POL_NO()+"' AND LOAN_STATUS = 'A'";
		String CURSORC3 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_NO = '"+valueBean.getLOAN_POL_NO()+"' AND NVL(POL_STATUS,'N') IN ('A', 'E', 'R')";

		int flag=0;
		Connection con =null; 
		
		try {
			System.out.println("CURSORC3"+CURSORC3);
			con = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSORC3, CommonUtils.getConnection());
			if(resultSet.next()){
				M_POL_NO = resultSet.getString(1);
			}else{
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71081").getDetail());
			}
			
			resultSet.close();
			
			System.out.println("CURSORC1  "+ CURSORC1);
			resultSet = handler.executeSelectStatement(CURSORC1, CommonUtils.getConnection());
			
			while(resultSet.next()){
				M_POL_SYS_ID = resultSet.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			
			String c1 = "SELECT POL_SYS_ID,POL_SA_CURR_CODE, POL_ISSUE_DT, POL_FC_CURR_SA,POL_LC_CURR_SA ,POL_PREM_WAIVE_YN,POL_NO_YRS_PREM_PAID,POL_STATUS FROM PT_IL_POLICY WHERE POL_NO = '"+valueBean.getLOAN_POL_NO()+"'";
			System.out.println("C1---------------------->" + c1);
			
			ResultSet rs2 = handler.executeSelectStatement(c1, CommonUtils.getConnection());
			while(rs2.next()){
				System.out.println("Inside while lo0p");
				 M_POL_SYS_ID		= rs2.getInt("POL_SYS_ID");
				 POL_SA_CURR_CODE   = rs2.getString("POL_SA_CURR_CODE");
				 POL_ISSUE_DT	    = rs2.getString("POL_ISSUE_DT");
				 POL_FC_CURR_SA 	= rs2.getDouble("POL_FC_CURR_SA");
			     POL_LC_CURR_SA 	= rs2.getDouble("POL_LC_CURR_SA");
				 POL_PREM_WAIVE_YN 	= rs2.getString("POL_PREM_WAIVE_YN");
				 M_NO_YRS_PREM_PAID = rs2.getDouble("POL_NO_YRS_PREM_PAID");
				 POL_STATUS 		= rs2.getString("POL_STATUS");
			}
			
			
			callproc_P9ilpk_Loan_SV_CALCULATION(valueBean.getLOAN_POL_NO(),apprDate,valueBean.getLOAN_SURR_PERC(),M_NO_YRS_PREM_PAID);
			
			
			System.out.println("After the Procedure >>> " + POL_STATUS);
			
			if("P".equalsIgnoreCase(POL_STATUS)||"Y".equalsIgnoreCase(POL_PREM_WAIVE_YN)){
				System.out.println("This is in If condition ");
				M_TOT_FC_UNPAID_PREM = 0.0;
		        M_TOT_LC_UNPAID_PREM = 0.0;
		        M_TOT_FC_UNPAID_PREM_INT = 0.0;
		        M_TOT_LC_UNPAID_PREM_INT = 0.0;
			
			}
			else{
				System.out.println("This is in Else Part >>>> ");
				ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",	""+M_POL_SYS_ID);
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",apprDate);
				parameterList.add(param2);
				
				OracleProcedureHandler procHandler = new OracleProcedureHandler();

				ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
				outputList = procHandler.execute(parameterList, CommonUtils.getConnection(),"P9ILPK_LOAN.INSERT_PREM_COLL_RECORDS");
				
				}
			    String CURSORC4 = "SELECT PC_SYS_ID FROM PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = "+M_POL_SYS_ID+" AND NVL(PC_PAID_FLAG,'N') = 'N' AND PC_PAID_DT IS NULL AND    TRUNC(PC_SCHD_PYMT_DT) < TRUNC(to_date('"+apprDate+"','dd-mon-rr')) AND PC_PAID_FLAG  != 'A'";   
	
				System.out.println("CURSORC4-------"+CURSORC4 );
				resultSet = handler.executeSelectStatement(CURSORC4, CommonUtils.getConnection());
				
				while(resultSet.next()){
					M_PC_SYS_ID = resultSet.getInt(1);
				}
			
			
			
				
				
				PROCEDURE P9ILPK_PREM_COLL.P_CALC_UNPAID_PREM_INT 
	
				// P_LOAN_FC_PERM_AMOUNT OUT NUMBER, P_LOAN_LC_PERM_AMOUNT 
				ArrayList<OracleParameter> parameterList1 = new ArrayList<OracleParameter>();
	
				OracleParameter p1 = new OracleParameter("IN1", "STRING", "IN",	""+M_POL_SYS_ID);
				parameterList1.add(p1);
				OracleParameter p2 = new OracleParameter("IN2", "STRING", "IN",""+M_PC_SYS_ID);
				parameterList1.add(p2);
				OracleParameter p3 = new OracleParameter("IN3", "STRING", "IN",apprDate);
				parameterList1.add(p3);
				OracleParameter p4 = new OracleParameter("OUT1", "STRING", "OUT","");
				parameterList1.add(p4);
				OracleParameter p5 = new OracleParameter("OUT2", "STRING", "OUT","");
				parameterList1.add(p5);
				OracleParameter p6 = new OracleParameter("OUT3", "STRING", "OUT","");
				parameterList1.add(p6);
				OracleParameter p7 = new OracleParameter("OUT4", "STRING", "OUT","");
				parameterList1.add(p7);
	
				
				OracleProcedureHandler procHandler1 = new OracleProcedureHandler();
	
				ArrayList<OracleParameter> outputList1 = new ArrayList<OracleParameter>();
				outputList1 = procHandler1.execute(parameterList1, CommonUtils.getConnection(),"P9ILPK_PREM_COLL.P_CALC_UNPAID_PREM_INT");
				
	
				Iterator<OracleParameter> iterator = outputList1.iterator();
	
				
				while (iterator.hasNext()) {
			       OracleParameter name = (OracleParameter) iterator.next();
					if (name.getFieldName().equals("OUT1")){
						System.out.println("Out1=" + name.getValue()); 
						//LOAN_FC_PERM_AMT = Double.valueOf(name.getValue()); 
						}
					if (name.getFieldName().equals("OUT2")){
						 System.out.println("Out2=" + name.getValue());
						 //LOAN_LC_PERM_AMT= Double.valueOf(name.getValue()); 
						}
					if (name.getFieldName().equals("OUT3")){
						 System.out.println("Out3=" + name.getValue());
						//UNPAID_PREM_INT = Double.valueOf(name.getValue()); 
						}
					if (name.getFieldName().equals("OUT4")){
						System.out.println("Out4=" + name.getValue());
						//LC_UNPAID_PREM_INT = Double.valueOf(name.getValue()); 
						}
					}
	
				
				double FC_UNPAID_PREM =0;
				System.out.println("After Executing All Procedures >>>>");
				if(valueBean.getLOAN_FC_UNPAID_PREM()== null){
					FC_UNPAID_PREM =0;
				}
				else{
				 valueBean.getLOAN_FC_UNPAID_PREM();
				 System.out.println("FC_UNPAID_PREM--------------------->" + FC_UNPAID_PREM);
				}
				
				if (FC_UNPAID_PREM>0){
					System.out.println("Update Statement Called......");
				}
				
				
				
				int k = 0;
				int M_RND_TYPE = 0;
				
			    double LOAN_FC_PERM_AMT1 = valueBean.getLOAN_FC_PERM_AMT();
				if(LOAN_FC_PERM_AMT1 >0){
					String updateQry = "UPDATE PT_IL_PREM_COLL "+
		               "SET PC_PAID_FLAG  = 'Y',"+
		               "PC_PAID_DT = to_date('"+ apprDate+"','dd-mon-rr'),"+
		               "PC_OBJ_ID = 'L',PC_OBJ_SYS_ID = "+ valueBean.getLOAN_SYS_ID()+","+
		               "PC_UNPAID_PREM_INT_CODE = '"+valueBean.getLOAN_UNPAID_PREM_INT_CODE()+"',"+
			           "PC_FC_UNPAID_PREM_INT   = NVL("+valueBean.getLOAN_FC_UNPAID_PREM_INT()+",0),"+
			           "PC_LC_UNPAID_PREM_INT   = NVL("+valueBean.getLOAN_LC_UNPAID_PREM_INT()+",0),"+
			           "PC_FC_PAID_AMT = DECODE("+M_RND_TYPE+", 1 , ROUND(NVL("+valueBean.getUI_M_LOAN_GR_FC_AMT()+",0)+NVL("+valueBean.getUI_M_LOAN_FC_CHARGE()+",0)+NVL("+valueBean.getUI_M_LOAN_FC_CHARGE()+",0),NVL("+valueBean.getLOAN_FC_UNPAID_PREM_INT()+",0))),"+
			           "PC_LC_PAID_AMT = DECODE("+M_RND_TYPE+", 1 , ROUND(NVL("+valueBean.getUI_M_LOAN_GR_LC_AMT()+",0)+NVL("+valueBean.getUI_M_LOAN_LC_CHARGE()+",0)+NVL("+valueBean.getUI_M_LOAN_LC_CHARGE()+",0),NVL("+valueBean.getLOAN_LC_UNPAID_PREM_INT()+",0)))"+
		               " WHERE  PC_POL_SYS_ID  = " + M_POL_SYS_ID+" AND PC_SYS_ID = "+ M_PC_SYS_ID;
					
				System.out.println("updateQry"+updateQry);
				k = handler.executeUpdateStatement(updateQry, CommonUtils.getConnection());
			    }	
			if(k!=0){
				getWarningMap().put("current", k+" Rows Updated!");
				CommonUtils.getConnection().commit();
			}else{
				//getErrorMap().put("current", "No Rows Updated!");
			}
			
			
			
			String P_LOAN_POL_SYS_ID = Integer.toString(M_POL_SYS_ID); 
			String P_LOAN_SYS_ID     = Integer.toString(valueBean.getLOAN_SYS_ID());
			//String P_CUST_CODE	 = (String) getCOMP_CUST_CODE().getSubmittedValue();	
			String P_CUST_CODE		 = PT_IL_LOAN_APPROVE_BEAN.getCUST_CODE();
			
			System.out.println("P_CUST_CODE" + P_CUST_CODE);         
			ArrayList<OracleParameter> paramList1 = new ArrayList<OracleParameter>();
			
			OracleParameter p11 = new OracleParameter("IN1", "STRING", "IN",P_CUST_CODE);
			paramList1.add(p11);
			OracleParameter p21 = new OracleParameter("IN2", "STRING", "IN",P_LOAN_POL_SYS_ID);
			paramList1.add(p21);
			OracleParameter p31 = new OracleParameter("IN2", "STRING", "IN",P_LOAN_SYS_ID);
			paramList1.add(p31);
			
			OracleProcedureHandler procHandler2 = new OracleProcedureHandler();
			
			ArrayList<OracleParameter> outputList2 = new ArrayList<OracleParameter>();
			outputList2 = procHandler1.execute(paramList1, CommonUtils.getConnection(),"P9ILPK_LOAN.LOAN_PAYMENT_APPROVAL");
			String Loan_status = "A";
			int M_VALUE =0;
			
			PROCEDURE P_VAL_SYSTEM (P_TYPE           IN     VARCHAR2,
            P_CODE           IN     VARCHAR2,
            P_CODE_DESC      IN OUT VARCHAR2,
            P_ERR_FLAG       IN     VARCHAR2,
            P_VALUE          IN OUT NUMBER ) IS
	
	
			
			ArrayList<OracleParameter> pList1 = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> oList1 = new ArrayList<OracleParameter>();

			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN","IL_LNINT_DED");
			pList1.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN","ID");
			pList1.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN OUT","");
			pList1.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN","N");
			pList1.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN OUT","");
			pList1.add(param5);
		
			
			OracleProcedureHandler pHandler1 = new OracleProcedureHandler();
			oList1 = pHandler1.execute(pList1,CommonUtils.getConnection(),"P_VAL_SYSTEM");
			for (Iterator iterator2 = oList1.iterator(); iterator2.hasNext();) {
				OracleParameter name = (OracleParameter) iterator2.next();
			 	if(name.getFieldName().equals("IN5") && name.getValue()!=null){
			 		M_VALUE = Integer.parseInt(name.getValue());
						
				}
			}
			
			if(M_VALUE==1){
				
				INSERT_PT_IL_LOAN_INT_COLL(P_LOAN_SYS_ID      IN NUMBER,
                P_LOAN_DT          IN DATE,
                P_LOAN_LC_INTEREST IN NUMBER,
                P_LOAN_FC_INTEREST IN NUMBER,
                P_USER_ID          IN VARCHAR2);
				
				String P_USER_ID = CommonUtils.getGlobalVariable("PILT004_GLOBAL_M_USER_ID");
				ArrayList<OracleParameter> pList2 = new ArrayList<OracleParameter>();
				ArrayList<OracleParameter> oList2 = new ArrayList<OracleParameter>();

				OracleParameter para1 = new OracleParameter("IN1", "STRING", "IN",Integer.toString(valueBean.getLOAN_SYS_ID()));
				pList1.add(para1);
				OracleParameter para2 = new OracleParameter("IN2", "STRING", "IN",format_Date(valueBean.getLOAN_DT()));
				pList1.add(para2);
				OracleParameter para3 = new OracleParameter("IN3", "STRING", "IN",String.valueOf(valueBean.getLOAN_FC_INTEREST()));
				pList1.add(para3);
				OracleParameter para4 = new OracleParameter("IN4", "STRING", "IN",String.valueOf(valueBean.getLOAN_LC_INTEREST()));
				pList1.add(para4);
				OracleParameter para5 = new OracleParameter("IN5", "STRING", "IN",P_USER_ID);
				pList1.add(para5);
			
				OracleProcedureHandler pHandler2 = new OracleProcedureHandler();
				oList2 = pHandler2.execute(pList2,CommonUtils.getConnection(),"P9ILPK_LOAN.INSERT_PT_IL_LOAN_INT_COLL");
			
			
			}
			//save logic
			if(MigratingFunctions.nvl(valueBean.getLOAN_FC_UNPAID_PREM(), 0)>0){
					System.out.println("LOAN_REF_NO=============== " +  valueBean.getLOAN_REF_NO());
					
					String updateQry1 = "UPDATE PT_IL_LOAN SET LOAN_STATUS = 'A' WHERE LOAN_REF_NO = '"+ valueBean.getLOAN_REF_NO()+"'" ;
					k = handler.executeUpdateStatement(updateQry1, CommonUtils.getConnection());
					if(k!=0){
						actionBean.setComponentDisableStatus(true);
						CommonUtils.getConnection().commit();
						valueBean.setUI_M_APPRV_STATUS("Approved");
						getWarningMap().put("current", k+" Rows Updated!");
					}else{
						actionBean.setComponentDisableStatus(false);
						valueBean.setUI_M_APPRV_STATUS("Not Approved");	
						getErrorMap().put("current", "No Rows Updated!");
					}
					actionBean.setPT_IL_LOAN_BEAN(valueBean);
			}
			
			//
			actionBean.getCOMP_UI_M_BUT_APPRV().setDisabled(false);
			actionBean.getCOMP_UI_M_BUT_RECAL().setDisabled(false);
			
			
			ArrayList<OracleParameter> pList11 = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> oList11 = new ArrayList<OracleParameter>();

			OracleParameter param11 = new OracleParameter("IN1", "STRING", "IN","IL_LNINT_DED");
			pList1.add(param11);
			OracleParameter param21 = new OracleParameter("IN2", "STRING", "IN","ID");
			pList1.add(param21);
			OracleParameter param31 = new OracleParameter("IN3", "STRING", "IN OUT","");
			pList1.add(param31);
			OracleParameter param41 = new OracleParameter("IN4", "STRING", "IN","N");
			pList1.add(param41);
			OracleParameter param51 = new OracleParameter("IN5", "STRING", "IN OUT","");
			pList1.add(param51);
		
			
			OracleProcedureHandler pHandler11 = new OracleProcedureHandler();
			oList11 = pHandler11.execute(pList11,CommonUtils.getConnection(),"P_VAL_SYSTEM");
			
			
			
	
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		finally{
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(con, FacesContext.getCurrentInstance(), getCOMP_UI_M_BUT_OK().getClientId(FacesContext.getCurrentInstance()), getErrorMap(), getWarningMap());
		}
		return "PILT004_APPR_OK";
		
	}*/
	
	
	private void callproc_P9ilpk_Loan_SV_CALCULATION(String loan_pol_no,String date1, Double loan_surr_perc, Double M_NO_YRS_PREM_PAID1) {
		System.out
				.println("PI_LT_LOAN_APPR_ACTION.callproc_P9ilpk_Loan_SV_CALCULATION()");
		
		
		try{
			
			Double P_LOAN_FC_PERM_AMOUNT = 0.0;
			Double P_LOAN_LC_PERM_AMOUNT = 0.0;
			
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			
			String M_POL_SA_CURR_CODE = CommonUtils.getGlobalVariable("PILT004_M_POL_SA_CURR_CODE");
			Double P_LOAN_EXCH_RATE = Double.valueOf(CommonUtils.getGlobalVariable("PILT004_P_LOAN_EXCH_RATE"));
			
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",	loan_pol_no);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",date1);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",	Double.toString(loan_surr_perc));
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",Double.toString(M_NO_YRS_PREM_PAID1));
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",M_POL_SA_CURR_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN","BND"); //P_BASE_CURR);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",Double.toString(P_LOAN_EXCH_RATE));
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING","OUT", "");
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING","OUT", "");
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING","OUT", "");
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING","OUT", "");
			parameterList.add(param11);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();

			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			outputList = procHandler.execute(parameterList, CommonUtils.getConnection(),"P9ilpk_Loan.SV_CALCULATION");
			

			Iterator<OracleParameter> iterator2 = outputList.iterator();

			
			while (iterator2.hasNext()) {
		        System.out.println("Iter not empty");
				OracleParameter name = (OracleParameter) iterator2.next();
			
				if (name.getFieldName().equals("IN8")){
					Double P_FC_95_VALUE = (name.getValue()==null) ? 0.0 : Double.valueOf(name.getValue());
				}else if (name.getFieldName().equals("IN9")){
					Double P_LC_95_VALUE = (name.getValue()==null) ? 0.0 : Double.valueOf(name.getValue());
				}else if (name.getFieldName().equals("IN10")){				
					P_LOAN_FC_PERM_AMOUNT = (name.getValue()==null) ? 0.0 : Double.valueOf(name.getValue());
				}else{
					P_LOAN_LC_PERM_AMOUNT = (name.getValue()==null) ? 0.0 : Double.valueOf(name.getValue());
				}	
			}

		
		
		
		 /*IF :DUMMY.M_FC_PER_AMT < :PT_IL_LOAN.LOAN_FC_AMOUNT  THEN 
	      STD_MESSAGE_ROUTINE(71084,:GLOBAL.M_LANG_CODE);
	      SET_ITEM_PROPERTY('DUMMY.M_BUT_RECAL',ENABLED , PROPERTY_TRUE);
	--      RAISE FORM_TRIGGER_FAILURE;
	   END IF;*/
		
		//From Proceedure LD_SA_CURR_EXCHANGE_RATE//
		
		}catch(Exception ex){ex.printStackTrace();}	
	
		
	}

	public String MainBtnAction(){
		System.out.println("PI_LT_LOAN_APPR_ACTION.MainBtnAction()");
		return "PILT004_APPR_MAIN";
	}
	
	public String format_Date(Date date){
		System.out.println("Date inside method >> "+date);
		String result=null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		result = sdf.format(date).toString();
		return result;
	}

	public boolean isCustCodeDisabled() {
		return custCodeDisabled;
	}

	public void setCustCodeDisabled(boolean custCodeDisabled) {
		this.custCodeDisabled = custCodeDisabled;
	}

	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}

	public ControlBean getCtrl() {
		return ctrl;
	}

	public void setCtrl(ControlBean ctrl) {
		this.ctrl = ctrl;
	}
}


