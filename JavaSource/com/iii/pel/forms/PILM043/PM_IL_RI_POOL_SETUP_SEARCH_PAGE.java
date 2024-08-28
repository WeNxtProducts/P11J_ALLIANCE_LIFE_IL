package com.iii.pel.forms.PILM043;

import java.util.ArrayList;

import javax.faces.component.html.HtmlDataTable;

public class PM_IL_RI_POOL_SETUP_SEARCH_PAGE {

	private HtmlDataTable dataTable;
	private ArrayList riPoolSetupArrayList;
	
	private String riPoolCode;
	private String riPoolDesc;
	
	private String storedRIPoolCode;
	private String storedRIPoolDesc;
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	public ArrayList getRiPoolSetupArrayList() {
		return riPoolSetupArrayList;
	}
	public void setRiPoolSetupArrayList(ArrayList riPoolSetupArrayList) {
		this.riPoolSetupArrayList = riPoolSetupArrayList;
	}
	public String getRiPoolCode() {
		return riPoolCode;
	}
	public void setRiPoolCode(String riPoolCode) {
		this.riPoolCode = riPoolCode;
	}
	public String getRiPoolDesc() {
		return riPoolDesc;
	}
	public void setRiPoolDesc(String riPoolDesc) {
		this.riPoolDesc = riPoolDesc;
	}
	public String getStoredRIPoolCode() {
		return storedRIPoolCode;
	}
	public void setStoredRIPoolCode(String storedRIPoolCode) {
		this.storedRIPoolCode = storedRIPoolCode;
	}
	public String getStoredRIPoolDesc() {
		return storedRIPoolDesc;
	}
	public void setStoredRIPoolDesc(String storedRIPoolDesc) {
		this.storedRIPoolDesc = storedRIPoolDesc;
	}

}
