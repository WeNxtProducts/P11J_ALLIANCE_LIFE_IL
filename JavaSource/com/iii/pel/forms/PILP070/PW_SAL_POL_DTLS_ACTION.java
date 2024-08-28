package com.iii.pel.forms.PILP070;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP017.DUMMY;
import com.iii.pel.forms.PILT006_APAC.PT_IL_CLAIM_COVER_DTLS;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PW_SAL_POL_DTLS_ACTION extends CommonAction {
	
	private HtmlOutputLabel COMP_CAPTION;
	
	private HtmlGraphicImage COMP_EMP_IMG;
	
	
	private HtmlOutputLabel COMP_UI_MICR_CODE_LABEL;
	private HtmlInputText   COMP_UI_MICR_CODE;
	
	private HtmlOutputLabel  COMP_UI_PS_PROC_YEAR_LABEL;
	private HtmlInputText COMP_UI_PS_PROC_YEAR;
	
	private HtmlOutputLabel  COMP_UI_PS_EMPLOYER_CODE_LABEL;
	private HtmlInputText COMP_UI_PS_EMPLOYER_CODE;

	private HtmlOutputLabel  COMP_UI_PS_REF_NO_LABEL;
	private HtmlInputText COMP_UI_PS_REF_NO;
	
	
	private HtmlOutputLabel COMP_UI_PS_PROC_MON_LABEL;
	private HtmlSelectOneMenu COMP_UI_PS_PROC_MON;
	
	/* Newly Added By Dhinesh on 27-9-2017*/
	
	private HtmlInputText COMP_PSP_POL_DUE_NO;
	private HtmlOutputLabel COMP_PSP_POL_DUE_NO_LABEL;
	
	public HtmlOutputLabel getCOMP_PSP_POL_DUE_NO_LABEL() {
		return COMP_PSP_POL_DUE_NO_LABEL;
	}

	public void setCOMP_PSP_POL_DUE_NO_LABEL(
			HtmlOutputLabel cOMP_PSP_POL_DUE_NO_LABEL) {
		COMP_PSP_POL_DUE_NO_LABEL = cOMP_PSP_POL_DUE_NO_LABEL;
	}

	public HtmlInputText getCOMP_PSP_POL_DUE_NO() {
		return COMP_PSP_POL_DUE_NO;
	}

	public void setCOMP_PSP_POL_DUE_NO(HtmlInputText cOMP_PSP_POL_DUE_NO) {
		COMP_PSP_POL_DUE_NO = cOMP_PSP_POL_DUE_NO;
	}

	private HtmlOutputLabel COMP_UI_PS_PROC_DT_LABEL;
	
	private HtmlCalendar COMP_UI_PS_PROC_DT;
	
	private UIData dataTable;
	/*	private ArrayList<SelectItem> listMonth =  new ArrayList<SelectItem>();*/
	private List<SelectItem> listMonth =  new ArrayList<SelectItem>();
	private ArrayList<SelectItem> listPSP_CHK_FLAG = new ArrayList<SelectItem>();
	
	
	
	/*
	 * Commented by sankara narayanan on 11/04/2017
	 * private ArrayList<PW_SAL_POL_DTLS> datalist_PW_SAL_POL_DTLS = new ArrayList<PW_SAL_POL_DTLS>();*/
	private List<PW_SAL_POL_DTLS> datalist_PW_SAL_POL_DTLS = new ArrayList<PW_SAL_POL_DTLS>();
	
	private HtmlCommandButton COMP_UI_m_post;
	
	
	public HtmlCommandButton getCOMP_UI_m_post() {
		return COMP_UI_m_post;
	}

	public void setCOMP_UI_m_post(HtmlCommandButton cOMP_UI_m_post) {
		COMP_UI_m_post = cOMP_UI_m_post;
	}

	private PW_SAL_POL_DTLS PW_SAL_POL_DTLS_BEAN;
	private PW_SAL_POL_DTLS_HELPER  helper;

	
	public PW_SAL_POL_DTLS_ACTION() {
		listPSP_CHK_FLAG.add(new SelectItem("Y","Yes"));
		listPSP_CHK_FLAG.add(new SelectItem("N","No"));
		setListItemValues();
		initializeallcomponent();
		/*
		 * Commented by sankara narayanan on 05/04/2017
		 * ArrayList<SelectItem> listTmp = new ArrayList<SelectItem>();
		listTmp.add(new SelectItem("1","JAN"));
		listTmp.add(new SelectItem("2","FEB"));
		listTmp.add(new SelectItem("3","MAR"));
		listTmp.add(new SelectItem("4","APR"));
		listTmp.add(new SelectItem("5","MAY"));
		listTmp.add(new SelectItem("6","JUN"));
		listTmp.add(new SelectItem("7","JULY"));
		listTmp.add(new SelectItem("8","AUG"));
		listTmp.add(new SelectItem("9","SEP"));
		listTmp.add(new SelectItem("10","OCT"));
		listTmp.add(new SelectItem("11","NOV"));
		listTmp.add(new SelectItem("12","DEC"));
		setListMonth(listTmp);*/
		PW_SAL_POL_DTLS_BEAN = new PW_SAL_POL_DTLS();
		helper = new PW_SAL_POL_DTLS_HELPER();
		
	}

	public PW_SAL_POL_DTLS getPW_SAL_POL_DTLS_BEAN() {
		return PW_SAL_POL_DTLS_BEAN;
	}

	public void setPW_SAL_POL_DTLS_BEAN(PW_SAL_POL_DTLS pw_sal_pol_dtls_bean) {
		PW_SAL_POL_DTLS_BEAN = pw_sal_pol_dtls_bean;
	}

	public PW_SAL_POL_DTLS_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PW_SAL_POL_DTLS_HELPER helper) {
		this.helper = helper;
	}

	public HtmlOutputLabel getCOMP_UI_PS_PROC_YEAR_LABEL() {
		return COMP_UI_PS_PROC_YEAR_LABEL;
	}

	public void setCOMP_UI_PS_PROC_YEAR_LABEL(
			HtmlOutputLabel comp_ui_ps_proc_year_label) {
		COMP_UI_PS_PROC_YEAR_LABEL = comp_ui_ps_proc_year_label;
	}

	public HtmlInputText getCOMP_UI_PS_PROC_YEAR() {
		return COMP_UI_PS_PROC_YEAR;
	}

	public void setCOMP_UI_PS_PROC_YEAR(HtmlInputText comp_ui_ps_proc_year) {
		COMP_UI_PS_PROC_YEAR = comp_ui_ps_proc_year;
	}

	public HtmlOutputLabel getCOMP_UI_PS_EMPLOYER_CODE_LABEL() {
		return COMP_UI_PS_EMPLOYER_CODE_LABEL;
	}

	public void setCOMP_UI_PS_EMPLOYER_CODE_LABEL(
			HtmlOutputLabel comp_ui_ps_employer_code_label) {
		COMP_UI_PS_EMPLOYER_CODE_LABEL = comp_ui_ps_employer_code_label;
	}

	public HtmlInputText getCOMP_UI_PS_EMPLOYER_CODE() {
		return COMP_UI_PS_EMPLOYER_CODE;
	}

	public void setCOMP_UI_PS_EMPLOYER_CODE(HtmlInputText comp_ui_ps_employer_code) {
		COMP_UI_PS_EMPLOYER_CODE = comp_ui_ps_employer_code;
	}

	public HtmlOutputLabel getCOMP_UI_PS_REF_NO_LABEL() {
		return COMP_UI_PS_REF_NO_LABEL;
	}

	public void setCOMP_UI_PS_REF_NO_LABEL(HtmlOutputLabel comp_ui_ps_ref_no_label) {
		COMP_UI_PS_REF_NO_LABEL = comp_ui_ps_ref_no_label;
	}

	public HtmlInputText getCOMP_UI_PS_REF_NO() {
		return COMP_UI_PS_REF_NO;
	}

	public void setCOMP_UI_PS_REF_NO(HtmlInputText comp_ui_ps_ref_no) {
		COMP_UI_PS_REF_NO = comp_ui_ps_ref_no;
	}

	public HtmlOutputLabel getCOMP_UI_PS_PROC_MON_LABEL() {
		return COMP_UI_PS_PROC_MON_LABEL;
	}

	public void setCOMP_UI_PS_PROC_MON_LABEL(
			HtmlOutputLabel comp_ui_ps_proc_mon_label) {
		COMP_UI_PS_PROC_MON_LABEL = comp_ui_ps_proc_mon_label;
	}

	public HtmlSelectOneMenu getCOMP_UI_PS_PROC_MON() {
		return COMP_UI_PS_PROC_MON;
	}

	public void setCOMP_UI_PS_PROC_MON(HtmlSelectOneMenu comp_ui_ps_proc_mon) {
		COMP_UI_PS_PROC_MON = comp_ui_ps_proc_mon;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	/*
	 * Commented by sankaranarayanan on 05/04/2017
	 * public ArrayList<SelectItem> getListMonth() {
		return listMonth;
	}

	public void setListMonth(ArrayList<SelectItem> listMonth) {
		this.listMonth = listMonth;
	}*/
	
	
	

	/*
	 * 
	 * 
	 * Commented by sankara narayanan on 11/04/2017
	 * public ArrayList<PW_SAL_POL_DTLS> getDatalist_PW_SAL_POL_DTLS() {
		return datalist_PW_SAL_POL_DTLS;
	}

	
	public void setDatalist_PW_SAL_POL_DTLS(
			ArrayList<PW_SAL_POL_DTLS> datalist_PW_SAL_POL_DTLS) {
		this.datalist_PW_SAL_POL_DTLS = datalist_PW_SAL_POL_DTLS;
	}*/
	
	/*Added by sankara narayanan on 05/04/2017*/
	
	
	
	public List<SelectItem> getListMonth() {
		return listMonth;
	}
	public List<PW_SAL_POL_DTLS> getDatalist_PW_SAL_POL_DTLS() {
		return datalist_PW_SAL_POL_DTLS;
	}

	public void setDatalist_PW_SAL_POL_DTLS(
			List<PW_SAL_POL_DTLS> datalist_PW_SAL_POL_DTLS) {
		this.datalist_PW_SAL_POL_DTLS = datalist_PW_SAL_POL_DTLS;
	}

	public void setListMonth(List<SelectItem> listMonth) {
		this.listMonth = listMonth;
	}

	/*end*/
	
	public void onBlurSelectYN(ActionEvent event) {
		try{
		PW_SAL_POL_DTLS mergeBean = (PW_SAL_POL_DTLS) dataTable.getRowData();
		String yesNo = (String) ((UIInput)event.getComponent().getParent()).getSubmittedValue();
		mergeBean.setPSP_CHK_FLAG(yesNo);
		new CRUDHandler().executeUpdate(mergeBean, CommonUtils.getConnection());
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Record Inserted,Please save it.");
		getWarningMap().put("CURRENT", "Record Inserted,Please save it.");
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		//lastColumnListener(renewalBean);
	}
	
	public ArrayList<LovBean> lovPOL_EMPLOYER_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		/*Modified by ganesh on 31-05-2017,ZBILQC-1724500 */
		/*added by raja on 27-06-2017 for ZBILQC-1729595*/
		/*String query = "SELECT  CONT_CODE,CONT_NAME  FROM   PM_IL_CONTRACTOR WHERE  CONT_EMPLOYER_YN ='Y' "
				+ "AND (CONT_CODE LIKE ? OR CONT_NAME LIKE ?) AND ROWNUM < ?";*/
		String query ="SELECT DUM_EMPLOYER_CODE, CONT_NAME FROM PM_IL_DATA_UPLOAD_MAPPING, PM_IL_CONTRACTOR WHERE DUM_EMPLOYER_TYPE = 'D' AND DUM_EMPLOYER_CODE = CONT_CODE AND (DUM_EMPLOYER_CODE LIKE ? OR CONT_NAME LIKE ?) AND ROWNUM < ? UNION SELECT DUM_EMPLOYER_CODE, BANK_NAME FROM PM_IL_DATA_UPLOAD_MAPPING, PM_BANK WHERE DUM_EMPLOYER_TYPE = 'D' AND DUM_EMPLOYER_CODE = BANK_CODE AND (DUM_EMPLOYER_CODE LIKE ? OR BANK_NAME LIKE ?)  AND ROWNUM < ? ";
		/*end*/
		Object[] values = null;
		String currentValue = (String) object;
		/*end*/

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			/*Modified by ganesh on 31-05-2017,ZBILQC-1724500 */
			/*values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };*/
			values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize,currentValue, currentValue,
					PELConstants.suggetionRecordSize};
			/*end*/
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	
	
	public void saveRecord() {
		getErrorMap().clear();
		getWarningMap().clear();
	try {
		CommonUtils.getConnection().commit();
		saveflag=true; /*AdDED BY SANKARA NARAYANAN ON 13/04/2017*/
		getWarningMap().put(
				PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));
		getWarningMap().put(
				"postRecord",
				Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));
	} catch (Exception e) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("SAVE", e.getMessage());
	}
}
	
	private final static ResourceBundle resourceBundleDatabase = ResourceBundle
			.getBundle("Report_ID");
	
	public void lastColoumListener(PW_SAL_POL_DTLS dtlsBean){
		/*Connection connection = null;
		ResultSet resultSet = null;
		String query = "UPADTE PW_SAL_POL_DTLS SET PSP_CHK_FLAG = ? WHERE ROWID = ? ";
		try {
			connection =CommonUtils.getConnection();
			
		} catch (DBException e) {
			e.printStackTrace();
		}*/
		 
		
	}
	
	
	public void getDetails(){
		//call procedure
		try {
			String value = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
			if("AD".equals(value)){
			
				/*cOMMENTED BY SANKARA NARAYANAN 1/04/2017
				 * INS_PW_SAL_POL_DTLS_MICR(getPW_SAL_POL_DTLS_BEAN().getUI_MICR_CODE(),getPW_SAL_POL_DTLS_BEAN().getUI_PS_PROC_DT());*/	
			/*AdDED BY SANKARA NARAYANAN ON 13/04/2017*/
				INS_PW_SAL_POL_DTLS_MICR(getPW_SAL_POL_DTLS_BEAN().getUI_MICR_CODE(),getPW_SAL_POL_DTLS_BEAN().getUI_PS_PROC_DT(),getPW_SAL_POL_DTLS_BEAN().getUI_PAY_MODE());
			//END
				executeQuery();
			}else{
				
				/*
				 * cOMMENTED BY SANKARA NARAYANAN 1/04/2017
				 * 
				 * INS_PW_SAL_POL_DTLS(String.valueOf(getPW_SAL_POL_DTLS_BEAN().getUI_PS_EMPLOYER_CODE()),getPW_SAL_POL_DTLS_BEAN().getUI_PS_PROC_DT());*/
				/*AdDED BY SANKARA NARAYANAN ON 13/04/2017*/
				INS_PW_SAL_POL_DTLS(String.valueOf(getPW_SAL_POL_DTLS_BEAN().getUI_PS_EMPLOYER_CODE()),getPW_SAL_POL_DTLS_BEAN().getUI_PS_PROC_DT(),getPW_SAL_POL_DTLS_BEAN().getUI_PAY_MODE());
				//END
				executeQuery();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}finally{}
		
		
	}
	
	
	
	public void process(){
		String P_ERROR_YN = null;
		try{
			String value = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");	
			if("AD".equals(value)){
				/* cOMMENTED BY SANKARA NARAYANAN ON 1304/2017
				PR_SCO_PROCESS(P_ERROR_YN, CommonUtils.dateToStringFormatter(PW_SAL_POL_DTLS_BEAN.getUI_PS_PROC_DT()),
						PW_SAL_POL_DTLS_BEAN.getUI_MICR_CODE(), 
						"123456");*/
				
				/*ADDED BY SANKARA NARAYANAN FOR DIRECT DEBIT ADDING ONE MORE PARAMETER ON 13/04/2017*/
				PR_SCO_PROCESS(P_ERROR_YN, CommonUtils.dateToStringFormatter(PW_SAL_POL_DTLS_BEAN.getUI_PS_PROC_DT()),
					PW_SAL_POL_DTLS_BEAN.getUI_MICR_CODE(), 
					"123456",getPW_SAL_POL_DTLS_BEAN().getUI_PAY_MODE());
				//END
			}else{
				/*
				 * cOMMENTED BY SANKARA NARAYANAN ON 1304/2017
				 * 
				 * 
				 * 
				PR_SCO_PROCESS(P_ERROR_YN, CommonUtils.dateToStringFormatter(PW_SAL_POL_DTLS_BEAN.getUI_PS_PROC_DT()),
						PW_SAL_POL_DTLS_BEAN.getUI_PS_EMPLOYER_CODE(), 
						"123456");*/
				/*ADDED BY SANKARA NARAYANAN FOR DIRECT DEBIT ADDING ONE MORE PARAMETER ON 13/04/2017*/
					PR_SCO_PROCESS(P_ERROR_YN, CommonUtils.dateToStringFormatter(PW_SAL_POL_DTLS_BEAN.getUI_PS_PROC_DT()),
						PW_SAL_POL_DTLS_BEAN.getUI_PS_EMPLOYER_CODE(), 
						"123456",getPW_SAL_POL_DTLS_BEAN().getUI_PAY_MODE());
					//END
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Process Completed successfully");
			getWarningMap().put("CURRENT", "Process Completed successfully");
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	
	}
	
	
	public ArrayList<OracleParameter> INS_PW_SAL_POL_DTLS(
			Object P_EMPLOYER_CODE, Object P_PROC_DT,Object P_PAY_MODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_EMPLOYER_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_PROC_DT);
			parameterList.add(param2);
			/*ADDED BY SANKARA NARAYANAN FOR DIRECT DEBIT ADDING ONE MORE PARAMETER ON 13/04/2017*/
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PAY_MODE);
			parameterList.add(param3); //END

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_SALARY_CHKOFF.INS_PW_SAL_POL_DTLS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
		
		
		
	public ArrayList<OracleParameter> INS_PW_SAL_POL_DTLS_MICR(
			Object P_MICR_CODE, Object P_PROC_DT, Object P_PAY_MODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_MICR_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_PROC_DT);
			parameterList.add(param2);
			/*ADDED BY SANKARA NARAYANAN FOR DIRECT DEBIT ADDING ONE MORE PARAMETER ON 13/04/2017*/
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PAY_MODE);
			parameterList.add(param3); //END

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_SALARY_CHKOFF.INS_PW_SAL_POL_DTLS_MICR");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
		
	public ArrayList<OracleParameter> PR_SCO_PROCESS(
			Object P_ERROR_YN,
			Object P_PROC_DT,
			Object P_EMPLOYER_CODE, 
			Object P_PS_REF_NO,
			Object P_PAY_MODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("OUT1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, P_ERROR_YN);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PROC_DT);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_EMPLOYER_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PS_REF_NO);
			parameterList.add(param4);
/*ADDED BY SANKARA NARAYANAN FOR DIRECT DEBIT ADDING ONE MORE PARAMETER ON 13/04/2017*/
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PAY_MODE);
			parameterList.add(param5);
			//ENDsas
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_SALARY_CHKOFF.PR_SCO_PROCESS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	
	
	public void executeQuery() throws Exception{
		
		Connection con = null;
		ResultSet resultSet = null;
		PW_SAL_POL_DTLS pw_sal_pol_dtls_bean = null;
		datalist_PW_SAL_POL_DTLS.clear();
		String query = "SELECT ROWID,PW_SAL_POL_DTLS.* FROM PW_SAL_POL_DTLS";
		try {
			con = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, con);
			while(resultSet.next()){
				pw_sal_pol_dtls_bean = new PW_SAL_POL_DTLS();
				pw_sal_pol_dtls_bean.setROWID(resultSet.getString("ROWID"));
				pw_sal_pol_dtls_bean.setPSP_POL_NO(resultSet.getString("PSP_POL_NO"));
				pw_sal_pol_dtls_bean.setPSP_CID_NO(resultSet.getString("PSP_CID_NO"));
				pw_sal_pol_dtls_bean.setPSP_CHK_FLAG(resultSet.getString("PSP_CHK_FLAG"));
				pw_sal_pol_dtls_bean.setPSP_PC_FC_PREM(resultSet.getDouble("PSP_PC_FC_PREM"));
				pw_sal_pol_dtls_bean.setPSP_SCHD_PYMT_DT(resultSet.getDate("PSP_SCHD_PYMT_DT"));
				pw_sal_pol_dtls_bean.setPSP_PC_SYS_ID(resultSet.getLong("PSP_PC_SYS_ID"));
				pw_sal_pol_dtls_bean.setPSP_POL_SYS_ID(resultSet.getLong("PSP_POL_SYS_ID"));
				pw_sal_pol_dtls_bean.setPSP_PC_LC_PREM(resultSet.getDouble("PSP_PC_FC_PREM"));
				/* Newly Added By Dhinesh on 27-9-2017 */
				pw_sal_pol_dtls_bean.setPSP_POL_DUE_NO(resultSet.getInt("PSP_POL_DUE_NO"));
				/* End */
				
				postQuery(pw_sal_pol_dtls_bean);
				datalist_PW_SAL_POL_DTLS.add(pw_sal_pol_dtls_bean);
			}
			if(datalist_PW_SAL_POL_DTLS.size() > 0){
				/*cOMMENTED BY SANKARA NARAYANAN ON 13/04/2017 */
				//this.setPW_SAL_POL_DTLS_BEAN(datalist_PW_SAL_POL_DTLS.get(0));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	
	public void postQuery(PW_SAL_POL_DTLS dtlsbean) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		String query = "SELECT   NVL(PC_FC_GROSS_PREM,0)+ NVL(PC_FC_CHARGE,0) FROM  PT_IL_PREM_COLL" +
				"  WHERE PC_POL_SYS_ID = ? " +
				"   AND  PC_SYS_ID  =   ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[]{dtlsbean.getPSP_POL_SYS_ID(),dtlsbean.getPSP_PC_SYS_ID()});
			if(resultSet.next()){
				dtlsbean.setUI_M_DUE_PREM(resultSet.getDouble(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	public void onLoad(PhaseEvent event){
		try{
			if(isBlockFlag()){
				String value = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
				if("AD".equals(value)){
					COMP_CAPTION.setValue("Auto Debit");
					COMP_UI_PS_EMPLOYER_CODE_LABEL.setRendered(false);
					COMP_UI_PS_EMPLOYER_CODE.setRendered(false);
					COMP_UI_MICR_CODE.setRendered(true);
					COMP_UI_MICR_CODE_LABEL.setRendered(true);
					COMP_EMP_IMG.setRendered(false);
				}else{
					PW_SAL_POL_DTLS_BEAN.setUI_PAY_MODE("AD");
					PW_SAL_POL_DTLS_BEAN.setUI_PS_PROC_DT(new CommonUtils().getCurrentDate());
					/*Updated by ganesh on 01-06-2017*/
					COMP_CAPTION.setValue("Premium Due Download Process");
					COMP_UI_MICR_CODE.setRendered(false);
					COMP_UI_MICR_CODE_LABEL.setRendered(false);
					COMP_UI_PS_EMPLOYER_CODE_LABEL.setRendered(true);
					COMP_UI_PS_EMPLOYER_CODE.setRendered(true);
					COMP_EMP_IMG.setRendered(true);
				}
				setBlockFlag(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	
	public void validateUI_MICR_CODE(FacesContext context,UIComponent component,Object value){
		try{
			PW_SAL_POL_DTLS_BEAN.setUI_MICR_CODE((String)value);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	
	public void validateEmpCode(FacesContext context ,UIComponent component ,Object value){
		PW_SAL_POL_DTLS_BEAN.setUI_PS_EMPLOYER_CODE((String)value);
	}

	public void validateUI_PS_PROC_DT(FacesContext context ,UIComponent component ,Object value){
		PW_SAL_POL_DTLS_BEAN.setUI_PS_PROC_DT((Date)value);
	}
	
	
	
	public HtmlOutputLabel getCOMP_UI_PS_PROC_DT_LABEL() {
		return COMP_UI_PS_PROC_DT_LABEL;
	}

	public void setCOMP_UI_PS_PROC_DT_LABEL(HtmlOutputLabel comp_ui_ps_proc_dt_label) {
		COMP_UI_PS_PROC_DT_LABEL = comp_ui_ps_proc_dt_label;
	}

	public HtmlCalendar getCOMP_UI_PS_PROC_DT() {
		return COMP_UI_PS_PROC_DT;
	}

	public void setCOMP_UI_PS_PROC_DT(HtmlCalendar comp_ui_ps_proc_dt) {
		COMP_UI_PS_PROC_DT = comp_ui_ps_proc_dt;
	}

	public ArrayList<SelectItem> getListPSP_CHK_FLAG() {
		return listPSP_CHK_FLAG;
	}

	public void setListPSP_CHK_FLAG(ArrayList<SelectItem> listPSP_CHK_FLAG) {
		this.listPSP_CHK_FLAG = listPSP_CHK_FLAG;
	}

	public HtmlOutputLabel getCOMP_CAPTION() {
		return COMP_CAPTION;
	}

	public void setCOMP_CAPTION(HtmlOutputLabel comp_caption) {
		COMP_CAPTION = comp_caption;
	}

	public HtmlGraphicImage getCOMP_EMP_IMG() {
		return COMP_EMP_IMG;
	}

	public void setCOMP_EMP_IMG(HtmlGraphicImage comp_emp_img) {
		COMP_EMP_IMG = comp_emp_img;
	}


	public HtmlOutputLabel getCOMP_UI_MICR_CODE_LABEL() {
		return COMP_UI_MICR_CODE_LABEL;
	}

	public void setCOMP_UI_MICR_CODE_LABEL(HtmlOutputLabel comp_ui_micr_code_label) {
		COMP_UI_MICR_CODE_LABEL = comp_ui_micr_code_label;
	}

	public HtmlInputText getCOMP_UI_MICR_CODE() {
		return COMP_UI_MICR_CODE;
	}

	public void setCOMP_UI_MICR_CODE(HtmlInputText comp_ui_micr_code) {
		COMP_UI_MICR_CODE = comp_ui_micr_code;
	}
	
	
	/*commented by R Raja on 22-02-2017 for Upload Issue*/
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/*end*/
	/*Added by sankara narayanan on 05/04/2017*/
	public String getFiletype(String MAP_CODE){
		String ftype=null;
	String C1 = " SELECT DUM_UPLOAD_TYPE FROM   PM_IL_DATA_UPLOAD_MAPPING WHERE  DUM_MAP_CODE = ?";
	Connection con = null;
	ResultSet resultSet = null;
	try {
		con = CommonUtils.getConnection();
		resultSet = new CRUDHandler().executeSelectStatement(C1, con,new Object[]{MAP_CODE});
		if(resultSet.next()){
			ftype=resultSet.getString("DUM_UPLOAD_TYPE");
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
	return ftype;
	
	}
	
	public void download(){
		HttpServletResponse response = null;
		String parameter1=null;
		String parameter2=null;
		String div_code=null;
		List<OracleParameter> outputList=new ArrayList<OracleParameter>();
		String output=null;
		try {
			
			if(saveflag){
				//ADD CODE HERE

				Map<String, Object> session = FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap();
				String menuId = (String) session.get("GLOBAL.M_MENU_ID");

				System.out.println("MENU IS ====> "+menuId);

				String Query="SELECT MENU_PARAMETER_1,MENU_PARAMETER_2 FROM MENU_MENUS WHERE MENU_ID = ?";
				ResultSet resultset=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{menuId});
				while(resultset.next())
				{
					parameter1=resultset.getString("MENU_PARAMETER_1");
					parameter2=resultset.getString("MENU_PARAMETER_2");
				}

				div_code=session.get("GLOBAL.M_DIVN_CODE").toString();

				outputList=P_GEN_DOC_NO(parameter1,parameter2,div_code,null,null,null,null,null,null,null,null,null,null,
						
						/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
						CommonUtils.nvl(PW_SAL_POL_DTLS_BEAN.getPSP_POL_NO(), null)
						/*End*/
						
						);	
				Iterator<OracleParameter> iterator = outputList.iterator();
				while (iterator.hasNext()) {
					OracleParameter oracleParameter = iterator.next();
					output=oracleParameter.getValue();
				}
				/*
				 * COMMENTED BY DHINESH ON 06-10-2017
				 * P_INS_UPLOAD_DATA(String.valueOf(getPW_SAL_POL_DTLS_BEAN().getUI_PS_EMPLOYER_CODE()),getPW_SAL_POL_DTLS_BEAN().getUI_PS_PROC_DT(),PW_SAL_POL_DTLS_BEAN.getUI_MAP_CODE(),"AD",output);*/
				
				/* Modified By Dhinesh on 06-10-2017 */
				 P_INS_UPLOAD_DATA(String.valueOf(getPW_SAL_POL_DTLS_BEAN().getUI_PS_EMPLOYER_CODE()),getPW_SAL_POL_DTLS_BEAN().getUI_PS_PROC_DT(),PW_SAL_POL_DTLS_BEAN.getUI_MAP_CODE(),PW_SAL_POL_DTLS_BEAN.getUI_PAY_MODE(),output);
				 /* End */
				
				String url=resourceBundleDatabase.getString("File_Fownloader");
				response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				String MEMBER_ID=PW_SAL_POL_DTLS_BEAN.getUI_MAP_CODE();				
				if("C".equalsIgnoreCase(getFiletype(PW_SAL_POL_DTLS_BEAN.getUI_MAP_CODE()))){
					/*Modified by ganesh on 30-05-2017, debit order issues reported by Mr.Girish */
					//response.sendRedirect(url+"FILE_NAME=DebitOrder&MAP_ID="+MEMBER_ID+"&FILE_TYPE=CSV");	
					response.sendRedirect(url+"FILE_NAME="+getDynamicFileName()+"&MAP_ID="+MEMBER_ID+"&FILE_TYPE=CSV");
					/*end*/
				}	/* Newly Added by Dhinesh on 29-06-2018 for FLA - RM018T - FSD_IL_FLA_004-Common Data Upload-R1_final */
				else if("T".equalsIgnoreCase(getFiletype(PW_SAL_POL_DTLS_BEAN.getUI_MAP_CODE()))){
					response.sendRedirect(url+"FILE_NAME="+getDynamicFileName()+"&MAP_ID="+MEMBER_ID+"&FILE_TYPE=TXT");
					/* End */
				}else{
					/*Modified by ganesh on 30-05-2017, debit order issues reported by Mr.Girish */
					//response.sendRedirect(url+"FILE_NAME=DebitOrder&MAP_ID="+MEMBER_ID+"&FILE_TYPE=E");	
					response.sendRedirect(url+"FILE_NAME="+getDynamicFileName()+"&MAP_ID="+MEMBER_ID+"&FILE_TYPE=E");
					/*end*/
				}
				saveflag=false;
			}else{
				throw new Exception("Save the Record Before Download.");
			}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		
	}
	public ArrayList<com.iii.premia.common.bean.LovBean> lovM_MAP_CODE(
			Object currValue) {

		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//P_CALL_LOV('DUMMY.M_MAP_CODE');
			/*	change parameter by raja on 06-03-2017 for ZBILQC-1719694 */
			String value = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
			if("AD".equals(value)){
			suggestionList = listitemutil.P_CALL_LOV("PILP017",
					"DUMMY", "M_MAP_CODE", PW_SAL_POL_DTLS_BEAN.getUI_MICR_CODE(), null, null,
					null, null, (String) currValue);
			}else{
				/*Modified by ganesh on 01-06-2017, suggested by Gaurav */
				/*suggestionList = listitemutil.P_CALL_LOV("PILP017",
						"DUMMY", "M_MAP_CODE", PW_SAL_POL_DTLS_BEAN.getUI_PS_EMPLOYER_CODE(), null, null,
						null, null, (String) currValue);*/	
				String query ="SELECT DUM_MAP_CODE, DUM_MAP_CODE_DESC, DUM_MAP_CODE_DESC FROM PM_IL_DATA_UPLOAD_MAPPING WHERE DUM_EMPLOYER_CODE = ? AND (UPPER(DUM_MAP_CODE) LIKE UPPER(?) OR UPPER(DUM_MAP_CODE_DESC) LIKE UPPER(?) OR UPPER(DUM_MAP_CODE_DESC) LIKE UPPER(?)) AND UPPER(DUM_MAP_CODE_DESC) LIKE ('%DOWNLOAD%') AND ROWNUM < ? ORDER BY 1";
				Object[] values = null;
				String currentValue = (String) currValue;
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
				values = new Object[] { PW_SAL_POL_DTLS_BEAN.getUI_PS_EMPLOYER_CODE(), currentValue, currentValue,currentValue,
						PELConstants.suggetionRecordSize };
				/*end*/
				suggestionList = ListItemUtil.prepareSuggestionList(query, values);
				
				/*end*/
			}
			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	
	public void setListItemValues() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

		
			
			setListUI_M_PAY_MODE(ListItemUtil.getDropDownListValue(
					connection, "PILP017", "DUMMY",
					"DUMMY.M_PAY_MODE", "IL_PAY_MODE"));
			
			setListMonth(ListItemUtil.getDropDownListValue(
					connection, "PILP017", "DUMMY",
					"DUMMY.M_DUE_MONTH", "MONTHS"));

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	
	private List<SelectItem> listUI_M_PAY_MODE = new ArrayList<SelectItem>();
	
	
	public void validateM_PAY_MODE(FacesContext context ,UIComponent component ,Object value){
		PW_SAL_POL_DTLS_BEAN.setUI_PAY_MODE((String)value);
		
		/*Commented by Janani on 07.02.2018 as suggested by Girish for ZB*/
		
		/*if(!"AD".equals((String)value)){
			COMP_UI_m_post.setRendered(false);
			COMP_PSP_POL_DUE_NO.setRendered(false);
			COMP_PSP_POL_DUE_NO_LABEL.setRendered(false);
		}*/
		
		/*End*/
		
		//COMP_UI_PAY_MODE.resetValue();
	}

	
	public void validateM_MAP_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PW_SAL_POL_DTLS_BEAN.setUI_MAP_CODE((String) value);
			
			
			/*if("DEBIT_ORDER_DW".equalsIgnoreCase(PW_SAL_POL_DTLS_BEAN.getUI_MAP_CODE())){
				PW_SAL_POL_DTLS_BEAN.setUI_PAY_MODE("AD");
			}else if("SAL_DED_DW".equalsIgnoreCase(PW_SAL_POL_DTLS_BEAN.getUI_MAP_CODE())){
				PW_SAL_POL_DTLS_BEAN.setUI_PAY_MODE("S");
			}*/
			
			/*Newly Added By Dhinesh on 1/11/2017 for Premium due Download/Upload issue suggested by Gaurav*/
			P_VAL_M_PAY_MODE(PW_SAL_POL_DTLS_BEAN.getUI_MAP_CODE(),PW_SAL_POL_DTLS_BEAN);
			/*End*/
			
			COMP_UI_PAY_MODE.resetValue();
			
		
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {}
	}
	
	
	
	
	
	public List<SelectItem> getListUI_M_PAY_MODE() {
		return listUI_M_PAY_MODE;
	}

	public void setListUI_M_PAY_MODE(List<SelectItem> listUI_M_PAY_MODE) {
		this.listUI_M_PAY_MODE = listUI_M_PAY_MODE;
	}
	
	private HtmlOutputLabel COMP_UI_PAY_MODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_MAP_CODE_LABEL;
	private HtmlInputText COMP_UI_MAP_CODE;
	private HtmlInputText COMP_UI_MAP_CODE_DESC; 
	private HtmlSelectOneMenu COMP_UI_PAY_MODE;
	private HtmlOutputLabel COMP_UI_M_MAP_BANK__CODE_LABEL;
	private HtmlInputText COMP_UI_MAP_BANK_CODE;
	private HtmlInputText COMP_UI_MAP_BANK_CODE_DESC; 
boolean saveflag=false;
	
	
	
	public HtmlOutputLabel getCOMP_UI_M_MAP_BANK__CODE_LABEL() {
		return COMP_UI_M_MAP_BANK__CODE_LABEL;
	}

	public void setCOMP_UI_M_MAP_BANK__CODE_LABEL(
			HtmlOutputLabel cOMP_UI_M_MAP_BANK__CODE_LABEL) {
		COMP_UI_M_MAP_BANK__CODE_LABEL = cOMP_UI_M_MAP_BANK__CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_MAP_BANK_CODE() {
		return COMP_UI_MAP_BANK_CODE;
	}

	public void setCOMP_UI_MAP_BANK_CODE(HtmlInputText cOMP_UI_MAP_BANK_CODE) {
		COMP_UI_MAP_BANK_CODE = cOMP_UI_MAP_BANK_CODE;
	}

	public HtmlInputText getCOMP_UI_MAP_BANK_CODE_DESC() {
		return COMP_UI_MAP_BANK_CODE_DESC;
	}

	public void setCOMP_UI_MAP_BANK_CODE_DESC(
			HtmlInputText cOMP_UI_MAP_BANK_CODE_DESC) {
		COMP_UI_MAP_BANK_CODE_DESC = cOMP_UI_MAP_BANK_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_PAY_MODE_LABEL() {
		return COMP_UI_PAY_MODE_LABEL;
	}

	public void setCOMP_UI_PAY_MODE_LABEL(HtmlOutputLabel cOMP_UI_PAY_MODE_LABEL) {
		COMP_UI_PAY_MODE_LABEL = cOMP_UI_PAY_MODE_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAP_CODE_LABEL() {
		return COMP_UI_M_MAP_CODE_LABEL;
	}

	public void setCOMP_UI_M_MAP_CODE_LABEL(HtmlOutputLabel cOMP_UI_M_MAP_CODE_LABEL) {
		COMP_UI_M_MAP_CODE_LABEL = cOMP_UI_M_MAP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_MAP_CODE() {
		return COMP_UI_MAP_CODE;
	}

	public void setCOMP_UI_MAP_CODE(HtmlInputText cOMP_UI_MAP_CODE) {
		COMP_UI_MAP_CODE = cOMP_UI_MAP_CODE;
	}

	public HtmlInputText getCOMP_UI_MAP_CODE_DESC() {
		return COMP_UI_MAP_CODE_DESC;
	}

	public void setCOMP_UI_MAP_CODE_DESC(HtmlInputText cOMP_UI_MAP_CODE_DESC) {
		COMP_UI_MAP_CODE_DESC = cOMP_UI_MAP_CODE_DESC;
	}

	public HtmlSelectOneMenu getCOMP_UI_PAY_MODE() {
		return COMP_UI_PAY_MODE;
	}

	public void setCOMP_UI_PAY_MODE(HtmlSelectOneMenu cOMP_UI_PAY_MODE) {
		COMP_UI_PAY_MODE = cOMP_UI_PAY_MODE;
	}

	public static ResourceBundle getResourcebundledatabase() {
		return resourceBundleDatabase;
	}
	
	public void initializeallcomponent(){
		
		COMP_UI_M_MAP_BANK__CODE_LABEL= new HtmlOutputLabel();
		COMP_UI_MAP_BANK_CODE= new HtmlInputText();
		 COMP_UI_MAP_BANK_CODE_DESC= new HtmlInputText();
		COMP_UI_PAY_MODE_LABEL= new HtmlOutputLabel();
		COMP_UI_M_MAP_CODE_LABEL= new HtmlOutputLabel();
		COMP_UI_MAP_CODE= new HtmlInputText();
		COMP_UI_MAP_CODE_DESC= new HtmlInputText();
		COMP_UI_PAY_MODE= new HtmlSelectOneMenu();
		COMP_CAPTION= new HtmlOutputLabel();
		COMP_EMP_IMG=new HtmlGraphicImage();
		COMP_UI_MICR_CODE_LABEL= new HtmlOutputLabel();
		COMP_UI_MICR_CODE= new HtmlInputText();
		COMP_UI_PS_PROC_YEAR_LABEL= new HtmlOutputLabel();
		COMP_UI_PS_PROC_YEAR= new HtmlInputText();
		COMP_UI_PS_EMPLOYER_CODE_LABEL= new HtmlOutputLabel();
		COMP_UI_PS_EMPLOYER_CODE= new HtmlInputText();
		COMP_UI_PS_REF_NO_LABEL= new HtmlOutputLabel();
		COMP_UI_PS_REF_NO= new HtmlInputText();
		COMP_UI_PS_PROC_MON_LABEL= new HtmlOutputLabel();
		COMP_UI_PS_PROC_MON= new HtmlSelectOneMenu();
		COMP_UI_PS_PROC_DT_LABEL= new HtmlOutputLabel();
		COMP_UI_PS_PROC_DT=new HtmlCalendar();
		
		/* Newly Added By Dhinesh on 27-9-2017 */
		COMP_PSP_POL_DUE_NO = new HtmlInputText();
		/* End */
	}
	
	
	public ArrayList<OracleParameter> P_INS_UPLOAD_DATA(
			Object P_MICR_CODE, Object P_PROC_DT,Object P_MAP_CODE,Object FLAG,String DOC_NO) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_MICR_CODE);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_PROC_DT);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_MAP_CODE);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, FLAG);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, DOC_NO);
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_SALARY_CHKOFF.P_INS_UPLOAD_DATA");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	
	
	
	/*end*/
	public ArrayList<OracleParameter> P_GEN_DOC_NO(String P_DOC_TYPE,
			String P_DOC_CODE, String P_DIVN_CODE, String P_CLASS_CODE,
			String P_PLAN_CODE, String P_PROD_CODE, String P_UW_YEAR,
			String P_DOC_NO_FN, String P_BLOCK_NAME, String P_DUMMY_YN,
			String P_DATE, String P_CLAIM_TYPE, String P_REG_DATE,
			
			  /*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
		       String P_POL_NO
		       /*End*/
			)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_DOC_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_DOC_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_DIVN_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_CLASS_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					P_PLAN_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					P_PROD_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
					P_UW_YEAR);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN OUT8", "STRING",
					"IN OUT", P_DOC_NO_FN);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",
					P_BLOCK_NAME);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING",
					"IN", P_DUMMY_YN);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING",
					"IN", P_DATE);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING",
					"IN", P_CLAIM_TYPE);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING",
					"IN", P_REG_DATE);
			parameterList.add(param13);
			
			/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/

			OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_POL_NO);
			parameterList.add(param14);

			/*End*/

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"LIFELIB.P_GEN_DOC_NO");
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	public void fireFieldValidationChk(ActionEvent event)
	{

		try {
			UIInput input = (UIInput) event.getComponent().getParent();
			boolean chkFlag = false;
			chkFlag = (boolean)input.getSubmittedValue();
			String defChk = "N";
			if(chkFlag)
			{
				defChk = "Y";
			}
			/*System.out.println("defChk        "+defChk+"       "+PW_SAL_POL_DTLS_BEAN.getCOMP_DT_SCROLLER().getPage()+"      "+PW_SAL_POL_DTLS_BEAN.getDataTable().getRows());
		 CommonUtils.setPageIndexing(PW_SAL_POL_DTLS_BEAN,PW_SAL_POL_DTLS_BEAN.getCOMP_DT_SCROLLER(),PW_SAL_POL_DTLS_BEAN.getDataTable());*/
		/* System.out.println("page Start from "+PW_SAL_POL_DTLS_BEAN.getStartIndex()+"    Ended to    "+PW_SAL_POL_DTLS_BEAN.getEndindex());
		 setDatalist_PW_SAL_POL_DTLS(CommonUtils.returnCheckedList(getDatalist_PW_SAL_POL_DTLS(), "PSP_CHK_FLAG", defChk,
	    		 PW_SAL_POL_DTLS_BEAN.getStartIndex(),PW_SAL_POL_DTLS_BEAN.getEndindex()));
		 PW_SAL_POL_DTLS_BEAN.setPSP_CHK_FLAG(defChk);*/
			
			if(datalist_PW_SAL_POL_DTLS.size()>0)
			{
				for(PW_SAL_POL_DTLS bean: getDatalist_PW_SAL_POL_DTLS())
				{
					//getDatalist_PW_SAL_POL_DTLS().remove(bean);
					bean.setPSP_CHK_FLAG(defChk);
					new CRUDHandler().executeUpdate(bean, CommonUtils.getConnection());
					//getDatalist_PW_SAL_POL_DTLS().add(bean);
				}
			}
			
	/*	 CommonUtils.updateAllRecords(datalist_PW_SAL_POL_DTLS, PW_SAL_POL_DTLS_BEAN.getStartIndex(), PW_SAL_POL_DTLS_BEAN.getEndindex());*/
	
			/*if(datalist_PW_SAL_POL_DTLS.size()>0)
			{
				for(PW_SAL_POL_DTLS bean: getDatalist_PW_SAL_POL_DTLS())
				{
					bean.setPSP_CHK_FLAG(defChk);
				}
			}*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*Added by ganesh on 30-05-2017, debit order issues reported by Mr.Girish */
	public String getDynamicFileName(){
		StringBuilder buildFileName = new StringBuilder();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		String value = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		
		try{
			if(value!=null && value.equals("AD")){
				
				buildFileName.append(PW_SAL_POL_DTLS_BEAN.getUI_MICR_CODE());				
			}else{				
				buildFileName.append(PW_SAL_POL_DTLS_BEAN.getUI_PS_EMPLOYER_CODE());
			}
			buildFileName.append("_");
			buildFileName.append(getShortProcessType());
			buildFileName.append("_");
			buildFileName.append(dateFormat.format(new Date()));
		}catch(Exception e){
			e.printStackTrace();
			
		}
		System.out.println("getDynamicFileName()-->"+buildFileName.toString());
		return buildFileName.toString();
		
	}

	public String getShortProcessType(){
		String paymentMode="";
		StringBuilder shortFieldName = new StringBuilder();
		try {
			paymentMode = ListItemUtil.getListItemDescription(CommonUtils.getConnection(), "PILP017", "DUMMY",
					"DUMMY.M_PAY_MODE", "IL_PAY_MODE",PW_SAL_POL_DTLS_BEAN.getUI_PAY_MODE());			
			System.out.println("my payment mode-->"+paymentMode);
			for(int i=0; i<paymentMode.split(" ").length; i++){
				shortFieldName.append(paymentMode.split(" ")[i].substring(0, 1));				
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shortFieldName.toString();
		
	}
	/*end*/


	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PW_SAL_POL_DTLS_BEAN = (PW_SAL_POL_DTLS) dataTable
					.getRowData();
			System.out.println("Row ID : "+ PW_SAL_POL_DTLS_BEAN.getROWID());
			
			
			PW_SAL_POL_DTLS_BEAN.setRowSelected(true);	
			/*getCOMP_PSP_POL_DUE_NO().setValue(PW_SAL_POL_DTLS_BEAN.getPSP_POL_DUE_NO());*/
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	
	private void resetSelectedRow() {
		Iterator<PW_SAL_POL_DTLS> PW_SAL_POL_DTLS_ITR = datalist_PW_SAL_POL_DTLS
				.iterator();
		while (PW_SAL_POL_DTLS_ITR.hasNext()) {
			PW_SAL_POL_DTLS_ITR.next().setRowSelected(false);
		}
	}
	
	
	public void validatePSP_POL_DUE_NO(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			double M_UI_PSP_POL_DUE_NO = 0.0;
			
			
			PW_SAL_POL_DTLS_BEAN.setPSP_POL_DUE_NO(Integer.parseInt((String)((UIInput)(event.getComponent().getParent())).getSubmittedValue()));
			
			/*Modified by saritha on 17-10-2017 for Premium Due Download Process*/
			/*M_UI_PSP_POL_DUE_NO = PW_SAL_POL_DTLS_BEAN.getPSP_PC_FC_PREM() * PW_SAL_POL_DTLS_BEAN.getPSP_POL_DUE_NO() ;
			PW_SAL_POL_DTLS_BEAN.setPSP_PC_LC_PREM(M_UI_PSP_POL_DUE_NO);
			PW_SAL_POL_DTLS_BEAN.setPSP_PC_FC_PREM(M_UI_PSP_POL_DUE_NO);*/
			
			M_UI_PSP_POL_DUE_NO = PW_SAL_POL_DTLS_BEAN.getUI_M_DUE_PREM() * PW_SAL_POL_DTLS_BEAN.getPSP_POL_DUE_NO();
			PW_SAL_POL_DTLS_BEAN.setPSP_PC_LC_PREM(M_UI_PSP_POL_DUE_NO);
			PW_SAL_POL_DTLS_BEAN.setPSP_PC_FC_PREM(M_UI_PSP_POL_DUE_NO);
			/*End*/
			
			/*getCOMP_PSP_POL_DUE_NO().setValid(true);*/
		
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {}
	}

	

	public String postRecord() {
		String message = null;
		try {
			
			if(PW_SAL_POL_DTLS_BEAN.getROWID() != null)
			{
			new CRUDHandler().executeUpdate(PW_SAL_POL_DTLS_BEAN, CommonUtils.getConnection());
			message = Messages.getString(
					PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$update");
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("postRecord", message);
			PW_SAL_POL_DTLS_BEAN.setRowSelected(true);
			
		}catch (Exception exc) 
		{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("postRecord", exc.getMessage());
		}
		
		return "";
		}


	public void resetAllComponent() {
		COMP_PSP_POL_DUE_NO.resetValue();
	}

	public void P_VAL_M_PAY_MODE(String P_MAP_CODE,PW_SAL_POL_DTLS PW_SAL_POL_DTLS_BEAN) throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;

		String C1 = "SELECT DISTINCT DUM_PAYMENT_MODE FROM PM_IL_DATA_UPLOAD_MAPPING WHERE DUM_MAP_CODE = ? AND DUM_EMPLOYER_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] {P_MAP_CODE ,PW_SAL_POL_DTLS_BEAN.getUI_PS_EMPLOYER_CODE()});
			
			if (resultSet.next()) {
				PW_SAL_POL_DTLS_BEAN.setUI_PAY_MODE(resultSet.getString("DUM_PAYMENT_MODE"));
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
}
