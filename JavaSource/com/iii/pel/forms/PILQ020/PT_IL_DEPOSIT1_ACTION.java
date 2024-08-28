package com.iii.pel.forms.PILQ020;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_DEPOSIT1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_REVERSE_YN_LABEL;

	private HtmlInputText COMP_UI_M_REVERSE_YN;

	private HtmlOutputLabel COMP_DEP_TXN_CODE_LABEL;

	private HtmlInputText COMP_DEP_TXN_CODE;

	private HtmlOutputLabel COMP_DEP_DOC_NO_LABEL;

	private HtmlInputText COMP_DEP_DOC_NO;

	private HtmlOutputLabel COMP_DEP_DOC_DT_LABEL;

	private HtmlCalendar COMP_DEP_DOC_DT;

	private HtmlOutputLabel COMP_DEP_LC_DEP_AMT_LABEL;

	private HtmlInputText COMP_DEP_LC_DEP_AMT;

	private HtmlOutputLabel COMP_DEP_CR_UID_LABEL;

	private HtmlInputText COMP_DEP_CR_UID;

	private PT_IL_DEPOSIT1 PT_IL_DEPOSIT1_BEAN;

	public PILQ020_COMPOSITE_ACTION compositeAction;

	private PT_IL_DEPOSIT1_HELPER helper;

	private List<PT_IL_DEPOSIT1> dataList_PT_IL_DEPOSIT1 = new ArrayList<PT_IL_DEPOSIT1>();

	private UIData dataTable;

	public PT_IL_DEPOSIT1_ACTION() {

		PT_IL_DEPOSIT1_BEAN = new PT_IL_DEPOSIT1();
		helper = new PT_IL_DEPOSIT1_HELPER();
	}

	public HtmlOutputLabel getCOMP_UI_M_REVERSE_YN_LABEL() {
		return COMP_UI_M_REVERSE_YN_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_REVERSE_YN() {
		return COMP_UI_M_REVERSE_YN;
	}

	public void setCOMP_UI_M_REVERSE_YN_LABEL(
			HtmlOutputLabel COMP_UI_M_REVERSE_YN_LABEL) {
		this.COMP_UI_M_REVERSE_YN_LABEL = COMP_UI_M_REVERSE_YN_LABEL;
	}

	public void setCOMP_UI_M_REVERSE_YN(HtmlInputText COMP_UI_M_REVERSE_YN) {
		this.COMP_UI_M_REVERSE_YN = COMP_UI_M_REVERSE_YN;
	}

	public HtmlOutputLabel getCOMP_DEP_TXN_CODE_LABEL() {
		return COMP_DEP_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_TXN_CODE() {
		return COMP_DEP_TXN_CODE;
	}

	public void setCOMP_DEP_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_TXN_CODE_LABEL) {
		this.COMP_DEP_TXN_CODE_LABEL = COMP_DEP_TXN_CODE_LABEL;
	}

	public void setCOMP_DEP_TXN_CODE(HtmlInputText COMP_DEP_TXN_CODE) {
		this.COMP_DEP_TXN_CODE = COMP_DEP_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_DEP_DOC_NO_LABEL() {
		return COMP_DEP_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_DEP_DOC_NO() {
		return COMP_DEP_DOC_NO;
	}

	public void setCOMP_DEP_DOC_NO_LABEL(HtmlOutputLabel COMP_DEP_DOC_NO_LABEL) {
		this.COMP_DEP_DOC_NO_LABEL = COMP_DEP_DOC_NO_LABEL;
	}

	public void setCOMP_DEP_DOC_NO(HtmlInputText COMP_DEP_DOC_NO) {
		this.COMP_DEP_DOC_NO = COMP_DEP_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_DEP_DOC_DT_LABEL() {
		return COMP_DEP_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DEP_DOC_DT() {
		return COMP_DEP_DOC_DT;
	}

	public void setCOMP_DEP_DOC_DT_LABEL(HtmlOutputLabel COMP_DEP_DOC_DT_LABEL) {
		this.COMP_DEP_DOC_DT_LABEL = COMP_DEP_DOC_DT_LABEL;
	}

	public void setCOMP_DEP_DOC_DT(HtmlCalendar COMP_DEP_DOC_DT) {
		this.COMP_DEP_DOC_DT = COMP_DEP_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_DEP_LC_DEP_AMT_LABEL() {
		return COMP_DEP_LC_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_DEP_LC_DEP_AMT() {
		return COMP_DEP_LC_DEP_AMT;
	}

	public void setCOMP_DEP_LC_DEP_AMT_LABEL(
			HtmlOutputLabel COMP_DEP_LC_DEP_AMT_LABEL) {
		this.COMP_DEP_LC_DEP_AMT_LABEL = COMP_DEP_LC_DEP_AMT_LABEL;
	}

	public void setCOMP_DEP_LC_DEP_AMT(HtmlInputText COMP_DEP_LC_DEP_AMT) {
		this.COMP_DEP_LC_DEP_AMT = COMP_DEP_LC_DEP_AMT;
	}

	public HtmlOutputLabel getCOMP_DEP_CR_UID_LABEL() {
		return COMP_DEP_CR_UID_LABEL;
	}

	public HtmlInputText getCOMP_DEP_CR_UID() {
		return COMP_DEP_CR_UID;
	}

	public void setCOMP_DEP_CR_UID_LABEL(HtmlOutputLabel COMP_DEP_CR_UID_LABEL) {
		this.COMP_DEP_CR_UID_LABEL = COMP_DEP_CR_UID_LABEL;
	}

	public void setCOMP_DEP_CR_UID(HtmlInputText COMP_DEP_CR_UID) {
		this.COMP_DEP_CR_UID = COMP_DEP_CR_UID;
	}

	public PT_IL_DEPOSIT1 getPT_IL_DEPOSIT1_BEAN() {
		return PT_IL_DEPOSIT1_BEAN;
	}

	public void setPT_IL_DEPOSIT1_BEAN(PT_IL_DEPOSIT1 PT_IL_DEPOSIT1_BEAN) {
		this.PT_IL_DEPOSIT1_BEAN = PT_IL_DEPOSIT1_BEAN;
	}

	

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_DEPOSIT1_BEAN = new PT_IL_DEPOSIT1();
				// resetAllComponent();
				// resetSelectedRow();
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

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public List<PT_IL_DEPOSIT1> getDataList_PT_IL_DEPOSIT1() {
		return dataList_PT_IL_DEPOSIT1;
	}

	public void setDataList_PT_IL_DEPOSIT1(
			List<PT_IL_DEPOSIT1> dataList_PT_IL_DEPOSIT1) {
		this.dataList_PT_IL_DEPOSIT1 = dataList_PT_IL_DEPOSIT1;
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
			PT_IL_DEPOSIT1_BEAN = (PT_IL_DEPOSIT1) dataTable
					.getRowData();
			PT_IL_DEPOSIT1_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_DEPOSIT1> PT_IL_DEPOSIT1_BEAN_ITR = dataList_PT_IL_DEPOSIT1.iterator();
		while (PT_IL_DEPOSIT1_BEAN_ITR.hasNext()) {
			PT_IL_DEPOSIT1_BEAN_ITR.next().setRowSelected(false);
		}
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
}
