package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlTab;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM003_APAC.PILM003_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILM003_APAC.PM_IL_PLAN_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PRODUCT_ACTION extends CommonAction {

	private PM_IL_PRODUCT PM_IL_PRODUCT_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PRODUCT_HELPER helper;

	public PM_IL_PRODUCT_DELEGATE delegate = new PM_IL_PRODUCT_DELEGATE();

	private HtmlTab COMP_MORE_INFO_1;

	private HtmlTab COMP_MORE_INFO_2;

	private HtmlTab COMP_MORE_INFO_3;
	
	private HtmlTab COMP_REM_INFO_4;
	
	private HtmlTab COMP_REM_INFO_5;
	
	private HtmlTab COMP_ANNUITY_PARAPETERS_TAB;
	
	private HtmlTab COMP_INSURED_AGE_TAB;

	private HtmlOutputLabel COMP_PROD_CODE_LABEL;

	private HtmlInputText COMP_PROD_CODE;

	private HtmlOutputLabel COMP_PROD_DESC_LABEL;

	private HtmlInputText COMP_PROD_DESC;

	private HtmlOutputLabel COMP_PROD_LONG_DESC_LABEL;

	private HtmlInputText COMP_PROD_LONG_DESC;

	private HtmlOutputLabel COMP_PROD_SHORT_DESC_LABEL;

	private HtmlInputText COMP_PROD_SHORT_DESC;

	private HtmlOutputLabel COMP_PROD_PLAN_CODE_LABEL;

	private HtmlInputText COMP_PROD_PLAN_CODE;

	private HtmlOutputLabel COMP_UI_M_PROD_PLAN_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_PLAN_CODE_DESC;

	private HtmlOutputLabel COMP_PROD_PERIOD_LABEL;

	private HtmlInputText COMP_PROD_PERIOD;

	private HtmlOutputLabel COMP_PROD_AGE_CALC_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PROD_AGE_CALC_FLAG;

	private HtmlOutputLabel COMP_PROD_PREM_PAY_YRS_LABEL;

	private HtmlInputText COMP_PROD_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_PROD_TARIFF_TERM_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PROD_TARIFF_TERM_FLAG;

	private HtmlOutputLabel COMP_PROD_JOINT_LIFE_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_JOINT_LIFE_YN;

	private HtmlOutputLabel COMP_PROD_SA_INST_PYMT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PROD_SA_INST_PYMT_TYPE;

	private HtmlOutputLabel COMP_PROD_PERIOD_MULTIPLE_LABEL;

	private HtmlInputText COMP_PROD_PERIOD_MULTIPLE;

	private HtmlOutputLabel COMP_PROD_DS_CODE_LABEL;

	private HtmlInputText COMP_PROD_DS_CODE;

	private HtmlOutputLabel COMP_UI_M_PROD_DS_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_DS_CODE_DESC;

	private HtmlOutputLabel COMP_PROD_PRODUCT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PROD_PRODUCT_TYPE;

	private HtmlOutputLabel COMP_PROD_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_PROD_EFF_FM_DT;

	private HtmlOutputLabel COMP_PROD_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_PROD_EFF_TO_DT;

	private HtmlOutputLabel COMP_PROD_SA_BY_PLAN_BASIS_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_SA_BY_PLAN_BASIS_YN;

	private HtmlOutputLabel COMP_PROD_FUND_ALLOWED_LABEL;

	private HtmlSelectOneMenu COMP_PROD_FUND_ALLOWED;

	private HtmlOutputLabel COMP_PROD_TOL_CHK_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_TOL_CHK_YN;

	private HtmlOutputLabel COMP_PROD_MASTER_CERT_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_MASTER_CERT_YN;

	private HtmlOutputLabel COMP_PROD_BL_DESC_LABEL;

	private HtmlInputText COMP_PROD_BL_DESC;

	private HtmlOutputLabel COMP_PROD_BL_SHORT_DESC_LABEL;

	private HtmlInputText COMP_PROD_BL_SHORT_DESC;

	private HtmlOutputLabel COMP_PROD_BL_LONG_DESC_LABEL;

	private HtmlInputText COMP_PROD_BL_LONG_DESC;

	private HtmlOutputLabel COMP_PROD_COOLOFF_DAYS_LABEL;

	private HtmlInputText COMP_PROD_COOLOFF_DAYS;

	private HtmlOutputLabel COMP_PROD_THRESHOLD_PERC_LABEL;

	private HtmlInputText COMP_PROD_THRESHOLD_PERC;

	private HtmlOutputLabel COMP_PROD_MATU_DT_LABEL;

	private HtmlSelectOneMenu COMP_PROD_MATU_DT;

	private HtmlOutputLabel COMP_PROD_EMI_TOLERANCE_LABEL;

	private HtmlInputText COMP_PROD_EMI_TOLERANCE;

	private HtmlOutputLabel COMP_PROD_DEF_PERIOD_FM_LABEL;

	private HtmlInputText COMP_PROD_DEF_PERIOD_FM;

	private HtmlOutputLabel COMP_PROD_DEF_PERIOD_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PROD_DEF_PERIOD_FLAG;

	private HtmlOutputLabel COMP_PROD_DEF_PERIOD_TO_LABEL;

	private HtmlInputText COMP_PROD_DEF_PERIOD_TO;

	private HtmlOutputLabel COMP_PROD_MAX_DEFER_MONTHS_LABEL;

	private HtmlInputText COMP_PROD_MAX_DEFER_MONTHS;

	private HtmlOutputLabel COMP_PROD_ENDT_VAL_DAYS_LABEL;

	private HtmlInputText COMP_PROD_ENDT_VAL_DAYS;

	private HtmlOutputLabel COMP_PROD_DRIP_LIMIT_LABEL;

	private HtmlSelectOneMenu COMP_PROD_DRIP_LIMIT;

	private HtmlOutputLabel COMP_PROD_MAT_AMT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PROD_MAT_AMT_TYPE;

	private HtmlOutputLabel COMP_PROD_SURR_PLUS_FACTOR_LABEL;

	private HtmlInputText COMP_PROD_SURR_PLUS_FACTOR;

	private HtmlOutputLabel COMP_PROD_SURR_PLUS_FACTOR_DESC_LABEL;

	private HtmlInputText COMP_PROD_SURR_PLUS_FACTOR_DESC;

	private HtmlOutputLabel COMP_PROD_PREM_CALC_MTHD_LABEL;

	private HtmlSelectOneMenu COMP_PROD_PREM_CALC_MTHD;

	private HtmlOutputLabel COMP_PROD_RSA_CALC_TYP_LABEL;

	private HtmlSelectOneMenu COMP_PROD_RSA_CALC_TYP;

	private HtmlOutputLabel COMP_PROD_MRTA_RATE_CALC_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_MRTA_RATE_CALC_YN;

	private HtmlOutputLabel COMP_PROD_WAQAF_PERIOD_FM_LABEL;

	private HtmlInputText COMP_PROD_WAQAF_PERIOD_FM;

	private HtmlOutputLabel COMP_PROD_WAQAF_PERIOD_TO_LABEL;

	private HtmlInputText COMP_PROD_WAQAF_PERIOD_TO;

	private HtmlOutputLabel COMP_PROD_CBC_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_CBC_YN;

	private HtmlOutputLabel COMP_PROD_DRIP_MTHD_LABEL;

	private HtmlSelectOneMenu COMP_PROD_DRIP_MTHD;

	private HtmlOutputLabel COMP_PROD_MAT_RATE_LABEL;

	private HtmlInputText COMP_PROD_MAT_RATE;

	private HtmlOutputLabel COMP_PROD_MAT_RATE_PER_LABEL;

	private HtmlInputText COMP_PROD_MAT_RATE_PER;

	private HtmlOutputLabel COMP_PROD_AUTO_APPROV_LABEL;

	private HtmlSelectOneMenu COMP_PROD_AUTO_APPROV;

	private HtmlOutputLabel COMP_PROD_CONT_LOAD_RATE_LABEL;

	private HtmlInputText COMP_PROD_CONT_LOAD_RATE;

	private HtmlOutputLabel COMP_PROD_CONT_LOAD_RATE_PER_LABEL;

	private HtmlInputText COMP_PROD_CONT_LOAD_RATE_PER;

	private HtmlOutputLabel COMP_PROD_SA_FACTOR_LABEL;

	private HtmlInputText COMP_PROD_SA_FACTOR;

	private HtmlOutputLabel COMP_UI_M_PROD_SA_FACTOR_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_SA_FACTOR_DESC;

	private HtmlOutputLabel COMP_PROD_SURR_CALC_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PROD_SURR_CALC_TYPE;

	private HtmlOutputLabel COMP_PROD_SURRENDER_FACTOR_LABEL;

	private HtmlInputText COMP_PROD_SURRENDER_FACTOR;

	private HtmlOutputLabel COMP_PROD_SURRENDER_FACTOR_DESC_LABEL;

	private HtmlInputText COMP_PROD_SURRENDER_FACTOR_DESC;

	private HtmlOutputLabel COMP_PROD_AUTO_UW_LABEL;

	private HtmlSelectOneMenu COMP_PROD_AUTO_UW;

	private HtmlOutputLabel COMP_PROD_EXP_LOAD_RATE_LABEL;

	private HtmlInputText COMP_PROD_EXP_LOAD_RATE;

	private HtmlOutputLabel COMP_PROD_EXP_LOAD_RATE_PER_LABEL;

	private HtmlInputText COMP_PROD_EXP_LOAD_RATE_PER;

	private HtmlOutputLabel COMP_PROD_SA_TARIFF_LABEL;

	private HtmlInputText COMP_PROD_SA_TARIFF;

	private HtmlOutputLabel COMP_UI_M_PROD_SA_TARIFF_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_SA_TARIFF_DESC;

	private HtmlOutputLabel COMP_PROD_WAKFEE_FACTOR_LABEL;

	private HtmlInputText COMP_PROD_WAKFEE_FACTOR;

	private HtmlOutputLabel COMP_PROD_WAKFEE_FACTOR_DESC_LABEL;

	private HtmlInputText COMP_PROD_WAKFEE_FACTOR_DESC;

	private HtmlOutputLabel COMP_PROD_MIN_SURR_AMT_LABEL;

	private HtmlInputText COMP_PROD_MIN_SURR_AMT;

	private HtmlOutputLabel COMP_PROD_ROUND_OPTION_LABEL;

	private HtmlSelectOneMenu COMP_PROD_ROUND_OPTION;

	private HtmlOutputLabel COMP_PROD_ROUND_VALUE_LABEL;

	private HtmlInputText COMP_PROD_ROUND_VALUE;

	private HtmlOutputLabel COMP_PROD_INST_BASIS_LABEL;

	private HtmlSelectOneMenu COMP_PROD_INST_BASIS;

	private HtmlOutputLabel COMP_PROD_AGE_SET_BACK_LABEL;

	private HtmlInputText COMP_PROD_AGE_SET_BACK;

	private HtmlOutputLabel COMP_PROD_SA_ADD_FACTOR_LABEL;

	private HtmlInputText COMP_PROD_SA_ADD_FACTOR;

	private HtmlOutputLabel COMP_UI_M_PROD_SA_ADD_FACTOR_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_SA_ADD_FACTOR_DESC;

	private HtmlOutputLabel COMP_PROD_MODE_OF_CALC_LABEL;

	private HtmlSelectOneMenu COMP_PROD_MODE_OF_CALC;

	private HtmlOutputLabel COMP_PROD_INST_RATE_PER_LABEL;

	private HtmlInputText COMP_PROD_INST_RATE_PER;

	private HtmlOutputLabel COMP_PROD_INST_PERC_LABEL;

	private HtmlInputText COMP_PROD_INST_PERC;

	private HtmlOutputLabel COMP_PROD_PREM_TARIFF_LABEL;

	private HtmlInputText COMP_PROD_PREM_TARIFF;

	private HtmlOutputLabel COMP_UI_M_PROD_PREM_TARIFF_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_PREM_TARIFF_DESC;

	private HtmlOutputLabel COMP_PROD_WITHDRAW_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_WITHDRAW_YN;

	private HtmlOutputLabel COMP_PROD_WITHDRAW_AMT_MULTIPLE_LABEL;

	private HtmlInputText COMP_PROD_WITHDRAW_AMT_MULTIPLE;

	private HtmlOutputLabel COMP_PROD_AFTWD_LC_MINBAL_LABEL;

	private HtmlInputText COMP_PROD_AFTWD_LC_MINBAL;

	private HtmlOutputLabel COMP_PROD_THR_BASIS_LABEL;

	private HtmlSelectOneMenu COMP_PROD_THR_BASIS;

	private HtmlOutputLabel COMP_PROD_GRP_THRESHOLD_PERC_LABEL;

	private HtmlInputText COMP_PROD_GRP_THRESHOLD_PERC;

	private HtmlOutputLabel COMP_PROD_RI_RECOV_BASIS_LABEL;

	private HtmlSelectOneMenu COMP_PROD_RI_RECOV_BASIS;

	private HtmlOutputLabel COMP_PROD_MORT_CODE_LABEL;

	private HtmlInputText COMP_PROD_MORT_CODE;

	private HtmlOutputLabel COMP_PROD_BUY_BASIS_LABEL;

	private HtmlSelectOneMenu COMP_PROD_BUY_BASIS;

	private HtmlOutputLabel COMP_UI_M_PROD_MORT_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_MORT_CODE_DESC;

	private HtmlOutputLabel COMP_PROD_LOAD_CHARGE_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_LOAD_CHARGE_YN;

	private HtmlOutputLabel COMP_PROD_TOPUP_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_TOPUP_YN;

	private HtmlOutputLabel COMP_PROD_TOPUP_MIN_YRS_LABEL;

	private HtmlInputText COMP_PROD_TOPUP_MIN_YRS;

	private HtmlOutputLabel COMP_PROD_TOLL_LIMIT_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_TOLL_LIMIT_YN;

	private HtmlOutputLabel COMP_PROD_ALLOC_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PROD_ALLOC_TYPE;

	private HtmlOutputLabel COMP_PROD_INTER_FUND_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_INTER_FUND_YN;

	private HtmlOutputLabel COMP_PROD_SERVICE_TAX_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_SERVICE_TAX_YN;

	private HtmlOutputLabel COMP_PROD_TOPUP_PROD_PERC_LABEL;

	private HtmlInputText COMP_PROD_TOPUP_PROD_PERC;

	private HtmlOutputLabel COMP_PROD_TOPUP_COMM_CODE_LABEL;

	private HtmlInputText COMP_PROD_TOPUP_COMM_CODE;

	private HtmlOutputLabel COMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION_LABEL;

	private HtmlInputText COMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION;

	private HtmlOutputLabel COMP_PROD_CALC_ALLOC_LABEL;

	private HtmlSelectOneMenu COMP_PROD_CALC_ALLOC;

	private HtmlOutputLabel COMP_PROD_TOPUP_CHARGE_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PROD_TOPUP_CHARGE_TYPE;

	private HtmlOutputLabel COMP_PROD_FUND_FEE_LABEL;

	private HtmlInputText COMP_PROD_FUND_FEE;

	private HtmlOutputLabel COMP_PROD_FUND_FEE_RATE_PER_LABEL;

	private HtmlInputText COMP_PROD_FUND_FEE_RATE_PER;

	private HtmlOutputLabel COMP_PROD_AGENT_HIRE_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_AGENT_HIRE_YN;

	private HtmlOutputLabel COMP_PROD_TRAN_RATE_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_TRAN_RATE_YN;

	private HtmlOutputLabel COMP_PROD_PREM_HOLIDAY_CODE_LABEL;

	private HtmlInputText COMP_PROD_PREM_HOLIDAY_CODE;

	private HtmlOutputLabel COMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC;

	private HtmlOutputLabel COMP_PROD_TOPUP_MULTIPLE_LABEL;

	private HtmlInputText COMP_PROD_TOPUP_MULTIPLE;

	private HtmlOutputLabel COMP_PROD_TOPUP_WAK_CODE_LABEL;

	private HtmlInputText COMP_PROD_TOPUP_WAK_CODE;

	private HtmlOutputLabel COMP_UI_M_PROD_WAK_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_WAK_CODE_DESC;

	private HtmlOutputLabel COMP_PROD_BCH_CODE_LABEL;

	private HtmlInputText COMP_PROD_BCH_CODE;

	private HtmlOutputLabel COMP_UI_M_PROD_BCH_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_BCH_CODE_DESC;

	private HtmlOutputLabel COMP_PROD_BROK_CALC_MTHD_LABEL;

	private HtmlSelectOneMenu COMP_PROD_BROK_CALC_MTHD;

	private HtmlOutputLabel COMP_PROD_COMM_RND_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PROD_COMM_RND_TYPE;

	private HtmlOutputLabel COMP_PROD_COMM_RND_DEC_LABEL;

	private HtmlInputText COMP_PROD_COMM_RND_DEC;

	private HtmlOutputLabel COMP_PROD_PRODUCTION_PERC_LABEL;

	private HtmlInputText COMP_PROD_PRODUCTION_PERC;
	
	private HtmlOutputLabel COMP_PROD_SAL_MULTIPLE_LABEL;
	
	private HtmlInputText COMP_PROD_SAL_MULTIPLE;

	private HtmlCommandButton COMP_UI_M_BUT_BILINGUAL;

	private HtmlCommandButton COMP_APPL_SUB_PLANS;

	private HtmlCommandButton COMP_UI_M_BUT_DS_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_EDIT_PROD_DESC;

	private HtmlCommandButton COMP_UI_M_EDIT_PROD_LOND_DESC;

	private HtmlCommandButton COMP_UI_M_EDIT_PROD_SHORT_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_PROD_PLAN_CODE;

	private HtmlCommandButton COMP_UI_M_COPY_BUTT;

	private HtmlCommandButton COMP_UI_M_BUT_WITHDRAW_DETAIL;

	private HtmlCommandButton COMP_UI_M_BUT_TOP_UP_DETAIL;

	private HtmlOutputLabel COMP_PROD_MIN_SA_LABEL;
	
	private HtmlInputText COMP_PROD_MIN_SA;

	private HtmlOutputLabel COMP_PROD_MAX_SA_LABEL;

	private HtmlInputText COMP_PROD_MAX_SA;

	private HtmlOutputLabel COMP_PROD_SURR_YRS_LABEL;

	private HtmlInputText COMP_PROD_SURR_YRS;

	private HtmlOutputLabel COMP_PROD_MAX_AGE_ON_MAT_LABEL;

	private HtmlInputText COMP_PROD_MAX_AGE_ON_MAT;

	private HtmlOutputLabel COMP_PROD_POL_VALID_AFTER_MAT_YN_LABEL;

	private HtmlOutputLabel COMP_PROD_INS_AGE_FM_LABEL;
	
	private HtmlOutputLabel COMP_PROD_INS_AGE_TO_LABEL;
	
	private HtmlOutputLabel COMP_PROD_INS_SA_FM_LABEL;
	
	private HtmlOutputLabel COMP_PROD_INS_SA_TO_LABEL;
	
	private HtmlOutputLabel COMP_PROD_INS_TM_FM_LABEL;
	
	private HtmlOutputLabel COMP_PROD_INS_TM_TO_LABEL;
	
	private HtmlInputText COMP_PROD_INS_AGE_FM;
	
	private HtmlInputText COMP_PROD_INS_AGE_TO;
	
	private HtmlInputText COMP_PROD_INS_SA_FM;
	
	private HtmlInputText COMP_PROD_INS_SA_TO;
	
	private HtmlInputText COMP_PROD_INS_TM_FM;
	
	private HtmlInputText COMP_PROD_INS_TM_TO;
	
	
	
	
	
	private HtmlSelectOneMenu COMP_PROD_INS_APL_YN;
	
	private HtmlOutputLabel COMP_PROD_INS_APL_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_PROD_POL_VALID_AFTER_MAT_YN;

	private List<SelectItem> listPROD_AGE_CALC_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_TARIFF_TERM_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_JOINT_LIFE_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_SA_INST_PYMT_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_PRODUCT_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_SA_BY_PLAN_BASIS_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_MASTER_CERT_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_POL_VALID_AFTER_MAT_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_MATU_DT = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_DEF_PERIOD_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_MAT_AMT_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_PREM_CALC_MTHD = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_RSA_CALC_TYP = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_MRTA_RATE_CALC_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_CBC_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_DRIP_MTHD = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_AUTO_APPROV = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_SURR_CALC_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_AUTO_UW = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_ROUND_OPTION = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_INST_BASIS = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_MODE_OF_CALC = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_WITHDRAW_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_THR_BASIS = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_RI_RECOV_BASIS = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_TOPUP_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_TOLL_LIMIT_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_INTER_FUND_YN = new ArrayList<SelectItem>();
	/*added by gopi for RM018T - DEV_IL_ZB Life_022-Automated Premium Loan*/
	private List<SelectItem> listPROD_APL_YN = new ArrayList<SelectItem>();

	public List<SelectItem> getListPROD_APL_YN() {
		if (listPROD_APL_YN.size() == 0) {
			listPROD_APL_YN.clear();
			try {
				listPROD_APL_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_APL_YN;
	}

	public void setListPROD_APL_YN(List<SelectItem> listPROD_APL_YN) {
		this.listPROD_APL_YN = listPROD_APL_YN;
	}
	/*end*/
	
	/*added  by gopi for toi on 14/06/18*/
	
	private List<SelectItem> listPROD_POL_APPROVAL_YN = new ArrayList<SelectItem>();
	
	public List<SelectItem> getListPROD_POL_APPROVAL_YN() {
		
		if (listPROD_POL_APPROVAL_YN.size() == 0) {
			listPROD_POL_APPROVAL_YN.clear();
			try {
				listPROD_POL_APPROVAL_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return listPROD_POL_APPROVAL_YN;
	}

	public void setListPROD_POL_APPROVAL_YN(
			List<SelectItem> listPROD_POL_APPROVAL_YN) {
		this.listPROD_POL_APPROVAL_YN = listPROD_POL_APPROVAL_YN;
	}
	//end
	private List<SelectItem> listPROD_BUY_BASIS = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_LOAD_CHARGE_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_ALLOC_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_SERVICE_TAX_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_AGENT_HIRE_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_TOPUP_CHARGE_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_CALC_ALLOC = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_BROK_CALC_MTHD = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_COMM_RND_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_FUND_ALLOWED = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_TOL_CHK_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_DRIP_LIMIT = new ArrayList<SelectItem>();

	private List<SelectItem> listPROD_TRAN_RATE_YN = new ArrayList<SelectItem>();
	
	private List<SelectItem> listAPL_YN = new ArrayList<SelectItem>();
	
	//Addded by akash to implement reminder on product label;
	
	private HtmlOutputLabel COMP_PROD_REM_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_PROD_REM_YN;
	
	private HtmlOutputLabel COMP_PROD_REM_1_LABEL;
	
	private HtmlInputText COMP_PROD_REM_1;
	
	private HtmlOutputLabel COMP_PROD_REM_2_LABEL;
	
	private HtmlInputText COMP_PROD_REM_2;
	
	private HtmlOutputLabel COMP_PROD_REM_3_LABEL;
	
	private HtmlInputText COMP_PROD_REM_3;
	
	//Added bY Haneef
	//added by saranya on 22-07-2016
	public PM_IL_PLAN_ACTION Plan_action;
	
	public PILM003_APAC_COMPOSITE_ACTION plan_composite_Action;
	
	private HtmlOutputLabel COMP_PROD_INC_WEIGHT_LABEL;
	private HtmlInputText   COMP_PROD_INC_WEIGHT;
    private HtmlGraphicImage COMP_PROD_WAKFEE_FACTOR_IMAGE;
    private HtmlGraphicImage COMP_UI_M_PROD_WAK_CODE_IMAGE;
    private HtmlGraphicImage COMP_PROD_SURR_PLUS_FACTOR_IMAGE;
	public HtmlGraphicImage getCOMP_PROD_SURR_PLUS_FACTOR_IMAGE() {
		return COMP_PROD_SURR_PLUS_FACTOR_IMAGE;
	}

	public void setCOMP_PROD_SURR_PLUS_FACTOR_IMAGE(
			HtmlGraphicImage comp_prod_surr_plus_factor_image) {
		COMP_PROD_SURR_PLUS_FACTOR_IMAGE = comp_prod_surr_plus_factor_image;
	}

	public HtmlGraphicImage getCOMP_PROD_WAKFEE_FACTOR_IMAGE() {
		return COMP_PROD_WAKFEE_FACTOR_IMAGE;
	}

	public void setCOMP_PROD_WAKFEE_FACTOR_IMAGE(
			HtmlGraphicImage comp_prod_wakfee_factor_image) {
		COMP_PROD_WAKFEE_FACTOR_IMAGE = comp_prod_wakfee_factor_image;
	}

	public HtmlGraphicImage getCOMP_UI_M_PROD_WAK_CODE_IMAGE() {
		return COMP_UI_M_PROD_WAK_CODE_IMAGE;
	}

	public void setCOMP_UI_M_PROD_WAK_CODE_IMAGE(
			HtmlGraphicImage comp_ui_m_prod_wak_code_image) {
		COMP_UI_M_PROD_WAK_CODE_IMAGE = comp_ui_m_prod_wak_code_image;
	}

	public HtmlOutputLabel getCOMP_PROD_INC_WEIGHT_LABEL() {
		return COMP_PROD_INC_WEIGHT_LABEL;
	}

	public void setCOMP_PROD_INC_WEIGHT_LABEL(
			HtmlOutputLabel comp_prod_inc_weight_label) {
		COMP_PROD_INC_WEIGHT_LABEL = comp_prod_inc_weight_label;
	}

	public HtmlInputText getCOMP_PROD_INC_WEIGHT() {
		return COMP_PROD_INC_WEIGHT;
	}

	public void setCOMP_PROD_INC_WEIGHT(HtmlInputText comp_prod_inc_weight) {
		COMP_PROD_INC_WEIGHT = comp_prod_inc_weight;
	}

	public List<SelectItem> getListPROD_TRAN_RATE_YN() {
		return listPROD_TRAN_RATE_YN;
	}

	public void setListPROD_TRAN_RATE_YN(List<SelectItem> listPROD_TRAN_RATE_YN) {
		this.listPROD_TRAN_RATE_YN = listPROD_TRAN_RATE_YN;
	}

	public List<SelectItem> getListPROD_FUND_ALLOWED() {
		return listPROD_FUND_ALLOWED;
	}

	public void setListPROD_FUND_ALLOWED(List<SelectItem> listPROD_FUND_ALLOWED) {
		this.listPROD_FUND_ALLOWED = listPROD_FUND_ALLOWED;
	}

	public List<SelectItem> getListPROD_TOL_CHK_YN() {
		return listPROD_TOL_CHK_YN;
	}

	public void setListPROD_TOL_CHK_YN(List<SelectItem> listPROD_TOL_CHK_YN) {
		this.listPROD_TOL_CHK_YN = listPROD_TOL_CHK_YN;
	}

	public HtmlTab getCOMP_ANNUITY_PARAPETERS_TAB() {
		return COMP_ANNUITY_PARAPETERS_TAB;
	}

	public void setCOMP_ANNUITY_PARAPETERS_TAB(HtmlTab comp_annuity_parapeters_tab) {
		COMP_ANNUITY_PARAPETERS_TAB = comp_annuity_parapeters_tab;
	}
	
	//added by saranya
	private HtmlOutputLabel COMP_PROD_FORMULA_SURR_LABEL;	

	private HtmlInputText COMP_PROD_FORMULA_SURR;
	
	private HtmlInputText COMP_UI_PROD_FORMULA_SURR_DESC;
	
	private HtmlOutputLabel COMP_PROD_PAIDUP_FORMULA_LABEL;

	private HtmlInputText COMP_PROD_PAIDUP_FORMULA;
	
	private HtmlInputText COMP_UI_PROD_PAIDUP_FORMULA_DESC;


	public HtmlOutputLabel getCOMP_PROD_PAIDUP_FORMULA_LABEL() {
		return COMP_PROD_PAIDUP_FORMULA_LABEL;
	}

	public void setCOMP_PROD_PAIDUP_FORMULA_LABEL(
			HtmlOutputLabel cOMP_PROD_PAIDUP_FORMULA_LABEL) {
		COMP_PROD_PAIDUP_FORMULA_LABEL = cOMP_PROD_PAIDUP_FORMULA_LABEL;
	}

	public HtmlInputText getCOMP_PROD_PAIDUP_FORMULA() {
		return COMP_PROD_PAIDUP_FORMULA;
	}

	public void setCOMP_PROD_PAIDUP_FORMULA(HtmlInputText cOMP_PROD_PAIDUP_FORMULA) {
		COMP_PROD_PAIDUP_FORMULA = cOMP_PROD_PAIDUP_FORMULA;
	}

	public HtmlInputText getCOMP_UI_PROD_PAIDUP_FORMULA_DESC() {
		return COMP_UI_PROD_PAIDUP_FORMULA_DESC;
	}

	public void setCOMP_UI_PROD_PAIDUP_FORMULA_DESC(
			HtmlInputText cOMP_UI_PROD_PAIDUP_FORMULA_DESC) {
		COMP_UI_PROD_PAIDUP_FORMULA_DESC = cOMP_UI_PROD_PAIDUP_FORMULA_DESC;
	}

	public HtmlInputText getCOMP_UI_PROD_FORMULA_SURR_DESC() {
		return COMP_UI_PROD_FORMULA_SURR_DESC;
	}

	public void setCOMP_UI_PROD_FORMULA_SURR_DESC(
			HtmlInputText cOMP_UI_PROD_FORMULA_SURR_DESC) {
		COMP_UI_PROD_FORMULA_SURR_DESC = cOMP_UI_PROD_FORMULA_SURR_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_FORMULA_SURR_LABEL() {
		return COMP_PROD_FORMULA_SURR_LABEL;
	}

	public void setCOMP_PROD_FORMULA_SURR_LABEL(
			HtmlOutputLabel cOMP_PROD_FORMULA_SURR_LABEL) {
		COMP_PROD_FORMULA_SURR_LABEL = cOMP_PROD_FORMULA_SURR_LABEL;
	}

	public HtmlInputText getCOMP_PROD_FORMULA_SURR() {
		return COMP_PROD_FORMULA_SURR;
	}

	public void setCOMP_PROD_FORMULA_SURR(HtmlInputText cOMP_PROD_FORMULA_SURR) {
		COMP_PROD_FORMULA_SURR = cOMP_PROD_FORMULA_SURR;
	}
	//end

	public PM_IL_PRODUCT_ACTION() {
		COMP_PROD_SA_FACTOR=new HtmlInputText();
		COMP_PROD_SA_ADD_FACTOR = new HtmlInputText();
		COMP_PROD_TRAN_RATE_YN = new HtmlSelectOneMenu();
		COMP_UI_M_BUT_WITHDRAW_DETAIL = new HtmlCommandButton();
		/*Added sankaranarayanan for hospitalcashplan  on 21-04-2017*/
		 COMP_PROD_INTR_SAVINGS_YN_LABEL=new HtmlOutputLabel();
    	  COMP_PROD_INTR_SAVINGS_YN=new HtmlSelectOneMenu();
    	  //end
    	  /*Added by Ameen on 13-03-2018 for FSD_IL_04_GOLDA*/
    	  COMP_PROD_MAT_AMT_LEVEL = new HtmlSelectOneMenu();
    	  /*End*/
		PM_IL_PRODUCT_BEAN = new PM_IL_PRODUCT();
		helper = new PM_IL_PRODUCT_HELPER();
		prepareDropDowns();
	}
	
	public int calcMethod() throws Exception{
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		Integer value = null;
		try {
			con = CommonUtils.getConnection();
			String C1 = "SELECT PS_VALUE  FROM   PP_SYSTEM "
				+ "WHERE  PS_TYPE = 'IL_CALC_MTHD'";
		rs1 = handler.executeSelectStatement(C1, con);
		if (rs1.next()) {
			value =rs1.getInt(1);
		}
		return value;
		}catch(Exception e){
			e.printStackTrace();
			throw e ;
			}
		}
	

	private void prepareDropDowns() {
		try{
			List<SelectItem> list = new ArrayList<SelectItem>();
			int calcMeth = calcMethod();
			list.add(new SelectItem("",""));
			/*Added by saranya on 30/12/2016 for RM018T - FSD_IL_ZB Life_028-Cash Back*/
			setListPROD_CASHBACK_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_CASHBACK_YN",
					"YESNO"));
			/*End*/
			
			/*Added by saranya on 13/02/2017 for Unit Link Product as per the Girish Suggessted*/
			setListPROD_RISK_FACTOR_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_RISK_FACTOR_YN",
					"YESNO"));
			/*End*/
			/*Added saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 13-03-2017*/
			setListPROD_UNIT_LINK_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_UNIT_LINK_TYPE",
					"IL_UL_TYPE"));
			/*End*/
			setListPROD_AGE_CALC_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_AGE_CALC_FLAG",
					"CALFLAG"));

			setListPROD_TARIFF_TERM_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_TARIFF_TERM_FLAG",
					"TRMFLAG"));

			setListPROD_JOINT_LIFE_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_JOINT_LIFE_YN",
					"YESNO"));

			setListPROD_SA_INST_PYMT_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_SA_INST_PYMT_TYPE",
					"PTYPE"));

			setListPROD_PRODUCT_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_PRODUCT_TYPE",
					"IL_PROD_UT"));

			setListPROD_SA_BY_PLAN_BASIS_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_SA_BY_PLAN_BASIS_YN",
					"YESNO"));

			setListPROD_MASTER_CERT_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_MASTER_CERT_YN",
					"YESNO"));
			setListPROD_POL_VALID_AFTER_MAT_YN(ListItemUtil
					.getDropDownListValue(CommonUtils.getConnection(),
							"PILM035_APAC", "PM_IL_PRODUCT",
							"PM_IL_PRODUCT.PROD_POL_VALID_AFTER_MAT_YN",
							"YESNO"));
			setListPROD_MATU_DT(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC", "PM_IL_PRODUCT",
					"PM_IL_PRODUCT.PROD_MATU_DT", "IL_MATU_DT"));
			setListPROD_CBC_YN(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC", "PM_IL_PRODUCT",
					"PM_IL_PRODUCT.PROD_CBC_YN", "YESNO"));
			setListPROD_DRIP_MTHD(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC", "PM_IL_PRODUCT",
					"PM_IL_PRODUCT.PROD_DRIP_MTHD", "IL_DRIP_MTHD"));

			setListPROD_PREM_CALC_MTHD(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_PREM_CALC_MTHD",
					"IL_PCALC_MTD"));
			setListPROD_AUTO_APPROV(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_AUTO_APPROV", "YESNO"));
			setListPROD_AUTO_UW(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC", "PM_IL_PRODUCT",
					"PM_IL_PRODUCT.PROD_AUTO_UW", "YESNO"));
			setListPROD_ROUND_OPTION(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_ROUND_OPTION",
					"IL_ROUND"));
			setListPROD_MODE_OF_CALC(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_MODE_OF_CALC",
					"IL_MODE_CALC"));
			setListPROD_THR_BASIS(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC", "PM_IL_PRODUCT",
					"PM_IL_PRODUCT.PROD_THR_BASIS", "IL_THR_BASIS"));
			setListPROD_TOLL_LIMIT_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_TOLL_LIMIT_YN",
					"YESNO"));
			setListPROD_INTER_FUND_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_INTER_FUND_YN",
					"YESNO"));
