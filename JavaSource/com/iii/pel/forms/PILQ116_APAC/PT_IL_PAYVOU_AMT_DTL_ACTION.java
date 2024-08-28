package com.iii.pel.forms.PILQ116_APAC;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PAYVOU_AMT_DTL_ACTION extends CommonAction {

	private PT_IL_PAYVOU_AMT_DTL PT_IL_PAYVOU_AMT_DTL_BEAN;

	public PILQ116_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_PAYVOU_AMT_DTL_HELPER helper;

	private List<PT_IL_PAYVOU_AMT_DTL> dataList_PT_IL_PAYVOU_AMT_DTL = new ArrayList<PT_IL_PAYVOU_AMT_DTL>();

	private UIData dataTable;

	public PT_IL_PAYVOU_AMT_DTL_ACTION() {

		PT_IL_PAYVOU_AMT_DTL_BEAN = new PT_IL_PAYVOU_AMT_DTL();
		helper = new PT_IL_PAYVOU_AMT_DTL_HELPER();
	}

	public PT_IL_PAYVOU_AMT_DTL getPT_IL_PAYVOU_AMT_DTL_BEAN() {
		return PT_IL_PAYVOU_AMT_DTL_BEAN;
	}

	public void setPT_IL_PAYVOU_AMT_DTL_BEAN(
			PT_IL_PAYVOU_AMT_DTL PT_IL_PAYVOU_AMT_DTL_BEAN) {
		this.PT_IL_PAYVOU_AMT_DTL_BEAN = PT_IL_PAYVOU_AMT_DTL_BEAN;
	}

	public List<PT_IL_PAYVOU_AMT_DTL> getDataList_PT_IL_PAYVOU_AMT_DTL() {
		return dataList_PT_IL_PAYVOU_AMT_DTL;
	}

	public void setDataListPT_IL_PAYVOU_AMT_DTL(
			List<PT_IL_PAYVOU_AMT_DTL> dataList_PT_IL_PAYVOU_AMT_DTL) {
		this.dataList_PT_IL_PAYVOU_AMT_DTL = dataList_PT_IL_PAYVOU_AMT_DTL;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_PAYVOU_AMT_DTL_BEAN = new PT_IL_PAYVOU_AMT_DTL();
				/*
				 * resetAllComponent(); resetSelectedRow();
				 */
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

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {

			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
}