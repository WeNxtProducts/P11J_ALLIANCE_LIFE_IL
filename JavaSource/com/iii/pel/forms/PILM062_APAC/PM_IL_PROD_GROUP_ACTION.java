package com.iii.pel.forms.PILM062_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlDatascroller;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;


public class PM_IL_PROD_GROUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PG_CODE_LABEL;

	private HtmlInputText COMP_PG_CODE;

	private HtmlOutputLabel COMP_PG_CODE_DESC_LABEL;

	private HtmlInputText COMP_PG_CODE_DESC;

	private HtmlOutputLabel COMP_PG_PROD_CODE_LABEL;

	private HtmlInputText COMP_PG_PROD_CODE;

	private HtmlOutputLabel COMP_PG_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_PG_PROD_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_ADD_ROW;

	private HtmlCommandButton COMP_UI_M_BUT_DELETE_ROW;

	private List<PM_IL_PROD_GROUP> groupCodeList;
	
	private List<PM_IL_PROD_GROUP> productCodeList;
	
	private List<PM_IL_PROD_GROUP> PROD_GROUP_DATALIST;
	
	private PM_IL_PROD_GROUP PM_IL_PROD_GROUP_BEAN;
	
	private HtmlDatascroller COMP_UI_DATA_SCROLLER;
	
	private UIData dataTable;
	
	private int currPage;

	private int recordsPerPage = 5;
	
	private int lastUpdatedRowIndex;
	
	private int prevRowIndex;
	
	private String filterByPG_CODE;
	
	private String filterByPG_CODE_DESC;
	
	private String filterByPG_PROD_CODE;
	
	private String filterByPG_PROD_CODE_DESC;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;


	public List<PM_IL_PROD_GROUP> fetchGroupCodeList(Object obj) {
		String groupCode = (String) obj;
		PILM062_APAC_DELEGATE delegate = new PILM062_APAC_DELEGATE();
		try {
			groupCodeList = delegate.getGroupCodeLov(groupCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groupCodeList;
	}

	public void groupCodeDetails(ActionEvent event) {
		CommonUtils.clearMaps(this);
		boolean keepLooking = true;
		int rowIndex = getDataTable().getRowIndex();
		UIInput input= (UIInput)event.getComponent().getParent().getParent();
		//String inputValue= (String) CommonUtils.getCurrentValue(input);
		String inputValue= this.PM_IL_PROD_GROUP_BEAN.getPG_CODE();
		if (inputValue != null) {
			Iterator<PM_IL_PROD_GROUP> iterator = groupCodeList.iterator();
			while (iterator.hasNext() && keepLooking) {
				PM_IL_PROD_GROUP tempBean = iterator.next();
				if (tempBean.getPG_CODE().equals(inputValue)) {
					this.PM_IL_PROD_GROUP_BEAN.setPG_CODE(tempBean.getPG_CODE());
					this.PM_IL_PROD_GROUP_BEAN.setPG_CODE_DESC(tempBean.getPG_CODE_DESC());
//					getPROD_GROUP_DATALIST().get(rowIndex).setPG_CODE(tempBean.getPG_CODE());
//					getPROD_GROUP_DATALIST().get(rowIndex).setPG_CODE_DESC(tempBean.getPG_CODE_DESC());
					keepLooking = false;
				}
			}
		}
	}
	
	public List<PM_IL_PROD_GROUP> fetchProductCodeList(Object obj) {
		String productCode = (String) obj;
		PILM062_APAC_DELEGATE delegate = new PILM062_APAC_DELEGATE();
		try {
			productCodeList = delegate.getProductCodeLov(productCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productCodeList;
	}

	public void productCodeDetails(ActionEvent event) {
		CommonUtils.clearMaps(this);
		boolean keepLooking = true;
		int rowIndex = getDataTable().getRowIndex();
		UIInput input= (UIInput)event.getComponent().getParent().getParent();
		//String inputValue= (String) CommonUtils.getCurrentValue(input);
		String inputValue = PM_IL_PROD_GROUP_BEAN.getPG_PROD_CODE();
		if (inputValue != null) {
			Iterator<PM_IL_PROD_GROUP> iterator = productCodeList.iterator();
			while (iterator.hasNext() && keepLooking) {
				PM_IL_PROD_GROUP tempBean = iterator.next();
				if (tempBean.getPG_PROD_CODE().equals(inputValue)) {
					PM_IL_PROD_GROUP_BEAN.setPG_PROD_CODE(tempBean.getPG_PROD_CODE());
					PM_IL_PROD_GROUP_BEAN.setPG_PROD_CODE_DESC(tempBean.getPG_PROD_CODE_DESC());
//					getPROD_GROUP_DATALIST().get(rowIndex).setPG_PROD_CODE(tempBean.getPG_PROD_CODE());
	//				getPROD_GROUP_DATALIST().get(rowIndex).setPG_PROD_CODE_DESC(tempBean.getPG_PROD_CODE_DESC());
					keepLooking = false;
				}
			}
		}
	}

	public void loadingBaseValues(String pgCode) throws Exception {
		PILM062_APAC_DELEGATE delegate = new PILM062_APAC_DELEGATE();
		List<PM_IL_PROD_GROUP> prodGroupList = null;
		try {
			prodGroupList = delegate.fetchData(pgCode);
			if(prodGroupList!=null && prodGroupList.size()>0){
				for(int i=0;i<prodGroupList.size();i++){
					PM_IL_PROD_GROUP pm_il_prod_group = prodGroupList.get(i);
					if(i==0){
						pm_il_prod_group.setRowSelected(true);
						setPM_IL_PROD_GROUP_BEAN(pm_il_prod_group);
					}else{
						pm_il_prod_group.setRowSelected(false);
					}
				}
			}
			setPROD_GROUP_DATALIST(prodGroupList);
			/*if(prodGroupList!=null && prodGroupList.size()>0){
				PM_IL_PROD_GROUP prodGroupBean = prodGroupList.get(0);
				getPM_IL_PROD_GROUP_BEAN().setPG_CODE(prodGroupBean.getPG_CODE());
				getPM_IL_PROD_GROUP_BEAN().setPG_CODE_DESC(prodGroupBean.getPG_CODE_DESC());
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void PG_CODE_WHEN_VALIDATE_ITEM(ActionEvent event) {
		PILM062_APAC_HELPER helper = new PILM062_APAC_HELPER();
		boolean keepLooking = true;
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		if ( input.getValue()!=null) {
			String inputValue= input.getValue().toString();
			Iterator<PM_IL_PROD_GROUP> iterator = groupCodeList.iterator();
			while (iterator.hasNext() && keepLooking) {
				PM_IL_PROD_GROUP tempBean = iterator.next();
				if (tempBean.getPG_CODE().equals(inputValue)) {
					this.PM_IL_PROD_GROUP_BEAN.setPG_CODE(tempBean.getPG_CODE());
					this.PM_IL_PROD_GROUP_BEAN.setPG_CODE_DESC(tempBean.getPG_CODE_DESC());
					keepLooking = false;
				}
			}
			//Validate PG COde.
		/*	try {
				helper.PM_IL_PROD_GROUP_PG_CODE_WHEN_VALIDATE_ITEM(PM_IL_PROD_GROUP_BEAN);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
	
	public PM_IL_PROD_GROUP_ACTION(){
		PM_IL_PROD_GROUP_BEAN = new PM_IL_PROD_GROUP();
		PROD_GROUP_DATALIST = new ArrayList<PM_IL_PROD_GROUP>();
	}
	
	public void validatePG_CODE(FacesContext fc, UIComponent component,
			Object value) {
		PILM062_APAC_HELPER helper = new PILM062_APAC_HELPER();
		int rowIndex = getDataTable().getRowIndex();
		//PM_IL_PROD_GROUP PM_IL_PROD_GROUP_BEAN = getPROD_GROUP_DATALIST().get(rowIndex);
		try {
			helper.PM_IL_PROD_GROUP_PG_CODE_WHEN_VALIDATE_ITEM(PM_IL_PROD_GROUP_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
			
		}
	}
	
	public void PG_PROD_CODE_WHEN_VALIDATE_ITEM(ActionEvent event) {
		CommonUtils.clearMaps(this);
		boolean keepLooking = true;
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		
		
		
		if (input.getValue()!=null) {
			//String inputValue = COMP_PG_PROD_CODE.getSubmittedValue().toString();
			String inputValue = input.getValue().toString();
			Iterator<PM_IL_PROD_GROUP> iterator = productCodeList.iterator();
			while (iterator.hasNext() && keepLooking) {
				PM_IL_PROD_GROUP tempBean = iterator.next();
				if (tempBean.getPG_PROD_CODE().equals(inputValue)) {
					PM_IL_PROD_GROUP_BEAN.setPG_PROD_CODE(tempBean.getPG_PROD_CODE());
					PM_IL_PROD_GROUP_BEAN.setPG_PROD_CODE_DESC(tempBean.getPG_PROD_CODE_DESC());
					keepLooking = false;
				}
			}
			
		}
	}
	
	public void validatePG_PROD_CODE(FacesContext fc, UIComponent component,
			Object value) {
		int rowIndex = getDataTable().getRowIndex();
		PILM062_APAC_HELPER helper = new PILM062_APAC_HELPER();
//		PM_IL_PROD_GROUP PM_IL_PROD_GROUP_BEAN = getPROD_GROUP_DATALIST().get(rowIndex);
		try {
			helper.PM_IL_PROD_GROUP_PG_PROD_CODE_WHEN_VALIDATE_ITEM(PM_IL_PROD_GROUP_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void save() {
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		}
	}

	public List<PM_IL_PROD_GROUP> getPROD_GROUP_DATALIST() {
		return PROD_GROUP_DATALIST;
	}

	public void setPROD_GROUP_DATALIST(List<PM_IL_PROD_GROUP> prod_group_datalist) {
		PROD_GROUP_DATALIST = prod_group_datalist;
	}
	
	public String addRow() throws SQLException, Exception {
		int rowCount = 0;
		PM_IL_PROD_GROUP prodGroup = new PM_IL_PROD_GROUP();
		if(PROD_GROUP_DATALIST == null){
			PROD_GROUP_DATALIST = new ArrayList<PM_IL_PROD_GROUP>();
		}
		if(getPM_IL_PROD_GROUP_BEAN()!=null && getPM_IL_PROD_GROUP_BEAN().getPG_CODE()!=null){
			prodGroup.setPG_CODE(getPM_IL_PROD_GROUP_BEAN().getPG_CODE());
			prodGroup.setPG_CODE_DESC(getPM_IL_PROD_GROUP_BEAN().getPG_CODE_DESC());
		}
		getPROD_GROUP_DATALIST().add(prodGroup);
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
			getCOMP_UI_DATA_SCROLLER().setPage(currPage);
		}
		return "";
	}
	
	public String deleteRow() throws DBException {

		PM_IL_PROD_GROUP prodGroup = null;
		int deletedRecordCount = 0;
		String message = null;
		
		PILM062_APAC_DELEGATE delegate = new PILM062_APAC_DELEGATE();

		try{
			if (PROD_GROUP_DATALIST != null && getPROD_GROUP_DATALIST().size() > 0) {

				for(int index = getPROD_GROUP_DATALIST().size(); index > 0 ; index--) {
					prodGroup = getPROD_GROUP_DATALIST().get(index-1);

					//if (prodGroup.isChecked()) {
					if("dataTableSelectedRow".equalsIgnoreCase(prodGroup.getRowSelected())){

						getPROD_GROUP_DATALIST().remove(prodGroup);
						delegate.deleteData(prodGroup);
						deletedRecordCount++;
					}
				}

				if (deletedRecordCount > 0) {
					getWarningMap().put("DELETE",Messages.getString(
							PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
				}
				lastUpdatedRowIndex = -1;
			}
		}catch (Exception exc){
			getErrorMap().put("current", exc.getMessage());
			getErrorMap().put("detail", exc.getMessage());
		}

		return "";
	}
	
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 18-Feb-2009
	/*private void gridTabListener() {

		int currRowIndex = getDataTable().getRowIndex();

		PM_IL_PROD_GROUP prodGroup = null;
		PILM062_APAC_DELEGATE delegate = new PILM062_APAC_DELEGATE();
		
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						// Get the bean based on row index
						prodGroup = getPROD_GROUP_DATALIST().get(prevRowIndex);

						// Update the record to database
						if (prodGroup.getROWID() != null) {
							delegate.updateData(prodGroup);
							
							getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
						} else {
							delegate.updateData(prodGroup);
						
							getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
						}

						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return;
	}*/
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 18-Feb-2009
	
	private void lastColumnListener() {

		int currRowIndex = getDataTable().getRowIndex();

		PM_IL_PROD_GROUP prodGroup = null;
		PILM062_APAC_HELPER helper = new PILM062_APAC_HELPER();
		PILM062_APAC_DELEGATE delegate = new PILM062_APAC_DELEGATE();
		getErrorMap().clear();
		setErrorMessages(null);
		getWarningMap().clear();
		setWarningMessages(null);
		try {
			// Get the bean based on row index
			if(currRowIndex!=-1){
				prodGroup = getPROD_GROUP_DATALIST().get(currRowIndex);

				// Update the record to database
				if (prodGroup.getROWID() != null) {

					helper.PM_IL_PROD_GROUP_PRE_UPDATE(prodGroup);
					delegate.updateData(prodGroup);
					
					getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				} else {
					
					helper.PM_IL_PROD_GROUP_PRE_INSERT(prodGroup);
					delegate.updateData(prodGroup);
					
					getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				}
				lastUpdatedRowIndex = currRowIndex;
			}

		} catch (ValidatorException e1) {
			e1.printStackTrace();
			getErrorMap().put("current", e1.getMessage());
			getErrorMap().put("detail", e1.getMessage());
		} catch (SQLException e1) {
			e1.printStackTrace();
			getErrorMap().put("current", e1.getMessage());
			getErrorMap().put("detail", e1.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			getErrorMap().put("current", e1.getMessage());
			getErrorMap().put("detail", e1.getMessage());
		}
		return;
	}
	
	public void checkBoxStatus(ActionEvent event)	{
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		boolean check = Boolean.parseBoolean((String) CommonUtils.getCurrentValue(input));
		int rowIndex = getDataTable().getRowIndex();
		getPROD_GROUP_DATALIST().get(rowIndex).setChecked(check);
	}
	
	public String backToSearch() {
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.clearMappedBeanFromSession("PILM062_APAC_COMPOSITE_ACTION");
		
		return "backToSearch";
	}
	
	// [ Added for grid implementation change, Added by: Amit Kumar, Dated: 18 Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

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
	// [ Added for grid implementation change, Added by: Amit Kumar, Dated: 18-Feb-2009
	
	
	public void getDetails() {
		try {
			if (PROD_GROUP_DATALIST.size() != 0) {				
				PM_IL_PROD_GROUP_BEAN = (PM_IL_PROD_GROUP) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_PROD_GROUP_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_GROUP> iterator = PROD_GROUP_DATALIST.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	
	public void duplicateCheck() throws Exception{
		try {
			if ( PROD_GROUP_DATALIST != null  &&PROD_GROUP_DATALIST.size() > 0) {
				for (PM_IL_PROD_GROUP bean : PROD_GROUP_DATALIST) {
					if (bean.getPG_CODE().equals(PM_IL_PROD_GROUP_BEAN.getPG_CODE())) {
						if (bean.getPG_PROD_CODE().equals(PM_IL_PROD_GROUP_BEAN.getPG_PROD_CODE())) {
							throw new Exception("This Record Already Exists.please Re-enter");
						}
					}
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void post(ActionEvent ae) {
	//	PM006_A_APAC_HELPER helper = new PM006_A_APAC_HELPER();
		try{
			ControlBean controlBean = CommonUtils.getControlBean();
			Date sysdate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
			if(PM_IL_PROD_GROUP_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					duplicateCheck();
					new CRUDHandler().executeInsert(PM_IL_PROD_GROUP_BEAN, new CommonUtils().getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			} else {

				if(isINSERT_ALLOWED()) {
				
					PM_IL_PROD_GROUP_BEAN.setPG_CR_DT(sysdate);
					PM_IL_PROD_GROUP_BEAN.setPG_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
					duplicateCheck();
					new CRUDHandler().executeInsert(PM_IL_PROD_GROUP_BEAN, new CommonUtils().getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					if(PROD_GROUP_DATALIST==null){
						PROD_GROUP_DATALIST = new ArrayList<PM_IL_PROD_GROUP>();
					}
					
					PROD_GROUP_DATALIST.add(PM_IL_PROD_GROUP_BEAN);
					if(PROD_GROUP_DATALIST.size()>0){
						for(int i=0;i<PROD_GROUP_DATALIST.size();i++){
							PM_IL_PROD_GROUP  pm_il_ri_pool_cover = PROD_GROUP_DATALIST.get(i);
							if(i==0){
								pm_il_ri_pool_cover.setRowSelected(true);
								setPM_IL_PROD_GROUP_BEAN(pm_il_ri_pool_cover);
							}else{
								pm_il_ri_pool_cover.setRowSelected(false);
							}
						}
					}
					
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	private void resetAllComponent(){
		COMP_PG_CODE.resetValue();
		COMP_PG_CODE_DESC.resetValue();
		COMP_PG_PROD_CODE.resetValue();
		COMP_PG_PROD_CODE_DESC.resetValue();
	}
	/**
	 * Add New component
	 * @param event
	 */
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PM_IL_PROD_GROUP_BEAN = new PM_IL_PROD_GROUP();
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
	
	/**
	 * Deletes a Record from Grid/Table
	 * 
	 * @return
	 */
	public String deleteRow(ActionEvent ae) {

		try {
			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			if (PROD_GROUP_DATALIST != null) {
				deleteRow();
			}
			if(PROD_GROUP_DATALIST!=null && !PROD_GROUP_DATALIST.isEmpty()){
				for(int i=0;i<PROD_GROUP_DATALIST.size();i++){
					PM_IL_PROD_GROUP pm_il_claim_cover = PROD_GROUP_DATALIST.get(i);
					if(i==0){
						PM_IL_PROD_GROUP_BEAN.setRowSelected(true);
						setPM_IL_PROD_GROUP_BEAN(pm_il_claim_cover);
					}else{
						pm_il_claim_cover.setRowSelected(false);
					}
				}
			}
			if(PROD_GROUP_DATALIST!=null && PROD_GROUP_DATALIST.isEmpty()){
				setPM_IL_PROD_GROUP_BEAN(new PM_IL_PROD_GROUP());
			}
			
			resetAllComponent();
		}catch(Exception exception){
		}
		return "";
	}
	
	//newly added for delete button conformation panel
	
	public String deleteAction(){
		CommonUtils commonUtils = new CommonUtils();
		try {
			if (PM_IL_PROD_GROUP_BEAN == null) {
				getErrorMap().put("key", "not to delete");
				getErrorMap().put("current", "not to delete");
			}else{
				String deleteMeaage = Messages.getString("messageProperties","errorPanel$message$delete");
				//helper.pm_broker_comm_hdr_pre_DELETE(headerBean);
				delete_pm_comm_hdr();
				commonUtils.doComitt();
				//setPM_IL_PROD_GROUP_BEAN(new PM_IL_PROD_GROUP());
				PM_IL_PROD_GROUP_BEAN= new PM_IL_PROD_GROUP();
				if(PROD_GROUP_DATALIST.size()>0){
					PROD_GROUP_DATALIST.clear();
				}	
				resetAllComponent();
				getWarningMap().put("errorKey", deleteMeaage);
				getWarningMap().put("current", deleteMeaage);
			}
			PM_IL_PROD_GROUP_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete_pm_comm_hdr() throws DBException {
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		
		try {
			connection=CommonUtils.getConnection();
			handler.executeDelete(PM_IL_PROD_GROUP_BEAN, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	public String saveRecord(){
		try {
			String message = null;
			Connection connection = CommonUtils.getConnection();
			CommonUtils utils = new CommonUtils();
			utils.doComitt();
			message=Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save");
			getWarningMap().put("current", message);
			getWarningMap().put("detail", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * @return the cOMP_PG_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_PG_CODE_LABEL() {
		return COMP_PG_CODE_LABEL;
	}

	/**
	 * @param comp_pg_code_label the cOMP_PG_CODE_LABEL to set
	 */
	public void setCOMP_PG_CODE_LABEL(HtmlOutputLabel comp_pg_code_label) {
		COMP_PG_CODE_LABEL = comp_pg_code_label;
	}

	/**
	 * @return the cOMP_PG_CODE
	 */
	public HtmlInputText getCOMP_PG_CODE() {
		return COMP_PG_CODE;
	}

	/**
	 * @param comp_pg_code the cOMP_PG_CODE to set
	 */
	public void setCOMP_PG_CODE(HtmlInputText comp_pg_code) {
		COMP_PG_CODE = comp_pg_code;
	}

	/**
	 * @return the cOMP_PG_CODE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_PG_CODE_DESC_LABEL() {
		return COMP_PG_CODE_DESC_LABEL;
	}

	/**
	 * @param comp_pg_code_desc_label the cOMP_PG_CODE_DESC_LABEL to set
	 */
	public void setCOMP_PG_CODE_DESC_LABEL(HtmlOutputLabel comp_pg_code_desc_label) {
		COMP_PG_CODE_DESC_LABEL = comp_pg_code_desc_label;
	}

	/**
	 * @return the cOMP_PG_CODE_DESC
	 */
	public HtmlInputText getCOMP_PG_CODE_DESC() {
		return COMP_PG_CODE_DESC;
	}

	/**
	 * @param comp_pg_code_desc the cOMP_PG_CODE_DESC to set
	 */
	public void setCOMP_PG_CODE_DESC(HtmlInputText comp_pg_code_desc) {
		COMP_PG_CODE_DESC = comp_pg_code_desc;
	}

	/**
	 * @return the cOMP_PG_PROD_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_PG_PROD_CODE_LABEL() {
		return COMP_PG_PROD_CODE_LABEL;
	}

	/**
	 * @param comp_pg_prod_code_label the cOMP_PG_PROD_CODE_LABEL to set
	 */
	public void setCOMP_PG_PROD_CODE_LABEL(HtmlOutputLabel comp_pg_prod_code_label) {
		COMP_PG_PROD_CODE_LABEL = comp_pg_prod_code_label;
	}

	/**
	 * @return the cOMP_PG_PROD_CODE
	 */
	public HtmlInputText getCOMP_PG_PROD_CODE() {
		return COMP_PG_PROD_CODE;
	}

	/**
	 * @param comp_pg_prod_code the cOMP_PG_PROD_CODE to set
	 */
	public void setCOMP_PG_PROD_CODE(HtmlInputText comp_pg_prod_code) {
		COMP_PG_PROD_CODE = comp_pg_prod_code;
	}

	/**
	 * @return the cOMP_PG_PROD_CODE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_PG_PROD_CODE_DESC_LABEL() {
		return COMP_PG_PROD_CODE_DESC_LABEL;
	}

	/**
	 * @param comp_pg_prod_code_desc_label the cOMP_PG_PROD_CODE_DESC_LABEL to set
	 */
	public void setCOMP_PG_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel comp_pg_prod_code_desc_label) {
		COMP_PG_PROD_CODE_DESC_LABEL = comp_pg_prod_code_desc_label;
	}

	/**
	 * @return the cOMP_PG_PROD_CODE_DESC
	 */
	public HtmlInputText getCOMP_PG_PROD_CODE_DESC() {
		return COMP_PG_PROD_CODE_DESC;
	}

	/**
	 * @param comp_pg_prod_code_desc the cOMP_PG_PROD_CODE_DESC to set
	 */
	public void setCOMP_PG_PROD_CODE_DESC(HtmlInputText comp_pg_prod_code_desc) {
		COMP_PG_PROD_CODE_DESC = comp_pg_prod_code_desc;
	}

	/**
	 * @return the cOMP_UI_M_BUT_ADD_ROW
	 */
	public HtmlCommandButton getCOMP_UI_M_BUT_ADD_ROW() {
		return COMP_UI_M_BUT_ADD_ROW;
	}

	/**
	 * @param comp_ui_m_but_add_row the cOMP_UI_M_BUT_ADD_ROW to set
	 */
	public void setCOMP_UI_M_BUT_ADD_ROW(HtmlCommandButton comp_ui_m_but_add_row) {
		COMP_UI_M_BUT_ADD_ROW = comp_ui_m_but_add_row;
	}

	/**
	 * @return the cOMP_UI_M_BUT_DELETE_ROW
	 */
	public HtmlCommandButton getCOMP_UI_M_BUT_DELETE_ROW() {
		return COMP_UI_M_BUT_DELETE_ROW;
	}

	/**
	 * @param comp_ui_m_but_delete_row the cOMP_UI_M_BUT_DELETE_ROW to set
	 */
	public void setCOMP_UI_M_BUT_DELETE_ROW(
			HtmlCommandButton comp_ui_m_but_delete_row) {
		COMP_UI_M_BUT_DELETE_ROW = comp_ui_m_but_delete_row;
	}

	/**
	 * @return the groupCodeList
	 */
	public List<PM_IL_PROD_GROUP> getGroupCodeList() {
		return groupCodeList;
	}

	/**
	 * @param groupCodeList the groupCodeList to set
	 */
	public void setGroupCodeList(List<PM_IL_PROD_GROUP> groupCodeList) {
		this.groupCodeList = groupCodeList;
	}

	/**
	 * @return the productCodeList
	 */
	public List<PM_IL_PROD_GROUP> getProductCodeList() {
		return productCodeList;
	}

	/**
	 * @param productCodeList the productCodeList to set
	 */
	public void setProductCodeList(List<PM_IL_PROD_GROUP> productCodeList) {
		this.productCodeList = productCodeList;
	}

	/**
	 * @return the pM_IL_PROD_GROUP_BEAN
	 */
	public PM_IL_PROD_GROUP getPM_IL_PROD_GROUP_BEAN() {
		return PM_IL_PROD_GROUP_BEAN;
	}

	/**
	 * @param pm_il_prod_group_bean the pM_IL_PROD_GROUP_BEAN to set
	 */
	public void setPM_IL_PROD_GROUP_BEAN(PM_IL_PROD_GROUP pm_il_prod_group_bean) {
		PM_IL_PROD_GROUP_BEAN = pm_il_prod_group_bean;
	}

	/**
	 * @return the cOMP_UI_DATA_SCROLLER
	 */
	public HtmlDatascroller getCOMP_UI_DATA_SCROLLER() {
		return COMP_UI_DATA_SCROLLER;
	}

	/**
	 * @param comp_ui_data_scroller the cOMP_UI_DATA_SCROLLER to set
	 */
	public void setCOMP_UI_DATA_SCROLLER(HtmlDatascroller comp_ui_data_scroller) {
		COMP_UI_DATA_SCROLLER = comp_ui_data_scroller;
	}

	/**
	 * @return the dataTable
	 */
	public UIData getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the currPage
	 */
	public int getCurrPage() {
		return currPage;
	}

	/**
	 * @param currPage the currPage to set
	 */
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	/**
	 * @return the recordsPerPage
	 */
	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	/**
	 * @param recordsPerPage the recordsPerPage to set
	 */
	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	/**
	 * @return the lastUpdatedRowIndex
	 */
	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	/**
	 * @param lastUpdatedRowIndex the lastUpdatedRowIndex to set
	 */
	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	/**
	 * @return the prevRowIndex
	 */
	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	/**
	 * @param prevRowIndex the prevRowIndex to set
	 */
	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	/**
	 * @return the filterByPG_CODE
	 */
	public String getFilterByPG_CODE() {
		return filterByPG_CODE;
	}

	/**
	 * @param filterByPG_CODE the filterByPG_CODE to set
	 */
	public void setFilterByPG_CODE(String filterByPG_CODE) {
		this.filterByPG_CODE = filterByPG_CODE;
	}

	/**
	 * @return the filterByPG_CODE_DESC
	 */
	public String getFilterByPG_CODE_DESC() {
		return filterByPG_CODE_DESC;
	}

	/**
	 * @param filterByPG_CODE_DESC the filterByPG_CODE_DESC to set
	 */
	public void setFilterByPG_CODE_DESC(String filterByPG_CODE_DESC) {
		this.filterByPG_CODE_DESC = filterByPG_CODE_DESC;
	}

	/**
	 * @return the filterByPG_PROD_CODE
	 */
	public String getFilterByPG_PROD_CODE() {
		return filterByPG_PROD_CODE;
	}

	/**
	 * @param filterByPG_PROD_CODE the filterByPG_PROD_CODE to set
	 */
	public void setFilterByPG_PROD_CODE(String filterByPG_PROD_CODE) {
		this.filterByPG_PROD_CODE = filterByPG_PROD_CODE;
	}

	/**
	 * @return the filterByPG_PROD_CODE_DESC
	 */
	public String getFilterByPG_PROD_CODE_DESC() {
		return filterByPG_PROD_CODE_DESC;
	}

	/**
	 * @param filterByPG_PROD_CODE_DESC the filterByPG_PROD_CODE_DESC to set
	 */
	public void setFilterByPG_PROD_CODE_DESC(String filterByPG_PROD_CODE_DESC) {
		this.filterByPG_PROD_CODE_DESC = filterByPG_PROD_CODE_DESC;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DEL
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	/**
	 * @param ui_m_but_del the uI_M_BUT_DEL to set
	 */
	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

		
	public void onLoad(PhaseEvent event){
		try {
			if (isBlockFlag()) {
				PROD_GROUP_DATALIST = new PILM062_APAC_DELEGATE().fetchData(PM_IL_PROD_GROUP_BEAN.getROWID());
				new PILM062_APAC_HELPER().PM_IL_PROD_GROUP_POST_QUERY(PM_IL_PROD_GROUP_BEAN);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	

	
}
