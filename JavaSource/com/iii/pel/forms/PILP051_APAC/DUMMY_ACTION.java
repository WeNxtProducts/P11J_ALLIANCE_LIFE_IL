package com.iii.pel.forms.PILP051_APAC;

import java.util.ArrayList;
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

import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.P9ILPK_CLAIM;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private DUMMY DUMMY_BEAN;

	public PILP051_APAC_COMPOSITE_ACTION compositeAction;

	private DUMMY_HELPER helper;

	private HtmlOutputLabel COMP_UI_M_CLAIM_NO_FM_LABEL;

	private HtmlInputText COMP_UI_M_CLAIM_NO_FM;

	private HtmlOutputLabel COMP_UI_M_CLAIM_NO_TO_LABEL;

	private HtmlInputText COMP_UI_M_CLAIM_NO_TO;

	private HtmlOutputLabel COMP_UI_M_AS_ON_DT_LABEL;

	private HtmlCalendar COMP_UI_M_AS_ON_DT;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton comp_ui_m_but_process) {
		COMP_UI_M_BUT_PROCESS = comp_ui_m_but_process;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
	}

	public PILP051_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILP051_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public DUMMY_HELPER getHelper() {
		return helper;
	}

	public void setHelper(DUMMY_HELPER helper) {
		this.helper = helper;
	}

	public HtmlOutputLabel getCOMP_UI_M_AS_ON_DT_LABEL() {
		return COMP_UI_M_AS_ON_DT_LABEL;
	}

	public void setCOMP_UI_M_AS_ON_DT_LABEL(
			HtmlOutputLabel comp_ui_m_as_on_dt_label) {
		COMP_UI_M_AS_ON_DT_LABEL = comp_ui_m_as_on_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_AS_ON_DT() {
		return COMP_UI_M_AS_ON_DT;
	}

	public void setCOMP_UI_M_AS_ON_DT(HtmlCalendar comp_ui_m_as_on_dt) {
		COMP_UI_M_AS_ON_DT = comp_ui_m_as_on_dt;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_NO_FM_LABEL() {
		return COMP_UI_M_CLAIM_NO_FM_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_NO_FM_LABEL(
			HtmlOutputLabel comp_ui_m_claim_no_fm_label) {
		COMP_UI_M_CLAIM_NO_FM_LABEL = comp_ui_m_claim_no_fm_label;
	}

	public HtmlInputText getCOMP_UI_M_CLAIM_NO_FM() {
		return COMP_UI_M_CLAIM_NO_FM;
	}

	public void setCOMP_UI_M_CLAIM_NO_FM(HtmlInputText comp_ui_m_claim_no_fm) {
		COMP_UI_M_CLAIM_NO_FM = comp_ui_m_claim_no_fm;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_NO_TO_LABEL() {
		return COMP_UI_M_CLAIM_NO_TO_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_NO_TO_LABEL(
			HtmlOutputLabel comp_ui_m_claim_no_to_label) {
		COMP_UI_M_CLAIM_NO_TO_LABEL = comp_ui_m_claim_no_to_label;
	}

	public HtmlInputText getCOMP_UI_M_CLAIM_NO_TO() {
		return COMP_UI_M_CLAIM_NO_TO;
	}

	public void setCOMP_UI_M_CLAIM_NO_TO(HtmlInputText comp_ui_m_claim_no_to) {
		COMP_UI_M_CLAIM_NO_TO = comp_ui_m_claim_no_to;
	}

	public void saveRecord() {
		try {
			if (getDUMMY_BEAN().getROWID() != null) {
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static final String z_Constant = "zzzzzzzzzz";

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
					helper.whenCreateRecord(this);
					setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public List<LovBean> lovUI_M_CLAIM_NO_FM(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP051_APAC", "DUMMY",
					"M_CLAIM_NO_FM", null, null, null, null, null,
					(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovUI_M_CLAIM_NO_TO(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP051_APAC", "DUMMY",
					"M_CLAIM_NO_TO", null, null, null, null, null,
					(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public void validateUI_M_CLAIM_NO_FM(FacesContext fc,
			UIComponent component, Object value) {
		try {
			DUMMY_BEAN.setUI_M_CLAIM_NO_FM((String) value);
			helper.when_Validate_UI_M_CLAIM_NO_FM(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateUI_M_CLAIM_NO_TO(FacesContext fc,
			UIComponent component, Object value) {
		try {
			DUMMY_BEAN.setUI_M_CLAIM_NO_TO((String) value);
			helper.when_Validate_UI_M_CLAIM_NO_TO(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void actionListenerUI_M_CLAIM_NO_FM(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput htmlInputText = (UIInput) actionEvent.getComponent()
					.getParent();
			String inputValue = (String) htmlInputText.getSubmittedValue();
			if (inputValue.isEmpty()) {
				getCOMP_UI_M_CLAIM_NO_FM().setSubmittedValue("0");
				DUMMY_BEAN.setUI_M_CLAIM_NO_FM("0");
			} else {
				DUMMY_BEAN.setUI_M_CLAIM_NO_FM(inputValue);
				ErrorHelpUtil.validate(htmlInputText, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void actionListenerUI_M_CLAIM_NO_TO(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String claimNumFm = DUMMY_BEAN.getUI_M_CLAIM_NO_FM();
				if (!claimNumFm.trim().equals("0")) {
					getCOMP_UI_M_CLAIM_NO_TO().setSubmittedValue(claimNumFm);
					DUMMY_BEAN.setUI_M_CLAIM_NO_TO(claimNumFm);
				} else {
					getCOMP_UI_M_CLAIM_NO_TO().setSubmittedValue(z_Constant);
					DUMMY_BEAN.setUI_M_CLAIM_NO_TO(z_Constant);				}
			} else {
				DUMMY_BEAN.setUI_M_CLAIM_NO_TO(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public String whenButtonPressed() throws Exception {
		String outString = null;
		ArrayList<OracleParameter> outputList = null;
		try {

			P9ILPK_CLAIM P9ILPK_CLAIM_BEAN = new P9ILPK_CLAIM();
			outputList = P9ILPK_CLAIM_BEAN.L_FIB_BATCH_PROCESS(DUMMY_BEAN
					.getUI_M_CLAIM_NO_FM(), DUMMY_BEAN.getUI_M_CLAIM_NO_TO(),
					CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_AS_ON_DT()));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Process Sucessfully Completed");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,"Process Sucessfully Completed");
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,e.getMessage());
		}
		return outString;
	}
	
}