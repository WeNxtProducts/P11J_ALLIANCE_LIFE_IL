package com.iii.pel.forms.PILP036;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.runtime.functions.MigratingFunctions;
import com.iii.premia.runtime.functions.StringFunctions;

public class PT_IL_CHEQ_REALISE_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CHRD_DEP_REF_NO_LABEL;

	private HtmlInputText COMP_CHRD_DEP_REF_NO;

	private HtmlOutputLabel COMP_CHRD_DEP_TXN_CODE_LABEL;

	private HtmlInputText COMP_CHRD_DEP_TXN_CODE;

	private HtmlOutputLabel COMP_CHRD_DEP_DOC_NO_LABEL;

	private HtmlInputText COMP_CHRD_DEP_DOC_NO;

	private HtmlOutputLabel COMP_CHRD_DEP_DOC_DT_LABEL;

	private HtmlCalendar COMP_CHRD_DEP_DOC_DT;

	private HtmlOutputLabel COMP_CHRD_PD_CHQ_NO_LABEL;

	private HtmlInputText COMP_CHRD_PD_CHQ_NO;

	private HtmlOutputLabel COMP_CHRD_PD_CHQ_DT_LABEL;

	private HtmlCalendar COMP_CHRD_PD_CHQ_DT;

	private HtmlOutputLabel COMP_CHRD_DEP_LC_TOTAL_AMT_LABEL;

	private HtmlInputText COMP_CHRD_DEP_LC_TOTAL_AMT;

	private HtmlOutputLabel COMP_CHRD_ASSIGN_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_CHRD_ASSIGN_FLAG;
	
	private HtmlOutputLabel COMP_B_FM_BANK;
	
	private HtmlInputText COMP_UI_M_FM_BANK;
	
	private HtmlInputText COMP_UI_M_FM_BANK_DESC;
	
	private HtmlOutputLabel COMP_B_TO_BANK;
	
	private HtmlInputText COMP_UI_M_TO_BANK;
	
	private HtmlInputText COMP_UI_M_TO_BANK_DESC;
	
	private HtmlOutputLabel COMP_B_TO_DATE;
	
	private HtmlCalendar COMP_UI_M_TO_DATE;

	private PT_IL_CHEQ_REALISE_DTL PT_IL_CHEQ_REALISE_DTL_BEAN;
	
	private UIDataTable dataTable;
	
	private HtmlAjaxCommandButton COMP_UI_M_BUT_PROCESS;
	
	private HtmlAjaxCommandButton COMP_UI_M_BUT_APPROVE;
	
	private String M_BASE_CURR =null;
	private ArrayList<SuggesionBean> fromBank;
	private ArrayList<SuggesionBean> toBank;
	
	private ArrayList<SelectItem> assignFlag = new ArrayList<SelectItem>();
	private ArrayList<PT_IL_CHEQ_REALISE_DTL> dataValue = new ArrayList<PT_IL_CHEQ_REALISE_DTL>();
	private CRUDHandler handler = null;
	
	private ControlBean controlBean;

	public ControlBean getControlBean() {
		return controlBean;
	}

	public void setControlBean(ControlBean controlBean) {
		this.controlBean = controlBean;
	}

	public PT_IL_CHEQ_REALISE_DTL_ACTION() {
		PT_IL_CHEQ_REALISE_DTL_BEAN = new PT_IL_CHEQ_REALISE_DTL();
		handler = new CRUDHandler();
		
		controlBean = (ControlBean) CommonUtils.getControlBean().clone();
		preForm();
		whenCreateRecord();
	}

	public HtmlOutputLabel getCOMP_CHRD_DEP_REF_NO_LABEL() {
		return COMP_CHRD_DEP_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_CHRD_DEP_REF_NO() {
		return COMP_CHRD_DEP_REF_NO;
	}

	public void setCOMP_CHRD_DEP_REF_NO_LABEL(HtmlOutputLabel COMP_CHRD_DEP_REF_NO_LABEL) {
		this.COMP_CHRD_DEP_REF_NO_LABEL = COMP_CHRD_DEP_REF_NO_LABEL;
	}

	public void setCOMP_CHRD_DEP_REF_NO(HtmlInputText COMP_CHRD_DEP_REF_NO) {
		this.COMP_CHRD_DEP_REF_NO = COMP_CHRD_DEP_REF_NO;
	}

	public HtmlOutputLabel getCOMP_CHRD_DEP_TXN_CODE_LABEL() {
		return COMP_CHRD_DEP_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CHRD_DEP_TXN_CODE() {
		return COMP_CHRD_DEP_TXN_CODE;
	}

	public void setCOMP_CHRD_DEP_TXN_CODE_LABEL(HtmlOutputLabel COMP_CHRD_DEP_TXN_CODE_LABEL) {
		this.COMP_CHRD_DEP_TXN_CODE_LABEL = COMP_CHRD_DEP_TXN_CODE_LABEL;
	}

	public void setCOMP_CHRD_DEP_TXN_CODE(HtmlInputText COMP_CHRD_DEP_TXN_CODE) {
		this.COMP_CHRD_DEP_TXN_CODE = COMP_CHRD_DEP_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_CHRD_DEP_DOC_NO_LABEL() {
		return COMP_CHRD_DEP_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_CHRD_DEP_DOC_NO() {
		return COMP_CHRD_DEP_DOC_NO;
	}

	public void setCOMP_CHRD_DEP_DOC_NO_LABEL(HtmlOutputLabel COMP_CHRD_DEP_DOC_NO_LABEL) {
		this.COMP_CHRD_DEP_DOC_NO_LABEL = COMP_CHRD_DEP_DOC_NO_LABEL;
	}

	public void setCOMP_CHRD_DEP_DOC_NO(HtmlInputText COMP_CHRD_DEP_DOC_NO) {
		this.COMP_CHRD_DEP_DOC_NO = COMP_CHRD_DEP_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_CHRD_DEP_DOC_DT_LABEL() {
		return COMP_CHRD_DEP_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CHRD_DEP_DOC_DT() {
		return COMP_CHRD_DEP_DOC_DT;
	}

	public void setCOMP_CHRD_DEP_DOC_DT_LABEL(HtmlOutputLabel COMP_CHRD_DEP_DOC_DT_LABEL) {
		this.COMP_CHRD_DEP_DOC_DT_LABEL = COMP_CHRD_DEP_DOC_DT_LABEL;
	}

	public void setCOMP_CHRD_DEP_DOC_DT(HtmlCalendar COMP_CHRD_DEP_DOC_DT) {
		this.COMP_CHRD_DEP_DOC_DT = COMP_CHRD_DEP_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_CHRD_PD_CHQ_NO_LABEL() {
		return COMP_CHRD_PD_CHQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_CHRD_PD_CHQ_NO() {
		return COMP_CHRD_PD_CHQ_NO;
	}

	public void setCOMP_CHRD_PD_CHQ_NO_LABEL(HtmlOutputLabel COMP_CHRD_PD_CHQ_NO_LABEL) {
		this.COMP_CHRD_PD_CHQ_NO_LABEL = COMP_CHRD_PD_CHQ_NO_LABEL;
	}

	public void setCOMP_CHRD_PD_CHQ_NO(HtmlInputText COMP_CHRD_PD_CHQ_NO) {
		this.COMP_CHRD_PD_CHQ_NO = COMP_CHRD_PD_CHQ_NO;
	}

	public HtmlOutputLabel getCOMP_CHRD_PD_CHQ_DT_LABEL() {
		return COMP_CHRD_PD_CHQ_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CHRD_PD_CHQ_DT() {
		return COMP_CHRD_PD_CHQ_DT;
	}

	public void setCOMP_CHRD_PD_CHQ_DT_LABEL(HtmlOutputLabel COMP_CHRD_PD_CHQ_DT_LABEL) {
		this.COMP_CHRD_PD_CHQ_DT_LABEL = COMP_CHRD_PD_CHQ_DT_LABEL;
	}

	public void setCOMP_CHRD_PD_CHQ_DT(HtmlCalendar COMP_CHRD_PD_CHQ_DT) {
		this.COMP_CHRD_PD_CHQ_DT = COMP_CHRD_PD_CHQ_DT;
	}

	public HtmlOutputLabel getCOMP_CHRD_DEP_LC_TOTAL_AMT_LABEL() {
		return COMP_CHRD_DEP_LC_TOTAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CHRD_DEP_LC_TOTAL_AMT() {
		return COMP_CHRD_DEP_LC_TOTAL_AMT;
	}

	public void setCOMP_CHRD_DEP_LC_TOTAL_AMT_LABEL(HtmlOutputLabel COMP_CHRD_DEP_LC_TOTAL_AMT_LABEL) {
		this.COMP_CHRD_DEP_LC_TOTAL_AMT_LABEL = COMP_CHRD_DEP_LC_TOTAL_AMT_LABEL;
	}

	public void setCOMP_CHRD_DEP_LC_TOTAL_AMT(HtmlInputText COMP_CHRD_DEP_LC_TOTAL_AMT) {
		this.COMP_CHRD_DEP_LC_TOTAL_AMT = COMP_CHRD_DEP_LC_TOTAL_AMT;
	}

	public HtmlOutputLabel getCOMP_CHRD_ASSIGN_FLAG_LABEL() {
		return COMP_CHRD_ASSIGN_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CHRD_ASSIGN_FLAG() {
		return COMP_CHRD_ASSIGN_FLAG;
	}

	public void setCOMP_CHRD_ASSIGN_FLAG_LABEL(HtmlOutputLabel COMP_CHRD_ASSIGN_FLAG_LABEL) {
		this.COMP_CHRD_ASSIGN_FLAG_LABEL = COMP_CHRD_ASSIGN_FLAG_LABEL;
	}

	public void setCOMP_CHRD_ASSIGN_FLAG(HtmlSelectOneMenu COMP_CHRD_ASSIGN_FLAG) {
		this.COMP_CHRD_ASSIGN_FLAG = COMP_CHRD_ASSIGN_FLAG;
	}

	public PT_IL_CHEQ_REALISE_DTL getPT_IL_CHEQ_REALISE_DTL_BEAN() {
		return PT_IL_CHEQ_REALISE_DTL_BEAN;
	}

	public void setPT_IL_CHEQ_REALISE_DTL_BEAN(PT_IL_CHEQ_REALISE_DTL PT_IL_CHEQ_REALISE_DTL_BEAN) {
		this.PT_IL_CHEQ_REALISE_DTL_BEAN = PT_IL_CHEQ_REALISE_DTL_BEAN;
	}

	public HtmlOutputLabel getCOMP_B_FM_BANK() {
		return COMP_B_FM_BANK;
	}

	public void setCOMP_B_FM_BANK(HtmlOutputLabel comp_b_fm_bank) {
		COMP_B_FM_BANK = comp_b_fm_bank;
	}

	public HtmlInputText getCOMP_UI_M_FM_BANK() {
		return COMP_UI_M_FM_BANK;
	}

	public void setCOMP_UI_M_FM_BANK(HtmlInputText comp_ui_m_fm_bank) {
		COMP_UI_M_FM_BANK = comp_ui_m_fm_bank;
	}

	public HtmlOutputLabel getCOMP_B_TO_BANK() {
		return COMP_B_TO_BANK;
	}

	public void setCOMP_B_TO_BANK(HtmlOutputLabel comp_b_to_bank) {
		COMP_B_TO_BANK = comp_b_to_bank;
	}

	public HtmlInputText getCOMP_UI_M_TO_BANK() {
		return COMP_UI_M_TO_BANK;
	}

	public void setCOMP_UI_M_TO_BANK(HtmlInputText comp_ui_m_to_bank) {
		COMP_UI_M_TO_BANK = comp_ui_m_to_bank;
	}

	public HtmlInputText getCOMP_UI_M_FM_BANK_DESC() {
		return COMP_UI_M_FM_BANK_DESC;
	}

	public void setCOMP_UI_M_FM_BANK_DESC(HtmlInputText comp_ui_m_fm_bank_desc) {
		COMP_UI_M_FM_BANK_DESC = comp_ui_m_fm_bank_desc;
	}

	public HtmlInputText getCOMP_UI_M_TO_BANK_DESC() {
		return COMP_UI_M_TO_BANK_DESC;
	}

	public void setCOMP_UI_M_TO_BANK_DESC(HtmlInputText comp_ui_m_to_bank_desc) {
		COMP_UI_M_TO_BANK_DESC = comp_ui_m_to_bank_desc;
	}

	public HtmlOutputLabel getCOMP_B_TO_DATE() {
		return COMP_B_TO_DATE;
	}

	public void setCOMP_B_TO_DATE(HtmlOutputLabel comp_b_to_date) {
		COMP_B_TO_DATE = comp_b_to_date;
	}

	public HtmlCalendar getCOMP_UI_M_TO_DATE() {
		return COMP_UI_M_TO_DATE;
	}

	public void setCOMP_UI_M_TO_DATE(HtmlCalendar comp_ui_m_to_date) {
		COMP_UI_M_TO_DATE = comp_ui_m_to_date;
	}

	public HtmlAjaxCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlAjaxCommandButton comp_ui_m_but_process) {
		COMP_UI_M_BUT_PROCESS = comp_ui_m_but_process;
	}

	public HtmlAjaxCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlAjaxCommandButton comp_ui_m_but_approve) {
		COMP_UI_M_BUT_APPROVE = comp_ui_m_but_approve;
	}
	
	public ArrayList<SelectItem> getAssignFlag() {
		try {
			assignFlag = (ArrayList<SelectItem>) ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILP036", "PT_IL_CHEQ_REALISE_DTL", "PT_IL_CHEQ_REALISE_DTL.CHRD_ASSIGN_FLAG","YESNO");
			System.out.println("[ "+assignFlag.toString()+" ]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assignFlag;
	}

	public void setAssignFlag(ArrayList<SelectItem> assignFlag) {
		this.assignFlag = assignFlag;
	}
	// Base_Curr changes PREMIAGDC-0030 : Added by Shankar Bodduluri : 25/03/09
	/*public void preForm(){
		System.out.println("PT_IL_CHEQ_REALISE_DTL_ACTION.preForm()");
		Connection connection= null;
		//session.put("GLOBAL.M_PRIVILEGE", "YYY");
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
		//session.put("GLOBAL.M_USER_ID", "PREMIA");
		//session.put("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM NAME");
		//session.put("GLOBAL.M_LANG_CODE", "ENG");
	//	session.put("GLOBAL.M_PARA_1", " ");
		//session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
//		values should take from GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME)
//		Developing purpose hard coded it.
	//	session.put("GLOBAL.M_MODULE_NAME", "PILP036");
//		calling STD_PRE_FORM PLL
		STD_PRE_FORM();
		//ControlBean ctrlbean = CommonUtils.getControlBean();
		String M_TITLE = controlBean.getM_USER_ID() + " " + controlBean.getM_SCR_NAME() + " " + new Date();
		System.out.println("PT_IL_RI_DETL_ACTION.preForm()---->> "+M_TITLE);
		
		P_VAL_FINAL_PARAMETER();
//		P_SET_PARA_VALUES();

	}*/
	public void preForm(){
		try{
			System.out.println("PT_IL_CHEQ_REALISE_DTL_ACTION.preForm()");
			Connection connection= null;
			//session.put("GLOBAL.M_PRIVILEGE", "YYY");
			CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
			//session.put("GLOBAL.M_USER_ID", "PREMIA");
			//session.put("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM NAME");
			//session.put("GLOBAL.M_LANG_CODE", "ENG");
			//	session.put("GLOBAL.M_PARA_1", " ");
			//session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
//			values should take from GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME)
//			Developing purpose hard coded it.
			//	session.put("GLOBAL.M_MODULE_NAME", "PILP036");
//			calling STD_PRE_FORM PLL
			STD_PRE_FORM();
			//ControlBean ctrlbean = CommonUtils.getControlBean();
			String M_TITLE = controlBean.getM_USER_ID() + " " + controlBean.getM_SCR_NAME() + " " + new Date();
			System.out.println("PT_IL_RI_DETL_ACTION.preForm()---->> "+M_TITLE);

			// Base_Curr changes PREMIAGDC-0030	helperF_GET_BASE_CURRENCY added
			String P_CURR_CODE = null;
			String P_NAME = null;
			int P_DECIMAL = -1;
			DBProcedures procedures = new DBProcedures();
			ArrayList<String> list = procedures.helperF_GET_BASE_CURRENCY(CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), "N", P_CURR_CODE, P_NAME, P_DECIMAL+"", "E");
			if(list!= null && list.size()>0){
				P_CURR_CODE = list.get(0);
				P_NAME = list.get(1);
				P_DECIMAL = CommonUtils.parseToInt(list.get(2));
			}

			ArrayList<String> arrayList = DBProcedures.P_VAL_FINAL_PARAMETER(
					connection, P_CURR_CODE, "E");
			System.out.println("PVALFINAL PARAMETER:" + arrayList);

			// Base_Curr changes PREMIAGDC-0030	helperF_GET_BASE_CURRENCY added
//			P_SET_PARA_VALUES();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void STD_PRE_FORM(){
//		P_GET_LOGO;
//		COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');

		controlBean.setM_PARA_1(CommonUtils.getGlobalVariable("GLOBAL.M_PARA_1"));
	//	ctrlBean.setM_USER_ID((String)session.get("GLOBAL.M_USER_ID"));
//		bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
//		ctrlBean.setM_PROG_NAME("PILT010");
//		COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30), 'BUTTON_PALETTE.M_COMP_NAME') ;
	//	ctrlBean.setM_SCR_NAME(((String)session.get("GLOBAL.M_NAME")).substring(30, 42));
//		COPY('10','SYSTEM.MESSAGE_LEVEL');
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
		controlBean.setM_GOFLD_NAME("NULL");
	//	ctrlBean.setM_LANG_CODE((String)session.get("GLOBAL.M_LANG_CODE"));
	//	ctrlBean.setM_COMP_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
	//	ctrlBean.setM_DIVN_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));
	//	ctrlBean.setM_DEPT_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(9,11));

		//putCtrlBean(ctrlBean);
	}
	
	private void P_VAL_FINAL_PARAMETER(){
		System.out.println("PT_IL_CHEQ_REALISE_DTL_ACTION.P_VAL_FINAL_PARAMETER()");
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN","BASE.CURR");
		OracleParameter param2 = new OracleParameter("inout1","STRING","IN OUT","");
		OracleParameter param3 = new OracleParameter("in2","STRING","IN","E");
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		ArrayList<OracleParameter> outParam= null;
		try {
			outParam = new OracleProcedureHandler().execute(paramList, CommonUtils.getConnection(), "P_VAL_FINAL_PARAMETER");
		} catch (Exception e) {
			e.printStackTrace();
		}
		M_BASE_CURR = outParam.get(0).getValue();
	}
	
	
	public void whenNewBlkInst(){
//		CHECK_BLK_NAVG ;
	}
	public void whenCreateRecord(){
		CommonUtils commonUtils = new CommonUtils();
		try {
			getPT_IL_CHEQ_REALISE_DTL_BEAN().setUI_M_TO_DATE(commonUtils.getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public List<SuggesionBean> M_FM_BANKLOV(Object obj){
		String query = null;
		Object[] values = null;
		if("*".equals((String)obj)){
			query = "SELECT BANK_CODE, BANK_NAME FROM FM_BANK ORDER BY BANK_CODE";
			values = new Object[]{};
		}else{
			/*
			 * 
			 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
			 * 
			 * query = "SELECT BANK_CODE, BANK_NAME FROM FM_BANK WHERE ROWNUM < 25 AND (BANK_CODE LIKE ? OR BANK_NAME LIKE ? ) ORDER BY BANK_CODE";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
			query = "SELECT BANK_CODE, BANK_NAME FROM FM_BANK WHERE ROWNUM < 25 AND (UPPER(BANK_CODE) LIKE UPPER(?) OR UPPER(BANK_NAME) LIKE UPPER(?) ) ORDER BY BANK_CODE";
			/*end*/
			values = new Object[]{obj.toString()+"%",obj.toString()+"%"};
		}
		System.out.println("PT_IL_CHEQ_REALISE_DTL_ACTION.M_FM_BANKLOV(qry) "+query);
		ResultSet rs = null;
		try {
			rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),values);
			fromBank = new ArrayList<SuggesionBean>();
			while(rs.next()){
				SuggesionBean bean = new SuggesionBean();
				bean.setFromBank(rs.getString(1));
				bean.setFromBankDesc(rs.getString(2));
				fromBank.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fromBank;
	}
	
	public void M_FM_BANKLOVDesc(ActionEvent ae){
		String value = (String) getCOMP_UI_M_FM_BANK().getSubmittedValue();//(String) input.getValue();
		String query = "SELECT BANK_CODE, BANK_NAME FROM FM_BANK WHERE ROWNUM < 25 AND (BANK_CODE LIKE ? OR BANK_NAME LIKE ? ) ORDER BY BANK_CODE";
		System.out.println("PT_IL_CHEQ_REALISE_DTL_ACTION.M_FM_BANKLOVDesc(qqq) "+query);
		ResultSet rs = null;
		try {
			rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{value,value});
			if(rs.next()){
				getCOMP_UI_M_FM_BANK_DESC().setSubmittedValue(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<SuggesionBean> M_TO_BANKLOV(Object obj){
		String query = null;
		Object[] values = null;
		if(obj.toString().equals("*")){
			query = "SELECT BANK_CODE,BANK_NAME FROM FM_BANK ORDER BY BANK_CODE";
			values = new Object[]{};
		}else{
			/*
			 * 
			 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
			 * 
			 * query = "SELECT BANK_CODE, BANK_NAME FROM FM_BANK WHERE ROWNUM < 25 AND (BANK_CODE LIKE ? OR BANK_NAME LIKE ? ) ORDER BY BANK_CODE";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
			query = "SELECT BANK_CODE, BANK_NAME FROM FM_BANK WHERE ROWNUM < 25 AND (UPPER(BANK_CODE) LIKE UPPER(?) OR UPPER(BANK_NAME) LIKE UPPER(?) ) ORDER BY BANK_CODE";
			/*end*/
			values = new Object[]{obj.toString()+"%",obj.toString()+"%"};
		}
		System.out.println("PT_IL_CHEQ_REALISE_DTL_ACTION.M_FM_BANKLOV(qry) "+query);
		ResultSet rs = null;
		try {
			rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),values);
			toBank = new ArrayList<SuggesionBean>();
			while(rs.next()){
				SuggesionBean bean = new SuggesionBean();
				bean.setToBank(rs.getString(1));
				bean.setToBankDesc(rs.getString(2));
				toBank.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toBank;
	}
	
	public void M_TO_BANKLOVDesc(ActionEvent ae){
		String value = (String) getCOMP_UI_M_TO_BANK().getSubmittedValue();//(String) input.getValue();
		String query = "SELECT BANK_CODE, BANK_NAME FROM FM_BANK WHERE ROWNUM < 25 AND (BANK_CODE LIKE ? OR BANK_NAME LIKE ? ) ORDER BY BANK_CODE";
		System.out.println("PT_IL_CHEQ_REALISE_DTL_ACTION.M_FM_BANKLOVDesc(qqq) "+query);
		ResultSet rs = null;
		try {
			rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{value,value});
			if(rs.next()){
				getCOMP_UI_M_TO_BANK_DESC().setSubmittedValue(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	public void whenProcessButPressed(ActionEvent ae) {
		ResultSet rs = null;
		Connection connection = null;
		
		String M_DUMMY_X = null;
		DBProcedures procedures = new DBProcedures();

		String fmBank = (String) CommonUtils.getCurrentValue(getCOMP_UI_M_FM_BANK());
		String toBank = (String) CommonUtils.getCurrentValue(getCOMP_UI_M_TO_BANK());
		Date asOnDate = getCOMP_UI_M_TO_DATE().getAsDate(CommonUtils.getCurrentValue(getCOMP_UI_M_TO_DATE()));
		
		try {
			connection = CommonUtils.getConnection();
			
			procedures.callP9ILPK_CHEQ_REALIZATION_INS_CHEQ_PROCESS(CommonUtils.dateToStringFormatter(asOnDate), fmBank, toBank);

			rs = handler.executeSelectStatement("SELECT 'X' FROM PT_IL_CHEQ_REALISE_DTL", connection);
			if(rs.next()){
				M_DUMMY_X = rs.getString(1);
			}

			if (MigratingFunctions.nvl(M_DUMMY_X, "N").equalsIgnoreCase("X")){
				getWarningMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "3083"));
			}else{
				getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "60306"));
			}
			fetchRecords();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), 
					getCOMP_UI_M_BUT_PROCESS().getId(), getErrorMap(), getWarningMap());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void whenApprovedButPressed(ActionEvent ae){

		ResultSet rs = null;
		String M_DUMMY_X = null;
		Connection connection = null;
		DBProcedures procedures = new DBProcedures();
		
		try {
			connection = CommonUtils.getConnection();
			
			rs = handler.executeSelectStatement("SELECT 'X' FROM PT_IL_CHEQ_REALISE_DTL WHERE CHRD_ASSIGN_FLAG='Y'", connection);
			if(rs.next()){
				M_DUMMY_X = rs.getString(1);
			}

			if (MigratingFunctions.nvl(M_DUMMY_X, "N").equals("X")) {
				procedures.callP9ILPK_CHEQ_REALIZATION_CHEQ_REALISE_APPRV();
				
				getWarningMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "91071"));

				procedures.callP9ILPK_CHEQ_REALIZATION_DEL_CHEQ_DTLS();

				fetchRecords();
			}else{
				getWarningMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "71092"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), 
					getCOMP_UI_M_BUT_APPROVE().getId(), getErrorMap(), getWarningMap());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<PT_IL_CHEQ_REALISE_DTL> getDataValue() {
		return dataValue;
	}

	public void setDataValue(ArrayList<PT_IL_CHEQ_REALISE_DTL> dataValue) {
		this.dataValue = dataValue;
	}
	
	public void M_FM_BANK_WHEN_VALIDATE_ITEM(ActionEvent event) {

		UIInput input = (UIInput)event.getComponent().getParent();
		try {
			if(input.getSubmittedValue() != null && !input.getSubmittedValue().equals("")) {
				ErrorHelpUtil.validate(input, getErrorMap());
			} else {
				P_SET_FIRST_FIELD(getCOMP_UI_M_FM_BANK(), getCOMP_UI_M_TO_BANK());
				getPT_IL_CHEQ_REALISE_DTL_BEAN().setUI_M_FM_BANK_DESC(L_VAL_BANK((String) input.getSubmittedValue(), "E"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("deatil", e.getMessage());
		}
	}
	
	public void validateM_FM_BANK(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		P_SET_FIRST_FIELD(getCOMP_UI_M_FM_BANK(), getCOMP_UI_M_TO_BANK());
		try {
			getPT_IL_CHEQ_REALISE_DTL_BEAN().setUI_M_FM_BANK_DESC(L_VAL_BANK((String) value, "E"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void M_TO_BANK_WHEN_VALIDATE_ITEM(ActionEvent event) {

		UIInput input = (UIInput)event.getComponent().getParent();
		try {
			if(input.getSubmittedValue() != null && !input.getSubmittedValue().equals("")) {
				ErrorHelpUtil.validate(input, getErrorMap());
			} else {
				P_SET_SECOND_FIELD(getCOMP_UI_M_FM_BANK(), getCOMP_UI_M_TO_BANK(), getCOMP_UI_M_FM_BANK());
				getPT_IL_CHEQ_REALISE_DTL_BEAN().setUI_M_TO_BANK_DESC(L_VAL_BANK((String) input.getSubmittedValue(), "E"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("deatil", e.getMessage());
		}
	}
	
	public void validateM_TO_BANK(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		try {
			P_SET_SECOND_FIELD(getCOMP_UI_M_FM_BANK(), getCOMP_UI_M_TO_BANK(), getCOMP_UI_M_FM_BANK());
			getPT_IL_CHEQ_REALISE_DTL_BEAN().setUI_M_TO_BANK_DESC(L_VAL_BANK((String) value, "E"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	private void P_SET_FIRST_FIELD(UIInput field1, UIInput field2){
		String M_FIELD_DATA = (String) CommonUtils.getCurrentValue(field1);
		String M_DATA_TYPE = CommonUtils.getCurrentValue(field1).getClass().getSimpleName();
		
		if(M_FIELD_DATA == null || M_FIELD_DATA.trim().isEmpty()) {
			if(M_DATA_TYPE != null && (M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("int"))) {
				M_FIELD_DATA = "0";
			}
			field1.setSubmittedValue(M_FIELD_DATA);
		}
		if(M_DATA_TYPE != null && !M_DATA_TYPE.equalsIgnoreCase("Date")){
			//getCOMP_UI_M_DRCR_TO_TXN_CODE().setSubmittedValue(getCOMP_UI_M_DRCR_TO_TXN_CODE().getSubmittedValue());
		}
	}
	
	private void P_SET_SECOND_FIELD(UIInput field1, UIInput field2, HtmlInputText firstText) throws Exception {

		int M_FIELD_LENGTH = -1;
		String M_FIELD_DATA = (String) CommonUtils.getCurrentValue(field2);
		String M_DATA_TYPE = CommonUtils.getCurrentValue(field1).getClass().getSimpleName();
		String field1Data = (String) CommonUtils.getCurrentValue(field1);

		DBProcedures procedures = new DBProcedures();
		ArrayList<String> valueList = null;

		try {
			if(M_FIELD_DATA == null || M_FIELD_DATA.trim().isEmpty()) {

				M_FIELD_LENGTH = firstText.getMaxlength();
				if(M_DATA_TYPE != null && (M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("int"))) {

					M_FIELD_DATA = "0";
				}
				field2.setSubmittedValue(M_FIELD_DATA);

				if(M_DATA_TYPE != null && (M_DATA_TYPE.equalsIgnoreCase("String"))) {

					if(field1Data != null && field1Data.equals(M_FIELD_DATA)) {

						M_FIELD_DATA = StringFunctions.substr("zzzzzzzzzzzzzzzzzzzzzz", 1, M_FIELD_LENGTH);
					} else {
						
						M_FIELD_DATA = field1Data;
					}
					field2.setSubmittedValue(M_FIELD_DATA);
				} 
			}

			if(M_DATA_TYPE.equalsIgnoreCase("String")) {

				valueList = procedures.callPR_VALIDATE_FM_TO(field1Data, M_FIELD_DATA, "");
				if(valueList != null && valueList.size() > 0 && valueList.get(0).equals("1")){
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "10064"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	private String L_VAL_BANK(String P_BANK_CODE, String P_ERR_FLAG) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet_C1=null;
		Object[] values = null;
	
		String sql_C1 = "SELECT BANK_NAME FROM FM_BANK WHERE BANK_CODE = ?";
		String P_BANK_NAME = null;
		
		try {
			connection = CommonUtils.getConnection();
			
            if(!MigratingFunctions.nvl(P_BANK_CODE, "X").equals("0")
            		&& !MigratingFunctions.nvl(P_BANK_CODE, "X").equals("zzzzzzzzzzzz")) {
               
            	values = new Object[1];
            	values[0] = P_BANK_CODE;
            	
            	resultSet_C1 = handler.executeSelectStatement(sql_C1, connection, values);
            	
                if(resultSet_C1.next()) {
                	P_BANK_NAME = resultSet_C1.getString(1);
                
                } else {
                    if("W".equals(P_ERR_FLAG) || "E".equals(P_ERR_FLAG)) {
                    	
                    	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "3206", new Object[]{"Invalid Bank Code"}));
                       /* if(P_ERR_FLAG.equals(""+"E"))
                        {
                            throw new FORM_TRIGGER_FAILURE();
                        }*/
                    }
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
        	CommonUtils.closeCursor(resultSet_C1);
        }
        return P_BANK_NAME;
    }
	
	private void fetchRecords() throws Exception {
		ResultSet resultSet = null;
		Connection connection = null;
		String query = "SELECT * FROM PT_IL_CHEQ_REALISE_DTL ORDER BY CHRD_DEP_REF_NO";

		try {
			connection = CommonUtils.getConnection();
			dataValue = new ArrayList<PT_IL_CHEQ_REALISE_DTL>();
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				PT_IL_CHEQ_REALISE_DTL bean = new PT_IL_CHEQ_REALISE_DTL();
				bean.setCHRD_DEP_REF_NO(resultSet.getString("CHRD_DEP_REF_NO"));
				bean.setCHRD_DEP_TXN_CODE(resultSet.getString("CHRD_DEP_TXN_CODE"));
				bean.setCHRD_DEP_DOC_NO(resultSet.getDouble("CHRD_DEP_DOC_NO"));
				bean.setCHRD_DEP_DOC_DT(resultSet.getDate("CHRD_DEP_DOC_DT"));
				bean.setCHRD_PD_CHQ_NO(resultSet.getString("CHRD_PD_CHQ_NO"));
				bean.setCHRD_PD_CHQ_DT(resultSet.getDate("CHRD_PD_CHQ_DT"));
				bean.setCHRD_DEP_LC_TOTAL_AMT(resultSet.getDouble("CHRD_DEP_LC_TOTAL_AMT"));
				bean.setCHRD_ASSIGN_FLAG(resultSet.getString("CHRD_ASSIGN_FLAG"));
				dataValue.add(bean);
			}
			/*Added by Sivarajan on 29/02/2020 for Orient IL*/
			if(dataValue != null && dataValue.size() > 0){
				PT_IL_CHEQ_REALISE_DTL_BEAN = dataValue.get(0);
				PT_IL_CHEQ_REALISE_DTL_BEAN.setRowSelected(true);
				
			}
			/*End*/
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public ArrayList<SuggesionBean> getFromBank() {
		return fromBank;
	}

	public void setFromBank(ArrayList<SuggesionBean> fromBank) {
		this.fromBank = fromBank;
	}

	public ArrayList<SuggesionBean> getToBank() {
		return toBank;
	}

	public void setToBank(ArrayList<SuggesionBean> toBank) {
		this.toBank = toBank;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_CHEQ_REALISE_DTL_BEAN = (PT_IL_CHEQ_REALISE_DTL) dataTable
					.getRowData();
			PT_IL_CHEQ_REALISE_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_CHEQ_REALISE_DTL> iterator = dataValue
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent(){
		COMP_CHRD_DEP_REF_NO.resetValue();
		COMP_CHRD_DEP_TXN_CODE.resetValue();
		COMP_CHRD_DEP_DOC_DT.resetValue();
		COMP_CHRD_DEP_LC_TOTAL_AMT.resetValue();
		COMP_CHRD_DEP_DOC_NO.resetValue();
		COMP_CHRD_PD_CHQ_DT.resetValue();
		COMP_CHRD_PD_CHQ_NO.resetValue();
	}
}
