package com.iii.pel.forms.PILT005;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class DataGridAction {
	
	private UIData dataTable;
	
	private ArrayList<PT_IL_LOAN_REPAYMENT> dataTableList;

	private HtmlCommandButton commandButton;
	
	private HtmlOutputText notificationArea;
	
	private int prevRowIndex;
	
	List resultList;
	
	DataGridDelegate dataGridDelegate;
	
	private int currPage;
	
	private int recordsPerPage = 5;
	
	ArrayList deletedIndexList ;
	
	private int lastUpdatedRowIndex;
	
	private String errorMessages;
	
	private Map<String, String> errorMap = new HashMap<String, String>();

	public DataGridAction() {
		deletedIndexList = new ArrayList();
		dataTableList = new ArrayList<PT_IL_LOAN_REPAYMENT>();
		dataGridDelegate = new DataGridDelegate();
		resultList = new ArrayList();
				
		try {
			resultList = dataGridDelegate.getValues();
			for(int index = 0; index<resultList.size(); index++)
			{
				PT_IL_LOAN_REPAYMENT gridValueBean = (PT_IL_LOAN_REPAYMENT)resultList.get(index);
				dataTableList.add(gridValueBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		prevRowIndex = 0;
		currPage = 1;
	}

	

	

	public ArrayList getDataTableList() {
		return dataTableList;
	}
	
	
	public void setDataTableList(ArrayList<PT_IL_LOAN_REPAYMENT> dataTableList) {
		this.dataTableList = dataTableList;
	}
	
	public void addRow(ActionEvent event)
	{
		dataTableList.add(new PT_IL_LOAN_REPAYMENT());
	}
	
	

	public void gridtabListener(){
		
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PT_IL_LOAN_REPAYMENT gridValueBean = null;
		System.out.println(lastUpdatedRowIndex+"   "+currRowIndex+"  "+prevRowIndex);
		try {
			if(lastUpdatedRowIndex!=-1)
			{
				if(lastUpdatedRowIndex!=prevRowIndex)
				{
					if(currRowIndex != prevRowIndex){
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PT_IL_LOAN_REPAYMENT)dataTableList.get(prevRowIndex);
						
							// Update the record to database
							if(gridValueBean.getROWID()!=null)
							{
								rowUpdated = dataGridDelegate.updateData(gridValueBean);
								errorMap.put("somekey", rowUpdated+" record updated.");
								errorMap.put("current", rowUpdated+" record updated.");
							}else
							{
//								gridValueBean.setRSA_PLAN_CODE("dee");
								rowUpdated = dataGridDelegate.updateData(gridValueBean);
								errorMap.put("somekey", rowUpdated+" record inserted.");
								errorMap.put("current", rowUpdated+" record inserted.");
								
							}
						
						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			e1.printStackTrace();
		}
		
		return ;
	}
	
	public void lastColumnListener()
	{
		System.out.println("LAST COLUMN LISTENER...............");
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PT_IL_LOAN_REPAYMENT gridValueBean = null;
		
		try {
			
				// Get the bean based on row index
				gridValueBean = (PT_IL_LOAN_REPAYMENT)dataTableList.get(currRowIndex);
				
					// Update the record to database
					if(gridValueBean.getROWID()!=null)
					{
						rowUpdated = dataGridDelegate.updateData(gridValueBean);
						errorMap.put("somekey", rowUpdated+" record updated.");
						errorMap.put("current", rowUpdated+" record updated.");
					}else
					{
//						gridValueBean.setRSA_PLAN_CODE("dee");
						rowUpdated = dataGridDelegate.updateData(gridValueBean);
						errorMap.put("somekey", rowUpdated+" record inserted.");
						errorMap.put("current", rowUpdated+" record inserted.");
						
					}
				
				lastUpdatedRowIndex = currRowIndex;
				
			
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			e1.printStackTrace();
		}
		
		return ;
	
	}
	
	public void checkBoxValidation(ActionEvent event)
	{
		gridtabListener();
	}
	
	
	public void yearsFromValidation(ActionEvent actionEvent)
	{
		getCurrentValue(actionEvent);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		
		
	}
	public void yearsToValidation(ActionEvent actionEvent)
	{
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());	
	}
	
	public void periodFromValidation(ActionEvent actionEvent)
	{
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String value = (String) inputText.getSubmittedValue();
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else
		{
			int rowIndex = getDataTable().getRowIndex();
//			dataTableList.get(rowIndex).setRSA_PERIOD_FROM(Double.parseDouble(value));
			gridtabListener();
		}
		
	}
	
	public void periodToValidation(ActionEvent actionEvent)
	{
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String value = (String) inputText.getSubmittedValue();
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else
		{
			int rowIndex = getDataTable().getRowIndex();
//			dataTableList.get(rowIndex).setRSA_PERIOD_TO(Double.parseDouble(value));
			gridtabListener();
		}
		
	}
	
	public void RIRateValidation(ActionEvent actionEvent)
	{
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String value = (String) inputText.getSubmittedValue();
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else
		{
			int rowIndex = getDataTable().getRowIndex();
//			dataTableList.get(rowIndex).setRSA_RI_RATE(Double.parseDouble(value));
			gridtabListener();
		}
		
	}
	
	public void CqsRateValidation(ActionEvent actionEvent)
	{
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String value = (String) inputText.getSubmittedValue();
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else
		{
			int rowIndex = getDataTable().getRowIndex();
//			dataTableList.get(rowIndex).setRSA_CQS_RATE(Double.parseDouble(value));
			gridtabListener();
		}
		
	}
	
	public void ratePerValidation(ActionEvent actionEvent)
	{
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String value = (String) inputText.getSubmittedValue();
		System.out.println("Last column value:"+value);
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else
		{
			int rowIndex = getDataTable().getRowIndex();
//			dataTableList.get(rowIndex).setRSA_RATE_PER(Double.parseDouble(value));
			lastColumnListener();
		}
		
	}
	
	
	
	public String addNew(){
		int rowCount = 0;
		
		if(dataTableList == null){
			dataTableList = new ArrayList<PT_IL_LOAN_REPAYMENT>();
		}
		dataTableList.add(new PT_IL_LOAN_REPAYMENT());
		
		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
		currPage = rowCount/recordsPerPage;
		if(rowCount%recordsPerPage>0){
			currPage++;
		}
		
		return "newadded";
	}

	public String checkBoxStatus(ActionEvent actionEvent)
	{
		getCurrentValue(actionEvent);
		System.out.println("Comming to check box status");
		return "";
	}
	
	public String deleteRow()
	{
		PT_IL_LOAN_REPAYMENT bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		if(dataTableList!=null)
		{
			deletedRecordList = new ArrayList();
			for(int index =0; index<dataTableList.size();)
			{
				bean = dataTableList.get(index);
				/*if(bean.isCHECK_BOX()){
					dataTableList.remove(bean);
					deletedRecordIndex = dataGridDelegate.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
					
				}else
				{
					index++;
				}*/
			}
			
			if(deletedRecordList.size()>0)
			{
				errorMap.put("somekey", deletedRecordList.size()+" records deleted.");
				errorMap.put("current", deletedRecordList.size()+" records deleted.");
			}
			lastUpdatedRowIndex = -1;
			
		}
		
		return "";
	}
	
	public String combinedSave()
	{
		dataGridDelegate.saveData(this);			
		return null;
	}

	
	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
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


	public int getRecordsPerPage() {
		return recordsPerPage;
	}


	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}


	public HtmlOutputText getNotificationArea() {
		return notificationArea;
	}


	public void setNotificationArea(HtmlOutputText notificationArea) {
		this.notificationArea = notificationArea;
	}


	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}


	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	// Common method
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
	
	//Error Handling
	
	public void validateYEARFROM(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception
	{
		//getCurrentValue(actionEvent);
		
		UIInput inputText = (UIInput)component;
		if(inputText.getSubmittedValue()!=null)
		{
			String inputValue = (String) inputText.getSubmittedValue();
			if(Double.parseDouble(inputValue)<1)
			{
				//System.out.println("value should be greater than 1");
				throw new ValidatorException(new FacesMessage("value should be greater than 1"));
				
			}
			else
			{
				int rowIndex = getDataTable().getRowIndex();
//				dataTableList.get(rowIndex).setRSA_YEAR_FROM(Double.parseDouble(inputValue));
				gridtabListener();
			}
		}
		
	}
	
	
	public void validateYEARTO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception
	{
		//getCurrentValue(actionEvent);
		UIInput inputText = (UIInput)component;
		
		String inputValue = (String) inputText.getSubmittedValue();
		if(inputText.getSubmittedValue()!=null)
		{
			if(Double.parseDouble(inputValue)<1)
			{
				throw new ValidatorException(new FacesMessage("value should be greater than 1"));
				
			}
			else
			{
				int rowIndex = getDataTable().getRowIndex();
//				dataTableList.get(rowIndex).setRSA_YEAR_FROM(Double.parseDouble(inputValue));
				gridtabListener();
			}
		}
		
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

	
}
