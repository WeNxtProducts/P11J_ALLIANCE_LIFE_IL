package com.iii.pel.forms.PILQ106_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_UNIT_FUND_REG_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_PC_PAID_DT_LABEL;

	private HtmlCalendar COMP_PC_PAID_DT;

	private HtmlOutputLabel COMP_UFRH_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_UFRH_TYPE;

	private HtmlOutputLabel COMP_UFRH_PREM_LC_AMT_LABEL;

	private HtmlInputText COMP_UFRH_PREM_LC_AMT;

	private HtmlOutputLabel COMP_UFRH_COMM_LC_AMT_LABEL;

	private HtmlInputText COMP_UFRH_COMM_LC_AMT;

	private HtmlOutputLabel COMP_UFRH_RISK_LC_AMT_LABEL;

	private HtmlInputText COMP_UFRH_RISK_LC_AMT;

	private HtmlOutputLabel COMP_UFRH_CHARGE_LC_AMT_LABEL;

	private HtmlInputText COMP_UFRH_CHARGE_LC_AMT;

	private HtmlOutputLabel COMP_UFRH_INV_LC_AMT_LABEL;

	private HtmlInputText COMP_UFRH_INV_LC_AMT;

	private HtmlOutputLabel COMP_UFRH_BUY_SEL_LABEL;

	private HtmlSelectOneMenu COMP_UFRH_BUY_SEL;

	private HtmlOutputLabel COMP_UFRH_BUY_LC_AMT_LABEL;

	private HtmlInputText COMP_UFRH_BUY_LC_AMT;

	private HtmlOutputLabel COMP_UFRH_SELL_LC_AMT_LABEL;

	private HtmlInputText COMP_UFRH_SELL_LC_AMT;

	private PT_IL_UNIT_FUND_REG_HDR PT_IL_UNIT_FUND_REG_HDR_BEAN;

	public PILQ106_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_UNIT_FUND_REG_HDR_HELPER helper;

	private List<PT_IL_UNIT_FUND_REG_HDR> dataList_PT_IL_UNIT_FUND_REG_HDR = new ArrayList<PT_IL_UNIT_FUND_REG_HDR>();

	private UIData dataTable;

	private List<SelectItem> listUFRH_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listUFRH_BUY_SEL = new ArrayList<SelectItem>();
	private String DEFAULT_WHERE;
	
	public PT_IL_UNIT_FUND_REG_HDR_ACTION() {

		PT_IL_UNIT_FUND_REG_HDR_BEAN = new PT_IL_UNIT_FUND_REG_HDR();
		helper = new PT_IL_UNIT_FUND_REG_HDR_HELPER();
		prepareDropDownOptions();
	}

	public HtmlOutputLabel getCOMP_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_SCHD_PYMT_DT() {
		return COMP_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_PC_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_PC_SCHD_PYMT_DT_LABEL = COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_PC_SCHD_PYMT_DT(HtmlCalendar COMP_PC_SCHD_PYMT_DT) {
		this.COMP_PC_SCHD_PYMT_DT = COMP_PC_SCHD_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_PC_PAID_DT_LABEL() {
		return COMP_PC_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_PAID_DT() {
		return COMP_PC_PAID_DT;
	}

	public void setCOMP_PC_PAID_DT_LABEL(HtmlOutputLabel COMP_PC_PAID_DT_LABEL) {
		this.COMP_PC_PAID_DT_LABEL = COMP_PC_PAID_DT_LABEL;
	}

	public void setCOMP_PC_PAID_DT(HtmlCalendar COMP_PC_PAID_DT) {
		this.COMP_PC_PAID_DT = COMP_PC_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_UFRH_TYPE_LABEL() {
		return COMP_UFRH_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UFRH_TYPE() {
		return COMP_UFRH_TYPE;
	}

	public void setCOMP_UFRH_TYPE_LABEL(HtmlOutputLabel COMP_UFRH_TYPE_LABEL) {
		this.COMP_UFRH_TYPE_LABEL = COMP_UFRH_TYPE_LABEL;
	}

	public void setCOMP_UFRH_TYPE(HtmlSelectOneMenu COMP_UFRH_TYPE) {
		this.COMP_UFRH_TYPE = COMP_UFRH_TYPE;
	}

	public HtmlOutputLabel getCOMP_UFRH_PREM_LC_AMT_LABEL() {
		return COMP_UFRH_PREM_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UFRH_PREM_LC_AMT() {
		return COMP_UFRH_PREM_LC_AMT;
	}

	public void setCOMP_UFRH_PREM_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UFRH_PREM_LC_AMT_LABEL) {
		this.COMP_UFRH_PREM_LC_AMT_LABEL = COMP_UFRH_PREM_LC_AMT_LABEL;
	}

	public void setCOMP_UFRH_PREM_LC_AMT(HtmlInputText COMP_UFRH_PREM_LC_AMT) {
		this.COMP_UFRH_PREM_LC_AMT = COMP_UFRH_PREM_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_UFRH_COMM_LC_AMT_LABEL() {
		return COMP_UFRH_COMM_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UFRH_COMM_LC_AMT() {
		return COMP_UFRH_COMM_LC_AMT;
	}

	public void setCOMP_UFRH_COMM_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UFRH_COMM_LC_AMT_LABEL) {
		this.COMP_UFRH_COMM_LC_AMT_LABEL = COMP_UFRH_COMM_LC_AMT_LABEL;
	}

	public void setCOMP_UFRH_COMM_LC_AMT(HtmlInputText COMP_UFRH_COMM_LC_AMT) {
		this.COMP_UFRH_COMM_LC_AMT = COMP_UFRH_COMM_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_UFRH_RISK_LC_AMT_LABEL() {
		return COMP_UFRH_RISK_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UFRH_RISK_LC_AMT() {
		return COMP_UFRH_RISK_LC_AMT;
	}

	public void setCOMP_UFRH_RISK_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UFRH_RISK_LC_AMT_LABEL) {
		this.COMP_UFRH_RISK_LC_AMT_LABEL = COMP_UFRH_RISK_LC_AMT_LABEL;
	}

	public void setCOMP_UFRH_RISK_LC_AMT(HtmlInputText COMP_UFRH_RISK_LC_AMT) {
		this.COMP_UFRH_RISK_LC_AMT = COMP_UFRH_RISK_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_UFRH_CHARGE_LC_AMT_LABEL() {
		return COMP_UFRH_CHARGE_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UFRH_CHARGE_LC_AMT() {
		return COMP_UFRH_CHARGE_LC_AMT;
	}

	public void setCOMP_UFRH_CHARGE_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UFRH_CHARGE_LC_AMT_LABEL) {
		this.COMP_UFRH_CHARGE_LC_AMT_LABEL = COMP_UFRH_CHARGE_LC_AMT_LABEL;
	}

	public void setCOMP_UFRH_CHARGE_LC_AMT(HtmlInputText COMP_UFRH_CHARGE_LC_AMT) {
		this.COMP_UFRH_CHARGE_LC_AMT = COMP_UFRH_CHARGE_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_UFRH_INV_LC_AMT_LABEL() {
		return COMP_UFRH_INV_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UFRH_INV_LC_AMT() {
		return COMP_UFRH_INV_LC_AMT;
	}

	public void setCOMP_UFRH_INV_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UFRH_INV_LC_AMT_LABEL) {
		this.COMP_UFRH_INV_LC_AMT_LABEL = COMP_UFRH_INV_LC_AMT_LABEL;
	}

	public void setCOMP_UFRH_INV_LC_AMT(HtmlInputText COMP_UFRH_INV_LC_AMT) {
		this.COMP_UFRH_INV_LC_AMT = COMP_UFRH_INV_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_UFRH_BUY_SEL_LABEL() {
		return COMP_UFRH_BUY_SEL_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UFRH_BUY_SEL() {
		return COMP_UFRH_BUY_SEL;
	}

	public void setCOMP_UFRH_BUY_SEL_LABEL(
			HtmlOutputLabel COMP_UFRH_BUY_SEL_LABEL) {
		this.COMP_UFRH_BUY_SEL_LABEL = COMP_UFRH_BUY_SEL_LABEL;
	}

	public void setCOMP_UFRH_BUY_SEL(HtmlSelectOneMenu COMP_UFRH_BUY_SEL) {
		this.COMP_UFRH_BUY_SEL = COMP_UFRH_BUY_SEL;
	}

	public HtmlOutputLabel getCOMP_UFRH_BUY_LC_AMT_LABEL() {
		return COMP_UFRH_BUY_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UFRH_BUY_LC_AMT() {
		return COMP_UFRH_BUY_LC_AMT;
	}

	public void setCOMP_UFRH_BUY_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UFRH_BUY_LC_AMT_LABEL) {
		this.COMP_UFRH_BUY_LC_AMT_LABEL = COMP_UFRH_BUY_LC_AMT_LABEL;
	}

	public void setCOMP_UFRH_BUY_LC_AMT(HtmlInputText COMP_UFRH_BUY_LC_AMT) {
		this.COMP_UFRH_BUY_LC_AMT = COMP_UFRH_BUY_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_UFRH_SELL_LC_AMT_LABEL() {
		return COMP_UFRH_SELL_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UFRH_SELL_LC_AMT() {
		return COMP_UFRH_SELL_LC_AMT;
	}

	public void setCOMP_UFRH_SELL_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UFRH_SELL_LC_AMT_LABEL) {
		this.COMP_UFRH_SELL_LC_AMT_LABEL = COMP_UFRH_SELL_LC_AMT_LABEL;
	}

	public void setCOMP_UFRH_SELL_LC_AMT(HtmlInputText COMP_UFRH_SELL_LC_AMT) {
		this.COMP_UFRH_SELL_LC_AMT = COMP_UFRH_SELL_LC_AMT;
	}

	public PT_IL_UNIT_FUND_REG_HDR getPT_IL_UNIT_FUND_REG_HDR_BEAN() {
		return PT_IL_UNIT_FUND_REG_HDR_BEAN;
	}

	public void setPT_IL_UNIT_FUND_REG_HDR_BEAN(
			PT_IL_UNIT_FUND_REG_HDR PT_IL_UNIT_FUND_REG_HDR_BEAN) {
		this.PT_IL_UNIT_FUND_REG_HDR_BEAN = PT_IL_UNIT_FUND_REG_HDR_BEAN;
	}

	public List<PT_IL_UNIT_FUND_REG_HDR> getDataList_PT_IL_UNIT_FUND_REG_HDR() {
		return dataList_PT_IL_UNIT_FUND_REG_HDR;
	}

	public void setDataListPT_IL_UNIT_FUND_REG_HDR(
			List<PT_IL_UNIT_FUND_REG_HDR> dataList_PT_IL_UNIT_FUND_REG_HDR) {
		this.dataList_PT_IL_UNIT_FUND_REG_HDR = dataList_PT_IL_UNIT_FUND_REG_HDR;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_UNIT_FUND_REG_HDR_BEAN = new PT_IL_UNIT_FUND_REG_HDR();
				resetAllComponent();
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

				new CRUDHandler().executeDelete(PT_IL_UNIT_FUND_REG_HDR_BEAN,
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
				dataList_PT_IL_UNIT_FUND_REG_HDR
						.remove(PT_IL_UNIT_FUND_REG_HDR_BEAN);
				if (dataList_PT_IL_UNIT_FUND_REG_HDR.size() > 0) {

					PT_IL_UNIT_FUND_REG_HDR_BEAN = dataList_PT_IL_UNIT_FUND_REG_HDR
							.get(0);
				} else if (dataList_PT_IL_UNIT_FUND_REG_HDR.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
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

	public void postRecord(ActionEvent event) {
		try {
			if (PT_IL_UNIT_FUND_REG_HDR_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PT_IL_UNIT_FUND_REG_HDR_BEAN,
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
				dataList_PT_IL_UNIT_FUND_REG_HDR
						.add(PT_IL_UNIT_FUND_REG_HDR_BEAN);
			} else if (PT_IL_UNIT_FUND_REG_HDR_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PT_IL_UNIT_FUND_REG_HDR_BEAN,
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

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}
	private void resetSelectedRow() {
		Iterator<PT_IL_UNIT_FUND_REG_HDR> PT_IL_UNIT_FUND_REG_HDR_BEAN_ITR = dataList_PT_IL_UNIT_FUND_REG_HDR.iterator();
		while (PT_IL_UNIT_FUND_REG_HDR_BEAN_ITR.hasNext()) {
		    PT_IL_UNIT_FUND_REG_HDR_BEAN_ITR.next().setRowSelected(false);
		}
	}
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
		    resetSelectedRow();
			PT_IL_UNIT_FUND_REG_HDR_BEAN = (PT_IL_UNIT_FUND_REG_HDR) dataTable
					.getRowData();
			helper.postQuery(PT_IL_UNIT_FUND_REG_HDR_BEAN);
			helper.whenNewRecordInstance(PT_IL_UNIT_FUND_REG_HDR_BEAN, 
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			helper.onPopulateDetails(PT_IL_UNIT_FUND_REG_HDR_BEAN, compositeAction);
			PT_IL_UNIT_FUND_REG_HDR_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	public void resetAllComponent() {
		COMP_PC_SCHD_PYMT_DT.resetValue();
		COMP_PC_PAID_DT.resetValue();
		COMP_UFRH_TYPE.resetValue();
		COMP_UFRH_PREM_LC_AMT.resetValue();
		COMP_UFRH_COMM_LC_AMT.resetValue();
		COMP_UFRH_RISK_LC_AMT.resetValue();
		COMP_UFRH_CHARGE_LC_AMT.resetValue();
		COMP_UFRH_INV_LC_AMT.resetValue();
		COMP_UFRH_BUY_SEL.resetValue();
		COMP_UFRH_BUY_LC_AMT.resetValue();
		COMP_UFRH_SELL_LC_AMT.resetValue();
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
	
	public void prepareDropDownOptions(){
		try {
			listUFRH_TYPE = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), 
					"PILQ106_APAC", 
					"PT_IL_UNIT_FUND_REG_HDR", 
					"PT_IL_UNIT_FUND_REG_HDR.UFRH_TYPE", "LINK_TYP");
			listUFRH_BUY_SEL = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), 
					"PILQ106_APAC", 
					"PT_IL_UNIT_FUND_REG_HDR", 
					"PT_IL_UNIT_FUND_REG_HDR.UFRH_BUY_SEL", "UNIT_SEL_BUY");
		} catch (DBException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DROP_DOWN_VALUE_PREPARATION", e.getMessage());
		}
	}

	public List<SelectItem> getListUFRH_TYPE() {
		return listUFRH_TYPE;
	}

	public void setListUFRH_TYPE(List<SelectItem> listUFRH_TYPE) {
		this.listUFRH_TYPE = listUFRH_TYPE;
	}

	public List<SelectItem> getListUFRH_BUY_SEL() {
		return listUFRH_BUY_SEL;
	}

	public void setListUFRH_BUY_SEL(List<SelectItem> listUFRH_BUY_SEL) {
		this.listUFRH_BUY_SEL = listUFRH_BUY_SEL;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad( ) {
		try {
			if (isBlockFlag()) {
				loadBlock();
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void loadBlock() throws Exception{
		helper.preQuery(this);
		helper.executeQuery(compositeAction);
		helper.postQuery(PT_IL_UNIT_FUND_REG_HDR_BEAN);
		helper.whenNewRecordInstance(PT_IL_UNIT_FUND_REG_HDR_BEAN, 
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
	}

	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}

}
