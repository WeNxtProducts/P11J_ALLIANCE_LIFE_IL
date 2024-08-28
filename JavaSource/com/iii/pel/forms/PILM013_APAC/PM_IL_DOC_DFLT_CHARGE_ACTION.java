package com.iii.pel.forms.PILM013_APAC;

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
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_DOC_DFLT_CHARGE_ACTION extends CommonAction {

	
//ADDED BY SARITHA
	
	
	private static final String TH_DESC = null;

	private static final String TH_CODE = null;
		
	//END
	
	private HtmlOutputLabel COMP_DDCHG_SR_NO_LABEL;

	private HtmlInputText COMP_DDCHG_SR_NO;
	
	/*Newly added by pidugu raj dt: 24-09-2018 as suggested by sivaraman and vaitheeswaran*/
	private HtmlOutputLabel COMP_DDCHG_CHARGE_MAX;
	private HtmlInputText COMP_DDCHG_CHARGE_MAX_LMT;
	
	/*End Newly added by pidugu raj dt: 24-09-2018 as suggested by sivaraman and vaitheeswaran*/

	private HtmlOutputLabel COMP_DDCHG_CODE_LABEL;

	private HtmlInputText COMP_DDCHG_CODE;

	private HtmlOutputLabel COMP_DDCHG_RATE_LABEL;

	private HtmlInputText COMP_DDCHG_RATE;

	private HtmlOutputLabel COMP_DDCHG_RATE_PER_LABEL;

	private HtmlInputText COMP_DDCHG_RATE_PER;

	private HtmlOutputLabel COMP_DDCHG_APPLIED_ON_LABEL;

	private HtmlSelectOneMenu COMP_DDCHG_APPLIED_ON;

	private HtmlOutputLabel COMP_DDCHG_CUST_SHARE_PERC_LABEL;

	private HtmlInputText COMP_DDCHG_CUST_SHARE_PERC;

	private HtmlOutputLabel COMP_DDCHG_APPLY_PERIOD_LABEL;

	private HtmlSelectOneMenu COMP_DDCHG_APPLY_PERIOD;

	private HtmlOutputLabel COMP_DDCHG_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_DDCHG_EFF_FM_DT;

	private HtmlOutputLabel COMP_DDCHG_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_DDCHG_EFF_TO_DT;

	private HtmlOutputLabel COMP_UI_M_DDCHG_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DDCHG_CODE_DESC;

	private PM_IL_DOC_DFLT_CHARGE PM_IL_DOC_DFLT_CHARGE_BEAN;

	private ArrayList<SelectItem> DDCHG_APPLIED_ON_ARRAYLIST;

	private ArrayList<SelectItem> DDCHG_APPLY_PERIOD_ARRAYLIST;

	private PM_IL_DOC_DFLT_CHARGE_DELEGATE pm_il_doc_dflt_charge_delegate;

	private PM_IL_DOC_DFLT_CHARGE_HELPER pm_il_doc_dflt_charge_helper;

	private List catgCodeList;

	// filters
	private String filterByDDCHG_CODE;

	private String filterByDDCHG_RATE;

	private String filterByDDCHG_CUST_SHARE_PERC;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private int recordPerPage = 5;
	private ArrayList dataTableList = null;
	private UIData dataTable;
	private int currentPage;
	private int lastUpdatedRowIndex;
	private int prevRowIndex;
	private ControlBean controlBean;
	private CommonUtils commonUtils;
	
	public PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeAction;
	
	
	private HtmlInputText COMP_DDCHG_DS_CHG_TAR_CODE;
	
	/*added by janani on 18.3.2016*/
	
	private HtmlOutputLabel COMP_DPROD_CODE_LABEL;

	private HtmlInputText COMP_COMP_DPROD_CODE;
	

	public HtmlOutputLabel getCOMP_DPROD_CODE_LABEL() {
		return COMP_DPROD_CODE_LABEL;
	}

	public void setCOMP_DPROD_CODE_LABEL(HtmlOutputLabel cOMP_DPROD_CODE_LABEL) {
		COMP_DPROD_CODE_LABEL = cOMP_DPROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_COMP_DPROD_CODE() {
		return COMP_COMP_DPROD_CODE;
	}

	public void setCOMP_COMP_DPROD_CODE(HtmlInputText cOMP_COMP_DPROD_CODE) {
		COMP_COMP_DPROD_CODE = cOMP_COMP_DPROD_CODE;
	}

	/*Added by saritha 5.4.2016 */
	
	private HtmlOutputLabel COMP_TARIFF_CODE_LABEL;
	private HtmlInputText COMP_TARIFF_CODE;

		public HtmlOutputLabel getCOMP_TARIFF_CODE_LABEL() {
			return COMP_TARIFF_CODE_LABEL;
		}

		public void setCOMP_TARIFF_CODE_LABEL(HtmlOutputLabel cOMP_TARIFF_CODE_LABEL) {
			COMP_TARIFF_CODE_LABEL = cOMP_TARIFF_CODE_LABEL;
		}

		public HtmlInputText getCOMP_TARIFF_CODE() {
			return COMP_TARIFF_CODE;
		}

		public void setCOMP_TARIFF_CODE(HtmlInputText cOMP_TARIFF_CODE) {
			COMP_TARIFF_CODE = cOMP_TARIFF_CODE;
		}
	
	/*End*/
		
	public PM_IL_DOC_DFLT_CHARGE_ACTION() {
		commonUtils = new CommonUtils();
		controlBean = new ControlBean();
		dataTableList = new ArrayList<PM_IL_DOC_DFLT_CHARGE>();
		PM_IL_DOC_DFLT_CHARGE_BEAN = new PM_IL_DOC_DFLT_CHARGE();
		pm_il_doc_dflt_charge_delegate = new PM_IL_DOC_DFLT_CHARGE_DELEGATE();
		pm_il_doc_dflt_charge_helper = new PM_IL_DOC_DFLT_CHARGE_HELPER();
		List outputList = new ArrayList();

		try {
			/* ComboBox Items */
			DDCHG_APPLIED_ON_ARRAYLIST = pm_il_doc_dflt_charge_delegate
					.fetchComboBoxValues(
							PM_IL_DOC_DFLT_CHARGE_CONSTANTS.MSG$PILM013_APAC,
							PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DFLT_CHARGE,
							PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DDCHG_APPLIED_ON);
			DDCHG_APPLY_PERIOD_ARRAYLIST = pm_il_doc_dflt_charge_delegate
					.fetchComboBoxValues(
							PM_IL_DOC_DFLT_CHARGE_CONSTANTS.MSG$PILM013_APAC,
							PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DFLT_CHARGE,
							PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DDCHG_APPLY_PERIOD);
			outputList = pm_il_doc_dflt_charge_delegate
					.getDocumentDefaultChargeValues();

		} catch (Exception e) {
			e.printStackTrace();
		}
		currentPage = 1;
		prevRowIndex = 0;
	}

	public HtmlOutputLabel getCOMP_DDCHG_SR_NO_LABEL() {
		return COMP_DDCHG_SR_NO_LABEL;
	}

	public HtmlInputText getCOMP_DDCHG_SR_NO() {
		return COMP_DDCHG_SR_NO;
	}

	public void setCOMP_DDCHG_SR_NO_LABEL(HtmlOutputLabel COMP_DDCHG_SR_NO_LABEL) {
		this.COMP_DDCHG_SR_NO_LABEL = COMP_DDCHG_SR_NO_LABEL;
	}

	public void setCOMP_DDCHG_SR_NO(HtmlInputText COMP_DDCHG_SR_NO) {
		this.COMP_DDCHG_SR_NO = COMP_DDCHG_SR_NO;
	}

	public HtmlOutputLabel getCOMP_DDCHG_CODE_LABEL() {
		return COMP_DDCHG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DDCHG_CODE() {
		return COMP_DDCHG_CODE;
	}

	public void setCOMP_DDCHG_CODE_LABEL(HtmlOutputLabel COMP_DDCHG_CODE_LABEL) {
		this.COMP_DDCHG_CODE_LABEL = COMP_DDCHG_CODE_LABEL;
	}

	public void setCOMP_DDCHG_CODE(HtmlInputText COMP_DDCHG_CODE) {
		this.COMP_DDCHG_CODE = COMP_DDCHG_CODE;
	}

	public HtmlOutputLabel getCOMP_DDCHG_RATE_LABEL() {
		return COMP_DDCHG_RATE_LABEL;
	}

	public HtmlInputText getCOMP_DDCHG_RATE() {
		return COMP_DDCHG_RATE;
	}

	public void setCOMP_DDCHG_RATE_LABEL(HtmlOutputLabel COMP_DDCHG_RATE_LABEL) {
		this.COMP_DDCHG_RATE_LABEL = COMP_DDCHG_RATE_LABEL;
	}

	public void setCOMP_DDCHG_RATE(HtmlInputText COMP_DDCHG_RATE) {
		this.COMP_DDCHG_RATE = COMP_DDCHG_RATE;
	}

	public HtmlOutputLabel getCOMP_DDCHG_RATE_PER_LABEL() {
		return COMP_DDCHG_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_DDCHG_RATE_PER() {
		return COMP_DDCHG_RATE_PER;
	}

	public void setCOMP_DDCHG_RATE_PER_LABEL(
			HtmlOutputLabel COMP_DDCHG_RATE_PER_LABEL) {
		this.COMP_DDCHG_RATE_PER_LABEL = COMP_DDCHG_RATE_PER_LABEL;
	}

	public void setCOMP_DDCHG_RATE_PER(HtmlInputText COMP_DDCHG_RATE_PER) {
		this.COMP_DDCHG_RATE_PER = COMP_DDCHG_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_DDCHG_APPLIED_ON_LABEL() {
		return COMP_DDCHG_APPLIED_ON_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DDCHG_APPLIED_ON() {
		return COMP_DDCHG_APPLIED_ON;
	}

	public void setCOMP_DDCHG_APPLIED_ON_LABEL(
			HtmlOutputLabel COMP_DDCHG_APPLIED_ON_LABEL) {
		this.COMP_DDCHG_APPLIED_ON_LABEL = COMP_DDCHG_APPLIED_ON_LABEL;
	}

	public void setCOMP_DDCHG_APPLIED_ON(HtmlSelectOneMenu COMP_DDCHG_APPLIED_ON) {
		this.COMP_DDCHG_APPLIED_ON = COMP_DDCHG_APPLIED_ON;
	}

	public HtmlOutputLabel getCOMP_DDCHG_CUST_SHARE_PERC_LABEL() {
		return COMP_DDCHG_CUST_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_DDCHG_CUST_SHARE_PERC() {
		return COMP_DDCHG_CUST_SHARE_PERC;
	}

	public void setCOMP_DDCHG_CUST_SHARE_PERC_LABEL(
			HtmlOutputLabel COMP_DDCHG_CUST_SHARE_PERC_LABEL) {
		this.COMP_DDCHG_CUST_SHARE_PERC_LABEL = COMP_DDCHG_CUST_SHARE_PERC_LABEL;
	}

	public void setCOMP_DDCHG_CUST_SHARE_PERC(
			HtmlInputText COMP_DDCHG_CUST_SHARE_PERC) {
		this.COMP_DDCHG_CUST_SHARE_PERC = COMP_DDCHG_CUST_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_DDCHG_APPLY_PERIOD_LABEL() {
		return COMP_DDCHG_APPLY_PERIOD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DDCHG_APPLY_PERIOD() {
		return COMP_DDCHG_APPLY_PERIOD;
	}

	public void setCOMP_DDCHG_APPLY_PERIOD_LABEL(
			HtmlOutputLabel COMP_DDCHG_APPLY_PERIOD_LABEL) {
		this.COMP_DDCHG_APPLY_PERIOD_LABEL = COMP_DDCHG_APPLY_PERIOD_LABEL;
	}

	public void setCOMP_DDCHG_APPLY_PERIOD(
			HtmlSelectOneMenu COMP_DDCHG_APPLY_PERIOD) {
		this.COMP_DDCHG_APPLY_PERIOD = COMP_DDCHG_APPLY_PERIOD;
	}

	public HtmlOutputLabel getCOMP_DDCHG_EFF_FM_DT_LABEL() {
		return COMP_DDCHG_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DDCHG_EFF_FM_DT() {
		return COMP_DDCHG_EFF_FM_DT;
	}

	public void setCOMP_DDCHG_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_DDCHG_EFF_FM_DT_LABEL) {
		this.COMP_DDCHG_EFF_FM_DT_LABEL = COMP_DDCHG_EFF_FM_DT_LABEL;
	}

	public void setCOMP_DDCHG_EFF_FM_DT(HtmlCalendar COMP_DDCHG_EFF_FM_DT) {
		this.COMP_DDCHG_EFF_FM_DT = COMP_DDCHG_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_DDCHG_EFF_TO_DT_LABEL() {
		return COMP_DDCHG_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DDCHG_EFF_TO_DT() {
		return COMP_DDCHG_EFF_TO_DT;
	}

	public void setCOMP_DDCHG_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_DDCHG_EFF_TO_DT_LABEL) {
		this.COMP_DDCHG_EFF_TO_DT_LABEL = COMP_DDCHG_EFF_TO_DT_LABEL;
	}

	public void setCOMP_DDCHG_EFF_TO_DT(HtmlCalendar COMP_DDCHG_EFF_TO_DT) {
		this.COMP_DDCHG_EFF_TO_DT = COMP_DDCHG_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_DDCHG_CODE_DESC_LABEL() {
		return COMP_UI_M_DDCHG_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DDCHG_CODE_DESC() {
		return COMP_UI_M_DDCHG_CODE_DESC;
	}

	public void setCOMP_UI_M_DDCHG_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DDCHG_CODE_DESC_LABEL) {
		this.COMP_UI_M_DDCHG_CODE_DESC_LABEL = COMP_UI_M_DDCHG_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DDCHG_CODE_DESC(
			HtmlInputText COMP_UI_M_DDCHG_CODE_DESC) {
		this.COMP_UI_M_DDCHG_CODE_DESC = COMP_UI_M_DDCHG_CODE_DESC;
	}

	public PM_IL_DOC_DFLT_CHARGE getPM_IL_DOC_DFLT_CHARGE_BEAN() {
		return PM_IL_DOC_DFLT_CHARGE_BEAN;
	}

	public void setPM_IL_DOC_DFLT_CHARGE_BEAN(
			PM_IL_DOC_DFLT_CHARGE PM_IL_DOC_DFLT_CHARGE_BEAN) {
		this.PM_IL_DOC_DFLT_CHARGE_BEAN = PM_IL_DOC_DFLT_CHARGE_BEAN;
	}

	public ArrayList<SelectItem> getDDCHG_APPLIED_ON_ARRAYLIST() {
		return DDCHG_APPLIED_ON_ARRAYLIST;
	}

	public void setDDCHG_APPLIED_ON_ARRAYLIST(
			ArrayList<SelectItem> ddchg_applied_on_arraylist) {
		DDCHG_APPLIED_ON_ARRAYLIST = ddchg_applied_on_arraylist;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public ArrayList getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(ArrayList dataTableList) {
		this.dataTableList = dataTableList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/*
	 * public void addRow(ActionEvent actionEvent){ int rowCount = 0; int
	 * serialNo = 0; if(dataTableList == null){ dataTableList = new ArrayList(); }
	 * PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge = new
	 * PM_IL_DOC_DFLT_CHARGE();
	 * 
	 * if(dataTable.getRowCount()>0) { PM_IL_DOC_DFLT_CHARGE
	 * pm_il_doc_dflt_charge2 =
	 * (PM_IL_DOC_DFLT_CHARGE)dataTableList.get(dataTable.getRowCount()-1); int
	 * sNo = pm_il_doc_dflt_charge2.getDDCHG_SR_NO();
	 * pm_il_doc_dflt_charge.setDDCHG_SR_NO(sNo+1); }else{ serialNo++;
	 * pm_il_doc_dflt_charge.setDDCHG_SR_NO(serialNo); }
	 * dataTableList.add(pm_il_doc_dflt_charge);
	 *  // Settings to navigate to last page rowCount =
	 * getDataTable().getRowCount(); currentPage = rowCount/recordPerPage;
	 * if(rowCount%recordPerPage>0){ currentPage++; }
	 * 
	 * Calling-- WHEN CREATE RECORD WHEN_CREATE_RECORD(); //return "newadded";
	 * resetAllComponent(); }
	 */

	public void addRow(ActionEvent event) {
		int rowCount = 0;
		int serialNo = 0;
		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PM_IL_DOC_DFLT_CHARGE_BEAN = new PM_IL_DOC_DFLT_CHARGE();
				resetAllComponent();
				if (dataTableList.size() > 0) {
					PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge2 = (PM_IL_DOC_DFLT_CHARGE) dataTableList
							.get(dataTable.getRowCount() - 1);
					int sNo = pm_il_doc_dflt_charge2.getDDCHG_SR_NO();
					this.PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_SR_NO(sNo + 1);
				} else {
					serialNo++;
					this.PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_SR_NO(serialNo);
				}
				
				/*added by raja on 14-08-2017 for ZBILQC-1726834*/
				
				PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_CUST_SHARE_PERC(100.0);
				/*end*/
				resetSelectedRow();
				PM_IL_DOC_DFLT_CHARGE_BEAN.setRowSelected(true);
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}

	/*
	 * public void deleteRow(ActionEvent actionEvent) { PM_IL_DOC_DFLT_CHARGE
	 * bean = null; ArrayList deletedRecordList = null; int deletedRecordIndex =
	 * 0; if(dataTableList!=null) { deletedRecordList = new ArrayList(); for(int
	 * index =0; index<dataTableList.size();) { bean = (PM_IL_DOC_DFLT_CHARGE)
	 * dataTableList.get(index); if(bean.isCHECKBOX()){ PRE DELETE
	 * PRE_DELETE(bean); dataTableList.remove(bean); deletedRecordIndex =
	 * pm_il_doc_dflt_charge_delegate.deleteData(bean);
	 * deletedRecordList.add(deletedRecordIndex); POST DELETE POST_DELETE(bean,
	 * index);
	 * 
	 * }else { index++; } }
	 * 
	 * if(deletedRecordList.size()>0) { getWarningMap().put("somekey",
	 * deletedRecordList.size()+" records deleted.");
	 * getWarningMap().put("current", deletedRecordList.size()+" records
	 * deleted."); } lastUpdatedRowIndex = -1;
	 *  }
	 * 
	 * //return ""; }
	 */

	public String deleteRow(ActionEvent ae) {

		try {

			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			PM_IL_DOC_DFLT_CHARGE bean = null;
			ArrayList<Integer> deletedRecordList = null;
			int deletedRecordIndex = 0;

			if (dataTableList != null) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < dataTableList.size();) {
					bean = (PM_IL_DOC_DFLT_CHARGE) dataTableList.get(index);
					if ("dataTableSelectedRow".equalsIgnoreCase(bean
							.getRowSelected())) {
						dataTableList.remove(bean);
						deletedRecordIndex = pm_il_doc_dflt_charge_delegate
								.deleteData(bean);
						pm_il_doc_dflt_charge_delegate.DFLT_CHARGE_POST_DELETE(
								PM_IL_DOC_DFLT_CHARGE_BEAN, index);
						deletedRecordList.add(deletedRecordIndex);

					} else {
						index++;
					}
				}
				if (dataTableList.size() > 0) {
					setPM_IL_DOC_DFLT_CHARGE_BEAN((PM_IL_DOC_DFLT_CHARGE) dataTableList
							.get(0));
					PM_IL_DOC_DFLT_CHARGE_BEAN.setRowSelected(true);
				} else {
					addRow(ae);
				}
				if (deletedRecordList.size() > 0) {
					getWarningMap().put("current",
							+deletedRecordList.size() + "Record Deleted ");

				}
				lastUpdatedRowIndex = -1;
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_DOC_DFLT_CHARGE_BEAN.setRowSelected(true);
		} catch (Exception exception) {
		}
		return "";
	}

	public void checkBoxValidation(ActionEvent event) {
		// [ Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009

		// gridtabListener();

		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009 ]
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		getCurrentValue(actionEvent);
		System.out.println("Comming to check box status");
		return "";
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}

	// [ Commented for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 13-Feb-2009

	/*
	 * public void gridtabListener(){
	 * 
	 * int currRowIndex = getDataTable().getRowIndex(); int rowUpdated = 0;
	 * PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge = null;
	 *  // DataGridValueBean gridValueBean = null;
	 * System.out.println(lastUpdatedRowIndex+" "+currRowIndex+"
	 * "+prevRowIndex); try { if(lastUpdatedRowIndex!=-1) {
	 * if(lastUpdatedRowIndex!=prevRowIndex) { if(currRowIndex != prevRowIndex){ //
	 * Get the bean based on row index pm_il_doc_dflt_charge =
	 * (PM_IL_DOC_DFLT_CHARGE)dataTableList.get(prevRowIndex);
	 *  // Update the record to database
	 * if(pm_il_doc_dflt_charge.getROWID()!=null) { rowUpdated =
	 * pm_il_doc_dflt_charge_delegate.updateData(pm_il_doc_dflt_charge);
	 * if(rowUpdated>0) { getWarningMap().put("somekey", rowUpdated+" record
	 * updated."); getWarningMap().put("current", rowUpdated+" record
	 * updated."); }
	 * 
	 * }else { String code =
	 * pm_il_doc_dflt_charge_delegate.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
	 * String type =
	 * pm_il_doc_dflt_charge_delegate.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
	 * pm_il_doc_dflt_charge.setDDCHG_DS_CODE(code);
	 * pm_il_doc_dflt_charge.setDDCHG_DS_TYPE(type);
	 * pm_il_doc_dflt_charge.setDDCHG_CR_DT(new
	 * java.sql.Date(Calendar.getInstance().getTimeInMillis()));
	 * pm_il_doc_dflt_charge.setDDCHG_CR_UID("PREMIA11");
	 * 
	 * rowUpdated =
	 * pm_il_doc_dflt_charge_delegate.updateData(pm_il_doc_dflt_charge);
	 * if(rowUpdated>0) { getWarningMap().put("somekey", rowUpdated+" record
	 * inserted."); getWarningMap().put("current", rowUpdated+" record
	 * inserted."); }
	 *  }
	 *  // Update previous row index prevRowIndex = currRowIndex; } } } } catch
	 * (Exception e1) { // TODO Put error mechanism to display user that
	 * something happened wrong while updating data e1.printStackTrace();
	 * getWarningMap().put("update", rowUpdated+" record NOT updated.");
	 * getWarningMap().put("current", rowUpdated+" record NOT updated."); }
	 * 
	 * return ; }
	 */

	// Commented for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 13-Feb-2009 ]
	public void lastColumnListener() {
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		String message = null;

		try {

			// Get the bean based on row index
			PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge = (PM_IL_DOC_DFLT_CHARGE) dataTableList
					.get(currRowIndex);
			// Update the record to database
			if (pm_il_doc_dflt_charge.getROWID() != null) {
				PRE_UPDATE(pm_il_doc_dflt_charge);
				rowUpdated = pm_il_doc_dflt_charge_delegate
						.updateData(pm_il_doc_dflt_charge);
				System.out.println("ROW UPDATED:::::::" + rowUpdated);
				/*
				 * if(rowUpdated>0) { getWarningMap().put("somekey",
				 * rowUpdated+" record updated.");
				 * getWarningMap().put("current", rowUpdated+" record
				 * updated."); }
				 */
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
			} else {
				PRE_INSERT(pm_il_doc_dflt_charge);
				String code = pm_il_doc_dflt_charge_delegate.getSessionValue()
						.getPM_IL_DOC_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
				String type = pm_il_doc_dflt_charge_delegate.getSessionValue()
						.getPM_IL_DOC_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
				// pm_il_doc_dflt_charge.setDDCHG_SR_NO(1.0);
				pm_il_doc_dflt_charge.setDDCHG_DS_CODE(code);
				pm_il_doc_dflt_charge.setDDCHG_DS_TYPE(type);
				pm_il_doc_dflt_charge.setDDCHG_CR_DT(new java.sql.Date(Calendar
						.getInstance().getTimeInMillis()));
				pm_il_doc_dflt_charge.setDDCHG_CR_UID(new CommonUtils()
						.getControlBean().getM_USER_ID());
				/* PRE-UPDATE calling */

				rowUpdated = pm_il_doc_dflt_charge_delegate
						.updateData(pm_il_doc_dflt_charge);
				/*
				 * if(rowUpdated>0) { getWarningMap().put("somekey",
				 * rowUpdated+" record inserted.");
				 * getWarningMap().put("current", rowUpdated+" record
				 * inserted."); }
				 */
				message = Messages.getString("messageProperties",
						"errorPanel$message$insert");
			}
			if (message != null) {
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
			}
			lastUpdatedRowIndex = currRowIndex;

		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
			getWarningMap().put("update", rowUpdated + " record NOT updated.");
			getWarningMap().put("current", rowUpdated + " record NOT updated.");
		}

		return;

	}

	public ArrayList<SelectItem> getDDCHG_APPLY_PERIOD_ARRAYLIST() {
		return DDCHG_APPLY_PERIOD_ARRAYLIST;
	}

	public void setDDCHG_APPLY_PERIOD_ARRAYLIST(
			ArrayList<SelectItem> ddchg_apply_period_arraylist) {
		DDCHG_APPLY_PERIOD_ARRAYLIST = ddchg_apply_period_arraylist;
	}

	/* Validation */

	public void validateDDCHG_SR_NO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		try {
			PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_SR_NO((Integer) value);
			pm_il_doc_dflt_charge_helper.DDCHG_SR_NO_WHEN_VALIDATE_ITEM(PM_IL_DOC_DFLT_CHARGE_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*Newly added by pidugu raj dt: 24-09-2018 as suggested by sivaraman and vaitheeswaran*/
	public void validateDDCHG_CHARGE_MAX_LMT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		try {
			PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_CHARGE_MAX_LMT((Integer) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*End Newly added by pidugu raj dt: 24-09-2018 as suggested by sivaraman and vaitheeswaran*/
	public void validateDDCHG_CODE(FacesContext fc, UIComponent component,
			Object value) {
		try {
			pm_il_doc_dflt_charge_helper.DDCHG_CODE_WHEN_VALIDATE_ITEM(
					(String) value, this, this.PM_IL_DOC_DFLT_CHARGE_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDDCHG_RATE(FacesContext fc, UIComponent component,
			Object value) {
		try {
			pm_il_doc_dflt_charge_helper.DDCHG_CUST_RATE_WHEN_VALIDATE_ITEM(
					value, this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDDCHG_RATE_PER(FacesContext fc, UIComponent component,
			Object value){
		try {
			UIInput input = (UIInput) component;
			double ratePercentage = Double.parseDouble(input
					.getSubmittedValue().toString());
			if (ratePercentage <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "RATE", ">", "0" }));
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/* COMMENTED BY SARITHA 5.4.20016
	 * 
	 *  
	 *  public void validateDDCHG_APPLIED_ON(FacesContext fc,
			UIComponent component, Object value)throws ValidatorException, Exception {
		
		added by nathiya for disabling tariffcode
		
		try
		{
	this.PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_APPLIED_ON((String) value);
	pm_il_doc_dflt_charge_helper.WHEN_VALIDATE_ITEM_DDCHG_APPLIED_ON(this);
}
catch (Exception e) { 
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
		end
	}*/

	public void validateDDCHG_APPLY_PERIOD(FacesContext fc,
			UIComponent component, Object value){
		this.PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_APPLY_PERIOD((String) value);
	}

	public void validateDDCHG_EFF_FM_DT(FacesContext fc, UIComponent component,
			Object value){
		try {
		Date toDate = this.PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_EFF_TO_DT();
		this.PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_EFF_FM_DT((Date) value);
			pm_il_doc_dflt_charge_helper.DDCHG_EFF_FM_DT_WHEN_VALIDATE_ITEM(
					(Date) value, toDate, this, this.PM_IL_DOC_DFLT_CHARGE_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDDCHG_EFF_TO_DT(FacesContext fc, UIComponent component,
			Object value) {
		try {
		Date fromDate = this.PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_EFF_FM_DT();
			pm_il_doc_dflt_charge_helper.DDCHG_EFF_TO_DT_WHEN_VALIDATE_ITEM(
					fromDate, (Date) value, this, this.PM_IL_DOC_DFLT_CHARGE_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDDCHG_EFF_TO_DT_ACTION(ActionEvent actionEvent) {
		fireFieldValidation(actionEvent);
	}

	public void validateDDCHG_CUST_SHARE_PERC(FacesContext fc,
			UIComponent component, Object value) {
		try {
			if (value != null) {
				pm_il_doc_dflt_charge_helper
						.DDCHG_CUST_SHARE_PERC_WHEN_VALIDATE_ITEM(value
								.toString(), this,
								this.PM_IL_DOC_DFLT_CHARGE_BEAN);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	//ADDED BY SARITHA
	// This is the default listener which internally fires the validation.
	public void fireFieldValidation(ActionEvent actionEvent) {
		System.out.println("sari");
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	//end

	/* LOV Actions */
	public List suggestionActionCatgCode(Object event) {
		String catgCode = (String) event;
		try {
			catgCodeList = pm_il_doc_dflt_charge_delegate.prepareCatgCodeList(
					catgCode, catgCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return catgCodeList;
	}

	public String getCatgDescforCode(String catgCode, List catgCodeList) {
		Iterator iterator = catgCodeList.iterator();
		String catgDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_DFLT_CHARGE pm_il_contractor = (PM_IL_DOC_DFLT_CHARGE) iterator
					.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
			if (catgCode.equalsIgnoreCase(pm_il_contractor.getDDCHG_CODE())) {
				catgDesc = pm_il_contractor.getUI_M_DDCHG_CODE_DESC();
			}
		}
		return catgDesc;
	}

	public void getCatgCodeDesc(ActionEvent event) {
		if (COMP_DDCHG_CODE.getSubmittedValue() != null) {
			String catgCode = (String) COMP_DDCHG_CODE.getSubmittedValue();
			String catgCodeDesc = getCatgDescforCode(catgCode, catgCodeList);
			// COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(catgCodeDesc);
			PM_IL_DOC_DFLT_CHARGE_BEAN.setUI_M_DDCHG_CODE_DESC(catgCodeDesc);
			COMP_UI_M_DDCHG_CODE_DESC.setSubmittedValue(catgCodeDesc);
		}
	}

	/* PRE_BLOCK */

	public void PRE_BLOCK() {
		new CommonUtils().getControlBean().setM_DELETE_MSG_FLAG("N");
	}

	/* WHEN CREATE RECORD */
	public void WHEN_CREATE_RECORD() {
		int rowIndex = dataTable.getRowCount();
		PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge = (PM_IL_DOC_DFLT_CHARGE) dataTableList
				.get(rowIndex - 1);
		// pm_il_doc_dflt_charge.setDDCHG_RATE_PER(1.0);
		pm_il_doc_dflt_charge.setDDCHG_APPLIED_ON("1");
		pm_il_doc_dflt_charge.setDDCHG_APPLY_PERIOD("S");

	}

	/* WHEN NEW BLOCK INSTANCE */
	public void WHEN_NEW_BLOCK_INSTANCE() {
		new CommonUtils().getControlBean().setM_COMM_DEL("P");
	}

	/* PRE_INSERT */
	public void PRE_INSERT(PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge) {
		pm_il_doc_dflt_charge.setDDCHG_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		pm_il_doc_dflt_charge.setDDCHG_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		// pm_il_doc_dflt_charge_delegate.L_DUP_CHARGE(pm_il_doc_dflt_charge);

		// pm_il_doc_dflt_charge_delegate.L_DUP_SRLNO("PM_IL_DOC_DFLT_CHARGE",rowIndex);
	}

	/* PRE_UPDATE */
	public void PRE_UPDATE(PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge) {

		pm_il_doc_dflt_charge.setDDCHG_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		pm_il_doc_dflt_charge.setDDCHG_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		// pm_il_doc_dflt_charge_delegate.L_DUP_CHARGE(pm_il_doc_dflt_charge);

		// pm_il_doc_dflt_charge_delegate.L_DUP_SRLNO("PM_IL_DOC_DFLT_CHARGE",rowIndex);
	}

	/* PRE DELETE */
	public void PRE_DELETE(PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge) {
		pm_il_doc_dflt_charge.setUI_M_SR_NO(pm_il_doc_dflt_charge
				.getDDCHG_SR_NO());
	}

	public List getCatgCodeList() {
		return catgCodeList;
	}

	public void setCatgCodeList(List catgCodeList) {
		this.catgCodeList = catgCodeList;
	}

	public PM_IL_DOC_DFLT_CHARGE_HELPER getPm_il_doc_dflt_charge_helper() {
		return pm_il_doc_dflt_charge_helper;
	}

	public void setPm_il_doc_dflt_charge_helper(
			PM_IL_DOC_DFLT_CHARGE_HELPER pm_il_doc_dflt_charge_helper) {
		this.pm_il_doc_dflt_charge_helper = pm_il_doc_dflt_charge_helper;
	}

	public PM_IL_DOC_DFLT_CHARGE_DELEGATE getPm_il_doc_dflt_charge_delegate() {
		return pm_il_doc_dflt_charge_delegate;
	}

	public void setPm_il_doc_dflt_charge_delegate(
			PM_IL_DOC_DFLT_CHARGE_DELEGATE pm_il_doc_dflt_charge_delegate) {
		this.pm_il_doc_dflt_charge_delegate = pm_il_doc_dflt_charge_delegate;
	}

	public ControlBean getControlBean() {
		return controlBean;
	}

	public void setControlBean(ControlBean controlBean) {
		this.controlBean = controlBean;
	}

	public String combinedSave() {
		pm_il_doc_dflt_charge_delegate.saveData(this);
		getWarningMap().put(
				"current",
				Messages.getString(PELConstants.pelErrorMessagePath,
						"SAVE_UPDATE_MESSAGE"));
		getWarningMap().put(
				"somekey",
				Messages.getString(PELConstants.pelErrorMessagePath,
						"SAVE_UPDATE_MESSAGE"));
		return null;
	}

	/**
	 * Implementation of Tool Bar Functionalities.
	 */
	/*
	 * public String saveNextAction() { combinedSave();
	 * PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action =
	 * (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value = pm_il_doc_setup_composite_action.callDocumentTodoList();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoNextTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(5); return
	 * value; }
	 * 
	 * 
	 * public String nextIconAction() { PM_IL_DOC_SETUP_COMPOSITE_ACTION
	 * pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value = pm_il_doc_setup_composite_action.callDocumentTodoList();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoNextTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(5); return
	 * value; }
	 * 
	 * public String lastIconAction() { PM_IL_DOC_SETUP_COMPOSITE_ACTION
	 * pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value = pm_il_doc_setup_composite_action.callDocumentReminder();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoLastTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(7); return
	 * value; }
	 * 
	 * public String firstIconAction() { PM_IL_DOC_SETUP_COMPOSITE_ACTION
	 * pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value = pm_il_doc_setup_composite_action.callDocumentSetup();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoFirstTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(1); return
	 * value; }
	 * 
	 * public String previousIconAction() { PM_IL_DOC_SETUP_COMPOSITE_ACTION
	 * pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value =
	 * pm_il_doc_setup_composite_action.callDocumentNumberRange();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoPrevTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(3); return
	 * value; }
	 */

	// [ Added for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 13-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

		try {
			if (rowIndex > -1) {
				// Calling last Column listener
				lastColumnListener();
			} else {
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}

		return outcome;
	}

	// Added for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 13-Feb-2009 ]

	public void post(ActionEvent ae) {
		try {
			if (PM_IL_DOC_DFLT_CHARGE_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					PRE_UPDATE(this.PM_IL_DOC_DFLT_CHARGE_BEAN);
					new CRUDHandler().executeInsert(PM_IL_DOC_DFLT_CHARGE_BEAN,
							commonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {

				if (isINSERT_ALLOWED()) {
					setCodeType();
					PRE_INSERT(this.PM_IL_DOC_DFLT_CHARGE_BEAN);
					new CRUDHandler().executeInsert(PM_IL_DOC_DFLT_CHARGE_BEAN,
							commonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					dataTableList.add(PM_IL_DOC_DFLT_CHARGE_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_DOC_DFLT_CHARGE_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	private void setCodeType() {
		String code = pm_il_doc_dflt_charge_delegate.getSessionValue()
				.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN()
				.getDS_CODE();
		String type = pm_il_doc_dflt_charge_delegate.getSessionValue()
				.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN()
				.getDS_TYPE();
		// pm_il_doc_dflt_charge.setDDCHG_SR_NO(1.0);
		this.PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_DS_CODE(code);
		this.PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_DS_TYPE(type);
	}

	public void getDetails() {
		try {
			if (dataTableList.size() != 0) {
				PM_IL_DOC_DFLT_CHARGE_BEAN = (PM_IL_DOC_DFLT_CHARGE) dataTable
						.getRowData();
				
				
				//saritha

				
				int val=Integer.parseInt(PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_APPLIED_ON());
			    if(val==5){
					System.out.println("inside val ==5 traffic");
					/*getCOMP_TARIFF_CODE().setDisabled(false);
				    getCOMP_TARIFF_CODE().setRendered(true);*/

					COMP_TARIFF_CODE.setDisabled(false);
					COMP_TARIFF_CODE.resetValue();
				}
				
				else{
					
					COMP_TARIFF_CODE.resetValue();
					COMP_TARIFF_CODE.setDisabled(true);
				
					
					
				}
				
			}
			//added by saranya for product from and to description on 11-05-2016
			compositeAction.getData();
			
			resetAllComponent();
			resetSelectedRow();
			PM_IL_DOC_DFLT_CHARGE_BEAN.setRowSelected(true);
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_DDCHG_SR_NO.resetValue();
		COMP_DDCHG_CODE.resetValue();
		COMP_UI_M_DDCHG_CODE_DESC.resetValue();
		COMP_DDCHG_RATE.resetValue();
		COMP_DDCHG_RATE_PER.resetValue();
		COMP_DDCHG_APPLIED_ON.resetValue();
		COMP_DDCHG_CUST_SHARE_PERC.resetValue();
		COMP_DDCHG_APPLY_PERIOD.resetValue();
		COMP_DDCHG_EFF_FM_DT.resetValue();
		COMP_DDCHG_EFF_TO_DT.resetValue();
		
		/*Added by Raja on 18-3-2016 for Product Code From and To field addtion*/
		COMP_DDCHG_PROD_CODE_FM.resetValue();
		COMP_DDCHG_PROD_CODE_FM_DESC.resetValue();
		COMP_DDCHG_PROD_CODE_TO.resetValue();
		COMP_DDCHG_PROD_CODE_TO_DESC.resetValue();
		/*End*/
		
		/*Added  by Ameen on 19-02-2018 as per siva sugg.*/
		COMP_TARIFF_CODE.resetValue();
		/*End*/
		/*Newly added by pidugu raj dt: 24-09-2018 as suggested by sivaraman and vaitheeswaran*/
		COMP_DDCHG_CHARGE_MAX_LMT.resetValue();
		/*End Newly added by pidugu raj dt: 24-09-2018 as suggested by sivaraman and vaitheeswaran*/
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_DOC_DFLT_CHARGE> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public String getFilterByDDCHG_CODE() {
		return filterByDDCHG_CODE;
	}

	public void setFilterByDDCHG_CODE(String filterByDDCHG_CODE) {
		this.filterByDDCHG_CODE = filterByDDCHG_CODE;
	}

	public String getFilterByDDCHG_RATE() {
		return filterByDDCHG_RATE;
	}

	public void setFilterByDDCHG_RATE(String filterByDDCHG_RATE) {
		this.filterByDDCHG_RATE = filterByDDCHG_RATE;
	}

	public String getFilterByDDCHG_CUST_SHARE_PERC() {
		return filterByDDCHG_CUST_SHARE_PERC;
	}

	public void setFilterByDDCHG_CUST_SHARE_PERC(
			String filterByDDCHG_CUST_SHARE_PERC) {
		this.filterByDDCHG_CUST_SHARE_PERC = filterByDDCHG_CUST_SHARE_PERC;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public HtmlInputText getCOMP_DDCHG_DS_CHG_TAR_CODE() {
		return COMP_DDCHG_DS_CHG_TAR_CODE;
	}

	public void setCOMP_DDCHG_DS_CHG_TAR_CODE(
			HtmlInputText comp_ddchg_ds_chg_tar_code) {
		COMP_DDCHG_DS_CHG_TAR_CODE = comp_ddchg_ds_chg_tar_code;
	}

	/*added by nathiya for disabling tariffcode*/
	
	public void whenListChangedMTHD(ActionEvent event){
		getErrorMap().clear();
		getWarningMap().clear();
		
		String value=(String)COMP_DDCHG_APPLIED_ON.getSubmittedValue();
		
		System.out.println("APPLIED ********** value :"+value);
		
		
		try {
			pm_il_doc_dflt_charge_helper.WHEN_VALIDATE_ITEM_DDCHG_APPLIED_ON(this);
			PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_APPLIED_ON(value);
			if(value.equals("5")){
				
				
			System.out.println("inside if method");
				COMP_DDCHG_DS_CHG_TAR_CODE.setDisabled(true);
				
			COMP_DDCHG_DS_CHG_TAR_CODE.resetValue();
			
			}
			else
			{
				COMP_DDCHG_DS_CHG_TAR_CODE.setDisabled(false);	
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
	}
	
		
	/*end*/
	
	
	public void validateDPROD_CODE(FacesContext fc,
			UIComponent component, Object value){
		this.PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_APPLY_PERIOD((String) value);
	}
	
	/*Added by Raja on 18-3-2016 for Product Code From and To field addtion*/
	
	private HtmlInputText COMP_DDCHG_PROD_CODE_FM;
	private HtmlInputText COMP_DDCHG_PROD_CODE_FM_DESC;
	private HtmlInputText COMP_DDCHG_PROD_CODE_TO;
	private HtmlInputText COMP_DDCHG_PROD_CODE_TO_DESC;
	
	public HtmlInputText getCOMP_DDCHG_PROD_CODE_FM_DESC() {
		return COMP_DDCHG_PROD_CODE_FM_DESC;
	}

	public void setCOMP_DDCHG_PROD_CODE_FM_DESC(
			HtmlInputText cOMP_DDCHG_PROD_CODE_FM_DESC) {
		COMP_DDCHG_PROD_CODE_FM_DESC = cOMP_DDCHG_PROD_CODE_FM_DESC;
	}

	public HtmlInputText getCOMP_DDCHG_PROD_CODE_FM() {
		return COMP_DDCHG_PROD_CODE_FM;
	}

	public void setCOMP_DDCHG_PROD_CODE_FM(HtmlInputText cOMP_DDCHG_PROD_CODE_FM) {
		COMP_DDCHG_PROD_CODE_FM = cOMP_DDCHG_PROD_CODE_FM;
	}
	
	
	public HtmlInputText getCOMP_DDCHG_PROD_CODE_TO() {
		return COMP_DDCHG_PROD_CODE_TO;
	}

	public void setCOMP_DDCHG_PROD_CODE_TO(HtmlInputText cOMP_DDCHG_PROD_CODE_TO) {
		COMP_DDCHG_PROD_CODE_TO = cOMP_DDCHG_PROD_CODE_TO;
	}

	public HtmlInputText getCOMP_DDCHG_PROD_CODE_TO_DESC() {
		return COMP_DDCHG_PROD_CODE_TO_DESC;
	}

	public void setCOMP_DDCHG_PROD_CODE_TO_DESC(
			HtmlInputText cOMP_DDCHG_PROD_CODE_TO_DESC) {
		COMP_DDCHG_PROD_CODE_TO_DESC = cOMP_DDCHG_PROD_CODE_TO_DESC;
	}




	
	public void validateDDCHG_PROD_CODE_FM(FacesContext context,
			UIComponent component, Object value){

		try {
			PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_PROD_CODE_FM((String) value);
			

pm_il_doc_dflt_charge_helper.DDCHG_PROD_CODE_FM_WHEN_VALIDATE_ITEM(PM_IL_DOC_DFLT_CHARGE_BEAN);
					
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public ArrayList<LovBean> prepareSuggestionList_DDCHG_PROD_CODE_FM(Object object){
		System.out.println("i         am            suggestion         box");
		
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILM013_APAC";
		String blockName = "PM_IL_DOC_DFLT_CHARGE";
		String fieldName = "DDCHG_PROD_CODE_FM";
		

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, 

null, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	
	


		//sankar
		public void validateDDCHG_PROD_CODE_TO(FacesContext context,
				UIComponent component, Object value){
			System.out.println("sankar validateDDCHG_PROD_CODE_TO ");
			try {
				PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_PROD_CODE_TO((String) 

value);
				

pm_il_doc_dflt_charge_helper.DDCHG_PROD_CODE_TO_WHEN_VALIDATE_ITEM(PM_IL_DOC_DFLT_CHARGE_BEAN);
						
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		
		
		
		/* LOV Actions */
		public ArrayList<LovBean> prepareSuggestionList_DDCHG_PROD_CODE_TO(Object 

object){
			System.out.println("i         am            suggestion         box");
			
			ArrayList<LovBean> lovList = new ArrayList<LovBean>();
			ListItemUtil itemUtil = new ListItemUtil();
			String currentValue = (String) object;
			String moduleName = "PILM013_APAC";
			String blockName = "PM_IL_DOC_DFLT_CHARGE";
			String fieldName = "DDCHG_PROD_CODE_TO";
			

			try {
				currentValue = "*".equals(currentValue) ? "%" : currentValue + 

"%";
				lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, 

	null, null,
						null, null, null, currentValue);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return lovList;
		}
	
		/*End*/
		
		

/*public void validateDDCHG_APPLIED_ON(FacesContext fc,
		UIComponent component, Object value)throws ValidatorException, Exception {
	
	try
	{
		PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_APPLIED_ON((String) value);
		
		int val=Integer.parseInt(PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_APPLIED_ON());
		
		System.out.println("applied on "+PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_APPLIED_ON()+ ","+val);
		
		if(val==5){
			COMP_TARIFF_CODE.setDisabled(false);
			
		}
		
		else{
			
			COMP_TARIFF_CODE.setDisabled(true);
		}

		}

catch (Exception e) { 
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
	
	
}*/
		
//ADDED BY SARITHA

        public void validateDDCHG_APPLIED_ON(FacesContext fc,
		UIComponent component, Object value)throws ValidatorException, Exception {
	try
	{
            PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_APPLIED_ON((String) value);
             }
             catch (Exception e) { 
     throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
	
	
}

//END	
		
		
//ADDED BY SARITHA

	public void chargeValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();		
		ErrorHelpUtil.validate(input, getErrorMap());
		System.out.println("saritha ");
		int val=Integer.parseInt(PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_APPLIED_ON());
		System.out.println("applied on "+PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_APPLIED_ON()+ ","+val);
		System.out.println("*****************inside chargeValidation******************");		
	    if(val==5){
			System.out.println("inside val ==5 traffic");
			/*getCOMP_TARIFF_CODE().setDisabled(false);
		    getCOMP_TARIFF_CODE().setRendered(true);*/

			COMP_TARIFF_CODE.setDisabled(false);
			//COMP_TARIFF_CODE.resetValue();
		}
		
		else{
			
			PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_DS_CHG_TAR_CODE("");
			COMP_TARIFF_CODE.setDisabled(true);
			
		}
		
	}
	
	/*end*/

/*Added by saritha */

public void validatePOL_TARIFF_REF_ID1(FacesContext facesContext,
		UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	
	PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_DS_CHG_TAR_CODE((String) value);
	COMP_TARIFF_CODE.resetValue();
	System.out.println("validatePOL_TARIFF_REF_ID1 bean " +PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_DS_CHG_TAR_CODE());

	//	PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1((String) value);
	}

public ArrayList<LovBean>lovPOL_TARIFF_REF_ID1(Object currValue) {
	
	System.out.println("****************  Enter the lovPOL_TARIFF_REF_ID1 ********************************");
	String code = (String) currValue;
	
	System.out.println("Before  code value  : "+code);
	if(code.equals(null))
	{
		
		code="*";
	}
	
	System.out.println("After code  Value   : "+code);
	ArrayList<LovBean> suggestionList = null;
	Object[] object = {};
	String query = null;
	try {
		if ("*".equals(code)) {
			object = new Object[] { PELConstants.suggetionRecordSize };
			query = "SELECT TH_CODE,TH_DESC FROM pm_il_tar_hdr WHERE TH_PARAM_TYPE  ='V' and TH_CODE IS NOT NULL AND ROWNUM <= ? ORDER BY 1";
			System.out.println("Before execute query");
		} else {
			object = new Object[] { code + "%", code + "%",
			PELConstants.suggetionRecordSize };
			query ="SELECT TH_CODE,TH_DESC FROM pm_il_tar_hdr WHERE (TH_CODE LIKE '%?%' OR TH_DESC LIKE '%?%') AND TH_CODE IS NOT NULL AND ROWNUM <= ? ORDER BY 1";
			System.out.println("After execute query");
		}
		suggestionList = ListItemUtil.prepareSuggestionList(query, object);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return suggestionList;
}

/*Newly added by pidugu raj dt: 24-09-2018 as suggested by sivaraman and vaitheeswaran*/
public HtmlInputText getCOMP_DDCHG_CHARGE_MAX_LMT() {
	return COMP_DDCHG_CHARGE_MAX_LMT;
}

public void setCOMP_DDCHG_CHARGE_MAX_LMT(HtmlInputText cOMP_DDCHG_CHARGE_MAX_LMT) {
	COMP_DDCHG_CHARGE_MAX_LMT = cOMP_DDCHG_CHARGE_MAX_LMT;
}

public HtmlOutputLabel getCOMP_DDCHG_CHARGE_MAX() {
	return COMP_DDCHG_CHARGE_MAX;
}

public void setCOMP_DDCHG_CHARGE_MAX(HtmlOutputLabel cOMP_DDCHG_CHARGE_MAX) {
	COMP_DDCHG_CHARGE_MAX = cOMP_DDCHG_CHARGE_MAX;
}

/*End Newly added by pidugu raj dt: 24-09-2018 as suggested by sivaraman and vaitheeswaran*/

}      

/*End*/


