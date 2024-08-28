package com.iii.pel.forms.PILM039;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_APPR_SETUP_DET1_ACTION extends CommonAction{
	
	private static Log LOG = LogFactory.getLog(PM_IL_APPR_SETUP_DET1_ACTION.class); 

	private HtmlOutputLabel COMP_ASD_CODE_LABEL;

	private HtmlInputText COMP_ASD_CODE;

	private HtmlOutputLabel COMP_UI_M_ASD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ASD_CODE_DESC;

	private HtmlOutputLabel COMP_ASD_CHAR_VALUE_LABEL;
	private HtmlInputText COMP_ASD_NUM_VALUE;

	private PM_IL_APPR_SETUP_DET1 PM_IL_APPR_SETUP_DET1_BEAN;

	private ArrayList<PM_IL_APPR_SETUP_DET1> list = new ArrayList<PM_IL_APPR_SETUP_DET1>();
	
	
	private Map<String, String> errorMap = new HashMap<String, String>();

	private String errorMessages;
	
	private UIData dataTable;
	
	private int currPage;

	private int prevRowIndex;

	private int recordsPerPage = 5;

	private int lastUpdatedRowIndex;
	
	// PREMIAGDC-0135 Added for new field , Added by: Shankar Bodduluri, Dated: 13-Mar-2009 -->
	
	private HtmlOutputLabel COMP_ASD_APPR_GRP_LABEL;

	private HtmlSelectOneMenu COMP_ASD_APPR_GRP;

	List<SelectItem> itemListName =null;
	
	private String filterByASD_CODE;
	
	private String filterByUI_M_ASD_CODE_DESC;
	
	private String filterByASD_NUM_VALUE;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	public PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction;
	

	public HtmlOutputLabel getCOMP_ASD_APPR_GRP_LABEL() {
		return COMP_ASD_APPR_GRP_LABEL;
	}

	public void setCOMP_ASD_APPR_GRP_LABEL(HtmlOutputLabel comp_asd_appr_grp_label) {
		COMP_ASD_APPR_GRP_LABEL = comp_asd_appr_grp_label;
	}

	public HtmlSelectOneMenu getCOMP_ASD_APPR_GRP() {
		return COMP_ASD_APPR_GRP;
	}

	public void setCOMP_ASD_APPR_GRP(HtmlSelectOneMenu comp_asd_appr_grp) {
		COMP_ASD_APPR_GRP = comp_asd_appr_grp;
	}

	public List<SelectItem> getItemListName() {
		return itemListName;
	}

	public void setItemListName(List<SelectItem> itemListName) {
		this.itemListName = itemListName;
	}

	public PM_IL_APPR_SETUP_DET1_ACTION() {
		PM_IL_APPR_SETUP_DET1_BEAN = new PM_IL_APPR_SETUP_DET1();
		
		itemListName = new PILM039_DELIGATE().selectValueForIL_APPR_GRP();
 

		prevRowIndex = 0;
		currPage = 1;
		
	}

	public HtmlOutputLabel getCOMP_ASD_CODE_LABEL() {
		return COMP_ASD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ASD_CODE() {
		return COMP_ASD_CODE;
	}

	public void setCOMP_ASD_CODE_LABEL(HtmlOutputLabel COMP_ASD_CODE_LABEL) {
		this.COMP_ASD_CODE_LABEL = COMP_ASD_CODE_LABEL;
	}

	public void setCOMP_ASD_CODE(HtmlInputText COMP_ASD_CODE) {
		this.COMP_ASD_CODE = COMP_ASD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ASD_CODE_DESC_LABEL() {
		return COMP_UI_M_ASD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ASD_CODE_DESC() {
		return COMP_UI_M_ASD_CODE_DESC;
	}

	public void setCOMP_UI_M_ASD_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_ASD_CODE_DESC_LABEL) {
		this.COMP_UI_M_ASD_CODE_DESC_LABEL = COMP_UI_M_ASD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_ASD_CODE_DESC(HtmlInputText COMP_UI_M_ASD_CODE_DESC) {
		this.COMP_UI_M_ASD_CODE_DESC = COMP_UI_M_ASD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_ASD_CHAR_VALUE_LABEL() {
		return COMP_ASD_CHAR_VALUE_LABEL;
	}

	public void setCOMP_ASD_CHAR_VALUE_LABEL(
			HtmlOutputLabel COMP_ASD_CHAR_VALUE_LABEL) {
		this.COMP_ASD_CHAR_VALUE_LABEL = COMP_ASD_CHAR_VALUE_LABEL;
	}

	public PM_IL_APPR_SETUP_DET1 getPM_IL_APPR_SETUP_DET1_BEAN() {
		return PM_IL_APPR_SETUP_DET1_BEAN;
	}

	public void setPM_IL_APPR_SETUP_DET1_BEAN(
			PM_IL_APPR_SETUP_DET1 PM_IL_APPR_SETUP_DET1_BEAN) {
		this.PM_IL_APPR_SETUP_DET1_BEAN = PM_IL_APPR_SETUP_DET1_BEAN;
	}

	public ArrayList<PM_IL_APPR_SETUP_DET1> getList() {
		return list;
	}

	public void setList(ArrayList<PM_IL_APPR_SETUP_DET1> list) {
		this.list = list;
	}
	
	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
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
	

	public String getErrorMessages() {
		String messageList;
		if ((errorMap == null) || (errorMap.size() == 0)) {
			messageList = "";
		} else {
			Map<String, String> error = new HashMap<String, String>();
			error.putAll(errorMap);
			error.remove("current");
			messageList = "<FONT SIZE=2><UL>\n";
			for (String message : error.values()) {

				messageList = messageList + "<LI>" + message + "\n";
			}
			messageList = messageList + "</UL></FONT>\n";
		}

		return messageList;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}
	
	
	public String checkBoxStatus(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		boolean check=Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataTable().getRowIndex();
		list.get(rowIndex).setCHECK_BOX(check);
		System.out.println("Comming to check box status");
		return "";
	}
	public String getCurrentValue(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}
	public void checkBoxValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//gridtabListener();
	}
	
	// [ Commented for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009
	
	/*public void gridtabListener() {
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_APPR_SETUP_DET1 detailsBean = null;
		PILM039_HELPER helper = new PILM039_HELPER();
		System.out.println(lastUpdatedRowIndex + "   " + currRowIndex + "  "+ prevRowIndex);
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");
						detailsBean =new PM_IL_APPR_SETUP_DET1();
						detailsBean = (PM_IL_APPR_SETUP_DET1) list.get(prevRowIndex);
						helper.pilm039_pm_il_appr_setup_det1_pre_update(detailsBean);
						rowUpdated = deligate.updateDataDET1(detailsBean);
						if (detailsBean.getROWID() != null) {
							errorMap.put("somekey", rowUpdated+ " record updated.");
							errorMap.put("current", rowUpdated+ " record updated.");
						} else {
							errorMap.put("somekey", rowUpdated+ " record inserted.");
							errorMap.put("current", rowUpdated+ " record inserted.");
						}//THE MESSAGE SHUD BE SHOWN AFTER LASTCOLUMNLISTSNER --VARUN(50663)
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return;
	}*/
	// Commented for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009 ]

	public void codeValidation(ActionEvent actionEvent) throws Exception
	{
		CommonUtils.clearMaps(this);
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();
		String codeValue=getCurrentValue(actionEvent);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		int rowIndex = getDataTable().getRowIndex();
		if(!"".equalsIgnoreCase(codeValue) && !codeValue.isEmpty()){
			list.get(rowIndex).setASD_CODE(codeValue);
			String descField = deligate.P_VAL_SYSTEM(codeValue, "N");
			getCOMP_UI_M_ASD_CODE_DESC().setSubmittedValue(descField);
		}else{
			getCOMP_UI_M_ASD_CODE_DESC().setSubmittedValue(" ");
			throw new ValidatorException(new FacesMessage("Invalid User Id"));
		}
		//gridtabListener();
	}
	public void valueValidation(ActionEvent actionEvent)
	{
		CommonUtils.clearMaps(this);
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction =null; 
		//double valueValue=Double.parseDouble(getCurrentValue(actionEvent));
		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		if(COMP_ASD_NUM_VALUE.getSubmittedValue()==null || "".equals(COMP_ASD_NUM_VALUE.getSubmittedValue())){
			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
		}else{
			String currentValue = (String)COMP_ASD_NUM_VALUE.getSubmittedValue();
			double valueValue = 0.0;
			if(currentValue!=null){
				valueValue=Double.parseDouble(currentValue);
			}
			
			CommonUtils commonUtils =new CommonUtils();
			//ErrorHelpUtil.validate(input, getErrorMap());
			compositeAction  =new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
			compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
			PM_IL_APPR_SETUP valueBean =compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN();

			/*int rowIndex = getDataTable().getRowIndex();
			PM_IL_APPR_SETUP_DET1 detailBeanGet=list.get(rowIndex);*/
			PM_IL_APPR_SETUP_DET1 detailBeanGet = null;
			for(PM_IL_APPR_SETUP_DET1 detailBean : list){
				if("dataTableSelectedRow".equalsIgnoreCase(detailBean.getRowSelected())){
					detailBeanGet = detailBean;
				}
			}
			
			String userId = valueBean.getAS_USER_ID();
			String fromProdId =valueBean.getAS_FM_PROD_CODE();
			String toProdId = valueBean.getAS_TO_PROD_CODE();
			
			
			try {
				detailBeanGet.setASD_USER_ID(userId);
				detailBeanGet.setASD_FM_PROD_CODE(fromProdId);
				detailBeanGet.setASD_TO_PROD_CODE(toProdId);
				detailBeanGet.setASD_CHAR_VALUE("0");//TODO not sure whether these values should be hard coded
				detailBeanGet.setASD_FLAG("1");
				detailBeanGet.setASD_NUM_VALUE(valueValue);
				if(detailBeanGet.getROWID()==null){
					
					detailBeanGet.setASD_CR_DT(commonUtils.getCurrentDate());
					detailBeanGet.setASD_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
				}else{
					//**Pre-Update Varun(50663)**//
					String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
					detailBeanGet.setASD_UPD_DT(new CommonUtils().getCurrentDate());
					detailBeanGet.setASD_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
					//** end**//
				}
				//lastColumnListener();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
	}
	public String addNew() {
		int rowCount = 0;
		if (list == null) {
			list = new ArrayList<PM_IL_APPR_SETUP_DET1>();
		}
		list.add(new PM_IL_APPR_SETUP_DET1());
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return null;
	}

	
	public void lastColumnListener( ){
		System.out.println("LAST COLUMN LISTENER...............");
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_APPR_SETUP_DET1 gridValueBean = null;
		PILM039_HELPER helper = new PILM039_HELPER();
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();
		String rowId = null;
		try {
				// Get the bean based on row index
				gridValueBean = (PM_IL_APPR_SETUP_DET1)list.get(currRowIndex);
				rowId = gridValueBean.getROWID();
				if (rowId == null) {
					String insertMessage = Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$save");
					getWarningMap().put("current", insertMessage);
				}else{
					
					String updateMessage = Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$update");
					getWarningMap().put("current", updateMessage);
				}
				rowUpdated = deligate.updateDataDET1(gridValueBean);
				lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return ;
	}

	public HtmlInputText getCOMP_ASD_NUM_VALUE() {
		return COMP_ASD_NUM_VALUE;
	}

	public void setCOMP_ASD_NUM_VALUE(HtmlInputText comp_asd_num_value) {
		COMP_ASD_NUM_VALUE = comp_asd_num_value;
	}
	public void validatePILM039User(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public String mainPage() {
		return "mainpage";
	}

	public String divisionPage() 
	{
		PM_IL_APPR_SETUP_COMPOSITE_ACTION linkBeanAction =new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		linkBeanAction.calldivisionPage();
		return "divisionpage";
	}

	public String rightPage() {
		PM_IL_APPR_SETUP_COMPOSITE_ACTION linkBeanAction =new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		linkBeanAction.callRightPage();
		return "rightpage";
	}

	public String headerPage() {
		return "headerpage";
	}

	public String processPage() 
	{
		PM_IL_APPR_SETUP_COMPOSITE_ACTION linkBeanAction =new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		linkBeanAction.callProcessPage();
		return "processpage";
	}
	public String saveAndCommit(){
		CommonUtils commonUtils = new CommonUtils();
		String message=null;
		try {
			commonUtils.doComitt();
			message=Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save");
			getWarningMap().put("current", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	// [ Added for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009
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
	// PREMIAGDC-0130 – added for generating ASD_APPR_GRP, Added by: Shankar Bodduluri, Dated: 13-Mar-2009

	public void ASD_APPR_GRP_FETCH_RECORDSValidate(ActionEvent actionEvent){
		String ASD_APPR_GRP = null;
		CommonUtils commonUtils = new CommonUtils();
		PILM039_DELIGATE delegate = new PILM039_DELIGATE();
		HtmlSelectOneMenu selectItem = (HtmlSelectOneMenu) actionEvent.getComponent().getParent();
		ASD_APPR_GRP = (String) selectItem.getSubmittedValue();
		PM_IL_APPR_SETUP_DET1_BEAN.setASD_APPR_GRP(ASD_APPR_GRP);
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		list = delegate.loadLimitsValues(compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN(), ASD_APPR_GRP);
		LOG.info("List Size============>"+list.size());
		PM_IL_APPR_SETUP_DET1 pm_il_appr_setup_det1 = null;
		
		if(list!=null && !list.isEmpty()){
			for(int i=0;i<list.size();i++){
				pm_il_appr_setup_det1 = (PM_IL_APPR_SETUP_DET1)list.get(i);
				if(i==0){
					pm_il_appr_setup_det1.setRowSelected(true);
					setPM_IL_APPR_SETUP_DET1_BEAN(pm_il_appr_setup_det1);
				}else{
					pm_il_appr_setup_det1.setRowSelected(false);	
				}
			}
			resetAllComponent();
		}
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
				PM_IL_APPR_SETUP_DET1_BEAN = new PM_IL_APPR_SETUP_DET1();
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
	 * Reset All the compent value
	 */
	private void resetAllComponent(){
		COMP_ASD_CODE.resetValue();
		COMP_UI_M_ASD_CODE_DESC.resetValue();
		COMP_ASD_NUM_VALUE.resetValue();
	}

	/**
	 * Deletes a Record from Grid/Table
	 * 
	 * @return
	 */
	
	/*
	 * Post the Value.
	 */
	public void post(ActionEvent ae) {
		
		try{
			
			ControlBean controlBean = CommonUtils.getControlBean();
			if(PM_IL_APPR_SETUP_DET1_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					setValues();
					new CRUDHandler().executeInsert(PM_IL_APPR_SETUP_DET1_BEAN, CommonUtils.getConnection());
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
					setValues();
					PILM039_DELIGATE deligate = new PILM039_DELIGATE();
					PM_IL_APPR_SETUP_DET1_BEAN.setASD_CR_DT(new CommonUtils().getCurrentDate());
					PM_IL_APPR_SETUP_DET1_BEAN.setASD_CR_UID(controlBean.getM_USER_ID());
					
					new CRUDHandler().executeInsert(PM_IL_APPR_SETUP_DET1_BEAN, CommonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					list.add(PM_IL_APPR_SETUP_DET1_BEAN);
					
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
	
	public void getDetails() {
		try {
			if (list.size() != 0) {				
				PM_IL_APPR_SETUP_DET1_BEAN = (PM_IL_APPR_SETUP_DET1) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_APPR_SETUP_DET1_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_APPR_SETUP_DET1_BEAN,
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
				list
						.remove(PM_IL_APPR_SETUP_DET1_BEAN);
				if (list.size() > 0) {

					PM_IL_APPR_SETUP_DET1_BEAN = list
							.get(0);
				} else if (list.size() == 0) {

					AddRow(null);
				}

				resetAllComponent();
				PM_IL_APPR_SETUP_DET1_BEAN.setRowSelected(true);
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
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_APPR_SETUP_DET1> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	/**
	 * @return the filterByASD_CODE
	 */
	public String getFilterByASD_CODE() {
		return filterByASD_CODE;
	}

	/**
	 * @param filterByASD_CODE the filterByASD_CODE to set
	 */
	public void setFilterByASD_CODE(String filterByASD_CODE) {
		this.filterByASD_CODE = filterByASD_CODE;
	}

	/**
	 * @return the filterByUI_M_ASD_CODE_DESC
	 */
	public String getFilterByUI_M_ASD_CODE_DESC() {
		return filterByUI_M_ASD_CODE_DESC;
	}

	/**
	 * @param filterByUI_M_ASD_CODE_DESC the filterByUI_M_ASD_CODE_DESC to set
	 */
	public void setFilterByUI_M_ASD_CODE_DESC(String filterByUI_M_ASD_CODE_DESC) {
		this.filterByUI_M_ASD_CODE_DESC = filterByUI_M_ASD_CODE_DESC;
	}

	

	/**
	 * @return the filterByASD_NUM_VALUE
	 */
	public String getFilterByASD_NUM_VALUE() {
		return filterByASD_NUM_VALUE;
	}

	/**
	 * @param filterByASD_NUM_VALUE the filterByASD_NUM_VALUE to set
	 */
	public void setFilterByASD_NUM_VALUE(String filterByASD_NUM_VALUE) {
		this.filterByASD_NUM_VALUE = filterByASD_NUM_VALUE;
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

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * Sets the value to the bean.
	 */
	private void setValues(){
		CommonUtils.clearMaps(this);
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction =null; 
		String currentValue = (String)COMP_ASD_NUM_VALUE.getSubmittedValue();
		double valueValue = 0.0;
		if(currentValue!=null && !"".equalsIgnoreCase(currentValue)){
			valueValue=Double.parseDouble(currentValue);
		}
		
		CommonUtils commonUtils =new CommonUtils();
		//ErrorHelpUtil.validate(input, getErrorMap());
		compositeAction  =new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		PM_IL_APPR_SETUP valueBean =compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN();

		/*int rowIndex = getDataTable().getRowIndex();
		PM_IL_APPR_SETUP_DET1 detailBeanGet=list.get(rowIndex);*/
		PM_IL_APPR_SETUP_DET1 detailBeanGet = null;
		for(PM_IL_APPR_SETUP_DET1 detailBean : list){
			if("dataTableSelectedRow".equalsIgnoreCase(detailBean.getRowSelected())){
				detailBeanGet = detailBean;
			}
		}
		
		String userId = valueBean.getAS_USER_ID();
		String fromProdId =valueBean.getAS_FM_PROD_CODE();
		String toProdId = valueBean.getAS_TO_PROD_CODE();
		
		try {
			detailBeanGet.setASD_USER_ID(userId);
			detailBeanGet.setASD_FM_PROD_CODE(fromProdId);
			detailBeanGet.setASD_TO_PROD_CODE(toProdId);
			detailBeanGet.setASD_CHAR_VALUE("0");//TODO not sure whether these values should be hard coded
			detailBeanGet.setASD_FLAG("1");
			detailBeanGet.setASD_NUM_VALUE(valueValue);
			if(detailBeanGet.getROWID()==null){
				
				detailBeanGet.setASD_CR_DT(commonUtils.getCurrentDate());
				detailBeanGet.setASD_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			}else{
				//**Pre-Update Varun(50663)**//
				String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
				detailBeanGet.setASD_UPD_DT(new CommonUtils().getCurrentDate());
				detailBeanGet.setASD_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
				//** end**//
			}
			//lastColumnListener();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
