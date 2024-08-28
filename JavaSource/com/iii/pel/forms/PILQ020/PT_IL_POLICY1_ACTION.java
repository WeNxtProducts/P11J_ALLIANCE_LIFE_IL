package com.iii.pel.forms.PILQ020;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POLICY1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POL_PYMT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_POL_PYMT_TYPE;

	private HtmlOutputLabel COMP_POL_END_NO_IDX_LABEL;

	private HtmlInputText COMP_POL_END_NO_IDX;

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_CONT_CODE_LABEL;

	private HtmlInputText COMP_POL_CONT_CODE;

	private HtmlOutputLabel COMP_UI_M_AGENT_CODE_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_CODE;

	private HtmlOutputLabel COMP_POL_LC_FIRST_PREM_LABEL;

	private HtmlInputText COMP_POL_LC_FIRST_PREM;

	private HtmlOutputLabel COMP_POL_CUST_CODE;

	private HtmlOutputLabel COMP_POL_ASSURED_NAME_LABEL;

	private HtmlInputText COMP_POL_ASSURED_NAME;

	private HtmlOutputLabel COMP_UI_M_CUST_NAME_LABEL;

	private HtmlInputText COMP_UI_M_CUST_NAME;

	private PT_IL_POLICY1 PT_IL_POLICY1_BEAN;

	public PILQ020_COMPOSITE_ACTION compositeAction;

	private PT_IL_POLICY1_HELPER helper;

	private List<PT_IL_POLICY1> dataList_PT_IL_POLICY1 = new ArrayList<PT_IL_POLICY1>();

	private UIData dataTable;

	private List<SelectItem> listPOL_PYMT_TYPE = new ArrayList<SelectItem>();

	public PT_IL_POLICY1_ACTION() {
		PT_IL_POLICY1_BEAN = new PT_IL_POLICY1();
		helper = new PT_IL_POLICY1_HELPER();
		dropdown();
	}
	
	public void dropdown(){
		try {
			Connection connection = CommonUtils.getConnection();
			setListPOL_PYMT_TYPE(ListItemUtil.getDropDownListValue_1(
					connection, "PILQ020", "PT_IL_POLICY1",
					"PT_IL_POLICY1.POL_PYMT_TYPE", null));
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}

	public HtmlOutputLabel getCOMP_POL_PYMT_TYPE_LABEL() {
		return COMP_POL_PYMT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_PYMT_TYPE() {
		return COMP_POL_PYMT_TYPE;
	}

	public void setCOMP_POL_PYMT_TYPE_LABEL(
			HtmlOutputLabel COMP_POL_PYMT_TYPE_LABEL) {
		this.COMP_POL_PYMT_TYPE_LABEL = COMP_POL_PYMT_TYPE_LABEL;
	}

	public void setCOMP_POL_PYMT_TYPE(HtmlSelectOneMenu COMP_POL_PYMT_TYPE) {
		this.COMP_POL_PYMT_TYPE = COMP_POL_PYMT_TYPE;
	}

	public HtmlOutputLabel getCOMP_POL_END_NO_IDX_LABEL() {
		return COMP_POL_END_NO_IDX_LABEL;
	}

	public HtmlInputText getCOMP_POL_END_NO_IDX() {
		return COMP_POL_END_NO_IDX;
	}

	public void setCOMP_POL_END_NO_IDX_LABEL(
			HtmlOutputLabel COMP_POL_END_NO_IDX_LABEL) {
		this.COMP_POL_END_NO_IDX_LABEL = COMP_POL_END_NO_IDX_LABEL;
	}

	public void setCOMP_POL_END_NO_IDX(HtmlInputText COMP_POL_END_NO_IDX) {
		this.COMP_POL_END_NO_IDX = COMP_POL_END_NO_IDX;
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_POL_CONT_CODE_LABEL() {
		return COMP_POL_CONT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CONT_CODE() {
		return COMP_POL_CONT_CODE;
	}

	public void setCOMP_POL_CONT_CODE_LABEL(
			HtmlOutputLabel COMP_POL_CONT_CODE_LABEL) {
		this.COMP_POL_CONT_CODE_LABEL = COMP_POL_CONT_CODE_LABEL;
	}

	public void setCOMP_POL_CONT_CODE(HtmlInputText COMP_POL_CONT_CODE) {
		this.COMP_POL_CONT_CODE = COMP_POL_CONT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_CODE_LABEL() {
		return COMP_UI_M_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_CODE() {
		return COMP_UI_M_AGENT_CODE;
	}

	public void setCOMP_UI_M_AGENT_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_CODE_LABEL) {
		this.COMP_UI_M_AGENT_CODE_LABEL = COMP_UI_M_AGENT_CODE_LABEL;
	}

	public void setCOMP_UI_M_AGENT_CODE(HtmlInputText COMP_UI_M_AGENT_CODE) {
		this.COMP_UI_M_AGENT_CODE = COMP_UI_M_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_LC_FIRST_PREM_LABEL() {
		return COMP_POL_LC_FIRST_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_FIRST_PREM() {
		return COMP_POL_LC_FIRST_PREM;
	}

	public void setCOMP_POL_LC_FIRST_PREM_LABEL(
			HtmlOutputLabel COMP_POL_LC_FIRST_PREM_LABEL) {
		this.COMP_POL_LC_FIRST_PREM_LABEL = COMP_POL_LC_FIRST_PREM_LABEL;
	}

	public void setCOMP_POL_LC_FIRST_PREM(HtmlInputText COMP_POL_LC_FIRST_PREM) {
		this.COMP_POL_LC_FIRST_PREM = COMP_POL_LC_FIRST_PREM;
	}

	public HtmlOutputLabel getCOMP_POL_CUST_CODE() {
		return COMP_POL_CUST_CODE;
	}

	public void setCOMP_POL_CUST_CODE(HtmlOutputLabel COMP_POL_CUST_CODE) {
		this.COMP_POL_CUST_CODE = COMP_POL_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_ASSURED_NAME_LABEL() {
		return COMP_POL_ASSURED_NAME_LABEL;
	}

	public HtmlInputText getCOMP_POL_ASSURED_NAME() {
		return COMP_POL_ASSURED_NAME;
	}

	public void setCOMP_POL_ASSURED_NAME_LABEL(
			HtmlOutputLabel COMP_POL_ASSURED_NAME_LABEL) {
		this.COMP_POL_ASSURED_NAME_LABEL = COMP_POL_ASSURED_NAME_LABEL;
	}

	public void setCOMP_POL_ASSURED_NAME(HtmlInputText COMP_POL_ASSURED_NAME) {
		this.COMP_POL_ASSURED_NAME = COMP_POL_ASSURED_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_NAME_LABEL() {
		return COMP_UI_M_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_NAME() {
		return COMP_UI_M_CUST_NAME;
	}

	public void setCOMP_UI_M_CUST_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_CUST_NAME_LABEL) {
		this.COMP_UI_M_CUST_NAME_LABEL = COMP_UI_M_CUST_NAME_LABEL;
	}

	public void setCOMP_UI_M_CUST_NAME(HtmlInputText COMP_UI_M_CUST_NAME) {
		this.COMP_UI_M_CUST_NAME = COMP_UI_M_CUST_NAME;
	}

	public PT_IL_POLICY1 getPT_IL_POLICY1_BEAN() {
		return PT_IL_POLICY1_BEAN;
	}

	public void setPT_IL_POLICY1_BEAN(PT_IL_POLICY1 PT_IL_POLICY1_BEAN) {
		this.PT_IL_POLICY1_BEAN = PT_IL_POLICY1_BEAN;
	}

	public List<PT_IL_POLICY1> getDataList_PT_IL_POLICY1() {
		return dataList_PT_IL_POLICY1;
	}

	public void setDataListPT_IL_POLICY1(
			List<PT_IL_POLICY1> dataList_PT_IL_POLICY1) {
		this.dataList_PT_IL_POLICY1 = dataList_PT_IL_POLICY1;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_POLICY1_BEAN = new PT_IL_POLICY1();
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

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListPOL_PYMT_TYPE() {
		if (listPOL_PYMT_TYPE.size() == 0) {
			listPOL_PYMT_TYPE.clear();
			try {
				listPOL_PYMT_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOL_PYMT_TYPE;
	}

	public void setListPOL_PYMT_TYPE(List<SelectItem> listPOL_PYMT_TYPE) {
		this.listPOL_PYMT_TYPE = listPOL_PYMT_TYPE;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void setDataList_PT_IL_POLICY1(
			List<PT_IL_POLICY1> dataList_PT_IL_POLICY1) {
		this.dataList_PT_IL_POLICY1 = dataList_PT_IL_POLICY1;
	}
	
	public void onLoad(){
		try{
			if(isBlockFlag()){
			helper.executeQuery(compositeAction);
			setBlockFlag(false);
			}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POLICY1_BEAN = (PT_IL_POLICY1) dataTable
					.getRowData();
			PT_IL_POLICY1_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_POLICY1> PT_IL_POLICY1_BEAN_ITR = dataList_PT_IL_POLICY1.iterator();
		while (PT_IL_POLICY1_BEAN_ITR.hasNext()) {
			PT_IL_POLICY1_BEAN_ITR.next().setRowSelected(false);
		}
	}
	
	/**
	 * Resets all components in PT_IL_POLICY1_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_POL_END_NO_IDX.resetValue();
		COMP_POL_NO.resetValue();
		COMP_POL_CONT_CODE.resetValue();
		COMP_UI_M_AGENT_CODE.resetValue();
		COMP_POL_LC_FIRST_PREM.resetValue();
		COMP_POL_ASSURED_NAME.resetValue();
		COMP_UI_M_CUST_NAME.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_POL_PYMT_TYPE.resetValue();

	}

	public PT_IL_POLICY1_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POLICY1_HELPER helper) {
		this.helper = helper;
	}

}
