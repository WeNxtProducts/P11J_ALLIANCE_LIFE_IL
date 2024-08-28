package com.iii.pel.forms.PILP206;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP078.PT_IL_ADJ_HEAD;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PW_IL_BALANCE_SUM_ACTION extends CommonAction {
	
	public PILP206_COMPOSITE_ACTION compositeAction;
	
	private PW_IL_BALANCE_SUM_HELPER helper;
	
	public PW_IL_BALANCE_SUM_HELPER getHelper() {
		return helper;
	}
	public void setHelper(PW_IL_BALANCE_SUM_HELPER helper) {
		this.helper = helper;
	}
	public PW_IL_BALANCE_SUM getPW_IL_BALANCE_SUM_BEAN() {
		return PW_IL_BALANCE_SUM_BEAN;
	}
	public void setPW_IL_BALANCE_SUM_BEAN(PW_IL_BALANCE_SUM pW_IL_BALANCE_SUM_BEAN) {
		PW_IL_BALANCE_SUM_BEAN = pW_IL_BALANCE_SUM_BEAN;
	}
	public PW_IL_BALANCE_SUM_DELEGATE getDelegate() {
		return delegate;
	}
	public void setDelegate(PW_IL_BALANCE_SUM_DELEGATE delegate) {
		this.delegate = delegate;
	}
	StringBuffer url=null;

	private PW_IL_BALANCE_SUM PW_IL_BALANCE_SUM_BEAN;
	
	private PW_IL_BALANCE_SUM_DELEGATE delegate;
	
	private UIData dataTable;
	
	private List<PW_IL_BALANCE_SUM> dataList_PW_IL_BALANCE_SUM = new ArrayList<PW_IL_BALANCE_SUM>();
	
	public PW_IL_BALANCE_SUM_ACTION(){
		PW_IL_BALANCE_SUM_BEAN=new PW_IL_BALANCE_SUM();
		delegate=new PW_IL_BALANCE_SUM_DELEGATE();
		helper=new PW_IL_BALANCE_SUM_HELPER();
		
	}
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public List<PW_IL_BALANCE_SUM> getDataList_PW_IL_BALANCE_SUM() {
		return dataList_PW_IL_BALANCE_SUM;
	}
	public void setDataList_PW_IL_BALANCE_SUM(
			List<PW_IL_BALANCE_SUM> dataList_PW_IL_BALANCE_SUM) {
		this.dataList_PW_IL_BALANCE_SUM = dataList_PW_IL_BALANCE_SUM;
	}
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				getErrorMap().clear();
				getWarningMap().clear();
				//helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PW_IL_BALANCE_SUM_BEAN = (PW_IL_BALANCE_SUM) dataTable.getRowData();
			PW_IL_BALANCE_SUM_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	private void resetSelectedRow() {
		Iterator<PW_IL_BALANCE_SUM> PW_IL_BALANCE_SUM = dataList_PW_IL_BALANCE_SUM.iterator();
		while (PW_IL_BALANCE_SUM.hasNext()) {
			PW_IL_BALANCE_SUM.next().setRowSelected(false);
		}
	}

	 public void resetAllComponent() {
		 COMP_PIBS_DOC_DATE.resetValue();
	 }
	 
	 private HtmlOutputLabel COMP_PIBS_DOC_DATE_LABEL;

	 private HtmlCalendar COMP_PIBS_DOC_DATE;

	 private HtmlCommandButton COMP_UI_M_BUT_OK;
	 
	 private HtmlCommandButton COMP_UI_M_TXT_FILE;
	 

	 
	 
	
	public HtmlCommandButton getCOMP_UI_M_TXT_FILE() {
		return COMP_UI_M_TXT_FILE;
	}
	public void setCOMP_UI_M_TXT_FILE(HtmlCommandButton cOMP_UI_M_TXT_FILE) {
		COMP_UI_M_TXT_FILE = cOMP_UI_M_TXT_FILE;
	}
	public HtmlOutputLabel getCOMP_PIBS_DOC_DATE_LABEL() {
		return COMP_PIBS_DOC_DATE_LABEL;
	}
	public void setCOMP_PIBS_DOC_DATE_LABEL(HtmlOutputLabel cOMP_PIBS_DOC_DATE_LABEL) {
		COMP_PIBS_DOC_DATE_LABEL = cOMP_PIBS_DOC_DATE_LABEL;
	}
	public HtmlCalendar getCOMP_PIBS_DOC_DATE() {
		return COMP_PIBS_DOC_DATE;
	}
	public void setCOMP_PIBS_DOC_DATE(HtmlCalendar cOMP_PIBS_DOC_DATE) {
		COMP_PIBS_DOC_DATE = cOMP_PIBS_DOC_DATE;
	}
	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}
	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton cOMP_UI_M_BUT_OK) {
		COMP_UI_M_BUT_OK = cOMP_UI_M_BUT_OK;
	}
	public String whenButtonPressedUI_M_BUT_OK() throws Exception{
		try {
			//PROCEDURE HAVE TO CALL
			P_BALANCE_SUM(DOC_DATE);
			helper.executeQuery(compositeAction);
			//callReportModalPanel();
			/*String message ="Generated text file succesfully";
			getWarningMap().put("writeFile",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);*/
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("WRITE", e.getMessage());
			
			// TODO: handle exception
		}
		return "";
	}
	/*public String WriteInToTextFile()throws Exception{
		try {
			helper.executeQuery(compositeAction);
			
			String message ="Generated text file succesfully";
			getWarningMap().put("writeFile",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("WRITE", e.getMessage());
			
			// TODO: handle exception
		}
		return "";
	}*/
	public ArrayList<OracleParameter> P_BALANCE_SUM(
			String P_DOC_DT)throws Exception {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "DATE", "IN",P_DOC_DT);
			parameterList.add(param1);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_SMART_STREAM.P_BALANCE_SUM");
		} catch(Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new Exception(e.getMessage());
		}
		return outputList;
	}
	String DOC_DATE=null;
	public void validatePIBS_DOC_DATE(FacesContext context,
			UIComponent component, Object value)  {
		Date CurValue = (Date) value;
		try {
			PW_IL_BALANCE_SUM_BEAN.setPIBS_DOC_DATE(CurValue);
			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			DOC_DATE = simpleDateFormat1.format(CurValue);
			System.out.println("CurValue Date  :"+PW_IL_BALANCE_SUM_BEAN.getPIBS_DOC_DATE());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Premtype", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL;
	
	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL() {
		return COMP_REPORT_MODAL_PANEL;
	}
	public void setCOMP_REPORT_MODAL_PANEL(HtmlModalPanel cOMP_REPORT_MODAL_PANEL) {
		COMP_REPORT_MODAL_PANEL = cOMP_REPORT_MODAL_PANEL;
	}
	
	private HtmlAjaxCommandButton COMP_CANCEL_BUTTON;
	
	private String redirectUrl;
	
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	public HtmlAjaxCommandButton getCOMP_CANCEL_BUTTON() {
		return COMP_CANCEL_BUTTON;
	}
	public void setCOMP_CANCEL_BUTTON(HtmlAjaxCommandButton cOMP_CANCEL_BUTTON) {
		COMP_CANCEL_BUTTON = cOMP_CANCEL_BUTTON;
	}
	/*public String runAction(){
		try {
			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			//runActionAfterValidate();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}*/

	public String runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		try {
			/*added by raja on 03-08-2017 for ZBILQC-1725878*/
			if(dataList_PW_IL_BALANCE_SUM.size()<=0)
			{
				throw new Exception("No Records Found for the Date");
			}
			/*end*/
			String url = null;		
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			url = request.getContextPath() + "/SmartStreamProcessServlet?";
			setRedirectUrl(url.toString());
			if (getRedirectUrl() != null) {
				response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				response.sendRedirect(getRedirectUrl());
			}
			
			System.out.println("getRedirectUrl               :"+getRedirectUrl());
			
			String message ="Generated text file succesfully";
			getWarningMap().put("writeFile",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}
	public String callReportModalPanel(){
			getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
		return null;
	}
	
	public String cancelModalPanel(){
		getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		return "";
	}
	
}

