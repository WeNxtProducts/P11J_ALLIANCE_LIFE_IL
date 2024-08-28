package com.iii.pel.forms.PILT039_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlTab;
import org.richfaces.component.html.HtmlTabPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILM086_APAC.PILM086_VAL_RNG_DTLS_BEAN;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.pel.forms.PM075_A.PM_CUSTOMER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PILT039_APAC_ACTION extends CommonAction{
	public PILT039_APAC_COMPOSITE_ACTION compositeAction;
	
	PILT039_APAC_BEAN PILT039_APAC_bean;
	PILT039_APAC_DELEGATE delegate;
	PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN;
	PILT039_APAC_HELPER helper;
	
	/*added by nadhiya*/
	PILT039_APAC_TAB1DELEGATE PILT039_APAC_TAB1DELEGATE_bean;
	PT_IL_POLICY PT_IL_POLICY_BEAN ;
	PM_CUSTOMER PM_CUSTOMER_BEAN;
	/*end*/
	
	
	public PILT039_APAC_ACTION(){
		PILT039_APAC_bean = new PILT039_APAC_BEAN();
		delegate = new PILT039_APAC_DELEGATE();
		helper = new PILT039_APAC_HELPER();
		PT_IL_RECEIPT_TRANS_HDR_BEAN = new PT_IL_RECEIPT_TRANS_HDR();
		instiate();
		inisiateComponent();
		
		
		/*added by nadhiya*/
		PILT039_APAC_TAB1DELEGATE_bean = new PILT039_APAC_TAB1DELEGATE();
		prepareDropDownList();
		 PT_IL_POLICY_BEAN=new PT_IL_POLICY();

		 PM_CUSTOMER_BEAN=new PM_CUSTOMER();
		
		/*end*/
		
		
	}
	
	

	public PILT039_APAC_TAB1DELEGATE getPILT039_APAC_TAB1DELEGATE_bean() {
		return PILT039_APAC_TAB1DELEGATE_bean;
	}



	public void setPILT039_APAC_TAB1DELEGATE_bean(
			PILT039_APAC_TAB1DELEGATE pILT039_APAC_TAB1DELEGATE_bean) {
		PILT039_APAC_TAB1DELEGATE_bean = pILT039_APAC_TAB1DELEGATE_bean;
	}



	public PILT039_APAC_DELEGATE getDelegate() {
		return delegate;
	}



	public void setDelegate(PILT039_APAC_DELEGATE delegate) {
		this.delegate = delegate;
	}



	public PT_IL_RECEIPT_TRANS_HDR getPT_IL_RECEIPT_TRANS_HDR_BEAN() {
		return PT_IL_RECEIPT_TRANS_HDR_BEAN;
	}



	public void setPT_IL_RECEIPT_TRANS_HDR_BEAN(
			PT_IL_RECEIPT_TRANS_HDR pT_IL_RECEIPT_TRANS_HDR_BEAN) {
		PT_IL_RECEIPT_TRANS_HDR_BEAN = pT_IL_RECEIPT_TRANS_HDR_BEAN;
	}



	public PILT039_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT039_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	
	

	public PILT039_APAC_BEAN getPILT039_APAC_bean() {
		return PILT039_APAC_bean;
	}

	public void setPILT039_APAC_bean(PILT039_APAC_BEAN pILT039_APAC_bean) {
		PILT039_APAC_bean = pILT039_APAC_bean;
	}

	

	public PILT039_APAC_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PILT039_APAC_HELPER helper) {
		this.helper = helper;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	private UIData dataTable;

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	private List<PILT039_APAC_BEAN> PILT1993_BEAN_CLASS_DATATABLE = new ArrayList<PILT039_APAC_BEAN>();
	
	
	public List<PILT039_APAC_BEAN> getPILT1993_BEAN_CLASS_DATATABLE() {
		return PILT1993_BEAN_CLASS_DATATABLE;
	}

	public void setPILT1993_BEAN_CLASS_DATATABLE(
			List<PILT039_APAC_BEAN> pILT1993_BEAN_CLASS_DATATABLE) {
		PILT1993_BEAN_CLASS_DATATABLE = pILT1993_BEAN_CLASS_DATATABLE;
	}

	private HtmlOutputLabel COMP_RTD_REASON_CODE_LABEL;

	private HtmlInputText COMP_RTD_REASON_CODE;
	
	private HtmlInputText COMP_RTD_REASON_CODE_DESC;
	
	private HtmlOutputLabel COMP_RTD_TXN_CODE_LABEL;

	private HtmlInputText COMP_RTD_TXN_CODE;
	
	private HtmlOutputLabel COMP_RTD_DOC_NO_LABEL;

	private HtmlInputText COMP_RTD_DOC_NO;
	
	private HtmlOutputLabel COMP_RTD_DOC_DT_LABEL;

	private HtmlCalendar COMP_RTD_DOC_DT;
	
	private HtmlOutputLabel COMP_RTD_ACNT_YR_LABEL;

	private HtmlInputText COMP_RTD_ACNT_YR;
	
	private HtmlOutputLabel COMP_RTD_REV_REMARKS_LABEL;
	
	private HtmlInputTextarea COMP_RTD_REV_REMARKS;
	
	

	public void instiate(){
		COMP_RTD_REASON_CODE=new HtmlInputText();
		COMP_RTD_REASON_CODE_DESC=new HtmlInputText();
		COMP_RTD_TXN_CODE=new HtmlInputText();
		COMP_RTD_DOC_NO=new HtmlInputText();
		COMP_RTD_DOC_DT=new HtmlCalendar();
		COMP_RTD_ACNT_YR=new HtmlInputText();
		COMP_RTD_REV_REMARKS=new HtmlInputTextarea();
	}
	
	
	
	

	public HtmlOutputLabel getCOMP_RTD_REASON_CODE_LABEL() {
		return COMP_RTD_REASON_CODE_LABEL;
	}

	public void setCOMP_RTD_REASON_CODE_LABEL(
			HtmlOutputLabel cOMP_RTD_REASON_CODE_LABEL) {
		COMP_RTD_REASON_CODE_LABEL = cOMP_RTD_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RTD_REASON_CODE() {
		return COMP_RTD_REASON_CODE;
	}

	public void setCOMP_RTD_REASON_CODE(HtmlInputText cOMP_RTD_REASON_CODE) {
		COMP_RTD_REASON_CODE = cOMP_RTD_REASON_CODE;
	}

	public HtmlInputText getCOMP_RTD_REASON_CODE_DESC() {
		return COMP_RTD_REASON_CODE_DESC;
	}

	public void setCOMP_RTD_REASON_CODE_DESC(HtmlInputText cOMP_RTD_REASON_CODE_DESC) {
		COMP_RTD_REASON_CODE_DESC = cOMP_RTD_REASON_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_RTD_TXN_CODE_LABEL() {
		return COMP_RTD_TXN_CODE_LABEL;
	}

	public void setCOMP_RTD_TXN_CODE_LABEL(HtmlOutputLabel cOMP_RTD_TXN_CODE_LABEL) {
		COMP_RTD_TXN_CODE_LABEL = cOMP_RTD_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RTD_TXN_CODE() {
		return COMP_RTD_TXN_CODE;
	}

	public void setCOMP_RTD_TXN_CODE(HtmlInputText cOMP_RTD_TXN_CODE) {
		COMP_RTD_TXN_CODE = cOMP_RTD_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_RTD_DOC_NO_LABEL() {
		return COMP_RTD_DOC_NO_LABEL;
	}

	public void setCOMP_RTD_DOC_NO_LABEL(HtmlOutputLabel cOMP_RTD_DOC_NO_LABEL) {
		COMP_RTD_DOC_NO_LABEL = cOMP_RTD_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_RTD_DOC_NO() {
		return COMP_RTD_DOC_NO;
	}

	public void setCOMP_RTD_DOC_NO(HtmlInputText cOMP_RTD_DOC_NO) {
		COMP_RTD_DOC_NO = cOMP_RTD_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_RTD_DOC_DT_LABEL() {
		return COMP_RTD_DOC_DT_LABEL;
	}

	public void setCOMP_RTD_DOC_DT_LABEL(HtmlOutputLabel cOMP_RTD_DOC_DT_LABEL) {
		COMP_RTD_DOC_DT_LABEL = cOMP_RTD_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_RTD_DOC_DT() {
		return COMP_RTD_DOC_DT;
	}

	public void setCOMP_RTD_DOC_DT(HtmlCalendar cOMP_RTD_DOC_DT) {
		COMP_RTD_DOC_DT = cOMP_RTD_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_RTD_ACNT_YR_LABEL() {
		return COMP_RTD_ACNT_YR_LABEL;
	}

	public void setCOMP_RTD_ACNT_YR_LABEL(HtmlOutputLabel cOMP_RTD_ACNT_YR_LABEL) {
		COMP_RTD_ACNT_YR_LABEL = cOMP_RTD_ACNT_YR_LABEL;
	}

	

	public HtmlInputText getCOMP_RTD_ACNT_YR() {
		return COMP_RTD_ACNT_YR;
	}

	public void setCOMP_RTD_ACNT_YR(HtmlInputText cOMP_RTD_ACNT_YR) {
		COMP_RTD_ACNT_YR = cOMP_RTD_ACNT_YR;
	}

	public HtmlOutputLabel getCOMP_RTD_REV_REMARKS_LABEL() {
		return COMP_RTD_REV_REMARKS_LABEL;
	}

	public void setCOMP_RTD_REV_REMARKS_LABEL(
			HtmlOutputLabel cOMP_RTD_REV_REMARKS_LABEL) {
		COMP_RTD_REV_REMARKS_LABEL = cOMP_RTD_REV_REMARKS_LABEL;
	}

	public HtmlInputTextarea getCOMP_RTD_REV_REMARKS() {
		return COMP_RTD_REV_REMARKS;
	}

	public void setCOMP_RTD_REV_REMARKS(HtmlInputTextarea cOMP_RTD_REV_REMARKS) {
		COMP_RTD_REV_REMARKS = cOMP_RTD_REV_REMARKS;
	}

	public HtmlTab getCOMP_MORE_INFO_1() {
		return COMP_MORE_INFO_1;
	}

	public void setCOMP_MORE_INFO_1(HtmlTab cOMP_MORE_INFO_1) {
		COMP_MORE_INFO_1 = cOMP_MORE_INFO_1;
	}

	public HtmlTab getCOMP_MORE_INFO_2() {
		return COMP_MORE_INFO_2;
	}

	public void setCOMP_MORE_INFO_2(HtmlTab cOMP_MORE_INFO_2) {
		COMP_MORE_INFO_2 = cOMP_MORE_INFO_2;
	}

	public HtmlTabPanel getCOMP_TAB_PANEL() {
		return COMP_TAB_PANEL;
	}

	public void setCOMP_TAB_PANEL(HtmlTabPanel cOMP_TAB_PANEL) {
		COMP_TAB_PANEL = cOMP_TAB_PANEL;
	}

	
	/*added by nadhiya*/
	
	private HtmlInputText COMP_RTH_SRC_POL_NO;
	private HtmlOutputLabel COMP_RTH_SRC_POL_NO_LABEL;
	
	private HtmlInputText COMP_M_CUST_CODE;
	private HtmlInputText COMP_M_CUST_DESC;
	private HtmlOutputLabel COMP_M_CUST_CODE_LABEL;
	
	private HtmlCalendar COMP_RTH_APPRV_DT;
	private HtmlOutputLabel COMP_RTH_APPRV_DT_LABEL;
	
	private HtmlInputText COMP_M_RTD_TXN_CODE;
	private HtmlOutputLabel COMP_M_RTD_TXN_CODE_LABEL;
	
	private HtmlInputText COMP_M_DOC_NO;
	private HtmlOutputLabel COMP_M_DOC_NO_LABEL;
	
	private HtmlCalendar COMP_M_DOC_DT;
	private HtmlOutputLabel COMP_M_DOC_DT_LABEL;
	
	private HtmlInputText COMP_M_ACC_YEAR;
	private HtmlOutputLabel COMP_M_ACC_YEAR_LABEL;
	
	private HtmlInputText COMP_M_DEP_LC_DEP_AMT;
	private HtmlOutputLabel COMP_M_DEP_LC_DEP_AMT_LABEL;
	
	private HtmlInputText COMP_RTD_DEP_LC_AMT;
	private HtmlOutputLabel COMP_RTD_DEP_LC_AMT_LABEL;
	
	private HtmlSelectOneMenu  COMP_RTD_TRNS_YN;
	private HtmlOutputLabel COMP_RTD_TRNS_YN_LABEL ;
	
	private HtmlInputText COMP_M_TOT_RTD_DEP_LC_AMT;
	private HtmlOutputLabel COMP_M_TOT_RTD_DEP_LC_AMT_LABEL;
	
	private HtmlInputText COMP_M_TOT_SELECTED_AMT;
	private HtmlOutputLabel COMP_M_TOT_SELECTED_AMT_LABEL;
	
	public HtmlInputText getCOMP_M_TOT_SELECTED_AMT() {
		return COMP_M_TOT_SELECTED_AMT;
	}

	public void setCOMP_M_TOT_SELECTED_AMT(HtmlInputText cOMP_M_TOT_SELECTED_AMT) {
		COMP_M_TOT_SELECTED_AMT = cOMP_M_TOT_SELECTED_AMT;
	}

	public HtmlOutputLabel getCOMP_M_TOT_SELECTED_AMT_LABEL() {
		return COMP_M_TOT_SELECTED_AMT_LABEL;
	}

	public void setCOMP_M_TOT_SELECTED_AMT_LABEL(
			HtmlOutputLabel cOMP_M_TOT_SELECTED_AMT_LABEL) {
		COMP_M_TOT_SELECTED_AMT_LABEL = cOMP_M_TOT_SELECTED_AMT_LABEL;
	}

	public HtmlInputText getCOMP_M_CUST_DESC() {
		return COMP_M_CUST_DESC;
	}

	public void setCOMP_M_CUST_DESC(HtmlInputText cOMP_M_CUST_DESC) {
		COMP_M_CUST_DESC = cOMP_M_CUST_DESC;
	}

	public HtmlInputText getCOMP_M_RTD_TXN_CODE() {
		return COMP_M_RTD_TXN_CODE;
	}

	public void setCOMP_M_RTD_TXN_CODE(HtmlInputText cOMP_M_RTD_TXN_CODE) {
		COMP_M_RTD_TXN_CODE = cOMP_M_RTD_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_M_RTD_TXN_CODE_LABEL() {
		return COMP_M_RTD_TXN_CODE_LABEL;
	}

	public void setCOMP_M_RTD_TXN_CODE_LABEL(
			HtmlOutputLabel cOMP_M_RTD_TXN_CODE_LABEL) {
		COMP_M_RTD_TXN_CODE_LABEL = cOMP_M_RTD_TXN_CODE_LABEL;
	}

	
	public HtmlOutputLabel getCOMP_M_DOC_NO_LABEL() {
		return COMP_M_DOC_NO_LABEL;
	}

	public void setCOMP_M_DOC_NO_LABEL(HtmlOutputLabel cOMP_M_DOC_NO_LABEL) {
		COMP_M_DOC_NO_LABEL = cOMP_M_DOC_NO_LABEL;
	}

	

	public HtmlOutputLabel getCOMP_M_DOC_DT_LABEL() {
		return COMP_M_DOC_DT_LABEL;
	}

	public void setCOMP_M_DOC_DT_LABEL(HtmlOutputLabel cOMP_M_DOC_DT_LABEL) {
		COMP_M_DOC_DT_LABEL = cOMP_M_DOC_DT_LABEL;
	}

	

	public HtmlOutputLabel getCOMP_M_ACC_YEAR_LABEL() {
		return COMP_M_ACC_YEAR_LABEL;
	}

	public void setCOMP_M_ACC_YEAR_LABEL(HtmlOutputLabel cOMP_M_ACC_YEAR_LABEL) {
		COMP_M_ACC_YEAR_LABEL = cOMP_M_ACC_YEAR_LABEL;
	}

	

	public HtmlOutputLabel getCOMP_M_DEP_LC_DEP_AMT_LABEL() {
		return COMP_M_DEP_LC_DEP_AMT_LABEL;
	}

	public void setCOMP_M_DEP_LC_DEP_AMT_LABEL(
			HtmlOutputLabel cOMP_M_DEP_LC_DEP_AMT_LABEL) {
		COMP_M_DEP_LC_DEP_AMT_LABEL = cOMP_M_DEP_LC_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_RTD_DEP_LC_AMT() {
		return COMP_RTD_DEP_LC_AMT;
	}

	public void setCOMP_RTD_DEP_LC_AMT(HtmlInputText cOMP_RTD_DEP_LC_AMT) {
		COMP_RTD_DEP_LC_AMT = cOMP_RTD_DEP_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_RTD_DEP_LC_AMT_LABEL() {
		return COMP_RTD_DEP_LC_AMT_LABEL;
	}

	public void setCOMP_RTD_DEP_LC_AMT_LABEL(
			HtmlOutputLabel cOMP_RTD_DEP_LC_AMT_LABEL) {
		COMP_RTD_DEP_LC_AMT_LABEL = cOMP_RTD_DEP_LC_AMT_LABEL;
	}

	

	public HtmlSelectOneMenu getCOMP_RTD_TRNS_YN() {
		return COMP_RTD_TRNS_YN;
	}

	public void setCOMP_RTD_TRNS_YN(HtmlSelectOneMenu cOMP_RTD_TRNS_YN) {
		COMP_RTD_TRNS_YN = cOMP_RTD_TRNS_YN;
	}

	public HtmlOutputLabel getCOMP_RTD_TRNS_YN_LABEL() {
		return COMP_RTD_TRNS_YN_LABEL;
	}

	public void setCOMP_RTD_TRNS_YN_LABEL(HtmlOutputLabel cOMP_RTD_TRNS_YN_LABEL) {
		COMP_RTD_TRNS_YN_LABEL = cOMP_RTD_TRNS_YN_LABEL;
	}

	public HtmlInputText getCOMP_M_TOT_RTD_DEP_LC_AMT() {
		return COMP_M_TOT_RTD_DEP_LC_AMT;
	}

	public void setCOMP_M_TOT_RTD_DEP_LC_AMT(HtmlInputText cOMP_M_TOT_RTD_DEP_LC_AMT) {
		COMP_M_TOT_RTD_DEP_LC_AMT = cOMP_M_TOT_RTD_DEP_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_M_TOT_RTD_DEP_LC_AMT_LABEL() {
		return COMP_M_TOT_RTD_DEP_LC_AMT_LABEL;
	}

	public void setCOMP_M_TOT_RTD_DEP_LC_AMT_LABEL(
			HtmlOutputLabel cOMP_M_TOT_RTD_DEP_LC_AMT_LABEL) {
		COMP_M_TOT_RTD_DEP_LC_AMT_LABEL = cOMP_M_TOT_RTD_DEP_LC_AMT_LABEL;
	}

	public HtmlOutputLabel getCOMP_RTH_SRC_POL_NO_LABEL() {
		return COMP_RTH_SRC_POL_NO_LABEL;
	}

	public void setCOMP_RTH_SRC_POL_NO_LABEL(
			HtmlOutputLabel cOMP_RTH_SRC_POL_NO_LABEL) {
		COMP_RTH_SRC_POL_NO_LABEL = cOMP_RTH_SRC_POL_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_M_CUST_CODE_LABEL() {
		return COMP_M_CUST_CODE_LABEL;
	}

	public void setCOMP_M_CUST_CODE_LABEL(HtmlOutputLabel cOMP_M_CUST_CODE_LABEL) {
		COMP_M_CUST_CODE_LABEL = cOMP_M_CUST_CODE_LABEL;
	}

	public HtmlOutputLabel getCOMP_RTH_APPRV_DT_LABEL() {
		return COMP_RTH_APPRV_DT_LABEL;
	}

	public void setCOMP_RTH_APPRV_DT_LABEL(HtmlOutputLabel cOMP_RTH_APPRV_DT_LABEL) {
		COMP_RTH_APPRV_DT_LABEL = cOMP_RTH_APPRV_DT_LABEL;
	}

	public HtmlInputText getCOMP_RTH_SRC_POL_NO() {
		return COMP_RTH_SRC_POL_NO;
	}

	public void setCOMP_RTH_SRC_POL_NO(HtmlInputText cOMP_RTH_SRC_POL_NO) {
		COMP_RTH_SRC_POL_NO = cOMP_RTH_SRC_POL_NO;
	}

	public HtmlInputText getCOMP_M_CUST_CODE() {
		return COMP_M_CUST_CODE;
	}

	public void setCOMP_M_CUST_CODE(HtmlInputText cOMP_M_CUST_CODE) {
		COMP_M_CUST_CODE = cOMP_M_CUST_CODE;
	}

	

	public HtmlCalendar getCOMP_RTH_APPRV_DT() {
		return COMP_RTH_APPRV_DT;
	}

	public void setCOMP_RTH_APPRV_DT(HtmlCalendar cOMP_RTH_APPRV_DT) {
		COMP_RTH_APPRV_DT = cOMP_RTH_APPRV_DT;
	}

	private HtmlCommandButton COMP_UI_PROCESS;
	
	private HtmlCommandButton COMP_UI_APPRO;
	
public HtmlCommandButton getCOMP_UI_PROCESS() {
		return COMP_UI_PROCESS;
	}

	public void setCOMP_UI_PROCESS(HtmlCommandButton cOMP_UI_PROCESS) {
		COMP_UI_PROCESS = cOMP_UI_PROCESS;
	}

	public HtmlCommandButton getCOMP_UI_APPRO() {
		return COMP_UI_APPRO;
	}

	public void setCOMP_UI_APPRO(HtmlCommandButton cOMP_UI_APPRO) {
		COMP_UI_APPRO = cOMP_UI_APPRO;
	}
	

    public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY pT_IL_POLICY_BEAN) {
		PT_IL_POLICY_BEAN = pT_IL_POLICY_BEAN;
	}

	public PM_CUSTOMER getPM_CUSTOMER_BEAN() {
		return PM_CUSTOMER_BEAN;
	}

	public void setPM_CUSTOMER_BEAN(PM_CUSTOMER pM_CUSTOMER_BEAN) {
		PM_CUSTOMER_BEAN = pM_CUSTOMER_BEAN;
	}
	
	/*DROPDOWNlist*/
	private List<SelectItem> listCR = new ArrayList<SelectItem>();

	public List<SelectItem> getListCR() {
		if (listCR.size() == 0) {
			listCR.clear();
			try {
				listCR = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCR;
	}
	/*added by gopi for setting customer code on 07/02/17*/
	 public void validateCUST_CODE(FacesContext facesContext,
			 UIComponent component, Object value) throws ValidatorException {
		 CommonUtils.clearMaps(this);
		 try {
			 String code = (String) value;


			 PT_IL_RECEIPT_TRANS_HDR_BEAN.setWP_CUST_CODE(code);
		} catch (Exception exception) {
			 exception.printStackTrace();
			 throw new ValidatorException(new FacesMessage(exception
					 .getMessage()));
		 } finally {
			 try {
				 ErrorHelpUtil.getWarningForProcedure(CommonUtils
						 .getConnection(), "CUST_CODE", getWarningMap());
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
	 }
	/*	END*/


	public void setListCR(List<SelectItem> listCR) {
		this.listCR = listCR;
	}
	/*END*/


public void prepareDropDownList(){
	Connection connection;
	try{
		connection = CommonUtils.getConnection();
		listCR= ListItemUtil.getDropDownListValue(
				connection, "PILT039_APAC", "PT_IL_RECEIPT_TRANS_DTL",
				"PT_IL_RECEIPT_TRANS_DTL.RTD_TRNS_YN", "YESNO");

	}catch (DBException e) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("prepareDropDownList", e.getMessage());
	}
		
	}
	
	
	

/*suggestion box*/

public ArrayList<LovBean> prepareSuggestionRTH_SRC_POL_NO(Object object){
	
	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
	ListItemUtil itemUtil = new ListItemUtil();
	String currentValue = (String) object;
	String moduleName = "PILT039_APAC";
	String blockName = "PT_IL_RECEIPT_TRANS_HDR";
	String fieldName = "RTH_SRC_POL_NO";
	String lovName = "PILH121";

	try {
		currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, lovName, 

null,
				null, null, null, currentValue);
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("SUGGETION", e.getMessage());
	}
	return lovList;
}
/*END*/
	

/*FORDATATABLE*/
private UIData setDatatable;



public UIData getSetDatatable() {
	return setDatatable;
}

public void setSetDatatable(UIData setDatatable) {
	this.setDatatable = setDatatable;
}

private List<PILT039_APAC_BEAN> listdata = new ArrayList<PILT039_APAC_BEAN>();



public List<PILT039_APAC_BEAN> getListdata() {
	return listdata;
}

public void setListdata(List<PILT039_APAC_BEAN> listdata) {
	this.listdata = listdata;
}

/*END*/

private void resetReceiptRow() {
	System.out.println("****indide of resetSelectedRow****");
	
	Iterator<PILT039_APAC_BEAN> PILT039_APAC_bean = listdata.iterator();
	while (PILT039_APAC_bean.hasNext()) {
		PILT039_APAC_bean.next().setRowSelected(false);
	}
}

public void displayRecords() {
	CommonUtils.clearMaps(this);
	try {
		System.out.println("indide RECEIPT of displayRecords");
		
		resetReceiptRow();
		PILT039_APAC_bean = (PILT039_APAC_BEAN) setDatatable.getRowData();
		PILT039_APAC_bean.setRowSelected(true);
		System.out.println("PILT039_APAC_bean        "+PILT039_APAC_bean.getRTD_REV_REMARKS());
		resetAllComponentInfo();
		
	} catch (Exception exc) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				exc.getMessage());
		getErrorMap().put("displayRecords", exc.getMessage());
	}

}


public void addInfo(ActionEvent event){
	System.out.println("PILT0321_APAC add");
	try {
		/*getErrorMap().clear();
		getWarningMap().clear();*/
		if (isINSERT_ALLOWED()){
			PILT039_APAC_bean = new PILT039_APAC_BEAN();
				resetAllComponentInfo();
			resetReceiptRow();
			query();
		}
		else{
			getErrorMap().put(
					"addRow",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
			getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));				}
		// Row highlight changes
	} catch (Exception exc) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				exc.getMessage());
		getErrorMap().put("addRow", exc.getMessage());
	}
}


public void deleteInfo(ActionEvent event){
	System.out.println("PILT0321_APAC delete");
	
	String message = null;
	getWarningMap().clear();
	getErrorMap().clear();
	try {
		System.out.println("PILT039_APAC_bean.getROWID() *********"+PILT039_APAC_bean.getROWID());
		if (isDELETE_ALLOWED()) {
			new CRUDHandler().executeDelete(PILT039_APAC_bean,CommonUtils.getConnection());
			listdata.remove(PILT039_APAC_bean);
			if (listdata.size() > 0) {
				PILT039_APAC_bean = listdata.get(0);
			} else if (listdata.size() == 0) {
				addInfo(null);
			}
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$Grid$delete");
			getWarningMap().put("deleteRow", message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			resetAllComponentInfo();
			PILT039_APAC_bean.setRowSelected(true);
		} else {
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed");
			getErrorMap().put("deleteRow", message);
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		}
	} catch (Exception exc) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
		getErrorMap().put("deleteRow", exc.getMessage());
	}
}

/*public void postInfo(ActionEvent event) {
	
	
	System.out.println(" inside post record===========");
	
	String message = null;
	try {
				
		if (PILT039_APAC_bean.getROWID() == null && isINSERT_ALLOWED()) {
					String Query="SELECT PIL_PD_SYS_ID.NEXTVAL FROM DUAL";
					
					ResultSet s=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection());
					while(s.next()){
						PILT039_APAC_bean.setRTD_SYS_ID(s.getInt(1));
					}	
					System.out.println("PILT039_APAC_bean.setRTD_SYS_ID"+PILT039_APAC_bean.getRTD_SYS_ID());
					System.out.println(" insert allowed===========");
					System.out.println("RTH Sys id for data table "+getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID());
					PILT039_APAC_bean.setRTD_RTH_SYS_ID(getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID());
					
				//pilt039_apac_bean.setWP_TOT_SELECTED_AMT()
					PILT039_APAC_bean.setRTD_RTH_SYS_ID(PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SYS_ID());
					PILT039_APAC_bean.setDOC_DT(new SimpleDateFormat("yyyy-MM-dd").format(PILT039_APAC_bean.getWP_DOC_DT()));
					System.out.println("dep"+PILT039_APAC_bean.getWP_DEP_LC_DEP_AMT());
					System.out.println("saum of lc"+helper.executeQuerydetail(compositeAction,PILT039_APAC_bean.getWP_DEP_LC_DEP_AMT()));
				
						PILT039_APAC_bean.setWP_TOT_SELECTED_AMT(helper.executeQuerydetail(compositeAction,PILT039_APAC_bean.getWP_DEP_LC_DEP_AMT()));
						PILT039_APAC_bean.setDOC_DT(new SimpleDateFormat("dd-MMM-yyyy").format(PILT039_APAC_bean.getWP_DOC_DT()));
				
						PILT039_APAC_bean.setWP_TOT_SELECTED_AMT(helper.executeQuerydetail(compositeAction,PILT039_APAC_bean.getWP_DEP_LC_DEP_AMT()));
						System.out.println("WP_TOT_SELECTED_AMT    "+PILT039_APAC_bean.getWP_TOT_SELECTED_AMT());
					
			new CRUDHandler().executeInsert(PILT039_APAC_bean,
					CommonUtils.getConnection());
			message = getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insert"));
			listdata.add(PILT039_APAC_bean);
		} else if (PILT039_APAC_bean.getROWID() != null && isUPDATE_ALLOWED()) {
			int sum=0;
			//pilt039_apac_bean.setWP_TOT_SELECTED_AMT()
			
					System.out.println(" update allowed===========");
			//helper.preUpdate(PILP205_ROP_BEAN);
					System.out.println("dep"+PILT039_APAC_bean.getWP_DEP_LC_DEP_AMT());
					System.out.println("saum of lc"+helper.executeQuerydetail(compositeAction,PILT039_APAC_bean.getWP_DEP_LC_DEP_AMT()));
					PILT039_APAC_bean.setDOC_DT(new SimpleDateFormat("dd-MMM-yyyy").format(PILT039_APAC_bean.getWP_DOC_DT()));
						PILT039_APAC_bean.setWP_TOT_SELECTED_AMT(helper.executeQuerydetail(compositeAction,PILT039_APAC_bean.getWP_DEP_LC_DEP_AMT()));
				
						PILT039_APAC_bean.setWP_TOT_SELECTED_AMT(helper.executeQuerydetail(compositeAction,PILT039_APAC_bean.getWP_DEP_LC_DEP_AMT()));
						System.out.println("WP_TOT_SELECTED_AMT    "+PILT039_APAC_bean.getWP_TOT_SELECTED_AMT());
						
						
			new CRUDHandler().executeUpdate(PILT039_APAC_bean,
					CommonUtils.getConnection());
			message = Messages.getString(
					PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$update");
		}
		PILT039_APAC_bean.setRowSelected(true);
	} catch (Exception exc) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				"Record not Inserted/Updated :: " + exc.getMessage());
		getErrorMap().put("postRecord",
				"Record not Inserted/Updated :: " + exc.getMessage());
	}
}
*/


public void postInfo(ActionEvent event) { 
	getErrorMap().clear();
	getWarningMap().clear();
try {
	
	System.out.println("PILT039_APAC_bean.getROWID() "+PILT039_APAC_bean.getROWID() );
	System.out.println("PILT039_APAC_bean.getROWID()       "+PILT039_APAC_bean.getRTD_SYS_ID());
	if (PILT039_APAC_bean.getROWID() == null && isINSERT_ALLOWED()) {
		//helper.preInsert(PM_IL_COLUMN_BEAN, compositeAction);
		
		System.out.println("Inside rowid=null");
		String Query="SELECT PIL_PD_SYS_ID.NEXTVAL FROM DUAL";
		
		ResultSet s=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection());
		while(s.next()){
			PILT039_APAC_bean.setRTD_SYS_ID(s.getInt(1));
		}	
		System.out.println("PILT039_APAC_bean.setRTD_SYS_ID"+PILT039_APAC_bean.getRTD_SYS_ID());
		System.out.println(" insert allowed===========");
		System.out.println("RTH Sys id for data table "+getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID());
		PILT039_APAC_bean.setRTD_RTH_SYS_ID(getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID());
		PILT039_APAC_bean.setDOC_DT(new SimpleDateFormat(PELConstants.dbDateFormat).format(PILT039_APAC_bean.getWP_DOC_DT()));
		
		PILT039_APAC_bean.setWP_TOT_SELECTED_AMT(helper.executeQuerydetail(compositeAction,PILT039_APAC_bean.getWP_DEP_LC_DEP_AMT()));
		System.out.println("WP_TOT_SELECTED_AMT    "+PILT039_APAC_bean.getWP_TOT_SELECTED_AMT());
		new CRUDHandler().executeInsert(PILT039_APAC_bean,
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
			
		listdata.add(PILT039_APAC_bean);
	} else if (PILT039_APAC_bean.getROWID() != null && isUPDATE_ALLOWED()) {
		//helper.preUpdate(compositeAction);
		System.out.println("Inside rowid!=null");
		
		if(PILT039_APAC_bean.getWP_DOC_DT() != null)
		PILT039_APAC_bean.setDOC_DT(new SimpleDateFormat("dd-MMM-yyyy").format(PILT039_APAC_bean.getWP_DOC_DT()));
		
		/*PILT039_APAC_bean.setWP_TOT_SELECTED_AMT(helper.executeQuerydetail(compositeAction,PILT039_APAC_bean.getWP_DEP_LC_DEP_AMT()));*/

		
		System.out.println("WP_TOT_SELECTED_AMT    "+PILT039_APAC_bean.getWP_TOT_SELECTED_AMT());
		System.out.println("WP_TOT_SELECTED_AMT    "+PILT039_APAC_bean.getROWID());
		System.out.println("getRTD_SYS_ID    "+PILT039_APAC_bean.getRTD_SYS_ID());
		
		new CRUDHandler().executeUpdate(PILT039_APAC_bean,
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

	PILT039_APAC_bean.setRowSelected(true);
} catch (Exception exc) {

	
	exc.printStackTrace();
	getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			exc.getMessage());
	getErrorMap().put("post", exc.getMessage());
}
}



private void resetAllComponentInfo()
{
/*	COMP_M_ACC_YEAR.resetValue();
	
	COMP_M_DEP_LC_DEP_AMT.resetValue();
	COMP_M_DOC_DT.resetValue();
	COMP_M_DOC_NO.resetValue();
	COMP_M_RTD_TXN_CODE.resetValue();*/
	COMP_M_TOT_RTD_DEP_LC_AMT.resetValue();
	COMP_RTD_DEP_LC_AMT.resetValue();
	
	/*COMP_M_TOT_SELECTED_AMT.resetValue();
	COMP_RTH_SRC_POL_NO.resetValue();
	COMP_RTH_APPRV_DT.resetValue();*/
	
	COMP_M_RTD_TXN_CODE.resetValue();
	COMP_M_DOC_NO.resetValue();
	COMP_M_ACC_YEAR.resetValue();
	COMP_M_DEP_LC_DEP_AMT.resetValue();
	COMP_RTD_DEP_LC_AMT.resetValue();
	
	COMP_RTD_TRNS_YN.resetValue();
	COMP_M_TOT_RTD_DEP_LC_AMT.resetValue();
	COMP_M_TOT_SELECTED_AMT.resetValue();
	COMP_RTD_REASON_CODE.resetValue();
	COMP_RTD_TXN_CODE.resetValue();
	
	COMP_RTD_DOC_NO.resetValue();
	COMP_RTD_DOC_DT.resetValue();
	COMP_RTD_ACNT_YR.resetValue();
	COMP_RTD_REV_REMARKS.resetValue();
}



public HtmlInputText getCOMP_M_DOC_NO() {
	return COMP_M_DOC_NO;
}

public void setCOMP_M_DOC_NO(HtmlInputText cOMP_M_DOC_NO) {
	COMP_M_DOC_NO = cOMP_M_DOC_NO;
}

public HtmlCalendar getCOMP_M_DOC_DT() {
	return COMP_M_DOC_DT;
}

public void setCOMP_M_DOC_DT(HtmlCalendar cOMP_M_DOC_DT) {
	COMP_M_DOC_DT = cOMP_M_DOC_DT;
}

public HtmlInputText getCOMP_M_ACC_YEAR() {
	return COMP_M_ACC_YEAR;
}

public void setCOMP_M_ACC_YEAR(HtmlInputText cOMP_M_ACC_YEAR) {
	COMP_M_ACC_YEAR = cOMP_M_ACC_YEAR;
}

public HtmlInputText getCOMP_M_DEP_LC_DEP_AMT() {
	return COMP_M_DEP_LC_DEP_AMT;
}

public void setCOMP_M_DEP_LC_DEP_AMT(HtmlInputText cOMP_M_DEP_LC_DEP_AMT) {
	COMP_M_DEP_LC_DEP_AMT = cOMP_M_DEP_LC_DEP_AMT;
}




/*for Buttuon*/
public void callProcess() throws Exception
{	Connection con = null;
	con = CommonUtils.getConnection();
	CRUDHandler handler = new CRUDHandler();
	ResultSet resultset=null;
	
	CommonUtils.clearMaps(this);
	try
	{
	int sysid=PILT039_APAC_bean.getRTD_SYS_ID();
	String value=Integer.toString(sysid);
	String C1 ="SELECT RTH_SRC_POL_SYS_ID,RTH_SRC_POL_NO FROM PT_IL_RECEIPT_TRANS_HDR WHERE RTH_SRC_POL_SYS_ID=? AND RTH_SRC_POL_NO=?";
	
	//callE_ProcessProc(String.valueOf(PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_SYS_ID()),PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_NO(),value);
		callE_ProcessProc(String.valueOf(PT_IL_RECEIPT_TRANS_HDR_BEAN.getWP_CUST_CODE()));
	
	resultset=handler.executeSelectStatement(C1, con, new Object[] {compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_SYS_ID(),
			compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_NO()});
	while(resultset.next()){
		compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().setRTH_SRC_POL_SYS_ID(resultset.getInt("RTH_SRC_POL_SYS_ID"));
		compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().setRTH_SRC_POL_NO(resultset.getString("RTH_SRC_POL_NO"));
	
		int src_pol_sys_id=compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_SYS_ID();
		String RTH_SRC_POL_SYS_ID=Integer.toString(src_pol_sys_id);
		String RTH_SRC_POL_NO=compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_NO();
		 PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_CR_UID(CommonUtils.getControlBean().getUSER_ID());
			PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_CR_DT(new CommonUtils().getCurrentDate());
		
	//	compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().setR
	/*	callE_ProcessProc(RTH_SRC_POL_SYS_ID,RTH_SRC_POL_NO,value);*/
		
		PT_IL_RECEIPT_TRANS_HDR BEAN=compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN();
		if(BEAN.getRTH_SYS_ID()==0)
		{
			getErrorMap().put("current","No Records are found");
			/*throw new Exception((Messages.getString(
					PELConstants.pelErrorMessagePath, "3206",
					new Object[] { "No Records are found" })));*/
			
		}
		else 
		{
			getWarningMap().put("current","Processed records successfully");
			getCOMP_UI_PROCESS().setDisabled(true);// added by sankaraNarayanan for Process button Disableing after approvel  for :ZBILQC-1720396 on 03-03-2017
			helper.executeQuerydetail(compositeAction);
			System.out.println("getListdata         "+compositeAction.getPILT039_APAC_ACTION_BEAN().getListdata());
			//throw new Exception( "Processed records successfully" );
					
		}
		
		}
	
	getWarningMap().put("current","Processed records successfully");
	
	}
	catch(Exception e)
	{
		getErrorMap().put(
				"callProcess",
				e.getMessage());
	}
	}

/*public void callE_ProcessProc(String RTH_SRC_POL_SYS_ID,String RTH_SRC_POL_NO,String value) throws Exception {    
	Connection con=CommonUtils.getConnection();
	try
	{
	ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",current);
	OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",RTH_SRC_POL_SYS_ID);
	OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",RTH_SRC_POL_NO);
	OracleParameter param3 = new OracleParameter("OUT1", "INT", "OUT",value);
	OracleParameter param4 = new OracleParameter("IN4", "INT", "IN",null);
	below line commented by gopi for call id ZBILQC-1719380 on 25/01/17
	//OracleParameter param5 = new OracleParameter("OUT2", "STRING", "OUT",null);
    parameterList.add(param1);
    parameterList.add(param2);
    parameterList.add(param3);
    parameterList.add(param4);
    below line commented by gopi for call id ZBILQC-1719380 on 25/01/17
    //parameterList.add(param5);
    OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.execute(parameterList, con,
            "P9ILPK_RECEIPT_TRANSFER. INS_RECEIPT_EXCESS_PREM");
    CommonUtils.getConnection().commit();
    Iterator<OracleParameter> iterator = outputList.iterator();
    while (iterator.hasNext()) {
        OracleParameter oracleParameter = iterator.next();
        System.out.println("Output value:::" + oracleParameter.getValue());
        String outputValue = null,flag = null;
        if(oracleParameter.getFieldName() != null)
        {
        	if(oracleParameter.getFieldName().equals("OUT1"))
        	{
        		outputValue = oracleParameter.getValue();
        	}
        	else if(oracleParameter.getFieldName().equals("OUT2"))
        	{
        		flag = oracleParameter.getValue();
        	}
        }
        System.out.println("outputValue     "+outputValue);
        System.out.println("flag     "+flag);
        if(outputValue!= null)
        {
        	if(!outputValue.equals("0"))
        	{
        		PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_SYS_ID(Integer.valueOf(outputValue));		
        	}
        }
        
        
    }   	
    System.out.println("PT_IL_RECEIPT_TRANS_HDR_BEAN         "+PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SYS_ID());
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
}*/
public void callE_ProcessProc(String WP_CUST_CODE) throws Exception {    
	Connection con=CommonUtils.getConnection();
	try
	{
	ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	/*OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",current);*/
	OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",WP_CUST_CODE);
	OracleParameter param2 = new OracleParameter("OUT1", "INT", "OUT",null);
	OracleParameter param3 = new OracleParameter("IN4", "INT", "IN",null);
	/*below line commented by gopi for call id ZBILQC-1719380 on 25/01/17*/
	//OracleParameter param5 = new OracleParameter("OUT2", "STRING", "OUT",null);
    parameterList.add(param1);
    parameterList.add(param2);
    parameterList.add(param3);
    /*below line commented by gopi for call id ZBILQC-1719380 on 25/01/17*/
    //parameterList.add(param5);
    OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.execute(parameterList, con,
            "P9ILPK_RECEIPT_TRANSFER. INS_RECEIPT_EXCESS_PREM");
    
     /*Modified Query by saritha on 06-02-2018 for Process button click records table level inserted,but does not click save button as per ajay sir sugg.*/ 
    //CommonUtils.getConnection().commit();
    /*End*/
    Iterator<OracleParameter> iterator = outputList.iterator();
    while (iterator.hasNext()) {
        OracleParameter oracleParameter = iterator.next(); 
        System.out.println("Output value:::" + oracleParameter.getValue());
        String outputValue = null,flag = null;
        if(oracleParameter.getFieldName() != null)
        {
        	if(oracleParameter.getFieldName().equals("OUT1"))
        	{
        		outputValue = oracleParameter.getValue();
        	}
        	else if(oracleParameter.getFieldName().equals("OUT2"))
        	{
        		flag = oracleParameter.getValue();
        	}
        }
        System.out.println("outputValue     "+outputValue);
        System.out.println("flag     "+flag);
        if(outputValue!= null)
        {
        	if(!outputValue.equals("0"))
        	{
        		PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_SYS_ID(Integer.valueOf(outputValue));		
        	}
        }
        
        
    }   	
    System.out.println("PT_IL_RECEIPT_TRANS_HDR_BEAN         "+PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SYS_ID());
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//ErrorHelpUtil.getErrorForProcedure(connection);
		throw new Exception(ErrorHelpUtil
				.getUserErrorMessageFromDBErrorMessage(e.getMessage()));
	}
}

public void APPROVE_EXCESS_REFUND(String RTH_SRC_POL_SYS_ID) throws Exception {    
	Connection con=CommonUtils.getConnection();
	
	ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	/*OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",current);*/
	OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",RTH_SRC_POL_SYS_ID);

    parameterList.add(param1);

   
    
    OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.execute(parameterList, con,
            "P9ILPK_RECEIPT_TRANSFER.APPROVE_EXCESS_REFUND");
    CommonUtils.getConnection().commit();
    Iterator<OracleParameter> iterator = outputList.iterator();
    while (iterator.hasNext()) {
        OracleParameter oracleParameter = iterator.next();
        System.out.println("Output value:::" + oracleParameter.getValue());
    }   	
}



public void callApprove() throws Exception
{	
	CRUDHandler handler = new CRUDHandler();
	String C1 =" SELECT  'X' FROM    PT_IL_RECEIPT_TRANS_DTL WHERE   RTD_RTH_SYS_ID =?  AND NVL( RTD_TRNS_YN,'N') ='Y' AND ((RTD_REASON_CODE) IS  NULL OR RTD_REV_REMARKS  IS  NULL)";
	String C2="SELECT 'X' FROM PT_IL_RECEIPT_TRANS_DTL WHERE RTD_RTH_SYS_ID =? AND   NVL( RTD_TRNS_YN,'N') ='Y'"; 
	Connection con = null;
	con = CommonUtils.getConnection();
	ResultSet resultset1=null;
	ResultSet resultset2=null;
	
	PILT039_APAC_BEAN OBJ=compositeAction.getPILT039_APAC_ACTION_BEAN().getPILT039_APAC_bean();
	System.out.println("OBJ.getRTD_RTH_SYS_ID()        "+OBJ.getRTD_RTH_SYS_ID());
	if(OBJ.getStatus() != null && OBJ.getStatus().equals("Y"))
	{
		resultset2=handler.executeSelectStatement(C2, con,new Object[]{OBJ.getRTD_RTH_SYS_ID()});	
		if(resultset2.next()){	
			resultset1=handler.executeSelectStatement(C1, con,new Object[]{OBJ.getRTD_RTH_SYS_ID()});
			if(resultset1.next()){
				/*throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "Enter the required fields" })));*/
				System.out.println("Reason Code & Remarks must not be Empty");
				getErrorMap().put("current","Reason Code & Remarks must not be Empty");
			}
			else{
				String RTH_SRC_POL_SYS_ID=Long.toString(OBJ.getRTD_RTH_SYS_ID());
				APPROVE_EXCESS_REFUND(RTH_SRC_POL_SYS_ID);
				helper.executeQuerydetail(compositeAction);
				getWarningMap().put("current","Approved Sucessfully.");
				getWarningMap().put("APPROVE","Approved Sucessfully.");
				getCOMP_UI_APPRO().setDisabled(true);	//added by sankaraNarayanan for Process button Disableing after approvel  for :ZBILQC-1720396 on 03-03-2017
				
			}
			
			
		}
		else{	
			getErrorMap().put("current","No records found");
			/*throw new Exception((Messages.getString(
					PELConstants.pelErrorMessagePath, "69009",
					new Object[] { "No records found " })));*/
			
			
		}
		
	}else
		{
		/*throw new Exception((Messages.getString(
				PELConstants.pelErrorMessagePath, "3206",
				new Object[] { "Please Save the Transaction" })));*/
		getErrorMap().put("current","Please Save the Transaction");
		}
	}



/*public void callE_ApproveProc(String RTH_SRC_POL_SYS_ID,String RTH_SRC_POL_NO,String value) throws Exception {    
	Connection con=CommonUtils.getConnection();
	
	ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",current);
	OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",RTH_SRC_POL_SYS_ID);
	OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",RTH_SRC_POL_NO);
	OracleParameter param3 = new OracleParameter("IN3", "INT", "OUT",value);
	OracleParameter param4 = new OracleParameter("IN4", "INT", "IN",null);
    parameterList.add(param1);
    parameterList.add(param2);
    parameterList.add(param3);
    parameterList.add(param4);
    OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.execute(parameterList, con,
            "P9ILPK_RECEIPT_TRANSFER. INS_RECEIPT_EXCESS_PREM");
    CommonUtils.getConnection().commit();
    Iterator<OracleParameter> iterator = outputList.iterator();
    while (iterator.hasNext()) {
        OracleParameter oracleParameter = iterator.next();
        System.out.println("Output value:::" + oracleParameter.getValue());
    }   	
}
*/


public void validatePolNo(FacesContext context,
		UIComponent component, Object value){
	ResultSet resultSet=null;
	ResultSet resultSet1=null;
	Connection connection=null; 
	try{
		
		String PolNo = (String)value;
		System.out.println(PolNo);
		System.out.println("Inside  validatePolNo  "+compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_NO());
		
		String query="SELECT POL_SYS_ID,POL_CUST_CODE FROM   PT_IL_POLICY  WHERE  POL_NO IN (SELECT DEP_REF_NO FROM   PT_IL_DEPOSIT WHERE  NVL(DEP_REC_REV_YN,'N') =  'N' ) "+
			    " AND  ((POL_DS_TYPE  =  '1' AND  NVL(POL_CONVERT_YN,'N')  = 'N' ) "+
			    " OR   (POL_DS_TYPE   =  '2' AND   POL_APPRV_STATUS = 'A'))"+
			    " AND  POL_NO         = ? "+" UNION ALL SELECT POL_SYS_ID,POL_CUST_CODE"+
			    " FROM PT_IL_POLICY WHERE POL_PROP_NO IN(SELECT DEP_REF_NO"+" FROM   PT_IL_DEPOSIT WHERE  NVL(DEP_REC_REV_YN,'N') =  'N' ) "+"AND POL_DS_TYPE   =  '2'"+
			    "AND POL_NO =?";
		connection=CommonUtils.getConnection();
		System.out.println("QUERY:**" +query);
		/*resultSet=new CRUDHandler().executeSelectStatement(query, connection,new Object[]{PolNo,PolNo});*/
		resultSet = new CRUDHandler().executeSelectStatement(
				query, connection,new Object[]{PolNo,PolNo});
		/*boolean rFlag=resultSet.next();
		System.out.println("Resultset flag-->"+rFlag);*/
		while(resultSet.next())
		{
			System.out.println("Inside while");
			PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_SRC_POL_SYS_ID(resultSet.getInt("POL_SYS_ID"));
			System.out.println("SYS ID   "+PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_SYS_ID());
			PT_IL_RECEIPT_TRANS_HDR_BEAN.setWP_CUST_CODE(resultSet.getString("POL_CUST_CODE"));
			System.out.println("CUST_CODE   "+PT_IL_RECEIPT_TRANS_HDR_BEAN.getWP_CUST_CODE());
			/*PT_IL_RECEIPT_TRANS_HDR_BEAN.setWP_CUST_CODE_DESC(resultSet.getString("POL_CUST_CODE"));
			System.out.println("CUST DESC  "+PT_IL_RECEIPT_TRANS_HDR_BEAN.getWP_CUST_CODE_DESC());*/
		}
	
		
		//String query1=" SELECT CUST_NAME FROM   PM_CUSTOMER WHERE  CUST_CODE = '"+PT_IL_RECEIPT_TRANS_HDR_BEAN.getWP_CUST_CODE()+"'";
		String query1=" SELECT CUST_NAME FROM   PM_CUSTOMER WHERE  CUST_CODE = ?";
		System.out.println("Query 1"+query1);
		
		resultSet1=new CRUDHandler().executeSelectStatement(query1, connection,new Object[]{PT_IL_RECEIPT_TRANS_HDR_BEAN.getWP_CUST_CODE()});
		System.out.println("result settt+++++++++++++"+!resultSet1.equals(null));
		while(resultSet1.next())
		{
			PT_IL_RECEIPT_TRANS_HDR_BEAN.setWP_CUST_CODE_DESC(resultSet1.getString("CUST_NAME"));
			System.out.println("CUST_NAME  "+PT_IL_RECEIPT_TRANS_HDR_BEAN.getWP_CUST_CODE_DESC());
		}
		
		
		
		COMP_M_CUST_CODE.resetValue();
		COMP_M_CUST_DESC.resetValue();
		/*String Query1="SELECT DEP_SYS_ID,DEP_TXN_CODE,DEP_DOC_NO,DEP_DOC_DT,DEP_ACNT_YEAR,DEP_LC_DEP_AMT FROM PT_IL_DEPOSIT WHERE DEP_SYS_ID = '87472'";
		 resultSet1=new CRUDHandler().executeSelectStatement(Query1,connection,new Object[]{});
			while(resultSet1.next()){
				System.out.println("Inside second resultset");
				
				PILT039_APAC_bean.setWP_DEP_LC_DEP_AMT(resultSet1.getInt("DEP_LC_DEP_AMT"));
				System.out.println("Dep Amount"+resultSet1.getInt("DEP_LC_DEP_AMT"));
				
				PILT039_APAC_bean.setWP_DOC_NO(resultSet1.getString("DEP_DOC_NO"));
				System.out.println("Doc Not"+resultSet1.getString("DEP_DOC_NO"));
				PILT039_APAC_bean.setWP_DOC_DT(resultSet1.getDate("DEP_DOC_DT"));
				
				
				System.out.println("Doc Date"+resultSet1.getDate("DEP_DOC_DT"));
				PILT039_APAC_bean.setWP_ACC_YEAR(resultSet1.getInt("DEP_ACNT_YEAR"));
				System.out.println("Doc Date"+resultSet1.getInt("DEP_ACNT_YEAR"));
				PILT039_APAC_bean.setWP_RTD_TXN_CODE(resultSet1.getString("DEP_TXN_CODE"));
				System.out.println("Doc Date"+resultSet1.getString("DEP_TXN_CODE"));
				
				
			}
			COMP_M_ACC_YEAR.resetValue();			
			COMP_M_DEP_LC_DEP_AMT.resetValue();
			COMP_M_DOC_DT.resetValue();
			COMP_M_DOC_NO.resetValue();
			COMP_M_RTD_TXN_CODE.resetValue();*/
			
			
			
		System.out.println("outside while");
		
		
	}catch (Exception e) {
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}
public void validateRTH_APPRV_DT(FacesContext context,
		UIComponent component, Object value){
	try{
		
		PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_APPRV_DT(new CommonUtils().getCurrentDate());
		
	}catch (Exception e) {
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}


	/*end*/
	
	private HtmlTab COMP_MORE_INFO_1;
	private HtmlTab COMP_MORE_INFO_2;
	private HtmlTabPanel COMP_TAB_PANEL;
	
public void inisiateComponent(){

	COMP_TAB_PANEL =new HtmlTabPanel();			
	COMP_MORE_INFO_1=new HtmlTab();
	COMP_MORE_INFO_2=new HtmlTab();
COMP_RTH_APPRV_DT=new HtmlCalendar();
COMP_RTH_SRC_POL_NO=new HtmlInputText();
COMP_M_CUST_CODE=new HtmlInputText();

COMP_M_CUST_DESC=new HtmlInputText();

COMP_M_RTD_TXN_CODE=new HtmlInputText();
COMP_M_DOC_NO=new HtmlInputText();
COMP_M_DOC_DT=new HtmlCalendar();
COMP_M_ACC_YEAR=new HtmlInputText();
COMP_M_DEP_LC_DEP_AMT=new HtmlInputText();

COMP_RTD_DEP_LC_AMT=new HtmlInputText();
COMP_RTD_TRNS_YN=new HtmlSelectOneMenu();
COMP_M_TOT_RTD_DEP_LC_AMT=new HtmlInputText();

COMP_M_TOT_SELECTED_AMT=new HtmlInputText();
		
}

public String backToSearch() {
	return SearchConstants.BACK_TO_SEARCH_PAGE;
}

	
	public void onLoad(PhaseEvent event) {
		try {
			 
			if (isBlockFlag()) {
				System.out.println("ONLOAD CALLED");
				/*added by nadhiya*/
				new PILT039_APAC_TAB1DELEGATE().executeSelectStatementheader(compositeAction);
				
				
				/*end*/
				if(PT_IL_RECEIPT_TRANS_HDR_BEAN.getROWID()!=null)
				{
					 helper.executeQueryPaid(compositeAction); 
				/*added by nadhiya*/
				helper.executeQuerydetail(compositeAction);
				/*end*/
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_APPRV_DT(new Date());
				}
				else{
					PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_APPRV_DT(new Date());
				}
				compositeAction.getPILT039_APAC_ACTION_BEAN().getPILT039_APAC_bean().setStatus("N");
				
				System.out.println("compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_APPRV_STATUS()      "
				+compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_APPRV_STATUS());
				
				if(compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_APPRV_STATUS() != null)
				{
					if(compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_APPRV_STATUS().equals("Y"))
					{
						getCOMP_UI_APPRO().setDisabled(true);		
						getCOMP_UI_PROCESS().setDisabled(true);// added by sankaraNarayanan for Process button Disableing after approvel  for :ZBILQC-1720396 on 03-03-2017
					}
					//else if(compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_APPRV_STATUS().equals("N")) 
					else{
						getCOMP_UI_APPRO().setDisabled(false);
						getCOMP_UI_PROCESS().setDisabled(false); // added by sankaraNarayanan for Process button Disableing after approvel  for :ZBILQC-1720396 on 03-03-2017
					}
				}
				
				 System.out.println("PILT039_APAC_bean in Onload    "+PILT039_APAC_bean.getRTD_SYS_ID());
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public void query() throws Exception{
		Connection connection=CommonUtils.getConnection();
		ResultSet resultSet1=null;
		String Query1="SELECT DEP_SYS_ID,DEP_TXN_CODE,DEP_DOC_NO,DEP_DOC_DT,DEP_ACNT_YEAR,DEP_LC_DEP_AMT FROM PT_IL_DEPOSIT WHERE DEP_REF_NO= ? ";
		 resultSet1=new CRUDHandler().executeSelectStatement(Query1,connection,new Object[]{PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_NO()});
			while(resultSet1.next()){
				System.out.println("Inside second resultset");
				
				PILT039_APAC_bean.setWP_DEP_LC_DEP_AMT(resultSet1.getInt("DEP_LC_DEP_AMT"));
				System.out.println("Dep Amount"+resultSet1.getInt("DEP_LC_DEP_AMT"));
				
				PILT039_APAC_bean.setWP_DOC_NO(resultSet1.getString("DEP_DOC_NO"));
				System.out.println("Doc Not"+resultSet1.getString("DEP_DOC_NO"));
				PILT039_APAC_bean.setWP_DOC_DT(resultSet1.getDate("DEP_DOC_DT"));
				
				
				System.out.println("Doc Date"+resultSet1.getDate("DEP_DOC_DT"));
				PILT039_APAC_bean.setWP_ACC_YEAR(resultSet1.getInt("DEP_ACNT_YEAR"));
				System.out.println("Doc Date"+resultSet1.getInt("DEP_ACNT_YEAR"));
				PILT039_APAC_bean.setWP_RTD_TXN_CODE(resultSet1.getString("DEP_TXN_CODE"));
				System.out.println("Doc Date"+resultSet1.getString("DEP_TXN_CODE"));
				
				
			}
	}

	
	public void displayRecordsPaid() {
		CommonUtils.clearMaps(this);
		try {
			
			System.out.println("inside display record");
			
			
			resetSelectedRow();
			PILT039_APAC_bean = (PILT039_APAC_BEAN) dataTable
					.getRowData();
			PILT039_APAC_bean.setRowSelected(true);
			System.out.println("RTD_REV_REMARKS       "+PILT039_APAC_bean.getRTD_REV_REMARKS());
			
			resetAllComponent();
			
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecordsPaid", exc.getMessage());
		}

	}
	
	
	
	
	 
	 
	 
	 
	 
	 
	/* public ArrayList<LovBean> prepareSuggestionRTD_REASON_CODE_DESC(Object object){
			
			ArrayList<LovBean> lovList = new ArrayList<LovBean>();
			ListItemUtil itemUtil = new ListItemUtil();
			String currentValue = (String) object;
			String moduleName = "PILT039_APAC";
			String blockName = "PT_IL_RECEIPT_TRANS_DTL";
			String fieldName = "RTD_REASON_CODE";
			

			try {
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
				lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, null,null,null, null, null, currentValue);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return lovList;
		}*/

		
	 public ArrayList<com.iii.premia.common.bean.LovBean> prepareSuggestionRTD_REASON_CODE_DESC(
				Object currValue) {
			System.out.println("Welcome to lovPOL_PROD_CODE method");
			ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
			ListItemUtil listitemutil = new ListItemUtil();
			try {
				 suggestionList = listitemutil.P_CALL_LOV("PILT039_APAC",
						"PT_IL_RECEIPT_TRANS_DTL", "RTD_REASON_CODE", "REV_REASON", null, null, null,
						null, (String) currValue); 
				System.out.println("suggestionList     "+suggestionList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return suggestionList;
		}	
	 public void resetAllComponent() {
		 
		 COMP_RTD_REASON_CODE.resetValue();
		 COMP_RTD_REASON_CODE_DESC.resetValue();
		 COMP_RTD_TXN_CODE.resetValue();
		 COMP_RTD_DOC_NO.resetValue();
		 COMP_RTD_DOC_DT.resetValue();
		 COMP_RTD_ACNT_YR.resetValue();
		 COMP_RTD_REV_REMARKS.resetValue();
	 }

	 private void resetSelectedRow() {
			System.out.println("indide of resetSelectedRow++++++++++++++");
			
			Iterator<PILT039_APAC_BEAN> PM_IL_COM_LINK_ITR = PILT1993_BEAN_CLASS_DATATABLE.iterator();
			while (PM_IL_COM_LINK_ITR.hasNext()) {
				PM_IL_COM_LINK_ITR.next().setRowSelected(false);
			}
		}

	 public void addRow(ActionEvent event) {
			try {
				System.out.println("ADD CALLED");
				if (isINSERT_ALLOWED()) {
					System.out.println("INSERT");
					PILT039_APAC_bean=new PILT039_APAC_BEAN();
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
				System.out.println("insert delete rew");
				
				if (isDELETE_ALLOWED()) {
					System.out.println("HAI");
					new CRUDHandler().executeDelete(PILT039_APAC_bean,
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
					PILT1993_BEAN_CLASS_DATATABLE.remove(PILT039_APAC_bean);
					if (PILT1993_BEAN_CLASS_DATATABLE.size() > 0) {

						PILT039_APAC_bean = PILT1993_BEAN_CLASS_DATATABLE.get(0);
					} else if (PILT1993_BEAN_CLASS_DATATABLE.size() == 0) {

						addRow(null);
					}

					resetAllComponent();
					PILT039_APAC_bean.setRowSelected(true);
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
	    	getErrorMap().clear();
			getWarningMap().clear();
		try {
			
			System.out.println("PILT039_APAC_bean.getROWID() "+PILT039_APAC_bean.getROWID() );
			if (PILT039_APAC_bean.getROWID() == null && isINSERT_ALLOWED()) {
				//helper.preInsert(PM_IL_COLUMN_BEAN, compositeAction);
				
				System.out.println("Inside rowid=null");
				String Query="SELECT PIL_PD_SYS_ID.NEXTVAL FROM DUAL";
				
				ResultSet s=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection());
				while(s.next()){
					PILT039_APAC_bean.setRTD_SYS_ID(s.getInt(1));
				}	
				System.out.println("PILT039_APAC_bean.setRTD_SYS_ID"+PILT039_APAC_bean.getRTD_SYS_ID());
				System.out.println(" insert allowed===========");
				System.out.println("RTH Sys id for data table "+getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID());
				PILT039_APAC_bean.setRTD_RTH_SYS_ID(getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID());
				PILT039_APAC_bean.setPOL_STRT_DATE(new SimpleDateFormat("yyyy-MM-dd").format(PILT039_APAC_bean.getRTD_DOC_DT()));
				new CRUDHandler().executeInsert(PILT039_APAC_bean,
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
					
				PILT1993_BEAN_CLASS_DATATABLE.add(PILT039_APAC_bean);
			} else if (PILT039_APAC_bean.getROWID() != null && isUPDATE_ALLOWED()) {
				//helper.preUpdate(compositeAction);
				System.out.println("Inside rowid!=null");
				PILT039_APAC_bean.setPOL_STRT_DATE(new SimpleDateFormat("dd-MMM-yyyy").format(PILT039_APAC_bean.getRTD_DOC_DT()));
				new CRUDHandler().executeUpdate(PILT039_APAC_bean,
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

			PILT039_APAC_bean.setRowSelected(true);
		} catch (Exception exc) {
	
			
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("post", exc.getMessage());
		}
	}
	 
	/* added by nadhiya*/
	 
	 public void saveRecord() {
			String message = null;
			CommonUtils.clearMaps(this);
			try {
				if (getPILT039_APAC_bean().getROWID() != null) {
					if(isUPDATE_ALLOWED()){
						 PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_CR_UID(CommonUtils.getControlBean().getUSER_ID());
							PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_CR_DT(new CommonUtils().getCurrentDate());
					new CRUDHandler().executeUpdate(getPT_IL_RECEIPT_TRANS_HDR_BEAN(),
							CommonUtils.getConnection());
					getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
					getWarningMap().put("togle", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
					message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
					}
				} else {
					if(isINSERT_ALLOWED()){
						//PILM086_BEAN.setBRH_SYS_ID(PM_RBH_SYS_ID.NEXTVAL);
						
					 PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_CR_UID(CommonUtils.getControlBean().getUSER_ID());
						PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_CR_DT(new CommonUtils().getCurrentDate());
						
						
					String Query="SELECT PIL_PD_SYS_ID.NEXTVAL FROM DUAL";
					
					ResultSet s=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection());
					while(s.next()){
						PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_SYS_ID(s.getInt(1));
					}		
				//	PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_APPRV_DT(new CommonUtils().getCurrentDate());
					
					new CRUDHandler().executeInsert(getPT_IL_RECEIPT_TRANS_HDR_BEAN(),
							CommonUtils.getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
					getWarningMap().put("togle",Messages.getString(
							PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
					message = Messages.getString("messageProperties","errorPanel$message$save");
					}
					}
				
				CommonUtils.getConnection().commit();
				compositeAction.getPILT039_APAC_ACTION_BEAN().getPILT039_APAC_bean().setStatus("Y");
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SAVE", e.getMessage());
			}
		}
	 
	 /*end*/
	 
	/* public void saveRecord() {

			System.out.println("INSIDE saveRecord");


			String message = null;
			CommonUtils.clearMaps(this);
			//PM_IL_CURRENCY_ACTION actionBean = (PM_IL_CURRENCY_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_CURRENCY_ACTION");

			try {
				CommonUtils.getConnection().commit();


			}catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SAVE", e.getMessage());
			}

	 }*/
	 
	
}
