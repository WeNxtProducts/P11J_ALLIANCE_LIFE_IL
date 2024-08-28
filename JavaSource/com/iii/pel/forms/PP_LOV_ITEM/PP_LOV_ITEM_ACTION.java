package com.iii.pel.forms.PP_LOV_ITEM;

import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PP_LOV_ITEM_ACTION extends CommonAction{
	
	private HtmlOutputLabel COMP_PLD_PROG_CODE_LABEL;
	
	private HtmlOutputLabel COMP_PLD_BLOCK_NAME_LABEL;
	
	private HtmlOutputLabel COMP_PLD_LOV_TITLE_LABEL;
	
	private HtmlOutputLabel COMP_PLD_LOV_TITLE_BL_LABEL;
	
	private HtmlOutputLabel COMP_PLD_LOV_SELECT_STMT_LABEL;
	
	private HtmlOutputLabel COMP_PLD_COLUMN_HEAD_LABEL;
	
	private HtmlOutputLabel COMP_PLD_FIELD_NAME_LABEL;
	
	private HtmlOutputLabel COMP_PLD_COLUMN_HEAD_BL_LABEL;
	
	private HtmlOutputLabel COMP_PLD_PARA_COL_1_LABEL;
	
	private HtmlOutputLabel COMP_PLD_PARA_COL_2_LABEL;
	
	private HtmlOutputLabel COMP_PLD_PARA_COL_3_LABEL;
	
	private HtmlOutputLabel COMP_PLD_PARA_COL_4_LABEL;
	
	private HtmlOutputLabel COMP_PLD_PARA_COL_5_LABEL;
	
	private HtmlInputText COMP_PLD_PROG_CODE ;
	
	private HtmlInputText COMP_PLD_BLOCK_NAME;

	private HtmlInputText COMP_PLD_FIELD_NAME;
	
	private HtmlInputText COMP_PLD_LOV_TITLE;
	
	private HtmlInputText COMP_PLD_LOV_TITLE_BL;
	
	private HtmlInputText COMP_PLD_LOV_SELECT_STMT;
	
	private HtmlInputText COMP_PLD_COLUMN_HEAD;
	
	private HtmlInputText COMP_PLD_COLUMN_HEAD_BL;
	
	private HtmlInputText COMP_PLD_PARA_COL_1;
	
	private HtmlInputText COMP_PLD_PARA_COL_2;
	
	private HtmlInputText COMP_PLD_PARA_COL_3;
	
	private HtmlInputText COMP_PLD_PARA_COL_4;
	
	private HtmlInputText COMP_PLD_PARA_COL_5;
	private String PLD_PROG_CODE;
	private String PLD_BLOCK_NAME;
	private String PLD_FIELD_NAME;
	private String PLD_LOV_TITLE;
	
	private String PLD_PROG_CODE_SEARCH;
	private String PLD_BLOCK_NAME_SEARCH;
	private String PLD_FIELD_NAME_SEARCH;
	
	private PP_LOV_ITEM PP_LOV_ITEM_BEAN;
	
	private UIData dataTable;
	
	private int recordsPerPage = 5;
	
	private int currPage = 1;
	
	private int lastUpdatedRowIndex;
	
	private int prevRowIndex;
	
	private ArrayList<PP_LOV_ITEM> lovDetailsList;
	
	public PP_LOV_ITEM_ACTION(){
		
		PP_LOV_ITEM_BEAN = new PP_LOV_ITEM();
		
	}

	public HtmlInputText getCOMP_PLD_PROG_CODE() {
		return COMP_PLD_PROG_CODE;
	}

	public void setCOMP_PLD_PROG_CODE(HtmlInputText COMP_PLD_PROG_CODE) {
		this.COMP_PLD_PROG_CODE = COMP_PLD_PROG_CODE;
	}

	public HtmlInputText getCOMP_PLD_BLOCK_NAME() {
		return COMP_PLD_BLOCK_NAME;
	}

	public void setCOMP_PLD_BLOCK_NAME(HtmlInputText COMP_PLD_BLOCK_NAME) {
		this.COMP_PLD_BLOCK_NAME = COMP_PLD_BLOCK_NAME;
	}

	public HtmlInputText getCOMP_PLD_FIELD_NAME() {
		return COMP_PLD_FIELD_NAME;
	}

	public void setCOMP_PLD_FIELD_NAME(HtmlInputText COMP_PLD_FIELD_NAME) {
		this.COMP_PLD_FIELD_NAME = COMP_PLD_FIELD_NAME;
	}

	public HtmlInputText getCOMP_PLD_LOV_TITLE() {
		return COMP_PLD_LOV_TITLE;
	}

	public void setCOMP_PLD_LOV_TITLE(HtmlInputText COMP_PLD_LOV_TITLE) {
		this.COMP_PLD_LOV_TITLE = COMP_PLD_LOV_TITLE;
	}

	public HtmlInputText getCOMP_PLD_LOV_TITLE_BL() {
		return COMP_PLD_LOV_TITLE_BL;
	}

	public void setCOMP_PLD_LOV_TITLE_BL(HtmlInputText COMP_PLD_LOV_TITLE_BL) {
		this.COMP_PLD_LOV_TITLE_BL = COMP_PLD_LOV_TITLE_BL;
	}

	public HtmlInputText getCOMP_PLD_LOV_SELECT_STMT() {
		return COMP_PLD_LOV_SELECT_STMT;
	}

	public void setCOMP_PLD_LOV_SELECT_STMT(HtmlInputText COMP_PLD_LOV_SELECT_STMT) {
		this.COMP_PLD_LOV_SELECT_STMT = COMP_PLD_LOV_SELECT_STMT;
	}

	public HtmlInputText getCOMP_PLD_COLUMN_HEAD() {
		return COMP_PLD_COLUMN_HEAD;
	}

	public void setCOMP_PLD_COLUMN_HEAD(HtmlInputText COMP_PLD_COLUMN_HEAD) {
		this.COMP_PLD_COLUMN_HEAD = COMP_PLD_COLUMN_HEAD;
	}

	public HtmlInputText getCOMP_PLD_COLUMN_HEAD_BL() {
		return COMP_PLD_COLUMN_HEAD_BL;
	}

	public void setCOMP_PLD_COLUMN_HEAD_BL(HtmlInputText COMP_PLD_COLUMN_HEAD_BL) {
		this.COMP_PLD_COLUMN_HEAD_BL = COMP_PLD_COLUMN_HEAD_BL;
	}

	public HtmlInputText getCOMP_PLD_PARA_COL_1() {
		return COMP_PLD_PARA_COL_1;
	}

	public void setCOMP_PLD_PARA_COL_1(HtmlInputText COMP_PLD_PARA_COL_1) {
		this.COMP_PLD_PARA_COL_1 = COMP_PLD_PARA_COL_1;
	}

	public HtmlInputText getCOMP_PLD_PARA_COL_2() {
		return COMP_PLD_PARA_COL_2;
	}

	public void setCOMP_PLD_PARA_COL_2(HtmlInputText COMP_PLD_PARA_COL_2) {
		this.COMP_PLD_PARA_COL_2 = COMP_PLD_PARA_COL_2;
	}

	public HtmlInputText getCOMP_PLD_PARA_COL_3() {
		return COMP_PLD_PARA_COL_3;
	}

	public void setCOMP_PLD_PARA_COL_3(HtmlInputText COMP_PLD_PARA_COL_3) {
		this.COMP_PLD_PARA_COL_3 = COMP_PLD_PARA_COL_3;
	}

	public HtmlInputText getCOMP_PLD_PARA_COL_4() {
		return COMP_PLD_PARA_COL_4;
	}

	public void setCOMP_PLD_PARA_COL_4(HtmlInputText COMP_PLD_PARA_COL_4) {
		this.COMP_PLD_PARA_COL_4 = COMP_PLD_PARA_COL_4;
	}

	public HtmlInputText getCOMP_PLD_PARA_COL_5() {
		return COMP_PLD_PARA_COL_5;
	}

	public void setCOMP_PLD_PARA_COL_5(HtmlInputText COMP_PLD_PARA_COL_5) {
		this.COMP_PLD_PARA_COL_5 = COMP_PLD_PARA_COL_5;
	}
	
	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public ArrayList<PP_LOV_ITEM> getLovDetailsList() {
		return lovDetailsList;
	}

	public void setLovDetailsList(ArrayList<PP_LOV_ITEM> lovDetailsList) {
		this.lovDetailsList = lovDetailsList;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	public String onLoading() throws ValidatorException, Exception {
		
		PP_LOV_ITEM_DELEGATE delegate = new PP_LOV_ITEM_DELEGATE(); 
		
		if(PP_LOV_ITEM_BEAN.getPLD_PROG_CODE()!= null)
		{
			lovDetailsList =  delegate.fetchValueForLov(this);
		}
		return "";
	}
	
	public String addRow() {
		int rowCount = 0;
		PP_LOV_ITEM addBean = null;
		if (lovDetailsList == null) {
			lovDetailsList = new ArrayList<PP_LOV_ITEM>();
		}
		addBean = new PP_LOV_ITEM();
		lovDetailsList.add(addBean);
		
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
			getErrorMap().put("somekey", " row added.");
			getErrorMap().put("current", " row added.");
		}
		return "";
	}

	public void checkBoxStatus(ActionEvent actionEvent)
	{
		CommonUtils.clearMaps(this);
		boolean check=Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex =getDataTable().getRowIndex();
		lovDetailsList.get(rowIndex).setCheckBoxSelected(check);
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
	
	public void checkBox_action(ActionEvent event){
			//gridtabListener();
		CommonUtils.clearMaps(this);
		boolean check=Boolean.parseBoolean(getCurrentValue(event));
		int rowIndex =getDataTable().getRowIndex();
		lovDetailsList.get(rowIndex).setCheckBoxSelected(check);
	}
	
	public String removeRow() {
		PP_LOV_ITEM bean = null;
		PP_LOV_ITEM_DELEGATE delegate = new PP_LOV_ITEM_DELEGATE();
		ArrayList<Integer> deletedRecordList = null;
		
		int deletedRecordIndex = 0;
		if (lovDetailsList != null) {
			
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < lovDetailsList.size();) {
				bean = (PP_LOV_ITEM)lovDetailsList.get(index);
				if (bean.isCheckBoxSelected()) {
					lovDetailsList.remove(bean);
					deletedRecordIndex = delegate.deleteLovDetails(bean);
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
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 16-Feb-2009 ]
	/*public void gridtabListener() {
		int currRowIndex = getDataTable().getRowIndex();
		PP_LOV_ITEM_DELEGATE delegate = new PP_LOV_ITEM_DELEGATE();
		int rowUpdated = 0;
		PP_LOV_ITEM detailsBean = null;
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if(currRowIndex != 0){
						if (currRowIndex != prevRowIndex) {
							detailsBean = lovDetailsList.get(prevRowIndex);
							if (detailsBean.getROWID() != null) {
								rowUpdated = delegate.updateLovDetails(detailsBean);
								getErrorMap().put("somekey", rowUpdated+ " record updated.");
								getErrorMap().put("current", rowUpdated+ " record updated.");
							} else {
								
								//TODO REMOVE HARDCODE
								detailsBean.setPLD_CR_UID("LIFEALL");
								detailsBean.setPLD_LOV_NO_OF_COLUMN(3.0);
								
								rowUpdated = delegate.updateLovDetails(detailsBean);
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
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 16-Feb-2009 ]
	public void getPLD_PROG_CODE(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_PROG_CODE = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
	//	lovDetailsList.get(rowIndex).setPLD_PROG_CODE(PLD_PROG_CODE);
		this.getPP_LOV_ITEM_BEAN().setPLD_PROG_CODE(PLD_PROG_CODE);
		//gridtabListener();
	}
	
	public void getPLD_BLOCK_NAME(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_BLOCK_NAME = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
		//lovDetailsList.get(rowIndex).setPLD_BLOCK_NAME(PLD_BLOCK_NAME);
		this.getPP_LOV_ITEM_BEAN().setPLD_BLOCK_NAME(PLD_BLOCK_NAME);
		//gridtabListener();
	}
	
	public void getPLD_FIELD_NAME(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_FIELD_NAME = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
		//lovDetailsList.get(rowIndex).setPLD_FIELD_NAME(PLD_FIELD_NAME);
	    this.getPP_LOV_ITEM_BEAN().setPLD_FIELD_NAME(PLD_FIELD_NAME);
		//	gridtabListener();
	}
	
	public void getPLD_LOV_TITLE(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_LOV_TITLE = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
		//lovDetailsList.get(rowIndex).setPLD_LOV_TITLE(PLD_LOV_TITLE);
		this.getPP_LOV_ITEM_BEAN().setPLD_LOV_TITLE(PLD_LOV_TITLE);
		//gridtabListener();
	}
	
	public void getPLD_LOV_TITLE_BL(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_LOV_TITLE_BL = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
		//lovDetailsList.get(rowIndex).setPLD_LOV_TITLE_BL(PLD_LOV_TITLE_BL);
		this.getPP_LOV_ITEM_BEAN().setPLD_LOV_TITLE_BL(PLD_LOV_TITLE_BL);
		//gridtabListener();
	}
	
	public void getPLD_LOV_SELECT_STMT(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_LOV_SELECT_STMT = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
		//lovDetailsList.get(rowIndex).setPLD_LOV_SELECT_STMT(PLD_LOV_SELECT_STMT);
		this.getPP_LOV_ITEM_BEAN().setPLD_LOV_SELECT_STMT(PLD_LOV_SELECT_STMT);
		//gridtabListener();
	}
	
	public void getPLD_COLUMN_HEAD(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_COLUMN_HEAD = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
		//lovDetailsList.get(rowIndex).setPLD_COLUMN_HEAD(PLD_COLUMN_HEAD);
		this.getPP_LOV_ITEM_BEAN().setPLD_COLUMN_HEAD(PLD_COLUMN_HEAD);
		//gridtabListener();
	}
	
	public void getPLD_COLUMN_HEAD_BL(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_COLUMN_HEAD_BL = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
		//lovDetailsList.get(rowIndex).setPLD_COLUMN_HEAD_BL(PLD_COLUMN_HEAD_BL);
		this.getPP_LOV_ITEM_BEAN().setPLD_COLUMN_HEAD_BL(PLD_COLUMN_HEAD_BL);
		//gridtabListener();
	}
	
	public void getPLD_PARA_COL_1(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_PARA_COL_1 = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
		//lovDetailsList.get(rowIndex).setPLD_PARA_COL_1(PLD_PARA_COL_1);
		this.getPP_LOV_ITEM_BEAN().setPLD_PARA_COL_1(PLD_PARA_COL_1);
		//gridtabListener();
	}
	
	public void getPLD_PARA_COL_2(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_PARA_COL_2 = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
		//lovDetailsList.get(rowIndex).setPLD_PARA_COL_2(PLD_PARA_COL_2);
		this.getPP_LOV_ITEM_BEAN().setPLD_PARA_COL_2(PLD_PARA_COL_2);
		//gridtabListener();
	}
	
	public void getPLD_PARA_COL_3(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_PARA_COL_3 = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
		//lovDetailsList.get(rowIndex).setPLD_PARA_COL_3(PLD_PARA_COL_3);
		this.getPP_LOV_ITEM_BEAN().setPLD_PARA_COL_3(PLD_PARA_COL_3);
		//gridtabListener();
	}
	
	public void getPLD_PARA_COL_4(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_PARA_COL_4 = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
		//lovDetailsList.get(rowIndex).setPLD_PARA_COL_4(PLD_PARA_COL_4);
		this.getPP_LOV_ITEM_BEAN().setPLD_PARA_COL_4(PLD_PARA_COL_4);
		//gridtabListener();
	}

	public void getPLD_PARA_COL_5(ActionEvent event){
		CommonUtils.clearMaps(this);
		String PLD_PARA_COL_5 = getCurrentValue(event);
		//int rowIndex = getDataTable().getRowIndex(); 
		//lovDetailsList.get(rowIndex).setPLD_PARA_COL_5(PLD_PARA_COL_5);
		this.getPP_LOV_ITEM_BEAN().setPLD_PARA_COL_5(PLD_PARA_COL_5);
		//lastColumnListener();
	}
	
	public void lastColumnListener()
	{
		int currRowIndex = getDataTable().getRowIndex();
		PP_LOV_ITEM_DELEGATE delegate = new PP_LOV_ITEM_DELEGATE();
		int rowUpdated = 0;
		PP_LOV_ITEM gridValueBean = null;
		try {
				// Get the bean based on row index
				gridValueBean = (PP_LOV_ITEM)lovDetailsList.get(currRowIndex);
				
					// Update the record to database
				System.out.println("RO:::::::::::::::::::::::::"+lovDetailsList.get(0).getROWID());
				System.out.println("R:::::::::::::::::::::::::"+gridValueBean.getROWID());
					
					if(gridValueBean.getROWID()!=null)
					{
						rowUpdated = delegate.updateLovDetails(gridValueBean);
						getErrorMap().put("somekey", rowUpdated+" record updated.");
						getErrorMap().put("current", rowUpdated+" record updated.");
					}else
					{
						CommonUtils commonUtils =  new CommonUtils();
						ControlBean bean = CommonUtils.getControlBean();
						//TODO REMOVE HARDCODE
						gridValueBean.setPLD_CR_UID(bean.getM_USER_ID());
						gridValueBean.setPLD_LOV_NO_OF_COLUMN(3.0);
						
						gridValueBean.setPLD_CR_DT(commonUtils.getCurrentDate());
						rowUpdated = delegate.updateLovDetails(gridValueBean);
						getErrorMap().put("somekey", rowUpdated+" record inserted.");
						getErrorMap().put("current", rowUpdated+" record inserted.");
						
					}
				lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return ;
	}
	
	public String saveAndCommit(){
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath,
			"SAVE_UPDATE_MESSAGE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String backToSearch(){
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion("PP_LOV_ITEM_SEARCH_ACTION", "fetchSearchList");
		return "backToSearch";
	}

	public void resetValues() {
		lovDetailsList = new ArrayList<PP_LOV_ITEM>();
		PP_LOV_ITEM_BEAN = new PP_LOV_ITEM();
		//resetAllComponent();
	}

	public PP_LOV_ITEM getPP_LOV_ITEM_BEAN() {
		return PP_LOV_ITEM_BEAN;
	}

	public void setPP_LOV_ITEM_BEAN(PP_LOV_ITEM pp_lov_item_bean) {
		PP_LOV_ITEM_BEAN = pp_lov_item_bean;
	}
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 16-Feb-2009 ] 
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
// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 16-Feb-2009 ]

	public HtmlOutputLabel getCOMP_PLD_PROG_CODE_LABEL() {
		return COMP_PLD_PROG_CODE_LABEL;
	}

	public void setCOMP_PLD_PROG_CODE_LABEL(HtmlOutputLabel comp_pld_prog_code_label) {
		COMP_PLD_PROG_CODE_LABEL = comp_pld_prog_code_label;
	}

	public HtmlOutputLabel getCOMP_PLD_BLOCK_NAME_LABEL() {
		return COMP_PLD_BLOCK_NAME_LABEL;
	}

	public void setCOMP_PLD_BLOCK_NAME_LABEL(
			HtmlOutputLabel comp_pld_block_name_label) {
		COMP_PLD_BLOCK_NAME_LABEL = comp_pld_block_name_label;
	}

	public HtmlOutputLabel getCOMP_PLD_LOV_TITLE_LABEL() {
		return COMP_PLD_LOV_TITLE_LABEL;
	}

	public void setCOMP_PLD_LOV_TITLE_LABEL(HtmlOutputLabel comp_pld_lov_title_label) {
		COMP_PLD_LOV_TITLE_LABEL = comp_pld_lov_title_label;
	}

	public HtmlOutputLabel getCOMP_PLD_LOV_TITLE_BL_LABEL() {
		return COMP_PLD_LOV_TITLE_BL_LABEL;
	}

	public void setCOMP_PLD_LOV_TITLE_BL_LABEL(
			HtmlOutputLabel comp_pld_lov_title_bl_label) {
		COMP_PLD_LOV_TITLE_BL_LABEL = comp_pld_lov_title_bl_label;
	}

	public HtmlOutputLabel getCOMP_PLD_LOV_SELECT_STMT_LABEL() {
		return COMP_PLD_LOV_SELECT_STMT_LABEL;
	}

	public void setCOMP_PLD_LOV_SELECT_STMT_LABEL(
			HtmlOutputLabel comp_pld_lov_select_stmt_label) {
		COMP_PLD_LOV_SELECT_STMT_LABEL = comp_pld_lov_select_stmt_label;
	}

	public HtmlOutputLabel getCOMP_PLD_COLUMN_HEAD_LABEL() {
		return COMP_PLD_COLUMN_HEAD_LABEL;
	}

	public void setCOMP_PLD_COLUMN_HEAD_LABEL(
			HtmlOutputLabel comp_pld_column_head_label) {
		COMP_PLD_COLUMN_HEAD_LABEL = comp_pld_column_head_label;
	}

	public HtmlOutputLabel getCOMP_PLD_FIELD_NAME_LABEL() {
		return COMP_PLD_FIELD_NAME_LABEL;
	}

	public void setCOMP_PLD_FIELD_NAME_LABEL(
			HtmlOutputLabel comp_pld_field_name_label) {
		COMP_PLD_FIELD_NAME_LABEL = comp_pld_field_name_label;
	}

	public HtmlOutputLabel getCOMP_PLD_COLUMN_HEAD_BL_LABEL() {
		return COMP_PLD_COLUMN_HEAD_BL_LABEL;
	}

	public void setCOMP_PLD_COLUMN_HEAD_BL_LABEL(
			HtmlOutputLabel comp_pld_column_head_bl_label) {
		COMP_PLD_COLUMN_HEAD_BL_LABEL = comp_pld_column_head_bl_label;
	}

	public HtmlOutputLabel getCOMP_PLD_PARA_COL_1_LABEL() {
		return COMP_PLD_PARA_COL_1_LABEL;
	}

	public void setCOMP_PLD_PARA_COL_1_LABEL(
			HtmlOutputLabel comp_pld_para_col_1_label) {
		COMP_PLD_PARA_COL_1_LABEL = comp_pld_para_col_1_label;
	}

	public HtmlOutputLabel getCOMP_PLD_PARA_COL_2_LABEL() {
		return COMP_PLD_PARA_COL_2_LABEL;
	}

	public void setCOMP_PLD_PARA_COL_2_LABEL(
			HtmlOutputLabel comp_pld_para_col_2_label) {
		COMP_PLD_PARA_COL_2_LABEL = comp_pld_para_col_2_label;
	}

	public HtmlOutputLabel getCOMP_PLD_PARA_COL_3_LABEL() {
		return COMP_PLD_PARA_COL_3_LABEL;
	}

	public void setCOMP_PLD_PARA_COL_3_LABEL(
			HtmlOutputLabel comp_pld_para_col_3_label) {
		COMP_PLD_PARA_COL_3_LABEL = comp_pld_para_col_3_label;
	}

	public HtmlOutputLabel getCOMP_PLD_PARA_COL_4_LABEL() {
		return COMP_PLD_PARA_COL_4_LABEL;
	}

	public void setCOMP_PLD_PARA_COL_4_LABEL(
			HtmlOutputLabel comp_pld_para_col_4_label) {
		COMP_PLD_PARA_COL_4_LABEL = comp_pld_para_col_4_label;
	}

	public HtmlOutputLabel getCOMP_PLD_PARA_COL_5_LABEL() {
		return COMP_PLD_PARA_COL_5_LABEL;
	}

	public void setCOMP_PLD_PARA_COL_5_LABEL(
			HtmlOutputLabel comp_pld_para_col_5_label) {
		COMP_PLD_PARA_COL_5_LABEL = comp_pld_para_col_5_label;
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
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			if (lovDetailsList.size() != 0) {
				PP_LOV_ITEM_BEAN = (PP_LOV_ITEM) dataTable
						.getRowData();
			}
			resetAllComponent();
			// Reset selection for other beans
			resetSelectedRow();
			PP_LOV_ITEM_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap()
					.put(com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	private void resetSelectedRow() {
		Iterator<PP_LOV_ITEM> iterator = lovDetailsList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	public void resetAllComponent() {
		COMP_PLD_PROG_CODE.resetValue();
		COMP_PLD_BLOCK_NAME.resetValue();
		COMP_PLD_LOV_TITLE.resetValue();
		COMP_PLD_LOV_TITLE_BL.resetValue();
		COMP_PLD_LOV_SELECT_STMT.resetValue();
		COMP_PLD_COLUMN_HEAD.resetValue();
		COMP_PLD_FIELD_NAME.resetValue();
		COMP_PLD_COLUMN_HEAD_BL.resetValue();
		COMP_PLD_PARA_COL_1.resetValue();
		COMP_PLD_PARA_COL_2.resetValue();
		COMP_PLD_PARA_COL_3.resetValue();
		COMP_PLD_PARA_COL_4.resetValue();
		COMP_PLD_PARA_COL_5.resetValue();

	}
	
	public void addRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PP_LOV_ITEM_BEAN = new PP_LOV_ITEM();
				resetAllComponent();
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
				if (PP_LOV_ITEM_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PP_LOV_ITEM_BEAN,
							CommonUtils.getConnection());
					lovDetailsList.remove(PP_LOV_ITEM_BEAN);
				}

				if (lovDetailsList.size() > 0) {
					setPP_LOV_ITEM_BEAN(lovDetailsList.get(0));
					PP_LOV_ITEM_BEAN.setRowSelected(true);
				} else {
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

	public void post(ActionEvent ae) {

		try {
			if (PP_LOV_ITEM_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
//					pre_update();
					new CRUDHandler().executeInsert(PP_LOV_ITEM_BEAN,
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
	//				pre_insert(this.PP_LOV_ITEM_BEAN);
					new CRUDHandler().executeInsert(PP_LOV_ITEM_BEAN,
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
					lovDetailsList.add(PP_LOV_ITEM_BEAN);
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
			PP_LOV_ITEM_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	public String fetchSearchList() throws ValidatorException, Exception{
		PP_LOV_ITEM_DELEGATE delegate = new PP_LOV_ITEM_DELEGATE();
		lovDetailsList = delegate.fetchlovList1(this);
		if (lovDetailsList.size() == 0) {
			getWarningMap().put("current",
					Messages.getString("messageProperties_PP_LOV_ITEM",

					"PGIM_LOV_DEFN$SEARCH$NORECORD$MESSAGE"));
		} else {
			getWarningMap().clear();
		}
		return null;
	}

	public void beforePhase(PhaseEvent event){
		
	}

	public String getPLD_PROG_CODE_SEARCH() {
		return PLD_PROG_CODE_SEARCH;
	}

	public void setPLD_PROG_CODE_SEARCH(String pld_prog_code_search) {
		PLD_PROG_CODE_SEARCH = pld_prog_code_search;
	}

	public String getPLD_BLOCK_NAME_SEARCH() {
		return PLD_BLOCK_NAME_SEARCH;
	}

	public void setPLD_BLOCK_NAME_SEARCH(String pld_block_name_search) {
		PLD_BLOCK_NAME_SEARCH = pld_block_name_search;
	}

	public String getPLD_FIELD_NAME_SEARCH() {
		return PLD_FIELD_NAME_SEARCH;
	}

	public void setPLD_FIELD_NAME_SEARCH(String pld_field_name_search) {
		PLD_FIELD_NAME_SEARCH = pld_field_name_search;
	}

	public String getPLD_PROG_CODE() {
		return PLD_PROG_CODE;
	}

	public void setPLD_PROG_CODE(String pld_prog_code) {
		PLD_PROG_CODE = pld_prog_code;
	}

	public String getPLD_BLOCK_NAME() {
		return PLD_BLOCK_NAME;
	}

	public void setPLD_BLOCK_NAME(String pld_block_name) {
		PLD_BLOCK_NAME = pld_block_name;
	}

	public String getPLD_FIELD_NAME() {
		return PLD_FIELD_NAME;
	}

	public void setPLD_FIELD_NAME(String pld_field_name) {
		PLD_FIELD_NAME = pld_field_name;
	}

	public String getPLD_LOV_TITLE() {
		return PLD_LOV_TITLE;
	}

	public void setPLD_LOV_TITLE(String pld_lov_title) {
		PLD_LOV_TITLE = pld_lov_title;
	}

}
