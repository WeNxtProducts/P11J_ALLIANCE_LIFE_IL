package com.iii.pel.forms.PILT032_APAC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_RECEIPT_TRANS_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_RTD_TXN_CODE_LABEL;

	private HtmlInputText COMP_UI_M_RTD_TXN_CODE;

	private HtmlOutputLabel COMP_UI_M_DOC_NO_LABEL;

	private HtmlInputText COMP_UI_M_DOC_NO;

	private HtmlOutputLabel COMP_UI_M_DOC_DT_LABEL;

	private HtmlCalendar COMP_UI_M_DOC_DT;

	private HtmlOutputLabel COMP_UI_M_ACC_YEAR_LABEL;

	private HtmlInputText COMP_UI_M_ACC_YEAR;

	private HtmlOutputLabel COMP_UI_M_DEP_LC_DEP_AMT_LABEL;

	private HtmlInputText COMP_UI_M_DEP_LC_DEP_AMT;

	private HtmlOutputLabel COMP_RTD_DEP_LC_AMT_LABEL;

	private HtmlInputText COMP_RTD_DEP_LC_AMT;

	private HtmlOutputLabel COMP_RTD_DES_POL_NO_LABEL;

	private HtmlInputText COMP_RTD_DES_POL_NO;

	private HtmlOutputLabel COMP_RTD_TRNS_YN_LABEL;

	private HtmlSelectOneMenu COMP_RTD_TRNS_YN;

	private HtmlOutputLabel COMP_RTD_REASON_CODE_LABEL;

	private HtmlInputText COMP_RTD_REASON_CODE;

	private HtmlOutputLabel COMP_RTD_REV_REMARKS_LABEL;

	private HtmlInputText COMP_RTD_REV_REMARKS;

	private HtmlOutputLabel COMP_RTD_TXN_CODE_LABEL;

	private HtmlInputText COMP_RTD_TXN_CODE;

	private HtmlOutputLabel COMP_RTD_DOC_NO_LABEL;

	private HtmlInputText COMP_RTD_DOC_NO;

	private HtmlOutputLabel COMP_RTD_DOC_DT_LABEL;

	private HtmlCalendar COMP_RTD_DOC_DT;

	private HtmlOutputLabel COMP_RTD_ACNT_YR_LABEL;

	private HtmlInputText COMP_RTD_ACNT_YR;

	private HtmlOutputLabel COMP_UI_M_REASON_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_REASON_CODE_DESC;
	
	private HtmlInputText COMP_UI_M_RTD_DES_POL_NO;

	private PT_IL_RECEIPT_TRANS_DTL PT_IL_RECEIPT_TRANS_DTL_BEAN;

	public PILT032_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_RECEIPT_TRANS_DTL_HELPER helper;

	private List<PT_IL_RECEIPT_TRANS_DTL> dataList_PT_IL_RECEIPT_TRANS_DTL = new ArrayList<PT_IL_RECEIPT_TRANS_DTL>();

	private UIData dataTable;

	private List<SelectItem> listRTD_TRNS_YN = new ArrayList<SelectItem>();

	public PT_IL_RECEIPT_TRANS_DTL_ACTION() {

		PT_IL_RECEIPT_TRANS_DTL_BEAN = new PT_IL_RECEIPT_TRANS_DTL();
		helper = new PT_IL_RECEIPT_TRANS_DTL_HELPER();
		prepareListItemValues();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_UI_M_RTD_TXN_CODE_LABEL() {
		return COMP_UI_M_RTD_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_RTD_TXN_CODE() {
		return COMP_UI_M_RTD_TXN_CODE;
	}

	public void setCOMP_UI_M_RTD_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_RTD_TXN_CODE_LABEL) {
		this.COMP_UI_M_RTD_TXN_CODE_LABEL = COMP_UI_M_RTD_TXN_CODE_LABEL;
	}

	public void setCOMP_UI_M_RTD_TXN_CODE(HtmlInputText COMP_UI_M_RTD_TXN_CODE) {
		this.COMP_UI_M_RTD_TXN_CODE = COMP_UI_M_RTD_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DOC_NO_LABEL() {
		return COMP_UI_M_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DOC_NO() {
		return COMP_UI_M_DOC_NO;
	}

	public void setCOMP_UI_M_DOC_NO_LABEL(HtmlOutputLabel COMP_UI_M_DOC_NO_LABEL) {
		this.COMP_UI_M_DOC_NO_LABEL = COMP_UI_M_DOC_NO_LABEL;
	}

	public void setCOMP_UI_M_DOC_NO(HtmlInputText COMP_UI_M_DOC_NO) {
		this.COMP_UI_M_DOC_NO = COMP_UI_M_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_DOC_DT_LABEL() {
		return COMP_UI_M_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_DOC_DT() {
		return COMP_UI_M_DOC_DT;
	}

	public void setCOMP_UI_M_DOC_DT_LABEL(HtmlOutputLabel COMP_UI_M_DOC_DT_LABEL) {
		this.COMP_UI_M_DOC_DT_LABEL = COMP_UI_M_DOC_DT_LABEL;
	}

	public void setCOMP_UI_M_DOC_DT(HtmlCalendar COMP_UI_M_DOC_DT) {
		this.COMP_UI_M_DOC_DT = COMP_UI_M_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACC_YEAR_LABEL() {
		return COMP_UI_M_ACC_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACC_YEAR() {
		return COMP_UI_M_ACC_YEAR;
	}

	public void setCOMP_UI_M_ACC_YEAR_LABEL(
			HtmlOutputLabel COMP_UI_M_ACC_YEAR_LABEL) {
		this.COMP_UI_M_ACC_YEAR_LABEL = COMP_UI_M_ACC_YEAR_LABEL;
	}

	public void setCOMP_UI_M_ACC_YEAR(HtmlInputText COMP_UI_M_ACC_YEAR) {
		this.COMP_UI_M_ACC_YEAR = COMP_UI_M_ACC_YEAR;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_LC_DEP_AMT_LABEL() {
		return COMP_UI_M_DEP_LC_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_LC_DEP_AMT() {
		return COMP_UI_M_DEP_LC_DEP_AMT;
	}

	public void setCOMP_UI_M_DEP_LC_DEP_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_DEP_LC_DEP_AMT_LABEL) {
		this.COMP_UI_M_DEP_LC_DEP_AMT_LABEL = COMP_UI_M_DEP_LC_DEP_AMT_LABEL;
	}

	public void setCOMP_UI_M_DEP_LC_DEP_AMT(
			HtmlInputText COMP_UI_M_DEP_LC_DEP_AMT) {
		this.COMP_UI_M_DEP_LC_DEP_AMT = COMP_UI_M_DEP_LC_DEP_AMT;
	}

	public HtmlOutputLabel getCOMP_RTD_DEP_LC_AMT_LABEL() {
		return COMP_RTD_DEP_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_RTD_DEP_LC_AMT() {
		return COMP_RTD_DEP_LC_AMT;
	}

	public void setCOMP_RTD_DEP_LC_AMT_LABEL(
			HtmlOutputLabel COMP_RTD_DEP_LC_AMT_LABEL) {
		this.COMP_RTD_DEP_LC_AMT_LABEL = COMP_RTD_DEP_LC_AMT_LABEL;
	}

	public void setCOMP_RTD_DEP_LC_AMT(HtmlInputText COMP_RTD_DEP_LC_AMT) {
		this.COMP_RTD_DEP_LC_AMT = COMP_RTD_DEP_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_RTD_DES_POL_NO_LABEL() {
		return COMP_RTD_DES_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_RTD_DES_POL_NO() {
		return COMP_RTD_DES_POL_NO;
	}

	public void setCOMP_RTD_DES_POL_NO_LABEL(
			HtmlOutputLabel COMP_RTD_DES_POL_NO_LABEL) {
		this.COMP_RTD_DES_POL_NO_LABEL = COMP_RTD_DES_POL_NO_LABEL;
	}

	public void setCOMP_RTD_DES_POL_NO(HtmlInputText COMP_RTD_DES_POL_NO) {
		this.COMP_RTD_DES_POL_NO = COMP_RTD_DES_POL_NO;
	}

	public HtmlOutputLabel getCOMP_RTD_TRNS_YN_LABEL() {
		return COMP_RTD_TRNS_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_RTD_TRNS_YN() {
		return COMP_RTD_TRNS_YN;
	}

	public void setCOMP_RTD_TRNS_YN_LABEL(HtmlOutputLabel COMP_RTD_TRNS_YN_LABEL) {
		this.COMP_RTD_TRNS_YN_LABEL = COMP_RTD_TRNS_YN_LABEL;
	}

	public void setCOMP_RTD_TRNS_YN(HtmlSelectOneMenu COMP_RTD_TRNS_YN) {
		this.COMP_RTD_TRNS_YN = COMP_RTD_TRNS_YN;
	}

	public HtmlOutputLabel getCOMP_RTD_REASON_CODE_LABEL() {
		return COMP_RTD_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RTD_REASON_CODE() {
		return COMP_RTD_REASON_CODE;
	}

	public void setCOMP_RTD_REASON_CODE_LABEL(
			HtmlOutputLabel COMP_RTD_REASON_CODE_LABEL) {
		this.COMP_RTD_REASON_CODE_LABEL = COMP_RTD_REASON_CODE_LABEL;
	}

	public void setCOMP_RTD_REASON_CODE(HtmlInputText COMP_RTD_REASON_CODE) {
		this.COMP_RTD_REASON_CODE = COMP_RTD_REASON_CODE;
	}

	public HtmlOutputLabel getCOMP_RTD_REV_REMARKS_LABEL() {
		return COMP_RTD_REV_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_RTD_REV_REMARKS() {
		return COMP_RTD_REV_REMARKS;
	}

	public void setCOMP_RTD_REV_REMARKS_LABEL(
			HtmlOutputLabel COMP_RTD_REV_REMARKS_LABEL) {
		this.COMP_RTD_REV_REMARKS_LABEL = COMP_RTD_REV_REMARKS_LABEL;
	}

	public void setCOMP_RTD_REV_REMARKS(HtmlInputText COMP_RTD_REV_REMARKS) {
		this.COMP_RTD_REV_REMARKS = COMP_RTD_REV_REMARKS;
	}

	public HtmlOutputLabel getCOMP_RTD_TXN_CODE_LABEL() {
		return COMP_RTD_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RTD_TXN_CODE() {
		return COMP_RTD_TXN_CODE;
	}

	public void setCOMP_RTD_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_RTD_TXN_CODE_LABEL) {
		this.COMP_RTD_TXN_CODE_LABEL = COMP_RTD_TXN_CODE_LABEL;
	}

	public void setCOMP_RTD_TXN_CODE(HtmlInputText COMP_RTD_TXN_CODE) {
		this.COMP_RTD_TXN_CODE = COMP_RTD_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_RTD_DOC_NO_LABEL() {
		return COMP_RTD_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_RTD_DOC_NO() {
		return COMP_RTD_DOC_NO;
	}

	public void setCOMP_RTD_DOC_NO_LABEL(HtmlOutputLabel COMP_RTD_DOC_NO_LABEL) {
		this.COMP_RTD_DOC_NO_LABEL = COMP_RTD_DOC_NO_LABEL;
	}

	public void setCOMP_RTD_DOC_NO(HtmlInputText COMP_RTD_DOC_NO) {
		this.COMP_RTD_DOC_NO = COMP_RTD_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_RTD_DOC_DT_LABEL() {
		return COMP_RTD_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_RTD_DOC_DT() {
		return COMP_RTD_DOC_DT;
	}

	public void setCOMP_RTD_DOC_DT_LABEL(HtmlOutputLabel COMP_RTD_DOC_DT_LABEL) {
		this.COMP_RTD_DOC_DT_LABEL = COMP_RTD_DOC_DT_LABEL;
	}

	public void setCOMP_RTD_DOC_DT(HtmlCalendar COMP_RTD_DOC_DT) {
		this.COMP_RTD_DOC_DT = COMP_RTD_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_RTD_ACNT_YR_LABEL() {
		return COMP_RTD_ACNT_YR_LABEL;
	}

	public HtmlInputText getCOMP_RTD_ACNT_YR() {
		return COMP_RTD_ACNT_YR;
	}

	public void setCOMP_RTD_ACNT_YR_LABEL(HtmlOutputLabel COMP_RTD_ACNT_YR_LABEL) {
		this.COMP_RTD_ACNT_YR_LABEL = COMP_RTD_ACNT_YR_LABEL;
	}

	public void setCOMP_RTD_ACNT_YR(HtmlInputText COMP_RTD_ACNT_YR) {
		this.COMP_RTD_ACNT_YR = COMP_RTD_ACNT_YR;
	}

	public HtmlOutputLabel getCOMP_UI_M_REASON_CODE_DESC_LABEL() {
		return COMP_UI_M_REASON_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_REASON_CODE_DESC() {
		return COMP_UI_M_REASON_CODE_DESC;
	}

	public void setCOMP_UI_M_REASON_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_REASON_CODE_DESC_LABEL) {
		this.COMP_UI_M_REASON_CODE_DESC_LABEL = COMP_UI_M_REASON_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_REASON_CODE_DESC(
			HtmlInputText COMP_UI_M_REASON_CODE_DESC) {
		this.COMP_UI_M_REASON_CODE_DESC = COMP_UI_M_REASON_CODE_DESC;
	}

	public PT_IL_RECEIPT_TRANS_DTL getPT_IL_RECEIPT_TRANS_DTL_BEAN() {
		return PT_IL_RECEIPT_TRANS_DTL_BEAN;
	}

	public void setPT_IL_RECEIPT_TRANS_DTL_BEAN(
			PT_IL_RECEIPT_TRANS_DTL PT_IL_RECEIPT_TRANS_DTL_BEAN) {
		this.PT_IL_RECEIPT_TRANS_DTL_BEAN = PT_IL_RECEIPT_TRANS_DTL_BEAN;
	}

	public List<PT_IL_RECEIPT_TRANS_DTL> getDataList_PT_IL_RECEIPT_TRANS_DTL() {
		return dataList_PT_IL_RECEIPT_TRANS_DTL;
	}

	public void setDataListPT_IL_RECEIPT_TRANS_DTL(
			List<PT_IL_RECEIPT_TRANS_DTL> dataList_PT_IL_RECEIPT_TRANS_DTL) {
		this.dataList_PT_IL_RECEIPT_TRANS_DTL = dataList_PT_IL_RECEIPT_TRANS_DTL;
	}
	
	public void prepareListItemValues(){
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			setListRTD_TRNS_YN(ListItemUtil.getDropDownListValue(
					connection, "PILT032_APAC", "PT_IL_RECEIPT_TRANS_DTL",
					"PT_IL_RECEIPT_TRANS_DTL.RTD_TRNS_YN", "YESNO"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_RECEIPT_TRANS_DTL_BEAN = new PT_IL_RECEIPT_TRANS_DTL();
				resetAllComponent();
				resetSelectedRow();
			} else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PT_IL_RECEIPT_TRANS_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PT_IL_RECEIPT_TRANS_DTL
						.remove(PT_IL_RECEIPT_TRANS_DTL_BEAN);
				if (dataList_PT_IL_RECEIPT_TRANS_DTL.size() > 0) {

					PT_IL_RECEIPT_TRANS_DTL_BEAN = dataList_PT_IL_RECEIPT_TRANS_DTL
							.get(0);
				} else if (dataList_PT_IL_RECEIPT_TRANS_DTL.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	/*Modified by Janani on 11.07.2017 for ZBILQC-1719675*/
	
	/*public void postRecord(ActionEvent event) {
		try {
			if (PT_IL_RECEIPT_TRANS_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PT_IL_RECEIPT_TRANS_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataList_PT_IL_RECEIPT_TRANS_DTL
						.add(PT_IL_RECEIPT_TRANS_DTL_BEAN);
			} else if (PT_IL_RECEIPT_TRANS_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				helper.PRE_UPDATE(PT_IL_RECEIPT_TRANS_DTL_BEAN);

				new CRUDHandler().executeUpdate(PT_IL_RECEIPT_TRANS_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}

			PT_IL_RECEIPT_TRANS_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}*/
	
	public String postRecord()
	
	{
		try {
			
			/*Added by ganesh on 13-06-2018, validation suggested by Girish*/ 
			System.out.println("["+PT_IL_RECEIPT_TRANS_DTL_BEAN.getRTD_DES_POL_NO()+"]--["+PT_IL_RECEIPT_TRANS_DTL_BEAN.getRTD_TRNS_YN()+"]");
			if(PT_IL_RECEIPT_TRANS_DTL_BEAN.getRTD_DES_POL_NO()!=null && !"".equalsIgnoreCase(PT_IL_RECEIPT_TRANS_DTL_BEAN.getRTD_DES_POL_NO().trim())){
				if("N".equalsIgnoreCase(PT_IL_RECEIPT_TRANS_DTL_BEAN.getRTD_TRNS_YN())){
					throw new Exception("Please select Transfer Y/N");
				}
				
			}else{
				if("Y".equalsIgnoreCase(PT_IL_RECEIPT_TRANS_DTL_BEAN.getRTD_TRNS_YN())){
					throw new Exception("Please provide Target Policy Number");
				}
			}
			/*end*/
			
			if (PT_IL_RECEIPT_TRANS_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PT_IL_RECEIPT_TRANS_DTL_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataList_PT_IL_RECEIPT_TRANS_DTL
						.add(PT_IL_RECEIPT_TRANS_DTL_BEAN);
			} else if (PT_IL_RECEIPT_TRANS_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				helper.PRE_UPDATE(PT_IL_RECEIPT_TRANS_DTL_BEAN);

				new CRUDHandler().executeUpdate(PT_IL_RECEIPT_TRANS_DTL_BEAN,
						CommonUtils.getConnection());				
				CommonUtils.getConnection().commit();
				System.out.println("TEST");
				compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}

			PT_IL_RECEIPT_TRANS_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			exc.printStackTrace();
			/*Modified by ganesh on 13-06-2018 to throw error in notification bar*/
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
			/*end*/
		}
		return null;

	}

	
	/*End*/
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_RECEIPT_TRANS_DTL_BEAN = (PT_IL_RECEIPT_TRANS_DTL) dataTable
					.getRowData();
			PT_IL_RECEIPT_TRANS_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_RECEIPT_TRANS_DTL> PT_IL_RECEIPT_TRANS_DTL_ITR = dataList_PT_IL_RECEIPT_TRANS_DTL
				.iterator();
		while (PT_IL_RECEIPT_TRANS_DTL_ITR.hasNext()) {
			PT_IL_RECEIPT_TRANS_DTL_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_UI_M_RTD_TXN_CODE.resetValue();
		COMP_UI_M_DOC_NO.resetValue();
		COMP_UI_M_DOC_DT.resetValue();
		COMP_UI_M_ACC_YEAR.resetValue();
		COMP_UI_M_DEP_LC_DEP_AMT.resetValue();
		COMP_RTD_DEP_LC_AMT.resetValue();
		COMP_RTD_DES_POL_NO.resetValue();
		COMP_RTD_TRNS_YN.resetValue();
		COMP_RTD_REASON_CODE.resetValue();
		COMP_RTD_REV_REMARKS.resetValue();
		COMP_RTD_TXN_CODE.resetValue();
		COMP_RTD_DOC_NO.resetValue();
		COMP_RTD_DOC_DT.resetValue();
		COMP_RTD_ACNT_YR.resetValue();
		COMP_UI_M_REASON_CODE_DESC.resetValue();
		COMP_UI_M_RTD_DES_POL_NO.resetValue();

	}
	

	/**
	 * Instantiates all components in PT_IL_RECEIPT_TRANS_DTL_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_RTD_TXN_CODE				 = new HtmlInputText();
		COMP_UI_M_DOC_NO				 = new HtmlInputText();
		COMP_UI_M_ACC_YEAR				 = new HtmlInputText();
		COMP_UI_M_DEP_LC_DEP_AMT			 = new HtmlInputText();
		COMP_RTD_DEP_LC_AMT				 = new HtmlInputText();
		COMP_RTD_DES_POL_NO				 = new HtmlInputText();
		COMP_RTD_REASON_CODE				 = new HtmlInputText();
		COMP_RTD_REV_REMARKS				 = new HtmlInputText();
		COMP_RTD_TXN_CODE				 = new HtmlInputText();
		COMP_RTD_DOC_NO					 = new HtmlInputText();
		COMP_RTD_ACNT_YR				 = new HtmlInputText();
		COMP_UI_M_REASON_CODE_DESC			 = new HtmlInputText();
		COMP_UI_M_RTD_DES_POL_NO			 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_RTD_TRNS_YN				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_UI_M_DOC_DT				 = new HtmlCalendar();
		COMP_RTD_DOC_DT					 = new HtmlCalendar();
		
/*Added by Janani on 10.07.2017 ZBILQC-1719675*/
		
		COMP_RTH_CREATE = new HtmlAjaxCommandButton();
		COMP_RTH_DELETE = new HtmlAjaxCommandButton();
		COMP_RTH_SAVE = new HtmlCommandButton();
		
		/*End*/

	}



	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListRTD_TRNS_YN() {
		if (listRTD_TRNS_YN.size() == 0) {
			listRTD_TRNS_YN.clear();
			try {
				listRTD_TRNS_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listRTD_TRNS_YN;
	}

	public void setListRTD_TRNS_YN(List<SelectItem> listRTD_TRNS_YN) {
		this.listRTD_TRNS_YN = listRTD_TRNS_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public ArrayList<com.iii.premia.common.bean.LovBean> lovRTD_DES_POL_NO(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		/*Commentted &Modified by saritha on 11-09-2017 for ssp call id ZBILQC-1718875*/ 
		PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN = compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN();
		try {
			
			System.out.println("pol_Sys_Id"+PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_SYS_ID());
			suggestionList = listitemutil.P_CALL_LOV("PILT032_APAC",
					"PT_IL_RECEIPT_TRANS_DTL", "RTD_DES_POL_NO", 
					PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_SYS_ID(),
					PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_NO(),
					/*End*/
					null,
					null,
					null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public ArrayList<com.iii.premia.common.bean.LovBean> lovRTD_REASON_CODE(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT032_APAC",
					"PT_IL_RECEIPT_TRANS_DTL", "RTD_REASON_CODE","REV_REASON",null, null, null,
					null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	//P_CALL_LOV('PT_IL_RECEIPT_TRANS_DTL.RTD_REASON_CODE','REV_REASON');
	
	public void validateRTD_REASON_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_REASON_CODE((String) value);
			helper.WHEN_VALIDATE_ITEM_RTD_REASON_CODE(PT_IL_RECEIPT_TRANS_DTL_BEAN);
			COMP_UI_M_REASON_CODE_DESC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "RTD_REASON_CODE",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void validateRTD_DES_POL_NO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_DES_POL_NO((String) value);
			helper.WHEN_VALIDATE_ITEM_RTD_DES_POL_NO(PT_IL_RECEIPT_TRANS_DTL_BEAN, compositeAction);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "RTD_REASON_CODE",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	 


	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
					helper.executeQuery(compositeAction);
				if (PT_IL_RECEIPT_TRANS_DTL_BEAN.getROWID() != null) {
					helper.POST_QUERY(PT_IL_RECEIPT_TRANS_DTL_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlInputText getCOMP_UI_M_RTD_DES_POL_NO() {
		return COMP_UI_M_RTD_DES_POL_NO;
	}

	public void setCOMP_UI_M_RTD_DES_POL_NO(HtmlInputText comp_ui_m_rtd_des_pol_no) {
		COMP_UI_M_RTD_DES_POL_NO = comp_ui_m_rtd_des_pol_no;
	}

	/*Added by Janani on 10.07.2017 ZBILQC-1719675*/
	
	private HtmlAjaxCommandButton COMP_RTH_CREATE;
	private HtmlAjaxCommandButton COMP_RTH_DELETE;
	private HtmlCommandButton COMP_RTH_SAVE;
	
	 public HtmlAjaxCommandButton getCOMP_RTH_CREATE() {
		return COMP_RTH_CREATE;
	}

	public void setCOMP_RTH_CREATE(HtmlAjaxCommandButton cOMP_RTH_CREATE) {
		COMP_RTH_CREATE = cOMP_RTH_CREATE;
	}

	public HtmlAjaxCommandButton getCOMP_RTH_DELETE() {
		return COMP_RTH_DELETE;
	}

	public void setCOMP_RTH_DELETE(HtmlAjaxCommandButton cOMP_RTH_DELETE) {
		COMP_RTH_DELETE = cOMP_RTH_DELETE;
	}

	public HtmlCommandButton getCOMP_RTH_SAVE() {
		return COMP_RTH_SAVE;
	}

	public void setCOMP_RTH_SAVE(HtmlCommandButton cOMP_RTH_SAVE) {
		COMP_RTH_SAVE = cOMP_RTH_SAVE;
	}
	
	
	
	public void disableAllComponent(boolean disabled) {
		COMP_UI_M_RTD_TXN_CODE.setDisabled(disabled);
		COMP_UI_M_DOC_NO.setDisabled(disabled);
		COMP_UI_M_DOC_DT.setDisabled(disabled);
		COMP_UI_M_ACC_YEAR.setDisabled(disabled);
		COMP_UI_M_DEP_LC_DEP_AMT.setDisabled(disabled);
		COMP_RTD_DEP_LC_AMT.setDisabled(disabled);
		COMP_RTD_DES_POL_NO.setDisabled(disabled);
		COMP_RTD_TRNS_YN.setDisabled(disabled);
		COMP_RTD_REASON_CODE.setDisabled(disabled);
		COMP_RTD_REV_REMARKS.setDisabled(disabled);
		COMP_RTD_TXN_CODE.setDisabled(disabled);
		COMP_RTD_DOC_NO.setDisabled(disabled);
		COMP_RTD_DOC_DT.setDisabled(disabled);
		COMP_RTD_ACNT_YR.setDisabled(disabled);
		COMP_UI_M_REASON_CODE_DESC.setDisabled(disabled);
		COMP_UI_M_RTD_DES_POL_NO.setDisabled(disabled);
		COMP_RTH_CREATE.setDisabled(disabled);
		COMP_RTH_DELETE.setDisabled(disabled);
		COMP_RTH_SAVE.setDisabled(disabled);
	}
	
	/*End*/
	
}
