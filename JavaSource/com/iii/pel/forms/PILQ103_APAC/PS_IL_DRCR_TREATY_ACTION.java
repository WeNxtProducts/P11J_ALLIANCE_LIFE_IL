package com.iii.pel.forms.PILQ103_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
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
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;


public class PS_IL_DRCR_TREATY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DRCR_DRCR_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_DRCR_DRCR_FLAG;

	private HtmlOutputLabel COMP_DRCR_TXN_CODE_LABEL;

	private HtmlInputText COMP_DRCR_TXN_CODE;

	private HtmlOutputLabel COMP_DRCR_DOC_NO_LABEL;

	private HtmlInputText COMP_DRCR_DOC_NO;

	private HtmlOutputLabel COMP_DRCR_SEQ_NO_LABEL;

	private HtmlInputText COMP_DRCR_SEQ_NO;

	private HtmlOutputLabel COMP_DRCR_DOC_DT_LABEL;

	private HtmlCalendar COMP_DRCR_DOC_DT;

	private HtmlOutputLabel COMP_DRCR_LC_AMT_LABEL;

	private HtmlInputText COMP_DRCR_LC_AMT;

	private HtmlOutputLabel COMP_DRCR_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_DRCR_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_DRCR_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_DRCR_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_DRCR_NARRATION_LABEL;

	private HtmlInputText COMP_DRCR_NARRATION;

	private HtmlOutputLabel COMP_DRCR_POST_YN_LABEL;

	private HtmlSelectOneMenu COMP_DRCR_POST_YN;

	private HtmlOutputLabel COMP_DRCR_END_NO_LABEL;

	private HtmlInputText COMP_DRCR_END_NO;

	private HtmlOutputLabel COMP_UI_M_DRCR_TOT_DR_LABEL;

	private HtmlInputText COMP_UI_M_DRCR_TOT_DR;

	private HtmlOutputLabel COMP_UI_M_DRCR_TOT_CR_LABEL;

	private HtmlInputText COMP_UI_M_DRCR_TOT_CR;

	private HtmlOutputLabel COMP_DRCR_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_DRCR_ANLY_CODE_1;

	private HtmlOutputLabel COMP_DRCR_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_DRCR_ANLY_CODE_2;

	private HtmlOutputLabel COMP_DRCR_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_DRCR_ACTY_CODE_1;

	private HtmlOutputLabel COMP_DRCR_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_DRCR_ACTY_CODE_2;

	private HtmlOutputLabel COMP_DRCR_CUST_CODE_LABEL;

	private HtmlInputText COMP_DRCR_CUST_CODE;

	private HtmlOutputLabel COMP_DRCR_DIVN_CODE_LABEL;

	private HtmlInputText COMP_DRCR_DIVN_CODE;

	private HtmlOutputLabel COMP_DRCR_DEPT_CODE_LABEL;

	private HtmlInputText COMP_DRCR_DEPT_CODE;

	private HtmlOutputLabel COMP_DRCR_CLAIM_NO_LABEL;

	private HtmlInputText COMP_DRCR_CLAIM_NO;

	private PS_IL_DRCR_TREATY PS_IL_DRCR_TREATY_BEAN;

	private List<PS_IL_DRCR_TREATY> dataList_PS_IL_DRCR_TREATY = new ArrayList<PS_IL_DRCR_TREATY>();
	
	private HtmlOutputLabel COMP_UI_M_CUST_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_CUST_CODE;
	
	private HtmlOutputLabel COMP_UI_M_CUST_NAME_LABEL;
	
	private HtmlInputText COMP_UI_M_CUST_NAME;
	
	private HtmlCommandButton COMP_BUT_FETCH;
	
	private HtmlCommandButton COMP_BUT_GOBACK;
	
	private boolean onLoadFlag = false;
	
	private boolean preFormFlag = false;
	
	List<SelectItem> drcrList = null;
	
	List<SelectItem> postYnList = null;
	
	private String filterDRCR_LC_AMT;
	
	private String filterDRCR_SEQ_NO;

	private String filterByDRCR_DOC_NO;
	
	private String filterByDRCR_TXN_CODE;
	
	private UIData dataTable;

	public PS_IL_DRCR_TREATY_ACTION() {
		PS_IL_DRCR_TREATY_BEAN = new PS_IL_DRCR_TREATY();
		Connection connection = PILQ103_APAC_ACTION_INSTANCE.getConnection();
		setDrcrList(ListItemUtil.getDropDownListValue(connection, "PILQ103_APAC", "PS_IL_DRCR_TREATY", "PS_IL_DRCR_TREATY.DRCR_DRCR_FLAG", "DRCR"));
		setPostYnList(ListItemUtil.getDropDownListValue(connection, "PILQ103_APAC", "PS_IL_DRCR_TREATY", "PS_IL_DRCR_TREATY.DRCR_POST_YN", "ILPOSTFLAG"));
	}
	
	public void fetchButAction(){
		PS_IL_DRCR_TREATY_HELPER helper = new PS_IL_DRCR_TREATY_HELPER();
		try {
			helper.executeQuery(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public HtmlOutputLabel getCOMP_DRCR_DRCR_FLAG_LABEL() {
		return COMP_DRCR_DRCR_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DRCR_DRCR_FLAG() {
		return COMP_DRCR_DRCR_FLAG;
	}

	public void setCOMP_DRCR_DRCR_FLAG_LABEL(HtmlOutputLabel COMP_DRCR_DRCR_FLAG_LABEL) {
		this.COMP_DRCR_DRCR_FLAG_LABEL = COMP_DRCR_DRCR_FLAG_LABEL;
	}

	public void setCOMP_DRCR_DRCR_FLAG(HtmlSelectOneMenu COMP_DRCR_DRCR_FLAG) {
		this.COMP_DRCR_DRCR_FLAG = COMP_DRCR_DRCR_FLAG;
	}

	public HtmlOutputLabel getCOMP_DRCR_TXN_CODE_LABEL() {
		return COMP_DRCR_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_TXN_CODE() {
		return COMP_DRCR_TXN_CODE;
	}

	public void setCOMP_DRCR_TXN_CODE_LABEL(HtmlOutputLabel COMP_DRCR_TXN_CODE_LABEL) {
		this.COMP_DRCR_TXN_CODE_LABEL = COMP_DRCR_TXN_CODE_LABEL;
	}

	public void setCOMP_DRCR_TXN_CODE(HtmlInputText COMP_DRCR_TXN_CODE) {
		this.COMP_DRCR_TXN_CODE = COMP_DRCR_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_DRCR_DOC_NO_LABEL() {
		return COMP_DRCR_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_DOC_NO() {
		return COMP_DRCR_DOC_NO;
	}

	public void setCOMP_DRCR_DOC_NO_LABEL(HtmlOutputLabel COMP_DRCR_DOC_NO_LABEL) {
		this.COMP_DRCR_DOC_NO_LABEL = COMP_DRCR_DOC_NO_LABEL;
	}

	public void setCOMP_DRCR_DOC_NO(HtmlInputText COMP_DRCR_DOC_NO) {
		this.COMP_DRCR_DOC_NO = COMP_DRCR_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_DRCR_SEQ_NO_LABEL() {
		return COMP_DRCR_SEQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_SEQ_NO() {
		return COMP_DRCR_SEQ_NO;
	}

	public void setCOMP_DRCR_SEQ_NO_LABEL(HtmlOutputLabel COMP_DRCR_SEQ_NO_LABEL) {
		this.COMP_DRCR_SEQ_NO_LABEL = COMP_DRCR_SEQ_NO_LABEL;
	}

	public void setCOMP_DRCR_SEQ_NO(HtmlInputText COMP_DRCR_SEQ_NO) {
		this.COMP_DRCR_SEQ_NO = COMP_DRCR_SEQ_NO;
	}

	public HtmlOutputLabel getCOMP_DRCR_DOC_DT_LABEL() {
		return COMP_DRCR_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DRCR_DOC_DT() {
		return COMP_DRCR_DOC_DT;
	}

	public void setCOMP_DRCR_DOC_DT_LABEL(HtmlOutputLabel COMP_DRCR_DOC_DT_LABEL) {
		this.COMP_DRCR_DOC_DT_LABEL = COMP_DRCR_DOC_DT_LABEL;
	}

	public void setCOMP_DRCR_DOC_DT(HtmlCalendar COMP_DRCR_DOC_DT) {
		this.COMP_DRCR_DOC_DT = COMP_DRCR_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_DRCR_LC_AMT_LABEL() {
		return COMP_DRCR_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_LC_AMT() {
		return COMP_DRCR_LC_AMT;
	}

	public void setCOMP_DRCR_LC_AMT_LABEL(HtmlOutputLabel COMP_DRCR_LC_AMT_LABEL) {
		this.COMP_DRCR_LC_AMT_LABEL = COMP_DRCR_LC_AMT_LABEL;
	}

	public void setCOMP_DRCR_LC_AMT(HtmlInputText COMP_DRCR_LC_AMT) {
		this.COMP_DRCR_LC_AMT = COMP_DRCR_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_DRCR_MAIN_ACNT_CODE_LABEL() {
		return COMP_DRCR_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_MAIN_ACNT_CODE() {
		return COMP_DRCR_MAIN_ACNT_CODE;
	}

	public void setCOMP_DRCR_MAIN_ACNT_CODE_LABEL(HtmlOutputLabel COMP_DRCR_MAIN_ACNT_CODE_LABEL) {
		this.COMP_DRCR_MAIN_ACNT_CODE_LABEL = COMP_DRCR_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_DRCR_MAIN_ACNT_CODE(HtmlInputText COMP_DRCR_MAIN_ACNT_CODE) {
		this.COMP_DRCR_MAIN_ACNT_CODE = COMP_DRCR_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_DRCR_SUB_ACNT_CODE_LABEL() {
		return COMP_DRCR_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_SUB_ACNT_CODE() {
		return COMP_DRCR_SUB_ACNT_CODE;
	}

	public void setCOMP_DRCR_SUB_ACNT_CODE_LABEL(HtmlOutputLabel COMP_DRCR_SUB_ACNT_CODE_LABEL) {
		this.COMP_DRCR_SUB_ACNT_CODE_LABEL = COMP_DRCR_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_DRCR_SUB_ACNT_CODE(HtmlInputText COMP_DRCR_SUB_ACNT_CODE) {
		this.COMP_DRCR_SUB_ACNT_CODE = COMP_DRCR_SUB_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_DRCR_NARRATION_LABEL() {
		return COMP_DRCR_NARRATION_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_NARRATION() {
		return COMP_DRCR_NARRATION;
	}

	public void setCOMP_DRCR_NARRATION_LABEL(HtmlOutputLabel COMP_DRCR_NARRATION_LABEL) {
		this.COMP_DRCR_NARRATION_LABEL = COMP_DRCR_NARRATION_LABEL;
	}

	public void setCOMP_DRCR_NARRATION(HtmlInputText COMP_DRCR_NARRATION) {
		this.COMP_DRCR_NARRATION = COMP_DRCR_NARRATION;
	}

	public HtmlOutputLabel getCOMP_DRCR_POST_YN_LABEL() {
		return COMP_DRCR_POST_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DRCR_POST_YN() {
		return COMP_DRCR_POST_YN;
	}

	public void setCOMP_DRCR_POST_YN_LABEL(HtmlOutputLabel COMP_DRCR_POST_YN_LABEL) {
		this.COMP_DRCR_POST_YN_LABEL = COMP_DRCR_POST_YN_LABEL;
	}

	public void setCOMP_DRCR_POST_YN(HtmlSelectOneMenu COMP_DRCR_POST_YN) {
		this.COMP_DRCR_POST_YN = COMP_DRCR_POST_YN;
	}

	public HtmlOutputLabel getCOMP_DRCR_END_NO_LABEL() {
		return COMP_DRCR_END_NO_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_END_NO() {
		return COMP_DRCR_END_NO;
	}

	public void setCOMP_DRCR_END_NO_LABEL(HtmlOutputLabel COMP_DRCR_END_NO_LABEL) {
		this.COMP_DRCR_END_NO_LABEL = COMP_DRCR_END_NO_LABEL;
	}

	public void setCOMP_DRCR_END_NO(HtmlInputText COMP_DRCR_END_NO) {
		this.COMP_DRCR_END_NO = COMP_DRCR_END_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_DRCR_TOT_DR_LABEL() {
		return COMP_UI_M_DRCR_TOT_DR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DRCR_TOT_DR() {
		return COMP_UI_M_DRCR_TOT_DR;
	}

	public void setCOMP_UI_M_DRCR_TOT_DR_LABEL(HtmlOutputLabel COMP_UI_M_DRCR_TOT_DR_LABEL) {
		this.COMP_UI_M_DRCR_TOT_DR_LABEL = COMP_UI_M_DRCR_TOT_DR_LABEL;
	}

	public void setCOMP_UI_M_DRCR_TOT_DR(HtmlInputText COMP_UI_M_DRCR_TOT_DR) {
		this.COMP_UI_M_DRCR_TOT_DR = COMP_UI_M_DRCR_TOT_DR;
	}

	public HtmlOutputLabel getCOMP_UI_M_DRCR_TOT_CR_LABEL() {
		return COMP_UI_M_DRCR_TOT_CR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DRCR_TOT_CR() {
		return COMP_UI_M_DRCR_TOT_CR;
	}

	public void setCOMP_UI_M_DRCR_TOT_CR_LABEL(HtmlOutputLabel COMP_UI_M_DRCR_TOT_CR_LABEL) {
		this.COMP_UI_M_DRCR_TOT_CR_LABEL = COMP_UI_M_DRCR_TOT_CR_LABEL;
	}

	public void setCOMP_UI_M_DRCR_TOT_CR(HtmlInputText COMP_UI_M_DRCR_TOT_CR) {
		this.COMP_UI_M_DRCR_TOT_CR = COMP_UI_M_DRCR_TOT_CR;
	}

	public HtmlOutputLabel getCOMP_DRCR_ANLY_CODE_1_LABEL() {
		return COMP_DRCR_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_ANLY_CODE_1() {
		return COMP_DRCR_ANLY_CODE_1;
	}

	public void setCOMP_DRCR_ANLY_CODE_1_LABEL(HtmlOutputLabel COMP_DRCR_ANLY_CODE_1_LABEL) {
		this.COMP_DRCR_ANLY_CODE_1_LABEL = COMP_DRCR_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_DRCR_ANLY_CODE_1(HtmlInputText COMP_DRCR_ANLY_CODE_1) {
		this.COMP_DRCR_ANLY_CODE_1 = COMP_DRCR_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_DRCR_ANLY_CODE_2_LABEL() {
		return COMP_DRCR_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_ANLY_CODE_2() {
		return COMP_DRCR_ANLY_CODE_2;
	}

	public void setCOMP_DRCR_ANLY_CODE_2_LABEL(HtmlOutputLabel COMP_DRCR_ANLY_CODE_2_LABEL) {
		this.COMP_DRCR_ANLY_CODE_2_LABEL = COMP_DRCR_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_DRCR_ANLY_CODE_2(HtmlInputText COMP_DRCR_ANLY_CODE_2) {
		this.COMP_DRCR_ANLY_CODE_2 = COMP_DRCR_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_DRCR_ACTY_CODE_1_LABEL() {
		return COMP_DRCR_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_ACTY_CODE_1() {
		return COMP_DRCR_ACTY_CODE_1;
	}

	public void setCOMP_DRCR_ACTY_CODE_1_LABEL(HtmlOutputLabel COMP_DRCR_ACTY_CODE_1_LABEL) {
		this.COMP_DRCR_ACTY_CODE_1_LABEL = COMP_DRCR_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_DRCR_ACTY_CODE_1(HtmlInputText COMP_DRCR_ACTY_CODE_1) {
		this.COMP_DRCR_ACTY_CODE_1 = COMP_DRCR_ACTY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_DRCR_ACTY_CODE_2_LABEL() {
		return COMP_DRCR_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_ACTY_CODE_2() {
		return COMP_DRCR_ACTY_CODE_2;
	}

	public void setCOMP_DRCR_ACTY_CODE_2_LABEL(HtmlOutputLabel COMP_DRCR_ACTY_CODE_2_LABEL) {
		this.COMP_DRCR_ACTY_CODE_2_LABEL = COMP_DRCR_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_DRCR_ACTY_CODE_2(HtmlInputText COMP_DRCR_ACTY_CODE_2) {
		this.COMP_DRCR_ACTY_CODE_2 = COMP_DRCR_ACTY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_DRCR_CUST_CODE_LABEL() {
		return COMP_DRCR_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_CUST_CODE() {
		return COMP_DRCR_CUST_CODE;
	}

	public void setCOMP_DRCR_CUST_CODE_LABEL(HtmlOutputLabel COMP_DRCR_CUST_CODE_LABEL) {
		this.COMP_DRCR_CUST_CODE_LABEL = COMP_DRCR_CUST_CODE_LABEL;
	}

	public void setCOMP_DRCR_CUST_CODE(HtmlInputText COMP_DRCR_CUST_CODE) {
		this.COMP_DRCR_CUST_CODE = COMP_DRCR_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_DRCR_DIVN_CODE_LABEL() {
		return COMP_DRCR_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_DIVN_CODE() {
		return COMP_DRCR_DIVN_CODE;
	}

	public void setCOMP_DRCR_DIVN_CODE_LABEL(HtmlOutputLabel COMP_DRCR_DIVN_CODE_LABEL) {
		this.COMP_DRCR_DIVN_CODE_LABEL = COMP_DRCR_DIVN_CODE_LABEL;
	}

	public void setCOMP_DRCR_DIVN_CODE(HtmlInputText COMP_DRCR_DIVN_CODE) {
		this.COMP_DRCR_DIVN_CODE = COMP_DRCR_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_DRCR_DEPT_CODE_LABEL() {
		return COMP_DRCR_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_DEPT_CODE() {
		return COMP_DRCR_DEPT_CODE;
	}

	public void setCOMP_DRCR_DEPT_CODE_LABEL(HtmlOutputLabel COMP_DRCR_DEPT_CODE_LABEL) {
		this.COMP_DRCR_DEPT_CODE_LABEL = COMP_DRCR_DEPT_CODE_LABEL;
	}

	public void setCOMP_DRCR_DEPT_CODE(HtmlInputText COMP_DRCR_DEPT_CODE) {
		this.COMP_DRCR_DEPT_CODE = COMP_DRCR_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_DRCR_CLAIM_NO_LABEL() {
		return COMP_DRCR_CLAIM_NO_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_CLAIM_NO() {
		return COMP_DRCR_CLAIM_NO;
	}

	public void setCOMP_DRCR_CLAIM_NO_LABEL(HtmlOutputLabel COMP_DRCR_CLAIM_NO_LABEL) {
		this.COMP_DRCR_CLAIM_NO_LABEL = COMP_DRCR_CLAIM_NO_LABEL;
	}

	public void setCOMP_DRCR_CLAIM_NO(HtmlInputText COMP_DRCR_CLAIM_NO) {
		this.COMP_DRCR_CLAIM_NO = COMP_DRCR_CLAIM_NO;
	}

	public PS_IL_DRCR_TREATY getPS_IL_DRCR_TREATY_BEAN() {
		return PS_IL_DRCR_TREATY_BEAN;
	}

	public void setPS_IL_DRCR_TREATY_BEAN(PS_IL_DRCR_TREATY PS_IL_DRCR_TREATY_BEAN) {
		this.PS_IL_DRCR_TREATY_BEAN = PS_IL_DRCR_TREATY_BEAN;
	}

	public List<PS_IL_DRCR_TREATY> getDataList_PS_IL_DRCR_TREATY() {
		return dataList_PS_IL_DRCR_TREATY;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public void setDataList_PS_IL_DRCR_TREATY(
			List<PS_IL_DRCR_TREATY> dataList_PS_IL_DRCR_TREATY) {
		this.dataList_PS_IL_DRCR_TREATY = dataList_PS_IL_DRCR_TREATY;
	}

	public boolean isPreFormFlag() {
		return preFormFlag;
	}

	public void setPreFormFlag(boolean preFormFlag) {
		this.preFormFlag = preFormFlag;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_CODE_LABEL() {
		return COMP_UI_M_CUST_CODE_LABEL;
	}

	public void setCOMP_UI_M_CUST_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_cust_code_label) {
		COMP_UI_M_CUST_CODE_LABEL = comp_ui_m_cust_code_label;
	}

	public HtmlInputText getCOMP_UI_M_CUST_CODE() {
		return COMP_UI_M_CUST_CODE;
	}

	public void setCOMP_UI_M_CUST_CODE(HtmlInputText comp_ui_m_cust_code) {
		COMP_UI_M_CUST_CODE = comp_ui_m_cust_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_NAME_LABEL() {
		return COMP_UI_M_CUST_NAME_LABEL;
	}

	public void setCOMP_UI_M_CUST_NAME_LABEL(
			HtmlOutputLabel comp_ui_m_cust_name_label) {
		COMP_UI_M_CUST_NAME_LABEL = comp_ui_m_cust_name_label;
	}

	public HtmlInputText getCOMP_UI_M_CUST_NAME() {
		return COMP_UI_M_CUST_NAME;
	}

	public void setCOMP_UI_M_CUST_NAME(HtmlInputText comp_ui_m_cust_name) {
		COMP_UI_M_CUST_NAME = comp_ui_m_cust_name;
	}

	public List<SelectItem> getDrcrList() {
		return drcrList;
	}

	public void setDrcrList(List<SelectItem> drcrList) {
		this.drcrList = drcrList;
	}

	public List<SelectItem> getPostYnList() {
		return postYnList;
	}

	public void setPostYnList(List<SelectItem> postYnList) {
		this.postYnList = postYnList;
	}

	public void onLoad(PhaseEvent event){
		try {
		if(!isOnLoadFlag()){
			PS_IL_DRCR_TREATY_HELPER helper = new PS_IL_DRCR_TREATY_HELPER();
			if(!isPreFormFlag()){
					helper.preForm();
					helper.whenNewFormInstance(this);
					helper.whenNewBlockInstance(this);
					COMP_UI_M_CUST_CODE.resetValue();
			}
			setOnLoadFlag(true);
			setPreFormFlag(true);
		}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	public List<PS_IL_DRCR_TREATY> custCodeList(Object value){
		List<PS_IL_DRCR_TREATY> treatyList = null;
		PS_IL_DRCR_TREATY_HELPER helper = new PS_IL_DRCR_TREATY_HELPER();
		try {
			treatyList = helper.M_CUST_CODELov((String) value);
			if(treatyList==null || treatyList.size()<=0){
				throw new ValidatorException(new FacesMessage("No records to display."));
			}
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return treatyList;
	}
	
	public void M_CUST_CODEValidator(FacesContext context, UIComponent component, Object value){
		try {
			getPS_IL_DRCR_TREATY_BEAN().setUI_M_CUST_CODE((String) value);
			PS_IL_DRCR_TREATY_HELPER helper = new PS_IL_DRCR_TREATY_HELPER();
			helper.M_CUST_CODEWhenValidateItem(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void M_CUST_CODEValidate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public String goBack(){
	
		String	returnString = "PILQ103_APAC_backToRiAlloc";
		return returnString;
	}
	
	/**
	 * 
	 */
	public void getDetails() {
		try {
			if (dataList_PS_IL_DRCR_TREATY!=null && dataList_PS_IL_DRCR_TREATY.size() != 0) {				
				PS_IL_DRCR_TREATY_BEAN = (PS_IL_DRCR_TREATY) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PS_IL_DRCR_TREATY_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Resets all components in this Block
	 */
	public void resetAllComponent(){
		
		COMP_DRCR_DOC_DT.resetValue();
		COMP_DRCR_DOC_DT.resetValue();
		COMP_DRCR_MAIN_ACNT_CODE.resetValue();
		COMP_DRCR_SUB_ACNT_CODE.resetValue();
		COMP_DRCR_DRCR_FLAG.resetValue();
		COMP_DRCR_NARRATION.resetValue();
		COMP_DRCR_POST_YN.resetValue();
		COMP_DRCR_END_NO.resetValue();
		COMP_DRCR_ANLY_CODE_1.resetValue();
		COMP_DRCR_ANLY_CODE_2.resetValue();
		COMP_DRCR_ACTY_CODE_1.resetValue();
		COMP_DRCR_ACTY_CODE_2.resetValue();
		COMP_DRCR_CUST_CODE.resetValue();
		COMP_DRCR_DIVN_CODE.resetValue();
		COMP_DRCR_DEPT_CODE.resetValue();
		COMP_DRCR_CLAIM_NO.resetValue();
		COMP_UI_M_DRCR_TOT_DR.resetValue();
		COMP_UI_M_DRCR_TOT_CR.resetValue();
		
	}
	
	private void resetSelectedRow() {
		Iterator<PS_IL_DRCR_TREATY> iterator = dataList_PS_IL_DRCR_TREATY.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	/**
	 * @return the filterDRCR_LC_AMT
	 */
	public String getFilterDRCR_LC_AMT() {
		return filterDRCR_LC_AMT;
	}

	/**
	 * @param filterDRCR_LC_AMT the filterDRCR_LC_AMT to set
	 */
	public void setFilterDRCR_LC_AMT(String filterDRCR_LC_AMT) {
		this.filterDRCR_LC_AMT = filterDRCR_LC_AMT;
	}

	/**
	 * @return the filterDRCR_SEQ_NO
	 */
	public String getFilterDRCR_SEQ_NO() {
		return filterDRCR_SEQ_NO;
	}

	/**
	 * @param filterDRCR_SEQ_NO the filterDRCR_SEQ_NO to set
	 */
	public void setFilterDRCR_SEQ_NO(String filterDRCR_SEQ_NO) {
		this.filterDRCR_SEQ_NO = filterDRCR_SEQ_NO;
	}

	/**
	 * @return the filterByDRCR_DOC_NO
	 */
	public String getFilterByDRCR_DOC_NO() {
		return filterByDRCR_DOC_NO;
	}

	/**
	 * @param filterByDRCR_DOC_NO the filterByDRCR_DOC_NO to set
	 */
	public void setFilterByDRCR_DOC_NO(String filterByDRCR_DOC_NO) {
		this.filterByDRCR_DOC_NO = filterByDRCR_DOC_NO;
	}

	/**
	 * @return the filterByDRCR_TXN_CODE
	 */
	public String getFilterByDRCR_TXN_CODE() {
		return filterByDRCR_TXN_CODE;
	}

	/**
	 * @param filterByDRCR_TXN_CODE the filterByDRCR_TXN_CODE to set
	 */
	public void setFilterByDRCR_TXN_CODE(String filterByDRCR_TXN_CODE) {
		this.filterByDRCR_TXN_CODE = filterByDRCR_TXN_CODE;
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

	public HtmlCommandButton getCOMP_BUT_FETCH() {
		return COMP_BUT_FETCH;
	}

	public void setCOMP_BUT_FETCH(HtmlCommandButton comp_but_fetch) {
		COMP_BUT_FETCH = comp_but_fetch;
	}

	public HtmlCommandButton getCOMP_BUT_GOBACK() {
		return COMP_BUT_GOBACK;
	}

	public void setCOMP_BUT_GOBACK(HtmlCommandButton comp_but_goback) {
		COMP_BUT_GOBACK = comp_but_goback;
	}
	
	
}
