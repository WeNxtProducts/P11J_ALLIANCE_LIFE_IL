package com.iii.pel.forms.PILQ114_APAC;

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

public class PT_IL_SURR_VALUE_ACTION extends CommonAction {

	private PT_IL_SURR_VALUE PT_IL_SURR_VALUE_BEAN;

	public PILQ114_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_SURR_VALUE_HELPER helper;

	private List<PT_IL_SURR_VALUE> dataList_PT_IL_SURR_VALUE = new ArrayList<PT_IL_SURR_VALUE>();

	private UIData dataTable;

	public PT_IL_SURR_VALUE_ACTION() {

		PT_IL_SURR_VALUE_BEAN = new PT_IL_SURR_VALUE();
		helper = new PT_IL_SURR_VALUE_HELPER();
	}

	public PT_IL_SURR_VALUE getPT_IL_SURR_VALUE_BEAN() {
		return PT_IL_SURR_VALUE_BEAN;
	}

	public void setPT_IL_SURR_VALUE_BEAN(PT_IL_SURR_VALUE PT_IL_SURR_VALUE_BEAN) {
		this.PT_IL_SURR_VALUE_BEAN = PT_IL_SURR_VALUE_BEAN;
	}

	public List<PT_IL_SURR_VALUE> getDataList_PT_IL_SURR_VALUE() {
		return dataList_PT_IL_SURR_VALUE;
	}

	public void setDataListPT_IL_SURR_VALUE(
			List<PT_IL_SURR_VALUE> dataList_PT_IL_SURR_VALUE) {
		this.dataList_PT_IL_SURR_VALUE = dataList_PT_IL_SURR_VALUE;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				PT_IL_SURR_VALUE_BEAN = new PT_IL_SURR_VALUE();
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