/*			added by gopi for RM018T - DEV_IL_ZB Life_022-Automated Premium Loan*/			
			setListPROD_APL_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_APL_YN",
					"YESNO"));
		/*	end*/
			
			
			
			/*added by gopi for toi on 14/06/18*/
			setListPROD_POL_APPROVAL_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_POL_APPROVAL_YN",
					"IL_POL_APP"));
			//end
			
			setListPROD_RI_RECOV_BASIS(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_RI_RECOV_BASIS",
					"IL_RI_RECOV"));
			setListPROD_LOAD_CHARGE_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_LOAD_CHARGE_YN",
					"YESNO"));
			setListPROD_SERVICE_TAX_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_SERVICE_TAX_YN",
					"YESNO"));
			setListPROD_AGENT_HIRE_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_AGENT_HIRE_YN",
					"YESNO"));
			setListPROD_BROK_CALC_MTHD(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_BROK_CALC_MTHD",
					"IL_BROK_COMM"));
			setListPROD_COMM_RND_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_COMM_RND_TYPE",
					"COMRNDMTD"));
			setListPROD_DEF_PERIOD_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_DEF_PERIOD_FLAG",
					"IL_DEF_PER"));
			setListPROD_RSA_CALC_TYP(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_RSA_CALC_TYP",
					"IL_RSA_TYP"));
			setListPROD_MRTA_RATE_CALC_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_MRTA_RATE_CALC_YN",
					"RATE_CALC"));
			setListPROD_INST_BASIS(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_INST_BASIS",
					"IL_INST_BASI"));
			setListPROD_BUY_BASIS(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC", "PM_IL_PRODUCT",
					"PM_IL_PRODUCT.PROD_BUY_BASIS", "APTRDT"));
			setListPROD_ALLOC_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_ALLOC_TYPE", "NON"));
			setListPROD_CALC_ALLOC(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_CALC_ALLOC",
					"PRODALLOC"));
			if(calcMeth==1){
			setListPROD_MAT_AMT_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_MAT_AMT_TYPE_TAK",
					"IL_MAT_AMT_T"));
			setListPROD_SURR_CALC_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_SURR_CALC_TYPE_TAK",
					"SUR_CAL_TYPT"));
			}else{
				setListPROD_MAT_AMT_TYPE(ListItemUtil.getDropDownListValue(
						CommonUtils.getConnection(), "PILM035_APAC",
						"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_MAT_AMT_TYPE",
						"IL_MAT_AMT"));	
				setListPROD_SURR_CALC_TYPE(ListItemUtil.getDropDownListValue(
						CommonUtils.getConnection(), "PILM035_APAC",
						"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_SURR_CALC_TYPE",
						"SUR_CAL_TYP"));
			}
			setListPROD_WITHDRAW_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_WITHDRAW_YN", "YESNO"));
			setListPROD_TOPUP_YN(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC", "PM_IL_PRODUCT",
					"PM_IL_PRODUCT.PROD_TOPUP_YN", "YESNO"));
			setListPROD_TOPUP_CHARGE_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_TOPUP_CHARGE_TYPE",
					"TOPUPFEE"));
			setListPROD_FUND_ALLOWED(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_FUND_ALLOWED",
					"IL_FUND_ALLW"));
			setListPROD_TOL_CHK_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_TOL_CHK_YN", "YESNO"));
			setListPROD_DRIP_LIMIT(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_DRIP_LIMIT",
					"IL_DRIP_LMT"));
			setListPROD_TRAN_RATE_YN(ListItemUtil
					.getDropDownListValue(CommonUtils.getConnection(),
							"PILM035_APAC", "PM_IL_PRODUCT",
							"PM_IL_PRODUCT.PROD_TRAN_RATE_YN", "YESNO"));
			
