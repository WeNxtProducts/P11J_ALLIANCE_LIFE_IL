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

public class PT_IL_PREM_COLL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_UI_M_DUE_AMT_LABEL;

	private HtmlInputText COMP_UI_M_DUE_AMT;

	private HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_AVLB_BAL_AMT;

	private HtmlOutputLabel COMP_PC_LC_PAID_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_PAID_AMT;

	private PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN;

	public PILQ020_COMPOSITE_ACTION compositeAction;

	private PT_IL_PREM_COLL_HELPER helper;

	private List<PT_IL_PREM_COLL> dataList_PT_IL_PREM_COLL = new ArrayList<PT_IL_PREM_COLL>();

	private UIData dataTable;

	public PT_IL_PREM_COLL_ACTION() {

		PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
		helper = new PT_IL_PREM_COLL_HELPER();
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

	public HtmlOutputLabel getCOMP_UI_M_DUE_AMT_LABEL() {
		return COMP_UI_M_DUE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUE_AMT() {
		return COMP_UI_M_DUE_AMT;
	}

	public void setCOMP_UI_M_DUE_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_DUE_AMT_LABEL) {
		this.COMP_UI_M_DUE_AMT_LABEL = COMP_UI_M_DUE_AMT_LABEL;
	}

	public void setCOMP_UI_M_DUE_AMT(HtmlInputText COMP_UI_M_DUE_AMT) {
		this.COMP_UI_M_DUE_AMT = COMP_UI_M_DUE_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_AVLB_BAL_AMT_LABEL() {
		return COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_AVLB_BAL_AMT() {
		return COMP_PC_LC_AVLB_BAL_AMT;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT_LABEL(
			HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL) {
		this.COMP_PC_LC_AVLB_BAL_AMT_LABEL = COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT(HtmlInputText COMP_PC_LC_AVLB_BAL_AMT) {
		this.COMP_PC_LC_AVLB_BAL_AMT = COMP_PC_LC_AVLB_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_PAID_AMT_LABEL() {
		return COMP_PC_LC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_PAID_AMT() {
		return COMP_PC_LC_PAID_AMT;
	}

	public void setCOMP_PC_LC_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_PC_LC_PAID_AMT_LABEL) {
		this.COMP_PC_LC_PAID_AMT_LABEL = COMP_PC_LC_PAID_AMT_LABEL;
	}

	public void setCOMP_PC_LC_PAID_AMT(HtmlInputText COMP_PC_LC_PAID_AMT) {
		this.COMP_PC_LC_PAID_AMT = COMP_PC_LC_PAID_AMT;
	}

	public PT_IL_PREM_COLL getPT_IL_PREM_COLL_BEAN() {
		return PT_IL_PREM_COLL_BEAN;
	}

	public void setPT_IL_PREM_COLL_BEAN(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) {
		this.PT_IL_PREM_COLL_BEAN = PT_IL_PREM_COLL_BEAN;
	}

	public List<PT_IL_PREM_COLL> getDataList_PT_IL_PREM_COLL() {
		return dataList_PT_IL_PREM_COLL;
	}

	public void setDataListPT_IL_PREM_COLL(
			List<PT_IL_PREM_COLL> dataList_PT_IL_PREM_COLL) {
		this.dataList_PT_IL_PREM_COLL = dataList_PT_IL_PREM_COLL;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
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
			PT_IL_PREM_COLL_BEAN = (PT_IL_PREM_COLL) dataTable
					.getRowData();
			PT_IL_PREM_COLL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_PREM_COLL> PT_IL_PREM_COLL_BEAN_ITR = dataList_PT_IL_PREM_COLL.iterator();
		while (PT_IL_PREM_COLL_BEAN_ITR.hasNext()) {
			PT_IL_PREM_COLL_BEAN_ITR.next().setRowSelected(false);
		}
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void setDataList_PT_IL_PREM_COLL(
			List<PT_IL_PREM_COLL> dataList_PT_IL_PREM_COLL) {
		this.dataList_PT_IL_PREM_COLL = dataList_PT_IL_PREM_COLL;
	}
}