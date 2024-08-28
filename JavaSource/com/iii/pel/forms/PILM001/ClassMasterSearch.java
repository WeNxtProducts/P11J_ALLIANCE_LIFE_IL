package com.iii.pel.forms.PILM001;

import java.util.ArrayList;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.action.CommonAction;

public class ClassMasterSearch extends CommonAction 
{
	
	private UIData dataGrid;
	private ArrayList<PM_IL_CLASS> nameList;
	private String initClasscode;
	private String initClassname;
	private String storedclasscode;

	private int lastUpdatedRowIndex;
	private int pageNum;
	private boolean checkBoxSelected;


	

	public String getInitClasscode() {
		return initClasscode;
	}

	public String getInitClassname() {
		return initClassname;
	}

	public String getStoredclasscode() {
		return storedclasscode;
	}

	
	
	public void setInitClasscode(String initClasscode) {
		this.initClasscode = initClasscode;
	}

	public void setInitClassname(String initClassname) {
		this.initClassname = initClassname;
	}

	public void setStoredclasscode(String storedclasscode) {
		this.storedclasscode = storedclasscode;
	}

	public String clearList() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String code = req.getParameter("ClassCode");
		System.out.println("ClassMasterSearch.clearList()Code*****" + code);
		prepareClassMasterDetails(code);
		nameList = null;
		String returnStr = "PILM001_CLASSMASTER";
		return returnStr;
	}

	public String fetchClassDetails() {
		try {
			/*this.classMasterRecordList = new PILM001_CRUD()
					.fetchClassMasterDetails(this);*/
			nameList = new PILM001_CRUD().fetchClassMasterDetails(this);

			
		} catch (Exception e) {
			// TODO do appropriate settings for the message to display to the
			// user
			e.printStackTrace();
		}

		return null;
	}

	public String clearSession() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("PM_IL_CLASS_ACTION") != null) {
			session.removeAttribute("PM_IL_CLASS_ACTION");
		}
		return "PILM001_CLASSMASTER";
	}

	public Object prepareClassMasterDetails(String code) {
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println(context.getExternalContext().getSessionMap());
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_CLASS_ACTION pi_lm_action = new PM_IL_CLASS_ACTION();
		session.setAttribute("PM_IL_CLASS_ACTION", pi_lm_action);
		new PILM001_CRUD().fetchClassDetails(code, pi_lm_action
				.getPM_IL_CLASS_BEAN());
		return "";
	}


	public ArrayList<PM_IL_CLASS> getNameList() {
		return nameList;
	}

	

	public void setNameList(ArrayList<PM_IL_CLASS> nameList) {
		this.nameList = nameList;
	}

	public int getPageNum() {
		return pageNum;
	}



	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public UIData getDataGrid() {
		return dataGrid;
	}

	public void setDataGrid(UIData dataGrid) {
		this.dataGrid = dataGrid;
	}
	
	public String deleteRow()
	{
		PM_IL_CLASS bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		if(nameList!=null)
		{
			deletedRecordList = new ArrayList();
			for(int index =0; index<nameList.size();)
			{
				bean = nameList.get(index);
				if(bean.isSelected()){
					deletedRecordList.add(bean);
					nameList.remove(bean);
					//deletedRecordIndex = dataGridDelegate.deleteData(bean);
					
				}else
				{
					index++;
				}
			}
			if(deletedRecordList.size()>0)
			{
				int deletedRecord=new PILM001_CRUD().executeDelete(deletedRecordList);
				if(deletedRecord>0)
				{
				getWarningMap().put("somekey", deletedRecordList.size()+" records deleted.");
				getWarningMap().put("current", deletedRecordList.size()+" records deleted.");
				}
			}
			
			lastUpdatedRowIndex = -1;
		}
		return "";
}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}

	public void setCheckBoxSelected(boolean checkBoxSelected) {
		this.checkBoxSelected = checkBoxSelected;
	}
}
