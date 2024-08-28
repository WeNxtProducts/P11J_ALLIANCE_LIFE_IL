package com.iii.pel.forms.PM104_A_TISB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;





public class PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_ACTION extends CommonAction{
	
	private List<PM_AGENT_WITH_DRAWL_SETUP> recordList;
	private HtmlDataTable dataTable;
	private PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_BEAN;
	private List<SelectItem> AWDS_TYPE_SELECT_ITEM = new ArrayList<SelectItem>();
	
	public PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_ACTION(){
		this.PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_BEAN =new PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE();
		try {
			AWDS_TYPE_SELECT_ITEM=ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PM104_A_APAC",
												"PM_AGENT_WITH_DRAWL_SETUP",
												"PM_AGENT_WITH_DRAWL_SETUP.AWDS_TYPE", "APFCLMTYP");
		} catch (DBException e) {
			
			e.printStackTrace();
		}
	}
	
	public PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE getPM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_BEAN() {
		return PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_BEAN;
	}

	public void setPM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_BEAN(
			PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE pm_agent_with_drawl_setup_search_page_bean) {
		PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_BEAN = pm_agent_with_drawl_setup_search_page_bean;
		
	}
	
	public List<PM_AGENT_WITH_DRAWL_SETUP> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<PM_AGENT_WITH_DRAWL_SETUP> recordList) {
		this.recordList = recordList;
	}
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	
	public String fetchButtonClick(){
		String message=null;
		
		list_Records();
		/*
		if(recordList == null || recordList.size()<1){
			message = Messages.getString(PELConstants.pelMessagePropertiesPath, "Search$NoRecord$Message");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			
		}*/
		return "";
	} 
	
	public void list_Records(){
		PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_DELEGATE delegate= new PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_DELEGATE();
		String awdTypeCode=null;
		this.recordList=delegate.listAllRecords();
		Iterator<PM_AGENT_WITH_DRAWL_SETUP> itr=this.recordList.iterator();
		
		while(itr.hasNext()){
			PM_AGENT_WITH_DRAWL_SETUP withDrawlSetupBean=itr.next();
			awdTypeCode=withDrawlSetupBean.getAWDS_TYPE();
			if(awdTypeCode!=null){
				withDrawlSetupBean.setUI_M_AWDS_TYPE_DESC(delegate.getDescForAwardCode(awdTypeCode));
			}
			
		}
	}
	
	
	public String insertButtonAction() throws Exception {
		String outcome = null;
		try {
			PM_AGENT_WITH_DRAWL_SETUP_ACTION action = new PM_AGENT_WITH_DRAWL_SETUP_ACTION();
			CommonUtils.setGlobalObject("PM104_A_TISB_PM_AGENT_WITH_DRAWL_SETUP_ACTION",
					action);
			outcome = "PM_AGENT_WITH_DRAWL_SETUP_NAVIGATOR";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outcome;

	}
	
	public String updateButtonAction(String rowId) throws Exception {
		String outcome = null;
		try {
			PM_AGENT_WITH_DRAWL_SETUP_ACTION action = new PM_AGENT_WITH_DRAWL_SETUP_ACTION();
			CommonUtils.setGlobalObject("PM104_A_TISB_PM_AGENT_WITH_DRAWL_SETUP_ACTION",
					action);
			action.getPM_AGENT_WITH_DRAWL_SETUP_BEAN().setROWID(rowId);
			outcome = "PM_AGENT_WITH_DRAWL_SETUP_NAVIGATOR";

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outcome;
	}

	public List<SelectItem> getAWDS_TYPE_SELECT_ITEM() {
		return AWDS_TYPE_SELECT_ITEM;
	}

	public void setAWDS_TYPE_SELECT_ITEM(List<SelectItem> awds_type_select_item) {
		AWDS_TYPE_SELECT_ITEM = awds_type_select_item;
	}
	
	public void setSelectedValueInBean(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		String selectedValue=(String)input.toString();
		if(selectedValue!=null){
			System.out.println("selectedValue :"+selectedValue);
			this.PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_BEAN.setSEARCH_BY_VALUE1(selectedValue);
		}
	}
	
	
	
}
