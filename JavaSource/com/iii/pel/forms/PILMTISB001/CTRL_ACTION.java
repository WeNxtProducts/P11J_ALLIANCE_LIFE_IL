package com.iii.pel.forms.PILMTISB001;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class CTRL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_USER_DISP_LABEL;

	private HtmlInputText COMP_UI_M_USER_DISP;

	private HtmlOutputLabel COMP_UI_M_CURSOR_HINT_REC;

	private CTRL CTRL_BEAN;

	public PILMTISB001_COMPOSITE_ACTION compositeAction;

	private CTRL_HELPER helper;

	public CTRL_ACTION() {

		CTRL_BEAN = new CTRL();
		helper = new CTRL_HELPER();
	}

	public HtmlOutputLabel getCOMP_UI_M_USER_DISP_LABEL() {
		return COMP_UI_M_USER_DISP_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_USER_DISP() {
		return COMP_UI_M_USER_DISP;
	}

	public void setCOMP_UI_M_USER_DISP_LABEL(
			HtmlOutputLabel COMP_UI_M_USER_DISP_LABEL) {
		this.COMP_UI_M_USER_DISP_LABEL = COMP_UI_M_USER_DISP_LABEL;
	}

	public void setCOMP_UI_M_USER_DISP(HtmlInputText COMP_UI_M_USER_DISP) {
		this.COMP_UI_M_USER_DISP = COMP_UI_M_USER_DISP;
	}

	public HtmlOutputLabel getCOMP_UI_M_CURSOR_HINT_REC() {
		return COMP_UI_M_CURSOR_HINT_REC;
	}

	public void setCOMP_UI_M_CURSOR_HINT_REC(
			HtmlOutputLabel COMP_UI_M_CURSOR_HINT_REC) {
		this.COMP_UI_M_CURSOR_HINT_REC = COMP_UI_M_CURSOR_HINT_REC;
	}

	public CTRL getCTRL_BEAN() {
		return CTRL_BEAN;
	}

	public void setCTRL_BEAN(CTRL CTRL_BEAN) {
		this.CTRL_BEAN = CTRL_BEAN;
	}

	public void saveRecord() {
		try {
			if (getCTRL_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getCTRL_BEAN(), CommonUtils
						.getConnection());
			} else {
				new CRUDHandler().executeInsert(getCTRL_BEAN(), CommonUtils
						.getConnection());
			}
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
