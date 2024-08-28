package com.iii.pel.forms.PILT036_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP016.PRINT_ACTION;
import com.iii.pel.forms.PILP016.PRINT_HELPER;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PT_IL_POL_RED_SA_ACTION extends CommonReportAction {

	private HtmlOutputLabel COMP_PRS_COVER_CODE_LABEL;

	private HtmlInputText COMP_PRS_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_PRS_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PRS_COVER_CODE_DESC;

	private HtmlOutputLabel COMP_PRS_MONTH_LABEL;

	private HtmlInputText COMP_PRS_MONTH;

	private HtmlOutputLabel COMP_PRS_FC_SA_LABEL;

	private HtmlInputText COMP_PRS_FC_SA;

	private HtmlOutputLabel COMP_PRS_LC_SA_LABEL;

	private HtmlInputText COMP_PRS_LC_SA;

	private HtmlOutputLabel COMP_PRS_INCOR_FC_SA_LABEL;

	private HtmlInputText COMP_PRS_INCOR_FC_SA;

	private HtmlOutputLabel COMP_PRS_INCOR_LC_SA_LABEL;

	private HtmlInputText COMP_PRS_INCOR_LC_SA;

	private HtmlCommandButton COMP_UI_M_BUT_COVER;

	private PT_IL_POL_RED_SA PT_IL_POL_RED_SA_BEAN;
	
	private HtmlCommandButton COMP_UI_M_DSA_REPORT;
	
	public Long POL_SYS_ID;
	
	public StringBuffer url;
	
	
	public HtmlCommandButton getCOMP_UI_M_DSA_REPORT() {
		return COMP_UI_M_DSA_REPORT;
	}

	public void setCOMP_UI_M_DSA_REPORT(HtmlCommandButton cOMP_UI_M_DSA_REPORT) {
		COMP_UI_M_DSA_REPORT = cOMP_UI_M_DSA_REPORT;
	}

	private PT_IL_POL_RED_SA_HELPER helper;

	private List<PT_IL_POL_RED_SA> dataList_PT_IL_POL_RED_SA; 

	private UIData dataTable;

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public PT_IL_POL_RED_SA_ACTION() throws Exception {
		dataList_PT_IL_POL_RED_SA = new ArrayList<PT_IL_POL_RED_SA>();
		PT_IL_POL_RED_SA_BEAN = new PT_IL_POL_RED_SA();
		helper = new PT_IL_POL_RED_SA_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_PRS_COVER_CODE_LABEL() {
		return COMP_PRS_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PRS_COVER_CODE() {
		return COMP_PRS_COVER_CODE;
	}

	public void setCOMP_PRS_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_PRS_COVER_CODE_LABEL) {
		this.COMP_PRS_COVER_CODE_LABEL = COMP_PRS_COVER_CODE_LABEL;
	}

	public void setCOMP_PRS_COVER_CODE(HtmlInputText COMP_PRS_COVER_CODE) {
		this.COMP_PRS_COVER_CODE = COMP_PRS_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PRS_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_PRS_COVER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PRS_COVER_CODE_DESC() {
		return COMP_UI_M_PRS_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_PRS_COVER_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PRS_COVER_CODE_DESC_LABEL) {
		this.COMP_UI_M_PRS_COVER_CODE_DESC_LABEL = COMP_UI_M_PRS_COVER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PRS_COVER_CODE_DESC(
			HtmlInputText COMP_UI_M_PRS_COVER_CODE_DESC) {
		this.COMP_UI_M_PRS_COVER_CODE_DESC = COMP_UI_M_PRS_COVER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PRS_MONTH_LABEL() {
		return COMP_PRS_MONTH_LABEL;
	}

	public HtmlInputText getCOMP_PRS_MONTH() {
		return COMP_PRS_MONTH;
	}

	public void setCOMP_PRS_MONTH_LABEL(HtmlOutputLabel COMP_PRS_MONTH_LABEL) {
		this.COMP_PRS_MONTH_LABEL = COMP_PRS_MONTH_LABEL;
	}

	public void setCOMP_PRS_MONTH(HtmlInputText COMP_PRS_MONTH) {
		this.COMP_PRS_MONTH = COMP_PRS_MONTH;
	}

	public HtmlOutputLabel getCOMP_PRS_FC_SA_LABEL() {
		return COMP_PRS_FC_SA_LABEL;
	}

	public HtmlInputText getCOMP_PRS_FC_SA() {
		return COMP_PRS_FC_SA;
	}

	public void setCOMP_PRS_FC_SA_LABEL(HtmlOutputLabel COMP_PRS_FC_SA_LABEL) {
		this.COMP_PRS_FC_SA_LABEL = COMP_PRS_FC_SA_LABEL;
	}

	public void setCOMP_PRS_FC_SA(HtmlInputText COMP_PRS_FC_SA) {
		this.COMP_PRS_FC_SA = COMP_PRS_FC_SA;
	}

	public HtmlOutputLabel getCOMP_PRS_LC_SA_LABEL() {
		return COMP_PRS_LC_SA_LABEL;
	}

	public HtmlInputText getCOMP_PRS_LC_SA() {
		return COMP_PRS_LC_SA;
	}

	public void setCOMP_PRS_LC_SA_LABEL(HtmlOutputLabel COMP_PRS_LC_SA_LABEL) {
		this.COMP_PRS_LC_SA_LABEL = COMP_PRS_LC_SA_LABEL;
	}

	public void setCOMP_PRS_LC_SA(HtmlInputText COMP_PRS_LC_SA) {
		this.COMP_PRS_LC_SA = COMP_PRS_LC_SA;
	}

	public HtmlOutputLabel getCOMP_PRS_INCOR_FC_SA_LABEL() {
		return COMP_PRS_INCOR_FC_SA_LABEL;
	}

	public HtmlInputText getCOMP_PRS_INCOR_FC_SA() {
		return COMP_PRS_INCOR_FC_SA;
	}

	public void setCOMP_PRS_INCOR_FC_SA_LABEL(
			HtmlOutputLabel COMP_PRS_INCOR_FC_SA_LABEL) {
		this.COMP_PRS_INCOR_FC_SA_LABEL = COMP_PRS_INCOR_FC_SA_LABEL;
	}

	public void setCOMP_PRS_INCOR_FC_SA(HtmlInputText COMP_PRS_INCOR_FC_SA) {
		this.COMP_PRS_INCOR_FC_SA = COMP_PRS_INCOR_FC_SA;
	}

	public HtmlOutputLabel getCOMP_PRS_INCOR_LC_SA_LABEL() {
		return COMP_PRS_INCOR_LC_SA_LABEL;
	}

	public HtmlInputText getCOMP_PRS_INCOR_LC_SA() {
		return COMP_PRS_INCOR_LC_SA;
	}

	public void setCOMP_PRS_INCOR_LC_SA_LABEL(
			HtmlOutputLabel COMP_PRS_INCOR_LC_SA_LABEL) {
		this.COMP_PRS_INCOR_LC_SA_LABEL = COMP_PRS_INCOR_LC_SA_LABEL;
	}

	public void setCOMP_PRS_INCOR_LC_SA(HtmlInputText COMP_PRS_INCOR_LC_SA) {
		this.COMP_PRS_INCOR_LC_SA = COMP_PRS_INCOR_LC_SA;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_COVER() {
		return COMP_UI_M_BUT_COVER;
	}

	public void setCOMP_UI_M_BUT_COVER(HtmlCommandButton COMP_UI_M_BUT_COVER) {
		this.COMP_UI_M_BUT_COVER = COMP_UI_M_BUT_COVER;
	}

	public PT_IL_POL_RED_SA getPT_IL_POL_RED_SA_BEAN() {
		return PT_IL_POL_RED_SA_BEAN;
	}

	public void setPT_IL_POL_RED_SA_BEAN(PT_IL_POL_RED_SA PT_IL_POL_RED_SA_BEAN) {
		this.PT_IL_POL_RED_SA_BEAN = PT_IL_POL_RED_SA_BEAN;
	}

	public List<PT_IL_POL_RED_SA> getDataList_PT_IL_POL_RED_SA() {
		return dataList_PT_IL_POL_RED_SA;
	}

	public void setDataListPT_IL_POL_RED_SA(
			List<PT_IL_POL_RED_SA> dataList_PT_IL_POL_RED_SA) {
		this.dataList_PT_IL_POL_RED_SA = dataList_PT_IL_POL_RED_SA;
	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_POL_RED_SA> PT_IL_POL_RED_SA_ITR = dataList_PT_IL_POL_RED_SA.iterator();
		while (PT_IL_POL_RED_SA_ITR.hasNext()) {
		    PT_IL_POL_RED_SA_ITR.next().setRowSelected(false);
		}
	    }
	

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				PT_IL_POL_RED_SA_BEAN = new PT_IL_POL_RED_SA();
				 resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put("addRow",Messages.getString(PELConstants.pelMessagePropertiesPath,
															   "errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
																PELConstants.pelMessagePropertiesPath,
																"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Saved Successfully");
			getWarningMap().put("Save", "Records Saved Successfully");
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput)actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	

	/**
	 * Instantiates all components in PT_IL_POL_RED_SA_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PRS_COVER_CODE				 = new HtmlInputText();
		COMP_UI_M_PRS_COVER_CODE_DESC			 = new HtmlInputText();
		COMP_PRS_MONTH					 = new HtmlInputText();
		COMP_PRS_FC_SA					 = new HtmlInputText();
		COMP_PRS_LC_SA					 = new HtmlInputText();
		COMP_PRS_INCOR_FC_SA				 = new HtmlInputText();
		COMP_PRS_INCOR_LC_SA				 = new HtmlInputText();
		COMP_UI_M_BUT_COVER				 = new HtmlCommandButton();
	}

	/**
	 * Resets all components in PT_IL_POL_RED_SA_ACTION
	 */
	public void resetAllComponent(){
		COMP_PRS_COVER_CODE.resetValue();
		COMP_UI_M_PRS_COVER_CODE_DESC.resetValue();
		COMP_PRS_MONTH.resetValue();
		COMP_PRS_FC_SA.resetValue();
		COMP_PRS_LC_SA.resetValue();
		COMP_PRS_INCOR_FC_SA.resetValue();
		COMP_PRS_INCOR_LC_SA.resetValue();
	}

	/**
	 * Disables all components in PT_IL_POL_RED_SA_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		COMP_PRS_COVER_CODE.setDisabled(disabled);
		COMP_UI_M_PRS_COVER_CODE_DESC.setDisabled(disabled);
		COMP_PRS_MONTH.setDisabled(disabled);
		COMP_PRS_FC_SA.setDisabled(disabled);
		COMP_PRS_LC_SA.setDisabled(disabled);
		COMP_PRS_INCOR_FC_SA.setDisabled(disabled);
		COMP_PRS_INCOR_LC_SA.setDisabled(disabled);
		COMP_UI_M_BUT_COVER.setDisabled(disabled);
	}

	
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.preQuery(PT_IL_POL_RED_SA_BEAN);
				/*helper.executeQuery(this);*/
				helper.helperexecuteQuery(this);
				helper.postQuery(this);
				setDataPageNo(1);
				setBlockFlag(false);
			}
			System.out.println();
			/*PT_IL_POL_RED_SA_BEAN.setDataPageNo(1);*/
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POL_RED_SA_BEAN = (PT_IL_POL_RED_SA) dataTable.getRowData();
			helper.postQuery(this);
			PT_IL_POL_RED_SA_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
		return "";
	}
	
	public String main() {
		/*Added by saritha on 24-08-2017 for ssp call id ZBILQC-1736021*/
		setBlockFlag(true);
		/*End*/
		return "PILT002_APAC_PT_IL_PREM_DTLS";
	}

	public void setDataList_PT_IL_POL_RED_SA(
			List<PT_IL_POL_RED_SA> dataList_PT_IL_POL_RED_SA) {
		this.dataList_PT_IL_POL_RED_SA = dataList_PT_IL_POL_RED_SA;
	}
	
	public String runAction() {
		String redirectUrl=null;
		CommonUtils.clearMaps(this);
 		setRedirectUrl(null);
 		HttpServletResponse response = null;
 		/*POL_SYS_ID=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
		System.out.println("polsysid in runActionAfterValidate"+POL_SYS_ID);*/
		
		
		try {
			setRedirectUrl(new PRINT_HELPER().WHEN_BUTTON_PRESSED_M_BUT_OK(new PRINT_ACTION()));
			
			/*url=new StringBuffer(getRedirectUrl());
			System.out.println("this is url"+url.toString());
			url.append("PolicyScheduleSubReport="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());	
			
			if (getRedirectUrl() != null) {
				response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
				response.sendRedirect(getRedirectUrl());
			}*/
			
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("RunAction", e.getMessage());
	}
	return redirectUrl;
 }
	
	public String runActionAfterValidate() {
		
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
	
	try {
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		
		String val= session.getAttribute("POL_DS_TYPE").toString();
		String POL_SYS_ID=CommonUtils.getGlobalVariable("GLOBAL.POL_SYS_ID");
		//POL_SYS_ID = pilt002_apac_composite_action_bean.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
		System.out.println("polsysid in runActionAfterValidate"+POL_SYS_ID);
		
		/*Added by Ram on 19/11/2016 for DSA Print Table format design*/
		
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, Integer.parseInt(POL_SYS_ID));
			parameterList.add(param1);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			
			outputList = procHandler.executeProc(parameterList, connection,
					"PROC_RSA_REP_TAB");
			/*System.out.println("outputList.get(0).getValue()   : "+outputList.get(0).getValueObject());*/
			
			
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		
		/*End*/
		
		PRINT_ACTION print = new PRINT_ACTION();
		print.setUI_REPORT_TYPE("DSA Print");
		String SCHEDULE_REPORT_TYPE=print.getUI_REPORT_TYPE();
		
		
			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is url"+url.toString());
			
			/*Added Total_count parameter by Ram on 19/11/2016 for DSA Print Tabular format*/
			url.append("PolicyScheduleSubReport="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID+"&DS_TYPE="+val+"&TOTAL_COUNT="+((dataList_PT_IL_POL_RED_SA.size()/30))+1);
			/*End*/
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());	
			
		if (getRedirectUrl() != null) {
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
			response.sendRedirect(getRedirectUrl());
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("runAction", e.getMessage());
	}
	return null;
	}
	

	private int dataPageNo;

	public int getDataPageNo() {
		return dataPageNo;
	}

	public void setDataPageNo(int dataPageNo) {
		this.dataPageNo = dataPageNo;
	}
    
}