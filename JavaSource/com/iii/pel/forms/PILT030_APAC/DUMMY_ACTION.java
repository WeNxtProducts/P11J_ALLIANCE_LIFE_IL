package com.iii.pel.forms.PILT030_APAC;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class DUMMY_ACTION extends CommonAction {

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private HtmlCommandButton COMP_UI_M_BUT_MATCH;

	private HtmlCommandButton COMP_UI_M_BUT_FREEZE;

	private HtmlCommandButton COMP_UI_M_BUT_UNFREEZE;

	private HtmlCommandButton COMP_UI_M_BUT_UNMATCH;

	private HtmlCommandButton COMP_UI_M_BUT_POST;

	private HtmlCommandButton COMP_UI_M_BUT_REPORT;
	
	private HtmlOutputLabel COMP_UI_M_CL_CLAIM_NO_FM_LABEL;
	
	private HtmlInputText COMP_UI_M_CL_CLAIM_NO_FM;
	
	private HtmlOutputLabel COMP_UI_M_CL_CLAIM_NO_TO_LABEL;
	
	private HtmlInputText COMP_UI_M_CL_CLAIM_NO_TO;
	
	private HtmlOutputLabel COMP_UI_M_CL_POLICY_NO_FM_LABEL;
	
	private HtmlInputText COMP_UI_M_CL_POLICY_NO_FM;
	
	private HtmlOutputLabel COMP_UI_M_CL_POLICY_NO_TO_LABEL;
	
	private HtmlInputText COMP_UI_M_CL_POLICY_NO_TO;
	
	private HtmlOutputLabel COMP_UI_M_CL_PROCESS_FM_DT_LABEL;
	
	private HtmlCalendar COMP_UI_M_CL_PROCESS_FM_DT;
	
	private HtmlOutputLabel COMP_UI_M_CL_PROCESS_TO_DT_LABEL;
	
	private HtmlCalendar COMP_UI_M_CL_PROCESS_TO_DT;
	
	private HtmlOutputLabel COMP_UI_M_PS_POLICY_FM_NO_LABEL;
	
	private HtmlInputText COMP_UI_M_PS_POLICY_FM_NO;
	
	private HtmlOutputLabel COMP_UI_M_PS_POLICY_TO_NO_LABEL;
	
	private HtmlInputText COMP_UI_M_PS_POLICY_TO_NO;
	
	private HtmlOutputLabel COMP_UI_M_PS_PROCESS_FM_DT_LABEL;
	
	private HtmlCalendar COMP_UI_M_PS_PROCESS_FM_DT;
	
	private HtmlOutputLabel COMP_UI_M_PS_PROCESS_TO_DT_LABEL;
	
	private HtmlCalendar COMP_UI_M_PS_PROCESS_TO_DT;

	private DUMMY DUMMY_BEAN;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
	}

	public HtmlOutputLabel getCOMP_UI_M_CL_CLAIM_NO_FM_LABEL() {
		return COMP_UI_M_CL_CLAIM_NO_FM_LABEL;
	}

	public void setCOMP_UI_M_CL_CLAIM_NO_FM_LABEL(
			HtmlOutputLabel comp_ui_m_cl_claim_no_fm_label) {
		COMP_UI_M_CL_CLAIM_NO_FM_LABEL = comp_ui_m_cl_claim_no_fm_label;
	}

	public HtmlInputText getCOMP_UI_M_CL_CLAIM_NO_FM() {
		return COMP_UI_M_CL_CLAIM_NO_FM;
	}

	public void setCOMP_UI_M_CL_CLAIM_NO_FM(HtmlInputText comp_ui_m_cl_claim_no_fm) {
		COMP_UI_M_CL_CLAIM_NO_FM = comp_ui_m_cl_claim_no_fm;
	}

	public HtmlOutputLabel getCOMP_UI_M_CL_CLAIM_NO_TO_LABEL() {
		return COMP_UI_M_CL_CLAIM_NO_TO_LABEL;
	}

	public void setCOMP_UI_M_CL_CLAIM_NO_TO_LABEL(
			HtmlOutputLabel comp_ui_m_cl_claim_no_to_label) {
		COMP_UI_M_CL_CLAIM_NO_TO_LABEL = comp_ui_m_cl_claim_no_to_label;
	}

	public HtmlInputText getCOMP_UI_M_CL_CLAIM_NO_TO() {
		return COMP_UI_M_CL_CLAIM_NO_TO;
	}

	public void setCOMP_UI_M_CL_CLAIM_NO_TO(HtmlInputText comp_ui_m_cl_claim_no_to) {
		COMP_UI_M_CL_CLAIM_NO_TO = comp_ui_m_cl_claim_no_to;
	}

	public HtmlOutputLabel getCOMP_UI_M_CL_POLICY_NO_FM_LABEL() {
		return COMP_UI_M_CL_POLICY_NO_FM_LABEL;
	}

	public void setCOMP_UI_M_CL_POLICY_NO_FM_LABEL(
			HtmlOutputLabel comp_ui_m_cl_policy_no_fm_label) {
		COMP_UI_M_CL_POLICY_NO_FM_LABEL = comp_ui_m_cl_policy_no_fm_label;
	}

	public HtmlInputText getCOMP_UI_M_CL_POLICY_NO_FM() {
		return COMP_UI_M_CL_POLICY_NO_FM;
	}

	public void setCOMP_UI_M_CL_POLICY_NO_FM(HtmlInputText comp_ui_m_cl_policy_no_fm) {
		COMP_UI_M_CL_POLICY_NO_FM = comp_ui_m_cl_policy_no_fm;
	}

	public HtmlOutputLabel getCOMP_UI_M_CL_POLICY_NO_TO_LABEL() {
		return COMP_UI_M_CL_POLICY_NO_TO_LABEL;
	}

	public void setCOMP_UI_M_CL_POLICY_NO_TO_LABEL(
			HtmlOutputLabel comp_ui_m_cl_policy_no_to_label) {
		COMP_UI_M_CL_POLICY_NO_TO_LABEL = comp_ui_m_cl_policy_no_to_label;
	}

	public HtmlInputText getCOMP_UI_M_CL_POLICY_NO_TO() {
		return COMP_UI_M_CL_POLICY_NO_TO;
	}

	public void setCOMP_UI_M_CL_POLICY_NO_TO(HtmlInputText comp_ui_m_cl_policy_no_to) {
		COMP_UI_M_CL_POLICY_NO_TO = comp_ui_m_cl_policy_no_to;
	}

	public HtmlOutputLabel getCOMP_UI_M_CL_PROCESS_FM_DT_LABEL() {
		return COMP_UI_M_CL_PROCESS_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_CL_PROCESS_FM_DT_LABEL(
			HtmlOutputLabel comp_ui_m_cl_process_fm_dt_label) {
		COMP_UI_M_CL_PROCESS_FM_DT_LABEL = comp_ui_m_cl_process_fm_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_CL_PROCESS_FM_DT() {
		return COMP_UI_M_CL_PROCESS_FM_DT;
	}

	public void setCOMP_UI_M_CL_PROCESS_FM_DT(
			HtmlCalendar comp_ui_m_cl_process_fm_dt) {
		COMP_UI_M_CL_PROCESS_FM_DT = comp_ui_m_cl_process_fm_dt;
	}

	public HtmlOutputLabel getCOMP_UI_M_CL_PROCESS_TO_DT_LABEL() {
		return COMP_UI_M_CL_PROCESS_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_CL_PROCESS_TO_DT_LABEL(
			HtmlOutputLabel comp_ui_m_cl_process_to_dt_label) {
		COMP_UI_M_CL_PROCESS_TO_DT_LABEL = comp_ui_m_cl_process_to_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_CL_PROCESS_TO_DT() {
		return COMP_UI_M_CL_PROCESS_TO_DT;
	}

	public void setCOMP_UI_M_CL_PROCESS_TO_DT(
			HtmlCalendar comp_ui_m_cl_process_to_dt) {
		COMP_UI_M_CL_PROCESS_TO_DT = comp_ui_m_cl_process_to_dt;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton COMP_UI_M_BUT_PROCESS) {
		this.COMP_UI_M_BUT_PROCESS = COMP_UI_M_BUT_PROCESS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MATCH() {
		return COMP_UI_M_BUT_MATCH;
	}

	public void setCOMP_UI_M_BUT_MATCH(HtmlCommandButton COMP_UI_M_BUT_MATCH) {
		this.COMP_UI_M_BUT_MATCH = COMP_UI_M_BUT_MATCH;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FREEZE() {
		return COMP_UI_M_BUT_FREEZE;
	}

	public void setCOMP_UI_M_BUT_FREEZE(HtmlCommandButton COMP_UI_M_BUT_FREEZE) {
		this.COMP_UI_M_BUT_FREEZE = COMP_UI_M_BUT_FREEZE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_UNFREEZE() {
		return COMP_UI_M_BUT_UNFREEZE;
	}

	public void setCOMP_UI_M_BUT_UNFREEZE(HtmlCommandButton COMP_UI_M_BUT_UNFREEZE) {
		this.COMP_UI_M_BUT_UNFREEZE = COMP_UI_M_BUT_UNFREEZE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_UNMATCH() {
		return COMP_UI_M_BUT_UNMATCH;
	}

	public void setCOMP_UI_M_BUT_UNMATCH(HtmlCommandButton COMP_UI_M_BUT_UNMATCH) {
		this.COMP_UI_M_BUT_UNMATCH = COMP_UI_M_BUT_UNMATCH;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POST() {
		return COMP_UI_M_BUT_POST;
	}

	public void setCOMP_UI_M_BUT_POST(HtmlCommandButton COMP_UI_M_BUT_POST) {
		this.COMP_UI_M_BUT_POST = COMP_UI_M_BUT_POST;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REPORT() {
		return COMP_UI_M_BUT_REPORT;
	}

	public void setCOMP_UI_M_BUT_REPORT(HtmlCommandButton COMP_UI_M_BUT_REPORT) {
		this.COMP_UI_M_BUT_REPORT = COMP_UI_M_BUT_REPORT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PS_POLICY_FM_NO_LABEL() {
		return COMP_UI_M_PS_POLICY_FM_NO_LABEL;
	}

	public void setCOMP_UI_M_PS_POLICY_FM_NO_LABEL(
			HtmlOutputLabel comp_ui_m_ps_policy_fm_no_label) {
		COMP_UI_M_PS_POLICY_FM_NO_LABEL = comp_ui_m_ps_policy_fm_no_label;
	}

	public HtmlInputText getCOMP_UI_M_PS_POLICY_FM_NO() {
		return COMP_UI_M_PS_POLICY_FM_NO;
	}

	public void setCOMP_UI_M_PS_POLICY_FM_NO(HtmlInputText comp_ui_m_ps_policy_fm_no) {
		COMP_UI_M_PS_POLICY_FM_NO = comp_ui_m_ps_policy_fm_no;
	}

	public HtmlOutputLabel getCOMP_UI_M_PS_POLICY_TO_NO_LABEL() {
		return COMP_UI_M_PS_POLICY_TO_NO_LABEL;
	}

	public void setCOMP_UI_M_PS_POLICY_TO_NO_LABEL(
			HtmlOutputLabel comp_ui_m_ps_policy_to_no_label) {
		COMP_UI_M_PS_POLICY_TO_NO_LABEL = comp_ui_m_ps_policy_to_no_label;
	}

	public HtmlInputText getCOMP_UI_M_PS_POLICY_TO_NO() {
		return COMP_UI_M_PS_POLICY_TO_NO;
	}

	public void setCOMP_UI_M_PS_POLICY_TO_NO(HtmlInputText comp_ui_m_ps_policy_to_no) {
		COMP_UI_M_PS_POLICY_TO_NO = comp_ui_m_ps_policy_to_no;
	}

	public HtmlOutputLabel getCOMP_UI_M_PS_PROCESS_FM_DT_LABEL() {
		return COMP_UI_M_PS_PROCESS_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_PS_PROCESS_FM_DT_LABEL(
			HtmlOutputLabel comp_ui_m_ps_process_fm_dt_label) {
		COMP_UI_M_PS_PROCESS_FM_DT_LABEL = comp_ui_m_ps_process_fm_dt_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_PS_PROCESS_TO_DT_LABEL() {
		return COMP_UI_M_PS_PROCESS_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_PS_PROCESS_TO_DT_LABEL(
			HtmlOutputLabel comp_ui_m_ps_process_to_dt_label) {
		COMP_UI_M_PS_PROCESS_TO_DT_LABEL = comp_ui_m_ps_process_to_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_PS_PROCESS_FM_DT() {
		return COMP_UI_M_PS_PROCESS_FM_DT;
	}

	public void setCOMP_UI_M_PS_PROCESS_FM_DT(
			HtmlCalendar comp_ui_m_ps_process_fm_dt) {
		COMP_UI_M_PS_PROCESS_FM_DT = comp_ui_m_ps_process_fm_dt;
	}

	public HtmlCalendar getCOMP_UI_M_PS_PROCESS_TO_DT() {
		return COMP_UI_M_PS_PROCESS_TO_DT;
	}

	public void setCOMP_UI_M_PS_PROCESS_TO_DT(
			HtmlCalendar comp_ui_m_ps_process_to_dt) {
		COMP_UI_M_PS_PROCESS_TO_DT = comp_ui_m_ps_process_to_dt;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}
	
	public void processButton(){
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		hdrAction.getErrorMap().clear();
		try {
			hdrAction.setOnLoadFlag(false);
			helper.processButton();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("description", e.getMessage());
		}
	}
	
	public String approveButton(){
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		hdrAction.getErrorMap().clear();
		try {
			hdrAction.setOnLoadFlag(false);
			return helper.approveButton();
		} catch (Exception e) {
			hdrAction.getErrorMap().put("current", e.getMessage());
			hdrAction.setErrorMessages(e.getMessage());
		}
		return null;
	}
	
	public void matchButton(){
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		hdrAction.getErrorMap().clear();
		try {
			hdrAction.setOnLoadFlag(false);
			helper.matchButton();
		} catch (Exception e) {
			hdrAction.getErrorMap().put("current", e.getMessage());
			hdrAction.setErrorMessages(e.getMessage());
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(PILT030_APAC_ACTION_INSTANCE.getConnection(), FacesContext.getCurrentInstance(), "UI_M_MATCH_BUTTON", hdrAction.getErrorMap(), hdrAction.getWarningMap());
		}
	}
	
	public void freezeButton(){
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		hdrAction.getErrorMap().clear();
		try {
			hdrAction.setOnLoadFlag(false);
			helper.freezeButton();
		} catch (Exception e) {
			hdrAction.getErrorMap().put("current", e.getMessage());
			hdrAction.setErrorMessages(e.getMessage());
		}finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(PILT030_APAC_ACTION_INSTANCE.getConnection(), FacesContext.getCurrentInstance(), "UI_M_FREEZE_BUTTON", hdrAction.getErrorMap(), hdrAction.getWarningMap());
		}
	}
	
	public void unFreezeButton(){
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		hdrAction.getErrorMap().clear();
		try {
			hdrAction.setOnLoadFlag(false);
			helper.unFreezeButton();
		} catch (Exception e) {
			hdrAction.getErrorMap().put("current", e.getMessage());
			hdrAction.setErrorMessages(e.getMessage());
		}
	}
	
	public void unMatchButton(){
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		hdrAction.getErrorMap().clear();
		try {
			hdrAction.setOnLoadFlag(false);
			helper.unMatchButton();
		} catch (Exception e) {
			hdrAction.getErrorMap().put("current", e.getMessage());
			hdrAction.setErrorMessages(e.getMessage());
		}
	}
	
	public String postButton(){
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		hdrAction.getErrorMap().clear();
		String postForm = null;
		try {
			hdrAction.setOnLoadFlag(false);
			postForm = helper.postButton();
		} catch (Exception e) {
			hdrAction.getErrorMap().put("current", e.getMessage());
			hdrAction.setErrorMessages(e.getMessage());
		}
		return postForm;
	}
	
	public void reportButton(){
		
	}
	
	public String goBack(){
		return "claimPaid";
	}
	
}
