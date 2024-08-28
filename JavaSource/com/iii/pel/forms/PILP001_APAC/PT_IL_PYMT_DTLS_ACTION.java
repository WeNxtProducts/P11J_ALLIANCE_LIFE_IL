package com.iii.pel.forms.PILP001_APAC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlComboBox;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PYMT_DTLS_ACTION extends CommonAction{

	Map<String, Object> session =   FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	Connection connection = null;

	CRUDHandler handler = null;

	FacesContext ctx= FacesContext.getCurrentInstance();

	public UIDataTable uiDataTable;

	public Connection con=null;

	private HtmlOutputLabel COMP_PD_SR_NO_LABEL;

	private HtmlInputText COMP_PD_SR_NO;

	private HtmlOutputLabel COMP_PD_PAY_MODE_LABEL;

	private HtmlComboBox COMP_PD_PAY_MODE;

	private HtmlOutputLabel COMP_PD_FC_AMT_LABEL;

	private HtmlInputText COMP_PD_FC_AMT;

	private HtmlOutputLabel COMP_PD_LC_AMT_LABEL;

	private HtmlInputText COMP_PD_LC_AMT;

	private HtmlOutputLabel COMP_PD_PAID_FOR_LABEL;

	private HtmlComboBox COMP_PD_PAID_FOR;

	private HtmlOutputLabel COMP_PD_CHQ_NO_LABEL;

	private HtmlInputText COMP_PD_CHQ_NO;

	private HtmlOutputLabel COMP_PD_CHQ_DT_LABEL;

	private HtmlCalendar COMP_PD_CHQ_DT;

	private HtmlOutputLabel COMP_PD_DPD_REF_ID_LABEL;

	private HtmlInputText COMP_PD_DPD_REF_ID;

	private HtmlOutputLabel COMP_PD_CR_ADVICE_NO_LABEL;

	private HtmlInputText COMP_PD_CR_ADVICE_NO;

	private HtmlOutputLabel COMP_PD_PAYIN_DATE_LABEL;

	private HtmlCalendar COMP_PD_PAYIN_DATE;

	private HtmlOutputLabel COMP_PD_BANK_NAME_LABEL;

	private HtmlInputText COMP_PD_BANK_NAME;

	private HtmlInputText COMP_UI_M_BANK_NAME_DESC;

	private HtmlOutputLabel COMP_PD_BRANCH_NAME_LABEL;

	private HtmlInputText COMP_PD_BRANCH_NAME;

	private HtmlOutputLabel COMP_PD_CUST_NAME_LABEL;

	private HtmlInputText COMP_PD_CUST_NAME;

	private HtmlOutputLabel COMP_PD_ADDR_01_LABEL;

	private HtmlInputText COMP_PD_ADDR_01;

	private HtmlOutputLabel COMP_PD_ADDR_02_LABEL;

	private HtmlInputText COMP_PD_ADDR_02;

	private HtmlOutputLabel COMP_PD_ADDR_03_LABEL;

	private HtmlInputText COMP_PD_ADDR_03;

	private HtmlOutputLabel COMP_PD_REMARKS_LABEL;

	private HtmlInputText COMP_PD_REMARKS;

	private HtmlOutputLabel COMP_PD_CURR_CODE_LABEL;

	private HtmlInputText COMP_PD_CURR_CODE;

	private HtmlOutputLabel COMP_UI_M_PD_CURR_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PD_CURR_CODE_DESC;

	private HtmlOutputLabel COMP_PD_LC_CHARGE_LABEL;

	private HtmlInputText COMP_PD_LC_CHARGE;

	private HtmlOutputLabel COMP_PD_FC_CHARGE_LABEL;

	private HtmlInputText COMP_PD_FC_CHARGE;

	private HtmlCommandButton COMP_UI_M_BUT_PD_CUST_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_PD_ADDR_01;

	private HtmlCommandButton COMP_UI_M_BUT_PD_ADDR_02;

	private HtmlCommandButton COMP_UI_M_BUT_PD_ADDR_03;

	private HtmlCommandButton COMP_UI_M_BUT_PD_REMARKS;

	private HtmlCommandButton COMP_UI_M_BUT_PD_BANK_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_PD_BRANCH_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_MORE;

	private HtmlCommandButton COMP_UI_M_BUT_BANK_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_DPD_REF_ID;

	public List list = new ArrayList();

	private PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN;

	public PILP001_APAC_COMPOSITE_ACTION compositeAction;

	public PT_IL_PYMT_DTLS_ACTION() {
		PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();
	}

	public HtmlOutputLabel getCOMP_PD_SR_NO_LABEL() {
		return COMP_PD_SR_NO_LABEL;
	}

	public HtmlInputText getCOMP_PD_SR_NO() {
		return COMP_PD_SR_NO;
	}

	public void setCOMP_PD_SR_NO_LABEL(HtmlOutputLabel COMP_PD_SR_NO_LABEL) {
		this.COMP_PD_SR_NO_LABEL = COMP_PD_SR_NO_LABEL;
	}

	public void setCOMP_PD_SR_NO(HtmlInputText COMP_PD_SR_NO) {
		this.COMP_PD_SR_NO = COMP_PD_SR_NO;
	}

	public HtmlOutputLabel getCOMP_PD_PAY_MODE_LABEL() {
		return COMP_PD_PAY_MODE_LABEL;
	}

	public HtmlComboBox getCOMP_PD_PAY_MODE() {
		return COMP_PD_PAY_MODE;
	}

	public void setCOMP_PD_PAY_MODE_LABEL(HtmlOutputLabel COMP_PD_PAY_MODE_LABEL) {
		this.COMP_PD_PAY_MODE_LABEL = COMP_PD_PAY_MODE_LABEL;
	}

	public void setCOMP_PD_PAY_MODE(HtmlComboBox COMP_PD_PAY_MODE) {
		this.COMP_PD_PAY_MODE = COMP_PD_PAY_MODE;
	}

	public HtmlOutputLabel getCOMP_PD_FC_AMT_LABEL() {
		return COMP_PD_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PD_FC_AMT() {
		return COMP_PD_FC_AMT;
	}

	public void setCOMP_PD_FC_AMT_LABEL(HtmlOutputLabel COMP_PD_FC_AMT_LABEL) {
		this.COMP_PD_FC_AMT_LABEL = COMP_PD_FC_AMT_LABEL;
	}

	public void setCOMP_PD_FC_AMT(HtmlInputText COMP_PD_FC_AMT) {
		this.COMP_PD_FC_AMT = COMP_PD_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_PD_LC_AMT_LABEL() {
		return COMP_PD_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PD_LC_AMT() {
		return COMP_PD_LC_AMT;
	}

	public void setCOMP_PD_LC_AMT_LABEL(HtmlOutputLabel COMP_PD_LC_AMT_LABEL) {
		this.COMP_PD_LC_AMT_LABEL = COMP_PD_LC_AMT_LABEL;
	}

	public void setCOMP_PD_LC_AMT(HtmlInputText COMP_PD_LC_AMT) {
		this.COMP_PD_LC_AMT = COMP_PD_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_PD_PAID_FOR_LABEL() {
		return COMP_PD_PAID_FOR_LABEL;
	}

	public HtmlComboBox getCOMP_PD_PAID_FOR() {
		return COMP_PD_PAID_FOR;
	}

	public void setCOMP_PD_PAID_FOR_LABEL(HtmlOutputLabel COMP_PD_PAID_FOR_LABEL) {
		this.COMP_PD_PAID_FOR_LABEL = COMP_PD_PAID_FOR_LABEL;
	}

	public void setCOMP_PD_PAID_FOR(HtmlComboBox COMP_PD_PAID_FOR) {
		this.COMP_PD_PAID_FOR = COMP_PD_PAID_FOR;
	}

	public HtmlOutputLabel getCOMP_PD_CHQ_NO_LABEL() {
		return COMP_PD_CHQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_PD_CHQ_NO() {
		return COMP_PD_CHQ_NO;
	}

	public void setCOMP_PD_CHQ_NO_LABEL(HtmlOutputLabel COMP_PD_CHQ_NO_LABEL) {
		this.COMP_PD_CHQ_NO_LABEL = COMP_PD_CHQ_NO_LABEL;
	}

	public void setCOMP_PD_CHQ_NO(HtmlInputText COMP_PD_CHQ_NO) {
		this.COMP_PD_CHQ_NO = COMP_PD_CHQ_NO;
	}

	public HtmlOutputLabel getCOMP_PD_CHQ_DT_LABEL() {
		return COMP_PD_CHQ_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PD_CHQ_DT() {
		return COMP_PD_CHQ_DT;
	}

	public void setCOMP_PD_CHQ_DT_LABEL(HtmlOutputLabel COMP_PD_CHQ_DT_LABEL) {
		this.COMP_PD_CHQ_DT_LABEL = COMP_PD_CHQ_DT_LABEL;
	}

	public void setCOMP_PD_CHQ_DT(HtmlCalendar COMP_PD_CHQ_DT) {
		this.COMP_PD_CHQ_DT = COMP_PD_CHQ_DT;
	}

	public HtmlOutputLabel getCOMP_PD_DPD_REF_ID_LABEL() {
		return COMP_PD_DPD_REF_ID_LABEL;
	}

	public HtmlInputText getCOMP_PD_DPD_REF_ID() {
		return COMP_PD_DPD_REF_ID;
	}

	public void setCOMP_PD_DPD_REF_ID_LABEL(HtmlOutputLabel COMP_PD_DPD_REF_ID_LABEL) {
		this.COMP_PD_DPD_REF_ID_LABEL = COMP_PD_DPD_REF_ID_LABEL;
	}

	public void setCOMP_PD_DPD_REF_ID(HtmlInputText COMP_PD_DPD_REF_ID) {
		this.COMP_PD_DPD_REF_ID = COMP_PD_DPD_REF_ID;
	}

	public HtmlOutputLabel getCOMP_PD_CR_ADVICE_NO_LABEL() {
		return COMP_PD_CR_ADVICE_NO_LABEL;
	}

	public HtmlInputText getCOMP_PD_CR_ADVICE_NO() {
		return COMP_PD_CR_ADVICE_NO;
	}

	public void setCOMP_PD_CR_ADVICE_NO_LABEL(HtmlOutputLabel COMP_PD_CR_ADVICE_NO_LABEL) {
		this.COMP_PD_CR_ADVICE_NO_LABEL = COMP_PD_CR_ADVICE_NO_LABEL;
	}

	public void setCOMP_PD_CR_ADVICE_NO(HtmlInputText COMP_PD_CR_ADVICE_NO) {
		this.COMP_PD_CR_ADVICE_NO = COMP_PD_CR_ADVICE_NO;
	}

	public HtmlOutputLabel getCOMP_PD_PAYIN_DATE_LABEL() {
		return COMP_PD_PAYIN_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_PD_PAYIN_DATE() {
		return COMP_PD_PAYIN_DATE;
	}

	public void setCOMP_PD_PAYIN_DATE_LABEL(HtmlOutputLabel COMP_PD_PAYIN_DATE_LABEL) {
		this.COMP_PD_PAYIN_DATE_LABEL = COMP_PD_PAYIN_DATE_LABEL;
	}

	public void setCOMP_PD_PAYIN_DATE(HtmlCalendar COMP_PD_PAYIN_DATE) {
		this.COMP_PD_PAYIN_DATE = COMP_PD_PAYIN_DATE;
	}

	public HtmlOutputLabel getCOMP_PD_BANK_NAME_LABEL() {
		return COMP_PD_BANK_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PD_BANK_NAME() {
		return COMP_PD_BANK_NAME;
	}

	public void setCOMP_PD_BANK_NAME_LABEL(HtmlOutputLabel COMP_PD_BANK_NAME_LABEL) {
		this.COMP_PD_BANK_NAME_LABEL = COMP_PD_BANK_NAME_LABEL;
	}

	public void setCOMP_PD_BANK_NAME(HtmlInputText COMP_PD_BANK_NAME) {
		this.COMP_PD_BANK_NAME = COMP_PD_BANK_NAME;
	}

	public HtmlInputText getCOMP_UI_M_BANK_NAME_DESC() {
		return COMP_UI_M_BANK_NAME_DESC;
	}

	public void setCOMP_UI_M_BANK_NAME_DESC(HtmlInputText COMP_UI_M_BANK_NAME_DESC) {
		this.COMP_UI_M_BANK_NAME_DESC = COMP_UI_M_BANK_NAME_DESC;
	}

	public HtmlOutputLabel getCOMP_PD_BRANCH_NAME_LABEL() {
		return COMP_PD_BRANCH_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PD_BRANCH_NAME() {
		return COMP_PD_BRANCH_NAME;
	}

	public void setCOMP_PD_BRANCH_NAME_LABEL(HtmlOutputLabel COMP_PD_BRANCH_NAME_LABEL) {
		this.COMP_PD_BRANCH_NAME_LABEL = COMP_PD_BRANCH_NAME_LABEL;
	}

	public void setCOMP_PD_BRANCH_NAME(HtmlInputText COMP_PD_BRANCH_NAME) {
		this.COMP_PD_BRANCH_NAME = COMP_PD_BRANCH_NAME;
	}

	public HtmlOutputLabel getCOMP_PD_CUST_NAME_LABEL() {
		return COMP_PD_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PD_CUST_NAME() {
		return COMP_PD_CUST_NAME;
	}

	public void setCOMP_PD_CUST_NAME_LABEL(HtmlOutputLabel COMP_PD_CUST_NAME_LABEL) {
		this.COMP_PD_CUST_NAME_LABEL = COMP_PD_CUST_NAME_LABEL;
	}

	public void setCOMP_PD_CUST_NAME(HtmlInputText COMP_PD_CUST_NAME) {
		this.COMP_PD_CUST_NAME = COMP_PD_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_01_LABEL() {
		return COMP_PD_ADDR_01_LABEL;
	}

	public HtmlInputText getCOMP_PD_ADDR_01() {
		return COMP_PD_ADDR_01;
	}

	public void setCOMP_PD_ADDR_01_LABEL(HtmlOutputLabel COMP_PD_ADDR_01_LABEL) {
		this.COMP_PD_ADDR_01_LABEL = COMP_PD_ADDR_01_LABEL;
	}

	public void setCOMP_PD_ADDR_01(HtmlInputText COMP_PD_ADDR_01) {
		this.COMP_PD_ADDR_01 = COMP_PD_ADDR_01;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_02_LABEL() {
		return COMP_PD_ADDR_02_LABEL;
	}

	public HtmlInputText getCOMP_PD_ADDR_02() {
		return COMP_PD_ADDR_02;
	}

	public void setCOMP_PD_ADDR_02_LABEL(HtmlOutputLabel COMP_PD_ADDR_02_LABEL) {
		this.COMP_PD_ADDR_02_LABEL = COMP_PD_ADDR_02_LABEL;
	}

	public void setCOMP_PD_ADDR_02(HtmlInputText COMP_PD_ADDR_02) {
		this.COMP_PD_ADDR_02 = COMP_PD_ADDR_02;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_03_LABEL() {
		return COMP_PD_ADDR_03_LABEL;
	}

	public HtmlInputText getCOMP_PD_ADDR_03() {
		return COMP_PD_ADDR_03;
	}

	public void setCOMP_PD_ADDR_03_LABEL(HtmlOutputLabel COMP_PD_ADDR_03_LABEL) {
		this.COMP_PD_ADDR_03_LABEL = COMP_PD_ADDR_03_LABEL;
	}

	public void setCOMP_PD_ADDR_03(HtmlInputText COMP_PD_ADDR_03) {
		this.COMP_PD_ADDR_03 = COMP_PD_ADDR_03;
	}

	public HtmlOutputLabel getCOMP_PD_REMARKS_LABEL() {
		return COMP_PD_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_PD_REMARKS() {
		return COMP_PD_REMARKS;
	}

	public void setCOMP_PD_REMARKS_LABEL(HtmlOutputLabel COMP_PD_REMARKS_LABEL) {
		this.COMP_PD_REMARKS_LABEL = COMP_PD_REMARKS_LABEL;
	}

	public void setCOMP_PD_REMARKS(HtmlInputText COMP_PD_REMARKS) {
		this.COMP_PD_REMARKS = COMP_PD_REMARKS;
	}

	public HtmlOutputLabel getCOMP_PD_CURR_CODE_LABEL() {
		return COMP_PD_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PD_CURR_CODE() {
		return COMP_PD_CURR_CODE;
	}

	public void setCOMP_PD_CURR_CODE_LABEL(HtmlOutputLabel COMP_PD_CURR_CODE_LABEL) {
		this.COMP_PD_CURR_CODE_LABEL = COMP_PD_CURR_CODE_LABEL;
	}

	public void setCOMP_PD_CURR_CODE(HtmlInputText COMP_PD_CURR_CODE) {
		this.COMP_PD_CURR_CODE = COMP_PD_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PD_CURR_CODE_DESC_LABEL() {
		return COMP_UI_M_PD_CURR_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PD_CURR_CODE_DESC() {
		return COMP_UI_M_PD_CURR_CODE_DESC;
	}

	public void setCOMP_UI_M_PD_CURR_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PD_CURR_CODE_DESC_LABEL) {
		this.COMP_UI_M_PD_CURR_CODE_DESC_LABEL = COMP_UI_M_PD_CURR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PD_CURR_CODE_DESC(HtmlInputText COMP_UI_M_PD_CURR_CODE_DESC) {
		this.COMP_UI_M_PD_CURR_CODE_DESC = COMP_UI_M_PD_CURR_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PD_LC_CHARGE_LABEL() {
		return COMP_PD_LC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_PD_LC_CHARGE() {
		return COMP_PD_LC_CHARGE;
	}

	public void setCOMP_PD_LC_CHARGE_LABEL(HtmlOutputLabel COMP_PD_LC_CHARGE_LABEL) {
		this.COMP_PD_LC_CHARGE_LABEL = COMP_PD_LC_CHARGE_LABEL;
	}

	public void setCOMP_PD_LC_CHARGE(HtmlInputText COMP_PD_LC_CHARGE) {
		this.COMP_PD_LC_CHARGE = COMP_PD_LC_CHARGE;
	}

	public HtmlOutputLabel getCOMP_PD_FC_CHARGE_LABEL() {
		return COMP_PD_FC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_PD_FC_CHARGE() {
		return COMP_PD_FC_CHARGE;
	}

	public void setCOMP_PD_FC_CHARGE_LABEL(HtmlOutputLabel COMP_PD_FC_CHARGE_LABEL) {
		this.COMP_PD_FC_CHARGE_LABEL = COMP_PD_FC_CHARGE_LABEL;
	}

	public void setCOMP_PD_FC_CHARGE(HtmlInputText COMP_PD_FC_CHARGE) {
		this.COMP_PD_FC_CHARGE = COMP_PD_FC_CHARGE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PD_CUST_NAME() {
		return COMP_UI_M_BUT_PD_CUST_NAME;
	}

	public void setCOMP_UI_M_BUT_PD_CUST_NAME(HtmlCommandButton COMP_UI_M_BUT_PD_CUST_NAME) {
		this.COMP_UI_M_BUT_PD_CUST_NAME = COMP_UI_M_BUT_PD_CUST_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PD_ADDR_01() {
		return COMP_UI_M_BUT_PD_ADDR_01;
	}

	public void setCOMP_UI_M_BUT_PD_ADDR_01(HtmlCommandButton COMP_UI_M_BUT_PD_ADDR_01) {
		this.COMP_UI_M_BUT_PD_ADDR_01 = COMP_UI_M_BUT_PD_ADDR_01;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PD_ADDR_02() {
		return COMP_UI_M_BUT_PD_ADDR_02;
	}

	public void setCOMP_UI_M_BUT_PD_ADDR_02(HtmlCommandButton COMP_UI_M_BUT_PD_ADDR_02) {
		this.COMP_UI_M_BUT_PD_ADDR_02 = COMP_UI_M_BUT_PD_ADDR_02;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PD_ADDR_03() {
		return COMP_UI_M_BUT_PD_ADDR_03;
	}

	public void setCOMP_UI_M_BUT_PD_ADDR_03(HtmlCommandButton COMP_UI_M_BUT_PD_ADDR_03) {
		this.COMP_UI_M_BUT_PD_ADDR_03 = COMP_UI_M_BUT_PD_ADDR_03;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PD_REMARKS() {
		return COMP_UI_M_BUT_PD_REMARKS;
	}

	public void setCOMP_UI_M_BUT_PD_REMARKS(HtmlCommandButton COMP_UI_M_BUT_PD_REMARKS) {
		this.COMP_UI_M_BUT_PD_REMARKS = COMP_UI_M_BUT_PD_REMARKS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PD_BANK_NAME() {
		return COMP_UI_M_BUT_PD_BANK_NAME;
	}

	public void setCOMP_UI_M_BUT_PD_BANK_NAME(HtmlCommandButton COMP_UI_M_BUT_PD_BANK_NAME) {
		this.COMP_UI_M_BUT_PD_BANK_NAME = COMP_UI_M_BUT_PD_BANK_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PD_BRANCH_NAME() {
		return COMP_UI_M_BUT_PD_BRANCH_NAME;
	}

	public void setCOMP_UI_M_BUT_PD_BRANCH_NAME(HtmlCommandButton COMP_UI_M_BUT_PD_BRANCH_NAME) {
		this.COMP_UI_M_BUT_PD_BRANCH_NAME = COMP_UI_M_BUT_PD_BRANCH_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MORE() {
		return COMP_UI_M_BUT_MORE;
	}

	public void setCOMP_UI_M_BUT_MORE(HtmlCommandButton COMP_UI_M_BUT_MORE) {
		this.COMP_UI_M_BUT_MORE = COMP_UI_M_BUT_MORE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BANK_LOV() {
		return COMP_UI_M_BUT_BANK_LOV;
	}

	public void setCOMP_UI_M_BUT_BANK_LOV(HtmlCommandButton COMP_UI_M_BUT_BANK_LOV) {
		this.COMP_UI_M_BUT_BANK_LOV = COMP_UI_M_BUT_BANK_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_DPD_REF_ID() {
		return COMP_UI_M_BUT_LOV_DPD_REF_ID;
	}

	public void setCOMP_UI_M_BUT_LOV_DPD_REF_ID(HtmlCommandButton COMP_UI_M_BUT_LOV_DPD_REF_ID) {
		this.COMP_UI_M_BUT_LOV_DPD_REF_ID = COMP_UI_M_BUT_LOV_DPD_REF_ID;
	}

	public PT_IL_PYMT_DTLS getPT_IL_PYMT_DTLS_BEAN() {
		return PT_IL_PYMT_DTLS_BEAN;
	}

	public void setPT_IL_PYMT_DTLS_BEAN(PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) {
		this.PT_IL_PYMT_DTLS_BEAN = PT_IL_PYMT_DTLS_BEAN;
	}

	public UIDataTable getUiDataTable() {
		return uiDataTable;
	}

	public void setUiDataTable(UIDataTable uiDataTable) {
		this.uiDataTable = uiDataTable;
	}

	public void setList(List list) {
		this.list = list;
	}

	/*public Connection getConnection() throws Exception{
		FacesContext fc = FacesContext.getCurrentInstance();
		ServletContext context = (ServletContext)fc.getExternalContext().getContext();
		SimpleConnectionAgent connectionAgent =  (SimpleConnectionAgent) context.getAttribute("connectionAgent");
		return connectionAgent.getConnection("System.currentTimeMillis()");
	}*/

	public String createRecord() throws Exception{
		System.out.println("\n\n createRecord() method is called");
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		try{
			con=CommonUtils.getConnection();
			System.out.println("\n\n The Connection object got when creating a record is"+con);
			//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]

			PT_IL_PYMT_DTLS_BEAN.setPD_CR_DT(new CommonUtils().getCurrentDate());
			PT_IL_PYMT_DTLS_BEAN.setPD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());

			rs = handler.executeSelectStatement("select * from PT_IL_PYMT_DTLS", con); 
			while(rs.next()){
				System.out.println("The resultset is:   "+ rs.getString(1));
			}

			handler.executeInsert(PT_IL_PYMT_DTLS_BEAN, con);
		}catch(DBException e){
			throw new Exception(e.getMessage());
		}catch(SQLException e){
			throw new Exception(e.getMessage());
		}finally{
			try{
				CommonUtils.closeCursor(rs);
			}catch(SQLException e){
				throw new Exception(e.getMessage());
			}
		}
		return null;
	}

	public List getList() {
		String query="select PD_SR_NO,PD_PAY_MODE,PD_DPD_REF_ID,PD_FC_AMT,PD_PAID_FOR,PD_LC_AMT,PD_CHQ_NO,PD_CHQ_DT from PT_IL_PYMT_DTLS where ROWNUM<=5";  
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		PT_IL_PYMT_DTLS payment;	
		try {
			con=CommonUtils.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			//ResultSet rs=ps.executeQuery();
			CRUDHandler handler = new CRUDHandler();
			//Class.forName("com.iii.pel.forms.PILP001_apac.PT_IL_PYMT_DTLS").newInstance();
			list  =  handler.fetch(query, "com.iii.pel.forms.PILP001_APAC.PT_IL_PYMT_DTLS", con);

			/*while(rs.next()){
				payment=new PT_IL_PYMT_DTLS();
				payment.setPD_SR_NO(rs.getDouble("PD_SR_NO"));
				payment.setPD_PAY_MODE(rs.getString("PD_PAY_MODE"));
				payment.setPD_DPD_REF_ID(rs.getString("PD_DPD_REF_ID"));
				payment.setPD_FC_AMT(rs.getDouble("PD_FC_AMT"));
				payment.setPD_LC_AMT(rs.getDouble("PD_LC_AMT"));
				payment.setPD_PAID_FOR(rs.getString("PD_PAID_FOR"));
				payment.setPD_CHQ_NO(rs.getString("PD_CHQ_NO"));
				payment.setPD_CHQ_DT(rs.getDate("PD_CHQ_DT"));
				list.add(payment);;
			}*/


		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*public String preForm(){
		System.out.println("DUMMYACTION.preForm()");
		ArrayList<OracleParameter> list =null;
		//FacesContext fc = FacesContext.getCurrentInstance();

		session.put("GLOBAL.M_PRIVILEGE", "YYY");
		session.put("GLOBAL.M_FAILURE", "FALSE");
		session.put("GLOBAL.M_USER_ID", "PREMIA");
		session.put("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM NAME");
		session.put("GLOBAL.M_LANG_CODE", "ENG");
		session.put("GLOBAL.M_DFLT_VALUES", "00101    01");
		session.put("GLOBAL.M_PARA_1", " ");
		session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");

//		values should take from GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME)
//		Developing purpose hard coded it.
		session.put("GLOBAL.M_MODULE_NAME", "PILP001_APAC");
		System.out.println("DUMMYACTION.preForm()\n"+ctx.getExternalContext().getSessionMap());

//		calling STD_PRE_FORM PLL
		STD_PRE_FORM();

		if(Integer.parseInt(((String)session.get("GLOBAL.M_FOR_LANG_CODE")).substring(4,5))== 1 ){
			System.out.println("DUMMYACTION.preForm()NULLLLLLLLLLLLLLLLL");
		}
		ControlBean ctrlbean = getCtrlBean();
		String M_TITLE = ctrlbean.getM_USER_ID()+" "+ctrlbean.getM_SCR_NAME()+" "+new Date();
		System.out.println("DUMMYACTION.preForm()---->> "+M_TITLE);
		try {
			connection = getConnection();
		} catch (Exception exp) {
			exp.printStackTrace();
		}

		List<String> bonusTypeList=null;
		System.out.println("bonusTypeList"+bonusTypeList);
		bonusTypeList = ListItemUtil.getComboSuggestionValues(connection, "PILP014_A", "DUMMY", "M_PROCESS_TYPE");
		DUMMY_ACTION queryAction = (DUMMY_ACTION) ctx.getExternalContext().getSessionMap().get("DUMMY_ACTION");
		queryAction.getDUMMY_BEAN().setUI_M_PROCESS_TYPE_LIST(bonusTypeList);

		System.out.println("DUMMYACTION.preForm() \n--------------- OUTPUTPARAM PREFORM FINISHED -------------------\n"+list+"\n----------------");

		//getTest().setDisabled(true);
		//getSystemDate();
		return null;
	}

	public void STD_PRE_FORM(){
		System.out.println("DUMMY_ACTION.STD_PRE_FORM()");
		createCtrlBean();
		System.out.println("DUMMY_ACTION.STD_PRE_FORM()------createCtrlBean");
		ctrlBean = getCtrlBean();
		System.out.println("DUMMYACTION.STD_PRE_FORM()\n---------->\n"+session.toString()+"\n----------");
		ctrlBean.setM_PARA_1((String)session.getAttribute("GLOBAL.M_PARA_1"));
		ctrlBean.setM_USER_ID((String)session.getAttribute("GLOBAL.M_USER_ID"));
		ctrlBean.setM_PROG_NAME("PIL014_A");
		System.out.println("DUMMYACTION.STD_PRE_FORM(------)" +(String)session.getAttribute("GLOBAL.M_NAME"));
		ctrlBean.setM_SCR_NAME(((String)session.getAttribute("GLOBAL.M_NAME")).substring(30, 42));
		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		ctrlBean.setM_LANG_CODE((String)session.getAttribute("GLOBAL.M_LANG_CODE"));
		ctrlBean.setM_COMP_CODE(((String)session.getAttribute("GLOBAL.M_DFLT_VALUES")).substring(0,3));
		ctrlBean.setM_DIVN_CODE(((String)session.getAttribute("GLOBAL.M_DFLT_VALUES")).substring(3,6));
		System.out.println("DUMMYACTION.STD_PRE_FORM(!!!! ) "+(String)session.getAttribute("GLOBAL.M_DFLT_VALUES"));
		ctrlBean.setM_DEPT_CODE(((String)session.getAttribute("GLOBAL.M_DFLT_VALUES")).substring(9,11));
		putCtrlBean(ctrlBean);
		System.out.println("DUMMYACTION.STD_PRE_FORM()--- \n "+ctrlBean.getM_LANG_CODE()+"\t"+ctrlBean.getM_COMP_CODE()+"\t"+ctrlBean.getM_PARA_1());
	}

	 */
}
