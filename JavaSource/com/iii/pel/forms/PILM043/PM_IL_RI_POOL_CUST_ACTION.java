package com.iii.pel.forms.PILM043;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UISuggestionBox;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RI_POOL_CUST_ACTION extends CommonAction {

	/*ADDED BY RAJA ON 17-03-2017 FOR SSP CALL ID - ZBILQC-1719314*/
	public PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION compositeAction;
	/*end*/
	private HtmlOutputLabel COMP_RPCUST_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_RPCUST_CODE_DESC_LABEL;
	private HtmlOutputLabel COMP_RPCUST_SHARE_PERC_LABEL;
	private HtmlOutputLabel COMP_RPCUST_NEW_COMM_LABEL;
	private HtmlOutputLabel COMP_RPCUST_REN_COMM_LABEL;
	private HtmlOutputLabel COMP_RPCUST_NEW_TAX_LABEL;
	private HtmlOutputLabel COMP_RPCUST_REN_TAX_LABEL;
	private HtmlOutputLabel COMP_UI_M_RCC_RPCUST_CODE_DESC_LABEL;
	private HtmlOutputLabel COMP_RPCUST_RETRO_SHARE_PERC_LABEL;
	private HtmlOutputLabel COMP_RPCUST_RETRO_NEW_COMM_LABEL;
	private HtmlOutputLabel COMP_RPCUST_RETRO_REN_COMM_LABEL;
	private HtmlOutputLabel COMP_RPCUST_RETRO_NEW_TAX_LABEL;
	private HtmlOutputLabel COMP_RPCUST_RETRO_REN_TAX_LABEL;

	private HtmlInputText COMP_RPCUST_CODE;
	private HtmlInputText COMP_UI_M_RPCUST_CODE_DESC;
	private HtmlInputText COMP_RPCUST_SHARE_PERC;
	private HtmlInputText COMP_RPCUST_NEW_COMM;
	private HtmlInputText COMP_RPCUST_REN_COMM;
	private HtmlInputText COMP_RPCUST_NEW_TAX;
	private HtmlInputText COMP_RPCUST_REN_TAX;
	private HtmlInputText COMP_UI_M_RCC_RPCUST_CODE_DESC;
	private HtmlInputText COMP_RPCUST_RETRO_SHARE_PERC;
	private HtmlInputText COMP_RPCUST_RETRO_NEW_COMM;
	private HtmlInputText COMP_RPCUST_RETRO_REN_COMM;
	private HtmlInputText COMP_RPCUST_RETRO_NEW_TAX;
	private HtmlInputText COMP_RPCUST_RETRO_REN_TAX;

	private PM_IL_RI_POOL_CUST PM_IL_RI_POOL_CUST_BEAN;
	

	List RI_POOL_CUST_LIST;

	private int recordPerPage = 5;
	private ArrayList<PM_IL_RI_POOL_CUST> dataTableList;
	private UIData dataTable;
	private int currentPage;
	private int lastUpdatedRowIndex;
	private int prevRowIndex;
	
	private String filterByUI_M_RPCUST_CODE_DESC;
	private String filterByRPCUST_CODE;
	private String filterByRPCUST_SHARE_PERC;
	private String filterByRPCUST_NEW_COMM;
	private String filterByRPCUST_REN_COMM;
	private String filterByRPCUST_REN_TAX;
	private String filterByRPCUST_NEW_TAX;
	private String filterByRPCUST_RETRO_NEW_COMM;
	private String filterByRPCUST_RETRO_SHARE_PERC;
	private String filterByRPCUST_RETRO_REN_COMM;
	private String filterByRPCUST_RETRO_NEW_TAX;
	private String filterByRPCUST_RETRO_REN_TAX;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private PM_IL_RI_POOL_CUST_HELPER helper;
	
	public PM_IL_RI_POOL_CUST_ACTION() {
		PM_IL_RI_POOL_CUST_BEAN = new PM_IL_RI_POOL_CUST();
		dataTableList = new ArrayList<PM_IL_RI_POOL_CUST>();
		helper = new PM_IL_RI_POOL_CUST_HELPER();
		// fetchList.add(new PM_IL_RI_POOL_CUST());
		currentPage=1;
	}

	public HtmlOutputLabel getCOMP_RPCUST_CODE_LABEL() {
		return COMP_RPCUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RPCUST_CODE() {
		return COMP_RPCUST_CODE;
	}

	public void setCOMP_RPCUST_CODE_LABEL(HtmlOutputLabel COMP_RPCUST_CODE_LABEL) {
		this.COMP_RPCUST_CODE_LABEL = COMP_RPCUST_CODE_LABEL;
	}

	public void setCOMP_RPCUST_CODE(HtmlInputText COMP_RPCUST_CODE) {
		this.COMP_RPCUST_CODE = COMP_RPCUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_RPCUST_CODE_DESC_LABEL() {
		return COMP_UI_M_RPCUST_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_RPCUST_CODE_DESC() {
		return COMP_UI_M_RPCUST_CODE_DESC;
	}

	public void setCOMP_UI_M_RPCUST_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_RPCUST_CODE_DESC_LABEL) {
		this.COMP_UI_M_RPCUST_CODE_DESC_LABEL = COMP_UI_M_RPCUST_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_RPCUST_CODE_DESC(
			HtmlInputText COMP_UI_M_RPCUST_CODE_DESC) {
		this.COMP_UI_M_RPCUST_CODE_DESC = COMP_UI_M_RPCUST_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_RPCUST_SHARE_PERC_LABEL() {
		return COMP_RPCUST_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_RPCUST_SHARE_PERC() {
		return COMP_RPCUST_SHARE_PERC;
	}

	public void setCOMP_RPCUST_SHARE_PERC_LABEL(
			HtmlOutputLabel COMP_RPCUST_SHARE_PERC_LABEL) {
		this.COMP_RPCUST_SHARE_PERC_LABEL = COMP_RPCUST_SHARE_PERC_LABEL;
	}

	public void setCOMP_RPCUST_SHARE_PERC(HtmlInputText COMP_RPCUST_SHARE_PERC) {
		this.COMP_RPCUST_SHARE_PERC = COMP_RPCUST_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_RPCUST_NEW_COMM_LABEL() {
		return COMP_RPCUST_NEW_COMM_LABEL;
	}

	public HtmlInputText getCOMP_RPCUST_NEW_COMM() {
		return COMP_RPCUST_NEW_COMM;
	}

	public void setCOMP_RPCUST_NEW_COMM_LABEL(
			HtmlOutputLabel COMP_RPCUST_NEW_COMM_LABEL) {
		this.COMP_RPCUST_NEW_COMM_LABEL = COMP_RPCUST_NEW_COMM_LABEL;
	}

	public void setCOMP_RPCUST_NEW_COMM(HtmlInputText COMP_RPCUST_NEW_COMM) {
		this.COMP_RPCUST_NEW_COMM = COMP_RPCUST_NEW_COMM;
	}

	public HtmlOutputLabel getCOMP_RPCUST_REN_COMM_LABEL() {
		return COMP_RPCUST_REN_COMM_LABEL;
	}

	public HtmlInputText getCOMP_RPCUST_REN_COMM() {
		return COMP_RPCUST_REN_COMM;
	}

	public void setCOMP_RPCUST_REN_COMM_LABEL(
			HtmlOutputLabel COMP_RPCUST_REN_COMM_LABEL) {
		this.COMP_RPCUST_REN_COMM_LABEL = COMP_RPCUST_REN_COMM_LABEL;
	}

	public void setCOMP_RPCUST_REN_COMM(HtmlInputText COMP_RPCUST_REN_COMM) {
		this.COMP_RPCUST_REN_COMM = COMP_RPCUST_REN_COMM;
	}

	public HtmlOutputLabel getCOMP_RPCUST_NEW_TAX_LABEL() {
		return COMP_RPCUST_NEW_TAX_LABEL;
	}

	public HtmlInputText getCOMP_RPCUST_NEW_TAX() {
		return COMP_RPCUST_NEW_TAX;
	}

	public void setCOMP_RPCUST_NEW_TAX_LABEL(
			HtmlOutputLabel COMP_RPCUST_NEW_TAX_LABEL) {
		this.COMP_RPCUST_NEW_TAX_LABEL = COMP_RPCUST_NEW_TAX_LABEL;
	}

	public void setCOMP_RPCUST_NEW_TAX(HtmlInputText COMP_RPCUST_NEW_TAX) {
		this.COMP_RPCUST_NEW_TAX = COMP_RPCUST_NEW_TAX;
	}

	public HtmlOutputLabel getCOMP_RPCUST_REN_TAX_LABEL() {
		return COMP_RPCUST_REN_TAX_LABEL;
	}

	public HtmlInputText getCOMP_RPCUST_REN_TAX() {
		return COMP_RPCUST_REN_TAX;
	}

	public void setCOMP_RPCUST_REN_TAX_LABEL(
			HtmlOutputLabel COMP_RPCUST_REN_TAX_LABEL) {
		this.COMP_RPCUST_REN_TAX_LABEL = COMP_RPCUST_REN_TAX_LABEL;
	}

	public void setCOMP_RPCUST_REN_TAX(HtmlInputText COMP_RPCUST_REN_TAX) {
		this.COMP_RPCUST_REN_TAX = COMP_RPCUST_REN_TAX;
	}

	public HtmlOutputLabel getCOMP_UI_M_RCC_RPCUST_CODE_DESC_LABEL() {
		return COMP_UI_M_RCC_RPCUST_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_RCC_RPCUST_CODE_DESC() {
		return COMP_UI_M_RCC_RPCUST_CODE_DESC;
	}

	public void setCOMP_UI_M_RCC_RPCUST_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_RCC_RPCUST_CODE_DESC_LABEL) {
		this.COMP_UI_M_RCC_RPCUST_CODE_DESC_LABEL = COMP_UI_M_RCC_RPCUST_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_RCC_RPCUST_CODE_DESC(
			HtmlInputText COMP_UI_M_RCC_RPCUST_CODE_DESC) {
		this.COMP_UI_M_RCC_RPCUST_CODE_DESC = COMP_UI_M_RCC_RPCUST_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_RPCUST_RETRO_SHARE_PERC_LABEL() {
		return COMP_RPCUST_RETRO_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_RPCUST_RETRO_SHARE_PERC() {
		return COMP_RPCUST_RETRO_SHARE_PERC;
	}

	public void setCOMP_RPCUST_RETRO_SHARE_PERC_LABEL(
			HtmlOutputLabel COMP_RPCUST_RETRO_SHARE_PERC_LABEL) {
		this.COMP_RPCUST_RETRO_SHARE_PERC_LABEL = COMP_RPCUST_RETRO_SHARE_PERC_LABEL;
	}

	public void setCOMP_RPCUST_RETRO_SHARE_PERC(
			HtmlInputText COMP_RPCUST_RETRO_SHARE_PERC) {
		this.COMP_RPCUST_RETRO_SHARE_PERC = COMP_RPCUST_RETRO_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_RPCUST_RETRO_NEW_COMM_LABEL() {
		return COMP_RPCUST_RETRO_NEW_COMM_LABEL;
	}

	public HtmlInputText getCOMP_RPCUST_RETRO_NEW_COMM() {
		return COMP_RPCUST_RETRO_NEW_COMM;
	}

	public void setCOMP_RPCUST_RETRO_NEW_COMM_LABEL(
			HtmlOutputLabel COMP_RPCUST_RETRO_NEW_COMM_LABEL) {
		this.COMP_RPCUST_RETRO_NEW_COMM_LABEL = COMP_RPCUST_RETRO_NEW_COMM_LABEL;
	}

	public void setCOMP_RPCUST_RETRO_NEW_COMM(
			HtmlInputText COMP_RPCUST_RETRO_NEW_COMM) {
		this.COMP_RPCUST_RETRO_NEW_COMM = COMP_RPCUST_RETRO_NEW_COMM;
	}

	public HtmlOutputLabel getCOMP_RPCUST_RETRO_REN_COMM_LABEL() {
		return COMP_RPCUST_RETRO_REN_COMM_LABEL;
	}

	public HtmlInputText getCOMP_RPCUST_RETRO_REN_COMM() {
		return COMP_RPCUST_RETRO_REN_COMM;
	}

	public void setCOMP_RPCUST_RETRO_REN_COMM_LABEL(
			HtmlOutputLabel COMP_RPCUST_RETRO_REN_COMM_LABEL) {
		this.COMP_RPCUST_RETRO_REN_COMM_LABEL = COMP_RPCUST_RETRO_REN_COMM_LABEL;
	}

	public void setCOMP_RPCUST_RETRO_REN_COMM(
			HtmlInputText COMP_RPCUST_RETRO_REN_COMM) {
		this.COMP_RPCUST_RETRO_REN_COMM = COMP_RPCUST_RETRO_REN_COMM;
	}

	public HtmlOutputLabel getCOMP_RPCUST_RETRO_NEW_TAX_LABEL() {
		return COMP_RPCUST_RETRO_NEW_TAX_LABEL;
	}

	public HtmlInputText getCOMP_RPCUST_RETRO_NEW_TAX() {
		return COMP_RPCUST_RETRO_NEW_TAX;
	}

	public void setCOMP_RPCUST_RETRO_NEW_TAX_LABEL(
			HtmlOutputLabel COMP_RPCUST_RETRO_NEW_TAX_LABEL) {
		this.COMP_RPCUST_RETRO_NEW_TAX_LABEL = COMP_RPCUST_RETRO_NEW_TAX_LABEL;
	}

	public void setCOMP_RPCUST_RETRO_NEW_TAX(
			HtmlInputText COMP_RPCUST_RETRO_NEW_TAX) {
		this.COMP_RPCUST_RETRO_NEW_TAX = COMP_RPCUST_RETRO_NEW_TAX;
	}

	public HtmlOutputLabel getCOMP_RPCUST_RETRO_REN_TAX_LABEL() {
		return COMP_RPCUST_RETRO_REN_TAX_LABEL;
	}

	public HtmlInputText getCOMP_RPCUST_RETRO_REN_TAX() {
		return COMP_RPCUST_RETRO_REN_TAX;
	}

	public void setCOMP_RPCUST_RETRO_REN_TAX_LABEL(
			HtmlOutputLabel COMP_RPCUST_RETRO_REN_TAX_LABEL) {
		this.COMP_RPCUST_RETRO_REN_TAX_LABEL = COMP_RPCUST_RETRO_REN_TAX_LABEL;
	}

	public void setCOMP_RPCUST_RETRO_REN_TAX(
			HtmlInputText COMP_RPCUST_RETRO_REN_TAX) {
		this.COMP_RPCUST_RETRO_REN_TAX = COMP_RPCUST_RETRO_REN_TAX;
	}

	public PM_IL_RI_POOL_CUST getPM_IL_RI_POOL_CUST_BEAN() {
		return PM_IL_RI_POOL_CUST_BEAN;
	}

	public void setPM_IL_RI_POOL_CUST_BEAN(
			PM_IL_RI_POOL_CUST PM_IL_RI_POOL_CUST_BEAN) {
		this.PM_IL_RI_POOL_CUST_BEAN = PM_IL_RI_POOL_CUST_BEAN;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void lastColumnListener() {
		PM_IL_RI_POOL_CUST_DELEGATE pm_il_ri_pool_cust_delegate = new PM_IL_RI_POOL_CUST_DELEGATE();
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		try {
			// Get the bean based on row index
			PM_IL_RI_POOL_CUST_BEAN = (PM_IL_RI_POOL_CUST) dataTableList
					.get(currRowIndex);
			// Update the record to database
			if (PM_IL_RI_POOL_CUST_BEAN.getROWID() != null) {
				rowUpdated = pm_il_ri_pool_cust_delegate
						.updateData(PM_IL_RI_POOL_CUST_BEAN);
				if (rowUpdated > 0) {
					getWarningMap().put("somekey",
							rowUpdated + " record updated.");
					getWarningMap().put("current",
							rowUpdated + " record updated.");
				}
			} else {
				setValues();
//				PM_IL_RI_POOL_CUST_BEAN.setRPCUST_CR_UID("LIFE");
				rowUpdated = pm_il_ri_pool_cust_delegate
						.updateData(PM_IL_RI_POOL_CUST_BEAN);
				if (rowUpdated > 0) {
					getWarningMap().put("somekey",
							rowUpdated + " record inserted.");
					getWarningMap().put("current",
							rowUpdated + " record inserted.");
				}
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			e1.printStackTrace();
			getWarningMap().put("update", rowUpdated + " record NOT updated.");
			getWarningMap().put("current", rowUpdated + " record NOT updated.");
		}
		return;
	}

	public String addRow() {
		int rowCount = 0;
		if (dataTableList == null) {
			dataTableList = new ArrayList();
		}
		PM_IL_RI_POOL_CUST pm_il_ri_pool_cust = new PM_IL_RI_POOL_CUST();
		dataTableList.add(pm_il_ri_pool_cust);
		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
		currentPage = rowCount / recordPerPage;
		if (rowCount % recordPerPage > 0) {
			currentPage++;
		}
		return "newadded";
	}

	public String deleteRow() {
		PM_IL_RI_POOL_CUST bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		PM_IL_RI_POOL_CUST_DELEGATE pm_il_ri_pool_cust_delegate = new PM_IL_RI_POOL_CUST_DELEGATE();
		if (dataTableList != null) {
			deletedRecordList = new ArrayList();
			for (int index = 0; index < dataTableList.size();) {
				bean = (PM_IL_RI_POOL_CUST) dataTableList.get(index);
				//if (bean.isCHECKBOX()) {
				if("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())){
					dataTableList.remove(bean);
					deletedRecordIndex = pm_il_ri_pool_cust_delegate
							.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			
			if(dataTableList!=null && dataTableList.size()>0){
				for(int i=0;i<dataTableList.size();i++){
					PM_IL_RI_POOL_CUST pm_il_ri_pool_cust = dataTableList.get(i);
					if(i==0){
						pm_il_ri_pool_cust.setRowSelected(true);
						setPM_IL_RI_POOL_CUST_BEAN(pm_il_ri_pool_cust);
					}else{
						pm_il_ri_pool_cust.setRowSelected(false);
					}
				}
			}
			
			if(dataTableList.isEmpty()){
				PM_IL_RI_POOL_CUST_BEAN = new PM_IL_RI_POOL_CUST();
				setPM_IL_RI_POOL_CUST_BEAN(PM_IL_RI_POOL_CUST_BEAN);
				resetAllComponent();
			}
			
			if(deletedRecordList.size()>0)
			{
				getErrorMap().put("somekey", deletedRecordList.size()+" records deleted.");
				getErrorMap().put("current", deletedRecordList.size()+" records deleted.");
			}
			lastUpdatedRowIndex = -1;
		}
		return "";
	}

	public void setErrorMessagesInMap(ActionEvent event) {
		CommonUtils.clearMaps(this);
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;
		CommonUtils.clearMaps(this);
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			
			}
		}
		return value;
	}

	

	

	public List getRI_POOL_CUST_LIST() {
		return RI_POOL_CUST_LIST;
	}

	public void setRI_POOL_CUST_LIST(List ri_pool_cust_list) {
		RI_POOL_CUST_LIST = ri_pool_cust_list;
	}

	/*
	 * Suggestion Box for Customer Code
	 */
	public List customerActionSuggestionAction(Object event) throws DBException {
		PM_IL_RI_POOL_CUST_DELEGATE pm_il_ri_pool_cust_delegate = new PM_IL_RI_POOL_CUST_DELEGATE();

		String customerCode = (String) event;

		RI_POOL_CUST_LIST = pm_il_ri_pool_cust_delegate
				.prepareCustomerCodeList(customerCode, RI_POOL_CUST_LIST);
		return RI_POOL_CUST_LIST;
	}

	public void getCustomerDesc(ActionEvent event) {
		CommonUtils.clearMaps(this);
		Iterator iterator = RI_POOL_CUST_LIST.iterator();
		UISuggestionBox input = (UISuggestionBox) event.getComponent().getParent();
		String customerCode = (String)input.getSubmitedValue();
		try{		
			while (iterator.hasNext()) {
				PM_IL_RI_POOL_CUST pm_il_ri_pool_cust = (PM_IL_RI_POOL_CUST) iterator.next();
			}
			if(customerCode!=null){
			String custBean = PM_IL_RI_POOL_CUST_BEAN.getRPCUST_CODE();
			String customerDesc = getCustomerDesc(customerCode,RI_POOL_CUST_LIST);
			for(PM_IL_RI_POOL_CUST pm_il_ri_pool_cust : dataTableList){
				if("dataTableSelectedRow".equalsIgnoreCase(pm_il_ri_pool_cust.getRowSelected())){
					pm_il_ri_pool_cust.setUI_M_RPCUST_CODE_DESC(customerDesc);
					COMP_UI_M_RPCUST_CODE_DESC.setSubmittedValue(customerDesc);
				}
			}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String getCustomerDesc(String customerCode, List RI_POOL_CUST_LIST) throws Exception {
		Iterator iterator = RI_POOL_CUST_LIST.iterator();
		String customerDesc = null;
		try{
			while (iterator.hasNext()) {
				PM_IL_RI_POOL_CUST pm_il_ri_pool_cust = (PM_IL_RI_POOL_CUST) iterator.next();
				if (customerCode.equalsIgnoreCase(pm_il_ri_pool_cust.getRPCUST_CODE())) {
					customerDesc = pm_il_ri_pool_cust.getUI_M_RPCUST_CODE_DESC();
				}
			}
			if (customerDesc == null) {
			throw new Exception("Code does not exists. Please Re-enter");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return customerDesc;
	}



	public void validateRPCUST_CODE(FacesContext fc, UIComponent component,Object value) throws ValidatorException {

		
		String RPCUST_CODE_STRING = (String) value;
		PM_IL_RI_POOL_CUST_BEAN.setRPCUST_CODE(RPCUST_CODE_STRING);
		try {
			if (PM_IL_RI_POOL_CUST_BEAN.getROWID() == null) {
				helper.RPCUST_CODE_WHEN_VALIDATE_ITEM(RPCUST_CODE_STRING);
				String customerDesc = getCustomerDesc(RPCUST_CODE_STRING,RI_POOL_CUST_LIST);
				PM_IL_RI_POOL_CUST_BEAN.setUI_M_RPCUST_CODE_DESC(customerDesc);
				COMP_UI_M_RPCUST_CODE_DESC.setSubmittedValue(customerDesc);
			}else{
				helper.RPCUST_CODE_WHEN_VALIDATE_ITEM_UPDATE(RPCUST_CODE_STRING);
				customerActionSuggestionAction(RPCUST_CODE_STRING);
				String customerDesc = getCustomerDesc(RPCUST_CODE_STRING,RI_POOL_CUST_LIST);
				PM_IL_RI_POOL_CUST_BEAN.setUI_M_RPCUST_CODE_DESC(customerDesc);
				COMP_UI_M_RPCUST_CODE_DESC.setSubmittedValue(customerDesc);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	
	public void validateRPCUST_SHARE_PERC(FacesContext fc,UIComponent component, Object value) throws ValidatorException{
		try{
		
			
			Double RPCUST_SHARE_PERC_DOUBLE =  (Double)value;
			PM_IL_RI_POOL_CUST_BEAN.setRPCUST_SHARE_PERC(RPCUST_SHARE_PERC_DOUBLE);
			helper.RPCUST_SHARE_PERC_WHEN_VALIDATE_ITEM(RPCUST_SHARE_PERC_DOUBLE, this);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
		


	public void validateRPCUST_NEW_COMM(FacesContext fc, UIComponent component,Object value) throws ValidatorException {
		try{
			
			Double RPCUST_NEW_COMM_DOUBLE =  (Double) value;
			PM_IL_RI_POOL_CUST_BEAN.setRPCUST_NEW_COMM(RPCUST_NEW_COMM_DOUBLE);	
			helper.RPCUST_NEW_COMM_WHEN_VALIDATE_ITEM(RPCUST_NEW_COMM_DOUBLE);

		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
		
		
	
	public void validateRPCUST_REN_COMM(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		try{
			
			Double RPCUST_REN_COMM_DOUBLE =  (Double) value;
			PM_IL_RI_POOL_CUST_BEAN.setRPCUST_REN_COMM(RPCUST_REN_COMM_DOUBLE);
			helper.RPCUST_REN_COMM_WHEN_VALIDATE_ITEM(RPCUST_REN_COMM_DOUBLE);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}

	
	
	public void validateRPCUST_NEW_TAX(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		try{
			
			
			Double RPCUST_NEW_TAX_DOUBLE =  (Double) value;
			PM_IL_RI_POOL_CUST_BEAN.setRPCUST_NEW_TAX(RPCUST_NEW_TAX_DOUBLE);
			helper.RPCUST_NEW_TAX_WHEN_VALIDATE_ITEM(RPCUST_NEW_TAX_DOUBLE);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

		
	public void validateRPCUST_REN_TAX(FacesContext fc, UIComponent component,Object value) throws ValidatorException {
		try{
			
			Double RPCUST_REN_TAX_DOUBLE =  (Double)value;
			PM_IL_RI_POOL_CUST_BEAN.setRPCUST_REN_TAX(RPCUST_REN_TAX_DOUBLE);
			helper.RPCUST_REN_TAX_WHEN_VALIDATE_ITEM(RPCUST_REN_TAX_DOUBLE);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}


	
	public void validateRPCUST_RETRO_SHARE_PERC(FacesContext fc,UIComponent component, Object value) throws ValidatorException {
		try{
		
			Double RPCUST_RETRO_SHARE_PERC_DOUBLE = (Double) value;
			PM_IL_RI_POOL_CUST_BEAN.setRPCUST_RETRO_SHARE_PERC(RPCUST_RETRO_SHARE_PERC_DOUBLE);
			Double RPCUST_SHARE_PERC_DOUBLE = PM_IL_RI_POOL_CUST_BEAN.getRPCUST_SHARE_PERC();
			helper.RPCUST_RETRO_SHARE_PERC_WHEN_VALIDATE_ITEM(RPCUST_RETRO_SHARE_PERC_DOUBLE, RPCUST_SHARE_PERC_DOUBLE, this);
			//helper.RPCUST_RETRO_SHARE_PERC_KEY_NEXT_ITEM(RPCUST_RETRO_SHARE_PERC_DOUBLE, this);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void validateRPCUST_RETRO_NEW_COMM(FacesContext fc,UIComponent component, Object value) throws ValidatorException {
		try{
			
			Double RPCUST_RETRO_NEW_COMM_DOUBLE = (Double) value;
			PM_IL_RI_POOL_CUST_BEAN.setRPCUST_RETRO_NEW_COMM(RPCUST_RETRO_NEW_COMM_DOUBLE);
			helper.RPCUST_RETRO_NEW_COMM_WHEN_VALIDATE_ITEM(RPCUST_RETRO_NEW_COMM_DOUBLE);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}


	
	public void validateRPCUST_RETRO_REN_COMM(FacesContext fc,UIComponent component, Object value) throws ValidatorException{
		try{
			
			Double RPCUST_RETRO_REN_COMM_DOUBLE = (Double) value;
			PM_IL_RI_POOL_CUST_BEAN.setRPCUST_RETRO_REN_COMM(RPCUST_RETRO_REN_COMM_DOUBLE);
			helper.RPCUST_RETRO_REN_COMM_WHEN_VALIDATE_ITEM(RPCUST_RETRO_REN_COMM_DOUBLE);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	
	
	public void validateRPCUST_RETRO_NEW_TAX(FacesContext fc,UIComponent component, Object value) throws ValidatorException {
		try{
			
			Double RPCUST_RETRO_NEW_TAX_DOUBLE = (Double) value;
			PM_IL_RI_POOL_CUST_BEAN.setRPCUST_RETRO_NEW_TAX(RPCUST_RETRO_NEW_TAX_DOUBLE);
			helper.RPCUST_RETRO_NEW_TAX_WHEN_VALIDATE_ITEM(RPCUST_RETRO_NEW_TAX_DOUBLE);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}


	public void validateRPCUST_RETRO_REN_TAX(FacesContext fc,UIComponent component, Object value) throws ValidatorException {
		try{
			
			Double RPCUST_RETRO_REN_TAX_DOUBLE = (Double) value;
			PM_IL_RI_POOL_CUST_BEAN.setRPCUST_RETRO_REN_TAX(RPCUST_RETRO_REN_TAX_DOUBLE);
			helper.RPCUST_RETRO_REN_TAX_WHEN_VALIDATE_ITEM(RPCUST_RETRO_REN_TAX_DOUBLE);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	

	/*
	 * Navigation to Charge Details JSP.
	 */
	public String chargeDetails() {
	
		if (dataTableList != null) {
			for (int index = 0; index < dataTableList.size(); index++) {
				PM_IL_RI_POOL_CUST PM_IL_RI_POOL_CUST_BEAN = (PM_IL_RI_POOL_CUST) dataTableList
						.get(index);
				//if (PM_IL_RI_POOL_CUST_BEAN.isCHECKBOX()) {
				if("dataTableSelectedRow".equalsIgnoreCase(PM_IL_RI_POOL_CUST_BEAN.getRowSelected())){
					PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils()
							.getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
					String poolCode = pm_il_ri_pool_setup_composite_action
							.getPM_IL_RI_POOL_SETUP_ACTION()
							.getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE();
					String coverCode1 = pm_il_ri_pool_setup_composite_action
							.getPM_IL_RI_POOL_CUST_ACTION()
							.getPM_IL_RI_POOL_CUST_BEAN()
							.getRPCUST_RPCVR_CODE();
	
					pm_il_ri_pool_setup_composite_action
							.getPM_IL_RI_CUST_CHRG_ACTION()
							.getPM_IL_RI_CUST_CHRG_BEAN().setRCC_RPCVR_CODE(
									coverCode1);
					String customerCode = PM_IL_RI_POOL_CUST_BEAN
							.getRPCUST_CODE();
					pm_il_ri_pool_setup_composite_action
							.getPM_IL_RI_CUST_CHRG_ACTION()
							.getPM_IL_RI_CUST_CHRG_BEAN().setRCC_RPCUST_CODE(
									customerCode);
	

					PM_IL_RI_CUST_CHRG_DELEGATE pm_il_ri_cust_chrg_delegate = new PM_IL_RI_CUST_CHRG_DELEGATE();
					pm_il_ri_pool_setup_composite_action
							.getPM_IL_RI_CUST_CHRG_ACTION().getDataTableList()
							.clear();
					// getPM_IL_RI_POOL_COVER_ACTION().getDataTableList().clear();
					List outputList = pm_il_ri_cust_chrg_delegate
							.getChargeDetailsValues(poolCode, coverCode1,
									customerCode);
					System.out.println("SIZE:====================>SYSYS::::::" + outputList.size());
					if (outputList.size() > 0) {
						pm_il_ri_pool_setup_composite_action
								.getPM_IL_RI_CUST_CHRG_ACTION()
								.getDataTableList().clear();
						for (int count = 0; count < outputList.size(); count++) {
							PM_IL_RI_CUST_CHRG pm_il_ri_cust_chrg = (PM_IL_RI_CUST_CHRG) outputList
									.get(count);
							pm_il_ri_pool_setup_composite_action
									.getPM_IL_RI_CUST_CHRG_ACTION()
									.getDataTableList().add(pm_il_ri_cust_chrg);
						}
					}
					
					//For Defalult Seleet
					List<PM_IL_RI_CUST_CHRG> list = pm_il_ri_pool_setup_composite_action.getPM_IL_RI_CUST_CHRG_ACTION().getDataTableList();
					for(int i=0;i<list.size();i++){
						PM_IL_RI_CUST_CHRG pm_il_ri_cust_chrg = list.get(i);
						if(i==0){
							pm_il_ri_cust_chrg.setRowSelected(true);
							pm_il_ri_pool_setup_composite_action.getPM_IL_RI_CUST_CHRG_ACTION().setPM_IL_RI_CUST_CHRG_BEAN(pm_il_ri_cust_chrg);
						}else{
							pm_il_ri_cust_chrg.setRowSelected(false);
						}
					}
					
					
					return "PILM043_PM_IL_RI_CUST_CHRG";
				}
			}
		}
		return "";
	}

	public void checkBoxValidation(ActionEvent event) {
		//gridtabListener();
	}

	public String back() {
		this.getDataTableList().clear();
		resetAllComponent();
		setBlockFlag(true);
		return "PILM043_PM_IL_RI_POOL_COVER";
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		getCurrentValue(actionEvent);
		return "";
	}

	public String combinedSave() {
		/**
		 * Share Percentage Logic The percentage given in Cover Block should be
		 * the total of percentages given in the customer block. Otherwise
		 * system should not allow to save the customer details block. Example
		 * cover1-50 customer1-20 customer2-30. - allow save. Cover2-75 -
		 * customer1-50 - donot allow to save. either customer1 should be 75 or
		 * new customer with 25 should be added.
		 */
	
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
		int coverRowCount = pm_il_ri_pool_setup_composite_action
				.getPM_IL_RI_POOL_COVER_ACTION().getDataTable().getRowCount();
		Double sharePercentage = 0.0;
		for (int index = 0; index < coverRowCount; index++) {
			PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = (PM_IL_RI_POOL_COVER) pm_il_ri_pool_setup_composite_action
					.getPM_IL_RI_POOL_COVER_ACTION().getDataTableList().get(
							index);
			if (pm_il_ri_pool_cover.isCHECKBOX()) {
				sharePercentage = pm_il_ri_pool_cover.getRPCVR_SHARE_PERC();
			}
		}

		int custRowCount = pm_il_ri_pool_setup_composite_action
				.getPM_IL_RI_POOL_CUST_ACTION().getDataTable().getRowCount();
		Double percentageSum = 0.0;
		for (int index = 0; index < custRowCount; index++) {
			PM_IL_RI_POOL_CUST pm_il_ri_pool_cust = (PM_IL_RI_POOL_CUST) pm_il_ri_pool_setup_composite_action
					.getPM_IL_RI_POOL_CUST_ACTION().getDataTableList().get(
							index);
			percentageSum = pm_il_ri_pool_cust.getRPCUST_SHARE_PERC()
					+ percentageSum;
		}
		
		try {
			if (percentageSum < sharePercentage
					|| percentageSum > sharePercentage) {
				throw new ValidatorException(Messages.getMessage(
						"messageProperties_PILM043",
						"PILM043$PM_IL_RI_POOL_CUST$SHARE_PERCENTAGE$ERROR", new Object[]{sharePercentage}));
			} else {
				
				helper.sharePercentageLogic();
				PM_IL_RI_POOL_CUST_DELEGATE pm_il_ri_pool_cust_delegate = new PM_IL_RI_POOL_CUST_DELEGATE();
				pm_il_ri_pool_cust_delegate.saveData();
			}
		} catch (ValidatorException validatorException) {
			String validationError = validatorException.getMessage();
			
			this.getErrorMap().put("current", validationError);
		}

		return "";
	}
	// [ Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 13-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListener();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	// [ Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 13-Feb-2009

	/**
	 * @return the filterByUI_M_RPCUST_CODE_DESC
	 */
	public String getFilterByUI_M_RPCUST_CODE_DESC() {
		return filterByUI_M_RPCUST_CODE_DESC;
	}

	/**
	 * @param filterByUI_M_RPCUST_CODE_DESC the filterByUI_M_RPCUST_CODE_DESC to set
	 */
	public void setFilterByUI_M_RPCUST_CODE_DESC(
			String filterByUI_M_RPCUST_CODE_DESC) {
		this.filterByUI_M_RPCUST_CODE_DESC = filterByUI_M_RPCUST_CODE_DESC;
	}

	/**
	 * @return the filterByRPCUST_CODE
	 */
	public String getFilterByRPCUST_CODE() {
		return filterByRPCUST_CODE;
	}

	/**
	 * @param filterByRPCUST_CODE the filterByRPCUST_CODE to set
	 */
	public void setFilterByRPCUST_CODE(String filterByRPCUST_CODE) {
		this.filterByRPCUST_CODE = filterByRPCUST_CODE;
	}

	/**
	 * @return the filterByRPCUST_SHARE_PERC
	 */
	public String getFilterByRPCUST_SHARE_PERC() {
		return filterByRPCUST_SHARE_PERC;
	}

	/**
	 * @param filterByRPCUST_SHARE_PERC the filterByRPCUST_SHARE_PERC to set
	 */
	public void setFilterByRPCUST_SHARE_PERC(String filterByRPCUST_SHARE_PERC) {
		this.filterByRPCUST_SHARE_PERC = filterByRPCUST_SHARE_PERC;
	}

	/**
	 * @return the filterByRPCUST_NEW_COMM
	 */
	public String getFilterByRPCUST_NEW_COMM() {
		return filterByRPCUST_NEW_COMM;
	}

	/**
	 * @param filterByRPCUST_NEW_COMM the filterByRPCUST_NEW_COMM to set
	 */
	public void setFilterByRPCUST_NEW_COMM(String filterByRPCUST_NEW_COMM) {
		this.filterByRPCUST_NEW_COMM = filterByRPCUST_NEW_COMM;
	}

	/**
	 * @return the filterByRPCUST_REN_COMM
	 */
	public String getFilterByRPCUST_REN_COMM() {
		return filterByRPCUST_REN_COMM;
	}

	/**
	 * @param filterByRPCUST_REN_COMM the filterByRPCUST_REN_COMM to set
	 */
	public void setFilterByRPCUST_REN_COMM(String filterByRPCUST_REN_COMM) {
		this.filterByRPCUST_REN_COMM = filterByRPCUST_REN_COMM;
	}

	/**
	 * @return the filterByRPCUST_REN_TAX
	 */
	public String getFilterByRPCUST_REN_TAX() {
		return filterByRPCUST_REN_TAX;
	}

	/**
	 * @param filterByRPCUST_REN_TAX the filterByRPCUST_REN_TAX to set
	 */
	public void setFilterByRPCUST_REN_TAX(String filterByRPCUST_REN_TAX) {
		this.filterByRPCUST_REN_TAX = filterByRPCUST_REN_TAX;
	}

	/**
	 * @return the filterByRPCUST_NEW_TAX
	 */
	public String getFilterByRPCUST_NEW_TAX() {
		return filterByRPCUST_NEW_TAX;
	}

	/**
	 * @param filterByRPCUST_NEW_TAX the filterByRPCUST_NEW_TAX to set
	 */
	public void setFilterByRPCUST_NEW_TAX(String filterByRPCUST_NEW_TAX) {
		this.filterByRPCUST_NEW_TAX = filterByRPCUST_NEW_TAX;
	}

	/**
	 * @return the filterByRPCUST_RETRO_NEW_COMM
	 */
	public String getFilterByRPCUST_RETRO_NEW_COMM() {
		return filterByRPCUST_RETRO_NEW_COMM;
	}

	/**
	 * @param filterByRPCUST_RETRO_NEW_COMM the filterByRPCUST_RETRO_NEW_COMM to set
	 */
	public void setFilterByRPCUST_RETRO_NEW_COMM(
			String filterByRPCUST_RETRO_NEW_COMM) {
		this.filterByRPCUST_RETRO_NEW_COMM = filterByRPCUST_RETRO_NEW_COMM;
	}

	/**
	 * @return the filterByRPCUST_RETRO_SHARE_PERC
	 */
	public String getFilterByRPCUST_RETRO_SHARE_PERC() {
		return filterByRPCUST_RETRO_SHARE_PERC;
	}

	/**
	 * @param filterByRPCUST_RETRO_SHARE_PERC the filterByRPCUST_RETRO_SHARE_PERC to set
	 */
	public void setFilterByRPCUST_RETRO_SHARE_PERC(
			String filterByRPCUST_RETRO_SHARE_PERC) {
		this.filterByRPCUST_RETRO_SHARE_PERC = filterByRPCUST_RETRO_SHARE_PERC;
	}

	/**
	 * @return the filterByRPCUST_RETRO_REN_COMM
	 */
	public String getFilterByRPCUST_RETRO_REN_COMM() {
		return filterByRPCUST_RETRO_REN_COMM;
	}

	/**
	 * @param filterByRPCUST_RETRO_REN_COMM the filterByRPCUST_RETRO_REN_COMM to set
	 */
	public void setFilterByRPCUST_RETRO_REN_COMM(
			String filterByRPCUST_RETRO_REN_COMM) {
		this.filterByRPCUST_RETRO_REN_COMM = filterByRPCUST_RETRO_REN_COMM;
	}

	/**
	 * @return the filterByRPCUST_RETRO_NEW_TAX
	 */
	public String getFilterByRPCUST_RETRO_NEW_TAX() {
		return filterByRPCUST_RETRO_NEW_TAX;
	}

	/**
	 * @param filterByRPCUST_RETRO_NEW_TAX the filterByRPCUST_RETRO_NEW_TAX to set
	 */
	public void setFilterByRPCUST_RETRO_NEW_TAX(String filterByRPCUST_RETRO_NEW_TAX) {
		this.filterByRPCUST_RETRO_NEW_TAX = filterByRPCUST_RETRO_NEW_TAX;
	}

	/**
	 * @return the filterByRPCUST_RETRO_REN_TAX
	 */
	public String getFilterByRPCUST_RETRO_REN_TAX() {
		return filterByRPCUST_RETRO_REN_TAX;
	}

	/**
	 * @param filterByRPCUST_RETRO_REN_TAX the filterByRPCUST_RETRO_REN_TAX to set
	 */
	public void setFilterByRPCUST_RETRO_REN_TAX(String filterByRPCUST_RETRO_REN_TAX) {
		this.filterByRPCUST_RETRO_REN_TAX = filterByRPCUST_RETRO_REN_TAX;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DEL
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	/**
	 * @param ui_m_but_del the uI_M_BUT_DEL to set
	 */
	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}
	
	public void post(ActionEvent ae) {
		String message = null;
		try{
			if(PM_IL_RI_POOL_CUST_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					PM_IL_RI_POOL_CUST_BEAN.setRPCUST_UPD_DT(new Date(Calendar.getInstance().getTimeInMillis()));
					PM_IL_RI_POOL_CUST_BEAN.setRPCUST_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
					new CRUDHandler().executeInsert(PM_IL_RI_POOL_CUST_BEAN, new CommonUtils().getConnection());
					message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"); 
				} else {
					getErrorMap().clear();
					message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed");
					getWarningMap().put("Current", message);
					getWarningMap().put("details", message);
				}
			} else {
				if(isINSERT_ALLOWED()) {
					setValues();
					new CRUDHandler().executeInsert(PM_IL_RI_POOL_CUST_BEAN, new CommonUtils().getConnection());
					message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"); 
					dataTableList.add(PM_IL_RI_POOL_CUST_BEAN);
					if(dataTableList.size()>0){
						for(int i=0;i<dataTableList.size();i++){
							PM_IL_RI_POOL_CUST pm_il_ri_pool_cover = dataTableList.get(i);
							if(i==0){
								pm_il_ri_pool_cover.setRowSelected(true);
								setPM_IL_RI_POOL_CUST_BEAN(pm_il_ri_pool_cover);
							}else{
								pm_il_ri_pool_cover.setRowSelected(false);
							}
						}
					}
					getWarningMap().put("Current", message);
					getWarningMap().put("details", message);
				} else {
					getErrorMap().clear();
					message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed");
					getErrorMap().put("Current", message);
					getErrorMap().put("details", message);
				}
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("post",message);
			resetAllComponent();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	/**
	 * 
	 */
	private void setValues() {
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
		String RPS_CODE = pm_il_ri_pool_setup_composite_action
				.getPM_IL_RI_POOL_SETUP_ACTION().getPM_IL_RI_POOL_SETUP_BEAN()
				.getRPS_CODE();
		
		PM_IL_RI_POOL_CUST_BEAN.setRPCUST_RPS_CODE(RPS_CODE);
		String coverCode = null;
		int custRowCount = pm_il_ri_pool_setup_composite_action
				.getPM_IL_RI_POOL_COVER_ACTION().getDataTable().getRowCount();
		for (int index = 0; index < custRowCount; index++) {
			PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = (PM_IL_RI_POOL_COVER) pm_il_ri_pool_setup_composite_action
					.getPM_IL_RI_POOL_COVER_ACTION().getDataTableList().get(
							index);
			//if (pm_il_ri_pool_cover.isCHECKBOX()) {
			if("dataTableSelectedRow".equalsIgnoreCase(pm_il_ri_pool_cover.getRowSelected())){
				coverCode = pm_il_ri_pool_cover.getRPCVR_CODE();
			}
		}

		PM_IL_RI_POOL_CUST_BEAN.setRPCUST_RPCVR_CODE(coverCode);
		String customerCode = pm_il_ri_pool_setup_composite_action
				.getPM_IL_RI_POOL_CUST_ACTION().getPM_IL_RI_POOL_CUST_BEAN()
				.getRPCUST_CODE();
		
		PM_IL_RI_POOL_CUST_BEAN.setRPCUST_CODE(customerCode);
		PM_IL_RI_POOL_CUST_BEAN.setRPCUST_CR_DT(new Date(Calendar.getInstance()
				.getTimeInMillis()));
		PM_IL_RI_POOL_CUST_BEAN.setRPCUST_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
	}
	
	private void resetAllComponent(){
		COMP_RPCUST_CODE.resetValue();
		COMP_UI_M_RPCUST_CODE_DESC.resetValue();
		COMP_RPCUST_SHARE_PERC.resetValue();
		COMP_RPCUST_NEW_COMM.resetValue();
		COMP_RPCUST_REN_COMM.resetValue();
		COMP_RPCUST_NEW_TAX.resetValue();
		COMP_RPCUST_REN_TAX.resetValue();
		COMP_RPCUST_RETRO_SHARE_PERC.resetValue();
		COMP_RPCUST_RETRO_NEW_COMM.resetValue();
		COMP_RPCUST_RETRO_REN_COMM.resetValue();
		COMP_RPCUST_RETRO_NEW_TAX.resetValue();
		COMP_RPCUST_RETRO_REN_TAX.resetValue();
	//	COMP_RPCUST_RETRO_REN_TAX.resetValue();
	}
	/**
	 * Add New component
	 * @param event
	 */
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PM_IL_RI_POOL_CUST_BEAN = new PM_IL_RI_POOL_CUST();
				resetAllComponent();
			}else{
				getErrorMap().put("somekey",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put("current",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}	
	}
	
	/**
	 * Deletes a Record from Grid/Table
	 * 
	 * @return
	 */
/*	public String deleteRow(ActionEvent ae) {

		try {
			
			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			if (dataTableList != null) {
				deleteRow();
			}
			resetAllComponent();
		}catch(Exception exception){
		}
		return "";
	}*/
	public String deleteRow(ActionEvent ae) throws Exception {
		try{
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_IL_RI_POOL_CUST bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (dataTableList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < dataTableList.size();) {
				bean = dataTableList.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
					/*Added by Ameen on 29-06-2017 as per chandramohan sugg. for : ZBILQC-1719381*/
					new CRUDHandler().executeDelete(bean,
							CommonUtils.getConnection());
					/*End*/
					dataTableList.remove(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			if(dataTableList.size() > 0) {
					setPM_IL_RI_POOL_CUST_BEAN(dataTableList.get(0));
					PM_IL_RI_POOL_CUST_BEAN.setRowSelected(true);
			} else {
				addNew(ae);
			}
			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put("details",
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
			}
			lastUpdatedRowIndex = -1;
		}
		resetAllComponent();
		resetSelectedRow();
		PM_IL_RI_POOL_CUST_BEAN.setRowSelected(true);	
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}
		return "";
	}
	
	public void addNew(ActionEvent event){
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()){		
				PM_IL_RI_POOL_CUST_BEAN = new PM_IL_RI_POOL_CUST();
				resetAllComponent();
			}else{
				getErrorMap().put("somekey",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put("current",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}	
	}
	
	public void getDetails() {
		try {
			if (dataTableList.size() != 0) {				
				PM_IL_RI_POOL_CUST_BEAN = (PM_IL_RI_POOL_CUST) dataTable.getRowData();
 			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_RI_POOL_CUST_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_RI_POOL_CUST> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	/**
	 * @return the dataTableList
	 */
	public ArrayList<PM_IL_RI_POOL_CUST> getDataTableList() {
		return dataTableList;
	}

	/**
	 * @param dataTableList the dataTableList to set
	 */
	public void setDataTableList(ArrayList<PM_IL_RI_POOL_CUST> dataTableList) {
		this.dataTableList = dataTableList;
	}
	
	public String saveAndCommit(){
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			String insertMessage = Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$save");
			getWarningMap().put("current", insertMessage);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, insertMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void save(ActionEvent actionEvent){
		CommonUtils commonUtils = new CommonUtils();
		try {

			/*ADDED BY RAJA ON 17-03-2017 FOR SSP CALL ID - ZBILQC-1719314*/
			Double SHARE_PERC = 0.0 ;
			if (dataTableList.size()!= 0) {
				
				//Added to check benificiary percentage during save
				for(PM_IL_RI_POOL_CUST  bean: this.getDataTableList()) {
					SHARE_PERC = SHARE_PERC + bean.getRPCUST_SHARE_PERC();
				}
				if(SHARE_PERC != null){
					if (SHARE_PERC > compositeAction.getPM_IL_RI_POOL_COVER_ACTION().getPM_IL_RI_POOL_COVER_BEAN().getRPCVR_SHARE_PERC()) {
						/*Added by saritha on 31-May-2017 for ssp call id ZBILQC-1719314*/
						/*throw new Exception("Total Share Percentage Shoud be less or equals FAC Cover Percentage");*/
						throw new Exception("Total Share Percentage Shoud be equals to FAC Cover Percentage");
					    /*End*/
					}
				}
			}
			
			/*end*/
			
			commonUtils.doComitt();
			String insertMessage = Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, insertMessage);
			getWarningMap().put("current", insertMessage);
			getWarningMap().put("detail", insertMessage);
			/*commonUtils.doComitt();
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));*/
		} catch (Exception e) {
			getErrorMap().put("current",
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
			
		}
	}
	public void saveRecord() {
		try {
			CommonUtils.clearMaps(this);
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	
	public void validatePILM039User(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void onLoad(PhaseEvent event){
		/*ADDED BY RAJA ON 17-03-2017 FOR SSP CALL ID - ZBILQC-1719314*/
		
		/*CommonUtils.clearMaps(this);*/
		
		/*END*/
		if (isBlockFlag()) {
			getCustomerDetailsValues();
			setBlockFlag(false);
		}
	}
	
	public void getCustomerDetailsValues(){
		ResultSet resultSet = null,resultSet2=null;
		List<PM_IL_RI_POOL_CUST> result = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			result = new ArrayList<PM_IL_RI_POOL_CUST>();
			String queryString ="SELECT  PM_IL_RI_POOL_CUST.*,PM_IL_RI_POOL_CUST.ROWID  FROM PM_IL_RI_POOL_CUST WHERE  RPCUST_RPS_CODE   =   ?   AND   RPCUST_RPCVR_CODE  =  ?   ";
			PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION compositeAction = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");

			dataTableList.clear();
			resultSet = handler.executeSelectStatement(queryString, connection,
					new Object[]{compositeAction.getPM_IL_RI_POOL_SETUP_ACTION().getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE(),
								compositeAction.getPM_IL_RI_POOL_COVER_ACTION().getPM_IL_RI_POOL_COVER_BEAN().getRPCVR_CODE()});
			while (resultSet.next()) {
				PM_IL_RI_POOL_CUST pm_il_ri_pool_cust = new PM_IL_RI_POOL_CUST();
				pm_il_ri_pool_cust.setRPCUST_RPS_CODE(resultSet.getString("RPCUST_RPS_CODE"));
				pm_il_ri_pool_cust.setRPCUST_RPCVR_CODE(resultSet.getString("RPCUST_RPCVR_CODE"));
				pm_il_ri_pool_cust.setRPCUST_CODE(resultSet.getString("RPCUST_CODE"));
				pm_il_ri_pool_cust.setRPCUST_SHARE_PERC(resultSet.getDouble("RPCUST_SHARE_PERC"));
				pm_il_ri_pool_cust.setRPCUST_NEW_COMM(resultSet.getDouble("RPCUST_NEW_COMM"));
				pm_il_ri_pool_cust.setRPCUST_REN_COMM(resultSet.getDouble("RPCUST_REN_COMM"));
				pm_il_ri_pool_cust.setRPCUST_NEW_TAX(resultSet.getDouble("RPCUST_NEW_TAX"));
				pm_il_ri_pool_cust.setRPCUST_REN_TAX(resultSet.getDouble("RPCUST_REN_TAX"));
				pm_il_ri_pool_cust.setRPCUST_RETRO_SHARE_PERC(resultSet.getDouble("RPCUST_RETRO_SHARE_PERC"));
				pm_il_ri_pool_cust.setRPCUST_RETRO_NEW_COMM(resultSet.getDouble("RPCUST_RETRO_NEW_COMM"));
				pm_il_ri_pool_cust.setRPCUST_RETRO_REN_COMM(resultSet.getDouble("RPCUST_RETRO_REN_COMM"));
				pm_il_ri_pool_cust.setRPCUST_RETRO_NEW_TAX(resultSet.getDouble("RPCUST_RETRO_NEW_TAX"));
				pm_il_ri_pool_cust.setRPCUST_RETRO_REN_TAX(resultSet.getDouble("RPCUST_RETRO_REN_TAX"));
				pm_il_ri_pool_cust.setRPCUST_CR_DT(resultSet.getDate("RPCUST_CR_DT"));
				pm_il_ri_pool_cust.setRPCUST_CR_UID(resultSet.getString("RPCUST_CR_UID"));
				pm_il_ri_pool_cust.setRPCUST_UPD_DT(resultSet.getDate("RPCUST_UPD_DT"));
				pm_il_ri_pool_cust.setRPCUST_UPD_UID(resultSet.getString("RPCUST_UPD_UID"));
				pm_il_ri_pool_cust.setROWID(resultSet.getString("ROWID"));
				//customerActionSuggestionAction(pm_il_ri_pool_cust.getRPCUST_CODE());
				//String customerDesc = getCustomerDesc(pm_il_ri_pool_cust.getRPCUST_CODE(),RI_POOL_CUST_LIST);
				/*ADDED BY GOPI on 25/01/18*/
				String query="SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE=?";
				String desc=null;
				resultSet2 = handler.executeSelectStatement(query, connection,
						new Object[]{pm_il_ri_pool_cust.getRPCUST_CODE()});
				if(resultSet2.next()) {
					desc=resultSet2.getString("CUST_NAME");
				}
				//END
				
				/*pm_il_ri_pool_cust.setUI_M_RPCUST_CODE_DESC(customerDesc);*/
				pm_il_ri_pool_cust.setUI_M_RPCUST_CODE_DESC(desc);
				dataTableList.add(pm_il_ri_pool_cust);
			}
			if (dataTableList.size() > 0) {
				PM_IL_RI_POOL_CUST_BEAN = dataTableList.get(0);
				PM_IL_RI_POOL_CUST_BEAN.setRowSelected(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
