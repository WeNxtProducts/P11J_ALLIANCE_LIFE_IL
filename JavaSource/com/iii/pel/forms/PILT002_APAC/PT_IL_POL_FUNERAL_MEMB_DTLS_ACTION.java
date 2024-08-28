package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_FUNERAL_MEMB_DTLS_ACTION extends CommonAction{
	public PILT002_APAC_COMPOSITE_ACTION compositeAction;
	private PT_IL_POL_FUNERAL_MEMB_DTLS PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN;
	private PT_IL_POL_FUNERAL_MEMB_DTLS_DELEGATE delegate; 
	private PT_IL_POL_FUNERAL_MEMB_DTLS_HELPER helper; 
	
	public PT_IL_POL_FUNERAL_MEMB_DTLS_ACTION()
	{
		PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN=new PT_IL_POL_FUNERAL_MEMB_DTLS();
	
		helper=new PT_IL_POL_FUNERAL_MEMB_DTLS_HELPER();
		prepareDropDownList();
		
		initiateAllComponents();
	}
	
	private HtmlOutputLabel COMP_PFMD_CUST_CODE_LABEL;
	private HtmlInputText COMP_PFMD_CUST_CODE;
	private HtmlInputText COMP_PFMD_CUST_DESC;
	
	private HtmlOutputLabel COMP_PFMD_RELATION_TYPE_LABEL;
	/*Modified by ganesh for ZBLIFE-1455133*/
	private HtmlInputText COMP_PFMD_RELATION_TYPE;
	
	private HtmlOutputLabel COMP_PFMD_MEMB_DOB_LABEL;
	private HtmlCalendar  COMP_PFMD_MEMB_DOB;
	
	private HtmlOutputLabel COMP_PFMD_MEMB_AGE_LABEL;
	private HtmlInputText COMP_PFMD_MEMB_AGE;
	
	private HtmlOutputLabel COMP_PFMD_SA_LABEL;
	private HtmlInputText COMP_PFMD_SA;
	
	
	private HtmlOutputLabel COMP_PFMD_PREMIUM_LABEL;
	private HtmlInputText COMP_PFMD_PREMIUM;
	
	private HtmlOutputLabel COMP_PFMD_CURR_ASSR_LABEL;
	private HtmlSelectBooleanCheckbox COMP_PFMD_CURR_ASSR;
	
	private HtmlOutputLabel COMP_PFMD_WOP_LABEL;
	private HtmlSelectBooleanCheckbox COMP_PFMD_WOP;
	
	private HtmlOutputLabel COMP_PFMD_STATUS_LABEL;
	private HtmlSelectBooleanCheckbox COMP_PFMD_STATUS;
	
	private HtmlOutputLabel COMP_PFMD_ADDRESS1_LABEL;
	private HtmlInputText COMP_PFMD_ADDRESS1;
	
	private HtmlOutputLabel COMP_PFMD_ADDRESS2_LABEL;
	private HtmlInputText COMP_PFMD_ADDRESS2;
	/*added by gopi for showing description for relation type on 01/02/17*/
	private HtmlOutputLabel COMP_PFMD_MEMB_TYPE_LABEL;
	
	public HtmlOutputLabel getCOMP_PFMD_MEMB_TYPE_LABEL() {
		return COMP_PFMD_MEMB_TYPE_LABEL;
	}
	public void setCOMP_PFMD_MEMB_TYPE_LABEL(
			HtmlOutputLabel cOMP_PFMD_MEMB_TYPE_LABEL) {
		COMP_PFMD_MEMB_TYPE_LABEL = cOMP_PFMD_MEMB_TYPE_LABEL;
	}
	private HtmlInputText COMP_PFMD_MEMB_TYPE;
	
	public HtmlInputText getCOMP_PFMD_MEMB_TYPE() {
		return COMP_PFMD_MEMB_TYPE;
	}
	public void setCOMP_PFMD_MEMB_TYPE(HtmlInputText cOMP_PFMD_MEMB_TYPE) {
		COMP_PFMD_MEMB_TYPE = cOMP_PFMD_MEMB_TYPE;
	}
	private HtmlInputText COMP_PFMD_MEMB_TYPE_DESC;
	
	public HtmlInputText getCOMP_PFMD_MEMB_TYPE_DESC() {
		return COMP_PFMD_MEMB_TYPE_DESC;
	}
	public void setCOMP_PFMD_MEMB_TYPE_DESC(HtmlInputText cOMP_PFMD_MEMB_TYPE_DESC) {
		COMP_PFMD_MEMB_TYPE_DESC = cOMP_PFMD_MEMB_TYPE_DESC;
	}

	/*end*/
	private HtmlOutputLabel COMP_PFMD_ADDRESS3_LABEL;
	private HtmlInputText COMP_PFMD_ADDRESS3;
	
	private HtmlOutputLabel COMP_PFMD_PHONE_LABEL;
	private HtmlInputText COMP_PFMD_PHONE;
	
	private HtmlOutputLabel COMP_PFMD_CANTACT_LABEL;
	private HtmlInputText COMP_PFMD_CANTACT;
	
	private HtmlCommandButton COMP_BTN_MORE;

	private List<PT_IL_POL_FUNERAL_MEMB_DTLS> dataList_PT_IL_POL_FUNERAL_MEMB_DTLS = new ArrayList<PT_IL_POL_FUNERAL_MEMB_DTLS>();
	
	/*ADDED BY SANKARA NARAYNAN ON 29/03/2017*/
	private List<PT_IL_POL_FUNERAL_MEMB_DTLS> dummy_dataList_PT_IL_POL_FUNERAL_MEMB_DTLS = new ArrayList<PT_IL_POL_FUNERAL_MEMB_DTLS>();
	
	public List<PT_IL_POL_FUNERAL_MEMB_DTLS> getDummy_dataList_PT_IL_POL_FUNERAL_MEMB_DTLS() {
		return dummy_dataList_PT_IL_POL_FUNERAL_MEMB_DTLS;
	}
	public void setDummy_dataList_PT_IL_POL_FUNERAL_MEMB_DTLS(
			List<PT_IL_POL_FUNERAL_MEMB_DTLS> dummy_dataList_PT_IL_POL_FUNERAL_MEMB_DTLS) {
		this.dummy_dataList_PT_IL_POL_FUNERAL_MEMB_DTLS = dummy_dataList_PT_IL_POL_FUNERAL_MEMB_DTLS;
	}

	/*END*/
	private UIData dataTable;
	
	private List<SelectItem> listPFMD_RELATION_TYPE = new ArrayList<SelectItem>();
	
	private HtmlAjaxCommandButton COMP_PFMD_BTN_ADD;
	private HtmlAjaxCommandButton COMP_PFMD_BTN_DELETE;
	private HtmlCommandButton COMP_PFMD_BTN_POST;
	
	
	public HtmlAjaxCommandButton getCOMP_PFMD_BTN_ADD() {
		return COMP_PFMD_BTN_ADD;
	}
	public void setCOMP_PFMD_BTN_ADD(HtmlAjaxCommandButton cOMP_PFMD_BTN_ADD) {
		COMP_PFMD_BTN_ADD = cOMP_PFMD_BTN_ADD;
	}
	public HtmlAjaxCommandButton getCOMP_PFMD_BTN_DELETE() {
		return COMP_PFMD_BTN_DELETE;
	}
	public void setCOMP_PFMD_BTN_DELETE(HtmlAjaxCommandButton cOMP_PFMD_BTN_DELETE) {
		COMP_PFMD_BTN_DELETE = cOMP_PFMD_BTN_DELETE;
	}
	

	public HtmlCommandButton getCOMP_PFMD_BTN_POST() {
		return COMP_PFMD_BTN_POST;
	}
	public void setCOMP_PFMD_BTN_POST(HtmlCommandButton cOMP_PFMD_BTN_POST) {
		COMP_PFMD_BTN_POST = cOMP_PFMD_BTN_POST;
	}
	public HtmlCommandButton getCOMP_BTN_MORE() {
		return COMP_BTN_MORE;
	}
	public void setCOMP_BTN_MORE(HtmlCommandButton cOMP_BTN_MORE) {
		COMP_BTN_MORE = cOMP_BTN_MORE;
	}
	public List<SelectItem> getListPFMD_RELATION_TYPE() {
		return listPFMD_RELATION_TYPE;
	}
	public void setListPFMD_RELATION_TYPE(List<SelectItem> listPFMD_RELATION_TYPE) {
		this.listPFMD_RELATION_TYPE = listPFMD_RELATION_TYPE;
	}
	public List<PT_IL_POL_FUNERAL_MEMB_DTLS> getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS() {
		return dataList_PT_IL_POL_FUNERAL_MEMB_DTLS;
	}
	public void setDataList_PT_IL_POL_FUNERAL_MEMB_DTLS(
			List<PT_IL_POL_FUNERAL_MEMB_DTLS> dataList_PT_IL_POL_FUNERAL_MEMB_DTLS) {
		this.dataList_PT_IL_POL_FUNERAL_MEMB_DTLS = dataList_PT_IL_POL_FUNERAL_MEMB_DTLS;
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public HtmlOutputLabel getCOMP_PFMD_STATUS_LABEL() {
		return COMP_PFMD_STATUS_LABEL;
	}
	public void setCOMP_PFMD_STATUS_LABEL(HtmlOutputLabel cOMP_PFMD_STATUS_LABEL) {
		COMP_PFMD_STATUS_LABEL = cOMP_PFMD_STATUS_LABEL;
	}
	public HtmlOutputLabel getCOMP_PFMD_ADDRESS1_LABEL() {
		return COMP_PFMD_ADDRESS1_LABEL;
	}
	public void setCOMP_PFMD_ADDRESS1_LABEL(HtmlOutputLabel cOMP_PFMD_ADDRESS1_LABEL) {
		COMP_PFMD_ADDRESS1_LABEL = cOMP_PFMD_ADDRESS1_LABEL;
	}
	public HtmlInputText getCOMP_PFMD_ADDRESS1() {
		return COMP_PFMD_ADDRESS1;
	}
	public void setCOMP_PFMD_ADDRESS1(HtmlInputText cOMP_PFMD_ADDRESS1) {
		COMP_PFMD_ADDRESS1 = cOMP_PFMD_ADDRESS1;
	}
	public HtmlOutputLabel getCOMP_PFMD_ADDRESS2_LABEL() {
		return COMP_PFMD_ADDRESS2_LABEL;
	}
	public void setCOMP_PFMD_ADDRESS2_LABEL(HtmlOutputLabel cOMP_PFMD_ADDRESS2_LABEL) {
		COMP_PFMD_ADDRESS2_LABEL = cOMP_PFMD_ADDRESS2_LABEL;
	}
	public HtmlInputText getCOMP_PFMD_ADDRESS2() {
		return COMP_PFMD_ADDRESS2;
	}
	public void setCOMP_PFMD_ADDRESS2(HtmlInputText cOMP_PFMD_ADDRESS2) {
		COMP_PFMD_ADDRESS2 = cOMP_PFMD_ADDRESS2;
	}
	public HtmlOutputLabel getCOMP_PFMD_ADDRESS3_LABEL() {
		return COMP_PFMD_ADDRESS3_LABEL;
	}
	public void setCOMP_PFMD_ADDRESS3_LABEL(HtmlOutputLabel cOMP_PFMD_ADDRESS3_LABEL) {
		COMP_PFMD_ADDRESS3_LABEL = cOMP_PFMD_ADDRESS3_LABEL;
	}
	public HtmlInputText getCOMP_PFMD_ADDRESS3() {
		return COMP_PFMD_ADDRESS3;
	}
	public void setCOMP_PFMD_ADDRESS3(HtmlInputText cOMP_PFMD_ADDRESS3) {
		COMP_PFMD_ADDRESS3 = cOMP_PFMD_ADDRESS3;
	}
	public HtmlOutputLabel getCOMP_PFMD_PHONE_LABEL() {
		return COMP_PFMD_PHONE_LABEL;
	}
	public void setCOMP_PFMD_PHONE_LABEL(HtmlOutputLabel cOMP_PFMD_PHONE_LABEL) {
		COMP_PFMD_PHONE_LABEL = cOMP_PFMD_PHONE_LABEL;
	}
	public HtmlInputText getCOMP_PFMD_PHONE() {
		return COMP_PFMD_PHONE;
	}
	public void setCOMP_PFMD_PHONE(HtmlInputText cOMP_PFMD_PHONE) {
		COMP_PFMD_PHONE = cOMP_PFMD_PHONE;
	}
	public HtmlOutputLabel getCOMP_PFMD_CANTACT_LABEL() {
		return COMP_PFMD_CANTACT_LABEL;
	}
	public void setCOMP_PFMD_CANTACT_LABEL(HtmlOutputLabel cOMP_PFMD_CANTACT_LABEL) {
		COMP_PFMD_CANTACT_LABEL = cOMP_PFMD_CANTACT_LABEL;
	}
	public HtmlInputText getCOMP_PFMD_CANTACT() {
		return COMP_PFMD_CANTACT;
	}
	public void setCOMP_PFMD_CANTACT(HtmlInputText cOMP_PFMD_CANTACT) {
		COMP_PFMD_CANTACT = cOMP_PFMD_CANTACT;
	}
	public PT_IL_POL_FUNERAL_MEMB_DTLS getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN() {
		return PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN;
	}
	public void setPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN(
			PT_IL_POL_FUNERAL_MEMB_DTLS pT_IL_POL_FUNERAL_MEMB_DTLS_BEAN) {
		PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN = pT_IL_POL_FUNERAL_MEMB_DTLS_BEAN;
	}
	public HtmlOutputLabel getCOMP_PFMD_CUST_CODE_LABEL() {
		return COMP_PFMD_CUST_CODE_LABEL;
	}
	public void setCOMP_PFMD_CUST_CODE_LABEL(
			HtmlOutputLabel cOMP_PFMD_CUST_CODE_LABEL) {
		COMP_PFMD_CUST_CODE_LABEL = cOMP_PFMD_CUST_CODE_LABEL;
	}
	public HtmlInputText getCOMP_PFMD_CUST_CODE() {
		return COMP_PFMD_CUST_CODE;
	}
	public void setCOMP_PFMD_CUST_CODE(HtmlInputText cOMP_PFMD_CUST_CODE) {
		COMP_PFMD_CUST_CODE = cOMP_PFMD_CUST_CODE;
	}
	
	public HtmlInputText getCOMP_PFMD_CUST_DESC() {
		return COMP_PFMD_CUST_DESC;
	}
	public void setCOMP_PFMD_CUST_DESC(HtmlInputText cOMP_PFMD_CUST_DESC) {
		COMP_PFMD_CUST_DESC = cOMP_PFMD_CUST_DESC;
	}
	public HtmlOutputLabel getCOMP_PFMD_RELATION_TYPE_LABEL() {
		return COMP_PFMD_RELATION_TYPE_LABEL;
	}
	public void setCOMP_PFMD_RELATION_TYPE_LABEL(
			HtmlOutputLabel cOMP_PFMD_RELATION_TYPE_LABEL) {
		COMP_PFMD_RELATION_TYPE_LABEL = cOMP_PFMD_RELATION_TYPE_LABEL;
	}
	/*Modified by ganesh for ZBLIFE-1455133*/
	public HtmlInputText getCOMP_PFMD_RELATION_TYPE() {
		return COMP_PFMD_RELATION_TYPE;
	}
	public void setCOMP_PFMD_RELATION_TYPE(HtmlInputText cOMP_PFMD_RELATION_TYPE) {
		COMP_PFMD_RELATION_TYPE = cOMP_PFMD_RELATION_TYPE;
	}
	/*end*/
	public HtmlOutputLabel getCOMP_PFMD_MEMB_DOB_LABEL() {
		return COMP_PFMD_MEMB_DOB_LABEL;
	}
	public void setCOMP_PFMD_MEMB_DOB_LABEL(HtmlOutputLabel cOMP_PFMD_MEMB_DOB_LABEL) {
		COMP_PFMD_MEMB_DOB_LABEL = cOMP_PFMD_MEMB_DOB_LABEL;
	}
	
	public HtmlCalendar getCOMP_PFMD_MEMB_DOB() {
		return COMP_PFMD_MEMB_DOB;
	}
	public void setCOMP_PFMD_MEMB_DOB(HtmlCalendar cOMP_PFMD_MEMB_DOB) {
		COMP_PFMD_MEMB_DOB = cOMP_PFMD_MEMB_DOB;
	}
	public HtmlOutputLabel getCOMP_PFMD_MEMB_AGE_LABEL() {
		return COMP_PFMD_MEMB_AGE_LABEL;
	}
	public void setCOMP_PFMD_MEMB_AGE_LABEL(HtmlOutputLabel cOMP_PFMD_MEMB_AGE_LABEL) {
		COMP_PFMD_MEMB_AGE_LABEL = cOMP_PFMD_MEMB_AGE_LABEL;
	}
	public HtmlInputText getCOMP_PFMD_MEMB_AGE() {
		return COMP_PFMD_MEMB_AGE;
	}
	public void setCOMP_PFMD_MEMB_AGE(HtmlInputText cOMP_PFMD_MEMB_AGE) {
		COMP_PFMD_MEMB_AGE = cOMP_PFMD_MEMB_AGE;
	}
	public HtmlOutputLabel getCOMP_PFMD_SA_LABEL() {
		return COMP_PFMD_SA_LABEL;
	}
	public void setCOMP_PFMD_SA_LABEL(HtmlOutputLabel cOMP_PFMD_SA_LABEL) {
		COMP_PFMD_SA_LABEL = cOMP_PFMD_SA_LABEL;
	}
	
	public HtmlInputText getCOMP_PFMD_SA() {
		return COMP_PFMD_SA;
	}
	public void setCOMP_PFMD_SA(HtmlInputText cOMP_PFMD_SA) {
		COMP_PFMD_SA = cOMP_PFMD_SA;
	}
	public HtmlOutputLabel getCOMP_PFMD_PREMIUM_LABEL() {
		return COMP_PFMD_PREMIUM_LABEL;
	}
	public void setCOMP_PFMD_PREMIUM_LABEL(HtmlOutputLabel cOMP_PFMD_PREMIUM_LABEL) {
		COMP_PFMD_PREMIUM_LABEL = cOMP_PFMD_PREMIUM_LABEL;
	}
	public HtmlInputText getCOMP_PFMD_PREMIUM() {
		return COMP_PFMD_PREMIUM;
	}
	public void setCOMP_PFMD_PREMIUM(HtmlInputText cOMP_PFMD_PREMIUM) {
		COMP_PFMD_PREMIUM = cOMP_PFMD_PREMIUM;
	}
	public HtmlOutputLabel getCOMP_PFMD_CURR_ASSR_LABEL() {
		return COMP_PFMD_CURR_ASSR_LABEL;
	}
	public void setCOMP_PFMD_CURR_ASSR_LABEL(
			HtmlOutputLabel cOMP_PFMD_CURR_ASSR_LABEL) {
		COMP_PFMD_CURR_ASSR_LABEL = cOMP_PFMD_CURR_ASSR_LABEL;
	}
	
	public HtmlOutputLabel getCOMP_PFMD_WOP_LABEL() {
		return COMP_PFMD_WOP_LABEL;
	}
	public void setCOMP_PFMD_WOP_LABEL(HtmlOutputLabel cOMP_PFMD_WOP_LABEL) {
		COMP_PFMD_WOP_LABEL = cOMP_PFMD_WOP_LABEL;
	}
	
	
	public HtmlSelectBooleanCheckbox getCOMP_PFMD_CURR_ASSR() {
		return COMP_PFMD_CURR_ASSR;
	}
	public void setCOMP_PFMD_CURR_ASSR(HtmlSelectBooleanCheckbox cOMP_PFMD_CURR_ASSR) {
		COMP_PFMD_CURR_ASSR = cOMP_PFMD_CURR_ASSR;
	}
	public HtmlSelectBooleanCheckbox getCOMP_PFMD_WOP() {
		return COMP_PFMD_WOP;
	}
	public void setCOMP_PFMD_WOP(HtmlSelectBooleanCheckbox cOMP_PFMD_WOP) {
		COMP_PFMD_WOP = cOMP_PFMD_WOP;
	}
	public HtmlSelectBooleanCheckbox getCOMP_PFMD_STATUS() {
		return COMP_PFMD_STATUS;
	}
	public void setCOMP_PFMD_STATUS(HtmlSelectBooleanCheckbox cOMP_PFMD_STATUS) {
		COMP_PFMD_STATUS = cOMP_PFMD_STATUS;
	}
	
	
	public void onLoad(PhaseEvent event) {
		try {
			
			if (isBlockFlag()) {
				helper.whenNewRecord(this);
				helper.executeQuery(compositeAction);
				
				/*System.out.println("Welcome to Member Body onload");
				if(compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS() != null )
				{
					System.out.println("Size       "+compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS().size());
					if(compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS().size() == 0)
					{
						helper.executeQuery(compositeAction);
					}
				}*/
				
				
				/*added by raja on 23-02-2017 for defaulting borker details page*/
				
			//	helper.validatePFMD_CUST_CODE(compositeAction,PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN);
				
				if((PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getROWID()!=null))
				{
					helper.PFMD_AGE_PROOF_FLAG_WHEN_VALIDATE_ITEM(this,compositeAction);
				}
				else
				{
				helper.fecthdata(compositeAction);
				/*Added by Ameen on 10-07-2017 for ZBILQC-1731204*/
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_EFF_FM_DT(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_START_DT());
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_EFF_TO_DT(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_EXPIRY_DT());
				/*end*/
				}
				resetAllComponents();
				/*Added by Ameen on 10-07-2017 for ZBILQC-1731204*/
				saErrmsg = getErrMsg(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE());
				System.out.println("saErrmsg ::" + saErrmsg);
				/*end*/
				setBlockFlag(false);
				
				//Added by saritha on 05-01-2017				
				PlanTypeLorH();				
				//End
				
				}
					
				/*added by raja on 23-05-2017*/
			
			checkEndoDeletion();
			
			/*end*/
				/*end*/
				
			 /*added by raja on 28-06-2017 for discussed with ajoy */ 
			
			/*if(!compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS().equalsIgnoreCase("A") && 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()!=null && 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("CDOB"))*/
			
			/*Modified by Janani on 23.01.2018 for Change in DOB alteration issue*/
			if(!compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS().equalsIgnoreCase("A") && 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()!=null && 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("CDOB") &&
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("N") )
			
			{
				
			/*End*/	
				
				COMP_PFMD_MEMB_DOB.setDisabled(false);
				
			}
			/*end*/
			
			/*Added by Ameen on 10-07-2017 for ZBILQC-1731204*/
			if("H".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE())){
				COMP_PFMD_SA_LABEL.setValue("Daily Benefit Limit");
			}else{
				COMP_PFMD_SA_LABEL.setValue("Sum Assured");
			}
			/*end*/
			
			/*added by Ameen on 01-11-2017 for ZBLIFE-1449096*/
			if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.isPFMD_STATUS_UI() == true){
				COMP_UI_M_STATUS.setValue("InActive");
			}else if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.isPFMD_STATUS_UI() == false){
				if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE() != null){
					COMP_UI_M_STATUS.setValue("Active");
				}else{
					COMP_UI_M_STATUS.setValue("");
				}
			}
			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
			
			
		}
	}
	
	public void prepareDropDownList(){
		Connection connection;
		try{
			connection = CommonUtils.getConnection();
			listPFMD_RELATION_TYPE = ListItemUtil.getDropDownListValue(
					connection, "PILT002_APAC", "PT_IL_POL_FUNERAL_MEMB_DTLS",
					"PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_RELATION_TYPE", "IL_PAR_MEMB");
			
			setListPOAD_HIV_TEST_YN(ListItemUtil.getDropDownListValue(
				    CommonUtils.getConnection(), "PILT002_APAC", "PT_IL_POL_ASSURED_DTLS",
				    "PT_IL_POL_ASSURED_DTLS.POAD_HIV_TEST_YN", "YESNO"));
			
			setListPFMD_AGE_PROOF_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_AGE_PROOF_FLAG",
					"IL_AGE_PROOF"));
			/*Added by sankara narayanan for hospital Cashplan on 22/04/2017*/
			
			setListPFMD_SMOKER_TEST_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_SMOKE_YN", "YESNO"));
			/*end*/
			
			/*Added By Dhinesh on 05-06-2018 for FLA Funeral Changes*/
			setListPFMD_PREM_CALC_TYPE(ListItemUtil.getDropDownListValue(
			          CommonUtils.getConnection(), "PILT002_APAC",
			          "PT_IL_POL_FUNERAL_MEMB_DTLS",
			          "PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_PREM_CALC_TYPE", "IL_PREM_TYPE"));
			/*End*/
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}
	
	public void resetAllComponents()
	{
		COMP_PFMD_ADDRESS1.resetValue();
		COMP_PFMD_ADDRESS2.resetValue();
		COMP_PFMD_ADDRESS3.resetValue();
		COMP_PFMD_CANTACT.resetValue();
		COMP_PFMD_CURR_ASSR.resetValue();
		COMP_PFMD_CUST_CODE.resetValue();
		COMP_PFMD_CUST_DESC.resetValue();
		COMP_PFMD_MEMB_AGE.resetValue();
		COMP_PFMD_MEMB_DOB.resetValue();
		COMP_PFMD_PHONE.resetValue();
		COMP_PFMD_PREMIUM.resetValue();
		COMP_PFMD_RELATION_TYPE.resetValue();
		COMP_PFMD_SA.resetValue();
		COMP_PFMD_STATUS.resetValue();
		COMP_PFMD_WOP.resetValue();
		/*added by gopi for showing description for relation type on 01/02/17*/
		COMP_PFMD_MEMB_TYPE.resetValue();
		COMP_PFMD_MEMB_TYPE_DESC.resetValue();
		/*end*/
		
		/*aded by raja on 27-03-2017 for ZBILQC-1722140 */
		COMP_PFMD_AGE_PROOF_FLAG.resetValue();
		COMP_PFMD_AGE_PROOF_OTHERS.resetValue();
		COMP_PFMD_HIV_TEST_YN.resetValue();
		COMP_PFMD_LC_THRESHOLD_LMT.resetValue();
		COMP_UI_M_NATIONAL_ID.resetValue();
		/*end*/
		/*Added by sankara narayanan on 22/04/2017*/
		COMP_PFMD_SMOKER_TEST_YN.resetValue();
		COMP_PFMD_GENDER.resetValue();
		COMP_UI_PFMD_NO_OF_DAYS.resetValue();
		/*end*/
		
		/*added by Ameen on 01-11-2017 for ZBLIFE-1449096*/
		COMP_PFMD_EFF_FM_DT.resetValue();
		COMP_PFMD_EFF_TO_DT.resetValue();
		/*end*/
		/*Added by ganesh on 17-11-2017 for ZBLIFE-1455133*/
		COMP_UI_M_PFMD_RELATION_DESC.resetValue();
		/*end*/
		
		/*Added By Dhinesh on 05-06-2018 for FLA Funeral Changes*/
		COMP_PFMD_PREM_CALC_TYPE.resetValue();
		/*end*/
	}
	
	public void disableAllComponents(boolean disabled){
		COMP_PFMD_CUST_CODE.setDisabled(disabled);
		COMP_PFMD_CURR_ASSR.setDisabled(disabled);
		/*COMP_PFMD_BTN_ADD.setDisabled(disabled);
		COMP_PFMD_BTN_DELETE.setDisabled(disabled);
		COMP_PFMD_BTN_POST.setDisabled(disabled);*/
		COMP_PFMD_SA.setDisabled(disabled);
		COMP_PFMD_RELATION_TYPE.setDisabled(disabled);
		/*added by gopi for showing description for relation type on 01/02/17*/
		COMP_PFMD_MEMB_TYPE.setDisabled(disabled);
		
		/*end*/
		/*aded by raja on 27-03-2017 for ZBILQC-1722140 */
		COMP_PFMD_AGE_PROOF_FLAG.setDisabled(disabled);
		COMP_PFMD_AGE_PROOF_OTHERS.setDisabled(disabled);
		COMP_PFMD_HIV_TEST_YN.setDisabled(disabled);
		COMP_PFMD_LC_THRESHOLD_LMT.setDisabled(disabled);
		COMP_UI_M_NATIONAL_ID.setDisabled(disabled);
		/*end*/
		
		/*Added by sankaranarayanan on 22/04/2017*/
		COMP_PFMD_SMOKER_TEST_YN.setDisabled(disabled);
		COMP_PFMD_GENDER.setDisabled(disabled);
		
		/*end*/
		
		/*added by Ameen on 01-11-2017 for ZBLIFE-1449096*/
		COMP_PFMD_EFF_FM_DT.setDisabled(disabled);
		COMP_PFMD_EFF_TO_DT.setDisabled(disabled);
		/*END*/
		
		/*Added By Dhinesh on 05-06-2018 for FLA Funeral Changes*/
		COMP_PFMD_PREM_CALC_TYPE.setDisabled(disabled);
		/*End*/
	}
	
	public void initiateAllComponents()
	{
		COMP_PFMD_BTN_ADD=new HtmlAjaxCommandButton();
		COMP_PFMD_BTN_DELETE=new HtmlAjaxCommandButton();
		COMP_PFMD_BTN_POST=new HtmlCommandButton();
		COMP_PFMD_ADDRESS1=new HtmlInputText();
		COMP_PFMD_ADDRESS2=new HtmlInputText();
		COMP_PFMD_ADDRESS3=new HtmlInputText();
		COMP_PFMD_CANTACT=new HtmlInputText();
		COMP_PFMD_CURR_ASSR=new HtmlSelectBooleanCheckbox();
		COMP_PFMD_CUST_CODE=new HtmlInputText();
		COMP_PFMD_CUST_DESC=new HtmlInputText();
		COMP_PFMD_MEMB_AGE=new HtmlInputText();
		COMP_PFMD_MEMB_DOB=new HtmlCalendar();
		COMP_PFMD_PHONE=new HtmlInputText();
		COMP_PFMD_PREMIUM=new HtmlInputText();
		/*Modified by ganesh for ZBLIFE-1455133*/
		COMP_PFMD_RELATION_TYPE=new HtmlInputText();
		/*end*/
		COMP_PFMD_SA=new HtmlInputText();
		COMP_PFMD_STATUS=new HtmlSelectBooleanCheckbox();
		COMP_PFMD_WOP=new HtmlSelectBooleanCheckbox();
		/*added by gopi for showing description for relation type on 01/02/17*/
		COMP_PFMD_MEMB_TYPE = new HtmlInputText();
		COMP_PFMD_MEMB_TYPE_DESC = new HtmlInputText();
		/*end*/
		/*aded by raja on 27-03-2017 for ZBILQC-1722140 */
		COMP_PFMD_AGE_PROOF_FLAG = new HtmlSelectOneMenu();
		COMP_PFMD_AGE_PROOF_OTHERS =new HtmlInputText();
		COMP_PFMD_HIV_TEST_YN =new HtmlSelectOneMenu();
		COMP_PFMD_LC_THRESHOLD_LMT =new HtmlInputText();
		COMP_UI_M_NATIONAL_ID =new HtmlInputText();
	/*end*/
		/*Addeed by sankar narayanan on 22/04/2017*/
		COMP_PFMD_SMOKER_TEST_YN= new HtmlSelectOneMenu();
		COMP_PFMD_SMOKER_TEST_YN_LABEL=new HtmlOutputLabel();
		COMP_UI_PFMD_GENDER_DESC=new HtmlInputText();
		COMP_PFMD_GENDER=new HtmlInputText();
		COMP_PFMD_GENDER_LABEL=new HtmlOutputLabel();
		 COMP_UI_PFMD_NO_OF_DAYS_LABEL=new HtmlOutputLabel();
		 COMP_UI_PFMD_NO_OF_DAYS=new HtmlInputText();
		 COMP_BTN_POL_ILLNESS= new HtmlCommandButton();
		/*end*/
		 
		 /*added by Ameen on 01-11-2017 for ZBLIFE-1449096*/
			COMP_PFMD_EFF_FM_DT = new HtmlCalendar();
			COMP_PFMD_EFF_TO_DT = new HtmlCalendar();
			/*END*/
			/*Added by ganesh for ZBLIFE-1455133*/
			COMP_UI_M_PFMD_RELATION_DESC = new HtmlInputText();
			/*end*/
			/*Added By Dhinesh on 05-06-2018 for FLA Funeral Changes*/
			COMP_PFMD_PREM_CALC_TYPE_LABEL = new HtmlOutputLabel();
			COMP_PFMD_PREM_CALC_TYPE = new HtmlSelectOneMenu();
			/*End*/
	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_POL_FUNERAL_MEMB_DTLS> PT_IL_POL_FUNERAL_MEMB_ITR = dataList_PT_IL_POL_FUNERAL_MEMB_DTLS.iterator();
		while (PT_IL_POL_FUNERAL_MEMB_ITR.hasNext()) {
			PT_IL_POL_FUNERAL_MEMB_ITR.next().setRowSelected(false);
		}
	}
	
	int rowindex;
	
	public int getRowindex() {
		return rowindex;
	}
	public void setRowindex(int rowindex) {
		this.rowindex = rowindex;
	}
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN = (PT_IL_POL_FUNERAL_MEMB_DTLS) dataTable.getRowData();
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setRowSelected(true);
			rowindex=dataTable.getRowIndex();
			helper.PFMD_AGE_PROOF_FLAG_WHEN_VALIDATE_ITEM(this,compositeAction);
			resetAllComponents();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	
	public void addRow(ActionEvent event) {
		String message = null;
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN = new PT_IL_POL_FUNERAL_MEMB_DTLS();
				helper.whenNewRecord(this);
				/*added by Ameen on 01-11-2017 for ZBLIFE-1449096*/
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null 
						&& "ADDDEP".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE())){
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_EFF_FM_DT(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_EFF_FROM_DT());
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_EFF_TO_DT(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_EXPIRY_DT());
				}else{
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_EFF_FM_DT(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_START_DT());
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_EFF_TO_DT(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_EXPIRY_DT());
				}
				/*end*/
				resetAllComponents();
				resetSelectedRow();
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"); 
				getErrorMap().put("addRow",message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			
			exc.printStackTrace();
		}

	}

