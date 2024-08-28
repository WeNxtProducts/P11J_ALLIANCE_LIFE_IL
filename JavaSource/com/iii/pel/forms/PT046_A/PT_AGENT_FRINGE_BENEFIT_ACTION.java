package com.iii.pel.forms.PT046_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP022.CustomerBean;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PM091_A.PM_AGENT_BENEFIT_HDR;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_AGENT_FRINGE_BENEFIT_ACTION extends CommonAction{

	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
	Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	//private ControlBean controlBean = null;
	private ResultSet resultSet;
	private CRUDHandler handler = new CRUDHandler();
	private OracleProcedureHandler ora_Handler = new OracleProcedureHandler();
	private HtmlSelectBooleanCheckbox checkBox;
	private List<PT_AGENT_FRINGE_BENEFIT> fringe_Benefit_List = new ArrayList<PT_AGENT_FRINGE_BENEFIT>();
	private UIDataTable fringe_Benefit_Table;
	OracleProcedureHandler ora_handler = new OracleProcedureHandler();

	private List<SelectItem> selectItem = new ArrayList<SelectItem>();
	private List<SelectItem> frequencyItems = new ArrayList<SelectItem>();

	private String M_WHERE;

	private HtmlOutputLabel COMP_UI_M_AGENT_FM_CODE_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_FM_CODE;

	private HtmlOutputLabel COMP_UI_M_AGENT_FM_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_FM_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_AGENT_TO_CODE_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_TO_CODE;

	private HtmlOutputLabel COMP_UI_M_AGENT_TO_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_TO_CODE_DESC;

	private HtmlInputText COMP_UI_M_BEN_FM_CODE;

	private HtmlInputText COMP_UI_M_BEN_FM_CODE_DESC;

	private HtmlInputText COMP_UI_M_BEN_TO_CODE;

	private HtmlInputText COMP_UI_M_BEN_TO_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_PROCESS_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PROCESS_FM_DT;

	private HtmlOutputLabel COMP_UI_M_PROCESS_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PROCESS_TO_DT;

	private HtmlOutputLabel COMP_AFB_AGENT_CODE_LABEL;

	private HtmlInputText COMP_AFB_AGENT_CODE;

	private HtmlOutputLabel COMP_AFB_PROCESS_DT_LABEL;

	private HtmlCalendar COMP_AFB_PROCESS_DT;

	private HtmlOutputLabel COMP_AFB_BNF_CODE_LABEL;

	private HtmlInputText COMP_AFB_BNF_CODE;

	private HtmlOutputLabel COMP_AFB_FREQ_LABEL;

	private HtmlSelectOneMenu COMP_AFB_FREQ;

	private HtmlOutputLabel COMP_AFB_FC_VALUE_LABEL;

	private HtmlInputText COMP_AFB_FC_VALUE;

	private HtmlOutputLabel COMP_AFB_LC_VALUE_LABEL;

	private HtmlInputText COMP_AFB_LC_VALUE;

	private HtmlOutputLabel COMP_AFB_PAID_DT_LABEL;

	private HtmlCalendar COMP_AFB_PAID_DT;

	private HtmlOutputLabel COMP_AFB_FRZ_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_AFB_FRZ_FLAG;
	
	
	/*Newly added by pidugu raj dt: 11-09-2018 for Bulk Freeze option as per sivaraman suggestion for Benefit Details Screen*/
	private HtmlSelectOneMenu COMP_AFB_FRZ_FLAG_Bulk;
	private HtmlOutputLabel COMP_DEFN_YN_ALL;
	/*End Newly added by pidugu raj dt: 11-09-2018 for Bulk Freeze option as per sivaraman suggestion for Benefit Details Screen*/
	


	private HtmlOutputLabel COMP_UI_M_AGENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_AGENT_FM_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_AGENT_TO_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private PT_AGENT_FRINGE_BENEFIT PT_AGENT_FRINGE_BENEFIT_BEAN;

	private int currentPage;

	private UIData dataTable;

	private String filterBYUI_M_AGENT_NAME;

	private String filterBYAFB_AGENT_CODE;

	private boolean DEFAULT_FIELD_DISABLE=true;

	private boolean FREEZE_FIELD_DISABLE=true;

	List suggesionList = new ArrayList();
	
	private PT_AGENT_FRINGE_BENEFIT pT_AGENT_FRINGE_BENEFIT;

	public PT_AGENT_FRINGE_BENEFIT_ACTION() {
		PT_AGENT_FRINGE_BENEFIT_BEAN = new PT_AGENT_FRINGE_BENEFIT();

		// Fetch drop-down values
		fetchSelectItems();

		//createCtrlBean();
		PT046_A_PRE_FORM();
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_FM_CODE_LABEL() {
		return COMP_UI_M_AGENT_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_FM_CODE() {
		return COMP_UI_M_AGENT_FM_CODE;
	}

	public void setCOMP_UI_M_AGENT_FM_CODE_LABEL(HtmlOutputLabel COMP_UI_M_AGENT_FM_CODE_LABEL) {
		this.COMP_UI_M_AGENT_FM_CODE_LABEL = COMP_UI_M_AGENT_FM_CODE_LABEL;
	}

	public void setCOMP_UI_M_AGENT_FM_CODE(HtmlInputText COMP_UI_M_AGENT_FM_CODE) {
		this.COMP_UI_M_AGENT_FM_CODE = COMP_UI_M_AGENT_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_FM_CODE_DESC_LABEL() {
		return COMP_UI_M_AGENT_FM_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_FM_CODE_DESC() {
		return COMP_UI_M_AGENT_FM_CODE_DESC;
	}

	public void setCOMP_UI_M_AGENT_FM_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_AGENT_FM_CODE_DESC_LABEL) {
		this.COMP_UI_M_AGENT_FM_CODE_DESC_LABEL = COMP_UI_M_AGENT_FM_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_AGENT_FM_CODE_DESC(HtmlInputText COMP_UI_M_AGENT_FM_CODE_DESC) {
		this.COMP_UI_M_AGENT_FM_CODE_DESC = COMP_UI_M_AGENT_FM_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_TO_CODE_LABEL() {
		return COMP_UI_M_AGENT_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_TO_CODE() {
		return COMP_UI_M_AGENT_TO_CODE;
	}

	public void setCOMP_UI_M_AGENT_TO_CODE_LABEL(HtmlOutputLabel COMP_UI_M_AGENT_TO_CODE_LABEL) {
		this.COMP_UI_M_AGENT_TO_CODE_LABEL = COMP_UI_M_AGENT_TO_CODE_LABEL;
	}

	public void setCOMP_UI_M_AGENT_TO_CODE(HtmlInputText COMP_UI_M_AGENT_TO_CODE) {
		this.COMP_UI_M_AGENT_TO_CODE = COMP_UI_M_AGENT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_TO_CODE_DESC_LABEL() {
		return COMP_UI_M_AGENT_TO_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_TO_CODE_DESC() {
		return COMP_UI_M_AGENT_TO_CODE_DESC;
	}

	public void setCOMP_UI_M_AGENT_TO_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_AGENT_TO_CODE_DESC_LABEL) {
		this.COMP_UI_M_AGENT_TO_CODE_DESC_LABEL = COMP_UI_M_AGENT_TO_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_AGENT_TO_CODE_DESC(HtmlInputText COMP_UI_M_AGENT_TO_CODE_DESC) {
		this.COMP_UI_M_AGENT_TO_CODE_DESC = COMP_UI_M_AGENT_TO_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_FM_DT_LABEL() {
		return COMP_UI_M_PROCESS_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_FM_DT() {
		return COMP_UI_M_PROCESS_FM_DT;
	}

	public void setCOMP_UI_M_PROCESS_FM_DT_LABEL(HtmlOutputLabel COMP_UI_M_PROCESS_FM_DT_LABEL) {
		this.COMP_UI_M_PROCESS_FM_DT_LABEL = COMP_UI_M_PROCESS_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_FM_DT(HtmlCalendar COMP_UI_M_PROCESS_FM_DT) {
		this.COMP_UI_M_PROCESS_FM_DT = COMP_UI_M_PROCESS_FM_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_TO_DT_LABEL() {
		return COMP_UI_M_PROCESS_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_TO_DT() {
		return COMP_UI_M_PROCESS_TO_DT;
	}

	public void setCOMP_UI_M_PROCESS_TO_DT_LABEL(HtmlOutputLabel COMP_UI_M_PROCESS_TO_DT_LABEL) {
		this.COMP_UI_M_PROCESS_TO_DT_LABEL = COMP_UI_M_PROCESS_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_TO_DT(HtmlCalendar COMP_UI_M_PROCESS_TO_DT) {
		this.COMP_UI_M_PROCESS_TO_DT = COMP_UI_M_PROCESS_TO_DT;
	}

	public HtmlOutputLabel getCOMP_AFB_AGENT_CODE_LABEL() {
		return COMP_AFB_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_AFB_AGENT_CODE() {
		return COMP_AFB_AGENT_CODE;
	}

	public void setCOMP_AFB_AGENT_CODE_LABEL(HtmlOutputLabel COMP_AFB_AGENT_CODE_LABEL) {
		this.COMP_AFB_AGENT_CODE_LABEL = COMP_AFB_AGENT_CODE_LABEL;
	}

	public void setCOMP_AFB_AGENT_CODE(HtmlInputText COMP_AFB_AGENT_CODE) {
		this.COMP_AFB_AGENT_CODE = COMP_AFB_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_AFB_PROCESS_DT_LABEL() {
		return COMP_AFB_PROCESS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_AFB_PROCESS_DT() {
		return COMP_AFB_PROCESS_DT;
	}

	public void setCOMP_AFB_PROCESS_DT_LABEL(HtmlOutputLabel COMP_AFB_PROCESS_DT_LABEL) {
		this.COMP_AFB_PROCESS_DT_LABEL = COMP_AFB_PROCESS_DT_LABEL;
	}

	public void setCOMP_AFB_PROCESS_DT(HtmlCalendar COMP_AFB_PROCESS_DT) {
		this.COMP_AFB_PROCESS_DT = COMP_AFB_PROCESS_DT;
	}

	public HtmlOutputLabel getCOMP_AFB_BNF_CODE_LABEL() {
		return COMP_AFB_BNF_CODE_LABEL;
	}

	public HtmlInputText getCOMP_AFB_BNF_CODE() {
		return COMP_AFB_BNF_CODE;
	}

	public void setCOMP_AFB_BNF_CODE_LABEL(HtmlOutputLabel COMP_AFB_BNF_CODE_LABEL) {
		this.COMP_AFB_BNF_CODE_LABEL = COMP_AFB_BNF_CODE_LABEL;
	}

	public void setCOMP_AFB_BNF_CODE(HtmlInputText COMP_AFB_BNF_CODE) {
		this.COMP_AFB_BNF_CODE = COMP_AFB_BNF_CODE;
	}

	public HtmlOutputLabel getCOMP_AFB_FREQ_LABEL() {
		return COMP_AFB_FREQ_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_AFB_FREQ() {
		return COMP_AFB_FREQ;
	}

	public void setCOMP_AFB_FREQ_LABEL(HtmlOutputLabel COMP_AFB_FREQ_LABEL) {
		this.COMP_AFB_FREQ_LABEL = COMP_AFB_FREQ_LABEL;
	}

	public void setCOMP_AFB_FREQ(HtmlSelectOneMenu COMP_AFB_FREQ) {
		this.COMP_AFB_FREQ = COMP_AFB_FREQ;
	}

	public HtmlOutputLabel getCOMP_AFB_FC_VALUE_LABEL() {
		return COMP_AFB_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_AFB_FC_VALUE() {
		return COMP_AFB_FC_VALUE;
	}

	public void setCOMP_AFB_FC_VALUE_LABEL(HtmlOutputLabel COMP_AFB_FC_VALUE_LABEL) {
		this.COMP_AFB_FC_VALUE_LABEL = COMP_AFB_FC_VALUE_LABEL;
	}

	public void setCOMP_AFB_FC_VALUE(HtmlInputText COMP_AFB_FC_VALUE) {
		this.COMP_AFB_FC_VALUE = COMP_AFB_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_AFB_LC_VALUE_LABEL() {
		return COMP_AFB_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_AFB_LC_VALUE() {
		return COMP_AFB_LC_VALUE;
	}

	public void setCOMP_AFB_LC_VALUE_LABEL(HtmlOutputLabel COMP_AFB_LC_VALUE_LABEL) {
		this.COMP_AFB_LC_VALUE_LABEL = COMP_AFB_LC_VALUE_LABEL;
	}

	public void setCOMP_AFB_LC_VALUE(HtmlInputText COMP_AFB_LC_VALUE) {
		this.COMP_AFB_LC_VALUE = COMP_AFB_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_AFB_PAID_DT_LABEL() {
		return COMP_AFB_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_AFB_PAID_DT() {
		return COMP_AFB_PAID_DT;
	}

	public void setCOMP_AFB_PAID_DT_LABEL(HtmlOutputLabel COMP_AFB_PAID_DT_LABEL) {
		this.COMP_AFB_PAID_DT_LABEL = COMP_AFB_PAID_DT_LABEL;
	}

	public void setCOMP_AFB_PAID_DT(HtmlCalendar COMP_AFB_PAID_DT) {
		this.COMP_AFB_PAID_DT = COMP_AFB_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_AFB_FRZ_FLAG_LABEL() {
		return COMP_AFB_FRZ_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_AFB_FRZ_FLAG() {
		return COMP_AFB_FRZ_FLAG;
	}

	public void setCOMP_AFB_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_AFB_FRZ_FLAG_LABEL) {
		this.COMP_AFB_FRZ_FLAG_LABEL = COMP_AFB_FRZ_FLAG_LABEL;
	}

	public void setCOMP_AFB_FRZ_FLAG(HtmlSelectOneMenu COMP_AFB_FRZ_FLAG) {
		this.COMP_AFB_FRZ_FLAG = COMP_AFB_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_NAME_LABEL() {
		return COMP_UI_M_AGENT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_NAME() {
		return COMP_UI_M_AGENT_NAME;
	}

	public void setCOMP_UI_M_AGENT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_AGENT_NAME_LABEL) {
		this.COMP_UI_M_AGENT_NAME_LABEL = COMP_UI_M_AGENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_AGENT_NAME(HtmlInputText COMP_UI_M_AGENT_NAME) {
		this.COMP_UI_M_AGENT_NAME = COMP_UI_M_AGENT_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_AGENT_FM_CODE_LOV() {
		return COMP_UI_M_BUT_AGENT_FM_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_AGENT_FM_CODE_LOV(HtmlCommandButton COMP_UI_M_BUT_AGENT_FM_CODE_LOV) {
		this.COMP_UI_M_BUT_AGENT_FM_CODE_LOV = COMP_UI_M_BUT_AGENT_FM_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_AGENT_TO_CODE_LOV() {
		return COMP_UI_M_BUT_AGENT_TO_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_AGENT_TO_CODE_LOV(HtmlCommandButton COMP_UI_M_BUT_AGENT_TO_CODE_LOV) {
		this.COMP_UI_M_BUT_AGENT_TO_CODE_LOV = COMP_UI_M_BUT_AGENT_TO_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public PT_AGENT_FRINGE_BENEFIT getPT_AGENT_FRINGE_BENEFIT_BEAN() {
		return PT_AGENT_FRINGE_BENEFIT_BEAN;
	}

	public void setPT_AGENT_FRINGE_BENEFIT_BEAN(PT_AGENT_FRINGE_BENEFIT PT_AGENT_FRINGE_BENEFIT_BEAN) {
		this.PT_AGENT_FRINGE_BENEFIT_BEAN = PT_AGENT_FRINGE_BENEFIT_BEAN;
	}

	public void PT046_A_PRE_FORM(){
		//Remove Once Deploy
//		controlBean = getControlBean();
//		session.put("GLOBAL.M_LANG_CODE", "ENG");
//		session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
//		session.put("GLOBAL.M_USER_ID", "LIFEALL");
//		session.put("GLOBAL.M_COMP_CODE","001");
//		session.put("M_PROG_NAME", "PT046_A");
		session.put("GLOBAL.M_DFLT_VALUES","12345678911111111");
//		//Remove Once Deploy
//		PT046_A_STD_PRE_FORM();
		ControlBean ctrlBean=CommonUtils.getControlBean();
		ArrayList<OracleParameter> inputList=new ArrayList<OracleParameter>();
		inputList.add(new OracleParameter("in1","STRING","IN",ctrlBean.getM_LANG_CODE()));
		inputList.add(new OracleParameter("in2","STRING","IN",null));
		inputList.add(new OracleParameter("in3","STRING","IN",ctrlBean.getM_USER_ID()));
		inputList.add(new OracleParameter("in4","STRING","IN",ctrlBean.getM_COMP_CODE()));
		inputList.add(new OracleParameter("in5","STRING","IN",ctrlBean.getM_DIVN_CODE()));
		inputList.add(new OracleParameter("in6","STRING","IN",ctrlBean.getM_DEPT_CODE()));
		inputList.add(new OracleParameter("in7","STRING","IN",ctrlBean.getM_BASE_CURR()));
		inputList.add(new OracleParameter("in8","STRING","IN","2"));
		inputList.add(new OracleParameter("in9","STRING","IN","PT046_A"));

		

		
	}

	public void PT046_A_STD_PRE_FORM(){

	}

	public List UI_M_AGENT_FM_CODE_LOV(Object obj) throws Exception{
		List suggesionList = new ArrayList();
		getCOMP_UI_M_AGENT_FM_CODE().setSubmittedValue(null);
		String query = null;
		if(obj.toString().equals("*")){
			query = "select cust_code,cust_name,cust_bl_name,cust_long_name,cust_ref_id1,cust_bl_addr1 from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' AND  rownum < 25";
		}else{
			query = "select cust_code,cust_name,cust_bl_name,cust_long_name,cust_ref_id1,cust_bl_addr1 from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' and CUST_CODE LIKE '"+obj.toString()+"%' and rownum < 25";
		}	

		resultSet = handler.executeSelectStatement(query,getConnection());
		resultSet.setFetchSize(25);
		while(resultSet.next()){
			CustomerBean cbean = new CustomerBean();
			cbean.setCUST_BL_ADDR1(resultSet.getString("cust_bl_addr1"));
			cbean.setCUST_BL_NAME(resultSet.getString("cust_bl_name"));
			cbean.setCUST_CODE(resultSet.getString("cust_code"));
			cbean.setCUST_LONG_NAME(resultSet.getString("cust_long_name"));
			cbean.setCUST_NAME(resultSet.getString("cust_name"));
			cbean.setCUST_REF_ID1(resultSet.getString("cust_ref_id1"));
			suggesionList.add(cbean);
		}
		resultSet.close();
		return suggesionList;
	}

	public void M_AGENT_FM_CODE_WHEN_VALIDATE_ITEM(ActionEvent ae){
		if(!getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue().toString().equals("")){
			PT_AGENT_FRINGE_BENEFIT_BEAN.setUI_M_AGENT_FM_CODE(getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue().toString());
			String C1 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE  CUST_CODE = '"+getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue().toString()+"'";
			try {
				resultSet = handler.executeSelectStatement(C1, getConnection());
				while(resultSet.next()){
					getCOMP_UI_M_AGENT_FM_CODE_DESC().setSubmittedValue(resultSet.getString("CUST_NAME"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(!getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue().toString().equals("")){
				L_VAL_FROM_TO(getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue().toString(),getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue().toString());
			}
		}else{
			getCOMP_UI_M_AGENT_FM_CODE().setSubmittedValue(L_SET_FIRST_FIELD(getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue().toString(),getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue().toString()));
		}
	}

	public String L_SET_FIRST_FIELD(String from_Code,String to_Code){
		if(from_Code.equals("")){
			from_Code = "0";
		}
		return from_Code;
	}

	public List UI_M_AGENT_TO_CODE_LOV(Object obj) throws Exception{
		List suggesionList = new ArrayList();
		getCOMP_UI_M_AGENT_TO_CODE().setSubmittedValue(null);
		String query = null;
		if(obj.toString().equals("*")){
			query = "select cust_code,cust_name,cust_bl_name,cust_long_name,cust_ref_id1,cust_bl_addr1 from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' AND  rownum < 25";
		}else{
			query = "select cust_code,cust_name,cust_bl_name,cust_long_name,cust_ref_id1,cust_bl_addr1 from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' and CUST_CODE LIKE '"+obj.toString()+"%' and rownum < 25";
		}	

		resultSet = handler.executeSelectStatement(query,getConnection());
		resultSet.setFetchSize(25);
		while(resultSet.next()){
			CustomerBean cbean = new CustomerBean();
			cbean.setCUST_BL_ADDR1(resultSet.getString("cust_bl_addr1"));
			cbean.setCUST_BL_NAME(resultSet.getString("cust_bl_name"));
			cbean.setCUST_CODE(resultSet.getString("cust_code"));
			cbean.setCUST_LONG_NAME(resultSet.getString("cust_long_name"));
			cbean.setCUST_NAME(resultSet.getString("cust_name"));
			cbean.setCUST_REF_ID1(resultSet.getString("cust_ref_id1"));
			suggesionList.add(cbean);
		}
		resultSet.close();
		return suggesionList;
	}

	public void M_AGENT_TO_CODE_WHEN_VALIDATE_ITEM(ActionEvent ae){
		if(getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue().equals("")){
			getCOMP_UI_M_AGENT_TO_CODE().setSubmittedValue(L_SET_SECOND_FIELD(getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue().toString(),getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue().toString()));
		}
		if(!getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue().equals("")){
			PT_AGENT_FRINGE_BENEFIT_BEAN.setUI_M_AGENT_TO_CODE(getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue().toString());
			String C1 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = '"+getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue().toString()+"'";
			try {
				resultSet = handler.executeSelectStatement(C1, getConnection());
				while(resultSet.next()){
					getCOMP_UI_M_AGENT_TO_CODE_DESC().setSubmittedValue(resultSet.getString("CUST_NAME"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					resultSet.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			L_VAL_FROM_TO(getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue().toString(),getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue().toString());
		}
	}

	public String L_SET_SECOND_FIELD(String M_FIELD_NAME1,String M_FIELD_NAME2){
		if(M_FIELD_NAME2.equals("")){
			if(M_FIELD_NAME1.equals("0"))
				M_FIELD_NAME2 = "zzzzzzzzz";
			else
				M_FIELD_NAME2 = M_FIELD_NAME1;
		}
		return M_FIELD_NAME2;
	}

	public void L_VAL_FROM_TO(String P_FROM_CODE,String P_TO_CODE){
		if(P_FROM_CODE.equals("")){
			getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80033").getDetail());
		}
		if(P_TO_CODE.compareTo(P_FROM_CODE) < 0){
			getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80034").getDetail());
		}
	}
	
	/*Newly added by pidugu raj dt: 10-09-2018 for KIC*/
	public void validateFromDate(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		try {
			PT_AGENT_FRINGE_BENEFIT_BEAN.setUI_M_PROCESS_FM_DT(curDate);
			
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	public void validateTODate(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		try {
			PT_AGENT_FRINGE_BENEFIT_BEAN.setUI_M_PROCESS_TO_DT(curDate);
			
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(2999, 11, 31);
		Date default_Date = calendar.getTime();
		Iterator<PT_AGENT_FRINGE_BENEFIT> iterator = null;
		PT_AGENT_FRINGE_BENEFIT benefitBean = null;
		Date from_Date = PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_PROCESS_FM_DT();
		Date to_Date = PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_PROCESS_TO_DT();
		if(from_Date != null){
			if(!compare_Date(from_Date,to_Date)){
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91001").getDetail());
			}else{
				getErrorMap().clear();
				if(!compare_Date(to_Date, default_Date)){
					getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91063").getDetail());
				}else{
					getErrorMap().clear();
					PT_AGENT_FRINGE_BENEFIT_WHEN_NEW_BLOCK_INSTANCE();

					for(PT_AGENT_FRINGE_BENEFIT agentFringeBenefitBean : fringe_Benefit_List) {
						/*Newly added by pidugu raj dt: 15-10-2018 as suggested by sivaraman*/
						try {
							for(int i=0;i<=fringe_Benefit_List.size();i++){
							String C1 = "SELECT CUST_NAME FROM   PM_CUSTOMER WHERE  CUST_CODE = '"+agentFringeBenefitBean.getAFB_AGENT_CODE()+"'";
							resultSet = handler.executeSelectStatement(C1, getConnection());
							while(resultSet.next()){
								agentFringeBenefitBean.setUI_M_AGENT_NAME(resultSet.getString("CUST_NAME"));
							}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							try {
								resultSet.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						/*End Newly added by pidugu raj dt: 15-10-2018 as suggested by sivaraman*/
						
						/*Commented by pidugu raj dt: 15-10-2018 to avoid duplicate customer name in fringe benefit details screen
						//PT_AGENT_FRINGE_BENEFIT_POST_QUERY(agentFringeBenefitBean);
						 * End
						 */
						//PT_AGENT_FRINGE_BENEFIT_WHEN_NEW_RECORD_INSTANCE(agentFringeBenefitBean);
					}

					if(fringe_Benefit_List != null && fringe_Benefit_List.size() > 0){
						iterator = fringe_Benefit_List.iterator();
						while(iterator.hasNext()){
							benefitBean = iterator.next();
							if(benefitBean != null){
								if("Y".equals(benefitBean.getAFB_FRZ_FLAG())){
									benefitBean.setDisableFrzFlag(true);
								}else{
									benefitBean.setDisableFrzFlag(false);
								}
							}
						}
					}
				}
				if(fringe_Benefit_List!=null){
					for(int i=0;i<fringe_Benefit_List.size();i++){
						PT_AGENT_FRINGE_BENEFIT pt_agent_fringe_benefit = fringe_Benefit_List.get(i);
						/*if(i==0){
							//pt_agent_fringe_benefit.setRowSelected(true);
							setPT_AGENT_FRINGE_BENEFIT_BEAN(pt_agent_fringe_benefit);
						}else{*/
							pt_agent_fringe_benefit.setRowSelected(false);
							setPT_AGENT_FRINGE_BENEFIT_BEAN(pt_agent_fringe_benefit);
						}
					}
				}
			}
		}
	//}
	
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	/*End Added by pidugu raj dt: 10-09-2018 for kic*/

	public void M_PROCESS_FM_DT_WHEN_VALIDATE_ITEM(ActionEvent ae){
		Date from_Date = (Date) getCOMP_UI_M_PROCESS_FM_DT().getSubmittedValue();
		Date to_Date = (Date) getCOMP_UI_M_PROCESS_FM_DT().getSubmittedValue();
		/*Date from_Date = PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_PROCESS_FM_DT();
		Date to_Date = PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_PROCESS_TO_DT();*/
		Calendar calendar = Calendar.getInstance();
		calendar.set(1900, 00, 01);
		Date default_Date = calendar.getTime();
		if(compare_Date(from_Date,default_Date)){
			getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91063").getDetail());
		}else{
			getErrorMap().clear();
		}
		if(to_Date != null ){
			if(!compare_Date(from_Date,to_Date)){
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91010").getDetail());
			}else{
				getErrorMap().clear();
			}
		}
	}

	public boolean compare_Date(Date from_Date,Date to_Date){
		boolean status = false;
		if(from_Date != null && to_Date != null){
			if(from_Date.compareTo(to_Date) <= 0){
				status = true;
			}
		}
		return status;
	}

	public void M_PROCESS_TO_DT_WHEN_VALIDATE_ITEM(ActionEvent ae){
		Date from_Date = PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_PROCESS_FM_DT();
		Date to_Date = PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_PROCESS_TO_DT();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2999, 11, 31);

		Date default_Date = calendar.getTime();
		Iterator<PT_AGENT_FRINGE_BENEFIT> iterator = null;
		PT_AGENT_FRINGE_BENEFIT benefitBean = null;

		if(from_Date != null){
			if(!compare_Date(from_Date,to_Date)){
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91001").getDetail());
			}else{
				getErrorMap().clear();
				if(!compare_Date(to_Date, default_Date)){
					getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91063").getDetail());
				}else{
					getErrorMap().clear();
					PT_AGENT_FRINGE_BENEFIT_WHEN_NEW_BLOCK_INSTANCE();

					for(PT_AGENT_FRINGE_BENEFIT agentFringeBenefitBean : fringe_Benefit_List) {
						/*Newly added by pidugu raj dt: 15-10-2018 as suggested by sivaraman*/
						try {
							for(int i=0;i<=fringe_Benefit_List.size();i++){
							String C1 = "SELECT CUST_NAME FROM   PM_CUSTOMER WHERE  CUST_CODE = '"+agentFringeBenefitBean.getAFB_AGENT_CODE()+"'";
							resultSet = handler.executeSelectStatement(C1, getConnection());
							while(resultSet.next()){
								agentFringeBenefitBean.setUI_M_AGENT_NAME(resultSet.getString("CUST_NAME"));
							}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							try {
								resultSet.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						/*EndNewly added by pidugu raj dt: 15-10-2018 as suggested by sivaraman*/
						
						/*Commented by pidugu raj dt: 15-10-2018 to avoid duplicate customer name in fringe benefit details screen
						//PT_AGENT_FRINGE_BENEFIT_POST_QUERY(agentFringeBenefitBean);
						 * End
						 */
						//PT_AGENT_FRINGE_BENEFIT_WHEN_NEW_RECORD_INSTANCE(agentFringeBenefitBean);
					}

					if(fringe_Benefit_List != null && fringe_Benefit_List.size() > 0){
						iterator = fringe_Benefit_List.iterator();
						while(iterator.hasNext()){
							benefitBean = iterator.next();
							if(benefitBean != null){
								if("Y".equals(benefitBean.getAFB_FRZ_FLAG())){
									benefitBean.setDisableFrzFlag(true);
								}else{
									benefitBean.setDisableFrzFlag(false);
								}
							}
						}
					}
				}
				if(fringe_Benefit_List!=null){
					for(int i=0;i<fringe_Benefit_List.size();i++){
						PT_AGENT_FRINGE_BENEFIT pt_agent_fringe_benefit = fringe_Benefit_List.get(i);
						if(i==0){
							pt_agent_fringe_benefit.setRowSelected(true);
							setPT_AGENT_FRINGE_BENEFIT_BEAN(pt_agent_fringe_benefit);
						}else{
							pt_agent_fringe_benefit.setRowSelected(false);
						}
					}
				}
			}
		}
	}

	public void M_BUT_APPROVE_WHEN_BUTTON_PRESSED(ActionEvent ae){
		int errorCode=-1;
		Iterator<PT_AGENT_FRINGE_BENEFIT> iterator = null;
		PT_AGENT_FRINGE_BENEFIT benefitBean = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CommonUtils utils = new CommonUtils();
			/*paramList.clear();
			paramList.add(new OracleParameter("in1","STRING","IN",PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_AGENT_FM_CODE()));
			paramList.add(new OracleParameter("in2","STRING","IN",PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_AGENT_TO_CODE()));
			paramList.add(new OracleParameter("in3","STRING","IN",PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_BEN_FM_CODE())); 
			paramList.add(new OracleParameter("in4","STRING","IN",PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_BEN_TO_CODE()));
			paramList.add(new OracleParameter("in5","STRING","IN",format_Date(PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_PROCESS_FM_DT())));
			paramList.add(new OracleParameter("in6","STRING","IN",format_Date(PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_PROCESS_TO_DT())));
			list = ora_handler.execute(paramList, connection, "P9ILPK_AGENT_BENEFITS.BENEFIT_APPROVE");
			connection.commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString(PELConstants.pelErrorMessagePath, "60315"));
*/
			// Set freeze flag disabled for selected benefits to approve

			if(fringe_Benefit_List != null && fringe_Benefit_List.size() > 0){
				iterator = fringe_Benefit_List.iterator();
				while(iterator.hasNext()){
					benefitBean = iterator.next();
					if(benefitBean != null){
						/*Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman*/
						try{
							/*Connection connection1 = CommonUtils.getConnection();
							CRUDHandler handler = new CRUDHandler();
							CommonUtils utils = new CommonUtils();
							String  CURSOR_C1 = "update PT_AGENT_FRINGE_BENEFIT set  AFB_FRZ_FLAG=?, AFB_PAID_DT = ? where afb_agent_code= ? and afb_bnf_code= ?";
							Object[] values= {benefitBean.getAFB_FRZ_FLAG(),utils.getCurrentDate(), benefitBean.getAFB_AGENT_CODE(), benefitBean.getAFB_BNF_CODE()};
							handler.executeUpdateStatement(CURSOR_C1, connection1, values);
							connection1.commit();*/
							
							
							
							if(benefitBean.getAFB_FRZ_FLAG().equalsIgnoreCase("Y")){
								Connection connection1 = CommonUtils.getConnection();
								CRUDHandler handler = new CRUDHandler();
								String  CURSOR_C1 = "update PT_AGENT_FRINGE_BENEFIT set  AFB_FRZ_FLAG=? , AFB_PAID_DT = ? where afb_agent_code= ? and afb_bnf_code= ?";
								Object[] values= {benefitBean.getAFB_FRZ_FLAG(), utils.getCurrentDate(), benefitBean.getAFB_AGENT_CODE(), benefitBean.getAFB_BNF_CODE()};
								handler.executeUpdateStatement(CURSOR_C1, connection1, values);
								connection1.commit();
								}
								else if(benefitBean.getAFB_FRZ_FLAG().equalsIgnoreCase("N")){
								Connection connection2 = CommonUtils.getConnection();
								CRUDHandler handler2 = new CRUDHandler();
								String  CURSOR_C2 = "update PT_AGENT_FRINGE_BENEFIT set  AFB_FRZ_FLAG=? , AFB_PAID_DT = ? where afb_agent_code= ? and afb_bnf_code= ?";
								Object[] values2= {benefitBean.getAFB_FRZ_FLAG(),null, benefitBean.getAFB_AGENT_CODE(), benefitBean.getAFB_BNF_CODE()};
								handler2.executeUpdateStatement(CURSOR_C2, connection2, values2);
								connection2.commit();
								}
							}catch(Exception e){
								e.printStackTrace();
							}
						/*End Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman*/
						
						if("Y".equals(benefitBean.getAFB_FRZ_FLAG())){
							benefitBean.setDisableFrzFlag(true);
						}else{
							benefitBean.setDisableFrzFlag(false);
						}
					}
				}
			}
			
			paramList.clear();
			paramList.add(new OracleParameter("in1","STRING","IN",PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_AGENT_FM_CODE()));
			paramList.add(new OracleParameter("in2","STRING","IN",PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_AGENT_TO_CODE()));
			paramList.add(new OracleParameter("in3","STRING","IN",PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_BEN_FM_CODE())); 
			paramList.add(new OracleParameter("in4","STRING","IN",PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_BEN_TO_CODE()));
			paramList.add(new OracleParameter("in5","STRING","IN",format_Date(PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_PROCESS_FM_DT())));
			paramList.add(new OracleParameter("in6","STRING","IN",format_Date(PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_PROCESS_TO_DT())));
			list = ora_handler.execute(paramList, connection, "P9ILPK_AGENT_BENEFITS.BENEFIT_APPROVE");
			connection.commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString(PELConstants.pelErrorMessagePath, "60315"));

		} catch (SQLException e) {
			errorCode=e.getErrorCode();
			e.printStackTrace();
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			try{

				if(errorCode==20100){
					ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(),
							FacesContext.getCurrentInstance(),
							getCOMP_UI_M_BUT_APPROVE().getClientId(FacesContext.getCurrentInstance()),
							getWarningMap());

				}
			}catch(DBException exception){
				exception.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exception.getMessage());
			}catch(ValidatorException validatorException){
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, validatorException.getMessage());
			}
		}
	}

	public void getApprovedRecord()
	{
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		try{
			handler = new CRUDHandler();
			String query = "";
			resultSet = handler.executeSelectStatement(query, connection, new Object[]{});
			while(resultSet.next())
			{

			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public String format_Date(Date date){
		String result=null; 
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		result = sdf.format(date).toString();
		return result;
	}

	public String PT_AGENT_FRINGE_BENEFIT_PRE_QUERY(){
		M_WHERE = "( AFB_AGENT_CODE BETWEEN '"+PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_AGENT_FM_CODE()+"' AND '"+PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_AGENT_TO_CODE()+"')";
		M_WHERE = M_WHERE + " AND (TO_DATE(TO_CHAR(AFB_PROCESS_DT,'DD/MM/RRRR'),'DD/MM/RRRR')) BETWEEN TO_DATE('"+date_Format(PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_PROCESS_FM_DT())+"','DD/MM/RRRR') AND TO_DATE('"+date_Format(PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_PROCESS_TO_DT())+"','DD/MM/RRRR')";
		return M_WHERE;
	}

	public String date_Format(Date date){
		String result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			result = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void PT_AGENT_FRINGE_BENEFIT_POST_QUERY(PT_AGENT_FRINGE_BENEFIT agentFringeBenefitBean){

		String C1 = "SELECT CUST_NAME FROM   PM_CUSTOMER WHERE  CUST_CODE = '"+fringe_Benefit_List.get(0).getAFB_AGENT_CODE()+"'";
		try {
			resultSet = handler.executeSelectStatement(C1, getConnection());
			while(resultSet.next()){
				agentFringeBenefitBean.setUI_M_AGENT_NAME(resultSet.getString("CUST_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void PT_AGENT_FRINGE_BENEFIT_WHEN_NEW_RECORD_INSTANCE(PT_AGENT_FRINGE_BENEFIT agentFringeBenefitBean){

		if(agentFringeBenefitBean.getAFB_FRZ_FLAG() == null){
			agentFringeBenefitBean.setAFB_FRZ_FLAG("X");
		}
		/*else if(agentFringeBenefitBean.getAFB_FRZ_FLAG().equals("Y")){
			getCOMP_AFB_PROCESS_DT().setRequired(false);
			getCOMP_AFB_PROCESS_DT().setDisabled(false);
			getCOMP_AFB_LC_VALUE().setRequired(false);
			getCOMP_AFB_LC_VALUE().setDisabled(false);
			getCOMP_AFB_FC_VALUE().setRequired(false);
			getCOMP_AFB_FC_VALUE().setDisabled(false);
			getCOMP_AFB_PAID_DT().setRequired(false);
			getCOMP_AFB_PAID_DT().setDisabled(false);
		}else{
			getCOMP_AFB_PROCESS_DT().setRequired(true);
			getCOMP_AFB_PROCESS_DT().setDisabled(true);
			getCOMP_AFB_LC_VALUE().setRequired(true);
			getCOMP_AFB_LC_VALUE().setDisabled(true);
			getCOMP_AFB_FC_VALUE().setRequired(true);
			getCOMP_AFB_FC_VALUE().setDisabled(true);
			getCOMP_AFB_PAID_DT().setRequired(true);
			getCOMP_AFB_PAID_DT().setDisabled(true);
		}*/

		//code changed by Varun[50663]
		if("Y".equals(CommonUtils.nvl(agentFringeBenefitBean.getAFB_PAID_FLAG(), "X"))){
			getCOMP_AFB_FRZ_FLAG().setRequired(true);
			getCOMP_AFB_FRZ_FLAG().setDisabled(true);
		}else{
			getCOMP_AFB_FRZ_FLAG().setRequired(false);
			getCOMP_AFB_FRZ_FLAG().setDisabled(false);
		}

	}
	
	/*Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman*/
	public void do_BULK_FRZ_Editable(ActionEvent event){
		try
		{
		CommonUtils.clearMaps(this);
		String status=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		
		int currentIndex=this.dataTable.getRowIndex();
		pT_AGENT_FRINGE_BENEFIT=(PT_AGENT_FRINGE_BENEFIT)fringe_Benefit_List.get(currentIndex);
		pT_AGENT_FRINGE_BENEFIT.setAFB_FRZ_FLAG(status);
		Connection connection1 = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		String  CURSOR_C1 = "update PT_AGENT_FRINGE_BENEFIT set  AFB_FRZ_FLAG=? where afb_agent_code= ? and afb_bnf_code= ?";
		Object[] values= {status, pT_AGENT_FRINGE_BENEFIT.getAFB_AGENT_CODE(), pT_AGENT_FRINGE_BENEFIT.getAFB_BNF_CODE()};
		handler.executeUpdateStatement(CURSOR_C1, connection1, values);
		connection1.commit();
		COMP_AFB_FRZ_FLAG.resetValue();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*End Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman*/
	

	public void PT_AGENT_FRINGE_BENEFIT_WHEN_NEW_BLOCK_INSTANCE(){
		String query = "SELECT AFB_SYS_ID,AFB_AGENT_CODE,AFB_PROCESS_DT,AFB_BNF_CODE,AFB_FREQ," +
		"AFB_LC_VALUE,AFB_FC_VALUE,AFB_CURR_CODE,AFB_PAID_DT,AFB_FRZ_FLAG,AFB_PAID_FLAG," +
		"AFB_CR_DT,AFB_CR_UID,AFB_UPD_DT,AFB_UPD_UID,AFB_PERIOD_FM_DT,AFB_PERIOD_TO_DT," +
		"AFB_AP_FYC,AFB_AP_NO_OF_POL,AFB_ADG_FYC,AFB_ADG_NO_OF_POL,AFB_AG_FYC,AFB_AG_NO_OF_POL," +
		"AFB_OR_FYC,AFB_OR_NO_OF_POL,AFB_UM_CODE,ROWID FROM PT_AGENT_FRINGE_BENEFIT WHERE "+PT_AGENT_FRINGE_BENEFIT_PRE_QUERY();
		try{
			fringe_Benefit_List = handler.fetch(query, "com.iii.pel.forms.PT046_A.PT_AGENT_FRINGE_BENEFIT", getConnection());
			for(int index = 0; index<fringe_Benefit_List.size(); index++)
			{
				if("Y".equalsIgnoreCase(fringe_Benefit_List.get(index).getAFB_FRZ_FLAG()) && "Y".equalsIgnoreCase(fringe_Benefit_List.get(index).getAFB_PAID_FLAG()))
				{
					fringe_Benefit_List.get(index).setDisableFrzFlag(true);
				}else{
					fringe_Benefit_List.get(index).setDisableFrzFlag(false);
				}
				if("Y".equals(fringe_Benefit_List.get(index).getAFB_FRZ_FLAG())){
					if(fringe_Benefit_List.get(index).getAFB_PAID_DT()==null){
						CommonUtils commonUtils = new CommonUtils(); 
						fringe_Benefit_List.get(index).setAFB_PAID_DT(commonUtils.getCurrentDate());
					}
				}else{
					fringe_Benefit_List.get(index).setAFB_PAID_DT(null);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void AFB_AGENT_CODE_WHEN_VALIDATE_ITEM(ActionEvent ae){
		String C1 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = '"+PT_AGENT_FRINGE_BENEFIT_BEAN.getUI_M_AGENT_FM_CODE()+"'";
		try {
			resultSet = handler.executeSelectStatement(C1, getConnection());
			while(resultSet.next()){
				//Having Doubt Temporarily Commented...
				//Suspecting to set CUST_NAME in UI_M_AGENT_NAME
//				PT_AGENT_FRINGE_BENEFIT_BEAN.setAFB_AGENT_CODE(resultSet.getString("CUST_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void AFB_FC_VALUE_WHEN_VALIDATE_ITEM(ActionEvent ae){
		int rowIndex = fringe_Benefit_Table.getRowIndex();
		PT_AGENT_FRINGE_BENEFIT_BEAN = fringe_Benefit_List.get(rowIndex);
		PT_AGENT_FRINGE_BENEFIT_BEAN.setM_EXCH_RATE(L_GET_EXCHANGE_RATE(PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_CURR_CODE(),"B",date_Format(PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_PROCESS_DT()),"","E"));
		getCOMP_AFB_FC_VALUE().setSubmittedValue(L_VAL_ROUND_AMT(PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_CURR_CODE(),PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_FC_VALUE().toString(),"V").toString());
		PT_AGENT_FRINGE_BENEFIT_BEAN.setAFB_LC_VALUE(PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_FC_VALUE()*PT_AGENT_FRINGE_BENEFIT_BEAN.getM_EXCH_RATE());
		getCOMP_AFB_LC_VALUE().setSubmittedValue(L_VAL_ROUND_AMT(PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_CURR_CODE(),PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_LC_VALUE().toString(),"R").toString());
	}

	public Double L_GET_EXCHANGE_RATE(String P_CURR_CODE,String P_BUY_SELL,String P_EFF_DT,String P_EXHG_RATE,String P_WAR_ERR){
		session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String C1 = "SELECT DECODE('"+P_BUY_SELL+"', 'B', NVL(CER_BUY_EXGE_RATE, 0), 'S', "+
		"NVL(CER_SELL_EXGE_RATE,0), 'A', NVL(CER_AVG_EXGE_RATE, 0), NVL(CER_FIX_EXGE_RATE, 0)) FROM "+
		"FM_EXCHANGE_RATE WHERE CER_COMP_CODE = '"+session.get("GLOBAL.M_COMP_CODE").toString()+
		"' AND CER_CURR_CODE = '"+P_CURR_CODE+"' AND TO_DATE('"+P_EFF_DT+"','DD/MM/RRRR') BETWEEN CER_EFF_FRM_DT AND CER_EFF_TO_DT";
		try {
			resultSet = handler.executeSelectStatement(C1, getConnection());
			while(resultSet.next()){
				if(!resultSet.getString(1).equals("")){
					P_EXHG_RATE = resultSet.getString(1);
				}else{
					if(P_WAR_ERR.equals("E") || P_WAR_ERR.equals("W")){
						if(P_WAR_ERR.equals("E")){
							getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1036", new Object [] {P_CURR_CODE,P_EFF_DT}).getDetail());
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return Double.valueOf(P_EXHG_RATE);
	}

	public Double L_VAL_ROUND_AMT(String P_CURR_CODE,String P_AMT,String P_VAL_ROUND){
		String C1 = "SELECT CURR_DECIMAL FROM FM_CURRENCY WHERE  CURR_CODE = '"+P_CURR_CODE+"'";
		String M_DECIMAL = "";
		try {
			resultSet = handler.executeSelectStatement(C1, getConnection());
			while(resultSet.next()){
				if(resultSet.getString(1).equals("")){
					M_DECIMAL = "2";
				}else{
					M_DECIMAL = resultSet.getString(1); 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if(P_VAL_ROUND.equals("V")){
			if(!round_Value(P_AMT, M_DECIMAL).equals(P_AMT)){
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1039").getDetail());
			}
		}else{
			P_AMT = round_Value(P_AMT, M_DECIMAL);
		}
		return Double.valueOf(P_AMT);
	}

	public String round_Value(String value,String digit){
		String [] value_Array = value.split("\\.");
		String zeros = "";
		for(int i=0;i<Integer.parseInt(digit);i++){
			zeros += "0";
		}
		if(value_Array.length == 1){
			value += "."+zeros;
		}else{
			if(value_Array[1].length() < Integer.parseInt(digit)){
				for(int j = value_Array[1].length();j<Integer.parseInt(digit);j++){
					value += "0";
				}
			}else{
				value = value_Array[0]+"."+value_Array[1].substring(0,Integer.parseInt(digit));
			}
		}
		return value;
	}

	public void AFB_LC_VALUE_WHEN_VALIDATE_ITEM(ActionEvent ae){
		int rowIndex = fringe_Benefit_Table.getRowIndex();
		PT_AGENT_FRINGE_BENEFIT_BEAN = fringe_Benefit_List.get(rowIndex);
		PT_AGENT_FRINGE_BENEFIT_BEAN.setM_EXCH_RATE(L_GET_EXCHANGE_RATE(PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_CURR_CODE(),"B",date_Format(PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_PROCESS_DT()),PT_AGENT_FRINGE_BENEFIT_BEAN.getM_EXCH_RATE().toString(),"E"));
		getCOMP_AFB_LC_VALUE().setSubmittedValue(L_VAL_ROUND_AMT(PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_CURR_CODE(),PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_LC_VALUE().toString(),"V").toString());
		L_VAL_FC_LC_TOLERANCE(PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_FC_VALUE(),PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_LC_VALUE(),PT_AGENT_FRINGE_BENEFIT_BEAN.getM_EXCH_RATE(),"E");
	}

	public void L_VAL_FC_LC_TOLERANCE(Double P_FC_VAL,Double P_LC_VAL,Double P_EXGE_RATE,String P_ERR_FLAG){
		Double M_EXGE_RATE = 0.0;
		Double M_TOL_PERC = 0.0;
		String M_CODE_DESC = "";

		paramList.clear();
		paramList.add(new OracleParameter("in1","STRING","IN","ROUNDOFTOL"));
		paramList.add(new OracleParameter("in2","STRING","IN","ROUNDOFTOL"));
		paramList.add(new OracleParameter("in3","STRING","IN OUT",M_CODE_DESC));
		paramList.add(new OracleParameter("in4","STRING","IN","E"));
		paramList.add(new OracleParameter("in5","STRING","IN OUT",M_TOL_PERC.toString()));

		try {
			list = ora_handler.execute(paramList, getConnection(), "P_VAL_SYSTEM");
			M_CODE_DESC = ((OracleParameter)list.get(0)).getValue();
			M_TOL_PERC = Double.valueOf(((OracleParameter)list.get(1)).getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(P_FC_VAL == null){
			P_FC_VAL = 0.0;
		}
		if(P_LC_VAL == null){
			P_LC_VAL = 0.0;
		}
		if(P_EXGE_RATE == null){
			P_EXGE_RATE = 0.0;
		}
		if(P_FC_VAL.equals("0") || P_LC_VAL.equals("0") || P_EXGE_RATE.equals("0")){
			return;
		}
		M_EXGE_RATE = P_LC_VAL /P_FC_VAL;
		if(((returnAbs_Value((M_EXGE_RATE - P_EXGE_RATE))/M_EXGE_RATE))*100 > M_TOL_PERC) {
			if(P_ERR_FLAG.equals("E") || P_ERR_FLAG.equals("W")){
				if(P_ERR_FLAG.equals("E")){
					getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1038", new Object [] {M_TOL_PERC.toString()}).getDetail());
				}
			}
		}
	}

	public Double returnAbs_Value(Double value){
		if(value < 0){
			value = value * -1;
		}
		return value;
	}

	public void AFB_PAID_DT_WHEN_VALIDATE_ITEM(ActionEvent ae){
		int rowIndex = fringe_Benefit_Table.getRowIndex();
		PT_AGENT_FRINGE_BENEFIT_BEAN = fringe_Benefit_List.get(rowIndex);
		Date paid_Date = PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_PAID_DT();
		CommonUtils commonUtils = new CommonUtils();
		try {
			if(compare_Date(commonUtils.getCurrentDate(),paid_Date)){
				getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "80268"));
			}else{
				getErrorMap().clear();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void AFB_FRZ_FLAG_WHEN_LIST_CHANGED(ActionEvent ae){
		//	int rowIndex = fringe_Benefit_Table.getRowIndex();
		CommonUtils utils=new CommonUtils();
		UIInput input=(UIInput)ae.getComponent().getParent();
		String selectedValue=input.getSubmittedValue().toString();
		if(selectedValue!=null){
			//fringe_Benefit_List.get(rowIndex).setAFB_FRZ_FLAG(selectedValue);
			this.PT_AGENT_FRINGE_BENEFIT_BEAN.setAFB_FRZ_FLAG(selectedValue);
		}
		try{
			if("Y".equals(PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_FRZ_FLAG())){
				if(PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_PAID_DT()==null){
					PT_AGENT_FRINGE_BENEFIT_BEAN.setAFB_PAID_DT(utils.getCurrentDate());
					/*Newly added by pidugu raj dt: 01-10-2018 as suggested by sivaraman for kic*/
					COMP_AFB_PAID_DT.resetValue();
					/*End Newly added by pidugu raj dt: 01-10-2018 as suggested by sivaraman for kic*/
				}
				
			}
			/*Newly added by pidugu raj dt: 01-10-2018 as suggested by sivaraman for kic*/
			else{
				PT_AGENT_FRINGE_BENEFIT_BEAN.setAFB_PAID_DT(null);
				COMP_AFB_PAID_DT.resetValue();
			}
			/*End Newly added by pidugu raj dt: 01-10-2018 as suggested by sivaraman for kic*/
			System.out.println("FLAG::::::"+PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_FRZ_FLAG());

			/*if("Y".equals(fringe_Benefit_List.get(rowIndex).getAFB_FRZ_FLAG())){
				if(fringe_Benefit_List.get(rowIndex).getAFB_PAID_DT()==null){
					fringe_Benefit_List.get(rowIndex).setAFB_PAID_DT(utils.getCurrentDate());
				}
			}
			System.out.println("FLAG::::::"+fringe_Benefit_List.get(rowIndex).getAFB_FRZ_FLAG());*/
			//updateData(fringe_Benefit_List.get(rowIndex));
			updateData(PT_AGENT_FRINGE_BENEFIT_BEAN);
			utils.doComitt();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public int updateData(Object value) throws Exception
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		connection = CommonUtils.getConnection();
		try {
			rowUpdated = dbHandler.executeInsert(value, connection);
			//connection.commit();
			//new CommonUtils().doComitt();
		} catch (Exception exc) {
			throw exc;
		} 
		return rowUpdated;
	}

	public void AFB_FRZ_FLAG_WHEN_VALIDATE_ITEM(ActionEvent ae){
		//int rowIndex = fringe_Benefit_Table.getRowIndex();
		CommonUtils utils=new CommonUtils();
		//String AFB_FRZ_FLAG = fringe_Benefit_List.get(rowIndex).getAFB_FRZ_FLAG();
		String AFB_FRZ_FLAG ="";
		for(int i=0;i<fringe_Benefit_List.size();i++){
			PT_AGENT_FRINGE_BENEFIT pt_agent_fringe_benefit = fringe_Benefit_List.get(i);
			if("dataTableSelectedRow".equalsIgnoreCase(pt_agent_fringe_benefit.getRowSelected())){
				AFB_FRZ_FLAG = pt_agent_fringe_benefit.getAFB_FRZ_FLAG();
			}

		}


		try{
			if("Y".equals(AFB_FRZ_FLAG)){
				if(PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_PAID_DT()==null){
					PT_AGENT_FRINGE_BENEFIT_BEAN.setAFB_PAID_DT(utils.getCurrentDate());
				}
				setFREEZE_FIELD_DISABLE(true);
			}else{
				setFREEZE_FIELD_DISABLE(false);
				PT_AGENT_FRINGE_BENEFIT_BEAN.setAFB_PAID_DT(null);
			}
			updateData(PT_AGENT_FRINGE_BENEFIT_BEAN);
			utils.doComitt();

			/*if("Y".equals(fringe_Benefit_List.get(rowIndex).getAFB_FRZ_FLAG())){

				getCOMP_AFB_PROCESS_DT().setRequired(true);
				getCOMP_AFB_PROCESS_DT().setDisabled(true);
				getCOMP_AFB_LC_VALUE().setRequired(true);
				getCOMP_AFB_LC_VALUE().setDisabled(true);
				getCOMP_AFB_FC_VALUE().setRequired(true);
				getCOMP_AFB_FC_VALUE().setDisabled(true);
				getCOMP_AFB_PAID_DT().setRequired(true);
				getCOMP_AFB_PAID_DT().setDisabled(true);		
			}else{
				getCOMP_AFB_PROCESS_DT().setRequired(false);
				getCOMP_AFB_PROCESS_DT().setDisabled(false);
				getCOMP_AFB_LC_VALUE().setRequired(false);
				getCOMP_AFB_LC_VALUE().setDisabled(false);
				getCOMP_AFB_FC_VALUE().setRequired(false);
				getCOMP_AFB_FC_VALUE().setDisabled(false);
				getCOMP_AFB_PAID_DT().setRequired(false);
				getCOMP_AFB_PAID_DT().setDisabled(false);
			}*/
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public Date getSystemDate(){
		Date sysDate = null;
		try {
			String query = "SELECT TO_DATE(SYSDATE,'DD/MM/YYYY') FROM DUAL";
			resultSet = handler.executeSelectStatement(query, getConnection());
			while(resultSet.next())
				sysDate = resultSet.getDate(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysDate;
	}

	public String globalM_DEFAULT(int startIndex,int length){
		String def_Values = session.get("GLOBAL.M_DFLT_VALUES").toString();
		String res_String = def_Values.substring(startIndex-1, (startIndex-1+length));
		while(res_String.endsWith(" ")){
			res_String = res_String.substring(0, res_String.length()-1);
		}
		return res_String;
	}

	/*public void createCtrlBean(){
		ControlBean control = new ControlBean();
		FacesContext faces = FacesContext.getCurrentInstance();
		session = faces.getExternalContext().getSessionMap();
		session.put("ctrlbean", control);
	}

	public ControlBean getControlBean(){
		FacesContext faces = FacesContext.getCurrentInstance();
		session = faces.getExternalContext().getSessionMap();
		return (ControlBean)session.get("ctrlbean");
	}

	public void putControlBean(ControlBean controlBean){
		FacesContext faces = FacesContext.getCurrentInstance();
		session = faces.getExternalContext().getSessionMap();
		session.put("ctrlbean", controlBean);
	}
	 */
	public Connection getConnection(){
		Connection conn = null; 
		try {
			conn = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public List<PT_AGENT_FRINGE_BENEFIT> getFringe_Benefit_List() {
		return fringe_Benefit_List;
	}

	public void setFringe_Benefit_List(
			List<PT_AGENT_FRINGE_BENEFIT> fringe_Benefit_List) {
		this.fringe_Benefit_List = fringe_Benefit_List;
	}

	public UIDataTable getFringe_Benefit_Table() {
		return fringe_Benefit_Table;
	}

	public void setFringe_Benefit_Table(UIDataTable fringe_Benefit_Table) {
		this.fringe_Benefit_Table = fringe_Benefit_Table;
	}
	public void checkBoxStatus(ActionEvent actionEvent){

	}

	public HtmlSelectBooleanCheckbox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(HtmlSelectBooleanCheckbox checkBox) {
		this.checkBox = checkBox;
	}

	public List<SelectItem> getSelectItem() {
		return selectItem;
	}

	public void fetchSelectItems() {
		selectItem = ListItemUtil.getDropDownListValue( getConnection(), "PT046_A", "PT_AGENT_FRINGE_BENEFIT", "PT_AGENT_FRINGE_BENEFIT.AFB_FRZ_FLAG", "YESNO");
		frequencyItems = ListItemUtil.getDropDownListValue( getConnection(), "PT046_A", "PT_AGENT_FRINGE_BENEFIT", "PT_AGENT_FRINGE_BENEFIT.AFB_FREQ", "");
		return;
	}

	public void setSelectItem(List<SelectItem> selectItem) {
		this.selectItem = selectItem;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<SelectItem> getFrequencyItems() {
		return frequencyItems;
	}

	public void setFrequencyItems(List<SelectItem> frequencyItems) {
		this.frequencyItems = frequencyItems;
	}

	public boolean isDEFAULT_FIELD_DISABLE() {
		return DEFAULT_FIELD_DISABLE;
	}

	public void setDEFAULT_FIELD_DISABLE(boolean default_field_disable) {
		DEFAULT_FIELD_DISABLE = default_field_disable;
	}

	public boolean isFREEZE_FIELD_DISABLE() {
		return FREEZE_FIELD_DISABLE;
	}

	public void setFREEZE_FIELD_DISABLE(boolean freeze_field_disable) {
		FREEZE_FIELD_DISABLE = freeze_field_disable;
	}
	/*Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman*/
	private int row_index;

	public int getRow_index() {
		return row_index;
	}
	public void setRow_index(int row_index) {
		this.row_index = row_index;
	}
	/*End Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman*/

	public void getDetails() {
		try {
			
			/*Modified by  pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman
			if (fringe_Benefit_List.size() != 0) {				
				PT_AGENT_FRINGE_BENEFIT_BEAN = (PT_AGENT_FRINGE_BENEFIT) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PT_AGENT_FRINGE_BENEFIT_BEAN.setRowSelected(true);	
		*/
			
			/*Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman*/

			resetSelectedRow();
			setRow_index(dataTable.getRowIndex());
			if (fringe_Benefit_List.size() != 0) {				
				PT_AGENT_FRINGE_BENEFIT_BEAN = (PT_AGENT_FRINGE_BENEFIT) dataTable.getRowData();
			}	
			PT_AGENT_FRINGE_BENEFIT_BEAN.setRowSelected(true);
			
			enableFields();
			resetAllComponent();			
		
			/*End Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman*/
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman*/
	public PILT002_APAC_COMPOSITE_ACTION compositeAction;
	
	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	private void enableFields()
	{
		if(PT_AGENT_FRINGE_BENEFIT_BEAN.getRowSelected() != null && PT_AGENT_FRINGE_BENEFIT_BEAN.getRowSelected().equals("dataTableSelectedRow"))
		{
			
			if((PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_FRZ_FLAG() != null && 
					PT_AGENT_FRINGE_BENEFIT_BEAN.getAFB_FRZ_FLAG().equals("N")))
			{
				PT_AGENT_FRINGE_BENEFIT_BEAN.setFIELD1_ENABLE("dataTableSelectedRow");
				PT_AGENT_FRINGE_BENEFIT_BEAN.setFIELD2_ENABLE("dataTableSelectedRow");
			}
			else
			{
				PT_AGENT_FRINGE_BENEFIT_BEAN.setFIELD1_ENABLE("dataTableSelectedRow");
				PT_AGENT_FRINGE_BENEFIT_BEAN.setFIELD2_ENABLE("dataTableSelectedRow");
			}
		}
	}

	/*End Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman*/

	public List UI_M_BEN_FM_CODE_LOV(Object obj) throws Exception{
		getCOMP_UI_M_BEN_FM_CODE().setSubmittedValue(null);
		String query = null;
		Object values[] = null;
		if(obj.toString().equals("*")){
			values = new Object[1];
			query = "SELECT ABH_BNF_CODE,ABH_DESC,ABH_BL_DESC FROM " +
			"PM_AGENT_BENEFIT_HDR WHERE ROWNUM < ?";
			values[0] = PELConstants.suggetionRecordSize;
		}else{
			values = new Object[2];
			query = "SELECT ABH_BNF_CODE,ABH_DESC,ABH_BL_DESC FROM " +
			"PM_AGENT_BENEFIT_HDR WHERE ABH_BNF_CODE LIKE ? AND ROWNUM < ?";
			values[0] = obj + "%";
			values[1] = PELConstants.suggetionRecordSize;
		}	

		resultSet = handler.executeSelectStatement(query,getConnection(), values);
		while(resultSet.next()){
			PM_AGENT_BENEFIT_HDR benefit_hdr = new PM_AGENT_BENEFIT_HDR();
			benefit_hdr.setABH_BNF_CODE(resultSet.getString(1));
			benefit_hdr.setABH_DESC(resultSet.getString(2));
			suggesionList.add(benefit_hdr);
		}
		resultSet.close();
		return suggesionList;
	}

	public void renderBenefitFMCode(ActionEvent event){
		if(!getCOMP_UI_M_BEN_FM_CODE().getSubmittedValue().toString().equals("")){
			PT_AGENT_FRINGE_BENEFIT_BEAN.setUI_M_BEN_FM_CODE(getCOMP_UI_M_BEN_FM_CODE().getSubmittedValue().toString());
			String C1 = "SELECT ABH_DESC FROM PM_AGENT_BENEFIT_HDR WHERE ABH_BNF_CODE= ?";
			try {
				resultSet = handler.executeSelectStatement(C1, getConnection(), 
						new Object[]{getCOMP_UI_M_BEN_FM_CODE().getSubmittedValue()});
				while(resultSet.next()){
					getCOMP_UI_M_BEN_FM_CODE_DESC().setSubmittedValue(resultSet.getString(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else{
			getCOMP_UI_M_BEN_FM_CODE().setSubmittedValue(L_SET_FIRST_FIELD(getCOMP_UI_M_BEN_FM_CODE().getSubmittedValue().toString(),getCOMP_UI_M_BEN_TO_CODE().getSubmittedValue().toString()));
		}
	}
	
	public void renderBenefitTOCode(ActionEvent event){
		if(getCOMP_UI_M_BEN_TO_CODE().getSubmittedValue().equals("")){
			getCOMP_UI_M_BEN_TO_CODE().setSubmittedValue(L_SET_SECOND_FIELD(getCOMP_UI_M_BEN_FM_CODE().getSubmittedValue().toString(),getCOMP_UI_M_BEN_TO_CODE().getSubmittedValue().toString()));
		}
		if(!getCOMP_UI_M_BEN_TO_CODE().getSubmittedValue().equals("")){
			PT_AGENT_FRINGE_BENEFIT_BEAN.setUI_M_BEN_TO_CODE(getCOMP_UI_M_BEN_TO_CODE().getSubmittedValue().toString());
			String C1 = "SELECT ABH_DESC FROM PM_AGENT_BENEFIT_HDR WHERE ABH_BNF_CODE= ?";
			try {
				resultSet = handler.executeSelectStatement(C1, getConnection(), 
						new Object[]{getCOMP_UI_M_BEN_TO_CODE().getSubmittedValue()});
				while(resultSet.next()){
					getCOMP_UI_M_BEN_TO_CODE_DESC().setSubmittedValue(resultSet.getString(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List UI_M_BEN_TO_CODE_LOV(Object obj) throws Exception{
		List suggesionList = new ArrayList();
		getCOMP_UI_M_AGENT_TO_CODE().setSubmittedValue(null);
		String query = null;
		Object values[] = null;
		if(obj.toString().equals("*")){
			values = new Object[1];
			query = "SELECT ABH_BNF_CODE,ABH_DESC,ABH_BL_DESC FROM " +
			"PM_AGENT_BENEFIT_HDR WHERE ROWNUM < ?";
			values[0] = PELConstants.datatableRecordSize;
		}else{
			values = new Object[2];
			query = "SELECT ABH_BNF_CODE,ABH_DESC,ABH_BL_DESC FROM " +
			"PM_AGENT_BENEFIT_HDR WHERE ABH_BNF_CODE LIKE ? AND ROWNUM < ?";
			values[0] = obj + "%";
			values[1] = PELConstants.datatableRecordSize;
		}	

		resultSet = handler.executeSelectStatement(query,getConnection(), values);
		while(resultSet.next()){
			PM_AGENT_BENEFIT_HDR benefit_hdr = new PM_AGENT_BENEFIT_HDR();
			benefit_hdr.setABH_BNF_CODE(resultSet.getString(1));
			benefit_hdr.setABH_DESC(resultSet.getString(2));
			suggesionList.add(benefit_hdr);
		}
		resultSet.close();
		return suggesionList;
	}

	/**
	 * Reset the selected Row.
	 */
	private void resetSelectedRow() {
		Iterator<PT_AGENT_FRINGE_BENEFIT> iterator = fringe_Benefit_List.iterator();
		while (iterator.hasNext()) {
			PT_AGENT_FRINGE_BENEFIT_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
			PT_AGENT_FRINGE_BENEFIT_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");

			iterator.next().setRowSelected(false);
		}
	}	
	
/*Newly added by pidugu raj dt: 11-09-2018 for Agent Benefit details Mass Freeze */
	
	
	public void fireFieldValidationChk(ActionEvent actionEvent) {
	try{
		CommonUtils utils = new CommonUtils();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		boolean chkFlag = false;
		chkFlag = (boolean)input.getSubmittedValue();
		String defChk = "N";
		if(chkFlag)
		{
			defChk = "Y";
		}
		
		
		/*Newly added by pidugu raj dt: 04-10-2018 as suggested by sivaraman and vaitheeswaran*/
		Iterator<PT_AGENT_FRINGE_BENEFIT> iterator = null;
		PT_AGENT_FRINGE_BENEFIT benefitBean = null;
		
		try {
			Connection connection = CommonUtils.getConnection();
		
			setFringe_Benefit_List(CommonUtils.returnCheckedList(getFringe_Benefit_List(), "AFB_FRZ_FLAG", defChk,
					PT_AGENT_FRINGE_BENEFIT_BEAN.getStartIndex(),getFringe_Benefit_List().size()));
			
			
			getPT_AGENT_FRINGE_BENEFIT_BEAN().setAFB_FRZ_FLAG(defChk);;
			COMP_AFB_FRZ_FLAG.resetValue();


			getPT_AGENT_FRINGE_BENEFIT_BEAN().setUPDATE_ALL(true);
		if(fringe_Benefit_List != null && fringe_Benefit_List.size() > 0){
			iterator = fringe_Benefit_List.iterator();
			while(iterator.hasNext()){
				benefitBean = iterator.next();
				if(benefitBean != null){
					/*Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman*/
					try{
						/*Connection connection1 = CommonUtils.getConnection();
						CRUDHandler handler = new CRUDHandler();
						CommonUtils utils = new CommonUtils();
						String  CURSOR_C1 = "update PT_AGENT_FRINGE_BENEFIT set  AFB_FRZ_FLAG=?, AFB_PAID_DT = ? where afb_agent_code= ? and afb_bnf_code= ?";
						Object[] values= {benefitBean.getAFB_FRZ_FLAG(),utils.getCurrentDate(), benefitBean.getAFB_AGENT_CODE(), benefitBean.getAFB_BNF_CODE()};
						handler.executeUpdateStatement(CURSOR_C1, connection1, values);
						connection1.commit();*/
						
						
						
						if(benefitBean.getAFB_FRZ_FLAG().equalsIgnoreCase("Y")){
							Connection connection1 = CommonUtils.getConnection();
							CRUDHandler handler = new CRUDHandler();
							String  CURSOR_C1 = "update PT_AGENT_FRINGE_BENEFIT set  AFB_FRZ_FLAG=? , AFB_PAID_DT = ? where afb_agent_code= ? and afb_bnf_code= ?";
							Object[] values= {benefitBean.getAFB_FRZ_FLAG(), utils.getCurrentDate(), benefitBean.getAFB_AGENT_CODE(), benefitBean.getAFB_BNF_CODE()};
							handler.executeUpdateStatement(CURSOR_C1, connection1, values);
							connection1.commit();
							}
							else if(benefitBean.getAFB_FRZ_FLAG().equalsIgnoreCase("N")){
							Connection connection2 = CommonUtils.getConnection();
							CRUDHandler handler2 = new CRUDHandler();
							String  CURSOR_C2 = "update PT_AGENT_FRINGE_BENEFIT set  AFB_FRZ_FLAG=? , AFB_PAID_DT = ? where afb_agent_code= ? and afb_bnf_code= ?";
							Object[] values2= {benefitBean.getAFB_FRZ_FLAG(),null, benefitBean.getAFB_AGENT_CODE(), benefitBean.getAFB_BNF_CODE()};
							handler2.executeUpdateStatement(CURSOR_C2, connection2, values2);
							connection2.commit();
							}
						}catch(Exception e){
							e.printStackTrace();
						}
					/*End Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Mass freeze checkbox as suggested by sivaraman*/
					
					if("Y".equals(benefitBean.getAFB_FRZ_FLAG())){
						benefitBean.setDisableFrzFlag(true);
					}else{
						benefitBean.setDisableFrzFlag(false);
					}
				}
			}
		}
		} catch(Exception exception){
			exception.printStackTrace();
		}
		/*Newly added by pidugu raj dt: 04-10-2018 as suggested by sivaraman and vaitheeswaran*/
		
		setFringe_Benefit_List(CommonUtils.returnCheckedList(getFringe_Benefit_List(), "AFB_FRZ_FLAG", defChk,
				PT_AGENT_FRINGE_BENEFIT_BEAN.getStartIndex(),getFringe_Benefit_List().size()));
		getPT_AGENT_FRINGE_BENEFIT_BEAN().setAFB_FRZ_FLAG(defChk);;
		COMP_AFB_FRZ_FLAG.resetValue();


		getPT_AGENT_FRINGE_BENEFIT_BEAN().setUPDATE_ALL(true);
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	/*End Newly added by pidugu raj dt: 11-09-2018 for Agent Benefit details Mass Freeze*/

	private void resetAllComponent(){
		COMP_AFB_AGENT_CODE.resetValue();
		COMP_UI_M_AGENT_NAME.resetValue();
		COMP_AFB_BNF_CODE.resetValue();
		COMP_AFB_FREQ.resetValue();
		COMP_AFB_FC_VALUE.resetValue();
		COMP_AFB_LC_VALUE.resetValue();
		COMP_AFB_FRZ_FLAG.resetValue();
		COMP_AFB_PAID_DT.resetValue();
		COMP_AFB_PROCESS_DT.resetValue();
		/*Newly added by pidugu raj dt: 11-09-2018 for Bulk Freeze option as per sivaraman suggestion for Benefit Details Screen*/
		COMP_AFB_FRZ_FLAG_Bulk.resetValue();
		/*End Newly added by pidugu raj dt: 11-09-2018 for Bulk Freeze option as per sivaraman suggestion for Benefit Details Screen*/

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
	 * @return the filterBYUI_M_AGENT_NAME
	 */
	public String getFilterBYUI_M_AGENT_NAME() {
		return filterBYUI_M_AGENT_NAME;
	}

	/**
	 * @param filterBYUI_M_AGENT_NAME the filterBYUI_M_AGENT_NAME to set
	 */
	public void setFilterBYUI_M_AGENT_NAME(String filterBYUI_M_AGENT_NAME) {
		this.filterBYUI_M_AGENT_NAME = filterBYUI_M_AGENT_NAME;
	}

	/**
	 * @return the filterBYAFB_AGENT_CODE
	 */
	public String getFilterBYAFB_AGENT_CODE() {
		return filterBYAFB_AGENT_CODE;
	}

	/**
	 * @param filterBYAFB_AGENT_CODE the filterBYAFB_AGENT_CODE to set
	 */
	public void setFilterBYAFB_AGENT_CODE(String filterBYAFB_AGENT_CODE) {
		this.filterBYAFB_AGENT_CODE = filterBYAFB_AGENT_CODE;
	}

	public HtmlInputText getCOMP_UI_M_BEN_FM_CODE() {
		return COMP_UI_M_BEN_FM_CODE;
	}

	public void setCOMP_UI_M_BEN_FM_CODE(HtmlInputText comp_ui_m_ben_fm_code) {
		COMP_UI_M_BEN_FM_CODE = comp_ui_m_ben_fm_code;
	}

	public HtmlInputText getCOMP_UI_M_BEN_FM_CODE_DESC() {
		return COMP_UI_M_BEN_FM_CODE_DESC;
	}

	public void setCOMP_UI_M_BEN_FM_CODE_DESC(
			HtmlInputText comp_ui_m_ben_fm_code_desc) {
		COMP_UI_M_BEN_FM_CODE_DESC = comp_ui_m_ben_fm_code_desc;
	}

	public HtmlInputText getCOMP_UI_M_BEN_TO_CODE() {
		return COMP_UI_M_BEN_TO_CODE;
	}

	public void setCOMP_UI_M_BEN_TO_CODE(HtmlInputText comp_ui_m_ben_to_code) {
		COMP_UI_M_BEN_TO_CODE = comp_ui_m_ben_to_code;
	}

	public HtmlInputText getCOMP_UI_M_BEN_TO_CODE_DESC() {
		return COMP_UI_M_BEN_TO_CODE_DESC;
	}

	public void setCOMP_UI_M_BEN_TO_CODE_DESC(
			HtmlInputText comp_ui_m_ben_to_code_desc) {
		COMP_UI_M_BEN_TO_CODE_DESC = comp_ui_m_ben_to_code_desc;
	}
	/*Newly added by pidugu raj dt: 10-09-2018 for benefit details screen (Product Feature)*/
	public PT_AGENT_FRINGE_BENEFIT getpT_AGENT_FRINGE_BENEFIT() {
		return pT_AGENT_FRINGE_BENEFIT;
	}

	public void setpT_AGENT_FRINGE_BENEFIT(
			PT_AGENT_FRINGE_BENEFIT pT_AGENT_FRINGE_BENEFIT) {
		this.pT_AGENT_FRINGE_BENEFIT = pT_AGENT_FRINGE_BENEFIT;
	}
	/*End Newly added by pidugu raj dt: 10-09-2018 for benefit details screen (Product Feature)*/
	
	/*Newly added by pidugu raj dt: 11-09-2018 for Bulk Freeze option as per sivaraman suggestion for Benefit Details Screen*/
	public HtmlSelectOneMenu getCOMP_AFB_FRZ_FLAG_Bulk() {
		return COMP_AFB_FRZ_FLAG_Bulk;
	}

	public void setCOMP_AFB_FRZ_FLAG_Bulk(HtmlSelectOneMenu cOMP_AFB_FRZ_FLAG_Bulk) {
		COMP_AFB_FRZ_FLAG_Bulk = cOMP_AFB_FRZ_FLAG_Bulk;
	}
	/*End Newly added by pidugu raj dt: 11-09-2018 for Bulk Freeze option as per sivaraman suggestion for Benefit Details Screen*/

	public HtmlOutputLabel getCOMP_DEFN_YN_ALL() {
		return COMP_DEFN_YN_ALL;
	}

	public void setCOMP_DEFN_YN_ALL(HtmlOutputLabel cOMP_DEFN_YN_ALL) {
		COMP_DEFN_YN_ALL = cOMP_DEFN_YN_ALL;
	}
	

}
