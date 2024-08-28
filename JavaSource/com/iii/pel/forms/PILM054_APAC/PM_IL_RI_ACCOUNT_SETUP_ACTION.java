package com.iii.pel.forms.PILM054_APAC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_RI_ACCOUNT_SETUP_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_RAS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_RAS_FRZ_FLAG;

	private HtmlOutputLabel COMP_RAS_DIVN_FM_CODE_LABEL;

	private HtmlInputText COMP_RAS_DIVN_FM_CODE;

	private HtmlOutputLabel COMP_RAS_DIVN_TO_CODE_LABEL;

	private HtmlInputText COMP_RAS_DIVN_TO_CODE;

	private HtmlOutputLabel COMP_RAS_DEPT_FM_CODE_LABEL;

	private HtmlInputText COMP_RAS_DEPT_FM_CODE;

	private HtmlOutputLabel COMP_RAS_DEPT_TO_CODE_LABEL;

	private HtmlInputText COMP_RAS_DEPT_TO_CODE;

	private HtmlOutputLabel COMP_RAS_CLASS_FM_CODE_LABEL;

	private HtmlInputText COMP_RAS_CLASS_FM_CODE;

	private HtmlOutputLabel COMP_RAS_CLASS_TO_CODE_LABEL;

	private HtmlInputText COMP_RAS_CLASS_TO_CODE;

	private HtmlOutputLabel COMP_RAS_SRC_BUS_FM_LABEL;

	private HtmlInputText COMP_RAS_SRC_BUS_FM;

	private HtmlOutputLabel COMP_RAS_SRC_BUS_TO_LABEL;

	private HtmlInputText COMP_RAS_SRC_BUS_TO;

	private HtmlOutputLabel COMP_RAS_PROD_FM_CODE_LABEL;

	private HtmlInputText COMP_RAS_PROD_FM_CODE;

	private HtmlOutputLabel COMP_RAS_PROD_TO_CODE_LABEL;

	private HtmlInputText COMP_RAS_PROD_TO_CODE;

	private HtmlOutputLabel COMP_RAS_COVER_FM_CODE_LABEL;

	private HtmlInputText COMP_RAS_COVER_FM_CODE;

	private HtmlOutputLabel COMP_RAS_COVER_TO_CODE_LABEL;

	private HtmlInputText COMP_RAS_COVER_TO_CODE;

	private HtmlOutputLabel COMP_RAS_CUST_CLS_FM_CODE_LABEL;

	private HtmlInputText COMP_RAS_CUST_CLS_FM_CODE;

	private HtmlOutputLabel COMP_RAS_CUST_CLS_TO_CODE_LABEL;

	private HtmlInputText COMP_RAS_CUST_CLS_TO_CODE;

	private HtmlOutputLabel COMP_RAS_NB_REN_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_RAS_NB_REN_TYPE;

	private HtmlOutputLabel COMP_RAS_FORCE_DIVN_YN_LABEL;

	private HtmlSelectOneMenu COMP_RAS_FORCE_DIVN_YN;

	private HtmlOutputLabel COMP_RAS_SETUP_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_RAS_SETUP_TYPE;

	private HtmlOutputLabel COMP_RAS_FORCE_DEPT_YN_LABEL;

	private HtmlSelectOneMenu COMP_RAS_FORCE_DEPT_YN;

	private HtmlOutputLabel COMP_RAS_TREATY_TYPE_LABEL;

	private HtmlInputText COMP_RAS_TREATY_TYPE;

	private HtmlOutputLabel COMP_RAS_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_RAS_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_RAS_MAIN_ACNT_CODE_DESC_LABEL;

	private HtmlInputText COMP_RAS_MAIN_ACNT_CODE_DESC;

	private HtmlOutputLabel COMP_RAS_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_RAS_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_RAS_SUB_ACNT_CODE_DESC_LABEL;

	private HtmlInputText COMP_RAS_SUB_ACNT_CODE_DESC;

	private HtmlOutputLabel COMP_RAS_DIVN_CODE_LABEL;

	private HtmlInputText COMP_RAS_DIVN_CODE;

	private HtmlOutputLabel COMP_RAS_DIVN_CODE_DESC_LABEL;

	private HtmlInputText COMP_RAS_DIVN_CODE_DESC;

	private HtmlOutputLabel COMP_RAS_DEPT_CODE_LABEL;

	private HtmlInputText COMP_RAS_DEPT_CODE;

	private HtmlOutputLabel COMP_RAS_DEPT_CODE_DESC_LABEL;

	private HtmlInputText COMP_RAS_DEPT_CODE_DESC;

	private HtmlOutputLabel COMP_RAS_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_RAS_ANLY_CODE_1;

	private HtmlOutputLabel COMP_RAS_ANLY_CODE_1_DESC_LABEL;

	private HtmlInputText COMP_RAS_ANLY_CODE_1_DESC;

	private HtmlOutputLabel COMP_RAS_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_RAS_ANLY_CODE_2;

	private HtmlOutputLabel COMP_RAS_ANLY_CODE_2_DESC_LABEL;

	private HtmlInputText COMP_RAS_ANLY_CODE_2_DESC;

	private HtmlOutputLabel COMP_RAS_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_RAS_ACTY_CODE_1;

	private HtmlOutputLabel COMP_RAS_ACTY_CODE_1_DESC_LABEL;

	private HtmlInputText COMP_RAS_ACTY_CODE_1_DESC;

	private HtmlOutputLabel COMP_RAS_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_RAS_ACTY_CODE_2;

	private HtmlOutputLabel COMP_RAS_ACTY_CODE_2_DESC_LABEL;

	private HtmlInputText COMP_RAS_ACTY_CODE_2_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_PROD_TO_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_ACNT_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_SUB_ACNT_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_RAS_ANLY_CODE_1;

	private HtmlCommandButton COMP_UI_M_BUT_ANLY_CODE_2;

	private HtmlCommandButton COMP_UI_M_BUT_ACTY_CODE_1;

	private HtmlCommandButton COMP_UI_M_BUT_ACTY_CODE_2;

	private HtmlCommandButton COMP_UI_M_BUT_CUST_CLS_FM_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_CUST_CLS_TO_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_RAS_DIVN_FM;

	private HtmlCommandButton COMP_UI_M_BUT_RAS_DEPT_FM;

	private HtmlCommandButton COMP_UI_M_BUT_RAS_PROD_FM;

	private HtmlCommandButton COMP_PUSH_BUTTON249;

	private HtmlCommandButton COMP_UI_M_BUT_RAS_DIVN_TO;

	private HtmlCommandButton COMP_UI_M_BUT_RAS_DEPT_TO;

	private PM_IL_RI_ACCOUNT_SETUP PM_IL_RI_ACCOUNT_SETUP_BEAN;
	
	private PM_IL_RI_ACCOUNT_SETUP_HELPER helper;
	
	private String mnAcctCode = null;
	
	private String sbAcctCode = null;
	
	private String divnCode = null;
	
	private ArrayList<SelectItem> renBusinessValList = new ArrayList<SelectItem>();
	
	private ArrayList<SelectItem> setupTypeValList = new ArrayList<SelectItem>();
	
	private ArrayList<SelectItem> divValList = new ArrayList<SelectItem>();
	
	private ArrayList<SelectItem> deptValList = new ArrayList<SelectItem>();
	
	private boolean onLoadingFlag = false;
	
	private boolean update = false;
	
	public PILM054_APAC_COMPOSITE_ACTION compositeAction =null;
	
	List<LovBean> suggestionList = null;

	public PM_IL_RI_ACCOUNT_SETUP_ACTION() {
		helper = new PM_IL_RI_ACCOUNT_SETUP_HELPER();
		PM_IL_RI_ACCOUNT_SETUP_BEAN = new PM_IL_RI_ACCOUNT_SETUP();
		DelegateDb dbHelper = new DelegateDb();
		renBusinessValList = dbHelper.selectValueForComboBox("PILM054_APAC",
				"PM_IL_RI_ACCOUNT_SETUP",
				"PM_IL_RI_ACCOUNT_SETUP.RAS_NB_REN_TYPE");
		
		setupTypeValList = dbHelper.selectValueForComboBox("PILM054_APAC",
				"PM_IL_RI_ACCOUNT_SETUP",
				"PM_IL_RI_ACCOUNT_SETUP.RAS_SETUP_TYPE");
		
		divValList = dbHelper.selectValueForComboBox("PILM054_APAC",
				"PM_IL_RI_ACCOUNT_SETUP",
				"PM_IL_RI_ACCOUNT_SETUP.RAS_FORCE_DIVN_YN");
		
		deptValList = dbHelper.selectValueForComboBox("PILM054_APAC",
				"PM_IL_RI_ACCOUNT_SETUP",
				"PM_IL_RI_ACCOUNT_SETUP.RAS_FORCE_DEPT_YN");
		
	}
	
	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event) {
		try {
			PILM054_APAC_Helper helper = new PILM054_APAC_Helper();
			if (isFormFlag()) {
				//preForm(null);
				//whenNewFormInstance();
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				helper.whenNewBlockInstance(PM_IL_RI_ACCOUNT_SETUP_BEAN);
				helper.executeQuery(PM_IL_RI_ACCOUNT_SETUP_BEAN);
				helper.whenNewRecordInstance();
				if (PM_IL_RI_ACCOUNT_SETUP_BEAN.getROWID() != null) {
					helper.pilm054_apac_pm_il_ri_account_setup_post_query(compositeAction);
				} else {
					helper.whenCreateRecord(this);
				}
				
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	

	public boolean isOnLoadingFlag() {
		return onLoadingFlag;
	}

	public void setOnLoadingFlag(boolean onLoadingFlag) {
		this.onLoadingFlag = onLoadingFlag;
	}

	public HtmlOutputLabel getCOMP_RAS_FRZ_FLAG_LABEL() {
		return COMP_RAS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_RAS_FRZ_FLAG() {
		return COMP_RAS_FRZ_FLAG;
	}

	public void setCOMP_RAS_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_RAS_FRZ_FLAG_LABEL) {
		this.COMP_RAS_FRZ_FLAG_LABEL = COMP_RAS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_RAS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_RAS_FRZ_FLAG) {
		this.COMP_RAS_FRZ_FLAG = COMP_RAS_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_RAS_DIVN_FM_CODE_LABEL() {
		return COMP_RAS_DIVN_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_DIVN_FM_CODE() {
		return COMP_RAS_DIVN_FM_CODE;
	}

	public void setCOMP_RAS_DIVN_FM_CODE_LABEL(HtmlOutputLabel COMP_RAS_DIVN_FM_CODE_LABEL) {
		this.COMP_RAS_DIVN_FM_CODE_LABEL = COMP_RAS_DIVN_FM_CODE_LABEL;
	}

	public void setCOMP_RAS_DIVN_FM_CODE(HtmlInputText COMP_RAS_DIVN_FM_CODE) {
		this.COMP_RAS_DIVN_FM_CODE = COMP_RAS_DIVN_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_DIVN_TO_CODE_LABEL() {
		return COMP_RAS_DIVN_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_DIVN_TO_CODE() {
		return COMP_RAS_DIVN_TO_CODE;
	}

	public void setCOMP_RAS_DIVN_TO_CODE_LABEL(HtmlOutputLabel COMP_RAS_DIVN_TO_CODE_LABEL) {
		this.COMP_RAS_DIVN_TO_CODE_LABEL = COMP_RAS_DIVN_TO_CODE_LABEL;
	}

	public void setCOMP_RAS_DIVN_TO_CODE(HtmlInputText COMP_RAS_DIVN_TO_CODE) {
		this.COMP_RAS_DIVN_TO_CODE = COMP_RAS_DIVN_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_DEPT_FM_CODE_LABEL() {
		return COMP_RAS_DEPT_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_DEPT_FM_CODE() {
		return COMP_RAS_DEPT_FM_CODE;
	}

	public void setCOMP_RAS_DEPT_FM_CODE_LABEL(HtmlOutputLabel COMP_RAS_DEPT_FM_CODE_LABEL) {
		this.COMP_RAS_DEPT_FM_CODE_LABEL = COMP_RAS_DEPT_FM_CODE_LABEL;
	}

	public void setCOMP_RAS_DEPT_FM_CODE(HtmlInputText COMP_RAS_DEPT_FM_CODE) {
		this.COMP_RAS_DEPT_FM_CODE = COMP_RAS_DEPT_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_DEPT_TO_CODE_LABEL() {
		return COMP_RAS_DEPT_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_DEPT_TO_CODE() {
		return COMP_RAS_DEPT_TO_CODE;
	}

	public void setCOMP_RAS_DEPT_TO_CODE_LABEL(HtmlOutputLabel COMP_RAS_DEPT_TO_CODE_LABEL) {
		this.COMP_RAS_DEPT_TO_CODE_LABEL = COMP_RAS_DEPT_TO_CODE_LABEL;
	}

	public void setCOMP_RAS_DEPT_TO_CODE(HtmlInputText COMP_RAS_DEPT_TO_CODE) {
		this.COMP_RAS_DEPT_TO_CODE = COMP_RAS_DEPT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_CLASS_FM_CODE_LABEL() {
		return COMP_RAS_CLASS_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_CLASS_FM_CODE() {
		return COMP_RAS_CLASS_FM_CODE;
	}

	public void setCOMP_RAS_CLASS_FM_CODE_LABEL(HtmlOutputLabel COMP_RAS_CLASS_FM_CODE_LABEL) {
		this.COMP_RAS_CLASS_FM_CODE_LABEL = COMP_RAS_CLASS_FM_CODE_LABEL;
	}

	public void setCOMP_RAS_CLASS_FM_CODE(HtmlInputText COMP_RAS_CLASS_FM_CODE) {
		this.COMP_RAS_CLASS_FM_CODE = COMP_RAS_CLASS_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_CLASS_TO_CODE_LABEL() {
		return COMP_RAS_CLASS_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_CLASS_TO_CODE() {
		return COMP_RAS_CLASS_TO_CODE;
	}

	public void setCOMP_RAS_CLASS_TO_CODE_LABEL(HtmlOutputLabel COMP_RAS_CLASS_TO_CODE_LABEL) {
		this.COMP_RAS_CLASS_TO_CODE_LABEL = COMP_RAS_CLASS_TO_CODE_LABEL;
	}

	public void setCOMP_RAS_CLASS_TO_CODE(HtmlInputText COMP_RAS_CLASS_TO_CODE) {
		this.COMP_RAS_CLASS_TO_CODE = COMP_RAS_CLASS_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_SRC_BUS_FM_LABEL() {
		return COMP_RAS_SRC_BUS_FM_LABEL;
	}

	public HtmlInputText getCOMP_RAS_SRC_BUS_FM() {
		return COMP_RAS_SRC_BUS_FM;
	}

	public void setCOMP_RAS_SRC_BUS_FM_LABEL(HtmlOutputLabel COMP_RAS_SRC_BUS_FM_LABEL) {
		this.COMP_RAS_SRC_BUS_FM_LABEL = COMP_RAS_SRC_BUS_FM_LABEL;
	}

	public void setCOMP_RAS_SRC_BUS_FM(HtmlInputText COMP_RAS_SRC_BUS_FM) {
		this.COMP_RAS_SRC_BUS_FM = COMP_RAS_SRC_BUS_FM;
	}

	public HtmlOutputLabel getCOMP_RAS_SRC_BUS_TO_LABEL() {
		return COMP_RAS_SRC_BUS_TO_LABEL;
	}

	public HtmlInputText getCOMP_RAS_SRC_BUS_TO() {
		return COMP_RAS_SRC_BUS_TO;
	}

	public void setCOMP_RAS_SRC_BUS_TO_LABEL(HtmlOutputLabel COMP_RAS_SRC_BUS_TO_LABEL) {
		this.COMP_RAS_SRC_BUS_TO_LABEL = COMP_RAS_SRC_BUS_TO_LABEL;
	}

	public void setCOMP_RAS_SRC_BUS_TO(HtmlInputText COMP_RAS_SRC_BUS_TO) {
		this.COMP_RAS_SRC_BUS_TO = COMP_RAS_SRC_BUS_TO;
	}

	public HtmlOutputLabel getCOMP_RAS_PROD_FM_CODE_LABEL() {
		return COMP_RAS_PROD_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_PROD_FM_CODE() {
		return COMP_RAS_PROD_FM_CODE;
	}

	public void setCOMP_RAS_PROD_FM_CODE_LABEL(HtmlOutputLabel COMP_RAS_PROD_FM_CODE_LABEL) {
		this.COMP_RAS_PROD_FM_CODE_LABEL = COMP_RAS_PROD_FM_CODE_LABEL;
	}

	public void setCOMP_RAS_PROD_FM_CODE(HtmlInputText COMP_RAS_PROD_FM_CODE) {
		this.COMP_RAS_PROD_FM_CODE = COMP_RAS_PROD_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_PROD_TO_CODE_LABEL() {
		return COMP_RAS_PROD_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_PROD_TO_CODE() {
		return COMP_RAS_PROD_TO_CODE;
	}

	public void setCOMP_RAS_PROD_TO_CODE_LABEL(HtmlOutputLabel COMP_RAS_PROD_TO_CODE_LABEL) {
		this.COMP_RAS_PROD_TO_CODE_LABEL = COMP_RAS_PROD_TO_CODE_LABEL;
	}

	public void setCOMP_RAS_PROD_TO_CODE(HtmlInputText COMP_RAS_PROD_TO_CODE) {
		this.COMP_RAS_PROD_TO_CODE = COMP_RAS_PROD_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_COVER_FM_CODE_LABEL() {
		return COMP_RAS_COVER_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_COVER_FM_CODE() {
		return COMP_RAS_COVER_FM_CODE;
	}

	public void setCOMP_RAS_COVER_FM_CODE_LABEL(HtmlOutputLabel COMP_RAS_COVER_FM_CODE_LABEL) {
		this.COMP_RAS_COVER_FM_CODE_LABEL = COMP_RAS_COVER_FM_CODE_LABEL;
	}

	public void setCOMP_RAS_COVER_FM_CODE(HtmlInputText COMP_RAS_COVER_FM_CODE) {
		this.COMP_RAS_COVER_FM_CODE = COMP_RAS_COVER_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_COVER_TO_CODE_LABEL() {
		return COMP_RAS_COVER_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_COVER_TO_CODE() {
		return COMP_RAS_COVER_TO_CODE;
	}

	public void setCOMP_RAS_COVER_TO_CODE_LABEL(HtmlOutputLabel COMP_RAS_COVER_TO_CODE_LABEL) {
		this.COMP_RAS_COVER_TO_CODE_LABEL = COMP_RAS_COVER_TO_CODE_LABEL;
	}

	public void setCOMP_RAS_COVER_TO_CODE(HtmlInputText COMP_RAS_COVER_TO_CODE) {
		this.COMP_RAS_COVER_TO_CODE = COMP_RAS_COVER_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_CUST_CLS_FM_CODE_LABEL() {
		return COMP_RAS_CUST_CLS_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_CUST_CLS_FM_CODE() {
		return COMP_RAS_CUST_CLS_FM_CODE;
	}

	public void setCOMP_RAS_CUST_CLS_FM_CODE_LABEL(HtmlOutputLabel COMP_RAS_CUST_CLS_FM_CODE_LABEL) {
		this.COMP_RAS_CUST_CLS_FM_CODE_LABEL = COMP_RAS_CUST_CLS_FM_CODE_LABEL;
	}

	public void setCOMP_RAS_CUST_CLS_FM_CODE(HtmlInputText COMP_RAS_CUST_CLS_FM_CODE) {
		this.COMP_RAS_CUST_CLS_FM_CODE = COMP_RAS_CUST_CLS_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_CUST_CLS_TO_CODE_LABEL() {
		return COMP_RAS_CUST_CLS_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_CUST_CLS_TO_CODE() {
		return COMP_RAS_CUST_CLS_TO_CODE;
	}

	public void setCOMP_RAS_CUST_CLS_TO_CODE_LABEL(HtmlOutputLabel COMP_RAS_CUST_CLS_TO_CODE_LABEL) {
		this.COMP_RAS_CUST_CLS_TO_CODE_LABEL = COMP_RAS_CUST_CLS_TO_CODE_LABEL;
	}

	public void setCOMP_RAS_CUST_CLS_TO_CODE(HtmlInputText COMP_RAS_CUST_CLS_TO_CODE) {
		this.COMP_RAS_CUST_CLS_TO_CODE = COMP_RAS_CUST_CLS_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_NB_REN_TYPE_LABEL() {
		return COMP_RAS_NB_REN_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_RAS_NB_REN_TYPE() {
		return COMP_RAS_NB_REN_TYPE;
	}

	public void setCOMP_RAS_NB_REN_TYPE_LABEL(HtmlOutputLabel COMP_RAS_NB_REN_TYPE_LABEL) {
		this.COMP_RAS_NB_REN_TYPE_LABEL = COMP_RAS_NB_REN_TYPE_LABEL;
	}

	public void setCOMP_RAS_NB_REN_TYPE(HtmlSelectOneMenu COMP_RAS_NB_REN_TYPE) {
		this.COMP_RAS_NB_REN_TYPE = COMP_RAS_NB_REN_TYPE;
	}

	public HtmlOutputLabel getCOMP_RAS_FORCE_DIVN_YN_LABEL() {
		return COMP_RAS_FORCE_DIVN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_RAS_FORCE_DIVN_YN() {
		return COMP_RAS_FORCE_DIVN_YN;
	}

	public void setCOMP_RAS_FORCE_DIVN_YN_LABEL(HtmlOutputLabel COMP_RAS_FORCE_DIVN_YN_LABEL) {
		this.COMP_RAS_FORCE_DIVN_YN_LABEL = COMP_RAS_FORCE_DIVN_YN_LABEL;
	}

	public void setCOMP_RAS_FORCE_DIVN_YN(HtmlSelectOneMenu COMP_RAS_FORCE_DIVN_YN) {
		this.COMP_RAS_FORCE_DIVN_YN = COMP_RAS_FORCE_DIVN_YN;
	}

	public HtmlOutputLabel getCOMP_RAS_SETUP_TYPE_LABEL() {
		return COMP_RAS_SETUP_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_RAS_SETUP_TYPE() {
		return COMP_RAS_SETUP_TYPE;
	}

	public void setCOMP_RAS_SETUP_TYPE_LABEL(HtmlOutputLabel COMP_RAS_SETUP_TYPE_LABEL) {
		this.COMP_RAS_SETUP_TYPE_LABEL = COMP_RAS_SETUP_TYPE_LABEL;
	}

	public void setCOMP_RAS_SETUP_TYPE(HtmlSelectOneMenu COMP_RAS_SETUP_TYPE) {
		this.COMP_RAS_SETUP_TYPE = COMP_RAS_SETUP_TYPE;
	}

	public HtmlOutputLabel getCOMP_RAS_FORCE_DEPT_YN_LABEL() {
		return COMP_RAS_FORCE_DEPT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_RAS_FORCE_DEPT_YN() {
		return COMP_RAS_FORCE_DEPT_YN;
	}

	public void setCOMP_RAS_FORCE_DEPT_YN_LABEL(HtmlOutputLabel COMP_RAS_FORCE_DEPT_YN_LABEL) {
		this.COMP_RAS_FORCE_DEPT_YN_LABEL = COMP_RAS_FORCE_DEPT_YN_LABEL;
	}

	public void setCOMP_RAS_FORCE_DEPT_YN(HtmlSelectOneMenu COMP_RAS_FORCE_DEPT_YN) {
		this.COMP_RAS_FORCE_DEPT_YN = COMP_RAS_FORCE_DEPT_YN;
	}

	public HtmlOutputLabel getCOMP_RAS_TREATY_TYPE_LABEL() {
		return COMP_RAS_TREATY_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_TREATY_TYPE() {
		return COMP_RAS_TREATY_TYPE;
	}

	public void setCOMP_RAS_TREATY_TYPE_LABEL(HtmlOutputLabel COMP_RAS_TREATY_TYPE_LABEL) {
		this.COMP_RAS_TREATY_TYPE_LABEL = COMP_RAS_TREATY_TYPE_LABEL;
	}

	public void setCOMP_RAS_TREATY_TYPE(HtmlInputText COMP_RAS_TREATY_TYPE) {
		this.COMP_RAS_TREATY_TYPE = COMP_RAS_TREATY_TYPE;
	}

	public HtmlOutputLabel getCOMP_RAS_MAIN_ACNT_CODE_LABEL() {
		return COMP_RAS_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_MAIN_ACNT_CODE() {
		return COMP_RAS_MAIN_ACNT_CODE;
	}

	public void setCOMP_RAS_MAIN_ACNT_CODE_LABEL(HtmlOutputLabel COMP_RAS_MAIN_ACNT_CODE_LABEL) {
		this.COMP_RAS_MAIN_ACNT_CODE_LABEL = COMP_RAS_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_RAS_MAIN_ACNT_CODE(HtmlInputText COMP_RAS_MAIN_ACNT_CODE) {
		this.COMP_RAS_MAIN_ACNT_CODE = COMP_RAS_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_MAIN_ACNT_CODE_DESC_LABEL() {
		return COMP_RAS_MAIN_ACNT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RAS_MAIN_ACNT_CODE_DESC() {
		return COMP_RAS_MAIN_ACNT_CODE_DESC;
	}

	public void setCOMP_RAS_MAIN_ACNT_CODE_DESC_LABEL(HtmlOutputLabel COMP_RAS_MAIN_ACNT_CODE_DESC_LABEL) {
		this.COMP_RAS_MAIN_ACNT_CODE_DESC_LABEL = COMP_RAS_MAIN_ACNT_CODE_DESC_LABEL;
	}

	public void setCOMP_RAS_MAIN_ACNT_CODE_DESC(HtmlInputText COMP_RAS_MAIN_ACNT_CODE_DESC) {
		this.COMP_RAS_MAIN_ACNT_CODE_DESC = COMP_RAS_MAIN_ACNT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_RAS_SUB_ACNT_CODE_LABEL() {
		return COMP_RAS_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_SUB_ACNT_CODE() {
		return COMP_RAS_SUB_ACNT_CODE;
	}

	public void setCOMP_RAS_SUB_ACNT_CODE_LABEL(HtmlOutputLabel COMP_RAS_SUB_ACNT_CODE_LABEL) {
		this.COMP_RAS_SUB_ACNT_CODE_LABEL = COMP_RAS_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_RAS_SUB_ACNT_CODE(HtmlInputText COMP_RAS_SUB_ACNT_CODE) {
		this.COMP_RAS_SUB_ACNT_CODE = COMP_RAS_SUB_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_SUB_ACNT_CODE_DESC_LABEL() {
		return COMP_RAS_SUB_ACNT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RAS_SUB_ACNT_CODE_DESC() {
		return COMP_RAS_SUB_ACNT_CODE_DESC;
	}

	public void setCOMP_RAS_SUB_ACNT_CODE_DESC_LABEL(HtmlOutputLabel COMP_RAS_SUB_ACNT_CODE_DESC_LABEL) {
		this.COMP_RAS_SUB_ACNT_CODE_DESC_LABEL = COMP_RAS_SUB_ACNT_CODE_DESC_LABEL;
	}

	public void setCOMP_RAS_SUB_ACNT_CODE_DESC(HtmlInputText COMP_RAS_SUB_ACNT_CODE_DESC) {
		this.COMP_RAS_SUB_ACNT_CODE_DESC = COMP_RAS_SUB_ACNT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_RAS_DIVN_CODE_LABEL() {
		return COMP_RAS_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_DIVN_CODE() {
		return COMP_RAS_DIVN_CODE;
	}

	public void setCOMP_RAS_DIVN_CODE_LABEL(HtmlOutputLabel COMP_RAS_DIVN_CODE_LABEL) {
		this.COMP_RAS_DIVN_CODE_LABEL = COMP_RAS_DIVN_CODE_LABEL;
	}

	public void setCOMP_RAS_DIVN_CODE(HtmlInputText COMP_RAS_DIVN_CODE) {
		this.COMP_RAS_DIVN_CODE = COMP_RAS_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_DIVN_CODE_DESC_LABEL() {
		return COMP_RAS_DIVN_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RAS_DIVN_CODE_DESC() {
		return COMP_RAS_DIVN_CODE_DESC;
	}

	public void setCOMP_RAS_DIVN_CODE_DESC_LABEL(HtmlOutputLabel COMP_RAS_DIVN_CODE_DESC_LABEL) {
		this.COMP_RAS_DIVN_CODE_DESC_LABEL = COMP_RAS_DIVN_CODE_DESC_LABEL;
	}

	public void setCOMP_RAS_DIVN_CODE_DESC(HtmlInputText COMP_RAS_DIVN_CODE_DESC) {
		this.COMP_RAS_DIVN_CODE_DESC = COMP_RAS_DIVN_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_RAS_DEPT_CODE_LABEL() {
		return COMP_RAS_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RAS_DEPT_CODE() {
		return COMP_RAS_DEPT_CODE;
	}

	public void setCOMP_RAS_DEPT_CODE_LABEL(HtmlOutputLabel COMP_RAS_DEPT_CODE_LABEL) {
		this.COMP_RAS_DEPT_CODE_LABEL = COMP_RAS_DEPT_CODE_LABEL;
	}

	public void setCOMP_RAS_DEPT_CODE(HtmlInputText COMP_RAS_DEPT_CODE) {
		this.COMP_RAS_DEPT_CODE = COMP_RAS_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_RAS_DEPT_CODE_DESC_LABEL() {
		return COMP_RAS_DEPT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RAS_DEPT_CODE_DESC() {
		return COMP_RAS_DEPT_CODE_DESC;
	}

	public void setCOMP_RAS_DEPT_CODE_DESC_LABEL(HtmlOutputLabel COMP_RAS_DEPT_CODE_DESC_LABEL) {
		this.COMP_RAS_DEPT_CODE_DESC_LABEL = COMP_RAS_DEPT_CODE_DESC_LABEL;
	}

	public void setCOMP_RAS_DEPT_CODE_DESC(HtmlInputText COMP_RAS_DEPT_CODE_DESC) {
		this.COMP_RAS_DEPT_CODE_DESC = COMP_RAS_DEPT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_RAS_ANLY_CODE_1_LABEL() {
		return COMP_RAS_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_RAS_ANLY_CODE_1() {
		return COMP_RAS_ANLY_CODE_1;
	}

	public void setCOMP_RAS_ANLY_CODE_1_LABEL(HtmlOutputLabel COMP_RAS_ANLY_CODE_1_LABEL) {
		this.COMP_RAS_ANLY_CODE_1_LABEL = COMP_RAS_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_RAS_ANLY_CODE_1(HtmlInputText COMP_RAS_ANLY_CODE_1) {
		this.COMP_RAS_ANLY_CODE_1 = COMP_RAS_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_RAS_ANLY_CODE_1_DESC_LABEL() {
		return COMP_RAS_ANLY_CODE_1_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RAS_ANLY_CODE_1_DESC() {
		return COMP_RAS_ANLY_CODE_1_DESC;
	}

	public void setCOMP_RAS_ANLY_CODE_1_DESC_LABEL(HtmlOutputLabel COMP_RAS_ANLY_CODE_1_DESC_LABEL) {
		this.COMP_RAS_ANLY_CODE_1_DESC_LABEL = COMP_RAS_ANLY_CODE_1_DESC_LABEL;
	}

	public void setCOMP_RAS_ANLY_CODE_1_DESC(HtmlInputText COMP_RAS_ANLY_CODE_1_DESC) {
		this.COMP_RAS_ANLY_CODE_1_DESC = COMP_RAS_ANLY_CODE_1_DESC;
	}

	public HtmlOutputLabel getCOMP_RAS_ANLY_CODE_2_LABEL() {
		return COMP_RAS_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_RAS_ANLY_CODE_2() {
		return COMP_RAS_ANLY_CODE_2;
	}

	public void setCOMP_RAS_ANLY_CODE_2_LABEL(HtmlOutputLabel COMP_RAS_ANLY_CODE_2_LABEL) {
		this.COMP_RAS_ANLY_CODE_2_LABEL = COMP_RAS_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_RAS_ANLY_CODE_2(HtmlInputText COMP_RAS_ANLY_CODE_2) {
		this.COMP_RAS_ANLY_CODE_2 = COMP_RAS_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_RAS_ANLY_CODE_2_DESC_LABEL() {
		return COMP_RAS_ANLY_CODE_2_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RAS_ANLY_CODE_2_DESC() {
		return COMP_RAS_ANLY_CODE_2_DESC;
	}

	public void setCOMP_RAS_ANLY_CODE_2_DESC_LABEL(HtmlOutputLabel COMP_RAS_ANLY_CODE_2_DESC_LABEL) {
		this.COMP_RAS_ANLY_CODE_2_DESC_LABEL = COMP_RAS_ANLY_CODE_2_DESC_LABEL;
	}

	public void setCOMP_RAS_ANLY_CODE_2_DESC(HtmlInputText COMP_RAS_ANLY_CODE_2_DESC) {
		this.COMP_RAS_ANLY_CODE_2_DESC = COMP_RAS_ANLY_CODE_2_DESC;
	}

	public HtmlOutputLabel getCOMP_RAS_ACTY_CODE_1_LABEL() {
		return COMP_RAS_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_RAS_ACTY_CODE_1() {
		return COMP_RAS_ACTY_CODE_1;
	}

	public void setCOMP_RAS_ACTY_CODE_1_LABEL(HtmlOutputLabel COMP_RAS_ACTY_CODE_1_LABEL) {
		this.COMP_RAS_ACTY_CODE_1_LABEL = COMP_RAS_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_RAS_ACTY_CODE_1(HtmlInputText COMP_RAS_ACTY_CODE_1) {
		this.COMP_RAS_ACTY_CODE_1 = COMP_RAS_ACTY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_RAS_ACTY_CODE_1_DESC_LABEL() {
		return COMP_RAS_ACTY_CODE_1_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RAS_ACTY_CODE_1_DESC() {
		return COMP_RAS_ACTY_CODE_1_DESC;
	}

	public void setCOMP_RAS_ACTY_CODE_1_DESC_LABEL(HtmlOutputLabel COMP_RAS_ACTY_CODE_1_DESC_LABEL) {
		this.COMP_RAS_ACTY_CODE_1_DESC_LABEL = COMP_RAS_ACTY_CODE_1_DESC_LABEL;
	}

	public void setCOMP_RAS_ACTY_CODE_1_DESC(HtmlInputText COMP_RAS_ACTY_CODE_1_DESC) {
		this.COMP_RAS_ACTY_CODE_1_DESC = COMP_RAS_ACTY_CODE_1_DESC;
	}

	public HtmlOutputLabel getCOMP_RAS_ACTY_CODE_2_LABEL() {
		return COMP_RAS_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_RAS_ACTY_CODE_2() {
		return COMP_RAS_ACTY_CODE_2;
	}

	public void setCOMP_RAS_ACTY_CODE_2_LABEL(HtmlOutputLabel COMP_RAS_ACTY_CODE_2_LABEL) {
		this.COMP_RAS_ACTY_CODE_2_LABEL = COMP_RAS_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_RAS_ACTY_CODE_2(HtmlInputText COMP_RAS_ACTY_CODE_2) {
		this.COMP_RAS_ACTY_CODE_2 = COMP_RAS_ACTY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_RAS_ACTY_CODE_2_DESC_LABEL() {
		return COMP_RAS_ACTY_CODE_2_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RAS_ACTY_CODE_2_DESC() {
		return COMP_RAS_ACTY_CODE_2_DESC;
	}

	public void setCOMP_RAS_ACTY_CODE_2_DESC_LABEL(HtmlOutputLabel COMP_RAS_ACTY_CODE_2_DESC_LABEL) {
		this.COMP_RAS_ACTY_CODE_2_DESC_LABEL = COMP_RAS_ACTY_CODE_2_DESC_LABEL;
	}

	public void setCOMP_RAS_ACTY_CODE_2_DESC(HtmlInputText COMP_RAS_ACTY_CODE_2_DESC) {
		this.COMP_RAS_ACTY_CODE_2_DESC = COMP_RAS_ACTY_CODE_2_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROD_TO_CODE() {
		return COMP_UI_M_BUT_PROD_TO_CODE;
	}

	public void setCOMP_UI_M_BUT_PROD_TO_CODE(HtmlCommandButton COMP_UI_M_BUT_PROD_TO_CODE) {
		this.COMP_UI_M_BUT_PROD_TO_CODE = COMP_UI_M_BUT_PROD_TO_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_ACNT_CODE() {
		return COMP_UI_M_BUT_MAIN_ACNT_CODE;
	}

	public void setCOMP_UI_M_BUT_MAIN_ACNT_CODE(HtmlCommandButton COMP_UI_M_BUT_MAIN_ACNT_CODE) {
		this.COMP_UI_M_BUT_MAIN_ACNT_CODE = COMP_UI_M_BUT_MAIN_ACNT_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SUB_ACNT_CODE() {
		return COMP_UI_M_BUT_SUB_ACNT_CODE;
	}

	public void setCOMP_UI_M_BUT_SUB_ACNT_CODE(HtmlCommandButton COMP_UI_M_BUT_SUB_ACNT_CODE) {
		this.COMP_UI_M_BUT_SUB_ACNT_CODE = COMP_UI_M_BUT_SUB_ACNT_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DIVN_CODE() {
		return COMP_UI_M_BUT_DIVN_CODE;
	}

	public void setCOMP_UI_M_BUT_DIVN_CODE(HtmlCommandButton COMP_UI_M_BUT_DIVN_CODE) {
		this.COMP_UI_M_BUT_DIVN_CODE = COMP_UI_M_BUT_DIVN_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEPT_CODE() {
		return COMP_UI_M_BUT_DEPT_CODE;
	}

	public void setCOMP_UI_M_BUT_DEPT_CODE(HtmlCommandButton COMP_UI_M_BUT_DEPT_CODE) {
		this.COMP_UI_M_BUT_DEPT_CODE = COMP_UI_M_BUT_DEPT_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_RAS_ANLY_CODE_1() {
		return COMP_UI_M_BUT_RAS_ANLY_CODE_1;
	}

	public void setCOMP_UI_M_BUT_RAS_ANLY_CODE_1(HtmlCommandButton COMP_UI_M_BUT_RAS_ANLY_CODE_1) {
		this.COMP_UI_M_BUT_RAS_ANLY_CODE_1 = COMP_UI_M_BUT_RAS_ANLY_CODE_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ANLY_CODE_2() {
		return COMP_UI_M_BUT_ANLY_CODE_2;
	}

	public void setCOMP_UI_M_BUT_ANLY_CODE_2(HtmlCommandButton COMP_UI_M_BUT_ANLY_CODE_2) {
		this.COMP_UI_M_BUT_ANLY_CODE_2 = COMP_UI_M_BUT_ANLY_CODE_2;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ACTY_CODE_1() {
		return COMP_UI_M_BUT_ACTY_CODE_1;
	}

	public void setCOMP_UI_M_BUT_ACTY_CODE_1(HtmlCommandButton COMP_UI_M_BUT_ACTY_CODE_1) {
		this.COMP_UI_M_BUT_ACTY_CODE_1 = COMP_UI_M_BUT_ACTY_CODE_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ACTY_CODE_2() {
		return COMP_UI_M_BUT_ACTY_CODE_2;
	}

	public void setCOMP_UI_M_BUT_ACTY_CODE_2(HtmlCommandButton COMP_UI_M_BUT_ACTY_CODE_2) {
		this.COMP_UI_M_BUT_ACTY_CODE_2 = COMP_UI_M_BUT_ACTY_CODE_2;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_CLS_FM_LOV() {
		return COMP_UI_M_BUT_CUST_CLS_FM_LOV;
	}

	public void setCOMP_UI_M_BUT_CUST_CLS_FM_LOV(HtmlCommandButton COMP_UI_M_BUT_CUST_CLS_FM_LOV) {
		this.COMP_UI_M_BUT_CUST_CLS_FM_LOV = COMP_UI_M_BUT_CUST_CLS_FM_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_CLS_TO_LOV() {
		return COMP_UI_M_BUT_CUST_CLS_TO_LOV;
	}

	public void setCOMP_UI_M_BUT_CUST_CLS_TO_LOV(HtmlCommandButton COMP_UI_M_BUT_CUST_CLS_TO_LOV) {
		this.COMP_UI_M_BUT_CUST_CLS_TO_LOV = COMP_UI_M_BUT_CUST_CLS_TO_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_RAS_DIVN_FM() {
		return COMP_UI_M_BUT_RAS_DIVN_FM;
	}

	public void setCOMP_UI_M_BUT_RAS_DIVN_FM(HtmlCommandButton COMP_UI_M_BUT_RAS_DIVN_FM) {
		this.COMP_UI_M_BUT_RAS_DIVN_FM = COMP_UI_M_BUT_RAS_DIVN_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_RAS_DEPT_FM() {
		return COMP_UI_M_BUT_RAS_DEPT_FM;
	}

	public void setCOMP_UI_M_BUT_RAS_DEPT_FM(HtmlCommandButton COMP_UI_M_BUT_RAS_DEPT_FM) {
		this.COMP_UI_M_BUT_RAS_DEPT_FM = COMP_UI_M_BUT_RAS_DEPT_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_RAS_PROD_FM() {
		return COMP_UI_M_BUT_RAS_PROD_FM;
	}

	public void setCOMP_UI_M_BUT_RAS_PROD_FM(HtmlCommandButton COMP_UI_M_BUT_RAS_PROD_FM) {
		this.COMP_UI_M_BUT_RAS_PROD_FM = COMP_UI_M_BUT_RAS_PROD_FM;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON249() {
		return COMP_PUSH_BUTTON249;
	}

	public void setCOMP_PUSH_BUTTON249(HtmlCommandButton COMP_PUSH_BUTTON249) {
		this.COMP_PUSH_BUTTON249 = COMP_PUSH_BUTTON249;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_RAS_DIVN_TO() {
		return COMP_UI_M_BUT_RAS_DIVN_TO;
	}

	public void setCOMP_UI_M_BUT_RAS_DIVN_TO(HtmlCommandButton COMP_UI_M_BUT_RAS_DIVN_TO) {
		this.COMP_UI_M_BUT_RAS_DIVN_TO = COMP_UI_M_BUT_RAS_DIVN_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_RAS_DEPT_TO() {
		return COMP_UI_M_BUT_RAS_DEPT_TO;
	}

	public void setCOMP_UI_M_BUT_RAS_DEPT_TO(HtmlCommandButton COMP_UI_M_BUT_RAS_DEPT_TO) {
		this.COMP_UI_M_BUT_RAS_DEPT_TO = COMP_UI_M_BUT_RAS_DEPT_TO;
	}

	public PM_IL_RI_ACCOUNT_SETUP getPM_IL_RI_ACCOUNT_SETUP_BEAN() {
		return PM_IL_RI_ACCOUNT_SETUP_BEAN;
	}

	public void setPM_IL_RI_ACCOUNT_SETUP_BEAN(PM_IL_RI_ACCOUNT_SETUP PM_IL_RI_ACCOUNT_SETUP_BEAN) {
		this.PM_IL_RI_ACCOUNT_SETUP_BEAN = PM_IL_RI_ACCOUNT_SETUP_BEAN;
	}
	
	public ArrayList<SelectItem> getRenBusinessValList() {
		return renBusinessValList;
	}

	public void setRenBusinessValList(ArrayList<SelectItem> renBusinessValList) {
		this.renBusinessValList = renBusinessValList;
	}

	public ArrayList<SelectItem> getSetupTypeValList() {
		return setupTypeValList;
	}

	public void setSetupTypeValList(ArrayList<SelectItem> setupTypeValList) {
		this.setupTypeValList = setupTypeValList;
	}

	public ArrayList<SelectItem> getDivValList() {
		return divValList;
	}

	public void setDivValList(ArrayList<SelectItem> divValList) {
		this.divValList = divValList;
	}

	public ArrayList<SelectItem> getDeptValList() {
		return deptValList;
	}

	public void setDeptValList(ArrayList<SelectItem> deptValList) {
		this.deptValList = deptValList;
	}
	
	public String getMnAcctCode() {
		return mnAcctCode;
	}

	public void setMnAcctCode(String mnAcctCode) {
		this.mnAcctCode = mnAcctCode;
	}
	
	public String getSbAcctCode() {
		return sbAcctCode;
	}

	public void setSbAcctCode(String sbAcctCode) {
		this.sbAcctCode = sbAcctCode;
	}
	
	public String getDivnCode() {
		return divnCode;
	}

	public void setDivnCode(String divnCode) {
		this.divnCode = divnCode;
	}
	

	public void loadingBaseValues(PhaseEvent e) {
		if(!onLoadingFlag){
			PILM054_APAC_Helper helper = new PILM054_APAC_Helper();
			helper.preForm();
			//helper.whenNewBlockInstance();
			if(update)
				//helper.whenCreateRecord();
			helper.whenNewRecordInstance();
			onLoadingFlag = true;
		}
	}
	
	
	public List<LovBean> popDivnCodeLov(Object obj){
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		divnCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String tempUid = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GLOBAL.M_USER_ID");
		String compCode = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GLOBAL.M_COMP_CODE");
		String query = null;
		if(divnCode!= null && "*".equalsIgnoreCase(divnCode)){
			query = PILM054_APAC_SQL_CONSTANTS.divLov; 
			Object values[]={compCode, tempUid};
			tempValues = values;
		}else{
			divnCode = divnCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.divLov1; 
			Object values[]={compCode,tempUid, divnCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);
		 
		return list;*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_DIVN_FM_CODE", CommonUtils.getControlBean().getM_COMP_CODE(), null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggestionList;
	}
	
	public List<LovBean> popDeptFmToCodeLov(Object obj){
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		String deptCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String divnCode = getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DIVN_FM_CODE();
		String compCode = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GLOBAL.M_COMP_CODE");
		String userId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GLOBAL.M_USER_ID");
		String query = null;
		if(deptCode!=null && "*".equalsIgnoreCase(deptCode)){
			query = PILM054_APAC_SQL_CONSTANTS.deptLov; 
			Object values[]={compCode, divnCode, userId};
			tempValues = values;
		}else{
			deptCode = deptCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.deptLov1; 
			Object values[]={compCode, divnCode,userId, deptCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);
		return list;*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_DEPT_FM_CODE", CommonUtils.getControlBean().getM_COMP_CODE(), 
					PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_DIVN_FM_CODE(), CommonUtils.getControlBean().getM_USER_ID(), null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggestionList;
	}
	
	public List<LovBean> popDeptCodeLov(Object obj){
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		String deptCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String divnCode = getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DIVN_CODE();
		String compCode = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GLOBAL.M_COMP_CODE");
		String userId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GLOBAL.M_USER_ID");
		String query = null;
		if(deptCode!=null && "*".equalsIgnoreCase(deptCode)){
			query = PILM054_APAC_SQL_CONSTANTS.deptLov; 
			Object values[]={compCode, divnCode, userId};
			tempValues = values;
		}else{
			deptCode = deptCode+"%"; 
			System.out.println(">>>>>>>>>"+deptCode);
			query = PILM054_APAC_SQL_CONSTANTS.deptLov1; 
			Object values[]={compCode, divnCode,userId, deptCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);
		return list;*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_DEPT_CODE", CommonUtils.getControlBean().getM_COMP_CODE(), PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_DIVN_CODE(), null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	
	public List<LovBean> popProductCodeLov(Object obj){
	/*	Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		String productCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String query = null;
		if("*".equalsIgnoreCase(productCode)){
			query = PILM054_APAC_SQL_CONSTANTS.productCodeLov; 
			Object values[]={};
			tempValues = values;
		}else{
			productCode = productCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.productCodeLov1; 
			Object values[]={productCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);
		 */
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_PROD_FM_CODE", null, null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public List<LovBean> popCustCodeLov(Object event){
		suggestionList = new ArrayList<LovBean>();
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		String custCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String query = null;
		if("*".equalsIgnoreCase(custCode)){
			query = PILM054_APAC_SQL_CONSTANTS.custClassLov; 
			Object values[]={};
			tempValues = values;
		}else{
			custCode = custCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.custClassLov1; 
			Object values[]={custCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);*/
		
		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
		//	COMP_RAS_CUST_CLS_FM_CODE.setSubmittedValue(null);
			if(event!=null && event.toString().equals("*")){
				suggestQuery="SELECT CCLAS_CODE,CCLAS_CLASS_DESC FROM PM_CUST_CLASS WHERE PM_CUST_CLASS.CCLAS_FRZ_FLAG = 'N' AND ROWNUM < 20 ORDER BY 1 ASC";
			}else{
				suggestQuery="SELECT CCLAS_CODE,CCLAS_CLASS_DESC FROM PM_CUST_CLASS " +
							"WHERE PM_CUST_CLASS.CCLAS_FRZ_FLAG = 'N' AND CCLAS_CODE LIKE '%"+PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_CUST_CLS_FM_CODE() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
			}
			System.out.println(suggestQuery);
			ResultSet rsSug1 = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection());
			while(rsSug1.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(rsSug1.getString(1));
				lovBean.setName(rsSug1.getString(2));
				suggestionList.add(lovBean);
			}
			CommonUtils.closeCursor(rsSug1);
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("Product Code Suggestion", e.getMessage());
			}
			return suggestionList;
		
	}
	
	
	public List<LovBean> popMainAcctCodeLov(Object obj){
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		mnAcctCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String query = null;
		if("*".equalsIgnoreCase(mnAcctCode)){
			query = PILM054_APAC_SQL_CONSTANTS.mainAcntCodeLov; 
			Object values[]={};
			tempValues = values;
		}else{
			mnAcctCode = mnAcctCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.mainAcntCodeLov1; 
			Object values[]={mnAcctCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);
		 
		return list;*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_MAIN_ACNT_CODE", null, null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public List<LovBean> popSubAcctCodeLov(Object obj){
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		sbAcctCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String query = null;
		String mainAccntCode = getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_MAIN_ACNT_CODE();
		if("*".equalsIgnoreCase(sbAcctCode)){
			query = PILM054_APAC_SQL_CONSTANTS.subAcntCodelov; 
			Object values[]={mainAccntCode};
			tempValues = values;
		}else{
			sbAcctCode = sbAcctCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.subAcntCodelov1; 
			Object values[]={mainAccntCode,sbAcctCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);
		 
		return list;*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_SUB_ACNT_CODE", PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_MAIN_ACNT_CODE(), null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public List<LovBean> popCoverCodeLov(Object obj){
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		String coverCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String query = null;
		if("*".equalsIgnoreCase(coverCode)){
			query = PILM054_APAC_SQL_CONSTANTS.coverCodeLov; 
			Object values[]={};
			tempValues = values;
		}else{
			coverCode = coverCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.coverCodeLov1;
			Object values[]={coverCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_COVER_FM_CODE", null, null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public List<LovBean> popClassCodeLov(Object obj){
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		String classCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String query = null;
		if("*".equalsIgnoreCase(classCode)){
			query = PILM054_APAC_SQL_CONSTANTS.classCodeLov; 
			Object values[]={};
			tempValues = values;
		}else{
			classCode = classCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.classCodeLov1; 
			Object values[]={classCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);
		return list;*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_CLASS_FM_CODE", "SRC_BUS_TY", null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggestionList;
	}
	
	public List<LovBean> popSourceOfBussinessLov(Object obj){
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		String classCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String query = null;
		if("*".equalsIgnoreCase(classCode)){
			query = PILM054_APAC_SQL_CONSTANTS.srcBussRangeLov; 
			Object values[]={"SRC_BUS_TY"};
			tempValues = values;
		}else{
			classCode = classCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.srcBussRangeLov1; 
			Object values[]={"SRC_BUS_TY",classCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);
		return list;*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_SRC_BUS_FM", "SRC_BUS_TY", null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public List<LovBean> popAnaly1CodeLov(Object obj){
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		String classCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String query = null;
		if("*".equalsIgnoreCase(classCode)){
			query = PILM054_APAC_SQL_CONSTANTS.analysis1Lov; 
			Object values[]={};
			tempValues = values;
		}else{
			classCode = classCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.analysis1Lov1; 
			Object values[]={classCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);
		return list;*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_ANLY_CODE_1", "1", null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public List<LovBean> popAnaly2CodeLov(Object obj){
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		String classCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String query = null;
		if("*".equalsIgnoreCase(classCode)){
			query = PILM054_APAC_SQL_CONSTANTS.analysis2Lov; 
			Object values[]={};
			tempValues = values;
		}else{
			classCode = classCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.analysis2Lov1; 
			Object values[]={classCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);
		return list;*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_ANLY_CODE_2", "2", null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public List<LovBean> popActy1CodeLov(Object obj){
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		String classCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String query = null;
		if("*".equalsIgnoreCase(classCode)){
			query = PILM054_APAC_SQL_CONSTANTS.acty1codeLov; 
			Object values[]={getPM_IL_RI_ACCOUNT_SETUP_BEAN().getUI_M_ACTY_1()};
			tempValues = values;
		}else{
			classCode = classCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.acty1codeLov1; 
			Object values[]={getPM_IL_RI_ACCOUNT_SETUP_BEAN().getUI_M_ACTY_1(), classCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);
		return list;*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_ACTY_CODE_1", compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_ACTY_1(), null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public List<LovBean> popActy2CodeLov(Object obj){
		/*Object tempValues[];
		ArrayList<LOV_POP> list = null;
 		String classCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		String query = null;
		if("*".equalsIgnoreCase(classCode)){
			query = PILM054_APAC_SQL_CONSTANTS.acty2codeLov; 
			Object values[]={getPM_IL_RI_ACCOUNT_SETUP_BEAN().getUI_M_ACTY_2()};
			tempValues = values;
		}else{
			classCode = classCode+"%"; 
			query = PILM054_APAC_SQL_CONSTANTS.acty2codeLov1; 
			Object values[]={getPM_IL_RI_ACCOUNT_SETUP_BEAN().getUI_M_ACTY_2(), classCode};
			tempValues = values;
		}
		list = new ArrayList<LOV_POP>();
		list = dbHelper.populateLovs(query, tempValues);
		return list;*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_ACTY_CODE_2",compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_ACTY_2()
					, null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}

	public void saveForm(){
		PILM054_APAC_Helper helper = new PILM054_APAC_Helper();
		String message = null;
		try{
			if (PM_IL_RI_ACCOUNT_SETUP_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.preUpdate();
					new CRUDHandler().executeInsert(PM_IL_RI_ACCOUNT_SETUP_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();//Commit

					message = com.iii.premia.common.errorUtil.Messages.getString("messageProperties",
							"errorPanel$message$update");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("UPDATE", message);
				} else {
					message = com.iii.premia.common.errorUtil.Messages.getString("messageProperties",
							"errorPanel$message$updatenotallowed");
					getErrorMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getErrorMap().put("UPDATE", message);
				}
			} else {
				if (isINSERT_ALLOWED()) {
					helper.preInsert();
					new CRUDHandler().executeInsert(PM_IL_RI_ACCOUNT_SETUP_BEAN,
							CommonUtils.getConnection());
					
					CommonUtils.getConnection().commit();//Commit

					message = com.iii.premia.common.errorUtil.Messages.getString("messageProperties",
							"errorPanel$message$save");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("SAVE", message);
				} else {
					message = com.iii.premia.common.errorUtil.Messages.getString("messageProperties",
							"errorPanel$message$insertnotallowed");
					getErrorMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getErrorMap().put("SAVE", message);
				}
			}

		}catch (Exception e) {
			try {
				CommonUtils.getConnection().commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		
		
		
		/*try {
			DelegateDb dbHelper = new DelegateDb();
			dbHelper.saveForm(this);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}*/
	}
	
	public void RAS_DIVN_FM_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_divn_fm_code_when_validate_item(this);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_DIVN_TO_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_divn_to_code_when_validate_item(this);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_DEPT_FM_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_dept_fm_code_when_validate_item(this);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_DEPT_TO_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_dept_to_code_when_validate_item(this);
		} catch (ValidatorException e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_CLASS_FM_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_class_fm_code_when_validate_item(this);
		} catch (ValidatorException e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_CLASS_TO_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_class_to_code_when_validate_item(this);
		} catch (ValidatorException e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_SRC_BUS_FMValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_src_bus_fm_when_validate_item(this);
		} catch (ValidatorException e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_SRC_BUS_TOValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_src_bus_to_when_validate_item(this);
		} catch (ValidatorException e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_PROD_FM_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_prod_fm_code_when_validate_item(this);
		} catch (ValidatorException e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_PROD_TO_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_prod_to_code_when_validate_item(this);
		} catch (ValidatorException e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_COVER_FM_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_cover_fm_code_when_validate_item(this);
		} catch (ValidatorException e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_COVER_TO_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_cover_to_code_when_validate_item(this);
		} catch (ValidatorException e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_CUST_CLS_FM_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_cust_cls_fm_code_when_validate_item(this);
		} catch (ValidatorException e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_CUST_CLS_TO_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_cust_cls_to_code_when_validate_item(this);
		} catch (ValidatorException e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void RAS_NB_REN_TYPEValidator(FacesContext context, UIComponent component, Object value){
		helper.pilm054_apac_pm_il_ri_account_setup_ras_nb_ren_type_when_validate_item(this);
	}
	
	public void RAS_NB_REN_TYPEValidate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void RAS_FORCE_DIVN_YNValidator(FacesContext context, UIComponent component, Object value){
		getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_FORCE_DIVN_YN((String) value);
		helper.pilm054_apac_pm_il_ri_account_setup_ras_force_divn_yn_when_validate_item(this);
	}
	
	public void RAS_FORCE_DIVN_YNValidate(ActionEvent event){
		try {
			String RAS_FORCE_DIVN_YN = (String) getCOMP_RAS_FORCE_DIVN_YN().getSubmittedValue();
			getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_FORCE_DIVN_YN(RAS_FORCE_DIVN_YN);
			helper.RAS_FORCE_DIVN_YNWhenListChanged();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void RAS_FORCE_DEPT_YNValidator(FacesContext context, UIComponent component, Object value){
		getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_FORCE_DEPT_YN((String) value);
		helper.pilm054_apac_pm_il_ri_account_setup_ras_force_dept_yn_when_validate_item(this);
	}
	
	public void RAS_FORCE_DEPT_YNValidate(ActionEvent event){
		try {
			String RAS_FORCE_DEPT_YN = (String) getCOMP_RAS_FORCE_DEPT_YN().getSubmittedValue();
			getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_FORCE_DEPT_YN(RAS_FORCE_DEPT_YN);
			helper.RAS_FORCE_DEPT_YNWhenListChanged();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void RAS_MAIN_ACNT_CODEValidator(FacesContext context, UIComponent component, Object value){
		getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_MAIN_ACNT_CODE((String) value);
		helper.pilm054_apac_pm_il_ri_account_setup_ras_main_acnt_code_when_validate_item(compositeAction);
	}
	
	public void RAS_MAIN_ACNT_CODEValidate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void RAS_SUB_ACNT_CODEValidator(FacesContext context,
			UIComponent component, Object value) {
		try {
			getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_SUB_ACNT_CODE(
					(String) value);
			helper
					.pilm054_apac_pm_il_ri_account_setup_ras_sub_acnt_code_when_validate_item(this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void RAS_SUB_ACNT_CODEValidate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void RAS_DIVN_CODEValidator(FacesContext context, UIComponent component, Object value){
		getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DIVN_CODE((String) value);
		helper.pilm054_apac_pm_il_ri_account_setup_ras_divn_code_when_validate_item(this);
	}
	
	public void RAS_DIVN_CODEValidate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void RAS_DEPT_CODEValidator(FacesContext context, UIComponent component, Object value){
		getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DEPT_CODE((String) value);
		helper.pilm054_apac_pm_il_ri_account_setup_ras_dept_code_when_validate_item(this);
	}
	
	public void RAS_DEPT_CODEValidate(ActionEvent event){
		try {
			helper.pilm054_apac_pm_il_ri_account_setup_ras_dept_code_when_new_item_instance();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void RAS_ANLY_CODE_1Validator(FacesContext context, UIComponent component, Object value){
		getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ANLY_CODE_1((String) value);
		helper.pilm054_apac_pm_il_ri_account_setup_ras_anly_code_1_when_validate_item(this);
	}
	
	public void RAS_ANLY_CODE_1Validate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void RAS_ANLY_CODE_2Validator(FacesContext context, UIComponent component, Object value){
		getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ANLY_CODE_2((String) value);
		helper.pilm054_apac_pm_il_ri_account_setup_ras_anly_code_2_when_validate_item(this);
	}
	
	public void RAS_ANLY_CODE_2Validate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void RAS_ACTY_CODE_1Validator(FacesContext context, UIComponent component, Object value){
		getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ACTY_CODE_1((String) value);
		helper.pilm054_apac_pm_il_ri_account_setup_ras_acty_code_1_when_validate_item(this,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_ACTY_1());
	}
	
	public void RAS_ACTY_CODE_1Validate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void RAS_ACTY_CODE_2Validator(FacesContext context, UIComponent component, Object value){
		getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ACTY_CODE_2((String) value);
		helper.pilm054_apac_pm_il_ri_account_setup_ras_acty_code_2_when_validate_item(this,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_ACTY_2());
	}
	
	public void RAS_ACTY_CODE_2Validate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public List<LovBean> TREATY_TYPESuggestionBox(Object value){
		/*String query = "SELECT PC_CODE,PC_DESC,PC_BL_DESC " +
				"FROM PM_CODES " +
				"WHERE PC_TYPE = 'IL_TTY_TYP' " +
				"AND NVL(PC_FRZ_FLAG,'N') = 'N' " +
				"AND PC_CODE LIKE NVL(?, PC_CODE)";
		String pcCode = null;
		if(value!=null){
			if(value.equals("*")){
				pcCode = "%";
			}else{
				pcCode += "%";
			}
		}
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet rst = null;
		List<PM_IL_RI_ACCOUNT_SETUP> accountSetupList = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(query, connection, new Object[]{pcCode});
			accountSetupList = new ArrayList<PM_IL_RI_ACCOUNT_SETUP>();
			while(rst.next()){
				PM_IL_RI_ACCOUNT_SETUP accountSetupBean = new PM_IL_RI_ACCOUNT_SETUP();
				accountSetupBean.setRAS_TREATY_TYPE(rst.getString(1));
				accountSetupList.add(accountSetupBean);
			}
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
			}
		}
		return accountSetupList;*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM054_APAC", "PM_IL_RI_ACCOUNT_SETUP",
					"RAS_TREATY_TYPE", "IL_TTY_TYP", PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_CLASS_FM_CODE(), null, null, null,
					(String) value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public void RAS_TREATY_TYPEValidate(ActionEvent event){
		String treatyType = (String) getCOMP_RAS_TREATY_TYPE().getSubmittedValue();
		getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_TREATY_TYPE(treatyType);
	}

	/**
	 * @return the compositeAction
	 */
	public PILM054_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PILM054_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
}
