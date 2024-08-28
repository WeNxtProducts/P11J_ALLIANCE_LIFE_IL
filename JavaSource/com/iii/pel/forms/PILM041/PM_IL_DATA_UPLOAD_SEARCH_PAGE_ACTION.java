package com.iii.pel.forms.PILM041;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DATA_UPLOAD_SEARCH_PAGE_ACTION extends CommonAction{

	private List<PM_IL_DATA_UPLOAD_MAPPING> recordList;
	private HtmlDataTable dataTable;
	private PM_IL_DATA_UPLOAD_SEARCH_PAGE PM_IL_DATA_UPLOAD_SEARCH_PAGE_BEAN;

	public PM_IL_DATA_UPLOAD_SEARCH_PAGE_ACTION() {
		this.PM_IL_DATA_UPLOAD_SEARCH_PAGE_BEAN = new PM_IL_DATA_UPLOAD_SEARCH_PAGE();
	}

	public List<PM_IL_DATA_UPLOAD_MAPPING> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<PM_IL_DATA_UPLOAD_MAPPING> recordList) {
		this.recordList = recordList;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public PM_IL_DATA_UPLOAD_SEARCH_PAGE getPM_IL_DATA_UPLOAD_SEARCH_PAGE_BEAN() {
		return PM_IL_DATA_UPLOAD_SEARCH_PAGE_BEAN;
	}

	public void setPM_IL_DATA_UPLOAD_SEARCH_PAGE_BEAN(
			PM_IL_DATA_UPLOAD_SEARCH_PAGE pm_il_data_upload_search_page_bean) {
		PM_IL_DATA_UPLOAD_SEARCH_PAGE_BEAN = pm_il_data_upload_search_page_bean;
	}

	public void fetchButtonClick(ActionEvent event) {
		System.out.println("Fetch List");

		PM_IL_DATA_UPLOAD_SEARCH_PAGE_DELEGATE delegate = new PM_IL_DATA_UPLOAD_SEARCH_PAGE_DELEGATE();
		this.recordList = delegate.listAllRecords();
	}

	public String updateOrInsertRecordLinkClicked() {

		System.out.println("In to The Link");

		String returnString = "PM_IL_DATA_UPLOAD_MAPPING_NAVIGATOR";
		String mappedBeanName = "PILM041_PM_IL_DATA_UPLOAD_MAPPING_ACTION";
		boolean keepLooking = true;

		CommonUtils utility = new CommonUtils();

		HttpSession session = utility.getSession();

		// Get the action bean for the next page from session
		PM_IL_DATA_UPLOAD_MAPPING_ACTION actionBean = (PM_IL_DATA_UPLOAD_MAPPING_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);

		// if action bean is null create new object and set is session
		if (actionBean == null) {
			actionBean = new PM_IL_DATA_UPLOAD_MAPPING_ACTION();
			session.setAttribute(mappedBeanName, actionBean);
		}
		// get the rowid from request which is to be updated
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext()
				.getRequestParameterMap();
		String currentRow = ((String) requestParameterMap.get("CURRENT_ROWID"));

		// check if request is for update or insert if row id present request
		// for update
		// else it is for insert
		if (currentRow != null && currentRow.length() > 0) {
			Iterator<PM_IL_DATA_UPLOAD_MAPPING> iterator = this.recordList
					.iterator();
			while (iterator.hasNext() && keepLooking) {
				PM_IL_DATA_UPLOAD_MAPPING tempBean = ((PM_IL_DATA_UPLOAD_MAPPING) iterator
						.next());
				if (currentRow.equals(tempBean.getROWID().trim())) {

					actionBean.setPM_IL_DATA_UPLOAD_MAPPING_BEAN(tempBean);
					keepLooking = false;
					// System.out.println("tempBean.getAWDS_CURR_AGE_TO()
					// \t"+tempBean.getAWDS_CURR_AGE_TO());
				}
			}
		} else {
			// clear any previous instances of the action bean that might exist
			// in case
			// of insert. This will take care of resetting the fields
			PM_IL_DATA_UPLOAD_MAPPING_ACTION newActionBean = new PM_IL_DATA_UPLOAD_MAPPING_ACTION();
			session.setAttribute(mappedBeanName, newActionBean);
		}
		this.recordList = null;
		return returnString;
	}

	public String updateButtonAction(String rowId) {
		PM_IL_DATA_UPLOAD_MAPPING_ACTION compositeAction = new PM_IL_DATA_UPLOAD_MAPPING_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM041_PM_IL_DATA_UPLOAD_MAPPING_ACTION",
				compositeAction);
		compositeAction.getPM_IL_DATA_UPLOAD_MAPPING_BEAN().setROWID(rowId);
		outcome = "PM_IL_DATA_UPLOAD_MAPPING_NAVIGATOR";
		return outcome;

	}

	public String insertButtonAction() {
		PM_IL_DATA_UPLOAD_MAPPING_ACTION compositeAction = new PM_IL_DATA_UPLOAD_MAPPING_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM041_PM_IL_DATA_UPLOAD_MAPPING_ACTION",
				compositeAction);
		outcome = "PM_IL_DATA_UPLOAD_MAPPING_NAVIGATOR";
		return outcome;

	}

	public String backToSearch() {
		CommonUtils.clearMaps(this);
		return "PILM041";

	}
}
