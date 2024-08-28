package com.iii.pel.forms.PILP085_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_HIBAH_FEE_PRCSS_ACTION extends CommonAction {

	private HtmlCommandButton UI_BUT_FETCH_RECORD;

	private HtmlCommandButton UI_BUT_FETCH_PROCESS;

	private HtmlOutputLabel COMP_HFH_POL_NO_FM_LABEL;

	private HtmlInputText COMP_HFH_POL_NO_FM;

	private HtmlOutputLabel COMP_HFH_POL_NO_TO_LABEL;

	private HtmlInputText COMP_HFH_POL_NO_TO;

	private HtmlOutputLabel COMP_HFH_ACNT_YEAR_LABEL;

	private HtmlInputText COMP_HFH_ACNT_YEAR;

	private HtmlOutputLabel COMP_HFH_DATE_FM_LABEL;

	private HtmlCalendar COMP_HFH_DATE_FM;

	private HtmlOutputLabel COMP_HFH_DATE_TO_LABEL;

	private HtmlCalendar COMP_HFH_DATE_TO;

	private HtmlOutputLabel COMP_HFP_POL_NO_LABEL;

	private HtmlInputText COMP_HFP_POL_NO;

	private HtmlOutputLabel COMP_HFP_ACNT_YEAR_LABEL;

	private HtmlInputText COMP_HFP_ACNT_YEAR;

	private HtmlOutputLabel COMP_HFP_PRCSS_YN_LABEL;

	private HtmlSelectOneMenu COMP_HFP_PRCSS_YN;

	private PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN;

	public PILP085_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_HIBAH_FEE_PRCSS_HELPER helper;

	private List<LovBean> suggestionLOV = null;

	private List<PT_IL_HIBAH_FEE_PRCSS> dataList_PT_IL_HIBAH_FEE_PRCSS = new ArrayList<PT_IL_HIBAH_FEE_PRCSS>();

	private UIData dataTable;

	private List<SelectItem> listHFP_PRCSS_YN = new ArrayList<SelectItem>();

	public PT_IL_HIBAH_FEE_PRCSS_ACTION() {

		PT_IL_HIBAH_FEE_PRCSS_BEAN = new PT_IL_HIBAH_FEE_PRCSS();
		helper = new PT_IL_HIBAH_FEE_PRCSS_HELPER();
		setListHFP_PRCSS_YN(ListItemUtil.getDropDownListValue(getConnection(),
				"PILP085_APAC", "PT_IL_HIBAH_FEE_PRCSS",
				"PT_IL_HIBAH_FEE_PRCSS.HFP_PRCSS_YN", "YESNO"));
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public HtmlOutputLabel getCOMP_HFP_POL_NO_LABEL() {
		return COMP_HFP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_HFP_POL_NO() {
		return COMP_HFP_POL_NO;
	}

	public void setCOMP_HFP_POL_NO_LABEL(HtmlOutputLabel COMP_HFP_POL_NO_LABEL) {
		this.COMP_HFP_POL_NO_LABEL = COMP_HFP_POL_NO_LABEL;
	}

	public void setCOMP_HFP_POL_NO(HtmlInputText COMP_HFP_POL_NO) {
		this.COMP_HFP_POL_NO = COMP_HFP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_HFP_ACNT_YEAR_LABEL() {
		return COMP_HFP_ACNT_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_HFP_ACNT_YEAR() {
		return COMP_HFP_ACNT_YEAR;
	}

	public void setCOMP_HFP_ACNT_YEAR_LABEL(
			HtmlOutputLabel COMP_HFP_ACNT_YEAR_LABEL) {
		this.COMP_HFP_ACNT_YEAR_LABEL = COMP_HFP_ACNT_YEAR_LABEL;
	}

	public void setCOMP_HFP_ACNT_YEAR(HtmlInputText COMP_HFP_ACNT_YEAR) {
		this.COMP_HFP_ACNT_YEAR = COMP_HFP_ACNT_YEAR;
	}

	public HtmlOutputLabel getCOMP_HFP_PRCSS_YN_LABEL() {
		return COMP_HFP_PRCSS_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_HFP_PRCSS_YN() {
		return COMP_HFP_PRCSS_YN;
	}

	public void setCOMP_HFP_PRCSS_YN_LABEL(
			HtmlOutputLabel COMP_HFP_PRCSS_YN_LABEL) {
		this.COMP_HFP_PRCSS_YN_LABEL = COMP_HFP_PRCSS_YN_LABEL;
	}

	public void setCOMP_HFP_PRCSS_YN(HtmlSelectOneMenu COMP_HFP_PRCSS_YN) {
		this.COMP_HFP_PRCSS_YN = COMP_HFP_PRCSS_YN;
	}

	public PT_IL_HIBAH_FEE_PRCSS getPT_IL_HIBAH_FEE_PRCSS_BEAN() {
		return PT_IL_HIBAH_FEE_PRCSS_BEAN;
	}

	public void setPT_IL_HIBAH_FEE_PRCSS_BEAN(
			PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN) {
		this.PT_IL_HIBAH_FEE_PRCSS_BEAN = PT_IL_HIBAH_FEE_PRCSS_BEAN;
	}

	public List<PT_IL_HIBAH_FEE_PRCSS> getDataList_PT_IL_HIBAH_FEE_PRCSS() {
		return dataList_PT_IL_HIBAH_FEE_PRCSS;
	}

	public void setDataListPT_IL_HIBAH_FEE_PRCSS(
			List<PT_IL_HIBAH_FEE_PRCSS> dataList_PT_IL_HIBAH_FEE_PRCSS) {
		this.dataList_PT_IL_HIBAH_FEE_PRCSS = dataList_PT_IL_HIBAH_FEE_PRCSS;
	}

	public HtmlOutputLabel getCOMP_HFH_POL_NO_FM_LABEL() {
		return COMP_HFH_POL_NO_FM_LABEL;
	}

	public void setCOMP_HFH_POL_NO_FM_LABEL(
			HtmlOutputLabel comp_hfh_pol_no_fm_label) {
		COMP_HFH_POL_NO_FM_LABEL = comp_hfh_pol_no_fm_label;
	}

	public HtmlInputText getCOMP_HFH_POL_NO_FM() {
		return COMP_HFH_POL_NO_FM;
	}

	public void setCOMP_HFH_POL_NO_FM(HtmlInputText comp_hfh_pol_no_fm) {
		COMP_HFH_POL_NO_FM = comp_hfh_pol_no_fm;
	}

	public HtmlOutputLabel getCOMP_HFH_POL_NO_TO_LABEL() {
		return COMP_HFH_POL_NO_TO_LABEL;
	}

	public void setCOMP_HFH_POL_NO_TO_LABEL(
			HtmlOutputLabel comp_hfh_pol_no_to_label) {
		COMP_HFH_POL_NO_TO_LABEL = comp_hfh_pol_no_to_label;
	}

	public HtmlInputText getCOMP_HFH_POL_NO_TO() {
		return COMP_HFH_POL_NO_TO;
	}

	public void setCOMP_HFH_POL_NO_TO(HtmlInputText comp_hfh_pol_no_to) {
		COMP_HFH_POL_NO_TO = comp_hfh_pol_no_to;
	}

	public HtmlOutputLabel getCOMP_HFH_ACNT_YEAR_LABEL() {
		return COMP_HFH_ACNT_YEAR_LABEL;
	}

	public void setCOMP_HFH_ACNT_YEAR_LABEL(
			HtmlOutputLabel comp_hfh_acnt_year_label) {
		COMP_HFH_ACNT_YEAR_LABEL = comp_hfh_acnt_year_label;
	}

	public HtmlInputText getCOMP_HFH_ACNT_YEAR() {
		return COMP_HFH_ACNT_YEAR;
	}

	public void setCOMP_HFH_ACNT_YEAR(HtmlInputText comp_hfh_acnt_year) {
		COMP_HFH_ACNT_YEAR = comp_hfh_acnt_year;
	}

	public HtmlOutputLabel getCOMP_HFH_DATE_FM_LABEL() {
		return COMP_HFH_DATE_FM_LABEL;
	}

	public void setCOMP_HFH_DATE_FM_LABEL(HtmlOutputLabel comp_hfh_date_fm_label) {
		COMP_HFH_DATE_FM_LABEL = comp_hfh_date_fm_label;
	}

	public HtmlCalendar getCOMP_HFH_DATE_FM() {
		return COMP_HFH_DATE_FM;
	}

	public void setCOMP_HFH_DATE_FM(HtmlCalendar comp_hfh_date_fm) {
		COMP_HFH_DATE_FM = comp_hfh_date_fm;
	}

	public HtmlOutputLabel getCOMP_HFH_DATE_TO_LABEL() {
		return COMP_HFH_DATE_TO_LABEL;
	}

	public void setCOMP_HFH_DATE_TO_LABEL(HtmlOutputLabel comp_hfh_date_to_label) {
		COMP_HFH_DATE_TO_LABEL = comp_hfh_date_to_label;
	}

	public HtmlCalendar getCOMP_HFH_DATE_TO() {
		return COMP_HFH_DATE_TO;
	}

	public void setCOMP_HFH_DATE_TO(HtmlCalendar comp_hfh_date_to) {
		COMP_HFH_DATE_TO = comp_hfh_date_to;
	}

	public PILP085_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILP085_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_HIBAH_FEE_PRCSS_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_HIBAH_FEE_PRCSS_HELPER helper) {
		this.helper = helper;
	}

	public void setDataList_PT_IL_HIBAH_FEE_PRCSS(
			List<PT_IL_HIBAH_FEE_PRCSS> dataList_PT_IL_HIBAH_FEE_PRCSS) {
		this.dataList_PT_IL_HIBAH_FEE_PRCSS = dataList_PT_IL_HIBAH_FEE_PRCSS;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_HIBAH_FEE_PRCSS_BEAN = new PT_IL_HIBAH_FEE_PRCSS();
				resetAllComponent();
				resetSelectedRow();
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

	public List<SelectItem> getListHFP_PRCSS_YN() {
		if (listHFP_PRCSS_YN.size() == 0) {
			listHFP_PRCSS_YN.clear();
			try {
				listHFP_PRCSS_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listHFP_PRCSS_YN;
	}

	public void setListHFP_PRCSS_YN(List<SelectItem> listHFP_PRCSS_YN) {
		this.listHFP_PRCSS_YN = listHFP_PRCSS_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void resetAllComponent() {
		COMP_HFH_ACNT_YEAR.resetValue();
		COMP_HFH_ACNT_YEAR.resetValue();
		COMP_HFH_DATE_TO.resetValue();
		COMP_HFH_POL_NO_FM.resetValue();
		COMP_HFH_POL_NO_TO.resetValue();
		COMP_HFP_PRCSS_YN.resetValue();

	}

	public void resetSelectedRow() {
		Iterator<com.iii.pel.forms.PILP085_APAC.PT_IL_HIBAH_FEE_PRCSS> PT_IL_HIBAH_FEE_PRCSS_ITR = dataList_PT_IL_HIBAH_FEE_PRCSS
				.iterator();
		while (PT_IL_HIBAH_FEE_PRCSS_ITR.hasNext()) {
			PT_IL_HIBAH_FEE_PRCSS_ITR.next().setRowSelected(false);
		}

	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				helper.whenCreateRecord(PT_IL_HIBAH_FEE_PRCSS_BEAN);
				setFormFlag(false);
			}
			if (isBlockFlag()) {

				helper.preBlock(compositeAction.getCTRL_ACTION_BEAN()
						.getCTRL_BEAN());
				helper.whenCreateRecord(PT_IL_HIBAH_FEE_PRCSS_BEAN);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlCommandButton getUI_BUT_FETCH_RECORD() {
		return UI_BUT_FETCH_RECORD;
	}

	public void setUI_BUT_FETCH_RECORD(HtmlCommandButton ui_but_fetch_record) {
		UI_BUT_FETCH_RECORD = ui_but_fetch_record;
	}

	public HtmlCommandButton getUI_BUT_FETCH_PROCESS() {
		return UI_BUT_FETCH_PROCESS;
	}

	public void setUI_BUT_FETCH_PROCESS(HtmlCommandButton ui_but_fetch_process) {
		UI_BUT_FETCH_PROCESS = ui_but_fetch_process;
	}

	public List<LovBean> policyFromLov(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILP085_APAC", "PT_IL_HIBAH_FEE_PRCSS",
					"HFH_POL_NO_FM", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	}

	public List<LovBean> policyToLov(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILP085_APAC", "PT_IL_HIBAH_FEE_PRCSS",
					"HFH_POL_NO_TO", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	}

	public List<LovBean> accountingYrLov(Object event) {

		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILP085_APAC", "DUMMY1",
					"HFH_ACNT_YEAR", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_HIBAH_FEE_PRCSS_BEAN = (PT_IL_HIBAH_FEE_PRCSS) dataTable
					.getRowData();
			PT_IL_HIBAH_FEE_PRCSS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	public void processRecord() {
		try {
			getWarningMap().clear();
			boolean valid = helper.processButtonPressed(compositeAction);
			if (valid) {
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Hibah Process Done Successfully");
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
	}

	public void validateAccountingYear(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFH_ACNT_YEAR((Integer) value);
			helper.whenValidateAccountingYear(PT_IL_HIBAH_FEE_PRCSS_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatePolicyNoFrom(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFH_POL_NO_FM((String) value);
			helper.whenValidatePolicyNoFrom(PT_IL_HIBAH_FEE_PRCSS_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatePolicyNoTo(FacesContext context, UIComponent component,
			Object value) {
		try {
			PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFH_POL_NO_TO((String) value);
			helper.whenValidatePolicyNoTo(PT_IL_HIBAH_FEE_PRCSS_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void listenerPolNoFm(ActionEvent actionEvent) {
		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			if (inputValue.isEmpty()) {
				getCOMP_HFH_POL_NO_FM().setSubmittedValue("0");
			} else {
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFH_POL_NO_FM(inputValue);
			}
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void listenerPolNoTo(ActionEvent actionEvent) {
		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			if (inputValue.isEmpty()) {
				getCOMP_HFH_POL_NO_TO().setSubmittedValue("zzzzzzzzzzzzzzzzzzzzzz");
			} else {
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFH_POL_NO_TO(inputValue);
			}
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
}
