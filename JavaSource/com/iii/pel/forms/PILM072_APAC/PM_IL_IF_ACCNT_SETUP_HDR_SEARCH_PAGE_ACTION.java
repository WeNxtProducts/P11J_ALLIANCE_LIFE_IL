package com.iii.pel.forms.PILM072_APAC;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.utils.CommonUtils;



public class PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_ACTION {
	
	private List<PM_IL_IF_ACCNT_SETUP_HDR> recordList;
	private HtmlDataTable dataTable;
	private PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_BEAN;
	
	public PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_ACTION(){
		this.PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_BEAN=new PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE();
	}
	
	public PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE getPM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_BEAN() {
		return PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_BEAN;
	}
	public void setPM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_BEAN(
			PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_BEAN) {
		this.PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_BEAN = PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_BEAN;
	}
	public List<PM_IL_IF_ACCNT_SETUP_HDR> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<PM_IL_IF_ACCNT_SETUP_HDR> recordList) {
		this.recordList = recordList;
	}
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	
	public void fetchButtonClick(ActionEvent event){
		PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_DELEGATE delegate= new PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_DELEGATE();
		this.recordList=delegate.listAllRecords();
	}
	
	public String updateOrInsertRecordLinkClicked(){
		
		String returnString="PILM072_APAC_PM_IL_IF_ACCNT_SETUP_HDR_NAVIGATOR";
		String mappedBeanName="PILM072_APAC_PM_IL_IF_ACCNT_SETUP_HDR_ACTION";
		boolean keepLooking=true;
		
		CommonUtils utility=new CommonUtils();
		
		HttpSession session = utility.getSession();
		
		//Get the action bean for the next page from session
		PM_IL_IF_ACCNT_SETUP_HDR_ACTION actionBean=(PM_IL_IF_ACCNT_SETUP_HDR_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		
		//if action bean is null create new object and set is session
		if(actionBean == null){
			actionBean = new PM_IL_IF_ACCNT_SETUP_HDR_ACTION();
			session.setAttribute(mappedBeanName, actionBean);
		}
		//get the rowid from request which is to be updated
		FacesContext context =FacesContext.getCurrentInstance();
		Map requestParameterMap=context.getExternalContext().getRequestParameterMap();
		String currentRow=((String)requestParameterMap.get("CURRENT_ROWID"));
		//check if request is for update or insert if row id present request for update
		//else it is for insert
		if(currentRow!=null && currentRow.length()>0){
			Iterator<PM_IL_IF_ACCNT_SETUP_HDR> iterator=this.recordList.iterator();
			while(iterator.hasNext()&& keepLooking){
				PM_IL_IF_ACCNT_SETUP_HDR tempBean=((PM_IL_IF_ACCNT_SETUP_HDR)iterator.next());
				if(currentRow.equals(tempBean.getROWID().trim())){
					actionBean.setPM_IL_IF_ACCNT_SETUP_HDR_BEAN(tempBean);
					keepLooking=false;
				}
			}
		}else{
			//clear any previous instances of the action bean that might exist in case
			//of insert. This will take care of resetting the fields
			PM_IL_IF_ACCNT_SETUP_HDR_ACTION newActionBean=new PM_IL_IF_ACCNT_SETUP_HDR_ACTION();
			session.setAttribute(mappedBeanName, newActionBean);
		}
		
		this.recordList=null;
		return returnString;
	}
}
