package com.iii.pel.forms.PILT021;

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

public class CTRL1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_ANNOTATION_LABEL;

	private HtmlInputText COMP_UI_M_ANNOTATION;

	private CTRL1 CTRL1_BEAN;

	public PILT021_COMPOSITE_ACTION compositeAction;

	private CTRL1_HELPER helper;



	public CTRL1_ACTION(){


		CTRL1_BEAN = new CTRL1();
		helper = new CTRL1_HELPER();
	}

	public HtmlOutputLabel getCOMP_UI_M_ANNOTATION_LABEL() {
		return COMP_UI_M_ANNOTATION_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANNOTATION() {
		return COMP_UI_M_ANNOTATION;
	}

	public void setCOMP_UI_M_ANNOTATION_LABEL(HtmlOutputLabel COMP_UI_M_ANNOTATION_LABEL) {
		this.COMP_UI_M_ANNOTATION_LABEL = COMP_UI_M_ANNOTATION_LABEL;
	}

	public void setCOMP_UI_M_ANNOTATION(HtmlInputText COMP_UI_M_ANNOTATION) {
		this.COMP_UI_M_ANNOTATION = COMP_UI_M_ANNOTATION;
	}

	public CTRL1 getCTRL1_BEAN() {
		return CTRL1_BEAN;
	}

	public void setCTRL1_BEAN(CTRL1 CTRL1_BEAN) {
		this.CTRL1_BEAN = CTRL1_BEAN;
	}
	public void saveRecord() {
		try {
			if (getCTRL1_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getCTRL1_BEAN(), CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getCTRL1_BEAN(), CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
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
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad",e.getMessage());
		}
	}

}
