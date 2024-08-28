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
import javax.faces.component.UISelectOne;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.component.html.HtmlComboBox;
import org.richfaces.component.html.HtmlDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_APPR_SETUP_DET_ACTION extends CommonAction{

	private static Log LOG = LogFactory.getLog(PM_IL_APPR_SETUP_DET_ACTION.class); 

	private HtmlOutputLabel COMP_ASD_CODE_LABEL;

	private HtmlInputText COMP_ASD_CODE;

	private HtmlOutputLabel COMP_UI_M_ASD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ASD_CODE_DESC;

	private HtmlOutputLabel COMP_ASD_NUM_VALUE_LABEL;

	private HtmlComboBox COMP_ASD_CHAR_VALUE_TYPE;
	
	private PM_IL_APPR_SETUP_DET PM_IL_APPR_SETUP_DET_BEAN;

	private ArrayList<SelectItem> fetchComboValue;

	private ArrayList<PM_IL_APPR_SETUP_DET> list = new ArrayList<PM_IL_APPR_SETUP_DET>();

	private HtmlDataTable htmlDataTable;
	
	PILM039_DELIGATE deligate =new PILM039_DELIGATE();

	private UIData dataTable;

	private int currPage;

	private int prevRowIndex;

	private int recordsPerPage = 5;

	private int lastUpdatedRowIndex;

	private String errorMessages;

	private Map<String, String> errorMap = new HashMap<String, String>();
	
	private HtmlOutputLabel COMP_ASD_APPR_GRP_LABEL;

	private HtmlSelectOneMenu COMP_ASD_APPR_GRP;

	private HtmlSelectOneMenu COMP_ASD_APPR_GRP_SEL;
	
	List<SelectItem> itemListName =null;
	
	private String filterByASD_CODE;
	
	private String filterByUI_M_ASD_CODE_DESC;
	
	private String filterByASD_CHAR_VALUE;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	public PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction;
	
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
	 * @return the filterByASD_CHAR_VALUE
	 */
	public String getFilterByASD_CHAR_VALUE() {
		return filterByASD_CHAR_VALUE;
	}

	/**
	 * @param filterByASD_CHAR_VALUE the filterByASD_CHAR_VALUE to set
	 */
	public void setFilterByASD_CHAR_VALUE(String filterByASD_CHAR_VALUE) {
		this.filterByASD_CHAR_VALUE = filterByASD_CHAR_VALUE;
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

	public PM_IL_APPR_SETUP_DET_ACTION() {
		PM_IL_APPR_SETUP_DET_BEAN = new PM_IL_APPR_SETUP_DET();
		fetchComboValue = deligate.selectValueForComboBox();
		
		itemListName = deligate.selectValueForIL_APPR_GRP();

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

	public HtmlOutputLabel getCOMP_ASD_NUM_VALUE_LABEL() {
		return COMP_ASD_NUM_VALUE_LABEL;
	}

	public void setCOMP_ASD_NUM_VALUE_LABEL(
			HtmlOutputLabel COMP_ASD_NUM_VALUE_LABEL) {
		this.COMP_ASD_NUM_VALUE_LABEL = COMP_ASD_NUM_VALUE_LABEL;
	}

	public PM_IL_APPR_SETUP_DET getPM_IL_APPR_SETUP_DET_BEAN() {
		return PM_IL_APPR_SETUP_DET_BEAN;
	}

	public void setPM_IL_APPR_SETUP_DET_BEAN(
			PM_IL_APPR_SETUP_DET PM_IL_APPR_SETUP_DET_BEAN) {
		this.PM_IL_APPR_SETUP_DET_BEAN = PM_IL_APPR_SETUP_DET_BEAN;
	}

	public String mainPage() {

		return "mainpage";
	}

	public String headerPage() {

		return "header";
	}

	

	public ArrayList<SelectItem> getFetchComboValue() {
		return fetchComboValue;
	}

	public void setFetchComboValue(ArrayList<SelectItem> fetchComboValue) {
		this.fetchComboValue = fetchComboValue;
	}

	public HtmlDataTable getHtmlDataTable() {
		return htmlDataTable;
	}

	public void setHtmlDataTable(HtmlDataTable htmlDataTable) {
		this.htmlDataTable = htmlDataTable;
	}

	public ArrayList<PM_IL_APPR_SETUP_DET> getList() {
		return list;
	}

	public void setList(ArrayList<PM_IL_APPR_SETUP_DET> list) {
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
	public HtmlComboBox getCOMP_ASD_CHAR_VALUE_TYPE() {
		return COMP_ASD_CHAR_VALUE_TYPE;
	}

	public void setCOMP_ASD_CHAR_VALUE_TYPE(
			HtmlComboBox comp_asd_char_value_type) {
		COMP_ASD_CHAR_VALUE_TYPE = comp_asd_char_value_type;
	}
	
	public String getErrorMessages() {
		return errorMessages;
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
		int rowIndex =getDataTable().getRowIndex();
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

	public String getCurrentSelectedValue(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String value = null;
		UISelectOne input = null;
		if (event != null) {
			input = (UISelectOne) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in selected field is : " + value);
			}
		}
		return value;
	}

	public void checkBoxValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//gridtabListener();
	}

	// [ Commented for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009
	
/*	public void gridtabListener() {
		
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_APPR_SETUP_DET detailsBean = null;
		PILM039_HELPER helper = new PILM039_HELPER(); 
		
		System.out.println(lastUpdatedRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");
						detailsBean = new PM_IL_APPR_SETUP_DET();
						detailsBean = (PM_IL_APPR_SETUP_DET) list.get(prevRowIndex);
						helper.pilm039_pm_il_appr_setup_det_pre_update(detailsBean);
						rowUpdated = deligate.updateDataDET(detailsBean);
						if (detailsBean.getROWID() != null) {
							errorMap.put("somekey", rowUpdated+ " record updated.");
							errorMap.put("current", rowUpdated+ " record updated.");
						} else {
							errorMap.put("somekey", rowUpdated+ " record inserted.");
							errorMap.put("current", rowUpdated+ " record inserted.");
						}
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

	public String addNew() {
		int rowCount = 0;
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;
		if (list == null) {
			list = new ArrayList<PM_IL_APPR_SETUP_DET>();
		}
		compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		list.add(compositeAction.getPM_IL_APPR_SETUP_DET_ACTION_BEAN()
				.getPM_IL_APPR_SETUP_DET_BEAN());
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return null;
	}

	/*public String deleteRow() {
		PM_IL_APPR_SETUP_DET bean = null;
		ArrayList deletedRecordList = null;
		
		int deletedRecordIndex = 0;
		if (list != null) {
			deletedRecordList = new ArrayList();
			for (int index = 0; index < list.size();) {
				bean = list.get(index);
				if (bean.isCHECK_BOX()) {
					list.remove(bean);
					deletedRecordIndex = deligate.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			if (deletedRecordList.size() > 0) {
				errorMap.put("somekey", deletedRecordList.size()+ " records deleted.");
				errorMap.put("current", deletedRecordList.size()+ " records deleted.");
			}
			lastUpdatedRowIndex = -1;
		}
		return "";
	}*/

	public void codeValidation(ActionEvent actionEvent) throws Exception {
		CommonUtils.clearMaps(this);
		String insertedValue = getCurrentValue(actionEvent);
		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		int rowIndex = getDataTable().getRowIndex();
		
		if(!"".equalsIgnoreCase(insertedValue) && !insertedValue.isEmpty()){
			list.get(rowIndex).setASD_CODE(insertedValue);
			String descField = deligate.P_VAL_SYSTEM(insertedValue, "N");
			getCOMP_UI_M_ASD_CODE_DESC().setSubmittedValue(descField);
		}else{
			getCOMP_UI_M_ASD_CODE_DESC().setSubmittedValue("");
			throw new ValidatorException(new FacesMessage("Invalid User Id"));
		}
		
		
		//gridtabListener();
		System.out.println(insertedValue);
	}
	public void onselectMethode(ActionEvent event) {
		CommonUtils.clearMaps(this);
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;
		CommonUtils commonUtils =new CommonUtils();
		String onSelectedValue = getCurrentSelectedValue(event);
		UISelectOne selectOne = (UISelectOne) event.getComponent().getParent();
		ErrorHelpUtil.validate(selectOne, getErrorMap());
		System.out.println(onSelectedValue);
		compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");

		PM_IL_APPR_SETUP valueDetailBean = compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN();
		
		PM_IL_APPR_SETUP_DET assignValueBean = null;
		
		for(PM_IL_APPR_SETUP_DET bean : list){
			if("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())){
				 assignValueBean = bean;
			}
		}
		
		String rowid = null;
		String UserId = valueDetailBean.getAS_USER_ID();
		String FromProcCode = valueDetailBean.getAS_FM_PROD_CODE();
		String toProcCode =valueDetailBean.getAS_TO_PROD_CODE();
		
		rowid = assignValueBean.getROWID();
		assignValueBean.setASD_FLAG("2");
		assignValueBean.setASD_FM_PROD_CODE(FromProcCode);
		assignValueBean.setASD_TO_PROD_CODE(toProcCode);
		assignValueBean.setASD_USER_ID(UserId);
		assignValueBean.setASD_CHAR_VALUE(onSelectedValue);
		try {
				if(rowid==null){
					
					assignValueBean.setASD_CR_DT(commonUtils.getCurrentDate());
					assignValueBean.setASD_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
					
				}else{
					
					assignValueBean.setASD_UPD_DT(commonUtils.getCurrentDate());
					assignValueBean.setASD_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
				}
		
				//lastColumnListener();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	public void lastColumnListener(){
		System.out.println("LAST COLUMN LISTENER...............");
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_APPR_SETUP_DET gridValueBean = null;
		PILM039_HELPER helper = new PILM039_HELPER();
		String rowId = null;
		try {
				// Get the bean based on row index
				gridValueBean = (PM_IL_APPR_SETUP_DET)list.get(currRowIndex);
				rowId = gridValueBean.getROWID();
				if (rowId == null) {
					String insertMessage = Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$save");
					getWarningMap().put("current", insertMessage);
				}else{
					String updateMessage = Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$update");
					getWarningMap().put("current", updateMessage);
				}
				rowUpdated = deligate.updateDataDET(gridValueBean);
				lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return ;
	}
	
	public String divisionPage() {
		PM_IL_APPR_SETUP_COMPOSITE_ACTION linkBeanAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		linkBeanAction.calldivisionPage();
		return "division";
	}

	public String limitsPage() {
		PM_IL_APPR_SETUP_COMPOSITE_ACTION linkBeanAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		linkBeanAction.callLimitsPage();
		return "limits";
	}
	public String saveAndCommit(){
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			String insertMessage = Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$save");
			getWarningMap().put("current", insertMessage);
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
	// Added for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009 ]
	
	// Added for UnderRating issue , Added by: Shankar Bodduluri[CCHN1148],  

	public List<SelectItem> getItemListName() {
		return itemListName;
	}

	public void setItemListName(List<SelectItem> itemListName) {
		this.itemListName = itemListName;
	}

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
	public void ASD_APPR_GRP_FETCH_RECORDSValidate(ActionEvent actionEvent){
		String ASD_APPR_GRP = null;
		CommonUtils commonUtils = new CommonUtils();
		PILM039_DELIGATE delegate = new PILM039_DELIGATE();
		HtmlSelectOneMenu selectItem = (HtmlSelectOneMenu) actionEvent.getComponent().getParent();
		ASD_APPR_GRP = (String) selectItem.getSubmittedValue();
		PM_IL_APPR_SETUP_DET_BEAN.setASD_APPR_GRP(ASD_APPR_GRP);
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		list = delegate.loadRightsValues(compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN(), ASD_APPR_GRP);
		PM_IL_APPR_SETUP_DET pmSetUpDt = null;
		//Data list default value set.
		if(list!=null && !list.isEmpty()){
			for(int i=0;i<list.size();i++){
				pmSetUpDt = list.get(i);
				if(i==0){
					pmSetUpDt.setRowSelected(true);
					setPM_IL_APPR_SETUP_DET_BEAN(pmSetUpDt);
				}else{
					pmSetUpDt.setRowSelected(false);
				}
			}
			resetAllComponent();		
		}
	}
	
	public void post(ActionEvent ae) {
		try{
			
			ControlBean controlBean = CommonUtils.getControlBean();
			if(PM_IL_APPR_SETUP_DET_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					PM_IL_APPR_SETUP_DET_BEAN.setASD_UPD_DT(new CommonUtils().getCurrentDate());
					PM_IL_APPR_SETUP_DET_BEAN.setASD_UPD_UID(controlBean.getM_USER_ID());
					new CRUDHandler().executeUpdate(PM_IL_APPR_SETUP_DET_BEAN, CommonUtils.getConnection());
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
					PILM039_DELIGATE deligate = new PILM039_DELIGATE();
					new CRUDHandler().executeInsert(PM_IL_APPR_SETUP_DET_BEAN, CommonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					list.add(PM_IL_APPR_SETUP_DET_BEAN);
					
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
		COMP_ASD_CODE.resetValue();
		COMP_UI_M_ASD_CODE_DESC.resetValue();
		COMP_ASD_APPR_GRP.resetValue();
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
				PM_IL_APPR_SETUP_DET_BEAN = new PM_IL_APPR_SETUP_DET();
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
			LOG.info("Inside Delete Method");
			PILM039_DELIGATE deligate = new PILM039_DELIGATE();
			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			PM_IL_APPR_DEPT_SETUP bean = null;
			ArrayList<Integer> deletedRecordList = null;
			int deletedRecordIndex = 0;

			if (list != null) {/*
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < list.size();) {
					bean = list.get(index);
					if ("dataTableSelectedRow".equalsIgnoreCase(bean
							.getRowSelected())) {
						list.remove(bean);
						deletedRecordIndex = deligate.deleteDataDEPT(bean);
						deletedRecordList.add(deletedRecordIndex);

					} else {
						index++;
					}
				}
				for(int i=0;i<list.size();i++){
					PM_IL_APPR_DEPT_SETUP pm_il_appr_dept_setup = list.get(i);
					if(i==0){
						pm_il_appr_dept_setup.setRowSelected(true);
						setPM_IL_APPR_DEPT_SETUP_BEAN(pm_il_appr_dept_setup);
					}else{
						pm_il_appr_dept_setup.setRowSelected(false);
					}
				}
				if(list.isEmpty()){
					PM_IL_APPR_DEPT_SETUP_BEAN = new PM_IL_APPR_DEPT_SETUP();
					setPM_IL_APPR_DEPT_SETUP_BEAN(PM_IL_APPR_DEPT_SETUP_BEAN);
				}
				if (deletedRecordList.size() > 0) {
					getWarningMap().put("current",
							+deletedRecordList.size() + "Record Deleted ");

				}
				lastUpdateRowIndex = -1;

			*/}
			resetAllComponent();
		}catch(Exception exception){
		}
		return "";
	}
	
	public void getDetails() {
		try {
			if (list.size() != 0) {				
				PM_IL_APPR_SETUP_DET_BEAN = (PM_IL_APPR_SETUP_DET) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_APPR_SETUP_DET_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_APPR_SETUP_DET> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	/**
	 * @return the cOMP_ASD_APPR_GRP_SEL
	 */
	public HtmlSelectOneMenu getCOMP_ASD_APPR_GRP_SEL() {
		return COMP_ASD_APPR_GRP_SEL;
	}

	/**
	 * @param comp_asd_appr_grp_sel the cOMP_ASD_APPR_GRP_SEL to set
	 */
	public void setCOMP_ASD_APPR_GRP_SEL(HtmlSelectOneMenu comp_asd_appr_grp_sel) {
		COMP_ASD_APPR_GRP_SEL = comp_asd_appr_grp_sel;
	}

}
