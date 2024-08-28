package com.iii.pel.forms.PILP057_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private DUMMY DUMMY_BEAN;

	private DUMMY_HELPER helper;

	public PILP057_APAC_COMPOSITE_ACTION compositeAction;

	private HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_FM;

	private HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_TO;

	private HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PROCESS_DT;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	public Connection getConnection() throws Exception {
		Connection con = CommonUtils.getConnection();
		return con;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public PILP057_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILP057_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FM_LABEL() {
		return COMP_UI_M_POL_NO_FM_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_FM_LABEL(
			HtmlOutputLabel comp_ui_m_pol_no_fm_label) {
		COMP_UI_M_POL_NO_FM_LABEL = comp_ui_m_pol_no_fm_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_FM() {
		return COMP_UI_M_POL_NO_FM;
	}

	public void setCOMP_UI_M_POL_NO_FM(HtmlInputText comp_ui_m_pol_no_fm) {
		COMP_UI_M_POL_NO_FM = comp_ui_m_pol_no_fm;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_TO_LABEL() {
		return COMP_UI_M_POL_NO_TO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_TO_LABEL(
			HtmlOutputLabel comp_ui_m_pol_no_to_label) {
		COMP_UI_M_POL_NO_TO_LABEL = comp_ui_m_pol_no_to_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_TO() {
		return COMP_UI_M_POL_NO_TO;
	}

	public void setCOMP_UI_M_POL_NO_TO(HtmlInputText comp_ui_m_pol_no_to) {
		COMP_UI_M_POL_NO_TO = comp_ui_m_pol_no_to;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DT_LABEL() {
		return COMP_UI_M_PROCESS_DT_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_DT_LABEL(
			HtmlOutputLabel comp_ui_m_process_dt_label) {
		COMP_UI_M_PROCESS_DT_LABEL = comp_ui_m_process_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_DT() {
		return COMP_UI_M_PROCESS_DT;
	}

	public void setCOMP_UI_M_PROCESS_DT(HtmlCalendar comp_ui_m_process_dt) {
		COMP_UI_M_PROCESS_DT = comp_ui_m_process_dt;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton comp_ui_m_but_process) {
		COMP_UI_M_BUT_PROCESS = comp_ui_m_but_process;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				DUMMY_BEAN.setUI_M_PROCESS_DT(new CommonUtils()
						.getCurrentDate());
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public String processButtonAction() throws Exception {
		String outString = null;
		try {
			helper.CALC_SURPLUS(DUMMY_BEAN.getUI_M_POL_NO_FM(),
							DUMMY_BEAN.getUI_M_POL_NO_TO(), 
							DUMMY_BEAN.getUI_M_PROCESS_DT(),
							null);
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "3083",
					new Object[] { CommonUtils.getControlBean()
							.getM_LANG_CODE() }));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return outString;
	}

	public List<LovBean> lovM_POL_NO_FM(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP057_APAC", "DUMMY",
					"M_POL_NO_FM", null, null, null, null, null,
					(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovM_POL_NO_TO(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP057_APAC", "DUMMY",
					"M_POL_NO_TO", null, null, null, null, null,
					(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public void validateUI_M_POL_NO_FM(FacesContext fc, UIComponent component,
			Object value) {
		try {
			DUMMY_BEAN.setUI_M_POL_NO_FM((String) value);
			if (DUMMY_BEAN.getUI_M_POL_NO_FM() != "0"
					&& !"0".equals(DUMMY_BEAN.getUI_M_POL_NO_FM())) {
				L_CHK_POL_NO(DUMMY_BEAN.getUI_M_POL_NO_FM());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateUI_M_POL_NO_TO(FacesContext fc, UIComponent component,
			Object value) {
		try {
			DUMMY_BEAN.setUI_M_POL_NO_TO((String) value);
			if (DUMMY_BEAN.getUI_M_POL_NO_TO() != "zzzzzzzzzz"
					&& !"zzzzzzzzzz".equals(DUMMY_BEAN.getUI_M_POL_NO_TO())) {
				L_CHK_POL_NO(DUMMY_BEAN.getUI_M_POL_NO_TO());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void actionListenerUI_M_POL_NO_FM(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput htmlInputText = (UIInput) actionEvent.getComponent()
					.getParent();
			String inputValue = (String) htmlInputText.getSubmittedValue();
			if (inputValue.isEmpty()) {
				getCOMP_UI_M_POL_NO_FM().setSubmittedValue("0");
				DUMMY_BEAN.setUI_M_POL_NO_FM("0");
			} else {
				DUMMY_BEAN.setUI_M_POL_NO_FM(inputValue);
				ErrorHelpUtil.validate(htmlInputText, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void validateUI_M_PROCESS_DT(FacesContext fc, UIComponent component,
			Object value) {
		try {
			if ((DUMMY_BEAN.getUI_M_PROCESS_DT()).after(new CommonUtils()
					.getCurrentDate())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60021",
						new Object[] { CommonUtils.getControlBean()
								.getM_LANG_CODE() }));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerUI_M_POL_NO_TO(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String claimNumFm = DUMMY_BEAN.getUI_M_POL_NO_FM();
				if (!claimNumFm.trim().equals("0")) {
					getCOMP_UI_M_POL_NO_TO().setSubmittedValue(claimNumFm);
					DUMMY_BEAN.setUI_M_POL_NO_TO(claimNumFm);
				} else {
					getCOMP_UI_M_POL_NO_TO().setSubmittedValue("zzzzzzzzzz");
					DUMMY_BEAN.setUI_M_POL_NO_TO("zzzzzzzzzz");
				}
			} else {
				DUMMY_BEAN.setUI_M_POL_NO_TO(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void L_CHK_POL_NO(String POLICY_NO) throws Exception {
		String C1 = " SELECT 'X' FROM PT_IL_POLICY WHERE  POL_NO = ? ";
		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String M_TEMP = null;
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if (POLICY_NO != null) {
				C1_REC = handler.executeSelectStatement(C1, conn,
						new Object[] { POLICY_NO });
				if (C1_REC.next()) {
					M_TEMP = C1_REC.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "2411",
							new Object[] { CommonUtils.getControlBean()
									.getM_LANG_CODE() }));
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}

		}
	}

}
