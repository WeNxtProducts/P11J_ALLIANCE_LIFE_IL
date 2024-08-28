package com.iii.pel.forms.PILM013_APAC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlSimpleTogglePanel;

import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY_HELPER;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_MED_EXAM_DTL_HELPER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.StringFunctions;

/**
 * Name :- AMEETT BENDRE
 * @author 50187
 * Date :- 04.10.2008
 */
public class PM_IL_DOC_SETUP_ACTION extends CommonAction {
	
	/*Added by saritha*/

	private HtmlOutputLabel COMP_END_REASON_LABEL;

	public HtmlOutputLabel getCOMP_END_REASON_LABEL() {
		return COMP_END_REASON_LABEL;
	}

	public void setCOMP_END_REASON_LABEL(HtmlOutputLabel cOMP_END_REASON_LABEL) {
		COMP_END_REASON_LABEL = cOMP_END_REASON_LABEL;
	}

	private HtmlInputTextarea COMP_END_COV_DESC;
	
	public HtmlInputTextarea getCOMP_END_COV_DESC() {
		return COMP_END_COV_DESC;
	}

	public void setCOMP_END_COV_DESC(HtmlInputTextarea cOMP_END_COV_DESC) {
		COMP_END_COV_DESC = cOMP_END_COV_DESC;
	}
	
	/*End*/

	private HtmlOutputLabel COMP_DS_TYPE_LABEL;
	private HtmlOutputLabel COMP_UI_M_DS_TYPE_DESC_LABEL;
	private HtmlOutputLabel COMP_DS_END_TYPE_LABEL;
	private HtmlOutputLabel COMP_DS_CODE_LABEL;
	private HtmlOutputLabel COMP_DS_DESC_LABEL;
	private HtmlOutputLabel COMP_DS_POL_CODE_LABEL;
	private HtmlOutputLabel COMP_DS_SHORT_DESC_LABEL;
	private HtmlOutputLabel COMP_DS_USE_SEQ_YN_LABEL;
	private HtmlOutputLabel COMP_DS_CURR_RATE_BS_LABEL;
	private HtmlOutputLabel COMP_DS_EFF_FM_DT_LABEL;
	private HtmlOutputLabel COMP_DS_EFF_TO_DT_LABEL;
	private HtmlOutputLabel COMP_DS_POST_BO_LABEL;
	private HtmlOutputLabel COMP_DS_BROKER_YN_LABEL;
	private HtmlOutputLabel COMP_DS_PRN_BEFORE_APPR_LABEL;
	private HtmlOutputLabel COMP_DS_REPRINT_YN_LABEL;
	private HtmlOutputLabel COMP_DS_AGE_RECALC_YN_LABEL;
	private HtmlOutputLabel COMP_DS_BL_DESC_LABEL;
	private HtmlOutputLabel COMP_DS_BL_SHORT_DESC_LABEL;
	private HtmlOutputLabel COMP_DS_FUND_TYPE_LABEL;
	private HtmlOutputLabel COMP_DS_REFUND_PREM_FLAG_LABEL;
	private HtmlOutputLabel COMP_DS_REFUND_SURPLUS_FLAG_LABEL;
	private HtmlOutputLabel COMP_DS_REFUND_DEP_FLAG_LABEL;
	private HtmlOutputLabel COMP_DS_RECVR_CHRG_FLAG_LABEL;
	private HtmlOutputLabel COMP_DS_RECVR_MEDFEE_YN_LABEL;
	private HtmlOutputLabel COMP_DS_RECVR_COMM_FLAG_LABEL;
	private HtmlOutputLabel COMP_DS_CLM_PARSET_LABEL;
	private HtmlOutputLabel COMP_UI_M_DS_CLM_PARSET_DESC_LABEL;
	private HtmlOutputLabel COMP_DS_CLM_FULSET_LABEL;
	private HtmlOutputLabel COMP_UI_M_DS_CLM_FULSET_DESC_LABEL;
	private HtmlOutputLabel COMP_UI_M_END_TYPE_DESC_LABEL;

	private HtmlInputText COMP_DS_TYPE;
	private HtmlInputText COMP_UI_M_DS_TYPE_DESC;
	private HtmlInputText COMP_DS_END_TYPE;
	private HtmlInputText COMP_DS_CODE;
	private HtmlInputText COMP_DS_DESC;
	private HtmlInputText COMP_DS_POL_CODE;
	private HtmlInputText COMP_DS_SHORT_DESC;
	private HtmlInputText COMP_DS_BL_DESC;
	private HtmlInputText COMP_DS_BL_SHORT_DESC;
	private HtmlInputText COMP_DS_CLM_PARSET;
	private HtmlInputText COMP_UI_M_DS_CLM_PARSET_DESC;
	private HtmlInputText COMP_DS_CLM_FULSET;
	private HtmlInputText COMP_UI_M_DS_CLM_FULSET_DESC;
	private HtmlInputText COMP_UI_M_DS_END_DESC;

	private HtmlSelectOneMenu COMP_DS_USE_SEQ_YN;
	private HtmlSelectOneMenu COMP_DS_CURR_RATE_BS;
	private HtmlSelectOneMenu COMP_DS_POST_BO;
	private HtmlSelectOneMenu COMP_DS_BROKER_YN;
	private HtmlSelectOneMenu COMP_DS_PRN_BEFORE_APPR;
	private HtmlSelectOneMenu COMP_DS_REPRINT_YN;
	private HtmlSelectOneMenu COMP_DS_AGE_RECALC_YN;
	private HtmlSelectOneMenu COMP_DS_FUND_TYPE;
	private HtmlSelectOneMenu COMP_DS_REFUND_PREM_FLAG;
	private HtmlSelectOneMenu COMP_DS_REFUND_SURPLUS_FLAG;
	private HtmlSelectOneMenu COMP_DS_REFUND_DEP_FLAG;
	private HtmlSelectOneMenu COMP_DS_RECVR_CHRG_FLAG;
	private HtmlSelectOneMenu COMP_DS_RECVR_MEDFEE_YN;
	private HtmlSelectOneMenu COMP_DS_RECVR_COMM_FLAG;

	private HtmlCalendar COMP_DS_EFF_TO_DT;
	private HtmlCalendar COMP_DS_EFF_FM_DT;

	private HtmlCommandButton COMP_UI_M_BUT_BILINGUAL;
	private HtmlCommandButton COMP_UI_M_BUT_CANC;
	private HtmlCommandButton COMP_UI_M_BUT_CLAIM;
	private HtmlCommandButton COMP_UI_M_BUT_DS_TYPE_LOV;
	private HtmlCommandButton COMP_UI_M_BUT_ENDT_TYPE_LOV;
	private HtmlCommandButton COMP_UI_M_BUT_POL_LINK_CODE_LOV;

	private HtmlSimpleTogglePanel COMP_Claim_Panel;
	private HtmlSimpleTogglePanel COMP_Cancellation_Details;

	ArrayList<SelectItem> DS_USE_SEQ_YN_ARRAYLIST;
	ArrayList<SelectItem> DS_CURR_RATE_BS_ARRAYLIST;
	ArrayList<SelectItem> DS_POST_BO_ARRAYLIST;
	ArrayList<SelectItem> DS_BROKER_YN_ARRAYLIST;
	ArrayList<SelectItem> DS_PRN_BEFORE_APPR_ARRAYLIST;
	ArrayList<SelectItem> DS_REPRINT_YN_ARRAYLIST;
	ArrayList<SelectItem> DS_AGE_RECALC_YN_ARRAYLIST;
	ArrayList<SelectItem> DS_FUND_TYPE_ARRAYLIST;
	ArrayList<SelectItem> DS_REFUND_PREM_FLAG_ARRAYLIST;
	ArrayList<SelectItem> DS_REFUND_SURPLUS_FLAG_ARRAYLIST;
	ArrayList<SelectItem> DS_REFUND_DEP_FLAG_ARRAYLIST;
	ArrayList<SelectItem> DS_RECVR_CHRG_FLAG_ARRAYLIST;
	ArrayList<SelectItem> DS_RECVR_MEDFEE_YN_ARRAYLIST;
	ArrayList<SelectItem> DS_RECVR_COMM_FLAG_ARRAYLIST;
	private List dsTypeList;
	private List endtypeList;
	private List linkCodeList;
	private List partSettleList;
	private List fullSettleList;

	private PM_IL_DOC_SETUP PM_IL_DOC_SETUP_BEAN;
	PM_IL_DOC_ACTION_DELEGATE pm_il_doc_action_delegate = null;
	private PM_IL_DOC_SETUP_HELPER pm_il_doc_setup_helper = null;
	
	public PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeAction;

	private ControlBean controlBean = null;

	private boolean isRendered = false;

	private CommonUtils commonUtils;

	Map<String, Object> session = null;

