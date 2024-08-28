package com.iii.pel.forms.PILP025;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.jasperreports.CallJasPerReport;
import com.iii.pel.jasperreports.OpenJasPerReport;
import com.iii.pel.utils.LIFE;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER extends CommonAction {

	//Map<String, Object> session = getSession();

	// Triggers Starts from Here
	CRUDHandler handler = new CRUDHandler();
	CommonUtils util = new CommonUtils();
	//ControlBean ctrlBean = null;
	/*public void createCtrlBean(){
		ControlBean bean = new ControlBean();
		getSession().put("ctrlbean", bean);
	}
	public Map<String, Object> getSession(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}
	public ControlBean getCtrlBean(){
		return (ControlBean) getSession().get("ctrlbean");
	}
	public void putCtrlBean(ControlBean bean){
		getSession().put("ctrlbean", bean);
	}*/

	//For Set First Field policy_fm 
	public void pilp025_dummy_ui_m_policy_fm_when_validate_item() {
		String mappedBeanName="PILP025_DUMMY_ACTION";
		CommonUtils utility=new CommonUtils();
		DUMMY_ACTION actionBean=(DUMMY_ACTION)utility.getMappedBeanFromSession(mappedBeanName);

		if(actionBean.getCOMP_UI_M_POLICY_FM().getSubmittedValue()==null|| 
				((String)actionBean.getCOMP_UI_M_POLICY_FM().getSubmittedValue()).trim().length()==0){
			actionBean.getDUMMY_BEAN().setUI_M_POLICY_FM("0");
			actionBean.getCOMP_UI_M_POLICY_FM().setSubmittedValue(null);
		}
	}
	//For Set First field field UI_M_DIVN_FM
	public void pilp025_dummy_ui_m_divn_fm_when_validate_item() {
		String mappedBeanName="PILP025_DUMMY_ACTION";
		CommonUtils utility=new CommonUtils();
		DUMMY_ACTION actionBean=(DUMMY_ACTION)utility.getMappedBeanFromSession(mappedBeanName);

		if(actionBean.getCOMP_UI_M_DIVN_FM().getSubmittedValue()==null|| 
				((String)actionBean.getCOMP_UI_M_DIVN_FM().getSubmittedValue()).trim().length()==0){
			actionBean.getDUMMY_BEAN().setUI_M_DIVN_FM("0");
			actionBean.getCOMP_UI_M_DIVN_FM().setSubmittedValue(null);
		}
	}
	// For setting the secong Field Value for DIVN_TO
	public void pilp025_dummy_ui_m_divn_to_when_validate_item() {
		String mappedBeanName="PILP025_DUMMY_ACTION";
		List resultList=null;
		CommonUtils utility=new CommonUtils();

		DUMMY_ACTION actionBean=(DUMMY_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		String fromDivnCode=(String)actionBean.getCOMP_UI_M_DIVN_FM().getSubmittedValue();
		String toDivnCode=(String)actionBean.getCOMP_UI_M_DIVN_TO().getSubmittedValue();


		if(toDivnCode==null || toDivnCode.trim().length()==0){

			if(fromDivnCode.equals("0")){
				actionBean.getDUMMY_BEAN().setUI_M_DIVN_TO("zzzzzzzzzzzz");

			}else{
				actionBean.getDUMMY_BEAN().setUI_M_DIVN_TO(fromDivnCode);
			}
			//setting submitted values to null so that JSF will pick values for
			//the fields from value bean
			actionBean.getCOMP_UI_M_DIVN_TO().setSubmittedValue(null);	
		}else{
			//procedure call to compare fromCode and toCode
			List<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",fromDivnCode);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN",toDivnCode);
			OracleParameter param3 = new OracleParameter("in3","STRING","OUT","");
			paramList.add(param1);
			paramList.add(param2);	
			paramList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			try {
				resultList = procHandler.execute((ArrayList)paramList, utility.getConnection(), 
				"PR_VALIDATE_FM_TO");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if(Integer.parseInt(((OracleParameter)resultList.get(0)).getValue())==1){
				String message=Messages.getString(PELConstants.pelErrorMessagePath, "10064");
				Map<String, String> errMap = actionBean.getErrorMap(); 
				errMap.put("current",message);
				errMap.put("someKey",message);
			}else
			{
				getErrorMap().clear();

			}
		}
		L_VAL_FROM_TO(fromDivnCode,toDivnCode);
	}
	// Method for L_VAL_FROM_TO    
	public void L_VAL_FROM_TO(String fr_dt,String to_dt)
	{
		String mappedBeanName="PILP025_DUMMY_ACTION";
		CommonUtils utility=new CommonUtils();
		DUMMY_ACTION actionBean=(DUMMY_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		if(fr_dt=="")
		{
			System.out.println("There is an Error in Date it should not ne greater than Zero");
			String message=Messages.getString(PELConstants.pelErrorMessagePath, "80033");
			Map<String, String> errMap = getErrorMap(); 
			errMap.put("current",message);
			errMap.put("someKey",message);

		}else{
			getErrorMap().clear();
		}
	}

	//For setting first value for UI_M_DEPT_FM
	public void pilp025_dummy_ui_m_dept_fm_when_validate_item() {
		String mappedBeanName="PILP025_DUMMY_ACTION";
		CommonUtils utility=new CommonUtils();
		DUMMY_ACTION actionBean=(DUMMY_ACTION)utility.getMappedBeanFromSession(mappedBeanName);

		if(actionBean.getCOMP_UI_M_DEPT_FM().getSubmittedValue()==null|| 
				((String)actionBean.getCOMP_UI_M_DEPT_FM().getSubmittedValue()).trim().length()==0){
			actionBean.getDUMMY_BEAN().setUI_M_DEPT_FM("0");
			actionBean.getCOMP_UI_M_DEPT_FM().setSubmittedValue(null);

		}
	}
	//For setting first value for UI_M_DEPT_TO
	public void pilp025_dummy_ui_m_dept_to_when_validate_item() {
		String mappedBeanName="PILP025_DUMMY_ACTION";
		List resultList=null;
		CommonUtils utility=new CommonUtils();

		DUMMY_ACTION actionBean=(DUMMY_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		String fromDivnCode=(String)actionBean.getCOMP_UI_M_DEPT_FM().getSubmittedValue();
		String toDivnCode=(String)actionBean.getCOMP_UI_M_DEPT_TO().getSubmittedValue();

		if(toDivnCode==null || toDivnCode.trim().length()==0){
			if(fromDivnCode.equals("0")){
				actionBean.getDUMMY_BEAN().setUI_M_DEPT_TO("zzzzzzzzzzzz");
			}else{
				actionBean.getDUMMY_BEAN().setUI_M_DEPT_TO(fromDivnCode);
			}
			//setting submitted values to null so that JSF will pick values for
			//the fields from value bean
			actionBean.getCOMP_UI_M_DEPT_TO().setSubmittedValue(null);
		}else{
			//procedure call to compare fromCode and toCode
			List<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",fromDivnCode);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN",toDivnCode);
			OracleParameter param3 = new OracleParameter("in3","STRING","OUT","");
			paramList.add(param1);
			paramList.add(param2);	
			paramList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			try {
				resultList = procHandler.execute((ArrayList)paramList, utility.getConnection(), 
				"PR_VALIDATE_FM_TO");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			if(Integer.parseInt(((OracleParameter)resultList.get(0)).getValue())==1){
				String message=Messages.getString(PELConstants.pelErrorMessagePath, "10064");
				Map<String, String> errMap = actionBean.getErrorMap(); 
				errMap.put("current",message);
				errMap.put("someKey",message);
			}
			else
			{
				getErrorMap().clear();
			}
		}
	}
	// for comparing the from and to Date 
	DUMMY_ACTION DUMMY_ACTION_BEAN = new DUMMY_ACTION();
	public void compare_Date(Date from_Date,Date to_Date){
		System.out.println("Now i am in Compare Method");
		System.out.println("From Date"+from_Date);
		System.out.println("To Date"+to_Date);
		if(from_Date != null && to_Date != null){
			if(from_Date.compareTo(to_Date) > 0){
				System.out.println("There is an Error in Date it should not ne greater than Zero");
				String message=Messages.getString(PELConstants.pelErrorMessagePath, "71145");
				Map<String, String> errMap = DUMMY_ACTION_BEAN.getErrorMap(); 
				errMap.put("current",message);
				errMap.put("someKey",message);
				//	getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71145").getDetail());
			}else{
				getErrorMap().clear();
			}
		}
	}
	// NVL Method for replacing Null Value with some Value

	public String nvl(String  value1 ,String  value2){
		if("".equals(value1)){
			value1 = ""+value2;
		}
		return value1;

	}
	//Mehtod to be called when Process Button Pressed	(Not implemented once the print server is finalized its needs to be implemented............) 
	public String when_process_button_pressed(DUMMY dummyBean) throws Exception{
		String mappedBeanName="PILP025_DUMMY_ACTION";
		List resultList=null;
		Iterator<List> iterator = null;
		CommonUtils utility=new CommonUtils();
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		String M_PLAN_TYPE = null;
		String M_POL_SYS_ID = null;
		String M_CSVSD_PARA_CODE_DESC = null;
		String outCome = null;
		String M_REP_NAME = null;

		//DUMMY_ACTION actionBean=(DUMMY_ACTION)utility.getMappedBeanFromSession(mappedBeanName);

		//  "SELECT 'X' FROM  PM_AGENT_WITH_DRAWL_SETUP  WHERE  (AWDS_TYPE  = '"++"');
		String C1 ="SELECT PLAN_TYPE, POL_SYS_ID,POL_NO FROM PM_IL_PLAN, " +
		"PT_IL_POLICY WHERE  PLAN_CODE = POL_PLAN_CODE AND POL_DS_TYPE = '2' " +
		"AND POL_NO BETWEEN ? AND ? AND POL_DIVN_CODE BETWEEN ? AND ? AND " +
		"POL_DEPT_CODE BETWEEN ? AND ? AND POL_ISSUE_DT BETWEEN ? AND ? ";

		String C2 ="SELECT CSVSD_PARA_CODE_DESC FROM PP_COMP_SITE_VALUE_SET_DTL," +
		"PP_COMP_SITE_VALUE_SET_HDR WHERE CSVSD_PARA_TYPE = 'ADDLFORM1' AND " +
		"CSVSD_PARA_CODE = ? AND CSVSH_SYS_ID = CSVSD_CSVSH_SYS_ID AND CSVSH_SITE_CODE = ? ";

		String C3 = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'SITE'";

		String C4 = "SELECT DISTINCT RS_REPORT_NAME FROM PS_IL_REMINDER_SUMMARY " +
		"WHERE RS_POL_SYS_ID IN (SELECT POL_SYS_ID FROM PM_IL_CONTRACTOR, " +
		"PT_IL_POLICY WHERE POL_CONT_CODE = CONT_CODE AND NVL(CONT_LC_POL_DEP_AMT,0) > " +
		"NVL(CONT_LC_POL_UTIL_AMT,0) AND POL_DS_TYPE = '2' AND POL_NO BETWEEN ? " +
		"AND ? AND POL_DIVN_CODE BETWEEN ? AND ? AND POL_DEPT_CODE BETWEEN ? " +
		"AND ? AND POL_ISSUE_DT BETWEEN ? AND ? ) GROUP BY RS_REPORT_NAME";

		String C5 = "UPDATE PT_IL_POLICY SET POL_NL_FM_DT =TRUNC(SYSDATE) WHERE " +
		"POL_NO BETWEEN ? AND ? AND POL_DIVN_CODE BETWEEN ? AND ? AND " +
		"POL_DEPT_CODE BETWEEN ? AND ? AND POL_ISSUE_DT BETWEEN ? AND ? AND " +
		"POL_NL_FM_DT IS NULL AND POL_DS_TYPE=2";

		System.out.println("The Query of C1>>>>>>>>>>>>>>"+C1);
		System.out.println("The Query of C3>>>>>>>>>>>>>>"+C3);
		System.out.println("The Query of C4>>>>>>>>>>>>>>"+C4);
		String 	PROP_DRIP_YN = dummyBean.getUI_M_PROP_DRIP_YN();

		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			if("Y".equals(CommonUtils.nvl(PROP_DRIP_YN, "N"))){
				resultSet = handler.executeSelectStatement(C3, connection);
				if(resultSet.next()){
					CommonUtils.setGlobalVariable("GLOBAL.M_SITE", resultSet.getString(1));
				}
				resultSet = handler.executeSelectStatement(C1, connection, new Object[]{
						dummyBean.getUI_M_POLICY_FM(), dummyBean.getUI_M_POLICY_TO(),
						dummyBean.getUI_M_DIVN_FM(), dummyBean.getUI_M_DIVN_TO(),
						dummyBean.getUI_M_DEPT_FM(), dummyBean.getUI_M_DEPT_TO(),
						dummyBean.getUI_M_FM_DT(), dummyBean.getUI_M_TO_DT()});
				while(resultSet.next()){
					M_PLAN_TYPE = resultSet.getString(1);
					M_POL_SYS_ID = resultSet.getString(2);
					CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", resultSet.getString(3));
					CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID", M_POL_SYS_ID);
					resultSet1 = handler.executeSelectStatement(C2, connection, new Object[]{
							M_PLAN_TYPE, CommonUtils.getGlobalVariable("GLOBAL.M_SITE")});
					if(resultSet1.next()){
						M_CSVSD_PARA_CODE_DESC = resultSet1.getString(1);
					}
					if(M_CSVSD_PARA_CODE_DESC != null){
						outCome = M_CSVSD_PARA_CODE_DESC;
					}
				}
			}

			// for calling the Trigger	for Printing Certificates
			String Cert_PRN_YN = dummyBean.getUI_M_CERT_PRINT_YN();	
			if("Y".equals(CommonUtils.nvl(Cert_PRN_YN, "N"))){
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN1",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_POLICY_FM());
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN2",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_POLICY_TO());
				parameterList.add(param2);
				OracleParameter param3 = new OracleParameter("IN3",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_DIVN_FM());
				parameterList.add(param3);
				OracleParameter param4 = new OracleParameter("IN4",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_DIVN_TO());
				parameterList.add(param4);
				OracleParameter param5 = new OracleParameter("IN5",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_DEPT_FM());
				parameterList.add(param5);
				OracleParameter param6 = new OracleParameter("IN6",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_DEPT_TO());
				parameterList.add(param6);
				OracleParameter param7 = new OracleParameter("IN7",
						OracleParameter.DATA_TYPE.DATE,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_FM_DT());
				parameterList.add(param7);
				OracleParameter param8 = new OracleParameter("IN8",
						OracleParameter.DATA_TYPE.DATE,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_TO_DT());
				parameterList.add(param8);

				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.executeProc(parameterList, connection,
						"P9ILPK_POL_PRINT.PRINT_CERTIFICATE");

			}
			//for calling the Trigger	for GEN_EXCESS_PAYMENT_LETTER	
			String EXE_PREMIUM_YN = dummyBean.getUI_M_EXE_PREMIUM_YN();
			if("Y".equals(CommonUtils.nvl(EXE_PREMIUM_YN,"N"))){
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN1",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_POLICY_FM());
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN2",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_POLICY_TO());
				parameterList.add(param2);
				OracleParameter param3 = new OracleParameter("IN3",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_DIVN_FM());
				parameterList.add(param3);
				OracleParameter param4 = new OracleParameter("IN4",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_DIVN_TO());
				parameterList.add(param4);
				OracleParameter param5 = new OracleParameter("IN5",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_DEPT_FM());
				parameterList.add(param5);
				OracleParameter param6 = new OracleParameter("IN6",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_DEPT_TO());
				parameterList.add(param6);
				OracleParameter param7 = new OracleParameter("IN7",
						OracleParameter.DATA_TYPE.DATE,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_FM_DT());
				parameterList.add(param7);
				OracleParameter param8 = new OracleParameter("IN8",
						OracleParameter.DATA_TYPE.DATE,
						OracleParameter.DIRECTION_TYPE.IN, dummyBean
						.getUI_M_TO_DT());
				parameterList.add(param8);

				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.executeProc(parameterList, connection,
						"P9ILPK_UW_LETTERS.GEN_EXCESS_PAYMENT_LETTER");
				CommonUtils.doComitt();
				resultSet = handler.executeSelectStatement(C4, connection, new Object[]{
						dummyBean.getUI_M_POLICY_FM(), dummyBean.getUI_M_POLICY_TO(),
						dummyBean.getUI_M_DIVN_FM(), dummyBean.getUI_M_DIVN_TO(),
						dummyBean.getUI_M_DEPT_FM(), dummyBean.getUI_M_DEPT_TO(),
						dummyBean.getUI_M_FM_DT(), dummyBean.getUI_M_TO_DT()});
				while(resultSet.next()){
					M_REP_NAME = resultSet.getString(1);
					new LIFE().P_LIFE_LETTER_BATCH(M_REP_NAME, 'B');
					call_report();
				}
				handler.executeDeleteStatement("DELETE PW_IL_DATA_SOURCE", connection);
			}
			handler.executeUpdateStatement(C5, connection, new Object[]{
					dummyBean.getUI_M_POLICY_FM(), dummyBean.getUI_M_POLICY_TO(),
					dummyBean.getUI_M_DIVN_FM(), dummyBean.getUI_M_DIVN_TO(),
					dummyBean.getUI_M_DEPT_FM(), dummyBean.getUI_M_DEPT_TO(),
					dummyBean.getUI_M_FM_DT(), dummyBean.getUI_M_TO_DT()});
			CommonUtils.doComitt();
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return outCome;
	}//method Close


	/*public void when_process_button_validate_pressed()
	{
		System.out.println("The method for validations.................................");

	}*/
	public void call_report() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		String reportName = "P_LIFE_LETTER_BATCH_BATCH_PRNT.jrxml";
		String generatedFilename = "P_LIFE_LETTER_BATCH_BATCH_PRNT";
		Map params = new HashMap();
		params.put("name", "Batch Printing Letters");

		try {
			new CallJasPerReport().generateReport(request, reportName,generatedFilename, params);
			new OpenJasPerReport().generateReport(request, response, context,generatedFilename);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}