/*Added sankaranarayanan for hospitalcashplan  on 21-04-2017*/
			
			setListPROD_INTR_SAVINGS_YN(ListItemUtil
					.getDropDownListValue(CommonUtils.getConnection(),
							"PILM035_APAC", "PM_IL_PRODUCT",
							"PM_IL_PRODUCT.PROD_INTR_SAVINGS_YN", "YESNO"));
			/*end*/
			
			/*added by Ameen on 31-10-2017 to add PROD_RI_SA_CALC_TYP as per Chandramohan sugg.*/
			setListPROD_RI_SA_CALC_TYP(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_RI_SA_CALC_TYP",
					"IL_RI_SA_TYP"));
			/*End*/
			
			/*Added by Janani on 04.01.2018 for ZBLIFE-1459615*/
			setListPROD_PUP_YN(ListItemUtil
					.getDropDownListValue(CommonUtils.getConnection(),
							"PILM035_APAC", "PM_IL_PRODUCT",
							"PM_IL_PRODUCT.PROD_PAIDUP_YN", "YESNO"));
			
			/*End*/
			
			List<SelectItem> list2 = new ArrayList<SelectItem>();
			list2.add(new SelectItem("Y","Yes"));
			list2.add(new SelectItem("N","No"));
			setListAPL_YN(list2);
			
			/*Added by Ameen on 15-02-2018 for kic*/
			setListPROD_RET_PREM_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_RET_PREM_YN",
					"YESNO"));
			/*End*/
			/*Added by Ameen on 09-03-2018 for FSD_IL_04_GOLDA*/
			setListPROD_REG_EXCESS_APP_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_REG_EXCESS_APP_YN",
					"YESNO"));
			
			setListPROD_MAT_AMT_LEVEL(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_MAT_AMT_LEVEL",
					"IL_MAT_PC"));
			/*End*/
			
			/*Added by Janani on 18.04.2018 for Fidelity period calc*/
			setListPROD_CALC_TERM_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_RET_PREM_YN",
					"YESNO"));
			
			
			setListPROD_RIDER_APPL_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_RET_PREM_YN",
					"YESNO"));
			
			
			/*End*/
			
			/*Added by Janani on 15.06.2018 for KIC*/
			
			setListPROD_NGTV_SUS_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_RET_PREM_YN",
					"YESNO"));
			
			/*End*/
			
			/*Added by Janani on 25.06.2018 for  FSD_IL_FLA_006_Monetary Endorsement Module*/
			setListPROD_AGENT_PREM_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_AGENT_PREM_TYPE",
					"AGN_PRM_TYP"));
			/*End*/
			
			
			/*Added by Janani on 05.07.2018 for FLALIFEQC-1512859 */
			setListPROD_PREM_PAYING_YRS(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_PREM_PAYING_YRS",
					"IL_PREM_PAY"));
			/*End*/
			/*Newly added by pidugu raj dt: 09-07-2020 as suggested by kk and sitrasan for Alliance IL*/
			setListPROD_SUB_DT_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_SUB_DT_YN",
					"YESNO"));
			/*End Newly added by pidugu raj dt: 09-07-2020 as suggested by kk and sitrasan for Alliance IL*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_PROD_CODE_LABEL() {
		return COMP_PROD_CODE_LABEL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TOP_UP_DETAIL() {
		return COMP_UI_M_BUT_TOP_UP_DETAIL;
	}

	public HtmlTab getCOMP_MORE_INFO_1() {
		return COMP_MORE_INFO_1;
	}

	public void setCOMP_MORE_INFO_1(HtmlTab comp_more_info_1) {
		COMP_MORE_INFO_1 = comp_more_info_1;
	}

	public HtmlTab getCOMP_MORE_INFO_2() {
		return COMP_MORE_INFO_2;
	}

	public void setCOMP_MORE_INFO_2(HtmlTab comp_more_info_2) {
		COMP_MORE_INFO_2 = comp_more_info_2;
	}

	public HtmlTab getCOMP_MORE_INFO_3() {
		return COMP_MORE_INFO_3;
	}

	public void setCOMP_MORE_INFO_3(HtmlTab comp_more_info_3) {
		COMP_MORE_INFO_3 = comp_more_info_3;
	}

	public void setCOMP_UI_M_BUT_TOP_UP_DETAIL(
			HtmlCommandButton comp_ui_m_but_top_up_detail) {
		COMP_UI_M_BUT_TOP_UP_DETAIL = comp_ui_m_but_top_up_detail;
	}

	public HtmlInputText getCOMP_PROD_CODE() {
		return COMP_PROD_CODE;
	}

	public void setCOMP_PROD_CODE_LABEL(HtmlOutputLabel COMP_PROD_CODE_LABEL) {
		this.COMP_PROD_CODE_LABEL = COMP_PROD_CODE_LABEL;
	}

	public void setCOMP_PROD_CODE(HtmlInputText COMP_PROD_CODE) {
		this.COMP_PROD_CODE = COMP_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_PROD_DESC_LABEL() {
		return COMP_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_DESC() {
		return COMP_PROD_DESC;
	}

	public void setCOMP_PROD_DESC_LABEL(HtmlOutputLabel COMP_PROD_DESC_LABEL) {
		this.COMP_PROD_DESC_LABEL = COMP_PROD_DESC_LABEL;
	}

	public void setCOMP_PROD_DESC(HtmlInputText COMP_PROD_DESC) {
		this.COMP_PROD_DESC = COMP_PROD_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_LONG_DESC_LABEL() {
		return COMP_PROD_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_LONG_DESC() {
		return COMP_PROD_LONG_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_WITHDRAW_DETAIL() {
		return COMP_UI_M_BUT_WITHDRAW_DETAIL;
	}

	public void setCOMP_UI_M_BUT_WITHDRAW_DETAIL(
			HtmlCommandButton comp_ui_m_but_withdraw_detail) {
		COMP_UI_M_BUT_WITHDRAW_DETAIL = comp_ui_m_but_withdraw_detail;
	}

	public void setCOMP_PROD_LONG_DESC_LABEL(
			HtmlOutputLabel COMP_PROD_LONG_DESC_LABEL) {
		this.COMP_PROD_LONG_DESC_LABEL = COMP_PROD_LONG_DESC_LABEL;
	}

	public void setCOMP_PROD_LONG_DESC(HtmlInputText COMP_PROD_LONG_DESC) {
		this.COMP_PROD_LONG_DESC = COMP_PROD_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_SHORT_DESC_LABEL() {
		return COMP_PROD_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_SHORT_DESC() {
		return COMP_PROD_SHORT_DESC;
	}

	public void setCOMP_PROD_SHORT_DESC_LABEL(
			HtmlOutputLabel COMP_PROD_SHORT_DESC_LABEL) {
		this.COMP_PROD_SHORT_DESC_LABEL = COMP_PROD_SHORT_DESC_LABEL;
	}

	public void setCOMP_PROD_SHORT_DESC(HtmlInputText COMP_PROD_SHORT_DESC) {
		this.COMP_PROD_SHORT_DESC = COMP_PROD_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_PLAN_CODE_LABEL() {
		return COMP_PROD_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_PLAN_CODE() {
		return COMP_PROD_PLAN_CODE;
	}

	public void setCOMP_PROD_PLAN_CODE_LABEL(
			HtmlOutputLabel COMP_PROD_PLAN_CODE_LABEL) {
		this.COMP_PROD_PLAN_CODE_LABEL = COMP_PROD_PLAN_CODE_LABEL;
	}

	public void setCOMP_PROD_PLAN_CODE(HtmlInputText COMP_PROD_PLAN_CODE) {
		this.COMP_PROD_PLAN_CODE = COMP_PROD_PLAN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_PLAN_CODE_DESC_LABEL() {
		return COMP_UI_M_PROD_PLAN_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_PLAN_CODE_DESC() {
		return COMP_UI_M_PROD_PLAN_CODE_DESC;
	}

	public void setCOMP_UI_M_PROD_PLAN_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_PLAN_CODE_DESC_LABEL) {
		this.COMP_UI_M_PROD_PLAN_CODE_DESC_LABEL = COMP_UI_M_PROD_PLAN_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_PLAN_CODE_DESC(
			HtmlInputText COMP_UI_M_PROD_PLAN_CODE_DESC) {
		this.COMP_UI_M_PROD_PLAN_CODE_DESC = COMP_UI_M_PROD_PLAN_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_PERIOD_LABEL() {
		return COMP_PROD_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_PROD_PERIOD() {
		return COMP_PROD_PERIOD;
	}

	public void setCOMP_PROD_PERIOD_LABEL(HtmlOutputLabel COMP_PROD_PERIOD_LABEL) {
		this.COMP_PROD_PERIOD_LABEL = COMP_PROD_PERIOD_LABEL;
	}

	public void setCOMP_PROD_PERIOD(HtmlInputText COMP_PROD_PERIOD) {
		this.COMP_PROD_PERIOD = COMP_PROD_PERIOD;
	}

	public HtmlOutputLabel getCOMP_PROD_AGE_CALC_FLAG_LABEL() {
		return COMP_PROD_AGE_CALC_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_AGE_CALC_FLAG() {
		return COMP_PROD_AGE_CALC_FLAG;
	}

	public void setCOMP_PROD_AGE_CALC_FLAG_LABEL(
			HtmlOutputLabel COMP_PROD_AGE_CALC_FLAG_LABEL) {
		this.COMP_PROD_AGE_CALC_FLAG_LABEL = COMP_PROD_AGE_CALC_FLAG_LABEL;
	}

	public void setCOMP_PROD_AGE_CALC_FLAG(
			HtmlSelectOneMenu COMP_PROD_AGE_CALC_FLAG) {
		this.COMP_PROD_AGE_CALC_FLAG = COMP_PROD_AGE_CALC_FLAG;
	}

	public HtmlOutputLabel getCOMP_PROD_PREM_PAY_YRS_LABEL() {
		return COMP_PROD_PREM_PAY_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PROD_PREM_PAY_YRS() {
		return COMP_PROD_PREM_PAY_YRS;
	}

	public void setCOMP_PROD_PREM_PAY_YRS_LABEL(
			HtmlOutputLabel COMP_PROD_PREM_PAY_YRS_LABEL) {
		this.COMP_PROD_PREM_PAY_YRS_LABEL = COMP_PROD_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_PROD_PREM_PAY_YRS(HtmlInputText COMP_PROD_PREM_PAY_YRS) {
		this.COMP_PROD_PREM_PAY_YRS = COMP_PROD_PREM_PAY_YRS;
	}

	public HtmlOutputLabel getCOMP_PROD_TARIFF_TERM_FLAG_LABEL() {
		return COMP_PROD_TARIFF_TERM_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_TARIFF_TERM_FLAG() {
		return COMP_PROD_TARIFF_TERM_FLAG;
	}

	public void setCOMP_PROD_TARIFF_TERM_FLAG_LABEL(
			HtmlOutputLabel COMP_PROD_TARIFF_TERM_FLAG_LABEL) {
		this.COMP_PROD_TARIFF_TERM_FLAG_LABEL = COMP_PROD_TARIFF_TERM_FLAG_LABEL;
	}

	public void setCOMP_PROD_TARIFF_TERM_FLAG(
			HtmlSelectOneMenu COMP_PROD_TARIFF_TERM_FLAG) {
		this.COMP_PROD_TARIFF_TERM_FLAG = COMP_PROD_TARIFF_TERM_FLAG;
	}

	public HtmlOutputLabel getCOMP_PROD_JOINT_LIFE_YN_LABEL() {
		return COMP_PROD_JOINT_LIFE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_JOINT_LIFE_YN() {
		return COMP_PROD_JOINT_LIFE_YN;
	}

	public void setCOMP_PROD_JOINT_LIFE_YN_LABEL(
			HtmlOutputLabel COMP_PROD_JOINT_LIFE_YN_LABEL) {
		this.COMP_PROD_JOINT_LIFE_YN_LABEL = COMP_PROD_JOINT_LIFE_YN_LABEL;
	}

	public void setCOMP_PROD_JOINT_LIFE_YN(
			HtmlSelectOneMenu COMP_PROD_JOINT_LIFE_YN) {
		this.COMP_PROD_JOINT_LIFE_YN = COMP_PROD_JOINT_LIFE_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_SA_INST_PYMT_TYPE_LABEL() {
		return COMP_PROD_SA_INST_PYMT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_SA_INST_PYMT_TYPE() {
		return COMP_PROD_SA_INST_PYMT_TYPE;
	}

	public void setCOMP_PROD_SA_INST_PYMT_TYPE_LABEL(
			HtmlOutputLabel COMP_PROD_SA_INST_PYMT_TYPE_LABEL) {
		this.COMP_PROD_SA_INST_PYMT_TYPE_LABEL = COMP_PROD_SA_INST_PYMT_TYPE_LABEL;
	}

	public void setCOMP_PROD_SA_INST_PYMT_TYPE(
			HtmlSelectOneMenu COMP_PROD_SA_INST_PYMT_TYPE) {
		this.COMP_PROD_SA_INST_PYMT_TYPE = COMP_PROD_SA_INST_PYMT_TYPE;
	}

	public HtmlOutputLabel getCOMP_PROD_PERIOD_MULTIPLE_LABEL() {
		return COMP_PROD_PERIOD_MULTIPLE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_PERIOD_MULTIPLE() {
		return COMP_PROD_PERIOD_MULTIPLE;
	}

	public void setCOMP_PROD_PERIOD_MULTIPLE_LABEL(
			HtmlOutputLabel COMP_PROD_PERIOD_MULTIPLE_LABEL) {
		this.COMP_PROD_PERIOD_MULTIPLE_LABEL = COMP_PROD_PERIOD_MULTIPLE_LABEL;
	}

	public void setCOMP_PROD_PERIOD_MULTIPLE(
			HtmlInputText COMP_PROD_PERIOD_MULTIPLE) {
		this.COMP_PROD_PERIOD_MULTIPLE = COMP_PROD_PERIOD_MULTIPLE;
	}

	public HtmlOutputLabel getCOMP_PROD_DS_CODE_LABEL() {
		return COMP_PROD_DS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_DS_CODE() {
		return COMP_PROD_DS_CODE;
	}

	public void setCOMP_PROD_DS_CODE_LABEL(
			HtmlOutputLabel COMP_PROD_DS_CODE_LABEL) {
		this.COMP_PROD_DS_CODE_LABEL = COMP_PROD_DS_CODE_LABEL;
	}

	public void setCOMP_PROD_DS_CODE(HtmlInputText COMP_PROD_DS_CODE) {
		this.COMP_PROD_DS_CODE = COMP_PROD_DS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_DS_CODE_DESC_LABEL() {
		return COMP_UI_M_PROD_DS_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_DS_CODE_DESC() {
		return COMP_UI_M_PROD_DS_CODE_DESC;
	}

	public void setCOMP_UI_M_PROD_DS_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_DS_CODE_DESC_LABEL) {
		this.COMP_UI_M_PROD_DS_CODE_DESC_LABEL = COMP_UI_M_PROD_DS_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_DS_CODE_DESC(
			HtmlInputText COMP_UI_M_PROD_DS_CODE_DESC) {
		this.COMP_UI_M_PROD_DS_CODE_DESC = COMP_UI_M_PROD_DS_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_PRODUCT_TYPE_LABEL() {
		return COMP_PROD_PRODUCT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_PRODUCT_TYPE() {
		return COMP_PROD_PRODUCT_TYPE;
	}

	public void setCOMP_PROD_PRODUCT_TYPE_LABEL(
			HtmlOutputLabel COMP_PROD_PRODUCT_TYPE_LABEL) {
		this.COMP_PROD_PRODUCT_TYPE_LABEL = COMP_PROD_PRODUCT_TYPE_LABEL;
	}

	public void setCOMP_PROD_PRODUCT_TYPE(
			HtmlSelectOneMenu COMP_PROD_PRODUCT_TYPE) {
		this.COMP_PROD_PRODUCT_TYPE = COMP_PROD_PRODUCT_TYPE;
	}

	public HtmlOutputLabel getCOMP_PROD_EFF_FM_DT_LABEL() {
		return COMP_PROD_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PROD_EFF_FM_DT() {
		return COMP_PROD_EFF_FM_DT;
	}

	public void setCOMP_PROD_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_PROD_EFF_FM_DT_LABEL) {
		this.COMP_PROD_EFF_FM_DT_LABEL = COMP_PROD_EFF_FM_DT_LABEL;
	}

	public void setCOMP_PROD_EFF_FM_DT(HtmlCalendar COMP_PROD_EFF_FM_DT) {
		this.COMP_PROD_EFF_FM_DT = COMP_PROD_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_PROD_EFF_TO_DT_LABEL() {
		return COMP_PROD_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PROD_EFF_TO_DT() {
		return COMP_PROD_EFF_TO_DT;
	}

	public void setCOMP_PROD_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_PROD_EFF_TO_DT_LABEL) {
		this.COMP_PROD_EFF_TO_DT_LABEL = COMP_PROD_EFF_TO_DT_LABEL;
	}

	public void setCOMP_PROD_EFF_TO_DT(HtmlCalendar COMP_PROD_EFF_TO_DT) {
		this.COMP_PROD_EFF_TO_DT = COMP_PROD_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_PROD_SA_BY_PLAN_BASIS_YN_LABEL() {
		return COMP_PROD_SA_BY_PLAN_BASIS_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_SA_BY_PLAN_BASIS_YN() {
		return COMP_PROD_SA_BY_PLAN_BASIS_YN;
	}

	public void setCOMP_PROD_SA_BY_PLAN_BASIS_YN_LABEL(
			HtmlOutputLabel COMP_PROD_SA_BY_PLAN_BASIS_YN_LABEL) {
		this.COMP_PROD_SA_BY_PLAN_BASIS_YN_LABEL = COMP_PROD_SA_BY_PLAN_BASIS_YN_LABEL;
	}

	public void setCOMP_PROD_SA_BY_PLAN_BASIS_YN(
			HtmlSelectOneMenu COMP_PROD_SA_BY_PLAN_BASIS_YN) {
		this.COMP_PROD_SA_BY_PLAN_BASIS_YN = COMP_PROD_SA_BY_PLAN_BASIS_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_MIN_SA_LABEL() {
		return COMP_PROD_MIN_SA_LABEL;
	}

	public HtmlInputText getCOMP_PROD_MIN_SA() {
		return COMP_PROD_MIN_SA;
	}

	public void setCOMP_PROD_MIN_SA_LABEL(HtmlOutputLabel COMP_PROD_MIN_SA_LABEL) {
		this.COMP_PROD_MIN_SA_LABEL = COMP_PROD_MIN_SA_LABEL;
	}

	public void setCOMP_PROD_MIN_SA(HtmlInputText COMP_PROD_MIN_SA) {
		this.COMP_PROD_MIN_SA = COMP_PROD_MIN_SA;
	}

	public HtmlOutputLabel getCOMP_PROD_MAX_SA_LABEL() {
		return COMP_PROD_MAX_SA_LABEL;
	}

	public HtmlInputText getCOMP_PROD_MAX_SA() {
		return COMP_PROD_MAX_SA;
	}

	public void setCOMP_PROD_MAX_SA_LABEL(HtmlOutputLabel COMP_PROD_MAX_SA_LABEL) {
		this.COMP_PROD_MAX_SA_LABEL = COMP_PROD_MAX_SA_LABEL;
	}

	public void setCOMP_PROD_MAX_SA(HtmlInputText COMP_PROD_MAX_SA) {
		this.COMP_PROD_MAX_SA = COMP_PROD_MAX_SA;
	}

	public HtmlOutputLabel getCOMP_PROD_MASTER_CERT_YN_LABEL() {
		return COMP_PROD_MASTER_CERT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_MASTER_CERT_YN() {
		return COMP_PROD_MASTER_CERT_YN;
	}

	public void setCOMP_PROD_MASTER_CERT_YN_LABEL(
			HtmlOutputLabel COMP_PROD_MASTER_CERT_YN_LABEL) {
		this.COMP_PROD_MASTER_CERT_YN_LABEL = COMP_PROD_MASTER_CERT_YN_LABEL;
	}

	public void setCOMP_PROD_MASTER_CERT_YN(
			HtmlSelectOneMenu COMP_PROD_MASTER_CERT_YN) {
		this.COMP_PROD_MASTER_CERT_YN = COMP_PROD_MASTER_CERT_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_SURR_YRS_LABEL() {
		return COMP_PROD_SURR_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PROD_SURR_YRS() {
		return COMP_PROD_SURR_YRS;
	}

	public void setCOMP_PROD_SURR_YRS_LABEL(
			HtmlOutputLabel COMP_PROD_SURR_YRS_LABEL) {
		this.COMP_PROD_SURR_YRS_LABEL = COMP_PROD_SURR_YRS_LABEL;
	}

	public void setCOMP_PROD_SURR_YRS(HtmlInputText COMP_PROD_SURR_YRS) {
		this.COMP_PROD_SURR_YRS = COMP_PROD_SURR_YRS;
	}

	public HtmlOutputLabel getCOMP_PROD_MAX_AGE_ON_MAT_LABEL() {
		return COMP_PROD_MAX_AGE_ON_MAT_LABEL;
	}

	public HtmlInputText getCOMP_PROD_MAX_AGE_ON_MAT() {
		return COMP_PROD_MAX_AGE_ON_MAT;
	}

	public void setCOMP_PROD_MAX_AGE_ON_MAT_LABEL(
			HtmlOutputLabel COMP_PROD_MAX_AGE_ON_MAT_LABEL) {
		this.COMP_PROD_MAX_AGE_ON_MAT_LABEL = COMP_PROD_MAX_AGE_ON_MAT_LABEL;
	}

	public void setCOMP_PROD_MAX_AGE_ON_MAT(
			HtmlInputText COMP_PROD_MAX_AGE_ON_MAT) {
		this.COMP_PROD_MAX_AGE_ON_MAT = COMP_PROD_MAX_AGE_ON_MAT;
	}

	public HtmlOutputLabel getCOMP_PROD_POL_VALID_AFTER_MAT_YN_LABEL() {
		return COMP_PROD_POL_VALID_AFTER_MAT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_POL_VALID_AFTER_MAT_YN() {
		return COMP_PROD_POL_VALID_AFTER_MAT_YN;
	}

	public void setCOMP_PROD_POL_VALID_AFTER_MAT_YN_LABEL(
			HtmlOutputLabel COMP_PROD_POL_VALID_AFTER_MAT_YN_LABEL) {
		this.COMP_PROD_POL_VALID_AFTER_MAT_YN_LABEL = COMP_PROD_POL_VALID_AFTER_MAT_YN_LABEL;
	}

	public void setCOMP_PROD_POL_VALID_AFTER_MAT_YN(
			HtmlSelectOneMenu COMP_PROD_POL_VALID_AFTER_MAT_YN) {
		this.COMP_PROD_POL_VALID_AFTER_MAT_YN = COMP_PROD_POL_VALID_AFTER_MAT_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_BL_DESC_LABEL() {
		return COMP_PROD_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_BL_DESC() {
		return COMP_PROD_BL_DESC;
	}

	public void setCOMP_PROD_BL_DESC_LABEL(
			HtmlOutputLabel COMP_PROD_BL_DESC_LABEL) {
		this.COMP_PROD_BL_DESC_LABEL = COMP_PROD_BL_DESC_LABEL;
	}

	public void setCOMP_PROD_BL_DESC(HtmlInputText COMP_PROD_BL_DESC) {
		this.COMP_PROD_BL_DESC = COMP_PROD_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_BL_SHORT_DESC_LABEL() {
		return COMP_PROD_BL_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_BL_SHORT_DESC() {
		return COMP_PROD_BL_SHORT_DESC;
	}

	public void setCOMP_PROD_BL_SHORT_DESC_LABEL(
			HtmlOutputLabel COMP_PROD_BL_SHORT_DESC_LABEL) {
		this.COMP_PROD_BL_SHORT_DESC_LABEL = COMP_PROD_BL_SHORT_DESC_LABEL;
	}

	public void setCOMP_PROD_BL_SHORT_DESC(HtmlInputText COMP_PROD_BL_SHORT_DESC) {
		this.COMP_PROD_BL_SHORT_DESC = COMP_PROD_BL_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_BL_LONG_DESC_LABEL() {
		return COMP_PROD_BL_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_BL_LONG_DESC() {
		return COMP_PROD_BL_LONG_DESC;
	}

	public void setCOMP_PROD_BL_LONG_DESC_LABEL(
			HtmlOutputLabel COMP_PROD_BL_LONG_DESC_LABEL) {
		this.COMP_PROD_BL_LONG_DESC_LABEL = COMP_PROD_BL_LONG_DESC_LABEL;
	}

	public void setCOMP_PROD_BL_LONG_DESC(HtmlInputText COMP_PROD_BL_LONG_DESC) {
		this.COMP_PROD_BL_LONG_DESC = COMP_PROD_BL_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_COOLOFF_DAYS_LABEL() {
		return COMP_PROD_COOLOFF_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_PROD_COOLOFF_DAYS() {
		return COMP_PROD_COOLOFF_DAYS;
	}

	public void setCOMP_PROD_COOLOFF_DAYS_LABEL(
			HtmlOutputLabel COMP_PROD_COOLOFF_DAYS_LABEL) {
		this.COMP_PROD_COOLOFF_DAYS_LABEL = COMP_PROD_COOLOFF_DAYS_LABEL;
	}

	public void setCOMP_PROD_COOLOFF_DAYS(HtmlInputText COMP_PROD_COOLOFF_DAYS) {
		this.COMP_PROD_COOLOFF_DAYS = COMP_PROD_COOLOFF_DAYS;
	}

	public HtmlOutputLabel getCOMP_PROD_THRESHOLD_PERC_LABEL() {
		return COMP_PROD_THRESHOLD_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_THRESHOLD_PERC() {
		return COMP_PROD_THRESHOLD_PERC;
	}

	public void setCOMP_PROD_THRESHOLD_PERC_LABEL(
			HtmlOutputLabel COMP_PROD_THRESHOLD_PERC_LABEL) {
		this.COMP_PROD_THRESHOLD_PERC_LABEL = COMP_PROD_THRESHOLD_PERC_LABEL;
	}

	public void setCOMP_PROD_THRESHOLD_PERC(
			HtmlInputText COMP_PROD_THRESHOLD_PERC) {
		this.COMP_PROD_THRESHOLD_PERC = COMP_PROD_THRESHOLD_PERC;
	}

	public HtmlOutputLabel getCOMP_PROD_MATU_DT_LABEL() {
		return COMP_PROD_MATU_DT_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_MATU_DT() {
		return COMP_PROD_MATU_DT;
	}

	public void setCOMP_PROD_MATU_DT_LABEL(
			HtmlOutputLabel COMP_PROD_MATU_DT_LABEL) {
		this.COMP_PROD_MATU_DT_LABEL = COMP_PROD_MATU_DT_LABEL;
	}

	public void setCOMP_PROD_MATU_DT(HtmlSelectOneMenu COMP_PROD_MATU_DT) {
		this.COMP_PROD_MATU_DT = COMP_PROD_MATU_DT;
	}

	public HtmlOutputLabel getCOMP_PROD_EMI_TOLERANCE_LABEL() {
		return COMP_PROD_EMI_TOLERANCE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_EMI_TOLERANCE() {
		return COMP_PROD_EMI_TOLERANCE;
	}

	public void setCOMP_PROD_EMI_TOLERANCE_LABEL(
			HtmlOutputLabel COMP_PROD_EMI_TOLERANCE_LABEL) {
		this.COMP_PROD_EMI_TOLERANCE_LABEL = COMP_PROD_EMI_TOLERANCE_LABEL;
	}

	public void setCOMP_PROD_EMI_TOLERANCE(HtmlInputText COMP_PROD_EMI_TOLERANCE) {
		this.COMP_PROD_EMI_TOLERANCE = COMP_PROD_EMI_TOLERANCE;
	}

	public HtmlOutputLabel getCOMP_PROD_DEF_PERIOD_FLAG_LABEL() {
		return COMP_PROD_DEF_PERIOD_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_DEF_PERIOD_FLAG() {
		return COMP_PROD_DEF_PERIOD_FLAG;
	}

	public void setCOMP_PROD_DEF_PERIOD_FLAG_LABEL(
			HtmlOutputLabel COMP_PROD_DEF_PERIOD_FLAG_LABEL) {
		this.COMP_PROD_DEF_PERIOD_FLAG_LABEL = COMP_PROD_DEF_PERIOD_FLAG_LABEL;
	}

	public void setCOMP_PROD_DEF_PERIOD_FLAG(
			HtmlSelectOneMenu COMP_PROD_DEF_PERIOD_FLAG) {
		this.COMP_PROD_DEF_PERIOD_FLAG = COMP_PROD_DEF_PERIOD_FLAG;
	}

	public HtmlOutputLabel getCOMP_PROD_MAX_DEFER_MONTHS_LABEL() {
		return COMP_PROD_MAX_DEFER_MONTHS_LABEL;
	}

	public HtmlInputText getCOMP_PROD_MAX_DEFER_MONTHS() {
		return COMP_PROD_MAX_DEFER_MONTHS;
	}

	public void setCOMP_PROD_MAX_DEFER_MONTHS_LABEL(
			HtmlOutputLabel COMP_PROD_MAX_DEFER_MONTHS_LABEL) {
		this.COMP_PROD_MAX_DEFER_MONTHS_LABEL = COMP_PROD_MAX_DEFER_MONTHS_LABEL;
	}

	public void setCOMP_PROD_MAX_DEFER_MONTHS(
			HtmlInputText COMP_PROD_MAX_DEFER_MONTHS) {
		this.COMP_PROD_MAX_DEFER_MONTHS = COMP_PROD_MAX_DEFER_MONTHS;
	}

	public HtmlOutputLabel getCOMP_PROD_ENDT_VAL_DAYS_LABEL() {
		return COMP_PROD_ENDT_VAL_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_PROD_ENDT_VAL_DAYS() {
		return COMP_PROD_ENDT_VAL_DAYS;
	}

	public void setCOMP_PROD_ENDT_VAL_DAYS_LABEL(
			HtmlOutputLabel COMP_PROD_ENDT_VAL_DAYS_LABEL) {
		this.COMP_PROD_ENDT_VAL_DAYS_LABEL = COMP_PROD_ENDT_VAL_DAYS_LABEL;
	}

	public void setCOMP_PROD_ENDT_VAL_DAYS(HtmlInputText COMP_PROD_ENDT_VAL_DAYS) {
		this.COMP_PROD_ENDT_VAL_DAYS = COMP_PROD_ENDT_VAL_DAYS;
	}

	public HtmlOutputLabel getCOMP_PROD_MAT_AMT_TYPE_LABEL() {
		return COMP_PROD_MAT_AMT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_MAT_AMT_TYPE() {
		return COMP_PROD_MAT_AMT_TYPE;
	}

	public void setCOMP_PROD_MAT_AMT_TYPE_LABEL(
			HtmlOutputLabel COMP_PROD_MAT_AMT_TYPE_LABEL) {
		this.COMP_PROD_MAT_AMT_TYPE_LABEL = COMP_PROD_MAT_AMT_TYPE_LABEL;
	}

	public void setCOMP_PROD_MAT_AMT_TYPE(
			HtmlSelectOneMenu COMP_PROD_MAT_AMT_TYPE) {
		this.COMP_PROD_MAT_AMT_TYPE = COMP_PROD_MAT_AMT_TYPE;
	}

	public HtmlOutputLabel getCOMP_PROD_SURR_PLUS_FACTOR_LABEL() {
		return COMP_PROD_SURR_PLUS_FACTOR_LABEL;
	}

	public HtmlInputText getCOMP_PROD_SURR_PLUS_FACTOR() {
		return COMP_PROD_SURR_PLUS_FACTOR;
	}

	public void setCOMP_PROD_SURR_PLUS_FACTOR_LABEL(
			HtmlOutputLabel COMP_PROD_SURR_PLUS_FACTOR_LABEL) {
		this.COMP_PROD_SURR_PLUS_FACTOR_LABEL = COMP_PROD_SURR_PLUS_FACTOR_LABEL;
	}

	public void setCOMP_PROD_SURR_PLUS_FACTOR(
			HtmlInputText COMP_PROD_SURR_PLUS_FACTOR) {
		this.COMP_PROD_SURR_PLUS_FACTOR = COMP_PROD_SURR_PLUS_FACTOR;
	}

	public HtmlOutputLabel getCOMP_PROD_SURR_PLUS_FACTOR_DESC_LABEL() {
		return COMP_PROD_SURR_PLUS_FACTOR_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_SURR_PLUS_FACTOR_DESC() {
		return COMP_PROD_SURR_PLUS_FACTOR_DESC;
	}

	public void setCOMP_PROD_SURR_PLUS_FACTOR_DESC_LABEL(
			HtmlOutputLabel COMP_PROD_SURR_PLUS_FACTOR_DESC_LABEL) {
		this.COMP_PROD_SURR_PLUS_FACTOR_DESC_LABEL = COMP_PROD_SURR_PLUS_FACTOR_DESC_LABEL;
	}

	public void setCOMP_PROD_SURR_PLUS_FACTOR_DESC(
			HtmlInputText COMP_PROD_SURR_PLUS_FACTOR_DESC) {
		this.COMP_PROD_SURR_PLUS_FACTOR_DESC = COMP_PROD_SURR_PLUS_FACTOR_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_PREM_CALC_MTHD_LABEL() {
		return COMP_PROD_PREM_CALC_MTHD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_PREM_CALC_MTHD() {
		return COMP_PROD_PREM_CALC_MTHD;
	}

	public void setCOMP_PROD_PREM_CALC_MTHD_LABEL(
			HtmlOutputLabel COMP_PROD_PREM_CALC_MTHD_LABEL) {
		this.COMP_PROD_PREM_CALC_MTHD_LABEL = COMP_PROD_PREM_CALC_MTHD_LABEL;
	}

	public void setCOMP_PROD_PREM_CALC_MTHD(
			HtmlSelectOneMenu COMP_PROD_PREM_CALC_MTHD) {
		this.COMP_PROD_PREM_CALC_MTHD = COMP_PROD_PREM_CALC_MTHD;
	}

	public HtmlOutputLabel getCOMP_PROD_RSA_CALC_TYP_LABEL() {
		return COMP_PROD_RSA_CALC_TYP_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_RSA_CALC_TYP() {
		return COMP_PROD_RSA_CALC_TYP;
	}

	public void setCOMP_PROD_RSA_CALC_TYP_LABEL(
			HtmlOutputLabel COMP_PROD_RSA_CALC_TYP_LABEL) {
		this.COMP_PROD_RSA_CALC_TYP_LABEL = COMP_PROD_RSA_CALC_TYP_LABEL;
	}

	public void setCOMP_PROD_RSA_CALC_TYP(
			HtmlSelectOneMenu COMP_PROD_RSA_CALC_TYP) {
		this.COMP_PROD_RSA_CALC_TYP = COMP_PROD_RSA_CALC_TYP;
	}

	public HtmlOutputLabel getCOMP_PROD_MRTA_RATE_CALC_YN_LABEL() {
		return COMP_PROD_MRTA_RATE_CALC_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_MRTA_RATE_CALC_YN() {
		return COMP_PROD_MRTA_RATE_CALC_YN;
	}

	public void setCOMP_PROD_MRTA_RATE_CALC_YN_LABEL(
			HtmlOutputLabel COMP_PROD_MRTA_RATE_CALC_YN_LABEL) {
		this.COMP_PROD_MRTA_RATE_CALC_YN_LABEL = COMP_PROD_MRTA_RATE_CALC_YN_LABEL;
	}

	public void setCOMP_PROD_MRTA_RATE_CALC_YN(
			HtmlSelectOneMenu COMP_PROD_MRTA_RATE_CALC_YN) {
		this.COMP_PROD_MRTA_RATE_CALC_YN = COMP_PROD_MRTA_RATE_CALC_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_CBC_YN_LABEL() {
		return COMP_PROD_CBC_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_CBC_YN() {
		return COMP_PROD_CBC_YN;
	}

	public void setCOMP_PROD_CBC_YN_LABEL(HtmlOutputLabel COMP_PROD_CBC_YN_LABEL) {
		this.COMP_PROD_CBC_YN_LABEL = COMP_PROD_CBC_YN_LABEL;
	}

	public void setCOMP_PROD_CBC_YN(HtmlSelectOneMenu COMP_PROD_CBC_YN) {
		this.COMP_PROD_CBC_YN = COMP_PROD_CBC_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_DRIP_MTHD_LABEL() {
		return COMP_PROD_DRIP_MTHD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_DRIP_MTHD() {
		return COMP_PROD_DRIP_MTHD;
	}

	public void setCOMP_PROD_DRIP_MTHD_LABEL(
			HtmlOutputLabel COMP_PROD_DRIP_MTHD_LABEL) {
		this.COMP_PROD_DRIP_MTHD_LABEL = COMP_PROD_DRIP_MTHD_LABEL;
	}

	public void setCOMP_PROD_DRIP_MTHD(HtmlSelectOneMenu COMP_PROD_DRIP_MTHD) {
		this.COMP_PROD_DRIP_MTHD = COMP_PROD_DRIP_MTHD;
	}

	public HtmlOutputLabel getCOMP_PROD_MAT_RATE_LABEL() {
		return COMP_PROD_MAT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_MAT_RATE() {
		return COMP_PROD_MAT_RATE;
	}

	public void setCOMP_PROD_MAT_RATE_LABEL(
			HtmlOutputLabel COMP_PROD_MAT_RATE_LABEL) {
		this.COMP_PROD_MAT_RATE_LABEL = COMP_PROD_MAT_RATE_LABEL;
	}

	public void setCOMP_PROD_MAT_RATE(HtmlInputText COMP_PROD_MAT_RATE) {
		this.COMP_PROD_MAT_RATE = COMP_PROD_MAT_RATE;
	}

	public HtmlOutputLabel getCOMP_PROD_MAT_RATE_PER_LABEL() {
		return COMP_PROD_MAT_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PROD_MAT_RATE_PER() {
		return COMP_PROD_MAT_RATE_PER;
	}

	public void setCOMP_PROD_MAT_RATE_PER_LABEL(
			HtmlOutputLabel COMP_PROD_MAT_RATE_PER_LABEL) {
		this.COMP_PROD_MAT_RATE_PER_LABEL = COMP_PROD_MAT_RATE_PER_LABEL;
	}

	public void setCOMP_PROD_MAT_RATE_PER(HtmlInputText COMP_PROD_MAT_RATE_PER) {
		this.COMP_PROD_MAT_RATE_PER = COMP_PROD_MAT_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PROD_AUTO_APPROV_LABEL() {
		return COMP_PROD_AUTO_APPROV_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_AUTO_APPROV() {
		return COMP_PROD_AUTO_APPROV;
	}

	public void setCOMP_PROD_AUTO_APPROV_LABEL(
			HtmlOutputLabel COMP_PROD_AUTO_APPROV_LABEL) {
		this.COMP_PROD_AUTO_APPROV_LABEL = COMP_PROD_AUTO_APPROV_LABEL;
	}

	public void setCOMP_PROD_AUTO_APPROV(HtmlSelectOneMenu COMP_PROD_AUTO_APPROV) {
		this.COMP_PROD_AUTO_APPROV = COMP_PROD_AUTO_APPROV;
	}

	public HtmlOutputLabel getCOMP_PROD_CONT_LOAD_RATE_LABEL() {
		return COMP_PROD_CONT_LOAD_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_CONT_LOAD_RATE() {
		return COMP_PROD_CONT_LOAD_RATE;
	}

	public void setCOMP_PROD_CONT_LOAD_RATE_LABEL(
			HtmlOutputLabel COMP_PROD_CONT_LOAD_RATE_LABEL) {
		this.COMP_PROD_CONT_LOAD_RATE_LABEL = COMP_PROD_CONT_LOAD_RATE_LABEL;
	}

	public void setCOMP_PROD_CONT_LOAD_RATE(
			HtmlInputText COMP_PROD_CONT_LOAD_RATE) {
		this.COMP_PROD_CONT_LOAD_RATE = COMP_PROD_CONT_LOAD_RATE;
	}

	public HtmlOutputLabel getCOMP_PROD_CONT_LOAD_RATE_PER_LABEL() {
		return COMP_PROD_CONT_LOAD_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PROD_CONT_LOAD_RATE_PER() {
		return COMP_PROD_CONT_LOAD_RATE_PER;
	}

	public void setCOMP_PROD_CONT_LOAD_RATE_PER_LABEL(
			HtmlOutputLabel COMP_PROD_CONT_LOAD_RATE_PER_LABEL) {
		this.COMP_PROD_CONT_LOAD_RATE_PER_LABEL = COMP_PROD_CONT_LOAD_RATE_PER_LABEL;
	}

	public void setCOMP_PROD_CONT_LOAD_RATE_PER(
			HtmlInputText COMP_PROD_CONT_LOAD_RATE_PER) {
		this.COMP_PROD_CONT_LOAD_RATE_PER = COMP_PROD_CONT_LOAD_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PROD_SA_FACTOR_LABEL() {
		return COMP_PROD_SA_FACTOR_LABEL;
	}

	public HtmlInputText getCOMP_PROD_SA_FACTOR() {
		return COMP_PROD_SA_FACTOR;
	}

	public void setCOMP_PROD_SA_FACTOR_LABEL(
			HtmlOutputLabel COMP_PROD_SA_FACTOR_LABEL) {
		this.COMP_PROD_SA_FACTOR_LABEL = COMP_PROD_SA_FACTOR_LABEL;
	}

	public void setCOMP_PROD_SA_FACTOR(HtmlInputText COMP_PROD_SA_FACTOR) {
		this.COMP_PROD_SA_FACTOR = COMP_PROD_SA_FACTOR;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_SA_FACTOR_DESC_LABEL() {
		return COMP_UI_M_PROD_SA_FACTOR_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_SA_FACTOR_DESC() {
		return COMP_UI_M_PROD_SA_FACTOR_DESC;
	}

	public void setCOMP_UI_M_PROD_SA_FACTOR_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_SA_FACTOR_DESC_LABEL) {
		this.COMP_UI_M_PROD_SA_FACTOR_DESC_LABEL = COMP_UI_M_PROD_SA_FACTOR_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_SA_FACTOR_DESC(
			HtmlInputText COMP_UI_M_PROD_SA_FACTOR_DESC) {
		this.COMP_UI_M_PROD_SA_FACTOR_DESC = COMP_UI_M_PROD_SA_FACTOR_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_SURR_CALC_TYPE_LABEL() {
		return COMP_PROD_SURR_CALC_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_SURR_CALC_TYPE() {
		return COMP_PROD_SURR_CALC_TYPE;
	}

	public void setCOMP_PROD_SURR_CALC_TYPE_LABEL(
			HtmlOutputLabel COMP_PROD_SURR_CALC_TYPE_LABEL) {
		this.COMP_PROD_SURR_CALC_TYPE_LABEL = COMP_PROD_SURR_CALC_TYPE_LABEL;
	}

	public void setCOMP_PROD_SURR_CALC_TYPE(
			HtmlSelectOneMenu COMP_PROD_SURR_CALC_TYPE) {
		this.COMP_PROD_SURR_CALC_TYPE = COMP_PROD_SURR_CALC_TYPE;
	}

	public HtmlOutputLabel getCOMP_PROD_SURRENDER_FACTOR_DESC_LABEL() {
		return COMP_PROD_SURRENDER_FACTOR_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_SURRENDER_FACTOR_DESC() {
		return COMP_PROD_SURRENDER_FACTOR_DESC;
	}

	public void setCOMP_PROD_SURRENDER_FACTOR_DESC_LABEL(
			HtmlOutputLabel COMP_PROD_SURRENDER_FACTOR_DESC_LABEL) {
		this.COMP_PROD_SURRENDER_FACTOR_DESC_LABEL = COMP_PROD_SURRENDER_FACTOR_DESC_LABEL;
	}

	public void setCOMP_PROD_SURRENDER_FACTOR_DESC(
			HtmlInputText COMP_PROD_SURRENDER_FACTOR_DESC) {
		this.COMP_PROD_SURRENDER_FACTOR_DESC = COMP_PROD_SURRENDER_FACTOR_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_SURRENDER_FACTOR_LABEL() {
		return COMP_PROD_SURRENDER_FACTOR_LABEL;
	}

	public HtmlInputText getCOMP_PROD_SURRENDER_FACTOR() {
		return COMP_PROD_SURRENDER_FACTOR;
	}

	public void setCOMP_PROD_SURRENDER_FACTOR_LABEL(
			HtmlOutputLabel COMP_PROD_SURRENDER_FACTOR_LABEL) {
		this.COMP_PROD_SURRENDER_FACTOR_LABEL = COMP_PROD_SURRENDER_FACTOR_LABEL;
	}

	public void setCOMP_PROD_SURRENDER_FACTOR(
			HtmlInputText COMP_PROD_SURRENDER_FACTOR) {
		this.COMP_PROD_SURRENDER_FACTOR = COMP_PROD_SURRENDER_FACTOR;
	}

	public HtmlOutputLabel getCOMP_PROD_AUTO_UW_LABEL() {
		return COMP_PROD_AUTO_UW_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_AUTO_UW() {
		return COMP_PROD_AUTO_UW;
	}

	public void setCOMP_PROD_AUTO_UW_LABEL(
			HtmlOutputLabel COMP_PROD_AUTO_UW_LABEL) {
		this.COMP_PROD_AUTO_UW_LABEL = COMP_PROD_AUTO_UW_LABEL;
	}

	public void setCOMP_PROD_AUTO_UW(HtmlSelectOneMenu COMP_PROD_AUTO_UW) {
		this.COMP_PROD_AUTO_UW = COMP_PROD_AUTO_UW;
	}

	public HtmlOutputLabel getCOMP_PROD_EXP_LOAD_RATE_LABEL() {
		return COMP_PROD_EXP_LOAD_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_EXP_LOAD_RATE() {
		return COMP_PROD_EXP_LOAD_RATE;
	}

	public void setCOMP_PROD_EXP_LOAD_RATE_LABEL(
			HtmlOutputLabel COMP_PROD_EXP_LOAD_RATE_LABEL) {
		this.COMP_PROD_EXP_LOAD_RATE_LABEL = COMP_PROD_EXP_LOAD_RATE_LABEL;
	}

	public void setCOMP_PROD_EXP_LOAD_RATE(HtmlInputText COMP_PROD_EXP_LOAD_RATE) {
		this.COMP_PROD_EXP_LOAD_RATE = COMP_PROD_EXP_LOAD_RATE;
	}

	public HtmlOutputLabel getCOMP_PROD_EXP_LOAD_RATE_PER_LABEL() {
		return COMP_PROD_EXP_LOAD_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PROD_EXP_LOAD_RATE_PER() {
		return COMP_PROD_EXP_LOAD_RATE_PER;
	}

	public void setCOMP_PROD_EXP_LOAD_RATE_PER_LABEL(
			HtmlOutputLabel COMP_PROD_EXP_LOAD_RATE_PER_LABEL) {
		this.COMP_PROD_EXP_LOAD_RATE_PER_LABEL = COMP_PROD_EXP_LOAD_RATE_PER_LABEL;
	}

	public void setCOMP_PROD_EXP_LOAD_RATE_PER(
			HtmlInputText COMP_PROD_EXP_LOAD_RATE_PER) {
		this.COMP_PROD_EXP_LOAD_RATE_PER = COMP_PROD_EXP_LOAD_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PROD_SA_TARIFF_LABEL() {
		return COMP_PROD_SA_TARIFF_LABEL;
	}

	public HtmlInputText getCOMP_PROD_SA_TARIFF() {
		return COMP_PROD_SA_TARIFF;
	}

	public void setCOMP_PROD_SA_TARIFF_LABEL(
			HtmlOutputLabel COMP_PROD_SA_TARIFF_LABEL) {
		this.COMP_PROD_SA_TARIFF_LABEL = COMP_PROD_SA_TARIFF_LABEL;
	}

	public void setCOMP_PROD_SA_TARIFF(HtmlInputText COMP_PROD_SA_TARIFF) {
		this.COMP_PROD_SA_TARIFF = COMP_PROD_SA_TARIFF;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_SA_TARIFF_DESC_LABEL() {
		return COMP_UI_M_PROD_SA_TARIFF_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_SA_TARIFF_DESC() {
		return COMP_UI_M_PROD_SA_TARIFF_DESC;
	}

	public void setCOMP_UI_M_PROD_SA_TARIFF_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_SA_TARIFF_DESC_LABEL) {
		this.COMP_UI_M_PROD_SA_TARIFF_DESC_LABEL = COMP_UI_M_PROD_SA_TARIFF_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_SA_TARIFF_DESC(
			HtmlInputText COMP_UI_M_PROD_SA_TARIFF_DESC) {
		this.COMP_UI_M_PROD_SA_TARIFF_DESC = COMP_UI_M_PROD_SA_TARIFF_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_ROUND_OPTION_LABEL() {
		return COMP_PROD_ROUND_OPTION_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_ROUND_OPTION() {
		return COMP_PROD_ROUND_OPTION;
	}

	public void setCOMP_PROD_ROUND_OPTION_LABEL(
			HtmlOutputLabel COMP_PROD_ROUND_OPTION_LABEL) {
		this.COMP_PROD_ROUND_OPTION_LABEL = COMP_PROD_ROUND_OPTION_LABEL;
	}

	public void setCOMP_PROD_ROUND_OPTION(
			HtmlSelectOneMenu COMP_PROD_ROUND_OPTION) {
		this.COMP_PROD_ROUND_OPTION = COMP_PROD_ROUND_OPTION;
	}

	public HtmlOutputLabel getCOMP_PROD_ROUND_VALUE_LABEL() {
		return COMP_PROD_ROUND_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_ROUND_VALUE() {
		return COMP_PROD_ROUND_VALUE;
	}

	public void setCOMP_PROD_ROUND_VALUE_LABEL(
			HtmlOutputLabel COMP_PROD_ROUND_VALUE_LABEL) {
		this.COMP_PROD_ROUND_VALUE_LABEL = COMP_PROD_ROUND_VALUE_LABEL;
	}

	public void setCOMP_PROD_ROUND_VALUE(HtmlInputText COMP_PROD_ROUND_VALUE) {
		this.COMP_PROD_ROUND_VALUE = COMP_PROD_ROUND_VALUE;
	}

	public HtmlOutputLabel getCOMP_PROD_INST_BASIS_LABEL() {
		return COMP_PROD_INST_BASIS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_INST_BASIS() {
		return COMP_PROD_INST_BASIS;
	}

	public void setCOMP_PROD_INST_BASIS_LABEL(
			HtmlOutputLabel COMP_PROD_INST_BASIS_LABEL) {
		this.COMP_PROD_INST_BASIS_LABEL = COMP_PROD_INST_BASIS_LABEL;
	}

	public void setCOMP_PROD_INST_BASIS(HtmlSelectOneMenu COMP_PROD_INST_BASIS) {
		this.COMP_PROD_INST_BASIS = COMP_PROD_INST_BASIS;
	}

	public HtmlOutputLabel getCOMP_PROD_AGE_SET_BACK_LABEL() {
		return COMP_PROD_AGE_SET_BACK_LABEL;
	}

	public HtmlInputText getCOMP_PROD_AGE_SET_BACK() {
		return COMP_PROD_AGE_SET_BACK;
	}

	public void setCOMP_PROD_AGE_SET_BACK_LABEL(
			HtmlOutputLabel COMP_PROD_AGE_SET_BACK_LABEL) {
		this.COMP_PROD_AGE_SET_BACK_LABEL = COMP_PROD_AGE_SET_BACK_LABEL;
	}

	public void setCOMP_PROD_AGE_SET_BACK(HtmlInputText COMP_PROD_AGE_SET_BACK) {
		this.COMP_PROD_AGE_SET_BACK = COMP_PROD_AGE_SET_BACK;
	}

	public HtmlOutputLabel getCOMP_PROD_PREM_TARIFF_LABEL() {
		return COMP_PROD_PREM_TARIFF_LABEL;
	}

	public HtmlInputText getCOMP_PROD_PREM_TARIFF() {
		return COMP_PROD_PREM_TARIFF;
	}

	public void setCOMP_PROD_PREM_TARIFF_LABEL(
			HtmlOutputLabel COMP_PROD_PREM_TARIFF_LABEL) {
		this.COMP_PROD_PREM_TARIFF_LABEL = COMP_PROD_PREM_TARIFF_LABEL;
	}

	public void setCOMP_PROD_PREM_TARIFF(HtmlInputText COMP_PROD_PREM_TARIFF) {
		this.COMP_PROD_PREM_TARIFF = COMP_PROD_PREM_TARIFF;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_PREM_TARIFF_DESC_LABEL() {
		return COMP_UI_M_PROD_PREM_TARIFF_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_PREM_TARIFF_DESC() {
		return COMP_UI_M_PROD_PREM_TARIFF_DESC;
	}

	public void setCOMP_UI_M_PROD_PREM_TARIFF_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_PREM_TARIFF_DESC_LABEL) {
		this.COMP_UI_M_PROD_PREM_TARIFF_DESC_LABEL = COMP_UI_M_PROD_PREM_TARIFF_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_PREM_TARIFF_DESC(
			HtmlInputText COMP_UI_M_PROD_PREM_TARIFF_DESC) {
		this.COMP_UI_M_PROD_PREM_TARIFF_DESC = COMP_UI_M_PROD_PREM_TARIFF_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_MODE_OF_CALC_LABEL() {
		return COMP_PROD_MODE_OF_CALC_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_MODE_OF_CALC() {
		return COMP_PROD_MODE_OF_CALC;
	}

	public void setCOMP_PROD_MODE_OF_CALC_LABEL(
			HtmlOutputLabel COMP_PROD_MODE_OF_CALC_LABEL) {
		this.COMP_PROD_MODE_OF_CALC_LABEL = COMP_PROD_MODE_OF_CALC_LABEL;
	}

	public void setCOMP_PROD_MODE_OF_CALC(
			HtmlSelectOneMenu COMP_PROD_MODE_OF_CALC) {
		this.COMP_PROD_MODE_OF_CALC = COMP_PROD_MODE_OF_CALC;
	}

	public HtmlOutputLabel getCOMP_PROD_INST_RATE_PER_LABEL() {
		return COMP_PROD_INST_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PROD_INST_RATE_PER() {
		return COMP_PROD_INST_RATE_PER;
	}

	public void setCOMP_PROD_INST_RATE_PER_LABEL(
			HtmlOutputLabel COMP_PROD_INST_RATE_PER_LABEL) {
		this.COMP_PROD_INST_RATE_PER_LABEL = COMP_PROD_INST_RATE_PER_LABEL;
	}

	public void setCOMP_PROD_INST_RATE_PER(HtmlInputText COMP_PROD_INST_RATE_PER) {
		this.COMP_PROD_INST_RATE_PER = COMP_PROD_INST_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PROD_WITHDRAW_YN_LABEL() {
		return COMP_PROD_WITHDRAW_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_WITHDRAW_YN() {
		return COMP_PROD_WITHDRAW_YN;
	}

	public void setCOMP_PROD_WITHDRAW_YN_LABEL(
			HtmlOutputLabel COMP_PROD_WITHDRAW_YN_LABEL) {
		this.COMP_PROD_WITHDRAW_YN_LABEL = COMP_PROD_WITHDRAW_YN_LABEL;
	}

	public void setCOMP_PROD_WITHDRAW_YN(HtmlSelectOneMenu COMP_PROD_WITHDRAW_YN) {
		this.COMP_PROD_WITHDRAW_YN = COMP_PROD_WITHDRAW_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_INST_PERC_LABEL() {
		return COMP_PROD_INST_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_INST_PERC() {
		return COMP_PROD_INST_PERC;
	}

	public void setCOMP_PROD_INST_PERC_LABEL(
			HtmlOutputLabel COMP_PROD_INST_PERC_LABEL) {
		this.COMP_PROD_INST_PERC_LABEL = COMP_PROD_INST_PERC_LABEL;
	}

	public void setCOMP_PROD_INST_PERC(HtmlInputText COMP_PROD_INST_PERC) {
		this.COMP_PROD_INST_PERC = COMP_PROD_INST_PERC;
	}

	public HtmlOutputLabel getCOMP_PROD_WITHDRAW_AMT_MULTIPLE_LABEL() {
		return COMP_PROD_WITHDRAW_AMT_MULTIPLE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_WITHDRAW_AMT_MULTIPLE() {
		return COMP_PROD_WITHDRAW_AMT_MULTIPLE;
	}

	public void setCOMP_PROD_WITHDRAW_AMT_MULTIPLE_LABEL(
			HtmlOutputLabel COMP_PROD_WITHDRAW_AMT_MULTIPLE_LABEL) {
		this.COMP_PROD_WITHDRAW_AMT_MULTIPLE_LABEL = COMP_PROD_WITHDRAW_AMT_MULTIPLE_LABEL;
	}

	public void setCOMP_PROD_WITHDRAW_AMT_MULTIPLE(
			HtmlInputText COMP_PROD_WITHDRAW_AMT_MULTIPLE) {
		this.COMP_PROD_WITHDRAW_AMT_MULTIPLE = COMP_PROD_WITHDRAW_AMT_MULTIPLE;
	}

	public HtmlOutputLabel getCOMP_PROD_GRP_THRESHOLD_PERC_LABEL() {
		return COMP_PROD_GRP_THRESHOLD_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_GRP_THRESHOLD_PERC() {
		return COMP_PROD_GRP_THRESHOLD_PERC;
	}

	public void setCOMP_PROD_GRP_THRESHOLD_PERC_LABEL(
			HtmlOutputLabel COMP_PROD_GRP_THRESHOLD_PERC_LABEL) {
		this.COMP_PROD_GRP_THRESHOLD_PERC_LABEL = COMP_PROD_GRP_THRESHOLD_PERC_LABEL;
	}

	public void setCOMP_PROD_GRP_THRESHOLD_PERC(
			HtmlInputText COMP_PROD_GRP_THRESHOLD_PERC) {
		this.COMP_PROD_GRP_THRESHOLD_PERC = COMP_PROD_GRP_THRESHOLD_PERC;
	}

	public HtmlOutputLabel getCOMP_PROD_THR_BASIS_LABEL() {
		return COMP_PROD_THR_BASIS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_THR_BASIS() {
		return COMP_PROD_THR_BASIS;
	}

	public void setCOMP_PROD_THR_BASIS_LABEL(
			HtmlOutputLabel COMP_PROD_THR_BASIS_LABEL) {
		this.COMP_PROD_THR_BASIS_LABEL = COMP_PROD_THR_BASIS_LABEL;
	}

	public void setCOMP_PROD_THR_BASIS(HtmlSelectOneMenu COMP_PROD_THR_BASIS) {
		this.COMP_PROD_THR_BASIS = COMP_PROD_THR_BASIS;
	}

	public HtmlOutputLabel getCOMP_PROD_MORT_CODE_LABEL() {
		return COMP_PROD_MORT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_MORT_CODE() {
		return COMP_PROD_MORT_CODE;
	}

	public void setCOMP_PROD_MORT_CODE_LABEL(
			HtmlOutputLabel COMP_PROD_MORT_CODE_LABEL) {
		this.COMP_PROD_MORT_CODE_LABEL = COMP_PROD_MORT_CODE_LABEL;
	}

	public void setCOMP_PROD_MORT_CODE(HtmlInputText COMP_PROD_MORT_CODE) {
		this.COMP_PROD_MORT_CODE = COMP_PROD_MORT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_MORT_CODE_DESC_LABEL() {
		return COMP_UI_M_PROD_MORT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_MORT_CODE_DESC() {
		return COMP_UI_M_PROD_MORT_CODE_DESC;
	}

	public void setCOMP_UI_M_PROD_MORT_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_MORT_CODE_DESC_LABEL) {
		this.COMP_UI_M_PROD_MORT_CODE_DESC_LABEL = COMP_UI_M_PROD_MORT_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_MORT_CODE_DESC(
			HtmlInputText COMP_UI_M_PROD_MORT_CODE_DESC) {
		this.COMP_UI_M_PROD_MORT_CODE_DESC = COMP_UI_M_PROD_MORT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_RI_RECOV_BASIS_LABEL() {
		return COMP_PROD_RI_RECOV_BASIS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_RI_RECOV_BASIS() {
		return COMP_PROD_RI_RECOV_BASIS;
	}

	public void setCOMP_PROD_RI_RECOV_BASIS_LABEL(
			HtmlOutputLabel COMP_PROD_RI_RECOV_BASIS_LABEL) {
		this.COMP_PROD_RI_RECOV_BASIS_LABEL = COMP_PROD_RI_RECOV_BASIS_LABEL;
	}

	public void setCOMP_PROD_RI_RECOV_BASIS(
			HtmlSelectOneMenu COMP_PROD_RI_RECOV_BASIS) {
		this.COMP_PROD_RI_RECOV_BASIS = COMP_PROD_RI_RECOV_BASIS;
	}

	public HtmlOutputLabel getCOMP_PROD_TOPUP_YN_LABEL() {
		return COMP_PROD_TOPUP_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_TOPUP_YN() {
		return COMP_PROD_TOPUP_YN;
	}

	public void setCOMP_PROD_TOPUP_YN_LABEL(
			HtmlOutputLabel COMP_PROD_TOPUP_YN_LABEL) {
		this.COMP_PROD_TOPUP_YN_LABEL = COMP_PROD_TOPUP_YN_LABEL;
	}

	public void setCOMP_PROD_TOPUP_YN(HtmlSelectOneMenu COMP_PROD_TOPUP_YN) {
		this.COMP_PROD_TOPUP_YN = COMP_PROD_TOPUP_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_TOPUP_MIN_YRS_LABEL() {
		return COMP_PROD_TOPUP_MIN_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PROD_TOPUP_MIN_YRS() {
		return COMP_PROD_TOPUP_MIN_YRS;
	}

	public void setCOMP_PROD_TOPUP_MIN_YRS_LABEL(
			HtmlOutputLabel COMP_PROD_TOPUP_MIN_YRS_LABEL) {
		this.COMP_PROD_TOPUP_MIN_YRS_LABEL = COMP_PROD_TOPUP_MIN_YRS_LABEL;
	}

	public void setCOMP_PROD_TOPUP_MIN_YRS(HtmlInputText COMP_PROD_TOPUP_MIN_YRS) {
		this.COMP_PROD_TOPUP_MIN_YRS = COMP_PROD_TOPUP_MIN_YRS;
	}

	public HtmlOutputLabel getCOMP_PROD_TOLL_LIMIT_YN_LABEL() {
		return COMP_PROD_TOLL_LIMIT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_TOLL_LIMIT_YN() {
		return COMP_PROD_TOLL_LIMIT_YN;
	}

	public void setCOMP_PROD_TOLL_LIMIT_YN_LABEL(
			HtmlOutputLabel COMP_PROD_TOLL_LIMIT_YN_LABEL) {
		this.COMP_PROD_TOLL_LIMIT_YN_LABEL = COMP_PROD_TOLL_LIMIT_YN_LABEL;
	}

	public void setCOMP_PROD_TOLL_LIMIT_YN(
			HtmlSelectOneMenu COMP_PROD_TOLL_LIMIT_YN) {
		this.COMP_PROD_TOLL_LIMIT_YN = COMP_PROD_TOLL_LIMIT_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_INTER_FUND_YN_LABEL() {
		return COMP_PROD_INTER_FUND_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_INTER_FUND_YN() {
		return COMP_PROD_INTER_FUND_YN;
	}

	public void setCOMP_PROD_INTER_FUND_YN_LABEL(
			HtmlOutputLabel COMP_PROD_INTER_FUND_YN_LABEL) {
		this.COMP_PROD_INTER_FUND_YN_LABEL = COMP_PROD_INTER_FUND_YN_LABEL;
	}

	public void setCOMP_PROD_INTER_FUND_YN(
			HtmlSelectOneMenu COMP_PROD_INTER_FUND_YN) {
		this.COMP_PROD_INTER_FUND_YN = COMP_PROD_INTER_FUND_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_BUY_BASIS_LABEL() {
		return COMP_PROD_BUY_BASIS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_BUY_BASIS() {
		return COMP_PROD_BUY_BASIS;
	}

	public void setCOMP_PROD_BUY_BASIS_LABEL(
			HtmlOutputLabel COMP_PROD_BUY_BASIS_LABEL) {
		this.COMP_PROD_BUY_BASIS_LABEL = COMP_PROD_BUY_BASIS_LABEL;
	}

	public void setCOMP_PROD_BUY_BASIS(HtmlSelectOneMenu COMP_PROD_BUY_BASIS) {
		this.COMP_PROD_BUY_BASIS = COMP_PROD_BUY_BASIS;
	}

	public HtmlOutputLabel getCOMP_PROD_LOAD_CHARGE_YN_LABEL() {
		return COMP_PROD_LOAD_CHARGE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_LOAD_CHARGE_YN() {
		return COMP_PROD_LOAD_CHARGE_YN;
	}

	public void setCOMP_PROD_LOAD_CHARGE_YN_LABEL(
			HtmlOutputLabel COMP_PROD_LOAD_CHARGE_YN_LABEL) {
		this.COMP_PROD_LOAD_CHARGE_YN_LABEL = COMP_PROD_LOAD_CHARGE_YN_LABEL;
	}

	public void setCOMP_PROD_LOAD_CHARGE_YN(
			HtmlSelectOneMenu COMP_PROD_LOAD_CHARGE_YN) {
		this.COMP_PROD_LOAD_CHARGE_YN = COMP_PROD_LOAD_CHARGE_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_TOPUP_PROD_PERC_LABEL() {
		return COMP_PROD_TOPUP_PROD_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_TOPUP_PROD_PERC() {
		return COMP_PROD_TOPUP_PROD_PERC;
	}

	public void setCOMP_PROD_TOPUP_PROD_PERC_LABEL(
			HtmlOutputLabel COMP_PROD_TOPUP_PROD_PERC_LABEL) {
		this.COMP_PROD_TOPUP_PROD_PERC_LABEL = COMP_PROD_TOPUP_PROD_PERC_LABEL;
	}

	public void setCOMP_PROD_TOPUP_PROD_PERC(
			HtmlInputText COMP_PROD_TOPUP_PROD_PERC) {
		this.COMP_PROD_TOPUP_PROD_PERC = COMP_PROD_TOPUP_PROD_PERC;
	}

	public HtmlOutputLabel getCOMP_PROD_TOPUP_COMM_CODE_LABEL() {
		return COMP_PROD_TOPUP_COMM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_TOPUP_COMM_CODE() {
		return COMP_PROD_TOPUP_COMM_CODE;
	}

	public void setCOMP_PROD_TOPUP_COMM_CODE_LABEL(
			HtmlOutputLabel COMP_PROD_TOPUP_COMM_CODE_LABEL) {
		this.COMP_PROD_TOPUP_COMM_CODE_LABEL = COMP_PROD_TOPUP_COMM_CODE_LABEL;
	}

	public void setCOMP_PROD_TOPUP_COMM_CODE(
			HtmlInputText COMP_PROD_TOPUP_COMM_CODE) {
		this.COMP_PROD_TOPUP_COMM_CODE = COMP_PROD_TOPUP_COMM_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION_LABEL() {
		return COMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION() {
		return COMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION;
	}

	public void setCOMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION_LABEL) {
		this.COMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION_LABEL = COMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION_LABEL;
	}

	public void setCOMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION(
			HtmlInputText COMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION) {
		this.COMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION = COMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION;
	}

	public HtmlOutputLabel getCOMP_PROD_ALLOC_TYPE_LABEL() {
		return COMP_PROD_ALLOC_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_ALLOC_TYPE() {
		return COMP_PROD_ALLOC_TYPE;
	}

	public void setCOMP_PROD_ALLOC_TYPE_LABEL(
			HtmlOutputLabel COMP_PROD_ALLOC_TYPE_LABEL) {
		this.COMP_PROD_ALLOC_TYPE_LABEL = COMP_PROD_ALLOC_TYPE_LABEL;
	}

	public void setCOMP_PROD_ALLOC_TYPE(HtmlSelectOneMenu COMP_PROD_ALLOC_TYPE) {
		this.COMP_PROD_ALLOC_TYPE = COMP_PROD_ALLOC_TYPE;
	}

	public HtmlOutputLabel getCOMP_PROD_SERVICE_TAX_YN_LABEL() {
		return COMP_PROD_SERVICE_TAX_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_SERVICE_TAX_YN() {
		return COMP_PROD_SERVICE_TAX_YN;
	}

	public void setCOMP_PROD_SERVICE_TAX_YN_LABEL(
			HtmlOutputLabel COMP_PROD_SERVICE_TAX_YN_LABEL) {
		this.COMP_PROD_SERVICE_TAX_YN_LABEL = COMP_PROD_SERVICE_TAX_YN_LABEL;
	}

	public void setCOMP_PROD_SERVICE_TAX_YN(
			HtmlSelectOneMenu COMP_PROD_SERVICE_TAX_YN) {
		this.COMP_PROD_SERVICE_TAX_YN = COMP_PROD_SERVICE_TAX_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_AGENT_HIRE_YN_LABEL() {
		return COMP_PROD_AGENT_HIRE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_AGENT_HIRE_YN() {
		return COMP_PROD_AGENT_HIRE_YN;
	}

	public void setCOMP_PROD_AGENT_HIRE_YN_LABEL(
			HtmlOutputLabel COMP_PROD_AGENT_HIRE_YN_LABEL) {
		this.COMP_PROD_AGENT_HIRE_YN_LABEL = COMP_PROD_AGENT_HIRE_YN_LABEL;
	}

	public void setCOMP_PROD_AGENT_HIRE_YN(
			HtmlSelectOneMenu COMP_PROD_AGENT_HIRE_YN) {
		this.COMP_PROD_AGENT_HIRE_YN = COMP_PROD_AGENT_HIRE_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_TOPUP_CHARGE_TYPE_LABEL() {
		return COMP_PROD_TOPUP_CHARGE_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_TOPUP_CHARGE_TYPE() {
		return COMP_PROD_TOPUP_CHARGE_TYPE;
	}

	public void setCOMP_PROD_TOPUP_CHARGE_TYPE_LABEL(
			HtmlOutputLabel COMP_PROD_TOPUP_CHARGE_TYPE_LABEL) {
		this.COMP_PROD_TOPUP_CHARGE_TYPE_LABEL = COMP_PROD_TOPUP_CHARGE_TYPE_LABEL;
	}

	public void setCOMP_PROD_TOPUP_CHARGE_TYPE(
			HtmlSelectOneMenu COMP_PROD_TOPUP_CHARGE_TYPE) {
		this.COMP_PROD_TOPUP_CHARGE_TYPE = COMP_PROD_TOPUP_CHARGE_TYPE;
	}

	public HtmlOutputLabel getCOMP_PROD_FUND_FEE_LABEL() {
		return COMP_PROD_FUND_FEE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_FUND_FEE() {
		return COMP_PROD_FUND_FEE;
	}

	public void setCOMP_PROD_FUND_FEE_LABEL(
			HtmlOutputLabel COMP_PROD_FUND_FEE_LABEL) {
		this.COMP_PROD_FUND_FEE_LABEL = COMP_PROD_FUND_FEE_LABEL;
	}

	public void setCOMP_PROD_FUND_FEE(HtmlInputText COMP_PROD_FUND_FEE) {
		this.COMP_PROD_FUND_FEE = COMP_PROD_FUND_FEE;
	}

	public HtmlOutputLabel getCOMP_PROD_FUND_FEE_RATE_PER_LABEL() {
		return COMP_PROD_FUND_FEE_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PROD_FUND_FEE_RATE_PER() {
		return COMP_PROD_FUND_FEE_RATE_PER;
	}

	public void setCOMP_PROD_FUND_FEE_RATE_PER_LABEL(
			HtmlOutputLabel COMP_PROD_FUND_FEE_RATE_PER_LABEL) {
		this.COMP_PROD_FUND_FEE_RATE_PER_LABEL = COMP_PROD_FUND_FEE_RATE_PER_LABEL;
	}

	public void setCOMP_PROD_FUND_FEE_RATE_PER(
			HtmlInputText COMP_PROD_FUND_FEE_RATE_PER) {
		this.COMP_PROD_FUND_FEE_RATE_PER = COMP_PROD_FUND_FEE_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PROD_CALC_ALLOC_LABEL() {
		return COMP_PROD_CALC_ALLOC_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_CALC_ALLOC() {
		return COMP_PROD_CALC_ALLOC;
	}

	public void setCOMP_PROD_CALC_ALLOC_LABEL(
			HtmlOutputLabel COMP_PROD_CALC_ALLOC_LABEL) {
		this.COMP_PROD_CALC_ALLOC_LABEL = COMP_PROD_CALC_ALLOC_LABEL;
	}

	public void setCOMP_PROD_CALC_ALLOC(HtmlSelectOneMenu COMP_PROD_CALC_ALLOC) {
		this.COMP_PROD_CALC_ALLOC = COMP_PROD_CALC_ALLOC;
	}

	public HtmlOutputLabel getCOMP_PROD_BCH_CODE_LABEL() {
		return COMP_PROD_BCH_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_BCH_CODE() {
		return COMP_PROD_BCH_CODE;
	}

	public void setCOMP_PROD_BCH_CODE_LABEL(
			HtmlOutputLabel COMP_PROD_BCH_CODE_LABEL) {
		this.COMP_PROD_BCH_CODE_LABEL = COMP_PROD_BCH_CODE_LABEL;
	}

	public void setCOMP_PROD_BCH_CODE(HtmlInputText COMP_PROD_BCH_CODE) {
		this.COMP_PROD_BCH_CODE = COMP_PROD_BCH_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_BCH_CODE_DESC_LABEL() {
		return COMP_UI_M_PROD_BCH_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_BCH_CODE_DESC() {
		return COMP_UI_M_PROD_BCH_CODE_DESC;
	}

	public void setCOMP_UI_M_PROD_BCH_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_BCH_CODE_DESC_LABEL) {
		this.COMP_UI_M_PROD_BCH_CODE_DESC_LABEL = COMP_UI_M_PROD_BCH_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_BCH_CODE_DESC(
			HtmlInputText COMP_UI_M_PROD_BCH_CODE_DESC) {
		this.COMP_UI_M_PROD_BCH_CODE_DESC = COMP_UI_M_PROD_BCH_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_BROK_CALC_MTHD_LABEL() {
		return COMP_PROD_BROK_CALC_MTHD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_BROK_CALC_MTHD() {
		return COMP_PROD_BROK_CALC_MTHD;
	}

	public void setCOMP_PROD_BROK_CALC_MTHD_LABEL(
			HtmlOutputLabel COMP_PROD_BROK_CALC_MTHD_LABEL) {
		this.COMP_PROD_BROK_CALC_MTHD_LABEL = COMP_PROD_BROK_CALC_MTHD_LABEL;
	}

	public void setCOMP_PROD_BROK_CALC_MTHD(
			HtmlSelectOneMenu COMP_PROD_BROK_CALC_MTHD) {
		this.COMP_PROD_BROK_CALC_MTHD = COMP_PROD_BROK_CALC_MTHD;
	}

	public HtmlOutputLabel getCOMP_PROD_PREM_HOLIDAY_CODE_LABEL() {
		return COMP_PROD_PREM_HOLIDAY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_PREM_HOLIDAY_CODE() {
		return COMP_PROD_PREM_HOLIDAY_CODE;
	}

	public void setCOMP_PROD_PREM_HOLIDAY_CODE_LABEL(
			HtmlOutputLabel COMP_PROD_PREM_HOLIDAY_CODE_LABEL) {
		this.COMP_PROD_PREM_HOLIDAY_CODE_LABEL = COMP_PROD_PREM_HOLIDAY_CODE_LABEL;
	}

	public void setCOMP_PROD_PREM_HOLIDAY_CODE(
			HtmlInputText COMP_PROD_PREM_HOLIDAY_CODE) {
		this.COMP_PROD_PREM_HOLIDAY_CODE = COMP_PROD_PREM_HOLIDAY_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC_LABEL() {
		return COMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC() {
		return COMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC;
	}

	public void setCOMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC_LABEL) {
		this.COMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC_LABEL = COMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC(
			HtmlInputText COMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC) {
		this.COMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC = COMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PROD_COMM_RND_TYPE_LABEL() {
		return COMP_PROD_COMM_RND_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_COMM_RND_TYPE() {
		return COMP_PROD_COMM_RND_TYPE;
	}

	public void setCOMP_PROD_COMM_RND_TYPE_LABEL(
			HtmlOutputLabel COMP_PROD_COMM_RND_TYPE_LABEL) {
		this.COMP_PROD_COMM_RND_TYPE_LABEL = COMP_PROD_COMM_RND_TYPE_LABEL;
	}

	public void setCOMP_PROD_COMM_RND_TYPE(
			HtmlSelectOneMenu COMP_PROD_COMM_RND_TYPE) {
		this.COMP_PROD_COMM_RND_TYPE = COMP_PROD_COMM_RND_TYPE;
	}

	public HtmlOutputLabel getCOMP_PROD_COMM_RND_DEC_LABEL() {
		return COMP_PROD_COMM_RND_DEC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_COMM_RND_DEC() {
		return COMP_PROD_COMM_RND_DEC;
	}

	public void setCOMP_PROD_COMM_RND_DEC_LABEL(
			HtmlOutputLabel COMP_PROD_COMM_RND_DEC_LABEL) {
		this.COMP_PROD_COMM_RND_DEC_LABEL = COMP_PROD_COMM_RND_DEC_LABEL;
	}

	public void setCOMP_PROD_COMM_RND_DEC(HtmlInputText COMP_PROD_COMM_RND_DEC) {
		this.COMP_PROD_COMM_RND_DEC = COMP_PROD_COMM_RND_DEC;
	}

	public HtmlOutputLabel getCOMP_PROD_PRODUCTION_PERC_LABEL() {
		return COMP_PROD_PRODUCTION_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_PRODUCTION_PERC() {
		return COMP_PROD_PRODUCTION_PERC;
	}

	public void setCOMP_PROD_PRODUCTION_PERC_LABEL(
			HtmlOutputLabel COMP_PROD_PRODUCTION_PERC_LABEL) {
		this.COMP_PROD_PRODUCTION_PERC_LABEL = COMP_PROD_PRODUCTION_PERC_LABEL;
	}

	public void setCOMP_PROD_PRODUCTION_PERC(
			HtmlInputText COMP_PROD_PRODUCTION_PERC) {
		this.COMP_PROD_PRODUCTION_PERC = COMP_PROD_PRODUCTION_PERC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DS_CODE_LOV() {
		return COMP_UI_M_BUT_DS_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_DS_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DS_CODE_LOV) {
		this.COMP_UI_M_BUT_DS_CODE_LOV = COMP_UI_M_BUT_DS_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_EDIT_PROD_DESC() {
		return COMP_UI_M_EDIT_PROD_DESC;
	}

	public void setCOMP_UI_M_EDIT_PROD_DESC(
			HtmlCommandButton COMP_UI_M_EDIT_PROD_DESC) {
		this.COMP_UI_M_EDIT_PROD_DESC = COMP_UI_M_EDIT_PROD_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_EDIT_PROD_LOND_DESC() {
		return COMP_UI_M_EDIT_PROD_LOND_DESC;
	}

	public void setCOMP_UI_M_EDIT_PROD_LOND_DESC(
			HtmlCommandButton COMP_UI_M_EDIT_PROD_LOND_DESC) {
		this.COMP_UI_M_EDIT_PROD_LOND_DESC = COMP_UI_M_EDIT_PROD_LOND_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_EDIT_PROD_SHORT_DESC() {
		return COMP_UI_M_EDIT_PROD_SHORT_DESC;
	}

	public void setCOMP_UI_M_EDIT_PROD_SHORT_DESC(
			HtmlCommandButton COMP_UI_M_EDIT_PROD_SHORT_DESC) {
		this.COMP_UI_M_EDIT_PROD_SHORT_DESC = COMP_UI_M_EDIT_PROD_SHORT_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PROD_PLAN_CODE() {
		return COMP_UI_M_BUT_LOV_PROD_PLAN_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_PROD_PLAN_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_PROD_PLAN_CODE) {
		this.COMP_UI_M_BUT_LOV_PROD_PLAN_CODE = COMP_UI_M_BUT_LOV_PROD_PLAN_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BILINGUAL() {
		return COMP_UI_M_BUT_BILINGUAL;
	}

	public void setCOMP_UI_M_BUT_BILINGUAL(
			HtmlCommandButton COMP_UI_M_BUT_BILINGUAL) {
		this.COMP_UI_M_BUT_BILINGUAL = COMP_UI_M_BUT_BILINGUAL;
	}

	public HtmlCommandButton getCOMP_UI_M_COPY_BUTT() {
		return COMP_UI_M_COPY_BUTT;
	}

	public void setCOMP_UI_M_COPY_BUTT(HtmlCommandButton COMP_UI_M_COPY_BUTT) {
		this.COMP_UI_M_COPY_BUTT = COMP_UI_M_COPY_BUTT;
	}

	public HtmlCommandButton getCOMP_APPL_SUB_PLANS() {
		return COMP_APPL_SUB_PLANS;
	}

	public void setCOMP_APPL_SUB_PLANS(HtmlCommandButton COMP_APPL_SUB_PLANS) {
		this.COMP_APPL_SUB_PLANS = COMP_APPL_SUB_PLANS;
	}

	public PM_IL_PRODUCT getPM_IL_PRODUCT_BEAN() {
		return PM_IL_PRODUCT_BEAN;
	}

	public void setPM_IL_PRODUCT_BEAN(PM_IL_PRODUCT PM_IL_PRODUCT_BEAN) {
		this.PM_IL_PRODUCT_BEAN = PM_IL_PRODUCT_BEAN;
	}

	public HtmlInputText getCOMP_PROD_SA_ADD_FACTOR() {
		return COMP_PROD_SA_ADD_FACTOR;
	}

	public void setCOMP_PROD_SA_ADD_FACTOR(HtmlInputText comp_prod_sa_add_factor) {
		COMP_PROD_SA_ADD_FACTOR = comp_prod_sa_add_factor;
	}

	public HtmlOutputLabel getCOMP_PROD_FUND_ALLOWED_LABEL() {
		return COMP_PROD_FUND_ALLOWED_LABEL;
	}

	public void setCOMP_PROD_FUND_ALLOWED_LABEL(
			HtmlOutputLabel comp_prod_fund_allowed_label) {
		COMP_PROD_FUND_ALLOWED_LABEL = comp_prod_fund_allowed_label;
	}

	public HtmlSelectOneMenu getCOMP_PROD_FUND_ALLOWED() {
		return COMP_PROD_FUND_ALLOWED;
	}

	public void setCOMP_PROD_FUND_ALLOWED(
			HtmlSelectOneMenu comp_prod_fund_allowed) {
		COMP_PROD_FUND_ALLOWED = comp_prod_fund_allowed;
	}

	public HtmlOutputLabel getCOMP_PROD_TOL_CHK_YN_LABEL() {
		return COMP_PROD_TOL_CHK_YN_LABEL;
	}

	public void setCOMP_PROD_TOL_CHK_YN_LABEL(
			HtmlOutputLabel comp_prod_tol_chk_yn_label) {
		COMP_PROD_TOL_CHK_YN_LABEL = comp_prod_tol_chk_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_PROD_TOL_CHK_YN() {
		return COMP_PROD_TOL_CHK_YN;
	}

	public void setCOMP_PROD_TOL_CHK_YN(HtmlSelectOneMenu comp_prod_tol_chk_yn) {
		COMP_PROD_TOL_CHK_YN = comp_prod_tol_chk_yn;
	}

	public HtmlOutputLabel getCOMP_PROD_DEF_PERIOD_FM_LABEL() {
		return COMP_PROD_DEF_PERIOD_FM_LABEL;
	}

	public void setCOMP_PROD_DEF_PERIOD_FM_LABEL(
			HtmlOutputLabel comp_prod_def_period_fm_label) {
		COMP_PROD_DEF_PERIOD_FM_LABEL = comp_prod_def_period_fm_label;
	}

	public HtmlInputText getCOMP_PROD_DEF_PERIOD_FM() {
		return COMP_PROD_DEF_PERIOD_FM;
	}

	public void setCOMP_PROD_DEF_PERIOD_FM(HtmlInputText comp_prod_def_period_fm) {
		COMP_PROD_DEF_PERIOD_FM = comp_prod_def_period_fm;
	}

	public HtmlOutputLabel getCOMP_PROD_DEF_PERIOD_TO_LABEL() {
		return COMP_PROD_DEF_PERIOD_TO_LABEL;
	}

	public void setCOMP_PROD_DEF_PERIOD_TO_LABEL(
			HtmlOutputLabel comp_prod_def_period_to_label) {
		COMP_PROD_DEF_PERIOD_TO_LABEL = comp_prod_def_period_to_label;
	}

	public HtmlInputText getCOMP_PROD_DEF_PERIOD_TO() {
		return COMP_PROD_DEF_PERIOD_TO;
	}

	public void setCOMP_PROD_DEF_PERIOD_TO(HtmlInputText comp_prod_def_period_to) {
		COMP_PROD_DEF_PERIOD_TO = comp_prod_def_period_to;
	}

	public HtmlOutputLabel getCOMP_PROD_DRIP_LIMIT_LABEL() {
		return COMP_PROD_DRIP_LIMIT_LABEL;
	}

	public void setCOMP_PROD_DRIP_LIMIT_LABEL(
			HtmlOutputLabel comp_prod_drip_limit_label) {
		COMP_PROD_DRIP_LIMIT_LABEL = comp_prod_drip_limit_label;
	}

	public HtmlSelectOneMenu getCOMP_PROD_DRIP_LIMIT() {
		return COMP_PROD_DRIP_LIMIT;
	}

	public void setCOMP_PROD_DRIP_LIMIT(HtmlSelectOneMenu comp_prod_drip_limit) {
		COMP_PROD_DRIP_LIMIT = comp_prod_drip_limit;
	}

	public HtmlOutputLabel getCOMP_PROD_WAQAF_PERIOD_FM_LABEL() {
		return COMP_PROD_WAQAF_PERIOD_FM_LABEL;
	}

	public void setCOMP_PROD_WAQAF_PERIOD_FM_LABEL(
			HtmlOutputLabel comp_prod_waqaf_period_fm_label) {
		COMP_PROD_WAQAF_PERIOD_FM_LABEL = comp_prod_waqaf_period_fm_label;
	}

	public HtmlInputText getCOMP_PROD_WAQAF_PERIOD_FM() {
		return COMP_PROD_WAQAF_PERIOD_FM;
	}

	public void setCOMP_PROD_WAQAF_PERIOD_FM(
			HtmlInputText comp_prod_waqaf_period_fm) {
		COMP_PROD_WAQAF_PERIOD_FM = comp_prod_waqaf_period_fm;
	}

	public HtmlOutputLabel getCOMP_PROD_WAQAF_PERIOD_TO_LABEL() {
		return COMP_PROD_WAQAF_PERIOD_TO_LABEL;
	}

	public void setCOMP_PROD_WAQAF_PERIOD_TO_LABEL(
			HtmlOutputLabel comp_prod_waqaf_period_to_label) {
		COMP_PROD_WAQAF_PERIOD_TO_LABEL = comp_prod_waqaf_period_to_label;
	}

	public HtmlInputText getCOMP_PROD_WAQAF_PERIOD_TO() {
		return COMP_PROD_WAQAF_PERIOD_TO;
	}

	public void setCOMP_PROD_WAQAF_PERIOD_TO(
			HtmlInputText comp_prod_waqaf_period_to) {
		COMP_PROD_WAQAF_PERIOD_TO = comp_prod_waqaf_period_to;
	}

	public HtmlOutputLabel getCOMP_PROD_WAKFEE_FACTOR_LABEL() {
		return COMP_PROD_WAKFEE_FACTOR_LABEL;
	}

	public void setCOMP_PROD_WAKFEE_FACTOR_LABEL(
			HtmlOutputLabel comp_prod_wakfee_factor_label) {
		COMP_PROD_WAKFEE_FACTOR_LABEL = comp_prod_wakfee_factor_label;
	}

	public HtmlInputText getCOMP_PROD_WAKFEE_FACTOR() {
		return COMP_PROD_WAKFEE_FACTOR;
	}

	public void setCOMP_PROD_WAKFEE_FACTOR(HtmlInputText comp_prod_wakfee_factor) {
		COMP_PROD_WAKFEE_FACTOR = comp_prod_wakfee_factor;
	}

	public HtmlOutputLabel getCOMP_PROD_WAKFEE_FACTOR_DESC_LABEL() {
		return COMP_PROD_WAKFEE_FACTOR_DESC_LABEL;
	}

	public void setCOMP_PROD_WAKFEE_FACTOR_DESC_LABEL(
			HtmlOutputLabel comp_prod_wakfee_factor_desc_label) {
		COMP_PROD_WAKFEE_FACTOR_DESC_LABEL = comp_prod_wakfee_factor_desc_label;
	}

	public HtmlInputText getCOMP_PROD_WAKFEE_FACTOR_DESC() {
		return COMP_PROD_WAKFEE_FACTOR_DESC;
	}

	public void setCOMP_PROD_WAKFEE_FACTOR_DESC(
			HtmlInputText comp_prod_wakfee_factor_desc) {
		COMP_PROD_WAKFEE_FACTOR_DESC = comp_prod_wakfee_factor_desc;
	}

	public HtmlOutputLabel getCOMP_PROD_MIN_SURR_AMT_LABEL() {
		return COMP_PROD_MIN_SURR_AMT_LABEL;
	}

	public void setCOMP_PROD_MIN_SURR_AMT_LABEL(
			HtmlOutputLabel comp_prod_min_surr_amt_label) {
		COMP_PROD_MIN_SURR_AMT_LABEL = comp_prod_min_surr_amt_label;
	}

	public HtmlInputText getCOMP_PROD_MIN_SURR_AMT() {
		return COMP_PROD_MIN_SURR_AMT;
	}

	public void setCOMP_PROD_MIN_SURR_AMT(HtmlInputText comp_prod_min_surr_amt) {
		COMP_PROD_MIN_SURR_AMT = comp_prod_min_surr_amt;
	}

	public HtmlOutputLabel getCOMP_PROD_SA_ADD_FACTOR_LABEL() {
		return COMP_PROD_SA_ADD_FACTOR_LABEL;
	}

	public void setCOMP_PROD_SA_ADD_FACTOR_LABEL(
			HtmlOutputLabel comp_prod_sa_add_factor_label) {
		COMP_PROD_SA_ADD_FACTOR_LABEL = comp_prod_sa_add_factor_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_SA_ADD_FACTOR_DESC_LABEL() {
		return COMP_UI_M_PROD_SA_ADD_FACTOR_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_SA_ADD_FACTOR_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_prod_sa_add_factor_desc_label) {
		COMP_UI_M_PROD_SA_ADD_FACTOR_DESC_LABEL = comp_ui_m_prod_sa_add_factor_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_PROD_SA_ADD_FACTOR_DESC() {
		return COMP_UI_M_PROD_SA_ADD_FACTOR_DESC;
	}

	public void setCOMP_UI_M_PROD_SA_ADD_FACTOR_DESC(
			HtmlInputText comp_ui_m_prod_sa_add_factor_desc) {
		COMP_UI_M_PROD_SA_ADD_FACTOR_DESC = comp_ui_m_prod_sa_add_factor_desc;
	}

	public HtmlOutputLabel getCOMP_PROD_AFTWD_LC_MINBAL_LABEL() {
		return COMP_PROD_AFTWD_LC_MINBAL_LABEL;
	}

	public void setCOMP_PROD_AFTWD_LC_MINBAL_LABEL(
			HtmlOutputLabel comp_prod_aftwd_lc_minbal_label) {
		COMP_PROD_AFTWD_LC_MINBAL_LABEL = comp_prod_aftwd_lc_minbal_label;
	}

	public HtmlInputText getCOMP_PROD_AFTWD_LC_MINBAL() {
		return COMP_PROD_AFTWD_LC_MINBAL;
	}

	public void setCOMP_PROD_AFTWD_LC_MINBAL(
			HtmlInputText comp_prod_aftwd_lc_minbal) {
		COMP_PROD_AFTWD_LC_MINBAL = comp_prod_aftwd_lc_minbal;
	}

	public HtmlOutputLabel getCOMP_PROD_TRAN_RATE_YN_LABEL() {
		return COMP_PROD_TRAN_RATE_YN_LABEL;
	}

	public void setCOMP_PROD_TRAN_RATE_YN_LABEL(
			HtmlOutputLabel comp_prod_tran_rate_yn_label) {
		COMP_PROD_TRAN_RATE_YN_LABEL = comp_prod_tran_rate_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_PROD_TRAN_RATE_YN() {
		return COMP_PROD_TRAN_RATE_YN;
	}

	public void setCOMP_PROD_TRAN_RATE_YN(
			HtmlSelectOneMenu comp_prod_tran_rate_yn) {
		COMP_PROD_TRAN_RATE_YN = comp_prod_tran_rate_yn;
	}

	public HtmlOutputLabel getCOMP_PROD_TOPUP_MULTIPLE_LABEL() {
		return COMP_PROD_TOPUP_MULTIPLE_LABEL;
	}

	public void setCOMP_PROD_TOPUP_MULTIPLE_LABEL(
			HtmlOutputLabel comp_prod_topup_multiple_label) {
		COMP_PROD_TOPUP_MULTIPLE_LABEL = comp_prod_topup_multiple_label;
	}

	public HtmlInputText getCOMP_PROD_TOPUP_MULTIPLE() {
		return COMP_PROD_TOPUP_MULTIPLE;
	}

	public void setCOMP_PROD_TOPUP_MULTIPLE(
			HtmlInputText comp_prod_topup_multiple) {
		COMP_PROD_TOPUP_MULTIPLE = comp_prod_topup_multiple;
	}

	public HtmlOutputLabel getCOMP_PROD_TOPUP_WAK_CODE_LABEL() {
		return COMP_PROD_TOPUP_WAK_CODE_LABEL;
	}

	public void setCOMP_PROD_TOPUP_WAK_CODE_LABEL(
			HtmlOutputLabel comp_prod_topup_wak_code_label) {
		COMP_PROD_TOPUP_WAK_CODE_LABEL = comp_prod_topup_wak_code_label;
	}

	public HtmlInputText getCOMP_PROD_TOPUP_WAK_CODE() {
		return COMP_PROD_TOPUP_WAK_CODE;
	}

	public void setCOMP_PROD_TOPUP_WAK_CODE(
			HtmlInputText comp_prod_topup_wak_code) {
		COMP_PROD_TOPUP_WAK_CODE = comp_prod_topup_wak_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_WAK_CODE_DESC_LABEL() {
		return COMP_UI_M_PROD_WAK_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_WAK_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_prod_wak_code_desc_label) {
		COMP_UI_M_PROD_WAK_CODE_DESC_LABEL = comp_ui_m_prod_wak_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_PROD_WAK_CODE_DESC() {
		return COMP_UI_M_PROD_WAK_CODE_DESC;
	}

	public void setCOMP_UI_M_PROD_WAK_CODE_DESC(
			HtmlInputText comp_ui_m_prod_wak_code_desc) {
		COMP_UI_M_PROD_WAK_CODE_DESC = comp_ui_m_prod_wak_code_desc;
	}

	public List<SelectItem> getListPROD_DRIP_LIMIT() {
		return listPROD_DRIP_LIMIT;
	}

	public void setListPROD_DRIP_LIMIT(List<SelectItem> listPROD_DRIP_LIMIT) {
		this.listPROD_DRIP_LIMIT = listPROD_DRIP_LIMIT;
	}

	public void saveRecord() {
		CommonUtils.clearMaps(this);
		try {
			helper.validPROD_TOPUP_MULTIPLE(PM_IL_PRODUCT_BEAN.getPROD_TOPUP_MULTIPLE(),PM_IL_PRODUCT_BEAN);
			if (getPM_IL_PRODUCT_BEAN().getROWID() != null) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(getPM_IL_PRODUCT_BEAN(),
						CommonUtils.getConnection());
			/*	Added by saranya on 02/01/2017 for RM018T - FSD_IL_ZB Life_028-Cash Back
				System.out.println("PROD_CASHBACK_YN value :"+PM_IL_PRODUCT_BEAN.getPROD_CASHBACK_YN());
				if("Y".equals(PM_IL_PRODUCT_BEAN.getPROD_CASHBACK_YN())){
				new CRUDHandler().executeUpdate(PM_IL_PROD_CASHBACK_BEAN,
						CommonUtils.getConnection());
				}
				End*/
				helper.POST_UPDATE(compositeAction);
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$update"));
				getWarningMap().put(
						"save",
						Messages.getString("messageProperties",
								"errorPanel$message$update"));
			} else {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(getPM_IL_PRODUCT_BEAN(),
						CommonUtils.getConnection());
				/*Added by saranya on 02/01/2017 for RM018T - FSD_IL_ZB Life_028-Cash Back
				System.out.println("PROD_CASHBACK_YN value :"+PM_IL_PRODUCT_BEAN.getPROD_CASHBACK_YN());
				if("Y".equals(PM_IL_PRODUCT_BEAN.getPROD_CASHBACK_YN())){
				new CRUDHandler().executeInsert(PM_IL_PROD_CASHBACK_BEAN,
						CommonUtils.getConnection());
				}
				End*/
				helper.POST_INSERT(compositeAction);
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$save"));
				getWarningMap().put(
						"save",
						Messages.getString("messageProperties",
						"errorPanel$message$save"));

			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListPROD_AGE_CALC_FLAG() {
		if (listPROD_AGE_CALC_FLAG.size() == 0) {
			listPROD_AGE_CALC_FLAG.clear();
			try {
				listPROD_AGE_CALC_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_AGE_CALC_FLAG;
	}

	public void setListPROD_AGE_CALC_FLAG(
			List<SelectItem> listPROD_AGE_CALC_FLAG) {
		this.listPROD_AGE_CALC_FLAG = listPROD_AGE_CALC_FLAG;
	}

	public List<SelectItem> getListPROD_TARIFF_TERM_FLAG() {
		if (listPROD_TARIFF_TERM_FLAG.size() == 0) {
			listPROD_TARIFF_TERM_FLAG.clear();
			try {
				listPROD_TARIFF_TERM_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_TARIFF_TERM_FLAG;
	}

	public void setListPROD_TARIFF_TERM_FLAG(
			List<SelectItem> listPROD_TARIFF_TERM_FLAG) {
		this.listPROD_TARIFF_TERM_FLAG = listPROD_TARIFF_TERM_FLAG;
	}

	public List<SelectItem> getListPROD_JOINT_LIFE_YN() {
		if (listPROD_JOINT_LIFE_YN.size() == 0) {
			listPROD_JOINT_LIFE_YN.clear();
			try {
				listPROD_JOINT_LIFE_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_JOINT_LIFE_YN;
	}

	public void setListPROD_JOINT_LIFE_YN(
			List<SelectItem> listPROD_JOINT_LIFE_YN) {
		this.listPROD_JOINT_LIFE_YN = listPROD_JOINT_LIFE_YN;
	}

	public List<SelectItem> getListPROD_SA_INST_PYMT_TYPE() {
		if (listPROD_SA_INST_PYMT_TYPE.size() == 0) {
			listPROD_SA_INST_PYMT_TYPE.clear();
			try {
				listPROD_SA_INST_PYMT_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_SA_INST_PYMT_TYPE;
	}

	public void setListPROD_SA_INST_PYMT_TYPE(
			List<SelectItem> listPROD_SA_INST_PYMT_TYPE) {
		this.listPROD_SA_INST_PYMT_TYPE = listPROD_SA_INST_PYMT_TYPE;
	}

	public List<SelectItem> getListPROD_PRODUCT_TYPE() {
		if (listPROD_PRODUCT_TYPE.size() == 0) {
			listPROD_PRODUCT_TYPE.clear();
			try {
				listPROD_PRODUCT_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_PRODUCT_TYPE;
	}

	public void setListPROD_PRODUCT_TYPE(List<SelectItem> listPROD_PRODUCT_TYPE) {
		this.listPROD_PRODUCT_TYPE = listPROD_PRODUCT_TYPE;
	}

	public List<SelectItem> getListPROD_SA_BY_PLAN_BASIS_YN() {
		if (listPROD_SA_BY_PLAN_BASIS_YN.size() == 0) {
			listPROD_SA_BY_PLAN_BASIS_YN.clear();
			try {
				listPROD_SA_BY_PLAN_BASIS_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_SA_BY_PLAN_BASIS_YN;
	}

	public void setListPROD_SA_BY_PLAN_BASIS_YN(
			List<SelectItem> listPROD_SA_BY_PLAN_BASIS_YN) {
		this.listPROD_SA_BY_PLAN_BASIS_YN = listPROD_SA_BY_PLAN_BASIS_YN;
	}

	public List<SelectItem> getListPROD_MASTER_CERT_YN() {
		if (listPROD_MASTER_CERT_YN.size() == 0) {
			listPROD_MASTER_CERT_YN.clear();
			try {
				listPROD_MASTER_CERT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_MASTER_CERT_YN;
	}

	public void setListPROD_MASTER_CERT_YN(
			List<SelectItem> listPROD_MASTER_CERT_YN) {
		this.listPROD_MASTER_CERT_YN = listPROD_MASTER_CERT_YN;
	}

	public List<SelectItem> getListPROD_POL_VALID_AFTER_MAT_YN() {
		if (listPROD_POL_VALID_AFTER_MAT_YN.size() == 0) {
			listPROD_POL_VALID_AFTER_MAT_YN.clear();
			try {
				listPROD_POL_VALID_AFTER_MAT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_POL_VALID_AFTER_MAT_YN;
	}

	public void setListPROD_POL_VALID_AFTER_MAT_YN(
			List<SelectItem> listPROD_POL_VALID_AFTER_MAT_YN) {
		this.listPROD_POL_VALID_AFTER_MAT_YN = listPROD_POL_VALID_AFTER_MAT_YN;
	}

	public List<SelectItem> getListPROD_MATU_DT() {
		if (listPROD_MATU_DT.size() == 0) {
			listPROD_MATU_DT.clear();
			try {
				listPROD_MATU_DT = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_MATU_DT;
	}

	public void setListPROD_MATU_DT(List<SelectItem> listPROD_MATU_DT) {
		this.listPROD_MATU_DT = listPROD_MATU_DT;
	}

	public List<SelectItem> getListPROD_DEF_PERIOD_FLAG() {
		if (listPROD_DEF_PERIOD_FLAG.size() == 0) {
			listPROD_DEF_PERIOD_FLAG.clear();
			try {
				listPROD_DEF_PERIOD_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_DEF_PERIOD_FLAG;
	}

	public void setListPROD_DEF_PERIOD_FLAG(
			List<SelectItem> listPROD_DEF_PERIOD_FLAG) {
		this.listPROD_DEF_PERIOD_FLAG = listPROD_DEF_PERIOD_FLAG;
	}

	public List<SelectItem> getListPROD_MAT_AMT_TYPE() {
		if (listPROD_MAT_AMT_TYPE.size() == 0) {
			listPROD_MAT_AMT_TYPE.clear();
			try {
				listPROD_MAT_AMT_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_MAT_AMT_TYPE;
	}

	public void setListPROD_MAT_AMT_TYPE(List<SelectItem> listPROD_MAT_AMT_TYPE) {
		this.listPROD_MAT_AMT_TYPE = listPROD_MAT_AMT_TYPE;
	}

	public List<SelectItem> getListPROD_PREM_CALC_MTHD() {
		if (listPROD_PREM_CALC_MTHD.size() == 0) {
			listPROD_PREM_CALC_MTHD.clear();
			try {
				listPROD_PREM_CALC_MTHD = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_PREM_CALC_MTHD;
	}

	public void setListPROD_PREM_CALC_MTHD(
			List<SelectItem> listPROD_PREM_CALC_MTHD) {
		this.listPROD_PREM_CALC_MTHD = listPROD_PREM_CALC_MTHD;
	}

	public List<SelectItem> getListPROD_RSA_CALC_TYP() {
		if (listPROD_RSA_CALC_TYP.size() == 0) {
			listPROD_RSA_CALC_TYP.clear();
			try {
				listPROD_RSA_CALC_TYP = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_RSA_CALC_TYP;
	}

	public void setListPROD_RSA_CALC_TYP(List<SelectItem> listPROD_RSA_CALC_TYP) {
		this.listPROD_RSA_CALC_TYP = listPROD_RSA_CALC_TYP;
	}

	public List<SelectItem> getListPROD_MRTA_RATE_CALC_YN() {
		if (listPROD_MRTA_RATE_CALC_YN.size() == 0) {
			listPROD_MRTA_RATE_CALC_YN.clear();
			try {
				listPROD_MRTA_RATE_CALC_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_MRTA_RATE_CALC_YN;
	}

	public void setListPROD_MRTA_RATE_CALC_YN(
			List<SelectItem> listPROD_MRTA_RATE_CALC_YN) {
		this.listPROD_MRTA_RATE_CALC_YN = listPROD_MRTA_RATE_CALC_YN;
	}

	public List<SelectItem> getListPROD_CBC_YN() {
		if (listPROD_CBC_YN.size() == 0) {
			listPROD_CBC_YN.clear();
			try {
				listPROD_CBC_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_CBC_YN;
	}

	public void setListPROD_CBC_YN(List<SelectItem> listPROD_CBC_YN) {
		this.listPROD_CBC_YN = listPROD_CBC_YN;
	}

	public List<SelectItem> getListPROD_DRIP_MTHD() {
		if (listPROD_DRIP_MTHD.size() == 0) {
			listPROD_DRIP_MTHD.clear();
			try {
				listPROD_DRIP_MTHD = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_DRIP_MTHD;
	}

	public void setListPROD_DRIP_MTHD(List<SelectItem> listPROD_DRIP_MTHD) {
		this.listPROD_DRIP_MTHD = listPROD_DRIP_MTHD;
	}

	public List<SelectItem> getListPROD_AUTO_APPROV() {
		if (listPROD_AUTO_APPROV.size() == 0) {
			listPROD_AUTO_APPROV.clear();
			try {
				listPROD_AUTO_APPROV = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_AUTO_APPROV;
	}

	public void setListPROD_AUTO_APPROV(List<SelectItem> listPROD_AUTO_APPROV) {
		this.listPROD_AUTO_APPROV = listPROD_AUTO_APPROV;
	}

	public List<SelectItem> getListPROD_SURR_CALC_TYPE() {
		if (listPROD_SURR_CALC_TYPE.size() == 0) {
			listPROD_SURR_CALC_TYPE.clear();
			try {
				listPROD_SURR_CALC_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_SURR_CALC_TYPE;
	}

	public void setListPROD_SURR_CALC_TYPE(
			List<SelectItem> listPROD_SURR_CALC_TYPE) {
		this.listPROD_SURR_CALC_TYPE = listPROD_SURR_CALC_TYPE;
	}

	public List<SelectItem> getListPROD_AUTO_UW() {
		if (listPROD_AUTO_UW.size() == 0) {
			listPROD_AUTO_UW.clear();
			try {
				listPROD_AUTO_UW = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_AUTO_UW;
	}

	public void setListPROD_AUTO_UW(List<SelectItem> listPROD_AUTO_UW) {
		this.listPROD_AUTO_UW = listPROD_AUTO_UW;
	}

	public List<SelectItem> getListPROD_ROUND_OPTION() {
		if (listPROD_ROUND_OPTION.size() == 0) {
			listPROD_ROUND_OPTION.clear();
			try {
				listPROD_ROUND_OPTION = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_ROUND_OPTION;
	}

	public void setListPROD_ROUND_OPTION(List<SelectItem> listPROD_ROUND_OPTION) {
		this.listPROD_ROUND_OPTION = listPROD_ROUND_OPTION;
	}

	public List<SelectItem> getListPROD_INST_BASIS() {
		if (listPROD_INST_BASIS.size() == 0) {
			listPROD_INST_BASIS.clear();
			try {
				listPROD_INST_BASIS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_INST_BASIS;
	}

	public void setListPROD_INST_BASIS(List<SelectItem> listPROD_INST_BASIS) {
		this.listPROD_INST_BASIS = listPROD_INST_BASIS;
	}

	public List<SelectItem> getListPROD_MODE_OF_CALC() {
		if (listPROD_MODE_OF_CALC.size() == 0) {
			listPROD_MODE_OF_CALC.clear();
			try {
				listPROD_MODE_OF_CALC = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_MODE_OF_CALC;
	}

	public void setListPROD_MODE_OF_CALC(List<SelectItem> listPROD_MODE_OF_CALC) {
		this.listPROD_MODE_OF_CALC = listPROD_MODE_OF_CALC;
	}

	public List<SelectItem> getListPROD_WITHDRAW_YN() {
		if (listPROD_WITHDRAW_YN.size() == 0) {
			listPROD_WITHDRAW_YN.clear();
			try {
				listPROD_WITHDRAW_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_WITHDRAW_YN;
	}

	public void setListPROD_WITHDRAW_YN(List<SelectItem> listPROD_WITHDRAW_YN) {
		this.listPROD_WITHDRAW_YN = listPROD_WITHDRAW_YN;
	}

	public List<SelectItem> getListPROD_THR_BASIS() {
		if (listPROD_THR_BASIS.size() == 0) {
			listPROD_THR_BASIS.clear();
			try {
				listPROD_THR_BASIS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_THR_BASIS;
	}

	public void setListPROD_THR_BASIS(List<SelectItem> listPROD_THR_BASIS) {
		this.listPROD_THR_BASIS = listPROD_THR_BASIS;
	}

	public List<SelectItem> getListPROD_RI_RECOV_BASIS() {
		if (listPROD_RI_RECOV_BASIS.size() == 0) {
			listPROD_RI_RECOV_BASIS.clear();
			try {
				listPROD_RI_RECOV_BASIS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_RI_RECOV_BASIS;
	}

	public void setListPROD_RI_RECOV_BASIS(
			List<SelectItem> listPROD_RI_RECOV_BASIS) {
		this.listPROD_RI_RECOV_BASIS = listPROD_RI_RECOV_BASIS;
	}

	public List<SelectItem> getListPROD_TOPUP_YN() {
		if (listPROD_TOPUP_YN.size() == 0) {
			listPROD_TOPUP_YN.clear();
			try {
				listPROD_TOPUP_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_TOPUP_YN;
	}

	public void setListPROD_TOPUP_YN(List<SelectItem> listPROD_TOPUP_YN) {
		this.listPROD_TOPUP_YN = listPROD_TOPUP_YN;
	}

	public List<SelectItem> getListPROD_TOLL_LIMIT_YN() {
		if (listPROD_TOLL_LIMIT_YN.size() == 0) {
			listPROD_TOLL_LIMIT_YN.clear();
			try {
				listPROD_TOLL_LIMIT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_TOLL_LIMIT_YN;
	}

	public void setListPROD_TOLL_LIMIT_YN(
			List<SelectItem> listPROD_TOLL_LIMIT_YN) {
		this.listPROD_TOLL_LIMIT_YN = listPROD_TOLL_LIMIT_YN;
	}

	public List<SelectItem> getListPROD_INTER_FUND_YN() {
		if (listPROD_INTER_FUND_YN.size() == 0) {
			listPROD_INTER_FUND_YN.clear();
			try {
				listPROD_INTER_FUND_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_INTER_FUND_YN;
	}

	public void setListPROD_INTER_FUND_YN(
			List<SelectItem> listPROD_INTER_FUND_YN) {
		this.listPROD_INTER_FUND_YN = listPROD_INTER_FUND_YN;
	}

	public List<SelectItem> getListPROD_BUY_BASIS() {
		if (listPROD_BUY_BASIS.size() == 0) {
			listPROD_BUY_BASIS.clear();
			try {
				listPROD_BUY_BASIS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_BUY_BASIS;
	}

	public void setListPROD_BUY_BASIS(List<SelectItem> listPROD_BUY_BASIS) {
		this.listPROD_BUY_BASIS = listPROD_BUY_BASIS;
	}

	public List<SelectItem> getListPROD_LOAD_CHARGE_YN() {
		if (listPROD_LOAD_CHARGE_YN.size() == 0) {
			listPROD_LOAD_CHARGE_YN.clear();
			try {
				listPROD_LOAD_CHARGE_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_LOAD_CHARGE_YN;
	}

	public void setListPROD_LOAD_CHARGE_YN(
			List<SelectItem> listPROD_LOAD_CHARGE_YN) {
		this.listPROD_LOAD_CHARGE_YN = listPROD_LOAD_CHARGE_YN;
	}

	public List<SelectItem> getListPROD_ALLOC_TYPE() {
		if (listPROD_ALLOC_TYPE.size() == 0) {
			listPROD_ALLOC_TYPE.clear();
			try {
				listPROD_ALLOC_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_ALLOC_TYPE;
	}

	public void setListPROD_ALLOC_TYPE(List<SelectItem> listPROD_ALLOC_TYPE) {
		this.listPROD_ALLOC_TYPE = listPROD_ALLOC_TYPE;
	}

	public List<SelectItem> getListPROD_SERVICE_TAX_YN() {
		if (listPROD_SERVICE_TAX_YN.size() == 0) {
			listPROD_SERVICE_TAX_YN.clear();
			try {
				listPROD_SERVICE_TAX_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_SERVICE_TAX_YN;
	}

	public void setListPROD_SERVICE_TAX_YN(
			List<SelectItem> listPROD_SERVICE_TAX_YN) {
		this.listPROD_SERVICE_TAX_YN = listPROD_SERVICE_TAX_YN;
	}

	public List<SelectItem> getListPROD_AGENT_HIRE_YN() {
		if (listPROD_AGENT_HIRE_YN.size() == 0) {
			listPROD_AGENT_HIRE_YN.clear();
			try {
				listPROD_AGENT_HIRE_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_AGENT_HIRE_YN;
	}

	public void setListPROD_AGENT_HIRE_YN(
			List<SelectItem> listPROD_AGENT_HIRE_YN) {
		this.listPROD_AGENT_HIRE_YN = listPROD_AGENT_HIRE_YN;
	}

	public List<SelectItem> getListPROD_TOPUP_CHARGE_TYPE() {
		if (listPROD_TOPUP_CHARGE_TYPE.size() == 0) {
			listPROD_TOPUP_CHARGE_TYPE.clear();
			try {
				listPROD_TOPUP_CHARGE_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_TOPUP_CHARGE_TYPE;
	}

	public void setListPROD_TOPUP_CHARGE_TYPE(
			List<SelectItem> listPROD_TOPUP_CHARGE_TYPE) {
		this.listPROD_TOPUP_CHARGE_TYPE = listPROD_TOPUP_CHARGE_TYPE;
	}

	public List<SelectItem> getListPROD_CALC_ALLOC() {
		if (listPROD_CALC_ALLOC.size() == 0) {
			listPROD_CALC_ALLOC.clear();
			try {
				listPROD_CALC_ALLOC = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_CALC_ALLOC;
	}

	public void setListPROD_CALC_ALLOC(List<SelectItem> listPROD_CALC_ALLOC) {
		this.listPROD_CALC_ALLOC = listPROD_CALC_ALLOC;
	}

	public List<SelectItem> getListPROD_BROK_CALC_MTHD() {
		if (listPROD_BROK_CALC_MTHD.size() == 0) {
			listPROD_BROK_CALC_MTHD.clear();
			try {
				listPROD_BROK_CALC_MTHD = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_BROK_CALC_MTHD;
	}

	public void setListPROD_BROK_CALC_MTHD(
			List<SelectItem> listPROD_BROK_CALC_MTHD) {
		this.listPROD_BROK_CALC_MTHD = listPROD_BROK_CALC_MTHD;
	}

	public List<SelectItem> getListPROD_COMM_RND_TYPE() {
		if (listPROD_COMM_RND_TYPE.size() == 0) {
			listPROD_COMM_RND_TYPE.clear();
			try {
				listPROD_COMM_RND_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_COMM_RND_TYPE;
	}

	public void setListPROD_COMM_RND_TYPE(
			List<SelectItem> listPROD_COMM_RND_TYPE) {
		this.listPROD_COMM_RND_TYPE = listPROD_COMM_RND_TYPE;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void firePROD_TOPUP_MULTIPLE(ActionEvent actionEvent){
		try {
			helper.validPROD_TOPUP_MULTIPLE(PM_IL_PRODUCT_BEAN.getPROD_TOPUP_MULTIPLE(),PM_IL_PRODUCT_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PROD_TOPUP_MULTIPLE", e.getMessage());
		}
	}

	public void PROD_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_CODE((String) value);
			helper.PROD_CODE_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void PROD_DESC_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_IL_PRODUCT_BEAN.setPROD_DESC((String) value);
			helper.PROD_DESC_WHEN_VALIDATE_ITEM(compositeAction, value);
			
			/*Commentted by saritha on 05-04-2018 for KIC Product Short Description &Long Description Values Reseting*/
			//COMP_PROD_LONG_DESC.resetValue();
			//COMP_PROD_SHORT_DESC.resetValue();
			/*End*/
			
			//COMP_PROD_LONG_DESC.setValue(PM_IL_PRODUCT_BEAN.getPROD_LONG_DESC());
			//COMP_PROD_SHORT_DESC.setValue(PM_IL_PRODUCT_BEAN.getPROD_SHORT_DESC());
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

	public void PROD_PLAN_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.PROD_PLAN_CODE_WHEN_VALIDATE_ITEM(compositeAction, value);
			PM_IL_PRODUCT_BEAN.setPROD_PLAN_CODE((String) value);
			if(compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PLAN_PERIOD_FROM() != null){
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PLAN_PERIOD_FROM().resetValue();
			}
			if(compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PLAN_PERIOD_TO() != null){
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PLAN_PERIOD_TO().resetValue();
			}
			if(compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PLAN_MAX_AGE_ON_MAT() != null){
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PLAN_MAX_AGE_ON_MAT().resetValue();
			}
			COMP_PROD_PREM_PAY_YRS.resetValue();
			COMP_PROD_SA_INST_PYMT_TYPE.resetValue();
			COMP_PROD_ENDT_VAL_DAYS.resetValue();
			COMP_PROD_MORT_CODE.resetValue();
			COMP_PROD_MAX_DEFER_MONTHS.resetValue();
			COMP_PROD_INST_RATE_PER.resetValue();
			COMP_PROD_DEF_PERIOD_FLAG.resetValue();
			COMP_PROD_RSA_CALC_TYP.resetValue();
			COMP_PROD_CONT_LOAD_RATE.resetValue();
			COMP_PROD_CONT_LOAD_RATE_PER.resetValue();
			COMP_PROD_EXP_LOAD_RATE.resetValue();
			COMP_PROD_EXP_LOAD_RATE_PER.resetValue();
			COMP_PROD_INST_PERC.resetValue();
			COMP_PROD_AGE_SET_BACK.resetValue();
			COMP_UI_M_PROD_MORT_CODE_DESC.resetValue();
			COMP_UI_M_PROD_PLAN_CODE_DESC.resetValue();
			COMP_PROD_PERIOD.resetValue();
			COMP_PROD_ENDT_VAL_DAYS.resetValue();
			COMP_PROD_EMI_TOLERANCE.resetValue();
			COMP_PROD_CBC_YN.resetValue();
			COMP_PROD_PREM_CALC_MTHD.resetValue();
			COMP_PROD_INST_BASIS.resetValue();
			COMP_PROD_MRTA_RATE_CALC_YN.resetValue();
			COMP_PROD_MORT_CODE.resetValue();
			compositeAction
			.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
			.getCOMP_PALT_LOAD_APPL_PERC().resetValue();
			COMP_PROD_WITHDRAW_YN.resetValue();
			COMP_PROD_INST_PERC.resetValue();
			COMP_PROD_SA_FACTOR.resetValue();
			COMP_PROD_SA_ADD_FACTOR.resetValue();
			COMP_PROD_BUY_BASIS.resetValue();
			COMP_PROD_ALLOC_TYPE.resetValue();
			COMP_PROD_CALC_ALLOC.resetValue();
			COMP_PROD_PREM_HOLIDAY_CODE.resetValue();
			
			
			
			
			compositeAction
			.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
			.getCOMP_PALT_LOAD_APPL_PERC().resetValue();
			
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

	public void PROD_PERIOD_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_PERIOD((Integer) value);
			helper.PROD_PERIOD_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void PROD_PREM_PAY_YRS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_PREM_PAY_YRS((Integer) value);
			helper.PROD_PREM_PAY_YRS_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_PROD_TARIFF_TERM_FLAG.resetValue();
			COMP_PROD_TARIFF_TERM_FLAG.resetValue();
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

	public void PROD_SA_INST_PYMT_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_SA_INST_PYMT_TYPE((String) value);
			helper.PROD_SA_INST_PYMT_TYPE_WHEN_VALIDATE_ITEM(compositeAction,
					value);
			//No fields UI_M_DUMMY and UI_M_DUMMY_1 available in xhtml so its throw null pointer
			/*compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PROD_SA_INST_PYMT_TYPE().resetValue();
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_DUMMY().resetValue();
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_DUMMY1().resetValue();*/
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

	public void PROD_DS_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_DS_CODE((String) value);
			helper.PROD_DS_CODE_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_UI_M_PROD_DS_CODE_DESC.resetValue();
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

	public void PROD_EFF_FM_DT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_EFF_FM_DT((Date) value);
			helper.PROD_EFF_FM_DT_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void PROD_EFF_TO_DT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_EFF_TO_DT((Date) value);
			helper.PROD_EFF_TO_DT_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void PROD_SA_BY_PLAN_BASIS_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_SA_BY_PLAN_BASIS_YN((String) value);
			helper.PROD_SA_BY_PLAN_BASIS_YN_WHEN_VALIDATE_ITEM(compositeAction,
					value);
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

	public void PROD_FUND_ALLOWED_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_FUND_ALLOWED((String) value);
			helper.PROD_FUND_ALLOWED_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void PROD_TOL_CHK_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_TOL_CHK_YN((String) value);
			helper.PROD_TOL_CHK_YN_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void PROD_BL_DESC_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_BL_DESC((String) value);
			helper.PROD_BL_DESC_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_PROD_BL_LONG_DESC.resetValue();
			COMP_PROD_BL_SHORT_DESC.resetValue();
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

	public void PROD_COOLOFF_DAYS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_COOLOFF_DAYS((Integer) value);
			helper.PROD_COOLOFF_DAYS_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void PROD_MATU_DT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_IL_PRODUCT_BEAN.setPROD_MATU_DT((String) value);
			helper.PROD_MATU_DT_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void PROD_THRESHOLD_PERC_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_THRESHOLD_PERC((Double) value);
			helper.PROD_THRESHOLD_PERC_WHEN_VALIDATE_ITEM(compositeAction,
					value);
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
	
	//added by agalya on 05/07/2016 for field validation, ref no- FALCONQC-1714490
	public void PROD_RSA_CALC_TYP_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			System.out.println("inside validator PROD_RSA_CALC_TYP_Validator");
			getPM_IL_PRODUCT_BEAN().setPROD_RSA_CALC_TYP((String) value);
			System.out.println("inside PROD_RSA_CALC_TYP validator   :"+getPM_IL_PRODUCT_BEAN().getPROD_RSA_CALC_TYP());
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
	
	
	public void PROD_MRTA_RATE_CALC_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			System.out.println("inside validator PROD_MRTA_RATE_CALC_YN");
			getPM_IL_PRODUCT_BEAN().setPROD_MRTA_RATE_CALC_YN((String) value);
			System.out.println("inside PROD_MRTA_RATE_CALC_YN validator   :"+getPM_IL_PRODUCT_BEAN().getPROD_MRTA_RATE_CALC_YN());
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
	
	public void validatePROD_CONT_LOAD_RATE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			getPM_IL_PRODUCT_BEAN().setPROD_CONT_LOAD_RATE((Double) value);
		
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
	
	
	public void validatePROD_CONT_LOAD_RATE_PER(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			getPM_IL_PRODUCT_BEAN().setPROD_CONT_LOAD_RATE_PER((Integer) value);
			
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
	
	
	public void validatePROD_EXP_LOAD_RATE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			getPM_IL_PRODUCT_BEAN().setPROD_EXP_LOAD_RATE((Double) value);
			
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
	
	
	public void validatePROD_EXP_LOAD_RATE_PER(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			getPM_IL_PRODUCT_BEAN().setPROD_EXP_LOAD_RATE_PER((Integer) value);
			
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
	
	public void validatePROD_AGE_SET_BACK(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			getPM_IL_PRODUCT_BEAN().setPROD_AGE_SET_BACK((Integer) value);
			
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
	
	public void PROD_INST_RATE_PER_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			getPM_IL_PRODUCT_BEAN().setPROD_INST_RATE_PER((Double) value);
			
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
	//end
	public void PROD_DEF_PERIOD_FLAG_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			System.out.println("inside validator of def period flag");
			getPM_IL_PRODUCT_BEAN().setPROD_DEF_PERIOD_FLAG((String) value);
			System.out.println("inside PROD_DEF_PERIOD_FLAG validator   :"+getPM_IL_PRODUCT_BEAN().getPROD_DEF_PERIOD_FLAG());
			helper.PROD_DEF_PERIOD_FLAG_WHEN_VALIDATE_ITEM(compositeAction,
					value);
			COMP_PROD_DEF_PERIOD_FLAG.resetValue();
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
	public void PROD_EMI_TOLERANCE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_IL_PRODUCT_BEAN.setPROD_EMI_TOLERANCE((Integer) value);
			helper
					.PROD_ENDT_VAL_DAYS_WHEN_VALIDATE_ITEM(compositeAction,
							value);
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

	public void PROD_ENDT_VAL_DAYS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_ENDT_VAL_DAYS((Integer) value);
			helper
					.PROD_ENDT_VAL_DAYS_WHEN_VALIDATE_ITEM(compositeAction,
							value);
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

	public void PROD_MAT_AMT_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_MAT_AMT_TYPE((String) value);
			helper.PROD_MAT_AMT_TYPE_WHEN_VALIDATE_ITEM(compositeAction, value);
			/*Added by kavitha on 08.01.2019 as per siva sir sugg */
			String prod_mat_amt_type = (String) value;
			System.out.println("value of:"+prod_mat_amt_type);
	        System.out.println("getPROD_MAT_AMT_TYPE"+getPM_IL_PRODUCT_BEAN().getPROD_MAT_AMT_TYPE());
		
			if("F".equalsIgnoreCase(prod_mat_amt_type))
			{
				COMP_PROD_FORMULA_MAT.setDisabled(false);
			}else{
				COMP_PROD_FORMULA_MAT.setDisabled(true);	
				COMP_PROD_FORMULA_MAT.resetValue();
				COMP_UI_PROD_FORMULA_MAT_DESC.resetValue();
				/*Added by kavitha on 08.01.2019 as per siva sir sugg */
				getPM_IL_PRODUCT_BEAN().setPROD_FORMULA_MAT(null);
				/*End*/
				getPM_IL_PRODUCT_BEAN().setUI_PROD_FORMULA_MAT_DESC(null);
				System.out.println("getPROD_MAT_AMT_TYPE"+getPM_IL_PRODUCT_BEAN().getUI_PROD_FORMULA_MAT_DESC());
			}
			/*End*/
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

	public void PROD_SURR_PLUS_FACTOR_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_SURR_PLUS_FACTOR((String) value);
			helper.PROD_SURR_PLUS_FACTOR_WHEN_VALIDATE_ITEM(compositeAction,
					value);
			COMP_PROD_SURR_PLUS_FACTOR_DESC.resetValue();
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

public void PROD_SURR_CALC_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
				getPM_IL_PRODUCT_BEAN().setPROD_SURR_CALC_TYPE((String) value);
				String prod_surr_calc_type = (String) value;
				System.out.println("value of:"+prod_surr_calc_type);
			System.out.println("getPROD_SURR_CALC_TYPE"+getPM_IL_PRODUCT_BEAN().getPROD_SURR_CALC_TYPE());
			helper.PROD_SURR_CALC_TYPE_WHEN_VALIDATE_ITEM(compositeAction,
					value);
			//added by saranya
			if("F".equalsIgnoreCase(prod_surr_calc_type))
			{
				COMP_PROD_FORMULA_SURR.setDisabled(false);	
				COMP_PROD_PAIDUP_FORMULA.setDisabled(false);
				System.out.println("getUI_PROD_FORMULA_SURR_DESC"+getPM_IL_PRODUCT_BEAN().getUI_PROD_FORMULA_SURR_DESC());
				System.out.println("getUI_PROD_PAIDUP_FORMULA_DESC"+getPM_IL_PRODUCT_BEAN().getUI_PROD_PAIDUP_FORMULA_DESC());
			}else{
				COMP_PROD_FORMULA_SURR.setDisabled(true);	
				COMP_PROD_PAIDUP_FORMULA.setDisabled(true);
				COMP_PROD_FORMULA_SURR.resetValue();
				COMP_PROD_PAIDUP_FORMULA.resetValue();
				getPM_IL_PRODUCT_BEAN().setUI_PROD_FORMULA_SURR_DESC(null);
				getPM_IL_PRODUCT_BEAN().setUI_PROD_PAIDUP_FORMULA_DESC(null);
			}
			//END
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
/*	public void PROD_SURR_CALC_TYPE_Validator(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		System.out.println("value of user "+input);
		try {
				getPM_IL_PRODUCT_BEAN().setPROD_SURR_CALC_TYPE((String) input.toString());
				String prod_surr_calc_type = (String) input.toString();
				System.out.println("value of:"+prod_surr_calc_type);
			System.out.println("getPROD_SURR_CALC_TYPE"+getPM_IL_PRODUCT_BEAN().getPROD_SURR_CALC_TYPE());
			helper.PROD_SURR_CALC_TYPE_WHEN_VALIDATE_ITEM(compositeAction,
					input);
			if("F".equalsIgnoreCase(prod_surr_calc_type))
			{
				COMP_PROD_FORMULA_SURR.setDisabled(false);	
				COMP_PROD_PAIDUP_FORMULA.setDisabled(false);
			}else{
				COMP_PROD_FORMULA_SURR.setDisabled(true);	
				COMP_PROD_PAIDUP_FORMULA.setDisabled(true);
			}
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
*/
	public void PROD_SURRENDER_FACTOR_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_SURRENDER_FACTOR((String) value);
			helper.PROD_SURRENDER_FACTOR_WHEN_VALIDATE_ITEM(compositeAction,
					value);
			COMP_PROD_SURRENDER_FACTOR_DESC.resetValue();
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

	public void PROD_WAKFEE_FACTOR_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_WAKFEE_FACTOR((String) value);
			helper.PROD_WAKFEE_FACTOR_WHEN_VALIDATE_ITEM(compositeAction,value);
			COMP_PROD_WAKFEE_FACTOR_DESC.resetValue();
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

	public void PROD_WITHDRAW_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_WITHDRAW_YN((String) value);
			helper.PROD_WITHDRAW_YN_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void PROD_TOPUP_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			String prevValue=getPM_IL_PRODUCT_BEAN().getPROD_TOPUP_YN();
			
			String currValue=(String) value;
			if(!prevValue.equalsIgnoreCase(currValue))
			{
			//getPM_IL_PRODUCT_BEAN().setPROD_TOPUP_YN((String) value);
			helper.PROD_TOPUP_YN_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_PROD_TOPUP_MIN_YRS.resetValue();
			COMP_PROD_TOPUP_PROD_PERC.resetValue();
			COMP_PROD_TOPUP_COMM_CODE.resetValue();
			COMP_PROD_FUND_FEE.resetValue();
			COMP_PROD_FUND_FEE_RATE_PER.resetValue();
			COMP_PROD_TOPUP_CHARGE_TYPE.resetValue();
			COMP_PROD_FUND_FEE.resetValue();
			COMP_PROD_FUND_FEE_RATE_PER.resetValue();
			COMP_PROD_TOPUP_MIN_YRS.resetValue();
			COMP_PROD_TOPUP_PROD_PERC.resetValue();
			COMP_PROD_TOPUP_COMM_CODE.resetValue();
			COMP_PROD_FUND_FEE.resetValue();
			COMP_PROD_FUND_FEE_RATE_PER.resetValue();
			COMP_PROD_TOPUP_CHARGE_TYPE.resetValue();
			COMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION.resetValue();
			}
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

	public void PROD_AFTWD_LC_MINBALValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			Double val = (Double)value;
			getPM_IL_PRODUCT_BEAN().setPROD_AFTWD_LC_MINBAL(val);
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
	
	public void PROD_TOPUP_PROD_PERC_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_TOPUP_PROD_PERC((Double) value);
			helper.PROD_TOPUP_PROD_PERC_WHEN_VALIDATE_ITEM(compositeAction,
					value);
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

	public void PROD_TOPUP_COMM_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_TOPUP_COMM_CODE((String) value);
			helper.PROD_TOPUP_COMM_CODE_WHEN_VALIDATE_ITEM(compositeAction,
					value);
			COMP_UI_M_PROD_TOPUP_COMM_DESCRIPTION.resetValue();
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

	public void PROD_TOPUP_CHARGE_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_TOPUP_CHARGE_TYPE((String) value);
			helper.PROD_TOPUP_CHARGE_TYPE_WHEN_VALIDATE_ITEM(compositeAction,
					value);
			COMP_PROD_FUND_FEE.resetValue();
			COMP_PROD_FUND_FEE_RATE_PER.resetValue();
			
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

	public void PROD_TOPUP_WAK_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_TOPUP_WAK_CODE((String) value);
			helper.PROD_TOPUP_WAK_CODE_WHEN_VALIDATE_ITEM(compositeAction,
					value);
			COMP_UI_M_PROD_WAK_CODE_DESC.resetValue();
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

	
	
	public void PROD_PREM_CALC_MTHD_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_PREM_CALC_MTHD((String) value);
			helper.PROD_PREM_CALC_MTHD_WHEN_VALIDATE_ITEM(compositeAction,
					value);
			COMP_PROD_MRTA_RATE_CALC_YN.resetValue();
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

	public void PROD_CBC_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_CBC_YN((String) value);
			helper.PROD_CBC_YN_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_PROD_AUTO_APPROV.resetValue();
			/*Added by Ameen on 25-03-2018 for KIC part payment*/
			if("Y".equalsIgnoreCase(PM_IL_PRODUCT_BEAN.getPROD_CBC_YN())){
				COMP_PROD_CBC_LIMIT.setDisabled(false);
			}else{
				COMP_PROD_CBC_LIMIT.setDisabled(true);
			}
			/*End*/
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

	public void PROD_SA_FACTOR_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_SA_FACTOR((String) value);
			helper.PROD_SA_FACTOR_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_UI_M_PROD_SA_FACTOR_DESC.resetValue();
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

	public void PROD_SA_TARIFF_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_SA_TARIFF((String) value);
			helper.PROD_SA_TARIFF_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_UI_M_PROD_SA_TARIFF_DESC.resetValue();
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

	public void PROD_AUTO_UW_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_AUTO_UW((String) value);
			helper.PROD_AUTO_UW_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_PROD_INST_PERC.resetValue();
			COMP_PROD_INST_RATE_PER.resetValue();
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

	public void PROD_SA_ADD_FACTOR_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_SA_ADD_FACTOR((String) value);
			helper
					.PROD_SA_ADD_FACTOR_WHEN_VALIDATE_ITEM(compositeAction,
							value);
			COMP_UI_M_PROD_SA_ADD_FACTOR_DESC.resetValue();
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

	public void PROD_ROUND_OPTION_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			String prevalue =getPM_IL_PRODUCT_BEAN().getPROD_ROUND_OPTION();
			String curvalue=(String)value;
			if(!(prevalue.equalsIgnoreCase(curvalue))){
			getPM_IL_PRODUCT_BEAN().setPROD_ROUND_OPTION((String) value);
			helper.PROD_ROUND_OPTION_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_PROD_ROUND_VALUE.resetValue();
		}
		}catch (Exception e) {
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
	
	public void PROD_ROUND_VALUE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_ROUND_VALUE((Integer) value);
			//COMP_PROD_ROUND_VALUE.resetValue();
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


	public void PROD_INST_BASIS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_INST_BASIS((String) value);
			helper.PROD_INST_BASIS_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_PROD_INST_PERC.resetValue();
			COMP_PROD_INST_RATE_PER.resetValue();
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

	public void PROD_PREM_TARIFF_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_PREM_TARIFF((String) value);
			helper.PROD_PREM_TARIFF_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_UI_M_PROD_PREM_TARIFF_DESC.resetValue();
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

	public void PROD_INST_PERC_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_INST_PERC((Double) value);
			helper.PROD_INST_PERC_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void PROD_GRP_THRESHOLD_PERC_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_GRP_THRESHOLD_PERC((Double) value);
			helper.PROD_GRP_THRESHOLD_PERC_WHEN_VALIDATE_ITEM(compositeAction,
					value);
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

	public void PROD_MORT_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_MORT_CODE((String) value);
			helper.PROD_MORT_CODE_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_UI_M_PROD_MORT_CODE_DESC.resetValue();
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

	public void PROD_TOLL_LIMIT_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_TOLL_LIMIT_YN((String) value);
			helper
					.PROD_TOLL_LIMIT_YN_WHEN_VALIDATE_ITEM(compositeAction,
							value);
			COMP_PROD_INTER_FUND_YN.resetValue();
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

	public void PROD_AGENT_HIRE_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_AGENT_HIRE_YN((String) value);
			helper
					.PROD_AGENT_HIRE_YN_WHEN_VALIDATE_ITEM(compositeAction,
							value);
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

	public void PROD_BCH_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_BCH_CODE((String) value);
			helper.PROD_BCH_CODE_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_UI_M_PROD_BCH_CODE_DESC.resetValue();
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

	public List<LovBean> lovPROD_DS_CODE(Object currValue) {

		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();


		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_DS_CODE", "1", null, null, null,
					null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPROD_SA_FACTOR(Object currValue) {

		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();


		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_SA_FACTOR", "IL_VAL_TAR", null,
					null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPROD_BCH_CODE(Object currValue) {

		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();


		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_BCH_CODE", null, null, null, null,
					null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPROD_PLAN_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_PLAN_CODE", "S", null, null, null,
					null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPROD_MORT_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_MORT_CODE", "IL_MORT_CODE", null,
					null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPROD_SA_TARIFF(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_SA_TARIFF", "IL_VAL_TAR", null,
					null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPROD_SA_ADD_FACTOR(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_SA_ADD_FACTOR", "IL_VAL_TAR", null,
					null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPROD_PREM_TARIFF(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_PREM_TARIFF", "IL_VAL_TAR", null,
					null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPROD_TOPUP_COMM_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_TOPUP_COMM_CODE", null, null, null,
					null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPROD_TOPUP_WAK_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_TOPUP_WAK_CODE", "IL_MORT_CODE",
					null, null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPROD_SURR_PLUS_FACTOR(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_SURR_PLUS_FACTOR", "IL_VAL_TAR",
					null, null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPROD_WAKFEE_FACTOR(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_WAKFEE_FACTOR", "IL_VAL_TAR", null,
					null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPROD_SURRENDER_FACTOR(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_SURRENDER_FACTOR", "IL_VAL_TAR",
					null, null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	//added by saranya
	public List<LovBean> lovPROD_FORMULA_SURR(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_FORMULA_SURR",null,
					null, null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovPROD_PAIDUP_FORMULA(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_PAIDUP_FORMULA",null,
					null, null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	//end

	public List<LovBean> lovPROD_PREM_HOLIDAY_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PRODUCT", "PROD_PREM_HOLIDAY_CODE", "IL_VAL_TAR",
					null, null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public void PROD_BROK_CALC_MTHD_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_BROK_CALC_MTHD((String) value);
			helper.PROD_BROK_CALC_MTHD_WHEN_VALIDATE_ITEM(compositeAction,
					value);
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

	public void PROD_PREM_HOLIDAY_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_PREM_HOLIDAY_CODE((String) value);
			helper.PROD_PREM_HOLIDAY_CODE_WHEN_VALIDATE_ITEM(compositeAction,
					value);
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

	public void PROD_COMM_RND_DEC_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_COMM_RND_DEC((Integer) value);
			helper.PROD_COMM_RND_DEC_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void PROD_COMM_RND_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_COMM_RND_TYPE((String) value);
			helper.PROD_COMM_RND_TYPE_WHEN_LIST_CHANGED(compositeAction, value);
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

	public void PROD_PRODUCTION_PERC_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_PRODUCTION_PERC((Double) value);
			helper.PROD_PRODUCTION_PERC_WHEN_VALIDATE_ITEM(compositeAction,
					value);
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
	
	public void PROD_INC_WEIGHT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_INC_WEIGHT((Double) value);
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

	public void PROD_DEF_PERIOD_FM_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_DEF_PERIOD_FM((Integer) value);
			helper
					.PROD_DEF_PERIOD_FM_WHEN_VALIDATE_ITEM(compositeAction,
							value);
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

	public void PROD_DEF_PERIOD_TO_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_DEF_PERIOD_TO((Integer) value);
			helper
					.PROD_DEF_PERIOD_TO_WHEN_VALIDATE_ITEM(compositeAction,
							value);
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

	public void PROD_WAQAF_PERIOD_FM_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_WAQAF_PERIOD_FM((Integer) value);
			helper.PROD_WAQAF_PERIOD_FM_WHEN_VALIDATE_ITEM(compositeAction,
					value);
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

	public void PROD_WAQAF_PERIOD_TO_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_WAQAF_PERIOD_TO((Integer) value);
			helper.PROD_WAQAF_PERIOD_TO_WHEN_VALIDATE_ITEM(compositeAction,
					value);
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

	public void onLoad(PhaseEvent event) {
		try {
			if(PM_IL_PRODUCT_BEAN.getROWID() != null){
				COMP_PROD_CODE.setDisabled(true);
			}
			if (isFormFlag()) {
				helper.PRE_FORM(compositeAction);
				setFormFlag(false);
			}
			if (isBlockFlag()) {			
				
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);
				helper.ON_POPULATE_DETAILS(compositeAction);
				if (PM_IL_PRODUCT_BEAN.getROWID() == null) {
					helper.WHEN_CREATE_RECORD(compositeAction);
				} else {
					helper.POST_QUERY(compositeAction);
					if("U".equals(PM_IL_PRODUCT_BEAN.getPROD_PRODUCT_TYPE())){
						//PM_IL_PRODUCT_BEAN.setPROD_MATU_DT("S");
						/*Commanted by gopifor kic as suggested by ajoy on 01/04/2019*/
						//COMP_PROD_MATU_DT.setDisabled(true);
						COMP_PROD_FUND_ALLOWED.setDisabled(false);
					}else{
						/*Commanted by gopifor kic as suggested by ajoy on 01/04/2019*/
						//COMP_PROD_MATU_DT.setDisabled(false);
						COMP_PROD_FUND_ALLOWED.setDisabled(true);
					}
				}
				helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
				/*Added by sankara narayanan for hospital cash plan on 22/04/2017*/
				if("Y".equals(PM_IL_PRODUCT_BEAN.getPROD_INTR_SAVINGS_YN())){
					compositeAction.getWizard().enableWizardItem("PILM035_APAC_PM_IL_PROD_INTREST");
				}else{
					compositeAction.getWizard().disableWizardItem("PILM035_APAC_PM_IL_PROD_INTREST");
				}
				setUI_PROD_PLAN_TYPE(getPlanType(PM_IL_PRODUCT_BEAN.getPROD_PLAN_CODE()));
				/*end*/
				/*Added by saranya on 02/01/2017 for RM018T - FSD_IL_ZB Life_028-Cash Back*/
				System.out.println("PROD_CASHBACK_YN value :"+PM_IL_PRODUCT_BEAN.getPROD_CASHBACK_YN());
				if("Y".equals(PM_IL_PRODUCT_BEAN.getPROD_CASHBACK_YN())){
					compositeAction.getWizard().enableWizardItem("PILM035_APAC_CASHBACK");
				}else{
					compositeAction.getWizard().disableWizardItem("PILM035_APAC_CASHBACK");
				}
				/*End*/
				/*Added saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 13-03-2017*/
				 String prod_type=getPM_IL_PRODUCT_BEAN().getPROD_PRODUCT_TYPE();
				 System.out.println("prod_type  :"+prod_type);
				 
				 /*Modified by Janani on 07.05.2018 as suggested by ajay for fidelity*/
				 //if("U".equalsIgnoreCase(prod_type))

				 if("U".equalsIgnoreCase(prod_type) || "T".equalsIgnoreCase(prod_type))

					 /*End*/
				 {
					System.out.println("Unit link enabled");
					COMP_PROD_UNIT_LINK_TYPE.setDisabled(false);
				 }else{
					 COMP_PROD_UNIT_LINK_TYPE.setDisabled(true);
				 }
				/*End*/
				 /*Added by senthilnathan for alliance to handle validation for prod_ri_sa_calc on 12.02.2021*/
				 if(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_RI_SA_CALC_TYP().equalsIgnoreCase("F")){
						compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_RI_FORMULA_CODE().setDisabled(false);
						compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_RI_FORMULA_CODE().resetValue();
						compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_UI_M_PROD_RI_FORMULA_CODE_DESC().resetValue();
					}else{
						compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().setPROD_RI_FORMULA_CODE(null);
						compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().setUI_M_PROD_RI_FORMULA_CODE_DESC(null);
						compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_RI_FORMULA_CODE().setDisabled(true);
						compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_RI_FORMULA_CODE().resetValue();
						compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_UI_M_PROD_RI_FORMULA_CODE_DESC().resetValue();
					}
				setBlockFlag(false);
				
				
			}
			helper.check_conortakaful(this);
			//Added by saritha on 6.6.16
			compositeAction.getWizard().enableWizardItem("PILM035_APAC_PM_IL_PROD_PREM_LIMIT");
			//End
			//ADDED BY SARANYA for ssp call id FALCONQC-1714541			
			//if(("TRUE").equalsIgnoreCase(CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.SURR"), "FALSE")))
			String Plan_surr_YN=plan_surr_value();
			System.out.println("surrender value  :::"+CommonUtils.nvl(Plan_surr_YN, "N"));
			if("Y".equalsIgnoreCase(CommonUtils.nvl(Plan_surr_YN, "N")))
			{
				compositeAction.getWizard().enableWizardItem("PILM035_APAC_SURRENDER");
			}
			else
			{
				compositeAction.getWizard().disableWizardItem("PILM035_APAC_SURRENDER");
			}
			//end
			//added by saranya for suggesstion box
		     String prod_surr_calc_type=getPM_IL_PRODUCT_BEAN().getPROD_SURR_CALC_TYPE();
		     System.out.println("value of surrender tariff--->"+prod_surr_calc_type);
		     if("F".equalsIgnoreCase(prod_surr_calc_type))
				{
					COMP_PROD_FORMULA_SURR.setDisabled(false);	
					COMP_PROD_PAIDUP_FORMULA.setDisabled(false);
				}else{
					COMP_PROD_FORMULA_SURR.setDisabled(true);	
					COMP_PROD_PAIDUP_FORMULA.setDisabled(true);
				}
			//end
		     /* Added by kavitha on 08.01.2019 for suggesstion box*/
		     String prod_mat_amt_type=getPM_IL_PRODUCT_BEAN().getPROD_MAT_AMT_TYPE();
				System.out.println("value of:"+prod_mat_amt_type);
		        System.out.println("getPROD_MAT_AMT_TYPE"+getPM_IL_PRODUCT_BEAN().getPROD_MAT_AMT_TYPE());
			
				if("F".equalsIgnoreCase(prod_mat_amt_type))
				{
					COMP_PROD_FORMULA_MAT.setDisabled(false);	
				}else{
					COMP_PROD_FORMULA_MAT.setDisabled(true);	
				}
				/*end*/
		     /*Added by Ameen on 13-07-2017 for ZBILQC-1731624*/
		     if("Y".equalsIgnoreCase(PM_IL_PRODUCT_BEAN.getPROD_INTR_SAVINGS_YN()) || "U".equals(PM_IL_PRODUCT_BEAN.getPROD_PRODUCT_TYPE())){
		    	 COMP_MORE_INFO_3.setDisabled(false);
		     }else{
		    	 COMP_MORE_INFO_3.setDisabled(true);
		     }
		     /*end*/
		     
		     /*Added by Janani on 04.01.2018 for ZBLIFE-1459615*/
		     System.out.println("getPROD_PUP_YN               "+PM_IL_PRODUCT_BEAN.getPROD_PUP_YN());
				
				if(PM_IL_PRODUCT_BEAN.getPROD_PUP_YN() != null && PM_IL_PRODUCT_BEAN.getPROD_PUP_YN().equalsIgnoreCase("y")){
					
					COMP_PROD_MIN_PUP_AMT.setDisabled(false);
					COMP_PROD_DRIP_AMT.setDisabled(false);
				}
				else
				{
					COMP_PROD_MIN_PUP_AMT.setDisabled(true);
					COMP_PROD_DRIP_AMT.setDisabled(true);
				}
		    /*End*/ 
			/*Added by Ameen on 13-03-2018 for FSD_IL_04_GOLDA*/
			if(PM_IL_PRODUCT_BEAN.getROWID() != null){
				if("U".equalsIgnoreCase(PM_IL_PRODUCT_BEAN.getPROD_PRODUCT_TYPE())){
					COMP_PROD_MAT_AMT_LEVEL.setDisabled(false);
					COMP_PROD_RET_PREM_YN.setDisabled(true);
					COMP_PROD_REG_EXCESS_APP_YN.setDisabled(false);
				}else{
					COMP_PROD_MAT_AMT_LEVEL.setDisabled(true);
					COMP_PROD_RET_PREM_YN.setDisabled(false);
					COMP_PROD_REG_EXCESS_APP_YN.setDisabled(true);
				}
			}
			/*End*/
			
			/*Added by Ameen on 25-03-2018 for KIC part payment*/
			if("Y".equalsIgnoreCase(PM_IL_PRODUCT_BEAN.getPROD_CBC_YN())){
				COMP_PROD_CBC_LIMIT.setDisabled(false);
			}else{
				COMP_PROD_CBC_LIMIT.setDisabled(true);
			}
			/*End*/
			
			/*Added by Janani on 12.05.2018 for Fidelity as suggested by Sivaram for Funeral,hospital cash rider*/
			disableRiderApp();
			
			/*End*/
			
			/*Added by Janani on 15.06.2018 for KIC*/
			
			if(getPlanType(PM_IL_PRODUCT_BEAN.getPROD_PLAN_CODE()).equalsIgnoreCase("u"))
			{
				COMP_PROD_NGTV_SUS_YN.setDisabled(false);
			}
			else
			{
				COMP_PROD_NGTV_SUS_YN.setDisabled(true);
			}
		
			
			/*End*/
			
			/*Added by Janani on 02.07.2018 for FLALIFEQC-1754274*/
			PROD_SA_BY_PLAN_BASIS_YN_Enab_Disb();
			/*End*/
			
			
			/*Added by Janani on 02.07.2018 for Investment product as suggested by Sivaram*/
			
			if(getPlanType(PM_IL_PRODUCT_BEAN.getPROD_PLAN_CODE()).equalsIgnoreCase("h") || 
			getPlanType(PM_IL_PRODUCT_BEAN.getPROD_PLAN_CODE()).equalsIgnoreCase("i"))
			{
				COMP_PROD_INTR_SAVINGS_YN.setDisabled(false);
			}
			else
			{
				COMP_PROD_INTR_SAVINGS_YN.setDisabled(true);
			}
			
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	//ADDED BY SARANYA for ssp call id FALCONQC-1714541
	public String plan_surr_value() throws Exception{
	try
	{
		System.out.println("inside plan_surr_value function");
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		connection = CommonUtils.getConnection();
		String Plan_surr=null;
		String CURSOR_C1="select PLAN_SURR_YN from pm_il_plan where PLAN_CODE=?";
		resultSet = handler.executeSelectStatement(CURSOR_C1,
				connection,new Object[] {PM_IL_PRODUCT_BEAN.getPROD_PLAN_CODE()});
	    while (resultSet.next()) {
			 Plan_surr=resultSet.getString(1);
			System.out.println("value-->"+Plan_surr);
			
		}
		return Plan_surr;
	
    }catch (Exception e) {
	e.printStackTrace();
	throw new ValidatorException(new FacesMessage(e.getMessage()));
     }
}
	//end


	public String subPlansAction() {

		return "PILM035_APAC_PM_IL_PROD_APPL_PLANS";
	}

	public String WithDrawalButAction() {
		return "PILM035_APAC_PM_IL_PROD_WD_PARAM_HDR";
	}

	public String topupChargesButtonAction() {
		return "PILM035_APAC_PM_IL_TOP_UP_CHARGE";
	}

	public String topupParamsButtonAction() {
		return "PILM035_APAC_PM_IL_PROD_TOPUP_PARAM";
	}

	public String copyRecord() {
		return "DUMMY_COPY_RECORD";
	}
	
	public String fetchCashBackInterest() {
		return "CASHBACK_INTEREST";
	}

	
	
	
	public String bilingualButtonAction() {
		if (getCOMP_PROD_BL_DESC_LABEL().isRendered() == true) {
			getCOMP_PROD_BL_DESC_LABEL().setRendered(false);
			getCOMP_PROD_BL_DESC().setRendered(false);
			getCOMP_PROD_BL_LONG_DESC_LABEL().setRendered(false);
			getCOMP_PROD_BL_LONG_DESC().setRendered(false);
			getCOMP_PROD_BL_SHORT_DESC_LABEL().setRendered(false);
			getCOMP_PROD_BL_SHORT_DESC().setRendered(false);
		} else {
			getCOMP_PROD_BL_DESC_LABEL().setRendered(true);
			getCOMP_PROD_BL_DESC().setRendered(true);
			getCOMP_PROD_BL_LONG_DESC_LABEL().setRendered(true);
			getCOMP_PROD_BL_LONG_DESC().setRendered(true);
			getCOMP_PROD_BL_SHORT_DESC_LABEL().setRendered(true);
			getCOMP_PROD_BL_SHORT_DESC().setRendered(true);
		}

		return "";

	}
	
	 public String backButton() {
			CommonUtils commonUtils = new CommonUtils();
			commonUtils.callRetaintion("PILM035_APAC_SEARCH_ACTION",
				"fetchRecords");
			return "PILM035_APAC";
		    }

	 public String uploadRecord() {
			
			return "PILM035_APAC_PW_IL_UPLOAD_FILE_DTLS";
		    }
	 
	 
	/**
	 * @return the cOMP_PROD_INS_AGE_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_AGE_FM_LABEL() {
		return COMP_PROD_INS_AGE_FM_LABEL;
	}

	/**
	 * @param comp_prod_ins_age_fm_label the cOMP_PROD_INS_AGE_FM_LABEL to set
	 */
	public void setCOMP_PROD_INS_AGE_FM_LABEL(
			HtmlOutputLabel comp_prod_ins_age_fm_label) {
		COMP_PROD_INS_AGE_FM_LABEL = comp_prod_ins_age_fm_label;
	}

	/**
	 * @return the cOMP_PROD_INS_AGE_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_AGE_TO_LABEL() {
		return COMP_PROD_INS_AGE_TO_LABEL;
	}

	/**
	 * @param comp_prod_ins_age_to_label the cOMP_PROD_INS_AGE_TO_LABEL to set
	 */
	public void setCOMP_PROD_INS_AGE_TO_LABEL(
			HtmlOutputLabel comp_prod_ins_age_to_label) {
		COMP_PROD_INS_AGE_TO_LABEL = comp_prod_ins_age_to_label;
	}

	/**
	 * @return the cOMP_PROD_INS_SA_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_SA_FM_LABEL() {
		return COMP_PROD_INS_SA_FM_LABEL;
	}

	/**
	 * @param comp_prod_ins_sa_fm_label the cOMP_PROD_INS_SA_FM_LABEL to set
	 */
	public void setCOMP_PROD_INS_SA_FM_LABEL(
			HtmlOutputLabel comp_prod_ins_sa_fm_label) {
		COMP_PROD_INS_SA_FM_LABEL = comp_prod_ins_sa_fm_label;
	}

	/**
	 * @return the cOMP_PROD_INS_SA_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_SA_TO_LABEL() {
		return COMP_PROD_INS_SA_TO_LABEL;
	}

	/**
	 * @param comp_prod_ins_sa_to_label the cOMP_PROD_INS_SA_TO_LABEL to set
	 */
	public void setCOMP_PROD_INS_SA_TO_LABEL(
			HtmlOutputLabel comp_prod_ins_sa_to_label) {
		COMP_PROD_INS_SA_TO_LABEL = comp_prod_ins_sa_to_label;
	}

	/**
	 * @return the cOMP_PROD_INS_TM_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_TM_FM_LABEL() {
		return COMP_PROD_INS_TM_FM_LABEL;
	}

	/**
	 * @param comp_prod_ins_tm_fm_label the cOMP_PROD_INS_TM_FM_LABEL to set
	 */
	public void setCOMP_PROD_INS_TM_FM_LABEL(
			HtmlOutputLabel comp_prod_ins_tm_fm_label) {
		COMP_PROD_INS_TM_FM_LABEL = comp_prod_ins_tm_fm_label;
	}

	/**
	 * @return the cOMP_PROD_INS_TM_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_TM_TO_LABEL() {
		return COMP_PROD_INS_TM_TO_LABEL;
	}

	/**
	 * @param comp_prod_ins_tm_to_label the cOMP_PROD_INS_TM_TO_LABEL to set
	 */
	public void setCOMP_PROD_INS_TM_TO_LABEL(
			HtmlOutputLabel comp_prod_ins_tm_to_label) {
		COMP_PROD_INS_TM_TO_LABEL = comp_prod_ins_tm_to_label;
	}

	/**
	 * @return the cOMP_PROD_INS_AGE_FM
	 */
	public HtmlInputText getCOMP_PROD_INS_AGE_FM() {
		return COMP_PROD_INS_AGE_FM;
	}

	/**
	 * @param comp_prod_ins_age_fm the cOMP_PROD_INS_AGE_FM to set
	 */
	public void setCOMP_PROD_INS_AGE_FM(HtmlInputText comp_prod_ins_age_fm) {
		COMP_PROD_INS_AGE_FM = comp_prod_ins_age_fm;
	}

	/**
	 * @return the cOMP_PROD_INS_AGE_TO
	 */
	public HtmlInputText getCOMP_PROD_INS_AGE_TO() {
		return COMP_PROD_INS_AGE_TO;
	}

	/**
	 * @param comp_prod_ins_age_to the cOMP_PROD_INS_AGE_TO to set
	 */
	public void setCOMP_PROD_INS_AGE_TO(HtmlInputText comp_prod_ins_age_to) {
		COMP_PROD_INS_AGE_TO = comp_prod_ins_age_to;
	}

	/**
	 * @return the cOMP_PROD_INS_SA_FM
	 */
	public HtmlInputText getCOMP_PROD_INS_SA_FM() {
		return COMP_PROD_INS_SA_FM;
	}

	/**
	 * @param comp_prod_ins_sa_fm the cOMP_PROD_INS_SA_FM to set
	 */
	public void setCOMP_PROD_INS_SA_FM(HtmlInputText comp_prod_ins_sa_fm) {
		COMP_PROD_INS_SA_FM = comp_prod_ins_sa_fm;
	}

	/**
	 * @return the cOMP_PROD_INS_SA_TO
	 */
	public HtmlInputText getCOMP_PROD_INS_SA_TO() {
		return COMP_PROD_INS_SA_TO;
	}

	/**
	 * @param comp_prod_ins_sa_to the cOMP_PROD_INS_SA_TO to set
	 */
	public void setCOMP_PROD_INS_SA_TO(HtmlInputText comp_prod_ins_sa_to) {
		COMP_PROD_INS_SA_TO = comp_prod_ins_sa_to;
	}

	/**
	 * @return the cOMP_PROD_INS_TM_FM
	 */
	public HtmlInputText getCOMP_PROD_INS_TM_FM() {
		return COMP_PROD_INS_TM_FM;
	}

	/**
	 * @param comp_prod_ins_tm_fm the cOMP_PROD_INS_TM_FM to set
	 */
	public void setCOMP_PROD_INS_TM_FM(HtmlInputText comp_prod_ins_tm_fm) {
		COMP_PROD_INS_TM_FM = comp_prod_ins_tm_fm;
	}

	/**
	 * @return the cOMP_PROD_INS_TM_TO
	 */
	public HtmlInputText getCOMP_PROD_INS_TM_TO() {
		return COMP_PROD_INS_TM_TO;
	}

	/**
	 * @param comp_prod_ins_tm_to the cOMP_PROD_INS_TM_TO to set
	 */
	public void setCOMP_PROD_INS_TM_TO(HtmlInputText comp_prod_ins_tm_to) {
		COMP_PROD_INS_TM_TO = comp_prod_ins_tm_to;
	}

	/**
	 * @return the cOMP_INSURED_AGE_TAB
	 */
	public HtmlTab getCOMP_INSURED_AGE_TAB() {
		return COMP_INSURED_AGE_TAB;
	}

	/**
	 * @param comp_insured_age_tab the cOMP_INSURED_AGE_TAB to set
	 */
	public void setCOMP_INSURED_AGE_TAB(HtmlTab comp_insured_age_tab) {
		COMP_INSURED_AGE_TAB = comp_insured_age_tab;
	}

	/**
	 * @return the listAPL_YN
	 */
	public List<SelectItem> getListAPL_YN() {
		return listAPL_YN;
	}

	/**
	 * @param listAPL_YN the listAPL_YN to set
	 */
	public void setListAPL_YN(List<SelectItem> listAPL_YN) {
		this.listAPL_YN = listAPL_YN;
	}

	/**
	 * @return the cOMP_PROD_INS_APL_YN
	 */
	public HtmlSelectOneMenu getCOMP_PROD_INS_APL_YN() {
		return COMP_PROD_INS_APL_YN;
	}

	/**
	 * @param comp_prod_ins_apl_yn the cOMP_PROD_INS_APL_YN to set
	 */
	public void setCOMP_PROD_INS_APL_YN(HtmlSelectOneMenu comp_prod_ins_apl_yn) {
		COMP_PROD_INS_APL_YN = comp_prod_ins_apl_yn;
	}

	/**
	 * @return the cOMP_PROD_INS_APL_YN_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_APL_YN_LABEL() {
		return COMP_PROD_INS_APL_YN_LABEL;
	}

	/**
	 * @param comp_prod_ins_apl_yn_label the cOMP_PROD_INS_APL_YN_LABEL to set
	 */
	public void setCOMP_PROD_INS_APL_YN_LABEL(
			HtmlOutputLabel comp_prod_ins_apl_yn_label) {
		COMP_PROD_INS_APL_YN_LABEL = comp_prod_ins_apl_yn_label;
	}

	public PILM035_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PM_IL_PRODUCT_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_PRODUCT_HELPER helper) {
		this.helper = helper;
	}

	public PM_IL_PRODUCT_DELEGATE getDelegate() {
		return delegate;
	}

	public void setDelegate(PM_IL_PRODUCT_DELEGATE delegate) {
		this.delegate = delegate;
	}

	public HtmlOutputLabel getCOMP_PROD_REM_YN_LABEL() {
		return COMP_PROD_REM_YN_LABEL;
	}

	public void setCOMP_PROD_REM_YN_LABEL(HtmlOutputLabel comp_prod_rem_yn_label) {
		COMP_PROD_REM_YN_LABEL = comp_prod_rem_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_PROD_REM_YN() {
		return COMP_PROD_REM_YN;
	}

	public void setCOMP_PROD_REM_YN(HtmlSelectOneMenu comp_prod_rem_yn) {
		COMP_PROD_REM_YN = comp_prod_rem_yn;
	}

	public HtmlOutputLabel getCOMP_PROD_REM_1_LABEL() {
		return COMP_PROD_REM_1_LABEL;
	}

	public void setCOMP_PROD_REM_1_LABEL(HtmlOutputLabel comp_prod_rem_1_label) {
		COMP_PROD_REM_1_LABEL = comp_prod_rem_1_label;
	}

	public HtmlInputText getCOMP_PROD_REM_1() {
		return COMP_PROD_REM_1;
	}

	public void setCOMP_PROD_REM_1(HtmlInputText comp_prod_rem_1) {
		COMP_PROD_REM_1 = comp_prod_rem_1;
	}

	public HtmlOutputLabel getCOMP_PROD_REM_2_LABEL() {
		return COMP_PROD_REM_2_LABEL;
	}

	public void setCOMP_PROD_REM_2_LABEL(HtmlOutputLabel comp_prod_rem_2_label) {
		COMP_PROD_REM_2_LABEL = comp_prod_rem_2_label;
	}

	public HtmlInputText getCOMP_PROD_REM_2() {
		return COMP_PROD_REM_2;
	}

	public void setCOMP_PROD_REM_2(HtmlInputText comp_prod_rem_2) {
		COMP_PROD_REM_2 = comp_prod_rem_2;
	}

	public HtmlOutputLabel getCOMP_PROD_REM_3_LABEL() {
		return COMP_PROD_REM_3_LABEL;
	}

	public void setCOMP_PROD_REM_3_LABEL(HtmlOutputLabel comp_prod_rem_3_label) {
		COMP_PROD_REM_3_LABEL = comp_prod_rem_3_label;
	}

	public HtmlInputText getCOMP_PROD_REM_3() {
		return COMP_PROD_REM_3;
	}

	public void setCOMP_PROD_REM_3(HtmlInputText comp_prod_rem_3) {
		COMP_PROD_REM_3 = comp_prod_rem_3;
	}

	//added by akash to implement reminder funactionality on product level
	
	
	public void validatePROD_REM_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_REM_YN(objValue);
			if("N".equals(objValue)){
				COMP_REM_INFO_4.setDisabled(true);
			}else{
				COMP_REM_INFO_4.setDisabled(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*added by gopi for RM018T - DEV_IL_ZB Life_022-Automated Premium Loan*/
	public void validatePROD_APL_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_APL_YN(objValue);
			COMP_PROD_INS_APL_YN.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*end*/
	public void validatePROD_TRAN_RATE_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_TRAN_RATE_YN(objValue);
			COMP_PROD_TRAN_RATE_YN.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void prodtype_Validator(FacesContext context,UIComponent component,Object value)throws ValidatorException{
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_PRODUCT_TYPE(objValue);
			
			/*Modified by Janani on 07.05.2018 as suggested by ajay for fidelity*/
			//if("U".equals(objValue))
			
			if("U".equals(objValue) || "T".equals(objValue))
			
			/*End*/
			{
				PM_IL_PRODUCT_BEAN.setPROD_MATU_DT("S");
				COMP_PROD_FUND_ALLOWED.setDisabled(false);
				/*Added saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 13-03-2017*/
				COMP_PROD_UNIT_LINK_TYPE.setDisabled(false);
				/*End*/
				
				/*End*/
				/*Commanted by gopifor kic as suggested by ajoy on 01/04/2019*/
				//COMP_PROD_MATU_DT.setDisabled(true);
				/*Added by Ameen on 13-03-2018 for FSD_IL_04_GOLDA*/
				COMP_PROD_MAT_AMT_LEVEL.setDisabled(false);
				COMP_PROD_RET_PREM_YN.setDisabled(true);
				COMP_PROD_REG_EXCESS_APP_YN.setDisabled(false);
				/*End*/ 
			}else{
				COMP_PROD_FUND_ALLOWED.setDisabled(true);
				/*Commanted by gopifor kic as suggested by ajoy on 01/04/2019*/
				//COMP_PROD_MATU_DT.setDisabled(false);
				COMP_PROD_UNIT_LINK_TYPE.setDisabled(true); 
				/*Added by Ameen on 13-03-2018 for FSD_IL_04_GOLDA*/
				COMP_PROD_MAT_AMT_LEVEL.setDisabled(true);
				COMP_PROD_RET_PREM_YN.setDisabled(false);
				COMP_PROD_REG_EXCESS_APP_YN.setDisabled(true);
				/*End*/
			}
			COMP_PROD_MATU_DT.resetValue();
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
	public HtmlTab getCOMP_REM_INFO_4() {
		return COMP_REM_INFO_4;
	}

	public void setCOMP_REM_INFO_4(HtmlTab comp_rem_info_4) {
		COMP_REM_INFO_4 = comp_rem_info_4;
	}

	public HtmlOutputLabel getCOMP_PROD_SAL_MULTIPLE_LABEL() {
		return COMP_PROD_SAL_MULTIPLE_LABEL;
	}

	public void setCOMP_PROD_SAL_MULTIPLE_LABEL(
			HtmlOutputLabel comp_prod_sal_multiple_label) {
		COMP_PROD_SAL_MULTIPLE_LABEL = comp_prod_sal_multiple_label;
	}

	public HtmlInputText getCOMP_PROD_SAL_MULTIPLE() {
		return COMP_PROD_SAL_MULTIPLE;
	}

	public void setCOMP_PROD_SAL_MULTIPLE(HtmlInputText comp_prod_sal_multiple) {
		COMP_PROD_SAL_MULTIPLE = comp_prod_sal_multiple;
	}

	public HtmlTab getCOMP_REM_INFO_5() {
		return COMP_REM_INFO_5;
	}

	public void setCOMP_REM_INFO_5(HtmlTab comp_rem_info_5) {
		COMP_REM_INFO_5 = comp_rem_info_5;
	}

	
	public void validatePROD_TOPUP_MULTIPLE(FacesContext context ,UIComponent component ,Object value){
		try{
			Double objValue = (Double)value;
			PM_IL_PRODUCT_BEAN.setPROD_TOPUP_MULTIPLE(objValue);
			helper.validPROD_TOPUP_MULTIPLE(objValue,PM_IL_PRODUCT_BEAN);
			//COMP_PROD_TOPUP_MULTIPLE.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePROD_ALLOC_TYPE(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_ALLOC_TYPE(objValue);
			COMP_PROD_ALLOC_TYPE.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePROD_BUY_BASIS(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_BUY_BASIS(objValue);
			COMP_PROD_BUY_BASIS.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePROD_CALC_ALLOC(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_CALC_ALLOC(objValue);
			COMP_PROD_CALC_ALLOC.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePROD_FUND_FEE(FacesContext context ,UIComponent component ,Object value){
		try{
			Double objValue = (Double)value;
			PM_IL_PRODUCT_BEAN.setPROD_FUND_FEE(objValue);
			COMP_PROD_FUND_FEE.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePROD_FUND_FEE_RATE_PER(FacesContext context ,UIComponent component ,Object value){
		try{
			Double objValue = (Double)value;
			PM_IL_PRODUCT_BEAN.setPROD_FUND_FEE_RATE_PER(objValue);
			COMP_PROD_FUND_FEE_RATE_PER.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	

	/*added by krithika*/

	public void validatePROD_MAX_DEFER_MONTHS(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_MAX_DEFER_MONTHS((Integer) value);
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
//end	
	/*Added by saranya on 30/12/2016 for RM018T - FSD_IL_ZB Life_028-Cash Back*/
	
	private HtmlOutputLabel COMP_PROD_CASHBACK_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_CASHBACK_YN;
	
	private List<SelectItem> listPROD_CASHBACK_YN = new ArrayList<SelectItem>();
	
	public HtmlOutputLabel getCOMP_PROD_CASHBACK_YN_LABEL() {
		return COMP_PROD_CASHBACK_YN_LABEL;
	}

	public void setCOMP_PROD_CASHBACK_YN_LABEL(
			HtmlOutputLabel cOMP_PROD_CASHBACK_YN_LABEL) {
		COMP_PROD_CASHBACK_YN_LABEL = cOMP_PROD_CASHBACK_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_CASHBACK_YN() {
		return COMP_PROD_CASHBACK_YN;
	}

	public void setCOMP_PROD_CASHBACK_YN(HtmlSelectOneMenu cOMP_PROD_CASHBACK_YN) {
		COMP_PROD_CASHBACK_YN = cOMP_PROD_CASHBACK_YN;
	}

	public List<SelectItem> getListPROD_CASHBACK_YN() {
		if (listPROD_CASHBACK_YN.size() == 0) {
			listPROD_CASHBACK_YN.clear();
			try {
				listPROD_CASHBACK_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_CASHBACK_YN;
	}

	public void setListPROD_CASHBACK_YN(List<SelectItem> listPROD_CASHBACK_YN) {
		this.listPROD_CASHBACK_YN = listPROD_CASHBACK_YN;
	}
	
	public void validatePROD_CASHBACK_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_CASHBACK_YN(objValue);
			if("Y".equals(objValue)){
				
				compositeAction.getWizard().enableWizardItem("PILM035_APAC_CASHBACK");
				
				
			}else{
				
				compositeAction.getWizard().disableWizardItem("PILM035_APAC_CASHBACK");
				
			}

		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
/*End*/
	/*Added by saranya on 13/02/2017 for Unit Link Product as per the Girish Suggessted*/
	private HtmlOutputLabel COMP_PROD_RISK_FACTOR_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_RISK_FACTOR_YN;
	
	private List<SelectItem> listPROD_RISK_FACTOR_YN = new ArrayList<SelectItem>();

	public HtmlOutputLabel getCOMP_PROD_RISK_FACTOR_YN_LABEL() {
		return COMP_PROD_RISK_FACTOR_YN_LABEL;
	}

	public void setCOMP_PROD_RISK_FACTOR_YN_LABEL(
			HtmlOutputLabel cOMP_PROD_RISK_FACTOR_YN_LABEL) {
		COMP_PROD_RISK_FACTOR_YN_LABEL = cOMP_PROD_RISK_FACTOR_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_RISK_FACTOR_YN() {
		if (listPROD_RISK_FACTOR_YN.size() == 0) {
			listPROD_RISK_FACTOR_YN.clear();
			try {
				listPROD_RISK_FACTOR_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return COMP_PROD_RISK_FACTOR_YN;
	}

	public void setCOMP_PROD_RISK_FACTOR_YN(
			HtmlSelectOneMenu cOMP_PROD_RISK_FACTOR_YN) {
		COMP_PROD_RISK_FACTOR_YN = cOMP_PROD_RISK_FACTOR_YN;
	}

	public List<SelectItem> getListPROD_RISK_FACTOR_YN() {
		return listPROD_RISK_FACTOR_YN;
	}

	public void setListPROD_RISK_FACTOR_YN(List<SelectItem> listPROD_RISK_FACTOR_YN) {
		this.listPROD_RISK_FACTOR_YN = listPROD_RISK_FACTOR_YN;
	}
	
	public void validatePROD_RISK_FACTOR_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_RISK_FACTOR_YN(objValue);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	
		}

	/*End*/	
	
	/*Added saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 13-03-2017*/
	
	private HtmlOutputLabel COMP_PROD_UNIT_LINK_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PROD_UNIT_LINK_TYPE;
	
	private List<SelectItem> listPROD_UNIT_LINK_TYPE = new ArrayList<SelectItem>();

	public HtmlOutputLabel getCOMP_PROD_UNIT_LINK_TYPE_LABEL() {
		return COMP_PROD_UNIT_LINK_TYPE_LABEL;
	}

	public void setCOMP_PROD_UNIT_LINK_TYPE_LABEL(
			HtmlOutputLabel cOMP_PROD_UNIT_LINK_TYPE_LABEL) {
		COMP_PROD_UNIT_LINK_TYPE_LABEL = cOMP_PROD_UNIT_LINK_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_UNIT_LINK_TYPE() {
		return COMP_PROD_UNIT_LINK_TYPE;
	}

	public void setCOMP_PROD_UNIT_LINK_TYPE(
			HtmlSelectOneMenu cOMP_PROD_UNIT_LINK_TYPE) {
		COMP_PROD_UNIT_LINK_TYPE = cOMP_PROD_UNIT_LINK_TYPE;
	}

	public List<SelectItem> getListPROD_UNIT_LINK_TYPE() {
		if (listPROD_UNIT_LINK_TYPE.size() == 0) {
			listPROD_UNIT_LINK_TYPE.clear();
			try {
				listPROD_UNIT_LINK_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_UNIT_LINK_TYPE;
	}

	public void setListPROD_UNIT_LINK_TYPE(List<SelectItem> listPROD_UNIT_LINK_TYPE) {
		this.listPROD_UNIT_LINK_TYPE = listPROD_UNIT_LINK_TYPE;
	}
	
	public void validatePROD_UNIT_LINK_TYPE(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_UNIT_LINK_TYPE(objValue);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	
		}
	
	
	/*End*/
	
	
	/*Added  by saranya for Hands on point num 23 on 14/02/2017
	private HtmlOutputLabel COMP_PROD_CLM_PROC_FEE_LABEL;
	
	private HtmlInputText COMP_PROD_CLM_PROC_FEE;

	public HtmlOutputLabel getCOMP_PROD_CLM_PROC_FEE_LABEL() {
		return COMP_PROD_CLM_PROC_FEE_LABEL;
	}

	public void setCOMP_PROD_CLM_PROC_FEE_LABEL(
			HtmlOutputLabel cOMP_PROD_CLM_PROC_FEE_LABEL) {
		COMP_PROD_CLM_PROC_FEE_LABEL = cOMP_PROD_CLM_PROC_FEE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_CLM_PROC_FEE() {
		return COMP_PROD_CLM_PROC_FEE;
	}

	public void setCOMP_PROD_CLM_PROC_FEE(HtmlInputText cOMP_PROD_CLM_PROC_FEE) {
		COMP_PROD_CLM_PROC_FEE = cOMP_PROD_CLM_PROC_FEE;
	}
	
	End*/
	/*Added sankaranarayanan for hospitalcashplan  on 21-04-2017*/
	private HtmlOutputLabel COMP_PROD_INTR_SAVINGS_YN_LABEL;

	private HtmlSelectOneMenu COMP_PROD_INTR_SAVINGS_YN;
	private List<SelectItem> listPROD_INTR_SAVINGS_YN = new ArrayList<SelectItem>();
	private String UI_PROD_PLAN_TYPE;

	public String getUI_PROD_PLAN_TYPE() {
		return UI_PROD_PLAN_TYPE;
	}
	public void setUI_PROD_PLAN_TYPE(String uI_PROD_PLAN_TYPE) {
		UI_PROD_PLAN_TYPE = uI_PROD_PLAN_TYPE;
	}

	public String getPlanType(String PLAN_CODE){
		String Type=null;
		Connection connection = null;
		Object[] values = new Object[] { PLAN_CODE };
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement("SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE=?", connection, values);
			if (resultSet.next()) {
				Type=resultSet.getString("PLAN_TYPE");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Type;

	}


	public List<SelectItem> getListPROD_INTR_SAVINGS_YN() {
		return listPROD_INTR_SAVINGS_YN;
	}

	public void setListPROD_INTR_SAVINGS_YN(
			List<SelectItem> listPROD_INTR_SAVINGS_YN) {
		this.listPROD_INTR_SAVINGS_YN = listPROD_INTR_SAVINGS_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_INTR_SAVINGS_YN_LABEL() {
		return COMP_PROD_INTR_SAVINGS_YN_LABEL;
	}

	public void setCOMP_PROD_INTR_SAVINGS_YN_LABEL(
			HtmlOutputLabel cOMP_PROD_INTR_SAVINGS_YN_LABEL) {
		COMP_PROD_INTR_SAVINGS_YN_LABEL = cOMP_PROD_INTR_SAVINGS_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_INTR_SAVINGS_YN() {
		return COMP_PROD_INTR_SAVINGS_YN;
	}

	public void setCOMP_PROD_INTR_SAVINGS_YN(
			HtmlSelectOneMenu cOMP_PROD_INTR_SAVINGS_YN) {
		COMP_PROD_INTR_SAVINGS_YN = cOMP_PROD_INTR_SAVINGS_YN;
	}


	public void validatePROD_INTR_SAVINGS_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_INTR_SAVINGS_YN(objValue);

			if("Y".equals(PM_IL_PRODUCT_BEAN.getPROD_INTR_SAVINGS_YN())){
				compositeAction.getWizard().enableWizardItem("PILM035_APAC_PM_IL_PROD_INTREST");
			}else{
				compositeAction.getWizard().disableWizardItem("PILM035_APAC_PM_IL_PROD_INTREST");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}


	/*end*/
	
	/*added by Ameen on 31-10-2017 to add PROD_RI_SA_CALC_TYP as per Chandramohan sugg.*/
	
	private HtmlOutputLabel COMP_PROD_RI_SA_CALC_TYP_LABEL;
	
	private HtmlSelectOneMenu COMP_PROD_RI_SA_CALC_TYP;
	
	private List<SelectItem> listPROD_RI_SA_CALC_TYP = new ArrayList<SelectItem>();
	
	public HtmlOutputLabel getCOMP_PROD_RI_SA_CALC_TYP_LABEL() {
		return COMP_PROD_RI_SA_CALC_TYP_LABEL;
	}

	public void setCOMP_PROD_RI_SA_CALC_TYP_LABEL(
			HtmlOutputLabel cOMP_PROD_RI_SA_CALC_TYP_LABEL) {
		COMP_PROD_RI_SA_CALC_TYP_LABEL = cOMP_PROD_RI_SA_CALC_TYP_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_RI_SA_CALC_TYP() {
		return COMP_PROD_RI_SA_CALC_TYP;
	}

	public void setCOMP_PROD_RI_SA_CALC_TYP(
			HtmlSelectOneMenu cOMP_PROD_RI_SA_CALC_TYP) {
		COMP_PROD_RI_SA_CALC_TYP = cOMP_PROD_RI_SA_CALC_TYP;
	}

	public List<SelectItem> getListPROD_RI_SA_CALC_TYP() {
		return listPROD_RI_SA_CALC_TYP;
	}

	public void setListPROD_RI_SA_CALC_TYP(List<SelectItem> listPROD_RI_SA_CALC_TYP) {
		this.listPROD_RI_SA_CALC_TYP = listPROD_RI_SA_CALC_TYP;
	}
	
	public void validatorPROD_RI_SA_CALC_TYP(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_RI_SA_CALC_TYP((String) value);
			
			String riCalcType = ((String) value);
			/*Added by senthilnathan for alliance to handle validation for prod_ri_sa_calc on 12.02.2021*/
			if(riCalcType.equalsIgnoreCase("F")){
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_RI_FORMULA_CODE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_RI_FORMULA_CODE().resetValue();
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_UI_M_PROD_RI_FORMULA_CODE_DESC().resetValue();
				
			}else{
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().setPROD_RI_FORMULA_CODE(null);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().setUI_M_PROD_RI_FORMULA_CODE_DESC(null);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_RI_FORMULA_CODE().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_RI_FORMULA_CODE().resetValue();
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_UI_M_PROD_RI_FORMULA_CODE_DESC().resetValue();
				}
			
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
	
	/*Added by Janani on 04.01.2018 for ZBLIFE-1459615*/
	
	private HtmlOutputLabel COMP_PROD_PUP_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_PROD_PUP_YN;
	
	private List<SelectItem> listPROD_PUP_YN = new ArrayList<SelectItem>();
	
	private HtmlOutputLabel COMP_PROD_MIN_PUP_AMT_LABEL;
	
	private HtmlInputText COMP_PROD_MIN_PUP_AMT;
	
	private HtmlOutputLabel COMP_PROD_DRIP_AMT_LABEL;
	
	private HtmlInputText COMP_PROD_DRIP_AMT;
	
	public HtmlOutputLabel getCOMP_PROD_DRIP_AMT_LABEL() {
		return COMP_PROD_DRIP_AMT_LABEL;
	}

	public void setCOMP_PROD_DRIP_AMT_LABEL(HtmlOutputLabel cOMP_PROD_DRIP_AMT_LABEL) {
		COMP_PROD_DRIP_AMT_LABEL = cOMP_PROD_DRIP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PROD_DRIP_AMT() {
		return COMP_PROD_DRIP_AMT;
	}

	public void setCOMP_PROD_DRIP_AMT(HtmlInputText cOMP_PROD_DRIP_AMT) {
		COMP_PROD_DRIP_AMT = cOMP_PROD_DRIP_AMT;
	}

	public HtmlOutputLabel getCOMP_PROD_PUP_YN_LABEL() {
		return COMP_PROD_PUP_YN_LABEL;
	}

	public void setCOMP_PROD_PUP_YN_LABEL(
			HtmlOutputLabel cOMP_PROD_PUP_YN_LABEL) {
		COMP_PROD_PUP_YN_LABEL = cOMP_PROD_PUP_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_PUP_YN() {
		return COMP_PROD_PUP_YN;
	}

	public void setCOMP_PROD_PUP_YN(HtmlSelectOneMenu cOMP_PROD_PUP_YN) {
		COMP_PROD_PUP_YN = cOMP_PROD_PUP_YN;
	}

	public List<SelectItem> getListPROD_PUP_YN() {
		return listPROD_PUP_YN;
	}

	public void setListPROD_PUP_YN(List<SelectItem> listPROD_PUP_YN) {
		this.listPROD_PUP_YN = listPROD_PUP_YN;
	}
	
	public HtmlOutputLabel getCOMP_PROD_MIN_PUP_AMT_LABEL() {
		return COMP_PROD_MIN_PUP_AMT_LABEL;
	}

	public void setCOMP_PROD_MIN_PUP_AMT_LABEL(
			HtmlOutputLabel cOMP_PROD_MIN_PUP_AMT_LABEL) {
		COMP_PROD_MIN_PUP_AMT_LABEL = cOMP_PROD_MIN_PUP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PROD_MIN_PUP_AMT() {
		return COMP_PROD_MIN_PUP_AMT;
	}

	public void setCOMP_PROD_MIN_PUP_AMT(HtmlInputText cOMP_PROD_MIN_PUP_AMT) {
		COMP_PROD_MIN_PUP_AMT = cOMP_PROD_MIN_PUP_AMT;
	}

	public void validatePROD_PUP_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			System.out.println("enters into validatePROD_PUP_YN");
			
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_PUP_YN(objValue);
			
			System.out.println("getPROD_PUP_YN               "+PM_IL_PRODUCT_BEAN.getPROD_PUP_YN());
			
		/*	if(PM_IL_PRODUCT_BEAN.getPROD_PUP_YN() != null && PM_IL_PRODUCT_BEAN.getPROD_PUP_YN().equalsIgnoreCase("y")){
				
				COMP_PROD_MIN_PUP_AMT.setDisabled(false);
				COMP_PROD_DRIP_AMT.setDisabled(false);
			}
			else
			{
				PM_IL_PRODUCT_BEAN.setPROD_MIN_PUP_AMT(0.0);
				COMP_PROD_MIN_PUP_AMT.setDisabled(true);
				
				PM_IL_PRODUCT_BEAN.setPROD_DRIP_AMT(0.0);
				COMP_PROD_DRIP_AMT.setDisabled(true);
			}*/
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
		
	
	public void validatePROD_PUP_YN_ajax(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		
		System.out.println("enters into validatePROD_PUP_YN_ajax                "+value);
		
		
		if(PM_IL_PRODUCT_BEAN.getPROD_PUP_YN() != null && PM_IL_PRODUCT_BEAN.getPROD_PUP_YN().equalsIgnoreCase("y")){
			
			COMP_PROD_MIN_PUP_AMT.setDisabled(false);
			COMP_PROD_DRIP_AMT.setDisabled(false);
		}
		else
		{
			PM_IL_PRODUCT_BEAN.setPROD_MIN_PUP_AMT(0.0);
			COMP_PROD_MIN_PUP_AMT.setDisabled(true);
			
			PM_IL_PRODUCT_BEAN.setPROD_DRIP_AMT(0.0);
			COMP_PROD_DRIP_AMT.setDisabled(true);
		}
	}
	
	
	public void validatePROD_MIN_PUP_AMT(FacesContext context ,UIComponent component ,Object value){
		try{
			System.out.println("enters into validatePROD_MIN_PUP_AMT");
		
			Double objValue = (Double)value;
			PM_IL_PRODUCT_BEAN.setPROD_MIN_PUP_AMT(objValue);
		
			System.out.println("getPROD_MIN_PUP_AMT               "+PM_IL_PRODUCT_BEAN.getPROD_MIN_PUP_AMT());
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}	
	
	
	public void validatePROD_DRIP_AMT(FacesContext context ,UIComponent component ,Object value){
		try{
			System.out.println("enters into validatePROD_MIN_PUP_AMT");
		
			Double objValue = (Double)value;
			PM_IL_PRODUCT_BEAN.setPROD_DRIP_AMT(objValue);
		
			System.out.println("getPROD_DRIP_AMT               "+PM_IL_PRODUCT_BEAN.getPROD_DRIP_AMT());
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}	
	
	/*End */
	
	/*Added by Ameen on 15-02-2018 for KIC*/
	private List<SelectItem> listPROD_RET_PREM_YN = new ArrayList<SelectItem>();
	
	private HtmlOutputLabel COMP_PROD_RET_PREM_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_PROD_RET_PREM_YN;

	public HtmlOutputLabel getCOMP_PROD_RET_PREM_YN_LABEL() {
		return COMP_PROD_RET_PREM_YN_LABEL;
	}

	public void setCOMP_PROD_RET_PREM_YN_LABEL(
			HtmlOutputLabel cOMP_PROD_RET_PREM_YN_LABEL) {
		COMP_PROD_RET_PREM_YN_LABEL = cOMP_PROD_RET_PREM_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_RET_PREM_YN() {
		return COMP_PROD_RET_PREM_YN;
	}

	public void setCOMP_PROD_RET_PREM_YN(HtmlSelectOneMenu cOMP_PROD_RET_PREM_YN) {
		COMP_PROD_RET_PREM_YN = cOMP_PROD_RET_PREM_YN;
	}
	
	public List<SelectItem> getListPROD_RET_PREM_YN() {
		return listPROD_RET_PREM_YN;
	}

	public void setListPROD_RET_PREM_YN(List<SelectItem> listPROD_RET_PREM_YN) {
		this.listPROD_RET_PREM_YN = listPROD_RET_PREM_YN;
	}

	public void validatePROD_RET_PREM_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			System.out.println("enters into validatePROD_MIN_PUP_AMT");
		
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_RET_PREM_YN(objValue);
		
			System.out.println("getPROD_DRIP_AMT               "+PM_IL_PRODUCT_BEAN.getPROD_DRIP_AMT());
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	private HtmlOutputLabel COMP_PROD_REG_EXCESS_APP_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_PROD_REG_EXCESS_APP_YN;
	
	private HtmlOutputLabel COMP_PROD_MAT_AMT_LEVEL_LABEL;
	
	private HtmlSelectOneMenu COMP_PROD_MAT_AMT_LEVEL;
	
	private List<SelectItem> listPROD_REG_EXCESS_APP_YN = new ArrayList<SelectItem>();
	
	private List<SelectItem> listPROD_MAT_AMT_LEVEL = new ArrayList<SelectItem>();

	public HtmlOutputLabel getCOMP_PROD_REG_EXCESS_APP_YN_LABEL() {
		return COMP_PROD_REG_EXCESS_APP_YN_LABEL;
	}

	public void setCOMP_PROD_REG_EXCESS_APP_YN_LABEL(
			HtmlOutputLabel cOMP_PROD_REG_EXCESS_APP_YN_LABEL) {
		COMP_PROD_REG_EXCESS_APP_YN_LABEL = cOMP_PROD_REG_EXCESS_APP_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_REG_EXCESS_APP_YN() {
		return COMP_PROD_REG_EXCESS_APP_YN;
	}

	public void setCOMP_PROD_REG_EXCESS_APP_YN(
			HtmlSelectOneMenu cOMP_PROD_REG_EXCESS_APP_YN) {
		COMP_PROD_REG_EXCESS_APP_YN = cOMP_PROD_REG_EXCESS_APP_YN;
	}

	public List<SelectItem> getListPROD_REG_EXCESS_APP_YN() {
		return listPROD_REG_EXCESS_APP_YN;
	}

	public void setListPROD_REG_EXCESS_APP_YN(
			List<SelectItem> listPROD_REG_EXCESS_APP_YN) {
		this.listPROD_REG_EXCESS_APP_YN = listPROD_REG_EXCESS_APP_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_MAT_AMT_LEVEL_LABEL() {
		return COMP_PROD_MAT_AMT_LEVEL_LABEL;
	}

	public void setCOMP_PROD_MAT_AMT_LEVEL_LABEL(
			HtmlOutputLabel cOMP_PROD_MAT_AMT_LEVEL_LABEL) {
		COMP_PROD_MAT_AMT_LEVEL_LABEL = cOMP_PROD_MAT_AMT_LEVEL_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_MAT_AMT_LEVEL() {
		return COMP_PROD_MAT_AMT_LEVEL;
	}

	public void setCOMP_PROD_MAT_AMT_LEVEL(HtmlSelectOneMenu cOMP_PROD_MAT_AMT_LEVEL) {
		COMP_PROD_MAT_AMT_LEVEL = cOMP_PROD_MAT_AMT_LEVEL;
	}

	public List<SelectItem> getListPROD_MAT_AMT_LEVEL() {
		return listPROD_MAT_AMT_LEVEL;
	}

	public void setListPROD_MAT_AMT_LEVEL(List<SelectItem> listPROD_MAT_AMT_LEVEL) {
		this.listPROD_MAT_AMT_LEVEL = listPROD_MAT_AMT_LEVEL;
	}
	
	public void validatePROD_REG_EXCESS_APP_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_REG_EXCESS_APP_YN(objValue);
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	public void validatePROD_MAT_AMT_LEVEL(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_MAT_AMT_LEVEL(objValue);
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	private HtmlOutputLabel COMP_PROD_CBC_LIMIT_LABEL;
	
	private HtmlInputText COMP_PROD_CBC_LIMIT;

	public HtmlInputText getCOMP_PROD_CBC_LIMIT() {
		return COMP_PROD_CBC_LIMIT;
	}

	public void setCOMP_PROD_CBC_LIMIT(HtmlInputText cOMP_PROD_CBC_LIMIT) {
		COMP_PROD_CBC_LIMIT = cOMP_PROD_CBC_LIMIT;
	}
	
	public HtmlOutputLabel getCOMP_PROD_CBC_LIMIT_LABEL() {
		return COMP_PROD_CBC_LIMIT_LABEL;
	}

	public void setCOMP_PROD_CBC_LIMIT_LABEL(
			HtmlOutputLabel cOMP_PROD_CBC_LIMIT_LABEL) {
		COMP_PROD_CBC_LIMIT_LABEL = cOMP_PROD_CBC_LIMIT_LABEL;
	}

	public void validatorPROD_CBC_LIMIT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PRODUCT_BEAN().setPROD_CBC_LIMIT((Integer) value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*End*/
	
	
	/*Added by Janani on 18.04.2018 for Fidelity period calc*/
	
private List<SelectItem> listPROD_CALC_TERM_YN = new ArrayList<SelectItem>();

private List<SelectItem> listPROD_PREM_SA_CALC_YN = new ArrayList<SelectItem>();

	
	private HtmlOutputLabel COMP_PROD_CALC_TERM_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_PROD_CALC_TERM_YN;

	
	public List<SelectItem> getListPROD_PREM_SA_CALC_YN() {
		return listPROD_PREM_SA_CALC_YN;
	}

	public void setListPROD_PREM_SA_CALC_YN(
			List<SelectItem> listPROD_PREM_SA_CALC_YN) {
		this.listPROD_PREM_SA_CALC_YN = listPROD_PREM_SA_CALC_YN;
	}

	public List<SelectItem> getListPROD_CALC_TERM_YN() {
		return listPROD_CALC_TERM_YN;
	}

	public void setListPROD_CALC_TERM_YN(List<SelectItem> listPROD_CALC_TERM_YN) {
		this.listPROD_CALC_TERM_YN = listPROD_CALC_TERM_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_CALC_TERM_YN_LABEL() {
		return COMP_PROD_CALC_TERM_YN_LABEL;
	}

	public void setCOMP_PROD_CALC_TERM_YN_LABEL(
			HtmlOutputLabel cOMP_PROD_CALC_TERM_YN_LABEL) {
		COMP_PROD_CALC_TERM_YN_LABEL = cOMP_PROD_CALC_TERM_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_CALC_TERM_YN() {
		return COMP_PROD_CALC_TERM_YN;
	}

	public void setCOMP_PROD_CALC_TERM_YN(HtmlSelectOneMenu cOMP_PROD_CALC_TERM_YN) {
		COMP_PROD_CALC_TERM_YN = cOMP_PROD_CALC_TERM_YN;
	}

	
	public void validatePROD_CALC_TERM_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_CALC_TERM_YN(objValue);
			
			System.out.println("getPROD_CALC_TERM_YN                 "+PM_IL_PRODUCT_BEAN.getPROD_CALC_TERM_YN());
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	
	
	/*End*/
	
	/*Added by Janani on 12.05.2018 for Fidelity as suggested by Sivaram for Funeral,hospital cash rider*/
	
	private HtmlOutputLabel COMP_PROD_RIDER_APPL_YN_LABEL;
	
	//added by gopi for toi on 25/05/18
	private HtmlOutputLabel COMP_PROD_BENF_AS_CUST_YN_LABEL;
	

	public HtmlOutputLabel getCOMP_PROD_BENF_AS_CUST_YN_LABEL() {
		return COMP_PROD_BENF_AS_CUST_YN_LABEL;
	}

	public void setCOMP_PROD_BENF_AS_CUST_YN_LABEL(
			HtmlOutputLabel cOMP_PROD_BENF_AS_CUST_YN_LABEL) {
		COMP_PROD_BENF_AS_CUST_YN_LABEL = cOMP_PROD_BENF_AS_CUST_YN_LABEL;
	}
	private HtmlSelectOneMenu COMP_PROD_BENF_AS_CUST_YN;
	
	
	
	public HtmlSelectOneMenu getCOMP_PROD_BENF_AS_CUST_YN() {
		return COMP_PROD_BENF_AS_CUST_YN;
	}

	public void setCOMP_PROD_BENF_AS_CUST_YN(
			HtmlSelectOneMenu cOMP_PROD_BENF_AS_CUST_YN) {
		COMP_PROD_BENF_AS_CUST_YN = cOMP_PROD_BENF_AS_CUST_YN;
	}
	
	
	private HtmlOutputLabel COMP_PROD_POL_APPROVAL_YN_LABEL;
	
	
	
	public HtmlOutputLabel getCOMP_PROD_POL_APPROVAL_YN_LABEL() {
		return COMP_PROD_POL_APPROVAL_YN_LABEL;
	}

	public void setCOMP_PROD_POL_APPROVAL_YN_LABEL(
			HtmlOutputLabel cOMP_PROD_POL_APPROVAL_YN_LABEL) {
		COMP_PROD_POL_APPROVAL_YN_LABEL = cOMP_PROD_POL_APPROVAL_YN_LABEL;
	}
	
	
	private HtmlSelectOneMenu COMP_PROD_POL_APPROVAL_YN;
	
	public HtmlSelectOneMenu getCOMP_PROD_POL_APPROVAL_YN() {
		return COMP_PROD_POL_APPROVAL_YN;
	}

	public void setCOMP_PROD_POL_APPROVAL_YN(
			HtmlSelectOneMenu cOMP_PROD_POL_APPROVAL_YN) {
		COMP_PROD_POL_APPROVAL_YN = cOMP_PROD_POL_APPROVAL_YN;
	}
	//end
	private HtmlSelectOneMenu COMP_PROD_RIDER_APPL_YN;

	private List<SelectItem> listPROD_RIDER_APPL_YN = new ArrayList<SelectItem>();

	public List<SelectItem> getListPROD_RIDER_APPL_YN() {
		return listPROD_RIDER_APPL_YN;
	}

	public void setListPROD_RIDER_APPL_YN(List<SelectItem> listPROD_RIDER_APPL_YN) {
		this.listPROD_RIDER_APPL_YN = listPROD_RIDER_APPL_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_RIDER_APPL_YN_LABEL() {
		return COMP_PROD_RIDER_APPL_YN_LABEL;
	}

	public void setCOMP_PROD_RIDER_APPL_YN_LABEL(
			HtmlOutputLabel cOMP_PROD_RIDER_APPL_YN_LABEL) {
		COMP_PROD_RIDER_APPL_YN_LABEL = cOMP_PROD_RIDER_APPL_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_RIDER_APPL_YN() {
		return COMP_PROD_RIDER_APPL_YN;
	}

	public void setCOMP_PROD_RIDER_APPL_YN(HtmlSelectOneMenu cOMP_PROD_RIDER_APPL_YN) {
		COMP_PROD_RIDER_APPL_YN = cOMP_PROD_RIDER_APPL_YN;
	}
	
	
	public void validatePROD_RIDER_APPL_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_RIDER_APPL_YN(objValue);
			
			System.out.println("getPROD_RIDER_APPL_YN                 "+PM_IL_PRODUCT_BEAN.getPROD_RIDER_APPL_YN());
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	//added by gopi for toi on 25/05/2018
	public void validatePROD_BENF_AS_CUST_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_BENF_AS_CUST_YN(objValue);
			
			System.out.println("getPROD_RIDER_APPL_YN                 "+PM_IL_PRODUCT_BEAN.getPROD_BENF_AS_CUST_YN());
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	public void validatePROD_POL_APPROVAL_YN(FacesContext context ,UIComponent component ,Object value){
		try{
			String objValue = (String)value;
			PM_IL_PRODUCT_BEAN.setPROD_POL_APPROVAL_YN(objValue);
			
			System.out.println("getPROD_RIDER_APPL_YN                 "+PM_IL_PRODUCT_BEAN.getPROD_POL_APPROVAL_YN());
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	
	//end
	
		public void disableRiderApp() throws Exception {
		Connection connection = null;
		ResultSet resultset = null;

		String plan_type = null;

		String query1 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE= ?";

		try {

			connection = CommonUtils.getConnection();

			resultset = new CRUDHandler().executeSelectStatement(query1, connection,new Object[]{getPM_IL_PRODUCT_BEAN().getPROD_CODE()});

			if(resultset.next()){

				plan_type = resultset.getString("PLAN_TYPE");

				System.out.println("plan_type is                 "+plan_type);

			}

			if(plan_type.equalsIgnoreCase("l") || plan_type.equalsIgnoreCase("h"))
			{
				COMP_PROD_RIDER_APPL_YN.setDisabled(false);
			}
			else
			{
				COMP_PROD_RIDER_APPL_YN.setDisabled(true);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally {
			CommonUtils.closeCursor(resultset);
		}

	}	
	/*End*/
		
		/*Added by Janani on 15.06.2018 for KIC*/
		private HtmlOutputLabel COMP_PROD_NGTV_SUS_YN_LABEL;

		private HtmlSelectOneMenu COMP_PROD_NGTV_SUS_YN;
		
		private List<SelectItem> listPROD_NGTV_SUS_YN = new ArrayList<SelectItem>();
		
		
		private String plan_type;
		
		
		
		public HtmlOutputLabel getCOMP_PROD_NGTV_SUS_YN_LABEL() {
			return COMP_PROD_NGTV_SUS_YN_LABEL;
		}

		public void setCOMP_PROD_NGTV_SUS_YN_LABEL(
				HtmlOutputLabel cOMP_PROD_NGTV_SUS_YN_LABEL) {
			COMP_PROD_NGTV_SUS_YN_LABEL = cOMP_PROD_NGTV_SUS_YN_LABEL;
		}

		public HtmlSelectOneMenu getCOMP_PROD_NGTV_SUS_YN() {
			return COMP_PROD_NGTV_SUS_YN;
		}

		public void setCOMP_PROD_NGTV_SUS_YN(HtmlSelectOneMenu cOMP_PROD_NGTV_SUS_YN) {
			COMP_PROD_NGTV_SUS_YN = cOMP_PROD_NGTV_SUS_YN;
		}

		public List<SelectItem> getListPROD_NGTV_SUS_YN() {
			return listPROD_NGTV_SUS_YN;
		}

		public void setListPROD_NGTV_SUS_YN(List<SelectItem> listPROD_NGTV_SUS_YN) {
			this.listPROD_NGTV_SUS_YN = listPROD_NGTV_SUS_YN;
		}

		public void validatePROD_NGTV_SUS_YN(FacesContext context ,UIComponent component ,Object value){
			try{
				String objValue = (String)value;
				PM_IL_PRODUCT_BEAN.setPROD_NGTV_SUS_YN(objValue);
				
				System.out.println("getPROD_NGTV_SUS_YN                 "+PM_IL_PRODUCT_BEAN.getPROD_RIDER_APPL_YN());
			
			}catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
		
		
		/*End*/
		
		/*Added by Janani on 25.06.2018 for  FSD_IL_FLA_006_Monetary Endorsement Module*/
		
		private HtmlOutputLabel COMP_PROD_AGENT_PREM_TYPE_LABEL;

		private HtmlSelectOneMenu COMP_PROD_AGENT_PREM_TYPE;

		private List<SelectItem> listPROD_AGENT_PREM_TYPE = new ArrayList<SelectItem>();
		
		public HtmlOutputLabel getCOMP_PROD_AGENT_PREM_TYPE_LABEL() {
			return COMP_PROD_AGENT_PREM_TYPE_LABEL;
		}

		public void setCOMP_PROD_AGENT_PREM_TYPE_LABEL(
				HtmlOutputLabel cOMP_PROD_AGENT_PREM_TYPE_LABEL) {
			COMP_PROD_AGENT_PREM_TYPE_LABEL = cOMP_PROD_AGENT_PREM_TYPE_LABEL;
		}

		public HtmlSelectOneMenu getCOMP_PROD_AGENT_PREM_TYPE() {
			return COMP_PROD_AGENT_PREM_TYPE;
		}

		public void setCOMP_PROD_AGENT_PREM_TYPE(
				HtmlSelectOneMenu cOMP_PROD_AGENT_PREM_TYPE) {
			COMP_PROD_AGENT_PREM_TYPE = cOMP_PROD_AGENT_PREM_TYPE;
		}

		public List<SelectItem> getListPROD_AGENT_PREM_TYPE() {
			return listPROD_AGENT_PREM_TYPE;
		}

		public void setListPROD_AGENT_PREM_TYPE(
				List<SelectItem> listPROD_AGENT_PREM_TYPE) {
			this.listPROD_AGENT_PREM_TYPE = listPROD_AGENT_PREM_TYPE;
		}
		
		
		public void validatePROD_AGENT_PREM_TYPE(FacesContext context ,UIComponent component ,Object value){
			try{
				String objValue = (String)value;
				PM_IL_PRODUCT_BEAN.setPROD_AGENT_PREM_TYPE(objValue);
				
				System.out.println("getPROD_AGENT_PREM_TYPE                 "+PM_IL_PRODUCT_BEAN.getPROD_AGENT_PREM_TYPE());
			
			}catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
		
		/*End*/
		
		/*Added by Janani on 02.07.2018 for FLALIFEQC-1754274*/
		
		public void PROD_SA_BY_PLAN_BASIS_YN_Enab_Disb()
				throws Exception {

			String prod_sa_by_plan_basis_yn = compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_SA_BY_PLAN_BASIS_YN();
			try {
				if ("Y".equalsIgnoreCase(prod_sa_by_plan_basis_yn)) {
					
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_SA_TARIFF().setRequired(true);
					
					
					
				} else if ("N".equalsIgnoreCase(prod_sa_by_plan_basis_yn)) {
					
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_SA_TARIFF().setRequired(false);
					
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
			}
		}
		
		/*End*/
		
		
		/*Added by Janani on 05.07.2018 for FLALIFEQC-1512859 */
		
		private HtmlOutputLabel COMP_PROD_PREM_PAYING_YRS_LABEL;

		private HtmlSelectOneMenu COMP_PROD_PREM_PAYING_YRS;

		private List<SelectItem> listPROD_PREM_PAYING_YRS = new ArrayList<SelectItem>();
		
		
		public HtmlOutputLabel getCOMP_PROD_PREM_PAYING_YRS_LABEL() {
			return COMP_PROD_PREM_PAYING_YRS_LABEL;
		}

		public void setCOMP_PROD_PREM_PAYING_YRS_LABEL(
				HtmlOutputLabel cOMP_PROD_PREM_PAYING_YRS_LABEL) {
			COMP_PROD_PREM_PAYING_YRS_LABEL = cOMP_PROD_PREM_PAYING_YRS_LABEL;
		}

		public HtmlSelectOneMenu getCOMP_PROD_PREM_PAYING_YRS() {
			return COMP_PROD_PREM_PAYING_YRS;
		}

		public void setCOMP_PROD_PREM_PAYING_YRS(
				HtmlSelectOneMenu cOMP_PROD_PREM_PAYING_YRS) {
			COMP_PROD_PREM_PAYING_YRS = cOMP_PROD_PREM_PAYING_YRS;
		}
		
		public List<SelectItem> getListPROD_PREM_PAYING_YRS() {
			return listPROD_PREM_PAYING_YRS;
		}

		public void setListPROD_PREM_PAYING_YRS(
				List<SelectItem> listPROD_PREM_PAYING_YRS) {
			this.listPROD_PREM_PAYING_YRS = listPROD_PREM_PAYING_YRS;
		}

		public void validatePROD_PREM_PAYING_YRS(FacesContext context ,UIComponent component ,Object value){
			try{
				String objValue = (String)value;
				PM_IL_PRODUCT_BEAN.setPROD_PREM_PAYING_YRS(objValue);
				
				System.out.println("getPROD_PREM_PAYING_YRS                 "+PM_IL_PRODUCT_BEAN.getPROD_PREM_PAYING_YRS());
			
			}catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
		
		/*End*/
		/*Added by kavitha on 08.01.2019 as per siva sir sugg*/
		private HtmlOutputLabel COMP_PROD_FORMULA_MAT_LABEL;
		private HtmlInputText COMP_PROD_FORMULA_MAT;
		private HtmlInputText COMP_UI_PROD_FORMULA_MAT_DESC;

		public HtmlOutputLabel getCOMP_PROD_FORMULA_MAT_LABEL() {
			return COMP_PROD_FORMULA_MAT_LABEL;
		}

		public void setCOMP_PROD_FORMULA_MAT_LABEL(
				HtmlOutputLabel cOMP_PROD_FORMULA_MAT_LABEL) {
			COMP_PROD_FORMULA_MAT_LABEL = cOMP_PROD_FORMULA_MAT_LABEL;
		}

		public HtmlInputText getCOMP_PROD_FORMULA_MAT() {
			return COMP_PROD_FORMULA_MAT;
		}

		public void setCOMP_PROD_FORMULA_MAT(HtmlInputText cOMP_PROD_FORMULA_MAT) {
			COMP_PROD_FORMULA_MAT = cOMP_PROD_FORMULA_MAT;
		}

		public HtmlInputText getCOMP_UI_PROD_FORMULA_MAT_DESC() {
			return COMP_UI_PROD_FORMULA_MAT_DESC;
		}

		public void setCOMP_UI_PROD_FORMULA_MAT_DESC(
				HtmlInputText cOMP_UI_PROD_FORMULA_MAT_DESC) {
			COMP_UI_PROD_FORMULA_MAT_DESC = cOMP_UI_PROD_FORMULA_MAT_DESC;
		}
		
		public List<LovBean> lovPROD_FORMULA_MAT(Object currValue) {
			ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
			ListItemUtil listitemutil = new ListItemUtil();
			try {
				suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
						"PM_IL_PRODUCT", "PROD_FORMULA_MAT",null,
						null, null, null, null, (String) currValue);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return suggestionList;
		}
		
		/*End*/
		/*Newly added by pidugu raj dt: 09-07-2020 as suggested by kk and sitrasan for Alliance IL*/
		private HtmlSelectOneMenu COMP_PROD_SUB_DT_YN;
		private HtmlOutputLabel COMP_PROD_SUB_DT_YN_LABEL;
		private List<SelectItem> listPROD_SUB_DT_YN = new ArrayList<SelectItem>();
		
		
		public List<SelectItem> getListPROD_SUB_DT_YN() {
			return listPROD_SUB_DT_YN;
		}

		public void setListPROD_SUB_DT_YN(List<SelectItem> listPROD_SUB_DT_YN) {
			this.listPROD_SUB_DT_YN = listPROD_SUB_DT_YN;
		}

		public HtmlSelectOneMenu getCOMP_PROD_SUB_DT_YN() {
			return COMP_PROD_SUB_DT_YN;
		}

		public void setCOMP_PROD_SUB_DT_YN(HtmlSelectOneMenu cOMP_PROD_SUB_DT_YN) {
			COMP_PROD_SUB_DT_YN = cOMP_PROD_SUB_DT_YN;
		}

		public HtmlOutputLabel getCOMP_PROD_SUB_DT_YN_LABEL() {
			return COMP_PROD_SUB_DT_YN_LABEL;
		}

		public void setCOMP_PROD_SUB_DT_YN_LABEL(
				HtmlOutputLabel cOMP_PROD_SUB_DT_YN_LABEL) {
			COMP_PROD_SUB_DT_YN_LABEL = cOMP_PROD_SUB_DT_YN_LABEL;
		}

		public void validatePROD_SUB_DT_YN(FacesContext context ,UIComponent component ,Object value){
			try{
				String objValue = (String)value;
				PM_IL_PRODUCT_BEAN.setPROD_SUB_DT_YN(objValue);
			}catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
		
		/*End Newly added by pidugu raj dt: 09-07-2020 as suggested by kk and sitrasan for Alliance IL*/
		/*Newly added by pidugu raj dt: 16-09-2020 as suggested by kk and sitrasan for Alliance IL*/
		private HtmlOutputLabel COMP_PROD_DEFAULT_CURR_CODE_LABEL;
		private HtmlInputText COMP_PROD_DEFAULT_CURR_CODE;
		private HtmlInputText COMP_UI_M_PROD_DEFAULT_CURR_CODE_DESC;
		
		public HtmlInputText getCOMP_UI_M_PROD_DEFAULT_CURR_CODE_DESC() {
			return COMP_UI_M_PROD_DEFAULT_CURR_CODE_DESC;
		}

		public void setCOMP_UI_M_PROD_DEFAULT_CURR_CODE_DESC(
				HtmlInputText cOMP_UI_M_PROD_DEFAULT_CURR_CODE_DESC) {
			COMP_UI_M_PROD_DEFAULT_CURR_CODE_DESC = cOMP_UI_M_PROD_DEFAULT_CURR_CODE_DESC;
		}

		public HtmlOutputLabel getCOMP_PROD_DEFAULT_CURR_CODE_LABEL() {
			return COMP_PROD_DEFAULT_CURR_CODE_LABEL;
		}

		public void setCOMP_PROD_DEFAULT_CURR_CODE_LABEL(
				HtmlOutputLabel cOMP_PROD_DEFAULT_CURR_CODE_LABEL) {
			COMP_PROD_DEFAULT_CURR_CODE_LABEL = cOMP_PROD_DEFAULT_CURR_CODE_LABEL;
		}

		public HtmlInputText getCOMP_PROD_DEFAULT_CURR_CODE() {
			return COMP_PROD_DEFAULT_CURR_CODE;
		}

		public void setCOMP_PROD_DEFAULT_CURR_CODE(
				HtmlInputText cOMP_PROD_DEFAULT_CURR_CODE) {
			COMP_PROD_DEFAULT_CURR_CODE = cOMP_PROD_DEFAULT_CURR_CODE;
		}

		public ArrayList<com.iii.premia.common.bean.LovBean> lovPROD_DEFAULT_CURR_CODE(
				Object currValue) {
			ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
			ListItemUtil listitemutil = new ListItemUtil();
			try {
				
				suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC","PM_IL_PRODUCT","PROD_DEFAULT_CURR_CODE","PILH0341", null, null, null, null,
						(String) currValue);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return suggestionList;
		}
		
		public void validatePROD_DEFAULT_CURR_CODE(FacesContext facesContext,
				 UIComponent component, Object value) throws ValidatorException {
			 CommonUtils.clearMaps(this);
			 try {
				 
				 PM_IL_PRODUCT_BEAN.setPROD_DEFAULT_CURR_CODE((String) value);
				 COMP_PROD_DEFAULT_CURR_CODE.resetValue();
				 
			 } catch (Exception exception) {
				 exception.printStackTrace();
				 throw new ValidatorException(new FacesMessage(exception
						 .getMessage()));
			 } finally {
				 try {
					 ErrorHelpUtil
					 .getWarningForProcedure(CommonUtils.getConnection(),
							 "PROD_DEFAULT_CURR_CODE", getWarningMap());
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
		 }

		
		/*End Newly added by pidugu raj dt: 16-09-2020 as suggested by kk and sitrasan for Alliance IL*/
		
		
		/*Added by senthilnathan for Alliance_IL ON 05.02.2021 as suggested by sivaram and abhilash*/
		private HtmlOutputLabel COMP_PROD_RI_FORMULA_CODE_LABEL;
		private HtmlInputText COMP_PROD_RI_FORMULA_CODE;
		private HtmlInputText COMP_UI_M_PROD_RI_FORMULA_CODE_DESC;
		private HtmlInputText COMP_UI_M_PROD_FORMULA_CODE_DESC;
		
		
		
		public HtmlOutputLabel getCOMP_PROD_RI_FORMULA_CODE_LABEL() {
			return COMP_PROD_RI_FORMULA_CODE_LABEL;
		}

		public void setCOMP_PROD_RI_FORMULA_CODE_LABEL(
				HtmlOutputLabel cOMP_PROD_RI_FORMULA_CODE_LABEL) {
			COMP_PROD_RI_FORMULA_CODE_LABEL = cOMP_PROD_RI_FORMULA_CODE_LABEL;
		}

		public HtmlInputText getCOMP_PROD_RI_FORMULA_CODE() {
			return COMP_PROD_RI_FORMULA_CODE;
		}

		public void setCOMP_PROD_RI_FORMULA_CODE(HtmlInputText cOMP_PROD_RI_FORMULA_CODE) {
			COMP_PROD_RI_FORMULA_CODE = cOMP_PROD_RI_FORMULA_CODE;
		}

		public HtmlInputText getCOMP_UI_M_PROD_RI_FORMULA_CODE_DESC() {
			return COMP_UI_M_PROD_RI_FORMULA_CODE_DESC;
		}

		public void setCOMP_UI_M_PROD_RI_FORMULA_CODE_DESC(
				HtmlInputText cOMP_UI_M_PROD_RI_FORMULA_CODE_DESC) {
			COMP_UI_M_PROD_RI_FORMULA_CODE_DESC = cOMP_UI_M_PROD_RI_FORMULA_CODE_DESC;
		}

		public HtmlInputText getCOMP_UI_M_PROD_FORMULA_CODE_DESC() {
			return COMP_UI_M_PROD_FORMULA_CODE_DESC;
		}

		public void setCOMP_UI_M_PROD_FORMULA_CODE_DESC(
				HtmlInputText cOMP_UI_M_PROD_FORMULA_CODE_DESC) {
			COMP_UI_M_PROD_FORMULA_CODE_DESC = cOMP_UI_M_PROD_FORMULA_CODE_DESC;
		}

		public void PROD_RI_FORMULA_CODE_Validator(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				PM_IL_PRODUCT_BEAN.setPROD_RI_FORMULA_CODE((String) value);
				
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

		public ArrayList<LovBean> lovPROD_RI_FORMULA_CODE(Object object) {
			 ArrayList<LovBean> suggestionList = null;
		    	String query1 = " SELECT FRM_CODE,FRM_DESC FROM PM_IL_FORMULA "
						+ " WHERE (UPPER(FRM_CODE) LIKE UPPER(?) OR UPPER(FRM_DESC) LIKE UPPER(?) ) AND ROWNUM < ? ORDER BY 1";
				try {
					String currentValue = (String) object;
					currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

					suggestionList = ListItemUtil.prepareSuggestionList(query1,
							new Object[] { currentValue, currentValue,
							PELConstants.suggetionRecordSize });
				} catch (Exception e) {
					e.printStackTrace();
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
					getErrorMap().put("SUGGETION", e.getMessage());
				}
				return suggestionList;
		   }
		
		
		public ArrayList<LovBean> lovPROD_FORMULA_CODE(Object object) {
			 ArrayList<LovBean> suggestionList = null;
		    	String query1 = " SELECT FRM_CODE,FRM_DESC FROM PM_IL_FORMULA "
						+ " WHERE (UPPER(FRM_CODE) LIKE UPPER(?) OR UPPER(FRM_DESC) LIKE UPPER(?) ) AND ROWNUM < ? ORDER BY 1";
				try {
					String currentValue = (String) object;
					currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

					suggestionList = ListItemUtil.prepareSuggestionList(query1,
							new Object[] { currentValue, currentValue,
							PELConstants.suggetionRecordSize });
				} catch (Exception e) {
					e.printStackTrace();
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
					getErrorMap().put("SUGGETION", e.getMessage());
				}
				return suggestionList;
		   }
		
		
		
		
		
		/*End*/

}
