package com.iii.pel.forms.PILP091_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_PROD_FM_LABEL;

	private HtmlInputText COMP_UI_M_PROD_FM;

	private HtmlOutputLabel COMP_UI_M_PROD_TO_LABEL;

	private HtmlInputText COMP_UI_M_PROD_TO;

	private HtmlOutputLabel COMP_UI_M_POL_NO_FROM_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_FROM;

	private HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_TO;

	private HtmlOutputLabel COMP_UI_M_ACNT_YEAR_FM_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_ACNT_YEAR_FM;
	
	private HtmlSelectOneMenu COMP_UI_M_ACNT_YEAR_TO;

	private HtmlOutputLabel COMP_UI_M_ACNT_YEAR_TO_LABEL;
	
    private List<SelectItem> listUI_M_ACNT_YEAR_FM = new ArrayList<SelectItem>();
	
	private List<SelectItem> listUI_M_ACNT_YEAR_TO = new ArrayList<SelectItem>();
	
	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FROM;

	private HtmlCommandButton COMP_UI_M_BUT_ACCEPT;

	private HtmlOutputLabel COMP_SELECT_ALL_LABEL;

	private HtmlCommandButton COMP_SELECT_ALL;

	private DUMMY DUMMY_BEAN = new DUMMY();

	private DUMMY_HELPER helper = new DUMMY_HELPER();

	public PILP091_APAC_COMPOSITE_ACTION compositeAction;

	public DUMMY_ACTION() {
		COMP_UI_M_PROD_FM = new HtmlInputText();
		COMP_UI_M_PROD_TO = new HtmlInputText();
		COMP_UI_M_POL_NO_FROM = new HtmlInputText();
		COMP_UI_M_POL_NO_TO = new HtmlInputText();
		COMP_SELECT_ALL_LABEL = new HtmlOutputLabel();
		populate_Acnt_year();
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
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

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FROM_LABEL() {
		return COMP_UI_M_POL_NO_FROM_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_FROM_LABEL(
			HtmlOutputLabel comp_ui_m_pol_no_from_label) {
		COMP_UI_M_POL_NO_FROM_LABEL = comp_ui_m_pol_no_from_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_FROM() {
		return COMP_UI_M_POL_NO_FROM;
	}

	public void setCOMP_UI_M_POL_NO_FROM(HtmlInputText comp_ui_m_pol_no_from) {
		COMP_UI_M_POL_NO_FROM = comp_ui_m_pol_no_from;
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

	public HtmlOutputLabel getCOMP_UI_M_ACNT_YEAR_FM_LABEL() {
		return COMP_UI_M_ACNT_YEAR_FM_LABEL;
	}

	public void setCOMP_UI_M_ACNT_YEAR_FM_LABEL(
			HtmlOutputLabel comp_ui_m_acnt_year_fm_label) {
		COMP_UI_M_ACNT_YEAR_FM_LABEL = comp_ui_m_acnt_year_fm_label;
	}

	
	public HtmlOutputLabel getCOMP_UI_M_ACNT_YEAR_TO_LABEL() {
		return COMP_UI_M_ACNT_YEAR_TO_LABEL;
	}

	public void setCOMP_UI_M_ACNT_YEAR_TO_LABEL(
			HtmlOutputLabel comp_ui_m_acnt_year_to_label) {
		COMP_UI_M_ACNT_YEAR_TO_LABEL = comp_ui_m_acnt_year_to_label;
	}

	

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_FROM() {
		return COMP_UI_M_BUT_LOV_POL_NO_FROM;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO_FROM(
			HtmlCommandButton comp_ui_m_but_lov_pol_no_from) {
		COMP_UI_M_BUT_LOV_POL_NO_FROM = comp_ui_m_but_lov_pol_no_from;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String approvalBtnAction() {
		String message = null;
		try {
			compositeAction.getPS_IL_CONT_PAID_HDR_ACTION_BEAN().setBlockFlag(
					true);
			helper
					.WHEN_BUTTON_PRESSED_M_BUT_ACCEPT(DUMMY_BEAN,
							compositeAction);
			message = Messages.getString(PELConstants.pelErrorMessagePath,
					"91071");
			compositeAction.getPS_IL_CONT_PAID_HDR_ACTION_BEAN()
					.getWarningMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			compositeAction.getPS_IL_CONT_PAID_HDR_ACTION_BEAN()
					.getWarningMap().put("CURRENT", message);

		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPS_IL_CONT_PAID_HDR_ACTION_BEAN().getErrorMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			compositeAction.getPS_IL_CONT_PAID_HDR_ACTION_BEAN().getErrorMap()
					.put("APPROVE", e.getMessage());
		}

		return message;
	}

	public String selectAllBtnAction() {
		String outcome = null;

		try {
			helper.WHEN_BUTTON_PRESSED_SELECT_ALL(DUMMY_BEAN, compositeAction
					.getDUMMY_ACTION_BEAN(), compositeAction
					.getPS_IL_CONT_PAID_HDR_ACTION_BEAN());

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SELECT_ALL", e.getMessage());
		}

		return outcome;
	}

	public List<LovBean> lovM_PROD_FM(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP091_APAC", "DUMMY",
					"M_PROD_FM", null, null, null, null, null,
					(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovM_PROD_TO(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP091_APAC", "DUMMY",
					"M_PROD_TO", null, null, null, null, null,
					(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public void listenerUI_M_PROD_FM(ActionEvent event) {
		String currentValue = (String) COMP_UI_M_PROD_FM.getSubmittedValue();

		try {
			DUMMY_BEAN.setUI_M_PROD_FM((String) new CommonUtils()
					.SET_REP_FIRST_FIELD(currentValue, "String"));
			COMP_UI_M_PROD_FM.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_PROD_FM", e.getMessage());
		}
	}

	public void listenerUI_M_PROD_TO(ActionEvent event) {
		String currentValue = (String) COMP_UI_M_PROD_TO.getSubmittedValue();
		try {
			DUMMY_BEAN.setUI_M_PROD_TO((String) new CommonUtils()
					.SET_REP_SECOND_FIELD(DUMMY_BEAN.getUI_M_PROD_FM(),
							currentValue, "String"));
			COMP_UI_M_PROD_TO.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_PROD_TO", e.getMessage());
		}
	}

	public void listenerUI_M_POL_NO_FROM(ActionEvent event) {
		String currentValue = (String) COMP_UI_M_POL_NO_FROM
				.getSubmittedValue();

		try {
			DUMMY_BEAN.setUI_M_POL_NO_FROM((String) new CommonUtils()
					.SET_REP_FIRST_FIELD(currentValue, "String"));
			COMP_UI_M_POL_NO_FROM.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_POL_NO_FROM", e.getMessage());
		}
	}

	public void listenerUI_M_POL_NO_TO(ActionEvent event) {
		String currentValue = (String) COMP_UI_M_POL_NO_TO.getSubmittedValue();

		try {
			DUMMY_BEAN.setUI_M_POL_NO_TO((String) new CommonUtils()
					.SET_REP_SECOND_FIELD(DUMMY_BEAN.getUI_M_POL_NO_FROM(),
							currentValue, "String"));
			COMP_UI_M_POL_NO_TO.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_POL_NO_TO", e.getMessage());
		}
	}

	public void listenerUI_M_ACNT_YEAR_FM(ActionEvent event) {
		String currentValue = (String) COMP_UI_M_ACNT_YEAR_FM
				.getSubmittedValue();
		try {
			DUMMY_BEAN.setUI_M_ACNT_YEAR_FM((Integer) new CommonUtils()
					.SET_REP_FIRST_FIELD(currentValue, "Integer"));
			COMP_UI_M_ACNT_YEAR_FM.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_ACNT_YEAR_FM", e.getMessage());
		}
	}

	public void listenerUI_M_ACNT_YEAR_TO(ActionEvent event) {
		String currentValue = (String) COMP_UI_M_ACNT_YEAR_TO
				.getSubmittedValue();

		try {
			/*
			 * DUMMY_BEAN.setUI_M_ACNT_YEAR_TO((Integer) new CommonUtils()
			 * .SET_REP_SECOND_FIELD(DUMMY_BEAN.getUI_M_ACNT_YEAR_FM(),
			 * currentValue, "Integer"));
			 */
			if (DUMMY_BEAN.getUI_M_ACNT_YEAR_FM() != null)
				if (DUMMY_BEAN.getUI_M_ACNT_YEAR_FM().equals(0))
					DUMMY_BEAN.setUI_M_ACNT_YEAR_TO(99);
				else
					DUMMY_BEAN.setUI_M_ACNT_YEAR_TO(DUMMY_BEAN
							.getUI_M_ACNT_YEAR_FM());
			COMP_UI_M_ACNT_YEAR_TO.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_ACNT_YEAR_TO", e.getMessage());
		}
	}

	public List<LovBean> lovM_POL_NO_FROM(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP091_APAC", "DUMMY",
					"M_POL_NO_FROM", DUMMY_BEAN.getUI_M_PROD_FM(), DUMMY_BEAN
							.getUI_M_PROD_TO(), null, null, null,
					(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovM_POL_NO_TO(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP091_APAC", "DUMMY",
					"M_POL_NO_TO", dummy_bean.getUI_M_PROD_FM(), dummy_bean
							.getUI_M_PROD_TO(), null, null, null,
					(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public String fetchDeatilsAction() {
		String outcome = null;

		try {
			helper.keyNextItemM_ACNT_YEAR_TO(DUMMY_BEAN, compositeAction
					.getPS_IL_CONT_PAID_HDR_ACTION_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("FETCH_DETAILS", e.getMessage());
		}

		return outcome;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ACCEPT() {
		return COMP_UI_M_BUT_ACCEPT;
	}

	public void setCOMP_UI_M_BUT_ACCEPT(HtmlCommandButton comp_ui_m_but_accept) {
		COMP_UI_M_BUT_ACCEPT = comp_ui_m_but_accept;
	}

	public HtmlCommandButton getCOMP_SELECT_ALL() {
		return COMP_SELECT_ALL;
	}

	public void setCOMP_SELECT_ALL(HtmlCommandButton comp_select_all) {
		COMP_SELECT_ALL = comp_select_all;
	}

	public HtmlOutputLabel getCOMP_SELECT_ALL_LABEL() {
		return COMP_SELECT_ALL_LABEL;
	}

	public void setCOMP_SELECT_ALL_LABEL(HtmlOutputLabel comp_select_all_label) {
		COMP_SELECT_ALL_LABEL = comp_select_all_label;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_ACNT_YEAR_FM() {
		return COMP_UI_M_ACNT_YEAR_FM;
	}

	public void setCOMP_UI_M_ACNT_YEAR_FM(HtmlSelectOneMenu comp_ui_m_acnt_year_fm) {
		COMP_UI_M_ACNT_YEAR_FM = comp_ui_m_acnt_year_fm;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_ACNT_YEAR_TO() {
		return COMP_UI_M_ACNT_YEAR_TO;
	}

	public void setCOMP_UI_M_ACNT_YEAR_TO(HtmlSelectOneMenu comp_ui_m_acnt_year_to) {
		COMP_UI_M_ACNT_YEAR_TO = comp_ui_m_acnt_year_to;
	}

	public List<SelectItem> getListUI_M_ACNT_YEAR_FM() {
		return listUI_M_ACNT_YEAR_FM;
	}

	public void setListUI_M_ACNT_YEAR_FM(List<SelectItem> listUI_M_ACNT_YEAR_FM) {
		this.listUI_M_ACNT_YEAR_FM = listUI_M_ACNT_YEAR_FM;
	}

	public List<SelectItem> getListUI_M_ACNT_YEAR_TO() {
		return listUI_M_ACNT_YEAR_TO;
	}

	public void setListUI_M_ACNT_YEAR_TO(List<SelectItem> listUI_M_ACNT_YEAR_TO) {
		this.listUI_M_ACNT_YEAR_TO = listUI_M_ACNT_YEAR_TO;
	}
	public void populate_Acnt_year() {
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
	    String query=" SELECT CAY_ACNT_YEAR FROM FM_COMP_ACNT_YEAR ";
	    listUI_M_ACNT_YEAR_FM.clear();
	    listUI_M_ACNT_YEAR_TO.clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				int year=resultSet.getInt(1);
				listUI_M_ACNT_YEAR_FM.add(new SelectItem(year));
				listUI_M_ACNT_YEAR_TO.add(new SelectItem(year));
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
		
	}

}
