package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT011.PILT011_COMPOSITE_ACTION;
import com.iii.pel.utils.P9ILPK_CLAIM;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_CLAIM_COVER_DTLS_ACTION extends CommonAction {
	
	private static final Log log = LogFactory.getLog(PT_IL_CLAIM_COVER_DTLS.class);

	private HtmlOutputLabel COMP_CCD_CLOSE_DT_LABEL;

	private HtmlCalendar COMP_CCD_CLOSE_DT;

	private HtmlOutputLabel COMP_CCD_COVER_CODE_LABEL;

	private HtmlInputText COMP_CCD_COVER_CODE;
	
	private HtmlInputText UI_COMP_CCD_COVER_CODE_DESC;

	private HtmlOutputLabel COMP_CCD_PROD_CODE_LABEL;

	private HtmlInputText COMP_CCD_PROD_CODE;

	private HtmlOutputLabel COMP_CCD_COVER_GROUP_CODE_LABEL;

	private HtmlInputText COMP_CCD_COVER_GROUP_CODE;

	private HtmlOutputLabel COMP_CCD_LOSS_TYPE_LABEL;

	private HtmlInputText COMP_CCD_LOSS_TYPE;
	
	private HtmlInputText COMP_CCD_LOSS_TYPE_DESC;

	private HtmlOutputLabel COMP_CCD_DISAB_TYPE_LABEL;

	private HtmlInputText COMP_CCD_DISAB_TYPE;
	
	private HtmlInputText COMP_CCD_DISAB_TYPE_DESC;

	private HtmlOutputLabel COMP_CCD_CLAIM_ILL_TYPE_LABEL;

	private HtmlInputText COMP_CCD_CLAIM_ILL_TYPE;

	private HtmlOutputLabel COMP_CCD_PERIOD_UNIT_LABEL;

	private HtmlSelectOneMenu COMP_CCD_PERIOD_UNIT;

	private HtmlOutputLabel COMP_CCD_PERIOD_LABEL;

	private HtmlInputText COMP_CCD_PERIOD;

	private HtmlOutputLabel COMP_CCD_RATE_PER_LABEL;

	private HtmlInputText COMP_CCD_RATE_PER;

	private HtmlOutputLabel COMP_CCD_NO_OF_DAYS_LABEL;

	private HtmlInputText COMP_CCD_NO_OF_DAYS;

	private HtmlOutputLabel COMP_CCD_RATE_LABEL;

	private HtmlInputText COMP_CCD_RATE;

	private HtmlOutputLabel COMP_CCD_FC_EST_AMT_LABEL;

	private HtmlInputText COMP_CCD_FC_EST_AMT;

	private HtmlOutputLabel COMP_CCD_FRZ_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_CCD_FRZ_FLAG;

	private HtmlOutputLabel COMP_CCD_CONFIRM_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_CCD_CONFIRM_FLAG;

	private HtmlOutputLabel COMP_CCD_RESERVE_DT_LABEL;

	private HtmlCalendar COMP_CCD_RESERVE_DT;

	private HtmlOutputLabel COMP_CCD_LC_EST_AMT_LABEL;

	private HtmlInputText COMP_CCD_LC_EST_AMT;

	private HtmlOutputLabel COMP_CCD_SET_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_CCD_SET_FLAG;

	private HtmlOutputLabel COMP_CCD_CLAIM_PAY_TO_LABEL;

	private HtmlSelectOneMenu COMP_CCD_CLAIM_PAY_TO;

	private HtmlOutputLabel COMP_UI_M_SUB_BEN_LIMIT_LABEL;

	private HtmlInputText COMP_UI_M_SUB_BEN_LIMIT;

	private HtmlOutputLabel COMP_UI_M_CCD_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CCD_COVER_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_CCD_LOSS_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CCD_LOSS_TYPE_DESC;

	private HtmlOutputLabel COMP_UI_M_LIMIT_TYPE_LABEL;

	private HtmlInputText COMP_UI_M_LIMIT_TYPE;

	private HtmlOutputLabel COMP_UI_M_ILL_TYPE_LABEL;

	private HtmlInputText COMP_UI_M_ILL_TYPE;

	private HtmlOutputLabel COMP_UI_M_CCD_DISAB_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CCD_DISAB_TYPE_DESC;
	
	private HtmlOutputLabel COMP_UI_M_REFUND_SERV_FEE_LABEL;
	
	private HtmlInputText COMP_UI_M_REFUND_SERV_FEE;
	
	private HtmlOutputLabel COMP_UI_M_REFUND_WAK_FEE_LABEL;
	
	private HtmlInputText COMP_UI_M_REFUND_WAK_FEE;
	
	private HtmlOutputLabel COMP_UI_M_REFUND_RISK_PREM_LABEL;
	
	private HtmlInputText COMP_UI_M_REFUND_RISK_PREM;

	private HtmlOutputLabel COMP_UI_M_CCD_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CCD_PROD_CODE_DESC;

	private PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN;

	public PILT006_APAC_COMPOSITE_ACTION compositeAction;
	/* Modified by saranya for RI recovery details to be shown at Claim registration stage itself on 18/02/2017 */
	
	public PILT011_COMPOSITE_ACTION PILT011compositeAction;
	/*End*/

	private PT_IL_CLAIM_COVER_DTLS_HELPER helper;

	private List<PT_IL_CLAIM_COVER_DTLS> dataList_PT_IL_CLAIM_COVER_DTLS = null;

	private UIData dataTable;

	private List<SelectItem> listCCD_PERIOD_UNIT = new ArrayList<SelectItem>();

	private List<SelectItem> listCCD_CONFIRM_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listCCD_FRZ_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listCCD_SET_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listCCD_CLAIM_PAY_TO = new ArrayList<SelectItem>();
	
	private HtmlCommandButton COMP_UI_M_BUT_HISTORY;
	
	private HtmlCommandButton COMP_UI_M_BUT_RI;
	
	private HtmlCommandButton COMP_UI_M_BUT_FAC;
	
	private String filterByCCD_COVER_CODE;
	
	private String filterByCCD_LOSS_TYPE;
	
	private String filterByCCD_DISAB_TYPE;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private List<LovBean> suggestionLOV = null;
	
	public PT_IL_CLAIM_COVER_DTLS_ACTION() {
		dataList_PT_IL_CLAIM_COVER_DTLS = new ArrayList<PT_IL_CLAIM_COVER_DTLS>();
		PT_IL_CLAIM_COVER_DTLS_BEAN = new PT_IL_CLAIM_COVER_DTLS();
		helper = new PT_IL_CLAIM_COVER_DTLS_HELPER();
		instantiateAllComponent();
		setListCCD_PERIOD_UNIT(ListItemUtil.getDropDownListValue(getConnection(), 
				"PILT006_APAC","PT_IL_CLAIM_COVER_DTLS", "PT_IL_CLAIM_COVER_DTLS.CCD_PERIOD_UNIT", "CALC-MTHD"));
		setListCCD_CONFIRM_FLAG(ListItemUtil.getDropDownListValue(getConnection(), 
				"PILT006_APAC","PT_IL_CLAIM_COVER_DTLS", "PT_IL_CLAIM_COVER_DTLS.CCD_CONFIRM_FLAG", "YESNO"));
		setListCCD_CLAIM_PAY_TO(ListItemUtil.getDropDownListValue(getConnection(), 
				"PILT006_APAC","PT_IL_CLAIM_COVER_DTLS", "PT_IL_CLAIM_COVER_DTLS.CCD_CLAIM_PAY_TO", "PAYTO"));
		setListCCD_SET_FLAG(ListItemUtil.getDropDownListValue(getConnection(), 
				"PILT006_APAC","PT_IL_CLAIM_COVER_DTLS", "PT_IL_CLAIM_COVER_DTLS.CCD_SET_FLAG", "IL_SA_PA"));
		setListCCD_FRZ_FLAG(ListItemUtil.getDropDownListValue(getConnection(), 
				"PILT006_APAC","PT_IL_CLAIM_COVER_DTLS", "PT_IL_CLAIM_COVER_DTLS.CCD_FRZ_FLAG", "YESNO"));
	}

	/**
	 * @return the cOMP_CCD_CLOSE_DT_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_CLOSE_DT_LABEL() {
		return COMP_CCD_CLOSE_DT_LABEL;
	}

	/**
	 * @param comp_ccd_close_dt_label
	 *            the cOMP_CCD_CLOSE_DT_LABEL to set
	 */
	public void setCOMP_CCD_CLOSE_DT_LABEL(
			HtmlOutputLabel comp_ccd_close_dt_label) {
		COMP_CCD_CLOSE_DT_LABEL = comp_ccd_close_dt_label;
	}

	/**
	 * @return the cOMP_CCD_CLOSE_DT
	 */
	public HtmlCalendar getCOMP_CCD_CLOSE_DT() {
		return COMP_CCD_CLOSE_DT;
	}

	/**
	 * @param comp_ccd_close_dt
	 *            the cOMP_CCD_CLOSE_DT to set
	 */
	public void setCOMP_CCD_CLOSE_DT(HtmlCalendar comp_ccd_close_dt) {
		COMP_CCD_CLOSE_DT = comp_ccd_close_dt;
	}

	/**
	 * @return the cOMP_CCD_COVER_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_COVER_CODE_LABEL() {
		return COMP_CCD_COVER_CODE_LABEL;
	}

	/**
	 * @param comp_ccd_cover_code_label
	 *            the cOMP_CCD_COVER_CODE_LABEL to set
	 */
	public void setCOMP_CCD_COVER_CODE_LABEL(
			HtmlOutputLabel comp_ccd_cover_code_label) {
		COMP_CCD_COVER_CODE_LABEL = comp_ccd_cover_code_label;
	}

	/**
	 * @return the cOMP_CCD_COVER_CODE
	 */
	public HtmlInputText getCOMP_CCD_COVER_CODE() {
		return COMP_CCD_COVER_CODE;
	}

	/**
	 * @param comp_ccd_cover_code
	 *            the cOMP_CCD_COVER_CODE to set
	 */
	public void setCOMP_CCD_COVER_CODE(HtmlInputText comp_ccd_cover_code) {
		COMP_CCD_COVER_CODE = comp_ccd_cover_code;
	}

	/**
	 * @return the cOMP_CCD_PROD_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_PROD_CODE_LABEL() {
		return COMP_CCD_PROD_CODE_LABEL;
	}

	/**
	 * @param comp_ccd_prod_code_label
	 *            the cOMP_CCD_PROD_CODE_LABEL to set
	 */
	public void setCOMP_CCD_PROD_CODE_LABEL(
			HtmlOutputLabel comp_ccd_prod_code_label) {
		COMP_CCD_PROD_CODE_LABEL = comp_ccd_prod_code_label;
	}

	/**
	 * @return the cOMP_CCD_PROD_CODE
	 */
	public HtmlInputText getCOMP_CCD_PROD_CODE() {
		return COMP_CCD_PROD_CODE;
	}

	/**
	 * @param comp_ccd_prod_code
	 *            the cOMP_CCD_PROD_CODE to set
	 */
	public void setCOMP_CCD_PROD_CODE(HtmlInputText comp_ccd_prod_code) {
		COMP_CCD_PROD_CODE = comp_ccd_prod_code;
	}

	/**
	 * @return the cOMP_CCD_COVER_GROUP_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_COVER_GROUP_CODE_LABEL() {
		return COMP_CCD_COVER_GROUP_CODE_LABEL;
	}

	/**
	 * @param comp_ccd_cover_group_code_label
	 *            the cOMP_CCD_COVER_GROUP_CODE_LABEL to set
	 */
	public void setCOMP_CCD_COVER_GROUP_CODE_LABEL(
			HtmlOutputLabel comp_ccd_cover_group_code_label) {
		COMP_CCD_COVER_GROUP_CODE_LABEL = comp_ccd_cover_group_code_label;
	}

	/**
	 * @return the cOMP_CCD_COVER_GROUP_CODE
	 */
	public HtmlInputText getCOMP_CCD_COVER_GROUP_CODE() {
		return COMP_CCD_COVER_GROUP_CODE;
	}

	/**
	 * @param comp_ccd_cover_group_code
	 *            the cOMP_CCD_COVER_GROUP_CODE to set
	 */
	public void setCOMP_CCD_COVER_GROUP_CODE(
			HtmlInputText comp_ccd_cover_group_code) {
		COMP_CCD_COVER_GROUP_CODE = comp_ccd_cover_group_code;
	}

	/**
	 * @return the cOMP_CCD_LOSS_TYPE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_LOSS_TYPE_LABEL() {
		return COMP_CCD_LOSS_TYPE_LABEL;
	}

	/**
	 * @param comp_ccd_loss_type_label
	 *            the cOMP_CCD_LOSS_TYPE_LABEL to set
	 */
	public void setCOMP_CCD_LOSS_TYPE_LABEL(
			HtmlOutputLabel comp_ccd_loss_type_label) {
		COMP_CCD_LOSS_TYPE_LABEL = comp_ccd_loss_type_label;
	}

	/**
	 * @return the cOMP_CCD_LOSS_TYPE
	 */
	public HtmlInputText getCOMP_CCD_LOSS_TYPE() {
		return COMP_CCD_LOSS_TYPE;
	}

	/**
	 * @param comp_ccd_loss_type
	 *            the cOMP_CCD_LOSS_TYPE to set
	 */
	public void setCOMP_CCD_LOSS_TYPE(HtmlInputText comp_ccd_loss_type) {
		COMP_CCD_LOSS_TYPE = comp_ccd_loss_type;
	}

	/**
	 * @return the cOMP_CCD_DISAB_TYPE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_DISAB_TYPE_LABEL() {
		return COMP_CCD_DISAB_TYPE_LABEL;
	}

	/**
	 * @param comp_ccd_disab_type_label
	 *            the cOMP_CCD_DISAB_TYPE_LABEL to set
	 */
	public void setCOMP_CCD_DISAB_TYPE_LABEL(
			HtmlOutputLabel comp_ccd_disab_type_label) {
		COMP_CCD_DISAB_TYPE_LABEL = comp_ccd_disab_type_label;
	}

	/**
	 * @return the cOMP_CCD_DISAB_TYPE
	 */
	public HtmlInputText getCOMP_CCD_DISAB_TYPE() {
		return COMP_CCD_DISAB_TYPE;
	}

	/**
	 * @param comp_ccd_disab_type
	 *            the cOMP_CCD_DISAB_TYPE to set
	 */
	public void setCOMP_CCD_DISAB_TYPE(HtmlInputText comp_ccd_disab_type) {
		COMP_CCD_DISAB_TYPE = comp_ccd_disab_type;
	}

	/**
	 * @return the cOMP_CCD_CLAIM_ILL_TYPE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_CLAIM_ILL_TYPE_LABEL() {
		return COMP_CCD_CLAIM_ILL_TYPE_LABEL;
	}

	/**
	 * @param comp_ccd_claim_ill_type_label
	 *            the cOMP_CCD_CLAIM_ILL_TYPE_LABEL to set
	 */
	public void setCOMP_CCD_CLAIM_ILL_TYPE_LABEL(
			HtmlOutputLabel comp_ccd_claim_ill_type_label) {
		COMP_CCD_CLAIM_ILL_TYPE_LABEL = comp_ccd_claim_ill_type_label;
	}

	/**
	 * @return the cOMP_CCD_CLAIM_ILL_TYPE
	 */
	public HtmlInputText getCOMP_CCD_CLAIM_ILL_TYPE() {
		return COMP_CCD_CLAIM_ILL_TYPE;
	}

	/**
	 * @param comp_ccd_claim_ill_type
	 *            the cOMP_CCD_CLAIM_ILL_TYPE to set
	 */
	public void setCOMP_CCD_CLAIM_ILL_TYPE(HtmlInputText comp_ccd_claim_ill_type) {
		COMP_CCD_CLAIM_ILL_TYPE = comp_ccd_claim_ill_type;
	}

	/**
	 * @return the cOMP_CCD_PERIOD_UNIT_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_PERIOD_UNIT_LABEL() {
		return COMP_CCD_PERIOD_UNIT_LABEL;
	}

	/**
	 * @param comp_ccd_period_unit_label
	 *            the cOMP_CCD_PERIOD_UNIT_LABEL to set
	 */
	public void setCOMP_CCD_PERIOD_UNIT_LABEL(
			HtmlOutputLabel comp_ccd_period_unit_label) {
		COMP_CCD_PERIOD_UNIT_LABEL = comp_ccd_period_unit_label;
	}

	/**
	 * @return the cOMP_CCD_PERIOD_UNIT
	 */
	public HtmlSelectOneMenu getCOMP_CCD_PERIOD_UNIT() {
		return COMP_CCD_PERIOD_UNIT;
	}

	/**
	 * @param comp_ccd_period_unit
	 *            the cOMP_CCD_PERIOD_UNIT to set
	 */
	public void setCOMP_CCD_PERIOD_UNIT(HtmlSelectOneMenu comp_ccd_period_unit) {
		COMP_CCD_PERIOD_UNIT = comp_ccd_period_unit;
	}

	/**
	 * @return the cOMP_CCD_PERIOD_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_PERIOD_LABEL() {
		return COMP_CCD_PERIOD_LABEL;
	}

	/**
	 * @param comp_ccd_period_label
	 *            the cOMP_CCD_PERIOD_LABEL to set
	 */
	public void setCOMP_CCD_PERIOD_LABEL(HtmlOutputLabel comp_ccd_period_label) {
		COMP_CCD_PERIOD_LABEL = comp_ccd_period_label;
	}

	/**
	 * @return the cOMP_CCD_PERIOD
	 */
	public HtmlInputText getCOMP_CCD_PERIOD() {
		return COMP_CCD_PERIOD;
	}

	/**
	 * @param comp_ccd_period
	 *            the cOMP_CCD_PERIOD to set
	 */
	public void setCOMP_CCD_PERIOD(HtmlInputText comp_ccd_period) {
		COMP_CCD_PERIOD = comp_ccd_period;
	}

	/**
	 * @return the cOMP_CCD_RATE_PER_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_RATE_PER_LABEL() {
		return COMP_CCD_RATE_PER_LABEL;
	}

	/**
	 * @param comp_ccd_rate_per_label
	 *            the cOMP_CCD_RATE_PER_LABEL to set
	 */
	public void setCOMP_CCD_RATE_PER_LABEL(
			HtmlOutputLabel comp_ccd_rate_per_label) {
		COMP_CCD_RATE_PER_LABEL = comp_ccd_rate_per_label;
	}

	/**
	 * @return the cOMP_CCD_RATE_PER
	 */
	public HtmlInputText getCOMP_CCD_RATE_PER() {
		return COMP_CCD_RATE_PER;
	}

	/**
	 * @param comp_ccd_rate_per
	 *            the cOMP_CCD_RATE_PER to set
	 */
	public void setCOMP_CCD_RATE_PER(HtmlInputText comp_ccd_rate_per) {
		COMP_CCD_RATE_PER = comp_ccd_rate_per;
	}

	/**
	 * @return the cOMP_CCD_NO_OF_DAYS_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_NO_OF_DAYS_LABEL() {
		return COMP_CCD_NO_OF_DAYS_LABEL;
	}

	/**
	 * @param comp_ccd_no_of_days_label
	 *            the cOMP_CCD_NO_OF_DAYS_LABEL to set
	 */
	public void setCOMP_CCD_NO_OF_DAYS_LABEL(
			HtmlOutputLabel comp_ccd_no_of_days_label) {
		COMP_CCD_NO_OF_DAYS_LABEL = comp_ccd_no_of_days_label;
	}

	/**
	 * @return the cOMP_CCD_NO_OF_DAYS
	 */
	public HtmlInputText getCOMP_CCD_NO_OF_DAYS() {
		return COMP_CCD_NO_OF_DAYS;
	}

	/**
	 * @param comp_ccd_no_of_days
	 *            the cOMP_CCD_NO_OF_DAYS to set
	 */
	public void setCOMP_CCD_NO_OF_DAYS(HtmlInputText comp_ccd_no_of_days) {
		COMP_CCD_NO_OF_DAYS = comp_ccd_no_of_days;
	}

	/**
	 * @return the cOMP_CCD_RATE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_RATE_LABEL() {
		return COMP_CCD_RATE_LABEL;
	}

	/**
	 * @param comp_ccd_rate_label
	 *            the cOMP_CCD_RATE_LABEL to set
	 */
	public void setCOMP_CCD_RATE_LABEL(HtmlOutputLabel comp_ccd_rate_label) {
		COMP_CCD_RATE_LABEL = comp_ccd_rate_label;
	}

	/**
	 * @return the cOMP_CCD_RATE
	 */
	public HtmlInputText getCOMP_CCD_RATE() {
		return COMP_CCD_RATE;
	}

	/**
	 * @param comp_ccd_rate
	 *            the cOMP_CCD_RATE to set
	 */
	public void setCOMP_CCD_RATE(HtmlInputText comp_ccd_rate) {
		COMP_CCD_RATE = comp_ccd_rate;
	}

	/**
	 * @return the cOMP_CCD_FC_EST_AMT_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_FC_EST_AMT_LABEL() {
		return COMP_CCD_FC_EST_AMT_LABEL;
	}

	/**
	 * @param comp_ccd_fc_est_amt_label
	 *            the cOMP_CCD_FC_EST_AMT_LABEL to set
	 */
	public void setCOMP_CCD_FC_EST_AMT_LABEL(
			HtmlOutputLabel comp_ccd_fc_est_amt_label) {
		COMP_CCD_FC_EST_AMT_LABEL = comp_ccd_fc_est_amt_label;
	}

	/**
	 * @return the cOMP_CCD_FC_EST_AMT
	 */
	public HtmlInputText getCOMP_CCD_FC_EST_AMT() {
		return COMP_CCD_FC_EST_AMT;
	}

	/**
	 * @param comp_ccd_fc_est_amt
	 *            the cOMP_CCD_FC_EST_AMT to set
	 */
	public void setCOMP_CCD_FC_EST_AMT(HtmlInputText comp_ccd_fc_est_amt) {
		COMP_CCD_FC_EST_AMT = comp_ccd_fc_est_amt;
	}

	/**
	 * @return the cOMP_CCD_FRZ_FLAG_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_FRZ_FLAG_LABEL() {
		return COMP_CCD_FRZ_FLAG_LABEL;
	}

	/**
	 * @param comp_ccd_frz_flag_label
	 *            the cOMP_CCD_FRZ_FLAG_LABEL to set
	 */
	public void setCOMP_CCD_FRZ_FLAG_LABEL(
			HtmlOutputLabel comp_ccd_frz_flag_label) {
		COMP_CCD_FRZ_FLAG_LABEL = comp_ccd_frz_flag_label;
	}

	/**
	 * @return the cOMP_CCD_FRZ_FLAG
	 */
	public HtmlSelectOneMenu getCOMP_CCD_FRZ_FLAG() {
		return COMP_CCD_FRZ_FLAG;
	}

	/**
	 * @param comp_ccd_frz_flag
	 *            the cOMP_CCD_FRZ_FLAG to set
	 */
	public void setCOMP_CCD_FRZ_FLAG(HtmlSelectOneMenu comp_ccd_frz_flag) {
		COMP_CCD_FRZ_FLAG = comp_ccd_frz_flag;
	}

	/**
	 * @return the cOMP_CCD_CONFIRM_FLAG_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_CONFIRM_FLAG_LABEL() {
		return COMP_CCD_CONFIRM_FLAG_LABEL;
	}

	/**
	 * @param comp_ccd_confirm_flag_label
	 *            the cOMP_CCD_CONFIRM_FLAG_LABEL to set
	 */
	public void setCOMP_CCD_CONFIRM_FLAG_LABEL(
			HtmlOutputLabel comp_ccd_confirm_flag_label) {
		COMP_CCD_CONFIRM_FLAG_LABEL = comp_ccd_confirm_flag_label;
	}

	/**
	 * @return the cOMP_CCD_CONFIRM_FLAG
	 */
	public HtmlSelectOneMenu getCOMP_CCD_CONFIRM_FLAG() {
		return COMP_CCD_CONFIRM_FLAG;
	}

	/**
	 * @param comp_ccd_confirm_flag
	 *            the cOMP_CCD_CONFIRM_FLAG to set
	 */
	public void setCOMP_CCD_CONFIRM_FLAG(HtmlSelectOneMenu comp_ccd_confirm_flag) {
		COMP_CCD_CONFIRM_FLAG = comp_ccd_confirm_flag;
	}

	/**
	 * @return the cOMP_CCD_RESERVE_DT_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_RESERVE_DT_LABEL() {
		return COMP_CCD_RESERVE_DT_LABEL;
	}

	/**
	 * @param comp_ccd_reserve_dt_label
	 *            the cOMP_CCD_RESERVE_DT_LABEL to set
	 */
	public void setCOMP_CCD_RESERVE_DT_LABEL(
			HtmlOutputLabel comp_ccd_reserve_dt_label) {
		COMP_CCD_RESERVE_DT_LABEL = comp_ccd_reserve_dt_label;
	}

	/**
	 * @return the cOMP_CCD_RESERVE_DT
	 */
	public HtmlCalendar getCOMP_CCD_RESERVE_DT() {
		return COMP_CCD_RESERVE_DT;
	}

	/**
	 * @param comp_ccd_reserve_dt
	 *            the cOMP_CCD_RESERVE_DT to set
	 */
	public void setCOMP_CCD_RESERVE_DT(HtmlCalendar comp_ccd_reserve_dt) {
		COMP_CCD_RESERVE_DT = comp_ccd_reserve_dt;
	}

	/**
	 * @return the cOMP_CCD_LC_EST_AMT_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_LC_EST_AMT_LABEL() {
		return COMP_CCD_LC_EST_AMT_LABEL;
	}

	/**
	 * @param comp_ccd_lc_est_amt_label
	 *            the cOMP_CCD_LC_EST_AMT_LABEL to set
	 */
	public void setCOMP_CCD_LC_EST_AMT_LABEL(
			HtmlOutputLabel comp_ccd_lc_est_amt_label) {
		COMP_CCD_LC_EST_AMT_LABEL = comp_ccd_lc_est_amt_label;
	}

	/**
	 * @return the cOMP_CCD_LC_EST_AMT
	 */
	public HtmlInputText getCOMP_CCD_LC_EST_AMT() {
		return COMP_CCD_LC_EST_AMT;
	}

	/**
	 * @param comp_ccd_lc_est_amt
	 *            the cOMP_CCD_LC_EST_AMT to set
	 */
	public void setCOMP_CCD_LC_EST_AMT(HtmlInputText comp_ccd_lc_est_amt) {
		COMP_CCD_LC_EST_AMT = comp_ccd_lc_est_amt;
	}

	/**
	 * @return the cOMP_CCD_SET_FLAG_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_SET_FLAG_LABEL() {
		return COMP_CCD_SET_FLAG_LABEL;
	}

	/**
	 * @param comp_ccd_set_flag_label
	 *            the cOMP_CCD_SET_FLAG_LABEL to set
	 */
	public void setCOMP_CCD_SET_FLAG_LABEL(
			HtmlOutputLabel comp_ccd_set_flag_label) {
		COMP_CCD_SET_FLAG_LABEL = comp_ccd_set_flag_label;
	}

	/**
	 * @return the cOMP_CCD_SET_FLAG
	 */
	public HtmlSelectOneMenu getCOMP_CCD_SET_FLAG() {
		return COMP_CCD_SET_FLAG;
	}

	/**
	 * @param comp_ccd_set_flag
	 *            the cOMP_CCD_SET_FLAG to set
	 */
	public void setCOMP_CCD_SET_FLAG(HtmlSelectOneMenu comp_ccd_set_flag) {
		COMP_CCD_SET_FLAG = comp_ccd_set_flag;
	}

	/**
	 * @return the cOMP_CCD_CLAIM_PAY_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCD_CLAIM_PAY_TO_LABEL() {
		return COMP_CCD_CLAIM_PAY_TO_LABEL;
	}

	/**
	 * @param comp_ccd_claim_pay_to_label
	 *            the cOMP_CCD_CLAIM_PAY_TO_LABEL to set
	 */
	public void setCOMP_CCD_CLAIM_PAY_TO_LABEL(
			HtmlOutputLabel comp_ccd_claim_pay_to_label) {
		COMP_CCD_CLAIM_PAY_TO_LABEL = comp_ccd_claim_pay_to_label;
	}

	/**
	 * @return the cOMP_CCD_CLAIM_PAY_TO
	 */
	public HtmlSelectOneMenu getCOMP_CCD_CLAIM_PAY_TO() {
		return COMP_CCD_CLAIM_PAY_TO;
	}

	/**
	 * @param comp_ccd_claim_pay_to
	 *            the cOMP_CCD_CLAIM_PAY_TO to set
	 */
	public void setCOMP_CCD_CLAIM_PAY_TO(HtmlSelectOneMenu comp_ccd_claim_pay_to) {
		COMP_CCD_CLAIM_PAY_TO = comp_ccd_claim_pay_to;
	}

	/**
	 * @return the cOMP_UI_M_SUB_BEN_LIMIT_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_SUB_BEN_LIMIT_LABEL() {
		return COMP_UI_M_SUB_BEN_LIMIT_LABEL;
	}

	/**
	 * @param comp_ui_m_sub_ben_limit_label
	 *            the cOMP_UI_M_SUB_BEN_LIMIT_LABEL to set
	 */
	public void setCOMP_UI_M_SUB_BEN_LIMIT_LABEL(
			HtmlOutputLabel comp_ui_m_sub_ben_limit_label) {
		COMP_UI_M_SUB_BEN_LIMIT_LABEL = comp_ui_m_sub_ben_limit_label;
	}

	/**
	 * @return the cOMP_UI_M_SUB_BEN_LIMIT
	 */
	public HtmlInputText getCOMP_UI_M_SUB_BEN_LIMIT() {
		return COMP_UI_M_SUB_BEN_LIMIT;
	}

	/**
	 * @param comp_ui_m_sub_ben_limit
	 *            the cOMP_UI_M_SUB_BEN_LIMIT to set
	 */
	public void setCOMP_UI_M_SUB_BEN_LIMIT(HtmlInputText comp_ui_m_sub_ben_limit) {
		COMP_UI_M_SUB_BEN_LIMIT = comp_ui_m_sub_ben_limit;
	}

	/**
	 * @return the cOMP_UI_M_CCD_COVER_CODE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_CCD_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_CCD_COVER_CODE_DESC_LABEL;
	}

	/**
	 * @param comp_ui_m_ccd_cover_code_desc_label
	 *            the cOMP_UI_M_CCD_COVER_CODE_DESC_LABEL to set
	 */
	public void setCOMP_UI_M_CCD_COVER_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_ccd_cover_code_desc_label) {
		COMP_UI_M_CCD_COVER_CODE_DESC_LABEL = comp_ui_m_ccd_cover_code_desc_label;
	}

	/**
	 * @return the cOMP_UI_M_CCD_COVER_CODE_DESC
	 */
	public HtmlInputText getCOMP_UI_M_CCD_COVER_CODE_DESC() {
		return COMP_UI_M_CCD_COVER_CODE_DESC;
	}

	/**
	 * @param comp_ui_m_ccd_cover_code_desc
	 *            the cOMP_UI_M_CCD_COVER_CODE_DESC to set
	 */
	public void setCOMP_UI_M_CCD_COVER_CODE_DESC(
			HtmlInputText comp_ui_m_ccd_cover_code_desc) {
		COMP_UI_M_CCD_COVER_CODE_DESC = comp_ui_m_ccd_cover_code_desc;
	}

	/**
	 * @return the cOMP_UI_M_CCD_LOSS_TYPE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_CCD_LOSS_TYPE_DESC_LABEL() {
		return COMP_UI_M_CCD_LOSS_TYPE_DESC_LABEL;
	}

	/**
	 * @param comp_ui_m_ccd_loss_type_desc_label
	 *            the cOMP_UI_M_CCD_LOSS_TYPE_DESC_LABEL to set
	 */
	public void setCOMP_UI_M_CCD_LOSS_TYPE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_ccd_loss_type_desc_label) {
		COMP_UI_M_CCD_LOSS_TYPE_DESC_LABEL = comp_ui_m_ccd_loss_type_desc_label;
	}

	/**
	 * @return the cOMP_UI_M_CCD_LOSS_TYPE_DESC
	 */
	public HtmlInputText getCOMP_UI_M_CCD_LOSS_TYPE_DESC() {
		return COMP_UI_M_CCD_LOSS_TYPE_DESC;
	}

	/**
	 * @param comp_ui_m_ccd_loss_type_desc
	 *            the cOMP_UI_M_CCD_LOSS_TYPE_DESC to set
	 */
	public void setCOMP_UI_M_CCD_LOSS_TYPE_DESC(
			HtmlInputText comp_ui_m_ccd_loss_type_desc) {
		COMP_UI_M_CCD_LOSS_TYPE_DESC = comp_ui_m_ccd_loss_type_desc;
	}

	/**
	 * @return the cOMP_UI_M_LIMIT_TYPE_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_LIMIT_TYPE_LABEL() {
		return COMP_UI_M_LIMIT_TYPE_LABEL;
	}

	/**
	 * @param comp_ui_m_limit_type_label
	 *            the cOMP_UI_M_LIMIT_TYPE_LABEL to set
	 */
	public void setCOMP_UI_M_LIMIT_TYPE_LABEL(
			HtmlOutputLabel comp_ui_m_limit_type_label) {
		COMP_UI_M_LIMIT_TYPE_LABEL = comp_ui_m_limit_type_label;
	}

	/**
	 * @return the cOMP_UI_M_LIMIT_TYPE
	 */
	public HtmlInputText getCOMP_UI_M_LIMIT_TYPE() {
		return COMP_UI_M_LIMIT_TYPE;
	}

	/**
	 * @param comp_ui_m_limit_type
	 *            the cOMP_UI_M_LIMIT_TYPE to set
	 */
	public void setCOMP_UI_M_LIMIT_TYPE(HtmlInputText comp_ui_m_limit_type) {
		COMP_UI_M_LIMIT_TYPE = comp_ui_m_limit_type;
	}

	/**
	 * @return the cOMP_UI_M_ILL_TYPE_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_ILL_TYPE_LABEL() {
		return COMP_UI_M_ILL_TYPE_LABEL;
	}

	/**
	 * @param comp_ui_m_ill_type_label
	 *            the cOMP_UI_M_ILL_TYPE_LABEL to set
	 */
	public void setCOMP_UI_M_ILL_TYPE_LABEL(
			HtmlOutputLabel comp_ui_m_ill_type_label) {
		COMP_UI_M_ILL_TYPE_LABEL = comp_ui_m_ill_type_label;
	}

	/**
	 * @return the cOMP_UI_M_ILL_TYPE
	 */
	public HtmlInputText getCOMP_UI_M_ILL_TYPE() {
		return COMP_UI_M_ILL_TYPE;
	}

	/**
	 * @param comp_ui_m_ill_type
	 *            the cOMP_UI_M_ILL_TYPE to set
	 */
	public void setCOMP_UI_M_ILL_TYPE(HtmlInputText comp_ui_m_ill_type) {
		COMP_UI_M_ILL_TYPE = comp_ui_m_ill_type;
	}

	/**
	 * @return the cOMP_UI_M_CCD_DISAB_TYPE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_CCD_DISAB_TYPE_DESC_LABEL() {
		return COMP_UI_M_CCD_DISAB_TYPE_DESC_LABEL;
	}

	/**
	 * @param comp_ui_m_ccd_disab_type_desc_label
	 *            the cOMP_UI_M_CCD_DISAB_TYPE_DESC_LABEL to set
	 */
	public void setCOMP_UI_M_CCD_DISAB_TYPE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_ccd_disab_type_desc_label) {
		COMP_UI_M_CCD_DISAB_TYPE_DESC_LABEL = comp_ui_m_ccd_disab_type_desc_label;
	}

	/**
	 * @return the cOMP_UI_M_CCD_DISAB_TYPE_DESC
	 */
	public HtmlInputText getCOMP_UI_M_CCD_DISAB_TYPE_DESC() {
		return COMP_UI_M_CCD_DISAB_TYPE_DESC;
	}

	/**
	 * @param comp_ui_m_ccd_disab_type_desc
	 *            the cOMP_UI_M_CCD_DISAB_TYPE_DESC to set
	 */
	public void setCOMP_UI_M_CCD_DISAB_TYPE_DESC(
			HtmlInputText comp_ui_m_ccd_disab_type_desc) {
		COMP_UI_M_CCD_DISAB_TYPE_DESC = comp_ui_m_ccd_disab_type_desc;
	}

	/**
	 * @return the cOMP_UI_M_CCD_PROD_CODE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_CCD_PROD_CODE_DESC_LABEL() {
		return COMP_UI_M_CCD_PROD_CODE_DESC_LABEL;
	}

	/**
	 * @param comp_ui_m_ccd_prod_code_desc_label
	 *            the cOMP_UI_M_CCD_PROD_CODE_DESC_LABEL to set
	 */
	public void setCOMP_UI_M_CCD_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_ccd_prod_code_desc_label) {
		COMP_UI_M_CCD_PROD_CODE_DESC_LABEL = comp_ui_m_ccd_prod_code_desc_label;
	}

	/**
	 * @return the cOMP_UI_M_CCD_PROD_CODE_DESC
	 */
	public HtmlInputText getCOMP_UI_M_CCD_PROD_CODE_DESC() {
		return COMP_UI_M_CCD_PROD_CODE_DESC;
	}

	/**
	 * @param comp_ui_m_ccd_prod_code_desc
	 *            the cOMP_UI_M_CCD_PROD_CODE_DESC to set
	 */
	public void setCOMP_UI_M_CCD_PROD_CODE_DESC(
			HtmlInputText comp_ui_m_ccd_prod_code_desc) {
		COMP_UI_M_CCD_PROD_CODE_DESC = comp_ui_m_ccd_prod_code_desc;
	}

	/**
	 * @return the pT_IL_CLAIM_COVER_DTLS_BEAN
	 */
	public PT_IL_CLAIM_COVER_DTLS getPT_IL_CLAIM_COVER_DTLS_BEAN() {
		return PT_IL_CLAIM_COVER_DTLS_BEAN;
	}

	/**
	 * @param pt_il_claim_cover_dtls_bean
	 *            the pT_IL_CLAIM_COVER_DTLS_BEAN to set
	 */
	public void setPT_IL_CLAIM_COVER_DTLS_BEAN(
			PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls_bean) {
		PT_IL_CLAIM_COVER_DTLS_BEAN = pt_il_claim_cover_dtls_bean;
	}

	/**
	 * @return the compositeAction
	 */
	public PILT006_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction
	 *            the compositeAction to set
	 */
	public void setCompositeAction(PILT006_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the helper
	 */
	public PT_IL_CLAIM_COVER_DTLS_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper
	 *            the helper to set
	 */
	public void setHelper(PT_IL_CLAIM_COVER_DTLS_HELPER helper) {
		this.helper = helper;
	}

	/**
	 * @return the dataList_PT_IL_CLAIM_COVER_DTLS
	 */
	public List<PT_IL_CLAIM_COVER_DTLS> getDataList_PT_IL_CLAIM_COVER_DTLS() {
		return dataList_PT_IL_CLAIM_COVER_DTLS;
	}

	/**
	 * @param dataList_PT_IL_CLAIM_COVER_DTLS
	 *            the dataList_PT_IL_CLAIM_COVER_DTLS to set
	 */
	public void setDataList_PT_IL_CLAIM_COVER_DTLS(
			List<PT_IL_CLAIM_COVER_DTLS> dataList_PT_IL_CLAIM_COVER_DTLS) {
		this.dataList_PT_IL_CLAIM_COVER_DTLS = dataList_PT_IL_CLAIM_COVER_DTLS;
	}

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PT_IL_CLAIM_COVER_DTLS_BEAN = new PT_IL_CLAIM_COVER_DTLS();
				helper.whenCreateRecord(compositeAction);		
				helper.whenNewRecordInstance(compositeAction);
				resetAllComponent();
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

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				Connection con = CommonUtils.getConnection();
				new CRUDHandler().executeDelete(PT_IL_CLAIM_COVER_DTLS_BEAN,
						CommonUtils.getConnection());
				con.commit();
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PT_IL_CLAIM_COVER_DTLS
						.remove(PT_IL_CLAIM_COVER_DTLS_BEAN);
				if(dataList_PT_IL_CLAIM_COVER_DTLS!=null && dataList_PT_IL_CLAIM_COVER_DTLS.size()>0){
					for(int i=0;i<dataList_PT_IL_CLAIM_COVER_DTLS.size();i++){
						PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER = dataList_PT_IL_CLAIM_COVER_DTLS.get(i);
						if(i==0){
							PT_IL_CLAIM_COVER.setRowSelected(true);
						}else{
							PT_IL_CLAIM_COVER.setRowSelected(false);
						}
						setPT_IL_CLAIM_COVER_DTLS_BEAN(PT_IL_CLAIM_COVER);
					}
				}
				
				resetAllComponent();
				//PT_IL_CLAIM_COVER_DTLS.setRowSelected(true);
				/*Added by saranya for Avoidance of POST button required in all screens on 21/02/2017*/
				CommonUtils.getConnection().commit();
				/*End*/
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String message = null;
		
		try {
			
			/*Added by saritha on 17-07-2017 for ssp call id ZBILQC-1731636*/
			COMP_CONTEST_PERIOD_MODAL_PANEL.setShowWhenRendered(false);
			/*End*/
			try{
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().checkContestabilityPeriod(COMP_CONTEST_PERIOD_MODAL_PANEL);
			}catch(Exception e){
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
			
			/*Modified by Janani on 05.07.2017 for error while changing confirm flag*/
		
			System.out.println("getCCD_CONFIRM_FLAG in postrecord         "+PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG());
			
			/*if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG().equalsIgnoreCase("Y"))*/
			if(!compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_TYPE().equalsIgnoreCase("O"))
			{
			if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG() != null && PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG().equalsIgnoreCase("Y"))
			{
				
			/*End*/	
				
				boolean flag=false;
				 flag=compositeAction.getPT_IL_CLAIM_ACTION_BEAN().accessValidation();
				if(flag==false)
				{
					throw new Exception("User not authorized");
				}
			}
			}
			if (PT_IL_CLAIM_COVER_DTLS_BEAN.getROWID() == null) {
				if(isINSERT_ALLOWED()){
					helper.preInsert(compositeAction);
					new CRUDHandler().executeInsert(PT_IL_CLAIM_COVER_DTLS_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save"));
					
					resetSelectedRow();
					PT_IL_CLAIM_COVER_DTLS_BEAN.setRowSelected(true);
					dataList_PT_IL_CLAIM_COVER_DTLS.add(PT_IL_CLAIM_COVER_DTLS_BEAN);
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PT_IL_CLAIM_COVER_DTLS_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()){
					helper.preUpdate(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN());
					PT_IL_CLAIM_COVER_DTLS_BEAN.setRowSelected(true);
					new CRUDHandler().executeUpdate(PT_IL_CLAIM_COVER_DTLS_BEAN,CommonUtils.getConnection());
					
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}
			}
			
			
			 /*Added by Janani on 16.06.2017 for ZBILQC-1723136*/ 
			if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG().equalsIgnoreCase("Y"))
			{ 
				System.out.println("Freeze flag Y in save");
				
			 disableAllComponentForFreeze(true);
			 
			}
			 /*End*/
			
			/*added by raja on 19-06-2017 discussed with siva sir*/
			
			funeralCustValidation();
			
			/*end*/
			
			if(!compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_TYPE().equalsIgnoreCase("O"))
			{
			if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG() != null && PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG().equalsIgnoreCase("Y"))
			{
			boolean flag=false;
			 flag=compositeAction.getPT_IL_CLAIM_ACTION_BEAN().accessValidation();
			 if(flag==false)
			 {
				 throw new Exception("User not authorized");
			 }
			}
			}
		
			/*Modified by Janani on 07.07.2017 for Record not Inserted/Updated :: null issue*/
			//if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG().equals("Y"))
			
			if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG() != null && PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG().equals("Y"))
		
			/*End*/
			
			{
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_ADDL_STATUS("CL02");
			
			
			/*Modified by Janani on 07.07.2017 for Record not Inserted/Updated :: null issue*/	
			//if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG().equalsIgnoreCase("Y"))
				
			if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG() != null && PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG().equalsIgnoreCase("Y"))	
			
			/*End*/	
				
			{
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_ADDL_STATUS("CL03");
			}
			else
			{
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_ADDL_STATUS("CL02");
			}
		}
			String query="UPDATE PT_IL_CLAIM SET CLAIM_ADDL_STATUS=? WHERE CLAIM_SYS_ID=?";
			new CRUDHandler().executeUpdateStatement(query, CommonUtils.getConnection(), new Object[]{
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_ADDL_STATUS()
				,compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
			CommonUtils.getConnection().commit();
			
			/*Modified by Janani on 07.07.2017 for Record not Inserted/Updated :: null issue*/	
			
			//if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG().equalsIgnoreCase("Y") && PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG().equalsIgnoreCase("Y"))
			
			if((PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG() != null && PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG() != null) &&
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG().equalsIgnoreCase("Y") 
					&& PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG().equalsIgnoreCase("Y"))
				
			/*End*/	
				
			{
				helper.CLM_EST_OS_AMTS(compositeAction);
			}
			
			/*Added by saranya for Avoidance of POST button required in all screens on 21/02/2017*/
			saveRecord();
			/*End*/
			
			
			 System.out.println("CCD_CONFIRM_FLAG after save      "+PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG());
			
		} catch (Exception exc) {
		
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_CLAIM_COVER_DTLS_BEAN = (PT_IL_CLAIM_COVER_DTLS) dataTable
					.getRowData();
			resetAllComponent();			
			resetSelectedRow();
			if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_RESERVE_DT() == null){
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_RESERVE_DT(new CommonUtils().getCurrentDate());
			}
			PT_IL_CLAIM_COVER_DTLS_BEAN.setRowSelected(true);	
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_CLAIM_COVER_DTLS> PT_IL_CLAIM_COVER_DTLS_ITR = dataList_PT_IL_CLAIM_COVER_DTLS
				.iterator();
		while (PT_IL_CLAIM_COVER_DTLS_ITR.hasNext()) {
			PT_IL_CLAIM_COVER_DTLS_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_CCD_CLOSE_DT.resetValue();
		COMP_CCD_CLOSE_DT.resetValue();
		COMP_CCD_COVER_CODE.resetValue();
		COMP_CCD_COVER_CODE.resetValue();
		COMP_CCD_PROD_CODE.resetValue();
		COMP_CCD_COVER_GROUP_CODE.resetValue();
		COMP_CCD_LOSS_TYPE.resetValue();
		COMP_CCD_DISAB_TYPE.resetValue();
		COMP_CCD_CLAIM_ILL_TYPE.resetValue();
		COMP_CCD_LOSS_TYPE.resetValue();
		COMP_CCD_DISAB_TYPE.resetValue();
		COMP_CCD_PERIOD.resetValue();
		COMP_CCD_NO_OF_DAYS.resetValue();
		COMP_CCD_PERIOD_UNIT.resetValue();
		COMP_CCD_RATE.resetValue();
		COMP_CCD_PERIOD.resetValue();
		COMP_CCD_RATE_PER.resetValue();
		COMP_CCD_NO_OF_DAYS.resetValue();
		COMP_CCD_FC_EST_AMT.resetValue();
		COMP_CCD_RATE.resetValue();
		COMP_CCD_RATE_PER.resetValue();
		COMP_CCD_FRZ_FLAG.resetValue();
		COMP_CCD_FC_EST_AMT.resetValue();
		COMP_CCD_CONFIRM_FLAG.resetValue();
		COMP_CCD_FRZ_FLAG.resetValue();
		COMP_CCD_RESERVE_DT.resetValue();
		COMP_CCD_CONFIRM_FLAG.resetValue();
		COMP_CCD_RESERVE_DT.resetValue();
		COMP_CCD_PERIOD_UNIT.resetValue();
		COMP_CCD_LC_EST_AMT.resetValue();
		COMP_CCD_LC_EST_AMT.resetValue();
		COMP_CCD_SET_FLAG.resetValue();
		COMP_CCD_SET_FLAG.resetValue();
		COMP_CCD_CLAIM_PAY_TO.resetValue();
		COMP_CCD_CLAIM_PAY_TO.resetValue();
		COMP_UI_M_SUB_BEN_LIMIT.resetValue();
		COMP_UI_M_CCD_COVER_CODE_DESC.resetValue();
		COMP_UI_M_CCD_COVER_CODE_DESC.resetValue();
		COMP_UI_M_CCD_LOSS_TYPE_DESC.resetValue();
		COMP_UI_M_CCD_LOSS_TYPE_DESC.resetValue();
		COMP_UI_M_LIMIT_TYPE.resetValue();
		COMP_UI_M_ILL_TYPE.resetValue();
		COMP_UI_M_CCD_DISAB_TYPE_DESC.resetValue();
		COMP_UI_M_CCD_DISAB_TYPE_DESC.resetValue();
		COMP_UI_M_CCD_PROD_CODE_DESC.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		CommonUtils.clearMaps(this);
		String message = null;
		
		try {
			
			/*Added by saranya on 20-04-2017*/
			PT_IL_CLAIM_ESTIMATE PT_IL_CLAIM_ESTIMATE_BEAN = compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN();
			PT_IL_CLAIM PT_IL_CLAIM_BEAN=compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
			PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();
			/*End*/
			
			//newly added query to fetch value for Advance Premium field 26-8-16
			Double Excess_amt=null; 
			Double Adv_premium=null; 
			ResultSet rs=null;
			ResultSet rs1=null;
			String query="SELECT NVL((CONT_LC_POL_DEP_AMT - CONT_LC_POL_UTIL_AMT ),0) EXCESS_AMOUNT "
					+ "FROM PM_IL_CONTRACTOR,PT_IL_CLAIM WHERE CONT_CODE = CLAIM_ASSR_CODE "
					+ "AND CLAIM_POL_SYS_ID = ?";

			String query2="SELECT SUM(PC_LC_GROSS_PREM + PC_LC_CHARGE)FROM PT_IL_PREM_COLL, PT_IL_CLAIM "
					+ "WHERE PC_POL_SYS_ID = CLAIM_POL_SYS_ID AND CLAIM_SYS_ID =? "
					+ "AND PC_SCHD_PYMT_DT > CLAIM_LOSS_DT AND PC_PAID_DT IS NOT NULL AND PC_PAID_FLAG = 'A'";
			
			rs=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()});
			while(rs.next())
			{
			compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().setUI_M_EXCESS_AMOUNT(rs.getDouble("EXCESS_AMOUNT"));
			compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getCOMP_EXCESS_AMOUNT().resetValue();
			}
			Excess_amt=compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getUI_M_EXCESS_AMOUNT();
			
			rs1=new CRUDHandler().executeSelectStatement(query2, CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
			while(rs1.next())
			{
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().setUI_M_ADVANCE_PREMIUM(rs1.getDouble(1));
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getCOMP_ADVANCE_PREMIUM().resetValue();
			}
			
			Adv_premium= compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getUI_M_ADVANCE_PREMIUM();
			
			if(Excess_amt>0.0||Adv_premium>0.0)
			{
				/*CHANGED BY RAJA ON 12-04-2017*/
				/*CHANGED BY RAJA ON 15-05-2017*/
				message = "Please check Excess Amount of USD  $"+" "+Excess_amt+" "+" and Advance Premium  $"+" "+Adv_premium+" "+" Amount Available for this customer.";
				/*Changed by Janani on 14.05.2017 for SSPID ZBILQC-1725649 */

				/*message = "Excess Premium Amount of USD"+" "+Excess_amt+" "+"is Available for this policy.";*/
				/*message = "Excess Premium Amount of USD"+" "+Excess_amt+" "+"is Available for this customer.";*/

				/*end*/
				/*end*/
				
                getWarningMap().put("ERROR",message);
			
			}
			//end
			
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().keyCommitt();
			if(PT_IL_CLAIM_ESTIMATE_BEAN.getCE_REF_NO() == null || (!(PT_IL_CLAIM_ESTIMATE_BEAN.getCE_REF_NO().isEmpty()))){
			generateRefNumOfEstimate();
			}
			
			
/*Added by saranya on 13/04/2017*/
			
			
			
			if("Y".equalsIgnoreCase(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG()) &&
					"Y".equalsIgnoreCase(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG())){
				getPARAM_VALUE_RSRV_CLM();
				if("1".equalsIgnoreCase(getPS_VAL())){
					getGEN_CLM_RESV(compositeAction);
					System.out.println("SYSID_VALUE   :"+getSYSID_VALUE());
					if(getSYSID_VALUE()!=null){
						P9ILPK_CLAIM.GENERATE_CLM_RESERVE(PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID().toString(),getSYSID_VALUE().toString());
						UPDATE_RESERVE_GEN_FLAG(compositeAction);
						
						/* Newly Added By Dhinesh on 14-8-2017 for ssp call id : ZBILQC-1734994 */
						P9ILPK_CLAIM.GENERATE_WOP_RESERVE(PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID().toString());
						UPDATE_RESERVE_GEN_FLAG_WOP(compositeAction);
						/* End */
						
					}
				}
			}
if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PREM_WAIVE_YN()!=null && 
compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PREM_WAIVE_YN().equalsIgnoreCase("Y"))
{	
	getGEN_WOP_RESV(compositeAction);
			if(getSYSID()!=0){
			P9ILPK_CLAIM.GENERATE_WOP_RESERVE(PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID().toString());
			UPDATE_RESERVE_GEN_FLAG_WOP(compositeAction);
			}
			
}			
				/*End*/
			
			CommonUtils.getConnection().commit();
			    String message1=Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
			    
			    /*Added by saranya for Additional field Advance Premium on 26/07/2016*/    
			    /*CHANGED BY RAJA ON 12-04-2017*/
			    /*CHANGED BY RAJA ON 15-05-2017*/
			    message = "Please check Excess Amount of USD  $"+" "+Excess_amt+" "+"  and Advance Premium  $"+" "+Adv_premium+" "+" Amount Available for this customer.";
			    /*Changed by Janani on 14.05.2017 for SSPID ZBILQC-1725649 */

				/*message = "Excess Premium Amount of USD"+" "+Excess_amt+" "+"is Available for this policy.";*/
				/*message = "Excess Premium Amount of USD"+" "+Excess_amt+" "+"is Available for this customer.";*/

				/*end*/
				/*end*/
			if(Excess_amt>0.0||Adv_premium>0.0)
			{
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}
			else
			{
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message1);
			}
			
			/*end*/
			getWarningMap().put("SAVERECORD",message1);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void generateRefNumOfEstimate() throws Exception{
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_CLAIM_ESTIMATE PT_IL_CLAIM_ESTIMATE_BEAN = compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN();
		String C1 = "SELECT SEQ_EST_REF.NEXTVAL FROM DUAL";
		String C2 = "UPDATE PT_IL_CLAIM_ESTIMATE SET CE_REF_NO = ? WHERE CE_CLAIM_SYS_ID = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection);
			Date date = new CommonUtils().getCurrentDate();
			if(resultSet.next()){
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_REF_NO("R" + "/" + resultSet.getString(1));
				handler.executeUpdateStatement(C2, connection,new Object[]{PT_IL_CLAIM_ESTIMATE_BEAN.getCE_REF_NO(),
						PT_IL_CLAIM_ESTIMATE_BEAN.getCE_CLAIM_SYS_ID()});
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	

	public List<SelectItem> getListCCD_FRZ_FLAG() {
		if (listCCD_FRZ_FLAG.size() == 0) {
			listCCD_FRZ_FLAG.clear();
			try {
				listCCD_FRZ_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCCD_FRZ_FLAG;
	}

	public void setListCCD_FRZ_FLAG(List<SelectItem> listCCD_FRZ_FLAG) {
		this.listCCD_FRZ_FLAG = listCCD_FRZ_FLAG;
	}

	public List<SelectItem> getListCCD_CONFIRM_FLAG() {
		if (listCCD_CONFIRM_FLAG.size() == 0) {
			listCCD_CONFIRM_FLAG.clear();
			try {
				listCCD_CONFIRM_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCCD_CONFIRM_FLAG;
	}

	public void setListCCD_CONFIRM_FLAG(List<SelectItem> listCCD_CONFIRM_FLAG) {
		this.listCCD_CONFIRM_FLAG = listCCD_CONFIRM_FLAG;
	}

	public List<SelectItem> getListCCD_PERIOD_UNIT() {
		if (listCCD_PERIOD_UNIT.size() == 0) {
			listCCD_PERIOD_UNIT.clear();
			try {
				listCCD_PERIOD_UNIT = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCCD_PERIOD_UNIT;
	}

	public void setListCCD_PERIOD_UNIT(List<SelectItem> listCCD_PERIOD_UNIT) {
		this.listCCD_PERIOD_UNIT = listCCD_PERIOD_UNIT;
	}

	
	public List<SelectItem> getListCCD_SET_FLAG() {
		if (listCCD_SET_FLAG.size() == 0) {
			listCCD_SET_FLAG.clear();
			try {
				listCCD_SET_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCCD_SET_FLAG;
	}

	public void setListCCD_SET_FLAG(List<SelectItem> listCCD_SET_FLAG) {
		this.listCCD_SET_FLAG = listCCD_SET_FLAG;
	}

	
	public List<SelectItem> getListCCD_CLAIM_PAY_TO() {
		if (listCCD_CLAIM_PAY_TO.size() == 0) {
			listCCD_CLAIM_PAY_TO.clear();
			try {
				listCCD_CLAIM_PAY_TO = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCCD_CLAIM_PAY_TO;
	}

	public void setListCCD_CLAIM_PAY_TO(List<SelectItem> listCCD_CLAIM_PAY_TO) {
		this.listCCD_CLAIM_PAY_TO = listCCD_CLAIM_PAY_TO;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				
				/*Added by saritha on 17-07-2017 for ssp call id ZBILQC-1731636*/
				COMP_CONTEST_PERIOD_MODAL_PANEL.setShowWhenRendered(false);
				/*End*/
				helper.preBlock(compositeAction);
				helper.whenNewBlockInstance();
				helper.executeQuery(compositeAction);
				if(PT_IL_CLAIM_COVER_DTLS_BEAN.getROWID() == null){
					helper.whenCreateRecord(compositeAction);					
				}else{
					helper.postQuery(compositeAction);
					if(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().
				    getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_RESERVE_DT() == null){
				    compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().
				    getPT_IL_CLAIM_COVER_DTLS_BEAN().setCCD_RESERVE_DT(new CommonUtils().getCurrentDate());
					}
					
					/*added by raja on 21-04-2017*/
					CommonUtils.setGlobalVariable("GLOBAL.CLM_COVER_CODE", PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE());
					/*end*/
					
				}
				helper.whenNewRecordInstance(compositeAction);
				
				setBlockFlag(false);
			}
			String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
			if(!callingForm.equalsIgnoreCase("PILT002_APAC")){
				
						if("N".equalsIgnoreCase(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG())){
						PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CONFIRM_FLAG("N");
									this.COMP_CCD_CONFIRM_FLAG.setDisabled(true);
								}
						else{
							this.COMP_CCD_CONFIRM_FLAG.setDisabled(false);
						}
						if("Y".equalsIgnoreCase(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG())&& 
								"Y".equalsIgnoreCase(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG()) && 
								"N".equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().
										getPT_IL_CLAIM_BEAN().getCLAIM_FRZ_FLAG())){
							disableAllComponentForFreeze(true);
						}
						else if("Y".equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().
										getPT_IL_CLAIM_BEAN().getCLAIM_FRZ_FLAG())){
							disableAllComponentForFreeze(true);
							/*Commentted by saranya for RI recovery details to be shown at Claim registration stage itself on 18/02/2017 */
						/*	COMP_CCD_FRZ_FLAG.setDisabled(true);
							COMP_CCD_CONFIRM_FLAG.setDisabled(true);*/
								}
								else{
									disableAllComponentForFreeze(false);
								}
			}else{
				disableAllComponent(true);
			}
			/*String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
			if(callingForm.equalsIgnoreCase("PILT002_APAC")){
				disableAllComponent(true);
			}*/
			if("N".equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().
										getPT_IL_CLAIM_BEAN().getCLAIM_FRZ_FLAG())){
				COMP_UI_M_BUT_RI.setDisabled(false);
				COMP_UI_M_BUT_FAC.setDisabled(false);
			}else{
				COMP_UI_M_BUT_RI.setDisabled(true);
				COMP_UI_M_BUT_FAC.setDisabled(true);
			}
			
			
			/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
			if (("Y".equalsIgnoreCase(compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
					.getCLAIM_FRZ_FLAG()))
					|| ("Y".equalsIgnoreCase(compositeAction
							.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
							.getCLAIM_CLOSE_FLAG()))
					|| ("CL05".equalsIgnoreCase(compositeAction
							.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
							.getCLAIM_ADDL_STATUS()))		) {
				
									disableAllComponent(true,"Y");
				
			} 
			/*END*/
			
			//added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 26-12-16
		/*	String ps_value=getPS_VALUE();
			if(!ps_value.equalsIgnoreCase("1")){
			String flag=validate_asd_char_value_flag();
			if(flag!=null && flag.equalsIgnoreCase("Y")){
				COMP_CCD_FC_EST_AMT.setDisabled(false);
			}else
			{
				COMP_CCD_FC_EST_AMT.setDisabled(true);

			}
			}*/
			//end
			
			
			
			
			 /*Added by Janani on 16.06.2017 for ZBILQC-1723136*/ 
			if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG().equalsIgnoreCase("Y"))
			{ 
				System.out.println("Freeze flag Y in ONLOAD");
				
			 disableAllComponentForFreeze(true);
			 
			}else
			{
				disableAllComponentForFreeze(false);
			}
			 /*End*/
			
			
			
			
	} catch (Exception e) {
			/*Added by saritha on 08-02-2017 for RM018T - FSD_IL_ZB Life_012b_Claim Waiting period COMMENTS*/
			String error =ErrorHelpUtil.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,error);
			e.printStackTrace();	
			/*End*/
			
			
			/*Added  by saritha for ZBILQC-1720199*/
			/*
			  * getErrorMap().put("onLoad", e.getMessage());*/
			getErrorMap().put("onLoad", error);
			
			/*End*/
		}
	}


	/**
	 * Instantiates all components in PT_IL_CLAIM_COVER_DTLS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_CCD_COVER_CODE				 = new HtmlInputText();
		COMP_CCD_PROD_CODE				 = new HtmlInputText();
		COMP_CCD_COVER_GROUP_CODE			 = new HtmlInputText();
		COMP_CCD_LOSS_TYPE				 = new HtmlInputText();
		COMP_CCD_DISAB_TYPE				 = new HtmlInputText();
		COMP_CCD_CLAIM_ILL_TYPE				 = new HtmlInputText();
		COMP_CCD_PERIOD					 = new HtmlInputText();
		COMP_CCD_RATE_PER				 = new HtmlInputText();
		COMP_CCD_NO_OF_DAYS				 = new HtmlInputText();
		COMP_CCD_RATE					 = new HtmlInputText();
		COMP_CCD_FC_EST_AMT				 = new HtmlInputText();
		COMP_CCD_LC_EST_AMT				 = new HtmlInputText();
		COMP_UI_M_SUB_BEN_LIMIT				 = new HtmlInputText();
		COMP_UI_M_CCD_COVER_CODE_DESC			 = new HtmlInputText();
		COMP_UI_M_CCD_LOSS_TYPE_DESC			 = new HtmlInputText();
		COMP_UI_M_LIMIT_TYPE				 = new HtmlInputText();
		COMP_UI_M_ILL_TYPE				 = new HtmlInputText();
		COMP_UI_M_CCD_DISAB_TYPE_DESC			 = new HtmlInputText();
		COMP_UI_M_CCD_PROD_CODE_DESC			 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_CCD_PERIOD_UNIT				 = new HtmlSelectOneMenu();
		COMP_CCD_FRZ_FLAG				 = new HtmlSelectOneMenu();
		COMP_CCD_CONFIRM_FLAG				 = new HtmlSelectOneMenu();
		COMP_CCD_SET_FLAG				 = new HtmlSelectOneMenu();
		COMP_CCD_CLAIM_PAY_TO				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_CCD_CLOSE_DT				 = new HtmlCalendar();
		COMP_CCD_RESERVE_DT				 = new HtmlCalendar();
		COMP_UI_M_BUT_RI = new HtmlCommandButton();
		COMP_UI_M_BUT_FAC = new HtmlCommandButton();
		COMP_UI_M_BUT_HISTORY = new HtmlCommandButton();
		
		COMP_UI_M_REFUND_RISK_PREM = new HtmlInputText();
		COMP_UI_M_REFUND_SERV_FEE= new HtmlInputText();
		COMP_UI_M_REFUND_WAK_FEE= new HtmlInputText();
		
		UI_M_BUT_ADD =new 	HtmlAjaxCommandButton ();
		UI_M_BUT_DEL =new 	HtmlAjaxCommandButton ();	
		UI_M_BUT_POST =new 	HtmlAjaxCommandButton ();	
	}


	/**
	 * Disables all components in PT_IL_CLAIM_COVER_DTLS_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_CCD_COVER_CODE.setDisabled(disabled);
		COMP_CCD_PROD_CODE.setDisabled(disabled);
		COMP_CCD_COVER_GROUP_CODE.setDisabled(disabled);
		COMP_CCD_LOSS_TYPE.setDisabled(disabled);
		COMP_CCD_DISAB_TYPE.setDisabled(disabled);
		COMP_CCD_CLAIM_ILL_TYPE.setDisabled(disabled);
		COMP_CCD_PERIOD.setDisabled(disabled);
		//COMP_CCD_RATE_PER.setDisabled(disabled);
		COMP_CCD_NO_OF_DAYS.setDisabled(disabled);
	//	COMP_CCD_RATE.setDisabled(disabled);
		/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 27/12/16*/
		//COMP_CCD_FC_EST_AMT.setDisabled(disabled);
		//COMP_CCD_LC_EST_AMT.setDisabled(disabled);
		String ps_value_1=null;
		try {
			ps_value_1 = getPS_VALUE();
		} catch (Exception e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
		//end
		if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("1")){
			COMP_CCD_FC_EST_AMT.setDisabled(disabled);
			COMP_CCD_LC_EST_AMT.setDisabled(disabled);
			}
		COMP_UI_M_SUB_BEN_LIMIT.setDisabled(disabled);
		COMP_UI_M_CCD_COVER_CODE_DESC.setDisabled(disabled);
		COMP_UI_M_CCD_LOSS_TYPE_DESC.setDisabled(disabled);
		COMP_UI_M_LIMIT_TYPE.setDisabled(disabled);
		COMP_UI_M_ILL_TYPE.setDisabled(disabled);
		COMP_UI_M_CCD_DISAB_TYPE_DESC.setDisabled(disabled);
		COMP_UI_M_CCD_PROD_CODE_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_CCD_PERIOD_UNIT.setDisabled(disabled);
		/* Modified by saranya for RI recovery details to be shown at Claim registration stage itself on 18/02/2017 */
		//COMP_CCD_FRZ_FLAG.setDisabled(disabled);
		//COMP_CCD_CONFIRM_FLAG.setDisabled(disabled);
		/*End*/
		COMP_CCD_SET_FLAG.setDisabled(disabled);
		COMP_CCD_CLAIM_PAY_TO.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_CCD_CLOSE_DT.setDisabled(disabled);
		COMP_CCD_RESERVE_DT.setDisabled(disabled);
		COMP_UI_M_BUT_RI.setDisabled(disabled);
		COMP_UI_M_BUT_FAC.setDisabled(disabled);
		COMP_UI_M_BUT_HISTORY.setDisabled(disabled);
		
		COMP_UI_M_REFUND_SERV_FEE.setDisabled(disabled);
		COMP_UI_M_REFUND_WAK_FEE.setDisabled(disabled);
		COMP_UI_M_REFUND_RISK_PREM.setDisabled(disabled);
		

		
	}
	
	public void disableAllComponentForFreeze(boolean disabled){
		COMP_CCD_COVER_CODE.setDisabled(disabled);
		COMP_CCD_PROD_CODE.setDisabled(disabled);
		COMP_CCD_COVER_GROUP_CODE.setDisabled(disabled);
		COMP_CCD_LOSS_TYPE.setDisabled(disabled);
		COMP_CCD_DISAB_TYPE.setDisabled(disabled);
		COMP_CCD_CLAIM_ILL_TYPE.setDisabled(disabled);
		COMP_CCD_PERIOD.setDisabled(disabled);	
		//COMP_CCD_RATE_PER.setDisabled(disabled);
		COMP_CCD_NO_OF_DAYS.setDisabled(disabled);
		//COMP_CCD_RATE.setDisabled(disabled);
		/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 27/12/16*/
		//COMP_CCD_FC_EST_AMT.setDisabled(disabled);
		//COMP_CCD_LC_EST_AMT.setDisabled(disabled);
		String ps_value_1=null;
		String flag=null;
		try {
			flag=validate_asd_char_value_flag();
			ps_value_1 = getPS_VALUE();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("1")){
			COMP_CCD_FC_EST_AMT.setDisabled(disabled);
			COMP_CCD_LC_EST_AMT.setDisabled(disabled);
		}else{
		
			
			/*Commented by Janani on 13.07.2017 for ZBILQC-1731343 and as per Siva's suggestion .If freeze flag is Y then
			 *  all fields should be disabled,irrespective of any user authorisation rights*/
			
			
			/*changed by raja on 11-08-2017 for ZBILQC-1726818*/ 
			if(flag!=null && flag.equalsIgnoreCase("Y")){
				/*Newly added if condition (since claims confirm flag value not checked null value coming or not)
				 *  by pidugu raj dt: 21-12-2020 for Alliance IL*/
				if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG() != null){
				if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG().equalsIgnoreCase("Y"))
				{ 
				COMP_CCD_FC_EST_AMT.setDisabled(true);
				}
				else
				{
					COMP_CCD_FC_EST_AMT.setDisabled(false);
				}
				}//End
			}else
			{
				COMP_CCD_FC_EST_AMT.setDisabled(true);

			}
			//COMP_CCD_FC_EST_AMT.setDisabled(disabled);
			/*end*/
			/*End*/
			
			
		}
		//end
		COMP_UI_M_SUB_BEN_LIMIT.setDisabled(disabled);
		COMP_UI_M_CCD_COVER_CODE_DESC.setDisabled(disabled);
		COMP_UI_M_CCD_LOSS_TYPE_DESC.setDisabled(disabled);
		COMP_UI_M_LIMIT_TYPE.setDisabled(disabled);
		COMP_UI_M_ILL_TYPE.setDisabled(disabled);
		COMP_UI_M_CCD_DISAB_TYPE_DESC.setDisabled(disabled);
		COMP_UI_M_CCD_PROD_CODE_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_CCD_PERIOD_UNIT.setDisabled(disabled);
		COMP_CCD_SET_FLAG.setDisabled(disabled);
		COMP_CCD_CLAIM_PAY_TO.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_CCD_CLOSE_DT.setDisabled(disabled);
		COMP_CCD_RESERVE_DT.setDisabled(disabled);
		//COMP_UI_M_BUT_RI.setDisabled(disabled);
		//COMP_UI_M_BUT_FAC.setDisabled(disabled);
		COMP_UI_M_BUT_HISTORY.setDisabled(disabled);
		
		COMP_UI_M_REFUND_SERV_FEE.setDisabled(disabled);
		COMP_UI_M_REFUND_WAK_FEE.setDisabled(disabled);
		COMP_UI_M_REFUND_RISK_PREM.setDisabled(disabled);
		/* Modified by saranya for RI recovery details to be shown at Claim registration stage itself on 18/02/2017 */
		/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
		//COMP_CCD_FRZ_FLAG.setDisabled(disabled);
		//COMP_CCD_CONFIRM_FLAG.setDisabled(disabled);
		//end
		/*End*/
		
		/*UI_M_BUT_ADD.setDisabled(disabled);
		UI_M_BUT_DEL.setDisabled(disabled);
		UI_M_BUT_POST.setDisabled(disabled);*/
		
/*Added by Janani on 16.06.2017 for ZBILQC-1723136*/ 
		
		COMP_CCD_EMAIL.setDisabled(disabled);
		
		/*End*/
		
	}
	/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
	public void disableAllComponent(boolean disabled,String flag){
		COMP_CCD_COVER_CODE.setDisabled(disabled);
		COMP_CCD_PROD_CODE.setDisabled(disabled);
		COMP_CCD_COVER_GROUP_CODE.setDisabled(disabled);
		COMP_CCD_LOSS_TYPE.setDisabled(disabled);
		COMP_CCD_DISAB_TYPE.setDisabled(disabled);
		COMP_CCD_CLAIM_ILL_TYPE.setDisabled(disabled);
		COMP_CCD_PERIOD.setDisabled(disabled);
		COMP_CCD_RATE_PER.setDisabled(disabled);
		COMP_CCD_NO_OF_DAYS.setDisabled(disabled);
		COMP_CCD_RATE.setDisabled(disabled);
		COMP_CCD_FC_EST_AMT.setDisabled(disabled);
		COMP_CCD_LC_EST_AMT.setDisabled(disabled);
		COMP_UI_M_SUB_BEN_LIMIT.setDisabled(disabled);
		COMP_UI_M_CCD_COVER_CODE_DESC.setDisabled(disabled);
		COMP_UI_M_CCD_LOSS_TYPE_DESC.setDisabled(disabled);
		COMP_UI_M_LIMIT_TYPE.setDisabled(disabled);
		COMP_UI_M_ILL_TYPE.setDisabled(disabled);
		COMP_UI_M_CCD_DISAB_TYPE_DESC.setDisabled(disabled);
		COMP_UI_M_CCD_PROD_CODE_DESC.setDisabled(disabled);
		COMP_CCD_PERIOD_UNIT.setDisabled(disabled);
		COMP_CCD_SET_FLAG.setDisabled(disabled);
		COMP_CCD_CLAIM_PAY_TO.setDisabled(disabled);
		COMP_CCD_CLOSE_DT.setDisabled(disabled);
		COMP_CCD_RESERVE_DT.setDisabled(disabled);
		COMP_UI_M_BUT_RI.setDisabled(false);
		COMP_UI_M_BUT_FAC.setDisabled(false);
		COMP_UI_M_BUT_HISTORY.setDisabled(disabled);
		COMP_UI_M_REFUND_SERV_FEE.setDisabled(disabled);
		COMP_UI_M_REFUND_WAK_FEE.setDisabled(disabled);
		COMP_UI_M_REFUND_RISK_PREM.setDisabled(disabled);
		COMP_CCD_FRZ_FLAG.setDisabled(disabled);
		COMP_CCD_CONFIRM_FLAG.setDisabled(disabled);
		/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
		UI_M_BUT_ADD.setDisabled(disabled);
		UI_M_BUT_DEL.setDisabled(disabled);
		UI_M_BUT_POST.setDisabled(disabled);
	//END
	}
/*end*/
	
	

	/**
	 * @return the suggestionLOV
	 */
	public List<LovBean> getSuggestionLOV() {
		return suggestionLOV;
	}

	/**
	 * @param suggestionLOV the suggestionLOV to set
	 */
	public void setSuggestionLOV(List<LovBean> suggestionLOV) {
		this.suggestionLOV = suggestionLOV;
	}

	/**
	 * @return the filterByCCD_COVER_CODE
	 */
	public String getFilterByCCD_COVER_CODE() {
		return filterByCCD_COVER_CODE;
	}

	/**
	 * @param filterByCCD_COVER_CODE the filterByCCD_COVER_CODE to set
	 */
	public void setFilterByCCD_COVER_CODE(String filterByCCD_COVER_CODE) {
		this.filterByCCD_COVER_CODE = filterByCCD_COVER_CODE;
	}

	/**
	 * @return the filterByCCD_LOSS_TYPE
	 */
	public String getFilterByCCD_LOSS_TYPE() {
		return filterByCCD_LOSS_TYPE;
	}

	/**
	 * @param filterByCCD_LOSS_TYPE the filterByCCD_LOSS_TYPE to set
	 */
	public void setFilterByCCD_LOSS_TYPE(String filterByCCD_LOSS_TYPE) {
		this.filterByCCD_LOSS_TYPE = filterByCCD_LOSS_TYPE;
	}

	/**
	 * @return the filterByCCD_DISAB_TYPE
	 */
	public String getFilterByCCD_DISAB_TYPE() {
		return filterByCCD_DISAB_TYPE;
	}

	/**
	 * @param filterByCCD_DISAB_TYPE the filterByCCD_DISAB_TYPE to set
	 */
	public void setFilterByCCD_DISAB_TYPE(String filterByCCD_DISAB_TYPE) {
		this.filterByCCD_DISAB_TYPE = filterByCCD_DISAB_TYPE;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DEL
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	/**
	 * @param ui_m_but_del the uI_M_BUT_DEL to set
	 */
	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}
	
	/**
	 * @return the uI_COMP_CCD_COVER_CODE_DESC
	 */
	public HtmlInputText getUI_COMP_CCD_COVER_CODE_DESC() {
		return UI_COMP_CCD_COVER_CODE_DESC;
	}

	/**
	 * @param ui_comp_ccd_cover_code_desc the uI_COMP_CCD_COVER_CODE_DESC to set
	 */
	public void setUI_COMP_CCD_COVER_CODE_DESC(
			HtmlInputText ui_comp_ccd_cover_code_desc) {
		UI_COMP_CCD_COVER_CODE_DESC = ui_comp_ccd_cover_code_desc;
	}

	/**
	 * @return the log
	 */
	public static Log getLog() {
		return log;
	}

	/**
	 * @return the cOMP_CCD_LOSS_TYPE_DESC
	 */
	public HtmlInputText getCOMP_CCD_LOSS_TYPE_DESC() {
		return COMP_CCD_LOSS_TYPE_DESC;
	}

	/**
	 * @param comp_ccd_loss_type_desc the cOMP_CCD_LOSS_TYPE_DESC to set
	 */
	public void setCOMP_CCD_LOSS_TYPE_DESC(HtmlInputText comp_ccd_loss_type_desc) {
		COMP_CCD_LOSS_TYPE_DESC = comp_ccd_loss_type_desc;
	}

	/**
	 * @return the cOMP_CCD_DISAB_TYPE_DESC
	 */
	public HtmlInputText getCOMP_CCD_DISAB_TYPE_DESC() {
		return COMP_CCD_DISAB_TYPE_DESC;
	}

	/**
	 * @param comp_ccd_disab_type_desc the cOMP_CCD_DISAB_TYPE_DESC to set
	 */
	public void setCOMP_CCD_DISAB_TYPE_DESC(HtmlInputText comp_ccd_disab_type_desc) {
		COMP_CCD_DISAB_TYPE_DESC = comp_ccd_disab_type_desc;
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
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> coverCodeSuggestionLOV(Object event){
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			log.debug("=========Inside Cover code Suggestion=====>"+compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_PLAN_CODE());
			suggestionLOV = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM_COVER_DTLS", "CCD_COVER_CODE", 
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_PLAN_CODE(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_SYS_ID(),
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_LOSS_DT(), 
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_TYPE(), 
					null, (String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		
		return suggestionLOV;
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> lossTypeSuggestionLOV(Object event){
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM_COVER_DTLS", "CCD_LOSS_TYPE", 
					"IL_LOS_TYP", 
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(), 
					null, 
					null, 
					null, (String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		
		return suggestionLOV;
	}
	
	/**
	 * 
	 */
	public void setLossTypeSUGGESTION_VALUE(){
		try{
			String lossType = (String) this.getCOMP_CCD_LOSS_TYPE().getSubmittedValue().toString();
			this.PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_LOSS_TYPE(lossType);
			
			if(suggestionLOV!=null){
				Iterator<LovBean> claimIterator = suggestionLOV.iterator();
				while(claimIterator.hasNext()){
					LovBean lovBean = claimIterator.next();
					if(lossType!=null && lossType.equals(lovBean.getCode())){
						this.getCOMP_UI_M_CCD_LOSS_TYPE_DESC().setSubmittedValue(lovBean.getName());
						this.PT_IL_CLAIM_COVER_DTLS_BEAN.setUI_M_CCD_LOSS_TYPE_DESC(lovBean.getName());
						return;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
	}
	
	public void validatorLossType(FacesContext context, UIComponent component, Object value){
		try{
			helper.whenValidateClaimCoverLossType(compositeAction, value);
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_LOSS_TYPE((String)value);
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
				
	
	
	public void validatorFreeze(FacesContext context, UIComponent component, Object value){
		
		
/*Added by Janani on 23.05.2017 for Factory testing feedback point(Checklist)*/
		
		CommonUtils.clearMaps(this);
		
		/*End*/
		
		try{
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_FRZ_FLAG((String)value);
			helper.whenListChangedCCD_FRZ_FLAG(compositeAction, value);
			COMP_CCD_CONFIRM_FLAG.resetValue();
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*changed the method by raja on 07-06-2017 for hands on points*/

/*	public void validatorConfirmFlag(FacesContext context, UIComponent component, Object value){*/
		
	public void validatorConfirmFlag(ActionEvent event){
		try{
			/*PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CONFIRM_FLAG((String)value);*/
			String value=(String)COMP_CCD_CONFIRM_FLAG.getSubmittedValue();
			
			/*added by raja on 07-06-2017 for hands on points*/
			
				
			/*Modified by Janani on 23.06.2017 for ZBILQC-1721216*/
			
			/*boolean flag=false;
				 flag=compositeAction.getPT_IL_CLAIM_ACTION_BEAN().accessValidation();
				if(flag==true)
				{
					PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CONFIRM_FLAG((String)value);
					helper.whenListChangedCCD_CONFIRM_FLAG(compositeAction, value);
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_ADDL_STATUS("CL03");
					  compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_CLAIM_ADDL_STATUS(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_ADDL_STATUS()+" :- "+compositeAction.getPT_IL_CLAIM_ACTION_BEAN().addilStatusDesc());
					helper.whenListChangedCCD_CONFIRM_FLAG(compositeAction, value);
				}
				else
				{
					throw new Exception("User not authorized");
				}*/
		
	       System.out.println("enters into validatorConfirmFlag");
			
			System.out.println("value          "+value);
			
			/*commanted by gopi for kic on 18/03/2019*/
			/*if(!compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_TYPE().equalsIgnoreCase("O"))
			{
				
			

			boolean flag=false;
			 flag=compositeAction.getPT_IL_CLAIM_ACTION_BEAN().accessValidation();
			 
			 
			 System.out.println("flag          "+flag);
			 System.out.println("CCD_CONFIRM_FLAG before          "+PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG());
			 System.out.println("flag          "+flag);
			 
			 
			if(flag==true)
			{*/
			/*end by gopi for kic on 18/03/2019*/
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CONFIRM_FLAG((String)value);
				helper.whenListChangedCCD_CONFIRM_FLAG(compositeAction, value);
				if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG()!= null && PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG().equalsIgnoreCase("Y"))
				{
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_ADDL_STATUS("CL03");
				}
				else
				{
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_ADDL_STATUS("CL02");
				}
				String query="UPDATE PT_IL_CLAIM SET CLAIM_ADDL_STATUS=? WHERE CLAIM_SYS_ID=?";
				new CRUDHandler().executeUpdateStatement(query, CommonUtils.getConnection(), new Object[]{
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_ADDL_STATUS()
					,compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
				CommonUtils.getConnection().commit();
				
				  compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_CLAIM_ADDL_STATUS(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_ADDL_STATUS()+" :- "+compositeAction.getPT_IL_CLAIM_ACTION_BEAN().addilStatusDesc());
		/*commanted by gopi for kic on 18/03/2019*/
			/*}
			else
			{
				throw new Exception("User not authorized");
			}*/
			/*}
			else
			{
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CONFIRM_FLAG((String)value);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_ADDL_STATUS("CL03");
			}
			*/
				  /*end by gopi for kic on 18/03/2019*/
			 System.out.println("CCD_CONFIRM_FLAG after          "+PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG());
			
			/*End*/
				/*added by raja on 05-07-2017 for ex-gratia*/
			 String flag=null;
			flag=validate_asd_char_value_flag();
			
			System.out.println("exgratia flag          "+flag);
			
			
			if(flag.equalsIgnoreCase("Y"))
			{
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CONFIRM_FLAG((String)value);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_ADDL_STATUS("CL03");
			}
			else
			{
				System.out.println("exgratia flag  is N");
			}
			/*end*/
			
			/*Added by saritha on 17-07-2017 for ssp call id ZBILQC-1731636*/
			if(value.equalsIgnoreCase("Y")){
				
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().checkContestabilityPeriod(COMP_CONTEST_PERIOD_MODAL_PANEL);
			}else{
				COMP_CONTEST_PERIOD_MODAL_PANEL.setShowWhenRendered(false);
			}
			 compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().disableAllComponentForFreeze(true);
			/*End*/
		}catch(Exception e){
			e.printStackTrace();
			/*changed by raja on 07-06-2017 for hands on points*/
			/*throw new ValidatorException(new FacesMessage(e.getMessage()));*/
			getErrorMap().put("current", e.getMessage());
		}
	}
	
	
	
	public void validatorConfirmFlag_old(ActionEvent event){
		try{
			/*PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CONFIRM_FLAG((String)value);*/
			String value=(String)COMP_CCD_CONFIRM_FLAG.getSubmittedValue();
			
			System.out.println("enters into validatorConfirmFlag");
			
			System.out.println("value          "+value);
			
			/*added by raja on 07-06-2017 for hands on points*/
			
				boolean flag=false;
				 flag=compositeAction.getPT_IL_CLAIM_ACTION_BEAN().accessValidation();
				 
				 System.out.println("flag          "+flag);
				 System.out.println("CCD_CONFIRM_FLAG          "+PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG());
				 System.out.println("flag          "+flag);
				 
				 
				 
				if(flag==true)
				{
					PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CONFIRM_FLAG((String)value);
					helper.whenListChangedCCD_CONFIRM_FLAG(compositeAction, value);
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_ADDL_STATUS("CL03");
					  compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_CLAIM_ADDL_STATUS(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_ADDL_STATUS()+" :- "+compositeAction.getPT_IL_CLAIM_ACTION_BEAN().addilStatusDesc());
					//helper.whenListChangedCCD_CONFIRM_FLAG(compositeAction, value);
				}
				else
				{
					throw new Exception("User not authorized");
				}
		
			
				
			
			
			/*end*/
		}catch(Exception e){
			e.printStackTrace();
			/*changed by raja on 07-06-2017 for hands on points*/
			/*throw new ValidatorException(new FacesMessage(e.getMessage()));*/
			getErrorMap().put("current", e.getMessage());
		}
	}
	

	public void validateLossType(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	
	public List<LovBean> disableTypeSuggestionLOV(Object event){
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM_COVER_DTLS", "CCD_DISAB_TYPE", 
					"IL_DIS_TYP", 
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(), 
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_LOSS_TYPE(), 
					null, 
					null, (String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		
		return suggestionLOV;
	}
	
	/**
	 * 
	 */
	public void setDisableTypeSUGGESTION_VALUE(){
		try{
			String disableType = (String) this.getCOMP_CCD_DISAB_TYPE().getSubmittedValue().toString();
			this.PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_DISAB_TYPE(disableType);
			
			if(suggestionLOV!=null){
				Iterator<LovBean> claimIterator = suggestionLOV.iterator();
				while(claimIterator.hasNext()){
					LovBean lovBean = claimIterator.next();
					if(disableType!=null && disableType.equals(lovBean.getCode())){
						this.getCOMP_UI_M_CCD_DISAB_TYPE_DESC().setSubmittedValue(lovBean.getName());
						this.PT_IL_CLAIM_COVER_DTLS_BEAN.setUI_M_CCD_DISAB_TYPE_DESC(lovBean.getName());
						return;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
	}
	
	
	public void validatorDisableType(FacesContext context, UIComponent component, Object value){
		String currValue = (String)value;
		String beanValue = getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_DISAB_TYPE();
		try{
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_DISAB_TYPE((String)value);
			if (!currValue.equalsIgnoreCase(beanValue)) {
			helper.whenValidateItemCCDDISABLETYPE(compositeAction, value);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
		
		

	/**
	 * 
	 * @param event
	 */
	public void validateDisableType(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/**
	 * 
	 */
	public void setCoverCode_SUGGESTION_VALUE(){
		try{
			String coverCode = (String) this.getCOMP_CCD_COVER_CODE().getSubmittedValue();
			this.PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_COVER_CODE(coverCode);
			
			if(suggestionLOV!=null){
				Iterator<LovBean> claimIterator = suggestionLOV.iterator();
				while(claimIterator.hasNext()){
					LovBean lovBean = claimIterator.next();
					if(coverCode!=null && coverCode.equals(lovBean.getCode())){
						this.getCOMP_UI_M_CCD_COVER_CODE_DESC().setSubmittedValue(lovBean.getName());
						this.PT_IL_CLAIM_COVER_DTLS_BEAN.setUI_M_CCD_COVER_CODE_DESC(lovBean.getName());
						return;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
	}
	
	
	public void validatorCoverCode(FacesContext context, UIComponent component, Object value){
		try{
			helper.whenValidateCoverCode(compositeAction, value);
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_COVER_CODE((String)value);
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	/**
	 * 
	 * @param event
	 */
	public void validateCoverCode(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	
	public void validatorPeriod(FacesContext context, UIComponent component, Object value){
		try{
			helper.whenValidateCCPERIOD(PT_IL_CLAIM_COVER_DTLS_BEAN, value);
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_PERIOD((Integer)value);
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void validatePeriod(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void validatorCCNoOfDays(FacesContext context, UIComponent component, Object value){
		try{
			helper.whenValidateCCDNoOfDays(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(),
					PT_IL_CLAIM_COVER_DTLS_BEAN, value);
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_NO_OF_DAYS((Integer)value);
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*added by gopi for ppd rider cover issue on 21/03/2019*/
	public void validatorCCD_RATE_PER(FacesContext context, UIComponent component, Object value){
		try{
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_RATE_PER((Double)value);
			PILT006_APAC_PROCEDURE dbProcedure = new PILT006_APAC_PROCEDURE();
			ArrayList<OracleParameter> outputList = dbProcedure.P_PPDA_EST_AMT(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CLAIM_SYS_ID(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_RATE(),
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_RATE_PER(), PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FC_EST_AMT(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_LC_EST_AMT());
			Double CCD_FC_EST_AMT =  (Double)outputList.get(0).getValueObject();
			Double CCD_LC_EST_AMT =  (Double)outputList.get(1).getValueObject();
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_FC_EST_AMT(CCD_FC_EST_AMT);
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_LC_EST_AMT(CCD_LC_EST_AMT);
			COMP_CCD_FC_EST_AMT.resetValue();
			COMP_CCD_LC_EST_AMT.resetValue();
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}	
	
	public void validatorCCD_RATE(FacesContext context, UIComponent component, Object value){
		try{
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_RATE((Double)value);
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}	
	/*end*/
	/**
	 * 
	 * @param event
	 */
	public void validateCCNoOfDays(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	

	/*Uncommented by ganesh on 18-05-2017 , ZBILQC-1719755 for exgratia issue*/
	public void validatorFCAmtEstimate(FacesContext context, UIComponent component, Object value){
			
		/*Added by Janani on 18.08.2017 for ZBILQC-1719755*/
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet C0_REC = null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C6_REC = null;
				
		/*String C0 = "SELECT POAC_FC_SA, POL_FC_SUM_ASSURED"
				+ " FROM PT_IL_POL_ADDL_COVER, PT_IL_POLICY"
				+ " WHERE POAC_POL_SYS_ID = POL_SYS_ID"
				+ " AND POAC_COVER_CODE = ?  AND POAC_ASSR_CODE = ? ";*/
		
		/*QUERY MODIFIED BY GOPI FOR SSP CALL ID ZBLIFE-1460781 ON 05/11/17*/
		/*String C0 = "SELECT POAC_FC_SA"
				+ " FROM PT_IL_POL_ADDL_COVER, PT_IL_POLICY"
				+ " WHERE POAC_POL_SYS_ID = POL_SYS_ID"
				+ " AND POAC_COVER_CODE = ?  AND POAC_ASSR_CODE = ? ";*/
		String C0 = "SELECT POL_FC_SUM_ASSURED FROM PT_IL_POLICY WHERE POL_NO=? ";
		
		String C1 = "SELECT PFMD_SA FROM PT_IL_POL_FUNERAL_MEMB_DTLS, PM_IL_PLAN,"
				+ " PT_IL_POLICY WHERE POL_PLAN_CODE = PLAN_CODE"
				+ " AND POL_SYS_ID = PFMD_POL_SYS_ID AND PLAN_TYPE = ? "
				+ " AND PFMD_POL_SYS_ID = ? AND PFMD_CUST_CODE= ? ";
		
		String C2 = "SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID= ?";
		
		String C3="SELECT PLAN_TYPE,PROD_UNIT_LINK_TYPE FROM PM_IL_PLAN,PM_IL_PRODUCT WHERE PLAN_CODE = PROD_CODE AND PLAN_CODE= ?";
					
		String C4 = "SELECT UFR_NO_OF_UNITS FROM PS_IL_UNIT_FUND_REG WHERE UFR_POL_SYS_ID = ?";
				
		/*MOdified by Janani on 15.09.2017 for ZBLIFE-1440369*/
		
		/*String C5 = "SELECT POAC_FC_SA, POL_FC_SUM_ASSURED"
				+ " FROM PT_IL_POL_ADDL_COVER, PT_IL_POLICY"
				+ " WHERE POAC_POL_SYS_ID = POL_SYS_ID"
				+ " AND POAC_COVER_CODE = ?  AND POL_NO = ? ";*/
		
		
		String C5 ="SELECT POAC_FC_SA FROM PT_IL_POL_ADDL_COVER, PT_IL_POLICY"
				+ " WHERE POAC_POL_SYS_ID = POL_SYS_ID AND POAC_COVER_CODE = ?"
				+ " AND POL_NO = ? "
				+ " UNION"
				+ " SELECT POL_FC_SUM_ASSURED"
				+ " FROM PT_IL_POLICY WHERE POL_PLAN_CODE = ?  AND POL_NO = ? ";
		
		/*End of ZBLIFE-1440369*/
		
		String C6="SELECT CR_APPLIED_ON FROM PM_IL_CLM_REPAY WHERE CR_COVER_CODE= ? AND CR_LOSS_TYPE = ? AND CR_DISABLE_TYPE= ?";
		
		
		Double POAC_FC_SA = 0.0;
		Double POL_FC_SUM_ASSURED = 0.0;
		String POL_PROD_CODE = null;
		String PLAN_TYPE = null;
		Double PFMD_SA = 0.0;
		String PROD_UNIT_LINK_TYPE = null;
		Double UFR_NO_OF_UNITS = 0.0;
		String CR_APPLIED_ON = null;
		Double SUM_ASSR = 0.0;
		
		/*End*/
		
		
		try
		{
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 26/12/16*/
						
				
				/*Modified by Janani on 01.07.2017 for ZBILQC-1724476*/
				
				/*if((Double.compare(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FC_EST_AMT().doubleValue(),Double.parseDouble(value.toString()))!=0))
				{
				Double number_amount=validate_asd_num_value();
				Double estimate_amt=PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FC_EST_AMT();
				if(number_amount!=null && estimate_amt!=null){
				if(estimate_amt>number_amount){
					throw new Exception("claim estimation amount of "+estimate_amt +" is greater than the ex-gratia limit  of " +number_amount +" for this User");                   
				}
				}
				}*/
				
				System.out.println("getCCD_FC_EST_AMT                "+PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FC_EST_AMT());
				System.out.println("value"+value.toString());
				
				/*Added by Janani on 18.08.2017 for ZBILQC-1719755*/
				
				connection = CommonUtils.getConnection();


				C2_REC= handler.executeSelectStatement(C2, connection,
						new Object[] {compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()});
				while (C2_REC.next()) {
					POL_PROD_CODE = C2_REC.getString("POL_PROD_CODE");
				}

				System.out.println("Product Code****************"+POL_PROD_CODE);

				C3_REC = handler.executeSelectStatement(C3, connection,
						new Object[] {POL_PROD_CODE});
				while (C3_REC.next())
				{
					PLAN_TYPE = C3_REC.getString("PLAN_TYPE");
					PROD_UNIT_LINK_TYPE = C3_REC.getString("PROD_UNIT_LINK_TYPE");
				}

				System.out.println("Plan type****************"+PLAN_TYPE);
				System.out.println("PROD_UNIT_LINK_TYPE****************"+PROD_UNIT_LINK_TYPE);
				
				Double est_amt = Double.valueOf(value.toString());

				System.out.println("est_amt                     "+est_amt);
				

				System.out.println("getCCD_COVER_CODE ****************"+PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE());
				System.out.println("getCCD_LOSS_TYPE ****************"+PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_LOSS_TYPE());
				System.out.println("getCCD_DISAB_TYPE ****************"+PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_DISAB_TYPE());
				
				
				C6_REC= handler.executeSelectStatement(C6, connection,
						new Object[] {PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_LOSS_TYPE(),
						PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_DISAB_TYPE()});
				while (C6_REC.next()) {
					CR_APPLIED_ON = C6_REC.getString("CR_APPLIED_ON");
				}
				
				System.out.println("Applied on ****************"+CR_APPLIED_ON);
				
				
				if(CR_APPLIED_ON.equalsIgnoreCase("SA"))
					
				{					
					System.out.println("CR_APPLIED_ON is SA hence SA,claim_est_amt validation will be processed ");
					
				if((PLAN_TYPE != null) && PLAN_TYPE.equalsIgnoreCase("H"))
				{
					System.out.println("PLAN_TYPE is H");
				}
				else
				{

					System.out.println("PLAN_TYPE is not H");
					
				if((PLAN_TYPE != null) && PLAN_TYPE.equalsIgnoreCase("L"))
				{	

					System.out.println("getCLAIM_MEMB_CODE           "+compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_MEMB_CODE());
					
					Object [] obj_C1 = new Object[]{PLAN_TYPE,
							compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID(),
							compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_MEMB_CODE()};

					C1_REC = handler.executeSelectStatement(C1, connection,obj_C1);

					if(C1_REC.next()){
						PFMD_SA = C1_REC.getDouble("PFMD_SA");

					}

					System.out.println("PFMD_SA                  "+PFMD_SA);
					
					if((est_amt != null && PFMD_SA != null) &&	(est_amt > PFMD_SA))
					{
						throw new Exception("Claim estimation amount of "+est_amt +" is greater than the S.A "+PFMD_SA);
					}			

				} 
				else if((PLAN_TYPE != null && PROD_UNIT_LINK_TYPE != null) && 
						(PLAN_TYPE.equalsIgnoreCase("U") && PROD_UNIT_LINK_TYPE.equalsIgnoreCase("EDU")))
				{

					Object [] obj_C4 = new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()};

					C4_REC = handler.executeSelectStatement(C4, connection,obj_C4);

					if(C4_REC.next()){

						UFR_NO_OF_UNITS = C4_REC.getDouble(1);
						
					}
					System.out.println("UFR_NO_OF_UNITS                  "+UFR_NO_OF_UNITS);
					
					if((est_amt != null && UFR_NO_OF_UNITS != null ) &&	(est_amt > UFR_NO_OF_UNITS))

					{
						throw new Exception("Claim estimation amount of "+est_amt +" is greater than the S.A of "+UFR_NO_OF_UNITS);
					}


				}
				
				else if((PLAN_TYPE != null && PROD_UNIT_LINK_TYPE != null) && 
						(PLAN_TYPE.equalsIgnoreCase("U") && PROD_UNIT_LINK_TYPE.equalsIgnoreCase("END")))
				{

					/*Object [] obj_C0 = new Object[]{PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),
							compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_ASSR_CODE()};*/
					Object [] obj_C0 = new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()};
					C0_REC = handler.executeSelectStatement(C0, connection,obj_C0);

					if(C0_REC.next()){

						POAC_FC_SA = C0_REC.getDouble(1);
						
					}

					System.out.println("POAC_FC_SA for  END                 "+POAC_FC_SA);
										
					if((est_amt != null && POAC_FC_SA != null ) &&	(est_amt > POAC_FC_SA))

					{
						throw new Exception("Claim estimation amount of "+est_amt +" is greater than the S.A of "+POAC_FC_SA);
					}


				}
				else 
				{

					/*MOdified by Janani on 15.09.2017 for ZBLIFE-1440369*/
					
					//Object [] obj_C5 = new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()};

					
					Object [] obj_C5 = new Object[]{compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_COVER_CODE(),
													compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO(),
													compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_COVER_CODE(),
													compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()};
					
					C5_REC = handler.executeSelectStatement(C5, connection,obj_C5);

					if(C5_REC.next()){

						SUM_ASSR = C5_REC.getDouble(1);
						//POL_FC_SUM_ASSURED = C5_REC.getDouble(2);
												
					}

				   //System.out.println("POL_FC_SUM_ASSURED for normal plans                  "+POL_FC_SUM_ASSURED);
					System.out.println("SUM_ASSR for normal plans                  "+SUM_ASSR);
										
				   /*if((est_amt != null && POL_FC_SUM_ASSURED != 0.0 ) &&	(est_amt > POL_FC_SUM_ASSURED))

					{
						throw new Exception("Claim estimation amount of "+est_amt +" is greater than the S.A of "+POL_FC_SUM_ASSURED);
					}*/
					
					if((est_amt != null && SUM_ASSR != 0.0 ) &&	(est_amt > SUM_ASSR))

					{
						throw new Exception("Claim estimation amount of "+est_amt +" is greater than the S.A of "+SUM_ASSR);
					}

					/*End of ZBLIFE-1440369*/
					

				}
				
				}
				
				}
				
				/*End of ZBILQC-1719755*/
				
				if((Double.compare(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FC_EST_AMT().doubleValue(),Double.parseDouble(value.toString()))!=0))
				{
					
					System.out.println("compared");
					
				Double number_amount=validate_asd_num_value();
				Double estimate_amt=PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FC_EST_AMT();
				
				Double curr_value = Double.valueOf(value.toString());
				
				if(number_amount!=null && curr_value!=null){
				if(curr_value >number_amount){
					throw new Exception("claim estimation amount of "+curr_value +" is greater than the ex-gratia limit  of " +number_amount +" for this User");                   
				}
				}
				}
				
				/*End*/
				
				//end
				
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_FC_EST_AMT((Double)value);
				helper.whenValidateFC_EST_AMOUNT(compositeAction);
			
				COMP_CCD_LC_EST_AMT.resetValue();
			}catch(Exception e){
			    e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	}
	/*Commented by ganesh on 18-05-2017 for exgratia issue 
	 * 
	 * //added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 26-12-16
	public void validatorFCAmtEstimate(ActionEvent event){
		try{
			
			UIInput input = (UIInput) event.getComponent().getParent();
		
		
			Double FCAmtEstimate =Double.valueOf(input.getSubmittedValue().toString().replace(",", ""));
		PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_FC_EST_AMT(FCAmtEstimate);
			helper.whenValidateFC_EST_AMOUNT(compositeAction);
			added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 26/12/16
			Double number_amount=validate_asd_num_value();
			Double estimate_amt=PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FC_EST_AMT();
			if(number_amount!=null && estimate_amt!=null){
			if(estimate_amt>number_amount){
				throw new Exception("claim estimation amount of "+estimate_amt +" is greater than the ex-gratia limit  of " +number_amount +" for this User");                   
			}
			}
			//end
			COMP_CCD_LC_EST_AMT.resetValue();
		}catch(Exception e){
		    e.printStackTrace();
		    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
}
	//end
*/
	//end
	/**
	 * 
	 * @param event
	 */
	public void validateFCAmtEstimate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	

	public void validatorLCAmtEstimate(FacesContext context, UIComponent component, Object value){
		try{
			helper.whenValidateCCD_LC_EST_AMT(compositeAction, value);
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_LC_EST_AMT((Double)value);
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	
	public void validateLCAmtEstimate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}


	/**
	 * When RI Button Pressed.
	 */
 /*Modified by saranya for RI recovery details to be shown at Claim registration stage itself on 20/02/2017 */
	public String whenUI_M_RI_ButtonPressed() {

		Long polSysId = null;
		Long claimSysId = null;
		if (compositeAction.getPT_IL_CLAIM_ACTION_BEAN().
					getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID() != null) {
			polSysId = compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
		}

		if (compositeAction.getPT_IL_CLAIM_ACTION_BEAN().
					getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID() != null) {
			claimSysId = compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
							.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
		}
		CommonUtils.setGlobalObject("GLOBAL.POL_SYS_ID", polSysId);
		CommonUtils.setGlobalObject("GLOBAL.CLM_SYS_ID", claimSysId);
		CommonUtils.setGlobalVariable("GLOBAL.COVER_CODE",PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE());
		CommonUtils.setGlobalVariable("GLOBAL.FAC_RI_BUT", "R");
		/*return "RIDetails";*/
		PILT011compositeAction.getPT_IL_TTY_CLAIM_EST_ACTION_BEAN().setBlockFlag(true);
		 return "Claim_RIdetail";
	}
	/*End*/
	
	public HtmlCommandButton getCOMP_UI_M_BUT_HISTORY() {
		return COMP_UI_M_BUT_HISTORY;
	}

	public void setCOMP_UI_M_BUT_HISTORY(HtmlCommandButton comp_ui_m_but_history) {
		COMP_UI_M_BUT_HISTORY = comp_ui_m_but_history;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_RI() {
		return COMP_UI_M_BUT_RI;
	}

	public void setCOMP_UI_M_BUT_RI(HtmlCommandButton comp_ui_m_but_ri) {
		COMP_UI_M_BUT_RI = comp_ui_m_but_ri;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC() {
		return COMP_UI_M_BUT_FAC;
	}

	public void setCOMP_UI_M_BUT_FAC(HtmlCommandButton comp_ui_m_but_fac) {
		COMP_UI_M_BUT_FAC = comp_ui_m_but_fac;
	}

	/**
	 * When RI Button Pressed.
	 */
	/* Modified by saranya for RI recovery details to be shown at Claim registration stage itself on 18/02/2017 */
	public String whenUI_M_FAC_ButtonPressed() {
		Long polSysId = null;
		Long claimSysId = null;
		if (compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
				.getCLAIM_POL_SYS_ID() != null) {
			polSysId = compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
		}

		if (compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
				.getCLAIM_SYS_ID() != null) {
			claimSysId = compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						 .getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
		}
        setBlockFlag(true);
		CommonUtils.setGlobalObject("GLOBAL.POL_SYS_ID", polSysId);
		CommonUtils.setGlobalObject("GLOBAL.CLM_SYS_ID", claimSysId);
		CommonUtils.setGlobalVariable("GLOBAL.COVER_CODE",PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE());
		CommonUtils.setGlobalVariable("GLOBAL.FAC_RI_BUT", "F");
		CommonUtils.setGlobalVariable("CALLING_FORM", "PILT006_APAC");
	  return "PILT011";
		/*return "FACDetailsPage";*/
	}
/*End*/
	
	public String whenUI_ButHist(){
		return "coverHistDtls";
	}

	public HtmlOutputLabel getCOMP_UI_M_REFUND_SERV_FEE_LABEL() {
		return COMP_UI_M_REFUND_SERV_FEE_LABEL;
	}

	public void setCOMP_UI_M_REFUND_SERV_FEE_LABEL(
			HtmlOutputLabel comp_ui_m_refund_serv_fee_label) {
		COMP_UI_M_REFUND_SERV_FEE_LABEL = comp_ui_m_refund_serv_fee_label;
	}

	public HtmlInputText getCOMP_UI_M_REFUND_SERV_FEE() {
		return COMP_UI_M_REFUND_SERV_FEE;
	}

	public void setCOMP_UI_M_REFUND_SERV_FEE(HtmlInputText comp_ui_m_refund_serv_fee) {
		COMP_UI_M_REFUND_SERV_FEE = comp_ui_m_refund_serv_fee;
	}

	public HtmlOutputLabel getCOMP_UI_M_REFUND_WAK_FEE_LABEL() {
		return COMP_UI_M_REFUND_WAK_FEE_LABEL;
	}

	public void setCOMP_UI_M_REFUND_WAK_FEE_LABEL(
			HtmlOutputLabel comp_ui_m_refund_wak_fee_label) {
		COMP_UI_M_REFUND_WAK_FEE_LABEL = comp_ui_m_refund_wak_fee_label;
	}

	public HtmlInputText getCOMP_UI_M_REFUND_WAK_FEE() {
		return COMP_UI_M_REFUND_WAK_FEE;
	}

	public void setCOMP_UI_M_REFUND_WAK_FEE(HtmlInputText comp_ui_m_refund_wak_fee) {
		COMP_UI_M_REFUND_WAK_FEE = comp_ui_m_refund_wak_fee;
	}

	public HtmlOutputLabel getCOMP_UI_M_REFUND_RISK_PREM_LABEL() {
		return COMP_UI_M_REFUND_RISK_PREM_LABEL;
	}

	public void setCOMP_UI_M_REFUND_RISK_PREM_LABEL(
			HtmlOutputLabel comp_ui_m_refund_risk_prem_label) {
		COMP_UI_M_REFUND_RISK_PREM_LABEL = comp_ui_m_refund_risk_prem_label;
	}

	public HtmlInputText getCOMP_UI_M_REFUND_RISK_PREM() {
		return COMP_UI_M_REFUND_RISK_PREM;
	}

	public void setCOMP_UI_M_REFUND_RISK_PREM(
			HtmlInputText comp_ui_m_refund_risk_prem) {
		COMP_UI_M_REFUND_RISK_PREM = comp_ui_m_refund_risk_prem;
	}

	/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 26/12/16*/
	 public String validate_asd_char_value_flag()
				throws Exception {
		  System.out.println("*******enter into validate_asd_char_value_flag***");
		
			String C1 ="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID =? "
					+ "AND ASD_CODE = 'CLM_EXGR_YN' AND ? BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
			ResultSet C1_REC = null;
			String CHECK_CODE=null;
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				String productCode=getprod_code();
				C1_REC = handler.executeSelectStatement(C1, connection,
						new Object[] {CommonUtils.getControlBean().getUSER_ID(),productCode});
				if (C1_REC.next()) {
					CHECK_CODE =C1_REC.getString(1);//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN()
				}
				} catch (SQLException e) {
				throw new Exception(e.getMessage());
			} 
			System.out.println("**************value of CHECK_CODE***"+CHECK_CODE);
			return CHECK_CODE;
			
		}
	 public String getprod_code()
				throws Exception {
		  System.out.println("*******enter into getprod_code***");
		
			String C1 ="select pol_prod_code from pt_il_policy where pol_no=?";
			ResultSet C1_REC = null;
			String product_code=null;
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				C1_REC = handler.executeSelectStatement(C1, connection,
						new Object[] {compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()});
				if (C1_REC.next()) {
					product_code =C1_REC.getString(1);
				}
				} catch (SQLException e) {
				throw new Exception(e.getMessage());
			} 
			System.out.println("**************value of product_code***"+product_code);
			return product_code;
			
		}
	 public Double validate_asd_num_value()
				throws Exception {
		  System.out.println("*******enter into validate_asd_num_value***");
		
			String C1 ="SELECT ASD_NUM_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_CODE = 'CLM_EXGR_AMT' AND ASD_USER_ID =? "
					+ "AND ? BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
			ResultSet C1_REC = null;
			Double num_value=null;
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				String productCode=getprod_code();
				C1_REC = handler.executeSelectStatement(C1, connection,
						new Object[] {CommonUtils.getControlBean().getUSER_ID(),productCode});
				if (C1_REC.next()) {
					num_value =C1_REC.getDouble(1);
				}
				} catch (SQLException e) {
				throw new Exception(e.getMessage());
			} 
			System.out.println("**************value of num_value***"+num_value);
			return num_value;
			
		}
	 public String getPS_VALUE()
				throws Exception {
		  System.out.println("*******enter into getPS_VALUE***");
		
			String C1 ="SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_CLM_MOD' AND PS_CODE = 'IL_CLM_MOD'";
			ResultSet C1_REC = null;
			String ps_value=null;
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				C1_REC = handler.executeSelectStatement(C1, connection);
				if (C1_REC.next()) {
					ps_value =String.valueOf(C1_REC.getInt(1));
				}
				} catch (SQLException e) {
				throw new Exception(e.getMessage());
			} 
			System.out.println("**************value of product_code***"+ps_value);
			return ps_value;
			
		}
	//end
	 
	
	/*validator Added by saritha on 18-01-2017 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
	 public void validatorsetflag(FacesContext context, UIComponent component, Object value){
			
			try{
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_SET_FLAG((String)value);
				System.out.println("Set Flag*************"+PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_SET_FLAG());
				COMP_CCD_SET_FLAG.resetValue();
			}catch(Exception e){
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	 	/*End*/
		
	//ADDED BY AMEEN ON 15-03-2017 AS PER VINOTH SUGG.
		private HtmlOutputLabel COMP_CCD_EMAIL_LABEL;
		
		private HtmlInputText COMP_CCD_EMAIL;

		public HtmlOutputLabel getCOMP_CCD_EMAIL_LABEL() {
			return COMP_CCD_EMAIL_LABEL;
		}

		public void setCOMP_CCD_EMAIL_LABEL(HtmlOutputLabel cOMP_CCD_EMAIL_LABEL) {
			COMP_CCD_EMAIL_LABEL = cOMP_CCD_EMAIL_LABEL;
		}

		public HtmlInputText getCOMP_CCD_EMAIL() {
			return COMP_CCD_EMAIL;
		}

		public void setCOMP_CCD_EMAIL(HtmlInputText cOMP_CCD_EMAIL) {
			COMP_CCD_EMAIL = cOMP_CCD_EMAIL;
		}
		
		
	public void validatorCCD_CLAIM_PAY_TO(FacesContext context, 
				UIComponent component, Object value){
			String qry = "SELECT PBEN_EMAIL FROM PT_IL_POL_BENEFICIARY WHERE PBEN_POL_SYS_ID = ?";
			ResultSet rs = null;
			try{
			System.out.println("validatorCCD_CLAIM_PAY_TO 11111111111");
			String payVal = (String)value;
			System.out.println("payVal ===========>>" + payVal);
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CLAIM_PAY_TO(payVal);
			
			rs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection(), new Object[]{
							compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()
					});
			if(rs.next()){
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_EMAIL(rs.getString("PBEN_EMAIL"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		}
		
	//End
	
	
	/*Added by saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 13-04-2017*/
	public long SYSID;
	
	public long getSYSID() {
		return SYSID;
	}

	public void setSYSID(long sYSID) {
		SYSID = sYSID;
	}

	public void getGEN_WOP_RESV(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		String CURSOR_C1 = "SELECT CCD_SYS_ID FROM PT_IL_CLAIM_COVER_DTLS, PM_IL_COVER WHERE CCD_COVER_CODE = COVER_CODE"
				+ " AND NVL(CCD_FRZ_FLAG, 'N') = 'Y' AND NVL(CCD_CONFIRM_FLAG, 'N') = 'Y'"
				+ " AND NVL(CCD_RESERVE_GEN_FLAG, 'N') = 'N'  AND COVER_CLASS = 'W' "
				+ " AND CCD_CLAIM_SYS_ID = ?";
		
		ResultSet resultSet = null;
		ResultSet rs = null;
		Connection connection = null;
		Long CCD_SYS_ID_VALUE=null;
		String CCD_SYS_ID_VAL=null;
		setSYSID(0);
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,new Object[] {pt_il_claim.getCLAIM_SYS_ID()});
			while (resultSet.next()) {
				CCD_SYS_ID_VALUE= resultSet.getLong("CCD_SYS_ID");
				setSYSID(CCD_SYS_ID_VALUE);
				System.out.println("CCD_SYS_ID   :"+getSYSID());
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	/*Modified by Saranya on 21/04/2017
	 * 
	 * public void UPDATE_RESERVE_GEN_FLAG(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		String CURSOR_C1 = " UPDATE PT_IL_CLAIM_COVER_DTLS SET CCD_RESERVE_GEN_FLAG = 'Y'"
				+ " WHERE CCD_CLAIM_SYS_ID = ? AND CCD_SYS_ID =?";
		ResultSet resultSet = null;
		Connection connection = null;
		Long CCD_SYS_ID_VALUE=null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] {pt_il_claim.getCLAIM_SYS_ID(),getSYSID_VALUE()});

			connection.commit();
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	public void UPDATE_RESERVE_GEN_FLAG_WOP(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		String CURSOR_C1 = " UPDATE PT_IL_CLAIM_COVER_DTLS SET CCD_RESERVE_GEN_FLAG = 'Y'"
				+ " WHERE CCD_CLAIM_SYS_ID = ? AND CCD_SYS_ID =?";
		ResultSet resultSet = null;
		Connection connection = null;
		Long CCD_SYS_ID_VALUE=null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] {pt_il_claim.getCLAIM_SYS_ID(),getSYSID()});
			connection.commit();
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}*/
	

public void UPDATE_RESERVE_GEN_FLAG(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		String CURSOR_C1 = " UPDATE PT_IL_CLAIM_COVER_DTLS SET CCD_RESERVE_GEN_FLAG = 'Y'"
				+ " WHERE CCD_CLAIM_SYS_ID = ? AND    CCD_SYS_ID =?";
		int resultSet = 0;
		Connection connection = null;
		Long CCD_SYS_ID_VALUE=null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeUpdateStatement(CURSOR_C1, connection,
					new Object[] {pt_il_claim.getCLAIM_SYS_ID(),getSYSID_VALUE()});

			connection.commit();
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	public void UPDATE_RESERVE_GEN_FLAG_WOP(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		String CURSOR_C1 = " UPDATE PT_IL_CLAIM_COVER_DTLS SET CCD_RESERVE_GEN_FLAG = 'Y'"
				+ " WHERE CCD_CLAIM_SYS_ID = ? AND    CCD_SYS_ID =?";
		int resultSet = 0;
		Connection connection = null;
		Long CCD_SYS_ID_VALUE=null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeUpdateStatement(CURSOR_C1, connection,
					new Object[] {pt_il_claim.getCLAIM_SYS_ID(),getSYSID()});
			connection.commit();
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	
	/*End*/
	public String PS_VAL;
	
	public String SYSID_VALUE;
	
	public String getSYSID_VALUE() {
		return SYSID_VALUE;
	}

	public void setSYSID_VALUE(String sYSID_VALUE) {
		SYSID_VALUE = sYSID_VALUE;
	}
	
	public String getPS_VAL() {
		return PS_VAL;
	}

	public void setPS_VAL(String pS_VAL) {
		PS_VAL = pS_VAL;
	}
	
	public void getGEN_CLM_RESV(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		String CURSOR_C1 = "SELECT CCD_SYS_ID FROM   PT_IL_CLAIM_COVER_DTLS WHERE  NVL(CCD_FRZ_FLAG,'N') = 'Y'"
				+ " AND NVL(CCD_CONFIRM_FLAG,'N') = 'Y' AND    NVL(CCD_RESERVE_GEN_FLAG,'N') = 'N'"
				+ " AND  CCD_CLAIM_SYS_ID = ?"
				+ " AND  ((CCD_SET_FLAG <> 'PA') OR     (CCD_SET_FLAG = 'PA'"
				+ " AND  NOT EXISTS (SELECT 1  FROM   PM_IL_CLM_REPAY WHERE  CR_COVER_CODE = CCD_COVER_CODE"
				+ " AND CR_LOSS_TYPE = CCD_LOSS_TYPE AND    CR_DISABLE_TYPE = CCD_DISAB_TYPE"
				+ " AND    NVL(CR_UNIT_PRICE,'N') = 'A')))";
		ResultSet rs = null;
		Connection connection = null;
		String CCD_SYS_ID_VAL=null;
		CRUDHandler handler = new CRUDHandler();
		setSYSID_VALUE(null);
		try {
			System.out.println();
			connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(CURSOR_C1, connection,new Object[] {pt_il_claim.getCLAIM_SYS_ID()});
			while (rs.next()) {
				CCD_SYS_ID_VAL= rs.getString("CCD_SYS_ID");
				setSYSID_VALUE(CCD_SYS_ID_VAL);
				System.out.println("CCD_SYS_ID   :"+getSYSID_VALUE());
				
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	public void getPARAM_VALUE_RSRV_CLM() throws Exception {
		String CURSOR_C1 = "SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_RSRV_CLM'";
		ResultSet rs = null;
		Connection connection = null;
		String PS_VALUE=null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(CURSOR_C1, connection,new Object[] {});
			while (rs.next()) {
				PS_VALUE= rs.getString("PS_VALUE");
				setPS_VAL(PS_VALUE);
				System.out.println("PS_VALUE   :"+getPS_VALUE());
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	/*End*/
	
	public void funeralCustValidation() throws Exception
	{
		try{
		String Query="SELECT PLAN_TYPE FROM PM_IL_PLAN,PT_IL_POLICY WHERE POL_PLAN_CODE = PLAN_CODE AND POL_SYS_ID =?";
		ResultSet rs=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
								.getCLAIM_POL_SYS_ID()});
		String plan_type=null;
		while(rs.next())
		{
			plan_type=rs.getString("PLAN_TYPE");
		}
		
		if(plan_type!=null && (plan_type.equalsIgnoreCase("L") || plan_type.equalsIgnoreCase("H")))
				{
			if(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_CUST_CODE().equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_MEMB_CODE()))
			{
				/*Added by ganesh on 19-12-2017 as suggested by Thiyags from onsite */
				compositeAction.getWizard().enableWizardItem("claimCoverDetails");
				  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
				  compositeAction.getWizard().enableWizardItem("toDoGroup");
				  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
				  compositeAction.getWizard().enableWizardItem("reminders");
				  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
				  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
				  /*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017*/
				  compositeAction.getWizard().enableWizardItem("claimCharge");
				  /*end*/
				
		for(PT_IL_CLAIM_COVER_DTLS bean : dataList_PT_IL_CLAIM_COVER_DTLS)
		{
			if(bean.getCCD_FRZ_FLAG().equalsIgnoreCase("Y"))
			{
				if(bean.getCCD_CONFIRM_FLAG().equalsIgnoreCase("Y"))
				{
					/*compositeAction.getWizard().disableWizardItem("claimCoverDetails");
					  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
					  compositeAction.getWizard().disableWizardItem("toDoGroup");
					  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
					  compositeAction.getWizard().disableWizardItem("reminders");
					  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
					  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
					  Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017
					  compositeAction.getWizard().disableWizardItem("claimCharge");*/
					  
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_POL_PRINT().setDisabled(true);
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_PRE_CLAIM_DTLS().setDisabled(true);
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_CLOSE().setDisabled(true);
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(true);
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_REOPEN().setDisabled(true);
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_POLICY_DTLS().setDisabled(true);
				}
				else
				{
					/*compositeAction.getWizard().enableWizardItem("claimCoverDetails");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
					  compositeAction.getWizard().enableWizardItem("toDoGroup");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
					  compositeAction.getWizard().enableWizardItem("reminders");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
					  Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017
					  compositeAction.getWizard().enableWizardItem("claimCharge");*/
					  
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_POL_PRINT().setDisabled(false);
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_PRE_CLAIM_DTLS().setDisabled(false);
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_CLOSE().setDisabled(false);
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(false);
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_POLICY_DTLS().setDisabled(false);
				}
			}
			else
			{
				/*compositeAction.getWizard().enableWizardItem("claimCoverDetails");
				  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
				  compositeAction.getWizard().enableWizardItem("toDoGroup");
				  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
				  compositeAction.getWizard().enableWizardItem("reminders");
				  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
				  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
				  Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017
				  compositeAction.getWizard().enableWizardItem("claimCharge");*/
				  
				  
				  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_POL_PRINT().setDisabled(false);
				  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_PRE_CLAIM_DTLS().setDisabled(false);
				  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_CLOSE().setDisabled(false);
				  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(false);
				  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_POLICY_DTLS().setDisabled(false);
			}
		}
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*Added by saritha on 17-07-2017 for ssp call id ZBILQC-1731636*/
	private HtmlModalPanel COMP_CONTEST_PERIOD_MODAL_PANEL;
	public HtmlModalPanel getCOMP_CONTEST_PERIOD_MODAL_PANEL() {
		return COMP_CONTEST_PERIOD_MODAL_PANEL;
	}

	public void setCOMP_CONTEST_PERIOD_MODAL_PANEL(
			HtmlModalPanel cOMP_CONTEST_PERIOD_MODAL_PANEL) {
		COMP_CONTEST_PERIOD_MODAL_PANEL = cOMP_CONTEST_PERIOD_MODAL_PANEL;
	}

	public void OkModalPanel() throws Exception{
		System.out.println("enter into the ok model panal");
		getCOMP_CONTEST_PERIOD_MODAL_PANEL().setShowWhenRendered(false);
			
	}
	
	public void fireFieldValidationFreezeFlag(ActionEvent actionEvent) throws Exception {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String)input.getSubmittedValue();
		try{
		if(value.equalsIgnoreCase("Y")){
			
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().checkContestabilityPeriod(COMP_CONTEST_PERIOD_MODAL_PANEL);
		}else{
			COMP_CONTEST_PERIOD_MODAL_PANEL.setShowWhenRendered(false);
		}
		
		ErrorHelpUtil.validate(input, getErrorMap());
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*End*/
}
