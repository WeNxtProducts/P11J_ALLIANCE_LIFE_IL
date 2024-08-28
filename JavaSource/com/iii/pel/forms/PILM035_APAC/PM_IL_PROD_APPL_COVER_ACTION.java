package com.iii.pel.forms.PILM035_APAC;

import java.util.ArrayList;
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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_APPL_COVER_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PAC_COVER_CODE_LABEL;

	private HtmlInputText COMP_PAC_COVER_CODE;

	private HtmlOutputLabel COMP_PAC_MANDATORY_YN_LABEL;

	private HtmlSelectOneMenu COMP_PAC_MANDATORY_YN;

	private HtmlOutputLabel COMP_PAC_DEFAULT_YN_LABEL;

	private HtmlSelectOneMenu COMP_PAC_DEFAULT_YN;

	private HtmlOutputLabel COMP_PAC_TARIFF_TERM_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PAC_TARIFF_TERM_FLAG;

	private HtmlOutputLabel COMP_PAC_PERIOD_LABEL;

	private HtmlInputText COMP_PAC_PERIOD;

	private HtmlOutputLabel COMP_PAC_PREM_PAY_YRS_LABEL;

	private HtmlInputText COMP_PAC_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_PAC_MAX_AGE_ON_MAT_LABEL;

	private HtmlInputText COMP_PAC_MAX_AGE_ON_MAT;

	private HtmlOutputLabel COMP_PAC_MAT_PAYEE_AGE_LABEL;

	private HtmlInputText COMP_PAC_MAT_PAYEE_AGE;

	private HtmlOutputLabel COMP_PAC_MAT_PAYER_AGE_LABEL;

	private HtmlInputText COMP_PAC_MAT_PAYER_AGE;

	private HtmlOutputLabel COMP_PAC_COVER_START_AGE_LABEL;

	private HtmlInputText COMP_PAC_COVER_START_AGE;

	private HtmlOutputLabel COMP_PAC_BCH_CODE_LABEL;

	private HtmlInputText COMP_PAC_BCH_CODE;

	private HtmlOutputLabel COMP_PAC_PRODUCTION_PERC_LABEL;

	private HtmlInputText COMP_PAC_PRODUCTION_PERC;

	private HtmlOutputLabel COMP_PAC_THRESHOLD_PERC_LABEL;

	private HtmlInputText COMP_PAC_THRESHOLD_PERC;

	private HtmlOutputLabel COMP_PAC_MED_DAYS_LABEL;

	private HtmlInputText COMP_PAC_MED_DAYS;

	private HtmlOutputLabel COMP_PAC_MED_AMT_LABEL;

	private HtmlInputText COMP_PAC_MED_AMT;

	private HtmlOutputLabel COMP_PAC_RSA_CALC_YN_LABEL;

	private HtmlSelectOneMenu COMP_PAC_RSA_CALC_YN;

	private HtmlOutputLabel COMP_PAC_GRP_THRESHOLD_PERC_LABEL;

	private HtmlInputText COMP_PAC_GRP_THRESHOLD_PERC;

	private HtmlOutputLabel COMP_PAC_BCH_TERM_LABEL;

	private HtmlSelectOneMenu COMP_PAC_BCH_TERM;

	private HtmlOutputLabel COMP_UI_M_PAC_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PAC_COVER_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_PAC_BCH_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PAC_BCH_CODE_DESC;

	private HtmlOutputLabel COMP_PAC_SA_FACTOR_LABEL;

	private HtmlOutputLabel COMP_PAC_SA_ADD_FACTOR_LABEL;

	private HtmlInputText COMP_PAC_SA_ADD_FACTOR;

	private HtmlInputText COMP_PAC_SA_FACTOR;

	private HtmlOutputLabel COMP_PAC_SA_TARIFF_LABEL;

	private HtmlInputText COMP_PAC_SA_TARIFF;

	private HtmlOutputLabel COMP_PAC_PREM_TARIFF_LABEL;

	private HtmlInputText COMP_PAC_PREM_TARIFF;
	
	private HtmlOutputLabel COMP_PAC_COOL_OF_PD_LABEL;

	private HtmlInputText COMP_PAC_COOL_OF_PD;

	private HtmlOutputLabel COMP_PAC_COVER_ASSR_TYPE_LABEL;
	
	private HtmlOutputLabel COMP_PAC_AGE_BASIS_LABEL;
	
	private HtmlOutputLabel COMP_PAC_COVER_START_AGE_VAL_YN_LABEL;
	/*added by gopi for ssp call id ZBILQC-1719437 on 27/01/17*/
	private HtmlOutputLabel COMP_PAC_ATT_CVR_YN_LABEL;
	
	public HtmlOutputLabel getCOMP_PAC_ATT_CVR_YN_LABEL() {
		return COMP_PAC_ATT_CVR_YN_LABEL;
	}

	public void setCOMP_PAC_ATT_CVR_YN_LABEL(
			HtmlOutputLabel cOMP_PAC_ATT_CVR_YN_LABEL) {
		COMP_PAC_ATT_CVR_YN_LABEL = cOMP_PAC_ATT_CVR_YN_LABEL;
	}
	private HtmlSelectOneMenu COMP_PAC_ATT_CVR_YN;
	
	public HtmlSelectOneMenu getCOMP_PAC_ATT_CVR_YN() {
		return COMP_PAC_ATT_CVR_YN;
	}

	public void setCOMP_PAC_ATT_CVR_YN(HtmlSelectOneMenu cOMP_PAC_ATT_CVR_YN) {
		COMP_PAC_ATT_CVR_YN = cOMP_PAC_ATT_CVR_YN;
	}
	/*end*/
    private HtmlSelectOneMenu COMP_PAC_AGE_BASIS;
	
	private HtmlSelectOneMenu COMP_PAC_COVER_START_AGE_VAL_YN;
	
	private HtmlSelectOneMenu COMP_PAC_COVER_ASSR_TYPE;

	private HtmlCommandButton COMP_UI_M_BUT_PAC_BCH_CODE_LOV;

	private PM_IL_PROD_APPL_COVER PM_IL_PROD_APPL_COVER_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_APPL_COVER_HELPER helper;

	private PM_IL_PROD_APPL_COVER_DELEGATE delegate;

	private List<PM_IL_PROD_APPL_COVER> dataList_PM_IL_PROD_APPL_COVER = new ArrayList<PM_IL_PROD_APPL_COVER>();

	private UIData dataTable;

	private List<SelectItem> listPAC_MANDATORY_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPAC_DEFAULT_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPAC_TARIFF_TERM_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPAC_RSA_CALC_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPAC_BCH_TERM = new ArrayList<SelectItem>();

	private List<SelectItem> listPAC_COVER_ASSR_TYPE = new ArrayList<SelectItem>();
	
	private List<SelectItem> listPAC_AGE_BASIS = new ArrayList<SelectItem>();
	
	private List<SelectItem> listPAC_COVER_START_AGE_VAL_YN = new ArrayList<SelectItem>();
	/*added by gopi for ssp call id ZBILQC-1719437 on 27/01/17*/
	private List<SelectItem> listPAC_ATT_CVR_YN = new ArrayList<SelectItem>();

	public List<SelectItem> getListPAC_ATT_CVR_YN() {
		if (listPAC_ATT_CVR_YN.size() == 0) {
			listPAC_ATT_CVR_YN.clear();
			try {
				listPAC_ATT_CVR_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_ATT_CVR_YN;
	}

	public void setListPAC_ATT_CVR_YN(List<SelectItem> listPAC_ATT_CVR_YN) {
		this.listPAC_ATT_CVR_YN = listPAC_ATT_CVR_YN;
	}
	/*end*/

	public PM_IL_PROD_APPL_COVER_ACTION() {
		PM_IL_PROD_APPL_COVER_BEAN = new PM_IL_PROD_APPL_COVER();
		helper = new PM_IL_PROD_APPL_COVER_HELPER();
		delegate = new PM_IL_PROD_APPL_COVER_DELEGATE();
		instantiateAllComponent();

		prepareDropDownList();
	}

	public HtmlOutputLabel getCOMP_PAC_SA_ADD_FACTOR_LABEL() {
		return COMP_PAC_SA_ADD_FACTOR_LABEL;
	}

	public void setCOMP_PAC_SA_ADD_FACTOR_LABEL(
			HtmlOutputLabel comp_pac_sa_add_factor_label) {
		COMP_PAC_SA_ADD_FACTOR_LABEL = comp_pac_sa_add_factor_label;
	}

	public HtmlInputText getCOMP_PAC_SA_ADD_FACTOR() {
		return COMP_PAC_SA_ADD_FACTOR;
	}

	public void setCOMP_PAC_SA_ADD_FACTOR(HtmlInputText comp_pac_sa_add_factor) {
		COMP_PAC_SA_ADD_FACTOR = comp_pac_sa_add_factor;
	}

	public HtmlOutputLabel getCOMP_PAC_COVER_CODE_LABEL() {
		return COMP_PAC_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAC_COVER_CODE() {
		return COMP_PAC_COVER_CODE;
	}

	public void setCOMP_PAC_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_PAC_COVER_CODE_LABEL) {
		this.COMP_PAC_COVER_CODE_LABEL = COMP_PAC_COVER_CODE_LABEL;
	}

	public void setCOMP_PAC_COVER_CODE(HtmlInputText COMP_PAC_COVER_CODE) {
		this.COMP_PAC_COVER_CODE = COMP_PAC_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_PAC_MANDATORY_YN_LABEL() {
		return COMP_PAC_MANDATORY_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAC_MANDATORY_YN() {
		return COMP_PAC_MANDATORY_YN;
	}

	public void setCOMP_PAC_MANDATORY_YN_LABEL(
			HtmlOutputLabel COMP_PAC_MANDATORY_YN_LABEL) {
		this.COMP_PAC_MANDATORY_YN_LABEL = COMP_PAC_MANDATORY_YN_LABEL;
	}

	public void setCOMP_PAC_MANDATORY_YN(HtmlSelectOneMenu COMP_PAC_MANDATORY_YN) {
		this.COMP_PAC_MANDATORY_YN = COMP_PAC_MANDATORY_YN;
	}

	public HtmlOutputLabel getCOMP_PAC_DEFAULT_YN_LABEL() {
		return COMP_PAC_DEFAULT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAC_DEFAULT_YN() {
		return COMP_PAC_DEFAULT_YN;
	}

	public void setCOMP_PAC_DEFAULT_YN_LABEL(
			HtmlOutputLabel COMP_PAC_DEFAULT_YN_LABEL) {
		this.COMP_PAC_DEFAULT_YN_LABEL = COMP_PAC_DEFAULT_YN_LABEL;
	}

	public void setCOMP_PAC_DEFAULT_YN(HtmlSelectOneMenu COMP_PAC_DEFAULT_YN) {
		this.COMP_PAC_DEFAULT_YN = COMP_PAC_DEFAULT_YN;
	}

	public HtmlOutputLabel getCOMP_PAC_TARIFF_TERM_FLAG_LABEL() {
		return COMP_PAC_TARIFF_TERM_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAC_TARIFF_TERM_FLAG() {
		return COMP_PAC_TARIFF_TERM_FLAG;
	}

	public void setCOMP_PAC_TARIFF_TERM_FLAG_LABEL(
			HtmlOutputLabel COMP_PAC_TARIFF_TERM_FLAG_LABEL) {
		this.COMP_PAC_TARIFF_TERM_FLAG_LABEL = COMP_PAC_TARIFF_TERM_FLAG_LABEL;
	}

	public void setCOMP_PAC_TARIFF_TERM_FLAG(
			HtmlSelectOneMenu COMP_PAC_TARIFF_TERM_FLAG) {
		this.COMP_PAC_TARIFF_TERM_FLAG = COMP_PAC_TARIFF_TERM_FLAG;
	}

	public HtmlOutputLabel getCOMP_PAC_PERIOD_LABEL() {
		return COMP_PAC_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_PAC_PERIOD() {
		return COMP_PAC_PERIOD;
	}

	public void setCOMP_PAC_PERIOD_LABEL(HtmlOutputLabel COMP_PAC_PERIOD_LABEL) {
		this.COMP_PAC_PERIOD_LABEL = COMP_PAC_PERIOD_LABEL;
	}

	public void setCOMP_PAC_PERIOD(HtmlInputText COMP_PAC_PERIOD) {
		this.COMP_PAC_PERIOD = COMP_PAC_PERIOD;
	}

	public HtmlOutputLabel getCOMP_PAC_PREM_PAY_YRS_LABEL() {
		return COMP_PAC_PREM_PAY_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PAC_PREM_PAY_YRS() {
		return COMP_PAC_PREM_PAY_YRS;
	}

	public void setCOMP_PAC_PREM_PAY_YRS_LABEL(
			HtmlOutputLabel COMP_PAC_PREM_PAY_YRS_LABEL) {
		this.COMP_PAC_PREM_PAY_YRS_LABEL = COMP_PAC_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_PAC_PREM_PAY_YRS(HtmlInputText COMP_PAC_PREM_PAY_YRS) {
		this.COMP_PAC_PREM_PAY_YRS = COMP_PAC_PREM_PAY_YRS;
	}

	public HtmlOutputLabel getCOMP_PAC_MAX_AGE_ON_MAT_LABEL() {
		return COMP_PAC_MAX_AGE_ON_MAT_LABEL;
	}

	public HtmlInputText getCOMP_PAC_MAX_AGE_ON_MAT() {
		return COMP_PAC_MAX_AGE_ON_MAT;
	}

	public void setCOMP_PAC_MAX_AGE_ON_MAT_LABEL(
			HtmlOutputLabel COMP_PAC_MAX_AGE_ON_MAT_LABEL) {
		this.COMP_PAC_MAX_AGE_ON_MAT_LABEL = COMP_PAC_MAX_AGE_ON_MAT_LABEL;
	}

	public void setCOMP_PAC_MAX_AGE_ON_MAT(HtmlInputText COMP_PAC_MAX_AGE_ON_MAT) {
		this.COMP_PAC_MAX_AGE_ON_MAT = COMP_PAC_MAX_AGE_ON_MAT;
	}

	public HtmlOutputLabel getCOMP_PAC_BCH_CODE_LABEL() {
		return COMP_PAC_BCH_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAC_BCH_CODE() {
		return COMP_PAC_BCH_CODE;
	}

	public void setCOMP_PAC_BCH_CODE_LABEL(
			HtmlOutputLabel COMP_PAC_BCH_CODE_LABEL) {
		this.COMP_PAC_BCH_CODE_LABEL = COMP_PAC_BCH_CODE_LABEL;
	}

	public void setCOMP_PAC_BCH_CODE(HtmlInputText COMP_PAC_BCH_CODE) {
		this.COMP_PAC_BCH_CODE = COMP_PAC_BCH_CODE;
	}

	public HtmlOutputLabel getCOMP_PAC_PRODUCTION_PERC_LABEL() {
		return COMP_PAC_PRODUCTION_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PAC_PRODUCTION_PERC() {
		return COMP_PAC_PRODUCTION_PERC;
	}

	public void setCOMP_PAC_PRODUCTION_PERC_LABEL(
			HtmlOutputLabel COMP_PAC_PRODUCTION_PERC_LABEL) {
		this.COMP_PAC_PRODUCTION_PERC_LABEL = COMP_PAC_PRODUCTION_PERC_LABEL;
	}

	public void setCOMP_PAC_PRODUCTION_PERC(
			HtmlInputText COMP_PAC_PRODUCTION_PERC) {
		this.COMP_PAC_PRODUCTION_PERC = COMP_PAC_PRODUCTION_PERC;
	}

	public HtmlOutputLabel getCOMP_PAC_THRESHOLD_PERC_LABEL() {
		return COMP_PAC_THRESHOLD_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PAC_THRESHOLD_PERC() {
		return COMP_PAC_THRESHOLD_PERC;
	}

	public void setCOMP_PAC_THRESHOLD_PERC_LABEL(
			HtmlOutputLabel COMP_PAC_THRESHOLD_PERC_LABEL) {
		this.COMP_PAC_THRESHOLD_PERC_LABEL = COMP_PAC_THRESHOLD_PERC_LABEL;
	}

	public void setCOMP_PAC_THRESHOLD_PERC(HtmlInputText COMP_PAC_THRESHOLD_PERC) {
		this.COMP_PAC_THRESHOLD_PERC = COMP_PAC_THRESHOLD_PERC;
	}

	public HtmlOutputLabel getCOMP_PAC_MED_DAYS_LABEL() {
		return COMP_PAC_MED_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_PAC_MED_DAYS() {
		return COMP_PAC_MED_DAYS;
	}

	public void setCOMP_PAC_MED_DAYS_LABEL(
			HtmlOutputLabel COMP_PAC_MED_DAYS_LABEL) {
		this.COMP_PAC_MED_DAYS_LABEL = COMP_PAC_MED_DAYS_LABEL;
	}

	public void setCOMP_PAC_MED_DAYS(HtmlInputText COMP_PAC_MED_DAYS) {
		this.COMP_PAC_MED_DAYS = COMP_PAC_MED_DAYS;
	}

	public HtmlOutputLabel getCOMP_PAC_MED_AMT_LABEL() {
		return COMP_PAC_MED_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PAC_MED_AMT() {
		return COMP_PAC_MED_AMT;
	}

	public void setCOMP_PAC_MED_AMT_LABEL(HtmlOutputLabel COMP_PAC_MED_AMT_LABEL) {
		this.COMP_PAC_MED_AMT_LABEL = COMP_PAC_MED_AMT_LABEL;
	}

	public void setCOMP_PAC_MED_AMT(HtmlInputText COMP_PAC_MED_AMT) {
		this.COMP_PAC_MED_AMT = COMP_PAC_MED_AMT;
	}

	public HtmlOutputLabel getCOMP_PAC_RSA_CALC_YN_LABEL() {
		return COMP_PAC_RSA_CALC_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAC_RSA_CALC_YN() {
		return COMP_PAC_RSA_CALC_YN;
	}

	public void setCOMP_PAC_RSA_CALC_YN_LABEL(
			HtmlOutputLabel COMP_PAC_RSA_CALC_YN_LABEL) {
		this.COMP_PAC_RSA_CALC_YN_LABEL = COMP_PAC_RSA_CALC_YN_LABEL;
	}

	public void setCOMP_PAC_RSA_CALC_YN(HtmlSelectOneMenu COMP_PAC_RSA_CALC_YN) {
		this.COMP_PAC_RSA_CALC_YN = COMP_PAC_RSA_CALC_YN;
	}

	public HtmlOutputLabel getCOMP_PAC_GRP_THRESHOLD_PERC_LABEL() {
		return COMP_PAC_GRP_THRESHOLD_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PAC_GRP_THRESHOLD_PERC() {
		return COMP_PAC_GRP_THRESHOLD_PERC;
	}

	public void setCOMP_PAC_GRP_THRESHOLD_PERC_LABEL(
			HtmlOutputLabel COMP_PAC_GRP_THRESHOLD_PERC_LABEL) {
		this.COMP_PAC_GRP_THRESHOLD_PERC_LABEL = COMP_PAC_GRP_THRESHOLD_PERC_LABEL;
	}

	public void setCOMP_PAC_GRP_THRESHOLD_PERC(
			HtmlInputText COMP_PAC_GRP_THRESHOLD_PERC) {
		this.COMP_PAC_GRP_THRESHOLD_PERC = COMP_PAC_GRP_THRESHOLD_PERC;
	}

	public HtmlOutputLabel getCOMP_PAC_BCH_TERM_LABEL() {
		return COMP_PAC_BCH_TERM_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAC_BCH_TERM() {
		return COMP_PAC_BCH_TERM;
	}

	public void setCOMP_PAC_BCH_TERM_LABEL(
			HtmlOutputLabel COMP_PAC_BCH_TERM_LABEL) {
		this.COMP_PAC_BCH_TERM_LABEL = COMP_PAC_BCH_TERM_LABEL;
	}

	public void setCOMP_PAC_BCH_TERM(HtmlSelectOneMenu COMP_PAC_BCH_TERM) {
		this.COMP_PAC_BCH_TERM = COMP_PAC_BCH_TERM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAC_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_PAC_COVER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAC_COVER_CODE_DESC() {
		return COMP_UI_M_PAC_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_PAC_COVER_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PAC_COVER_CODE_DESC_LABEL) {
		this.COMP_UI_M_PAC_COVER_CODE_DESC_LABEL = COMP_UI_M_PAC_COVER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PAC_COVER_CODE_DESC(
			HtmlInputText COMP_UI_M_PAC_COVER_CODE_DESC) {
		this.COMP_UI_M_PAC_COVER_CODE_DESC = COMP_UI_M_PAC_COVER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAC_BCH_CODE_DESC_LABEL() {
		return COMP_UI_M_PAC_BCH_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAC_BCH_CODE_DESC() {
		return COMP_UI_M_PAC_BCH_CODE_DESC;
	}

	public void setCOMP_UI_M_PAC_BCH_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PAC_BCH_CODE_DESC_LABEL) {
		this.COMP_UI_M_PAC_BCH_CODE_DESC_LABEL = COMP_UI_M_PAC_BCH_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PAC_BCH_CODE_DESC(
			HtmlInputText COMP_UI_M_PAC_BCH_CODE_DESC) {
		this.COMP_UI_M_PAC_BCH_CODE_DESC = COMP_UI_M_PAC_BCH_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PAC_SA_FACTOR_LABEL() {
		return COMP_PAC_SA_FACTOR_LABEL;
	}

	public HtmlInputText getCOMP_PAC_SA_FACTOR() {
		return COMP_PAC_SA_FACTOR;
	}

	public void setCOMP_PAC_SA_FACTOR_LABEL(
			HtmlOutputLabel COMP_PAC_SA_FACTOR_LABEL) {
		this.COMP_PAC_SA_FACTOR_LABEL = COMP_PAC_SA_FACTOR_LABEL;
	}

	public void setCOMP_PAC_SA_FACTOR(HtmlInputText COMP_PAC_SA_FACTOR) {
		this.COMP_PAC_SA_FACTOR = COMP_PAC_SA_FACTOR;
	}

	public HtmlOutputLabel getCOMP_PAC_SA_TARIFF_LABEL() {
		return COMP_PAC_SA_TARIFF_LABEL;
	}

	public HtmlInputText getCOMP_PAC_SA_TARIFF() {
		return COMP_PAC_SA_TARIFF;
	}

	public void setCOMP_PAC_SA_TARIFF_LABEL(
			HtmlOutputLabel COMP_PAC_SA_TARIFF_LABEL) {
		this.COMP_PAC_SA_TARIFF_LABEL = COMP_PAC_SA_TARIFF_LABEL;
	}

	public void setCOMP_PAC_SA_TARIFF(HtmlInputText COMP_PAC_SA_TARIFF) {
		this.COMP_PAC_SA_TARIFF = COMP_PAC_SA_TARIFF;
	}

	public HtmlOutputLabel getCOMP_PAC_PREM_TARIFF_LABEL() {
		return COMP_PAC_PREM_TARIFF_LABEL;
	}

	public HtmlInputText getCOMP_PAC_PREM_TARIFF() {
		return COMP_PAC_PREM_TARIFF;
	}

	public void setCOMP_PAC_PREM_TARIFF_LABEL(
			HtmlOutputLabel COMP_PAC_PREM_TARIFF_LABEL) {
		this.COMP_PAC_PREM_TARIFF_LABEL = COMP_PAC_PREM_TARIFF_LABEL;
	}

	public void setCOMP_PAC_PREM_TARIFF(HtmlInputText COMP_PAC_PREM_TARIFF) {
		this.COMP_PAC_PREM_TARIFF = COMP_PAC_PREM_TARIFF;
	}

	public HtmlOutputLabel getCOMP_PAC_COVER_ASSR_TYPE_LABEL() {
		return COMP_PAC_COVER_ASSR_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAC_COVER_ASSR_TYPE() {
		return COMP_PAC_COVER_ASSR_TYPE;
	}

	public void setCOMP_PAC_COVER_ASSR_TYPE_LABEL(
			HtmlOutputLabel COMP_PAC_COVER_ASSR_TYPE_LABEL) {
		this.COMP_PAC_COVER_ASSR_TYPE_LABEL = COMP_PAC_COVER_ASSR_TYPE_LABEL;
	}

	public void setCOMP_PAC_COVER_ASSR_TYPE(
			HtmlSelectOneMenu COMP_PAC_COVER_ASSR_TYPE) {
		this.COMP_PAC_COVER_ASSR_TYPE = COMP_PAC_COVER_ASSR_TYPE;
	}

	public PM_IL_PROD_APPL_COVER getPM_IL_PROD_APPL_COVER_BEAN() {
		return PM_IL_PROD_APPL_COVER_BEAN;
	}

	public void setPM_IL_PROD_APPL_COVER_BEAN(
			PM_IL_PROD_APPL_COVER PM_IL_PROD_APPL_COVER_BEAN) {
		this.PM_IL_PROD_APPL_COVER_BEAN = PM_IL_PROD_APPL_COVER_BEAN;
	}

	public List<PM_IL_PROD_APPL_COVER> getDataList_PM_IL_PROD_APPL_COVER() {
		return dataList_PM_IL_PROD_APPL_COVER;
	}

	public void setDataListPM_IL_PROD_APPL_COVER(
			List<PM_IL_PROD_APPL_COVER> dataList_PM_IL_PROD_APPL_COVER) {
		this.dataList_PM_IL_PROD_APPL_COVER = dataList_PM_IL_PROD_APPL_COVER;
	}

	public String addRow() {
		try {
			if (isINSERT_ALLOWED()) {
				helper.WHEN_CREATE_RECORD(compositeAction);
				PM_IL_PROD_APPL_COVER_BEAN = new PM_IL_PROD_APPL_COVER();
				resetAllComponent();
				resetDummyComponentsToCreateNewRec();
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

		return null;

	}
	
	private void resetDummyComponentsToCreateNewRec(){
		compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_PAC_SA_FACTOR("");
		compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_PAC_SA_ADD_FACTOR("");
		compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_PAC_PREM_TARIFF("");
		compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_PAC_SA_TARIFF("");
	}

	public String deleteRow() {
		try {
			if (isDELETE_ALLOWED()) {
				helper.PRE_DELETE(compositeAction);
				new CRUDHandler().executeDelete(PM_IL_PROD_APPL_COVER_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
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
				dataList_PM_IL_PROD_APPL_COVER
						.remove(PM_IL_PROD_APPL_COVER_BEAN);
				if (dataList_PM_IL_PROD_APPL_COVER.size() > 0) {

					PM_IL_PROD_APPL_COVER_BEAN = dataList_PM_IL_PROD_APPL_COVER
							.get(0);
				} else if (dataList_PM_IL_PROD_APPL_COVER.size() == 0) {

					addRow();
				}

				resetAllComponent();
				PM_IL_PROD_APPL_COVER_BEAN.setRowSelected(true);
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

		return null;

	}

	public void postRecord(ActionEvent event) {
		try {
			if (PM_IL_PROD_APPL_COVER_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_APPL_COVER_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				dataList_PM_IL_PROD_APPL_COVER.add(PM_IL_PROD_APPL_COVER_BEAN);
			} else if (PM_IL_PROD_APPL_COVER_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_APPL_COVER_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}

			PM_IL_PROD_APPL_COVER_BEAN.setRowSelected(true);
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
			PM_IL_PROD_APPL_COVER_BEAN = (PM_IL_PROD_APPL_COVER) dataTable
					.getRowData();
			
			helper.POST_QUERY(compositeAction);
			PM_IL_PROD_APPL_COVER_BEAN.setRowSelected(true);
			//added by soundarya for additional cover on 11-05-2016
			
			String age_basis=compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getPM_IL_PROD_APPL_COVER_BEAN().getPAC_AGE_BASIS();
			if ("E".equalsIgnoreCase(age_basis)) {
						compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYER_AGE().setDisabled(true);
						compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYEE_AGE().setDisabled(false);
						
			} else if ("R".equalsIgnoreCase(age_basis)) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYER_AGE().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYEE_AGE().setDisabled(true);
				/*compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYER_AGE().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYER_AGE().setRequired(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYEE_AGE().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYEE_AGE().setRequired(false);		*/		
			
			}
			
			
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_APPL_COVER> PM_IL_PROD_APPL_COVER_ITR = dataList_PM_IL_PROD_APPL_COVER
				.iterator();
		while (PM_IL_PROD_APPL_COVER_ITR.hasNext()) {
			PM_IL_PROD_APPL_COVER_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PAC_COVER_CODE.resetValue();
		COMP_PAC_MANDATORY_YN.resetValue();
		COMP_PAC_DEFAULT_YN.resetValue();
		COMP_PAC_TARIFF_TERM_FLAG.resetValue();
		COMP_PAC_PERIOD.resetValue();
		COMP_PAC_PREM_PAY_YRS.resetValue();
		COMP_PAC_MAX_AGE_ON_MAT.resetValue();
		COMP_PAC_BCH_CODE.resetValue();
		COMP_PAC_PRODUCTION_PERC.resetValue();
		COMP_PAC_THRESHOLD_PERC.resetValue();
		COMP_PAC_MED_DAYS.resetValue();
		COMP_PAC_MED_AMT.resetValue();
		COMP_PAC_RSA_CALC_YN.resetValue();
		COMP_PAC_GRP_THRESHOLD_PERC.resetValue();
		COMP_PAC_BCH_TERM.resetValue();
		COMP_UI_M_PAC_COVER_CODE_DESC.resetValue();
		COMP_UI_M_PAC_BCH_CODE_DESC.resetValue();
		COMP_PAC_SA_FACTOR.resetValue();
		COMP_PAC_SA_ADD_FACTOR.resetValue();
		COMP_PAC_SA_TARIFF.resetValue();
		COMP_PAC_PREM_TARIFF.resetValue();
		COMP_PAC_COVER_ASSR_TYPE.resetValue();
		COMP_PAC_COOL_OF_PD.resetValue();
		COMP_PAC_AGE_BASIS.resetValue();
		COMP_PAC_COVER_START_AGE_VAL_YN.resetValue();
		compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PAC_SA_FACTOR().resetValue();
		//compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PAC_SA_ADD_FACTOR().resetValue();
		compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PAC_PREM_TARIFF().resetValue();
		//compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PAC_SA_TARIFF().resetValue();
		COMP_PAC_MAT_PAYER_AGE.resetValue();
		COMP_PAC_MAT_PAYEE_AGE.resetValue();
		/*added by gopi for ssp call id ZBILQC-1719437 on 27/01/17*/
		COMP_PAC_ATT_CVR_YN.resetValue();
		/*end*/
		
		/*Added by Janani on 15.05.2018 for Fidelity 
		cover start age is getting updated for all rider covers from the latest added cover*/
		
		COMP_PAC_COVER_START_AGE.resetValue();
		
		/*End*/
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
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"Save",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListPAC_MANDATORY_YN() {
		if (listPAC_MANDATORY_YN.size() == 0) {
			listPAC_MANDATORY_YN.clear();
			try {
				listPAC_MANDATORY_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_MANDATORY_YN;
	}

	public void setListPAC_MANDATORY_YN(List<SelectItem> listPAC_MANDATORY_YN) {
		this.listPAC_MANDATORY_YN = listPAC_MANDATORY_YN;
	}

	public List<SelectItem> getListPAC_DEFAULT_YN() {
		if (listPAC_DEFAULT_YN.size() == 0) {
			listPAC_DEFAULT_YN.clear();
			try {
				listPAC_DEFAULT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_DEFAULT_YN;
	}

	public void setListPAC_DEFAULT_YN(List<SelectItem> listPAC_DEFAULT_YN) {
		this.listPAC_DEFAULT_YN = listPAC_DEFAULT_YN;
	}

	public List<SelectItem> getListPAC_TARIFF_TERM_FLAG() {
		if (listPAC_TARIFF_TERM_FLAG.size() == 0) {
			listPAC_TARIFF_TERM_FLAG.clear();
			try {
				listPAC_TARIFF_TERM_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_TARIFF_TERM_FLAG;
	}

	public void setListPAC_TARIFF_TERM_FLAG(
			List<SelectItem> listPAC_TARIFF_TERM_FLAG) {
		this.listPAC_TARIFF_TERM_FLAG = listPAC_TARIFF_TERM_FLAG;
	}

	public List<SelectItem> getListPAC_RSA_CALC_YN() {
		if (listPAC_RSA_CALC_YN.size() == 0) {
			listPAC_RSA_CALC_YN.clear();
			try {
				listPAC_RSA_CALC_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_RSA_CALC_YN;
	}

	public void setListPAC_RSA_CALC_YN(List<SelectItem> listPAC_RSA_CALC_YN) {
		this.listPAC_RSA_CALC_YN = listPAC_RSA_CALC_YN;
	}

	public List<SelectItem> getListPAC_BCH_TERM() {
		if (listPAC_BCH_TERM.size() == 0) {
			listPAC_BCH_TERM.clear();
			try {
				listPAC_BCH_TERM = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_BCH_TERM;
	}

	public void setListPAC_BCH_TERM(List<SelectItem> listPAC_BCH_TERM) {
		this.listPAC_BCH_TERM = listPAC_BCH_TERM;
	}

	public List<SelectItem> getListPAC_COVER_ASSR_TYPE() {
		if (listPAC_COVER_ASSR_TYPE.size() == 0) {
			listPAC_COVER_ASSR_TYPE.clear();
			try {
				listPAC_COVER_ASSR_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_COVER_ASSR_TYPE;
	}

	public void setListPAC_COVER_ASSR_TYPE(
			List<SelectItem> listPAC_COVER_ASSR_TYPE) {
		this.listPAC_COVER_ASSR_TYPE = listPAC_COVER_ASSR_TYPE;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	private void prepareDropDownList() {

		try {
			setListPAC_DEFAULT_YN(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC", "PM_IL_PROD_APPL_COVER",
					"PM_IL_PROD_APPL_COVER.PAC_DEFAULT_YN", "YESNO"));

			setListPAC_TARIFF_TERM_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_APPL_COVER",
					"PM_IL_PROD_APPL_COVER.PAC_TARIFF_TERM_FLAG", "TRMFLAG"));
			setListPAC_RSA_CALC_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_APPL_COVER",
					"PM_IL_PROD_APPL_COVER.PAC_RSA_CALC_YN", "YESNO"));
			setListPAC_BCH_TERM(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC", "PM_IL_PROD_APPL_COVER",
					"PM_IL_PROD_APPL_COVER.PAC_BCH_TERM", "IL_COMM_TERM"));
			setListPAC_MANDATORY_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_APPL_COVER",
					"PM_IL_PROD_APPL_COVER.PAC_MANDATORY_YN", "YESNO"));
			setListPAC_COVER_ASSR_TYPE(ListItemUtil
					.getDropDownListValue(CommonUtils.getConnection(),
							"PILM035_APAC", "PM_IL_PROD_APPL_COVER",
							"PM_IL_PROD_APPL_COVER.PAC_COVER_ASSR_TYPE",
							"PROD_DRP_CLM"));
			setListPAC_AGE_BASIS(ListItemUtil
					.getDropDownListValue(CommonUtils.getConnection(),
							"PILM035_APAC", "PM_IL_PROD_APPL_COVER",
							"PM_IL_PROD_APPL_COVER.PAC_AGE_BASIS",
							"PACAGEBASIS"));
			setListPAC_COVER_START_AGE_VAL_YN(ListItemUtil
					.getDropDownListValue(CommonUtils.getConnection(),
							"PILM035_APAC", "PM_IL_PROD_APPL_COVER",
							"PM_IL_PROD_APPL_COVER.PAC_COVER_START_AGE_VAL_YN",
							"YESNO"));
			/*added by gopi for ssp call id ZBILQC-1719437 on 27/01/17*/
		setListPAC_ATT_CVR_YN(ListItemUtil
				.getDropDownListValue(CommonUtils.getConnection(),
						"PILM035_APAC", "PM_IL_PROD_APPL_COVER",
						"PM_IL_PROD_APPL_COVER.PAC_ATT_CVR_YN",
						"YESNO"));
		//end
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String detailCoverButtonAction() {
		return "PILM035_APAC_PM_IL_PROD_APPL_COVER_1";
	}

	public void onLoad(PhaseEvent event) {
		try {
			
			String age_basis=compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getPM_IL_PROD_APPL_COVER_BEAN().getPAC_AGE_BASIS();
			if ("E".equalsIgnoreCase(age_basis)) {
						compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYER_AGE().setDisabled(true);
						compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYEE_AGE().setDisabled(false);
						
			} else if ("R".equalsIgnoreCase(age_basis)) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYER_AGE().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYEE_AGE().setDisabled(true);
				/*compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYER_AGE().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYER_AGE().setRequired(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYEE_AGE().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYEE_AGE().setRequired(false);		*/		
			
			}
			
			
			COMP_PAC_AGE_BASIS.resetValue();
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				helper.executeQuery(compositeAction);
			
				if (getPM_IL_PROD_APPL_COVER_BEAN().getROWID() != null) {
					helper.POST_QUERY(compositeAction);
				}else{
					helper.WHEN_CREATE_RECORD(compositeAction);
				}
				helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
				setBlockFlag(false);
			}
			
			
			/*Added by Janani on 15.05.2018 for Fidelity 
			cover start age is getting updated for all rider covers from the latest added cover*/
			
			if ("Y".equalsIgnoreCase(getPM_IL_PROD_APPL_COVER_BEAN().getPAC_COVER_START_AGE_VAL_YN())) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_COVER_START_AGE().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_COVER_START_AGE().setRequired(true);
			} else if ("N".equalsIgnoreCase(getPM_IL_PROD_APPL_COVER_BEAN().getPAC_COVER_START_AGE_VAL_YN())) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_COVER_START_AGE().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_COVER_START_AGE().setRequired(false);
			}
			
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PAC_BCH_CODE_LOV() {
		return COMP_UI_M_BUT_PAC_BCH_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_PAC_BCH_CODE_LOV(
			HtmlCommandButton comp_ui_m_but_pac_bch_code_lov) {
		COMP_UI_M_BUT_PAC_BCH_CODE_LOV = comp_ui_m_but_pac_bch_code_lov;
	}

	public void PAC_COVER_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_COVER_CODE((String) value);
			helper.WHEN_VALIDATE_ITEM_PAC_COVER_CODE(compositeAction, value);
			COMP_PAC_COVER_CODE.resetValue();
			COMP_UI_M_PAC_COVER_CODE_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PAC_PERIOD_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_PERIOD((Integer) value);
			helper.WHEN_VALIDATE_ITEM_PAC_PERIOD(compositeAction, value);
			COMP_PAC_PREM_PAY_YRS.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	public void PAC_MAX_AGE_ON_MAT_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_MAX_AGE_ON_MAT((Integer) value);
			helper.WHEN_VALIDATE_ITEM_PAC_MAX_AGE_ON_MAT(compositeAction,value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	public void PAC_COVER_START_AGE_VAL_YN_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_COVER_START_AGE_VAL_YN((String) value);
			helper.WHEN_VALIDATE_ITEM_PAC_COVER_START_AGE_VAL_YN(compositeAction, value);
			COMP_PAC_COVER_START_AGE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}
	/*added by gopi for ssp call id ZBILQC-1719437 on 27/01/17*/
	public void PAC_ATT_CVR_YN_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_ATT_CVR_YN((String) value);
			COMP_PAC_ATT_CVR_YN.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}
	/*end*/
	
	
	public void PAC_COVER_START_AGE_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_COVER_START_AGE((Integer) value);
			helper.WHEN_VALIDATE_ITEM_PAC_COVER_START_AGE(compositeAction,value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	public void PAC_PREM_PAY_YRS_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_PREM_PAY_YRS((Integer) value);
			helper.WHEN_VALIDATE_ITEM_PAC_PREM_PAY_YRS(compositeAction, value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	public void PAC_PRODUCTION_PERC_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_PRODUCTION_PERC((Double) value);
			helper.WHEN_VALIDATE_ITEM_PAC_PRODUCTION_PERC(compositeAction,value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	public void PAC_THRESHOLD_PERC_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_THRESHOLD_PERC((Double) value);
			helper.WHEN_VALIDATE_ITEM_PAC_THRESHOLD_PERC(compositeAction,value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	public void PAC_MED_DAYS_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_MED_DAYS((Integer) value);
			helper.WHEN_VALIDATE_ITEM_PAC_MED_DAYS(compositeAction, value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	public void PAC_MED_AMT_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_MED_AMT((Double) value);
			helper.WHEN_VALIDATE_ITEM_PAC_MED_AMT(compositeAction, value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	public void PAC_BCH_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_BCH_CODE((String) value);
			helper.WHEN_VALIDATE_ITEM_PAC_BCH_CODE(compositeAction, value);
			COMP_UI_M_PAC_BCH_CODE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PAC_GRP_THRESHOLD_PERC_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_GRP_THRESHOLD_PERC((Double) value);
			helper.WHEN_VALIDATE_ITEM_PAC_GRP_THRESHOLD_PERC(compositeAction,value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PAC_SA_FACTOR_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_SA_FACTOR((String) value);
			helper.WHEN_VALIDATE_ITEM_PAC_SA_FACTOR(compositeAction, value);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PAC_SA_FACTOR().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PAC_SA_ADD_FACTOR_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_SA_ADD_FACTOR((String) value);
			helper.WHEN_VALIDATE_ITEM_PAC_SA_ADD_FACTOR(compositeAction, value);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PAC_SA_ADD_FACTOR().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PAC_SA_TARIFF_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_SA_TARIFF((String) value);
			helper.WHEN_VALIDATE_ITEM_PAC_SA_TARIFF(compositeAction, value);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PAC_SA_TARIFF().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PAC_PREM_TARIFF_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_PREM_TARIFF((String) value);
			helper.WHEN_VALIDATE_ITEM_PAC_PREM_TARIFF(compositeAction, value);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PAC_PREM_TARIFF().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PAC_COVER_ASSR_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_COVER_ASSR_TYPE((String) value);
			helper.WHEN_VALIDATE_ITEM_PAC_COVER_ASSR_TYPE(compositeAction,value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PAC_AGE_BASIS_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_AGE_BASIS((String) value);
			helper.WHEN_VALIDATE_ITEM_PAC_AGE_BASIS(compositeAction, value);
			COMP_PAC_MAT_PAYER_AGE.resetValue();
			COMP_PAC_MAT_PAYEE_AGE.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PAC_MAT_PAYER_AGE_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_MAT_PAYER_AGE((Integer) value);
			helper.WHEN_VALIDATE_ITEM_PAC_MAT_PAYER_AGE(compositeAction, value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PAC_MAT_PAYEE_AGE_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_MAT_PAYEE_AGE((Integer) value);
			helper.WHEN_VALIDATE_ITEM_PAC_MAT_PAYEE_AGE(compositeAction, value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PAC_MANDATORY_YN_List_Changed_Listener(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String currValue = (String) input.getSubmittedValue();
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_MANDATORY_YN(currValue);
			helper.WHEN_LIST_CHANGED_PAC_MANDATORY_YN(compositeAction,currValue);
			COMP_PAC_DEFAULT_YN.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<LovBean> lovPAC_COVER_CODE_OLD(Object obj) {
		String bchcode = (String) obj;
		List <LovBean> suggestionList = new  ArrayList<LovBean>();
		Object[] object={};
		String query=null;
		try {
			if ("*".equals(bchcode)) {
				object = new Object[] { compositeAction.getPM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN().getPM_IL_PROD_APPL_CVR_GRP_BEAN().getPACG_CVR_GROUP_CODE()};
				query ="SELECT CGD_COVER_CODE,CGD_GROUP_CODE   FROM   PM_IL_CVR_GROUP_DTL  WHERE  CGD_GROUP_CODE = ?";
			}
			suggestionList = delegate.prepareLovList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return suggestionList;
	}
	
	public List<LovBean> lovPAC_COVER_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_APPL_COVER", "PAC_COVER_CODE", "A",
					"S", null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	//P_CALL_LOV('PM_IL_PROD_APPL_COVER.PAC_COVER_CODE','A','S');

	public List<LovBean> lovPAC_BCH_CODE(Object obj) {
		String bchcode = (String) obj;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(bchcode)) {
				object = new Object[] { PELConstants.suggetionRecordSize };
				query = PILM035_APAC_QUERYCONSTANTS.BCH_CODE_LOV;
			} else {
				object = new Object[] { bchcode + "%", bchcode + "%",
						PELConstants.suggetionRecordSize };
				query = PILM035_APAC_QUERYCONSTANTS.BCH_CODE_LOV_LIKE;
			}
			suggestionList = delegate.prepareLovList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lov_PAC_SA_FACTOR(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_APPL_COVER", "PAC_SA_FACTOR", "IL_VAL_TAR",
					null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lov_PAC_SA_TARIFF(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_APPL_COVER", "PAC_SA_TARIFF", "IL_VAL_TAR",
					null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lov_PAC_SA_ADD_FACTOR(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_APPL_COVER", "PAC_SA_ADD_FACTOR", "IL_VAL_TAR",
					null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lov_PAC_PREM_TARIFF(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_APPL_COVER", "PAC_PREM_TARIFF", "IL_VAL_TAR",
					null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public HtmlInputText getCOMP_PAC_MAT_PAYEE_AGE() {
		return COMP_PAC_MAT_PAYEE_AGE;
	}

	public void setCOMP_PAC_MAT_PAYEE_AGE(HtmlInputText comp_pac_mat_payee_age) {
		COMP_PAC_MAT_PAYEE_AGE = comp_pac_mat_payee_age;
	}

	public HtmlOutputLabel getCOMP_PAC_MAT_PAYEE_AGE_LABEL() {
		return COMP_PAC_MAT_PAYEE_AGE_LABEL;
	}

	public void setCOMP_PAC_MAT_PAYEE_AGE_LABEL(
			HtmlOutputLabel comp_pac_mat_payee_age_label) {
		COMP_PAC_MAT_PAYEE_AGE_LABEL = comp_pac_mat_payee_age_label;
	}

	public HtmlOutputLabel getCOMP_PAC_MAT_PAYER_AGE_LABEL() {
		return COMP_PAC_MAT_PAYER_AGE_LABEL;
	}

	public void setCOMP_PAC_MAT_PAYER_AGE_LABEL(
			HtmlOutputLabel comp_pac_mat_payer_age_label) {
		COMP_PAC_MAT_PAYER_AGE_LABEL = comp_pac_mat_payer_age_label;
	}

	public HtmlInputText getCOMP_PAC_MAT_PAYER_AGE() {
		return COMP_PAC_MAT_PAYER_AGE;
	}

	public void setCOMP_PAC_MAT_PAYER_AGE(HtmlInputText comp_pac_mat_payer_age) {
		COMP_PAC_MAT_PAYER_AGE = comp_pac_mat_payer_age;
	}

	public HtmlOutputLabel getCOMP_PAC_COVER_START_AGE_LABEL() {
		return COMP_PAC_COVER_START_AGE_LABEL;
	}

	public void setCOMP_PAC_COVER_START_AGE_LABEL(
			HtmlOutputLabel comp_pac_cover_start_age_label) {
		COMP_PAC_COVER_START_AGE_LABEL = comp_pac_cover_start_age_label;
	}

	public HtmlInputText getCOMP_PAC_COVER_START_AGE() {
		return COMP_PAC_COVER_START_AGE;
	}

	public void setCOMP_PAC_COVER_START_AGE(
			HtmlInputText comp_pac_cover_start_age) {
		COMP_PAC_COVER_START_AGE = comp_pac_cover_start_age;
	}
	
	
	/**
	 * Instantiates all components in PM_IL_PROD_APPL_COVER_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PAC_COVER_CODE				 = new HtmlInputText();
		COMP_PAC_PERIOD					 = new HtmlInputText();
		COMP_PAC_PREM_PAY_YRS				 = new HtmlInputText();
		COMP_PAC_MAX_AGE_ON_MAT				 = new HtmlInputText();
		COMP_PAC_MAT_PAYEE_AGE				 = new HtmlInputText();
		COMP_PAC_MAT_PAYER_AGE				 = new HtmlInputText();
		COMP_PAC_COVER_START_AGE			 = new HtmlInputText();
		COMP_PAC_BCH_CODE				 = new HtmlInputText();
		COMP_PAC_PRODUCTION_PERC			 = new HtmlInputText();
		COMP_PAC_THRESHOLD_PERC				 = new HtmlInputText();
		COMP_PAC_MED_DAYS				 = new HtmlInputText();
		COMP_PAC_MED_AMT				 = new HtmlInputText();
		COMP_PAC_GRP_THRESHOLD_PERC			 = new HtmlInputText();
		COMP_UI_M_PAC_COVER_CODE_DESC			 = new HtmlInputText();
		COMP_UI_M_PAC_BCH_CODE_DESC			 = new HtmlInputText();
		COMP_PAC_SA_ADD_FACTOR				 = new HtmlInputText();
		COMP_PAC_SA_FACTOR				 = new HtmlInputText();
		COMP_PAC_SA_TARIFF				 = new HtmlInputText();
		COMP_PAC_PREM_TARIFF				 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_PAC_MANDATORY_YN				 = new HtmlSelectOneMenu();
		COMP_PAC_DEFAULT_YN				 = new HtmlSelectOneMenu();
		COMP_PAC_TARIFF_TERM_FLAG			 = new HtmlSelectOneMenu();
		COMP_PAC_RSA_CALC_YN				 = new HtmlSelectOneMenu();
		COMP_PAC_BCH_TERM				 = new HtmlSelectOneMenu();
		COMP_PAC_COVER_ASSR_TYPE			 = new HtmlSelectOneMenu();
		COMP_PAC_AGE_BASIS                   = new HtmlSelectOneMenu();
		COMP_PAC_COVER_START_AGE_VAL_YN      = new HtmlSelectOneMenu();
		/*added by gopi for ssp call id ZBILQC-1719437 on 27/01/17*/
		COMP_PAC_ATT_CVR_YN = new HtmlSelectOneMenu();
		/*end*/
		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_PAC_BCH_CODE_LOV			 = new HtmlCommandButton();
		COMP_PAC_COOL_OF_PD = new HtmlInputText();
	}

	public HtmlOutputLabel getCOMP_PAC_COOL_OF_PD_LABEL() {
		return COMP_PAC_COOL_OF_PD_LABEL;
	}

	public void setCOMP_PAC_COOL_OF_PD_LABEL(
			HtmlOutputLabel comp_pac_cool_of_pd_label) {
		COMP_PAC_COOL_OF_PD_LABEL = comp_pac_cool_of_pd_label;
	}

	public HtmlInputText getCOMP_PAC_COOL_OF_PD() {
		return COMP_PAC_COOL_OF_PD;
	}

	public void setCOMP_PAC_COOL_OF_PD(HtmlInputText comp_pac_cool_of_pd) {
		COMP_PAC_COOL_OF_PD = comp_pac_cool_of_pd;
	}

	public HtmlOutputLabel getCOMP_PAC_AGE_BASIS_LABEL() {
		return COMP_PAC_AGE_BASIS_LABEL;
	}

	public void setCOMP_PAC_AGE_BASIS_LABEL(HtmlOutputLabel comp_pac_age_basis_label) {
		COMP_PAC_AGE_BASIS_LABEL = comp_pac_age_basis_label;
	}

	public HtmlOutputLabel getCOMP_PAC_COVER_START_AGE_VAL_YN_LABEL() {
		return COMP_PAC_COVER_START_AGE_VAL_YN_LABEL;
	}

	public void setCOMP_PAC_COVER_START_AGE_VAL_YN_LABEL(
			HtmlOutputLabel comp_pac_cover_start_age_val_yn_label) {
		COMP_PAC_COVER_START_AGE_VAL_YN_LABEL = comp_pac_cover_start_age_val_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_PAC_AGE_BASIS() {
		return COMP_PAC_AGE_BASIS;
	}

	public void setCOMP_PAC_AGE_BASIS(HtmlSelectOneMenu comp_pac_age_basis) {
		COMP_PAC_AGE_BASIS = comp_pac_age_basis;
	}

	public HtmlSelectOneMenu getCOMP_PAC_COVER_START_AGE_VAL_YN() {
		return COMP_PAC_COVER_START_AGE_VAL_YN;
	}

	public void setCOMP_PAC_COVER_START_AGE_VAL_YN(
			HtmlSelectOneMenu comp_pac_cover_start_age_val_yn) {
		COMP_PAC_COVER_START_AGE_VAL_YN = comp_pac_cover_start_age_val_yn;
	}

	public List<SelectItem> getListPAC_AGE_BASIS() {
		if (listPAC_AGE_BASIS.size() == 0) {
			listPAC_AGE_BASIS.clear();
			try {
				listPAC_AGE_BASIS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_AGE_BASIS;
	}

	public void setListPAC_AGE_BASIS(List<SelectItem> listPAC_AGE_BASIS) {
		this.listPAC_AGE_BASIS = listPAC_AGE_BASIS;
	}

	public List<SelectItem> getListPAC_COVER_START_AGE_VAL_YN() {
		if (listPAC_COVER_START_AGE_VAL_YN.size() == 0) {
			listPAC_COVER_START_AGE_VAL_YN.clear();
			try {
				listPAC_COVER_START_AGE_VAL_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listPAC_COVER_START_AGE_VAL_YN;
	}

	public void setListPAC_COVER_START_AGE_VAL_YN(
			List<SelectItem> listPAC_COVER_START_AGE_VAL_YN) {
		this.listPAC_COVER_START_AGE_VAL_YN = listPAC_COVER_START_AGE_VAL_YN;
	}

	/*Added by Ram on 19/11/2016 for Product Cover Attached field addition*/
	private HtmlOutputLabel COMP_ATTACHED_PAC_COVER_CODE_LABEL;
	private HtmlInputText COMP_ATTACHED_UI_M_PAC_COVER_CODE_DESC;
	private HtmlInputText COMP_ATTACHED_PAC_COVER_CODE;

	public HtmlOutputLabel getCOMP_ATTACHED_PAC_COVER_CODE_LABEL() {
		return COMP_ATTACHED_PAC_COVER_CODE_LABEL;
	}

	public void setCOMP_ATTACHED_PAC_COVER_CODE_LABEL(
			HtmlOutputLabel cOMP_ATTACHED_PAC_COVER_CODE_LABEL) {
		COMP_ATTACHED_PAC_COVER_CODE_LABEL = cOMP_ATTACHED_PAC_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATTACHED_UI_M_PAC_COVER_CODE_DESC() {
		return COMP_ATTACHED_UI_M_PAC_COVER_CODE_DESC;
	}

	public void setCOMP_ATTACHED_UI_M_PAC_COVER_CODE_DESC(
			HtmlInputText cOMP_ATTACHED_UI_M_PAC_COVER_CODE_DESC) {
		COMP_ATTACHED_UI_M_PAC_COVER_CODE_DESC = cOMP_ATTACHED_UI_M_PAC_COVER_CODE_DESC;
	}

	public HtmlInputText getCOMP_ATTACHED_PAC_COVER_CODE() {
		return COMP_ATTACHED_PAC_COVER_CODE;
	}

	public void setCOMP_ATTACHED_PAC_COVER_CODE(
			HtmlInputText cOMP_ATTACHED_PAC_COVER_CODE) {
		COMP_ATTACHED_PAC_COVER_CODE = cOMP_ATTACHED_PAC_COVER_CODE;
	}
	
	public void PAC_ATTHACHED_COVER_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_IL_PROD_APPL_COVER_BEAN.setPAC_ATT_CVR_CODE((String) value);
			 
			COMP_PAC_COVER_CODE.resetValue();
			COMP_UI_M_PAC_COVER_CODE_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	/*End*/
}
