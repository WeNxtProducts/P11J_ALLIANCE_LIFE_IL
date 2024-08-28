package com.iii.pel.forms.PILP080;

import java.sql.SQLException;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_ACTION extends CommonAction {
	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private HtmlCommandButton COMP_UI_M_BUT_GENERATE;

	private HtmlCommandButton COMP_UI_M_BUT_REP;
	private HtmlCommandButton COMP_UI_M_BUT_ERR_DTLS;
	private HtmlInputText COMP_UI_M_APPRV_STATUS;
	private DUMMY DUMMY_BEAN;
	private DUMMY_HELPER helper;
	private String M_WHERE;
	private String M_WHERE1;
	public PILP080_COMPOSITE_ACTION compositeAction;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
		COMP_UI_M_APPRV_STATUS = new HtmlInputText();
		COMP_UI_M_BUT_REP = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVE = new HtmlCommandButton();
		COMP_UI_M_BUT_GENERATE = new HtmlCommandButton();
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton comp_ui_m_but_approve) {
		COMP_UI_M_BUT_APPROVE = comp_ui_m_but_approve;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_GENERATE() {
		return COMP_UI_M_BUT_GENERATE;
	}

	public void setCOMP_UI_M_BUT_GENERATE(
			HtmlCommandButton comp_ui_m_but_generate) {
		COMP_UI_M_BUT_GENERATE = comp_ui_m_but_generate;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REP() {
		return COMP_UI_M_BUT_REP;
	}

	public void setCOMP_UI_M_BUT_REP(HtmlCommandButton comp_ui_m_but_rep) {
		COMP_UI_M_BUT_REP = comp_ui_m_but_rep;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ERR_DTLS() {
		return COMP_UI_M_BUT_ERR_DTLS;
	}

	public void setCOMP_UI_M_BUT_ERR_DTLS(
			HtmlCommandButton comp_ui_m_but_err_dtls) {
		COMP_UI_M_BUT_ERR_DTLS = comp_ui_m_but_err_dtls;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public HtmlInputText getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlInputText comp_ui_m_apprv_status) {
		COMP_UI_M_APPRV_STATUS = comp_ui_m_apprv_status;
	}

	public void M_BUT_GENERATE_ACTION() {
		try {
			helper.M_BUT_GENERATE(compositeAction);
		} catch (DBException e) {
			compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN().getErrorMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
	compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN().getErrorMap()
			.put("APPROVE", e.getMessage());
		} catch (SQLException e) {
			compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN().getErrorMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
	compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN().getErrorMap()
			.put("APPROVE", e.getMessage());
		} catch (Exception e) {
			compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN().getErrorMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
	compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN().getErrorMap()
			.put("APPROVE", e.getMessage());
		}
	}

	public DUMMY_HELPER getHelper() {
		return helper;
	}

	public void setHelper(DUMMY_HELPER helper) {
		this.helper = helper;
	}

	public String getM_WHERE() {
		return M_WHERE;
	}

	public void setM_WHERE(String m_where) {
		M_WHERE = m_where;
	}

	public String getM_WHERE1() {
		return M_WHERE1;
	}

	public void setM_WHERE1(String m_where1) {
		M_WHERE1 = m_where1;
	}

	public void M_BUT_APP() throws Exception {
		try {
			CommonUtils.clearMaps(compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN());
			helper.M_BUT_APPROVE(compositeAction);

		} catch (Exception e) {
			compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN().getErrorMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN().getErrorMap()
					.put("APPROVE", e.getMessage());
		}
	}
}
/*
 * public String M_BUT_ERROR() throws Exception{ return
 * helper.M_BUT_ERR_DTLS(compositeAction); }
 */

