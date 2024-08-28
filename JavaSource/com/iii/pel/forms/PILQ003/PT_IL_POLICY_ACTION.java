package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
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

import org.ajax4jsf.component.html.HtmlAjaxRegion;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlTab;
import org.richfaces.component.html.HtmlTabPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POLICY_ACTION extends CommonAction {

    private HtmlTab COMP_MORE_INFO_1;

    private HtmlTab COMP_MORE_INFO_2;

    private HtmlTab COMP_MORE_INFO_3;
    
    private HtmlTab COMP_ADDRESS;
    
    private HtmlTabPanel COMP_TAB_PANEL;
    
    private HtmlInputText COMP_UI_M_POL_CONT_DESC;
    
    private HtmlOutputLabel COMP_FORM_CAPTION;

    private HtmlOutputLabel COMP_POL_CURR_SA_LIMIT_LABEL;

    private HtmlInputText COMP_POL_CURR_SA_LIMIT;

    private HtmlOutputLabel COMP_POL_CURR_SA_LABEL;

    private HtmlInputText COMP_POL_CURR_SA;

    private HtmlOutputLabel COMP_PROP_LC_DEP_PREM_LABEL;

    private HtmlInputText COMP_PROP_LC_DEP_PREM;

    private HtmlOutputLabel COMP_PROP_FC_DEP_PREM_LABEL;

    private HtmlInputText COMP_PROP_FC_DEP_PREM;

    private HtmlOutputLabel COMP_POL_DEF_PERIOD_FM_LABEL;

    private HtmlInputText COMP_POL_DEF_PERIOD_FM;

    private HtmlOutputLabel COMP_POL_DEF_PERIOD_TO_LABEL;

    private HtmlInputText COMP_POL_DEF_PERIOD_TO;

    private HtmlOutputLabel COMP_POL_WAQAF_PERIOD_FM_LABEL;

    private HtmlInputText COMP_POL_WAQAF_PERIOD_FM;

    private HtmlOutputLabel COMP_POL_WAQAF_PERIOD_TO_LABEL;

    private HtmlInputText COMP_POL_WAQAF_PERIOD_TO;

    private HtmlOutputLabel COMP_POL_END_CODE_LABEL;

    private HtmlInputText COMP_POL_END_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_END_CODE_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_END_CODE_DESC;

    private HtmlOutputLabel COMP_POL_END_DT_LABEL;

    private HtmlCalendar COMP_POL_END_DT;

    private HtmlOutputLabel COMP_POL_MED_FEE_RECOVER_YN_LABEL;

    private HtmlSelectOneMenu COMP_POL_MED_FEE_RECOVER_YN;

    private HtmlOutputLabel COMP_POL_END_NO_LABEL;

    private HtmlInputText COMP_POL_END_NO;

    private HtmlOutputLabel COMP_POL_END_EFF_FROM_DT_LABEL;

    private HtmlCalendar COMP_POL_END_EFF_FROM_DT;

    private HtmlOutputLabel COMP_POL_END_EFF_TO_DT_LABEL;

    private HtmlCalendar COMP_POL_END_EFF_TO_DT;

    private HtmlOutputLabel COMP_POL_END_DESC_LABEL;

    private HtmlInputText COMP_POL_END_DESC;

    private HtmlOutputLabel COMP_UI_M_PAY_PERIOD_LABEL;

    private HtmlInputText COMP_UI_M_PAY_PERIOD;

    private HtmlOutputLabel COMP_UI_M_PAY_YEARS_LABEL;

    private HtmlInputText COMP_UI_M_PAY_YEARS;

    private HtmlOutputLabel COMP_UI_M_LC_SA_LABEL;

    private HtmlInputText COMP_UI_M_LC_SA;

    private HtmlOutputLabel COMP_UI_M_FC_SA_LABEL;

    private HtmlInputText COMP_UI_M_FC_SA;
    
    private HtmlAjaxRegion  COMP_REGION_ONE;
    
    private HtmlAjaxRegion  COMP_REGION_TWO;
    
    private HtmlAjaxRegion  COMP_REGION_THREE;
    
    private HtmlAjaxRegion  COMP_REGION_FOUR;

    private HtmlOutputLabel COMP_UI_M_ADDL_STATUS_DESC;

    private HtmlOutputLabel COMP_UI_M_APPRV_STATUS;

    private HtmlOutputLabel COMP_UI_M_BUS_STATUS;

    private HtmlOutputLabel COMP_UI_M_END_STATUS;

    private HtmlOutputLabel COMP_UI_M_END_IDX_TYPE_NO;

    private HtmlOutputLabel COMP_UI_M_AMEND_IDX;

    private HtmlOutputLabel COMP_POL_PROD_CODE_LABEL;

    private HtmlInputText COMP_POL_PROD_CODE;

    private HtmlOutputLabel COMP_UI_M_PROD_DESC_LABEL;

    private HtmlInputText COMP_UI_M_PROD_DESC;

    private HtmlOutputLabel COMP_POL_PROD_GROUP_CODE_LABEL;

    private HtmlInputText COMP_POL_PROD_GROUP_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_PROD_GROUP_CODE_LABEL;

    private HtmlInputText COMP_UI_M_POL_PROD_GROUP_CODE;

    private HtmlOutputLabel COMP_POL_PLAN_CODE_LABEL;

    private HtmlInputText COMP_POL_PLAN_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_PLAN_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_PLAN_DESC;

    private HtmlOutputLabel COMP_UI_M_ICON_HINT;

    private HtmlOutputLabel COMP_UI_M_CLM_ADDL_STATUS;

    private HtmlOutputLabel COMP_POL_ISSUE_DT_LABEL;

    private HtmlCalendar COMP_POL_ISSUE_DT;

    private HtmlOutputLabel COMP_POL_UW_YEAR_LABEL;

    private HtmlInputText COMP_POL_UW_YEAR;

    private HtmlOutputLabel COMP_POL_NO_YRS_PREM_PAID_LABEL;

    private HtmlInputText COMP_POL_NO_YRS_PREM_PAID;

    private HtmlOutputLabel COMP_UI_M_CIC_STATUS;

    private HtmlOutputLabel COMP_POL_JOINT_LIFE_YN_LABEL;

    private HtmlSelectOneMenu COMP_POL_JOINT_LIFE_YN;

    private HtmlOutputLabel COMP_POL_JOINT_LIFE_AGE_LABEL;

    private HtmlInputText COMP_POL_JOINT_LIFE_AGE;

    private HtmlOutputLabel COMP_POL_FRZ_FLAG_LABEL;

    private HtmlSelectOneMenu COMP_POL_FRZ_FLAG;

    private HtmlOutputLabel COMP_UI_M_WAI_STATUS;

    private HtmlOutputLabel COMP_POL_NO_LABEL;

    private HtmlInputText COMP_POL_NO;

    private HtmlOutputLabel COMP_POL_CASH_YN_LABEL;

    private HtmlSelectOneMenu COMP_POL_CASH_YN;

    private HtmlOutputLabel COMP_UI_M_HOLD_STATUS;

    private HtmlOutputLabel COMP_POL_ASSRD_REF_ID1_LABEL;

    private HtmlInputText COMP_POL_ASSRD_REF_ID1;

    private HtmlOutputLabel COMP_POL_TRAN_DT_LABEL;

    private HtmlCalendar COMP_POL_TRAN_DT;

    private HtmlOutputLabel COMP_POL_ASSRD_REF_ID2_LABEL;

    private HtmlInputText COMP_POL_ASSRD_REF_ID2;

    private HtmlOutputLabel COMP_UI_M_MAT_AGE_LABEL;

    private HtmlInputText COMP_UI_M_MAT_AGE;

    private HtmlOutputLabel COMP_POL_APPRV_UID;

    private HtmlOutputLabel COMP_UI_M_POL_CONVERT_YN;

    private HtmlOutputLabel COMP_UI_M_POL_LC_SA1_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_SA1;

    private HtmlOutputLabel COMP_POL_BASIC_RATE1_LABEL;

    private HtmlInputText COMP_POL_BASIC_RATE1;

    private HtmlOutputLabel COMP_POL_LC_BASIC_PREM1_LABEL;

    private HtmlInputText COMP_POL_LC_BASIC_PREM1;

    private HtmlOutputLabel COMP_POL_LC_ADDL_PREM1_LABEL;

    private HtmlInputText COMP_POL_LC_ADDL_PREM1;

    private HtmlOutputLabel COMP_UI_M_POL_LC_TOT_PREM1_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_TOT_PREM1;

    private HtmlOutputLabel COMP_UI_M_POL_LC_TOT_LOADING1_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_TOT_LOADING1;

    private HtmlOutputLabel COMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_TOT_DISCOUNT1;

    private HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL;

    private HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_CUST1;

    private HtmlOutputLabel COMP_UI_M_POL_LC_NET_PREM1_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_NET_PREM1;

    private HtmlOutputLabel COMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL;

    private HtmlInputText COMP_UI_M_POL_MODE_OF_PYMT_RATE1;

    private HtmlOutputLabel COMP_UI_M_POL_LC_MOP1_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_MOP1;

    private HtmlOutputLabel COMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_GR_ANN_PREM1;

    private HtmlOutputLabel COMP_UI_M_POL_INST_LC_PREM1_LABEL;

    private HtmlInputText COMP_UI_M_POL_INST_LC_PREM1;

    private HtmlOutputLabel COMP_POL_LC_DISC_AMT1_LABEL;

    private HtmlInputText COMP_POL_LC_DISC_AMT1;

    private HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL;

    private HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_CUST1;

    private HtmlOutputLabel COMP_POL_LC_FIRST_PREM1_LABEL;

    private HtmlInputText COMP_POL_LC_FIRST_PREM1;

    private HtmlOutputLabel COMP_POL_RES_ADDRESS_1_LABEL;

    private HtmlInputText COMP_POL_RES_ADDRESS_1;

    private HtmlOutputLabel COMP_POL_RES_ADDRESS_2_LABEL;

    private HtmlInputText COMP_POL_RES_ADDRESS_2;

    private HtmlOutputLabel COMP_POL_RES_ADDRESS_3_LABEL;

    private HtmlInputText COMP_POL_RES_ADDRESS_3;

    private HtmlOutputLabel COMP_POL_RES_AREA_CODE_LABEL;

    private HtmlInputText COMP_POL_RES_AREA_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_RES_AREA_CODE_DESC;

    private HtmlOutputLabel COMP_POL_CITY_CODE_LABEL;

    private HtmlInputText COMP_POL_CITY_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_CITY_NAME_LABEL;

    private HtmlInputText COMP_UI_M_POL_CITY_NAME;

    private HtmlOutputLabel COMP_POL_STATE_CODE_LABEL;

    private HtmlInputText COMP_POL_STATE_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_STATE_NAME_LABEL;

    private HtmlInputText COMP_UI_M_POL_STATE_NAME;

    private HtmlOutputLabel COMP_POL_COUNT_CODE_LABEL;

    private HtmlInputText COMP_POL_COUNT_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_COUNT_NAME_LABEL;

    private HtmlInputText COMP_UI_M_POL_COUNT_NAME;

    private HtmlOutputLabel COMP_POL_RES_PHONE_NO_LABEL;

    private HtmlInputText COMP_POL_RES_PHONE_NO;

    private HtmlOutputLabel COMP_POL_MOBILE_NO_LABEL;

    private HtmlInputText COMP_POL_MOBILE_NO;

    private HtmlOutputLabel COMP_POL_OFF_ADDRESS_1_LABEL;

    private HtmlInputText COMP_POL_OFF_ADDRESS_1;

    private HtmlOutputLabel COMP_POL_OFF_ADDRESS_2_LABEL;

    private HtmlInputText COMP_POL_OFF_ADDRESS_2;

    private HtmlOutputLabel COMP_POL_OFF_ADDRESS_3_LABEL;

    private HtmlInputText COMP_POL_OFF_ADDRESS_3;

    private HtmlOutputLabel COMP_POL_OFF_AREA_CODE_LABEL;

    private HtmlInputText COMP_POL_OFF_AREA_CODE;

    private HtmlOutputLabel COMP_UI_M_POSTAL_NAME_LABEL;

    private HtmlInputText COMP_UI_M_POSTAL_NAME;

    private HtmlOutputLabel COMP_POL_OFF_PHONE_NO_LABEL;

    private HtmlInputText COMP_POL_OFF_PHONE_NO;

    private HtmlOutputLabel COMP_POL_FAX_NO_LABEL;

    private HtmlInputText COMP_POL_FAX_NO;

    private HtmlOutputLabel COMP_POL_FAX_AREA_CODE_LABEL;

    private HtmlInputText COMP_POL_FAX_AREA_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_ADDL_STATUS_DESC;

    private HtmlOutputLabel COMP_PAYOR_TAB_LABEL;

    private HtmlInputText COMP_PAYOR_TAB;

    private HtmlOutputLabel COMP_POL_MASTER_POL_NO_LABEL;

    private HtmlInputText COMP_POL_MASTER_POL_NO;

    private HtmlOutputLabel COMP_POL_PROFIT_RATE_LABEL;

    private HtmlInputText COMP_POL_PROFIT_RATE;

    private HtmlOutputLabel COMP_POL_MODE_OF_CALC_LABEL;

    private HtmlSelectOneMenu COMP_POL_MODE_OF_CALC;

    private HtmlOutputLabel COMP_POL_CREDIT_INT_RATE_LABEL;

    private HtmlInputText COMP_POL_CREDIT_INT_RATE;

    private HtmlOutputLabel COMP_POL_PROP_NO_LABEL;

    private HtmlInputText COMP_POL_PROP_NO;

    private HtmlOutputLabel COMP_UI_M_POL_FC_SA_LABEL;

    private HtmlInputText COMP_UI_M_POL_FC_SA;

    private HtmlOutputLabel COMP_UI_M_POL_LC_SA_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_SA;

    private HtmlOutputLabel COMP_POL_OCC_RATE_LABEL;

    private HtmlInputText COMP_POL_OCC_RATE;

    private HtmlOutputLabel COMP_POL_HEALTH_RATE_LABEL;

    private HtmlInputText COMP_POL_HEALTH_RATE;

    private HtmlOutputLabel COMP_POL_PROJECT_CODE_LABEL;

    private HtmlInputText COMP_POL_PROJECT_CODE;

    private HtmlOutputLabel COMP_UI_M_PROJECT_CODE_DESC_LABEL;

    private HtmlInputText COMP_UI_M_PROJECT_CODE_DESC;

    private HtmlOutputLabel COMP_POL_DEVELOPER_CODE_LABEL;

    private HtmlInputText COMP_POL_DEVELOPER_CODE;

    private HtmlOutputLabel COMP_UI_M_DEVELOPER_CODE_DESC_LABEL;

    private HtmlInputText COMP_UI_M_DEVELOPER_CODE_DESC;

    private HtmlOutputLabel COMP_POL_PYMT_TYPE_LABEL;

    private HtmlSelectOneMenu COMP_POL_PYMT_TYPE;

    private HtmlOutputLabel COMP_POL_PAYOR_SDCODE_LABEL;

    private HtmlInputText COMP_POL_PAYOR_SDCODE;

    private HtmlOutputLabel COMP_UI_M_PAYOR_CONT_NAME_LABEL;

    private HtmlInputText COMP_UI_M_PAYOR_CONT_NAME;

    private HtmlOutputLabel COMP_POL_CUST_CODE_LABEL;

    private HtmlInputText COMP_POL_CUST_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_CUST_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_CUST_DESC;

    private HtmlOutputLabel COMP_POL_BASIC_RATE_LABEL;

    private HtmlInputText COMP_POL_BASIC_RATE;

    private HtmlOutputLabel COMP_POL_FC_BASIC_PREM_LABEL;

    private HtmlInputText COMP_POL_FC_BASIC_PREM;

    private HtmlOutputLabel COMP_POL_LC_BASIC_PREM_LABEL;

    private HtmlInputText COMP_POL_LC_BASIC_PREM;

    private HtmlOutputLabel COMP_POL_FC_HEALTH_LOAD_LABEL;

    private HtmlInputText COMP_POL_FC_HEALTH_LOAD;

    private HtmlOutputLabel COMP_POL_LC_HEALTH_LOAD_LABEL;

    private HtmlInputText COMP_POL_LC_HEALTH_LOAD;

    private HtmlOutputLabel COMP_POL_HOME_OWNER_FLAG_LABEL;

    private HtmlSelectOneMenu COMP_POL_HOME_OWNER_FLAG;

    private HtmlOutputLabel COMP_POL_FLEX_01_LABEL;

    private HtmlInputText COMP_POL_FLEX_01;

    private HtmlOutputLabel COMP_UI_M_CONT_NAME_LABEL;

    private HtmlInputText COMP_UI_M_CONT_NAME;

    private HtmlOutputLabel COMP_POL_DEFER_PRD_LABEL;

    private HtmlInputText COMP_POL_DEFER_PRD;

    private HtmlOutputLabel COMP_POL_EMPLOYER_CODE_LABEL;

    private HtmlInputText COMP_POL_EMPLOYER_CODE;

    private HtmlOutputLabel COMP_POL_SRC_OF_BUS_LABEL;

    private HtmlInputText COMP_POL_SRC_OF_BUS;

    private HtmlOutputLabel COMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_SRC_OF_BUS_DESC;

    private HtmlOutputLabel COMP_POL_FC_ADDL_PREM_LABEL;

    private HtmlInputText COMP_POL_FC_ADDL_PREM;

    private HtmlOutputLabel COMP_POL_LC_ADDL_PREM_LABEL;

    private HtmlInputText COMP_POL_LC_ADDL_PREM;

    private HtmlOutputLabel COMP_POL_FC_TOT_SA_LABEL;

    private HtmlInputText COMP_POL_FC_TOT_SA;

    private HtmlOutputLabel COMP_POL_LC_TOT_SA_LABEL;

    private HtmlInputText COMP_POL_LC_TOT_SA;

    private HtmlOutputLabel COMP_POL_PROP_RECV_DT_LABEL;

    private HtmlCalendar COMP_POL_PROP_RECV_DT;

    private HtmlOutputLabel COMP_UI_M_FC_DEATH_LOAD_LABEL;

    private HtmlInputText COMP_UI_M_FC_DEATH_LOAD;

    private HtmlOutputLabel COMP_UI_M_LC_DEATH_LOAD_LABEL;

    private HtmlInputText COMP_UI_M_LC_DEATH_LOAD;

    private HtmlOutputLabel COMP_POL_FLEX_02_LABEL;

    private HtmlInputText COMP_POL_FLEX_02;

    private HtmlOutputLabel COMP_POL_INCORPORATED_YN_LABEL;

    private HtmlSelectOneMenu COMP_POL_INCORPORATED_YN;

    private HtmlOutputLabel COMP_POL_SUB_PLAN_CODE_LABEL;

    private HtmlInputText COMP_POL_SUB_PLAN_CODE;

    private HtmlOutputLabel COMP_POL_NET_PREM_YN_LABEL;

    private HtmlSelectOneMenu COMP_POL_NET_PREM_YN;

    private HtmlOutputLabel COMP_POL_CONT_CODE_LABEL;

    private HtmlInputText COMP_POL_CONT_CODE;

    private HtmlOutputLabel COMP_POL_ASSURED_NAME_LABEL;

    private HtmlInputText COMP_POL_ASSURED_NAME;

    private HtmlOutputLabel COMP_UI_M_POL_FC_TOT_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_FC_TOT_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_LC_TOT_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_TOT_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_FC_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_FC_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_LC_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_PREM;

    private HtmlOutputLabel COMP_POL_PROP_STAMP_DT_LABEL;

    private HtmlCalendar COMP_POL_PROP_STAMP_DT;

    private HtmlOutputLabel COMP_UI_M_FC_TPD_LOAD_LABEL;

    private HtmlInputText COMP_UI_M_FC_TPD_LOAD;

    private HtmlOutputLabel COMP_UI_M_LC_TPD_LOAD_LABEL;

    private HtmlInputText COMP_UI_M_LC_TPD_LOAD;

    private HtmlOutputLabel COMP_POL_FLEX_03_LABEL;

    private HtmlInputText COMP_POL_FLEX_03;

    private HtmlOutputLabel COMP_POL_GRANTEE_NAME_LABEL;

    private HtmlInputText COMP_POL_GRANTEE_NAME;

    private HtmlOutputLabel COMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_SUB_PLAN_CODE_DESC;

    private HtmlOutputLabel COMP_POL_GRANTEE_TYPE_LABEL;

    private HtmlSelectOneMenu COMP_POL_GRANTEE_TYPE;

    private HtmlOutputLabel COMP_POL_PERIOD_LABEL;

    private HtmlInputText COMP_POL_PERIOD;

    private HtmlOutputLabel COMP_POL_PREM_PAY_YRS_LABEL;

    private HtmlInputText COMP_POL_PREM_PAY_YRS;

    private HtmlOutputLabel COMP_POL_FC_NETT_PREM_LABEL;

    private HtmlInputText COMP_POL_FC_NETT_PREM;

    private HtmlOutputLabel COMP_POL_LC_NETT_PREM_LABEL;

    private HtmlInputText COMP_POL_LC_NETT_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_FC_TOT_LOADING_LABEL;

    private HtmlInputText COMP_UI_M_POL_FC_TOT_LOADING;

    private HtmlOutputLabel COMP_UI_M_POL_LC_TOT_LOADING_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_TOT_LOADING;

    private HtmlOutputLabel COMP_POL_PROP_DECL_DT_LABEL;

    private HtmlCalendar COMP_POL_PROP_DECL_DT;

    private HtmlOutputLabel COMP_UI_M_FC_MED_LOAD_LABEL;

    private HtmlInputText COMP_UI_M_FC_MED_LOAD;

    private HtmlOutputLabel COMP_UI_M_LC_MED_LOAD_LABEL;

    private HtmlInputText COMP_UI_M_LC_MED_LOAD;

    private HtmlOutputLabel COMP_POL_LC_TOP_UP_AMT_LABEL;

    private HtmlInputText COMP_POL_LC_TOP_UP_AMT;

    private HtmlOutputLabel COMP_POL_INTRODUCER_REF_ID1_LABEL;

    private HtmlInputText COMP_POL_INTRODUCER_REF_ID1;

    private HtmlOutputLabel COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC;

    private HtmlOutputLabel COMP_POL_BANK_BRANCH_NAME_LABEL;

    private HtmlInputText COMP_POL_BANK_BRANCH_NAME;

    private HtmlOutputLabel COMP_UI_M_BRANCH_CODE_DESC_LABEL;

    private HtmlInputText COMP_UI_M_BRANCH_CODE_DESC;

    private HtmlOutputLabel COMP_POL_START_DT_LABEL;

    private HtmlCalendar COMP_POL_START_DT;

    private HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL;

    private HtmlCalendar COMP_POL_EXPIRY_DT;

    private HtmlOutputLabel COMP_POL_DIVN_CODE_LABEL;

    private HtmlInputText COMP_POL_DIVN_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL;

    private HtmlInputText COMP_UI_M_POL_FC_TOT_DISCOUNT;

    private HtmlOutputLabel COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_TOT_DISCOUNT;

    private HtmlOutputLabel COMP_POL_FC_CURR_SA_LABEL;

    private HtmlInputText COMP_POL_FC_CURR_SA;

    private HtmlOutputLabel COMP_POL_LC_CURR_SA_LABEL;

    private HtmlInputText COMP_POL_LC_CURR_SA;

    private HtmlOutputLabel COMP_POL_FC_TOP_UP_AMT_LABEL;

    private HtmlInputText COMP_POL_FC_TOP_UP_AMT;

    private HtmlOutputLabel COMP_UI_M_FC_OCC_LOAD_LABEL;

    private HtmlInputText COMP_UI_M_FC_OCC_LOAD;

    private HtmlOutputLabel COMP_UI_M_LC_OCC_LOAD_LABEL;

    private HtmlInputText COMP_UI_M_LC_OCC_LOAD;

    private HtmlOutputLabel COMP_POL_RATE_APPLIED_ON_LABEL;

    private HtmlSelectOneMenu COMP_POL_RATE_APPLIED_ON;

    private HtmlOutputLabel COMP_POL_BANK_REF_NO_LABEL;

    private HtmlInputText COMP_POL_BANK_REF_NO;

    private HtmlOutputLabel COMP_POL_SA_CURR_CODE_LABEL;

    private HtmlInputText COMP_POL_SA_CURR_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_SA_CURR_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_SA_CURR_DESC;

    private HtmlOutputLabel COMP_POL_SA_EXCH_RATE_LABEL;

    private HtmlInputText COMP_POL_SA_EXCH_RATE;

    private HtmlOutputLabel COMP_UI_M_POL_DIVN_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_DIVN_DESC;

    private HtmlOutputLabel COMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL;

    private HtmlInputText COMP_UI_M_FC_PCHARGES_BORNE_CUST;

    private HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL;

    private HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_CUST;

    private HtmlOutputLabel COMP_POL_ORG_PROP_RECV_YN_LABEL;

    private HtmlSelectOneMenu COMP_POL_ORG_PROP_RECV_YN;

    private HtmlOutputLabel COMP_UI_M_FC_GROSS_CONT_LABEL;

    private HtmlInputText COMP_UI_M_FC_GROSS_CONT;

    private HtmlOutputLabel COMP_UI_M_LC_GROSS_CONT_LABEL;

    private HtmlInputText COMP_UI_M_LC_GROSS_CONT;

    private HtmlOutputLabel COMP_POL_LC_EXC_INT_AMT_LABEL;

    private HtmlInputText COMP_POL_LC_EXC_INT_AMT;

    private HtmlOutputLabel COMP_POL_NL_FM_DT_LABEL;

    private HtmlCalendar COMP_POL_NL_FM_DT;

    private HtmlOutputLabel COMP_POL_TARIFF_TERM_FLAG_LABEL;

    private HtmlSelectOneMenu COMP_POL_TARIFF_TERM_FLAG;

    private HtmlOutputLabel COMP_POL_CUST_CURR_CODE_LABEL;

    private HtmlInputText COMP_POL_CUST_CURR_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_CUST_CURR_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_CUST_CURR_DESC;

    private HtmlOutputLabel COMP_POL_CUST_EXCH_RATE_LABEL;

    private HtmlInputText COMP_POL_CUST_EXCH_RATE;

    private HtmlOutputLabel COMP_POL_DEPT_CODE_LABEL;

    private HtmlInputText COMP_POL_DEPT_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_FC_NET_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_FC_NET_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_LC_NET_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_NET_PREM;

    private HtmlOutputLabel COMP_UI_M_FC_BROK_COMM_LABEL;

    private HtmlInputText COMP_UI_M_FC_BROK_COMM;

    private HtmlOutputLabel COMP_UI_M_LC_BROK_COMM_LABEL;

    private HtmlInputText COMP_UI_M_LC_BROK_COMM;

    private HtmlOutputLabel COMP_POL_EXC_INT_PERC_LABEL;

    private HtmlInputText COMP_POL_EXC_INT_PERC;

    private HtmlOutputLabel COMP_POL_STAFF_CCLASS_CODE_LABEL;

    private HtmlInputText COMP_POL_STAFF_CCLASS_CODE;

    private HtmlOutputLabel COMP_UI_M_CCLAS_CLASS_DESC_LABEL;

    private HtmlInputText COMP_UI_M_CCLAS_CLASS_DESC;

    private HtmlOutputLabel COMP_POL_STD_RISK_YN_LABEL;

    private HtmlSelectOneMenu COMP_POL_STD_RISK_YN;

    private HtmlOutputLabel COMP_POL_FC_EXC_INT_AMT_LABEL;

    private HtmlInputText COMP_POL_FC_EXC_INT_AMT;

    private HtmlOutputLabel COMP_POL_FC_MODAL_PREM_LABEL;

    private HtmlInputText COMP_POL_FC_MODAL_PREM;

    private HtmlOutputLabel COMP_POL_NO_OF_UNIT_LABEL;

    private HtmlInputText COMP_POL_NO_OF_UNIT;

    private HtmlOutputLabel COMP_POL_LC_MODAL_PREM_LABEL;

    private HtmlInputText COMP_POL_LC_MODAL_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_DEPT_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_DEPT_DESC;

    private HtmlOutputLabel COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL;

    private HtmlInputText COMP_UI_M_POL_MODE_OF_PYMT_RATE;

    private HtmlOutputLabel COMP_UI_M_POL_FC_MOP_LABEL;

    private HtmlInputText COMP_UI_M_POL_FC_MOP;

    private HtmlOutputLabel COMP_UI_M_POL_LC_MOP_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_MOP;

    private HtmlOutputLabel COMP_UI_M_FC_CHARGE_LABEL;

    private HtmlInputText COMP_UI_M_FC_CHARGE;

    private HtmlOutputLabel COMP_UI_M_LC_CHARGE_LABEL;

    private HtmlInputText COMP_UI_M_LC_CHARGE;

    private HtmlOutputLabel COMP_POL_RI_POOL_CODE_LABEL;

    private HtmlInputText COMP_POL_RI_POOL_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_RI_POOL_CODE_DESC;

    private HtmlOutputLabel COMP_POL_CREDIT_YN_LABEL;

    private HtmlSelectOneMenu COMP_POL_CREDIT_YN;

    private HtmlOutputLabel COMP_POL_LOAD_PERC_LABEL;

    private HtmlInputText COMP_POL_LOAD_PERC;

    private HtmlOutputLabel COMP_POL_STAFF_YN_LABEL;

    private HtmlSelectOneMenu COMP_POL_STAFF_YN;

    private HtmlOutputLabel COMP_POL_FAC_BASIS_LABEL;

    private HtmlSelectOneMenu COMP_POL_FAC_BASIS;

    private HtmlOutputLabel COMP_POL_MODE_OF_PYMT_LABEL;

    private HtmlSelectOneMenu COMP_POL_MODE_OF_PYMT;

    private HtmlOutputLabel COMP_POL_NO_OF_INST_LABEL;

    private HtmlInputText COMP_POL_NO_OF_INST;

    private HtmlOutputLabel COMP_POL_MODE_OF_PYMT_RATE_LABEL;

    private HtmlInputText COMP_POL_MODE_OF_PYMT_RATE;

    private HtmlOutputLabel COMP_POL_CLASS_CODE_LABEL;

    private HtmlInputText COMP_POL_CLASS_CODE;

    private HtmlOutputLabel COMP_UI_M_POL_FC_GR_ANN_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_FC_GR_ANN_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_GR_ANN_PREM;

    private HtmlOutputLabel COMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL;

    private HtmlInputText COMP_UI_M_FC_PCHARGES_BORNE_COMP;

    private HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL;

    private HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_COMP;

    private HtmlOutputLabel COMP_POL_FC_NET_PREM_LABEL;

    private HtmlInputText COMP_POL_FC_NET_PREM;

    private HtmlOutputLabel COMP_POL_LC_NET_PREM_LABEL;

    private HtmlInputText COMP_POL_LC_NET_PREM;

    private HtmlOutputLabel COMP_UI_M_FC_INST_PREM_LABEL;

    private HtmlInputText COMP_UI_M_FC_INST_PREM;

    private HtmlOutputLabel COMP_UI_M_LC_INST_PREM_LABEL;

    private HtmlInputText COMP_UI_M_LC_INST_PREM;

    private HtmlOutputLabel COMP_POL_CQS_PERC_LABEL;

    private HtmlInputText COMP_POL_CQS_PERC;

    private HtmlOutputLabel COMP_POL_CREDIT_DISCOUNT_PERC_LABEL;

    private HtmlInputText COMP_POL_CREDIT_DISCOUNT_PERC;

    private HtmlOutputLabel COMP_POL_FAC_YN_LABEL;

    private HtmlSelectOneMenu COMP_POL_FAC_YN;

    private HtmlOutputLabel COMP_POL_FORM_NO_LABEL;

    private HtmlInputText COMP_POL_FORM_NO;

    private HtmlOutputLabel COMP_POL_FC_SUM_ASSURED_LABEL;

    private HtmlInputText COMP_POL_FC_SUM_ASSURED;

    private HtmlOutputLabel COMP_POL_LC_SUM_ASSURED_LABEL;

    private HtmlInputText COMP_POL_LC_SUM_ASSURED;

    private HtmlOutputLabel COMP_UI_M_POL_CLASS_DESC_LABEL;

    private HtmlInputText COMP_UI_M_POL_CLASS_DESC;

    private HtmlOutputLabel COMP_UI_M_POL_INST_FC_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_INST_FC_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_INST_LC_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_INST_LC_PREM;

    private HtmlOutputLabel COMP_POL_FC_BANK_ALLOC_AMT_LABEL;

    private HtmlInputText COMP_POL_FC_BANK_ALLOC_AMT;

    private HtmlOutputLabel COMP_POL_LC_BANK_ALLOC_AMT_LABEL;

    private HtmlInputText COMP_POL_LC_BANK_ALLOC_AMT;

    private HtmlOutputLabel COMP_UI_M_POL_CONT_AD_ACC_NO_LABEL;

    private HtmlInputText COMP_UI_M_POL_CONT_AD_ACC_NO;

    private HtmlOutputLabel COMP_POL_PROP_REF_NO_LABEL;

    private HtmlInputText COMP_POL_PROP_REF_NO;

    private HtmlOutputLabel COMP_POL_AGENT_REF_CODE_LABEL;

    private HtmlInputText COMP_POL_AGENT_REF_CODE;

    private HtmlOutputLabel COMP_POL_CQS_YN_LABEL;

    private HtmlSelectOneMenu COMP_POL_CQS_YN;

    private HtmlOutputLabel COMP_POL_FC_DEPOSIT_AMOUNT_LABEL;

    private HtmlInputText COMP_POL_FC_DEPOSIT_AMOUNT;

    private HtmlOutputLabel COMP_POL_LC_DEPOSIT_AMOUNT_LABEL;

    private HtmlInputText COMP_POL_LC_DEPOSIT_AMOUNT;

    private HtmlOutputLabel COMP_POL_LC_MIN_PREM_LABEL;

    private HtmlInputText COMP_POL_LC_MIN_PREM;

    private HtmlOutputLabel COMP_POL_FC_DISC_AMT_LABEL;

    private HtmlInputText COMP_POL_FC_DISC_AMT;

    private HtmlOutputLabel COMP_POL_LC_DISC_AMT_LABEL;

    private HtmlInputText COMP_POL_LC_DISC_AMT;

    private HtmlOutputLabel COMP_POL_FC_CLIENT_ALLOC_AMT_LABEL;

    private HtmlInputText COMP_POL_FC_CLIENT_ALLOC_AMT;

    private HtmlOutputLabel COMP_POL_LC_CLIENT_ALLOC_AMT_LABEL;

    private HtmlInputText COMP_POL_LC_CLIENT_ALLOC_AMT;

    private HtmlOutputLabel COMP_POL_CONT_AD_BANK_CODE_LABEL;

    private HtmlInputText COMP_POL_CONT_AD_BANK_CODE;

    private HtmlOutputLabel COMP_UI_M_BANK_CODE_DESC_LABEL;

    private HtmlInputText COMP_UI_M_BANK_CODE_DESC;

    private HtmlOutputLabel COMP_POL_FIRST_INST_DT_LABEL;

    private HtmlCalendar COMP_POL_FIRST_INST_DT;

    private HtmlOutputLabel COMP_POL_LAST_INST_DT_LABEL;

    private HtmlCalendar COMP_POL_LAST_INST_DT;

    private HtmlOutputLabel COMP_POL_REMARKS_LABEL;

    private HtmlInputText COMP_POL_REMARKS;

    private HtmlOutputLabel COMP_POL_FC_MIN_PREM_LABEL;

    private HtmlInputText COMP_POL_FC_MIN_PREM;

    private HtmlOutputLabel COMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL;

    private HtmlInputText COMP_UI_M_FC_SCHARGES_BORNE_CUST;

    private HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL;

    private HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_CUST;

    private HtmlOutputLabel COMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL;

    private HtmlInputText COMP_UI_M_FC_SCHARGES_BORNE_COMP;

    private HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL;

    private HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_COMP;

    private HtmlOutputLabel COMP_POL_CARD_HOLDER_NAME_LABEL;

    private HtmlInputText COMP_POL_CARD_HOLDER_NAME;

    private HtmlOutputLabel COMP_POL_DEF_IMM_FLAG_LABEL;

    private HtmlSelectOneMenu COMP_POL_DEF_IMM_FLAG;

    private HtmlOutputLabel COMP_POL_LC_EXTRA_PREM_LABEL;

    private HtmlInputText COMP_POL_LC_EXTRA_PREM;

    private HtmlOutputLabel COMP_POL_FC_EXTRA_PREM_LABEL;

    private HtmlInputText COMP_POL_FC_EXTRA_PREM;

    private HtmlOutputLabel COMP_POL_FC_MON_ANNU_AMT_LABEL;

    private HtmlInputText COMP_POL_FC_MON_ANNU_AMT;

    private HtmlOutputLabel COMP_POL_LC_MON_ANNU_AMT_LABEL;

    private HtmlInputText COMP_POL_LC_MON_ANNU_AMT;

    private HtmlOutputLabel COMP_POL_FC_FIRST_PREM_LABEL;

    private HtmlInputText COMP_POL_FC_FIRST_PREM;

    private HtmlOutputLabel COMP_POL_LC_FIRST_PREM_LABEL;

    private HtmlInputText COMP_POL_LC_FIRST_PREM;

    private HtmlOutputLabel COMP_POL_FC_PRE_TPD_BNF_LABEL;

    private HtmlInputText COMP_POL_FC_PRE_TPD_BNF;

    private HtmlOutputLabel COMP_POL_LC_PRE_TPD_BNF_LABEL;

    private HtmlInputText COMP_POL_LC_PRE_TPD_BNF;

    private HtmlOutputLabel COMP_POL_AUTH_LIMIT_LABEL;

    private HtmlInputText COMP_POL_AUTH_LIMIT;
    
    private HtmlInputText COMP_POL_NEW_LC_SA;
    
    private HtmlInputText COMP_POL_NEW_FC_SA;
    
    private HtmlInputText COMP_POL_ORG_NEW_LC_SA;
    
    private HtmlInputText COMP_POL_ORG_NEW_FC_SA;
    
    /*
     * private HtmlOutputLabel COMP_UI_M_FC_RED_SA_LABEL;
     * 
     * private HtmlInputText COMP_UI_M_FC_RED_SA;
     */

   // private HtmlCommandButton COMP_UI_M_BUS_RUL;
    
    private HtmlCommandButton COMP_UI_M_BUT_CC_LOV;

    private HtmlCommandButton COMP_UI_M_BUT_LOV_GRP_CODE;

    private HtmlCommandButton COMP_UI_M_BUT_COPY;

    private HtmlCommandButton COMP_UI_M_BUT_FUND_QUERY;

    private HtmlCommandButton COMP_UI_M_BUT_HOLD;

    private HtmlCommandButton COMP_UI_M_BUT_UDDATE_STAT;

    private HtmlCommandButton COMP_UI_M_BUT_UPI;

    private HtmlCommandButton COMP_UI_M_BUT_CALC_DISC_LOAD;

    private HtmlCommandButton COMP_UI_M_BUT_SURR_MAT;

  //  private HtmlCommandButton COMP_UI_M_BUT_ENDT;
    
    private HtmlCommandButton COMP_UI_M_BUT_ENDT_OK;
    
    private HtmlCommandButton COMP_UI_M_BUT_ENDT_CANCEL;

    private HtmlCommandButton COMP_UI_M_BUT_APPROVAL;

    private HtmlCommandButton COMP_UI_M_BUT_PRMDTLS;

    private HtmlCommandButton COMP_UI_M_BUT_LOV_PLAN;

    private HtmlCommandButton COMP_UI_M_BUT_DOC_GEN_NO;

    private HtmlCommandButton COMP_UI_M_BUT_LOV_PROD_CODE;

    private HtmlCommandButton COMP_UI_M_BUT_CONVERT;

    private HtmlCommandButton COMP_UI_M_BUT_POL_AMDT;

    private HtmlCommandButton COMP_UI_M_BUT_UPLOAD;

    private HtmlCommandButton COMP_UI_M_BUT_CLAIM;

    private HtmlCommandButton COMP_UI_M_BUT_FUND_DTL;
    
    private String toggleState;

    private PT_IL_POLICY PT_IL_POLICY_BEAN;

    public PILQ003_COMPOSITE_ACTION compositeAction;

    private PT_IL_POLICY_HELPER helper;

    private PT_IL_POLICY_DELEGATE delegate;

    private List<SelectItem> listPOL_MED_FEE_RECOVER_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_JOINT_LIFE_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_FRZ_FLAG = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_CASH_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_MODE_OF_CALC = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_PYMT_TYPE = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_HOME_OWNER_FLAG = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_INCORPORATED_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_NET_PREM_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_GRANTEE_TYPE = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_RATE_APPLIED_ON = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_ORG_PROP_RECV_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_TARIFF_TERM_FLAG = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_STD_RISK_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_CREDIT_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_STAFF_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_FAC_BASIS = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_MODE_OF_PYMT = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_FAC_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_CQS_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listPOL_DEF_IMM_FLAG = new ArrayList<SelectItem>();
    
      

    public PT_IL_POLICY_ACTION() {

	PT_IL_POLICY_BEAN = new PT_IL_POLICY();
	helper = new PT_IL_POLICY_HELPER();
	instantiateAllComponent();
	setListItemValues();

    }



	/**
	 * Instantiates all components in PT_IL_POLICY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_POL_CONT_DESC				 = new HtmlInputText();
		COMP_POL_CURR_SA_LIMIT				 = new HtmlInputText();
		COMP_POL_CURR_SA				 = new HtmlInputText();
		COMP_PROP_LC_DEP_PREM				 = new HtmlInputText();
		COMP_PROP_FC_DEP_PREM				 = new HtmlInputText();
		COMP_POL_DEF_PERIOD_FM				 = new HtmlInputText();
		COMP_POL_DEF_PERIOD_TO				 = new HtmlInputText();
		COMP_POL_WAQAF_PERIOD_FM			 = new HtmlInputText();
		COMP_POL_WAQAF_PERIOD_TO			 = new HtmlInputText();
		COMP_POL_END_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_END_CODE_DESC			 = new HtmlInputText();
		COMP_POL_END_NO					 = new HtmlInputText();
		COMP_POL_END_DESC				 = new HtmlInputText();
		COMP_UI_M_PAY_PERIOD				 = new HtmlInputText();
		COMP_UI_M_PAY_YEARS				 = new HtmlInputText();
		COMP_UI_M_LC_SA					 = new HtmlInputText();
		COMP_UI_M_FC_SA					 = new HtmlInputText();
		COMP_POL_PROD_CODE				 = new HtmlInputText();
		COMP_UI_M_PROD_DESC				 = new HtmlInputText();
		COMP_POL_PROD_GROUP_CODE			 = new HtmlInputText();
		COMP_UI_M_POL_PROD_GROUP_CODE			 = new HtmlInputText();
		COMP_POL_PLAN_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_PLAN_DESC				 = new HtmlInputText();
		COMP_POL_UW_YEAR				 = new HtmlInputText();
		COMP_POL_NO_YRS_PREM_PAID			 = new HtmlInputText();
		COMP_POL_JOINT_LIFE_AGE				 = new HtmlInputText();
		COMP_POL_NO					 = new HtmlInputText();
		COMP_POL_ASSRD_REF_ID1				 = new HtmlInputText();
		COMP_POL_ASSRD_REF_ID2				 = new HtmlInputText();
		COMP_UI_M_MAT_AGE				 = new HtmlInputText();
		COMP_UI_M_POL_LC_SA1				 = new HtmlInputText();
		COMP_POL_BASIC_RATE1				 = new HtmlInputText();
		COMP_POL_LC_BASIC_PREM1				 = new HtmlInputText();
		COMP_POL_LC_ADDL_PREM1				 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_PREM1			 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_LOADING1			 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_DISCOUNT1			 = new HtmlInputText();
		COMP_UI_M_LC_PCHARGES_BORNE_CUST1		 = new HtmlInputText();
		COMP_UI_M_POL_LC_NET_PREM1			 = new HtmlInputText();
		COMP_UI_M_POL_MODE_OF_PYMT_RATE1		 = new HtmlInputText();
		COMP_UI_M_POL_LC_MOP1				 = new HtmlInputText();
		COMP_UI_M_POL_LC_GR_ANN_PREM1			 = new HtmlInputText();
		COMP_UI_M_POL_INST_LC_PREM1			 = new HtmlInputText();
		COMP_POL_LC_DISC_AMT1				 = new HtmlInputText();
		COMP_UI_M_LC_SCHARGES_BORNE_CUST1		 = new HtmlInputText();
		COMP_POL_LC_FIRST_PREM1				 = new HtmlInputText();
		COMP_POL_RES_ADDRESS_1				 = new HtmlInputText();
		COMP_POL_RES_ADDRESS_2				 = new HtmlInputText();
		COMP_POL_RES_ADDRESS_3				 = new HtmlInputText();
		COMP_POL_RES_AREA_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_RES_AREA_CODE_DESC		 = new HtmlInputText();
		COMP_POL_CITY_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_CITY_NAME				 = new HtmlInputText();
		COMP_POL_STATE_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_STATE_NAME			 = new HtmlInputText();
		COMP_POL_COUNT_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_COUNT_NAME			 = new HtmlInputText();
		COMP_POL_RES_PHONE_NO				 = new HtmlInputText();
		COMP_POL_MOBILE_NO				 = new HtmlInputText();
		COMP_POL_OFF_ADDRESS_1				 = new HtmlInputText();
		COMP_POL_OFF_ADDRESS_2				 = new HtmlInputText();
		COMP_POL_OFF_ADDRESS_3				 = new HtmlInputText();
		COMP_POL_OFF_AREA_CODE				 = new HtmlInputText();
		COMP_UI_M_POSTAL_NAME				 = new HtmlInputText();
		COMP_POL_OFF_PHONE_NO				 = new HtmlInputText();
		COMP_POL_FAX_NO					 = new HtmlInputText();
		COMP_POL_FAX_AREA_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_ADDL_STATUS_DESC			 = new HtmlInputText();
		COMP_PAYOR_TAB					 = new HtmlInputText();
		COMP_POL_MASTER_POL_NO				 = new HtmlInputText();
		COMP_POL_PROFIT_RATE				 = new HtmlInputText();
		COMP_POL_CREDIT_INT_RATE			 = new HtmlInputText();
		COMP_POL_PROP_NO				 = new HtmlInputText();
		COMP_UI_M_POL_FC_SA				 = new HtmlInputText();
		COMP_UI_M_POL_LC_SA				 = new HtmlInputText();
		COMP_POL_OCC_RATE				 = new HtmlInputText();
		COMP_POL_HEALTH_RATE				 = new HtmlInputText();
		COMP_POL_PROJECT_CODE				 = new HtmlInputText();
		COMP_UI_M_PROJECT_CODE_DESC			 = new HtmlInputText();
		COMP_POL_DEVELOPER_CODE				 = new HtmlInputText();
		COMP_UI_M_DEVELOPER_CODE_DESC			 = new HtmlInputText();
		COMP_POL_PAYOR_SDCODE				 = new HtmlInputText();
		COMP_UI_M_PAYOR_CONT_NAME			 = new HtmlInputText();
		COMP_POL_CUST_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_CUST_DESC				 = new HtmlInputText();
		COMP_POL_BASIC_RATE				 = new HtmlInputText();
		COMP_POL_FC_BASIC_PREM				 = new HtmlInputText();
		COMP_POL_LC_BASIC_PREM				 = new HtmlInputText();
		COMP_POL_FC_HEALTH_LOAD				 = new HtmlInputText();
		COMP_POL_LC_HEALTH_LOAD				 = new HtmlInputText();
		COMP_POL_FLEX_01				 = new HtmlInputText();
		COMP_UI_M_CONT_NAME				 = new HtmlInputText();
		COMP_POL_DEFER_PRD				 = new HtmlInputText();
		COMP_POL_EMPLOYER_CODE				 = new HtmlInputText();
		COMP_POL_SRC_OF_BUS				 = new HtmlInputText();
		COMP_UI_M_POL_SRC_OF_BUS_DESC			 = new HtmlInputText();
		COMP_POL_FC_ADDL_PREM				 = new HtmlInputText();
		COMP_POL_LC_ADDL_PREM				 = new HtmlInputText();
		COMP_POL_FC_TOT_SA				 = new HtmlInputText();
		COMP_POL_LC_TOT_SA				 = new HtmlInputText();
		COMP_UI_M_FC_DEATH_LOAD				 = new HtmlInputText();
		COMP_UI_M_LC_DEATH_LOAD				 = new HtmlInputText();
		COMP_POL_FLEX_02				 = new HtmlInputText();
		COMP_POL_SUB_PLAN_CODE				 = new HtmlInputText();
		COMP_POL_CONT_CODE				 = new HtmlInputText();
		COMP_POL_ASSURED_NAME				 = new HtmlInputText();
		COMP_UI_M_POL_FC_TOT_PREM			 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_PREM			 = new HtmlInputText();
		COMP_UI_M_POL_FC_PREM				 = new HtmlInputText();
		COMP_UI_M_POL_LC_PREM				 = new HtmlInputText();
		COMP_UI_M_FC_TPD_LOAD				 = new HtmlInputText();
		COMP_UI_M_LC_TPD_LOAD				 = new HtmlInputText();
		COMP_POL_FLEX_03				 = new HtmlInputText();
		COMP_POL_GRANTEE_NAME				 = new HtmlInputText();
		COMP_UI_M_POL_SUB_PLAN_CODE_DESC		 = new HtmlInputText();
		COMP_POL_PERIOD					 = new HtmlInputText();
		COMP_POL_PREM_PAY_YRS				 = new HtmlInputText();
		COMP_POL_FC_NETT_PREM				 = new HtmlInputText();
		COMP_POL_LC_NETT_PREM				 = new HtmlInputText();
		COMP_UI_M_POL_FC_TOT_LOADING			 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_LOADING			 = new HtmlInputText();
		COMP_UI_M_FC_MED_LOAD				 = new HtmlInputText();
		COMP_UI_M_LC_MED_LOAD				 = new HtmlInputText();
		COMP_POL_LC_TOP_UP_AMT				 = new HtmlInputText();
		COMP_POL_INTRODUCER_REF_ID1			 = new HtmlInputText();
		COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC		 = new HtmlInputText();
		COMP_POL_BANK_BRANCH_NAME			 = new HtmlInputText();
		COMP_UI_M_BRANCH_CODE_DESC			 = new HtmlInputText();
		COMP_POL_DIVN_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_FC_TOT_DISCOUNT			 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_DISCOUNT			 = new HtmlInputText();
		COMP_POL_FC_CURR_SA				 = new HtmlInputText();
		COMP_POL_LC_CURR_SA				 = new HtmlInputText();
		COMP_POL_FC_TOP_UP_AMT				 = new HtmlInputText();
		COMP_UI_M_FC_OCC_LOAD				 = new HtmlInputText();
		COMP_UI_M_LC_OCC_LOAD				 = new HtmlInputText();
		COMP_POL_BANK_REF_NO				 = new HtmlInputText();
		COMP_POL_SA_CURR_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_SA_CURR_DESC			 = new HtmlInputText();
		COMP_POL_SA_EXCH_RATE				 = new HtmlInputText();
		COMP_UI_M_POL_DIVN_DESC				 = new HtmlInputText();
		COMP_UI_M_FC_PCHARGES_BORNE_CUST		 = new HtmlInputText();
		COMP_UI_M_LC_PCHARGES_BORNE_CUST		 = new HtmlInputText();
		COMP_UI_M_FC_GROSS_CONT				 = new HtmlInputText();
		COMP_UI_M_LC_GROSS_CONT				 = new HtmlInputText();
		COMP_POL_LC_EXC_INT_AMT				 = new HtmlInputText();
		COMP_POL_CUST_CURR_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_CUST_CURR_DESC			 = new HtmlInputText();
		COMP_POL_CUST_EXCH_RATE				 = new HtmlInputText();
		COMP_POL_DEPT_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_FC_NET_PREM			 = new HtmlInputText();
		COMP_UI_M_POL_LC_NET_PREM			 = new HtmlInputText();
		COMP_UI_M_FC_BROK_COMM				 = new HtmlInputText();
		COMP_UI_M_LC_BROK_COMM				 = new HtmlInputText();
		COMP_POL_EXC_INT_PERC				 = new HtmlInputText();
		COMP_POL_STAFF_CCLASS_CODE			 = new HtmlInputText();
		COMP_UI_M_CCLAS_CLASS_DESC			 = new HtmlInputText();
		COMP_POL_FC_EXC_INT_AMT				 = new HtmlInputText();
		COMP_POL_FC_MODAL_PREM				 = new HtmlInputText();
		COMP_POL_NO_OF_UNIT				 = new HtmlInputText();
		COMP_POL_LC_MODAL_PREM				 = new HtmlInputText();
		COMP_UI_M_POL_DEPT_DESC				 = new HtmlInputText();
		COMP_UI_M_POL_MODE_OF_PYMT_RATE			 = new HtmlInputText();
		COMP_UI_M_POL_FC_MOP				 = new HtmlInputText();
		COMP_UI_M_POL_LC_MOP				 = new HtmlInputText();
		COMP_UI_M_FC_CHARGE				 = new HtmlInputText();
		COMP_UI_M_LC_CHARGE				 = new HtmlInputText();
		COMP_POL_RI_POOL_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_RI_POOL_CODE_DESC			 = new HtmlInputText();
		COMP_POL_LOAD_PERC				 = new HtmlInputText();
		COMP_POL_NO_OF_INST				 = new HtmlInputText();
		COMP_POL_MODE_OF_PYMT_RATE			 = new HtmlInputText();
		COMP_POL_CLASS_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_FC_GR_ANN_PREM			 = new HtmlInputText();
		COMP_UI_M_POL_LC_GR_ANN_PREM			 = new HtmlInputText();
		COMP_UI_M_FC_PCHARGES_BORNE_COMP		 = new HtmlInputText();
		COMP_UI_M_LC_PCHARGES_BORNE_COMP		 = new HtmlInputText();
		COMP_POL_FC_NET_PREM				 = new HtmlInputText();
		COMP_POL_LC_NET_PREM				 = new HtmlInputText();
		COMP_UI_M_FC_INST_PREM				 = new HtmlInputText();
		COMP_UI_M_LC_INST_PREM				 = new HtmlInputText();
		COMP_POL_CQS_PERC				 = new HtmlInputText();
		COMP_POL_CREDIT_DISCOUNT_PERC			 = new HtmlInputText();
		COMP_POL_FORM_NO				 = new HtmlInputText();
		COMP_POL_FC_SUM_ASSURED				 = new HtmlInputText();
		COMP_POL_LC_SUM_ASSURED				 = new HtmlInputText();
		COMP_UI_M_POL_CLASS_DESC			 = new HtmlInputText();
		COMP_UI_M_POL_INST_FC_PREM			 = new HtmlInputText();
		COMP_UI_M_POL_INST_LC_PREM			 = new HtmlInputText();
		COMP_POL_FC_BANK_ALLOC_AMT			 = new HtmlInputText();
		COMP_POL_LC_BANK_ALLOC_AMT			 = new HtmlInputText();
		COMP_UI_M_POL_CONT_AD_ACC_NO			 = new HtmlInputText();
		COMP_POL_PROP_REF_NO				 = new HtmlInputText();
		COMP_POL_AGENT_REF_CODE				 = new HtmlInputText();
		COMP_POL_FC_DEPOSIT_AMOUNT			 = new HtmlInputText();
		COMP_POL_LC_DEPOSIT_AMOUNT			 = new HtmlInputText();
		COMP_POL_LC_MIN_PREM				 = new HtmlInputText();
		COMP_POL_FC_DISC_AMT				 = new HtmlInputText();
		COMP_POL_LC_DISC_AMT				 = new HtmlInputText();
		COMP_POL_FC_CLIENT_ALLOC_AMT			 = new HtmlInputText();
		COMP_POL_LC_CLIENT_ALLOC_AMT			 = new HtmlInputText();
		COMP_POL_CONT_AD_BANK_CODE			 = new HtmlInputText();
		COMP_UI_M_BANK_CODE_DESC			 = new HtmlInputText();
		COMP_POL_REMARKS				 = new HtmlInputText();
		COMP_POL_FC_MIN_PREM				 = new HtmlInputText();
		COMP_UI_M_FC_SCHARGES_BORNE_CUST		 = new HtmlInputText();
		COMP_UI_M_LC_SCHARGES_BORNE_CUST		 = new HtmlInputText();
		COMP_UI_M_FC_SCHARGES_BORNE_COMP		 = new HtmlInputText();
		COMP_UI_M_LC_SCHARGES_BORNE_COMP		 = new HtmlInputText();
		COMP_POL_CARD_HOLDER_NAME			 = new HtmlInputText();
		COMP_POL_LC_EXTRA_PREM				 = new HtmlInputText();
		COMP_POL_FC_EXTRA_PREM				 = new HtmlInputText();
		COMP_POL_FC_MON_ANNU_AMT			 = new HtmlInputText();
		COMP_POL_LC_MON_ANNU_AMT			 = new HtmlInputText();
		COMP_POL_FC_FIRST_PREM				 = new HtmlInputText();
		COMP_POL_LC_FIRST_PREM				 = new HtmlInputText();
		COMP_POL_FC_PRE_TPD_BNF				 = new HtmlInputText();
		COMP_POL_LC_PRE_TPD_BNF				 = new HtmlInputText();
		COMP_POL_AUTH_LIMIT				 = new HtmlInputText();
		COMP_POL_NEW_FC_SA				= new HtmlInputText();
		COMP_POL_NEW_LC_SA				= new HtmlInputText();
		COMP_POL_ORG_NEW_FC_SA				= new HtmlInputText();
		COMP_POL_ORG_NEW_LC_SA				= new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_FORM_CAPTION				 = new HtmlOutputLabel();
		COMP_POL_CURR_SA_LIMIT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_CURR_SA_LABEL				 = new HtmlOutputLabel();
		COMP_PROP_LC_DEP_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_PROP_FC_DEP_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_DEF_PERIOD_FM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_DEF_PERIOD_TO_LABEL			 = new HtmlOutputLabel();
		COMP_POL_WAQAF_PERIOD_FM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_WAQAF_PERIOD_TO_LABEL			 = new HtmlOutputLabel();
		COMP_POL_END_CODE_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_POL_END_CODE_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POL_END_DT_LABEL				 = new HtmlOutputLabel();
		COMP_POL_MED_FEE_RECOVER_YN_LABEL		 = new HtmlOutputLabel();
		COMP_POL_END_NO_LABEL				 = new HtmlOutputLabel();
		COMP_POL_END_EFF_FROM_DT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_END_EFF_TO_DT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_END_DESC_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_PAY_PERIOD_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PAY_YEARS_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_SA_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_FC_SA_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_ADDL_STATUS_DESC			 = new HtmlOutputLabel();
		COMP_UI_M_APPRV_STATUS				 = new HtmlOutputLabel();
		COMP_UI_M_BUS_STATUS				 = new HtmlOutputLabel();
		COMP_UI_M_END_STATUS				 = new HtmlOutputLabel();
		COMP_UI_M_END_IDX_TYPE_NO			 = new HtmlOutputLabel();
		COMP_UI_M_AMEND_IDX				 = new HtmlOutputLabel();
		COMP_POL_PROD_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PROD_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_POL_PROD_GROUP_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_PROD_GROUP_CODE_LABEL		 = new HtmlOutputLabel();
		COMP_POL_PLAN_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_PLAN_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_ICON_HINT				 = new HtmlOutputLabel();
		COMP_UI_M_CLM_ADDL_STATUS			 = new HtmlOutputLabel();
		COMP_POL_ISSUE_DT_LABEL				 = new HtmlOutputLabel();
		COMP_POL_UW_YEAR_LABEL				 = new HtmlOutputLabel();
		COMP_POL_NO_YRS_PREM_PAID_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_CIC_STATUS				 = new HtmlOutputLabel();
		COMP_POL_JOINT_LIFE_YN_LABEL			 = new HtmlOutputLabel();
		COMP_POL_JOINT_LIFE_AGE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FRZ_FLAG_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_WAI_STATUS				 = new HtmlOutputLabel();
		COMP_POL_NO_LABEL				 = new HtmlOutputLabel();
		COMP_POL_CASH_YN_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_HOLD_STATUS				 = new HtmlOutputLabel();
		COMP_POL_ASSRD_REF_ID1_LABEL			 = new HtmlOutputLabel();
		COMP_POL_TRAN_DT_LABEL				 = new HtmlOutputLabel();
		COMP_POL_ASSRD_REF_ID2_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_MAT_AGE_LABEL				 = new HtmlOutputLabel();
		COMP_POL_APPRV_UID				 = new HtmlOutputLabel();
		COMP_UI_M_POL_CONVERT_YN			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_SA1_LABEL			 = new HtmlOutputLabel();
		COMP_POL_BASIC_RATE1_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_BASIC_PREM1_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_ADDL_PREM1_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_PREM1_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_LOADING1_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_NET_PREM1_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_MOP1_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_INST_LC_PREM1_LABEL		 = new HtmlOutputLabel();
		COMP_POL_LC_DISC_AMT1_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL		 = new HtmlOutputLabel();
		COMP_POL_LC_FIRST_PREM1_LABEL			 = new HtmlOutputLabel();
		COMP_POL_RES_ADDRESS_1_LABEL			 = new HtmlOutputLabel();
		COMP_POL_RES_ADDRESS_2_LABEL			 = new HtmlOutputLabel();
		COMP_POL_RES_ADDRESS_3_LABEL			 = new HtmlOutputLabel();
		COMP_POL_RES_AREA_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POL_CITY_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_CITY_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_POL_STATE_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_STATE_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_POL_COUNT_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_COUNT_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_POL_RES_PHONE_NO_LABEL			 = new HtmlOutputLabel();
		COMP_POL_MOBILE_NO_LABEL			 = new HtmlOutputLabel();
		COMP_POL_OFF_ADDRESS_1_LABEL			 = new HtmlOutputLabel();
		COMP_POL_OFF_ADDRESS_2_LABEL			 = new HtmlOutputLabel();
		COMP_POL_OFF_ADDRESS_3_LABEL			 = new HtmlOutputLabel();
		COMP_POL_OFF_AREA_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POSTAL_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_POL_OFF_PHONE_NO_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FAX_NO_LABEL				 = new HtmlOutputLabel();
		COMP_POL_FAX_AREA_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_PAYOR_TAB_LABEL				 = new HtmlOutputLabel();
		COMP_POL_MASTER_POL_NO_LABEL			 = new HtmlOutputLabel();
		COMP_POL_PROFIT_RATE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_MODE_OF_CALC_LABEL			 = new HtmlOutputLabel();
		COMP_POL_CREDIT_INT_RATE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_PROP_NO_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_SA_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_SA_LABEL			 = new HtmlOutputLabel();
		COMP_POL_OCC_RATE_LABEL				 = new HtmlOutputLabel();
		COMP_POL_HEALTH_RATE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_PROJECT_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PROJECT_CODE_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POL_DEVELOPER_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_DEVELOPER_CODE_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POL_PYMT_TYPE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_PAYOR_SDCODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PAYOR_CONT_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_POL_CUST_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_CUST_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_POL_BASIC_RATE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_BASIC_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_BASIC_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_HEALTH_LOAD_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_HEALTH_LOAD_LABEL			 = new HtmlOutputLabel();
		COMP_POL_HOME_OWNER_FLAG_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FLEX_01_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_CONT_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_POL_DEFER_PRD_LABEL			 = new HtmlOutputLabel();
		COMP_POL_EMPLOYER_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_SRC_OF_BUS_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POL_FC_ADDL_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_ADDL_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_TOT_SA_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_TOT_SA_LABEL			 = new HtmlOutputLabel();
		COMP_POL_PROP_RECV_DT_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FC_DEATH_LOAD_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_DEATH_LOAD_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FLEX_02_LABEL				 = new HtmlOutputLabel();
		COMP_POL_INCORPORATED_YN_LABEL			 = new HtmlOutputLabel();
		COMP_POL_SUB_PLAN_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_NET_PREM_YN_LABEL			 = new HtmlOutputLabel();
		COMP_POL_CONT_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_ASSURED_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_TOT_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_PROP_STAMP_DT_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FC_TPD_LOAD_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_TPD_LOAD_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FLEX_03_LABEL				 = new HtmlOutputLabel();
		COMP_POL_GRANTEE_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POL_GRANTEE_TYPE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_PERIOD_LABEL				 = new HtmlOutputLabel();
		COMP_POL_PREM_PAY_YRS_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_NETT_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_NETT_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_TOT_LOADING_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_LOADING_LABEL		 = new HtmlOutputLabel();
		COMP_POL_PROP_DECL_DT_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FC_MED_LOAD_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_MED_LOAD_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_TOP_UP_AMT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_INTRODUCER_REF_ID1_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC_LABEL	 = new HtmlOutputLabel();
		COMP_POL_BANK_BRANCH_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_BRANCH_CODE_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POL_START_DT_LABEL				 = new HtmlOutputLabel();
		COMP_POL_EXPIRY_DT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_DIVN_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL		 = new HtmlOutputLabel();
		COMP_POL_FC_CURR_SA_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_CURR_SA_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_TOP_UP_AMT_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FC_OCC_LOAD_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_OCC_LOAD_LABEL			 = new HtmlOutputLabel();
		COMP_POL_RATE_APPLIED_ON_LABEL			 = new HtmlOutputLabel();
		COMP_POL_BANK_REF_NO_LABEL			 = new HtmlOutputLabel();
		COMP_POL_SA_CURR_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_SA_CURR_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POL_SA_EXCH_RATE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_DIVN_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL		 = new HtmlOutputLabel();
		COMP_POL_ORG_PROP_RECV_YN_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FC_GROSS_CONT_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_GROSS_CONT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_EXC_INT_AMT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_NL_FM_DT_LABEL				 = new HtmlOutputLabel();
		COMP_POL_TARIFF_TERM_FLAG_LABEL			 = new HtmlOutputLabel();
		COMP_POL_CUST_CURR_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_CUST_CURR_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POL_CUST_EXCH_RATE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_DEPT_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_NET_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_NET_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FC_BROK_COMM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_BROK_COMM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_EXC_INT_PERC_LABEL			 = new HtmlOutputLabel();
		COMP_POL_STAFF_CCLASS_CODE_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_CCLAS_CLASS_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POL_STD_RISK_YN_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_EXC_INT_AMT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_MODAL_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_NO_OF_UNIT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_MODAL_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_DEPT_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_MOP_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_MOP_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FC_CHARGE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_CHARGE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_RI_POOL_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POL_CREDIT_YN_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LOAD_PERC_LABEL			 = new HtmlOutputLabel();
		COMP_POL_STAFF_YN_LABEL				 = new HtmlOutputLabel();
		COMP_POL_FAC_BASIS_LABEL			 = new HtmlOutputLabel();
		COMP_POL_MODE_OF_PYMT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_NO_OF_INST_LABEL			 = new HtmlOutputLabel();
		COMP_POL_MODE_OF_PYMT_RATE_LABEL		 = new HtmlOutputLabel();
		COMP_POL_CLASS_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_GR_ANN_PREM_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL		 = new HtmlOutputLabel();
		COMP_POL_FC_NET_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_NET_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FC_INST_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_INST_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_CQS_PERC_LABEL				 = new HtmlOutputLabel();
		COMP_POL_CREDIT_DISCOUNT_PERC_LABEL		 = new HtmlOutputLabel();
		COMP_POL_FAC_YN_LABEL				 = new HtmlOutputLabel();
		COMP_POL_FORM_NO_LABEL				 = new HtmlOutputLabel();
		COMP_POL_FC_SUM_ASSURED_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_SUM_ASSURED_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_CLASS_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_INST_FC_PREM_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_INST_LC_PREM_LABEL		 = new HtmlOutputLabel();
		COMP_POL_FC_BANK_ALLOC_AMT_LABEL		 = new HtmlOutputLabel();
		COMP_POL_LC_BANK_ALLOC_AMT_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_CONT_AD_ACC_NO_LABEL		 = new HtmlOutputLabel();
		COMP_POL_PROP_REF_NO_LABEL			 = new HtmlOutputLabel();
		COMP_POL_AGENT_REF_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_CQS_YN_LABEL				 = new HtmlOutputLabel();
		COMP_POL_FC_DEPOSIT_AMOUNT_LABEL		 = new HtmlOutputLabel();
		COMP_POL_LC_DEPOSIT_AMOUNT_LABEL		 = new HtmlOutputLabel();
		COMP_POL_LC_MIN_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_DISC_AMT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_DISC_AMT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_CLIENT_ALLOC_AMT_LABEL		 = new HtmlOutputLabel();
		COMP_POL_LC_CLIENT_ALLOC_AMT_LABEL		 = new HtmlOutputLabel();
		COMP_POL_CONT_AD_BANK_CODE_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_BANK_CODE_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FIRST_INST_DT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LAST_INST_DT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_REMARKS_LABEL				 = new HtmlOutputLabel();
		COMP_POL_FC_MIN_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL		 = new HtmlOutputLabel();
		COMP_POL_CARD_HOLDER_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_POL_DEF_IMM_FLAG_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_EXTRA_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_EXTRA_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_MON_ANNU_AMT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_MON_ANNU_AMT_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_FIRST_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_FIRST_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_PRE_TPD_BNF_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_PRE_TPD_BNF_LABEL			 = new HtmlOutputLabel();
		COMP_POL_AUTH_LIMIT_LABEL			 = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_POL_MED_FEE_RECOVER_YN			 = new HtmlSelectOneMenu();
		COMP_POL_JOINT_LIFE_YN				 = new HtmlSelectOneMenu();
		COMP_POL_FRZ_FLAG				 = new HtmlSelectOneMenu();
		COMP_POL_CASH_YN				 = new HtmlSelectOneMenu();
		COMP_POL_MODE_OF_CALC				 = new HtmlSelectOneMenu();
		COMP_POL_PYMT_TYPE				 = new HtmlSelectOneMenu();
		COMP_POL_HOME_OWNER_FLAG			 = new HtmlSelectOneMenu();
		COMP_POL_INCORPORATED_YN			 = new HtmlSelectOneMenu();
		COMP_POL_NET_PREM_YN				 = new HtmlSelectOneMenu();
		COMP_POL_GRANTEE_TYPE				 = new HtmlSelectOneMenu();
		COMP_POL_RATE_APPLIED_ON			 = new HtmlSelectOneMenu();
		COMP_POL_ORG_PROP_RECV_YN			 = new HtmlSelectOneMenu();
		COMP_POL_TARIFF_TERM_FLAG			 = new HtmlSelectOneMenu();
		COMP_POL_STD_RISK_YN				 = new HtmlSelectOneMenu();
		COMP_POL_CREDIT_YN				 = new HtmlSelectOneMenu();
		COMP_POL_STAFF_YN				 = new HtmlSelectOneMenu();
		COMP_POL_FAC_BASIS				 = new HtmlSelectOneMenu();
		COMP_POL_MODE_OF_PYMT				 = new HtmlSelectOneMenu();
		COMP_POL_FAC_YN					 = new HtmlSelectOneMenu();
		COMP_POL_CQS_YN					 = new HtmlSelectOneMenu();
		COMP_POL_DEF_IMM_FLAG				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_POL_END_DT					 = new HtmlCalendar();
		COMP_POL_END_EFF_FROM_DT			 = new HtmlCalendar();
		COMP_POL_END_EFF_TO_DT				 = new HtmlCalendar();
		COMP_POL_ISSUE_DT				 = new HtmlCalendar();
		COMP_POL_TRAN_DT				 = new HtmlCalendar();
		COMP_POL_PROP_RECV_DT				 = new HtmlCalendar();
		COMP_POL_PROP_STAMP_DT				 = new HtmlCalendar();
		COMP_POL_PROP_DECL_DT				 = new HtmlCalendar();
		COMP_POL_START_DT				 = new HtmlCalendar();
		COMP_POL_EXPIRY_DT				 = new HtmlCalendar();
		COMP_POL_NL_FM_DT				 = new HtmlCalendar();
		COMP_POL_FIRST_INST_DT				 = new HtmlCalendar();
		COMP_POL_LAST_INST_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		//COMP_UI_M_BUS_RUL				 = new HtmlCommandButton();
		COMP_UI_M_BUT_CC_LOV				 = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_GRP_CODE			 = new HtmlCommandButton();
		COMP_UI_M_BUT_COPY				 = new HtmlCommandButton();
		COMP_UI_M_BUT_FUND_QUERY			 = new HtmlCommandButton();
		COMP_UI_M_BUT_HOLD				 = new HtmlCommandButton();
		COMP_UI_M_BUT_UDDATE_STAT			 = new HtmlCommandButton();
		COMP_UI_M_BUT_UPI				 = new HtmlCommandButton();
		COMP_UI_M_BUT_CALC_DISC_LOAD			 = new HtmlCommandButton();
		COMP_UI_M_BUT_SURR_MAT				 = new HtmlCommandButton();
		//COMP_UI_M_BUT_ENDT				 = new HtmlCommandButton();
		COMP_UI_M_BUT_ENDT_OK				 = new HtmlCommandButton();
		COMP_UI_M_BUT_ENDT_CANCEL			 = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVAL				 = new HtmlCommandButton();
		COMP_UI_M_BUT_PRMDTLS				 = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_PLAN				 = new HtmlCommandButton();
		COMP_UI_M_BUT_DOC_GEN_NO			 = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_PROD_CODE			 = new HtmlCommandButton();
		COMP_UI_M_BUT_CONVERT				 = new HtmlCommandButton();
		COMP_UI_M_BUT_POL_AMDT				 = new HtmlCommandButton();
		COMP_UI_M_BUT_UPLOAD				 = new HtmlCommandButton();
		COMP_UI_M_BUT_CLAIM				 = new HtmlCommandButton();
		COMP_UI_M_BUT_FUND_DTL				 = new HtmlCommandButton();

	}


    
    public void setListItemValues() {
	Connection connection = null;
	try {
	    connection = CommonUtils.getConnection();
	    
	    setListPOL_JOINT_LIFE_YN(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_JOINT_LIFE_YN", "YESNO"));
	    
	    setListPOL_MED_FEE_RECOVER_YN(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_MED_FEE_RECOVER_YN", "YESNO"));
	    
	    setListPOL_FRZ_FLAG(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_FRZ_FLAG", "YESNO"));
	    
	    setListPOL_CASH_YN(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_CASH_YN", "YESNO"));
	    
	    setListPOL_MODE_OF_CALC(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_MODE_OF_CALC", "IL_MODE_CALC"));
	    
	    setListPOL_PYMT_TYPE(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_PYMT_TYPE", "IL_PAY_MODE"));
	    
	    setListPOL_HOME_OWNER_FLAG(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_HOME_OWNER_FLAG", "YESNO"));
	    
	    setListPOL_INCORPORATED_YN(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_INCORPORATED_YN", "YESNO"));
	    
	    setListPOL_NET_PREM_YN(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_NET_PREM_YN", "YESNO"));
	    
	    setListPOL_GRANTEE_TYPE(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_GRANTEE_TYPE", "IL_GRNT_TYPE"));
	    
	    setListPOL_RATE_APPLIED_ON(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_RATE_APPLIED_ON", "IL_RATE_APPL"));
	    
	    setListPOL_ORG_PROP_RECV_YN(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_ORG_PROP_RECV_YN", "YESNO"));
	    
	    setListPOL_TARIFF_TERM_FLAG(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_TARIFF_TERM_FLAG", "IL_TAR_TERM"));
	    
	    setListPOL_STD_RISK_YN(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_STD_RISK_YN", "YESNO"));
	    
	    setListPOL_CREDIT_YN(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_CREDIT_YN", "YESNO"));
	    
	    setListPOL_STAFF_YN(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_STAFF_YN", "YESNO"));
	    
	    setListPOL_FAC_BASIS(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_FAC_BASIS", "IL_FAC_BASIS"));
	    
	    setListPOL_MODE_OF_PYMT(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_MODE_OF_PYMT", "PAYMODE"));
	    
	    setListPOL_FAC_YN(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_FAC_YN", "YESNO"));
	    
	    setListPOL_CQS_YN(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_CQS_YN", "YESNO"));
	    
	    setListPOL_DEF_IMM_FLAG(ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "PT_IL_POLICY",
		    "PT_IL_POLICY.POL_DEF_IMM_FLAG", "IL_ANNU_PER"));
	    
	    
	} catch (Exception e) {
	    e.printStackTrace();
	    // TODO: handle exception
	}
    }

    public HtmlOutputLabel getCOMP_POL_DEF_PERIOD_FM_LABEL() {
	return COMP_POL_DEF_PERIOD_FM_LABEL;
    }

    public HtmlInputText getCOMP_POL_DEF_PERIOD_FM() {
	return COMP_POL_DEF_PERIOD_FM;
    }

    public void setCOMP_POL_DEF_PERIOD_FM_LABEL(
	    HtmlOutputLabel COMP_POL_DEF_PERIOD_FM_LABEL) {
	this.COMP_POL_DEF_PERIOD_FM_LABEL = COMP_POL_DEF_PERIOD_FM_LABEL;
    }

    public void setCOMP_POL_DEF_PERIOD_FM(HtmlInputText COMP_POL_DEF_PERIOD_FM) {
	this.COMP_POL_DEF_PERIOD_FM = COMP_POL_DEF_PERIOD_FM;
    }

    public HtmlOutputLabel getCOMP_POL_DEF_PERIOD_TO_LABEL() {
	return COMP_POL_DEF_PERIOD_TO_LABEL;
    }

    public HtmlInputText getCOMP_POL_DEF_PERIOD_TO() {
	return COMP_POL_DEF_PERIOD_TO;
    }

    public void setCOMP_POL_DEF_PERIOD_TO_LABEL(
	    HtmlOutputLabel COMP_POL_DEF_PERIOD_TO_LABEL) {
	this.COMP_POL_DEF_PERIOD_TO_LABEL = COMP_POL_DEF_PERIOD_TO_LABEL;
    }

    public void setCOMP_POL_DEF_PERIOD_TO(HtmlInputText COMP_POL_DEF_PERIOD_TO) {
	this.COMP_POL_DEF_PERIOD_TO = COMP_POL_DEF_PERIOD_TO;
    }

    public HtmlOutputLabel getCOMP_POL_WAQAF_PERIOD_FM_LABEL() {
	return COMP_POL_WAQAF_PERIOD_FM_LABEL;
    }

    public HtmlInputText getCOMP_POL_WAQAF_PERIOD_FM() {
	return COMP_POL_WAQAF_PERIOD_FM;
    }

    public void setCOMP_POL_WAQAF_PERIOD_FM_LABEL(
	    HtmlOutputLabel COMP_POL_WAQAF_PERIOD_FM_LABEL) {
	this.COMP_POL_WAQAF_PERIOD_FM_LABEL = COMP_POL_WAQAF_PERIOD_FM_LABEL;
    }

    public void setCOMP_POL_WAQAF_PERIOD_FM(
	    HtmlInputText COMP_POL_WAQAF_PERIOD_FM) {
	this.COMP_POL_WAQAF_PERIOD_FM = COMP_POL_WAQAF_PERIOD_FM;
    }

    public HtmlOutputLabel getCOMP_POL_WAQAF_PERIOD_TO_LABEL() {
	return COMP_POL_WAQAF_PERIOD_TO_LABEL;
    }

    public HtmlInputText getCOMP_POL_WAQAF_PERIOD_TO() {
	return COMP_POL_WAQAF_PERIOD_TO;
    }

    public void setCOMP_POL_WAQAF_PERIOD_TO_LABEL(
	    HtmlOutputLabel COMP_POL_WAQAF_PERIOD_TO_LABEL) {
	this.COMP_POL_WAQAF_PERIOD_TO_LABEL = COMP_POL_WAQAF_PERIOD_TO_LABEL;
    }

    public void setCOMP_POL_WAQAF_PERIOD_TO(
	    HtmlInputText COMP_POL_WAQAF_PERIOD_TO) {
	this.COMP_POL_WAQAF_PERIOD_TO = COMP_POL_WAQAF_PERIOD_TO;
    }

    public HtmlOutputLabel getCOMP_POL_END_CODE_LABEL() {
	return COMP_POL_END_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_END_CODE() {
	return COMP_POL_END_CODE;
    }

    public void setCOMP_POL_END_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_END_CODE_LABEL) {
	this.COMP_POL_END_CODE_LABEL = COMP_POL_END_CODE_LABEL;
    }

    public void setCOMP_POL_END_CODE(HtmlInputText COMP_POL_END_CODE) {
	this.COMP_POL_END_CODE = COMP_POL_END_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_END_CODE_DESC_LABEL() {
	return COMP_UI_M_POL_END_CODE_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_END_CODE_DESC() {
	return COMP_UI_M_POL_END_CODE_DESC;
    }

    public void setCOMP_UI_M_POL_END_CODE_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_END_CODE_DESC_LABEL) {
	this.COMP_UI_M_POL_END_CODE_DESC_LABEL = COMP_UI_M_POL_END_CODE_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_END_CODE_DESC(
	    HtmlInputText COMP_UI_M_POL_END_CODE_DESC) {
	this.COMP_UI_M_POL_END_CODE_DESC = COMP_UI_M_POL_END_CODE_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_END_DT_LABEL() {
	return COMP_POL_END_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_END_DT() {
	return COMP_POL_END_DT;
    }

    public void setCOMP_POL_END_DT_LABEL(HtmlOutputLabel COMP_POL_END_DT_LABEL) {
	this.COMP_POL_END_DT_LABEL = COMP_POL_END_DT_LABEL;
    }

    public void setCOMP_POL_END_DT(HtmlCalendar COMP_POL_END_DT) {
	this.COMP_POL_END_DT = COMP_POL_END_DT;
    }

    public HtmlOutputLabel getCOMP_POL_MED_FEE_RECOVER_YN_LABEL() {
	return COMP_POL_MED_FEE_RECOVER_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_MED_FEE_RECOVER_YN() {
	return COMP_POL_MED_FEE_RECOVER_YN;
    }

    public void setCOMP_POL_MED_FEE_RECOVER_YN_LABEL(
	    HtmlOutputLabel COMP_POL_MED_FEE_RECOVER_YN_LABEL) {
	this.COMP_POL_MED_FEE_RECOVER_YN_LABEL = COMP_POL_MED_FEE_RECOVER_YN_LABEL;
    }

    public void setCOMP_POL_MED_FEE_RECOVER_YN(
	    HtmlSelectOneMenu COMP_POL_MED_FEE_RECOVER_YN) {
	this.COMP_POL_MED_FEE_RECOVER_YN = COMP_POL_MED_FEE_RECOVER_YN;
    }

    public HtmlOutputLabel getCOMP_POL_END_NO_LABEL() {
	return COMP_POL_END_NO_LABEL;
    }

    public HtmlInputText getCOMP_POL_END_NO() {
	return COMP_POL_END_NO;
    }

    public void setCOMP_POL_END_NO_LABEL(HtmlOutputLabel COMP_POL_END_NO_LABEL) {
	this.COMP_POL_END_NO_LABEL = COMP_POL_END_NO_LABEL;
    }

    public void setCOMP_POL_END_NO(HtmlInputText COMP_POL_END_NO) {
	this.COMP_POL_END_NO = COMP_POL_END_NO;
    }

    public HtmlOutputLabel getCOMP_POL_END_EFF_FROM_DT_LABEL() {
	return COMP_POL_END_EFF_FROM_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_END_EFF_FROM_DT() {
	return COMP_POL_END_EFF_FROM_DT;
    }

    public void setCOMP_POL_END_EFF_FROM_DT_LABEL(
	    HtmlOutputLabel COMP_POL_END_EFF_FROM_DT_LABEL) {
	this.COMP_POL_END_EFF_FROM_DT_LABEL = COMP_POL_END_EFF_FROM_DT_LABEL;
    }

    public void setCOMP_POL_END_EFF_FROM_DT(
	    HtmlCalendar COMP_POL_END_EFF_FROM_DT) {
	this.COMP_POL_END_EFF_FROM_DT = COMP_POL_END_EFF_FROM_DT;
    }

    public HtmlOutputLabel getCOMP_POL_END_EFF_TO_DT_LABEL() {
	return COMP_POL_END_EFF_TO_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_END_EFF_TO_DT() {
	return COMP_POL_END_EFF_TO_DT;
    }

    public void setCOMP_POL_END_EFF_TO_DT_LABEL(
	    HtmlOutputLabel COMP_POL_END_EFF_TO_DT_LABEL) {
	this.COMP_POL_END_EFF_TO_DT_LABEL = COMP_POL_END_EFF_TO_DT_LABEL;
    }

    public void setCOMP_POL_END_EFF_TO_DT(HtmlCalendar COMP_POL_END_EFF_TO_DT) {
	this.COMP_POL_END_EFF_TO_DT = COMP_POL_END_EFF_TO_DT;
    }

    public HtmlOutputLabel getCOMP_POL_END_DESC_LABEL() {
	return COMP_POL_END_DESC_LABEL;
    }

    public HtmlInputText getCOMP_POL_END_DESC() {
	return COMP_POL_END_DESC;
    }

    public void setCOMP_POL_END_DESC_LABEL(
	    HtmlOutputLabel COMP_POL_END_DESC_LABEL) {
	this.COMP_POL_END_DESC_LABEL = COMP_POL_END_DESC_LABEL;
    }

    public void setCOMP_POL_END_DESC(HtmlInputText COMP_POL_END_DESC) {
	this.COMP_POL_END_DESC = COMP_POL_END_DESC;
    }

    public HtmlOutputLabel getCOMP_UI_M_PAY_PERIOD_LABEL() {
	return COMP_UI_M_PAY_PERIOD_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PAY_PERIOD() {
	return COMP_UI_M_PAY_PERIOD;
    }

    public void setCOMP_UI_M_PAY_PERIOD_LABEL(
	    HtmlOutputLabel COMP_UI_M_PAY_PERIOD_LABEL) {
	this.COMP_UI_M_PAY_PERIOD_LABEL = COMP_UI_M_PAY_PERIOD_LABEL;
    }

    public void setCOMP_UI_M_PAY_PERIOD(HtmlInputText COMP_UI_M_PAY_PERIOD) {
	this.COMP_UI_M_PAY_PERIOD = COMP_UI_M_PAY_PERIOD;
    }

    public HtmlOutputLabel getCOMP_UI_M_PAY_YEARS_LABEL() {
	return COMP_UI_M_PAY_YEARS_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PAY_YEARS() {
	return COMP_UI_M_PAY_YEARS;
    }

    public void setCOMP_UI_M_PAY_YEARS_LABEL(
	    HtmlOutputLabel COMP_UI_M_PAY_YEARS_LABEL) {
	this.COMP_UI_M_PAY_YEARS_LABEL = COMP_UI_M_PAY_YEARS_LABEL;
    }

    public void setCOMP_UI_M_PAY_YEARS(HtmlInputText COMP_UI_M_PAY_YEARS) {
	this.COMP_UI_M_PAY_YEARS = COMP_UI_M_PAY_YEARS;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_SA_LABEL() {
	return COMP_UI_M_LC_SA_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_SA() {
	return COMP_UI_M_LC_SA;
    }

    public void setCOMP_UI_M_LC_SA_LABEL(HtmlOutputLabel COMP_UI_M_LC_SA_LABEL) {
	this.COMP_UI_M_LC_SA_LABEL = COMP_UI_M_LC_SA_LABEL;
    }

    public void setCOMP_UI_M_LC_SA(HtmlInputText COMP_UI_M_LC_SA) {
	this.COMP_UI_M_LC_SA = COMP_UI_M_LC_SA;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_SA_LABEL() {
	return COMP_UI_M_FC_SA_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_SA() {
	return COMP_UI_M_FC_SA;
    }

    public void setCOMP_UI_M_FC_SA_LABEL(HtmlOutputLabel COMP_UI_M_FC_SA_LABEL) {
	this.COMP_UI_M_FC_SA_LABEL = COMP_UI_M_FC_SA_LABEL;
    }

    public void setCOMP_UI_M_FC_SA(HtmlInputText COMP_UI_M_FC_SA) {
	this.COMP_UI_M_FC_SA = COMP_UI_M_FC_SA;
    }

    public HtmlOutputLabel getCOMP_UI_M_ADDL_STATUS_DESC() {
	return COMP_UI_M_ADDL_STATUS_DESC;
    }

    public void setCOMP_UI_M_ADDL_STATUS_DESC(
	    HtmlOutputLabel COMP_UI_M_ADDL_STATUS_DESC) {
	this.COMP_UI_M_ADDL_STATUS_DESC = COMP_UI_M_ADDL_STATUS_DESC;
    }

    public HtmlOutputLabel getCOMP_UI_M_APPRV_STATUS() {
	return COMP_UI_M_APPRV_STATUS;
    }

    public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputLabel COMP_UI_M_APPRV_STATUS) {
	this.COMP_UI_M_APPRV_STATUS = COMP_UI_M_APPRV_STATUS;
    }

    public HtmlOutputLabel getCOMP_UI_M_BUS_STATUS() {
	return COMP_UI_M_BUS_STATUS;
    }

    public void setCOMP_UI_M_BUS_STATUS(HtmlOutputLabel COMP_UI_M_BUS_STATUS) {
	this.COMP_UI_M_BUS_STATUS = COMP_UI_M_BUS_STATUS;
    }

    public HtmlOutputLabel getCOMP_UI_M_END_STATUS() {
	return COMP_UI_M_END_STATUS;
    }

    public void setCOMP_UI_M_END_STATUS(HtmlOutputLabel COMP_UI_M_END_STATUS) {
	this.COMP_UI_M_END_STATUS = COMP_UI_M_END_STATUS;
    }

    public HtmlOutputLabel getCOMP_UI_M_END_IDX_TYPE_NO() {
	return COMP_UI_M_END_IDX_TYPE_NO;
    }

    public void setCOMP_UI_M_END_IDX_TYPE_NO(
	    HtmlOutputLabel COMP_UI_M_END_IDX_TYPE_NO) {
	this.COMP_UI_M_END_IDX_TYPE_NO = COMP_UI_M_END_IDX_TYPE_NO;
    }

    public HtmlOutputLabel getCOMP_UI_M_AMEND_IDX() {
	return COMP_UI_M_AMEND_IDX;
    }

    public void setCOMP_UI_M_AMEND_IDX(HtmlOutputLabel COMP_UI_M_AMEND_IDX) {
	this.COMP_UI_M_AMEND_IDX = COMP_UI_M_AMEND_IDX;
    }

    public HtmlOutputLabel getCOMP_POL_PROD_CODE_LABEL() {
	return COMP_POL_PROD_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_PROD_CODE() {
	return COMP_POL_PROD_CODE;
    }

    public void setCOMP_POL_PROD_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_PROD_CODE_LABEL) {
	this.COMP_POL_PROD_CODE_LABEL = COMP_POL_PROD_CODE_LABEL;
    }

    public void setCOMP_POL_PROD_CODE(HtmlInputText COMP_POL_PROD_CODE) {
	this.COMP_POL_PROD_CODE = COMP_POL_PROD_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_PROD_DESC_LABEL() {
	return COMP_UI_M_PROD_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PROD_DESC() {
	return COMP_UI_M_PROD_DESC;
    }

    public void setCOMP_UI_M_PROD_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_PROD_DESC_LABEL) {
	this.COMP_UI_M_PROD_DESC_LABEL = COMP_UI_M_PROD_DESC_LABEL;
    }

    public void setCOMP_UI_M_PROD_DESC(HtmlInputText COMP_UI_M_PROD_DESC) {
	this.COMP_UI_M_PROD_DESC = COMP_UI_M_PROD_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_PLAN_CODE_LABEL() {
	return COMP_POL_PLAN_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_PLAN_CODE() {
	return COMP_POL_PLAN_CODE;
    }

    public void setCOMP_POL_PLAN_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_PLAN_CODE_LABEL) {
	this.COMP_POL_PLAN_CODE_LABEL = COMP_POL_PLAN_CODE_LABEL;
    }

    public void setCOMP_POL_PLAN_CODE(HtmlInputText COMP_POL_PLAN_CODE) {
	this.COMP_POL_PLAN_CODE = COMP_POL_PLAN_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_PLAN_DESC_LABEL() {
	return COMP_UI_M_POL_PLAN_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_PLAN_DESC() {
	return COMP_UI_M_POL_PLAN_DESC;
    }

    public void setCOMP_UI_M_POL_PLAN_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_PLAN_DESC_LABEL) {
	this.COMP_UI_M_POL_PLAN_DESC_LABEL = COMP_UI_M_POL_PLAN_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_PLAN_DESC(HtmlInputText COMP_UI_M_POL_PLAN_DESC) {
	this.COMP_UI_M_POL_PLAN_DESC = COMP_UI_M_POL_PLAN_DESC;
    }

    public HtmlOutputLabel getCOMP_UI_M_ICON_HINT() {
	return COMP_UI_M_ICON_HINT;
    }

    public void setCOMP_UI_M_ICON_HINT(HtmlOutputLabel COMP_UI_M_ICON_HINT) {
	this.COMP_UI_M_ICON_HINT = COMP_UI_M_ICON_HINT;
    }

    public HtmlOutputLabel getCOMP_UI_M_CLM_ADDL_STATUS() {
	return COMP_UI_M_CLM_ADDL_STATUS;
    }

    public void setCOMP_UI_M_CLM_ADDL_STATUS(
	    HtmlOutputLabel COMP_UI_M_CLM_ADDL_STATUS) {
	this.COMP_UI_M_CLM_ADDL_STATUS = COMP_UI_M_CLM_ADDL_STATUS;
    }

    public HtmlOutputLabel getCOMP_POL_ISSUE_DT_LABEL() {
	return COMP_POL_ISSUE_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_ISSUE_DT() {
	return COMP_POL_ISSUE_DT;
    }

    public void setCOMP_POL_ISSUE_DT_LABEL(
	    HtmlOutputLabel COMP_POL_ISSUE_DT_LABEL) {
	this.COMP_POL_ISSUE_DT_LABEL = COMP_POL_ISSUE_DT_LABEL;
    }

    public void setCOMP_POL_ISSUE_DT(HtmlCalendar COMP_POL_ISSUE_DT) {
	this.COMP_POL_ISSUE_DT = COMP_POL_ISSUE_DT;
    }

    public HtmlOutputLabel getCOMP_POL_UW_YEAR_LABEL() {
	return COMP_POL_UW_YEAR_LABEL;
    }

    public HtmlInputText getCOMP_POL_UW_YEAR() {
	return COMP_POL_UW_YEAR;
    }

    public void setCOMP_POL_UW_YEAR_LABEL(HtmlOutputLabel COMP_POL_UW_YEAR_LABEL) {
	this.COMP_POL_UW_YEAR_LABEL = COMP_POL_UW_YEAR_LABEL;
    }

    public void setCOMP_POL_UW_YEAR(HtmlInputText COMP_POL_UW_YEAR) {
	this.COMP_POL_UW_YEAR = COMP_POL_UW_YEAR;
    }

    public HtmlOutputLabel getCOMP_POL_NO_YRS_PREM_PAID_LABEL() {
	return COMP_POL_NO_YRS_PREM_PAID_LABEL;
    }

    public HtmlInputText getCOMP_POL_NO_YRS_PREM_PAID() {
	return COMP_POL_NO_YRS_PREM_PAID;
    }

    public void setCOMP_POL_NO_YRS_PREM_PAID_LABEL(
	    HtmlOutputLabel COMP_POL_NO_YRS_PREM_PAID_LABEL) {
	this.COMP_POL_NO_YRS_PREM_PAID_LABEL = COMP_POL_NO_YRS_PREM_PAID_LABEL;
    }

    public void setCOMP_POL_NO_YRS_PREM_PAID(
	    HtmlInputText COMP_POL_NO_YRS_PREM_PAID) {
	this.COMP_POL_NO_YRS_PREM_PAID = COMP_POL_NO_YRS_PREM_PAID;
    }

    public HtmlOutputLabel getCOMP_UI_M_CIC_STATUS() {
	return COMP_UI_M_CIC_STATUS;
    }

    public void setCOMP_UI_M_CIC_STATUS(HtmlOutputLabel COMP_UI_M_CIC_STATUS) {
	this.COMP_UI_M_CIC_STATUS = COMP_UI_M_CIC_STATUS;
    }

    public HtmlOutputLabel getCOMP_POL_JOINT_LIFE_YN_LABEL() {
	return COMP_POL_JOINT_LIFE_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_JOINT_LIFE_YN() {
	return COMP_POL_JOINT_LIFE_YN;
    }

    public void setCOMP_POL_JOINT_LIFE_YN_LABEL(
	    HtmlOutputLabel COMP_POL_JOINT_LIFE_YN_LABEL) {
	this.COMP_POL_JOINT_LIFE_YN_LABEL = COMP_POL_JOINT_LIFE_YN_LABEL;
    }

    public void setCOMP_POL_JOINT_LIFE_YN(
	    HtmlSelectOneMenu COMP_POL_JOINT_LIFE_YN) {
	this.COMP_POL_JOINT_LIFE_YN = COMP_POL_JOINT_LIFE_YN;
    }

    public HtmlOutputLabel getCOMP_POL_JOINT_LIFE_AGE_LABEL() {
	return COMP_POL_JOINT_LIFE_AGE_LABEL;
    }

    public HtmlInputText getCOMP_POL_JOINT_LIFE_AGE() {
	return COMP_POL_JOINT_LIFE_AGE;
    }

    public void setCOMP_POL_JOINT_LIFE_AGE_LABEL(
	    HtmlOutputLabel COMP_POL_JOINT_LIFE_AGE_LABEL) {
	this.COMP_POL_JOINT_LIFE_AGE_LABEL = COMP_POL_JOINT_LIFE_AGE_LABEL;
    }

    public void setCOMP_POL_JOINT_LIFE_AGE(HtmlInputText COMP_POL_JOINT_LIFE_AGE) {
	this.COMP_POL_JOINT_LIFE_AGE = COMP_POL_JOINT_LIFE_AGE;
    }

    public HtmlOutputLabel getCOMP_POL_FRZ_FLAG_LABEL() {
	return COMP_POL_FRZ_FLAG_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_FRZ_FLAG() {
	return COMP_POL_FRZ_FLAG;
    }

    public void setCOMP_POL_FRZ_FLAG_LABEL(
	    HtmlOutputLabel COMP_POL_FRZ_FLAG_LABEL) {
	this.COMP_POL_FRZ_FLAG_LABEL = COMP_POL_FRZ_FLAG_LABEL;
    }

    public void setCOMP_POL_FRZ_FLAG(HtmlSelectOneMenu COMP_POL_FRZ_FLAG) {
	this.COMP_POL_FRZ_FLAG = COMP_POL_FRZ_FLAG;
    }

    public HtmlOutputLabel getCOMP_UI_M_WAI_STATUS() {
	return COMP_UI_M_WAI_STATUS;
    }

    public void setCOMP_UI_M_WAI_STATUS(HtmlOutputLabel COMP_UI_M_WAI_STATUS) {
	this.COMP_UI_M_WAI_STATUS = COMP_UI_M_WAI_STATUS;
    }

    public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
	return COMP_POL_NO_LABEL;
    }

    public HtmlInputText getCOMP_POL_NO() {
	return COMP_POL_NO;
    }

    public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
	this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
    }

    public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
	this.COMP_POL_NO = COMP_POL_NO;
    }

    public HtmlOutputLabel getCOMP_POL_CASH_YN_LABEL() {
	return COMP_POL_CASH_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_CASH_YN() {
	return COMP_POL_CASH_YN;
    }

    public void setCOMP_POL_CASH_YN_LABEL(HtmlOutputLabel COMP_POL_CASH_YN_LABEL) {
	this.COMP_POL_CASH_YN_LABEL = COMP_POL_CASH_YN_LABEL;
    }

    public void setCOMP_POL_CASH_YN(HtmlSelectOneMenu COMP_POL_CASH_YN) {
	this.COMP_POL_CASH_YN = COMP_POL_CASH_YN;
    }

    public HtmlOutputLabel getCOMP_UI_M_HOLD_STATUS() {
	return COMP_UI_M_HOLD_STATUS;
    }

    public void setCOMP_UI_M_HOLD_STATUS(HtmlOutputLabel COMP_UI_M_HOLD_STATUS) {
	this.COMP_UI_M_HOLD_STATUS = COMP_UI_M_HOLD_STATUS;
    }

    public HtmlOutputLabel getCOMP_POL_ASSRD_REF_ID1_LABEL() {
	return COMP_POL_ASSRD_REF_ID1_LABEL;
    }

    public HtmlInputText getCOMP_POL_ASSRD_REF_ID1() {
	return COMP_POL_ASSRD_REF_ID1;
    }

    public void setCOMP_POL_ASSRD_REF_ID1_LABEL(
	    HtmlOutputLabel COMP_POL_ASSRD_REF_ID1_LABEL) {
	this.COMP_POL_ASSRD_REF_ID1_LABEL = COMP_POL_ASSRD_REF_ID1_LABEL;
    }

    public void setCOMP_POL_ASSRD_REF_ID1(HtmlInputText COMP_POL_ASSRD_REF_ID1) {
	this.COMP_POL_ASSRD_REF_ID1 = COMP_POL_ASSRD_REF_ID1;
    }

    public HtmlOutputLabel getCOMP_POL_TRAN_DT_LABEL() {
	return COMP_POL_TRAN_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_TRAN_DT() {
	return COMP_POL_TRAN_DT;
    }

    public void setCOMP_POL_TRAN_DT_LABEL(HtmlOutputLabel COMP_POL_TRAN_DT_LABEL) {
	this.COMP_POL_TRAN_DT_LABEL = COMP_POL_TRAN_DT_LABEL;
    }

    public void setCOMP_POL_TRAN_DT(HtmlCalendar COMP_POL_TRAN_DT) {
	this.COMP_POL_TRAN_DT = COMP_POL_TRAN_DT;
    }

    public HtmlOutputLabel getCOMP_POL_ASSRD_REF_ID2_LABEL() {
	return COMP_POL_ASSRD_REF_ID2_LABEL;
    }

    public HtmlInputText getCOMP_POL_ASSRD_REF_ID2() {
	return COMP_POL_ASSRD_REF_ID2;
    }

    public void setCOMP_POL_ASSRD_REF_ID2_LABEL(
	    HtmlOutputLabel COMP_POL_ASSRD_REF_ID2_LABEL) {
	this.COMP_POL_ASSRD_REF_ID2_LABEL = COMP_POL_ASSRD_REF_ID2_LABEL;
    }

    public void setCOMP_POL_ASSRD_REF_ID2(HtmlInputText COMP_POL_ASSRD_REF_ID2) {
	this.COMP_POL_ASSRD_REF_ID2 = COMP_POL_ASSRD_REF_ID2;
    }

    public HtmlOutputLabel getCOMP_UI_M_MAT_AGE_LABEL() {
	return COMP_UI_M_MAT_AGE_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_MAT_AGE() {
	return COMP_UI_M_MAT_AGE;
    }

    public void setCOMP_UI_M_MAT_AGE_LABEL(
	    HtmlOutputLabel COMP_UI_M_MAT_AGE_LABEL) {
	this.COMP_UI_M_MAT_AGE_LABEL = COMP_UI_M_MAT_AGE_LABEL;
    }

    public void setCOMP_UI_M_MAT_AGE(HtmlInputText COMP_UI_M_MAT_AGE) {
	this.COMP_UI_M_MAT_AGE = COMP_UI_M_MAT_AGE;
    }

    public HtmlOutputLabel getCOMP_POL_APPRV_UID() {
	return COMP_POL_APPRV_UID;
    }

    public void setCOMP_POL_APPRV_UID(HtmlOutputLabel COMP_POL_APPRV_UID) {
	this.COMP_POL_APPRV_UID = COMP_POL_APPRV_UID;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_CONVERT_YN() {
	return COMP_UI_M_POL_CONVERT_YN;
    }

    public void setCOMP_UI_M_POL_CONVERT_YN(
	    HtmlOutputLabel COMP_UI_M_POL_CONVERT_YN) {
	this.COMP_UI_M_POL_CONVERT_YN = COMP_UI_M_POL_CONVERT_YN;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_SA1_LABEL() {
	return COMP_UI_M_POL_LC_SA1_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_SA1() {
	return COMP_UI_M_POL_LC_SA1;
    }

    public void setCOMP_UI_M_POL_LC_SA1_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_SA1_LABEL) {
	this.COMP_UI_M_POL_LC_SA1_LABEL = COMP_UI_M_POL_LC_SA1_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_SA1(HtmlInputText COMP_UI_M_POL_LC_SA1) {
	this.COMP_UI_M_POL_LC_SA1 = COMP_UI_M_POL_LC_SA1;
    }

    public HtmlOutputLabel getCOMP_POL_BASIC_RATE1_LABEL() {
	return COMP_POL_BASIC_RATE1_LABEL;
    }

    public HtmlInputText getCOMP_POL_BASIC_RATE1() {
	return COMP_POL_BASIC_RATE1;
    }

    public void setCOMP_POL_BASIC_RATE1_LABEL(
	    HtmlOutputLabel COMP_POL_BASIC_RATE1_LABEL) {
	this.COMP_POL_BASIC_RATE1_LABEL = COMP_POL_BASIC_RATE1_LABEL;
    }

    public void setCOMP_POL_BASIC_RATE1(HtmlInputText COMP_POL_BASIC_RATE1) {
	this.COMP_POL_BASIC_RATE1 = COMP_POL_BASIC_RATE1;
    }

    public HtmlOutputLabel getCOMP_POL_LC_BASIC_PREM1_LABEL() {
	return COMP_POL_LC_BASIC_PREM1_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_BASIC_PREM1() {
	return COMP_POL_LC_BASIC_PREM1;
    }

    public void setCOMP_POL_LC_BASIC_PREM1_LABEL(
	    HtmlOutputLabel COMP_POL_LC_BASIC_PREM1_LABEL) {
	this.COMP_POL_LC_BASIC_PREM1_LABEL = COMP_POL_LC_BASIC_PREM1_LABEL;
    }

    public void setCOMP_POL_LC_BASIC_PREM1(HtmlInputText COMP_POL_LC_BASIC_PREM1) {
	this.COMP_POL_LC_BASIC_PREM1 = COMP_POL_LC_BASIC_PREM1;
    }

    public HtmlOutputLabel getCOMP_POL_LC_ADDL_PREM1_LABEL() {
	return COMP_POL_LC_ADDL_PREM1_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_ADDL_PREM1() {
	return COMP_POL_LC_ADDL_PREM1;
    }

    public void setCOMP_POL_LC_ADDL_PREM1_LABEL(
	    HtmlOutputLabel COMP_POL_LC_ADDL_PREM1_LABEL) {
	this.COMP_POL_LC_ADDL_PREM1_LABEL = COMP_POL_LC_ADDL_PREM1_LABEL;
    }

    public void setCOMP_POL_LC_ADDL_PREM1(HtmlInputText COMP_POL_LC_ADDL_PREM1) {
	this.COMP_POL_LC_ADDL_PREM1 = COMP_POL_LC_ADDL_PREM1;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_PREM1_LABEL() {
	return COMP_UI_M_POL_LC_TOT_PREM1_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_TOT_PREM1() {
	return COMP_UI_M_POL_LC_TOT_PREM1;
    }

    public void setCOMP_UI_M_POL_LC_TOT_PREM1_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_TOT_PREM1_LABEL) {
	this.COMP_UI_M_POL_LC_TOT_PREM1_LABEL = COMP_UI_M_POL_LC_TOT_PREM1_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_TOT_PREM1(
	    HtmlInputText COMP_UI_M_POL_LC_TOT_PREM1) {
	this.COMP_UI_M_POL_LC_TOT_PREM1 = COMP_UI_M_POL_LC_TOT_PREM1;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_LOADING1_LABEL() {
	return COMP_UI_M_POL_LC_TOT_LOADING1_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_TOT_LOADING1() {
	return COMP_UI_M_POL_LC_TOT_LOADING1;
    }

    public void setCOMP_UI_M_POL_LC_TOT_LOADING1_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_TOT_LOADING1_LABEL) {
	this.COMP_UI_M_POL_LC_TOT_LOADING1_LABEL = COMP_UI_M_POL_LC_TOT_LOADING1_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_TOT_LOADING1(  HtmlInputText COMP_UI_M_POL_LC_TOT_LOADING1) {
	this.COMP_UI_M_POL_LC_TOT_LOADING1 = COMP_UI_M_POL_LC_TOT_LOADING1;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL() {
	return COMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_TOT_DISCOUNT1() {
	return COMP_UI_M_POL_LC_TOT_DISCOUNT1;
    }

    public void setCOMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL) {
	this.COMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL = COMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_TOT_DISCOUNT1(
	    HtmlInputText COMP_UI_M_POL_LC_TOT_DISCOUNT1) {
	this.COMP_UI_M_POL_LC_TOT_DISCOUNT1 = COMP_UI_M_POL_LC_TOT_DISCOUNT1;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL() {
	return COMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_PCHARGES_BORNE_CUST1() {
	return COMP_UI_M_LC_PCHARGES_BORNE_CUST1;
    }

    public void setCOMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL) {
	this.COMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL = COMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL;
    }

    public void setCOMP_UI_M_LC_PCHARGES_BORNE_CUST1(
	    HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_CUST1) {
	this.COMP_UI_M_LC_PCHARGES_BORNE_CUST1 = COMP_UI_M_LC_PCHARGES_BORNE_CUST1;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_NET_PREM1_LABEL() {
	return COMP_UI_M_POL_LC_NET_PREM1_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_NET_PREM1() {
	return COMP_UI_M_POL_LC_NET_PREM1;
    }

    public void setCOMP_UI_M_POL_LC_NET_PREM1_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_NET_PREM1_LABEL) {
	this.COMP_UI_M_POL_LC_NET_PREM1_LABEL = COMP_UI_M_POL_LC_NET_PREM1_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_NET_PREM1(
	    HtmlInputText COMP_UI_M_POL_LC_NET_PREM1) {
	this.COMP_UI_M_POL_LC_NET_PREM1 = COMP_UI_M_POL_LC_NET_PREM1;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL() {
	return COMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_MODE_OF_PYMT_RATE1() {
	return COMP_UI_M_POL_MODE_OF_PYMT_RATE1;
    }

    public void setCOMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL) {
	this.COMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL = COMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL;
    }

    public void setCOMP_UI_M_POL_MODE_OF_PYMT_RATE1(
	    HtmlInputText COMP_UI_M_POL_MODE_OF_PYMT_RATE1) {
	this.COMP_UI_M_POL_MODE_OF_PYMT_RATE1 = COMP_UI_M_POL_MODE_OF_PYMT_RATE1;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_MOP1_LABEL() {
	return COMP_UI_M_POL_LC_MOP1_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_MOP1() {
	return COMP_UI_M_POL_LC_MOP1;
    }

    public void setCOMP_UI_M_POL_LC_MOP1_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_MOP1_LABEL) {
	this.COMP_UI_M_POL_LC_MOP1_LABEL = COMP_UI_M_POL_LC_MOP1_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_MOP1(HtmlInputText COMP_UI_M_POL_LC_MOP1) {
	this.COMP_UI_M_POL_LC_MOP1 = COMP_UI_M_POL_LC_MOP1;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL() {
	return COMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_GR_ANN_PREM1() {
	return COMP_UI_M_POL_LC_GR_ANN_PREM1;
    }

    public void setCOMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL) {
	this.COMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL = COMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_GR_ANN_PREM1(
	    HtmlInputText COMP_UI_M_POL_LC_GR_ANN_PREM1) {
	this.COMP_UI_M_POL_LC_GR_ANN_PREM1 = COMP_UI_M_POL_LC_GR_ANN_PREM1;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_INST_LC_PREM1_LABEL() {
	return COMP_UI_M_POL_INST_LC_PREM1_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_INST_LC_PREM1() {
	return COMP_UI_M_POL_INST_LC_PREM1;
    }

    public void setCOMP_UI_M_POL_INST_LC_PREM1_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_INST_LC_PREM1_LABEL) {
	this.COMP_UI_M_POL_INST_LC_PREM1_LABEL = COMP_UI_M_POL_INST_LC_PREM1_LABEL;
    }

    public void setCOMP_UI_M_POL_INST_LC_PREM1(
	    HtmlInputText COMP_UI_M_POL_INST_LC_PREM1) {
	this.COMP_UI_M_POL_INST_LC_PREM1 = COMP_UI_M_POL_INST_LC_PREM1;
    }

    public HtmlOutputLabel getCOMP_POL_LC_DISC_AMT1_LABEL() {
	return COMP_POL_LC_DISC_AMT1_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_DISC_AMT1() {
	return COMP_POL_LC_DISC_AMT1;
    }

    public void setCOMP_POL_LC_DISC_AMT1_LABEL(
	    HtmlOutputLabel COMP_POL_LC_DISC_AMT1_LABEL) {
	this.COMP_POL_LC_DISC_AMT1_LABEL = COMP_POL_LC_DISC_AMT1_LABEL;
    }

    public void setCOMP_POL_LC_DISC_AMT1(HtmlInputText COMP_POL_LC_DISC_AMT1) {
	this.COMP_POL_LC_DISC_AMT1 = COMP_POL_LC_DISC_AMT1;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL() {
	return COMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_SCHARGES_BORNE_CUST1() {
	return COMP_UI_M_LC_SCHARGES_BORNE_CUST1;
    }

    public void setCOMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL) {
	this.COMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL = COMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL;
    }

    public void setCOMP_UI_M_LC_SCHARGES_BORNE_CUST1(
	    HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_CUST1) {
	this.COMP_UI_M_LC_SCHARGES_BORNE_CUST1 = COMP_UI_M_LC_SCHARGES_BORNE_CUST1;
    }

    public HtmlOutputLabel getCOMP_POL_LC_FIRST_PREM1_LABEL() {
	return COMP_POL_LC_FIRST_PREM1_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_FIRST_PREM1() {
	return COMP_POL_LC_FIRST_PREM1;
    }

    public void setCOMP_POL_LC_FIRST_PREM1_LABEL(
	    HtmlOutputLabel COMP_POL_LC_FIRST_PREM1_LABEL) {
	this.COMP_POL_LC_FIRST_PREM1_LABEL = COMP_POL_LC_FIRST_PREM1_LABEL;
    }

    public void setCOMP_POL_LC_FIRST_PREM1(HtmlInputText COMP_POL_LC_FIRST_PREM1) {
	this.COMP_POL_LC_FIRST_PREM1 = COMP_POL_LC_FIRST_PREM1;
    }

    public HtmlOutputLabel getCOMP_POL_RES_ADDRESS_1_LABEL() {
	return COMP_POL_RES_ADDRESS_1_LABEL;
    }

    public HtmlInputText getCOMP_POL_RES_ADDRESS_1() {
	return COMP_POL_RES_ADDRESS_1;
    }

    public void setCOMP_POL_RES_ADDRESS_1_LABEL(
	    HtmlOutputLabel COMP_POL_RES_ADDRESS_1_LABEL) {
	this.COMP_POL_RES_ADDRESS_1_LABEL = COMP_POL_RES_ADDRESS_1_LABEL;
    }

    public void setCOMP_POL_RES_ADDRESS_1(HtmlInputText COMP_POL_RES_ADDRESS_1) {
	this.COMP_POL_RES_ADDRESS_1 = COMP_POL_RES_ADDRESS_1;
    }

    public HtmlOutputLabel getCOMP_POL_RES_ADDRESS_2_LABEL() {
	return COMP_POL_RES_ADDRESS_2_LABEL;
    }

    public HtmlInputText getCOMP_POL_RES_ADDRESS_2() {
	return COMP_POL_RES_ADDRESS_2;
    }

    public void setCOMP_POL_RES_ADDRESS_2_LABEL(
	    HtmlOutputLabel COMP_POL_RES_ADDRESS_2_LABEL) {
	this.COMP_POL_RES_ADDRESS_2_LABEL = COMP_POL_RES_ADDRESS_2_LABEL;
    }

    public void setCOMP_POL_RES_ADDRESS_2(HtmlInputText COMP_POL_RES_ADDRESS_2) {
	this.COMP_POL_RES_ADDRESS_2 = COMP_POL_RES_ADDRESS_2;
    }

    public HtmlOutputLabel getCOMP_POL_RES_ADDRESS_3_LABEL() {
	return COMP_POL_RES_ADDRESS_3_LABEL;
    }

    public HtmlInputText getCOMP_POL_RES_ADDRESS_3() {
	return COMP_POL_RES_ADDRESS_3;
    }

    public void setCOMP_POL_RES_ADDRESS_3_LABEL(
	    HtmlOutputLabel COMP_POL_RES_ADDRESS_3_LABEL) {
	this.COMP_POL_RES_ADDRESS_3_LABEL = COMP_POL_RES_ADDRESS_3_LABEL;
    }

    public void setCOMP_POL_RES_ADDRESS_3(HtmlInputText COMP_POL_RES_ADDRESS_3) {
	this.COMP_POL_RES_ADDRESS_3 = COMP_POL_RES_ADDRESS_3;
    }

    public HtmlOutputLabel getCOMP_POL_RES_AREA_CODE_LABEL() {
	return COMP_POL_RES_AREA_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_RES_AREA_CODE() {
	return COMP_POL_RES_AREA_CODE;
    }

    public void setCOMP_POL_RES_AREA_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_RES_AREA_CODE_LABEL) {
	this.COMP_POL_RES_AREA_CODE_LABEL = COMP_POL_RES_AREA_CODE_LABEL;
    }

    public void setCOMP_POL_RES_AREA_CODE(HtmlInputText COMP_POL_RES_AREA_CODE) {
	this.COMP_POL_RES_AREA_CODE = COMP_POL_RES_AREA_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL() {
	return COMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_RES_AREA_CODE_DESC() {
	return COMP_UI_M_POL_RES_AREA_CODE_DESC;
    }

    public void setCOMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL) {
	this.COMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL = COMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_RES_AREA_CODE_DESC(
	    HtmlInputText COMP_UI_M_POL_RES_AREA_CODE_DESC) {
	this.COMP_UI_M_POL_RES_AREA_CODE_DESC = COMP_UI_M_POL_RES_AREA_CODE_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_CITY_CODE_LABEL() {
	return COMP_POL_CITY_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_CITY_CODE() {
	return COMP_POL_CITY_CODE;
    }

    public void setCOMP_POL_CITY_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_CITY_CODE_LABEL) {
	this.COMP_POL_CITY_CODE_LABEL = COMP_POL_CITY_CODE_LABEL;
    }

    public void setCOMP_POL_CITY_CODE(HtmlInputText COMP_POL_CITY_CODE) {
	this.COMP_POL_CITY_CODE = COMP_POL_CITY_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_CITY_NAME_LABEL() {
	return COMP_UI_M_POL_CITY_NAME_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_CITY_NAME() {
	return COMP_UI_M_POL_CITY_NAME;
    }

    public void setCOMP_UI_M_POL_CITY_NAME_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_CITY_NAME_LABEL) {
	this.COMP_UI_M_POL_CITY_NAME_LABEL = COMP_UI_M_POL_CITY_NAME_LABEL;
    }

    public void setCOMP_UI_M_POL_CITY_NAME(HtmlInputText COMP_UI_M_POL_CITY_NAME) {
	this.COMP_UI_M_POL_CITY_NAME = COMP_UI_M_POL_CITY_NAME;
    }

    public HtmlOutputLabel getCOMP_POL_STATE_CODE_LABEL() {
	return COMP_POL_STATE_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_STATE_CODE() {
	return COMP_POL_STATE_CODE;
    }

    public void setCOMP_POL_STATE_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_STATE_CODE_LABEL) {
	this.COMP_POL_STATE_CODE_LABEL = COMP_POL_STATE_CODE_LABEL;
    }

    public void setCOMP_POL_STATE_CODE(HtmlInputText COMP_POL_STATE_CODE) {
	this.COMP_POL_STATE_CODE = COMP_POL_STATE_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_STATE_NAME_LABEL() {
	return COMP_UI_M_POL_STATE_NAME_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_STATE_NAME() {
	return COMP_UI_M_POL_STATE_NAME;
    }

    public void setCOMP_UI_M_POL_STATE_NAME_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_STATE_NAME_LABEL) {
	this.COMP_UI_M_POL_STATE_NAME_LABEL = COMP_UI_M_POL_STATE_NAME_LABEL;
    }

    public void setCOMP_UI_M_POL_STATE_NAME(
	    HtmlInputText COMP_UI_M_POL_STATE_NAME) {
	this.COMP_UI_M_POL_STATE_NAME = COMP_UI_M_POL_STATE_NAME;
    }

    public HtmlOutputLabel getCOMP_POL_COUNT_CODE_LABEL() {
	return COMP_POL_COUNT_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_COUNT_CODE() {
	return COMP_POL_COUNT_CODE;
    }

    public void setCOMP_POL_COUNT_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_COUNT_CODE_LABEL) {
	this.COMP_POL_COUNT_CODE_LABEL = COMP_POL_COUNT_CODE_LABEL;
    }

    public void setCOMP_POL_COUNT_CODE(HtmlInputText COMP_POL_COUNT_CODE) {
	this.COMP_POL_COUNT_CODE = COMP_POL_COUNT_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_COUNT_NAME_LABEL() {
	return COMP_UI_M_POL_COUNT_NAME_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_COUNT_NAME() {
	return COMP_UI_M_POL_COUNT_NAME;
    }

    public void setCOMP_UI_M_POL_COUNT_NAME_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_COUNT_NAME_LABEL) {
	this.COMP_UI_M_POL_COUNT_NAME_LABEL = COMP_UI_M_POL_COUNT_NAME_LABEL;
    }

    public void setCOMP_UI_M_POL_COUNT_NAME(
	    HtmlInputText COMP_UI_M_POL_COUNT_NAME) {
	this.COMP_UI_M_POL_COUNT_NAME = COMP_UI_M_POL_COUNT_NAME;
    }

    public HtmlOutputLabel getCOMP_POL_RES_PHONE_NO_LABEL() {
	return COMP_POL_RES_PHONE_NO_LABEL;
    }

    public HtmlInputText getCOMP_POL_RES_PHONE_NO() {
	return COMP_POL_RES_PHONE_NO;
    }

    public void setCOMP_POL_RES_PHONE_NO_LABEL(
	    HtmlOutputLabel COMP_POL_RES_PHONE_NO_LABEL) {
	this.COMP_POL_RES_PHONE_NO_LABEL = COMP_POL_RES_PHONE_NO_LABEL;
    }

    public void setCOMP_POL_RES_PHONE_NO(HtmlInputText COMP_POL_RES_PHONE_NO) {
	this.COMP_POL_RES_PHONE_NO = COMP_POL_RES_PHONE_NO;
    }

    public HtmlOutputLabel getCOMP_POL_MOBILE_NO_LABEL() {
	return COMP_POL_MOBILE_NO_LABEL;
    }

    public HtmlInputText getCOMP_POL_MOBILE_NO() {
	return COMP_POL_MOBILE_NO;
    }

    public void setCOMP_POL_MOBILE_NO_LABEL(
	    HtmlOutputLabel COMP_POL_MOBILE_NO_LABEL) {
	this.COMP_POL_MOBILE_NO_LABEL = COMP_POL_MOBILE_NO_LABEL;
    }

    public void setCOMP_POL_MOBILE_NO(HtmlInputText COMP_POL_MOBILE_NO) {
	this.COMP_POL_MOBILE_NO = COMP_POL_MOBILE_NO;
    }

    public HtmlOutputLabel getCOMP_POL_OFF_ADDRESS_1_LABEL() {
	return COMP_POL_OFF_ADDRESS_1_LABEL;
    }

    public HtmlInputText getCOMP_POL_OFF_ADDRESS_1() {
	return COMP_POL_OFF_ADDRESS_1;
    }

    public void setCOMP_POL_OFF_ADDRESS_1_LABEL(
	    HtmlOutputLabel COMP_POL_OFF_ADDRESS_1_LABEL) {
	this.COMP_POL_OFF_ADDRESS_1_LABEL = COMP_POL_OFF_ADDRESS_1_LABEL;
    }

    public void setCOMP_POL_OFF_ADDRESS_1(HtmlInputText COMP_POL_OFF_ADDRESS_1) {
	this.COMP_POL_OFF_ADDRESS_1 = COMP_POL_OFF_ADDRESS_1;
    }

    public HtmlOutputLabel getCOMP_POL_OFF_ADDRESS_2_LABEL() {
	return COMP_POL_OFF_ADDRESS_2_LABEL;
    }

    public HtmlInputText getCOMP_POL_OFF_ADDRESS_2() {
	return COMP_POL_OFF_ADDRESS_2;
    }

    public void setCOMP_POL_OFF_ADDRESS_2_LABEL(
	    HtmlOutputLabel COMP_POL_OFF_ADDRESS_2_LABEL) {
	this.COMP_POL_OFF_ADDRESS_2_LABEL = COMP_POL_OFF_ADDRESS_2_LABEL;
    }

    public void setCOMP_POL_OFF_ADDRESS_2(HtmlInputText COMP_POL_OFF_ADDRESS_2) {
	this.COMP_POL_OFF_ADDRESS_2 = COMP_POL_OFF_ADDRESS_2;
    }

    public HtmlOutputLabel getCOMP_POL_OFF_ADDRESS_3_LABEL() {
	return COMP_POL_OFF_ADDRESS_3_LABEL;
    }

    public HtmlInputText getCOMP_POL_OFF_ADDRESS_3() {
	return COMP_POL_OFF_ADDRESS_3;
    }

    public void setCOMP_POL_OFF_ADDRESS_3_LABEL(
	    HtmlOutputLabel COMP_POL_OFF_ADDRESS_3_LABEL) {
	this.COMP_POL_OFF_ADDRESS_3_LABEL = COMP_POL_OFF_ADDRESS_3_LABEL;
    }

    public void setCOMP_POL_OFF_ADDRESS_3(HtmlInputText COMP_POL_OFF_ADDRESS_3) {
	this.COMP_POL_OFF_ADDRESS_3 = COMP_POL_OFF_ADDRESS_3;
    }

    public HtmlOutputLabel getCOMP_POL_OFF_AREA_CODE_LABEL() {
	return COMP_POL_OFF_AREA_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_OFF_AREA_CODE() {
	return COMP_POL_OFF_AREA_CODE;
    }

    public void setCOMP_POL_OFF_AREA_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_OFF_AREA_CODE_LABEL) {
	this.COMP_POL_OFF_AREA_CODE_LABEL = COMP_POL_OFF_AREA_CODE_LABEL;
    }

    public void setCOMP_POL_OFF_AREA_CODE(HtmlInputText COMP_POL_OFF_AREA_CODE) {
	this.COMP_POL_OFF_AREA_CODE = COMP_POL_OFF_AREA_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POSTAL_NAME_LABEL() {
	return COMP_UI_M_POSTAL_NAME_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POSTAL_NAME() {
	return COMP_UI_M_POSTAL_NAME;
    }

    public void setCOMP_UI_M_POSTAL_NAME_LABEL(
	    HtmlOutputLabel COMP_UI_M_POSTAL_NAME_LABEL) {
	this.COMP_UI_M_POSTAL_NAME_LABEL = COMP_UI_M_POSTAL_NAME_LABEL;
    }

    public void setCOMP_UI_M_POSTAL_NAME(HtmlInputText COMP_UI_M_POSTAL_NAME) {
	this.COMP_UI_M_POSTAL_NAME = COMP_UI_M_POSTAL_NAME;
    }

    public HtmlOutputLabel getCOMP_POL_OFF_PHONE_NO_LABEL() {
	return COMP_POL_OFF_PHONE_NO_LABEL;
    }

    public HtmlInputText getCOMP_POL_OFF_PHONE_NO() {
	return COMP_POL_OFF_PHONE_NO;
    }

    public void setCOMP_POL_OFF_PHONE_NO_LABEL(
	    HtmlOutputLabel COMP_POL_OFF_PHONE_NO_LABEL) {
	this.COMP_POL_OFF_PHONE_NO_LABEL = COMP_POL_OFF_PHONE_NO_LABEL;
    }

    public void setCOMP_POL_OFF_PHONE_NO(HtmlInputText COMP_POL_OFF_PHONE_NO) {
	this.COMP_POL_OFF_PHONE_NO = COMP_POL_OFF_PHONE_NO;
    }

    public HtmlOutputLabel getCOMP_POL_FAX_NO_LABEL() {
	return COMP_POL_FAX_NO_LABEL;
    }

    public HtmlInputText getCOMP_POL_FAX_NO() {
	return COMP_POL_FAX_NO;
    }

    public void setCOMP_POL_FAX_NO_LABEL(HtmlOutputLabel COMP_POL_FAX_NO_LABEL) {
	this.COMP_POL_FAX_NO_LABEL = COMP_POL_FAX_NO_LABEL;
    }

    public void setCOMP_POL_FAX_NO(HtmlInputText COMP_POL_FAX_NO) {
	this.COMP_POL_FAX_NO = COMP_POL_FAX_NO;
    }

    public HtmlOutputLabel getCOMP_POL_FAX_AREA_CODE_LABEL() {
	return COMP_POL_FAX_AREA_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_FAX_AREA_CODE() {
	return COMP_POL_FAX_AREA_CODE;
    }

    public void setCOMP_POL_FAX_AREA_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_FAX_AREA_CODE_LABEL) {
	this.COMP_POL_FAX_AREA_CODE_LABEL = COMP_POL_FAX_AREA_CODE_LABEL;
    }

    public void setCOMP_POL_FAX_AREA_CODE(HtmlInputText COMP_POL_FAX_AREA_CODE) {
	this.COMP_POL_FAX_AREA_CODE = COMP_POL_FAX_AREA_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_ADDL_STATUS_DESC_LABEL() {
	return COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_ADDL_STATUS_DESC() {
	return COMP_UI_M_POL_ADDL_STATUS_DESC;
    }

    public void setCOMP_UI_M_POL_ADDL_STATUS_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL) {
	this.COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL = COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_ADDL_STATUS_DESC(
	    HtmlInputText COMP_UI_M_POL_ADDL_STATUS_DESC) {
	this.COMP_UI_M_POL_ADDL_STATUS_DESC = COMP_UI_M_POL_ADDL_STATUS_DESC;
    }

    public HtmlOutputLabel getCOMP_PAYOR_TAB_LABEL() {
	return COMP_PAYOR_TAB_LABEL;
    }

    public HtmlInputText getCOMP_PAYOR_TAB() {
	return COMP_PAYOR_TAB;
    }

    public void setCOMP_PAYOR_TAB_LABEL(HtmlOutputLabel COMP_PAYOR_TAB_LABEL) {
	this.COMP_PAYOR_TAB_LABEL = COMP_PAYOR_TAB_LABEL;
    }

    public void setCOMP_PAYOR_TAB(HtmlInputText COMP_PAYOR_TAB) {
	this.COMP_PAYOR_TAB = COMP_PAYOR_TAB;
    }

    public HtmlOutputLabel getCOMP_POL_MASTER_POL_NO_LABEL() {
	return COMP_POL_MASTER_POL_NO_LABEL;
    }

    public HtmlInputText getCOMP_POL_MASTER_POL_NO() {
	return COMP_POL_MASTER_POL_NO;
    }

    public void setCOMP_POL_MASTER_POL_NO_LABEL(
	    HtmlOutputLabel COMP_POL_MASTER_POL_NO_LABEL) {
	this.COMP_POL_MASTER_POL_NO_LABEL = COMP_POL_MASTER_POL_NO_LABEL;
    }

    public void setCOMP_POL_MASTER_POL_NO(HtmlInputText COMP_POL_MASTER_POL_NO) {
	this.COMP_POL_MASTER_POL_NO = COMP_POL_MASTER_POL_NO;
    }

    public HtmlOutputLabel getCOMP_POL_PROFIT_RATE_LABEL() {
	return COMP_POL_PROFIT_RATE_LABEL;
    }

    public HtmlInputText getCOMP_POL_PROFIT_RATE() {
	return COMP_POL_PROFIT_RATE;
    }

    public void setCOMP_POL_PROFIT_RATE_LABEL(
	    HtmlOutputLabel COMP_POL_PROFIT_RATE_LABEL) {
	this.COMP_POL_PROFIT_RATE_LABEL = COMP_POL_PROFIT_RATE_LABEL;
    }

    public void setCOMP_POL_PROFIT_RATE(HtmlInputText COMP_POL_PROFIT_RATE) {
	this.COMP_POL_PROFIT_RATE = COMP_POL_PROFIT_RATE;
    }

    public HtmlOutputLabel getCOMP_POL_MODE_OF_CALC_LABEL() {
	return COMP_POL_MODE_OF_CALC_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_MODE_OF_CALC() {
	return COMP_POL_MODE_OF_CALC;
    }

    public void setCOMP_POL_MODE_OF_CALC_LABEL(
	    HtmlOutputLabel COMP_POL_MODE_OF_CALC_LABEL) {
	this.COMP_POL_MODE_OF_CALC_LABEL = COMP_POL_MODE_OF_CALC_LABEL;
    }

    public void setCOMP_POL_MODE_OF_CALC(HtmlSelectOneMenu COMP_POL_MODE_OF_CALC) {
	this.COMP_POL_MODE_OF_CALC = COMP_POL_MODE_OF_CALC;
    }

    public HtmlOutputLabel getCOMP_POL_CREDIT_INT_RATE_LABEL() {
	return COMP_POL_CREDIT_INT_RATE_LABEL;
    }

    public HtmlInputText getCOMP_POL_CREDIT_INT_RATE() {
	return COMP_POL_CREDIT_INT_RATE;
    }

    public void setCOMP_POL_CREDIT_INT_RATE_LABEL(
	    HtmlOutputLabel COMP_POL_CREDIT_INT_RATE_LABEL) {
	this.COMP_POL_CREDIT_INT_RATE_LABEL = COMP_POL_CREDIT_INT_RATE_LABEL;
    }

    public void setCOMP_POL_CREDIT_INT_RATE(
	    HtmlInputText COMP_POL_CREDIT_INT_RATE) {
	this.COMP_POL_CREDIT_INT_RATE = COMP_POL_CREDIT_INT_RATE;
    }

    public HtmlOutputLabel getCOMP_POL_PROP_NO_LABEL() {
	return COMP_POL_PROP_NO_LABEL;
    }

    public HtmlInputText getCOMP_POL_PROP_NO() {
	return COMP_POL_PROP_NO;
    }

    public void setCOMP_POL_PROP_NO_LABEL(HtmlOutputLabel COMP_POL_PROP_NO_LABEL) {
	this.COMP_POL_PROP_NO_LABEL = COMP_POL_PROP_NO_LABEL;
    }

    public void setCOMP_POL_PROP_NO(HtmlInputText COMP_POL_PROP_NO) {
	this.COMP_POL_PROP_NO = COMP_POL_PROP_NO;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_FC_SA_LABEL() {
	return COMP_UI_M_POL_FC_SA_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_FC_SA() {
	return COMP_UI_M_POL_FC_SA;
    }

    public void setCOMP_UI_M_POL_FC_SA_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_FC_SA_LABEL) {
	this.COMP_UI_M_POL_FC_SA_LABEL = COMP_UI_M_POL_FC_SA_LABEL;
    }

    public void setCOMP_UI_M_POL_FC_SA(HtmlInputText COMP_UI_M_POL_FC_SA) {
	this.COMP_UI_M_POL_FC_SA = COMP_UI_M_POL_FC_SA;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_SA_LABEL() {
	return COMP_UI_M_POL_LC_SA_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_SA() {
	return COMP_UI_M_POL_LC_SA;
    }

    public void setCOMP_UI_M_POL_LC_SA_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_SA_LABEL) {
	this.COMP_UI_M_POL_LC_SA_LABEL = COMP_UI_M_POL_LC_SA_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_SA(HtmlInputText COMP_UI_M_POL_LC_SA) {
	this.COMP_UI_M_POL_LC_SA = COMP_UI_M_POL_LC_SA;
    }

    public HtmlOutputLabel getCOMP_POL_HEALTH_RATE_LABEL() {
	return COMP_POL_HEALTH_RATE_LABEL;
    }

    public HtmlInputText getCOMP_POL_HEALTH_RATE() {
	return COMP_POL_HEALTH_RATE;
    }

    public void setCOMP_POL_HEALTH_RATE_LABEL(
	    HtmlOutputLabel COMP_POL_HEALTH_RATE_LABEL) {
	this.COMP_POL_HEALTH_RATE_LABEL = COMP_POL_HEALTH_RATE_LABEL;
    }

    public void setCOMP_POL_HEALTH_RATE(HtmlInputText COMP_POL_HEALTH_RATE) {
	this.COMP_POL_HEALTH_RATE = COMP_POL_HEALTH_RATE;
    }

    public HtmlOutputLabel getCOMP_POL_PROJECT_CODE_LABEL() {
	return COMP_POL_PROJECT_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_PROJECT_CODE() {
	return COMP_POL_PROJECT_CODE;
    }

    public void setCOMP_POL_PROJECT_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_PROJECT_CODE_LABEL) {
	this.COMP_POL_PROJECT_CODE_LABEL = COMP_POL_PROJECT_CODE_LABEL;
    }

    public void setCOMP_POL_PROJECT_CODE(HtmlInputText COMP_POL_PROJECT_CODE) {
	this.COMP_POL_PROJECT_CODE = COMP_POL_PROJECT_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_PROJECT_CODE_DESC_LABEL() {
	return COMP_UI_M_PROJECT_CODE_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PROJECT_CODE_DESC() {
	return COMP_UI_M_PROJECT_CODE_DESC;
    }

    public void setCOMP_UI_M_PROJECT_CODE_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_PROJECT_CODE_DESC_LABEL) {
	this.COMP_UI_M_PROJECT_CODE_DESC_LABEL = COMP_UI_M_PROJECT_CODE_DESC_LABEL;
    }

    public void setCOMP_UI_M_PROJECT_CODE_DESC(
	    HtmlInputText COMP_UI_M_PROJECT_CODE_DESC) {
	this.COMP_UI_M_PROJECT_CODE_DESC = COMP_UI_M_PROJECT_CODE_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_DEVELOPER_CODE_LABEL() {
	return COMP_POL_DEVELOPER_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_DEVELOPER_CODE() {
	return COMP_POL_DEVELOPER_CODE;
    }

    public void setCOMP_POL_DEVELOPER_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_DEVELOPER_CODE_LABEL) {
	this.COMP_POL_DEVELOPER_CODE_LABEL = COMP_POL_DEVELOPER_CODE_LABEL;
    }

    public void setCOMP_POL_DEVELOPER_CODE(HtmlInputText COMP_POL_DEVELOPER_CODE) {
	this.COMP_POL_DEVELOPER_CODE = COMP_POL_DEVELOPER_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_DEVELOPER_CODE_DESC_LABEL() {
	return COMP_UI_M_DEVELOPER_CODE_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_DEVELOPER_CODE_DESC() {
	return COMP_UI_M_DEVELOPER_CODE_DESC;
    }

    public void setCOMP_UI_M_DEVELOPER_CODE_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_DEVELOPER_CODE_DESC_LABEL) {
	this.COMP_UI_M_DEVELOPER_CODE_DESC_LABEL = COMP_UI_M_DEVELOPER_CODE_DESC_LABEL;
    }

    public void setCOMP_UI_M_DEVELOPER_CODE_DESC(
	    HtmlInputText COMP_UI_M_DEVELOPER_CODE_DESC) {
	this.COMP_UI_M_DEVELOPER_CODE_DESC = COMP_UI_M_DEVELOPER_CODE_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_PYMT_TYPE_LABEL() {
	return COMP_POL_PYMT_TYPE_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_PYMT_TYPE() {
	return COMP_POL_PYMT_TYPE;
    }

    public void setCOMP_POL_PYMT_TYPE_LABEL(
	    HtmlOutputLabel COMP_POL_PYMT_TYPE_LABEL) {
	this.COMP_POL_PYMT_TYPE_LABEL = COMP_POL_PYMT_TYPE_LABEL;
    }

    public void setCOMP_POL_PYMT_TYPE(HtmlSelectOneMenu COMP_POL_PYMT_TYPE) {
	this.COMP_POL_PYMT_TYPE = COMP_POL_PYMT_TYPE;
    }

    public HtmlOutputLabel getCOMP_POL_PAYOR_SDCODE_LABEL() {
	return COMP_POL_PAYOR_SDCODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_PAYOR_SDCODE() {
	return COMP_POL_PAYOR_SDCODE;
    }

    public void setCOMP_POL_PAYOR_SDCODE_LABEL(
	    HtmlOutputLabel COMP_POL_PAYOR_SDCODE_LABEL) {
	this.COMP_POL_PAYOR_SDCODE_LABEL = COMP_POL_PAYOR_SDCODE_LABEL;
    }

    public void setCOMP_POL_PAYOR_SDCODE(HtmlInputText COMP_POL_PAYOR_SDCODE) {
	this.COMP_POL_PAYOR_SDCODE = COMP_POL_PAYOR_SDCODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_PAYOR_CONT_NAME_LABEL() {
	return COMP_UI_M_PAYOR_CONT_NAME_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PAYOR_CONT_NAME() {
	return COMP_UI_M_PAYOR_CONT_NAME;
    }

    public void setCOMP_UI_M_PAYOR_CONT_NAME_LABEL(
	    HtmlOutputLabel COMP_UI_M_PAYOR_CONT_NAME_LABEL) {
	this.COMP_UI_M_PAYOR_CONT_NAME_LABEL = COMP_UI_M_PAYOR_CONT_NAME_LABEL;
    }

    public void setCOMP_UI_M_PAYOR_CONT_NAME(
	    HtmlInputText COMP_UI_M_PAYOR_CONT_NAME) {
	this.COMP_UI_M_PAYOR_CONT_NAME = COMP_UI_M_PAYOR_CONT_NAME;
    }

    public HtmlOutputLabel getCOMP_POL_CUST_CODE_LABEL() {
	return COMP_POL_CUST_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_CUST_CODE() {
	return COMP_POL_CUST_CODE;
    }

    public void setCOMP_POL_CUST_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_CUST_CODE_LABEL) {
	this.COMP_POL_CUST_CODE_LABEL = COMP_POL_CUST_CODE_LABEL;
    }

    public void setCOMP_POL_CUST_CODE(HtmlInputText COMP_POL_CUST_CODE) {
	this.COMP_POL_CUST_CODE = COMP_POL_CUST_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_CUST_DESC_LABEL() {
	return COMP_UI_M_POL_CUST_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_CUST_DESC() {
	return COMP_UI_M_POL_CUST_DESC;
    }

    public void setCOMP_UI_M_POL_CUST_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_CUST_DESC_LABEL) {
	this.COMP_UI_M_POL_CUST_DESC_LABEL = COMP_UI_M_POL_CUST_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_CUST_DESC(HtmlInputText COMP_UI_M_POL_CUST_DESC) {
	this.COMP_UI_M_POL_CUST_DESC = COMP_UI_M_POL_CUST_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_BASIC_RATE_LABEL() {
	return COMP_POL_BASIC_RATE_LABEL;
    }

    public HtmlInputText getCOMP_POL_BASIC_RATE() {
	return COMP_POL_BASIC_RATE;
    }

    public void setCOMP_POL_BASIC_RATE_LABEL(
	    HtmlOutputLabel COMP_POL_BASIC_RATE_LABEL) {
	this.COMP_POL_BASIC_RATE_LABEL = COMP_POL_BASIC_RATE_LABEL;
    }

    public void setCOMP_POL_BASIC_RATE(HtmlInputText COMP_POL_BASIC_RATE) {
	this.COMP_POL_BASIC_RATE = COMP_POL_BASIC_RATE;
    }

    public HtmlOutputLabel getCOMP_POL_FC_BASIC_PREM_LABEL() {
	return COMP_POL_FC_BASIC_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_BASIC_PREM() {
	return COMP_POL_FC_BASIC_PREM;
    }

    public void setCOMP_POL_FC_BASIC_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_FC_BASIC_PREM_LABEL) {
	this.COMP_POL_FC_BASIC_PREM_LABEL = COMP_POL_FC_BASIC_PREM_LABEL;
    }

    public void setCOMP_POL_FC_BASIC_PREM(HtmlInputText COMP_POL_FC_BASIC_PREM) {
	this.COMP_POL_FC_BASIC_PREM = COMP_POL_FC_BASIC_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_LC_BASIC_PREM_LABEL() {
	return COMP_POL_LC_BASIC_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_BASIC_PREM() {
	return COMP_POL_LC_BASIC_PREM;
    }

    public void setCOMP_POL_LC_BASIC_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_LC_BASIC_PREM_LABEL) {
	this.COMP_POL_LC_BASIC_PREM_LABEL = COMP_POL_LC_BASIC_PREM_LABEL;
    }

    public void setCOMP_POL_LC_BASIC_PREM(HtmlInputText COMP_POL_LC_BASIC_PREM) {
	this.COMP_POL_LC_BASIC_PREM = COMP_POL_LC_BASIC_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_FC_HEALTH_LOAD_LABEL() {
	return COMP_POL_FC_HEALTH_LOAD_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_HEALTH_LOAD() {
	return COMP_POL_FC_HEALTH_LOAD;
    }

    public void setCOMP_POL_FC_HEALTH_LOAD_LABEL(
	    HtmlOutputLabel COMP_POL_FC_HEALTH_LOAD_LABEL) {
	this.COMP_POL_FC_HEALTH_LOAD_LABEL = COMP_POL_FC_HEALTH_LOAD_LABEL;
    }

    public void setCOMP_POL_FC_HEALTH_LOAD(HtmlInputText COMP_POL_FC_HEALTH_LOAD) {
	this.COMP_POL_FC_HEALTH_LOAD = COMP_POL_FC_HEALTH_LOAD;
    }

    public HtmlOutputLabel getCOMP_POL_LC_HEALTH_LOAD_LABEL() {
	return COMP_POL_LC_HEALTH_LOAD_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_HEALTH_LOAD() {
	return COMP_POL_LC_HEALTH_LOAD;
    }

    public void setCOMP_POL_LC_HEALTH_LOAD_LABEL(
	    HtmlOutputLabel COMP_POL_LC_HEALTH_LOAD_LABEL) {
	this.COMP_POL_LC_HEALTH_LOAD_LABEL = COMP_POL_LC_HEALTH_LOAD_LABEL;
    }

    public void setCOMP_POL_LC_HEALTH_LOAD(HtmlInputText COMP_POL_LC_HEALTH_LOAD) {
	this.COMP_POL_LC_HEALTH_LOAD = COMP_POL_LC_HEALTH_LOAD;
    }

    public HtmlOutputLabel getCOMP_POL_HOME_OWNER_FLAG_LABEL() {
	return COMP_POL_HOME_OWNER_FLAG_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_HOME_OWNER_FLAG() {
	return COMP_POL_HOME_OWNER_FLAG;
    }

    public void setCOMP_POL_HOME_OWNER_FLAG_LABEL(
	    HtmlOutputLabel COMP_POL_HOME_OWNER_FLAG_LABEL) {
	this.COMP_POL_HOME_OWNER_FLAG_LABEL = COMP_POL_HOME_OWNER_FLAG_LABEL;
    }

    public void setCOMP_POL_HOME_OWNER_FLAG(
	    HtmlSelectOneMenu COMP_POL_HOME_OWNER_FLAG) {
	this.COMP_POL_HOME_OWNER_FLAG = COMP_POL_HOME_OWNER_FLAG;
    }

    public HtmlOutputLabel getCOMP_POL_FLEX_01_LABEL() {
	return COMP_POL_FLEX_01_LABEL;
    }

    public HtmlInputText getCOMP_POL_FLEX_01() {
	return COMP_POL_FLEX_01;
    }

    public void setCOMP_POL_FLEX_01_LABEL(HtmlOutputLabel COMP_POL_FLEX_01_LABEL) {
	this.COMP_POL_FLEX_01_LABEL = COMP_POL_FLEX_01_LABEL;
    }

    public void setCOMP_POL_FLEX_01(HtmlInputText COMP_POL_FLEX_01) {
	this.COMP_POL_FLEX_01 = COMP_POL_FLEX_01;
    }

    public HtmlOutputLabel getCOMP_UI_M_CONT_NAME_LABEL() {
	return COMP_UI_M_CONT_NAME_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_CONT_NAME() {
	return COMP_UI_M_CONT_NAME;
    }

    public void setCOMP_UI_M_CONT_NAME_LABEL(
	    HtmlOutputLabel COMP_UI_M_CONT_NAME_LABEL) {
	this.COMP_UI_M_CONT_NAME_LABEL = COMP_UI_M_CONT_NAME_LABEL;
    }

    public void setCOMP_UI_M_CONT_NAME(HtmlInputText COMP_UI_M_CONT_NAME) {
	this.COMP_UI_M_CONT_NAME = COMP_UI_M_CONT_NAME;
    }

    public HtmlOutputLabel getCOMP_POL_DEFER_PRD_LABEL() {
	return COMP_POL_DEFER_PRD_LABEL;
    }

    public HtmlInputText getCOMP_POL_DEFER_PRD() {
	return COMP_POL_DEFER_PRD;
    }

    public void setCOMP_POL_DEFER_PRD_LABEL(
	    HtmlOutputLabel COMP_POL_DEFER_PRD_LABEL) {
	this.COMP_POL_DEFER_PRD_LABEL = COMP_POL_DEFER_PRD_LABEL;
    }

    public void setCOMP_POL_DEFER_PRD(HtmlInputText COMP_POL_DEFER_PRD) {
	this.COMP_POL_DEFER_PRD = COMP_POL_DEFER_PRD;
    }

    public HtmlOutputLabel getCOMP_POL_EMPLOYER_CODE_LABEL() {
	return COMP_POL_EMPLOYER_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_EMPLOYER_CODE() {
	return COMP_POL_EMPLOYER_CODE;
    }

    public void setCOMP_POL_EMPLOYER_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_EMPLOYER_CODE_LABEL) {
	this.COMP_POL_EMPLOYER_CODE_LABEL = COMP_POL_EMPLOYER_CODE_LABEL;
    }

    public void setCOMP_POL_EMPLOYER_CODE(HtmlInputText COMP_POL_EMPLOYER_CODE) {
	this.COMP_POL_EMPLOYER_CODE = COMP_POL_EMPLOYER_CODE;
    }

    public HtmlOutputLabel getCOMP_POL_SRC_OF_BUS_LABEL() {
	return COMP_POL_SRC_OF_BUS_LABEL;
    }

    public HtmlInputText getCOMP_POL_SRC_OF_BUS() {
	return COMP_POL_SRC_OF_BUS;
    }

    public void setCOMP_POL_SRC_OF_BUS_LABEL(
	    HtmlOutputLabel COMP_POL_SRC_OF_BUS_LABEL) {
	this.COMP_POL_SRC_OF_BUS_LABEL = COMP_POL_SRC_OF_BUS_LABEL;
    }

    public void setCOMP_POL_SRC_OF_BUS(HtmlInputText COMP_POL_SRC_OF_BUS) {
	this.COMP_POL_SRC_OF_BUS = COMP_POL_SRC_OF_BUS;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL() {
	return COMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_SRC_OF_BUS_DESC() {
	return COMP_UI_M_POL_SRC_OF_BUS_DESC;
    }

    public void setCOMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL) {
	this.COMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL = COMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_SRC_OF_BUS_DESC(
	    HtmlInputText COMP_UI_M_POL_SRC_OF_BUS_DESC) {
	this.COMP_UI_M_POL_SRC_OF_BUS_DESC = COMP_UI_M_POL_SRC_OF_BUS_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_FC_ADDL_PREM_LABEL() {
	return COMP_POL_FC_ADDL_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_ADDL_PREM() {
	return COMP_POL_FC_ADDL_PREM;
    }

    public void setCOMP_POL_FC_ADDL_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_FC_ADDL_PREM_LABEL) {
	this.COMP_POL_FC_ADDL_PREM_LABEL = COMP_POL_FC_ADDL_PREM_LABEL;
    }

    public void setCOMP_POL_FC_ADDL_PREM(HtmlInputText COMP_POL_FC_ADDL_PREM) {
	this.COMP_POL_FC_ADDL_PREM = COMP_POL_FC_ADDL_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_LC_ADDL_PREM_LABEL() {
	return COMP_POL_LC_ADDL_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_ADDL_PREM() {
	return COMP_POL_LC_ADDL_PREM;
    }

    public void setCOMP_POL_LC_ADDL_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_LC_ADDL_PREM_LABEL) {
	this.COMP_POL_LC_ADDL_PREM_LABEL = COMP_POL_LC_ADDL_PREM_LABEL;
    }

    public void setCOMP_POL_LC_ADDL_PREM(HtmlInputText COMP_POL_LC_ADDL_PREM) {
	this.COMP_POL_LC_ADDL_PREM = COMP_POL_LC_ADDL_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_FC_TOT_SA_LABEL() {
	return COMP_POL_FC_TOT_SA_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_TOT_SA() {
	return COMP_POL_FC_TOT_SA;
    }

    public void setCOMP_POL_FC_TOT_SA_LABEL(
	    HtmlOutputLabel COMP_POL_FC_TOT_SA_LABEL) {
	this.COMP_POL_FC_TOT_SA_LABEL = COMP_POL_FC_TOT_SA_LABEL;
    }

    public void setCOMP_POL_FC_TOT_SA(HtmlInputText COMP_POL_FC_TOT_SA) {
	this.COMP_POL_FC_TOT_SA = COMP_POL_FC_TOT_SA;
    }

    public HtmlOutputLabel getCOMP_POL_LC_TOT_SA_LABEL() {
	return COMP_POL_LC_TOT_SA_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_TOT_SA() {
	return COMP_POL_LC_TOT_SA;
    }

    public void setCOMP_POL_LC_TOT_SA_LABEL(
	    HtmlOutputLabel COMP_POL_LC_TOT_SA_LABEL) {
	this.COMP_POL_LC_TOT_SA_LABEL = COMP_POL_LC_TOT_SA_LABEL;
    }

    public void setCOMP_POL_LC_TOT_SA(HtmlInputText COMP_POL_LC_TOT_SA) {
	this.COMP_POL_LC_TOT_SA = COMP_POL_LC_TOT_SA;
    }

    public HtmlOutputLabel getCOMP_POL_PROP_RECV_DT_LABEL() {
	return COMP_POL_PROP_RECV_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_PROP_RECV_DT() {
	return COMP_POL_PROP_RECV_DT;
    }

    public void setCOMP_POL_PROP_RECV_DT_LABEL(
	    HtmlOutputLabel COMP_POL_PROP_RECV_DT_LABEL) {
	this.COMP_POL_PROP_RECV_DT_LABEL = COMP_POL_PROP_RECV_DT_LABEL;
    }

    public void setCOMP_POL_PROP_RECV_DT(HtmlCalendar COMP_POL_PROP_RECV_DT) {
	this.COMP_POL_PROP_RECV_DT = COMP_POL_PROP_RECV_DT;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_DEATH_LOAD_LABEL() {
	return COMP_UI_M_FC_DEATH_LOAD_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_DEATH_LOAD() {
	return COMP_UI_M_FC_DEATH_LOAD;
    }

    public void setCOMP_UI_M_FC_DEATH_LOAD_LABEL(
	    HtmlOutputLabel COMP_UI_M_FC_DEATH_LOAD_LABEL) {
	this.COMP_UI_M_FC_DEATH_LOAD_LABEL = COMP_UI_M_FC_DEATH_LOAD_LABEL;
    }

    public void setCOMP_UI_M_FC_DEATH_LOAD(HtmlInputText COMP_UI_M_FC_DEATH_LOAD) {
	this.COMP_UI_M_FC_DEATH_LOAD = COMP_UI_M_FC_DEATH_LOAD;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_DEATH_LOAD_LABEL() {
	return COMP_UI_M_LC_DEATH_LOAD_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_DEATH_LOAD() {
	return COMP_UI_M_LC_DEATH_LOAD;
    }

    public void setCOMP_UI_M_LC_DEATH_LOAD_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_DEATH_LOAD_LABEL) {
	this.COMP_UI_M_LC_DEATH_LOAD_LABEL = COMP_UI_M_LC_DEATH_LOAD_LABEL;
    }

    public void setCOMP_UI_M_LC_DEATH_LOAD(HtmlInputText COMP_UI_M_LC_DEATH_LOAD) {
	this.COMP_UI_M_LC_DEATH_LOAD = COMP_UI_M_LC_DEATH_LOAD;
    }

    public HtmlOutputLabel getCOMP_POL_FLEX_02_LABEL() {
	return COMP_POL_FLEX_02_LABEL;
    }

    public HtmlInputText getCOMP_POL_FLEX_02() {
	return COMP_POL_FLEX_02;
    }

    public void setCOMP_POL_FLEX_02_LABEL(HtmlOutputLabel COMP_POL_FLEX_02_LABEL) {
	this.COMP_POL_FLEX_02_LABEL = COMP_POL_FLEX_02_LABEL;
    }

    public void setCOMP_POL_FLEX_02(HtmlInputText COMP_POL_FLEX_02) {
	this.COMP_POL_FLEX_02 = COMP_POL_FLEX_02;
    }

    public HtmlOutputLabel getCOMP_POL_INCORPORATED_YN_LABEL() {
	return COMP_POL_INCORPORATED_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_INCORPORATED_YN() {
	return COMP_POL_INCORPORATED_YN;
    }

    public void setCOMP_POL_INCORPORATED_YN_LABEL(
	    HtmlOutputLabel COMP_POL_INCORPORATED_YN_LABEL) {
	this.COMP_POL_INCORPORATED_YN_LABEL = COMP_POL_INCORPORATED_YN_LABEL;
    }

    public void setCOMP_POL_INCORPORATED_YN(
	    HtmlSelectOneMenu COMP_POL_INCORPORATED_YN) {
	this.COMP_POL_INCORPORATED_YN = COMP_POL_INCORPORATED_YN;
    }

    public HtmlOutputLabel getCOMP_POL_SUB_PLAN_CODE_LABEL() {
	return COMP_POL_SUB_PLAN_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_SUB_PLAN_CODE() {
	return COMP_POL_SUB_PLAN_CODE;
    }

    public void setCOMP_POL_SUB_PLAN_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_SUB_PLAN_CODE_LABEL) {
	this.COMP_POL_SUB_PLAN_CODE_LABEL = COMP_POL_SUB_PLAN_CODE_LABEL;
    }

    public void setCOMP_POL_SUB_PLAN_CODE(HtmlInputText COMP_POL_SUB_PLAN_CODE) {
	this.COMP_POL_SUB_PLAN_CODE = COMP_POL_SUB_PLAN_CODE;
    }

    public HtmlOutputLabel getCOMP_POL_NET_PREM_YN_LABEL() {
	return COMP_POL_NET_PREM_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_NET_PREM_YN() {
	return COMP_POL_NET_PREM_YN;
    }

    public void setCOMP_POL_NET_PREM_YN_LABEL(
	    HtmlOutputLabel COMP_POL_NET_PREM_YN_LABEL) {
	this.COMP_POL_NET_PREM_YN_LABEL = COMP_POL_NET_PREM_YN_LABEL;
    }

    public void setCOMP_POL_NET_PREM_YN(HtmlSelectOneMenu COMP_POL_NET_PREM_YN) {
	this.COMP_POL_NET_PREM_YN = COMP_POL_NET_PREM_YN;
    }

    public HtmlOutputLabel getCOMP_POL_CONT_CODE_LABEL() {
	return COMP_POL_CONT_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_CONT_CODE() {
	return COMP_POL_CONT_CODE;
    }

    public void setCOMP_POL_CONT_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_CONT_CODE_LABEL) {
	this.COMP_POL_CONT_CODE_LABEL = COMP_POL_CONT_CODE_LABEL;
    }

    public void setCOMP_POL_CONT_CODE(HtmlInputText COMP_POL_CONT_CODE) {
	this.COMP_POL_CONT_CODE = COMP_POL_CONT_CODE;
    }

    public HtmlOutputLabel getCOMP_POL_ASSURED_NAME_LABEL() {
	return COMP_POL_ASSURED_NAME_LABEL;
    }

    public HtmlInputText getCOMP_POL_ASSURED_NAME() {
	return COMP_POL_ASSURED_NAME;
    }

    public void setCOMP_POL_ASSURED_NAME_LABEL(
	    HtmlOutputLabel COMP_POL_ASSURED_NAME_LABEL) {
	this.COMP_POL_ASSURED_NAME_LABEL = COMP_POL_ASSURED_NAME_LABEL;
    }

    public void setCOMP_POL_ASSURED_NAME(HtmlInputText COMP_POL_ASSURED_NAME) {
	this.COMP_POL_ASSURED_NAME = COMP_POL_ASSURED_NAME;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_FC_TOT_PREM_LABEL() {
	return COMP_UI_M_POL_FC_TOT_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_FC_TOT_PREM() {
	return COMP_UI_M_POL_FC_TOT_PREM;
    }

    public void setCOMP_UI_M_POL_FC_TOT_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_FC_TOT_PREM_LABEL) {
	this.COMP_UI_M_POL_FC_TOT_PREM_LABEL = COMP_UI_M_POL_FC_TOT_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_FC_TOT_PREM(
	    HtmlInputText COMP_UI_M_POL_FC_TOT_PREM) {
	this.COMP_UI_M_POL_FC_TOT_PREM = COMP_UI_M_POL_FC_TOT_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_PREM_LABEL() {
	return COMP_UI_M_POL_LC_TOT_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_TOT_PREM() {
	return COMP_UI_M_POL_LC_TOT_PREM;
    }

    public void setCOMP_UI_M_POL_LC_TOT_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_TOT_PREM_LABEL) {
	this.COMP_UI_M_POL_LC_TOT_PREM_LABEL = COMP_UI_M_POL_LC_TOT_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_TOT_PREM(
	    HtmlInputText COMP_UI_M_POL_LC_TOT_PREM) {
	this.COMP_UI_M_POL_LC_TOT_PREM = COMP_UI_M_POL_LC_TOT_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_FC_PREM_LABEL() {
	return COMP_UI_M_POL_FC_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_FC_PREM() {
	return COMP_UI_M_POL_FC_PREM;
    }

    public void setCOMP_UI_M_POL_FC_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_FC_PREM_LABEL) {
	this.COMP_UI_M_POL_FC_PREM_LABEL = COMP_UI_M_POL_FC_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_FC_PREM(HtmlInputText COMP_UI_M_POL_FC_PREM) {
	this.COMP_UI_M_POL_FC_PREM = COMP_UI_M_POL_FC_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_PREM_LABEL() {
	return COMP_UI_M_POL_LC_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_PREM() {
	return COMP_UI_M_POL_LC_PREM;
    }

    public void setCOMP_UI_M_POL_LC_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_PREM_LABEL) {
	this.COMP_UI_M_POL_LC_PREM_LABEL = COMP_UI_M_POL_LC_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_PREM(HtmlInputText COMP_UI_M_POL_LC_PREM) {
	this.COMP_UI_M_POL_LC_PREM = COMP_UI_M_POL_LC_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_PROP_STAMP_DT_LABEL() {
	return COMP_POL_PROP_STAMP_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_PROP_STAMP_DT() {
	return COMP_POL_PROP_STAMP_DT;
    }

    public void setCOMP_POL_PROP_STAMP_DT_LABEL(
	    HtmlOutputLabel COMP_POL_PROP_STAMP_DT_LABEL) {
	this.COMP_POL_PROP_STAMP_DT_LABEL = COMP_POL_PROP_STAMP_DT_LABEL;
    }

    public void setCOMP_POL_PROP_STAMP_DT(HtmlCalendar COMP_POL_PROP_STAMP_DT) {
	this.COMP_POL_PROP_STAMP_DT = COMP_POL_PROP_STAMP_DT;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_TPD_LOAD_LABEL() {
	return COMP_UI_M_FC_TPD_LOAD_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_TPD_LOAD() {
	return COMP_UI_M_FC_TPD_LOAD;
    }

    public void setCOMP_UI_M_FC_TPD_LOAD_LABEL(
	    HtmlOutputLabel COMP_UI_M_FC_TPD_LOAD_LABEL) {
	this.COMP_UI_M_FC_TPD_LOAD_LABEL = COMP_UI_M_FC_TPD_LOAD_LABEL;
    }

    public void setCOMP_UI_M_FC_TPD_LOAD(HtmlInputText COMP_UI_M_FC_TPD_LOAD) {
	this.COMP_UI_M_FC_TPD_LOAD = COMP_UI_M_FC_TPD_LOAD;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_TPD_LOAD_LABEL() {
	return COMP_UI_M_LC_TPD_LOAD_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_TPD_LOAD() {
	return COMP_UI_M_LC_TPD_LOAD;
    }

    public void setCOMP_UI_M_LC_TPD_LOAD_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_TPD_LOAD_LABEL) {
	this.COMP_UI_M_LC_TPD_LOAD_LABEL = COMP_UI_M_LC_TPD_LOAD_LABEL;
    }

    public void setCOMP_UI_M_LC_TPD_LOAD(HtmlInputText COMP_UI_M_LC_TPD_LOAD) {
	this.COMP_UI_M_LC_TPD_LOAD = COMP_UI_M_LC_TPD_LOAD;
    }

    public HtmlOutputLabel getCOMP_POL_FLEX_03_LABEL() {
	return COMP_POL_FLEX_03_LABEL;
    }

    public HtmlInputText getCOMP_POL_FLEX_03() {
	return COMP_POL_FLEX_03;
    }

    public void setCOMP_POL_FLEX_03_LABEL(HtmlOutputLabel COMP_POL_FLEX_03_LABEL) {
	this.COMP_POL_FLEX_03_LABEL = COMP_POL_FLEX_03_LABEL;
    }

    public void setCOMP_POL_FLEX_03(HtmlInputText COMP_POL_FLEX_03) {
	this.COMP_POL_FLEX_03 = COMP_POL_FLEX_03;
    }

    public HtmlOutputLabel getCOMP_POL_GRANTEE_NAME_LABEL() {
	return COMP_POL_GRANTEE_NAME_LABEL;
    }

    public HtmlInputText getCOMP_POL_GRANTEE_NAME() {
	return COMP_POL_GRANTEE_NAME;
    }

    public void setCOMP_POL_GRANTEE_NAME_LABEL(
	    HtmlOutputLabel COMP_POL_GRANTEE_NAME_LABEL) {
	this.COMP_POL_GRANTEE_NAME_LABEL = COMP_POL_GRANTEE_NAME_LABEL;
    }

    public void setCOMP_POL_GRANTEE_NAME(HtmlInputText COMP_POL_GRANTEE_NAME) {
	this.COMP_POL_GRANTEE_NAME = COMP_POL_GRANTEE_NAME;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL() {
	return COMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_SUB_PLAN_CODE_DESC() {
	return COMP_UI_M_POL_SUB_PLAN_CODE_DESC;
    }

    public void setCOMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL) {
	this.COMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL = COMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_SUB_PLAN_CODE_DESC(
	    HtmlInputText COMP_UI_M_POL_SUB_PLAN_CODE_DESC) {
	this.COMP_UI_M_POL_SUB_PLAN_CODE_DESC = COMP_UI_M_POL_SUB_PLAN_CODE_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_GRANTEE_TYPE_LABEL() {
	return COMP_POL_GRANTEE_TYPE_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_GRANTEE_TYPE() {
	return COMP_POL_GRANTEE_TYPE;
    }

    public void setCOMP_POL_GRANTEE_TYPE_LABEL(
	    HtmlOutputLabel COMP_POL_GRANTEE_TYPE_LABEL) {
	this.COMP_POL_GRANTEE_TYPE_LABEL = COMP_POL_GRANTEE_TYPE_LABEL;
    }

    public void setCOMP_POL_GRANTEE_TYPE(HtmlSelectOneMenu COMP_POL_GRANTEE_TYPE) {
	this.COMP_POL_GRANTEE_TYPE = COMP_POL_GRANTEE_TYPE;
    }

    public HtmlOutputLabel getCOMP_POL_PERIOD_LABEL() {
	return COMP_POL_PERIOD_LABEL;
    }

    public HtmlInputText getCOMP_POL_PERIOD() {
	return COMP_POL_PERIOD;
    }

    public void setCOMP_POL_PERIOD_LABEL(HtmlOutputLabel COMP_POL_PERIOD_LABEL) {
	this.COMP_POL_PERIOD_LABEL = COMP_POL_PERIOD_LABEL;
    }

    public void setCOMP_POL_PERIOD(HtmlInputText COMP_POL_PERIOD) {
	this.COMP_POL_PERIOD = COMP_POL_PERIOD;
    }

    public HtmlOutputLabel getCOMP_POL_PREM_PAY_YRS_LABEL() {
	return COMP_POL_PREM_PAY_YRS_LABEL;
    }

    public HtmlInputText getCOMP_POL_PREM_PAY_YRS() {
	return COMP_POL_PREM_PAY_YRS;
    }

    public void setCOMP_POL_PREM_PAY_YRS_LABEL(
	    HtmlOutputLabel COMP_POL_PREM_PAY_YRS_LABEL) {
	this.COMP_POL_PREM_PAY_YRS_LABEL = COMP_POL_PREM_PAY_YRS_LABEL;
    }

    public void setCOMP_POL_PREM_PAY_YRS(HtmlInputText COMP_POL_PREM_PAY_YRS) {
	this.COMP_POL_PREM_PAY_YRS = COMP_POL_PREM_PAY_YRS;
    }

    public HtmlOutputLabel getCOMP_POL_FC_NETT_PREM_LABEL() {
	return COMP_POL_FC_NETT_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_NETT_PREM() {
	return COMP_POL_FC_NETT_PREM;
    }

    public void setCOMP_POL_FC_NETT_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_FC_NETT_PREM_LABEL) {
	this.COMP_POL_FC_NETT_PREM_LABEL = COMP_POL_FC_NETT_PREM_LABEL;
    }

    public void setCOMP_POL_FC_NETT_PREM(HtmlInputText COMP_POL_FC_NETT_PREM) {
	this.COMP_POL_FC_NETT_PREM = COMP_POL_FC_NETT_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_LC_NETT_PREM_LABEL() {
	return COMP_POL_LC_NETT_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_NETT_PREM() {
	return COMP_POL_LC_NETT_PREM;
    }

    public void setCOMP_POL_LC_NETT_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_LC_NETT_PREM_LABEL) {
	this.COMP_POL_LC_NETT_PREM_LABEL = COMP_POL_LC_NETT_PREM_LABEL;
    }

    public void setCOMP_POL_LC_NETT_PREM(HtmlInputText COMP_POL_LC_NETT_PREM) {
	this.COMP_POL_LC_NETT_PREM = COMP_POL_LC_NETT_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_FC_TOT_LOADING_LABEL() {
	return COMP_UI_M_POL_FC_TOT_LOADING_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_FC_TOT_LOADING() {
	return COMP_UI_M_POL_FC_TOT_LOADING;
    }

    public void setCOMP_UI_M_POL_FC_TOT_LOADING_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_FC_TOT_LOADING_LABEL) {
	this.COMP_UI_M_POL_FC_TOT_LOADING_LABEL = COMP_UI_M_POL_FC_TOT_LOADING_LABEL;
    }

    public void setCOMP_UI_M_POL_FC_TOT_LOADING(
	    HtmlInputText COMP_UI_M_POL_FC_TOT_LOADING) {
	this.COMP_UI_M_POL_FC_TOT_LOADING = COMP_UI_M_POL_FC_TOT_LOADING;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_LOADING_LABEL() {
	return COMP_UI_M_POL_LC_TOT_LOADING_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_TOT_LOADING() {
	return COMP_UI_M_POL_LC_TOT_LOADING;
    }

    public void setCOMP_UI_M_POL_LC_TOT_LOADING_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_TOT_LOADING_LABEL) {
	this.COMP_UI_M_POL_LC_TOT_LOADING_LABEL = COMP_UI_M_POL_LC_TOT_LOADING_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_TOT_LOADING(
	    HtmlInputText COMP_UI_M_POL_LC_TOT_LOADING) {
	this.COMP_UI_M_POL_LC_TOT_LOADING = COMP_UI_M_POL_LC_TOT_LOADING;
    }

    public HtmlOutputLabel getCOMP_POL_PROP_DECL_DT_LABEL() {
	return COMP_POL_PROP_DECL_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_PROP_DECL_DT() {
	return COMP_POL_PROP_DECL_DT;
    }

    public void setCOMP_POL_PROP_DECL_DT_LABEL(
	    HtmlOutputLabel COMP_POL_PROP_DECL_DT_LABEL) {
	this.COMP_POL_PROP_DECL_DT_LABEL = COMP_POL_PROP_DECL_DT_LABEL;
    }

    public void setCOMP_POL_PROP_DECL_DT(HtmlCalendar COMP_POL_PROP_DECL_DT) {
	this.COMP_POL_PROP_DECL_DT = COMP_POL_PROP_DECL_DT;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_MED_LOAD_LABEL() {
	return COMP_UI_M_FC_MED_LOAD_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_MED_LOAD() {
	return COMP_UI_M_FC_MED_LOAD;
    }

    public void setCOMP_UI_M_FC_MED_LOAD_LABEL(
	    HtmlOutputLabel COMP_UI_M_FC_MED_LOAD_LABEL) {
	this.COMP_UI_M_FC_MED_LOAD_LABEL = COMP_UI_M_FC_MED_LOAD_LABEL;
    }

    public void setCOMP_UI_M_FC_MED_LOAD(HtmlInputText COMP_UI_M_FC_MED_LOAD) {
	this.COMP_UI_M_FC_MED_LOAD = COMP_UI_M_FC_MED_LOAD;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_MED_LOAD_LABEL() {
	return COMP_UI_M_LC_MED_LOAD_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_MED_LOAD() {
	return COMP_UI_M_LC_MED_LOAD;
    }

    public void setCOMP_UI_M_LC_MED_LOAD_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_MED_LOAD_LABEL) {
	this.COMP_UI_M_LC_MED_LOAD_LABEL = COMP_UI_M_LC_MED_LOAD_LABEL;
    }

    public void setCOMP_UI_M_LC_MED_LOAD(HtmlInputText COMP_UI_M_LC_MED_LOAD) {
	this.COMP_UI_M_LC_MED_LOAD = COMP_UI_M_LC_MED_LOAD;
    }

    public HtmlOutputLabel getCOMP_POL_LC_TOP_UP_AMT_LABEL() {
	return COMP_POL_LC_TOP_UP_AMT_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_TOP_UP_AMT() {
	return COMP_POL_LC_TOP_UP_AMT;
    }

    public void setCOMP_POL_LC_TOP_UP_AMT_LABEL(
	    HtmlOutputLabel COMP_POL_LC_TOP_UP_AMT_LABEL) {
	this.COMP_POL_LC_TOP_UP_AMT_LABEL = COMP_POL_LC_TOP_UP_AMT_LABEL;
    }

    public void setCOMP_POL_LC_TOP_UP_AMT(HtmlInputText COMP_POL_LC_TOP_UP_AMT) {
	this.COMP_POL_LC_TOP_UP_AMT = COMP_POL_LC_TOP_UP_AMT;
    }

    public HtmlOutputLabel getCOMP_POL_INTRODUCER_REF_ID1_LABEL() {
	return COMP_POL_INTRODUCER_REF_ID1_LABEL;
    }

    public HtmlInputText getCOMP_POL_INTRODUCER_REF_ID1() {
	return COMP_POL_INTRODUCER_REF_ID1;
    }

    public void setCOMP_POL_INTRODUCER_REF_ID1_LABEL(
	    HtmlOutputLabel COMP_POL_INTRODUCER_REF_ID1_LABEL) {
	this.COMP_POL_INTRODUCER_REF_ID1_LABEL = COMP_POL_INTRODUCER_REF_ID1_LABEL;
    }

    public void setCOMP_POL_INTRODUCER_REF_ID1(
	    HtmlInputText COMP_POL_INTRODUCER_REF_ID1) {
	this.COMP_POL_INTRODUCER_REF_ID1 = COMP_POL_INTRODUCER_REF_ID1;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_INTRODUCER_REF_ID1_DESC_LABEL() {
	return COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_INTRODUCER_REF_ID1_DESC() {
	return COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC;
    }

    public void setCOMP_UI_M_POL_INTRODUCER_REF_ID1_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC_LABEL) {
	this.COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC_LABEL = COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_INTRODUCER_REF_ID1_DESC(
	    HtmlInputText COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC) {
	this.COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC = COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_BANK_BRANCH_NAME_LABEL() {
	return COMP_POL_BANK_BRANCH_NAME_LABEL;
    }

    public HtmlInputText getCOMP_POL_BANK_BRANCH_NAME() {
	return COMP_POL_BANK_BRANCH_NAME;
    }

    public void setCOMP_POL_BANK_BRANCH_NAME_LABEL(
	    HtmlOutputLabel COMP_POL_BANK_BRANCH_NAME_LABEL) {
	this.COMP_POL_BANK_BRANCH_NAME_LABEL = COMP_POL_BANK_BRANCH_NAME_LABEL;
    }

    public void setCOMP_POL_BANK_BRANCH_NAME(
	    HtmlInputText COMP_POL_BANK_BRANCH_NAME) {
	this.COMP_POL_BANK_BRANCH_NAME = COMP_POL_BANK_BRANCH_NAME;
    }

    public HtmlOutputLabel getCOMP_UI_M_BRANCH_CODE_DESC_LABEL() {
	return COMP_UI_M_BRANCH_CODE_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_BRANCH_CODE_DESC() {
	return COMP_UI_M_BRANCH_CODE_DESC;
    }

    public void setCOMP_UI_M_BRANCH_CODE_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_BRANCH_CODE_DESC_LABEL) {
	this.COMP_UI_M_BRANCH_CODE_DESC_LABEL = COMP_UI_M_BRANCH_CODE_DESC_LABEL;
    }

    public void setCOMP_UI_M_BRANCH_CODE_DESC(
	    HtmlInputText COMP_UI_M_BRANCH_CODE_DESC) {
	this.COMP_UI_M_BRANCH_CODE_DESC = COMP_UI_M_BRANCH_CODE_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_START_DT_LABEL() {
	return COMP_POL_START_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_START_DT() {
	return COMP_POL_START_DT;
    }

    public void setCOMP_POL_START_DT_LABEL(
	    HtmlOutputLabel COMP_POL_START_DT_LABEL) {
	this.COMP_POL_START_DT_LABEL = COMP_POL_START_DT_LABEL;
    }

    public void setCOMP_POL_START_DT(HtmlCalendar COMP_POL_START_DT) {
	this.COMP_POL_START_DT = COMP_POL_START_DT;
    }

    public HtmlOutputLabel getCOMP_POL_EXPIRY_DT_LABEL() {
	return COMP_POL_EXPIRY_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_EXPIRY_DT() {
	return COMP_POL_EXPIRY_DT;
    }

    public void setCOMP_POL_EXPIRY_DT_LABEL(
	    HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL) {
	this.COMP_POL_EXPIRY_DT_LABEL = COMP_POL_EXPIRY_DT_LABEL;
    }

    public void setCOMP_POL_EXPIRY_DT(HtmlCalendar COMP_POL_EXPIRY_DT) {
	this.COMP_POL_EXPIRY_DT = COMP_POL_EXPIRY_DT;
    }

    public HtmlOutputLabel getCOMP_POL_DIVN_CODE_LABEL() {
	return COMP_POL_DIVN_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_DIVN_CODE() {
	return COMP_POL_DIVN_CODE;
    }

    public void setCOMP_POL_DIVN_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_DIVN_CODE_LABEL) {
	this.COMP_POL_DIVN_CODE_LABEL = COMP_POL_DIVN_CODE_LABEL;
    }

    public void setCOMP_POL_DIVN_CODE(HtmlInputText COMP_POL_DIVN_CODE) {
	this.COMP_POL_DIVN_CODE = COMP_POL_DIVN_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL() {
	return COMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_FC_TOT_DISCOUNT() {
	return COMP_UI_M_POL_FC_TOT_DISCOUNT;
    }

    public void setCOMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL) {
	this.COMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL = COMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL;
    }

    public void setCOMP_UI_M_POL_FC_TOT_DISCOUNT(
	    HtmlInputText COMP_UI_M_POL_FC_TOT_DISCOUNT) {
	this.COMP_UI_M_POL_FC_TOT_DISCOUNT = COMP_UI_M_POL_FC_TOT_DISCOUNT;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL() {
	return COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_TOT_DISCOUNT() {
	return COMP_UI_M_POL_LC_TOT_DISCOUNT;
    }

    public void setCOMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL) {
	this.COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL = COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_TOT_DISCOUNT(
	    HtmlInputText COMP_UI_M_POL_LC_TOT_DISCOUNT) {
	this.COMP_UI_M_POL_LC_TOT_DISCOUNT = COMP_UI_M_POL_LC_TOT_DISCOUNT;
    }

    public HtmlOutputLabel getCOMP_POL_FC_CURR_SA_LABEL() {
	return COMP_POL_FC_CURR_SA_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_CURR_SA() {
	return COMP_POL_FC_CURR_SA;
    }

    public void setCOMP_POL_FC_CURR_SA_LABEL(
	    HtmlOutputLabel COMP_POL_FC_CURR_SA_LABEL) {
	this.COMP_POL_FC_CURR_SA_LABEL = COMP_POL_FC_CURR_SA_LABEL;
    }

    public void setCOMP_POL_FC_CURR_SA(HtmlInputText COMP_POL_FC_CURR_SA) {
	this.COMP_POL_FC_CURR_SA = COMP_POL_FC_CURR_SA;
    }

    public HtmlOutputLabel getCOMP_POL_LC_CURR_SA_LABEL() {
	return COMP_POL_LC_CURR_SA_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_CURR_SA() {
	return COMP_POL_LC_CURR_SA;
    }

    public void setCOMP_POL_LC_CURR_SA_LABEL(
	    HtmlOutputLabel COMP_POL_LC_CURR_SA_LABEL) {
	this.COMP_POL_LC_CURR_SA_LABEL = COMP_POL_LC_CURR_SA_LABEL;
    }

    public void setCOMP_POL_LC_CURR_SA(HtmlInputText COMP_POL_LC_CURR_SA) {
	this.COMP_POL_LC_CURR_SA = COMP_POL_LC_CURR_SA;
    }

    public HtmlOutputLabel getCOMP_POL_FC_TOP_UP_AMT_LABEL() {
	return COMP_POL_FC_TOP_UP_AMT_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_TOP_UP_AMT() {
	return COMP_POL_FC_TOP_UP_AMT;
    }

    public void setCOMP_POL_FC_TOP_UP_AMT_LABEL(
	    HtmlOutputLabel COMP_POL_FC_TOP_UP_AMT_LABEL) {
	this.COMP_POL_FC_TOP_UP_AMT_LABEL = COMP_POL_FC_TOP_UP_AMT_LABEL;
    }

    public void setCOMP_POL_FC_TOP_UP_AMT(HtmlInputText COMP_POL_FC_TOP_UP_AMT) {
	this.COMP_POL_FC_TOP_UP_AMT = COMP_POL_FC_TOP_UP_AMT;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_OCC_LOAD_LABEL() {
	return COMP_UI_M_FC_OCC_LOAD_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_OCC_LOAD() {
	return COMP_UI_M_FC_OCC_LOAD;
    }

    public void setCOMP_UI_M_FC_OCC_LOAD_LABEL(
	    HtmlOutputLabel COMP_UI_M_FC_OCC_LOAD_LABEL) {
	this.COMP_UI_M_FC_OCC_LOAD_LABEL = COMP_UI_M_FC_OCC_LOAD_LABEL;
    }

    public void setCOMP_UI_M_FC_OCC_LOAD(HtmlInputText COMP_UI_M_FC_OCC_LOAD) {
	this.COMP_UI_M_FC_OCC_LOAD = COMP_UI_M_FC_OCC_LOAD;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_OCC_LOAD_LABEL() {
	return COMP_UI_M_LC_OCC_LOAD_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_OCC_LOAD() {
	return COMP_UI_M_LC_OCC_LOAD;
    }

    public void setCOMP_UI_M_LC_OCC_LOAD_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_OCC_LOAD_LABEL) {
	this.COMP_UI_M_LC_OCC_LOAD_LABEL = COMP_UI_M_LC_OCC_LOAD_LABEL;
    }

    public void setCOMP_UI_M_LC_OCC_LOAD(HtmlInputText COMP_UI_M_LC_OCC_LOAD) {
	this.COMP_UI_M_LC_OCC_LOAD = COMP_UI_M_LC_OCC_LOAD;
    }

    public HtmlOutputLabel getCOMP_POL_RATE_APPLIED_ON_LABEL() {
	return COMP_POL_RATE_APPLIED_ON_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_RATE_APPLIED_ON() {
	return COMP_POL_RATE_APPLIED_ON;
    }

    public void setCOMP_POL_RATE_APPLIED_ON_LABEL(
	    HtmlOutputLabel COMP_POL_RATE_APPLIED_ON_LABEL) {
	this.COMP_POL_RATE_APPLIED_ON_LABEL = COMP_POL_RATE_APPLIED_ON_LABEL;
    }

    public void setCOMP_POL_RATE_APPLIED_ON(
	    HtmlSelectOneMenu COMP_POL_RATE_APPLIED_ON) {
	this.COMP_POL_RATE_APPLIED_ON = COMP_POL_RATE_APPLIED_ON;
    }

    public HtmlOutputLabel getCOMP_POL_BANK_REF_NO_LABEL() {
	return COMP_POL_BANK_REF_NO_LABEL;
    }

    public HtmlInputText getCOMP_POL_BANK_REF_NO() {
	return COMP_POL_BANK_REF_NO;
    }

    public void setCOMP_POL_BANK_REF_NO_LABEL(
	    HtmlOutputLabel COMP_POL_BANK_REF_NO_LABEL) {
	this.COMP_POL_BANK_REF_NO_LABEL = COMP_POL_BANK_REF_NO_LABEL;
    }

    public void setCOMP_POL_BANK_REF_NO(HtmlInputText COMP_POL_BANK_REF_NO) {
	this.COMP_POL_BANK_REF_NO = COMP_POL_BANK_REF_NO;
    }

    public HtmlOutputLabel getCOMP_POL_SA_CURR_CODE_LABEL() {
	return COMP_POL_SA_CURR_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_SA_CURR_CODE() {
	return COMP_POL_SA_CURR_CODE;
    }

    public void setCOMP_POL_SA_CURR_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_SA_CURR_CODE_LABEL) {
	this.COMP_POL_SA_CURR_CODE_LABEL = COMP_POL_SA_CURR_CODE_LABEL;
    }

    public void setCOMP_POL_SA_CURR_CODE(HtmlInputText COMP_POL_SA_CURR_CODE) {
	this.COMP_POL_SA_CURR_CODE = COMP_POL_SA_CURR_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_SA_CURR_DESC_LABEL() {
	return COMP_UI_M_POL_SA_CURR_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_SA_CURR_DESC() {
	return COMP_UI_M_POL_SA_CURR_DESC;
    }

    public void setCOMP_UI_M_POL_SA_CURR_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_SA_CURR_DESC_LABEL) {
	this.COMP_UI_M_POL_SA_CURR_DESC_LABEL = COMP_UI_M_POL_SA_CURR_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_SA_CURR_DESC(
	    HtmlInputText COMP_UI_M_POL_SA_CURR_DESC) {
	this.COMP_UI_M_POL_SA_CURR_DESC = COMP_UI_M_POL_SA_CURR_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_SA_EXCH_RATE_LABEL() {
	return COMP_POL_SA_EXCH_RATE_LABEL;
    }

    public HtmlInputText getCOMP_POL_SA_EXCH_RATE() {
	return COMP_POL_SA_EXCH_RATE;
    }

    public void setCOMP_POL_SA_EXCH_RATE_LABEL(
	    HtmlOutputLabel COMP_POL_SA_EXCH_RATE_LABEL) {
	this.COMP_POL_SA_EXCH_RATE_LABEL = COMP_POL_SA_EXCH_RATE_LABEL;
    }

    public void setCOMP_POL_SA_EXCH_RATE(HtmlInputText COMP_POL_SA_EXCH_RATE) {
	this.COMP_POL_SA_EXCH_RATE = COMP_POL_SA_EXCH_RATE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_DIVN_DESC_LABEL() {
	return COMP_UI_M_POL_DIVN_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_DIVN_DESC() {
	return COMP_UI_M_POL_DIVN_DESC;
    }

    public void setCOMP_UI_M_POL_DIVN_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_DIVN_DESC_LABEL) {
	this.COMP_UI_M_POL_DIVN_DESC_LABEL = COMP_UI_M_POL_DIVN_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_DIVN_DESC(HtmlInputText COMP_UI_M_POL_DIVN_DESC) {
	this.COMP_UI_M_POL_DIVN_DESC = COMP_UI_M_POL_DIVN_DESC;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL() {
	return COMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_PCHARGES_BORNE_CUST() {
	return COMP_UI_M_FC_PCHARGES_BORNE_CUST;
    }

    public void setCOMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL(
	    HtmlOutputLabel COMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL) {
	this.COMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL = COMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL;
    }

    public void setCOMP_UI_M_FC_PCHARGES_BORNE_CUST(
	    HtmlInputText COMP_UI_M_FC_PCHARGES_BORNE_CUST) {
	this.COMP_UI_M_FC_PCHARGES_BORNE_CUST = COMP_UI_M_FC_PCHARGES_BORNE_CUST;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL() {
	return COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_PCHARGES_BORNE_CUST() {
	return COMP_UI_M_LC_PCHARGES_BORNE_CUST;
    }

    public void setCOMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL) {
	this.COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL = COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL;
    }

    public void setCOMP_UI_M_LC_PCHARGES_BORNE_CUST(
	    HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_CUST) {
	this.COMP_UI_M_LC_PCHARGES_BORNE_CUST = COMP_UI_M_LC_PCHARGES_BORNE_CUST;
    }

    public HtmlOutputLabel getCOMP_POL_ORG_PROP_RECV_YN_LABEL() {
	return COMP_POL_ORG_PROP_RECV_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_ORG_PROP_RECV_YN() {
	return COMP_POL_ORG_PROP_RECV_YN;
    }

    public void setCOMP_POL_ORG_PROP_RECV_YN_LABEL(
	    HtmlOutputLabel COMP_POL_ORG_PROP_RECV_YN_LABEL) {
	this.COMP_POL_ORG_PROP_RECV_YN_LABEL = COMP_POL_ORG_PROP_RECV_YN_LABEL;
    }

    public void setCOMP_POL_ORG_PROP_RECV_YN(
	    HtmlSelectOneMenu COMP_POL_ORG_PROP_RECV_YN) {
	this.COMP_POL_ORG_PROP_RECV_YN = COMP_POL_ORG_PROP_RECV_YN;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_GROSS_CONT_LABEL() {
	return COMP_UI_M_FC_GROSS_CONT_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_GROSS_CONT() {
	return COMP_UI_M_FC_GROSS_CONT;
    }

    public void setCOMP_UI_M_FC_GROSS_CONT_LABEL(
	    HtmlOutputLabel COMP_UI_M_FC_GROSS_CONT_LABEL) {
	this.COMP_UI_M_FC_GROSS_CONT_LABEL = COMP_UI_M_FC_GROSS_CONT_LABEL;
    }

    public void setCOMP_UI_M_FC_GROSS_CONT(HtmlInputText COMP_UI_M_FC_GROSS_CONT) {
	this.COMP_UI_M_FC_GROSS_CONT = COMP_UI_M_FC_GROSS_CONT;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_GROSS_CONT_LABEL() {
	return COMP_UI_M_LC_GROSS_CONT_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_GROSS_CONT() {
	return COMP_UI_M_LC_GROSS_CONT;
    }

    public void setCOMP_UI_M_LC_GROSS_CONT_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_GROSS_CONT_LABEL) {
	this.COMP_UI_M_LC_GROSS_CONT_LABEL = COMP_UI_M_LC_GROSS_CONT_LABEL;
    }

    public void setCOMP_UI_M_LC_GROSS_CONT(HtmlInputText COMP_UI_M_LC_GROSS_CONT) {
	this.COMP_UI_M_LC_GROSS_CONT = COMP_UI_M_LC_GROSS_CONT;
    }

    public HtmlOutputLabel getCOMP_POL_LC_EXC_INT_AMT_LABEL() {
	return COMP_POL_LC_EXC_INT_AMT_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_EXC_INT_AMT() {
	return COMP_POL_LC_EXC_INT_AMT;
    }

    public void setCOMP_POL_LC_EXC_INT_AMT_LABEL(
	    HtmlOutputLabel COMP_POL_LC_EXC_INT_AMT_LABEL) {
	this.COMP_POL_LC_EXC_INT_AMT_LABEL = COMP_POL_LC_EXC_INT_AMT_LABEL;
    }

    public void setCOMP_POL_LC_EXC_INT_AMT(HtmlInputText COMP_POL_LC_EXC_INT_AMT) {
	this.COMP_POL_LC_EXC_INT_AMT = COMP_POL_LC_EXC_INT_AMT;
    }

    public HtmlOutputLabel getCOMP_POL_NL_FM_DT_LABEL() {
	return COMP_POL_NL_FM_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_NL_FM_DT() {
	return COMP_POL_NL_FM_DT;
    }

    public void setCOMP_POL_NL_FM_DT_LABEL(
	    HtmlOutputLabel COMP_POL_NL_FM_DT_LABEL) {
	this.COMP_POL_NL_FM_DT_LABEL = COMP_POL_NL_FM_DT_LABEL;
    }

    public void setCOMP_POL_NL_FM_DT(HtmlCalendar COMP_POL_NL_FM_DT) {
	this.COMP_POL_NL_FM_DT = COMP_POL_NL_FM_DT;
    }

    public HtmlOutputLabel getCOMP_POL_TARIFF_TERM_FLAG_LABEL() {
	return COMP_POL_TARIFF_TERM_FLAG_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_TARIFF_TERM_FLAG() {
	return COMP_POL_TARIFF_TERM_FLAG;
    }

    public void setCOMP_POL_TARIFF_TERM_FLAG_LABEL(
	    HtmlOutputLabel COMP_POL_TARIFF_TERM_FLAG_LABEL) {
	this.COMP_POL_TARIFF_TERM_FLAG_LABEL = COMP_POL_TARIFF_TERM_FLAG_LABEL;
    }

    public void setCOMP_POL_TARIFF_TERM_FLAG(
	    HtmlSelectOneMenu COMP_POL_TARIFF_TERM_FLAG) {
	this.COMP_POL_TARIFF_TERM_FLAG = COMP_POL_TARIFF_TERM_FLAG;
    }

    public HtmlOutputLabel getCOMP_POL_CUST_CURR_CODE_LABEL() {
	return COMP_POL_CUST_CURR_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_CUST_CURR_CODE() {
	return COMP_POL_CUST_CURR_CODE;
    }

    public void setCOMP_POL_CUST_CURR_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_CUST_CURR_CODE_LABEL) {
	this.COMP_POL_CUST_CURR_CODE_LABEL = COMP_POL_CUST_CURR_CODE_LABEL;
    }

    public void setCOMP_POL_CUST_CURR_CODE(HtmlInputText COMP_POL_CUST_CURR_CODE) {
	this.COMP_POL_CUST_CURR_CODE = COMP_POL_CUST_CURR_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_CUST_CURR_DESC_LABEL() {
	return COMP_UI_M_POL_CUST_CURR_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_CUST_CURR_DESC() {
	return COMP_UI_M_POL_CUST_CURR_DESC;
    }

    public void setCOMP_UI_M_POL_CUST_CURR_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_CUST_CURR_DESC_LABEL) {
	this.COMP_UI_M_POL_CUST_CURR_DESC_LABEL = COMP_UI_M_POL_CUST_CURR_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_CUST_CURR_DESC(
	    HtmlInputText COMP_UI_M_POL_CUST_CURR_DESC) {
	this.COMP_UI_M_POL_CUST_CURR_DESC = COMP_UI_M_POL_CUST_CURR_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_CUST_EXCH_RATE_LABEL() {
	return COMP_POL_CUST_EXCH_RATE_LABEL;
    }

    public HtmlInputText getCOMP_POL_CUST_EXCH_RATE() {
	return COMP_POL_CUST_EXCH_RATE;
    }

    public void setCOMP_POL_CUST_EXCH_RATE_LABEL(
	    HtmlOutputLabel COMP_POL_CUST_EXCH_RATE_LABEL) {
	this.COMP_POL_CUST_EXCH_RATE_LABEL = COMP_POL_CUST_EXCH_RATE_LABEL;
    }

    public void setCOMP_POL_CUST_EXCH_RATE(HtmlInputText COMP_POL_CUST_EXCH_RATE) {
	this.COMP_POL_CUST_EXCH_RATE = COMP_POL_CUST_EXCH_RATE;
    }

    public HtmlOutputLabel getCOMP_POL_DEPT_CODE_LABEL() {
	return COMP_POL_DEPT_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_DEPT_CODE() {
	return COMP_POL_DEPT_CODE;
    }

    public void setCOMP_POL_DEPT_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_DEPT_CODE_LABEL) {
	this.COMP_POL_DEPT_CODE_LABEL = COMP_POL_DEPT_CODE_LABEL;
    }

    public void setCOMP_POL_DEPT_CODE(HtmlInputText COMP_POL_DEPT_CODE) {
	this.COMP_POL_DEPT_CODE = COMP_POL_DEPT_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_FC_NET_PREM_LABEL() {
	return COMP_UI_M_POL_FC_NET_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_FC_NET_PREM() {
	return COMP_UI_M_POL_FC_NET_PREM;
    }

    public void setCOMP_UI_M_POL_FC_NET_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_FC_NET_PREM_LABEL) {
	this.COMP_UI_M_POL_FC_NET_PREM_LABEL = COMP_UI_M_POL_FC_NET_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_FC_NET_PREM(
	    HtmlInputText COMP_UI_M_POL_FC_NET_PREM) {
	this.COMP_UI_M_POL_FC_NET_PREM = COMP_UI_M_POL_FC_NET_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_NET_PREM_LABEL() {
	return COMP_UI_M_POL_LC_NET_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_NET_PREM() {
	return COMP_UI_M_POL_LC_NET_PREM;
    }

    public void setCOMP_UI_M_POL_LC_NET_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_NET_PREM_LABEL) {
	this.COMP_UI_M_POL_LC_NET_PREM_LABEL = COMP_UI_M_POL_LC_NET_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_NET_PREM(
	    HtmlInputText COMP_UI_M_POL_LC_NET_PREM) {
	this.COMP_UI_M_POL_LC_NET_PREM = COMP_UI_M_POL_LC_NET_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_BROK_COMM_LABEL() {
	return COMP_UI_M_FC_BROK_COMM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_BROK_COMM() {
	return COMP_UI_M_FC_BROK_COMM;
    }

    public void setCOMP_UI_M_FC_BROK_COMM_LABEL(
	    HtmlOutputLabel COMP_UI_M_FC_BROK_COMM_LABEL) {
	this.COMP_UI_M_FC_BROK_COMM_LABEL = COMP_UI_M_FC_BROK_COMM_LABEL;
    }

    public void setCOMP_UI_M_FC_BROK_COMM(HtmlInputText COMP_UI_M_FC_BROK_COMM) {
	this.COMP_UI_M_FC_BROK_COMM = COMP_UI_M_FC_BROK_COMM;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_BROK_COMM_LABEL() {
	return COMP_UI_M_LC_BROK_COMM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_BROK_COMM() {
	return COMP_UI_M_LC_BROK_COMM;
    }

    public void setCOMP_UI_M_LC_BROK_COMM_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_BROK_COMM_LABEL) {
	this.COMP_UI_M_LC_BROK_COMM_LABEL = COMP_UI_M_LC_BROK_COMM_LABEL;
    }

    public void setCOMP_UI_M_LC_BROK_COMM(HtmlInputText COMP_UI_M_LC_BROK_COMM) {
	this.COMP_UI_M_LC_BROK_COMM = COMP_UI_M_LC_BROK_COMM;
    }

    public HtmlOutputLabel getCOMP_POL_EXC_INT_PERC_LABEL() {
	return COMP_POL_EXC_INT_PERC_LABEL;
    }

    public HtmlInputText getCOMP_POL_EXC_INT_PERC() {
	return COMP_POL_EXC_INT_PERC;
    }

    public void setCOMP_POL_EXC_INT_PERC_LABEL(
	    HtmlOutputLabel COMP_POL_EXC_INT_PERC_LABEL) {
	this.COMP_POL_EXC_INT_PERC_LABEL = COMP_POL_EXC_INT_PERC_LABEL;
    }

    public void setCOMP_POL_EXC_INT_PERC(HtmlInputText COMP_POL_EXC_INT_PERC) {
	this.COMP_POL_EXC_INT_PERC = COMP_POL_EXC_INT_PERC;
    }

    public HtmlOutputLabel getCOMP_POL_STAFF_CCLASS_CODE_LABEL() {
	return COMP_POL_STAFF_CCLASS_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_STAFF_CCLASS_CODE() {
	return COMP_POL_STAFF_CCLASS_CODE;
    }

    public void setCOMP_POL_STAFF_CCLASS_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_STAFF_CCLASS_CODE_LABEL) {
	this.COMP_POL_STAFF_CCLASS_CODE_LABEL = COMP_POL_STAFF_CCLASS_CODE_LABEL;
    }

    public void setCOMP_POL_STAFF_CCLASS_CODE(
	    HtmlInputText COMP_POL_STAFF_CCLASS_CODE) {
	this.COMP_POL_STAFF_CCLASS_CODE = COMP_POL_STAFF_CCLASS_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_CCLAS_CLASS_DESC_LABEL() {
	return COMP_UI_M_CCLAS_CLASS_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_CCLAS_CLASS_DESC() {
	return COMP_UI_M_CCLAS_CLASS_DESC;
    }

    public void setCOMP_UI_M_CCLAS_CLASS_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_CCLAS_CLASS_DESC_LABEL) {
	this.COMP_UI_M_CCLAS_CLASS_DESC_LABEL = COMP_UI_M_CCLAS_CLASS_DESC_LABEL;
    }

    public void setCOMP_UI_M_CCLAS_CLASS_DESC(
	    HtmlInputText COMP_UI_M_CCLAS_CLASS_DESC) {
	this.COMP_UI_M_CCLAS_CLASS_DESC = COMP_UI_M_CCLAS_CLASS_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_STD_RISK_YN_LABEL() {
	return COMP_POL_STD_RISK_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_STD_RISK_YN() {
	return COMP_POL_STD_RISK_YN;
    }

    public void setCOMP_POL_STD_RISK_YN_LABEL(
	    HtmlOutputLabel COMP_POL_STD_RISK_YN_LABEL) {
	this.COMP_POL_STD_RISK_YN_LABEL = COMP_POL_STD_RISK_YN_LABEL;
    }

    public void setCOMP_POL_STD_RISK_YN(HtmlSelectOneMenu COMP_POL_STD_RISK_YN) {
	this.COMP_POL_STD_RISK_YN = COMP_POL_STD_RISK_YN;
    }

    public HtmlOutputLabel getCOMP_POL_FC_EXC_INT_AMT_LABEL() {
	return COMP_POL_FC_EXC_INT_AMT_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_EXC_INT_AMT() {
	return COMP_POL_FC_EXC_INT_AMT;
    }

    public void setCOMP_POL_FC_EXC_INT_AMT_LABEL(
	    HtmlOutputLabel COMP_POL_FC_EXC_INT_AMT_LABEL) {
	this.COMP_POL_FC_EXC_INT_AMT_LABEL = COMP_POL_FC_EXC_INT_AMT_LABEL;
    }

    public void setCOMP_POL_FC_EXC_INT_AMT(HtmlInputText COMP_POL_FC_EXC_INT_AMT) {
	this.COMP_POL_FC_EXC_INT_AMT = COMP_POL_FC_EXC_INT_AMT;
    }

    public HtmlOutputLabel getCOMP_POL_FC_MODAL_PREM_LABEL() {
	return COMP_POL_FC_MODAL_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_MODAL_PREM() {
	return COMP_POL_FC_MODAL_PREM;
    }

    public void setCOMP_POL_FC_MODAL_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_FC_MODAL_PREM_LABEL) {
	this.COMP_POL_FC_MODAL_PREM_LABEL = COMP_POL_FC_MODAL_PREM_LABEL;
    }

    public void setCOMP_POL_FC_MODAL_PREM(HtmlInputText COMP_POL_FC_MODAL_PREM) {
	this.COMP_POL_FC_MODAL_PREM = COMP_POL_FC_MODAL_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_NO_OF_UNIT_LABEL() {
	return COMP_POL_NO_OF_UNIT_LABEL;
    }

    public HtmlInputText getCOMP_POL_NO_OF_UNIT() {
	return COMP_POL_NO_OF_UNIT;
    }

    public void setCOMP_POL_NO_OF_UNIT_LABEL(
	    HtmlOutputLabel COMP_POL_NO_OF_UNIT_LABEL) {
	this.COMP_POL_NO_OF_UNIT_LABEL = COMP_POL_NO_OF_UNIT_LABEL;
    }

    public void setCOMP_POL_NO_OF_UNIT(HtmlInputText COMP_POL_NO_OF_UNIT) {
	this.COMP_POL_NO_OF_UNIT = COMP_POL_NO_OF_UNIT;
    }

    public HtmlOutputLabel getCOMP_POL_LC_MODAL_PREM_LABEL() {
	return COMP_POL_LC_MODAL_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_MODAL_PREM() {
	return COMP_POL_LC_MODAL_PREM;
    }

    public void setCOMP_POL_LC_MODAL_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_LC_MODAL_PREM_LABEL) {
	this.COMP_POL_LC_MODAL_PREM_LABEL = COMP_POL_LC_MODAL_PREM_LABEL;
    }

    public void setCOMP_POL_LC_MODAL_PREM(HtmlInputText COMP_POL_LC_MODAL_PREM) {
	this.COMP_POL_LC_MODAL_PREM = COMP_POL_LC_MODAL_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_DEPT_DESC_LABEL() {
	return COMP_UI_M_POL_DEPT_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_DEPT_DESC() {
	return COMP_UI_M_POL_DEPT_DESC;
    }

    public void setCOMP_UI_M_POL_DEPT_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_DEPT_DESC_LABEL) {
	this.COMP_UI_M_POL_DEPT_DESC_LABEL = COMP_UI_M_POL_DEPT_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_DEPT_DESC(HtmlInputText COMP_UI_M_POL_DEPT_DESC) {
	this.COMP_UI_M_POL_DEPT_DESC = COMP_UI_M_POL_DEPT_DESC;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL() {
	return COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_MODE_OF_PYMT_RATE() {
	return COMP_UI_M_POL_MODE_OF_PYMT_RATE;
    }

    public void setCOMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL) {
	this.COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL = COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL;
    }

    public void setCOMP_UI_M_POL_MODE_OF_PYMT_RATE(
	    HtmlInputText COMP_UI_M_POL_MODE_OF_PYMT_RATE) {
	this.COMP_UI_M_POL_MODE_OF_PYMT_RATE = COMP_UI_M_POL_MODE_OF_PYMT_RATE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_FC_MOP_LABEL() {
	return COMP_UI_M_POL_FC_MOP_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_FC_MOP() {
	return COMP_UI_M_POL_FC_MOP;
    }

    public void setCOMP_UI_M_POL_FC_MOP_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_FC_MOP_LABEL) {
	this.COMP_UI_M_POL_FC_MOP_LABEL = COMP_UI_M_POL_FC_MOP_LABEL;
    }

    public void setCOMP_UI_M_POL_FC_MOP(HtmlInputText COMP_UI_M_POL_FC_MOP) {
	this.COMP_UI_M_POL_FC_MOP = COMP_UI_M_POL_FC_MOP;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_MOP_LABEL() {
	return COMP_UI_M_POL_LC_MOP_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_MOP() {
	return COMP_UI_M_POL_LC_MOP;
    }

    public void setCOMP_UI_M_POL_LC_MOP_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_MOP_LABEL) {
	this.COMP_UI_M_POL_LC_MOP_LABEL = COMP_UI_M_POL_LC_MOP_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_MOP(HtmlInputText COMP_UI_M_POL_LC_MOP) {
	this.COMP_UI_M_POL_LC_MOP = COMP_UI_M_POL_LC_MOP;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_CHARGE_LABEL() {
	return COMP_UI_M_FC_CHARGE_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_CHARGE() {
	return COMP_UI_M_FC_CHARGE;
    }

    public void setCOMP_UI_M_FC_CHARGE_LABEL(
	    HtmlOutputLabel COMP_UI_M_FC_CHARGE_LABEL) {
	this.COMP_UI_M_FC_CHARGE_LABEL = COMP_UI_M_FC_CHARGE_LABEL;
    }

    public void setCOMP_UI_M_FC_CHARGE(HtmlInputText COMP_UI_M_FC_CHARGE) {
	this.COMP_UI_M_FC_CHARGE = COMP_UI_M_FC_CHARGE;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_CHARGE_LABEL() {
	return COMP_UI_M_LC_CHARGE_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_CHARGE() {
	return COMP_UI_M_LC_CHARGE;
    }

    public void setCOMP_UI_M_LC_CHARGE_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_CHARGE_LABEL) {
	this.COMP_UI_M_LC_CHARGE_LABEL = COMP_UI_M_LC_CHARGE_LABEL;
    }

    public void setCOMP_UI_M_LC_CHARGE(HtmlInputText COMP_UI_M_LC_CHARGE) {
	this.COMP_UI_M_LC_CHARGE = COMP_UI_M_LC_CHARGE;
    }

    public HtmlOutputLabel getCOMP_POL_RI_POOL_CODE_LABEL() {
	return COMP_POL_RI_POOL_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_RI_POOL_CODE() {
	return COMP_POL_RI_POOL_CODE;
    }

    public void setCOMP_POL_RI_POOL_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_RI_POOL_CODE_LABEL) {
	this.COMP_POL_RI_POOL_CODE_LABEL = COMP_POL_RI_POOL_CODE_LABEL;
    }

    public void setCOMP_POL_RI_POOL_CODE(HtmlInputText COMP_POL_RI_POOL_CODE) {
	this.COMP_POL_RI_POOL_CODE = COMP_POL_RI_POOL_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL() {
	return COMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_RI_POOL_CODE_DESC() {
	return COMP_UI_M_POL_RI_POOL_CODE_DESC;
    }

    public void setCOMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL) {
	this.COMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL = COMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_RI_POOL_CODE_DESC(
	    HtmlInputText COMP_UI_M_POL_RI_POOL_CODE_DESC) {
	this.COMP_UI_M_POL_RI_POOL_CODE_DESC = COMP_UI_M_POL_RI_POOL_CODE_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_CREDIT_YN_LABEL() {
	return COMP_POL_CREDIT_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_CREDIT_YN() {
	return COMP_POL_CREDIT_YN;
    }

    public void setCOMP_POL_CREDIT_YN_LABEL(
	    HtmlOutputLabel COMP_POL_CREDIT_YN_LABEL) {
	this.COMP_POL_CREDIT_YN_LABEL = COMP_POL_CREDIT_YN_LABEL;
    }

    public void setCOMP_POL_CREDIT_YN(HtmlSelectOneMenu COMP_POL_CREDIT_YN) {
	this.COMP_POL_CREDIT_YN = COMP_POL_CREDIT_YN;
    }

    public HtmlOutputLabel getCOMP_POL_LOAD_PERC_LABEL() {
	return COMP_POL_LOAD_PERC_LABEL;
    }

    public HtmlInputText getCOMP_POL_LOAD_PERC() {
	return COMP_POL_LOAD_PERC;
    }

    public void setCOMP_POL_LOAD_PERC_LABEL(
	    HtmlOutputLabel COMP_POL_LOAD_PERC_LABEL) {
	this.COMP_POL_LOAD_PERC_LABEL = COMP_POL_LOAD_PERC_LABEL;
    }

    public void setCOMP_POL_LOAD_PERC(HtmlInputText COMP_POL_LOAD_PERC) {
	this.COMP_POL_LOAD_PERC = COMP_POL_LOAD_PERC;
    }

    public HtmlOutputLabel getCOMP_POL_STAFF_YN_LABEL() {
	return COMP_POL_STAFF_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_STAFF_YN() {
	return COMP_POL_STAFF_YN;
    }

    public void setCOMP_POL_STAFF_YN_LABEL(
	    HtmlOutputLabel COMP_POL_STAFF_YN_LABEL) {
	this.COMP_POL_STAFF_YN_LABEL = COMP_POL_STAFF_YN_LABEL;
    }

    public void setCOMP_POL_STAFF_YN(HtmlSelectOneMenu COMP_POL_STAFF_YN) {
	this.COMP_POL_STAFF_YN = COMP_POL_STAFF_YN;
    }

    public HtmlOutputLabel getCOMP_POL_FAC_BASIS_LABEL() {
	return COMP_POL_FAC_BASIS_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_FAC_BASIS() {
	return COMP_POL_FAC_BASIS;
    }

    public void setCOMP_POL_FAC_BASIS_LABEL(
	    HtmlOutputLabel COMP_POL_FAC_BASIS_LABEL) {
	this.COMP_POL_FAC_BASIS_LABEL = COMP_POL_FAC_BASIS_LABEL;
    }

    public void setCOMP_POL_FAC_BASIS(HtmlSelectOneMenu COMP_POL_FAC_BASIS) {
	this.COMP_POL_FAC_BASIS = COMP_POL_FAC_BASIS;
    }

    public HtmlOutputLabel getCOMP_POL_MODE_OF_PYMT_LABEL() {
	return COMP_POL_MODE_OF_PYMT_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_MODE_OF_PYMT() {
	return COMP_POL_MODE_OF_PYMT;
    }

    public void setCOMP_POL_MODE_OF_PYMT_LABEL(
	    HtmlOutputLabel COMP_POL_MODE_OF_PYMT_LABEL) {
	this.COMP_POL_MODE_OF_PYMT_LABEL = COMP_POL_MODE_OF_PYMT_LABEL;
    }

    public void setCOMP_POL_MODE_OF_PYMT(HtmlSelectOneMenu COMP_POL_MODE_OF_PYMT) {
	this.COMP_POL_MODE_OF_PYMT = COMP_POL_MODE_OF_PYMT;
    }

    public HtmlOutputLabel getCOMP_POL_NO_OF_INST_LABEL() {
	return COMP_POL_NO_OF_INST_LABEL;
    }

    public HtmlInputText getCOMP_POL_NO_OF_INST() {
	return COMP_POL_NO_OF_INST;
    }

    public void setCOMP_POL_NO_OF_INST_LABEL(
	    HtmlOutputLabel COMP_POL_NO_OF_INST_LABEL) {
	this.COMP_POL_NO_OF_INST_LABEL = COMP_POL_NO_OF_INST_LABEL;
    }

    public void setCOMP_POL_NO_OF_INST(HtmlInputText COMP_POL_NO_OF_INST) {
	this.COMP_POL_NO_OF_INST = COMP_POL_NO_OF_INST;
    }

    public HtmlOutputLabel getCOMP_POL_MODE_OF_PYMT_RATE_LABEL() {
	return COMP_POL_MODE_OF_PYMT_RATE_LABEL;
    }

    public HtmlInputText getCOMP_POL_MODE_OF_PYMT_RATE() {
	return COMP_POL_MODE_OF_PYMT_RATE;
    }

    public void setCOMP_POL_MODE_OF_PYMT_RATE_LABEL(
	    HtmlOutputLabel COMP_POL_MODE_OF_PYMT_RATE_LABEL) {
	this.COMP_POL_MODE_OF_PYMT_RATE_LABEL = COMP_POL_MODE_OF_PYMT_RATE_LABEL;
    }

    public void setCOMP_POL_MODE_OF_PYMT_RATE(
	    HtmlInputText COMP_POL_MODE_OF_PYMT_RATE) {
	this.COMP_POL_MODE_OF_PYMT_RATE = COMP_POL_MODE_OF_PYMT_RATE;
    }

    public HtmlOutputLabel getCOMP_POL_CLASS_CODE_LABEL() {
	return COMP_POL_CLASS_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_CLASS_CODE() {
	return COMP_POL_CLASS_CODE;
    }

    public void setCOMP_POL_CLASS_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_CLASS_CODE_LABEL) {
	this.COMP_POL_CLASS_CODE_LABEL = COMP_POL_CLASS_CODE_LABEL;
    }

    public void setCOMP_POL_CLASS_CODE(HtmlInputText COMP_POL_CLASS_CODE) {
	this.COMP_POL_CLASS_CODE = COMP_POL_CLASS_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_FC_GR_ANN_PREM_LABEL() {
	return COMP_UI_M_POL_FC_GR_ANN_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_FC_GR_ANN_PREM() {
	return COMP_UI_M_POL_FC_GR_ANN_PREM;
    }

    public void setCOMP_UI_M_POL_FC_GR_ANN_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_FC_GR_ANN_PREM_LABEL) {
	this.COMP_UI_M_POL_FC_GR_ANN_PREM_LABEL = COMP_UI_M_POL_FC_GR_ANN_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_FC_GR_ANN_PREM(
	    HtmlInputText COMP_UI_M_POL_FC_GR_ANN_PREM) {
	this.COMP_UI_M_POL_FC_GR_ANN_PREM = COMP_UI_M_POL_FC_GR_ANN_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_GR_ANN_PREM_LABEL() {
	return COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_GR_ANN_PREM() {
	return COMP_UI_M_POL_LC_GR_ANN_PREM;
    }

    public void setCOMP_UI_M_POL_LC_GR_ANN_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL) {
	this.COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL = COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_GR_ANN_PREM(
	    HtmlInputText COMP_UI_M_POL_LC_GR_ANN_PREM) {
	this.COMP_UI_M_POL_LC_GR_ANN_PREM = COMP_UI_M_POL_LC_GR_ANN_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL() {
	return COMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_PCHARGES_BORNE_COMP() {
	return COMP_UI_M_FC_PCHARGES_BORNE_COMP;
    }

    public void setCOMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL(
	    HtmlOutputLabel COMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL) {
	this.COMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL = COMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL;
    }

    public void setCOMP_UI_M_FC_PCHARGES_BORNE_COMP(
	    HtmlInputText COMP_UI_M_FC_PCHARGES_BORNE_COMP) {
	this.COMP_UI_M_FC_PCHARGES_BORNE_COMP = COMP_UI_M_FC_PCHARGES_BORNE_COMP;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL() {
	return COMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_PCHARGES_BORNE_COMP() {
	return COMP_UI_M_LC_PCHARGES_BORNE_COMP;
    }

    public void setCOMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL) {
	this.COMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL = COMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL;
    }

    public void setCOMP_UI_M_LC_PCHARGES_BORNE_COMP(
	    HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_COMP) {
	this.COMP_UI_M_LC_PCHARGES_BORNE_COMP = COMP_UI_M_LC_PCHARGES_BORNE_COMP;
    }

    public HtmlOutputLabel getCOMP_POL_FC_NET_PREM_LABEL() {
	return COMP_POL_FC_NET_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_NET_PREM() {
	return COMP_POL_FC_NET_PREM;
    }

    public void setCOMP_POL_FC_NET_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_FC_NET_PREM_LABEL) {
	this.COMP_POL_FC_NET_PREM_LABEL = COMP_POL_FC_NET_PREM_LABEL;
    }

    public void setCOMP_POL_FC_NET_PREM(HtmlInputText COMP_POL_FC_NET_PREM) {
	this.COMP_POL_FC_NET_PREM = COMP_POL_FC_NET_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_LC_NET_PREM_LABEL() {
	return COMP_POL_LC_NET_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_NET_PREM() {
	return COMP_POL_LC_NET_PREM;
    }

    public void setCOMP_POL_LC_NET_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_LC_NET_PREM_LABEL) {
	this.COMP_POL_LC_NET_PREM_LABEL = COMP_POL_LC_NET_PREM_LABEL;
    }

    public void setCOMP_POL_LC_NET_PREM(HtmlInputText COMP_POL_LC_NET_PREM) {
	this.COMP_POL_LC_NET_PREM = COMP_POL_LC_NET_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_INST_PREM_LABEL() {
	return COMP_UI_M_FC_INST_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_INST_PREM() {
	return COMP_UI_M_FC_INST_PREM;
    }

    public void setCOMP_UI_M_FC_INST_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_FC_INST_PREM_LABEL) {
	this.COMP_UI_M_FC_INST_PREM_LABEL = COMP_UI_M_FC_INST_PREM_LABEL;
    }

    public void setCOMP_UI_M_FC_INST_PREM(HtmlInputText COMP_UI_M_FC_INST_PREM) {
	this.COMP_UI_M_FC_INST_PREM = COMP_UI_M_FC_INST_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_INST_PREM_LABEL() {
	return COMP_UI_M_LC_INST_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_INST_PREM() {
	return COMP_UI_M_LC_INST_PREM;
    }

    public void setCOMP_UI_M_LC_INST_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_INST_PREM_LABEL) {
	this.COMP_UI_M_LC_INST_PREM_LABEL = COMP_UI_M_LC_INST_PREM_LABEL;
    }

    public void setCOMP_UI_M_LC_INST_PREM(HtmlInputText COMP_UI_M_LC_INST_PREM) {
	this.COMP_UI_M_LC_INST_PREM = COMP_UI_M_LC_INST_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_CQS_PERC_LABEL() {
	return COMP_POL_CQS_PERC_LABEL;
    }

    public HtmlInputText getCOMP_POL_CQS_PERC() {
	return COMP_POL_CQS_PERC;
    }

    public void setCOMP_POL_CQS_PERC_LABEL(
	    HtmlOutputLabel COMP_POL_CQS_PERC_LABEL) {
	this.COMP_POL_CQS_PERC_LABEL = COMP_POL_CQS_PERC_LABEL;
    }

    public void setCOMP_POL_CQS_PERC(HtmlInputText COMP_POL_CQS_PERC) {
	this.COMP_POL_CQS_PERC = COMP_POL_CQS_PERC;
    }

    public HtmlOutputLabel getCOMP_POL_CREDIT_DISCOUNT_PERC_LABEL() {
	return COMP_POL_CREDIT_DISCOUNT_PERC_LABEL;
    }

    public HtmlInputText getCOMP_POL_CREDIT_DISCOUNT_PERC() {
	return COMP_POL_CREDIT_DISCOUNT_PERC;
    }

    public void setCOMP_POL_CREDIT_DISCOUNT_PERC_LABEL(
	    HtmlOutputLabel COMP_POL_CREDIT_DISCOUNT_PERC_LABEL) {
	this.COMP_POL_CREDIT_DISCOUNT_PERC_LABEL = COMP_POL_CREDIT_DISCOUNT_PERC_LABEL;
    }

    public void setCOMP_POL_CREDIT_DISCOUNT_PERC(
	    HtmlInputText COMP_POL_CREDIT_DISCOUNT_PERC) {
	this.COMP_POL_CREDIT_DISCOUNT_PERC = COMP_POL_CREDIT_DISCOUNT_PERC;
    }

    public HtmlOutputLabel getCOMP_POL_FAC_YN_LABEL() {
	return COMP_POL_FAC_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_FAC_YN() {
	return COMP_POL_FAC_YN;
    }

    public void setCOMP_POL_FAC_YN_LABEL(HtmlOutputLabel COMP_POL_FAC_YN_LABEL) {
	this.COMP_POL_FAC_YN_LABEL = COMP_POL_FAC_YN_LABEL;
    }

    public void setCOMP_POL_FAC_YN(HtmlSelectOneMenu COMP_POL_FAC_YN) {
	this.COMP_POL_FAC_YN = COMP_POL_FAC_YN;
    }

    public HtmlOutputLabel getCOMP_POL_FORM_NO_LABEL() {
	return COMP_POL_FORM_NO_LABEL;
    }

    public HtmlInputText getCOMP_POL_FORM_NO() {
	return COMP_POL_FORM_NO;
    }

    public void setCOMP_POL_FORM_NO_LABEL(HtmlOutputLabel COMP_POL_FORM_NO_LABEL) {
	this.COMP_POL_FORM_NO_LABEL = COMP_POL_FORM_NO_LABEL;
    }

    public void setCOMP_POL_FORM_NO(HtmlInputText COMP_POL_FORM_NO) {
	this.COMP_POL_FORM_NO = COMP_POL_FORM_NO;
    }

    public HtmlOutputLabel getCOMP_POL_FC_SUM_ASSURED_LABEL() {
	return COMP_POL_FC_SUM_ASSURED_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_SUM_ASSURED() {
	return COMP_POL_FC_SUM_ASSURED;
    }

    public void setCOMP_POL_FC_SUM_ASSURED_LABEL(
	    HtmlOutputLabel COMP_POL_FC_SUM_ASSURED_LABEL) {
	this.COMP_POL_FC_SUM_ASSURED_LABEL = COMP_POL_FC_SUM_ASSURED_LABEL;
    }

    public void setCOMP_POL_FC_SUM_ASSURED(HtmlInputText COMP_POL_FC_SUM_ASSURED) {
	this.COMP_POL_FC_SUM_ASSURED = COMP_POL_FC_SUM_ASSURED;
    }

    public HtmlOutputLabel getCOMP_POL_LC_SUM_ASSURED_LABEL() {
	return COMP_POL_LC_SUM_ASSURED_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_SUM_ASSURED() {
	return COMP_POL_LC_SUM_ASSURED;
    }

    public void setCOMP_POL_LC_SUM_ASSURED_LABEL(  HtmlOutputLabel COMP_POL_LC_SUM_ASSURED_LABEL) {
	this.COMP_POL_LC_SUM_ASSURED_LABEL = COMP_POL_LC_SUM_ASSURED_LABEL;
    }

    public void setCOMP_POL_LC_SUM_ASSURED(HtmlInputText COMP_POL_LC_SUM_ASSURED) {
	this.COMP_POL_LC_SUM_ASSURED = COMP_POL_LC_SUM_ASSURED;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_CLASS_DESC_LABEL() {
	return COMP_UI_M_POL_CLASS_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_CLASS_DESC() {
	return COMP_UI_M_POL_CLASS_DESC;
    }

    public void setCOMP_UI_M_POL_CLASS_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_CLASS_DESC_LABEL) {
	this.COMP_UI_M_POL_CLASS_DESC_LABEL = COMP_UI_M_POL_CLASS_DESC_LABEL;
    }

    public void setCOMP_UI_M_POL_CLASS_DESC(
	    HtmlInputText COMP_UI_M_POL_CLASS_DESC) {
	this.COMP_UI_M_POL_CLASS_DESC = COMP_UI_M_POL_CLASS_DESC;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_INST_FC_PREM_LABEL() {
	return COMP_UI_M_POL_INST_FC_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_INST_FC_PREM() {
	return COMP_UI_M_POL_INST_FC_PREM;
    }

    public void setCOMP_UI_M_POL_INST_FC_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_INST_FC_PREM_LABEL) {
	this.COMP_UI_M_POL_INST_FC_PREM_LABEL = COMP_UI_M_POL_INST_FC_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_INST_FC_PREM(
	    HtmlInputText COMP_UI_M_POL_INST_FC_PREM) {
	this.COMP_UI_M_POL_INST_FC_PREM = COMP_UI_M_POL_INST_FC_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_INST_LC_PREM_LABEL() {
	return COMP_UI_M_POL_INST_LC_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_INST_LC_PREM() {
	return COMP_UI_M_POL_INST_LC_PREM;
    }

    public void setCOMP_UI_M_POL_INST_LC_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_INST_LC_PREM_LABEL) {
	this.COMP_UI_M_POL_INST_LC_PREM_LABEL = COMP_UI_M_POL_INST_LC_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_INST_LC_PREM(
	    HtmlInputText COMP_UI_M_POL_INST_LC_PREM) {
	this.COMP_UI_M_POL_INST_LC_PREM = COMP_UI_M_POL_INST_LC_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_FC_BANK_ALLOC_AMT_LABEL() {
	return COMP_POL_FC_BANK_ALLOC_AMT_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_BANK_ALLOC_AMT() {
	return COMP_POL_FC_BANK_ALLOC_AMT;
    }

    public void setCOMP_POL_FC_BANK_ALLOC_AMT_LABEL(
	    HtmlOutputLabel COMP_POL_FC_BANK_ALLOC_AMT_LABEL) {
	this.COMP_POL_FC_BANK_ALLOC_AMT_LABEL = COMP_POL_FC_BANK_ALLOC_AMT_LABEL;
    }

    public void setCOMP_POL_FC_BANK_ALLOC_AMT(
	    HtmlInputText COMP_POL_FC_BANK_ALLOC_AMT) {
	this.COMP_POL_FC_BANK_ALLOC_AMT = COMP_POL_FC_BANK_ALLOC_AMT;
    }

    public HtmlOutputLabel getCOMP_POL_LC_BANK_ALLOC_AMT_LABEL() {
	return COMP_POL_LC_BANK_ALLOC_AMT_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_BANK_ALLOC_AMT() {
	return COMP_POL_LC_BANK_ALLOC_AMT;
    }

    public void setCOMP_POL_LC_BANK_ALLOC_AMT_LABEL(
	    HtmlOutputLabel COMP_POL_LC_BANK_ALLOC_AMT_LABEL) {
	this.COMP_POL_LC_BANK_ALLOC_AMT_LABEL = COMP_POL_LC_BANK_ALLOC_AMT_LABEL;
    }

    public void setCOMP_POL_LC_BANK_ALLOC_AMT(
	    HtmlInputText COMP_POL_LC_BANK_ALLOC_AMT) {
	this.COMP_POL_LC_BANK_ALLOC_AMT = COMP_POL_LC_BANK_ALLOC_AMT;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL() {
	return COMP_UI_M_POL_CONT_AD_ACC_NO_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_CONT_AD_ACC_NO() {
	return COMP_UI_M_POL_CONT_AD_ACC_NO;
    }

    public void setCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_CONT_AD_ACC_NO_LABEL) {
	this.COMP_UI_M_POL_CONT_AD_ACC_NO_LABEL = COMP_UI_M_POL_CONT_AD_ACC_NO_LABEL;
    }

    public void setCOMP_UI_M_POL_CONT_AD_ACC_NO(
	    HtmlInputText COMP_UI_M_POL_CONT_AD_ACC_NO) {
	this.COMP_UI_M_POL_CONT_AD_ACC_NO = COMP_UI_M_POL_CONT_AD_ACC_NO;
    }

    public HtmlOutputLabel getCOMP_POL_PROP_REF_NO_LABEL() {
	return COMP_POL_PROP_REF_NO_LABEL;
    }

    public HtmlInputText getCOMP_POL_PROP_REF_NO() {
	return COMP_POL_PROP_REF_NO;
    }

    public void setCOMP_POL_PROP_REF_NO_LABEL(
	    HtmlOutputLabel COMP_POL_PROP_REF_NO_LABEL) {
	this.COMP_POL_PROP_REF_NO_LABEL = COMP_POL_PROP_REF_NO_LABEL;
    }

    public void setCOMP_POL_PROP_REF_NO(HtmlInputText COMP_POL_PROP_REF_NO) {
	this.COMP_POL_PROP_REF_NO = COMP_POL_PROP_REF_NO;
    }

    public HtmlOutputLabel getCOMP_POL_AGENT_REF_CODE_LABEL() {
	return COMP_POL_AGENT_REF_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_AGENT_REF_CODE() {
	return COMP_POL_AGENT_REF_CODE;
    }

    public void setCOMP_POL_AGENT_REF_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_AGENT_REF_CODE_LABEL) {
	this.COMP_POL_AGENT_REF_CODE_LABEL = COMP_POL_AGENT_REF_CODE_LABEL;
    }

    public void setCOMP_POL_AGENT_REF_CODE(HtmlInputText COMP_POL_AGENT_REF_CODE) {
	this.COMP_POL_AGENT_REF_CODE = COMP_POL_AGENT_REF_CODE;
    }

    public HtmlOutputLabel getCOMP_POL_CQS_YN_LABEL() {
	return COMP_POL_CQS_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_CQS_YN() {
	return COMP_POL_CQS_YN;
    }

    public void setCOMP_POL_CQS_YN_LABEL(HtmlOutputLabel COMP_POL_CQS_YN_LABEL) {
	this.COMP_POL_CQS_YN_LABEL = COMP_POL_CQS_YN_LABEL;
    }

    public void setCOMP_POL_CQS_YN(HtmlSelectOneMenu COMP_POL_CQS_YN) {
	this.COMP_POL_CQS_YN = COMP_POL_CQS_YN;
    }

    public HtmlOutputLabel getCOMP_POL_FC_DEPOSIT_AMOUNT_LABEL() {
	return COMP_POL_FC_DEPOSIT_AMOUNT_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_DEPOSIT_AMOUNT() {
	return COMP_POL_FC_DEPOSIT_AMOUNT;
    }

    public void setCOMP_POL_FC_DEPOSIT_AMOUNT_LABEL(
	    HtmlOutputLabel COMP_POL_FC_DEPOSIT_AMOUNT_LABEL) {
	this.COMP_POL_FC_DEPOSIT_AMOUNT_LABEL = COMP_POL_FC_DEPOSIT_AMOUNT_LABEL;
    }

    public void setCOMP_POL_FC_DEPOSIT_AMOUNT(
	    HtmlInputText COMP_POL_FC_DEPOSIT_AMOUNT) {
	this.COMP_POL_FC_DEPOSIT_AMOUNT = COMP_POL_FC_DEPOSIT_AMOUNT;
    }

    public HtmlOutputLabel getCOMP_POL_LC_DEPOSIT_AMOUNT_LABEL() {
	return COMP_POL_LC_DEPOSIT_AMOUNT_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_DEPOSIT_AMOUNT() {
	return COMP_POL_LC_DEPOSIT_AMOUNT;
    }

    public void setCOMP_POL_LC_DEPOSIT_AMOUNT_LABEL(
	    HtmlOutputLabel COMP_POL_LC_DEPOSIT_AMOUNT_LABEL) {
	this.COMP_POL_LC_DEPOSIT_AMOUNT_LABEL = COMP_POL_LC_DEPOSIT_AMOUNT_LABEL;
    }

    public void setCOMP_POL_LC_DEPOSIT_AMOUNT(
	    HtmlInputText COMP_POL_LC_DEPOSIT_AMOUNT) {
	this.COMP_POL_LC_DEPOSIT_AMOUNT = COMP_POL_LC_DEPOSIT_AMOUNT;
    }

    public HtmlOutputLabel getCOMP_POL_LC_MIN_PREM_LABEL() {
	return COMP_POL_LC_MIN_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_MIN_PREM() {
	return COMP_POL_LC_MIN_PREM;
    }

    public void setCOMP_POL_LC_MIN_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_LC_MIN_PREM_LABEL) {
	this.COMP_POL_LC_MIN_PREM_LABEL = COMP_POL_LC_MIN_PREM_LABEL;
    }

    public void setCOMP_POL_LC_MIN_PREM(HtmlInputText COMP_POL_LC_MIN_PREM) {
	this.COMP_POL_LC_MIN_PREM = COMP_POL_LC_MIN_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_FC_DISC_AMT_LABEL() {
	return COMP_POL_FC_DISC_AMT_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_DISC_AMT() {
	return COMP_POL_FC_DISC_AMT;
    }

    public void setCOMP_POL_FC_DISC_AMT_LABEL(
	    HtmlOutputLabel COMP_POL_FC_DISC_AMT_LABEL) {
	this.COMP_POL_FC_DISC_AMT_LABEL = COMP_POL_FC_DISC_AMT_LABEL;
    }

    public void setCOMP_POL_FC_DISC_AMT(HtmlInputText COMP_POL_FC_DISC_AMT) {
	this.COMP_POL_FC_DISC_AMT = COMP_POL_FC_DISC_AMT;
    }

    public HtmlOutputLabel getCOMP_POL_LC_DISC_AMT_LABEL() {
	return COMP_POL_LC_DISC_AMT_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_DISC_AMT() {
	return COMP_POL_LC_DISC_AMT;
    }

    public void setCOMP_POL_LC_DISC_AMT_LABEL(
	    HtmlOutputLabel COMP_POL_LC_DISC_AMT_LABEL) {
	this.COMP_POL_LC_DISC_AMT_LABEL = COMP_POL_LC_DISC_AMT_LABEL;
    }

    public void setCOMP_POL_LC_DISC_AMT(HtmlInputText COMP_POL_LC_DISC_AMT) {
	this.COMP_POL_LC_DISC_AMT = COMP_POL_LC_DISC_AMT;
    }

    public HtmlOutputLabel getCOMP_POL_FC_CLIENT_ALLOC_AMT_LABEL() {
	return COMP_POL_FC_CLIENT_ALLOC_AMT_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_CLIENT_ALLOC_AMT() {
	return COMP_POL_FC_CLIENT_ALLOC_AMT;
    }

    public void setCOMP_POL_FC_CLIENT_ALLOC_AMT_LABEL(
	    HtmlOutputLabel COMP_POL_FC_CLIENT_ALLOC_AMT_LABEL) {
	this.COMP_POL_FC_CLIENT_ALLOC_AMT_LABEL = COMP_POL_FC_CLIENT_ALLOC_AMT_LABEL;
    }

    public void setCOMP_POL_FC_CLIENT_ALLOC_AMT(
	    HtmlInputText COMP_POL_FC_CLIENT_ALLOC_AMT) {
	this.COMP_POL_FC_CLIENT_ALLOC_AMT = COMP_POL_FC_CLIENT_ALLOC_AMT;
    }

    public HtmlOutputLabel getCOMP_POL_LC_CLIENT_ALLOC_AMT_LABEL() {
	return COMP_POL_LC_CLIENT_ALLOC_AMT_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_CLIENT_ALLOC_AMT() {
	return COMP_POL_LC_CLIENT_ALLOC_AMT;
    }

    public void setCOMP_POL_LC_CLIENT_ALLOC_AMT_LABEL(
	    HtmlOutputLabel COMP_POL_LC_CLIENT_ALLOC_AMT_LABEL) {
	this.COMP_POL_LC_CLIENT_ALLOC_AMT_LABEL = COMP_POL_LC_CLIENT_ALLOC_AMT_LABEL;
    }

    public void setCOMP_POL_LC_CLIENT_ALLOC_AMT(
	    HtmlInputText COMP_POL_LC_CLIENT_ALLOC_AMT) {
	this.COMP_POL_LC_CLIENT_ALLOC_AMT = COMP_POL_LC_CLIENT_ALLOC_AMT;
    }

    public HtmlOutputLabel getCOMP_POL_CONT_AD_BANK_CODE_LABEL() {
	return COMP_POL_CONT_AD_BANK_CODE_LABEL;
    }

    public HtmlInputText getCOMP_POL_CONT_AD_BANK_CODE() {
	return COMP_POL_CONT_AD_BANK_CODE;
    }

    public void setCOMP_POL_CONT_AD_BANK_CODE_LABEL(
	    HtmlOutputLabel COMP_POL_CONT_AD_BANK_CODE_LABEL) {
	this.COMP_POL_CONT_AD_BANK_CODE_LABEL = COMP_POL_CONT_AD_BANK_CODE_LABEL;
    }

    public void setCOMP_POL_CONT_AD_BANK_CODE(
	    HtmlInputText COMP_POL_CONT_AD_BANK_CODE) {
	this.COMP_POL_CONT_AD_BANK_CODE = COMP_POL_CONT_AD_BANK_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_BANK_CODE_DESC_LABEL() {
	return COMP_UI_M_BANK_CODE_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_BANK_CODE_DESC() {
	return COMP_UI_M_BANK_CODE_DESC;
    }

    public void setCOMP_UI_M_BANK_CODE_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_BANK_CODE_DESC_LABEL) {
	this.COMP_UI_M_BANK_CODE_DESC_LABEL = COMP_UI_M_BANK_CODE_DESC_LABEL;
    }

    public void setCOMP_UI_M_BANK_CODE_DESC(
	    HtmlInputText COMP_UI_M_BANK_CODE_DESC) {
	this.COMP_UI_M_BANK_CODE_DESC = COMP_UI_M_BANK_CODE_DESC;
    }

    public HtmlOutputLabel getCOMP_POL_FIRST_INST_DT_LABEL() {
	return COMP_POL_FIRST_INST_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_FIRST_INST_DT() {
	return COMP_POL_FIRST_INST_DT;
    }

    public void setCOMP_POL_FIRST_INST_DT_LABEL(
	    HtmlOutputLabel COMP_POL_FIRST_INST_DT_LABEL) {
	this.COMP_POL_FIRST_INST_DT_LABEL = COMP_POL_FIRST_INST_DT_LABEL;
    }

    public void setCOMP_POL_FIRST_INST_DT(HtmlCalendar COMP_POL_FIRST_INST_DT) {
	this.COMP_POL_FIRST_INST_DT = COMP_POL_FIRST_INST_DT;
    }

    public HtmlOutputLabel getCOMP_POL_LAST_INST_DT_LABEL() {
	return COMP_POL_LAST_INST_DT_LABEL;
    }

    public HtmlCalendar getCOMP_POL_LAST_INST_DT() {
	return COMP_POL_LAST_INST_DT;
    }

    public void setCOMP_POL_LAST_INST_DT_LABEL(
	    HtmlOutputLabel COMP_POL_LAST_INST_DT_LABEL) {
	this.COMP_POL_LAST_INST_DT_LABEL = COMP_POL_LAST_INST_DT_LABEL;
    }

    public void setCOMP_POL_LAST_INST_DT(HtmlCalendar COMP_POL_LAST_INST_DT) {
	this.COMP_POL_LAST_INST_DT = COMP_POL_LAST_INST_DT;
    }

    public HtmlOutputLabel getCOMP_POL_REMARKS_LABEL() {
	return COMP_POL_REMARKS_LABEL;
    }

    public HtmlInputText getCOMP_POL_REMARKS() {
	return COMP_POL_REMARKS;
    }

    public void setCOMP_POL_REMARKS_LABEL(HtmlOutputLabel COMP_POL_REMARKS_LABEL) {
	this.COMP_POL_REMARKS_LABEL = COMP_POL_REMARKS_LABEL;
    }

    public void setCOMP_POL_REMARKS(HtmlInputText COMP_POL_REMARKS) {
	this.COMP_POL_REMARKS = COMP_POL_REMARKS;
    }

    public HtmlOutputLabel getCOMP_POL_FC_MIN_PREM_LABEL() {
	return COMP_POL_FC_MIN_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_MIN_PREM() {
	return COMP_POL_FC_MIN_PREM;
    }

    public void setCOMP_POL_FC_MIN_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_FC_MIN_PREM_LABEL) {
	this.COMP_POL_FC_MIN_PREM_LABEL = COMP_POL_FC_MIN_PREM_LABEL;
    }

    public void setCOMP_POL_FC_MIN_PREM(HtmlInputText COMP_POL_FC_MIN_PREM) {
	this.COMP_POL_FC_MIN_PREM = COMP_POL_FC_MIN_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL() {
	return COMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_SCHARGES_BORNE_CUST() {
	return COMP_UI_M_FC_SCHARGES_BORNE_CUST;
    }

    public void setCOMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL(
	    HtmlOutputLabel COMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL) {
	this.COMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL = COMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL;
    }

    public void setCOMP_UI_M_FC_SCHARGES_BORNE_CUST(
	    HtmlInputText COMP_UI_M_FC_SCHARGES_BORNE_CUST) {
	this.COMP_UI_M_FC_SCHARGES_BORNE_CUST = COMP_UI_M_FC_SCHARGES_BORNE_CUST;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL() {
	return COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_SCHARGES_BORNE_CUST() {
	return COMP_UI_M_LC_SCHARGES_BORNE_CUST;
    }

    public void setCOMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL) {
	this.COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL = COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL;
    }

    public void setCOMP_UI_M_LC_SCHARGES_BORNE_CUST(
	    HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_CUST) {
	this.COMP_UI_M_LC_SCHARGES_BORNE_CUST = COMP_UI_M_LC_SCHARGES_BORNE_CUST;
    }

    public HtmlOutputLabel getCOMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL() {
	return COMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_FC_SCHARGES_BORNE_COMP() {
	return COMP_UI_M_FC_SCHARGES_BORNE_COMP;
    }

    public void setCOMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL(
	    HtmlOutputLabel COMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL) {
	this.COMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL = COMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL;
    }

    public void setCOMP_UI_M_FC_SCHARGES_BORNE_COMP(
	    HtmlInputText COMP_UI_M_FC_SCHARGES_BORNE_COMP) {
	this.COMP_UI_M_FC_SCHARGES_BORNE_COMP = COMP_UI_M_FC_SCHARGES_BORNE_COMP;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL() {
	return COMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_SCHARGES_BORNE_COMP() {
	return COMP_UI_M_LC_SCHARGES_BORNE_COMP;
    }

    public void setCOMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL) {
	this.COMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL = COMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL;
    }

    public void setCOMP_UI_M_LC_SCHARGES_BORNE_COMP(
	    HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_COMP) {
	this.COMP_UI_M_LC_SCHARGES_BORNE_COMP = COMP_UI_M_LC_SCHARGES_BORNE_COMP;
    }

    public HtmlOutputLabel getCOMP_POL_CARD_HOLDER_NAME_LABEL() {
	return COMP_POL_CARD_HOLDER_NAME_LABEL;
    }

    public HtmlInputText getCOMP_POL_CARD_HOLDER_NAME() {
	return COMP_POL_CARD_HOLDER_NAME;
    }

    public void setCOMP_POL_CARD_HOLDER_NAME_LABEL(
	    HtmlOutputLabel COMP_POL_CARD_HOLDER_NAME_LABEL) {
	this.COMP_POL_CARD_HOLDER_NAME_LABEL = COMP_POL_CARD_HOLDER_NAME_LABEL;
    }

    public void setCOMP_POL_CARD_HOLDER_NAME(
	    HtmlInputText COMP_POL_CARD_HOLDER_NAME) {
	this.COMP_POL_CARD_HOLDER_NAME = COMP_POL_CARD_HOLDER_NAME;
    }

    public HtmlOutputLabel getCOMP_POL_DEF_IMM_FLAG_LABEL() {
	return COMP_POL_DEF_IMM_FLAG_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_POL_DEF_IMM_FLAG() {
	return COMP_POL_DEF_IMM_FLAG;
    }

    public void setCOMP_POL_DEF_IMM_FLAG_LABEL(
	    HtmlOutputLabel COMP_POL_DEF_IMM_FLAG_LABEL) {
	this.COMP_POL_DEF_IMM_FLAG_LABEL = COMP_POL_DEF_IMM_FLAG_LABEL;
    }

    public void setCOMP_POL_DEF_IMM_FLAG(HtmlSelectOneMenu COMP_POL_DEF_IMM_FLAG) {
	this.COMP_POL_DEF_IMM_FLAG = COMP_POL_DEF_IMM_FLAG;
    }

    public HtmlOutputLabel getCOMP_POL_LC_EXTRA_PREM_LABEL() {
	return COMP_POL_LC_EXTRA_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_EXTRA_PREM() {
	return COMP_POL_LC_EXTRA_PREM;
    }

    public void setCOMP_POL_LC_EXTRA_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_LC_EXTRA_PREM_LABEL) {
	this.COMP_POL_LC_EXTRA_PREM_LABEL = COMP_POL_LC_EXTRA_PREM_LABEL;
    }

    public void setCOMP_POL_LC_EXTRA_PREM(HtmlInputText COMP_POL_LC_EXTRA_PREM) {
	this.COMP_POL_LC_EXTRA_PREM = COMP_POL_LC_EXTRA_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_FC_EXTRA_PREM_LABEL() {
	return COMP_POL_FC_EXTRA_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_EXTRA_PREM() {
	return COMP_POL_FC_EXTRA_PREM;
    }

    public void setCOMP_POL_FC_EXTRA_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_FC_EXTRA_PREM_LABEL) {
	this.COMP_POL_FC_EXTRA_PREM_LABEL = COMP_POL_FC_EXTRA_PREM_LABEL;
    }

    public void setCOMP_POL_FC_EXTRA_PREM(HtmlInputText COMP_POL_FC_EXTRA_PREM) {
	this.COMP_POL_FC_EXTRA_PREM = COMP_POL_FC_EXTRA_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_FC_MON_ANNU_AMT_LABEL() {
	return COMP_POL_FC_MON_ANNU_AMT_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_MON_ANNU_AMT() {
	return COMP_POL_FC_MON_ANNU_AMT;
    }

    public void setCOMP_POL_FC_MON_ANNU_AMT_LABEL(
	    HtmlOutputLabel COMP_POL_FC_MON_ANNU_AMT_LABEL) {
	this.COMP_POL_FC_MON_ANNU_AMT_LABEL = COMP_POL_FC_MON_ANNU_AMT_LABEL;
    }

    public void setCOMP_POL_FC_MON_ANNU_AMT(
	    HtmlInputText COMP_POL_FC_MON_ANNU_AMT) {
	this.COMP_POL_FC_MON_ANNU_AMT = COMP_POL_FC_MON_ANNU_AMT;
    }

    public HtmlOutputLabel getCOMP_POL_LC_MON_ANNU_AMT_LABEL() {
	return COMP_POL_LC_MON_ANNU_AMT_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_MON_ANNU_AMT() {
	return COMP_POL_LC_MON_ANNU_AMT;
    }

    public void setCOMP_POL_LC_MON_ANNU_AMT_LABEL(
	    HtmlOutputLabel COMP_POL_LC_MON_ANNU_AMT_LABEL) {
	this.COMP_POL_LC_MON_ANNU_AMT_LABEL = COMP_POL_LC_MON_ANNU_AMT_LABEL;
    }

    public void setCOMP_POL_LC_MON_ANNU_AMT(
	    HtmlInputText COMP_POL_LC_MON_ANNU_AMT) {
	this.COMP_POL_LC_MON_ANNU_AMT = COMP_POL_LC_MON_ANNU_AMT;
    }

    public HtmlOutputLabel getCOMP_POL_FC_FIRST_PREM_LABEL() {
	return COMP_POL_FC_FIRST_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_FIRST_PREM() {
	return COMP_POL_FC_FIRST_PREM;
    }

    public void setCOMP_POL_FC_FIRST_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_FC_FIRST_PREM_LABEL) {
	this.COMP_POL_FC_FIRST_PREM_LABEL = COMP_POL_FC_FIRST_PREM_LABEL;
    }

    public void setCOMP_POL_FC_FIRST_PREM(HtmlInputText COMP_POL_FC_FIRST_PREM) {
	this.COMP_POL_FC_FIRST_PREM = COMP_POL_FC_FIRST_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_LC_FIRST_PREM_LABEL() {
	return COMP_POL_LC_FIRST_PREM_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_FIRST_PREM() {
	return COMP_POL_LC_FIRST_PREM;
    }

    public void setCOMP_POL_LC_FIRST_PREM_LABEL(
	    HtmlOutputLabel COMP_POL_LC_FIRST_PREM_LABEL) {
	this.COMP_POL_LC_FIRST_PREM_LABEL = COMP_POL_LC_FIRST_PREM_LABEL;
    }

    public void setCOMP_POL_LC_FIRST_PREM(HtmlInputText COMP_POL_LC_FIRST_PREM) {
	this.COMP_POL_LC_FIRST_PREM = COMP_POL_LC_FIRST_PREM;
    }

    public HtmlOutputLabel getCOMP_POL_FC_PRE_TPD_BNF_LABEL() {
	return COMP_POL_FC_PRE_TPD_BNF_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_PRE_TPD_BNF() {
	return COMP_POL_FC_PRE_TPD_BNF;
    }

    public void setCOMP_POL_FC_PRE_TPD_BNF_LABEL(
	    HtmlOutputLabel COMP_POL_FC_PRE_TPD_BNF_LABEL) {
	this.COMP_POL_FC_PRE_TPD_BNF_LABEL = COMP_POL_FC_PRE_TPD_BNF_LABEL;
    }

    public void setCOMP_POL_FC_PRE_TPD_BNF(HtmlInputText COMP_POL_FC_PRE_TPD_BNF) {
	this.COMP_POL_FC_PRE_TPD_BNF = COMP_POL_FC_PRE_TPD_BNF;
    }

    public HtmlOutputLabel getCOMP_POL_LC_PRE_TPD_BNF_LABEL() {
	return COMP_POL_LC_PRE_TPD_BNF_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_PRE_TPD_BNF() {
	return COMP_POL_LC_PRE_TPD_BNF;
    }

    public void setCOMP_POL_LC_PRE_TPD_BNF_LABEL(
	    HtmlOutputLabel COMP_POL_LC_PRE_TPD_BNF_LABEL) {
	this.COMP_POL_LC_PRE_TPD_BNF_LABEL = COMP_POL_LC_PRE_TPD_BNF_LABEL;
    }

    public void setCOMP_POL_LC_PRE_TPD_BNF(HtmlInputText COMP_POL_LC_PRE_TPD_BNF) {
	this.COMP_POL_LC_PRE_TPD_BNF = COMP_POL_LC_PRE_TPD_BNF;
    }

    public HtmlOutputLabel getCOMP_POL_AUTH_LIMIT_LABEL() {
	return COMP_POL_AUTH_LIMIT_LABEL;
    }

    public HtmlInputText getCOMP_POL_AUTH_LIMIT() {
	return COMP_POL_AUTH_LIMIT;
    }

    public void setCOMP_POL_AUTH_LIMIT_LABEL(
	    HtmlOutputLabel COMP_POL_AUTH_LIMIT_LABEL) {
	this.COMP_POL_AUTH_LIMIT_LABEL = COMP_POL_AUTH_LIMIT_LABEL;
    }

    public void setCOMP_POL_AUTH_LIMIT(HtmlInputText COMP_POL_AUTH_LIMIT) {
	this.COMP_POL_AUTH_LIMIT = COMP_POL_AUTH_LIMIT;
    }

    /*public HtmlCommandButton getCOMP_UI_M_BUS_RUL() {
	return COMP_UI_M_BUS_RUL;
    }

    public void setCOMP_UI_M_BUS_RUL(HtmlCommandButton COMP_UI_M_BUS_RUL) {
	this.COMP_UI_M_BUS_RUL = COMP_UI_M_BUS_RUL;
    }*/

    public HtmlCommandButton getCOMP_UI_M_BUT_COPY() {
	return COMP_UI_M_BUT_COPY;
    }

    public void setCOMP_UI_M_BUT_COPY(HtmlCommandButton COMP_UI_M_BUT_COPY) {
	this.COMP_UI_M_BUT_COPY = COMP_UI_M_BUT_COPY;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_FUND_QUERY() {
	return COMP_UI_M_BUT_FUND_QUERY;
    }

    public void setCOMP_UI_M_BUT_FUND_QUERY(
	    HtmlCommandButton COMP_UI_M_BUT_FUND_QUERY) {
	this.COMP_UI_M_BUT_FUND_QUERY = COMP_UI_M_BUT_FUND_QUERY;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_HOLD() {
	return COMP_UI_M_BUT_HOLD;
    }

    public void setCOMP_UI_M_BUT_HOLD(HtmlCommandButton COMP_UI_M_BUT_HOLD) {
	this.COMP_UI_M_BUT_HOLD = COMP_UI_M_BUT_HOLD;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_UDDATE_STAT() {
	return COMP_UI_M_BUT_UDDATE_STAT;
    }

    public void setCOMP_UI_M_BUT_UDDATE_STAT(
	    HtmlCommandButton COMP_UI_M_BUT_UDDATE_STAT) {
	this.COMP_UI_M_BUT_UDDATE_STAT = COMP_UI_M_BUT_UDDATE_STAT;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_UPI() {
	return COMP_UI_M_BUT_UPI;
    }

    public void setCOMP_UI_M_BUT_UPI(HtmlCommandButton COMP_UI_M_BUT_UPI) {
	this.COMP_UI_M_BUT_UPI = COMP_UI_M_BUT_UPI;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_CALC_DISC_LOAD() {
	return COMP_UI_M_BUT_CALC_DISC_LOAD;
    }

    public void setCOMP_UI_M_BUT_CALC_DISC_LOAD(
	    HtmlCommandButton COMP_UI_M_BUT_CALC_DISC_LOAD) {
	this.COMP_UI_M_BUT_CALC_DISC_LOAD = COMP_UI_M_BUT_CALC_DISC_LOAD;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_SURR_MAT() {
	return COMP_UI_M_BUT_SURR_MAT;
    }

    public void setCOMP_UI_M_BUT_SURR_MAT(
	    HtmlCommandButton COMP_UI_M_BUT_SURR_MAT) {
	this.COMP_UI_M_BUT_SURR_MAT = COMP_UI_M_BUT_SURR_MAT;
    }

 /*   public HtmlCommandButton getCOMP_UI_M_BUT_ENDT() {
	return COMP_UI_M_BUT_ENDT;
    }

    public void setCOMP_UI_M_BUT_ENDT(HtmlCommandButton COMP_UI_M_BUT_ENDT) {
	this.COMP_UI_M_BUT_ENDT = COMP_UI_M_BUT_ENDT;
    }*/

    public HtmlCommandButton getCOMP_UI_M_BUT_APPROVAL() {
	return COMP_UI_M_BUT_APPROVAL;
    }

    public void setCOMP_UI_M_BUT_APPROVAL(
	    HtmlCommandButton COMP_UI_M_BUT_APPROVAL) {
	this.COMP_UI_M_BUT_APPROVAL = COMP_UI_M_BUT_APPROVAL;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_PRMDTLS() {
	return COMP_UI_M_BUT_PRMDTLS;
    }

    public void setCOMP_UI_M_BUT_PRMDTLS(HtmlCommandButton COMP_UI_M_BUT_PRMDTLS) {
	this.COMP_UI_M_BUT_PRMDTLS = COMP_UI_M_BUT_PRMDTLS;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PLAN() {
	return COMP_UI_M_BUT_LOV_PLAN;
    }

    public void setCOMP_UI_M_BUT_LOV_PLAN(
	    HtmlCommandButton COMP_UI_M_BUT_LOV_PLAN) {
	this.COMP_UI_M_BUT_LOV_PLAN = COMP_UI_M_BUT_LOV_PLAN;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_DOC_GEN_NO() {
	return COMP_UI_M_BUT_DOC_GEN_NO;
    }

    public void setCOMP_UI_M_BUT_DOC_GEN_NO(
	    HtmlCommandButton COMP_UI_M_BUT_DOC_GEN_NO) {
	this.COMP_UI_M_BUT_DOC_GEN_NO = COMP_UI_M_BUT_DOC_GEN_NO;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PROD_CODE() {
	return COMP_UI_M_BUT_LOV_PROD_CODE;
    }

    public void setCOMP_UI_M_BUT_LOV_PROD_CODE(
	    HtmlCommandButton COMP_UI_M_BUT_LOV_PROD_CODE) {
	this.COMP_UI_M_BUT_LOV_PROD_CODE = COMP_UI_M_BUT_LOV_PROD_CODE;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_CONVERT() {
	return COMP_UI_M_BUT_CONVERT;
    }

    public void setCOMP_UI_M_BUT_CONVERT(HtmlCommandButton COMP_UI_M_BUT_CONVERT) {
	this.COMP_UI_M_BUT_CONVERT = COMP_UI_M_BUT_CONVERT;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_POL_AMDT() {
	return COMP_UI_M_BUT_POL_AMDT;
    }

    public void setCOMP_UI_M_BUT_POL_AMDT(
	    HtmlCommandButton COMP_UI_M_BUT_POL_AMDT) {
	this.COMP_UI_M_BUT_POL_AMDT = COMP_UI_M_BUT_POL_AMDT;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_UPLOAD() {
	return COMP_UI_M_BUT_UPLOAD;
    }

    public void setCOMP_UI_M_BUT_UPLOAD(HtmlCommandButton COMP_UI_M_BUT_UPLOAD) {
	this.COMP_UI_M_BUT_UPLOAD = COMP_UI_M_BUT_UPLOAD;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_CLAIM() {
	return COMP_UI_M_BUT_CLAIM;
    }

    public void setCOMP_UI_M_BUT_CLAIM(HtmlCommandButton COMP_UI_M_BUT_CLAIM) {
	this.COMP_UI_M_BUT_CLAIM = COMP_UI_M_BUT_CLAIM;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_FUND_DTL() {
	return COMP_UI_M_BUT_FUND_DTL;
    }

    public void setCOMP_UI_M_BUT_FUND_DTL(
	    HtmlCommandButton COMP_UI_M_BUT_FUND_DTL) {
	this.COMP_UI_M_BUT_FUND_DTL = COMP_UI_M_BUT_FUND_DTL;
    }

    public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
	return PT_IL_POLICY_BEAN;
    }

    public void setPT_IL_POLICY_BEAN(PT_IL_POLICY PT_IL_POLICY_BEAN) {
	this.PT_IL_POLICY_BEAN = PT_IL_POLICY_BEAN;
    }


	public String deleteRow(ActionEvent event) {
	    CommonUtils.clearMaps(this);
		try {
			if (isDELETE_ALLOWED()) {
			    
			    helper.ON_CHECK_DELETE_MASTER(PT_IL_POLICY_BEAN);
				new CRUDHandler().executeDelete(PT_IL_POLICY_BEAN,
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
			 
				 
			} else {

				getErrorMap().put("deleteRow", Messages.getString(
						PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$deletenotallowed"));
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}
		return backButton();
	}

    
    public void saveRecord() {
    	String message = null;
    	CommonUtils.clearMaps(this);
	try {
	    if (getPT_IL_POLICY_BEAN().getROWID() != null) {
		if(isUPDATE_ALLOWED()){
        	    	helper.PRE_UPDATE(compositeAction);
        	    	validateOtherRichTabComponents();
        	    	new CRUDHandler().executeInsert(PT_IL_POLICY_BEAN,CommonUtils.getConnection());
        	    	helper.POST_UPDATE(PT_IL_POLICY_BEAN, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
        	    	getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
        	    	message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
		}
	    } else {
		if(isINSERT_ALLOWED()){
        	    	helper.PRE_INSERT(compositeAction);
        	    	validateOtherRichTabComponents();
        	    	new CRUDHandler().executeInsert(PT_IL_POLICY_BEAN,CommonUtils.getConnection());
        	    	helper.POST_INSERT(compositeAction);
        	    	message = Messages.getString("messageProperties","errorPanel$message$save");
		}
	    }
	    CommonUtils.getConnection().commit();
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		getWarningMap().put("SAVE_RECORD",message);
	} catch (Exception e) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("SAVE", e.getMessage());
	}
    }


    public List<SelectItem> getListPOL_MED_FEE_RECOVER_YN() {
	if (listPOL_MED_FEE_RECOVER_YN.size() == 0) {
	    listPOL_MED_FEE_RECOVER_YN.clear();
	    try {
		listPOL_MED_FEE_RECOVER_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_MED_FEE_RECOVER_YN;
    }

    public void setListPOL_MED_FEE_RECOVER_YN(
	    List<SelectItem> listPOL_MED_FEE_RECOVER_YN) {
	this.listPOL_MED_FEE_RECOVER_YN = listPOL_MED_FEE_RECOVER_YN;
    }

    public List<SelectItem> getListPOL_JOINT_LIFE_YN() {
	if (listPOL_JOINT_LIFE_YN.size() == 0) {
	    listPOL_JOINT_LIFE_YN.clear();
	    try {
		listPOL_JOINT_LIFE_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }

	}
	return listPOL_JOINT_LIFE_YN;
    }

    public void setListPOL_JOINT_LIFE_YN(List<SelectItem> listPOL_JOINT_LIFE_YN) {
	this.listPOL_JOINT_LIFE_YN = listPOL_JOINT_LIFE_YN;
    }

    public List<SelectItem> getListPOL_FRZ_FLAG() {
	if (listPOL_FRZ_FLAG.size() == 0) {
	    listPOL_FRZ_FLAG.clear();
	    try {
		listPOL_FRZ_FLAG = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_FRZ_FLAG;
    }

    public void setListPOL_FRZ_FLAG(List<SelectItem> listPOL_FRZ_FLAG) {
	this.listPOL_FRZ_FLAG = listPOL_FRZ_FLAG;
    }

    public List<SelectItem> getListPOL_CASH_YN() {
	if (listPOL_CASH_YN.size() == 0) {
	    listPOL_CASH_YN.clear();
	    try {
		listPOL_CASH_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_CASH_YN;
    }

    public void setListPOL_CASH_YN(List<SelectItem> listPOL_CASH_YN) {
	this.listPOL_CASH_YN = listPOL_CASH_YN;
    }

    public List<SelectItem> getListPOL_MODE_OF_CALC() {
	if (listPOL_MODE_OF_CALC.size() == 0) {
	    listPOL_MODE_OF_CALC.clear();
	    try {
		listPOL_MODE_OF_CALC = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_MODE_OF_CALC;
    }

    public void setListPOL_MODE_OF_CALC(List<SelectItem> listPOL_MODE_OF_CALC) {
	this.listPOL_MODE_OF_CALC = listPOL_MODE_OF_CALC;
    }

    public List<SelectItem> getListPOL_PYMT_TYPE() {
	if (listPOL_PYMT_TYPE.size() == 0) {
	    listPOL_PYMT_TYPE.clear();
	    try {
		listPOL_PYMT_TYPE = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_PYMT_TYPE;
    }

    public void setListPOL_PYMT_TYPE(List<SelectItem> listPOL_PYMT_TYPE) {
	this.listPOL_PYMT_TYPE = listPOL_PYMT_TYPE;
    }

    public List<SelectItem> getListPOL_HOME_OWNER_FLAG() {
	if (listPOL_HOME_OWNER_FLAG.size() == 0) {
	    listPOL_HOME_OWNER_FLAG.clear();
	    try {
		listPOL_HOME_OWNER_FLAG = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_HOME_OWNER_FLAG;
    }

    public void setListPOL_HOME_OWNER_FLAG(
	    List<SelectItem> listPOL_HOME_OWNER_FLAG) {
	this.listPOL_HOME_OWNER_FLAG = listPOL_HOME_OWNER_FLAG;
    }

    public List<SelectItem> getListPOL_INCORPORATED_YN() {
	if (listPOL_INCORPORATED_YN.size() == 0) {
	    listPOL_INCORPORATED_YN.clear();
	    try {
		listPOL_INCORPORATED_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_INCORPORATED_YN;
    }

    public void setListPOL_INCORPORATED_YN(
	    List<SelectItem> listPOL_INCORPORATED_YN) {
	this.listPOL_INCORPORATED_YN = listPOL_INCORPORATED_YN;
    }

    public List<SelectItem> getListPOL_NET_PREM_YN() {
	if (listPOL_NET_PREM_YN.size() == 0) {
	    listPOL_NET_PREM_YN.clear();
	    try {
		listPOL_NET_PREM_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_NET_PREM_YN;
    }

    public void setListPOL_NET_PREM_YN(List<SelectItem> listPOL_NET_PREM_YN) {
	this.listPOL_NET_PREM_YN = listPOL_NET_PREM_YN;
    }

    public List<SelectItem> getListPOL_GRANTEE_TYPE() {
	if (listPOL_GRANTEE_TYPE.size() == 0) {
	    listPOL_GRANTEE_TYPE.clear();
	    try {
		listPOL_GRANTEE_TYPE = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_GRANTEE_TYPE;
    }

    public void setListPOL_GRANTEE_TYPE(List<SelectItem> listPOL_GRANTEE_TYPE) {
	this.listPOL_GRANTEE_TYPE = listPOL_GRANTEE_TYPE;
    }

    public List<SelectItem> getListPOL_RATE_APPLIED_ON() {
	if (listPOL_RATE_APPLIED_ON.size() == 0) {
	    listPOL_RATE_APPLIED_ON.clear();
	    try {
		listPOL_RATE_APPLIED_ON = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_RATE_APPLIED_ON;
    }

    public void setListPOL_RATE_APPLIED_ON(
	    List<SelectItem> listPOL_RATE_APPLIED_ON) {
	this.listPOL_RATE_APPLIED_ON = listPOL_RATE_APPLIED_ON;
    }

    public List<SelectItem> getListPOL_ORG_PROP_RECV_YN() {
	if (listPOL_ORG_PROP_RECV_YN.size() == 0) {
	    listPOL_ORG_PROP_RECV_YN.clear();
	    try {
		listPOL_ORG_PROP_RECV_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_ORG_PROP_RECV_YN;
    }

    public void setListPOL_ORG_PROP_RECV_YN(
	    List<SelectItem> listPOL_ORG_PROP_RECV_YN) {
	this.listPOL_ORG_PROP_RECV_YN = listPOL_ORG_PROP_RECV_YN;
    }

    public List<SelectItem> getListPOL_TARIFF_TERM_FLAG() {
	if (listPOL_TARIFF_TERM_FLAG.size() == 0) {
	    listPOL_TARIFF_TERM_FLAG.clear();
	    try {
		listPOL_TARIFF_TERM_FLAG = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_TARIFF_TERM_FLAG;
    }

    public void setListPOL_TARIFF_TERM_FLAG(
	    List<SelectItem> listPOL_TARIFF_TERM_FLAG) {
	this.listPOL_TARIFF_TERM_FLAG = listPOL_TARIFF_TERM_FLAG;
    }

    public List<SelectItem> getListPOL_STD_RISK_YN() {
	if (listPOL_STD_RISK_YN.size() == 0) {
	    listPOL_STD_RISK_YN.clear();
	    try {
		listPOL_STD_RISK_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_STD_RISK_YN;
    }

    public void setListPOL_STD_RISK_YN(List<SelectItem> listPOL_STD_RISK_YN) {
	this.listPOL_STD_RISK_YN = listPOL_STD_RISK_YN;
    }

    public List<SelectItem> getListPOL_CREDIT_YN() {
	if (listPOL_CREDIT_YN.size() == 0) {
	    listPOL_CREDIT_YN.clear();
	    try {
		listPOL_CREDIT_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_CREDIT_YN;
    }

    public void setListPOL_CREDIT_YN(List<SelectItem> listPOL_CREDIT_YN) {
	this.listPOL_CREDIT_YN = listPOL_CREDIT_YN;
    }

    public List<SelectItem> getListPOL_STAFF_YN() {
	if (listPOL_STAFF_YN.size() == 0) {
	    listPOL_STAFF_YN.clear();
	    try {
		listPOL_STAFF_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_STAFF_YN;
    }

    public void setListPOL_STAFF_YN(List<SelectItem> listPOL_STAFF_YN) {
	this.listPOL_STAFF_YN = listPOL_STAFF_YN;
    }

    public List<SelectItem> getListPOL_FAC_BASIS() {
	if (listPOL_FAC_BASIS.size() == 0) {
	    listPOL_FAC_BASIS.clear();
	    try {
		listPOL_FAC_BASIS = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_FAC_BASIS;
    }

    public void setListPOL_FAC_BASIS(List<SelectItem> listPOL_FAC_BASIS) {
	this.listPOL_FAC_BASIS = listPOL_FAC_BASIS;
    }

    public List<SelectItem> getListPOL_MODE_OF_PYMT() {
	if (listPOL_MODE_OF_PYMT.size() == 0) {
	    listPOL_MODE_OF_PYMT.clear();
	    try {
		listPOL_MODE_OF_PYMT = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_MODE_OF_PYMT;
    }

    public void setListPOL_MODE_OF_PYMT(List<SelectItem> listPOL_MODE_OF_PYMT) {
	this.listPOL_MODE_OF_PYMT = listPOL_MODE_OF_PYMT;
    }

    public List<SelectItem> getListPOL_FAC_YN() {
	if (listPOL_FAC_YN.size() == 0) {
	    listPOL_FAC_YN.clear();
	    try {
		listPOL_FAC_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_FAC_YN;
    }

    public void setListPOL_FAC_YN(List<SelectItem> listPOL_FAC_YN) {
	this.listPOL_FAC_YN = listPOL_FAC_YN;
    }

    public List<SelectItem> getListPOL_CQS_YN() {
	if (listPOL_CQS_YN.size() == 0) {
	    listPOL_CQS_YN.clear();
	    try {
		listPOL_CQS_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_CQS_YN;
    }

    public void setListPOL_CQS_YN(List<SelectItem> listPOL_CQS_YN) {
	this.listPOL_CQS_YN = listPOL_CQS_YN;
    }

    public List<SelectItem> getListPOL_DEF_IMM_FLAG() {
	if (listPOL_DEF_IMM_FLAG.size() == 0) {
	    listPOL_DEF_IMM_FLAG.clear();
	    try {
		listPOL_DEF_IMM_FLAG = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPOL_DEF_IMM_FLAG;
    }

    public void setListPOL_DEF_IMM_FLAG(List<SelectItem> listPOL_DEF_IMM_FLAG) {
	this.listPOL_DEF_IMM_FLAG = listPOL_DEF_IMM_FLAG;
    }

    public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    public void onLoad(PhaseEvent event) {
	//CommonUtils.clearMaps(this);
	try {
	    PILQ003_HELPER pilt002_apac_helper = new PILQ003_HELPER();
	    if (isFormFlag()) {
		pilt002_apac_helper.setLabel(this, 
			compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN(), 
			compositeAction.getPT_IL_POLICY_1_ACTION_BEAN(),
			compositeAction.getPT_IL_POLICY2_ACTION_BEAN(),
			compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN(),
			compositeAction.getDUMMY_ACTION_BEAN());
		pilt002_apac_helper.PRE_FORM(compositeAction);
		pilt002_apac_helper.PILT002_APAC_WHEN_NEW_FORM_INSTANCE(compositeAction);
		//added to disable create post and delete in policy history query
		compositeAction.disableCreatePostDelete(false);
		//compositeAction.getTabbedBar().getTabById(compositeAction.TAB_PT_IL_POLICY).setTabName(this.getCOMP_FORM_CAPTION().getValue().toString() );
		setFormFlag(false);
	    }
	    if (isBlockFlag()) {

		helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
		 helper.PRE_QUERY(PT_IL_POLICY_BEAN);
		helper.executeQuery(compositeAction);
		if("A".equals(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())){
		   // compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled( true);
		    disableAllComponent(true);
		}
		/*else {//if("N".equals(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())){
		    compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled( false);
		    disableAllComponent(false);
		}*/
		helper.PRE_RECORD(compositeAction);
		helper.dummyButtonEnableDisable(compositeAction.getDUMMY_ACTION_BEAN());
		
		if (PT_IL_POLICY_BEAN.getROWID() != null) {
		    helper.PRE_QUERY(PT_IL_POLICY_BEAN);
		    helper.executeQuery(compositeAction);
		    helper.POST_QUERY(compositeAction);
		    helper.onPopulateDetails(compositeAction);
		}else{
		    helper.WHEN_CREATE_RECORD(compositeAction);
		  //  pilt002_apac_helper.PILT002_APAC_WHEN_NEW_FORM_INSTANCE(compositeAction);
		}
		
		helper.whenNewRecordInstance(compositeAction);
		
		setBlockFlag(false);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,  e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }

    public String backButton() {
	CommonUtils.clearMaps(this);
	String outcome = null;
	if(CommonUtils.getGlobalVariable("CALLING_FORM") != null){
		if("PILQ002".equals(CommonUtils.getGlobalVariable("CALLING_FORM"))){
			CommonUtils.setGlobalVariable("CALLING_FORM", null);
			new CommonUtils().clearMappedBeanFromSession("PILQ003_COMPOSITE_ACTION");
			outcome="PILQ002-I01";
		}
	}else{
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion("PILT002_APAC_PT_IL_POLICY_SEARCH_ACTION",
			"fetchRecords");
		outcome="PILT002_APAC";
		}
		return outcome;
    }

    
    
    public String backButtonAction(){
		String outcome = null;
		if(CommonUtils.getGlobalVariable("CALLING_FORM") != null){
			if("PILQ002".equals(CommonUtils.getGlobalVariable("CALLING_FORM"))){
				CommonUtils.setGlobalVariable("CALLING_FORM", null);
				new CommonUtils().clearMappedBeanFromSession("PILQ003_COMPOSITE_ACTION");
				outcome="PILQ002-I01";
			}
		}
		return outcome;
	}
    
    /* For forwarding to address details */

    public String addressButtonAction() {

	String forward = null;
	// String apprvStatus = getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS();
	forward = "PILT002_APAC_PT_IL_POL_ADDRESS_DTLS";
	return forward;

    }
    public String approveButtonAction() {
	String action = null;
	CommonUtils.clearMaps(this);
	DUMMY_HELPER helper = new DUMMY_HELPER();
	try {
		action = helper.UI_M_BUT_APPROVAL_WHEN_BUTTON_PRESSED(compositeAction);
	 
	} catch (Exception e) {
	    e.printStackTrace();
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());

	}
	return action;
    }
    public String copyButtonAction() {
	String action = null;
	CommonUtils.clearMaps(this);
	COPY_HELPER  helper = new COPY_HELPER();
	try {
	    action = helper.UI_M_BUT_COPY_WHEN_BUTTON_PRESSED( compositeAction);
	    
	} catch (Exception e) {
	    e.printStackTrace();
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	}
	return action;
    }
    public String endorsementButtonAction()
	{
	CommonUtils.clearMaps(this);
		String endorsementScreenId=null;
		 DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
		try
		{
		    endorsementScreenId = dummy_helper.UI_M_BUT_ENDT_WHEN_BUTTON_PRESSED(compositeAction);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			  getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				    e.getMessage());
		}
		return endorsementScreenId;
	}
    public String endorsementOKButtonAction()
    {
	CommonUtils.clearMaps(this);
	String outCome=null;
	 DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
	try
	{
	    dummy_helper.UI_M_PT_ENDT_OK_WHEN_BUTTON_PRESSED(compositeAction);
	    outCome="PILT002_APAC_PT_IL_POLICY";
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	   // getErrorMap().put("Endt", e.getMessage());
	}
	return outCome;
    }
    public  String  endorsementCancelButtonAction(){
	String  outCome = null;
	CommonUtils.clearMaps(this);
	try {
	    outCome =  "PILT002_APAC_PT_IL_POLICY";
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	}
	return outCome;
    }
    public String  doc_gen_noButton_Action( ){
	     DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
	     CommonUtils.clearMaps(this);
	    try {
		dummy_helper.UI_M_BUT_DOC_GEN_NO_WHEN_BUTTON_PRESSED(
			 PT_IL_POLICY_BEAN ,
			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN() , compositeAction.getDUMMY_ACTION_BEAN());
		
		
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		  getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			    e.getMessage());
	    }
	    return "PILT002_APAC_PT_IL_POLICY";
	 }
	  
    
	public String busRulButtonAction( ){
	     
	     // GO_BLOCK('PT_BUS_RULE_ERROR_MSG');
	     return "PILT002_APAC_PT_BUS_RULE_ERROR_MSG";
	 }
	 

    public HtmlOutputLabel getCOMP_POL_CURR_SA_LABEL() {
	return COMP_POL_CURR_SA_LABEL;
    }

    public void setCOMP_POL_CURR_SA_LABEL(HtmlOutputLabel comp_pol_curr_sa_label) {
	COMP_POL_CURR_SA_LABEL = comp_pol_curr_sa_label;
    }

    public HtmlInputText getCOMP_POL_CURR_SA_LIMIT() {
	return COMP_POL_CURR_SA_LIMIT;
    }

    public void setCOMP_POL_CURR_SA_LIMIT(HtmlInputText comp_pol_curr_sa_limit) {
	COMP_POL_CURR_SA_LIMIT = comp_pol_curr_sa_limit;
    }

    public HtmlOutputLabel getCOMP_POL_CURR_SA_LIMIT_LABEL() {
	return COMP_POL_CURR_SA_LIMIT_LABEL;
    }

    public void setCOMP_POL_CURR_SA_LIMIT_LABEL(
	    HtmlOutputLabel comp_pol_curr_sa_limit_label) {
	COMP_POL_CURR_SA_LIMIT_LABEL = comp_pol_curr_sa_limit_label;
    }

    public HtmlInputText getCOMP_POL_CURR_SA() {
	return COMP_POL_CURR_SA;
    }

    public void setCOMP_POL_CURR_SA(HtmlInputText comp_pol_curr_sa) {
	COMP_POL_CURR_SA = comp_pol_curr_sa;
    }

    public HtmlOutputLabel getCOMP_PROP_LC_DEP_PREM_LABEL() {
	return COMP_PROP_LC_DEP_PREM_LABEL;
    }

    public void setCOMP_PROP_LC_DEP_PREM_LABEL(
	    HtmlOutputLabel comp_prop_lc_dep_prem_label) {
	COMP_PROP_LC_DEP_PREM_LABEL = comp_prop_lc_dep_prem_label;
    }

    public HtmlInputText getCOMP_PROP_LC_DEP_PREM() {
	return COMP_PROP_LC_DEP_PREM;
    }

    public void setCOMP_PROP_LC_DEP_PREM(HtmlInputText comp_prop_lc_dep_prem) {
	COMP_PROP_LC_DEP_PREM = comp_prop_lc_dep_prem;
    }

    public HtmlInputText getCOMP_PROP_FC_DEP_PREM() {
	return COMP_PROP_FC_DEP_PREM;
    }

    public void setCOMP_PROP_FC_DEP_PREM(HtmlInputText comp_prop_fc_dep_prem) {
	COMP_PROP_FC_DEP_PREM = comp_prop_fc_dep_prem;
    }

    public HtmlOutputLabel getCOMP_PROP_FC_DEP_PREM_LABEL() {
	return COMP_PROP_FC_DEP_PREM_LABEL;
    }

    public void setCOMP_PROP_FC_DEP_PREM_LABEL(
	    HtmlOutputLabel comp_prop_fc_dep_prem_label) {
	COMP_PROP_FC_DEP_PREM_LABEL = comp_prop_fc_dep_prem_label;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PROD_GROUP_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_PROD_GROUP_CODE", null, null, null, null,
		    null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }
    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PROD_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_PROD_CODE", null, null, null, null,
		    null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    
    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_INTRODUCER_REF_ID1(
	    Object currValue) {

	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // PENDING
	    // STD_CALL_LOV('PILH152','PT_IL_POLICY.POL_INTRODUCER_REF_ID1','BROKER',:PT_IL_POLICY.POL_DIVN_CODE,'BROKER');

	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_INTRODUCER_REF_ID1", "BROKER",
		    PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), "BROKER", null, null,
		    (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean>lovPOL_STAFF_CCLASS_CODE(
	    Object currValue) {

	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_STAFF_CCLASS_CODE','STAFF');
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_STAFF_CCLASS_CODE", "STAFF", null,
		    null, null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<LovBean> lovUI_M_POL_CONT_AD_ACC_NO(
	    Object object) {

	ArrayList<LovBean> suggestionList = null;
	ListItemUtil listitemutil = new ListItemUtil();
	String M_CREDIT_CARD_UPD_YN = null;
	String M_FOUND = null;
	String query1 = "SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N') FROM MENU_USER  WHERE USER_ID =? ";
	String lovQuery = "SELECT DECRYPT(CBAD_ACNT_NO,'DuRAc33s') FROM PM_CUST_BANK_ACNT_DTLS " +
			"WHERE CBAD_CUST_CODE = ? AND CBAD_TYPE =  ?  AND (DECRYPT(CBAD_ACNT_NO,'DuRAc33s') LIKE ?  ) AND ROWNUM < 25 ";
	ResultSet rs = null;
	Connection connection = null;

	try {

	    connection = CommonUtils.getConnection();
	    rs = new CRUDHandler().executeSelectStatement(query1, connection,
		    new Object[] { CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID") });

	    while (rs.next()) {
		M_CREDIT_CARD_UPD_YN = rs.getString(1);
	    }

	    String currentValue = (String) object;
	    currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
	    if ("Y".equals(M_CREDIT_CARD_UPD_YN)) {
	    	 suggestionList = ListItemUtil.prepareSuggestionList(lovQuery,new Object[]{PT_IL_POLICY_BEAN.getPOL_CUST_CODE(),
	    			 	PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE(),currentValue});
	    } else if ("N".equals(M_CREDIT_CARD_UPD_YN)) {
	    	suggestionList = ListItemUtil.prepareSuggestionList(lovQuery,new Object[]{PT_IL_POLICY_BEAN.getPOL_CUST_CODE(),
    			 	PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE(),currentValue});
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
	finally{
		try {
			CommonUtils.closeCursor(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return suggestionList;
    }

    public ArrayList<LovBean> lovPOL_RI_POOL_CODE(Object currValue) {

	ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_RI_POOL_CODE');
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
	    										"PT_IL_POLICY",
	    										"POL_RI_POOL_CODE",
	    										null, null, null, null,
	    										null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<LovBean> lovPOL_RES_AREA_CODE(Object currValue) {

	ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_RES_AREA_CODE', 'POSTAL');
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_RES_AREA_CODE", "POSTAL", null, null,
		    null, null, (String) currValue);
	    System.out.println(" LIST " +suggestionList);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<LovBean> lovPOL_CITY_CODE(Object currValue) {

	ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_CITY_CODE','CITY');
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
	    "PT_IL_POLICY", "POL_CITY_CODE", "CITY", null, null, null,
		    null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_STATE_CODE(Object currValue) {

	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_STATE_CODE','STATE');
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_STATE_CODE", "STATE", null, null,
		    null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean>lovPOL_COUNT_CODE(Object currValue) {

	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_COUNT_CODE','COUNTRY');
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_COUNT_CODE", "COUNTRY", null, null,
		    null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public List<com.iii.premia.common.bean.LovBean> lovPOL_OFF_AREA_CODE(Object currValue) {

	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_OFF_AREA_CODE', 'POSTAL');
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_OFF_AREA_CODE", "POSTAL", null, null,
		    null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public List<com.iii.premia.common.bean.LovBean> lovPOL_END_CODE(Object currValue) {

	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_END_CODE','3',:CTRL.M_USER_ID,:PT_IL_POLICY.POL_PROD_CODE);
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_END_CODE", "3", CommonUtils
			    .getGlobalVariable("GLOBAL.M_USER_ID"),
		    PT_IL_POLICY_BEAN.getPOL_PROD_CODE(), null, null,
		    (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<LovBean> lovPOL_EMPLOYER_CODE(Object object) {
    	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT  CONT_CODE,CONT_NAME  FROM   PM_IL_CONTRACTOR WHERE  CONT_EMPLOYER_YN ='Y' "
				+ "AND (CONT_CODE LIKE ? OR CONT_NAME LIKE ?) AND ROWNUM < ?";
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PLAN_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {

	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_PLAN_CODE", null, null, null, null,
		    null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_SRC_OF_BUS(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {

	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_SRC_OF_BUS", "SRC_BUS_TY", null, null,
		    null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_SUB_PLAN_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_SUB_PLAN_CODE", PT_IL_POLICY_BEAN
			    .getPOL_PROD_CODE(), null, null, null, null,
		    (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_ADDL_STATUS(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.M_BUT_POL_ADDL_STATUS','IL_ADDL_STATUS',:PT_IL_POLICY.POL_DS_TYPE);
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_ADDL_STATUS", "IL_ADDL_STATUS",
		    PT_IL_POLICY_BEAN.getPOL_DS_TYPE(), null, null, null,
		    (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean>lovPOL_CLM_ADDL_STATUS(
	    Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.M_BUT_POL_ADDL_STATUS','IL_ADDL_STATUS',:PT_IL_POLICY.POL_DS_TYPE);
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_CLM_ADDL_STATUS", "IL_ADDL_STATUS",
		    PT_IL_POLICY_BEAN.getPOL_DS_TYPE(), null, null, null,
		    (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

   
    public ArrayList<com.iii.premia.common.bean.LovBean> lovM_BUT_POL_ADDL_STATUS(
	    Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	int M_VALUE =0;
	try {

	   
	if( "1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE() ) &&
		 "P".equals(PT_IL_POLICY_BEAN.getPOL_PROP_QUOT_FLAG() )){
		  
		 M_VALUE =1;
	}else if( "1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE() ) &&
			 "Q".equals(PT_IL_POLICY_BEAN.getPOL_PROP_QUOT_FLAG() )){
	    M_VALUE =5; 
	}
	else if( "2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE() )){
	 
		 M_VALUE = 2;
        	if( PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() > 0 ){
        		    M_VALUE = 3;
        	}
	}
	       suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
	       "DUMMY",
	       "M_PS_STATUS","IL_ADDL_STAT", M_VALUE,
	       null, null, null, (String) currValue);
	      
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_CONT_AD_BANK_CODE(
	    Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {

	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_CONT_AD_BANK_CODE", null, null, null,
		    null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PROJECT_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_PROJECT_CODE','IL_PROJ_CODE');
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_PROJECT_CODE", "IL_PROJ_CODE", null,
		    null, null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_CLASS_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_CLASS_CODE');
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_CLASS_CODE", null, null, null, null,
		    null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_DEVELOPER_CODE(
	    Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_DEVELOPER_CODE','IL_DVP_CODE');
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_DEVELOPER_CODE", "IL_DVP_CODE", null,
		    null, null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<LovBean> lovPOL_CONT_CODE(Object currValue) {
	String code = (String) currValue;
	ArrayList<LovBean> suggestionList = null;
	Object[] object = {};
	String query = null;
	try{
	if ("*".equals(code)) {
	    object = new Object[] { PELConstants.suggetionRecordSize };
	    query = PT_IL_POLICY_QUERY_CONSTANTS.POL_CONT_CODE_QUERY;
	} else {
	    object = new Object[] { code + "%", code + "%",PELConstants.suggetionRecordSize };
	    query = PT_IL_POLICY_QUERY_CONSTANTS.POL_CONT_CODE_QUERY_LIKE;
	}
	suggestionList = ListItemUtil.prepareSuggestionList(query, object);
	}catch (Exception e) {
		e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_BANK_BRANCH_NAME(
	    Object currValue) {
	ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    if (!"C".equals(PT_IL_POLICY_BEAN.getPOL_GRANTEE_TYPE())) {
		suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
			"PT_IL_POLICY", "POL_BANK_BRANCH_NAME",
			PT_IL_POLICY_BEAN.getPOL_CUST_CODE(), null, null, null,
			null, (String) currValue);

		// P_CALL_LOV('PT_IL_POLICY.POL_BANK_BRANCH_NAME',:PT_IL_POLICY.POL_CUST_CODE);
	    } else {
		suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
			"PT_IL_POLICY", "POL_BANK_BRANCH_NAME", "1", null,
			null, null, null, (String) currValue);
		// P_CALL_LOV('PT_IL_POLICY.POL_BANK_BRANCH_NAME','1');
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_SA_CURR_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_SA_CURR_CODE',:PT_IL_POLICY.POL_CUST_CODE);

	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_SA_CURR_CODE", PT_IL_POLICY_BEAN
			    .getPOL_CUST_CODE(), null, null, null, null,
		    (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public List<com.iii.premia.common.bean.LovBean> lovPOAD_RELIGION_CODE(
	    Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POL_ASSURED_DTLS.POAD_RELIGION_CODE','RELIGION');

	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POAD_RELIGION_CODE", "RELIGION", null,
		    null, null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<LovBean> lovPOL_DIVN_CODE(Object currValue) {
	ArrayList<LovBean> suggestionList = null;
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_DIVN_CODE',:CTRL.M_COMP_CODE,:CTRL.M_USER_ID);

	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_DIVN_CODE", CommonUtils
			    .getGlobalVariable("GLOBAL.M_COMP_CODE"),
		    CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"), null,
		    null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_DEPT_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_DEPT_CODE',:CTRL.M_COMP_CODE,
	    // :PT_IL_POLICY.POL_DIVN_CODE,:CTRL.M_USER_ID );

	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_DEPT_CODE", CommonUtils
			    .getGlobalVariable("GLOBAL.M_COMP_CODE"),
		    PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), CommonUtils
			    .getGlobalVariable("GLOBAL.M_USER_ID"), null, null,
		    (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_CUST_CURR_CODE(
	    Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('PT_IL_POLICY.POL_CUST_CURR_CODE',
	    // :PT_IL_POLICY.POL_CUST_CODE);
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POLICY", "POL_CUST_CURR_CODE", PT_IL_POLICY_BEAN
			    .getPOL_CUST_CODE(), null, null, null, null,
		    (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

   /* public ArrayList<LovBean> lovPOL_CUST_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	String M_FACIN_YN = null;
	String query = " SELECT NVL(CLASS_FACIN_YN, 'N')   	FROM   PM_IL_CLASS"
		+ "  WHERE  CLASS_CODE = ? ";

	ResultSet rs = null;
	Connection connection = null;

	try {
	    connection = CommonUtils.getConnection();
	    rs = new CRUDHandler().executeSelectStatement(query, connection,
		    new Object[] { PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });

	    while (rs.next()) {
		M_FACIN_YN = rs.getString(1);
	    }
	    if ("1".equals(compositeAction.getDUMMY_ACTION_BEAN()
		    .getDUMMY_BEAN().getUI_M_CALC_METHOD())
		    && "C".equals(CommonUtils
			    .getGlobalVariable("GLOBAL.M_PARA_7"))) {

		suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
			"PT_IL_POLICY", "POL_CUST_CODE", "BANK",
			PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), "BANK", null,
			null, (String) currValue);
		// STD_CALL_LOV('PILH152','PT_IL_POLICY.POL_CUST_CODE','BANK',:PT_IL_POLICY.POL_DIVN_CODE,'BANK');
	    } else {
		if ("N".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN
			.getPOL_CASH_YN(), "N"))) {
		    if ("N".equals(CommonUtils.nvl(M_FACIN_YN, "N"))) {

			suggestionList = listitemutil.P_CALL_LOV(
				"PILT002_APAC", "PT_IL_POLICY",
				"POL_CUST_CODE", "CUSTOMER", PT_IL_POLICY_BEAN
					.getPOL_DIVN_CODE(), "CUSTOMER", null,
				null, (String) currValue);

			// STD_CALL_LOV('PILH152','PT_IL_POLICY.POL_CUST_CODE','CUSTOMER',:PT_IL_POLICY.POL_DIVN_CODE,'CUSTOMER');
		    } else {
			suggestionList = listitemutil.P_CALL_LOV(
				"PILT002_APAC", "PT_IL_POLICY",
				"POL_CUST_CODE", "REINS", PT_IL_POLICY_BEAN
					.getPOL_DIVN_CODE(), "REINS", null,
				null, (String) currValue);

			// STD_CALL_LOV('PILH152','PT_IL_POLICY.POL_CUST_CODE','REINS',:PT_IL_POLICY.POL_DIVN_CODE,'REINS');
		    }
		} else {
		    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
			    "PT_IL_POLICY", "POL_CUST_CODE", "CASH",
			    PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), "CASH", null,
			    null, (String) currValue);

		    // STD_CALL_LOV('PILH152','PT_IL_POLICY.POL_CUST_CODE','CASH',:PT_IL_POLICY.POL_DIVN_CODE,'CASH');
		}
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }
*/
    
    
    
    // CALL THE Validator

    public void validatePOL_WAQAF_PERIOD_TO(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
	try {
	    helper.POL_WAQAF_PERIOD_TO_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_WAQAF_PERIOD_TO((Double)value);
	    //COMP_POL_WAQAF_PERIOD_TO.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
	    		.getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_WAQAF_PERIOD_TO",
			getWarningMap());
		
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_WAQAF_PERIOD_FM(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_WAQAF_PERIOD_FM_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_WAQAF_PERIOD_FM((Double)value);
	    //COMP_POL_WAQAF_PERIOD_FM.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_WAQAF_PERIOD_FM",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_DEF_PERIOD_TO(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_DEF_PERIOD_TO_WHEN_VALIDATE_ITEM(compositeAction, (Double)value);
	    PT_IL_POLICY_BEAN.setPOL_DEF_PERIOD_TO((Double)value);
	    //COMP_POL_DEF_PERIOD_TO.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_DEF_PERIOD_TO", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_DEF_PERIOD_FM(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	   
	    helper.POL_DEF_PERIOD_FM_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_PERIOD((Integer)value);
	    //COMP_POL_DEF_PERIOD_FM.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_DEF_PERIOD_FM", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_BASIC_RATE1(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_BASIC_RATE1_WHEN_VALIDATE_ITEM(compositeAction,(Double) value);
	    PT_IL_POLICY_BEAN.setPOL_BASIC_RATE1((Double)value);
	    //COMP_POL_BASIC_RATE1.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_BASIC_RATE1", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LC_BASIC_PREM1(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	   // helper.POL_LC_BASIC_PREM1_WHEN_VALIDATE_ITEM(
	    // compositeAction,Doublevalue));
	    //COMP_POL_LC_BASIC_PREM1.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil
			.getWarningForProcedure(CommonUtils.getConnection(),
				"POL_LC_BASIC_PREM1", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_CLASS_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_CLASS_CODE_WHEN_VALIDATE_ITEM(compositeAction,(String) value );
	    PT_IL_POLICY_BEAN.setPOL_CLASS_CODE((String)value);
	    //COMP_POL_CLASS_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_CLASS_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_DEPT_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_DEPT_CODE((String)value);
	    helper.POL_DEPT_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    COMP_UI_M_POL_DEPT_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_DEPT_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_DIVN_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_DIVN_CODE_WHEN_VALIDATE_ITEM(compositeAction,(String) value);
	    PT_IL_POLICY_BEAN.setPOL_DIVN_CODE((String)value);
//	    COMP_POL_DIVN_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_DIVN_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LC_PRE_TPD_BNF(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_LC_PRE_TPD_BNF_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_LC_PRE_TPD_BNF((Double)value);
	    //COMP_POL_LC_PRE_TPD_BNF.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil
			.getWarningForProcedure(CommonUtils.getConnection(),
				"POL_LC_PRE_TPD_BNF", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FC_PRE_TPD_BNF(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FC_PRE_TPD_BNF_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_FC_PRE_TPD_BNF((Double)value);
	    //COMP_POL_FC_PRE_TPD_BNF.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil
			.getWarningForProcedure(CommonUtils.getConnection(),
				"POL_FC_PRE_TPD_BNF", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LC_CLIENT_ALLOC_AMT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_LC_CLIENT_ALLOC_AMT_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_LC_CLIENT_ALLOC_AMT((Double)value);
	    
	    //COMP_POL_LC_CLIENT_ALLOC_AMT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_LC_CLIENT_ALLOC_AMT",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FC_CLIENT_ALLOC_AMT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FC_CLIENT_ALLOC_AMT_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_FC_CLIENT_ALLOC_AMT((Double)value);
	    //COMP_POL_FC_CLIENT_ALLOC_AMT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FC_CLIENT_ALLOC_AMT",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LC_BANK_ALLOC_AMT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_LC_BANK_ALLOC_AMT_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_LC_BANK_ALLOC_AMT((Double)value);
	    //COMP_POL_LC_BANK_ALLOC_AMT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_LC_BANK_ALLOC_AMT",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FC_BANK_ALLOC_AMT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FC_BANK_ALLOC_AMT_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_FC_BANK_ALLOC_AMT((Double)value);
	    //COMP_POL_FC_BANK_ALLOC_AMT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FC_BANK_ALLOC_AMT",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LC_NET_PREM(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_LC_NET_PREM_WHEN_VALIDATE_ITEM(compositeAction, (Double)value);
	    PT_IL_POLICY_BEAN.setPOL_LC_NET_PREM((Double) value);
	    //COMP_POL_LC_NET_PREM.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_LC_NET_PREM", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FC_NET_PREM(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FC_NET_PREM_WHEN_VALIDATE_ITEM(compositeAction, (Double)value);
	    PT_IL_POLICY_BEAN.setPOL_FC_NET_PREM((Double)value);
	    //COMP_POL_FC_NET_PREM.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FC_NET_PREM", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LC_SENABEL_PREM(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		
	    helper.POL_LC_SENABEL_PREM_WHEN_VALIDATE_ITEM(compositeAction);
	    PT_IL_POLICY_BEAN.setPOL_LC_SENABEL_PREM((Double)value);
	    // COMP_POL_LC_SENABEL_PREM.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_LC_SENABEL_PREM",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FC_SENABEL_PREM(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FC_SENABEL_PREM_WHEN_VALIDATE_ITEM(compositeAction);
	    PT_IL_POLICY_BEAN.setPOL_FC_SENABEL_PREM((Double)value);
	    // COMP_POL_FC_SENABEL_PREM.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FC_SENABEL_PREM",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LC_AMAN_PREM(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_LC_AMAN_PREM_WHEN_VALIDATE_ITEM(compositeAction);
	    PT_IL_POLICY_BEAN.setPOL_LC_AMAN_PREM((Double)value);
	    // COMP_POL_LC_AMAN_PREM.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_LC_AMAN_PREM", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FC_AMAN_PREM(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FC_AMAN_PREM_WHEN_VALIDATE_ITEM(compositeAction);
	    PT_IL_POLICY_BEAN.setPOL_FC_AMAN_PREM((Double)value);
	    // COMP_POL_FC_AMAN_PREM.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FC_AMAN_PREM", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_END_EFF_TO_DT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Date curDate = (Date) value;
	try {
	    helper.POL_END_EFF_TO_DT_WHEN_VALIDATE_ITEM(compositeAction,curDate);
	    PT_IL_POLICY_BEAN.setPOL_END_EFF_TO_DT(curDate);
	   // COMP_POL_END_EFF_TO_DT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_END_EFF_TO_DT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_END_EFF_FROM_DT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Date curDate = (Date) value;
	try {
	    PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT((Date)value);
	    helper.POL_END_EFF_FROM_DT_WHEN_VALIDATE_ITEM(compositeAction, curDate);
	    // COMP_POL_END_EFF_FROM_DT.resetValue();
	    COMP_POL_END_EFF_TO_DT.resetValue();
	    compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_AGE().resetValue();
	    compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getCOMP_POAD_AGE().resetValue();
	    
	    
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_END_EFF_FROM_DT",
			getWarningMap());
	    }catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_END_NO(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_END_NO_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    PT_IL_POLICY_BEAN.setPOL_END_NO((String)value);
	    //COMP_POL_END_NO.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_END_NO", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_END_DT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Date curDate = (Date) value;
	try {
	    helper.POL_END_DT_WHEN_VALIDATE_ITEM(compositeAction, curDate);
	    COMP_POL_END_DT.resetValue();
	    COMP_POL_END_EFF_FROM_DT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_END_DT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_END_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_END_CODE_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	    PT_IL_POLICY_BEAN.setPOL_END_CODE((String)value);
	    //COMP_POL_END_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_END_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_HEALTH_RATE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_HEALTH_RATE_WHEN_VALIDATE_ITEM(compositeAction,(Double) value);
	    PT_IL_POLICY_BEAN.setPOL_HEALTH_RATE((Double)value);

	    //COMP_POL_HEALTH_RATE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_HEALTH_RATE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_OCC_RATE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_OCC_RATE_WHEN_VALIDATE_ITEM(compositeAction, (Double)value);
	    PT_IL_POLICY_BEAN.setPOL_OCC_RATE((Double)value);
	    COMP_POL_OCC_RATE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_OCC_RATE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LC_BASIC_PREM(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_LC_BASIC_PREM((Double)value);
	    // helper.POL_LC_BASIC_PREM_WHEN_VALIDATE_ITEM( compositeAction,
	    // value);
	    //COMP_POL_LC_BASIC_PREM.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_LC_BASIC_PREM", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FC_BASIC_PREM(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FC_BASIC_PREM_WHEN_VALIDATE_ITEM(compositeAction, (Double)value);
	    PT_IL_POLICY_BEAN.setPOL_FC_BASIC_PREM((Double)value);
	     COMP_POL_FC_BASIC_PREM.resetValue();
	     COMP_POL_LC_BASIC_PREM.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FC_BASIC_PREM", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_BASIC_RATE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_BASIC_RATE_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_BASIC_RATE((Double)value);
	    //COMP_POL_BASIC_RATE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_BASIC_RATE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_OFF_AREA_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_OFF_AREA_CODE_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	    PT_IL_POLICY_BEAN.setPOL_OFF_AREA_CODE((String)value);
	    
	    //COMP_POL_OFF_AREA_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_OFF_AREA_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_COUNT_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
    	 String values = (String)value;
	try {
	    helper.POL_COUNT_CODE_WHEN_VALIDATE_ITEM(compositeAction, values);
	    PT_IL_POLICY_BEAN.setPOL_COUNT_CODE(values);
	    //COMP_POL_COUNT_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_COUNT_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_STATE_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_STATE_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    PT_IL_POLICY_BEAN.setPOL_STATE_CODE((String)value);
	    //COMP_POL_STATE_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_STATE_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_CITY_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_CITY_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
		 PT_IL_POLICY_BEAN.setPOL_CITY_CODE((String)value);  
	    //COMP_POL_CITY_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_CITY_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_RES_AREA_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_RES_AREA_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    PT_IL_POLICY_BEAN.setPOL_RES_AREA_CODE((String)value);
	    //COMP_POL_RES_AREA_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_RES_AREA_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

   

    public void validatePOL_FRZ_FLAG(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FRZ_FLAG_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    PT_IL_POLICY_BEAN.setPOL_FRZ_FLAG((String)value);
	    //COMP_POL_FRZ_FLAG.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FRZ_FLAG", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_PROP_REF_NO(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_PROP_REF_NO_WHEN_VALIDATE_ITEM(compositeAction,(String) value);
	    PT_IL_POLICY_BEAN.setPOL_PROP_REF_NO((String)value);
	    //COMP_POL_PROP_REF_NO.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PROP_REF_NO", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_CREDIT_DISCOUNT_PERC(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_CREDIT_DISCOUNT_PERC_WHEN_VALIDATE_ITEM((Double) value);
	    PT_IL_POLICY_BEAN.setPOL_CREDIT_DISCOUNT_PERC((Double)value);
	    //COMP_POL_CREDIT_DISCOUNT_PERC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_CREDIT_DISCOUNT_PERC",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LOAD_PERC(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_LOAD_PERC_WHEN_VALIDATE_ITEM((Double)value);
	    PT_IL_POLICY_BEAN.setPOL_LOAD_PERC((Double)value); 
	    //COMP_POL_LOAD_PERC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_LOAD_PERC", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_EXC_INT_PERC(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_EXC_INT_PERC_WHEN_VALIDATE_ITEM((Double)value);
	    PT_IL_POLICY_BEAN.setPOL_EXC_INT_PERC((Double)value);
	    //COMP_POL_EXC_INT_PERC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_EXC_INT_PERC", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FC_EXC_INT_AMT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FC_EXC_INT_AMT_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_FC_EXC_INT_AMT((Double)value);
	    //COMP_POL_FC_EXC_INT_AMT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil
			.getWarningForProcedure(CommonUtils.getConnection(),
				"POL_FC_EXC_INT_AMT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LC_EXC_INT_AMT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
    	Double cuDouble = (Double)value;
	try {
	   cuDouble = helper.POL_LC_EXC_INT_AMT_WHEN_VALIDATE_ITEM(compositeAction,cuDouble);
	    PT_IL_POLICY_BEAN.setPOL_LC_EXC_INT_AMT(cuDouble);
	    //COMP_POL_LC_EXC_INT_AMT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil
			.getWarningForProcedure(CommonUtils.getConnection(),
				"POL_LC_EXC_INT_AMT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_PROP_DECL_DT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Date curDate = (Date) value;
	try {
	    helper.POL_PROP_DECL_DT_WHEN_VALIDATE_ITEM(compositeAction,curDate);
	    PT_IL_POLICY_BEAN.setPOL_PROP_DECL_DT(curDate);
	    //COMP_POL_PROP_DECL_DT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PROP_DECL_DT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_PROP_STAMP_DT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Date curDate = (Date) value;
	try {
	    helper.POL_PROP_STAMP_DT_WHEN_VALIDATE_ITEM(compositeAction,curDate);
	    PT_IL_POLICY_BEAN.setPOL_PROP_STAMP_DT(curDate);
	    //COMP_POL_PROP_STAMP_DT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PROP_STAMP_DT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_PROP_RECV_DT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Date curDate = (Date) value;
	try {
	    helper.POL_PROP_RECV_DT_WHEN_VALIDATE_ITEM(compositeAction,curDate);
	    PT_IL_POLICY_BEAN.setPOL_PROP_RECV_DT(curDate);
	    //COMP_POL_PROP_RECV_DT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PROP_RECV_DT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_PROJECT_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_PROJECT_CODE_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	    PT_IL_POLICY_BEAN.setPOL_PROJECT_CODE((String)value);
	    COMP_POL_DEVELOPER_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PROJECT_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_PROFIT_RATE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_PROFIT_RATE_WHEN_VALIDATE_ITEM(compositeAction, (Double)value);
	    PT_IL_POLICY_BEAN.setPOL_PROFIT_RATE((Double)value);
	    //COMP_POL_PROFIT_RATE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PROFIT_RATE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_AUTH_LIMIT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_AUTH_LIMIT((Double)value);
	    helper.POL_AUTH_LIMIT_WHEN_VALIDATE_ITEM(compositeAction,(Double) value);

	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_AUTH_LIMIT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_CARD_HOLDER_NAME(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_CARD_HOLDER_NAME((String)value);
	    helper.POL_CARD_HOLDER_NAME_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	    
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_CARD_HOLDER_NAME",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_CONT_AD_BANK_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_CONT_AD_BANK_CODE((String)value);
	    helper.POL_CONT_AD_BANK_CODE_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	    COMP_UI_M_BANK_CODE_DESC.resetValue();

	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_CONT_AD_BANK_CODE",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validateUI_M_POL_CONT_AD_ACC_NO(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setUI_M_POL_CONT_AD_ACC_NO((Integer)value);
	    helper.UI_M_POL_CONT_AD_ACC_NO_WHEN_VALIDATE_ITEM(compositeAction,(Integer)value);
	    //COMP_UI_M_POL_CONT_AD_ACC_NO.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_POL_CONT_AD_ACC_NO",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_CQS_PERC(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_CQS_PERC((Double)value);
	    helper.POL_CQS_PERC_WHEN_VALIDATE_ITEM(compositeAction, (Double)value);
	    
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_CQS_PERC", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validateListChangedPOL_CQS_YN(ActionEvent actionEvent)
	    throws ValidatorException {
	CommonUtils.clearMaps(this);
	UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
	Object value = uiInput.getSubmittedValue();
	try {
	    helper.POL_CQS_YN_WHEN_LIST_CHANGED(compositeAction,(String) value);
	    PT_IL_POLICY_BEAN.setPOL_CQS_YN((String)value);
	    //COMP_POL_CQS_YN.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_CQS_YN", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_CQS_YN(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_CQS_YN((String)value);
	    helper.POL_CQS_YN_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	    COMP_POL_CQS_PERC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_CQS_YN", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_RI_POOL_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_RI_POOL_CODE((String)value);
	    helper.POL_RI_POOL_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    COMP_UI_M_POL_RI_POOL_CODE_DESC.resetValue();
	    
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_RI_POOL_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FAC_BASIS(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_FAC_BASIS((String)value);
	    helper.POL_FAC_BASIS_WHEN_VALIDATE_ITEM(compositeAction,(String) value);
	    COMP_POL_RI_POOL_CODE.resetValue();
	    //COMP_POL_FAC_BASIS.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FAC_BASIS", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validateListChangedPOL_FAC_YN(ActionEvent actionEvent)
	    throws ValidatorException {
	CommonUtils.clearMaps(this);
	UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
	Object value = uiInput.getSubmittedValue();
	try {
	    helper.POL_FAC_YN_WHEN_LIST_CHANGED(compositeAction,(String) value);
	    PT_IL_POLICY_BEAN.setPOL_FAC_YN((String)value);
	    //COMP_POL_FAC_YN.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FAC_YN", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FAC_YN(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_FAC_YN((String) value);
	    helper.POL_FAC_YN_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
	    COMP_POL_FAC_BASIS.resetValue();
	    COMP_POL_RI_POOL_CODE.resetValue();

	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FAC_YN", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_STAFF_CCLASS_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_STAFF_CCLASS_CODE((String)value);
	    helper.POL_STAFF_CCLASS_CODE_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	    COMP_UI_M_CCLAS_CLASS_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception.getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_STAFF_CCLASS_CODE",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validateListChangedPOL_STAFF_YN(ActionEvent actionEvent)
	    throws ValidatorException {
	CommonUtils.clearMaps(this);
	UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
	Object value = uiInput.getSubmittedValue();
	try {
	    helper.POL_STAFF_YN_WHEN_LIST_CHANGED(compositeAction,(String)value);
	    //COMP_POL_STAFF_YN.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_STAFF_YN", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_STAFF_YN(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_STAFF_YN((String)value);
	    helper.POL_STAFF_YN_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	    COMP_POL_STAFF_CCLASS_CODE.resetValue();
	    COMP_POL_FC_DISC_AMT.resetValue();
	    //COMP_POL_STAFF_YN.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_STAFF_YN", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

   /* public void validatePOL_BANK_REF_NO(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {

	try {
	    helper.POL_BANK_REF_NO_WHEN_VALIDATE_ITEM(compositeAction, value);
	    COMP_POL_BANK_REF_NO.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_BANK_REF_NO", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }*/

    public void validatePOL_INTRODUCER_REF_ID1(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_INTRODUCER_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	    PT_IL_POLICY_BEAN.setPOL_INTRODUCER_REF_ID1((String)value);
	    COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_INTRODUCER_REF_ID1",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_BANK_BRANCH_NAME(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_BANK_BRANCH_NAME_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	    PT_IL_POLICY_BEAN.setPOL_BANK_BRANCH_NAME((String)value);
	    COMP_UI_M_BANK_CODE_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_BANK_BRANCH_NAME",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validateListChangedPOL_GRANTEE_TYPE(ActionEvent actionEvent)
	    throws ValidatorException {
	CommonUtils.clearMaps(this);
	UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
	Object value = uiInput.getSubmittedValue();
	try {
	    helper.POL_GRANTEE_TYPE_WHEN_LIST_CHANGED(compositeAction, (String)value);
	    //COMP_POL_GRANTEE_TYPE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_GRANTEE_TYPE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_GRANTEE_TYPE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_GRANTEE_TYPE_WHEN_VALIDATE_ITEM(compositeAction,(String) value);
	    PT_IL_POLICY_BEAN.setPOL_GRANTEE_TYPE((String)value);
	    COMP_POL_GRANTEE_NAME.resetValue();
	   
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_GRANTEE_TYPE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validateListChangedPOL_INCORPORATED_YN(ActionEvent actionEvent)
	    throws ValidatorException {
	CommonUtils.clearMaps(this);
	UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
	Object value = uiInput.getSubmittedValue();
	try {
	    helper.POL_INCORPORATED_YN_WHEN_LIST_CHANGED(compositeAction, (String)value);
	    PT_IL_POLICY_BEAN.setPOL_INCORPORATED_YN((String)value);
	    //COMP_POL_INCORPORATED_YN.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_INCORPORATED_YN",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_INCORPORATED_YN(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_INCORPORATED_YN_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	    PT_IL_POLICY_BEAN.setPOL_INCORPORATED_YN((String)value);
	    COMP_POL_FC_BANK_ALLOC_AMT.resetValue();
	    COMP_POL_LC_BANK_ALLOC_AMT.resetValue();
	    COMP_POL_FC_CLIENT_ALLOC_AMT.resetValue();
	    COMP_POL_LC_CLIENT_ALLOC_AMT.resetValue();
	    COMP_POL_FC_TOT_SA.resetValue();
	    COMP_POL_FC_TOT_SA.resetValue();
//	    COMP_POL_INCORPORATED_YN.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_INCORPORATED_YN",getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_DEFER_PRD(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_DEFER_PRD_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_DEFER_PRD((Double)value);
	//    COMP_POL_DEFER_PRD.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_DEFER_PRD", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_EMPLOYER_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_EMPLOYER_CODE_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN,(String)value);
	    PT_IL_POLICY_BEAN.setPOL_EMPLOYER_CODE((String) value);
	    //COMP_POL_EMPLOYER_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_EMPLOYER_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_PAYOR_SDCODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_PAYOR_SDCODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
	    PT_IL_POLICY_BEAN.setPOL_PAYOR_SDCODE((String)value);
	    //COMP_POL_PAYOR_SDCODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PAYOR_SDCODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validateListChangedPOL_PYMT_TYPE(ActionEvent actionEvent)
	    throws ValidatorException {
	CommonUtils.clearMaps(this);
	UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
	Object value = uiInput.getSubmittedValue();
	try {
	    helper.POL_PYMT_TYPE_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    //COMP_POL_PYMT_TYPE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PYMT_TYPE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_PYMT_TYPE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_PYMT_TYPE_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	    PT_IL_POLICY_BEAN.setPOL_PYMT_TYPE((String)value);
	    //COMP_POL_PYMT_TYPE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PYMT_TYPE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FC_MON_ANNU_AMT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FC_MON_ANNU_AMT_WHEN_VALIDATE_ITEM(compositeAction,(Double) value);
	    PT_IL_POLICY_BEAN.setPOL_FC_MON_ANNU_AMT((Double)value);
	    //COMP_POL_FC_MON_ANNU_AMT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FC_MON_ANNU_AMT",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LAST_INST_DT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Date curDate = (Date) value;
	try {
		PT_IL_POLICY_BEAN.setPOL_LAST_INST_DT(curDate);
	    helper.POL_LAST_INST_DT_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN.getPOL_FIRST_INST_DT(),curDate);
	    //COMP_POL_LAST_INST_DT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_LAST_INST_DT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FIRST_INST_DT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Date curDate = (Date) value;
	try {
	    helper.POL_FIRST_INST_DT_WHEN_VALIDATE_ITEM(compositeAction,curDate);
	    PT_IL_POLICY_BEAN.setPOL_FIRST_INST_DT(curDate);
	    COMP_POL_LAST_INST_DT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FIRST_INST_DT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LC_DEPOSIT_AMOUNT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
    	  Double currDouble = (Double)value;
	try {
	    helper.POL_LC_DEPOSIT_AMOUNT_WHEN_VALIDATE_ITEM(compositeAction,currDouble);
	    PT_IL_POLICY_BEAN.setPOL_LC_DEPOSIT_AMOUNT(currDouble);
	   //COMP_POL_LC_DEPOSIT_AMOUNT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_LC_DEPOSIT_AMOUNT",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FC_DEPOSIT_AMOUNT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
    Double currDouble = (Double)value;
	try {
	    currDouble = helper.POL_FC_DEPOSIT_AMOUNT_WHEN_VALIDATE_ITEM(compositeAction,currDouble);
	    PT_IL_POLICY_BEAN.setPOL_FC_DEPOSIT_AMOUNT(currDouble);
	    COMP_POL_LC_DEPOSIT_AMOUNT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FC_DEPOSIT_AMOUNT",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LC_SUM_ASSURED(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_LC_SUM_ASSURED_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED((Double)value);
	    //COMP_POL_LC_SUM_ASSURED.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil
			.getWarningForProcedure(CommonUtils.getConnection(),
				"POL_LC_SUM_ASSURED", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validateClearBlockPOL_FC_SUM_ASSURED(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FC_SUM_ASSURED_WHEN_CLEAR_BLOCK(compositeAction, (Double)value);
	    PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED((Double)value);
	    //COMP_POL_FC_SUM_ASSURED.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil
			.getWarningForProcedure(CommonUtils.getConnection(),
				"POL_FC_SUM_ASSURED", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validateNewItemInstancePOL_FC_SUM_ASSURED(
	    FacesContext facesContext, UIComponent component, Object value)
	    throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FC_SUM_ASSURED_WHEN_NEW_ITEM_INSTANCE(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED((Double)value);
	    //COMP_POL_FC_SUM_ASSURED.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil
			.getWarningForProcedure(CommonUtils.getConnection(),
				"POL_FC_SUM_ASSURED", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FC_SUM_ASSURED(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_FC_SUM_ASSURED_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED((Double)value);
	    COMP_POL_FC_SUM_ASSURED.resetValue();
	    COMP_POL_LC_SUM_ASSURED.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil
			.getWarningForProcedure(CommonUtils.getConnection(),
				"POL_FC_SUM_ASSURED", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_MODE_OF_PYMT_RATE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_MODE_OF_PYMT_RATE_WHEN_VALIDATE_ITEM(compositeAction,(Double)value);
	    PT_IL_POLICY_BEAN.setPOL_MODE_OF_PYMT_RATE((Double)value);
	    //COMP_POL_MODE_OF_PYMT_RATE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_MODE_OF_PYMT_RATE",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_NO_OF_INST(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_NO_OF_INST_WHEN_VALIDATE_ITEM(compositeAction, (Integer)value);
	    PT_IL_POLICY_BEAN.setPOL_NO_OF_INST((Integer) value);
	    
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_NO_OF_INST", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validateListChangedPOL_MODE_OF_PYMT(ActionEvent actionEvent)
	    throws ValidatorException {
	CommonUtils.clearMaps(this);
	UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
	Object value = uiInput.getSubmittedValue();
	try {
	    helper.POL_MODE_OF_PYMT_WHEN_LIST_CHANGED(compositeAction,(String) value);
	   // COMP_POL_MODE_OF_PYMT.resetValue();
	    
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_MODE_OF_PYMT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_MODE_OF_PYMT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_MODE_OF_PYMT((String)value);
	    helper.POL_MODE_OF_PYMT_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    COMP_POL_MODE_OF_PYMT_RATE.resetValue();
	    COMP_POL_NO_OF_INST.resetValue();
	    COMP_POL_EXPIRY_DT.resetValue();
	    COMP_POL_LAST_INST_DT.resetValue();
	    COMP_POL_FC_MODAL_PREM.resetValue();
	    COMP_POL_LC_MODAL_PREM.resetValue();
	    COMP_POL_FC_BASIC_PREM.resetValue();
	    COMP_POL_LC_BASIC_PREM.resetValue();
	    COMP_POL_FC_SUM_ASSURED.resetValue();
	    COMP_POL_LC_SUM_ASSURED.resetValue();
	    COMP_POL_FC_CURR_SA.resetValue();
	    COMP_POL_LC_CURR_SA.resetValue();
	    COMP_POL_ORG_NEW_LC_SA.resetValue();
	    COMP_POL_ORG_NEW_FC_SA.resetValue();
	    COMP_POL_NEW_LC_SA.resetValue();
	    COMP_POL_FC_MON_ANNU_AMT.resetValue();
	    COMP_POL_LC_MON_ANNU_AMT.resetValue();
	    COMP_POL_NO_OF_UNIT.resetValue();
	    COMP_POL_LC_MIN_PREM.resetValue();
	    COMP_POL_FC_MIN_PREM.resetValue();
	    COMP_POL_FC_EXTRA_PREM.resetValue();
	    COMP_POL_LC_EXTRA_PREM.resetValue();

	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_MODE_OF_PYMT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_LC_MODAL_PREM(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Double currDouble = (Double)value;
  
	try {
	    currDouble = helper.POL_LC_MODAL_PREM_WHEN_VALIDATE_ITEM(compositeAction,currDouble);
	    PT_IL_POLICY_BEAN.setPOL_LC_MODAL_PREM(currDouble);
	    
	    //COMP_POL_LC_MODAL_PREM.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_LC_MODAL_PREM", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_NO_OF_UNIT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_NO_OF_UNIT((Double)value);
	    helper.POL_NO_OF_UNIT_WHEN_VALIDATE_ITEM(compositeAction, (Double)value);
	    COMP_POL_FC_SUM_ASSURED.resetValue();
	    COMP_POL_LC_SUM_ASSURED.resetValue();
	    //COMP_POL_NO_OF_UNIT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_NO_OF_UNIT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_FC_MODAL_PREM(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Double currValue = (Double)value;
	try {
	    currValue = helper.POL_FC_MODAL_PREM_WHEN_VALIDATE_ITEM(compositeAction,currValue);
	    PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(currValue);
	    
	    COMP_POL_NEW_FC_SA.resetValue();
	    COMP_POL_NEW_LC_SA.resetValue();
	    COMP_POL_NO_OF_UNIT.resetValue();
	    COMP_POL_LC_BASIC_PREM.resetValue();
	    COMP_POL_FC_BASIC_PREM.resetValue();
	    COMP_POL_FC_SUM_ASSURED.resetValue();
	    COMP_POL_LC_SUM_ASSURED.resetValue();
	    COMP_POL_FC_CURR_SA.resetValue();
	    COMP_POL_LC_CURR_SA.resetValue();
	    COMP_POL_ORG_NEW_LC_SA.resetValue();
	    COMP_POL_ORG_NEW_FC_SA.resetValue();
	    COMP_POL_LC_MODAL_PREM.resetValue();
	    COMP_POL_FC_MODAL_PREM.resetValue();
	    COMP_POL_FC_MON_ANNU_AMT.resetValue();
	    COMP_POL_LC_MON_ANNU_AMT.resetValue();
	    COMP_POL_LC_MIN_PREM.resetValue();
	    COMP_POL_FC_MIN_PREM.resetValue();
	    COMP_POL_FC_EXTRA_PREM.resetValue();
	    COMP_POL_LC_EXTRA_PREM.resetValue();
	    
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_FC_MODAL_PREM", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_CUST_CURR_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_CUST_CURR_CODE_WHEN_VALIDATE_ITEM(compositeAction,(String) value);
	    PT_IL_POLICY_BEAN.setPOL_CUST_CURR_CODE((String)value);
	    COMP_POL_CUST_EXCH_RATE.resetValue();
	    COMP_UI_M_POL_CUST_CURR_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil
			.getWarningForProcedure(CommonUtils.getConnection(),
				"POL_CUST_CURR_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_SA_EXCH_RATE(FacesContext facesContext,
	    UIComponent component, Object value)   {
	CommonUtils.clearMaps(this);
        Double currvalue= (Double)value;
	try {
	    PT_IL_POLICY_BEAN.setPOL_SA_EXCH_RATE(currvalue);
	   currvalue = helper.POL_SA_EXCH_RATE_WHEN_VALIDATE_ITEM(compositeAction,currvalue);
	     COMP_POL_SA_EXCH_RATE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_SA_EXCH_RATE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_SA_CURR_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_SA_CURR_CODE((String)value);
	    helper.POL_SA_CURR_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    COMP_POL_SA_EXCH_RATE.resetValue();
	    COMP_UI_M_POL_SA_CURR_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_SA_CURR_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_EXPIRY_DT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Date currValue = (Date) value;
	try {
	    helper.POL_EXPIRY_DT_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN,currValue);
	    PT_IL_POLICY_BEAN.setPOL_EXPIRY_DT(currValue);
	    //COMP_POL_EXPIRY_DT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_EXPIRY_DT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_START_DT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Date currValue = (Date) value;
	try {
		PT_IL_POLICY_BEAN.setPOL_START_DT(currValue);
		helper.POL_START_DT_WHEN_VALIDATE_ITEM(compositeAction, currValue);
	     COMP_POL_EXPIRY_DT.resetValue();
	     COMP_POL_FIRST_INST_DT.resetValue();
	     COMP_POL_UW_YEAR.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_START_DT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_PREM_PAY_YRS(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
    	Integer values =  (Integer)value;
	try {
	    PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(values);
	    values= helper.POL_PREM_PAY_YRS_WHEN_VALIDATE_ITEM(compositeAction, values);
	    COMP_POL_FIRST_INST_DT.resetValue();
	    COMP_POL_LAST_INST_DT.resetValue();
	   COMP_POL_PREM_PAY_YRS.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PREM_PAY_YRS", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_PERIOD(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_PERIOD((Integer)value);
	    helper.POL_PERIOD_WHEN_VALIDATE_ITEM(compositeAction, (Integer)value);
	     COMP_POL_PERIOD.resetValue();
	     
	/*	PT_IL_POLICY_BEAN.setPOL_PERIOD((Integer)value);
	    helper.POL_PERIOD_WHEN_VALIDATE_ITEM(compositeAction, (Integer)value);
	   */
	    COMP_POL_START_DT.resetValue();
	    COMP_POL_EXPIRY_DT.resetValue();
	   
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(),"POL_PERIOD",getWarningMap());
	    } catch (Exception e) {
	    	
	    	e.printStackTrace();
	    }
	}
    }

    public void validatePOL_SUB_PLAN_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_SUB_PLAN_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    PT_IL_POLICY_BEAN.setPOL_SUB_PLAN_CODE((String)value);
	    //COMP_POL_SUB_PLAN_CODE.resetValue();
	    COMP_UI_M_POL_SUB_PLAN_CODE_DESC.resetValue();
	    COMP_POL_FC_SUM_ASSURED.resetValue();
	    COMP_POL_LC_SUM_ASSURED.resetValue();
	    
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_SUB_PLAN_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_CONT_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		PT_IL_POLICY_BEAN.setPOL_CONT_CODE((String)value);
	    helper.POL_CONT_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    COMP_POL_ASSURED_NAME.resetValue();
	    COMP_POL_PREM_PAY_YRS.resetValue();
	    COMP_POL_PERIOD.resetValue();
	    //COMP_POL_CONT_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_CONT_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_SRC_OF_BUS(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    helper.POL_SRC_OF_BUS_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    PT_IL_POLICY_BEAN.setPOL_SRC_OF_BUS((String)value);
	    COMP_POL_SRC_OF_BUS.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_SRC_OF_BUS", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_CUST_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_CUST_CODE((String)value);
	    helper.POL_CUST_CODE_WHEN_VALIDATE_ITEM(compositeAction,(String) value);
	    COMP_UI_M_POL_CUST_DESC.resetValue();
	     
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_CUST_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_PROP_NO(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_PROP_NO((String)value);
	    helper.POL_PROP_NO_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN
		    .getPOL_DS_TYPE(),(String) value);
	     COMP_POL_PROP_NO.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PROP_NO", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_ASSRD_REF_ID2(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2((String)value);
	    helper.POL_ASSRD_REF_ID2_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	   COMP_POL_CUST_CODE.resetValue();

	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_ASSRD_REF_ID2", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_ASSRD_REF_ID1(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1((String)value);
	    helper.POL_ASSRD_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction,(String) value);
	     COMP_POL_ASSRD_REF_ID1.resetValue();

	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_ASSRD_REF_ID1", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_NO(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_NO((String)value);
	    helper.POL_NO_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),(String) value);
	     COMP_POL_NO.resetValue();

	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_NO", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_JOINT_LIFE_YN(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_JOINT_LIFE_YN((String)value);
	    helper.POL_JOINT_LIFE_YN_WHEN_VALIDATE_ITEM(compositeAction,(String) value);
	     COMP_POL_JOINT_LIFE_YN.resetValue();

	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_JOINT_LIFE_YN", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    
    

    public void validatePOL_PROD_GROUP_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_PROD_GROUP_CODE((String)value);
	    helper.POL_PROD_GROUP_CODE_WHEN_VALIDATE_ITEM(this,PT_IL_POLICY_BEAN, (String)value);
	    COMP_POL_PROD_CODE.resetValue();
	     COMP_UI_M_POL_PROD_GROUP_CODE.resetValue();
	   //  validatePOL_PROD_CODE(facesContext, component, value);
	  //   validatePOL_PLAN_CODE(facesContext, component, value);
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PROD_GROUP_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    public void validatePOL_PROD_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_PROD_CODE((String)value);
	    //	PT_IL_POLICY_BEAN.setPOL_PROD_CODE((String)value);
	    helper.POL_PROD_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String)value);
	    //    COMP_POL_PROD_CODE.resetValue();
	    COMP_UI_M_PROD_DESC.resetValue();
	    COMP_POL_PLAN_CODE.resetValue();
	    COMP_UI_M_POL_PLAN_DESC.resetValue();
	    COMP_POL_TARIFF_TERM_FLAG.resetValue();
	    
	    COMP_POL_PERIOD.resetValue();
	    COMP_POL_PREM_PAY_YRS.resetValue();
	    COMP_POL_FC_MODAL_PREM.resetValue();
	    COMP_POL_LC_MODAL_PREM.resetValue();
	    
	    COMP_POL_ISSUE_DT.resetValue();
	    COMP_POL_MASTER_POL_NO.resetValue();
	    COMP_POL_DEFER_PRD.resetValue();
	    COMP_POL_JOINT_LIFE_YN.resetValue();

	    getCOMP_POL_PROD_CODE().setDisabled(true);
	    
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PROD_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_PLAN_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PT_IL_POLICY_BEAN.setPOL_PLAN_CODE((String)value);
	    helper.POL_PLAN_CODE_WHEN_VALIDATE_ITEM(compositeAction,(String)value);
	   // COMP_POL_PLAN_CODE.resetValue();
	    COMP_UI_M_POL_PLAN_DESC.resetValue();

	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_PLAN_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePOL_ISSUE_DT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	Date dtValue = (Date) value;
	try {
	    PT_IL_POLICY_BEAN.setPOL_ISSUE_DT(dtValue);
	    helper.POL_ISSUE_DT_WHEN_VALIDATE_ITEM(compositeAction, dtValue);
	    COMP_POL_UW_YEAR.resetValue();
	    COMP_POL_START_DT.resetValue();
	    COMP_POL_PROP_RECV_DT.resetValue();
	    COMP_POL_PROP_STAMP_DT.resetValue();
	    COMP_POL_EXPIRY_DT.resetValue();
	     //COMP_POL_ISSUE_DT.resetValue();
	    
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "POL_ISSUE_DT", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    // lov

    public HtmlOutputLabel getCOMP_POL_OCC_RATE_LABEL() {
	return COMP_POL_OCC_RATE_LABEL;
    }

    public void setCOMP_POL_OCC_RATE_LABEL(
	    HtmlOutputLabel comp_pol_occ_rate_label) {
	COMP_POL_OCC_RATE_LABEL = comp_pol_occ_rate_label;
    }

    public HtmlInputText getCOMP_POL_OCC_RATE() {
	return COMP_POL_OCC_RATE;
    }

    public void setCOMP_POL_OCC_RATE(HtmlInputText comp_pol_occ_rate) {
	COMP_POL_OCC_RATE = comp_pol_occ_rate;
    }

    public HtmlOutputLabel getCOMP_POL_PROD_GROUP_CODE_LABEL() {
	return COMP_POL_PROD_GROUP_CODE_LABEL;
    }

    public void setCOMP_POL_PROD_GROUP_CODE_LABEL(
	    HtmlOutputLabel comp_pol_prod_group_code_label) {
	COMP_POL_PROD_GROUP_CODE_LABEL = comp_pol_prod_group_code_label;
    }

    public HtmlInputText getCOMP_POL_PROD_GROUP_CODE() {
	return COMP_POL_PROD_GROUP_CODE;
    }

    public void setCOMP_POL_PROD_GROUP_CODE(
	    HtmlInputText comp_pol_prod_group_code) {
	COMP_POL_PROD_GROUP_CODE = comp_pol_prod_group_code;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_PROD_GROUP_CODE_LABEL() {
	return COMP_UI_M_POL_PROD_GROUP_CODE_LABEL;
    }

    public void setCOMP_UI_M_POL_PROD_GROUP_CODE_LABEL(
	    HtmlOutputLabel comp_ui_m_pol_prod_group_code_label) {
	COMP_UI_M_POL_PROD_GROUP_CODE_LABEL = comp_ui_m_pol_prod_group_code_label;
    }

    public HtmlInputText getCOMP_UI_M_POL_PROD_GROUP_CODE() {
	return COMP_UI_M_POL_PROD_GROUP_CODE;
    }

    public void setCOMP_UI_M_POL_PROD_GROUP_CODE(
	    HtmlInputText comp_ui_m_pol_prod_group_code) {
	COMP_UI_M_POL_PROD_GROUP_CODE = comp_ui_m_pol_prod_group_code;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_LOV_GRP_CODE() {
	return COMP_UI_M_BUT_LOV_GRP_CODE;
    }

    public void setCOMP_UI_M_BUT_LOV_GRP_CODE(
	    HtmlCommandButton comp_ui_m_but_lov_grp_code) {
	COMP_UI_M_BUT_LOV_GRP_CODE = comp_ui_m_but_lov_grp_code;
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

    public HtmlCommandButton getCOMP_UI_M_BUT_CC_LOV() {
	return COMP_UI_M_BUT_CC_LOV;
    }

    public void setCOMP_UI_M_BUT_CC_LOV(HtmlCommandButton comp_ui_m_but_cc_lov) {
	COMP_UI_M_BUT_CC_LOV = comp_ui_m_but_cc_lov;
    }

    
    public HtmlOutputLabel getCOMP_FORM_CAPTION() {
        return COMP_FORM_CAPTION;
    }

    public void setCOMP_FORM_CAPTION(HtmlOutputLabel comp_form_caption) {
        COMP_FORM_CAPTION = comp_form_caption;
    }
    
    public ArrayList<LovBean> lovPOL_CUST_CODE(Object object) {

    	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
    	ListItemUtil listitemutil = new ListItemUtil();
    	String M_FACIN_YN = null;
    	Connection connection = null;
    	ResultSet rs= null;
    	Object[] values = null;
		String currentValue = (String) object;
		String query = " SELECT NVL(CLASS_FACIN_YN, 'N')   	FROM   PM_IL_CLASS"
    		+ "  WHERE  CLASS_CODE = ? ";
		
    	String subQry="SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";
      
    	String mainQry="SELECT CUST_CODE,CUST_NAME,CUST_BL_NAME " +
        		" FROM PM_CUSTOMER WHERE CUST_CLASS IN " +
        		" (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM " +
        		" WHERE DECODE(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN " +
        		" (?)) AND CUST_FRZ_FLAG = 'N' AND (CUST_APPL_ALL_BRAN_YN = 'Y'" +
        		" OR CUST_CODE IN " +
        		" (SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN " +
        		" WHERE CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE))) AND " +
        		"(CUST_CODE LIKE ? OR CUST_NAME LIKE ? OR  CUST_BL_NAME LIKE ?)AND  ROWNUM < 25 order by 1";
      
				System.out.println(mainQry);
		    try{
		    currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
    	    connection = CommonUtils.getConnection();
    	    rs = new CRUDHandler().executeSelectStatement(query, connection,
    		    new Object[] { PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });

    	    while (rs.next()) {
    		M_FACIN_YN = rs.getString(1);
    	    }
    	    if ("1".equals(compositeAction.getDUMMY_ACTION_BEAN()
    		    .getDUMMY_BEAN().getUI_M_CALC_METHOD())
    		    && "C".equals(CommonUtils
    			    .getGlobalVariable("GLOBAL.M_PARA_7"))) {
    	    	  mainQry=prepareCustomerQuery(mainQry,new Object[]{"BANK"});
    	    	  values =new Object[]{PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(),currentValue,currentValue,currentValue};
    	    	  suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);
    		
    	    } else {
    		if ("N".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN
    			.getPOL_CASH_YN(), "N"))) {
    		    if ("N".equals(CommonUtils.nvl(M_FACIN_YN, "N"))) {

    		    	mainQry=prepareCustomerQuery(mainQry,new Object[]{"CUSTOMER"});
    		    	values =new Object[]{PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(),currentValue,currentValue,currentValue};
      	    	  suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);

    		
    		    } else {
    		    	mainQry=prepareCustomerQuery(mainQry,new Object[]{"REINS"});
    		    	values =new Object[]{PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(),currentValue,currentValue,currentValue};
      	    	  suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);
			}
    		} else {
    			mainQry=prepareCustomerQuery(mainQry,new Object[]{"CASH"});
    			values =new Object[]{PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(),currentValue,currentValue,currentValue};
    	    	  suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);

    		}
    	    }

    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    	finally{
    		try {
			 CommonUtils.closeCursor(rs);
		} catch (Exception e) {
				// TODO: handle exception
		}
    	}
    	return suggestionList;
        }
    public String prepareCustomerQuery(String CustCodeQuery,Object[] values) {
		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();
		String query_input="";
		String subQry="SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement(subQry, connection,values);
			if(resultSet.next()) {
				query_input = resultSet.getString("PS_CODE_DESC"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		CustCodeQuery=CustCodeQuery.replaceFirst("\\?",query_input);
		return CustCodeQuery;
	}

	public HtmlAjaxRegion getCOMP_REGION_ONE() {
		return COMP_REGION_ONE;
	}

	public void setCOMP_REGION_ONE(HtmlAjaxRegion comp_region_one) {
		COMP_REGION_ONE = comp_region_one;
	}

	public HtmlAjaxRegion getCOMP_REGION_TWO() {
		return COMP_REGION_TWO;
	}

	public void setCOMP_REGION_TWO(HtmlAjaxRegion comp_region_two) {
		COMP_REGION_TWO = comp_region_two;
	}

	public HtmlAjaxRegion getCOMP_REGION_THREE() {
		return COMP_REGION_THREE;
	}

	public void setCOMP_REGION_THREE(HtmlAjaxRegion comp_region_three) {
		COMP_REGION_THREE = comp_region_three;
	}

	public HtmlAjaxRegion getCOMP_REGION_FOUR() {
		return COMP_REGION_FOUR;
	}

	public void setCOMP_REGION_FOUR(HtmlAjaxRegion comp_region_four) {
		COMP_REGION_FOUR = comp_region_four;
	}
	

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PAYOR_SDCODE(Object object) {

		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		
	    	Object[] values = null;
		String currentValue = (String) object;
		String subQry="SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";
		String mainQry="SELECT CUST_CODE,CUST_NAME,CUST_BL_NAME " +
	        		" FROM PM_CUSTOMER WHERE CUST_CLASS IN " +
	        		" (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM " +
	        		" WHERE DECODE(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN " +
	        		" (?)) AND CUST_FRZ_FLAG = 'N' AND (CUST_APPL_ALL_BRAN_YN = 'Y'" +
	        		" OR CUST_CODE IN " +
	        		" (SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN " +
	        		" WHERE CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE))) and ROWNUM < 25 order by 1";
	        try{
			   currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			   mainQry=prepareCustomerQuery(mainQry,new Object[]{"CUSTOMER"});
	      	    	  values =new Object[]{PT_IL_POLICY_BEAN.getPOL_DIVN_CODE()};
	      	    	  suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);

	    		
	    		  
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return suggestionList;
	   }

	public HtmlCommandButton getCOMP_UI_M_BUT_ENDT_OK() {
	    return COMP_UI_M_BUT_ENDT_OK;
	}

	public void setCOMP_UI_M_BUT_ENDT_OK(HtmlCommandButton comp_ui_m_but_endt_ok) {
	    COMP_UI_M_BUT_ENDT_OK = comp_ui_m_but_endt_ok;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ENDT_CANCEL() {
	    return COMP_UI_M_BUT_ENDT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_ENDT_CANCEL(
		HtmlCommandButton comp_ui_m_but_endt_cancel) {
	    COMP_UI_M_BUT_ENDT_CANCEL = comp_ui_m_but_endt_cancel;
	}


	public String getToggleState() {
		System.out.println("PT_IL_POLICY_ACTION.getToggleState()"+toggleState);
		return toggleState;
	}


	public void setToggleState(String toggleState) {
		System.out.println("PT_IL_POLICY_ACTION.setToggleState()"+toggleState);
		this.toggleState = toggleState;
	}


	public HtmlTab getCOMP_ADDRESS() {
		return COMP_ADDRESS;
	}


	public void setCOMP_ADDRESS(HtmlTab comp_address) {
		COMP_ADDRESS = comp_address;
	}


	public HtmlInputText getCOMP_UI_M_POL_CONT_DESC() {
		return COMP_UI_M_POL_CONT_DESC;
	}


	public void setCOMP_UI_M_POL_CONT_DESC(HtmlInputText comp_ui_m_pol_cont_desc) {
		COMP_UI_M_POL_CONT_DESC = comp_ui_m_pol_cont_desc;
	}

	private void validateOtherRichTabComponents() throws ValidatorException {

		/*if(COMP_POL_RES_ADDRESS_1.getValue() !=null && !"".equals(COMP_POL_RES_ADDRESS_1.getValue()) ){
			
		}else*/ if(COMP_POL_RES_ADDRESS_1.getValue() ==null && "".equals(COMP_POL_RES_ADDRESS_1.getValue()) ){
	 
			throw new ValidatorException(new FacesMessage("Residential Address " + Messages.getString(PELConstants.pelMessagePropertiesPath,"javax.faces.component.UIInput.REQUIRED")));
		}
		/*if(COMP_POL_TARIFF_TERM_FLAG.getValue() !=null && !"".equals(COMP_POL_TARIFF_TERM_FLAG.getValue()) ){
			
		}else*/ if(COMP_POL_TARIFF_TERM_FLAG.getValue() ==null && "".equals(COMP_POL_TARIFF_TERM_FLAG.getValue()) ){
	 
			throw new ValidatorException(new FacesMessage("Tariff Term Flag " + Messages.getString(PELConstants.pelMessagePropertiesPath,"javax.faces.component.UIInput.REQUIRED")));
		}
	} 



	/**
	 * Disables all components in PT_IL_POLICY_ACTION
	 */
	public void disableAllComponent(boolean disabled){
	    
	    if(disabled){
		COMP_TAB_PANEL.setSwitchType("client");
	    }
	    else{
		COMP_TAB_PANEL.setSwitchType("ajax");
	    }
	    
		// Disabling HtmlInputText
		COMP_UI_M_POL_CONT_DESC.setDisabled(disabled);
		COMP_POL_CURR_SA_LIMIT.setDisabled(disabled);
		COMP_POL_CURR_SA.setDisabled(disabled);
		COMP_PROP_LC_DEP_PREM.setDisabled(disabled);
		COMP_PROP_FC_DEP_PREM.setDisabled(disabled);
		COMP_POL_DEF_PERIOD_FM.setDisabled(disabled);
		COMP_POL_DEF_PERIOD_TO.setDisabled(disabled);
		COMP_POL_WAQAF_PERIOD_FM.setDisabled(disabled);
		COMP_POL_WAQAF_PERIOD_TO.setDisabled(disabled);
		COMP_POL_END_CODE.setDisabled(disabled);
		COMP_UI_M_POL_END_CODE_DESC.setDisabled(disabled);
		COMP_POL_END_NO.setDisabled(disabled);
		COMP_POL_END_DESC.setDisabled(disabled);
		COMP_UI_M_PAY_PERIOD.setDisabled(disabled);
		COMP_UI_M_PAY_YEARS.setDisabled(disabled);
		COMP_UI_M_LC_SA.setDisabled(disabled);
		COMP_UI_M_FC_SA.setDisabled(disabled);
		COMP_POL_PROD_CODE.setDisabled(disabled);
		COMP_UI_M_PROD_DESC.setDisabled(disabled);
		COMP_POL_PROD_GROUP_CODE.setDisabled(disabled);
		COMP_UI_M_POL_PROD_GROUP_CODE.setDisabled(disabled);
		COMP_POL_PLAN_CODE.setDisabled(disabled);
		COMP_UI_M_POL_PLAN_DESC.setDisabled(disabled);
		COMP_POL_UW_YEAR.setDisabled(disabled);
		COMP_POL_NO_YRS_PREM_PAID.setDisabled(disabled);
		COMP_POL_JOINT_LIFE_AGE.setDisabled(disabled);
		COMP_POL_NO.setDisabled(disabled);
		COMP_POL_ASSRD_REF_ID1.setDisabled(disabled);
		COMP_POL_ASSRD_REF_ID2.setDisabled(disabled);
		COMP_UI_M_MAT_AGE.setDisabled(disabled);
		COMP_UI_M_POL_LC_SA1.setDisabled(disabled);
		COMP_POL_BASIC_RATE1.setDisabled(disabled);
		COMP_POL_LC_BASIC_PREM1.setDisabled(disabled);
		COMP_POL_LC_ADDL_PREM1.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_PREM1.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_LOADING1.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_DISCOUNT1.setDisabled(disabled);
		COMP_UI_M_LC_PCHARGES_BORNE_CUST1.setDisabled(disabled);
		COMP_UI_M_POL_LC_NET_PREM1.setDisabled(disabled);
		COMP_UI_M_POL_MODE_OF_PYMT_RATE1.setDisabled(disabled);
		COMP_UI_M_POL_LC_MOP1.setDisabled(disabled);
		COMP_UI_M_POL_LC_GR_ANN_PREM1.setDisabled(disabled);
		COMP_UI_M_POL_INST_LC_PREM1.setDisabled(disabled);
		COMP_POL_LC_DISC_AMT1.setDisabled(disabled);
		COMP_UI_M_LC_SCHARGES_BORNE_CUST1.setDisabled(disabled);
		COMP_POL_LC_FIRST_PREM1.setDisabled(disabled);
		COMP_POL_RES_ADDRESS_1.setDisabled(disabled);
		COMP_POL_RES_ADDRESS_2.setDisabled(disabled);
		COMP_POL_RES_ADDRESS_3.setDisabled(disabled);
		COMP_POL_RES_AREA_CODE.setDisabled(disabled);
		COMP_UI_M_POL_RES_AREA_CODE_DESC.setDisabled(disabled);
		COMP_POL_CITY_CODE.setDisabled(disabled);
		COMP_UI_M_POL_CITY_NAME.setDisabled(disabled);
		COMP_POL_STATE_CODE.setDisabled(disabled);
		COMP_UI_M_POL_STATE_NAME.setDisabled(disabled);
		COMP_POL_COUNT_CODE.setDisabled(disabled);
		COMP_UI_M_POL_COUNT_NAME.setDisabled(disabled);
		COMP_POL_RES_PHONE_NO.setDisabled(disabled);
		COMP_POL_MOBILE_NO.setDisabled(disabled);
		COMP_POL_OFF_ADDRESS_1.setDisabled(disabled);
		COMP_POL_OFF_ADDRESS_2.setDisabled(disabled);
		COMP_POL_OFF_ADDRESS_3.setDisabled(disabled);
		COMP_POL_OFF_AREA_CODE.setDisabled(disabled);
		COMP_UI_M_POSTAL_NAME.setDisabled(disabled);
		COMP_POL_OFF_PHONE_NO.setDisabled(disabled);
		COMP_POL_FAX_NO.setDisabled(disabled);
		COMP_POL_FAX_AREA_CODE.setDisabled(disabled);
		COMP_UI_M_POL_ADDL_STATUS_DESC.setDisabled(disabled);
		COMP_PAYOR_TAB.setDisabled(disabled);
		COMP_POL_MASTER_POL_NO.setDisabled(disabled);
		COMP_POL_PROFIT_RATE.setDisabled(disabled);
		COMP_POL_CREDIT_INT_RATE.setDisabled(disabled);
		COMP_POL_PROP_NO.setDisabled(disabled);
		COMP_UI_M_POL_FC_SA.setDisabled(disabled);
		COMP_UI_M_POL_LC_SA.setDisabled(disabled);
		COMP_POL_OCC_RATE.setDisabled(disabled);
		COMP_POL_HEALTH_RATE.setDisabled(disabled);
		COMP_POL_PROJECT_CODE.setDisabled(disabled);
		COMP_UI_M_PROJECT_CODE_DESC.setDisabled(disabled);
		COMP_POL_DEVELOPER_CODE.setDisabled(disabled);
		COMP_UI_M_DEVELOPER_CODE_DESC.setDisabled(disabled);
		COMP_POL_PAYOR_SDCODE.setDisabled(disabled);
		COMP_UI_M_PAYOR_CONT_NAME.setDisabled(disabled);
		COMP_POL_CUST_CODE.setDisabled(disabled);
		COMP_UI_M_POL_CUST_DESC.setDisabled(disabled);
		COMP_POL_BASIC_RATE.setDisabled(disabled);
		COMP_POL_FC_BASIC_PREM.setDisabled(disabled);
		COMP_POL_LC_BASIC_PREM.setDisabled(disabled);
		COMP_POL_FC_HEALTH_LOAD.setDisabled(disabled);
		COMP_POL_LC_HEALTH_LOAD.setDisabled(disabled);
		COMP_POL_FLEX_01.setDisabled(disabled);
		COMP_UI_M_CONT_NAME.setDisabled(disabled);
		COMP_POL_DEFER_PRD.setDisabled(disabled);
		COMP_POL_EMPLOYER_CODE.setDisabled(disabled);
		COMP_POL_SRC_OF_BUS.setDisabled(disabled);
		COMP_UI_M_POL_SRC_OF_BUS_DESC.setDisabled(disabled);
		COMP_POL_FC_ADDL_PREM.setDisabled(disabled);
		COMP_POL_LC_ADDL_PREM.setDisabled(disabled);
		COMP_POL_FC_TOT_SA.setDisabled(disabled);
		COMP_POL_LC_TOT_SA.setDisabled(disabled);
		COMP_UI_M_FC_DEATH_LOAD.setDisabled(disabled);
		COMP_UI_M_LC_DEATH_LOAD.setDisabled(disabled);
		COMP_POL_FLEX_02.setDisabled(disabled);
		COMP_POL_SUB_PLAN_CODE.setDisabled(disabled);
		COMP_POL_CONT_CODE.setDisabled(disabled);
		COMP_POL_ASSURED_NAME.setDisabled(disabled);
		COMP_UI_M_POL_FC_TOT_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_PREM.setDisabled(disabled);
		COMP_UI_M_POL_FC_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_PREM.setDisabled(disabled);
		COMP_UI_M_FC_TPD_LOAD.setDisabled(disabled);
		COMP_UI_M_LC_TPD_LOAD.setDisabled(disabled);
		COMP_POL_FLEX_03.setDisabled(disabled);
		COMP_POL_GRANTEE_NAME.setDisabled(disabled);
		COMP_UI_M_POL_SUB_PLAN_CODE_DESC.setDisabled(disabled);
		COMP_POL_PERIOD.setDisabled(disabled);
		COMP_POL_PREM_PAY_YRS.setDisabled(disabled);
		COMP_POL_FC_NETT_PREM.setDisabled(disabled);
		COMP_POL_LC_NETT_PREM.setDisabled(disabled);
		COMP_UI_M_POL_FC_TOT_LOADING.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_LOADING.setDisabled(disabled);
		COMP_UI_M_FC_MED_LOAD.setDisabled(disabled);
		COMP_UI_M_LC_MED_LOAD.setDisabled(disabled);
		COMP_POL_LC_TOP_UP_AMT.setDisabled(disabled);
		COMP_POL_INTRODUCER_REF_ID1.setDisabled(disabled);
		COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC.setDisabled(disabled);
		COMP_POL_BANK_BRANCH_NAME.setDisabled(disabled);
		COMP_UI_M_BRANCH_CODE_DESC.setDisabled(disabled);
		COMP_POL_DIVN_CODE.setDisabled(disabled);
		COMP_UI_M_POL_FC_TOT_DISCOUNT.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_DISCOUNT.setDisabled(disabled);
		COMP_POL_FC_CURR_SA.setDisabled(disabled);
		COMP_POL_LC_CURR_SA.setDisabled(disabled);
		COMP_POL_FC_TOP_UP_AMT.setDisabled(disabled);
		COMP_UI_M_FC_OCC_LOAD.setDisabled(disabled);
		COMP_UI_M_LC_OCC_LOAD.setDisabled(disabled);
		COMP_POL_BANK_REF_NO.setDisabled(disabled);
		COMP_POL_SA_CURR_CODE.setDisabled(disabled);
		COMP_UI_M_POL_SA_CURR_DESC.setDisabled(disabled);
		COMP_POL_SA_EXCH_RATE.setDisabled(disabled);
		COMP_UI_M_POL_DIVN_DESC.setDisabled(disabled);
		COMP_UI_M_FC_PCHARGES_BORNE_CUST.setDisabled(disabled);
		COMP_UI_M_LC_PCHARGES_BORNE_CUST.setDisabled(disabled);
		COMP_UI_M_FC_GROSS_CONT.setDisabled(disabled);
		COMP_UI_M_LC_GROSS_CONT.setDisabled(disabled);
		COMP_POL_LC_EXC_INT_AMT.setDisabled(disabled);
		COMP_POL_CUST_CURR_CODE.setDisabled(disabled);
		COMP_UI_M_POL_CUST_CURR_DESC.setDisabled(disabled);
		COMP_POL_CUST_EXCH_RATE.setDisabled(disabled);
		COMP_POL_DEPT_CODE.setDisabled(disabled);
		COMP_UI_M_POL_FC_NET_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_NET_PREM.setDisabled(disabled);
		COMP_UI_M_FC_BROK_COMM.setDisabled(disabled);
		COMP_UI_M_LC_BROK_COMM.setDisabled(disabled);
		COMP_POL_EXC_INT_PERC.setDisabled(disabled);
		COMP_POL_STAFF_CCLASS_CODE.setDisabled(disabled);
		COMP_UI_M_CCLAS_CLASS_DESC.setDisabled(disabled);
		COMP_POL_FC_EXC_INT_AMT.setDisabled(disabled);
		COMP_POL_FC_MODAL_PREM.setDisabled(disabled);
		COMP_POL_NO_OF_UNIT.setDisabled(disabled);
		COMP_POL_LC_MODAL_PREM.setDisabled(disabled);
		COMP_UI_M_POL_DEPT_DESC.setDisabled(disabled);
		COMP_UI_M_POL_MODE_OF_PYMT_RATE.setDisabled(disabled);
		COMP_UI_M_POL_FC_MOP.setDisabled(disabled);
		COMP_UI_M_POL_LC_MOP.setDisabled(disabled);
		COMP_UI_M_FC_CHARGE.setDisabled(disabled);
		COMP_UI_M_LC_CHARGE.setDisabled(disabled);
		COMP_POL_RI_POOL_CODE.setDisabled(disabled);
		COMP_UI_M_POL_RI_POOL_CODE_DESC.setDisabled(disabled);
		COMP_POL_LOAD_PERC.setDisabled(disabled);
		COMP_POL_NO_OF_INST.setDisabled(disabled);
		COMP_POL_MODE_OF_PYMT_RATE.setDisabled(disabled);
		COMP_POL_CLASS_CODE.setDisabled(disabled);
		COMP_UI_M_POL_FC_GR_ANN_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_GR_ANN_PREM.setDisabled(disabled);
		COMP_UI_M_FC_PCHARGES_BORNE_COMP.setDisabled(disabled);
		COMP_UI_M_LC_PCHARGES_BORNE_COMP.setDisabled(disabled);
		COMP_POL_FC_NET_PREM.setDisabled(disabled);
		COMP_POL_LC_NET_PREM.setDisabled(disabled);
		COMP_UI_M_FC_INST_PREM.setDisabled(disabled);
		COMP_UI_M_LC_INST_PREM.setDisabled(disabled);
		COMP_POL_CQS_PERC.setDisabled(disabled);
		COMP_POL_CREDIT_DISCOUNT_PERC.setDisabled(disabled);
		COMP_POL_FORM_NO.setDisabled(disabled);
		COMP_POL_FC_SUM_ASSURED.setDisabled(disabled);
		COMP_POL_LC_SUM_ASSURED.setDisabled(disabled);
		COMP_UI_M_POL_CLASS_DESC.setDisabled(disabled);
		COMP_UI_M_POL_INST_FC_PREM.setDisabled(disabled);
		COMP_UI_M_POL_INST_LC_PREM.setDisabled(disabled);
		COMP_POL_FC_BANK_ALLOC_AMT.setDisabled(disabled);
		COMP_POL_LC_BANK_ALLOC_AMT.setDisabled(disabled);
		COMP_UI_M_POL_CONT_AD_ACC_NO.setDisabled(disabled);
		COMP_POL_PROP_REF_NO.setDisabled(disabled);
		COMP_POL_AGENT_REF_CODE.setDisabled(disabled);
		COMP_POL_FC_DEPOSIT_AMOUNT.setDisabled(disabled);
		COMP_POL_LC_DEPOSIT_AMOUNT.setDisabled(disabled);
		COMP_POL_FC_DISC_AMT.setDisabled(disabled);
		COMP_POL_LC_DISC_AMT.setDisabled(disabled);
		COMP_POL_FC_CLIENT_ALLOC_AMT.setDisabled(disabled);
		COMP_POL_LC_CLIENT_ALLOC_AMT.setDisabled(disabled);
		COMP_POL_CONT_AD_BANK_CODE.setDisabled(disabled);
		COMP_UI_M_BANK_CODE_DESC.setDisabled(disabled);
		COMP_POL_REMARKS.setDisabled(disabled);
		COMP_UI_M_FC_SCHARGES_BORNE_CUST.setDisabled(disabled);
		COMP_UI_M_LC_SCHARGES_BORNE_CUST.setDisabled(disabled);
		COMP_UI_M_FC_SCHARGES_BORNE_COMP.setDisabled(disabled);
		COMP_UI_M_LC_SCHARGES_BORNE_COMP.setDisabled(disabled);
		COMP_POL_CARD_HOLDER_NAME.setDisabled(disabled);
		COMP_POL_FC_MON_ANNU_AMT.setDisabled(disabled);
		COMP_POL_LC_MON_ANNU_AMT.setDisabled(disabled);
		COMP_POL_FC_FIRST_PREM.setDisabled(disabled);
		COMP_POL_LC_FIRST_PREM.setDisabled(disabled);
		COMP_POL_FC_PRE_TPD_BNF.setDisabled(disabled);
		COMP_POL_LC_PRE_TPD_BNF.setDisabled(disabled);
		COMP_POL_AUTH_LIMIT.setDisabled(disabled);
		 
		if ("U".equals(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_POL_PLAN_TYPE())) {
		    COMP_POL_LC_MIN_PREM.setDisabled(true);
		    COMP_POL_FC_MIN_PREM.setDisabled(true);
		    COMP_POL_LC_EXTRA_PREM.setDisabled(true);
		    COMP_POL_FC_EXTRA_PREM.setDisabled(true);
		}
		else{
		    COMP_POL_LC_MIN_PREM.setDisabled(disabled);
		    COMP_POL_FC_MIN_PREM.setDisabled(disabled);
		    COMP_POL_LC_EXTRA_PREM.setDisabled(disabled);
		    COMP_POL_FC_EXTRA_PREM.setDisabled(disabled);
		}
		
		// Disabling HtmlSelectOneMenu
		COMP_POL_MED_FEE_RECOVER_YN.setDisabled(disabled);
		COMP_POL_JOINT_LIFE_YN.setDisabled(disabled);
		COMP_POL_FRZ_FLAG.setDisabled(disabled);
		COMP_POL_CASH_YN.setDisabled(disabled);
		COMP_POL_MODE_OF_CALC.setDisabled(disabled);
		COMP_POL_PYMT_TYPE.setDisabled(disabled);
		COMP_POL_HOME_OWNER_FLAG.setDisabled(disabled);
		COMP_POL_INCORPORATED_YN.setDisabled(disabled);
		COMP_POL_NET_PREM_YN.setDisabled(disabled);
		COMP_POL_GRANTEE_TYPE.setDisabled(disabled);
		COMP_POL_RATE_APPLIED_ON.setDisabled(disabled);
		COMP_POL_ORG_PROP_RECV_YN.setDisabled(disabled);
		COMP_POL_TARIFF_TERM_FLAG.setDisabled(disabled);
		COMP_POL_STD_RISK_YN.setDisabled(disabled);
		COMP_POL_CREDIT_YN.setDisabled(disabled);
		COMP_POL_STAFF_YN.setDisabled(disabled);
		COMP_POL_FAC_BASIS.setDisabled(disabled);
		COMP_POL_MODE_OF_PYMT.setDisabled(disabled);
		COMP_POL_FAC_YN.setDisabled(disabled);
		COMP_POL_CQS_YN.setDisabled(disabled);
		COMP_POL_DEF_IMM_FLAG.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_POL_END_DT.setDisabled(disabled);
		COMP_POL_END_EFF_FROM_DT.setDisabled(disabled);
		COMP_POL_END_EFF_TO_DT.setDisabled(disabled);
		COMP_POL_ISSUE_DT.setDisabled(disabled);
		COMP_POL_TRAN_DT.setDisabled(disabled);
		COMP_POL_PROP_RECV_DT.setDisabled(disabled);
		COMP_POL_PROP_STAMP_DT.setDisabled(disabled);
		COMP_POL_PROP_DECL_DT.setDisabled(disabled);
		COMP_POL_START_DT.setDisabled(disabled);
		COMP_POL_EXPIRY_DT.setDisabled(disabled);
		COMP_POL_NL_FM_DT.setDisabled(disabled);
		COMP_POL_FIRST_INST_DT.setDisabled(disabled);
		COMP_POL_LAST_INST_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		/*
		COMP_UI_M_BUS_RUL.setDisabled(disabled);
		COMP_UI_M_BUT_CC_LOV.setDisabled(disabled);
		COMP_UI_M_BUT_LOV_GRP_CODE.setDisabled(disabled);
		COMP_UI_M_BUT_COPY.setDisabled(disabled);
		COMP_UI_M_BUT_FUND_QUERY.setDisabled(disabled);
		COMP_UI_M_BUT_HOLD.setDisabled(disabled);
		COMP_UI_M_BUT_UDDATE_STAT.setDisabled(disabled);
		COMP_UI_M_BUT_UPI.setDisabled(disabled);
		COMP_UI_M_BUT_CALC_DISC_LOAD.setDisabled(disabled);
		COMP_UI_M_BUT_SURR_MAT.setDisabled(disabled);
		COMP_UI_M_BUT_ENDT.setDisabled(disabled);
		COMP_UI_M_BUT_ENDT_OK.setDisabled(disabled);
		COMP_UI_M_BUT_ENDT_CANCEL.setDisabled(disabled);
		COMP_UI_M_BUT_APPROVAL.setDisabled(disabled);
		COMP_UI_M_BUT_PRMDTLS.setDisabled(disabled);
		COMP_UI_M_BUT_LOV_PLAN.setDisabled(disabled);
		COMP_UI_M_BUT_DOC_GEN_NO.setDisabled(disabled);
		COMP_UI_M_BUT_LOV_PROD_CODE.setDisabled(disabled);
		COMP_UI_M_BUT_CONVERT.setDisabled(disabled);
		COMP_UI_M_BUT_POL_AMDT.setDisabled(disabled);
		COMP_UI_M_BUT_UPLOAD.setDisabled(disabled);
		COMP_UI_M_BUT_CLAIM.setDisabled(disabled);
		COMP_UI_M_BUT_FUND_DTL.setDisabled(disabled);*/

	}



	public HtmlTabPanel getCOMP_TAB_PANEL() {
	    return COMP_TAB_PANEL;
	}



	public void setCOMP_TAB_PANEL(HtmlTabPanel comp_tab_panel) {
	    COMP_TAB_PANEL = comp_tab_panel;
	}



	public HtmlInputText getCOMP_POL_NEW_LC_SA() {
	    return COMP_POL_NEW_LC_SA;
	}



	public void setCOMP_POL_NEW_LC_SA(HtmlInputText comp_pol_new_lc_sa) {
	    COMP_POL_NEW_LC_SA = comp_pol_new_lc_sa;
	}



	public HtmlInputText getCOMP_POL_NEW_FC_SA() {
	    return COMP_POL_NEW_FC_SA;
	}



	public void setCOMP_POL_NEW_FC_SA(HtmlInputText comp_pol_new_fc_sa) {
	    COMP_POL_NEW_FC_SA = comp_pol_new_fc_sa;
	}



	public HtmlInputText getCOMP_POL_ORG_NEW_LC_SA() {
	    return COMP_POL_ORG_NEW_LC_SA;
	}



	public void setCOMP_POL_ORG_NEW_LC_SA(HtmlInputText comp_pol_org_new_lc_sa) {
	    COMP_POL_ORG_NEW_LC_SA = comp_pol_org_new_lc_sa;
	}



	public HtmlInputText getCOMP_POL_ORG_NEW_FC_SA() {
	    return COMP_POL_ORG_NEW_FC_SA;
	}



	public void setCOMP_POL_ORG_NEW_FC_SA(HtmlInputText comp_pol_org_new_fc_sa) {
	    COMP_POL_ORG_NEW_FC_SA = comp_pol_org_new_fc_sa;
	}


	
}
