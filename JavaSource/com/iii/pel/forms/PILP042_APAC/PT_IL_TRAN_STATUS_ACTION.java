package com.iii.pel.forms.PILP042_APAC;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_TRAN_STATUS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_WD_STATUS_DT_LABEL;

	private HtmlCalendar COMP_UI_M_WD_STATUS_DT;

	private HtmlOutputLabel COMP_UI_M_WD_STATUS_CODE_LABEL;

	private HtmlInputText COMP_UI_M_WD_STATUS_CODE;

	private HtmlOutputLabel COMP_UI_M_WD_STATUS_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_WD_STATUS_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_WD_REASON_CODE_LABEL;

	private HtmlInputText COMP_UI_M_WD_REASON_CODE;

	private HtmlOutputLabel COMP_UI_M_WD_REASON_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_WD_REASON_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_WD_REMARKS_LABEL;

	private HtmlInputText COMP_UI_M_WD_REMARKS;

	private HtmlOutputLabel COMP_TS_STATUS_DT_LABEL;

	private HtmlCalendar COMP_TS_STATUS_DT;

	private HtmlOutputLabel COMP_TS_STATUS_CODE_LABEL;

	private HtmlInputText COMP_TS_STATUS_CODE;

	private HtmlOutputLabel COMP_UI_M_STATUS_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_STATUS_CODE_DESC;

	private HtmlOutputLabel COMP_TS_REASON_CODE_LABEL;

	private HtmlInputText COMP_TS_REASON_CODE;

	private HtmlOutputLabel COMP_UI_M_REASON_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_REASON_CODE_DESC;

	private HtmlOutputLabel COMP_TS_STATUS_UID_LABEL;

	private HtmlInputText COMP_TS_STATUS_UID;

	private HtmlOutputLabel COMP_TS_REMARKS_LABEL;

	private HtmlInputText COMP_TS_REMARKS;

	private HtmlCommandButton COMP_UI_M_BUT_STATUS_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_REASON_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private HtmlCommandButton COMP_ITEM160;

	PT_IL_FUND_TRAN_DTL_DELEGATE delegate = new PT_IL_FUND_TRAN_DTL_DELEGATE();

	private List statusCodeList = new ArrayList();

	private List reasonCodeList = new ArrayList();

	private PT_IL_TRAN_STATUS PT_IL_TRAN_STATUS_BEAN;
	
	private List dataTableList=new ArrayList<PT_IL_TRAN_STATUS>();
	
	private int recordsperPage=10;
	
	private UIData dataTable;
	

	public PT_IL_TRAN_STATUS_ACTION() {
		PT_IL_TRAN_STATUS_BEAN = new PT_IL_TRAN_STATUS();
        dataTableList = new ArrayList<PT_IL_TRAN_STATUS>();
		instantiateAllComponents();
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_STATUS_DT_LABEL() {
		return COMP_UI_M_WD_STATUS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_WD_STATUS_DT() {
		return COMP_UI_M_WD_STATUS_DT;
	}

	public void setCOMP_UI_M_WD_STATUS_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_WD_STATUS_DT_LABEL) {
		this.COMP_UI_M_WD_STATUS_DT_LABEL = COMP_UI_M_WD_STATUS_DT_LABEL;
	}

	public void setCOMP_UI_M_WD_STATUS_DT(HtmlCalendar COMP_UI_M_WD_STATUS_DT) {
		this.COMP_UI_M_WD_STATUS_DT = COMP_UI_M_WD_STATUS_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_STATUS_CODE_LABEL() {
		return COMP_UI_M_WD_STATUS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WD_STATUS_CODE() {
		return COMP_UI_M_WD_STATUS_CODE;
	}

	public void setCOMP_UI_M_WD_STATUS_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_WD_STATUS_CODE_LABEL) {
		this.COMP_UI_M_WD_STATUS_CODE_LABEL = COMP_UI_M_WD_STATUS_CODE_LABEL;
	}

	public void setCOMP_UI_M_WD_STATUS_CODE(
			HtmlInputText COMP_UI_M_WD_STATUS_CODE) {
		this.COMP_UI_M_WD_STATUS_CODE = COMP_UI_M_WD_STATUS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_STATUS_CODE_DESC_LABEL() {
		return COMP_UI_M_WD_STATUS_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WD_STATUS_CODE_DESC() {
		return COMP_UI_M_WD_STATUS_CODE_DESC;
	}

	public void setCOMP_UI_M_WD_STATUS_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_WD_STATUS_CODE_DESC_LABEL) {
		this.COMP_UI_M_WD_STATUS_CODE_DESC_LABEL = COMP_UI_M_WD_STATUS_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_WD_STATUS_CODE_DESC(
			HtmlInputText COMP_UI_M_WD_STATUS_CODE_DESC) {
		this.COMP_UI_M_WD_STATUS_CODE_DESC = COMP_UI_M_WD_STATUS_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_REASON_CODE_LABEL() {
		return COMP_UI_M_WD_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WD_REASON_CODE() {
		return COMP_UI_M_WD_REASON_CODE;
	}

	public void setCOMP_UI_M_WD_REASON_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_WD_REASON_CODE_LABEL) {
		this.COMP_UI_M_WD_REASON_CODE_LABEL = COMP_UI_M_WD_REASON_CODE_LABEL;
	}

	public void setCOMP_UI_M_WD_REASON_CODE(
			HtmlInputText COMP_UI_M_WD_REASON_CODE) {
		this.COMP_UI_M_WD_REASON_CODE = COMP_UI_M_WD_REASON_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_REASON_CODE_DESC_LABEL() {
		return COMP_UI_M_WD_REASON_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WD_REASON_CODE_DESC() {
		return COMP_UI_M_WD_REASON_CODE_DESC;
	}

	public void setCOMP_UI_M_WD_REASON_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_WD_REASON_CODE_DESC_LABEL) {
		this.COMP_UI_M_WD_REASON_CODE_DESC_LABEL = COMP_UI_M_WD_REASON_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_WD_REASON_CODE_DESC(
			HtmlInputText COMP_UI_M_WD_REASON_CODE_DESC) {
		this.COMP_UI_M_WD_REASON_CODE_DESC = COMP_UI_M_WD_REASON_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_REMARKS_LABEL() {
		return COMP_UI_M_WD_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WD_REMARKS() {
		return COMP_UI_M_WD_REMARKS;
	}

	public void setCOMP_UI_M_WD_REMARKS_LABEL(
			HtmlOutputLabel COMP_UI_M_WD_REMARKS_LABEL) {
		this.COMP_UI_M_WD_REMARKS_LABEL = COMP_UI_M_WD_REMARKS_LABEL;
	}

	public void setCOMP_UI_M_WD_REMARKS(HtmlInputText COMP_UI_M_WD_REMARKS) {
		this.COMP_UI_M_WD_REMARKS = COMP_UI_M_WD_REMARKS;
	}

	public HtmlOutputLabel getCOMP_TS_STATUS_DT_LABEL() {
		return COMP_TS_STATUS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TS_STATUS_DT() {
		return COMP_TS_STATUS_DT;
	}

	public void setCOMP_TS_STATUS_DT_LABEL(
			HtmlOutputLabel COMP_TS_STATUS_DT_LABEL) {
		this.COMP_TS_STATUS_DT_LABEL = COMP_TS_STATUS_DT_LABEL;
	}

	public void setCOMP_TS_STATUS_DT(HtmlCalendar COMP_TS_STATUS_DT) {
		this.COMP_TS_STATUS_DT = COMP_TS_STATUS_DT;
	}

	public HtmlOutputLabel getCOMP_TS_STATUS_CODE_LABEL() {
		return COMP_TS_STATUS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TS_STATUS_CODE() {
		return COMP_TS_STATUS_CODE;
	}

	public void setCOMP_TS_STATUS_CODE_LABEL(
			HtmlOutputLabel COMP_TS_STATUS_CODE_LABEL) {
		this.COMP_TS_STATUS_CODE_LABEL = COMP_TS_STATUS_CODE_LABEL;
	}

	public void setCOMP_TS_STATUS_CODE(HtmlInputText COMP_TS_STATUS_CODE) {
		this.COMP_TS_STATUS_CODE = COMP_TS_STATUS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_STATUS_CODE_DESC_LABEL() {
		return COMP_UI_M_STATUS_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_STATUS_CODE_DESC() {
		return COMP_UI_M_STATUS_CODE_DESC;
	}

	public void setCOMP_UI_M_STATUS_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_STATUS_CODE_DESC_LABEL) {
		this.COMP_UI_M_STATUS_CODE_DESC_LABEL = COMP_UI_M_STATUS_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_STATUS_CODE_DESC(
			HtmlInputText COMP_UI_M_STATUS_CODE_DESC) {
		this.COMP_UI_M_STATUS_CODE_DESC = COMP_UI_M_STATUS_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_TS_REASON_CODE_LABEL() {
		return COMP_TS_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TS_REASON_CODE() {
		return COMP_TS_REASON_CODE;
	}

	public void setCOMP_TS_REASON_CODE_LABEL(
			HtmlOutputLabel COMP_TS_REASON_CODE_LABEL) {
		this.COMP_TS_REASON_CODE_LABEL = COMP_TS_REASON_CODE_LABEL;
	}

	public void setCOMP_TS_REASON_CODE(HtmlInputText COMP_TS_REASON_CODE) {
		this.COMP_TS_REASON_CODE = COMP_TS_REASON_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_REASON_CODE_DESC_LABEL() {
		return COMP_UI_M_REASON_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_REASON_CODE_DESC() {
		return COMP_UI_M_REASON_CODE_DESC;
	}

	public void setCOMP_UI_M_REASON_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_REASON_CODE_DESC_LABEL) {
		this.COMP_UI_M_REASON_CODE_DESC_LABEL = COMP_UI_M_REASON_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_REASON_CODE_DESC(
			HtmlInputText COMP_UI_M_REASON_CODE_DESC) {
		this.COMP_UI_M_REASON_CODE_DESC = COMP_UI_M_REASON_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_TS_STATUS_UID_LABEL() {
		return COMP_TS_STATUS_UID_LABEL;
	}

	public HtmlInputText getCOMP_TS_STATUS_UID() {
		return COMP_TS_STATUS_UID;
	}

	public void setCOMP_TS_STATUS_UID_LABEL(
			HtmlOutputLabel COMP_TS_STATUS_UID_LABEL) {
		this.COMP_TS_STATUS_UID_LABEL = COMP_TS_STATUS_UID_LABEL;
	}

	public void setCOMP_TS_STATUS_UID(HtmlInputText COMP_TS_STATUS_UID) {
		this.COMP_TS_STATUS_UID = COMP_TS_STATUS_UID;
	}

	public HtmlOutputLabel getCOMP_TS_REMARKS_LABEL() {
		return COMP_TS_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_TS_REMARKS() {
		return COMP_TS_REMARKS;
	}

	public void setCOMP_TS_REMARKS_LABEL(HtmlOutputLabel COMP_TS_REMARKS_LABEL) {
		this.COMP_TS_REMARKS_LABEL = COMP_TS_REMARKS_LABEL;
	}

	public void setCOMP_TS_REMARKS(HtmlInputText COMP_TS_REMARKS) {
		this.COMP_TS_REMARKS = COMP_TS_REMARKS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_STATUS_LOV() {
		return COMP_UI_M_BUT_STATUS_LOV;
	}

	public void setCOMP_UI_M_BUT_STATUS_LOV(
			HtmlCommandButton COMP_UI_M_BUT_STATUS_LOV) {
		this.COMP_UI_M_BUT_STATUS_LOV = COMP_UI_M_BUT_STATUS_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REASON_LOV() {
		return COMP_UI_M_BUT_REASON_LOV;
	}

	public void setCOMP_UI_M_BUT_REASON_LOV(
			HtmlCommandButton COMP_UI_M_BUT_REASON_LOV) {
		this.COMP_UI_M_BUT_REASON_LOV = COMP_UI_M_BUT_REASON_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public HtmlCommandButton getCOMP_ITEM160() {
		return COMP_ITEM160;
	}

	public void setCOMP_ITEM160(HtmlCommandButton COMP_ITEM160) {
		this.COMP_ITEM160 = COMP_ITEM160;
	}

	public PT_IL_TRAN_STATUS getPT_IL_TRAN_STATUS_BEAN() {
		return PT_IL_TRAN_STATUS_BEAN;
	}

	public void setPT_IL_TRAN_STATUS_BEAN(
			PT_IL_TRAN_STATUS PT_IL_TRAN_STATUS_BEAN) {
		this.PT_IL_TRAN_STATUS_BEAN = PT_IL_TRAN_STATUS_BEAN;
	}

	public List suggesstionActionStatus(Object obj) {
		String code = (String) obj;
		statusCodeList = delegate.getStatusCode(code, statusCodeList);
		return statusCodeList;
	}

	public void getCodeDesc(ActionEvent event) {
		COMP_UI_M_WD_STATUS_CODE_DESC.setSubmittedValue(null);
		
		if (COMP_UI_M_WD_STATUS_CODE.getSubmittedValue() != null) {
			String code = (String) COMP_UI_M_WD_STATUS_CODE.getSubmittedValue();
			String codeDesc = delegate.getStatusCodeDesc(code, statusCodeList);
//			COMP_UI_M_WD_STATUS_CODE_DESC.setSubmittedValue(codeDesc);
			PT_IL_TRAN_STATUS_BEAN.setUI_M_WD_STATUS_CODE_DESC(codeDesc);
		}

	}

	public List suggesstionActionReason(Object obj) {
		String code = (String) obj;
		reasonCodeList = delegate.getReasonCode(code, reasonCodeList);
		return reasonCodeList;
	}

	public void getReasonCodeDesc(ActionEvent event) {
		COMP_UI_M_WD_REASON_CODE_DESC.setSubmittedValue(null);
	

		if (COMP_UI_M_WD_REASON_CODE.getSubmittedValue() != null) {
			String code = (String) COMP_UI_M_WD_REASON_CODE.getSubmittedValue();
			String codeDesc = delegate.getReasonCodeDesc(code, reasonCodeList);
//			COMP_UI_M_WD_REASON_CODE_DESC.setSubmittedValue(codeDesc);
			PT_IL_TRAN_STATUS_BEAN.setUI_M_WD_REASON_CODE_DESC(codeDesc);

		}

	}

	public String backToSwithing() {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest servletRequest = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = servletRequest.getSession();
		PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
		.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		compAction.getPT_IL_TRAN_STATUS_ACTION().setDataTableList(
				delegate.getStatusDetails());
		
		return "ToSwithing";
	}



	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void statusDescriptionWhenValidate(FacesContext facesContext,UIComponent component,Object value){
		
		String statusDescription =(String)value;
		PT_IL_TRAN_STATUS_BEAN.setUI_M_WD_STATUS_CODE_DESC(statusDescription);
	}
	
    public void reasonDescriptionWhenValidate(FacesContext facesContext,UIComponent component,Object value){
		
		String reasonDescription =(String)value;
		PT_IL_TRAN_STATUS_BEAN.setUI_M_WD_REASON_CODE_DESC(reasonDescription);
	}
	
	public String okButtonPress() throws ValidatorException {

		PT_IL_TRAN_STATUS_HELPER helper = new PT_IL_TRAN_STATUS_HELPER();
		PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
		.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		helper.okButtonPressed();
		getWarningMap().put("current", "Records Processed");
		PILP042_APAC_DELEGATE pilp042_apac_delegate = new PILP042_APAC_DELEGATE();
		//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]

		PT_IL_TRAN_STATUS_BEAN.setTS_STATUS_UID(CommonUtils.getControlBean().getM_USER_ID());
		pilp042_apac_delegate.executeInsert(PT_IL_TRAN_STATUS_BEAN);
		compAction.getPT_IL_TRAN_STATUS_ACTION().setDataTableList(
				delegate.getStatusDetails());
		/*
		 * COMMENTED BY DHINESH ON 14-9-2017 
		 * 
		 * HtmlAjaxCommandButton COMP_UI_M_GET_FUND   = new HtmlAjaxCommandButton();*/
		HtmlCommandButton COMP_UI_M_GET_FUND   = new HtmlCommandButton();
		COMP_UI_M_GET_FUND.setDisabled(true);
		compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().setCOMP_UI_M_GET_FUND(COMP_UI_M_GET_FUND);
		HtmlCommandButton COMP_UI_M_STATUS_BUT   = new HtmlCommandButton();
		COMP_UI_M_STATUS_BUT.setDisabled(true);
		compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().setCOMP_UI_M_STATUS_BUT(COMP_UI_M_STATUS_BUT);
	
		
		return "ToSwithing";
	}
	
	public void UI_M_WD_STATUS_DTWhenValidate(FacesContext facesContext,UIComponent component,Object value) throws Exception{
		if(COMP_UI_M_WD_STATUS_DT.getSubmittedValue()!=null){
			
			PT_IL_TRAN_STATUS_HELPER helper = new PT_IL_TRAN_STATUS_HELPER();
			HtmlCalendar htmlCalendar = (HtmlCalendar) component;
			Date statusDate = htmlCalendar.getAsDate(htmlCalendar.getSubmittedValue());
			PT_IL_TRAN_STATUS_BEAN.setTS_STATUS_DT(statusDate);
		}
		
	}
	
	public void UI_M_WD_STATUS_CODEWhenValidate(FacesContext facesContext,UIComponent component,Object value) throws Exception{
		if(COMP_UI_M_WD_STATUS_CODE.getSubmittedValue()!=null){
			
			PT_IL_TRAN_STATUS_HELPER helper = new PT_IL_TRAN_STATUS_HELPER();
			String statusCode = (String)COMP_UI_M_WD_STATUS_CODE.getSubmittedValue();
			PT_IL_TRAN_STATUS_BEAN.setTS_STATUS_CODE(statusCode);
			if(statusCode.equals("A")){
				PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
				compAction.getPT_IL_TRAN_STATUS_ACTION().getCOMP_UI_M_WD_REASON_CODE().setDisabled(true);
			}
			else
			{
				PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
				compAction.getPT_IL_TRAN_STATUS_ACTION().getCOMP_UI_M_WD_REASON_CODE().setDisabled(false);
			}
		}
		
	}
	
	public void UI_M_WD_REASON_CODEWhenValidate(FacesContext facesContext,UIComponent component,Object value) throws Exception{
		if(COMP_UI_M_WD_REASON_CODE.getSubmittedValue()!=null){
			
			PT_IL_TRAN_STATUS_HELPER helper = new PT_IL_TRAN_STATUS_HELPER();
			String reasonCode = (String)COMP_UI_M_WD_REASON_CODE.getSubmittedValue();
			PT_IL_TRAN_STATUS_BEAN.setTS_REASON_CODE(reasonCode);
			
		}
		
	}
	
	public void remarksWhenValidate(FacesContext facesContext,UIComponent component,Object value) throws Exception{
		if(COMP_UI_M_WD_REMARKS.getSubmittedValue()!=null){
			
			PT_IL_TRAN_STATUS_HELPER helper = new PT_IL_TRAN_STATUS_HELPER();
			String remarks = (String)COMP_UI_M_WD_REMARKS.getSubmittedValue();
			PT_IL_TRAN_STATUS_BEAN.setTS_REMARKS(remarks);
			
		}
		
	}
	// display method added by Akash Singh date:-8july2011
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			if (dataTableList.size() != 0) {
				PT_IL_TRAN_STATUS_BEAN = (PT_IL_TRAN_STATUS)dataTable
						.getRowData();
			}
			resetAllComponent();
			// Reset selection for other beans
			resetSelectedRow();
			PT_IL_TRAN_STATUS_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap()
					.put(com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	private void resetSelectedRow() {
		Iterator<PT_IL_TRAN_STATUS> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	public void resetAllComponent() {
		COMP_TS_STATUS_CODE.resetValue();
		COMP_UI_M_STATUS_CODE_DESC.resetValue();
		COMP_TS_STATUS_DT.resetValue();		
		COMP_TS_REASON_CODE.resetValue();
		COMP_UI_M_REASON_CODE_DESC.resetValue();
		COMP_TS_STATUS_UID.resetValue();
		COMP_TS_REMARKS.resetValue();

	}
	public void instantiateAllComponents()
	{
		COMP_TS_STATUS_CODE=new HtmlInputText();
		COMP_UI_M_STATUS_CODE_DESC=new HtmlInputText();
		COMP_TS_STATUS_DT=new HtmlCalendar();
		COMP_TS_REASON_CODE=new HtmlInputText();
		COMP_UI_M_REASON_CODE_DESC=new HtmlInputText();
		COMP_TS_STATUS_UID=new HtmlInputText();
		COMP_TS_REMARKS=new HtmlInputText();
		
		
		
	}
	

	public List getStatusCodeList() {
		return statusCodeList;
	}

	public void setStatusCodeList(List statusCodeList) {
		this.statusCodeList = statusCodeList;
	}

	public List getReasonCodeList() {
		return reasonCodeList;
	}

	public void setReasonCodeList(List reasonCodeList) {
		this.reasonCodeList = reasonCodeList;
	}

	public List getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List dataTableList) {
		this.dataTableList = dataTableList;
	}

	public int getRecordsperPage() {
		return recordsperPage;
	}

	public void setRecordsperPage(int recordsperPage) {
		this.recordsperPage = recordsperPage;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
}
