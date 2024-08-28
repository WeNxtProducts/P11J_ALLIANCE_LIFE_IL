package com.iii.pel.forms.PILM002_APAC;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;



public class PM_IL_COVER_SEARCH_PAGE_ACTION extends CommonAction{
	
	private List<PM_IL_COVER> recordList;
	private HtmlDataTable dataTable;
	
	private PM_IL_COVER_SEARCH_PAGE PM_IL_COVER_SEARCH_PAGE_BEAN;
	
	public PM_IL_COVER_SEARCH_PAGE_ACTION(){
		this.PM_IL_COVER_SEARCH_PAGE_BEAN=new PM_IL_COVER_SEARCH_PAGE();
	}
	
	
	public PM_IL_COVER_SEARCH_PAGE getPM_IL_COVER_SEARCH_PAGE_BEAN() {
		return PM_IL_COVER_SEARCH_PAGE_BEAN;
	}

	public void setPM_IL_COVER_SEARCH_PAGE_BEAN(
			PM_IL_COVER_SEARCH_PAGE pm_il_cover_search_page_bean) {
		PM_IL_COVER_SEARCH_PAGE_BEAN = pm_il_cover_search_page_bean;
	}

	public List<PM_IL_COVER> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<PM_IL_COVER> recordList) {
		this.recordList = recordList;
	}
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	
	/*public void fetchButtonClick(ActionEvent event){
		PM_IL_COVER_SEARCH_PAGE_DELEGATE delegate= new PM_IL_COVER_SEARCH_PAGE_DELEGATE();
		this.recordList=delegate.listAllRecords();
	}
	
	public void fetchAllRecord(){
		PM_IL_COVER_SEARCH_PAGE_DELEGATE delegate= new PM_IL_COVER_SEARCH_PAGE_DELEGATE();
		this.recordList=delegate.listAllRecords();
	}*/
	
	public String updateRecordLinkClicked(){
		
		String returnString="GO_TO_PILM002_APAC_PM_IL_COVER";
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		boolean keepLooking=true;
		
		CommonUtils utility=new CommonUtils();
		HttpSession session = utility.getSession();
		Iterator<PM_IL_COVER> iterator=this.recordList.iterator();
		
		//create new object of composite action bean and set it in session
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean = new PILM002_APAC_COMPOSITE_ACTION();
		session.setAttribute(mappedBeanName, compositeActionBean);
		//setting the flag to false to indicate form is in insert mode
		compositeActionBean.getPM_IL_COVER_ACTION_BEAN().setInsertmode(false);
		//get the rowid from request which is to be updated
		FacesContext context =FacesContext.getCurrentInstance();
		Map requestParameterMap=context.getExternalContext().getRequestParameterMap();
		String currentRow=((String)requestParameterMap.get("CURRENT_ROWID"));
		
		while(iterator.hasNext()&& keepLooking){
			PM_IL_COVER tempBean=((PM_IL_COVER)iterator.next());
			if(currentRow.equals(tempBean.getROWID().trim())){
				compositeActionBean.getPM_IL_COVER_ACTION_BEAN().setPM_IL_COVER_BEAN(tempBean);
				System.out.println("Selected cover--->"+tempBean.getCOVER_CODE());
				keepLooking=false;
			}
		}
		
		//calling the when new block instance trigger for the next form 
		//compositeActionBean.getPM_IL_COVER_ACTION_BEAN().whenNewBlockInstanceForPM_IL_COVER();
		//calling the when new record instance trigger for the next form 
		//compositeActionBean.getPM_IL_COVER_ACTION_BEAN().whenNewRecordInstanceForPM_IL_COVER();
		this.recordList=null;
		return returnString;
	}
	
	public String insertRecordLinkClicked(){
		
		System.out.println("inside insert modeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		String returnString="GO_TO_PILM002_APAC_PM_IL_COVER";
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		HttpSession session = utility.getSession();
		//clear any previous instances of the action bean that might exist in case
		//of insert. This will take care of resetting the fields
		PILM002_APAC_COMPOSITE_ACTION newActionBean=new PILM002_APAC_COMPOSITE_ACTION();
		session.setAttribute(mappedBeanName, newActionBean);
		//setting the flag to true to indicate form is in insert mode
		newActionBean.getPM_IL_COVER_ACTION_BEAN().setInsertmode(true);
		//calling the when new block instance trigger for the next form 
		//newActionBean.getPM_IL_COVER_ACTION_BEAN().whenNewBlockInstanceForPM_IL_COVER();
		//calling the when_new_record_instance trigger for the next form 
		//newActionBean.getPM_IL_COVER_ACTION_BEAN().whenNewRecordInstanceForPM_IL_COVER();
		newActionBean.getPM_IL_COVER_ACTION_BEAN().getCOMP_COVER_APP_ON_BASIC_RATE().setDisabled(true);
		newActionBean.getPM_IL_COVER_ACTION_BEAN().getCOMP_COVER_CLASS().setDisabled(true);
		this.recordList=null;
		return returnString;
	}
	
	public String updateButtonAction(String rowId) {
		PILM002_APAC_COMPOSITE_ACTION compositeAction= new PILM002_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM002_APAC_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPM_IL_COVER_ACTION_BEAN().getPM_IL_COVER_BEAN().setROWID(rowId);
	
		outcome = "GO_TO_PILM002_APAC_PM_IL_COVER";
		return outcome;
    }

    public String insertButtonAction() {
    	PILM002_APAC_COMPOSITE_ACTION compositeAction= new PILM002_APAC_COMPOSITE_ACTION();
    	String outcome = null;
	
		CommonUtils.setGlobalObject("PILM002_APAC_COMPOSITE_ACTION",
				compositeAction);
		outcome = "GO_TO_PILM002_APAC_PM_IL_COVER";
		return outcome;
    }
}
