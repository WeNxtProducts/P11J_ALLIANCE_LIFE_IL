package com.iii.pel.forms.PILP084_APAC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
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
import com.iii.pel.forms.PILM012.PM_IL_BROKER_SETUP;
import com.iii.pel.forms.PILM012.PM_IL_BROKER_SETUP_DELEGATE;
import com.iii.pel.forms.PILM012.PM_IL_BROKER_SETUP_HELPER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class JOBS_SCHD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_PRCSS_NAME_LABEL;

	private HtmlInputText COMP_UI_M_PRCSS_NAME;

	private HtmlOutputLabel COMP_UI_M_PRCSS_NAME_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PRCSS_NAME_DESC;

	private HtmlOutputLabel COMP_UI_M_SCHD_INSTANCE_LABEL;

	private HtmlCalendar COMP_UI_M_SCHD_INSTANCE;

	private HtmlOutputLabel COMP_UI_M_SCHD_INTERVAL_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_SCHD_INTERVAL;

	private HtmlOutputLabel COMP_UI_M_SCHD_JOB_YN_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_SCHD_JOB_YN;

	private JOBS_SCHD JOBS_SCHD_BEAN;

	public PILP084_APAC_COMPOSITE_ACTION compositeAction;

	private JOBS_SCHD_HELPER helper;

	private List<SelectItem> listUI_M_SCHD_INTERVAL = new ArrayList<SelectItem>();

	private HtmlCommandButton COMP_UI_M_BUT_SAVE;

	private List<SelectItem> listUI_M_SCHD_JOB_YN = new ArrayList<SelectItem>();

	public JOBS_SCHD_ACTION() {

		JOBS_SCHD_BEAN = new JOBS_SCHD();
		helper = new JOBS_SCHD_HELPER();
		prepareDropDowns();
	}

	public void prepareDropDowns() {
		try {
			Connection connection = CommonUtils.getConnection();
			setListUI_M_SCHD_INTERVAL(ListItemUtil.getDropDownListValue_1(
					connection, "PILP084_APAC", "JOBS_SCHD",
					"JOBS_SCHD.M_SCHD_INTERVAL", "JOBINTRVL"));
			setListUI_M_SCHD_JOB_YN(ListItemUtil.getDropDownListValue_1(
					connection, "PILP084_APAC", "JOBS_SCHD",
					"JOBS_SCHD.M_SCHD_JOB_YN", "YESNO"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_PRCSS_NAME_LABEL() {
		return COMP_UI_M_PRCSS_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PRCSS_NAME() {
		return COMP_UI_M_PRCSS_NAME;
	}

	public void setCOMP_UI_M_PRCSS_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_PRCSS_NAME_LABEL) {
		this.COMP_UI_M_PRCSS_NAME_LABEL = COMP_UI_M_PRCSS_NAME_LABEL;
	}

	public void setCOMP_UI_M_PRCSS_NAME(HtmlInputText COMP_UI_M_PRCSS_NAME) {
		this.COMP_UI_M_PRCSS_NAME = COMP_UI_M_PRCSS_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_PRCSS_NAME_DESC_LABEL() {
		return COMP_UI_M_PRCSS_NAME_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PRCSS_NAME_DESC() {
		return COMP_UI_M_PRCSS_NAME_DESC;
	}

	public void setCOMP_UI_M_PRCSS_NAME_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PRCSS_NAME_DESC_LABEL) {
		this.COMP_UI_M_PRCSS_NAME_DESC_LABEL = COMP_UI_M_PRCSS_NAME_DESC_LABEL;
	}

	public void setCOMP_UI_M_PRCSS_NAME_DESC(
			HtmlInputText COMP_UI_M_PRCSS_NAME_DESC) {
		this.COMP_UI_M_PRCSS_NAME_DESC = COMP_UI_M_PRCSS_NAME_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_SCHD_INSTANCE_LABEL() {
		return COMP_UI_M_SCHD_INSTANCE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_SCHD_INSTANCE() {
		return COMP_UI_M_SCHD_INSTANCE;
	}

	public void setCOMP_UI_M_SCHD_INSTANCE_LABEL(
			HtmlOutputLabel COMP_UI_M_SCHD_INSTANCE_LABEL) {
		this.COMP_UI_M_SCHD_INSTANCE_LABEL = COMP_UI_M_SCHD_INSTANCE_LABEL;
	}

	public void setCOMP_UI_M_SCHD_INSTANCE(HtmlCalendar COMP_UI_M_SCHD_INSTANCE) {
		this.COMP_UI_M_SCHD_INSTANCE = COMP_UI_M_SCHD_INSTANCE;
	}

	public HtmlOutputLabel getCOMP_UI_M_SCHD_INTERVAL_LABEL() {
		return COMP_UI_M_SCHD_INTERVAL_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_SCHD_INTERVAL() {
		return COMP_UI_M_SCHD_INTERVAL;
	}

	public void setCOMP_UI_M_SCHD_INTERVAL_LABEL(
			HtmlOutputLabel COMP_UI_M_SCHD_INTERVAL_LABEL) {
		this.COMP_UI_M_SCHD_INTERVAL_LABEL = COMP_UI_M_SCHD_INTERVAL_LABEL;
	}

	public void setCOMP_UI_M_SCHD_INTERVAL(
			HtmlSelectOneMenu COMP_UI_M_SCHD_INTERVAL) {
		this.COMP_UI_M_SCHD_INTERVAL = COMP_UI_M_SCHD_INTERVAL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SAVE() {
		return COMP_UI_M_BUT_SAVE;
	}

	public void setCOMP_UI_M_BUT_SAVE(HtmlCommandButton comp_ui_m_but_save) {
		COMP_UI_M_BUT_SAVE = comp_ui_m_but_save;
	}

	public HtmlOutputLabel getCOMP_UI_M_SCHD_JOB_YN_LABEL() {
		return COMP_UI_M_SCHD_JOB_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_SCHD_JOB_YN() {
		return COMP_UI_M_SCHD_JOB_YN;
	}

	public void setCOMP_UI_M_SCHD_JOB_YN_LABEL(
			HtmlOutputLabel COMP_UI_M_SCHD_JOB_YN_LABEL) {
		this.COMP_UI_M_SCHD_JOB_YN_LABEL = COMP_UI_M_SCHD_JOB_YN_LABEL;
	}

	public void setCOMP_UI_M_SCHD_JOB_YN(HtmlSelectOneMenu COMP_UI_M_SCHD_JOB_YN) {
		this.COMP_UI_M_SCHD_JOB_YN = COMP_UI_M_SCHD_JOB_YN;
	}

	public JOBS_SCHD getJOBS_SCHD_BEAN() {
		return JOBS_SCHD_BEAN;
	}

	public void setJOBS_SCHD_BEAN(JOBS_SCHD JOBS_SCHD_BEAN) {
		this.JOBS_SCHD_BEAN = JOBS_SCHD_BEAN;
	}

	public List<SelectItem> getListUI_M_SCHD_INTERVAL() {
		if (listUI_M_SCHD_INTERVAL.size() == 0) {

			try {
				listUI_M_SCHD_INTERVAL = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listUI_M_SCHD_INTERVAL;
	}

	public void setListUI_M_SCHD_INTERVAL(
			List<SelectItem> listUI_M_SCHD_INTERVAL) {
		this.listUI_M_SCHD_INTERVAL = listUI_M_SCHD_INTERVAL;
	}

	public List<SelectItem> getListUI_M_SCHD_JOB_YN() {
		if (listUI_M_SCHD_JOB_YN.size() == 0) {

			try {
				listUI_M_SCHD_JOB_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listUI_M_SCHD_JOB_YN;
	}

	public void setListUI_M_SCHD_JOB_YN(List<SelectItem> listUI_M_SCHD_JOB_YN) {
		this.listUI_M_SCHD_JOB_YN = listUI_M_SCHD_JOB_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		JOBS_SCHD_DELEGATE degate = new JOBS_SCHD_DELEGATE();
		try {
			if (isBlockFlag()) {
				helper.whenNewRecordCreated(this);
				if (JOBS_SCHD_BEAN.getROWID() != null) {
				} else {
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public List<LovBean> lovUI_M_PRCSS_NAME(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP084_APAC",
					"JOBS_SCHD", "M_PRCSS_NAME", "JOBS_SCHD", null, null, null,
					null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public void validateUI_M_PRCSS_NAME(FacesContext fc, UIComponent component,
			Object value) {
		try {
			JOBS_SCHD_BEAN.setUI_M_PRCSS_NAME((String) value);
			helper.when_ValidatePrcss_Name(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateUI_M_SCHD_INSTANCE(FacesContext fc,
			UIComponent component, Object value) {
		try {
			JOBS_SCHD_BEAN.setUI_M_SCHD_INSTANCE((Date) value);
			helper.whenValidateUI_M_SCHD_INSTANCE(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void saveRecord() {
		try {
			if (getJOBS_SCHD_BEAN().getROWID() != null) {
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String save() throws Exception {

		String C1 = " SELECT JOB FROM   USER_JOBS WHERE  LOWER(WHAT) =LOWER(?)";
		Integer M_JOB = null;
		String M_INTERVAL = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		String outcome = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] {JOBS_SCHD_BEAN.getUI_M_PRCSS_NAME_DESC()});
			if (resultSet.next()) {
				M_JOB = resultSet.getInt(1);
			}
			if (M_JOB == null && "Y".equals(JOBS_SCHD_BEAN.getUI_M_SCHD_JOB_YN())) {

				// L_JOB_SUBMIT(JOBS_SCHD_BEAN.getUI_M_PRCSS_NAME_DESC());
			} else if (M_JOB == null && "N".equals(JOBS_SCHD_BEAN.getUI_M_SCHD_JOB_YN())) {
				throw new Exception("Job Is Not Scheduled");
			}
			if (((JOBS_SCHD_BEAN.getUI_M_SCHD_INSTANCE() != null)
					&& (JOBS_SCHD_BEAN.getUI_M_SCHD_INTERVAL() == null))
					|| ((JOBS_SCHD_BEAN.getUI_M_SCHD_INSTANCE() == null)
							&& (JOBS_SCHD_BEAN.getUI_M_SCHD_INTERVAL() != null))
					|| ((JOBS_SCHD_BEAN.getUI_M_SCHD_INSTANCE() != null)
							&& (JOBS_SCHD_BEAN.getUI_M_SCHD_INTERVAL() != null))) {

				// BREAK_JOB(M_JOB,:JOBS_SCHD_BEAN.getM_SCHD_JOB_YN());
				if (JOBS_SCHD_BEAN.getUI_M_SCHD_INTERVAL() == 1) {
					// DBMS_JOB.CHANGE(M_JOB,NULL,JOBS_SCHD_BEAN.getUI_M_SCHD_INSTANCE(),"SYSDATE+1");
				} else if (JOBS_SCHD_BEAN.getUI_M_SCHD_INTERVAL() == 7) {
					// DBMS_JOB.CHANGE(M_JOB,NULL,JOBS_SCHD_BEAN.getUI_M_SCHD_INSTANCE(),"SYSDATE+7");
				}
				// COMMIT_FORM;
				throw new Exception("Job Rescheduled");
			}
		} catch (Exception e) {
			e.printStackTrace();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getWarningMap().put("CURRENT", e.getMessage());
			e.printStackTrace();
		}
		return outcome;
	}

}