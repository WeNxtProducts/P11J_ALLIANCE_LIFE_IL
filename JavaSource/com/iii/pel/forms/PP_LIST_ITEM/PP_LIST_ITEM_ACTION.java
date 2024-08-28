package com.iii.pel.forms.PP_LIST_ITEM;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PP_LIST_ITEM_ACTION extends CommonAction{
	
	private HtmlOutputLabel COMP_LIV_SYS_PARAM_LABEL;
	
	private HtmlOutputLabel COMP_LIV_DESC_LABEL;
	
	private HtmlOutputLabel COMP_LIV_CODE_LABEL;
	
	private HtmlOutputLabel COMP_LIV_CODE_DESC_LABEL;
	
	private HtmlOutputLabel COMP_LIV_BL_CODE_DESC_LABEL;
	
	private HtmlOutputLabel COMP_LI_MODULE_NAME_LABEL;
	
	private HtmlOutputLabel COMP_LI_BLOCK_NAME_LABEL;
	
	private HtmlOutputLabel COMP_LI_ITEM_NAME_LABEL;
	
	private HtmlOutputLabel COMP_LI_SYS_PARAM_LABEL;
	
	private HtmlOutputLabel COMP_LI_REMARKS_LABEL;
	
	private HtmlOutputLabel COMP_LI_EXTERNAL_TABLE_YN_LABEL;
	
	private HtmlOutputLabel COMP_LI_WHERE_CLAUSE_LABEL;
	
	private HtmlOutputLabel COMP_LI_DFLT_VALUE_LABEL;
	
	private HtmlInputText COMP_LIV_SYS_PARAM ;
	
	private HtmlInputText COMP_LIV_DESC ;
	
	private HtmlInputText COMP_LIV_CODE ;
	
	private HtmlInputText COMP_LIV_CODE_DESC ;
	
	private HtmlInputText COMP_LIV_BL_CODE_DESC ;
	
	private HtmlInputText COMP_LI_MODULE_NAME;
	
	private HtmlInputText COMP_LI_BLOCK_NAME ;
	
	private HtmlInputText COMP_LI_ITEM_NAME ;
	
	private HtmlInputText COMP_LI_SYS_PARAM ;
	
	private HtmlInputText COMP_LI_REMARKS ;
	
	private HtmlSelectBooleanCheckbox COMP_LI_EXTERNAL_TABLE_YN ;
	
	private HtmlInputText COMP_LI_WHERE_CLAUSE ;
	
	private HtmlInputText COMP_LI_DFLT_VALUE ;
	
	private PP_LIST_ITEM PP_LIST_ITEM_BEAN;
	
	private PP_LIST_ITEM_VALUES PP_LIST_ITEM_VALUES_BEAN;
	
	private UIData listItemDataTable;
	
	private UIData listItemValuesDataTable;
	
	private int recordsPerPage = 3;
	
	private int currItemPage = 1;
	
	private int lastUpdatedRowIndex;
	
	private int prevRowIndex;
	
	private int valuesPerPage = 3;
	
	private int currValuePage = 1;
	
	private int lastUpdatedValuesRowIndex;
	
	private int prevValuesRowIndex;
	
	private ArrayList<PP_LIST_ITEM> listItemList;
		
	private ArrayList<PP_LIST_ITEM_VALUES> listItemValuesList;
	
	
	public PP_LIST_ITEM_ACTION(){
		
		PP_LIST_ITEM_BEAN = new PP_LIST_ITEM();
		PP_LIST_ITEM_VALUES_BEAN = new PP_LIST_ITEM_VALUES();
		
		listItemList = new ArrayList<PP_LIST_ITEM>();
		listItemValuesList = new ArrayList<PP_LIST_ITEM_VALUES>();
		
		instantiateAllComponents();

	}

	public HtmlInputText getCOMP_LIV_SYS_PARAM() {
		return COMP_LIV_SYS_PARAM;
	}

	public void setCOMP_LIV_SYS_PARAM(HtmlInputText comp_liv_sys_param) {
		COMP_LIV_SYS_PARAM = comp_liv_sys_param;
	}

	public HtmlInputText getCOMP_LIV_DESC() {
		return COMP_LIV_DESC;
	}

	public void setCOMP_LIV_DESC(HtmlInputText comp_liv_desc) {
		COMP_LIV_DESC = comp_liv_desc;
	}

	public HtmlInputText getCOMP_LIV_CODE() {
		return COMP_LIV_CODE;
	}

	public void setCOMP_LIV_CODE(HtmlInputText comp_liv_code) {
		COMP_LIV_CODE = comp_liv_code;
	}

	public HtmlInputText getCOMP_LIV_CODE_DESC() {
		return COMP_LIV_CODE_DESC;
	}

	public void setCOMP_LIV_CODE_DESC(HtmlInputText comp_liv_code_desc) {
		COMP_LIV_CODE_DESC = comp_liv_code_desc;
	}

	public HtmlInputText getCOMP_LIV_BL_CODE_DESC() {
		return COMP_LIV_BL_CODE_DESC;
	}

	public void setCOMP_LIV_BL_CODE_DESC(HtmlInputText comp_liv_bl_code_desc) {
		COMP_LIV_BL_CODE_DESC = comp_liv_bl_code_desc;
	}

	public HtmlInputText getCOMP_LI_MODULE_NAME() {
		return COMP_LI_MODULE_NAME;
	}

	public void setCOMP_LI_MODULE_NAME(HtmlInputText comp_li_module_name) {
		COMP_LI_MODULE_NAME = comp_li_module_name;
	}

	public HtmlInputText getCOMP_LI_BLOCK_NAME() {
		return COMP_LI_BLOCK_NAME;
	}

	public void setCOMP_LI_BLOCK_NAME(HtmlInputText comp_li_block_name) {
		COMP_LI_BLOCK_NAME = comp_li_block_name;
	}

	public HtmlInputText getCOMP_LI_ITEM_NAME() {
		return COMP_LI_ITEM_NAME;
	}

	public void setCOMP_LI_ITEM_NAME(HtmlInputText comp_li_item_name) {
		COMP_LI_ITEM_NAME = comp_li_item_name;
	}

	public HtmlInputText getCOMP_LI_SYS_PARAM() {
		return COMP_LI_SYS_PARAM;
	}

	public void setCOMP_LI_SYS_PARAM(HtmlInputText comp_li_sys_param) {
		COMP_LI_SYS_PARAM = comp_li_sys_param;
	}

	public HtmlInputText getCOMP_LI_REMARKS() {
		return COMP_LI_REMARKS;
	}

	public void setCOMP_LI_REMARKS(HtmlInputText comp_li_remarks) {
		COMP_LI_REMARKS = comp_li_remarks;
	}

	public HtmlSelectBooleanCheckbox getCOMP_LI_EXTERNAL_TABLE_YN() {
		return COMP_LI_EXTERNAL_TABLE_YN;
	}

	public void setCOMP_LI_EXTERNAL_TABLE_YN(HtmlSelectBooleanCheckbox comp_li_external_table_yn) {
		COMP_LI_EXTERNAL_TABLE_YN = comp_li_external_table_yn;
	}

	public HtmlInputText getCOMP_LI_WHERE_CLAUSE() {
		return COMP_LI_WHERE_CLAUSE;
	}

	public void setCOMP_LI_WHERE_CLAUSE(HtmlInputText comp_li_where_clause) {
		COMP_LI_WHERE_CLAUSE = comp_li_where_clause;
	}

	public HtmlInputText getCOMP_LI_DFLT_VALUE() {
		return COMP_LI_DFLT_VALUE;
	}

	public void setCOMP_LI_DFLT_VALUE(HtmlInputText comp_li_dflt_value) {
		COMP_LI_DFLT_VALUE = comp_li_dflt_value;
	}

	public PP_LIST_ITEM getPP_LIST_ITEM_BEAN() {
		return PP_LIST_ITEM_BEAN;
	}

	public void setPP_LIST_ITEM_BEAN(PP_LIST_ITEM pp_list_item_bean) {
		PP_LIST_ITEM_BEAN = pp_list_item_bean;
	}
		
	public int getCurrPage() {
		return currItemPage;
	}

	public void setCurrPage(int currPage) {
		this.currItemPage = currPage;
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
	
	public ArrayList<PP_LIST_ITEM_VALUES> getListItemValuesList() {
		return listItemValuesList;
	}

	public void setListItemValuesList(ArrayList<PP_LIST_ITEM_VALUES> listItemValuesList) {
		this.listItemValuesList = listItemValuesList;
	}
	public UIData getListItemValuesDataTable() {
		return listItemValuesDataTable;
	}

	public void setListItemValuesDataTable(UIData listItemValuesDataTable) {
		this.listItemValuesDataTable = listItemValuesDataTable;
	}
	

	public UIData getListItemDataTable() {
		return listItemDataTable;
	}

	public void setListItemDataTable(UIData listItemDataTable) {
		this.listItemDataTable = listItemDataTable;
	}

	public ArrayList<PP_LIST_ITEM> getListItemList() {
		return listItemList;
	}

	public void setListItemList(ArrayList<PP_LIST_ITEM> listItemList) {
		this.listItemList = listItemList;
	}
	
	public int getCurrItemPage() {
		return currItemPage;
	}

	public void setCurrItemPage(int currItemPage) {
		this.currItemPage = currItemPage;
	}

	public int getCurrValuePage() {
		return currValuePage;
	}

	public void setCurrValuePage(int currValuePage) {
		this.currValuePage = currValuePage;
	}

	public int getLastUpdatedValuesRowIndex() {
		return lastUpdatedValuesRowIndex;
	}

	public void setLastUpdatedValuesRowIndex(int lastUpdatedValuesRowIndex) {
		this.lastUpdatedValuesRowIndex = lastUpdatedValuesRowIndex;
	}

	public int getPrevValuesRowIndex() {
		return prevValuesRowIndex;
	}

	public void setPrevValuesRowIndex(int prevValuesRowIndex) {
		this.prevValuesRowIndex = prevValuesRowIndex;
	}
	
	public int getValuesPerPage() {
		return valuesPerPage;
	}
	
	public void setValuesPerPage(int valuesPerPage) {
		this.valuesPerPage = valuesPerPage;
	}

	public PP_LIST_ITEM_VALUES getPP_LIST_ITEM_VALUES_BEAN() {
		return PP_LIST_ITEM_VALUES_BEAN;
	}

	public void setPP_LIST_ITEM_VALUES_BEAN(
			PP_LIST_ITEM_VALUES pp_list_item_values_bean) {
		PP_LIST_ITEM_VALUES_BEAN = pp_list_item_values_bean;
	}
	
	public void onLoad(PhaseEvent event)  {
		PP_LIST_ITEM_DELEGATE delegate = new PP_LIST_ITEM_DELEGATE();
			try {
				if(isBlockFlag()){
				listItemList = delegate.fetchListItem(this);
				listItemValuesList = delegate.fetchListItemValues(this);
				setBlockFlag(false);
				}
			} catch (ValidatorException e) {
				e.printStackTrace();
				e.getMessage();
			} catch (Exception e) {
			    e.printStackTrace();
				e.getMessage();
			}
		
		}
		
	
	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
	
	public String saveAndCommit(){
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put(
					"current",
					Messages.getString(PELConstants.pelErrorMessagePath,
							"SAVE_UPDATE_MESSAGE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/*public String addRow() {
		int rowCount = 0;
		PP_LIST_ITEM addBean = null;
		if (listItemList == null) {
			listItemList = new ArrayList<PP_LIST_ITEM>();
		}
		addBean = new PP_LIST_ITEM();
		listItemList.add(addBean);
		
		rowCount = getListItemDataTable().getRowCount();
		currItemPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currItemPage++;
			getErrorMap().put("somekey", " row added.");
			getErrorMap().put("current", " row added.");
		}
		return "";
	}
*/
	
	public void addRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PP_LIST_ITEM_BEAN = new PP_LIST_ITEM();
				PP_LIST_ITEM_VALUES_BEAN = new PP_LIST_ITEM_VALUES();
				listItemValuesList.clear();
				resetAllComponent();
				resetAllChildComponent();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}
	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PP_LIST_ITEM_BEAN.getROWID() != null ) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PP_LIST_ITEM_BEAN,
							CommonUtils.getConnection());
					listItemList.remove(PP_LIST_ITEM_BEAN);
						
				}

				if (listItemList.size() > 0) {
					setPP_LIST_ITEM_BEAN(listItemList.get(0));
					PP_LIST_ITEM_BEAN.setRowSelected(true);
					
					} 
				else 
				{
					addRow(ae);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				resetAllComponent();
				resetAllChildComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}
	
	public void addChildRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PP_LIST_ITEM_VALUES_BEAN = new PP_LIST_ITEM_VALUES();
				resetAllChildComponent();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}
	public void deleteChildRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PP_LIST_ITEM_VALUES_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PP_LIST_ITEM_VALUES_BEAN,
							CommonUtils.getConnection());
					listItemValuesList.remove(PP_LIST_ITEM_VALUES_BEAN);
				}

				if (listItemValuesList.size() > 0) {
					setPP_LIST_ITEM_VALUES_BEAN(listItemValuesList.get(0));
					PP_LIST_ITEM_VALUES_BEAN.setRowSelected(true);
				} else {
					addChildRow(ae);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				resetAllChildComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}
	
	public void checkBoxStatus(ActionEvent actionEvent)
	{
		CommonUtils.clearMaps(this);
		boolean check=Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex =getListItemDataTable().getRowIndex();
		listItemList.get(rowIndex).setCheckBoxSelected(check);
	}
	
	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String)input.getSubmittedValue();
			}
		}
		return value;
	}
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
	/*public void checkBox_action(ActionEvent event){
		
			gridtabListener();
	}*/
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
	
	public String removeRow() {
		PP_LIST_ITEM bean = null;
		PP_LIST_ITEM_DELEGATE delegate = new PP_LIST_ITEM_DELEGATE();
		ArrayList<Integer> deletedRecordList = null;
		
		int deletedRecordIndex = 0;
		if (listItemList != null) {
			
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < listItemList.size();) {
				bean = (PP_LIST_ITEM)listItemList.get(index);
				
				if (bean.isCheckBoxSelected()) {
					listItemList.remove(bean);
					deletedRecordIndex = delegate.deleteListItemDetails(bean);
					deletedRecordList.add(deletedRecordIndex);

				} else {
					index++;
				}
			}
			if (deletedRecordList.size() > 0) {
				getErrorMap().put("somekey", deletedRecordList.size()+ " records deleted.");
				getErrorMap().put("current", deletedRecordList.size()+ " records deleted.");
			}
			lastUpdatedRowIndex = -1;
		}
		return "";
	}
	
	public void paramListener(ActionEvent event) {
		String oldParam = getPP_LIST_ITEM_BEAN().getLI_SYS_PARAM();
		String currentParam = (String) COMP_LI_SYS_PARAM.getSubmittedValue();

		try {
			if(currentParam != null && !currentParam.equals(oldParam)){
				getPP_LIST_ITEM_BEAN().setLI_SYS_PARAM(currentParam);
				queryListItemValues();
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGEST", e.getMessage());
		}
		resetAllChildComponent();
	}
	
	public void queryListItemValues() throws Exception {
		PP_LIST_ITEM_DELEGATE delegate = new PP_LIST_ITEM_DELEGATE();
		ArrayList<PP_LIST_ITEM_VALUES> listItemValues = null;

		try {
			listItemValues = delegate.fetchListItemValues(this);
			this.setListItemValuesList(listItemValues);
			if (listItemValues.size() > 0) {
				this.setPP_LIST_ITEM_VALUES_BEAN(listItemValues.get(0));
				this.getPP_LIST_ITEM_VALUES_BEAN().setRowSelected(true);
			}
			resetAllChildComponent();
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw new Exception(e.getFacesMessage().getSummary());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
/*
 * public String queryListItemValues(ActionEvent event) throws
 * ValidatorException, Exception { PP_LIST_ITEM bean = null; PP_LIST_ITEM_VALUES
 * valueBean = null; PP_LIST_ITEM_DELEGATE delegate = new
 * PP_LIST_ITEM_DELEGATE(); int count = 0; if (listItemList != null) {
 * 
 * for (int index = 0; index < listItemList.size();index++) { bean =
 * (PP_LIST_ITEM)listItemList.get(index); if (bean.isExtarnalCheckBox()){
 * listItemValuesList = new ArrayList<PP_LIST_ITEM_VALUES>();
 * getErrorMap().put("current", " View details is not allowed. Enter value in
 * where clause"); getErrorMap().put("somekey", " View details is not allowed.
 * Enter value in where clause"); }else{ if (bean.isCheckBoxSelected()) {
 * getErrorMap().clear(); count = count + 1; listItemValuesList =
 * delegate.fetchListItemValues(bean.getLI_SYS_PARAM()); } } }
 * 
 * }if(count>1) { listItemValuesList = new ArrayList<PP_LIST_ITEM_VALUES>();
 * getWarningMap().put("current", "Multiple selection is not allowed");
 * getWarningMap().put("somekey", "Multiple selection is not allowed");
 * 
 * }else{ getWarningMap().clear(); } return ""; }
 */
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
	/*public void gridtabListener() {
		int currRowIndex = getListItemDataTable().getRowIndex();
		PP_LIST_ITEM_DELEGATE delegate = new PP_LIST_ITEM_DELEGATE();
		int rowUpdated = 0;
		PP_LIST_ITEM detailsBean = null;
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if(currRowIndex != 0){
						if (currRowIndex != prevRowIndex) {
							detailsBean = listItemList.get(prevRowIndex);
							if (detailsBean.getROWID() != null) {
								rowUpdated = delegate.updateListItemDetails(detailsBean);
								getErrorMap().put("somekey", rowUpdated+ " record updated.");
								getErrorMap().put("current", rowUpdated+ " record updated.");
							} else {
								
								rowUpdated = delegate.updateListItemDetails(detailsBean);
								getErrorMap().put("somekey", rowUpdated+ " record inserted.");
								getErrorMap().put("current", rowUpdated+ " record inserted.");
							}
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
	
	public void getLI_MODULE_NAME(ActionEvent event){
		CommonUtils.clearMaps(this);
		String LI_MODULE_NAME = getCurrentValue(event);
//		int rowIndex = getListItemDataTable().getRowIndex(); 
//		listItemList.get(rowIndex).setLI_MODULE_NAME(LI_MODULE_NAME);
		this.getPP_LIST_ITEM_BEAN().setLI_MODULE_NAME(LI_MODULE_NAME);
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
		//gridtabListener();
	}
	
	public void getLI_BLOCK_NAME(ActionEvent event){
		CommonUtils.clearMaps(this);
		String LI_BLOCK_NAME = getCurrentValue(event);
		//int rowIndex = getListItemDataTable().getRowIndex(); 
		//listItemList.get(rowIndex).setLI_BLOCK_NAME(LI_BLOCK_NAME);
		this.getPP_LIST_ITEM_BEAN().setLI_BLOCK_NAME(LI_BLOCK_NAME);
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
		//gridtabListener();
	}
	
	public void getLI_ITEM_NAME(ActionEvent event){
		CommonUtils.clearMaps(this);
		String LI_ITEM_NAME = getCurrentValue(event);
		//int rowIndex = getListItemDataTable().getRowIndex(); 
		//listItemList.get(rowIndex).setLI_ITEM_NAME(LI_ITEM_NAME);
		this.getPP_LIST_ITEM_BEAN().setLI_ITEM_NAME(LI_ITEM_NAME);
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
		//gridtabListener();
	}
	
	public void getLI_SYS_PARAM(ActionEvent event){
		CommonUtils.clearMaps(this);
		String LI_SYS_PARAM = getCurrentValue(event);
		//int rowIndex = getListItemDataTable().getRowIndex(); 
		//listItemList.get(rowIndex).setLI_SYS_PARAM(LI_SYS_PARAM);
		this.getPP_LIST_ITEM_BEAN().setLI_SYS_PARAM(LI_SYS_PARAM);
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
		//gridtabListener();
	}
	
	public void getLI_REMARKS(ActionEvent event){
		CommonUtils.clearMaps(this);
		String LI_REMARKS = getCurrentValue(event);
		//int rowIndex = getListItemDataTable().getRowIndex(); 
		//listItemList.get(rowIndex).setLI_REMARKS(LI_REMARKS);
		this.getPP_LIST_ITEM_BEAN().setLI_REMARKS(LI_REMARKS);
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
		//gridtabListener();
	}
	
	public void getLI_WHERE_CLAUSE(ActionEvent event){
		CommonUtils.clearMaps(this);
		String LI_WHERE_CLAUSE = getCurrentValue(event);
		//int rowIndex = getListItemDataTable().getRowIndex(); 
		//listItemList.get(rowIndex).setLI_WHERE_CLAUSE(LI_WHERE_CLAUSE);
		this.getPP_LIST_ITEM_BEAN().setLI_WHERE_CLAUSE(LI_WHERE_CLAUSE);
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
		//gridtabListener();
	}
	
	public void getLIV_SYS_PARAM(ActionEvent event){
		CommonUtils.clearMaps(this);
		String LIV_SYS_PARAM = getCurrentValue(event);
		//int rowIndex = getListItemValuesDataTable().getRowIndex(); 
		//listItemValuesList.get(rowIndex).setLIV_SYS_PARAM(LIV_SYS_PARAM);
          this.getPP_LIST_ITEM_VALUES_BEAN().setLIV_SYS_PARAM(LIV_SYS_PARAM);		
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
		//gridtabListener();
	}
	
	public void getLIV_DESC(ActionEvent event){
		CommonUtils.clearMaps(this);
		String LIV_DESC = getCurrentValue(event);
		//int rowIndex = getListItemValuesDataTable().getRowIndex(); 
		//listItemValuesList.get(rowIndex).setLIV_DESC(LIV_DESC);
		this.getPP_LIST_ITEM_VALUES_BEAN().setLIV_DESC(LIV_DESC);
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
		//gridtabListener();
	}
	
	public void getLIV_CODE(ActionEvent event){
		CommonUtils.clearMaps(this);
		String LIV_CODE = getCurrentValue(event);
		//int rowIndex = getListItemValuesDataTable().getRowIndex(); 
		//listItemValuesList.get(rowIndex).setLIV_CODE(LIV_CODE);
		this.getPP_LIST_ITEM_VALUES_BEAN().setLIV_CODE(LIV_CODE);;
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
		//gridtabListener();
	}
	
	public void getLIV_CODE_DESC(ActionEvent event){
		CommonUtils.clearMaps(this);
		String LIV_CODE_DESC = getCurrentValue(event);
		//int rowIndex = getListItemValuesDataTable().getRowIndex(); 
		//listItemValuesList.get(rowIndex).setLIV_CODE_DESC(LIV_CODE_DESC);
		this.getPP_LIST_ITEM_VALUES_BEAN().setLIV_CODE_DESC(LIV_CODE_DESC);
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
		//gridtabListener();
	}
	
	public void getLI_DFLT_VALUE(ActionEvent event){
		CommonUtils.clearMaps(this);
		String LI_DFLT_VALUE = getCurrentValue(event);
		//int rowIndex = getListItemDataTable().getRowIndex(); 
		//listItemList.get(rowIndex).setLI_DFLT_VALUE(LI_DFLT_VALUE);
		this.getPP_LIST_ITEM_BEAN().setLI_DFLT_VALUE(LI_DFLT_VALUE);
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009 
		// lastColumnListenerForListItem();
	}
	
	public void lastColumnListenerForListItem()
	{
		int currRowIndex = getListItemDataTable().getRowIndex();
		PP_LIST_ITEM_DELEGATE delegate = new PP_LIST_ITEM_DELEGATE();
		int rowUpdated = 0;
		PP_LIST_ITEM gridValueBean = null;
		try {
				// Get the bean based on row index
					gridValueBean = (PP_LIST_ITEM)listItemList.get(currRowIndex);
				
					// Update the record to database
					
					if( gridValueBean.getROWID()!=null)
					{
						rowUpdated = delegate.updateListItemDetails(gridValueBean);
						getErrorMap().put("somekey", rowUpdated+" record updated.");
						getErrorMap().put("current", rowUpdated+" record updated.");
					}else
					{
						rowUpdated = delegate.updateListItemDetails(gridValueBean);
						getErrorMap().put("somekey", rowUpdated+" record inserted.");
						getErrorMap().put("current", rowUpdated+" record inserted.");
						
					}
				lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return ;
	}
	
	public void getLIV_BL_CODE_DESC(ActionEvent event){
		CommonUtils.clearMaps(this);
		String LIV_BL_CODE_DESC = getCurrentValue(event);
		//int rowIndex = getListItemValuesDataTable().getRowIndex(); 
		//listItemValuesList.get(rowIndex).setLIV_BL_CODE_DESC(LIV_BL_CODE_DESC);
		this.getPP_LIST_ITEM_VALUES_BEAN().setLIV_BL_CODE_DESC(LIV_BL_CODE_DESC);
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009 
		//lastColumnListenerForListItemValues();
	}
	
	public void lastColumnListenerForListItemValues()
	{
		int currRowIndex = getListItemValuesDataTable().getRowIndex();
		PP_LIST_ITEM_DELEGATE delegate = new PP_LIST_ITEM_DELEGATE();
		int rowUpdated = 0;
		PP_LIST_ITEM_VALUES gridValueBean = null;
		try {
				// Get the bean based on row index
				gridValueBean = (PP_LIST_ITEM_VALUES)listItemValuesList.get(currRowIndex);
				
					// Update the record to database
					
					if(gridValueBean.getROWID()!=null)
					{
						rowUpdated = delegate.updateListItemValues(gridValueBean);
						getErrorMap().put("somekey", rowUpdated+" record updated.");
						getErrorMap().put("current", rowUpdated+" record updated.");
					}else
					{
						gridValueBean.setLIV_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
						CommonUtils commonUtils =  new CommonUtils();
						gridValueBean.setLIV_CR_DT(commonUtils.getCurrentDate());
						rowUpdated = delegate.updateListItemValues(gridValueBean);
						getErrorMap().put("somekey", rowUpdated+" record inserted.");
						getErrorMap().put("current", rowUpdated+" record inserted.");
						
					}
				lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return ;
	}
	
	public String addRowForValues() {
		int rowCount = 0;
		PP_LIST_ITEM_VALUES addBean = null;
		if (listItemValuesList == null) {
			listItemValuesList = new ArrayList<PP_LIST_ITEM_VALUES>();
		}
		addBean = new PP_LIST_ITEM_VALUES();
		listItemValuesList.add(addBean);
		
		rowCount = getListItemValuesDataTable().getRowCount();
		currValuePage = rowCount / valuesPerPage;
		if (rowCount % valuesPerPage > 0) {
			currValuePage++;
			getErrorMap().put("somekey", " row added.");
			getErrorMap().put("current", " row added.");
		}
		return "";
	}

	public void checkBoxStatusForListItemValues(ActionEvent actionEvent)
	{
		CommonUtils.clearMaps(this);
		boolean check=Boolean.parseBoolean(getCurrentValueForListItemValues(actionEvent));
		int rowIndex =getListItemValuesDataTable().getRowIndex();
		listItemValuesList.get(rowIndex).setCheckBoxSelected(check);
	}
	
	public String getCurrentValueForListItemValues(ActionEvent event){
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String)input.getSubmittedValue();
			}
		}
		return value;
	}
	
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
	/*public void checkBox_actionForListItemValues(ActionEvent event){
		
			//gridtabListener();
	}*/
	
	public String removeListItemValues() {
		PP_LIST_ITEM_VALUES bean = null;
		PP_LIST_ITEM_DELEGATE delegate = new PP_LIST_ITEM_DELEGATE();
		ArrayList<Integer> deletedRecordList = null;
		
		int deletedRecordIndex = 0;
		if (listItemValuesList != null) {
			
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < listItemValuesList.size();) {
				bean = (PP_LIST_ITEM_VALUES)listItemValuesList.get(index);
				if (bean.isCheckBoxSelected()) {
					listItemValuesList.remove(bean);
					deletedRecordIndex = delegate.deleteListItemValues(bean);
					deletedRecordList.add(deletedRecordIndex);

				} else {
					index++;
				}
			}
			if (deletedRecordList.size() > 0) {
				getErrorMap().put("somekey", deletedRecordList.size()+ " records deleted.");
				getErrorMap().put("current", deletedRecordList.size()+ " records deleted.");
			}
			lastUpdatedValuesRowIndex = -1;
		}
		return "";
	}
	
	public void extarnalCheckBoxStatus(ActionEvent actionEvent)
	{
		boolean check=Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex =getListItemDataTable().getRowIndex();
		listItemList.get(rowIndex).setExtarnalCheckBox(check);
	}
	
	public String getCurrentValueForExtarnal(ActionEvent event){
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String)input.getSubmittedValue();
			}
		}
		return value;
	}
	
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
	/*public void extarnalCheckBox_action(ActionEvent event){
		
			//gridtabListener();
	}*/

	public void resetAllValues() {
		CommonUtils.clearMaps(this);
		PP_LIST_ITEM PP_LIST_ITEM_BEAN=new PP_LIST_ITEM();
		this.setPP_LIST_ITEM_BEAN( PP_LIST_ITEM_BEAN);
		
		this.setPP_LIST_ITEM_VALUES_BEAN(new PP_LIST_ITEM_VALUES());
		listItemList = new ArrayList<PP_LIST_ITEM>();
		listItemValuesList = new ArrayList<PP_LIST_ITEM_VALUES>();
		resetAllComponent();
		resetAllChildComponent();
		
	}
	
	// [ Added for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord1(){
		String outcome = null;
		int rowIndex = listItemDataTable.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListenerForListItem();
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

	// [ Added for grid implementation change, Added by: Amit Kumar, Dated: 17-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord2(){
		String outcome = null;
		int rowIndex = listItemValuesDataTable.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListenerForListItemValues();
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
      
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			if (listItemList.size() != 0) {
				PP_LIST_ITEM_BEAN= (PP_LIST_ITEM)listItemDataTable
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PP_LIST_ITEM_BEAN.setRowSelected(true);
			// Reset selection for other beans
			queryListItemValues();
			
			displayChildRecords();
		} catch (Exception exc) {
			getErrorMap()
					.put(com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	public void displayChildRecords() {
		CommonUtils.clearMaps(this);
		try {
			if (listItemValuesList.size() != 0) {
				PP_LIST_ITEM_VALUES_BEAN= (PP_LIST_ITEM_VALUES)listItemValuesDataTable
						.getRowData();
			}
			resetAllChildComponent();
			// Reset selection for other beans
			resetChildSelectedRow();
			PP_LIST_ITEM_VALUES_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap()
					.put(com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	private void resetChildSelectedRow()
	{
		Iterator<PP_LIST_ITEM_VALUES> iterator = listItemValuesList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public void instantiateAllComponents(){
		COMP_LIV_SYS_PARAM = new HtmlInputText();
		COMP_LIV_DESC = new HtmlInputText();
		COMP_LIV_CODE = new HtmlInputText();
		COMP_LIV_CODE_DESC = new HtmlInputText();
		COMP_LIV_BL_CODE_DESC = new HtmlInputText();
		
		COMP_LI_MODULE_NAME = new HtmlInputText();
		COMP_LI_BLOCK_NAME = new HtmlInputText();
		COMP_LI_ITEM_NAME = new HtmlInputText();
		COMP_LI_SYS_PARAM = new HtmlInputText();
		COMP_LI_REMARKS = new HtmlInputText();
		COMP_LI_WHERE_CLAUSE = new HtmlInputText();
		COMP_LI_DFLT_VALUE  = new HtmlInputText();
	}
	
	public void resetAllChildComponent()
	{
		COMP_LIV_SYS_PARAM.resetValue();
		COMP_LIV_DESC.resetValue();
		COMP_LIV_CODE.resetValue();
		COMP_LIV_CODE_DESC.resetValue();
		COMP_LIV_BL_CODE_DESC.resetValue();
		
	}
	
	public void resetAllComponent()
	{
		COMP_LI_MODULE_NAME.resetValue();
		COMP_LI_BLOCK_NAME.resetValue();
		COMP_LI_ITEM_NAME.resetValue();
		COMP_LI_SYS_PARAM.resetValue();
		COMP_LI_REMARKS.resetValue();
		COMP_LI_WHERE_CLAUSE.resetValue();
		COMP_LI_DFLT_VALUE .resetValue();


	}
	private void resetSelectedRow()
	{
		Iterator<PP_LIST_ITEM> iterator = listItemList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public HtmlOutputLabel getCOMP_LI_MODULE_NAME_LABEL() {
		return COMP_LI_MODULE_NAME_LABEL;
	}

	public void setCOMP_LI_MODULE_NAME_LABEL(
			HtmlOutputLabel comp_li_module_name_label) {
		COMP_LI_MODULE_NAME_LABEL = comp_li_module_name_label;
	}

	public HtmlOutputLabel getCOMP_LI_BLOCK_NAME_LABEL() {
		return COMP_LI_BLOCK_NAME_LABEL;
	}

	public void setCOMP_LI_BLOCK_NAME_LABEL(HtmlOutputLabel comp_li_block_name_label) {
		COMP_LI_BLOCK_NAME_LABEL = comp_li_block_name_label;
	}

	public HtmlOutputLabel getCOMP_LI_ITEM_NAME_LABEL() {
		return COMP_LI_ITEM_NAME_LABEL;
	}

	public void setCOMP_LI_ITEM_NAME_LABEL(HtmlOutputLabel comp_li_item_name_label) {
		COMP_LI_ITEM_NAME_LABEL = comp_li_item_name_label;
	}

	public HtmlOutputLabel getCOMP_LI_SYS_PARAM_LABEL() {
		return COMP_LI_SYS_PARAM_LABEL;
	}

	public void setCOMP_LI_SYS_PARAM_LABEL(HtmlOutputLabel comp_li_sys_param_label) {
		COMP_LI_SYS_PARAM_LABEL = comp_li_sys_param_label;
	}

	public HtmlOutputLabel getCOMP_LI_REMARKS_LABEL() {
		return COMP_LI_REMARKS_LABEL;
	}

	public void setCOMP_LI_REMARKS_LABEL(HtmlOutputLabel comp_li_remarks_label) {
		COMP_LI_REMARKS_LABEL = comp_li_remarks_label;
	}

	public HtmlOutputLabel getCOMP_LI_EXTERNAL_TABLE_YN_LABEL() {
		return COMP_LI_EXTERNAL_TABLE_YN_LABEL;
	}

	public void setCOMP_LI_EXTERNAL_TABLE_YN_LABEL(
			HtmlOutputLabel comp_li_external_table_yn_label) {
		COMP_LI_EXTERNAL_TABLE_YN_LABEL = comp_li_external_table_yn_label;
	}

	public HtmlOutputLabel getCOMP_LI_WHERE_CLAUSE_LABEL() {
		return COMP_LI_WHERE_CLAUSE_LABEL;
	}

	public void setCOMP_LI_WHERE_CLAUSE_LABEL(
			HtmlOutputLabel comp_li_where_clause_label) {
		COMP_LI_WHERE_CLAUSE_LABEL = comp_li_where_clause_label;
	}

	public HtmlOutputLabel getCOMP_LI_DFLT_VALUE_LABEL() {
		return COMP_LI_DFLT_VALUE_LABEL;
	}

	public void setCOMP_LI_DFLT_VALUE_LABEL(HtmlOutputLabel comp_li_dflt_value_label) {
		COMP_LI_DFLT_VALUE_LABEL = comp_li_dflt_value_label;
	}

	public HtmlOutputLabel getCOMP_LIV_SYS_PARAM_LABEL() {
		return COMP_LIV_SYS_PARAM_LABEL;
	}

	public void setCOMP_LIV_SYS_PARAM_LABEL(HtmlOutputLabel comp_liv_sys_param_label) {
		COMP_LIV_SYS_PARAM_LABEL = comp_liv_sys_param_label;
	}

	public HtmlOutputLabel getCOMP_LIV_DESC_LABEL() {
		return COMP_LIV_DESC_LABEL;
	}

	public void setCOMP_LIV_DESC_LABEL(HtmlOutputLabel comp_liv_desc_label) {
		COMP_LIV_DESC_LABEL = comp_liv_desc_label;
	}

	public HtmlOutputLabel getCOMP_LIV_CODE_LABEL() {
		return COMP_LIV_CODE_LABEL;
	}

	public void setCOMP_LIV_CODE_LABEL(HtmlOutputLabel comp_liv_code_label) {
		COMP_LIV_CODE_LABEL = comp_liv_code_label;
	}

	public HtmlOutputLabel getCOMP_LIV_CODE_DESC_LABEL() {
		return COMP_LIV_CODE_DESC_LABEL;
	}

	public void setCOMP_LIV_CODE_DESC_LABEL(HtmlOutputLabel comp_liv_code_desc_label) {
		COMP_LIV_CODE_DESC_LABEL = comp_liv_code_desc_label;
	}

	public HtmlOutputLabel getCOMP_LIV_BL_CODE_DESC_LABEL() {
		return COMP_LIV_BL_CODE_DESC_LABEL;
	}

	public void setCOMP_LIV_BL_CODE_DESC_LABEL(
			HtmlOutputLabel comp_liv_bl_code_desc_label) {
		COMP_LIV_BL_CODE_DESC_LABEL = comp_liv_bl_code_desc_label;
	}
	
	public void post(ActionEvent ae) {

		try {
			if (PP_LIST_ITEM_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
						new CRUDHandler().executeInsert(PP_LIST_ITEM_BEAN,
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
						new CRUDHandler().executeInsert(PP_LIST_ITEM_BEAN,
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
					listItemList.add(PP_LIST_ITEM_BEAN);
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
			PP_LIST_ITEM_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	public void postChild(ActionEvent ae) {

		try {
			if (PP_LIST_ITEM_VALUES_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
						new CRUDHandler().executeInsert(PP_LIST_ITEM_VALUES_BEAN,
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
			} 
			else 
			{

				//if(isINSERT_ALLOWED())
				//{			
					if (getPP_LIST_ITEM_VALUES_BEAN().getLIV_SYS_PARAM().equals(getPP_LIST_ITEM_BEAN().getLI_SYS_PARAM()))
			{
						new CRUDHandler().executeInsert(PP_LIST_ITEM_VALUES_BEAN,
							
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
					listItemValuesList.add(PP_LIST_ITEM_VALUES_BEAN);
				} 
				
			else 
				{
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
		
			resetAllChildComponent();
			resetChildSelectedRow();
			PP_LIST_ITEM_VALUES_BEAN.setRowSelected(true);

			}
		}
	catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	// added for LI_SYS_PARAM LOV3
	public List<LovBean> LIV_SYS_PARAM_Suggestions(Object value) {
		PP_LIST_ITEM_DELEGATE delegate = new PP_LIST_ITEM_DELEGATE();
		List<LovBean> lovBeanList = null;
		
		try {
			lovBeanList = delegate.LI_SYS_PARAM_Suggestions((String) value);
		} catch (Exception e) {
		}
		
		return lovBeanList;
	}
}

	

