package com.iii.pel.forms.PILT018;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.runtime.functions.MigratingFunctions;
import com.vembu.plsql.runtime.VembuExceptionConstants;
import com.vembu.plsql.runtime.functions.dbms_output;

public class PT_IL_BROK_ADV_HDR_ACTION  extends CommonAction{

	private HtmlOutputLabel COMP_BAH_PYMT_DT_LABEL;

	private HtmlCalendar COMP_BAH_PYMT_DT;

	private HtmlOutputLabel COMP_BAH_CUST_CODE_LABEL;

	private HtmlInputText COMP_BAH_CUST_CODE;

	private HtmlOutputLabel COMP_BAH_REF_NO_LABEL;

	private HtmlInputText COMP_BAH_REF_NO;

	private HtmlOutputLabel COMP_BAH_PYMT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_BAH_PYMT_TYPE;

	private HtmlOutputLabel COMP_BAH_CURR_CODE_LABEL;

	private HtmlInputText COMP_BAH_CURR_CODE;

	private HtmlOutputLabel COMP_BAH_CURR_RATE_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_BAH_CURR_RATE_TYPE;

	private HtmlOutputLabel COMP_BAH_FC_AMT_LABEL;

	private HtmlInputText COMP_BAH_FC_AMT;

	private HtmlOutputLabel COMP_BAH_REPAY_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_BAH_REPAY_TYPE;

	private HtmlOutputLabel COMP_BAH_CONFIRM_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_BAH_CONFIRM_FLAG;

	private HtmlOutputLabel COMP_BAH_PAYMENT_YN_LABEL;

	private HtmlSelectOneMenu COMP_BAH_PAYMENT_YN;

	private HtmlOutputLabel COMP_BAH_TXN_CODE_LABEL;

	private HtmlInputText COMP_BAH_TXN_CODE;

	private HtmlOutputLabel COMP_UI_M_BAH_CUST_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BAH_CUST_DESC;

	private HtmlOutputLabel COMP_UI_M_BAH_CURR_NAME_LABEL;

	private HtmlInputText COMP_UI_M_BAH_CURR_NAME;

	private HtmlOutputLabel COMP_BAH_REPAYMENT_YN_LABEL;

	private HtmlSelectOneMenu COMP_BAH_REPAYMENT_YN;

	private HtmlOutputLabel COMP_BAH_DOC_NO_LABEL;

	private HtmlInputText COMP_BAH_DOC_NO;

	private HtmlOutputLabel COMP_BAH_INST_FM_DT_LABEL;

	private HtmlCalendar COMP_BAH_INST_FM_DT;

	private HtmlOutputLabel COMP_BAH_REMARKS_LABEL;

	private HtmlInputText COMP_BAH_REMARKS;

	private HtmlOutputLabel COMP_BAH_EXCH_RATE_LABEL;

	private HtmlInputText COMP_BAH_EXCH_RATE;

	private HtmlOutputLabel COMP_BAH_LC_AMT_LABEL;

	private HtmlInputText COMP_BAH_LC_AMT;

	private HtmlOutputLabel COMP_BAH_NO_OF_INST_LABEL;

	private HtmlInputText COMP_BAH_NO_OF_INST;

	private HtmlOutputLabel COMP_BAH_STATUS_LABEL;

	private HtmlSelectOneMenu COMP_BAH_STATUS;

	private HtmlOutputLabel COMP_BAH_PAY_PRIORITY_LABEL;

	private HtmlInputText COMP_BAH_PAY_PRIORITY;

	private HtmlOutputLabel COMP_BAH_DOC_DT_LABEL;

	private HtmlCalendar COMP_BAH_DOC_DT;

	private HtmlCommandButton COMP_UI_M_EDIT_BAH_REMARKS;

	private HtmlCommandButton COMP_UI_M_LOV_BAH_CUST_CODE;

	private HtmlCommandButton COMP_UI_M_LOV_BAH_CURR_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;
	
		
	private HtmlOutputText COMP_UI_M_APPROVAL_STATUS;
	
	private List<LovBean> suggesionList;

	private boolean compUiMButApproveDisabled;
	
	private boolean APPROVE_STATUS;

	private boolean compBahLcAmtDisabled;

	private PT_IL_BROK_ADV_HDR PT_IL_BROK_ADV_HDR_BEAN;
	private List<String> CUSTCODELOV;
	CRUDHandler handler = new CRUDHandler();

	private HtmlCommandButton test;
		
	public CompositeAction compositeAction;
	
	
	private List<SelectItem> SELECT_PYMT_TYPE_LIST = new ArrayList<SelectItem>() ;
	
	private List<SelectItem> SELECT_CURR_RATE_TYPE_LIST = new ArrayList<SelectItem>() ;
	
	private List<SelectItem> SELECT_REPAY_TYPE_LIST = new ArrayList<SelectItem>() ;
	
	private List<SelectItem> SELECT_CONFIRM_FLAG_LIST = new ArrayList<SelectItem>() ;
		
	private List<SelectItem> SELECT_BAH_STATUS_LIST = new ArrayList<SelectItem>() ;

	private List<SelectItem> SELECT_PAYMENT_YN_LIST = new ArrayList<SelectItem>() ;
	
	private List<SelectItem> SELECT_REPAYMENT_YN_LIST = new ArrayList<SelectItem>() ;
	
	

	public List<SelectItem> getSELECT_PYMT_TYPE_LIST() {
		return SELECT_PYMT_TYPE_LIST;
	}

	public void setSELECT_PYMT_TYPE_LIST(List<SelectItem> select_pymt_type_list) {
		SELECT_PYMT_TYPE_LIST = select_pymt_type_list;
	}

	public List<SelectItem> getSELECT_CURR_RATE_TYPE_LIST() {
		return SELECT_CURR_RATE_TYPE_LIST;
	}

	public void setSELECT_CURR_RATE_TYPE_LIST(
			List<SelectItem> select_curr_rate_type_list) {
		SELECT_CURR_RATE_TYPE_LIST = select_curr_rate_type_list;
	}

	public List<SelectItem> getSELECT_REPAY_TYPE_LIST() {
		return SELECT_REPAY_TYPE_LIST;
	}

	public void setSELECT_REPAY_TYPE_LIST(List<SelectItem> select_repay_type_list) {
		SELECT_REPAY_TYPE_LIST = select_repay_type_list;
	}

	public List<SelectItem> getSELECT_CONFIRM_FLAG_LIST() {
		return SELECT_CONFIRM_FLAG_LIST;
	}

	public void setSELECT_CONFIRM_FLAG_LIST(
			List<SelectItem> select_confirm_flag_list) {
		SELECT_CONFIRM_FLAG_LIST = select_confirm_flag_list;
	}

	public List<SelectItem> getSELECT_BAH_STATUS_LIST() {
		return SELECT_BAH_STATUS_LIST;
	}

	public void setSELECT_BAH_STATUS_LIST(List<SelectItem> select_bah_status_list) {
		SELECT_BAH_STATUS_LIST = select_bah_status_list;
	}

	public List<SelectItem> getSELECT_PAYMENT_YN_LIST() {
		return SELECT_PAYMENT_YN_LIST;
	}

	public void setSELECT_PAYMENT_YN_LIST(List<SelectItem> select_payment_yn_list) {
		SELECT_PAYMENT_YN_LIST = select_payment_yn_list;
	}

	public List<SelectItem> getSELECT_REPAYMENT_YN_LIST() {
		return SELECT_REPAYMENT_YN_LIST;
	}

	public void setSELECT_REPAYMENT_YN_LIST(
			List<SelectItem> select_repayment_yn_list) {
		SELECT_REPAYMENT_YN_LIST = select_repayment_yn_list;
	}

	public HtmlCommandButton getTest() {
		return test;
	}

	public void setTest(HtmlCommandButton test) {
		this.test = test;
	}

