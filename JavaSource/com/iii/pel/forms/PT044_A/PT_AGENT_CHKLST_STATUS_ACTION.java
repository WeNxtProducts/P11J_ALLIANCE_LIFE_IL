package com.iii.pel.forms.PT044_A;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UISelectOne;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_AGENT_CHKLST_STATUS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ACS_SR_NO_LABEL;

	private HtmlInputText COMP_ACS_SR_NO;

	private HtmlOutputLabel COMP_ACS_TODO_LIST_ITEM_LABEL;

	private HtmlInputText COMP_ACS_TODO_LIST_ITEM;

	private HtmlOutputLabel COMP_ACS_MANDATORY_YN_LABEL;

	private HtmlSelectOneMenu COMP_ACS_MANDATORY_YN;

	private HtmlOutputLabel COMP_ACS_APPR_STS_LABEL;

	private HtmlSelectOneMenu COMP_ACS_APPR_STS;

	private HtmlOutputLabel COMP_ACS_REMARKS_LABEL;

	private HtmlInputText COMP_ACS_REMARKS;
	
	private String filterByACS_SR_NO;

	private String filterByACS_TODO_LIST_ITEM;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private PT_AGENT_CHKLST_STATUS PT_AGENT_CHKLST_STATUS_BEAN;
	
	public PT044_A_COMPOSITE_ACTION compositeAction;
	
	private UIDataTable dataTable;
	private int recordsPerPage = PELConstants.datatableRecordSize;

	private int lastUpdatedRowIndex;

	private int prevRowIndex;

	private int currPage;

	ArrayList<PT_AGENT_CHKLST_STATUS> list = new ArrayList<PT_AGENT_CHKLST_STATUS>();
	
	List<SelectItem> itemACS_MANDATORY_YN =null;
	List<SelectItem> itemACS_APPR_STS =null;

	public List<SelectItem> getItemACS_MANDATORY_YN() {
		return itemACS_MANDATORY_YN;
	}

	public void setItemACS_MANDATORY_YN(List<SelectItem> itemACS_MANDATORY_YN) {
		this.itemACS_MANDATORY_YN = itemACS_MANDATORY_YN;
	}

	public List<SelectItem> getItemACS_APPR_STS() {
		return itemACS_APPR_STS;
	}

	public void setItemACS_APPR_STS(List<SelectItem> itemACS_APPR_STS) {
		this.itemACS_APPR_STS = itemACS_APPR_STS;
	}

	public PT_AGENT_CHKLST_STATUS_ACTION() {
		PT_AGENT_CHKLST_STATUS_BEAN = new PT_AGENT_CHKLST_STATUS();
		
		itemACS_MANDATORY_YN = PT044_A_DELEGATE.getDropDownListValue("PT044_A","PT_AGENT_CHKLST_STATUS","PT_AGENT_CHKLST_STATUS.ACS_MANDATORY_YN","YESNO");
		itemACS_APPR_STS = PT044_A_DELEGATE.getDropDownListValue("PT044_A","PT_AGENT_CHKLST_STATUS","PT_AGENT_CHKLST_STATUS.ACS_APPR_STS","CHKLST_STS");
		
		prevRowIndex = 0;
		currPage = 1;
		
		initialAllComponent();
		postButtonShow();
		
	}

	public HtmlOutputLabel getCOMP_ACS_SR_NO_LABEL() {
		return COMP_ACS_SR_NO_LABEL;
	}

	public HtmlInputText getCOMP_ACS_SR_NO() {
		return COMP_ACS_SR_NO;
	}

	public void setCOMP_ACS_SR_NO_LABEL(HtmlOutputLabel COMP_ACS_SR_NO_LABEL) {
		this.COMP_ACS_SR_NO_LABEL = COMP_ACS_SR_NO_LABEL;
	}

	public void setCOMP_ACS_SR_NO(HtmlInputText COMP_ACS_SR_NO) {
		this.COMP_ACS_SR_NO = COMP_ACS_SR_NO;
	}

	public HtmlOutputLabel getCOMP_ACS_TODO_LIST_ITEM_LABEL() {
		return COMP_ACS_TODO_LIST_ITEM_LABEL;
	}

	public HtmlInputText getCOMP_ACS_TODO_LIST_ITEM() {
		return COMP_ACS_TODO_LIST_ITEM;
	}

	public void setCOMP_ACS_TODO_LIST_ITEM_LABEL(HtmlOutputLabel COMP_ACS_TODO_LIST_ITEM_LABEL) {
		this.COMP_ACS_TODO_LIST_ITEM_LABEL = COMP_ACS_TODO_LIST_ITEM_LABEL;
	}

	public void setCOMP_ACS_TODO_LIST_ITEM(HtmlInputText COMP_ACS_TODO_LIST_ITEM) {
		this.COMP_ACS_TODO_LIST_ITEM = COMP_ACS_TODO_LIST_ITEM;
	}

	public HtmlOutputLabel getCOMP_ACS_MANDATORY_YN_LABEL() {
		return COMP_ACS_MANDATORY_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ACS_MANDATORY_YN() {
		return COMP_ACS_MANDATORY_YN;
	}

	public void setCOMP_ACS_MANDATORY_YN_LABEL(HtmlOutputLabel COMP_ACS_MANDATORY_YN_LABEL) {
		this.COMP_ACS_MANDATORY_YN_LABEL = COMP_ACS_MANDATORY_YN_LABEL;
	}

	public void setCOMP_ACS_MANDATORY_YN(HtmlSelectOneMenu COMP_ACS_MANDATORY_YN) {
		this.COMP_ACS_MANDATORY_YN = COMP_ACS_MANDATORY_YN;
	}

	public HtmlOutputLabel getCOMP_ACS_APPR_STS_LABEL() {
		return COMP_ACS_APPR_STS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ACS_APPR_STS() {
		return COMP_ACS_APPR_STS;
	}

	public void setCOMP_ACS_APPR_STS_LABEL(HtmlOutputLabel COMP_ACS_APPR_STS_LABEL) {
		this.COMP_ACS_APPR_STS_LABEL = COMP_ACS_APPR_STS_LABEL;
	}

	public void setCOMP_ACS_APPR_STS(HtmlSelectOneMenu COMP_ACS_APPR_STS) {
		this.COMP_ACS_APPR_STS = COMP_ACS_APPR_STS;
	}

	public HtmlOutputLabel getCOMP_ACS_REMARKS_LABEL() {
		return COMP_ACS_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_ACS_REMARKS() {
		return COMP_ACS_REMARKS;
	}

	public void setCOMP_ACS_REMARKS_LABEL(HtmlOutputLabel COMP_ACS_REMARKS_LABEL) {
		this.COMP_ACS_REMARKS_LABEL = COMP_ACS_REMARKS_LABEL;
	}

	public void setCOMP_ACS_REMARKS(HtmlInputText COMP_ACS_REMARKS) {
		this.COMP_ACS_REMARKS = COMP_ACS_REMARKS;
	}

	public PT_AGENT_CHKLST_STATUS getPT_AGENT_CHKLST_STATUS_BEAN() {
		return PT_AGENT_CHKLST_STATUS_BEAN;
	}

	public void setPT_AGENT_CHKLST_STATUS_BEAN(PT_AGENT_CHKLST_STATUS PT_AGENT_CHKLST_STATUS_BEAN) {
		this.PT_AGENT_CHKLST_STATUS_BEAN = PT_AGENT_CHKLST_STATUS_BEAN;
	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
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

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public ArrayList<PT_AGENT_CHKLST_STATUS> getList() {
		return list;
	}

	public void setList(ArrayList<PT_AGENT_CHKLST_STATUS> list) {
		this.list = list;
	}
	
	public String getCurrentValue(ActionEvent event) {
		//[Calling of the method is implemented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
		CommonUtils.clearMaps(this);
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		//[Calling of the method is implemented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
		CommonUtils.clearMaps(this);
		boolean check = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataTable().getRowIndex();
		list.get(rowIndex).setCHECK_BOX(check);
		return "";
	}

	public void checkBoxValidation(ActionEvent event) {
		//[Calling of the method is commented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
		//gridtabListener();
	}

	public String checkBoxFlagStatus(ActionEvent actionEvent) {
		String checkValue = getCurrentValue(actionEvent);
		String assignCheckValue = "";
		if ("true".equalsIgnoreCase(checkValue)) {
			assignCheckValue = "Y";
		} else {
			assignCheckValue = "N";
		}

		int rowIndex = getDataTable().getRowIndex();

		return "";
	}
	//[Commented by the Phanikumar dated on 16-Feb-2009 for the New Tab Implementation
	/*private void gridtabListener() {
		int currRowIndex  =getDataTable().getRowIndex();
		PT044_A_DELEGATE delegate =null;
		int rowUpdated =0;
		PT_AGENT_CHKLST_STATUS detailBean = null;
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex == 0) {
						if (currRowIndex != prevRowIndex) {
							detailBean = new PT_AGENT_CHKLST_STATUS();
							delegate = new PT044_A_DELEGATE();
							detailBean = (PT_AGENT_CHKLST_STATUS) list.get(prevRowIndex);
							rowUpdated = delegate.updateChecklistDetails(detailBean);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("Unable to Insert", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
	}*/
	//]
	public String addNew() {
		int rowCount = 0;
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		PT_AGENT_CHKLST_STATUS localBean = null;
		if (list == null) {
			list = new ArrayList<PT_AGENT_CHKLST_STATUS>();
		}
		localBean = new PT_AGENT_CHKLST_STATUS();
		delegate.loaddefalutDetailValues(localBean);
		list.add(localBean);
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return null;
	}
	public String deleteRow() {
		PT_AGENT_CHKLST_STATUS bean = null;
		ArrayList deletedRecordList = null;
		PT044_A_DELEGATE delegate =new PT044_A_DELEGATE();
		int deletedRecordIndex = 0;
		if (list != null) {
			deletedRecordList = new ArrayList();
			for (int index = 0; index < list.size();) {
				bean = list.get(index);
				if (bean.isCHECK_BOX()) {
					list.remove(bean);
					deletedRecordIndex = delegate.deleteChecklistDetails(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			if (deletedRecordList.size() > 0) {
				getErrorMap().put("SuccesFully", deletedRecordList.size()+ " records deleted.");
				getErrorMap().put("current", deletedRecordList.size()+ " records deleted.");
			}
			lastUpdatedRowIndex = -1;
		}
		return "";
	}
	public void lastColumnListener(){
		int currRowIndex = getDataTable().getRowIndex();
		PT044_A_DELEGATE delegate =new PT044_A_DELEGATE();
		int rowUpdated = 0;
		PT_AGENT_CHKLST_STATUS gridValueBean = null;
		String rowId = null;
		String successMessage = null;
	
		try {
				gridValueBean = (PT_AGENT_CHKLST_STATUS)list.get(currRowIndex);
				rowId = gridValueBean.getROWID();
				if (rowId == null) {
					delegate.pt_agent_chklst_pre_insert(gridValueBean);
				}else{
					delegate.pt_agent_chklst_pre_update(gridValueBean);
				}
				rowUpdated = delegate.updateChecklistDetails(gridValueBean);
				
				if (rowId == null) {
					successMessage = Messages.getString("messageProperties", "errorPanel$message$save");
					getWarningMap().put("details", successMessage);
					getWarningMap().put("current", successMessage);
				}else{
					successMessage = Messages.getString("messageProperties", "errorPanel$message$update");
					getWarningMap().put("details", successMessage);
					getWarningMap().put("current", successMessage);
				}
				lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return ;
	}
	public String getCurrentSelectedValue(ActionEvent event) {
		//[Calling of the method is implemented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
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
	public String saveRecord(){
	CommonUtils commonUtils = new CommonUtils();
			try {
				commonUtils.doComitt();
				getWarningMap().put("current",Messages.getString(
					"messageProperties","errorPanel$message$save"));
			getWarningMap().put("details",Messages.getString(
					"messageProperties","errorPanel$message$save"));
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("commkey", "Error on commit, cause: "+e.getMessage());
				getErrorMap().put("current", "Error on commit");
			}
			return null;
		}
		/*CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			//Newly Added
			int rowCount = getDataTable().getRowCount();
			PT_AGENT_CHKLST_STATUS pt_agent_chklst_status = null;
			PT044_A_COMPOSITE_ACTION pt044_a_composite_action = (PT044_A_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession("PT044_A_COMPOSITE_ACTION");
			int count = 0;
			for(int index = 0; index<getList().size(); index++)
			{
				pt_agent_chklst_status = (PT_AGENT_CHKLST_STATUS) getList().get(index);
				
				if("Y".equalsIgnoreCase(pt_agent_chklst_status.getACS_MANDATORY_YN()) && "Y".equalsIgnoreCase(pt_agent_chklst_status.getACS_APPR_STS()))
				{
					count = count+1;
					
				}else if("N".equalsIgnoreCase(pt_agent_chklst_status.getACS_MANDATORY_YN()))
				{
					count = count+1;
				}else{
					count = 0;
				}
			}
			
			if(count == getList().size())
			{
				pt044_a_composite_action.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
			}else{
				pt044_a_composite_action.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	public void validateField(ActionEvent event){
		UIInput inputValue = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(inputValue, getErrorMap());
	}
	public void validateSrNo(FacesContext context, UIComponent component,Object value){
		//getCurrentBean().setACS_SR_NO((Double) value);
		Double ACS_SR_NO = (Double) value;
		PT_AGENT_CHKLST_STATUS_BEAN.setACS_SR_NO(ACS_SR_NO);
		//[Calling of the method is commented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
		 //gridtabListener();
		
	}
	public void validateTodoListItem(ActionEvent event){
		System.out.println("PM_AGENT_CHKLIST_STATUS_ACTION.validateTodoListItem()");
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());	
		//[Calling of the method is implemented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
		//CommonUtils.clearMaps(this);
		//String ACS_TODO_LIST_ITEM = getCurrentValue(event);
		//getCurrentBean().setACS_TODO_LIST_ITEM(ACS_TODO_LIST_ITEM);
		//String ACS_TODO_LIST_ITEM = null;
		//PT_AGENT_CHKLST_STATUS_BEAN.setACS_TODO_LIST_ITEM(ACS_TODO_LIST_ITEM);
		
		//[Calling of the method is commented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
		//gridtabListener();
	}
	//
	
	public void validateMandatory(ActionEvent event){
		System.out.println("PM_AGENT_CHKLIST_STATUS_ACTION.validateMandatory()");
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		//[Calling of the method is implemented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
		/*CommonUtils.clearMaps(this);
		String ACS_MANDATORY_YN = getCurrentSelectedValue(event);
		getCurrentBean().setACS_MANDATORY_YN(ACS_MANDATORY_YN);*/
		//[Calling of the method is commented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
		//gridtabListener();
	}
	public void validateStatus(ActionEvent event){
		System.out.println("PM_AGENT_CHKLIST_STATUS_ACTION.validateStatus()");
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		//[Calling of the method is implemented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
		/*CommonUtils.clearMaps(this);
		String ACS_APPR_STS = getCurrentSelectedValue(event);
		getCurrentBean().setACS_APPR_STS(ACS_APPR_STS);*/
		//[Calling of the method is commented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
		//gridtabListener();
	}
	public void validateRemarks(ActionEvent event){
		System.out.println("PM_AGENT_CHKLIST_STATUS_ACTION.validateRemarks()");
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		//[Calling of the method is implemented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
		/*CommonUtils.clearMaps(this);
		String ACS_REMARKS = getCurrentValue(event);
		getCurrentBean().setACS_REMARKS(ACS_REMARKS);*/
		//[Calling of the method is commented by the Phanikumar dated on 16-Feb-2009 for the new Tab Implementation]
		//lastColumnListener();
	}
	
	
	public PT_AGENT_CHKLST_STATUS getCurrentBean(){
		//int rowIndex = getDataTable().getRowIndex(); 
		return  PT_AGENT_CHKLST_STATUS_BEAN;//list.get(rowIndex);
	}
	// [ Added for grid implementation change, Added by: PhaniKumar , Dated: 16-Feb-2009
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
	
	public void resetAllComponent() {

		// Reseting HtmlInputText
		COMP_ACS_SR_NO.resetValue();
		COMP_ACS_TODO_LIST_ITEM.resetValue();
		COMP_ACS_MANDATORY_YN.resetValue();
		COMP_ACS_APPR_STS.resetValue();
		COMP_ACS_REMARKS.resetValue();
		
	}
	
	
	private void resetSelectedRow() {
		Iterator<PT_AGENT_CHKLST_STATUS> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	public void getDetails() {
		try {
			if (list.size() != 0) {
				PT_AGENT_CHKLST_STATUS_BEAN = (PT_AGENT_CHKLST_STATUS) dataTable
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PT_AGENT_CHKLST_STATUS_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void post(ActionEvent ae) {
		PT044_A_DELEGATE delegate =new PT044_A_DELEGATE();
		try {
			if (PT_AGENT_CHKLST_STATUS_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {

					delegate.pt_agent_chklst_pre_update(PT_AGENT_CHKLST_STATUS_BEAN);
					new CRUDHandler().executeUpdate(PT_AGENT_CHKLST_STATUS_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {

				if (isINSERT_ALLOWED()) {
					delegate.pt_agent_chklst_pre_insert(PT_AGENT_CHKLST_STATUS_BEAN);
					new CRUDHandler().executeInsert(PT_AGENT_CHKLST_STATUS_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					list.add(PT_AGENT_CHKLST_STATUS_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PT_AGENT_CHKLST_STATUS_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}


	// Added for grid implementation change, Added by: Phanikumar, Dated: 16-Feb-2009 ]

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

	public String getFilterByACS_SR_NO() {
		return filterByACS_SR_NO;
	}

	public void setFilterByACS_SR_NO(String filterByACS_SR_NO) {
		this.filterByACS_SR_NO = filterByACS_SR_NO;
	}

	public String getFilterByACS_TODO_LIST_ITEM() {
		return filterByACS_TODO_LIST_ITEM;
	}

	public void setFilterByACS_TODO_LIST_ITEM(String filterByACS_TODO_LIST_ITEM) {
		this.filterByACS_TODO_LIST_ITEM = filterByACS_TODO_LIST_ITEM;
	}
	
	public void initialAllComponent()
	{
		UI_M_BUT_POST=new HtmlAjaxCommandButton();
		COMP_ACS_SR_NO=new HtmlInputText();
		COMP_ACS_TODO_LIST_ITEM =new HtmlInputText();
		COMP_ACS_MANDATORY_YN=new HtmlSelectOneMenu();
		COMP_ACS_APPR_STS=new HtmlSelectOneMenu();
		COMP_ACS_REMARKS =new HtmlInputText();
	}
	
	public void postButtonShow()
	{
		/*getUI_M_BUT_POST().setRendered(true);*/
	}
	
}
