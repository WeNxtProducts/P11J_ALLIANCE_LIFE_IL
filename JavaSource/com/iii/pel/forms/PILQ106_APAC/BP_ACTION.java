package com.iii.pel.forms.PILQ106_APAC;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class BP_ACTION extends CommonAction {

	private BP BP_BEAN;
	private HtmlOutputLabel UI_B_POL_NO;
	private HtmlOutputLabel UI_B_CUST_CODE;
	private HtmlOutputLabel UI_B_PROD_CODE;

	public PILQ106_APAC_COMPOSITE_ACTION compositeAction;

	private BP_HELPER helper;

	public BP_ACTION() {

		BP_BEAN = new BP();
		helper = new BP_HELPER();
	}

	public BP getBP_BEAN() {
		return BP_BEAN;
	}

	public void setBP_BEAN(BP BP_BEAN) {
		this.BP_BEAN = BP_BEAN;
	}

	public void saveRecord() {
		try {
			if (getBP_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getBP_BEAN(), CommonUtils
						.getConnection());
			} else {
				new CRUDHandler().executeInsert(getBP_BEAN(), CommonUtils
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

	public HtmlOutputLabel getUI_B_POL_NO() {
		return UI_B_POL_NO;
	}

	public void setUI_B_POL_NO(HtmlOutputLabel ui_b_pol_no) {
		UI_B_POL_NO = ui_b_pol_no;
	}

	public HtmlOutputLabel getUI_B_CUST_CODE() {
		return UI_B_CUST_CODE;
	}

	public void setUI_B_CUST_CODE(HtmlOutputLabel ui_b_cust_code) {
		UI_B_CUST_CODE = ui_b_cust_code;
	}

	public HtmlOutputLabel getUI_B_PROD_CODE() {
		return UI_B_PROD_CODE;
	}

	public void setUI_B_PROD_CODE(HtmlOutputLabel ui_b_prod_code) {
		UI_B_PROD_CODE = ui_b_prod_code;
	}

}
