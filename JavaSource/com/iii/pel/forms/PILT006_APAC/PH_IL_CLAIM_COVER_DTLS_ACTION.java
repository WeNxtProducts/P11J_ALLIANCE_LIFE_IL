package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PH_IL_CLAIM_COVER_DTLS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CCDH_REF_NO_LABEL;

	private HtmlInputText COMP_CCDH_REF_NO;

	private HtmlOutputLabel COMP_CCDH_COVER_CODE_LABEL;

	private HtmlInputText COMP_CCDH_COVER_CODE;

	private HtmlOutputLabel COMP_CCDH_LOSS_TYPE_LABEL;

	private HtmlInputText COMP_CCDH_LOSS_TYPE;

	private HtmlOutputLabel COMP_CCDH_DISAB_TYPE_LABEL;

	private HtmlInputText COMP_CCDH_DISAB_TYPE;

	private HtmlOutputLabel COMP_CCDH_PERIOD_UNIT_LABEL;

	private HtmlSelectOneMenu COMP_CCDH_PERIOD_UNIT;

	private HtmlOutputLabel COMP_CCDH_PERIOD_LABEL;

	private HtmlInputText COMP_CCDH_PERIOD;

	private HtmlOutputLabel COMP_CCDH_RATE_LABEL;

	private HtmlInputText COMP_CCDH_RATE;

	private HtmlOutputLabel COMP_CCDH_RATE_PER_LABEL;

	private HtmlInputText COMP_CCDH_RATE_PER;

	private HtmlOutputLabel COMP_CCDH_O_FC_EST_AMT_LABEL;

	private HtmlInputText COMP_CCDH_O_FC_EST_AMT;

	private HtmlOutputLabel COMP_CCDH_FRZ_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_CCDH_FRZ_FLAG;

	private HtmlOutputLabel COMP_CCDH_CONFIRM_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_CCDH_CONFIRM_FLAG;

	private HtmlOutputLabel COMP_CCDH_O_RESERVE_DT_LABEL;

	private HtmlCalendar COMP_CCDH_O_RESERVE_DT;

	private HtmlOutputLabel COMP_UI_M_CCDH_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CCDH_COVER_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_CCDH_LOSS_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CCDH_LOSS_TYPE_DESC;

	private HtmlOutputLabel COMP_UI_M_CCDH_DISAB_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CCDH_DISAB_TYPE_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_COVER;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_DISABLE_TYPE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_LOSS_TYPE;

	private HtmlCommandButton COMP_PUSH_BUTTON1018;
	
	private HtmlCommandButton UI_BUT_MAIN;

	private PH_IL_CLAIM_COVER_DTLS PH_IL_CLAIM_COVER_DTLS_BEAN;

	public PILT006_APAC_COMPOSITE_ACTION compositeAction;

	private PH_IL_CLAIM_COVER_DTLS_HELPER helper;

	private List<PH_IL_CLAIM_COVER_DTLS> dataList_PH_IL_CLAIM_COVER_DTLS = new ArrayList<PH_IL_CLAIM_COVER_DTLS>();

	private UIData dataTable;

	private List<SelectItem> listCCDH_PERIOD_UNIT = new ArrayList<SelectItem>();

	private List<SelectItem> listCCDH_FRZ_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listCCDH_CONFIRM_FLAG = new ArrayList<SelectItem>();
	
	private String filterByCCDH_REF_NO;
	
	private String filterByCCDH_COVER_CODE;
	
	private String filterByCCDH_LOSS_TYPE;

	
	public PH_IL_CLAIM_COVER_DTLS_ACTION() {
		PH_IL_CLAIM_COVER_DTLS_BEAN = new PH_IL_CLAIM_COVER_DTLS();
		helper = new PH_IL_CLAIM_COVER_DTLS_HELPER();
		setListCCDH_PERIOD_UNIT(ListItemUtil.getDropDownListValue(getConnection(), 
				"PILT006_APAC","PT_IL_CLAIM_COVER_DTLS", "PT_IL_CLAIM_COVER_DTLS.CCD_PERIOD_UNIT", "CALC-MTHD"));
		setListCCDH_CONFIRM_FLAG(ListItemUtil.getDropDownListValue(getConnection(), 
				"PILT006_APAC","PT_IL_CLAIM_COVER_DTLS", "PT_IL_CLAIM_COVER_DTLS.CCD_CONFIRM_FLAG", "YESNO"));
		setListCCDH_FRZ_FLAG(ListItemUtil.getDropDownListValue(getConnection(), 
				"PILT006_APAC","PT_IL_CLAIM_COVER_DTLS", "PT_IL_CLAIM_COVER_DTLS.CCD_SET_FLAG", "IL_SA_PA"));
		instantiateAllComponent();
	}
	
	/**
	 * @return the cOMP_CCDH_REF_NO_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCDH_REF_NO_LABEL() {
		return COMP_CCDH_REF_NO_LABEL;
	}

	/**
	 * @param comp_ccdh_ref_no_label the cOMP_CCDH_REF_NO_LABEL to set
	 */
	public void setCOMP_CCDH_REF_NO_LABEL(HtmlOutputLabel comp_ccdh_ref_no_label) {
		COMP_CCDH_REF_NO_LABEL = comp_ccdh_ref_no_label;
	}

	/**
	 * @return the cOMP_CCDH_REF_NO
	 */
	public HtmlInputText getCOMP_CCDH_REF_NO() {
		return COMP_CCDH_REF_NO;
	}

	/**
	 * @param comp_ccdh_ref_no the cOMP_CCDH_REF_NO to set
	 */
	public void setCOMP_CCDH_REF_NO(HtmlInputText comp_ccdh_ref_no) {
		COMP_CCDH_REF_NO = comp_ccdh_ref_no;
	}

	/**
	 * @return the cOMP_CCDH_COVER_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCDH_COVER_CODE_LABEL() {
		return COMP_CCDH_COVER_CODE_LABEL;
	}

	/**
	 * @param comp_ccdh_cover_code_label the cOMP_CCDH_COVER_CODE_LABEL to set
	 */
	public void setCOMP_CCDH_COVER_CODE_LABEL(
			HtmlOutputLabel comp_ccdh_cover_code_label) {
		COMP_CCDH_COVER_CODE_LABEL = comp_ccdh_cover_code_label;
	}

	/**
	 * @return the cOMP_CCDH_COVER_CODE
	 */
	public HtmlInputText getCOMP_CCDH_COVER_CODE() {
		return COMP_CCDH_COVER_CODE;
	}

	/**
	 * @param comp_ccdh_cover_code the cOMP_CCDH_COVER_CODE to set
	 */
	public void setCOMP_CCDH_COVER_CODE(HtmlInputText comp_ccdh_cover_code) {
		COMP_CCDH_COVER_CODE = comp_ccdh_cover_code;
	}

	/**
	 * @return the cOMP_CCDH_LOSS_TYPE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCDH_LOSS_TYPE_LABEL() {
		return COMP_CCDH_LOSS_TYPE_LABEL;
	}

	/**
	 * @param comp_ccdh_loss_type_label the cOMP_CCDH_LOSS_TYPE_LABEL to set
	 */
	public void setCOMP_CCDH_LOSS_TYPE_LABEL(
			HtmlOutputLabel comp_ccdh_loss_type_label) {
		COMP_CCDH_LOSS_TYPE_LABEL = comp_ccdh_loss_type_label;
	}

	/**
	 * @return the cOMP_CCDH_LOSS_TYPE
	 */
	public HtmlInputText getCOMP_CCDH_LOSS_TYPE() {
		return COMP_CCDH_LOSS_TYPE;
	}

	/**
	 * @param comp_ccdh_loss_type the cOMP_CCDH_LOSS_TYPE to set
	 */
	public void setCOMP_CCDH_LOSS_TYPE(HtmlInputText comp_ccdh_loss_type) {
		COMP_CCDH_LOSS_TYPE = comp_ccdh_loss_type;
	}

	/**
	 * @return the cOMP_CCDH_DISAB_TYPE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCDH_DISAB_TYPE_LABEL() {
		return COMP_CCDH_DISAB_TYPE_LABEL;
	}

	/**
	 * @param comp_ccdh_disab_type_label the cOMP_CCDH_DISAB_TYPE_LABEL to set
	 */
	public void setCOMP_CCDH_DISAB_TYPE_LABEL(
			HtmlOutputLabel comp_ccdh_disab_type_label) {
		COMP_CCDH_DISAB_TYPE_LABEL = comp_ccdh_disab_type_label;
	}

	/**
	 * @return the cOMP_CCDH_DISAB_TYPE
	 */
	public HtmlInputText getCOMP_CCDH_DISAB_TYPE() {
		return COMP_CCDH_DISAB_TYPE;
	}

	/**
	 * @param comp_ccdh_disab_type the cOMP_CCDH_DISAB_TYPE to set
	 */
	public void setCOMP_CCDH_DISAB_TYPE(HtmlInputText comp_ccdh_disab_type) {
		COMP_CCDH_DISAB_TYPE = comp_ccdh_disab_type;
	}

	/**
	 * @return the cOMP_CCDH_PERIOD_UNIT_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCDH_PERIOD_UNIT_LABEL() {
		return COMP_CCDH_PERIOD_UNIT_LABEL;
	}

	/**
	 * @param comp_ccdh_period_unit_label the cOMP_CCDH_PERIOD_UNIT_LABEL to set
	 */
	public void setCOMP_CCDH_PERIOD_UNIT_LABEL(
			HtmlOutputLabel comp_ccdh_period_unit_label) {
		COMP_CCDH_PERIOD_UNIT_LABEL = comp_ccdh_period_unit_label;
	}

	/**
	 * @return the cOMP_CCDH_PERIOD_UNIT
	 */
	public HtmlSelectOneMenu getCOMP_CCDH_PERIOD_UNIT() {
		return COMP_CCDH_PERIOD_UNIT;
	}

	/**
	 * @param comp_ccdh_period_unit the cOMP_CCDH_PERIOD_UNIT to set
	 */
	public void setCOMP_CCDH_PERIOD_UNIT(HtmlSelectOneMenu comp_ccdh_period_unit) {
		COMP_CCDH_PERIOD_UNIT = comp_ccdh_period_unit;
	}

	/**
	 * @return the cOMP_CCDH_PERIOD_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCDH_PERIOD_LABEL() {
		return COMP_CCDH_PERIOD_LABEL;
	}

	/**
	 * @param comp_ccdh_period_label the cOMP_CCDH_PERIOD_LABEL to set
	 */
	public void setCOMP_CCDH_PERIOD_LABEL(HtmlOutputLabel comp_ccdh_period_label) {
		COMP_CCDH_PERIOD_LABEL = comp_ccdh_period_label;
	}

	/**
	 * @return the cOMP_CCDH_PERIOD
	 */
	public HtmlInputText getCOMP_CCDH_PERIOD() {
		return COMP_CCDH_PERIOD;
	}

	/**
	 * @param comp_ccdh_period the cOMP_CCDH_PERIOD to set
	 */
	public void setCOMP_CCDH_PERIOD(HtmlInputText comp_ccdh_period) {
		COMP_CCDH_PERIOD = comp_ccdh_period;
	}

	/**
	 * @return the cOMP_CCDH_RATE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCDH_RATE_LABEL() {
		return COMP_CCDH_RATE_LABEL;
	}

	/**
	 * @param comp_ccdh_rate_label the cOMP_CCDH_RATE_LABEL to set
	 */
	public void setCOMP_CCDH_RATE_LABEL(HtmlOutputLabel comp_ccdh_rate_label) {
		COMP_CCDH_RATE_LABEL = comp_ccdh_rate_label;
	}

	/**
	 * @return the cOMP_CCDH_RATE
	 */
	public HtmlInputText getCOMP_CCDH_RATE() {
		return COMP_CCDH_RATE;
	}

	/**
	 * @param comp_ccdh_rate the cOMP_CCDH_RATE to set
	 */
	public void setCOMP_CCDH_RATE(HtmlInputText comp_ccdh_rate) {
		COMP_CCDH_RATE = comp_ccdh_rate;
	}

	/**
	 * @return the cOMP_CCDH_RATE_PER_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCDH_RATE_PER_LABEL() {
		return COMP_CCDH_RATE_PER_LABEL;
	}

	/**
	 * @param comp_ccdh_rate_per_label the cOMP_CCDH_RATE_PER_LABEL to set
	 */
	public void setCOMP_CCDH_RATE_PER_LABEL(HtmlOutputLabel comp_ccdh_rate_per_label) {
		COMP_CCDH_RATE_PER_LABEL = comp_ccdh_rate_per_label;
	}

	/**
	 * @return the cOMP_CCDH_RATE_PER
	 */
	public HtmlInputText getCOMP_CCDH_RATE_PER() {
		return COMP_CCDH_RATE_PER;
	}

	/**
	 * @param comp_ccdh_rate_per the cOMP_CCDH_RATE_PER to set
	 */
	public void setCOMP_CCDH_RATE_PER(HtmlInputText comp_ccdh_rate_per) {
		COMP_CCDH_RATE_PER = comp_ccdh_rate_per;
	}

	/**
	 * @return the cOMP_CCDH_O_FC_EST_AMT_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCDH_O_FC_EST_AMT_LABEL() {
		return COMP_CCDH_O_FC_EST_AMT_LABEL;
	}

	/**
	 * @param comp_ccdh_o_fc_est_amt_label the cOMP_CCDH_O_FC_EST_AMT_LABEL to set
	 */
	public void setCOMP_CCDH_O_FC_EST_AMT_LABEL(
			HtmlOutputLabel comp_ccdh_o_fc_est_amt_label) {
		COMP_CCDH_O_FC_EST_AMT_LABEL = comp_ccdh_o_fc_est_amt_label;
	}

	/**
	 * @return the cOMP_CCDH_O_FC_EST_AMT
	 */
	public HtmlInputText getCOMP_CCDH_O_FC_EST_AMT() {
		return COMP_CCDH_O_FC_EST_AMT;
	}

	/**
	 * @param comp_ccdh_o_fc_est_amt the cOMP_CCDH_O_FC_EST_AMT to set
	 */
	public void setCOMP_CCDH_O_FC_EST_AMT(HtmlInputText comp_ccdh_o_fc_est_amt) {
		COMP_CCDH_O_FC_EST_AMT = comp_ccdh_o_fc_est_amt;
	}

	/**
	 * @return the cOMP_CCDH_FRZ_FLAG_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCDH_FRZ_FLAG_LABEL() {
		return COMP_CCDH_FRZ_FLAG_LABEL;
	}

	/**
	 * @param comp_ccdh_frz_flag_label the cOMP_CCDH_FRZ_FLAG_LABEL to set
	 */
	public void setCOMP_CCDH_FRZ_FLAG_LABEL(HtmlOutputLabel comp_ccdh_frz_flag_label) {
		COMP_CCDH_FRZ_FLAG_LABEL = comp_ccdh_frz_flag_label;
	}

	/**
	 * @return the cOMP_CCDH_FRZ_FLAG
	 */
	public HtmlSelectOneMenu getCOMP_CCDH_FRZ_FLAG() {
		return COMP_CCDH_FRZ_FLAG;
	}

	/**
	 * @param comp_ccdh_frz_flag the cOMP_CCDH_FRZ_FLAG to set
	 */
	public void setCOMP_CCDH_FRZ_FLAG(HtmlSelectOneMenu comp_ccdh_frz_flag) {
		COMP_CCDH_FRZ_FLAG = comp_ccdh_frz_flag;
	}

	/**
	 * @return the cOMP_CCDH_CONFIRM_FLAG_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCDH_CONFIRM_FLAG_LABEL() {
		return COMP_CCDH_CONFIRM_FLAG_LABEL;
	}

	/**
	 * @param comp_ccdh_confirm_flag_label the cOMP_CCDH_CONFIRM_FLAG_LABEL to set
	 */
	public void setCOMP_CCDH_CONFIRM_FLAG_LABEL(
			HtmlOutputLabel comp_ccdh_confirm_flag_label) {
		COMP_CCDH_CONFIRM_FLAG_LABEL = comp_ccdh_confirm_flag_label;
	}

	/**
	 * @return the cOMP_CCDH_CONFIRM_FLAG
	 */
	public HtmlSelectOneMenu getCOMP_CCDH_CONFIRM_FLAG() {
		return COMP_CCDH_CONFIRM_FLAG;
	}

	/**
	 * @param comp_ccdh_confirm_flag the cOMP_CCDH_CONFIRM_FLAG to set
	 */
	public void setCOMP_CCDH_CONFIRM_FLAG(HtmlSelectOneMenu comp_ccdh_confirm_flag) {
		COMP_CCDH_CONFIRM_FLAG = comp_ccdh_confirm_flag;
	}

	/**
	 * @return the cOMP_CCDH_O_RESERVE_DT_LABEL
	 */
	public HtmlOutputLabel getCOMP_CCDH_O_RESERVE_DT_LABEL() {
		return COMP_CCDH_O_RESERVE_DT_LABEL;
	}

	/**
	 * @param comp_ccdh_o_reserve_dt_label the cOMP_CCDH_O_RESERVE_DT_LABEL to set
	 */
	public void setCOMP_CCDH_O_RESERVE_DT_LABEL(
			HtmlOutputLabel comp_ccdh_o_reserve_dt_label) {
		COMP_CCDH_O_RESERVE_DT_LABEL = comp_ccdh_o_reserve_dt_label;
	}

	/**
	 * @return the cOMP_CCDH_O_RESERVE_DT
	 */
	public HtmlCalendar getCOMP_CCDH_O_RESERVE_DT() {
		return COMP_CCDH_O_RESERVE_DT;
	}

	/**
	 * @param comp_ccdh_o_reserve_dt the cOMP_CCDH_O_RESERVE_DT to set
	 */
	public void setCOMP_CCDH_O_RESERVE_DT(HtmlCalendar comp_ccdh_o_reserve_dt) {
		COMP_CCDH_O_RESERVE_DT = comp_ccdh_o_reserve_dt;
	}

	/**
	 * @return the cOMP_UI_M_CCDH_LOSS_TYPE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_CCDH_LOSS_TYPE_DESC_LABEL() {
		return COMP_UI_M_CCDH_LOSS_TYPE_DESC_LABEL;
	}

	/**
	 * @param comp_ui_m_ccdh_loss_type_desc_label the cOMP_UI_M_CCDH_LOSS_TYPE_DESC_LABEL to set
	 */
	public void setCOMP_UI_M_CCDH_LOSS_TYPE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_ccdh_loss_type_desc_label) {
		COMP_UI_M_CCDH_LOSS_TYPE_DESC_LABEL = comp_ui_m_ccdh_loss_type_desc_label;
	}

	/**
	 * @return the cOMP_UI_M_CCDH_LOSS_TYPE_DESC
	 */
	public HtmlInputText getCOMP_UI_M_CCDH_LOSS_TYPE_DESC() {
		return COMP_UI_M_CCDH_LOSS_TYPE_DESC;
	}

	/**
	 * @param comp_ui_m_ccdh_loss_type_desc the cOMP_UI_M_CCDH_LOSS_TYPE_DESC to set
	 */
	public void setCOMP_UI_M_CCDH_LOSS_TYPE_DESC(
			HtmlInputText comp_ui_m_ccdh_loss_type_desc) {
		COMP_UI_M_CCDH_LOSS_TYPE_DESC = comp_ui_m_ccdh_loss_type_desc;
	}

	/**
	 * @return the cOMP_UI_M_CCDH_DISAB_TYPE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_CCDH_DISAB_TYPE_DESC_LABEL() {
		return COMP_UI_M_CCDH_DISAB_TYPE_DESC_LABEL;
	}

	/**
	 * @param comp_ui_m_ccdh_disab_type_desc_label the cOMP_UI_M_CCDH_DISAB_TYPE_DESC_LABEL to set
	 */
	public void setCOMP_UI_M_CCDH_DISAB_TYPE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_ccdh_disab_type_desc_label) {
		COMP_UI_M_CCDH_DISAB_TYPE_DESC_LABEL = comp_ui_m_ccdh_disab_type_desc_label;
	}

	/**
	 * @return the cOMP_UI_M_CCDH_DISAB_TYPE_DESC
	 */
	public HtmlInputText getCOMP_UI_M_CCDH_DISAB_TYPE_DESC() {
		return COMP_UI_M_CCDH_DISAB_TYPE_DESC;
	}

	/**
	 * @param comp_ui_m_ccdh_disab_type_desc the cOMP_UI_M_CCDH_DISAB_TYPE_DESC to set
	 */
	public void setCOMP_UI_M_CCDH_DISAB_TYPE_DESC(
			HtmlInputText comp_ui_m_ccdh_disab_type_desc) {
		COMP_UI_M_CCDH_DISAB_TYPE_DESC = comp_ui_m_ccdh_disab_type_desc;
	}

	/**
	 * @return the cOMP_UI_M_BUT_LOV_COVER
	 */
	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_COVER() {
		return COMP_UI_M_BUT_LOV_COVER;
	}

	/**
	 * @param comp_ui_m_but_lov_cover the cOMP_UI_M_BUT_LOV_COVER to set
	 */
	public void setCOMP_UI_M_BUT_LOV_COVER(HtmlCommandButton comp_ui_m_but_lov_cover) {
		COMP_UI_M_BUT_LOV_COVER = comp_ui_m_but_lov_cover;
	}

	/**
	 * @return the cOMP_UI_M_BUT_LOV_DISABLE_TYPE
	 */
	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_DISABLE_TYPE() {
		return COMP_UI_M_BUT_LOV_DISABLE_TYPE;
	}

	/**
	 * @param comp_ui_m_but_lov_disable_type the cOMP_UI_M_BUT_LOV_DISABLE_TYPE to set
	 */
	public void setCOMP_UI_M_BUT_LOV_DISABLE_TYPE(
			HtmlCommandButton comp_ui_m_but_lov_disable_type) {
		COMP_UI_M_BUT_LOV_DISABLE_TYPE = comp_ui_m_but_lov_disable_type;
	}

	/**
	 * @return the cOMP_UI_M_BUT_LOV_LOSS_TYPE
	 */
	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_LOSS_TYPE() {
		return COMP_UI_M_BUT_LOV_LOSS_TYPE;
	}

	/**
	 * @param comp_ui_m_but_lov_loss_type the cOMP_UI_M_BUT_LOV_LOSS_TYPE to set
	 */
	public void setCOMP_UI_M_BUT_LOV_LOSS_TYPE(
			HtmlCommandButton comp_ui_m_but_lov_loss_type) {
		COMP_UI_M_BUT_LOV_LOSS_TYPE = comp_ui_m_but_lov_loss_type;
	}

	/**
	 * @return the cOMP_PUSH_BUTTON1018
	 */
	public HtmlCommandButton getCOMP_PUSH_BUTTON1018() {
		return COMP_PUSH_BUTTON1018;
	}

	/**
	 * @param comp_push_button1018 the cOMP_PUSH_BUTTON1018 to set
	 */
	public void setCOMP_PUSH_BUTTON1018(HtmlCommandButton comp_push_button1018) {
		COMP_PUSH_BUTTON1018 = comp_push_button1018;
	}

	/**
	 * @return the compositeAction
	 */
	public PILT006_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PILT006_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the helper
	 */
	public PH_IL_CLAIM_COVER_DTLS_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(PH_IL_CLAIM_COVER_DTLS_HELPER helper) {
		this.helper = helper;
	}

	/**
	 * @param dataList_PH_IL_CLAIM_COVER_DTLS the dataList_PH_IL_CLAIM_COVER_DTLS to set
	 */
	public void setDataList_PH_IL_CLAIM_COVER_DTLS(
			List<PH_IL_CLAIM_COVER_DTLS> dataList_PH_IL_CLAIM_COVER_DTLS) {
		this.dataList_PH_IL_CLAIM_COVER_DTLS = dataList_PH_IL_CLAIM_COVER_DTLS;
	}

	public HtmlOutputLabel getCOMP_UI_M_CCDH_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_CCDH_COVER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CCDH_COVER_CODE_DESC() {
		return COMP_UI_M_CCDH_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_CCDH_COVER_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CCDH_COVER_CODE_DESC_LABEL) {
		this.COMP_UI_M_CCDH_COVER_CODE_DESC_LABEL = COMP_UI_M_CCDH_COVER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CCDH_COVER_CODE_DESC(
			HtmlInputText COMP_UI_M_CCDH_COVER_CODE_DESC) {
		this.COMP_UI_M_CCDH_COVER_CODE_DESC = COMP_UI_M_CCDH_COVER_CODE_DESC;
	}

	public PH_IL_CLAIM_COVER_DTLS getPH_IL_CLAIM_COVER_DTLS_BEAN() {
		return PH_IL_CLAIM_COVER_DTLS_BEAN;
	}

	public void setPH_IL_CLAIM_COVER_DTLS_BEAN(
			PH_IL_CLAIM_COVER_DTLS PH_IL_CLAIM_COVER_DTLS_BEAN) {
		this.PH_IL_CLAIM_COVER_DTLS_BEAN = PH_IL_CLAIM_COVER_DTLS_BEAN;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PH_IL_CLAIM_COVER_DTLS_BEAN = new PH_IL_CLAIM_COVER_DTLS();
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

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PH_IL_CLAIM_COVER_DTLS_BEAN,
						CommonUtils.getConnection());
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
				dataList_PH_IL_CLAIM_COVER_DTLS
						.remove(PH_IL_CLAIM_COVER_DTLS_BEAN);
				if (dataList_PH_IL_CLAIM_COVER_DTLS.size() > 0) {

					PH_IL_CLAIM_COVER_DTLS_BEAN = dataList_PH_IL_CLAIM_COVER_DTLS
							.get(0);
				} else if (dataList_PH_IL_CLAIM_COVER_DTLS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PH_IL_CLAIM_COVER_DTLS_BEAN.setRowSelected(true);
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
		try {
			if (PH_IL_CLAIM_COVER_DTLS_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PH_IL_CLAIM_COVER_DTLS_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataList_PH_IL_CLAIM_COVER_DTLS
						.add(PH_IL_CLAIM_COVER_DTLS_BEAN);
			} else if (PH_IL_CLAIM_COVER_DTLS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PH_IL_CLAIM_COVER_DTLS_BEAN,
						CommonUtils.getConnection());
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
			}

			PH_IL_CLAIM_COVER_DTLS_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PH_IL_CLAIM_COVER_DTLS_BEAN = (PH_IL_CLAIM_COVER_DTLS) dataTable
					.getRowData();
			PH_IL_CLAIM_COVER_DTLS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PH_IL_CLAIM_COVER_DTLS> PH_IL_CLAIM_COVER_DTLS_ITR = dataList_PH_IL_CLAIM_COVER_DTLS
				.iterator();
		while (PH_IL_CLAIM_COVER_DTLS_ITR.hasNext()) {
			PH_IL_CLAIM_COVER_DTLS_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_CCDH_REF_NO.resetValue();
		COMP_CCDH_O_RESERVE_DT.resetValue();
		COMP_CCDH_COVER_CODE.resetValue();
		COMP_CCDH_LOSS_TYPE.resetValue();
		COMP_CCDH_DISAB_TYPE.resetValue();
		COMP_CCDH_PERIOD_UNIT.resetValue();
		COMP_CCDH_PERIOD.resetValue();
		COMP_CCDH_RATE.resetValue();
		COMP_CCDH_RATE_PER.resetValue();
		COMP_CCDH_O_FC_EST_AMT.resetValue();
		COMP_CCDH_FRZ_FLAG.resetValue();
		COMP_CCDH_CONFIRM_FLAG.resetValue();
		COMP_UI_M_CCDH_COVER_CODE_DESC.resetValue();
		COMP_UI_M_CCDH_LOSS_TYPE_DESC.resetValue();
		COMP_UI_M_CCDH_DISAB_TYPE_DESC.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
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


	public void setListCCDH_PERIOD_UNIT(List<SelectItem> listCCDH_PERIOD_UNIT) {
		this.listCCDH_PERIOD_UNIT = listCCDH_PERIOD_UNIT;
	}

	public List<SelectItem> getListCCDH_PERIOD_UNIT() {
		if (listCCDH_PERIOD_UNIT.size() == 0) {
			listCCDH_PERIOD_UNIT.clear();
			try {
				listCCDH_PERIOD_UNIT = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCCDH_PERIOD_UNIT;
	}



	public List<SelectItem> getListCCDH_FRZ_FLAG() {
		if (listCCDH_FRZ_FLAG.size() == 0) {
			listCCDH_FRZ_FLAG.clear();
			try {
				listCCDH_FRZ_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCCDH_FRZ_FLAG;
	}

	public void setListCCDH_FRZ_FLAG(List<SelectItem> listCCDH_FRZ_FLAG) {
		this.listCCDH_FRZ_FLAG = listCCDH_FRZ_FLAG;
	}

	
	public void setListCCDH_CONFIRM_FLAG(List<SelectItem> listCCDH_CONFIRM_FLAG) {
		this.listCCDH_CONFIRM_FLAG = listCCDH_CONFIRM_FLAG;
	}

	public List<SelectItem> getListCCDH_CONFIRM_FLAG() {
		if (listCCDH_CONFIRM_FLAG.size() == 0) {
			listCCDH_CONFIRM_FLAG.clear();
			try {
				listCCDH_CONFIRM_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCCDH_CONFIRM_FLAG;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.whenNewBlockInstance(compositeAction.getPH_IL_CLAIM_COVER_DTLS_ACTION_BEAN());
				helper.preQuery(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN(),
						PH_IL_CLAIM_COVER_DTLS_BEAN);
				helper.executeQuery(compositeAction);
				helper.postQuery(PH_IL_CLAIM_COVER_DTLS_BEAN);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}


	/**
	 * Instantiates all components in PH_IL_CLAIM_COVER_DTLS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_CCDH_REF_NO				 = new HtmlInputText();
		COMP_CCDH_COVER_CODE				 = new HtmlInputText();
		COMP_CCDH_LOSS_TYPE				 = new HtmlInputText();
		COMP_CCDH_DISAB_TYPE				 = new HtmlInputText();
		COMP_CCDH_PERIOD				 = new HtmlInputText();
		COMP_CCDH_RATE					 = new HtmlInputText();
		COMP_CCDH_RATE_PER				 = new HtmlInputText();
		COMP_CCDH_O_FC_EST_AMT				 = new HtmlInputText();
		COMP_UI_M_CCDH_COVER_CODE_DESC			 = new HtmlInputText();
		COMP_UI_M_CCDH_LOSS_TYPE_DESC			 = new HtmlInputText();
		COMP_UI_M_CCDH_DISAB_TYPE_DESC			 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_CCDH_PERIOD_UNIT				 = new HtmlSelectOneMenu();
		COMP_CCDH_FRZ_FLAG				 = new HtmlSelectOneMenu();
		COMP_CCDH_CONFIRM_FLAG				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_CCDH_O_RESERVE_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_LOV_COVER				 = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_DISABLE_TYPE			 = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_LOSS_TYPE			 = new HtmlCommandButton();
		COMP_PUSH_BUTTON1018				 = new HtmlCommandButton();

	}


	/**
	 * Disables all components in PH_IL_CLAIM_COVER_DTLS_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_CCDH_REF_NO.setDisabled(disabled);
		COMP_CCDH_COVER_CODE.setDisabled(disabled);
		COMP_CCDH_LOSS_TYPE.setDisabled(disabled);
		COMP_CCDH_DISAB_TYPE.setDisabled(disabled);
		COMP_CCDH_PERIOD.setDisabled(disabled);
		COMP_CCDH_RATE.setDisabled(disabled);
		COMP_CCDH_RATE_PER.setDisabled(disabled);
		COMP_CCDH_O_FC_EST_AMT.setDisabled(disabled);
		COMP_UI_M_CCDH_COVER_CODE_DESC.setDisabled(disabled);
		COMP_UI_M_CCDH_LOSS_TYPE_DESC.setDisabled(disabled);
		COMP_UI_M_CCDH_DISAB_TYPE_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_CCDH_PERIOD_UNIT.setDisabled(disabled);
		COMP_CCDH_FRZ_FLAG.setDisabled(disabled);
		COMP_CCDH_CONFIRM_FLAG.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_CCDH_O_RESERVE_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_LOV_COVER.setDisabled(disabled);
		COMP_UI_M_BUT_LOV_DISABLE_TYPE.setDisabled(disabled);
		COMP_UI_M_BUT_LOV_LOSS_TYPE.setDisabled(disabled);
		COMP_PUSH_BUTTON1018.setDisabled(disabled);

	}

	/**
	 * @return the dataList_PH_IL_CLAIM_COVER_DTLS
	 */
	public List<PH_IL_CLAIM_COVER_DTLS> getDataList_PH_IL_CLAIM_COVER_DTLS() {
		return dataList_PH_IL_CLAIM_COVER_DTLS;
	}

	/**
	 * @return the filterByCCDH_REF_NO
	 */
	public String getFilterByCCDH_REF_NO() {
		return filterByCCDH_REF_NO;
	}

	/**
	 * @param filterByCCDH_REF_NO the filterByCCDH_REF_NO to set
	 */
	public void setFilterByCCDH_REF_NO(String filterByCCDH_REF_NO) {
		this.filterByCCDH_REF_NO = filterByCCDH_REF_NO;
	}

	/**
	 * @return the filterByCCDH_COVER_CODE
	 */
	public String getFilterByCCDH_COVER_CODE() {
		return filterByCCDH_COVER_CODE;
	}

	/**
	 * @param filterByCCDH_COVER_CODE the filterByCCDH_COVER_CODE to set
	 */
	public void setFilterByCCDH_COVER_CODE(String filterByCCDH_COVER_CODE) {
		this.filterByCCDH_COVER_CODE = filterByCCDH_COVER_CODE;
	}

	/**
	 * @return the filterByCCDH_LOSS_TYPE
	 */
	public String getFilterByCCDH_LOSS_TYPE() {
		return filterByCCDH_LOSS_TYPE;
	}

	/**
	 * @param filterByCCDH_LOSS_TYPE the filterByCCDH_LOSS_TYPE to set
	 */
	public void setFilterByCCDH_LOSS_TYPE(String filterByCCDH_LOSS_TYPE) {
		this.filterByCCDH_LOSS_TYPE = filterByCCDH_LOSS_TYPE;
	}
	
	/**
	 * 
	 * @return
	 */
	public String goToMain(){
		return "claimCoverDetails";
	}

	/**
	 * @return the uI_BUT_MAIN
	 */
	public HtmlCommandButton getUI_BUT_MAIN() {
		return UI_BUT_MAIN;
	}

	/**
	 * @param ui_but_main the uI_BUT_MAIN to set
	 */
	public void setUI_BUT_MAIN(HtmlCommandButton ui_but_main) {
		UI_BUT_MAIN = ui_but_main;
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
}
