package com.iii.pel.forms.PM094_A;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_AGENT_BONUS_APPL_PROD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ABAP_MODULE_ID_LABEL;

	private HtmlSelectOneMenu COMP_ABAP_MODULE_ID;

	private HtmlOutputLabel COMP_ABAP_PROD_CODE_LABEL;

	private HtmlInputText COMP_ABAP_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_ABAP_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ABAP_PROD_CODE_DESC;

	private PM_AGENT_BONUS_APPL_PROD PM_AGENT_BONUS_APPL_PROD_BEAN;

	private List<PM_AGENT_BONUS_APPL_PROD> dataList_PM_AGENT_BONUS_APPL_PROD = new ArrayList<PM_AGENT_BONUS_APPL_PROD>();

	private List<SelectItem> moduleIdList;
	
	private int currPage=1;
	
	private int recordsPerPage = 5;
	
	private int lastUpdatedRowIndex;
	
	private int prevRowIndex;
	
	private UIData dataTable;
	
	private List prodcodeList;
	
	public PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction;
	
	private PM_AGENT_BONUS_APPL_PROD_HELPER helper;
	
	public PM_AGENT_BONUS_APPL_PROD_ACTION() {
		PM_AGENT_BONUS_APPL_PROD_BEAN = new PM_AGENT_BONUS_APPL_PROD();
		helper = new PM_AGENT_BONUS_APPL_PROD_HELPER();
		getDropDown();
	}

	private void getDropDown() {
		try {
			Connection connection=CommonUtils.getConnection();
			List moduleId=ListItemUtil.getDropDownListValue(connection, PM094_A_PM_AGENT_BONUS_CONSTANTS.FORM_NAME,
																PM094_A_PM_AGENT_BONUS_CONSTANTS.BLOCK_NAME_APPL_PROD,
																PM094_A_PM_AGENT_BONUS_CONSTANTS.ITEM_NAME_MODULE_ID, null);
			setModuleIdList(moduleId);
		} catch (DBException e) {
			
			e.printStackTrace();
		}
		
	}

	public HtmlOutputLabel getCOMP_ABAP_MODULE_ID_LABEL() {
		return COMP_ABAP_MODULE_ID_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ABAP_MODULE_ID() {
		return COMP_ABAP_MODULE_ID;
	}

	public void setCOMP_ABAP_MODULE_ID_LABEL(HtmlOutputLabel COMP_ABAP_MODULE_ID_LABEL) {
		this.COMP_ABAP_MODULE_ID_LABEL = COMP_ABAP_MODULE_ID_LABEL;
	}

	public void setCOMP_ABAP_MODULE_ID(HtmlSelectOneMenu COMP_ABAP_MODULE_ID) {
		this.COMP_ABAP_MODULE_ID = COMP_ABAP_MODULE_ID;
	}

	public HtmlOutputLabel getCOMP_ABAP_PROD_CODE_LABEL() {
		return COMP_ABAP_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ABAP_PROD_CODE() {
		return COMP_ABAP_PROD_CODE;
	}

	public void setCOMP_ABAP_PROD_CODE_LABEL(HtmlOutputLabel COMP_ABAP_PROD_CODE_LABEL) {
		this.COMP_ABAP_PROD_CODE_LABEL = COMP_ABAP_PROD_CODE_LABEL;
	}

	public void setCOMP_ABAP_PROD_CODE(HtmlInputText COMP_ABAP_PROD_CODE) {
		this.COMP_ABAP_PROD_CODE = COMP_ABAP_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABAP_PROD_CODE_DESC_LABEL() {
		return COMP_UI_M_ABAP_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ABAP_PROD_CODE_DESC() {
		return COMP_UI_M_ABAP_PROD_CODE_DESC;
	}

	public void setCOMP_UI_M_ABAP_PROD_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ABAP_PROD_CODE_DESC_LABEL) {
		this.COMP_UI_M_ABAP_PROD_CODE_DESC_LABEL = COMP_UI_M_ABAP_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_ABAP_PROD_CODE_DESC(HtmlInputText COMP_UI_M_ABAP_PROD_CODE_DESC) {
		this.COMP_UI_M_ABAP_PROD_CODE_DESC = COMP_UI_M_ABAP_PROD_CODE_DESC;
	}

	public PM_AGENT_BONUS_APPL_PROD getPM_AGENT_BONUS_APPL_PROD_BEAN() {
		return PM_AGENT_BONUS_APPL_PROD_BEAN;
	}

	public void setPM_AGENT_BONUS_APPL_PROD_BEAN(PM_AGENT_BONUS_APPL_PROD PM_AGENT_BONUS_APPL_PROD_BEAN) {
		this.PM_AGENT_BONUS_APPL_PROD_BEAN = PM_AGENT_BONUS_APPL_PROD_BEAN;
	}

	public List<PM_AGENT_BONUS_APPL_PROD> getDataList_PM_AGENT_BONUS_APPL_PROD() {
		return dataList_PM_AGENT_BONUS_APPL_PROD;
	}

	public void setDataListPM_AGENT_BONUS_APPL_PROD(List<PM_AGENT_BONUS_APPL_PROD> dataList_PM_AGENT_BONUS_APPL_PROD) {
		this.dataList_PM_AGENT_BONUS_APPL_PROD = dataList_PM_AGENT_BONUS_APPL_PROD;
	}

	public void loadBonusApplProd(HashMap<String, String> errorMap) {
		PM_AGENT_BONUS_APPL_PROD_HELPER helper = new PM_AGENT_BONUS_APPL_PROD_HELPER();
		String message = null;
		
		try {
			dataList_PM_AGENT_BONUS_APPL_PROD = new ArrayList<PM_AGENT_BONUS_APPL_PROD>();
			helper.execute_query(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			errorMap.put("current", message);
			errorMap.put("details", message);
		}
	}

	public List<SelectItem> getModuleIdList() {
		return moduleIdList;
	}

	public void setModuleIdList(List<SelectItem> moduleIdList) {
		this.moduleIdList = moduleIdList;
	}
	
	public String addRow() throws Exception{
		int rowCount = 0;
		getWarningMap().clear();
		getErrorMap().clear();
		PM_AGENT_BONUS_APPL_PROD addBean = null;
		if (dataList_PM_AGENT_BONUS_APPL_PROD == null) {
			dataList_PM_AGENT_BONUS_APPL_PROD = new ArrayList<PM_AGENT_BONUS_APPL_PROD>();
		}
		addBean = new PM_AGENT_BONUS_APPL_PROD();
		PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction = (PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION");
		String absCode=compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN().getABS_CODE();
		System.out.println("Abs Code :"+absCode);
		new PM_AGENT_BONUS_APPL_PROD_HELPER().when_create_record(addBean);
		addBean.setABAP_ABS_CODE(absCode);
		dataList_PM_AGENT_BONUS_APPL_PROD.add(addBean);

		rowCount = dataList_PM_AGENT_BONUS_APPL_PROD.size();
		currPage = rowCount / recordsPerPage;
		if(rowCount%recordsPerPage>0){
			currPage++;
		}
		return "";
	}
	
	public String removeRow() {
		PM_AGENT_BONUS_APPL_PROD bean = null;
		ArrayList<Integer> deletedRecordList = null;
		PM_AGENT_BONUS_APPL_PROD_DELEGATE delegete = new PM_AGENT_BONUS_APPL_PROD_DELEGATE();
		int deletedRecordIndex = 0;
		getWarningMap().clear();
		getErrorMap().clear();

		try{
			if (dataList_PM_AGENT_BONUS_APPL_PROD != null && dataList_PM_AGENT_BONUS_APPL_PROD.size()>0) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < dataList_PM_AGENT_BONUS_APPL_PROD.size();) {
					bean = dataList_PM_AGENT_BONUS_APPL_PROD.get(index);
					if (bean.isCheckBoxSelected()) {
						dataList_PM_AGENT_BONUS_APPL_PROD.remove(bean);
						deletedRecordIndex = delegete.deleteApplProd(bean);
						deletedRecordList.add(deletedRecordIndex);
					} else {
						index++;
					}
				}
				if (deletedRecordList.size() > 0) {
					getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				}
				lastUpdatedRowIndex = -1;
			}
		}catch (Exception exc){
			getErrorMap().put("current", exc.getMessage());
		}

		return "";
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}
	
	public String  lastColumnListener() throws Exception{
		System.out.println("LAST COLUMN LISTENER CALLED----------------------->");
		int currRowIndex = getDataTable().getRowIndex();
		PM_AGENT_BONUS_APPL_PROD_HELPER helper = new PM_AGENT_BONUS_APPL_PROD_HELPER();
		PM_AGENT_BONUS_APPL_PROD_DELEGATE delegate=new PM_AGENT_BONUS_APPL_PROD_DELEGATE();
		CommonUtils utils=new CommonUtils();
		int result = 0;
		String message = null;
		PM_AGENT_BONUS_APPL_PROD gridValueBean = null;
		getWarningMap().clear();
		getErrorMap().clear();
		try {
			
			gridValueBean = (PM_AGENT_BONUS_APPL_PROD)dataList_PM_AGENT_BONUS_APPL_PROD.get(currRowIndex);
			if(gridValueBean.getROWID()== null){
				//helper.pre_insert(gridValueBean);
				gridValueBean.setABAP_CR_DT(utils.getCurrentDate());
				gridValueBean.setABAP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
			}else{
				helper.pre_update(gridValueBean);
				gridValueBean.setABAP_UPD_DT(utils.getCurrentDate());
				gridValueBean.setABAP_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
			}
			result=delegate.executeInsert(gridValueBean);
			if (result == 1) {
				getWarningMap().put("current", message);
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			getErrorMap().put("current", e1.getMessage());
		}

		return "" ;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	
	public void validateModuleId(FacesContext context, UIComponent component,
			Object value){
		String moduleId=(String)value;
		System.out.println("moduleId :"+moduleId);
		PM_AGENT_BONUS_APPL_PROD_HELPER helper=new PM_AGENT_BONUS_APPL_PROD_HELPER();
		
		PM_AGENT_BONUS_APPL_PROD_BEAN.setABAP_MODULE_ID(moduleId);
		try {
			helper.whenListChanged(PM_AGENT_BONUS_APPL_PROD_BEAN);
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void validateAbapProdCode(FacesContext context, UIComponent component,
			Object value){
		String abapProdCode=(String)value;
		PM_AGENT_BONUS_APPL_PROD_HELPER helper=new PM_AGENT_BONUS_APPL_PROD_HELPER();
		PM_AGENT_BONUS_APPL_PROD_BEAN.setABAP_PROD_CODE(abapProdCode);
		try {
			helper.whenListChanged(PM_AGENT_BONUS_APPL_PROD_BEAN);
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public List getProdcodeList() {
		return prodcodeList;
	}

	public void setProdcodeList(List prodcodeList) {
		this.prodcodeList = prodcodeList;
	}
	
	public List suggestionActionProdCode(Object event){
		String prodcode=(String)event;
		PM_AGENT_BONUS_APPL_PROD_HELPER helper=new PM_AGENT_BONUS_APPL_PROD_HELPER();
		String moduleId=PM_AGENT_BONUS_APPL_PROD_BEAN.getABAP_MODULE_ID();
		prodcodeList=helper.prepareProdCodeList(prodcode,moduleId,prodcodeList);
		return prodcodeList;
	}
	
	public void getProdCodeDesc(ActionEvent event) {
		PM_AGENT_BONUS_APPL_PROD_BEAN.setUI_M_ABAP_PROD_CODE_DESC(null);
		System.out.println("prod code :" + PM_AGENT_BONUS_APPL_PROD_BEAN.getABAP_PROD_CODE());
		if (PM_AGENT_BONUS_APPL_PROD_BEAN.getABAP_PROD_CODE()!= null) {
			String prodcode = (String) PM_AGENT_BONUS_APPL_PROD_BEAN.getABAP_PROD_CODE();
			PM_AGENT_BONUS_APPL_PROD_HELPER helper=new PM_AGENT_BONUS_APPL_PROD_HELPER();
			String prodCodeDesc = helper.getDescforProdCode(prodcode, prodcodeList);
			PM_AGENT_BONUS_APPL_PROD_BEAN.setUI_M_ABAP_PROD_CODE_DESC(prodCodeDesc);
		
	}
	}
	
	public String saveAndCommit(){
		CommonUtils commonUtils=new CommonUtils();
		String message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
		try {
			commonUtils.doComitt();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void saveData() {
		try {
			CommonUtils.clearMaps(this);
			CommonUtils.getConnection().commit();
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_AGENT_BONUS_APPL_PROD_BEAN = (PM_AGENT_BONUS_APPL_PROD) dataTable
					.getRowData();
			helper.postQuery(PM_AGENT_BONUS_APPL_PROD_BEAN);
			PM_AGENT_BONUS_APPL_PROD_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	private void resetSelectedRow() {
		Iterator<PM_AGENT_BONUS_APPL_PROD> iterator = dataList_PM_AGENT_BONUS_APPL_PROD
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent(){
		COMP_ABAP_PROD_CODE.resetValue();
		COMP_UI_M_ABAP_PROD_CODE_DESC.resetValue();
	}
	
	public void addRow(ActionEvent event) {
		try {
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()) {
				PM_AGENT_BONUS_APPL_PROD_BEAN = new PM_AGENT_BONUS_APPL_PROD();
				helper.when_create_record(PM_AGENT_BONUS_APPL_PROD_BEAN);
				resetAllComponent();
				resetSelectedRow();
			} else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}
	}
	
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				new CRUDHandler().executeDelete(PM_AGENT_BONUS_APPL_PROD_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
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
				dataList_PM_AGENT_BONUS_APPL_PROD.remove(PM_AGENT_BONUS_APPL_PROD_BEAN);
				if (dataList_PM_AGENT_BONUS_APPL_PROD.size() > 0) {

					PM_AGENT_BONUS_APPL_PROD_BEAN = dataList_PM_AGENT_BONUS_APPL_PROD
							.get(0);
				} else if (dataList_PM_AGENT_BONUS_APPL_PROD.size() == 0) {
					addRow(null);
				}

				resetAllComponent();
				PM_AGENT_BONUS_APPL_PROD_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}
			

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		try {
			if (PM_AGENT_BONUS_APPL_PROD_BEAN.getROWID() == null){
				if(isINSERT_ALLOWED()) {
					helper.pre_insert(PM_AGENT_BONUS_APPL_PROD_BEAN,compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN());
				new CRUDHandler().executeInsert(PM_AGENT_BONUS_APPL_PROD_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				dataList_PM_AGENT_BONUS_APPL_PROD.add(PM_AGENT_BONUS_APPL_PROD_BEAN);
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PM_AGENT_BONUS_APPL_PROD_BEAN.getROWID() != null){
					if(isUPDATE_ALLOWED()) {
				helper.pre_update(PM_AGENT_BONUS_APPL_PROD_BEAN);
				new CRUDHandler().executeUpdate(PM_AGENT_BONUS_APPL_PROD_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
			}else{
				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$updatenotallowed"));
			}
			}
			PM_AGENT_BONUS_APPL_PROD_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}
	
	
	public void onLoad(PhaseEvent event){
		try {
			if(isBlockFlag()){
				helper.execute_query(compositeAction);
				if(PM_AGENT_BONUS_APPL_PROD_BEAN.getROWID() != null){
					helper.postQuery(PM_AGENT_BONUS_APPL_PROD_BEAN);
				}else{
					helper.when_create_record(PM_AGENT_BONUS_APPL_PROD_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
}
