package com.iii.pel.forms.PILQ004_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;


public class ASSRD_DTLS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POAD_ASSR_CODE_LABEL;

	private HtmlInputText COMP_POAD_ASSR_CODE;

	private HtmlOutputLabel COMP_POAD_ASSURED_NAME_LABEL;

	private HtmlInputText COMP_POAD_ASSURED_NAME;

	private HtmlOutputLabel COMP_POAD_ASSRD_REF_ID1_LABEL;

	private HtmlInputText COMP_POAD_ASSRD_REF_ID1;

	private HtmlOutputLabel COMP_POAD_ASSRD_REF_ID2_LABEL;

	private HtmlInputText COMP_POAD_ASSRD_REF_ID2;

	private ASSRD_DTLS ASSRD_DTLS_BEAN;
	
	private String filterByPOL_NO;
	
	private String filterByPOL_PLAN_CODE;
	
	private String filterByPOAC_COVER_CODE;
	
	private String filterByPOAC_LC_SA;
	
	private String filterByPDL_RATE;
	
	private String filterByPDL_DISC_LOAD_CODE;

	Double UI_M_TOT_SAValue = 0.0;

	HashMap<String, Object> buttonPaleteBean;
	
	private HtmlCommandButton COMP_UI_M_QUERY;

	private UIData dataTable;
	
	private UIData discountDataTable;
	
	private UIData addtionalCoverDataTable;
	
	private HtmlInputText COMP_UI_M_POAD_TOT_THRESOLD_LMT;
	
	private HtmlOutputLabel COMP_UI_M_POAD_TOT_THRESOLD_LMT_LABEL;

	private Map<String, String> errorMap = new HashMap<String, String>();
	private Map<String, String> warningMap = new HashMap<String, String>();


	FacesContext ctx= FacesContext.getCurrentInstance();
	Map<String, Object> session = null;
	Connection connection = null;
	String selectQuery;

	public ASSRD_DTLS_ACTION() {
		ASSRD_DTLS_BEAN = new ASSRD_DTLS();
		POLICY_DETAILS_BEAN = new POLICY_DETAILS();
		POL_ADDL_COVER_BEAN = new POL_ADDL_COVER();
		POL_DISC_LOAD_BEAN = new POL_DISC_LOAD();

		policyDetailList = new ArrayList<POLICY_DETAILS>();
		coverList = new ArrayList<POL_ADDL_COVER>();
		loadList = new ArrayList<POL_DISC_LOAD>();

		buttonPaleteBean = new HashMap<String, Object>();
	}

	public HtmlOutputLabel getCOMP_POAD_ASSR_CODE_LABEL() {
		return COMP_POAD_ASSR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POAD_ASSR_CODE() {
		return COMP_POAD_ASSR_CODE;
	}

	public void setCOMP_POAD_ASSR_CODE_LABEL(HtmlOutputLabel COMP_POAD_ASSR_CODE_LABEL) {
		this.COMP_POAD_ASSR_CODE_LABEL = COMP_POAD_ASSR_CODE_LABEL;
	}

	public void setCOMP_POAD_ASSR_CODE(HtmlInputText COMP_POAD_ASSR_CODE) {
		this.COMP_POAD_ASSR_CODE = COMP_POAD_ASSR_CODE;
	}

	public HtmlOutputLabel getCOMP_POAD_ASSURED_NAME_LABEL() {
		return COMP_POAD_ASSURED_NAME_LABEL;
	}

	public HtmlInputText getCOMP_POAD_ASSURED_NAME() {
		return COMP_POAD_ASSURED_NAME;
	}

	public void setCOMP_POAD_ASSURED_NAME_LABEL(HtmlOutputLabel COMP_POAD_ASSURED_NAME_LABEL) {
		this.COMP_POAD_ASSURED_NAME_LABEL = COMP_POAD_ASSURED_NAME_LABEL;
	}

	public void setCOMP_POAD_ASSURED_NAME(HtmlInputText COMP_POAD_ASSURED_NAME) {
		this.COMP_POAD_ASSURED_NAME = COMP_POAD_ASSURED_NAME;
	}

	public HtmlOutputLabel getCOMP_POAD_ASSRD_REF_ID1_LABEL() {
		return COMP_POAD_ASSRD_REF_ID1_LABEL;
	}

	public HtmlInputText getCOMP_POAD_ASSRD_REF_ID1() {
		return COMP_POAD_ASSRD_REF_ID1;
	}

	public void setCOMP_POAD_ASSRD_REF_ID1_LABEL(HtmlOutputLabel COMP_POAD_ASSRD_REF_ID1_LABEL) {
		this.COMP_POAD_ASSRD_REF_ID1_LABEL = COMP_POAD_ASSRD_REF_ID1_LABEL;
	}

	public void setCOMP_POAD_ASSRD_REF_ID1(HtmlInputText COMP_POAD_ASSRD_REF_ID1) {
		this.COMP_POAD_ASSRD_REF_ID1 = COMP_POAD_ASSRD_REF_ID1;
	}

	public HtmlOutputLabel getCOMP_POAD_ASSRD_REF_ID2_LABEL() {
		return COMP_POAD_ASSRD_REF_ID2_LABEL;
	}

	public HtmlInputText getCOMP_POAD_ASSRD_REF_ID2() {
		return COMP_POAD_ASSRD_REF_ID2;
	}

	public void setCOMP_POAD_ASSRD_REF_ID2_LABEL(HtmlOutputLabel COMP_POAD_ASSRD_REF_ID2_LABEL) {
		this.COMP_POAD_ASSRD_REF_ID2_LABEL = COMP_POAD_ASSRD_REF_ID2_LABEL;
	}

	public void setCOMP_POAD_ASSRD_REF_ID2(HtmlInputText COMP_POAD_ASSRD_REF_ID2) {
		this.COMP_POAD_ASSRD_REF_ID2 = COMP_POAD_ASSRD_REF_ID2;
	}

	public ASSRD_DTLS getASSRD_DTLS_BEAN() {
		return ASSRD_DTLS_BEAN;
	}

	public void setASSRD_DTLS_BEAN(ASSRD_DTLS ASSRD_DTLS_BEAN) {
		this.ASSRD_DTLS_BEAN = ASSRD_DTLS_BEAN;
	}

//	Policy Details Action

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_TRAN_DT_LABEL;

	private HtmlCalendar COMP_POL_TRAN_DT;

	private HtmlOutputLabel COMP_POL_FC_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_POL_FC_SUM_ASSURED;

	private HtmlOutputLabel COMP_UI_M_POL_PLAN_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POL_PLAN_DESC;

	private HtmlInputText COMP_UI_M_TOT_SA;

	private HtmlOutputLabel COMP_POL_PLAN_CODE_LABEL;

	private HtmlInputText COMP_POL_PLAN_CODE;

	private HtmlOutputLabel COMP_POL_LC_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_POL_LC_SUM_ASSURED;

	private HtmlOutputLabel COMP_NEXT_DUE_DATE_LABEL;

	private HtmlCalendar COMP_NEXT_DUE_DATE;

	private HtmlOutputLabel COMP_POL_FC_FIRST_PREM_LABEL;

	private HtmlInputText COMP_POL_FC_FIRST_PREM;

	private HtmlOutputLabel COMP_POL_PERIOD_LABEL;

	private HtmlInputText COMP_POL_PERIOD;

	private HtmlOutputLabel COMP_POL_PREM_PAY_YRS_LABEL;

	private HtmlInputText COMP_POL_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_POL_START_DT_LABEL;

	private HtmlCalendar COMP_POL_START_DT;

	private HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL;

	private HtmlCalendar COMP_POL_EXPIRY_DT;

	private HtmlOutputLabel COMP_POL_REMARKS_LABEL;

	private HtmlInputText COMP_POL_REMARKS;

	private HtmlOutputLabel COMP_POL_FC_BASIC_PREM_LABEL;

	private HtmlInputText COMP_POL_FC_BASIC_PREM;

	private HtmlOutputLabel COMP_POL_MODE_OF_PYMT_DESC_LABEL;

	private HtmlInputText COMP_POL_MODE_OF_PYMT_DESC;

	private HtmlOutputLabel COMP_POL_ADDL_STATUS_LABEL;

	private HtmlInputText COMP_POL_ADDL_STATUS;

	private HtmlOutputLabel COMP_POL_LC_FIRST_PREM_LABEL;

	private HtmlInputText COMP_POL_LC_FIRST_PREM;

	private HtmlOutputLabel COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL;

	private HtmlInputText COMP_UI_M_POAD_LC_THRESOLD_LMT;

	private HtmlInputText M_TOT_SA;

	private HtmlOutputLabel COMP_POL_STATUS_DESC_LABEL;

	private HtmlInputText COMP_POL_STATUS_DESC;

	private HtmlOutputLabel COMP_UI_M_TYPE_LABEL;

	private HtmlInputText COMP_UI_M_TYPE;

	private HtmlOutputLabel COMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL;

	private HtmlInputText COMP_UI_M_POAD_LC_THRESHOLD_LMT;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_POAD_ASSURED_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private POLICY_DETAILS POLICY_DETAILS_BEAN;

	private List<POLICY_DETAILS> policyDetailList;

	private UIDataTable policyDetailBlock;

	List<LovBean> suggestionList = null;

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		//COMP_POL_NO.setDisabled(true);
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
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

	public HtmlOutputLabel getCOMP_NEXT_DUE_DATE_LABEL() {
		return COMP_NEXT_DUE_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_NEXT_DUE_DATE() {
		return COMP_NEXT_DUE_DATE;
	}

	public void setCOMP_NEXT_DUE_DATE_LABEL(HtmlOutputLabel COMP_NEXT_DUE_DATE_LABEL) {
		this.COMP_NEXT_DUE_DATE_LABEL = COMP_NEXT_DUE_DATE_LABEL;
	}

	public void setCOMP_NEXT_DUE_DATE(HtmlCalendar COMP_NEXT_DUE_DATE) {
		this.COMP_NEXT_DUE_DATE = COMP_NEXT_DUE_DATE;
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

	public HtmlOutputLabel getCOMP_POL_MODE_OF_PYMT_DESC_LABEL() {
		return COMP_POL_MODE_OF_PYMT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_POL_MODE_OF_PYMT_DESC() {
		return COMP_POL_MODE_OF_PYMT_DESC;
	}

	public void setCOMP_POL_MODE_OF_PYMT_DESC_LABEL(HtmlOutputLabel COMP_POL_MODE_OF_PYMT_DESC_LABEL) {
		this.COMP_POL_MODE_OF_PYMT_DESC_LABEL = COMP_POL_MODE_OF_PYMT_DESC_LABEL;
	}

	public void setCOMP_POL_MODE_OF_PYMT_DESC(HtmlInputText COMP_POL_MODE_OF_PYMT_DESC) {
		this.COMP_POL_MODE_OF_PYMT_DESC = COMP_POL_MODE_OF_PYMT_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_ADDL_STATUS_LABEL() {
		return COMP_POL_ADDL_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_POL_ADDL_STATUS() {
		return COMP_POL_ADDL_STATUS;
	}

	public void setCOMP_POL_ADDL_STATUS_LABEL(HtmlOutputLabel COMP_POL_ADDL_STATUS_LABEL) {
		this.COMP_POL_ADDL_STATUS_LABEL = COMP_POL_ADDL_STATUS_LABEL;
	}

	public void setCOMP_POL_ADDL_STATUS(HtmlInputText COMP_POL_ADDL_STATUS) {
		this.COMP_POL_ADDL_STATUS = COMP_POL_ADDL_STATUS;
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

	public HtmlOutputLabel getCOMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL() {
		return COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAD_LC_THRESOLD_LMT() {
		return COMP_UI_M_POAD_LC_THRESOLD_LMT;
	}

	public void setCOMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL(HtmlOutputLabel COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL) {
		this.COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL = COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL;
	}

	public void setCOMP_UI_M_POAD_LC_THRESOLD_LMT(HtmlInputText COMP_UI_M_POAD_LC_THRESOLD_LMT) {
		this.COMP_UI_M_POAD_LC_THRESOLD_LMT = COMP_UI_M_POAD_LC_THRESOLD_LMT;
	}

	public HtmlOutputLabel getCOMP_POL_STATUS_DESC_LABEL() {
		return COMP_POL_STATUS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_POL_STATUS_DESC() {
		return COMP_POL_STATUS_DESC;
	}

	public void setCOMP_POL_STATUS_DESC_LABEL(HtmlOutputLabel COMP_POL_STATUS_DESC_LABEL) {
		this.COMP_POL_STATUS_DESC_LABEL = COMP_POL_STATUS_DESC_LABEL;
	}

	public void setCOMP_POL_STATUS_DESC(HtmlInputText COMP_POL_STATUS_DESC) {
		this.COMP_POL_STATUS_DESC = COMP_POL_STATUS_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_TYPE_LABEL() {
		return COMP_UI_M_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TYPE() {
		return COMP_UI_M_TYPE;
	}

	public void setCOMP_UI_M_TYPE_LABEL(HtmlOutputLabel COMP_UI_M_TYPE_LABEL) {
		this.COMP_UI_M_TYPE_LABEL = COMP_UI_M_TYPE_LABEL;
	}

	public void setCOMP_UI_M_TYPE(HtmlInputText COMP_UI_M_TYPE) {
		this.COMP_UI_M_TYPE = COMP_UI_M_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL() {
		return COMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAD_LC_THRESHOLD_LMT() {
		return COMP_UI_M_POAD_LC_THRESHOLD_LMT;
	}

	public void setCOMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL(HtmlOutputLabel COMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL) {
		this.COMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL = COMP_UI_M_POAD_LC_THRESHOLD_LMT_LABEL;
	}

	public void setCOMP_UI_M_POAD_LC_THRESHOLD_LMT(HtmlInputText COMP_UI_M_POAD_LC_THRESHOLD_LMT) {
		this.COMP_UI_M_POAD_LC_THRESHOLD_LMT = COMP_UI_M_POAD_LC_THRESHOLD_LMT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POAD_ASSR_CODE() {
		return COMP_UI_M_BUT_LOV_POAD_ASSR_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_POAD_ASSR_CODE(HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_CODE) {
		this.COMP_UI_M_BUT_LOV_POAD_ASSR_CODE = COMP_UI_M_BUT_LOV_POAD_ASSR_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POAD_ASSURED_NAME() {
		return COMP_UI_M_BUT_POAD_ASSURED_NAME;
	}

	public void setCOMP_UI_M_BUT_POAD_ASSURED_NAME(HtmlCommandButton COMP_UI_M_BUT_POAD_ASSURED_NAME) {
		this.COMP_UI_M_BUT_POAD_ASSURED_NAME = COMP_UI_M_BUT_POAD_ASSURED_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POAD_ASSR_REFID1() {
		return COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1;
	}

	public void setCOMP_UI_M_BUT_LOV_POAD_ASSR_REFID1(HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1) {
		this.COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1 = COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POAD_ASSR_REFID2() {
		return COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2;
	}

	public void setCOMP_UI_M_BUT_LOV_POAD_ASSR_REFID2(HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2) {
		this.COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2 = COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton COMP_UI_M_BUT_MAIN) {
		this.COMP_UI_M_BUT_MAIN = COMP_UI_M_BUT_MAIN;
	}

	public POLICY_DETAILS getPOLICY_DETAILS_BEAN() {
		return POLICY_DETAILS_BEAN;
	}

	public void setPOLICY_DETAILS_BEAN(POLICY_DETAILS POLICY_DETAILS_BEAN) {
		this.POLICY_DETAILS_BEAN = POLICY_DETAILS_BEAN;
	}

//	POL_ADDL_COVER_ACTION

	private HtmlOutputLabel COMP_POAC_COVER_CODE_LABEL;

	private HtmlInputText COMP_POAC_COVER_CODE;

	private HtmlOutputLabel COMP_POAC_LC_SA_LABEL;

	private HtmlInputText COMP_POAC_LC_SA;

	private HtmlOutputLabel COMP_UI_M_POAC_TOTAL_LC_SUM_LABEL;

	private HtmlInputText COMP_UI_M_POAC_TOTAL_LC_SUM;

	private HtmlOutputLabel COMP_POAC_PERIOD_LABEL;

	private HtmlInputText COMP_POAC_PERIOD;

	private HtmlOutputLabel COMP_POAC_PREM_PAY_YRS_LABEL;

	private HtmlInputText COMP_POAC_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_UI_M_TOT_LC_SA_LABEL;

	private HtmlInputText COMP_UI_M_TOT_LC_SA;

	private HtmlOutputLabel COMP_POAC_FM_DT_LABEL;

	private HtmlCalendar COMP_POAC_FM_DT;

	private HtmlOutputLabel COMP_POAC_LC_PREM_LABEL;

	private HtmlInputText COMP_POAC_LC_PREM;

	private HtmlOutputLabel COMP_UI_M_POAC_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAC_COVER_DESC;

	private POL_ADDL_COVER POL_ADDL_COVER_BEAN;

	private List<POL_ADDL_COVER> coverList;

	private UIDataTable coverDetailBlock;

	public HtmlOutputLabel getCOMP_POAC_COVER_CODE_LABEL() {
		return COMP_POAC_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POAC_COVER_CODE() {
		return COMP_POAC_COVER_CODE;
	}

	public void setCOMP_POAC_COVER_CODE_LABEL(HtmlOutputLabel COMP_POAC_COVER_CODE_LABEL) {
		this.COMP_POAC_COVER_CODE_LABEL = COMP_POAC_COVER_CODE_LABEL;
	}

	public void setCOMP_POAC_COVER_CODE(HtmlInputText COMP_POAC_COVER_CODE) {
		this.COMP_POAC_COVER_CODE = COMP_POAC_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_POAC_LC_SA_LABEL() {
		return COMP_POAC_LC_SA_LABEL;
	}

	public HtmlInputText getCOMP_POAC_LC_SA() {
		return COMP_POAC_LC_SA;
	}

	public void setCOMP_POAC_LC_SA_LABEL(HtmlOutputLabel COMP_POAC_LC_SA_LABEL) {
		this.COMP_POAC_LC_SA_LABEL = COMP_POAC_LC_SA_LABEL;
	}

	public void setCOMP_POAC_LC_SA(HtmlInputText COMP_POAC_LC_SA) {
		this.COMP_POAC_LC_SA = COMP_POAC_LC_SA;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_TOTAL_LC_SUM_LABEL() {
		return COMP_UI_M_POAC_TOTAL_LC_SUM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAC_TOTAL_LC_SUM() {
		return COMP_UI_M_POAC_TOTAL_LC_SUM;
	}

	public void setCOMP_UI_M_POAC_TOTAL_LC_SUM_LABEL(HtmlOutputLabel COMP_UI_M_POAC_TOTAL_LC_SUM_LABEL) {
		this.COMP_UI_M_POAC_TOTAL_LC_SUM_LABEL = COMP_UI_M_POAC_TOTAL_LC_SUM_LABEL;
	}

	public void setCOMP_UI_M_POAC_TOTAL_LC_SUM(HtmlInputText COMP_UI_M_POAC_TOTAL_LC_SUM) {
		this.COMP_UI_M_POAC_TOTAL_LC_SUM = COMP_UI_M_POAC_TOTAL_LC_SUM;
	}

	public HtmlOutputLabel getCOMP_POAC_PERIOD_LABEL() {
		return COMP_POAC_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_POAC_PERIOD() {
		return COMP_POAC_PERIOD;
	}

	public void setCOMP_POAC_PERIOD_LABEL(HtmlOutputLabel COMP_POAC_PERIOD_LABEL) {
		this.COMP_POAC_PERIOD_LABEL = COMP_POAC_PERIOD_LABEL;
	}

	public void setCOMP_POAC_PERIOD(HtmlInputText COMP_POAC_PERIOD) {
		this.COMP_POAC_PERIOD = COMP_POAC_PERIOD;
	}

	public HtmlOutputLabel getCOMP_POAC_PREM_PAY_YRS_LABEL() {
		return COMP_POAC_PREM_PAY_YRS_LABEL;
	}

	public HtmlInputText getCOMP_POAC_PREM_PAY_YRS() {
		return COMP_POAC_PREM_PAY_YRS;
	}

	public void setCOMP_POAC_PREM_PAY_YRS_LABEL(HtmlOutputLabel COMP_POAC_PREM_PAY_YRS_LABEL) {
		this.COMP_POAC_PREM_PAY_YRS_LABEL = COMP_POAC_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_POAC_PREM_PAY_YRS(HtmlInputText COMP_POAC_PREM_PAY_YRS) {
		this.COMP_POAC_PREM_PAY_YRS = COMP_POAC_PREM_PAY_YRS;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOT_LC_SA_LABEL() {
		return COMP_UI_M_TOT_LC_SA_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOT_LC_SA() {
		return COMP_UI_M_TOT_LC_SA;
	}

	public void setCOMP_UI_M_TOT_LC_SA_LABEL(HtmlOutputLabel COMP_UI_M_TOT_LC_SA_LABEL) {
		this.COMP_UI_M_TOT_LC_SA_LABEL = COMP_UI_M_TOT_LC_SA_LABEL;
	}

	public void setCOMP_UI_M_TOT_LC_SA(HtmlInputText COMP_UI_M_TOT_LC_SA) {
		this.COMP_UI_M_TOT_LC_SA = COMP_UI_M_TOT_LC_SA;
	}

	public HtmlOutputLabel getCOMP_POAC_FM_DT_LABEL() {
		return COMP_POAC_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POAC_FM_DT() {
		return COMP_POAC_FM_DT;
	}

	public void setCOMP_POAC_FM_DT_LABEL(HtmlOutputLabel COMP_POAC_FM_DT_LABEL) {
		this.COMP_POAC_FM_DT_LABEL = COMP_POAC_FM_DT_LABEL;
	}

	public void setCOMP_POAC_FM_DT(HtmlCalendar COMP_POAC_FM_DT) {
		this.COMP_POAC_FM_DT = COMP_POAC_FM_DT;
	}

	public HtmlOutputLabel getCOMP_POAC_LC_PREM_LABEL() {
		return COMP_POAC_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POAC_LC_PREM() {
		return COMP_POAC_LC_PREM;
	}

	public void setCOMP_POAC_LC_PREM_LABEL(HtmlOutputLabel COMP_POAC_LC_PREM_LABEL) {
		this.COMP_POAC_LC_PREM_LABEL = COMP_POAC_LC_PREM_LABEL;
	}

	public void setCOMP_POAC_LC_PREM(HtmlInputText COMP_POAC_LC_PREM) {
		this.COMP_POAC_LC_PREM = COMP_POAC_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_COVER_DESC_LABEL() {
		return COMP_UI_M_POAC_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAC_COVER_DESC() {
		return COMP_UI_M_POAC_COVER_DESC;
	}

	public void setCOMP_UI_M_POAC_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POAC_COVER_DESC_LABEL) {
		this.COMP_UI_M_POAC_COVER_DESC_LABEL = COMP_UI_M_POAC_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAC_COVER_DESC(HtmlInputText COMP_UI_M_POAC_COVER_DESC) {
		this.COMP_UI_M_POAC_COVER_DESC = COMP_UI_M_POAC_COVER_DESC;
	}

	public POL_ADDL_COVER getPOL_ADDL_COVER_BEAN() {
		return POL_ADDL_COVER_BEAN;
	}

	public void setPOL_ADDL_COVER_BEAN(POL_ADDL_COVER POL_ADDL_COVER_BEAN) {
		this.POL_ADDL_COVER_BEAN = POL_ADDL_COVER_BEAN;
	}

//	POL_DISC_LOAD_ACTION

	private HtmlOutputLabel COMP_PDL_DISC_LOAD_CODE_LABEL;

	private HtmlInputText COMP_PDL_DISC_LOAD_CODE;

	private HtmlOutputLabel COMP_PDL_RATE_LABEL;

	private HtmlInputText COMP_PDL_RATE;

	private HtmlOutputLabel COMP_PDL_RATE_PER_LABEL;

	private HtmlInputText COMP_PDL_RATE_PER;

	private HtmlOutputLabel COMP_PDL_LC_DISC_LOAD_VALUE_LABEL;

	private HtmlInputText COMP_PDL_LC_DISC_LOAD_VALUE;

	private HtmlOutputLabel COMP_UI_M_DISCLOAD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DISCLOAD_DESC;

	private POL_DISC_LOAD POL_DISC_LOAD_BEAN;

	private List<POL_DISC_LOAD> loadList;

	private UIDataTable discountDetailBlock;

	public HtmlOutputLabel getCOMP_PDL_DISC_LOAD_CODE_LABEL() {
		return COMP_PDL_DISC_LOAD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PDL_DISC_LOAD_CODE() {
		return COMP_PDL_DISC_LOAD_CODE;
	}

	public void setCOMP_PDL_DISC_LOAD_CODE_LABEL(HtmlOutputLabel COMP_PDL_DISC_LOAD_CODE_LABEL) {
		this.COMP_PDL_DISC_LOAD_CODE_LABEL = COMP_PDL_DISC_LOAD_CODE_LABEL;
	}

	public void setCOMP_PDL_DISC_LOAD_CODE(HtmlInputText COMP_PDL_DISC_LOAD_CODE) {
		this.COMP_PDL_DISC_LOAD_CODE = COMP_PDL_DISC_LOAD_CODE;
	}

	public HtmlOutputLabel getCOMP_PDL_RATE_LABEL() {
		return COMP_PDL_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PDL_RATE() {
		return COMP_PDL_RATE;
	}

	public void setCOMP_PDL_RATE_LABEL(HtmlOutputLabel COMP_PDL_RATE_LABEL) {
		this.COMP_PDL_RATE_LABEL = COMP_PDL_RATE_LABEL;
	}

	public void setCOMP_PDL_RATE(HtmlInputText COMP_PDL_RATE) {
		this.COMP_PDL_RATE = COMP_PDL_RATE;
	}

	public HtmlOutputLabel getCOMP_PDL_RATE_PER_LABEL() {
		return COMP_PDL_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PDL_RATE_PER() {
		return COMP_PDL_RATE_PER;
	}

	public void setCOMP_PDL_RATE_PER_LABEL(HtmlOutputLabel COMP_PDL_RATE_PER_LABEL) {
		this.COMP_PDL_RATE_PER_LABEL = COMP_PDL_RATE_PER_LABEL;
	}

	public void setCOMP_PDL_RATE_PER(HtmlInputText COMP_PDL_RATE_PER) {
		this.COMP_PDL_RATE_PER = COMP_PDL_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PDL_LC_DISC_LOAD_VALUE_LABEL() {
		return COMP_PDL_LC_DISC_LOAD_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_PDL_LC_DISC_LOAD_VALUE() {
		return COMP_PDL_LC_DISC_LOAD_VALUE;
	}

	public void setCOMP_PDL_LC_DISC_LOAD_VALUE_LABEL(HtmlOutputLabel COMP_PDL_LC_DISC_LOAD_VALUE_LABEL) {
		this.COMP_PDL_LC_DISC_LOAD_VALUE_LABEL = COMP_PDL_LC_DISC_LOAD_VALUE_LABEL;
	}

	public void setCOMP_PDL_LC_DISC_LOAD_VALUE(HtmlInputText COMP_PDL_LC_DISC_LOAD_VALUE) {
		this.COMP_PDL_LC_DISC_LOAD_VALUE = COMP_PDL_LC_DISC_LOAD_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DISCLOAD_DESC_LABEL() {
		return COMP_UI_M_DISCLOAD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DISCLOAD_DESC() {
		return COMP_UI_M_DISCLOAD_DESC;
	}

	public void setCOMP_UI_M_DISCLOAD_DESC_LABEL(HtmlOutputLabel COMP_UI_M_DISCLOAD_DESC_LABEL) {
		this.COMP_UI_M_DISCLOAD_DESC_LABEL = COMP_UI_M_DISCLOAD_DESC_LABEL;
	}

	public void setCOMP_UI_M_DISCLOAD_DESC(HtmlInputText COMP_UI_M_DISCLOAD_DESC) {
		this.COMP_UI_M_DISCLOAD_DESC = COMP_UI_M_DISCLOAD_DESC;
	}

	public POL_DISC_LOAD getPOL_DISC_LOAD_BEAN() {
		return POL_DISC_LOAD_BEAN;
	}

	public void setPOL_DISC_LOAD_BEAN(POL_DISC_LOAD POL_DISC_LOAD_BEAN) {
		this.POL_DISC_LOAD_BEAN = POL_DISC_LOAD_BEAN;
	}

	public List<POLICY_DETAILS> getPolicyDetailList() {

		if (policyDetailList.size() == 0 ){
			/*for (int i=0; i<5;i++){
				POLICY_DETAILS polDtls = new POLICY_DETAILS();
				policyDetailList.add(polDtls);
			}*/
			policyDetailList = new ArrayList<POLICY_DETAILS>();
		}		
		return policyDetailList;
	}

	public void setPolicyDetailList(List<POLICY_DETAILS> policyDetailList) {
		this.policyDetailList = policyDetailList;
	}

	public List<POL_ADDL_COVER> getCoverList() {
		return coverList;
	}

	public void setCoverList(List<POL_ADDL_COVER> coverList) {
		this.coverList = coverList;
	}

	public List<POL_DISC_LOAD> getLoadList() {
		return loadList;
	}

	public void setLoadList(List<POL_DISC_LOAD> loadList) {
		this.loadList = loadList;
	}

	public void loadingBaseValues(PhaseEvent e ) {
		FacesContext fc = FacesContext.getCurrentInstance();
		session = fc.getExternalContext().getSessionMap();
		if(session.get("isPreformFired") == null) {
			preForm();
			session.put("isPreformFired","true");
		} 
	}

	public String preForm(){
		System.out.println("Preform Starting ................ ");
		FacesContext fc = FacesContext.getCurrentInstance();
		ArrayList<OracleParameter> list =null;
		Map<String, Object> session = fc.getExternalContext().getSessionMap();
		session.put("GLOBAL.M_FAILURE", "FALSE");

//		values should take from GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME)
//		Developing purpose hard coded it.
		session.put("GLOBAL.M_MODULE_NAME", "PILQ004");
		System.out.println("PT_IL_RI_DETL_ACTION.preForm() getSessionMap: "+fc.getExternalContext().getSessionMap());

//		calling STD_PRE_FORM PLL
		STD_PRE_FORM();

		ControlBean ctrlbean = CommonUtils.getControlBean();
		String M_TITLE = ctrlbean.getM_USER_ID()+" "+ctrlbean.getM_SCR_NAME()+" "+new Date();

		System.out.println("PT_IL_RI_DETL_ACTION getM_USER_ID : getM_SCR_NAME() ---->> "+M_TITLE);


//		SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
//		values should take from GET_APPLICATION_PROPERTY(CALLING_FORM)
//		Developing purpose hard coded "PILT010".
//		if(GET_APPLICATION_PROPERTY(CALLING_FORM) !="PILT002%"){
//		session.put("GLOBAL.M_POL_NO", "NULL");

		/*		   IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILT002%' THEN


		   	  :ASSRD_DTLS.POAD_ASSR_CODE    := :GLOBAL.POAD_ASSR_CODE;
					:ASSRD_DTLS.POAD_ASSURED_NAME := :GLOBAL.POAD_ASSURED_NAME;
				 	:ASSRD_DTLS.POAD_ASSRD_REF_ID1 := :GLOBAL.POAD_REF_ID1;      
		      :ASSRD_DTLS.POAD_ASSRD_REF_ID2 :=:GLOBAL.POAD_REF_ID2;


		   		SET_ITEM_PROPERTY('ASSRD_DTLS.M_BUT_MAIN',ENABLED,PROPERTY_TRUE);
		   		SET_BLOCK_PROPERTY('ASSRD_DTLS',INSERT_ALLOWED,PROPERTY_FALSE);
		   		SET_BLOCK_PROPERTY('ASSRD_DTLS',UPDATE_ALLOWED,PROPERTY_FALSE);
		   		SET_BLOCK_PROPERTY('ASSRD_DTLS',DELETE_ALLOWED,PROPERTY_FALSE);
		   		SET_BLOCK_PROPERTY('ASSRD_DTLS',QUERY_ALLOWED,PROPERTY_TRUE);

		   ELSIF GET_APPLICATION_PROPERTY(CALLING_FORM) = 'PILT002_APAC' THEN

		       :ASSRD_DTLS.POAD_ASSR_CODE    := :GLOBAL.POAD_ASSR_CODE;
				 	:ASSRD_DTLS.POAD_ASSURED_NAME := :GLOBAL.POAD_ASSURED_NAME;
				 	:ASSRD_DTLS.POAD_ASSRD_REF_ID1 := :GLOBAL.POAD_REF_ID1;      
		      :ASSRD_DTLS.POAD_ASSRD_REF_ID2 :=:GLOBAL.POAD_REF_ID2;  
		      SET_ITEM_PROPERTY('ASSRD_DTLS.M_BUT_LOV_POAD_ASSR_CODE',ENABLED,PROPERTY_TRUE);
		   		SET_ITEM_PROPERTY('ASSRD_DTLS.POAD_ASSR_CODE',ENABLED,PROPERTY_TRUE);
		   		SET_ITEM_PROPERTY('ASSRD_DTLS..M_BUT_MAIN',ENABLED,PROPERTY_TRUE);
		  ELSIF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'GNMNF001_A%' THEN 

		      SET_BLOCK_PROPERTY('ASSRD_DTLS',INSERT_ALLOWED,PROPERTY_FALSE);
		   		SET_BLOCK_PROPERTY('ASSRD_DTLS',UPDATE_ALLOWED,PROPERTY_FALSE);
		   		SET_BLOCK_PROPERTY('ASSRD_DTLS',DELETE_ALLOWED,PROPERTY_FALSE);
		   		SET_BLOCK_PROPERTY('ASSRD_DTLS',QUERY_ALLOWED,PROPERTY_TRUE);  
		   		SET_ITEM_PROPERTY('ASSRD_DTLS.M_BUT_MAIN',ENABLED,PROPERTY_FALSE);

		  ELSE
		   	  SET_ITEM_PROPERTY('ASSRD_DTLS.M_BUT_LOV_POAD_ASSR_CODE',ENABLED,PROPERTY_TRUE);
		   	  SET_ITEM_PROPERTY('ASSRD_DTLS.POAD_ASSR_CODE',ENABLED,PROPERTY_TRUE);
		   	  SET_ITEM_PROPERTY('ASSRD_DTLS.POAD_ASSR_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
		   	  SET_ITEM_PROPERTY('ASSRD_DTLS.POAD_ASSR_CODE',NAVIGABLE,PROPERTY_TRUE);
		   	 	SET_ITEM_PROPERTY('ASSRD_DTLS..M_BUT_MAIN',ENABLED,PROPERTY_FALSE);
		   END IF;*/
//		}
		System.out.println("Preform Ending ................ ");
		return null;
	}    


	public void STD_PRE_FORM(){
//		P_GET_LOGO;
//		COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');

		ControlBean ctrlBean = CommonUtils.getControlBean();

//		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM()\n---------->\n"+session.toString()+"\n----------");
		ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
//		bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
//		ctrlBean.setM_PROG_NAME("PILT010");
//		COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30), 'BUTTON_PALETTE.M_COMP_NAME') ;
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM(------)" +(String)session.get("GLOBAL.M_NAME"));
//		COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM()--- \n "+ctrlBean.getM_LANG_CODE()+"\t"+ctrlBean.getM_COMP_CODE()+"\t"+ctrlBean.getM_PARA_1());
		/** GLOBAL.M_MODULE_NAME IS ADDED IN ORDER TO QUERY HINT DETAILS IN RECORD GROUP **/
		/* M_MODULE_NAME := GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME) ;
   COPY(M_MODULE_NAME,'GLOBAL.M_MODULE_NAME') ;
   M_TITLE:= NAME_IN('CTRL.M_USER_ID') ||'                 '||NAME_IN('CTRL.M_SCR_NAME')||'          '||TO_CHAR(SYSDATE,'DD/MM/YY');
   SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
   HIDE_VIEW('ABOUT');
   M_FIRST_BLOCK := GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(
                         CURRENT_FORM_NAME), FIRSTBLOCK) ;

   LOOP
      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,INSERT_ALLOWED) = 'TRUE' THEN
         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),1,1) = 'Y' THEN
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_TRUE) ;
         ELSE
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_FALSE) ;
         END IF ;
      END IF;
      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,UPDATE_ALLOWED) = 'TRUE' THEN
         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),2,1) = 'Y' THEN
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_TRUE) ;
         ELSE
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_FALSE) ;
         END IF ;
      END IF;
      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,DELETE_ALLOWED) = 'TRUE' THEN
         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),3,1) = 'Y' THEN
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_TRUE) ;
         ELSE
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_FALSE) ;
         END IF ;
      END IF;
      M_FIRST_BLOCK := GET_BLOCK_PROPERTY(M_FIRST_BLOCK, NEXTBLOCK) ;
      IF M_FIRST_BLOCK IN ('DUAL','CTRL','BUTTON_PALETTE') THEN
         EXIT ;
      END IF ;
   END LOOP ;

   RG_ID	:= FIND_GROUP('RG_HINT') ;
   IF ID_NULL(RG_ID) THEN
      NULL ;
   ELSE
      M_QUERY_OK := POPULATE_GROUP(RG_ID) ;
   END IF ;
   RG_ID	:= FIND_GROUP('RG_ALERT_MSG') ;
   IF ID_NULL(RG_ID) THEN
      NULL ;
   ELSE
      M_QUERY_OK := POPULATE_GROUP(RG_ID) ;
   END IF ;
   LOAD_BP;
   ENABLE_BUTTONS ;
   IF M_MODULE_NAME NOT LIKE 'GNMNF001%' THEN
      LOAD_BALOON_LABEL;
   END IF;
END;*/
	}

	public Connection getConnection() throws Exception{
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		Connection con=((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("123456");		
		return con;
	}

	public List displayLovOld(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		getCOMP_POAD_ASSR_CODE().setSubmittedValue(null);
		String query = null;
		System.out.println("PT_IL_RI_DETL_ACTION.suggesion() "+obj.toString()+"\t "+obj.toString().equals("*"));
		if(obj.toString().equals("*")){
			query = "SELECT POAD_ASSR_CODE,POAD_ASSURED_NAME FROM PT_IL_POL_ASSURED_DTLS WHERE rownum < 25";
		}else{
			query = "SELECT POAD_ASSR_CODE,POAD_ASSURED_NAME FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_ASSR_CODE LIKE '"+obj.toString()+"%' and rownum < 25";
		}
		connection = getConnection();
		System.out.println("PT_IL_RI_DETL_ACTION.suggesion() Query :::::::  "+query);
		ResultSet rs = getHandler().executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			AssuredCodeLovBean bean = new AssuredCodeLovBean();
			bean.setCode(rs.getString("POAD_ASSR_CODE"));
			bean.setName(rs.getString("POAD_ASSURED_NAME"));
			suggesionList.add(bean);
		}
		rs.close();
		return suggesionList;
	}
	
	public ArrayList<LovBean> displayLov(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT CONT_CODE,CONT_NAME FROM PM_IL_CONTRACTOR WHERE  (CONT_CODE LIKE ? OR CONT_NAME LIKE ?) AND ROWNUM < ?";
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

	public void executeQueryPOLICY_DETAILS() throws SQLException,Exception {
		Double tempValue = 0.0;
		//String preQueryString = preQueryPOLICY_DETAILS();

	//	preQueryString = "SELECT * FROM PT_IL_POLICY WHERE "+preQueryString;
		//System.out.println("\n\nASSRD_DTLS_ACTION.executeQueryPOLICY_DETAILS() preQueryString: "+preQueryString);		
//		List<POLICY_DETAILS> preQueryList = executeQueryPOLICY_DETAILS(preQueryString);
//		List<POLICY_DETAILS> postQueryList = postQueryPOLICY_DETAILS(preQueryList);

//		for(Iterator<POLICY_DETAILS> iterator = postQueryList.iterator(); iterator.hasNext(); ) {
//			UI_M_TOT_SAValue += iterator.next().getPOL_LC_SUM_ASSURED();
//		}
//
//		System.out.println("ASSRD_DTLS_ACTION.executeQueryPOLICY_DETAILS() COMP_UI_M_TOT_SA : "+UI_M_TOT_SAValue);
//		System.out.println("ASSRD_DTLS_ACTION.executeQueryPOLICY_DETAILS() +++ "+postQueryList.get(0).getPOL_STATUS_DESC());
//		setPolicyDetailList(postQueryList);
		//policyDetailList= executeQueryPOLICY_DETAILS(preQueryString);
		List<POLICY_DETAILS> postQueryList = postQueryPOLICY_DETAILS(policyDetailList);
		for(Iterator<POLICY_DETAILS> iterator = postQueryList.iterator(); iterator.hasNext(); ) {
			UI_M_TOT_SAValue += iterator.next().getPOL_LC_SUM_ASSURED();
		}
		if(policyDetailList!=null){
			for(int i=0;i<getPolicyDetailList().size();i++){
				POLICY_DETAILS policy_details = getPolicyDetailList().get(i);
				if(i==0){
					policy_details.setRowSelected(true);
					this.POLICY_DETAILS_BEAN = policy_details;
					policy_details_on_populate_details(null);
				}else{
					policy_details.setRowSelected(false);
				}
			}
		}else{
			this.coverList.clear();
			this.loadList.clear();
		}
		if(coverList.isEmpty()){
			this.setPOL_ADDL_COVER_BEAN(new POL_ADDL_COVER());
		}
		if(loadList.isEmpty()){
			this.setPOL_DISC_LOAD_BEAN(new POL_DISC_LOAD());
		}
		
		resetAllComponent();
		
		System.out.println("ASSRD_DTLS_ACTION.executeQueryPOLICY_DETAILS() COMP_UI_M_TOT_SA : "+UI_M_TOT_SAValue);
		System.out.println("ASSRD_DTLS_ACTION.executeQueryPOLICY_DETAILS() +++ "+postQueryList.get(0).getPOL_STATUS_DESC());
	}

	private List<POLICY_DETAILS> executeQueryPOLICY_DETAILS(String preQueryString) throws SQLException,Exception {
		policyDetailList.clear();
		System.out.println("ASSRD_DTLS_ACTION.executeQueryPOLICY_DETAILS(----)");
		CRUDHandler handler = new CRUDHandler();
		List<POLICY_DETAILS> preQueryList = handler.fetch(preQueryString, "com.iii.pel.forms.PILQ004_APAC.POLICY_DETAILS", getConnection());
//		if (policyDetailList.size() != 5 ){
//		for (int i=policyDetailList.size(); i<5;i++){
//		POLICY_DETAILS polDtls = new POLICY_DETAILS();
//		policyDetailList.add(polDtls);
//		}
//		}
		System.out.println("ASSRD_DTLS_ACTION.executeQueryPOLICY_DETAILS(...)");
		return preQueryList;
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> poadAssrCode(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILQ004_APAC", "ASSRD_DTLS",
					"POAD_ASSR_CODE", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggestionList;
	}

	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> poadAssrRefID1(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILQ004_APAC", "ASSRD_DTLS",
					"POAD_ASSRD_REF_ID1", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggestionList;
	}

	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> poadAssrRefID2(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILQ004_APAC", "ASSRD_DTLS",
					"POAD_ASSRD_REF_ID2", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggestionList;
	}

	


	@SuppressWarnings("unchecked")
	public void policy_details_on_populate_details(ActionEvent event) throws Exception {
		System.out.println("\n\nASSRD_DTLS_ACTION.policy_details_on_populate_details() Starting ....... ");
		coverList.clear();
		loadList.clear();
//		String RECSTAT = :SYSTEM.RECORD_STATUS;
//		String STARTITM=:SYSTEM.CURSOR_ITEM;
		String query = "";
		//POLICY_DETAILS policyDetailsBean = (POLICY_DETAILS) policyDetailBlock.getRowData();
		POLICY_DETAILS policyDetailsBean = this.POLICY_DETAILS_BEAN;
		System.out
		.println("ASSRD_DTLS_ACTION.policy_details_on_populate_details() policyDetailsBean.getPOL_SYS_ID(): "+policyDetailsBean.getPOL_SYS_ID());
		double sysId = policyDetailsBean.getPOL_SYS_ID();
System.out.println("ASSRD_DTLS_ACTION.policy_details_on_populate_details(sysId)-----[ "+sysId+" ]-------");
		if(((sysId != -1))) {
			query = "select * from PT_IL_POL_ADDL_COVER where POAC_POL_SYS_ID="+sysId+"";
			System.out.println("ASSRD_DTLS_ACTION.policy_details_on_populate_details() query -1-1: "+query);
			CRUDHandler handler = new CRUDHandler();
			coverList = handler.fetch(query, "com.iii.pel.forms.PILQ004_APAC.POL_ADDL_COVER", getConnection());
			if(coverList.size() > 0) {
				coverList = postQueryPOL_ADDL_COVER(coverList);
			} else {
				getCOMP_UI_M_POAC_TOTAL_LC_SUM().setSubmittedValue("");
				getCOMP_UI_M_TOT_LC_SA().setSubmittedValue("");
			}
			
			if(coverList!=null && !coverList.isEmpty()){
				for(int i =0;i<coverList.size();i++){
					POL_ADDL_COVER addtionalCover = (POL_ADDL_COVER)coverList.get(i);
					if(i==0){
						addtionalCover.setRowSelected(true);
						this.setPOL_ADDL_COVER_BEAN(addtionalCover);
					}else{
						addtionalCover.setRowSelected(false);
					}
				}
			}
			
		}

		if(((sysId != -1 ))) {
			query = "select * from PT_IL_POL_DISC_LOAD where PDL_POL_SYS_ID="+sysId+"";
			CRUDHandler handler = new CRUDHandler();
			loadList = handler.fetch(query, "com.iii.pel.forms.PILQ004_APAC.POL_DISC_LOAD", getConnection());
			if(loadList.size() > 0) {
				postQueryPOL_DISC_LOAD(loadList);
			}
			
			if(loadList!=null && !loadList.isEmpty()){
				for(int i=0;i<loadList.size();i++){
					POL_DISC_LOAD pol_disc_load = loadList.get(i);
					if(i==0){
						pol_disc_load.setRowSelected(true);
						this.setPOL_DISC_LOAD_BEAN(pol_disc_load);
					}else{
						pol_disc_load.setRowSelected(false);
					}
				}
			}
		}

		System.out.println("nASSRD_DTLS_ACTION.policy_details_on_populate_details() Ending ....... \n\n ");
	}

	private List<POL_DISC_LOAD> postQueryPOL_DISC_LOAD(List<POL_DISC_LOAD> loadList) throws Exception {

		POL_DISC_LOAD loadBean =  loadList.get(0);

		List<POL_DISC_LOAD> postQueryList = new ArrayList<POL_DISC_LOAD>();

		String  M_TYPE=null;

		if(loadBean.getPDL_DISC_LOAD_CODE() != null)
		{
			if(loadBean.getPDL_DISC_LOAD_TYPE()=="D")
			{
				M_TYPE="IL_DISC";
			}
			else
			{
				M_TYPE="IL_LOAD";
			}
//			P_VAL_CODES.P_VAL_CODES(M_TYPE,:POL_DISC_LOAD.PDL_DISC_LOAD_CODE,:POL_DISC_LOAD.M_DISCLOAD_DESC,"N","N",null);

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",M_TYPE);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN",loadBean.getPDL_DISC_LOAD_CODE());
			OracleParameter param3 = new OracleParameter("in3","STRING","IN OUT",loadBean.getUI_M_DISCLOAD_DESC());
			OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
			OracleParameter param5 = new OracleParameter("in5","STRING","IN","'N'");
			OracleParameter param6 = new OracleParameter("in6","STRING","IN",null);
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);
			paramList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "P_VAL_CODES");
			System.out.println("ASSRD_DTLS_ACTION.postQueryPOLICY_DETAILS() P_VAL_PLAN: "+list.get(0).getValue());
			loadBean.setUI_M_DISCLOAD_DESC(list.get(0).getValue());
			postQueryList.add(loadBean);
		}
		return postQueryList;
	}

	public List<POLICY_DETAILS> postQueryPOLICY_DETAILS(List preQueryList)throws SQLException,Exception {
		System.out.println(" \n\n ASSRD_DTLS_ACTION.postQueryPOLICY_DETAILS() Starting .............. ");		
		ArrayList<OracleParameter> list =null;
		List<POLICY_DETAILS> postQueryList = new ArrayList<POLICY_DETAILS>();
		
			connection = getConnection();

			CRUDHandler handler = new CRUDHandler();
//			ResultSet rs = handler.executeSelectStatement(selectQuery,connection);

			System.out.println("ASSRD_DTLS_ACTION.postQueryPOLICY_DETAILS() >>>>> "+((POLICY_DETAILS)preQueryList.get(0)).getPOL_STATUS());

			String  M_POAD_LC_THRESHOLD_LMT=null;
			String  M_POAD_SYS_ID=null;
			ResultSet vembu_C1=null;
//			Statement stmt_C1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet vembu_C2=null;
//			Statement stmt_C2=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			

			for(Iterator <POLICY_DETAILS> iterator = preQueryList.iterator() ; iterator.hasNext(); ) {

				POLICY_DETAILS policyDetailsBean = iterator.next();

				String sql_C1="SELECT PC_SCHD_PYMT_DT FROM  PT_IL_PREM_COLL  WHERE  PC_POL_SYS_ID  = '"+policyDetailsBean.getPOL_SYS_ID()+"' AND NVL(PC_PAID_FLAG, 'N')  = 'N' ";
				String sql_C2="SELECT POAD_LC_THRESHOLD_LMT, POAD_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID  = '"+policyDetailsBean.getPOL_SYS_ID()+"'";

				System.out.println("\n\nsql_C1: "+sql_C1+"\n\nsql_C2: "+sql_C2);

				String policyStatus = policyDetailsBean.getPOL_STATUS();
				String modeOfPayment = policyDetailsBean.getPOL_MODE_OF_PYMT();
				String ds_type = policyDetailsBean.getPOL_DS_TYPE();

				System.out.println("ASSRD_DTLS_ACTION.postQueryPOLICY_DETAILS() policyStatus: "+policyStatus);			

				if("A".equals(policyStatus))
				{
					policyDetailsBean.setPOL_STATUS_DESC("APPROVED");
				}
				else if("C".equals(policyStatus))
				{
					policyDetailsBean.setPOL_STATUS_DESC("CANCELLED");
				}
				else if("E".equals(policyStatus))
				{
					policyDetailsBean.setPOL_STATUS_DESC("ENDORSED");
				}
				else if("M".equals(policyStatus))
				{
					policyDetailsBean.setPOL_STATUS_DESC("MATURED");
				}
				else if("S".equals(policyStatus))
				{
					policyDetailsBean.setPOL_STATUS_DESC("SURRENDERED");
				}
				else if("P".equals(policyStatus))
				{
					policyDetailsBean.setPOL_STATUS_DESC("PAIDUP");
				}
				else if("D".equals(policyStatus))
				{
					policyDetailsBean.setPOL_STATUS_DESC("DEATH CLAIM");
				}
				else if("R".equals(policyStatus))
				{
					policyDetailsBean.setPOL_STATUS_DESC("RE-INSTATED");
				}
				if("S".equals(modeOfPayment))
				{
					policyDetailsBean.setPOL_MODE_OF_PYMT_DESC("SINGLE");
				}
				else if("Y".equals(modeOfPayment))
				{
					policyDetailsBean.setPOL_MODE_OF_PYMT_DESC("YEARLY");
				}
				else if("H".equals(modeOfPayment))
				{
					policyDetailsBean.setPOL_MODE_OF_PYMT_DESC("HALF-YEARLY");
				}
				else if("Q".equals(modeOfPayment))
				{
					policyDetailsBean.setPOL_MODE_OF_PYMT_DESC("QUARTERLY");
				}
				else if("M".equals(modeOfPayment))
				{
					policyDetailsBean.setPOL_MODE_OF_PYMT_DESC("MONTHLY");
				}
				if("1".equals(ds_type))
				{
					policyDetailsBean.setUI_M_TYPE("PROPOSAL");
				}
				else if("2".equals(ds_type))
				{
					policyDetailsBean.setUI_M_TYPE("POLICY");
				}

				ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("in1","STRING","IN", policyDetailsBean.getPOL_PLAN_CODE());
				OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT",policyDetailsBean.getUI_M_POL_PLAN_DESC());
				OracleParameter param3 = new OracleParameter("in3","STRING","IN","'N'");
				OracleParameter param4 = new OracleParameter("in4","STRING","IN","'E'");
				paramList.add(param1);
				paramList.add(param2);
				paramList.add(param3);
				paramList.add(param4);

				OracleProcedureHandler procHandler = new OracleProcedureHandler();

			//	list = procHandler.execute(paramList, connection, "P_VAL_PLAN");

				String planDesc = null;
				planDesc =  new DBProcedures().P_VAL_PLAN(policyDetailsBean.getPOL_PLAN_CODE(), "N", "E");
				policyDetailsBean.setUI_M_POL_PLAN_DESC(planDesc);

//				P_VAL_PLAN.P_VAL_PLAN(:POLICY_DETAILS.POL_PLAN_CODE,:M_POL_PLAN_DESC,"N","E");
//				P_SET_FC_NUM_FMT_MASK.P_SET_FC_NUM_FMT_MASK(:POLICY_DETAILS.POL_CUST_CURR_CODE);

				if(vembu_C1!=null) {
					vembu_C1.close();
				}

				vembu_C1 = handler.executeSelectStatement(sql_C1, connection);
				if(vembu_C1.next()){
					policyDetailsBean.setNEXT_DUE_DATE(vembu_C1.getDate("PC_SCHD_PYMT_DT"));
				}
				vembu_C1.close();

				if(vembu_C2!=null) {
					vembu_C2.close();
				}
				vembu_C2 = handler.executeSelectStatement(sql_C2, connection);
				if(vembu_C2.next())
				{
					policyDetailsBean.setUI_M_POAD_TOT_THRESOLD_LMT(vembu_C2.getDouble(1));
					M_POAD_SYS_ID = vembu_C2.getString(2);
					M_POAD_LC_THRESHOLD_LMT = vembu_C2.getString(1);
					System.out.println("SRIDHAR_1" + policyDetailsBean.getUI_M_POAD_TOT_THRESOLD_LMT());
				}
				System.out.println("SRIDHAR_2" + policyDetailsBean.getUI_M_POAD_TOT_THRESOLD_LMT());
				vembu_C2.close();

				paramList.clear();
				OracleParameter param11 = new OracleParameter("in1","DOUBLE","IN", String.valueOf(policyDetailsBean.getPOL_SYS_ID()));
				OracleParameter param22 = new OracleParameter("in2","STRING","IN",M_POAD_SYS_ID);
				OracleParameter param33 = new OracleParameter("in3","STRING","OUT",M_POAD_LC_THRESHOLD_LMT);
				paramList.add(param11);
				paramList.add(param22);
				paramList.add(param33);

				list = procHandler.execute(paramList, connection, "P9ILPK_POLICY.CALC_ASSRD_THRESHOLD_LIMIT");
				policyDetailsBean.setUI_M_POAD_LC_THRESOLD_LMT(Double.parseDouble(list.get(0).getValue()));
				System.out.println("ASSRD_DTLS_ACTION.postQueryPOLICY_DETAILS() listlistlist::: "+list.get(0).getValue());
				postQueryList.add(policyDetailsBean);
			}

//			try{
//			p9ilpk_policy.p9ilpk_policy.calc_assrd_threshold_limit(:POLICY_DETAILS.POL_SYS_ID,M_POAD_SYS_ID,:POLICY_DETAILS.M_POAD_LC_THRESOLD_LMT);
//			}
//			catch(SQLException se){
//			DISP_ALERT.DISP_ALERT(se.getMessage());
//			throw new FORM_TRIGGER_FAILURE();
//			}

		
		return postQueryList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 */
	public void whenValidatePOAD_ASSRD_REF_ID2(FacesContext context,
			UIComponent component, Object value) {
		String selectQuery = null;
		ResultSet rs = null;
		try {
			ASSRD_DTLS_BEAN.setPOAD_ASSRD_REF_ID2((String) value);
			selectQuery = "SELECT POAD_ASSURED_NAME FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_ASSR_CODE = ? ";
			System.out.println("selectQuery: " + selectQuery);
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			rs = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { ASSRD_DTLS_BEAN.getPOAD_ASSR_CODE() });
			if (rs.next()) {
				getCOMP_POAD_ASSURED_NAME().setSubmittedValue(
						rs.getString("POAD_ASSURED_NAME"));
			}else{
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91121"));
			}

			/*POLICY_DETAILS_ACTION POLICY_DETAILS_ACTION = new POLICY_DETAILS_ACTION();
			POLICY_DETAILS_ACTION.onLoad(this);
			
			resetAllComponent();
			resetAllComponentAddtional();
			discountResetSelectedRows();*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e1) {
			}
		}
	}

	public String buttonPressQuery() {
		try {
			if((ASSRD_DTLS_BEAN.getPOAD_ASSR_CODE()!=null && !"".equalsIgnoreCase(ASSRD_DTLS_BEAN.getPOAD_ASSR_CODE())) || 
					(ASSRD_DTLS_BEAN.getPOAD_ASSRD_REF_ID1()!=null && !"".equalsIgnoreCase(ASSRD_DTLS_BEAN.getPOAD_ASSRD_REF_ID1())) || 
						(ASSRD_DTLS_BEAN.getPOAD_ASSRD_REF_ID2()!=null && !"".equalsIgnoreCase(ASSRD_DTLS_BEAN.getPOAD_ASSRD_REF_ID2()))){
				POLICY_DETAILS_ACTION POLICY_DETAILS_ACTION = new POLICY_DETAILS_ACTION();
				POLICY_DETAILS_ACTION.onLoad(this);
				
				/*resetAllComponent();
				resetAllComponentAddtional();
				discountResetSelectedRows();*/
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
		return null;
	}

	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 */
	public void whenValidatePOAD_ASSRD_REF_ID1(FacesContext context, UIComponent component, Object value){
		ASSRD_DTLS_BEAN.setPOAD_ASSRD_REF_ID1((String)value);
		ResultSet rs =null;
		try{
			String selectQuery = "SELECT POAD_ASSURED_NAME FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_ASSR_CODE = ? ";
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			rs = handler.executeSelectStatement(selectQuery,connection,new Object[]{ASSRD_DTLS_BEAN.getPOAD_ASSR_CODE()});
			if(rs.next()) {
				ASSRD_DTLS_BEAN.setPOAD_ASSURED_NAME(rs.getString("POAD_ASSURED_NAME"));
			}else{
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91121"));
			}
		
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}finally{
			try{CommonUtils.closeCursor(rs);}catch(Exception exception2){}
		}
	
		
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 */
	public void whenValidatePOAD_ASSR_CODE(FacesContext context, UIComponent component, Object value){
		Connection connection =null;
		ASSRD_DTLS_BEAN.setPOAD_ASSR_CODE((String)value);
		ResultSet rs =null;
		try{
			String selectQuery = "SELECT POAD_ASSURED_NAME,POAD_REF_ID1, POAD_REF_ID2 FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_ASSR_CODE = ? ";
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			rs= handler.executeSelectStatement(selectQuery,connection,new Object[]{ASSRD_DTLS_BEAN.getPOAD_ASSR_CODE()});
			if(rs.next()) {
				ASSRD_DTLS_BEAN.setPOAD_ASSURED_NAME(rs.getString("POAD_ASSURED_NAME"));
				ASSRD_DTLS_BEAN.setPOAD_ASSRD_REF_ID1(rs.getString("POAD_REF_ID1"));
				ASSRD_DTLS_BEAN.setPOAD_ASSRD_REF_ID2(rs.getString("POAD_REF_ID2"));
			}else{
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91121"));
			}
			COMP_POAD_ASSURED_NAME.resetValue();
			COMP_POAD_ASSRD_REF_ID1.resetValue();
			COMP_POAD_ASSRD_REF_ID2.resetValue();
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}finally{
			try{CommonUtils.closeCursor(rs);}catch(Exception exception2){}
		}
	
	}


	public List<POL_ADDL_COVER> postQueryPOL_ADDL_COVER(List<POL_ADDL_COVER> preQueryList) throws Exception {
		double SA=0;
		double SA1=0;
		List<POL_ADDL_COVER> postQueryList = new ArrayList<POL_ADDL_COVER>();
		System.out.println("ASSRD_DTLS_ACTION.postQueryPOL_ADDL_COVER() Size: "+preQueryList.size());
		POL_ADDL_COVER coverBean = (POL_ADDL_COVER) preQueryList.get(0);
//		Statement stmt_vembu1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		CRUDHandler handler = new CRUDHandler();
		System.out.println("ASSRD_DTLS_ACTION.postQueryPOL_ADDL_COVER() coverBean.getPOAC_POL_SYS_ID(): "+coverBean.getPOAC_POL_SYS_ID());
		String sql_vembu1 = "SELECT (SUM(POL_LC_SUM_ASSURED)) FROM  PT_IL_POLICY WHERE  POL_SYS_ID  = "+coverBean.getPOAC_POL_SYS_ID()+"";
		System.out.println("ASSRD_DTLS_ACTION.postQueryPOL_ADDL_COVER() sql_vembu1 Query: "+sql_vembu1);
		ResultSet vembu0 = handler.executeSelectStatement(sql_vembu1,getConnection());

		if(vembu0.next()) {
			SA=vembu0.getDouble(1);
		}
		vembu0.close();

		String query = "SELECT (SUM(POL_LC_SUM_ASSURED)) FROM  PT_IL_POLICY";

		vembu0 = handler.executeSelectStatement(query,getConnection());
		Double totalSum = 0.0; 
		if(vembu0.next()) {
			totalSum = vembu0.getDouble(1);
		}

//		if(!vembu0.isLast())
//		{
//		throw new TooManyRowsException();
//		}
//		stmt_vembu1.close();
//		try{

//		}catch(NullPointerException null_pointer_exception)
//		{ M_TOT_LC_SA
//		throw null_pointer_exception;//ResultSet already close
//		}
//		Statement stmt_vembu2 = vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String sql_vembu2 = "SELECT SUM(POAC_LC_SA) FROM  PT_IL_POL_ADDL_COVER B  WHERE  B.POAC_POL_SYS_ID  = "+coverBean.getPOAC_POL_SYS_ID()+"";
		System.out.println("ASSRD_DTLS_ACTION.postQueryPOL_ADDL_COVER() sql_vembu2 query : "+sql_vembu2);
		ResultSet vembu1 = handler.executeSelectStatement(sql_vembu2,connection);
		if(vembu1.next()) {
			SA1=vembu1.getDouble(1);
		}

//		if(!vembu1.isLast())
//		{
//		throw new TooManyRowsException();
//		}
//		stmt_vembu2.close();
//		try{
		vembu1.close();
//		}catch(NullPointerException null_pointer_exception)
//		{
//		throw null_pointer_exception;//ResultSet already close
//		}
//		:POL_ADDL_COVER.M_POAC_TOTAL_LC_SUM=(MigratingFunctions.nvl(SA,0)+MigratingFunctions.nvl(SA1,0));

		Double tempValue = UI_M_TOT_SAValue + SA;

		System.out.println("ASSRD_DTLS_ACTION.postQueryPOL_ADDL_COVER() Final tempValue: "+tempValue);

		Double sumValue = new Double(SA+SA1);
		System.out.println("ASSRD_DTLS_ACTION.postQueryPOL_ADDL_COVER() SA:"+SA+" SA1: "+SA1);
		System.out.println("ASSRD_DTLS_ACTION.postQueryPOL_ADDL_COVER() sumValue: "+sumValue);
		POL_ADDL_COVER_BEAN.setUI_M_POAC_TOTAL_LC_SUM(sumValue);
		sumValue = sumValue == 0 ? 0.0:sumValue;
		getCOMP_UI_M_POAC_TOTAL_LC_SUM().setSubmittedValue(String.valueOf(sumValue));
		getCOMP_UI_M_TOT_LC_SA().setSubmittedValue(String.valueOf(tempValue));

//		P_VAL_COVER.P_VAL_COVER(:POL_ADDL_COVER.POAC_COVER_CODE,:POL_ADDL_COVER.M_POAC_COVER_DESC,"A","N","N");

		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN", coverBean.getPOAC_COVER_CODE());
		OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT",coverBean.getUI_M_POAC_COVER_DESC());
		OracleParameter param3 = new OracleParameter("in3","STRING","IN","'A'");
		OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
		OracleParameter param5 = new OracleParameter("in5","STRING","IN","'N'");
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		ArrayList<OracleParameter> list = procHandler.execute(paramList, connection, "P_VAL_COVER");
		coverBean.setUI_M_POAC_COVER_DESC(list.get(0).getValue());
		
		coverBean.setUI_M_POAC_TOTAL_LC_SUM(sumValue);
		//coverBean.setUI_M_TOT_LC_SA(String.valueOf(tempValue));
		
		postQueryList.add(coverBean);
		return postQueryList;
	}

	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}

	public UIDataTable getPolicyDetailBlock() {
		return policyDetailBlock;
	}

	public void setPolicyDetailBlock(UIDataTable policyDetailBlock) {
		this.policyDetailBlock = policyDetailBlock;
	}

	public UIDataTable getCoverDetailBlock() {
		return coverDetailBlock;
	}

	public void setCoverDetailBlock(UIDataTable coverDetailBlock) {
		this.coverDetailBlock = coverDetailBlock;
	}

	public UIDataTable getDiscountDetailBlock() {
		return discountDetailBlock;
	}

	public void setDiscountDetailBlock(UIDataTable discountDetailBlock) {
		this.discountDetailBlock = discountDetailBlock;
	}

	public HtmlInputText getM_TOT_SA() {
		return M_TOT_SA;
	}

	public void setM_TOT_SA(HtmlInputText m_tot_sa) {
		M_TOT_SA = m_tot_sa;
	}

	public HtmlInputText getCOMP_UI_M_TOT_SA() {
		return COMP_UI_M_TOT_SA;
	}

	public void setCOMP_UI_M_TOT_SA(HtmlInputText comp_ui_m_tot_sa) {
		COMP_UI_M_TOT_SA = comp_ui_m_tot_sa;
	}

	/**
	 * @return the filterByPOL_NO
	 */
	public String getFilterByPOL_NO() {
		return filterByPOL_NO;
	}

	/**
	 * @param filterByPOL_NO the filterByPOL_NO to set
	 */
	public void setFilterByPOL_NO(String filterByPOL_NO) {
		this.filterByPOL_NO = filterByPOL_NO;
	}

	/**
	 * @return the filterByPOL_PLAN_CODE
	 */
	public String getFilterByPOL_PLAN_CODE() {
		return filterByPOL_PLAN_CODE;
	}

	/**
	 * @param filterByPOL_PLAN_CODE the filterByPOL_PLAN_CODE to set
	 */
	public void setFilterByPOL_PLAN_CODE(String filterByPOL_PLAN_CODE) {
		this.filterByPOL_PLAN_CODE = filterByPOL_PLAN_CODE;
	}

	public void getDetails() {
		try {
			coverList.clear();
			loadList.clear();
			POLICY_DETAILS_ACTION policy_details_action = new POLICY_DETAILS_ACTION();
			if (policyDetailList.size() != 0) {				
				POLICY_DETAILS_BEAN = (POLICY_DETAILS) dataTable.getRowData();
				//policy_details_on_populate_details(null);
				policy_details_action.onPopulateDetails(this, POLICY_DETAILS_BEAN);
				COMP_UI_M_POAC_TOTAL_LC_SUM.resetValue();
				
			}else{
				this.coverList.clear();
				this.loadList.clear();
			}
			if(coverList.isEmpty()){
				this.setPOL_ADDL_COVER_BEAN(new POL_ADDL_COVER());
			}
			if(loadList.isEmpty()){
				this.setPOL_DISC_LOAD_BEAN(new POL_DISC_LOAD());
			}
			resetAllComponent();
			resetAllComponentAddtional();
			resetSelectedRow();
			POLICY_DETAILS_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
	}
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<POLICY_DETAILS> iterator = policyDetailList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	private void resetAllComponent(){
		COMP_POL_NO.resetValue();
		COMP_POL_PLAN_CODE.resetValue();
		COMP_POL_LC_SUM_ASSURED.resetValue();
		COMP_POL_PERIOD.resetValue();
		COMP_POL_PREM_PAY_YRS.resetValue();
		COMP_POL_START_DT.resetValue();
		COMP_POL_FC_BASIC_PREM.resetValue();
		COMP_POL_MODE_OF_PYMT_DESC.resetValue();
		COMP_POL_ADDL_STATUS.resetValue();
		COMP_POL_LC_FIRST_PREM.resetValue();
		COMP_UI_M_POAD_LC_THRESOLD_LMT.resetValue();
		COMP_POL_TRAN_DT.resetValue();
		COMP_NEXT_DUE_DATE.resetValue();
		COMP_POL_EXPIRY_DT.resetValue();
		COMP_POL_STATUS_DESC.resetValue();
		COMP_POL_FC_SUM_ASSURED.resetValue();
		COMP_POL_FC_FIRST_PREM.resetValue();
		COMP_POL_REMARKS.resetValue();
		COMP_UI_M_TYPE.resetValue();
		COMP_UI_M_POL_PLAN_DESC.resetValue();
	}
	
	public void getDetailsAddtionial() {
		try {
			if (coverList.size() != 0) {				
				POL_ADDL_COVER_BEAN = (POL_ADDL_COVER) addtionalCoverDataTable.getRowData();
			}	
			resetAllComponentAddtional();			
			resetSelectedRowAddtional();
			POL_ADDL_COVER_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
	}
	// Added to apply row selection
	private void resetSelectedRowAddtional() {
		Iterator<POL_ADDL_COVER> iterator = coverList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	private void resetAllComponentAddtional(){
		COMP_POAC_PERIOD.resetValue();
		COMP_POAC_PREM_PAY_YRS.resetValue();
		COMP_POAC_FM_DT.resetValue();
		COMP_POAC_LC_PREM.resetValue();
		COMP_UI_M_POAC_COVER_DESC.resetValue();
		
	}
	
	public void getDiscountDetails() {
		try {
			if (loadList.size() != 0) {				
				POL_DISC_LOAD_BEAN = (POL_DISC_LOAD) discountDataTable.getRowData();
			}	
			discountResetAllComponent();			
			discountResetSelectedRows();
			POL_DISC_LOAD_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Added to apply row selection
	private void discountResetAllComponent() {
		Iterator<POL_DISC_LOAD> iterator = loadList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	private void discountResetSelectedRows(){
		COMP_PDL_RATE_PER.resetValue();
		COMP_UI_M_DISCLOAD_DESC.resetValue();
		COMP_PDL_LC_DISC_LOAD_VALUE.resetValue();
		
	}
	
	/**
	 * @return the dataTable
	 */
	public UIData getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the discountDataTable
	 */
	public UIData getDiscountDataTable() {
		return discountDataTable;
	}

	/**
	 * @param discountDataTable the discountDataTable to set
	 */
	public void setDiscountDataTable(UIData discountDataTable) {
		this.discountDataTable = discountDataTable;
	}

	/**
	 * @return the addtionalCoverDataTable
	 */
	public UIData getAddtionalCoverDataTable() {
		return addtionalCoverDataTable;
	}

	/**
	 * @param addtionalCoverDataTable the addtionalCoverDataTable to set
	 */
	public void setAddtionalCoverDataTable(UIData addtionalCoverDataTable) {
		this.addtionalCoverDataTable = addtionalCoverDataTable;
	}

	/**
	 * @return the filterByPOAC_COVER_CODE
	 */
	public String getFilterByPOAC_COVER_CODE() {
		return filterByPOAC_COVER_CODE;
	}

	/**
	 * @param filterByPOAC_COVER_CODE the filterByPOAC_COVER_CODE to set
	 */
	public void setFilterByPOAC_COVER_CODE(String filterByPOAC_COVER_CODE) {
		this.filterByPOAC_COVER_CODE = filterByPOAC_COVER_CODE;
	}

	/**
	 * @return the filterByPOAC_LC_SA
	 */
	public String getFilterByPOAC_LC_SA() {
		return filterByPOAC_LC_SA;
	}

	/**
	 * @param filterByPOAC_LC_SA the filterByPOAC_LC_SA to set
	 */
	public void setFilterByPOAC_LC_SA(String filterByPOAC_LC_SA) {
		this.filterByPOAC_LC_SA = filterByPOAC_LC_SA;
	}

	/**
	 * @return the filterByPDL_RATE
	 */
	public String getFilterByPDL_RATE() {
		return filterByPDL_RATE;
	}

	/**
	 * @param filterByPDL_RATE the filterByPDL_RATE to set
	 */
	public void setFilterByPDL_RATE(String filterByPDL_RATE) {
		this.filterByPDL_RATE = filterByPDL_RATE;
	}

	/**
	 * @return the filterByPDL_DISC_LOAD_CODE
	 */
	public String getFilterByPDL_DISC_LOAD_CODE() {
		return filterByPDL_DISC_LOAD_CODE;
	}

	/**
	 * @param filterByPDL_DISC_LOAD_CODE the filterByPDL_DISC_LOAD_CODE to set
	 */
	public void setFilterByPDL_DISC_LOAD_CODE(String filterByPDL_DISC_LOAD_CODE) {
		this.filterByPDL_DISC_LOAD_CODE = filterByPDL_DISC_LOAD_CODE;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * @return the cOMP_UI_M_QUERY
	 */
	public HtmlCommandButton getCOMP_UI_M_QUERY() {
		return COMP_UI_M_QUERY;
	}

	/**
	 * @param comp_ui_m_query the cOMP_UI_M_QUERY to set
	 */
	public void setCOMP_UI_M_QUERY(HtmlCommandButton comp_ui_m_query) {
		COMP_UI_M_QUERY = comp_ui_m_query;
	}

	public HtmlInputText getCOMP_UI_M_POAD_TOT_THRESOLD_LMT() {
		return COMP_UI_M_POAD_TOT_THRESOLD_LMT;
	}

	public void setCOMP_UI_M_POAD_TOT_THRESOLD_LMT(
			HtmlInputText comp_ui_m_poad_tot_thresold_lmt) {
		COMP_UI_M_POAD_TOT_THRESOLD_LMT = comp_ui_m_poad_tot_thresold_lmt;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_TOT_THRESOLD_LMT_LABEL() {
		return COMP_UI_M_POAD_TOT_THRESOLD_LMT_LABEL;
	}

	public void setCOMP_UI_M_POAD_TOT_THRESOLD_LMT_LABEL(
			HtmlOutputLabel comp_ui_m_poad_tot_thresold_lmt_label) {
		COMP_UI_M_POAD_TOT_THRESOLD_LMT_LABEL = comp_ui_m_poad_tot_thresold_lmt_label;
	}
}
