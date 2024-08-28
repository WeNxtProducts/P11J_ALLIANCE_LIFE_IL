package com.iii.pel.forms.PILM002_APAC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlSimpleTogglePanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY_QUERY_CONSTANTS;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_COVER_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_COVER_BL_DESC_LABEL;

	private HtmlInputText COMP_COVER_BL_DESC;

	private HtmlOutputLabel COMP_COVER_BL_LONG_DESC_LABEL;

	private HtmlInputText COMP_COVER_BL_LONG_DESC;

	private HtmlOutputLabel COMP_COVER_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_COVER_FRZ_FLAG;

	private HtmlOutputLabel COMP_COVER_CODE_LABEL;

	private HtmlInputText COMP_COVER_CODE;

	private HtmlOutputLabel COMP_COVER_DESC_LABEL;

	private HtmlOutputLabel COMP_COVER_MEDICAL_YN_LABEL;

	private HtmlSelectOneMenu COMP_COVER_MEDICAL_YN;

	// private HtmlOutputLabel COMP_COVER_SURGICAL_YN_LABEL;

	// private HtmlSelectOneMenu COMP_COVER_SURGICAL_YN;

	private HtmlInputText COMP_COVER_DESC;

	private HtmlOutputLabel COMP_COVER_LONG_DESC_LABEL;

	private HtmlInputText COMP_COVER_LONG_DESC;

	private HtmlOutputLabel COMP_COVER_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_COVER_TYPE;

	private HtmlOutputLabel COMP_CREATE_BASIC_COVER_LABEL;

	private HtmlSelectOneMenu COMP_CREATE_BASIC_COVER;

	private HtmlOutputLabel COMP_COVER_APP_ON_BASIC_RATE_LABEL;

	private HtmlSelectOneMenu COMP_COVER_APP_ON_BASIC_RATE;

	private HtmlOutputLabel COMP_COVER_DISC_AGE_YN_LABEL;

	private HtmlSelectOneMenu COMP_COVER_DISC_AGE_YN;

	private HtmlOutputLabel COMP_COVER_CLASS_LABEL;

	private HtmlSelectOneMenu COMP_COVER_CLASS;

	private HtmlOutputLabel COMP_COVER_RATE_APPLIED_ON_LABEL;

	private HtmlSelectOneMenu COMP_COVER_RATE_APPLIED_ON;

	private HtmlOutputLabel COMP_COVER_SA_CALC_LABEL;

	private HtmlSelectOneMenu COMP_COVER_SA_CALC;

	private HtmlOutputLabel COMP_COVER_SA_PERC_LABEL;

	private HtmlInputText COMP_COVER_SA_PERC;

	private HtmlOutputLabel COMP_COVER_VAR_VALUE_LABEL;

	private HtmlInputText COMP_COVER_VAR_VALUE;

	private HtmlOutputLabel COMP_COVER_PREM_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_COVER_PREM_TYPE;

	private HtmlOutputLabel COMP_COVER_MIN_SA_LABEL;

	private HtmlInputText COMP_COVER_MIN_SA;

	private HtmlOutputLabel COMP_COVER_MAX_SA_LABEL;

	private HtmlInputText COMP_COVER_MAX_SA;

	private HtmlOutputLabel COMP_COVER_FUND_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_COVER_FUND_TYPE;

	private HtmlOutputLabel COMP_COVER_FUND_MTHD_LABEL;

	private HtmlSelectOneMenu COMP_COVER_FUND_MTHD;

	private HtmlOutputLabel COMP_COVER_FUND_RISK_LABEL;

	private HtmlSelectOneMenu COMP_COVER_FUND_RISK;

	private HtmlOutputLabel COMP_COVER_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_COVER_EFF_FM_DT;

	private HtmlOutputLabel COMP_COVER_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_COVER_EFF_TO_DT;

	private HtmlOutputLabel COMP_COVER_MAX_UNIT_LABEL;

	private HtmlInputText COMP_COVER_MAX_UNIT;

	private HtmlOutputLabel COMP_COVER_MIN_UNIT_LABEL;

	private HtmlInputText COMP_COVER_MIN_UNIT;

	private HtmlOutputLabel COMP_COVER_SA_MULTIPLE_LABEL;

	private HtmlInputText COMP_COVER_SA_MULTIPLE;

	private HtmlOutputLabel COMP_COVER_MIN_MAX_REQ_LABEL;

	private HtmlSelectOneMenu COMP_COVER_MIN_MAX_REQ;

	private HtmlCommandButton COMP_UI_M_BUT_EDITOR_LONG_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_BILINGUAL;
	
	private HtmlOutputLabel COMP_COVER_SA_BY_PARTS_TARR_LABEL;
	
	
	/*added by gopi for toi on 24/05/18*/
	private HtmlOutputLabel COMP_COVER_SA_FIXED_LABEL;
	
	

	private HtmlInputText COMP_COVER_SA_FIXED;
	
	
	/*end*/
	
	public HtmlOutputLabel getCOMP_COVER_SA_FIXED_LABEL() {
		return COMP_COVER_SA_FIXED_LABEL;
	}

	public void setCOMP_COVER_SA_FIXED_LABEL(
			HtmlOutputLabel cOMP_COVER_SA_FIXED_LABEL) {
		COMP_COVER_SA_FIXED_LABEL = cOMP_COVER_SA_FIXED_LABEL;
	}

	public HtmlInputText getCOMP_COVER_SA_FIXED() {
		return COMP_COVER_SA_FIXED;
	}

	public void setCOMP_COVER_SA_FIXED(HtmlInputText cOMP_COVER_SA_FIXED) {
		COMP_COVER_SA_FIXED = cOMP_COVER_SA_FIXED;
	}

	private HtmlInputText COMP_COVER_SA_BY_PARTS_TARR;

	private PM_IL_COVER PM_IL_COVER_BEAN;
	
	private HtmlOutputLabel COMP_COVER_MIN_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_COVER_MIN_TYPE;
	private HtmlOutputLabel COMP_COVER_MAX_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_COVER_MAX_TYPE;
	private HtmlOutputLabel COMP_COVER_MIN_PERC_LABEL;
	private HtmlInputText COMP_COVER_MIN_PERC;
	private HtmlOutputLabel COMP_COVER_MAX_PERC_LABEL;
	private HtmlInputText COMP_COVER_MAX_PERC;
	
	private HtmlSimpleTogglePanel COMP_BILINGUAL_PANEL;
	

	// Fields for DROPDOWN values begin
	private List<SelectItem> COVER_TYPE_ITEMS;
	private List<SelectItem> COVER_APP_ON_BASIC_RATE_ITEMS;
	private List<SelectItem> COVER_CLASS_ITEMS;
	private List<SelectItem> COVER_SA_CALC_ITEMS;
	private List<SelectItem> COVER_DISC_AGE_YN_ITEMS;
	private List<SelectItem> COVER_RATE_APPLIED_ON_ITEMS;
	private List<SelectItem> COVER_PREM_TYPE_ITEMS;
	private List<SelectItem> COVER_FUND_TYPE_ITEMS;
	private List<SelectItem> COVER_FUND_MTHD_ITEMS;
	private List<SelectItem> COVER_FUND_RISK_ITEMS;
	private List<SelectItem> COVER_MIN_MAX_REQ_ITEMS;
	private List<SelectItem> COVER_MEDICAL_YN_ITEMS;
	private List<SelectItem> COVER_SURGICAL_YN_ITEMS;
	private List<SelectItem> CREATE_BASIC_COVER_ITEMS;
	
	private List<SelectItem> COVER_MIN_TYPE_ITEMS;
	private List<SelectItem> COVER_MAX_TYPE_ITEMS;
	
	/*Added by saritha on 18/12/2017 for ssp call id : ZBLIFE-1463447*/ 
	private List<SelectItem> COVER_FUNERAL_CVR_YN_ITEMS;

	public List<SelectItem> getCOVER_FUNERAL_CVR_YN_ITEMS() {
		return COVER_FUNERAL_CVR_YN_ITEMS;
	}

	public void setCOVER_FUNERAL_CVR_YN_ITEMS(
			List<SelectItem> cOVER_FUNERAL_CVR_YN_ITEMS) {
		COVER_FUNERAL_CVR_YN_ITEMS = cOVER_FUNERAL_CVR_YN_ITEMS;
	}
	
	/*End*/
	
	// Fields for DROPDOWN end

	


	private boolean isInsertmode;
	
	public PILM002_APAC_COMPOSITE_ACTION compositeAction;

	public PM_IL_COVER_ACTION() {
		PM_IL_COVER_BEAN = new PM_IL_COVER();
		PM_IL_COVER_DELEGATE delegate = new PM_IL_COVER_DELEGATE();
		this.setCOVER_TYPE_ITEMS(delegate.getSelectItems(
				"PM_IL_COVER.COVER_TYPE", "CTYPE"));
		// getting drop down values
		this.COVER_APP_ON_BASIC_RATE_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.COVER_APP_ON_BASIC_RATE", "YESNO");
		this.COVER_DISC_AGE_YN_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.COVER_DISC_AGE_YN", "YESNO");
		this.COVER_FUND_MTHD_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.COVER_FUND_MTHD", "IL_FUND_MTHD");
		this.COVER_FUND_RISK_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.COVER_FUND_RISK", "IL_ASSR_TYP");
		this.COVER_FUND_TYPE_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.COVER_FUND_TYPE", "FUNDTYPE");
		this.COVER_MIN_MAX_REQ_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.COVER_MIN_MAX_REQ", "YESNO");
		this.COVER_PREM_TYPE_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.COVER_PREM_TYPE", "IL_PRM_TYP");
		this.COVER_RATE_APPLIED_ON_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.COVER_RATE_APPLIED_ON", "IL_COV_RAT");
		this.COVER_SA_CALC_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.COVER_SA_CALC", "IL_COV_CAL");
		this.COVER_CLASS_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.COVER_CLASS", "IL_COV_CLASS");
		this.COVER_MEDICAL_YN_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.COVER_MEDICAL_YN", "YESNO");
		this.COVER_SURGICAL_YN_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.COVER_SURGICAL_YN", "YESNO");
		this.CREATE_BASIC_COVER_ITEMS = delegate.getSelectItems(
				"PM_IL_COVER.CREATE_BASIC_COVER", "YESNO");
		
		this.COVER_MIN_TYPE_ITEMS=delegate.getSelectItems(
				"PM_IL_COVER.COVER_MIN_TYPE", "Mintyp");
		
		this.COVER_MAX_TYPE_ITEMS=delegate.getSelectItems(
				"PM_IL_COVER.COVER_MAX_TYPE", "Maxtyp");
		
        /*Added by saritha on 15/12/2017*/ 
		this.COVER_FUNERAL_CVR_YN_ITEMS=delegate.getSelectItems(
				"PM_IL_COVER.COVER_FUNERAL_CVR_YN", "YESNO");
        
        /*End*/
		
		/*Added by Janani on 24.04.2018 for Fidelity money tree cover validation*/
		this.COVER_VALIDATE_YN_ITEMS=delegate.getSelectItems(
				"PM_IL_COVER.COVER_VALIDATE_YN", "YESNO");
		
		/*End*/
		
		
		// calling preform trigger
		preform();
		// instantiating all required components
		this.COMP_COVER_APP_ON_BASIC_RATE = new HtmlSelectOneMenu();
		this.COMP_COVER_RATE_APPLIED_ON = new HtmlSelectOneMenu();
		this.COMP_COVER_CLASS = new HtmlSelectOneMenu();
		this.COMP_COVER_SA_CALC = new HtmlSelectOneMenu();
		this.COMP_COVER_SA_PERC = new HtmlInputText();
		this.COMP_COVER_FUND_MTHD = new HtmlSelectOneMenu();
		this.COMP_COVER_FUND_RISK = new HtmlSelectOneMenu();
		this.COMP_COVER_VAR_VALUE = new HtmlInputText();
		this.COMP_COVER_CODE = new HtmlInputText();
		this.COMP_COVER_MIN_UNIT = new HtmlInputText();
		this.COMP_COVER_MAX_UNIT = new HtmlInputText();
		this.COMP_CREATE_BASIC_COVER = new HtmlSelectOneMenu();
		this.COMP_COVER_SA_BY_PARTS_TARR=new HtmlInputText();
        this.COMP_COVER_MIN_TYPE= new HtmlSelectOneMenu();
        this.COMP_COVER_MAX_TYPE= new HtmlSelectOneMenu();
        this.COMP_COVER_MIN_PERC=new HtmlInputText();
        this.COMP_COVER_MAX_PERC=new HtmlInputText();
        this.COMP_BILINGUAL_PANEL=new HtmlSimpleTogglePanel();
        this.COMP_COVER_LONG_DESC=new HtmlInputText();
        this.COMP_COVER_DESC = new HtmlInputText();
        
        /*Added by saritha on 15/12/2017*/ 
        this.COMP_COVER_FUNERAL_CVR_YN = new HtmlSelectOneMenu();
        /*End*/
        
        
		// this.COMP_COVER_SURGICAL_YN=new HtmlSelectOneMenu();
	}

	public boolean isInsertmode() {
		return isInsertmode;
	}

	public void setInsertmode(boolean isInsertmode) {
		this.isInsertmode = isInsertmode;
	}

	public HtmlOutputLabel getCOMP_COVER_BL_DESC_LABEL() {
		return COMP_COVER_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_COVER_BL_DESC() {
		return COMP_COVER_BL_DESC;
	}

	public void setCOMP_COVER_BL_DESC_LABEL(
			HtmlOutputLabel COMP_COVER_BL_DESC_LABEL) {
		this.COMP_COVER_BL_DESC_LABEL = COMP_COVER_BL_DESC_LABEL;
	}

	public void setCOMP_COVER_BL_DESC(HtmlInputText COMP_COVER_BL_DESC) {
		this.COMP_COVER_BL_DESC = COMP_COVER_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_COVER_BL_LONG_DESC_LABEL() {
		return COMP_COVER_BL_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_COVER_BL_LONG_DESC() {
		return COMP_COVER_BL_LONG_DESC;
	}

	public void setCOMP_COVER_BL_LONG_DESC_LABEL(
			HtmlOutputLabel COMP_COVER_BL_LONG_DESC_LABEL) {
		this.COMP_COVER_BL_LONG_DESC_LABEL = COMP_COVER_BL_LONG_DESC_LABEL;
	}

	public void setCOMP_COVER_BL_LONG_DESC(HtmlInputText COMP_COVER_BL_LONG_DESC) {
		this.COMP_COVER_BL_LONG_DESC = COMP_COVER_BL_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_COVER_FRZ_FLAG_LABEL() {
		return COMP_COVER_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_COVER_FRZ_FLAG() {
		return COMP_COVER_FRZ_FLAG;
	}

	public void setCOMP_COVER_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_COVER_FRZ_FLAG_LABEL) {
		this.COMP_COVER_FRZ_FLAG_LABEL = COMP_COVER_FRZ_FLAG_LABEL;
	}

	public void setCOMP_COVER_FRZ_FLAG(
			HtmlSelectBooleanCheckbox COMP_COVER_FRZ_FLAG) {
		this.COMP_COVER_FRZ_FLAG = COMP_COVER_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_COVER_CODE_LABEL() {
		return COMP_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_COVER_CODE() {
		return COMP_COVER_CODE;
	}

	public void setCOMP_COVER_CODE_LABEL(HtmlOutputLabel COMP_COVER_CODE_LABEL) {
		this.COMP_COVER_CODE_LABEL = COMP_COVER_CODE_LABEL;
	}

	public void setCOMP_COVER_CODE(HtmlInputText COMP_COVER_CODE) {
		this.COMP_COVER_CODE = COMP_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_COVER_DESC_LABEL() {
		return COMP_COVER_DESC_LABEL;
	}

	public void setCOMP_COVER_DESC_LABEL(HtmlOutputLabel COMP_COVER_DESC_LABEL) {
		this.COMP_COVER_DESC_LABEL = COMP_COVER_DESC_LABEL;
	}

	public HtmlOutputLabel getCOMP_COVER_LONG_DESC_LABEL() {
		return COMP_COVER_LONG_DESC_LABEL;
	}
	
	public void setCOMP_COVER_LONG_DESC_LABEL(
			HtmlOutputLabel COMP_COVER_LONG_DESC_LABEL) {
		this.COMP_COVER_LONG_DESC_LABEL = COMP_COVER_LONG_DESC_LABEL;
	}

	public HtmlOutputLabel getCOMP_COVER_TYPE_LABEL() {
		return COMP_COVER_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_TYPE() {
		return COMP_COVER_TYPE;
	}

	public void setCOMP_COVER_TYPE_LABEL(HtmlOutputLabel COMP_COVER_TYPE_LABEL) {
		this.COMP_COVER_TYPE_LABEL = COMP_COVER_TYPE_LABEL;
	}

	public void setCOMP_COVER_TYPE(HtmlSelectOneMenu COMP_COVER_TYPE) {
		this.COMP_COVER_TYPE = COMP_COVER_TYPE;
	}

	public HtmlOutputLabel getCOMP_COVER_APP_ON_BASIC_RATE_LABEL() {
		return COMP_COVER_APP_ON_BASIC_RATE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_APP_ON_BASIC_RATE() {
		return COMP_COVER_APP_ON_BASIC_RATE;
	}

	public void setCOMP_COVER_APP_ON_BASIC_RATE_LABEL(
			HtmlOutputLabel COMP_COVER_APP_ON_BASIC_RATE_LABEL) {
		this.COMP_COVER_APP_ON_BASIC_RATE_LABEL = COMP_COVER_APP_ON_BASIC_RATE_LABEL;
	}

	public void setCOMP_COVER_APP_ON_BASIC_RATE(
			HtmlSelectOneMenu COMP_COVER_APP_ON_BASIC_RATE) {
		this.COMP_COVER_APP_ON_BASIC_RATE = COMP_COVER_APP_ON_BASIC_RATE;
	}

	public HtmlOutputLabel getCOMP_COVER_DISC_AGE_YN_LABEL() {
		return COMP_COVER_DISC_AGE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_DISC_AGE_YN() {
		return COMP_COVER_DISC_AGE_YN;
	}

	public void setCOMP_COVER_DISC_AGE_YN_LABEL(
			HtmlOutputLabel COMP_COVER_DISC_AGE_YN_LABEL) {
		this.COMP_COVER_DISC_AGE_YN_LABEL = COMP_COVER_DISC_AGE_YN_LABEL;
	}

	public void setCOMP_COVER_DISC_AGE_YN(
			HtmlSelectOneMenu COMP_COVER_DISC_AGE_YN) {
		this.COMP_COVER_DISC_AGE_YN = COMP_COVER_DISC_AGE_YN;
	}

	public HtmlOutputLabel getCOMP_COVER_CLASS_LABEL() {
		return COMP_COVER_CLASS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_CLASS() {
		return COMP_COVER_CLASS;
	}

	public void setCOMP_COVER_CLASS_LABEL(HtmlOutputLabel COMP_COVER_CLASS_LABEL) {
		this.COMP_COVER_CLASS_LABEL = COMP_COVER_CLASS_LABEL;
	}

	public void setCOMP_COVER_CLASS(HtmlSelectOneMenu COMP_COVER_CLASS) {
		this.COMP_COVER_CLASS = COMP_COVER_CLASS;
	}

	public HtmlOutputLabel getCOMP_COVER_RATE_APPLIED_ON_LABEL() {
		return COMP_COVER_RATE_APPLIED_ON_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_RATE_APPLIED_ON() {
		return COMP_COVER_RATE_APPLIED_ON;
	}

	public void setCOMP_COVER_RATE_APPLIED_ON_LABEL(
			HtmlOutputLabel COMP_COVER_RATE_APPLIED_ON_LABEL) {
		this.COMP_COVER_RATE_APPLIED_ON_LABEL = COMP_COVER_RATE_APPLIED_ON_LABEL;
	}

	public void setCOMP_COVER_RATE_APPLIED_ON(
			HtmlSelectOneMenu COMP_COVER_RATE_APPLIED_ON) {
		this.COMP_COVER_RATE_APPLIED_ON = COMP_COVER_RATE_APPLIED_ON;
	}

	public HtmlOutputLabel getCOMP_COVER_SA_CALC_LABEL() {
		return COMP_COVER_SA_CALC_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_SA_CALC() {
		return COMP_COVER_SA_CALC;
	}

	public void setCOMP_COVER_SA_CALC_LABEL(
			HtmlOutputLabel COMP_COVER_SA_CALC_LABEL) {
		this.COMP_COVER_SA_CALC_LABEL = COMP_COVER_SA_CALC_LABEL;
	}

	public void setCOMP_COVER_SA_CALC(HtmlSelectOneMenu COMP_COVER_SA_CALC) {
		this.COMP_COVER_SA_CALC = COMP_COVER_SA_CALC;
	}

	public HtmlOutputLabel getCOMP_COVER_SA_PERC_LABEL() {
		return COMP_COVER_SA_PERC_LABEL;
	}

	public HtmlInputText getCOMP_COVER_SA_PERC() {
		return COMP_COVER_SA_PERC;
	}

	public void setCOMP_COVER_SA_PERC_LABEL(
			HtmlOutputLabel COMP_COVER_SA_PERC_LABEL) {
		this.COMP_COVER_SA_PERC_LABEL = COMP_COVER_SA_PERC_LABEL;
	}

	public void setCOMP_COVER_SA_PERC(HtmlInputText COMP_COVER_SA_PERC) {
		this.COMP_COVER_SA_PERC = COMP_COVER_SA_PERC;
	}

	public HtmlOutputLabel getCOMP_COVER_VAR_VALUE_LABEL() {
		return COMP_COVER_VAR_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_COVER_VAR_VALUE() {
		return COMP_COVER_VAR_VALUE;
	}

	public void setCOMP_COVER_VAR_VALUE_LABEL(
			HtmlOutputLabel COMP_COVER_VAR_VALUE_LABEL) {
		this.COMP_COVER_VAR_VALUE_LABEL = COMP_COVER_VAR_VALUE_LABEL;
	}

	public void setCOMP_COVER_VAR_VALUE(HtmlInputText COMP_COVER_VAR_VALUE) {
		this.COMP_COVER_VAR_VALUE = COMP_COVER_VAR_VALUE;
	}

	public HtmlOutputLabel getCOMP_COVER_PREM_TYPE_LABEL() {
		return COMP_COVER_PREM_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_PREM_TYPE() {
		return COMP_COVER_PREM_TYPE;
	}

	public void setCOMP_COVER_PREM_TYPE_LABEL(
			HtmlOutputLabel COMP_COVER_PREM_TYPE_LABEL) {
		this.COMP_COVER_PREM_TYPE_LABEL = COMP_COVER_PREM_TYPE_LABEL;
	}

	public void setCOMP_COVER_PREM_TYPE(HtmlSelectOneMenu COMP_COVER_PREM_TYPE) {
		this.COMP_COVER_PREM_TYPE = COMP_COVER_PREM_TYPE;
	}

	public HtmlOutputLabel getCOMP_COVER_MIN_SA_LABEL() {
		return COMP_COVER_MIN_SA_LABEL;
	}

	public HtmlInputText getCOMP_COVER_MIN_SA() {
		return COMP_COVER_MIN_SA;
	}

	public void setCOMP_COVER_MIN_SA_LABEL(
			HtmlOutputLabel COMP_COVER_MIN_SA_LABEL) {
		this.COMP_COVER_MIN_SA_LABEL = COMP_COVER_MIN_SA_LABEL;
	}

	public void setCOMP_COVER_MIN_SA(HtmlInputText COMP_COVER_MIN_SA) {
		this.COMP_COVER_MIN_SA = COMP_COVER_MIN_SA;
	}

	public HtmlOutputLabel getCOMP_COVER_MAX_SA_LABEL() {
		return COMP_COVER_MAX_SA_LABEL;
	}

	public HtmlInputText getCOMP_COVER_MAX_SA() {
		return COMP_COVER_MAX_SA;
	}

	public void setCOMP_COVER_MAX_SA_LABEL(
			HtmlOutputLabel COMP_COVER_MAX_SA_LABEL) {
		this.COMP_COVER_MAX_SA_LABEL = COMP_COVER_MAX_SA_LABEL;
	}

	public void setCOMP_COVER_MAX_SA(HtmlInputText COMP_COVER_MAX_SA) {
		this.COMP_COVER_MAX_SA = COMP_COVER_MAX_SA;
	}

	public HtmlOutputLabel getCOMP_COVER_FUND_TYPE_LABEL() {
		return COMP_COVER_FUND_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_FUND_TYPE() {
		return COMP_COVER_FUND_TYPE;
	}

	public void setCOMP_COVER_FUND_TYPE_LABEL(
			HtmlOutputLabel COMP_COVER_FUND_TYPE_LABEL) {
		this.COMP_COVER_FUND_TYPE_LABEL = COMP_COVER_FUND_TYPE_LABEL;
	}

	public void setCOMP_COVER_FUND_TYPE(HtmlSelectOneMenu COMP_COVER_FUND_TYPE) {
		this.COMP_COVER_FUND_TYPE = COMP_COVER_FUND_TYPE;
	}

	public HtmlOutputLabel getCOMP_COVER_FUND_MTHD_LABEL() {
		return COMP_COVER_FUND_MTHD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_FUND_MTHD() {
		return COMP_COVER_FUND_MTHD;
	}

	public void setCOMP_COVER_FUND_MTHD_LABEL(
			HtmlOutputLabel COMP_COVER_FUND_MTHD_LABEL) {
		this.COMP_COVER_FUND_MTHD_LABEL = COMP_COVER_FUND_MTHD_LABEL;
	}

	public void setCOMP_COVER_FUND_MTHD(HtmlSelectOneMenu COMP_COVER_FUND_MTHD) {
		this.COMP_COVER_FUND_MTHD = COMP_COVER_FUND_MTHD;
	}

	public HtmlOutputLabel getCOMP_COVER_FUND_RISK_LABEL() {
		return COMP_COVER_FUND_RISK_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_FUND_RISK() {
		return COMP_COVER_FUND_RISK;
	}

	public void setCOMP_COVER_FUND_RISK_LABEL(
			HtmlOutputLabel COMP_COVER_FUND_RISK_LABEL) {
		this.COMP_COVER_FUND_RISK_LABEL = COMP_COVER_FUND_RISK_LABEL;
	}

	public void setCOMP_COVER_FUND_RISK(HtmlSelectOneMenu COMP_COVER_FUND_RISK) {
		this.COMP_COVER_FUND_RISK = COMP_COVER_FUND_RISK;
	}

	public HtmlOutputLabel getCOMP_COVER_EFF_FM_DT_LABEL() {
		return COMP_COVER_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_COVER_EFF_FM_DT() {
		return COMP_COVER_EFF_FM_DT;
	}

	public void setCOMP_COVER_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_COVER_EFF_FM_DT_LABEL) {
		this.COMP_COVER_EFF_FM_DT_LABEL = COMP_COVER_EFF_FM_DT_LABEL;
	}

	public void setCOMP_COVER_EFF_FM_DT(HtmlCalendar COMP_COVER_EFF_FM_DT) {
		this.COMP_COVER_EFF_FM_DT = COMP_COVER_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_COVER_EFF_TO_DT_LABEL() {
		return COMP_COVER_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_COVER_EFF_TO_DT() {
		return COMP_COVER_EFF_TO_DT;
	}

	public void setCOMP_COVER_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_COVER_EFF_TO_DT_LABEL) {
		this.COMP_COVER_EFF_TO_DT_LABEL = COMP_COVER_EFF_TO_DT_LABEL;
	}

	public void setCOMP_COVER_EFF_TO_DT(HtmlCalendar COMP_COVER_EFF_TO_DT) {
		this.COMP_COVER_EFF_TO_DT = COMP_COVER_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_COVER_MAX_UNIT_LABEL() {
		return COMP_COVER_MAX_UNIT_LABEL;
	}

	public HtmlInputText getCOMP_COVER_MAX_UNIT() {
		return COMP_COVER_MAX_UNIT;
	}

	public void setCOMP_COVER_MAX_UNIT_LABEL(
			HtmlOutputLabel COMP_COVER_MAX_UNIT_LABEL) {
		this.COMP_COVER_MAX_UNIT_LABEL = COMP_COVER_MAX_UNIT_LABEL;
	}

	public void setCOMP_COVER_MAX_UNIT(HtmlInputText COMP_COVER_MAX_UNIT) {
		this.COMP_COVER_MAX_UNIT = COMP_COVER_MAX_UNIT;
	}

	public HtmlOutputLabel getCOMP_COVER_MIN_UNIT_LABEL() {
		return COMP_COVER_MIN_UNIT_LABEL;
	}

	public HtmlInputText getCOMP_COVER_MIN_UNIT() {
		return COMP_COVER_MIN_UNIT;
	}

	public void setCOMP_COVER_MIN_UNIT_LABEL(
			HtmlOutputLabel COMP_COVER_MIN_UNIT_LABEL) {
		this.COMP_COVER_MIN_UNIT_LABEL = COMP_COVER_MIN_UNIT_LABEL;
	}

	public void setCOMP_COVER_MIN_UNIT(HtmlInputText COMP_COVER_MIN_UNIT) {
		this.COMP_COVER_MIN_UNIT = COMP_COVER_MIN_UNIT;
	}

	public HtmlOutputLabel getCOMP_COVER_SA_MULTIPLE_LABEL() {
		return COMP_COVER_SA_MULTIPLE_LABEL;
	}

	public HtmlInputText getCOMP_COVER_SA_MULTIPLE() {
		return COMP_COVER_SA_MULTIPLE;
	}

	public void setCOMP_COVER_SA_MULTIPLE_LABEL(
			HtmlOutputLabel COMP_COVER_SA_MULTIPLE_LABEL) {
		this.COMP_COVER_SA_MULTIPLE_LABEL = COMP_COVER_SA_MULTIPLE_LABEL;
	}

	public void setCOMP_COVER_SA_MULTIPLE(HtmlInputText COMP_COVER_SA_MULTIPLE) {
		this.COMP_COVER_SA_MULTIPLE = COMP_COVER_SA_MULTIPLE;
	}

	public HtmlOutputLabel getCOMP_COVER_MIN_MAX_REQ_LABEL() {
		return COMP_COVER_MIN_MAX_REQ_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_MIN_MAX_REQ() {
		return COMP_COVER_MIN_MAX_REQ;
	}

	public void setCOMP_COVER_MIN_MAX_REQ_LABEL(
			HtmlOutputLabel COMP_COVER_MIN_MAX_REQ_LABEL) {
		this.COMP_COVER_MIN_MAX_REQ_LABEL = COMP_COVER_MIN_MAX_REQ_LABEL;
	}

	public void setCOMP_COVER_MIN_MAX_REQ(
			HtmlSelectOneMenu COMP_COVER_MIN_MAX_REQ) {
		this.COMP_COVER_MIN_MAX_REQ = COMP_COVER_MIN_MAX_REQ;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDITOR_LONG_DESC() {
		return COMP_UI_M_BUT_EDITOR_LONG_DESC;
	}

	public void setCOMP_UI_M_BUT_EDITOR_LONG_DESC(
			HtmlCommandButton COMP_UI_M_BUT_EDITOR_LONG_DESC) {
		this.COMP_UI_M_BUT_EDITOR_LONG_DESC = COMP_UI_M_BUT_EDITOR_LONG_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BILINGUAL() {
		return COMP_UI_M_BUT_BILINGUAL;
	}

	public void setCOMP_UI_M_BUT_BILINGUAL(
			HtmlCommandButton COMP_UI_M_BUT_BILINGUAL) {
		this.COMP_UI_M_BUT_BILINGUAL = COMP_UI_M_BUT_BILINGUAL;
	}

	public PM_IL_COVER getPM_IL_COVER_BEAN() {
		return PM_IL_COVER_BEAN;
	}

	public void setPM_IL_COVER_BEAN(PM_IL_COVER PM_IL_COVER_BEAN) {
		this.PM_IL_COVER_BEAN = PM_IL_COVER_BEAN;
	}

	public List<SelectItem> getCOVER_TYPE_ITEMS() {
		return COVER_TYPE_ITEMS;
	}

	public void setCOVER_TYPE_ITEMS(List<SelectItem> cover_type_items) {
		COVER_TYPE_ITEMS = cover_type_items;
	}

	public List<SelectItem> getCOVER_APP_ON_BASIC_RATE_ITEMS() {
		return COVER_APP_ON_BASIC_RATE_ITEMS;
	}

	public void setCOVER_APP_ON_BASIC_RATE_ITEMS(
			List<SelectItem> cover_app_on_basic_rate_items) {
		COVER_APP_ON_BASIC_RATE_ITEMS = cover_app_on_basic_rate_items;
	}

	public List<SelectItem> getCOVER_CLASS_ITEMS() {
		return COVER_CLASS_ITEMS;
	}

	public void setCOVER_CLASS_ITEMS(List<SelectItem> cover_class_items) {
		COVER_CLASS_ITEMS = cover_class_items;
	}

	public List<SelectItem> getCOVER_SA_CALC_ITEMS() {
		return COVER_SA_CALC_ITEMS;
	}

	public void setCOVER_SA_CALC_ITEMS(List<SelectItem> cover_sa_calc_items) {
		COVER_SA_CALC_ITEMS = cover_sa_calc_items;
	}

	public List<SelectItem> getCOVER_DISC_AGE_YN_ITEMS() {
		return COVER_DISC_AGE_YN_ITEMS;
	}

	public void setCOVER_DISC_AGE_YN_ITEMS(
			List<SelectItem> cover_disc_age_yn_items) {
		COVER_DISC_AGE_YN_ITEMS = cover_disc_age_yn_items;
	}

	public List<SelectItem> getCOVER_RATE_APPLIED_ON_ITEMS() {
		return COVER_RATE_APPLIED_ON_ITEMS;
	}

	public void setCOVER_RATE_APPLIED_ON_ITEMS(
			List<SelectItem> cover_rate_applied_on_items) {
		COVER_RATE_APPLIED_ON_ITEMS = cover_rate_applied_on_items;
	}

	public List<SelectItem> getCOVER_PREM_TYPE_ITEMS() {
		return COVER_PREM_TYPE_ITEMS;
	}

	public void setCOVER_PREM_TYPE_ITEMS(List<SelectItem> cover_prem_type_items) {
		COVER_PREM_TYPE_ITEMS = cover_prem_type_items;
	}

	public List<SelectItem> getCOVER_FUND_TYPE_ITEMS() {
		return COVER_FUND_TYPE_ITEMS;
	}

	public void setCOVER_FUND_TYPE_ITEMS(List<SelectItem> cover_fund_type_items) {
		COVER_FUND_TYPE_ITEMS = cover_fund_type_items;
	}

	public List<SelectItem> getCOVER_FUND_MTHD_ITEMS() {
		return COVER_FUND_MTHD_ITEMS;
	}

	public void setCOVER_FUND_MTHD_ITEMS(List<SelectItem> cover_fund_mthd_items) {
		COVER_FUND_MTHD_ITEMS = cover_fund_mthd_items;
	}

	public List<SelectItem> getCOVER_FUND_RISK_ITEMS() {
		return COVER_FUND_RISK_ITEMS;
	}

	public void setCOVER_FUND_RISK_ITEMS(List<SelectItem> cover_fund_risk_items) {
		COVER_FUND_RISK_ITEMS = cover_fund_risk_items;
	}

	public List<SelectItem> getCOVER_MIN_MAX_REQ_ITEMS() {
		return COVER_MIN_MAX_REQ_ITEMS;
	}

	public void setCOVER_MIN_MAX_REQ_ITEMS(
			List<SelectItem> cover_min_max_req_items) {
		COVER_MIN_MAX_REQ_ITEMS = cover_min_max_req_items;
	}

	public HtmlOutputLabel getCOMP_COVER_MEDICAL_YN_LABEL() {
		return COMP_COVER_MEDICAL_YN_LABEL;
	}

	public void setCOMP_COVER_MEDICAL_YN_LABEL(
			HtmlOutputLabel comp_cover_medical_yn_label) {
		COMP_COVER_MEDICAL_YN_LABEL = comp_cover_medical_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_COVER_MEDICAL_YN() {
		return COMP_COVER_MEDICAL_YN;
	}

	public void setCOMP_COVER_MEDICAL_YN(HtmlSelectOneMenu comp_cover_medical_yn) {
		COMP_COVER_MEDICAL_YN = comp_cover_medical_yn;
	}

	

	public List<SelectItem> getCOVER_MEDICAL_YN_ITEMS() {
		return COVER_MEDICAL_YN_ITEMS;
	}

	public void setCOVER_MEDICAL_YN_ITEMS(
			List<SelectItem> cover_medical_yn_items) {
		COVER_MEDICAL_YN_ITEMS = cover_medical_yn_items;
	}

	public List<SelectItem> getCOVER_SURGICAL_YN_ITEMS() {
		return COVER_SURGICAL_YN_ITEMS;
	}

	public void setCOVER_SURGICAL_YN_ITEMS(
			List<SelectItem> cover_surgical_yn_items) {
		COVER_SURGICAL_YN_ITEMS = cover_surgical_yn_items;
	}

	PM_IL_COVER_HELPER helper = new PM_IL_COVER_HELPER();

	/**
	 * Called when save button is clicked. Method checks if rowid is present in
	 * value bean if rowid is null it will call PRE-INSERT trigger method else
	 * it will call PRE-UPDATE trigger method before saving the record
	 * 
	 * @param event
	 * @return
	 * @throws
	 */
	public String saveButtonClick() {
		CRUDHandler handler = new CRUDHandler();
		try {
			if (this.PM_IL_COVER_BEAN.getROWID() == null && this.isINSERT_ALLOWED() == true) {

				helper.preInsertPM_IL_COVER(getPM_IL_COVER_BEAN());
				handler.executeInsert(getPM_IL_COVER_BEAN(), CommonUtils.getConnection());
				helper.postInsertPM_IL_COVER(getPM_IL_COVER_BEAN());
				CommonUtils.doComitt();
				getWarningMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			} else {
				helper.preUpdatePM_IL_COVER(this);
				System.out.println("after    executeDeleteStatement method------>");
				handler.executeUpdate(getPM_IL_COVER_BEAN(), CommonUtils
						.getConnection());
				System.out.println("after    executeUpdate method------>");
				CommonUtils.doComitt();
				System.out.println("after   commit----->");
				getWarningMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			} 
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());

		}

		return "";
	}


	/**
	 * Called when delete button is clicked. This method will call
	 * ON-CHECK-DELETE-MASTER trigger before deleting the record
	 * 
	 * @param event
	 * @return
	 * @throws
	 */
	public void deleteButtonClick(ActionEvent event) {
		// calling ON-CHECK-DELETE-MASTER trigger

		try {
			helper.onCheckDeleteMasterPM_IL_COVER(PM_IL_COVER_BEAN);
			 new CRUDHandler().executeDelete(getPM_IL_COVER_BEAN(),CommonUtils.getConnection());
			this.getWarningMap().clear();
			
			this.getWarningMap().put("Delete", PELConstants.PEL_ERROR_WARNING_CURRENT_KEY);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public String nextPageButtonClick() {
		String returnString = "";
		String mappedBeanName = "PILM002_APAC_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean = (PILM002_APAC_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		PM_IL_COVER_DELEGATE delegate = new PM_IL_COVER_DELEGATE();
		// delegate.saveRecord(this.PM_IL_COVER_BEAN,false);
		populateBlockPM_IL_APPL_WOP_COVER();
		// calling WHEN-NEW-BLOCK-INSTANCE for the next block
		compositeActionBean.getPM_IL_APPL_WOP_COVER_ACTION_BEAN()
				.whenNewBlockInstanceForPM_IL_APPL_WOP_COVER();
		returnString = "GO_TO_PILM002_APAC_PM_IL_APPL_WOP_COVER";
		return returnString;
	}

	public void populateBlockPM_IL_APPL_WOP_COVER() {
		// get details from database for the block
		PM_IL_COVER_DELEGATE delegate = new PM_IL_COVER_DELEGATE();
		List dataList = new ArrayList<PM_IL_APPL_WOP_COVER>();
		// Querying details to be populated
		dataList = delegate.getBlockDataForPM_IL_APPL_WOP_COVER(compositeAction);
		System.out.println("size of list-------------" + dataList.size());
		// Calling POST-QUERY trigger to set the description field for the next
		// block
		System.out.println("CAlling post query");
		compositeAction.getPM_IL_APPL_WOP_COVER_ACTION_BEAN()
				.postQueryPM_IL_APPL_WOP_COVER();
		System.out.println("size of list-------------" + dataList.size());

		// Populate the block
		compositeAction.getPM_IL_APPL_WOP_COVER_ACTION_BEAN()
				.setRecordList(dataList);

		// calling post query trigger
		compositeAction.getPM_IL_APPL_WOP_COVER_ACTION_BEAN()
				.postQueryPM_IL_APPL_WOP_COVER();
	}

	public boolean deleteBlockPM_IL_APPL_WOP_COVER() {
		boolean isdeleted = false;
		PM_IL_COVER_DELEGATE delegate = new PM_IL_COVER_DELEGATE();
		isdeleted = delegate.deleteRecordPM_IL_APPL_WOP_COVER(false);
		return isdeleted;
	}

	public boolean deleteBlockPM_IL_CVR_WAITING_PRD() {
		boolean isdeleted = false;
		PM_IL_COVER_DELEGATE delegate = new PM_IL_COVER_DELEGATE();
		isdeleted = delegate.deleteRecordPM_IL_CVR_WAITING_PRD(false);
		return isdeleted;
	}

	public void preform() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(true);
		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
	}

	
	public void onLoad(PhaseEvent event){
		PM_IL_COVER_DELEGATE delegate = new PM_IL_COVER_DELEGATE();
		try {
			if(isBlockFlag()){
				helper.whenNewBlockInstanceForPM_IL_COVER(this);
				delegate.executeStatement(this);
				if(PM_IL_COVER_BEAN.getROWID() != null){
					COMP_COVER_CODE.setDisabled(true);
					helper.postQueryPM_IL_COVER(this);
				}else{
					helper.when_create_record(PM_IL_COVER_BEAN);
				}
				setBlockFlag(false);
			}
			helper.whenNewRecordInstanceForPM_IL_COVER(compositeAction);
			helper.validateFundrisk(this);
			//added by saranya for Cover SA % ssp call id is FALCONQC-1716238
			if("B".equalsIgnoreCase(PM_IL_COVER_BEAN.getCOVER_TYPE()))
			{
				System.out.println("Enter into cover type val inside if");
				PM_IL_COVER_BEAN.setCOVER_SA_PERC(100.00);
				COMP_COVER_SA_PERC.resetValue();
				System.out.println(PM_IL_COVER_BEAN.getCOVER_SA_PERC());
			}
			if("N".equalsIgnoreCase(PM_IL_COVER_BEAN.getCOVER_SA_CALC()))
			{
				PM_IL_COVER_BEAN.setCOVER_SA_PERC(null);
				COMP_COVER_SA_PERC.resetValue();
			}
			System.out.println("value of cover SA onload------->"+PM_IL_COVER_BEAN.getCOVER_SA_CALC()  + PM_IL_COVER_BEAN.getCOVER_TYPE());
			if("S".equalsIgnoreCase(PM_IL_COVER_BEAN.getCOVER_SA_CALC())&&("A".equalsIgnoreCase(PM_IL_COVER_BEAN.getCOVER_TYPE())))
			{
				System.out.println("entered into if condition");
				COMP_COVER_SA_PERC.setDisabled(false);
				COMP_COVER_SA_PERC.setRequired(true);
			}
			else
			{
				System.out.println("entered into else condition");
				COMP_COVER_SA_PERC.setDisabled(true);
				COMP_COVER_SA_PERC.setRequired(false);
			}
			//end
			
			 if("I".equalsIgnoreCase(PM_IL_COVER_BEAN.getCOVER_SA_CALC())){
				 COMP_COVER_SA_FIXED.setRequired(true);
				 COMP_COVER_SA_FIXED.setDisabled(false);
				
			}else{
				COMP_COVER_SA_FIXED.setRequired(false);	
				COMP_COVER_SA_FIXED.setDisabled(true);
				COMP_COVER_SA_FIXED.setSubmittedValue(null);
				COMP_COVER_SA_FIXED.setValue(null);
				PM_IL_COVER_BEAN.setCOVER_SA_FIXED(null);
			}
			
			
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void validateCOVER_CODE(FacesContext context, UIComponent component,
			Object value) {
		String value1 = (String) value;
		try {
			PM_IL_COVER_BEAN.setCOVER_CODE(value1);
			helper.whenValidateItemCOVER_CODE(PM_IL_COVER_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCOVER_DESC(FacesContext context, UIComponent component,
			Object value) {
		String value1 = (String) value;
		try{
			PM_IL_COVER_BEAN.setCOVER_DESC(value1);
			//commanted by gopi
			//COMP_COVER_LONG_DESC.setSubmittedValue(value1);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void whenListChangedCOVER_TYPE(ActionEvent event) {
		try {
			UIInput input = (UIInput) event.getComponent().getParent();
			String inputData = input.getSubmittedValue().toString();
			PM_IL_COVER_BEAN.setCOVER_TYPE(inputData);
			helper.whenListChangedCOVER_TYPE(compositeAction);
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
	}

	public void validateCOVER_CLASS(FacesContext context,UIComponent component, Object value) {

		try {
			PM_IL_COVER_BEAN.setCOVER_CLASS((String) value);
			helper.whenValidateItemCOVER_CLASS(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateCOVER_TYPE(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("Enter into cover type val ");
			PM_IL_COVER_BEAN.setCOVER_TYPE((String) value);
			//added by saranya for cover master issue
			if("B".equalsIgnoreCase(PM_IL_COVER_BEAN.getCOVER_TYPE()))
			{
				System.out.println("Enter into cover type val inside if");
				PM_IL_COVER_BEAN.setCOVER_SA_PERC(100.00);
				COMP_COVER_SA_PERC.resetValue();
				System.out.println(PM_IL_COVER_BEAN.getCOVER_SA_PERC());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		}
	public void validateCOVER_APP_ON_BASIC_RATE(FacesContext context,UIComponent component, Object value) {
		try {
			System.out.println("Entered into COVER_APP_ON_BASIC_RATE ");
			PM_IL_COVER_BEAN.setCOVER_APP_ON_BASIC_RATE((String) value);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	public void validateCOVER_SA_CALC(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_COVER_BEAN.setCOVER_SA_CALC((String) value);
			 if("D".equalsIgnoreCase(PM_IL_COVER_BEAN.getCOVER_SA_CALC())){
				 String message = "Cover SA Type:Dynamic is applicable only for Annuity products";
				 compositeAction.getPM_IL_COVER_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,  message);

			 }
			helper.whenValidateItemCOVER_SA_CALC(this);	
			//added by saranya for Cover SA % ssp call id is FALCONQC-1716238
			helper.whenValidateItem(this);
			//end
			COMP_COVER_MAX_TYPE.resetValue();
			COMP_COVER_MIN_TYPE.resetValue();
			COMP_COVER_PREM_TYPE.resetValue();
			COMP_COVER_VAR_VALUE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCOVER_SA_PERC(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_COVER_BEAN.setCOVER_SA_PERC((Double) value);
			helper.whenValidateItemCOVER_SA_PERC(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCOVER_VAR_VALUE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_COVER_BEAN.setCOVER_VAR_VALUE((Double) value);
			helper.whenValidateItemCOVER_VAR_VALUE(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCOVER_MIN_SA(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_COVER_BEAN.setCOVER_MIN_SA((Double) value);
			//added by saranya for Cover SA % ssp call id is FALCONQC-1716238	//added by saranya
			 if (!("N".equals(PM_IL_COVER_BEAN.getCOVER_MIN_TYPE())))
			 {
			   helper.whenValidateItemCOVER_MIN_SA(this);
			 }
			 //end
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*added by gopi for toi on 24/05/18*/
	public void validateCOVER_SA_FIXED(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_COVER_BEAN.setCOVER_SA_FIXED((Double) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*end*/
	
	
	public void validateCOVER_MAX_SA(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_COVER_BEAN.setCOVER_MAX_SA((Double) value);
			//added by saranya for Cover SA % ssp call id is FALCONQC-1716238
			if (!("N".equals(PM_IL_COVER_BEAN.getCOVER_MAX_TYPE())))
			 {
				helper.whenValidateItemCOVER_MAX_SA(this);
			 }
			//end
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCOVER_FUND_TYPE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_COVER_BEAN.setCOVER_FUND_TYPE((String) value);
			helper.whenValidateItemCOVER_FUND_TYPE(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCOVER_FUND_MTHD(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_COVER_BEAN.setCOVER_FUND_MTHD((String) value);
			helper.whenValidateItemCOVER_FUND_MTHD(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCOVER_EFF_FM_DT(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_COVER_BEAN.setCOVER_EFF_FM_DT((Date) value);
			helper.whenValidateItemCOVER_EFF_FM_DT(PM_IL_COVER_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/*added by gopi for cover code long description issue on 21/11/17 */
	public void fireFieldValidation_COVER_DESC(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = input.getSubmittedValue().toString();
		PM_IL_COVER_BEAN.setCOVER_LONG_DESC((String) value);
		COMP_COVER_LONG_DESC.resetValue();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	//end
	
	
	
	public void validateCOVER_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_COVER_BEAN.setCOVER_EFF_TO_DT((Date) value);
			helper.whenValidateItemCOVER_EFF_TO_DT(getPM_IL_COVER_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * This method is called on blur. This method will call the validate method
	 * in ErrorHelpUtil class which internally calls validator method applied on
	 * COVER_MIN_UNIT field
	 * 
	 * @param event
	 * @return
	 * @throws
	 */
	public void whenValidateItemCOVER_MIN_UNIT(ActionEvent event) {
		UIInput coverMinUnitInputComp = (UIInput) (event.getComponent()
				.getParent());
		ErrorHelpUtil.validate(coverMinUnitInputComp, getErrorMap());
		System.out
				.println("*******calling validator for COVER_MIN_UNIT on blur ends************");
	}

	/**
	 * Validator method for validating field COVER_MIN_UNIT
	 * 
	 * @param FacesContext
	 *            context
	 * @param UIComponent
	 *            component
	 * @param Object
	 *            value
	 * @return
	 * @throws
	 */
	public void validateCOVER_MIN_UNIT(FacesContext context,
			UIComponent component, Object value) {
		try {
			this.getPM_IL_COVER_BEAN().setCOVER_MIN_UNIT((Double) value);
			helper.whenValidateItemCOVER_MIN_UNIT(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * This method is called on blur. This method will call the validate method
	 * in ErrorHelpUtil class which internally calls validator method applied on
	 * COVER_MAX_UNIT field
	 * 
	 * @param event
	 * @return
	 * @throws
	 */
	public void whenValidateItemCOVER_MAX_UNIT(ActionEvent event) {
		UIInput coverMaxUnitInputComp = (UIInput) (event.getComponent()
				.getParent());
		ErrorHelpUtil.validate(coverMaxUnitInputComp, getErrorMap());
		System.out
				.println("*******calling validator for COVER_MAX_UNIT on blur ends************");
	}

	/**
	 * Validator method for validating field COVER_MAX_UNIT
	 * 
	 * @param FacesContext
	 *            context
	 * @param UIComponent
	 *            component
	 * @param Object
	 *            value
	 * @return
	 * @throws
	 */
	public void validateCOVER_MAX_UNIT(FacesContext context,
			UIComponent component, Object value) {
		try {
			this.getPM_IL_COVER_BEAN().setCOVER_MAX_UNIT((Double) value);
			helper.whenValidateItemCOVER_MAX_UNIT(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * This method is called on blur. This method will call the validate method
	 * in ErrorHelpUtil class which internally calls validator method applied on
	 * COVER_SA_MULTIPLE field
	 * 
	 * @param event
	 * @return
	 * @throws
	 */
	public void whenValidateItemCOVER_SA_MULTIPLE(ActionEvent event) {
		UIInput coverSAMultipleInputComp = (UIInput) (event.getComponent()
				.getParent());
		ErrorHelpUtil.validate(coverSAMultipleInputComp, getErrorMap());
		System.out
				.println("*******calling validator for COVER_SA_MULTIPLE on blur ends************");
	}

	/**
	 * Validator method for validating field COVER_SA_MULTIPLE
	 * 
	 * @param FacesContext
	 *            context
	 * @param UIComponent
	 *            component
	 * @param Object
	 *            value
	 * @return
	 * @throws
	 */
	public void validateCOVER_SA_MULTIPLE(FacesContext context,
			UIComponent component, Object value) {
		try {
			this.getPM_IL_COVER_BEAN().setCOVER_SA_MULTIPLE((Double) value);
			helper.whenValidateItemCOVER_SA_MULTIPLE(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public HtmlSelectOneMenu getCOMP_CREATE_BASIC_COVER() {
		return COMP_CREATE_BASIC_COVER;
	}

	public void setCOMP_CREATE_BASIC_COVER(
			HtmlSelectOneMenu comp_create_basic_cover) {
		COMP_CREATE_BASIC_COVER = comp_create_basic_cover;
	}

	public HtmlOutputLabel getCOMP_CREATE_BASIC_COVER_LABEL() {
		return COMP_CREATE_BASIC_COVER_LABEL;
	}

	public void setCOMP_CREATE_BASIC_COVER_LABEL(
			HtmlOutputLabel comp_create_basic_cover_label) {
		COMP_CREATE_BASIC_COVER_LABEL = comp_create_basic_cover_label;
	}

	public List<SelectItem> getCREATE_BASIC_COVER_ITEMS() {
		return CREATE_BASIC_COVER_ITEMS;
	}

	public void setCREATE_BASIC_COVER_ITEMS(
			List<SelectItem> create_basic_cover_items) {
		CREATE_BASIC_COVER_ITEMS = create_basic_cover_items;
	}

	public HtmlOutputLabel getCOMP_COVER_SA_BY_PARTS_TARR_LABEL() {
		return COMP_COVER_SA_BY_PARTS_TARR_LABEL;
	}

	public void setCOMP_COVER_SA_BY_PARTS_TARR_LABEL(
			HtmlOutputLabel comp_cover_sa_by_parts_tarr_label) {
		COMP_COVER_SA_BY_PARTS_TARR_LABEL = comp_cover_sa_by_parts_tarr_label;
	}

	public HtmlInputText getCOMP_COVER_SA_BY_PARTS_TARR() {
		return COMP_COVER_SA_BY_PARTS_TARR;
	}

	public void setCOMP_COVER_SA_BY_PARTS_TARR(
			HtmlInputText comp_cover_sa_by_parts_tarr) {
		COMP_COVER_SA_BY_PARTS_TARR = comp_cover_sa_by_parts_tarr;
	}

	public HtmlOutputLabel getCOMP_COVER_MIN_TYPE_LABEL() {
		return COMP_COVER_MIN_TYPE_LABEL;
	}

	public void setCOMP_COVER_MIN_TYPE_LABEL(
			HtmlOutputLabel comp_cover_min_type_label) {
		COMP_COVER_MIN_TYPE_LABEL = comp_cover_min_type_label;
	}

	public HtmlSelectOneMenu getCOMP_COVER_MIN_TYPE() {
		return COMP_COVER_MIN_TYPE;
	}

	public void setCOMP_COVER_MIN_TYPE(HtmlSelectOneMenu comp_cover_min_type) {
		COMP_COVER_MIN_TYPE = comp_cover_min_type;
	}

	public HtmlOutputLabel getCOMP_COVER_MAX_TYPE_LABEL() {
		return COMP_COVER_MAX_TYPE_LABEL;
	}

	public void setCOMP_COVER_MAX_TYPE_LABEL(
			HtmlOutputLabel comp_cover_max_type_label) {
		COMP_COVER_MAX_TYPE_LABEL = comp_cover_max_type_label;
	}

	public HtmlSelectOneMenu getCOMP_COVER_MAX_TYPE() {
		return COMP_COVER_MAX_TYPE;
	}

	public void setCOMP_COVER_MAX_TYPE(HtmlSelectOneMenu comp_cover_max_type) {
		COMP_COVER_MAX_TYPE = comp_cover_max_type;
	}

	public List<SelectItem> getCOVER_MIN_TYPE_ITEMS() {
		return COVER_MIN_TYPE_ITEMS;
	}

	public void setCOVER_MIN_TYPE_ITEMS(List<SelectItem> cover_min_type_items) {
		COVER_MIN_TYPE_ITEMS = cover_min_type_items;
	}

	public List<SelectItem> getCOVER_MAX_TYPE_ITEMS() {
		return COVER_MAX_TYPE_ITEMS;
	}

	public void setCOVER_MAX_TYPE_ITEMS(List<SelectItem> cover_max_type_items) {
		COVER_MAX_TYPE_ITEMS = cover_max_type_items;
	}

	public HtmlOutputLabel getCOMP_COVER_MIN_PERC_LABEL() {
		return COMP_COVER_MIN_PERC_LABEL;
	}

	public void setCOMP_COVER_MIN_PERC_LABEL(
			HtmlOutputLabel comp_cover_min_perc_label) {
		COMP_COVER_MIN_PERC_LABEL = comp_cover_min_perc_label;
	}

	public HtmlInputText getCOMP_COVER_MIN_PERC() {
		return COMP_COVER_MIN_PERC;
	}

	public void setCOMP_COVER_MIN_PERC(HtmlInputText comp_cover_min_perc) {
		COMP_COVER_MIN_PERC = comp_cover_min_perc;
	}

	public HtmlOutputLabel getCOMP_COVER_MAX_PERC_LABEL() {
		return COMP_COVER_MAX_PERC_LABEL;
	}

	public void setCOMP_COVER_MAX_PERC_LABEL(
			HtmlOutputLabel comp_cover_max_perc_label) {
		COMP_COVER_MAX_PERC_LABEL = comp_cover_max_perc_label;
	}

	public HtmlInputText getCOMP_COVER_MAX_PERC() {
		return COMP_COVER_MAX_PERC;
	}

	public void setCOMP_COVER_MAX_PERC(HtmlInputText comp_cover_max_perc) {
		COMP_COVER_MAX_PERC = comp_cover_max_perc;
	}

	public HtmlSimpleTogglePanel getCOMP_BILINGUAL_PANEL() {
		return COMP_BILINGUAL_PANEL;
	}

	public void setCOMP_BILINGUAL_PANEL(HtmlSimpleTogglePanel comp_bilingual_panel) {
		COMP_BILINGUAL_PANEL = comp_bilingual_panel;
	}

	public HtmlInputText getCOMP_COVER_DESC() {
		return COMP_COVER_DESC;
	}

	public void setCOMP_COVER_DESC(HtmlInputText comp_cover_desc) {
		COMP_COVER_DESC = comp_cover_desc;
	}

	public HtmlInputText getCOMP_COVER_LONG_DESC() {
		return COMP_COVER_LONG_DESC;
	}

	public void setCOMP_COVER_LONG_DESC(HtmlInputText comp_cover_long_desc) {
		COMP_COVER_LONG_DESC = comp_cover_long_desc;
	}
	
	 public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
	 
	 
	 
	 public void validateCOVER_MAX_TYPE(FacesContext context,UIComponent component, Object object) {
		 CommonUtils.clearMaps(this);
		 PM_IL_COVER_BEAN.setCOVER_MAX_TYPE((String)object);
		 try {
			 helper.validateCOVER_MAX_TYPE(this);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	 }

	 public void validateCOVER_MIN_TYPE(FacesContext context,UIComponent component, Object object) {
		 CommonUtils.clearMaps(this);
		 PM_IL_COVER_BEAN.setCOVER_MIN_TYPE((String)object);
		 try {
			 helper.validateCOVER_MIN_TYPE(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	 }
	 
	 public void validateCOVER_MAX_PERC(FacesContext context,UIComponent component,Object object) {
		 PM_IL_COVER_BEAN.setCOVER_MAX_PERC((Double)object);
		 try {
			helper.validateCOVER_MAX_PERC(PM_IL_COVER_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	 }
	 
	 
	 public void validateCOVER_MIN_PERC(FacesContext context,UIComponent component,Object object) {
		 PM_IL_COVER_BEAN.setCOVER_MIN_PERC((Double)object);
		 try {
			helper.validateCOVER_MIN_PERC(PM_IL_COVER_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	 }
	 public ArrayList<LovBean> lovCOVER_SA_BY_PARTS_TARR(Object currValue) {
			String code = (String) currValue;
			ArrayList<LovBean> suggestionList = null;
			Object[] object = {};
			String query = null;
			try {
				if ("*".equals(code)) {
					object = new Object[] { PELConstants.suggetionRecordSize };
					query = "SELECT TH_CODE,TH_DESC FROM PM_IL_TAR_HDR WHERE TH_PARAM_TYPE='V'AND ROWNUM <=?";
				} else {
					object = new Object[] { code + "%",
							
							PELConstants.suggetionRecordSize };
					query =  "SELECT TH_CODE,TH_DESC FROM PM_IL_TAR_HDR WHERE TH_PARAM_TYPE='V'AND TH_CODE LIKE ? AND ROWNUM <=?";
				}
				suggestionList = ListItemUtil.prepareSuggestionList(query, object);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return suggestionList;
		}	
	 public void validateCOVER_PREM_TYPE(FacesContext context,UIComponent component,Object object) {

		 try{
			 PM_IL_COVER_BEAN.setCOVER_PREM_TYPE((String)object);

			 if("D".equalsIgnoreCase(PM_IL_COVER_BEAN.getCOVER_PREM_TYPE())){
				 String message = "Cover Premium Type:Fixed is applicable only for Annuity products";
				 compositeAction.getPM_IL_COVER_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,  message);

			 }

		 }catch (Exception e) {
			 e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		 }
	 }
	 
	 
	 /*Added by saritha on 15/12/2017 for ssp call id : ZBLIFE-1463447*/
	 private HtmlOutputLabel COMP_COVER_FUNERAL_CVR_YN_LABEL;
	 
	 public HtmlOutputLabel getCOMP_COVER_FUNERAL_CVR_YN_LABEL() {
		return COMP_COVER_FUNERAL_CVR_YN_LABEL;
	}

	public void setCOMP_COVER_FUNERAL_CVR_YN_LABEL(
			HtmlOutputLabel cOMP_COVER_FUNERAL_CVR_YN_LABEL) {
		COMP_COVER_FUNERAL_CVR_YN_LABEL = cOMP_COVER_FUNERAL_CVR_YN_LABEL;
	}
	
	private HtmlSelectOneMenu COMP_COVER_FUNERAL_CVR_YN;

	public HtmlSelectOneMenu getCOMP_COVER_FUNERAL_CVR_YN() {
		return COMP_COVER_FUNERAL_CVR_YN;
	}

	public void setCOMP_COVER_FUNERAL_CVR_YN(
			HtmlSelectOneMenu cOMP_COVER_FUNERAL_CVR_YN) {
		COMP_COVER_FUNERAL_CVR_YN = cOMP_COVER_FUNERAL_CVR_YN;
	}

	public void validateCOVER_FUNERAL_CVR_YN(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_COVER_BEAN.setCOVER_FUNERAL_CVR_YN((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	 
	 /*End*/
	 
	/*Added by Janani on 24.04.2018 for Fidelity money tree cover validation*/
	
	private HtmlOutputLabel COMP_COVER_VALIDATE_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_COVER_VALIDATE_YN;

	public HtmlOutputLabel getCOMP_COVER_VALIDATE_YN_LABEL() {
		return COMP_COVER_VALIDATE_YN_LABEL;
	}

	public void setCOMP_COVER_VALIDATE_YN_LABEL(
			HtmlOutputLabel cOMP_COVER_VALIDATE_YN_LABEL) {
		COMP_COVER_VALIDATE_YN_LABEL = cOMP_COVER_VALIDATE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_VALIDATE_YN() {
		return COMP_COVER_VALIDATE_YN;
	}

	public void setCOMP_COVER_VALIDATE_YN(HtmlSelectOneMenu cOMP_COVER_VALIDATE_YN) {
		COMP_COVER_VALIDATE_YN = cOMP_COVER_VALIDATE_YN;
	}
	
	
	public void validateCOVER_VALIDATE_YN(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_COVER_BEAN.setCOVER_VALIDATE_YN((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	private List<SelectItem> COVER_VALIDATE_YN_ITEMS;

	public List<SelectItem> getCOVER_VALIDATE_YN_ITEMS() {
		return COVER_VALIDATE_YN_ITEMS;
	}

	public void setCOVER_VALIDATE_YN_ITEMS(List<SelectItem> cOVER_VALIDATE_YN_ITEMS) {
		COVER_VALIDATE_YN_ITEMS = cOVER_VALIDATE_YN_ITEMS;
	}

	
	
	
	/*End*/
	
}