	public PM_IL_DOC_SETUP_ACTION() {
		controlBean = new ControlBean();

		resetAllComponent();

		PM_IL_DOC_SETUP_BEAN = new PM_IL_DOC_SETUP();
		pm_il_doc_action_delegate = new PM_IL_DOC_ACTION_DELEGATE();
		pm_il_doc_setup_helper = new PM_IL_DOC_SETUP_HELPER();
		PM_IL_DOC_SETUP_BEAN.setUI_M_CALC_METHOD("1");
		PM_IL_DOC_SETUP_BEAN.setRendered(false);

		DS_USE_SEQ_YN_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_USE_SEQ_YN);
		DS_CURR_RATE_BS_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_CURR_RATE_BS);
		DS_POST_BO_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_POST_BO);
		DS_BROKER_YN_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_BROKER_YN);
		DS_PRN_BEFORE_APPR_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_PRN_BEFORE_APPR);
		DS_REPRINT_YN_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_REPRINT_YN);
		DS_AGE_RECALC_YN_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_AGE_RECALC_YN);

		DS_FUND_TYPE_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_FUND_TYPE);
		DS_REFUND_PREM_FLAG_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_REFUND_PREM_FLAG);
		DS_REFUND_SURPLUS_FLAG_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_REFUND_SURPLUS_FLAG);
		DS_REFUND_DEP_FLAG_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_REFUND_DEP_FLAG);
		DS_RECVR_CHRG_FLAG_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_RECVR_CHRG_FLAG);
		DS_RECVR_MEDFEE_YN_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_RECVR_MEDFEE_YN);
		DS_RECVR_COMM_FLAG_ARRAYLIST = pm_il_doc_action_delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DS_RECVR_COMM_FLAG);

		/*pm_il_doc_setup_helper.setCANCELLATION_DETAILS_BLOCK_ENABLE(true, this);
		pm_il_doc_setup_helper.setCLAIM_DETAILS_BLOCK_ENABLED(true, this);*/

	}

	public HtmlOutputLabel getCOMP_DS_TYPE_LABEL() {
		return COMP_DS_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_DS_TYPE() {
		return COMP_DS_TYPE;
	}

	public void setCOMP_DS_TYPE_LABEL(HtmlOutputLabel COMP_DS_TYPE_LABEL) {
		this.COMP_DS_TYPE_LABEL = COMP_DS_TYPE_LABEL;
	}

	public void setCOMP_DS_TYPE(HtmlInputText COMP_DS_TYPE) {
		this.COMP_DS_TYPE = COMP_DS_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DS_TYPE_DESC_LABEL() {
		return COMP_UI_M_DS_TYPE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DS_TYPE_DESC() {
		return COMP_UI_M_DS_TYPE_DESC;
	}

	public void setCOMP_UI_M_DS_TYPE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DS_TYPE_DESC_LABEL) {
		this.COMP_UI_M_DS_TYPE_DESC_LABEL = COMP_UI_M_DS_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DS_TYPE_DESC(HtmlInputText COMP_UI_M_DS_TYPE_DESC) {
		this.COMP_UI_M_DS_TYPE_DESC = COMP_UI_M_DS_TYPE_DESC;
	}

	public HtmlOutputLabel getCOMP_DS_END_TYPE_LABEL() {
		return COMP_DS_END_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_DS_END_TYPE() {
		return COMP_DS_END_TYPE;
	}

	public void setCOMP_DS_END_TYPE_LABEL(HtmlOutputLabel COMP_DS_END_TYPE_LABEL) {
		this.COMP_DS_END_TYPE_LABEL = COMP_DS_END_TYPE_LABEL;
	}

	public void setCOMP_DS_END_TYPE(HtmlInputText COMP_DS_END_TYPE) {
		this.COMP_DS_END_TYPE = COMP_DS_END_TYPE;
	}

	public HtmlOutputLabel getCOMP_DS_CODE_LABEL() {
		return COMP_DS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DS_CODE() {
		return COMP_DS_CODE;
	}

	public void setCOMP_DS_CODE_LABEL(HtmlOutputLabel COMP_DS_CODE_LABEL) {
		this.COMP_DS_CODE_LABEL = COMP_DS_CODE_LABEL;
	}

	public void setCOMP_DS_CODE(HtmlInputText COMP_DS_CODE) {
		this.COMP_DS_CODE = COMP_DS_CODE;
	}

	public HtmlOutputLabel getCOMP_DS_DESC_LABEL() {
		return COMP_DS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DS_DESC() {
		return COMP_DS_DESC;
	}

	public void setCOMP_DS_DESC_LABEL(HtmlOutputLabel COMP_DS_DESC_LABEL) {
		this.COMP_DS_DESC_LABEL = COMP_DS_DESC_LABEL;
	}

	public void setCOMP_DS_DESC(HtmlInputText COMP_DS_DESC) {
		this.COMP_DS_DESC = COMP_DS_DESC;
	}

	public HtmlOutputLabel getCOMP_DS_POL_CODE_LABEL() {
		return COMP_DS_POL_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DS_POL_CODE() {
		return COMP_DS_POL_CODE;
	}

	public void setCOMP_DS_POL_CODE_LABEL(HtmlOutputLabel COMP_DS_POL_CODE_LABEL) {
		this.COMP_DS_POL_CODE_LABEL = COMP_DS_POL_CODE_LABEL;
	}

	public void setCOMP_DS_POL_CODE(HtmlInputText COMP_DS_POL_CODE) {
		this.COMP_DS_POL_CODE = COMP_DS_POL_CODE;
	}

	public HtmlOutputLabel getCOMP_DS_SHORT_DESC_LABEL() {
		return COMP_DS_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DS_SHORT_DESC() {
		return COMP_DS_SHORT_DESC;
	}

	public void setCOMP_DS_SHORT_DESC_LABEL(
			HtmlOutputLabel COMP_DS_SHORT_DESC_LABEL) {
		this.COMP_DS_SHORT_DESC_LABEL = COMP_DS_SHORT_DESC_LABEL;
	}

	public void setCOMP_DS_SHORT_DESC(HtmlInputText COMP_DS_SHORT_DESC) {
		this.COMP_DS_SHORT_DESC = COMP_DS_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_DS_USE_SEQ_YN_LABEL() {
		return COMP_DS_USE_SEQ_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_USE_SEQ_YN() {
		return COMP_DS_USE_SEQ_YN;
	}

	public void setCOMP_DS_USE_SEQ_YN_LABEL(
			HtmlOutputLabel COMP_DS_USE_SEQ_YN_LABEL) {
		this.COMP_DS_USE_SEQ_YN_LABEL = COMP_DS_USE_SEQ_YN_LABEL;
	}

	public void setCOMP_DS_USE_SEQ_YN(HtmlSelectOneMenu COMP_DS_USE_SEQ_YN) {
		this.COMP_DS_USE_SEQ_YN = COMP_DS_USE_SEQ_YN;
	}

	public HtmlOutputLabel getCOMP_DS_CURR_RATE_BS_LABEL() {
		return COMP_DS_CURR_RATE_BS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_CURR_RATE_BS() {
		return COMP_DS_CURR_RATE_BS;
	}

	public void setCOMP_DS_CURR_RATE_BS_LABEL(
			HtmlOutputLabel COMP_DS_CURR_RATE_BS_LABEL) {
		this.COMP_DS_CURR_RATE_BS_LABEL = COMP_DS_CURR_RATE_BS_LABEL;
	}

	public void setCOMP_DS_CURR_RATE_BS(HtmlSelectOneMenu COMP_DS_CURR_RATE_BS) {
		this.COMP_DS_CURR_RATE_BS = COMP_DS_CURR_RATE_BS;
	}

	public HtmlOutputLabel getCOMP_DS_EFF_FM_DT_LABEL() {
		return COMP_DS_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DS_EFF_FM_DT() {
		return COMP_DS_EFF_FM_DT;
	}

	public void setCOMP_DS_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_DS_EFF_FM_DT_LABEL) {
		this.COMP_DS_EFF_FM_DT_LABEL = COMP_DS_EFF_FM_DT_LABEL;
	}

	public void setCOMP_DS_EFF_FM_DT(HtmlCalendar COMP_DS_EFF_FM_DT) {
		this.COMP_DS_EFF_FM_DT = COMP_DS_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_DS_EFF_TO_DT_LABEL() {
		return COMP_DS_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DS_EFF_TO_DT() {
		return COMP_DS_EFF_TO_DT;
	}

	public void setCOMP_DS_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_DS_EFF_TO_DT_LABEL) {
		this.COMP_DS_EFF_TO_DT_LABEL = COMP_DS_EFF_TO_DT_LABEL;
	}

	public void setCOMP_DS_EFF_TO_DT(HtmlCalendar COMP_DS_EFF_TO_DT) {
		this.COMP_DS_EFF_TO_DT = COMP_DS_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_DS_POST_BO_LABEL() {
		return COMP_DS_POST_BO_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_POST_BO() {
		return COMP_DS_POST_BO;
	}

	public void setCOMP_DS_POST_BO_LABEL(HtmlOutputLabel COMP_DS_POST_BO_LABEL) {
		this.COMP_DS_POST_BO_LABEL = COMP_DS_POST_BO_LABEL;
	}

	public void setCOMP_DS_POST_BO(HtmlSelectOneMenu COMP_DS_POST_BO) {
		this.COMP_DS_POST_BO = COMP_DS_POST_BO;
	}

	public HtmlOutputLabel getCOMP_DS_BROKER_YN_LABEL() {
		return COMP_DS_BROKER_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_BROKER_YN() {
		return COMP_DS_BROKER_YN;
	}

	public void setCOMP_DS_BROKER_YN_LABEL(
			HtmlOutputLabel COMP_DS_BROKER_YN_LABEL) {
		this.COMP_DS_BROKER_YN_LABEL = COMP_DS_BROKER_YN_LABEL;
	}

	public void setCOMP_DS_BROKER_YN(HtmlSelectOneMenu COMP_DS_BROKER_YN) {
		this.COMP_DS_BROKER_YN = COMP_DS_BROKER_YN;
	}

	public HtmlOutputLabel getCOMP_DS_PRN_BEFORE_APPR_LABEL() {
		return COMP_DS_PRN_BEFORE_APPR_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_PRN_BEFORE_APPR() {
		return COMP_DS_PRN_BEFORE_APPR;
	}

	public void setCOMP_DS_PRN_BEFORE_APPR_LABEL(
			HtmlOutputLabel COMP_DS_PRN_BEFORE_APPR_LABEL) {
		this.COMP_DS_PRN_BEFORE_APPR_LABEL = COMP_DS_PRN_BEFORE_APPR_LABEL;
	}

	public void setCOMP_DS_PRN_BEFORE_APPR(
			HtmlSelectOneMenu COMP_DS_PRN_BEFORE_APPR) {
		this.COMP_DS_PRN_BEFORE_APPR = COMP_DS_PRN_BEFORE_APPR;
	}

	public HtmlOutputLabel getCOMP_DS_REPRINT_YN_LABEL() {
		return COMP_DS_REPRINT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_REPRINT_YN() {
		return COMP_DS_REPRINT_YN;
	}

	public void setCOMP_DS_REPRINT_YN_LABEL(
			HtmlOutputLabel COMP_DS_REPRINT_YN_LABEL) {
		this.COMP_DS_REPRINT_YN_LABEL = COMP_DS_REPRINT_YN_LABEL;
	}

	public void setCOMP_DS_REPRINT_YN(HtmlSelectOneMenu COMP_DS_REPRINT_YN) {
		this.COMP_DS_REPRINT_YN = COMP_DS_REPRINT_YN;
	}

	public HtmlOutputLabel getCOMP_DS_AGE_RECALC_YN_LABEL() {
		return COMP_DS_AGE_RECALC_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_AGE_RECALC_YN() {
		return COMP_DS_AGE_RECALC_YN;
	}

	public void setCOMP_DS_AGE_RECALC_YN_LABEL(
			HtmlOutputLabel COMP_DS_AGE_RECALC_YN_LABEL) {
		this.COMP_DS_AGE_RECALC_YN_LABEL = COMP_DS_AGE_RECALC_YN_LABEL;
	}

	public void setCOMP_DS_AGE_RECALC_YN(HtmlSelectOneMenu COMP_DS_AGE_RECALC_YN) {
		this.COMP_DS_AGE_RECALC_YN = COMP_DS_AGE_RECALC_YN;
	}

	public HtmlOutputLabel getCOMP_DS_BL_DESC_LABEL() {
		return COMP_DS_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DS_BL_DESC() {
		return COMP_DS_BL_DESC;
	}

	public void setCOMP_DS_BL_DESC_LABEL(HtmlOutputLabel COMP_DS_BL_DESC_LABEL) {
		this.COMP_DS_BL_DESC_LABEL = COMP_DS_BL_DESC_LABEL;
	}

	public void setCOMP_DS_BL_DESC(HtmlInputText COMP_DS_BL_DESC) {
		this.COMP_DS_BL_DESC = COMP_DS_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_DS_BL_SHORT_DESC_LABEL() {
		return COMP_DS_BL_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DS_BL_SHORT_DESC() {
		return COMP_DS_BL_SHORT_DESC;
	}

	public void setCOMP_DS_BL_SHORT_DESC_LABEL(
			HtmlOutputLabel COMP_DS_BL_SHORT_DESC_LABEL) {
		this.COMP_DS_BL_SHORT_DESC_LABEL = COMP_DS_BL_SHORT_DESC_LABEL;
	}

	public void setCOMP_DS_BL_SHORT_DESC(HtmlInputText COMP_DS_BL_SHORT_DESC) {
		this.COMP_DS_BL_SHORT_DESC = COMP_DS_BL_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_DS_FUND_TYPE_LABEL() {
		return COMP_DS_FUND_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_FUND_TYPE() {
		return COMP_DS_FUND_TYPE;
	}

	public void setCOMP_DS_FUND_TYPE_LABEL(
			HtmlOutputLabel COMP_DS_FUND_TYPE_LABEL) {
		this.COMP_DS_FUND_TYPE_LABEL = COMP_DS_FUND_TYPE_LABEL;
	}

	public void setCOMP_DS_FUND_TYPE(HtmlSelectOneMenu COMP_DS_FUND_TYPE) {
		this.COMP_DS_FUND_TYPE = COMP_DS_FUND_TYPE;
	}

	public HtmlOutputLabel getCOMP_DS_REFUND_PREM_FLAG_LABEL() {
		return COMP_DS_REFUND_PREM_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_REFUND_PREM_FLAG() {
		return COMP_DS_REFUND_PREM_FLAG;
	}

	public void setCOMP_DS_REFUND_PREM_FLAG_LABEL(
			HtmlOutputLabel COMP_DS_REFUND_PREM_FLAG_LABEL) {
		this.COMP_DS_REFUND_PREM_FLAG_LABEL = COMP_DS_REFUND_PREM_FLAG_LABEL;
	}

	public void setCOMP_DS_REFUND_PREM_FLAG(
			HtmlSelectOneMenu COMP_DS_REFUND_PREM_FLAG) {
		this.COMP_DS_REFUND_PREM_FLAG = COMP_DS_REFUND_PREM_FLAG;
	}

	public HtmlOutputLabel getCOMP_DS_REFUND_SURPLUS_FLAG_LABEL() {
		return COMP_DS_REFUND_SURPLUS_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_REFUND_SURPLUS_FLAG() {
		return COMP_DS_REFUND_SURPLUS_FLAG;
	}

	public void setCOMP_DS_REFUND_SURPLUS_FLAG_LABEL(
			HtmlOutputLabel COMP_DS_REFUND_SURPLUS_FLAG_LABEL) {
		this.COMP_DS_REFUND_SURPLUS_FLAG_LABEL = COMP_DS_REFUND_SURPLUS_FLAG_LABEL;
	}

	public void setCOMP_DS_REFUND_SURPLUS_FLAG(
			HtmlSelectOneMenu COMP_DS_REFUND_SURPLUS_FLAG) {
		this.COMP_DS_REFUND_SURPLUS_FLAG = COMP_DS_REFUND_SURPLUS_FLAG;
	}

	public HtmlOutputLabel getCOMP_DS_REFUND_DEP_FLAG_LABEL() {
		return COMP_DS_REFUND_DEP_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_REFUND_DEP_FLAG() {
		return COMP_DS_REFUND_DEP_FLAG;
	}

	public void setCOMP_DS_REFUND_DEP_FLAG_LABEL(
			HtmlOutputLabel COMP_DS_REFUND_DEP_FLAG_LABEL) {
		this.COMP_DS_REFUND_DEP_FLAG_LABEL = COMP_DS_REFUND_DEP_FLAG_LABEL;
	}

	public void setCOMP_DS_REFUND_DEP_FLAG(
			HtmlSelectOneMenu COMP_DS_REFUND_DEP_FLAG) {
		this.COMP_DS_REFUND_DEP_FLAG = COMP_DS_REFUND_DEP_FLAG;
	}

	public HtmlOutputLabel getCOMP_DS_RECVR_CHRG_FLAG_LABEL() {
		return COMP_DS_RECVR_CHRG_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_RECVR_CHRG_FLAG() {
		return COMP_DS_RECVR_CHRG_FLAG;
	}

	public void setCOMP_DS_RECVR_CHRG_FLAG_LABEL(
			HtmlOutputLabel COMP_DS_RECVR_CHRG_FLAG_LABEL) {
		this.COMP_DS_RECVR_CHRG_FLAG_LABEL = COMP_DS_RECVR_CHRG_FLAG_LABEL;
	}

	public void setCOMP_DS_RECVR_CHRG_FLAG(
			HtmlSelectOneMenu COMP_DS_RECVR_CHRG_FLAG) {
		this.COMP_DS_RECVR_CHRG_FLAG = COMP_DS_RECVR_CHRG_FLAG;
	}

	public HtmlOutputLabel getCOMP_DS_RECVR_MEDFEE_YN_LABEL() {
		return COMP_DS_RECVR_MEDFEE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_RECVR_MEDFEE_YN() {
		return COMP_DS_RECVR_MEDFEE_YN;
	}

	public void setCOMP_DS_RECVR_MEDFEE_YN_LABEL(
			HtmlOutputLabel COMP_DS_RECVR_MEDFEE_YN_LABEL) {
		this.COMP_DS_RECVR_MEDFEE_YN_LABEL = COMP_DS_RECVR_MEDFEE_YN_LABEL;
	}

	public void setCOMP_DS_RECVR_MEDFEE_YN(
			HtmlSelectOneMenu COMP_DS_RECVR_MEDFEE_YN) {
		this.COMP_DS_RECVR_MEDFEE_YN = COMP_DS_RECVR_MEDFEE_YN;
	}

	public HtmlOutputLabel getCOMP_DS_RECVR_COMM_FLAG_LABEL() {
		return COMP_DS_RECVR_COMM_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DS_RECVR_COMM_FLAG() {
		return COMP_DS_RECVR_COMM_FLAG;
	}

	public void setCOMP_DS_RECVR_COMM_FLAG_LABEL(
			HtmlOutputLabel COMP_DS_RECVR_COMM_FLAG_LABEL) {
		this.COMP_DS_RECVR_COMM_FLAG_LABEL = COMP_DS_RECVR_COMM_FLAG_LABEL;
	}

	public void setCOMP_DS_RECVR_COMM_FLAG(
			HtmlSelectOneMenu COMP_DS_RECVR_COMM_FLAG) {
		this.COMP_DS_RECVR_COMM_FLAG = COMP_DS_RECVR_COMM_FLAG;
	}

	public HtmlOutputLabel getCOMP_DS_CLM_PARSET_LABEL() {
		return COMP_DS_CLM_PARSET_LABEL;
	}

	public HtmlInputText getCOMP_DS_CLM_PARSET() {
		return COMP_DS_CLM_PARSET;
	}

	public void setCOMP_DS_CLM_PARSET_LABEL(
			HtmlOutputLabel COMP_DS_CLM_PARSET_LABEL) {
		this.COMP_DS_CLM_PARSET_LABEL = COMP_DS_CLM_PARSET_LABEL;
	}

	public void setCOMP_DS_CLM_PARSET(HtmlInputText COMP_DS_CLM_PARSET) {
		this.COMP_DS_CLM_PARSET = COMP_DS_CLM_PARSET;
	}

	public HtmlOutputLabel getCOMP_UI_M_DS_CLM_PARSET_DESC_LABEL() {
		return COMP_UI_M_DS_CLM_PARSET_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DS_CLM_PARSET_DESC() {
		return COMP_UI_M_DS_CLM_PARSET_DESC;
	}

	public void setCOMP_UI_M_DS_CLM_PARSET_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DS_CLM_PARSET_DESC_LABEL) {
		this.COMP_UI_M_DS_CLM_PARSET_DESC_LABEL = COMP_UI_M_DS_CLM_PARSET_DESC_LABEL;
	}

	public void setCOMP_UI_M_DS_CLM_PARSET_DESC(
			HtmlInputText COMP_UI_M_DS_CLM_PARSET_DESC) {
		this.COMP_UI_M_DS_CLM_PARSET_DESC = COMP_UI_M_DS_CLM_PARSET_DESC;
	}

	public HtmlOutputLabel getCOMP_DS_CLM_FULSET_LABEL() {
		return COMP_DS_CLM_FULSET_LABEL;
	}

	public HtmlInputText getCOMP_DS_CLM_FULSET() {
		return COMP_DS_CLM_FULSET;
	}

	public void setCOMP_DS_CLM_FULSET_LABEL(
			HtmlOutputLabel COMP_DS_CLM_FULSET_LABEL) {
		this.COMP_DS_CLM_FULSET_LABEL = COMP_DS_CLM_FULSET_LABEL;
	}

	public void setCOMP_DS_CLM_FULSET(HtmlInputText COMP_DS_CLM_FULSET) {
		this.COMP_DS_CLM_FULSET = COMP_DS_CLM_FULSET;
	}

	public HtmlOutputLabel getCOMP_UI_M_DS_CLM_FULSET_DESC_LABEL() {
		return COMP_UI_M_DS_CLM_FULSET_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DS_CLM_FULSET_DESC() {
		return COMP_UI_M_DS_CLM_FULSET_DESC;
	}

	public void setCOMP_UI_M_DS_CLM_FULSET_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DS_CLM_FULSET_DESC_LABEL) {
		this.COMP_UI_M_DS_CLM_FULSET_DESC_LABEL = COMP_UI_M_DS_CLM_FULSET_DESC_LABEL;
	}

	public void setCOMP_UI_M_DS_CLM_FULSET_DESC(
			HtmlInputText COMP_UI_M_DS_CLM_FULSET_DESC) {
		this.COMP_UI_M_DS_CLM_FULSET_DESC = COMP_UI_M_DS_CLM_FULSET_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BILINGUAL() {
		return COMP_UI_M_BUT_BILINGUAL;
	}

	public void setCOMP_UI_M_BUT_BILINGUAL(
			HtmlCommandButton COMP_UI_M_BUT_BILINGUAL) {
		this.COMP_UI_M_BUT_BILINGUAL = COMP_UI_M_BUT_BILINGUAL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANC() {
		return COMP_UI_M_BUT_CANC;
	}

	public void setCOMP_UI_M_BUT_CANC(HtmlCommandButton COMP_UI_M_BUT_CANC) {
		this.COMP_UI_M_BUT_CANC = COMP_UI_M_BUT_CANC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLAIM() {
		return COMP_UI_M_BUT_CLAIM;
	}

	public void setCOMP_UI_M_BUT_CLAIM(HtmlCommandButton COMP_UI_M_BUT_CLAIM) {
		this.COMP_UI_M_BUT_CLAIM = COMP_UI_M_BUT_CLAIM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DS_TYPE_LOV() {
		return COMP_UI_M_BUT_DS_TYPE_LOV;
	}

	public void setCOMP_UI_M_BUT_DS_TYPE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DS_TYPE_LOV) {
		this.COMP_UI_M_BUT_DS_TYPE_LOV = COMP_UI_M_BUT_DS_TYPE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ENDT_TYPE_LOV() {
		return COMP_UI_M_BUT_ENDT_TYPE_LOV;
	}

	public void setCOMP_UI_M_BUT_ENDT_TYPE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_ENDT_TYPE_LOV) {
		this.COMP_UI_M_BUT_ENDT_TYPE_LOV = COMP_UI_M_BUT_ENDT_TYPE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_LINK_CODE_LOV() {
		return COMP_UI_M_BUT_POL_LINK_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_POL_LINK_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_POL_LINK_CODE_LOV) {
		this.COMP_UI_M_BUT_POL_LINK_CODE_LOV = COMP_UI_M_BUT_POL_LINK_CODE_LOV;
	}

	public PM_IL_DOC_SETUP getPM_IL_DOC_SETUP_BEAN() {
		return PM_IL_DOC_SETUP_BEAN;
	}

	public void setPM_IL_DOC_SETUP_BEAN(PM_IL_DOC_SETUP PM_IL_DOC_SETUP_BEAN) {
		this.PM_IL_DOC_SETUP_BEAN = PM_IL_DOC_SETUP_BEAN;
	}

	public ArrayList<SelectItem> getDS_USE_SEQ_YN_ARRAYLIST() {
		return DS_USE_SEQ_YN_ARRAYLIST;
	}

	public void setDS_USE_SEQ_YN_ARRAYLIST(
			ArrayList<SelectItem> ds_use_seq_yn_arraylist) {
		DS_USE_SEQ_YN_ARRAYLIST = ds_use_seq_yn_arraylist;
	}

	public ArrayList<SelectItem> getDS_CURR_RATE_BS_ARRAYLIST() {
		return DS_CURR_RATE_BS_ARRAYLIST;
	}

	public void setDS_CURR_RATE_BS_ARRAYLIST(
			ArrayList<SelectItem> ds_curr_rate_bs_arraylist) {
		DS_CURR_RATE_BS_ARRAYLIST = ds_curr_rate_bs_arraylist;
	}

	public ArrayList<SelectItem> getDS_POST_BO_ARRAYLIST() {
		return DS_POST_BO_ARRAYLIST;
	}

	public void setDS_POST_BO_ARRAYLIST(
			ArrayList<SelectItem> ds_post_bo_arraylist) {
		DS_POST_BO_ARRAYLIST = ds_post_bo_arraylist;
	}

	public ArrayList<SelectItem> getDS_BROKER_YN_ARRAYLIST() {
		return DS_BROKER_YN_ARRAYLIST;
	}

	public void setDS_BROKER_YN_ARRAYLIST(
			ArrayList<SelectItem> ds_broker_yn_arraylist) {
		DS_BROKER_YN_ARRAYLIST = ds_broker_yn_arraylist;
	}

	public ArrayList<SelectItem> getDS_PRN_BEFORE_APPR_ARRAYLIST() {
		return DS_PRN_BEFORE_APPR_ARRAYLIST;
	}

	public void setDS_PRN_BEFORE_APPR_ARRAYLIST(
			ArrayList<SelectItem> ds_prn_before_appr_arraylist) {
		DS_PRN_BEFORE_APPR_ARRAYLIST = ds_prn_before_appr_arraylist;
	}

	public ArrayList<SelectItem> getDS_REPRINT_YN_ARRAYLIST() {
		return DS_REPRINT_YN_ARRAYLIST;
	}

	public void setDS_REPRINT_YN_ARRAYLIST(
			ArrayList<SelectItem> ds_reprint_yn_arraylist) {
		DS_REPRINT_YN_ARRAYLIST = ds_reprint_yn_arraylist;
	}

	public ArrayList<SelectItem> getDS_AGE_RECALC_YN_ARRAYLIST() {
		return DS_AGE_RECALC_YN_ARRAYLIST;
	}

	public void setDS_AGE_RECALC_YN_ARRAYLIST(
			ArrayList<SelectItem> ds_age_recalc_yn_arraylist) {
		DS_AGE_RECALC_YN_ARRAYLIST = ds_age_recalc_yn_arraylist;
	}

	public ArrayList<SelectItem> getDS_FUND_TYPE_ARRAYLIST() {
		return DS_FUND_TYPE_ARRAYLIST;
	}

	public void setDS_FUND_TYPE_ARRAYLIST(
			ArrayList<SelectItem> ds_fund_type_arraylist) {
		DS_FUND_TYPE_ARRAYLIST = ds_fund_type_arraylist;
	}

	public ArrayList<SelectItem> getDS_REFUND_PREM_FLAG_ARRAYLIST() {
		return DS_REFUND_PREM_FLAG_ARRAYLIST;
	}

	public void setDS_REFUND_PREM_FLAG_ARRAYLIST(
			ArrayList<SelectItem> ds_refund_prem_flag_arraylist) {
		DS_REFUND_PREM_FLAG_ARRAYLIST = ds_refund_prem_flag_arraylist;
	}

	public ArrayList<SelectItem> getDS_REFUND_SURPLUS_FLAG_ARRAYLIST() {
		return DS_REFUND_SURPLUS_FLAG_ARRAYLIST;
	}

	public void setDS_REFUND_SURPLUS_FLAG_ARRAYLIST(
			ArrayList<SelectItem> ds_refund_surplus_flag_arraylist) {
		DS_REFUND_SURPLUS_FLAG_ARRAYLIST = ds_refund_surplus_flag_arraylist;
	}

	public ArrayList<SelectItem> getDS_REFUND_DEP_FLAG_ARRAYLIST() {
		return DS_REFUND_DEP_FLAG_ARRAYLIST;
	}

	public void setDS_REFUND_DEP_FLAG_ARRAYLIST(
			ArrayList<SelectItem> ds_refund_dep_flag_arraylist) {
		DS_REFUND_DEP_FLAG_ARRAYLIST = ds_refund_dep_flag_arraylist;
	}

	public ArrayList<SelectItem> getDS_RECVR_CHRG_FLAG_ARRAYLIST() {
		return DS_RECVR_CHRG_FLAG_ARRAYLIST;
	}

	public void setDS_RECVR_CHRG_FLAG_ARRAYLIST(
			ArrayList<SelectItem> ds_recvr_chrg_flag_arraylist) {
		DS_RECVR_CHRG_FLAG_ARRAYLIST = ds_recvr_chrg_flag_arraylist;
	}

	public ArrayList<SelectItem> getDS_RECVR_MEDFEE_YN_ARRAYLIST() {
		return DS_RECVR_MEDFEE_YN_ARRAYLIST;
	}

	public void setDS_RECVR_MEDFEE_YN_ARRAYLIST(
			ArrayList<SelectItem> ds_recvr_medfee_yn_arraylist) {
		DS_RECVR_MEDFEE_YN_ARRAYLIST = ds_recvr_medfee_yn_arraylist;
	}

	public ArrayList<SelectItem> getDS_RECVR_COMM_FLAG_ARRAYLIST() {
		return DS_RECVR_COMM_FLAG_ARRAYLIST;
	}

	public void setDS_RECVR_COMM_FLAG_ARRAYLIST(
			ArrayList<SelectItem> ds_recvr_comm_flag_arraylist) {
		DS_RECVR_COMM_FLAG_ARRAYLIST = ds_recvr_comm_flag_arraylist;
	}

	public int executeInsertion() {
		pm_il_doc_action_delegate = new PM_IL_DOC_ACTION_DELEGATE();
		PM_IL_DOC_SETUP_BEAN.setDS_FRZ_FLAG("N");
		int rowupdated = 0;
		System.out.println("FRM DATE::::::"
				+ PM_IL_DOC_SETUP_BEAN.getDS_EFF_FM_DT() + " TO DATE::::::::"
				+ PM_IL_DOC_SETUP_BEAN.getDS_EFF_TO_DT());
		try {
			if (PM_IL_DOC_SETUP_BEAN.getROWID() == null) {
				WHEN_NEW_RECORD_INSTANCE();
				pm_il_doc_setup_helper.PRE_INSERT(this);

				rowupdated = pm_il_doc_action_delegate
						.insertDocumentSetupDetails(PM_IL_DOC_SETUP_BEAN);
				if (rowupdated > 0) {
					getErrorMap().clear();
					/*getWarningMap().put("somekey",
							rowupdated + " record inserted.");
					getWarningMap().put("current",
							rowupdated + " record inserted.");*/
					getWarningMap().put(
							"current",
							Messages.getString(
									PELConstants.pelErrorMessagePath,
									"SAVE_MESSAGE"));
					getWarningMap().put(
							"somekey",
							Messages.getString(
									PELConstants.pelErrorMessagePath,
									"SAVE_MESSAGE"));
				}
			} else {
				PRE_UPDATE();
				rowupdated = pm_il_doc_action_delegate
						.insertDocumentSetupDetails(PM_IL_DOC_SETUP_BEAN);
				if (rowupdated > 0) {
					getErrorMap().clear();
					/*getWarningMap().put("somekey",
							rowupdated + " record updated.");
					getWarningMap().put("current",
							rowupdated + " record updated.");*/
					getWarningMap().put(
							"current",
							Messages.getString(
									PELConstants.pelErrorMessagePath,
									"UPDATE_MESSAGE"));
					getWarningMap().put(
							"somekey",
							Messages.getString(
									PELConstants.pelErrorMessagePath,
									"UPDATE_MESSAGE"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("update", rowupdated + " record NOT updated.");
			getErrorMap().put("current", rowupdated + " record NOT updated.");
		}
		return 0;
	}

	public void validateDS_TYPE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		try{
			pm_il_doc_setup_helper.DS_TYPE_WHEN_VALIDATE_ITEM(value.toString(), this);
		}catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	public void validateDS_END_TYPE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		UIInput input = (UIInput) component;
		pm_il_doc_setup_helper.DS_END_TYPE_WHEN_VALIDATE_ITEM(input
				.getSubmittedValue(), this);
	}

	public void validateDS_CODE(FacesContext fc, UIComponent component,
			Object value) {
		   UIInput input = (UIInput) component;
			try {
				if (PM_IL_DOC_SETUP_BEAN.getROWID() == null) {
				pm_il_doc_setup_helper.DS_CODE_WHEN_VALIDATE_ITEM(input
						.getSubmittedValue(), this);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e
	    				.getMessage()));
			}
			finally {
	    		try {
	    			ErrorHelpUtil.getWarningForProcedure(CommonUtils
	    					.getConnection(), "POL_WAQAF_PERIOD_FM",
	    					getWarningMap());
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    	}
		}

	public void validateDS_SHORT_DESC(ActionEvent event) {
		if (PM_IL_DOC_SETUP_BEAN.getDS_BL_SHORT_DESC() == null) {
			if (COMP_DS_DESC.getSubmittedValue().toString().length() > 15) {
				COMP_DS_SHORT_DESC.setSubmittedValue(StringFunctions.substr(
						COMP_DS_DESC.getSubmittedValue().toString(), 1, 15));
			} else {
				COMP_DS_SHORT_DESC.setSubmittedValue(COMP_DS_DESC
						.getSubmittedValue());
			}
		}
	}

	public void validateDS_POL_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		UIInput input = (UIInput) component;
		pm_il_doc_setup_helper.DS_POL_CODE_WHEN_VALIDATE_ITEM(input
				.getSubmittedValue(), this);
	}

	public void validateDS_USE_SEQ_YN(ActionEvent event) {

		UIInput input = (UIInput) event.getComponent().getParent();
		if (input.getSubmittedValue() != null) {
			PM_IL_DOC_SETUP_BEAN.setDS_USE_SEQ_YN(input.getSubmittedValue()
					.toString());
			if (input.getSubmittedValue().toString().equalsIgnoreCase("Y")) {
				getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
						.getPM_IL_DOC_NO_RANGE_BEAN().setCurrNodisabled(false);
				getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
						.getPM_IL_DOC_NO_RANGE_BEAN().setSegNameDisabled(false);
				//getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN().getCOMP_DNR_CURR_NO().setDisabled(true);
				//getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN().getCOMP_DNR_SEQ_NAME().setDisabled(false);

			} else {
				getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
						.getPM_IL_DOC_NO_RANGE_BEAN().setCurrNodisabled(false);
				getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
						.getPM_IL_DOC_NO_RANGE_BEAN().setSegNameDisabled(true);
				//getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN().getCOMP_DNR_CURR_NO().setDisabled(true);
				//getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN().getCOMP_DNR_SEQ_NAME().setDisabled(true);

			}
		}
	}

	public void validateDS_CLM_PARSET(ActionEvent event) {
		try {
			pm_il_doc_setup_helper.DS_CLM_PARSET_WHEN_VALIDATE_ITEM(this);
		} catch (Exception e) {
			getErrorMap().put("update", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
	}

	public void validateDS_CLM_FULSET(ActionEvent event) {
		try {
			pm_il_doc_setup_helper.DS_CLM_FULSET_WHEN_VALIDATE_ITEM(this);
		} catch (Exception e) {
			getErrorMap().put("update", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
	}

	/* CANCELLATION BLOCK VALIDATIONS */
	public void validateDS_REFUND_PREM_FLAG(ActionEvent event) {
		if (COMP_DS_REFUND_PREM_FLAG.getSubmittedValue().toString()
				.equalsIgnoreCase("N")) {
			COMP_DS_REFUND_DEP_FLAG.setSubmittedValue("N");
			COMP_DS_RECVR_MEDFEE_YN.setSubmittedValue("N");
			COMP_DS_RECVR_CHRG_FLAG.setSubmittedValue("N");
			COMP_DS_REFUND_DEP_FLAG.setDisabled(true);
			COMP_DS_RECVR_MEDFEE_YN.setDisabled(true);
			COMP_DS_RECVR_CHRG_FLAG.setDisabled(true);

		} else {

			COMP_DS_REFUND_DEP_FLAG.setDisabled(false);
			COMP_DS_RECVR_MEDFEE_YN.setDisabled(false);
			COMP_DS_RECVR_CHRG_FLAG.setDisabled(false);

		}
	}

	public void validateDS_EFF_FM_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		HtmlCalendar htmlCalendar = (HtmlCalendar) component;
		Date fromDate = htmlCalendar
				.getAsDate(htmlCalendar.getSubmittedValue());
		PM_IL_DOC_SETUP_BEAN.setDS_EFF_FM_DT(fromDate);
		Date toDate = (Date) PM_IL_DOC_SETUP_BEAN.getDS_EFF_TO_DT();
		pm_il_doc_setup_helper
				.DS_EFF_FM_DT_WHEN_VALIDATE_ITEM(fromDate, toDate);
	}

	public void validateDS_EFF_TO_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		HtmlCalendar htmlCalendar = (HtmlCalendar) component;
		Date toDate = htmlCalendar.getAsDate(htmlCalendar.getSubmittedValue());
		PM_IL_DOC_SETUP_BEAN.setDS_EFF_TO_DT(toDate);
		Date fromDate = (Date) PM_IL_DOC_SETUP_BEAN.getDS_EFF_FM_DT();
		pm_il_doc_setup_helper
				.DS_EFF_FM_DT_WHEN_VALIDATE_ITEM(fromDate, toDate);
	}

	//	This is the default listener which internally fires the validation.
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		pm_il_doc_setup_helper.callErrorMap(input);
	}

	/* PRE FORM */
	public void PRE_FORM() {
		//TODO needs to be get from Login form
		//setControlBeanValues();
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, Object> session = fc.getExternalContext().getSessionMap();
		//session.put("GLOBAL.M_PRIVILEGE", "YYY");
		session.put("GLOBAL.M_FAILURE", "FALSE");
		//session.put("GLOBAL.M_USER_ID", "EDP");
		//session.put("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM NAME");
		//session.put("GLOBAL.M_LANG_CODE", "ENG");
		//session.put("GLOBAL.M_PARA_1", " ");
		//session.put("GLOBAL.M_MODULE_NAME", "ARBR1");
		//session.put("M_FOR_LANG_CODE", "ARBR2");
		//session.put("GLOBAL.M_DFLT_VALUES", "00101    01    ");

		// STD_PRE_FORM.STD_PRE_FORM();
		ArrayList list;
		try {
			list = new PILM013_APAC_DBProcedures().P_VAL_SYSTEM("IL_CALC_MTHD",
					"IL_CALC_MTHD", "N");

			session.put("M_PS_CODE_DESC", list.get(0));
			session.put("DUMMY.M_CALC_METHOD", list.get(1));
			session.put("DUMMY.PM_IL_DOC_SETUP_CF", "N");
			session.put("DUMMY.PM_IL_DOC_NO_SETUP_CF", "P");
			session.put("DUMMY.PM_IL_DOC_NO_RANGE_CF", "P");
			session.put("DUMMY.PM_IL_DOC_DFLT_CHARGE_CF", "P");
			session.put("DUMMY.PM_IL_DOC_TODO_LIST_CF", "P");
			session.put("DUMMY.PM_IL_DOC_MED_HIST_CF", "P");
			session.put("DUMMY.PM_IL_DOC_TODO_GROUP_CF", "P");
			session.put("DUMMY.PM_IL_DOC_REMINDERS_CF", "P");

			PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
					.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
			HtmlSelectOneMenu DTL_CLAIM_TYPE = new HtmlSelectOneMenu();
			DTL_CLAIM_TYPE.setDisabled(true);
			pm_il_doc_setup_composite_action
					.getPM_IL_DOC_TODO_LIST_ACTION_BEAN()
					.setCOMP_DTL_CLAIM_TYPE(DTL_CLAIM_TYPE);
			// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_TODO_LIST.DTL_CLAIM_TYPE",ENABLED,PROPERTY_FALSE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* PRE_UPDATE */
	public void PRE_UPDATE() {
		PM_IL_DOC_SETUP_BEAN.setDS_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		PM_IL_DOC_SETUP_BEAN.setDS_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		if (PM_IL_DOC_SETUP_BEAN.getDS_REFUND_PREM_FLAG() != null) {
			if (PM_IL_DOC_SETUP_BEAN.getDS_REFUND_PREM_FLAG().equals("N")) {
				PM_IL_DOC_SETUP_BEAN.setDS_REFUND_DEP_FLAG("N");
				PM_IL_DOC_SETUP_BEAN.setDS_RECVR_CHRG_FLAG("N");
				PM_IL_DOC_SETUP_BEAN.setDS_RECVR_MEDFEE_YN("N");
			}
		}
	}

	/* PRE_BLOCK */
	public void PRE_BLOCK() {
		new CommonUtils().getControlBean().setM_DELETE_MSG_FLAG("N");
	}

	/* WHEN_CREATE_RECORD */
	public void WHEN_CREATE_RECORD() {
		PM_IL_DOC_SETUP_BEAN.setDS_BROKER_YN("N");
		PM_IL_DOC_SETUP_BEAN.setDS_REPRINT_YN("N");
		PM_IL_DOC_SETUP_BEAN.setDS_PRN_BEFORE_APPR("N");
		PM_IL_DOC_SETUP_BEAN.setDS_CURR_RATE_BS("S");
		PM_IL_DOC_SETUP_BEAN.setDS_POST_BO("B");
		PM_IL_DOC_SETUP_BEAN.setDS_FUND_TYPE("R");
		PM_IL_DOC_SETUP_BEAN.setDS_REFUND_PREM_FLAG("I");
		PM_IL_DOC_SETUP_BEAN.setDS_REFUND_SURPLUS_FLAG("I");
		PM_IL_DOC_SETUP_BEAN.setDS_REFUND_DEP_FLAG("R");
		PM_IL_DOC_SETUP_BEAN.setDS_RECVR_CHRG_FLAG("I");
		PM_IL_DOC_SETUP_BEAN.setDS_RECVR_MEDFEE_YN("Y");
		PM_IL_DOC_SETUP_BEAN.setDS_RECVR_COMM_FLAG("S");
		PM_IL_DOC_SETUP_BEAN.setDS_AGE_RECALC_YN("N");
		PM_IL_DOC_SETUP_BEAN.setDS_USE_SEQ_YN("Y");

	}

	/* WHEN NEW RECORD INSTANCE */
	public void WHEN_NEW_RECORD_INSTANCE() {
		pm_il_doc_setup_helper.L_DISP_END_POL(
				PM_IL_DOC_SETUP_BEAN.getDS_TYPE(), this);
		if (PM_IL_DOC_SETUP_BEAN.getDS_REFUND_PREM_FLAG() != null) {
			if (PM_IL_DOC_SETUP_BEAN.getDS_REFUND_PREM_FLAG().equals("N")) {
				COMP_DS_REFUND_DEP_FLAG.setDisabled(true);
				COMP_DS_RECVR_MEDFEE_YN.setDisabled(true);
				COMP_DS_RECVR_CHRG_FLAG.setDisabled(true);
			} else {
				COMP_DS_REFUND_DEP_FLAG.setDisabled(false);
				COMP_DS_RECVR_MEDFEE_YN.setDisabled(false);
				COMP_DS_RECVR_CHRG_FLAG.setDisabled(false);
			}
		}
		if (PM_IL_DOC_SETUP_BEAN.getDS_TYPE() != null
				&& PM_IL_DOC_SETUP_BEAN.getDS_END_TYPE() != null) {
			if (PM_IL_DOC_SETUP_BEAN.getDS_TYPE().equals("3")
					&& PM_IL_DOC_SETUP_BEAN.getDS_END_TYPE().equals("009")) {
				pm_il_doc_setup_helper.setCANCELLATION_DETAILS_BLOCK_ENABLE(
						false, this);
			} else {
				pm_il_doc_setup_helper.setCANCELLATION_DETAILS_BLOCK_ENABLE(
						true, this);
			}
		}
		if (PM_IL_DOC_SETUP_BEAN.getDS_USE_SEQ_YN() != null) {
			if (PM_IL_DOC_SETUP_BEAN.getDS_USE_SEQ_YN().equals("Y")) {
				getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
						.getPM_IL_DOC_NO_RANGE_BEAN().setCurrNodisabled(false);
				getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
						.getPM_IL_DOC_NO_RANGE_BEAN().setSegNameDisabled(false);

			} else {
				getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
						.getPM_IL_DOC_NO_RANGE_BEAN().setCurrNodisabled(true);
				getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
						.getPM_IL_DOC_NO_RANGE_BEAN().setSegNameDisabled(true);

			}
		}

		if (PM_IL_DOC_SETUP_BEAN.getDS_TYPE() != null) {
			if (PM_IL_DOC_SETUP_BEAN.getDS_TYPE().equals("4")) {
				pm_il_doc_setup_helper.setCLAIM_DETAILS_BLOCK_ENABLED(false,
						this);
				//SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_BUT_CLAIM",ENABLED,PROPERTY_TRUE);
			} else {
				pm_il_doc_setup_helper.setCLAIM_DETAILS_BLOCK_ENABLED(true,
						this);
				//SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_BUT_CLAIM",ENABLED,PROPERTY_FALSE);
			}
		}
	}

	/* POST QUERY */
	public void POST_QUERY(PM_IL_DOC_SETUP pm_il_doc_setup) {
		double VAR1 = -1;
		double M_VALUE = -1;
		ArrayList<String> resultList;
		try {
			resultList = new PILM013_APAC_DBProcedures().P_VAL_SYSTEM(
					"IL_DOC_TYP", pm_il_doc_setup.getDS_TYPE(), "N");

			pm_il_doc_setup.setUI_M_DS_TYPE_DESC(isNullOrBlank(resultList
					.get(0)) ? null : resultList.get(0).toString());
			if (pm_il_doc_setup.getDS_USE_SEQ_YN() != null) {
				if (pm_il_doc_setup.getDS_USE_SEQ_YN().equals("Y")) {
					getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
							.getPM_IL_DOC_NO_RANGE_BEAN().setCurrNodisabled(
									false);
					getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
							.getPM_IL_DOC_NO_RANGE_BEAN().setSegNameDisabled(
									false);
				}else {
					getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
							.getPM_IL_DOC_NO_RANGE_BEAN().setCurrNodisabled(
									false);
					getSessionValue().getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
							.getPM_IL_DOC_NO_RANGE_BEAN().setSegNameDisabled(
									true);
				}
			}
			if (pm_il_doc_setup.getDS_TYPE() != null) {
				System.out.println("TYPE::::::::::::::"
						+ pm_il_doc_setup.getDS_TYPE());
				if ("4".equalsIgnoreCase(pm_il_doc_setup.getDS_TYPE())) {
					//pm_il_doc_setup_helper.setCLAIM_DETAILS_BLOCK_ENABLED(false, this);

					setClaimPanelProperty(false);
					setCancellationPanelProperty(true);

					// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_BUT_CLAIM",ENABLED,PROPERTY_TRUE);
					ArrayList<String> partSettleList = new PILM013_APAC_DBProcedures()
							.P_VAL_SYSTEM("IL_ADDL_STAT", pm_il_doc_setup
									.getDS_CLM_PARSET(), "N");
					pm_il_doc_setup.setUI_M_DS_CLM_PARSET_DESC(partSettleList
							.get(0));

					ArrayList<String> fullSettleList = new PILM013_APAC_DBProcedures()
							.P_VAL_SYSTEM("IL_ADDL_STAT", pm_il_doc_setup
									.getDS_CLM_FULSET(), "N");
					pm_il_doc_setup.setUI_M_DS_CLM_FULSET_DESC(fullSettleList
							.get(0));
				} else if ("3".equalsIgnoreCase(pm_il_doc_setup.getDS_TYPE())) {
					setClaimPanelProperty(true);
					PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
							.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
					HtmlInputText DS_POL_CODE = new HtmlInputText();
					DS_POL_CODE.setReadonly(true);
					setCOMP_DS_POL_CODE(DS_POL_CODE);
					pm_il_doc_setup_composite_action
							.getPM_IL_DOC_SETUP_ACTION_BEAN()
							.setCOMP_DS_POL_CODE(DS_POL_CODE);
				} else if ("1".equalsIgnoreCase(pm_il_doc_setup.getDS_TYPE())) {
					setClaimPanelProperty(true);
					setCancellationPanelProperty(true);
					PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
							.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
					HtmlInputText END_TYPE = new HtmlInputText();
					END_TYPE.setReadonly(true);
					setCOMP_DS_END_TYPE(END_TYPE);
					pm_il_doc_setup_composite_action
							.getPM_IL_DOC_SETUP_ACTION_BEAN()
							.setCOMP_DS_END_TYPE(END_TYPE);

					pm_il_doc_setup_composite_action
							.getPM_IL_DOC_SETUP_ACTION_BEAN()
							.getCOMP_DS_POL_CODE().setReadonly(false);
				} else {
					PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
							.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
					setClaimPanelProperty(true);
					setCancellationPanelProperty(true);
					pm_il_doc_setup_composite_action
							.getPM_IL_DOC_SETUP_ACTION_BEAN()
							.getCOMP_DS_POL_CODE().setReadonly(true);
				}
			}
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		}
	}

	public void setClaimPanelProperty(boolean flag) {
		HtmlInputText DS_CLM_FULSET = new HtmlInputText();
		DS_CLM_FULSET.setDisabled(flag);
		setCOMP_DS_CLM_FULSET(DS_CLM_FULSET);

		HtmlInputText DS_CLM_PARSET = new HtmlInputText();
		DS_CLM_PARSET.setDisabled(flag);
		setCOMP_DS_CLM_PARSET(DS_CLM_PARSET);

		HtmlInputText DS_CLM_FULSET_DESC = new HtmlInputText();
		DS_CLM_FULSET_DESC.setDisabled(flag);
		setCOMP_UI_M_DS_CLM_FULSET_DESC(DS_CLM_FULSET_DESC);

		HtmlInputText DS_CLM_PARSET_DESC = new HtmlInputText();
		DS_CLM_PARSET_DESC.setDisabled(flag);
		setCOMP_UI_M_DS_CLM_PARSET_DESC(DS_CLM_PARSET_DESC);
	}

	public void setCancellationPanelProperty(boolean flag) {
		HtmlSelectOneMenu DS_FUND_TYPE = new HtmlSelectOneMenu();
		DS_FUND_TYPE.setDisabled(flag);
		setCOMP_DS_FUND_TYPE(DS_FUND_TYPE);

		HtmlSelectOneMenu DS_REFUND_PREM_FLAG = new HtmlSelectOneMenu();
		DS_REFUND_PREM_FLAG.setDisabled(flag);
		setCOMP_DS_REFUND_PREM_FLAG(DS_REFUND_PREM_FLAG);

		HtmlSelectOneMenu DS_REFUND_DEP_FLAG = new HtmlSelectOneMenu();
		DS_REFUND_DEP_FLAG.setDisabled(flag);
		setCOMP_DS_REFUND_DEP_FLAG(DS_REFUND_DEP_FLAG);

		HtmlSelectOneMenu DS_REFUND_SURPLUS_FLAG = new HtmlSelectOneMenu();
		DS_REFUND_SURPLUS_FLAG.setDisabled(flag);
		setCOMP_DS_REFUND_SURPLUS_FLAG(DS_REFUND_SURPLUS_FLAG);

		HtmlSelectOneMenu DS_RECVR_CHRG_FLAG = new HtmlSelectOneMenu();
		DS_RECVR_CHRG_FLAG.setDisabled(flag);
		setCOMP_DS_RECVR_CHRG_FLAG(DS_RECVR_CHRG_FLAG);

		HtmlSelectOneMenu DS_RECVR_COMM_FLAG = new HtmlSelectOneMenu();
		DS_RECVR_COMM_FLAG.setDisabled(flag);
		setCOMP_DS_RECVR_COMM_FLAG(DS_RECVR_COMM_FLAG);

		HtmlSelectOneMenu DS_RECVR_MEDFEE_YN = new HtmlSelectOneMenu();
		DS_RECVR_MEDFEE_YN.setDisabled(flag);
		setCOMP_DS_RECVR_MEDFEE_YN(DS_RECVR_MEDFEE_YN);
	}

	private boolean isNullOrBlank(String string) {
		return (string == null || string.equals(""));
	}

	/* LOV Actions */
	public List suggestionActionDSType(Object event) {
		String dsType = (String) event;
		try {
			dsTypeList = pm_il_doc_action_delegate.prepareDSTypeList(dsType,
					dsTypeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTypeList;
	}

	public String getDsTypeDescforCode(String catgCode, List catgCodeList) {
		Iterator iterator = catgCodeList.iterator();
		String dsTypeDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_SETUP pm_il_doc_setup = (PM_IL_DOC_SETUP) iterator.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
			if (catgCode.equalsIgnoreCase(pm_il_doc_setup.getDS_TYPE())) {
				dsTypeDesc = pm_il_doc_setup.getUI_M_DS_TYPE_DESC();
			}
		}
		return dsTypeDesc;
	}

	public void getDSTypeDesc(ActionEvent event) {
		if (COMP_DS_TYPE.getSubmittedValue() != null) {
			String dsType = (String) COMP_DS_TYPE.getSubmittedValue();
			String dsTypeDesc = getDsTypeDescforCode(dsType, dsTypeList);
			// COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(catgCodeDesc);
			PM_IL_DOC_SETUP_BEAN.setUI_M_DS_TYPE_DESC(dsTypeDesc);
			COMP_UI_M_DS_TYPE_DESC.setSubmittedValue(dsTypeDesc);
		}
	}

	/* Endorsement type LOV */
	public List suggestionActionEndorsementType(Object event) {
		String dsType = (String) event;
		try {
			endtypeList = pm_il_doc_action_delegate.prepareEndorsementTypeList(
					dsType, endtypeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return endtypeList;
	}

	public String getEndorsementDescforCode(String endtype, List endTypeList) {
		Iterator iterator = endTypeList.iterator();
		String dsTypeDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_SETUP pm_il_doc_setup = (PM_IL_DOC_SETUP) iterator.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
			if (endtype.equalsIgnoreCase(pm_il_doc_setup.getDS_TYPE())) {
				//dsTypeDesc = pm_il_doc_setup.getUI_M_DS_TYPE_DESC();
			}
		}
		return dsTypeDesc;
	}

	public void getEndorsementDesc(ActionEvent event) {
		if (COMP_DS_END_TYPE.getSubmittedValue() != null) {
			String endType = (String) COMP_DS_END_TYPE.getSubmittedValue();
			String endDesc = getEndorsementDescforCode(endType, endtypeList);
			System.out.println("DESC::::::::::" + endDesc);
			//PM_IL_DOC_SETUP_BEAN.setDS_END_TYPE_DESC(endDesc);
			PM_IL_DOC_SETUP_BEAN.setUI_M_DS_END_DESC(endDesc);
			COMP_UI_M_DS_END_DESC.setSubmittedValue(endDesc);
			System.out.println("Test "
					+ PM_IL_DOC_SETUP_BEAN.getUI_M_DS_END_DESC());
		}
	}

	/* Policy Link Code LOV */
	public List<LovBean> suggestionActionPolicyLinkCode(Object event) {
		String linkCode = (String) event;
		try {
			linkCodeList = pm_il_doc_action_delegate.preparePolicyLinkCodeList(
					linkCode, linkCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return linkCodeList;
	}

	public String getLinkDescforCode(String endtype, List endTypeList) {
		Iterator iterator = endTypeList.iterator();
		String dsTypeDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_SETUP pm_il_doc_setup = (PM_IL_DOC_SETUP) iterator.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
			if (endtype.equalsIgnoreCase(pm_il_doc_setup.getDS_POL_CODE())) {
				//dsTypeDesc = pm_il_doc_setup.getUI_M_DS_TYPE_DESC();
			}
		}
		return dsTypeDesc;
	}

	public void getLinkDesc(ActionEvent event) {
		if (COMP_DS_POL_CODE.getSubmittedValue() != null) {
			String linkCode = (String) COMP_DS_POL_CODE.getSubmittedValue();
			String linkDesc = getLinkDescforCode(linkCode, linkCodeList);
			PM_IL_DOC_SETUP_BEAN.setDS_POL_CODE_DESC(linkDesc);
		}
	}

	/* Partial Settlement-Claim Details LOV Actions */
	public List suggestionActionPartSettlement(Object event) {
		String dsType = (String) event;
		try {
			partSettleList = pm_il_doc_action_delegate
					.preparePartSettleCodeList(dsType, partSettleList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return partSettleList;
	}

	public String getPartSettleDescforCode(String partSettleCode,
			List partSettleList) {
		Iterator iterator = partSettleList.iterator();
		String partSettleDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_SETUP pm_il_doc_setup = (PM_IL_DOC_SETUP) iterator.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
			if (partSettleCode.equalsIgnoreCase(pm_il_doc_setup
					.getDS_CLM_PARSET())) {
				partSettleDesc = pm_il_doc_setup.getUI_M_DS_CLM_PARSET_DESC();
			}
		}
		return partSettleDesc;
	}

	public void getPartSettlementDesc(ActionEvent event) {
		if (COMP_DS_CLM_PARSET.getSubmittedValue() != null) {
			String partSettleCode = (String) COMP_DS_CLM_PARSET
					.getSubmittedValue();
			String partSettleCodeDesc = getPartSettleDescforCode(
					partSettleCode, partSettleList);
			// COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(catgCodeDesc);
			PM_IL_DOC_SETUP_BEAN.setDS_CLM_PARSET(partSettleCode);
			COMP_UI_M_DS_CLM_PARSET_DESC.setSubmittedValue(partSettleCodeDesc);
		}
	}

	/* Full settlement LOV Actions */
	public List suggestionActionFullSettlement(Object event) {
		String dsType = (String) event;
		try {
			fullSettleList = pm_il_doc_action_delegate.prepareFullSettleList(
					dsType, fullSettleList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fullSettleList;
	}

	public String getfullSettleDescforCode(String catgCode, List settlementList) {
		Iterator iterator = settlementList.iterator();
		String fullSettleDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_SETUP pm_il_doc_setup = (PM_IL_DOC_SETUP) iterator.next();
			if (catgCode.equalsIgnoreCase(pm_il_doc_setup.getDS_CLM_FULSET())) {
				fullSettleDesc = pm_il_doc_setup.getUI_M_DS_CLM_FULSET_DESC();
			}
		}
		return fullSettleDesc;
	}

	public void getFullSettleDesc(ActionEvent event) {
		if (COMP_DS_CLM_FULSET.getSubmittedValue() != null) {
			String fullSettleCode = (String) COMP_DS_CLM_FULSET
					.getSubmittedValue();
			String fullSettleDesc = getfullSettleDescforCode(fullSettleCode,
					fullSettleList);
			PM_IL_DOC_SETUP_BEAN.setUI_M_DS_CLM_FULSET_DESC(fullSettleDesc);
			COMP_UI_M_DS_CLM_FULSET_DESC.setSubmittedValue(fullSettleDesc);
		}
	}

	public PM_IL_DOC_ACTION_DELEGATE getPm_il_doc_action_delegate() {
		return pm_il_doc_action_delegate;
	}

	public void setPm_il_doc_action_delegate(
			PM_IL_DOC_ACTION_DELEGATE pm_il_doc_action_delegate) {
		this.pm_il_doc_action_delegate = pm_il_doc_action_delegate;
	}

	public PM_IL_DOC_SETUP_HELPER getPm_il_doc_setup_helper() {
		return pm_il_doc_setup_helper;
	}

	public void setPm_il_doc_setup_helper(
			PM_IL_DOC_SETUP_HELPER pm_il_doc_setup_helper) {
		this.pm_il_doc_setup_helper = pm_il_doc_setup_helper;
	}

	public List getDsTypeList() {
		return dsTypeList;
	}

	public void setDsTypeList(List dsTypeList) {
		this.dsTypeList = dsTypeList;
	}

	public List getEndtypeList() {
		return endtypeList;
	}

	public void setEndtypeList(List endtypeList) {
		this.endtypeList = endtypeList;
	}

	public HtmlSimpleTogglePanel getCOMP_Claim_Panel() {
		return COMP_Claim_Panel;
	}

	public void setCOMP_Claim_Panel(HtmlSimpleTogglePanel claim_Panel) {
		COMP_Claim_Panel = claim_Panel;
	}

	public HtmlSimpleTogglePanel getCOMP_Cancellation_Details() {
		return COMP_Cancellation_Details;
	}

	public void setCOMP_Cancellation_Details(
			HtmlSimpleTogglePanel cancellation_Details) {
		COMP_Cancellation_Details = cancellation_Details;
	}

	public List getLinkCodeList() {
		return linkCodeList;
	}

	public void setLinkCodeList(List linkCodeList) {
		this.linkCodeList = linkCodeList;
	}

	public List getPartSettleList() {
		return partSettleList;
	}

	public void setPartSettleList(List partSettleList) {
		this.partSettleList = partSettleList;
	}

	public List getFullSettleList() {
		return fullSettleList;
	}

	public void setFullSettleList(List fullSettleList) {
		this.fullSettleList = fullSettleList;
	}

	public boolean isRendered() {
		return isRendered;
	}

	public void setRendered(boolean isRendered) {
		this.isRendered = isRendered;
	}

	public ControlBean getControlBean() {
		return controlBean;
	}

	public void setControlBean(ControlBean controlBean) {
		this.controlBean = controlBean;
	}

	public PM_IL_DOC_SETUP_COMPOSITE_ACTION getSessionValue() {
		commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION actionBean = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		if (actionBean == null) {
			return null;
		} else {
			PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils
					.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
			return pm_il_doc_setup_composite_action;

		}
	}

	/**
	 * Implementation of Tool Bar Functionalities.
	 */
	/*	public String saveNextAction()
	 {
	 executeInsertion();
	 PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 String value  = pm_il_doc_setup_composite_action.callDocumentNumber();
	 pm_il_doc_setup_composite_action.getTabbedBar().gotoNextTab();
	 pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(2);
	 return value;
	 }
	
	
	 public String  nextIconAction()
	 {
	 PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 String value  = pm_il_doc_setup_composite_action.callDocumentNumber();
	 pm_il_doc_setup_composite_action.getTabbedBar().gotoNextTab();
	 pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(2);
	 return value;
	 }
	
	 public String  lastIconAction()
	 {
	 PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 String value  = pm_il_doc_setup_composite_action.callDocumentReminder();
	 pm_il_doc_setup_composite_action.getTabbedBar().gotoLastTab();
	 pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(7);
	 return value;
	 }
	
	 public String  firstIconAction()
	 {
	 PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 String value  = pm_il_doc_setup_composite_action.callDocumentSetup();
	 pm_il_doc_setup_composite_action.getTabbedBar().gotoFirstTab();
	 pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(1);
	 return value;
	 }
	
	 public String  previousIconAction()
	 {
	 PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 String value  = pm_il_doc_setup_composite_action.callDocumentSetup();
	 pm_il_doc_setup_composite_action.getTabbedBar().gotoPrevTab();
	 pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(1);
	 return value;
	 }*/

	public HtmlOutputLabel getCOMP_UI_M_END_TYPE_DESC_LABEL() {
		return COMP_UI_M_END_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_END_TYPE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_end_type_desc_label) {
		COMP_UI_M_END_TYPE_DESC_LABEL = comp_ui_m_end_type_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_DS_END_DESC() {
		return COMP_UI_M_DS_END_DESC;
	}

	public void setCOMP_UI_M_DS_END_DESC(HtmlInputText comp_ui_m_ds_end_desc) {
		COMP_UI_M_DS_END_DESC = comp_ui_m_ds_end_desc;
	}

	public String DELETE_BUTTON_ACTION() {
		PRE_DELETE(PM_IL_DOC_SETUP_BEAN.getDS_TYPE(), PM_IL_DOC_SETUP_BEAN
				.getDS_CODE());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.removeAttribute("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		return "";
	}

	public void PRE_DELETE(String DNS_TYPE, String DNS_CODE) {
		int rowsDeleted = new PM_IL_DOC_ACTION_DELEGATE().DOC_SETUP_PRE_DELETE(
				DNS_TYPE, DNS_CODE);
		System.out.println("ROWS DELETED:::::::" + rowsDeleted);
		if (rowsDeleted > 0) {
			getWarningMap().put("current", rowsDeleted + "Record Deleted");
			getWarningMap().put("detail", rowsDeleted + "Record Deleted");
		} else {
			getWarningMap().put("current", rowsDeleted + "Record not Deleted");
			getWarningMap().put("detail", rowsDeleted + "Record not Deleted");
		}
	}

	public void resetAllComponent() {
		COMP_DS_POL_CODE = new HtmlInputText();
		COMP_DS_END_TYPE = new HtmlInputText();
		COMP_DS_POL_CODE = new HtmlInputText();
		COMP_DS_END_TYPE = new HtmlInputText();
	}
	
	public void onLoad(PhaseEvent event) {
		try {
			if(isFormFlag()){
				PRE_FORM();
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				
				/*ADDED BY RAJA ON 17-03-2017 FOR SSP CALL ID - ZBILQC-1719438*/
				
				compositeAction.getWizard().disableWizardItem("DocumentNumberRange");
				
				/*end*/
				PRE_BLOCK();
				if(PM_IL_DOC_SETUP_BEAN.getROWID() != null){
					pm_il_doc_action_delegate.fetchDocumentSetupDetails(PM_IL_DOC_SETUP_BEAN.getROWID(), PM_IL_DOC_SETUP_BEAN);
					POST_QUERY(PM_IL_DOC_SETUP_BEAN);
				}else{
					WHEN_CREATE_RECORD();
				}
				WHEN_NEW_RECORD_INSTANCE();
				setBlockFlag(false);
			}
			/*Added by saritha*/
			if(this.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE().equals("3"))
			{
				COMP_END_COV_DESC.setRendered(true);
				COMP_END_REASON_LABEL.setRendered(true);				
			}else
			{
				COMP_END_COV_DESC.setRendered(false);
				COMP_END_REASON_LABEL.setRendered(false);
			}
			
			/*End*/
			
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad",e.getMessage());
		}
	}
	
	/*Added by saritha*/
	
			public void validateDS_END_REASON(FacesContext facesContext,
					UIComponent component, Object value) throws ValidatorException {
				CommonUtils.clearMaps(this);
				try {
					PM_IL_DOC_SETUP_BEAN.setDS_END_REASON((String) value);
					//COMP_END_COV_DESC.resetValue();
				} catch (Exception exception) {
					exception.printStackTrace();
					throw new ValidatorException(new FacesMessage(exception
							.getMessage()));
				} finally {
					try {
						ErrorHelpUtil.getWarningForProcedure(CommonUtils
								.getConnection(), "DS_END_REASON", getWarningMap());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			
			/*public void validateDS_END_REASON(FacesContext context,
					UIComponent component, Object value){
				try{
					System.out.println("inside validateDS_END_REASON ");
					String DS_END_REASON = (String)value;
					PM_IL_DOC_SETUP_BEAN.setDS_END_REASON(DS_END_REASON);
					System.out.println("value of fle-field--------->"+	PM_IL_DOC_SETUP_BEAN.getDS_END_REASON());
					
				}catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}
			}*/

			/*End*/

}
