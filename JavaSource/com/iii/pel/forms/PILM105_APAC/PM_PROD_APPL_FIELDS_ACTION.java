package com.iii.pel.forms.PILM105_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_PROD_APPL_FIELDS_ACTION extends CommonAction {

	private PM_PROD_APPL_FIELDS PM_PROD_APPL_FIELDS_BEAN;

	public PILM105_APAC_COMPOSITE_ACTION compositeAction;

	private PM_PROD_APPL_FIELDS_HELPER helper;

	private List<PM_PROD_APPL_FIELDS> dataList_PM_PROD_APPL_FIELDS = new ArrayList<PM_PROD_APPL_FIELDS>();

	private UIData dataTable;

	private HtmlInputText COMP_COL_CODE;

	private HtmlInputText COMP_COL_CODE_DESC;

	private HtmlSelectOneMenu COMP_MAND_YN;

	private HtmlSelectOneMenu COMP_NMAND_YN;

	private HtmlOutputLabel COMP_COL_CODE_LABEL;

	private HtmlOutputLabel COMP_COL_CODE_DESC_LABEL;

	private HtmlOutputLabel COMP_MAND_YN_LABEL;

	private HtmlOutputLabel COMP_NMAND_YN_LABEL;
	
	private HtmlOutputLabel COMP_PROD_CODE_LABEL;
	
	private HtmlInputText COMP_PROD_CODE;
	
	private String productCode;
	
	 private List<SelectItem> listMandYN = new ArrayList<SelectItem>();
	 
	 private List<SelectItem> listNMandYN = new ArrayList<SelectItem>();
	 
	 private List<LovBean> suggestionList = new ArrayList<LovBean>();
	public PM_PROD_APPL_FIELDS_ACTION() {
		instantiateAllComponent();
		PM_PROD_APPL_FIELDS_BEAN = new PM_PROD_APPL_FIELDS();
		helper = new PM_PROD_APPL_FIELDS_HELPER();
		try {
			setListMandYN(ListItemUtil.getDropDownListValue(
					 CommonUtils.getConnection(), "PILM105_APAC", "PM_PROD_APPL_FIELDS",
					 "PM_PROD_APPL_FIELDS.PPAF_MAND_YN", "YESNO"));
			setListNMandYN(ListItemUtil.getDropDownListValue(
					 CommonUtils.getConnection(), "PILM105_APAC", "PM_PROD_APPL_FIELDS",
					 "PM_PROD_APPL_FIELDS.PPAF_NMAND_YN", "YESNO"));
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PM_PROD_APPL_FIELDS getPM_PROD_APPL_FIELDS_BEAN() {
		return PM_PROD_APPL_FIELDS_BEAN;
	}

	public void setPM_PROD_APPL_FIELDS_BEAN(
			PM_PROD_APPL_FIELDS PM_PROD_APPL_FIELDS_BEAN) {
		this.PM_PROD_APPL_FIELDS_BEAN = PM_PROD_APPL_FIELDS_BEAN;
	}

	public List<PM_PROD_APPL_FIELDS> getDataList_PM_PROD_APPL_FIELDS() {
		return dataList_PM_PROD_APPL_FIELDS;
	}

	public void setDataListPM_PROD_APPL_FIELDS(
			List<PM_PROD_APPL_FIELDS> dataList_PM_PROD_APPL_FIELDS) {
		this.dataList_PM_PROD_APPL_FIELDS = dataList_PM_PROD_APPL_FIELDS;
	}

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PM_PROD_APPL_FIELDS_BEAN = new PM_PROD_APPL_FIELDS();
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put("addRow",Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}
	}
	
	private void resetSelectedRow() {
		Iterator<PM_PROD_APPL_FIELDS> PM_PROD_APPL_FIELDS_IRT = dataList_PM_PROD_APPL_FIELDS
		.iterator();
		while (PM_PROD_APPL_FIELDS_IRT.hasNext()) {
			PM_PROD_APPL_FIELDS_IRT.next().setRowSelected(false);
		}
	}
	
	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put("current", Messages.getString("messageProperties","errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * @return the compositeAction
	 */
	public PILM105_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction
	 *            the compositeAction to set
	 */
	public void setCompositeAction(PILM105_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the helper
	 */
	public PM_PROD_APPL_FIELDS_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper
	 *            the helper to set
	 */
	public void setHelper(PM_PROD_APPL_FIELDS_HELPER helper) {
		this.helper = helper;
	}

	/**
	 * @return the dataTable
	 */
	public UIData getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable
	 *            the dataTable to set
	 */
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the cOMP_COL_CODE
	 */
	public HtmlInputText getCOMP_COL_CODE() {
		return COMP_COL_CODE;
	}

	/**
	 * @param comp_col_code
	 *            the cOMP_COL_CODE to set
	 */
	public void setCOMP_COL_CODE(HtmlInputText comp_col_code) {
		COMP_COL_CODE = comp_col_code;
	}

	/**
	 * @return the cOMP_COL_CODE_DESC
	 */
	public HtmlInputText getCOMP_COL_CODE_DESC() {
		return COMP_COL_CODE_DESC;
	}

	/**
	 * @param comp_col_code_desc
	 *            the cOMP_COL_CODE_DESC to set
	 */
	public void setCOMP_COL_CODE_DESC(HtmlInputText comp_col_code_desc) {
		COMP_COL_CODE_DESC = comp_col_code_desc;
	}

	/**
	 * @return the cOMP_MAND_YN
	 */
	public HtmlSelectOneMenu getCOMP_MAND_YN() {
		return COMP_MAND_YN;
	}

	/**
	 * @param comp_mand_yn
	 *            the cOMP_MAND_YN to set
	 */
	public void setCOMP_MAND_YN(HtmlSelectOneMenu comp_mand_yn) {
		COMP_MAND_YN = comp_mand_yn;
	}

	

	/**
	 * @return the cOMP_NMAND_YN
	 */
	public HtmlSelectOneMenu getCOMP_NMAND_YN() {
		return COMP_NMAND_YN;
	}

	/**
	 * @param comp_nmand_yn the cOMP_NMAND_YN to set
	 */
	public void setCOMP_NMAND_YN(HtmlSelectOneMenu comp_nmand_yn) {
		COMP_NMAND_YN = comp_nmand_yn;
	}

	/**
	 * @return the cOMP_COL_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_COL_CODE_LABEL() {
		return COMP_COL_CODE_LABEL;
	}

	/**
	 * @param comp_col_code_label
	 *            the cOMP_COL_CODE_LABEL to set
	 */
	public void setCOMP_COL_CODE_LABEL(HtmlOutputLabel comp_col_code_label) {
		COMP_COL_CODE_LABEL = comp_col_code_label;
	}

	/**
	 * @return the cOMP_COL_CODE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_COL_CODE_DESC_LABEL() {
		return COMP_COL_CODE_DESC_LABEL;
	}

	/**
	 * @param comp_col_code_desc_label
	 *            the cOMP_COL_CODE_DESC_LABEL to set
	 */
	public void setCOMP_COL_CODE_DESC_LABEL(
			HtmlOutputLabel comp_col_code_desc_label) {
		COMP_COL_CODE_DESC_LABEL = comp_col_code_desc_label;
	}

	/**
	 * @return the cOMP_MAND_YN_LABEL
	 */
	public HtmlOutputLabel getCOMP_MAND_YN_LABEL() {
		return COMP_MAND_YN_LABEL;
	}

	/**
	 * @param comp_mand_yn_label
	 *            the cOMP_MAND_YN_LABEL to set
	 */
	public void setCOMP_MAND_YN_LABEL(HtmlOutputLabel comp_mand_yn_label) {
		COMP_MAND_YN_LABEL = comp_mand_yn_label;
	}

	/**
	 * @return the cOMP_NMAND_YN_LABEL
	 */
	public HtmlOutputLabel getCOMP_NMAND_YN_LABEL() {
		return COMP_NMAND_YN_LABEL;
	}

	/**
	 * @param comp_nmand_yn_label
	 *            the cOMP_NMAND_YN_LABEL to set
	 */
	public void setCOMP_NMAND_YN_LABEL(HtmlOutputLabel comp_nmand_yn_label) {
		COMP_NMAND_YN_LABEL = comp_nmand_yn_label;
	}

	/**
	 * @param dataList_PM_PROD_APPL_FIELDS
	 *            the dataList_PM_PROD_APPL_FIELDS to set
	 */
	public void setDataList_PM_PROD_APPL_FIELDS(
			List<PM_PROD_APPL_FIELDS> dataList_PM_PROD_APPL_FIELDS) {
		this.dataList_PM_PROD_APPL_FIELDS = dataList_PM_PROD_APPL_FIELDS;
	}


	/**
	 * Instantiates all components in PM_PROD_APPL_FIELDS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_COL_CODE					 = new HtmlInputText();
		COMP_COL_CODE_DESC				 = new HtmlInputText();
		COMP_PROD_CODE = new HtmlInputText();
		COMP_NMAND_YN = new HtmlSelectOneMenu();

		// Instantiating HtmlSelectOneMenu
		COMP_MAND_YN					 = new HtmlSelectOneMenu();

	}

	/**
	 * Resets all components in PM_PROD_APPL_FIELDS_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_COL_CODE.resetValue();
		COMP_COL_CODE_DESC.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_MAND_YN.resetValue();
		COMP_NMAND_YN.resetValue();
		COMP_PROD_CODE.resetValue();

	}

	/**
	 * Disables all components in PM_PROD_APPL_FIELDS_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_COL_CODE.setDisabled(disabled);
		COMP_COL_CODE_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_MAND_YN.setDisabled(disabled);
		COMP_NMAND_YN.setDisabled(disabled);
		COMP_PROD_CODE.setDisabled(disabled);

	}
	
	/**
	 * 
	 * @param facesContext
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
    public void validateCOL_CODE(FacesContext facesContext,
    		UIComponent component, Object value) throws ValidatorException {
    	CommonUtils.clearMaps(this);
    	try {
    		PM_PROD_APPL_FIELDS_BEAN.setPPAF_COL_CODE((String)value);
    		helper.validateCOL_CODE(compositeAction);
    	} catch (Exception exception) {
    		exception.printStackTrace();
    		throw new ValidatorException(new FacesMessage(exception
    				.getMessage()));
    	} 
    }
    
    /**
	 * 
	 * @param facesContext
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
    public void validatePPAF_MAND_YN(FacesContext facesContext,
    		UIComponent component, Object value) throws ValidatorException {
    	CommonUtils.clearMaps(this);
    	try {
    		PM_PROD_APPL_FIELDS_BEAN.setPPAF_MAND_YN((String)value);
    		helper.validatePPAF_MAND_YN(this);
    	} catch (Exception exception) {
    		exception.printStackTrace();
    		throw new ValidatorException(new FacesMessage(exception
    				.getMessage()));
    	} 
    }

	/**
	 * @return the listMandYN
	 */
	public List<SelectItem> getListMandYN() {
		if (listMandYN.size() == 0) {
			listMandYN.clear();
    		try {
    			listMandYN = new ArrayList<SelectItem>();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
		return listMandYN;
	}

	/**
	 * @param listMandYN the listMandYN to set
	 */
	public void setListMandYN(List<SelectItem> listMandYN) {
		this.listMandYN = listMandYN;
	}

	/**
	 * @return the listNMandYN
	 */
	public List<SelectItem> getListNMandYN() {
		if (listNMandYN.size() == 0) {
			listNMandYN.clear();
    		try {
    			listNMandYN = new ArrayList<SelectItem>();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
		return listNMandYN;
	}

	/**
	 * @param listNMandYN the listNMandYN to set
	 */
	public void setListNMandYN(List<SelectItem> listNMandYN) {
		this.listNMandYN = listNMandYN;
	}
	
	/**
	 * 
	 * @param currValue
	 * @return
	 */
    public List<LovBean> lovPPAF_COL_CODE(Object currValue) {
    	ListItemUtil listitemutil = new ListItemUtil();
    	try {
    		suggestionList = listitemutil.P_CALL_LOV("PILM105_APAC",
    				"PM_PROD_APPL_FIELDS", "PPAF_COL_CODE", null, null, null, null,
    				null, (String) currValue);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return suggestionList;
    }
    
    public void onLoad(PhaseEvent event) {
    	//CommonUtils.clearMaps(this);
    	try {
    		if(isFormFlag()){
    			
    		}
    		if(isBlockFlag()){
    			helper.executeSelect(compositeAction);
    			helper.whenNewBlockInstance(compositeAction);
    			
    			List<PM_PROD_APPL_FIELDS> list = compositeAction.getPM_PROD_APPL_FIELDS_ACTION_BEAN().getDataList_PM_PROD_APPL_FIELDS();
        		if(list!=null && !list.isEmpty()){
        			int i = 0;
        			for(PM_PROD_APPL_FIELDS PM_PROD_APPL_FIELDS_BEAN : list){
        				if(i==0){
        					PM_PROD_APPL_FIELDS_BEAN.setRowSelected(true);
        					setPM_PROD_APPL_FIELDS_BEAN(PM_PROD_APPL_FIELDS_BEAN);
        					i=1;
        				}else{
        					PM_PROD_APPL_FIELDS_BEAN.setRowSelected(false);
        				}
        			}
        		}
        		setBlockFlag(false);
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,  e.getMessage());
    		getErrorMap().put("onLoad", e.getMessage());
    	}
    }
    
    public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}
    
    /**
     * 
     * @param event
     */
	public void postRecord(ActionEvent event) {
		try {
			String productCode = (String)COMP_PROD_CODE.getSubmittedValue();
			productCode = productCode ==null ? compositeAction.getPM_PROD_APPL_FIELDS_ACTION_BEAN().getProductCode() : productCode;
			System.out.println("=====>Product Code=====>"+productCode);
			PM_PROD_APPL_FIELDS_BEAN.setPPAF_PROD_CODE(productCode);
			
			if (PM_PROD_APPL_FIELDS_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(PM_PROD_APPL_FIELDS_BEAN);
				new CRUDHandler().executeInsert(PM_PROD_APPL_FIELDS_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insert"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insert"));
				dataList_PM_PROD_APPL_FIELDS.add(PM_PROD_APPL_FIELDS_BEAN);
			} else if (PM_PROD_APPL_FIELDS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PM_PROD_APPL_FIELDS_BEAN);
				new CRUDHandler().executeUpdate(PM_PROD_APPL_FIELDS_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update"));
			}
			PM_PROD_APPL_FIELDS_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}
	
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_PROD_APPL_FIELDS_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
				dataList_PM_PROD_APPL_FIELDS.remove(PM_PROD_APPL_FIELDS_BEAN);
				if (dataList_PM_PROD_APPL_FIELDS.size() > 0) {

					PM_PROD_APPL_FIELDS_BEAN = dataList_PM_PROD_APPL_FIELDS
					.get(0);
				} else if (dataList_PM_PROD_APPL_FIELDS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_PROD_APPL_FIELDS_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put("deleteRow", Messages.getString(
						PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$deletenotallowed"));
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}
	}

	/**
	 * @return the suggestionList
	 */
	public List<LovBean> getSuggestionList() {
		return suggestionList;
	}

	/**
	 * @param suggestionList the suggestionList to set
	 */
	public void setSuggestionList(List<LovBean> suggestionList) {
		this.suggestionList = suggestionList;
	}

	/**
	 * @return the cOMP_PROD_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_CODE_LABEL() {
		return COMP_PROD_CODE_LABEL;
	}

	/**
	 * @param comp_prod_code_label the cOMP_PROD_CODE_LABEL to set
	 */
	public void setCOMP_PROD_CODE_LABEL(HtmlOutputLabel comp_prod_code_label) {
		COMP_PROD_CODE_LABEL = comp_prod_code_label;
	}

	/**
	 * @return the cOMP_PROD_CODE
	 */
	public HtmlInputText getCOMP_PROD_CODE() {
		return COMP_PROD_CODE;
	}

	/**
	 * @param comp_prod_code the cOMP_PROD_CODE to set
	 */
	public void setCOMP_PROD_CODE(HtmlInputText comp_prod_code) {
		COMP_PROD_CODE = comp_prod_code;
	}
	
    public void displayRecords() {
    	CommonUtils.clearMaps(this);
    	try {
    	    resetSelectedRow();
    	    PM_PROD_APPL_FIELDS_BEAN = (PM_PROD_APPL_FIELDS) dataTable
    		    .getRowData();
    	    PM_PROD_APPL_FIELDS_BEAN.setRowSelected(true);
    	    resetAllComponent();
    	} catch (Exception exc) {
    	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
    		    exc.getMessage());
    	    getErrorMap().put("displayRecords", exc.getMessage());
    	}

        }

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * 
	 * @param currValue
	 * @return
	 */
	 public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PROD_CODE(Object currValue) {
	    	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	    	ListItemUtil listitemutil = new ListItemUtil();
	    	try {
	    		suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
	    				"PT_IL_POLICY", "POL_PROD_CODE", null, null, null, null,
	    				null, (String) currValue);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	return suggestionList;
	    }
	 
	 /**
		 * 
		 * @param facesContext
		 * @param component
		 * @param value
		 * @throws ValidatorException
		 */
	    public void validatePOL_PROD_FM(FacesContext facesContext,
	    		UIComponent component, Object value) throws ValidatorException {
	    	CommonUtils.clearMaps(this);
	    	try {
	    		PM_PROD_APPL_FIELDS_BEAN.setPPAF_PROD_CODE((String)value);
	    		
    			helper.validateProductCode(PM_PROD_APPL_FIELDS_BEAN.getPPAF_PROD_CODE());
	    		
	    	} catch (Exception exception) {
	    		exception.printStackTrace();
	    		throw new ValidatorException(new FacesMessage(exception
	    				.getMessage()));
	    	}
	    }
}
