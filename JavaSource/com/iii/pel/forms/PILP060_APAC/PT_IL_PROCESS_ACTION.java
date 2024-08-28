package com.iii.pel.forms.PILP060_APAC;

import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import org.richfaces.component.UIDataTable;

import com.iii.premia.common.action.CommonAction;

public class PT_IL_PROCESS_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_PR_ERROR_DESC_LABEL;

	private HtmlInputText COMP_PR_ERROR_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_EM_OK;

	private HtmlCommandButton COMP_UI_M_BUT_EDIT;

	private PT_IL_PROCESS PT_IL_PROCESS_BEAN;
	
	private UIDataTable dataTableComponent;
	
	private List<PT_IL_PROCESS> dataTableList;
	
	int recordsPerPage=5;
	
	int currentPage;
	
	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public UIDataTable getDataTableComponent() {
		return dataTableComponent;
	}

	public void setDataTableComponent(UIDataTable dataTableComponent) {
		this.dataTableComponent = dataTableComponent;
	}

	public List<PT_IL_PROCESS> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<PT_IL_PROCESS> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public PT_IL_PROCESS_ACTION() {
		PT_IL_PROCESS_BEAN = new PT_IL_PROCESS();
		currentPage=1;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
		return COMP_UI_M_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_LABEL) {
		this.COMP_UI_M_POL_NO_LABEL = COMP_UI_M_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText COMP_UI_M_POL_NO) {
		this.COMP_UI_M_POL_NO = COMP_UI_M_POL_NO;
	}

	public HtmlOutputLabel getCOMP_PR_ERROR_DESC_LABEL() {
		return COMP_PR_ERROR_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PR_ERROR_DESC() {
		return COMP_PR_ERROR_DESC;
	}

	public void setCOMP_PR_ERROR_DESC_LABEL(HtmlOutputLabel COMP_PR_ERROR_DESC_LABEL) {
		this.COMP_PR_ERROR_DESC_LABEL = COMP_PR_ERROR_DESC_LABEL;
	}

	public void setCOMP_PR_ERROR_DESC(HtmlInputText COMP_PR_ERROR_DESC) {
		this.COMP_PR_ERROR_DESC = COMP_PR_ERROR_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EM_OK() {
		return COMP_UI_M_BUT_EM_OK;
	}

	public void setCOMP_UI_M_BUT_EM_OK(HtmlCommandButton COMP_UI_M_BUT_EM_OK) {
		this.COMP_UI_M_BUT_EM_OK = COMP_UI_M_BUT_EM_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDIT() {
		return COMP_UI_M_BUT_EDIT;
	}

	public void setCOMP_UI_M_BUT_EDIT(HtmlCommandButton COMP_UI_M_BUT_EDIT) {
		this.COMP_UI_M_BUT_EDIT = COMP_UI_M_BUT_EDIT;
	}

	public PT_IL_PROCESS getPT_IL_PROCESS_BEAN() {
		return PT_IL_PROCESS_BEAN;
	}

	public void setPT_IL_PROCESS_BEAN(PT_IL_PROCESS PT_IL_PROCESS_BEAN) {
		this.PT_IL_PROCESS_BEAN = PT_IL_PROCESS_BEAN;
	}

	public void whenNewBlockInstancePT_IL_PROCESS() {
		System.out
				.println("PT_IL_PROCESS_ACTION.whenNewBlockInstancePT_IL_PROCESS()");
		
		PT_IL_PROCESS_HELPER helper=new PT_IL_PROCESS_HELPER();
		try {
			this.dataTableList=helper.getBlockData();
			helper.postQuery(dataTableList);
		} catch (Exception e) {
			getErrorMap().clear();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("key", e.getMessage());
			e.printStackTrace();
		}
	}

	public String okButtonAction(){
		String retString="";
		PT_IL_PROCESS_HELPER helper=new PT_IL_PROCESS_HELPER();
		try {
			helper.deleteRecords();
			retString="GO_TO_PILP060_APAC_DUMMY";
		} catch (Exception e) {
			getErrorMap().clear();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("key", e.getMessage());
			e.printStackTrace();
			e.printStackTrace();
		}
		return retString; 
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
