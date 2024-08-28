package com.iii.pel.forms.PILM074_APAC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
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
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_LIFE_TAX_APPL_PROD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_TAP_PROD_CODE_LABEL;

	private HtmlInputText COMP_TAP_PROD_CODE;

	private HtmlOutputLabel COMP_TAP_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_TAP_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_TAP_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_TAP_EFF_FM_DT;

	private HtmlOutputLabel COMP_TAP_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_TAP_EFF_TO_DT;

	private PM_LIFE_TAX_APPL_PROD PM_LIFE_TAX_APPL_PROD_BEAN;
//	private PM_LIFE_TAX_APPL_CUST_ACTION PM_LIFE_TAX_APPL_CUST_ACTION_BEAN;
	PM_LIFE_TAX_APPL_CUST_ACTION applicableAction = new PM_LIFE_TAX_APPL_CUST_ACTION();
	
	/** Following Variables are added for functionality */
	private UIData prodDataTable;
	private ArrayList<PM_LIFE_TAX_APPL_PROD> taxApplProd ;
	
	private ArrayList<PM_LIFE_TAX_APPL_PROD> productCodeLov;
	
	private String filterByTAP_PROD_CODE;
	private String filterByTAP_PROD_CODE_DESC;
	
	private int prevRowIndex;
	private int currPage;
	private int lastUpdatedRowIndex;
	private int recordsPerPage = 5;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	/** Following Variables are added for functionality */
	
	public ArrayList<PM_LIFE_TAX_APPL_PROD> getTaxApplProd() {
		return taxApplProd;
	}

	public void setTaxApplProd(ArrayList<PM_LIFE_TAX_APPL_PROD> taxApplProd) {
		this.taxApplProd = taxApplProd;
	}

	public UIData getProdDataTable() {
		return prodDataTable;
	}

	public void setProdDataTable(UIData prodDataTable) {
		this.prodDataTable = prodDataTable;
	}

	public PM_LIFE_TAX_APPL_PROD_ACTION() {
		PM_LIFE_TAX_APPL_PROD_BEAN = new PM_LIFE_TAX_APPL_PROD();
	}

	public HtmlOutputLabel getCOMP_TAP_PROD_CODE_LABEL() {
		return COMP_TAP_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TAP_PROD_CODE() {
		return COMP_TAP_PROD_CODE;
	}

	public void setCOMP_TAP_PROD_CODE_LABEL(HtmlOutputLabel COMP_TAP_PROD_CODE_LABEL) {
		this.COMP_TAP_PROD_CODE_LABEL = COMP_TAP_PROD_CODE_LABEL;
	}

	public void setCOMP_TAP_PROD_CODE(HtmlInputText COMP_TAP_PROD_CODE) {
		this.COMP_TAP_PROD_CODE = COMP_TAP_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_TAP_PROD_CODE_DESC_LABEL() {
		return COMP_TAP_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_TAP_PROD_CODE_DESC() {
		return COMP_TAP_PROD_CODE_DESC;
	}

	public void setCOMP_TAP_PROD_CODE_DESC_LABEL(HtmlOutputLabel COMP_TAP_PROD_CODE_DESC_LABEL) {
		this.COMP_TAP_PROD_CODE_DESC_LABEL = COMP_TAP_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_TAP_PROD_CODE_DESC(HtmlInputText COMP_TAP_PROD_CODE_DESC) {
		this.COMP_TAP_PROD_CODE_DESC = COMP_TAP_PROD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_TAP_EFF_FM_DT_LABEL() {
		return COMP_TAP_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TAP_EFF_FM_DT() {
		return COMP_TAP_EFF_FM_DT;
	}

	public void setCOMP_TAP_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_TAP_EFF_FM_DT_LABEL) {
		this.COMP_TAP_EFF_FM_DT_LABEL = COMP_TAP_EFF_FM_DT_LABEL;
	}

	public void setCOMP_TAP_EFF_FM_DT(HtmlCalendar COMP_TAP_EFF_FM_DT) {
		this.COMP_TAP_EFF_FM_DT = COMP_TAP_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_TAP_EFF_TO_DT_LABEL() {
		return COMP_TAP_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TAP_EFF_TO_DT() {
		return COMP_TAP_EFF_TO_DT;
	}

	public void setCOMP_TAP_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_TAP_EFF_TO_DT_LABEL) {
		this.COMP_TAP_EFF_TO_DT_LABEL = COMP_TAP_EFF_TO_DT_LABEL;
	}

	public void setCOMP_TAP_EFF_TO_DT(HtmlCalendar COMP_TAP_EFF_TO_DT) {
		this.COMP_TAP_EFF_TO_DT = COMP_TAP_EFF_TO_DT;
	}

	public PM_LIFE_TAX_APPL_PROD getPM_LIFE_TAX_APPL_PROD_BEAN() {
		return PM_LIFE_TAX_APPL_PROD_BEAN;
	}

	public void setPM_LIFE_TAX_APPL_PROD_BEAN(PM_LIFE_TAX_APPL_PROD PM_LIFE_TAX_APPL_PROD_BEAN) {
		this.PM_LIFE_TAX_APPL_PROD_BEAN = PM_LIFE_TAX_APPL_PROD_BEAN;
	}
	
	public ArrayList<PM_LIFE_TAX_APPL_PROD> getProductCodeLov() {
		return productCodeLov;
	}

	public void setProductCodeLov(ArrayList<PM_LIFE_TAX_APPL_PROD> productCodeLov) {
		this.productCodeLov = productCodeLov;
	}
	
	
/*	public PM_LIFE_TAX_APPL_CUST_ACTION getPM_LIFE_TAX_APPL_CUST_ACTION_BEAN() {
		return PM_LIFE_TAX_APPL_CUST_ACTION_BEAN;
	}

	public void setPM_LIFE_TAX_APPL_CUST_ACTION_BEAN(
			PM_LIFE_TAX_APPL_CUST_ACTION pM_LIFE_TAX_APPL_CUST_ACTION_BEAN) {
		PM_LIFE_TAX_APPL_CUST_ACTION_BEAN = pM_LIFE_TAX_APPL_CUST_ACTION_BEAN;
	}*/

	public void addNew(ActionEvent ae){
		CommonUtils.clearMaps(this);
		int rowCount = 0;
		if(taxApplProd == null){
			taxApplProd = new ArrayList<PM_LIFE_TAX_APPL_PROD>();
		}
		getWarningMap().clear();
		PILM074_APAC_COMPOSITE_ACTION compositeAction = (PILM074_APAC_COMPOSITE_ACTION) CommonUtils.getGlobalObject("PILM074_APAC_COMPOSITE_ACTION");
		PM_LIFE_TAX_HEADER hdrBean = compositeAction.getPM_LIFE_TAX_HEADER_ACTION_BEAN().getPM_LIFE_TAX_HEADER_BEAN();
		
		PM_LIFE_TAX_APPL_PROD dBean = new PM_LIFE_TAX_APPL_PROD();
		dBean.setTAP_TH_TAX_TYPE(hdrBean.getTH_TAX_TYPE());
		
		taxApplProd.add(dBean);
		rowCount = getProdDataTable().getRowCount();
		currPage = rowCount/recordsPerPage;
		if(rowCount%recordsPerPage>0){
			currPage++;
		}
	}
	
	public String deleteRow() {
		getWarningMap().clear();
		PM_LIFE_TAX_APPL_PROD bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (taxApplProd != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < taxApplProd.size();) {
				bean = taxApplProd.get(index);
				if (bean.isCheckBoxValue()) {
					taxApplProd.remove(bean);
					deletedRecordIndex = new PILM074_APAC_DELEGATE().deleteLifeTaxProduct(bean);
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
		int rowIndex = getProdDataTable().getRowIndex();
		getTaxApplProd().get(rowIndex).setCheckBoxValue(checkBoxValue);
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
	
	public String  lastColumnListener(){
		int currRowIndex = getProdDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_LIFE_TAX_APPL_PROD gridValueBean = null;
		String message = null;
		PILM074_APAC_HELPER helper = new PILM074_APAC_HELPER();
		try {
			if (currRowIndex >= 0) {
				gridValueBean = taxApplProd.get(currRowIndex);
				if(gridValueBean.getROWID()== null){
					message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert");
					helper.pre_insert_product(gridValueBean);
				}else{
					message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update");
					helper.pre_update_product(gridValueBean);
				}
				rowUpdated = new PILM074_APAC_DELEGATE().updateLifeTaxProductDetails(gridValueBean);
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
	
	public String saveGridData(){
		try {		
			/*ResultSet excessRS = new CRUDHandler().executeSelectStatement("SELECT TAP_RIDER_FM FROM PM_LIFE_TAX_APPL_PROD WHERE TAP_PROD_CODE = ? and TAP_RIDER_FM = ?", 
			CommonUtils.getConnection(),new Object[]{PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_PROD_CODE(),PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_RIDER_FM()});
			String tap_rider =null;
			if(excessRS.next()){
				tap_rider = excessRS.getString("TAP_RIDER_FM");				
			}
			if(tap_rider!=null){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "Cover Already Available for this Product"));
//				getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "Cover Already Available for this Product"));
			}else{	*/			
				CommonUtils.getConnection().commit();
				getWarningMap().put("current",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
//				new CommonUtils().doComitt();
			/*}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void checkBoxValidation(ActionEvent event){	}

	public void onPageLoad() {
		PILM074_APAC_COMPOSITE_ACTION compositeAction = (PILM074_APAC_COMPOSITE_ACTION) CommonUtils.getGlobalObject("PILM074_APAC_COMPOSITE_ACTION");
		String taxType = compositeAction.getPM_LIFE_TAX_HEADER_ACTION_BEAN().getPM_LIFE_TAX_HEADER_BEAN().getTH_TAX_TYPE();
		PILM074_APAC_DELEGATE delegate = new PILM074_APAC_DELEGATE();
		getErrorMap().clear();
		getWarningMap().clear();
		taxApplProd = delegate.fetchLifeTaxProduct(taxType);
		for (PM_LIFE_TAX_APPL_PROD tempBean : taxApplProd) {
			new PILM074_APAC_HELPER().POST_QUERY_TRIGGER_PRODUCT(tempBean);
		}
		compositeAction.getPM_LIFE_TAX_APPL_PROD_ACTION_BEAN().setTaxApplProd(taxApplProd);
		if (taxApplProd.size() !=0){					
			compositeAction.getPM_LIFE_TAX_APPL_PROD_ACTION_BEAN().setPM_LIFE_TAX_APPL_PROD_BEAN(taxApplProd.get(0));
			compositeAction.getPM_LIFE_TAX_APPL_PROD_ACTION_BEAN().getPM_LIFE_TAX_APPL_PROD_BEAN().setRowSelected(true);
		}
		applicableAction.onPageLoad();
	}
	
	public ArrayList<PM_LIFE_TAX_APPL_PROD> lovForProductCode(Object event) {
		String productCode = (String) event;
		productCodeLov = new PILM074_APAC_DELEGATE().prepareProductCodeLov(productCode, productCodeLov);
		return productCodeLov;
	}

	public void getProductCodeDesc(ActionEvent event) {
		Iterator<PM_LIFE_TAX_APPL_PROD> iterator = null;
		int rowIndex = getProdDataTable().getRowIndex();
		PM_LIFE_TAX_APPL_PROD bean = null;
		boolean keepLooking = true;
		String productCode = null;
		PM_LIFE_TAX_APPL_PROD productBean = taxApplProd.get(rowIndex);
		UIInput inputtext = (UIInput) event.getComponent().getParent().getParent();
		System.out.println(inputtext.getSubmittedValue());
		productCode = (String) inputtext.getSubmittedValue();
		if (productCode != null && !productCode.trim().isEmpty()) {
			if (productCodeLov != null) {
				iterator = productCodeLov.iterator();
				while (iterator.hasNext() && keepLooking) {
					bean = iterator.next();
					if (bean.getTAP_PROD_CODE().equalsIgnoreCase(productCode)) {
						productBean.setTAP_PROD_CODE(bean.getTAP_PROD_CODE());
						productBean.setTAP_PROD_CODE_DESC(bean.getTAP_PROD_CODE_DESC());
						keepLooking = false;
					}
				}
			}
		}
	}
	
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009 
	/*public void gridtabListener() {
		int currRowIndex = getProdDataTable().getRowIndex();
		PM_LIFE_TAX_APPL_PROD detailsBean = null;
		PILM074_APAC_HELPER helper = new PILM074_APAC_HELPER();
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != 0) {
						if (currRowIndex != prevRowIndex) {
							detailsBean = new PM_LIFE_TAX_APPL_PROD();
							detailsBean = taxApplProd.get(prevRowIndex);
							if (detailsBean.getROWID() == null) {
								helper.pre_insert_product(detailsBean);
							} else {
								helper.pre_update_product(detailsBean);
							}
							new PILM074_APAC_DELEGATE().updateLifeTaxProductDetails(detailsBean);
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
	
	public void validateTAP_PROD_CODE(FacesContext context,
			UIComponent component, Object value) throws SQLException, Exception {
//		int rowIndex = getProdDataTable().getRowIndex();
//		PM_LIFE_TAX_APPL_PROD bean = taxApplProd.get(rowIndex);
		getPM_LIFE_TAX_APPL_PROD_BEAN().setTAP_PROD_CODE((String)value);
		if (value != null) {
			String TAP_PROD_CODE_DESC = new PILM074_APAC_HELPER().whenValidate_TAP_PROD_CODE(this,value);
			getPM_LIFE_TAX_APPL_PROD_BEAN().setTAP_PROD_CODE_DESC(TAP_PROD_CODE_DESC);
		}
		System.out.println("<<<<<<<<<<>>>>>>>>>>>" + getPM_LIFE_TAX_APPL_PROD_BEAN().getTAP_PROD_CODE());
	}
	
	public void TAP_PROD_CODE_ACTION(ActionEvent event){
		CommonUtils.clearMaps(this);
		String productCode  = getCurrentValue(event);
		int rowIndex = getProdDataTable().getRowIndex();
		taxApplProd.get(rowIndex).setTAP_PROD_CODE(productCode);
		
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009 
		//gridtabListener();
	}
	
	public void validateTAP_EFF_FM_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		UIInput inputText = (UIInput) component;
		Date effFromDate = this.getCOMP_TAP_EFF_FM_DT().getAsDate(inputText.getSubmittedValue());
		int rowIndex = getProdDataTable().getRowIndex();
		if(rowIndex >= 0)
		{
			taxApplProd.get(rowIndex).setTAP_EFF_FM_DT(effFromDate);
			Date effToDate = taxApplProd.get(rowIndex).getTAP_EFF_TO_DT();
			new PILM074_APAC_HELPER().whenValidate_TAP_EFF_FM_DT(this,effFromDate, effToDate);
		}
		
	}
	
	public void TAP_EFF_FM_DT_ACTION(ActionEvent event){
		CommonUtils.clearMaps(this);
		UIInput inputText = (UIInput) event.getComponent().getParent();
		Date effFromDate = this.getCOMP_TAP_EFF_FM_DT().getAsDate(inputText.getSubmittedValue());
		int rowIndex = getProdDataTable().getRowIndex();
		if(rowIndex >= 0)
		{
			taxApplProd.get(rowIndex).setTAP_EFF_FM_DT(effFromDate);
			Date effToDate = taxApplProd.get(rowIndex).getTAP_EFF_TO_DT();
			new PILM074_APAC_HELPER().whenValidate_TAP_EFF_FM_DT(this,effFromDate, effToDate);
			// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009 
			//gridtabListener();
		}
		ErrorHelpUtil.validate(inputText, getErrorMap());
	}
	
	public void validateTAP_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value) throws SQLException, Exception {
		UIInput inputText = (UIInput) component;
		Date effToDate = this.getCOMP_TAP_EFF_TO_DT().getAsDate(inputText.getSubmittedValue());
		int rowIndex = getProdDataTable().getRowIndex();
		if(rowIndex >= 0)
		{
			taxApplProd.get(rowIndex).setTAP_EFF_TO_DT(effToDate);
			Date effFromDate = taxApplProd.get(rowIndex).getTAP_EFF_FM_DT();
			new PILM074_APAC_HELPER().whenValidate_TAP_EFF_TO_DT(this,effFromDate, effToDate);
		}
	}
	
	public void TAP_EFF_TO_DT_ACTION(ActionEvent event){
		CommonUtils.clearMaps(this);
		UIInput inputText = (UIInput) event.getComponent().getParent();
		Date effToDate = this.getCOMP_TAP_EFF_TO_DT().getAsDate(inputText.getSubmittedValue());
		int rowIndex = getProdDataTable().getRowIndex();
		if(rowIndex >= 0)
		{
			taxApplProd.get(rowIndex).setTAP_EFF_TO_DT(effToDate);
			Date effFromDate = taxApplProd.get(rowIndex).getTAP_EFF_FM_DT();
			new PILM074_APAC_HELPER().whenValidate_TAP_EFF_TO_DT(this,effFromDate, effToDate);
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
		int rowIndex = prodDataTable.getRowIndex();

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
			if (taxApplProd.size() != 0) {				
				PM_LIFE_TAX_APPL_PROD_BEAN = (PM_LIFE_TAX_APPL_PROD) prodDataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_LIFE_TAX_APPL_PROD_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void resetSelectedRow() {
			Iterator<PM_LIFE_TAX_APPL_PROD> iterator = taxApplProd.iterator();
			while (iterator.hasNext()) {
				iterator.next().setRowSelected(false);
			}
			/*applicableAction.resetSelectedRow();*/
	}

	private void resetAllComponent() {
		// TODO Auto-generated method stub
		COMP_TAP_PROD_CODE.resetValue();
		COMP_TAP_PROD_CODE_DESC.resetValue();
		COMP_TAP_EFF_FM_DT.resetValue();
		COMP_TAP_EFF_TO_DT.resetValue();
		//Added by kavitha on 05.10.2019 for orient
		COMP_TAP_PROD_CODE_TO.resetValue();
		COMP_TAP_PROD_CODE_TO_DESC.resetValue();
		COMP_TAP_RIDER_FM.resetValue();
		COMP_TAP_RIDER_TO.resetValue();
		/*applicableAction.resetAllComponent();*/
//		added by senthilnathan on 14.10.2019 for orient suggested by girish
		COMP_TAP_CUST_CLASS.resetValue();
		COMP_TAP_CUST_CLASS_DESC.resetValue();
		COMP_TAP_CUST_CLASS_TO.resetValue();
		COMP_TAP_CUST_CLASS_TO_DESC.resetValue();
		
		
	}

	public String getFilterByTAP_PROD_CODE() {
		return filterByTAP_PROD_CODE;
	}

	public void setFilterByTAP_PROD_CODE(String filterByTAP_PROD_CODE) {
		this.filterByTAP_PROD_CODE = filterByTAP_PROD_CODE;
	}

	public String getFilterByTAP_PROD_CODE_DESC() {
		return filterByTAP_PROD_CODE_DESC;
	}

	public void setFilterByTAP_PROD_CODE_DESC(String filterByTAP_PROD_CODE_DESC) {
		this.filterByTAP_PROD_CODE_DESC = filterByTAP_PROD_CODE_DESC;
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
				PM_LIFE_TAX_APPL_PROD_BEAN = new PM_LIFE_TAX_APPL_PROD();
				resetAllComponent();
				resetSelectedRow();
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
				if(PM_LIFE_TAX_APPL_PROD_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PM_LIFE_TAX_APPL_PROD_BEAN, CommonUtils.getConnection());
					taxApplProd.remove(PM_LIFE_TAX_APPL_PROD_BEAN);
				}
				
				if(taxApplProd.size() > 0) {
					setPM_LIFE_TAX_APPL_PROD_BEAN(taxApplProd.get(0));
					PM_LIFE_TAX_APPL_PROD_BEAN.setRowSelected(true);
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
			
			if(PM_LIFE_TAX_APPL_PROD_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					ResultSet excessRS = new CRUDHandler().executeSelectStatement("SELECT TAP_RIDER_FM FROM PM_LIFE_TAX_APPL_PROD WHERE TAP_PROD_CODE = ? and TAP_PROD_CODE_TO = ? and TAP_RIDER_FM = ?"
							+ " and TAP_RIDER_TO = ? and TAP_CHANNEL_FM = ? and TAP_CHANNEL_TO = ?", 
							CommonUtils.getConnection(),new Object[]{PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_PROD_CODE(),PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_PROD_CODE_TO(),PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_RIDER_FM(),
								PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_RIDER_TO(),PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_CHANNEL_FM(),PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_CHANNEL_TO()});
							String tap_rider =null;
							if(excessRS.next()){
								tap_rider = excessRS.getString("TAP_RIDER_FM");				
							}
							if(tap_rider!=null){
								getErrorMap().clear();
								getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
								getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
							}else{	

					helper.pre_update_product(PM_LIFE_TAX_APPL_PROD_BEAN);
					new CRUDHandler().executeInsert(PM_LIFE_TAX_APPL_PROD_BEAN, CommonUtils.getConnection());
//					applicableAction.post(ae);	
					/*getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));*/
					saveGridData();
							}
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			} else {

				if(isINSERT_ALLOWED()) {
					ResultSet excessRS = new CRUDHandler().executeSelectStatement("SELECT TAP_RIDER_FM FROM PM_LIFE_TAX_APPL_PROD WHERE TAP_PROD_CODE = ? and TAP_PROD_CODE_TO = ? and TAP_RIDER_FM = ?"
							+ " and TAP_RIDER_TO = ? and TAP_CHANNEL_FM = ? and TAP_CHANNEL_TO = ?", 
							CommonUtils.getConnection(),new Object[]{PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_PROD_CODE(),PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_PROD_CODE_TO(),PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_RIDER_FM(),
								PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_RIDER_TO(),PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_CHANNEL_FM(),PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_CHANNEL_TO()});
							String tap_rider =null;
							if(excessRS.next()){
								tap_rider = excessRS.getString("TAP_RIDER_FM");				
							}
							if(tap_rider!=null){
								getErrorMap().clear();
								getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
								getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
							}else{
					helper.pre_insert_product(PM_LIFE_TAX_APPL_PROD_BEAN);
					new CRUDHandler().executeInsert(PM_LIFE_TAX_APPL_PROD_BEAN, CommonUtils.getConnection());	
					/*applicableAction.post(ae);*/
					/*PILM074_APAC_COMPOSITE_ACTION compositeAction = (PILM074_APAC_COMPOSITE_ACTION) CommonUtils.getGlobalObject("PILM074_APAC_COMPOSITE_ACTION");
					compositeAction.getPM_LIFE_TAX_APPL_CUST_ACTION_BEAN().post(null);*/
					
					/*getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));*/
					taxApplProd.add(PM_LIFE_TAX_APPL_PROD_BEAN);
					saveGridData();
							}
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_LIFE_TAX_APPL_PROD_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	//Added by kavitha on 04.10.2019 for orient
	
	private HtmlOutputLabel COMP_TAP_PROD_CODE_TO_LABEL;
	private HtmlInputText COMP_TAP_PROD_CODE_TO;
	private HtmlInputText COMP_TAP_PROD_CODE_TO_DESC;
	private HtmlOutputLabel COMP_TAP_RIDER_FM_LABEL;
	private HtmlOutputLabel COMP_TAP_RIDER_TO_LABEL;
	private HtmlInputText COMP_TAP_RIDER_FM;
	private HtmlInputText COMP_TAP_RIDER_TO;
	private HtmlInputText COMP_TAP_RIDER_FM_DESC;
	private HtmlInputText COMP_TAP_RIDER_TO_DESC;
	private String filterByTAP_RIDER_FM_DESC;
	
	public void validateTAP_PROD_CODE_TO(FacesContext context,
			UIComponent component, Object value) throws SQLException, Exception {
		try{
			getPM_LIFE_TAX_APPL_PROD_BEAN().setTAP_PROD_CODE_TO((String) value);
			if (value != null) {
				String TAP_PROD_CODE_DESC = new PILM074_APAC_HELPER().whenValidate_TAP_PROD_CODE(this,value);
				getPM_LIFE_TAX_APPL_PROD_BEAN().setTAP_PROD_CODE_TO_DESC(TAP_PROD_CODE_DESC);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}	
	}
	
	public void validateTAP_RIDER_FM(FacesContext context,
			UIComponent component, Object value) throws SQLException, Exception {
		try{
		getPM_LIFE_TAX_APPL_PROD_BEAN().setTAP_RIDER_FM((String) value);
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	public void validateTAP_RIDER_TO(FacesContext context,
			UIComponent component, Object value) throws SQLException, Exception {
		try{
		getPM_LIFE_TAX_APPL_PROD_BEAN().setTAP_RIDER_TO((String) value);
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {

		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	
	/* public ArrayList<LovBean> lovTAP_RIDER(Object object) {
		 ArrayList<LovBean> suggestionList = null;
	    	String query1 = "SELECT COVER_CODE,COVER_DESC FROM PM_IL_COVER WHERE COVER_FRZ_FLAG='N' AND COVER_TYPE = 'A' "
					+ " AND  (UPPER(COVER_CODE) LIKE UPPER(?) OR UPPER(COVER_DESC) LIKE UPPER(?) ) AND ROWNUM < ? ORDER BY 1";
			
	
			try {
				String currentValue = (String) object;
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
	
				suggestionList = ListItemUtil.prepareSuggestionList(query1,
						new Object[] { currentValue, currentValue,
						PELConstants.suggetionRecordSize });
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return suggestionList;
	    }*/
	 
	
	public HtmlOutputLabel getCOMP_TAP_PROD_CODE_TO_LABEL() {
		return COMP_TAP_PROD_CODE_TO_LABEL;
	}

	public void setCOMP_TAP_PROD_CODE_TO_LABEL(
			HtmlOutputLabel cOMP_TAP_PROD_CODE_TO_LABEL) {
		COMP_TAP_PROD_CODE_TO_LABEL = cOMP_TAP_PROD_CODE_TO_LABEL;
	}


	public HtmlInputText getCOMP_TAP_PROD_CODE_TO() {
		return COMP_TAP_PROD_CODE_TO;
	}

	public void setCOMP_TAP_PROD_CODE_TO(HtmlInputText cOMP_TAP_PROD_CODE_TO) {
		COMP_TAP_PROD_CODE_TO = cOMP_TAP_PROD_CODE_TO;
	}


	public HtmlInputText getCOMP_TAP_PROD_CODE_TO_DESC() {
		return COMP_TAP_PROD_CODE_TO_DESC;
	}

	public void setCOMP_TAP_PROD_CODE_TO_DESC(HtmlInputText cOMP_TAP_PROD_CODE_TO_DESC) {
		COMP_TAP_PROD_CODE_TO_DESC = cOMP_TAP_PROD_CODE_TO_DESC;
	}

	public HtmlOutputLabel getCOMP_TAP_RIDER_FM_LABEL() {
		return COMP_TAP_RIDER_FM_LABEL;
	}

	public void setCOMP_TAP_RIDER_FM_LABEL(HtmlOutputLabel cOMP_TAP_RIDER_FM_LABEL) {
		COMP_TAP_RIDER_FM_LABEL = cOMP_TAP_RIDER_FM_LABEL;
	}

	public HtmlOutputLabel getCOMP_TAP_RIDER_TO_LABEL() {
		return COMP_TAP_RIDER_TO_LABEL;
	}

	public void setCOMP_TAP_RIDER_TO_LABEL(HtmlOutputLabel cOMP_TAP_RIDER_TO_LABEL) {
		COMP_TAP_RIDER_TO_LABEL = cOMP_TAP_RIDER_TO_LABEL;
	}

	public HtmlInputText getCOMP_TAP_RIDER_FM() {
		return COMP_TAP_RIDER_FM;
	}

	public void setCOMP_TAP_RIDER_FM(HtmlInputText cOMP_TAP_RIDER_FM) {
		COMP_TAP_RIDER_FM = cOMP_TAP_RIDER_FM;
	}

	public HtmlInputText getCOMP_TAP_RIDER_TO() {
		return COMP_TAP_RIDER_TO;
	}

	public void setCOMP_TAP_RIDER_TO(HtmlInputText cOMP_TAP_RIDER_TO) {
		COMP_TAP_RIDER_TO = cOMP_TAP_RIDER_TO;
	}

	public HtmlInputText getCOMP_TAP_RIDER_FM_DESC() {
		return COMP_TAP_RIDER_FM_DESC;
	}

	public void setCOMP_TAP_RIDER_FM_DESC(HtmlInputText cOMP_TAP_RIDER_FM_DESC) {
		COMP_TAP_RIDER_FM_DESC = cOMP_TAP_RIDER_FM_DESC;
	}

	public HtmlInputText getCOMP_TAP_RIDER_TO_DESC() {
		return COMP_TAP_RIDER_TO_DESC;
	}

	public void setCOMP_TAP_RIDER_TO_DESC(HtmlInputText cOMP_TAP_RIDER_TO_DESC) {
		COMP_TAP_RIDER_TO_DESC = cOMP_TAP_RIDER_TO_DESC;
	}

	public String getFilterByTAP_RIDER_FM_DESC() {
		return filterByTAP_RIDER_FM_DESC;
	}

	public void setFilterByTAP_RIDER_FM_DESC(String filterByTAP_RIDER_FM_DESC) {
		this.filterByTAP_RIDER_FM_DESC = filterByTAP_RIDER_FM_DESC;
	}
	/*Added  by senthilnathan for Orient Suggested by girish*/
	
	private HtmlOutputLabel COMP_TAP_CUST_CLASS_TO_LABEL;
	private HtmlInputText COMP_TAP_CUST_CLASS_TO;
	private HtmlInputText COMP_TAP_CUST_CLASS_TO_DESC;	
	
	private HtmlOutputLabel COMP_TAP_CUST_CLASS_LABEL;
	private HtmlInputText COMP_TAP_CUST_CLASS;
	private HtmlInputText COMP_TAP_CUST_CLASS_DESC;	
	private String filterByTAP_CHANNEL_FM;
	private String filterByTAP_CHANNEL_TO;
	private String filterByTAP_PROD_CODE_TO_DESC;
	private String filterByTAP_RIDER_FM;
	private String filterByTAP_RIDER_TO;
	
	
	
	public String getFilterByTAP_RIDER_FM() {
		return filterByTAP_RIDER_FM;
	}

	public void setFilterByTAP_RIDER_FM(String filterByTAP_RIDER_FM) {
		this.filterByTAP_RIDER_FM = filterByTAP_RIDER_FM;
	}

	public String getFilterByTAP_RIDER_TO() {
		return filterByTAP_RIDER_TO;
	}

	public void setFilterByTAP_RIDER_TO(String filterByTAP_RIDER_TO) {
		this.filterByTAP_RIDER_TO = filterByTAP_RIDER_TO;
	}

	public String getFilterByTAP_PROD_CODE_TO_DESC() {
		return filterByTAP_PROD_CODE_TO_DESC;
	}

	public void setFilterByTAP_PROD_CODE_TO_DESC(
			String filterByTAP_PROD_CODE_TO_DESC) {
		this.filterByTAP_PROD_CODE_TO_DESC = filterByTAP_PROD_CODE_TO_DESC;
	}

	public String getFilterByTAP_CHANNEL_TO() {
		return filterByTAP_CHANNEL_TO;
	}

	public void setFilterByTAP_CHANNEL_TO(String filterByTAP_CHANNEL_TO) {
		this.filterByTAP_CHANNEL_TO = filterByTAP_CHANNEL_TO;
	}

	public String getFilterByTAP_CHANNEL_FM() {
		return filterByTAP_CHANNEL_FM;
	}

	public void setFilterByTAP_CHANNEL_FM(String filterByTAP_CHANNEL_FM) {
		this.filterByTAP_CHANNEL_FM = filterByTAP_CHANNEL_FM;
	}

	public HtmlOutputLabel getCOMP_TAP_CUST_CLASS_TO_LABEL() {
		return COMP_TAP_CUST_CLASS_TO_LABEL;
	}

	public void setCOMP_TAP_CUST_CLASS_TO_LABEL(
			HtmlOutputLabel cOMP_TAP_CUST_CLASS_TO_LABEL) {
		COMP_TAP_CUST_CLASS_TO_LABEL = cOMP_TAP_CUST_CLASS_TO_LABEL;
	}

	public HtmlInputText getCOMP_TAP_CUST_CLASS_TO() {
		return COMP_TAP_CUST_CLASS_TO;
	}

	public void setCOMP_TAP_CUST_CLASS_TO(HtmlInputText cOMP_TAP_CUST_CLASS_TO) {
		COMP_TAP_CUST_CLASS_TO = cOMP_TAP_CUST_CLASS_TO;
	}

	public HtmlInputText getCOMP_TAP_CUST_CLASS_TO_DESC() {
		return COMP_TAP_CUST_CLASS_TO_DESC;
	}

	public void setCOMP_TAP_CUST_CLASS_TO_DESC(
			HtmlInputText cOMP_TAP_CUST_CLASS_TO_DESC) {
		COMP_TAP_CUST_CLASS_TO_DESC = cOMP_TAP_CUST_CLASS_TO_DESC;
	}

	public HtmlOutputLabel getCOMP_TAP_CUST_CLASS_LABEL() {
		return COMP_TAP_CUST_CLASS_LABEL;
	}

	public void setCOMP_TAP_CUST_CLASS_LABEL(
			HtmlOutputLabel cOMP_TAP_CUST_CLASS_LABEL) {
		COMP_TAP_CUST_CLASS_LABEL = cOMP_TAP_CUST_CLASS_LABEL;
	}

	public HtmlInputText getCOMP_TAP_CUST_CLASS() {
		return COMP_TAP_CUST_CLASS;
	}

	public void setCOMP_TAP_CUST_CLASS(HtmlInputText cOMP_TAP_CUST_CLASS) {
		COMP_TAP_CUST_CLASS = cOMP_TAP_CUST_CLASS;
	}	
	
	public HtmlInputText getCOMP_TAP_CUST_CLASS_DESC() {
		return COMP_TAP_CUST_CLASS_DESC;
	}

	public void setCOMP_TAP_CUST_CLASS_DESC(HtmlInputText cOMP_TAP_CUST_CLASS_DESC) {
		COMP_TAP_CUST_CLASS_DESC = cOMP_TAP_CUST_CLASS_DESC;
	}

	private ArrayList<PM_LIFE_TAX_APPL_PROD> custCodeLov;
	
	public ArrayList<PM_LIFE_TAX_APPL_PROD> lovForCustCode(Object event) {
		String custCode = (String) event;
		custCodeLov = new PILM074_APAC_DELEGATE().prepareChanCodeLov(custCode, custCodeLov);
		return custCodeLov;
	}
	
	public void validateTAP_CHANNEL_FM(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try{
		if (value != null) {
			
			String TAC_CUST_CLASS_DESC = new PILM074_APAC_HELPER().whenValidate_TAP_CUST_CLASS(this,value);
			getPM_LIFE_TAX_APPL_PROD_BEAN().setTAP_CHANNEL_FM_DESC(TAC_CUST_CLASS_DESC);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateTAP_CHANNEL_TO(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try{
		if (value != null) {
			String TAC_CUST_CLASS_DESC = new PILM074_APAC_HELPER().whenValidate_TAP_CUST_CLASS(this,value);
			getPM_LIFE_TAX_APPL_PROD_BEAN().setTAP_CHANNEL_TO_DESC(TAC_CUST_CLASS_DESC);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	/*end*/
	
	public ArrayList<LovBean> lovTAP_RIDER(Object object) {
		 ArrayList<LovBean> suggestionList = null;
		 /*Added Cover Code by senthilnathan suggested by Girish*/
	    	/*String query1 = "SELECT COVER_CODE,COVER_DESC FROM PM_IL_COVER WHERE COVER_FRZ_FLAG='N' AND COVER_TYPE = 'A' "
					+ " AND  (UPPER(COVER_CODE) LIKE UPPER(?) OR UPPER(COVER_DESC) LIKE UPPER(?) ) AND COVER_CODE BETWEEN ? AND ? AND ROWNUM < ? ORDER BY 1";*/
	    	
	    String query1 = "SELECT distinct PAC_COVER_CODE,COVER_DESC FROM PM_IL_COVER,PM_IL_PROD_APPL_COVER WHERE COVER_CODE = PAC_COVER_CODE AND "
	    		+ "PAC_PROD_CODE BETWEEN ? AND ? AND (UPPER(COVER_CODE) LIKE UPPER(?) OR UPPER(COVER_DESC) LIKE UPPER(?)) AND ROWNUM < ? ORDER BY 1";
	
			try {
				
				String currentValue = (String) object;
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
	
				suggestionList = ListItemUtil.prepareSuggestionList(query1,
						new Object[] { PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_PROD_CODE(),
						PM_LIFE_TAX_APPL_PROD_BEAN.getTAP_PROD_CODE_TO(),currentValue, currentValue,PELConstants.suggetionRecordSize });
				System.out.println(query1);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return suggestionList;
	    }

    
}
