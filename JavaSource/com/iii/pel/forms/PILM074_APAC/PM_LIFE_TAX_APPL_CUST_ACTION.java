package com.iii.pel.forms.PILM074_APAC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_LIFE_TAX_APPL_CUST_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_TAC_CUST_CLASS_LABEL;

	private HtmlInputText COMP_TAC_CUST_CLASS;

	private HtmlOutputLabel COMP_TAC_CUST_CLASS_DESC_LABEL;

	private HtmlInputText COMP_TAC_CUST_CLASS_DESC;

	private HtmlOutputLabel COMP_TAC_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_TAC_EFF_FM_DT;

	private HtmlOutputLabel COMP_TAC_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_TAC_EFF_TO_DT;

	private PM_LIFE_TAX_APPL_CUST PM_LIFE_TAX_APPL_CUST_BEAN;

	/** Following Variables are added for functionality */
	private UIData custDataTable;
	private ArrayList<PM_LIFE_TAX_APPL_CUST> taxApplCust = new ArrayList<PM_LIFE_TAX_APPL_CUST>();
	
	private ArrayList<PM_LIFE_TAX_APPL_CUST> custCodeLov;
	
	private int prevRowIndex;
	private int currPage;
	private int lastUpdatedRowIndex;
	private int recordsPerPage = 5;
	private String filterByTAC_CUST_CLASS;
	private String filterByTAC_CUST_CLASS_DESC;
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	private HtmlAjaxCommandButton UI_M_BUT_POST;

	/** Following Variables are added for functionality */
	
	
	public PM_LIFE_TAX_APPL_CUST_ACTION() {
		PM_LIFE_TAX_APPL_CUST_BEAN = new PM_LIFE_TAX_APPL_CUST();
		
		instantiateAllComponents();
	}

	public HtmlOutputLabel getCOMP_TAC_CUST_CLASS_LABEL() {
		return COMP_TAC_CUST_CLASS_LABEL;
	}

	public HtmlInputText getCOMP_TAC_CUST_CLASS() {
		return COMP_TAC_CUST_CLASS;
	}

	public void setCOMP_TAC_CUST_CLASS_LABEL(HtmlOutputLabel COMP_TAC_CUST_CLASS_LABEL) {
		this.COMP_TAC_CUST_CLASS_LABEL = COMP_TAC_CUST_CLASS_LABEL;
	}

	public void setCOMP_TAC_CUST_CLASS(HtmlInputText COMP_TAC_CUST_CLASS) {
		this.COMP_TAC_CUST_CLASS = COMP_TAC_CUST_CLASS;
	}

	public HtmlOutputLabel getCOMP_TAC_CUST_CLASS_DESC_LABEL() {
		return COMP_TAC_CUST_CLASS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_TAC_CUST_CLASS_DESC() {
		return COMP_TAC_CUST_CLASS_DESC;
	}

	public void setCOMP_TAC_CUST_CLASS_DESC_LABEL(HtmlOutputLabel COMP_TAC_CUST_CLASS_DESC_LABEL) {
		this.COMP_TAC_CUST_CLASS_DESC_LABEL = COMP_TAC_CUST_CLASS_DESC_LABEL;
	}

	public void setCOMP_TAC_CUST_CLASS_DESC(HtmlInputText COMP_TAC_CUST_CLASS_DESC) {
		this.COMP_TAC_CUST_CLASS_DESC = COMP_TAC_CUST_CLASS_DESC;
	}

	public HtmlOutputLabel getCOMP_TAC_EFF_FM_DT_LABEL() {
		return COMP_TAC_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TAC_EFF_FM_DT() {
		return COMP_TAC_EFF_FM_DT;
	}

	public void setCOMP_TAC_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_TAC_EFF_FM_DT_LABEL) {
		this.COMP_TAC_EFF_FM_DT_LABEL = COMP_TAC_EFF_FM_DT_LABEL;
	}

	public void setCOMP_TAC_EFF_FM_DT(HtmlCalendar COMP_TAC_EFF_FM_DT) {
		this.COMP_TAC_EFF_FM_DT = COMP_TAC_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_TAC_EFF_TO_DT_LABEL() {
		return COMP_TAC_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TAC_EFF_TO_DT() {
		return COMP_TAC_EFF_TO_DT;
	}

	public void setCOMP_TAC_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_TAC_EFF_TO_DT_LABEL) {
		this.COMP_TAC_EFF_TO_DT_LABEL = COMP_TAC_EFF_TO_DT_LABEL;
	}

	public void setCOMP_TAC_EFF_TO_DT(HtmlCalendar COMP_TAC_EFF_TO_DT) {
		this.COMP_TAC_EFF_TO_DT = COMP_TAC_EFF_TO_DT;
	}

	public PM_LIFE_TAX_APPL_CUST getPM_LIFE_TAX_APPL_CUST_BEAN() {
		return PM_LIFE_TAX_APPL_CUST_BEAN;
	}

	public void setPM_LIFE_TAX_APPL_CUST_BEAN(PM_LIFE_TAX_APPL_CUST PM_LIFE_TAX_APPL_CUST_BEAN) {
		this.PM_LIFE_TAX_APPL_CUST_BEAN = PM_LIFE_TAX_APPL_CUST_BEAN;
	}

	public UIData getCustDataTable() {
		return custDataTable;
	}

	public void setCustDataTable(UIData custDataTable) {
		this.custDataTable = custDataTable;
	}

	public ArrayList<PM_LIFE_TAX_APPL_CUST> getTaxApplCust() {
		return taxApplCust;
	}

	public void setTaxApplCust(ArrayList<PM_LIFE_TAX_APPL_CUST> taxApplCust) {
		this.taxApplCust = taxApplCust;
	}
	
	public ArrayList<PM_LIFE_TAX_APPL_CUST> getCustCodeLov() {
		return custCodeLov;
	}

	public void setCustCodeLov(ArrayList<PM_LIFE_TAX_APPL_CUST> custCodeLov) {
		this.custCodeLov = custCodeLov;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	
	public void addNew(ActionEvent ae){
		
		int rowCount = 0;
		if(taxApplCust == null){
			taxApplCust = new ArrayList<PM_LIFE_TAX_APPL_CUST>();
		}
		
		getWarningMap().clear();
		PILM074_APAC_COMPOSITE_ACTION compositeAction = (PILM074_APAC_COMPOSITE_ACTION) CommonUtils.getGlobalObject("PILM074_APAC_COMPOSITE_ACTION");
		PM_LIFE_TAX_HEADER hdrBean = compositeAction.getPM_LIFE_TAX_HEADER_ACTION_BEAN().getPM_LIFE_TAX_HEADER_BEAN();
		
		PM_LIFE_TAX_APPL_CUST dBean = new PM_LIFE_TAX_APPL_CUST();
		dBean.setTAC_TH_TAX_TYPE(hdrBean.getTH_TAX_TYPE());
		
		taxApplCust.add(dBean);
		rowCount = getCustDataTable().getRowCount();
		currPage = rowCount/recordsPerPage;
		if(rowCount%recordsPerPage>0){
			currPage++;
		}
	}
	
	public String deleteRow()
	{
		PM_LIFE_TAX_APPL_CUST bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (taxApplCust != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < taxApplCust.size();) {
				bean = taxApplCust.get(index);
				if (bean.isCheckBoxValue()) {
					taxApplCust.remove(bean);
					deletedRecordIndex = new PILM074_APAC_DELEGATE().deleteLifeTaxClass(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			if(deletedRecordList.size()>0) {
				String message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete");
				getWarningMap().put("current", message);
			}
			lastUpdatedRowIndex = -1;
		}
		return "";
	}
	
	public String checkBoxStatus(ActionEvent actionEvent){
		CommonUtils.clearMaps(this);
		boolean checkBoxValue = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getCustDataTable().getRowIndex();
		getTaxApplCust().get(rowIndex).setCheckBoxValue(checkBoxValue);
		return "";
	}
	
	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: "+value);
			}
		}
		return value;
	}
	
	public String saveGridData(){
		try {
			getWarningMap().put("current",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
			new CommonUtils().doComitt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String  lastColumnListener(){
		int currRowIndex = getCustDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_LIFE_TAX_APPL_CUST gridValueBean = null;
		String message = null;
		PILM074_APAC_HELPER helper = new PILM074_APAC_HELPER();
		try {
			if (currRowIndex >= 0) {
				gridValueBean = taxApplCust.get(currRowIndex);
				if(gridValueBean.getROWID()== null){
					message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert");
					helper.pre_insert_class(gridValueBean);
				}else{
					message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update");
					helper.pre_update_class(gridValueBean);
				}
				rowUpdated = new PILM074_APAC_DELEGATE().updateLifeTaxClassDetails(gridValueBean);
				if (rowUpdated == 1) {
					getWarningMap().put("current", message);
				}
				lastUpdatedRowIndex = currRowIndex;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return "" ;
	}
	
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009 
	/*public void gridtabListener() {
		int currRowIndex = getCustDataTable().getRowIndex();
		PM_LIFE_TAX_APPL_CUST detailsBean = null;
		PILM074_APAC_HELPER helper = new PILM074_APAC_HELPER();
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != 0) {
						if (currRowIndex != prevRowIndex) {
							detailsBean = new PM_LIFE_TAX_APPL_CUST();
							detailsBean =  taxApplCust.get(prevRowIndex);
							if (detailsBean.getROWID() == null) {
								helper.pre_insert_class(detailsBean);
							} else {
								helper.pre_update_class(detailsBean);
							}
							new PILM074_APAC_DELEGATE().updateLifeTaxClassDetails(detailsBean);
							prevRowIndex = currRowIndex;
						}
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return;
	}*/
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009 

	public void checkBoxValidation(ActionEvent event){	}

	public void onPageLoad() {
		PILM074_APAC_COMPOSITE_ACTION compositeAction = (PILM074_APAC_COMPOSITE_ACTION) CommonUtils.getGlobalObject("PILM074_APAC_COMPOSITE_ACTION");
		String taxType = compositeAction.getPM_LIFE_TAX_HEADER_ACTION_BEAN().getPM_LIFE_TAX_HEADER_BEAN().getTH_TAX_TYPE();
		PILM074_APAC_DELEGATE delegate = new PILM074_APAC_DELEGATE();
		taxApplCust = delegate.fetchLifeTaxClass(taxType);
		getWarningMap().clear();
		for (PM_LIFE_TAX_APPL_CUST tempBean : taxApplCust) {
			new PILM074_APAC_HELPER().POST_QUERY_TRIGGER_CUST(tempBean);
		}
		
		compositeAction.getPM_LIFE_TAX_APPL_CUST_ACTION_BEAN().setTaxApplCust(taxApplCust);
		if (taxApplCust.size() !=0){					
			compositeAction.getPM_LIFE_TAX_APPL_CUST_ACTION_BEAN().setPM_LIFE_TAX_APPL_CUST_BEAN(taxApplCust.get(0));
			compositeAction.getPM_LIFE_TAX_APPL_CUST_ACTION_BEAN().getPM_LIFE_TAX_APPL_CUST_BEAN().setRowSelected(true);
		}
		
		
	}
	
	public ArrayList<PM_LIFE_TAX_APPL_CUST> lovForCustCode(Object event) {
		String custCode = (String) event;
		custCodeLov = new PILM074_APAC_DELEGATE().prepareCustCodeLov(custCode, custCodeLov);
		return custCodeLov;
	}
	
	public void getCustCodeDesc(ActionEvent event) {
		Iterator<PM_LIFE_TAX_APPL_CUST> iterator = null;
		int rowIndex = getCustDataTable().getRowIndex();
		PM_LIFE_TAX_APPL_CUST bean = null;
		boolean keepLooking = true;
		String custCode = null;
		PM_LIFE_TAX_APPL_CUST productBean = taxApplCust.get(rowIndex);
		UIInput inputtext = (UIInput) event.getComponent().getParent().getParent();
		System.out.println(inputtext.getSubmittedValue());
		custCode = (String) inputtext.getSubmittedValue();
		if (custCode != null && !custCode.trim().isEmpty()) {
			if (custCodeLov != null) {
				iterator = custCodeLov.iterator();
				while (iterator.hasNext() && keepLooking) {
					bean = iterator.next();
					if (bean.getTAC_CUST_CLASS().equalsIgnoreCase(custCode)) {
						productBean.setTAC_CUST_CLASS(bean.getTAC_CUST_CLASS());
						productBean.setTAC_CUST_CLASS_DESC(bean.getTAC_CUST_CLASS_DESC());
						keepLooking = false;
					}
				}
			}
		}
	}
	
	public void validateTAC_CUST_CLASS(FacesContext context,
			UIComponent component, Object value) throws SQLException, Exception {
//		int rowIndex = getCustDataTable().getRowIndex();
//		PM_LIFE_TAX_APPL_CUST bean = taxApplCust.get(rowIndex);
		if (value != null) {
			String TAC_CUST_CLASS_DESC = new PILM074_APAC_HELPER().whenValidate_TAC_CUST_CLASS(this,value);
			getPM_LIFE_TAX_APPL_CUST_BEAN().setTAC_CUST_CLASS_DESC(TAC_CUST_CLASS_DESC);
		}
	}
	
	public void TAC_CUST_CLASS_ACTION(ActionEvent event){
		getWarningMap().clear();
		String classCode  = getCurrentValue(event);
		int rowIndex = getCustDataTable().getRowIndex();
		taxApplCust.get(rowIndex).setTAC_CUST_CLASS(classCode);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009 
		//gridtabListener();
	}
	
	public void validateTAC_EFF_FM_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		UIInput inputText = (UIInput) component;
		Date effFromDate = this.getCOMP_TAC_EFF_FM_DT().getAsDate(inputText.getSubmittedValue());
		int rowIndex = getCustDataTable().getRowIndex();
		if(rowIndex >= 0)
		{
			taxApplCust.get(rowIndex).setTAC_EFF_FM_DT(effFromDate);
			Date effToDate = taxApplCust.get(rowIndex).getTAC_EFF_TO_DT();
			new PILM074_APAC_HELPER().whenValidate_TAC_EFF_FM_DT(this,effFromDate, effToDate);
		}
		
	}
	
	public void TAC_EFF_FM_DT_ACTION(ActionEvent event){
		getWarningMap().clear();
		UIInput inputText = (UIInput) event.getComponent().getParent();
		Date effFromDate = this.getCOMP_TAC_EFF_FM_DT().getAsDate(inputText.getSubmittedValue());
		int rowIndex = getCustDataTable().getRowIndex();
		if(rowIndex >= 0)
		{
			taxApplCust.get(rowIndex).setTAC_EFF_FM_DT(effFromDate);
			Date effToDate = taxApplCust.get(rowIndex).getTAC_EFF_TO_DT();
			new PILM074_APAC_HELPER().whenValidate_TAC_EFF_FM_DT(this,effFromDate, effToDate);
			// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009 
			//gridtabListener();
		}
		ErrorHelpUtil.validate(inputText, getErrorMap());
	}
	
	public void validateTAC_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value) throws SQLException, Exception {
		UIInput inputText = (UIInput) component;
		Date effToDate = this.getCOMP_TAC_EFF_TO_DT().getAsDate(inputText.getSubmittedValue());
		int rowIndex = getCustDataTable().getRowIndex();
		if(rowIndex >= 0)
		{
			taxApplCust.get(rowIndex).setTAC_EFF_TO_DT(effToDate);
			Date effFromDate = taxApplCust.get(rowIndex).getTAC_EFF_FM_DT();
			new PILM074_APAC_HELPER().whenValidate_TAC_EFF_TO_DT(this,effFromDate, effToDate);
		}
	}
	
	public void TAC_EFF_TO_DT_ACTION(ActionEvent event){
		getWarningMap().clear();
		UIInput inputText = (UIInput) event.getComponent().getParent();
		Date effToDate = this.getCOMP_TAC_EFF_TO_DT().getAsDate(inputText.getSubmittedValue());
		int rowIndex = getCustDataTable().getRowIndex();
		if(rowIndex >= 0)
		{
			taxApplCust.get(rowIndex).setTAC_EFF_TO_DT(effToDate);
			Date effFromDate = taxApplCust.get(rowIndex).getTAC_EFF_FM_DT();
			new PILM074_APAC_HELPER().whenValidate_TAC_EFF_TO_DT(this,effFromDate, effToDate);
			// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009 
			//lastColumnListener();
		}
		ErrorHelpUtil.validate(inputText, getErrorMap());
	}
	
	// [ Added for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = custDataTable.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListener();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	// [ Added for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
	public void getDetails() {
		try {
			if (taxApplCust.size() != 0) {				
				PM_LIFE_TAX_APPL_CUST_BEAN = (PM_LIFE_TAX_APPL_CUST) custDataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_LIFE_TAX_APPL_CUST_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void resetAllComponent() {
		// TODO Auto-generated method stub
		COMP_TAC_CUST_CLASS.resetValue();
		COMP_TAC_CUST_CLASS_DESC.resetValue();
		COMP_TAC_EFF_FM_DT.resetValue();
		COMP_TAC_EFF_TO_DT.resetValue();
		//Added by kavitha on 07.10.2019 for orient
		COMP_TAC_CUST_CLASS_TO.resetValue();
		COMP_TAC_CUST_CLASS_TO_DESC.resetValue();
	}
	
	protected void instantiateAllComponents() {
		// TODO Auto-generated method stub
		COMP_TAC_CUST_CLASS = new HtmlInputText();
		COMP_TAC_CUST_CLASS_DESC = new HtmlInputText();
		COMP_TAC_EFF_FM_DT = new HtmlCalendar();
		COMP_TAC_EFF_TO_DT = new HtmlCalendar();
		//Added by kavitha on 07.10.2019 for orient
		COMP_TAC_CUST_CLASS_TO = new HtmlInputText();
		COMP_TAC_CUST_CLASS_TO_DESC = new HtmlInputText();
	}


	protected void resetSelectedRow() {
			Iterator<PM_LIFE_TAX_APPL_CUST> iterator = taxApplCust.iterator();
			while (iterator.hasNext()) {
				iterator.next().setRowSelected(false);
			}
	}

	public String getFilterByTAC_CUST_CLASS() {
		return filterByTAC_CUST_CLASS;
	}

	public void setFilterByTAC_CUST_CLASS(String filterByTAC_CUST_CLASS) {
		this.filterByTAC_CUST_CLASS = filterByTAC_CUST_CLASS;
	}

	public String getFilterByTAC_CUST_CLASS_DESC() {
		return filterByTAC_CUST_CLASS_DESC;
	}

	public void setFilterByTAC_CUST_CLASS_DESC(String filterByTAC_CUST_CLASS_DESC) {
		this.filterByTAC_CUST_CLASS_DESC = filterByTAC_CUST_CLASS_DESC;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PM_LIFE_TAX_APPL_CUST_BEAN = new PM_LIFE_TAX_APPL_CUST();
				resetAllComponent();
			}else{
				getErrorMap().put("somekey",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put("current",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}	
	}

	public void deleteRow(ActionEvent ae) {
		
		try{
			getErrorMap().clear();
			getWarningMap().clear();

			if(isDELETE_ALLOWED()) {
				if(PM_LIFE_TAX_APPL_CUST_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PM_LIFE_TAX_APPL_CUST_BEAN, CommonUtils.getConnection());
					taxApplCust.remove(PM_LIFE_TAX_APPL_CUST_BEAN);
				}
				
				if(taxApplCust.size() > 0) {
					setPM_LIFE_TAX_APPL_CUST_BEAN(taxApplCust.get(0));
					PM_LIFE_TAX_APPL_CUST_BEAN.setRowSelected(true);
				} else {
					AddRow(ae);
				}
				
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				getWarningMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}

	public void post(ActionEvent ae) {
		PILM074_APAC_HELPER helper = new PILM074_APAC_HELPER();
	
		try{
			if(PM_LIFE_TAX_APPL_CUST_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {

					helper.pre_update_class(PM_LIFE_TAX_APPL_CUST_BEAN);
					new CRUDHandler().executeInsert(PM_LIFE_TAX_APPL_CUST_BEAN, CommonUtils.getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			} else {

				if(isINSERT_ALLOWED()) {
					helper.pre_insert_class(PM_LIFE_TAX_APPL_CUST_BEAN);
					new CRUDHandler().executeInsert(PM_LIFE_TAX_APPL_CUST_BEAN, CommonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					taxApplCust.add(PM_LIFE_TAX_APPL_CUST_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_LIFE_TAX_APPL_CUST_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	//Added by kavitha on 07.10.2019 for Orient
	private HtmlOutputLabel COMP_TAC_CUST_CLASS_TO_LABEL;
	private HtmlInputText COMP_TAC_CUST_CLASS_TO;
	private HtmlInputText COMP_TAC_CUST_CLASS_TO_DESC;
	
	public void validateTAC_CUST_CLASS_TO(FacesContext context,
			UIComponent component, Object value) throws SQLException, Exception {
		if (value != null) {
			String TAC_CUST_CLASS_DESC = new PILM074_APAC_HELPER().whenValidate_TAC_CUST_CLASS(this,value);
			getPM_LIFE_TAX_APPL_CUST_BEAN().setTAC_CUST_CLASS_TO_DESC(TAC_CUST_CLASS_DESC);
		}
	}

	public HtmlOutputLabel getCOMP_TAC_CUST_CLASS_TO_LABEL() {
		return COMP_TAC_CUST_CLASS_TO_LABEL;
	}

	public void setCOMP_TAC_CUST_CLASS_TO_LABEL(
			HtmlOutputLabel cOMP_TAC_CUST_CLASS_TO_LABEL) {
		COMP_TAC_CUST_CLASS_TO_LABEL = cOMP_TAC_CUST_CLASS_TO_LABEL;
	}

	public HtmlInputText getCOMP_TAC_CUST_CLASS_TO() {
		return COMP_TAC_CUST_CLASS_TO;
	}

	public void setCOMP_TAC_CUST_CLASS_TO(HtmlInputText cOMP_TAC_CUST_CLASS_TO) {
		COMP_TAC_CUST_CLASS_TO = cOMP_TAC_CUST_CLASS_TO;
	}

	public HtmlInputText getCOMP_TAC_CUST_CLASS_TO_DESC() {
		return COMP_TAC_CUST_CLASS_TO_DESC;
	}

	public void setCOMP_TAC_CUST_CLASS_TO_DESC(
			HtmlInputText cOMP_TAC_CUST_CLASS_TO_DESC) {
		COMP_TAC_CUST_CLASS_TO_DESC = cOMP_TAC_CUST_CLASS_TO_DESC;
	}
	
	
	
}
