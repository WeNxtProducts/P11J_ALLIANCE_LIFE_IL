package com.iii.pel.forms.PQ123;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.pel.forms.PILQ004_APAC.POLICY_DETAILS;
import com.iii.pel.forms.PILQ004_APAC.POL_ADDL_COVER;
import com.iii.pel.forms.PILQ004_APAC.POL_DISC_LOAD;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class PV_POL_QUERY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POL_MODULE_LABEL;

	private HtmlInputText COMP_POL_MODULE;

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_ISSUE_DT_LABEL;

	private HtmlCalendar COMP_POL_ISSUE_DT;

	private HtmlOutputLabel COMP_POL_LC_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_POL_LC_SUM_ASSURED;

	private HtmlOutputLabel COMP_POL_LC_PREM_LABEL;

	private HtmlInputText COMP_POL_LC_PREM;

	private HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL;

	private HtmlCalendar COMP_POL_EXPIRY_DT;

	private HtmlOutputLabel COMP_POL_STATUS_LABEL;

	private HtmlInputText COMP_POL_STATUS;

	private PV_POL_QUERY PV_POL_QUERY_BEAN;

	private List<PV_POL_QUERY> dataList_PV_POL_QUERY = new ArrayList<PV_POL_QUERY>();
	
	private List customerCodeList;
	
	private ArrayList<Integer> selectedList = new ArrayList<Integer>();
	
	PV_POL_QUERY_DELEGATE delegate = new PV_POL_QUERY_DELEGATE();
	
	private HtmlInputText COMP_CUST_CODE;
	
	private HtmlInputText COMP_CUST_DESC;
	
	public PV_POL_QUERY_COMPOSITE compositeAction;
	
	private UIData dataTable;
	
	public List getCustomerCodeList() {
		return customerCodeList;
	}

	public void setCustomerCodeList(List customerCodeList) {
		this.customerCodeList = customerCodeList;
	}

	public PV_POL_QUERY_ACTION() {
		PV_POL_QUERY_BEAN = new PV_POL_QUERY();
		instantiateAllComponent();
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public List cutomerCodeLovAction(Object value){
		
     String customerCode = (String)value;
     customerCodeList = delegate.getCustomerCodeValues(customerCode);
      
		
	  return customerCodeList;	
	}
	
	public void getCustDescription(ActionEvent actionEvent){
		COMP_CUST_DESC.setSubmittedValue(null);
		if(COMP_CUST_CODE.getSubmittedValue()!=null){
	
			String custCode =(String)COMP_CUST_CODE.getSubmittedValue();
			String custDesc = delegate.getDescription(custCode, customerCodeList);
		    PV_POL_QUERY_BEAN.setCUST_DESC(custDesc);
		    
    	}
	}
	
	
	public void customerCodeValidation(FacesContext facesContext,UIComponent component,Object value){
		try{
			if(value!=null){
				Map sessionmap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
				PV_POL_QUERY_COMPOSITE compAction = (PV_POL_QUERY_COMPOSITE) sessionmap
				.get("PV_POL_QUERY_COMPOSITE");
				//compAction.getPV_POL_QUERY_ACTION().setDataList_PV_POL_QUERY(delegate.fetchPolicyDetails((String)value));
				dataList_PV_POL_QUERY=delegate.fetchPolicyDetails((String)value);
			}
		}catch(Exception exception){
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/**
	 * 
	 */
	public void fetchDetails() {
		PV_POL_QUERY_HELPER pv_pol_query_helper = new PV_POL_QUERY_HELPER();
		try{
			if (dataList_PV_POL_QUERY!=null && 
					dataList_PV_POL_QUERY.size() != 0) {				
				PV_POL_QUERY_BEAN = (PV_POL_QUERY) dataTable.getRowData();
				pv_pol_query_helper.populateDetails(compositeAction, PV_POL_QUERY_BEAN);
				pv_pol_query_helper.whenNewRecordInstance(compositeAction);
			}
			resetAllComponent();
			resetSelectedRow();
			PV_POL_QUERY_BEAN.setRowSelected(true);
			
			compositeAction.getPREMIUM_ACTION().resetAllComponent();
			compositeAction.getFAC_CO_INS_ACTION().resetAllComponent();
			compositeAction.getPV_CLM_QUERY_ACTION().resetAllComponent();
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param PV_POL_QUERY_BEAN
	 */
	public void fetchDetailsFirstRecord(PV_POL_QUERY PV_POL_QUERY_BEAN) {
		PV_POL_QUERY_HELPER pv_pol_query_helper = new PV_POL_QUERY_HELPER();
		try{
				pv_pol_query_helper.populateDetails(compositeAction, PV_POL_QUERY_BEAN);
				pv_pol_query_helper.whenNewRecordInstance(compositeAction);
				resetAllComponent();
			resetSelectedRow();
			PV_POL_QUERY_BEAN.setRowSelected(true);
			
			compositeAction.getPREMIUM_ACTION().resetAllComponent();
			compositeAction.getFAC_CO_INS_ACTION().resetAllComponent();
			compositeAction.getPV_CLM_QUERY_ACTION().resetAllComponent();
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PV_POL_QUERY> iterator = dataList_PV_POL_QUERY.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public void selectedCheckbox(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();

		String selected = (String) (input.getSubmittedValue());
		int row = dataTable.getRowIndex();
		Integer integer = new Integer(row);
		if ("true".equalsIgnoreCase(selected)) {
			if (!selectedList.contains(integer)) {
				selectedList.add(row);
			}
		} else {
			if (selectedList.contains(integer)) {
				selectedList.remove(integer);
			}
		}
		System.out.println("row"+row);
		PV_POL_QUERY  pv_pol_query = dataList_PV_POL_QUERY.get(row);
		System.out.println("Selected::"+selected);
		if("TRUE".equalsIgnoreCase(selected))
		{
			System.out.println("it is true::"+row);
			pv_pol_query.setSelected(true);
		}
		else
		{
			pv_pol_query.setSelected(false);
		}
		System.out.println("SELETED LIST" + selectedList);
	}
	
	
	public HtmlOutputLabel getCOMP_POL_MODULE_LABEL() {
		return COMP_POL_MODULE_LABEL;
	}

	public HtmlInputText getCOMP_POL_MODULE() {
		return COMP_POL_MODULE;
	}

	public void setCOMP_POL_MODULE_LABEL(HtmlOutputLabel COMP_POL_MODULE_LABEL) {
		this.COMP_POL_MODULE_LABEL = COMP_POL_MODULE_LABEL;
	}

	public void setCOMP_POL_MODULE(HtmlInputText COMP_POL_MODULE) {
		this.COMP_POL_MODULE = COMP_POL_MODULE;
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_POL_ISSUE_DT_LABEL() {
		return COMP_POL_ISSUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_ISSUE_DT() {
		return COMP_POL_ISSUE_DT;
	}

	public void setCOMP_POL_ISSUE_DT_LABEL(HtmlOutputLabel COMP_POL_ISSUE_DT_LABEL) {
		this.COMP_POL_ISSUE_DT_LABEL = COMP_POL_ISSUE_DT_LABEL;
	}

	public void setCOMP_POL_ISSUE_DT(HtmlCalendar COMP_POL_ISSUE_DT) {
		this.COMP_POL_ISSUE_DT = COMP_POL_ISSUE_DT;
	}

	public HtmlOutputLabel getCOMP_POL_LC_SUM_ASSURED_LABEL() {
		return COMP_POL_LC_SUM_ASSURED_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_SUM_ASSURED() {
		return COMP_POL_LC_SUM_ASSURED;
	}

	public void setCOMP_POL_LC_SUM_ASSURED_LABEL(HtmlOutputLabel COMP_POL_LC_SUM_ASSURED_LABEL) {
		this.COMP_POL_LC_SUM_ASSURED_LABEL = COMP_POL_LC_SUM_ASSURED_LABEL;
	}

	public void setCOMP_POL_LC_SUM_ASSURED(HtmlInputText COMP_POL_LC_SUM_ASSURED) {
		this.COMP_POL_LC_SUM_ASSURED = COMP_POL_LC_SUM_ASSURED;
	}

	public HtmlOutputLabel getCOMP_POL_LC_PREM_LABEL() {
		return COMP_POL_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_PREM() {
		return COMP_POL_LC_PREM;
	}

	public void setCOMP_POL_LC_PREM_LABEL(HtmlOutputLabel COMP_POL_LC_PREM_LABEL) {
		this.COMP_POL_LC_PREM_LABEL = COMP_POL_LC_PREM_LABEL;
	}

	public void setCOMP_POL_LC_PREM(HtmlInputText COMP_POL_LC_PREM) {
		this.COMP_POL_LC_PREM = COMP_POL_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_POL_EXPIRY_DT_LABEL() {
		return COMP_POL_EXPIRY_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_EXPIRY_DT() {
		return COMP_POL_EXPIRY_DT;
	}

	public void setCOMP_POL_EXPIRY_DT_LABEL(HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL) {
		this.COMP_POL_EXPIRY_DT_LABEL = COMP_POL_EXPIRY_DT_LABEL;
	}

	public void setCOMP_POL_EXPIRY_DT(HtmlCalendar COMP_POL_EXPIRY_DT) {
		this.COMP_POL_EXPIRY_DT = COMP_POL_EXPIRY_DT;
	}

	public HtmlOutputLabel getCOMP_POL_STATUS_LABEL() {
		return COMP_POL_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_POL_STATUS() {
		return COMP_POL_STATUS;
	}

	public void setCOMP_POL_STATUS_LABEL(HtmlOutputLabel COMP_POL_STATUS_LABEL) {
		this.COMP_POL_STATUS_LABEL = COMP_POL_STATUS_LABEL;
	}

	public void setCOMP_POL_STATUS(HtmlInputText COMP_POL_STATUS) {
		this.COMP_POL_STATUS = COMP_POL_STATUS;
	}

	public PV_POL_QUERY getPV_POL_QUERY_BEAN() {
		return PV_POL_QUERY_BEAN;
	}

	public void setPV_POL_QUERY_BEAN(PV_POL_QUERY PV_POL_QUERY_BEAN) {
		this.PV_POL_QUERY_BEAN = PV_POL_QUERY_BEAN;
	}

	public List<PV_POL_QUERY> getDataList_PV_POL_QUERY() {
		return dataList_PV_POL_QUERY;
	}

	public void setDataListPV_POL_QUERY(List<PV_POL_QUERY> dataList_PV_POL_QUERY) {
		this.dataList_PV_POL_QUERY = dataList_PV_POL_QUERY;
	}

	public HtmlInputText getCOMP_CUST_CODE() {
		return COMP_CUST_CODE;
	}

	public void setCOMP_CUST_CODE(HtmlInputText comp_cust_code) {
		COMP_CUST_CODE = comp_cust_code;
	}

	public HtmlInputText getCOMP_CUST_DESC() {
		return COMP_CUST_DESC;
	}

	public void setCOMP_CUST_DESC(HtmlInputText comp_cust_desc) {
		COMP_CUST_DESC = comp_cust_desc;
	}

	public void setDataList_PV_POL_QUERY(List<PV_POL_QUERY> dataList_PV_POL_QUERY) {
		this.dataList_PV_POL_QUERY = dataList_PV_POL_QUERY;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<Integer> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(ArrayList<Integer> selectedList) {
		this.selectedList = selectedList;
	}
	

	/**
	 * Resets all components in PV_POL_QUERY_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_POL_MODULE.resetValue();
		COMP_POL_NO.resetValue();
		COMP_POL_LC_SUM_ASSURED.resetValue();
		COMP_POL_LC_PREM.resetValue();
		COMP_POL_STATUS.resetValue();
		COMP_CUST_CODE.resetValue();
		COMP_CUST_DESC.resetValue();

		// Reseting HtmlCalendar
		COMP_POL_ISSUE_DT.resetValue();
		COMP_POL_EXPIRY_DT.resetValue();

	}

	/**
	 * Instantiates all components in PV_POL_QUERY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_POL_MODULE					 = new HtmlInputText();
		COMP_POL_NO					 = new HtmlInputText();
		COMP_POL_LC_SUM_ASSURED				 = new HtmlInputText();
		COMP_POL_LC_PREM				 = new HtmlInputText();
		COMP_POL_STATUS					 = new HtmlInputText();
		COMP_CUST_CODE					 = new HtmlInputText();
		COMP_CUST_DESC					 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_POL_ISSUE_DT				 = new HtmlCalendar();
		COMP_POL_EXPIRY_DT				 = new HtmlCalendar();

	}



}
