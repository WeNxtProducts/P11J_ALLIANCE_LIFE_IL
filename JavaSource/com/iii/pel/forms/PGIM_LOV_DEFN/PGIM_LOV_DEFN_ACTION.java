package com.iii.pel.forms.PGIM_LOV_DEFN;

import java.util.ArrayList;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ActionEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PGIM_LOV_DEFN_ACTION extends CommonAction{
	

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
	
	private PGIM_LOV_DEFN PGIM_LOV_DEFN_BEAN;
	
	private UIData dataTable;
	
	private int recordsPerPage = 7;
	
	private int currPage = 1;
	
	private int lastUpdatedRowIndex;
	
	private int prevRowIndex;
	
	private ArrayList<PGIM_LOV_DEFN> lovDetailsList;
	
	public PGIM_LOV_DEFN_ACTION(){
		
		PGIM_LOV_DEFN_BEAN = new PGIM_LOV_DEFN();
		
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
	
	public PGIM_LOV_DEFN getPGIM_LOV_DEFN_BEAN() {
		return PGIM_LOV_DEFN_BEAN;
	}
	
	public void setPGIM_LOV_DEFN_BEAN(PGIM_LOV_DEFN PGIM_LOV_DEFN_BEAN) {
		this.PGIM_LOV_DEFN_BEAN = PGIM_LOV_DEFN_BEAN;
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

	public ArrayList<PGIM_LOV_DEFN> getLovDetailsList() {
		return lovDetailsList;
	}

	public void setLovDetailsList(ArrayList<PGIM_LOV_DEFN> lovDetailsList) {
		this.lovDetailsList = lovDetailsList;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	public String onLoading() {
		
		PGIM_LOV_DEFN_DELEGATE delegate = new PGIM_LOV_DEFN_DELEGATE(); 
		
		if(PGIM_LOV_DEFN_BEAN.getPLD_PROG_CODE()!= null)
		{
			lovDetailsList =  delegate.fetchValueForLov(this);
		}
		return null;
	}
	
	public String addRow() {
		int rowCount = 0;
		PGIM_LOV_DEFN addBean = null;
		if (lovDetailsList == null) {
			lovDetailsList = new ArrayList<PGIM_LOV_DEFN>();
		}
		addBean = new PGIM_LOV_DEFN();
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
		
			gridtabListener();
	}
	
	public String removeRow() {
		PGIM_LOV_DEFN bean = null;
		PGIM_LOV_DEFN_DELEGATE delegate = new PGIM_LOV_DEFN_DELEGATE();
		ArrayList<Integer> deletedRecordList = null;
		
		int deletedRecordIndex = 0;
		if (lovDetailsList != null) {
			
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < lovDetailsList.size();) {
				bean = (PGIM_LOV_DEFN)lovDetailsList.get(index);
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
	
	public void gridtabListener() {
		int currRowIndex = getDataTable().getRowIndex();
		PGIM_LOV_DEFN_DELEGATE delegate = new PGIM_LOV_DEFN_DELEGATE();
		int rowUpdated = 0;
		PGIM_LOV_DEFN detailsBean = null;
		CommonUtils commonUtils = new CommonUtils();
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
								
								detailsBean.setPLD_LOV_NO_OF_COLUMN(3.0);
								
								//[ Removed Hard coded user id and add created date: added by: Shankar bodduluri Dated: 19-Mar-2009 ]								
								detailsBean.setPLD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
								detailsBean.setPLD_CR_DT(commonUtils.getCurrentDate());
								
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
	}
	
	public void getPLD_PROG_CODE(ActionEvent event){
		String PLD_PROG_CODE = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_PROG_CODE(PLD_PROG_CODE);
		gridtabListener();
	}
	
	public void getPLD_BLOCK_NAME(ActionEvent event){
		String PLD_BLOCK_NAME = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_BLOCK_NAME(PLD_BLOCK_NAME);
		gridtabListener();
	}
	
	public void getPLD_FIELD_NAME(ActionEvent event){
		String PLD_FIELD_NAME = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_FIELD_NAME(PLD_FIELD_NAME);
		gridtabListener();
	}
	
	public void getPLD_LOV_TITLE(ActionEvent event){
		String PLD_LOV_TITLE = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_LOV_TITLE(PLD_LOV_TITLE);
		gridtabListener();
	}
	
	public void getPLD_LOV_TITLE_BL(ActionEvent event){
		String PLD_LOV_TITLE_BL = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_LOV_TITLE_BL(PLD_LOV_TITLE_BL);
		gridtabListener();
	}
	
	public void getPLD_LOV_SELECT_STMT(ActionEvent event){
		String PLD_LOV_SELECT_STMT = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_LOV_SELECT_STMT(PLD_LOV_SELECT_STMT);
		gridtabListener();
	}
	
	public void getPLD_COLUMN_HEAD(ActionEvent event){
		String PLD_COLUMN_HEAD = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_COLUMN_HEAD(PLD_COLUMN_HEAD);
		gridtabListener();
	}
	
	public void getPLD_COLUMN_HEAD_BL(ActionEvent event){
		String PLD_COLUMN_HEAD_BL = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_COLUMN_HEAD_BL(PLD_COLUMN_HEAD_BL);
		gridtabListener();
	}
	
	public void getPLD_PARA_COL_1(ActionEvent event){
		String PLD_PARA_COL_1 = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_PARA_COL_1(PLD_PARA_COL_1);
		gridtabListener();
	}
	
	public void getPLD_PARA_COL_2(ActionEvent event){
		String PLD_PARA_COL_2 = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_PARA_COL_2(PLD_PARA_COL_2);
		gridtabListener();
	}
	
	public void getPLD_PARA_COL_3(ActionEvent event){
		String PLD_PARA_COL_3 = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_PARA_COL_3(PLD_PARA_COL_3);
		gridtabListener();
	}
	
	public void getPLD_PARA_COL_4(ActionEvent event){
		String PLD_PARA_COL_4 = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_PARA_COL_4(PLD_PARA_COL_4);
		gridtabListener();
	}

	public void getPLD_PARA_COL_5(ActionEvent event){
		String PLD_PARA_COL_5 = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex(); 
		lovDetailsList.get(rowIndex).setPLD_PARA_COL_5(PLD_PARA_COL_5);
		lastColumnListener();
	}
	
	public void lastColumnListener()
	{
		int currRowIndex = getDataTable().getRowIndex();
		PGIM_LOV_DEFN_DELEGATE delegate = new PGIM_LOV_DEFN_DELEGATE();
		int rowUpdated = 0;
		PGIM_LOV_DEFN gridValueBean = null;
		try {
				// Get the bean based on row index
				gridValueBean = (PGIM_LOV_DEFN)lovDetailsList.get(currRowIndex);
				
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
						gridValueBean.setPLD_LOV_NO_OF_COLUMN(3.0);
						//[ Removed Hard coded user id and add created date: added by: Shankar bodduluri Dated: 19-Mar-2009 ]								
						gridValueBean.setPLD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String backToSearch(){
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion("PGIM_LOV_DEFN_SEARCH_ACTION", "fetchlovList");
		return "backToSearch";
	}

	public void resetValues() {
		lovDetailsList = new ArrayList<PGIM_LOV_DEFN>();
	}
}
