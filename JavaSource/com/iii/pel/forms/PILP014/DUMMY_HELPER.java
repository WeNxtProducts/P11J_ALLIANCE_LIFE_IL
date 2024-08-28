package com.iii.pel.forms.PILP014;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.utils.P9ILPK_DEP_APPROVAL;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class DUMMY_HELPER {

	private String P_VALUE;
	private String P_CODE_DESC;
	private String M_NAME;
	private String M_BL_NAME;
	private String M_VALUE;
	private String M_CALC_METHOD;
	private String SMV_TYPE;
	private String stringM_SMV_POL_SYS_ID;
	private String M_POL_DS_TYPE;
	Connection connection = null;

	// HttpSession session = null;

	HttpSession session = null;

	public DUMMY_HELPER() {
		FacesContext context = FacesContext.getCurrentInstance();
		session = (HttpSession) context.getExternalContext().getSession(true);
	}

	// Triggers Starts from Here
	FacesContext ctx = FacesContext.getCurrentInstance();
	CRUDHandler handler = new CRUDHandler();
	CommonUtils util = new CommonUtils();
	ControlBean ctrlBean = null;

	public ControlBean getCtrlBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		session = (HttpSession) context.getExternalContext().getSession(false);
		return (ControlBean) session.getAttribute("ctrlbean");
	}

	public void createCtrlBean() {
		ControlBean bean = new ControlBean();
		System.out.println("DUMMY_ACTION.createCtrlBean()" + session);
		FacesContext context = FacesContext.getCurrentInstance();
		session = (HttpSession) context.getExternalContext().getSession(false);
		System.out.println("DUMMY_ACTION.createCtrlBean()SESSION" + session);
		session.setAttribute("ctrlbean", bean);
	}

	public void putCtrlBean(ControlBean bean) {
		FacesContext context = FacesContext.getCurrentInstance();
		session = (HttpSession) context.getExternalContext().getSession(false);
		session.setAttribute("ctrlbean", bean);
	}

	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();

	public ArrayList<OracleParameter> prepareOracleParam(HttpSession session2) {
		paramList.clear();
		System.out
				.println("DUMMY_ACTION.prepareOracleParam()\n------------! \n"
						+ session2.toString());
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				(String) session2.getAttribute("GLOBAL.M_LANG_CODE"));
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				(String) session2.getAttribute("GLOBAL.M_FOR_LANG_CODE"));
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				(String) session2.getAttribute("GLOBAL.M_USER_ID"));
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				getCtrlBean().getM_COMP_CODE());
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				(((String) session2.getAttribute("GLOBAL.M_DFLT_VALUES"))
						.substring(3, 6)).trim());
		System.out.println("DUMMY_ACTION.prepareOracleParam(.....) "
				+ (String) session2.getAttribute("GLOBAL.M_DFLT_VALUES"));
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				(((String) session2.getAttribute("GLOBAL.M_DFLT_VALUES"))
						.substring(9, 11)).trim());
		OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
				getCtrlBean().getM_BASE_CURR());
		OracleParameter param8 = new OracleParameter("in8", "STRING", "IN", "2");
		OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
				getCtrlBean().getM_PROG_NAME());

		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);
		paramList.add(param7);
		paramList.add(param8);
		paramList.add(param9);
		return paramList;
	}

	public void getSystemDate() {
		String mappedBeanName = "PILP014_DUMMY_ACTION";
		DUMMY_ACTION actionBean = (DUMMY_ACTION) util
				.getMappedBeanFromSession(mappedBeanName);

		try {
			connection = CommonUtils.getConnection();
			System.out.println("DUMMY_ACTION.getSystemDate()");
			String query = "SELECT TO_DATE(SYSDATE,'DD/MM/RR') FROM DUAL";
			PreparedStatement datestmt = connection.prepareStatement(query);
			ResultSet rs = datestmt.executeQuery();
			Date date = null;
			while (rs.next()) {
				try {
					System.out
							.println("DUMMY_ACTION.getSystemDate()-----------["
									+ rs.getString(1) + "]");
					date = rs.getDate(1);
				} catch (Exception err) {
					err.printStackTrace();
				}

			}
			// getCOMP_UI_M_PROCESS_DT().setValue(date);
			actionBean.getCOMP_UI_M_PROCESS_DT().setValue(date);

		} catch (Exception er) {
			er.printStackTrace();
		} finally {
			if (connection != null) {
				// SwisSqlConnection.getInstance().closeConnection(vembu_conn);
				System.out.println("FINALLY DATABASE");

			}
		}
	}

	// For Set First Field policy_fm

	public void pilp014_dummy_ui_m_policy_no_fm_when_validate_item() {
		String mappedBeanName = "PILP014_DUMMY_ACTION";
		ResultSet rs = null;
		String M_TEMP = null;
		Object[] values = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		DUMMY_ACTION actionBean = (DUMMY_ACTION) util
				.getMappedBeanFromSession(mappedBeanName);

		if (actionBean.getCOMP_UI_M_POL_NO_FM().getSubmittedValue() == null
				|| ((String) actionBean.getCOMP_UI_M_POL_NO_FM()
						.getSubmittedValue()).trim().length() == 0) {
			actionBean.getDUMMY_BEAN().setUI_M_POL_NO_FM("0");
			actionBean.getCOMP_UI_M_POL_NO_FM().setSubmittedValue(null);
		} else {
			String C1_Validate = "SELECT 'X' FROM   PT_IL_POLICY WHERE  POL_NO = ? ";
					
			try {
				connection = CommonUtils.getConnection();
				values = new Object[]{actionBean.getDUMMY_BEAN().getUI_M_POL_NO_FM()};
				rs = handler.executeSelectStatement(C1_Validate, connection,values);
				if (rs.next()) {
					M_TEMP = rs.getString(1);
				} else {
					String message = Messages.getString(
							PELConstants.pelErrorMessagePath, "2411");
					}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (DBException e) {
				e.printStackTrace();
			}finally{
				try {
					CommonUtils.closeCursor(rs);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}
	}

	

	// Procedure call for button press starts from here,each cursor call written
	// as a method and is called in the below mwthod

	/*
	 * ResultSet rsC9 = null; ResultSet rsC8 = null; ResultSet rsC3 = null;
	 */
	String C1, C2, C2A, C3, C3A, C4, C5, C6, C7, C8, C9, C8A, C9A, M_REP_NAME,
			M_PC_DESC, M_PC_BL_DESC, M_CONT_PREFERRED_LANG, M_PRINT_TYPE,
			M_RS_DS_TYPE, M_PS_CODE_DESC, M_PLAN_TYPE;

	String M_FLAG = null;
	String M_RS_REPORT_NAME = null;
	String M_SMV_TYPE = null;

	Double M_PS_VALUE = 0.0;
	// Double M_CALC_METHOD = 0.0;

	Integer M_DSRC_SYS_ID;
	int M_SMV_POL_SYS_ID;
	int M_POL_SYS_ID_PSTPONE;
	int M_CLAIM_SYS_ID;
	int M_POL_SYS_ID;
	int M_RS_END_NO_IDX;
	int M_DUMMY = 0;

	DUMMY_ACTION actionBean = null;
	ArrayList<String> resultList = new ArrayList<String>();

	OracleProcedureHandler procHandler = new OracleProcedureHandler();

	List<OracleParameter> button_paramList = new ArrayList<OracleParameter>();

	DateFormat formatter;

	public String pilp014_dummy_ui_m_but_ok_call_proc()throws Exception {

			connection = CommonUtils.getConnection();
		String mappedBeanName = "PILP014_DUMMY_ACTION";
		
		DUMMY_ACTION actionBean = (DUMMY_ACTION) util
				.getMappedBeanFromSession(mappedBeanName);
		BP_ACTION BP_BEAN = new BP_ACTION();
		DUMMY DUMMY_BEAN = actionBean.getDUMMY_BEAN();
		CommonUtils utility = new CommonUtils();
		ControlBean bean = new ControlBean();
		String where_Condition_C6 = "";
		Integer IL_CALC_METHOD = null;
		ResultSet rs = null;
		DUMMY_DELEGATE delegate = new DUMMY_DELEGATE();

		formatter = new SimpleDateFormat(PELConstants.dbDateFormat);

		C1 = "SELECT DISTINCT RS_REPORT_NAME FROM PW_IL_REMINDER_SUMMARY WHERE RS_POL_SYS_ID IN"
				+ "(SELECT  POL_SYS_ID FROM PT_IL_POLICY WHERE   POL_PLAN_CODE IN(SELECT PLAN_CODE"
				+ " FROM PM_IL_PLAN WHERE PLAN_TYPE ='M' AND POL_NO BETWEEN '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_FM()
				+ "' AND '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_TO() + "'))";

		C2 = "SELECT DISTINCT RS_REPORT_NAME,RS_POL_SYS_ID FROM   PW_IL_REMINDER_SUMMARY WHERE  RS_POL_SYS_ID IN"
				+ "(SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_PLAN_CODE IN (SELECT PLAN_CODE FROM   PM_IL_PLAN"
				+ "WHERE PLAN_TYPE <> 'M' AND POL_NO BETWEEN '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_FM()
				+ "' AND '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_TO() 
				+ "'))AND RS_REPORT_NAME = M_RS_REPORT_NAME";
		
		C3 = "SELECT DISTINCT RS_REPORT_NAME,RS_POL_SYS_ID FROM   PW_IL_REMINDER_SUMMARY WHERE  RS_POL_SYS_ID IN (SELECT   CLAIM_SYS_ID"
				+ "FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID IN (SELECT POL_SYS_ID FROM   PT_IL_POLICY WHERE  POL_PLAN_CODE IN ( SELECT PLAN_CODE"
				+ "FROM  PM_IL_PLAN WHERE  PLAN_TYPE <> 'M' AND POL_NO BETWEEN '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_FM()
				+ "' AND '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_TO()
				+ "'))AND RS_REPORT_NAME = M_RS_REPORT_NAME";

		C4 = "SELECT PC_DESC,PC_BL_DESC FROM PM_CODES WHERE  PC_TYPE = 'IL_REMIN_RPT'AND PC_CODE IN(SELECT PS_CODE_DESC"
				+ "FROM PP_SYSTEM WHERE  PS_TYPE = 'MATURITY_LTR' AND PS_CODE = 'MAT_ACK'";

		C5 = "SELECT CONT_PREFERRED_LANG FROM   PM_IL_CONTRACTOR WHERE  CONT_CODE =(SELECT POL_CONT_CODE FROM PT_IL_POLICY"
				+ "WHERE  POL_SYS_ID = M_SMV_POL_SYS_ID AND POL_DS_TYPE = '2'";
		if(actionBean.getDUMMY_BEAN()
				.getUI_M_PROCESS_DT() != null){
		 where_Condition_C6 = formatter.format(actionBean.getDUMMY_BEAN()
				.getUI_M_PROCESS_DT())
				+ M_PS_VALUE;
		}
		C6 = "SELECT SMV_POL_SYS_ID,SMV_TYPE FROM   PT_IL_SURR_MAT_VALUES WHERE  SMV_DATE BETWEEN to_date('"
				+ formatter.format(actionBean.getDUMMY_BEAN()
						.getUI_M_PROCESS_DT())+"','dd-mon-yyyy')"
				+ " AND (to_date('" + formatter.format(actionBean.getDUMMY_BEAN()
						.getUI_M_PROCESS_DT())+ "','dd-mon-yyyy') + '"+ M_PS_VALUE +"') AND SMV_POL_SYS_ID IN (SELECT POL_SYS_ID FROM   PT_IL_POLICY  WHERE  POL_NO BETWEEN '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_FM()
				+ "' AND '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_TO()
				+ " ' AND POL_DS_TYPE = '2')";
		

		C7 = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE TRUNC(POL_POSTPONE_EXPIRY_DT) = TRUNC(to_date ('"
				+ actionBean.getDUMMY_BEAN().getUI_M_PROCESS_DT()
				+ "'),('dd-mon-yy'))"
				+ "AND POL_ADDL_STATUS = 'B07' AND POL_DS_TYPE = '1'";

		C8 = "SELECT DISTINCT RS_REPORT_NAME,RS_POL_SYS_ID FROM PW_IL_REMINDER_SUMMARY WHERE  RS_POL_SYS_ID IN (SELECT  CLAIM_SYS_ID"
				+ " FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID IN (SELECT POL_SYS_ID FROM   PT_IL_POLICY WHERE  POL_PLAN_CODE IN ( SELECT PLAN_CODE"
				+ " FROM   PM_IL_PLAN WHERE  PLAN_TYPE = 'M')AND POL_NO BETWEEN '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_FM()
				+ "' AND '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_TO()
				+ "'))AND RS_REPORT_NAME = '" + M_RS_REPORT_NAME + "'";

		C9 = "SELECT DSRC_SYS_ID.NEXTVAL FROM  DUAL";

		C2A = "SELECT RS_REPORT_NAME FROM   PW_IL_REMINDER_SUMMARY WHERE  RS_POL_SYS_ID IN (SELECT   POL_SYS_ID FROM     PT_IL_POLICY"
				+ " WHERE POL_PLAN_CODE IN (SELECT PLAN_CODE FROM PM_IL_PLAN WHERE  PLAN_TYPE <> 'M')AND POL_NO BETWEEN '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_FM()
				+ "' AND '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_TO()
				+ "'"
				+ " AND POL_DS_TYPE='"
				+ M_POL_DS_TYPE
				+ "') GROUP BY RS_REPORT_NAME";

		C3A = "SELECT RS_REPORT_NAME FROM   PW_IL_REMINDER_SUMMARY WHERE  RS_POL_SYS_ID IN (SELECT CLAIM_SYS_ID FROM PT_IL_CLAIM"
				+ " WHERE    CLAIM_POL_SYS_ID IN (SELECT POL_SYS_ID FROM   PT_IL_POLICY WHERE  POL_PLAN_CODE IN ( SELECT PLAN_CODE FROM   PM_IL_PLAN WHERE  PLAN_TYPE <> 'M')"
				+ " AND      POL_NO BETWEEN '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_FM()
				+ "' AND '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_TO()
				+ "')) GROUP BY RS_REPORT_NAME";

		C8A = "SELECT RS_REPORT_NAME FROM   PW_IL_REMINDER_SUMMARY WHERE  RS_POL_SYS_ID IN (SELECT  CLAIM_SYS_ID FROM    PT_IL_CLAIM "
				+ "WHERE   CLAIM_POL_SYS_ID IN (SELECT POL_SYS_ID FROM   PT_IL_POLICY WHERE  POL_PLAN_CODE IN ( SELECT PLAN_CODE FROM   PM_IL_PLAN WHERE  PLAN_TYPE = 'M')"
				+ " AND     POL_NO BETWEEN '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_FM()
				+ "' AND '"
				+ actionBean.getDUMMY_BEAN().getUI_M_POL_NO_TO()
				+ "')) GROUP BY RS_REPORT_NAME";

		String message = null;

			try {
				if ("Y".equals(actionBean.getDUMMY_BEAN().getUI_M_POL_CANCEL_PROCESS())) {
					delegate.POL_UPD_RCPT_REVERSAL();
				}
				resultList.clear();
				resultList = DBProcedures.P_VAL_SYSTEM("IL_CALC_MTHD",
						 "IL_CALC_MTHD", 
						 M_PS_CODE_DESC, 
						 "E", 
						 CommonUtils.getProcedureValue(M_CALC_METHOD));
					if(!resultList.isEmpty()){
						M_PS_CODE_DESC = resultList.get(0).toString();
						M_CALC_METHOD = resultList.get(1);
					}

				// Call Cursor7
				button_Press_Cursor7();

				bean.setM_COMM_DEL("C");
			
				// All Comits are Commented
				CommonUtils.getConnection().commit();
				bean.setM_COMM_DEL(null);

				message = Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",new Object[]{"Policy Servicing is Complete"});
				
				/*throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206"));*/

				// Convert The Required Bean Date to the Db Date Format

				formatter = new SimpleDateFormat(PELConstants.dbDateFormat);
				String date = formatter.format(DUMMY_BEAN.getUI_M_PROCESS_DT());
				
				delegate.P9ILPR_END_DAY_PROCESS(DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN.getUI_M_POL_NO_TO(), DUMMY_BEAN.getUI_M_PROCESS_DT());
				
				DUMMY_BEAN.setM_PRINT_TYPE("B");
				
				 button_Press_Cursor1();
				 button_Press_Cursor8A();
				 button_Press_Cursor2A("1");
				 button_Press_Cursor3A();
				if (M_DUMMY == 1) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "60315"));
				}

				// SET_ITEM_PROPERTY('BP.B_PROCESSING_MSG',VISIBLE,PROPERTY_FALSE);
				resultList.clear();
				resultList = DBProcedures.P_VAL_SYSTEM("IL_MATU_DAYS",
						 "IL_MATU_DAYS", 
						 M_PS_CODE_DESC, 
						 "E", 
						 CommonUtils.getProcedureValue(M_PS_VALUE));
					if(!resultList.isEmpty()){
						M_PS_CODE_DESC = resultList.get(0).toString();
					}
					/*new P9ILPK_PROCESS().CALC_MAT_AMT(DUMMY_BEAN.getUI_M_POL_NO_FM(),
													DUMMY_BEAN.getUI_M_POL_NO_TO(),
													DUMMY_BEAN.getUI_M_PROCESS_DT(),
													DUMMY_BEAN.get
													(DUMMY_BEAN.getUI_M_PROCESS_DT() + M_PS_VALUE), 
													M_FLAG,
													P_POL_DS_CODE);*/
				button_Press_Cursor6();
				
				/*new P9ILPK_DEP_APPROVAL().P_UPD_TOPUP_CHARGE(DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN.getUI_M_POL_NO_TO());
				
				delegate.P_UPD_SWITCH_APPROVAL(DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN.getUI_M_POL_NO_TO(), DUMMY_BEAN.getUI_M_PROCESS_DT());
				
				delegate.P_UPD_WITHDRAWAL_APPROVAL(DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN.getUI_M_POL_NO_TO(), DUMMY_BEAN.getUI_M_PROCESS_DT());
				
				delegate.P_UPD_CLAIM_APPROVAL(DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN.getUI_M_POL_NO_TO(), DUMMY_BEAN.getUI_M_PROCESS_DT());
				
				delegate.P_UPD_CANCEL_APPROVAL(DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN.getUI_M_POL_NO_TO(), DUMMY_BEAN.getUI_M_PROCESS_DT());*/
				
		/*		delegate.DEPOSIT_MOVEMENT(DUMMY_BEAN.getUI_M_PROCESS_DT(),
					DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN
							.getUI_M_POL_NO_TO());
				
				delegate.P_UPD_WITHDRAWAL_APPROVAL(DUMMY_BEAN.getUI_M_PROCESS_DT(),
					DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN
							.getUI_M_POL_NO_TO());
			if (M_CALC_METHOD != null && "2".equalsIgnoreCase(M_CALC_METHOD)) {
				delegate.PROCESS_LAPSATION(DUMMY_BEAN.getUI_M_PROCESS_DT(),
						DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN
								.getUI_M_POL_NO_TO());
			} else if (M_CALC_METHOD != null
					&& "1".equalsIgnoreCase(M_CALC_METHOD)) {
				delegate.PROCESS_LAPSATION_TAKAFUL(DUMMY_BEAN
						.getUI_M_PROCESS_DT(), DUMMY_BEAN.getUI_M_POL_NO_FM(),
						DUMMY_BEAN.getUI_M_POL_NO_TO());
			}*/
				
				
				delegate.EOD_PROCESSING(DUMMY_BEAN.getUI_M_PROCESS_DT(),
						DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN
						.getUI_M_POL_NO_TO());
			
				handler.executeDeleteStatement("DELETE FROM PW_IL_DATA_SOURCE",
						CommonUtils.getConnection());
				handler.executeDeleteStatement(
						"DELETE FROM PW_IL_REMINDER_SUMMARY", CommonUtils
								.getConnection());
				CommonUtils.getConnection().commit();
			} catch (Exception proc_Call) {
				proc_Call.printStackTrace();
				throw new Exception(proc_Call.getMessage());
			}
			return message;
		}
	

	public void button_Press_Cursor1() {

		ResultSet rsC1 = null;
		try {

			rsC1 = handler.executeSelectStatement(C1, CommonUtils
					.getConnection());
			  while(rsC1.next()) {
				   M_RS_REPORT_NAME = rsC1.getString(1);
				if (M_RS_REPORT_NAME.contains("B03")) {
					M_DUMMY = 1;
				} else if (M_RS_REPORT_NAME.contains("R01")) {
					M_DUMMY = 1;
					 
					// P_INCOMPLETE_DOC(M_RS_REPORT_NAME,'B');
				} else if (M_RS_REPORT_NAME.contains("N02")) {
					M_DUMMY = 1;
					// Form Level trigger Need to be Converted after getting inputs 
					// P_NOT_TAKEN_UP_DOC(M_RS_REPORT_NAME,'B');
				} else if (M_RS_REPORT_NAME.contains("B02")) {
					M_DUMMY = 1;
					// Form Level trigger Need to be Converted after getting inputs 
					// P_MEDICAL_DOC(M_RS_REPORT_NAME,'B');
				} else if (M_RS_REPORT_NAME.contains("C02")) {
					M_DUMMY = 1;
					// Form Level trigger Need to be Converted after getting inputs 
					// P_SHORT_PAY_DOC(M_RS_REPORT_NAME,'B');
				} else if (M_RS_REPORT_NAME.contains("C04")) {
					M_DUMMY = 1;

					// Form Level trigger Need to be Converted after getting inputs 
					// P_EXTENSION_APPRV_LETTER(M_RS_REPORT_NAME,'B');
				} else if (M_RS_REPORT_NAME.contains("C06")) {
					M_DUMMY = 1;
					// Form Level trigger Need to be Converted after getting inputs 
					// P_EXT_ACCEPT_LETTER (M_RS_REPORT_NAME,'B');
				}
			}
			rsC1.close();

			String insertData = "INSERT INTO PS_IL_REMINDER_SUMMARY(SELECT * FROM   PW_IL_REMINDER_SUMMARY WHERE  RS_REPORT_NAME  = "
					+ M_RS_REPORT_NAME
					+ " AND    RS_POL_SYS_ID   = "
					+ M_POL_SYS_ID + ")";

			handler.executeInsertStatement(insertData, CommonUtils
					.getConnection());

			handler
					.executeDeleteStatement(
							"DELETE PW_IL_REMINDER_SUMMARY WHERE  RS_REPORT_NAME = '"+M_RS_REPORT_NAME+"' AND RS_POL_SYS_ID  = '"+M_POL_SYS_ID+"'",
							CommonUtils.getConnection());

			handler
					.executeDeleteStatement(
							"DELETE PW_IL_DATA_SOURCE WHERE  DSRC_SYS_ID ='"+M_DSRC_SYS_ID+"'",
							CommonUtils.getConnection());
		} catch (Exception cursor1) {
			// TODO: handle exception
			cursor1.printStackTrace();
		}
	}

	public void button_Press_Cursor2() {

		ResultSet rsC2 = null;
		DUMMY_DELEGATE delegate = new DUMMY_DELEGATE();
		ArrayList<OracleParameter> returnList = new ArrayList<OracleParameter>();
		
		try {
			rsC2 = handler.executeSelectStatement(C2, CommonUtils
					.getConnection());
			while (rsC2.next()) {
				M_RS_REPORT_NAME = rsC2.getString(1);
				M_POL_SYS_ID = rsC2.getInt(2);
				if("1".equals(M_POL_DS_TYPE)){	
				if (M_RS_REPORT_NAME.contains("B02")) {
						M_DUMMY = 1;
						returnList = delegate.GEN_JE_MEDICAL_REQUIREMENT(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
						if(!returnList.isEmpty() ){
							M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
						}

					} else if (M_RS_REPORT_NAME.contains("R01")) {
						M_DUMMY = 1;
						returnList = delegate.GEN_JE_MEDICAL_REQUIREMENT(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
						if(!returnList.isEmpty() ){
							M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
						}
					} else if (M_RS_REPORT_NAME.contains("B09")) {
						M_DUMMY = 1;
						returnList = delegate.GEN_JE_MEDICAL_REQUIREMENT(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
						if(!returnList.isEmpty() ){
							M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
						}
					} else if (M_RS_REPORT_NAME.contains("C02")) {
						M_DUMMY = 1;
						returnList = delegate.GEN_JE_MEDICAL_REQUIREMENT(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
						if(!returnList.isEmpty() ){
							M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
						}
					} else if (M_RS_REPORT_NAME.contains("B11")) {
						M_DUMMY = 1;
						returnList = delegate.GEN_JE_MEDICAL_REQUIREMENT(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
						if(!returnList.isEmpty() ){
							M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
						}
					}
					
					}  else if (M_POL_DS_TYPE == "2") {
						if (M_RS_REPORT_NAME.contains("I00-1")) {
						M_DUMMY = 1;
						returnList = delegate.GEN_PS_RENEWAL_NOTICE(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
						if(!returnList.isEmpty() ){
							M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
						}
					} else if (M_RS_REPORT_NAME.contains("I00-2")) {
						M_DUMMY = 1;
						returnList = delegate.GEN_PS_SHORTCOLL_NOTICE(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
						if(!returnList.isEmpty() ){
							M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
						}

					} else if (M_RS_REPORT_NAME.contains("I00-3")) {
						M_DUMMY = 1;
						returnList = delegate.GEN_PS_REMINDER_NOTICE(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
						if(!returnList.isEmpty() ){
							M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
						}

					} else if (M_RS_REPORT_NAME.contains("I00-4")) {
						M_DUMMY = 1;
						returnList = delegate.GEN_PS_REMINDER_NOTICE(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
						if(!returnList.isEmpty() ){
							M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
						}
					} else if (M_RS_REPORT_NAME.contains("I00-5")) {
						M_DUMMY = 1;
						returnList = delegate.GEN_PS_LAPSED_NOTICE(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
						if(!returnList.isEmpty() ){
							M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
						}
					} else if (M_RS_REPORT_NAME.contains("I00-6")) {
						M_DUMMY = 1;
						returnList = delegate.GEN_PS_PIA_NOTICE(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
						if(!returnList.isEmpty() ){
							M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
						}
					}
			}
				handler
						.executeInsertStatement(
								"INSERT INTO PS_IL_REMINDER_SUMMARY (SELECT * FROM PW_IL_REMINDER_SUMMARY WHERE  RS_REPORT_NAME  = '"+M_RS_REPORT_NAME +"' AND RS_POL_SYS_ID = '"+M_POL_SYS_ID+"'",
								CommonUtils.getConnection());
				handler
						.executeDeleteStatement(
								"DELETE PW_IL_REMINDER_SUMMARY WHERE  RS_REPORT_NAME = '"+M_RS_REPORT_NAME +"' AND    RS_POL_SYS_ID  = '"+M_POL_SYS_ID+"'",
								CommonUtils.getConnection());
			}
		} catch (Exception cursor2) {
			// TODO: handle exception
			cursor2.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rsC2);
			} catch (Exception e) {
			}
		}

	}

	public void button_Press_Cursor2A(String M_POL_DS_TYPE) {

		ResultSet rsC2A = null;
		this.M_POL_DS_TYPE = M_POL_DS_TYPE;
		try {
			rsC2A = handler.executeSelectStatement(C2A, CommonUtils
					.getConnection());
			while (rsC2A.next()) {
				M_RS_REPORT_NAME = rsC2A.getString(1);
				button_Press_Cursor9();
				button_Press_Cursor2();
				// P_LIFE_LETTER( M_DSRC_SYS_ID,M_RS_REPORT_NAME,:DUMMY.M_PRINT_TYPE,'UW');				 
				handler
						.executeDeleteStatement(
								"DELETE PW_IL_DATA_SOURCE WHERE  DSRC_SYS_ID = '"+M_DSRC_SYS_ID+"'",
								CommonUtils.getConnection());
			}
		} catch (Exception cursor2A) {
			cursor2A.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(rsC2A);
			}catch (Exception e) {
			}
		}
	}

	public void button_Press_Cursor3() {

		ResultSet rsC3 = null;
		ArrayList<OracleParameter> returnList = new ArrayList<OracleParameter>();
		DUMMY_DELEGATE delegate = new DUMMY_DELEGATE();
		try {
			rsC3 = handler.executeSelectStatement(C3, CommonUtils
					.getConnection());
			while (rsC3.next()) {
				M_RS_REPORT_NAME = rsC3.getString(1);
				M_CLAIM_SYS_ID = rsC3.getInt(2);


				if (M_RS_REPORT_NAME.contains("D01_1")) {
					M_DUMMY = 1;
					returnList = delegate.GEN_REMINDER_CLAIMANT_D01(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_CLAIM_SYS_ID);
					if(!returnList.isEmpty()){
						M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
					}
					//P_LIFE_LETTER( M_DSRC_SYS_ID,M_RS_REPORT_NAME,:DUMMY.M_PRINT_TYPE,'CL');	
				} else if (M_RS_REPORT_NAME.contains("T01_1")) {
					M_DUMMY = 1;
					returnList = delegate.GEN_REMINDER_CLAIMANT_T01(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_CLAIM_SYS_ID);
					if(!returnList.isEmpty()){
						M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
					}
					//P_LIFE_LETTER( M_DSRC_SYS_ID,M_RS_REPORT_NAME,:DUMMY.M_PRINT_TYPE,'CL');	                    
				} else if (M_RS_REPORT_NAME.contains("FM01_1")) {
					M_DUMMY = 1;
					returnList = delegate.GEN_REMINDER_PHYSICIAN_FM01(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_CLAIM_SYS_ID);
					if(!returnList.isEmpty()){
						M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
					}
					//P_LIFE_LETTER( M_DSRC_SYS_ID,M_RS_REPORT_NAME,:DUMMY.M_PRINT_TYPE,'CL');
				} else if (M_RS_REPORT_NAME.contains("LM01_1")) {
					M_DUMMY = 1;
					returnList = delegate.GEN_REMINDER_PHYSICIAN_FM01(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_CLAIM_SYS_ID);
					if(!returnList.isEmpty()){
						M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
					}
				}
				handler
						.executeInsertStatement(
								"INSERT INTO PS_IL_REMINDER_SUMMARY (SELECT * FROM PW_IL_REMINDER_SUMMARY WHERE  RS_REPORT_NAME  = '"+M_RS_REPORT_NAME+"' AND    RS_POL_SYS_ID   = '"+M_CLAIM_SYS_ID+"'",
								CommonUtils.getConnection());

				handler
						.executeDeleteStatement(
								"DELETE PW_IL_REMINDER_SUMMARY WHERE  RS_REPORT_NAME = '"+M_RS_REPORT_NAME+"' AND    RS_POL_SYS_ID  = '"+M_CLAIM_SYS_ID+"'",
								CommonUtils.getConnection());
			}
			
		} catch (Exception cursor3) {
			cursor3.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rsC3);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void button_Press_Cursor3A() {

		ResultSet rsC3A = null;
		try {
			rsC3A = handler.executeSelectStatement(C3A, CommonUtils
					.getConnection());
			if (rsC3A.next()) {
				M_RS_REPORT_NAME = rsC3A.getString(1);
				button_Press_Cursor9();
				button_Press_Cursor3();
			}
			handler.executeDeleteStatement(
					"DELETE PW_IL_DATA_SOURCE WHERE  DSRC_SYS_ID = '"
							+ M_DSRC_SYS_ID + "'", CommonUtils.getConnection());
		} catch (Exception cursor3a) {
			cursor3a.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rsC3A);
			} catch (Exception e) {
			}
		}
	}

	public void button_Press_Cursor4() {

		ResultSet rsC4 = null;
		try {
			rsC4 = handler.executeSelectStatement(C4, CommonUtils
					.getConnection());

			while (rsC4.next()) {

				M_PC_DESC = rsC4.getString(1);
				M_PC_BL_DESC = rsC4.getString(2);
			}
		} catch (Exception cursor4) {
			// TODO: handle exception
			cursor4.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rsC4);
			} catch (Exception e) {
			}
		}

	}

	public void button_Press_Cursor5() {

		ResultSet rsC5 = null;
		try {
			rsC5 = handler.executeSelectStatement(C5, CommonUtils
					.getConnection());

			while (rsC5.next()) {
				M_CONT_PREFERRED_LANG = rsC5.getString(1);

				if (M_CONT_PREFERRED_LANG == null
						|| M_CONT_PREFERRED_LANG == "E") {
					M_REP_NAME = M_PC_DESC;
				} else {
					M_REP_NAME = M_PC_BL_DESC;
				}
			}
		} catch (Exception cursor5) {
			// TODO: handle exception
			cursor5.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rsC5);
			} catch (Exception e) {
			}
		}
	}

	public void button_Press_Cursor6() {
		DUMMY_DELEGATE delegate = new DUMMY_DELEGATE();
		ResultSet rsC6 = null;
		ArrayList<OracleParameter> returnList = new ArrayList<OracleParameter>();
		try {
			rsC6 = handler.executeSelectStatement(C6, CommonUtils
					.getConnection());

			while (rsC6.next()) {
				M_SMV_POL_SYS_ID = rsC6.getInt(1);
				M_SMV_TYPE = rsC6.getString(2);

				if ("M".equals(CommonUtils.nvl(M_SMV_TYPE, "M"))) {
					handler
							.executeUpdateStatement(
									"UPDATE PT_IL_POLICYSET    POL_ADDL_STATUS = 'M001' WHERE  POL_SYS_ID = '"+M_SMV_POL_SYS_ID+"' AND    POL_DS_TYPE = '2' ",
									CommonUtils.getConnection());
					M_PRINT_TYPE = "B";
					button_Press_Cursor4();
					button_Press_Cursor5();
					if ("E".equals(CommonUtils.nvl(M_CONT_PREFERRED_LANG ,"E"))) {
						M_REP_NAME = M_PC_DESC;
					} else {
						M_REP_NAME = M_PC_BL_DESC;
					}
				}
				returnList = delegate.GEN_MATURITY_ACK_LETTER(M_DSRC_SYS_ID, M_REP_NAME, M_SMV_POL_SYS_ID);
				if(!returnList.isEmpty()){
					M_DSRC_SYS_ID = Integer.valueOf(returnList.get(0).getValue());
				}
				//P_LIFE_LETTER( M_DSRC_SYS_ID,M_REP_NAME,M_PRINT_TYPE,'UW');	 
			}
		} catch (Exception cursor6) {
			cursor6.printStackTrace();
		}
	}

	public void button_Press_Cursor7() {

		ResultSet rsC7 = null;
		try {
			rsC7 = handler.executeSelectStatement(C7, CommonUtils
					.getConnection());
			while(rsC7.next()) {
				M_POL_SYS_ID_PSTPONE = Integer.parseInt(rsC7.getString(1));

				String upd_Qry = "UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = 'B11'  WHERE  POL_SYS_ID = '"+M_POL_SYS_ID_PSTPONE+"'";

				String Inst_qry = "INSERT INTO PT_IL_POL_STATUS(PS_POL_SYS_ID,PS_END_NO_IDX,PS_STATUS_DT,PS_STATUS,PS_REASON_CODE,PS_REMARKS,PS_STATUS_UID,PS_STATUS_TYPE,PS_CR_UID,PS_CR_DT) VALUES ('"+M_POL_SYS_ID_PSTPONE+"','"
						+ actionBean.getDUMMY_BEAN().getUI_M_PROCESS_DT()
						+ "'"
						+ "'B11',null,null,'"
						+ session.getAttribute("M_USER_ID")
						+ "','S','"
						+ session.getAttribute("M_USER_ID") + "',SYSDATE";
				handler.executeUpdateStatement(upd_Qry, CommonUtils
						.getConnection());
				handler.executeInsertStatement(Inst_qry, CommonUtils
						.getConnection());
			}
		} catch (Exception cursor7) {
			cursor7.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rsC7);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void button_Press_Cursor8() {
		DUMMY_DELEGATE delegate = new DUMMY_DELEGATE();
		ResultSet rsC8 = null;
		try {
			rsC8 = handler.executeSelectStatement(C8, CommonUtils
					.getConnection());
			while (rsC8.next()) {
				M_RS_REPORT_NAME = rsC8.getString(1);
				M_CLAIM_SYS_ID = rsC8.getInt(2);
				if (M_RS_REPORT_NAME == "D01_1") {
					M_DUMMY = 1;
					delegate.GEN_REMINDER_CLAIMANT_D01(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_CLAIM_SYS_ID);
				} else if (M_RS_REPORT_NAME == "T01_1") {
					M_DUMMY = 1;
					delegate.GEN_REMINDER_CLAIMANT_D01(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_CLAIM_SYS_ID);
				} else if (M_RS_REPORT_NAME == "FM01_1") {
					M_DUMMY = 1;
					delegate.GEN_REMINDER_PHYSICIAN_FM01(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_CLAIM_SYS_ID);
				} else if (M_RS_REPORT_NAME == "LM01_1") {
					M_DUMMY = 1;
					delegate.GEN_REMINDER_PHYSICIAN_FM01(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_CLAIM_SYS_ID);
				}
				handler
				.executeInsertStatement(
						"INSERT INTO PS_IL_REMINDER_SUMMARY (SELECT * FROM PW_IL_REMINDER_SUMMARY WHERE  RS_REPORT_NAME  = '"+M_RS_REPORT_NAME +"'AND RS_POL_SYS_ID = '"+M_CLAIM_SYS_ID+"'",
						CommonUtils.getConnection());
				handler
				.executeDeleteStatement(
						"DELETE PW_IL_REMINDER_SUMMARY WHERE  RS_REPORT_NAME = '"+M_RS_REPORT_NAME+"' AND    RS_POL_SYS_ID  = '"+M_CLAIM_SYS_ID+"'",
						CommonUtils.getConnection());
			}
		} catch (Exception cursor8) {
			cursor8.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rsC8);
			} catch (Exception e) {
			}
		}
	}

	public void button_Press_Cursor8A() {

		ResultSet rsC8A = null;
		ResultSet rsC9 = null;
		try {

			rsC8A = handler.executeSelectStatement(C8A, CommonUtils
					.getConnection());
			if (rsC8A.next()) {
				 M_RS_REPORT_NAME = rsC8A.getString(1);
				button_Press_Cursor9();
				 
				rsC9 = handler.executeSelectStatement(C9,
				CommonUtils.getConnection());
				  if(rsC9.next()) { 
					  M_DSRC_SYS_ID = rsC9.getInt(1);
				  }
				button_Press_Cursor8();
			}

			String del_qry_C8A = "DELETE PW_IL_DATA_SOURCE WHERE  DSRC_SYS_ID = '"
					+ M_DSRC_SYS_ID + "'";
			handler.executeDeleteStatement(del_qry_C8A, CommonUtils
					.getConnection());
		} catch (Exception cursor8a) {
			cursor8a.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rsC8A);
				CommonUtils.closeCursor(rsC9);
			} catch (Exception e) {
			}
		}
	}

	public void button_Press_Cursor9() {

		ResultSet rsC9 = null;
		try {
			rsC9 = handler.executeSelectStatement(C9, CommonUtils
					.getConnection());

			while (rsC9.next()) {
				M_DSRC_SYS_ID = rsC9.getInt(1);
			}
			// rs.close();
		} catch (Exception cursor9) {
			cursor9.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rsC9);
			} catch (Exception e) {
			}
		}
	}

	public void P_VAL_SYSTEM(String P_TYPE, String P_CODE, String P_CODE_DESC,
			String P_ERR_FLAG, String P_VALUE) throws Exception {
		System.out
				.println("P_VAL_SYSTEM   INSIDE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DUMMY_ACTION.P_VAL_SYSTEM()");
		this.P_CODE_DESC = P_CODE_DESC;
		this.P_VALUE = P_VALUE;
		ResultSet pvsrs;
		PreparedStatement pvstmt;
		String pvsQuery;
		// CommonUtils.getConnection() = CommonUtils.getConnection();
		pvsQuery = "SELECT PS_CODE_DESC,PS_BL_CODE_DESC,PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE='"
				+ P_TYPE + "' AND PS_CODE='" + P_CODE + "'";
		pvstmt = CommonUtils.getConnection().prepareStatement(pvsQuery);
		pvsrs = pvstmt.executeQuery();
		while (pvsrs.next()) {
			setM_NAME(pvsrs.getString("PS_CODE_DESC"));
			setM_BL_NAME(pvsrs.getString("PS_BL_CODE_DESC"));
			setM_VALUE("" + pvsrs.getInt("PS_VALUE"));
		}
		if (pvsrs.isAfterLast() || pvsrs.isBeforeFirst()) {
			if (P_ERR_FLAG.equals("W") || P_ERR_FLAG.equals("E")) {
				System.out.println("STD_MESSAGE_ROUTINE(1000,NAME_IN.NAME_IN("
						+ session.getAttribute("GLOBAL.M_LANG_CODE") + "))");
				if (P_ERR_FLAG.equals("" + "E")) {
					System.out
							.println("The Err in ERR_FLAG........................");
				}
			}
		}

		pvsrs.close();
		if (session.getAttribute("GLOBAL.M_FOR_LANG_CODE").toString()
				.substring(1, 4).equals("1")
				|| session.getAttribute("GLOBAL.M_LANG_CODE").equals("ENG")) {
			setP_CODE_DESC(getM_NAME());
		} else {
			setP_CODE_DESC(getM_NAME());
		}
		setP_VALUE(M_VALUE);
		setM_CALC_METHOD(getP_VALUE());

		System.out.println("The Results are " + getP_CODE_DESC() + "--------"
				+ getP_VALUE());
	}

	public String getP_VALUE() {
		return P_VALUE;
	}

	public void setP_VALUE(String p_value) {
		P_VALUE = p_value;
	}

	public String getP_CODE_DESC() {
		return P_CODE_DESC;
	}

	public void setP_CODE_DESC(String p_code_desc) {
		P_CODE_DESC = p_code_desc;
	}

	public String getM_NAME() {
		return M_NAME;
	}

	public void setM_NAME(String m_name) {
		M_NAME = m_name;
	}

	public String getM_BL_NAME() {
		return M_BL_NAME;
	}

	public void setM_BL_NAME(String m_bl_name) {
		M_BL_NAME = m_bl_name;
	}

	public String getM_VALUE() {
		return M_VALUE;
	}

	public void setM_VALUE(String m_value) {
		M_VALUE = m_value;
	}

	public String getM_CALC_METHOD() {
		return M_CALC_METHOD;
	}

	public void setM_CALC_METHOD(String m_calc_method) {
		M_CALC_METHOD = m_calc_method;
	}
       
}
