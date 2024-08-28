package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.common.dms.DMSUtil;
import com.iii.pel.utils.P9ILPK_PREM_COLL;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;


public class PT_IL_PREM_COLL_ACTION extends CommonReportAction/*CommonAction*/ {

	private HtmlOutputLabel COMP_UI_M_ADDL_STATUS_DESC;

	private HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_PC_PAID_DT_LABEL;

	private HtmlCalendar COMP_PC_PAID_DT;

	private HtmlOutputLabel COMP_UI_M_FC_NET_PREM_LABEL;

	private HtmlInputText COMP_UI_M_FC_NET_PREM;
	
	private HtmlInputText COMP_PC_DRCR_DOC_NO;
	
	private HtmlOutputLabel COMP_PC_DRCR_DOC_NO_LABEL;

	private HtmlOutputLabel COMP_UI_M_PC_FC_OUTSTD_AMT_LABEL;

	private HtmlOutputLabel COMP_UI_M_PC_FC_OUTSTD_AMT_1_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_OUTSTD_AMT;

	private HtmlOutputLabel COMP_UI_M_PC_LC_OUTSTD_AMT_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_OUTSTD_AMT;

	private HtmlOutputLabel COMP_PC_FC_AVLB_BAL_AMT_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_OUTSTD_AMT_1;

	private HtmlOutputLabel COMP_UI_M_PC_LC_OUTSTD_AMT_1_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_OUTSTD_AMT_1;

	private HtmlInputText COMP_PC_FC_AVLB_BAL_AMT;

	private HtmlOutputLabel COMP_PC_PAID_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PC_PAID_FLAG;

	private HtmlOutputLabel COMP_PC_REF_NO_LABEL;

	private HtmlInputText COMP_PC_REF_NO;

	private HtmlOutputLabel COMP_PC_APPRV_DT_LABEL;

	private HtmlCalendar COMP_PC_APPRV_DT;

	private HtmlOutputLabel COMP_PC_PREM_HOLIDAY_YN_LABEL;

	private HtmlSelectOneMenu COMP_PC_PREM_HOLIDAY_YN;
	
	private HtmlSelectOneMenu COMP_PC_WAIVE_PREM_YN;

	private HtmlOutputLabel COMP_PC_FC_BASIC_PREM_LABEL;

	private HtmlInputText COMP_PC_FC_BASIC_PREM;

	private HtmlOutputLabel COMP_PC_LC_BASIC_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_BASIC_PREM;

	private HtmlOutputLabel COMP_PC_FC_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_PC_FC_CHARGE_AMT;

	private HtmlOutputLabel COMP_PC_LC_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_CHARGE_AMT;

	private HtmlOutputLabel COMP_PC_FC_ADDL_PREM_LABEL;

	private HtmlInputText COMP_PC_FC_ADDL_PREM;

	private HtmlOutputLabel COMP_PC_LC_ADDL_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_ADDL_PREM;

	private HtmlOutputLabel COMP_PC_FC_CHARGE_LABEL;

	private HtmlInputText COMP_PC_FC_CHARGE;

	private HtmlOutputLabel COMP_PC_LC_CHARGE_LABEL;

	private HtmlInputText COMP_PC_LC_CHARGE;

	private HtmlOutputLabel COMP_PC_FC_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PC_FC_LOAD_AMT;

	private HtmlOutputLabel COMP_PC_LC_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_LOAD_AMT;

	private HtmlOutputLabel COMP_PC_FC_DISCOUNT_LABEL;

	private HtmlInputText COMP_PC_FC_DISCOUNT;

	private HtmlOutputLabel COMP_PC_LC_DISCOUNT_LABEL;

	private HtmlInputText COMP_PC_LC_DISCOUNT;

	private HtmlOutputLabel COMP_PC_FC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_PC_FC_GROSS_PREM;

	private HtmlOutputLabel COMP_PC_LC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_GROSS_PREM;

	private HtmlOutputLabel COMP_UI_M_FC_LOAN_INT_LABEL;

	private HtmlInputText COMP_UI_M_FC_LOAN_INT;

	private HtmlOutputLabel COMP_UI_M_LC_LOAN_INT_LABEL;

	private HtmlInputText COMP_UI_M_LC_LOAN_INT;

	private HtmlOutputLabel COMP_PC_FC_UNPAID_PREM_INT_LABEL;

	private HtmlInputText COMP_PC_FC_UNPAID_PREM_INT;

	private HtmlOutputLabel COMP_PC_LC_UNPAID_PREM_INT_LABEL;

	private HtmlInputText COMP_PC_LC_UNPAID_PREM_INT;

	private HtmlOutputLabel COMP_UI_M_LC_NET_PREM_LABEL;

	private HtmlInputText COMP_UI_M_LC_NET_PREM;

	private HtmlOutputLabel COMP_UI_M_PREM_FC_TO_PAY_LABEL;

	private HtmlInputText COMP_UI_M_PREM_FC_TO_PAY;

	private HtmlOutputLabel COMP_UI_M_PREM_TO_PAY_LABEL;

	private HtmlInputText COMP_UI_M_PREM_TO_PAY;

	private HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_AVLB_BAL_AMT;

	private HtmlOutputLabel COMP_UI_M_PREM_FC_AMT_LABEL;
	
	private HtmlOutputLabel COMP_PC_WAIVE_PREM_YN_LABEL;

	private HtmlInputText COMP_UI_M_PREM_FC_AMT;

	private HtmlOutputLabel COMP_UI_M_PREM_AMT_LABEL;

	private HtmlInputText COMP_UI_M_PREM_AMT;

	private HtmlOutputLabel COMP_PC_TEMP_RCPT_NO_LABEL;

	private HtmlInputText COMP_PC_TEMP_RCPT_NO;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_PC_LC_UNPAID_WAIVE_PREM_INT_LABEL;

	private HtmlInputText COMP_PC_LC_UNPAID_WAIVE_PREM_INT;

	private HtmlInputText COMP_PC_FC_UNPAID_WAIVE_PREM_INT;

	private HtmlOutputLabel COMP_PC_FC_UNPAID_WAIVE_PREM_INT_LABEL;

	private HtmlCommandButton COMP_UI_M_LOV_POL_NO;

	private HtmlCommandButton COMP_UI_M_BUT_REINSTATE;

	private HtmlCommandButton COMP_UI_M_BUT_INT_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_CVR_DTL;

	private HtmlCommandButton COMP_UI_M_BUT_BROKER_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_CHG_DTL;

	private HtmlCommandButton COMP_UI_M_BUT_FAC;

	private HtmlCommandButton COMP_UI_M_BUT_LOAN_INT;
	
	private HtmlCommandButton COMP_REV;
	
	public HtmlCommandButton getCOMP_REV() {
		return COMP_REV;
	}

	public void setCOMP_REV(HtmlCommandButton cOMP_REV) {
		COMP_REV = cOMP_REV;
	}

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private HtmlCommandButton COMP_UI_M_FUND_QUERY_DETAILS;

	private HtmlOutputLabel COMP_PC_FC_PAID_AMOUNT_LABEL;

	private HtmlInputText COMP_PC_FC_PAID_AMOUNT;

	private HtmlOutputLabel COMP_PC_LC_PAID_AMOUNT_LABEL;

	private HtmlInputText COMP_PC_LC_PAID_AMOUNT;
	
	/* Newly Added By Dhinesh on 23-06-2017 for ssp call id : ZBILQC-1727457 */
	private HtmlOutputLabel COMP_PC_DEP_REF_DOC_NO_LABEL;
	private HtmlOutputLabel COMP_PC_DEP_REF_DOC_DT_LABEL;
	private HtmlInputText COMP_PC_DEP_REF_DOC_NO;
	private HtmlCalendar COMP_PC_DEP_REF_DOC_DT;
	
	public HtmlOutputLabel getCOMP_PC_DEP_REF_DOC_NO_LABEL() {
		return COMP_PC_DEP_REF_DOC_NO_LABEL;
	}

