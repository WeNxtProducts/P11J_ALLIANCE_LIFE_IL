package com.iii.pel.forms.PM092_A;

import java.util.Date;

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

public class PM_AGENT_CONTEST_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ACH_CODE_LABEL;
	private HtmlOutputLabel COMP_ACH_DESC_LABEL;
	private HtmlOutputLabel COMP_ACH_SHORT_DESC_LABEL;
	private HtmlOutputLabel COMP_ACH_LONG_DESC_LABEL;
	private HtmlOutputLabel COMP_ACH_LEVEL_LABEL;
	private HtmlOutputLabel COMP_ACH_EFF_FM_DT_LABEL;
	private HtmlOutputLabel COMP_ACH_EFF_TO_DT_LABEL;
	private HtmlOutputLabel COMP_ACH_BL_DESC_LABEL;
	private HtmlOutputLabel COMP_ACH_BL_SHORT_DESC_LABEL;
	private HtmlOutputLabel COMP_ACH_BL_LONG_DESC_LABEL;

	private HtmlInputText COMP_ACH_CODE;
	private HtmlInputText COMP_ACH_DESC;
	private HtmlInputText COMP_ACH_SHORT_DESC;
	private HtmlInputText COMP_ACH_LONG_DESC;
	private HtmlInputText COMP_ACH_LEVEL;
	private HtmlInputText COMP_ACH_BL_DESC;
	private HtmlInputText COMP_ACH_BL_SHORT_DESC;
	private HtmlInputText COMP_ACH_BL_LONG_DESC;

	private HtmlCalendar COMP_ACH_EFF_FM_DT;
	private HtmlCalendar COMP_ACH_EFF_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_EDI_ACH_LONG_DESC;
	private HtmlCommandButton COMP_UI_M_BUT_BILINGUAL;

	private PM_AGENT_CONTEST_HDR PM_AGENT_CONTEST_HDR_BEAN;

	public PM092_A_COMPOSITE_ACTION compositeAction;

	public PM_AGENT_CONTEST_HDR_HELPER helper;

	public PM_AGENT_CONTEST_HDR_ACTION() {
		PM_AGENT_CONTEST_HDR_BEAN = new PM_AGENT_CONTEST_HDR();
		helper = new PM_AGENT_CONTEST_HDR_HELPER();
	}

	public HtmlOutputLabel getCOMP_ACH_CODE_LABEL() {
		return COMP_ACH_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACH_CODE() {
		return COMP_ACH_CODE;
	}

	public void setCOMP_ACH_CODE_LABEL(HtmlOutputLabel COMP_ACH_CODE_LABEL) {
		this.COMP_ACH_CODE_LABEL = COMP_ACH_CODE_LABEL;
	}

	public void setCOMP_ACH_CODE(HtmlInputText COMP_ACH_CODE) {
		this.COMP_ACH_CODE = COMP_ACH_CODE;
	}

	public HtmlOutputLabel getCOMP_ACH_DESC_LABEL() {
		return COMP_ACH_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ACH_DESC() {
		return COMP_ACH_DESC;
	}

	public void setCOMP_ACH_DESC_LABEL(HtmlOutputLabel COMP_ACH_DESC_LABEL) {
		this.COMP_ACH_DESC_LABEL = COMP_ACH_DESC_LABEL;
	}

	public void setCOMP_ACH_DESC(HtmlInputText COMP_ACH_DESC) {
		this.COMP_ACH_DESC = COMP_ACH_DESC;
	}

	public HtmlOutputLabel getCOMP_ACH_SHORT_DESC_LABEL() {
		return COMP_ACH_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ACH_SHORT_DESC() {
		return COMP_ACH_SHORT_DESC;
	}

	public void setCOMP_ACH_SHORT_DESC_LABEL(
			HtmlOutputLabel COMP_ACH_SHORT_DESC_LABEL) {
		this.COMP_ACH_SHORT_DESC_LABEL = COMP_ACH_SHORT_DESC_LABEL;
	}

	public void setCOMP_ACH_SHORT_DESC(HtmlInputText COMP_ACH_SHORT_DESC) {
		this.COMP_ACH_SHORT_DESC = COMP_ACH_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_ACH_LONG_DESC_LABEL() {
		return COMP_ACH_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ACH_LONG_DESC() {
		return COMP_ACH_LONG_DESC;
	}

	public void setCOMP_ACH_LONG_DESC_LABEL(
			HtmlOutputLabel COMP_ACH_LONG_DESC_LABEL) {
		this.COMP_ACH_LONG_DESC_LABEL = COMP_ACH_LONG_DESC_LABEL;
	}

	public void setCOMP_ACH_LONG_DESC(HtmlInputText COMP_ACH_LONG_DESC) {
		this.COMP_ACH_LONG_DESC = COMP_ACH_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_ACH_LEVEL_LABEL() {
		return COMP_ACH_LEVEL_LABEL;
	}

	public HtmlInputText getCOMP_ACH_LEVEL() {
		return COMP_ACH_LEVEL;
	}

	public void setCOMP_ACH_LEVEL_LABEL(HtmlOutputLabel COMP_ACH_LEVEL_LABEL) {
		this.COMP_ACH_LEVEL_LABEL = COMP_ACH_LEVEL_LABEL;
	}

	public void setCOMP_ACH_LEVEL(HtmlInputText COMP_ACH_LEVEL) {
		this.COMP_ACH_LEVEL = COMP_ACH_LEVEL;
	}

	public HtmlOutputLabel getCOMP_ACH_EFF_FM_DT_LABEL() {
		return COMP_ACH_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ACH_EFF_FM_DT() {
		return COMP_ACH_EFF_FM_DT;
	}

	public void setCOMP_ACH_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_ACH_EFF_FM_DT_LABEL) {
		this.COMP_ACH_EFF_FM_DT_LABEL = COMP_ACH_EFF_FM_DT_LABEL;
	}

	public void setCOMP_ACH_EFF_FM_DT(HtmlCalendar COMP_ACH_EFF_FM_DT) {
		this.COMP_ACH_EFF_FM_DT = COMP_ACH_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_ACH_EFF_TO_DT_LABEL() {
		return COMP_ACH_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ACH_EFF_TO_DT() {
		return COMP_ACH_EFF_TO_DT;
	}

	public void setCOMP_ACH_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_ACH_EFF_TO_DT_LABEL) {
		this.COMP_ACH_EFF_TO_DT_LABEL = COMP_ACH_EFF_TO_DT_LABEL;
	}

	public void setCOMP_ACH_EFF_TO_DT(HtmlCalendar COMP_ACH_EFF_TO_DT) {
		this.COMP_ACH_EFF_TO_DT = COMP_ACH_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_ACH_BL_DESC_LABEL() {
		return COMP_ACH_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ACH_BL_DESC() {
		return COMP_ACH_BL_DESC;
	}

	public void setCOMP_ACH_BL_DESC_LABEL(HtmlOutputLabel COMP_ACH_BL_DESC_LABEL) {
		this.COMP_ACH_BL_DESC_LABEL = COMP_ACH_BL_DESC_LABEL;
	}

	public void setCOMP_ACH_BL_DESC(HtmlInputText COMP_ACH_BL_DESC) {
		this.COMP_ACH_BL_DESC = COMP_ACH_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_ACH_BL_SHORT_DESC_LABEL() {
		return COMP_ACH_BL_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ACH_BL_SHORT_DESC() {
		return COMP_ACH_BL_SHORT_DESC;
	}

	public void setCOMP_ACH_BL_SHORT_DESC_LABEL(
			HtmlOutputLabel COMP_ACH_BL_SHORT_DESC_LABEL) {
		this.COMP_ACH_BL_SHORT_DESC_LABEL = COMP_ACH_BL_SHORT_DESC_LABEL;
	}

	public void setCOMP_ACH_BL_SHORT_DESC(HtmlInputText COMP_ACH_BL_SHORT_DESC) {
		this.COMP_ACH_BL_SHORT_DESC = COMP_ACH_BL_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_ACH_BL_LONG_DESC_LABEL() {
		return COMP_ACH_BL_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ACH_BL_LONG_DESC() {
		return COMP_ACH_BL_LONG_DESC;
	}

	public void setCOMP_ACH_BL_LONG_DESC_LABEL(
			HtmlOutputLabel COMP_ACH_BL_LONG_DESC_LABEL) {
		this.COMP_ACH_BL_LONG_DESC_LABEL = COMP_ACH_BL_LONG_DESC_LABEL;
	}

	public void setCOMP_ACH_BL_LONG_DESC(HtmlInputText COMP_ACH_BL_LONG_DESC) {
		this.COMP_ACH_BL_LONG_DESC = COMP_ACH_BL_LONG_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDI_ACH_LONG_DESC() {
		return COMP_UI_M_BUT_EDI_ACH_LONG_DESC;
	}

	public void setCOMP_UI_M_BUT_EDI_ACH_LONG_DESC(
			HtmlCommandButton COMP_UI_M_BUT_EDI_ACH_LONG_DESC) {
		this.COMP_UI_M_BUT_EDI_ACH_LONG_DESC = COMP_UI_M_BUT_EDI_ACH_LONG_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BILINGUAL() {
		return COMP_UI_M_BUT_BILINGUAL;
	}

	public void setCOMP_UI_M_BUT_BILINGUAL(
			HtmlCommandButton COMP_UI_M_BUT_BILINGUAL) {
		this.COMP_UI_M_BUT_BILINGUAL = COMP_UI_M_BUT_BILINGUAL;
	}

	public PM_AGENT_CONTEST_HDR getPM_AGENT_CONTEST_HDR_BEAN() {
		return PM_AGENT_CONTEST_HDR_BEAN;
	}

	public void setPM_AGENT_CONTEST_HDR_BEAN(
			PM_AGENT_CONTEST_HDR PM_AGENT_CONTEST_HDR_BEAN) {
		this.PM_AGENT_CONTEST_HDR_BEAN = PM_AGENT_CONTEST_HDR_BEAN;
	}

	public String saveButtonClick() {
		String returnString = "";
		String message = null;
		PM_AGENT_CONTEST_HDR_DELEGATE delegate = new PM_AGENT_CONTEST_HDR_DELEGATE();
		if (PM_AGENT_CONTEST_HDR_BEAN.getROWID() == null) {
			message = Messages.getString("messageProperties",
					"errorPanel$message$save");
		} else {
			message = Messages.getString("messageProperties",
					"errorPanel$message$update");
		}
		delegate.saveRecord(this.PM_AGENT_CONTEST_HDR_BEAN, true);
		if (message != null) {
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					message);
		}
		return returnString;
	}

	public String saveNextButtonClick() {
		String returnString = "";
		String message = null;
		boolean result = false;
		PM_AGENT_CONTEST_HDR_DELEGATE delegate = new PM_AGENT_CONTEST_HDR_DELEGATE();

		if (PM_AGENT_CONTEST_HDR_BEAN.getROWID() == null) {
			message = Messages.getString("messageProperties",
					"errorPanel$message$save");
		} else {
			message = Messages.getString("messageProperties",
					"errorPanel$message$update");
		}

		result = delegate.saveRecord(this.PM_AGENT_CONTEST_HDR_BEAN, true);

		if (message != null) {
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
		}

		populateBlockPM_AGENT_CONTEST_DTL();
		if (result) {
			returnString = "GO_TO_PM092_A_PM_AGENT_CONTEST_DTL";
		}
		return returnString;
	}

	public String deleteButtonClick() {
		String returnString = "";
		boolean recordDeletedFlag = false;
		String message = null;
		deleteBlockPM_AGENT_CONTEST_APPL_RANK();
		deleteBlockPM_AGENT_CONTEST_AWARD();
		deleteBlockPM_AGENT_CONTEST_DTL();
		PM_AGENT_CONTEST_HDR_DELEGATE delegate = new PM_AGENT_CONTEST_HDR_DELEGATE();
		PM092_A_COMPOSITE_ACTION compositeAction = (PM092_A_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		helper.pmAgentContestHdrPreDelete(compositeAction);
		recordDeletedFlag = delegate.deleteRecord(
				this.PM_AGENT_CONTEST_HDR_BEAN, false);
		PM_AGENT_CONTEST_HDR_BEAN = new PM_AGENT_CONTEST_HDR();

		if (recordDeletedFlag) {
			message = Messages.getString("messageProperties",
					"errorPanel$message$delete");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
		}

		return returnString;
	}

	public String nextPageButtonClick() {
		String returnString = "";
		PM_AGENT_CONTEST_HDR_DELEGATE delegate = new PM_AGENT_CONTEST_HDR_DELEGATE();
		delegate.saveRecord(this.PM_AGENT_CONTEST_HDR_BEAN, false);
		populateBlockPM_AGENT_CONTEST_DTL();
		returnString = "GO_TO_PM092_A_PM_AGENT_CONTEST_DTL";
		return returnString;
	}

	public void populateBlockPM_AGENT_CONTEST_DTL() {
		String mappedBeanName = "PM092_A_COMPOSITE_ACTION";
		PM_AGENT_CONTEST_HDR_DELEGATE delegate = new PM_AGENT_CONTEST_HDR_DELEGATE();
		CommonUtils utility = new CommonUtils();
		PM092_A_COMPOSITE_ACTION compositeActionBean = (PM092_A_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		compositeActionBean.getPM_AGENT_CONTEST_DTL_ACTION_BEAN()
				.setPM_AGENT_CONTEST_DTL_BEAN(
						delegate.getBlockDataForPM_AGENT_CONTEST_DTL());

	}

	public boolean deleteBlockPM_AGENT_CONTEST_DTL() {
		boolean isdeleted = false;
		PM_AGENT_CONTEST_HDR_DELEGATE delegate = new PM_AGENT_CONTEST_HDR_DELEGATE();
		isdeleted = delegate.deleteRecordPM_AGENT_CONTEST_DTL(false);
		return isdeleted;
	}

	public boolean deleteBlockPM_AGENT_CONTEST_APPL_RANK() {
		boolean isdeleted = false;
		PM_AGENT_CONTEST_HDR_DELEGATE delegate = new PM_AGENT_CONTEST_HDR_DELEGATE();
		isdeleted = delegate.deleteRecordPM_AGENT_CONTEST_APPL_RANK(false);
		return isdeleted;
	}

	public boolean deleteBlockPM_AGENT_CONTEST_AWARD() {
		boolean isdeleted = false;
		PM_AGENT_CONTEST_HDR_DELEGATE delegate = new PM_AGENT_CONTEST_HDR_DELEGATE();
		isdeleted = delegate.deleteRecordPM_AGENT_CONTEST_AWARD(false);
		return isdeleted;
	}

	/*
	 * For Error Messages.
	 */
	public void setErrorMessagesInMap(ActionEvent event) {
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}

	/*
	 * Triggers Conversion.
	 */
	/**
	 * Validate Contest Code (ACH_CODE) for duplicate records.
	 */
	public void validateACH_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		UIInput input = (UIInput) component;
		String ACH_CODE_STRING = (String) input.getSubmittedValue();

		if (PM_AGENT_CONTEST_HDR_BEAN.getROWID() == null) {
			helper.ACH_CODE_WHEN_VALIDATE_ITEM(ACH_CODE_STRING);
		}
	}

	/**
	 * Setting the value in bean.
	 * 
	 * @param actionEvent
	 */
	public void validateACH_DESC(ActionEvent actionEvent) {
		HtmlInputText htmlInputText = (HtmlInputText) actionEvent
				.getComponent().getParent();
		String ACH_DESC_STRING = htmlInputText.getSubmittedValue().toString();
		if (ACH_DESC_STRING != null) {

			PM_AGENT_CONTEST_HDR_BEAN.setACH_DESC(ACH_DESC_STRING);
		}
		helper.achDescWhenValidateItem(PM_AGENT_CONTEST_HDR_BEAN);
		getCOMP_ACH_SHORT_DESC().resetValue();
	}

	public void validateACH_BL_DESC(ActionEvent event){
		getCurrentValue(event);
		HtmlInputText htmlInputText = (HtmlInputText) event.getComponent().getParent();
		String ACH_BL_DESC_STRING = htmlInputText.getSubmittedValue().toString();
		PM_AGENT_CONTEST_HDR_HELPER helper = new PM_AGENT_CONTEST_HDR_HELPER();
		if(ACH_BL_DESC_STRING!=null){
			PM_AGENT_CONTEST_HDR_BEAN.setACH_BL_DESC(ACH_BL_DESC_STRING);
		}
		helper.achBlDescWhenValidateItem(PM_AGENT_CONTEST_HDR_BEAN);
		getCOMP_ACH_BL_SHORT_DESC().resetValue();

	}		
	/**
	 * Setting the Short Desc.
	 */
	public void validateACH_SHORT_DESC(ActionEvent actionEvent) {
		HtmlInputText htmlInputText = (HtmlInputText) actionEvent
				.getComponent().getParent();
		String ACH_SHORT_DESC_STRING = htmlInputText.getSubmittedValue()
				.toString();
		if (ACH_SHORT_DESC_STRING != null) {
			PM_AGENT_CONTEST_HDR_BEAN.setACH_SHORT_DESC(ACH_SHORT_DESC_STRING);
		}
	}

	public void actionlistenervalueBLDesc(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		PM_AGENT_CONTEST_HDR_BEAN.setACH_BL_DESC(value);
	}

	public void actionlistenervalueBLShortDesc(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		PM_AGENT_CONTEST_HDR_BEAN.setACH_BL_SHORT_DESC(value);
	}

	public void actionlistenervalueBLLongDesc(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		PM_AGENT_CONTEST_HDR_BEAN.setACH_BL_LONG_DESC(value);
	}

	/**
	 * Validate Contest Level for correctness of values.
	 */
	public void validateACH_LEVEL(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		UIInput input = (UIInput) component;
		String ACH_LEVEL_STRING = (String) input.getSubmittedValue();
		helper.ACH_LEVEL_WHEN_VALIDATE_ITEM(ACH_LEVEL_STRING);
	}

	/**
	 * Effective From Date
	 */
	public void validateACH_EFF_FM_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		Date fromDate = (Date) value;
		getPM_AGENT_CONTEST_HDR_BEAN().setACH_EFF_FM_DT(fromDate);
		helper.ACH_EFF_FM_DT_WHEN_VALIDATE_ITEM(fromDate, this);
	}

	/**
	 * Effective To Date
	 */
	public void validateACH_EFF_TO_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		Date toDate = (Date) value;
		getPM_AGENT_CONTEST_HDR_BEAN().setACH_EFF_TO_DT(toDate);
		helper.ACH_EFF_TO_DT_WHEN_VALIDATE_ITEM(toDate, this);
	}

	/**
	 * Implementation of Tool Bar Functionalities.
	 */
	public String saveNextAction() {
		saveButtonClick();
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value = pm092_a_composite_action.goToPM_AGENT_CONTEST_DTL();
		pm092_a_composite_action.getTabbedBar().gotoNextTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(2);
		return value;
	}

	public String nextIconAction() {
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value = pm092_a_composite_action.goToPM_AGENT_CONTEST_DTL();
		pm092_a_composite_action.getTabbedBar().gotoNextTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(2);
		return value;
	}

	public String lastIconAction() {
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value = pm092_a_composite_action.goToPM_AGENT_CONTEST_AWARD();
		pm092_a_composite_action.getTabbedBar().gotoLastTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(4);
		return value;
	}

	public String firstIconAction() {
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value = pm092_a_composite_action.goToPM_AGENT_CONTEST_HDR();
		pm092_a_composite_action.getTabbedBar().gotoFirstTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(1);
		return value;
	}

	public String previousIconAction() {
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value = pm092_a_composite_action.goToPM_AGENT_CONTEST_HDR();
		pm092_a_composite_action.getTabbedBar().gotoPrevTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(1);
		return value;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				new PM_AGENT_CONTEST_HDR_DELEGATE()
						.executeSelectStatement(compositeAction);
				setBlockFlag(false);
			}

			/*
			 * if (PM_AGENT_CONTEST_HDR_BEAN.getROWID() != null) { new
			 * PM_AGENT_CONTEST_HDR_DELEGATE().executeSelectStatement(compositeAction);
			 * }else{ whenCreateRecord(); }
			 */

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
}