public void deleteRow(ActionEvent event) {
		String message = null;
		CommonUtils.clearMaps(this);
		try {
			
			/*added the if condition by raja on 23-02-2017 for defaulting borker details page*/ 
			System.out.println("Relation Type == "+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE());
			if(!(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE().equalsIgnoreCase("01")))
			{
				
				/*added by raja on 23-05-2017 for ZBILQC-1727275*/
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()!=null 
						&& compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("ADDDEP") 
						&& PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_REC_TYPE()==2)	
				{
					this.setDELETE_ALLOWED(true);
				}
				/*end*/
				
			if (isDELETE_ALLOWED()) {
				
				
				/*added by raja on 17-05-2017 for addition of dependant*/
				
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()!=null 
						&& compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("DELDEP"))	
				{
					/*changed by raja on 01-06-2017 for addition of dependant*/
					/*PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_SA((PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA()*-1));
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_PREMIUM(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_PREMIUM()*-1);*/
					if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_REC_TYPE()==3)
					{
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_REC_TYPE(4);
					new CRUDHandler().executeUpdate(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN,CommonUtils.getConnection());
					message ="Endorsement Deletion Sucessfully !!!!!";
					CommonUtils.getConnection().commit();
					/*added by raja on 01-06-2017 for addition of dependant*/
					P_FUNERAL_DEP_UPD(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
							PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SYS_ID());
					CommonUtils.getConnection().commit();
					
					setBlockFlag(true);
					}
					else if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_REC_TYPE()==4)
					{
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_REC_TYPE(3);
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_DEL_FLAG(null);
						//PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_SA(0.0);
						//PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_PREMIUM(0);
						new CRUDHandler().executeUpdate(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN,CommonUtils.getConnection());
						P_FUNERAL_DEP_UPD(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
								PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SYS_ID());
						
						CommonUtils.getConnection().commit();
						setBlockFlag(true);
					}
					
					/*end*/
				}
				else
				{
				
				/*end*/	
					
				new CRUDHandler().executeDelete(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"); 
				dataList_PT_IL_POL_FUNERAL_MEMB_DTLS.remove(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN);
				if (dataList_PT_IL_POL_FUNERAL_MEMB_DTLS.size() > 0) {
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN = dataList_PT_IL_POL_FUNERAL_MEMB_DTLS.get(0);
				} 
				 
				else if (dataList_PT_IL_POL_FUNERAL_MEMB_DTLS.size() == 0) {
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_RELATION_TYPE("01");
					
			}				
				resetAllComponents();
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setRowSelected(true);
				CommonUtils.getConnection().commit();
				
				/*added by raja on 17-05-2017 for addition of dependant*/
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()!=null 
						&& compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("ADDDEP") 
						&& PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_REC_TYPE()==2)	
				{
					this.setDELETE_ALLOWED(false);
				}
				/*end*/

				
				}
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"); 
			}

			getWarningMap().put("deleteRow",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}
			/*added by raja on 23-02-2017 for defaulting borker details page*/
			else
			{
				throw new Exception("Cannot delete record with Relation type Principal");
			}
			/*end*/
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

		boolean flag=false;



		public void postRecord(ActionEvent event) throws Exception {
		String message = null;
		try {
			
			/*added by raja on 13-06-2017 for ZBILQC-1724894*/ 
			
			LIFELIB lifelib = new LIFELIB();
			 lifelib.P_VAL_CUST(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE(),
					 PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_DESC(), "N", "N",
					 compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE());
			 
			/*end*/
			 
			/*added by raja on 23-05-2017 for ZBILQC-1727275*/
			
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()!=null 
					&& compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("ADDDEP") 
					&& PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_REC_TYPE()==2)	
			{
				this.setUPDATE_ALLOWED(true);
			}
			
			
			/*end*/
			if (PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				//helper.validate_benf_type(this);
				/*added by gopi for funeral beneficiary on 28/02/2017*/
				String Plan_code=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE();
			//	Min_Max_value(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA(),PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE());
				/*end*/
				helper.checkDuplicate(this);
				flag=false;
				/*cOMMENTED BY RAJA ON 29/03/2017
				 * cust_validation(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA(),PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(),
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE());*/
				/*validation();*/
				helper.preInsert(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(),PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN);
				/*dummy_dataList_PT_IL_POL_FUNERAL_MEMB_DTLS.add(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN);
				helper.Validatemember(dummy_dataList_PT_IL_POL_FUNERAL_MEMB_DTLS);*/
				/*Added by Ameen on 31-07-2017 for ZBILQC-1733321*/
				P9ILPK_POLICY_NR p9ilpk_policy_nr = new P9ILPK_POLICY_NR();
				/*
				 * modified by Ameen on 08-08-2017 to add CUST_CODE parameter for ZBILQC-1734095
				 * p9ilpk_policy_nr.P_UPD_PREM_FLAG(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_HIV_TEST_YN());*/
				p9ilpk_policy_nr.P_UPD_PREM_FLAG(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE(),PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_HIV_TEST_YN(),1.0,1.0);
				/*End*/
				no_of_lives();
				/*Modified by ganesh on 18-01-2018 for ZBLIFE-1471888 */
				//sum_assured_validation();
				sum_assured_validation(null);
				/*End of ZBLIFE-1471888*/
				/*Added by Raja on 18.04.2017 for handson feedback */
				memberCountValidation();
				
				/*End*/
				
				/*added by raja on 16-05-2017*/
				helper.validateAge(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_AGE(), PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(), 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE(),
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_TYPE());
				/*end*/
				/*added by raja on 16-05-2017*/
				
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_REC_TYPE(2);
				
				
				/*end*/
				new CRUDHandler().executeInsert(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN,CommonUtils.getConnection());
				
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
				
				
				
				dataList_PT_IL_POL_FUNERAL_MEMB_DTLS.add(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN);
				
			
			} else if (PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				/*added by gopi for funeral beneficiary on 28/02/2017*/
				String Plan_code=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE();
			//	Min_Max_value(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA(),PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE());
				/*end*/
				//helper.validate_benf_type(this);
				helper.checkDuplicate(this);
				/*
				 * cOMMENTED BY RAJA ON 29/03/2017
				 * 
				 * cust_validation(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA(),PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(),
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE());*/
				/*validation();*/
				no_of_lives();
				/*Modified by ganesh on 18-01-2018 for ZBLIFE-1471888 */
				//sum_assured_validation();
				sum_assured_validation(null);
				/*End of ZBLIFE-1471888 */
				
				/*added by raja on 16-05-2017*/
				helper.validateAge(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_AGE(), PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(), 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE(),
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_TYPE());
				/*end*/
				
				helper.preUpdate(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(),PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN);
				/*Added by Ameen on 31-07-2017 for ZBILQC-1733321*/
				P9ILPK_POLICY_NR p9ilpk_policy_nr = new P9ILPK_POLICY_NR();
				/*
				 * modified by Ameen on 08-08-2017 to add CUST_CODE parameter for ZBILQC-1734095
				 * p9ilpk_policy_nr.P_UPD_PREM_FLAG(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_HIV_TEST_YN());*/
				p9ilpk_policy_nr.P_UPD_PREM_FLAG(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE(),PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_HIV_TEST_YN(),1.0,1.0);
				/*End*/
			
				 /*added by raja on 28-06-2017 for discussed with ajoy */ 
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()!=null && 
						(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("INCSA") || 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("DECSA") ||
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("CDOB")))
				{
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_REC_TYPE(2);
				}
				/*end*/
				
				new CRUDHandler().executeUpdate(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN,CommonUtils.getConnection());
				
				
				
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
				
				/*added by raja on 23-05-2017 for ZBILQC-1727275*/
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()!=null 
						&& compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("ADDDEP") 
						&& PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_REC_TYPE()==2)	
				{
					this.setUPDATE_ALLOWED(false);
				}
				/*end*/
			}
			/*added by raja on 18-05-2017 for funeral benefit fsd endorsement*/
			
			else
			{
				message ="cannot updated";
			}
			
			/*end*/
		
				helper.callP_CALC_PREMIUM_FUNERAL(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_SYS_ID(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE());
		
			CommonUtils.getConnection().commit();
			setBlockFlag(true);
			
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			exc.printStackTrace();
			
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: " + exc.getMessage());
			//throw new ValidatorException(new FacesMessage(exc.getMessage()));
			
		}
		

	}

		/*public void saveRecord() {
			
			String message = null;
			changed by raja for funeral benifit fsd
			double sumAssued0=0.0;
			double sumAssued1=0.0;
			double sumAssued2=0.0;
			double sumAssued3=0.0;
			double sumAssued4=0.0;
			double sumAssued5=0.0;
			double sumAssued6=0.0;
			
			int count1=0;
			int count2=0;
			int count3=0;
			int count4=0;
			int count5=0;
			int count6=0;
			end
			
			try {
				if (dataList_PT_IL_POL_FUNERAL_MEMB_DTLS.size() == 0) {
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN=new PT_IL_POL_FUNERAL_MEMB_DTLS();	
					resetAllComponents();
				}
				
				changed by raja for funeral benifit fsd
				
				for(PT_IL_POL_FUNERAL_MEMB_DTLS  bean: this.getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS()) {
					
					if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("01"))
					{
				count1++;
				sumAssued0=sumAssued0+bean.getPFMD_SA();
				Min_Max_value(sumAssued0,bean.getPFMD_RELATION_TYPE().toString());
				cust_validation(sumAssued0,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());
				
					}
					
					if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("02"))
							{
						count1++;
						sumAssued1=sumAssued1+bean.getPFMD_SA();
						Min_Max_value(sumAssued1,bean.getPFMD_RELATION_TYPE().toString());
						no_of_live(count1,bean.getPFMD_RELATION_TYPE().toString());
						////cust_validation(sumAssued1,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());
						
							}
					else if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("03"))
					{
						count2++;
						sumAssued2=sumAssued2+bean.getPFMD_SA();
						Min_Max_value(sumAssued2,bean.getPFMD_RELATION_TYPE().toString());
						no_of_live(count2,bean.getPFMD_RELATION_TYPE().toString());
						//cust_validation(sumAssued2,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());
					}
					else if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("04"))
					{
						count3++;
						sumAssued3=sumAssued3+bean.getPFMD_SA();
						Min_Max_value(sumAssued3,bean.getPFMD_RELATION_TYPE().toString());
						no_of_live(count3,bean.getPFMD_RELATION_TYPE().toString());
						//cust_validation(sumAssued3,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());
					}
					else if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("05"))
						
					{
						count4++;
						sumAssued4=sumAssued4+bean.getPFMD_SA();
						Min_Max_value(sumAssued4,bean.getPFMD_RELATION_TYPE().toString());
						no_of_live(count4,bean.getPFMD_RELATION_TYPE().toString());
						//cust_validation(sumAssued4,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());
						}
					else if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("06"))
					{
						count5++;
						sumAssued5=sumAssued5+bean.getPFMD_SA();
						Min_Max_value(sumAssued5,bean.getPFMD_RELATION_TYPE().toString());
						no_of_live(count5,bean.getPFMD_RELATION_TYPE().toString());
						//cust_validation(sumAssued5,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());
					}
					
					else if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("07"))
					{
						count6++;
						sumAssued6=sumAssued6+bean.getPFMD_SA();
						Min_Max_value(sumAssued6,bean.getPFMD_RELATION_TYPE().toString());
						no_of_live(count6,bean.getPFMD_RELATION_TYPE().toString());
						//cust_validation(sumAssued6,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());
					}
				}
				
				end
				
				helper.callP_CALC_PREMIUM_FUNERAL(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_SYS_ID(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE());
				
				
				
				
				CommonUtils.getConnection().commit();
				setBlockFlag(true);
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
				getWarningMap().put("SAVE",message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("SAVE", e.getMessage());
				//throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}*/
		
		public ArrayList<LovBean> lovPFMD_CUST_CODE(Object object) {
			ArrayList<LovBean> lovList = new ArrayList<LovBean>();
			ListItemUtil itemUtil = new ListItemUtil();
			String currentValue = (String) object;
			String moduleName = "PILT002_APAC";
			String blockName = "PT_IL_POL_FUNERAL_MEMB_DTLS";
			String fieldName = "PFMD_CUST_CODE";
			try {
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
				
				lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, null, null,
						null, null, null, currentValue);
				
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return lovList;
		}
		
		public void validatePFMD_CUST_CODE(ActionEvent event){

			try {
				getErrorMap().clear();
				getWarningMap().clear();
				String value=(String)COMP_PFMD_CUST_CODE.getSubmittedValue();
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_CUST_CODE(value);
				helper.validatePFMD_CUST_CODE(compositeAction,PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN);
				
				COMP_PFMD_ADDRESS1.resetValue();
				COMP_PFMD_ADDRESS2.resetValue();
				COMP_PFMD_ADDRESS3.resetValue();
				COMP_PFMD_CANTACT.resetValue();
				COMP_PFMD_MEMB_DOB.resetValue();
				COMP_PFMD_PHONE.resetValue();
				COMP_PFMD_MEMB_AGE.resetValue();
				COMP_PFMD_STATUS.resetValue();
				COMP_PFMD_LC_THRESHOLD_LMT.resetValue();
				COMP_UI_M_NATIONAL_ID.resetValue();
				COMP_PFMD_GENDER.resetValue();
				COMP_UI_PFMD_GENDER_DESC.resetValue();
				/*added by gopi for ssp call id ZBILQC-1726698 on 12/06/17*/
				COMP_PFMD_AGE_PROOF_OTHERS.resetValue();
				COMP_PFMD_AGE_PROOF_FLAG.resetValue();
				//end
			} catch (Exception e) {
				getErrorMap().put("current", e.getMessage());
				//throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void validatePFMD_RELATION_TYPE(FacesContext context,
				UIComponent component, Object value){

		/*	public void validatePFMD_RELATION_TYPE( ActionEvent actionEvent) {*/
				/*getWarningMap().clear();
				UIInput input = (UIInput) actionEvent.getComponent().getParent();
				String value1 = input.getSubmittedValue().toString();*/
			try {
				getErrorMap().clear();
				String value1=/*(String)COMP_PFMD_RELATION_TYPE.getSubmittedValue();*/(String) value;
				helper.validatePFMD_RELATION_TYPE(compositeAction,PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN,value1);
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_RELATION_TYPE(value1);
				COMP_PFMD_MEMB_DOB.resetValue();
				/*
				 * commneted by Ameen on 11-07-2017 for ZBILQC-1731204
				 * COMP_PFMD_MEMB_TYPE.resetValue();
				COMP_PFMD_MEMB_TYPE_DESC.resetValue();*/
				
				/* Dependent Type value defaulted based on relationship code*/
				COMP_PFMD_MEMB_TYPE.resetValue();
				COMP_PFMD_MEMB_TYPE_DESC.resetValue();
				/* End */
				
				COMP_UI_PFMD_NO_OF_DAYS.resetValue();
				
				
			} catch (Exception e) {
				//getErrorMap().put("current", e.getMessage());
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		
		
		public void validatePFMD_MEMB_DOB(FacesContext context,
				UIComponent component, Object value){

			try {
				
				//UIInput input = (UIInput) event.getComponent().getParent();
				Date inputDate=(Date)value;
				//helper.validatePFMD_MEMB_DOB(compositeAction,PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN,inputDate);
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_MEMB_DOB(inputDate);
				
				
				ArrayList<OracleParameter> list2 = null;
				PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
				DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
				
				list2 = localProcedure.P_CALC_ANB(new CommonUtils().getCurrentDate(), PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_DOB(),
						dummyBean.getUI_M_PROD_AGE_CALC_FLAG(),PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_AGE());
				if (list2 != null && !list2.isEmpty()) {
					if (list2.get(0).getValueObject() != null) {
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_MEMB_AGE((Integer)list2.get(0).getValueObject());
						COMP_PFMD_MEMB_AGE.resetValue();
					}
				}
				
				if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_AGE()>0)
				{
					helper.validateAge(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_AGE(), PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(), 
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE(),PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_TYPE());
				}
				
				
				/*Newly Added By Dhinesh on 15-06-2017 for ssp call id  ZBILQC-1727540*/
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setUI_M_PFMD_MEMB_DOB(CommonUtils.dateToStringFormat(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_DOB()));
				/*End*/
				
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("current", e.getMessage());
				//throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void fireFieldValidation(ActionEvent actionEvent) {
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		}
		
		/*Added by Ameen on 10-07-2017 for ZBILQC-1731204*/
		public void sumAssuredfireFieldValidation(ActionEvent actionEvent) {
			
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String value = input.getSubmittedValue().toString();
			
			HashMap<String, String> dynamicLabelMap = new HashMap<String, String>();
			dynamicLabelMap.put(input.getId(), COMP_PFMD_SA_LABEL.getValue().toString());
			ErrorHelpUtil.validate(input, getErrorMap(), dynamicLabelMap);
		}
		/*End*/
		
		public void validateASSURED(ActionEvent actionEvent){

			try {
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_CURR_ASSR_UI((boolean)COMP_PFMD_CURR_ASSR.getSubmittedValue());
					
			} catch (Exception e) {
				getErrorMap().put("current", e.getMessage());
				//throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void validateSTATUS(ActionEvent actionEvent){

			try {
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_STATUS_UI((boolean)COMP_PFMD_STATUS.getSubmittedValue());
					
			} catch (Exception e) {
				getErrorMap().put("current", e.getMessage());
				//throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void validateWOP(ActionEvent actionEvent){

			try {
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_WOP_UI((boolean)COMP_PFMD_WOP.getSubmittedValue() );
					
			} catch (Exception e) {
				getErrorMap().put("current", e.getMessage());
				//throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public String clickMore() {
			
			try {
				System.out.println("More button is clicked");
			} catch (Exception exc) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						exc.getMessage());
				
				exc.printStackTrace();
			}
			return "DUMMY_FUNERAL_BENIFIT";

		}
		
		public void validatePFMD_SA(FacesContext context,
				UIComponent component, Object value){

			try {
				
				Double Current =(Double)value;
		
				ResultSet resultSetSA = null;
								
				CRUDHandler handler = new CRUDHandler();
				/*if(Current!=null&&Current>=0){*/
				
				/*Added by Janani on 16.01.2018 for  ZBLIFE-1471888*/
				
				String plan_type = null;
				
				String plan_query = "SELECT PLAN_TYPE FROM PT_IL_POLICY,PM_IL_PRODUCT,PM_IL_PLAN "+ 
					      "WHERE PLAN_CODE = POL_PLAN_CODE AND PROD_CODE = POL_PROD_CODE AND POL_NO = ?";
				
				resultSetSA = handler.executeSelectStatement(plan_query, CommonUtils.getConnection(),
							new Object[] { compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});
				if (resultSetSA.next()) {
					plan_type = resultSetSA.getString(1);
					
				} 
				
				System.out.println("plan_type              "+plan_type);
				
				/*End of ZBLIFE-1471888*/
				

				/*added by raja on 26-05-2017 for ZBILQC-1727275*/
				
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()==null
						|| !compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("DELDEP"))
				{
					
				if(getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS().size()>1)
				{
					if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE().equalsIgnoreCase("01"))
					{
						double self_sumassured=Current;
						for(PT_IL_POL_FUNERAL_MEMB_DTLS bean:getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS())
						{
							if(!PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getROWID().equalsIgnoreCase(bean.getROWID()))
							{
								if(self_sumassured<bean.getPFMD_SA())
								{
									/*added by raja on 23-05-2017 for ZBILQC-1727275*/
									if(self_sumassured>0)
									{
									throw new Exception("Principal sumassured is greater than dependant sumassured");
									}
									/*end*/
								}
							}
						}
					}
				}
			}
				
				/*end*/
				/*added by raja on 14-05-2017*/
				double sumassur=0.0;
				
				/*Added by ganesh for ZBLIFE-1455133 handled null issue*/
				if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE()!=null && !PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE().equalsIgnoreCase("01"))
				{
					
					
					
					/*added by raja on 23-05-2017 for ZBILQC-1727275*/
					
					if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_REC_TYPE()!=4 && 
							(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()!=null && 
							(!compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("INCSA")
							|| !compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("DECSA"))))
					{
						if(Current<=0)
						{
							throw new Exception("Sum Assured should be greater than Zero");
						}
					}
					
					
					
					
					if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_REC_TYPE()<=0 || PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_REC_TYPE()==2)
					{
						if(Current<=0)
						{
							throw new Exception("Sum Assured should be greater than Zero");
						}
					}
					
					String Query=null;
					if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()==null
							|| !compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("ADDDEP"))
					{
						
						
						Query="SELECT PFMD_SA FROM PT_IL_POL_FUNERAL_MEMB_DTLS where PFMD_POL_SYS_ID=? AND PFMD_RELATION_TYPE='01'";
						ResultSet result_sumass=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), 
								new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
						
						if(result_sumass.next())
						{
							sumassur=result_sumass.getDouble("PFMD_SA");
						}
						
						
						
					}
					else
					{
					/*end*/
						Query="SELECT PFMD_ORG_SA FROM PT_IL_POL_FUNERAL_MEMB_DTLS where PFMD_POL_SYS_ID=? AND PFMD_RELATION_TYPE='01'";
						ResultSet result_sumass=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), 
								new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
						
						if(result_sumass.next())
						{
							sumassur=result_sumass.getDouble("PFMD_ORG_SA");
						}
				/*added by raja on 23-05-2017 for ZBILQC-1727275*/
					}
					/*end*/
				}
				if(sumassur>0)
				{
					if(Current>sumassur)
					{
						/*
						 * Modified by Ameen on 10-07-2017 for ZBILQC-1731204
						 * throw new Exception("Sum Assured should be less than Principal Sumassured");*/
						throw new Exception(saErrmsg +" should be less than Principal Sumassured");
					}
				}
				/*end*/
				
				/*added by raja on 03-04-2017 for no of live validation*/
				if(dataList_PT_IL_POL_FUNERAL_MEMB_DTLS.size()>0)
				{
				if((PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA()==0 || !(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA()==Current)))
				{
					Double threshold_limit= PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_LC_THRESHOLD_LMT();
					
					Double setup_sumassured =0.0;
					/*change the query by raja on 09-06-2017 for ZBILQC-1727275*/
					String querySA="SELECT nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? AND PMEM_PLAN_CODE=?";
					
									
					resultSetSA = handler.executeSelectStatement(querySA, CommonUtils.getConnection(),
							/*change the query by raja on 09-06-2017 for ZBILQC-1727275*/
							new Object[] { PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});
					if (resultSetSA.next()) {
						setup_sumassured = resultSetSA.getDouble(1);
						
					} 
								
					
					/*Added by Janani on 16.01.2018 for  ZBLIFE-1471888*/
					
					if(plan_type !=null && plan_type.equalsIgnoreCase("H"))
					{
					
						/*End*/
						
					if(setup_sumassured!=0 && threshold_limit!=0)
					{
						if(threshold_limit>=setup_sumassured)
						{
							
							/*added by raja on 23-05-2017 for ZBILQC-1727275*/
							if(Current>0)
							{
							throw new Exception("Threshold limit is already exceeds for the Member   "+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE() );
						
							}
							/*end*/
						}
						else if((Current+threshold_limit)>setup_sumassured)
						{
							double remaining_sumassured=setup_sumassured-threshold_limit;
							/*
							 * Modified by Ameen on 10-07-2017 for ZBILQC-1731204
							 * throw new Exception("Sum Assured can be less than or equal to   " + remaining_sumassured + "  for the customer "+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE());*/
							throw new Exception(saErrmsg +" can be less than or equal to   " + remaining_sumassured + "  for the customer "+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE());
						}
					}
					}
					
					/*Added by Janani on 16.01.2018 for  ZBLIFE-1471888*/
					else
					{
						
						/*Added by Janani on 19.01.2018 for ZBLIFE-1471887*/
						System.out.println("getPOL_END_CODE  "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
						if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()==null
								|| compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("ADDDEP")
								|| compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("INCSA"))
						{
						
							/*End of ZBLIFE-1471887*/
							
						 String UI_TEMP_MEMB_THRES_LMT_TIED = null;
						
						 String qUERYMEMB_THRES_LMT_TIED=" select  p9ilpk_f_policy.F_FUN_MEMB_THRES_LMT_TIED(?,?,?,?) FUN_MEMB_THRES_LMT_TIED  from dual " ;
							
						 System.out.println("getPOL_CUST_CODE      "+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE());
						 System.out.println("Current      "+Current);
						 System.out.println("getPOL_SYS_ID      "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
						 
					/*	 resultSetSA = handler.executeSelectStatement(qUERYMEMB_THRES_LMT_TIED, CommonUtils.getConnection(),
									new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_CUST_CODE(),
								Current,
								"L",compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});*/
							resultSetSA = handler.executeSelectStatement(qUERYMEMB_THRES_LMT_TIED, CommonUtils.getConnection(),
									new Object[] {PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE(),
								Current,
								"L",compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
						 
						if (resultSetSA.next()) {
							UI_TEMP_MEMB_THRES_LMT_TIED = resultSetSA.getString("FUN_MEMB_THRES_LMT_TIED");
							
							if(!UI_TEMP_MEMB_THRES_LMT_TIED.equalsIgnoreCase("0"))
							{
								throw new Exception(UI_TEMP_MEMB_THRES_LMT_TIED);
							}
							
							
						} 
						
						
					}
						
					}
					
					/*End of ZBLIFE-1471888*/
				}
				}
				else
				{
					Double threshold_limit= PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_LC_THRESHOLD_LMT();
					
					Double setup_sumassured =0.0;
					
					 String UI_TEMP_MEMB_THRES_LMT_TIED = null;
					
					/*  Newly added By Dhinesh on 28-8-2017 for ssp call id  */
					
					String U_PLAN_TYPE_QUERY =" SELECT PLAN_TYPE FROM PT_IL_POLICY, PM_IL_PLAN WHERE PLAN_CODE = POL_PLAN_CODE  AND POL_SYS_ID = ? ";
					 
					String U_PLAN_TYPE = null;
					resultSetSA = handler.executeSelectStatement(U_PLAN_TYPE_QUERY, CommonUtils.getConnection(),
							new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
					if (resultSetSA.next()) {
						U_PLAN_TYPE = resultSetSA.getString("PLAN_TYPE");
						
					}
					/*Added extra condition by ganesh on 18-01-2018 for 207R morecover funeral */
					if("L".equalsIgnoreCase(U_PLAN_TYPE) || checkFuneralCoverYN())
					{
					
						/*Modified by Janani on 16.01.2018 for  ZBLIFE-1471888*/
						
						/* String qUERYMEMB_THRES_LMT_TIED=" select  p9ilpk_f_policy.F_FUN_MEMB_THRES_LMT_TIED(?,?,?) FUN_MEMB_THRES_LMT_TIED  from dual " ;
					
					resultSetSA = handler.executeSelectStatement(qUERYMEMB_THRES_LMT_TIED, CommonUtils.getConnection(),
							new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_CUST_CODE(),
						Current,
						"L"});*/

						/*Added by Janani on 19.01.2018 for ZBLIFE-1471887*/
											
						System.out.println("getPOL_END_CODE in else     "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
						if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()==null
								|| compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("ADDDEP")
								|| compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("INCSA"))
						{
							
							/*End of ZBLIFE-1471887*/
						
						 String qUERYMEMB_THRES_LMT_TIED=" select  p9ilpk_f_policy.F_FUN_MEMB_THRES_LMT_TIED(?,?,?,?) FUN_MEMB_THRES_LMT_TIED  from dual " ;
						 
						 System.out.println("getPOL_CUST_CODE in else     "+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE());
						 System.out.println("Current  in else    "+Current);
						 System.out.println("getPOL_SYS_ID  in else    "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
						
							resultSetSA = handler.executeSelectStatement(qUERYMEMB_THRES_LMT_TIED, CommonUtils.getConnection(),
									new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_CUST_CODE(),
								Current,
								"L",compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
						
							/*End*/
						
						if (resultSetSA.next()) {
						UI_TEMP_MEMB_THRES_LMT_TIED = resultSetSA.getString("FUN_MEMB_THRES_LMT_TIED");
						
						if(!UI_TEMP_MEMB_THRES_LMT_TIED.equalsIgnoreCase("0"))
						{
							throw new Exception(UI_TEMP_MEMB_THRES_LMT_TIED);
						}
						
						
					} 
					}	
					}
					/* End of  ZBLIFE-1471888*/
					
					/*Added by Janani on 16.01.2018 for  ZBLIFE-1471888*/
					
					if(plan_type !=null && plan_type.equalsIgnoreCase("H"))
					{
					
					/*End of ZBLIFE-1471888*/
						
					/*change the query by raja on 09-06-2017 for ZBILQC-1727275*/
				String querySA="SELECT nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE = ?  AND PMEM_PLAN_CODE=?";
					
					resultSetSA = handler.executeSelectStatement(querySA, CommonUtils.getConnection(),
							/*change the query by raja on 09-06-2017 for ZBILQC-1727275*/
							new Object[] { PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});
					if (resultSetSA.next()) {
						setup_sumassured = resultSetSA.getDouble(1);
						
					} 
					if(setup_sumassured!=0 && threshold_limit!=0)
					{
						if(threshold_limit>=setup_sumassured)
						{
							/*added by raja on 23-05-2017 for ZBILQC-1727275*/
							if(Current>0)
							{
							throw new Exception("Threshold limit is already exceeds for the Member   "+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE() );
							}
							/*end*/
						}
						else if((Current+threshold_limit)>setup_sumassured)
						{
							double remaining_sumassured=setup_sumassured-threshold_limit;
							/*
							 * Modified by Ameen on 10-07-2017 for ZBILQC-1731204
							 * throw new Exception("Sum Assured can be less than or equal to   " + remaining_sumassured + "  for the customer "+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE());*/
							throw new Exception(saErrmsg +" can be less than or equal to   " + remaining_sumassured + "  for the customer "+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE());
						}
					}
	
					
					
				}
				
				}
					
						//validation();
					/*added by gopi for funeral beneficiary on 28/02/2017*/
					String Plan_code=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE();
					Min_Max_value((Double)value,PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE());
					/*end*/
					/*Modified by ganesh on 18-01-2018 for ZBLIFE-1471888 */
					//sum_assured_validation();
					sum_assured_validation((Double)value);
					/*End of ZBLIFE-1471888*/
					/* Newly Added By Dhinesh on 23-05-2018 for sub plan issue */
					double SUB_PLAN_SA_Min = 0.0;
					double SUB_PLAN_SA_MAX = 0.0;
					String PROD_SA_BY_PLAN_BASIS_YN =null;
					SUB_PLAN_SA_Min = Double.parseDouble(CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.SUB_PLAN_SA_Min"),"0"));
					SUB_PLAN_SA_MAX =  Double.parseDouble(CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.SUB_PLAN_SA_MAX"),"0"));
					PROD_SA_BY_PLAN_BASIS_YN = CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.PROD_SA_BY_PLAN_BASIS_YN"),"N");
					
					double currentValue =(Double)value; 

					if("Y".equalsIgnoreCase(PROD_SA_BY_PLAN_BASIS_YN))
					{
						if( SUB_PLAN_SA_Min < currentValue) 
						{
							if(SUB_PLAN_SA_MAX >= currentValue)
							{
								PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_SA(currentValue);	
							}else
							{
								throw new Exception("SubPlan Dependent SA should not exceed maximum SA in tariff master");							
							}

						}else
						{
							throw new Exception("SubPlan Dependent SA should not be lesser than minimum SA in tariff master");		
						}
					}	//end
					else
					{
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_SA((Double)value);	
					}

					/*end*/
				
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("current", e.getMessage());
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		
		public void validatePFMD_CURR_ASSR(FacesContext context,
				UIComponent component, Object value){

			try {
				getErrorMap().clear();
				getWarningMap().clear();
				
				if (value.toString().equalsIgnoreCase("true"))
				{
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_CURR_ASSR_UI(true);
				}
				else
				{
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_CURR_ASSR_UI(false);
				}
				if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.isPFMD_CURR_ASSR_UI())
				{
				String assuredvalue=null;
				String Query="select POAD_ASSR_CODE from PT_IL_POL_ASSURED_DTLS where poad_pol_sys_id=?";
				ResultSet rs=new CRUDHandler().executeSelectStatement(Query, 
						CommonUtils.getConnection(), new Object[]{CommonUtils.getGlobalVariable("GLOBAL.POL_SYS_ID")});
				while(rs.next())
				{
					assuredvalue=rs.getString("POAD_ASSR_CODE");
				}
				if(!(assuredvalue.equalsIgnoreCase(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE())))
				{
					throw new Exception("Customer does not a assured");
				}
				}
				
					
			} catch (Exception e) {
				getErrorMap().put("current", e.getMessage());
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		/*added by gopi for funeral beneficiary on 28/02/2017*/
		/*public void Min_Max_value(String plan_code, String relation_type) throws Exception {
			String query = "SELECT PMEM_MIN_SA,PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_PLAN_CODE =? AND PMEM_RELATION_TYPE =? ";
			CRUDHandler handler = new CRUDHandler();
			Double PMEM_MIN_SA = null;
			Double PMEM_MAX_SA = null;
			Connection connection = null;
			ResultSet resultSet = null;
			try {
				connection = CommonUtils.getConnection();

				resultSet = handler.executeSelectStatement(query, connection,
						new Object[] { plan_code,relation_type});
				while (resultSet.next()) {
					PMEM_MIN_SA = resultSet.getDouble("PMEM_MIN_SA");
					PMEM_MAX_SA = resultSet.getDouble("PMEM_MAX_SA");
				} 
				Double mem_sumassured=PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA();
				if(PMEM_MIN_SA!=null && PMEM_MAX_SA!=null)
				{
				if(mem_sumassured<PMEM_MIN_SA)
				{
					throw new Exception("Sum Assured should be with in range of  " +PMEM_MIN_SA+   "  and "   +PMEM_MAX_SA);
				}else if(mem_sumassured>PMEM_MAX_SA){
					throw new Exception("Sum Assured should be with in range of  " +PMEM_MIN_SA+   "  and "   +PMEM_MAX_SA);
				}
				}
			} catch (Exception exception) {
				exception.printStackTrace();
				throw exception;
			}
		
		}*/
		/*end*/		
		
		/*added by gopi for funeral beneficiary on 28/02/2017*/
		/*public void Min_Max_value(String plan_code, String relation_type) throws Exception {
			String query ="SELECT nvl(PMEM_MIN_SA,0) PMEM_MIN_SA,nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_PLAN_CODE =? AND PMEM_RELATION_TYPE =? ";
			CRUDHandler handler = new CRUDHandler();
			Double PMEM_MIN_SA =0.0;
			Double PMEM_MAX_SA =0.0;
			Connection connection = null;
			ResultSet resultSet = null;
			try {
				connection = CommonUtils.getConnection();

				resultSet = handler.executeSelectStatement(query, connection,
						new Object[] { plan_code,relation_type});
				if (resultSet.next()) {
					PMEM_MIN_SA = resultSet.getDouble("PMEM_MIN_SA");
					PMEM_MAX_SA = resultSet.getDouble("PMEM_MAX_SA");
				} 
				Double mem_sumassured=PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA();
				
				if(mem_sumassured!=0)
				{
				if(PMEM_MIN_SA!=null && PMEM_MAX_SA!=null)
				{
				if(mem_sumassured<PMEM_MIN_SA)
				{
					throw new Exception("Sum Assured should be with in range of  " +PMEM_MIN_SA+   "  and "   +PMEM_MAX_SA);
				}else if(mem_sumassured>PMEM_MAX_SA){
					throw new Exception("Sum Assured should be with in range of  " +PMEM_MIN_SA+   "  and "   +PMEM_MAX_SA);
				}
				}
				}
			} catch (Exception exception) {
				exception.printStackTrace();
				throw exception;
			}
		
		}*/
		/*end*/	
		
		/*added by raja on 04-03-2017 for funeral benefit fsd*/
		
		public void Min_Max_value(double sumAssured, String relation_type) throws Exception {
			/*
			 * 
			 * COMMENTED BY SANKARA NARAYANAN FOR hOSPITAL cASH PLAN ON 25/04/2017
			 * String query ="SELECT nvl(PMEM_MIN_SA,0) PMEM_MIN_SA,nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? ";*/
			/*cHANGED BY SANKARA NARAYANAN ON 25/04/2017 FOR HOSPITAL CASH PLAN*/
			
			//by saritha on 05-01-2018
			/*String query ="SELECT nvl(PMEM_MIN_SA,0) PMEM_MIN_SA,nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? AND PMEM_PLAN_CODE=?";*/
			
			/*String depsumAssQuery ="SELECT NVL(PMEM_MIN_SA, 0) PMEM_MIN_SA, NVL(PMEM_MAX_SA, 0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB, PM_CODES, PCOM_APP_PARAMETER"
					+ " WHERE PMEM_DEP_TYPE = PC_CODE AND PC_TYPE = 'IL_DEP_TYP' AND PARA_CODE = 'IL_RIDER_TY' AND PMEM_PLAN_CODE = PARA_VALUE "
					+ "AND PMEM_RELATION_TYPE = ? AND PARA_SUB_CODE = (SELECT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER, PM_IL_COVER "
					+ "WHERE POAC_COVER_CODE = COVER_CODE AND COVER_TYPE <> 'B' AND COVER_FUNERAL_CVR_YN = 'Y' AND POAC_POL_SYS_ID = ?) "
					+ "AND ? BETWEEN NVL(PMEM_MIN_AGE_ENTRY, 0) AND NVL(PMEM_MAX_AGE_ENTRY, 0)"; */
			
			
			CRUDHandler handler = new CRUDHandler();
			Double PMEM_MIN_SA =0.0;
			Double PMEM_MAX_SA =0.0;
			Connection connection = null;
			ResultSet resultSet = null;
			String dependantQuery = "";
			Object planTypeLorH[] = null;
			try {
				connection = CommonUtils.getConnection();

				if(compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPlanTypeLorH()!=null && compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPlanTypeLorH().equalsIgnoreCase("X")){
					//String tempQuery = (CommonUtils.nvl(compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPlanTypeLorH(),"").equalsIgnoreCase("X")?query:depsumAssQuery);

					dependantQuery ="SELECT nvl(PMEM_MIN_SA,0) PMEM_MIN_SA,nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? AND PMEM_PLAN_CODE=?";

					planTypeLorH = new Object[] { relation_type,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()};
				}
				else{

					dependantQuery ="SELECT NVL(PMEM_MIN_SA, 0) PMEM_MIN_SA, NVL(PMEM_MAX_SA, 0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB, PM_CODES, PCOM_APP_PARAMETER"
							+ " WHERE PMEM_DEP_TYPE = PC_CODE AND PC_TYPE = 'IL_DEP_TYP' AND PARA_CODE = 'IL_RIDER_TY' AND PMEM_PLAN_CODE = PARA_VALUE "
							+ "AND PMEM_RELATION_TYPE = ? AND PARA_SUB_CODE = (SELECT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER, PM_IL_COVER "
							+ "WHERE POAC_COVER_CODE = COVER_CODE AND COVER_TYPE <> 'B' AND COVER_FUNERAL_CVR_YN = 'Y' AND POAC_POL_SYS_ID = ?) "
							+ "AND ? BETWEEN NVL(PMEM_MIN_AGE_ENTRY, 0) AND NVL(PMEM_MAX_AGE_ENTRY, 0)"; 

					planTypeLorH = new Object[] { relation_type,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
							compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_MEMB_AGE()};
				}

				resultSet = handler.executeSelectStatement(dependantQuery, connection,planTypeLorH);


				if (resultSet.next()) {
					PMEM_MIN_SA = resultSet.getDouble("PMEM_MIN_SA");
					PMEM_MAX_SA = resultSet.getDouble("PMEM_MAX_SA");
				} 

				Double mem_sumassured=sumAssured;
				
			
					
				if(mem_sumassured!=0)
				{
				if(PMEM_MIN_SA!=null && PMEM_MAX_SA!=null)
				{
					String relDesc=null;
				if(mem_sumassured<PMEM_MIN_SA)
				{
					
					/*added by raja on 23-05-2017 for ZBILQC-1727275*/
					if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()==null
							|| !compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("DELDEP"))
					{
						
						/*end*/
					
					
					String queryreldesc="SELECT LIV_CODE, LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE "
							+ "LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC' AND "
							+ "LI_BLOCK_NAME = 'PT_IL_POL_FUNERAL_MEMB_DTLS' AND LI_ITEM_NAME= 'PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_RELATION_TYPE' "
							+ "AND liv_code=?";	
				
					ResultSet resultSetRelDesc=new CRUDHandler().executeSelectStatement(queryreldesc, connection, 
							new Object[]{relation_type});
					
					while(resultSetRelDesc.next())
					{
						relDesc= resultSetRelDesc.getString("LIV_CODE_DESC");
					}
					
					throw new Exception("Total Sum Assured should be Start from " +PMEM_MIN_SA+ "  for  " +relDesc);
					/*added by raja on 23-05-2017 for ZBILQC-1727275*/
					}
					/*end*/
				}
				
				
				else if(mem_sumassured>PMEM_MAX_SA){
					
					double remaining_Sum_Assured=PMEM_MAX_SA-mem_sumassured;
					String queryreldesc="SELECT LIV_CODE, LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE "
							+ "LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC' AND "
							+ "LI_BLOCK_NAME = 'PT_IL_POL_FUNERAL_MEMB_DTLS' AND LI_ITEM_NAME= 'PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_RELATION_TYPE' "
							+ "AND liv_code=?";	
				
					ResultSet resultSetRelDesc=new CRUDHandler().executeSelectStatement(queryreldesc, connection, 
							new Object[]{relation_type});
					
					while(resultSetRelDesc.next())
					{
						relDesc= resultSetRelDesc.getString("LIV_CODE_DESC");
					}
					/*
					 * Modified by Ameen on 10-07-2017 for ZBILQC-1731204
					 * throw new Exception("Sum assured can be less than or equal to  " +PMEM_MAX_SA+ "  for "  +relDesc);*/
					throw new Exception(saErrmsg +" can be less than or equal to  " +PMEM_MAX_SA+ "  for "  +relDesc);
				}
				}
				}
				/*added by raja on 23-05-2017 for ZBILQC-1727275*/
				
				new PKG_PILT002_APAC().L_CHECK_MULTIPLE_SA("B", CommonUtils
						.getProcedureValue(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE(), CommonUtils
								.getProcedureValue(sumAssured), CommonUtils
								.getProcedureValue(0.0));
				/*end*/
			} catch (Exception exception) {
				exception.printStackTrace();
				throw exception;
			}
		}
		
		
		public void no_of_live(int count, String relation_type) throws Exception {
			
			
			/*changed by raja on 23-05-2017 for ZBILQC-1727275*/
			/*String query ="SELECT PMEM_NO_OF_LIFE FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE=? ";*/
			String query ="SELECT PMEM_NO_OF_LIFE FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE=? AND PMEM_PLAN_CODE=?";
			/*end*/
			CRUDHandler handler = new CRUDHandler();
			int live=0;
			Connection connection = null;
			ResultSet resultSet = null;
			try {
				connection = CommonUtils.getConnection();

				/*changed by raja on 23-05-2017 for ZBILQC-1727275*/
				/*resultSet = handler.executeSelectStatement(query, connection,
						new Object[] { relation_type});*/
				
				resultSet = handler.executeSelectStatement(query, connection,
						new Object[] { relation_type,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});
				/*end*/
				if (resultSet.next()) {
					live = resultSet.getInt("PMEM_NO_OF_LIFE");
					
				} 
				
				
				if(live!=0)
				{
			 
				if(count>live)
				{
					String relDesc=null;
					String queryreldesc="SELECT LIV_CODE, LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE "
							+ "LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC' AND "
							+ "LI_BLOCK_NAME = 'PT_IL_POL_FUNERAL_MEMB_DTLS' AND LI_ITEM_NAME= 'PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_RELATION_TYPE' "
							+ "AND liv_code=?";	
				
					ResultSet resultSetRelDesc=new CRUDHandler().executeSelectStatement(queryreldesc, connection, 
							new Object[]{relation_type});
					
					while(resultSetRelDesc.next())
					{
						relDesc= resultSetRelDesc.getString("LIV_CODE_DESC");
					}
					
					throw new Exception("Numer of allowed " +relDesc+" dependant exceeds the limit");
				}
				}
				
			} catch (Exception exception) {
				exception.printStackTrace();
				throw exception;
			}
		}
		
		
		
		
		
			/*end*/
		
		
	
		private HtmlOutputLabel COMP_UI_M_NATIONAL_ID_LABEL;
		private HtmlInputText COMP_UI_M_NATIONAL_ID;


		private HtmlOutputLabel COMP_PFMD_AGE_PROOF_FLAG_LABEL;
		private HtmlSelectOneMenu COMP_PFMD_AGE_PROOF_FLAG;

		private HtmlOutputLabel COMP_PFMD_AGE_PROOF_OTHERS_LABEL;
		private HtmlInputText COMP_PFMD_AGE_PROOF_OTHERS;

		private HtmlOutputLabel COMP_PFMD_LC_THRESHOLD_LMT_LABEL;
		private HtmlInputText COMP_PFMD_LC_THRESHOLD_LMT;

		private HtmlOutputLabel COMP_PFMD_HIV_TEST_YN_LABEL;
		public HtmlSelectOneMenu getCOMP_PFMD_HIV_TEST_YN() {
			return COMP_PFMD_HIV_TEST_YN;
		}

		private HtmlSelectOneMenu COMP_PFMD_HIV_TEST_YN;
		
		private List<SelectItem> listPOAD_HIV_TEST_YN = new ArrayList<SelectItem>();
		
		private List<SelectItem> listPFMD_AGE_PROOF_FLAG = new ArrayList<SelectItem>();
		

		

		public List<SelectItem> getListPOAD_HIV_TEST_YN() {
			return listPOAD_HIV_TEST_YN;
		}
		public void setListPOAD_HIV_TEST_YN(List<SelectItem> listPOAD_HIV_TEST_YN) {
			this.listPOAD_HIV_TEST_YN = listPOAD_HIV_TEST_YN;
		}
		public List<SelectItem> getListPFMD_AGE_PROOF_FLAG() {
			return listPFMD_AGE_PROOF_FLAG;
		}
		public void setListPFMD_AGE_PROOF_FLAG(List<SelectItem> listPFMD_AGE_PROOF_FLAG) {
			this.listPFMD_AGE_PROOF_FLAG = listPFMD_AGE_PROOF_FLAG;
		}
		public HtmlOutputLabel getCOMP_UI_M_NATIONAL_ID_LABEL() {
			return COMP_UI_M_NATIONAL_ID_LABEL;
		}
		public void setCOMP_UI_M_NATIONAL_ID_LABEL(
				HtmlOutputLabel cOMP_UI_M_NATIONAL_ID_LABEL) {
			COMP_UI_M_NATIONAL_ID_LABEL = cOMP_UI_M_NATIONAL_ID_LABEL;
		}
		public HtmlInputText getCOMP_UI_M_NATIONAL_ID() {
			return COMP_UI_M_NATIONAL_ID;
		}
		public void setCOMP_UI_M_NATIONAL_ID(HtmlInputText cOMP_UI_M_NATIONAL_ID) {
			COMP_UI_M_NATIONAL_ID = cOMP_UI_M_NATIONAL_ID;
		}
		public HtmlOutputLabel getCOMP_PFMD_AGE_PROOF_FLAG_LABEL() {
			return COMP_PFMD_AGE_PROOF_FLAG_LABEL;
		}
		public void setCOMP_PFMD_AGE_PROOF_FLAG_LABEL(
				HtmlOutputLabel cOMP_PFMD_AGE_PROOF_FLAG_LABEL) {
			COMP_PFMD_AGE_PROOF_FLAG_LABEL = cOMP_PFMD_AGE_PROOF_FLAG_LABEL;
		}
		
		public HtmlSelectOneMenu getCOMP_PFMD_AGE_PROOF_FLAG() {
			return COMP_PFMD_AGE_PROOF_FLAG;
		}
		public void setCOMP_PFMD_AGE_PROOF_FLAG(
				HtmlSelectOneMenu cOMP_PFMD_AGE_PROOF_FLAG) {
			COMP_PFMD_AGE_PROOF_FLAG = cOMP_PFMD_AGE_PROOF_FLAG;
		}
		public void setCOMP_PFMD_HIV_TEST_YN(HtmlSelectOneMenu cOMP_PFMD_HIV_TEST_YN) {
			COMP_PFMD_HIV_TEST_YN = cOMP_PFMD_HIV_TEST_YN;
		}
		public HtmlOutputLabel getCOMP_PFMD_AGE_PROOF_OTHERS_LABEL() {
			return COMP_PFMD_AGE_PROOF_OTHERS_LABEL;
		}
		public void setCOMP_PFMD_AGE_PROOF_OTHERS_LABEL(
				HtmlOutputLabel cOMP_PFMD_AGE_PROOF_OTHERS_LABEL) {
			COMP_PFMD_AGE_PROOF_OTHERS_LABEL = cOMP_PFMD_AGE_PROOF_OTHERS_LABEL;
		}
		public HtmlInputText getCOMP_PFMD_AGE_PROOF_OTHERS() {
			return COMP_PFMD_AGE_PROOF_OTHERS;
		}
		public void setCOMP_PFMD_AGE_PROOF_OTHERS(
				HtmlInputText cOMP_PFMD_AGE_PROOF_OTHERS) {
			COMP_PFMD_AGE_PROOF_OTHERS = cOMP_PFMD_AGE_PROOF_OTHERS;
		}
		public HtmlOutputLabel getCOMP_PFMD_LC_THRESHOLD_LMT_LABEL() {
			return COMP_PFMD_LC_THRESHOLD_LMT_LABEL;
		}
		public void setCOMP_PFMD_LC_THRESHOLD_LMT_LABEL(
				HtmlOutputLabel cOMP_PFMD_LC_THRESHOLD_LMT_LABEL) {
			COMP_PFMD_LC_THRESHOLD_LMT_LABEL = cOMP_PFMD_LC_THRESHOLD_LMT_LABEL;
		}
		public HtmlInputText getCOMP_PFMD_LC_THRESHOLD_LMT() {
			return COMP_PFMD_LC_THRESHOLD_LMT;
		}
		public void setCOMP_PFMD_LC_THRESHOLD_LMT(
				HtmlInputText cOMP_PFMD_LC_THRESHOLD_LMT) {
			COMP_PFMD_LC_THRESHOLD_LMT = cOMP_PFMD_LC_THRESHOLD_LMT;
		}
		public HtmlOutputLabel getCOMP_PFMD_HIV_TEST_YN_LABEL() {
			return COMP_PFMD_HIV_TEST_YN_LABEL;
		}
		public void setCOMP_PFMD_HIV_TEST_YN_LABEL(
				HtmlOutputLabel cOMP_PFMD_HIV_TEST_YN_LABEL) {
			COMP_PFMD_HIV_TEST_YN_LABEL = cOMP_PFMD_HIV_TEST_YN_LABEL;
		}
		
		
		public void PFMD_AGE_PROOF_FLAG_WHEN_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value){

			try {
				getErrorMap().clear();
				getWarningMap().clear();
				
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_AGE_PROOF_FLAG(value.toString());
				helper.PFMD_AGE_PROOF_FLAG_WHEN_VALIDATE_ITEM(this,compositeAction);
				/*if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_AGE_PROOF_FLAG().equalsIgnoreCase("0"))
				{
					COMP_PFMD_AGE_PROOF_OTHERS.setRequired(true);
				}
				else
				{
					COMP_PFMD_AGE_PROOF_OTHERS.setRequired(false);
				}*/
			} catch (Exception e) {
				//getErrorMap().put("current", e.getMessage());
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		
		public void PFMD_AGE_PROOF_OTHERS_VALIDATOR(FacesContext context,
				UIComponent component, Object value){

			try {
				getErrorMap().clear();
				getWarningMap().clear();
				
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_AGE_PROOF_OTHERS(value.toString());
				
				
			} catch (Exception e) {
				//getErrorMap().put("current", e.getMessage());
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		
		public void validatePFMD_LC_THRESHOLD_LMT(FacesContext context,
				UIComponent component, Object value){

			try {
				getErrorMap().clear();
				getWarningMap().clear();
				
				
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_LC_THRESHOLD_LMT((Double)value);
				
				
				
			} catch (Exception e) {
				//getErrorMap().put("current", e.getMessage());
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		
		public void PFMD_HIV_TEST_YN_WHEN_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value){

			try {
				getErrorMap().clear();
				getWarningMap().clear();
				
				
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_HIV_TEST_YN(value.toString());
				
				
				
			} catch (Exception e) {
				//getErrorMap().put("current", e.getMessage());
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		
		public void cust_validation(double current_sum_assured,String relation_type,String CUST_CODE) throws Exception {
			String query ="SELECT SUM(PFMD_SA) PFMD_SA FROM PT_IL_POL_FUNERAL_MEMB_DTLS WHERE PFMD_CUST_CODE = ?";
			CRUDHandler handler = new CRUDHandler();
			Double threshold_sumasured =0.0;
			Double Sum_Assured =0.0;
			
			/*changed by raja on 23-05-2017 for ZBILQC-1727275*/
			/*String querySA="SELECT nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =?";*/
			String querySA="SELECT nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? AND PMEM_PLAN_CODE=?";
			/*end*/
			ResultSet resultSet = null;
			ResultSet resultSetSA = null;
			Double remaining_sumassured =0.0;
			Double cumulative_sumassured =0.0;
			try {
					
				/*added by raja on 23-05-2017 for ZBILQC-1727275*/
				/*resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection(),
						new Object[] { CUST_CODE});*/
				resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection(),
						new Object[] { CUST_CODE,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});
				/*end*/
				if (resultSet.next()) {
					threshold_sumasured = resultSet.getDouble("PFMD_SA");
					
				} 
				
				resultSetSA = handler.executeSelectStatement(querySA, CommonUtils.getConnection(),
						new Object[] { relation_type});
				if (resultSetSA.next()) {
					Sum_Assured = resultSetSA.getDouble(1);
					
				} 
				
			
				if(threshold_sumasured>=Sum_Assured)
				{
					
					throw new Exception("Threshold Limit for  " + CUST_CODE + " customer  exceeded the limit");
				
				}
				else
				{
					cumulative_sumassured=current_sum_assured+threshold_sumasured;
					if(cumulative_sumassured>Sum_Assured)
					{
						remaining_sumassured=Sum_Assured-threshold_sumasured;
						/*
						 *Modified by Ameen on 10-07-2017 for ZBILQC-1731204 
						 * throw new Exception("Sum Assured can be less than or equal to   " + remaining_sumassured + "  for the customer "+CUST_CODE);*/
						throw new Exception(saErrmsg +" can be less than or equal to   " + remaining_sumassured + "  for the customer "+CUST_CODE);
					}
				}
				
			
			} catch (Exception exception) {
				exception.printStackTrace();
				throw exception;
			}
		}
		
		public double threshole_sumassured() throws Exception
		{
			
			String query ="SELECT SUM(PFMD_SA) PFMD_SA FROM PT_IL_POL_FUNERAL_MEMB_DTLS WHERE PFMD_CUST_CODE = ?";
			CRUDHandler handler = new CRUDHandler();
			Double threshold_sumasured =0.0;
			ResultSet resultSet = null;
			try
			{
			resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection(),
					new Object[] { PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE()});
			if (resultSet.next()) {
				threshold_sumasured = resultSet.getDouble("PFMD_SA");
				
			} 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return threshold_sumasured;
		}
		
		public double setup_sumassured() throws Exception
		{
			Double setup_sumassured =0.0;
			
			/*added by raja on 23-05-2017 for ZBILQC-1727275*/
			
			/*String querySA="SELECT nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =?";*/
			String querySA="SELECT nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? AND PMEM_PLAN_CODE=?";
			/*end*/
			
			ResultSet resultSetSA = null;
			CRUDHandler handler = new CRUDHandler();
			try
			{
				
				/*added by raja on 23-05-2017 for ZBILQC-1727275*/
				
			/*resultSetSA = handler.executeSelectStatement(querySA, CommonUtils.getConnection(),
					new Object[] { PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE()});*/
				resultSetSA = handler.executeSelectStatement(querySA, CommonUtils.getConnection(),
						new Object[] { PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});
				/*end*/
			if (resultSetSA.next()) {
				setup_sumassured = resultSetSA.getDouble(1);
				
			} 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return setup_sumassured;
		}
		
		
		/*public void cust_validation(double current_sum_assured,String relation_type,String CUST_CODE) throws Exception {
		String query ="SELECT SUM(PFMD_SA) PFMD_SA FROM PT_IL_POL_FUNERAL_MEMB_DTLS WHERE PFMD_CUST_CODE = ?";
		CRUDHandler handler = new CRUDHandler();
		Double threshold_sumasured =0.0;
		Double Sum_Assured =0.0;
		String querySA="SELECT nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =?";
		
		ResultSet resultSet_threshold = null;
		ResultSet resultSetSA = null;
		Double remaining_sumassured =0.0;
		Double cumulative_sumassured =0.0;
		try {
				
			
			resultSet_threshold = handler.executeSelectStatement(query, CommonUtils.getConnection(),
					new Object[] { CUST_CODE});
			if (resultSet_threshold.next()) {
				threshold_sumasured = resultSet_threshold.getDouble("PFMD_SA");
				
			} 
			
			resultSetSA = handler.executeSelectStatement(querySA, CommonUtils.getConnection(),
					new Object[] { relation_type});
			if (resultSetSA.next()) {
				Sum_Assured = resultSetSA.getDouble(1);
				
			} 
			
		
			if(threshold_sumasured>=Sum_Assured)
			{
				
				throw new Exception("Threshold Limit for  " + CUST_CODE + " customer  exceeded the limit");
			
			}
			else
			{
				cumulative_sumassured=current_sum_assured+threshold_sumasured;
				if(cumulative_sumassured>Sum_Assured)
				{
					remaining_sumassured=Sum_Assured-threshold_sumasured;
					throw new Exception("Sum Assured can be less than or equal to   " + remaining_sumassured + "  for the customer "+CUST_CODE);
				}
			}
			
		
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
	}*/
	
	public double threshole_sumassured(String cust_code) throws Exception
	{
		String query ="SELECT SUM(PFMD_SA) PFMD_SA FROM PT_IL_POL_FUNERAL_MEMB_DTLS WHERE PFMD_CUST_CODE = ?";
		CRUDHandler handler = new CRUDHandler();
		Double threshold_sumasured =0.0;
		ResultSet resultSet = null;
		try
		{
		resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection(),
				new Object[] { cust_code});
		if (resultSet.next()) {
			threshold_sumasured = resultSet.getDouble("PFMD_SA");
			
		} 
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return threshold_sumasured;
	}
	
	public double setup_sumassured(String relation_type) throws Exception
	{
		Double setup_sumassured =0.0;
		/*added by raja on 23-05-2017 for ZBILQC-1727275*/
		/*String querySA="SELECT nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =?";*/
		String querySA="SELECT nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? AND PMEM_PLAN_CODE=?";
		/*end*/
		ResultSet resultSetSA = null;
		CRUDHandler handler = new CRUDHandler();
		try
		{
			/*added by raja on 23-05-2017 for ZBILQC-1727275*/
		/*resultSetSA = handler.executeSelectStatement(querySA, CommonUtils.getConnection(),
				new Object[] { relation_type});*/
			resultSetSA = handler.executeSelectStatement(querySA, CommonUtils.getConnection(),
					new Object[] { relation_type,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});
			/*end*/
		if (resultSetSA.next()) {
			setup_sumassured = resultSetSA.getDouble(1);
			
		} 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return setup_sumassured;
	}
	
	
	
	public void validation() throws Exception
	{
		double sumAssued=0.0;
		double thres_SA=0.0;
		double cumulative_SA=0.0;
		
			try {
									
				/*changed by raja for funeral benifit fsd*/
				/*if(getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS().size()>0)
				{
									
				for(PT_IL_POL_FUNERAL_MEMB_DTLS  bean: this.getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS()) {
					
						
				sumAssued=bean.getPFMD_SA();
				thres_SA=threshole_sumassured(bean.getPFMD_CUST_CODE());
				
				double setup_SA=setup_sumassured(bean.getPFMD_RELATION_TYPE());
				
				if(thres_SA>=setup_SA)
				{
					throw new Exception("Threshold Limit for  " + bean.getPFMD_CUST_CODE() + " customer  exceeded the limit");
				}
				else
				{
					cumulative_SA=sumAssued+thres_SA;
					if(cumulative_SA>setup_SA)
					{
						double remaining_sumassured=setup_SA-thres_SA;
						throw new Exception("Sum Assured can be less than or equal to   " + remaining_sumassured + "  for the customer "+bean.getPFMD_CUST_CODE());
					}
					else
					{
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_LC_THRESHOLD_LMT(cumulative_SA);
					}
					
					}
					
			
				}
				}
				else
				{*/
					sumAssued=PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA();
					thres_SA=threshole_sumassured(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE());
					
					double setup_SA=setup_sumassured(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE());
					
					if(thres_SA>setup_SA)
					{
						throw new Exception("Threshold Limit for  " + PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE() + " customer  exceeded the limit");
					}
					else
					{
						cumulative_SA=sumAssued+thres_SA;
						if(cumulative_SA>setup_SA)
						{
							double remaining_sumassured=setup_SA-thres_SA;
							/*
							 * Modified by Ameen on 10-07-2017 for ZBILQC-1731204
							 * throw new Exception("Sum Assured can be less than or equal to   " + remaining_sumassured + "  for the customer "+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE());*/
							throw new Exception(saErrmsg +" can be less than or equal to   " + remaining_sumassured + "  for the customer "+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE());
						}
						else
						{
							PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_LC_THRESHOLD_LMT(cumulative_SA);
						}
						
						}
						
				
					// }
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	
	}
		
	
	/*added by raja on 03-04-2017 for no of live validation*/
	
	public void no_of_lives() throws Exception
	{
		/*added by raja on 23-05-2017 for ZBILQC-1727275*/
		/*String query ="SELECT PMEM_NO_OF_LIFE FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE=? ";*/
		String query ="SELECT PMEM_NO_OF_LIFE FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE=? AND PMEM_PLAN_CODE=?";
		/*end*/
		String setup_sumassured ="SELECT nvl(PMEM_MIN_SA,0) PMEM_MIN_SA,nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? ";
		CRUDHandler handler = new CRUDHandler();
		int live=0;
		int count=0;
		Connection connection = null;
		ResultSet resultSet = null;
		try
		{
			connection = CommonUtils.getConnection();
			/*added by raja on 23-05-2017 for ZBILQC-1727275*/
			/*resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE()});*/
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});
			
			/*end*/
			
			if (resultSet.next()) {
				live = resultSet.getInt("PMEM_NO_OF_LIFE");
				
			} 
			for(PT_IL_POL_FUNERAL_MEMB_DTLS  bean: dataList_PT_IL_POL_FUNERAL_MEMB_DTLS) 
			{
				if(bean.getROWID()!=null && !(bean.getROWID().equalsIgnoreCase(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getROWID())))
				{
					if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE()))
					{
						count++;
					}
				}
				
			}
			if(count!=0 && (count+1)>live)
			{
				String relDesc=null;
				String queryreldesc="SELECT LIV_CODE, LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE "
						+ "LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC' AND "
						+ "LI_BLOCK_NAME = 'PT_IL_POL_FUNERAL_MEMB_DTLS' AND LI_ITEM_NAME= 'PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_RELATION_TYPE' "
						+ "AND liv_code=?";	
			
				ResultSet resultSetRelDesc=new CRUDHandler().executeSelectStatement(queryreldesc, connection, 
						new Object[]{PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE()});
				
				while(resultSetRelDesc.next())
				{
					relDesc= resultSetRelDesc.getString("LIV_CODE_DESC");
				}
				
				throw new Exception("Numer of allowed " +relDesc+" dependant exceeds the limit");
			}
			
			
		}
		catch(Exception e)
		{
		e.printStackTrace();
		throw e;
		}
	}

	/*Modified by ganesh on 18-01-2018 for ZBLIFE-1471888 */
	//public void sum_assured_validation() throws Exception
	public void sum_assured_validation(Double currValue) throws Exception
	/*End*/
	{
		//added by raja on 23-05-2017 for ZBILQC-1727275
		//String setup_sumassured ="SELECT nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? ";
		
		 // query modified by Ameen on 11-07-2017 for ZBILQC-1731204
		// String setup_sumassured ="SELECT nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? AND PMEM_PLAN_CODE=?";
		//end
		/*Modified by ganesh on 30-jan-2018 207R rider issue */
		String setup_sumassured = "";
		Object masterSAObject[] = null;
		if(compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPlanTypeLorH()!=null && compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPlanTypeLorH().equalsIgnoreCase("X")){
			
			setup_sumassured ="SELECT nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? AND PMEM_PLAN_CODE=? AND PMEM_DEP_TYPE = ?";
			masterSAObject = new Object[]{PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE(),
					   PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_TYPE()};
			
		}else{
			
			setup_sumassured = "SELECT NVL(PMEM_MAX_SA, 0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB, PM_CODES, PCOM_APP_PARAMETER"
					+ " WHERE PMEM_DEP_TYPE = PC_CODE AND PC_TYPE = 'IL_DEP_TYP' AND PARA_CODE = 'IL_RIDER_TY' AND PMEM_PLAN_CODE = PARA_VALUE "
					+ "AND PMEM_RELATION_TYPE = ? AND PARA_SUB_CODE = (SELECT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER, PM_IL_COVER "
					+ "WHERE POAC_COVER_CODE = COVER_CODE AND COVER_TYPE <> 'B' AND COVER_FUNERAL_CVR_YN = 'Y' AND POAC_POL_SYS_ID = ?) "
					+ "AND ? BETWEEN NVL(PMEM_MIN_AGE_ENTRY, 0) AND NVL(PMEM_MAX_AGE_ENTRY, 0)";
			
			masterSAObject = new Object[]{PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
					compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_MEMB_AGE()};
		}
		
			
		/*end*/
		CRUDHandler handler = new CRUDHandler();
		double setup_assuerd=0.0;
		double sum_assuerd=0.0;
		Connection connection = null;
		ResultSet resultSet = null;
		
		/*Added by ganesh on 18-01-2018 for ZBLIFE-1471888 */
		ResultSet rstSumAssured = null;
		
		String sumOfAllSA = "SELECT SUM(PFMD_SA) FROM PT_IL_POL_FUNERAL_MEMB_DTLS WHERE PFMD_POL_SYS_ID = ? AND PFMD_RELATION_TYPE = ? AND PFMD_MEMB_TYPE = ? AND ROWID <> ?";
		/*End of  ZBLIFE-1471888 */
		
		try
		{
			connection = CommonUtils.getConnection();

			//end
			//resultSet = handler.executeSelectStatement(setup_sumassured, connection,
					//new Object[] { PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE()});
			/*Modified by ganesh on 30-jan-2018 207R rider issue */
			/*resultSet = handler.executeSelectStatement(setup_sumassured, connection,
					new Object[] { PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE(),
								   PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_TYPE()});
*/			
			resultSet = handler.executeSelectStatement(setup_sumassured, connection,masterSAObject);
			
			//end
			
			if (resultSet.next()) {
				setup_assuerd = resultSet.getDouble("PMEM_MAX_SA");
				
			} 
			/*Commented by ganesh on 18-01-2018 for ZBLIFE-1471888*/
			/*for(PT_IL_POL_FUNERAL_MEMB_DTLS  bean: dataList_PT_IL_POL_FUNERAL_MEMB_DTLS) 
			{
				if(bean.getROWID()!=null && !(bean.getROWID().equalsIgnoreCase(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getROWID())))
				{
					Extra condition added by ganesh on 12-01-2018 as suggested by gaurav
					if((bean.getPFMD_RELATION_TYPE().equalsIgnoreCase(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE())) && (bean.getPFMD_MEMB_TYPE().equalsIgnoreCase(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_TYPE())))
					{
						sum_assuerd = bean.getPFMD_SA();
					}
				}
				
			}*/
			/*end*/
			
			/*Modified by ganesh on 26-01-2018 for brother issue suggested by vikram & Siva*/
			/*Added by ganesh on 18-01-2018 for ZBLIFE-1471888 */
			/*rstSumAssured =  handler.executeSelectStatement(sumOfAllSA, connection,
					new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(), PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(),
					   PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_TYPE(),PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getROWID()});
			if(rstSumAssured.next()){
				sum_assuerd = rstSumAssured.getDouble(1);
			}*/
			
			//if((CommonUtils.nvl(sum_assuerd,0)>0.0) && (CommonUtils.nvl(sum_assuerd,0))+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA() > CommonUtils.nvl(setup_assuerd,0))
			//if((CommonUtils.nvl(sum_assuerd,0)>0.0) && (CommonUtils.nvl(sum_assuerd,0))+CommonUtils.nvl(currValue,PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA()) > CommonUtils.nvl(setup_assuerd,0))
			/*end*/
			if(CommonUtils.nvl(currValue,PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_SA()) > CommonUtils.nvl(setup_assuerd,0))
				/*end*/
			{
				
				String relDesc=null;
				String queryreldesc="SELECT LIV_CODE, LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE "
						+ "LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC' AND "
						+ "LI_BLOCK_NAME = 'PT_IL_POL_FUNERAL_MEMB_DTLS' AND LI_ITEM_NAME= 'PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_RELATION_TYPE' "
						+ "AND liv_code=?";	
			
				ResultSet resultSetRelDesc=new CRUDHandler().executeSelectStatement(queryreldesc, connection, 
						new Object[]{PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE()});
				
				while(resultSetRelDesc.next())
				{
					relDesc= resultSetRelDesc.getString("LIV_CODE_DESC");
				}
				
				/*Added by ganesh on 18-01-2018 for ZBLIFE-1471888 */	
				 System.out.println("COMP_PFMD_SA_LABEL                "+COMP_PFMD_SA_LABEL.getValue());
					
					//throw new Exception("Sum assured is exceeds the for the relation " +relDesc);
					throw new Exception(COMP_PFMD_SA_LABEL.getValue()+" exceeds the limit ("+setup_assuerd+") for the relation " +PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_DESC());
		
					/*End of  ZBLIFE-1471888 */
			
			}
			
			
		}
		catch(Exception e)
		{
		e.printStackTrace();
		throw e;
		}finally{
			
			/*Added by ganesh on 18-01-2018 for ZBLIFE-1471888 */
			CommonUtils.closeCursor(resultSet);
			
			/*End*/
			
		}
		
	}
	
	
	/*end*/
	
	/*added by raja on 18-04-2017*/
	public void memberCountValidation() throws Exception
	{
		
		int mem_count=0;
		try
		{
		/*
		 * Commented by sankara narayanan on 26/04/2017 for hospital cash plan on 26/04/2017
		 * String Query="SELECT PLAN_MAX_DEP_COUNT FROM PM_IL_PLAN WHERE PLAN_TYPE= 'L'";*/
			/*Changed by sankara narayanan for Hospital cash plan on 26/04/2017*/
			
		//Added by saritha on 12-01-2018	
			
		String memCountQuery = "";
		Object[] memCountParam = null;
		if(getPlanTypeLorH()!=null && compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPlanTypeLorH().equalsIgnoreCase("X")){
			
			memCountQuery = "SELECT PLAN_MAX_DEP_COUNT FROM PM_IL_PLAN WHERE PLAN_TYPE= ? AND PLAN_CODE=?";
			memCountParam = new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()};
			
		}else{
			memCountQuery = "SELECT PLAN_MAX_DEP_COUNT FROM PCOM_APP_PARAMETER,PM_IL_PLAN WHERE PARA_CODE = 'IL_RIDER_TY' "
			         + "AND PARA_VALUE = PLAN_CODE AND PARA_SUB_CODE = (SELECT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER, PM_IL_COVER "
			         + "WHERE POAC_COVER_CODE = COVER_CODE AND COVER_TYPE <> 'B'"
			         + "AND COVER_FUNERAL_CVR_YN = 'Y'"
			          + "AND POAC_POL_SYS_ID = ?)";
			memCountParam = new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()};
		}
		//String Query="SELECT PLAN_MAX_DEP_COUNT FROM PM_IL_PLAN WHERE PLAN_TYPE= ? AND PLAN_CODE=?"; //end
		
		 
		
		
			
		/*ResultSet rs=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE(),
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});*/
		ResultSet rs=new CRUDHandler().executeSelectStatement(memCountQuery, CommonUtils.getConnection(),memCountParam);
		while(rs.next())
		{
			/*
			 * Commented by sankara narayanan on 26/04/2017 for hospital cash plan on 26/04/2017
			 * mem_count=rs.getInt("PLAN_MAX_DEP_COUNT");*/
			/*Changed by sankara narayanan for Hospital cash plan on 26/04/2017*/
			mem_count=rs.getInt("PLAN_MAX_DEP_COUNT")+1;
			//end
		}
		
		if(dataList_PT_IL_POL_FUNERAL_MEMB_DTLS.size()>=mem_count)
		{
			/*added by raja on 29-05-2017 for ZBILQC-1727275*/
			/*throw new Exception("Maximum member count has been already ");*/
			/*throw new Exception("Maximum Depentant count has been reached already, cannot to add new Dependant ");*/
			throw new Exception("Maximum Depentant count  "+(mem_count-1)+" has been reached; cannot add more Dependants");
			/*end*/
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	/*end*/
	
	
	
	/*aDDED BY SANKARA NARAYANAN FOR HOSPITAL cASH pLAN ON22-04-2017*/
	private List<SelectItem> listPFMD_SMOKER_TEST_YN = new ArrayList<SelectItem>();

	public List<SelectItem> getListPFMD_SMOKER_TEST_YN() {
		return listPFMD_SMOKER_TEST_YN;
	}
	public void setListPFMD_SMOKER_TEST_YN(List<SelectItem> listPFMD_SMOKER_TEST_YN) {
		this.listPFMD_SMOKER_TEST_YN = listPFMD_SMOKER_TEST_YN;
	}
	
	private HtmlSelectOneMenu COMP_PFMD_SMOKER_TEST_YN;
	private HtmlOutputLabel COMP_PFMD_SMOKER_TEST_YN_LABEL;
	private HtmlInputText  COMP_UI_PFMD_GENDER_DESC;
	private HtmlInputText COMP_PFMD_GENDER;
	private HtmlOutputLabel COMP_PFMD_GENDER_LABEL;
	private HtmlOutputLabel COMP_UI_PFMD_NO_OF_DAYS_LABEL;
	private HtmlInputText COMP_UI_PFMD_NO_OF_DAYS;
	private HtmlCommandButton COMP_BTN_POL_ILLNESS;
	
	
	
	
	
	
	
	
	public HtmlCommandButton getCOMP_BTN_POL_ILLNESS() {
		return COMP_BTN_POL_ILLNESS;
	}
	public void setCOMP_BTN_POL_ILLNESS(HtmlCommandButton cOMP_BTN_POL_ILLNESS) {
		COMP_BTN_POL_ILLNESS = cOMP_BTN_POL_ILLNESS;
	}
	public HtmlOutputLabel getCOMP_UI_PFMD_NO_OF_DAYS_LABEL() {
		return COMP_UI_PFMD_NO_OF_DAYS_LABEL;
	}
	public void setCOMP_UI_PFMD_NO_OF_DAYS_LABEL(
			HtmlOutputLabel cOMP_UI_PFMD_NO_OF_DAYS_LABEL) {
		COMP_UI_PFMD_NO_OF_DAYS_LABEL = cOMP_UI_PFMD_NO_OF_DAYS_LABEL;
	}
	public HtmlInputText getCOMP_UI_PFMD_NO_OF_DAYS() {
		return COMP_UI_PFMD_NO_OF_DAYS;
	}
	public void setCOMP_UI_PFMD_NO_OF_DAYS(HtmlInputText cOMP_UI_PFMD_NO_OF_DAYS) {
		COMP_UI_PFMD_NO_OF_DAYS = cOMP_UI_PFMD_NO_OF_DAYS;
	}
	public HtmlSelectOneMenu getCOMP_PFMD_SMOKER_TEST_YN() {
		return COMP_PFMD_SMOKER_TEST_YN;
	}
	public void setCOMP_PFMD_SMOKER_TEST_YN(
			HtmlSelectOneMenu cOMP_PFMD_SMOKER_TEST_YN) {
		COMP_PFMD_SMOKER_TEST_YN = cOMP_PFMD_SMOKER_TEST_YN;
	}
	public HtmlOutputLabel getCOMP_PFMD_SMOKER_TEST_YN_LABEL() {
		return COMP_PFMD_SMOKER_TEST_YN_LABEL;
	}
	public void setCOMP_PFMD_SMOKER_TEST_YN_LABEL(
			HtmlOutputLabel cOMP_PFMD_SMOKER_TEST_YN_LABEL) {
		COMP_PFMD_SMOKER_TEST_YN_LABEL = cOMP_PFMD_SMOKER_TEST_YN_LABEL;
	}
	
	
	public HtmlInputText getCOMP_UI_PFMD_GENDER_DESC() {
		return COMP_UI_PFMD_GENDER_DESC;
	}
	public void setCOMP_UI_PFMD_GENDER_DESC(HtmlInputText cOMP_UI_PFMD_GENDER_DESC) {
		COMP_UI_PFMD_GENDER_DESC = cOMP_UI_PFMD_GENDER_DESC;
	}
	
	public HtmlInputText getCOMP_PFMD_GENDER() {
		return COMP_PFMD_GENDER;
	}
	public void setCOMP_PFMD_GENDER(HtmlInputText cOMP_PFMD_GENDER) {
		COMP_PFMD_GENDER = cOMP_PFMD_GENDER;
	}
	public HtmlOutputLabel getCOMP_PFMD_GENDER_LABEL() {
		return COMP_PFMD_GENDER_LABEL;
	}
	public void setCOMP_PFMD_GENDER_LABEL(HtmlOutputLabel cOMP_PFMD_GENDER_LABEL) {
		COMP_PFMD_GENDER_LABEL = cOMP_PFMD_GENDER_LABEL;
	}
	
	
	public void PFMD_GENDER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){
		try {					
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_GENDER(value.toString());
		} catch (Exception e) {
			//getErrorMap().put("current", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void PFMD_SMOKER_TEST_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){
		try {					
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_SMOKER_TEST_YN(value.toString());
		} catch (Exception e) {
			//getErrorMap().put("current", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public ArrayList<LovBean> prepareSuggestionList_CATG_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_CATG_CODE";
		Object param1 = "CATG";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	public String clickillnessDetaile() {
		compositeAction.getPT_IL_POL_PRE_ILLNESS_DTLS_ACTION_BEAN().setBlockFlag(true);
		compositeAction.getPT_IL_POL_PRE_ILLNESS_DTLS_ACTION_BEAN().addRow(null);
		return "MEMBER_ILLNESS";

	}
	
	/*END*/
	
	
	/*added by raja on 17-05-2017 for addition of dependant*/
	
	
	public void checkEndoDeletion() {
		List<PT_IL_POL_FUNERAL_MEMB_DTLS> dataList = compositeAction
				.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS();
		for (int i = 0; i < dataList.size(); i++) {
			if (4==(dataList.get(i).getPFMD_REC_TYPE())) {
				dataList.get(i).setDeleted("deletedyes");
			} else {
				dataList.get(i).setDeleted("deletedno");
			}
		}
	}
	
	/*end*/
	
/*added by raja on 23-05-2017 for deletion of dependant*/
	
	public  ArrayList<OracleParameter> P_FUNERAL_DEP_UPD(long POL_SYS_ID, long PFMD_SYS_ID) throws Exception
	{
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, PFMD_SYS_ID);
			parameterList.add(param2);
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_POLICY.P_FUNERAL_DEP_UPD");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			e.printStackTrace();
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	/*end*/
	/*Added by Ameen on 10-07-2017 for ZBILQC-1731204*/
	String saErrmsg = "";
	public String getErrMsg(String planType){
		System.out.println("inside getErrMsg ::" + planType);
		String msg="";
		try {
			if("H".equalsIgnoreCase(planType)){
				msg = "Daily Benefit Limit";
			}else{
				msg = "Sum Assured";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<LovBean> lovPfmdMembType(
			Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			/*suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POL_FUNERAL_MEMB_DTLS", "PFMD_MEMB_TYPE", "IL_DEP_TYP", null, null,
					null, null, (String) currValue);*/
			
			
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POL_FUNERAL_MEMB_DTLS", "PFMD_MEMB_TYPE", "IL_DEP_TYP",PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(), compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE(),
					null, null, (String) currValue);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public void validatePFMD_MEMB_TYPE(FacesContext context,
			UIComponent component, Object value){

		
		try {
			
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_MEMB_TYPE((String)value);
			helper.PFMD_MEMB_TYPE_WHEN_VALIDATE_ITEM(compositeAction,PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN);
			
		} catch (Exception e) {
			e.printStackTrace();
 			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	private HtmlOutputLabel COMP_PFMD_BASIC_RATE_LABEL;
	
	private HtmlInputText COMP_PFMD_BASIC_RATE;

	public HtmlOutputLabel getCOMP_PFMD_BASIC_RATE_LABEL() {
		return COMP_PFMD_BASIC_RATE_LABEL;
	}
	public void setCOMP_PFMD_BASIC_RATE_LABEL(
			HtmlOutputLabel cOMP_PFMD_BASIC_RATE_LABEL) {
		COMP_PFMD_BASIC_RATE_LABEL = cOMP_PFMD_BASIC_RATE_LABEL;
	}
	public HtmlInputText getCOMP_PFMD_BASIC_RATE() {
		return COMP_PFMD_BASIC_RATE;
	}
	public void setCOMP_PFMD_BASIC_RATE(HtmlInputText cOMP_PFMD_BASIC_RATE) {
		COMP_PFMD_BASIC_RATE = cOMP_PFMD_BASIC_RATE;
	}
	
	/*end*/
	
	/*added by Ameen on 01-11-2017 for ZBLIFE-1449096*/
	private HtmlOutputText COMP_UI_M_STATUS;
	
	private HtmlOutputLabel COMP_PFMD_EFF_FM_DT_LABEL;
	
	private HtmlCalendar COMP_PFMD_EFF_FM_DT;
	
	private HtmlOutputLabel COMP_PFMD_EFF_TO_DT_LABEL;
	
	private HtmlCalendar COMP_PFMD_EFF_TO_DT;
	

	public HtmlOutputText getCOMP_UI_M_STATUS() {
		return COMP_UI_M_STATUS;
	}
	public void setCOMP_UI_M_STATUS(HtmlOutputText cOMP_UI_M_STATUS) {
		COMP_UI_M_STATUS = cOMP_UI_M_STATUS;
	}
	public HtmlOutputLabel getCOMP_PFMD_EFF_FM_DT_LABEL() {
		return COMP_PFMD_EFF_FM_DT_LABEL;
	}
	public void setCOMP_PFMD_EFF_FM_DT_LABEL(
			HtmlOutputLabel cOMP_PFMD_EFF_FM_DT_LABEL) {
		COMP_PFMD_EFF_FM_DT_LABEL = cOMP_PFMD_EFF_FM_DT_LABEL;
	}
	
	public HtmlCalendar getCOMP_PFMD_EFF_FM_DT() {
		return COMP_PFMD_EFF_FM_DT;
	}
	public void setCOMP_PFMD_EFF_FM_DT(HtmlCalendar cOMP_PFMD_EFF_FM_DT) {
		COMP_PFMD_EFF_FM_DT = cOMP_PFMD_EFF_FM_DT;
	}
	public HtmlOutputLabel getCOMP_PFMD_EFF_TO_DT_LABEL() {
		return COMP_PFMD_EFF_TO_DT_LABEL;
	}
	public void setCOMP_PFMD_EFF_TO_DT_LABEL(
			HtmlOutputLabel cOMP_PFMD_EFF_TO_DT_LABEL) {
		COMP_PFMD_EFF_TO_DT_LABEL = cOMP_PFMD_EFF_TO_DT_LABEL;
	}
	
	public HtmlCalendar getCOMP_PFMD_EFF_TO_DT() {
		return COMP_PFMD_EFF_TO_DT;
	}
	public void setCOMP_PFMD_EFF_TO_DT(HtmlCalendar cOMP_PFMD_EFF_TO_DT) {
		COMP_PFMD_EFF_TO_DT = cOMP_PFMD_EFF_TO_DT;
	}
	public void validatorPFMD_EFF_FM_DT(FacesContext context,
			UIComponent component, Object value){
	
		try {
			Date currVal = (Date)value;

			/*Added by Janani on 05.06.2018 for FLA funeral changes remove timestamp from date*/
			
			System.out.println("getPOL_START_DT              "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					getPT_IL_POLICY_BEAN().getPOL_START_DT());
						
			Date pol_strt_date = CommonUtils.getDate(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					getPT_IL_POLICY_BEAN().getPOL_START_DT());
			
			System.out.println("date                  "+pol_strt_date);
			
			//if(currVal.before(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_START_DT())) Commented by 
			//Janani on 05.06.2018 for FLA funeral changes
			
			if(currVal.before(pol_strt_date))
				
			/*End*/	
			{
				throw new Exception("Registration Date Should be within Policy Period");
			}
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_EFF_FM_DT((Date)value);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorPFMD_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value){
	
		try {
			Date currVal = (Date)value;
			if(currVal.after(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_EXPIRY_DT())){
				throw new Exception("Registration Date Should be within Policy Period");
			}
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_EFF_TO_DT((Date)value);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	/*end*/
	
	/*Added by ganesh for ZBLIFE-1455133*/
	public ArrayList<LovBean> prepareSuggestionList_PBEN_RELATION_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String currentValue = (String) object;		
			String moduleName = "PILT002_APAC";
			String blockName = "PT_IL_POL_FUNERAL_MEMB_DTLS";
			String fieldName = "PFMD_RELATION_TYPE";
			ListItemUtil itemUtil = new ListItemUtil();

			try {
				lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
						"IL_PAR_MEMB", getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_GENDER(), null, null, null, currentValue);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return lovList;
	}
	
	private HtmlInputText COMP_UI_M_PFMD_RELATION_DESC;

	public HtmlInputText getCOMP_UI_M_PFMD_RELATION_DESC() {
		return COMP_UI_M_PFMD_RELATION_DESC;
	}
	public void setCOMP_UI_M_PFMD_RELATION_DESC(
			HtmlInputText cOMP_UI_M_PFMD_RELATION_DESC) {
		COMP_UI_M_PFMD_RELATION_DESC = cOMP_UI_M_PFMD_RELATION_DESC;
	}
	/*end*/
	
	
	//Added by saritha on 05-01-2018
	
	public String planTypeLorH;
	
	public String getPlanTypeLorH() {
		return planTypeLorH;
	}
	public void setPlanTypeLorH(String planTypeLorH) {
		this.planTypeLorH = planTypeLorH;
	}
	
	public void PlanTypeLorH() throws Exception
	{

		ResultSet  rstplanTypeLorH=null;
		Connection connection = null;
		String planTypeLorH=null;
		String query="SELECT 'X' FROM PM_IL_PLAN,PT_IL_POLICY WHERE PLAN_TYPE IN('L','H') AND PLAN_CODE=POL_PLAN_CODE AND POL_SYS_ID =?";

		try{
			connection=CommonUtils.getConnection();

			rstplanTypeLorH = new CRUDHandler().executeSelectStatement(query, connection, new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});

			if(rstplanTypeLorH.next())
			{
				planTypeLorH=rstplanTypeLorH.getString(1);
			}

			setPlanTypeLorH(planTypeLorH);
			System.out.println("setPlanTypeLorH -----> "+ getPlanTypeLorH());

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(rstplanTypeLorH);
		}
	}

	/*End*/
	
	/*Added by ganesh on 18-01-2018 for 207R morecover funeral */
	public boolean checkFuneralCoverYN() throws Exception {
		Connection connection = null;
		ResultSet resultset = null;
		Boolean flag=false;
		String coverCodequery = "SELECT 'X'FROM PT_IL_POL_ADDL_COVER, PM_IL_COVER WHERE POAC_COVER_CODE = COVER_CODE "
				               	+ "AND COVER_TYPE <> 'B' AND COVER_FUNERAL_CVR_YN = 'Y' AND POAC_POL_SYS_ID = ?";

		try {

			connection = CommonUtils.getConnection();
			resultset = new CRUDHandler().executeSelectStatement(coverCodequery, connection,new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			if(resultset.next()){				
				flag = true;
			}
			return flag;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally {
			CommonUtils.closeCursor(resultset);
		}

	}
	/*end*/
	/*Added By Dhinesh on 05-06-2018 for FLA Funeral Changes*/
	
	private HtmlOutputLabel COMP_PFMD_PREM_CALC_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_PFMD_PREM_CALC_TYPE;	
	private List<SelectItem> listPFMD_PREM_CALC_TYPE = new ArrayList<SelectItem>();

	public HtmlOutputLabel getCOMP_PFMD_PREM_CALC_TYPE_LABEL() {
		return COMP_PFMD_PREM_CALC_TYPE_LABEL;
	}
	public void setCOMP_PFMD_PREM_CALC_TYPE_LABEL(
			HtmlOutputLabel cOMP_PFMD_PREM_CALC_TYPE_LABEL) {
		COMP_PFMD_PREM_CALC_TYPE_LABEL = cOMP_PFMD_PREM_CALC_TYPE_LABEL;
	}
	public HtmlSelectOneMenu getCOMP_PFMD_PREM_CALC_TYPE() {
		return COMP_PFMD_PREM_CALC_TYPE;
	}
	public void setCOMP_PFMD_PREM_CALC_TYPE(
			HtmlSelectOneMenu cOMP_PFMD_PREM_CALC_TYPE) {
		COMP_PFMD_PREM_CALC_TYPE = cOMP_PFMD_PREM_CALC_TYPE;
	}
	public List<SelectItem> getListPFMD_PREM_CALC_TYPE() {
		return listPFMD_PREM_CALC_TYPE;
	}
	public void setListPFMD_PREM_CALC_TYPE(List<SelectItem> listPFMD_PREM_CALC_TYPE) {
		this.listPFMD_PREM_CALC_TYPE = listPFMD_PREM_CALC_TYPE;
	}
	
	
		
	
	public void validatorPFMD_PREM_CALC_TYPE(FacesContext context,
			UIComponent component, Object value){
	
		try {
			
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_PREM_CALC_TYPE((String)value);
			
			/*Added by Janani on 05.06.2018 for FLA funeral changes*/
			
			if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_PREM_CALC_TYPE().equalsIgnoreCase("s"))
			{
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_PREMIUM(0);
			}
			
			System.out.println("getPFMD_PREMIUM                 "+PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_PREMIUM());
			
			
			/*Modified by kavitha on 20.07.2018 for FLALIFEQC-1757116 */
			if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_TYPE()!=null &&  PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_TYPE().equalsIgnoreCase("mm"))
			/*End of FLALIFEQC-1757116*/
			{

				if(!PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_PREM_CALC_TYPE().equalsIgnoreCase("i"))
				{
					throw new Exception("Premium Calc Type must be Individual for Main member");	
				}

			}

			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*End*/
	
}