	public void setCOMP_PC_DEP_REF_DOC_NO_LABEL(
			HtmlOutputLabel cOMP_PC_DEP_REF_DOC_NO_LABEL) {
		COMP_PC_DEP_REF_DOC_NO_LABEL = cOMP_PC_DEP_REF_DOC_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_PC_DEP_REF_DOC_DT_LABEL() {
		return COMP_PC_DEP_REF_DOC_DT_LABEL;
	}

	public void setCOMP_PC_DEP_REF_DOC_DT_LABEL(
			HtmlOutputLabel cOMP_PC_DEP_REF_DOC_DT_LABEL) {
		COMP_PC_DEP_REF_DOC_DT_LABEL = cOMP_PC_DEP_REF_DOC_DT_LABEL;
	}

	public HtmlInputText getCOMP_PC_DEP_REF_DOC_NO() {
		return COMP_PC_DEP_REF_DOC_NO;
	}

	public void setCOMP_PC_DEP_REF_DOC_NO(HtmlInputText cOMP_PC_DEP_REF_DOC_NO) {
		COMP_PC_DEP_REF_DOC_NO = cOMP_PC_DEP_REF_DOC_NO;
	}

	public HtmlCalendar getCOMP_PC_DEP_REF_DOC_DT() {
		return COMP_PC_DEP_REF_DOC_DT;
	}

	public void setCOMP_PC_DEP_REF_DOC_DT(HtmlCalendar cOMP_PC_DEP_REF_DOC_DT) {
		COMP_PC_DEP_REF_DOC_DT = cOMP_PC_DEP_REF_DOC_DT;
	}
	
	
	/* End */
	

	

	private PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN;

	public PILT003_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_PREM_COLL_HELPER helper;

	private PT_IL_POLICY_HELPER policyHelper;

	private List<PT_IL_PREM_COLL> dataList_PT_IL_PREM_COLL = new ArrayList<PT_IL_PREM_COLL>();

	private UIData dataTable;

	private List<SelectItem> listPC_PAID_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPC_PREM_HOLIDAY_YN = new ArrayList<SelectItem>();

	ArrayList<LovBean> list = new ArrayList<LovBean>();

	// Added by Akash DPLI customization.
	
	//added by agalya for print button 
	private HtmlCommandButton COMP_UI_PRINT_BUTTON;
	public HtmlCommandButton getCOMP_UI_PRINT_BUTTON() {
		return COMP_UI_PRINT_BUTTON;
	}

	public void setCOMP_UI_PRINT_BUTTON(HtmlCommandButton cOMP_UI_PRINT_BUTTON) {
		COMP_UI_PRINT_BUTTON = cOMP_UI_PRINT_BUTTON;
	}
	//end

	private HtmlOutputLabel COMP_PC_FLEX_01_LABEL;
	private HtmlSelectOneMenu COMP_PC_FLEX_01;

	private List<SelectItem> listYesNo = new ArrayList<SelectItem>();

	
	
	/*Added by Ram on 23/02/2017 for fetch Records by Statuswise*/
	private HtmlSelectOneMenu COMP_POL_STS_FLAG;

	public HtmlSelectOneMenu getCOMP_POL_STS_FLAG() {
		return COMP_POL_STS_FLAG;
	}

	public void setCOMP_POL_STS_FLAG(HtmlSelectOneMenu cOMP_POL_STS_FLAG) {
		COMP_POL_STS_FLAG = cOMP_POL_STS_FLAG;
	}
	
	public void validatePOL_STS_FLAG(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		
		PT_IL_PREM_COLL_BEAN.setPOL_STS_FLAG((String)value);
		CommonUtils.setGlobalVariable("PREM_COLL.POL_STS",(String)value);
		COMP_POL_STS_FLAG.resetValue();
		
	}
	
	private List<SelectItem> listPOL_STS_FLAG = new ArrayList<SelectItem>();
   
   public List<SelectItem> getListPOL_STS_FLAG() {
		if (listPOL_STS_FLAG.size() == 0) {
			listPOL_STS_FLAG.clear();
			try {
				Connection con = CommonUtils.getConnection();
				listPOL_STS_FLAG = new ArrayList<SelectItem>();
				listPOL_STS_FLAG = ListItemUtil.getDropDownListValue(con,
						"PILT003_APAC", "PT_IL_PREM_COLL",
						"PT_IL_PREM_COLL.POL_STS_FLAG", "IL_RENV_STS");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOL_STS_FLAG;
	}

	public void setListPOL_STS_FLAG(List<SelectItem> listPOL_STS_FLAG) {
		this.listPOL_STS_FLAG = listPOL_STS_FLAG;
	}

	
	public PT_IL_PREM_COLL_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_PREM_COLL_HELPER helper) {
		this.helper = helper;
	}
	/*End*/
	public PT_IL_PREM_COLL_ACTION() {
		ArrayList<SelectItem> listtmp = new ArrayList<SelectItem>();
		listtmp.add(new SelectItem("N", "No"));
		listtmp.add(new SelectItem("Y", "Yes"));
		setListYesNo(listtmp);
		PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
		helper = new PT_IL_PREM_COLL_HELPER();
		instantiateAllComponent();
		P9ILPK_PREM_COLL p9ilpk_prem_coll = new P9ILPK_PREM_COLL();
	}

	public HtmlOutputLabel getCOMP_UI_M_ADDL_STATUS_DESC() {
		return COMP_UI_M_ADDL_STATUS_DESC;
	}

	public void setCOMP_UI_M_ADDL_STATUS_DESC(
			HtmlOutputLabel COMP_UI_M_ADDL_STATUS_DESC) {
		this.COMP_UI_M_ADDL_STATUS_DESC = COMP_UI_M_ADDL_STATUS_DESC;
	}

	public HtmlOutputLabel getCOMP_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_SCHD_PYMT_DT() {
		return COMP_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_PC_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_PC_SCHD_PYMT_DT_LABEL = COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_PC_SCHD_PYMT_DT(HtmlCalendar COMP_PC_SCHD_PYMT_DT) {
		this.COMP_PC_SCHD_PYMT_DT = COMP_PC_SCHD_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_PC_PAID_DT_LABEL() {
		return COMP_PC_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_PAID_DT() {
		return COMP_PC_PAID_DT;
	}

	public void setCOMP_PC_PAID_DT_LABEL(HtmlOutputLabel COMP_PC_PAID_DT_LABEL) {
		this.COMP_PC_PAID_DT_LABEL = COMP_PC_PAID_DT_LABEL;
	}

	public void setCOMP_PC_PAID_DT(HtmlCalendar COMP_PC_PAID_DT) {
		this.COMP_PC_PAID_DT = COMP_PC_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_NET_PREM_LABEL() {
		return COMP_UI_M_FC_NET_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_NET_PREM() {
		return COMP_UI_M_FC_NET_PREM;
	}

	public void setCOMP_UI_M_FC_NET_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_FC_NET_PREM_LABEL) {
		this.COMP_UI_M_FC_NET_PREM_LABEL = COMP_UI_M_FC_NET_PREM_LABEL;
	}

	public void setCOMP_UI_M_FC_NET_PREM(HtmlInputText COMP_UI_M_FC_NET_PREM) {
		this.COMP_UI_M_FC_NET_PREM = COMP_UI_M_FC_NET_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_FC_AVLB_BAL_AMT_LABEL() {
		return COMP_PC_FC_AVLB_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_AVLB_BAL_AMT() {
		return COMP_PC_FC_AVLB_BAL_AMT;
	}

	public void setCOMP_PC_FC_AVLB_BAL_AMT_LABEL(
			HtmlOutputLabel COMP_PC_FC_AVLB_BAL_AMT_LABEL) {
		this.COMP_PC_FC_AVLB_BAL_AMT_LABEL = COMP_PC_FC_AVLB_BAL_AMT_LABEL;
	}

	public void setCOMP_PC_FC_AVLB_BAL_AMT(HtmlInputText COMP_PC_FC_AVLB_BAL_AMT) {
		this.COMP_PC_FC_AVLB_BAL_AMT = COMP_PC_FC_AVLB_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_PAID_FLAG_LABEL() {
		return COMP_PC_PAID_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PC_PAID_FLAG() {
		return COMP_PC_PAID_FLAG;
	}

	public void setCOMP_PC_PAID_FLAG_LABEL(
			HtmlOutputLabel COMP_PC_PAID_FLAG_LABEL) {
		this.COMP_PC_PAID_FLAG_LABEL = COMP_PC_PAID_FLAG_LABEL;
	}

	public void setCOMP_PC_PAID_FLAG(HtmlSelectOneMenu COMP_PC_PAID_FLAG) {
		this.COMP_PC_PAID_FLAG = COMP_PC_PAID_FLAG;
	}

	public HtmlOutputLabel getCOMP_PC_REF_NO_LABEL() {
		return COMP_PC_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_PC_REF_NO() {
		return COMP_PC_REF_NO;
	}

	public void setCOMP_PC_REF_NO_LABEL(HtmlOutputLabel COMP_PC_REF_NO_LABEL) {
		this.COMP_PC_REF_NO_LABEL = COMP_PC_REF_NO_LABEL;
	}

	public void setCOMP_PC_REF_NO(HtmlInputText COMP_PC_REF_NO) {
		this.COMP_PC_REF_NO = COMP_PC_REF_NO;
	}

	public HtmlOutputLabel getCOMP_PC_APPRV_DT_LABEL() {
		return COMP_PC_APPRV_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_APPRV_DT() {
		return COMP_PC_APPRV_DT;
	}

	public void setCOMP_PC_APPRV_DT_LABEL(HtmlOutputLabel COMP_PC_APPRV_DT_LABEL) {
		this.COMP_PC_APPRV_DT_LABEL = COMP_PC_APPRV_DT_LABEL;
	}

	public void setCOMP_PC_APPRV_DT(HtmlCalendar COMP_PC_APPRV_DT) {
		this.COMP_PC_APPRV_DT = COMP_PC_APPRV_DT;
	}

	public HtmlOutputLabel getCOMP_PC_PREM_HOLIDAY_YN_LABEL() {
		return COMP_PC_PREM_HOLIDAY_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PC_PREM_HOLIDAY_YN() {
		return COMP_PC_PREM_HOLIDAY_YN;
	}

	public void setCOMP_PC_PREM_HOLIDAY_YN_LABEL(
			HtmlOutputLabel COMP_PC_PREM_HOLIDAY_YN_LABEL) {
		this.COMP_PC_PREM_HOLIDAY_YN_LABEL = COMP_PC_PREM_HOLIDAY_YN_LABEL;
	}

	public void setCOMP_PC_PREM_HOLIDAY_YN(
			HtmlSelectOneMenu COMP_PC_PREM_HOLIDAY_YN) {
		this.COMP_PC_PREM_HOLIDAY_YN = COMP_PC_PREM_HOLIDAY_YN;
	}

	public HtmlOutputLabel getCOMP_PC_FC_BASIC_PREM_LABEL() {
		return COMP_PC_FC_BASIC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_BASIC_PREM() {
		return COMP_PC_FC_BASIC_PREM;
	}

	public void setCOMP_PC_FC_BASIC_PREM_LABEL(
			HtmlOutputLabel COMP_PC_FC_BASIC_PREM_LABEL) {
		this.COMP_PC_FC_BASIC_PREM_LABEL = COMP_PC_FC_BASIC_PREM_LABEL;
	}

	public void setCOMP_PC_FC_BASIC_PREM(HtmlInputText COMP_PC_FC_BASIC_PREM) {
		this.COMP_PC_FC_BASIC_PREM = COMP_PC_FC_BASIC_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_LC_BASIC_PREM_LABEL() {
		return COMP_PC_LC_BASIC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_BASIC_PREM() {
		return COMP_PC_LC_BASIC_PREM;
	}

	public void setCOMP_PC_LC_BASIC_PREM_LABEL(
			HtmlOutputLabel COMP_PC_LC_BASIC_PREM_LABEL) {
		this.COMP_PC_LC_BASIC_PREM_LABEL = COMP_PC_LC_BASIC_PREM_LABEL;
	}

	public void setCOMP_PC_LC_BASIC_PREM(HtmlInputText COMP_PC_LC_BASIC_PREM) {
		this.COMP_PC_LC_BASIC_PREM = COMP_PC_LC_BASIC_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_FC_CHARGE_AMT_LABEL() {
		return COMP_PC_FC_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_CHARGE_AMT() {
		return COMP_PC_FC_CHARGE_AMT;
	}

	public void setCOMP_PC_FC_CHARGE_AMT_LABEL(
			HtmlOutputLabel COMP_PC_FC_CHARGE_AMT_LABEL) {
		this.COMP_PC_FC_CHARGE_AMT_LABEL = COMP_PC_FC_CHARGE_AMT_LABEL;
	}

	public void setCOMP_PC_FC_CHARGE_AMT(HtmlInputText COMP_PC_FC_CHARGE_AMT) {
		this.COMP_PC_FC_CHARGE_AMT = COMP_PC_FC_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_CHARGE_AMT_LABEL() {
		return COMP_PC_LC_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_CHARGE_AMT() {
		return COMP_PC_LC_CHARGE_AMT;
	}

	public void setCOMP_PC_LC_CHARGE_AMT_LABEL(
			HtmlOutputLabel COMP_PC_LC_CHARGE_AMT_LABEL) {
		this.COMP_PC_LC_CHARGE_AMT_LABEL = COMP_PC_LC_CHARGE_AMT_LABEL;
	}

	public void setCOMP_PC_LC_CHARGE_AMT(HtmlInputText COMP_PC_LC_CHARGE_AMT) {
		this.COMP_PC_LC_CHARGE_AMT = COMP_PC_LC_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_ADDL_PREM_LABEL() {
		return COMP_PC_FC_ADDL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_ADDL_PREM() {
		return COMP_PC_FC_ADDL_PREM;
	}

	public void setCOMP_PC_FC_ADDL_PREM_LABEL(
			HtmlOutputLabel COMP_PC_FC_ADDL_PREM_LABEL) {
		this.COMP_PC_FC_ADDL_PREM_LABEL = COMP_PC_FC_ADDL_PREM_LABEL;
	}

	public void setCOMP_PC_FC_ADDL_PREM(HtmlInputText COMP_PC_FC_ADDL_PREM) {
		this.COMP_PC_FC_ADDL_PREM = COMP_PC_FC_ADDL_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_LC_ADDL_PREM_LABEL() {
		return COMP_PC_LC_ADDL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_ADDL_PREM() {
		return COMP_PC_LC_ADDL_PREM;
	}

	public void setCOMP_PC_LC_ADDL_PREM_LABEL(
			HtmlOutputLabel COMP_PC_LC_ADDL_PREM_LABEL) {
		this.COMP_PC_LC_ADDL_PREM_LABEL = COMP_PC_LC_ADDL_PREM_LABEL;
	}

	public void setCOMP_PC_LC_ADDL_PREM(HtmlInputText COMP_PC_LC_ADDL_PREM) {
		this.COMP_PC_LC_ADDL_PREM = COMP_PC_LC_ADDL_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_FC_CHARGE_LABEL() {
		return COMP_PC_FC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_CHARGE() {
		return COMP_PC_FC_CHARGE;
	}

	public void setCOMP_PC_FC_CHARGE_LABEL(
			HtmlOutputLabel COMP_PC_FC_CHARGE_LABEL) {
		this.COMP_PC_FC_CHARGE_LABEL = COMP_PC_FC_CHARGE_LABEL;
	}

	public void setCOMP_PC_FC_CHARGE(HtmlInputText COMP_PC_FC_CHARGE) {
		this.COMP_PC_FC_CHARGE = COMP_PC_FC_CHARGE;
	}

	public HtmlOutputLabel getCOMP_PC_LC_CHARGE_LABEL() {
		return COMP_PC_LC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_CHARGE() {
		return COMP_PC_LC_CHARGE;
	}

	public void setCOMP_PC_LC_CHARGE_LABEL(
			HtmlOutputLabel COMP_PC_LC_CHARGE_LABEL) {
		this.COMP_PC_LC_CHARGE_LABEL = COMP_PC_LC_CHARGE_LABEL;
	}

	public void setCOMP_PC_LC_CHARGE(HtmlInputText COMP_PC_LC_CHARGE) {
		this.COMP_PC_LC_CHARGE = COMP_PC_LC_CHARGE;
	}

	public HtmlOutputLabel getCOMP_PC_FC_LOAD_AMT_LABEL() {
		return COMP_PC_FC_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_LOAD_AMT() {
		return COMP_PC_FC_LOAD_AMT;
	}

	public void setCOMP_PC_FC_LOAD_AMT_LABEL(
			HtmlOutputLabel COMP_PC_FC_LOAD_AMT_LABEL) {
		this.COMP_PC_FC_LOAD_AMT_LABEL = COMP_PC_FC_LOAD_AMT_LABEL;
	}

	public void setCOMP_PC_FC_LOAD_AMT(HtmlInputText COMP_PC_FC_LOAD_AMT) {
		this.COMP_PC_FC_LOAD_AMT = COMP_PC_FC_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_LOAD_AMT_LABEL() {
		return COMP_PC_LC_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_LOAD_AMT() {
		return COMP_PC_LC_LOAD_AMT;
	}

	public void setCOMP_PC_LC_LOAD_AMT_LABEL(
			HtmlOutputLabel COMP_PC_LC_LOAD_AMT_LABEL) {
		this.COMP_PC_LC_LOAD_AMT_LABEL = COMP_PC_LC_LOAD_AMT_LABEL;
	}

	public void setCOMP_PC_LC_LOAD_AMT(HtmlInputText COMP_PC_LC_LOAD_AMT) {
		this.COMP_PC_LC_LOAD_AMT = COMP_PC_LC_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_DISCOUNT_LABEL() {
		return COMP_PC_FC_DISCOUNT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_DISCOUNT() {
		return COMP_PC_FC_DISCOUNT;
	}

	public void setCOMP_PC_FC_DISCOUNT_LABEL(
			HtmlOutputLabel COMP_PC_FC_DISCOUNT_LABEL) {
		this.COMP_PC_FC_DISCOUNT_LABEL = COMP_PC_FC_DISCOUNT_LABEL;
	}

	public void setCOMP_PC_FC_DISCOUNT(HtmlInputText COMP_PC_FC_DISCOUNT) {
		this.COMP_PC_FC_DISCOUNT = COMP_PC_FC_DISCOUNT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_DISCOUNT_LABEL() {
		return COMP_PC_LC_DISCOUNT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_DISCOUNT() {
		return COMP_PC_LC_DISCOUNT;
	}

	public void setCOMP_PC_LC_DISCOUNT_LABEL(
			HtmlOutputLabel COMP_PC_LC_DISCOUNT_LABEL) {
		this.COMP_PC_LC_DISCOUNT_LABEL = COMP_PC_LC_DISCOUNT_LABEL;
	}

	public void setCOMP_PC_LC_DISCOUNT(HtmlInputText COMP_PC_LC_DISCOUNT) {
		this.COMP_PC_LC_DISCOUNT = COMP_PC_LC_DISCOUNT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_GROSS_PREM_LABEL() {
		return COMP_PC_FC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_GROSS_PREM() {
		return COMP_PC_FC_GROSS_PREM;
	}

	public void setCOMP_PC_FC_GROSS_PREM_LABEL(
			HtmlOutputLabel COMP_PC_FC_GROSS_PREM_LABEL) {
		this.COMP_PC_FC_GROSS_PREM_LABEL = COMP_PC_FC_GROSS_PREM_LABEL;
	}

	public void setCOMP_PC_FC_GROSS_PREM(HtmlInputText COMP_PC_FC_GROSS_PREM) {
		this.COMP_PC_FC_GROSS_PREM = COMP_PC_FC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_LC_GROSS_PREM_LABEL() {
		return COMP_PC_LC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_GROSS_PREM() {
		return COMP_PC_LC_GROSS_PREM;
	}

	public void setCOMP_PC_LC_GROSS_PREM_LABEL(
			HtmlOutputLabel COMP_PC_LC_GROSS_PREM_LABEL) {
		this.COMP_PC_LC_GROSS_PREM_LABEL = COMP_PC_LC_GROSS_PREM_LABEL;
	}

	public void setCOMP_PC_LC_GROSS_PREM(HtmlInputText COMP_PC_LC_GROSS_PREM) {
		this.COMP_PC_LC_GROSS_PREM = COMP_PC_LC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_LOAN_INT_LABEL() {
		return COMP_UI_M_FC_LOAN_INT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_LOAN_INT() {
		return COMP_UI_M_FC_LOAN_INT;
	}

	public void setCOMP_UI_M_FC_LOAN_INT_LABEL(
			HtmlOutputLabel COMP_UI_M_FC_LOAN_INT_LABEL) {
		this.COMP_UI_M_FC_LOAN_INT_LABEL = COMP_UI_M_FC_LOAN_INT_LABEL;
	}

	public void setCOMP_UI_M_FC_LOAN_INT(HtmlInputText COMP_UI_M_FC_LOAN_INT) {
		this.COMP_UI_M_FC_LOAN_INT = COMP_UI_M_FC_LOAN_INT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_LOAN_INT_LABEL() {
		return COMP_UI_M_LC_LOAN_INT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_LOAN_INT() {
		return COMP_UI_M_LC_LOAN_INT;
	}

	public void setCOMP_UI_M_LC_LOAN_INT_LABEL(
			HtmlOutputLabel COMP_UI_M_LC_LOAN_INT_LABEL) {
		this.COMP_UI_M_LC_LOAN_INT_LABEL = COMP_UI_M_LC_LOAN_INT_LABEL;
	}

	public void setCOMP_UI_M_LC_LOAN_INT(HtmlInputText COMP_UI_M_LC_LOAN_INT) {
		this.COMP_UI_M_LC_LOAN_INT = COMP_UI_M_LC_LOAN_INT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_UNPAID_PREM_INT_LABEL() {
		return COMP_PC_FC_UNPAID_PREM_INT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_UNPAID_PREM_INT() {
		return COMP_PC_FC_UNPAID_PREM_INT;
	}

	public void setCOMP_PC_FC_UNPAID_PREM_INT_LABEL(
			HtmlOutputLabel COMP_PC_FC_UNPAID_PREM_INT_LABEL) {
		this.COMP_PC_FC_UNPAID_PREM_INT_LABEL = COMP_PC_FC_UNPAID_PREM_INT_LABEL;
	}

	public void setCOMP_PC_FC_UNPAID_PREM_INT(
			HtmlInputText COMP_PC_FC_UNPAID_PREM_INT) {
		this.COMP_PC_FC_UNPAID_PREM_INT = COMP_PC_FC_UNPAID_PREM_INT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_UNPAID_PREM_INT_LABEL() {
		return COMP_PC_LC_UNPAID_PREM_INT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_UNPAID_PREM_INT() {
		return COMP_PC_LC_UNPAID_PREM_INT;
	}

	public void setCOMP_PC_LC_UNPAID_PREM_INT_LABEL(
			HtmlOutputLabel COMP_PC_LC_UNPAID_PREM_INT_LABEL) {
		this.COMP_PC_LC_UNPAID_PREM_INT_LABEL = COMP_PC_LC_UNPAID_PREM_INT_LABEL;
	}

	public void setCOMP_PC_LC_UNPAID_PREM_INT(
			HtmlInputText COMP_PC_LC_UNPAID_PREM_INT) {
		this.COMP_PC_LC_UNPAID_PREM_INT = COMP_PC_LC_UNPAID_PREM_INT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_NET_PREM_LABEL() {
		return COMP_UI_M_LC_NET_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_NET_PREM() {
		return COMP_UI_M_LC_NET_PREM;
	}

	public void setCOMP_UI_M_LC_NET_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_LC_NET_PREM_LABEL) {
		this.COMP_UI_M_LC_NET_PREM_LABEL = COMP_UI_M_LC_NET_PREM_LABEL;
	}

	public void setCOMP_UI_M_LC_NET_PREM(HtmlInputText COMP_UI_M_LC_NET_PREM) {
		this.COMP_UI_M_LC_NET_PREM = COMP_UI_M_LC_NET_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREM_FC_TO_PAY_LABEL() {
		return COMP_UI_M_PREM_FC_TO_PAY_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PREM_FC_TO_PAY() {
		return COMP_UI_M_PREM_FC_TO_PAY;
	}

	public void setCOMP_UI_M_PREM_FC_TO_PAY_LABEL(
			HtmlOutputLabel COMP_UI_M_PREM_FC_TO_PAY_LABEL) {
		this.COMP_UI_M_PREM_FC_TO_PAY_LABEL = COMP_UI_M_PREM_FC_TO_PAY_LABEL;
	}

	public void setCOMP_UI_M_PREM_FC_TO_PAY(
			HtmlInputText COMP_UI_M_PREM_FC_TO_PAY) {
		this.COMP_UI_M_PREM_FC_TO_PAY = COMP_UI_M_PREM_FC_TO_PAY;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREM_TO_PAY_LABEL() {
		return COMP_UI_M_PREM_TO_PAY_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PREM_TO_PAY() {
		return COMP_UI_M_PREM_TO_PAY;
	}

	public void setCOMP_UI_M_PREM_TO_PAY_LABEL(
			HtmlOutputLabel COMP_UI_M_PREM_TO_PAY_LABEL) {
		this.COMP_UI_M_PREM_TO_PAY_LABEL = COMP_UI_M_PREM_TO_PAY_LABEL;
	}

	public void setCOMP_UI_M_PREM_TO_PAY(HtmlInputText COMP_UI_M_PREM_TO_PAY) {
		this.COMP_UI_M_PREM_TO_PAY = COMP_UI_M_PREM_TO_PAY;
	}

	public HtmlOutputLabel getCOMP_PC_LC_AVLB_BAL_AMT_LABEL() {
		return COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_AVLB_BAL_AMT() {
		return COMP_PC_LC_AVLB_BAL_AMT;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT_LABEL(
			HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL) {
		this.COMP_PC_LC_AVLB_BAL_AMT_LABEL = COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT(HtmlInputText COMP_PC_LC_AVLB_BAL_AMT) {
		this.COMP_PC_LC_AVLB_BAL_AMT = COMP_PC_LC_AVLB_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREM_FC_AMT_LABEL() {
		return COMP_UI_M_PREM_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PREM_FC_AMT() {
		return COMP_UI_M_PREM_FC_AMT;
	}

	public void setCOMP_UI_M_PREM_FC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_PREM_FC_AMT_LABEL) {
		this.COMP_UI_M_PREM_FC_AMT_LABEL = COMP_UI_M_PREM_FC_AMT_LABEL;
	}

	public void setCOMP_UI_M_PREM_FC_AMT(HtmlInputText COMP_UI_M_PREM_FC_AMT) {
		this.COMP_UI_M_PREM_FC_AMT = COMP_UI_M_PREM_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREM_AMT_LABEL() {
		return COMP_UI_M_PREM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PREM_AMT() {
		return COMP_UI_M_PREM_AMT;
	}

	public void setCOMP_UI_M_PREM_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_PREM_AMT_LABEL) {
		this.COMP_UI_M_PREM_AMT_LABEL = COMP_UI_M_PREM_AMT_LABEL;
	}

	public void setCOMP_UI_M_PREM_AMT(HtmlInputText COMP_UI_M_PREM_AMT) {
		this.COMP_UI_M_PREM_AMT = COMP_UI_M_PREM_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_TEMP_RCPT_NO_LABEL() {
		return COMP_PC_TEMP_RCPT_NO_LABEL;
	}

	public HtmlInputText getCOMP_PC_TEMP_RCPT_NO() {
		return COMP_PC_TEMP_RCPT_NO;
	}

	public void setCOMP_PC_TEMP_RCPT_NO_LABEL(
			HtmlOutputLabel COMP_PC_TEMP_RCPT_NO_LABEL) {
		this.COMP_PC_TEMP_RCPT_NO_LABEL = COMP_PC_TEMP_RCPT_NO_LABEL;
	}

	public void setCOMP_PC_TEMP_RCPT_NO(HtmlInputText COMP_PC_TEMP_RCPT_NO) {
		this.COMP_PC_TEMP_RCPT_NO = COMP_PC_TEMP_RCPT_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_POL_NO() {
		return COMP_UI_M_LOV_POL_NO;
	}

	public void setCOMP_UI_M_LOV_POL_NO(HtmlCommandButton COMP_UI_M_LOV_POL_NO) {
		this.COMP_UI_M_LOV_POL_NO = COMP_UI_M_LOV_POL_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REINSTATE() {
		return COMP_UI_M_BUT_REINSTATE;
	}

	public void setCOMP_UI_M_BUT_REINSTATE(
			HtmlCommandButton COMP_UI_M_BUT_REINSTATE) {
		this.COMP_UI_M_BUT_REINSTATE = COMP_UI_M_BUT_REINSTATE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_INT_DTLS() {
		return COMP_UI_M_BUT_INT_DTLS;
	}

	public void setCOMP_UI_M_BUT_INT_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_INT_DTLS) {
		this.COMP_UI_M_BUT_INT_DTLS = COMP_UI_M_BUT_INT_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CVR_DTL() {
		return COMP_UI_M_BUT_CVR_DTL;
	}

	public void setCOMP_UI_M_BUT_CVR_DTL(HtmlCommandButton COMP_UI_M_BUT_CVR_DTL) {
		this.COMP_UI_M_BUT_CVR_DTL = COMP_UI_M_BUT_CVR_DTL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BROKER_DTLS() {
		return COMP_UI_M_BUT_BROKER_DTLS;
	}

	public void setCOMP_UI_M_BUT_BROKER_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_BROKER_DTLS) {
		this.COMP_UI_M_BUT_BROKER_DTLS = COMP_UI_M_BUT_BROKER_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PYMT_DTLS() {
		return COMP_UI_M_BUT_PYMT_DTLS;
	}

	public void setCOMP_UI_M_BUT_PYMT_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS) {
		this.COMP_UI_M_BUT_PYMT_DTLS = COMP_UI_M_BUT_PYMT_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CHG_DTL() {
		return COMP_UI_M_BUT_CHG_DTL;
	}

	public void setCOMP_UI_M_BUT_CHG_DTL(HtmlCommandButton COMP_UI_M_BUT_CHG_DTL) {
		this.COMP_UI_M_BUT_CHG_DTL = COMP_UI_M_BUT_CHG_DTL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC() {
		return COMP_UI_M_BUT_FAC;
	}

	public void setCOMP_UI_M_BUT_FAC(HtmlCommandButton COMP_UI_M_BUT_FAC) {
		this.COMP_UI_M_BUT_FAC = COMP_UI_M_BUT_FAC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOAN_INT() {
		return COMP_UI_M_BUT_LOAN_INT;
	}

	public void setCOMP_UI_M_BUT_LOAN_INT(
			HtmlCommandButton COMP_UI_M_BUT_LOAN_INT) {
		this.COMP_UI_M_BUT_LOAN_INT = COMP_UI_M_BUT_LOAN_INT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public HtmlCommandButton getCOMP_UI_M_FUND_QUERY_DETAILS() {
		return COMP_UI_M_FUND_QUERY_DETAILS;
	}

	public void setCOMP_UI_M_FUND_QUERY_DETAILS(
			HtmlCommandButton COMP_UI_M_FUND_QUERY_DETAILS) {
		this.COMP_UI_M_FUND_QUERY_DETAILS = COMP_UI_M_FUND_QUERY_DETAILS;
	}

	public PT_IL_PREM_COLL getPT_IL_PREM_COLL_BEAN() {
		return PT_IL_PREM_COLL_BEAN;
	}

	public void setPT_IL_PREM_COLL_BEAN(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) {
		this.PT_IL_PREM_COLL_BEAN = PT_IL_PREM_COLL_BEAN;
	}

	public List<PT_IL_PREM_COLL> getDataList_PT_IL_PREM_COLL() {
		return dataList_PT_IL_PREM_COLL;
	}

	public void setDataListPT_IL_PREM_COLL(
			List<PT_IL_PREM_COLL> dataList_PT_IL_PREM_COLL) {
		this.dataList_PT_IL_PREM_COLL = dataList_PT_IL_PREM_COLL;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
				resetAllComponent();
				resetSelectedRow();
				PT_IL_PREM_COLL_BEAN.setRowSelected(true);
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

				new CRUDHandler().executeDelete(PT_IL_PREM_COLL_BEAN,
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
				dataList_PT_IL_PREM_COLL.remove(PT_IL_PREM_COLL_BEAN);
				if (dataList_PT_IL_PREM_COLL.size() > 0) {

					PT_IL_PREM_COLL_BEAN = dataList_PT_IL_PREM_COLL.get(0);
				} else if (dataList_PT_IL_PREM_COLL.size() == 0) {
					addRow(null);
				}
				resetAllComponent();
				PT_IL_PREM_COLL_BEAN.setRowSelected(true);
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

	/**
	 * 
	 */
	public void saveRecord() {
		String message = null;
		CommonUtils.clearMaps(this);
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"SAVE_RECORD",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public List<SelectItem> getListPC_PAID_FLAG() {
		if (listPC_PAID_FLAG.size() == 0) {
			listPC_PAID_FLAG.clear();
			try {
				Connection con = CommonUtils.getConnection();
				listPC_PAID_FLAG = new ArrayList<SelectItem>();
				listPC_PAID_FLAG = ListItemUtil.getDropDownListValue(con,
						"PILT003_APAC", "PT_IL_PREM_COLL",
						"PT_IL_PREM_COLL.PC_PAID_FLAG", "IL_PREM_STAT");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPC_PAID_FLAG;
	}

	public void setListPC_PAID_FLAG(List<SelectItem> listPC_PAID_FLAG) {
		this.listPC_PAID_FLAG = listPC_PAID_FLAG;
	}

	public List<SelectItem> getListPC_PREM_HOLIDAY_YN() {
		if (listPC_PREM_HOLIDAY_YN.size() == 0) {
			listPC_PREM_HOLIDAY_YN.clear();
			try {
				Connection con = CommonUtils.getConnection();
				listPC_PREM_HOLIDAY_YN = new ArrayList<SelectItem>();
				listPC_PREM_HOLIDAY_YN = ListItemUtil.getDropDownListValue(con,
						"PILT003_APAC", "PT_IL_PREM_COLL",
						"PT_IL_PREM_COLL.PC_PREM_HOLIDAY_YN", "YESNO");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPC_PREM_HOLIDAY_YN;
	}

	public void validatePC_PAID_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			
			if(!value.equals(PT_IL_PREM_COLL_BEAN.getPC_PAID_DT())){
				PT_IL_PREM_COLL_BEAN.setPC_PAID_DT((Date) value);
			helper.WHEN_VALIDATE_ITEM_PC_PAID_DT(PT_IL_PREM_COLL_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			
			COMP_PC_FC_UNPAID_PREM_INT.resetValue();
			COMP_PC_LC_UNPAID_PREM_INT.resetValue();
			COMP_PC_FC_AVLB_BAL_AMT.resetValue();
			COMP_UI_M_LC_NET_PREM.resetValue();
			COMP_UI_M_FC_NET_PREM.resetValue();
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_PAID_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_PAID_DT(ActionListener actionListener)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			// PT_IL_PREM_COLL_BEAN.setPC_PAID_DT((Date)value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_PAID_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_FC_BASIC_PREM(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_FC_BASIC_PREM((Double) value);
			helper.WHEN_VALIDATE_ITEM_PC_FC_BASIC_PREM(PT_IL_PREM_COLL_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_FC_BASIC_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_LC_BASIC_PREM(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_LC_BASIC_PREM((Double) value);
			helper.WHEN_VALIDATE_ITEM_PC_LC_BASIC_PREM(PT_IL_PREM_COLL_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_LC_BASIC_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_FC_ADDL_PREM(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_FC_ADDL_PREM((Double) value);
			helper.WHEN_VALIDATE_ITEM_PC_FC_ADDL_PREM(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_FC_ADDL_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_LC_ADDL_PREM(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_FC_ADDL_PREM((Double) value);
			helper.WHEN_VALIDATE_ITEM_PC_LC_ADDL_PREM(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_FC_ADDL_PREM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_FC_LOAD_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_FC_LOAD_AMT((Double) value);
			helper.WHEN_VALIDATE_ITEM_PC_FC_LOAD_AMT(PT_IL_PREM_COLL_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_FC_LOAD_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_LC_LOAD_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_LC_LOAD_AMT((Double) value);
			helper.WHEN_VALIDATE_PC_LC_LOAD_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_LC_LOAD_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateM_FC_TOT_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setUI_M_FC_TOT_AMT((Double) value);
			helper.WHEN_VALIDATE_M_FC_TOT_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_FC_TOT_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateM_LC_TOT_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setUI_M_LC_TOT_AMT((Double) value);
			helper.WHEN_VALIDATE_M_LC_TOT_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_LC_TOT_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_REF_NO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_REF_NO((String) value);
			// helper.WHEN_VALIDATE_PC_REF_NO(PT_IL_PREM_COLL_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_REF_NO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_FC_CHARGE_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_FC_CHARGE_AMT((Double) value);
			helper.WHEN_VALIDATE_PC_FC_CHARGE_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_FC_CHARGE_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_LC_CHARGE_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_LC_CHARGE_AMT((Double) value);
			helper.WHEN_VALIDATE_PC_LC_CHARGE_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_LC_CHARGE_AM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateM_FC_TOT_DUE_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setUI_M_FC_TOT_DUE_AMT((Double) value);
			helper.WHEN_VALIDATE_M_FC_TOT_DUE_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "M_FC_TOT_DUE_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateM_LC_TOT_DUE_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setUI_M_LC_TOT_DUE_AMT((Double) value);
			helper.WHEN_VALIDATE_M_LC_TOT_DUE_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "M_LC_TOT_DUE_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * public void validatePC_FC_PAID_AMT(FacesContext facesContext, UIComponent
	 * component, Object value) throws ValidatorException {
	 * CommonUtils.clearMaps(this); try {
	 * PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_AMT((Double) value);
	 * helper.WHEN_VALIDATE_PC_FC_PAID_AMT(compositeAction
	 * .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
	 * PT_IL_PREM_COLL_BEAN, compositeAction
	 * .getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
	 * COMP_PC_LC_PAID_AMT.resetValue(); } catch (Exception exception) {
	 * exception.printStackTrace(); throw new ValidatorException(new
	 * FacesMessage(exception .getMessage())); } finally { try {
	 * ErrorHelpUtil.getWarningForProcedure(CommonUtils .getConnection(),
	 * "PC_FC_PAID_AMT", getWarningMap()); } catch (Exception e) {
	 * e.printStackTrace(); } } }
	 */

	public void validatePC_LC_PAID_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_AMT((Double) value);
			helper.WHEN_VALIDATE_PC_LC_PAID_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_LC_PAID_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_PAID_FLAG(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_PAID_FLAG((String) value);
			helper.PC_PAID_FLAG_WHEN_LIST_CHANGED(PT_IL_PREM_COLL_BEAN,
					compositeAction);
			COMP_PC_WAIVE_PREM_YN.resetValue();
			COMP_PC_REF_NO.resetValue();
			/*COMP_PC_FC_UNPAID_PREM_INT.resetValue();
			COMP_PC_LC_UNPAID_PREM_INT.resetValue();
			COMP_PC_FC_PAID_AMOUNT.resetValue();
			COMP_PC_LC_PAID_AMOUNT.resetValue();*/
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_PAID_FLAG", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_UNPAID_PREM_INT_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_UNPAID_PREM_INT_CODE((String) value);
			helper.WHEN_VALIDATE_PC_UNPAID_PREM_INT_CODE(PT_IL_PREM_COLL_BEAN,
					compositeAction);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_UNPAID_PREM_INT_CODE",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_FC_UNPAID_PREM_INT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_FC_UNPAID_PREM_INT((Double) value);
			helper.WHEN_VALIDATE_PC_FC_UNPAID_PREM_INT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_FC_UNPAID_PREM_INT",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_LC_UNPAID_PREM_INT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT((Double) value);
			helper.WHEN_VALIDATE_PC_LC_UNPAID_PREM_INT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_LC_UNPAID_PREM_INT",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePC_TEMP_RCPT_NO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_TEMP_RCPT_NO((String) value);
			helper.WHEN_VALIDATE_PC_TEMP_RCPT_NO(PT_IL_PREM_COLL_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_TEMP_RCPT_NO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateM_TOT_UTL_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setUI_M_TOT_UTL_AMT((Double) value);
			helper.WHEN_VALIDATE_M_TOT_UTL_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "M_TOT_UTL_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateM_TOT_EXCESS_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setUI_M_TOT_EXCESS_AMT((Double) value);
			helper.WHEN_VALIDATE_ITEM_M_TOT_EXCESS_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "M_TOT_EXCESS_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateM_UTL_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setUI_M_UTL_AMT((Double) value);
			helper.WHEN_VALIDATE_ITEM_M_UTL_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "M_UTL_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateM_EXCESS_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setUI_M_EXCESS_AMT((Double) value);
			helper.WHEN_VALIDATE_ITEM_M_EXCESS_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "M_EXCESS_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateM_SHORT_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setUI_M_SHORT_AMT((Double) value);
			helper.WHEN_VALIDATE_ITEM_M_SHORT_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "M_SHORT_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateM_TOL_LIMIT_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setUI_M_TOL_LIMIT_AMT((Double) value);
			helper.WHEN_VALIDATE_ITEM_M_TOL_LIMIT_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "M_TOL_LIMIT_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<LovBean> lovAction(Object value) {
		ListItemUtil listItemUtil = null;
		try {
			listItemUtil = new ListItemUtil();
			list = listItemUtil.P_CALL_LOV("PILT003_APAC", "PT_IL_POLICY",
					"POL_NO", "A", null, null, null, null, (String) value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("prepareLovCommCode", e.getMessage());
		}
		return list;
	}

	public List suggestionList(String query) {

		Statement stmt = null;
		List list = new ArrayList();
		ResultSet rs;
		try {

			Connection con = CommonUtils.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				PT_IL_POLICY_LOV lovBox = new PT_IL_POLICY_LOV();
				lovBox.setPOL_NO(rs.getString("POL_NO"));
				lovBox.setPOL_ISSUE_DT(rs.getString("POL_ISSUE_DT"));
				list.add(lovBox);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param event
	 */
	public void postRecord(ActionEvent actionEvent) {
		try {

			validateComponentItems();
			//helper.validateOnClaimregister(PT_IL_PREM_COLL_BEAN);
			if (PT_IL_PREM_COLL_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PT_IL_PREM_COLL_BEAN,
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
								"errorPanel$message$insert"));
				dataList_PT_IL_PREM_COLL.add(PT_IL_PREM_COLL_BEAN);
			} else if (PT_IL_PREM_COLL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PT_IL_PREM_COLL_BEAN);
				helper.whenNewRecordInstance(compositeAction);
				new CRUDHandler().executeUpdate(PT_IL_PREM_COLL_BEAN,
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
			/*Added by Sivarajan on 21-03-2019 for KIC Ajoy sugg.*/
			COMP_PC_FC_PAID_AMOUNT.setDisabled(true);
			COMP_PC_LC_PAID_AMOUNT.setDisabled(true);
			/*End*/
			PT_IL_PREM_COLL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}
	

	public void validateComponentItems() throws Exception {
		try {
			if ("N".equals(PT_IL_PREM_COLL_BEAN.getPC_PREM_HOLIDAY_YN())) {
				if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() == null) {
					throw new Exception("Paid Date: Value is required");// FP_910088
				}
			}
		} catch (Exception exception) {
			throw exception;
		}
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPC_UNPAID_PREM_INT_CODE(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT003_APAC",
					"PT_IL_PREM_COLL", "PC_UNPAID_PREM_INT_CODE", "IL_PRM_INT",
					null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	// P_CALL_LOV('PT_IL_PREM_COLL.PC_UNPAID_PREM_INT_CODE',
	// 'IL_PRM_INT');

	/*
	 * public void onLoad(PhaseEvent event){
	 * this.getCOMP_PC_FC_UNPAID_PREM_INT().setDisabled(true);
	 * this.getCOMP_PC_LC_UNPAID_PREM_INT().setDisabled(true); String
	 * buttonClickValid = CommonUtils.getGlobalVariable("ButtonClickValid"); try {
	 * if (isFormFlag()) { helper.PRE_FORM(compositeAction,
	 * compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
	 * setFormFlag(false); } if (isBlockFlag()) {
	 * helper.executeQuery(compositeAction);
	 * helper.post_query(PT_IL_PREM_COLL_BEAN,
	 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
	 * compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(), compositeAction); }
	 * if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO() !=
	 * null && "Y".equalsIgnoreCase(buttonClickValid)){
	 * helper.executeQuery(compositeAction);
	 * helper.WHEN_NEW_RECORD_INSTANCE(PT_IL_PREM_COLL_BEAN,
	 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
	 * compositeAction,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
	 * CommonUtils.setGlobalVariable("ButtonClickValid", "N"); }
	 * setBlockFlag(false); } catch (Exception e) {
	 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * e.getMessage()); getErrorMap().put("onLoad", e.getMessage()); } }
	 */

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				helper.PRE_FORM(compositeAction, compositeAction
						.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());

				setFormFlag(false);
			}
			if (isBlockFlag()) {

				helper.whenNewBlockInstance();
				helper.executeQuery(compositeAction);
				/*
				 * commented By Dhinesh on 09-10-2017
				 * 
				 * helper.onPopulateDetails(compositeAction);
				 * 
				 * 
				 */
				// helper.postQuery(compositeAction);
				helper.whenNewRecordInstance(compositeAction);

				String pdflg = chkFlag(PT_IL_PREM_COLL_BEAN);

				/*Modified by saritha on 23-Jan-2018 System should not allow to reverse the allocation(Premium collection screen) 
				 * even when policy not in Force (Death claim,Cancelled,Lapse,Surrender,Matured,Paid up)*/

				boolean checkPolStatusApproved = compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getchequeBounceYN_Enable();

				/*if (pdflg.equalsIgnoreCase("A")) {*/
				if (pdflg.equalsIgnoreCase("A") && checkPolStatusApproved && PT_IL_PREM_COLL_BEAN.getPC_SCHD_PYMT_DT().equals(fetchLastPaymentDate(PT_IL_PREM_COLL_BEAN))) {

					getCOMP_PC_FLEX_01().setDisabled(false);

				} else {
					getCOMP_PC_FLEX_01().setDisabled(true);
				}
                
				/*End*/

			}
			if ("PILQ002".equals(CommonUtils.getGlobalVariable("CALLING_FORM"))) {
				disablebutton();
			}
			/*String pdflg = chkFlag(PT_IL_PREM_COLL_BEAN);
			if (pdflg.equalsIgnoreCase("A")) {
				COMP_PC_FLEX_01.setDisabled(false);
			} else {
				COMP_PC_FLEX_01.setDisabled(true);
			}*/

			setBlockFlag(false);

			/*Commented by Sivarajan on 21-03-2019 for KIC Ajoy Sugg.*/
			/*
						Newly Added By Dhinesh on 18-06-2018 for KIC Issue
						if("A".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG()))
						{
							COMP_PC_FC_PAID_AMOUNT.setDisabled(true);
						}else
						{
							COMP_PC_FC_PAID_AMOUNT.setDisabled(false);
						}
						End*/
						COMP_PC_FC_PAID_AMOUNT.setDisabled(true);
			/*
			 * 
			 * COMMENTED BY DHINESH ON 15-06-2018 FOR KIC 
			 * 
			 * COMP_PC_FC_PAID_AMOUNT.setDisabled(false);*/

			COMP_PC_LC_PAID_AMOUNT.setDisabled(true);
			if(helper.validateOnClaimregister(PT_IL_PREM_COLL_BEAN) == true){
				disableAllComponent(true);
				COMP_ADD_BUT.setDisabled(true);
			}



		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	private HtmlAjaxCommandButton COMP_ADD_BUT;

	public void disablebutton() {
		COMP_UI_M_BUT_REINSTATE.setDisabled(true);
		COMP_UI_M_BUT_CVR_DTL.setDisabled(true);
		COMP_UI_M_BUT_BROKER_DTLS.setDisabled(true);
		COMP_UI_M_BUT_PYMT_DTLS.setDisabled(true);
		COMP_UI_M_BUT_CHG_DTL.setDisabled(true);
		COMP_UI_M_BUT_FAC.setDisabled(true);
		COMP_UI_M_BUT_LOAN_INT.setDisabled(true);
		COMP_UI_M_BUT_APPROVE.setDisabled(true);
		COMP_UI_M_FUND_QUERY_DETAILS.setDisabled(true);
		COMP_ADD_BUT.setDisabled(true);
		COMP_PC_FC_PAID_AMOUNT.setDisabled(true);
		COMP_PC_LC_PAID_AMOUNT.setDisabled(true);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_NO()
				.setDisabled(true);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_QUERY()
				.setDisabled(true);
	}

	/**
	 * Instantiates all components in PT_IL_PREM_COLL_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_UI_M_FC_NET_PREM = new HtmlInputText();
		COMP_PC_FC_AVLB_BAL_AMT = new HtmlInputText();
		COMP_POL_NO = new HtmlInputText();

		COMP_PC_REF_NO = new HtmlInputText();
		COMP_PC_FC_BASIC_PREM = new HtmlInputText();
		COMP_PC_LC_BASIC_PREM = new HtmlInputText();
		COMP_PC_FC_CHARGE_AMT = new HtmlInputText();
		COMP_PC_LC_CHARGE_AMT = new HtmlInputText();
		COMP_PC_FC_ADDL_PREM = new HtmlInputText();
		COMP_PC_LC_ADDL_PREM = new HtmlInputText();
		COMP_PC_FC_CHARGE = new HtmlInputText();
		COMP_PC_LC_CHARGE = new HtmlInputText();
		COMP_PC_FC_LOAD_AMT = new HtmlInputText();
		COMP_PC_LC_LOAD_AMT = new HtmlInputText();
		COMP_PC_FC_DISCOUNT = new HtmlInputText();
		COMP_PC_LC_DISCOUNT = new HtmlInputText();
		COMP_PC_FC_GROSS_PREM = new HtmlInputText();
		COMP_PC_LC_GROSS_PREM = new HtmlInputText();
		COMP_UI_M_FC_LOAN_INT = new HtmlInputText();
		COMP_UI_M_LC_LOAN_INT = new HtmlInputText();
		COMP_PC_FC_UNPAID_PREM_INT = new HtmlInputText();
		COMP_PC_LC_UNPAID_PREM_INT = new HtmlInputText();
		COMP_UI_M_LC_NET_PREM = new HtmlInputText();
		COMP_UI_M_PREM_FC_TO_PAY = new HtmlInputText();
		COMP_UI_M_PREM_TO_PAY = new HtmlInputText();
		COMP_PC_LC_AVLB_BAL_AMT = new HtmlInputText();
		COMP_UI_M_PREM_FC_AMT = new HtmlInputText();
		COMP_UI_M_PREM_AMT = new HtmlInputText();
		COMP_PC_TEMP_RCPT_NO = new HtmlInputText();
		COMP_PC_FC_PAID_AMOUNT = new HtmlInputText();
		COMP_PC_LC_PAID_AMOUNT = new HtmlInputText();
		/* Newly Added By Dhinesh on 23-06-2017 for ssp call id : ZBILQC-1727457 */
		COMP_PC_DEP_REF_DOC_NO = new HtmlInputText();
		/*End*/

		// Instantiating HtmlSelectOneMenu
		COMP_PC_PAID_FLAG = new HtmlSelectOneMenu();
		COMP_PC_PREM_HOLIDAY_YN = new HtmlSelectOneMenu();
		COMP_PC_WAIVE_PREM_YN = new HtmlSelectOneMenu();
		COMP_PC_FLEX_01 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_PC_SCHD_PYMT_DT = new HtmlCalendar();
		COMP_PC_PAID_DT = new HtmlCalendar();
		COMP_PC_APPRV_DT = new HtmlCalendar();
		
		/* Newly Added By Dhinesh on 23-06-2017 for ssp call id : ZBILQC-1727457 */
		COMP_PC_DEP_REF_DOC_DT = new HtmlCalendar();
		/* End */
		
		// Instantiating HtmlCommandButton
		COMP_UI_M_LOV_POL_NO = new HtmlCommandButton();
		COMP_UI_M_BUT_REINSTATE = new HtmlCommandButton();
		COMP_UI_M_BUT_INT_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_CVR_DTL = new HtmlCommandButton();
		COMP_UI_M_BUT_BROKER_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_PYMT_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_CHG_DTL = new HtmlCommandButton();
		COMP_UI_M_BUT_FAC = new HtmlCommandButton();
		COMP_UI_M_BUT_LOAN_INT = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVE = new HtmlCommandButton();
		COMP_UI_M_FUND_QUERY_DETAILS = new HtmlCommandButton();
		COMP_REV= new HtmlCommandButton();
		
		/*Added by Ram on 03/04/2017 for initializing component*/
		COMP_BANK_CODE = new HtmlInputText();
		/*End*/
		
		/*Added by saritha on 26-10-2017 for ssp call id ZBLIFE-1449091*/
		COMP_UI_M_TOTAL_PREM_PAID_LABEL = new HtmlOutputLabel();
		COMP_UI_M_TOTAL_PREM_PAID       = new HtmlInputText();
		/*End*/

	}

	public String CheckPaidFlag(PILT003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		String C1 = "select pc_paid_flag from pt_il_prem_coll where pc_pol_sys_id=(select pol_sys_id from pt_il_policy where pol_no like ?)";
		String paidflg = null;
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = null;
		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_NO() });
			while (rs.next()) {
				paidflg = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(rs);
		}
		return paidflg;
	}

	public String chkFlag(PT_IL_PREM_COLL collBean) throws Exception {
		String C1 = "select pc_paid_flag from pt_il_prem_coll where pc_sys_id = ? ";
		String paidflg = null;
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = null;
		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { collBean.getPC_SYS_ID() });
			if (rs.next()) {
				paidflg = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(rs);
		}
		return paidflg;
	}

	
	public void setListPC_PREM_HOLIDAY_YN(
			List<SelectItem> listPC_PREM_HOLIDAY_YN) {
		this.listPC_PREM_HOLIDAY_YN = listPC_PREM_HOLIDAY_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	
	
	
	public void fireFieldValidation_status(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		
		/*Added by Ram on 03/04/2017 for clearing the fields*/
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getDataList_PT_IL_PREM_COLL().clear();
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().setPT_IL_PREM_COLL_BEAN(new PT_IL_PREM_COLL());
		resetAllComponent();
		/*End*/
	}
	
	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public PT_IL_POLICY_HELPER getPolicyHelper() {
		return policyHelper;
	}

	public void setPolicyHelper(PT_IL_POLICY_HELPER policyHelper) {
		this.policyHelper = policyHelper;
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);

		try {
			resetSelectedRow();
			PT_IL_PREM_COLL_BEAN = (PT_IL_PREM_COLL) dataTable.getRowData();
			helper.whenNewRecordInstance(compositeAction);// This is to enable
			// for the buttons
			// to show.
			PT_IL_PREM_COLL_BEAN.setRowSelected(true);
			resetAllComponent();

			if ("PILQ002".equals(CommonUtils.getGlobalVariable("CALLING_FORM"))) {
				disablebutton();
			}

			String pdflg = chkFlag(PT_IL_PREM_COLL_BEAN);
			
			/*Modified by saritha on 23-Jan-2018 System should not allow to reverse the allocation(Premium collection screen) 
			 * even when policy not in Force (Death claim,Cancelled,Lapse,Surrender,Matured,Paid up)*/
			
			boolean checkPolStatusApproved = compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getchequeBounceYN_Enable();
			if (pdflg.equalsIgnoreCase("A") && checkPolStatusApproved && PT_IL_PREM_COLL_BEAN.getPC_SCHD_PYMT_DT().equals(fetchLastPaymentDate(PT_IL_PREM_COLL_BEAN))) {

				//COMP_PC_FLEX_01.setDisabled(false);
				
				getCOMP_PC_FLEX_01().setDisabled(false);

			} else {
				getCOMP_PC_FLEX_01().setDisabled(true);
			}

			/*End*/
			
			String PC_PAID_FLAG =PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG();
			System.out.println("PC_PAID_FLAG    :::::"+PC_PAID_FLAG);

			if(PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG().equalsIgnoreCase("A"))
			{
				System.out.println("inside if");
				COMP_UI_PRINT_BUTTON.setDisabled(false);
			}
			else 
			{
				COMP_UI_PRINT_BUTTON.setDisabled(true);
			}

			/*Added by Ram on 03/04/2017 for disable status field by Condition based*/
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().disableFunctionality();
			/*End*/

			/*Added by Ameen on 18-05-2017 as per Ajoy sugg. to disable all fields when selected pol_type = H*/
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().hopitalPlanType();
			/*End*/

			/* Newly Added By Dhinesh on 15-06-2018 */
			/*commeted by Sivarajan on 20-03-2019 for KIC ajoy suggestion*/
			/*if("A".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG()))
			{
				COMP_PC_FC_PAID_AMOUNT.setDisabled(true);
			}else
			{
				COMP_PC_FC_PAID_AMOUNT.setDisabled(false);
			}*/
			COMP_PC_FC_PAID_AMOUNT.setDisabled(true);
			COMP_PC_LC_PAID_AMOUNT.setDisabled(true);
			/* End */
			
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_PREM_COLL> PT_IL_PREM_COLL_ITR = dataList_PT_IL_PREM_COLL
				.iterator();
		while (PT_IL_PREM_COLL_ITR.hasNext()) {
			PT_IL_PREM_COLL_ITR.next().setRowSelected(false);
		}
	}

	/**
	 * Resets all components in PT_IL_PREM_COLL_ACTION
	 */
	public void resetAllComponent() {
		// Reseting HtmlInputText
		/*Added by Ram on 08/02/2017 for BankCode field capturing*/
		COMP_BANK_CODE.resetValue();
		/*End*/
		COMP_UI_M_FC_NET_PREM.resetValue();
		COMP_PC_FC_AVLB_BAL_AMT.resetValue();
		COMP_PC_FLEX_01.resetValue();
		COMP_PC_REF_NO.resetValue();
		COMP_PC_FC_BASIC_PREM.resetValue();
		COMP_PC_LC_BASIC_PREM.resetValue();
		COMP_PC_FC_CHARGE_AMT.resetValue();
		COMP_PC_LC_CHARGE_AMT.resetValue();
		COMP_PC_FC_ADDL_PREM.resetValue();
		COMP_PC_LC_ADDL_PREM.resetValue();
		COMP_PC_FC_CHARGE.resetValue();
		COMP_PC_LC_CHARGE.resetValue();
		COMP_PC_FC_LOAD_AMT.resetValue();
		COMP_PC_LC_LOAD_AMT.resetValue();
		COMP_PC_FC_DISCOUNT.resetValue();
		COMP_PC_LC_DISCOUNT.resetValue();
		COMP_PC_FC_GROSS_PREM.resetValue();
		COMP_PC_LC_GROSS_PREM.resetValue();
		COMP_UI_M_FC_LOAN_INT.resetValue();
		COMP_UI_M_LC_LOAN_INT.resetValue();
		COMP_PC_FC_UNPAID_PREM_INT.resetValue();
		COMP_PC_LC_UNPAID_PREM_INT.resetValue();
		COMP_UI_M_LC_NET_PREM.resetValue();
		COMP_UI_M_PREM_FC_TO_PAY.resetValue();
		COMP_UI_M_PREM_TO_PAY.resetValue();
		COMP_PC_LC_AVLB_BAL_AMT.resetValue();
		COMP_UI_M_PREM_FC_AMT.resetValue();
		COMP_UI_M_PREM_AMT.resetValue();
		COMP_PC_TEMP_RCPT_NO.resetValue();
		COMP_PC_FC_PAID_AMOUNT.resetValue();
		COMP_PC_LC_PAID_AMOUNT.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_PC_PAID_FLAG.resetValue();
		COMP_PC_PREM_HOLIDAY_YN.resetValue();
		COMP_PC_WAIVE_PREM_YN.resetValue();
		// Reseting HtmlCalendar
		COMP_PC_SCHD_PYMT_DT.resetValue();
		COMP_PC_PAID_DT.resetValue();
		COMP_PC_APPRV_DT.resetValue();
		
		/*Added by Ram on 08/02/2017 for BankCode field capturing*/
		COMP_BANK_CODE.resetValue();
		/*End*/
		
		/*Added by saritha on 26-10-2017 for ssp call id ZBLIFE-1449091*/
		COMP_UI_M_TOTAL_PREM_PAID.resetValue();
		/*End*/

	}
	
	/*Added by Ram on 08/02/2017 for BankCode field capturing*/
	private HtmlOutputLabel COMP_BANK_CODE_LABEL;
	private HtmlInputText COMP_BANK_CODE;
	private HtmlInputText COMP_BANK_CODE_DESC;
	
	public HtmlOutputLabel getCOMP_BANK_CODE_LABEL() {
		return COMP_BANK_CODE_LABEL;
	}

	public void setCOMP_BANK_CODE_LABEL(HtmlOutputLabel cOMP_BANK_CODE_LABEL) {
		COMP_BANK_CODE_LABEL = cOMP_BANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BANK_CODE() {
		return COMP_BANK_CODE;
	}

	public void setCOMP_BANK_CODE(HtmlInputText cOMP_BANK_CODE) {
		COMP_BANK_CODE = cOMP_BANK_CODE;
	}
	
	public HtmlInputText getCOMP_BANK_CODE_DESC() {
		return COMP_BANK_CODE_DESC;
	}

	public void setCOMP_BANK_CODE_DESC(HtmlInputText cOMP_BANK_CODE_DESC) {
		COMP_BANK_CODE_DESC = cOMP_BANK_CODE_DESC;
	}

	public void validateBankCode(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		System.out.println("value        "+value);
		if(value != null)
		{
			PT_IL_PREM_COLL_BEAN.setBANK_CODE((String)value);	
		}
		
	}

	public String coverBtnAction() {
		return "PILT003_APAC_PT_IL_PREM_COLL_CVR_DTL";

	}

	public String paymentDetailsAction() {
		try {
			helper.WHEN_BTN_PRESSED_PYMT_DETAILS(PT_IL_PREM_COLL_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
			/*Added by Ram on 05/03/2017 for DepRefId is null issue*/
			PT_IL_PREM_COLL_BEAN.setOLD_PC_FC_PAID_AMT(PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT());
			/*End*/
			CommonUtils.setGlobalObject("G_PC_SYS_ID",PT_IL_PREM_COLL_BEAN.getPC_SYS_ID());
			CommonUtils.setGlobalObject("G_PC_NET_PREM_FC",PT_IL_PREM_COLL_BEAN.getUI_M_FC_NET_PREM());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("paymentDetails", e.getMessage());
		}
		CommonUtils.setGlobalVariable("CALLING_FORM", "PILT003_APAC");
		return "PILT017_PAYMENTDETAILS";
	}

	public String chargesButtonAction() {
		try {
			new PT_IL_PREM_COLL_CHARGE_HELPER().executeQuery(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("charges", e.getMessage());
		}
		return "PILT003_APAC_PT_IL_PREM_COLL_CHARGE";
	}

	public String facoutBtnAction() {
		String outcome = null;
		try {
			helper.WHEN_BTN_PRESSED_M_BUT_FAC(compositeAction);
			outcome = "gotoFacOut";
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILT003");
		} catch (Exception e) {
			outcome = "";
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("facout", e.getMessage());
		}
		return outcome;
	}

	public String brokerDetailsAction() {
		if ("1".equals(CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN().getUI_M_IL_BROK_CALC(), "2"))) {
			return "PILT003_APAC_PT_IL_BROKER_VALUES";
		} else {
			return "PILT003_APAC_PT_AGENT_COMM_VALUES";
		}
	}

	public String loanDetailsBtnAction() {
		return "PILT003_APAC_PT_IL_LOAN_INT_COLL";
	}

	public String fundQueryAction() {
		try {
			helper.WHEN_BTN_PRESSED_M_FUND_QUERY_DETAILS(PT_IL_PREM_COLL_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILT003_APAC");
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("fundQuery", e.getMessage());
		}
		return "PILQ106_APAC";
	}

	/*
	 * public String pymtBtnAction() {
	 * com.iii.pel.forms.PILT017.PT_IL_PYMT_DTLS_ACTION paymentAction = null;
	 * PT_IL_POLICY policyBean =
	 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	 * 
	 * String returnValue = null;
	 * 
	 * 
	 * 
	 * PT_IL_PREM_COLL valueBean = getPT_IL_PREM_COLL_BEAN();
	 * 
	 * 
	 * Double PC_FC_PAID_AMT = (valueBean.getPC_FC_PAID_AMT() == null) ? 0.0 :
	 * valueBean.getPC_FC_PAID_AMT(); Double PC_LC_PAID_AMT =
	 * (valueBean.getPC_LC_PAID_AMT() == null) ? 0.0 :
	 * valueBean.getPC_LC_PAID_AMT(); String PC_PAID_FLAG =
	 * (valueBean.getPC_PAID_FLAG() == null) ? "N" :
	 * valueBean.getPC_PAID_FLAG(); Long PC_SYS_ID = valueBean.getPC_SYS_ID();
	 * 
	 * Double POL_CUST_EXCH_RATE = 0.0; Double M_LC_DEP_AVAI_AMT = 0.0; Long
	 * TXN_SYS_ID;
	 * 
	 * Map sessMap = sessionMap(); Date approveDateAssign =
	 * getApproveDateAssign(); valueBean.setPC_APPRV_DT(approveDateAssign);
	 * sessMap.put("PT_IL_PREM_COLL_SELECTED", valueBean);
	 * 
	 * try { DBProcedures procedures = new DBProcedures(); procedures
	 * .helperP9ILPK_PREM_COLL_P_CHECK_REN_RECALC( valueBean.getPC_POL_SYS_ID(),
	 * valueBean.getPC_SYS_ID()); Connection con = CommonUtils.getConnection(); //
	 * senthil-changes1.2 String query1 = "select POL_SYS_ID, POL_NO,
	 * POL_CUST_EXCH_RATE from PT_IL_POLICY WHERE POL_NO=?"; PreparedStatement
	 * psmt = con .prepareStatement(query1); psmt.setString(1, (String)
	 * COMP_POL_NO.getValue()); ResultSet rs = psmt.executeQuery(); String
	 * POL_SYS_ID = null; while (rs.next()) { POL_SYS_ID =
	 * rs.getString("POL_SYS_ID"); POL_CUST_EXCH_RATE = rs
	 * .getDouble("POL_CUST_EXCH_RATE"); }
	 * 
	 * String cursorC1 = "SELECT MIN(PC_SYS_ID) AS SYSID,SUM(PC_FC_PAID_AMT) AS
	 * PC_FC_PAID_AMT,SUM(PC_LC_PAID_AMT) AS PC_LC_PAID_AMT FROM PT_IL_PREM_COLL
	 * WHERE PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG,'N') = 'Y' AND PC_PAID_DT IS
	 * NOT NULL"; // TXN_SYS_ID = PC_SYS_ID; if (PC_PAID_FLAG.equals("A")) {
	 * TXN_SYS_ID = new Long(PC_SYS_ID); } else { psmt =
	 * con.prepareStatement(cursorC1); psmt.setString(1, POL_SYS_ID); rs =
	 * psmt.executeQuery(); while (rs.next()) { TXN_SYS_ID = new
	 * Long(rs.getInt(1)); } }
	 * 
	 * ArrayList<OracleParameter> pList1 = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> oList1 = new ArrayList<OracleParameter>();
	 * OracleParameter p1 = new OracleParameter("IN1", "STRING", "IN",
	 * POL_SYS_ID); pList1.add(p1); OracleParameter p2 = new
	 * OracleParameter("IN2", "STRING", "OUT", ""); pList1.add(p2);
	 * OracleProcedureHandler pHandler1 = new OracleProcedureHandler(); oList1 =
	 * pHandler1 .execute(pList1, con,
	 * "P9ILPK_CHEQ_VALIDATION.GET_AVAILABLE_DEPOSIT"); for (Iterator iterator2 =
	 * oList1.iterator(); iterator2 .hasNext();) { OracleParameter name =
	 * (OracleParameter) iterator2 .next(); if
	 * (name.getFieldName().equals("IN2")) { if ("".equals(name.getValue()) ||
	 * name.getValue() == null) { M_LC_DEP_AVAI_AMT = 0.0; } else {
	 * M_LC_DEP_AVAI_AMT = Double.valueOf(name .getValue()); } } }
	 * 
	 * ArrayList<OracleParameter> pList11 = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> oList11 = new ArrayList<OracleParameter>();
	 * OracleParameter p11 = new OracleParameter("IN1", "STRING", "IN",
	 * Long.toString(PC_SYS_ID)); pList11.add(p11); OracleParameter p21 = new
	 * OracleParameter("IN2", "STRING", "IN", String
	 * .valueOf(M_LC_DEP_AVAI_AMT)); pList11.add(p21); OracleParameter p31 = new
	 * OracleParameter("IN3", "STRING", "IN", "0"); pList11.add(p31);
	 * OracleParameter p41 = new OracleParameter("IN4", "STRING", "IN", "D");
	 * pList11.add(p41); OracleParameter p51 = new OracleParameter("IN5",
	 * "STRING", "IN", "D"); pList11.add(p51); OracleParameter p61 = new
	 * OracleParameter("IN6", "STRING", "IN", String
	 * .valueOf(POL_CUST_EXCH_RATE)); pList11.add(p61);
	 * 
	 * OracleProcedureHandler pHandler11 = new OracleProcedureHandler(); //
	 * oList11 = pHandler1.execute(pList11, //
	 * con,"P9ILPK_CHEQ_VALIDATION.P_INS_DEFAULT_PYMT");
	 * 
	 * String outcome = "PILT003_APAC_PT_IL_PREM_COLL"; // PC_SYS_ID// String
	 * txnType = "PC"; String curr_code = policyBean.getPOL_CUST_CURR_CODE();
	 * Double FC_AMT = PC_FC_PAID_AMT; Double LC_AMT = PC_FC_PAID_AMT;
	 * 
	 * com.iii.pel.forms.PILT017.PT_IL_PYMT_DTLS pymtDtls = new
	 * PT_IL_PYMT_DTLS(); pymtDtls.setPD_TXN_TYPE(txnType); // Commented to
	 * avoid compilation error, Dated: 15-Feb, Commented by: Manoj
	 * pymtDtls.setPD_TXN_SYS_ID(TXN_SYS_ID); pymtDtls.setPD_FC_AMT(FC_AMT);
	 * pymtDtls.setPD_LC_AMT(LC_AMT);
	 * 
	 * Map<String, Object> session1 = FacesContext
	 * .getCurrentInstance().getExternalContext() .getSessionMap();
	 * session1.put("GLOBAL.TXN_TYPE", txnType);
	 * session1.put("GLOBAL.TXN_SYS_ID", TXN_SYS_ID);
	 * session1.put("GLOBAL.CURR_CODE", curr_code);
	 * session1.put("GLOBAL.FC_AMT", FC_AMT); session1.put("GLOBAL.LC_AMT",
	 * LC_AMT); session1.put("GLOBAL.EXCH_RATE", POL_CUST_EXCH_RATE);
	 * 
	 * paymentAction = new com.iii.pel.forms.PILT017.PT_IL_PYMT_DTLS_ACTION(
	 * outcome, pymtDtls, false); returnValue =
	 * paymentAction.gotoPaymentDetails(); } catch (SQLException exception) { }
	 * catch (Exception ex) { ex.printStackTrace(); } finally { try {
	 * ErrorHelpUtil .getErrorsAndWarningsforProcedureAction(
	 * CommonUtils.getConnection(), FacesContext .getCurrentInstance(), "",
	 * getErrorMap(), getWarningMap()); } catch (DBException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } } return returnValue; }
	 */

	private Date getApproveDateAssign() {
		Date date = null;
		Connection con = null;
		String sysdate = "SELECT SYSDATE FROM DUAL";
		CRUDHandler handler = new CRUDHandler();
		try {
			con = CommonUtils.getConnection();
			ResultSet rs = handler.executeSelectStatement(sysdate, con);
			while (rs.next()) {
				date = rs.getDate("SYSDATE");
			}
			rs.close();
			// con.close();

		} catch (Exception e) {
		}

		return date;
	}

	private Map sessionMap() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = context.getExternalContext()
				.getSessionMap();
		return sessionMap;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO(HtmlInputText comp_pol_no) {
		COMP_POL_NO = comp_pol_no;
	}

	/* Modified for functionality of PILT003_APAC - PREMIA-GDC-1153441 */
	public String apprBtnAction() throws Exception {
		String outCome = null;
		try {
			outCome = helper.apprBtnAction(compositeAction);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("APPROVE BUTTON ACTION", e.getMessage());

		}
		return outCome;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_OUTSTD_AMT_LABEL() {
		return COMP_UI_M_PC_FC_OUTSTD_AMT_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_OUTSTD_AMT_LABEL(
			HtmlOutputLabel comp_ui_m_pc_fc_outstd_amt_label) {
		COMP_UI_M_PC_FC_OUTSTD_AMT_LABEL = comp_ui_m_pc_fc_outstd_amt_label;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_OUTSTD_AMT() {
		return COMP_UI_M_PC_FC_OUTSTD_AMT;
	}

	public void setCOMP_UI_M_PC_FC_OUTSTD_AMT(
			HtmlInputText comp_ui_m_pc_fc_outstd_amt) {
		COMP_UI_M_PC_FC_OUTSTD_AMT = comp_ui_m_pc_fc_outstd_amt;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_OUTSTD_AMT_LABEL() {
		return COMP_UI_M_PC_LC_OUTSTD_AMT_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_OUTSTD_AMT_LABEL(
			HtmlOutputLabel comp_ui_m_pc_lc_outstd_amt_label) {
		COMP_UI_M_PC_LC_OUTSTD_AMT_LABEL = comp_ui_m_pc_lc_outstd_amt_label;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_OUTSTD_AMT() {
		return COMP_UI_M_PC_LC_OUTSTD_AMT;
	}

	public void setCOMP_UI_M_PC_LC_OUTSTD_AMT(
			HtmlInputText comp_ui_m_pc_lc_outstd_amt) {
		COMP_UI_M_PC_LC_OUTSTD_AMT = comp_ui_m_pc_lc_outstd_amt;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_OUTSTD_AMT_1() {
		return COMP_UI_M_PC_FC_OUTSTD_AMT_1;
	}

	public void setCOMP_UI_M_PC_FC_OUTSTD_AMT_1(
			HtmlInputText comp_ui_m_pc_fc_outstd_amt_1) {
		COMP_UI_M_PC_FC_OUTSTD_AMT_1 = comp_ui_m_pc_fc_outstd_amt_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_OUTSTD_AMT_1_LABEL() {
		return COMP_UI_M_PC_LC_OUTSTD_AMT_1_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_OUTSTD_AMT_1_LABEL(
			HtmlOutputLabel comp_ui_m_pc_lc_outstd_amt_1_label) {
		COMP_UI_M_PC_LC_OUTSTD_AMT_1_LABEL = comp_ui_m_pc_lc_outstd_amt_1_label;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_OUTSTD_AMT_1() {
		return COMP_UI_M_PC_LC_OUTSTD_AMT_1;
	}

	public void setCOMP_UI_M_PC_LC_OUTSTD_AMT_1(
			HtmlInputText comp_ui_m_pc_lc_outstd_amt_1) {
		COMP_UI_M_PC_LC_OUTSTD_AMT_1 = comp_ui_m_pc_lc_outstd_amt_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_OUTSTD_AMT_1_LABEL() {
		return COMP_UI_M_PC_FC_OUTSTD_AMT_1_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_OUTSTD_AMT_1_LABEL(
			HtmlOutputLabel comp_ui_m_pc_fc_outstd_amt_1_label) {
		COMP_UI_M_PC_FC_OUTSTD_AMT_1_LABEL = comp_ui_m_pc_fc_outstd_amt_1_label;
	}

	/**
	 * Disables all components in PT_IL_PREM_COLL_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_UI_M_FC_NET_PREM.setDisabled(disabled);
		COMP_UI_M_PC_FC_OUTSTD_AMT.setDisabled(disabled);
		COMP_UI_M_PC_LC_OUTSTD_AMT.setDisabled(disabled);
		COMP_UI_M_PC_FC_OUTSTD_AMT_1.setDisabled(disabled);
		COMP_UI_M_PC_LC_OUTSTD_AMT_1.setDisabled(disabled);
		COMP_PC_FC_AVLB_BAL_AMT.setDisabled(disabled);
		COMP_PC_FC_PAID_AMOUNT.setDisabled(disabled);
		COMP_PC_LC_PAID_AMOUNT.setDisabled(disabled);
		COMP_PC_REF_NO.setDisabled(disabled);
		COMP_PC_FC_BASIC_PREM.setDisabled(disabled);
		COMP_PC_LC_BASIC_PREM.setDisabled(disabled);
		COMP_PC_FC_CHARGE_AMT.setDisabled(disabled);
		COMP_PC_LC_CHARGE_AMT.setDisabled(disabled);
		COMP_PC_FC_ADDL_PREM.setDisabled(disabled);
		COMP_PC_LC_ADDL_PREM.setDisabled(disabled);
		COMP_PC_FC_CHARGE.setDisabled(disabled);
		COMP_PC_LC_CHARGE.setDisabled(disabled);
		COMP_PC_FC_LOAD_AMT.setDisabled(disabled);
		COMP_PC_LC_LOAD_AMT.setDisabled(disabled);
		COMP_PC_FC_DISCOUNT.setDisabled(disabled);
		COMP_PC_LC_DISCOUNT.setDisabled(disabled);
		COMP_PC_FC_GROSS_PREM.setDisabled(disabled);
		COMP_PC_LC_GROSS_PREM.setDisabled(disabled);
		COMP_UI_M_FC_LOAN_INT.setDisabled(disabled);
		COMP_UI_M_LC_LOAN_INT.setDisabled(disabled);
		COMP_PC_FC_UNPAID_PREM_INT.setDisabled(disabled);
		COMP_PC_LC_UNPAID_PREM_INT.setDisabled(disabled);
		COMP_UI_M_LC_NET_PREM.setDisabled(disabled);
		COMP_UI_M_PREM_FC_TO_PAY.setDisabled(disabled);
		COMP_UI_M_PREM_TO_PAY.setDisabled(disabled);
		COMP_PC_LC_AVLB_BAL_AMT.setDisabled(disabled);
		COMP_UI_M_PREM_FC_AMT.setDisabled(disabled);
		COMP_UI_M_PREM_AMT.setDisabled(disabled);
		COMP_PC_TEMP_RCPT_NO.setDisabled(disabled);
		COMP_POL_NO.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_PC_PAID_FLAG.setDisabled(disabled);
		COMP_PC_PREM_HOLIDAY_YN.setDisabled(disabled);
		COMP_PC_WAIVE_PREM_YN.setDisabled(disabled);
		COMP_PC_FLEX_01.setDisabled(disabled);
		
		// Disabling HtmlCalendar
		COMP_PC_SCHD_PYMT_DT.setDisabled(disabled);
		COMP_PC_PAID_DT.setDisabled(disabled);
		COMP_PC_APPRV_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_LOV_POL_NO.setDisabled(disabled);
		COMP_UI_M_BUT_REINSTATE.setDisabled(disabled);
		COMP_UI_M_BUT_INT_DTLS.setDisabled(disabled);
		COMP_UI_M_BUT_CVR_DTL.setDisabled(disabled);
		COMP_UI_M_BUT_BROKER_DTLS.setDisabled(disabled);
		COMP_UI_M_BUT_PYMT_DTLS.setDisabled(disabled);
		COMP_UI_M_BUT_CHG_DTL.setDisabled(disabled);
		COMP_UI_M_BUT_FAC.setDisabled(disabled);
		COMP_UI_M_BUT_LOAN_INT.setDisabled(disabled);
		COMP_UI_M_BUT_APPROVE.setDisabled(disabled);
		COMP_UI_M_FUND_QUERY_DETAILS.setDisabled(disabled);

	}
	
	public void disableHospProdComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_UI_M_FC_NET_PREM.setDisabled(disabled);
		COMP_UI_M_PC_FC_OUTSTD_AMT.setDisabled(disabled);
		COMP_UI_M_PC_LC_OUTSTD_AMT.setDisabled(disabled);
		COMP_UI_M_PC_FC_OUTSTD_AMT_1.setDisabled(disabled);
		COMP_UI_M_PC_LC_OUTSTD_AMT_1.setDisabled(disabled);
		COMP_PC_FC_AVLB_BAL_AMT.setDisabled(disabled);
		COMP_PC_FC_PAID_AMOUNT.setDisabled(disabled);
		COMP_PC_LC_PAID_AMOUNT.setDisabled(disabled);
		COMP_PC_REF_NO.setDisabled(disabled);
		COMP_PC_FC_BASIC_PREM.setDisabled(disabled);
		COMP_PC_LC_BASIC_PREM.setDisabled(disabled);
		COMP_PC_FC_CHARGE_AMT.setDisabled(disabled);
		COMP_PC_LC_CHARGE_AMT.setDisabled(disabled);
		COMP_PC_FC_ADDL_PREM.setDisabled(disabled);
		COMP_PC_LC_ADDL_PREM.setDisabled(disabled);
		COMP_PC_FC_CHARGE.setDisabled(disabled);
		COMP_PC_LC_CHARGE.setDisabled(disabled);
		COMP_PC_FC_LOAD_AMT.setDisabled(disabled);
		COMP_PC_LC_LOAD_AMT.setDisabled(disabled);
		COMP_PC_FC_DISCOUNT.setDisabled(disabled);
		COMP_PC_LC_DISCOUNT.setDisabled(disabled);
		COMP_PC_FC_GROSS_PREM.setDisabled(disabled);
		COMP_PC_LC_GROSS_PREM.setDisabled(disabled);
		COMP_UI_M_FC_LOAN_INT.setDisabled(disabled);
		COMP_UI_M_LC_LOAN_INT.setDisabled(disabled);
		COMP_PC_FC_UNPAID_PREM_INT.setDisabled(disabled);
		COMP_PC_LC_UNPAID_PREM_INT.setDisabled(disabled);
		COMP_UI_M_LC_NET_PREM.setDisabled(disabled);
		COMP_UI_M_PREM_FC_TO_PAY.setDisabled(disabled);
		COMP_UI_M_PREM_TO_PAY.setDisabled(disabled);
		COMP_PC_LC_AVLB_BAL_AMT.setDisabled(disabled);
		COMP_UI_M_PREM_FC_AMT.setDisabled(disabled);
		COMP_UI_M_PREM_AMT.setDisabled(disabled);
		COMP_PC_TEMP_RCPT_NO.setDisabled(disabled);
		COMP_POL_NO.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_PC_PAID_FLAG.setDisabled(disabled);
		COMP_PC_PREM_HOLIDAY_YN.setDisabled(disabled);
		COMP_PC_WAIVE_PREM_YN.setDisabled(disabled);
		COMP_PC_FLEX_01.setDisabled(disabled);
		
		// Disabling HtmlCalendar
		COMP_PC_SCHD_PYMT_DT.setDisabled(disabled);
		COMP_PC_PAID_DT.setDisabled(disabled);
		COMP_PC_APPRV_DT.setDisabled(disabled);

		COMP_UI_M_BUT_APPROVE.setDisabled(disabled);
		
		/*Added by saritha on 26-10-2017 for ssp call id ZBLIFE-1449091*/
		COMP_UI_M_TOTAL_PREM_PAID.setDisabled(disabled);
		/*End*/

	}

	public PILT003_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT003_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public HtmlAjaxCommandButton getCOMP_ADD_BUT() {
		return COMP_ADD_BUT;
	}

	public void setCOMP_ADD_BUT(HtmlAjaxCommandButton comp_add_but) {
		COMP_ADD_BUT = comp_add_but;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_01_LABEL() {
		return COMP_PC_FLEX_01_LABEL;
	}

	public void setCOMP_PC_FLEX_01_LABEL(HtmlOutputLabel comp_pc_flex_01_label) {
		COMP_PC_FLEX_01_LABEL = comp_pc_flex_01_label;
	}

	public List<SelectItem> getListYesNo() {
		return listYesNo;
	}

	public void setListYesNo(List<SelectItem> listYesNo) {
		this.listYesNo = listYesNo;
	}

	public HtmlSelectOneMenu getCOMP_PC_FLEX_01() {
		return COMP_PC_FLEX_01;
	}

	public void setCOMP_PC_FLEX_01(HtmlSelectOneMenu comp_pc_flex_01) {
		COMP_PC_FLEX_01 = comp_pc_flex_01;
	}

	public void validatePC_FLEX_01(FacesContext context,
			UIComponent commComponen, Object value) {
		try {
			String val = (String) value;
			PT_IL_PREM_COLL_BEAN.setPC_FLEX_01(val);
			if (PT_IL_PREM_COLL_BEAN.getPC_FLEX_01().equalsIgnoreCase("Y")) {
				COMP_REV.setDisabled(false);
			}
			COMP_PC_FLEX_01.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public String checkBounce() {
		ArrayList<OracleParameter> list = null;
		try {
			if ("Y".equals(PT_IL_PREM_COLL_BEAN.getPC_FLEX_01())) {
				list = helper.P_CHCK_BOUNCE_ACC_CANC(PT_IL_PREM_COLL_BEAN
						.getPC_POL_SYS_ID(), PT_IL_PREM_COLL_BEAN
						.getPC_SYS_ID(), "Y", "Y");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Process Completed Successfully.");
				getWarningMap().put("CURRENT_1",
						"Process Completed Successfully.");
			
		/*	Added by sankar for reloading the dataatable after reversal the premium on 27/08/2016 */
				setBlockFlag(true);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().fetchBtnAction();
				
				/*end*/
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
		return "";
	}

	public void checkCheque() {
		Connection connection = null;
		ResultSet resultSet = null;
		String query = " SELECT PD_PAY_MODE FROM PT_IL_DEPOSIT,PT_IL_PYMT_DTLS  "
				+ " WHERE   PD_PAY_MODE = 'L' AND PT_IL_DEPOSIT.DEP_SYS_ID = PT_IL_PYMT_DTLS.PD_TXN_SYS_ID  "
				+ " AND DEP_REF_NO = (SELECT POL_NO FROM PT_IL_POLICY WHERE POL_SYS_ID=? ) ";
	}

	public HtmlOutputLabel getCOMP_PC_LC_UNPAID_WAIVE_PREM_INT_LABEL() {
		return COMP_PC_LC_UNPAID_WAIVE_PREM_INT_LABEL;
	}

	public void setCOMP_PC_LC_UNPAID_WAIVE_PREM_INT_LABEL(
			HtmlOutputLabel comp_pc_lc_unpaid_waive_prem_int_label) {
		COMP_PC_LC_UNPAID_WAIVE_PREM_INT_LABEL = comp_pc_lc_unpaid_waive_prem_int_label;
	}

	public HtmlInputText getCOMP_PC_LC_UNPAID_WAIVE_PREM_INT() {
		return COMP_PC_LC_UNPAID_WAIVE_PREM_INT;
	}

	public void setCOMP_PC_LC_UNPAID_WAIVE_PREM_INT(
			HtmlInputText comp_pc_lc_unpaid_waive_prem_int) {
		COMP_PC_LC_UNPAID_WAIVE_PREM_INT = comp_pc_lc_unpaid_waive_prem_int;
	}

	public HtmlInputText getCOMP_PC_FC_UNPAID_WAIVE_PREM_INT() {
		return COMP_PC_FC_UNPAID_WAIVE_PREM_INT;
	}

	public void setCOMP_PC_FC_UNPAID_WAIVE_PREM_INT(
			HtmlInputText comp_pc_fc_unpaid_waive_prem_int) {
		COMP_PC_FC_UNPAID_WAIVE_PREM_INT = comp_pc_fc_unpaid_waive_prem_int;
	}

	public HtmlOutputLabel getCOMP_PC_FC_UNPAID_WAIVE_PREM_INT_LABEL() {
		return COMP_PC_FC_UNPAID_WAIVE_PREM_INT_LABEL;
	}

	public void setCOMP_PC_FC_UNPAID_WAIVE_PREM_INT_LABEL(
			HtmlOutputLabel comp_pc_fc_unpaid_waive_prem_int_label) {
		COMP_PC_FC_UNPAID_WAIVE_PREM_INT_LABEL = comp_pc_fc_unpaid_waive_prem_int_label;
	}

	// ADDED BY AKASH

	public void validateHolidayYN(FacesContext context, UIComponent component,
			Object value) {
		try {
			String value1 = (String) value;
			if ("Y".equals(value1)) {
				COMP_PC_FC_PAID_AMOUNT.setDisabled(true);
				COMP_PC_PAID_DT.setDisabled(true);
				COMP_PC_PAID_DT.setRequired(false);
				COMP_PC_FC_PAID_AMOUNT.setRequired(false);
			} else {
				COMP_PC_FC_PAID_AMOUNT.setDisabled(false);
				COMP_PC_PAID_DT.setDisabled(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	

	public void whenValidatePaiddate(ActionEvent event) throws Exception {
		P9ILPK_PREM_COLL p9ilpk_prem_coll = new P9ILPK_PREM_COLL();
		try {
			if ((!("A".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
					.getPC_PREM_TYPE(), "I"))))
					&& (PT_IL_PREM_COLL_BEAN.getPC_SCHD_PYMT_DT()
							.before(PT_IL_PREM_COLL_BEAN.getPC_PAID_DT()))) {
				/*
				 * new PILT003_PROCEDURES().calL_CALC_UNPAID_PREM_INT(
				 * PT_IL_PREM_COLL_BEAN, policyBean);
				 */
				ArrayList<OracleParameter> listUnpaid = new ArrayList<OracleParameter>();
				listUnpaid = p9ilpk_prem_coll.P_CALC_UNPAID_PREM_INT(
						PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(), null, null, null,
						null);
				if (listUnpaid.size() > 0) {
					if (listUnpaid.get(2).getValueObject() != null) {
						PT_IL_PREM_COLL_BEAN
								.setPC_FC_UNPAID_PREM_INT((Double) listUnpaid
										.get(2).getValueObject());
					}

					if (listUnpaid.get(3).getValueObject() != null) {
						PT_IL_PREM_COLL_BEAN
								.setPC_LC_UNPAID_PREM_INT((Double) listUnpaid
										.get(3).getValueObject());
					}
				}
			}
			COMP_PC_FC_UNPAID_PREM_INT.resetValue();
			COMP_PC_LC_UNPAID_PREM_INT.resetValue();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public HtmlOutputLabel getCOMP_PC_FC_PAID_AMOUNT_LABEL() {
		return COMP_PC_FC_PAID_AMOUNT_LABEL;
	}

	public void setCOMP_PC_FC_PAID_AMOUNT_LABEL(
			HtmlOutputLabel comp_pc_fc_paid_amount_label) {
		COMP_PC_FC_PAID_AMOUNT_LABEL = comp_pc_fc_paid_amount_label;
	}

	public HtmlInputText getCOMP_PC_FC_PAID_AMOUNT() {
		return COMP_PC_FC_PAID_AMOUNT;
	}

	public void setCOMP_PC_FC_PAID_AMOUNT(HtmlInputText comp_pc_fc_paid_amount) {
		COMP_PC_FC_PAID_AMOUNT = comp_pc_fc_paid_amount;
	}

	public HtmlOutputLabel getCOMP_PC_LC_PAID_AMOUNT_LABEL() {
		return COMP_PC_LC_PAID_AMOUNT_LABEL;
	}

	public void setCOMP_PC_LC_PAID_AMOUNT_LABEL(
			HtmlOutputLabel comp_pc_lc_paid_amount_label) {
		COMP_PC_LC_PAID_AMOUNT_LABEL = comp_pc_lc_paid_amount_label;
	}

	public HtmlInputText getCOMP_PC_LC_PAID_AMOUNT() {
		return COMP_PC_LC_PAID_AMOUNT;
	}

	public void setCOMP_PC_LC_PAID_AMOUNT(HtmlInputText comp_pc_lc_paid_amount) {
		COMP_PC_LC_PAID_AMOUNT = comp_pc_lc_paid_amount;
	}

	public void validatePC_FC_PAID_AMT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_AMT((Double) value);
			helper.WHEN_VALIDATE_PC_FC_PAID_AMT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					PT_IL_PREM_COLL_BEAN, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			COMP_PC_LC_PAID_AMOUNT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_FC_PAID_AMT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void validatePC_WAIVE_PREM_YN(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			String temp = (String)value;
			if(!(temp.equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN()))){
			PT_IL_PREM_COLL_BEAN.setPC_WAIVE_PREM_YN((String) value);
			helper.WHEN_VALIDATE_PC_WAIVE_PREM_YN(this,(String) value);
			COMP_UI_M_FC_NET_PREM.resetValue();
			COMP_UI_M_LC_NET_PREM.resetValue();
			COMP_PC_FC_UNPAID_WAIVE_PREM_INT.resetValue();
			COMP_PC_LC_UNPAID_WAIVE_PREM_INT.resetValue();
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public void validatePC_FC_UNPAID_WAIVE_PREM_INT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			if(!(value.equals(PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_WAIVE_PREM_INT()))){
			PT_IL_PREM_COLL_BEAN.setPC_FC_UNPAID_WAIVE_PREM_INT((Double) value);
			helper.WHEN_VALIDATE_PC_FC_UNPAID_WAIVE_PREM_INT(this,(Double) value);
			COMP_PC_LC_UNPAID_WAIVE_PREM_INT.resetValue();
			COMP_UI_M_LC_NET_PREM.resetValue();
			COMP_UI_M_FC_NET_PREM.resetValue();
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public HtmlSelectOneMenu getCOMP_PC_WAIVE_PREM_YN() {
		return COMP_PC_WAIVE_PREM_YN;
	}

	public void setCOMP_PC_WAIVE_PREM_YN(HtmlSelectOneMenu comp_pc_waive_prem_yn) {
		COMP_PC_WAIVE_PREM_YN = comp_pc_waive_prem_yn;
	}

	public HtmlOutputLabel getCOMP_PC_WAIVE_PREM_YN_LABEL() {
		return COMP_PC_WAIVE_PREM_YN_LABEL;
	}

	public void setCOMP_PC_WAIVE_PREM_YN_LABEL(
			HtmlOutputLabel comp_pc_waive_prem_yn_label) {
		COMP_PC_WAIVE_PREM_YN_LABEL = comp_pc_waive_prem_yn_label;
	}

	public HtmlInputText getCOMP_PC_DRCR_DOC_NO() {
		return COMP_PC_DRCR_DOC_NO;
	}

	public void setCOMP_PC_DRCR_DOC_NO(HtmlInputText comp_pc_drcr_doc_no) {
		COMP_PC_DRCR_DOC_NO = comp_pc_drcr_doc_no;
	}

	public HtmlOutputLabel getCOMP_PC_DRCR_DOC_NO_LABEL() {
		return COMP_PC_DRCR_DOC_NO_LABEL;
	}

	public void setCOMP_PC_DRCR_DOC_NO_LABEL(
			HtmlOutputLabel comp_pc_drcr_doc_no_label) {
		COMP_PC_DRCR_DOC_NO_LABEL = comp_pc_drcr_doc_no_label;
	}
	
	//added by krithika on 30-05-2016
	public String printaction()
	{
		
		//added by agalya
		compositeAction.getPILT003_APAC_PRINTACTION_BEAN().setBlockFlag(true);
		System.out.println("compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_DOC_NO()"+compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_DRCR_DOC_NO());
		return "PrintButton";
	}
	
	
	
	/*Added By jannai for DMS Integration*/
	
	
	//public CommonReportAction commonReportAction;
	
	
	 public void callReportModalPanel(ActionEvent event) {
		 String input = event.getComponent().getId();
		 runAction_DMS();
		 try {
		
				 String dmsUrl = new DMSUtil().getDmsUrl();
				 System.out.println("PT_IL_PREM_COLL_ACTION.invokeDMS()" + dmsUrl);
				 setRedirectUrl(dmsUrl);
			
					System.out.println("getRedirectUrl in renewal prem coll                :"+getRedirectUrl());	

			 if (getRedirectUrl() != null) {
				 getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
			 } else {
				 getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
			 }

		 } catch (Exception e) {
			 e.printStackTrace();
		 }

	 }

	
	 public String runAction_DMS() {
		 System.out.println("PT_IL_PREM_COLL_ACTION_PILT003.invokeDMS()");
		 try {

		 } catch (Exception e) {
			
		 }
		 return "";

	 }
	
	 
	 /*end*/
	 
	 
	 /*added by raja on 09-05-2017*/
	 	private HtmlOutputLabel COMP_PC_DRCR_DOC_DT_LABEL;

		private HtmlCalendar COMP_PC_DRCR_DOC_DT;

		public HtmlOutputLabel getCOMP_PC_DRCR_DOC_DT_LABEL() {
			return COMP_PC_DRCR_DOC_DT_LABEL;
		}

		public void setCOMP_PC_DRCR_DOC_DT_LABEL(
				HtmlOutputLabel cOMP_PC_DRCR_DOC_DT_LABEL) {
			COMP_PC_DRCR_DOC_DT_LABEL = cOMP_PC_DRCR_DOC_DT_LABEL;
		}

		public HtmlCalendar getCOMP_PC_DRCR_DOC_DT() {
			return COMP_PC_DRCR_DOC_DT;
		}

		public void setCOMP_PC_DRCR_DOC_DT(HtmlCalendar cOMP_PC_DRCR_DOC_DT) {
			COMP_PC_DRCR_DOC_DT = cOMP_PC_DRCR_DOC_DT;
		}
		
		 
	 /*end*/
		 
		/*Added by Ameen on 25-05-2017*/
		private HtmlCommandLink COMP_SAVE_BTN;
		private HtmlCommandLink COMP_DMS_BTN;
		
		private HtmlCommandButton COMP_SAVE_COMD_BTN;
		private HtmlCommandButton COMP_DMS_COMD_BTN;

		public HtmlCommandLink getCOMP_SAVE_BTN() {
			return COMP_SAVE_BTN;
		}

		public void setCOMP_SAVE_BTN(HtmlCommandLink cOMP_SAVE_BTN) {
			COMP_SAVE_BTN = cOMP_SAVE_BTN;
		}

		public HtmlCommandLink getCOMP_DMS_BTN() {
			return COMP_DMS_BTN;
		}

		public void setCOMP_DMS_BTN(HtmlCommandLink cOMP_DMS_BTN) {
			COMP_DMS_BTN = cOMP_DMS_BTN;
		}

		public HtmlCommandButton getCOMP_SAVE_COMD_BTN() {
			return COMP_SAVE_COMD_BTN;
		}

		public void setCOMP_SAVE_COMD_BTN(HtmlCommandButton cOMP_SAVE_COMD_BTN) {
			COMP_SAVE_COMD_BTN = cOMP_SAVE_COMD_BTN;
		}

		public HtmlCommandButton getCOMP_DMS_COMD_BTN() {
			return COMP_DMS_COMD_BTN;
		}

		public void setCOMP_DMS_COMD_BTN(HtmlCommandButton cOMP_DMS_COMD_BTN) {
			COMP_DMS_COMD_BTN = cOMP_DMS_COMD_BTN;
		}
		
		/*End*/
		
		/*Added by saritha on 26-10-2017 for ssp call id ZBLIFE-1449091*/
		private HtmlOutputLabel COMP_UI_M_TOTAL_PREM_PAID_LABEL;
		private HtmlInputText COMP_UI_M_TOTAL_PREM_PAID;

		public HtmlOutputLabel getCOMP_UI_M_TOTAL_PREM_PAID_LABEL() {
			return COMP_UI_M_TOTAL_PREM_PAID_LABEL;
		}

		public void setCOMP_UI_M_TOTAL_PREM_PAID_LABEL(
				HtmlOutputLabel cOMP_UI_M_TOTAL_PREM_PAID_LABEL) {
			COMP_UI_M_TOTAL_PREM_PAID_LABEL = cOMP_UI_M_TOTAL_PREM_PAID_LABEL;
		}
		
		public HtmlInputText getCOMP_UI_M_TOTAL_PREM_PAID() {
			return COMP_UI_M_TOTAL_PREM_PAID;
		}

		public void setCOMP_UI_M_TOTAL_PREM_PAID(HtmlInputText cOMP_UI_M_TOTAL_PREM_PAID) {
			COMP_UI_M_TOTAL_PREM_PAID = cOMP_UI_M_TOTAL_PREM_PAID;
		}
		/*End*/
		
		
		/*Added by saritha on 17-01-2018 for System should not allow to reverse the allocation(Premium collection screen) 
		 * even when policy not in Force (Death claim,Cancelled,Lapse,Surrender,Matured,Paid up) query given by ajoy */

		public boolean getchequeBounceYN_Enable() throws Exception {

			ResultSet rstchequebounceYN = null;
			Connection connection = null;
			boolean chequebounceYN = false;
			CRUDHandler handler = new CRUDHandler();
			try {
				connection = CommonUtils.getConnection();

				String query = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_NO = ? AND NVL(POL_APPRV_STATUS,'N') = 'A' AND NVL(POL_STATUS,'N') = 'A' ";

				rstchequebounceYN = handler.executeSelectStatement(query, connection,
						new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});

				if (rstchequebounceYN.next()) {
					chequebounceYN = true;

				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} finally {
				CommonUtils.closeCursor(rstchequebounceYN);
			}
			return chequebounceYN;
		}

		/*End*/	

		public Date fetchLastPaymentDate(PT_IL_PREM_COLL collBean) throws Exception {
			String C1 = "SELECT MAX(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND PC_PAID_FLAG = 'A' AND PC_PAID_DT IS NOT NULL";
			Date lastPayDate = null;
			Connection con = null;
			ResultSet rs = null;
			CRUDHandler handler = null;
			try {
				con = CommonUtils.getConnection();
				handler = new CRUDHandler();
				rs = handler.executeSelectStatement(C1, con,
						new Object[] { collBean.getPC_POL_SYS_ID() });
				if (rs.next()) {
					lastPayDate = rs.getDate(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} finally {
				CommonUtils.closeCursor(rs);
			}
			return lastPayDate;
		}
}