package com.iii.pel.forms.PILT002_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.component.html.HtmlSelectManyListbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletResponse;

import org.ajax4jsf.component.html.HtmlAjaxRegion;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;
import org.richfaces.component.html.HtmlTab;
import org.richfaces.component.html.HtmlTabPanel;
import org.syntax.jedit.InputHandler.next_char;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.common.dms.DMSUtil;
import com.iii.pel.fileupload.FileUploadAction;
import com.iii.pel.forms.PILM003_APAC.PM_IL_PLAN;
import com.iii.pel.forms.PILM016_APAC.P_VAL_CODES;
import com.iii.pel.forms.PILM016_APAC_QE.PM_IL_CONTRACTOR_DELEGATE_QE;
import com.iii.pel.forms.PILM016_APAC_QE.PM_IL_CONTRACTOR_HELPER_QE;
import com.iii.pel.forms.PILM016_APAC_QE.PM_IL_CONTRACTOR_QE;
import com.iii.pel.forms.PILP016.PILP016_COMPOSITE_ACTION;
import com.iii.pel.forms.PILP201.IP_REP_INFO;
import com.iii.pel.forms.PM006_QE.PM006_QE_CUSTOMER;
import com.iii.pel.forms.PM006_QE.PM006_QE_CUSTOMER_DELEGATE;
import com.iii.pel.forms.PM006_QE.PM006_QE_CUSTOMER_HELPER;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_ENDORSE;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.pel.utils.P9ILPK_PROCESS;
import com.iii.pel.utils.PILPK_POLICY_APPROVAL;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;

public class PT_IL_POLICY_ACTION extends CommonReportAction {

	/* Added by Ram on 13/03/2017 for Common Report by Customerwise */
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("Application");
	/* End */

	private HtmlGraphicImage COMP_POL_CREDIT_INT_RATE_MANDATORY;

	private HtmlCommandButton COMP_UI_M_BUT_DOCUMENTS;

	private HtmlTab COMP_MORE_INFO_1;

	private HtmlTab COMP_MORE_INFO_2;

	private HtmlTab COMP_MORE_INFO_3;
	private HtmlTab COMP_MORE_INFO_4;

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

	private HtmlOutputLabel COMP_POL_FLEX_18_LABEL;

	private HtmlInputText COMP_POL_FLEX_18;

	private HtmlOutputLabel COMP_UI_M_FC_SA_LABEL;

	private HtmlInputText COMP_UI_M_FC_SA;

	private HtmlAjaxRegion COMP_REGION_ONE;

	private HtmlAjaxRegion COMP_REGION_TWO;

	private HtmlAjaxRegion COMP_REGION_THREE;

	private HtmlAjaxRegion COMP_REGION_FOUR;

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

	private HtmlOutputLabel COMP_POL_STD_SUBSTD_LABEL;

	private HtmlSelectOneMenu COMP_POL_STD_SUBSTD;

	private HtmlOutputLabel COMP_POL_CREDIT_INT_RATE_LABEL;

	private HtmlInputText COMP_POL_CREDIT_INT_RATE;

	private HtmlOutputLabel COMP_POL_PROP_NO_LABEL;

	private HtmlInputText COMP_POL_PROP_NO;

	/* added by gopi for hands on feed back issue in ZB on 31/01/17 */
	private HtmlOutputLabel COMP_POL_QUOT_NO_LABEL;
	/* added by sivarajan on 12-08-2018 for KICLIFEQC-1761314 */
	private HtmlOutputLabel COMP_POL_ENDORSEMENT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_POL_ENDORSEMENT_TYPE;

	/* End */
	public HtmlOutputLabel getCOMP_POL_QUOT_NO_LABEL() {
		return COMP_POL_QUOT_NO_LABEL;
	}

	public void setCOMP_POL_QUOT_NO_LABEL(HtmlOutputLabel cOMP_POL_QUOT_NO_LABEL) {
		COMP_POL_QUOT_NO_LABEL = cOMP_POL_QUOT_NO_LABEL;
	}

	private HtmlInputText COMP_POL_QUOT_NO;

	public HtmlInputText getCOMP_POL_QUOT_NO() {
		return COMP_POL_QUOT_NO;
	}

	public void setCOMP_POL_QUOT_NO(HtmlInputText cOMP_POL_QUOT_NO) {
		COMP_POL_QUOT_NO = cOMP_POL_QUOT_NO;
	}

	/* end */
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

	private HtmlCommandLink COMP_SAVE_COMMAND_LINK;

	private HtmlCommandButton COMP_SAVE_BUTTON;

	private HtmlCommandLink COMP_SAVE_COMMAND_LINK2;

	private HtmlCommandButton COMP_SAVE_BUTTON2;

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

	public HtmlInputText getCOMP_POL_ORG_COMM_RATE() {
		return COMP_POL_ORG_COMM_RATE;
	}

	public void setCOMP_POL_ORG_COMM_RATE(HtmlInputText cOMP_POL_ORG_COMM_RATE) {
		COMP_POL_ORG_COMM_RATE = cOMP_POL_ORG_COMM_RATE;
	}

	public HtmlInputText getCOMP_POL_ORG_COMM_VALUE() {
		return COMP_POL_ORG_COMM_VALUE;
	}

	public void setCOMP_POL_ORG_COMM_VALUE(HtmlInputText cOMP_POL_ORG_COMM_VALUE) {
		COMP_POL_ORG_COMM_VALUE = cOMP_POL_ORG_COMM_VALUE;
	}

	public HtmlInputText getCOMP_POL_COMM_RATE() {
		return COMP_POL_COMM_RATE;
	}

	public void setCOMP_POL_COMM_RATE(HtmlInputText cOMP_POL_COMM_RATE) {
		COMP_POL_COMM_RATE = cOMP_POL_COMM_RATE;
	}

	public HtmlInputText getCOMP_POL_COMM_VALUE() {
		return COMP_POL_COMM_VALUE;
	}

	public void setCOMP_POL_COMM_VALUE(HtmlInputText cOMP_POL_COMM_VALUE) {
		COMP_POL_COMM_VALUE = cOMP_POL_COMM_VALUE;
	}

	private HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_COMP;

	private HtmlInputText COMP_POL_ORG_COMM_RATE;

	private HtmlInputText COMP_POL_ORG_COMM_VALUE;

	private HtmlInputText COMP_POL_COMM_RATE;

	private HtmlInputText COMP_POL_COMM_VALUE;

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

	private HtmlOutputLabel COMP_POL_APL_LABEL;

	private HtmlSelectOneMenu COM_POL_APL_LIST;
	/*
	 * private HtmlOutputLabel COMP_UI_M_FC_RED_SA_LABEL;
	 * 
	 * private HtmlInputText COMP_UI_M_FC_RED_SA;
	 */

	// private HtmlCommandButton COMP_UI_M_BUS_RUL;
	private HtmlCommandButton COMP_UI_M_BUT_CC_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_GRP_CODE;

	private HtmlCommandLink COMP_UI_M_BUT_COPY;

	private HtmlCommandButton COMP_UI_M_BUT_FUND_QUERY;

	private HtmlCommandButton COMP_UI_M_BUT_HOLD;

	private HtmlCommandButton COMP_BACK_BUTTON;

	private HtmlCommandButton COMP_UI_M_BUT_UDDATE_STAT;

	private HtmlCommandButton COMP_UI_M_BUT_UPI;

	private HtmlCommandButton COMP_UI_M_BUT_CALC_DISC_LOAD;

	private HtmlCommandButton COMP_UI_M_BUT_SURR_MAT;

	// private HtmlCommandButton COMP_UI_M_BUT_ENDT;

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

	private HtmlSelectOneMenu COMP_POL_FLEX_14;
	private HtmlSelectOneMenu COMP_POL_FLEX_09;
	private HtmlSelectOneMenu COMP_POL_ESC_YN;
	private HtmlInputText COMP_POL_FLEX_08;
	private HtmlInputText COMP_POL_ESC_PERCENTAGE;
	private HtmlSelectOneMenu COMP_POL_CVR_ESC_PERC;
	private HtmlOutputLabel COMP_POL_FLEX_14_LABEL;
	private HtmlOutputLabel COMP_POL_FLEX_09_LABEL;
	private HtmlOutputLabel COMP_POL_ESC_YN_LABEL;
	private HtmlOutputLabel COMP_POL_ESC_PERCENTAGE_LABEL;
	private HtmlOutputLabel COMP_POL_FLEX_08_LABEL;
	private HtmlOutputLabel COMP_POL_CVR_ESC_PERC_LABEL;

	// [ADDED BY AKASH TO IMPLEMENT DIRECT DEBIT AND CREDIT

	private HtmlOutputLabel COMP_POL_MICR_CODE_LABEL;

	private HtmlInputText COMP_POL_MICR_CODE;

	private HtmlOutputLabel COMP_POL_CUST_BANK_CODE_LABEL;

	private HtmlInputText COMP_POL_CUST_BANK_CODE;

	private HtmlOutputLabel COMP_UI_M_CITY_CODE_LABEL;

	private HtmlInputText COMP_UI_M_CITY_CODE;
	private HtmlInputText COMP_UI_M_CITY_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_BANK_CODE_LABEL;

	private HtmlInputText COMP_UI_M_BANK_CODE;
	private HtmlInputText COMP_UI_M_BANK_CODE_DESC_1;

	private HtmlOutputLabel COMP_UI_M_BRANCH_CODE_LABEL;

	private HtmlInputText COMP_UI_M_BRANCH_CODE;
	private HtmlInputText COMP_UI_M_BRANCH_CODE_DESC_1;

	/*
	 * added by gopi for RM018T - DEV_IL_ZB Life_022-Automated Premium Loan on
	 * 06/01/17
	 */

	private HtmlSelectOneMenu COMP_PROD_INS_APL_YN;

	private HtmlOutputLabel COMP_PROD_INS_APL_YN_LABEL;

	public HtmlSelectOneMenu getCOMP_PROD_INS_APL_YN() {
		return COMP_PROD_INS_APL_YN;
	}

	public void setCOMP_PROD_INS_APL_YN(HtmlSelectOneMenu cOMP_PROD_INS_APL_YN) {
		COMP_PROD_INS_APL_YN = cOMP_PROD_INS_APL_YN;
	}

	public HtmlOutputLabel getCOMP_PROD_INS_APL_YN_LABEL() {
		return COMP_PROD_INS_APL_YN_LABEL;
	}

	public void setCOMP_PROD_INS_APL_YN_LABEL(HtmlOutputLabel cOMP_PROD_INS_APL_YN_LABEL) {
		COMP_PROD_INS_APL_YN_LABEL = cOMP_PROD_INS_APL_YN_LABEL;
	}

	// END
	// ADDED BY AKASH TO IMPLEMENT DIRECT DEBIT AND CREDIT]

	/* Added By Dhinesh 9.6.2016 */

	private boolean default_Cust_Flag = false;

	public boolean isDefault_Cust_Flag() {
		return default_Cust_Flag;
	}

	public void setDefault_Cust_Flag(boolean default_Cust_Flag) {
		this.default_Cust_Flag = default_Cust_Flag;
	}

	/* End */

	private String toggleState;

	public static StringBuffer sb = new StringBuffer();
	public String wizardCaption = "";

	private PT_IL_POLICY PT_IL_POLICY_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POLICY_HELPER helper;

	private List<SelectItem> listPOL_MED_FEE_RECOVER_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPOL_JOINT_LIFE_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPOL_FRZ_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPOL_CASH_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPOL_MODE_OF_CALC = new ArrayList<SelectItem>();

	private List<SelectItem> listPOL_STD_SUBSTD = new ArrayList<SelectItem>();

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

	private List<SelectItem> listAPL = new ArrayList<SelectItem>();
	private List<SelectItem> listPOL_ESC_YN = new ArrayList<SelectItem>();
	private List<SelectItem> listPOL_FLEX_14 = new ArrayList<SelectItem>();
	private List<SelectItem> listPOL_CVR_ESC_PERC = new ArrayList<SelectItem>();
	private List<SelectItem> listPOL_FLEX_09 = new ArrayList<SelectItem>();

	private List<SelectItem> listPOL_STND_SUB = new ArrayList<SelectItem>();

	/* added by janani on 10.2.2016 */

	private HtmlOutputLabel COMP_POL_PREM_OPTION_LABEL;
	private HtmlInputText COMP_POL_PREM_OPTION_CODE;
	private HtmlSelectOneMenu COMP_POL_PREM_OPTION;

	private ArrayList<String> listPhoneEmail = new ArrayList<String>();

	public ArrayList<String> getListPhoneEmail() {
		return listPhoneEmail;
	}

	public void setListPhoneEmail(ArrayList<String> listPhoneEmail) {
		this.listPhoneEmail = listPhoneEmail;
	}

	// MOP
	public static boolean mopCheck = false;

	public HtmlInputText getCOMP_POL_PREM_OPTION_CODE() {
		return COMP_POL_PREM_OPTION_CODE;
	}

	public void setCOMP_POL_PREM_OPTION_CODE(HtmlInputText cOMP_POL_PREM_OPTION_CODE) {
		COMP_POL_PREM_OPTION_CODE = cOMP_POL_PREM_OPTION_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_PREM_OPTION_LABEL() {
		return COMP_POL_PREM_OPTION_LABEL;
	}

	public void setCOMP_POL_PREM_OPTION_LABEL(HtmlOutputLabel cOMP_POL_PREM_OPTION_LABEL) {
		COMP_POL_PREM_OPTION_LABEL = cOMP_POL_PREM_OPTION_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_PREM_OPTION() {
		return COMP_POL_PREM_OPTION;
	}

	public void setCOMP_POL_PREM_OPTION(HtmlSelectOneMenu cOMP_POL_PREM_OPTION) {
		COMP_POL_PREM_OPTION = cOMP_POL_PREM_OPTION;
	}

	/* end */

	private boolean POL_PROD_GROUP_CODE_REQ;
	private boolean endorseFlag = false;

	private boolean endorseIndxVisibleFlag = false;

	private HtmlGraphicImage COMP_MANDATORY;

	/* added by ram */

	private HtmlInputText COMP_UI_POL_PREM_DESC;

	public HtmlInputText getCOMP_UI_POL_PREM_DESC() {
		return COMP_UI_POL_PREM_DESC;
	}

	public void setCOMP_UI_POL_PREM_DESC(HtmlInputText cOMP_UI_POL_PREM_DESC) {
		COMP_UI_POL_PREM_DESC = cOMP_UI_POL_PREM_DESC;
	}

	public HtmlGraphicImage getCOMP_MANDATORY() {
		return COMP_MANDATORY;
	}

	public void setCOMP_MANDATORY(HtmlGraphicImage comp_mandatory) {
		COMP_MANDATORY = comp_mandatory;
	}

	public boolean isPOL_PROD_GROUP_CODE_REQ() {
		return POL_PROD_GROUP_CODE_REQ;
	}

	public void setPOL_PROD_GROUP_CODE_REQ(boolean pol_prod_group_code_req) {
		POL_PROD_GROUP_CODE_REQ = pol_prod_group_code_req;
	}

	private boolean Premium_Brk_Flag = false;

	public boolean isPremium_Brk_Flag() {
		return Premium_Brk_Flag;
	}

	public void setPremium_Brk_Flag(boolean premium_Brk_Flag) {
		Premium_Brk_Flag = premium_Brk_Flag;
	}

	/*
	 * Added by saranya on 10-12-2016 for RM018T - FSD_IL_ZB Life_016-Queried
	 * Proposals v1.0
	 */
	private List<SelectItem> listPOL_CANCEL_YN = new ArrayList<SelectItem>();

	public List<SelectItem> getListPOL_CANCEL_YN() {
		return listPOL_CANCEL_YN;
	}

	public void setListPOL_CANCEL_YN(List<SelectItem> listPOL_CANCEL_YN) {
		this.listPOL_CANCEL_YN = listPOL_CANCEL_YN;
	}

	/* End */
	/*
	 * Modified by Saranya on 13-03-2017 for RM018T - FSD_IL_ZB
	 * Life_001-Education Endowment Plan COMMENTS
	 */
	private PT_IL_POL_ESC_SA_ACTION PT_IL_POL_ESC_SA_ACTION_BEAN;

	public PT_IL_POLICY_ACTION() {
		PT_IL_POL_ESC_SA_ACTION_BEAN = new PT_IL_POL_ESC_SA_ACTION();
		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
		helper = new PT_IL_POLICY_HELPER();
		instantiateAllComponent();
		setListItemValues();

		/* Added by Ram on 08/12/2016 for Business Rule Reports */
		PT_IL_POL_BR_QUESTION_BEAN = new PT_IL_POL_BR_QUESTION();
		UI_M_SCHEDULE_TYPE = new ArrayList<String>();
		/* End */
	}
	/* end */

	/**
	 * Instantiates all components in PT_IL_POLICY_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		/* Added by saranya on 18-03-2017 */
		COMP_POL_LOAN_TYPE = new HtmlSelectOneMenu();
		/* End */
		/*
		 * Added by saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment
		 * Plan COMMENTS on 26-01-2017
		 */
		/* modified by Ameen on 25-10-2019 for SARWA as sugg. by Sivaram */
		/* COMP_POL_BNF_ESC_PERC=new HtmlSelectOneMenu(); */
		COMP_POL_BNF_ESC_PERC = new HtmlInputText();
		COMP_POL_ANN_PAY_PERIOD = new HtmlSelectOneMenu();
		COMP_POL_ANN_BNF_AMT = new HtmlInputText();
		COMP_POL_UL_PREM_CALC = new HtmlSelectOneMenu();

		/* End */
		// added by saranya
		COMP_UI_M_CITY_CODE = new HtmlInputText();
		COMP_UI_M_CITY_CODE_DESC = new HtmlInputText();
		COMP_UI_M_BRANCH_CODE = new HtmlInputText();
		COMP_UI_M_BANK_CODE = new HtmlInputText();
		COMP_UI_M_BANK_CODE_DESC_1 = new HtmlInputText();
		// End
		/*
		 * Added by saranya on 07-12-2016 for RM018T - FSD_IL_ZB
		 * Life_013_Underwriting changes
		 */
		COMP_POL_FC_AGENT_PREM = new HtmlInputText();
		COMP_POL_LC_AGENT_PREM = new HtmlInputText();
		/* End */
		/*
		 * added by saranya on 10-12-2016 for RM018T - FSD_IL_ZB
		 * Life_016-Queried Proposals v1.0
		 */
		COMP_POL_CANCEL_YN = new HtmlSelectOneMenu();
		/* End */
		COMP_REGION_ONE = new HtmlAjaxRegion();
		COMP_REGION_TWO = new HtmlAjaxRegion();
		COMP_REGION_THREE = new HtmlAjaxRegion();
		COMP_REGION_FOUR = new HtmlAjaxRegion();
		COMP_UI_M_POL_CONT_DESC = new HtmlInputText();
		COMP_POL_CURR_SA_LIMIT = new HtmlInputText();
		COMP_POL_CURR_SA = new HtmlInputText();
		COMP_PROP_LC_DEP_PREM = new HtmlInputText();
		COMP_PROP_FC_DEP_PREM = new HtmlInputText();
		COMP_POL_DEF_PERIOD_FM = new HtmlInputText();
		COMP_POL_DEF_PERIOD_TO = new HtmlInputText();
		COMP_POL_WAQAF_PERIOD_FM = new HtmlInputText();
		COMP_POL_WAQAF_PERIOD_TO = new HtmlInputText();
		COMP_POL_END_CODE = new HtmlInputText();
		COMP_UI_M_POL_END_CODE_DESC = new HtmlInputText();
		COMP_POL_END_NO = new HtmlInputText();
		COMP_POL_END_DESC = new HtmlInputText();
		COMP_UI_M_PAY_PERIOD = new HtmlInputText();
		COMP_UI_M_PAY_YEARS = new HtmlInputText();
		COMP_UI_M_LC_SA = new HtmlInputText();
		COMP_UI_M_FC_SA = new HtmlInputText();
		COMP_POL_PROD_CODE = new HtmlInputText();
		COMP_UI_M_PROD_DESC = new HtmlInputText();
		COMP_POL_PROD_GROUP_CODE = new HtmlInputText();
		COMP_UI_M_POL_PROD_GROUP_CODE = new HtmlInputText();
		COMP_POL_PLAN_CODE = new HtmlInputText();
		COMP_UI_M_POL_PLAN_DESC = new HtmlInputText();
		COMP_POL_UW_YEAR = new HtmlInputText();
		COMP_POL_NO_YRS_PREM_PAID = new HtmlInputText();
		COMP_POL_JOINT_LIFE_AGE = new HtmlInputText();
		COMP_POL_NO = new HtmlInputText();
		COMP_POL_ASSRD_REF_ID1 = new HtmlInputText();
		COMP_POL_ASSRD_REF_ID2 = new HtmlInputText();
		COMP_UI_M_MAT_AGE = new HtmlInputText();
		COMP_UI_M_POL_LC_SA1 = new HtmlInputText();
		COMP_POL_BASIC_RATE1 = new HtmlInputText();
		COMP_POL_LC_BASIC_PREM1 = new HtmlInputText();
		COMP_POL_LC_ADDL_PREM1 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_PREM1 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_LOADING1 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_DISCOUNT1 = new HtmlInputText();
		COMP_UI_M_LC_PCHARGES_BORNE_CUST1 = new HtmlInputText();
		COMP_UI_M_POL_LC_NET_PREM1 = new HtmlInputText();
		COMP_UI_M_POL_MODE_OF_PYMT_RATE1 = new HtmlInputText();
		COMP_UI_M_POL_LC_MOP1 = new HtmlInputText();
		COMP_UI_M_POL_LC_GR_ANN_PREM1 = new HtmlInputText();
		COMP_UI_M_POL_INST_LC_PREM1 = new HtmlInputText();
		COMP_POL_LC_DISC_AMT1 = new HtmlInputText();
		COMP_UI_M_LC_SCHARGES_BORNE_CUST1 = new HtmlInputText();
		COMP_POL_LC_FIRST_PREM1 = new HtmlInputText();
		COMP_POL_RES_ADDRESS_1 = new HtmlInputText();
		COMP_POL_RES_ADDRESS_2 = new HtmlInputText();
		COMP_POL_RES_ADDRESS_3 = new HtmlInputText();
		COMP_POL_RES_AREA_CODE = new HtmlInputText();
		COMP_UI_M_POL_RES_AREA_CODE_DESC = new HtmlInputText();
		COMP_POL_CITY_CODE = new HtmlInputText();
		COMP_UI_M_POL_CITY_NAME = new HtmlInputText();
		COMP_POL_STATE_CODE = new HtmlInputText();
		COMP_UI_M_POL_STATE_NAME = new HtmlInputText();
		COMP_POL_COUNT_CODE = new HtmlInputText();
		COMP_UI_M_POL_COUNT_NAME = new HtmlInputText();
		COMP_POL_RES_PHONE_NO = new HtmlInputText();
		COMP_POL_MOBILE_NO = new HtmlInputText();
		COMP_POL_OFF_ADDRESS_1 = new HtmlInputText();
		COMP_POL_OFF_ADDRESS_2 = new HtmlInputText();
		COMP_POL_OFF_ADDRESS_3 = new HtmlInputText();
		COMP_POL_OFF_AREA_CODE = new HtmlInputText();
		COMP_UI_M_POSTAL_NAME = new HtmlInputText();
		COMP_POL_OFF_PHONE_NO = new HtmlInputText();
		COMP_POL_FAX_NO = new HtmlInputText();
		COMP_POL_FAX_AREA_CODE = new HtmlInputText();
		COMP_UI_M_POL_ADDL_STATUS_DESC = new HtmlInputText();
		COMP_PAYOR_TAB = new HtmlInputText();
		COMP_POL_MASTER_POL_NO = new HtmlInputText();
		COMP_POL_PROFIT_RATE = new HtmlInputText();
		COMP_POL_CREDIT_INT_RATE = new HtmlInputText();
		COMP_POL_PROP_NO = new HtmlInputText();
		COMP_UI_M_POL_FC_SA = new HtmlInputText();
		COMP_UI_M_POL_LC_SA = new HtmlInputText();
		COMP_POL_OCC_RATE = new HtmlInputText();
		COMP_POL_HEALTH_RATE = new HtmlInputText();
		COMP_POL_PROJECT_CODE = new HtmlInputText();
		COMP_UI_M_PROJECT_CODE_DESC = new HtmlInputText();
		COMP_POL_DEVELOPER_CODE = new HtmlInputText();
		COMP_UI_M_DEVELOPER_CODE_DESC = new HtmlInputText();
		COMP_POL_PAYOR_SDCODE = new HtmlInputText();
		COMP_UI_M_PAYOR_CONT_NAME = new HtmlInputText();
		COMP_POL_CUST_CODE = new HtmlInputText();
		COMP_UI_M_POL_CUST_DESC = new HtmlInputText();
		COMP_POL_BASIC_RATE = new HtmlInputText();
		COMP_POL_FC_BASIC_PREM = new HtmlInputText();
		COMP_POL_LC_BASIC_PREM = new HtmlInputText();
		COMP_POL_FC_HEALTH_LOAD = new HtmlInputText();
		COMP_POL_LC_HEALTH_LOAD = new HtmlInputText();
		COMP_POL_FLEX_01 = new HtmlInputText();
		COMP_UI_M_CONT_NAME = new HtmlInputText();
		COMP_POL_DEFER_PRD = new HtmlInputText();
		COMP_POL_EMPLOYER_CODE = new HtmlInputText();
		COMP_POL_SRC_OF_BUS = new HtmlInputText();
		COMP_UI_M_POL_SRC_OF_BUS_DESC = new HtmlInputText();
		COMP_POL_FC_ADDL_PREM = new HtmlInputText();
		COMP_POL_LC_ADDL_PREM = new HtmlInputText();
		COMP_POL_FC_TOT_SA = new HtmlInputText();
		COMP_POL_LC_TOT_SA = new HtmlInputText();
		COMP_UI_M_FC_DEATH_LOAD = new HtmlInputText();
		COMP_UI_M_LC_DEATH_LOAD = new HtmlInputText();
		COMP_POL_FLEX_02 = new HtmlInputText();
		COMP_POL_SUB_PLAN_CODE = new HtmlInputText();
		COMP_POL_CONT_CODE = new HtmlInputText();
		COMP_POL_ASSURED_NAME = new HtmlInputText();
		COMP_UI_M_POL_FC_TOT_PREM = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_PREM = new HtmlInputText();
		COMP_UI_M_POL_FC_PREM = new HtmlInputText();
		COMP_UI_M_POL_LC_PREM = new HtmlInputText();
		COMP_UI_M_FC_TPD_LOAD = new HtmlInputText();
		COMP_UI_M_LC_TPD_LOAD = new HtmlInputText();
		COMP_POL_FLEX_03 = new HtmlInputText();
		COMP_POL_GRANTEE_NAME = new HtmlInputText();
		COMP_UI_M_POL_SUB_PLAN_CODE_DESC = new HtmlInputText();
		COMP_POL_PERIOD = new HtmlInputText();
		COMP_POL_PREM_PAY_YRS = new HtmlInputText();
		COMP_POL_FC_NETT_PREM = new HtmlInputText();
		COMP_POL_LC_NETT_PREM = new HtmlInputText();
		COMP_UI_M_POL_FC_TOT_LOADING = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_LOADING = new HtmlInputText();
		COMP_UI_M_FC_MED_LOAD = new HtmlInputText();
		COMP_UI_M_LC_MED_LOAD = new HtmlInputText();
		COMP_POL_LC_TOP_UP_AMT = new HtmlInputText();
		COMP_POL_INTRODUCER_REF_ID1 = new HtmlInputText();
		COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC = new HtmlInputText();
		COMP_POL_BANK_BRANCH_NAME = new HtmlInputText();
		COMP_UI_M_BRANCH_CODE_DESC = new HtmlInputText();
		COMP_POL_DIVN_CODE = new HtmlInputText();
		COMP_UI_M_POL_FC_TOT_DISCOUNT = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_DISCOUNT = new HtmlInputText();
		COMP_POL_FC_CURR_SA = new HtmlInputText();
		COMP_POL_LC_CURR_SA = new HtmlInputText();
		COMP_POL_FC_TOP_UP_AMT = new HtmlInputText();
		COMP_UI_M_FC_OCC_LOAD = new HtmlInputText();
		COMP_UI_M_LC_OCC_LOAD = new HtmlInputText();
		COMP_POL_BANK_REF_NO = new HtmlInputText();
		COMP_POL_SA_CURR_CODE = new HtmlInputText();
		COMP_UI_M_POL_SA_CURR_DESC = new HtmlInputText();
		COMP_POL_SA_EXCH_RATE = new HtmlInputText();
		COMP_UI_M_POL_DIVN_DESC = new HtmlInputText();
		COMP_UI_M_FC_PCHARGES_BORNE_CUST = new HtmlInputText();
		COMP_UI_M_LC_PCHARGES_BORNE_CUST = new HtmlInputText();
		COMP_UI_M_FC_GROSS_CONT = new HtmlInputText();
		COMP_UI_M_LC_GROSS_CONT = new HtmlInputText();
		COMP_POL_LC_EXC_INT_AMT = new HtmlInputText();
		COMP_POL_CUST_CURR_CODE = new HtmlInputText();
		COMP_UI_M_POL_CUST_CURR_DESC = new HtmlInputText();
		COMP_POL_CUST_EXCH_RATE = new HtmlInputText();
		COMP_POL_DEPT_CODE = new HtmlInputText();
		COMP_UI_M_POL_FC_NET_PREM = new HtmlInputText();
		COMP_UI_M_POL_LC_NET_PREM = new HtmlInputText();
		COMP_UI_M_FC_BROK_COMM = new HtmlInputText();
		COMP_UI_M_LC_BROK_COMM = new HtmlInputText();
		COMP_POL_EXC_INT_PERC = new HtmlInputText();
		COMP_POL_STAFF_CCLASS_CODE = new HtmlInputText();
		COMP_UI_M_CCLAS_CLASS_DESC = new HtmlInputText();
		COMP_POL_FC_EXC_INT_AMT = new HtmlInputText();
		COMP_POL_FC_MODAL_PREM = new HtmlInputText();
		COMP_POL_NO_OF_UNIT = new HtmlInputText();
		COMP_POL_LC_MODAL_PREM = new HtmlInputText();
		COMP_UI_M_POL_DEPT_DESC = new HtmlInputText();
		COMP_UI_M_POL_MODE_OF_PYMT_RATE = new HtmlInputText();
		COMP_UI_M_POL_FC_MOP = new HtmlInputText();
		COMP_UI_M_POL_LC_MOP = new HtmlInputText();
		COMP_UI_M_FC_CHARGE = new HtmlInputText();
		COMP_UI_M_LC_CHARGE = new HtmlInputText();
		COMP_POL_RI_POOL_CODE = new HtmlInputText();
		COMP_UI_M_POL_RI_POOL_CODE_DESC = new HtmlInputText();
		COMP_POL_LOAD_PERC = new HtmlInputText();
		COMP_POL_NO_OF_INST = new HtmlInputText();
		COMP_POL_MODE_OF_PYMT_RATE = new HtmlInputText();
		COMP_POL_CLASS_CODE = new HtmlInputText();
		COMP_UI_M_POL_FC_GR_ANN_PREM = new HtmlInputText();
		COMP_UI_M_POL_LC_GR_ANN_PREM = new HtmlInputText();
		COMP_UI_M_FC_PCHARGES_BORNE_COMP = new HtmlInputText();
		COMP_UI_M_LC_PCHARGES_BORNE_COMP = new HtmlInputText();
		COMP_POL_ORG_COMM_RATE = new HtmlInputText();
		COMP_POL_ORG_COMM_VALUE = new HtmlInputText();
		COMP_POL_COMM_RATE = new HtmlInputText();
		COMP_POL_COMM_VALUE = new HtmlInputText();
		COMP_POL_FC_NET_PREM = new HtmlInputText();
		COMP_POL_LC_NET_PREM = new HtmlInputText();
		COMP_UI_M_FC_INST_PREM = new HtmlInputText();
		COMP_UI_M_LC_INST_PREM = new HtmlInputText();
		COMP_POL_CQS_PERC = new HtmlInputText();
		COMP_POL_CREDIT_DISCOUNT_PERC = new HtmlInputText();
		COMP_POL_FORM_NO = new HtmlInputText();
		COMP_POL_FC_SUM_ASSURED = new HtmlInputText();
		COMP_POL_LC_SUM_ASSURED = new HtmlInputText();
		COMP_UI_M_POL_CLASS_DESC = new HtmlInputText();
		COMP_UI_M_POL_INST_FC_PREM = new HtmlInputText();
		COMP_UI_M_POL_INST_LC_PREM = new HtmlInputText();
		COMP_POL_FC_BANK_ALLOC_AMT = new HtmlInputText();
		COMP_POL_LC_BANK_ALLOC_AMT = new HtmlInputText();
		COMP_UI_M_POL_CONT_AD_ACC_NO = new HtmlInputText();
		COMP_POL_PROP_REF_NO = new HtmlInputText();
		COMP_POL_AGENT_REF_CODE = new HtmlInputText();
		COMP_POL_FC_DEPOSIT_AMOUNT = new HtmlInputText();
		COMP_POL_LC_DEPOSIT_AMOUNT = new HtmlInputText();
		COMP_POL_LC_MIN_PREM = new HtmlInputText();
		COMP_POL_FC_DISC_AMT = new HtmlInputText();
		COMP_POL_LC_DISC_AMT = new HtmlInputText();
		COMP_POL_FC_CLIENT_ALLOC_AMT = new HtmlInputText();
		COMP_POL_LC_CLIENT_ALLOC_AMT = new HtmlInputText();
		COMP_POL_CONT_AD_BANK_CODE = new HtmlInputText();
		COMP_UI_M_BANK_CODE_DESC = new HtmlInputText();
		COMP_POL_REMARKS = new HtmlInputText();
		COMP_POL_FC_MIN_PREM = new HtmlInputText();
		COMP_UI_M_FC_SCHARGES_BORNE_CUST = new HtmlInputText();
		COMP_UI_M_LC_SCHARGES_BORNE_CUST = new HtmlInputText();
		COMP_UI_M_FC_SCHARGES_BORNE_COMP = new HtmlInputText();
		COMP_UI_M_LC_SCHARGES_BORNE_COMP = new HtmlInputText();
		COMP_POL_CARD_HOLDER_NAME = new HtmlInputText();
		COMP_POL_LC_EXTRA_PREM = new HtmlInputText();
		COMP_POL_FC_EXTRA_PREM = new HtmlInputText();
		COMP_POL_FC_MON_ANNU_AMT = new HtmlInputText();
		COMP_POL_LC_MON_ANNU_AMT = new HtmlInputText();
		COMP_POL_FC_FIRST_PREM = new HtmlInputText();
		COMP_POL_LC_FIRST_PREM = new HtmlInputText();
		COMP_POL_FC_PRE_TPD_BNF = new HtmlInputText();
		COMP_POL_LC_PRE_TPD_BNF = new HtmlInputText();
		COMP_POL_AUTH_LIMIT = new HtmlInputText();
		COMP_POL_NEW_FC_SA = new HtmlInputText();
		COMP_POL_NEW_LC_SA = new HtmlInputText();
		COMP_POL_ORG_NEW_FC_SA = new HtmlInputText();
		COMP_POL_ORG_NEW_LC_SA = new HtmlInputText();
		COMP_POL_MICR_CODE = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_FORM_CAPTION = new HtmlOutputLabel();
		COMP_POL_CURR_SA_LIMIT_LABEL = new HtmlOutputLabel();
		COMP_POL_CURR_SA_LABEL = new HtmlOutputLabel();
		COMP_PROP_LC_DEP_PREM_LABEL = new HtmlOutputLabel();
		COMP_PROP_FC_DEP_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_DEF_PERIOD_FM_LABEL = new HtmlOutputLabel();
		COMP_POL_DEF_PERIOD_TO_LABEL = new HtmlOutputLabel();
		COMP_POL_WAQAF_PERIOD_FM_LABEL = new HtmlOutputLabel();
		COMP_POL_WAQAF_PERIOD_TO_LABEL = new HtmlOutputLabel();
		COMP_POL_END_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_END_CODE_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_END_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_MED_FEE_RECOVER_YN_LABEL = new HtmlOutputLabel();
		COMP_POL_END_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_END_EFF_FROM_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_END_EFF_TO_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_END_DESC_LABEL = new HtmlOutputLabel();
		COMP_UI_M_PAY_PERIOD_LABEL = new HtmlOutputLabel();
		COMP_UI_M_PAY_YEARS_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_SA_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_SA_LABEL = new HtmlOutputLabel();
		COMP_UI_M_ADDL_STATUS_DESC = new HtmlOutputLabel();
		COMP_UI_M_APPRV_STATUS = new HtmlOutputLabel();
		COMP_UI_M_BUS_STATUS = new HtmlOutputLabel();
		COMP_UI_M_END_STATUS = new HtmlOutputLabel();
		COMP_UI_M_END_IDX_TYPE_NO = new HtmlOutputLabel();
		COMP_UI_M_AMEND_IDX = new HtmlOutputLabel();
		COMP_POL_PROD_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_PROD_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_PROD_GROUP_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_PROD_GROUP_CODE_LABEL = new HtmlOutputLabel();
		COMP_POL_PLAN_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_PLAN_DESC_LABEL = new HtmlOutputLabel();
		COMP_UI_M_ICON_HINT = new HtmlOutputLabel();
		COMP_UI_M_CLM_ADDL_STATUS = new HtmlOutputLabel();
		COMP_POL_ISSUE_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_UW_YEAR_LABEL = new HtmlOutputLabel();
		COMP_POL_NO_YRS_PREM_PAID_LABEL = new HtmlOutputLabel();
		COMP_UI_M_CIC_STATUS = new HtmlOutputLabel();
		COMP_POL_JOINT_LIFE_YN_LABEL = new HtmlOutputLabel();
		COMP_POL_JOINT_LIFE_AGE_LABEL = new HtmlOutputLabel();
		COMP_POL_FRZ_FLAG_LABEL = new HtmlOutputLabel();
		COMP_UI_M_WAI_STATUS = new HtmlOutputLabel();
		COMP_POL_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_CASH_YN_LABEL = new HtmlOutputLabel();
		COMP_UI_M_HOLD_STATUS = new HtmlOutputLabel();
		COMP_POL_ASSRD_REF_ID1_LABEL = new HtmlOutputLabel();
		COMP_POL_TRAN_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_ASSRD_REF_ID2_LABEL = new HtmlOutputLabel();
		COMP_UI_M_MAT_AGE_LABEL = new HtmlOutputLabel();
		COMP_POL_APPRV_UID = new HtmlOutputLabel();
		COMP_UI_M_POL_CONVERT_YN = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_SA1_LABEL = new HtmlOutputLabel();
		COMP_POL_BASIC_RATE1_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_BASIC_PREM1_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_ADDL_PREM1_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_PREM1_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_LOADING1_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_NET_PREM1_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_MOP1_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_INST_LC_PREM1_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_DISC_AMT1_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_FIRST_PREM1_LABEL = new HtmlOutputLabel();
		COMP_POL_RES_ADDRESS_1_LABEL = new HtmlOutputLabel();
		COMP_POL_RES_ADDRESS_2_LABEL = new HtmlOutputLabel();
		COMP_POL_RES_ADDRESS_3_LABEL = new HtmlOutputLabel();
		COMP_POL_RES_AREA_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_CITY_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_CITY_NAME_LABEL = new HtmlOutputLabel();
		COMP_POL_STATE_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_STATE_NAME_LABEL = new HtmlOutputLabel();
		COMP_POL_COUNT_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_COUNT_NAME_LABEL = new HtmlOutputLabel();
		COMP_POL_RES_PHONE_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_MOBILE_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_OFF_ADDRESS_1_LABEL = new HtmlOutputLabel();
		COMP_POL_OFF_ADDRESS_2_LABEL = new HtmlOutputLabel();
		COMP_POL_OFF_ADDRESS_3_LABEL = new HtmlOutputLabel();
		COMP_POL_OFF_AREA_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POSTAL_NAME_LABEL = new HtmlOutputLabel();
		COMP_POL_OFF_PHONE_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_FAX_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_FAX_AREA_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL = new HtmlOutputLabel();
		COMP_PAYOR_TAB_LABEL = new HtmlOutputLabel();
		COMP_POL_MASTER_POL_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_PROFIT_RATE_LABEL = new HtmlOutputLabel();
		COMP_POL_MODE_OF_CALC_LABEL = new HtmlOutputLabel();
		COMP_POL_STD_SUBSTD_LABEL = new HtmlOutputLabel();
		COMP_POL_CREDIT_INT_RATE_LABEL = new HtmlOutputLabel();
		COMP_POL_PROP_NO_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_SA_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_SA_LABEL = new HtmlOutputLabel();
		COMP_POL_OCC_RATE_LABEL = new HtmlOutputLabel();
		COMP_POL_HEALTH_RATE_LABEL = new HtmlOutputLabel();
		COMP_POL_PROJECT_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_PROJECT_CODE_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_DEVELOPER_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_DEVELOPER_CODE_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_PYMT_TYPE_LABEL = new HtmlOutputLabel();
		COMP_POL_PAYOR_SDCODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_PAYOR_CONT_NAME_LABEL = new HtmlOutputLabel();
		COMP_POL_CUST_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_CUST_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_BASIC_RATE_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_BASIC_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_BASIC_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_HEALTH_LOAD_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_HEALTH_LOAD_LABEL = new HtmlOutputLabel();
		COMP_POL_HOME_OWNER_FLAG_LABEL = new HtmlOutputLabel();
		COMP_POL_FLEX_01_LABEL = new HtmlOutputLabel();
		COMP_UI_M_CONT_NAME_LABEL = new HtmlOutputLabel();
		COMP_POL_DEFER_PRD_LABEL = new HtmlOutputLabel();
		COMP_POL_EMPLOYER_CODE_LABEL = new HtmlOutputLabel();
		COMP_POL_SRC_OF_BUS_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_ADDL_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_ADDL_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_TOT_SA_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_TOT_SA_LABEL = new HtmlOutputLabel();
		COMP_POL_PROP_RECV_DT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_DEATH_LOAD_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_DEATH_LOAD_LABEL = new HtmlOutputLabel();
		COMP_POL_FLEX_02_LABEL = new HtmlOutputLabel();
		COMP_POL_INCORPORATED_YN_LABEL = new HtmlOutputLabel();
		COMP_POL_SUB_PLAN_CODE_LABEL = new HtmlOutputLabel();
		COMP_POL_NET_PREM_YN_LABEL = new HtmlOutputLabel();
		COMP_POL_CONT_CODE_LABEL = new HtmlOutputLabel();
		COMP_POL_ASSURED_NAME_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_TOT_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_PROP_STAMP_DT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_TPD_LOAD_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_TPD_LOAD_LABEL = new HtmlOutputLabel();
		COMP_POL_FLEX_03_LABEL = new HtmlOutputLabel();
		COMP_POL_GRANTEE_NAME_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_GRANTEE_TYPE_LABEL = new HtmlOutputLabel();
		COMP_POL_PERIOD_LABEL = new HtmlOutputLabel();
		COMP_POL_PREM_PAY_YRS_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_NETT_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_NETT_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_TOT_LOADING_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_LOADING_LABEL = new HtmlOutputLabel();
		COMP_POL_PROP_DECL_DT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_MED_LOAD_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_MED_LOAD_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_TOP_UP_AMT_LABEL = new HtmlOutputLabel();
		COMP_POL_INTRODUCER_REF_ID1_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_BANK_BRANCH_NAME_LABEL = new HtmlOutputLabel();
		COMP_UI_M_BRANCH_CODE_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_START_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_EXPIRY_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_DIVN_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_CURR_SA_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_CURR_SA_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_TOP_UP_AMT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_OCC_LOAD_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_OCC_LOAD_LABEL = new HtmlOutputLabel();
		COMP_POL_RATE_APPLIED_ON_LABEL = new HtmlOutputLabel();
		COMP_POL_BANK_REF_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_SA_CURR_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_SA_CURR_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_SA_EXCH_RATE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_DIVN_DESC_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL = new HtmlOutputLabel();
		COMP_POL_ORG_PROP_RECV_YN_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_GROSS_CONT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_GROSS_CONT_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_EXC_INT_AMT_LABEL = new HtmlOutputLabel();
		COMP_POL_NL_FM_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_TARIFF_TERM_FLAG_LABEL = new HtmlOutputLabel();
		COMP_POL_CUST_CURR_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_CUST_CURR_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_CUST_EXCH_RATE_LABEL = new HtmlOutputLabel();
		COMP_POL_DEPT_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_NET_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_NET_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_BROK_COMM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_BROK_COMM_LABEL = new HtmlOutputLabel();
		COMP_POL_EXC_INT_PERC_LABEL = new HtmlOutputLabel();
		COMP_POL_STAFF_CCLASS_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_CCLAS_CLASS_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_STD_RISK_YN_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_EXC_INT_AMT_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_MODAL_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_NO_OF_UNIT_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_MODAL_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_DEPT_DESC_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_MOP_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_MOP_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_CHARGE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_CHARGE_LABEL = new HtmlOutputLabel();
		COMP_POL_RI_POOL_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_CREDIT_YN_LABEL = new HtmlOutputLabel();
		COMP_POL_LOAD_PERC_LABEL = new HtmlOutputLabel();
		COMP_POL_STAFF_YN_LABEL = new HtmlOutputLabel();
		COMP_POL_FAC_BASIS_LABEL = new HtmlOutputLabel();
		COMP_POL_MODE_OF_PYMT_LABEL = new HtmlOutputLabel();
		COMP_POL_NO_OF_INST_LABEL = new HtmlOutputLabel();
		COMP_POL_MODE_OF_PYMT_RATE_LABEL = new HtmlOutputLabel();
		COMP_POL_CLASS_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_FC_GR_ANN_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_NET_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_NET_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_INST_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_INST_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_CQS_PERC_LABEL = new HtmlOutputLabel();
		COMP_POL_CREDIT_DISCOUNT_PERC_LABEL = new HtmlOutputLabel();
		COMP_POL_FAC_YN_LABEL = new HtmlOutputLabel();
		COMP_POL_FORM_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_SUM_ASSURED_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_SUM_ASSURED_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_CLASS_DESC_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_INST_FC_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_INST_LC_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_BANK_ALLOC_AMT_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_BANK_ALLOC_AMT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_CONT_AD_ACC_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_PROP_REF_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_AGENT_REF_CODE_LABEL = new HtmlOutputLabel();
		COMP_POL_CQS_YN_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_DEPOSIT_AMOUNT_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_DEPOSIT_AMOUNT_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_MIN_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_DISC_AMT_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_DISC_AMT_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_CLIENT_ALLOC_AMT_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_CLIENT_ALLOC_AMT_LABEL = new HtmlOutputLabel();
		COMP_POL_CONT_AD_BANK_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_BANK_CODE_DESC_LABEL = new HtmlOutputLabel();
		COMP_POL_FIRST_INST_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_LAST_INST_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_REMARKS_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_MIN_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL = new HtmlOutputLabel();
		COMP_POL_CARD_HOLDER_NAME_LABEL = new HtmlOutputLabel();
		COMP_POL_DEF_IMM_FLAG_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_EXTRA_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_EXTRA_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_MON_ANNU_AMT_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_MON_ANNU_AMT_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_FIRST_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_FIRST_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_FC_PRE_TPD_BNF_LABEL = new HtmlOutputLabel();
		COMP_POL_LC_PRE_TPD_BNF_LABEL = new HtmlOutputLabel();
		COMP_POL_AUTH_LIMIT_LABEL = new HtmlOutputLabel();

		/*
		 * Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation
		 * and commission clawback 2
		 */
		COMP_POL_LAPS_OVR_YN_LABEL = new HtmlOutputLabel();
		/* End */

		/*
		 * Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation
		 * and commission clawback 2
		 */
		COMP_POL_LAPS_OVR_DT_LABEL = new HtmlOutputLabel();
		/* End */

		/*
		 * Added by saritha on 27-01-2017 for RM018T - DEV_IL_ZB
		 * Life_027-Replacement Policy
		 */
		COMP_POL_REPLACEMENT_YN_LABEL = new HtmlOutputLabel();
		/* End */

		// Instantiating HtmlSelectOneMenu
		COMP_POL_MED_FEE_RECOVER_YN = new HtmlSelectOneMenu();
		COMP_POL_JOINT_LIFE_YN = new HtmlSelectOneMenu();
		COMP_POL_FRZ_FLAG = new HtmlSelectOneMenu();
		COMP_POL_CASH_YN = new HtmlSelectOneMenu();
		COMP_POL_MODE_OF_CALC = new HtmlSelectOneMenu();
		COMP_POL_STD_SUBSTD = new HtmlSelectOneMenu();
		COMP_POL_PYMT_TYPE = new HtmlSelectOneMenu();
		COMP_POL_HOME_OWNER_FLAG = new HtmlSelectOneMenu();
		COMP_POL_INCORPORATED_YN = new HtmlSelectOneMenu();
		COMP_POL_NET_PREM_YN = new HtmlSelectOneMenu();
		COMP_POL_GRANTEE_TYPE = new HtmlSelectOneMenu();
		COMP_POL_RATE_APPLIED_ON = new HtmlSelectOneMenu();
		COMP_POL_ORG_PROP_RECV_YN = new HtmlSelectOneMenu();
		COMP_POL_TARIFF_TERM_FLAG = new HtmlSelectOneMenu();
		COMP_POL_STD_RISK_YN = new HtmlSelectOneMenu();
		COMP_POL_CREDIT_YN = new HtmlSelectOneMenu();
		COMP_POL_STAFF_YN = new HtmlSelectOneMenu();
		COMP_POL_FAC_BASIS = new HtmlSelectOneMenu();
		COMP_POL_MODE_OF_PYMT = new HtmlSelectOneMenu();
		COMP_POL_FAC_YN = new HtmlSelectOneMenu();
		COMP_POL_CQS_YN = new HtmlSelectOneMenu();
		COMP_POL_DEF_IMM_FLAG = new HtmlSelectOneMenu();
		/*
		 * added by gopi for RM018T - DEV_IL_ZB Life_022-Automated Premium Loan
		 * on 06/01/17
		 */
		COMP_PROD_INS_APL_YN = new HtmlSelectOneMenu();
		/* end */
		/*
		 * Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation
		 * and commission clawback 2
		 */
		COMP_POL_LAPS_OVR_YN = new HtmlSelectOneMenu();
		/* End */

		/*
		 * Added by saritha on 27-01-2017 for RM018T - DEV_IL_ZB
		 * Life_027-Replacement Policy
		 */
		COMP_POL_REPLACEMENT_YN = new HtmlSelectOneMenu();
		/* End */

		// Instantiating HtmlCalendar
		COMP_POL_END_DT = new HtmlCalendar();
		COMP_POL_END_EFF_FROM_DT = new HtmlCalendar();
		COMP_POL_END_EFF_TO_DT = new HtmlCalendar();
		COMP_POL_ISSUE_DT = new HtmlCalendar();
		COMP_POL_TRAN_DT = new HtmlCalendar();
		COMP_POL_PROP_RECV_DT = new HtmlCalendar();
		COMP_POL_PROP_STAMP_DT = new HtmlCalendar();
		COMP_POL_PROP_DECL_DT = new HtmlCalendar();
		COMP_POL_START_DT = new HtmlCalendar();
		COMP_POL_EXPIRY_DT = new HtmlCalendar();
		COMP_POL_NL_FM_DT = new HtmlCalendar();
		COMP_POL_FIRST_INST_DT = new HtmlCalendar();
		COMP_POL_LAST_INST_DT = new HtmlCalendar();

		/*
		 * Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation
		 * and commission clawback 2
		 */
		COMP_POL_LAPS_OVR_DT = new HtmlCalendar();
		/* End */

		// Instantiating HtmlCommandButton
		// COMP_UI_M_BUS_RUL = new HtmlCommandButton();
		COMP_UI_M_BUT_CC_LOV = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_GRP_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_COPY = new HtmlCommandLink();
		COMP_UI_M_BUT_FUND_QUERY = new HtmlCommandButton();
		COMP_UI_M_BUT_HOLD = new HtmlCommandButton();
		COMP_UI_M_BUT_UDDATE_STAT = new HtmlCommandButton();
		COMP_UI_M_BUT_UPI = new HtmlCommandButton();
		COMP_UI_M_BUT_CALC_DISC_LOAD = new HtmlCommandButton();
		COMP_UI_M_BUT_SURR_MAT = new HtmlCommandButton();
		// COMP_UI_M_BUT_ENDT = new HtmlCommandButton();
		COMP_UI_M_BUT_ENDT_OK = new HtmlCommandButton();
		COMP_UI_M_BUT_ENDT_CANCEL = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVAL = new HtmlCommandButton();
		COMP_UI_M_BUT_PRMDTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_PLAN = new HtmlCommandButton();
		COMP_UI_M_BUT_DOC_GEN_NO = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_PROD_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_CONVERT = new HtmlCommandButton();
		COMP_UI_M_BUT_POL_AMDT = new HtmlCommandButton();
		COMP_UI_M_BUT_UPLOAD = new HtmlCommandButton();
		COMP_UI_M_BUT_CLAIM = new HtmlCommandButton();
		COMP_UI_M_BUT_FUND_DTL = new HtmlCommandButton();
		COMP_SAVE_BUTTON = new HtmlCommandButton();
		COMP_SAVE_BUTTON2 = new HtmlCommandButton();
		COMP_BACK_BUTTON = new HtmlCommandButton();
		COMP_MANDATORY = new HtmlGraphicImage();

		COMP_POL_FLEX_14 = new HtmlSelectOneMenu();
		COMP_POL_FLEX_09 = new HtmlSelectOneMenu();
		COMP_POL_ESC_YN = new HtmlSelectOneMenu();
		COMP_POL_FLEX_08 = new HtmlInputText();
		// Html command Link
		COMP_SAVE_COMMAND_LINK = new HtmlCommandLink();
		COMP_SAVE_COMMAND_LINK2 = new HtmlCommandLink();

		COMP_POL_PREM_OPTION_CODE = new HtmlInputText();
		COMP_UI_POL_PREM_DESC = new HtmlInputText();

		/* Added By Saritha on 3.3.2016 for EMail id field Addition(Start) */
		COMP_POL_RES_EMAIL_ID = new HtmlInputText();
		COMP_POL_RES_EMAIL_ID_LABEL = new HtmlOutputLabel();
		/* End */
		/*
		 * Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB
		 * Life_002-Customer Master Changes COMMENTS
		 */

		COMP_POL_PREM_PAYER_CODE = new HtmlInputText();
		COMP_UI_M_POL_PREM_PAYER_CODE_DESC = new HtmlInputText();

		/* end */
		COMP_POL_EMR_RATE = new HtmlInputText();

		/* added by raja on 05-03-2017 for ssp call id - ZBILQC-1719062 */

		COMP_CUST_BUTTON = new HtmlCommandButton();
		COMP_ASSU_BUTTON = new HtmlCommandButton();

		COMP_ASSU_COMMAND_LINK = new HtmlCommandLink();
		COMP_CUST_COMMAND_LINK = new HtmlCommandLink();

		/* end */

		/*
		 * added by Sankaranarayanan on 27-03-2017 for ssp call id -
		 * ZBILQC-1721052
		 */

		COMP_POL_DISPATCH_MTD_LABEL = new HtmlOutputLabel();
		COMP_POL_DISPATCH_MTD = new HtmlSelectOneMenu();
		COMP_POL_DISPATCH_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_DISPATCH_DT = new HtmlCalendar();
		COMP_POL_DOC_ACK_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_DOC_ACK_DT = new HtmlCalendar();
		/* END */

		/* Added by Janani on 18.07.2017 for ZBILQC-1732136 */

		COMP_ANNUITY_MANDATORY = new HtmlOutputText();

		/* End */

		/* Added by saritha on 08-09-2017 */
		COMP_POL_LAPS_OVR_FM_DT = new HtmlOutputText();
		COMP_POL_LAPS_OVR_TO_DT = new HtmlOutputText();
		/* End */

		/* Added by saritha on 20-07-2017 for ssp call id ZBILQC-1732158 */
		COMP_POL_LAPS_OVR_FRM_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_LAPS_OVR_FRM_DT = new HtmlCalendar();
		/* End */

		/*
		 * Added by saritha on 17-08-2017 for ssp call id ZBILQC-1735415 as per
		 * Thiag sir sugg
		 */
		COMP_POL_QUESTIONAIRE = new HtmlCommandLink();
		/* End */
		COMP_UI_M_MOP_END = new HtmlSelectOneMenu();

		/* Added by saritha on 27-10-2017 for ssp call id ZBLIFE-1449063 */
		COMP_POL_CUST_EMP_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_CUST_EMP_NO = new HtmlInputText();
		/* End */

		COMP_UI_M_ACC_NAME = new HtmlInputText();

		/*
		 * Added by saritha on 21-11-2017 for Due date for debit order by each
		 * policy is required
		 */
		COMP_POL_DEBIT_DAY_LABEL = new HtmlOutputLabel();
		COMP_POL_DEBIT_DAY = new HtmlInputText();
		/* End */

		/* Added by Ameen on 09-03-2018 for FSD_IL_04_GOLDA */
		COMP_POL_REG_EXCESS_PREM_LABEL = new HtmlOutputLabel();
		COMP_POL_REG_EXCESS_PREM = new HtmlInputText();
		COMP_POL_RETURN_VAL_LABEL = new HtmlOutputLabel();
		COMP_POL_RETURN_VAL = new HtmlSelectOneMenu();
		/* End */

		/*
		 * Added by Ameen on 24-03-2018 for KIC Method of collection cards
		 * option
		 */
		COMP_POL_CARD_EXP_DT = new HtmlCalendar();
		COMP_POL_CVV_NO = new HtmlInputText();
		/* End */
		/* Added by saritha on 16-04-2018 for KIC Office Address Fields Hide */
		COMP_POL_OFF_ADDRESS = new HtmlPanelGroup();
		/* End */
		/* added by Ameen on 13-07-2018 for TOI as per Ajay sugg. */
		COMP_UI_M_POBH_BROKER_CODE = new HtmlInputText();
		/* End */
		/* added by sivarajan on 12-08-2018 for KICLIFEQC-1761314 */
		COMP_POL_ENDORSEMENT_TYPE = new HtmlSelectOneMenu();
		/* End */

		/* added by Ameen on 21-10-2019 for SARWA for Retirement Product */
		COMP_POL_BNF_ESC_YN = new HtmlSelectOneMenu();
		COMP_POL_ADHOC_PREM_YN = new HtmlSelectOneMenu();
		COMP_POL_ADHOC_LC_PREM = new HtmlInputText();
		COMP_POL_CASHBACK_YN = new HtmlSelectOneMenu();
		COMP_POL_CASHBACK_PREC = new HtmlInputText();
		COMP_POL_CASHBACK_ST_YR = new HtmlInputText();
		/* End */

	}

	private boolean eflag;

	public boolean isEflag() {
		return eflag;
	}

	public void setEflag(boolean eflag) {
		this.eflag = eflag;
	}

	public void setListItemValues() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			setListPOL_JOINT_LIFE_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_JOINT_LIFE_YN", "YESNO"));

			setListPOL_MED_FEE_RECOVER_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_MED_FEE_RECOVER_YN", "YESNO"));
			/*
			 * added by saranya on 10-12-2016 for RM018T - FSD_IL_ZB
			 * Life_016-Queried Proposals v1.0
			 */
			setListPOL_CANCEL_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_FLEX_27", "YESNO"));
			/* End */

			setListPOL_FRZ_FLAG(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_FRZ_FLAG", "YESNO"));

			setListPOL_CASH_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_CASH_YN", "YESNO"));

			/*
			 * added by gopi for RM018T - DEV_IL_ZB Life_022-Automated Premium
			 * Loan on 06/01/17
			 */
			setListPOL_APL_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_APL_YN", "YESNO"));
			// end
			setListPOL_MODE_OF_CALC(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_MODE_OF_CALC", "IL_MODE_CALC"));

			setListPOL_STD_SUBSTD(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_STD_SUBSTD", "StandardcaseSubstandard case"));

			/*
			 * modified by Ameen on 12-10-2017 as per Chandramohan said
			 * setListPOL_PYMT_TYPE(ListItemUtil.getDropDownListValue(
			 * connection, "PILT002_APAC", "PT_IL_POLICY",
			 * "PT_IL_POLICY.POL_PYMT_TYPE", "IL_PAY_MODE"));
			 */

			setListPOL_PYMT_TYPE(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_PYMT_TYPE", "IL_POL_PAY"));

			setListPOL_HOME_OWNER_FLAG(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_HOME_OWNER_FLAG", "YESNO"));

			setListPOL_INCORPORATED_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_INCORPORATED_YN", "YESNO"));

			setListPOL_NET_PREM_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_NET_PREM_YN", "YESNO"));

			setListPOL_GRANTEE_TYPE(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_GRANTEE_TYPE", "IL_GRNT_TYPE"));

			setListPOL_RATE_APPLIED_ON(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_RATE_APPLIED_ON", "IL_RATE_APPL"));

			setListPOL_ORG_PROP_RECV_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_ORG_PROP_RECV_YN", "YESNO"));

			setListPOL_TARIFF_TERM_FLAG(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_TARIFF_TERM_FLAG", "IL_TAR_TERM"));

			setListPOL_STD_RISK_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_STD_RISK_YN", "YESNO"));

			setListPOL_CREDIT_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_CREDIT_YN", "YESNO"));

			setListPOL_STAFF_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_STAFF_YN", "YESNO"));

			setListPOL_FAC_BASIS(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_FAC_BASIS", "IL_FAC_BASIS"));

			setListPOL_MODE_OF_PYMT(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_MODE_OF_PYMT", "PAYMODE"));

			setListPOL_FAC_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_FAC_YN", "YESNO"));

			setListPOL_CQS_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_CQS_YN", "YESNO"));

			setListPOL_DEF_IMM_FLAG(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_DEF_IMM_FLAG", "IL_ANNU_PER"));

			setListPOL_ESC_YN(ListItemUtil.getDropDownListValue(connection, "PILT002T", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_ESC_YN", "ESC_APP_YN"));

			setListPOL_FLEX_14(ListItemUtil.getDropDownListValue(connection, "PILT002T", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_FLEX_14", "ESC_APP"));

			setListPOL_FLEX_09(ListItemUtil.getDropDownListValue(connection, "PILT002T", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_FLEX_09", "ESC_APP_INT"));
			/*
			 * Added by saranya for RM018T - FSD_IL_ZB Life_001-Education
			 * Endowment Plan COMMENTS on 26-01-2017
			 */
			setListPOL_ANN_PAY_PERIOD(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_ANN_PAY_PERIOD", "IL_ANN_PAY"));

			setListPOL_BNF_ESC_PERC(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_BNF_ESC_PERC", "IL_BNF_ESC"));

			setListPOL_UL_PREM_CALC(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_UL_PREM_CALC", "IL_UL_PRMCAL"));

			/* End */

			/*
			 * setListPOL_CVR_ESC_PERC(ListItemUtil.getDropDownListValue(
			 * connection, "PILT002_APAC", "PT_IL_POLICY",
			 * "PT_IL_POLICY.POL_CVR_ESC_PERC", ""));
			 */
			/* Added by Ram on 25/11/2016 for LoanType field addition */
			setListPOL_LOAN_TYPE(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT002_APAC_QE",
					"PW_IL_QUICK_QUOTE", "PW_IL_QUICK_QUOTE.QUOT_LOAN_TYPE", "IL_LOAN_TYPE"));
			/* End */

			/*
			 * Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB
			 * Life_015-Lapsation and commission clawback 2
			 */

			setListPOL_LAPS_OVR_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_LAPS_OVR_YN", "YESNO"));

			/* End */
			/*
			 * Added by saranya for RM018T - DEV_IL_ZB Life_027-Replacement
			 * Policy on 17-03-2017
			 */
			setListPOL_REPL_POLICY_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_REPL_POLICY_YN", "YESNO"));
			/* End */

			/* Added by sankaranarayanan for ZBILQC-1721052 27-03-2017 */
			setListPOL_DISPATCH_MTD(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_DISPATCH_MTD", "IL_DISP_MTD"));
			/* end */

			List<SelectItem> list = new ArrayList<SelectItem>();
			list.add(new SelectItem("ETI", "ETI"));
			list.add(new SelectItem("RPU", "RPU"));
			list.add(new SelectItem("ACS", "ACS"));
			setListAPL(list);

			List<SelectItem> listStandard = new ArrayList<SelectItem>();
			listStandard.add(new SelectItem("1", "Standard case"));
			listStandard.add(new SelectItem("2", "Sub standard case"));
			setListPOL_STND_SUB(listStandard);

			/* Added by Ram on 08/12/2016 for Business Rule reports */
			setListUI_M_SCHEDULE_TYPE(UI_M_SCHEDULE_TYPELIST());
			System.out.println("getListUI_M_SCHEDULE_TYPE  " + getListUI_M_SCHEDULE_TYPE());
			/* End */

			setListPOL_MOP_END(getExternalTableItemValue());

			setListPOL_RETURN_VAL(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_RETURN_VAL", "IL_UL_CLM_VL"));
			/* Added by Sivarajan on 12-08-2018 for KICLIFEQC-1761314 */
			setListENDORSEMENT_TYPE(getLIV_CODE());
			/*
			 * added by Ameen on 21-10-2019 for SARWA sugg. by Vijay and Manoj
			 */
			setListPOL_BNF_ESC_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_REPL_POLICY_YN", "YESNO"));

			setListPOL_ADHOC_PREM_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_REPL_POLICY_YN", "YESNO"));

			setListPOL_CASHBACK_YN(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_REPL_POLICY_YN", "YESNO"));
			/* END */
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	/*
	 * Added by saranya on 10-12-2016 for RM018T - FSD_IL_ZB Life_016-Queried
	 * Proposals v1.0
	 */
	private HtmlOutputLabel COMP_POL_CANCEL_YN_LABEL;

	private HtmlSelectOneMenu COMP_POL_CANCEL_YN;

	public HtmlOutputLabel getCOMP_POL_CANCEL_YN_LABEL() {
		return COMP_POL_CANCEL_YN_LABEL;
	}

	public void setCOMP_POL_CANCEL_YN_LABEL(HtmlOutputLabel cOMP_POL_CANCEL_YN_LABEL) {
		COMP_POL_CANCEL_YN_LABEL = cOMP_POL_CANCEL_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_CANCEL_YN() {
		return COMP_POL_CANCEL_YN;
	}

	public void setCOMP_POL_CANCEL_YN(HtmlSelectOneMenu cOMP_POL_CANCEL_YN) {
		COMP_POL_CANCEL_YN = cOMP_POL_CANCEL_YN;
	}
	/* End */
	/*
	 * Added by saranya on 07-12-2016 for RM018T - FSD_IL_ZB
	 * Life_013_Underwriting changes
	 */

	private HtmlOutputLabel COMP_POL_FC_AGENT_PREM_lABEL;

	private HtmlOutputLabel COMP_POL_LC_AGENT_PREM_lABEL;

	private HtmlInputText COMP_POL_FC_AGENT_PREM;

	private HtmlInputText COMP_POL_LC_AGENT_PREM;

	public HtmlInputText getCOMP_POL_FC_AGENT_PREM() {
		return COMP_POL_FC_AGENT_PREM;
	}

	public void setCOMP_POL_FC_AGENT_PREM(HtmlInputText cOMP_POL_FC_AGENT_PREM) {
		COMP_POL_FC_AGENT_PREM = cOMP_POL_FC_AGENT_PREM;
	}

	public HtmlInputText getCOMP_POL_LC_AGENT_PREM() {
		return COMP_POL_LC_AGENT_PREM;
	}

	public void setCOMP_POL_LC_AGENT_PREM(HtmlInputText cOMP_POL_LC_AGENT_PREM) {
		COMP_POL_LC_AGENT_PREM = cOMP_POL_LC_AGENT_PREM;
	}

	public HtmlOutputLabel getCOMP_POL_FC_AGENT_PREM_lABEL() {
		return COMP_POL_FC_AGENT_PREM_lABEL;
	}

	public void setCOMP_POL_FC_AGENT_PREM_lABEL(HtmlOutputLabel cOMP_POL_FC_AGENT_PREM_lABEL) {
		COMP_POL_FC_AGENT_PREM_lABEL = cOMP_POL_FC_AGENT_PREM_lABEL;
	}

	public HtmlOutputLabel getCOMP_POL_LC_AGENT_PREM_lABEL() {
		return COMP_POL_LC_AGENT_PREM_lABEL;
	}

	public void setCOMP_POL_LC_AGENT_PREM_lABEL(HtmlOutputLabel cOMP_POL_LC_AGENT_PREM_lABEL) {
		COMP_POL_LC_AGENT_PREM_lABEL = cOMP_POL_LC_AGENT_PREM_lABEL;
	}

	/* End */

	public HtmlOutputLabel getCOMP_POL_DEF_PERIOD_FM_LABEL() {
		return COMP_POL_DEF_PERIOD_FM_LABEL;
	}

	public HtmlInputText getCOMP_POL_DEF_PERIOD_FM() {
		return COMP_POL_DEF_PERIOD_FM;
	}

	public void setCOMP_POL_DEF_PERIOD_FM_LABEL(HtmlOutputLabel COMP_POL_DEF_PERIOD_FM_LABEL) {
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

	public void setCOMP_POL_DEF_PERIOD_TO_LABEL(HtmlOutputLabel COMP_POL_DEF_PERIOD_TO_LABEL) {
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

	public void setCOMP_POL_WAQAF_PERIOD_FM_LABEL(HtmlOutputLabel COMP_POL_WAQAF_PERIOD_FM_LABEL) {
		this.COMP_POL_WAQAF_PERIOD_FM_LABEL = COMP_POL_WAQAF_PERIOD_FM_LABEL;
	}

	public void setCOMP_POL_WAQAF_PERIOD_FM(HtmlInputText COMP_POL_WAQAF_PERIOD_FM) {
		this.COMP_POL_WAQAF_PERIOD_FM = COMP_POL_WAQAF_PERIOD_FM;
	}

	public HtmlOutputLabel getCOMP_POL_WAQAF_PERIOD_TO_LABEL() {
		return COMP_POL_WAQAF_PERIOD_TO_LABEL;
	}

	public HtmlInputText getCOMP_POL_WAQAF_PERIOD_TO() {
		return COMP_POL_WAQAF_PERIOD_TO;
	}

	public void setCOMP_POL_WAQAF_PERIOD_TO_LABEL(HtmlOutputLabel COMP_POL_WAQAF_PERIOD_TO_LABEL) {
		this.COMP_POL_WAQAF_PERIOD_TO_LABEL = COMP_POL_WAQAF_PERIOD_TO_LABEL;
	}

	public void setCOMP_POL_WAQAF_PERIOD_TO(HtmlInputText COMP_POL_WAQAF_PERIOD_TO) {
		this.COMP_POL_WAQAF_PERIOD_TO = COMP_POL_WAQAF_PERIOD_TO;
	}

	public HtmlOutputLabel getCOMP_POL_END_CODE_LABEL() {
		return COMP_POL_END_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_END_CODE() {
		return COMP_POL_END_CODE;
	}

	public void setCOMP_POL_END_CODE_LABEL(HtmlOutputLabel COMP_POL_END_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_END_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_END_CODE_DESC_LABEL) {
		this.COMP_UI_M_POL_END_CODE_DESC_LABEL = COMP_UI_M_POL_END_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_END_CODE_DESC(HtmlInputText COMP_UI_M_POL_END_CODE_DESC) {
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

	public void setCOMP_POL_MED_FEE_RECOVER_YN_LABEL(HtmlOutputLabel COMP_POL_MED_FEE_RECOVER_YN_LABEL) {
		this.COMP_POL_MED_FEE_RECOVER_YN_LABEL = COMP_POL_MED_FEE_RECOVER_YN_LABEL;
	}

	public void setCOMP_POL_MED_FEE_RECOVER_YN(HtmlSelectOneMenu COMP_POL_MED_FEE_RECOVER_YN) {
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

	public void setCOMP_POL_END_EFF_FROM_DT_LABEL(HtmlOutputLabel COMP_POL_END_EFF_FROM_DT_LABEL) {
		this.COMP_POL_END_EFF_FROM_DT_LABEL = COMP_POL_END_EFF_FROM_DT_LABEL;
	}

	public void setCOMP_POL_END_EFF_FROM_DT(HtmlCalendar COMP_POL_END_EFF_FROM_DT) {
		this.COMP_POL_END_EFF_FROM_DT = COMP_POL_END_EFF_FROM_DT;
	}

	public HtmlOutputLabel getCOMP_POL_END_EFF_TO_DT_LABEL() {
		return COMP_POL_END_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_END_EFF_TO_DT() {
		return COMP_POL_END_EFF_TO_DT;
	}

	public void setCOMP_POL_END_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_POL_END_EFF_TO_DT_LABEL) {
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

	public void setCOMP_POL_END_DESC_LABEL(HtmlOutputLabel COMP_POL_END_DESC_LABEL) {
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

	public void setCOMP_UI_M_PAY_PERIOD_LABEL(HtmlOutputLabel COMP_UI_M_PAY_PERIOD_LABEL) {
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

	public void setCOMP_UI_M_PAY_YEARS_LABEL(HtmlOutputLabel COMP_UI_M_PAY_YEARS_LABEL) {
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

	public void setCOMP_UI_M_ADDL_STATUS_DESC(HtmlOutputLabel COMP_UI_M_ADDL_STATUS_DESC) {
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

	public void setCOMP_UI_M_END_IDX_TYPE_NO(HtmlOutputLabel COMP_UI_M_END_IDX_TYPE_NO) {
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

	public void setCOMP_POL_PROD_CODE_LABEL(HtmlOutputLabel COMP_POL_PROD_CODE_LABEL) {
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

	public void setCOMP_UI_M_PROD_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PROD_DESC_LABEL) {
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

	public void setCOMP_POL_PLAN_CODE_LABEL(HtmlOutputLabel COMP_POL_PLAN_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_PLAN_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_PLAN_DESC_LABEL) {
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

	public void setCOMP_UI_M_CLM_ADDL_STATUS(HtmlOutputLabel COMP_UI_M_CLM_ADDL_STATUS) {
		this.COMP_UI_M_CLM_ADDL_STATUS = COMP_UI_M_CLM_ADDL_STATUS;
	}

	public HtmlOutputLabel getCOMP_POL_ISSUE_DT_LABEL() {
		return COMP_POL_ISSUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_ISSUE_DT() {
		return COMP_POL_ISSUE_DT;
	}

	public void setCOMP_POL_ISSUE_DT_LABEL(HtmlOutputLabel COMP_POL_ISSUE_DT_LABEL) {
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

	public void setCOMP_POL_NO_YRS_PREM_PAID_LABEL(HtmlOutputLabel COMP_POL_NO_YRS_PREM_PAID_LABEL) {
		this.COMP_POL_NO_YRS_PREM_PAID_LABEL = COMP_POL_NO_YRS_PREM_PAID_LABEL;
	}

	public void setCOMP_POL_NO_YRS_PREM_PAID(HtmlInputText COMP_POL_NO_YRS_PREM_PAID) {
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

	public void setCOMP_POL_JOINT_LIFE_YN_LABEL(HtmlOutputLabel COMP_POL_JOINT_LIFE_YN_LABEL) {
		this.COMP_POL_JOINT_LIFE_YN_LABEL = COMP_POL_JOINT_LIFE_YN_LABEL;
	}

	public void setCOMP_POL_JOINT_LIFE_YN(HtmlSelectOneMenu COMP_POL_JOINT_LIFE_YN) {
		this.COMP_POL_JOINT_LIFE_YN = COMP_POL_JOINT_LIFE_YN;
	}

	public HtmlOutputLabel getCOMP_POL_JOINT_LIFE_AGE_LABEL() {
		return COMP_POL_JOINT_LIFE_AGE_LABEL;
	}

	public HtmlInputText getCOMP_POL_JOINT_LIFE_AGE() {
		return COMP_POL_JOINT_LIFE_AGE;
	}

	public void setCOMP_POL_JOINT_LIFE_AGE_LABEL(HtmlOutputLabel COMP_POL_JOINT_LIFE_AGE_LABEL) {
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

	public void setCOMP_POL_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_POL_FRZ_FLAG_LABEL) {
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

	public void setCOMP_POL_ASSRD_REF_ID1_LABEL(HtmlOutputLabel COMP_POL_ASSRD_REF_ID1_LABEL) {
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

	public void setCOMP_POL_ASSRD_REF_ID2_LABEL(HtmlOutputLabel COMP_POL_ASSRD_REF_ID2_LABEL) {
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

	public void setCOMP_UI_M_MAT_AGE_LABEL(HtmlOutputLabel COMP_UI_M_MAT_AGE_LABEL) {
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

	public void setCOMP_UI_M_POL_CONVERT_YN(HtmlOutputLabel COMP_UI_M_POL_CONVERT_YN) {
		this.COMP_UI_M_POL_CONVERT_YN = COMP_UI_M_POL_CONVERT_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_SA1_LABEL() {
		return COMP_UI_M_POL_LC_SA1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_SA1() {
		return COMP_UI_M_POL_LC_SA1;
	}

	public void setCOMP_UI_M_POL_LC_SA1_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_SA1_LABEL) {
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

	public void setCOMP_POL_BASIC_RATE1_LABEL(HtmlOutputLabel COMP_POL_BASIC_RATE1_LABEL) {
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

	public void setCOMP_POL_LC_BASIC_PREM1_LABEL(HtmlOutputLabel COMP_POL_LC_BASIC_PREM1_LABEL) {
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

	public void setCOMP_POL_LC_ADDL_PREM1_LABEL(HtmlOutputLabel COMP_POL_LC_ADDL_PREM1_LABEL) {
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

	public void setCOMP_UI_M_POL_LC_TOT_PREM1_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_TOT_PREM1_LABEL) {
		this.COMP_UI_M_POL_LC_TOT_PREM1_LABEL = COMP_UI_M_POL_LC_TOT_PREM1_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_TOT_PREM1(HtmlInputText COMP_UI_M_POL_LC_TOT_PREM1) {
		this.COMP_UI_M_POL_LC_TOT_PREM1 = COMP_UI_M_POL_LC_TOT_PREM1;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_LOADING1_LABEL() {
		return COMP_UI_M_POL_LC_TOT_LOADING1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_TOT_LOADING1() {
		return COMP_UI_M_POL_LC_TOT_LOADING1;
	}

	public void setCOMP_UI_M_POL_LC_TOT_LOADING1_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_TOT_LOADING1_LABEL) {
		this.COMP_UI_M_POL_LC_TOT_LOADING1_LABEL = COMP_UI_M_POL_LC_TOT_LOADING1_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_TOT_LOADING1(HtmlInputText COMP_UI_M_POL_LC_TOT_LOADING1) {
		this.COMP_UI_M_POL_LC_TOT_LOADING1 = COMP_UI_M_POL_LC_TOT_LOADING1;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL() {
		return COMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_TOT_DISCOUNT1() {
		return COMP_UI_M_POL_LC_TOT_DISCOUNT1;
	}

	public void setCOMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL) {
		this.COMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL = COMP_UI_M_POL_LC_TOT_DISCOUNT1_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_TOT_DISCOUNT1(HtmlInputText COMP_UI_M_POL_LC_TOT_DISCOUNT1) {
		this.COMP_UI_M_POL_LC_TOT_DISCOUNT1 = COMP_UI_M_POL_LC_TOT_DISCOUNT1;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL() {
		return COMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_PCHARGES_BORNE_CUST1() {
		return COMP_UI_M_LC_PCHARGES_BORNE_CUST1;
	}

	public void setCOMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL(HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL) {
		this.COMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL = COMP_UI_M_LC_PCHARGES_BORNE_CUST1_LABEL;
	}

	public void setCOMP_UI_M_LC_PCHARGES_BORNE_CUST1(HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_CUST1) {
		this.COMP_UI_M_LC_PCHARGES_BORNE_CUST1 = COMP_UI_M_LC_PCHARGES_BORNE_CUST1;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_NET_PREM1_LABEL() {
		return COMP_UI_M_POL_LC_NET_PREM1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_NET_PREM1() {
		return COMP_UI_M_POL_LC_NET_PREM1;
	}

	public void setCOMP_UI_M_POL_LC_NET_PREM1_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_NET_PREM1_LABEL) {
		this.COMP_UI_M_POL_LC_NET_PREM1_LABEL = COMP_UI_M_POL_LC_NET_PREM1_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_NET_PREM1(HtmlInputText COMP_UI_M_POL_LC_NET_PREM1) {
		this.COMP_UI_M_POL_LC_NET_PREM1 = COMP_UI_M_POL_LC_NET_PREM1;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL() {
		return COMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_MODE_OF_PYMT_RATE1() {
		return COMP_UI_M_POL_MODE_OF_PYMT_RATE1;
	}

	public void setCOMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL(HtmlOutputLabel COMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL) {
		this.COMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL = COMP_UI_M_POL_MODE_OF_PYMT_RATE1_LABEL;
	}

	public void setCOMP_UI_M_POL_MODE_OF_PYMT_RATE1(HtmlInputText COMP_UI_M_POL_MODE_OF_PYMT_RATE1) {
		this.COMP_UI_M_POL_MODE_OF_PYMT_RATE1 = COMP_UI_M_POL_MODE_OF_PYMT_RATE1;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_MOP1_LABEL() {
		return COMP_UI_M_POL_LC_MOP1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_MOP1() {
		return COMP_UI_M_POL_LC_MOP1;
	}

	public void setCOMP_UI_M_POL_LC_MOP1_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_MOP1_LABEL) {
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

	public void setCOMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL) {
		this.COMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL = COMP_UI_M_POL_LC_GR_ANN_PREM1_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_GR_ANN_PREM1(HtmlInputText COMP_UI_M_POL_LC_GR_ANN_PREM1) {
		this.COMP_UI_M_POL_LC_GR_ANN_PREM1 = COMP_UI_M_POL_LC_GR_ANN_PREM1;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_INST_LC_PREM1_LABEL() {
		return COMP_UI_M_POL_INST_LC_PREM1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_INST_LC_PREM1() {
		return COMP_UI_M_POL_INST_LC_PREM1;
	}

	public void setCOMP_UI_M_POL_INST_LC_PREM1_LABEL(HtmlOutputLabel COMP_UI_M_POL_INST_LC_PREM1_LABEL) {
		this.COMP_UI_M_POL_INST_LC_PREM1_LABEL = COMP_UI_M_POL_INST_LC_PREM1_LABEL;
	}

	public void setCOMP_UI_M_POL_INST_LC_PREM1(HtmlInputText COMP_UI_M_POL_INST_LC_PREM1) {
		this.COMP_UI_M_POL_INST_LC_PREM1 = COMP_UI_M_POL_INST_LC_PREM1;
	}

	public HtmlOutputLabel getCOMP_POL_LC_DISC_AMT1_LABEL() {
		return COMP_POL_LC_DISC_AMT1_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_DISC_AMT1() {
		return COMP_POL_LC_DISC_AMT1;
	}

	public void setCOMP_POL_LC_DISC_AMT1_LABEL(HtmlOutputLabel COMP_POL_LC_DISC_AMT1_LABEL) {
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

	public void setCOMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL(HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL) {
		this.COMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL = COMP_UI_M_LC_SCHARGES_BORNE_CUST1_LABEL;
	}

	public void setCOMP_UI_M_LC_SCHARGES_BORNE_CUST1(HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_CUST1) {
		this.COMP_UI_M_LC_SCHARGES_BORNE_CUST1 = COMP_UI_M_LC_SCHARGES_BORNE_CUST1;
	}

	public HtmlOutputLabel getCOMP_POL_LC_FIRST_PREM1_LABEL() {
		return COMP_POL_LC_FIRST_PREM1_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_FIRST_PREM1() {
		return COMP_POL_LC_FIRST_PREM1;
	}

	public void setCOMP_POL_LC_FIRST_PREM1_LABEL(HtmlOutputLabel COMP_POL_LC_FIRST_PREM1_LABEL) {
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

	public void setCOMP_POL_RES_ADDRESS_1_LABEL(HtmlOutputLabel COMP_POL_RES_ADDRESS_1_LABEL) {
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

	public void setCOMP_POL_RES_ADDRESS_2_LABEL(HtmlOutputLabel COMP_POL_RES_ADDRESS_2_LABEL) {
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

	public void setCOMP_POL_RES_ADDRESS_3_LABEL(HtmlOutputLabel COMP_POL_RES_ADDRESS_3_LABEL) {
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

	public void setCOMP_POL_RES_AREA_CODE_LABEL(HtmlOutputLabel COMP_POL_RES_AREA_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL) {
		this.COMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL = COMP_UI_M_POL_RES_AREA_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_RES_AREA_CODE_DESC(HtmlInputText COMP_UI_M_POL_RES_AREA_CODE_DESC) {
		this.COMP_UI_M_POL_RES_AREA_CODE_DESC = COMP_UI_M_POL_RES_AREA_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_CITY_CODE_LABEL() {
		return COMP_POL_CITY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CITY_CODE() {
		return COMP_POL_CITY_CODE;
	}

	public void setCOMP_POL_CITY_CODE_LABEL(HtmlOutputLabel COMP_POL_CITY_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_CITY_NAME_LABEL(HtmlOutputLabel COMP_UI_M_POL_CITY_NAME_LABEL) {
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

	public void setCOMP_POL_STATE_CODE_LABEL(HtmlOutputLabel COMP_POL_STATE_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_STATE_NAME_LABEL(HtmlOutputLabel COMP_UI_M_POL_STATE_NAME_LABEL) {
		this.COMP_UI_M_POL_STATE_NAME_LABEL = COMP_UI_M_POL_STATE_NAME_LABEL;
	}

	public void setCOMP_UI_M_POL_STATE_NAME(HtmlInputText COMP_UI_M_POL_STATE_NAME) {
		this.COMP_UI_M_POL_STATE_NAME = COMP_UI_M_POL_STATE_NAME;
	}

	public HtmlOutputLabel getCOMP_POL_COUNT_CODE_LABEL() {
		return COMP_POL_COUNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_COUNT_CODE() {
		return COMP_POL_COUNT_CODE;
	}

	public void setCOMP_POL_COUNT_CODE_LABEL(HtmlOutputLabel COMP_POL_COUNT_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_COUNT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_POL_COUNT_NAME_LABEL) {
		this.COMP_UI_M_POL_COUNT_NAME_LABEL = COMP_UI_M_POL_COUNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_POL_COUNT_NAME(HtmlInputText COMP_UI_M_POL_COUNT_NAME) {
		this.COMP_UI_M_POL_COUNT_NAME = COMP_UI_M_POL_COUNT_NAME;
	}

	public HtmlOutputLabel getCOMP_POL_RES_PHONE_NO_LABEL() {
		return COMP_POL_RES_PHONE_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_RES_PHONE_NO() {
		return COMP_POL_RES_PHONE_NO;
	}

	public void setCOMP_POL_RES_PHONE_NO_LABEL(HtmlOutputLabel COMP_POL_RES_PHONE_NO_LABEL) {
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

	public void setCOMP_POL_MOBILE_NO_LABEL(HtmlOutputLabel COMP_POL_MOBILE_NO_LABEL) {
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

	public void setCOMP_POL_OFF_ADDRESS_1_LABEL(HtmlOutputLabel COMP_POL_OFF_ADDRESS_1_LABEL) {
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

	public void setCOMP_POL_OFF_ADDRESS_2_LABEL(HtmlOutputLabel COMP_POL_OFF_ADDRESS_2_LABEL) {
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

	public void setCOMP_POL_OFF_ADDRESS_3_LABEL(HtmlOutputLabel COMP_POL_OFF_ADDRESS_3_LABEL) {
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

	public void setCOMP_POL_OFF_AREA_CODE_LABEL(HtmlOutputLabel COMP_POL_OFF_AREA_CODE_LABEL) {
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

	public void setCOMP_UI_M_POSTAL_NAME_LABEL(HtmlOutputLabel COMP_UI_M_POSTAL_NAME_LABEL) {
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

	public void setCOMP_POL_OFF_PHONE_NO_LABEL(HtmlOutputLabel COMP_POL_OFF_PHONE_NO_LABEL) {
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

	public void setCOMP_POL_FAX_AREA_CODE_LABEL(HtmlOutputLabel COMP_POL_FAX_AREA_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_ADDL_STATUS_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL) {
		this.COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL = COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_ADDL_STATUS_DESC(HtmlInputText COMP_UI_M_POL_ADDL_STATUS_DESC) {
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

	public void setCOMP_POL_MASTER_POL_NO_LABEL(HtmlOutputLabel COMP_POL_MASTER_POL_NO_LABEL) {
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

	public void setCOMP_POL_PROFIT_RATE_LABEL(HtmlOutputLabel COMP_POL_PROFIT_RATE_LABEL) {
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

	public void setCOMP_POL_MODE_OF_CALC_LABEL(HtmlOutputLabel COMP_POL_MODE_OF_CALC_LABEL) {
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

	public void setCOMP_POL_CREDIT_INT_RATE_LABEL(HtmlOutputLabel COMP_POL_CREDIT_INT_RATE_LABEL) {
		this.COMP_POL_CREDIT_INT_RATE_LABEL = COMP_POL_CREDIT_INT_RATE_LABEL;
	}

	public void setCOMP_POL_CREDIT_INT_RATE(HtmlInputText COMP_POL_CREDIT_INT_RATE) {
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

	public void setCOMP_UI_M_POL_FC_SA_LABEL(HtmlOutputLabel COMP_UI_M_POL_FC_SA_LABEL) {
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

	public void setCOMP_UI_M_POL_LC_SA_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_SA_LABEL) {
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

	public void setCOMP_POL_HEALTH_RATE_LABEL(HtmlOutputLabel COMP_POL_HEALTH_RATE_LABEL) {
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

	public void setCOMP_POL_PROJECT_CODE_LABEL(HtmlOutputLabel COMP_POL_PROJECT_CODE_LABEL) {
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

	public void setCOMP_UI_M_PROJECT_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PROJECT_CODE_DESC_LABEL) {
		this.COMP_UI_M_PROJECT_CODE_DESC_LABEL = COMP_UI_M_PROJECT_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROJECT_CODE_DESC(HtmlInputText COMP_UI_M_PROJECT_CODE_DESC) {
		this.COMP_UI_M_PROJECT_CODE_DESC = COMP_UI_M_PROJECT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_DEVELOPER_CODE_LABEL() {
		return COMP_POL_DEVELOPER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_DEVELOPER_CODE() {
		return COMP_POL_DEVELOPER_CODE;
	}

	public void setCOMP_POL_DEVELOPER_CODE_LABEL(HtmlOutputLabel COMP_POL_DEVELOPER_CODE_LABEL) {
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

	public void setCOMP_UI_M_DEVELOPER_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_DEVELOPER_CODE_DESC_LABEL) {
		this.COMP_UI_M_DEVELOPER_CODE_DESC_LABEL = COMP_UI_M_DEVELOPER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEVELOPER_CODE_DESC(HtmlInputText COMP_UI_M_DEVELOPER_CODE_DESC) {
		this.COMP_UI_M_DEVELOPER_CODE_DESC = COMP_UI_M_DEVELOPER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_PYMT_TYPE_LABEL() {
		return COMP_POL_PYMT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_PYMT_TYPE() {
		return COMP_POL_PYMT_TYPE;
	}

	public void setCOMP_POL_PYMT_TYPE_LABEL(HtmlOutputLabel COMP_POL_PYMT_TYPE_LABEL) {
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

	public void setCOMP_POL_PAYOR_SDCODE_LABEL(HtmlOutputLabel COMP_POL_PAYOR_SDCODE_LABEL) {
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

	public void setCOMP_UI_M_PAYOR_CONT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_PAYOR_CONT_NAME_LABEL) {
		this.COMP_UI_M_PAYOR_CONT_NAME_LABEL = COMP_UI_M_PAYOR_CONT_NAME_LABEL;
	}

	public void setCOMP_UI_M_PAYOR_CONT_NAME(HtmlInputText COMP_UI_M_PAYOR_CONT_NAME) {
		this.COMP_UI_M_PAYOR_CONT_NAME = COMP_UI_M_PAYOR_CONT_NAME;
	}

	public HtmlOutputLabel getCOMP_POL_CUST_CODE_LABEL() {
		return COMP_POL_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CUST_CODE() {
		return COMP_POL_CUST_CODE;
	}

	public void setCOMP_POL_CUST_CODE_LABEL(HtmlOutputLabel COMP_POL_CUST_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_CUST_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_CUST_DESC_LABEL) {
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

	public void setCOMP_POL_BASIC_RATE_LABEL(HtmlOutputLabel COMP_POL_BASIC_RATE_LABEL) {
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

	public void setCOMP_POL_FC_BASIC_PREM_LABEL(HtmlOutputLabel COMP_POL_FC_BASIC_PREM_LABEL) {
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

	public void setCOMP_POL_LC_BASIC_PREM_LABEL(HtmlOutputLabel COMP_POL_LC_BASIC_PREM_LABEL) {
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

	public void setCOMP_POL_FC_HEALTH_LOAD_LABEL(HtmlOutputLabel COMP_POL_FC_HEALTH_LOAD_LABEL) {
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

	public void setCOMP_POL_LC_HEALTH_LOAD_LABEL(HtmlOutputLabel COMP_POL_LC_HEALTH_LOAD_LABEL) {
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

	public void setCOMP_POL_HOME_OWNER_FLAG_LABEL(HtmlOutputLabel COMP_POL_HOME_OWNER_FLAG_LABEL) {
		this.COMP_POL_HOME_OWNER_FLAG_LABEL = COMP_POL_HOME_OWNER_FLAG_LABEL;
	}

	public void setCOMP_POL_HOME_OWNER_FLAG(HtmlSelectOneMenu COMP_POL_HOME_OWNER_FLAG) {
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

	public void setCOMP_UI_M_CONT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_CONT_NAME_LABEL) {
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

	public void setCOMP_POL_DEFER_PRD_LABEL(HtmlOutputLabel COMP_POL_DEFER_PRD_LABEL) {
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

	public void setCOMP_POL_EMPLOYER_CODE_LABEL(HtmlOutputLabel COMP_POL_EMPLOYER_CODE_LABEL) {
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

	public void setCOMP_POL_SRC_OF_BUS_LABEL(HtmlOutputLabel COMP_POL_SRC_OF_BUS_LABEL) {
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

	public void setCOMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL) {
		this.COMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL = COMP_UI_M_POL_SRC_OF_BUS_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_SRC_OF_BUS_DESC(HtmlInputText COMP_UI_M_POL_SRC_OF_BUS_DESC) {
		this.COMP_UI_M_POL_SRC_OF_BUS_DESC = COMP_UI_M_POL_SRC_OF_BUS_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_FC_ADDL_PREM_LABEL() {
		return COMP_POL_FC_ADDL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_FC_ADDL_PREM() {
		return COMP_POL_FC_ADDL_PREM;
	}

	public void setCOMP_POL_FC_ADDL_PREM_LABEL(HtmlOutputLabel COMP_POL_FC_ADDL_PREM_LABEL) {
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

	public void setCOMP_POL_LC_ADDL_PREM_LABEL(HtmlOutputLabel COMP_POL_LC_ADDL_PREM_LABEL) {
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

	public void setCOMP_POL_FC_TOT_SA_LABEL(HtmlOutputLabel COMP_POL_FC_TOT_SA_LABEL) {
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

	public void setCOMP_POL_LC_TOT_SA_LABEL(HtmlOutputLabel COMP_POL_LC_TOT_SA_LABEL) {
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

	public void setCOMP_POL_PROP_RECV_DT_LABEL(HtmlOutputLabel COMP_POL_PROP_RECV_DT_LABEL) {
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

	public void setCOMP_UI_M_FC_DEATH_LOAD_LABEL(HtmlOutputLabel COMP_UI_M_FC_DEATH_LOAD_LABEL) {
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

	public void setCOMP_UI_M_LC_DEATH_LOAD_LABEL(HtmlOutputLabel COMP_UI_M_LC_DEATH_LOAD_LABEL) {
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

	public void setCOMP_POL_INCORPORATED_YN_LABEL(HtmlOutputLabel COMP_POL_INCORPORATED_YN_LABEL) {
		this.COMP_POL_INCORPORATED_YN_LABEL = COMP_POL_INCORPORATED_YN_LABEL;
	}

	public void setCOMP_POL_INCORPORATED_YN(HtmlSelectOneMenu COMP_POL_INCORPORATED_YN) {
		this.COMP_POL_INCORPORATED_YN = COMP_POL_INCORPORATED_YN;
	}

	public HtmlOutputLabel getCOMP_POL_SUB_PLAN_CODE_LABEL() {
		return COMP_POL_SUB_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_SUB_PLAN_CODE() {
		return COMP_POL_SUB_PLAN_CODE;
	}

	public void setCOMP_POL_SUB_PLAN_CODE_LABEL(HtmlOutputLabel COMP_POL_SUB_PLAN_CODE_LABEL) {
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

	public void setCOMP_POL_NET_PREM_YN_LABEL(HtmlOutputLabel COMP_POL_NET_PREM_YN_LABEL) {
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

	public void setCOMP_POL_CONT_CODE_LABEL(HtmlOutputLabel COMP_POL_CONT_CODE_LABEL) {
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

	public void setCOMP_POL_ASSURED_NAME_LABEL(HtmlOutputLabel COMP_POL_ASSURED_NAME_LABEL) {
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

	public void setCOMP_UI_M_POL_FC_TOT_PREM_LABEL(HtmlOutputLabel COMP_UI_M_POL_FC_TOT_PREM_LABEL) {
		this.COMP_UI_M_POL_FC_TOT_PREM_LABEL = COMP_UI_M_POL_FC_TOT_PREM_LABEL;
	}

	public void setCOMP_UI_M_POL_FC_TOT_PREM(HtmlInputText COMP_UI_M_POL_FC_TOT_PREM) {
		this.COMP_UI_M_POL_FC_TOT_PREM = COMP_UI_M_POL_FC_TOT_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_PREM_LABEL() {
		return COMP_UI_M_POL_LC_TOT_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_TOT_PREM() {
		return COMP_UI_M_POL_LC_TOT_PREM;
	}

	public void setCOMP_UI_M_POL_LC_TOT_PREM_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_TOT_PREM_LABEL) {
		this.COMP_UI_M_POL_LC_TOT_PREM_LABEL = COMP_UI_M_POL_LC_TOT_PREM_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_TOT_PREM(HtmlInputText COMP_UI_M_POL_LC_TOT_PREM) {
		this.COMP_UI_M_POL_LC_TOT_PREM = COMP_UI_M_POL_LC_TOT_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_FC_PREM_LABEL() {
		return COMP_UI_M_POL_FC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_FC_PREM() {
		return COMP_UI_M_POL_FC_PREM;
	}

	public void setCOMP_UI_M_POL_FC_PREM_LABEL(HtmlOutputLabel COMP_UI_M_POL_FC_PREM_LABEL) {
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

	public void setCOMP_UI_M_POL_LC_PREM_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_PREM_LABEL) {
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

	public void setCOMP_POL_PROP_STAMP_DT_LABEL(HtmlOutputLabel COMP_POL_PROP_STAMP_DT_LABEL) {
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

	public void setCOMP_UI_M_FC_TPD_LOAD_LABEL(HtmlOutputLabel COMP_UI_M_FC_TPD_LOAD_LABEL) {
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

	public void setCOMP_UI_M_LC_TPD_LOAD_LABEL(HtmlOutputLabel COMP_UI_M_LC_TPD_LOAD_LABEL) {
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

	public void setCOMP_POL_GRANTEE_NAME_LABEL(HtmlOutputLabel COMP_POL_GRANTEE_NAME_LABEL) {
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

	public void setCOMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL) {
		this.COMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL = COMP_UI_M_POL_SUB_PLAN_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_SUB_PLAN_CODE_DESC(HtmlInputText COMP_UI_M_POL_SUB_PLAN_CODE_DESC) {
		this.COMP_UI_M_POL_SUB_PLAN_CODE_DESC = COMP_UI_M_POL_SUB_PLAN_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_GRANTEE_TYPE_LABEL() {
		return COMP_POL_GRANTEE_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_GRANTEE_TYPE() {
		return COMP_POL_GRANTEE_TYPE;
	}

	public void setCOMP_POL_GRANTEE_TYPE_LABEL(HtmlOutputLabel COMP_POL_GRANTEE_TYPE_LABEL) {
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

	public void setCOMP_POL_PREM_PAY_YRS_LABEL(HtmlOutputLabel COMP_POL_PREM_PAY_YRS_LABEL) {
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

	public void setCOMP_POL_FC_NETT_PREM_LABEL(HtmlOutputLabel COMP_POL_FC_NETT_PREM_LABEL) {
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

	public void setCOMP_POL_LC_NETT_PREM_LABEL(HtmlOutputLabel COMP_POL_LC_NETT_PREM_LABEL) {
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

	public void setCOMP_UI_M_POL_FC_TOT_LOADING_LABEL(HtmlOutputLabel COMP_UI_M_POL_FC_TOT_LOADING_LABEL) {
		this.COMP_UI_M_POL_FC_TOT_LOADING_LABEL = COMP_UI_M_POL_FC_TOT_LOADING_LABEL;
	}

	public void setCOMP_UI_M_POL_FC_TOT_LOADING(HtmlInputText COMP_UI_M_POL_FC_TOT_LOADING) {
		this.COMP_UI_M_POL_FC_TOT_LOADING = COMP_UI_M_POL_FC_TOT_LOADING;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_LOADING_LABEL() {
		return COMP_UI_M_POL_LC_TOT_LOADING_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_TOT_LOADING() {
		return COMP_UI_M_POL_LC_TOT_LOADING;
	}

	public void setCOMP_UI_M_POL_LC_TOT_LOADING_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_TOT_LOADING_LABEL) {
		this.COMP_UI_M_POL_LC_TOT_LOADING_LABEL = COMP_UI_M_POL_LC_TOT_LOADING_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_TOT_LOADING(HtmlInputText COMP_UI_M_POL_LC_TOT_LOADING) {
		this.COMP_UI_M_POL_LC_TOT_LOADING = COMP_UI_M_POL_LC_TOT_LOADING;
	}

	public HtmlOutputLabel getCOMP_POL_PROP_DECL_DT_LABEL() {
		return COMP_POL_PROP_DECL_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_PROP_DECL_DT() {
		return COMP_POL_PROP_DECL_DT;
	}

	public void setCOMP_POL_PROP_DECL_DT_LABEL(HtmlOutputLabel COMP_POL_PROP_DECL_DT_LABEL) {
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

	public void setCOMP_UI_M_FC_MED_LOAD_LABEL(HtmlOutputLabel COMP_UI_M_FC_MED_LOAD_LABEL) {
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

	public void setCOMP_UI_M_LC_MED_LOAD_LABEL(HtmlOutputLabel COMP_UI_M_LC_MED_LOAD_LABEL) {
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

	public void setCOMP_POL_LC_TOP_UP_AMT_LABEL(HtmlOutputLabel COMP_POL_LC_TOP_UP_AMT_LABEL) {
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

	public void setCOMP_POL_INTRODUCER_REF_ID1_LABEL(HtmlOutputLabel COMP_POL_INTRODUCER_REF_ID1_LABEL) {
		this.COMP_POL_INTRODUCER_REF_ID1_LABEL = COMP_POL_INTRODUCER_REF_ID1_LABEL;
	}

	public void setCOMP_POL_INTRODUCER_REF_ID1(HtmlInputText COMP_POL_INTRODUCER_REF_ID1) {
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

	public void setCOMP_UI_M_POL_INTRODUCER_REF_ID1_DESC(HtmlInputText COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC) {
		this.COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC = COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_BANK_BRANCH_NAME_LABEL() {
		return COMP_POL_BANK_BRANCH_NAME_LABEL;
	}

	public HtmlInputText getCOMP_POL_BANK_BRANCH_NAME() {
		return COMP_POL_BANK_BRANCH_NAME;
	}

	public void setCOMP_POL_BANK_BRANCH_NAME_LABEL(HtmlOutputLabel COMP_POL_BANK_BRANCH_NAME_LABEL) {
		this.COMP_POL_BANK_BRANCH_NAME_LABEL = COMP_POL_BANK_BRANCH_NAME_LABEL;
	}

	public void setCOMP_POL_BANK_BRANCH_NAME(HtmlInputText COMP_POL_BANK_BRANCH_NAME) {
		this.COMP_POL_BANK_BRANCH_NAME = COMP_POL_BANK_BRANCH_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_BRANCH_CODE_DESC_LABEL() {
		return COMP_UI_M_BRANCH_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BRANCH_CODE_DESC() {
		return COMP_UI_M_BRANCH_CODE_DESC;
	}

	public void setCOMP_UI_M_BRANCH_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_BRANCH_CODE_DESC_LABEL) {
		this.COMP_UI_M_BRANCH_CODE_DESC_LABEL = COMP_UI_M_BRANCH_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_BRANCH_CODE_DESC(HtmlInputText COMP_UI_M_BRANCH_CODE_DESC) {
		this.COMP_UI_M_BRANCH_CODE_DESC = COMP_UI_M_BRANCH_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_START_DT_LABEL() {
		return COMP_POL_START_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_START_DT() {
		return COMP_POL_START_DT;
	}

	public void setCOMP_POL_START_DT_LABEL(HtmlOutputLabel COMP_POL_START_DT_LABEL) {
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

	public void setCOMP_POL_EXPIRY_DT_LABEL(HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL) {
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

	public void setCOMP_POL_DIVN_CODE_LABEL(HtmlOutputLabel COMP_POL_DIVN_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL(HtmlOutputLabel COMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL) {
		this.COMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL = COMP_UI_M_POL_FC_TOT_DISCOUNT_LABEL;
	}

	public void setCOMP_UI_M_POL_FC_TOT_DISCOUNT(HtmlInputText COMP_UI_M_POL_FC_TOT_DISCOUNT) {
		this.COMP_UI_M_POL_FC_TOT_DISCOUNT = COMP_UI_M_POL_FC_TOT_DISCOUNT;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL() {
		return COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_TOT_DISCOUNT() {
		return COMP_UI_M_POL_LC_TOT_DISCOUNT;
	}

	public void setCOMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL) {
		this.COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL = COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_TOT_DISCOUNT(HtmlInputText COMP_UI_M_POL_LC_TOT_DISCOUNT) {
		this.COMP_UI_M_POL_LC_TOT_DISCOUNT = COMP_UI_M_POL_LC_TOT_DISCOUNT;
	}

	public HtmlOutputLabel getCOMP_POL_FC_CURR_SA_LABEL() {
		return COMP_POL_FC_CURR_SA_LABEL;
	}

	public HtmlInputText getCOMP_POL_FC_CURR_SA() {
		return COMP_POL_FC_CURR_SA;
	}

	public void setCOMP_POL_FC_CURR_SA_LABEL(HtmlOutputLabel COMP_POL_FC_CURR_SA_LABEL) {
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

	public void setCOMP_POL_LC_CURR_SA_LABEL(HtmlOutputLabel COMP_POL_LC_CURR_SA_LABEL) {
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

	public void setCOMP_POL_FC_TOP_UP_AMT_LABEL(HtmlOutputLabel COMP_POL_FC_TOP_UP_AMT_LABEL) {
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

	public void setCOMP_UI_M_FC_OCC_LOAD_LABEL(HtmlOutputLabel COMP_UI_M_FC_OCC_LOAD_LABEL) {
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

	public void setCOMP_UI_M_LC_OCC_LOAD_LABEL(HtmlOutputLabel COMP_UI_M_LC_OCC_LOAD_LABEL) {
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

	public void setCOMP_POL_RATE_APPLIED_ON_LABEL(HtmlOutputLabel COMP_POL_RATE_APPLIED_ON_LABEL) {
		this.COMP_POL_RATE_APPLIED_ON_LABEL = COMP_POL_RATE_APPLIED_ON_LABEL;
	}

	public void setCOMP_POL_RATE_APPLIED_ON(HtmlSelectOneMenu COMP_POL_RATE_APPLIED_ON) {
		this.COMP_POL_RATE_APPLIED_ON = COMP_POL_RATE_APPLIED_ON;
	}

	public HtmlOutputLabel getCOMP_POL_BANK_REF_NO_LABEL() {
		return COMP_POL_BANK_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_BANK_REF_NO() {
		return COMP_POL_BANK_REF_NO;
	}

	public void setCOMP_POL_BANK_REF_NO_LABEL(HtmlOutputLabel COMP_POL_BANK_REF_NO_LABEL) {
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

	public void setCOMP_POL_SA_CURR_CODE_LABEL(HtmlOutputLabel COMP_POL_SA_CURR_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_SA_CURR_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_SA_CURR_DESC_LABEL) {
		this.COMP_UI_M_POL_SA_CURR_DESC_LABEL = COMP_UI_M_POL_SA_CURR_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_SA_CURR_DESC(HtmlInputText COMP_UI_M_POL_SA_CURR_DESC) {
		this.COMP_UI_M_POL_SA_CURR_DESC = COMP_UI_M_POL_SA_CURR_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_SA_EXCH_RATE_LABEL() {
		return COMP_POL_SA_EXCH_RATE_LABEL;
	}

	public HtmlInputText getCOMP_POL_SA_EXCH_RATE() {
		return COMP_POL_SA_EXCH_RATE;
	}

	public void setCOMP_POL_SA_EXCH_RATE_LABEL(HtmlOutputLabel COMP_POL_SA_EXCH_RATE_LABEL) {
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

	public void setCOMP_UI_M_POL_DIVN_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_DIVN_DESC_LABEL) {
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

	public void setCOMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL(HtmlOutputLabel COMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL) {
		this.COMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL = COMP_UI_M_FC_PCHARGES_BORNE_CUST_LABEL;
	}

	public void setCOMP_UI_M_FC_PCHARGES_BORNE_CUST(HtmlInputText COMP_UI_M_FC_PCHARGES_BORNE_CUST) {
		this.COMP_UI_M_FC_PCHARGES_BORNE_CUST = COMP_UI_M_FC_PCHARGES_BORNE_CUST;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL() {
		return COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_PCHARGES_BORNE_CUST() {
		return COMP_UI_M_LC_PCHARGES_BORNE_CUST;
	}

	public void setCOMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL(HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL) {
		this.COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL = COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL;
	}

	public void setCOMP_UI_M_LC_PCHARGES_BORNE_CUST(HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_CUST) {
		this.COMP_UI_M_LC_PCHARGES_BORNE_CUST = COMP_UI_M_LC_PCHARGES_BORNE_CUST;
	}

	public HtmlOutputLabel getCOMP_POL_ORG_PROP_RECV_YN_LABEL() {
		return COMP_POL_ORG_PROP_RECV_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_ORG_PROP_RECV_YN() {
		return COMP_POL_ORG_PROP_RECV_YN;
	}

	public void setCOMP_POL_ORG_PROP_RECV_YN_LABEL(HtmlOutputLabel COMP_POL_ORG_PROP_RECV_YN_LABEL) {
		this.COMP_POL_ORG_PROP_RECV_YN_LABEL = COMP_POL_ORG_PROP_RECV_YN_LABEL;
	}

	public void setCOMP_POL_ORG_PROP_RECV_YN(HtmlSelectOneMenu COMP_POL_ORG_PROP_RECV_YN) {
		this.COMP_POL_ORG_PROP_RECV_YN = COMP_POL_ORG_PROP_RECV_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_GROSS_CONT_LABEL() {
		return COMP_UI_M_FC_GROSS_CONT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_GROSS_CONT() {
		return COMP_UI_M_FC_GROSS_CONT;
	}

	public void setCOMP_UI_M_FC_GROSS_CONT_LABEL(HtmlOutputLabel COMP_UI_M_FC_GROSS_CONT_LABEL) {
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

	public void setCOMP_UI_M_LC_GROSS_CONT_LABEL(HtmlOutputLabel COMP_UI_M_LC_GROSS_CONT_LABEL) {
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

	public void setCOMP_POL_LC_EXC_INT_AMT_LABEL(HtmlOutputLabel COMP_POL_LC_EXC_INT_AMT_LABEL) {
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

	public void setCOMP_POL_NL_FM_DT_LABEL(HtmlOutputLabel COMP_POL_NL_FM_DT_LABEL) {
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

	public void setCOMP_POL_TARIFF_TERM_FLAG_LABEL(HtmlOutputLabel COMP_POL_TARIFF_TERM_FLAG_LABEL) {
		this.COMP_POL_TARIFF_TERM_FLAG_LABEL = COMP_POL_TARIFF_TERM_FLAG_LABEL;
	}

	public void setCOMP_POL_TARIFF_TERM_FLAG(HtmlSelectOneMenu COMP_POL_TARIFF_TERM_FLAG) {
		this.COMP_POL_TARIFF_TERM_FLAG = COMP_POL_TARIFF_TERM_FLAG;
	}

	public HtmlOutputLabel getCOMP_POL_CUST_CURR_CODE_LABEL() {
		return COMP_POL_CUST_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CUST_CURR_CODE() {
		return COMP_POL_CUST_CURR_CODE;
	}

	public void setCOMP_POL_CUST_CURR_CODE_LABEL(HtmlOutputLabel COMP_POL_CUST_CURR_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_CUST_CURR_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_CUST_CURR_DESC_LABEL) {
		this.COMP_UI_M_POL_CUST_CURR_DESC_LABEL = COMP_UI_M_POL_CUST_CURR_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_CUST_CURR_DESC(HtmlInputText COMP_UI_M_POL_CUST_CURR_DESC) {
		this.COMP_UI_M_POL_CUST_CURR_DESC = COMP_UI_M_POL_CUST_CURR_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_CUST_EXCH_RATE_LABEL() {
		return COMP_POL_CUST_EXCH_RATE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CUST_EXCH_RATE() {
		return COMP_POL_CUST_EXCH_RATE;
	}

	public void setCOMP_POL_CUST_EXCH_RATE_LABEL(HtmlOutputLabel COMP_POL_CUST_EXCH_RATE_LABEL) {
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

	public void setCOMP_POL_DEPT_CODE_LABEL(HtmlOutputLabel COMP_POL_DEPT_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_FC_NET_PREM_LABEL(HtmlOutputLabel COMP_UI_M_POL_FC_NET_PREM_LABEL) {
		this.COMP_UI_M_POL_FC_NET_PREM_LABEL = COMP_UI_M_POL_FC_NET_PREM_LABEL;
	}

	public void setCOMP_UI_M_POL_FC_NET_PREM(HtmlInputText COMP_UI_M_POL_FC_NET_PREM) {
		this.COMP_UI_M_POL_FC_NET_PREM = COMP_UI_M_POL_FC_NET_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_NET_PREM_LABEL() {
		return COMP_UI_M_POL_LC_NET_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_NET_PREM() {
		return COMP_UI_M_POL_LC_NET_PREM;
	}

	public void setCOMP_UI_M_POL_LC_NET_PREM_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_NET_PREM_LABEL) {
		this.COMP_UI_M_POL_LC_NET_PREM_LABEL = COMP_UI_M_POL_LC_NET_PREM_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_NET_PREM(HtmlInputText COMP_UI_M_POL_LC_NET_PREM) {
		this.COMP_UI_M_POL_LC_NET_PREM = COMP_UI_M_POL_LC_NET_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_BROK_COMM_LABEL() {
		return COMP_UI_M_FC_BROK_COMM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_BROK_COMM() {
		return COMP_UI_M_FC_BROK_COMM;
	}

	public void setCOMP_UI_M_FC_BROK_COMM_LABEL(HtmlOutputLabel COMP_UI_M_FC_BROK_COMM_LABEL) {
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

	public void setCOMP_UI_M_LC_BROK_COMM_LABEL(HtmlOutputLabel COMP_UI_M_LC_BROK_COMM_LABEL) {
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

	public void setCOMP_POL_EXC_INT_PERC_LABEL(HtmlOutputLabel COMP_POL_EXC_INT_PERC_LABEL) {
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

	public void setCOMP_POL_STAFF_CCLASS_CODE_LABEL(HtmlOutputLabel COMP_POL_STAFF_CCLASS_CODE_LABEL) {
		this.COMP_POL_STAFF_CCLASS_CODE_LABEL = COMP_POL_STAFF_CCLASS_CODE_LABEL;
	}

	public void setCOMP_POL_STAFF_CCLASS_CODE(HtmlInputText COMP_POL_STAFF_CCLASS_CODE) {
		this.COMP_POL_STAFF_CCLASS_CODE = COMP_POL_STAFF_CCLASS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CCLAS_CLASS_DESC_LABEL() {
		return COMP_UI_M_CCLAS_CLASS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CCLAS_CLASS_DESC() {
		return COMP_UI_M_CCLAS_CLASS_DESC;
	}

	public void setCOMP_UI_M_CCLAS_CLASS_DESC_LABEL(HtmlOutputLabel COMP_UI_M_CCLAS_CLASS_DESC_LABEL) {
		this.COMP_UI_M_CCLAS_CLASS_DESC_LABEL = COMP_UI_M_CCLAS_CLASS_DESC_LABEL;
	}

	public void setCOMP_UI_M_CCLAS_CLASS_DESC(HtmlInputText COMP_UI_M_CCLAS_CLASS_DESC) {
		this.COMP_UI_M_CCLAS_CLASS_DESC = COMP_UI_M_CCLAS_CLASS_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_STD_RISK_YN_LABEL() {
		return COMP_POL_STD_RISK_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_STD_RISK_YN() {
		return COMP_POL_STD_RISK_YN;
	}

	public void setCOMP_POL_STD_RISK_YN_LABEL(HtmlOutputLabel COMP_POL_STD_RISK_YN_LABEL) {
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

	public void setCOMP_POL_FC_EXC_INT_AMT_LABEL(HtmlOutputLabel COMP_POL_FC_EXC_INT_AMT_LABEL) {
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

	public void setCOMP_POL_FC_MODAL_PREM_LABEL(HtmlOutputLabel COMP_POL_FC_MODAL_PREM_LABEL) {
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

	public void setCOMP_POL_NO_OF_UNIT_LABEL(HtmlOutputLabel COMP_POL_NO_OF_UNIT_LABEL) {
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

	public void setCOMP_POL_LC_MODAL_PREM_LABEL(HtmlOutputLabel COMP_POL_LC_MODAL_PREM_LABEL) {
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

	public void setCOMP_UI_M_POL_DEPT_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_DEPT_DESC_LABEL) {
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

	public void setCOMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL(HtmlOutputLabel COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL) {
		this.COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL = COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL;
	}

	public void setCOMP_UI_M_POL_MODE_OF_PYMT_RATE(HtmlInputText COMP_UI_M_POL_MODE_OF_PYMT_RATE) {
		this.COMP_UI_M_POL_MODE_OF_PYMT_RATE = COMP_UI_M_POL_MODE_OF_PYMT_RATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_FC_MOP_LABEL() {
		return COMP_UI_M_POL_FC_MOP_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_FC_MOP() {
		return COMP_UI_M_POL_FC_MOP;
	}

	public void setCOMP_UI_M_POL_FC_MOP_LABEL(HtmlOutputLabel COMP_UI_M_POL_FC_MOP_LABEL) {
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

	public void setCOMP_UI_M_POL_LC_MOP_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_MOP_LABEL) {
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

	public void setCOMP_UI_M_FC_CHARGE_LABEL(HtmlOutputLabel COMP_UI_M_FC_CHARGE_LABEL) {
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

	public void setCOMP_UI_M_LC_CHARGE_LABEL(HtmlOutputLabel COMP_UI_M_LC_CHARGE_LABEL) {
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

	public void setCOMP_POL_RI_POOL_CODE_LABEL(HtmlOutputLabel COMP_POL_RI_POOL_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL) {
		this.COMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL = COMP_UI_M_POL_RI_POOL_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_RI_POOL_CODE_DESC(HtmlInputText COMP_UI_M_POL_RI_POOL_CODE_DESC) {
		this.COMP_UI_M_POL_RI_POOL_CODE_DESC = COMP_UI_M_POL_RI_POOL_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_CREDIT_YN_LABEL() {
		return COMP_POL_CREDIT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_CREDIT_YN() {
		return COMP_POL_CREDIT_YN;
	}

	public void setCOMP_POL_CREDIT_YN_LABEL(HtmlOutputLabel COMP_POL_CREDIT_YN_LABEL) {
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

	public void setCOMP_POL_LOAD_PERC_LABEL(HtmlOutputLabel COMP_POL_LOAD_PERC_LABEL) {
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

	public void setCOMP_POL_STAFF_YN_LABEL(HtmlOutputLabel COMP_POL_STAFF_YN_LABEL) {
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

	public void setCOMP_POL_FAC_BASIS_LABEL(HtmlOutputLabel COMP_POL_FAC_BASIS_LABEL) {
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

	public void setCOMP_POL_MODE_OF_PYMT_LABEL(HtmlOutputLabel COMP_POL_MODE_OF_PYMT_LABEL) {
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

	public void setCOMP_POL_NO_OF_INST_LABEL(HtmlOutputLabel COMP_POL_NO_OF_INST_LABEL) {
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

	public void setCOMP_POL_MODE_OF_PYMT_RATE_LABEL(HtmlOutputLabel COMP_POL_MODE_OF_PYMT_RATE_LABEL) {
		this.COMP_POL_MODE_OF_PYMT_RATE_LABEL = COMP_POL_MODE_OF_PYMT_RATE_LABEL;
	}

	public void setCOMP_POL_MODE_OF_PYMT_RATE(HtmlInputText COMP_POL_MODE_OF_PYMT_RATE) {
		this.COMP_POL_MODE_OF_PYMT_RATE = COMP_POL_MODE_OF_PYMT_RATE;
	}

	public HtmlOutputLabel getCOMP_POL_CLASS_CODE_LABEL() {
		return COMP_POL_CLASS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CLASS_CODE() {
		return COMP_POL_CLASS_CODE;
	}

	public void setCOMP_POL_CLASS_CODE_LABEL(HtmlOutputLabel COMP_POL_CLASS_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_FC_GR_ANN_PREM_LABEL(HtmlOutputLabel COMP_UI_M_POL_FC_GR_ANN_PREM_LABEL) {
		this.COMP_UI_M_POL_FC_GR_ANN_PREM_LABEL = COMP_UI_M_POL_FC_GR_ANN_PREM_LABEL;
	}

	public void setCOMP_UI_M_POL_FC_GR_ANN_PREM(HtmlInputText COMP_UI_M_POL_FC_GR_ANN_PREM) {
		this.COMP_UI_M_POL_FC_GR_ANN_PREM = COMP_UI_M_POL_FC_GR_ANN_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_GR_ANN_PREM_LABEL() {
		return COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_GR_ANN_PREM() {
		return COMP_UI_M_POL_LC_GR_ANN_PREM;
	}

	public void setCOMP_UI_M_POL_LC_GR_ANN_PREM_LABEL(HtmlOutputLabel COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL) {
		this.COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL = COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_GR_ANN_PREM(HtmlInputText COMP_UI_M_POL_LC_GR_ANN_PREM) {
		this.COMP_UI_M_POL_LC_GR_ANN_PREM = COMP_UI_M_POL_LC_GR_ANN_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL() {
		return COMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_PCHARGES_BORNE_COMP() {
		return COMP_UI_M_FC_PCHARGES_BORNE_COMP;
	}

	public void setCOMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL(HtmlOutputLabel COMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL) {
		this.COMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL = COMP_UI_M_FC_PCHARGES_BORNE_COMP_LABEL;
	}

	public void setCOMP_UI_M_FC_PCHARGES_BORNE_COMP(HtmlInputText COMP_UI_M_FC_PCHARGES_BORNE_COMP) {
		this.COMP_UI_M_FC_PCHARGES_BORNE_COMP = COMP_UI_M_FC_PCHARGES_BORNE_COMP;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL() {
		return COMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_PCHARGES_BORNE_COMP() {
		return COMP_UI_M_LC_PCHARGES_BORNE_COMP;
	}

	public void setCOMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL(HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL) {
		this.COMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL = COMP_UI_M_LC_PCHARGES_BORNE_COMP_LABEL;
	}

	public void setCOMP_UI_M_LC_PCHARGES_BORNE_COMP(HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_COMP) {
		this.COMP_UI_M_LC_PCHARGES_BORNE_COMP = COMP_UI_M_LC_PCHARGES_BORNE_COMP;
	}

	public HtmlOutputLabel getCOMP_POL_FC_NET_PREM_LABEL() {
		return COMP_POL_FC_NET_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_FC_NET_PREM() {
		return COMP_POL_FC_NET_PREM;
	}

	public void setCOMP_POL_FC_NET_PREM_LABEL(HtmlOutputLabel COMP_POL_FC_NET_PREM_LABEL) {
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

	public void setCOMP_POL_LC_NET_PREM_LABEL(HtmlOutputLabel COMP_POL_LC_NET_PREM_LABEL) {
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

	public void setCOMP_UI_M_FC_INST_PREM_LABEL(HtmlOutputLabel COMP_UI_M_FC_INST_PREM_LABEL) {
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

	public void setCOMP_UI_M_LC_INST_PREM_LABEL(HtmlOutputLabel COMP_UI_M_LC_INST_PREM_LABEL) {
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

	public void setCOMP_POL_CQS_PERC_LABEL(HtmlOutputLabel COMP_POL_CQS_PERC_LABEL) {
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

	public void setCOMP_POL_CREDIT_DISCOUNT_PERC_LABEL(HtmlOutputLabel COMP_POL_CREDIT_DISCOUNT_PERC_LABEL) {
		this.COMP_POL_CREDIT_DISCOUNT_PERC_LABEL = COMP_POL_CREDIT_DISCOUNT_PERC_LABEL;
	}

	public void setCOMP_POL_CREDIT_DISCOUNT_PERC(HtmlInputText COMP_POL_CREDIT_DISCOUNT_PERC) {
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

	public void setCOMP_POL_FC_SUM_ASSURED_LABEL(HtmlOutputLabel COMP_POL_FC_SUM_ASSURED_LABEL) {
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

	public void setCOMP_POL_LC_SUM_ASSURED_LABEL(HtmlOutputLabel COMP_POL_LC_SUM_ASSURED_LABEL) {
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

	public void setCOMP_UI_M_POL_CLASS_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_CLASS_DESC_LABEL) {
		this.COMP_UI_M_POL_CLASS_DESC_LABEL = COMP_UI_M_POL_CLASS_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_CLASS_DESC(HtmlInputText COMP_UI_M_POL_CLASS_DESC) {
		this.COMP_UI_M_POL_CLASS_DESC = COMP_UI_M_POL_CLASS_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_INST_FC_PREM_LABEL() {
		return COMP_UI_M_POL_INST_FC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_INST_FC_PREM() {
		return COMP_UI_M_POL_INST_FC_PREM;
	}

	public void setCOMP_UI_M_POL_INST_FC_PREM_LABEL(HtmlOutputLabel COMP_UI_M_POL_INST_FC_PREM_LABEL) {
		this.COMP_UI_M_POL_INST_FC_PREM_LABEL = COMP_UI_M_POL_INST_FC_PREM_LABEL;
	}

	public void setCOMP_UI_M_POL_INST_FC_PREM(HtmlInputText COMP_UI_M_POL_INST_FC_PREM) {
		this.COMP_UI_M_POL_INST_FC_PREM = COMP_UI_M_POL_INST_FC_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_INST_LC_PREM_LABEL() {
		return COMP_UI_M_POL_INST_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_INST_LC_PREM() {
		return COMP_UI_M_POL_INST_LC_PREM;
	}

	public void setCOMP_UI_M_POL_INST_LC_PREM_LABEL(HtmlOutputLabel COMP_UI_M_POL_INST_LC_PREM_LABEL) {
		this.COMP_UI_M_POL_INST_LC_PREM_LABEL = COMP_UI_M_POL_INST_LC_PREM_LABEL;
	}

	public void setCOMP_UI_M_POL_INST_LC_PREM(HtmlInputText COMP_UI_M_POL_INST_LC_PREM) {
		this.COMP_UI_M_POL_INST_LC_PREM = COMP_UI_M_POL_INST_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_POL_FC_BANK_ALLOC_AMT_LABEL() {
		return COMP_POL_FC_BANK_ALLOC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_POL_FC_BANK_ALLOC_AMT() {
		return COMP_POL_FC_BANK_ALLOC_AMT;
	}

	public void setCOMP_POL_FC_BANK_ALLOC_AMT_LABEL(HtmlOutputLabel COMP_POL_FC_BANK_ALLOC_AMT_LABEL) {
		this.COMP_POL_FC_BANK_ALLOC_AMT_LABEL = COMP_POL_FC_BANK_ALLOC_AMT_LABEL;
	}

	public void setCOMP_POL_FC_BANK_ALLOC_AMT(HtmlInputText COMP_POL_FC_BANK_ALLOC_AMT) {
		this.COMP_POL_FC_BANK_ALLOC_AMT = COMP_POL_FC_BANK_ALLOC_AMT;
	}

	public HtmlOutputLabel getCOMP_POL_LC_BANK_ALLOC_AMT_LABEL() {
		return COMP_POL_LC_BANK_ALLOC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_BANK_ALLOC_AMT() {
		return COMP_POL_LC_BANK_ALLOC_AMT;
	}

	public void setCOMP_POL_LC_BANK_ALLOC_AMT_LABEL(HtmlOutputLabel COMP_POL_LC_BANK_ALLOC_AMT_LABEL) {
		this.COMP_POL_LC_BANK_ALLOC_AMT_LABEL = COMP_POL_LC_BANK_ALLOC_AMT_LABEL;
	}

	public void setCOMP_POL_LC_BANK_ALLOC_AMT(HtmlInputText COMP_POL_LC_BANK_ALLOC_AMT) {
		this.COMP_POL_LC_BANK_ALLOC_AMT = COMP_POL_LC_BANK_ALLOC_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL() {
		return COMP_UI_M_POL_CONT_AD_ACC_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CONT_AD_ACC_NO() {
		return COMP_UI_M_POL_CONT_AD_ACC_NO;
	}

	public void setCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL(HtmlOutputLabel COMP_UI_M_POL_CONT_AD_ACC_NO_LABEL) {
		this.COMP_UI_M_POL_CONT_AD_ACC_NO_LABEL = COMP_UI_M_POL_CONT_AD_ACC_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_CONT_AD_ACC_NO(HtmlInputText COMP_UI_M_POL_CONT_AD_ACC_NO) {
		this.COMP_UI_M_POL_CONT_AD_ACC_NO = COMP_UI_M_POL_CONT_AD_ACC_NO;
	}

	public HtmlOutputLabel getCOMP_POL_PROP_REF_NO_LABEL() {
		return COMP_POL_PROP_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_PROP_REF_NO() {
		return COMP_POL_PROP_REF_NO;
	}

	public void setCOMP_POL_PROP_REF_NO_LABEL(HtmlOutputLabel COMP_POL_PROP_REF_NO_LABEL) {
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

	public void setCOMP_POL_AGENT_REF_CODE_LABEL(HtmlOutputLabel COMP_POL_AGENT_REF_CODE_LABEL) {
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

	public void setCOMP_POL_FC_DEPOSIT_AMOUNT_LABEL(HtmlOutputLabel COMP_POL_FC_DEPOSIT_AMOUNT_LABEL) {
		this.COMP_POL_FC_DEPOSIT_AMOUNT_LABEL = COMP_POL_FC_DEPOSIT_AMOUNT_LABEL;
	}

	public void setCOMP_POL_FC_DEPOSIT_AMOUNT(HtmlInputText COMP_POL_FC_DEPOSIT_AMOUNT) {
		this.COMP_POL_FC_DEPOSIT_AMOUNT = COMP_POL_FC_DEPOSIT_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_POL_LC_DEPOSIT_AMOUNT_LABEL() {
		return COMP_POL_LC_DEPOSIT_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_DEPOSIT_AMOUNT() {
		return COMP_POL_LC_DEPOSIT_AMOUNT;
	}

	public void setCOMP_POL_LC_DEPOSIT_AMOUNT_LABEL(HtmlOutputLabel COMP_POL_LC_DEPOSIT_AMOUNT_LABEL) {
		this.COMP_POL_LC_DEPOSIT_AMOUNT_LABEL = COMP_POL_LC_DEPOSIT_AMOUNT_LABEL;
	}

	public void setCOMP_POL_LC_DEPOSIT_AMOUNT(HtmlInputText COMP_POL_LC_DEPOSIT_AMOUNT) {
		this.COMP_POL_LC_DEPOSIT_AMOUNT = COMP_POL_LC_DEPOSIT_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_POL_LC_MIN_PREM_LABEL() {
		return COMP_POL_LC_MIN_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_MIN_PREM() {
		return COMP_POL_LC_MIN_PREM;
	}

	public void setCOMP_POL_LC_MIN_PREM_LABEL(HtmlOutputLabel COMP_POL_LC_MIN_PREM_LABEL) {
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

	public void setCOMP_POL_FC_DISC_AMT_LABEL(HtmlOutputLabel COMP_POL_FC_DISC_AMT_LABEL) {
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

	public void setCOMP_POL_LC_DISC_AMT_LABEL(HtmlOutputLabel COMP_POL_LC_DISC_AMT_LABEL) {
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

	public void setCOMP_POL_FC_CLIENT_ALLOC_AMT_LABEL(HtmlOutputLabel COMP_POL_FC_CLIENT_ALLOC_AMT_LABEL) {
		this.COMP_POL_FC_CLIENT_ALLOC_AMT_LABEL = COMP_POL_FC_CLIENT_ALLOC_AMT_LABEL;
	}

	public void setCOMP_POL_FC_CLIENT_ALLOC_AMT(HtmlInputText COMP_POL_FC_CLIENT_ALLOC_AMT) {
		this.COMP_POL_FC_CLIENT_ALLOC_AMT = COMP_POL_FC_CLIENT_ALLOC_AMT;
	}

	public HtmlOutputLabel getCOMP_POL_LC_CLIENT_ALLOC_AMT_LABEL() {
		return COMP_POL_LC_CLIENT_ALLOC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_CLIENT_ALLOC_AMT() {
		return COMP_POL_LC_CLIENT_ALLOC_AMT;
	}

	public void setCOMP_POL_LC_CLIENT_ALLOC_AMT_LABEL(HtmlOutputLabel COMP_POL_LC_CLIENT_ALLOC_AMT_LABEL) {
		this.COMP_POL_LC_CLIENT_ALLOC_AMT_LABEL = COMP_POL_LC_CLIENT_ALLOC_AMT_LABEL;
	}

	public void setCOMP_POL_LC_CLIENT_ALLOC_AMT(HtmlInputText COMP_POL_LC_CLIENT_ALLOC_AMT) {
		this.COMP_POL_LC_CLIENT_ALLOC_AMT = COMP_POL_LC_CLIENT_ALLOC_AMT;
	}

	public HtmlOutputLabel getCOMP_POL_CONT_AD_BANK_CODE_LABEL() {
		return COMP_POL_CONT_AD_BANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CONT_AD_BANK_CODE() {
		return COMP_POL_CONT_AD_BANK_CODE;
	}

	public void setCOMP_POL_CONT_AD_BANK_CODE_LABEL(HtmlOutputLabel COMP_POL_CONT_AD_BANK_CODE_LABEL) {
		this.COMP_POL_CONT_AD_BANK_CODE_LABEL = COMP_POL_CONT_AD_BANK_CODE_LABEL;
	}

	public void setCOMP_POL_CONT_AD_BANK_CODE(HtmlInputText COMP_POL_CONT_AD_BANK_CODE) {
		this.COMP_POL_CONT_AD_BANK_CODE = COMP_POL_CONT_AD_BANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BANK_CODE_DESC_LABEL() {
		return COMP_UI_M_BANK_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BANK_CODE_DESC() {
		return COMP_UI_M_BANK_CODE_DESC;
	}

	public void setCOMP_UI_M_BANK_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_BANK_CODE_DESC_LABEL) {
		this.COMP_UI_M_BANK_CODE_DESC_LABEL = COMP_UI_M_BANK_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_BANK_CODE_DESC(HtmlInputText COMP_UI_M_BANK_CODE_DESC) {
		this.COMP_UI_M_BANK_CODE_DESC = COMP_UI_M_BANK_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_FIRST_INST_DT_LABEL() {
		return COMP_POL_FIRST_INST_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_FIRST_INST_DT() {
		return COMP_POL_FIRST_INST_DT;
	}

	public void setCOMP_POL_FIRST_INST_DT_LABEL(HtmlOutputLabel COMP_POL_FIRST_INST_DT_LABEL) {
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

	public void setCOMP_POL_LAST_INST_DT_LABEL(HtmlOutputLabel COMP_POL_LAST_INST_DT_LABEL) {
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

	public void setCOMP_POL_FC_MIN_PREM_LABEL(HtmlOutputLabel COMP_POL_FC_MIN_PREM_LABEL) {
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

	public void setCOMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL(HtmlOutputLabel COMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL) {
		this.COMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL = COMP_UI_M_FC_SCHARGES_BORNE_CUST_LABEL;
	}

	public void setCOMP_UI_M_FC_SCHARGES_BORNE_CUST(HtmlInputText COMP_UI_M_FC_SCHARGES_BORNE_CUST) {
		this.COMP_UI_M_FC_SCHARGES_BORNE_CUST = COMP_UI_M_FC_SCHARGES_BORNE_CUST;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL() {
		return COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_SCHARGES_BORNE_CUST() {
		return COMP_UI_M_LC_SCHARGES_BORNE_CUST;
	}

	public void setCOMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL(HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL) {
		this.COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL = COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL;
	}

	public void setCOMP_UI_M_LC_SCHARGES_BORNE_CUST(HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_CUST) {
		this.COMP_UI_M_LC_SCHARGES_BORNE_CUST = COMP_UI_M_LC_SCHARGES_BORNE_CUST;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL() {
		return COMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_SCHARGES_BORNE_COMP() {
		return COMP_UI_M_FC_SCHARGES_BORNE_COMP;
	}

	public void setCOMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL(HtmlOutputLabel COMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL) {
		this.COMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL = COMP_UI_M_FC_SCHARGES_BORNE_COMP_LABEL;
	}

	public void setCOMP_UI_M_FC_SCHARGES_BORNE_COMP(HtmlInputText COMP_UI_M_FC_SCHARGES_BORNE_COMP) {
		this.COMP_UI_M_FC_SCHARGES_BORNE_COMP = COMP_UI_M_FC_SCHARGES_BORNE_COMP;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL() {
		return COMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_SCHARGES_BORNE_COMP() {
		return COMP_UI_M_LC_SCHARGES_BORNE_COMP;
	}

	public void setCOMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL(HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL) {
		this.COMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL = COMP_UI_M_LC_SCHARGES_BORNE_COMP_LABEL;
	}

	public void setCOMP_UI_M_LC_SCHARGES_BORNE_COMP(HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_COMP) {
		this.COMP_UI_M_LC_SCHARGES_BORNE_COMP = COMP_UI_M_LC_SCHARGES_BORNE_COMP;
	}

	public HtmlOutputLabel getCOMP_POL_CARD_HOLDER_NAME_LABEL() {
		return COMP_POL_CARD_HOLDER_NAME_LABEL;
	}

	public HtmlInputText getCOMP_POL_CARD_HOLDER_NAME() {
		return COMP_POL_CARD_HOLDER_NAME;
	}

	public void setCOMP_POL_CARD_HOLDER_NAME_LABEL(HtmlOutputLabel COMP_POL_CARD_HOLDER_NAME_LABEL) {
		this.COMP_POL_CARD_HOLDER_NAME_LABEL = COMP_POL_CARD_HOLDER_NAME_LABEL;
	}

	public void setCOMP_POL_CARD_HOLDER_NAME(HtmlInputText COMP_POL_CARD_HOLDER_NAME) {
		this.COMP_POL_CARD_HOLDER_NAME = COMP_POL_CARD_HOLDER_NAME;
	}

	public HtmlOutputLabel getCOMP_POL_DEF_IMM_FLAG_LABEL() {
		return COMP_POL_DEF_IMM_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_DEF_IMM_FLAG() {
		return COMP_POL_DEF_IMM_FLAG;
	}

	public void setCOMP_POL_DEF_IMM_FLAG_LABEL(HtmlOutputLabel COMP_POL_DEF_IMM_FLAG_LABEL) {
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

	public void setCOMP_POL_LC_EXTRA_PREM_LABEL(HtmlOutputLabel COMP_POL_LC_EXTRA_PREM_LABEL) {
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

	public void setCOMP_POL_FC_EXTRA_PREM_LABEL(HtmlOutputLabel COMP_POL_FC_EXTRA_PREM_LABEL) {
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

	public void setCOMP_POL_FC_MON_ANNU_AMT_LABEL(HtmlOutputLabel COMP_POL_FC_MON_ANNU_AMT_LABEL) {
		this.COMP_POL_FC_MON_ANNU_AMT_LABEL = COMP_POL_FC_MON_ANNU_AMT_LABEL;
	}

	public void setCOMP_POL_FC_MON_ANNU_AMT(HtmlInputText COMP_POL_FC_MON_ANNU_AMT) {
		this.COMP_POL_FC_MON_ANNU_AMT = COMP_POL_FC_MON_ANNU_AMT;
	}

	public HtmlOutputLabel getCOMP_POL_LC_MON_ANNU_AMT_LABEL() {
		return COMP_POL_LC_MON_ANNU_AMT_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_MON_ANNU_AMT() {
		return COMP_POL_LC_MON_ANNU_AMT;
	}

	public void setCOMP_POL_LC_MON_ANNU_AMT_LABEL(HtmlOutputLabel COMP_POL_LC_MON_ANNU_AMT_LABEL) {
		this.COMP_POL_LC_MON_ANNU_AMT_LABEL = COMP_POL_LC_MON_ANNU_AMT_LABEL;
	}

	public void setCOMP_POL_LC_MON_ANNU_AMT(HtmlInputText COMP_POL_LC_MON_ANNU_AMT) {
		this.COMP_POL_LC_MON_ANNU_AMT = COMP_POL_LC_MON_ANNU_AMT;
	}

	public HtmlOutputLabel getCOMP_POL_FC_FIRST_PREM_LABEL() {
		return COMP_POL_FC_FIRST_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_FC_FIRST_PREM() {
		return COMP_POL_FC_FIRST_PREM;
	}

	public void setCOMP_POL_FC_FIRST_PREM_LABEL(HtmlOutputLabel COMP_POL_FC_FIRST_PREM_LABEL) {
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

	public void setCOMP_POL_LC_FIRST_PREM_LABEL(HtmlOutputLabel COMP_POL_LC_FIRST_PREM_LABEL) {
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

	public void setCOMP_POL_FC_PRE_TPD_BNF_LABEL(HtmlOutputLabel COMP_POL_FC_PRE_TPD_BNF_LABEL) {
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

	public void setCOMP_POL_LC_PRE_TPD_BNF_LABEL(HtmlOutputLabel COMP_POL_LC_PRE_TPD_BNF_LABEL) {
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

	public void setCOMP_POL_AUTH_LIMIT_LABEL(HtmlOutputLabel COMP_POL_AUTH_LIMIT_LABEL) {
		this.COMP_POL_AUTH_LIMIT_LABEL = COMP_POL_AUTH_LIMIT_LABEL;
	}

	public void setCOMP_POL_AUTH_LIMIT(HtmlInputText COMP_POL_AUTH_LIMIT) {
		this.COMP_POL_AUTH_LIMIT = COMP_POL_AUTH_LIMIT;
	}

	/*
	 * public HtmlCommandButton getCOMP_UI_M_BUS_RUL() { return
	 * COMP_UI_M_BUS_RUL; }
	 * 
	 * public void setCOMP_UI_M_BUS_RUL(HtmlCommandButton COMP_UI_M_BUS_RUL) {
	 * this.COMP_UI_M_BUS_RUL = COMP_UI_M_BUS_RUL; }
	 */

	public HtmlCommandLink getCOMP_UI_M_BUT_COPY() {
		return COMP_UI_M_BUT_COPY;
	}

	public void setCOMP_UI_M_BUT_COPY(HtmlCommandLink COMP_UI_M_BUT_COPY) {
		this.COMP_UI_M_BUT_COPY = COMP_UI_M_BUT_COPY;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FUND_QUERY() {
		return COMP_UI_M_BUT_FUND_QUERY;
	}

	public void setCOMP_UI_M_BUT_FUND_QUERY(HtmlCommandButton COMP_UI_M_BUT_FUND_QUERY) {
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

	public void setCOMP_UI_M_BUT_UDDATE_STAT(HtmlCommandButton COMP_UI_M_BUT_UDDATE_STAT) {
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

	public void setCOMP_UI_M_BUT_CALC_DISC_LOAD(HtmlCommandButton COMP_UI_M_BUT_CALC_DISC_LOAD) {
		this.COMP_UI_M_BUT_CALC_DISC_LOAD = COMP_UI_M_BUT_CALC_DISC_LOAD;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SURR_MAT() {
		return COMP_UI_M_BUT_SURR_MAT;
	}

	public void setCOMP_UI_M_BUT_SURR_MAT(HtmlCommandButton COMP_UI_M_BUT_SURR_MAT) {
		this.COMP_UI_M_BUT_SURR_MAT = COMP_UI_M_BUT_SURR_MAT;
	}

	/*
	 * public HtmlCommandButton getCOMP_UI_M_BUT_ENDT() { return
	 * COMP_UI_M_BUT_ENDT; }
	 * 
	 * public void setCOMP_UI_M_BUT_ENDT(HtmlCommandButton COMP_UI_M_BUT_ENDT) {
	 * this.COMP_UI_M_BUT_ENDT = COMP_UI_M_BUT_ENDT; }
	 */

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVAL() {
		return COMP_UI_M_BUT_APPROVAL;
	}

	public void setCOMP_UI_M_BUT_APPROVAL(HtmlCommandButton COMP_UI_M_BUT_APPROVAL) {
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

	public void setCOMP_UI_M_BUT_LOV_PLAN(HtmlCommandButton COMP_UI_M_BUT_LOV_PLAN) {
		this.COMP_UI_M_BUT_LOV_PLAN = COMP_UI_M_BUT_LOV_PLAN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DOC_GEN_NO() {
		return COMP_UI_M_BUT_DOC_GEN_NO;
	}

	public void setCOMP_UI_M_BUT_DOC_GEN_NO(HtmlCommandButton COMP_UI_M_BUT_DOC_GEN_NO) {
		this.COMP_UI_M_BUT_DOC_GEN_NO = COMP_UI_M_BUT_DOC_GEN_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PROD_CODE() {
		return COMP_UI_M_BUT_LOV_PROD_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_PROD_CODE(HtmlCommandButton COMP_UI_M_BUT_LOV_PROD_CODE) {
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

	public void setCOMP_UI_M_BUT_POL_AMDT(HtmlCommandButton COMP_UI_M_BUT_POL_AMDT) {
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

	public void setCOMP_UI_M_BUT_FUND_DTL(HtmlCommandButton COMP_UI_M_BUT_FUND_DTL) {
		this.COMP_UI_M_BUT_FUND_DTL = COMP_UI_M_BUT_FUND_DTL;
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		this.PT_IL_POLICY_BEAN = PT_IL_POLICY_BEAN;
	}

	/* added by Sivarajan on 12-08-2018 for KICLIFEQC-1761314 */
	public HtmlOutputLabel getCOMP_POL_ENDORSEMENT_TYPE_LABEL() {
		return COMP_POL_ENDORSEMENT_TYPE_LABEL;
	}

	public void setCOMP_POL_ENDORSEMENT_TYPE_LABEL(HtmlOutputLabel cOMP_POL_ENDORSEMENT_TYPE_LABEL) {
		COMP_POL_ENDORSEMENT_TYPE_LABEL = cOMP_POL_ENDORSEMENT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_ENDORSEMENT_TYPE() {
		return COMP_POL_ENDORSEMENT_TYPE;
	}

	/* Added by Sivarajan on 12-08-2018 for KICLIFEQC-1761314 */
	public void setCOMP_POL_ENDORSEMENT_TYPE(HtmlSelectOneMenu cOMP_POL_ENDORSEMENT_TYPE) {
		COMP_POL_ENDORSEMENT_TYPE = cOMP_POL_ENDORSEMENT_TYPE;
	}
	// END

	/* added by gopi for RM018T - DEV_IL_ZB Life_022-Automated Premium Loan */
	private List<SelectItem> listPOL_APL_YN = new ArrayList<SelectItem>();

	public List<SelectItem> getListPOL_APL_YN() {
		if (listPOL_APL_YN.size() == 0) {
			listPOL_APL_YN.clear();
			try {
				listPOL_APL_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOL_APL_YN;
	}

	public void setListPOL_APL_YN(List<SelectItem> listPOL_APL_YN) {
		this.listPOL_APL_YN = listPOL_APL_YN;
	}

	/* end */
	public String deleteRow(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			if (isDELETE_ALLOWED()) {

				helper.ON_CHECK_DELETE_MASTER(PT_IL_POLICY_BEAN);
				new CRUDHandler().executeDelete(PT_IL_POLICY_BEAN, CommonUtils.getConnection());
				getWarningMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));

			} else {

				getErrorMap().put("deleteRow", Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages
						.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}
		return backButton();
	}

	/* added by saranya for sum assured */
	public static String sys_SA;

	public static String getsysparameter() throws Exception {

		String query = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_Code= ?";
		sys_SA = new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE().selectbmivalue(query, "FIN_QUESTVAL");
		System.out.println("PARAMETER VALUE" + sys_SA);
		return sys_SA;
	}

	/* end */

	/*
	 * 
	 * Added By Dhinesh for Quick quote - after converting into proposal while
	 * calculation of premium medical is not getting defaulted due to occupation
	 * code.
	 */

	public static String getoccupation_Code(String Pol_sys_id) throws Exception {

		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		String Psvalue = null;
		CRUDHandler handler = new CRUDHandler();
		String Occupation_Code = null;
		String query = "select POAD_OCC_CODE from PT_IL_POL_ASSURED_DTLS where poad_pol_sys_id = ?";
		resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[] { Pol_sys_id });
		while (resultSet.next()) {
			Occupation_Code = resultSet.getString("POAD_OCC_CODE");
		}

		System.out.println("Occupation_Code VALUE    : " + Occupation_Code);

		return Occupation_Code;
	}

	/* End */

	public void saveRecord() throws Exception {
		/*
		 * System.out.println("getPOL_PREM_OPTION_CODE "+PT_IL_POLICY_BEAN.
		 * getPOL_PREM_OPTION_CODE());
		 */

		compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_REPORT_MODAL_PANEL_ASSURED().setRendered(false);

		/*
		 * Added by ganesh to avoid popuping busrule modal panel on save button
		 * on 09-08-2017
		 */
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_BUS_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		/* end */
		String message = null;
		CommonUtils.clearMaps(this);
		DUMMY_ACTION dummy_action = new DUMMY_ACTION();

		/*
		 * Added by saritha on 29-06-2017 for ssp call id ZBILQC-1719714 &
		 * ZBILQC-1719734
		 */
		Connection conn = null;
		ResultSet resultset = null;
		ResultSet resultset2 = null;
		ResultSet resultset3 = null;
		String product_code = null;
		Double DTL_SA_FROM = null;
		Double DTL_SA_TO = null;
		Double SA_FROM = null;
		Double SA_TO = null;
		CRUDHandler handler1 = new CRUDHandler();
		conn = CommonUtils.getConnection();
		String msg1 = "";
		String msg2 = "";
		/* End */
		String contMessage = null;

		/* Added by Janani on 20.07.2018 for FLALIFEQC-1758558 */
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		/* End */

		try {

			/*
			 * Added by saritha on 16-04-2018 for KIC Customer address Details
			 * to default policy level address Handled for below scenario 1.New
			 * customer creation choose any Communication Address to default
			 * Policy level Communication Address 2.Communication Address to
			 * allow change in address 3.Change in Address Endorsement passing
			 * customer address should not default policy level communication
			 * address only to allow change in address.
			 */

			String addrEnableDisableParam = String.valueOf(CommonUtils.getPPSystemParameterValue("IL_ADDR_DISP"));
			System.out.println("addrEnableDisableParam ----->" + addrEnableDisableParam);
			/*
			 * Added by Sivarajan on 29-01-19 for validate cust and assured code
			 */
			String policy_aaprove = getPolicyApprove();
			if (policy_aaprove != null && !"O".equalsIgnoreCase(policy_aaprove)) {
				if (!validateCivilId(PT_IL_POLICY_BEAN)) {
					throw new Exception("Not a Valid Customer Code or Assured Code");
				}
			}
			/* End */
			if (addrEnableDisableParam.equalsIgnoreCase("1")) {

				/* Newly Added By Dhinesh on 25-04-2018 */
				/*
				 * if(PT_IL_POLICY_BEAN.getPOL_END_CODE()!=null
				 * &&!PT_IL_POLICY_BEAN.getPOL_END_CODE().equalsIgnoreCase(
				 * "GEN002")){
				 */
				if (PT_IL_POLICY_BEAN.getPOL_END_CODE() != null
						&& !CommonUtils.isIN(PT_IL_POLICY_BEAN.getPOL_END_CODE(), "GEN002", "GEN015")) {
					helper.getAddressDetails(compositeAction);
				} else {

					if (PT_IL_POLICY_BEAN.getROWID() == null) {
						helper.getAddressDetails(compositeAction);
					}
				}

			}

			/* End */

			/* Added by Janani on 18.07.2017 for ZBLIFE-1467489 */
			System.out.println("PLAN_TYPE            " + PLAN_TYPE + "       getProd_unit_link_type       "
					+ PT_IL_POLICY_BEAN.getProd_unit_link_type() + "     getPOL_ANN_PAY_PERIOD   "
					+ PT_IL_POLICY_BEAN.getPOL_ANN_PAY_PERIOD());

			if (PLAN_TYPE.equalsIgnoreCase("u") && PT_IL_POLICY_BEAN.getProd_unit_link_type().equalsIgnoreCase("edu")) {
				if ("0".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_ANN_PAY_PERIOD())) {
					throw new Exception("Please select Annuity payout period in Collection Method Tab");
				}
			}
			/* End of ZBLIFE-1467489 */

			/* Added by Janani on 18.07.2017 for ZBILQC-1732136 */

			System.out.println("getPOL_MODE_OF_PYMT                   " + PT_IL_POLICY_BEAN.getPOL_MODE_OF_PYMT());
			System.out.println("getPOL_PYMT_TYPE                   " + PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE());

			/*
			 * Added by saritha on 22-11-2017 for Due date for debit order by
			 * each policy is required
			 */
			if (PT_IL_POLICY_BEAN.getPOL_DEBIT_DAY() == null
					&& PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("AD")) {
				throw new Exception("Direct Debit Due Date:Validation Error: Value is required");
			}
			/* End */

			/*
			 * Modified by Janani on 27.06.2018 for FLA as per Chandramohan
			 * sugges
			 */
			// if(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("S") &&
			// !PT_IL_POLICY_BEAN.getPOL_MODE_OF_PYMT().equalsIgnoreCase("M"))

			if ((PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("S")
					|| PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("AO"))
					&& !PT_IL_POLICY_BEAN.getPOL_MODE_OF_PYMT().equalsIgnoreCase("M"))

			/* End */
			{
				System.out.println("mode of payment is not monthly");
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "2314"));

				// throw new Exception("Payment type Stop order is applicable
				// only for Mode of Payment:Monthly");
			} else {

				// System.out.println("UPD_Dt---->"+CommonUtils.dateToPELStringFormatterWithTimeStamp(PT_IL_POLICY_BEAN.getPOL_UPD_DT()));
				// System.out.println("Policy upd dt on save"+
				// CommonUtils.dateToPELStringFormatterWithTimeStamp(PT_IL_POLICY_BEAN.getPOL_UPD_DT()));

				/* added by raja on 10-07-2017 for ZBILQC-1731018 */

				LIFELIB lifelib = new LIFELIB();
				/*
				 * try - catch handled by Ameen on 07-08-2017 for ZBILQC-1731155
				 */
				try {
					lifelib.P_VAL_CUST(PT_IL_POLICY_BEAN.getPOL_CONT_CODE(), PT_IL_POLICY_BEAN.getPOL_ASSURED_NAME(),
							"N", "N",
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE());
				} catch (Exception e) {
					contMessage = e.getMessage();
					String ErrMSG = custErrCode(contMessage, "PT_IL_POLICY:POL_CONT_CODE");
					throw new Exception(ErrMSG);
				}
				/* end try - catch handling */
				/* end */

				/* commented by raja on 25-07-2017 for ZBILQC-1730358 */
				/* Added by Janani on 09.06.2017 for ZBILQC-1728495 */

				// helper.assuredAgeCheck(compositeAction);

				/* End */
				/* End */
				/* added by saranya for sum assured */
				String value = getsysparameter();
				int getsm = Integer.parseInt(value);
				System.out.println("FINPARAMVALUE-->" + getsm + "]");
				System.out.println("getPT_IL_POLICY_BEAN().getPOL_PREM_PAY_YRS()         "
						+ getPT_IL_POLICY_BEAN().getPOL_PREM_PAY_YRS() + "     "
						+ getPT_IL_POLICY_BEAN().getPOL_PERIOD());

				/*
				 * Added by Ram on 26/11/2016 for Policy Period validation
				 * handling
				 */
				if (getPT_IL_POLICY_BEAN().getPOL_PREM_PAY_YRS() > getPT_IL_POLICY_BEAN().getPOL_PERIOD()) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014", new Object[] {
							"Premium Paying Years",
							"less than or equal to Policy Period  " + getPT_IL_POLICY_BEAN().getPOL_PERIOD() }));
				}
				/* End */

				/* added by raja on 30-05-2017 for ZBILQC-1724894 */
				helper.POL_ASSRD_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction,
						getPT_IL_POLICY_BEAN().getPOL_ASSRD_REF_ID1());
				/* end */

				if (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_FC_SUM_ASSURED() != null) {
					double SUM_ASSURED = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
							.getPOL_FC_SUM_ASSURED();
					System.out.println("SUM_ASSURED-->" + SUM_ASSURED + "]");
					String Todo = "FINANCIAL QUESTIONARIES";
					if (SUM_ASSURED > getsm) {
						new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE().updatemandatoryflag(compositeAction, "Y", Todo);
						System.out.println("manditary field if part value:"
								+ compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
										.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_MANDATORY_YN());

					} else {
						new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE().updatemandatoryflag(compositeAction, "N", Todo);
						System.out.println("manditary field else part value:"
								+ compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
										.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_MANDATORY_YN());
					}

					/* END */

				} /*
					 * Commented by Saranya on 07/04/2017 else{ throw new
					 * Exception(" FC Sum Assured :Validation Error: Value is required."
					 * ); } End
					 */

				/*
				 * Added by sankara narayanan for uicomponent frz flag on
				 * 21-03-2017
				 */
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.setPOL_FRZ_FLAG(CommonUtils.nvl(PT_IL_POLICY_BEAN.getUI_POL_FRZ_FLAG(), "N"));
				// end

				// added by agalya on 10/07/2016 for ssp call no
				// -FALCONQC-1714573
				String POL_FRZ_FLAG = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_FRZ_FLAG();
				System.out.println("POL_FRZ_FLAG in save button========>" + POL_FRZ_FLAG);
				String POL_DS_TYPE = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_DS_TYPE();
				System.out.println("POL_DS_TYPE in save button==========>" + POL_DS_TYPE);
				String POL_PROP_QUOT_FLAG = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_PROP_QUOT_FLAG();
				System.out.println("POL_PROP_QUOT_FLAG in save button==========>" + POL_PROP_QUOT_FLAG);
				Integer POL_END_NO_IDX = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_END_NO_IDX();
				System.out.println("POL_END_NO_IDX ::::::INter" + POL_END_NO_IDX);
				// Added by Dhinesh on 19-06-2017
				/*
				 * if(POL_FRZ_FLAG.equalsIgnoreCase("Y")&&
				 * POL_DS_TYPE.equals("1")&&
				 * POL_PROP_QUOT_FLAG.equalsIgnoreCase("P"))
				 */
				if (POL_FRZ_FLAG.equalsIgnoreCase("Y") && POL_DS_TYPE.equals("1")
						&& POL_PROP_QUOT_FLAG.equalsIgnoreCase("P") && "A".equalsIgnoreCase(compositeAction
								.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FAC_BASIS())) {
					System.out.println("inside the proceduce");
					PKG_PILT002_APAC PKG_PILT002_APAC_BEAN = new PKG_PILT002_APAC();
					int PC_SYS_ID = 0;
					Date PC_SCHD_PYMT_DT = null;
					Connection con = null;
					con = CommonUtils.getConnection();
					ResultSet resultSet = null;
					CRUDHandler handler = new CRUDHandler();
					long pol_sys_id = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
							.getPOL_SYS_ID();

					System.out.println("value of pol_sys_id in premiajasperprint" + pol_sys_id);
					String query = "SELECT PC_SYS_ID, PC_SCHD_PYMT_DT  FROM PT_IL_PREM_COLL, PT_IL_POLICY WHERE PC_POL_SYS_ID = POL_SYS_ID AND POL_DS_TYPE = 1 AND PC_POL_SYS_ID ='"
							+ pol_sys_id + "'";
					System.out.println("query exe sucess" + query);
					resultSet = new CRUDHandler().executeSelectStatement(query, con);
					System.out.println("value for insert" + handler.executeSelectStatement(query, con));
					while (resultSet.next()) {
						PC_SYS_ID = resultSet.getInt("PC_SYS_ID");
						PC_SCHD_PYMT_DT = resultSet.getDate("PC_SCHD_PYMT_DT");
					}

					System.out.println("value of PC_SYS_ID--------->" + PC_SYS_ID);
					System.out.println("value of Pol_Sys_id" + pol_sys_id);

					System.out.println("value of PC_SCHD_PYMT_DT--------->" + PC_SCHD_PYMT_DT);
					String freeze = "N";
					String values = "P";

					/* added by raja on 30-06-2017 ZBILQC-1730135 */
					boolean flag = false;
					getProd_plan_type();
					if (PLAN_TYPE.equalsIgnoreCase("L")) {
						flag = true;
					}

					if (PLAN_TYPE.equalsIgnoreCase("U")) {
						String value1 = null;
						String Prod = "SELECT PROD_UNIT_LINK_TYPE FROM PM_IL_PRODUCT where prod_code=?";
						ResultSet rsProd = new CRUDHandler().executeSelectStatement(Prod, CommonUtils.getConnection(),
								new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
						while (rsProd.next()) {
							value1 = rsProd.getString("PROD_UNIT_LINK_TYPE");

						}
						/*
						 * if(value1!=null && value1.equalsIgnoreCase("NA")) {
						 * 
						 * String
						 * Addcov="select 'X' from PT_IL_POL_ADDL_COVER where POAC_POL_SYS_ID=?"
						 * ; ResultSet rsAddcov=new
						 * CRUDHandler().executeSelectStatement(Addcov,
						 * CommonUtils.getConnection(), new
						 * Object[]{PT_IL_POLICY_BEAN.getPOL_SYS_ID()});
						 * if(rsAddcov.next()) { flag=false; } else { flag=true;
						 * }
						 * 
						 * }
						 */

						/* Added by saritha */
						if (value1 != null && value1.equalsIgnoreCase("NA")) {
							if (PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED() != null) {

								flag = false;

							}

							else {
								String Addcov = "select 'X' from PT_IL_POL_ADDL_COVER where POAC_POL_SYS_ID=?";
								ResultSet rsAddcov = new CRUDHandler().executeSelectStatement(Addcov,
										CommonUtils.getConnection(),
										new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
								if (rsAddcov.next()) {
									flag = false;
								} else {
									flag = true;
								}
							}

						}

						/* End */

					}

					/* end */
					if (flag == false) {
						PKG_PILT002_APAC_BEAN.callpolicyreviewsheet(String.valueOf(pol_sys_id),
								String.valueOf(PC_SYS_ID), CommonUtils.dateToStringFormatter(PC_SCHD_PYMT_DT), freeze,
								values);
					}
				}
				// Added by Ameen 30-7-2016 as per Siva said to call procedure
				// P9ILPK_RI_ALLOC.P_APPRV_FAC if ds_type=2 and IDX_NO=0

				PKG_PILT002_APAC PKG_PILT002_APAC_BEAN = new PKG_PILT002_APAC();

				if (POL_FRZ_FLAG.equalsIgnoreCase("Y") && POL_DS_TYPE.equals("2")
						&& POL_PROP_QUOT_FLAG.equalsIgnoreCase("P") && POL_END_NO_IDX == 0
						&& "A".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
								.getPOL_FAC_BASIS())) {
					System.out.println("POL_DS_TYPE 2 inside the proceduce");

					/*
					 * Instance Object creation place changed by Ramkumar on
					 * 06-08-2016 for Cover default Date change issue
					 * 
					 * PKG_PILT002_APAC PKG_PILT002_APAC_BEAN=new
					 * PKG_PILT002_APAC();
					 */

					int PC_SYS_ID = 0;
					Date PC_SCHD_PYMT_DT = null;
					Connection con = null;
					con = CommonUtils.getConnection();
					ResultSet resultSet = null;
					CRUDHandler handler = new CRUDHandler();
					long pol_sys_id = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
							.getPOL_SYS_ID();

					System.out.println("value of pol_sys_id in premiajasperprint" + pol_sys_id);
					String query = "SELECT PC_SYS_ID, PC_SCHD_PYMT_DT  FROM PT_IL_PREM_COLL, PT_IL_POLICY WHERE PC_POL_SYS_ID = POL_SYS_ID AND POL_DS_TYPE = 2 AND PC_POL_SYS_ID ='"
							+ pol_sys_id + "'";
					System.out.println("query exe sucess" + query);
					resultSet = new CRUDHandler().executeSelectStatement(query, con);
					System.out.println("value for insert" + handler.executeSelectStatement(query, con));
					while (resultSet.next()) {
						PC_SYS_ID = resultSet.getInt("PC_SYS_ID");
						PC_SCHD_PYMT_DT = resultSet.getDate("PC_SCHD_PYMT_DT");
					}

					System.out.println("value of PC_SYS_ID--------->" + PC_SYS_ID);
					System.out.println("value of Pol_Sys_id" + pol_sys_id);

					System.out.println("value of PC_SCHD_PYMT_DT--------->" + PC_SCHD_PYMT_DT);
					String freeze = "N";
					String values = "P";

					/* added by raja on 30-06-2017 ZBILQC-1730135 */
					boolean flag = false;
					getProd_plan_type();
					if (!PLAN_TYPE.equalsIgnoreCase("L")) {
						flag = true;
					}

					if (!PLAN_TYPE.equalsIgnoreCase("U")) {
						String value1 = null;
						String Prod = "SELECT PROD_UNIT_LINK_TYPE FROM PM_IL_PRODUCT where prod_code=?";
						ResultSet rsProd = new CRUDHandler().executeSelectStatement(Prod, CommonUtils.getConnection(),
								new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
						while (rsProd.next()) {
							value1 = rsProd.getString("PROD_UNIT_LINK_TYPE");

						}
						if (value1 != null && value1.equalsIgnoreCase("NA")) {

							String Addcov = "select 'X' from PT_IL_POL_ADDL_COVER where POAC_POL_SYS_ID=?";
							ResultSet rsAddcov = new CRUDHandler().executeSelectStatement(Addcov,
									CommonUtils.getConnection(), new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
							if (rsAddcov.next()) {
								flag = false;
							} else {
								flag = true;
							}

						}

					}

					/* end */
					if (flag == false) {
						PKG_PILT002_APAC_BEAN.callpolicyreviewsheet(String.valueOf(pol_sys_id),
								String.valueOf(PC_SYS_ID), CommonUtils.dateToStringFormatter(PC_SCHD_PYMT_DT), freeze,
								values);
					}
				}
				// End procedure calling P9ILPK_RI_ALLOC.P_APPRV_FAC by Ameen

				/*
				 * Condition Added by Ameen on 18/11/2016 for Endorsement
				 * Cancellation
				 */
				/*
				 * 
				 * commented By Dhinesh on 31-05-2018
				 * 
				 * if(!"009".equalsIgnoreCase(getPT_IL_POLICY_BEAN().
				 * getPOL_END_TYPE())){ chkSumAssured(); }
				 */

				/* Modified By Dhinesh on 31-05-2018 */
				if (!"009".equalsIgnoreCase(getPT_IL_POLICY_BEAN().getPOL_END_TYPE())
						&& CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(), 0) > 0) {
					chkSumAssured();
				}
				/* End */
				/* End */

				if ("Y".equals(PT_IL_POLICY_BEAN.getPOL_FAC_YN())) {
					helper.POL_RI_POOL_CODE_WHEN_VALIDATE_ITEM(compositeAction,
							PT_IL_POLICY_BEAN.getPOL_RI_POOL_CODE());
				}

				/*
				 * Added by saritha on 21-Jan-2017 for RM018T -DEV_IL_ZB
				 * Life_015-Lapsation and commission clawback 2
				 */

				Connection connection = null;
				ResultSet resultSet = null;
				ResultSet resultSet1 = null;
				int END_IDX_NO = 0;
				String CUST_EMAIL_ID_PER = null;
				CRUDHandler handler = new CRUDHandler();
				connection = CommonUtils.getConnection();

				String C1 = "SELECT POL_END_NO_IDX FROM PT_IL_POLICY WHERE POL_SYS_ID=?";
				String C2 = "SELECT CUST_EMAIL_ID_PER from PM_CUSTOMER where CUST_CODE=?";
				resultSet = handler.executeSelectStatement(C1, connection,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
				while (resultSet.next()) {
					END_IDX_NO = resultSet.getInt(1);
					System.out.println("End number idx:::::::::" + END_IDX_NO);
				}
				System.out.println("Customer_code::::" + PT_IL_POLICY_BEAN.getPOL_CUST_CODE());
				resultSet1 = handler.executeSelectStatement(C2, connection,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_CUST_CODE() });
				while (resultSet1.next()) {
					CUST_EMAIL_ID_PER = resultSet1.getString("CUST_EMAIL_ID_PER");
					System.out.println("email_id***********" + CUST_EMAIL_ID_PER);
				}

				if ((END_IDX_NO == 0) && (PT_IL_POLICY_BEAN.getPOL_CUST_CODE() != null)) {
					PT_IL_POLICY_BEAN.setPOL_FLEX_26(CUST_EMAIL_ID_PER);
					/*
					 * Added by saritha on 12-07-2017 for Endowment Product
					 * &Education Product Issues
					 */
					Endow_Product();
					/* End */
				}
				/* End */
				/*
				 * Commented by ganesh on 02-11-2017, as suggested by girish sir
				 * no validation required in save button
				 */
				/*
				 * Added by Ameen on 30-10-2017 for bank details defaulting
				 * issue
				 */
				/*
				 * if("AD".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE()
				 * ) ||
				 * "BS".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE())){
				 * bankAccDtlsCheck(); }
				 */
				/* End */
				/* end */
				/*
				 * added by Ameen on 02-10-2018 as per Ajay sugg. issue :for
				 * FLA/VLA to set POL_CUST_EXCH_RATE = 1 as default if 0 to
				 * avoid divisor equal to 0 error
				 */
				if (PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE() == null || PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE() == 0
						|| PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE() == 0.0) {
					PT_IL_POLICY_BEAN.setPOL_CUST_EXCH_RATE(1.0);
				}
				/* End */
				if (getPT_IL_POLICY_BEAN().getROWID() != null) {
					if (isUPDATE_ALLOWED()) {
						helper.PRE_UPDATE(compositeAction);

						helper.POL_CONT_CODE_WHEN_VALIDATE_ITEM(compositeAction,
								(String) PT_IL_POLICY_BEAN.getPOL_CONT_CODE());
						// System.out.println("Policy upd dt after preupdate"+
						// CommonUtils.dateToPELStringFormatterWithTimeStamp(PT_IL_POLICY_BEAN.getPOL_UPD_DT()));
						/*
						 * Added by Ameen on 22-11-2017 for policy term
						 * validation
						 */
						checkPolTerm();
						/* end */
						validateOtherRichTabComponents();
						if ("020".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
							helper.specialRevivalCheck(compositeAction);
							// disableAllComponent(true);
						}

						/*
						 * Added by Janani on 20.07.2018 for FLALIFEQC-1758558
						 */

						System.out.println(
								"getPOL_FC_AGENT_PREM              " + PT_IL_POLICY_BEAN.getPOL_FC_AGENT_PREM());

						list = new P9ILPK_POLICY_NR().P_UPD_PREM_FLAG_NEW(
								compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
								PT_IL_POLICY_BEAN.getPOL_FC_AGENT_PREM());

						if (list != null && !list.isEmpty()) {
							if (list.get(0).getValueObject() != null) {
								PT_IL_POLICY_BEAN.setPOL_FLEX_20((String) list.get(0).getValueObject());
							}
						}

						System.out.println("getPOL_FLEX_20               " + PT_IL_POLICY_BEAN.getPOL_FLEX_20());

						/* End */

						helper.ChkPrdAgeSetup(PT_IL_POLICY_BEAN);
						new CRUDHandler().executeUpdate(PT_IL_POLICY_BEAN, CommonUtils.getConnection());
						// dummy_action.keycommitButtonAction();
						helper.POST_UPDATE(PT_IL_POLICY_BEAN, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
								compositeAction);

						System.out.println("getPOL_FLEX_20               " + PT_IL_POLICY_BEAN.getPOL_FLEX_20());

						helper.updateThresholdLimit(PT_IL_POLICY_BEAN, compositeAction
								.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN());
						helper.POST_QUERY(compositeAction);
						if (PT_IL_POLICY_BEAN.getPOL_FAC_YN().equalsIgnoreCase("Y")) {
							if (PT_IL_POLICY_BEAN.getPOL_RI_POOL_CODE() == null) {
								throw new Exception("PoolCode value is required");
							}
						}
						Integer pol_prd = CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_ORG_PERIOD(), 0)
								+ PT_IL_POLICY_BEAN.getPOL_PERIOD();
						// if("012".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(),"000"))){
						if ((CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_ORG_PREM_PAY_YRS(), 0) + PT_IL_POLICY_BEAN
								.getPOL_PREM_PAY_YRS()) > (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_ORG_PERIOD(), 0)
										+ PT_IL_POLICY_BEAN.getPOL_PERIOD())) {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",
									new Object[] { "Premium Paying Years",
											"less than or equal to Policy Period  " + pol_prd }));
						}
						// }

						/*
						 * Added by saritha on 01-Feb-2018 Feneral Plan(207)
						 * Dependant save Record inserted &updated null error as
						 * per siva sir sugg.
						 */
						if (PT_IL_POLICY_BEAN.getPOL_OLD_ASSRD_REF_ID() != null && !PT_IL_POLICY_BEAN
								.getPOL_OLD_ASSRD_REF_ID().equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1())) {
							new PKG_PILT002_APAC().P_ASSURED_DETAILS(PT_IL_POLICY_BEAN.getPOL_SYS_ID());

							PT_IL_POLICY_BEAN.setPOL_OLD_ASSRD_REF_ID(null);

						}
						/* End */

						/*
						 * Added by Janani on 20.06.2018 for FLALIFEQC-1754995
						 */

						helper.POL_FC_SUM_ASSURED_WHEN_VALIDATE_ITEM(compositeAction,
								PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED());
						/* End of FLALIFEQC-1754995 */

						getWarningMap().put("current",
								Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
						message = Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update");
					}
				} else {
					if (isINSERT_ALLOWED()) {

						System.out.println("*************** Enter the INSERT_ALLOWED ******************");

						if ("F".equals(
								compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_COVER_SA_CALC())) {
							helper.checkSA(PT_IL_POLICY_BEAN);
						}
						helper.ChkPrdAgeSetup(PT_IL_POLICY_BEAN);

						/* added by raja on 30-05-2017 for ZBILQC-1730358 */
						String custStatus = null;
						int min_age = 0;
						int max_age = 0;
						Date DOB = null;
						int age = 0;
						ArrayList<OracleParameter> list2 = null;
						PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
						DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();

						String freezQuery = "SELECT PLAN_PROP_AGE_FM,PLAN_PROP_AGE_TO,CUST_DOB FROM PM_IL_PLAN ,PM_CUSTOMER WHERE PLAN_CODE=? AND CUST_CODE=?";
						ResultSet freezRS = new CRUDHandler().executeSelectStatement(freezQuery,
								CommonUtils.getConnection(), new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE(),
										PT_IL_POLICY_BEAN.getPOL_CUST_CODE() });
						while (freezRS.next()) {
							min_age = freezRS.getInt("PLAN_PROP_AGE_FM");
							max_age = freezRS.getInt("PLAN_PROP_AGE_TO");
							DOB = freezRS.getDate("CUST_DOB");
						}
						list2 = localProcedure.P_CALC_ANB(new CommonUtils().getCurrentDate(), DOB,
								dummyBean.getUI_M_PROD_AGE_CALC_FLAG(), age);
						if (list2 != null && !list2.isEmpty()) {
							if (list2.get(0).getValueObject() != null) {
								age = (Integer) list2.get(0).getValueObject();
							}
						}

						if (age < min_age || age > max_age) {
							/*
							 * changed by raja on 25-07-2017 for ZBILQC-1730358
							 */
							throw new Exception("Proposer age should between " + min_age + " and " + max_age);
						}
						/* end */

						helper.POL_CONT_CODE_WHEN_VALIDATE_ITEM(compositeAction,
								(String) PT_IL_POLICY_BEAN.getPOL_CONT_CODE());
						/*
						 * Added by Ameen on 22-11-2017 for policy term
						 * validation
						 */
						checkPolTerm();
						/* end */

						helper.PRE_INSERT(compositeAction);
						validateOtherRichTabComponents();

						/*
						 * Added by Janani on 20.06.2018 for FLALIFEQC-1754995
						 */

						helper.POL_FC_SUM_ASSURED_WHEN_VALIDATE_ITEM(compositeAction,
								PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED());
						/* End of FLALIFEQC-1754995 */

						doc_gen_noButton_Action();
						// COMP_POL_RES_ADDRESS_1.setValue("na");

						System.out.println("POL_DS_TYPE  == " + PT_IL_POLICY_BEAN.getPOL_DS_TYPE());
						System.out.println("POL_NO  == " + PT_IL_POLICY_BEAN.getPOL_NO());
						System.out.println("POL_END_NO_IDX  == " + PT_IL_POLICY_BEAN.getPOL_END_NO_IDX());
						System.out.println("POL_PROP_QUOT_FLAG  == " + PT_IL_POLICY_BEAN.getPOL_PROP_QUOT_FLAG());

						/*
						 * Added by Janani on 20.07.2018 for FLALIFEQC-1758558
						 */

						System.out.println(
								"getPOL_FC_AGENT_PREM              " + PT_IL_POLICY_BEAN.getPOL_FC_AGENT_PREM());

						list = new P9ILPK_POLICY_NR().P_UPD_PREM_FLAG_NEW(
								compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
								PT_IL_POLICY_BEAN.getPOL_FC_AGENT_PREM());
						System.out.println("POL_RES_EMAIL_ID  == " + PT_IL_POLICY_BEAN.getPOL_RES_EMAIL_ID());
						if (list != null && !list.isEmpty()) {
							if (list.get(0).getValueObject() != null) {
								PT_IL_POLICY_BEAN.setPOL_FLEX_20((String) list.get(0).getValueObject());
							}
						}
						System.out.println("getPOL_FLEX_20               " + PT_IL_POLICY_BEAN.getPOL_FLEX_20());

						/* End */

						new CRUDHandler().executeInsert(PT_IL_POLICY_BEAN, CommonUtils.getConnection());

						/* added by sankara narayanan on 28/03/2017 */
						new PKG_PILT002_APAC().P_ASSURED_DETAILS(PT_IL_POLICY_BEAN.getPOL_SYS_ID());
						/* end */

						/* Added by Ameen on 12-05-2017 as per siva sugg. */
						new P9ILPK_POLICY_NR().P_INS_ADDL_COVER(PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
								PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
								compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_CHANGE_SA_YN());
						/* end */

						/* added by gopi for toi on 26/05/18 */
						String Benef_cust_flag = getBeneficiary_as_customer();
						if (Benef_cust_flag != null && "Y".equalsIgnoreCase(Benef_cust_flag)) {
							System.out.println(
									"P9ILPK_POLICY_NR().P_BENEFICIARY_DETAILS PROCEDURE EXECUTED SUCCESSFULLY");
							new P9ILPK_POLICY_NR().P_BENEFICIARY_DETAILS(PT_IL_POLICY_BEAN.getPOL_SYS_ID());
						}
						/* end */

						/*
						 * Added by Saranya on 13-03-2017 for RM018T - FSD_IL_ZB
						 * Life_001-Education Endowment Plan COMMENTS
						 */
						helper.POST_INSERT(compositeAction);
						helper.POST_QUERY(compositeAction);
						message = Messages.getString("messageProperties", "errorPanel$message$save");
						/* End */

						/*
						 * added by raja on 05-03-2017 for ssp call id -
						 * ZBILQC-1719062
						 */

						COMP_CUST_BUTTON.setDisabled(false);
						COMP_CUST_COMMAND_LINK.setDisabled(false);
						COMP_ASSU_BUTTON.setDisabled(false);
						COMP_ASSU_COMMAND_LINK.setDisabled(false);

						/* end */

						if (PT_IL_POLICY_BEAN.getPOL_FAC_YN().equalsIgnoreCase("Y")) {
							if (PT_IL_POLICY_BEAN.getPOL_RI_POOL_CODE() == null) {
								throw new Exception("PoolCode value is required");
							}
						}
					}
				}

				/*
				 * commented By Dhinesh on 4-7-2017 for ssp call id :
				 * ZBILQC-1723357
				 * 
				 * PKG_PILT002_APAC_BEAN.P_POL_COV_DT_DFT(getPT_IL_POLICY_BEAN()
				 * .getPOL_SYS_ID().toString());
				 * 
				 * CommonUtils.getConnection().commit();
				 */

				if ("Y".equals(this.PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
					COMP_UI_M_BUT_APPROVAL.setDisabled(false);
				}
				/*
				 * Newly added the below code To avoid the popup is opening on
				 * save
				 */
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_REPORT_MODAL_PANEL_CUSTOMER()
						.setShowWhenRendered(false);

				enableComponentsBasedOnFreezRate();
				if ("020".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
					// helper.specialRevivalCheck(compositeAction);
					disableAllComponent(true);
				}

				if ("012".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE())
						&& "N".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(), "N"))) {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
				}

				// added by Ameen as per Somnath Suggestion for Endorsement
				// Cancellation
				System.out
						.println("P_PRORATE_CAN_ENDORS POL_END_TYPE    : " + getPT_IL_POLICY_BEAN().getPOL_END_TYPE());
				if ("009".equalsIgnoreCase(getPT_IL_POLICY_BEAN().getPOL_END_TYPE())) {
					System.out.println("inside POL_END_TYPE 009");
					PKG_PILT002_APAC_BEAN.callP_PRORATE_CAN_ENDORS(getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
							getPT_IL_POLICY_BEAN().getPOL_END_CODE());
				}

				P9ILPK_POLICY P9ILPK_POLICY_OBJ = new P9ILPK_POLICY();
				ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
				System.out.println(
						"compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()  update    "
								+ compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
				if (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID() != null) {
					outputList = P9ILPK_POLICY_OBJ.UPDATE_ASSRD_TH_LT_FOR_POLICY(compositeAction
							.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString());
				}
				/*
				 * Added by Ram on 23/11/2016 for Endorsement Cancellation value
				 * onload
				 */

				helper.executeQuery(compositeAction);
				helper.POST_QUERY(compositeAction);
				/* End */

				/* added by rja on 09-05-2017 */
				Double UI_M_SUM_PBEN_PERC = 0.0;
				if (compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getDataList_PT_IL_POL_BENEFICIARY()
						.size() > 0) {
					for (PT_IL_POL_BENEFICIARY bn : compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
							.getDataList_PT_IL_POL_BENEFICIARY()) {
						UI_M_SUM_PBEN_PERC = UI_M_SUM_PBEN_PERC + bn.getPBEN_PERC();
					}
					if (UI_M_SUM_PBEN_PERC != null) {
						if (UI_M_SUM_PBEN_PERC > 100.00) {
							throw new Exception((Messages.getString(PELConstants.pelErrorMessagePath, "91136")));
						} else if (UI_M_SUM_PBEN_PERC < 100.00) {
							throw new Exception((Messages.getString(PELConstants.pelErrorMessagePath, "91971")));
						}
					}
				}
				/* end */

				/* added by raja on 24-04-2017 */
				int shareRatioSystemParam = ((BigDecimal) CommonUtils.getPPSystemParameterValue("IL_BRKR_SHAR"))
						.intValue();
				if (shareRatioSystemParam == 1) {
					Double UI_M_SUM_POBH_SHARE_PERC = 0.0;
					if (compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getDataList_PT_IL_POL_BROKER_HEAD()
							.size() != 0) {
						// Added to check share Ratio percentage during save
						for (PT_IL_POL_BROKER_HEAD obj : compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
								.getDataList_PT_IL_POL_BROKER_HEAD()) {
							if (obj.getPOBH_SRNO() == 1) {
								Double value1 = CommonUtils.nvl(obj.getPOBH_SHARE_PERC(), 0);
								UI_M_SUM_POBH_SHARE_PERC = UI_M_SUM_POBH_SHARE_PERC + value1;
							}
						}
						if (UI_M_SUM_POBH_SHARE_PERC != null) {
							if (!(UI_M_SUM_POBH_SHARE_PERC == 100.00)) {
								throw new Exception("Total Broker Share Ratio % Should be 100%");
							}
						}
					}
				}
				/* end */

				/*
				 * Commented by ganesh on 19-09-2017 and it is moved at the last
				 * of the saverecord method for ZBILQC-1732146
				 */
				/*
				 * getWarningMap().put(PELConstants.
				 * PEL_ERROR_WARNING_CURRENT_KEY, message);
				 * getWarningMap().put("SAVE_RECORD", message);
				 */
				/* end */

				/*
				 * Added by saranya for for RM018T - FSD_IL_ZB
				 * Life_001-Education Endowment Plan COMMENTS on 20-04-2017
				 */
				/* setPremiumCalculationType(); */

				/*
				 * Modified by saritha on 01-08-2017 for Endowment Product &
				 * Education Product issues
				 */
				setPremiumCalcType();
				/* End */

				Unit_link_typ();
				if ((!"NA".equalsIgnoreCase(getUnit_link_typ()))
						&& ("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()))) {
					/*
					 * getErrorMap().put(PELConstants.
					 * PEL_ERROR_WARNING_CURRENT_KEY, "NOT A VALID OPTION");
					 */
					throw new Exception("Premium Calc Type: NOT A VALID OPTION");
				}
				if (("NA".equalsIgnoreCase(getUnit_link_typ()))
						&& (!"N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()))) {
					/*
					 * getErrorMap().put(PELConstants.
					 * PEL_ERROR_WARNING_CURRENT_KEY, "NOT A VALID OPTION");
					 */
					throw new Exception("Premium Calc Type: NOT A VALID OPTION");
				}
				/* End */

				/* added by raja 09-06-2017 for ZBILQC-1724894 */
				/*
				 * try - catch handled by Ameen on 07-08-2017 for ZBILQC-1731155
				 */
				try {
					lifelib.P_VAL_CUST(PT_IL_POLICY_BEAN.getPOL_CUST_CODE(), PT_IL_POLICY_BEAN.getUI_M_POL_CUST_DESC(),
							"N", "N", PT_IL_POLICY_BEAN.getPOL_DIVN_CODE());
				} catch (Exception exec) {
					contMessage = exec.getMessage();
					String ErrMSG = custErrCode(contMessage, "PT_IL_POLICY:POL_CUST_CODE");
					throw new Exception(ErrMSG);
				}
				/* end try - catch handling */
				/* END */

				/*
				 * Added by saranya for for RM018T - FSD_IL_ZB
				 * Life_001-Education Endowment Plan COMMENTS on 22-03-2017
				 */
				setBlockFlag(true);
				/* End */

				/*
				 * Added by saritha on 29-06-2017 for ssp call id ZBILQC-1719714
				 * &ZBILQC-1719734
				 */
				System.out.println("pol no::::" + PT_IL_POLICY_BEAN.getPOL_NO());
				String query = "SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO=?";
				resultset = handler1.executeSelectStatement(query, conn,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_NO() });
				while (resultset.next()) {
					product_code = resultset.getString("POL_PROD_CODE");
					System.out.println("product code::::" + product_code);
				}

				long pol_sys_id = PT_IL_POLICY_BEAN.getPOL_SYS_ID();
				System.out.println("pol_sys_id--------------" + pol_sys_id);

				String C3 = "SELECT DTL_SA_FROM, DTL_SA_TO FROM PM_IL_DOC_TODO_LIST WHERE DTL_DS_TYPE = '1' AND "
						+ "DTL_DS_CODE = 'ZB-PRO' AND UPPER(DTL_TODO_LIST_ITEM) LIKE '%FINANCIAL Q%'";
				resultset2 = handler1.executeSelectStatement(C3, conn, new Object[] {});
				while (resultset2.next()) {
					DTL_SA_FROM = resultset2.getDouble(1);
					DTL_SA_TO = resultset2.getDouble(2);
					System.out.println("Sum Assured From ::::" + DTL_SA_FROM);
					System.out.println("Sum Assured To ::::" + DTL_SA_TO);

				}

				String C4 = "SELECT DTL_SA_FROM, DTL_SA_TO FROM PM_IL_DOC_TODO_LIST WHERE DTL_DS_TYPE = '1' AND "
						+ "DTL_DS_CODE = 'ZB-PRO' AND UPPER(DTL_TODO_LIST_ITEM) LIKE '%FINANCIAL S%'";
				resultset3 = handler1.executeSelectStatement(C4, conn, new Object[] {});
				while (resultset3.next()) {
					SA_FROM = resultset3.getDouble(1);
					SA_TO = resultset3.getDouble(2);
					System.out.println("SA From ::::" + SA_FROM);
					System.out.println("SA To ::::" + SA_TO);

				}

				String P_CUST_TYPE = " ";
				double SUM_ASSURED = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_FC_SUM_ASSURED();
				System.out.println("SUM_ASSURED-->" + SUM_ASSURED + "]");
				// modified by gopi for null point handling and toi on 16/06/18
				if (DTL_SA_FROM != null && DTL_SA_TO != null && SUM_ASSURED != 0.0) {
					if (("Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) && (SUM_ASSURED > DTL_SA_FROM)
							&& (SUM_ASSURED < DTL_SA_TO)) {
						String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(product_code, "FIN1",
								String.valueOf(pol_sys_id), "C", "");
						;
						msg1 = msg1 + emailStatusMessage;
						System.out.println("Mail information msg1-->" + msg1);

					}
				}
				if (SA_FROM != null && SA_TO != null && SUM_ASSURED != 0.0) {
					if (("Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) && (SUM_ASSURED > SA_FROM)
							&& (SUM_ASSURED < SA_TO)) {
						String emailStatusMsg = Email_Procedure_Call.emailStatusMsg(product_code, "FIN2",
								String.valueOf(pol_sys_id), "C", "");
						;
						msg2 = msg2 + emailStatusMsg;
						System.out.println("Mail information msg2-->" + msg2);

					}
				}
				/* End */

				/* End of ZBILQC-1732136 */

			}

			/* End */

			/*
			 * Added by Ameen on 24-07-2017 for ZBILQC-1720395 as per
			 * Chandramohan sugg.
			 */
			if ("Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
				new P9ILPK_POLICY().INS_MEDEX_FEE_DTL(CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()));
			}
			/* End */

			/* Added by ganesh on 19-09-2017 for ZBILQC-1732146 */
			String futureDateMailMsg = "";
			if (("Y".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG(), "X"))
					&& CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_START_DT(), new Date()).after(new Date()))) {

				futureDateMailMsg = Email_Procedure_Call.emailStatusDynamicMsg(PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
						"FDI", PT_IL_POLICY_BEAN.getPOL_SYS_ID().toString(), "C", "");
				System.out.println(futureDateMailMsg);

			}

			System.out.println("getPOL_LC_SUM_ASSURED         " + PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED()
					+ "     getPOL_FC_SUM_ASSURED     " + PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED());

			// PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED());

			// setBlockFlag(false);

			/* added by gopi for toi on 14/06/2018 */
			String pol_frz_flag = PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG();
			/* Commented by sivarajan already above used on this variable */
			// String policy_aaprove=getPolicyApprove();
			/* End */
			if (pol_frz_flag != null && "Y".equalsIgnoreCase(pol_frz_flag)) {
				if (policy_aaprove != null && "O".equalsIgnoreCase(policy_aaprove)) {
					System.out.println("P9ILPK_POLICY_NR().P_POLICY_APPROVAL PROCEDURE EXECUTED SUCCESSFULLY");
					new P9ILPK_POLICY_NR().P_POLICY_APPROVAL(PT_IL_POLICY_BEAN.getPOL_SYS_ID());
				}

			}
			// end
			/* Added by Ameen on 13-07-2018 for TOI as per Ajay sugg. */
			if ("O".equalsIgnoreCase(P_PROD_POL_APPROVAL_YN)) {
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().postRecord(null);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().saveRecord();
			}
			/* End */
			/* Added by pidugu raj dt:04-09-2018 for KICLIFEQC-1763231 */
			PM_IL_PLAN planObj = helper.doGetPlanType(
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE());

			if (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG()
					.equalsIgnoreCase("Y")) {
				double fundAllocatedPercentageTotal = 0.00;
				String liqVariable = "liquidNotPresent";
				for (PT_IL_POL_FUND_DTL fund : compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
						.getDataList_PT_IL_POL_FUND_DTL()) {
					fundAllocatedPercentageTotal = fundAllocatedPercentageTotal + fund.getPOFD_FUND_PERC();

					if (fund.getPOFD_FUND_CODE().equalsIgnoreCase("LIQUID FUND")) {
						liqVariable = "liquidPresent";
					}
				}
				if (fundAllocatedPercentageTotal != 100.00 && (liqVariable.equalsIgnoreCase("liquidPresent"))
						&& planObj.getPLAN_TYPE().equals("U")) {
					throw new Exception("Kindly add fund details with 100 % allocation");
				} else if (fundAllocatedPercentageTotal == 100.00 && liqVariable.equalsIgnoreCase("liquidNotPresent")
						&& planObj.equals("U")) {
					/*
					 * Modified by pidgu raj dt: 09-10-2018 for kic as suggested
					 * by vijay and sivaraman throw new
					 * Exception("Kindly add 15% for liquid fund in fund details"
					 * );
					 */
					String IL_FUND_VAL = CommonUtils.getPPSystemParameterValue("IL_FUND_VAL").toString();
					int fundParameterValue = Integer.valueOf(IL_FUND_VAL);
					throw new Exception("Kindly add " + fundParameterValue + "% for liquid fund in fund details");
					/* End */
				} else if (fundAllocatedPercentageTotal != 100.00 && liqVariable.equalsIgnoreCase("liquidNotPresent")
						&& planObj.equals("U")) {
					/*
					 * Modified by pidgu raj dt: 09-10-2018 for kic as suggested
					 * by vijay and sivaraman throw new
					 * Exception("Kindly add 15% for liquid fund in fund details"
					 * );
					 */
					String IL_FUND_VAL = CommonUtils.getPPSystemParameterValue("IL_FUND_VAL").toString();
					int fundParameterValue = Integer.valueOf(IL_FUND_VAL);
					throw new Exception("Kindly add " + fundParameterValue + "% for liquid fund in fund details");
					/* End */
				}
			}

			/* End Added by pidugu raj dt:04-09-2018 for KICLIFEQC-1763231 */

			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message + futureDateMailMsg);
			getWarningMap().put("SAVE_RECORD", message + futureDateMailMsg);
			/* end */

		} catch (Exception e) {
			e.printStackTrace();
			String error = ErrorHelpUtil.getUserErrorMessageFromDBErrorMessage(e.getMessage());

			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, error);
			getErrorMap().put("SAVE", error);

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

	public void setListPOL_MED_FEE_RECOVER_YN(List<SelectItem> listPOL_MED_FEE_RECOVER_YN) {
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

	public List<SelectItem> getlistPOL_STD_SUBSTD() {
		if (listPOL_STD_SUBSTD.size() == 0) {
			listPOL_STD_SUBSTD.clear();
			try {
				listPOL_STD_SUBSTD = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOL_STD_SUBSTD;
	}

	public void setlistPOL_STD_SUBSTD(List<SelectItem> listPOL_STD_SUBSTD) {
		this.listPOL_STD_SUBSTD = listPOL_STD_SUBSTD;
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

	public void setListPOL_HOME_OWNER_FLAG(List<SelectItem> listPOL_HOME_OWNER_FLAG) {
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

	public void setListPOL_INCORPORATED_YN(List<SelectItem> listPOL_INCORPORATED_YN) {
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

	public void setListPOL_RATE_APPLIED_ON(List<SelectItem> listPOL_RATE_APPLIED_ON) {
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

	public void setListPOL_ORG_PROP_RECV_YN(List<SelectItem> listPOL_ORG_PROP_RECV_YN) {
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

	public void setListPOL_TARIFF_TERM_FLAG(List<SelectItem> listPOL_TARIFF_TERM_FLAG) {
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

	public void fireFieldValidationType(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		// ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/* Added by Ameen on 19-04-2018 for KIC */
	public void fireFieldValidationFrzFlag(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String frzVal = (String) input.getSubmittedValue();
		System.out.println("inside fireFieldValidationFrzFlag frzVal >>>> " + frzVal);
		if (frzVal != null && !frzVal.equalsIgnoreCase("Y")) {
			/*
			 * Newly Added By Dhinesh on 11.8.2017 for ssp call id :
			 * ZBILQC-1733134
			 */
			PT_IL_POLICY_BEAN.setPOL_FLEX_20(null);
			/* End */
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	/* End */

	/* Added by saritha on 14-Jun-2017 for ssp call id ZBILQC-1720514 */
	public void emp_codefireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		HashMap<String, String> dynamicLabelMap = new HashMap<String, String>();
		dynamicLabelMap.put(input.getId(), COMP_POL_EMPLOYER_CODE_LABEL.getValue().toString());
		ErrorHelpUtil.validate(input, getErrorMap(), dynamicLabelMap);
	}
	/* End */

	/* added by krithikia on 15.4.15 */

	private HtmlCommandLink COMP_POL_PRINT;
	private HtmlCommandButton COMP_POL_PRINT1;

	public HtmlCommandLink getCOMP_POL_PRINT() {
		return COMP_POL_PRINT;
	}

	public void setCOMP_POL_PRINT(HtmlCommandLink cOMP_POL_PRINT) {
		COMP_POL_PRINT = cOMP_POL_PRINT;
	}

	public HtmlCommandButton getCOMP_POL_PRINT1() {
		return COMP_POL_PRINT1;
	}

	public void setCOMP_POL_PRINT1(HtmlCommandButton cOMP_POL_PRINT1) {
		COMP_POL_PRINT1 = cOMP_POL_PRINT1;
	}

	public String flagAction() {
		String value = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG();
		System.out.println(" value inside  if NO2 " + value);
		boolean printBtnFlag = printEnableDisable();
		/*
		 * condition modified by Ameen on 18-07-2017 for ZBILQC-1731923 as per
		 * Siva sugg. if(value.equals("Y")){
		 */
		try {
			/*
			 * if("1".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
			 * getPT_IL_POLICY_BEAN().getPOL_DS_TYPE())){
			 */
			if (value.equals("Y") && printBtnFlag) {
				System.out.println(" inside DS = 1 if FRZ = Y ");
				// COMP_POL_PRINT.setDisabled(false);
				// COMP_POL_PRINT1.setDisabled(false);
				COMP_POL_RES_EMAIL_ID.setDisabled(true);

			} else {
				System.out.println(" inside DS = 1 if FRZ = N ");
				/* added by gopi for toi on 14/06/2018 */

				String policy_aaprove = getPolicyApprove();
				String prem_cal_flag = PT_IL_POLICY_BEAN.getPOL_FLEX_20();
				String po_addl_status = PT_IL_POLICY_BEAN.getPOL_ADDL_STATUS();
				if (policy_aaprove != null && "O".equalsIgnoreCase(policy_aaprove)) {
					if (prem_cal_flag != null && "Y".equalsIgnoreCase(prem_cal_flag)) {
						if (po_addl_status != null && "001".equalsIgnoreCase(po_addl_status)) {
							COMP_POL_PRINT.setDisabled(false);
							COMP_POL_PRINT1.setDisabled(false);
						} else {
							COMP_POL_PRINT.setDisabled(false);
							COMP_POL_PRINT1.setDisabled(false);
						}

					} else {
						/*
						 * COMP_POL_PRINT.setDisabled(true);
						 * COMP_POL_PRINT1.setDisabled(true);
						 */
					}
				} else {

					/*
					 * COMP_POL_PRINT.setDisabled(true);
					 * COMP_POL_PRINT1.setDisabled(true);
					 */
					COMP_POL_RES_EMAIL_ID.setDisabled(false);
				}

			}
			/*
			 * }else{ //if(value.equals("Y") &&
			 * "A".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN(
			 * ).getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS())){
			 * if(value.equals("Y") && printBtnFlag){
			 * System.out.println(" inside DS = 2 if FRZ = Y ");
			 * COMP_POL_PRINT.setDisabled(false);
			 * COMP_POL_PRINT1.setDisabled(false);
			 * COMP_POL_RES_EMAIL_ID.setDisabled(true);
			 * 
			 * }else { System.out.println(" inside DS = 2 if FRZ = N ");
			 * COMP_POL_PRINT.setDisabled(true);
			 * COMP_POL_PRINT1.setDisabled(true);
			 * COMP_POL_RES_EMAIL_ID.setDisabled(false);
			 * 
			 * } }
			 */
			// return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	// end

	/* Added by Janani on 13.8.2016 for IC no length issue */

	public int ICnoLength() {
		System.out.println("enters into ICnoLength");

		int M_PS_VALUE = 0;
		try {
			String query = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'CUSTREFFMT'";
			ResultSet resultSet = null;

			CRUDHandler handler = new CRUDHandler();
			CommonUtils commonUtils = new CommonUtils();
			Connection connection = null;

			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);

			while (resultSet.next()) {
				M_PS_VALUE = resultSet.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return M_PS_VALUE;
	}

	/* end */
	/*
	 * Added by saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan
	 * COMMENTS on 26-01-2017
	 */
	private HtmlOutputLabel COMP_POL_BNF_ESC_PERC_LABEL;
	/* modified by Ameen on 25-10-2019 for SARWA as sugg. by Sivaram */
	/* private HtmlSelectOneMenu COMP_POL_BNF_ESC_PERC; */
	private HtmlInputText COMP_POL_BNF_ESC_PERC;

	private HtmlOutputLabel COMP_POL_ANN_PAY_PERIOD_LABEL;

	private HtmlSelectOneMenu COMP_POL_ANN_PAY_PERIOD;

	private List<SelectItem> listPOL_BNF_ESC_PERC = new ArrayList<SelectItem>();

	private List<SelectItem> listPOL_ANN_PAY_PERIOD = new ArrayList<SelectItem>();

	public List<SelectItem> getListPOL_BNF_ESC_PERC() {
		return listPOL_BNF_ESC_PERC;
	}

	public void setListPOL_BNF_ESC_PERC(List<SelectItem> listPOL_BNF_ESC_PERC) {
		this.listPOL_BNF_ESC_PERC = listPOL_BNF_ESC_PERC;
	}

	public List<SelectItem> getListPOL_ANN_PAY_PERIOD() {
		return listPOL_ANN_PAY_PERIOD;
	}

	public void setListPOL_ANN_PAY_PERIOD(List<SelectItem> listPOL_ANN_PAY_PERIOD) {
		this.listPOL_ANN_PAY_PERIOD = listPOL_ANN_PAY_PERIOD;
	}

	public HtmlOutputLabel getCOMP_POL_BNF_ESC_PERC_LABEL() {
		return COMP_POL_BNF_ESC_PERC_LABEL;
	}

	public void setCOMP_POL_BNF_ESC_PERC_LABEL(HtmlOutputLabel cOMP_POL_BNF_ESC_PERC_LABEL) {
		COMP_POL_BNF_ESC_PERC_LABEL = cOMP_POL_BNF_ESC_PERC_LABEL;
	}

	public HtmlInputText getCOMP_POL_BNF_ESC_PERC() {
		return COMP_POL_BNF_ESC_PERC;
	}

	public void setCOMP_POL_BNF_ESC_PERC(HtmlInputText cOMP_POL_BNF_ESC_PERC) {
		COMP_POL_BNF_ESC_PERC = cOMP_POL_BNF_ESC_PERC;
	}

	public HtmlOutputLabel getCOMP_POL_ANN_PAY_PERIOD_LABEL() {
		return COMP_POL_ANN_PAY_PERIOD_LABEL;
	}

	public void setCOMP_POL_ANN_PAY_PERIOD_LABEL(HtmlOutputLabel cOMP_POL_ANN_PAY_PERIOD_LABEL) {
		COMP_POL_ANN_PAY_PERIOD_LABEL = cOMP_POL_ANN_PAY_PERIOD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_ANN_PAY_PERIOD() {
		return COMP_POL_ANN_PAY_PERIOD;
	}

	public void setCOMP_POL_ANN_PAY_PERIOD(HtmlSelectOneMenu cOMP_POL_ANN_PAY_PERIOD) {
		COMP_POL_ANN_PAY_PERIOD = cOMP_POL_ANN_PAY_PERIOD;
	}

	/* End */

	public void onLoad(PhaseEvent event) {
		try {
			PILT002_APAC_HELPER pilt002_apac_helper = new PILT002_APAC_HELPER();
			doBackButDisable();

			/* Added by Janani on 13.03.2018 for FSD_FLA_IL_008 */

			checkEndCode();

			/* End of FSD_FLA_IL_008 */

			/*
			 * String isprmcalc =
			 * CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.ISPRMCALC")
			 * ,null);
			 * 
			 * if("TRUE".equalsIgnoreCase(isprmcalc)) { System.out.
			 * println("******** INSIDE THE isprmcalc IF BLOCK ********* ");
			 * System.out.println("*5555*");
			 * compositeAction.getDUMMY_ACTION_BEAN().
			 * getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(true); }
			 */
			/* ADDED BY RAJA ON 15-03-2017 */
			if (CommonUtils.getGlobalVariable("GLOBAL.CALL_QUERY") != null
					&& CommonUtils.getGlobalVariable("GLOBAL.CALL_QUERY").equalsIgnoreCase("QUERY")) {
				System.out.println("CALL_QUERY  ==== > " + CommonUtils.getGlobalVariable("GLOBAL.CALL_QUERY"));
				System.out.println("POL_ROW_ID  ==== > " + CommonUtils.getGlobalVariable("GLOBAL.POL_ROW_ID"));
				PT_IL_POLICY_BEAN.setROWID(CommonUtils.getGlobalVariable("GLOBAL.POL_ROW_ID"));
				setBlockFlag(true);
			}

			/* end */

			if (isFormFlag()) {
				// CommonUtils.clearMaps(this);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().clear();
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().clear();
				CommonUtils.setGlobalVariable("GLOBAL.CUSTCODE", null);
				CommonUtils.setGlobalVariable("GLOBAL.REFID", null);
				CommonUtils.setGlobalVariable("GLOBAL.CONT_CODE", null);
				/*
				 * Added by Ameen on 20-04-2018 for KIC ,customer and assrd.
				 * same scenario
				 */
				CommonUtils.setGlobalVariable("GLOBAL.REFID2", null);
				CommonUtils.setGlobalVariable("GLOBAL.CONTCODE", null);
				/* End */

				/* Added by Janani on 13.8.2016 for IC no length issue */

				int fieldLength = 0;
				int PS_VALUE = (int) CommonUtils.getGlobalObject("M_PS_VALUE");
				fieldLength = (int) CommonUtils.getGlobalObject("FIELD_LENGTH");
				System.out.println("fieldLength         " + fieldLength);

				if (PS_VALUE == 1) {
					System.out.println("enters into PS_VALUE == 1");
					// compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_REF_ID1().setMaxlength(12);
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_REF_ID1().setMaxlength(fieldLength);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_ASSRD_REF_ID1().setMaxlength(fieldLength);
				} else if (PS_VALUE == 2) {
					System.out.println("enters into PS_VALUE == 2");
					// compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_REF_ID1().setMaxlength(24);
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_REF_ID1().setMaxlength(fieldLength);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_ASSRD_REF_ID1().setMaxlength(fieldLength);
				}

				/* end */

				pilt002_apac_helper.setLabel(compositeAction);
				pilt002_apac_helper.PRE_FORM(compositeAction);
				pilt002_apac_helper.PILT002_APAC_WHEN_NEW_FORM_INSTANCE(compositeAction);
				decideCaptionOfWizard();
				// compositeAction.getTabbedBar().getTabById(compositeAction.TAB_PT_IL_POLICY).setTabName(this.getCOMP_FORM_CAPTION().getValue().toString()
				// );

				/* added by janani */

				/*
				 * if(isPremium_Brk_Flag()==false){
				 * compositeAction.getWizard().disableWizardItem(
				 * "PILT002_APAC_PT_IL_PREM_DTLS"); }else {
				 * compositeAction.getWizard().enableWizardItem(
				 * "PILT002_APAC_PT_IL_PREM_DTLS"); }
				 */

				/*
				 * if(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS().equalsIgnoreCase(
				 * "A")&&PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG().equalsIgnoreCase(
				 * "Y")) { System.out.println("inside prem dtls enable");
				 * compositeAction.getWizard().enableWizardItem(
				 * "PILT002_APAC_PT_IL_PREM_DTLS"); }
				 */
				if (PT_IL_POLICY_BEAN.getPOL_PROD_CODE() != null) {
					System.out.println("POL_PROD_CODE value :" + PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
					if (PT_IL_POLICY_BEAN.getPOL_PROD_CODE().equalsIgnoreCase("WNS")) {
						getCOMP_POL_PREM_OPTION_CODE().setRequired(true);
					} else {
						getCOMP_POL_PREM_OPTION_CODE().setRequired(false);
					}
				}
				/* end */

				setFormFlag(false);
			}
			System.out.println("isBlockFlag()     " + isBlockFlag());
			if (isBlockFlag()) {

				/* Modified by Saranya on 28/03/2017 for RI Allocation */
				/*
				 * Added by saritha on 11-01-2017 for Payer Details Height and
				 * Weight &BMI is Mantatory
				 */
				PT_IL_POL_ASSURED_DTLS_ACTION pt_il_assued_action = compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
				/* End */
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_REPORT_MODAL_PANEL_ASSURED()
						.setRendered(true);
				// compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(true);
				/* End */

				/*
				 * Added by R. Raja on 20-12-2016 for RM018T - FSD_IL_ZB
				 * Life_002-Customer Master Changes COMMENTS
				 */

				int param_type_address = 0;
				String query = "SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_ADDR_DISP' AND PS_CODE = 'IL_ADDR_DISP'";
				ResultSet rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
				while (rs.next()) {
					param_type_address = rs.getInt("PS_VALUE");
				}
				if (param_type_address == 2) {
					COMP_ADDRESS.setRendered(false);
				} else {
					COMP_ADDRESS.setRendered(true);
					/*
					 * Added by saritha on 13-04-2018 for KIC Customer address
					 * Details to defalut policy level address
					 */
					COMP_ADDRESS.setLabel("Communication Address");
					COMP_POL_OFF_ADDRESS.setRendered(false);
					/* End */

				}

				/* end */

				helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				helper.PRE_QUERY(PT_IL_POLICY_BEAN);
				helper.executeQuery(compositeAction);

				/*
				 * added by raja on 17-08-2017 for RI page policy no getting
				 * existing policy
				 */

				CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", PT_IL_POLICY_BEAN.getPOL_NO());
				CommonUtils.setGlobalVariable("GLOBAL.M_POL_CONT_CODE", PT_IL_POLICY_BEAN.getPOL_CONT_CODE());
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().disableAllComponent(true);

				/* end */

				/*
				 * Newly Added By Dhinesh on 30-04-2018 for policy owner id
				 * issue
				 */
				CommonUtils.setGlobalVariable("GLOBAL.M_POL_ASSRD_REF_ID1", PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1());
				CommonUtils.setGlobalVariable("GLOBAL.M_POL_ASSRD_REF_ID2", PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2());
				/* End */

				/* Added by R. Raja on 18-04-2017 */
				/*
				 * if(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()!=null &&
				 * PT_IL_POLICY_BEAN.getPOL_DS_TYPE().equalsIgnoreCase("1")) {
				 * COMP_POL_CUST_CODE_LABEL.setValue("Proposer Code"); } else {
				 * COMP_POL_CUST_CODE_LABEL.setValue("Policy Holder Code"); }
				 */

				/*
				 * Commented by ganesh on 28-07-2017,ZBILQC-1731155 as suggested
				 * by siva sir changed statically
				 */
				/*
				 * Added by saritha on 14-May-2017 for ssp call id
				 * ZBILQC-1724959
				 */
				/*
				 * if((PT_IL_POLICY_BEAN.getROWID()==null)||(PT_IL_POLICY_BEAN.
				 * getPOL_DS_TYPE().equalsIgnoreCase("1"))) {
				 * COMP_POL_CUST_CODE_LABEL.setValue("Proposer Code"); } else
				 * if(PT_IL_POLICY_BEAN.getPOL_DS_TYPE().equalsIgnoreCase("2"))
				 * { COMP_POL_CUST_CODE_LABEL.setValue("Policy Holder Code"); }
				 */

				/* end */
				/* end */

				/*
				 * else
				 * {//if("N".equals(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())){
				 * compositeAction.getDUMMY_ACTION_BEAN().
				 * getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled( false);
				 * disableAllComponent(false); }
				 */
				helper.PRE_RECORD(compositeAction);
				// helper.dummyButtonEnableDisable(compositeAction.getDUMMY_ACTION_BEAN());
				System.out.println("PT_IL_POLICY_BEAN.getROWID()     " + PT_IL_POLICY_BEAN.getROWID());
				if (PT_IL_POLICY_BEAN.getROWID() != null) {
					helper.PRE_QUERY(PT_IL_POLICY_BEAN);
					helper.executeQuery(compositeAction);
					defaultMICRDetails();
					/*
					 * added by gopi for RM018T - DEV_IL_ZB Life_022-Automated
					 * Premium Loan ON 06/01/17
					 */
					String pol_apl_flag = POl_APL();
					if (pol_apl_flag != null) {
						if (pol_apl_flag.equalsIgnoreCase("N")) {
							COMP_PROD_INS_APL_YN.setDisabled(true);
						}
					}

					helper.POST_QUERY(compositeAction);
					helper.onPopulateDetails(compositeAction);
					int param = 0;
					if (compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN()
							.getPOAD_AGE() != null) {

						String Query = "SELECT PARA_VALUE FROM PCOM_APP_PARAMETER WHERE PARA_CODE LIKE 'IL_END_LOGIC'";
						ResultSet rsEndo = new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection());
						while (rsEndo.next()) {
							PT_IL_POLICY_BEAN.setPOL_ENDO_PARAM(rsEndo.getInt(1));

						}

						if (PT_IL_POLICY_BEAN.getPOL_ENDO_PARAM() == 1) {
							PT_IL_POLICY_BEAN.setUI_M_MAT_AGE(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
									.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE() + PT_IL_POLICY_BEAN.getPOL_PERIOD()
									+ CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_ORG_PERIOD(), 0));
						} else {
							PT_IL_POLICY_BEAN.setUI_M_MAT_AGE(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
									.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE()
									+ PT_IL_POLICY_BEAN.getPOL_PERIOD());
						}
					}

					/* Added by Janani on 08.06.2017 for ZBILQC-1727538 */

					System.out.println("getPOL_DS_TYPE                :"
							+ compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE());
					System.out.println("getPOL_APPRV_STATUS                :" + compositeAction
							.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS());
					System.out.println("getUI_M_POL_PLAN_TYPE                :"
							+ compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_POL_PLAN_TYPE());

					/* handled nvl by ganesh on 05-07-2017,ZBILQC-1718714 */
					if (CommonUtils
							.nvl(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_POL_PLAN_TYPE(), "X")
							.equalsIgnoreCase("u")
							&& compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE()
									.equals("2")
							&& compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
									.getPOL_APPRV_STATUS().equalsIgnoreCase("a")) {

						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_FUND_QUERY().setDisabled(false);
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_FUND_QUERY().setRendered(true);
					} else {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_FUND_QUERY().setRendered(false);
					}

					/* End */

				} else {
					helper.WHEN_CREATE_RECORD(compositeAction);

					/*
					 * Added By Dhinesh for ssp call id FALCONLIFE_1349311 on
					 * 19.10.2016
					 */

					validatePOL_ISSUE_DT(compositeAction);

					/* End */

					/*
					 * added by raja on 05-03-2017 for ssp call id -
					 * ZBILQC-1719062
					 */
					int param_type_Cust = 0;
					String queryCust = "SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_CUST_PROP' AND PS_CODE = 'IL_CUST_PROP'";
					ResultSet rsCust = new CRUDHandler().executeSelectStatement(queryCust, CommonUtils.getConnection());
					while (rsCust.next()) {
						param_type_Cust = rsCust.getInt("PS_VALUE");
					}
					if (param_type_Cust == 2) {
						COMP_CUST_BUTTON.setDisabled(true);
						COMP_CUST_COMMAND_LINK.setDisabled(true);
						COMP_ASSU_BUTTON.setDisabled(true);
						COMP_ASSU_COMMAND_LINK.setDisabled(true);
					} else {
						COMP_CUST_BUTTON.setDisabled(false);
						COMP_CUST_COMMAND_LINK.setDisabled(false);
						COMP_ASSU_BUTTON.setDisabled(false);
						COMP_ASSU_COMMAND_LINK.setDisabled(false);
					}

					/* end */

					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_EMR_RATE(0.000);
					// pilt002_apac_helper.PILT002_APAC_WHEN_NEW_FORM_INSTANCE(compositeAction);

					/* Added by Janani on 08.06.2017 for ZBILQC-1727538 */

					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_FUND_QUERY().setRendered(false);

					/* End */

					/* Added by Ameen on 09-03-2018 for FSD_IL_04_GOLDA */
					PT_IL_POLICY_BEAN.setPOL_RETURN_VAL("N");
					/* End */

				}
				// disable save button after approval

				// added by akash to solve the altertion of term endorsment
				// issue

				/*
				 * if(!"000".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.
				 * getPOL_END_TYPE(),"000") )){
				 * if(!"012".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE()) ){
				 * COMP_POL_PERIOD.setDisabled(true);
				 * ///COMP_POL_PREM_PAY_YRS.setDisabled(true); }else{
				 * PT_IL_POLICY_BEAN.setPOL_PERIOD(0); } }
				 */
				System.out.println("******* Dhinesh *******");
				// quickCustomerDefault();
				System.out.println("******* Dhinesh *******");
				helper.disableMortageTabs(this);
				/* KIC condition added by Ameen on 19-01-2018 */
				/*
				 * if(!"KIC/".equalsIgnoreCase(CommonUtils.getGlobalVariable(
				 * "GLOBAL.SITE_CODE"))) {
				 */
				/*
				 * Added by saranya on 07-12-2016 for RM018T - FSD_IL_ZB
				 * Life_013_Underwriting changes
				 */
				/*
				 * if("075".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_SRC_OF_BUS
				 * ()) &&
				 * !"KIC/".equalsIgnoreCase(CommonUtils.getGlobalVariable(
				 * "GLOBAL.SITE_CODE")))
				 *//*
					 * KIC condition handled by Ameen on 26-03-2018 for agent
					 * prem. less thencalculated prem. error not to come in KIC
					 */
				if ("075".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_SRC_OF_BUS())
						&& !CommonUtils.isIN(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE"), "KIC/", "TOI/")) {
					// compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FC_AGENT_PREM().setRequired(true);
					// compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LC_AGENT_PREM().setRequired(true);
					COMP_POL_FC_AGENT_PREM.setRequired(true);
					COMP_POL_LC_AGENT_PREM.setRequired(true);

				} else {
					// compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FC_AGENT_PREM().setRequired(false);
					// compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LC_AGENT_PREM().setRequired(false);
					COMP_POL_FC_AGENT_PREM.setRequired(false);
					COMP_POL_LC_AGENT_PREM.setRequired(false);
				}
				// }
				/* End */
				/*
				 * added by saranya on 20-12-2016 for RM018T - FSD_IL_ZB
				 * Life_016-Queried Proposals v1.0
				 */
				System.out.println("POL_DS_TYPE   :"
						+ compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE());
				/*
				 * if("2".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
				 * getPT_IL_POLICY_BEAN().getPOL_DS_TYPE())) {
				 * COMP_POL_CANCEL_YN.setDisabled(false); } else {
				 * COMP_POL_CANCEL_YN.setDisabled(true); }
				 */
				System.out.println("PT_IL_POLICY_BEAN.getPOL_NO():" + PT_IL_POLICY_BEAN.getPOL_NO());
				if ((PT_IL_POLICY_BEAN.getPOL_DS_TYPE().equals("1")) && (PT_IL_POLICY_BEAN.getPOL_NO() != null)
						&& (PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG().equals("N"))) {
					COMP_POL_CANCEL_YN.setDisabled(false);
				} else {
					COMP_POL_CANCEL_YN.setDisabled(true);
				}
				/* End */

				/*
				 * Added by saritha on 31-01-2017 for Source Of Business default
				 * Broker/Agent
				 */
				Connection connection = null;
				ResultSet resultset = null;
				connection = CommonUtils.getConnection();
				String PC_DESC = null;
				CRUDHandler handler = new CRUDHandler();

				if (PT_IL_POLICY_BEAN.getROWID() == null) {

					Object POL_SRC_OF_BUS_Obj = CommonUtils.getPPSystemParameterValue("IL_POLSRCBUS");
					BigDecimal POL_SRC_FLAG = null;
					if (POL_SRC_OF_BUS_Obj != null) {
						POL_SRC_FLAG = (BigDecimal) POL_SRC_OF_BUS_Obj;
					}
					System.out.println("POL_SRC_FLAG         " + POL_SRC_FLAG);
					if (POL_SRC_FLAG != null && POL_SRC_FLAG.intValue() == 1) {
						System.out.println("Source of Business is default");
						PT_IL_POLICY_BEAN.setPOL_SRC_OF_BUS("075");
					} else {// else added by Ameen on 13-07-2018 as per Ajay
							// sugg.
						PT_IL_POLICY_BEAN.setPOL_SRC_OF_BUS("001");
					}

					String C1 = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND PC_CODE=?";
					System.out.println("source of business" + PT_IL_POLICY_BEAN.getPOL_SRC_OF_BUS());
					resultset = handler.executeSelectStatement(C1, connection,
							new Object[] { PT_IL_POLICY_BEAN.getPOL_SRC_OF_BUS() });
					while (resultset.next()) {
						PC_DESC = resultset.getString("PC_DESC");
						System.out.println("Value Of PC_DESC ***********" + PC_DESC);
					}
					PT_IL_POLICY_BEAN.setUI_M_POL_SRC_OF_BUS_DESC(PC_DESC);
					COMP_POL_SRC_OF_BUS.resetValue();
					COMP_UI_M_POL_SRC_OF_BUS_DESC.resetValue();
					/*
					 * Added saranya for RM018T - FSD_IL_ZB Life_001-Education
					 * Endowment Plan COMMENTS on 13-03-2017
					 */
					PT_IL_POLICY_BEAN.setPOL_BNF_ESC_PERC("0");
					PT_IL_POLICY_BEAN.setPOL_ANN_PAY_PERIOD("0");

					/* Modified by Janani on 08.06.2017 for ZBILQC-1728005 */

					// PT_IL_POLICY_BEAN.setPOL_UL_PREM_CALC("N");
					Unit_link_typ();

					System.out.println("getUnit_link_typ              " + getUnit_link_typ());

					/*
					 * Modified by Janani on 30.06.2018 for Fidelity as
					 * suggested by Vinoth
					 */
					/*
					 * if(!"NA".equalsIgnoreCase(getUnit_link_typ())) {
					 * PT_IL_POLICY_BEAN.setPOL_UL_PREM_CALC("A"); }
					 */

					/*
					 * modifeid by Ameen on 10-07-2018 as per Siva sugg.
					 * if(!"NA".equalsIgnoreCase(getUnit_link_typ())) {
					 * PT_IL_POLICY_BEAN.setPOL_UL_PREM_CALC("D"); } End else
					 * if("NA".equalsIgnoreCase(getUnit_link_typ())) {
					 * PT_IL_POLICY_BEAN.setPOL_UL_PREM_CALC("N"); }
					 */

					System.out.println(
							"POL_UL_PREM_CALC / GLOBAL.M_PARAM_8" + CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_8"));
					if (null != CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_8")) {
						PT_IL_POLICY_BEAN.setPOL_UL_PREM_CALC(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_8"));
					}

				}

				/* End */
				/*
				 * added by gopi for hands on feed back issue,serial no 18 in ZB
				 * on 31/01/17
				 */
				if ("1".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"))) {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_QUOT_NO_LABEL().setRendered(false);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_QUOT_NO().setRendered(false);
				} else {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_QUOT_NO_LABEL().setRendered(true);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_QUOT_NO().setRendered(true);
				}
				/* end */

				/*
				 * Added saranya for RM018T - FSD_IL_ZB Life_001-Education
				 * Endowment Plan COMMENTS on 13-03-2017
				 */
				/*
				 * Commented by Saranya on 07/04/2017
				 * 
				 * Unit_link_typ(); String Unit_link_typ= getUnit_link_typ();
				 * if(!"NA".equalsIgnoreCase(Unit_link_typ)) {
				 * COMP_POL_BNF_ESC_PERC.setDisabled(false);
				 * COMP_POL_ANN_PAY_PERIOD.setDisabled(false); }else{
				 * COMP_POL_BNF_ESC_PERC.setDisabled(true);
				 * COMP_POL_ANN_PAY_PERIOD.setDisabled(true); } End
				 */

				/* End */

				/*
				 * Added by saritha on 20-Jun-2017 for ssp call id
				 * ZBILQC-1720514
				 */

				if (PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG() != null
						&& PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG().equalsIgnoreCase("N")) {
					System.out.println("PYMT_TYPE  : "
							+ CommonUtils.isIN(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE(), "AD", "BS", "S", "AO"));

					/*
					 * Modified by Janani on 27.06.2018 for FLA as per
					 * Chandramohan sugges
					 */
					// if(CommonUtils.isIN(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE(),
					// "AD","BS","S"))

					if (CommonUtils.isIN(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE(), "AD", "BS", "S", "AO"))
					/* End */
					{
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_EMPLOYER_CODE().setDisabled(false);

					} else {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_EMPLOYER_CODE().setDisabled(true);
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_EMPLOYER_CODE(null);
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_EMPLOYER_CODE().resetValue();

					}

					if (CommonUtils.isIN(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE(), "AD", "BS")) {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_EMPLOYER_CODE_LABEL()
								.setValue("Bank Code");
					}

					/*
					 * Modified by Janani on 27.06.2018 for FLA as per
					 * Chandramohan sugges
					 */
					// else
					// if(CommonUtils.isIN(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE(),
					// "S"))

					else if (CommonUtils.isIN(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE(), "S", "AO"))
					/* End */
					{
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_EMPLOYER_CODE_LABEL()
								.setValue("Employer Code");

					}

					else {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_EMPLOYER_CODE_LABEL()
								.setValue("Employer/Bank Code");

					}
				}

				/* End */

				/*
				 * Added by saritha on 13-07-2017 for ssp call id ZBILQC-1731155
				 */

				if ((PT_IL_POLICY_BEAN.getROWID() == null)
						&& ("N".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG(), "N")))
						&& ("N".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(), "N")))) {

					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_HOLD().setDisabled(true);

				}
				/* End */

				/* Commented by kavitha on 02.08.2018 for KICLIFEQC-1759635 */
				/* setBlockFlag(false); */

				/* } */

				/* added by raja on 30-06-2017 ZBILQC-1730135 */
				getProd_plan_type();
				if (PLAN_TYPE.equalsIgnoreCase("L")) {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setRendered(false);
				}

				if (PLAN_TYPE.equalsIgnoreCase("U")) {
					String value = null;
					String Prod = "SELECT PROD_UNIT_LINK_TYPE FROM PM_IL_PRODUCT where prod_code=?";
					ResultSet rsProd = new CRUDHandler().executeSelectStatement(Prod, connection,
							new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
					while (rsProd.next()) {
						value = rsProd.getString("PROD_UNIT_LINK_TYPE");

						/* Added by Janani on 03.01.2018 for ZBLIFE-1467489 */
						PT_IL_POLICY_BEAN.setProd_unit_link_type(value);

						/* End of ZBLIFE-1467489 */

					}
					if (value != null && value.equalsIgnoreCase("NA")) {

						String Addcov = "select 'X' from PT_IL_POL_ADDL_COVER where POAC_POL_SYS_ID=?";
						ResultSet rsAddcov = new CRUDHandler().executeSelectStatement(Addcov, connection,
								new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
						if (rsAddcov.next()) {
							compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setRendered(false);
						} else {
							compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setRendered(true);
						}

					} else {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setRendered(true);
					}
				}

				/* end */

				/* ADDED BY RAJA ON 15-03-2017 */

				CommonUtils.setGlobalVariable("GLOBAL.CALL_QUERY", null);

				CommonUtils.setGlobalVariable("GLOBAL.POL_ROW_ID", null);

				/*
				 * Added by sankara narayanan for business rule issue on
				 * 04-03-2017
				 */
				/*
				 * String query13 =
				 * "  SELECT BREM_ERR_FLAG  FROM   PT_BUS_RULE_ERROR_MSG  WHERE  BREM_POL_SYS_ID  = ?   AND    "
				 * + "     BREM_APPLY_LEVEL =?  AND BREM_GRP_ID  = 'IL'";
				 */

				/*
				 * Modified by saritha on 25-07-2017 for ssp call id
				 * ZBILQC-1732436
				 */
				String busRuleQuery = "SELECT BREM_ERR_FLAG FROM PT_BUS_RULE_ERROR_MSG WHERE BREM_POL_SYS_ID = ? AND BREM_APPLY_LEVEL = ? AND "
						+ "BREM_GRP_ID = 'IL' AND BREM_APL_SCREEN ='T'";
				Object[] values = new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID(), "T" };
				ResultSet rs13 = new CRUDHandler().executeSelectStatement(busRuleQuery, CommonUtils.getConnection(),
						values);
				if (rs13.next()) {

					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUS_RUL().setDisabled(false);

				} else {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUS_RUL().setDisabled(true);
					/*
					 * dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(false);
					 */

				}
				/* end */

				/*
				 * Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB
				 * Life_015-Lapsation and commission clawback 2
				 */
				System.out.println("Endorsement Type" + PT_IL_POLICY_BEAN.getPOL_END_TYPE());
				System.out.println("Freeze Flag" + PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG());
				/* End */

				/*
				 * Newly Added By Dhinesh on 12-06-2017 for Change in lapsation
				 * Overriding Endorsement Issues
				 */

				/*
				 * Modified by saritha on 20-07-2017 for ssp call id
				 * ZBILQC-1732158
				 */
				if (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE()
						.equalsIgnoreCase("1")) {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(true);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setDisabled(true);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_FRM_DT().setDisabled(true);

				} else {

					/*
					 * Commented &Modified by saritha on 03-10-2017 for
					 * Lapsation Override
					 */
					/*
					 * if((("001".equalsIgnoreCase(PT_IL_POLICY_BEAN.
					 * getPOL_END_TYPE())) &&
					 * ("GEN008".equalsIgnoreCase(PT_IL_POLICY_BEAN.
					 * getPOL_END_CODE())))) {
					 */
					Lap_ovr_sys_param();
					if (("001".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE()))
							&& (PT_IL_POLICY_BEAN.getPOL_END_CODE()).equalsIgnoreCase(getLap_ovr_sys_param())) {
						/* End */

						System.out.println("inside freez............");

						/* Added by saritha on 08-09-2017 */

						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(false);
						if ("Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_LAPS_OVR_YN())) {

							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(false);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setDisabled(false);
							getCOMP_POL_LAPS_OVR_FRM_DT().setRequired(true);
							getCOMP_POL_LAPS_OVR_DT().setRequired(true);

						}

						else {
							// if(CommonUtils.nvl(PT_IL_POLICY_BEAN().getCOMP_POL_LAPS_OVR_YN(),"N").equalsIgnoreCase("N"))

							if ("N".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_LAPS_OVR_YN(), "N"))) {
								compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN()
										.setDisabled(true);
								compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT()
										.setDisabled(true);
								getCOMP_POL_LAPS_OVR_FRM_DT().setRequired(false);
								getCOMP_POL_LAPS_OVR_DT().setRequired(false);
								PT_IL_POLICY_BEAN.setPOL_LAPS_OVR_FRM_DT(null);
								COMP_POL_LAPS_OVR_FRM_DT.resetValue();
								PT_IL_POLICY_BEAN.setPOL_LAPS_OVR_TO_DT(null);
								COMP_POL_LAPS_OVR_DT.resetValue();
							}
						}
						/* End */

						if ("Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(true);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setDisabled(true);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_FRM_DT()
									.setDisabled(true);

						} else if ("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {

							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(false);
						}

					}

					else {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(true);

					}

				}
				/* End */

				String status = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS();
				System.out.println("status----->" + status);
				// uncommented the below 3 lines due to facing issue in RSA-DSA
				// print button not working.
				if (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID() != null) {
					System.out.println(
							"compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString()    : "
									+ compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
											.getPOL_SYS_ID().toString());
					CommonUtils.setGlobalVariable("GLOBAL.POL_SYS_ID", compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString());
					System.out.println(CommonUtils.getGlobalVariable("GLOBAL.POL_SYS_ID"));
				}

				// added by agalya for premiumn details link enable & disable on
				// 03-06-2016
				if (PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS().equalsIgnoreCase("A")
						&& PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG().equalsIgnoreCase("Y")) {
					compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_PREM_DTLS");
				}

				// Added by saranya for maturity link enable & disable on
				// 03-11-2016
				/*
				 * Modified by Saranya on 13-03-2017 for RM018T - FSD_IL_ZB
				 * Life_001-Education Endowment Plan COMMENTS
				 */
				getProd_plan_type();
				/* End */
				if ("U".equalsIgnoreCase(PLAN_TYPE)) {
					compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_SA_INST_PYMT_HEAD");
				} else {
					compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_SA_INST_PYMT_HEAD");
				}
				// END

				/*
				 * added by R. Raja for RM018T - FSD_IL_ZB Life_010-Maximum
				 * Funeral Benefit Limit
				 */

				/*
				 * Commenetd by Saranya on 11/04/2017 getProd_plan_type(); End
				 */

				/*
				 * cOMMENTED BY SANKARA NARAYANAN ON 23/04/2015
				 * 
				 * if("L".equalsIgnoreCase(PLAN_TYPE))
				 */

				/* Added by Janani on 18.04.2018 for Fidelity period calc */
				String PROD_RIDER_APPL_YN = getPlanType();
				System.out.println("PROD_RIDER_APPL_YN in onload               :" + PROD_RIDER_APPL_YN);
				/* End */

				if ("L".equalsIgnoreCase(PLAN_TYPE) || "H".equalsIgnoreCase(PLAN_TYPE)) {
					compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_FUNERAL_MEMB_DTLS");

					/* Added by Janani on 18.04.2018 for Fidelity period calc */
					if (PROD_RIDER_APPL_YN != null && PROD_RIDER_APPL_YN.equalsIgnoreCase("y")) {
						compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_ASSURED_DTLS");
					} else {
						/* End */

						/* Added by Shankar on 27/03/2017 */
						compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_ASSURED_DTLS");
						/* End */
					}

					if ("H".equalsIgnoreCase(PLAN_TYPE)) {
						compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_ASSR_ILLNESS_DTLS");
						compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_BENEFICIARY");
					}

				} else {

					addCoverRider();
					// End

					compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_FUNERAL_MEMB_DTLS");
					/* Added by Shankar on 27/03/2017 */
					compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_ASSURED_DTLS");
					compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_ASSR_ILLNESS_DTLS");
					compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_BENEFICIARY");
					/* End */
				}

				/* END */
				/*
				 * Added by saranya for RM018T - FSD_IL_ZB Life_001-Education
				 * Endowment Plan COMMENTS on 01-02-2017
				 * if(("U".equalsIgnoreCase(PLAN_TYPE)) &&
				 * (!"N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_BNF_ESC_PERC(
				 * )))) {
				 * PT_IL_POL_ESC_SA_ACTION_BEAN.getCOMP_UI_M_BUT_ANNU_ESC().
				 * setRendered(true); } else{
				 * PT_IL_POL_ESC_SA_ACTION_BEAN.getCOMP_UI_M_BUT_ANNU_ESC().
				 * setRendered(false); } End
				 */

				/* added by raja on 10-05-2017 */

				if (null == PT_IL_POLICY_BEAN.getPOL_FLEX_20() || PT_IL_POLICY_BEAN.getPOL_FLEX_20().isEmpty()
						|| "N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FLEX_20())) {

					compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_MED_EXAM_DTL");
				} else {
					compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_MED_EXAM_DTL");
				}

				/* end */

				if (PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS().equalsIgnoreCase("A")) {
					// compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_PREM_DTLS");
					COMP_SAVE_COMMAND_LINK.setDisabled(true);
					COMP_SAVE_BUTTON.setDisabled(true);
					COMP_SAVE_COMMAND_LINK2.setDisabled(true);
					COMP_SAVE_BUTTON2.setDisabled(true);
				} else {
					COMP_SAVE_COMMAND_LINK.setDisabled(false);
					COMP_SAVE_BUTTON.setDisabled(false);
					COMP_SAVE_COMMAND_LINK2.setDisabled(false);
					COMP_SAVE_BUTTON2.setDisabled(false);
				}
				helper.chkNormalOrPackagePolicy(this);
				helper.whenNewRecordInstance(compositeAction);
				checkPropOrPol();
				hideNonUlipItems(PT_IL_POLICY_BEAN);

				helper.enableDisableForAPLYN(compositeAction);

				// helper.memberEndosement(compositeAction);

				/* Added by Janani on 08.06.2017 for ZBILQC-1728005 */
				/* handled nvl by ganesh on 05-07-2017,ZBILQC-1718714 */
				if (CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_POL_PLAN_TYPE(), "X")
						.equalsIgnoreCase("u")) {
					System.out.println("plan type is U for disabling SA factor field");
					COMP_POL_NO_OF_UNIT.setDisabled(true);

				} else {
					COMP_POL_NO_OF_UNIT.setDisabled(false);
				}

				/* End */

				/*
				 * Added by saritha on 22-11-2017 for Due date for debit order
				 * by each policy is required
				 */

				/*
				 * Modified by Janani on 28.06.2018 for FLA as per Chandramohan
				 * sugges
				 */
				// if(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE()!=null &&
				// PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("AD"))

				if (PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE() != null
						&& (PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("AD") ||

								PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("AO")))
				/* End */

				{
					getCOMP_POL_DEBIT_DAY().setDisabled(false);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_DEBIT_DAY().setRequired(true);

				} else {
					getCOMP_POL_DEBIT_DAY().setDisabled(true);
					PT_IL_POLICY_BEAN.setPOL_DEBIT_DAY(null);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_DEBIT_DAY().setRequired(false);
				}
				/* End */
				/* Added by Ameen on 14-03-2018 for KIC */

				ResultSet excessRS = new CRUDHandler().executeSelectStatement(
						"SELECT PROD_REG_EXCESS_APP_YN,PROD_MAT_AMT_LEVEL FROM PM_IL_PRODUCT WHERE PROD_CODE = ?",
						CommonUtils.getConnection(), new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
				String excessYN = "N";
				String matAmtLevel = "C";
				if (excessRS.next()) {
					excessYN = excessRS.getString("PROD_REG_EXCESS_APP_YN");
					matAmtLevel = excessRS.getString("PROD_MAT_AMT_LEVEL");
				}

				if ("Y".equalsIgnoreCase(excessYN)) {
					COMP_POL_REG_EXCESS_PREM.setDisabled(false);
				} else {
					COMP_POL_REG_EXCESS_PREM.setDisabled(true);
				}

				if ("P".equalsIgnoreCase(matAmtLevel)) {
					COMP_POL_RETURN_VAL.setDisabled(false);
				} else {
					COMP_POL_RETURN_VAL.setDisabled(true);
				}

				/* End */

				if (!isEndorseFlag() || "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {

					enableDisableForApproveCondition();

				} else if (isEndorseFlag()) {
					System.out.println("*3333*");
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(false);
				}
				enableDisableRSA();
				// Added By Yalamanda for Quick Customer Creation (Customer code
				// default in policy level)

				System.out.println("default cust flag" + default_Cust_Flag);
				/* Commented By Dhinesh 9.6.2016 */
				// quickCustomerDefault();
				// End
				if (null == PT_IL_POLICY_BEAN.getPOL_FLEX_20() || PT_IL_POLICY_BEAN.getPOL_FLEX_20().isEmpty()
						|| "N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FLEX_20())) {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FRZ_FLAG().setDisabled(true);
				} else if (!"A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())) {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FRZ_FLAG().setDisabled(false);
				}

				if ("M".equalsIgnoreCase(
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_POL_PLAN_TYPE())) {
					// this.getCOMP_POL_FC_CURR_SA().setRendered(true);
					this.getCOMP_POL_FC_CURR_SA_LABEL().setValue("Reduced SA");

				} else {
					// this.getCOMP_POL_FC_CURR_SA().setRendered(false);
					this.getCOMP_POL_FC_CURR_SA_LABEL().setValue("Original SA");
				}

				if (!"1".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"))
						&& "A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())) {
					// PILT002_APAC_COMPOSITE_ACTION.DUMMY_ACTION_BEAN.COMP_UI_M_BUT_ENDT
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT().setDisabled(false);
				} else {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT().setDisabled(true);
				}

				if ("A".equalsIgnoreCase(
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_APPRV_STATUS())) {
					if (compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_POL_NO() == null) {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setDisabled(false);
					} else {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setDisabled(true);
					}
				}

				chkDthClaim(PT_IL_POLICY_BEAN.getPOL_NO());
				chkMaturedSts(PT_IL_POLICY_BEAN.getPOL_NO());
				/*
				 * As per Vinoth requirement, no need to display endorsment
				 * letter link in this screen. commented by ganesh on 21-07-2016
				 * 
				 */
				/*
				 * if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(),0)
				 * > 0 &&
				 * "A".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_STATUS(),
				 * "N"))) { getCOMP_UI_M_ENDT_LETTER().setRendered(true); }else
				 * { getCOMP_UI_M_ENDT_LETTER().setRendered(false); }
				 */

				/*
				 * Commented by sankara narayanan for hospitalcash plan on
				 * 25/04/2017 if("L".equalsIgnoreCase(PLAN_TYPE) )
				 */
				/*
				 * Changed by sankara narayanan for hospitalcash plan on
				 * 25/04/2017
				 */
				if ("L".equalsIgnoreCase(PLAN_TYPE) || "H".equalsIgnoreCase(PLAN_TYPE))
				// END
				{
					if ("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {

						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(false);
					} else {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(true);
					}
				} else {
					/* End */
					boolean premCalc_Enable = false;
					premCalc_Enable = helper.enableDisablePremiumcalc(PT_IL_POLICY_BEAN);
					System.out.println("premCalc_Enable         " + premCalc_Enable);
					/*
					 * if(helper.enableDisablePremiumcalc(PT_IL_POLICY_BEAN)&&
					 * "N"
					 * .equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG()))
					 */
					if (premCalc_Enable && "N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
						System.out.println("*4444*");
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(false);
					} else {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(true);
					}

				}

				/*
				 * if("TRUE".equalsIgnoreCase(isprmcalc)) { System.out.
				 * println("******** INSIDE THE isprmcalc IF BLOCK ********* ");
				 * System.out.println("*5555*");
				 * compositeAction.getDUMMY_ACTION_BEAN().
				 * getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(true); }
				 */

				// added to disable approve button if status other than B08
				if (!(("B08".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_ADDL_STATUS()))
						|| ("N01".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_ADDL_STATUS())))
						&& "1".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())) {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
				}

				/*
				 * Modified by Dhinesh on 16-10-2017 for Alteration button
				 * enable &disable
				 */
				if ("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())) {
					if (!("D".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS())
							|| "S".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS())
							|| "M".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS()))
							&& "2".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())) {
						if (PT_IL_POLICY_BEAN.getPOL_END_NO() == null || PT_IL_POLICY_BEAN.getPOL_END_NO().isEmpty()) {
							compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
							/* Newly Added By Dhinesh on 12/10/2017 */
							compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT().setRendered(true);
							/* End */
							compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT().setDisabled(false);
						}

						/* End */

					} else if ("D".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS())
							|| "S".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS())
							|| "M".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS())) {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT().setRendered(true);
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT().setDisabled(true);

					}
				}

				if ("012".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000"))) {

					COMP_POL_NO_OF_UNIT.setDisabled(true);
				}
				COMP_POL_ASSURED_NAME.setDisabled(true); // disable assured name
															// always exception
															// handled in 001
															// endo
				END_001changes();
				convertButtonEnable();
				disableButtons();

				/* Modified by Raja on 27/03/2016 for Disable opy button */
				int param_type_address1 = 0;
				String query_copy = "SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_PROP_COPY' AND PS_CODE = 'IL_PROP_COPY'";
				ResultSet rs_copy = new CRUDHandler().executeSelectStatement(query_copy, CommonUtils.getConnection());
				while (rs_copy.next()) {

					param_type_address1 = rs_copy.getInt("PS_VALUE");
				}
				System.out.println("param_type_address1  ===  >" + param_type_address1);
				if (param_type_address1 == 2) {
					COMP_UI_M_BUT_COPY.setRendered(false);
				} else {
					COMP_UI_M_BUT_COPY.setRendered(true);
					if ("2".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())) {
						COMP_UI_M_BUT_COPY.setDisabled(true);
					} else {
						COMP_UI_M_BUT_COPY.setDisabled(false);
					}
				}

				/* end */
				// alterInTerm();
				if ("020".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000"))
						&& "N".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(), "N"))) {
					/*
					 * sp_revival.upd_del_flag_rein_redate_agent(
					 * PT_IL_POLICY_BEAN.getPOL_SYS_ID());
					 * sp_revival.P_UPD_REDATE_ST_DATE(pt_il_policy_bean.
					 * getPOL_SYS_ID());
					 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getHelper()
					 * .executeQuery(compositeAction);
					 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					 * getCOMP_POL_FRZ_FLAG().setDisabled(false);
					 */compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(true);
				}

				if ("012".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE())
						&& "N".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(), "N"))) {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
				}

				/*
				 * Commentted by saritha on 20-06-2017 for ssp call id
				 * ZBILQC-1720514
				 */
				/*
				 * if ("S".equals(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE()) ||
				 * "AD".equals(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE())) {
				 * COMP_POL_EMPLOYER_CODE.setDisabled( false); }else{
				 * COMP_POL_EMPLOYER_CODE.setDisabled( true); }
				 */
				/* End */

				System.out.println("PT_IL_POLICY_BEAN.getPOL_PROP_NO()    : " + PT_IL_POLICY_BEAN.getPOL_PROP_NO());
				/*
				 * if(PT_IL_POLICY_BEAN.getPOL_PROP_NO()!=null) {
				 * compositeAction.getWizard().enableWizardItem(
				 * "PILT002_APAC_PT_IL_PREM_DTLS"); } else {
				 * compositeAction.getWizard().disableWizardItem(
				 * "PILT002_APAC_PT_IL_PREM_DTLS"); }
				 */
				compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_PREM_DTLS");
				disableenable_facyn_endt_appr_setup(PT_IL_POLICY_BEAN);
				flagAction();

				/* ADDED BY RAJA */
				System.out.println("Assured flag value==========" + compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
						.getPM_IL_CONTRACTOR_QE_BEAN().isASSURED_FLAG());
				boolean assured_flag = compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
						.getPM_IL_CONTRACTOR_QE_BEAN().isASSURED_FLAG();
				if (assured_flag) {
					COMP_POL_ASSURED_NAME.setDisabled(false);
					System.out.println("assured code in onload=========" + compositeAction
							.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN().getCONT_CODE());
					System.out.println("assured name in onload==========" + compositeAction
							.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN().getCONT_NAME());
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
							.setPOL_CONT_CODE(compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
									.getPM_IL_CONTRACTOR_QE_BEAN().getCONT_CODE());
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
							.setPOL_ASSURED_NAME(compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
									.getPM_IL_CONTRACTOR_QE_BEAN().getCONT_NAME());

				}
				// added by krithika for FALCONQC-1715215
				if (status.equals("M")) {
					System.out.println("inside the Matured--------->");
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FRZ_FLAG().setDisabled(true);
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT().setDisabled(true);
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_HOLD().setDisabled(true);

				}
				// end

				COMP_POL_CONT_CODE.resetValue();
				COMP_POL_ASSURED_NAME.resetValue();
				COMP_POL_ASSURED_NAME.setDisabled(true);

				/* END */
				/*
				 * ADDED BY RAJA ON 10-07-2016. FOR SSP CALL ID -
				 * FALCONQC-1714559
				 */

				// System.out.println("CommonUtils.setGlobalVariable(GLOBAL.FLAGCUST,
				// TRUE)
				// "+CommonUtils.getGlobalVariable("GLOBAL.FLAGCUST").toString());
				if ("TRUE"
						.equalsIgnoreCase(CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.FLAGCUST"), "FALSE"))) {
					CommonUtils.setGlobalVariable("GLOBAL.FLAGCUST", "FALSE");
					quickCustomerDefault();

				}

				/* End of SSP Call ID - FAL-001-2016-0015875 */
				/*
				 * if((PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS().equalsIgnoreCase(
				 * "N")&&PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG().equalsIgnoreCase(
				 * "Y")&&(
				 * PT_IL_POLICY_BEAN.getPOL_DS_TYPE().equalsIgnoreCase("1")||
				 * PT_IL_POLICY_BEAN.getPOL_DS_TYPE().equalsIgnoreCase("2")))||
				 * (PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS().equalsIgnoreCase("A"
				 * )&&PT_IL_POLICY_BEAN.getPOL_DS_TYPE().equalsIgnoreCase("2")))
				 * { compositeAction.getDUMMY_ACTION_BEAN().
				 * getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(false);
				 * 
				 * }
				 */

				/*
				 * Added by Ramkumar on 06-08-2016 for QuotationNo field enable
				 * issue
				 */

				getCOMP_POL_PROP_NO().setDisabled(true);

				/* End */

				/*
				 * Added by saritha on 11-01-2017 for Payer Details Height and
				 * Weight &BMI is Mantatory
				 */

				if (PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG().equals("Y")) {

					pt_il_assued_action.getCOMP_POAD_WEIGHT().setRequired(true);
					pt_il_assued_action.getCOMP_POAD_HEIGHT().setRequired(true);
					pt_il_assued_action.getCOMP_POAD_BMI().setRequired(true);

				}

				/* End */

				/*
				 * Added by saritha on 20-Feb-2017 for RM018T - DEV_IL_ZB
				 * Life_027-Replacement Policy
				 */
				COMP_POL_REPLACEMENT_YN.setDisabled(true);
				/* End */

				/* Added by Saranya on 07/04/2017 */
				// getProd_plan_type();
				System.out.println("setPLAN_TYPE   :" + getPLAN_TYPE());

				/*
				 * if("U".equalsIgnoreCase(getPLAN_TYPE()))
				 * 
				 * { //Modified by saritha on 01-08-2017 for Endowment Product &
				 * Education Product issues //setPremiumCalculationType();
				 * setPremiumCalcType(); //End }
				 */
				/*
				 * Added by Janani on 25.06.2018 for FSD_IL_FLA_006_Monetary
				 * Endorsement Module
				 */

				/* Modified by Janani on 13.08.2018 for null check */

				/* if(getAgentPremiumType().equalsIgnoreCase("C")) */
				if (getAgentPremiumType() != null && getAgentPremiumType().equalsIgnoreCase("C"))

				/* End */
				{
					setPremiumCalcType();
				} else {
					PremSAcheck();
				}

				/* End */

				/* Added by saranya on 20-04-2016 for Endowment Product */
				Unit_link_typ();

				/*
				 * Modified condition by saritha on 06-07-2017 for Endowment
				 * Product
				 */
				if (("U".equals(getPLAN_TYPE())) && ("END".equals(getUnit_link_typ()))) {
					COMP_POL_BNF_ESC_PERC.setDisabled(true);
					COMP_POL_ANN_PAY_PERIOD.setDisabled(false);
				}

				/* Added by saritha on 12-07-2017 for Education Product */
				else if (("U".equals(getPLAN_TYPE())) && ("EDU".equals(getUnit_link_typ()))) {
					COMP_POL_BNF_ESC_PERC.setDisabled(false);

				} else {
					COMP_POL_BNF_ESC_PERC.setDisabled(true);
					COMP_POL_ANN_PAY_PERIOD.setDisabled(true);
				}
				/* End */

				/* Added by saranya on 11-04-2016 */
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setBlockFlag(true);
				/* End */

				/*
				 * Added by Ram on 12/04/2017 for disable FCPremium field
				 * disable process
				 */
				if (PT_IL_POLICY_BEAN.getUI_POL_FRZ_FLAG() != null
						&& PT_IL_POLICY_BEAN.getUI_POL_FRZ_FLAG().equals("Y")) {
					getCOMP_POL_FC_MODAL_PREM().setDisabled(true);

					/*
					 * Added by Ram on 12/04/2017 for disable components after
					 * freezing policy
					 */
					getCOMP_POL_DISPATCH_DT().setDisabled(true);
					getCOMP_POL_DOC_ACK_DT().setDisabled(true);
					getCOMP_POL_DISPATCH_MTD().setDisabled(true);
					/* End */

					/*
					 * Added by saranya on 24/04/2017 for disable Component
					 * after freezing policy
					 */
					getCOMP_POL_BNF_ESC_PERC().setDisabled(true);
					getCOMP_POL_ANN_PAY_PERIOD().setDisabled(true);
					getCOMP_POL_ANN_BNF_AMT().setDisabled(true);
					/* End */
				}
				/* End */

				/* Added by Janani on 08.06.2017 for ZBILQC-1728005 */

				/*
				 * if(compositeAction.getDUMMY_ACTION_BEAN()
				 * .getDUMMY_BEAN().getUI_M_POL_PLAN_TYPE().equalsIgnoreCase("u"
				 * )) { System.out.
				 * println("plan type is U for disabling SA factor field");
				 * COMP_POL_NO_OF_UNIT.setDisabled(true);
				 * 
				 * } else { COMP_POL_NO_OF_UNIT.setDisabled(false); }
				 */

				/* End */

				/* Added by Ram on 13/04/2017 as per Sivaram suggestion */
				System.out.println("getPOL_UL_PREM_CALC  in prem calc function                     "
						+ compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_UL_PREM_CALC());

				if ("D".equalsIgnoreCase(
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_UL_PREM_CALC())
						&& ("EDU".equals(getUnit_link_typ()))) {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPremium_Amt();

					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
							.setPOL_FC_SUM_ASSURED(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPREM_AMT());
					/*
					 * Added by saritha on 23-08-2017 for Education & Endowment
					 * Product Issues
					 */
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
							.setPOL_LC_SUM_ASSURED(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
									.getPOL_FC_SUM_ASSURED());
					/* End */
					System.out.println("last of prem calc function         " + compositeAction
							.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FC_SUM_ASSURED());
				}

				/* End */
				System.out.println("SumAssured in onLoad        "
						+ compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FC_SUM_ASSURED());

				/* NEWLY ADDED BY DHINESH ON 12-06-2017 */
				if (!(CommonUtils.nvl(
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX(),
						0) > 0)) {
					CommonUtils.setGlobalVariable("GLOBAL.APPRV_SCRN_END_IDX_NO", null);
				}
				/* END */

				/*
				 * Moved this code inside the isblockflag block by ganesh,
				 * 07-07-2017 ZBILQC-1719674
				 */
				/* Added By Ameen for Endorsements slip reports 12.9.2016 */

				System.out.println("END_CODE ==" + PT_IL_POLICY_BEAN.getPOL_END_CODE() + " POL_STATUS"
						+ PT_IL_POLICY_BEAN.getPOL_STATUS() + " FRZ_FLAG" + PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG());
				if (PT_IL_POLICY_BEAN.getPOL_END_CODE() != null) {
					END_FIELD_DISABLED(PT_IL_POLICY_BEAN.getPOL_STATUS(), PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG(),
							PT_IL_POLICY_BEAN.getPOL_END_CODE());

					System.out.println("AFTER GEN END ENABLING");

				}

				/* End */
				/* end */

				/* ADDED BY RAJA ON 07-07-2017 FOR ZBILQC-1730135 */
				if (PT_IL_POLICY_BEAN.getUI_POL_FRZ_FLAG() != null
						&& PT_IL_POLICY_BEAN.getUI_POL_FRZ_FLAG().equalsIgnoreCase("Y")) {
					// Modified by ganesh on 24-08-2017, as suggested by Mr.
					// Vikram and Siva to disable RI Allocation
					if (PT_IL_POLICY_BEAN.getPOL_DS_TYPE().equals("1")
							&& PT_IL_POLICY_BEAN.getPOL_STATUS().equalsIgnoreCase("A")
							&& PT_IL_POLICY_BEAN.getPOL_FAC_YN().equalsIgnoreCase("Y")) {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(true);
					} else {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(false);
					}
					/* end */
				} else {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(true);
				}
				/* END */

				/* Added by saritha for feneral 207R Cover Code */

				addCoverRider();

				/* End */

				/* Added by Ameen on 12-07-2018 for TOI as per Ajay sugg. */
				ResultSet prodRS = new CRUDHandler().executeSelectStatement(
						"SELECT PROD_CODE,PROD_POL_APPROVAL_YN FROM PM_IL_PRODUCT WHERE PROD_CODE = ?",
						CommonUtils.getConnection(), new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
				if (prodRS.next()) {
					P_PROD_POL_APPROVAL_YN = prodRS.getString("PROD_POL_APPROVAL_YN");
				}
				if ("O".equalsIgnoreCase(P_PROD_POL_APPROVAL_YN)) {
					PT_IL_POLICY_BEAN.setUI_M_PREM_HIDE(true);
				} else {
					PT_IL_POLICY_BEAN.setUI_M_PREM_HIDE(false);
				}
				/* end */
				/* Added by kavitha on 02.08.2018 for KICLIFEQC-1759635 */
				setBlockFlag(false);
				/* end */

				/* added by Ameen on 27-10-2019 for SARWA retiremnet product */
				retirementFieldsEnDis(getPLAN_TYPE());
				retirementFieldHandling();
				/* end */
			}

			/*
			 * Modified by ganesh on 12-04-2018 for hide and show the quotation
			 * number in policy screen
			 */
			if ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
					&& ("Q".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13"))
							|| "P".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13")))) {
				getCOMP_POL_PROP_NO().setRendered(false);
				getCOMP_POL_PROP_NO_LABEL().setRendered(false);

			} else if ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
					&& "P".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13"))) {

				getCOMP_POL_PROP_NO().setRendered(true);
				getCOMP_POL_PROP_NO_LABEL().setRendered(true);

			}
			/* END */

			/*
			 * Added by saritha on 17-08-2017 for ssp call id ZBILQC-1735415 as
			 * per Thiag sir sugg
			 */
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().enableDisable_FinancialQuest_Link();
			/* End */

			/*
			 * Commented and Moved this code inside the isblockflag block by
			 * ganesh, 07-07-2017 ZBILQC-1719674
			 */
			/* Added By Ameen for Endorsements slip reports 12.9.2016 */

			/*
			 * System.out.println("END_CODE =="+PT_IL_POLICY_BEAN.
			 * getPOL_END_CODE()+" POL_STATUS"+PT_IL_POLICY_BEAN.getPOL_STATUS()
			 * + " FRZ_FLAG"+PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG());
			 * if(PT_IL_POLICY_BEAN.getPOL_END_CODE()!=null){
			 * END_FIELD_DISABLED(PT_IL_POLICY_BEAN.getPOL_STATUS(),
			 * PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG(),PT_IL_POLICY_BEAN.
			 * getPOL_END_CODE());
			 * 
			 * System.out.println("AFTER GEN END ENABLING");
			 * 
			 * }
			 */

			/* End */
			/* end */

			/* added by raja on 30-06-2017 ZBILQC-1730135 */

			if (PLAN_TYPE.equalsIgnoreCase("U")) {
				String value = null;
				String Prod = "SELECT PROD_UNIT_LINK_TYPE FROM PM_IL_PRODUCT where prod_code=?";
				ResultSet rsProd = new CRUDHandler().executeSelectStatement(Prod, CommonUtils.getConnection(),
						new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
				while (rsProd.next()) {
					value = rsProd.getString("PROD_UNIT_LINK_TYPE");

				}
				if (value != null && value.equalsIgnoreCase("NA")) {

					String Addcov = "select 'X' from PT_IL_POL_ADDL_COVER where POAC_POL_SYS_ID=?";
					ResultSet rsAddcov = new CRUDHandler().executeSelectStatement(Addcov, CommonUtils.getConnection(),
							new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
					if (rsAddcov.next()) {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setRendered(true);
					} else {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setRendered(false);
					}

				} else {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setRendered(true);
				}
			}

			/* end */

			/* Added by Ram on 31/03/2017 for Defaulting Customer */
			if ("TRUE".equalsIgnoreCase(CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.FLAGCUST"), "FALSE"))) {
				CommonUtils.setGlobalVariable("GLOBAL.FLAGCUST", "FALSE");
				quickCustomerDefault();

			}
			/* End */

			/* Added by saritha on 14-May-2017 for ssp call id ZBILQC-1723794 */
			getCOMP_UI_M_POL_PREM_PAYER_CODE_DESC().setDisabled(true);
			/* End */

			/* added by raja on 01-07-2017 for ZBILQC-1730166 */
			if (!"A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())
					&& CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.FRZ_FLAG"), "N").equalsIgnoreCase("Y")) {
				COMP_POL_FRZ_FLAG.setDisabled(false);
			}

			/* Newly added by dhinesh on 13-06-2017 for ZBILQC-1719814 */
			if ("002".equalsIgnoreCase(
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_TYPE())) {
				if ((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()
						.equalsIgnoreCase("INCSA")
						|| compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()
								.equalsIgnoreCase("DECSA"))) {
					if ("Y".equalsIgnoreCase(
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())) {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FAC_YN().setDisabled(true);
					} else {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FAC_YN().setDisabled(false);
					}
				}
			}

			/* End */
			/*
			 * Added by Ameen on 10-07-2017 for ZBILQC-1731204 as per siva sugg.
			 */
			/*
			 * Added by Ameen on 10-07-2017 for ZBILQC-1731204 as per siva sugg.
			 */

			String PROD_SA_BY_PLAN_BASIS_YN = null;
			String PROD_SA_TARIFF = null;
			double SUB_PLAN_SA_Min = 0.0;
			double SUB_PLAN_SA_MAX = 0.0;

			String Prod = "SELECT PROD_SA_BY_PLAN_BASIS_YN,PROD_SA_TARIFF FROM PM_IL_PRODUCT where prod_code=?";
			ResultSet rsSubPlan = new CRUDHandler().executeSelectStatement(Prod, CommonUtils.getConnection(),
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
			while (rsSubPlan.next()) {
				PROD_SA_BY_PLAN_BASIS_YN = rsSubPlan.getString("PROD_SA_BY_PLAN_BASIS_YN");
				PROD_SA_TARIFF = rsSubPlan.getString("PROD_SA_TARIFF");
				CommonUtils.setGlobalVariable("GLOBAL.PROD_SA_BY_PLAN_BASIS_YN", PROD_SA_BY_PLAN_BASIS_YN);
			}

			/* Modified By Dhinesh on 31-05-2018 */
			if (!"Y".equalsIgnoreCase(PROD_SA_BY_PLAN_BASIS_YN)) {
				if ("H".equalsIgnoreCase(PLAN_TYPE)) {
					if (PT_IL_POLICY_BEAN.getROWID() == null) {
						PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(25.0);
					}
					COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				} else if ("L".equalsIgnoreCase(PLAN_TYPE)) {
					if (PT_IL_POLICY_BEAN.getROWID() == null) {

						/*
						 * COMMENTED BY DHINESH ON 06-10-2017
						 * 
						 * PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(1.0);
						 */

						/*
						 * Modified by Dhinesh on 06-10-2017 suggested by
						 * Sivaram : sum assured value defaulted 1000 for
						 * funeral plan
						 */

						PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(1000.0);

						/* End */
					}
					COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				}
			}
			/* End */
			/* Added by Ameen on 17-07-2017 for ZBILQC-1731923 */
			if ("203".equals(PT_IL_POLICY_BEAN.getPOL_PROD_CODE())) {
				COMP_POL_ANN_BNF_AMT_LABEL.setRendered(false);
				COMP_POL_ANN_BNF_AMT.setRendered(false);
				COMP_ANNUITY_MANDATORY.setRendered(false);
			}
			/* End */

			/* Newly Added By Dhinesh 24-8-2017 */
			if (CommonUtils.isIN(CommonUtils.nvl(
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE(), "XXXX"),
					"INCSA", "DECSA")) {

				String medicalExamQry = "SELECT count(*) count FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ? ";
				int MedCount = 0;
				Object[] values = new Object[] {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID() };
				ResultSet rs13 = new CRUDHandler().executeSelectStatement(medicalExamQry, CommonUtils.getConnection(),
						values);
				if (rs13.next()) {
					MedCount = rs13.getInt("count");
				}

				if (MedCount != 0 || "Y".equalsIgnoreCase(
						CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.POAD_HIV_TEST_YN").toString(), "N"))) {
					compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_MED_EXAM_DTL");

				} else {
					compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_MED_EXAM_DTL");
				}
			}
			/* End */

			/*
			 * Added by Ameen on 07-09-2017 for ZBILQC-1720075 as per
			 * Chandramohan sugg.
			 */
			if (PT_IL_POLICY_BEAN.getPOL_END_TYPE() != null
					&& "009".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
				if ("CANPOL".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_CODE())) {

					Date polIssueDt = PT_IL_POLICY_BEAN.getPOL_ISSUE_DT();
					Calendar cal = Calendar.getInstance();
					cal.setTime(polIssueDt);
					cal.set(Calendar.HOUR_OF_DAY, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					cal.set(Calendar.MILLISECOND, 0);
					polIssueDt = cal.getTime();
					System.out.println(
							"POL_ISSUE_DT ::" + polIssueDt + " :: POL_END_DT ::" + PT_IL_POLICY_BEAN.getPOL_END_DT());
					String coolOfDaysQry = "SELECT PROD_COOLOFF_DAYS FROM PM_IL_PRODUCT,PT_IL_POLICY WHERE PROD_CODE = ?";
					ResultSet coolOfDaysRS = null;
					long coolOfDays = 0;
					coolOfDaysRS = new CRUDHandler().executeSelectStatement(coolOfDaysQry, CommonUtils.getConnection(),
							new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
					if (coolOfDaysRS.next()) {
						coolOfDays = coolOfDaysRS.getInt("PROD_COOLOFF_DAYS");
					}

					long diff = (polIssueDt.getTime() - PT_IL_POLICY_BEAN.getPOL_END_DT().getTime())
							/ (24 * 60 * 60 * 1000);
					System.out.println("DAYS :: " + diff + ":: coolOfDays ::" + coolOfDays);
					// commented by mani 22July24 advised by Ajoy. Save button
					// to enable for cancellation
					// if(diff <= coolOfDays){
					// compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(true);
					// COMP_SAVE_COMMAND_LINK.setDisabled(true);
					// COMP_SAVE_BUTTON.setDisabled(true);
					// }
				}
			}
			/* End */

			/*
			 * Added by Ameen on 19-09-2017 for list issues to disable M.E.
			 * block for funeral and no M.E. records
			 */

			String medicalExamQry = "SELECT 'X' count FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ? ";

			ResultSet rs13 = new CRUDHandler().executeSelectStatement(medicalExamQry, CommonUtils.getConnection(),
					new Object[] {
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			if (rs13.next()) {
				compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_MED_EXAM_DTL");

			}

			/*
			 * Commentted &Modified by saritha on 14-12-2017 for ssp call id :
			 * ZBLIFE-1461947
			 */

			/*
			 * else { compositeAction.getWizard().disableWizardItem(
			 * "PILT002_APAC_PT_IL_POL_MED_EXAM_DTL"); }
			 */

			else {

				helper.userMedicalAccessValidation(compositeAction);

			}

			/* End */

			/*
			 * Commented by ganesh on 06-02-2018 as suggested by Raja sir to
			 * enable always
			 */
			/*
			 * if(PLAN_TYPE.equals("L") || PLAN_TYPE.equals("H") ||
			 * PLAN_TYPE.equals("U")){
			 * 
			 * String coverQry =
			 * "SELECT 'X' FROM PT_IL_POL_ADDL_COVER WHERE POAC_COVER_CODE = '203R' AND POAC_POL_SYS_ID = ?"
			 * ; ResultSet coverRS = null; coverRS = new
			 * CRUDHandler().executeSelectStatement(coverQry,CommonUtils.
			 * getConnection(), new
			 * Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().
			 * getPT_IL_POLICY_BEAN().getPOL_SYS_ID()}); if(coverRS.next()){
			 * 
			 * this.getCOMP_MORE_INFO_4().setDisabled(false); }else{
			 * 
			 * this.getCOMP_MORE_INFO_4().setDisabled(true); } }else{
			 * 
			 * this.getCOMP_MORE_INFO_4().setDisabled(false); }
			 */
			/* end */

			if ("206".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_PROD_CODE())) {
				COMP_POL_PYMT_TYPE.setRequired(true);
				COMP_POL_ANN_PAY_PERIOD.setRequired(true);
			}

			/* End */

			/*
			 * Added by Ameen on 30-05-2018 for KIC as per siva sugg. to enable
			 * print btn based on autoUW
			 */
			String autoUW = "N";
			ResultSet autoRS = new CRUDHandler().executeSelectStatement(
					"SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT A WHERE PROD_CODE = ?", CommonUtils.getConnection(),
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
			if (autoRS.next()) {
				autoUW = autoRS.getString("PROD_AUTO_UW");
			}
			if ("Y".equalsIgnoreCase(autoUW)) {
				if (PT_IL_POLICY_BEAN.getPOL_ADDL_STATUS() != null
						&& CommonUtils.isIN(PT_IL_POLICY_BEAN.getPOL_ADDL_STATUS(), "C01", "C02", "I00", "005")) {
					COMP_POL_PRINT.setDisabled(false);
					COMP_POL_PRINT1.setDisabled(false);
				}
			}
			/* End */

			/* added by Ameen on 04-05-2018 for KIC */
			if (PT_IL_POLICY_BEAN.getPOL_DS_TYPE().equals("1")) {
				ResultSet rs = new CRUDHandler().executeSelectStatement(
						"SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_RI_BUTTON'", CommonUtils.getConnection());
				if (rs.next()) {
					int riVal = rs.getInt("PS_VALUE");
					if (riVal == 1) {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setRendered(false);
					}
				}
			} else {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setRendered(true);
			}
			/* End */

			System.out.println(
					"Tested Value-->" + fetchInstanceData("PM_CUSTOMER_QE", "PILT002_APAC", "CUST_TEL_AREA_CODE2", 5));

			if ("KIC/".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE"))) {
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_PHONE2().setRequired(false);

				/* COmmented by Janani for KIC Mobile number updation issue */
				// compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN().setCUST_TEL_AREA_CODE2("+965");
				/* End */

				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_TEL_AREA_CODE2().setDisabled(true);

				if ("1".equals(fetchInstanceData("PM_CUSTOMER_QE", "PILT002_APAC", "CUST_TEL_AREA_CODE2", 5))) {
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_EMAIL_ID_PER().setRequired(false);
				} else {
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_EMAIL_ID_PER().setRequired(true);
				}

				if ("1".equals(fetchInstanceData("PM_CUSTOMER_QE", "PILT002_APAC", "CUST_ADDR2", 5))) {
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_ADDR2().setRequired(false);
				} else {
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_ADDR2().setRequired(true);
				}

				if ("1".equals(fetchInstanceData("PM_CUSTOMER_QE", "PILT002_APAC", "CUST_ADDR3", 5))) {
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_ADDR3().setRequired(false);
				} else {
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_ADDR3().setRequired(true);
				}

				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_QUOT_NO().setRendered(false);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_QUOT_NO_LABEL().setRendered(false);

				COMP_POL_DISPATCH_MTD_LABEL.setRendered(false);
				COMP_POL_DISPATCH_MTD.setRendered(false);
				COMP_POL_DOC_ACK_DT_LABEL.setRendered(false);
				COMP_POL_DOC_ACK_DT.setRendered(false);
				COMP_POL_DISPATCH_DT_LABEL.setRendered(false);
				COMP_POL_DISPATCH_DT.setRendered(false);

				if ("1".equals(fetchInstanceData("PT_IL_POLICY", "PILT002_APAC", "POL_ANN_BNF_AMT", 5))) {
					COMP_POL_ANN_BNF_AMT.setRequired(false);
				} else {
					COMP_POL_ANN_BNF_AMT.setRequired(true);
				}

				compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_ASSR_ILLNESS_DTLS");

				/*
				 * COMP_UI_M_POL_CONT_AD_ACC_NO_LABEL.setRendered(true);
				 * COMP_UI_M_POL_CONT_AD_ACC_NO.setRendered(true);
				 * COMP_POL_CONT_AD_BANK_CODE_LABEL.setRendered(true);
				 * COMP_POL_CONT_AD_BANK_CODE.setRendered(true);
				 * COMP_UI_M_BANK_CODE_DESC.setRendered(true);
				 * COMP_POL_CARD_HOLDER_NAME_LABEL.setRendered(true);
				 * COMP_POL_CARD_HOLDER_NAME.setRendered(true);
				 */
				officialAddrs = true;
				if ("T01".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_PROD_CODE())) {
					kicCheck = true;
				}
				if (null == PT_IL_POLICY_BEAN.getPOL_NO()) {
					// COMP_POL_PROP_NO.setDisabled(false);
					COMP_POL_NO.setDisabled(false);
					COMP_POL_NO.setRequired(true);
				}
				/*
				 * if("2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())){
				 * COMP_POL_NO_LABEL.setValue("Policy No.");
				 * COMP_POL_PROP_NO_LABEL.setValue("Application No."); }
				 */
				COMP_POL_STAFF_YN.setRequired(false);
			}

			/* Added by Ameen on 16-05-2018 for update cust civil ID */
			if (compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().isUpdCivilFlag()) {
				setUpdatedCivilIID();
			}
			/* End */

			/*
			 * Added by Janani as suggested by Sivaram for fidelity on
			 * 07.05.2018
			 */
			getCoverSACalc();
			/* if condition handled by Ameen on 23-05-2018 for KIC */
			if (!"Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())
					&& PT_IL_POLICY_BEAN.getPOL_END_CODE() == null) {
				pol_period_disable();
			}
			/* End */

			/* Newly Added By Dhinesh on 01-06-2018 */
			if ("Y".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.PROD_SA_BY_PLAN_BASIS_YN"))) {
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
			}
			/* End */

			/*
			 * Added by Ameen on 06-07-2018 for KIC to disable POL_FRZ_FLAG
			 * based on POL_FLEX_20 in endorsements
			 */
			if (!"A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())
					&& !"Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FLEX_20())) {
				COMP_POL_FRZ_FLAG.setDisabled(true);
			}
			/* End */
			/* Added by kavitha on 26.07.2018 for KICLIFEQC-1759635-3 */
			getCityCodeDesc();
			getCountryCodeDesc();
			/*
			 * Fidelity feature taken for kic added by Pidugu Raj on 20-09-2018
			 * (FSD_IL_FLA_009)
			 */
			showPol_receipt_dtls();
			/*
			 * Fidelity feature taken for kic added by Pidugu Raj on 20-09-2018
			 * (FSD_IL_FLA_009)
			 */

			/* Added by Janani on 16.03.2018 for KIC Disaptch dtls screen */

			dispatchDtl_render();
			/* End */
			/* Newly added by pidugu raj dt: 13-10-2020 for Alliance IL */
			if (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS()
					.equalsIgnoreCase("L")) {
				COMP_POL_FRZ_FLAG.setDisabled(false);
				COMP_SAVE_BUTTON.setDisabled(false);
				COMP_SAVE_COMMAND_LINK.setDisabled(false);
				// compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().disableAllComponent(false);
			}
			String trueorfalse = EnableUnderwrite();
			if (trueorfalse != null && "X".equalsIgnoreCase(trueorfalse)) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_HOLD().setDisabled(false);
			}
			if ("2".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_HOLD().setDisabled(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/* Added by Janani on 20.05.2017 for SSP id ZBILQC-1719696 */

	private int CustomerPanelsaving() {

		System.out.println("enters into CustomerPanelsaving");

		int param_type_Cust = 0;
		try {

			String queryCust = "SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_CUST_PROP' AND PS_CODE = 'IL_CUST_PROP'";
			ResultSet rsCust = new CRUDHandler().executeSelectStatement(queryCust, CommonUtils.getConnection());
			while (rsCust.next()) {
				param_type_Cust = rsCust.getInt("PS_VALUE");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return param_type_Cust;

	}

	/* End */

	public void disableenable_facyn_endt_appr_setup(PT_IL_POLICY pt_il_policy_bean) throws ProcedureException {

		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		ArrayList<String> pValList = new ArrayList<String>();
		String M_USER_PERM = null;

		if ("002".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(), "000"))) {

			pValList = new ArrayList<String>();

			try {
				pValList = pkg_pilt002_apac.P_VAL_ENDT_APPROVAL(CommonUtils.getControlBean().getM_USER_ID(), "FAC_YN",
						pt_il_policy_bean.getPOL_PROD_CODE(), "2", M_USER_PERM, pt_il_policy_bean.getPOL_END_CODE());
			} catch (ProcedureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
			if (!pValList.isEmpty() && pValList.get(0) != null)
				M_USER_PERM = pValList.get(0);

			if ("N".equalsIgnoreCase(M_USER_PERM)) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FAC_YN().setDisabled(false);
			} else {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FAC_YN().setDisabled(false);
			}
		}
	}

	private void doBackButDisable() {
		String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
		String pilt010BackFlag = CommonUtils.nvl(CommonUtils.getGlobalVariable("PILP010_BACK_FLAG"), "N");
		if (callingForm != null) {
			if ("PILT010".equalsIgnoreCase(callingForm) && "Y".equalsIgnoreCase(pilt010BackFlag)) {
				COMP_BACK_BUTTON.setDisabled(false);
			} else if ("PILT010".equalsIgnoreCase(callingForm) && "N".equalsIgnoreCase(pilt010BackFlag)) {
				COMP_BACK_BUTTON.setDisabled(true);
			}
		}
	}

	// ADDED BY AKASH TO DISABLE ENDORSMENT BUTTON FOR MATURED POLICY.

	private void chkMaturedSts(String polNo) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String polStatus = null;
		String query = " SELECT POL_STATUS FROM PT_IL_POLICY WHERE POL_NO = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[] { polNo });
			if (resultSet.next()) {
				polStatus = resultSet.getString(1);
			}
			if ("M".equalsIgnoreCase(polStatus)) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT().setDisabled(true);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	private void checkPropOrPol() {
		if ("2".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_DS_TYPE(), "1"))) {
			setEndorseIndxVisibleFlag(true);
		}

		/*
		 * Added by ganesh on 14-04-2017 for amendment functionality in proposal
		 */
		else if ("1".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_DS_TYPE(), "1"))) {
			setAmendmentIndxVisibleFlag(true);

		}
		/* end */
	}

	private void hideNonUlipItems(PT_IL_POLICY PT_IL_POLICY_BEAN) throws Exception {
		String planType = helper.getPlanType(PT_IL_POLICY_BEAN.getPOL_PLAN_CODE());
		if (!("U".equalsIgnoreCase(planType))) {
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PRMDTLS().setRendered(false);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_FUND_DTL().setRendered(false);
		}
	}
	/*
	 * private void quickCustomerDefault() { if
	 * (CommonUtils.getGlobalVariable("GLOBAL.CUSTCODE") != null) {
	 * PT_IL_POLICY_BEAN.setPOL_CUST_CODE(CommonUtils.getGlobalVariable(
	 * "GLOBAL.CUSTCODE").toString()); } if
	 * (CommonUtils.getGlobalVariable("GLOBAL.REFID") != null) {
	 * PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1(CommonUtils
	 * .getGlobalVariable("GLOBAL.REFID").toString()); } if
	 * (CommonUtils.getGlobalVariable("GLOBAL.CONT_CODE") != null) {
	 * PT_IL_POLICY_BEAN.setPOL_CONT_CODE(CommonUtils
	 * .getGlobalVariable("GLOBAL.CONT_CODE")); } }
	 */

	private void quickCustomerDefault() {
		// System.out.println("GLOBAL.CUSTCODE ===========
		// "+CommonUtils.getGlobalVariable("GLOBAL.CUSTCODE").toString());

		if (CommonUtils.getGlobalVariable("GLOBAL.REFID") != null) {

			System.out.println("GLOBAL.REFID  =========== " + CommonUtils.getGlobalVariable("GLOBAL.REFID").toString());

			this.PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1(CommonUtils.getGlobalVariable("GLOBAL.REFID").toString());
			/* Added by Ameen on 07-05-2018 for KIC as per Ajoy sugg. */
			defaultPremPayorCode(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1());
			/* End */
		}

		if (CommonUtils.getGlobalVariable("GLOBAL.CUSTCODE") != null) {

			System.out.println(
					"GLOBAL.CUSTCODE  =========== " + CommonUtils.getGlobalVariable("GLOBAL.CUSTCODE").toString());

			this.PT_IL_POLICY_BEAN.setPOL_CUST_CODE(CommonUtils.getGlobalVariable("GLOBAL.CUSTCODE").toString());

			this.PT_IL_POLICY_BEAN.setPOL_CONT_CODE(CommonUtils.getGlobalVariable("GLOBAL.CUSTCODE"));
		}

		// System.out.println("GLOBAL.REFID ===========
		// "+CommonUtils.getGlobalVariable("GLOBAL.REFID").toString());

		// System.out.println("GLOBAL.CONT_CODE ===========
		// "+CommonUtils.getGlobalVariable("GLOBAL.CONT_CODE").toString());

		if (CommonUtils.getGlobalVariable("GLOBAL.CONT_CODE") != null) {
			System.out.println(
					"GLOBAL.CONT_CODE =========== " + CommonUtils.getGlobalVariable("GLOBAL.CONT_CODE").toString());

			this.PT_IL_POLICY_BEAN.setPOL_CONT_CODE(CommonUtils.getGlobalVariable("GLOBAL.CONT_CODE"));
		}
		COMP_POL_CUST_CODE.resetValue();
		COMP_POL_ASSRD_REF_ID1.resetValue();
		COMP_POL_CONT_CODE.resetValue();

		/*
		 * Added by Ameen on 20-04-2018 for KIC ,customer and assrd. same
		 * scenario
		 */
		if (CommonUtils.getGlobalVariable("GLOBAL.REFID2") != null) {
			this.PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2(CommonUtils.getGlobalVariable("GLOBAL.REFID2"));
		}
		if (CommonUtils.getGlobalVariable("GLOBAL.CONTCODE") != null) {
			this.PT_IL_POLICY_BEAN.setPOL_CONT_CODE(CommonUtils.getGlobalVariable("GLOBAL.CONTCODE"));
		}
		COMP_POL_ASSRD_REF_ID2.resetValue();
		COMP_POL_CONT_CODE.resetValue();
		/* End */

	}

	/* Added by Ameen on 07-05-2018 for KIC as per Ajoy sugg. */
	public void defaultPremPayorCode(String REF_ID1) {
		String premPayorQry = "SELECT CUST_CODE FROM PM_CUSTOMER WHERE UPPER(CUST_CLASS) IN UPPER('INDL') "
				+ "AND NVL(CUST_REF_ID1, 'X') = NVL(?, 'X')";
		ResultSet rs = null;
		String premPayorCode = "";
		try {
			rs = new CRUDHandler().executeSelectStatement(premPayorQry, CommonUtils.getConnection(),
					new Object[] { REF_ID1 });
			if (rs.next()) {
				premPayorCode = rs.getString("CUST_CODE");
			}
			if (!"".equals(premPayorCode)) {
				PT_IL_POLICY_BEAN.setPOL_PREM_PAYER_CODE(premPayorCode);
			}
			if (null != PT_IL_POLICY_BEAN.getPOL_PREM_PAYER_CODE()) {
				List<String> pvalList = new ArrayList<String>();
				LIFELIB lifelib = new LIFELIB();
				pvalList = lifelib.P_VAL_CUST_NAME(PT_IL_POLICY_BEAN.getPOL_PREM_PAYER_CODE(),
						PT_IL_POLICY_BEAN.getUI_M_POL_PREM_PAYER_CODE_DESC(), "N", "N",
						PT_IL_POLICY_BEAN.getPOL_DIVN_CODE());
				if (!pvalList.isEmpty()) {
					PT_IL_POLICY_BEAN.setUI_M_POL_PREM_PAYER_CODE_DESC(pvalList.get(0).toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void convertButtonEnable() throws Exception {
		try {
			chkpropconvert(PT_IL_POLICY_BEAN.getPOL_NO());
			if ("N".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_CONVERT_YN(), "N"))) {
				if ("1".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"))) {// Proposal&Quotation
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setRendered(true);

					if ("Y".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_CONVERT_YN(), "N"))) {
						// && PT_IL_POLICY_BEAN.getPOL_PROP_NO() != null){

						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setRendered(false);
					}
				} else if ("2".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"))) {// Policy
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setRendered(false);
					// compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setDisabled(true);
				}
			} else {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setRendered(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * Modified by Saranya on 11/04/2017
	 * 
	 * void enableDisableForApproveCondition() {
	 */
	public void enableDisableForApproveCondition() {
		System.out.println("ENTER ENABLEDISABLEFORAPPROVECONDITION METHOD ");
		if (("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())
				|| "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG()))) {
			disableAllComponent(true);
			System.out.println("*1111*");

			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(true);

			COMP_POL_JOINT_LIFE_YN.setDisabled(true);
			new PILT002_APAC_LOCAL_PROCEDURES().IL_BLOCK_POL_DISABLED(compositeAction);

			if ("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())
					&& "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
				COMP_POL_FRZ_FLAG.setDisabled(true);
				// compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(false);
				/* Added by Sivarajan on 28/03/2021 for Allaince IL */
				PT_IL_POLICY_HELPER helper = new PT_IL_POLICY_HELPER();
				String value = helper.toConvertButtonED(PT_IL_POLICY_BEAN.getPOL_NO());
				if ("Y".equalsIgnoreCase(value)) {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setDisabled(false);
				} else {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setDisabled(true);
				}
				/* End */
			} else if ("E".equals(PT_IL_POLICY_BEAN.getPOL_STATUS())
					&& "N".equals(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())
					&& "Y".equals(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
				COMP_POL_FRZ_FLAG.setDisabled(false);
				// compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(false);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL().setDisabled(false);
			} else {
				COMP_POL_FRZ_FLAG.setDisabled(false);
				// compositeAction.getDUMMY_ACTION_BEAN().get,
				// ().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setDisabled(true);
			}
		} else {
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setDisabled(true);

			System.out.println("*2222*");
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(false);

			// disableAllComponent(false);
			new PILT002_APAC_LOCAL_PROCEDURES().IL_BLOCK_POL_ENABLED(compositeAction);

			/* Added by Janani on 22.06.2018 for FLALIFEQC-1753794 */
			if (PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN().equalsIgnoreCase("y")) {
				COMP_POL_JOINT_LIFE_YN.setDisabled(false);
			}
			/* End */
		}

	}

	/*
	 * public String backButton() { CommonUtils.clearMaps(this); CommonUtils
	 * commonUtils = new CommonUtils();
	 * commonUtils.callRetaintion("PILT002_APAC_PT_IL_POLICY_SEARCH_ACTION",
	 * "fetchRecords"); return "PILT002_APAC"; }
	 */

	private void decideCaptionOfWizard() {

		if ("1".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"))
				|| "1".equalsIgnoreCase(CommonUtils.getGlobalVariable("POL_DS_TYPE"))) {
			setWizardCaption("Proposal Entry");
			compositeAction.getWizard().setWizardLabel("PILT002_APAC_PT_IL_POLICY", "Proposal Entry");
			compositeAction.getComp().setTitle("Proposal Information");
			/*
			 * commentted by Ameen for KIC to make from respective properties
			 * file getCOMP_POL_NO_LABEL().setValue("Proposal No.");
			 */
			getCOMP_POL_NO_LABEL().setValue(Messages.getString(
					CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE") + "messageProperties_PILT002_APAC",
					"PILT002_APAC$PT_IL_POLICY$UI_M_COPY_POL_NO_2$caption"));
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(true);
			CommonUtils.setGlobalVariable("POL_DS_TYPE", null);
		} else if ("2".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"))
				|| "2".equalsIgnoreCase(CommonUtils.getGlobalVariable("POL_DS_TYPE"))) {
			setWizardCaption("Policy Entry");
			compositeAction.getWizard().setWizardLabel("PILT002_APAC_PT_IL_POLICY", "Policy Entry");
			compositeAction.getComp().setTitle("Policy Information");
			/*
			 * commentted by Ameen for KIC to make from respective properties
			 * file getCOMP_POL_NO_LABEL().setValue("Policy No.");
			 */
			getCOMP_POL_NO_LABEL().setValue(Messages.getString(
					CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE") + "messageProperties_PILT002_APAC",
					"PILT002_APAC$PT_IL_POLICY$POL_NO$Caption"));
			if (!("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS()))) {
				// compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(true);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(false);
			}
			CommonUtils.setGlobalVariable("POL_DS_TYPE", null);
		}
	}

	// Added by Jyoti(55315) on 7th Jun'12
	public String backButton() {
		String outcome = null;

		String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
		String todmsworkflow = CommonUtils.getGlobalVariable("backValue");
		if (!"".equals(todmsworkflow) && todmsworkflow != null) {
			outcome = todmsworkflow;
			CommonUtils.setGlobalVariable("backValue", "");
		} else if (null == callingForm || callingForm.trim().isEmpty() || "PILP001_APAC".equals(callingForm)
				|| "PILT010".equals(callingForm)) {
			outcome = "PILT002_APAC";
		} else if (null != callingForm && !(callingForm.trim().isEmpty())
				&& "PILT006_APAC".equals(CommonUtils.getGlobalVariable("CLAIM_CALLING_FORM"))) {
			CommonUtils.setGlobalVariable("CLAIM_CALLING_FORM", "PILT002_APAC");
			outcome = "claimsEntry";
		}

		else if (CommonUtils.getGlobalVariable("GLOBAL.QUERY_BACK") != null
				&& CommonUtils.getGlobalVariable("GLOBAL.QUERY_BACK").equalsIgnoreCase("TRUE")) {
			outcome = "PILQ002-I01";
			CommonUtils.setGlobalVariable("GLOBAL.QUERY_BACK", null);
		} else {
			outcome = callingForm;
			// Removing integration paramters
			CommonUtils.getSession().removeAttribute("CALLING_FORM");
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
		PT_IL_POLICY_HELPER helper2 = new PT_IL_POLICY_HELPER();
		String message = null;
		try {
			/* added by gopi for toi on 14/06/2018 */
			String pol_frz_flag = PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG();
			String policy_aaprove = getPolicyApprove();
			if (pol_frz_flag != null && "Y".equalsIgnoreCase(pol_frz_flag)) {
				if (policy_aaprove != null && "O".equalsIgnoreCase(policy_aaprove)) {
					System.out.println(
							"PILPK_POLICY_APPROVAL().P_POLICY_DIRECT_APPROVAL PROCEDURE EXECUTED SUCCESSFULLY");
					new PILPK_POLICY_APPROVAL().P_POLICY_DIRECT_APPROVAL(PT_IL_POLICY_BEAN.getPOL_SYS_ID());
					setBlockFlag(true);
					onLoad(null);
					System.out.println("approveButtonAction POLICY NUMBER--------->" + PT_IL_POLICY_BEAN.getPOL_NO());
					message = "Policy Approved Successfully";

					String policyNumber = getPolicynumber();
					String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(
							PT_IL_POLICY_BEAN.getPOL_PROD_CODE(), "POL", policyNumber.toString(), "C", "");
					// end
					System.out.println("EMAIL STATUS MESSAGE-->" + emailStatusMessage);
					message = message + emailStatusMessage;

					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);

				} else {
					/* Added by Janani on 17-08-2017 for ZBILQC-1732439 */
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_BUS_REPORT_MODAL_PANEL()
							.setShowWhenRendered(false);
					/* end */

					/* added by raja 09-06-2017 for ZBILQC-1724894 */
					LIFELIB lifelib = new LIFELIB();
					lifelib.P_VAL_CUST(PT_IL_POLICY_BEAN.getPOL_CUST_CODE(), PT_IL_POLICY_BEAN.getUI_M_POL_CUST_DESC(),
							"N", "N", PT_IL_POLICY_BEAN.getPOL_DIVN_CODE());
					/* END */

					action = helper.UI_M_BUT_APPROVAL_WHEN_BUTTON_PRESSED(compositeAction);
					CommonUtils.setGlobalVariable("POL_CUST_CODE", this.getPT_IL_POLICY_BEAN().getPOL_CUST_CODE());
					if (isEndorseFlag()) {
						setEndorseFlag(false);
					}

				}

			}
			// end

			/*
			 * Added by Janani on 17-08-2017 for ZBILQC-1732439
			 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().
			 * getCOMP_BUS_REPORT_MODAL_PANEL().setShowWhenRendered(false); end
			 * 
			 * added by raja 09-06-2017 for ZBILQC-1724894 LIFELIB lifelib = new
			 * LIFELIB();
			 * lifelib.P_VAL_CUST(PT_IL_POLICY_BEAN.getPOL_CUST_CODE(),
			 * PT_IL_POLICY_BEAN.getUI_M_POL_CUST_DESC(), "N", "N",
			 * PT_IL_POLICY_BEAN.getPOL_DIVN_CODE()); END
			 * 
			 * action = helper
			 * .UI_M_BUT_APPROVAL_WHEN_BUTTON_PRESSED(compositeAction);
			 * CommonUtils.setGlobalVariable("POL_CUST_CODE",
			 * this.getPT_IL_POLICY_BEAN().getPOL_CUST_CODE()); if
			 * (isEndorseFlag()) { setEndorseFlag(false); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());

		}
		return action;
	}

	public String copyButtonAction() {
		String action = null;
		CommonUtils.clearMaps(this);
		COPY_HELPER helper = new COPY_HELPER();
		try {
			compositeAction.getCOPY_ACTION_BEAN().setCOPY_BEAN(new COPY());
			action = helper.UI_M_BUT_COPY_WHEN_BUTTON_PRESSED(compositeAction);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
		return action;
	}

	public String endorsementButtonAction() {
		CommonUtils.clearMaps(this);
		String endorsementScreenId = null;
		DUMMY_HELPER dummy_helper = new DUMMY_HELPER();

		/* Added by Ram on 07/04/2017 */
		ResultSet resultset = null;
		String query = null;
		String function_ret = null;
		/* End */

		try {
			setEndorseFlag(true);
			/* Added by Ram on 07/04/2017 */
			getProd_plan_type();
			/*
			 * Modified if condition by ganesh on 06-07-2017, as suggested by
			 * ajoy
			 */
			/* if("L".equalsIgnoreCase(PLAN_TYPE)) */

			/*
			 * Commentted &Modified by saritha on 05-09-2017 for ssp call id
			 * ZBILQC-1735997 as suggested by ajoy sir
			 */
			/*
			 * if(CommonUtils.isIN(PLAN_TYPE, "L","H")) {
			 * query="select P9ilpk_F_Policy.F_FUND_ENDT_VAL(?) from dual";
			 * query="select P9ilpk_F_Policy.F_FUND_ENDT_VAL_DC(?) from dual";
			 * 
			 * resultset=new CRUDHandler().executeSelectStatement(query,
			 * CommonUtils.getConnection(), new
			 * Object[]{PT_IL_POLICY_BEAN.getPOL_SYS_ID()});
			 * if(resultset.next()) { function_ret=resultset.getString(1); }
			 * 
			 * if(function_ret!=null && function_ret.equalsIgnoreCase("N")) {
			 * throw new
			 * Exception("Death Claim Register for Main member Endorsement not allowed for this policy"
			 * ); } }
			 */
			/* End */

			endorsementScreenId = dummy_helper.UI_M_BUT_ENDT_WHEN_BUTTON_PRESSED(compositeAction);

			/*
			 * Added by ganesh on 03-04-2017,to avoid CBC validation issue when
			 * come back to policy screen from endorsement
			 */
			setBlockFlag(true);
			/* end */

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
		return endorsementScreenId;
	}

	// added by soundarya for endorment issue on 5th may 2016

	public String endorsementOKButtonAction() {

		CommonUtils.clearMaps(this);
		String outCome = null;
		DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
		
		try {
			if(PT_IL_POLICY_BEAN.getPOL_END_TYPE().equals("009")){
			//coolOff period handled added by Mani suggested by KK Sir.
			String coolOffPeriod;
			String query1 = "SELECT NVL(to_Date(SYSDATE,'DD/MM/YYYY') - TO_DATE(POL_START_DT,'DD/MM/YYYY'),0) - nvl(PROD_COOLOFF_DAYS,0)FROM  PT_IL_POLICY , PM_IL_PRODUCT WHERE POL_PROD_CODE = PROD_CODE AND POL_NO = ?";
			ResultSet rs = null;
			Connection connection = null;
			
				connection = CommonUtils.getConnection();
				rs = new CRUDHandler().executeSelectStatement(query1, connection,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_NO() });
				while (rs.next()) {
					coolOffPeriod = rs.getString(1);
					if (Integer.parseInt(coolOffPeriod) > 0) {
						String message = "Cancellation cannot be done after the CoolOff Period";
						throw new Exception(message);
					}
				}
			}
			System.out.println("inside if ");
			System.out.println("Endorsment Code--->" + PT_IL_POLICY_BEAN.getPOL_END_CODE());
			System.out.println("PT_IL_POLICY_BEAN.getPOL_END_TYPE()           " + PT_IL_POLICY_BEAN.getPOL_END_TYPE());
			/*
			 * Added by ganesh on 01-02-2018 as suggested by gaurav for charge
			 * issue in Reinstatement Quotation
			 */
			if ("006".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
				new P9ILPK_PROCESS().P_REIN_TILL_DT(PT_IL_POLICY_BEAN.getPOL_SYS_ID().toString(),
						CommonUtils.dateToStringFormatter(new Date()));

			}
			/* end */
			helper.POL_END_EFF_FROM_DT_WHEN_VALIDATE_ITEM(compositeAction, PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT());

			updatePOL_END_EFF_FROM_DT(compositeAction);

			dummy_helper.UI_M_PT_ENDT_OK_WHEN_BUTTON_PRESSED(compositeAction);
			/* condition handled by Ameen on 07-09-2017 as per Siva sugg. */
			if ("009".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
				/*
				 * Added by Ameen on 18/11/2016 for Endorsement Cancellation
				 * Procedure
				 */
				new P9ILPK_ENDORSE().P_VALIDATE_PROCAN(PT_IL_POLICY_BEAN.getPOL_SYS_ID());
				/* End */
			}
			outCome = "PILT002_APAC_PT_IL_POLICY";

			/* Added by Janani on 13.03.2018 for FSD_FLA_IL_008 */

			checkEndCode();

			/* End of FSD_FLA_IL_008 */
			/* Added by pidugu raj dt: 26-08-2018 for KICLIFEQC-1762428 */
			PM_IL_PLAN planObj = helper.doGetPlanType(
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE());
			if (planObj != null && planObj.getPLAN_TYPE().equalsIgnoreCase("U")) {
				if (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()
						.equalsIgnoreCase("GEN016")) {
					helper.doDeleteFundDetailRecords(compositeAction);
				}

			}
			/* End Added by pidugu raj dt: 26-08-2018 for KICLIFEQC-1762428 */
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			// getErrorMap().put("Endt", e.getMessage());
		}
		return outCome;
	}

	public void updatePOL_END_EFF_FROM_DT(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		Connection connection = null;
		connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		DateFormat formatter1;
		formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
		/* System.out.println((Date)formatter1.parse("08/16/2011")); */
		Date datevaluefrom = PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT();
		Date datevalueto = PT_IL_POLICY_BEAN.getPOL_END_EFF_TO_DT();

		datevaluefrom = formatter1.parse(formatter1.format(datevaluefrom));

		datevalueto = formatter1.parse(formatter1.format(datevalueto));
		System.out.println("datevaluefrom       " + datevaluefrom);
		System.out.println("datevalueto-------------->" + datevalueto);
		long pol_sys_is = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
		System.out.println("pol_sys_is      " + pol_sys_is);
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		System.out.println("datevaluefrom------->" + datevaluefrom);
		System.out.println("datevalueto------->" + datevalueto);

		// String query = "UPDATE PT_IL_POLICY SET
		// POL_END_EFF_FROM_DT='"+datevaluefrom+"',POL_END_EFF_TO_DT='"+datevalueto+"'WHERE
		// POL_SYS_ID= ? ";
		/*
		 * String query =
		 * "UPDATE PT_IL_POLICY SET POL_END_EFF_FROM_DT='"+datevaluefrom+
		 * "',POL_END_EFF_TO_DT='"+datevalueto+"'WHERE POL_SYS_ID='"+pol_sys_is+
		 * "'";
		 */
		String query = "UPDATE PT_IL_POLICY SET POL_END_EFF_FROM_DT=?,POL_END_EFF_TO_DT=? WHERE POL_SYS_ID=?";

		System.out.println("query executed " + query);

		new CRUDHandler().executeUpdateStatement(query, connection,
				new Object[] { datevaluefrom, datevalueto, pol_sys_is });
		//// new CRUDHandler().executeUpdateStatement(query,
		//// connection,pol_sys_is);
		connection.commit();
	}

	// end

	/*
	 * public String endorsementOKButtonAction() { CommonUtils.clearMaps(this);
	 * String outCome = null; DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
	 * try { helper.POL_END_EFF_FROM_DT_WHEN_VALIDATE_ITEM(compositeAction,
	 * PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT());
	 * dummy_helper.UI_M_PT_ENDT_OK_WHEN_BUTTON_PRESSED(compositeAction);
	 * outCome = "PILT002_APAC_PT_IL_POLICY"; } catch (Exception e) {
	 * e.printStackTrace();
	 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * e.getMessage()); // getErrorMap().put("Endt", e.getMessage()); } return
	 * outCome; }
	 */

	public String endorsementCancelButtonAction() {
		String outCome = null;
		CommonUtils.clearMaps(this);
		try {
			outCome = "PILT002_APAC_PT_IL_POLICY";
			if (PT_IL_POLICY_BEAN.getPOL_END_NO() == null) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT().setDisabled(false);
			}
			setEndorseFlag(false);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
		return outCome;
	}

	private void doc_gen_noButton_Action() {
		DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
		CommonUtils.clearMaps(this);
		try {

			/*
			 * Added if condition by R. Raja for policy no generation issue on
			 * 17-12-2016
			 */

			if (PT_IL_POLICY_BEAN.getPOL_NO() == null) {

				/* end */
				dummy_helper.UI_M_BUT_DOC_GEN_NO_WHEN_BUTTON_PRESSED(PT_IL_POLICY_BEAN,
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(), compositeAction.getDUMMY_ACTION_BEAN());
			}
			if (PT_IL_POLICY_BEAN.getPOL_NO() != null) {
				COMP_POL_NO.setDisabled(true);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
		// return "PILT002_APAC_PT_IL_POLICY";
	}

	/* Added by Ram for 16/11/2016 for Business Rule Engine */
	public String busRulButtonAction() {
		/* Added bys saritha on 08-Jun-2017 for ssp call id ZBILQC-1721836 */
		CommonUtils.clearMaps(this);
		/* End */
		String returnValue = null;
		try {
			// GO_BLOCK('PT_BUS_RULE_ERROR_MSG');
			new PT_BUS_RULE_ERROR_MSG_DELEGATE().executeSelectStatement(compositeAction);
			/*
			 * compositeAction added by saritha on 04-08-2017 for freeze flag
			 * yes choose then save error: freeze flag null
			 */
			returnValue = businessModalPanel(compositeAction);
			/* End */
			/* return "PILT002_APAC_PT_BUS_RULE_ERROR_MSG"; */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	/* End */

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

	public void setCOMP_POL_CURR_SA_LIMIT_LABEL(HtmlOutputLabel comp_pol_curr_sa_limit_label) {
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

	public void setCOMP_PROP_LC_DEP_PREM_LABEL(HtmlOutputLabel comp_prop_lc_dep_prem_label) {
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

	public void setCOMP_PROP_FC_DEP_PREM_LABEL(HtmlOutputLabel comp_prop_fc_dep_prem_label) {
		COMP_PROP_FC_DEP_PREM_LABEL = comp_prop_fc_dep_prem_label;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PROD_GROUP_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_PROD_GROUP_CODE", null, null,
					null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PROD_CODE(Object currValue) {
		System.out.println("Welcome to lovPOL_PROD_CODE method");
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_PROD_CODE", null, null, null,
					null, null, (String) currValue);
			System.out.println("suggestionList     " + suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	/* changed by ram */

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PREM_OPTION(Object currValue) {
		System.out.println("Welcome to lovPOL_PREM_OPTION method");
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_PREM_OPT", "IL_PREM_OPT",
					null, null, null, null, (String) currValue);
			System.out.println("suggestionList     " + suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	/* end */
	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_INTRODUCER_REF_ID1(Object currValue) {

		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// PENDING
			// STD_CALL_LOV('PILH152','PT_IL_POLICY.POL_INTRODUCER_REF_ID1','BROKER',:PT_IL_POLICY.POL_DIVN_CODE,'BROKER');

			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_INTRODUCER_REF_ID1", "BROKER",
					PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), "BROKER", null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_STAFF_CCLASS_CODE(Object currValue) {

		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('PT_IL_POLICY.POL_STAFF_CCLASS_CODE','STAFF'); STAFF
			// for stm version only
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_STAFF_CCLASS_CODE", "002",
					null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<LovBean> lovUI_M_POL_CONT_AD_ACC_NO(Object object) {

		ArrayList<LovBean> suggestionList = null;
		ListItemUtil listitemutil = new ListItemUtil();
		String M_CREDIT_CARD_UPD_YN = null;
		String M_FOUND = null;
		String query1 = "SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N') FROM MENU_USER  WHERE USER_ID =? ";
		String lovQuery = "SELECT DECRYPT(CBAD_ACNT_NO,'DuRAc33s') FROM PM_CUST_BANK_ACNT_DTLS "
				+ "WHERE CBAD_CUST_CODE = ? AND CBAD_TYPE =  ?  AND (DECRYPT(CBAD_ACNT_NO,'DuRAc33s') LIKE ?  ) AND ROWNUM < 25 ";
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
				suggestionList = ListItemUtil.prepareSuggestionList(lovQuery, new Object[] {
						PT_IL_POLICY_BEAN.getPOL_CUST_CODE(), PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE(), currentValue });
			} else if ("N".equals(M_CREDIT_CARD_UPD_YN)) {
				suggestionList = ListItemUtil.prepareSuggestionList(lovQuery, new Object[] {
						PT_IL_POLICY_BEAN.getPOL_CUST_CODE(), PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE(), currentValue });
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_RI_POOL_CODE(Object currValue) {

		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('PT_IL_POLICY.POL_RI_POOL_CODE');
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_RI_POOL_CODE", null, null,
					null, null, null, (String) currValue);
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
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_RES_AREA_CODE", "POSTAL",
					null, null, null, null, (String) currValue);
			System.out.println(" LIST " + suggestionList);
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
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_CITY_CODE", "CITY", null,
					null, null, null, (String) currValue);
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
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_STATE_CODE", "STATE", null,
					null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_COUNT_CODE(Object currValue) {

		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('PT_IL_POLICY.POL_COUNT_CODE','COUNTRY');
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_COUNT_CODE", "COUNTRY", null,
					null, null, null, (String) currValue);
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
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_OFF_AREA_CODE", "POSTAL",
					null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<com.iii.premia.common.bean.LovBean> lovPOL_END_CODE(Object currValue) {

		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			/*
			 * Commented by sankaraNarayanan for lovendsement ref by Sivaraman
			 * sir on 23-10-2016
			 * 
			 * 
			 * 
			 * 
			 * if(!("S".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_MODE_OF_PYMT()
			 * ))){
			 */

			// end
			// P_CALL_LOV('PT_IL_POLICY.POL_END_CODE','3',:CTRL.M_USER_ID,:PT_IL_POLICY.POL_PROD_CODE);
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_END_CODE", "3",
					CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"), PT_IL_POLICY_BEAN.getPOL_PROD_CODE(), null, null,
					(String) currValue);

			/*
			 * 
			 * 
			 * 
			 * Commented by sankaraNarayanan for lovendsement ref by Sivaraman
			 * sir on 23-10-2016
			 * 
			 * }else{ LovBean bean = new LovBean(); bean.setCode("END001");
			 * bean.setName("Non-Financial Endorsement"); LovBean bean1 = new
			 * LovBean(); bean1.setCode("CANPOL");
			 * bean1.setName("Cancellation policy"); suggestionList.add(bean);
			 * suggestionList.add(bean1); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<LovBean> lovPOL_EMPLOYER_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		/*
		 * Modifed by Raja on 29/03/2017
		 * 
		 * String query =
		 * "SELECT  CONT_CODE,CONT_NAME  FROM   PM_IL_CONTRACTOR WHERE  CONT_EMPLOYER_YN ='Y' "
		 * + "AND (CONT_CODE LIKE ? OR CONT_NAME LIKE ?) AND ROWNUM < ?";
		 */

		String query = null;
		/* Added by saritha on 13-Jun-2017 for ssp call id ZBILQC-1720514 */
		/*
		 * condition modified by Ameen on 25-03-2018 for KIC to add crdit card &
		 * Knet option
		 * if((PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("AD"))||(
		 * PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("BS")))
		 */
		if ((PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("AD"))
				|| (PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("BS"))
				|| (PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("SC"))
				|| (PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("B"))) {
			/* End */

			/* changed by raja on 16-05-2017 */
			/*
			 * query =
			 * "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER,PM_CUST_CLASS " +
			 * "WHERE CUST_CLASS = CCLAS_CODE AND CCLAS_TYPE = 011 " +
			 * "AND (CUST_CODE LIKE ? OR CUST_NAME LIKE ?) AND ROWNUM < ?";
			 */
			/* Modified by ganesh on 31-05-2017, invalid column issue */
			// query = "SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE ROWNUM < ?
			// ORDER BY 1 ASC";
			query = "SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE (UPPER(BANK_CODE) LIKE ? OR UPPER(BANK_NAME) LIKE ?) AND ROWNUM < ?  ORDER BY 1 ASC";
			/* end */

			/* end */
		}
		/*
		 * Commented by sankara narayanan on 20-04-2017 else
		 * if(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("S"))
		 */
		/* Changed by Sankara narayanan on 20/04/2017 */

		/* Modified by saritha on 13-Jun-2017 for ssp call id ZBILQC-1720514 */
		/*
		 * else if(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("S") ||
		 * PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("BS") )
		 */

		/*
		 * Modified by Janani on 27.06.2018 for FLA as per Chandramohan sugges
		 */
		// else if(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("S"))

		else if (PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("S")
				|| PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE().equalsIgnoreCase("AO"))

		/* End of FLA */

		/* End */

		{ // end
			/*
			 * Modified by ganesh on 16-06-2017,ZBILQC-1719874 as per the girsh
			 * suggestion
			 */
			/*
			 * query =
			 * "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER,PM_CUST_CLASS " +
			 * "WHERE CUST_CLASS = CCLAS_CODE AND CCLAS_TYPE = 010 " +
			 * "AND (UPPER(CUST_CODE) LIKE ? OR UPPER(CUST_NAME) LIKE ?) AND ROWNUM < ?"
			 * ;
			 */

			/*
			 * query =
			 * "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER,PM_CUST_CLASS " +
			 * "WHERE CUST_CLASS = CCLAS_CODE AND CCLAS_TYPE in (010,001) " +
			 * "AND (UPPER(CUST_CODE) LIKE ? OR UPPER(CUST_NAME) LIKE ?) AND ROWNUM < ?"
			 * ;
			 */
			/* added by raja on 22-08-2017 for mop endorsement */
			/*
			 * query =
			 * "SELECT CONT_NAME,CONT_CODE, CONT_EMPLOYER_YN FROM PM_IL_CONTRACTOR WHERE CONT_EMPLOYER_YN = 'Y'"
			 * +
			 * "AND (UPPER(CUST_CODE) LIKE ? OR UPPER(CUST_NAME) LIKE ?) AND ROWNUM < ?"
			 * ;
			 */

			/*
			 * commented By Dhinesh 3-10-2017
			 * 
			 * query =
			 * "SELECT CONT_CODE,CONT_NAME, CONT_EMPLOYER_YN FROM PM_IL_CONTRACTOR WHERE CONT_EMPLOYER_YN = 'Y'"
			 * +
			 * "AND (UPPER(CONT_CODE) LIKE ? OR UPPER(CONT_NAME) LIKE ?) AND ROWNUM < ?"
			 * ;
			 */
			/* end */

			query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER,PM_CUST_CLASS  WHERE CUST_CLASS = CCLAS_CODE  AND"
					+ " (UPPER(CUST_CODE) LIKE ? OR UPPER(CUST_NAME) LIKE ?)  AND CCLAS_TYPE = '001' AND CUST_FLEX_SEL_01 = 'Y'   AND ROWNUM < ?";
		}
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue, PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PLAN_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {

			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_PLAN_CODE", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_SRC_OF_BUS(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {

			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_SRC_OF_BUS", "SRC_BUS_TY",
					null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_SUB_PLAN_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_SUB_PLAN_CODE",
					PT_IL_POLICY_BEAN.getPOL_PROD_CODE(), null, null, null, null, (String) currValue);
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
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_ADDL_STATUS",
					"IL_ADDL_STATUS", PT_IL_POLICY_BEAN.getPOL_DS_TYPE(), null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_CLM_ADDL_STATUS(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('PT_IL_POLICY.M_BUT_POL_ADDL_STATUS','IL_ADDL_STATUS',:PT_IL_POLICY.POL_DS_TYPE);
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_CLM_ADDL_STATUS",
					"IL_ADDL_STATUS", PT_IL_POLICY_BEAN.getPOL_DS_TYPE(), null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovM_BUT_POL_ADDL_STATUS(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		int M_VALUE = 0;
		try {

			if ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
					&& "P".equals(PT_IL_POLICY_BEAN.getPOL_PROP_QUOT_FLAG())) {

				M_VALUE = 1;
			} else if ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
					&& "Q".equals(PT_IL_POLICY_BEAN.getPOL_PROP_QUOT_FLAG())) {
				M_VALUE = 5;
			} else if ("2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())) {

				M_VALUE = 2;
				if (PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() > 0) {
					M_VALUE = 3;
				}
			}
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "DUMMY", "M_PS_STATUS", "IL_ADDL_STAT", M_VALUE,
					null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_CONT_AD_BANK_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {

			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_CONT_AD_BANK_CODE", null,
					null, null, null, null, (String) currValue);
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
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_PROJECT_CODE", "IL_PROJ_CODE",
					null, null, null, null, (String) currValue);
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
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_CLASS_CODE", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_DEVELOPER_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('PT_IL_POLICY.POL_DEVELOPER_CODE','IL_DVP_CODE');
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_DEVELOPER_CODE",
					"IL_DVP_CODE", null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<LovBean> lovPOL_ASSRD_REF_ID1(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PELConstants.suggetionRecordSize };
				query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID1_QUERY;
			} else {
				object = new Object[] { code + "%", code + "%", PELConstants.suggetionRecordSize };
				query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID1_QUERY_LIKE;
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);

			/*
			 * added by R. Raja on 08-07-2016 for ssp call no FALCONQC-1714559
			 */

			PT_IL_POLICY_BEAN.setASSURED_NAME_FLAG(false);

			/* End of SSP Call ID - FALCONQC-1714559 */

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
		try {
			if ("*".equals(code)) {
				object = new Object[] { PELConstants.suggetionRecordSize };
				query = PT_IL_POLICY_QUERY_CONSTANTS.POL_CONT_CODE_QUERY;
			} else {
				object = new Object[] { code + "%", code + "%", PELConstants.suggetionRecordSize };
				query = PT_IL_POLICY_QUERY_CONSTANTS.POL_CONT_CODE_QUERY_LIKE;
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);

			/*
			 * added by R. Raja on 08-07-2016 for ssp call no FALCONQC-1714559�
			 */

			PT_IL_POLICY_BEAN.setASSURED_NAME_FLAG(true);

			/* End of SSP Call ID - FAL-001-2016-0015875 FALCONQC-1714559� */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	// added by gopi for toi on 04/06/18
	public ArrayList<LovBean> lovPOL_ASSRD_REF_ID2(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		Connection connection = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String cust_code = null;
		String Benef_cust_flag = null;
		try {
			Benef_cust_flag = getBeneficiary_as_customer();
			if (Benef_cust_flag != null && "Y".equalsIgnoreCase(Benef_cust_flag)) {

				String query1 = "SELECT CUST_CODE FROM PM_CUSTOMER WHERE CUST_REF_ID1=?";
				connection = CommonUtils.getConnection();
				rs = new CRUDHandler().executeSelectStatement(query1, connection,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1() });
				if (rs.next()) {
					cust_code = rs.getString("CUST_CODE");
				}
				if ("*".equals(code)) {
					object = new Object[] { PELConstants.suggetionRecordSize, cust_code,
							PT_IL_POLICY_BEAN.getPOL_PROD_CODE() };
					query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID2_QUERY;
				} else {
					object = new Object[] { code + "%", code + "%", PELConstants.suggetionRecordSize, cust_code,
							PT_IL_POLICY_BEAN.getPOL_PROD_CODE() };
					query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID2_QUERY_LIKE;
				}
				suggestionList = ListItemUtil.prepareSuggestionList(query, object);

				/*
				 * added by R. Raja on 08-07-2016 for ssp call no
				 * FALCONQC-1714559�
				 */

				PT_IL_POLICY_BEAN.setASSURED_NAME_FLAG(false);

				/* End of SSP Call ID - FALCONQC-1714559� */
			} else {
				if ("*".equals(code)) {
					object = new Object[] { PELConstants.suggetionRecordSize };
					query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID1_QUERY;
				} else {
					object = new Object[] { code + "%", code + "%", PELConstants.suggetionRecordSize };
					query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID1_QUERY_LIKE;
				}
				suggestionList = ListItemUtil.prepareSuggestionList(query, object);

				/*
				 * added by R. Raja on 08-07-2016 for ssp call no
				 * FALCONQC-1714559�
				 */

				PT_IL_POLICY_BEAN.setASSURED_NAME_FLAG(false);

				/* End of SSP Call ID - FALCONQC-1714559� */

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	// end

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_BANK_BRANCH_NAME(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			if (!"C".equals(PT_IL_POLICY_BEAN.getPOL_GRANTEE_TYPE())) {
				suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_BANK_BRANCH_NAME",
						PT_IL_POLICY_BEAN.getPOL_CUST_CODE(), null, null, null, null, (String) currValue);

				// P_CALL_LOV('PT_IL_POLICY.POL_BANK_BRANCH_NAME',:PT_IL_POLICY.POL_CUST_CODE);
			} else {
				suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_BANK_BRANCH_NAME", "1",
						null, null, null, null, (String) currValue);
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

			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_SA_CURR_CODE",
					PT_IL_POLICY_BEAN.getPOL_CUST_CODE(), null, null, null, null, (String) currValue);
			if (currValue == null || currValue.toString().isEmpty()) {
				PT_IL_POLICY_BEAN.setUI_M_POL_SA_CURR_DESC(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<com.iii.premia.common.bean.LovBean> lovPOAD_RELIGION_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('PT_IL_POL_ASSURED_DTLS.POAD_RELIGION_CODE','RELIGION');

			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POAD_RELIGION_CODE", "RELIGION",
					null, null, null, null, (String) currValue);
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

			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_DIVN_CODE",
					CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"), null, null, null, (String) currValue);
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

			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_DEPT_CODE",
					CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(),
					CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"), null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_CUST_CURR_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('PT_IL_POLICY.POL_CUST_CURR_CODE',
			// :PT_IL_POLICY.POL_CUST_CODE);
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_CUST_CURR_CODE",
					PT_IL_POLICY_BEAN.getPOL_CUST_CODE(), null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	/*
	 * public ArrayList<LovBean> lovPOL_CUST_CODE(Object currValue) {
	 * ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new
	 * ArrayList<com.iii.premia.common.bean.LovBean>(); ListItemUtil
	 * listitemutil = new ListItemUtil(); String M_FACIN_YN = null; String query
	 * = " SELECT NVL(CLASS_FACIN_YN, 'N') FROM PM_IL_CLASS" + " WHERE
	 * CLASS_CODE = ? ";
	 * 
	 * ResultSet rs = null; Connection connection = null;
	 * 
	 * try { connection = CommonUtils.getConnection(); rs = new
	 * CRUDHandler().executeSelectStatement(query, connection, new Object[] {
	 * PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });
	 * 
	 * while (rs.next()) { M_FACIN_YN = rs.getString(1); } if
	 * ("1".equals(compositeAction.getDUMMY_ACTION_BEAN()
	 * .getDUMMY_BEAN().getUI_M_CALC_METHOD()) && "C".equals(CommonUtils
	 * .getGlobalVariable("GLOBAL.M_PARA_7"))) {
	 * 
	 * suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY",
	 * "POL_CUST_CODE", "BANK", PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), "BANK",
	 * null, null, (String) currValue); //
	 * STD_CALL_LOV('PILH152','PT_IL_POLICY.POL_CUST_CODE','BANK',:PT_IL_POLICY.
	 * POL_DIVN_CODE,'BANK'); } else { if
	 * ("N".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN .getPOL_CASH_YN(), "N"))) {
	 * if ("N".equals(CommonUtils.nvl(M_FACIN_YN, "N"))) {
	 * 
	 * suggestionList = listitemutil.P_CALL_LOV( "PILT002_APAC", "PT_IL_POLICY",
	 * "POL_CUST_CODE", "CUSTOMER", PT_IL_POLICY_BEAN .getPOL_DIVN_CODE(),
	 * "CUSTOMER", null, null, (String) currValue); //
	 * STD_CALL_LOV('PILH152','PT_IL_POLICY.POL_CUST_CODE','CUSTOMER',:
	 * PT_IL_POLICY.POL_DIVN_CODE,'CUSTOMER'); } else { suggestionList =
	 * listitemutil.P_CALL_LOV( "PILT002_APAC", "PT_IL_POLICY", "POL_CUST_CODE",
	 * "REINS", PT_IL_POLICY_BEAN .getPOL_DIVN_CODE(), "REINS", null, null,
	 * (String) currValue); //
	 * STD_CALL_LOV('PILH152','PT_IL_POLICY.POL_CUST_CODE','REINS',:PT_IL_POLICY
	 * .POL_DIVN_CODE,'REINS'); } } else { suggestionList =
	 * listitemutil.P_CALL_LOV("PILT002_APAC", "PT_IL_POLICY", "POL_CUST_CODE",
	 * "CASH", PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), "CASH", null, null,
	 * (String) currValue); //
	 * STD_CALL_LOV('PILH152','PT_IL_POLICY.POL_CUST_CODE','CASH',:PT_IL_POLICY.
	 * POL_DIVN_CODE,'CASH'); } } } catch (Exception e) { e.printStackTrace(); }
	 * return suggestionList; }
	 */

	// CALL THE Validator
	public void validatePOL_WAQAF_PERIOD_TO(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_WAQAF_PERIOD_TO_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_WAQAF_PERIOD_TO((Double) value);
			// COMP_POL_WAQAF_PERIOD_TO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_WAQAF_PERIOD_TO",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_WAQAF_PERIOD_FM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_WAQAF_PERIOD_FM_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_WAQAF_PERIOD_FM((Double) value);
			// COMP_POL_WAQAF_PERIOD_FM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_WAQAF_PERIOD_FM",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_DEF_PERIOD_TO(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_DEF_PERIOD_TO_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_DEF_PERIOD_TO((Double) value);
			// COMP_POL_DEF_PERIOD_TO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_DEF_PERIOD_TO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_DEF_PERIOD_FM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			helper.POL_DEF_PERIOD_FM_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_PERIOD((Integer) value);
			// COMP_POL_DEF_PERIOD_FM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_DEF_PERIOD_FM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_BASIC_RATE1(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_BASIC_RATE1_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_BASIC_RATE1((Double) value);
			// COMP_POL_BASIC_RATE1.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_BASIC_RATE1", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LC_BASIC_PREM1(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			// helper.POL_LC_BASIC_PREM1_WHEN_VALIDATE_ITEM(
			// compositeAction,Doublevalue));
			// COMP_POL_LC_BASIC_PREM1.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LC_BASIC_PREM1",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CLASS_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_CLASS_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_CLASS_CODE((String) value);
			// COMP_POL_CLASS_CODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CLASS_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_DEPT_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_DEPT_CODE((String) value);
			helper.POL_DEPT_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			COMP_UI_M_POL_DEPT_DESC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_DEPT_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_DIVN_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_DIVN_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_DIVN_CODE((String) value);
			COMP_UI_M_POL_DIVN_DESC.resetValue();
			// COMP_POL_DIVN_CODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_DIVN_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LC_PRE_TPD_BNF(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_LC_PRE_TPD_BNF_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_LC_PRE_TPD_BNF((Double) value);
			// COMP_POL_LC_PRE_TPD_BNF.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LC_PRE_TPD_BNF",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FC_PRE_TPD_BNF(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_FC_PRE_TPD_BNF_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_FC_PRE_TPD_BNF((Double) value);
			// COMP_POL_FC_PRE_TPD_BNF.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_PRE_TPD_BNF",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LC_CLIENT_ALLOC_AMT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_LC_CLIENT_ALLOC_AMT_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_LC_CLIENT_ALLOC_AMT((Double) value);

			// COMP_POL_LC_CLIENT_ALLOC_AMT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LC_CLIENT_ALLOC_AMT",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FC_CLIENT_ALLOC_AMT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_FC_CLIENT_ALLOC_AMT_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_FC_CLIENT_ALLOC_AMT((Double) value);
			// COMP_POL_FC_CLIENT_ALLOC_AMT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_CLIENT_ALLOC_AMT",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LC_BANK_ALLOC_AMT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_LC_BANK_ALLOC_AMT_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_LC_BANK_ALLOC_AMT((Double) value);
			// COMP_POL_LC_BANK_ALLOC_AMT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LC_BANK_ALLOC_AMT",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FC_BANK_ALLOC_AMT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_FC_BANK_ALLOC_AMT_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_FC_BANK_ALLOC_AMT((Double) value);
			// COMP_POL_FC_BANK_ALLOC_AMT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_BANK_ALLOC_AMT",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LC_NET_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_LC_NET_PREM_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_LC_NET_PREM((Double) value);
			// COMP_POL_LC_NET_PREM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LC_NET_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FC_NET_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_FC_NET_PREM_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_FC_NET_PREM((Double) value);
			// COMP_POL_FC_NET_PREM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_NET_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LC_SENABEL_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			helper.POL_LC_SENABEL_PREM_WHEN_VALIDATE_ITEM(compositeAction);
			PT_IL_POLICY_BEAN.setPOL_LC_SENABEL_PREM((Double) value);
			// COMP_POL_LC_SENABEL_PREM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LC_SENABEL_PREM",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FC_SENABEL_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_FC_SENABEL_PREM_WHEN_VALIDATE_ITEM(compositeAction);
			PT_IL_POLICY_BEAN.setPOL_FC_SENABEL_PREM((Double) value);
			// COMP_POL_FC_SENABEL_PREM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_SENABEL_PREM",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LC_AMAN_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_LC_AMAN_PREM_WHEN_VALIDATE_ITEM(compositeAction);
			PT_IL_POLICY_BEAN.setPOL_LC_AMAN_PREM((Double) value);
			// COMP_POL_LC_AMAN_PREM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LC_AMAN_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FC_AMAN_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_FC_AMAN_PREM_WHEN_VALIDATE_ITEM(compositeAction);
			PT_IL_POLICY_BEAN.setPOL_FC_AMAN_PREM((Double) value);
			// COMP_POL_FC_AMAN_PREM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_AMAN_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_END_EFF_TO_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		try {
			helper.POL_END_EFF_TO_DT_WHEN_VALIDATE_ITEM(compositeAction, curDate);
			PT_IL_POLICY_BEAN.setPOL_END_EFF_TO_DT(curDate);
			// COMP_POL_END_EFF_TO_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_END_EFF_TO_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_END_EFF_FROM_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		try {
			PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT((Date) value);
			helper.POL_END_EFF_FROM_DT_WHEN_VALIDATE_ITEM(compositeAction, curDate); // added
																						// to
																						// fix
																						// P11JLIFEQC-1678487
			// COMP_POL_END_EFF_FROM_DT.resetValue();
			COMP_POL_END_EFF_TO_DT.resetValue();
			compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_AGE().resetValue();
			compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getCOMP_POAD_AGE().resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_END_EFF_FROM_DT",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_END_NO(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_END_NO_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_END_NO((String) value);
			// COMP_POL_END_NO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_END_NO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_TARIFF_TERM_FLAG(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_TARIFF_TERM_FLAG((String) value);
			// COMP_POL_END_NO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_END_NO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_END_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		Date sysdate = new Date();
		try {
			// added by saranya for ssp call id FALCONQC-1716236
			PT_IL_POLICY_BEAN.setPOL_END_DT(curDate);
			Long POL_SYS_ID = PT_IL_POLICY_BEAN.getPOL_SYS_ID();
			Date POL_END_DT = PT_IL_POLICY_BEAN.getPOL_END_DT();
			String POL_END_TYPE = PT_IL_POLICY_BEAN.getPOL_END_TYPE();
			System.out.println("Date value-->" + POL_END_DT);
			helper.P_VALIDATE_END_EFF_DT(String.valueOf(POL_SYS_ID), CommonUtils.dateToStringFormatter(POL_END_DT),
					POL_END_TYPE);
			// end
			helper.POL_END_DT_WHEN_VALIDATE_ITEM(compositeAction, curDate);
			if (PT_IL_POLICY_BEAN.getPOL_END_DT().after(sysdate)) {
				throw new Exception("Endorsement Date should not be grater than Current Date");
			}
			COMP_POL_END_DT.resetValue();
			COMP_POL_END_EFF_FROM_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_END_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * throws DBException Added by sivarajan on 12-08-2018 for KICLIFEQC-1761314
	 */
	public void validatePOL_END_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException, DBException {
		CommonUtils.clearMaps(this);

		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		/* Added by Sivarajan on 12-08-2018 for KICLIFEQC-1761314 */
		ResultSet resultSet = null;
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		String ps_value = null;
		try {
			helper.POL_END_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_END_CODE((String) value);
			System.out.println("Endorsement Code::::" + PT_IL_POLICY_BEAN.getPOL_END_CODE());

			/*
			 * As per the requirement by vinoth, except General endorsement
			 * other endorsement should send the endorsement date not effective
			 * date
			 * 
			 * ssp call id FALCONQC-1714633 added by ganesh
			 */

			System.out.println(
					"Endorsement type [" + (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000") + "]"));

			validatemethod();

			/* Added by ganesh on 06-07-2017, as suggested by ajoy */
			validateDependentEnd();
			/* end */

			COMP_POL_END_DESC.resetValue();

			/*
			 * Added by ganesh on 03-04-2017, need to default endorsement eff.
			 * from date to nextanniversaryrenewal date only for MOP endorsment
			 * other than inception date should default sugested by Mr.Ajoy
			 */
			System.out.println("endFromDateSysParam-->" + endFromDateSysParam);

			// Modified by ganesh on 13-04-2017 set effective from date at first
			// time only not all time.*/
			/* if(endFromDateSysParam.intValue() == 2){ */
			/*
			 * commented by Ameen on 21-06-2017 as per ZB requirement except
			 * POL_EN_TYPE = 001 every endorsement want to set next unpaid prem.
			 * collection date : ZBILQC-1719974
			 * if(endFromDateSysParam.intValue() == 2 &&
			 * PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT()==null){
			 * 
			 * 
			 * 
			 * 
			 * String endorseType = PT_IL_POLICY_BEAN.getPOL_END_TYPE();
			 * System.out.println("End type-->"+endorseType);
			 * if(endorseType.equals("007")){ fetchNextAnniversaryRenewalDate();
			 * }else{
			 * PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(PT_IL_POLICY_BEAN.
			 * getPOL_START_DT()); } COMP_POL_END_EFF_FROM_DT.resetValue();
			 * 
			 * }
			 */
			/* end */

			/* Added by Ameen on 21-06-2017 for ZBILQC-1719974 */
			String endorseType = PT_IL_POLICY_BEAN.getPOL_END_TYPE();
			System.out.println("End type-->" + endorseType);
			/* if(!"001".equals(endorseType) && !"006".equals(endorseType)) */
			/* Modified by ganesh on 17-08-2017 for 1719674 */
			/* if(!CommonUtils.isIN(endorseType,"001","009","006")) */
			/* Added by Sivarajan on 12-08-2018 for KICLIFEQC-1761314 */
			String subQry = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'DFLT_END_DT' ";
			resultSet = handler.executeSelectStatement(subQry, connection);
			if (resultSet.next()) {
				ps_value = resultSet.getString("PS_VALUE");
			}
			if (!"1".equalsIgnoreCase(ps_value)) {
				if (CommonUtils.isIN(endorseType, "009", "006")) {
					PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(PT_IL_POLICY_BEAN.getPOL_START_DT());

				}

				/* Modified by ganesh on 28-08-2017 as suggested by ajoy */
				/*
				 * else if(PT_IL_POLICY_BEAN.getPOL_END_CODE().equalsIgnoreCase(
				 * "DMWP"))
				 */
				else if (CommonUtils.isIN(endorseType, "001")) {
					PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(new CommonUtils().getCurrentDate());
				} else if (endorseType.equalsIgnoreCase("007")) {
					COMP_UI_M_MOP_END.setDisabled(false);
					COMP_UI_M_MOP_END.setRequired(true);
				} else {
					nextPremCollDate();
				}
			}
			if (endorseType.equalsIgnoreCase("007")) {
				COMP_UI_M_MOP_END.setDisabled(false);
				COMP_UI_M_MOP_END.setRequired(true);
			} else {
				COMP_UI_M_MOP_END.setDisabled(true);
				COMP_UI_M_MOP_END.setRequired(false);
			}
			System.out.println("nextPremCollDate::" + PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT());

			COMP_POL_END_EFF_FROM_DT.resetValue();
			/* End */

			/*
			 * commented by saranya for ssp call id FALCONQC-1716236
			 * 
			 * 
			 * 
			 * 
			 */
			/*
			 * if((CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(),
			 * "000").equalsIgnoreCase("002"))){
			 * //COMP_UI_M_BUT_ENDT_OK.setDisabled(true); throw new
			 * Exception("Premium due exists - Cannot proceed with Financial Endorsement"
			 * );
			 * 
			 * }
			 */

			// added by soundarya for defaulting the endorsement date
			// COMP_POL_END_EFF_FROM_DT.resetValue();
			// Commented by Ameen on 28-03-2017 as per Ajoy suggestion not to
			// default endorsment from date.
			/*
			 * if (PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT() == null) {
			 * PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(PT_IL_POLICY_BEAN.
			 * getPOL_START_DT()); }
			 */
			// end
			/*
			 * Commented by Ameen on 28-03-2017 as per Ajoy suggestion to set
			 * value in onload and disable the field
			 * PT_IL_POLICY_BEAN.setPOL_END_EFF_TO_DT(PT_IL_POLICY_BEAN.
			 * getPOL_EXPIRY_DT());
			 */
			System.out.println(PT_IL_POLICY_BEAN.getPOL_START_DT() + "," + PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT()
					+ "," + PT_IL_POLICY_BEAN.getPOL_EXPIRY_DT());

			// end

			// Commented by Ameen on 28-03-2017 as per Ajoy suggestion not to
			// default endorsment from date.
			/*
			 * if(PT_IL_POLICY_BEAN.getPOL_END_TYPE().equalsIgnoreCase("012")){
			 * if (PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT() == null) {
			 * PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(PT_IL_POLICY_BEAN.
			 * getPOL_START_DT()); COMP_POL_END_EFF_FROM_DT.setDisabled(true);
			 * 
			 * } }else{ COMP_POL_END_EFF_FROM_DT.setDisabled(false); }
			 * if(PT_IL_POLICY_BEAN.getPOL_END_TYPE().equalsIgnoreCase("009")){
			 * 
			 * if (PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT() == null) {
			 * PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(PT_IL_POLICY_BEAN.
			 * getPOL_START_DT()); } }
			 */
			// END
			if ("020".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000"))) {
				if (!"L".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS())) {
					throw new Exception("Special Revival Endorsement can be passed only for Lapsed Policy ");
				}
			}

			/*
			 * Date sysdate = new Date(); String sysdateString =
			 * CommonUtils.dateToStringFormat(sysdate);
			 * PT_IL_POLICY_BEAN.setPOL_END_DT(CommonUtils.stringToDate(
			 * sysdateString, "dd/MM/yyyy"));
			 */
			COMP_POL_END_DT.resetValue();

			// COMP_POL_END_CODE.resetValue();

			// validatemethod();

			/* Added by Janani on 07.03.2018 for FSD_FLA_IL_008 */

			System.out.println("getChkEndCode                             " + this.getChkEndCode());

			if (PT_IL_POLICY_BEAN.getPOL_END_CODE().equalsIgnoreCase(this.getChkEndCode())
					&& ((compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN()
							.getPOAD_FAMILY_YN() != null
							&& compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN()
									.getPOAD_OCC_YN() != null)
							&& (compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN()
									.getPOAD_FAMILY_YN().equalsIgnoreCase("N")
									&& compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
											.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_OCC_YN().equalsIgnoreCase("n"))))

			{
				throw new Exception(PT_IL_POLICY_BEAN.getPOL_END_CODE() + " is not applicable");
			}

			/* End of FSD_FLA_IL_008 */

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_END_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_HEALTH_RATE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_HEALTH_RATE_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_HEALTH_RATE((Double) value);

			// COMP_POL_HEALTH_RATE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_HEALTH_RATE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_OCC_RATE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_OCC_RATE_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_OCC_RATE((Double) value);
			COMP_POL_OCC_RATE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_OCC_RATE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LC_BASIC_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_LC_BASIC_PREM((Double) value);
			// helper.POL_LC_BASIC_PREM_WHEN_VALIDATE_ITEM( compositeAction,
			// value);
			// COMP_POL_LC_BASIC_PREM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LC_BASIC_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FC_BASIC_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_FC_BASIC_PREM_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_FC_BASIC_PREM((Double) value);
			COMP_POL_FC_BASIC_PREM.resetValue();
			COMP_POL_LC_BASIC_PREM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_BASIC_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_BASIC_RATE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_BASIC_RATE_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_BASIC_RATE((Double) value);
			// COMP_POL_BASIC_RATE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_BASIC_RATE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_OFF_AREA_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_OFF_AREA_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_OFF_AREA_CODE((String) value);

			// COMP_POL_OFF_AREA_CODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_OFF_AREA_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_COUNT_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		String values = (String) value;
		try {
			helper.POL_COUNT_CODE_WHEN_VALIDATE_ITEM(compositeAction, values);
			PT_IL_POLICY_BEAN.setPOL_COUNT_CODE(values);
			// COMP_POL_COUNT_CODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_COUNT_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_STATE_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_STATE_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_STATE_CODE((String) value);
			// COMP_POL_STATE_CODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_STATE_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CITY_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_CITY_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_CITY_CODE((String) value);
			// COMP_POL_CITY_CODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CITY_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_RES_AREA_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_RES_AREA_CODE((String) value);
			helper.POL_RES_AREA_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			COMP_UI_M_POL_RES_AREA_CODE_DESC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_RES_AREA_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FRZ_FLAG(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_FRZ_FLAG_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			if ("Y".equalsIgnoreCase((String) value)) {
				helper.checkFreeze(PT_IL_POLICY_BEAN, compositeAction);

				/*
				 * double fundAllocatedPercentageTotal = 0.00; for
				 * (PT_IL_POL_FUND_DTL fund : compositeAction
				 * .getPT_IL_POL_FUND_DTL_ACTION_BEAN()
				 * .getDataList_PT_IL_POL_FUND_DTL()) {
				 * fundAllocatedPercentageTotal = fundAllocatedPercentageTotal +
				 * fund.getPOFD_FUND_PERC();
				 * 
				 * if(fundAllocatedPercentageTotal != 100.00){ throw new
				 * Exception("Kindly add fund details with 100 % allocation"); }
				 * }
				 */
				// added by saranya
				ArrayList<OracleParameter> pValOrclList = null;
				String M_PREMIUM_WITHIN_LIMIT_YN = null;
				PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
				PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
				pValOrclList = new P9ILPK_POLICY().CHECK_LC_PREMIUM_LIMIT(
						CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()), M_PREMIUM_WITHIN_LIMIT_YN);
				System.out.println("outcome of pValOrclList  -->" + pValOrclList);
				if (!pValOrclList.isEmpty()) {
					System.out.println(
							"pValOrclList.get(0).getValueObject()--->" + pValOrclList.get(0) + " " + pValOrclList);
					if (pValOrclList.get(0).getValue() != null) {
						M_PREMIUM_WITHIN_LIMIT_YN = (String) pValOrclList.get(0).getValue();
					}
				}

				/*
				 * commented by dhinesh on 12-06-2017 for canpol endorsement
				 * error message validation
				 * 
				 * if (CommonUtils.nvl(M_PREMIUM_WITHIN_LIMIT_YN,
				 * "X").equals("N")) { throw new Exception(Messages.getString(
				 * PELConstants.pelErrorMessagePath, "91330")); }
				 */

				/*
				 * Newly added by Dhinesh on 12-06-2017 for canpol endorsement
				 * error message validation
				 */

				if (!"009".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE())) {
					if (CommonUtils.nvl(M_PREMIUM_WITHIN_LIMIT_YN, "X").equals("N")) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91330"));
					}
				}

				/* End */

			}

			/*
			 * 
			 * Commented by sankara narayanan for frz flag is handled by ui
			 * component on 21-03-2017
			 * 
			 * PT_IL_POLICY_BEAN.setPOL_FRZ_FLAG((String) value);
			 */
			/*
			 * Added by sankara narayanan for uicomponent frz flag on 21-03-2017
			 */
			PT_IL_POLICY_BEAN.setUI_POL_FRZ_FLAG((String) value);
			// end

			/* ADDED BY RAJA ON 07-07-2017 FOR ZBILQC-1730135 */
			if (PT_IL_POLICY_BEAN.getUI_POL_FRZ_FLAG() != null
					&& PT_IL_POLICY_BEAN.getUI_POL_FRZ_FLAG().equalsIgnoreCase("Y")) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(false);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(true);

				/*
				 * Newly Added By Dhinesh on 11.8.2017 for ssp call id :
				 * ZBILQC-1733134
				 */
				/*
				 * commentd by Ameen on 19-04-2018 for KIC to place it in ajaz
				 * event PT_IL_POLICY_BEAN.setPOL_FLEX_20(null);
				 */
				/* End */
			}
			/* END */

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FRZ_FLAG", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_PROP_REF_NO(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_PROP_REF_NO_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_PROP_REF_NO((String) value);
			// COMP_POL_PROP_REF_NO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PROP_REF_NO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CREDIT_DISCOUNT_PERC(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_CREDIT_DISCOUNT_PERC_WHEN_VALIDATE_ITEM((Double) value);
			PT_IL_POLICY_BEAN.setPOL_CREDIT_DISCOUNT_PERC((Double) value);
			// COMP_POL_CREDIT_DISCOUNT_PERC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CREDIT_DISCOUNT_PERC",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LOAD_PERC(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_LOAD_PERC_WHEN_VALIDATE_ITEM((Double) value);
			PT_IL_POLICY_BEAN.setPOL_LOAD_PERC((Double) value);
			// COMP_POL_LOAD_PERC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LOAD_PERC", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_EXC_INT_PERC(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_EXC_INT_PERC_WHEN_VALIDATE_ITEM((Double) value);
			PT_IL_POLICY_BEAN.setPOL_EXC_INT_PERC((Double) value);
			// COMP_POL_EXC_INT_PERC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_EXC_INT_PERC", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FC_EXC_INT_AMT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_FC_EXC_INT_AMT_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_FC_EXC_INT_AMT((Double) value);
			// COMP_POL_FC_EXC_INT_AMT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_EXC_INT_AMT",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LC_EXC_INT_AMT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Double cuDouble = (Double) value;
		try {
			cuDouble = helper.POL_LC_EXC_INT_AMT_WHEN_VALIDATE_ITEM(compositeAction, cuDouble);
			PT_IL_POLICY_BEAN.setPOL_LC_EXC_INT_AMT(cuDouble);
			// COMP_POL_LC_EXC_INT_AMT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LC_EXC_INT_AMT",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_PROP_DECL_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		try {
			helper.POL_PROP_DECL_DT_WHEN_VALIDATE_ITEM(compositeAction, curDate);
			PT_IL_POLICY_BEAN.setPOL_PROP_DECL_DT(curDate);
			// COMP_POL_PROP_DECL_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PROP_DECL_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_PROP_STAMP_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		try {
			PT_IL_POLICY_BEAN.setPOL_PROP_STAMP_DT(curDate);
			helper.POL_PROP_STAMP_DT_WHEN_VALIDATE_ITEM(compositeAction, curDate);

			// COMP_POL_PROP_STAMP_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PROP_STAMP_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_PROP_RECV_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		try {
			PT_IL_POLICY_BEAN.setPOL_PROP_RECV_DT(curDate);
			helper.POL_PROP_RECV_DT_WHEN_VALIDATE_ITEM(compositeAction, curDate);

			// COMP_POL_PROP_RECV_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PROP_RECV_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_PROJECT_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_PROJECT_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_PROJECT_CODE((String) value);
			COMP_POL_DEVELOPER_CODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PROJECT_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_PROFIT_RATE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_PROFIT_RATE_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_PROFIT_RATE((Double) value);
			// COMP_POL_PROFIT_RATE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PROFIT_RATE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_AUTH_LIMIT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_AUTH_LIMIT((Double) value);
			helper.POL_AUTH_LIMIT_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_AUTH_LIMIT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CARD_HOLDER_NAME(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_CARD_HOLDER_NAME((String) value);
			helper.POL_CARD_HOLDER_NAME_WHEN_VALIDATE_ITEM(compositeAction, (String) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CARD_HOLDER_NAME",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CONT_AD_BANK_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_CONT_AD_BANK_CODE((String) value);
			helper.POL_CONT_AD_BANK_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			COMP_UI_M_BANK_CODE_DESC.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CONT_AD_BANK_CODE",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateUI_M_POL_CONT_AD_ACC_NO(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setUI_M_POL_CONT_AD_ACC_NO((Long) value);
			helper.UI_M_POL_CONT_AD_ACC_NO_WHEN_VALIDATE_ITEM(compositeAction, (Long) value);
			// COMP_UI_M_POL_CONT_AD_ACC_NO.resetValue();
			/* Added by Ameen on 01-04-2018 for KIC Method of collection */
			PT_IL_POLICY_BEAN.setPOL_CONT_AD_ACC_NO(PT_IL_POLICY_BEAN.getUI_M_POL_CONT_AD_ACC_NO().toString());
			/* End */
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "UI_M_POL_CONT_AD_ACC_NO",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CQS_PERC(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_CQS_PERC((Double) value);
			helper.POL_CQS_PERC_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CQS_PERC", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateListChangedPOL_CQS_YN(ActionEvent actionEvent) throws ValidatorException {
		CommonUtils.clearMaps(this);
		UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
		Object value = uiInput.getSubmittedValue();
		try {
			helper.POL_CQS_YN_WHEN_LIST_CHANGED(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_CQS_YN((String) value);
			// COMP_POL_CQS_YN.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CQS_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CQS_YN(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_CQS_YN((String) value);
			helper.POL_CQS_YN_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			COMP_POL_CQS_PERC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CQS_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_RI_POOL_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_RI_POOL_CODE((String) value);
			helper.POL_RI_POOL_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			COMP_UI_M_POL_RI_POOL_CODE_DESC.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	public void validatePOL_FAC_BASIS(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_FAC_BASIS((String) value);
			helper.POL_FAC_BASIS_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			COMP_POL_RI_POOL_CODE.resetValue();
			// COMP_POL_FAC_BASIS.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FAC_BASIS", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateListChangedPOL_FAC_YN(ActionEvent actionEvent) throws ValidatorException {
		CommonUtils.clearMaps(this);
		UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
		Object value = uiInput.getSubmittedValue();
		try {
			helper.POL_FAC_YN_WHEN_LIST_CHANGED(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_FAC_YN((String) value);
			// COMP_POL_FAC_YN.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FAC_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FAC_YN(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_FAC_YN((String) value);
			helper.POL_FAC_YN_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			COMP_POL_FAC_BASIS.resetValue();
			COMP_POL_RI_POOL_CODE.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FAC_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_STAFF_CCLASS_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_STAFF_CCLASS_CODE((String) value);
			helper.POL_STAFF_CCLASS_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			COMP_UI_M_CCLAS_CLASS_DESC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_STAFF_CCLASS_CODE",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateListChangedPOL_STAFF_YN(ActionEvent actionEvent) throws ValidatorException {
		CommonUtils.clearMaps(this);
		UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
		Object value = uiInput.getSubmittedValue();
		try {
			helper.POL_STAFF_YN_WHEN_LIST_CHANGED(compositeAction, (String) value);
			// COMP_POL_STAFF_YN.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_STAFF_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_STAFF_YN(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_STAFF_YN((String) value);
			helper.POL_STAFF_YN_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			COMP_POL_STAFF_CCLASS_CODE.resetValue();
			COMP_POL_FC_DISC_AMT.resetValue();
			// COMP_POL_STAFF_YN.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_STAFF_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * public void validatePOL_BANK_REF_NO(FacesContext facesContext,
	 * UIComponent component, Object value) throws ValidatorException {
	 * 
	 * try { helper.POL_BANK_REF_NO_WHEN_VALIDATE_ITEM(compositeAction, value);
	 * COMP_POL_BANK_REF_NO.resetValue(); } catch (Exception exception) {
	 * exception.printStackTrace(); throw new ValidatorException(new
	 * FacesMessage(exception .getMessage())); } finally { try {
	 * ErrorHelpUtil.getWarningForProcedure(CommonUtils .getConnection(),
	 * "POL_BANK_REF_NO", getWarningMap()); } catch (Exception e) {
	 * e.printStackTrace(); } } }
	 */

	public void validatePOL_INTRODUCER_REF_ID1(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_INTRODUCER_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_INTRODUCER_REF_ID1((String) value);
			COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_INTRODUCER_REF_ID1",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_BANK_BRANCH_NAME(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_BANK_BRANCH_NAME_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_BANK_BRANCH_NAME((String) value);
			COMP_UI_M_BANK_CODE_DESC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_BANK_BRANCH_NAME",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateListChangedPOL_GRANTEE_TYPE(ActionEvent actionEvent) throws ValidatorException {
		CommonUtils.clearMaps(this);
		UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
		Object value = uiInput.getSubmittedValue();
		try {
			helper.POL_GRANTEE_TYPE_WHEN_LIST_CHANGED(compositeAction, (String) value);
			COMP_POL_BANK_BRANCH_NAME.resetValue();
			// COMP_POL_GRANTEE_TYPE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_GRANTEE_TYPE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_GRANTEE_TYPE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_GRANTEE_TYPE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_GRANTEE_TYPE((String) value);
			COMP_POL_GRANTEE_NAME.resetValue();
			COMP_POL_BANK_BRANCH_NAME.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_GRANTEE_TYPE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateListChangedPOL_INCORPORATED_YN(ActionEvent actionEvent) throws ValidatorException {
		CommonUtils.clearMaps(this);
		UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
		Object value = uiInput.getSubmittedValue();
		try {
			helper.POL_INCORPORATED_YN_WHEN_LIST_CHANGED(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_INCORPORATED_YN((String) value);
			// COMP_POL_INCORPORATED_YN.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_INCORPORATED_YN",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_INCORPORATED_YN(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_INCORPORATED_YN((String) value);
			helper.POL_INCORPORATED_YN_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			COMP_POL_FC_BANK_ALLOC_AMT.resetValue();
			COMP_POL_LC_BANK_ALLOC_AMT.resetValue();
			COMP_POL_FC_CLIENT_ALLOC_AMT.resetValue();
			COMP_POL_LC_CLIENT_ALLOC_AMT.resetValue();
			COMP_POL_FC_TOT_SA.resetValue();
			COMP_POL_FC_TOT_SA.resetValue();
			// COMP_POL_INCORPORATED_YN.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_INCORPORATED_YN",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_DEFER_PRD(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_DEFER_PRD_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_DEFER_PRD((Double) value);
			// COMP_POL_DEFER_PRD.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_DEFER_PRD", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_EMPLOYER_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_EMPLOYER_CODE_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN, (String) value);
			PT_IL_POLICY_BEAN.setPOL_EMPLOYER_CODE((String) value);
			// COMP_POL_EMPLOYER_CODE.resetValue();
			COMP_UI_M_CONT_NAME.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_EMPLOYER_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_PAYOR_SDCODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_PAYOR_SDCODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_PAYOR_SDCODE((String) value);
			// COMP_POL_PAYOR_SDCODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PAYOR_SDCODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateListChangedPOL_PYMT_TYPE(ActionEvent actionEvent) throws ValidatorException {
		CommonUtils.clearMaps(this);
		UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
		Object value = uiInput.getSubmittedValue();
		try {
			helper.POL_PYMT_TYPE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			// COMP_POL_PYMT_TYPE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PYMT_TYPE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_PYMT_TYPE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_PYMT_TYPE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_PYMT_TYPE((String) value);
			System.out.println("Method of collection " + PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE());
			// COMP_POL_MICR_CODE.resetValue();
			// COMP_POL_CUST_BANK_CODE.resetValue();
			// COMP_POL_PYMT_TYPE.resetValue();
			COMP_POL_DEBIT_DAY.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PYMT_TYPE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FC_MON_ANNU_AMT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_FC_MON_ANNU_AMT_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_FC_MON_ANNU_AMT((Double) value);
			// COMP_POL_FC_MON_ANNU_AMT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_MON_ANNU_AMT",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LAST_INST_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		// Date curDate = (Date) value;
		try {
			// added by gopi for toi on 20/06/18
			Date policy_start_date = (Date) value;
			DateFormat dateformate = new SimpleDateFormat("dd/MM/yyyy");
			String poldate = dateformate.format(policy_start_date);
			Date POL_LAST_INST_DT = dateformate.parse(poldate);

			PT_IL_POLICY_BEAN.setPOL_LAST_INST_DT(POL_LAST_INST_DT);
			helper.POL_LAST_INST_DT_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN.getPOL_FIRST_INST_DT(), POL_LAST_INST_DT);
			/*
			 * PT_IL_POLICY_BEAN.setPOL_LAST_INST_DT(curDate);
			 * helper.POL_LAST_INST_DT_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN
			 * .getPOL_FIRST_INST_DT(), curDate);
			 */
			/* end */
			// COMP_POL_LAST_INST_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LAST_INST_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FIRST_INST_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		try {
			// added by gopi for toi on 20/06/18
			Date policy_start_date = (Date) value;
			DateFormat dateformate = new SimpleDateFormat("dd/MM/yyyy");
			String poldate = dateformate.format(policy_start_date);
			Date POL_FIRST_INST_DT = dateformate.parse(poldate);

			/*
			 * helper.POL_FIRST_INST_DT_WHEN_VALIDATE_ITEM(compositeAction,
			 * curDate); PT_IL_POLICY_BEAN.setPOL_FIRST_INST_DT(curDate);
			 */

			helper.POL_FIRST_INST_DT_WHEN_VALIDATE_ITEM(compositeAction, POL_FIRST_INST_DT);
			PT_IL_POLICY_BEAN.setPOL_FIRST_INST_DT(POL_FIRST_INST_DT);

			COMP_POL_LAST_INST_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FIRST_INST_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LC_DEPOSIT_AMOUNT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Double currDouble = (Double) value;
		try {
			helper.POL_LC_DEPOSIT_AMOUNT_WHEN_VALIDATE_ITEM(compositeAction, currDouble);
			PT_IL_POLICY_BEAN.setPOL_LC_DEPOSIT_AMOUNT(currDouble);
			// COMP_POL_LC_DEPOSIT_AMOUNT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LC_DEPOSIT_AMOUNT",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FC_DEPOSIT_AMOUNT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Double currDouble = (Double) value;
		try {
			currDouble = helper.POL_FC_DEPOSIT_AMOUNT_WHEN_VALIDATE_ITEM(compositeAction, currDouble);
			PT_IL_POLICY_BEAN.setPOL_FC_DEPOSIT_AMOUNT(currDouble);
			COMP_POL_LC_DEPOSIT_AMOUNT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_DEPOSIT_AMOUNT",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_LC_SUM_ASSURED(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_LC_SUM_ASSURED_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED((Double) value);
			// COMP_POL_LC_SUM_ASSURED.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LC_SUM_ASSURED",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateClearBlockPOL_FC_SUM_ASSURED(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_FC_SUM_ASSURED_WHEN_CLEAR_BLOCK(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED((Double) value);
			// COMP_POL_FC_SUM_ASSURED.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_SUM_ASSURED",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateNewItemInstancePOL_FC_SUM_ASSURED(FacesContext facesContext, UIComponent component,
			Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_FC_SUM_ASSURED_WHEN_NEW_ITEM_INSTANCE(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED((Double) value);
			// COMP_POL_FC_SUM_ASSURED.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_SUM_ASSURED",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FC_SUM_ASSURED(FacesContext facesContext, UIComponent component, Object value)
			throws Exception {
		CommonUtils.clearMaps(this);
		try {
			// helper.thresholdLimitAdding(PT_IL_POLICY_BEAN, compositeAction,
			// (Double) value);
			System.out.println("VALUE :" + (Double) value);
			/*
			 * Added by Ameen for KIC Endorsement pol_frz_flag issue as per Ajay
			 * sugg. on 05-07-2018
			 */
			double currVal = (Double) value;
			if (PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() != null && PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() > 0
					&& PT_IL_POLICY_BEAN.getPOL_END_TYPE() != null
					&& !"001".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
				if (currVal != PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED()) {
					PT_IL_POLICY_BEAN.setPOL_FLEX_20("N");
					CommonUtils.setGlobalVariable("GLOBAL.FRZ_FLAG", null);
				}
			}
			/* End */
			helper.POL_FC_SUM_ASSURED_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);

			PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED((Double) value);
			System.out.println("Sum Assured*************" + PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED());
			// PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED((Double) value);
			// Commented By Haneef:- to fix DEC SA, the below method is not
			// allowing to give negative SA values.
			/*
			 * helper.F_validate_term(PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
			 * PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_AGE(),
			 * PT_IL_POLICY_BEAN.getPOL_PERIOD(), PT_IL_POLICY_BEAN
			 * .getPOL_FC_SUM_ASSURED());
			 */

			// COMP_POL_FC_SUM_ASSURED.resetValue();
			COMP_POL_LC_SUM_ASSURED.resetValue();

			// added by Ameen for PREM_PAY_YRS changing the default value
			/*
			 * PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(PT_IL_POLICY_BEAN.
			 * getPOL_PREM_PAY_YRS()); System.out.
			 * println("PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS() =======>>>>>>"
			 * +PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS());
			 * COMP_POL_PREM_PAY_YRS.resetValue();
			 */

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} /*
			 * finally { try { ErrorHelpUtil
			 * .getWarningForProcedure(CommonUtils.getConnection(),
			 * "POL_FC_SUM_ASSURED", getWarningMap()); } catch (Exception e) {
			 * e.printStackTrace(); } }
			 */
	}

	public void validatePOL_MODE_OF_PYMT_RATE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_MODE_OF_PYMT_RATE_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			PT_IL_POLICY_BEAN.setPOL_MODE_OF_PYMT_RATE((Double) value);
			// COMP_POL_MODE_OF_PYMT_RATE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_MODE_OF_PYMT_RATE",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_NO_OF_INST(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_NO_OF_INST_WHEN_VALIDATE_ITEM(compositeAction, (Integer) value);
			PT_IL_POLICY_BEAN.setPOL_NO_OF_INST((Integer) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_NO_OF_INST", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * public void validateListChangedPOL_MODE_OF_PYMT(ActionEvent actionEvent)
	 * throws ValidatorException { CommonUtils.clearMaps(this); UIInput uiInput
	 * = (UIInput) actionEvent.getComponent().getParent(); Object value =
	 * uiInput.getSubmittedValue(); try {
	 * helper.POL_MODE_OF_PYMT_WHEN_LIST_CHANGED(compositeAction,(String)
	 * value); // COMP_POL_MODE_OF_PYMT.resetValue(); } catch (Exception
	 * exception) { exception.printStackTrace(); throw new
	 * ValidatorException(new FacesMessage(exception .getMessage())); } finally
	 * { try { ErrorHelpUtil.getWarningForProcedure(CommonUtils
	 * .getConnection(), "POL_MODE_OF_PYMT", getWarningMap()); } catch
	 * (Exception e) { e.printStackTrace(); } } }
	 * 
	 */public void validatePOL_MODE_OF_PYMT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			System.out.println("facesContext = " + facesContext + "component =" + component);
			/*
			 * Added by Ameen for KIC Endorsement pol_frz_flag issue as per Ajay
			 * sugg. on 05-07-2018
			 */
			String currVal = (String) value;
			if (PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() != null && PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() > 0
					&& PT_IL_POLICY_BEAN.getPOL_END_TYPE() != null
					&& !"001".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
				if (!currVal.equals(PT_IL_POLICY_BEAN.getPOL_MODE_OF_PYMT())) {
					PT_IL_POLICY_BEAN.setPOL_FLEX_20("N");
					CommonUtils.setGlobalVariable("GLOBAL.FRZ_FLAG", null);
				}
			}
			/* End */
			PT_IL_POLICY_BEAN.setPOL_MODE_OF_PYMT((String) value);
			System.out.println("POL_MODE_OF_PYMT   ::" + PT_IL_POLICY_BEAN.getPOL_MODE_OF_PYMT());
			helper.POL_MODE_OF_PYMT_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			fetchMethodOfCollection(PT_IL_POLICY_BEAN.getPOL_MODE_OF_PYMT());
			COMP_POL_MODE_OF_PYMT_RATE.resetValue();
			COMP_POL_NO_OF_INST.resetValue();
			// COMP_POL_EXPIRY_DT.resetValue();
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
			COMP_POL_PREM_PAY_YRS.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
		}
	}

	public void validatePOL_LC_MODAL_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Double currDouble = (Double) value;

		try {
			currDouble = helper.POL_LC_MODAL_PREM_WHEN_VALIDATE_ITEM(compositeAction, currDouble);
			PT_IL_POLICY_BEAN.setPOL_LC_MODAL_PREM(currDouble);

			// COMP_POL_LC_MODAL_PREM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_LC_MODAL_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_NO_OF_UNIT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			helper.POL_NO_OF_UNIT_WHEN_VALIDATE_ITEM(compositeAction, (Double) value);
			// PT_IL_POLICY_BEAN.setPOL_NO_OF_UNIT((Double) value);
			COMP_POL_FC_SUM_ASSURED.resetValue();
			COMP_POL_LC_SUM_ASSURED.resetValue();
			// COMP_POL_NO_OF_UNIT.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_NO_OF_UNIT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_FC_MODAL_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		/*
		 * Commeneted by Saranya on 07/04/2017
		 * 
		 * CommonUtils.clearMaps(this);
		 * 
		 * End
		 */

		System.out.println("enters into validatePOL_FC_MODAL_PREM");
		Double currValue = (Double) value;
		try {
			currValue = helper.POL_FC_MODAL_PREM_WHEN_VALIDATE_ITEM(compositeAction, currValue);
			PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(currValue);
			/* Added By Ameen on 30-06-2017 for ZBILQC-1726916 */
			System.out.println("Model FC Premium PLAN_TYPE ::" + PLAN_TYPE);
			if ("U".equalsIgnoreCase(PLAN_TYPE)) {
				if (PT_IL_POLICY_BEAN.getPOL_FC_MODAL_PREM() < 1) {
					throw new Exception("Should be greater than 0");
				}
			}
			/* End */
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
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FC_MODAL_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CUST_CURR_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_CUST_CURR_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_CUST_CURR_CODE((String) value);
			COMP_POL_CUST_EXCH_RATE.resetValue();
			COMP_UI_M_POL_CUST_CURR_DESC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CUST_CURR_CODE",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_SA_EXCH_RATE(FacesContext facesContext, UIComponent component, Object value) {
		CommonUtils.clearMaps(this);
		Double currvalue = (Double) value;
		try {
			PT_IL_POLICY_BEAN.setPOL_SA_EXCH_RATE(currvalue);
			currvalue = helper.POL_SA_EXCH_RATE_WHEN_VALIDATE_ITEM(compositeAction, currvalue);
			// COMP_POL_SA_EXCH_RATE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_SA_EXCH_RATE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_SA_CURR_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_SA_CURR_CODE((String) value);
			helper.POL_SA_CURR_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			COMP_POL_SA_EXCH_RATE.resetValue();
			COMP_UI_M_POL_SA_CURR_DESC.resetValue();

			/* Newly Added By Dhinesh on 11-01-2018 for KIC Changes */
			if ("KIC/".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE"))) {
				helper.POL_CUST_CURR_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
				PT_IL_POLICY_BEAN.setPOL_CUST_CURR_CODE((String) value);
				COMP_POL_CUST_EXCH_RATE.resetValue();
				COMP_UI_M_POL_CUST_CURR_DESC.resetValue();
			}
			/* End */

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_SA_CURR_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_EXPIRY_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date currValue = (Date) value;
		try {
			// modifeid
			if ("O".equalsIgnoreCase(P_PROD_POL_APPROVAL_YN)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(currValue);
				cal.set(Calendar.HOUR_OF_DAY, 23);
				cal.set(Calendar.MINUTE, 59);
				helper.POL_EXPIRY_DT_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN, cal.getTime());
				PT_IL_POLICY_BEAN.setPOL_EXPIRY_DT(cal.getTime());
			} else if ("B".equalsIgnoreCase(P_PROD_POL_APPROVAL_YN)) {
				helper.POL_EXPIRY_DT_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN, currValue);
				PT_IL_POLICY_BEAN.setPOL_EXPIRY_DT(currValue);
			}
			// COMP_POL_EXPIRY_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_EXPIRY_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	Boolean chkFlag = true;

	public void validatePOL_START_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date currValue = (Date) value;
		try {
			/*
			 * if (String.valueOf(currValue).isEmpty()) {
			 * PT_IL_POLICY_BEAN.setPOL_START_DT(currValue); }
			 */
			/*
			 * Commented and added by saranya for ssp call ZBILQC-1718566 on
			 * 20-01-2016
			 */
			PT_IL_POLICY_BEAN.setPOL_START_DT(currValue);
			String Value = helper.start_dt_sys_pram(compositeAction);
			Trunc_st_dd_dt();
			if ("1".equalsIgnoreCase(Value)) {
				if (!("01".equals(M_POL_ST_DT))) {
					throw new Exception("Start Date Should be 1st of the month");
					// compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put("current",
					// "Start Date Should be Month Start Date");
				}
			}
			/* End */
			if (!PT_IL_POLICY_BEAN.getPOL_START_DT().equals(PT_IL_POLICY_BEAN.getPOL_ISSUE_DT())) {
				chkFlag = false;
			}
			helper.POL_START_DT_WHEN_VALIDATE_ITEM(compositeAction, currValue);
			COMP_POL_EXPIRY_DT.resetValue();
			COMP_POL_FIRST_INST_DT.resetValue();
			COMP_POL_UW_YEAR.resetValue();
			COMP_POL_START_DT.resetValue();
			/*
			 * Newly added by pidugu raj for pol period update if start date
			 * changes as suggested by sivaraman dt: 29-11-2018
			 */
			COMP_POL_PERIOD.resetValue();
			COMP_POL_PREM_PAY_YRS.resetValue();
			/*
			 * Newly added by pidugu raj for pol period update if start date
			 * changes as suggested by sivaraman dt: 29-11-2018
			 */
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_START_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_PREM_PAY_YRS(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Integer values = (Integer) value;
		Integer currValues = (Integer) value;
		System.out.println("old values" + values);
		System.out.println("currValues" + currValues);
		try {

			Integer beanValue = CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS(), 0);

			if (String.valueOf(values).isEmpty()) {
				PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(values);
			}
			if (!(values.equals(beanValue))) {

				values = helper.POL_PREM_PAY_YRS_WHEN_VALIDATE_ITEM(compositeAction, values);
				System.out.println("new val" + values);
				PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(values);
				COMP_POL_FIRST_INST_DT.resetValue();
				COMP_POL_LAST_INST_DT.resetValue();
				COMP_POL_PREM_PAY_YRS.resetValue();
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PREM_PAY_YRS", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_PERIOD(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			/*
			 * Newly added by pidugu raj dt: 15-09-2020 as suggested by
			 * kuzhandaivel for Alliance IL
			 */
			/*
			 * if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
			 * getPT_IL_POLICY_BEAN().getPOL_PROD_CODE().equalsIgnoreCase(
			 * "EDU00001")){ String term =String.valueOf(value);
			 * if(!((term).equals("10") || (term).equals("12") ||
			 * (term).equals("15"))){ throw new
			 * Exception("Please choose term value as either 10 or 12 or 15"); }
			 * }
			 */
			/*
			 * End newly added by pidugu raj dt: 15-09-2020 as suggested by
			 * kuzhandaivel for Alliance IL
			 */
			// PT_IL_POLICY_BEAN.setPOL_PERIOD((Integer) value);
			int prev = CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0);
			System.out.println("PT_IL_POLICY_BEAN.getPOL_PERIOD()  :" + prev);
			/*
			 * Added by Ameen on 27-07-2018 for KIC To change pol_period
			 * KICLIFEQC-1759635 - 2,6
			 */
			if ((Integer) value != PT_IL_POLICY_BEAN.getPOL_PERIOD()) {
				POL_PERIOD_CHNG = true;
			}
			/* End */

			helper.POL_PERIOD_WHEN_VALIDATE_ITEM(compositeAction, (Integer) value);
			// helper.checkMaxAgeOnMaturity(PT_IL_POLICY_BEAN, (Integer) value);
			// helper.chkMaturityAge(PT_IL_POLICY_BEAN,compositeAction);

			// COMP_POL_PERIOD.resetValue();

			/*
			 * PT_IL_POLICY_BEAN.setPOL_PERIOD((Integer)value);
			 * helper.POL_PERIOD_WHEN_VALIDATE_ITEM(compositeAction,
			 * (Integer)value);
			 */

			/*
			 * Added by Ameen for KIC Endorsement pol_frz_flag issue as per Ajay
			 * sugg. on 05-07-2018
			 */
			int currVal = (Integer) value;
			if (PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() != null && PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() > 0
					&& PT_IL_POLICY_BEAN.getPOL_END_TYPE() != null
					&& !"001".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
				if (currVal != PT_IL_POLICY_BEAN.getPOL_PERIOD()) {
					PT_IL_POLICY_BEAN.setPOL_FLEX_20("N");
					CommonUtils.setGlobalVariable("GLOBAL.FRZ_FLAG", null);
				}
			}
			/* End */
			PT_IL_POLICY_BEAN.setPOL_PERIOD((Integer) value);
			/*
			 * Added by Ram on 29/11/2016 for Defaulting Premium Paying years
			 * value while tabbing out from Period in Years field
			 */

			/*
			 * Commentted &Modified by saritha on 07-09-2017 for ssp call id
			 * ZBILQC-1736358 as suggestted by siva sir
			 */
			/*
			 * if(!"S".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_MODE_OF_PYMT())
			 * ) { PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS((Integer) value); }
			 */

			/*
			 * if(PT_IL_POLICY_BEAN.getPOL_PERIOD()!=value){
			 * PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS((Integer) value); }
			 */
			/* End */

			System.out.println(
					"111 PT_IL_POLICY_BEAN.getPOL_MODE_OF_PYMT()  : " + PT_IL_POLICY_BEAN.getPOL_MODE_OF_PYMT());

			helper.ChkPrdAgeSetup(PT_IL_POLICY_BEAN);
			int curr = PT_IL_POLICY_BEAN.getPOL_PERIOD();

			if ("012".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
				helper.chkPolPeriodAftrEndo(PT_IL_POLICY_BEAN);
				helper.checkMaxAgeOnMaturity(PT_IL_POLICY_BEAN, PT_IL_POLICY_BEAN.getPOL_PERIOD());
				// helper.chkMaturityAge(PT_IL_POLICY_BEAN,compositeAction);
				// PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS((Integer) value);
			}
			if (prev != (Integer) value) {

				if ("000".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000"))) {
					helper.chkNo_of_units(PT_IL_POLICY_BEAN);

				}
				/*
				 * Added by saranya on 13/02/2017 for Unit Link Product as per
				 * the Girish Suggessted
				 */
				COMP_POL_PERIOD.resetValue();
				/* End */
				COMP_POL_START_DT.resetValue();
				COMP_POL_EXPIRY_DT.resetValue();
				COMP_POL_NO_OF_UNIT.resetValue();
				/*
				 * Added by saranya on 13/02/2017 for Unit Link Product as per
				 * the Girish Suggessted
				 */
				COMP_POL_PERIOD.resetValue();
				/* End */

			}

			if (!"S".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_MODE_OF_PYMT())) {
				System.out
						.println("Enter the Mode of payment if block **** " + PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS());

				/* Changed by Ram on 26/11/2016 for validation */
				if (PT_IL_POLICY_BEAN.getPOL_PERIOD() < PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS()) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014", new Object[] {
							"Premium Paying Years",
							"less than or equal to Policy Period  " + getPT_IL_POLICY_BEAN().getPOL_PERIOD() }));
				}

				/*
				 * Commentted by saritha on 07-09-2017 for ssp call id
				 * ZBILQC-1736358 as suggestted by siva sir
				 */
				/*
				 * else {
				 * PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(PT_IL_POLICY_BEAN.
				 * getPOL_PERIOD()); }
				 */
				/* End */

				System.out.println(
						" PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS    " + PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS());
				COMP_POL_PREM_PAY_YRS.resetValue();

			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} /*
			 * finally { try { ErrorHelpUtil.getWarningForProcedure(CommonUtils
			 * .getConnection(),"POL_PERIOD",getWarningMap()); } catch
			 * (Exception e) {
			 * 
			 * e.printStackTrace(); } }
			 */
	}

	/*
	 * 
	 * commented By Dhinesh on 31-05-2018
	 * 
	 * public void validatePOL_SUB_PLAN_CODE(FacesContext facesContext,
	 * UIComponent component, Object value) throws ValidatorException {
	 * CommonUtils.clearMaps(this); try {
	 * helper.POL_SUB_PLAN_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String)
	 * value); PT_IL_POLICY_BEAN.setPOL_SUB_PLAN_CODE((String) value); //
	 * COMP_POL_SUB_PLAN_CODE.resetValue();
	 * COMP_UI_M_POL_SUB_PLAN_CODE_DESC.resetValue();
	 * COMP_POL_FC_SUM_ASSURED.resetValue();
	 * COMP_POL_LC_SUM_ASSURED.resetValue();
	 * 
	 * } catch (Exception exception) { exception.printStackTrace(); throw new
	 * ValidatorException(new FacesMessage(exception .getMessage())); } finally
	 * { try { ErrorHelpUtil.getWarningForProcedure(CommonUtils
	 * .getConnection(), "POL_SUB_PLAN_CODE", getWarningMap()); } catch
	 * (Exception e) { e.printStackTrace(); } } }
	 */

	public void validatePOL_SUB_PLAN_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_SUB_PLAN_CODE((String) value);

			helper.POL_SUB_PLAN_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);

			double SUB_PLAN_SA_Min = 0.0;
			double SUB_PLAN_SA_MAX = 0.0;

			List<OracleParameter> subPlanSARangeList = helper.callP_FUNERAL_SUB_PLAN_DFLT_SA(
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SUB_PLAN_CODE());

			if (subPlanSARangeList != null) {

				if (subPlanSARangeList.get(0).getValueObject() != null
						&& subPlanSARangeList.get(1).getValueObject() != null) {
					SUB_PLAN_SA_Min = (Double) subPlanSARangeList.get(0).getValueObject();
					SUB_PLAN_SA_MAX = (Double) subPlanSARangeList.get(1).getValueObject();

					CommonUtils.setGlobalVariable("GLOBAL.SUB_PLAN_SA_Min",
							subPlanSARangeList.get(0).getValueObject().toString());
					CommonUtils.setGlobalVariable("GLOBAL.SUB_PLAN_SA_MAX",
							subPlanSARangeList.get(1).getValueObject().toString());

				}
			}
			// if(PT_IL_POLICY_BEAN.getROWID()==null){
			PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(SUB_PLAN_SA_MAX);
			// }
			COMP_POL_FC_SUM_ASSURED.setDisabled(true);

			PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED(PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED()
					* CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_SA_EXCH_RATE(), 0.0));

			COMP_POL_SUB_PLAN_CODE.resetValue();
			COMP_UI_M_POL_SUB_PLAN_CODE_DESC.resetValue();
			COMP_POL_FC_SUM_ASSURED.resetValue();
			COMP_POL_LC_SUM_ASSURED.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_SUB_PLAN_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CONT_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Connection connection = null;
		try {
			String prev = CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_CONT_CODE(), "n");

			String query = "select CONT_REF_ID1 from PM_IL_CONTRACTOR where cont_code=?";
			String REF1 = null;
			connection = CommonUtils.getConnection();
			ResultSet resultSet1 = null;
			/*
			 * resultSet1=new CRUDHandler().executeSelectStatement(query,
			 * connection, new Object[]{value}); while(resultSet1.next()) {
			 * REF1=resultSet1.getString("CONT_REF_ID1"); }
			 * 
			 * if(REF1!=null &&
			 * !REF1.equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1()))
			 * { throw new Exception(""); }
			 */

			PT_IL_POLICY_BEAN.setPOL_CONT_CODE((String) value);

			/* added by raja on 10-07-2017 for ZBILQC-1731018 */

			LIFELIB lifelib = new LIFELIB();
			lifelib.P_VAL_CUST(PT_IL_POLICY_BEAN.getPOL_CONT_CODE(), PT_IL_POLICY_BEAN.getPOL_ASSURED_NAME(), "N", "N",
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE());

			/* end */

			/* Added By Raja 29.6.2016 */

			if (!(PT_IL_POLICY_BEAN.getPOL_CONT_CODE().equals(null))) {

				if (compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.isASSURED_FLAG()) {
					compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
							.setASSURED_FLAG(false);
				}
			}

			/* End */
			helper.POL_CONT_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			if (prev != (String) value) {

				if ("000".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000"))) {
					helper.chkNo_of_units(PT_IL_POLICY_BEAN);
				}
			}
			COMP_POL_NO_OF_UNIT.resetValue();
			COMP_POL_ASSURED_NAME.resetValue();
			COMP_POL_PREM_PAY_YRS.resetValue();
			COMP_POL_PERIOD.resetValue();
			COMP_POL_RES_ADDRESS_1.resetValue();
			COMP_POL_JOINT_LIFE_AGE.resetValue();
			// COMP_POL_CONT_CODE.resetValue();

			// helper.assuredAgeCheck(compositeAction);
			/* Added by Ameen on 24-01-2018 for KIC */
			getAssuredDltPanel();
			/* END */

		} catch (Exception exception) {
			exception.printStackTrace();
			getErrorMap().put("current", exception.getMessage());
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} /*
			 * finally { try { ErrorHelpUtil.getWarningForProcedure(CommonUtils
			 * .getConnection(), "POL_CONT_CODE", getWarningMap()); } catch
			 * (Exception e) { e.printStackTrace(); } }
			 */
	}

	public void validatePOL_SRC_OF_BUS(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			helper.POL_SRC_OF_BUS_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			PT_IL_POLICY_BEAN.setPOL_SRC_OF_BUS((String) value);
			/* KIC condition added by Ameen on 19-01-2018 */
			/*
			 * if(!"KIC/".equalsIgnoreCase(CommonUtils.getGlobalVariable(
			 * "GLOBAL.SITE_CODE"))) {
			 */
			/*
			 * Added by saranya on 07-12-2016 for RM018T - FSD_IL_ZB
			 * Life_013_Underwriting changes
			 */
			/*
			 * if("075".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_SRC_OF_BUS())
			 * && (!"KIC/".equalsIgnoreCase(CommonUtils.getGlobalVariable(
			 * "GLOBAL.SITE_CODE")) ||
			 * !"TOI/".equalsIgnoreCase(CommonUtils.getGlobalVariable(
			 * "GLOBAL.SITE_CODE"))))KIC condition handled by Ameen on
			 * 26-03-2018 for agent prem. less thencalculated prem. error not to
			 * come in KIC
			 */
			if ("075".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_SRC_OF_BUS())
					&& !CommonUtils.isIN(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE"), "KIC/", "TOI/")) {
				// compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FC_AGENT_PREM().setRequired(true);
				// compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LC_AGENT_PREM().setRequired(true);
				COMP_POL_FC_AGENT_PREM.setRequired(true);
				COMP_POL_LC_AGENT_PREM.setRequired(true);

			} else {
				// compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FC_AGENT_PREM().setRequired(false);
				// compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LC_AGENT_PREM().setRequired(false);
				COMP_POL_FC_AGENT_PREM.setRequired(false);
				COMP_POL_LC_AGENT_PREM.setRequired(false);
			}
			/* End */
			// }
			COMP_POL_SRC_OF_BUS.resetValue();

			/* Added by Ameen on 13-07-2018 for TOI as per Ajay */
			if ("O".equalsIgnoreCase(P_PROD_POL_APPROVAL_YN)) {
				if ("075".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_SRC_OF_BUS())) {
					COMP_UI_M_POBH_BROKER_CODE.setDisabled(false);
					COMP_UI_M_POBH_BROKER_CODE.setRequired(true);
					// ADDED BY GOPI FOR TOI AS PER AJOY AND SIVA SUGGESTION ON
					// 27/07/18
					PT_IL_POLICY_BEAN.setPol_flex_31("Y");

					// END

				} else {
					COMP_UI_M_POBH_BROKER_CODE.setDisabled(true);
					COMP_UI_M_POBH_BROKER_CODE.setRequired(false);
				}
			}
			/* End */
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_SRC_OF_BUS", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CUST_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		/* CommonUtils.clearMaps(this); */
		try {
			String code = (String) value;

			PT_IL_POLICY_BEAN.setPOL_CUST_CODE(code);
			helper.POL_CUST_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			/* Commented by ganesh on 02-11-2017 */
			// defaultBankDetails(code);
			/* end */
			COMP_UI_M_POL_CUST_DESC.resetValue();
			COMP_POL_CUST_BANK_CODE.resetValue();
			COMP_POL_MICR_CODE.resetValue();
			COMP_UI_M_BANK_CODE.resetValue();
			COMP_UI_M_BANK_CODE_DESC_1.resetValue();

			/* added by raja 09-06-2017 for ZBILQC-1724894 */
			/*
			 * LIFELIB lifelib = new LIFELIB();
			 * lifelib.P_VAL_CUST(PT_IL_POLICY_BEAN.getPOL_CUST_CODE(),
			 * PT_IL_POLICY_BEAN.getUI_M_POL_CUST_DESC(), "N", "N",
			 * PT_IL_POLICY_BEAN.getPOL_DIVN_CODE());
			 */
			/* end */

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CUST_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// below code commented by ganesh on 02-11-2017 for bank detail issue
	/*
	 * public void defaultBankDetails(String custCode) {
	 * 
	 * Connection connection = null; ResultSet resultSet = null; //Modified by
	 * ganesh on 23-10-2017 as per suggested by ajoy /*String query =
	 * "SELECT CBAD_ACNT_NO,CBAD_MICR_CODE FROM PM_CUST_BANK_ACNT_DTLS WHERE CBAD_CUST_CODE = ? "
	 * ;
	 */
	/*
	 * String query =
	 * "SELECT CBAD_ACNT_NO,CBAD_MICR_CODE,CBAD_BANK_CODE,CBAD_BANK_NAME FROM PM_CUST_BANK_ACNT_DTLS WHERE CBAD_CUST_CODE = ?"
	 * ;
	 */
	/*
	 * String query =
	 * "SELECT CBAD_ACNT_NO,CBAD_MICR_CODE,CBAD_CUST_BANK_CODE,BANK_NAME FROM PM_CUST_BANK_ACNT_DTLS,FM_BANK WHERE CBAD_CUST_CODE = ? "
	 * + "AND BANK_CODE = CBAD_CUST_BANK_CODE";
	 * 
	 * 
	 * try { connection = CommonUtils.getConnection(); resultSet = new
	 * CRUDHandler().executeSelectStatement(query, connection, new Object[] {
	 * custCode }); if (resultSet.next()) {
	 * 
	 * PT_IL_POLICY_BEAN.setPOL_CUST_BANK_CODE(resultSet.getLong(1) ==
	 * 0?null:resultSet.getLong(1));
	 * 
	 * PT_IL_POLICY_BEAN .setPOL_MICR_CODE(resultSet.getLong(2) == 0 ? null :
	 * resultSet.getLong(2)); //Added by ganesh on 23-10-2017 as per suggested
	 * by ajoy
	 * PT_IL_POLICY_BEAN.setPOL_BANK_CODE(CommonUtils.nvl(resultSet.getString(3)
	 * ,""));
	 * PT_IL_POLICY_BEAN.setUI_POL_BANK_DESC(CommonUtils.nvl(resultSet.getString
	 * (4),""));
	 * 
	 * 
	 * } } catch (DBException e) { e.printStackTrace(); } catch (SQLException e)
	 * { e.printStackTrace(); }
	 * 
	 * }
	 */
	public void validatePOL_PROP_NO(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_PROP_NO((String) value);
			System.out.println("Proposal Number" + PT_IL_POLICY_BEAN.getPOL_PROP_NO());
			helper.POL_PROP_NO_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN.getPOL_DS_TYPE(), (String) value);
			COMP_POL_PROP_NO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PROP_NO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * added by gopi for hands on feed back issue,serial no 18 in ZB on 31/01/17
	 */
	public void validatePOL_QUOT_NO(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setUI_M_POL_QUOT_NO((String) value);
			COMP_POL_QUOT_NO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_QUOT_NO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/* end */
	/* Added by Ameen on 12-07-2018 for TOI as per Ajay sugg. */
	String P_PROD_POL_APPROVAL_YN = null;

	public String getP_PROD_POL_APPROVAL_YN() {
		return P_PROD_POL_APPROVAL_YN;
	}

	public void setP_PROD_POL_APPROVAL_YN(String p_PROD_POL_APPROVAL_YN) {
		P_PROD_POL_APPROVAL_YN = p_PROD_POL_APPROVAL_YN;
	}
	/* end */

	public void validatePOL_ASSRD_REF_ID2(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			String currValue = (String) value;
			PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2((String) value);
			if ("O".equalsIgnoreCase(P_PROD_POL_APPROVAL_YN)) {

				ArrayList<String> pValList = new ArrayList<String>();
				PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
				DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();

				String query1 = " SELECT PROD_CALC_TERM_YN,PROD_PREM_PAYING_YRS FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
				String query2 = "SELECT POL_CONT_CODE FROM PT_IL_POLICY WHERE POL_NO = ? ";
				String PROD_CALC_TERM_YN = null, POL_CONT_CODE = null;
				BigDecimal term_disb_SysParam = null;
				ResultSet rs1, rs2;
				rs1 = new CRUDHandler().executeSelectStatement(query1, CommonUtils.getConnection(),
						new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
				if (rs1.next()) {
					PROD_CALC_TERM_YN = rs1.getString("PROD_CALC_TERM_YN");
				}
				rs2 = new CRUDHandler().executeSelectStatement(query2, CommonUtils.getConnection(),
						new Object[] { PT_IL_POLICY_BEAN.getPOL_NO() });
				if (rs2.next()) {
					POL_CONT_CODE = rs2.getString("POL_CONT_CODE");
				}

				pValList = pkg_pilt002_apac.POL_CONT_CODE_W_V_I(
						CommonUtils.getProcedureValue(dummy_bean.getUI_M_IL_ASSRIND()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_PLAN_CODE()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_CUST_CODE()),
						CommonUtils.getProcedureValue(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_CATG_CODE()),
						CommonUtils.getProcedureValue(compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_CATG_CODE()),
						CommonUtils.getProcedureValue(compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_AGE()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_START_DT()),
						CommonUtils.getProcedureValue(dummy_bean.getUI_M_PROD_AGE_CALC_FLAG()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_ISSUE_DT()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2()),
						CommonUtils.getProcedureValue(dummy_bean.getUI_M_POL_PLAN_TYPE()),
						CommonUtils.getProcedureValue(dummy_bean.getUI_M_PROD_PERIOD_MULTIPLE()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_END_TYPE()),
						PT_IL_POLICY_BEAN.getROWID(), PT_IL_POLICY_BEAN.getPOL_CUST_CODE(),

						CommonUtils.getProcedureValue(dummy_bean.getUI_M_POL_PERIOD()),

						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null,

						CommonUtils.getProcedureValue(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(), 0) != 0
								? PT_IL_POLICY_BEAN.getPOL_PERIOD() : dummy_bean.getUI_M_POL_PERIOD()),

						CommonUtils.getProcedureValue(dummy_bean.getUI_M_CALC_METHOD()));

				if (pValList != null && pValList.size() > 0) {
					if (pValList.get(0) != null) {
						// currValue = pValList.get(0);
						PT_IL_POLICY_BEAN.setPOL_CONT_CODE(pValList.get(0));
					}
					if (pValList.get(1) != null) {

						if (PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS() == null
								|| ((POL_CONT_CODE != null) && !POL_CONT_CODE.equalsIgnoreCase(currValue.trim()))) {
							PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(Integer.parseInt(pValList.get(1)));
						}
					}
					if (pValList.get(2) != null) {

						if (PT_IL_POLICY_BEAN.getPOL_STATUS() != null
								&& !(PT_IL_POLICY_BEAN.getPOL_STATUS().equals("E"))) {
							if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_CODE(), "XXXXX") != null && !(CommonUtils
									.nvl(PT_IL_POLICY_BEAN.getPOL_END_CODE(), "XXXXX").equals("GEN001"))) {
								PT_IL_POLICY_BEAN.setPOL_ASSURED_NAME(pValList.get(2));
							}
						}
					}
					if (pValList.get(3) != null) {

						if (PT_IL_POLICY_BEAN.getPOL_STATUS() != null
								&& !(PT_IL_POLICY_BEAN.getPOL_STATUS().equals("E"))) {
							if (PT_IL_POLICY_BEAN.getPOL_END_CODE() != null
									&& !(PT_IL_POLICY_BEAN.getPOL_END_CODE().equals("GEN005"))) {
								PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_1(pValList.get(3));
							}
						}
					}
					if (pValList.get(4) != null) {

						if (PT_IL_POLICY_BEAN.getPOL_STATUS() != null
								&& !(PT_IL_POLICY_BEAN.getPOL_STATUS().equals("E"))) {
							if (PT_IL_POLICY_BEAN.getPOL_END_CODE() != null
									&& !(PT_IL_POLICY_BEAN.getPOL_END_CODE().equals("GEN005"))) {
								PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_2(pValList.get(4));
							}
						}
					}
					if (pValList.get(5) != null) {

						if (PT_IL_POLICY_BEAN.getPOL_STATUS() != null
								&& !(PT_IL_POLICY_BEAN.getPOL_STATUS().equals("E"))) {
							if (PT_IL_POLICY_BEAN.getPOL_END_CODE() != null
									&& !(PT_IL_POLICY_BEAN.getPOL_END_CODE().equals("GEN005"))) {
								PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_3(pValList.get(5));
							}
						}
					}
					if (pValList.get(6) != null) {

						if (PT_IL_POLICY_BEAN.getPOL_STATUS() != null
								&& !(PT_IL_POLICY_BEAN.getPOL_STATUS().equals("E"))) {
							if (PT_IL_POLICY_BEAN.getPOL_END_CODE() != null
									&& !(PT_IL_POLICY_BEAN.getPOL_END_CODE().equals("GEN005"))) {
								PT_IL_POLICY_BEAN.setPOL_RES_AREA_CODE(pValList.get(6));
							}
						}
					}
					if (pValList.get(7) != null) {
						PT_IL_POLICY_BEAN.setPOL_RES_PHONE_NO(pValList.get(7));
					}
					if (pValList.get(8) != null) {
						PT_IL_POLICY_BEAN.setPOL_FAX_NO(pValList.get(8));
					}
					if (pValList.get(9) != null) {

						if (PT_IL_POLICY_BEAN.getPOL_STATUS() != null
								&& !(PT_IL_POLICY_BEAN.getPOL_STATUS().equals("E"))) {
							if (PT_IL_POLICY_BEAN.getPOL_END_CODE() != null
									&& !(PT_IL_POLICY_BEAN.getPOL_END_CODE().equals("GEN005"))) {
								PT_IL_POLICY_BEAN.setPOL_RES_AREA_CODE(pValList.get(9));
							}
						}
					}
					if (pValList.get(10) != null) {
						PT_IL_POLICY_BEAN.setPOL_FAX_AREA_CODE(pValList.get(10));
					}
					if (pValList.get(11) != null) {

						if (PT_IL_POLICY_BEAN.getPOL_STATUS() != null
								&& !(PT_IL_POLICY_BEAN.getPOL_STATUS().equals("E"))) {
							if (PT_IL_POLICY_BEAN.getPOL_END_CODE() != null
									&& !(PT_IL_POLICY_BEAN.getPOL_END_CODE().equals("GEN005"))) {
								PT_IL_POLICY_BEAN.setPOL_CITY_CODE(pValList.get(11));
							}
						}
					}
					if (pValList.get(12) != null) {

						if (PT_IL_POLICY_BEAN.getPOL_STATUS() != null
								&& !(PT_IL_POLICY_BEAN.getPOL_STATUS().equals("E"))) {
							if (PT_IL_POLICY_BEAN.getPOL_END_CODE() != null
									&& !(PT_IL_POLICY_BEAN.getPOL_END_CODE().equals("GEN005"))) {
								PT_IL_POLICY_BEAN.setPOL_STATE_CODE(pValList.get(12));
							}
						}
					}
					if (pValList.get(13) != null) {

						if (PT_IL_POLICY_BEAN.getPOL_STATUS() != null
								&& !(PT_IL_POLICY_BEAN.getPOL_STATUS().equals("E"))) {
							if (PT_IL_POLICY_BEAN.getPOL_END_CODE() != null
									&& !(PT_IL_POLICY_BEAN.getPOL_END_CODE().equals("GEN005"))) {
								PT_IL_POLICY_BEAN.setPOL_COUNT_CODE(pValList.get(13));
							}
						}
					}
					if (pValList.get(14) != null) {
						PT_IL_POLICY_BEAN.setUI_M_POL_COUNT_NAME(pValList.get(14));
					}
					if (pValList.get(15) != null) {
						PT_IL_POLICY_BEAN.setUI_M_POL_CITY_NAME(pValList.get(15));
					}
					if (pValList.get(16) != null) {
						PT_IL_POLICY_BEAN.setUI_M_POL_STATE_NAME(pValList.get(16));
					}
					if (pValList.get(17) != null) {
						PT_IL_POLICY_BEAN.setPOL_MOBILE_NO(pValList.get(17));
					}
					if (pValList.get(18) != null) {
						dummy_bean.setUI_M_CONT_REF_ID1(pValList.get(18));
					}
					if (pValList.get(19) != null) {
						dummy_bean.setUI_M_CONT_REF_ID2(pValList.get(19));
					}
					if (pValList.get(20) != null) {
						dummy_bean.setUI_M_CUST_AGE(pValList.get(20));
					}
					if (pValList.get(21) != null) {

						term_disb_SysParam = (BigDecimal) CommonUtils.getPPSystemParameterValue("IL_TERM_DFLT");

						if (term_disb_SysParam.intValue() == 1) {

							System.out.println("getPOL_PREM_PAY_YRS          " + PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS()
									+ "getPOL_PERIOD               " + PT_IL_POLICY_BEAN.getPOL_PERIOD());

							if (PROD_CALC_TERM_YN != null && !PROD_CALC_TERM_YN.equalsIgnoreCase("Y")) {

								if (PT_IL_POLICY_BEAN.getPOL_PERIOD() == null || ((POL_CONT_CODE != null)
										&& !POL_CONT_CODE.equalsIgnoreCase(currValue.trim()))) {
									PT_IL_POLICY_BEAN.setPOL_PERIOD(Integer.parseInt(pValList.get(21)));
									// pt_il_policy_bean.setUI_M_POL_PERIOD(Integer.parseInt(pValList.get(21)));
								}

							} else {
								PT_IL_POLICY_BEAN.setPOL_PERIOD(Integer.parseInt(pValList.get(21)));
								if (PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS() > PT_IL_POLICY_BEAN.getPOL_PERIOD()) {
									PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(Integer.parseInt(pValList.get(21)));
								}

							}
							PT_IL_POLICY_BEAN.setUI_M_POL_PERIOD(Integer.parseInt(pValList.get(21)));

						} else if (term_disb_SysParam.intValue() == 2) {
							PT_IL_POLICY_BEAN.setPOL_PERIOD(Integer.parseInt(pValList.get(21)));
							PT_IL_POLICY_BEAN.setUI_M_POL_PERIOD(Integer.parseInt(pValList.get(21)));
						}

					}

					System.out.println("POL_PERIOD       " + PT_IL_POLICY_BEAN.getPOL_PERIOD()
							+ "    getUI_M_POL_PERIOD    " + PT_IL_POLICY_BEAN.getUI_M_POL_PERIOD());

				}

				/*
				 * Added by Ameen on 23-04-2018 for KIC cust and assured same
				 * issue
				 */
				String contCodeQry = "SELECT CUST_CODE FROM PM_CUSTOMER WHERE " + "NVL(CUST_REF_ID1,'X') = NVL(?,'X') ";
				ResultSet contCodeRS = null;

				if (PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1() != null
						&& PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2() != null) {
					if (!PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1()
							.equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2())) {

						contCodeRS = new CRUDHandler().executeSelectStatement(contCodeQry, CommonUtils.getConnection(),
								new Object[] { PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2() });
						if (contCodeRS.next()) {
							PT_IL_POLICY_BEAN.setPOL_CONT_CODE(contCodeRS.getString(1));
						}
					}
				}
				/* End */

				COMP_POL_NO_OF_UNIT.resetValue();
				COMP_POL_ASSURED_NAME.resetValue();
				COMP_POL_PREM_PAY_YRS.resetValue();
				COMP_POL_PERIOD.resetValue();
				COMP_POL_RES_ADDRESS_1.resetValue();
				COMP_POL_JOINT_LIFE_AGE.resetValue();

			} else if ("B".equalsIgnoreCase(P_PROD_POL_APPROVAL_YN)) {
				helper.POL_ASSRD_REF_ID2_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			}
			COMP_POL_CUST_CODE.resetValue();
			COMP_POL_CONT_CODE.resetValue();
			COMP_POL_ASSURED_NAME.resetValue();
			COMP_POL_RES_ADDRESS_1.resetValue();
			COMP_POL_RES_ADDRESS_2.resetValue();
			COMP_POL_RES_ADDRESS_3.resetValue();
			COMP_POL_RES_PHONE_NO.resetValue();
			COMP_POL_FAX_NO.resetValue();
			COMP_POL_RES_AREA_CODE.resetValue();
			COMP_POL_FAX_AREA_CODE.resetValue();
			COMP_POL_STATE_CODE.resetValue();
			COMP_POL_COUNT_CODE.resetValue();
			COMP_POL_MOBILE_NO.resetValue();
			COMP_UI_M_POL_CITY_NAME.resetValue();
			COMP_UI_M_POL_STATE_NAME.resetValue();
			COMP_UI_M_POL_COUNT_NAME.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_ASSRD_REF_ID2", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void fireFieldValidationPOL_ASSRD_REF_ID1(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value == null || "".trim().equals(value)) {
			COMP_POL_ASSRD_REF_ID2.setRequired(true);
			PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1(null);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void fireFieldValidatePOL_MODE_OF_PYMT(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();

		mopCheck = true;

		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void fireFieldValidationPOL_CONT_CODE(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value == null || "".trim().equals(value)) {
			PT_IL_POLICY_BEAN.setPOL_CONT_CODE(null);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validatePOL_ASSRD_REF_ID1(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			System.out.println("******  Enter the validatePOL_ASSRD_REF_ID1 Methods  *******");
			PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1((String) value);
			COMP_UI_M_POL_CUST_DESC.resetValue();
			// COMP_POL_ASSRD_REF_ID1.resetValue();
			COMP_POL_CUST_CODE.resetValue();
			COMP_POL_CONT_CODE.resetValue();
			COMP_POL_ASSURED_NAME.resetValue();
			COMP_POL_RES_ADDRESS_1.resetValue();
			COMP_POL_RES_ADDRESS_2.resetValue();
			COMP_POL_RES_ADDRESS_3.resetValue();
			COMP_POL_RES_PHONE_NO.resetValue();
			COMP_POL_FAX_NO.resetValue();
			COMP_POL_RES_AREA_CODE.resetValue();
			COMP_POL_FAX_AREA_CODE.resetValue();
			COMP_POL_STATE_CODE.resetValue();
			COMP_POL_COUNT_CODE.resetValue();
			COMP_POL_MOBILE_NO.resetValue();
			COMP_UI_M_POL_CITY_NAME.resetValue();
			COMP_UI_M_POL_STATE_NAME.resetValue();
			COMP_UI_M_POL_COUNT_NAME.resetValue();
			COMP_POL_SRC_OF_BUS.resetValue();
			COMP_POL_ASSRD_REF_ID2.resetValue();
			/*
			 * Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB
			 * Life_002-Customer Master Changes COMMENTS
			 */
			COMP_POL_PREM_PAYER_CODE.resetValue();
			COMP_UI_M_POL_PREM_PAYER_CODE_DESC.resetValue();
			/* end */
			System.out.println("*************************** Before ***************************");
			System.out.println("PT_IL_POLICY_BEAN.getPOL_CUST_CODE()" + PT_IL_POLICY_BEAN.getPOL_CUST_CODE());
			helper.POL_ASSRD_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			/*
			 * Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB
			 * Life_002-Customer Master Changes COMMENTS
			 */
			COMP_POL_PREM_PAYER_CODE.resetValue();
			/* end */

			selectquerymail();
			COMP_POL_MOBILE_NO.resetValue();
			COMP_POL_RES_EMAIL_ID.resetValue();
			System.out.println("getListPhoneEmail()      " + getListPhoneEmail());
			/*
			 * System.out.println("email  "+compositeAction.
			 * getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN().
			 * getCUST_EMAIL_ID_PER());
			 * System.out.println("Phone number "+compositeAction.
			 * getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN().
			 * getCUST_MOBILE_NO());
			 */
			if (getListPhoneEmail().size() > 0) {
				String cust_phone = getListPhoneEmail().get(0);
				String cust_mail = getListPhoneEmail().get(1);

				if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_RES_EMAIL_ID(), "T").equals("T")
						&& CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_MOBILE_NO(), "T").equals("T")) {
					setEflag(true);
				} else {
					setEflag(false);
				}
				if (isEflag()) {
					if (!(CommonUtils.nvl(cust_phone, "T").equals("T"))) {
						PT_IL_POLICY_BEAN.setPOL_MOBILE_NO(cust_phone);
					}

					if (!(CommonUtils.nvl(cust_mail, "T").equals("T"))) {
						PT_IL_POLICY_BEAN.setPOL_RES_EMAIL_ID(cust_mail);
					}
				}
				/*
				 * if(!cust_phone.isEmpty()) {
				 * PT_IL_POLICY_BEAN.setPOL_MOBILE_NO(cust_phone);
				 * PT_IL_POLICY_BEAN.setPOL_RES_EMAIL_ID(cust_mail); }
				 */
			}
			/*
			 * else { System.out.println("else");
			 * PT_IL_POLICY_BEAN.setPOL_MOBILE_NO(null);
			 * PT_IL_POLICY_BEAN.setPOL_RES_EMAIL_ID(null); }
			 */

			System.out.println("PT_IL_POLICY_BEAN.getPOL_CUST_CODE()" + PT_IL_POLICY_BEAN.getPOL_CUST_CODE());
			System.out.println("*************************** After ***************************");
			// setDefault_Cust_Flag(true);
			System.out.println("PT_IL_POLICY_BEAN.getROWID()    : " + PT_IL_POLICY_BEAN.getROWID());

			/*
			 * Modified by saritha on 02-Feb-2018 Feneral Plan(207) Dependant
			 * save Record inserted &updated null error as per siva sir sugg.
			 */
			/*
			 * COMMENTED BY DHINESH ON 04-05-2018
			 * 
			 * if(PT_IL_POLICY_BEAN.getROWID()!=null)
			 */

			/* Modified by Janani for end null issue on 07.05.2018 */
			/*
			 * if(PT_IL_POLICY_BEAN.getROWID()!=null &&
			 * !CommonUtils.isIN(PT_IL_POLICY_BEAN.getPOL_END_CODE(),
			 * "GEN012","GEN016"))
			 */

			/*
			 * modified by Ameen on 08-05-2018 as per Ajoy sugg.
			 * if(PT_IL_POLICY_BEAN.getROWID()!=null &&
			 * (PT_IL_POLICY_BEAN.getPOL_END_CODE() != null &&
			 * !CommonUtils.isIN(PT_IL_POLICY_BEAN.getPOL_END_CODE(),
			 * "GEN012","GEN016")))
			 */
			if (PT_IL_POLICY_BEAN.getROWID() != null && (PT_IL_POLICY_BEAN.getPOL_END_CODE() != null
					&& !CommonUtils.isIN(PT_IL_POLICY_BEAN.getPOL_END_CODE(), "GEN012", "CDOB")))
			/* End */
			{
				String Pol_Sys_ID = PT_IL_POLICY_BEAN.getPOL_SYS_ID().toString();
				String Pol_Old_AssuredRefId = "";
				String POL_OLD_ASSRD_REF_ID = "";
				ArrayList<OracleParameter> proclist = null;
				proclist = helper.P_POL_ASSR_DELT(Pol_Sys_ID, PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1(),
						Pol_Old_AssuredRefId);

				if (proclist != null && !proclist.isEmpty()) {
					if (proclist.get(0).getValueObject() != null) {
						POL_OLD_ASSRD_REF_ID = (String) proclist.get(0).getValueObject();
						PT_IL_POLICY_BEAN.setPOL_OLD_ASSRD_REF_ID(POL_OLD_ASSRD_REF_ID);

					}
				}

			}

			/* End */

			/* Added by dhinesh 5.8.2016 */

			/* End */
			/* Added by Ameen on 08-06-2017 for ZBILQC-1728002 */
			// bankDetailsDefaulting();
			/*
			 * COMP_POL_CUST_BANK_CODE.resetValue();
			 * COMP_UI_M_CITY_CODE.resetValue();
			 * COMP_UI_M_CITY_CODE_DESC.resetValue();
			 * COMP_UI_M_BANK_CODE.resetValue();
			 * COMP_UI_M_BANK_CODE_DESC_1.resetValue();
			 * COMP_UI_M_BRANCH_CODE.resetValue();
			 */
			getCOMP_POL_ASSRD_REF_ID1().setValid(true);
			/* End */

			/* added by raja 09-06-2017 for ZBILQC-1724894 */
			/*
			 * LIFELIB lifelib = new LIFELIB();
			 * lifelib.P_VAL_CUST(PT_IL_POLICY_BEAN.getPOL_CUST_CODE(),
			 * PT_IL_POLICY_BEAN.getUI_M_POL_CUST_DESC(), "N", "N",
			 * PT_IL_POLICY_BEAN.getPOL_DIVN_CODE());
			 */
			/* end */

			/* Added by Ameen on 20-04-2018 for KIC */

			/* modified by gopi for toi on 26/05/18 */
			/*
			 * if(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2()==null){
			 * PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2(PT_IL_POLICY_BEAN.
			 * getPOL_ASSRD_REF_ID1()); }
			 */

			String Benef_cust_flag = getBeneficiary_as_customer();

			if (Benef_cust_flag != null && !"Y".equalsIgnoreCase(Benef_cust_flag)) {
				if (PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2() == null) {
					PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1());
				}
			}
			COMP_POL_ASSRD_REF_ID2.resetValue();
			/* End */

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_ASSRD_REF_ID1", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/* Modified by ganesh on 02-11-2017 to avoid defaulting in validation */
	// ADDED BY SARANYA
	public void validatePOL_DIVISION(FacesContext context, UIComponent component, Object object) {

		try {
			PT_IL_POLICY_BEAN.setPOL_BANK_DIVN((String) object);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	// END

	public void POL_VALIDATE_CUST_MAIL_ID(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		try {

			PT_IL_POLICY_BEAN.setPOL_RES_EMAIL_ID((String) value);
			if (CommonUtils.nvl((String) value, "T").equals("T")) {
				setEflag(true);
			} else {
				setEflag(false);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	public void selectquerymail() throws SQLException, DBException {
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String cust_code = PT_IL_POLICY_BEAN.getPOL_CUST_CODE();
		String Cust_phone = "";
		String email_id = "";
		System.out.println("value of cust_code" + cust_code);

		String query = "select cust_phone2, Cust_email_id_per from pm_customer where cust_code='" + cust_code
				+ "' and cust_class IN ('INDL','DC')";
		System.out.println("query---------->" + query);
		resultSet = new CRUDHandler().executeSelectStatement(query, connection);
		COMP_POL_MOBILE_NO.resetValue();
		COMP_POL_RES_EMAIL_ID.resetValue();
		while (resultSet.next()) {
			Cust_phone = resultSet.getString("CUST_PHONE2");
			email_id = resultSet.getString("CUST_EMAIL_ID_PER");
			getListPhoneEmail().add(Cust_phone);
			getListPhoneEmail().add(email_id);
		}

		/* return list1; */
	}

	public void validatePOL_NO(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			/*
			 * Newly added by pidugu raj dt: 23-10-2018 for KICLIFEQC-1773914 as
			 * per sreeram suggestion
			 */
			if (!(value.toString().matches("^[a-zA-Z0-9]+$"))) {
				throw new ValidatorException(new FacesMessage("Invalid characters!"));
			}
			/*
			 * Newly added by pidugu raj dt: 23-10-2018 for KICLIFEQC-1773914 as
			 * per sreeram suggestion
			 */
			PT_IL_POLICY_BEAN.setPOL_NO((String) value);
			helper.POL_NO_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN.getPOL_DS_TYPE(), (String) value, compositeAction);
			COMP_POL_NO.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_NO", getWarningMap());
			} catch (Exception e) {
				getErrorMap().put("current", e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_JOINT_LIFE_YN(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_JOINT_LIFE_YN((String) value);
			helper.POL_JOINT_LIFE_YN_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			COMP_POL_JOINT_LIFE_YN.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_JOINT_LIFE_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_PROD_GROUP_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_PROD_GROUP_CODE((String) value);
			helper.POL_PROD_GROUP_CODE_WHEN_VALIDATE_ITEM(this, PT_IL_POLICY_BEAN, (String) value);
			COMP_POL_PROD_CODE.resetValue();
			COMP_UI_M_POL_PROD_GROUP_CODE.resetValue();
			// validatePOL_PROD_CODE(facesContext, component, value);
			// validatePOL_PLAN_CODE(facesContext, component, value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PROD_GROUP_CODE",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_PROD_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			// PT_IL_POLICY_BEAN.setPOL_PROD_CODE((String)value);
			helper.POL_PROD_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value,
					CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PROD_CODE(), ""));

			PT_IL_POLICY_BEAN.setPOL_PROD_CODE((String) value);
			// COMP_POL_PROD_CODE.resetValue();
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
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PROD_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * changed by ram
	 * 
	 * public void validatePOL_PREM_OPTION(FacesContext facesContext,
	 * UIComponent component, Object value) throws ValidatorException {
	 * CommonUtils.clearMaps(this); try {
	 * PT_IL_POLICY_BEAN.setPOL_PREM_OPTION_CODE((String) value);
	 * System.out.println("getPOL_PREM_OPTION_CODE "+PT_IL_POLICY_BEAN.
	 * getPOL_PREM_OPTION_CODE());
	 * 
	 * commented by ram helper.POL_PLAN_CODE_WHEN_VALIDATE_ITEM(compositeAction,
	 * (String) value); // COMP_POL_PLAN_CODE.resetValue();
	 * COMP_UI_M_POL_PLAN_DESC.resetValue();
	 * 
	 * end
	 * 
	 * } catch (Exception exception) { exception.printStackTrace(); throw new
	 * ValidatorException(new FacesMessage(exception .getMessage())); } finally
	 * { try { ErrorHelpUtil.getWarningForProcedure(CommonUtils
	 * .getConnection(), "POL_PLAN_CODE", getWarningMap()); } catch (Exception
	 * e) { e.printStackTrace(); } } }
	 * 
	 * 
	 * end
	 */

	public void validatePOL_PLAN_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_PLAN_CODE((String) value);
			helper.POL_PLAN_CODE_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			// COMP_POL_PLAN_CODE.resetValue();
			COMP_UI_M_POL_PLAN_DESC.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_PLAN_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String gotoFileUpload() {
		String outcome = null;
		if (PT_IL_POLICY_BEAN != null && PT_IL_POLICY_BEAN.getPOL_NO() != null
				&& !(PT_IL_POLICY_BEAN.getPOL_NO().trim().isEmpty())) {

			FileUploadAction uploadAction = new FileUploadAction(PT_IL_POLICY_BEAN.getPOL_NO(),
					PELConstants.pelPolicyTrans, "PILT002_APAC_PT_IL_POLICY", this.getErrorMap());
			outcome = uploadAction.gotoFileUpload();
		} else {
			getErrorMap().clear();
			String fileUploadErrorMessage = Messages.getString("messageProperties_fileUpload",
					"fileupload$polreference$error$message");
			getErrorMap().put("key", fileUploadErrorMessage);
			getErrorMap().put("current", fileUploadErrorMessage);
		}
		return outcome;
	}

	/*
	 * public void validatePOL_ISSUE_DT(FacesContext facesContext, UIComponent
	 * component, Object value) throws ValidatorException {
	 * CommonUtils.clearMaps(this); Date dtValue = (Date) value; try {
	 * helper.POL_ISSUE_DT_WHEN_VALIDATE_ITEM(compositeAction, dtValue);
	 * PT_IL_POLICY_BEAN.setPOL_ISSUE_DT(dtValue);
	 * COMP_POL_UW_YEAR.resetValue(); COMP_POL_START_DT.resetValue();
	 * COMP_POL_PROP_RECV_DT.resetValue(); COMP_POL_PROP_STAMP_DT.resetValue();
	 * COMP_POL_EXPIRY_DT.resetValue(); // COMP_POL_ISSUE_DT.resetValue();
	 * 
	 * } catch (Exception exception) { exception.printStackTrace(); throw new
	 * ValidatorException(new FacesMessage(exception .getMessage())); } finally
	 * { try { ErrorHelpUtil.getWarningForProcedure(CommonUtils
	 * .getConnection(), "POL_ISSUE_DT", getWarningMap()); } catch (Exception e)
	 * { e.printStackTrace(); } } }
	 */
	public void validatePOL_ISSUE_DT(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		CommonUtils.clearMaps(this);

		Date dtValue = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_ISSUE_DT();

		try {

			System.out.println(
					"compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_ISSUE_DT()    :  "
							+ compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_ISSUE_DT());

			helper.POL_ISSUE_DT_WHEN_VALIDATE_ITEM(compositeAction, dtValue);
			PT_IL_POLICY_BEAN.setPOL_ISSUE_DT(dtValue);
			COMP_POL_UW_YEAR.resetValue();
			COMP_POL_START_DT.resetValue();
			COMP_POL_PROP_RECV_DT.resetValue();
			COMP_POL_PROP_STAMP_DT.resetValue();
			COMP_POL_EXPIRY_DT.resetValue();
			// COMP_POL_ISSUE_DT.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_ISSUE_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_ESC_YN(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_ESC_YN((String) value);
			helper.POL_ESC_YN_WHEN_VALIDATE_ITEM(this, PT_IL_POLICY_BEAN);
			COMP_POL_CVR_ESC_PERC.resetValue();
			COMP_POL_FLEX_14.resetValue();
			COMP_POL_FLEX_09.resetValue();
			COMP_POL_FLEX_18.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_ESC_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateAppliedOn(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_FLEX_09((String) value);
			helper.Applied_On_WHEN_VALIDATE_ITEM(this, PT_IL_POLICY_BEAN);
			COMP_POL_FLEX_18.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_FLEX_09", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CVR_ESC_PERC(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_CVR_ESC_PERC((Integer) value);
			helper.POL_CVR_ESC_PERC_WHEN_VALIDATE_ITEM(PT_IL_POLICY_BEAN);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CVR_ESC_PERC", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// lov

	public HtmlOutputLabel getCOMP_POL_OCC_RATE_LABEL() {
		return COMP_POL_OCC_RATE_LABEL;
	}

	public void setCOMP_POL_OCC_RATE_LABEL(HtmlOutputLabel comp_pol_occ_rate_label) {
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

	public void setCOMP_POL_PROD_GROUP_CODE_LABEL(HtmlOutputLabel comp_pol_prod_group_code_label) {
		COMP_POL_PROD_GROUP_CODE_LABEL = comp_pol_prod_group_code_label;
	}

	public HtmlInputText getCOMP_POL_PROD_GROUP_CODE() {
		return COMP_POL_PROD_GROUP_CODE;
	}

	public void setCOMP_POL_PROD_GROUP_CODE(HtmlInputText comp_pol_prod_group_code) {
		COMP_POL_PROD_GROUP_CODE = comp_pol_prod_group_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PROD_GROUP_CODE_LABEL() {
		return COMP_UI_M_POL_PROD_GROUP_CODE_LABEL;
	}

	public void setCOMP_UI_M_POL_PROD_GROUP_CODE_LABEL(HtmlOutputLabel comp_ui_m_pol_prod_group_code_label) {
		COMP_UI_M_POL_PROD_GROUP_CODE_LABEL = comp_ui_m_pol_prod_group_code_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_PROD_GROUP_CODE() {
		return COMP_UI_M_POL_PROD_GROUP_CODE;
	}

	public void setCOMP_UI_M_POL_PROD_GROUP_CODE(HtmlInputText comp_ui_m_pol_prod_group_code) {
		COMP_UI_M_POL_PROD_GROUP_CODE = comp_ui_m_pol_prod_group_code;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_GRP_CODE() {
		return COMP_UI_M_BUT_LOV_GRP_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_GRP_CODE(HtmlCommandButton comp_ui_m_but_lov_grp_code) {
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
		ResultSet rs = null;
		Object[] values = null;
		String currentValue = (String) object;
		String query = " SELECT NVL(CLASS_FACIN_YN, 'N')   	FROM   PM_IL_CLASS" + "  WHERE  CLASS_CODE = ? ";

		String subQry = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";

		/*
		 * commented by Ameen for lov lower case issue ssp call id
		 * FALCONLIFE-1344105
		 * 
		 * String mainQry = "SELECT CUST_CODE,CUST_NAME,CUST_BL_NAME " +
		 * " FROM PM_CUSTOMER WHERE CUST_CLASS IN " +
		 * " (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM " +
		 * " WHERE DECODE(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN " +
		 * " (?)) AND CUST_FRZ_FLAG = 'N' AND (CUST_APPL_ALL_BRAN_YN = 'Y'" +
		 * " OR CUST_CODE IN " + " (SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN " +
		 * " WHERE CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE))) AND " +
		 * "(CUST_CODE LIKE ? OR CUST_NAME LIKE ? OR  CUST_BL_NAME LIKE ?)AND  ROWNUM < 25 order by 1"
		 * ;
		 */

		/*
		 * Added by Ameen for lov lower case issue ssp call id
		 * FALCONLIFE-1344105
		 */
		String mainQry = "SELECT CUST_CODE,CUST_NAME,CUST_BL_NAME " + " FROM PM_CUSTOMER WHERE CUST_CLASS IN "
				+ " (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM "
				+ " WHERE DECODE(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN "
				+ " (?)) AND CUST_FRZ_FLAG = 'N' AND (CUST_APPL_ALL_BRAN_YN = 'Y'" + " OR CUST_CODE IN "
				+ " (SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN "
				+ " WHERE CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE))) AND "
				+ "(UPPER(CUST_CODE) LIKE UPPER(?) OR UPPER(CUST_NAME) LIKE UPPER(?) OR  UPPER(CUST_BL_NAME) LIKE UPPER(?))AND  ROWNUM < 25 order by 1";
		/* End */
		System.out.println(mainQry);
		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });

			while (rs.next()) {
				M_FACIN_YN = rs.getString(1);
			}
			// ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.

			if (("1".equals(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_CALC_METHOD())
					|| "2".equals(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_CALC_METHOD()))
					&& "C".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARA_7"))) {
				mainQry = prepareCustomerQuery(mainQry, new Object[] { "BANK" });
				values = new Object[] { PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), currentValue, currentValue,
						currentValue };
				suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);

			} else {
				if ("N".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_CASH_YN(), "N"))) {
					if ("N".equals(CommonUtils.nvl(M_FACIN_YN, "N"))) {

						mainQry = prepareCustomerQuery(mainQry, new Object[] { "CUSTOMER" });
						values = new Object[] { PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), currentValue, currentValue,
								currentValue };
						suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);

					} else {
						mainQry = prepareCustomerQuery(mainQry, new Object[] { "REINS" });
						values = new Object[] { PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), currentValue, currentValue,
								currentValue };
						suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);
					}
				} else {
					mainQry = prepareCustomerQuery(mainQry, new Object[] { "CASH" });
					values = new Object[] { PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), currentValue, currentValue,
							currentValue };
					suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);

				}
			}

			/* added by raja on 02-06-2017 for hanends on points */
			PT_IL_POLICY_BEAN.setUI_M_CUST_FLAG("Y");
			/* end */

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return suggestionList;
	}

	public String prepareCustomerQuery(String CustCodeQuery, Object[] values) {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String query_input = "";
		String subQry = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(subQry, connection, values);
			if (resultSet.next()) {
				query_input = resultSet.getString("PS_CODE_DESC");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		CustCodeQuery = CustCodeQuery.replaceFirst("\\?", query_input);
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
		String subQry = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";
		String mainQry = "SELECT CUST_CODE,CUST_NAME,CUST_BL_NAME " + " FROM PM_CUSTOMER WHERE CUST_CLASS IN "
				+ " (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM "
				+ " WHERE DECODE(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN "
				+ " (?)) AND CUST_FRZ_FLAG = 'N' AND (CUST_APPL_ALL_BRAN_YN = 'Y'" + " OR CUST_CODE IN "
				+ " (SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN "
				+ " WHERE CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE))) and ROWNUM < 25 order by 1";
		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			mainQry = prepareCustomerQuery(mainQry, new Object[] { "CUSTOMER" });
			values = new Object[] { PT_IL_POLICY_BEAN.getPOL_DIVN_CODE() };
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

	public void setCOMP_UI_M_BUT_ENDT_CANCEL(HtmlCommandButton comp_ui_m_but_endt_cancel) {
		COMP_UI_M_BUT_ENDT_CANCEL = comp_ui_m_but_endt_cancel;
	}

	public String getToggleState() {
		System.out.println("PT_IL_POLICY_ACTION.getToggleState()" + toggleState);
		return toggleState;
	}

	public void setToggleState(String toggleState) {
		System.out.println("PT_IL_POLICY_ACTION.setToggleState()" + toggleState);
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

		/*
		 * if(COMP_POL_RES_ADDRESS_1.getValue() !=null &&
		 * !"".equals(COMP_POL_RES_ADDRESS_1.getValue()) ){
		 * 
		 * }else
		 */if (COMP_POL_RES_ADDRESS_1.getValue() == null && "".equals(COMP_POL_RES_ADDRESS_1.getValue())) {

			throw new ValidatorException(new FacesMessage("Residential Address " + Messages
					.getString(PELConstants.pelMessagePropertiesPath, "javax.faces.component.UIInput.REQUIRED")));
		}
		/*
		 * if(COMP_POL_TARIFF_TERM_FLAG.getValue() !=null &&
		 * !"".equals(COMP_POL_TARIFF_TERM_FLAG.getValue()) ){
		 * 
		 * }else
		 */if (COMP_POL_TARIFF_TERM_FLAG.getValue() == null && "".equals(COMP_POL_TARIFF_TERM_FLAG.getValue())) {

			throw new ValidatorException(new FacesMessage("Tariff Term Flag " + Messages
					.getString(PELConstants.pelMessagePropertiesPath, "javax.faces.component.UIInput.REQUIRED")));
		}
		if ("M".equals(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_POL_PLAN_TYPE())) {
			if (COMP_POL_CREDIT_INT_RATE.getValue() != null && !"".equals(COMP_POL_CREDIT_INT_RATE.getValue())) {
				// validatePOL_IRDA_CLASS_CODE(FacesContext.getCurrentInstance(),COMP_POL_CREDIT_INT_RATE,
				// COMP_POL_CREDIT_INT_RATE.getValue());
			} else {
				throw new ValidatorException(new FacesMessage("Loan Interest Rate " + Messages
						.getString(PELConstants.pelMessagePropertiesPath, "javax.faces.component.UIInput.REQUIRED")));
			}
		}
	}

	/**
	 * Disables all components in PT_IL_POLICY_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		// COMP_UI_M_POL_CONT_DESC.setDisabled(disabled);
		/* Added by saranya on 18-03-2017 */
		COMP_POL_LOAN_TYPE.setDisabled(disabled);
		COMP_POL_ANN_BNF_AMT.setDisabled(disabled);
		COMP_POL_BNF_ESC_PERC.setDisabled(disabled);
		COMP_POL_ANN_PAY_PERIOD.setDisabled(disabled);

		COMP_POL_UL_PREM_CALC.setDisabled(disabled);

		/* End */
		// Added by saranya
		COMP_UI_M_CITY_CODE.setDisabled(disabled);
		COMP_UI_M_CITY_CODE_DESC.setDisabled(disabled);
		COMP_UI_M_BRANCH_CODE.setDisabled(disabled);
		COMP_UI_M_BANK_CODE.setDisabled(disabled);
		COMP_UI_M_BANK_CODE_DESC_1.setDisabled(disabled);
		// End
		/*
		 * Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB
		 * Life_002-Customer Master Changes COMMENTS
		 */
		COMP_POL_PREM_PAYER_CODE.setDisabled(disabled);
		COMP_UI_M_POL_PREM_PAYER_CODE_DESC.setDisabled(disabled);
		/* end */
		/*
		 * Added by saranya on 02-11-2016 for RM018T - FSD_IL_ZB
		 * Life_013_Underwriting changes
		 */
		COMP_POL_FC_AGENT_PREM.setDisabled(disabled);
		/* added by gopi ZBILQC_02-JAN-2017_Disabling of fields on 07/01/17 */
		// COMP_POL_LC_AGENT_PREM.setDisabled(disabled);
		/* end */
		/* End */
		/*
		 * added by saranya on 10-12-2016 for RM018T - FSD_IL_ZB
		 * Life_016-Queried Proposals v1.0
		 */
		COMP_POL_CANCEL_YN.setDisabled(disabled);
		/* End */
		COMP_POL_EMR_RATE.setDisabled(disabled);
		COMP_POL_CURR_SA_LIMIT.setDisabled(disabled);
		COMP_POL_CURR_SA.setDisabled(disabled);
		COMP_PROP_LC_DEP_PREM.setDisabled(disabled);
		COMP_PROP_FC_DEP_PREM.setDisabled(disabled);
		COMP_POL_DEF_PERIOD_FM.setDisabled(disabled);
		COMP_POL_DEF_PERIOD_TO.setDisabled(disabled);
		COMP_POL_WAQAF_PERIOD_FM.setDisabled(disabled);
		COMP_POL_WAQAF_PERIOD_TO.setDisabled(disabled);
		COMP_POL_END_CODE.setDisabled(disabled);
		// COMP_UI_M_POL_END_CODE_DESC.setDisabled(disabled);
		COMP_POL_END_NO.setDisabled(disabled);
		COMP_POL_END_DESC.setDisabled(disabled);
		COMP_UI_M_PAY_PERIOD.setDisabled(disabled);
		COMP_UI_M_PAY_YEARS.setDisabled(disabled);
		COMP_UI_M_LC_SA.setDisabled(disabled);
		COMP_UI_M_FC_SA.setDisabled(disabled);
		COMP_POL_PROD_CODE.setDisabled(disabled);
		// COMP_UI_M_PROD_DESC.setDisabled(disabled);
		COMP_POL_PROD_GROUP_CODE.setDisabled(disabled);
		// COMP_UI_M_POL_PROD_GROUP_CODE.setDisabled(disabled);
		COMP_POL_PLAN_CODE.setDisabled(disabled);
		// COMP_UI_M_POL_PLAN_DESC.setDisabled(disabled);
		// COMP_POL_UW_YEAR.setDisabled(disabled);
		/* added by gopi ZBILQC_02-JAN-2017_Disabling of fields on 07/01/17 */
		// COMP_POL_NO_YRS_PREM_PAID.setDisabled(disabled);
		// COMP_POL_JOINT_LIFE_AGE.setDisabled(disabled);
		/* end */
		// COMP_POL_NO.setDisabled(disabled);
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
		// COMP_UI_M_POL_RES_AREA_CODE_DESC.setDisabled(disabled);
		COMP_POL_CITY_CODE.setDisabled(disabled);
		// COMP_UI_M_POL_CITY_NAME.setDisabled(disabled);
		COMP_POL_STATE_CODE.setDisabled(disabled);
		// COMP_UI_M_POL_STATE_NAME.setDisabled(disabled);
		COMP_POL_COUNT_CODE.setDisabled(disabled);
		// COMP_UI_M_POL_COUNT_NAME.setDisabled(disabled);
		COMP_POL_RES_PHONE_NO.setDisabled(disabled);
		COMP_POL_MOBILE_NO.setDisabled(disabled);
		COMP_POL_OFF_ADDRESS_1.setDisabled(disabled);
		COMP_POL_OFF_ADDRESS_2.setDisabled(disabled);
		COMP_POL_OFF_ADDRESS_3.setDisabled(disabled);
		COMP_POL_OFF_AREA_CODE.setDisabled(disabled);
		// COMP_UI_M_POSTAL_NAME.setDisabled(disabled);
		COMP_POL_OFF_PHONE_NO.setDisabled(disabled);
		COMP_POL_FAX_NO.setDisabled(disabled);
		COMP_POL_FAX_AREA_CODE.setDisabled(disabled);
		// COMP_UI_M_POL_ADDL_STATUS_DESC.setDisabled(disabled);
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
		// COMP_UI_M_PROJECT_CODE_DESC.setDisabled(disabled);
		COMP_POL_DEVELOPER_CODE.setDisabled(disabled);
		// COMP_UI_M_DEVELOPER_CODE_DESC.setDisabled(disabled);
		COMP_POL_PAYOR_SDCODE.setDisabled(disabled);
		// COMP_UI_M_PAYOR_CONT_NAME.setDisabled(disabled);
		COMP_POL_CUST_CODE.setDisabled(disabled);
		// COMP_UI_M_POL_CUST_DESC.setDisabled(disabled);
		COMP_POL_BASIC_RATE.setDisabled(disabled);
		COMP_POL_FC_BASIC_PREM.setDisabled(disabled);
		COMP_POL_LC_BASIC_PREM.setDisabled(disabled);
		COMP_POL_FC_HEALTH_LOAD.setDisabled(disabled);
		COMP_POL_LC_HEALTH_LOAD.setDisabled(disabled);
		COMP_POL_FLEX_01.setDisabled(disabled);
		// COMP_UI_M_CONT_NAME.setDisabled(disabled);
		COMP_POL_DEFER_PRD.setDisabled(disabled);
		COMP_POL_EMPLOYER_CODE.setDisabled(disabled);
		COMP_POL_SRC_OF_BUS.setDisabled(disabled);
		// COMP_UI_M_POL_SRC_OF_BUS_DESC.setDisabled(disabled);
		COMP_POL_FC_ADDL_PREM.setDisabled(disabled);
		COMP_POL_LC_ADDL_PREM.setDisabled(disabled);
		COMP_POL_FC_TOT_SA.setDisabled(disabled);
		COMP_POL_LC_TOT_SA.setDisabled(disabled);
		COMP_UI_M_FC_DEATH_LOAD.setDisabled(disabled);
		COMP_UI_M_LC_DEATH_LOAD.setDisabled(disabled);
		COMP_POL_FLEX_02.setDisabled(disabled);
		COMP_POL_SUB_PLAN_CODE.setDisabled(disabled);
		COMP_POL_CONT_CODE.setDisabled(disabled);
		// COMP_POL_ASSURED_NAME.setDisabled(disabled);
		COMP_UI_M_POL_FC_TOT_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_PREM.setDisabled(disabled);
		COMP_UI_M_POL_FC_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_PREM.setDisabled(disabled);
		COMP_UI_M_FC_TPD_LOAD.setDisabled(disabled);
		COMP_UI_M_LC_TPD_LOAD.setDisabled(disabled);
		COMP_POL_FLEX_03.setDisabled(disabled);
		COMP_POL_GRANTEE_NAME.setDisabled(disabled);
		// COMP_UI_M_POL_SUB_PLAN_CODE_DESC.setDisabled(disabled);
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
		// COMP_UI_M_POL_INTRODUCER_REF_ID1_DESC.setDisabled(disabled);
		COMP_POL_BANK_BRANCH_NAME.setDisabled(disabled);
		// COMP_UI_M_BRANCH_CODE_DESC.setDisabled(disabled);
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
		// COMP_UI_M_POL_SA_CURR_DESC.setDisabled(disabled);
		COMP_POL_SA_EXCH_RATE.setDisabled(disabled);
		// COMP_UI_M_POL_DIVN_DESC.setDisabled(disabled);
		COMP_UI_M_FC_PCHARGES_BORNE_CUST.setDisabled(disabled);
		COMP_UI_M_LC_PCHARGES_BORNE_CUST.setDisabled(disabled);
		COMP_UI_M_FC_GROSS_CONT.setDisabled(disabled);
		COMP_UI_M_LC_GROSS_CONT.setDisabled(disabled);
		COMP_POL_LC_EXC_INT_AMT.setDisabled(disabled);
		COMP_POL_CUST_CURR_CODE.setDisabled(disabled);
		// COMP_UI_M_POL_CUST_CURR_DESC.setDisabled(disabled);
		COMP_POL_CUST_EXCH_RATE.setDisabled(disabled);
		COMP_POL_DEPT_CODE.setDisabled(disabled);
		COMP_UI_M_POL_FC_NET_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_NET_PREM.setDisabled(disabled);
		COMP_UI_M_FC_BROK_COMM.setDisabled(disabled);
		COMP_UI_M_LC_BROK_COMM.setDisabled(disabled);
		COMP_POL_EXC_INT_PERC.setDisabled(disabled);
		COMP_POL_STAFF_CCLASS_CODE.setDisabled(disabled);
		// COMP_UI_M_CCLAS_CLASS_DESC.setDisabled(disabled);
		COMP_POL_FC_EXC_INT_AMT.setDisabled(disabled);
		/*
		 * Commeneted by Saranya on 07/04/2017
		 * 
		 * COMP_POL_FC_MODAL_PREM.setDisabled(disabled);
		 * 
		 * End
		 */
		COMP_POL_NO_OF_UNIT.setDisabled(disabled);
		COMP_POL_LC_MODAL_PREM.setDisabled(disabled);
		// COMP_UI_M_POL_DEPT_DESC.setDisabled(disabled);
		COMP_UI_M_POL_MODE_OF_PYMT_RATE.setDisabled(disabled);
		COMP_UI_M_POL_FC_MOP.setDisabled(disabled);
		COMP_UI_M_POL_LC_MOP.setDisabled(disabled);
		COMP_UI_M_FC_CHARGE.setDisabled(disabled);
		COMP_UI_M_LC_CHARGE.setDisabled(disabled);
		COMP_POL_RI_POOL_CODE.setDisabled(disabled);
		// COMP_UI_M_POL_RI_POOL_CODE_DESC.setDisabled(disabled);
		COMP_POL_LOAD_PERC.setDisabled(disabled);
		// COMP_POL_NO_OF_INST.setDisabled(disabled);
		// COMP_POL_MODE_OF_PYMT_RATE.setDisabled(disabled);
		// COMP_POL_CLASS_CODE.setDisabled(disabled);
		COMP_UI_M_POL_FC_GR_ANN_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_GR_ANN_PREM.setDisabled(disabled);
		COMP_UI_M_FC_PCHARGES_BORNE_COMP.setDisabled(disabled);
		COMP_UI_M_LC_PCHARGES_BORNE_COMP.setDisabled(disabled);

		COMP_POL_ORG_COMM_RATE.setDisabled(disabled);
		COMP_POL_ORG_COMM_VALUE.setDisabled(disabled);
		COMP_POL_COMM_RATE.setDisabled(disabled);
		COMP_POL_COMM_VALUE.setDisabled(disabled);

		COMP_POL_FC_NET_PREM.setDisabled(disabled);
		COMP_POL_LC_NET_PREM.setDisabled(disabled);
		COMP_UI_M_FC_INST_PREM.setDisabled(disabled);
		COMP_UI_M_LC_INST_PREM.setDisabled(disabled);
		COMP_POL_CQS_PERC.setDisabled(disabled);
		COMP_POL_CREDIT_DISCOUNT_PERC.setDisabled(disabled);
		COMP_POL_FORM_NO.setDisabled(disabled);

		/* Newly Added By Dhinesh on 31-05-2018 */
		if ("Y".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.PROD_SA_BY_PLAN_BASIS_YN"))) {
			COMP_POL_FC_SUM_ASSURED.setDisabled(true);
		} else {
			COMP_POL_FC_SUM_ASSURED.setDisabled(disabled);
		}
		/* End */

		COMP_POL_LC_SUM_ASSURED.setDisabled(disabled);
		// COMP_UI_M_POL_CLASS_DESC.setDisabled(disabled);
		COMP_UI_M_POL_INST_FC_PREM.setDisabled(disabled);
		COMP_UI_M_POL_INST_LC_PREM.setDisabled(disabled);
		COMP_POL_FC_BANK_ALLOC_AMT.setDisabled(disabled);
		COMP_POL_LC_BANK_ALLOC_AMT.setDisabled(disabled);
		COMP_UI_M_POL_CONT_AD_ACC_NO.setDisabled(disabled);
		COMP_POL_PROP_REF_NO.setDisabled(disabled);
		COMP_POL_AGENT_REF_CODE.setDisabled(disabled);
		COMP_POL_FC_DEPOSIT_AMOUNT.setDisabled(disabled);
		COMP_POL_LC_DEPOSIT_AMOUNT.setDisabled(disabled);
		COMP_POL_STD_SUBSTD.setDisabled(disabled);
		COMP_POL_CUST_BANK_CODE.setDisabled(disabled);
		COMP_POL_MICR_CODE.setDisabled(disabled);
		if (disabled) {
			COMP_TAB_PANEL.setSwitchType("client");
		} else {
			COMP_TAB_PANEL.setSwitchType("ajax");
		}
		if ("U".equals(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_POL_PLAN_TYPE())) {
			COMP_POL_LC_MIN_PREM.setDisabled(true);
			COMP_POL_FC_MIN_PREM.setDisabled(true);
			COMP_POL_LC_EXTRA_PREM.setDisabled(true);
			COMP_POL_FC_EXTRA_PREM.setDisabled(true);
		} else {
			COMP_POL_LC_MIN_PREM.setDisabled(disabled);
			COMP_POL_FC_MIN_PREM.setDisabled(disabled);
			COMP_POL_LC_EXTRA_PREM.setDisabled(disabled);
			COMP_POL_FC_EXTRA_PREM.setDisabled(disabled);
		}
		/*
		 * //COMP_POL_LC_MIN_PREM.setDisabled(disabled);
		 * COMP_POL_FC_MIN_PREM.setDisabled(disabled);
		 * COMP_POL_LC_EXTRA_PREM.setDisabled(disabled);
		 * COMP_POL_FC_EXTRA_PREM.setDisabled(disabled);
		 */
		COMP_POL_FC_DISC_AMT.setDisabled(disabled);
		COMP_POL_LC_DISC_AMT.setDisabled(disabled);
		COMP_POL_FC_CLIENT_ALLOC_AMT.setDisabled(disabled);
		COMP_POL_LC_CLIENT_ALLOC_AMT.setDisabled(disabled);
		COMP_POL_CONT_AD_BANK_CODE.setDisabled(disabled);
		// COMP_UI_M_BANK_CODE_DESC.setDisabled(disabled);
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
		COMP_POL_NEW_LC_SA.setDisabled(disabled);
		COMP_POL_NEW_FC_SA.setDisabled(disabled);
		COMP_POL_ORG_NEW_LC_SA.setDisabled(disabled);
		COMP_POL_ORG_NEW_FC_SA.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_POL_MED_FEE_RECOVER_YN.setDisabled(disabled);
		// COMP_POL_JOINT_LIFE_YN.setDisabled(disabled);
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

		// COMP_POL_ISSUE_DT.setDisabled(disabled);

		COMP_POL_TRAN_DT.setDisabled(disabled);
		COMP_POL_PROP_RECV_DT.setDisabled(disabled);
		COMP_POL_PROP_STAMP_DT.setDisabled(disabled);
		COMP_POL_PROP_DECL_DT.setDisabled(disabled);
		COMP_POL_START_DT.setDisabled(disabled);
		COMP_POL_EXPIRY_DT.setDisabled(disabled);
		COMP_POL_NL_FM_DT.setDisabled(disabled);
		// COMP_POL_FIRST_INST_DT.setDisabled(disabled);
		// COMP_POL_LAST_INST_DT.setDisabled(disabled);
		COM_POL_APL_LIST.setDisabled(disabled);

		COMP_POL_FLEX_14.setDisabled(disabled);
		COMP_POL_FLEX_09.setDisabled(disabled);
		COMP_POL_ESC_YN.setDisabled(disabled);
		COMP_POL_FLEX_08.setDisabled(disabled);
		COMP_POL_FLEX_18.setDisabled(disabled);
		COMP_POL_LAPS_OVR_YN.setDisabled(disabled);
		COMP_POL_LAPS_OVR_DT.setDisabled(disabled);

		/*
		 * Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation
		 * and commission clawback 2
		 */
		/*
		 * if((PT_IL_POLICY_BEAN.getPOL_NO() !=
		 * null)&&(PT_IL_POLICY_BEAN.getPOL_END_TYPE() !=
		 * null)&&(PT_IL_POLICY_BEAN.getPOL_END_TYPE().equals("001"))&&(
		 * PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG().equals("Y"))){
		 * COMP_POL_LAPS_OVR_YN.setDisabled(false); } else {
		 * COMP_POL_LAPS_OVR_YN.setDisabled(disabled); }
		 */
		/* End */

		/*
		 * Newly Added By Dhinesh on 12-06-2017 for Change in lapsation
		 * Overriding Endorsement Issues
		 */

		/*
		 * if("001".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE()) &&
		 * "GEN008".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_CODE()) &&
		 * "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG()) ) {
		 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN
		 * ().setDisabled(true);
		 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT
		 * ().setDisabled(true); } else {
		 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN
		 * ().setDisabled(false);
		 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT
		 * ().setDisabled(false);
		 * 
		 * }
		 */

		/* End */

		/*
		 * Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation
		 * and commission clawback 2
		 */
		/*
		 * if((PT_IL_POLICY_BEAN.getPOL_NO() !=
		 * null)&&(PT_IL_POLICY_BEAN.getPOL_END_TYPE() !=
		 * null)&&(PT_IL_POLICY_BEAN.getPOL_END_TYPE().equals("001"))&&("Y".
		 * equals(PT_IL_POLICY_BEAN.getPOL_LAPS_OVR_YN()))){
		 * COMP_POL_LAPS_OVR_DT.setDisabled(false); }else{
		 * COMP_POL_LAPS_OVR_DT.setDisabled(disabled); }
		 */
		/* End */

		/*
		 * Added by saritha on 27-01-2017 for RM018T - DEV_IL_ZB
		 * Life_027-Replacement Policy
		 */
		COMP_POL_REPLACEMENT_YN.setDisabled(disabled);
		/* End */

		// Disabling HtmlCommandButton
		/*
		 * COMP_UI_M_BUT_CC_LOV.setDisabled(disabled);
		 * COMP_UI_M_BUT_LOV_GRP_CODE.setDisabled(disabled);
		 * COMP_UI_M_BUT_COPY.setDisabled(disabled);
		 * COMP_UI_M_BUT_FUND_QUERY.setDisabled(disabled);
		 * COMP_UI_M_BUT_HOLD.setDisabled(disabled);
		 * COMP_UI_M_BUT_UDDATE_STAT.setDisabled(disabled);
		 * COMP_UI_M_BUT_UPI.setDisabled(disabled);
		 * COMP_UI_M_BUT_CALC_DISC_LOAD.setDisabled(disabled);
		 * COMP_UI_M_BUT_SURR_MAT.setDisabled(disabled);
		 * COMP_UI_M_BUT_ENDT_OK.setDisabled(disabled);
		 * COMP_UI_M_BUT_ENDT_CANCEL.setDisabled(disabled);
		 * COMP_UI_M_BUT_APPROVAL.setDisabled(disabled);
		 * COMP_UI_M_BUT_PRMDTLS.setDisabled(disabled);
		 * COMP_UI_M_BUT_LOV_PLAN.setDisabled(disabled);
		 * COMP_UI_M_BUT_DOC_GEN_NO.setDisabled(disabled);
		 * COMP_UI_M_BUT_LOV_PROD_CODE.setDisabled(disabled);
		 * COMP_UI_M_BUT_CONVERT.setDisabled(disabled);
		 * COMP_UI_M_BUT_POL_AMDT.setDisabled(disabled);
		 * COMP_UI_M_BUT_UPLOAD.setDisabled(disabled);
		 * COMP_UI_M_BUT_CLAIM.setDisabled(disabled);
		 * COMP_UI_M_BUT_FUND_DTL.setDisabled(disabled);
		 */
		/* Added by sankara narayanan on 20/04/2017 */
		COMP_POL_DISPATCH_MTD.setDisabled(disabled);
		COMP_POL_DISPATCH_DT.setDisabled(disabled);
		COMP_POL_DOC_ACK_DT.setDisabled(disabled);
		/* end */

		/* Added by saritha on 20-07-2017 for ssp call id ZBILQC-1732158 */
		COMP_POL_LAPS_OVR_FRM_DT.setDisabled(disabled);
		/* End */

		/* Added by saritha on 27-10-2017 for ssp call id ZBLIFE-1449063 */
		COMP_POL_CUST_EMP_NO.setDisabled(disabled);
		/* End */

		COMP_UI_M_ACC_NAME.setDisabled(disabled);

		/*
		 * Added by saritha on 21-11-2017 for Due date for debit order by each
		 * policy is required
		 */
		COMP_POL_DEBIT_DAY.setDisabled(disabled);
		/* End */

		/*
		 * Added by ganesh on 01-02-2018 for APL field should based on product
		 * master APL Flag suggested by siva
		 */
		COMP_PROD_INS_APL_YN.setDisabled(disabled);
		/* end */

		COMP_POL_REG_EXCESS_PREM.setDisabled(disabled);
		COMP_POL_RETURN_VAL.setDisabled(disabled);

		/*
		 * Added by Ameen on 24-03-2018 for KIC Method of collection cards
		 * option
		 */
		COMP_POL_CARD_EXP_DT.setDisabled(disabled);
		COMP_POL_CVV_NO.setDisabled(disabled);
		/* End */
		/* added by Ameen for GEN015 endorsement */
		COMP_POL_RES_EMAIL_ID.setDisabled(disabled);
		/* End */
		/* added by Ameen on 13-07-2018 for TOI as per Ajay sugg. */
		COMP_UI_M_POBH_BROKER_CODE.setDisabled(disabled);
		/* End */

		/* added by Ameen on 21-10-2019 for SARWA for Retirement Product */
		COMP_POL_BNF_ESC_YN.setDisabled(disabled);
		COMP_POL_ADHOC_PREM_YN.setDisabled(disabled);
		COMP_POL_ADHOC_LC_PREM.setDisabled(disabled);
		COMP_POL_CASHBACK_YN.setDisabled(disabled);
		COMP_POL_CASHBACK_PREC.setDisabled(disabled);
		COMP_POL_CASHBACK_ST_YR.setDisabled(disabled);
		/* End */
	}

	/**
	 * Disables all components in PT_IL_POLICY_ACTION
	 */
	public void disableAllComponentOld(boolean disabled) {

		// Disabling HtmlInputText
		// added by saranya
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
		// COMP_POL_UW_YEAR.setDisabled(disabled);
		COMP_POL_NO_YRS_PREM_PAID.setDisabled(disabled);
		COMP_POL_JOINT_LIFE_AGE.setDisabled(disabled);
		COMP_POL_NO.setDisabled(disabled);
		COMP_POL_ASSRD_REF_ID1.setDisabled(disabled);
		// COMP_POL_ASSRD_REF_ID2.setDisabled(disabled);
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
		// COMP_UI_M_POSTAL_NAME.setDisabled(disabled);
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
		COMP_POL_ORG_COMM_RATE.setDisabled(disabled);
		COMP_POL_ORG_COMM_VALUE.setDisabled(disabled);
		COMP_POL_COMM_RATE.setDisabled(disabled);
		COMP_POL_COMM_VALUE.setDisabled(disabled);
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

		if (disabled) {
			COMP_TAB_PANEL.setSwitchType("client");
		} else {
			COMP_TAB_PANEL.setSwitchType("ajax");
		}
		if ("U".equals(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_POL_PLAN_TYPE())) {
			COMP_POL_LC_MIN_PREM.setDisabled(true);
			COMP_POL_FC_MIN_PREM.setDisabled(true);
			COMP_POL_LC_EXTRA_PREM.setDisabled(true);
			COMP_POL_FC_EXTRA_PREM.setDisabled(true);
		} else {
			COMP_POL_LC_MIN_PREM.setDisabled(disabled);
			COMP_POL_FC_MIN_PREM.setDisabled(disabled);
			COMP_POL_LC_EXTRA_PREM.setDisabled(disabled);
			COMP_POL_FC_EXTRA_PREM.setDisabled(disabled);
		}

		// Disabling HtmlSelectOneMenu
		COMP_POL_MED_FEE_RECOVER_YN.setDisabled(disabled);
		// COMP_POL_JOINT_LIFE_YN.setDisabled(disabled);
		COMP_POL_FRZ_FLAG.setDisabled(disabled);
		COMP_POL_CASH_YN.setDisabled(disabled);
		COMP_POL_MODE_OF_CALC.setDisabled(disabled);
		COMP_POL_STD_SUBSTD.setDisabled(disabled);
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

		// COMP_POL_ISSUE_DT.setDisabled(disabled);

		COMP_POL_TRAN_DT.setDisabled(disabled);
		COMP_POL_PROP_RECV_DT.setDisabled(disabled);
		COMP_POL_PROP_STAMP_DT.setDisabled(disabled);
		COMP_POL_PROP_DECL_DT.setDisabled(disabled);
		COMP_POL_START_DT.setDisabled(disabled);
		COMP_POL_EXPIRY_DT.setDisabled(disabled);
		COMP_POL_NL_FM_DT.setDisabled(disabled);

		// COMP_POL_FIRST_INST_DT.setDisabled(disabled);
		// COMP_POL_LAST_INST_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		/*
		 * COMP_UI_M_BUS_RUL.setDisabled(disabled);
		 * COMP_UI_M_BUT_CC_LOV.setDisabled(disabled);
		 * COMP_UI_M_BUT_LOV_GRP_CODE.setDisabled(disabled);
		 * COMP_UI_M_BUT_COPY.setDisabled(disabled);
		 * COMP_UI_M_BUT_FUND_QUERY.setDisabled(disabled);
		 * COMP_UI_M_BUT_HOLD.setDisabled(disabled);
		 * COMP_UI_M_BUT_UDDATE_STAT.setDisabled(disabled);
		 * COMP_UI_M_BUT_UPI.setDisabled(disabled);
		 * COMP_UI_M_BUT_CALC_DISC_LOAD.setDisabled(disabled);
		 * COMP_UI_M_BUT_SURR_MAT.setDisabled(disabled);
		 * COMP_UI_M_BUT_ENDT.setDisabled(disabled);
		 * COMP_UI_M_BUT_ENDT_OK.setDisabled(disabled);
		 * COMP_UI_M_BUT_ENDT_CANCEL.setDisabled(disabled);
		 * COMP_UI_M_BUT_APPROVAL.setDisabled(disabled);
		 * COMP_UI_M_BUT_PRMDTLS.setDisabled(disabled);
		 * COMP_UI_M_BUT_LOV_PLAN.setDisabled(disabled);
		 * COMP_UI_M_BUT_DOC_GEN_NO.setDisabled(disabled);
		 * COMP_UI_M_BUT_LOV_PROD_CODE.setDisabled(disabled);
		 * COMP_UI_M_BUT_CONVERT.setDisabled(disabled);
		 * COMP_UI_M_BUT_POL_AMDT.setDisabled(disabled);
		 * COMP_UI_M_BUT_UPLOAD.setDisabled(disabled);
		 * COMP_UI_M_BUT_CLAIM.setDisabled(disabled);
		 * COMP_UI_M_BUT_FUND_DTL.setDisabled(disabled);
		 */

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

	public HtmlGraphicImage getCOMP_POL_CREDIT_INT_RATE_MANDATORY() {
		return COMP_POL_CREDIT_INT_RATE_MANDATORY;
	}

	public void setCOMP_POL_CREDIT_INT_RATE_MANDATORY(HtmlGraphicImage comp_pol_credit_int_rate_mandatory) {
		COMP_POL_CREDIT_INT_RATE_MANDATORY = comp_pol_credit_int_rate_mandatory;
	}

	public String getWizardCaption() {
		return wizardCaption;
	}

	public void setWizardCaption(String wizardCaption) {
		this.wizardCaption = wizardCaption;
	}

	private void enableComponentsBasedOnFreezRate() {
		if ("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
			disableAllComponent(false);
		}

		/* Added by Janani on 07.03.2018 for FSD_FLA_IL_008 */
		else {
			compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().disableAllComponent(true);
		}
		/* End of FSD_FLA_IL_008 */
	}

	/**
	 * @return the listAPL
	 */
	public List<SelectItem> getListAPL() {
		return listAPL;
	}

	/**
	 * @param listAPL
	 *            the listAPL to set
	 */
	public void setListAPL(List<SelectItem> listAPL) {
		this.listAPL = listAPL;
	}

	/**
	 * @return the cOMP_POL_APL_LABEL
	 */
	public HtmlOutputLabel getCOMP_POL_APL_LABEL() {
		return COMP_POL_APL_LABEL;
	}

	/**
	 * @param comp_pol_apl_label
	 *            the cOMP_POL_APL_LABEL to set
	 */
	public void setCOMP_POL_APL_LABEL(HtmlOutputLabel comp_pol_apl_label) {
		COMP_POL_APL_LABEL = comp_pol_apl_label;
	}

	/**
	 * @return the cOM_POL_APL_LIST
	 */
	public HtmlSelectOneMenu getCOM_POL_APL_LIST() {
		return COM_POL_APL_LIST;
	}

	/**
	 * @param com_pol_apl_list
	 *            the cOM_POL_APL_LIST to set
	 */
	public void setCOM_POL_APL_LIST(HtmlSelectOneMenu com_pol_apl_list) {
		COM_POL_APL_LIST = com_pol_apl_list;
	}

	public String printButtonAction() {
		String outcome = null;
		try {

			/* Added by Ram on 13/03/2017 for Common Report by Customerwise */
			/*
			 * if(resourceBundle.getString("isJasperReports") != null) {
			 * if(resourceBundle.getString("isJasperReports").equals("Y")) {
			 * CommonUtils.setGlobalObject("PILP016_COMPOSITE_ACTION", new
			 * com.iii.pel.forms.PILP016_F.PILP016_COMPOSITE_ACTION()); // ADDED
			 * BY SANKARA NARAYANAN ON 16-02-2017 } else { Added by Sankar on
			 * 15.02.2017 for ZB schedule
			 * CommonUtils.setGlobalObject("PILP016_COMPOSITE_ACTION", new
			 * com.iii.pel.forms.PILP016.PILP016_COMPOSITE_ACTION()); // ADDED
			 * BY SANKARA NARAYANAN ON 16-02-2017 End } }
			 */

			/* ENd */
			/* Added by Sankar on 15.02.2017 for ZB schedule */
			CommonUtils.setGlobalObject("PILP016_COMPOSITE_ACTION", new PILP016_COMPOSITE_ACTION()); // ADDED
																										// BY
																										// SANKARA
																										// NARAYANAN
																										// ON
																										// 16-02-2017
			outcome = helper.buttonPressPrint(compositeAction);
			/* Add by sankar on 09/07/2016 for FALCONQC-1715096� */
			compositeAction.getPRINT_ACTION_BEAN().setBlockFlag(true);
			/* end */
		} catch (Exception exception) {
			exception.getMessage();
			getErrorMap().put("current", exception.getMessage());
		}
		return outcome;
	}

	public boolean isEndorseFlag() {
		return endorseFlag;
	}

	public void setEndorseFlag(boolean endorseFlag) {
		this.endorseFlag = endorseFlag;
	}

	// Added by Yalamanda to implement modal panel for Customer Quick Entry
	// screen.

	public String onclickCancel() {
		// compositeAction.getPT_IL_POLICY_ACTION_BEAN().setFormFlag(true);
		// compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
		CommonUtils.clearMaps(this);

		compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_REPORT_MODAL_PANEL_CUSTOMER()
				.setShowWhenRendered(false);
		compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_REPORT_MODAL_PANEL_ASSURED()
				.setShowWhenRendered(false);

		/*
		 * Added by saritha on 06-04-2018 for KIC Pop up message that the
		 * customer/Assured is already exist once ID is entered is required &
		 * CIVIL ID to be numeric field.validation to be there.
		 */

		compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().setBlockFlag(true);
		compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().setBlockFlag(true);

		/*
		 * compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().
		 * getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(false);
		 */
		/* End */

		return "PILT002_APAC_PT_IL_POLICY";
	}

	public String customerModalPanel() {

		/* Added by Janani on 30-05-2017 for ZBILQC-1719696�� */

		int param_type_Cust = 0;

		/* End */
		String outcome = "";
		/* added by Ameen on 26-04-2018 for KIC customer and assured same */
		compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().setCustAssured("C");
		compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_HEADER_LABEL()
				.setValue(Messages.getString(
						CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE") + "messageProperties_PM006_QE",
						"PM006_A_APAC$PM_CUSTOMER_QE$DISPLAY$caption"));
		/* End */
		try {
			System.out.println(" **** customerModalPanel **** ");
			PM006_QE_CUSTOMER_HELPER custHelper = compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getHelper();
			PM006_QE_CUSTOMER_DELEGATE custDelegate = compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getDelegate();
			CommonUtils.setGlobalVariable("CALL_FORM_FOR_CUST", "PILT002_APAC");
			if (PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1() != null
					&& !"".equals(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1())) {
				System.out.println("TRUE BLOCK");
				/*
				 * CommonUtils.setGlobalVariable("GLOBAL.M_POL_ASSRD_REF_ID1",
				 * PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1());
				 */
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN()
						.setCUST_REF_ID1(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1());
				custDelegate.executeQuery(compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN());
				/*
				 * Commented by Janani on 30.05.2017 for ZBILQC-1719696�
				 * 
				 * if ("A".equalsIgnoreCase(PT_IL_POLICY_BEAN
				 * .getPOL_APPRV_STATUS()) ||
				 * "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN .getPOL_FRZ_FLAG())) {
				 * System.out.println(" NESTED TRUE BLOCK");
				 * compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
				 * .disableAllComponent(true); }
				 */

				/* Added by Janani on 30-05-2017 for ZBILQC-1719696�� */

				/*
				 * modified by Ameen to change the sys. param. to enable/diasble
				 * cust. creation fields as per Kuzhandhai sir sugg.
				 * param_type_Cust = CustomerPanelsaving();
				 */

				param_type_Cust = ((BigDecimal) CommonUtils.getPPSystemParameterValue("IL_CUST_FLDS")).intValue();

				System.out.println("param_type_Cust in customer  panel             :" + param_type_Cust);

				if (param_type_Cust == 1) {

					System.out.println("enters into param_type_Cust==1");

					if ("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())
							|| "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {

						compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().disableAllComponent(true);

					}
				} else if (param_type_Cust == 2) { /*
													 * else if condition handled
													 * by Ameen on 03-05-2018
													 * for KIC
													 */

					if ("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())
							&& "N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())
							&& PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() != null
							&& PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0) {
						compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().disableAllComponent(false);
					} else if ("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())
							|| "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
						compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().disableAllComponent(true);
					}
				} else {

					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().disableAllComponent(true);

				}

				/* End */

				/* Added by Ameen on 09-05-2018 for disabling name fields */
				if ((PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() != null && PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() > 0)
						|| "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_FIRST_NAME().setDisabled(true);
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_SURNAME().setDisabled(true);
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_MIDDLE_NAME().setDisabled(true);
				} else {
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_FIRST_NAME().setDisabled(false);
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_SURNAME().setDisabled(false);
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_MIDDLE_NAME().setDisabled(false);
				}
				/* End */

			} else {
				System.out.println("ELSE BLOCK");
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().setPM006_QE_CUSTOMER_BEAN(new PM006_QE_CUSTOMER());
				System.out.println("LINE 12439 ");
				custHelper.when_create_record(
						compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN());
				System.out.println("LINE 12443 ");
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().disableAllComponent(false);

				System.out.println("teeeeeeeesssstttttttt : " + CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_20"));
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN()
						.setCUST_CLASS(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_20"));
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN()
						.setUI_M_CUST_CCLAS_DESC("Individuals");
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_RESIDENCE().setSelected(true);
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN().setCOMM_ADDRS("H");

				/*
				 * Added by Ameen on 19-04-2018 for KIC to default nationality
				 * as per Vijay sugg.
				 */
				ResultSet nationRS = new CRUDHandler().executeSelectStatement(
						"SELECT PC_CODE FROM  PM_CODES  WHERE  PC_TYPE  = 'NATLITY'  AND PC_VALUE  = 1 ",
						CommonUtils.getConnection());
				if (nationRS.next()) {
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN()
							.setCUST_NATIONALITY_CODE(nationRS.getString("PC_CODE"));
				}
				String nationalityDesc = P_VAL_CODES.P_VAL_CODES(CommonUtils.getConnection(), "NATLITY", compositeAction
						.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN().getCUST_NATIONALITY_CODE(), "N",
						"N");
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN()
						.setUI_M_CUST_NATIONALITY_CODE_DESC(nationalityDesc);
				/* End */

			}
			System.out.println("LINE 12447 ");
			/*
			 * commented by Ameen on 02-03-2018 for KIC that to Display customer
			 * screen for projects
			 * compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
			 * .getCOMP_REPORT_MODAL_PANEL_CUSTOMER().setShowWhenRendered(
			 * true);
			 */
			System.out.println("LINE 12451 ");
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_REPORT_MODAL_PANEL_ASSURED()
					.setShowWhenRendered(false);

			outcome = "custCreation";

			System.out.println("LINE 12455 ");
			compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().resetAllComponents();
		} catch (Exception e) {
			compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_REPORT_MODAL_PANEL_CUSTOMER()
					.setShowWhenRendered(false);
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("customerModalPanel", e.getMessage());
		}
		return outcome;
	}

	// Added by Yalamanda to implement modal panel for Assured Quick Entry
	// screen.

	/*
	 * commented by Janani on 24.03.2018 for KIC
	 * 
	 * public String assuredModalPanel() {
	 * 
	 * //Added by Janani on 30-05-2017 for ZBILQC-1719062�
	 * 
	 * int param_type_Cust = 0;
	 * 
	 * //End //OUTCOME HANDLED BY aMEEN ON 26-02-2018 FOR KIC String outcome =
	 * ""; //eND
	 * 
	 * try { PM_IL_CONTRACTOR_HELPER_QE assuredHelper = compositeAction
	 * .getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getHelper();
	 * PM_IL_CONTRACTOR_DELEGATE_QE assuredDelegate = compositeAction
	 * .getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getDelegate();
	 * CommonUtils.setGlobalVariable("CALL_FORM_FOR_CUST", "PILT002_APAC"); if
	 * (PT_IL_POLICY_BEAN.getPOL_CONT_CODE() != null &&
	 * !"".equals(PT_IL_POLICY_BEAN.getPOL_CONT_CODE())) {
	 * CommonUtils.setGlobalVariable("GLOBAL.M_POL_CONT_CODE",
	 * PT_IL_POLICY_BEAN.getPOL_CONT_CODE());
	 * assuredDelegate.executeQuery(compositeAction
	 * .getPM_IL_CONTRACTOR_ACTION_QE_BEAN());
	 * 
	 * 
	 * Commented by Janani on 30-05-2017 for ZBILQC-1719062�
	 * 
	 * //CommonUtils.setGlobalVariable("GLOBAL.M_POL_CONT_CODE", //
	 * PT_IL_POLICY_BEAN.getPOL_CONT_CODE());
	 * //assuredDelegate.executeQuery(compositeAction
	 * //.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()); //if
	 * ("A".equalsIgnoreCase(PT_IL_POLICY_BEAN // .getPOL_APPRV_STATUS()) //||
	 * "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN // .getPOL_FRZ_FLAG())) {
	 * 
	 * // commented by raja on 06-03-2017 for ZBILQC-1719062�
	 * 
	 * // compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
	 * //.disableAllComponent(true);
	 * 
	 * //end // } //commented by raja on 06-03-2017 for ZBILQC-1719062�
	 * //compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
	 * //.disableAllComponent(true); //end
	 * 
	 * End
	 * 
	 * //Added by Janani on 30-05-2017 for ZBILQC-1719062�
	 * 
	 * 
	 * param_type_Cust = CustomerPanelsaving();
	 * 
	 * System.out.println("param_type_Cust in assured panel             :"
	 * +param_type_Cust);
	 * 
	 * if(param_type_Cust==1) {
	 * 
	 * System.out.println("enters into param_type_Cust==1");
	 * 
	 * if ("A".equalsIgnoreCase(PT_IL_POLICY_BEAN .getPOL_APPRV_STATUS()) ||
	 * "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN .getPOL_FRZ_FLAG())) {
	 * 
	 * compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
	 * .disableAllComponent(true);
	 * 
	 * }
	 * 
	 * }else { //Added by raja on 06-03-2017 for ZBILQC-1719062
	 * compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
	 * .disableAllComponent(true); //end
	 * 
	 * }
	 * 
	 * //End
	 * 
	 * } else { compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
	 * .setPM_IL_CONTRACTOR_QE_BEAN(new PM_IL_CONTRACTOR_QE());
	 * assuredHelper.when_create_record(compositeAction
	 * .getPM_IL_CONTRACTOR_ACTION_QE_BEAN() .getPM_IL_CONTRACTOR_QE_BEAN());
	 * compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
	 * .disableAllComponent(false); }
	 * compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
	 * .getCOMP_REPORT_MODAL_PANEL_CUSTOMER().setShowWhenRendered( false);
	 * 
	 * //commented by Ameen on 02-03-2018 to show Assured screen for every
	 * project //compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
	 * //.getCOMP_REPORT_MODAL_PANEL_ASSURED().setShowWhenRendered( //true);
	 * 
	 * outcome = "assredScreen";
	 * 
	 * compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
	 * .resetAllComponent(); } catch (Exception e) {
	 * compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
	 * .getCOMP_REPORT_MODAL_PANEL_ASSURED().setShowWhenRendered( false);
	 * e.printStackTrace();
	 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * e.getMessage()); getErrorMap().put("AssuredModalPanel", e.getMessage());
	 * } return outcome; }
	 *
	 * 
	 * End
	 *
	 */

	/* Modified by Janani on 24.03.2018 for KIC */
	/*
	 * public String assuredModalPanel() {
	 * 
	 * Added by Janani on 30-05-2017 for ZBILQC-1719062�
	 * 
	 * int param_type_Cust = 0;
	 * 
	 * End OUTCOME HANDLED BY aMEEN ON 26-02-2018 FOR KIC String outcome = "";
	 * eND
	 * 
	 * try { PM_IL_CONTRACTOR_HELPER_QE assuredHelper = compositeAction
	 * .getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getHelper();
	 * PM_IL_CONTRACTOR_DELEGATE_QE assuredDelegate = compositeAction
	 * .getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getDelegate();
	 * CommonUtils.setGlobalVariable("CALL_FORM_FOR_CUST", "PILT002_APAC");
	 * 
	 * compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
	 * .setPM_IL_CONTRACTOR_QE_BEAN(new PM_IL_CONTRACTOR_QE());
	 * assuredHelper.when_create_record(compositeAction
	 * .getPM_IL_CONTRACTOR_ACTION_QE_BEAN() .getPM_IL_CONTRACTOR_QE_BEAN());
	 * 
	 * Newly Added By Dhinesh on 16-04-2018 if(PT_IL_POLICY_BEAN.getROWID() ==
	 * null) { compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
	 * .disableAllComponent(false); }else {
	 * compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
	 * .disableAllComponent(true); } End
	 * 
	 * compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
	 * .getCOMP_REPORT_MODAL_PANEL_CUSTOMER().setShowWhenRendered( false);
	 * 
	 * if(PT_IL_POLICY_BEAN.getUI_POL_FRZ_FLAG()!=null &&
	 * PT_IL_POLICY_BEAN.getUI_POL_FRZ_FLAG().equalsIgnoreCase("Y")) {
	 * compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().disableAllComponent(
	 * true); //
	 * compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().resetAllComponent();
	 * }else {
	 * compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().disableAllComponent(
	 * false); }
	 * 
	 * outcome = "assredScreen";
	 * 
	 * compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
	 * .resetAllComponent(); } catch (Exception e) {
	 * compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
	 * .getCOMP_REPORT_MODAL_PANEL_ASSURED().setShowWhenRendered( false);
	 * e.printStackTrace();
	 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * e.getMessage()); getErrorMap().put("AssuredModalPanel", e.getMessage());
	 * } return outcome; }
	 */

	/* End */

	public String assuredModalPanel() {
		int param_type_Cust = 0;
		String outcome = "";
		/* added by Ameen on 26-04-2018 for KIC customer and assured same */
		compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().setCustAssured("A");
		compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_HEADER_LABEL()
				.setValue(Messages.getString(
						CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE") + "messageProperties_PM006_QE",
						"PM006_A_APAC$PM_CUSTOMER_QE$DISPLAY_ASSURED$caption"));
		/* End */
		try {
			PM006_QE_CUSTOMER_HELPER custHelper = compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getHelper();
			PM006_QE_CUSTOMER_DELEGATE custDelegate = compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getDelegate();
			CommonUtils.setGlobalVariable("CALL_FORM_FOR_CUST", "PILT002_APAC");
			if (PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2() != null && !"".equals(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2())
					&& (!PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2()
							.equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1())
							|| null != PT_IL_POLICY_BEAN.getPOL_SYS_ID())) {

				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN()
						.setCUST_REF_ID2(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2());
				custDelegate.executeQuery(compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN());

				/*
				 * modified by Ameen to change the sys. param. to enable/diasble
				 * cust. creation fields as per Kuzhandhai sir sugg.
				 * param_type_Cust = CustomerPanelsaving();
				 */

				param_type_Cust = ((BigDecimal) CommonUtils.getPPSystemParameterValue("IL_CUST_FLDS")).intValue();

				System.out.println("param_type_Cust in customer  panel             :" + param_type_Cust);

				if (param_type_Cust == 1) {

					System.out.println("enters into param_type_Cust==1");

					if ("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())
							|| "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {

						compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().disableAllComponent(true);

					}
				} else if (param_type_Cust == 2) { /*
													 * else if condition handled
													 * by Ameen on 03-05-2018
													 * for KIC
													 */

					if ("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())
							&& "N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())
							&& PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() != null
							&& PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0) {
						compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().disableAllComponent(false);
					} else if ("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())
							|| "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
						compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().disableAllComponent(true);
					}
				} else {

					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().disableAllComponent(true);

				}

				/* Added by Ameen on 09-05-2018 for disabling name fields */
				if ((PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() != null && PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() > 0)
						|| "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_FIRST_NAME().setDisabled(true);
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_SURNAME().setDisabled(true);
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_MIDDLE_NAME().setDisabled(true);
				} else {
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_FIRST_NAME().setDisabled(false);
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_SURNAME().setDisabled(false);
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_MIDDLE_NAME().setDisabled(false);
				}
				/* End */

			} else {
				System.out.println("ELSE BLOCK");
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().setPM006_QE_CUSTOMER_BEAN(new PM006_QE_CUSTOMER());
				System.out.println("LINE 12439 ");
				custHelper.when_create_record(
						compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN());
				System.out.println("LINE 12443 ");
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().disableAllComponent(false);

				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN()
						.setCUST_CLASS(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_20"));
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN()
						.setUI_M_CUST_CCLAS_DESC("Individuals");
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_RESIDENCE().setSelected(true);
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN().setCOMM_ADDRS("H");

				/*
				 * Added by Ameen on 19-04-2018 for KIC to default nationality
				 * as per Vijay sugg.
				 */
				ResultSet nationRS = new CRUDHandler().executeSelectStatement(
						"SELECT PC_CODE FROM  PM_CODES  WHERE  PC_TYPE  = 'NATLITY'  AND PC_VALUE  = 1 ",
						CommonUtils.getConnection());
				if (nationRS.next()) {
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN()
							.setCUST_NATIONALITY_CODE(nationRS.getString("PC_CODE"));
				}
				String nationalityDesc = P_VAL_CODES.P_VAL_CODES(CommonUtils.getConnection(), "NATLITY", compositeAction
						.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN().getCUST_NATIONALITY_CODE(), "N",
						"N");
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN()
						.setUI_M_CUST_NATIONALITY_CODE_DESC(nationalityDesc);
				/* End */

				/*
				 * if(compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().
				 * getPM006_QE_CUSTOMER_BEAN().getCUST_REF_ID1() != null){
				 * CommonUtils.setGlobalVariable("GLOBAL.REFID2",
				 * compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().
				 * getPM006_QE_CUSTOMER_BEAN().getCUST_REF_ID1());
				 * CommonUtils.setGlobalVariable("GLOBAL.FLAGCUST", "TRUE"); }
				 */
			}

			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_REPORT_MODAL_PANEL_ASSURED()
					.setShowWhenRendered(false);

			outcome = "custCreation";

			compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().resetAllComponents();
		} catch (Exception e) {
			compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_REPORT_MODAL_PANEL_CUSTOMER()
					.setShowWhenRendered(false);
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("customerModalPanel", e.getMessage());
		}
		return outcome;
	}

	public HtmlSelectOneMenu getCOMP_POL_FLEX_14() {
		return COMP_POL_FLEX_14;
	}

	public void setCOMP_POL_FLEX_14(HtmlSelectOneMenu comp_pol_flex_14) {
		COMP_POL_FLEX_14 = comp_pol_flex_14;
	}

	public HtmlSelectOneMenu getCOMP_POL_FLEX_09() {
		return COMP_POL_FLEX_09;
	}

	public void setCOMP_POL_FLEX_09(HtmlSelectOneMenu comp_pol_flex_09) {
		COMP_POL_FLEX_09 = comp_pol_flex_09;
	}

	public HtmlSelectOneMenu getCOMP_POL_ESC_YN() {
		return COMP_POL_ESC_YN;
	}

	public void setCOMP_POL_ESC_YN(HtmlSelectOneMenu comp_pol_esc_yn) {
		COMP_POL_ESC_YN = comp_pol_esc_yn;
	}

	public HtmlInputText getCOMP_POL_ESC_PERCENTAGE() {
		return COMP_POL_ESC_PERCENTAGE;
	}

	public void setCOMP_POL_ESC_PERCENTAGE(HtmlInputText comp_pol_esc_percentage) {
		COMP_POL_ESC_PERCENTAGE = comp_pol_esc_percentage;
	}

	public HtmlInputText getCOMP_POL_FLEX_08() {
		return COMP_POL_FLEX_08;
	}

	public void setCOMP_POL_FLEX_08(HtmlInputText comp_pol_flex_08) {
		COMP_POL_FLEX_08 = comp_pol_flex_08;
	}

	public HtmlSelectOneMenu getCOMP_POL_CVR_ESC_PERC() {
		return COMP_POL_CVR_ESC_PERC;
	}

	public void setCOMP_POL_CVR_ESC_PERC(HtmlSelectOneMenu comp_pol_cvr_esc_perc) {
		COMP_POL_CVR_ESC_PERC = comp_pol_cvr_esc_perc;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_14_LABEL() {
		return COMP_POL_FLEX_14_LABEL;
	}

	public void setCOMP_POL_FLEX_14_LABEL(HtmlOutputLabel comp_pol_flex_14_label) {
		COMP_POL_FLEX_14_LABEL = comp_pol_flex_14_label;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_09_LABEL() {
		return COMP_POL_FLEX_09_LABEL;
	}

	public void setCOMP_POL_FLEX_09_LABEL(HtmlOutputLabel comp_pol_flex_09_label) {
		COMP_POL_FLEX_09_LABEL = comp_pol_flex_09_label;
	}

	public HtmlOutputLabel getCOMP_POL_ESC_YN_LABEL() {
		return COMP_POL_ESC_YN_LABEL;
	}

	public void setCOMP_POL_ESC_YN_LABEL(HtmlOutputLabel comp_pol_esc_yn_label) {
		COMP_POL_ESC_YN_LABEL = comp_pol_esc_yn_label;
	}

	public HtmlOutputLabel getCOMP_POL_ESC_PERCENTAGE_LABEL() {
		return COMP_POL_ESC_PERCENTAGE_LABEL;
	}

	public void setCOMP_POL_ESC_PERCENTAGE_LABEL(HtmlOutputLabel comp_pol_esc_percentage_label) {
		COMP_POL_ESC_PERCENTAGE_LABEL = comp_pol_esc_percentage_label;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_08_LABEL() {
		return COMP_POL_FLEX_08_LABEL;
	}

	public void setCOMP_POL_FLEX_08_LABEL(HtmlOutputLabel comp_pol_flex_08_label) {
		COMP_POL_FLEX_08_LABEL = comp_pol_flex_08_label;
	}

	public HtmlOutputLabel getCOMP_POL_CVR_ESC_PERC_LABEL() {
		return COMP_POL_CVR_ESC_PERC_LABEL;
	}

	public void setCOMP_POL_CVR_ESC_PERC_LABEL(HtmlOutputLabel comp_pol_cvr_esc_perc_label) {
		COMP_POL_CVR_ESC_PERC_LABEL = comp_pol_cvr_esc_perc_label;
	}

	public List<SelectItem> getListPOL_ESC_YN() {
		return listPOL_ESC_YN;
	}

	public void setListPOL_ESC_YN(List<SelectItem> listPOL_ESC_YN) {
		this.listPOL_ESC_YN = listPOL_ESC_YN;
	}

	public List<SelectItem> getListPOL_FLEX_14() {
		return listPOL_FLEX_14;
	}

	public void setListPOL_FLEX_14(List<SelectItem> listPOL_FLEX_14) {
		this.listPOL_FLEX_14 = listPOL_FLEX_14;
	}

	public List<SelectItem> getListPOL_CVR_ESC_PERC() {
		return listPOL_CVR_ESC_PERC;
	}

	public void setListPOL_CVR_ESC_PERC(List<SelectItem> listPOL_CVR_ESC_PERC) {
		this.listPOL_CVR_ESC_PERC = listPOL_CVR_ESC_PERC;
	}

	public List<SelectItem> getListPOL_FLEX_09() {
		return listPOL_FLEX_09;
	}

	public void setListPOL_FLEX_09(List<SelectItem> listPOL_FLEX_09) {
		this.listPOL_FLEX_09 = listPOL_FLEX_09;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_18_LABEL() {
		return COMP_POL_FLEX_18_LABEL;
	}

	public void setCOMP_POL_FLEX_18_LABEL(HtmlOutputLabel comp_pol_flex_18_label) {
		COMP_POL_FLEX_18_LABEL = comp_pol_flex_18_label;
	}

	public HtmlInputText getCOMP_POL_FLEX_18() {
		return COMP_POL_FLEX_18;
	}

	public void setCOMP_POL_FLEX_18(HtmlInputText comp_pol_flex_18) {
		COMP_POL_FLEX_18 = comp_pol_flex_18;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DOCUMENTS() {
		return COMP_UI_M_BUT_DOCUMENTS;
	}

	public void setCOMP_UI_M_BUT_DOCUMENTS(HtmlCommandButton comp_ui_m_but_documents) {
		COMP_UI_M_BUT_DOCUMENTS = comp_ui_m_but_documents;
	}

	public List<SelectItem> getListPOL_STD_SUBSTD() {
		return listPOL_STD_SUBSTD;
	}

	public void setListPOL_STD_SUBSTD(List<SelectItem> listPOL_STD_SUBSTD) {
		this.listPOL_STD_SUBSTD = listPOL_STD_SUBSTD;
	}

	// <<<<<<< PT_IL_POLICY_ACTION.java

	public HtmlOutputLabel getCOMP_POL_STD_SUBSTD_LABEL() {
		return COMP_POL_STD_SUBSTD_LABEL;
	}

	public void setCOMP_POL_STD_SUBSTD_LABEL(HtmlOutputLabel comp_pol_std_substd_label) {
		COMP_POL_STD_SUBSTD_LABEL = comp_pol_std_substd_label;
	}

	public HtmlSelectOneMenu getCOMP_POL_STD_SUBSTD() {
		return COMP_POL_STD_SUBSTD;
	}

	public void setCOMP_POL_STD_SUBSTD(HtmlSelectOneMenu comp_pol_std_substd) {
		COMP_POL_STD_SUBSTD = comp_pol_std_substd;
	}

	public List<SelectItem> getListPOL_STND_SUB() {
		return listPOL_STND_SUB;
	}

	public void setListPOL_STND_SUB(List<SelectItem> listPOL_STND_SUB) {
		this.listPOL_STND_SUB = listPOL_STND_SUB;
	}

	public void callReportModalPanel(ActionEvent event) {
		String input = event.getComponent().getId();
		runAction();
		try {
			if ("UI_M_ENDT_LETTER".equals(input)) {
				IP_REP_INFO IP_REP_INFO_BEAN = new IP_REP_INFO();
				IP_REP_INFO_BEAN.setSelectedFileType("PDF");
				HttpServletResponse response = null;
				String redirectUrl = null;
				Map<String, String> map = new HashMap<String, String>();
				if (IP_REP_INFO_BEAN.getSelectedFileType() != null) {

					if (IP_REP_INFO_BEAN.getROWID() == null) {
						IP_REP_INFO_BEAN.setREP_VALUE_1(String.valueOf(PT_IL_POLICY_BEAN.getPOL_SYS_ID()));

						IP_REP_INFO_BEAN.setREP_ID("RICBL_SCH_19");
						IP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
						new CRUDHandler().executeInsert(IP_REP_INFO_BEAN, CommonUtils.getConnection());
						CommonUtils.getConnection().commit();
					}
					map.put("P_COMP_CODE", CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"));
					response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
							.getResponse();
					redirectUrl = ReportUtils.getReportRedirectString(IP_REP_INFO_BEAN.getREP_KEY_NO(),
							IP_REP_INFO_BEAN.getREP_ID(), IP_REP_INFO_BEAN.getREP_ID(),
							IP_REP_INFO_BEAN.getSelectedFileType(), map);
					setRedirectUrl(redirectUrl);
				}
			} else {
				String dmsUrl = new DMSUtil().getDmsUrl();
				System.out.println("PT_IL_POLICY_ACTION.invokeDMS()" + dmsUrl);
				setRedirectUrl(dmsUrl);
			}

			if (getRedirectUrl() != null) {
				getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
			} else {
				getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Added By Srinivas J
	public String runAction() {
		System.out.println("PT_IL_POLICY_ACTION.invokeDMS()");
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";

	}

	public void enableDisableRSA() throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String query = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ? ";
		String planType = null;
		try {
			connection = CommonUtils.getConnection();
			System.out.println("PT_IL_POLICY_BEAN.getPOL_PLAN_CODE()          " + PT_IL_POLICY_BEAN.getPOL_PLAN_CODE());
			resultSet = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
			if (resultSet.next()) {
				planType = resultSet.getString(1);
			}
			if ("M".equals(planType)) {
				compositeAction.getPT_IL_POL_RED_SA_ACTION_BEAN().getCOMP_UI_M_BUT_RD_SA1().setRendered(true);
				System.out.println("RSA----->" + planType);
			} else {
				compositeAction.getPT_IL_POL_RED_SA_ACTION_BEAN().getCOMP_UI_M_BUT_RD_SA1().setRendered(false);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

	}

	public HtmlOutputLabel getCOMP_POL_MICR_CODE_LABEL() {
		return COMP_POL_MICR_CODE_LABEL;
	}

	public void setCOMP_POL_MICR_CODE_LABEL(HtmlOutputLabel comp_pol_micr_code_label) {
		COMP_POL_MICR_CODE_LABEL = comp_pol_micr_code_label;
	}

	public HtmlInputText getCOMP_POL_MICR_CODE() {
		return COMP_POL_MICR_CODE;
	}

	public void setCOMP_POL_MICR_CODE(HtmlInputText comp_pol_micr_code) {
		COMP_POL_MICR_CODE = comp_pol_micr_code;
	}

	public HtmlOutputLabel getCOMP_POL_CUST_BANK_CODE_LABEL() {
		return COMP_POL_CUST_BANK_CODE_LABEL;
	}

	public void setCOMP_POL_CUST_BANK_CODE_LABEL(HtmlOutputLabel comp_pol_cust_bank_code_label) {
		COMP_POL_CUST_BANK_CODE_LABEL = comp_pol_cust_bank_code_label;
	}

	public HtmlInputText getCOMP_POL_CUST_BANK_CODE() {
		return COMP_POL_CUST_BANK_CODE;
	}

	public void setCOMP_POL_CUST_BANK_CODE(HtmlInputText comp_pol_cust_bank_code) {
		COMP_POL_CUST_BANK_CODE = comp_pol_cust_bank_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_CITY_CODE_LABEL() {
		return COMP_UI_M_CITY_CODE_LABEL;
	}

	public void setCOMP_UI_M_CITY_CODE_LABEL(HtmlOutputLabel comp_ui_m_city_code_label) {
		COMP_UI_M_CITY_CODE_LABEL = comp_ui_m_city_code_label;
	}

	public HtmlInputText getCOMP_UI_M_CITY_CODE() {
		return COMP_UI_M_CITY_CODE;
	}

	public void setCOMP_UI_M_CITY_CODE(HtmlInputText comp_ui_m_city_code) {
		COMP_UI_M_CITY_CODE = comp_ui_m_city_code;
	}

	public HtmlInputText getCOMP_UI_M_CITY_CODE_DESC() {
		return COMP_UI_M_CITY_CODE_DESC;
	}

	public void setCOMP_UI_M_CITY_CODE_DESC(HtmlInputText comp_ui_m_city_code_desc) {
		COMP_UI_M_CITY_CODE_DESC = comp_ui_m_city_code_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_BANK_CODE_LABEL() {
		return COMP_UI_M_BANK_CODE_LABEL;
	}

	public void setCOMP_UI_M_BANK_CODE_LABEL(HtmlOutputLabel comp_ui_m_bank_code_label) {
		COMP_UI_M_BANK_CODE_LABEL = comp_ui_m_bank_code_label;
	}

	public HtmlInputText getCOMP_UI_M_BANK_CODE() {
		return COMP_UI_M_BANK_CODE;
	}

	public void setCOMP_UI_M_BANK_CODE(HtmlInputText comp_ui_m_bank_code) {
		COMP_UI_M_BANK_CODE = comp_ui_m_bank_code;
	}

	public HtmlInputText getCOMP_UI_M_BANK_CODE_DESC_1() {
		return COMP_UI_M_BANK_CODE_DESC_1;
	}

	public void setCOMP_UI_M_BANK_CODE_DESC_1(HtmlInputText comp_ui_m_bank_code_desc_1) {
		COMP_UI_M_BANK_CODE_DESC_1 = comp_ui_m_bank_code_desc_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_BRANCH_CODE_LABEL() {
		return COMP_UI_M_BRANCH_CODE_LABEL;
	}

	public void setCOMP_UI_M_BRANCH_CODE_LABEL(HtmlOutputLabel comp_ui_m_branch_code_label) {
		COMP_UI_M_BRANCH_CODE_LABEL = comp_ui_m_branch_code_label;
	}

	public HtmlInputText getCOMP_UI_M_BRANCH_CODE() {
		return COMP_UI_M_BRANCH_CODE;
	}

	public void setCOMP_UI_M_BRANCH_CODE(HtmlInputText comp_ui_m_branch_code) {
		COMP_UI_M_BRANCH_CODE = comp_ui_m_branch_code;
	}

	public HtmlInputText getCOMP_UI_M_BRANCH_CODE_DESC_1() {
		return COMP_UI_M_BRANCH_CODE_DESC_1;
	}

	public void setCOMP_UI_M_BRANCH_CODE_DESC_1(HtmlInputText comp_ui_m_branch_code_desc_1) {
		COMP_UI_M_BRANCH_CODE_DESC_1 = comp_ui_m_branch_code_desc_1;
	}

	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POLICY_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POLICY_HELPER helper) {
		this.helper = helper;
	}
	// [ Added by vinoj as suggested by Akash

	public void chkMICRCode(Long micrCode) throws Exception {
		String query = "SELECT 'X' FROM PM_BANK_DTLS WHERE PMD_MICR_CODE = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[] { micrCode });
			if (resultSet.next()) {
				// return x
			} else {
				throw new Exception("Invalid MICR Code.");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

	}

	// [ADDED BY AKASH TO IMPLEMENT DIRECT DEBIT /CREDIT.

	String citycode = null;
	String bankcode = null;
	String branchcode = null;

	public void validateMICRCODE(FacesContext context, UIComponent component, Object value) {

		try {
			Long value_1 = (Long) value;
			chkMICRCode(value_1);
			PT_IL_POLICY_BEAN.setPOL_MICR_CODE(value_1);
			// getPW_PAYING_SLIP_DTLS_BEAN().setPSL_CHK_NO(value_1 );
			String str = String.valueOf(PT_IL_POLICY_BEAN.getPOL_MICR_CODE());
			System.out.println("------>" + str.length());
			if (str.length() > 9 || str.length() < 9) {
				throw new Exception("Enter valid MICR No.");
			}

			citycode = str.substring(0, 3);
			bankcode = str.substring(3, 6);
			branchcode = str.substring(6, 9);
			System.out.println("" + citycode);
			System.out.println("" + bankcode);
			System.out.println("" + branchcode);
			PT_IL_POLICY_BEAN.setUI_M_CITY_CODE(citycode);
			PT_IL_POLICY_BEAN.setUI_M_BANK_CODE(bankcode);
			PT_IL_POLICY_BEAN.setUI_M_BRANCH_CODE(branchcode);
			PT_IL_POLICY_BEAN.setUI_M_CITY_CODE_DESC(getCityDesc(citycode));
			PT_IL_POLICY_BEAN.setUI_M_BANK_CODE_DESC_1(getBankDesc(bankcode));
			PT_IL_POLICY_BEAN.setUI_M_BRANCH_CODE_DESC_1(getBranchDesc(branchcode, bankcode, citycode));

			COMP_UI_M_BANK_CODE.resetValue();
			COMP_UI_M_BANK_CODE_DESC.resetValue();
			COMP_UI_M_BRANCH_CODE.resetValue();
			COMP_UI_M_BRANCH_CODE_DESC.resetValue();
			COMP_UI_M_CITY_CODE.resetValue();
			COMP_UI_M_CITY_CODE_DESC.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void defaultMICRDetails() throws Exception {
		try {
			// Added by ganesh on 02-11-2017 to default branch names
			PT_IL_POLICY_BEAN.setUI_M_POL_BANK_DIVN_DESC(getBranchDesc());
			if (PT_IL_POLICY_BEAN.getPOL_MICR_CODE() != null) {
				String str = String.valueOf(PT_IL_POLICY_BEAN.getPOL_MICR_CODE());
				if (str.length() == 9) {
					citycode = str.substring(0, 3);
					bankcode = str.substring(3, 6);
					branchcode = str.substring(6, 9);

					PT_IL_POLICY_BEAN.setUI_M_CITY_CODE(citycode);
					PT_IL_POLICY_BEAN.setUI_M_BANK_CODE(bankcode);
					PT_IL_POLICY_BEAN.setUI_M_BRANCH_CODE(branchcode);
					PT_IL_POLICY_BEAN.setUI_M_CITY_CODE_DESC(getCityDesc(citycode));
					PT_IL_POLICY_BEAN.setUI_M_BANK_CODE_DESC_1(getBankDesc(bankcode));
					PT_IL_POLICY_BEAN.setUI_M_BRANCH_CODE_DESC_1(getBranchDesc(branchcode, bankcode, citycode));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public String getCityDesc(String cityCode) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String desc = null;
		String query = "SELECT PMD_CITY_DESC  FROM PM_BANK_DTLS WHERE PMD_CITY_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[] { cityCode });
			if (resultSet.next()) {
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}

	public String getBankDesc(String cityCode) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String desc = null;
		String query = "SELECT PMD_BANK_NAME  FROM PM_BANK_DTLS WHERE PMD_BANK_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[] { cityCode });
			if (resultSet.next()) {
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}

	public String getBranchDesc(String branchCode, String bank, String cityCode) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String desc = null;
		String query = "SELECT PMD_BRANCH_NAME  FROM PM_BANK_DTLS WHERE PMD_BRANCH_CODE = ?  "
				+ " AND PMD_BANK_CODE = ? AND PMD_CITY_CODE = ?  ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { branchCode, bank, cityCode });
			if (resultSet.next()) {
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}

	public boolean isEndorseIndxVisibleFlag() {
		return endorseIndxVisibleFlag;
	}

	public void setEndorseIndxVisibleFlag(boolean endorseIndxVisibleFlag) {
		this.endorseIndxVisibleFlag = endorseIndxVisibleFlag;
	}

	// [ADDED BY AKASH TO IMPLEMENT DIRECT DEBIT /CREDIT.]

	public void chkDthClaim(String polno) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String query = "SELECT 'X'  FROM   PT_IL_CLAIM WHERE " + " CLAIM_POL_NO = ?  AND    CLAIM_TYPE IN ('A','D')"
				+ "AND NVL(CLAIM_MEMB_CODE,CLAIM_ASSR_CODE) = NVL(CLAIM_ASSR_CODE,'XXX')";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[] { polno });
			if (resultSet.next()) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT().setDisabled(true);
			}
			/*
			 * 
			 * Commented By Dhinesh on 19-9-2017 for ssp call id :
			 * ZBILQC-1737294 Point No : 2
			 * 
			 * else {
			 * compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT()
			 * .setDisabled(false); }
			 */
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

	}

	private HtmlCommandLink COMP_UI_M_ENDT_LETTER;

	public HtmlCommandLink getCOMP_UI_M_ENDT_LETTER() {
		return COMP_UI_M_ENDT_LETTER;
	}

	public void setCOMP_UI_M_ENDT_LETTER(HtmlCommandLink comp_ui_m_endt_letter) {
		COMP_UI_M_ENDT_LETTER = comp_ui_m_endt_letter;
	}

	public Boolean getChkFlag() {
		return chkFlag;
	}

	public void setChkFlag(Boolean chkFlag) {
		this.chkFlag = chkFlag;
	}

	public void chkSumAssured() throws Exception {
		try {
			helper.POL_FC_SUM_ASSURED_WHEN_VALIDATE_ITEM(compositeAction, PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED());
			if (PT_IL_POLICY_BEAN.getPOL_SRC_OF_BUS() == null) {
				throw new Exception("Source of Business Value is Required");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public HtmlCommandLink getCOMP_SAVE_COMMAND_LINK() {
		return COMP_SAVE_COMMAND_LINK;
	}

	public void setCOMP_SAVE_COMMAND_LINK(HtmlCommandLink comp_save_command_link) {
		COMP_SAVE_COMMAND_LINK = comp_save_command_link;
	}

	public HtmlCommandButton getCOMP_SAVE_BUTTON() {
		return COMP_SAVE_BUTTON;
	}

	public void setCOMP_SAVE_BUTTON(HtmlCommandButton comp_save_button) {
		COMP_SAVE_BUTTON = comp_save_button;
	}

	public HtmlCommandLink getCOMP_SAVE_COMMAND_LINK2() {
		return COMP_SAVE_COMMAND_LINK2;
	}

	public void setCOMP_SAVE_COMMAND_LINK2(HtmlCommandLink comp_save_command_link2) {
		COMP_SAVE_COMMAND_LINK2 = comp_save_command_link2;
	}

	public HtmlCommandButton getCOMP_SAVE_BUTTON2() {
		return COMP_SAVE_BUTTON2;
	}

	public void setCOMP_SAVE_BUTTON2(HtmlCommandButton comp_save_button2) {
		COMP_SAVE_BUTTON2 = comp_save_button2;
	}

	public HtmlTab getCOMP_MORE_INFO_4() {
		return COMP_MORE_INFO_4;
	}

	public void setCOMP_MORE_INFO_4(HtmlTab comp_more_info_4) {
		COMP_MORE_INFO_4 = comp_more_info_4;
	}

	public void chkpropconvert(String pol_no) throws Exception {
		Connection connection = null;
		ResultSet res = null;
		String query = "SELECT POL_CONVERT_YN FROM PT_IL_POLICY WHERE POL_NO = ? ";
		String convert_YN = null;
		try {
			connection = CommonUtils.getConnection();
			res = new CRUDHandler().executeSelectStatement(query, connection, new Object[] { pol_no });

			if (res.next()) {
				convert_YN = res.getString(1);
			}
			if ("Y".equalsIgnoreCase(CommonUtils.nvl(convert_YN, "N"))) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setRendered(false);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CONVERT().setRendered(true);
			}
			PT_IL_POLICY_BEAN.setPOL_CONVERT_YN(convert_YN);
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(res);

		}

	}

	public HtmlCommandButton getCOMP_BACK_BUTTON() {
		return COMP_BACK_BUTTON;
	}

	public void setCOMP_BACK_BUTTON(HtmlCommandButton comp_back_button) {
		COMP_BACK_BUTTON = comp_back_button;
	}

	public void fetchMethodOfCollection(String pymt_mode) {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			if ("S".equalsIgnoreCase(pymt_mode)) {
				setListPOL_PYMT_TYPE(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
						"PT_IL_POLICY.POL_PYMT_TYPE_SINGLE", "IL_PAY_MODES"));
				COMP_POL_EMPLOYER_CODE.setDisabled(true);
			} else {
				/*
				 * modified by Ameen on 12-10-2017 as per Chandramohan said
				 * setListPOL_PYMT_TYPE(ListItemUtil.getDropDownListValue(
				 * connection, "PILT002_APAC", "PT_IL_POLICY",
				 * "PT_IL_POLICY.POL_PYMT_TYPE", "IL_PAY_MODE"));
				 */
				setListPOL_PYMT_TYPE(ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", "PT_IL_POLICY",
						"PT_IL_POLICY.POL_PYMT_TYPE", "IL_POL_PAY"));
				/*
				 * Commentted by saritha on 14-Jun-2017 for ssp call id
				 * ZBILQC-1720514
				 */
				// COMP_POL_EMPLOYER_CODE.setDisabled(false);
				/* End */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disableButtons() {
		String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
		String claimCallingForm = CommonUtils.getGlobalVariable("CLAIM_CALLING_FORM");
		if (claimCallingForm != null && callingForm != null) {
			if (claimCallingForm.equalsIgnoreCase("PILT006_APAC") && callingForm.equalsIgnoreCase("PILT006_APAC")) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_BUT_COPY().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_ENDT().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(true);
			}
		}
	}

	public void alterInTerm() {
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		if ("012".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(), "000"))
				&& "A".equalsIgnoreCase(pt_il_policy_bean.getPOL_APPRV_STATUS())) {
			if (pt_il_policy_bean.getPOL_PERIOD() != 0) {
				Date polFromDt = pt_il_policy_bean.getPOL_START_DT();
				Integer polPeriod = pt_il_policy_bean.getPOL_PERIOD();
				Date polExpiryDate = null;
				String Query = "SELECT ADD_MONTHS(?,?*12)-1 FROM DUAL";
				ResultSet resultSet = null;
				try {
					Connection connection = CommonUtils.getConnection();
					resultSet = new CRUDHandler().executeSelectStatement(Query, connection,
							new Object[] { polFromDt, polPeriod });
					if (resultSet.next()) {
						polExpiryDate = resultSet.getDate(1);
					}
					if (polExpiryDate.equals(pt_il_policy_bean.getPOL_EXPIRY_DT())) {
						// do nothing
					} else {
						pt_il_policy_bean.setPOL_EXPIRY_DT(polExpiryDate);
						pt_il_policy_bean.setPOL_LAST_INST_DT(polExpiryDate);
						CommonUtils.doComitt();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						CommonUtils.closeCursor(resultSet);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void END_001changes() {
		if ("001".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000"))
				&& "N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())) {
			COMP_POL_ASSRD_REF_ID2.setDisabled(true);
			COMP_UI_M_BUT_COPY.setDisabled(true);
			COMP_POL_PLAN_CODE.setDisabled(true);
			COMP_POL_NO_YRS_PREM_PAID.setDisabled(true);
			COMP_UI_M_MAT_AGE.setDisabled(true);
			COMP_POL_STD_SUBSTD.setDisabled(true);
			// COMP_UI_M_POL_CUST_DESC.setDisabled(false);

			if (!"Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
				COMP_POL_ASSURED_NAME.setDisabled(false);
			}

			/*
			 * Modified by Janani on 27.06.2018 for FLA as per Chandramohan
			 * sugges
			 */
			// if("AD".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE()) ||
			// "S".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE()))

			if ("AD".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE())
					|| "S".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE())
					|| "AO".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE()))
			/* ENd */
			{
				COMP_POL_EMPLOYER_CODE.setDisabled(false);
			} else {
				COMP_POL_EMPLOYER_CODE.setDisabled(true);
			}
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(true);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(true);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_HOLD().setDisabled(true);
			/*
			 * if(PT_IL_POLICY_BEAN.getUI_M_POL_CUST_DESC() != null){
			 * getPT_IL_POLICY_BEAN().setUI_M_POL_CUST_DESC(PT_IL_POLICY_BEAN.
			 * getUI_M_POL_CUST_DESC()); } else{
			 * getPT_IL_POLICY_BEAN().setUI_M_POL_CUST_DESC(PT_IL_POLICY_BEAN.
			 * getPOL_ASSURED_NAME()); }
			 */
		}
		/*
		 * else{ COMP_UI_M_POL_CUST_DESC.setDisabled(true); }
		 */

	}
	/* Added By Saritha on 3.3.2016 for EMail id field Addition(Start) */

	private HtmlInputText COMP_POL_RES_EMAIL_ID;

	private HtmlOutputLabel COMP_POL_RES_EMAIL_ID_LABEL;

	public HtmlInputText getCOMP_POL_RES_EMAIL_ID() {
		return COMP_POL_RES_EMAIL_ID;
	}

	public void setCOMP_POL_RES_EMAIL_ID(HtmlInputText cOMP_POL_RES_EMAIL_ID) {
		COMP_POL_RES_EMAIL_ID = cOMP_POL_RES_EMAIL_ID;
	}

	public HtmlOutputLabel getCOMP_POL_RES_EMAIL_ID_LABEL() {
		return COMP_POL_RES_EMAIL_ID_LABEL;
	}

	public void setCOMP_POL_RES_EMAIL_ID_LABEL(HtmlOutputLabel cOMP_POL_RES_EMAIL_ID_LABEL) {
		COMP_POL_RES_EMAIL_ID_LABEL = cOMP_POL_RES_EMAIL_ID_LABEL;
	}

	public void emailId(ActionEvent event) {
		System.out.println("Ënter EmailID");
		UIInput input = (UIInput) event.getComponent().getParent();
		System.out.println((String) input.getSubmittedValue());
		System.out.println("PT_IL_POLICY_BEAN " + PT_IL_POLICY_BEAN);

		PT_IL_POLICY_BEAN.setPOL_RES_EMAIL_ID((String) input.getSubmittedValue());
		System.out.println("Email value onChange  " + PT_IL_POLICY_BEAN.getPOL_RES_EMAIL_ID());
		// ErrorHelpUtil.validate(input, getErrorMap());

	}
	/* End */

	/* ADDED BY GOPI FOR ENDORSEMENT SLIP */
	public void addcontent(ActionEvent actionEvent) {
		/* added by raja on 22-08-2017 for mop endorsement */
		System.out.println("*********ENTERING INTO addcontent************** ");
		CommonUtils.clearMaps(this);
		/* end */
		sb.delete(0, sb.length());
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		System.out.println((String) input.getSubmittedValue());
		String des = (String) input.getSubmittedValue();
		System.out.println("lenght (String)input.getSubmittedValue()  : " + des.length());
		sb.append((String) input.getSubmittedValue());
		PT_IL_POLICY_BEAN.setPOL_END_DESC(sb.toString());
		System.out.println("*******************value of addcontent------------------------>"
				+ PT_IL_POLICY_BEAN.getPOL_END_DESC());
	}

	/* END */

	/* added by R. Raja for add EMR Rate field */

	public void validatePOL_EMR_RATE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_EMR_RATE((Double) value);
			// COMP_POL_WAQAF_PERIOD_FM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_EMR_RATE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private HtmlInputText COMP_POL_EMR_RATE;

	private HtmlOutputLabel COMP_POL_EMR_RATE_LABEL;

	public HtmlInputText getCOMP_POL_EMR_RATE() {
		return COMP_POL_EMR_RATE;
	}

	public void setCOMP_POL_EMR_RATE(HtmlInputText cOMP_POL_EMR_RATE) {
		COMP_POL_EMR_RATE = cOMP_POL_EMR_RATE;
	}

	public HtmlOutputLabel getCOMP_POL_EMR_RATE_LABEL() {
		return COMP_POL_EMR_RATE_LABEL;
	}

	public void setCOMP_POL_EMR_RATE_LABEL(HtmlOutputLabel cOMP_POL_EMR_RATE_LABEL) {
		COMP_POL_EMR_RATE_LABEL = cOMP_POL_EMR_RATE_LABEL;
	}

	/* End */

	/* Endorsement SSP Call id FALCONQC-1714638 on 29-07-2016 */

	public void validatemethod() throws Exception {
		if (PT_IL_POLICY_BEAN.getPOL_END_DESC() == null) {
			System.out.println("inside validate function");
			ResultSet resultSet = null;
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			String pol_end_code = PT_IL_POLICY_BEAN.getPOL_END_CODE();
			String End_Desc = "SELECT DS_END_REASON FROM PM_IL_DOC_SETUP WHERE DS_TYPE='3'AND DS_CODE ='" + pol_end_code
					+ "'";
			/*
			 * String
			 * End_Desc="SELECT DS_END_REASON FROM PM_IL_DOC_SETUP WHERE DS_TYPE = '3' AND DS_CODE = ?"
			 * ;
			 */
			System.out.println("End Description Query--------------------->" + End_Desc);
			resultSet = handler.executeSelectStatement(End_Desc, connection);
			if (resultSet.next()) {
				PT_IL_POLICY_BEAN.setPOL_END_DESC(resultSet.getString("DS_END_REASON"));
				System.out.println("value-->" + PT_IL_POLICY_BEAN.getPOL_END_DESC());
			}
			// connection.close();
		}
	}

	// ADDED BY SARANYA
	public ArrayList<LovBean> lovUI_M_BANK_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POLICY";
		String fieldName = "POL_BANK_CODE";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, null, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> lovUI_M_BRANCH_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_BNF_TYPE";
		Object param1 = "ILBENFTYPE";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null, null, null, null,
					currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> lovUI_M_CITY_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_CITY_CODE";
		Object param1 = "CITY";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null, null, null, null,
					currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	// END

	// Added By Ameen 12.9.2016 for ssp call id : FALCONQC-1714579 ---�START
	// ----
	public void validateUI_M_POL_CUST_DESC(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			String code = (String) value;
			PT_IL_POLICY_BEAN.setUI_M_POL_CUST_DESC(code);
			System.out.println("validateUI_M_POL_CUST_DESC code==>>" + code);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void validatePOL_ASSURED_NAME(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			String code = (String) value;
			PT_IL_POLICY_BEAN.setPOL_ASSURED_NAME(code);
			System.out.println("validatePOL_ASSURED_NAME code==>>" + code);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	// public void IL_BLOCK_POL_DISABLED(
	public void END_FIELD_DISABLED(String polStatus, String frzFlag, String endType) throws Exception {
		System.out.println("enter into endorment disable method ******");
		PILT002_APAC_LOCAL_PROCEDURES disbaleFields = new PILT002_APAC_LOCAL_PROCEDURES();
		if (polStatus.equalsIgnoreCase("E") && frzFlag.equalsIgnoreCase("N")) {

			if (endType.equalsIgnoreCase("GEN001")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				COMP_POL_ASSURED_NAME.setDisabled(false);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				COMP_POL_FRZ_FLAG.setDisabled(false);
			}
			if (endType.equalsIgnoreCase("GEN002") || endType.equalsIgnoreCase("GEN003")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().disableAllComponent(false);
				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().setUPDATE_ALLOWED(true);
				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().setDELETE_ALLOWED(true);
				COMP_POL_FRZ_FLAG.setDisabled(false);
			}

			/* changed by R.Raja on 24-01-2017 for */
			if (endType.equalsIgnoreCase("GEN004")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				COMP_POL_FRZ_FLAG.setDisabled(false);
				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().disableAllComponent(false);
				/*
				 * compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().
				 * getCOMP_UI_M_BANK_CODE().setDisabled(false);
				 * compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().
				 * getCOMP_UI_M_BRANCH_CODE().setDisabled(false);
				 */
				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().setUPDATE_ALLOWED(true);
				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().setDELETE_ALLOWED(true);

			}
			if (endType.equalsIgnoreCase("GEN005")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				COMP_POL_FRZ_FLAG.setDisabled(false);
				COMP_POL_RES_ADDRESS_1.setDisabled(false);
				COMP_POL_RES_AREA_CODE.setDisabled(false);
				COMP_POL_RES_ADDRESS_2.setDisabled(false);
				COMP_POL_CITY_CODE.setDisabled(false);
				COMP_POL_RES_ADDRESS_3.setDisabled(false);
				COMP_POL_STATE_CODE.setDisabled(false);
				COMP_POL_COUNT_CODE.setDisabled(false);
			}
			if (endType.equalsIgnoreCase("GEN006")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				COMP_POL_FRZ_FLAG.setDisabled(false);
				COMP_POL_RES_PHONE_NO.setDisabled(false);
				COMP_POL_MOBILE_NO.setDisabled(false);
			}
			if (endType.equalsIgnoreCase("GEN007")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				COMP_POL_FRZ_FLAG.setDisabled(false);
				COMP_POL_RES_EMAIL_ID.setDisabled(false);
			}
			if (endType.equalsIgnoreCase("ADDRIDER")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().disableAllComponent(false);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setUPDATE_ALLOWED(true);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setDELETE_ALLOWED(false);
				/*
				 * added by raja on 03-08-2017 for ZBILQC-1733034 &
				 * ZBILQC-1730978
				 */
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_TO_DT().setDisabled(true);
				/* end */
				COMP_POL_FRZ_FLAG.setDisabled(false);
			}
			/*
			 * 
			 * commented By Dhinesh on 25-05-2018
			 * 
			 * if(endType.equalsIgnoreCase("DELRIDER")){
			 * disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
			 * compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().
			 * disableAllComponent(false);
			 * compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().
			 * setUPDATE_ALLOWED(false);
			 * compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().
			 * setINSERT_ALLOWED(false);
			 * compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().
			 * setDELETE_ALLOWED(true); COMP_POL_FRZ_FLAG.setDisabled(false); }
			 */

			if (endType.equalsIgnoreCase("DELRIDER")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().disableAllComponent(true);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setUPDATE_ALLOWED(false);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setINSERT_ALLOWED(false);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setDELETE_ALLOWED(true);
				COMP_POL_FRZ_FLAG.setDisabled(false);
			}

			if ((endType.equalsIgnoreCase("INCSA") || endType.equalsIgnoreCase("DECSA"))) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				COMP_POL_FRZ_FLAG.setDisabled(false);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				COMP_POL_FC_SUM_ASSURED.setDisabled(false);

				/* added by raja on 28-06-2017 for discussed with ajoy */
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getCOMP_PFMD_SA().setDisabled(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setINSERT_ALLOWED(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setDELETE_ALLOWED(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setUPDATE_ALLOWED(true);
				/* end */
			}

			/* Added by ganesh on 30-11-2017 as suggested by ajoy */
			if ((endType.equalsIgnoreCase("INCPREM") || endType.equalsIgnoreCase("DECPREM"))) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				COMP_POL_FRZ_FLAG.setDisabled(false);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				/* Modified by ganesh on 05-02-2018 as suggested by ajoy */
				String premCalcType = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_UL_PREM_CALC();
				if ("A".equalsIgnoreCase(premCalcType)) { // Premium From
															// benefit
					if ("U".equalsIgnoreCase(getPLAN_TYPE()) && "EDU".equalsIgnoreCase(getUnit_link_typ())) {
						COMP_POL_ANN_BNF_AMT.setDisabled(false);
					}

				} else if ("D".equalsIgnoreCase(premCalcType) || "N".equalsIgnoreCase(premCalcType)) {
					COMP_POL_FC_MODAL_PREM.setDisabled(false);
				}
				// COMP_POL_FC_MODAL_PREM.setDisabled(false);
				/* end */
			}
			/* end */
			/*
			 * Commentted &Modified by saritha on 27-11-2017 for adding INCTERM
			 * & DECTERM as suggested by Ajoy sir
			 */
			/* if(endType.equalsIgnoreCase("ALTERM")){ */

			if (endType.equalsIgnoreCase("ALTERM") || endType.equalsIgnoreCase("INCTERM")
					|| endType.equalsIgnoreCase("DECTERM")) {

				/* End */

				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				// COMP_POL_FRZ_FLAG.setDisabled(false);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				COMP_POL_PERIOD.setDisabled(false);
				COMP_POL_PREM_PAY_YRS.setDisabled(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().disableAllComponents(true);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setINSERT_ALLOWED(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setDELETE_ALLOWED(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setUPDATE_ALLOWED(false);

				/*
				 * Added by saritha on 17-05-2018 for In Incressing/Decreasing
				 * in Term Endorsement need to enable for Rider
				 */

				if (endType.equalsIgnoreCase("INCTERM") || endType.equalsIgnoreCase("DECTERM")) {

					compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setUPDATE_ALLOWED(false);
					compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_PERIOD().setDisabled(false);
				}

				/* End */

			}
			if (endType.equalsIgnoreCase("MOP")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				// COMP_POL_FRZ_FLAG.setDisabled(false);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				COMP_POL_MODE_OF_PYMT.setDisabled(false);
			}

			/* added by raja on 17-05-2017 for addition of dependant */

			/* added by raja on 28-06-2017 for discussed with ajoy */
			if (endType.equalsIgnoreCase("ADDDEP")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				// COMP_POL_FRZ_FLAG.setDisabled(false);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().disableAllComponents(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setDELETE_ALLOWED(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setUPDATE_ALLOWED(false);
				/*
				 * Added by ganesh as suggested on 06-10-2017 as suggestd by
				 * thiags from onsite
				 */
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().setUPDATE_ALLOWED(true);
				/* end */
			}

			if (endType.equalsIgnoreCase("DELDEP")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				// COMP_POL_FRZ_FLAG.setDisabled(false);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().disableAllComponents(true);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setINSERT_ALLOWED(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setDELETE_ALLOWED(true);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setUPDATE_ALLOWED(false);
			}
			/* end */

			/*
			 * Added by ganesh on 15-06-2017, as suggested by ajoy to enable
			 * payment type
			 */
			if (endType.equalsIgnoreCase("GEN009")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				COMP_POL_PYMT_TYPE.setDisabled(false);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				// COMP_POL_FRZ_FLAG.setDisabled(false);
			}

			/* end */
			/* added by raja on 28-06-2017 for discussed with ajoy */
			if (endType.equalsIgnoreCase("CDOB")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				// COMP_POL_FRZ_FLAG.setDisabled(false);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getCOMP_PFMD_MEMB_DOB().setDisabled(false);

				/* added by raja on 28-06-2017 for ZBILQC-1733519 */
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getCOMP_PFMD_MEMB_TYPE()
						.setDisabled(false);
				/* end */

				/* Added by Janani on 22.01.2018 as per Sivaram's suggestion */

				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_DOB().setDisabled(false);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().setUPDATE_ALLOWED(true);
				/* End */

				/*
				 * Added by Janani on 04.06.2018 for Product feature as per
				 * Sivaram's suggestion
				 */
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getCOMP_POAD_DOB().setDisabled(false);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().setUPDATE_ALLOWED(true);
				/* End */

				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setINSERT_ALLOWED(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setDELETE_ALLOWED(false);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setUPDATE_ALLOWED(true);
			}
			/* end */

			/* ADDED BY RAJA ON 12-08-2017 for discussed with ajoy */

			if (endType.equalsIgnoreCase("DMWP") || endType.equalsIgnoreCase("DMWOP")) {

				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				// COMP_POL_FRZ_FLAG.setDisabled(false);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(true);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				COMP_POL_EXPIRY_DT.setDisabled(false);
			}

			if (endType.equalsIgnoreCase("COCCP")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				// COMP_POL_FRZ_FLAG.setDisabled(false);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().setUPDATE_ALLOWED(true);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().setDELETE_ALLOWED(true);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_OCC_CODE().setDisabled(false);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_OCC_CLASS().setDisabled(true);
			}

			/* END */

			/*
			 * Commented &Modified by saritha on 03-10-2017 for Lapsation
			 * Override
			 */
			/* if(endType.equalsIgnoreCase("GEN008")) */

			if (endType.equalsIgnoreCase(getLap_ovr_sys_param())) {
				/* End */
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(false);
				PT_IL_POLICY_BEAN.setPOL_LAPS_OVR_YN("Y");
				PT_IL_POLICY_BEAN.setPOL_LAPS_OVR_FRM_DT(new CommonUtils().getCurrentDate());
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setDisabled(false);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_FRM_DT().setDisabled(false);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_FRM_DT().setRequired(true);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setRequired(true);

			}
			/* End */

			/* added by raja on 28-06-2017 for discussed with ajoy */

			if (getPT_IL_POLICY_BEAN().getPOL_END_TYPE() != null
					&& getPT_IL_POLICY_BEAN().getPOL_END_TYPE().equalsIgnoreCase("001")) {
				COMP_POL_FRZ_FLAG.setDisabled(false);
			} else {
				COMP_POL_FRZ_FLAG.setDisabled(true);
			}
			/* end */

			/*
			 * Added by Janani on 12.03.2018 for FSD_FLA_IL_008(GEN010
			 * endorsement)
			 */

			System.out.println(
					"endType               " + endType + "       getChkEndCode          " + this.getChkEndCode());

			if (endType != null && endType.equalsIgnoreCase(this.getChkEndCode())) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);

				compositeAction.getPT_IL_POL_ASSR_FAMILY_DTLS_ACTION_BEAN().disableAllComponent(false);
				compositeAction.getPT_IL_POL_ASSR_OCCU_DTLS_ACTION_BEAN().disableAllComponent(false);
				compositeAction.getPT_IL_POL_ASSR_FAMILY_DTLS_ACTION_BEAN().setUPDATE_ALLOWED(true);
				compositeAction.getPT_IL_POL_ASSR_FAMILY_DTLS_ACTION_BEAN().setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POL_ASSR_FAMILY_DTLS_ACTION_BEAN().setDELETE_ALLOWED(true);
				compositeAction.getPT_IL_POL_ASSR_OCCU_DTLS_ACTION_BEAN().setUPDATE_ALLOWED(true);
				compositeAction.getPT_IL_POL_ASSR_OCCU_DTLS_ACTION_BEAN().setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POL_ASSR_OCCU_DTLS_ACTION_BEAN().setDELETE_ALLOWED(true);
				COMP_POL_FRZ_FLAG.setDisabled(false);

			}

			/* End of FSD_FLA_IL_008 */

			/* Added by Janani on 12.04.2018 for KIC as suggested by Gaurav */
			if (getPT_IL_POLICY_BEAN().getPOL_END_TYPE() != null
					&& getPT_IL_POLICY_BEAN().getPOL_END_TYPE().equalsIgnoreCase("021")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				COMP_POL_REG_EXCESS_PREM.setDisabled(false);
			}
			/* End */

			/* Newly Added By Dhinesh on 20/04/2018 */
			if (endType.equalsIgnoreCase("GEN011")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				COMP_POL_RETURN_VAL.setDisabled(false);
				COMP_POL_FRZ_FLAG.setDisabled(false);
			}

			if (endType.equalsIgnoreCase("GEN012")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				COMP_POL_ASSRD_REF_ID1.setDisabled(false);
				COMP_POL_FRZ_FLAG.setDisabled(false);
			}

			/* End */

			/* Newly Added By Dhinesh on 24-04-2018 */

			if (endType.equalsIgnoreCase("GEN013")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				setUPDATE_ALLOWED(true);
				setINSERT_ALLOWED(true);
				setDELETE_ALLOWED(true);
				COMP_POL_PREM_PAY_YRS.setDisabled(false);
				COMP_POL_FRZ_FLAG.setDisabled(false);
			}

			if (endType.equalsIgnoreCase("GEN014")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN().setUPDATE_ALLOWED(true);
				compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN().setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN().setDELETE_ALLOWED(true);
				compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN().getCOMP_PLCOND_CODE().setDisabled(false);
				compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN().getCOMP_PLCOND_DESC().setDisabled(false);
				compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN().getCOMP_PLCOND_CONDITION().setDisabled(false);
				COMP_POL_FRZ_FLAG.setDisabled(false);
			}

			if (endType.equalsIgnoreCase("GEN015")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().setUPDATE_ALLOWED(true);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().setDELETE_ALLOWED(true);
				COMP_POL_RES_ADDRESS_1.setDisabled(false);
				COMP_POL_RES_ADDRESS_2.setDisabled(false);
				COMP_POL_RES_ADDRESS_3.setDisabled(false);
				COMP_POL_COUNT_CODE.setDisabled(false);
				COMP_POL_FAX_AREA_CODE.setDisabled(false);
				COMP_POL_FAX_NO.setDisabled(false);
				COMP_POL_OFF_PHONE_NO.setDisabled(false);
				COMP_POL_OFF_AREA_CODE.setDisabled(false);
				COMP_POL_OFF_ADDRESS_1.setDisabled(false);
				COMP_POL_OFF_ADDRESS_2.setDisabled(false);
				COMP_POL_OFF_ADDRESS_3.setDisabled(false);
				/*
				 * commented by Ameen on 07-05-2018 as per Chandramohan Sugg.
				 * COMP_POL_MOBILE_NO.setDisabled(false);
				 * COMP_POL_RES_EMAIL_ID.setDisabled(false);
				 */
				COMP_POL_RES_PHONE_NO.setDisabled(false);
				COMP_POL_STATE_CODE.setDisabled(false);
				COMP_POL_CITY_CODE.setDisabled(false);
				COMP_POL_RES_AREA_CODE.setDisabled(false);
				COMP_POL_FRZ_FLAG.setDisabled(false);
			}

			/*
			 * modified by Ameen on 08-05-2018 as per Ajoy
			 * if(endType.equalsIgnoreCase("GEN016"))
			 */
			if (endType.equalsIgnoreCase("CDOB")) {
				disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);

				compositeAction.getPT_IL_POLICY_ACTION_BEAN().setUPDATE_ALLOWED(true);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().setDELETE_ALLOWED(true);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().setUPDATE_ALLOWED(true);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().setDELETE_ALLOWED(true);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_DOB().setDisabled(false);
				COMP_POL_FRZ_FLAG.setDisabled(false);
			}

			/* End */

			/*
			 * if(endType.equalsIgnoreCase("GEN016")) {
			 * disbaleFields.IL_BLOCK_POL_DISABLED(compositeAction);
			 * setUPDATE_ALLOWED(true); setINSERT_ALLOWED(true);
			 * setDELETE_ALLOWED(true);
			 * COMP_POL_ASSRD_REF_ID1.setDisabled(false);
			 * COMP_POL_FRZ_FLAG.setDisabled(false); }
			 */

		}
	}
	// Added By Ameen 12.9.2016 for ssp call id : FALCONQC-1714579 ---END ---

	/* Addded By Dhinesh for ssp call id FALCONQC-1716975 */

	public static void COVER_SUM_SA_Validation(String Pol_sys_id, String Prod_code, String Pol_End_Type,
			String Pol_End_Code) throws Exception {

		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;

		String Psvalue = null;
		CRUDHandler handler = new CRUDHandler();
		String POAC_COVER_CODE = null;
		Double POAC_FC_SA = null;
		Double POAC_ORG_FC_SA = null;
		Double POAC_LC_SA = null;
		Double POAC_ORG_LC_SA = null;
		Double TOT_POAC_FC_SA = null;
		Double TOT_POAC_LC_SA = null;
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();

		PKG_PILT002_APAC PKG_PILT002_APAC_BEAN = new PKG_PILT002_APAC();
		String query = "SELECT POAC_COVER_CODE,POAC_FC_SA,POAC_ORG_FC_SA,POAC_LC_SA,POAC_ORG_LC_SA FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID= ?";
		String query1 = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_DEL_RIDER'";

		resultSet1 = new CRUDHandler().executeSelectStatement(query1, connection, new Object[] {});
		while (resultSet1.next()) {
			Psvalue = resultSet1.getString("PS_CODE");
		}
		resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[] { Pol_sys_id });
		while (resultSet.next()) {
			POAC_COVER_CODE = resultSet.getString("POAC_COVER_CODE");

			POAC_FC_SA = resultSet.getDouble("POAC_FC_SA");
			POAC_ORG_FC_SA = resultSet.getDouble("POAC_ORG_FC_SA");
			POAC_LC_SA = resultSet.getDouble("POAC_LC_SA");
			POAC_ORG_LC_SA = resultSet.getDouble("POAC_ORG_LC_SA");

			outputList = PKG_PILT002_APAC_BEAN.callCoverMaxMinSA_Check(Pol_sys_id, Prod_code, POAC_COVER_CODE);
			System.out.println("POAC_COVER_CODE      : " + POAC_COVER_CODE);

			System.out.println("POAC_FC_SA     :  " + POAC_FC_SA);

			TOT_POAC_FC_SA = CommonUtils.nvl(POAC_FC_SA, 0) + (CommonUtils.nvl(POAC_ORG_FC_SA, 0));
			TOT_POAC_LC_SA = CommonUtils.nvl(POAC_LC_SA, 0) + (CommonUtils.nvl(POAC_ORG_LC_SA, 0));

			System.out.println("TOT_POAC_FC_SA    : " + TOT_POAC_FC_SA);
			System.out.println("outputList  Max SA   : " + outputList.get(1).getValueObject());
			System.out.println("TOT_POAC_LC_SA    : " + TOT_POAC_LC_SA);
			System.out.println("outputList  MIN SA   : " + outputList.get(0).getValueObject());
			if (TOT_POAC_FC_SA != null && TOT_POAC_LC_SA != null) {
				if (CommonUtils.isIN(CommonUtils.nvl(Pol_End_Type, "000"), new String[] { "000", "002", "012" })
						&& (CommonUtils.nvl(Pol_End_Code, "XXX") != Psvalue)) {
					if (TOT_POAC_FC_SA > Double.parseDouble(outputList.get(1).getValueObject().toString())) {

						System.out.println("MAX VALUE BLOCK");
						throw new Exception(
								POAC_COVER_CODE + " Cover Sum Assured exceeds the Max limit in Cover Master.");

					}

					if (TOT_POAC_FC_SA < Double.parseDouble(outputList.get(0).getValueObject().toString())) {

						System.out.println("MIN VALUE BLOCK");
						throw new Exception(
								POAC_COVER_CODE + " Cover Sum Assured Less than Min limit in Cover Master.");

					}

				}
			}

		}

		System.out.println("POAC_COVER_CODE VALUE    : " + POAC_COVER_CODE);

	}

	/* End */
	/*
	 * Modified by Saranya on 13-03-2017 for RM018T - FSD_IL_ZB
	 * Life_001-Education Endowment Plan COMMENTS
	 */
	// Added by saranya for maturity link enable & disable on 03-11-2016
	public String PLAN_TYPE = null;

	public String getPLAN_TYPE() {
		return PLAN_TYPE;
	}

	public void setPLAN_TYPE(String pLAN_TYPE) {
		PLAN_TYPE = pLAN_TYPE;
	}

	public void getProd_plan_type() throws Exception {
		/*
		 * String
		 * query="SELECT PLAN_TYPE FROM PM_IL_PLAN, PT_IL_POLICY WHERE POL_PLAN_CODE = PLAN_CODE AND POL_SYS_ID =?"
		 * ;
		 */
		String Plan_type1 = null;
		String risk_yn = null;

		/*
		 * QUERY CHANGED BY SANKARA NARAYANAN ON 28/03/2017 String
		 * query="SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
		 */
		String query = "SELECT PROD_RISK_FACTOR_YN,PLAN_TYPE FROM PM_IL_PLAN,PM_IL_PRODUCT WHERE PLAN_CODE= ? AND PROD_CODE= ?";

		ResultSet resultSet1 = null;
		Connection connection = null;
		connection = CommonUtils.getConnection();
		System.out.println(" value  :" + PT_IL_POLICY_BEAN.getPOL_PLAN_CODE());
		/*
		 * Modified by Shankar on 07/04/2017
		 * 
		 * resultSet1 = new CRUDHandler().executeSelectStatement(query,
		 * connection, new Object[]{PT_IL_POLICY_BEAN.getPOL_PLAN_CODE()});
		 */
		resultSet1 = new CRUDHandler().executeSelectStatement(query, connection,
				new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE(), PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
		/* End */
		while (resultSet1.next()) {
			Plan_type1 = resultSet1.getString("PLAN_TYPE");
			risk_yn = resultSet1.getString("PROD_RISK_FACTOR_YN");
			System.out.println("value of PLAN_TYPE--->" + PLAN_TYPE);
		}
		setPLAN_TYPE(Plan_type1);
		setPROD_RISK_FLG(risk_yn);
		System.out.println("getPLAN_TYPE of PLAN_TYPE--->" + getPLAN_TYPE());
	}
	/* end */
	/* ENd */

	/* Added by Ram on 15/11/2016 for display BusinessRule in Panel */
	private HtmlModalPanel COMP_BUS_REPORT_MODAL_PANEL;

	public HtmlModalPanel getCOMP_BUS_REPORT_MODAL_PANEL() {
		return COMP_BUS_REPORT_MODAL_PANEL;
	}

	public void setCOMP_BUS_REPORT_MODAL_PANEL(HtmlModalPanel cOMP_BUS_REPORT_MODAL_PANEL) {
		COMP_BUS_REPORT_MODAL_PANEL = cOMP_BUS_REPORT_MODAL_PANEL;
	}

	/*
	 * compositeAction added by saritha on 04-08-2017 for freeze flag yes choose
	 * then save error: freeze flag null
	 */
	public String businessModalPanel(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		/* End */
		try {
			/* Added by saritha on 08-Jun-2017 for ssp call id ZBILQC-1721836 */
			System.out.println("inside businessModalPanel call------------------------");
			setBlockFlag(true);
			if (compositeAction.getPT_BUS_RULE_ERROR_MSG_ACTION_BEAN().getDataList_PT_BUS_RULE_ERROR_MSG().size() > 0) {
				compositeAction.getPT_BUS_RULE_ERROR_MSG_ACTION_BEAN().onLoad(null);
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_REPORT_MODAL_PANEL_CUSTOMER()
						.setShowWhenRendered(false);
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_REPORT_MODAL_PANEL_ASSURED()
						.setShowWhenRendered(false);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_BUS_REPORT_MODAL_PANEL()
						.setShowWhenRendered(true);
			}
			/* End */
		} catch (Exception e) {
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_REPORT_MODAL_PANEL_ASSURED()
					.setShowWhenRendered(false);
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("AssuredModalPanel", e.getMessage());
		}
		return "";
	}

	public String closeBusinessModalPanel() {
		try {

			compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_REPORT_MODAL_PANEL_CUSTOMER()
					.setShowWhenRendered(false);
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_REPORT_MODAL_PANEL_ASSURED()
					.setShowWhenRendered(false);
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_BUS_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		} catch (Exception e) {
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_REPORT_MODAL_PANEL_ASSURED()
					.setShowWhenRendered(false);
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("AssuredModalPanel", e.getMessage());
		}
		return "";
	}
	/* End */

	/* Added by Ram on 25/11/2016 for LoanType field addition */
	private HtmlOutputLabel COMP_POL_LOAN_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_POL_LOAN_TYPE;

	public HtmlOutputLabel getCOMP_POL_LOAN_TYPE_LABEL() {
		return COMP_POL_LOAN_TYPE_LABEL;
	}

	public void setCOMP_POL_LOAN_TYPE_LABEL(HtmlOutputLabel cOMP_POL_LOAN_TYPE_LABEL) {
		COMP_POL_LOAN_TYPE_LABEL = cOMP_POL_LOAN_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_LOAN_TYPE() {
		return COMP_POL_LOAN_TYPE;
	}

	public void setCOMP_POL_LOAN_TYPE(HtmlSelectOneMenu cOMP_POL_LOAN_TYPE) {
		COMP_POL_LOAN_TYPE = cOMP_POL_LOAN_TYPE;
	}

	public void validatorPOL_LOAN_TYPE(FacesContext context, UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : " + value.toString());
			PT_IL_POLICY_BEAN.setPOL_LOAN_TYPE((String) value);
			System.out.println("getPOL_LOAN_TYPE()   : " + PT_IL_POLICY_BEAN.getPOL_LOAN_TYPE());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	private List<SelectItem> listPOL_LOAN_TYPE = new ArrayList<SelectItem>();

	public List<SelectItem> getListPOL_LOAN_TYPE() {
		return listPOL_LOAN_TYPE;
	}

	public void setListPOL_LOAN_TYPE(List<SelectItem> listPOL_LOAN_TYPE) {
		this.listPOL_LOAN_TYPE = listPOL_LOAN_TYPE;
	}

	/* End */
	/* Added by Ram on 03/12/2016 for Business Rule Reports Configuration */
	// @Override
	public String bus_rule_runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		try {
			Connection conn = CommonUtils.getConnection();

			StringBuffer url = null;
			String menuAction = (String) CommonUtils.getGlobalObject("MENU_ACTION");
			System.out.println("menuAction      " + menuAction);
			String Report_Id = getReportIdwithoutInterface(CommonUtils.getConnection(), menuAction);
			IP_REP_INFO repInfo = new IP_REP_INFO();
			String REP_KEY_NO = new ReportUtils().getRepKeyNo();
			String DEP_REF_NO = null;
			System.out.println("REP_KEY_NO          :" + REP_KEY_NO);
			repInfo.setREP_KEY_NO(REP_KEY_NO);
			repInfo.setREP_VALUE_1("3");
			repInfo.setREP_VALUE_2("POL_NO" + "&&&" + getPT_IL_POLICY_BEAN().getPOL_NO());
			repInfo.setREP_VALUE_3("POL_SYS_ID" + "&&&" + getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			repInfo.setREP_VALUE_4("REP_KEY_NO" + "&&&" + REP_KEY_NO);

			String reportNames = "", reportNamesForDel = "";
			// Iterator<String> scheduleITRforDel =
			// getUI_M_SCHEDULE_TYPE().iterator();
			// while(scheduleITRforDel.hasNext())
			// {
			// String reportName = scheduleITRforDel.next();
			// reportNamesForDel += reportName+",";
			// }

			// if(reportNamesForDel != null && reportNamesForDel.length() > 0)
			// {
			// reportNamesForDel =
			// reportNamesForDel.substring(0,reportNamesForDel.length()-1);
			// System.out.println("reportNamesForDel "+reportNamesForDel);
			// String deleteQuestionQuery = "DELETE FROM PT_IL_POL_BR_QUESTION
			// WHERE PBQ_POL_SYS_ID = ? AND PBQ_QUEST_REP_NAME NOT IN (?)";
			// new CRUDHandler().executeDeleteStatement(deleteQuestionQuery,
			// conn,new
			// Object[]{getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),reportNamesForDel});
			// conn.commit();
			// }

			Iterator<String> scheduleITR = getUI_M_SCHEDULE_TYPE().iterator();
			setUserEntryDetails();
			String deleteQuestionQuery = "DELETE FROM PT_IL_POL_BR_QUESTION WHERE PBQ_POL_SYS_ID = ?";
			new CRUDHandler().executeDeleteStatement(deleteQuestionQuery, conn,
					new Object[] { getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			conn.commit();
			String reportName = Report_Id + ",";
			reportNames += reportName;
			System.out.println("getUI_M_SCHEDULE_TYPE()      " + getUI_M_SCHEDULE_TYPE());
			while (scheduleITR.hasNext()) {
				PT_IL_POL_BR_QUESTION_BEAN = new PT_IL_POL_BR_QUESTION();
				reportName = scheduleITR.next();
				reportNames += reportName + ",";
				String categoryQuery = " SELECT PC_TYPE FROM PM_CODES WHERE PC_TYPE IN (SELECT PC_CODE FROM PM_CODES WHERE PC_TYPE = 'IL_QUEST_TYP') AND "
						+ "PC_CODE = ? ";
				ResultSet rs = new CRUDHandler().executeSelectStatement(categoryQuery, conn,
						new Object[] { reportName });
				while (rs.next()) {
					getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_QUEST_TYPE(rs.getString(1));
				}
				String QuestionarieSeqQuery = null;
				QuestionarieSeqQuery = "SELECT PBQ_SYS_ID FROM PT_IL_POL_BR_QUESTION WHERE PBQ_POL_SYS_ID = ? AND PBQ_QUEST_REP_NAME = ?";
				System.out.println("getPT_IL_POLICY_BEAN().getPOL_SYS_ID()          "
						+ getPT_IL_POLICY_BEAN().getPOL_SYS_ID() + "      " + reportName);
				rs = new CRUDHandler().executeSelectStatement(QuestionarieSeqQuery, conn,
						new Object[] { getPT_IL_POLICY_BEAN().getPOL_SYS_ID(), reportName });
				if (rs.next()) {
					System.out.println("if condition");
					getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_SYS_ID(rs.getLong(1));
				} else {
					System.out.println("else condition");
					QuestionarieSeqQuery = "SELECT PIL_PBQ_SYS_ID.NEXTVAL FROM DUAL";

					rs = new CRUDHandler().executeSelectStatement(QuestionarieSeqQuery, conn);
					while (rs.next()) {
						getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_SYS_ID(rs.getLong(1));
					}

					System.out.println("getPT_IL_POL_BR_QUESTION_BEAN().getPBQ_SYS_ID        "
							+ getPT_IL_POL_BR_QUESTION_BEAN().getPBQ_SYS_ID());
					getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_POL_SYS_ID(getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
					getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_QUEST_REP_NAME(reportName);

					System.out.println("getPT_IL_POL_BR_QUESTION_BEAN().getPBQ_QUEST_TYPE     "
							+ getPT_IL_POL_BR_QUESTION_BEAN().getPBQ_QUEST_TYPE() + "  "
							+ getPT_IL_POL_BR_QUESTION_BEAN().getPBQ_CR_UID());

					new CRUDHandler().executeInsert(getPT_IL_POL_BR_QUESTION_BEAN(), conn);
					conn.commit();

				}

			}
			System.out.println("reportNames  " + reportNames);
			repInfo.setREP_VALUE_59(reportNames);

			System.out.println("UI_M_SCHEDULE_TYPE         " + getUI_M_SCHEDULE_TYPE());
			new CRUDHandler().executeUpdate(PT_IL_POLICY_BEAN, conn);

			int ins = new CRUDHandler().executeInsert(repInfo, conn);
			conn.commit();

			PRINT_ACTION helper = compositeAction.getPRINT_ACTION_BEAN();
			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());

			url = new StringBuffer(getRedirectUrl());
			url.append("REP_KEY_NO=" + REP_KEY_NO + "&REP_ID=" + Report_Id);
			setRedirectUrl(url.toString());
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			System.out.println("CommonReportAction.runActionAfterValidate: " + getRedirectUrl());
			response.sendRedirect(getRedirectUrl());

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}

	public void setUserEntryDetails() throws ParseException {
		getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_CR_DT(new CommonUtils().getCurrentDate());
		getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_UPD_DT(new CommonUtils().getCurrentDate());
		getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
	}

	private HtmlInputTextarea COMP_POL_BUS_REMARKS;

	private HtmlOutputLabel COMP_POL_BUS_REMARKS_LABEL;

	public HtmlInputTextarea getCOMP_POL_BUS_REMARKS() {
		return COMP_POL_BUS_REMARKS;
	}

	public void setCOMP_POL_BUS_REMARKS(HtmlInputTextarea cOMP_POL_BUS_REMARKS) {
		COMP_POL_BUS_REMARKS = cOMP_POL_BUS_REMARKS;
	}

	public HtmlOutputLabel getCOMP_POL_BUS_REMARKS_LABEL() {
		return COMP_POL_BUS_REMARKS_LABEL;
	}

	public void setCOMP_POL_BUS_REMARKS_LABEL(HtmlOutputLabel cOMP_POL_BUS_REMARKS_LABEL) {
		COMP_POL_BUS_REMARKS_LABEL = cOMP_POL_BUS_REMARKS_LABEL;
	}

	public void validatePOL_BUS_REMARKS(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_BUS_REMARKS((String) value);
			System.out.println("business Remarks       " + PT_IL_POLICY_BEAN.getPOL_BUS_REMARKS());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "QUOT_MEDICAL_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private HtmlOutputLabel COMP_QUESTIONARIES_LABEL;
	private HtmlSelectManyListbox COMP_QUESTIONARIES;
	private List<SelectItem> listUI_M_SCHEDULE_TYPE = new ArrayList<SelectItem>();
	private List<String> UI_M_SCHEDULE_TYPE;

	public List<SelectItem> getListUI_M_SCHEDULE_TYPE() {
		return listUI_M_SCHEDULE_TYPE;
	}

	public void setListUI_M_SCHEDULE_TYPE(List<SelectItem> listUI_M_SCHEDULE_TYPE) {
		this.listUI_M_SCHEDULE_TYPE = listUI_M_SCHEDULE_TYPE;
	}

	public HtmlOutputLabel getCOMP_QUESTIONARIES_LABEL() {
		return COMP_QUESTIONARIES_LABEL;
	}

	public void setCOMP_QUESTIONARIES_LABEL(HtmlOutputLabel cOMP_QUESTIONARIES_LABEL) {
		COMP_QUESTIONARIES_LABEL = cOMP_QUESTIONARIES_LABEL;
	}

	public HtmlSelectManyListbox getCOMP_QUESTIONARIES() {
		return COMP_QUESTIONARIES;
	}

	public void setCOMP_QUESTIONARIES(HtmlSelectManyListbox cOMP_QUESTIONARIES) {
		COMP_QUESTIONARIES = cOMP_QUESTIONARIES;
	}

	public List<String> getUI_M_SCHEDULE_TYPE() {
		return UI_M_SCHEDULE_TYPE;
	}

	public void setUI_M_SCHEDULE_TYPE(List<String> uI_M_SCHEDULE_TYPE) {
		UI_M_SCHEDULE_TYPE = uI_M_SCHEDULE_TYPE;
	}

	public ArrayList<SelectItem> UI_M_SCHEDULE_TYPELIST() {
		System.out.println("Welcome to UI_M_SCHEDULE_TYPELIST");
		ArrayList<SelectItem> list = null;
		SelectItem selectItem = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<SelectItem>();
			conn = CommonUtils.getConnection();
			String query = "SELECT * FROM PM_CODES WHERE PC_TYPE IN (SELECT PC_CODE FROM PM_CODES WHERE PC_TYPE = ?)";
			rs = new CRUDHandler().executeSelectStatement(query, conn, new Object[] { "IL_QUEST_TYP" });
			while (rs.next()) {

				selectItem = new SelectItem();
				/* Modifed by Ram on 11/12/2016 for Display purpose */
				selectItem.setLabel(rs.getString("PC_DESC") + " - " + rs.getString("PC_BL_SHORT_DESC"));
				/* End */
				selectItem.setValue(rs.getString("PC_CODE"));
				list.add(selectItem);

			}

			System.out.println("****************  UI_M_SCHEDULE_TYPELIST   *****************");

			System.out.println("schedule_type  Size   : " + list.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	private PT_IL_POL_BR_QUESTION PT_IL_POL_BR_QUESTION_BEAN;

	public PT_IL_POL_BR_QUESTION getPT_IL_POL_BR_QUESTION_BEAN() {
		return PT_IL_POL_BR_QUESTION_BEAN;
	}

	public void setPT_IL_POL_BR_QUESTION_BEAN(PT_IL_POL_BR_QUESTION pT_IL_POL_BR_QUESTION_BEAN) {
		PT_IL_POL_BR_QUESTION_BEAN = pT_IL_POL_BR_QUESTION_BEAN;
	}

	/* End */
	/*
	 * Added by saranya on 02-11-2016 for RM018T - FSD_IL_ZB
	 * Life_013_Underwriting changes
	 */

	public void validatePOL_FC_AGENT_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		try {
			PT_IL_POLICY_BEAN.setPOL_FC_AGENT_PREM((Double) value);
			PT_IL_POLICY_BEAN.setPOL_LC_AGENT_PREM(PT_IL_POLICY_BEAN.getPOL_FC_AGENT_PREM());

			/*
			 * Added by Janani on 25.06.2018 for FSD_IL_FLA_006_Monetary
			 * Endorsement Module
			 */
			if (getAgentPremiumType().equalsIgnoreCase("t") && PT_IL_POLICY_BEAN.getPOL_FC_MODAL_PREM() == null) {
				PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(PT_IL_POLICY_BEAN.getPOL_FC_AGENT_PREM());
			}
			/* End */

			System.out.println("PT_IL_POLICY_BEAN.setPOL_LC_AGENT_PREM  :" + PT_IL_POLICY_BEAN.getPOL_LC_AGENT_PREM());
			COMP_POL_FC_AGENT_PREM.resetValue();
			COMP_POL_LC_AGENT_PREM.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}

	}

	/* End */
	/*
	 * added by saranya on 10-12-2016 for RM018T - FSD_IL_ZB Life_016-Queried
	 * Proposals v1.0
	 */

	public void validatePOL_CANCEL_YN(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		try {
			checkCancelYN(PT_IL_POLICY_BEAN, compositeAction);
			String CurValue = (String) value;
			// System.out.println("PT_IL_POLICY_BEAN.getPOL_CANCEL_YN()
			// :"+PT_IL_POLICY_BEAN.getPOL_CANCEL_YN());
			if ("Y".equalsIgnoreCase(CurValue)) {
				if ("Y".equalsIgnoreCase(Cancel_YN)) {
					PT_IL_POLICY_BEAN.setPOL_CANCEL_YN((String) value);
				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "User not Authorized to change the cancellation Override Y/N" }));
				}
			}

			COMP_POL_CANCEL_YN.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CREDIT_DISCOUNT_PERC",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/* End */
	/*
	 * added by saranya on 19-12-2016 for RM018T - FSD_IL_ZB Life_016-Queried
	 * Proposals v1.0
	 */
	String Cancel_YN = null;

	public void checkCancelYN(PT_IL_POLICY pt_il_policy_bean, PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			System.out.println("pt_il_policy_bean.getPOL_UPD_UID()  :" + pt_il_policy_bean.getPOL_UPD_UID());
			System.out.println("pt_il_policy_bean.getPOL_PROD_CODE()  :" + pt_il_policy_bean.getPOL_PROD_CODE());
			String query = "SELECT  ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID = ? AND ASD_CODE = 'PROP_CAN_OVR'"
					+ "AND ? BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
			connection = CommonUtils.getConnection();
			resultSet1 = handler.executeSelectStatement(query, connection,
					new Object[] { pt_il_policy_bean.getPOL_UPD_UID(), pt_il_policy_bean.getPOL_PROD_CODE() });
			if (resultSet1.next()) {
				Cancel_YN = resultSet1.getString(1);
				System.out.println("Cancel_YN  :" + Cancel_YN);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// compositeAction.getWizard().setImmediate("true");
			throw new Exception(e.getMessage());
		}

	}
	/* End */

	/*
	 * Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and
	 * commission clawback 2
	 */

	private HtmlOutputLabel COMP_POL_LAPS_OVR_YN_LABEL;

	public HtmlOutputLabel getCOMP_POL_LAPS_OVR_YN_LABEL() {
		return COMP_POL_LAPS_OVR_YN_LABEL;
	}

	public void setCOMP_POL_LAPS_OVR_YN_LABEL(HtmlOutputLabel cOMP_POL_LAPS_OVR_YN_LABEL) {
		COMP_POL_LAPS_OVR_YN_LABEL = cOMP_POL_LAPS_OVR_YN_LABEL;
	}

	private HtmlSelectOneMenu COMP_POL_LAPS_OVR_YN;

	public HtmlSelectOneMenu getCOMP_POL_LAPS_OVR_YN() {
		return COMP_POL_LAPS_OVR_YN;
	}

	public void setCOMP_POL_LAPS_OVR_YN(HtmlSelectOneMenu cOMP_POL_LAPS_OVR_YN) {
		COMP_POL_LAPS_OVR_YN = cOMP_POL_LAPS_OVR_YN;
	}

	private List<SelectItem> listPOL_LAPS_OVR_YN = new ArrayList<SelectItem>();

	public List<SelectItem> getListPOL_LAPS_OVR_YN() {
		return listPOL_LAPS_OVR_YN;
	}

	public void setListPOL_LAPS_OVR_YN(List<SelectItem> listPOL_LAPS_OVR_YN) {
		this.listPOL_LAPS_OVR_YN = listPOL_LAPS_OVR_YN;
	}

	public void validatePOL_LAPS_OVR_YN(FacesContext context, UIComponent component, Object value) {
		CommonUtils.clearMaps(this);
		String POL_LAPS_OVR_YN = (String) value;
		try {
			getPT_IL_POLICY_BEAN().setPOL_LAPS_OVR_YN(POL_LAPS_OVR_YN);
			System.out.println("Lapsation Override Y/N ::::::::::::::::::" + PT_IL_POLICY_BEAN.getPOL_LAPS_OVR_YN());
			helper.POL_LAPS_OVR_YN_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
			/* COMP_POL_LAPS_OVR_YN.resetValue(); */
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	private HtmlOutputLabel COMP_POL_LAPS_OVR_DT_LABEL;

	public HtmlOutputLabel getCOMP_POL_LAPS_OVR_DT_LABEL() {
		return COMP_POL_LAPS_OVR_DT_LABEL;
	}

	public void setCOMP_POL_LAPS_OVR_DT_LABEL(HtmlOutputLabel cOMP_POL_LAPS_OVR_DT_LABEL) {
		COMP_POL_LAPS_OVR_DT_LABEL = cOMP_POL_LAPS_OVR_DT_LABEL;
	}

	private HtmlCalendar COMP_POL_LAPS_OVR_DT;

	public HtmlCalendar getCOMP_POL_LAPS_OVR_DT() {
		return COMP_POL_LAPS_OVR_DT;
	}

	public void setCOMP_POL_LAPS_OVR_DT(HtmlCalendar cOMP_POL_LAPS_OVR_DT) {
		COMP_POL_LAPS_OVR_DT = cOMP_POL_LAPS_OVR_DT;
	}

	public void validatePOL_LAPS_OVR_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		Date curDate = (Date) value;
		try {
			PT_IL_POLICY_BEAN.setPOL_LAPS_OVR_TO_DT((Date) value);
			helper.POL_LAPS_OVR_DT_WHEN_VALIDATE_ITEM(compositeAction, (Date) value);
			COMP_POL_LAPS_OVR_DT.resetValue();

		} catch (Exception exe) {
			getErrorMap().put("current", exe.getMessage());
			throw new ValidatorException(new FacesMessage(exe.getMessage()));
		}
	}

	/* End */

	/* Added by saritha on 20-07-2017 for ssp call id ZBILQC-1732158 */
	public void validatePOL_LAPS_OVR_FRM_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		Date curDate = (Date) value;
		try {
			PT_IL_POLICY_BEAN.setPOL_LAPS_OVR_FRM_DT((Date) value);
			helper.POL_LAPS_OVR_FRM_DT_WHEN_VALIDATE_ITEM(compositeAction, (Date) value);
			COMP_POL_LAPS_OVR_FRM_DT.resetValue();

		} catch (Exception exe) {
			getErrorMap().put("current", exe.getMessage());
			throw new ValidatorException(new FacesMessage(exe.getMessage()));
		}
	}
	/* End */

	/*
	 * Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_002-Customer
	 * Master Changes COMMENTS
	 */

	private HtmlInputText COMP_POL_PREM_PAYER_CODE;
	private HtmlInputText COMP_UI_M_POL_PREM_PAYER_CODE_DESC;

	private HtmlOutputLabel COMP_POL_PREM_PAYER_CODE_LABEL;

	public HtmlInputText getCOMP_POL_PREM_PAYER_CODE() {
		return COMP_POL_PREM_PAYER_CODE;
	}

	public void setCOMP_POL_PREM_PAYER_CODE(HtmlInputText cOMP_POL_PREM_PAYER_CODE) {
		COMP_POL_PREM_PAYER_CODE = cOMP_POL_PREM_PAYER_CODE;
	}

	public HtmlInputText getCOMP_UI_M_POL_PREM_PAYER_CODE_DESC() {
		return COMP_UI_M_POL_PREM_PAYER_CODE_DESC;
	}

	public void setCOMP_UI_M_POL_PREM_PAYER_CODE_DESC(HtmlInputText cOMP_UI_M_POL_PREM_PAYER_CODE_DESC) {
		COMP_UI_M_POL_PREM_PAYER_CODE_DESC = cOMP_UI_M_POL_PREM_PAYER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_PREM_PAYER_CODE_LABEL() {
		return COMP_POL_PREM_PAYER_CODE_LABEL;
	}

	public void setCOMP_POL_PREM_PAYER_CODE_LABEL(HtmlOutputLabel cOMP_POL_PREM_PAYER_CODE_LABEL) {
		COMP_POL_PREM_PAYER_CODE_LABEL = cOMP_POL_PREM_PAYER_CODE_LABEL;
	}

	public void validatePOL_PREM_PAYER_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_PREM_PAYER_CODE((String) value);

			System.out.println("enters into validatePOL_PREM_PAYER_CODE");
			/* added by raja on 10-07-2017 for ZBILQC-1731018 */

			LIFELIB lifelib = new LIFELIB();
			lifelib.P_VAL_CUST(PT_IL_POLICY_BEAN.getPOL_PREM_PAYER_CODE(),
					PT_IL_POLICY_BEAN.getUI_M_POL_PREM_PAYER_CODE_DESC(), "N", "N",
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE());

			/* end */

			/* Added by Janani on 09.06.2017 for ZBILQC-1728495 */

			// helper.assuredAgeCheck(compositeAction);

			/* End */

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	public ArrayList<LovBean> lovPOL_PREM_PAYER_CODE(Object object) {

		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		String M_FACIN_YN = null;
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = null;
		String currentValue = (String) object;
		String query = " SELECT NVL(CLASS_FACIN_YN, 'N')   	FROM   PM_IL_CLASS" + "  WHERE  CLASS_CODE = ? ";

		String subQry = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";

		/*
		 * commented by Ameen for lov lower case issue ssp call id
		 * FALCONLIFE-1344105
		 * 
		 * String mainQry = "SELECT CUST_CODE,CUST_NAME,CUST_BL_NAME " +
		 * " FROM PM_CUSTOMER WHERE CUST_CLASS IN " +
		 * " (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM " +
		 * " WHERE DECODE(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN " +
		 * " (?)) AND CUST_FRZ_FLAG = 'N' AND (CUST_APPL_ALL_BRAN_YN = 'Y'" +
		 * " OR CUST_CODE IN " + " (SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN " +
		 * " WHERE CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE))) AND " +
		 * "(CUST_CODE LIKE ? OR CUST_NAME LIKE ? OR  CUST_BL_NAME LIKE ?)AND  ROWNUM < 25 order by 1"
		 * ;
		 */

		/*
		 * Added by Ameen for lov lower case issue ssp call id
		 * FALCONLIFE-1344105
		 */
		String mainQry = "SELECT CUST_CODE,CUST_NAME,CUST_BL_NAME " + " FROM PM_CUSTOMER WHERE CUST_CLASS IN "
				+ " (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM "
				+ " WHERE DECODE(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN "
				+ " (?)) AND CUST_FRZ_FLAG = 'N' AND (CUST_APPL_ALL_BRAN_YN = 'Y'" + " OR CUST_CODE IN "
				+ " (SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN "
				+ " WHERE CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE))) AND "
				+ "(UPPER(CUST_CODE) LIKE UPPER(?) OR UPPER(CUST_NAME) LIKE UPPER(?) OR  UPPER(CUST_BL_NAME) LIKE UPPER(?))AND  ROWNUM < 25 order by 1";
		/* End */
		System.out.println(mainQry);
		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });

			while (rs.next()) {
				M_FACIN_YN = rs.getString(1);
			}
			// ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.

			/* Added by R. Raja on 01-06-2017 for ZBILQC-1724387 */
			PT_IL_POLICY_BEAN.setUI_M_PREM_PAYR_FLAG("Y");
			/* end */

			if (("1".equals(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_CALC_METHOD())
					|| "2".equals(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_CALC_METHOD()))
					&& "C".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARA_7"))) {
				mainQry = prepareCustomerQuery(mainQry, new Object[] { "BANK" });
				values = new Object[] { PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), currentValue, currentValue,
						currentValue };
				suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);

			} else {
				if ("N".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_CASH_YN(), "N"))) {
					if ("N".equals(CommonUtils.nvl(M_FACIN_YN, "N"))) {

						mainQry = prepareCustomerQuery(mainQry, new Object[] { "CUSTOMER" });
						values = new Object[] { PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), currentValue, currentValue,
								currentValue };
						suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);

					} else {
						mainQry = prepareCustomerQuery(mainQry, new Object[] { "REINS" });
						values = new Object[] { PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), currentValue, currentValue,
								currentValue };
						suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);
					}
				} else {
					mainQry = prepareCustomerQuery(mainQry, new Object[] { "CASH" });
					values = new Object[] { PT_IL_POLICY_BEAN.getPOL_DIVN_CODE(), currentValue, currentValue,
							currentValue };
					suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return suggestionList;
	}

	/* end */

	/* added by gopi for RM018T - DEV_IL_ZB Life_022-Automated Premium Loan */
	public void validatePROD_APL_YN(FacesContext context, UIComponent component, Object value) {
		try {
			String objValue = (String) value;
			PT_IL_POLICY_BEAN.setPOL_APL_YN(objValue);
			COMP_PROD_INS_APL_YN.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public String POl_APL() {

		String pol_apl = null;
		Connection connection = null;
		ResultSet rs = null;
		String query = "select PROD_APL_YN from PM_IL_PRODUCT where PROD_CODE=?";
		try {

			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
			if (rs.next()) {
				pol_apl = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pol_apl;
	}

	/* end */
	/* added by saranya for ssp call ZBILQC-1718566 on 20-01-2016 */
	String M_POL_ST_DT = null;

	public String Trunc_st_dd_dt() {
		Connection connection = null;
		ResultSet rs1 = null;
		String query1 = "SELECT TO_CHAR(?, 'DD') FROM DUAL";
		try {
			System.out.println(PT_IL_POLICY_BEAN.getPOL_START_DT());
			connection = CommonUtils.getConnection();
			rs1 = new CRUDHandler().executeSelectStatement(query1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_START_DT() });
			if (rs1.next()) {
				M_POL_ST_DT = rs1.getString(1);
				System.out.println("M_POL_ST_DT  :" + M_POL_ST_DT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return M_POL_ST_DT;
	}

	/*
	 * Added by saritha on 27-01-2017 for RM018T - DEV_IL_ZB
	 * Life_027-Replacement Policy
	 */
	private HtmlOutputLabel COMP_POL_REPLACEMENT_YN_LABEL;

	public HtmlOutputLabel getCOMP_POL_REPLACEMENT_YN_LABEL() {
		return COMP_POL_REPLACEMENT_YN_LABEL;
	}

	public void setCOMP_POL_REPLACEMENT_YN_LABEL(HtmlOutputLabel cOMP_POL_REPLACEMENT_YN_LABEL) {
		COMP_POL_REPLACEMENT_YN_LABEL = cOMP_POL_REPLACEMENT_YN_LABEL;
	}

	private HtmlSelectOneMenu COMP_POL_REPLACEMENT_YN;

	public HtmlSelectOneMenu getCOMP_POL_REPLACEMENT_YN() {
		return COMP_POL_REPLACEMENT_YN;
	}

	public void setCOMP_POL_REPLACEMENT_YN(HtmlSelectOneMenu cOMP_POL_REPLACEMENT_YN) {
		COMP_POL_REPLACEMENT_YN = cOMP_POL_REPLACEMENT_YN;
	}

	private List<SelectItem> listPOL_REPL_POLICY_YN = new ArrayList<SelectItem>();

	public List<SelectItem> getListPOL_REPL_POLICY_YN() {
		return listPOL_REPL_POLICY_YN;
	}

	public void setListPOL_REPL_POLICY_YN(List<SelectItem> listPOL_REPL_POLICY_YN) {
		this.listPOL_REPL_POLICY_YN = listPOL_REPL_POLICY_YN;
	}

	public void validatePOL_REPLACEMENT_YN(FacesContext context, UIComponent component, Object value) {
		String POL_REPL_POLICY_YN = (String) value;
		try {
			getPT_IL_POLICY_BEAN().setPOL_REPL_POLICY_YN(POL_REPL_POLICY_YN);
			System.out.println("Replacement Y/N ::::::::::::::::::" + PT_IL_POLICY_BEAN.getPOL_REPL_POLICY_YN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/* End */
	/*
	 * Added by saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan
	 * COMMENTS on 26-01-2017
	 */
	public void validatePOL_BNF_ESC_PERC(FacesContext context, UIComponent component, Object value) {
		String CurValue = (String) value;
		try {
			PT_IL_POLICY_BEAN.setPOL_BNF_ESC_PERC(CurValue);
			System.out.println("Benefit escalation rate    :" + PT_IL_POLICY_BEAN.getPOL_BNF_ESC_PERC());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatePOL_ANN_PAY_PERIOD(FacesContext context, UIComponent component, Object value) {
		String CurValue = (String) value;
		try {

			PT_IL_POLICY_BEAN.setPOL_ANN_PAY_PERIOD(CurValue);
			System.out.println("Annuity payout period     :" + PT_IL_POLICY_BEAN.getPOL_ANN_PAY_PERIOD());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/* End */

	/* added by raja on 05-03-2017 for ssp call id - ZBILQC-1719062 */

	private HtmlCommandLink COMP_ASSU_COMMAND_LINK;
	private HtmlCommandLink COMP_CUST_COMMAND_LINK;

	private HtmlCommandButton COMP_CUST_BUTTON;
	private HtmlCommandButton COMP_ASSU_BUTTON;

	public HtmlCommandLink getCOMP_ASSU_COMMAND_LINK() {
		return COMP_ASSU_COMMAND_LINK;
	}

	public void setCOMP_ASSU_COMMAND_LINK(HtmlCommandLink cOMP_ASSU_COMMAND_LINK) {
		COMP_ASSU_COMMAND_LINK = cOMP_ASSU_COMMAND_LINK;
	}

	public HtmlCommandLink getCOMP_CUST_COMMAND_LINK() {
		return COMP_CUST_COMMAND_LINK;
	}

	public void setCOMP_CUST_COMMAND_LINK(HtmlCommandLink cOMP_CUST_COMMAND_LINK) {
		COMP_CUST_COMMAND_LINK = cOMP_CUST_COMMAND_LINK;
	}

	public HtmlCommandButton getCOMP_CUST_BUTTON() {
		return COMP_CUST_BUTTON;
	}

	public void setCOMP_CUST_BUTTON(HtmlCommandButton cOMP_CUST_BUTTON) {
		COMP_CUST_BUTTON = cOMP_CUST_BUTTON;
	}

	public HtmlCommandButton getCOMP_ASSU_BUTTON() {
		return COMP_ASSU_BUTTON;
	}

	public void setCOMP_ASSU_BUTTON(HtmlCommandButton cOMP_ASSU_BUTTON) {
		COMP_ASSU_BUTTON = cOMP_ASSU_BUTTON;
	}

	/* end */
	/*
	 * Added saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan
	 * COMMENTS on 13-03-2017
	 */
	private HtmlOutputLabel COMP_POL_ANN_BNF_AMT_LABEL;

	private HtmlInputText COMP_POL_ANN_BNF_AMT;

	public HtmlOutputLabel getCOMP_POL_ANN_BNF_AMT_LABEL() {
		return COMP_POL_ANN_BNF_AMT_LABEL;
	}

	public void setCOMP_POL_ANN_BNF_AMT_LABEL(HtmlOutputLabel cOMP_POL_ANN_BNF_AMT_LABEL) {
		COMP_POL_ANN_BNF_AMT_LABEL = cOMP_POL_ANN_BNF_AMT_LABEL;
	}

	public HtmlInputText getCOMP_POL_ANN_BNF_AMT() {
		return COMP_POL_ANN_BNF_AMT;
	}

	public void setCOMP_POL_ANN_BNF_AMT(HtmlInputText cOMP_POL_ANN_BNF_AMT) {
		COMP_POL_ANN_BNF_AMT = cOMP_POL_ANN_BNF_AMT;
	}

	public void validatePOL_ANN_BNF_AMT(FacesContext context, UIComponent component, Object value) {
		Double CurValue = (Double) value;
		try {
			System.out.println("Welcome to validatePOL_ANN_BNF_AMT");
			PT_IL_POLICY_BEAN.setPOL_ANN_BNF_AMT(CurValue);
			System.out.println("Annuity Benefit amount     :" + PT_IL_POLICY_BEAN.getPOL_ANN_BNF_AMT());
			getPremium_Amt();
			System.out.println("getPremium_Amt value  :" + getPREM_AMT());
			PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(getPREM_AMT());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public String Unit_link_typ;

	public String getUnit_link_typ() {
		return Unit_link_typ;
	}

	public void setUnit_link_typ(String unit_link_typ) {
		Unit_link_typ = unit_link_typ;
	}

	public void Unit_link_typ() {
		String Unit_link_typ1 = null;
		Connection connection = null;
		ResultSet rs = null;
		String query = "SELECT PROD_UNIT_LINK_TYPE FROM PM_IL_PRODUCT where PROD_CODE=? ";
		try {

			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
			if (rs.next()) {
				Unit_link_typ1 = rs.getString(1);
			}
			setUnit_link_typ(Unit_link_typ1);
			System.out.println("setUnit_link_typ  :" + getUnit_link_typ());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Double PREM_AMT;

	public Double getPREM_AMT() {
		return PREM_AMT;
	}

	public void setPREM_AMT(Double pREM_AMT) {
		PREM_AMT = pREM_AMT;
	}

	public void getPremium_Amt() throws Exception {

		String CURSOR_C1 = "select P9ILPK_POLICY_NR.F_CALC_EDU_UL_SA(?,?) from dual";
		ResultSet resultSet = null;
		Connection connection = null;
		Double Premium_Amt = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			System.out.println("Annuity Amount   :" + PT_IL_POLICY_BEAN.getPOL_ANN_BNF_AMT());
			System.out.println("policy_term  :" + PT_IL_POLICY_BEAN.getPOL_PERIOD());
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_ANN_BNF_AMT(), PT_IL_POLICY_BEAN.getPOL_PERIOD() });
			if (resultSet.next()) {
				Premium_Amt = resultSet.getDouble(1);
				setPREM_AMT(Premium_Amt);
				System.out.println("Premium_Amt  :" + getPREM_AMT());
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		}

	}

	/* End */

	/* ADDED BY SANKARA NARAYANAN FOR ZBILQC-1721052 ON 27-03-2017 */
	private HtmlOutputLabel COMP_POL_DISPATCH_MTD_LABEL;

	private HtmlSelectOneMenu COMP_POL_DISPATCH_MTD;

	private HtmlOutputLabel COMP_POL_DISPATCH_DT_LABEL;

	private HtmlCalendar COMP_POL_DISPATCH_DT;
	private HtmlOutputLabel COMP_POL_DOC_ACK_DT_LABEL;

	private HtmlCalendar COMP_POL_DOC_ACK_DT;

	private List<SelectItem> listPOL_DISPATCH_MTD = new ArrayList<SelectItem>();

	public List<SelectItem> getListPOL_DISPATCH_MTD() {
		return listPOL_DISPATCH_MTD;
	}

	public void setListPOL_DISPATCH_MTD(List<SelectItem> listPOL_DISPATCH_MTD) {
		this.listPOL_DISPATCH_MTD = listPOL_DISPATCH_MTD;
	}

	public HtmlOutputLabel getCOMP_POL_DISPATCH_MTD_LABEL() {
		return COMP_POL_DISPATCH_MTD_LABEL;
	}

	public void setCOMP_POL_DISPATCH_MTD_LABEL(HtmlOutputLabel cOMP_POL_DISPATCH_MTD_LABEL) {
		COMP_POL_DISPATCH_MTD_LABEL = cOMP_POL_DISPATCH_MTD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_DISPATCH_MTD() {
		return COMP_POL_DISPATCH_MTD;
	}

	public void setCOMP_POL_DISPATCH_MTD(HtmlSelectOneMenu cOMP_POL_DISPATCH_MTD) {
		COMP_POL_DISPATCH_MTD = cOMP_POL_DISPATCH_MTD;
	}

	public HtmlOutputLabel getCOMP_POL_DISPATCH_DT_LABEL() {
		return COMP_POL_DISPATCH_DT_LABEL;
	}

	public void setCOMP_POL_DISPATCH_DT_LABEL(HtmlOutputLabel cOMP_POL_DISPATCH_DT_LABEL) {
		COMP_POL_DISPATCH_DT_LABEL = cOMP_POL_DISPATCH_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_DISPATCH_DT() {
		return COMP_POL_DISPATCH_DT;
	}

	public void setCOMP_POL_DISPATCH_DT(HtmlCalendar cOMP_POL_DISPATCH_DT) {
		COMP_POL_DISPATCH_DT = cOMP_POL_DISPATCH_DT;
	}

	public HtmlOutputLabel getCOMP_POL_DOC_ACK_DT_LABEL() {
		return COMP_POL_DOC_ACK_DT_LABEL;
	}

	public void setCOMP_POL_DOC_ACK_DT_LABEL(HtmlOutputLabel cOMP_POL_DOC_ACK_DT_LABEL) {
		COMP_POL_DOC_ACK_DT_LABEL = cOMP_POL_DOC_ACK_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_DOC_ACK_DT() {
		return COMP_POL_DOC_ACK_DT;
	}

	public void setCOMP_POL_DOC_ACK_DT(HtmlCalendar cOMP_POL_DOC_ACK_DT) {
		COMP_POL_DOC_ACK_DT = cOMP_POL_DOC_ACK_DT;
	}

	/* END */

	/* Added by sankaranarayanan for ZBILQC-1721052 on 27-03-2017 */

	public void validatePOL_DISPATCH_MTD(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			String Currvalue = ((String) value);
			if ("001".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_SRC_OF_BUS())) {
				if ("A".equalsIgnoreCase(Currvalue)) {
					/*
					 * modified by Ameen on 07-02-2018 for KIC as per SreeRam
					 * sir sugg. throw new
					 * Exception("You can't able to select because you are the Direct Customer"
					 * );
					 */
					throw new Exception("For Direct Customers, Dispatch through Agent is not allowed");
				} else {
					PT_IL_POLICY_BEAN.setPOL_DISPATCH_MTD(Currvalue);
				}
			} else {
				PT_IL_POLICY_BEAN.setPOL_DISPATCH_MTD(Currvalue);
			}

			COMP_POL_DISPATCH_MTD.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	public void validatePOL_DOC_ACK_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date currValue = (Date) value;
		try {

			PT_IL_POLICY_BEAN.setPOL_DOC_ACK_DT(currValue);

			COMP_POL_DOC_ACK_DT.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	public void validatePOL_DISPATCH_DT(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date currValue = (Date) value;
		try {

			PT_IL_POLICY_BEAN.setPOL_DISPATCH_DT(currValue);

			COMP_POL_DISPATCH_DT.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	/* end */

	/*
	 * Added by saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan
	 * COMMENTS on 22-03-2017
	 */
	private HtmlOutputLabel COMP_POL_UL_PREM_CALC_LABEL;

	private HtmlSelectOneMenu COMP_POL_UL_PREM_CALC;

	private List<SelectItem> listPOL_UL_PREM_CALC = new ArrayList<SelectItem>();

	public List<SelectItem> getListPOL_UL_PREM_CALC() {
		return listPOL_UL_PREM_CALC;
	}

	public void setListPOL_UL_PREM_CALC(List<SelectItem> listPOL_UL_PREM_CALC) {
		this.listPOL_UL_PREM_CALC = listPOL_UL_PREM_CALC;
	}

	public HtmlOutputLabel getCOMP_POL_UL_PREM_CALC_LABEL() {
		return COMP_POL_UL_PREM_CALC_LABEL;
	}

	public void setCOMP_POL_UL_PREM_CALC_LABEL(HtmlOutputLabel cOMP_POL_UL_PREM_CALC_LABEL) {
		COMP_POL_UL_PREM_CALC_LABEL = cOMP_POL_UL_PREM_CALC_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_UL_PREM_CALC() {
		return COMP_POL_UL_PREM_CALC;
	}

	public void setCOMP_POL_UL_PREM_CALC(HtmlSelectOneMenu cOMP_POL_UL_PREM_CALC) {
		COMP_POL_UL_PREM_CALC = cOMP_POL_UL_PREM_CALC;
	}

	public void validatePOL_UL_PREM_CALC(FacesContext context, UIComponent component, Object value) {
		String CurValue = (String) value;
		try {
			PT_IL_POLICY_BEAN.setPOL_UL_PREM_CALC(CurValue);
			// PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(getPREM_AMT());

			/*
			 * Modified by Janani on 25.06.2018 for FSD_IL_FLA_006_Monetary
			 * Endorsement Module
			 */

			// setPremiumCalculationType();
			if (getAgentPremiumType().equalsIgnoreCase("C")) {
				setPremiumCalculationType();
			} else {
				PremSAcheck();
			}

			/* End */
			Unit_link_typ();
			String Unit_link_typ = getUnit_link_typ();
			if ((!"NA".equalsIgnoreCase(Unit_link_typ))
					&& ("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()))) {
				/*
				 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				 * "NOT A VALID OPTION");
				 */
				throw new Exception("NOT A VALID OPTION");
			}
			if (("NA".equalsIgnoreCase(Unit_link_typ))
					&& (!"N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()))) {
				/*
				 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				 * "NOT A VALID OPTION");
				 */
				throw new Exception("NOT A VALID OPTION");
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			/*
			 * Commeneted by Saranya on 07/04/2017
			 * 
			 * getErrorMap().put("Premtype", e.getMessage());
			 * 
			 * End
			 */
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*
	 * public void setPremiumCalculationType() { try {
	 * if("D".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())) {
	 * COMP_POL_FC_MODAL_PREM.setDisabled(false);
	 * COMP_POL_FC_SUM_ASSURED.setDisabled(true);
	 * COMP_POL_ANN_BNF_AMT.setDisabled(true);
	 * PT_IL_POLICY_BEAN.setPOL_ANN_BNF_AMT(null); } else
	 * if("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())){
	 * PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(null);
	 * COMP_POL_FC_MODAL_PREM.setDisabled(true);
	 * COMP_POL_FC_SUM_ASSURED.setDisabled(true);
	 * COMP_POL_ANN_BNF_AMT.setDisabled(false); } else{
	 * COMP_POL_FC_MODAL_PREM.setDisabled(true);
	 * //COMP_POL_FC_SUM_ASSURED.setDisabled(true);
	 * COMP_POL_ANN_BNF_AMT.setDisabled(true); }
	 * 
	 * } catch (Exception e) { throw new ValidatorException(new
	 * FacesMessage(e.getMessage())); } }
	 */

	/* Modified by Saranya on 07/04/2017 */
	public void setPremiumCalculationType() {
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		try {

			/*
			 * Added by saritha on 12-07-2017 for Endowment Product & Education
			 * Product issues
			 */
			if (("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()))
					&& ("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ()))) {
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				/*
				 * Commented by ganesh on 25-07-2017, as per anbarasi suggestion
				 * ZBILQC-1732654
				 */
				PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(null);
				COMP_POL_FC_SUM_ASSURED.resetValue();
				/* end */
				COMP_POL_ANN_BNF_AMT.setDisabled(false);
				COMP_POL_ANN_PAY_PERIOD.setDisabled(false);
				COMP_POL_FC_MODAL_PREM.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(null);
				COMP_POL_FC_MODAL_PREM.resetValue();
				COMP_POL_LC_MODAL_PREM.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_LC_MODAL_PREM(null);
				COMP_POL_LC_MODAL_PREM.resetValue();

			}

			else if (("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()))
					&& ("END".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ()))) {
				COMP_POL_FC_SUM_ASSURED.setDisabled(false);
				COMP_POL_ANN_BNF_AMT.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_ANN_BNF_AMT(null);
				PT_IL_POLICY_BEAN.setPOL_ANN_PAY_PERIOD(null);
				COMP_POL_ANN_PAY_PERIOD.resetValue();
				COMP_POL_FC_MODAL_PREM.setDisabled(true);
				COMP_POL_ANN_BNF_AMT.resetValue();
				COMP_POL_ANN_PAY_PERIOD.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(null);
				COMP_POL_FC_MODAL_PREM.resetValue();
				COMP_POL_LC_MODAL_PREM.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_LC_MODAL_PREM(null);
				COMP_POL_LC_MODAL_PREM.resetValue();

			}

			else if (("D".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())
					&& ("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))) {
				COMP_POL_FC_MODAL_PREM.setDisabled(false);
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				COMP_POL_ANN_BNF_AMT.setDisabled(true);
				/*
				 * Commentted by saritha on 23-08-2017 for Education Product
				 * Issues
				 */
				/*
				 * PT_IL_POLICY_BEAN.setPOL_ANN_BNF_AMT(null);
				 * COMP_POL_ANN_BNF_AMT.resetValue();
				 */
				/* End */

			}

			else if (("D".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())
					&& ("END".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))) {
				COMP_POL_FC_MODAL_PREM.setDisabled(false);
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(null);
				COMP_POL_FC_SUM_ASSURED.resetValue();
				COMP_POL_ANN_BNF_AMT.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_ANN_BNF_AMT(null);
				COMP_POL_ANN_BNF_AMT.resetValue();

			}

			else if (("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())
					&& ("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))
					|| ("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()) && ("END"
							.equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))) {

				COMP_POL_FC_MODAL_PREM.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(null);
				COMP_POL_FC_MODAL_PREM.resetValue();
				COMP_POL_ANN_BNF_AMT.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_ANN_BNF_AMT(null);
				COMP_POL_ANN_BNF_AMT.resetValue();
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(null);
				COMP_POL_FC_SUM_ASSURED.resetValue();
				COMP_POL_LC_MODAL_PREM.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_LC_MODAL_PREM(null);
				COMP_POL_LC_MODAL_PREM.resetValue();

			}

			else {
				/* Modified by Saranya on 12/04/2017 */
				Unit_link_typ();
				if ("F".equals(dummyBean.getUI_M_COVER_SA_CALC())
						&& ("NA".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ()))) {
					COMP_POL_FC_MODAL_PREM.setDisabled(false);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FC_MODAL_PREM().setRequired(true);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_NO_OF_UNIT(0.0);
					COMP_POL_NO_OF_UNIT.setDisabled(true);
					COMP_POL_FC_SUM_ASSURED.setDisabled(true);
					COMP_POL_FC_SUM_ASSURED.setRequired(false);
					COMP_POL_ANN_BNF_AMT.setDisabled(true);
				} else {
					/* End */
					COMP_POL_FC_MODAL_PREM.setDisabled(true);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FC_MODAL_PREM().setRequired(false);

				}
			}
			/* End */

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/* End */

	/*
	 * Added by ameen on 28-03-2017 to default the expiry date to effective from
	 * date
	 */
	public void onLoadEndorsement(PhaseEvent event) throws Exception {

		try {

			/*
			 * Added by ganesh on 06-09-2017, to enable ok button only on
			 * POL_APPRV_STATUS is Approved other than disabled.suggested by
			 * ajoy
			 */
			if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(), "N").equalsIgnoreCase("N")) {
				COMP_UI_M_BUT_ENDT_OK.setDisabled(true);
			} else {
				COMP_UI_M_BUT_ENDT_OK.setDisabled(false);
			}
			/* end */

			PT_IL_POLICY_BEAN.setPOL_END_EFF_TO_DT(PT_IL_POLICY_BEAN.getPOL_EXPIRY_DT());
			System.out.println("ONLOADEND-->" + PT_IL_POLICY_BEAN.getPOL_START_DT() + ","
					+ PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT() + "," + PT_IL_POLICY_BEAN.getPOL_EXPIRY_DT());
			COMP_POL_END_EFF_TO_DT.resetValue();
			/*
			 * Added by ganesh on 30-03-2017 to setting the Endorsement eff.
			 * from date based on the system parameter. 1- set Policy start date
			 * 2- set Next Anniversay Renewal Date
			 */
			endFromDateSysParam = (BigDecimal) CommonUtils.getPPSystemParameterValue("IL_EEFD_DFLT");
			if (endFromDateSysParam.intValue() == 1) {

				PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(PT_IL_POLICY_BEAN.getPOL_START_DT());

			} /*
				 * else if(endFromDateSysParam.intValue() == 2){
				 * 
				 * fetchNextAnniversaryRenewalDate();
				 * 
				 * }
				 */
			// end

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* end */
	/*
	 * Added by ganesh on 30-03-2017 to fetch the next Anniversary Renewal Date.
	 */
	public void fetchNextAnniversaryRenewalDate() throws SQLException, DBException {

		ResultSet rs = null;

		rs = new CRUDHandler().executeSelectStatement(
				"SELECT MAX(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND PC_PREM_TYPE = 'R' AND PC_PAID_FLAG = 'N'",
				CommonUtils.getConnection(), new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
		if (rs.next()) {
			PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(rs.getDate(1));

		} else {

			PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(null);
		}
		System.out.println("fetchNextAnniversaryRenewalDate        " + PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT());

	}
	/* end */

	private BigDecimal endFromDateSysParam;

	/* ADDED BY SANKARA NARAYANAN ON 28/03/2017 */
	public String PROD_RISK_FLG = null;

	public String getPROD_RISK_FLG() {
		return PROD_RISK_FLG;
	}

	public void setPROD_RISK_FLG(String pROD_RISK_FLG) {
		PROD_RISK_FLG = pROD_RISK_FLG;
	}
	/* END */

	// ADDED BY Ram on 13/04/2017
	public void validatePOL_BANK_CODE(FacesContext context, UIComponent component, Object object) {
		try {
			PT_IL_POLICY_BEAN.setPOL_BANK_CODE((String) object);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	// END

	/* Added by ganesh on 14-04-2017 for amendment functionality in proposal */
	private boolean amendmentIndxVisibleFlag = false;

	public boolean isAmendmentIndxVisibleFlag() {
		return amendmentIndxVisibleFlag;
	}

	public void setAmendmentIndxVisibleFlag(boolean amendmentIndxVisibleFlag) {
		this.amendmentIndxVisibleFlag = amendmentIndxVisibleFlag;
	}

	public String callAmendmentModalPanel() throws Exception {

		getCOMP_REPORT_MODAL_PANEL_AMENDMENT().setShowWhenRendered(true);

		return "";

	}

	private HtmlModalPanel COMP_REPORT_MODAL_PANEL_AMENDMENT;

	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL_AMENDMENT() {
		return COMP_REPORT_MODAL_PANEL_AMENDMENT;
	}

	public void setCOMP_REPORT_MODAL_PANEL_AMENDMENT(HtmlModalPanel cOMP_REPORT_MODAL_PANEL_AMENDMENT) {
		COMP_REPORT_MODAL_PANEL_AMENDMENT = cOMP_REPORT_MODAL_PANEL_AMENDMENT;
	}

	public String cancelModalPanelAmendment() {
		getCOMP_REPORT_MODAL_PANEL_AMENDMENT().setShowWhenRendered(false);
		return "";
	}
	/* end */

	public void bankDetailsDefaulting(String submittedPOL_CUST_CODE) {
		System.out.println("conso" + PT_IL_POLICY_BEAN.getPOL_CUST_CODE());
		/*
		 * String qry =
		 * "SELECT CBAD_ACNT_NO, CBAD_BANK_CODE, CBAD_BANK_NAME, CBAD_CITY_CODE, CBAD_DIVISION,CBAD_ACNT_NAME "
		 * +
		 * "FROM PM_CUST_BANK_ACNT_DTLS WHERE CBAD_CUST_CODE = ? AND CBAD_PREF_ACNT_YN = 'Y'"
		 * ;
		 */
		/*
		 * String qry =
		 * "SELECT CBAD_ACNT_NO, CBAD_CUST_BANK_CODE, CBAD_BANK_NAME, CBAD_CITY_CODE, CBAD_DIVISION,CBAD_ACNT_NAME,BANK_NAME,BR_BANK_BRANCH_CODE "
		 * +
		 * "FROM PM_CUST_BANK_ACNT_DTLS,PM_BANK,PM_BANK_BRANCH WHERE CBAD_CUST_CODE = ? AND CBAD_PREF_ACNT_YN = 'Y' "
		 * +
		 * "AND BANK_CODE = CBAD_CUST_BANK_CODE AND BR_BANK_SORT_CODE = CBAD_DIVISION"
		 * ;
		 */

		String qry = "SELECT CBAD_ACNT_NO, CBAD_CUST_BANK_CODE, CBAD_BANK_NAME, CBAD_CITY_CODE, CBAD_DIVISION,CBAD_ACNT_NAME,BANK_NAME,BR_BANK_BRANCH_CODE FROM PM_CUST_BANK_ACNT_DTLS,PM_BANK,PM_BANK_BRANCH WHERE CBAD_CUST_CODE = ? AND CBAD_PREF_ACNT_YN = 'Y'"
				+ "AND (BR_BANK_SORT_CODE = CBAD_DIVISION AND BR_BANK_CODE=CBAD_CUST_BANK_CODE) AND (BANK_CODE=CBAD_CUST_BANK_CODE)";

		String cityDescQry = "SELECT  PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' AND PC_CODE = ? ";
		ResultSet rs = null;
		ResultSet cityDescRS = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(qry, con, new Object[] { submittedPOL_CUST_CODE });
			if (rs.next()) {
				/* Modified by ganesh on 06-11-2017 as suggested by ajoy */
				// PT_IL_POLICY_BEAN.setPOL_CUST_BANK_CODE(rs.getLong("CBAD_ACNT_NO"));
				PT_IL_POLICY_BEAN.setPOL_CUST_BANK_CODE(rs.getString("CBAD_ACNT_NO"));
				/* end */
				PT_IL_POLICY_BEAN.setPOL_CITY_CODE(rs.getString("CBAD_CITY_CODE"));
				cityDescRS = handler.executeSelectStatement(cityDescQry, con,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_CITY_CODE() });
				if (cityDescRS.next()) {
					PT_IL_POLICY_BEAN.setUI_M_CITY_CODE_DESC(cityDescRS.getString("PC_DESC"));
				}
				/*
				 * PT_IL_POLICY_BEAN.setPOL_BANK_CODE(rs.getString(
				 * "CBAD_BANK_CODE"));
				 */
				PT_IL_POLICY_BEAN.setPOL_BANK_CODE(rs.getString("CBAD_CUST_BANK_CODE"));
				PT_IL_POLICY_BEAN.setUI_POL_BANK_DESC(rs.getString("BANK_NAME"));
				PT_IL_POLICY_BEAN.setPOL_BANK_DIVN(rs.getString("CBAD_DIVISION"));
				PT_IL_POLICY_BEAN.setUI_M_ACC_NAME(rs.getString("CBAD_ACNT_NAME"));
				PT_IL_POLICY_BEAN.setUI_M_POL_BANK_DIVN_DESC(rs.getString("BR_BANK_BRANCH_CODE"));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/* Added by Ameen on 21-06-2017 for ZBILQC-1719974 */
	public void nextPremCollDate() {
		String premCollDatQry = "SELECT MIN(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG,'N') <> 'A'";
		ResultSet rs = null;
		try {
			rs = new CRUDHandler().executeSelectStatement(premCollDatQry, CommonUtils.getConnection(),
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs.next()) {
				PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(rs.getDate(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	/* end */

	/* Added by ganesh on 06-07-2017, as suggested by ganesh */
	public void validateDependentEnd() throws Exception {

		System.out.println("Plan Type-->" + getPLAN_TYPE() + "--end code-->" + PT_IL_POLICY_BEAN.getPOL_END_CODE());
		if (CommonUtils.isIN(CommonUtils.nvl(getPLAN_TYPE(), "X"), "L", "H")) {
			String query = "select P9ILPK_F_POLICY.F_FUND_ENDT_VAL(?,?) from dual";
			String function_ret = "";

			ResultSet resultset = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID(), PT_IL_POLICY_BEAN.getPOL_END_CODE() });
			if (resultset.next()) {
				function_ret = resultset.getString(1);
			}

			if (function_ret != null && function_ret.equalsIgnoreCase("N")) {
				throw new Exception("Remaining policy term is less than 10 years; adding dependant is not allowed");
			}
		}

	}
	/* end */

	/*
	 * Added by saritha on 12-07-2017 for Endowment Product & Education Product
	 * Issues
	 */
	public void Endow_Product() {
		String Unit_link_typ1 = null;
		Connection connection = null;
		ResultSet rs = null;
		String query = "SELECT PROD_UNIT_LINK_TYPE FROM PM_IL_PRODUCT where PROD_CODE=? ";
		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
			if (rs.next()) {
				Unit_link_typ1 = rs.getString(1);
			}
			setUnit_link_typ(Unit_link_typ1);
			System.out.println("setendoweduproduct  :" + getUnit_link_typ());
			/*
			 * Commented and Modified by ganesh on 25-07-2017, as per andbarasi
			 * suggestion ZBILQC-1732654
			 */
			/*
			 * if(("U".equals(getPLAN_TYPE()))&&("END".equals(getUnit_link_typ()
			 * ))){ PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED(PT_IL_POLICY_BEAN.
			 * getPOL_FC_SUM_ASSURED());
			 * 
			 * }
			 */

			if (("U".equals(getPLAN_TYPE()) && ("END".equals(getUnit_link_typ())))
					|| ("U".equals(getPLAN_TYPE()) && ("EDU".equals(getUnit_link_typ())))) {
				/*
				 * MODIFIED BY AMEEN FOR KIC AS PER SIVA SUGG.
				 * PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED(PT_IL_POLICY_BEAN.
				 * getPOL_FC_SUM_ASSURED());
				 */
				PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED(
						PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED() * PT_IL_POLICY_BEAN.getPOL_SA_EXCH_RATE());
				/*
				 * Commented by saritha on 12-08-2017 for Endowment Product &
				 * Education Product Issues
				 */
				// COMP_POL_LC_SUM_ASSURED.resetValue();
				/* End */

			}
			/* end */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* End */

	private HtmlOutputText COMP_ANNUITY_MANDATORY;

	public HtmlOutputText getCOMP_ANNUITY_MANDATORY() {
		return COMP_ANNUITY_MANDATORY;
	}

	public void setCOMP_ANNUITY_MANDATORY(HtmlOutputText cOMP_ANNUITY_MANDATORY) {
		COMP_ANNUITY_MANDATORY = cOMP_ANNUITY_MANDATORY;
	}

	/* Added by saritha on 20-07-2017 for ssp call id ZBILQC-1732158 */
	private HtmlOutputLabel COMP_POL_LAPS_OVR_FRM_DT_LABEL;
	private HtmlCalendar COMP_POL_LAPS_OVR_FRM_DT;

	public HtmlOutputLabel getCOMP_POL_LAPS_OVR_FRM_DT_LABEL() {
		return COMP_POL_LAPS_OVR_FRM_DT_LABEL;
	}

	public void setCOMP_POL_LAPS_OVR_FRM_DT_LABEL(HtmlOutputLabel cOMP_POL_LAPS_OVR_FRM_DT_LABEL) {
		COMP_POL_LAPS_OVR_FRM_DT_LABEL = cOMP_POL_LAPS_OVR_FRM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_LAPS_OVR_FRM_DT() {
		return COMP_POL_LAPS_OVR_FRM_DT;
	}

	public void setCOMP_POL_LAPS_OVR_FRM_DT(HtmlCalendar cOMP_POL_LAPS_OVR_FRM_DT) {
		COMP_POL_LAPS_OVR_FRM_DT = cOMP_POL_LAPS_OVR_FRM_DT;
	}

	/* End */

	/*
	 * Added by saritha on 01-08-2017 for Endowment Product & Education Product
	 * issues
	 */
	public void setPremiumCalcType() {
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		try {

			if (("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()))
					&& ("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ()))) {
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				COMP_POL_ANN_BNF_AMT.setDisabled(false);
				COMP_POL_ANN_PAY_PERIOD.setDisabled(false);
				COMP_POL_FC_MODAL_PREM.setDisabled(true);
				COMP_POL_LC_MODAL_PREM.setDisabled(true);

			}
			/*
			 * Added freezeflag condition by ganesh on 09-11-2017 to avoid
			 * enabling sum assured field for end product
			 */
			else if (("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()))
					&& ("END".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ()))
					&& "N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
				COMP_POL_FC_SUM_ASSURED.setDisabled(false);
				COMP_POL_ANN_BNF_AMT.setDisabled(true);
				COMP_POL_FC_MODAL_PREM.setDisabled(true);
				COMP_POL_ANN_PAY_PERIOD.setDisabled(true);
				COMP_POL_LC_MODAL_PREM.setDisabled(true);

			}

			else if (("D".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())
					&& ("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))) {
				COMP_POL_FC_MODAL_PREM.setDisabled(false);
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				COMP_POL_ANN_BNF_AMT.setDisabled(true);

			}
			/*
			 * Added freezeflag condition by ganesh on 09-11-2017 to avoid
			 * enabling sum assured field for end product
			 */
			else if (("D".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())
					&& ("END".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))
					&& "N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {

				COMP_POL_FC_MODAL_PREM.setDisabled(false);
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				COMP_POL_ANN_BNF_AMT.setDisabled(true);

			}

			else if (("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())
					&& ("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))
					|| ("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()) && ("END"
							.equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))) {

				COMP_POL_FC_MODAL_PREM.setDisabled(true);
				COMP_POL_ANN_BNF_AMT.setDisabled(true);
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				COMP_POL_LC_MODAL_PREM.setDisabled(true);

			}

			else {

				Unit_link_typ();
				if ("F".equals(dummyBean.getUI_M_COVER_SA_CALC())
						&& ("NA".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ()))) {
					COMP_POL_FC_MODAL_PREM.setDisabled(false);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FC_MODAL_PREM().setRequired(true);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_NO_OF_UNIT(0.0);
					COMP_POL_NO_OF_UNIT.setDisabled(true);
					COMP_POL_FC_SUM_ASSURED.setDisabled(true);
					COMP_POL_FC_SUM_ASSURED.setRequired(false);
					COMP_POL_ANN_BNF_AMT.setDisabled(true);
				} else {
					/*
					 * if condition added by Ameen on 25-10-2019 for SARWA sugg.
					 * by Sivaram
					 */
					if ("U".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())) {
						COMP_POL_FC_MODAL_PREM.setDisabled(false);
					} else {
						COMP_POL_FC_MODAL_PREM.setDisabled(true);
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FC_MODAL_PREM().setRequired(false);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/* End */

	/* added by Ameen on 07-08-2017 for ZBILQC-1731155 */
	public String custErrCode(String errMsg, String CompId) {
		String finalMgs = "";
		FacesContext fc = FacesContext.getCurrentInstance();
		String labelName = ErrorHelpUtil.findFieldName(fc, CompId);
		System.out.println("labelname------>" + labelName);
		finalMgs = labelName + " : " + errMsg;
		return finalMgs;
	}
	/* End */

	/*
	 * Added by saritha on 17-08-2017 for ssp call id ZBILQC-1735415 as per
	 * Thiag sir sugg
	 */
	private HtmlCommandLink COMP_POL_QUESTIONAIRE;

	public HtmlCommandLink getCOMP_POL_QUESTIONAIRE() {
		return COMP_POL_QUESTIONAIRE;
	}

	public void setCOMP_POL_QUESTIONAIRE(HtmlCommandLink cOMP_POL_QUESTIONAIRE) {
		COMP_POL_QUESTIONAIRE = cOMP_POL_QUESTIONAIRE;
	}

	private HtmlCommandButton COMP_POL_QUESTIONAIRE_BUTTON;

	public HtmlCommandButton getCOMP_POL_QUESTIONAIRE_BUTTON() {
		return COMP_POL_QUESTIONAIRE_BUTTON;
	}

	public void setCOMP_POL_QUESTIONAIRE_BUTTON(HtmlCommandButton cOMP_POL_QUESTIONAIRE_BUTTON) {
		COMP_POL_QUESTIONAIRE_BUTTON = cOMP_POL_QUESTIONAIRE_BUTTON;
	}

	public void enableDisable_FinancialQuest_Link() throws Exception {

		Connection connection = null;
		ResultSet resultSet = null;
		String C1 = "SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE UPPER(DTLS_TODO_LIST_ITEM) LIKE '%FINANCIAL%' AND "
				+ "DTLS_POL_SYS_ID = ? AND NVL(DTLS_MANDATORY_YN,'N') = 'Y'";
		try {
			connection = CommonUtils.getConnection();

			resultSet = new CRUDHandler().executeSelectStatement(C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultSet.next()) {
				System.out.println("Financial Questionaire--->");
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_QUESTIONAIRE().setDisabled(false);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_QUESTIONAIRE_BUTTON().setDisabled(false);

			} else {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_QUESTIONAIRE().setDisabled(true);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_QUESTIONAIRE_BUTTON().setDisabled(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

	}
	/* End */

	/* added by raja on 22-08-2017 for mop endorsement */

	private HtmlOutputLabel COMP_UI_M_MOP_END_LABEL;
	private HtmlSelectOneMenu COMP_UI_M_MOP_END;

	public HtmlOutputLabel getCOMP_UI_M_MOP_END_LABEL() {
		return COMP_UI_M_MOP_END_LABEL;
	}

	public void setCOMP_UI_M_MOP_END_LABEL(HtmlOutputLabel cOMP_UI_M_MOP_END_LABEL) {
		COMP_UI_M_MOP_END_LABEL = cOMP_UI_M_MOP_END_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_MOP_END() {
		return COMP_UI_M_MOP_END;
	}

	public void setCOMP_UI_M_MOP_END(HtmlSelectOneMenu cOMP_UI_M_MOP_END) {
		COMP_UI_M_MOP_END = cOMP_UI_M_MOP_END;
	}

	private List<SelectItem> listPOL_MOP_END = new ArrayList<SelectItem>();

	public List<SelectItem> getListPOL_MOP_END() {
		return listPOL_MOP_END;
	}

	public void setListPOL_MOP_END(List<SelectItem> listPOL_MOP_END) {
		this.listPOL_MOP_END = listPOL_MOP_END;
	}

	/* Added by Sivarajan on 12-08-2018 for KICLIFEQC-1761314 */
	private List<SelectItem> listENDORSEMENT_TYPE = new ArrayList<SelectItem>();

	public List<SelectItem> getListENDORSEMENT_TYPE() {
		return listENDORSEMENT_TYPE;
	}

	public void setListENDORSEMENT_TYPE(List<SelectItem> listENDORSEMENT_TYPE) {
		this.listENDORSEMENT_TYPE = listENDORSEMENT_TYPE;
	}
	// END

	public void validateUI_M_MOP_END(FacesContext context, UIComponent component, Object object) {
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		try {
			PT_IL_POLICY_BEAN.setUI_M_MOP_END((String) object);

			if (PT_IL_POLICY_BEAN.getUI_M_MOP_END() != null
					&& PT_IL_POLICY_BEAN.getUI_M_MOP_END().equalsIgnoreCase("A")) {
				throw new Exception("Please select Mode of Payment");
			}

			if (PT_IL_POLICY_BEAN.getPOL_MODE_OF_PYMT().equalsIgnoreCase(PT_IL_POLICY_BEAN.getUI_M_MOP_END())) {
				throw new Exception("Policy Existing MOP and current MOP should be different");
			}

			if (PT_IL_POLICY_BEAN.getPOL_END_TYPE() != null
					&& PT_IL_POLICY_BEAN.getPOL_END_TYPE().equalsIgnoreCase("007")) {
				list = pkg_pilt002_apac.P_MOP_EFF_DT_VAL(PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
						PT_IL_POLICY_BEAN.getUI_M_MOP_END(), null);

				PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT((Date) list.get(0).getValueObject());
				System.out.println("eff. fm .date ---->" + PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT());
				COMP_POL_END_EFF_FROM_DT.resetValue();

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/* added by sivarajan on 12-08-2018 for KICLIFEQC-1761314 */
	public void validatePOL_END_EFF_TYPE(FacesContext context, UIComponent component, Object object) {
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		try {
			PT_IL_POLICY_BEAN.setPOL_END_EFF_TYPE((String) object);
			PKG_PILT002_APAC pkg_pilt002_apacnew = new PKG_PILT002_APAC();
			Object pValue = null;
			list = pkg_pilt002_apacnew.P_END_EFF_DT(PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
					PT_IL_POLICY_BEAN.getPOL_END_DT(), PT_IL_POLICY_BEAN.getPOL_END_EFF_TYPE(), null);
			if (list != null && list.size() > 0) {
				pValue = list.get(0).getValueObject();
				Date curDate = (Date) pValue;
				PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(curDate);
			}
			System.out
					.println("getPOL_END_EFF_FROM_DT                   " + PT_IL_POLICY_BEAN.getPOL_END_EFF_FROM_DT());
			COMP_POL_END_EFF_FROM_DT.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	// end

	private static List<SelectItem> getExternalTableItemValue() throws Exception {
		List<SelectItem> listItemValues = null;
		String query = "SELECT LIV_CODE,LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM ='MOP_END'";
		// Object[] values = {formName, blockName, fieldName, "Y"};
		CRUDHandler handler = new CRUDHandler();

		try {
			listItemValues = new ArrayList<SelectItem>();
			Connection connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection);
			while (rst.next()) {
				listItemValues.add(new SelectItem(rst.getString("LIV_CODE"), rst.getString("LIV_CODE_DESC")));
			}
			rst.close();
			rst.getStatement().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listItemValues;
	}

	/* end */

	// Added by Sivarajan on 12-08-2018 for KICLIFEQC-1761314
	private static List<SelectItem> getLIV_CODE() throws Exception {
		List<SelectItem> listItemValues = null;
		String query = "SELECT LIV_CODE,LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM IN ('IL_END_DF_DT') AND LIV_REQD_YN = 'Y'";
		// Object[] values = {formName, blockName, fieldName, "Y"};
		CRUDHandler handler = new CRUDHandler();

		try {
			listItemValues = new ArrayList<SelectItem>();
			Connection connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection);
			while (rst.next()) {
				listItemValues.add(new SelectItem(rst.getString("LIV_CODE"), rst.getString("LIV_CODE_DESC")));
			}
			rst.close();
			rst.getStatement().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listItemValues;
	}

	public boolean printEnableDisable() {

		boolean check = false;
		String ds_type = "";
		if ("1".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())) {
			ds_type = "PRO";
		} else {
			ds_type = "POL";
		}
		String printQry = "SELECT 'X' FROM PM_REP_TAB_DTL WHERE PMLIT_FORM_ID = 'PILT002_APAC' AND PMLIT_BLOCK_ID = 'PT_IL_POLICY'"
				+ " AND PMLIT_PROD_CODE LIKE ? AND PMILT_ADDL_STS LIKE ? AND SYS_PARAM = ? AND ITEM_NAME = ?";

		ResultSet rs = null;
		try {
			rs = new CRUDHandler().executeSelectStatement(printQry, CommonUtils.getConnection(),
					new Object[] { "%" + PT_IL_POLICY_BEAN.getPOL_PROD_CODE() + "%",
							"%" + PT_IL_POLICY_BEAN.getPOL_ADDL_STATUS() + "%", PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(),
							ds_type });
			if (rs.next()) {
				check = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return check;
	}

	/* Added by saritha on 08-09-2017 */
	private HtmlOutputText COMP_POL_LAPS_OVR_FM_DT;
	private HtmlOutputText COMP_POL_LAPS_OVR_TO_DT;

	public HtmlOutputText getCOMP_POL_LAPS_OVR_FM_DT() {
		return COMP_POL_LAPS_OVR_FM_DT;
	}

	public void setCOMP_POL_LAPS_OVR_FM_DT(HtmlOutputText cOMP_POL_LAPS_OVR_FM_DT) {
		COMP_POL_LAPS_OVR_FM_DT = cOMP_POL_LAPS_OVR_FM_DT;
	}

	public HtmlOutputText getCOMP_POL_LAPS_OVR_TO_DT() {
		return COMP_POL_LAPS_OVR_TO_DT;
	}

	public void setCOMP_POL_LAPS_OVR_TO_DT(HtmlOutputText cOMP_POL_LAPS_OVR_TO_DT) {
		COMP_POL_LAPS_OVR_TO_DT = cOMP_POL_LAPS_OVR_TO_DT;
	}
	/* End */

	/* Added by saritha on 03-10-2017 for Lapsation Override */
	public String Lap_ovr_sys_param;

	public String getLap_ovr_sys_param() {
		return Lap_ovr_sys_param;
	}

	public void setLap_ovr_sys_param(String lap_ovr_sys_param) {
		Lap_ovr_sys_param = lap_ovr_sys_param;
	}

	public void Lap_ovr_sys_param() {
		String PS_CODE_VALUE = null;
		Connection connection = null;
		ResultSet rs = null;
		String query = "SELECT PS_CODE FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_LAPOV_END'";
		try {

			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection);
			if (rs.next()) {
				PS_CODE_VALUE = rs.getString(1);
			}
			setLap_ovr_sys_param(PS_CODE_VALUE);
			System.out.println("Lap_ovr_sys_param  :" + getLap_ovr_sys_param());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* End */

	/* Added by saritha on 27-10-2017 for ssp call id ZBLIFE-1449063 */
	private HtmlOutputLabel COMP_POL_CUST_EMP_NO_LABEL;
	private HtmlInputText COMP_POL_CUST_EMP_NO;

	public HtmlOutputLabel getCOMP_POL_CUST_EMP_NO_LABEL() {
		return COMP_POL_CUST_EMP_NO_LABEL;
	}

	public void setCOMP_POL_CUST_EMP_NO_LABEL(HtmlOutputLabel cOMP_POL_CUST_EMP_NO_LABEL) {
		COMP_POL_CUST_EMP_NO_LABEL = cOMP_POL_CUST_EMP_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_CUST_EMP_NO() {
		return COMP_POL_CUST_EMP_NO;
	}

	public void setCOMP_POL_CUST_EMP_NO(HtmlInputText cOMP_POL_CUST_EMP_NO) {
		COMP_POL_CUST_EMP_NO = cOMP_POL_CUST_EMP_NO;
	}

	public void validatePOL_CUST_EMP_NO(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_CUST_EMP_NO((String) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CUST_EMP_NO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatorAjaxPOL_CUST_EMP_NO(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		System.out.println(value);
		PT_IL_POLICY_BEAN.setPOL_CUST_EMP_NO(value);
		setEmployee_No(value);
		/* Added by Ameen on 30-10-2017 for Bank details defaulting issue */
		if ("AD".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE())
				|| "BS".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_PYMT_TYPE())) {
			PT_IL_POLICY_BEAN.setPOL_EMPLOYER_CODE(PT_IL_POLICY_BEAN.getPOL_BANK_CODE());
			PT_IL_POLICY_BEAN.setUI_M_CONT_NAME(PT_IL_POLICY_BEAN.getUI_POL_BANK_DESC());
			COMP_POL_EMPLOYER_CODE.resetValue();
			COMP_UI_M_CONT_NAME.resetValue();
		}
		/* End */
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void setEmployee_No(String value) {
		Connection connection = null;
		ResultSet resultSet = null;
		String Emp_No = null;
		String empCode = null;

		try {

			connection = CommonUtils.getConnection();
			String query = "SELECT CUST_FLEX_02,CUST_EMPLOYER_CODE FROM PM_CUSTOMER WHERE CUST_CODE = ?";

			System.out.println("pol_cust_code    " + PT_IL_POLICY_BEAN.getPOL_CUST_CODE());
			Object[] pol_cust_code = { PT_IL_POLICY_BEAN.getPOL_CUST_CODE() };
			resultSet = new CRUDHandler().executeSelectStatement(query, connection, pol_cust_code);
			if (resultSet.next()) {
				Emp_No = resultSet.getString("CUST_FLEX_02");
				empCode = resultSet.getString("CUST_EMPLOYER_CODE");
			}

			/*
			 * Modified by Janani on 27.06.2018 for FLA as per Chandramohan
			 * sugges
			 */
			// if(Emp_No!=null && "S".equalsIgnoreCase(value))
			if (Emp_No != null && ("S".equalsIgnoreCase(value) || "AO".equalsIgnoreCase(value)))

			/* End */
			{
				PT_IL_POLICY_BEAN.setPOL_CUST_EMP_NO(Emp_No);
			} else {
				PT_IL_POLICY_BEAN.setPOL_CUST_EMP_NO(null);

			}

			/*
			 * Modified by Janani on 27.06.2018 for FLA as per Chandramohan
			 * sugges
			 */
			// if(empCode!=null && "S".equalsIgnoreCase(value))
			if (empCode != null && ("S".equalsIgnoreCase(value) || "AO".equalsIgnoreCase(value)))

			/* End */
			{
				PT_IL_POLICY_BEAN.setPOL_EMPLOYER_CODE(empCode);
			} else {
				PT_IL_POLICY_BEAN.setPOL_EMPLOYER_CODE(null);

			}
			COMP_POL_EMPLOYER_CODE.resetValue();
			COMP_POL_CUST_EMP_NO.resetValue();

		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/* End */

	/* Added by Ameen on 30-10-2017 for Bank details defaulting issue */

	private HtmlOutputLabel COMP_UI_M_ACC_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ACC_NAME;

	private HtmlInputText COMP_UI_M_POL_BANK_DIVN_DESC;

	public HtmlOutputLabel getCOMP_UI_M_ACC_NAME_LABEL() {
		return COMP_UI_M_ACC_NAME_LABEL;
	}

	public void setCOMP_UI_M_ACC_NAME_LABEL(HtmlOutputLabel cOMP_UI_M_ACC_NAME_LABEL) {
		COMP_UI_M_ACC_NAME_LABEL = cOMP_UI_M_ACC_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACC_NAME() {
		return COMP_UI_M_ACC_NAME;
	}

	public void setCOMP_UI_M_ACC_NAME(HtmlInputText cOMP_UI_M_ACC_NAME) {
		COMP_UI_M_ACC_NAME = cOMP_UI_M_ACC_NAME;
	}

	public HtmlInputText getCOMP_UI_M_POL_BANK_DIVN_DESC() {
		return COMP_UI_M_POL_BANK_DIVN_DESC;
	}

	public void setCOMP_UI_M_POL_BANK_DIVN_DESC(HtmlInputText cOMP_UI_M_POL_BANK_DIVN_DESC) {
		COMP_UI_M_POL_BANK_DIVN_DESC = cOMP_UI_M_POL_BANK_DIVN_DESC;
	}

	public void validatorUI_M_ACC_NAME(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setUI_M_ACC_NAME((String) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	public void validatorPOL_CUST_BANK_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			/* Modified by ganesh on 06-11-2017 as suggested by ajoy */
			// PT_IL_POLICY_BEAN.setPOL_CUST_BANK_CODE((Long) value);
			PT_IL_POLICY_BEAN.setPOL_CUST_BANK_CODE((String) value);
			/* end */

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}

	}

	/* Commented by ganesh on 02-11-2017 as suggested by ganesh */
	/*
	 * public void bankAccDtlsCheck(){ String qry =
	 * "SELECT 'X' FROM PM_CUST_BANK_ACNT_DTLS WHERE CBAD_CUST_CODE = ? AND CBAD_ACNT_NO = ? AND CBAD_ACNT_NAME = ?"
	 * ; ResultSet rs = null; try {
	 * 
	 * rs = new CRUDHandler().executeSelectStatement(qry,
	 * CommonUtils.getConnection(), new
	 * Object[]{PT_IL_POLICY_BEAN.getPOL_PREM_PAYER_CODE(),PT_IL_POLICY_BEAN.
	 * getPOL_CUST_BANK_CODE(),PT_IL_POLICY_BEAN.getUI_M_ACC_NAME()});
	 * if(!rs.next()){ throw new
	 * Exception("Bank Dtls:Invalid Account Number and Account Name"); }
	 * 
	 * } catch (Exception exception) { exception.printStackTrace(); throw new
	 * ValidatorException(new FacesMessage(exception .getMessage())); } }
	 */
	/* end */
	public ArrayList<LovBean> lovBANK_DIVN_DESC(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PT_IL_POLICY_BEAN.getPOL_BANK_CODE(), PELConstants.suggetionRecordSize };

				query = "SELECT BR_BANK_SORT_CODE,BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH WHERE BR_BANK_CODE = ? AND ROWNUM <= ? ORDER BY 1";
			} else {
				object = new Object[] { PT_IL_POLICY_BEAN.getPOL_BANK_CODE(), code + "%", code + "%",
						PELConstants.suggetionRecordSize };

				query = "SELECT BR_BANK_SORT_CODE,BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH WHERE BR_BANK_CODE = ? AND"
						+ "(UPPER(BR_BANK_SORT_CODE) LIKE UPPER(?) OR UPPER(BR_BANK_BRANCH_CODE) LIKE UPPER(?)) AND ROWNUM <= ? ORDER BY 1";
				/* End */
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	/* End */
	public void fireFieldValidationPOL_CUST_CODE(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		bankDetailsDefaulting(value);
		COMP_UI_M_BANK_CODE.resetValue();
		COMP_UI_M_BRANCH_CODE.resetValue();
		COMP_POL_CUST_BANK_CODE.resetValue();
		COMP_UI_M_ACC_NAME.resetValue();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void fireFieldValidationPOL_DIVISION(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		defaultAccNoName(value);
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/* Added by Ameen on 30-10-2017 for Bank details defaulting issue */
	public void defaultAccNoName(String submittedValue) {

		String selectQuery = "SELECT CBAD_ACNT_NO,CBAD_ACNT_NAME FROM PM_CUST_BANK_ACNT_DTLS WHERE CBAD_CUST_BANK_CODE = ? AND CBAD_DIVISION = ? AND  CBAD_CUST_CODE = ?";
		ResultSet rs = null;
		/* End */
		try {
			rs = new CRUDHandler().executeSelectStatement(selectQuery, CommonUtils.getConnection(), new Object[] {
					PT_IL_POLICY_BEAN.getPOL_BANK_CODE(), submittedValue, PT_IL_POLICY_BEAN.getPOL_PREM_PAYER_CODE() });
			if (rs.next()) {
				/* Modified by ganesh on 06-11-2017 as suggested by ajoy */
				// PT_IL_POLICY_BEAN.setPOL_CUST_BANK_CODE(rs.getLong("CBAD_ACNT_NO"));
				PT_IL_POLICY_BEAN.setPOL_CUST_BANK_CODE(rs.getString("CBAD_ACNT_NO"));
				PT_IL_POLICY_BEAN.setUI_M_ACC_NAME(rs.getString("CBAD_ACNT_NAME"));
			} else {
				PT_IL_POLICY_BEAN.setPOL_CUST_BANK_CODE(null);
				PT_IL_POLICY_BEAN.setUI_M_ACC_NAME(null);
			}
			COMP_POL_CUST_BANK_CODE.resetValue();
			COMP_UI_M_ACC_NAME.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public String getBranchDesc() throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String desc = null;
		String query = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_BANK_CODE(), PT_IL_POLICY_BEAN.getPOL_BANK_DIVN() });
			if (resultSet.next()) {
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}

	/* Added by ganesh on 03-11-2017 for bank details issue */
	public void fireFieldValidationPOL_PREM_PAYER_CODE(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		bankDetailsDefaulting(value);
		COMP_UI_M_BANK_CODE.resetValue();
		COMP_UI_M_BRANCH_CODE.resetValue();
		COMP_POL_CUST_BANK_CODE.resetValue();
		COMP_UI_M_ACC_NAME.resetValue();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/* end */
	public void fireFieldValidationPOL_PERIOD(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(Integer.valueOf(value));
		COMP_POL_PREM_PAY_YRS.resetValue();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/*
	 * Added by saritha on 21-11-2017 for Due date for debit order by each
	 * policy is required
	 */

	private HtmlOutputLabel COMP_POL_DEBIT_DAY_LABEL;
	private HtmlInputText COMP_POL_DEBIT_DAY;

	public HtmlOutputLabel getCOMP_POL_DEBIT_DAY_LABEL() {
		return COMP_POL_DEBIT_DAY_LABEL;
	}

	public void setCOMP_POL_DEBIT_DAY_LABEL(HtmlOutputLabel cOMP_POL_DEBIT_DAY_LABEL) {
		COMP_POL_DEBIT_DAY_LABEL = cOMP_POL_DEBIT_DAY_LABEL;
	}

	public HtmlInputText getCOMP_POL_DEBIT_DAY() {
		return COMP_POL_DEBIT_DAY;
	}

	public void setCOMP_POL_DEBIT_DAY(HtmlInputText cOMP_POL_DEBIT_DAY) {
		COMP_POL_DEBIT_DAY = cOMP_POL_DEBIT_DAY;
	}

	public void validatorPOL_DEBIT_DAY(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_DEBIT_DAY((Integer) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	/* End */

	/* Added by Ameen on 22-11-2017 for policy term validation */
	public void checkPolTerm() throws Exception {
		String matQry = "SELECT PLAN_MAX_AGE_ON_MAT FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
		ResultSet rs = null;
		int matAge = 0;
		int pol_age = 0;
		/* Added by Janani on 20.06.2018 for FLALIFEQC-1754995 */
		int pol_period = 0;
		/* End */

		try {
			pol_age = PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_AGE() + PT_IL_POLICY_BEAN.getPOL_PERIOD();

			/*
			 * 
			 * COMMENTED BY DHINESH ON 05-06-2018 FOR FLA SSP CALL ID
			 * 
			 * rs = new CRUDHandler().executeSelectStatement(matQry,
			 * CommonUtils.getConnection(),new
			 * Object[]{PT_IL_POLICY_BEAN.getPOL_PROD_CODE()});
			 */

			rs = new CRUDHandler().executeSelectStatement(matQry, CommonUtils.getConnection(),
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
			if (rs.next()) {
				matAge = rs.getInt("PLAN_MAX_AGE_ON_MAT");
			}
			/*
			 * Added and modified by Janani on 20.06.2018 for FLALIFEQC-1754995
			 */
			pol_period = matAge - PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_AGE();

			if (pol_age > matAge) {
				// throw new Exception("Maximum Maturity Age exceeds as per
				// Setup ,Policy Term Should be lesser or equalto : " +
				// PT_IL_POLICY_BEAN.getUI_M_POL_PERIOD());

				throw new Exception(
						"Maximum Maturity Age exceeds as per Setup ,Policy Term Should be lesser or equalto : "
								+ pol_period);
			}

			/* End of FLALIFEQC-1754995 */
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}
	/* End */

	/* Added by saritha */
	public void addCoverRider() throws Exception {
		Connection connection = null;
		ResultSet resultset = null;
		Boolean flag = false;
		String coverCodequery = "SELECT 'X' FROM PM_IL_PLAN,PT_IL_POLICY WHERE PLAN_TYPE IN('L','H') AND PLAN_CODE=POL_PLAN_CODE "
				+ "AND POL_SYS_ID =? UNION SELECT 'X'FROM PT_IL_POL_ADDL_COVER, PM_IL_COVER WHERE POAC_COVER_CODE = COVER_CODE "
				+ "AND COVER_TYPE <> 'B' AND COVER_FUNERAL_CVR_YN = 'Y' AND POAC_POL_SYS_ID = ?";

		try {

			connection = CommonUtils.getConnection();
			resultset = new CRUDHandler().executeSelectStatement(coverCodequery, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID(), PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultset.next()) {
				compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_FUNERAL_MEMB_DTLS");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultset);
		}

	}

	/* End */

	/* Added by Ameen on 24-01-2018 for KIC */
	public void getAssuredDltPanel() {
		String qry = "SELECT CONT_CODE,CONT_NAME,CONT_REF_ID1,CONT_REF_ID2,CONT_DOB,CONT_CATG_CODE,CONT_ADDR1,CONT_ADDR2,"
				+ "CONT_ADDR3,CONT_CITY_CODE,CONT_CITY,CONT_COUNT_CODE,CONT_COUNTRY,CONT_POSTAL_CODE,CONT_MOB_AREA_CODE,"
				+ "CONT_MOBILE_NO,CONT_TEL_AREA_CODE,CONT_PHONE,CONT_FAX_AREA_CODE,CONT_FAX,CONT_EMAIL_ID FROM PM_IL_CONTRACTOR WHERE CONT_CODE = ?";
		String catgQry = "SELECT PS_CODE_DESC FROM PP_SYSTEM1 WHERE PS_TYPE = 'CATG' AND PS_CODE = ?";
		ResultSet rs = null;
		ResultSet catgRS = null;
		try {
			rs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection(),
					new Object[] { PT_IL_POLICY_BEAN.getPOL_CONT_CODE() });
			if (rs.next()) {
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_CODE(rs.getString("CONT_CODE"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_NAME(rs.getString("CONT_NAME"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_REF_ID1(rs.getString("CONT_REF_ID1"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_REF_ID2(rs.getString("CONT_REF_ID2"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_DOB(rs.getDate("CONT_DOB"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_CATG_CODE(rs.getString("CONT_CATG_CODE"));
				catgRS = new CRUDHandler().executeSelectStatement(catgQry, CommonUtils.getConnection(),
						new Object[] { compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
								.getPM_IL_CONTRACTOR_QE_BEAN().getCONT_CATG_CODE() });
				if (catgRS.next()) {
					compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
							.setUI_M_CONT_CATG_CODE_DESC(catgRS.getString("PS_CODE_DESC"));
				}
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_ADDR1(rs.getString("CONT_ADDR1"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_ADDR2(rs.getString("CONT_ADDR2"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_ADDR3(rs.getString("CONT_ADDR3"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_CITY_CODE(rs.getString("CONT_CITY_CODE"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_CITY(rs.getString("CONT_CITY"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_COUNT_CODE(rs.getString("CONT_COUNT_CODE"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_COUNTRY(rs.getString("CONT_COUNTRY"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_POSTAL_CODE(rs.getString("CONT_POSTAL_CODE"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_MOB_AREA_CODE(rs.getString("CONT_MOB_AREA_CODE"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_MOBILE_NO(rs.getString("CONT_MOBILE_NO"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_TEL_AREA_CODE(rs.getString("CONT_TEL_AREA_CODE"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_PHONE(rs.getString("CONT_PHONE"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_FAX_AREA_CODE(rs.getString("CONT_FAX_AREA_CODE"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_FAX(rs.getString("CONT_FAX"));
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getPM_IL_CONTRACTOR_QE_BEAN()
						.setCONT_EMAIL_ID(rs.getString("CONT_EMAIL_ID"));

			}
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_CODE().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_NAME().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_REF_ID1().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_REF_ID2().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_DOB().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_CATG_CODE().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_UI_M_CONT_CATG_CODE_DESC().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_ADDR1().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_ADDR2().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_ADDR3().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_CITY_CODE().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_CITY().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_COUNT_CODE().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_COUNTRY().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_POSTAL_CODE().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_TEL_AREA_CODE2().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_PHONE2().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_TEL_AREA_CODE().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_PHONE().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_FAX_AREA_CODE().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_FAX().resetValue();
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_EMAIL_ID_PER().resetValue();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* End */

	/* ADDED BY Ameen on 29-01-2018 for KIC */

	private List<SelectItem> listPOL_DISPATCH_MTD_ = new ArrayList<SelectItem>();

	boolean officialAddrs = false;

	boolean kicCheck = false;

	public List<SelectItem> getListPOL_DISPATCH_MTD_() {
		return listPOL_DISPATCH_MTD_;
	}

	public void setListPOL_DISPATCH_MTD_(List<SelectItem> listPOL_DISPATCH_MTD_) {
		this.listPOL_DISPATCH_MTD_ = listPOL_DISPATCH_MTD_;
	}

	public boolean isOfficialAddrs() {
		return officialAddrs;
	}

	public void setOfficialAddrs(boolean officialAddrs) {
		this.officialAddrs = officialAddrs;
	}

	public boolean isKicCheck() {
		return kicCheck;
	}

	public void setKicCheck(boolean kicCheck) {
		this.kicCheck = kicCheck;
	}

	/* END */

	/* Added by Janani on 13.03.2018 for FSD_FLA_IL_008 */

	String chkEndCode = null;

	public String getChkEndCode() {
		return chkEndCode;
	}

	public void setChkEndCode(String chkEndCode) {
		this.chkEndCode = chkEndCode;
	}

	public void checkEndCode() throws Exception {
		Connection connection = null;
		ResultSet resultset = null;

		String ps_code = null;
		String query = "SELECT PS_CODE FROM PP_SYSTEM1 WHERE PS_TYPE='IL_FAM_OCC'";

		System.out.println("enters into checkEndCode");

		try {

			connection = CommonUtils.getConnection();
			resultset = new CRUDHandler().executeSelectStatement(query, connection);
			if (resultset.next()) {

				ps_code = resultset.getString("PS_CODE");

				setChkEndCode(ps_code);

				System.out.println("getChkEndCode        " + this.getChkEndCode());
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultset);
		}

	}

	/* End of FSD_FLA_IL_008 */

	/* Added by Janani on 16.03.2018 for KIC Disaptch dtls screen */
	public String approveLinkDisable() throws Exception {
		Connection connection = null;
		ResultSet resultset = null, resultSet1 = null;

		String ps_code = null;

		String query2 = "SELECT PDD_STATUS FROM PT_IL_POL_DISPATCH_DTLS WHERE PDD_POL_SYS_ID = ? AND PDD_CR_DT =(SELECT MAX(PDD_CR_DT) FROM PT_IL_POL_DISPATCH_DTLS WHERE PDD_POL_SYS_ID = ?)";

		System.out.println("enters into approveLinkDisable                    "
				+ compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());

		String pdd_status = null;

		String query1 = "SELECT * FROM PT_IL_POL_DISPATCH_DTLS WHERE PDD_POL_SYS_ID = ?";

		try {

			connection = CommonUtils.getConnection();

			resultset = new CRUDHandler().executeSelectStatement(query1, connection, new Object[] {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });

			if (resultset.next()) {

				resultSet1 = new CRUDHandler().executeSelectStatement(query2, connection,
						new Object[] {
								compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
								compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });

				if (resultSet1.next()) {

					pdd_status = resultSet1.getString("PDD_STATUS");

					System.out.println("status is                 " + pdd_status);

					if (pdd_status.equalsIgnoreCase("DP04")) {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);

					}

					/*
					 * Commentted &Modified by saritha on 23-04-2019 for KIC
					 * (Issue :Reinstatement Endorsement passed approve button
					 * disable) as per siva sir sugg.
					 */

					/*
					 * else if(pdd_status.equalsIgnoreCase("DP03") &&
					 * (compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					 * getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX() == 0))
					 */

					else if (pdd_status.equalsIgnoreCase("DP03")
							&& (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
									.getPOL_END_NO_IDX() == 0)
							|| compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
									.getPOL_END_NO_IDX() > 0) {
						System.out.println("status is Customer received");
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL().setDisabled(false);
					}

					/* End */

					else {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
					}

				}

			} else {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultset);
		}
		return pdd_status;

	}

	public void dispatchDtl_render() throws Exception {
		Connection connection = null;
		ResultSet resultset = null;

		String PS_VALUE = null;
		String query = "SELECT PS_VALUE FROM pp_system1 WHERE ps_type='IL_DISP_HS' ";

		System.out.println("enters into dispatchDtl_render");

		try {

			connection = CommonUtils.getConnection();
			resultset = new CRUDHandler().executeSelectStatement(query, connection);

			System.out.println("getPOL_DS_TYPE            " + PT_IL_POLICY_BEAN.getPOL_DS_TYPE());

			if (resultset.next()) {

				PS_VALUE = resultset.getString("PS_VALUE");

				if (PS_VALUE.equalsIgnoreCase("1")) {

					/*
					 * If and else Added by Janani on 12.10.2018 for KIC Issue :
					 * Disable Dispatch dtls link at Proposal level
					 */

					if (PT_IL_POLICY_BEAN.getPOL_DS_TYPE().equalsIgnoreCase("2")) {

						/* End */
						compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_DISPATCH_DTLS");
					} else {
						compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_DISPATCH_DTLS");
					}
				} else {
					compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_DISPATCH_DTLS");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultset);
		}

	}

	/* ENd */

	/* Added by Janani on 03.04.2018 for KIC Disaptch dtls screen */
	public String getAutoUnderwriting() throws Exception {
		Connection connection = null;
		ResultSet resultset = null, resultSet1 = null;

		String ps_code = null;

		String query1 = "SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";

		String uw_status = null;

		try {

			connection = CommonUtils.getConnection();

			resultSet1 = new CRUDHandler().executeSelectStatement(query1, connection, new Object[] {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE() });

			if (resultSet1.next()) {

				uw_status = resultSet1.getString("PROD_AUTO_UW");

				System.out.println("status is                 " + uw_status);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultset);
		}
		return uw_status;

	}

	/* Added by Ameen on 09-03-2018 for FSD_IL_04_GOLDA */
	private HtmlOutputLabel COMP_POL_REG_EXCESS_PREM_LABEL;

	private HtmlInputText COMP_POL_REG_EXCESS_PREM;

	private HtmlOutputLabel COMP_POL_RETURN_VAL_LABEL;

	private HtmlSelectOneMenu COMP_POL_RETURN_VAL;

	private List<SelectItem> listPOL_RETURN_VAL = new ArrayList<SelectItem>();

	public HtmlOutputLabel getCOMP_POL_REG_EXCESS_PREM_LABEL() {
		return COMP_POL_REG_EXCESS_PREM_LABEL;
	}

	public void setCOMP_POL_REG_EXCESS_PREM_LABEL(HtmlOutputLabel cOMP_POL_REG_EXCESS_PREM_LABEL) {
		COMP_POL_REG_EXCESS_PREM_LABEL = cOMP_POL_REG_EXCESS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_REG_EXCESS_PREM() {
		return COMP_POL_REG_EXCESS_PREM;
	}

	public void setCOMP_POL_REG_EXCESS_PREM(HtmlInputText cOMP_POL_REG_EXCESS_PREM) {
		COMP_POL_REG_EXCESS_PREM = cOMP_POL_REG_EXCESS_PREM;
	}

	public HtmlOutputLabel getCOMP_POL_RETURN_VAL_LABEL() {
		return COMP_POL_RETURN_VAL_LABEL;
	}

	public void setCOMP_POL_RETURN_VAL_LABEL(HtmlOutputLabel cOMP_POL_RETURN_VAL_LABEL) {
		COMP_POL_RETURN_VAL_LABEL = cOMP_POL_RETURN_VAL_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_RETURN_VAL() {
		return COMP_POL_RETURN_VAL;
	}

	public void setCOMP_POL_RETURN_VAL(HtmlSelectOneMenu cOMP_POL_RETURN_VAL) {
		COMP_POL_RETURN_VAL = cOMP_POL_RETURN_VAL;
	}

	public List<SelectItem> getListPOL_RETURN_VAL() {
		return listPOL_RETURN_VAL;
	}

	public void setListPOL_RETURN_VAL(List<SelectItem> listPOL_RETURN_VAL) {
		this.listPOL_RETURN_VAL = listPOL_RETURN_VAL;
	}

	public void validatePOL_REG_EXCESS_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		try {

			/*
			 * Added by Ameen for KIC Endorsement pol_frz_flag issue as per Ajay
			 * sugg. on 05-07-2018
			 */
			double currVal = (Double) value;
			if (PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() != null && PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() > 0
					&& PT_IL_POLICY_BEAN.getPOL_END_TYPE() != null
					&& !"001".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
				if (currVal != PT_IL_POLICY_BEAN.getPOL_REG_EXCESS_PREM()) {
					PT_IL_POLICY_BEAN.setPOL_FLEX_20("N");
					CommonUtils.setGlobalVariable("GLOBAL.FRZ_FLAG", null);
				}
			}
			/* End */

			PT_IL_POLICY_BEAN.setPOL_REG_EXCESS_PREM((Double) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	public void validatePOL_RETURN_VAL(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		try {

			PT_IL_POLICY_BEAN.setPOL_RETURN_VAL((String) value);
			if ("U".equalsIgnoreCase(PLAN_TYPE)) {
				if ("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_RETURN_VAL())) {
					throw new Exception("Please choose valid Type of Return");
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	private HtmlInputText COMP_UI_M_POL_REG_EXCESS_PREM;

	public HtmlInputText getCOMP_UI_M_POL_REG_EXCESS_PREM() {
		return COMP_UI_M_POL_REG_EXCESS_PREM;
	}

	public void setCOMP_UI_M_POL_REG_EXCESS_PREM(HtmlInputText cOMP_UI_M_POL_REG_EXCESS_PREM) {
		COMP_UI_M_POL_REG_EXCESS_PREM = cOMP_UI_M_POL_REG_EXCESS_PREM;
	}

	/* End */

	/* added by Ameen on 24-03-2018 for KIC onsite issue */
	private HtmlOutputLabel COMP_POL_CARD_EXP_DT_LABEL;

	private HtmlCalendar COMP_POL_CARD_EXP_DT;

	private HtmlOutputLabel COMP_POL_CVV_NO_LABEL;

	private HtmlInputText COMP_POL_CVV_NO;

	public HtmlOutputLabel getCOMP_POL_CARD_EXP_DT_LABEL() {
		return COMP_POL_CARD_EXP_DT_LABEL;
	}

	public void setCOMP_POL_CARD_EXP_DT_LABEL(HtmlOutputLabel cOMP_POL_CARD_EXP_DT_LABEL) {
		COMP_POL_CARD_EXP_DT_LABEL = cOMP_POL_CARD_EXP_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_CARD_EXP_DT() {
		return COMP_POL_CARD_EXP_DT;
	}

	public void setCOMP_POL_CARD_EXP_DT(HtmlCalendar cOMP_POL_CARD_EXP_DT) {
		COMP_POL_CARD_EXP_DT = cOMP_POL_CARD_EXP_DT;
	}

	public HtmlOutputLabel getCOMP_POL_CVV_NO_LABEL() {
		return COMP_POL_CVV_NO_LABEL;
	}

	public void setCOMP_POL_CVV_NO_LABEL(HtmlOutputLabel cOMP_POL_CVV_NO_LABEL) {
		COMP_POL_CVV_NO_LABEL = cOMP_POL_CVV_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_CVV_NO() {
		return COMP_POL_CVV_NO;
	}

	public void setCOMP_POL_CVV_NO(HtmlInputText cOMP_POL_CVV_NO) {
		COMP_POL_CVV_NO = cOMP_POL_CVV_NO;
	}

	public void validatePOL_CVV_NO(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_CVV_NO((Integer) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	/* end */

	/* Added by Janani on 26.03.2018 for KIC Credit card issue */
	private HtmlInputText COMP_POL_CARD_EXP_DT_MM;

	private HtmlInputText COMP_POL_CARD_EXP_DT_YY;

	public HtmlInputText getCOMP_POL_CARD_EXP_DT_MM() {
		return COMP_POL_CARD_EXP_DT_MM;
	}

	public void setCOMP_POL_CARD_EXP_DT_MM(HtmlInputText cOMP_POL_CARD_EXP_DT_MM) {
		COMP_POL_CARD_EXP_DT_MM = cOMP_POL_CARD_EXP_DT_MM;
	}

	public HtmlInputText getCOMP_POL_CARD_EXP_DT_YY() {
		return COMP_POL_CARD_EXP_DT_YY;
	}

	public void setCOMP_POL_CARD_EXP_DT_YY(HtmlInputText cOMP_POL_CARD_EXP_DT_YY) {
		COMP_POL_CARD_EXP_DT_YY = cOMP_POL_CARD_EXP_DT_YY;
	}

	public void validatePOL_CARD_EXP_DT_MM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			System.out.println("inside validatePOL_CARD_EXP_DT_MM");

			PT_IL_POLICY_BEAN.setPOL_CARD_EXP_DT_MM((String) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	public void validatePOL_CARD_EXP_DT_YY(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			System.out.println("inside validatePOL_CARD_EXP_DT_YY");

			PT_IL_POLICY_BEAN.setPOL_CARD_EXP_DT_YY((String) value);

			String card_exp_dt = PT_IL_POLICY_BEAN.getPOL_CARD_EXP_DT_MM() + "/"
					+ PT_IL_POLICY_BEAN.getPOL_CARD_EXP_DT_YY();
			System.out.println("card_exp_dt                     " + card_exp_dt);

			PT_IL_POLICY_BEAN.setPOL_CARD_EXP_DT(card_exp_dt);

			System.out.println("getPOL_CARD_EXP_DT          " + PT_IL_POLICY_BEAN.getPOL_CARD_EXP_DT());

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	/* End */

	/*
	 * Added by saritha on 16-04-2018 for KIC Customer Address Details to
	 * defalut policy level address
	 */
	private HtmlPanelGroup COMP_POL_OFF_ADDRESS;

	public HtmlPanelGroup getCOMP_POL_OFF_ADDRESS() {
		return COMP_POL_OFF_ADDRESS;
	}

	public void setCOMP_POL_OFF_ADDRESS(HtmlPanelGroup cOMP_POL_OFF_ADDRESS) {
		COMP_POL_OFF_ADDRESS = cOMP_POL_OFF_ADDRESS;
	}

	public void validatePOL_RES_ADDRESS_1(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_1((String) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_RES_ADDRESS_1", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_RES_ADDRESS_2(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_2((String) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_RES_ADDRESS_2", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_RES_ADDRESS_3(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_3((String) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_RES_ADDRESS_3", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_MOBILE_NO(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_MOBILE_NO((String) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_MOBILE_NO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/* added by gopi for toi on 26/05/2018 */
	public String getPolicyApprove() {

		String Policy_approve = null;
		Connection connection = null;
		ResultSet rs = null;
		String query = "SELECT PROD_POL_APPROVAL_YN FROM PM_IL_PRODUCT WHERE PROD_CODE=? ";
		try {

			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
			if (rs.next()) {
				Policy_approve = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Policy_approve;
	}

	public String getPolicynumber() {

		String Policy_number = null;
		Connection connection = null;
		ResultSet rs = null;
		String query = "SELECT * FROM PT_IL_POLICY WHERE POL_PROP_NO=?";
		try {

			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_NO() });
			if (rs.next()) {
				Policy_number = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Policy_number;
	}

	// end

	public void validatePOL_RES_PHONE_NO(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_RES_PHONE_NO((String) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_RES_PHONE_NO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/* End */

	/* Added by Ameen on 16-05-2018 for KIC updating customer */
	public void setUpdatedCivilIID() {

		try {

			if ("C".equalsIgnoreCase(compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCustAssured())) {

				if (PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1() != null && PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2() != null
						&& PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1()
								.equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2())) {
					this.PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1(compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
							.getPM006_QE_CUSTOMER_BEAN().getCUST_REF_ID1());
					this.PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2(compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
							.getPM006_QE_CUSTOMER_BEAN().getCUST_REF_ID1());

				} else {
					this.PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1(compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
							.getPM006_QE_CUSTOMER_BEAN().getCUST_REF_ID1());
				}

			} else if ("A".equalsIgnoreCase(compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCustAssured())) {

				this.PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2(compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
						.getPM006_QE_CUSTOMER_BEAN().getCUST_REF_ID1());
			}
			COMP_POL_ASSRD_REF_ID1.resetValue();
			COMP_POL_ASSRD_REF_ID2.resetValue();
			compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().setUpdCivilFlag(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* End */

	/* Added by Janani as suggested by Sivaram for fidelity on 07.05.2018 */
	public void getCoverSACalc() throws Exception {
		Connection connection = null;
		ResultSet resultset = null, resultSet1 = null;

		String cvr_sa_calc = null;

		String query1 = "SELECT COVER_SA_CALC FROM PM_IL_COVER WHERE COVER_CODE= ?";

		try {

			connection = CommonUtils.getConnection();

			resultSet1 = new CRUDHandler().executeSelectStatement(query1, connection, new Object[] {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE() });

			if (resultSet1.next()) {

				cvr_sa_calc = resultSet1.getString("COVER_SA_CALC");

				System.out.println("cvr_sa_calc is                 " + cvr_sa_calc);

			}

			/* Newly Added By Dhinesh on 29-05-2018 */
			if (!"A".equalsIgnoreCase(cvr_sa_calc) || ("Y".equalsIgnoreCase(
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())
					&& "A".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
							.getPOL_APPRV_STATUS()))) {
				COMP_POL_SUB_PLAN_CODE.setDisabled(true);
			} else {
				COMP_POL_SUB_PLAN_CODE.setDisabled(false);
			}

			/* End */

			/*
			 * 
			 * commented by Dhinesh on 29-05-2018 for funeral Sub plan code
			 * issue
			 * 
			 * if(cvr_sa_calc.equalsIgnoreCase("a")) {
			 * COMP_POL_SUB_PLAN_CODE.setDisabled(false); } else {
			 * COMP_POL_SUB_PLAN_CODE.setDisabled(true); }
			 */

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultset);
		}

	}
	/* End */

	/* Added by Janani on 18.04.2018 for Fidelity period calc */
	public String getPlanType() throws Exception {
		Connection connection = null;
		ResultSet resultset = null;

		String PROD_RIDER_APPL_YN = null;

		String query1 = "SELECT PROD_RIDER_APPL_YN FROM PM_IL_PRODUCT WHERE PROD_CODE= ?";

		try {

			connection = CommonUtils.getConnection();

			resultset = new CRUDHandler().executeSelectStatement(query1, connection, new Object[] {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE() });

			if (resultset.next()) {

				PROD_RIDER_APPL_YN = resultset.getString("PROD_RIDER_APPL_YN");

				System.out.println("PROD_RIDER_APPL_YN is                 " + PROD_RIDER_APPL_YN);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultset);
		}
		return PROD_RIDER_APPL_YN;

	}

	/* End */

	/* Added by Janani on 18.04.2018 for Fidelity period calc */

	public void pol_period_disable() throws Exception {
		Connection connection = null;
		ResultSet resultset = null;

		String PROD_CALC_TERM_YN = null, PROD_PREM_PAYING_YRS = null;

		String query1 = " SELECT PROD_CALC_TERM_YN,PROD_PREM_PAYING_YRS FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";

		BigDecimal term_disb_SysParam = null;

		try {

			connection = CommonUtils.getConnection();

			resultset = new CRUDHandler().executeSelectStatement(query1, connection, new Object[] {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE() });

			if (resultset.next()) {

				PROD_CALC_TERM_YN = resultset.getString("PROD_CALC_TERM_YN");
				PROD_PREM_PAYING_YRS = resultset.getString("PROD_PREM_PAYING_YRS");

				System.out.println("PROD_CALC_TERM_YN is                 " + PROD_CALC_TERM_YN
						+ "    PROD_PREM_PAYING_YRS    " + PROD_PREM_PAYING_YRS);

			}

			term_disb_SysParam = (BigDecimal) CommonUtils.getPPSystemParameterValue("IL_TERM_DFLT");

			/*
			 * Added by Janani on 06.07.2018 for FLALIFEQC-1512859(EAT, ELE,
			 * LCTF - Premium paying term should default to the policy term) as
			 * suggested by Sivaram
			 */

			if (PROD_PREM_PAYING_YRS.equalsIgnoreCase("s")) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_PREM_PAY_YRS().setDisabled(true);

			} else if (PROD_PREM_PAYING_YRS.equalsIgnoreCase("v")) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_PREM_PAY_YRS().setDisabled(false);
			} else {

				/* End of FLALIFEQC-1512859 */

				if (PROD_CALC_TERM_YN != null && PROD_CALC_TERM_YN.equalsIgnoreCase("n")) {
					System.out.println("POL_PERIOD       " + PT_IL_POLICY_BEAN.getPOL_PERIOD());

					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_PERIOD().setDisabled(false);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_PREM_PAY_YRS().setDisabled(false);

				} else {
					if (term_disb_SysParam.intValue() == 1) {

						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_PERIOD().setDisabled(true);
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultset);
		}

	}

	/* End of FLA */

	/* added by gopinfor toi on 26/05/2018 */
	public String getBeneficiary_as_customer() {

		String Benef_cust_flag = null;
		Connection connection = null;
		ResultSet rs = null;
		String query = "SELECT PROD_BENF_AS_CUST_YN FROM PM_IL_PRODUCT WHERE PROD_CODE=? ";
		try {

			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
			if (rs.next()) {
				Benef_cust_flag = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Benef_cust_flag;
	}

	// end

	/*
	 * Added by Janani on 25.06.2018 for FSD_IL_FLA_006_Monetary Endorsement
	 * Module
	 */

	public void PremSAcheck() {
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		try {

			/*
			 * Added by saritha on 12-07-2017 for Endowment Product & Education
			 * Product issues
			 */
			if (("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()))
					&& ("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ()))) {
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				/*
				 * Commented by ganesh on 25-07-2017, as per anbarasi suggestion
				 * ZBILQC-1732654
				 */
				PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(null);
				COMP_POL_FC_SUM_ASSURED.resetValue();
				/* end */
				COMP_POL_ANN_BNF_AMT.setDisabled(false);
				COMP_POL_ANN_PAY_PERIOD.setDisabled(false);
				COMP_POL_FC_MODAL_PREM.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(null);
				COMP_POL_FC_MODAL_PREM.resetValue();
				COMP_POL_LC_MODAL_PREM.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_LC_MODAL_PREM(null);
				COMP_POL_LC_MODAL_PREM.resetValue();

			}

			/*
			 * MOdified by Janani on 23.07.2018 for SA field enabled after
			 * Freeeze Yes
			 */
			/*
			 * else
			 * if(("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())
			 * )&& ("END".equalsIgnoreCase(compositeAction.
			 * getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))
			 */

			else if (("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()))
					&& ("END".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ()))
					&& "N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG())) {
				/* End */

				COMP_POL_FC_SUM_ASSURED.setDisabled(false);
				COMP_POL_ANN_BNF_AMT.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_ANN_BNF_AMT(null);
				PT_IL_POLICY_BEAN.setPOL_ANN_PAY_PERIOD(null);
				COMP_POL_ANN_PAY_PERIOD.resetValue();
				COMP_POL_FC_MODAL_PREM.setDisabled(true);
				COMP_POL_ANN_BNF_AMT.resetValue();
				COMP_POL_ANN_PAY_PERIOD.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(null);
				COMP_POL_FC_MODAL_PREM.resetValue();
				COMP_POL_LC_MODAL_PREM.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_LC_MODAL_PREM(null);
				COMP_POL_LC_MODAL_PREM.resetValue();

			}

			else if (("D".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())
					&& ("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))) {
				COMP_POL_FC_MODAL_PREM.setDisabled(false);
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				COMP_POL_ANN_BNF_AMT.setDisabled(true);

			}

			else if (("D".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())
					&& ("END".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))) {
				COMP_POL_FC_MODAL_PREM.setDisabled(true);
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				// PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(null);
				COMP_POL_FC_SUM_ASSURED.resetValue();
				COMP_POL_ANN_BNF_AMT.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_ANN_BNF_AMT(null);
				COMP_POL_ANN_BNF_AMT.resetValue();

			}

			else if (("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())
					&& ("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))
					|| ("N".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC()) && ("END"
							.equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))) {

				COMP_POL_FC_MODAL_PREM.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(null);
				COMP_POL_FC_MODAL_PREM.resetValue();
				COMP_POL_ANN_BNF_AMT.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_ANN_BNF_AMT(null);
				COMP_POL_ANN_BNF_AMT.resetValue();
				COMP_POL_FC_SUM_ASSURED.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(null);
				COMP_POL_FC_SUM_ASSURED.resetValue();
				COMP_POL_LC_MODAL_PREM.setDisabled(true);
				PT_IL_POLICY_BEAN.setPOL_LC_MODAL_PREM(null);
				COMP_POL_LC_MODAL_PREM.resetValue();

			}

			else {
				/* Modified by Saranya on 12/04/2017 */
				Unit_link_typ();
				if ("F".equals(dummyBean.getUI_M_COVER_SA_CALC())
						&& ("NA".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ()))) {
					COMP_POL_FC_MODAL_PREM.setDisabled(false);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FC_MODAL_PREM().setRequired(true);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_NO_OF_UNIT(0.0);
					COMP_POL_NO_OF_UNIT.setDisabled(true);
					COMP_POL_FC_SUM_ASSURED.setDisabled(true);
					COMP_POL_FC_SUM_ASSURED.setRequired(false);
					COMP_POL_ANN_BNF_AMT.setDisabled(true);
				} else {
					/* End */
					/*
					 * if condition added by Ameen on 25-10-2019 for SARWA sugg.
					 * by Sivaram
					 */
					if ("U".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_UL_PREM_CALC())) {
						COMP_POL_FC_MODAL_PREM.setDisabled(false);
					} else {
						COMP_POL_FC_MODAL_PREM.setDisabled(true);
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FC_MODAL_PREM().setRequired(false);
					}

				}
			}
			/* End */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getAgentPremiumType() {
		String agnt_prem_type = null;
		Connection connection = null;
		ResultSet rs = null;
		String query = "SELECT PROD_AGENT_PREM_TYPE FROM PM_IL_PRODUCT  WHERE PROD_CODE=? ";
		try {

			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
			if (rs.next()) {
				agnt_prem_type = rs.getString(1);
			}

			System.out.println("setUnit_link_typ  :" + getUnit_link_typ());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return agnt_prem_type;
	}

	/* End */

	/* Added by Ameen on 13-07-2018 for TOI as per Ajay sugg. */
	private HtmlOutputLabel COMP_UI_M_POBH_BROKER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_POBH_BROKER_CODE;

	private HtmlInputText COMP_UI_M_POBH_BROKER_CODE_DESC;

	public HtmlOutputLabel getCOMP_UI_M_POBH_BROKER_CODE_LABEL() {
		return COMP_UI_M_POBH_BROKER_CODE_LABEL;
	}

	public void setCOMP_UI_M_POBH_BROKER_CODE_LABEL(HtmlOutputLabel cOMP_UI_M_POBH_BROKER_CODE_LABEL) {
		COMP_UI_M_POBH_BROKER_CODE_LABEL = cOMP_UI_M_POBH_BROKER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POBH_BROKER_CODE() {
		return COMP_UI_M_POBH_BROKER_CODE;
	}

	public void setCOMP_UI_M_POBH_BROKER_CODE(HtmlInputText cOMP_UI_M_POBH_BROKER_CODE) {
		COMP_UI_M_POBH_BROKER_CODE = cOMP_UI_M_POBH_BROKER_CODE;
	}

	public HtmlInputText getCOMP_UI_M_POBH_BROKER_CODE_DESC() {
		return COMP_UI_M_POBH_BROKER_CODE_DESC;
	}

	public void setCOMP_UI_M_POBH_BROKER_CODE_DESC(HtmlInputText cOMP_UI_M_POBH_BROKER_CODE_DESC) {
		COMP_UI_M_POBH_BROKER_CODE_DESC = cOMP_UI_M_POBH_BROKER_CODE_DESC;
	}

	public void validateUI_M_POBH_BROKER_CODE(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		PT_IL_POL_BROKER_HEAD_HELPER helper = new PT_IL_POL_BROKER_HEAD_HELPER();
		try {
			String currValue = (String) value;
			PT_IL_POLICY_BEAN.setUI_M_POBH_BROKER_CODE((String) value);

			if ("O".equalsIgnoreCase(P_PROD_POL_APPROVAL_YN)) {
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_SRNO(1);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getPT_IL_POL_BROKER_HEAD_BEAN()
						.setPOBH_BROKER_CODE(PT_IL_POLICY_BEAN.getUI_M_POBH_BROKER_CODE());
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getPT_IL_POL_BROKER_HEAD_BEAN()
						.setPOBH_SHARE_PERC(100.0);
				helper.POBH_BROKER_CODE_WHEN_VALIDATE_ITEM(compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(), currValue);
			}
		} catch (Exception exception) {

			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	public ArrayList<LovBean> prepareSuggestionList_BROKER_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		Connection connection = null;
		ResultSet resultSet = null;
		String currentValue = (String) object;
		String query1value = null;
		String query1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'LOV_CUST' " + "AND PS_CODE = 'IL_BROKER'";
		String query2 = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query1, connection);
			if (resultSet.next()) {
				query1value = resultSet.getString(1);
			}

			query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS "
					+ "IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE "
					+ "(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN (" + query1value + ") AND PS_CODE = 'IL_BROKER' "
					+ "AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT "
					+ "CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND "
					+ "CUST_APPL_ALL_BRAN_YN = 'N'))OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND "
					+ "(UPPER(CUST_CODE) LIKE UPPER(?) OR  UPPER(CUST_NAME) LIKE UPPER(?) OR  UPPER(CUST_BL_NAME) LIKE UPPER(?))"
					/* + "AND CUST_AGENCY_BRANCH_CODE = ? " */ /*
																 * COMMENTED BY
																 * AJAY THIS
																 * LOGIC NOT
																 * REQUIRED
																 */
					+ "AND ROWNUM < 25 ORDER BY 1";

			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			System.out.println("CommonUtils.getGlobalVariable(GLOBAL.X_DIVN_CODE)         "
					+ CommonUtils.getGlobalVariable("GLOBAL.M_DIVN_CODE"));

			lovList = ListItemUtil.prepareSuggestionList(query2,
					new Object[] {
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE(),
							currentValue, currentValue,
							currentValue/*
										 * ,CommonUtils.getGlobalVariable(
										 * "GLOBAL.M_DIVN_CODE") COMMENTED BY
										 * AJAY THIS LOGIC NOT REQUIRED
										 */ });

			/* End */

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	/* End */

	/* Added by kavitha on 26.07.2018 for KICLIFEQC-1759635-3 */
	public void getCityCodeDesc() {
		String city_code_desc = null;
		Connection connection = null;
		ResultSet rs = null;
		String cityCode = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_CITY_CODE();
		String query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' AND PC_CODE = ?";
		try {

			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection, new Object[] { cityCode });

			if (rs.next()) {
				city_code_desc = rs.getString(2);
			}
			PT_IL_POLICY_BEAN.setUI_M_POL_CITY_NAME(city_code_desc);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCountryCodeDesc() {
		String country_code_desc = null;
		Connection connection = null;
		ResultSet rs = null;
		String countryCode = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_COUNT_CODE();
		// String query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE =
		// 'COUNTRY' and ";
		String query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' AND PC_CODE = ?";
		try {

			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection, new Object[] { countryCode });

			if (rs.next()) {
				country_code_desc = rs.getString(2);
			}
			PT_IL_POLICY_BEAN.setUI_M_POL_COUNT_NAME(country_code_desc);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* End */
	/*
	 * Added by Ameen on 27-07-2018 for KIC To change pol_period
	 * KICLIFEQC-1759635 - 2,6
	 */
	private boolean POL_PERIOD_CHNG = false;

	public boolean isPOL_PERIOD_CHNG() {
		return POL_PERIOD_CHNG;
	}

	public void setPOL_PERIOD_CHNG(boolean pOL_PERIOD_CHNG) {
		POL_PERIOD_CHNG = pOL_PERIOD_CHNG;
	}

	/* End */
	/*
	 * Fidelity feature taken for kic added by Pidugu Raj on 20-09-2018
	 * (FSD_IL_FLA_009)
	 */

	private HtmlOutputLabel COMP_PDU_DEP_AMT_LABEL;

	private HtmlInputText COMP_PDU_DEP_AMT;

	private HtmlOutputLabel COMP_PDU_UTIL_AMT_LABEL;

	private HtmlInputText COMP_PDU_UTIL_AMT;

	public HtmlOutputLabel getCOMP_PDU_DEP_AMT_LABEL() {
		return COMP_PDU_DEP_AMT_LABEL;
	}

	public void setCOMP_PDU_DEP_AMT_LABEL(HtmlOutputLabel cOMP_PDU_DEP_AMT_LABEL) {
		COMP_PDU_DEP_AMT_LABEL = cOMP_PDU_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PDU_DEP_AMT() {
		return COMP_PDU_DEP_AMT;
	}

	public void setCOMP_PDU_DEP_AMT(HtmlInputText cOMP_PDU_DEP_AMT) {
		COMP_PDU_DEP_AMT = cOMP_PDU_DEP_AMT;
	}

	public HtmlOutputLabel getCOMP_PDU_UTIL_AMT_LABEL() {
		return COMP_PDU_UTIL_AMT_LABEL;
	}

	public void setCOMP_PDU_UTIL_AMT_LABEL(HtmlOutputLabel cOMP_PDU_UTIL_AMT_LABEL) {
		COMP_PDU_UTIL_AMT_LABEL = cOMP_PDU_UTIL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PDU_UTIL_AMT() {
		return COMP_PDU_UTIL_AMT;
	}

	public void setCOMP_PDU_UTIL_AMT(HtmlInputText cOMP_PDU_UTIL_AMT) {
		COMP_PDU_UTIL_AMT = cOMP_PDU_UTIL_AMT;
	}

	private HtmlOutputLabel COMP_UI_M_PDU_SUS_AMT_LABEL;

	private HtmlInputText COMP_UI_M_PDU_SUS_AMT;

	public HtmlOutputLabel getCOMP_UI_M_PDU_SUS_AMT_LABEL() {
		return COMP_UI_M_PDU_SUS_AMT_LABEL;
	}

	public void setCOMP_UI_M_PDU_SUS_AMT_LABEL(HtmlOutputLabel cOMP_UI_M_PDU_SUS_AMT_LABEL) {
		COMP_UI_M_PDU_SUS_AMT_LABEL = cOMP_UI_M_PDU_SUS_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PDU_SUS_AMT() {
		return COMP_UI_M_PDU_SUS_AMT;
	}

	public void setCOMP_UI_M_PDU_SUS_AMT(HtmlInputText cOMP_UI_M_PDU_SUS_AMT) {
		COMP_UI_M_PDU_SUS_AMT = cOMP_UI_M_PDU_SUS_AMT;
	}

	private double UI_M_PDU_SUS_AMT;

	public double getUI_M_PDU_SUS_AMT() {
		return UI_M_PDU_SUS_AMT;
	}

	public void setUI_M_PDU_SUS_AMT(double uI_M_PDU_SUS_AMT) {
		UI_M_PDU_SUS_AMT = uI_M_PDU_SUS_AMT;
	}

	public void getPol_receipt_dtls() {

		Connection connection = null;
		ResultSet rs = null;
		String query = "SELECT PDU_DEP_AMT,PDU_UTIL_AMT FROM PT_IL_POL_DEPUTIL WHERE PDU_POL_SYS_ID = ?";
		try {

			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });

			if (rs.next()) {

				PT_IL_POLICY_BEAN.setPDU_DEP_AMT(rs.getDouble("PDU_DEP_AMT"));
				PT_IL_POLICY_BEAN.setPDU_UTIL_AMT(rs.getDouble("PDU_UTIL_AMT"));

				/* Added by kavitha on 13.08.2018 for FLALIFEQC-1761039 */
				Double sus_amt = ((PT_IL_POLICY_BEAN.getPDU_DEP_AMT()) - (PT_IL_POLICY_BEAN.getPDU_UTIL_AMT()));

				PT_IL_POLICY_BEAN.setUI_M_PDU_SUS_AMT(sus_amt);

				/* End */
			}

			System.out.println("getPDU_DEP_AMT                " + PT_IL_POLICY_BEAN.getPDU_DEP_AMT()
					+ "    getPDU_UTIL_AMT          " + PT_IL_POLICY_BEAN.getPDU_UTIL_AMT());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showPol_receipt_dtls() {

		System.out.println("enters into showPol_receipt_dtlss");

		try {
			/* Modified by pidugu raj KICLIFEQC-1761597 dt: 18-08-2018 */
			String IL_DEP_COLL = null;
			if (CommonUtils.getPPSystemParameterValue("IL_DEP_COLL") != null) {
				/* End added by pidugu raj dt: 18-08-2018 */
				IL_DEP_COLL = CommonUtils.getPPSystemParameterValue("IL_DEP_COLL").toString();

				System.out.println("IL_DEP_COLL           " + IL_DEP_COLL);

				if (IL_DEP_COLL.equalsIgnoreCase("2")) {
					getPol_receipt_dtls();

					if (PT_IL_POLICY_BEAN.getPOL_DS_TYPE().equalsIgnoreCase("2")) {

						COMP_PDU_DEP_AMT_LABEL.setRendered(true);

						COMP_PDU_DEP_AMT.setRendered(true);

						COMP_PDU_UTIL_AMT_LABEL.setRendered(true);

						COMP_PDU_UTIL_AMT.setRendered(true);

						/*
						 * Added by kavitha on 13.08.2018 for FLALIFEQC-1761039
						 */
						COMP_UI_M_PDU_SUS_AMT_LABEL.setRendered(true);

						COMP_UI_M_PDU_SUS_AMT.setRendered(true);
						/* End */
					} else {
						/*
						 * MOdified by Janani on 24.08.2018 for FSD_IL_FLA_009
						 * as suggested by Prasanth
						 */

						/*
						 * COMP_PDU_DEP_AMT_LABEL.setRendered(false);
						 * 
						 * COMP_PDU_DEP_AMT.setRendered(false);
						 */
						COMP_PDU_DEP_AMT_LABEL.setRendered(true);

						COMP_PDU_DEP_AMT.setRendered(true);

						/* End of FSD_IL_FLA_009 */
						COMP_PDU_UTIL_AMT_LABEL.setRendered(false);

						COMP_PDU_UTIL_AMT.setRendered(false);

						/*
						 * Added by kavitha on 13.08.2018 for FLALIFEQC-1761039
						 */
						COMP_UI_M_PDU_SUS_AMT_LABEL.setRendered(false);

						COMP_UI_M_PDU_SUS_AMT.setRendered(false);
						/* End */
					}
				}
				/* Modified by pidugu raj KICLIFEQC-1761597 dt: 18-08-2018 */
			}
			/* End added by pidugu raj dt: 18-08-2018 */
			else {
				COMP_PDU_DEP_AMT_LABEL.setRendered(false);

				COMP_PDU_DEP_AMT.setRendered(false);

				COMP_PDU_UTIL_AMT_LABEL.setRendered(false);

				COMP_PDU_UTIL_AMT.setRendered(false);

				/* Added by kavitha on 13.08.2018 for FLALIFEQC-1761039 */
				COMP_UI_M_PDU_SUS_AMT_LABEL.setRendered(false);

				COMP_UI_M_PDU_SUS_AMT.setRendered(false);
				/* End */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Fidelity feature taken for kic added by Pidugu Raj on 20-09-2018
	 * (FSD_IL_FLA_009)
	 */

	/*
	 * Added by Sivarajan on 29-01-2019 for cust code and assured code
	 * validation
	 */
	public boolean validateCivilId(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		boolean returnVal = false;
		String query = null;
		Connection connection = null;
		ResultSet rs = null;
		List<String> check = new ArrayList<String>();
		try {
			connection = CommonUtils.getConnection();
			query = "SELECT CUST_CODE FROM PM_CUSTOMER WHERE CUST_REF_ID1 = ? AND  CUST_CODE = ? ";

			if (PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1() != null) {
				rs = new CRUDHandler().executeSelectStatement(query, connection, new Object[] {
						PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1(), PT_IL_POLICY_BEAN.getPOL_CUST_CODE() });
				if (rs.next()) {
					returnVal = true;
				} else {
					return false;
				}
			}
			if (PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2() != null) {
				rs = new CRUDHandler().executeSelectStatement(query, connection, new Object[] {
						PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID2(), PT_IL_POLICY_BEAN.getPOL_CONT_CODE() });
				if (rs.next()) {
					returnVal = true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnVal;
	}
	/* End */

	/* added by Ameen on 21-10-2019 for SARWA for Retirement Product */
	private HtmlOutputLabel COMP_POL_BNF_ESC_YN_LABEL;

	private HtmlSelectOneMenu COMP_POL_BNF_ESC_YN;

	private HtmlOutputLabel COMP_POL_ADHOC_PREM_YN_LABEL;

	private HtmlSelectOneMenu COMP_POL_ADHOC_PREM_YN;

	private HtmlOutputLabel COMP_POL_ADHOC_LC_PREM_LABEL;

	private HtmlInputText COMP_POL_ADHOC_LC_PREM;

	private HtmlOutputLabel COMP_POL_CASHBACK_YN_LABEL;

	private HtmlSelectOneMenu COMP_POL_CASHBACK_YN;

	private HtmlOutputLabel COMP_POL_CASHBACK_PREC_LABEL;

	private HtmlInputText COMP_POL_CASHBACK_PREC;

	private HtmlOutputLabel COMP_POL_CASHBACK_ST_YR_LABEL;

	private HtmlInputText COMP_POL_CASHBACK_ST_YR;

	private List<SelectItem> listPOL_BNF_ESC_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPOL_ADHOC_PREM_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPOL_CASHBACK_YN = new ArrayList<SelectItem>();

	public HtmlOutputLabel getCOMP_POL_BNF_ESC_YN_LABEL() {
		return COMP_POL_BNF_ESC_YN_LABEL;
	}

	public void setCOMP_POL_BNF_ESC_YN_LABEL(HtmlOutputLabel cOMP_POL_BNF_ESC_YN_LABEL) {
		COMP_POL_BNF_ESC_YN_LABEL = cOMP_POL_BNF_ESC_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_BNF_ESC_YN() {
		return COMP_POL_BNF_ESC_YN;
	}

	public void setCOMP_POL_BNF_ESC_YN(HtmlSelectOneMenu cOMP_POL_BNF_ESC_YN) {
		COMP_POL_BNF_ESC_YN = cOMP_POL_BNF_ESC_YN;
	}

	public HtmlOutputLabel getCOMP_POL_ADHOC_PREM_YN_LABEL() {
		return COMP_POL_ADHOC_PREM_YN_LABEL;
	}

	public void setCOMP_POL_ADHOC_PREM_YN_LABEL(HtmlOutputLabel cOMP_POL_ADHOC_PREM_YN_LABEL) {
		COMP_POL_ADHOC_PREM_YN_LABEL = cOMP_POL_ADHOC_PREM_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_ADHOC_PREM_YN() {
		return COMP_POL_ADHOC_PREM_YN;
	}

	public void setCOMP_POL_ADHOC_PREM_YN(HtmlSelectOneMenu cOMP_POL_ADHOC_PREM_YN) {
		COMP_POL_ADHOC_PREM_YN = cOMP_POL_ADHOC_PREM_YN;
	}

	public HtmlOutputLabel getCOMP_POL_ADHOC_LC_PREM_LABEL() {
		return COMP_POL_ADHOC_LC_PREM_LABEL;
	}

	public void setCOMP_POL_ADHOC_LC_PREM_LABEL(HtmlOutputLabel cOMP_POL_ADHOC_LC_PREM_LABEL) {
		COMP_POL_ADHOC_LC_PREM_LABEL = cOMP_POL_ADHOC_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_ADHOC_LC_PREM() {
		return COMP_POL_ADHOC_LC_PREM;
	}

	public void setCOMP_POL_ADHOC_LC_PREM(HtmlInputText cOMP_POL_ADHOC_LC_PREM) {
		COMP_POL_ADHOC_LC_PREM = cOMP_POL_ADHOC_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_POL_CASHBACK_YN_LABEL() {
		return COMP_POL_CASHBACK_YN_LABEL;
	}

	public void setCOMP_POL_CASHBACK_YN_LABEL(HtmlOutputLabel cOMP_POL_CASHBACK_YN_LABEL) {
		COMP_POL_CASHBACK_YN_LABEL = cOMP_POL_CASHBACK_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POL_CASHBACK_YN() {
		return COMP_POL_CASHBACK_YN;
	}

	public void setCOMP_POL_CASHBACK_YN(HtmlSelectOneMenu cOMP_POL_CASHBACK_YN) {
		COMP_POL_CASHBACK_YN = cOMP_POL_CASHBACK_YN;
	}

	public List<SelectItem> getListPOL_BNF_ESC_YN() {
		return listPOL_BNF_ESC_YN;
	}

	public void setListPOL_BNF_ESC_YN(List<SelectItem> listPOL_BNF_ESC_YN) {
		this.listPOL_BNF_ESC_YN = listPOL_BNF_ESC_YN;
	}

	public List<SelectItem> getListPOL_ADHOC_PREM_YN() {
		return listPOL_ADHOC_PREM_YN;
	}

	public void setListPOL_ADHOC_PREM_YN(List<SelectItem> listPOL_ADHOC_PREM_YN) {
		this.listPOL_ADHOC_PREM_YN = listPOL_ADHOC_PREM_YN;
	}

	public List<SelectItem> getListPOL_CASHBACK_YN() {
		return listPOL_CASHBACK_YN;
	}

	public void setListPOL_CASHBACK_YN(List<SelectItem> listPOL_CASHBACK_YN) {
		this.listPOL_CASHBACK_YN = listPOL_CASHBACK_YN;
	}

	public HtmlOutputLabel getCOMP_POL_CASHBACK_PREC_LABEL() {
		return COMP_POL_CASHBACK_PREC_LABEL;
	}

	public void setCOMP_POL_CASHBACK_PREC_LABEL(HtmlOutputLabel cOMP_POL_CASHBACK_PREC_LABEL) {
		COMP_POL_CASHBACK_PREC_LABEL = cOMP_POL_CASHBACK_PREC_LABEL;
	}

	public HtmlInputText getCOMP_POL_CASHBACK_PREC() {
		return COMP_POL_CASHBACK_PREC;
	}

	public void setCOMP_POL_CASHBACK_PREC(HtmlInputText cOMP_POL_CASHBACK_PREC) {
		COMP_POL_CASHBACK_PREC = cOMP_POL_CASHBACK_PREC;
	}

	public HtmlOutputLabel getCOMP_POL_CASHBACK_ST_YR_LABEL() {
		return COMP_POL_CASHBACK_ST_YR_LABEL;
	}

	public void setCOMP_POL_CASHBACK_ST_YR_LABEL(HtmlOutputLabel cOMP_POL_CASHBACK_ST_YR_LABEL) {
		COMP_POL_CASHBACK_ST_YR_LABEL = cOMP_POL_CASHBACK_ST_YR_LABEL;
	}

	public HtmlInputText getCOMP_POL_CASHBACK_ST_YR() {
		return COMP_POL_CASHBACK_ST_YR;
	}

	public void setCOMP_POL_CASHBACK_ST_YR(HtmlInputText cOMP_POL_CASHBACK_ST_YR) {
		COMP_POL_CASHBACK_ST_YR = cOMP_POL_CASHBACK_ST_YR;
	}

	public void validatePOL_BNF_ESC_YN(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_BNF_ESC_YN((String) value);
			if (PT_IL_POLICY_BEAN.getPOL_BNF_ESC_YN() != null
					&& "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_BNF_ESC_YN())) {
				COMP_POL_BNF_ESC_PERC.setDisabled(false);
			} else {
				COMP_POL_BNF_ESC_PERC.setDisabled(true);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_BNF_ESC_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_ADHOC_PREM_YN(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_ADHOC_PREM_YN((String) value);
			if (PT_IL_POLICY_BEAN.getPOL_ADHOC_PREM_YN() != null
					&& "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_ADHOC_PREM_YN())) {
				COMP_POL_ADHOC_LC_PREM.setDisabled(false);
			} else {
				COMP_POL_ADHOC_LC_PREM.setDisabled(true);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_ADHOC_PREM_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_ADHOC_LC_PREM(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_ADHOC_LC_PREM((Double) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_ADHOC_LC_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CASHBACK_YN(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_CASHBACK_YN((String) value);
			if (PT_IL_POLICY_BEAN.getPOL_CASHBACK_YN() != null
					&& "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_CASHBACK_YN())) {
				COMP_POL_CASHBACK_PREC.setDisabled(false);
				COMP_POL_CASHBACK_ST_YR.setDisabled(false);
			} else {
				COMP_POL_CASHBACK_PREC.setDisabled(true);
				COMP_POL_CASHBACK_ST_YR.setDisabled(true);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_CASHBACK_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CASHBACK_PREC(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_CASHBACK_PREC((Integer) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_ADHOC_LC_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOL_CASHBACK_ST_YR(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_POLICY_BEAN.setPOL_CASHBACK_ST_YR((Integer) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "POL_ADHOC_LC_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void retirementFieldHandling() {

		if (PT_IL_POLICY_BEAN.getPOL_BNF_ESC_YN() != null
				&& "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_BNF_ESC_YN())) {
			COMP_POL_BNF_ESC_PERC.setDisabled(false);
		} else {
			COMP_POL_BNF_ESC_PERC.setDisabled(true);
		}

		if (PT_IL_POLICY_BEAN.getPOL_CASHBACK_YN() != null
				&& "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_CASHBACK_YN())) {
			COMP_POL_CASHBACK_PREC.setDisabled(false);
			COMP_POL_CASHBACK_ST_YR.setDisabled(false);
		} else {
			COMP_POL_CASHBACK_PREC.setDisabled(true);
			COMP_POL_CASHBACK_ST_YR.setDisabled(true);
		}

		if (PT_IL_POLICY_BEAN.getPOL_ADHOC_PREM_YN() != null
				&& "Y".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_ADHOC_PREM_YN())) {
			COMP_POL_ADHOC_LC_PREM.setDisabled(false);
		} else {
			COMP_POL_ADHOC_LC_PREM.setDisabled(true);
		}
	}

	public void retirementFieldsEnDis(String plantype) {
		if (null != plantype && "U".equalsIgnoreCase(plantype)) {
			COMP_POL_BNF_ESC_YN.setDisabled(false);
			COMP_POL_ADHOC_PREM_YN.setDisabled(false);
			COMP_POL_ADHOC_LC_PREM.setDisabled(false);
			COMP_POL_CASHBACK_YN.setDisabled(false);
			COMP_POL_BNF_ESC_PERC.setDisabled(false);
			COMP_POL_FC_MODAL_PREM.setDisabled(false);
		} else {
			COMP_POL_BNF_ESC_YN.setDisabled(true);
			COMP_POL_ADHOC_PREM_YN.setDisabled(true);
			COMP_POL_ADHOC_LC_PREM.setDisabled(true);
			COMP_POL_CASHBACK_YN.setDisabled(true);
			COMP_POL_BNF_ESC_PERC.setDisabled(true);
			COMP_POL_FC_MODAL_PREM.setDisabled(true);
		}
	}

	/* end */
	public String EnableUnderwrite() {
		String truefalse = null;
		Connection connection = null;
		ResultSet rs = null;
		String polNo = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO();
		String query = "SELECT 'X' FROM PT_IL_POLICY WHERE NVL(POL_CONVERT_YN,'N') = 'N' AND POL_DS_TYPE='1' "
				+ "AND POL_NO= ? ";
		try {

			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection, new Object[] { polNo });

			if (rs.next()) {
				truefalse = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return truefalse;
	}

}
