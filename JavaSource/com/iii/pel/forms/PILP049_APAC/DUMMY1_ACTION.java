package com.iii.pel.forms.PILP049_APAC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.pel.forms.PILP021.DUMMY;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_FM_FUND_CODE_LABEL;

	private HtmlInputText COMP_UI_M_FM_FUND_CODE;

	private HtmlOutputLabel COMP_UI_M_TO_FUND_CODE_LABEL;

	private HtmlInputText COMP_UI_M_TO_FUND_CODE;

	private HtmlOutputLabel COMP_UI_M_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_FM_DT;

	private HtmlOutputLabel COMP_UI_M_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_TO_DT;
	
	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	private DUMMY1 DUMMY1_BEAN;

	public PILP049_APAC_COMPOSITE_ACTION compositeAction;

	private DUMMY1_HELPER helper;

	public DUMMY1_ACTION() {

		DUMMY1_BEAN = new DUMMY1();
		helper = new DUMMY1_HELPER();
	}

	public DUMMY1 getDUMMY1_BEAN() {
		return DUMMY1_BEAN;
	}

	public void setDUMMY1_BEAN(DUMMY1 DUMMY1_BEAN) {
		this.DUMMY1_BEAN = DUMMY1_BEAN;
	}

	public HtmlOutputLabel getCOMP_UI_M_FM_FUND_CODE_LABEL() {
		return COMP_UI_M_FM_FUND_CODE_LABEL;
	}

	public void setCOMP_UI_M_FM_FUND_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_fm_fund_code_label) {
		COMP_UI_M_FM_FUND_CODE_LABEL = comp_ui_m_fm_fund_code_label;
	}

	public HtmlInputText getCOMP_UI_M_FM_FUND_CODE() {
		return COMP_UI_M_FM_FUND_CODE;
	}

	public void setCOMP_UI_M_FM_FUND_CODE(HtmlInputText comp_ui_m_fm_fund_code) {
		COMP_UI_M_FM_FUND_CODE = comp_ui_m_fm_fund_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_FUND_CODE_LABEL() {
		return COMP_UI_M_TO_FUND_CODE_LABEL;
	}

	public void setCOMP_UI_M_TO_FUND_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_to_fund_code_label) {
		COMP_UI_M_TO_FUND_CODE_LABEL = comp_ui_m_to_fund_code_label;
	}

	public HtmlInputText getCOMP_UI_M_TO_FUND_CODE() {
		return COMP_UI_M_TO_FUND_CODE;
	}

	public void setCOMP_UI_M_TO_FUND_CODE(HtmlInputText comp_ui_m_to_fund_code) {
		COMP_UI_M_TO_FUND_CODE = comp_ui_m_to_fund_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_FM_DT_LABEL() {
		return COMP_UI_M_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_FM_DT_LABEL(HtmlOutputLabel comp_ui_m_fm_dt_label) {
		COMP_UI_M_FM_DT_LABEL = comp_ui_m_fm_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_FM_DT() {
		return COMP_UI_M_FM_DT;
	}

	public void setCOMP_UI_M_FM_DT(HtmlCalendar comp_ui_m_fm_dt) {
		COMP_UI_M_FM_DT = comp_ui_m_fm_dt;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_DT_LABEL() {
		return COMP_UI_M_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_TO_DT_LABEL(HtmlOutputLabel comp_ui_m_to_dt_label) {
		COMP_UI_M_TO_DT_LABEL = comp_ui_m_to_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_TO_DT() {
		return COMP_UI_M_TO_DT;
	}

	public void setCOMP_UI_M_TO_DT(HtmlCalendar comp_ui_m_to_dt) {
		COMP_UI_M_TO_DT = comp_ui_m_to_dt;
	}

	public PILP049_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILP049_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public DUMMY1_HELPER getHelper() {
		return helper;
	}

	public void setHelper(DUMMY1_HELPER helper) {
		this.helper = helper;
	}

	public void saveRecord() {
		if (getDUMMY1_BEAN().getROWID() != null) {

		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.whenCreateRecord(DUMMY1_BEAN);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void validateUI_M_FM_FUND_CODE(ActionEvent event) {
		try {
			UIInput input = (UIInput) event.getComponent().getParent();
			String value = (String) input.getSubmittedValue();
			if (value.isEmpty()) {
				COMP_UI_M_FM_FUND_CODE.setSubmittedValue("0");
				COMP_UI_M_TO_FUND_CODE.setSubmittedValue("zzzzzzzzzzzzzzzzzzzzzz");
			} else {
				COMP_UI_M_FM_FUND_CODE.setSubmittedValue(value);
				COMP_UI_M_TO_FUND_CODE.setSubmittedValue(value);
			}
			ErrorHelpUtil.validate(input, getErrorMap());
			

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_FM_FUND_CODE", e.getMessage());
		}
	}

	public void validateUI_M_TO_FUND_CODE(ActionEvent event) {
		try {
			UIInput input = (UIInput) event.getComponent().getParent();
			String value = (String) input.getSubmittedValue();
			if (value.isEmpty()) {
				COMP_UI_M_TO_FUND_CODE
						.setSubmittedValue("zzzzzzzzzzzzzzzzzzzzzz");
			} else {
				COMP_UI_M_TO_FUND_CODE.setSubmittedValue(value);
			}
			ErrorHelpUtil.validate(input, getErrorMap());

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_FM_FUND_CODE", e.getMessage());
		}
	}

	public void validateUI_M_FM_DT(FacesContext context, UIComponent component,
			Object value) {
		DUMMY1_BEAN.setUI_M_FM_DT((Date) value);
		try {
			helper.validateUI_M_FM_DT(DUMMY1_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateUI_M_TO_DT(FacesContext context, UIComponent component,
			Object value) {
		DUMMY1_BEAN.setUI_M_TO_DT((Date) value);
		try {
			helper.validateUI_M_TO_DT(DUMMY1_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public List<LovBean> lovM_FUND_CODE_FM(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP049_APAC",
					"DUMMY", "M_FUND_CODE_FM",
					null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton comp_ui_m_but_process) {
		COMP_UI_M_BUT_PROCESS = comp_ui_m_but_process;
	}
	

	public String processButtonAction() {
		String message = null;
		DUMMY1_HELPER helper = new DUMMY1_HELPER();
		try {
			 
			   helper.UNIT_PRICE(DUMMY1_BEAN.getUI_M_FM_FUND_CODE(),
					   		DUMMY1_BEAN.getUI_M_TO_FUND_CODE(),
					   		DUMMY1_BEAN.getUI_M_FM_DT(),
					   		DUMMY1_BEAN.getUI_M_TO_DT());
			message = Messages.getString("messageProperties","errorPanel$message$process$complete");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put("processButtonAction", message);
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
			
		}

		return null;
	}

}