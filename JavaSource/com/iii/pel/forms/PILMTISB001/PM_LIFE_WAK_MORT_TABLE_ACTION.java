package com.iii.pel.forms.PILMTISB001;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
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
import com.iii.pel.forms.PILM002_APAC.PM_IL_COVER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_LIFE_WAK_MORT_TABLE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_WAKM_PROD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_WAKM_PROD_DESC;

	private HtmlOutputLabel COMP_WAKM_PROD_CODE_LABEL;

	private HtmlSelectOneMenu COMP_WAKM_PROD_CODE;

	private HtmlOutputLabel COMP_WAKM_COVER_CODE_LABEL;

	private HtmlSelectOneMenu COMP_WAKM_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC;

	private HtmlOutputLabel COMP_WAKM_MORT_CODE_LABEL;

	private HtmlSelectOneMenu COMP_WAKM_MORT_CODE;

	private HtmlOutputLabel COMP_UI_M_MORT_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_MORT_CODE_DESC;

	private HtmlOutputLabel COMP_WAKM_ASSUR_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_WAKM_ASSUR_TYPE;

	private HtmlOutputLabel COMP_WAKM_SA_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_WAKM_SA_TYPE;

	private HtmlOutputLabel COMP_WAKM_SELECT_RATE_LABEL;

	private HtmlSelectOneMenu COMP_WAKM_SELECT_RATE;

	private HtmlOutputLabel COMP_WAKM_SUBSEQ_YN_LABEL;

	private HtmlSelectOneMenu COMP_WAKM_SUBSEQ_YN;

	private HtmlOutputLabel COMP_WAKM_ANLY_CODE_1_LABEL;

	private HtmlSelectOneMenu COMP_WAKM_ANLY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_WAKM_ANLY_CODE_1_DESC_LABEL;

	private HtmlInputText COMP_UI_M_WAKM_ANLY_CODE_1_DESC;

	private HtmlOutputLabel COMP_WAKM_ANLY_CODE_2_LABEL;

	private HtmlSelectOneMenu COMP_WAKM_ANLY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_WAKM_ANLY_CODE_2_DESC_LABEL;

	private HtmlInputText COMP_UI_M_WAKM_ANLY_CODE_2_DESC;

	private HtmlOutputLabel COMP_WAKM_EXP_CODE_LABEL;

	private HtmlSelectOneMenu COMP_WAKM_EXP_CODE;

	private HtmlOutputLabel COMP_UI_M_EXP_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_EXP_CODE_DESC;

	private HtmlOutputLabel COMP_WAKM_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_WAKM_EFF_FM_DT;

	private HtmlOutputLabel COMP_WAKM_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_WAKM_EFF_TO_DT;

	private HtmlOutputLabel COMP_WAKM_SURPRO_PER_LABEL;

	private HtmlInputText COMP_WAKM_SURPRO_PER;

	private HtmlOutputLabel COMP_WAKM_COVER_PERC_LABEL;

	private HtmlInputText COMP_WAKM_COVER_PERC;

	private HtmlOutputLabel COMP_WAKM_SA_RISK_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_WAKM_SA_RISK_TYPE;

	private HtmlOutputLabel COMP_WAKM_WAK_CALC_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_WAKM_WAK_CALC_TYPE;

	private PM_LIFE_WAK_MORT_TABLE PM_LIFE_WAK_MORT_TABLE_BEAN;

	public PILMTISB001_COMPOSITE_ACTION compositeAction;

	private PM_LIFE_WAK_MORT_TABLE_HELPER helper;

	private List<SelectItem> listWAKM_PROD_CODE = new ArrayList<SelectItem>();

	private List<SelectItem> listWAKM_COVER_CODE = new ArrayList<SelectItem>();

	private List<SelectItem> listWAKM_MORT_CODE = new ArrayList<SelectItem>();

	private List<SelectItem> listWAKM_ASSUR_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listWAKM_SA_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listWAKM_SELECT_RATE = new ArrayList<SelectItem>();

	private List<SelectItem> listWAKM_SUBSEQ_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listWAKM_ANLY_CODE_1 = new ArrayList<SelectItem>();

	private List<SelectItem> listWAKM_ANLY_CODE_2 = new ArrayList<SelectItem>();

	private List<SelectItem> listWAKM_EXP_CODE = new ArrayList<SelectItem>();

	private List<SelectItem> listWAKM_SA_RISK_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listWAKM_WAK_CALC_TYPE = new ArrayList<SelectItem>();
	
	private Hashtable<String , String> errors = new Hashtable<String, String>();

	public Hashtable<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Hashtable<String, String> errors) {
		this.errors = errors;
	}

	public PM_LIFE_WAK_MORT_TABLE_ACTION() {
System.out.println("PM_LIFE_WAK_MORT_TABLE_ACTION constructor");
		PM_LIFE_WAK_MORT_TABLE_BEAN = new PM_LIFE_WAK_MORT_TABLE();
		helper = new PM_LIFE_WAK_MORT_TABLE_HELPER();
		prepareListItemValues();
	}

	public HtmlOutputLabel getCOMP_UI_M_WAKM_PROD_DESC_LABEL() {
		return COMP_UI_M_WAKM_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WAKM_PROD_DESC() {
		return COMP_UI_M_WAKM_PROD_DESC;
	}

	public void setCOMP_UI_M_WAKM_PROD_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_WAKM_PROD_DESC_LABEL) {
		this.COMP_UI_M_WAKM_PROD_DESC_LABEL = COMP_UI_M_WAKM_PROD_DESC_LABEL;
	}

	public void setCOMP_UI_M_WAKM_PROD_DESC(
			HtmlInputText COMP_UI_M_WAKM_PROD_DESC) {
		this.COMP_UI_M_WAKM_PROD_DESC = COMP_UI_M_WAKM_PROD_DESC;
	}

	public HtmlOutputLabel getCOMP_WAKM_PROD_CODE_LABEL() {
		return COMP_WAKM_PROD_CODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKM_PROD_CODE() {
		return COMP_WAKM_PROD_CODE;
	}

	public void setCOMP_WAKM_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_WAKM_PROD_CODE_LABEL) {
		this.COMP_WAKM_PROD_CODE_LABEL = COMP_WAKM_PROD_CODE_LABEL;
	}

	public void setCOMP_WAKM_PROD_CODE(HtmlSelectOneMenu COMP_WAKM_PROD_CODE) {
		this.COMP_WAKM_PROD_CODE = COMP_WAKM_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_WAKM_COVER_CODE_LABEL() {
		return COMP_WAKM_COVER_CODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKM_COVER_CODE() {
		return COMP_WAKM_COVER_CODE;
	}

	public void setCOMP_WAKM_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_WAKM_COVER_CODE_LABEL) {
		this.COMP_WAKM_COVER_CODE_LABEL = COMP_WAKM_COVER_CODE_LABEL;
	}

	public void setCOMP_WAKM_COVER_CODE(HtmlSelectOneMenu COMP_WAKM_COVER_CODE) {
		this.COMP_WAKM_COVER_CODE = COMP_WAKM_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_LABEL() {
		return COMP_UI_M_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC() {
		return COMP_UI_M_COVER_DESC;
	}

	public void setCOMP_UI_M_COVER_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL) {
		this.COMP_UI_M_COVER_DESC_LABEL = COMP_UI_M_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC(HtmlInputText COMP_UI_M_COVER_DESC) {
		this.COMP_UI_M_COVER_DESC = COMP_UI_M_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_WAKM_MORT_CODE_LABEL() {
		return COMP_WAKM_MORT_CODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKM_MORT_CODE() {
		return COMP_WAKM_MORT_CODE;
	}

	public void setCOMP_WAKM_MORT_CODE_LABEL(
			HtmlOutputLabel COMP_WAKM_MORT_CODE_LABEL) {
		this.COMP_WAKM_MORT_CODE_LABEL = COMP_WAKM_MORT_CODE_LABEL;
	}

	public void setCOMP_WAKM_MORT_CODE(HtmlSelectOneMenu COMP_WAKM_MORT_CODE) {
		this.COMP_WAKM_MORT_CODE = COMP_WAKM_MORT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_MORT_CODE_DESC_LABEL() {
		return COMP_UI_M_MORT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MORT_CODE_DESC() {
		return COMP_UI_M_MORT_CODE_DESC;
	}

	public void setCOMP_UI_M_MORT_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_MORT_CODE_DESC_LABEL) {
		this.COMP_UI_M_MORT_CODE_DESC_LABEL = COMP_UI_M_MORT_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_MORT_CODE_DESC(
			HtmlInputText COMP_UI_M_MORT_CODE_DESC) {
		this.COMP_UI_M_MORT_CODE_DESC = COMP_UI_M_MORT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_WAKM_ASSUR_TYPE_LABEL() {
		return COMP_WAKM_ASSUR_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKM_ASSUR_TYPE() {
		return COMP_WAKM_ASSUR_TYPE;
	}

	public void setCOMP_WAKM_ASSUR_TYPE_LABEL(
			HtmlOutputLabel COMP_WAKM_ASSUR_TYPE_LABEL) {
		this.COMP_WAKM_ASSUR_TYPE_LABEL = COMP_WAKM_ASSUR_TYPE_LABEL;
	}

	public void setCOMP_WAKM_ASSUR_TYPE(HtmlSelectOneMenu COMP_WAKM_ASSUR_TYPE) {
		this.COMP_WAKM_ASSUR_TYPE = COMP_WAKM_ASSUR_TYPE;
	}

	public HtmlOutputLabel getCOMP_WAKM_SA_TYPE_LABEL() {
		return COMP_WAKM_SA_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKM_SA_TYPE() {
		return COMP_WAKM_SA_TYPE;
	}

	public void setCOMP_WAKM_SA_TYPE_LABEL(
			HtmlOutputLabel COMP_WAKM_SA_TYPE_LABEL) {
		this.COMP_WAKM_SA_TYPE_LABEL = COMP_WAKM_SA_TYPE_LABEL;
	}

	public void setCOMP_WAKM_SA_TYPE(HtmlSelectOneMenu COMP_WAKM_SA_TYPE) {
		this.COMP_WAKM_SA_TYPE = COMP_WAKM_SA_TYPE;
	}

	public HtmlOutputLabel getCOMP_WAKM_SELECT_RATE_LABEL() {
		return COMP_WAKM_SELECT_RATE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKM_SELECT_RATE() {
		return COMP_WAKM_SELECT_RATE;
	}

	public void setCOMP_WAKM_SELECT_RATE_LABEL(
			HtmlOutputLabel COMP_WAKM_SELECT_RATE_LABEL) {
		this.COMP_WAKM_SELECT_RATE_LABEL = COMP_WAKM_SELECT_RATE_LABEL;
	}

	public void setCOMP_WAKM_SELECT_RATE(HtmlSelectOneMenu COMP_WAKM_SELECT_RATE) {
		this.COMP_WAKM_SELECT_RATE = COMP_WAKM_SELECT_RATE;
	}

	public HtmlOutputLabel getCOMP_WAKM_SUBSEQ_YN_LABEL() {
		return COMP_WAKM_SUBSEQ_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKM_SUBSEQ_YN() {
		return COMP_WAKM_SUBSEQ_YN;
	}

	public void setCOMP_WAKM_SUBSEQ_YN_LABEL(
			HtmlOutputLabel COMP_WAKM_SUBSEQ_YN_LABEL) {
		this.COMP_WAKM_SUBSEQ_YN_LABEL = COMP_WAKM_SUBSEQ_YN_LABEL;
	}

	public void setCOMP_WAKM_SUBSEQ_YN(HtmlSelectOneMenu COMP_WAKM_SUBSEQ_YN) {
		this.COMP_WAKM_SUBSEQ_YN = COMP_WAKM_SUBSEQ_YN;
	}

	public HtmlOutputLabel getCOMP_WAKM_ANLY_CODE_1_LABEL() {
		return COMP_WAKM_ANLY_CODE_1_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKM_ANLY_CODE_1() {
		return COMP_WAKM_ANLY_CODE_1;
	}

	public void setCOMP_WAKM_ANLY_CODE_1_LABEL(
			HtmlOutputLabel COMP_WAKM_ANLY_CODE_1_LABEL) {
		this.COMP_WAKM_ANLY_CODE_1_LABEL = COMP_WAKM_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_WAKM_ANLY_CODE_1(HtmlSelectOneMenu COMP_WAKM_ANLY_CODE_1) {
		this.COMP_WAKM_ANLY_CODE_1 = COMP_WAKM_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_WAKM_ANLY_CODE_1_DESC_LABEL() {
		return COMP_UI_M_WAKM_ANLY_CODE_1_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WAKM_ANLY_CODE_1_DESC() {
		return COMP_UI_M_WAKM_ANLY_CODE_1_DESC;
	}

	public void setCOMP_UI_M_WAKM_ANLY_CODE_1_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_WAKM_ANLY_CODE_1_DESC_LABEL) {
		this.COMP_UI_M_WAKM_ANLY_CODE_1_DESC_LABEL = COMP_UI_M_WAKM_ANLY_CODE_1_DESC_LABEL;
	}

	public void setCOMP_UI_M_WAKM_ANLY_CODE_1_DESC(
			HtmlInputText COMP_UI_M_WAKM_ANLY_CODE_1_DESC) {
		this.COMP_UI_M_WAKM_ANLY_CODE_1_DESC = COMP_UI_M_WAKM_ANLY_CODE_1_DESC;
	}

	public HtmlOutputLabel getCOMP_WAKM_ANLY_CODE_2_LABEL() {
		return COMP_WAKM_ANLY_CODE_2_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKM_ANLY_CODE_2() {
		return COMP_WAKM_ANLY_CODE_2;
	}

	public void setCOMP_WAKM_ANLY_CODE_2_LABEL(
			HtmlOutputLabel COMP_WAKM_ANLY_CODE_2_LABEL) {
		this.COMP_WAKM_ANLY_CODE_2_LABEL = COMP_WAKM_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_WAKM_ANLY_CODE_2(HtmlSelectOneMenu COMP_WAKM_ANLY_CODE_2) {
		this.COMP_WAKM_ANLY_CODE_2 = COMP_WAKM_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_WAKM_ANLY_CODE_2_DESC_LABEL() {
		return COMP_UI_M_WAKM_ANLY_CODE_2_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WAKM_ANLY_CODE_2_DESC() {
		return COMP_UI_M_WAKM_ANLY_CODE_2_DESC;
	}

	public void setCOMP_UI_M_WAKM_ANLY_CODE_2_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_WAKM_ANLY_CODE_2_DESC_LABEL) {
		this.COMP_UI_M_WAKM_ANLY_CODE_2_DESC_LABEL = COMP_UI_M_WAKM_ANLY_CODE_2_DESC_LABEL;
	}

	public void setCOMP_UI_M_WAKM_ANLY_CODE_2_DESC(
			HtmlInputText COMP_UI_M_WAKM_ANLY_CODE_2_DESC) {
		this.COMP_UI_M_WAKM_ANLY_CODE_2_DESC = COMP_UI_M_WAKM_ANLY_CODE_2_DESC;
	}

	public HtmlOutputLabel getCOMP_WAKM_EXP_CODE_LABEL() {
		return COMP_WAKM_EXP_CODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKM_EXP_CODE() {
		return COMP_WAKM_EXP_CODE;
	}

	public void setCOMP_WAKM_EXP_CODE_LABEL(
			HtmlOutputLabel COMP_WAKM_EXP_CODE_LABEL) {
		this.COMP_WAKM_EXP_CODE_LABEL = COMP_WAKM_EXP_CODE_LABEL;
	}

	public void setCOMP_WAKM_EXP_CODE(HtmlSelectOneMenu COMP_WAKM_EXP_CODE) {
		this.COMP_WAKM_EXP_CODE = COMP_WAKM_EXP_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_EXP_CODE_DESC_LABEL() {
		return COMP_UI_M_EXP_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_EXP_CODE_DESC() {
		return COMP_UI_M_EXP_CODE_DESC;
	}

	public void setCOMP_UI_M_EXP_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_EXP_CODE_DESC_LABEL) {
		this.COMP_UI_M_EXP_CODE_DESC_LABEL = COMP_UI_M_EXP_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_EXP_CODE_DESC(HtmlInputText COMP_UI_M_EXP_CODE_DESC) {
		this.COMP_UI_M_EXP_CODE_DESC = COMP_UI_M_EXP_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_WAKM_EFF_FM_DT_LABEL() {
		return COMP_WAKM_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_WAKM_EFF_FM_DT() {
		return COMP_WAKM_EFF_FM_DT;
	}

	public void setCOMP_WAKM_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_WAKM_EFF_FM_DT_LABEL) {
		this.COMP_WAKM_EFF_FM_DT_LABEL = COMP_WAKM_EFF_FM_DT_LABEL;
	}

	public void setCOMP_WAKM_EFF_FM_DT(HtmlCalendar COMP_WAKM_EFF_FM_DT) {
		this.COMP_WAKM_EFF_FM_DT = COMP_WAKM_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_WAKM_EFF_TO_DT_LABEL() {
		return COMP_WAKM_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_WAKM_EFF_TO_DT() {
		return COMP_WAKM_EFF_TO_DT;
	}

	public void setCOMP_WAKM_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_WAKM_EFF_TO_DT_LABEL) {
		this.COMP_WAKM_EFF_TO_DT_LABEL = COMP_WAKM_EFF_TO_DT_LABEL;
	}

	public void setCOMP_WAKM_EFF_TO_DT(HtmlCalendar COMP_WAKM_EFF_TO_DT) {
		this.COMP_WAKM_EFF_TO_DT = COMP_WAKM_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_WAKM_SURPRO_PER_LABEL() {
		return COMP_WAKM_SURPRO_PER_LABEL;
	}

	public HtmlInputText getCOMP_WAKM_SURPRO_PER() {
		return COMP_WAKM_SURPRO_PER;
	}

	public void setCOMP_WAKM_SURPRO_PER_LABEL(
			HtmlOutputLabel COMP_WAKM_SURPRO_PER_LABEL) {
		this.COMP_WAKM_SURPRO_PER_LABEL = COMP_WAKM_SURPRO_PER_LABEL;
	}

	public void setCOMP_WAKM_SURPRO_PER(HtmlInputText COMP_WAKM_SURPRO_PER) {
		this.COMP_WAKM_SURPRO_PER = COMP_WAKM_SURPRO_PER;
	}

	public HtmlOutputLabel getCOMP_WAKM_COVER_PERC_LABEL() {
		return COMP_WAKM_COVER_PERC_LABEL;
	}

	public HtmlInputText getCOMP_WAKM_COVER_PERC() {
		return COMP_WAKM_COVER_PERC;
	}

	public void setCOMP_WAKM_COVER_PERC_LABEL(
			HtmlOutputLabel COMP_WAKM_COVER_PERC_LABEL) {
		this.COMP_WAKM_COVER_PERC_LABEL = COMP_WAKM_COVER_PERC_LABEL;
	}

	public void setCOMP_WAKM_COVER_PERC(HtmlInputText COMP_WAKM_COVER_PERC) {
		this.COMP_WAKM_COVER_PERC = COMP_WAKM_COVER_PERC;
	}

	public HtmlOutputLabel getCOMP_WAKM_SA_RISK_TYPE_LABEL() {
		return COMP_WAKM_SA_RISK_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKM_SA_RISK_TYPE() {
		return COMP_WAKM_SA_RISK_TYPE;
	}

	public void setCOMP_WAKM_SA_RISK_TYPE_LABEL(
			HtmlOutputLabel COMP_WAKM_SA_RISK_TYPE_LABEL) {
		this.COMP_WAKM_SA_RISK_TYPE_LABEL = COMP_WAKM_SA_RISK_TYPE_LABEL;
	}

	public void setCOMP_WAKM_SA_RISK_TYPE(
			HtmlSelectOneMenu COMP_WAKM_SA_RISK_TYPE) {
		this.COMP_WAKM_SA_RISK_TYPE = COMP_WAKM_SA_RISK_TYPE;
	}

	public HtmlOutputLabel getCOMP_WAKM_WAK_CALC_TYPE_LABEL() {
		return COMP_WAKM_WAK_CALC_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKM_WAK_CALC_TYPE() {
		return COMP_WAKM_WAK_CALC_TYPE;
	}

	public void setCOMP_WAKM_WAK_CALC_TYPE_LABEL(
			HtmlOutputLabel COMP_WAKM_WAK_CALC_TYPE_LABEL) {
		this.COMP_WAKM_WAK_CALC_TYPE_LABEL = COMP_WAKM_WAK_CALC_TYPE_LABEL;
	}

	public void setCOMP_WAKM_WAK_CALC_TYPE(
			HtmlSelectOneMenu COMP_WAKM_WAK_CALC_TYPE) {
		this.COMP_WAKM_WAK_CALC_TYPE = COMP_WAKM_WAK_CALC_TYPE;
	}

	public PM_LIFE_WAK_MORT_TABLE getPM_LIFE_WAK_MORT_TABLE_BEAN() {
		return PM_LIFE_WAK_MORT_TABLE_BEAN;
	}

	public void setPM_LIFE_WAK_MORT_TABLE_BEAN(
			PM_LIFE_WAK_MORT_TABLE PM_LIFE_WAK_MORT_TABLE_BEAN) {
		this.PM_LIFE_WAK_MORT_TABLE_BEAN = PM_LIFE_WAK_MORT_TABLE_BEAN;
	}

	public void saveRecord() {
		CommonUtils.clearMaps(this);
		String message = "";
		try {
			if (getPM_LIFE_WAK_MORT_TABLE_BEAN().getROWID() != null) {
				if(isUPDATE_ALLOWED()){
					helper.PRE_UPDATE(compositeAction);
					new CRUDHandler().executeUpdate(
							getPM_LIFE_WAK_MORT_TABLE_BEAN(), CommonUtils
							.getConnection());
					message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
				}else{
					throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$updatenotallowed"));
				}
			} else {
				if(isINSERT_ALLOWED()){
					helper.PRE_INSERT(compositeAction);
					new CRUDHandler().executeInsert(
							getPM_LIFE_WAK_MORT_TABLE_BEAN(), CommonUtils
							.getConnection());
					message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save");
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE",
					message);
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public String deleteRecord() {
		CommonUtils.clearMaps(this);
		CommonUtils commonUtils = new CommonUtils();
		try {
			if (PM_LIFE_WAK_MORT_TABLE_BEAN == null) {
				getErrorMap().put("key", "not to delete");
				getErrorMap().put("current", "not to delete");
			} else {
				String deleteMeaage = Messages.getString("messageProperties",
						"errorPanel$message$delete");
				// helper.pm_broker_comm_hdr_pre_DELETE(headerBean);
				delete_pm_fund_setup();
				commonUtils.doComitt();
				setPM_LIFE_WAK_MORT_TABLE_BEAN(new PM_LIFE_WAK_MORT_TABLE());
				getWarningMap().put("errorKey", deleteMeaage);
				getWarningMap().put("current", deleteMeaage);
			}
			resetAllComponent();
			PM_LIFE_WAK_MORT_TABLE_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete_pm_fund_setup() throws DBException, DBException {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();
			handler.executeDelete(PM_LIFE_WAK_MORT_TABLE_BEAN, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Resets all components in PM_LIFE_WAK_MORT_TABLE_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_UI_M_WAKM_PROD_DESC.resetValue();
		COMP_UI_M_COVER_DESC.resetValue();
		COMP_UI_M_MORT_CODE_DESC.resetValue();
		COMP_UI_M_WAKM_ANLY_CODE_1_DESC.resetValue();
		COMP_UI_M_WAKM_ANLY_CODE_2_DESC.resetValue();
		COMP_UI_M_EXP_CODE_DESC.resetValue();
		COMP_WAKM_SURPRO_PER.resetValue();
		COMP_WAKM_COVER_PERC.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_WAKM_PROD_CODE.resetValue();
		COMP_WAKM_COVER_CODE.resetValue();
		COMP_WAKM_MORT_CODE.resetValue();
		COMP_WAKM_ASSUR_TYPE.resetValue();
		COMP_WAKM_SA_TYPE.resetValue();
		COMP_WAKM_SELECT_RATE.resetValue();
		COMP_WAKM_SUBSEQ_YN.resetValue();
		COMP_WAKM_ANLY_CODE_1.resetValue();
		COMP_WAKM_ANLY_CODE_2.resetValue();
		COMP_WAKM_EXP_CODE.resetValue();
		COMP_WAKM_SA_RISK_TYPE.resetValue();
		COMP_WAKM_WAK_CALC_TYPE.resetValue();

		// Reseting HtmlCalendar
		COMP_WAKM_EFF_FM_DT.resetValue();
		COMP_WAKM_EFF_TO_DT.resetValue();

	}



	public List<SelectItem> getListWAKM_PROD_CODE() {
		return listWAKM_PROD_CODE;
	}

	public void setListWAKM_PROD_CODE(List<SelectItem> listWAKM_PROD_CODE) {
		this.listWAKM_PROD_CODE = listWAKM_PROD_CODE;
	}

	public List<SelectItem> getListWAKM_COVER_CODE() {
		return listWAKM_COVER_CODE;
	}

	public void setListWAKM_COVER_CODE(List<SelectItem> listWAKM_COVER_CODE) {
		this.listWAKM_COVER_CODE = listWAKM_COVER_CODE;
	}

	public List<SelectItem> getListWAKM_MORT_CODE() {
		return listWAKM_MORT_CODE;
	}

	public void setListWAKM_MORT_CODE(List<SelectItem> listWAKM_MORT_CODE) {
		this.listWAKM_MORT_CODE = listWAKM_MORT_CODE;
	}

	public List<SelectItem> getListWAKM_ASSUR_TYPE() {
		return listWAKM_ASSUR_TYPE;
	}

	public void setListWAKM_ASSUR_TYPE(List<SelectItem> listWAKM_ASSUR_TYPE) {
		this.listWAKM_ASSUR_TYPE = listWAKM_ASSUR_TYPE;
	}

	public List<SelectItem> getListWAKM_SA_TYPE() {
		return listWAKM_SA_TYPE;
	}

	public void setListWAKM_SA_TYPE(List<SelectItem> listWAKM_SA_TYPE) {
		this.listWAKM_SA_TYPE = listWAKM_SA_TYPE;
	}

	public List<SelectItem> getListWAKM_SELECT_RATE() {
		return listWAKM_SELECT_RATE;
	}

	public void setListWAKM_SELECT_RATE(List<SelectItem> listWAKM_SELECT_RATE) {
		this.listWAKM_SELECT_RATE = listWAKM_SELECT_RATE;
	}

	public List<SelectItem> getListWAKM_SUBSEQ_YN() {
		return listWAKM_SUBSEQ_YN;
	}

	public void setListWAKM_SUBSEQ_YN(List<SelectItem> listWAKM_SUBSEQ_YN) {
		this.listWAKM_SUBSEQ_YN = listWAKM_SUBSEQ_YN;
	}

	public List<SelectItem> getListWAKM_ANLY_CODE_1() {
		return listWAKM_ANLY_CODE_1;
	}

	public void setListWAKM_ANLY_CODE_1(List<SelectItem> listWAKM_ANLY_CODE_1) {
		this.listWAKM_ANLY_CODE_1 = listWAKM_ANLY_CODE_1;
	}

	public List<SelectItem> getListWAKM_ANLY_CODE_2() {
		return listWAKM_ANLY_CODE_2;
	}

	public void setListWAKM_ANLY_CODE_2(List<SelectItem> listWAKM_ANLY_CODE_2) {
		this.listWAKM_ANLY_CODE_2 = listWAKM_ANLY_CODE_2;
	}

	public List<SelectItem> getListWAKM_EXP_CODE() {
		return listWAKM_EXP_CODE;
	}

	public void setListWAKM_EXP_CODE(List<SelectItem> listWAKM_EXP_CODE) {
		this.listWAKM_EXP_CODE = listWAKM_EXP_CODE;
	}

	public List<SelectItem> getListWAKM_SA_RISK_TYPE() {
		return listWAKM_SA_RISK_TYPE;
	}

	public void setListWAKM_SA_RISK_TYPE(List<SelectItem> listWAKM_SA_RISK_TYPE) {
		this.listWAKM_SA_RISK_TYPE = listWAKM_SA_RISK_TYPE;
	}

	public List<SelectItem> getListWAKM_WAK_CALC_TYPE() {
		return listWAKM_WAK_CALC_TYPE;
	}

	public void setListWAKM_WAK_CALC_TYPE(
			List<SelectItem> listWAKM_WAK_CALC_TYPE) {
		this.listWAKM_WAK_CALC_TYPE = listWAKM_WAK_CALC_TYPE;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void WAKM_PROD_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WAKM_PROD_CODE_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_LIFE_WAK_MORT_TABLE_BEAN().setWAKM_PROD_CODE((String) value);
			COMP_UI_M_WAKM_PROD_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void WAKM_COVER_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WAKM_COVER_CODE_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_LIFE_WAK_MORT_TABLE_BEAN().setWAKM_COVER_CODE((String) value);
			COMP_UI_M_COVER_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void WAKM_MORT_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WAKM_MORT_CODE_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_LIFE_WAK_MORT_TABLE_BEAN().setWAKM_MORT_CODE((String) value);
			COMP_UI_M_MORT_CODE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void WAKM_ANLY_CODE_1_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WAKM_ANLY_CODE_1_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_LIFE_WAK_MORT_TABLE_BEAN()
					.setWAKM_ANLY_CODE_1((String) value);
			COMP_UI_M_WAKM_ANLY_CODE_1_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void WAKM_ANLY_CODE_2_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WAKM_ANLY_CODE_2_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_LIFE_WAK_MORT_TABLE_BEAN()
					.setWAKM_ANLY_CODE_2((String) value);
			COMP_UI_M_WAKM_ANLY_CODE_2_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void WAKM_EXP_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WAKM_EXP_CODE_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_LIFE_WAK_MORT_TABLE_BEAN().setWAKM_EXP_CODE((String) value);
			COMP_UI_M_EXP_CODE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if (compositeAction.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
						.getPM_LIFE_WAK_MORT_TABLE_BEAN().getROWID() != null) {
					helper.POST_QUERY(compositeAction);
				} else {
					helper.WHEN_CREATE_RECORD(compositeAction);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	private void prepareListItemValues() {
		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();
			listWAKM_PROD_CODE.add(new SelectItem("","")); 
			listWAKM_PROD_CODE.addAll(ListItemUtil.getDropDownListValue_1(
					connection, "PILMTISB001", "PM_LIFE_WAK_MORT_TABLE",
					"PM_LIFE_WAK_MORT_TABLE.WAKM_PROD_CODE", null));
			listWAKM_COVER_CODE.add(new SelectItem("",""));
			listWAKM_COVER_CODE.addAll(ListItemUtil.getDropDownListValue_1(
					connection, "PILMTISB001", "PM_LIFE_WAK_MORT_TABLE",
					"PM_LIFE_WAK_MORT_TABLE.WAKM_COVER_CODE", null));
			listWAKM_MORT_CODE.add(new SelectItem("",""));
			listWAKM_MORT_CODE.addAll(ListItemUtil.getDropDownListValue_1(
					connection, "PILMTISB001", "PM_LIFE_WAK_MORT_TABLE",
					"PM_LIFE_WAK_MORT_TABLE.WAKM_MORT_CODE", null));
			listWAKM_ASSUR_TYPE.add(new SelectItem("",""));
			listWAKM_ASSUR_TYPE.addAll(ListItemUtil.getDropDownListValue_1(
					connection, "PILMTISB001", "PM_LIFE_WAK_MORT_TABLE",
					"PM_LIFE_WAK_MORT_TABLE.WAKM_ASSUR_TYPE", null));
			System.out.println("Body Type Add Start");
			listWAKM_ANLY_CODE_1.add(new SelectItem("",""));
			listWAKM_ANLY_CODE_1.addAll(ListItemUtil.getDropDownListValue_1(
					connection, "PILMTISB001", "PM_LIFE_WAK_MORT_TABLE",
					"PM_LIFE_WAK_MORT_TABLE.WAKM_ANLY_CODE_1", null));
			System.out.println("listWAKM_ANLY_CODE_1      "+listWAKM_ANLY_CODE_1);
			System.out.println("listWAKM_ANLY_CODE_1 size      "+listWAKM_ANLY_CODE_1.size());
			System.out.println("Body Type Add End");
			listWAKM_ANLY_CODE_2.add(new SelectItem("",""));
			listWAKM_ANLY_CODE_2.addAll(ListItemUtil.getDropDownListValue_1(
					connection, "PILMTISB001", "PM_LIFE_WAK_MORT_TABLE",
					"PM_LIFE_WAK_MORT_TABLE.WAKM_ANLY_CODE_2", null));
			listWAKM_EXP_CODE.add(new SelectItem("",""));
			listWAKM_EXP_CODE.addAll(ListItemUtil.getDropDownListValue_1(connection,
					"PILMTISB001", "PM_LIFE_WAK_MORT_TABLE",
					"PM_LIFE_WAK_MORT_TABLE.WAKM_EXP_CODE", null));
			listWAKM_SA_RISK_TYPE.add(new SelectItem("",""));
			listWAKM_SA_RISK_TYPE.addAll(ListItemUtil.getDropDownListValue_1(
					connection, "PILMTISB001", "PM_LIFE_WAK_MORT_TABLE",
					"PM_LIFE_WAK_MORT_TABLE.WAKM_SA_RISK_TYPE", null));
			listWAKM_SA_TYPE.add(new SelectItem("",""));
			listWAKM_SA_TYPE.addAll(ListItemUtil.getDropDownListValue_1(connection,
					"PILMTISB001", "PM_LIFE_WAK_MORT_TABLE",
					"PM_LIFE_WAK_MORT_TABLE.WAKM_SA_TYPE", null));
			listWAKM_SELECT_RATE.add(new SelectItem("",""));
			listWAKM_SELECT_RATE.addAll(ListItemUtil.getDropDownListValue_1(
					connection, "PILMTISB001", "PM_LIFE_WAK_MORT_TABLE",
					"PM_LIFE_WAK_MORT_TABLE.WAKM_SELECT_RATE", null));

			listWAKM_SUBSEQ_YN = ListItemUtil.getDropDownListValue_1(
					connection, "PILMTISB001", "PM_LIFE_WAK_MORT_TABLE",
					"PM_LIFE_WAK_MORT_TABLE.WAKM_SUBSEQ_YN", null);
			listWAKM_WAK_CALC_TYPE.add(new SelectItem("",""));
			listWAKM_WAK_CALC_TYPE.addAll(ListItemUtil.getDropDownListValue_1(
					connection, "PILMTISB001", "PM_LIFE_WAK_MORT_TABLE",
					"PM_LIFE_WAK_MORT_TABLE.WAKM_WAK_CALC_TYPE", null));

		} catch (DBException e) {

			e.printStackTrace();
		}

	}
	
	public void whenValidateItemWAKM_EFF_FM_DT() throws Exception{
		Date effFromDate =PM_LIFE_WAK_MORT_TABLE_BEAN.getWAKM_EFF_FM_DT();
		Date effToDate=PM_LIFE_WAK_MORT_TABLE_BEAN.getWAKM_EFF_TO_DT();
		try {
			if(effFromDate != null){
				if (effToDate != null) {
					if(effFromDate.after(effToDate)){
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
					}
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
		
	public void validateWAKM_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_EFF_TO_DT((Date) value);
			whenValidateItemWAKM_EFF_TO_DT();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
    		try {
    			ErrorHelpUtil.getWarningForProcedure(CommonUtils
    					.getConnection(), "WAKM_EFF_TO_DT",
    					getWarningMap());

    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
	}	
		
	public void whenValidateItemWAKM_EFF_TO_DT() throws Exception{
		Date effToDate = PM_LIFE_WAK_MORT_TABLE_BEAN.getWAKM_EFF_TO_DT();
		Date effFromDate= PM_LIFE_WAK_MORT_TABLE_BEAN.getWAKM_EFF_FM_DT();
		try {
			if(effToDate != null && effFromDate != null){
				if(effFromDate.after(effToDate)){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void validateWAKM_EFF_FM_DT(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_EFF_FM_DT((Date) value);
			whenValidateItemWAKM_EFF_FM_DT();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
    		try {
    			ErrorHelpUtil.getWarningForProcedure(CommonUtils
    					.getConnection(), "WAKM_EFF_FM_DT",
    					getWarningMap());

    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
	}

	
	public void whenValidateWAKM_EFF_FM_DT(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//PM_IL_LOAN_SLAB_INTEREST gridBean = getInterestDetailList().get(getInterestTable().getRowIndex());
		UIInput input = (UIInput) event.getComponent().getParent();
		String componentCaption = ErrorHelpUtil.findFieldName(FacesContext.getCurrentInstance(), input);
		String value = (String) input.getSubmittedValue();
		if(!"".equals(value)) {
			DateFormat dateFormat = new SimpleDateFormat(getDatePattern());
			try {
				Date fromDate = dateFormat.parse(value);
				//gridBean.setLSI_EFF_FM_DT(fromDate);
				this.PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_EFF_FM_DT(fromDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void whenValidateWAKM_EFF_TO_DT(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//PM_IL_LOAN_SLAB_INTEREST gridBean = getInterestDetailList().get(getInterestTable().getRowIndex());
		String stringFromDate = (String)getCOMP_WAKM_EFF_TO_DT().getSubmittedValue();

		UIInput component = (UIInput) event.getComponent().getParent();
		String stringToDate = (String) component.getSubmittedValue();
		String componentCaption = ErrorHelpUtil.findFieldName(FacesContext.getCurrentInstance(), component);
		
		System.out.println("PM_LIFE_WAK_MORT_TABLE_ACTION.whenValidateWAKM_EFF_TO_DT() stringFromDate: "+stringFromDate);		

		if(!"".equals(stringFromDate) && !"".equals(stringToDate)) {
			Date fromDate = new Date(stringFromDate);
			Date dateToDate = new Date(stringToDate);
			//gridBean.setLSI_EFF_TO_DT(dateToDate);
			this.PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_EFF_TO_DT(dateToDate);
			if(fromDate!=null && dateToDate!=null) {
				if(fromDate.equals(dateToDate)) {
					removeErrorMessage(componentCaption);
				} else {
					if(!fromDate.before(dateToDate)) {
						throwErrorMessage(componentCaption, Messages.getMessage(PELConstants.pelErrorMessagePath,"71145").getSummary());
					} else {
						removeErrorMessage(componentCaption);
					}
				}
			} 
		} else {
			removeErrorMessage(componentCaption);
		}
		//lastColumnListener();
	}
	
	private void removeErrorMessage(String id) {
		getErrorMap().remove("current");
		getErrorMap().remove(id);
		getErrors().remove(id);
	}
	private void throwMessage(String message) {
		getErrorMap().put("current",message);
	}
	
	private void throwWarningMessage(String id,String string) {
		getWarningMap().put("current",string);
//		getWarningMap().put(id,id+" : "+string);
	}
	private void throwErrorMessage(String id , String string) {
		getErrorMap().put("current",string);
		getErrorMap().put(id,id+" : "+string);
		getErrors().put(id,string);
		getWarningMap().clear();
	}

}