	public PT_IL_BROK_ADV_HDR_ACTION() {
		try {
			PT_IL_BROK_ADV_HDR_BEAN = new PT_IL_BROK_ADV_HDR();
			instantiateAllComponent();
			setSELECT_PYMT_TYPE_LIST(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT018","PT_IL_BROK_ADV_HDR", "PT_IL_BROK_ADV_HDR.BAH_PYMT_TYPE",""));
			setSELECT_CURR_RATE_TYPE_LIST(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT018","PT_IL_BROK_ADV_HDR","PT_IL_BROK_ADV_HDR.BAH_CURR_RATE_TYPE", "CURRATE"));
			setSELECT_REPAY_TYPE_LIST(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT018","PT_IL_BROK_ADV_HDR", "PT_IL_BROK_ADV_HDR.BAH_REPAYMENT_YN","YESNO"));
			setSELECT_CONFIRM_FLAG_LIST(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT018","PT_IL_BROK_ADV_HDR","PT_IL_BROK_ADV_HDR.BAH_CONFIRM_FLAG", "YESNO"));
			setSELECT_BAH_STATUS_LIST(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT018","PT_IL_BROK_ADV_HDR", "PT_IL_BROK_ADV_HDR.BAH_STATUS","OPENCLOSE"));
			setSELECT_PAYMENT_YN_LIST(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT018","PT_IL_BROK_ADV_HDR", "PT_IL_BROK_ADV_HDR.BAH_PAYMENT_YN","YESNO"));
			setSELECT_REPAYMENT_YN_LIST(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT018","PT_IL_BROK_ADV_HDR","PT_IL_BROK_ADV_HDR.BAH_REPAY_TYPE", "IL_BAH_REPAY"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Constructor", e.getMessage());
		}
	}
	
	public HtmlOutputLabel getCOMP_BAH_PYMT_DT_LABEL() {
		return COMP_BAH_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_BAH_PYMT_DT() {
		return COMP_BAH_PYMT_DT;
	}

	public void setCOMP_BAH_PYMT_DT_LABEL(HtmlOutputLabel COMP_BAH_PYMT_DT_LABEL) {
		this.COMP_BAH_PYMT_DT_LABEL = COMP_BAH_PYMT_DT_LABEL;
	}

	public void setCOMP_BAH_PYMT_DT(HtmlCalendar COMP_BAH_PYMT_DT) {
		this.COMP_BAH_PYMT_DT = COMP_BAH_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_BAH_CUST_CODE_LABEL() {
		return COMP_BAH_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAH_CUST_CODE() {
		return COMP_BAH_CUST_CODE;
	}

	public void setCOMP_BAH_CUST_CODE_LABEL(HtmlOutputLabel COMP_BAH_CUST_CODE_LABEL) {
		this.COMP_BAH_CUST_CODE_LABEL = COMP_BAH_CUST_CODE_LABEL;
	}

	public void setCOMP_BAH_CUST_CODE(HtmlInputText COMP_BAH_CUST_CODE) {
		this.COMP_BAH_CUST_CODE = COMP_BAH_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_BAH_REF_NO_LABEL() {
		return COMP_BAH_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_BAH_REF_NO() {
		return COMP_BAH_REF_NO;
	}

	public void setCOMP_BAH_REF_NO_LABEL(HtmlOutputLabel COMP_BAH_REF_NO_LABEL) {
		this.COMP_BAH_REF_NO_LABEL = COMP_BAH_REF_NO_LABEL;
	}

	public void setCOMP_BAH_REF_NO(HtmlInputText COMP_BAH_REF_NO) {
		this.COMP_BAH_REF_NO = COMP_BAH_REF_NO;
	}

	public HtmlOutputLabel getCOMP_BAH_PYMT_TYPE_LABEL() {
		return COMP_BAH_PYMT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BAH_PYMT_TYPE() {
		return COMP_BAH_PYMT_TYPE;
	}

	public void setCOMP_BAH_PYMT_TYPE_LABEL(HtmlOutputLabel COMP_BAH_PYMT_TYPE_LABEL) {
		this.COMP_BAH_PYMT_TYPE_LABEL = COMP_BAH_PYMT_TYPE_LABEL;
	}

	public void setCOMP_BAH_PYMT_TYPE(HtmlSelectOneMenu COMP_BAH_PYMT_TYPE) {
		this.COMP_BAH_PYMT_TYPE = COMP_BAH_PYMT_TYPE;
	}

	public HtmlOutputLabel getCOMP_BAH_CURR_CODE_LABEL() {
		return COMP_BAH_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAH_CURR_CODE() {
		return COMP_BAH_CURR_CODE;
	}

	public void setCOMP_BAH_CURR_CODE_LABEL(HtmlOutputLabel COMP_BAH_CURR_CODE_LABEL) {
		this.COMP_BAH_CURR_CODE_LABEL = COMP_BAH_CURR_CODE_LABEL;
	}

	public void setCOMP_BAH_CURR_CODE(HtmlInputText COMP_BAH_CURR_CODE) {
		this.COMP_BAH_CURR_CODE = COMP_BAH_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_BAH_CURR_RATE_TYPE_LABEL() {
		return COMP_BAH_CURR_RATE_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BAH_CURR_RATE_TYPE() {
		return COMP_BAH_CURR_RATE_TYPE;
	}

	public void setCOMP_BAH_CURR_RATE_TYPE_LABEL(HtmlOutputLabel COMP_BAH_CURR_RATE_TYPE_LABEL) {
		this.COMP_BAH_CURR_RATE_TYPE_LABEL = COMP_BAH_CURR_RATE_TYPE_LABEL;
	}

	public void setCOMP_BAH_CURR_RATE_TYPE(HtmlSelectOneMenu COMP_BAH_CURR_RATE_TYPE) {
		this.COMP_BAH_CURR_RATE_TYPE = COMP_BAH_CURR_RATE_TYPE;
	}

	public HtmlOutputLabel getCOMP_BAH_FC_AMT_LABEL() {
		return COMP_BAH_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_BAH_FC_AMT() {
		return COMP_BAH_FC_AMT;
	}

	public void setCOMP_BAH_FC_AMT_LABEL(HtmlOutputLabel COMP_BAH_FC_AMT_LABEL) {
		this.COMP_BAH_FC_AMT_LABEL = COMP_BAH_FC_AMT_LABEL;
	}

	public void setCOMP_BAH_FC_AMT(HtmlInputText COMP_BAH_FC_AMT) {
		this.COMP_BAH_FC_AMT = COMP_BAH_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_BAH_REPAY_TYPE_LABEL() {
		return COMP_BAH_REPAY_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BAH_REPAY_TYPE() {
		return COMP_BAH_REPAY_TYPE;
	}

	public void setCOMP_BAH_REPAY_TYPE_LABEL(HtmlOutputLabel COMP_BAH_REPAY_TYPE_LABEL) {
		this.COMP_BAH_REPAY_TYPE_LABEL = COMP_BAH_REPAY_TYPE_LABEL;
	}

	public void setCOMP_BAH_REPAY_TYPE(HtmlSelectOneMenu COMP_BAH_REPAY_TYPE) {
		this.COMP_BAH_REPAY_TYPE = COMP_BAH_REPAY_TYPE;
	}

	public HtmlOutputLabel getCOMP_BAH_CONFIRM_FLAG_LABEL() {
		return COMP_BAH_CONFIRM_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BAH_CONFIRM_FLAG() {
		return COMP_BAH_CONFIRM_FLAG;
	}

	public void setCOMP_BAH_CONFIRM_FLAG_LABEL(HtmlOutputLabel COMP_BAH_CONFIRM_FLAG_LABEL) {
		this.COMP_BAH_CONFIRM_FLAG_LABEL = COMP_BAH_CONFIRM_FLAG_LABEL;
	}

	public void setCOMP_BAH_CONFIRM_FLAG(HtmlSelectOneMenu COMP_BAH_CONFIRM_FLAG) {
		this.COMP_BAH_CONFIRM_FLAG = COMP_BAH_CONFIRM_FLAG;
	}

	public HtmlOutputLabel getCOMP_BAH_PAYMENT_YN_LABEL() {
		return COMP_BAH_PAYMENT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BAH_PAYMENT_YN() {
		return COMP_BAH_PAYMENT_YN;
	}

	public void setCOMP_BAH_PAYMENT_YN_LABEL(HtmlOutputLabel COMP_BAH_PAYMENT_YN_LABEL) {
		this.COMP_BAH_PAYMENT_YN_LABEL = COMP_BAH_PAYMENT_YN_LABEL;
	}

	public void setCOMP_BAH_PAYMENT_YN(HtmlSelectOneMenu COMP_BAH_PAYMENT_YN) {
		this.COMP_BAH_PAYMENT_YN = COMP_BAH_PAYMENT_YN;
	}

	public HtmlOutputLabel getCOMP_BAH_TXN_CODE_LABEL() {
		return COMP_BAH_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAH_TXN_CODE() {
		return COMP_BAH_TXN_CODE;
	}

	public void setCOMP_BAH_TXN_CODE_LABEL(HtmlOutputLabel COMP_BAH_TXN_CODE_LABEL) {
		this.COMP_BAH_TXN_CODE_LABEL = COMP_BAH_TXN_CODE_LABEL;
	}

	public void setCOMP_BAH_TXN_CODE(HtmlInputText COMP_BAH_TXN_CODE) {
		this.COMP_BAH_TXN_CODE = COMP_BAH_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BAH_CUST_DESC_LABEL() {
		return COMP_UI_M_BAH_CUST_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BAH_CUST_DESC() {
		return COMP_UI_M_BAH_CUST_DESC;
	}

	public void setCOMP_UI_M_BAH_CUST_DESC_LABEL(HtmlOutputLabel COMP_UI_M_BAH_CUST_DESC_LABEL) {
		this.COMP_UI_M_BAH_CUST_DESC_LABEL = COMP_UI_M_BAH_CUST_DESC_LABEL;
	}

	public void setCOMP_UI_M_BAH_CUST_DESC(HtmlInputText COMP_UI_M_BAH_CUST_DESC) {
		this.COMP_UI_M_BAH_CUST_DESC = COMP_UI_M_BAH_CUST_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_BAH_CURR_NAME_LABEL() {
		return COMP_UI_M_BAH_CURR_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BAH_CURR_NAME() {
		return COMP_UI_M_BAH_CURR_NAME;
	}

	public void setCOMP_UI_M_BAH_CURR_NAME_LABEL(HtmlOutputLabel COMP_UI_M_BAH_CURR_NAME_LABEL) {
		this.COMP_UI_M_BAH_CURR_NAME_LABEL = COMP_UI_M_BAH_CURR_NAME_LABEL;
	}

	public void setCOMP_UI_M_BAH_CURR_NAME(HtmlInputText COMP_UI_M_BAH_CURR_NAME) {
		this.COMP_UI_M_BAH_CURR_NAME = COMP_UI_M_BAH_CURR_NAME;
	}

	public HtmlOutputLabel getCOMP_BAH_REPAYMENT_YN_LABEL() {
		return COMP_BAH_REPAYMENT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BAH_REPAYMENT_YN() {
		return COMP_BAH_REPAYMENT_YN;
	}

	public void setCOMP_BAH_REPAYMENT_YN_LABEL(HtmlOutputLabel COMP_BAH_REPAYMENT_YN_LABEL) {
		this.COMP_BAH_REPAYMENT_YN_LABEL = COMP_BAH_REPAYMENT_YN_LABEL;
	}

	public void setCOMP_BAH_REPAYMENT_YN(HtmlSelectOneMenu COMP_BAH_REPAYMENT_YN) {
		this.COMP_BAH_REPAYMENT_YN = COMP_BAH_REPAYMENT_YN;
	}

	public HtmlOutputLabel getCOMP_BAH_DOC_NO_LABEL() {
		return COMP_BAH_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_BAH_DOC_NO() {
		return COMP_BAH_DOC_NO;
	}

	public void setCOMP_BAH_DOC_NO_LABEL(HtmlOutputLabel COMP_BAH_DOC_NO_LABEL) {
		this.COMP_BAH_DOC_NO_LABEL = COMP_BAH_DOC_NO_LABEL;
	}

	public void setCOMP_BAH_DOC_NO(HtmlInputText COMP_BAH_DOC_NO) {
		this.COMP_BAH_DOC_NO = COMP_BAH_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_BAH_INST_FM_DT_LABEL() {
		return COMP_BAH_INST_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_BAH_INST_FM_DT() {
		return COMP_BAH_INST_FM_DT;
	}

	public void setCOMP_BAH_INST_FM_DT_LABEL(HtmlOutputLabel COMP_BAH_INST_FM_DT_LABEL) {
		this.COMP_BAH_INST_FM_DT_LABEL = COMP_BAH_INST_FM_DT_LABEL;
	}

	public void setCOMP_BAH_INST_FM_DT(HtmlCalendar COMP_BAH_INST_FM_DT) {
		this.COMP_BAH_INST_FM_DT = COMP_BAH_INST_FM_DT;
	}

	public HtmlOutputLabel getCOMP_BAH_REMARKS_LABEL() {
		return COMP_BAH_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_BAH_REMARKS() {
		return COMP_BAH_REMARKS;
	}

	public void setCOMP_BAH_REMARKS_LABEL(HtmlOutputLabel COMP_BAH_REMARKS_LABEL) {
		this.COMP_BAH_REMARKS_LABEL = COMP_BAH_REMARKS_LABEL;
	}

	public void setCOMP_BAH_REMARKS(HtmlInputText COMP_BAH_REMARKS) {
		this.COMP_BAH_REMARKS = COMP_BAH_REMARKS;
	}

	public HtmlOutputLabel getCOMP_BAH_EXCH_RATE_LABEL() {
		return COMP_BAH_EXCH_RATE_LABEL;
	}

	public HtmlInputText getCOMP_BAH_EXCH_RATE() {
		return COMP_BAH_EXCH_RATE;
	}

	public void setCOMP_BAH_EXCH_RATE_LABEL(HtmlOutputLabel COMP_BAH_EXCH_RATE_LABEL) {
		this.COMP_BAH_EXCH_RATE_LABEL = COMP_BAH_EXCH_RATE_LABEL;
	}

	public void setCOMP_BAH_EXCH_RATE(HtmlInputText COMP_BAH_EXCH_RATE) {
		this.COMP_BAH_EXCH_RATE = COMP_BAH_EXCH_RATE;
	}

	public HtmlOutputLabel getCOMP_BAH_LC_AMT_LABEL() {
		return COMP_BAH_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_BAH_LC_AMT() {
		return COMP_BAH_LC_AMT;
	}

	public void setCOMP_BAH_LC_AMT_LABEL(HtmlOutputLabel COMP_BAH_LC_AMT_LABEL) {
		this.COMP_BAH_LC_AMT_LABEL = COMP_BAH_LC_AMT_LABEL;
	}

	public void setCOMP_BAH_LC_AMT(HtmlInputText COMP_BAH_LC_AMT) {
		this.COMP_BAH_LC_AMT = COMP_BAH_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_BAH_NO_OF_INST_LABEL() {
		return COMP_BAH_NO_OF_INST_LABEL;
	}

	public HtmlInputText getCOMP_BAH_NO_OF_INST() {
		return COMP_BAH_NO_OF_INST;
	}

	public void setCOMP_BAH_NO_OF_INST_LABEL(HtmlOutputLabel COMP_BAH_NO_OF_INST_LABEL) {
		this.COMP_BAH_NO_OF_INST_LABEL = COMP_BAH_NO_OF_INST_LABEL;
	}

	public void setCOMP_BAH_NO_OF_INST(HtmlInputText COMP_BAH_NO_OF_INST) {
		this.COMP_BAH_NO_OF_INST = COMP_BAH_NO_OF_INST;
	}

	public HtmlOutputLabel getCOMP_BAH_STATUS_LABEL() {
		return COMP_BAH_STATUS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BAH_STATUS() {
		return COMP_BAH_STATUS;
	}

	public void setCOMP_BAH_STATUS_LABEL(HtmlOutputLabel COMP_BAH_STATUS_LABEL) {
		this.COMP_BAH_STATUS_LABEL = COMP_BAH_STATUS_LABEL;
	}

	public void setCOMP_BAH_STATUS(HtmlSelectOneMenu COMP_BAH_STATUS) {
		this.COMP_BAH_STATUS = COMP_BAH_STATUS;
	}

	public HtmlOutputLabel getCOMP_BAH_PAY_PRIORITY_LABEL() {
		return COMP_BAH_PAY_PRIORITY_LABEL;
	}

	public HtmlInputText getCOMP_BAH_PAY_PRIORITY() {
		return COMP_BAH_PAY_PRIORITY;
	}

	public void setCOMP_BAH_PAY_PRIORITY_LABEL(HtmlOutputLabel COMP_BAH_PAY_PRIORITY_LABEL) {
		this.COMP_BAH_PAY_PRIORITY_LABEL = COMP_BAH_PAY_PRIORITY_LABEL;
	}

	public void setCOMP_BAH_PAY_PRIORITY(HtmlInputText COMP_BAH_PAY_PRIORITY) {
		this.COMP_BAH_PAY_PRIORITY = COMP_BAH_PAY_PRIORITY;
	}

	public HtmlOutputLabel getCOMP_BAH_DOC_DT_LABEL() {
		return COMP_BAH_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_BAH_DOC_DT() {
		return COMP_BAH_DOC_DT;
	}

	public void setCOMP_BAH_DOC_DT_LABEL(HtmlOutputLabel COMP_BAH_DOC_DT_LABEL) {
		this.COMP_BAH_DOC_DT_LABEL = COMP_BAH_DOC_DT_LABEL;
	}

	public void setCOMP_BAH_DOC_DT(HtmlCalendar COMP_BAH_DOC_DT) {
		this.COMP_BAH_DOC_DT = COMP_BAH_DOC_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_EDIT_BAH_REMARKS() {
		return COMP_UI_M_EDIT_BAH_REMARKS;
	}

	public void setCOMP_UI_M_EDIT_BAH_REMARKS(HtmlCommandButton COMP_UI_M_EDIT_BAH_REMARKS) {
		this.COMP_UI_M_EDIT_BAH_REMARKS = COMP_UI_M_EDIT_BAH_REMARKS;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_BAH_CUST_CODE() {
		return COMP_UI_M_LOV_BAH_CUST_CODE;
	}

	public void setCOMP_UI_M_LOV_BAH_CUST_CODE(HtmlCommandButton COMP_UI_M_LOV_BAH_CUST_CODE) {
		this.COMP_UI_M_LOV_BAH_CUST_CODE = COMP_UI_M_LOV_BAH_CUST_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_BAH_CURR_CODE() {
		return COMP_UI_M_LOV_BAH_CURR_CODE;
	}

	public void setCOMP_UI_M_LOV_BAH_CURR_CODE(HtmlCommandButton COMP_UI_M_LOV_BAH_CURR_CODE) {
		this.COMP_UI_M_LOV_BAH_CURR_CODE = COMP_UI_M_LOV_BAH_CURR_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public PT_IL_BROK_ADV_HDR getPT_IL_BROK_ADV_HDR_BEAN() {
		return PT_IL_BROK_ADV_HDR_BEAN;
	}

	public void setPT_IL_BROK_ADV_HDR_BEAN(PT_IL_BROK_ADV_HDR PT_IL_BROK_ADV_HDR_BEAN) {
		this.PT_IL_BROK_ADV_HDR_BEAN = PT_IL_BROK_ADV_HDR_BEAN;
	}
	public String PILT018_GOT0GRID(){
		return "PILT018_GO_GRID";
	}
	
	
	
	public void preForm(CompositeAction compositeAction) throws Exception{
		DBProcedures procedures = new DBProcedures();
		try {
			PT_IL_BROK_ADV_HDR_BEAN.setBAH_PYMT_DT(new CommonUtils().getCurrentDate());
			PT_IL_BROK_ADV_HDR_BEAN.setBAH_INST_FM_DT(new CommonUtils().getCurrentDate());
			compositeAction.getDUMMY_ACTION().getDUMMY_BEAN().setPT_IL_BROK_ADV_HDR_CF("N");
			compositeAction.getDUMMY_ACTION().getDUMMY_BEAN().setPT_IL_BROK_ADV_DTL_CF("P");
			PT_IL_BROK_ADV_HDR_BEAN.setUI_M_BASE_CURR_CODE(CommonUtils.getControlBean().getM_BASE_CURR());
			PT_IL_BROK_ADV_HDR_BEAN.setBAH_CURR_CODE(PT_IL_BROK_ADV_HDR_BEAN.getUI_M_BASE_CURR_CODE());
			COMP_BAH_PYMT_DT.resetValue();
			COMP_BAH_INST_FM_DT.resetValue();
			COMP_BAH_CURR_CODE.resetValue();
			
			ArrayList<String> calcValue = procedures.callP_VAL_SYSTEM("IL_BROK_CALC", "IL_BROK_CALC", "E");
			if (calcValue.size() != 0 ) {
				PT_IL_BROK_ADV_HDR_BEAN.setUI_M_BROK_CAL_METHOD(Double.parseDouble(calcValue.get(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	


	
	/**
	 * 
	 */
	public void whenNewFormInstance(){
		CommonUtils.setGlobalVariable("GLOBAL.BAH_SYS_ID", "NULL");
		CommonUtils.setGlobalVariable("GLOBAL.BAD_SYS_ID", "NULL");
		System.out.println("PT_IL_BROK_ADV_HDR_ACTION.whenNewFormInstance()");
	}
	
	/**
	 * 
	 * @param compositeAction
	 * @throws Exception 
	 */
	public void whenNewRecordInstance(CompositeAction compositeAction) throws Exception{
		String C1 = "SELECT 'X' FROM   PT_IL_BROK_ADV_DTL  WHERE  BAD_BAH_SYS_ID = ? ";
		String C2 = "SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_CODE = 'AG_MIS_AP_YN' AND ASD_USER_ID = ? ";
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		String M_ASD_CHAR_VALUE1 = null;
		String M_DUMMY = null;
		
		Connection connection = null;
		CRUDHandler handler =null;
		PT_IL_BROK_ADV_HDR PT_IL_BROK_ADV_HDR_BEAN = compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN();
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			
			if(compositeAction.getDUMMY_ACTION().getDUMMY_BEAN().getUI_M_BASE_CURR_CODE()!=null &&
					compositeAction.getDUMMY_ACTION().getDUMMY_BEAN().getUI_M_BASE_CURR_CODE().equalsIgnoreCase(PT_IL_BROK_ADV_HDR_BEAN.getBAH_CURR_CODE())){
				compositeAction.getParentAction().getCOMP_BAH_LC_AMT().setDisabled(true);
			}else{
				compositeAction.getParentAction().getCOMP_BAH_LC_AMT().setDisabled(false);
			}
			
			
			C2_REC = handler.executeSelectStatement(C2, connection,new Object[]{CommonUtils.getControlBean().getM_USER_ID()});
			if(C2_REC.next()){
				M_ASD_CHAR_VALUE1 = C2_REC.getString(1);
			}
			
			
			
			if("Y".equalsIgnoreCase(MigratingFunctions.nvl(compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_CONFIRM_FLAG(),"N"))){
				if("N".equalsIgnoreCase(MigratingFunctions.nvl(compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_PAID_FLAG(),"N"))){
					COMP_UI_M_BUT_APPROVE.setDisabled(false);
					if(COMP_UI_M_BUT_APPROVE.isDisabled()){
						COMP_UI_M_BUT_APPROVE.setDisabled(true);
					}
				}else{
					if(COMP_UI_M_BUT_APPROVE.isDisabled()){
						COMP_UI_M_BUT_APPROVE.setDisabled(false);
					}else{
						COMP_UI_M_BUT_APPROVE.setDisabled(false);
					}
				}
			}else{
				if(COMP_UI_M_BUT_APPROVE.isDisabled()){
					COMP_UI_M_BUT_APPROVE.setDisabled(true);
				}
				if(COMP_UI_M_BUT_APPROVE.isDisabled()){
					COMP_UI_M_BUT_APPROVE.setDisabled(true);
				}

			}
			
			
			if("N".equalsIgnoreCase(CommonUtils.nvl(M_ASD_CHAR_VALUE1, "N"))){
				if(COMP_UI_M_BUT_APPROVE.isDisabled()){
					COMP_UI_M_BUT_APPROVE.setDisabled(true);
				}
				
				if(COMP_UI_M_BUT_APPROVE.isDisabled()){
					COMP_UI_M_BUT_APPROVE.setDisabled(true);
				}
			}
			
			C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{PT_IL_BROK_ADV_HDR_BEAN.getBAH_SYS_ID()});
			if(C1_REC.next()){
				M_DUMMY = C1_REC.getString(1);
				if(compositeAction.getDUMMY_ACTION().getDUMMY_BEAN().getUI_M_BASE_CURR_CODE()!=null &&
						compositeAction.getDUMMY_ACTION().getDUMMY_BEAN().getUI_M_BASE_CURR_CODE().equalsIgnoreCase(PT_IL_BROK_ADV_HDR_BEAN.getBAH_CURR_CODE())){
					compositeAction.getParentAction().getCOMP_BAH_LC_AMT().setDisabled(true);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{try {CommonUtils.closeCursor(C1_REC);CommonUtils.closeCursor(C2_REC);} catch (Exception e) {}}
	}

	
	
	public void pre_query(CompositeAction compositeAction){
		if(CommonUtils.getGlobalVariable("BAH_SYS_ID")!=null){
			compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().setBAH_SYS_ID(Long.parseLong(CommonUtils.getGlobalVariable("BAH_SYS_ID")));
		}
	}
	
	public void  postQuery(){
		ArrayList<OracleParameter> list = null;
		
		try{
			list = P_VAL_CUST(PT_IL_BROK_ADV_HDR_BEAN.getBAH_CUST_CODE(), 
			           		  PT_IL_BROK_ADV_HDR_BEAN.getUI_M_BAH_CUST_DESC(),"N","N",null);
			if (list != null && !(list.isEmpty()) ) {
				PT_IL_BROK_ADV_HDR_BEAN.setUI_M_BAH_CUST_DESC((String)list.get(0).getValueObject());
			}
			            
			ArrayList<OracleParameter>  list1= P_VAL_CURR(PT_IL_BROK_ADV_HDR_BEAN.getBAH_CURR_CODE(),null, 
			           												"N","N",PT_IL_BROK_ADV_HDR_BEAN.getBAH_CUST_CODE());
			if (list1 != null  && !(list1.isEmpty())) {
				PT_IL_BROK_ADV_HDR_BEAN.setUI_M_BAH_CURR_NAME((String)list1.get(0).getValueObject());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
				
			

	public void validator_BAH_CURR_RATE_TYPE(FacesContext context,UIComponent component,Object value){
		try {
			PT_IL_BROK_ADV_HDR_BEAN.setBAH_EXCH_RATE(new DBProcedures().P_GET_EXCHANGE_RATE(PT_IL_BROK_ADV_HDR_BEAN.getBAH_CURR_CODE(),
					PT_IL_BROK_ADV_HDR_BEAN.getBAH_CURR_RATE_TYPE(), 
					PT_IL_BROK_ADV_HDR_BEAN.getBAH_PYMT_DT(), "E"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}



	public void validator_BAH_PYMT_DT(FacesContext context,UIComponent component,Object value){
		Date pamentDate = null;
		PT_IL_BROK_ADV_HDR_BEAN.setBAH_PYMT_DT((Date)value);
		try{
			pamentDate = PT_IL_BROK_ADV_HDR_BEAN.getBAH_PYMT_DT();
			if (pamentDate.before(new CommonUtils().getCurrentDate())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, 
						"91014" , new Object[]{"Payment Date" , "Greater than or Equal to System Date"}));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	
	

	public void validator_BAH_INST_FM_DT(FacesContext context,UIComponent component,Object value){
		
		Date installmentDate = null;
		String message = null;
		Date paymentDate = PT_IL_BROK_ADV_HDR_BEAN.getBAH_PYMT_DT();
		PT_IL_BROK_ADV_HDR_BEAN.setBAH_INST_FM_DT((Date) value);
		try{
			installmentDate = PT_IL_BROK_ADV_HDR_BEAN.getBAH_INST_FM_DT();
			if (paymentDate != null && installmentDate != null) {
				if (installmentDate.before(paymentDate)) {
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91014",new Object[]{"Installment Date","Greater than","or Equal to Payment Date"}));
				}
			}
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	







	

	

	
	 
	public void validator_BAH_FC_AMT(FacesContext context,UIComponent component,Object value){
		 DBProcedures procedures = new DBProcedures();
		 CRUDHandler handler = new CRUDHandler();
		 String M_FC_VALUE = null;
		 ResultSet resultSet1 = null, resultSet2 = null;
		 try{
			 Connection conn = CommonUtils.getConnection();
			 Object[] objects = {PT_IL_BROK_ADV_HDR_BEAN.getBAH_CUST_CODE()};
			 if(COMP_BAH_FC_AMT.getSubmittedValue()!= null){
				 if (!"".equals(COMP_BAH_FC_AMT.getSubmittedValue().toString())) {
					 PT_IL_BROK_ADV_HDR_BEAN.setBAH_FC_AMT(Double.parseDouble(COMP_BAH_FC_AMT.getSubmittedValue().toString()));
				 }
			 }
			 if (PT_IL_BROK_ADV_HDR_BEAN.getBAH_FC_AMT() != null) {
				 if(PT_IL_BROK_ADV_HDR_BEAN.getBAH_FC_AMT() <= 0){
					 Object[] values = {"FC AMOUNT","GREATER THAN ZERO",""};
//					 getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath,"91014",values));
					 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91014",values));
				 }
			 }
			 if (PT_IL_BROK_ADV_HDR_BEAN.getBAH_FC_AMT() != null) {
			 	 ArrayList<String> fcAmt = procedures.callP_VAL_ROUND_AMT(PT_IL_BROK_ADV_HDR_BEAN.getBAH_CURR_CODE(), PT_IL_BROK_ADV_HDR_BEAN.getBAH_FC_AMT().toString(), "V");
             
			 	 if (fcAmt.size() != 0) {
			 		 PT_IL_BROK_ADV_HDR_BEAN.setBAH_FC_AMT(Double.parseDouble(fcAmt.get(0)));
			 	 }
			 }
			 
			 if (PT_IL_BROK_ADV_HDR_BEAN.getBAH_FC_AMT() != null) {
				 PT_IL_BROK_ADV_HDR_BEAN.setBAH_LC_AMT(MigratingFunctions.nvl(PT_IL_BROK_ADV_HDR_BEAN.getBAH_FC_AMT(),0)*MigratingFunctions.nvl(PT_IL_BROK_ADV_HDR_BEAN.getBAH_EXCH_RATE(),0));

				 ArrayList<String> lcAmt = procedures.callP_VAL_ROUND_AMT(PT_IL_BROK_ADV_HDR_BEAN.getUI_M_BASE_CURR_CODE(), PT_IL_BROK_ADV_HDR_BEAN.getBAH_LC_AMT().toString(), "R");
				 if (lcAmt.size() != 0) {
					 COMP_BAH_LC_AMT.setSubmittedValue(lcAmt.get(0));
					 PT_IL_BROK_ADV_HDR_BEAN.setBAH_LC_AMT(Double.parseDouble(lcAmt.get(0)));
					 COMP_BAH_LC_AMT.setDisabled(true);
				 }
			 }
			 
			 if(MigratingFunctions.nvl(PT_IL_BROK_ADV_HDR_BEAN.getUI_M_BROK_CAL_METHOD(),1)== 1){
				 resultSet1 = handler.executeSelectStatement(QueryRepository.SELECT_BV_FC_VALUE, conn, objects);
				 if(resultSet1.next()){
					 M_FC_VALUE = resultSet1.getString(1);
				 }
				 CommonUtils.closeCursor(resultSet1);
			 }
			 else{
				 resultSet2 = handler.executeSelectStatement(QueryRepository.SELECT_ACV_FC_VALUE, conn, objects);
				 if(resultSet2.next()){
					 M_FC_VALUE = resultSet2.getString(1);
				 }
				 CommonUtils.closeCursor(resultSet2);
			 }
			 if (M_FC_VALUE != null) {
				 if (PT_IL_BROK_ADV_HDR_BEAN.getBAH_FC_AMT() != null) {
					 if (MigratingFunctions.nvl(Double.parseDouble(M_FC_VALUE), 0) < 
							 MigratingFunctions.nvl(PT_IL_BROK_ADV_HDR_BEAN.getBAH_FC_AMT(), 0)) {
						 getWarningMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath,"91229"));
//						 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91229"));
					 }
				 }
			 }
		 }catch(ValidatorException ve){
			ve.printStackTrace();
			throw ve;
		 }catch (NumberFormatException nfe) {
			 getErrorMap().put("current",Messages.getString("messageProperties_PILT018","PILT018$PT_IL_BROK_ADV_HDR$BAH_FC_AMT$numbermessage"));
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 } 
	
	public void validator_BAH_LC_AMT(FacesContext context,UIComponent component,Object value){
		PT_IL_BROK_ADV_HDR_BEAN.setBAH_LC_AMT((Double)value);
		String message = null;
		try{
			if(PT_IL_BROK_ADV_HDR_BEAN.getBAH_LC_AMT()!=null &&
					PT_IL_BROK_ADV_HDR_BEAN.getBAH_LC_AMT() < 0){
				Object[] values = {CommonUtils.getControlBean().getM_LANG_CODE(),"LC Amount","Greater than Zero"};
				message = Messages.getString(PELConstants.pelErrorMessagePath,"91014",values);
			}
			LIFELIB lifelib = new LIFELIB();
			lifelib.callP_VAL_FC_LC_TOLERANCE(CommonUtils.getProcedureValue(PT_IL_BROK_ADV_HDR_BEAN.getBAH_FC_AMT()),
							CommonUtils.getProcedureValue(PT_IL_BROK_ADV_HDR_BEAN.getBAH_LC_AMT()),
							CommonUtils.getProcedureValue(PT_IL_BROK_ADV_HDR_BEAN.getBAH_EXCH_RATE()), "E");
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	 public  String M_BUT_APPROVE_when_button_pressed(){
		 CommonUtils.clearMaps(this);
		 Connection connection = null;
		 CRUDHandler handler = new CRUDHandler();
		 try {
			 connection = CommonUtils.getConnection();
			 if (PT_IL_BROK_ADV_HDR_BEAN.getBAH_PAYMENT_YN() != null) {
				 Long sysId = PT_IL_BROK_ADV_HDR_BEAN.getBAH_SYS_ID();
				 if ("Y".equals(PT_IL_BROK_ADV_HDR_BEAN.getBAH_PAYMENT_YN())) {
					 BROK_ADVANCE_APPROVE(sysId, new CommonUtils().getCurrentDate());
					 getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath,"91071"));
					 getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
					 setCompUiMButApproveDisabled(true);
				 }else{
					 Object[] values = {sysId};
					 handler.executeUpdateStatement(QueryRepository.UPDATE_PT_IL_BROK_ADV_HDR, connection, values);
				 }
				 executeQuery(PT_IL_BROK_ADV_HDR_BEAN);
			 }
			 CommonUtils.getConnection().commit();
		 } catch (Exception e) {
			 e.printStackTrace();
			 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			 getErrorMap().put("Approve",e.getMessage());
		 } 
		 return "";
	 }
			
	 
	 public void executeQuery(PT_IL_BROK_ADV_HDR ptIlBrokAdvHdrBean){
		 try{	
			 String selectQuery  = "SELECT ROWID,PT_IL_BROK_ADV_HDR.* FROM PT_IL_BROK_ADV_HDR " +
			 					   "WHERE ROWID= '" + ptIlBrokAdvHdrBean.getROWID() + "'";
			 System.out.println("selectQuery"+selectQuery);
			 System.out.println("CODE **********"+ptIlBrokAdvHdrBean.getROWID());
			 //pre_query();
			 List<PT_IL_BROK_ADV_HDR> list = handler.fetch(selectQuery, "com.iii.pel.forms.PILT018.PT_IL_BROK_ADV_HDR",CommonUtils.getConnection());
			 if (list.size() <= 0) {
				 PT_IL_BROK_ADV_HDR_BEAN = list.get(0);
				 postQuery();
			 }
		 }catch(Exception e){
			 e.printStackTrace();
			 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			 getErrorMap().put("ExexuteQuery", e.getMessage());
		 }
	 }
	 
	public void L_VAL_REF_NO() throws Exception{
		ResultSet C1_REC=null;
		String message = null;
		try{
			Connection conn = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			String bah_cust_code=(String)getCOMP_BAH_CUST_CODE().getSubmittedValue();
			String bah_ref_no=(String)getCOMP_BAH_REF_NO().getSubmittedValue();
			String sql_C1="SELECT 'X' FROM  PT_IL_BROK_ADV_HDR  WHERE  BAH_CUST_CODE  = ? AND BAH_REF_NO =? ";
			
			C1_REC=handler.executeSelectStatement(sql_C1, conn , new Object[]{bah_cust_code,bah_ref_no});
			if(C1_REC.next()){
				String M_DUMMY=C1_REC.getString(1);
				message = Messages.getString(PELConstants.pelErrorMessagePath,"91041",new Object[]{"Reference Number"});
				throw new Exception(message);
			}
				
		}catch(Exception e){
			e.printStackTrace();
			throw  new Exception(e.getMessage());
		}finally{
			try {CommonUtils.closeCursor(C1_REC);} catch (Exception e) {}}
	}

	
	public void preInsert() throws Exception{
		Connection conn=null;
		CRUDHandler handler = null;
		ResultSet vembu_C2=null;
		ResultSet vembu_C1=null;
		String sql_C1="SELECT MAX(BAH_PAY_PRIORITY) FROM  PT_IL_BROK_ADV_HDR  WHERE  BAH_STATUS  = 'O' ";
		String sql_C2="SELECT PIL_BAH_SYS_ID.NEXTVAL FROM  DUAL ";
		try{
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			L_VAL_REF_NO();
			if(getCOMP_BAH_PAY_PRIORITY().getSubmittedValue()==null){
				vembu_C1 = handler.executeSelectStatement(sql_C1, conn);
				if(vembu_C1.next()){
					PT_IL_BROK_ADV_HDR_BEAN.setBAH_PAY_PRIORITY(vembu_C1.getDouble(1));
				}
			}
			vembu_C2 = handler.executeSelectStatement(sql_C2, conn);
			if(vembu_C2.next()){
				String bah_sys_id=vembu_C2.getString(1);
				PT_IL_BROK_ADV_HDR_BEAN.setBAH_SYS_ID(Long.parseLong(bah_sys_id));
			}
			PT_IL_BROK_ADV_HDR_BEAN.setBAH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			PT_IL_BROK_ADV_HDR_BEAN.setBAH_CR_DT(new CommonUtils().getCurrentDate());
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{try {CommonUtils.closeCursor(vembu_C1);CommonUtils.closeCursor(vembu_C2);} catch (Exception e) {}}
	}
	 
	
	 public void whenCreateRecord() throws Exception{
		 Connection connection = null;
		 ResultSet resultSet = null;
		 ResultSet resultSet1 = null;
		 CRUDHandler handler = new CRUDHandler();
		 try {
			 connection = CommonUtils.getConnection();
			 resultSet = handler.executeSelectStatement(QueryRepository.SELECT_BAH_PAY_PRIORITY,CommonUtils.getConnection());
			 if (resultSet.next()) {
				 PT_IL_BROK_ADV_HDR_BEAN.setBAH_PAY_PRIORITY(resultSet.getDouble(1));
			 }

			 /*Modified by pidugu raj dt: 14-09-2018 for KIC as suggested by sivaraman
			  * PT_IL_BROK_ADV_HDR_BEAN.setBAH_CURR_RATE_TYPE("B");*/
			 /*Newly Added by pidugu raj dt: 14-09-2018 for KIC as suggested by sivaraman*/
			 PT_IL_BROK_ADV_HDR_BEAN.setBAH_CURR_RATE_TYPE("F");
			 PT_IL_BROK_ADV_HDR_BEAN.setBAH_EXCH_RATE(1.0);
			 /*Newly Added by pidugu raj dt: 14-09-2018 for KIC as suggested by sivaraman*/
			 PT_IL_BROK_ADV_HDR_BEAN.setBAH_REPAY_TYPE("M");
			 PT_IL_BROK_ADV_HDR_BEAN.setBAH_STATUS("O");
			 PT_IL_BROK_ADV_HDR_BEAN.setBAH_CONFIRM_FLAG("N");
			 PT_IL_BROK_ADV_HDR_BEAN.setBAH_PYMT_TYPE("BA");
			 PT_IL_BROK_ADV_HDR_BEAN.setBAH_NO_OF_INST(1);
			 PT_IL_BROK_ADV_HDR_BEAN.setBAH_PYMT_DT(new CommonUtils().getCurrentDate());
			 PT_IL_BROK_ADV_HDR_BEAN.setBAH_PAYMENT_YN("Y");
			 PT_IL_BROK_ADV_HDR_BEAN.setBAH_REPAYMENT_YN("Y");
			 Object[] objects = {PT_IL_BROK_ADV_HDR_BEAN.getBAH_PYMT_TYPE()};
			 resultSet1 = handler.executeSelectStatement(QueryRepository.SELECT_PC_LONG_DESC, connection,objects);
			 if (resultSet1.next()) {
				 PT_IL_BROK_ADV_HDR_BEAN.setBAH_PAYMENT_YN(resultSet1.getString(1));
				 PT_IL_BROK_ADV_HDR_BEAN.setBAH_REPAYMENT_YN(resultSet1.getString(2));
			 }
			 
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (ParseException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}finally{try {CommonUtils.closeCursor(resultSet);CommonUtils.closeCursor(resultSet1);} catch (Exception e) {}}
	    }

	
	
	
	public String saveRecord() {
		CommonUtils.clearMaps(this);
		String message = null;
		try {
			if (PT_IL_BROK_ADV_HDR_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					preUpdate();
					new CRUDHandler().executeInsert(PT_IL_BROK_ADV_HDR_BEAN,CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					message = Messages.getString("messageProperties","errorPanel$message$update");
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
					getWarningMap().put("UPDATE", message);
				} else {
					message = Messages.getString("messageProperties","errorPanel$message$updatenotallowed");
					throw new Exception(message);
				}
			} else {
				if (isINSERT_ALLOWED()) {
					preInsert();
					new CRUDHandler().executeInsert(PT_IL_BROK_ADV_HDR_BEAN,CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					message = Messages.getString("messageProperties","errorPanel$message$save");

				} else {
					message = Messages.getString("messageProperties","errorPanel$message$insertnotallowed");
					throw new Exception(message);
				}
			}
			if ("Y".equals(PT_IL_BROK_ADV_HDR_BEAN.getBAH_REPAYMENT_YN())) {
				STP_INS_BRO_ADV_DTL(PT_IL_BROK_ADV_HDR_BEAN.getBAH_SYS_ID());
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("SAVE", message);
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		return null;
	}
	
	public void preUpdate(){
		Connection connection = null;
		CRUDHandler handler = null;
		String C1 = "SELECT MAX(BAH_PAY_PRIORITY) FROM PT_IL_BROK_ADV_HDR WHERE BAH_STATUS ='O'";
		ResultSet C1_REC = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection);
			if(PT_IL_BROK_ADV_HDR_BEAN.getBAH_PAY_PRIORITY()==null){
				if(C1_REC.next()){
					PT_IL_BROK_ADV_HDR_BEAN.setBAH_PAY_PRIORITY(C1_REC.getDouble(1));
				}
			}
			PT_IL_BROK_ADV_HDR_BEAN.setBAH_UPD_DT(new CommonUtils().getCurrentDate());
			PT_IL_BROK_ADV_HDR_BEAN.setBAH_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		}catch(Exception exception){
			exception.getMessage();
		}finally{try {CommonUtils.closeCursor(C1_REC);} catch (Exception e) {}}
	}

	public String deleteRecord(){
		CommonUtils.clearMaps(this);
		String message = null;

		try {
			if (isDELETE_ALLOWED()) {
				if (PT_IL_BROK_ADV_HDR_BEAN.getROWID() != null) {
					preDelete();
					new CRUDHandler().executeDelete(PT_IL_BROK_ADV_HDR_BEAN,CommonUtils.getConnection());
					PT_IL_BROK_ADV_HDR_BEAN = new PT_IL_BROK_ADV_HDR();
					message = Messages.getString("messageProperties","errorPanel$message$delete");
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
					getWarningMap().put("DELETE", message);
				}
			} else {
				message = Messages.getString("messageProperties","errorPanel$message$deletenotallowed");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getErrorMap().put("DELETE", message);
			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}
		return null;
	}

	
	public void preDelete() throws Exception{
		ResultSet resultSet = null;
		String CURSOR_C1 = "SELECT DISTINCT 'X' FROM   PT_IL_BROK_ADV_DTL WHERE  BAD_BAH_SYS_ID = ?  ";
		try {
			resultSet = new CRUDHandler().executeSelectStatement(CURSOR_C1, CommonUtils.getConnection(), 
					new Object[]{PT_IL_BROK_ADV_HDR_BEAN.getBAH_SYS_ID()});
			if (resultSet.next()) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91050"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}}
	}

	

	public List<LovBean> CUSTCODESuggestionBox(Object event) throws Exception{
		suggesionList = new ArrayList<LovBean>();
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			suggesionList = itemUtil.P_CALL_LOV("PILT018",
					"PT_IL_BROK_ADV_HDR", "BAH_CUST_CODE", "002", null, null,
					null, null, (String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggesionList;
	}


		
	/**
	 * 
	 * @param context
	 * @param component
	 * @param object
	 */
	public void whenValidateCustCode(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try{
			PT_IL_BROK_ADV_HDR_BEAN.setBAH_CUST_CODE((String)value);
			LIFELIB lifelib = new LIFELIB();
			lifelib.P_VAL_CUST(PT_IL_BROK_ADV_HDR_BEAN.getBAH_CUST_CODE(), null, "N", "E", null);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void whenValidateREFNO(FacesContext context,UIComponent component, Object object) {
		String value = (String) object;
		try{
			PT_IL_BROK_ADV_HDR_BEAN.setBAH_REF_NO((String)value);
			L_VAL_REF_NO();
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public List CURRCODESuggestionBox(Object obj) throws Exception{
		suggesionList = new ArrayList<LovBean>();
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			suggesionList = itemUtil.P_CALL_LOV("PILT018",
					"PT_IL_BROK_ADV_HDR", "BAH_CURR_CODE", PT_IL_BROK_ADV_HDR_BEAN.getBAH_CUST_CODE(), null, null,
					null, null, (String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggesionList;
	}

	
	

	public void currencyValidator(FacesContext context,UIComponent component,Object value){
		PT_IL_BROK_ADV_HDR_BEAN.setBAH_CURR_CODE((String)value);
		try{
				ArrayList<OracleParameter> list = P_VAL_CURR(PT_IL_BROK_ADV_HDR_BEAN.getBAH_CURR_CODE(),null, "N", "E", PT_IL_BROK_ADV_HDR_BEAN.getBAH_CUST_CODE());
				if (list != null && !(list.isEmpty())) {
					PT_IL_BROK_ADV_HDR_BEAN.setUI_M_BAH_CURR_NAME((String)list.get(0).getValueObject());
				}
				if(PT_IL_BROK_ADV_HDR_BEAN.getBAH_CURR_CODE()!=null && PT_IL_BROK_ADV_HDR_BEAN.getBAH_CURR_CODE().equals(compositeAction.getDUMMY_ACTION().getDUMMY_BEAN().getUI_M_BASE_CURR_CODE())){
					COMP_BAH_LC_AMT.setDisabled(true);
				}else{
					COMP_BAH_LC_AMT.setDisabled(false);
				}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
    /**
    *
    * @param P_CURR_CODE-IN
    * @param P_CURR_NAME-IN OUT
    * @param P_NAME_FLAG-IN
    * @param P_ERR_FLAG-IN
    * @param P_CUST_CODE-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_VAL_CURR(
                    Object P_CURR_CODE,
         Object P_CURR_NAME,
         Object P_NAME_FLAG,
         Object P_ERR_FLAG,
         Object P_CUST_CODE) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CURR_CODE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN OUT2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_CURR_NAME);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_NAME_FLAG);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ERR_FLAG);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CUST_CODE);
          parameterList.add(param5);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P_VAL_CURR");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
	
	
	
	public String backToSearch(){
		CommonUtils.clearMaps(this);
		return  SearchConstants.BACK_TO_SEARCH_PAGE;

	}

	public boolean isCompUiMButApproveDisabled() {
		return compUiMButApproveDisabled;
	}

	public void setCompUiMButApproveDisabled(boolean compUiMButApproveDisabled) {
		this.compUiMButApproveDisabled = compUiMButApproveDisabled;
	}
		
	public boolean isCompBahLcAmtDisabled() {
		return compBahLcAmtDisabled;
	}

	public void setCompBahLcAmtDisabled(boolean compBahLcAmtDisabled) {
		this.compBahLcAmtDisabled = compBahLcAmtDisabled;
	}


	public HtmlOutputText getCOMP_UI_M_APPROVAL_STATUS() {
		return COMP_UI_M_APPROVAL_STATUS;
	}

	public void setCOMP_UI_M_APPROVAL_STATUS(
			HtmlOutputText comp_ui_m_approval_status) {
		COMP_UI_M_APPROVAL_STATUS = comp_ui_m_approval_status;
	}
	
	
	
	
	public void paymentTypeValidator(FacesContext context,UIComponent component,Object obj){
		PT_IL_BROK_ADV_HDR_BEAN.setBAH_PYMT_TYPE((String)obj);
		Connection connection = null;
		CRUDHandler handler = null;
		String C1 = "SELECT PC_LONG_DESC,PC_BL_LONG_DESC FROM PM_CODES  "
				+ "WHERE PC_TYPE = 'IL_BAH_PYMT' "
				+ "AND   PC_CODE = ? ";
		ResultSet C1_REC = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{PT_IL_BROK_ADV_HDR_BEAN.getBAH_PYMT_TYPE()});
			if(C1_REC.next()){
				PT_IL_BROK_ADV_HDR_BEAN.setBAH_PAYMENT_YN(C1_REC.getString(1));
				PT_IL_BROK_ADV_HDR_BEAN.setBAH_REPAYMENT_YN(C1_REC.getString(2));
			}
			COMP_BAH_REPAYMENT_YN.setSubmittedValue(PT_IL_BROK_ADV_HDR_BEAN.getBAH_REPAYMENT_YN());
			COMP_BAH_REPAYMENT_YN.resetValue();
		}catch(Exception e){
			e.getMessage();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally{try {CommonUtils.closeCursor(C1_REC);} catch (Exception e) {}}
	}

	public boolean isAPPROVE_STATUS() {
		return APPROVE_STATUS;
	}

	public void setAPPROVE_STATUS(boolean approve_status) {
		APPROVE_STATUS = approve_status;
	}
	
	
	public void onLoad(PhaseEvent e) {
		try {
			if (isFormFlag()) {
				preForm(compositeAction);
				whenNewFormInstance();
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				pre_query(compositeAction);
				executeQuery(compositeAction);
				if (PT_IL_BROK_ADV_HDR_BEAN.getROWID() != null) {
					postQuery();
				} else {
					whenCreateRecord();
				}
				whenNewRecordInstance(compositeAction);
				setBlockFlag(false);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,ex.getMessage());
			getErrorMap().put("onLoad", ex.getMessage());
		}

	}
	

	public void executeQuery(CompositeAction compositeAction) throws Exception{
		Connection con = CommonUtils.getConnection();
		try{
			String rowId = compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getROWID();
			String selectQuery  = "SELECT ROWID,PT_IL_BROK_ADV_HDR.* FROM PT_IL_BROK_ADV_HDR WHERE ROWID LIKE '%" +rowId + "%'";
			con = CommonUtils.getConnection();
			List list = handler.fetch(selectQuery, "com.iii.pel.forms.PILT018.PT_IL_BROK_ADV_HDR",con);
			if(list!=null && !list.isEmpty()){
				setPT_IL_BROK_ADV_HDR_BEAN((PT_IL_BROK_ADV_HDR)list.get(0));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
    /**
    *
    * @param P_BAH_SYS_ID-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> STP_INS_BRO_ADV_DTL(
                    Object P_BAH_SYS_ID) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_BAH_SYS_ID);
          parameterList.add(param1);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_BROKER_ADVANCE_PYMT.STP_INS_BRO_ADV_DTL");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }

  
  /**
  *
  * @param P_CUST_CODE-IN
  * @param P_CUST_NAME-IN OUT
  * @param P_NAME_FLAG-IN
  * @param P_ERR_FLAG-IN
  * @param P_DIVN_CODE-IN
  *
  * @return ArrayList of type Oracle Parameter
  * @throws Exception
  */
public ArrayList<OracleParameter> P_VAL_CUST(
                  Object P_CUST_CODE,
       Object P_CUST_NAME,
       Object P_NAME_FLAG,
       Object P_ERR_FLAG,
       Object P_DIVN_CODE) throws ProcedureException {
     Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
        OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CUST_CODE);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN OUT2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_CUST_NAME);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_NAME_FLAG);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ERR_FLAG);
        parameterList.add(param4);
        OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DIVN_CODE);
        parameterList.add(param5);

       OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.executeProc(parameterList, connection,
               "P_VAL_CUST");
     } catch(Exception e) {
     	ErrorHelpUtil.getErrorForProcedure(connection);
            throw new ProcedureException(e.getMessage());
     }
    return outputList;
}
  

/**
*
* @param P_BAH_SYS_ID-IN
* @param P_BAH_PAID_DT-IN
*
* @return ArrayList of type Oracle Parameter
* @throws Exception
*/
public ArrayList<OracleParameter> BROK_ADVANCE_APPROVE(
                Object P_BAH_SYS_ID,
     Object P_BAH_PAID_DT) throws ProcedureException {
   Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_BAH_SYS_ID);
      parameterList.add(param1);
      OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_BAH_PAID_DT);
      parameterList.add(param2);

     OracleProcedureHandler procHandler = new OracleProcedureHandler();
      outputList = procHandler.executeProc(parameterList, connection,
             "P9ILPK_BROKER_ADVANCE_PYMT.BROK_ADVANCE_APPROVE");
   } catch(Exception e) {
   	ErrorHelpUtil.getErrorForProcedure(connection);
          throw new ProcedureException(e.getMessage());
   }
  return outputList;
}




/**
 * Instantiates all components in PT_IL_BROK_ADV_HDR_ACTION
 */
public void instantiateAllComponent(){
	// Instantiating HtmlInputText
	COMP_BAH_CUST_CODE				 = new HtmlInputText();
	COMP_BAH_REF_NO					 = new HtmlInputText();
	COMP_BAH_CURR_CODE				 = new HtmlInputText();
	COMP_BAH_FC_AMT					 = new HtmlInputText();
	COMP_BAH_TXN_CODE				 = new HtmlInputText();
	COMP_UI_M_BAH_CUST_DESC				 = new HtmlInputText();
	COMP_UI_M_BAH_CURR_NAME				 = new HtmlInputText();
	COMP_BAH_DOC_NO					 = new HtmlInputText();
	COMP_BAH_REMARKS				 = new HtmlInputText();
	COMP_BAH_EXCH_RATE				 = new HtmlInputText();
	COMP_BAH_LC_AMT					 = new HtmlInputText();
	COMP_BAH_NO_OF_INST				 = new HtmlInputText();
	COMP_BAH_PAY_PRIORITY				 = new HtmlInputText();

	// Instantiating HtmlSelectOneMenu
	COMP_BAH_PYMT_TYPE				 = new HtmlSelectOneMenu();
	COMP_BAH_CURR_RATE_TYPE				 = new HtmlSelectOneMenu();
	COMP_BAH_REPAY_TYPE				 = new HtmlSelectOneMenu();
	COMP_BAH_CONFIRM_FLAG				 = new HtmlSelectOneMenu();
	COMP_BAH_PAYMENT_YN				 = new HtmlSelectOneMenu();
	COMP_BAH_REPAYMENT_YN				 = new HtmlSelectOneMenu();
	COMP_BAH_STATUS					 = new HtmlSelectOneMenu();

	// Instantiating HtmlCalendar
	COMP_BAH_PYMT_DT				 = new HtmlCalendar();
	COMP_BAH_INST_FM_DT				 = new HtmlCalendar();
	COMP_BAH_DOC_DT					 = new HtmlCalendar();

	// Instantiating HtmlCommandButton
	COMP_UI_M_EDIT_BAH_REMARKS			 = new HtmlCommandButton();
	COMP_UI_M_LOV_BAH_CUST_CODE			 = new HtmlCommandButton();
	COMP_UI_M_LOV_BAH_CURR_CODE			 = new HtmlCommandButton();
	COMP_UI_M_BUT_APPROVE				 = new HtmlCommandButton();
	test						 = new HtmlCommandButton();

}

/**
 * Resets all components in PT_IL_BROK_ADV_HDR_ACTION
 */
public void resetAllComponent(){
	// Reseting HtmlInputText
	COMP_BAH_CUST_CODE.resetValue();
	COMP_BAH_REF_NO.resetValue();
	COMP_BAH_CURR_CODE.resetValue();
	COMP_BAH_FC_AMT.resetValue();
	COMP_BAH_TXN_CODE.resetValue();
	COMP_UI_M_BAH_CUST_DESC.resetValue();
	COMP_UI_M_BAH_CURR_NAME.resetValue();
	COMP_BAH_DOC_NO.resetValue();
	COMP_BAH_REMARKS.resetValue();
	COMP_BAH_EXCH_RATE.resetValue();
	COMP_BAH_LC_AMT.resetValue();
	COMP_BAH_NO_OF_INST.resetValue();
	COMP_BAH_PAY_PRIORITY.resetValue();

	// Reseting HtmlSelectOneMenu
	COMP_BAH_PYMT_TYPE.resetValue();
	COMP_BAH_CURR_RATE_TYPE.resetValue();
	COMP_BAH_REPAY_TYPE.resetValue();
	COMP_BAH_CONFIRM_FLAG.resetValue();
	COMP_BAH_PAYMENT_YN.resetValue();
	COMP_BAH_REPAYMENT_YN.resetValue();
	COMP_BAH_STATUS.resetValue();

	// Reseting HtmlCalendar
	COMP_BAH_PYMT_DT.resetValue();
	COMP_BAH_INST_FM_DT.resetValue();
	COMP_BAH_DOC_DT.resetValue();

}

/**
 * Disables all components in PT_IL_BROK_ADV_HDR_ACTION
 */
public void disableAllComponent(boolean disabled){
	// Disabling HtmlInputText
	COMP_BAH_CUST_CODE.setDisabled(disabled);
	COMP_BAH_REF_NO.setDisabled(disabled);
	COMP_BAH_CURR_CODE.setDisabled(disabled);
	COMP_BAH_FC_AMT.setDisabled(disabled);
	COMP_BAH_TXN_CODE.setDisabled(disabled);
	COMP_UI_M_BAH_CUST_DESC.setDisabled(disabled);
	COMP_UI_M_BAH_CURR_NAME.setDisabled(disabled);
	COMP_BAH_DOC_NO.setDisabled(disabled);
	COMP_BAH_REMARKS.setDisabled(disabled);
	COMP_BAH_EXCH_RATE.setDisabled(disabled);
	COMP_BAH_LC_AMT.setDisabled(disabled);
	COMP_BAH_NO_OF_INST.setDisabled(disabled);
	COMP_BAH_PAY_PRIORITY.setDisabled(disabled);

	// Disabling HtmlSelectOneMenu
	COMP_BAH_PYMT_TYPE.setDisabled(disabled);
	COMP_BAH_CURR_RATE_TYPE.setDisabled(disabled);
	COMP_BAH_REPAY_TYPE.setDisabled(disabled);
	COMP_BAH_CONFIRM_FLAG.setDisabled(disabled);
	COMP_BAH_PAYMENT_YN.setDisabled(disabled);
	COMP_BAH_REPAYMENT_YN.setDisabled(disabled);
	COMP_BAH_STATUS.setDisabled(disabled);

	// Disabling HtmlCalendar
	COMP_BAH_PYMT_DT.setDisabled(disabled);
	COMP_BAH_INST_FM_DT.setDisabled(disabled);
	COMP_BAH_DOC_DT.setDisabled(disabled);

	// Disabling HtmlCommandButton
	COMP_UI_M_EDIT_BAH_REMARKS.setDisabled(disabled);
	COMP_UI_M_LOV_BAH_CUST_CODE.setDisabled(disabled);
	COMP_UI_M_LOV_BAH_CURR_CODE.setDisabled(disabled);
	COMP_UI_M_BUT_APPROVE.setDisabled(disabled);
	test.setDisabled(disabled);

}


/*Newly added by pidugu raj dt: 07-09-2018 for exchange rate field setting*/

public void whenValidateExchangeRate(FacesContext context,UIComponent component, Object object) {
	Double value =  (Double)object;
	try{
		PT_IL_BROK_ADV_HDR_BEAN.setBAH_EXCH_RATE(value);
		
	}catch(Exception e){
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}	


}

