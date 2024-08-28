package com.iii.pel.forms.PILM042;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import com.iii.pel.forms.PILM041.PM_IL_DATA_UPLOAD_MAPPING_ACTION;
import com.iii.pel.login.exception.DatabaseException;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_ACTION {
	private List<PM_IL_DATA_UPLOAD_DEFN_HDR> recordList;
	private List<PM_IL_DATA_UPLOAD_DEFN_HDR> recordListDtl;
	private HtmlDataTable dataTable;
	private PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_BEAN;
	
	private String filter_DEF_ID;
	private String filter_DEF_DESC;
	private String filter_DUDH_EFF_FM_DT;
	private String filter_DUDH_EFF_TO_DT;

	public PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_ACTION() {
		PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_BEAN = new PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE();
	}

	public List<PM_IL_DATA_UPLOAD_DEFN_HDR> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<PM_IL_DATA_UPLOAD_DEFN_HDR> recordList) {
		this.recordList = recordList;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE getPILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_BEAN() {
		return PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_BEAN;
	}

	public void setPILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_BEAN(
			PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE pilm042_pm_il_data_upload_defn_search_page_bean) {
		PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_BEAN = pilm042_pm_il_data_upload_defn_search_page_bean;
	}

	public void test(ActionEvent event) {
		System.out.println("Fetch List");
	}

	public void fetchButtonClick(ActionEvent event) throws DatabaseException,
			DBException {
		filter_DEF_ID= null;
		filter_DEF_DESC = null;
		PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_DELEGATE delegate = new PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_DELEGATE();
		recordList = delegate.listAllRecords();
	}

	public String updateOrInsertRecordLinkClicked() {
		String returnString = "PM_IL_DATA_UPLOAD_NAVIGATOR";
		String mappedBeanName = "PILM042_COMPOSITE_ACTION";
		boolean keepLooking = true;
		CommonUtils utility = new CommonUtils();
		HttpSession session = utility.getSession();
		PILM042_COMPOSITE_ACTION actionBean = (PILM042_COMPOSITE_ACTION) utility.getMappedBeanFromSession(mappedBeanName);
		PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_DELEGATE delegate = new PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_DELEGATE();
		if (actionBean == null) {
			actionBean = new PILM042_COMPOSITE_ACTION();
			session.setAttribute(mappedBeanName, actionBean);
		}
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext()
				.getRequestParameterMap();
		String currentRow = ((String) requestParameterMap.get("CURRENT_ROWID"));
		PM_IL_DATA_UPLOAD_DEFN_HDR tempBean = null;
		Iterator<PM_IL_DATA_UPLOAD_DEFN_HDR> iterator = null;
		if (currentRow != null && currentRow.length() > 0) {
				delegate.nameList(currentRow);
			iterator = recordList.iterator();
			while (iterator.hasNext() && keepLooking) {
				tempBean = ((PM_IL_DATA_UPLOAD_DEFN_HDR) iterator.next());
				if (currentRow.equals(tempBean.getROWID().trim())) {
					actionBean.setPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN(new PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION());
					actionBean.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().setPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN(tempBean);
					keepLooking = false;
				}
			}
		} else {
			actionBean = new PILM042_COMPOSITE_ACTION();
			session.setAttribute(mappedBeanName, actionBean);
		}
		recordList = null;
		return returnString;
	}

	public String newRecordAction() {
		CommonUtils commonUtils = new CommonUtils();
		PILM042_COMPOSITE_ACTION compositeAction = null;

		commonUtils.setGlobalObject("PILM042_COMPOSITE_ACTION",new PILM042_COMPOSITE_ACTION());

		return "PM_IL_DATA_UPLOAD_NAVIGATOR";
	}

	public List<PM_IL_DATA_UPLOAD_DEFN_HDR> getRecordListDtl() {
		return recordListDtl;
	}

	public void setRecordListDtl(List<PM_IL_DATA_UPLOAD_DEFN_HDR> recordListDtl) {
		this.recordListDtl = recordListDtl;
	}

	public String getFilter_DEF_ID() {
		return filter_DEF_ID;
	}

	public void setFilter_DEF_ID(String filter_DEF_ID) {
		this.filter_DEF_ID = filter_DEF_ID;
	}

	public String getFilter_DEF_DESC() {
		return filter_DEF_DESC;
	}

	public void setFilter_DEF_DESC(String filter_DEF_DESC) {
		this.filter_DEF_DESC = filter_DEF_DESC;
	}
	public String getSearchPage(){
		PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_DELEGATE delegate = new PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_DELEGATE();
		recordList = delegate.listAllRecords();	
		return null;
	}

	/**
	 * @return the filter_DUDH_EFF_FM_DT
	 */
	public String getFilter_DUDH_EFF_FM_DT() {
		return filter_DUDH_EFF_FM_DT;
	}

	/**
	 * @param filter_DUDH_EFF_FM_DT the filter_DUDH_EFF_FM_DT to set
	 */
	public void setFilter_DUDH_EFF_FM_DT(String filter_DUDH_EFF_FM_DT) {
		this.filter_DUDH_EFF_FM_DT = filter_DUDH_EFF_FM_DT;
	}

	/**
	 * @return the filter_DUDH_EFF_TO_DT
	 */
	public String getFilter_DUDH_EFF_TO_DT() {
		return filter_DUDH_EFF_TO_DT;
	}

	/**
	 * @param filter_DUDH_EFF_TO_DT the filter_DUDH_EFF_TO_DT to set
	 */
	public void setFilter_DUDH_EFF_TO_DT(String filter_DUDH_EFF_TO_DT) {
		this.filter_DUDH_EFF_TO_DT = filter_DUDH_EFF_TO_DT;
	}
	
	/**
	 * 
	 * @param rowId
	 * @return
	 */
	public String updateButtonAction(String rowId) {
		PILM042_COMPOSITE_ACTION compositeAction = new PILM042_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM042_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN().setROWID(rowId);
		outcome = "definitionHeader";
		return outcome;
	}
	
	/**
	 * 
	 * @return
	 */
	public String insertButtonAction() {
		PILM042_COMPOSITE_ACTION compositeAction = new PILM042_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM042_COMPOSITE_ACTION",
				compositeAction);
		outcome = "definitionHeader";
		return outcome;
	}
}
