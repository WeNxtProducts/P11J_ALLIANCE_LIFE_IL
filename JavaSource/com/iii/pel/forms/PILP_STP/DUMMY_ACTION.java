package com.iii.pel.forms.PILP_STP;

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

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_PROD_FM_LABEL;
	private HtmlInputText COMP_UI_M_PROD_FM;
	private HtmlInputText COMP_UI_M_PROD_FM_DESC;
	private HtmlOutputLabel COMP_UI_M_PROD_TO_LABEL;
	private HtmlInputText COMP_UI_M_PROD_TO;
	private HtmlInputText COMP_UI_M_PROD_TO_DESC;
	private HtmlOutputLabel COMP_UI_M_FM_DT_LABEL;
	private HtmlCalendar COMP_UI_M_FM_DT;
	private HtmlOutputLabel COMP_UI_M_TO_DT_LABEL;
	private HtmlCalendar COMP_UI_M_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;
	private HtmlCommandButton COMP_UI_M_BUT_VIEWLOG;
	private HtmlCommandButton COMP_UI_M_BUT_VIE_PROCESS;

	private DUMMY DUMMY_BEAN;
	DUMMY_DELEGATE delegate = null;
	DUMMY_HELPER helper = null;
	private List<DUMMY> suggestionList;

	public PILP_STP_COMPOSITE_ACTION compositeAction;

	public DUMMY_ACTION() {
		try {
			DUMMY_BEAN = new DUMMY();
			delegate = new DUMMY_DELEGATE();
			helper = new DUMMY_HELPER();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Constructor", e.getMessage());
		}
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public List<DUMMY> getLovForFM_TO_PROD_CODE(Object obj) {
		String filterString = obj.toString().trim();
		System.out.println("Fetching List");
		suggestionList = delegate.getListForFM_TO_PROD_CODE(filterString);
		return suggestionList;
	}

	public void UI_M_PROD_FM_WHEN_VALIDATE_ITEM(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value.isEmpty()) {
			COMP_UI_M_PROD_FM.setSubmittedValue("0");
		} else {
			COMP_UI_M_PROD_FM.setSubmittedValue(value);
		}
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void validateUI_M_PROD_FM(FacesContext context,
			UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_PROD_FM((String) value);
		try {
			if (!(DUMMY_BEAN.getUI_M_PROD_FM().equals("0"))) {
				DUMMY_BEAN.setUI_M_PROD_FM_DESC(helper
						.ValidateUI_M_PROD(DUMMY_BEAN.getUI_M_PROD_FM()));
			}
			COMP_UI_M_PROD_FM_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void UI_M_PROD_TO_WHEN_VALIDATE_ITEM(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value.isEmpty()) {
			COMP_UI_M_PROD_TO.setSubmittedValue("zzzzzzzzzzzzzzzzzzzzzz");
		} else {
			COMP_UI_M_PROD_TO.setSubmittedValue(value);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateUI_M_PROD_TO(FacesContext context,
			UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_PROD_TO((String) value);
		try {
			if (!(DUMMY_BEAN.getUI_M_PROD_TO().equals("zzzzzzzzzzzzzzzzzzzzzz"))) {
				DUMMY_BEAN.setUI_M_PROD_TO_DESC(helper
						.ValidateUI_M_PROD(DUMMY_BEAN.getUI_M_PROD_TO()));
			}
			COMP_UI_M_PROD_TO_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateUI_M_FM_DT(FacesContext context, UIComponent component,
			Object value) {
		try {
			DUMMY_BEAN.setUI_M_FM_DT((Date) value);
			helper.validateUI_M_FM_DT(DUMMY_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateUI_M_TO_DT(FacesContext context, UIComponent component,
			Object value) {
		try {
			DUMMY_BEAN.setUI_M_TO_DT((Date) value);
			helper.validateUI_M_TO_DT(DUMMY_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public String processButtonAction() {
		String message = null;
		try {
			/*
			 * helper.BATCH_APPROVAL(DUMMY_BEAN.getUI_M_PROD_FM(),
			 * DUMMY_BEAN.getUI_M_PROD_TO(), DUMMY_BEAN.getUI_M_FM_PROP_NO(),
			 * DUMMY_BEAN.getUI_M_TO_PROP_NO(), DUMMY_BEAN.getUI_M_FM_DT(),
			 * DUMMY_BEAN.getUI_M_TO_DT(),new CommonUtils().getCurrentDate());
			 */
			message = Messages.getString("messageProperties",
					"errorPanel$message$process$complete");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("processButtonAction", message);

		} catch (Exception e1) {
			e1.printStackTrace();

		}

		return null;
	}

	public String processButAction() {
		String outCome = null;

		try {
			delegate.P_APPRV_PROCESSING(DUMMY_BEAN.getUI_M_PROD_FM(),
					DUMMY_BEAN.getUI_M_PROD_TO(), DUMMY_BEAN.getUI_M_FM_DT(),
					DUMMY_BEAN.getUI_M_TO_DT());

			getWarningMap().put("processButAction", "Processed Successfully.");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Processed Successfully.");

			outCome = "PILP_STP_VIEW_LOG";

		} catch (Exception e1) {
			e1.printStackTrace();

		}

		return outCome;
	}

	public String viewLogAction() {
		String outCome = null;
		try {
			outCome = "PILP_STP_VIEW_LOG";

		} catch (Exception e1) {
			e1.printStackTrace();

		}

		return outCome;
	}

	public String viewProcessedAction() {
		String outCome = null;
		try {
			outCome = "PILP_STP_VIEW_PROCESS";

		} catch (Exception e1) {
			e1.printStackTrace();

		}

		return outCome;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.whenCreateRecord(DUMMY_BEAN);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void UI_M_PROD_FMListener(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value.isEmpty()) {
			COMP_UI_M_PROD_FM.setSubmittedValue("0");
		} else {
			COMP_UI_M_PROD_FM.setSubmittedValue(value);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void UI_M_PROD_TOListener(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value.isEmpty()) {
			COMP_UI_M_PROD_TO.setSubmittedValue("zzzzzzzzzzzzzzzzzzzzzz");
		} else {
			COMP_UI_M_PROD_TO.setSubmittedValue(value);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_FM_LABEL() {
		return COMP_UI_M_PROD_FM_LABEL;
	}

	public void setCOMP_UI_M_PROD_FM_LABEL(
			HtmlOutputLabel comp_ui_m_prod_fm_label) {
		COMP_UI_M_PROD_FM_LABEL = comp_ui_m_prod_fm_label;
	}

	public HtmlInputText getCOMP_UI_M_PROD_FM() {
		return COMP_UI_M_PROD_FM;
	}

	public void setCOMP_UI_M_PROD_FM(HtmlInputText comp_ui_m_prod_fm) {
		COMP_UI_M_PROD_FM = comp_ui_m_prod_fm;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_TO_LABEL() {
		return COMP_UI_M_PROD_TO_LABEL;
	}

	public void setCOMP_UI_M_PROD_TO_LABEL(
			HtmlOutputLabel comp_ui_m_prod_to_label) {
		COMP_UI_M_PROD_TO_LABEL = comp_ui_m_prod_to_label;
	}

	public HtmlInputText getCOMP_UI_M_PROD_TO() {
		return COMP_UI_M_PROD_TO;
	}

	public void setCOMP_UI_M_PROD_TO(HtmlInputText comp_ui_m_prod_to) {
		COMP_UI_M_PROD_TO = comp_ui_m_prod_to;
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

	public HtmlInputText getCOMP_UI_M_PROD_FM_DESC() {
		return COMP_UI_M_PROD_FM_DESC;
	}

	public void setCOMP_UI_M_PROD_FM_DESC(HtmlInputText comp_ui_m_prod_fm_desc) {
		COMP_UI_M_PROD_FM_DESC = comp_ui_m_prod_fm_desc;
	}

	public HtmlInputText getCOMP_UI_M_PROD_TO_DESC() {
		return COMP_UI_M_PROD_TO_DESC;
	}

	public void setCOMP_UI_M_PROD_TO_DESC(HtmlInputText comp_ui_m_prod_to_desc) {
		COMP_UI_M_PROD_TO_DESC = comp_ui_m_prod_to_desc;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton comp_ui_m_but_process) {
		COMP_UI_M_BUT_PROCESS = comp_ui_m_but_process;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_VIEWLOG() {
		return COMP_UI_M_BUT_VIEWLOG;
	}

	public void setCOMP_UI_M_BUT_VIEWLOG(HtmlCommandButton comp_ui_m_but_viewlog) {
		COMP_UI_M_BUT_VIEWLOG = comp_ui_m_but_viewlog;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_VIE_PROCESS() {
		return COMP_UI_M_BUT_VIE_PROCESS;
	}

	public void setCOMP_UI_M_BUT_VIE_PROCESS(
			HtmlCommandButton comp_ui_m_but_vie_process) {
		COMP_UI_M_BUT_VIE_PROCESS = comp_ui_m_but_vie_process;
	}

}
